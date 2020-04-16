package com.guc.myadptertest.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.guc.myadptertest.ICallback;
import com.guc.myadptertest.IPersonAidlInterface;
import com.guc.myadptertest.R;
import com.guc.myadptertest.adapter.AdapterPerson;
import com.guc.myadptertest.bean.BeanPerson;
import com.guc.myadptertest.service.PersonService;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guc on 2018/10/15.
 * 描述：aidl进程间通讯测试
 */
public class TestAidl extends AppCompatActivity {
    @BindView(R.id.rcv)
    RecyclerView mRcv;
    @BindView(R.id.et_name)
    EditText mEtName;
    @BindView(R.id.et_age)
    EditText mEtAge;
    @BindView(R.id.btn_add_person)
    Button mBtnAddPerson;
    @BindView(R.id.btn_get_person)
    Button mBtnGetPerson;
    private AdapterPerson mAdapter;
    private Random random = new Random();
    private BeanPerson mPerson;
    private String mName;
    private int mAge;
    private IPersonAidlInterface mPersonAidl;
    private ICallback mCallback;
    private ServiceConnection mConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mPersonAidl = IPersonAidlInterface.Stub.asInterface(service);
            try {
                mPersonAidl.registerCallback(mCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mPersonAidl = null;
        }
    };

    public static void jump(Context context) {
        Intent intent = new Intent(context, TestAidl.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_test_aidl);
        ButterKnife.bind(this);
        initView();
        //绑定服务
        Intent intent = new Intent(this, PersonService.class);
        bindService(intent, mConn, BIND_AUTO_CREATE);
    }

    @OnClick({R.id.btn_add_person, R.id.btn_get_person})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_add_person:
                if (mPersonAidl == null) return;
                getPersonParams();
                mPerson = new BeanPerson();
                mPerson.name = TextUtils.isEmpty(mName) ? "万剑归中" + random.nextInt() : mName;
                mPerson.age = mAge <= 0 ? random.nextInt() : mAge;
                try {
                    mPersonAidl.addPerson(mPerson);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.btn_get_person:
                try {
                    mAdapter.update(mPersonAidl.getPersonList());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void initView() {
        mAdapter = new AdapterPerson(this, null);
        mRcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRcv.setAdapter(mAdapter);

        mCallback = new ICallback.Stub() {
            @Override
            public void onAddPersonCallback(boolean success, String msg) throws RemoteException {
                showToast(msg);
            }

            @Override
            public void onGetPersonsCallbacck(boolean success, String msg) throws RemoteException {
                showToast(msg);
            }
        };
    }

    private void getPersonParams() {
        mName = mEtName.getText().toString().trim();
        try {
            mAge = Integer.parseInt(mEtAge.getText().toString().trim());
        } catch (NumberFormatException e) {
            mAge = 0;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConn);
    }

    private void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
