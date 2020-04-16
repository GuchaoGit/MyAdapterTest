package com.guc.myadptertest.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.guc.myadptertest.ICallback;
import com.guc.myadptertest.IPersonAidlInterface;
import com.guc.myadptertest.bean.BeanPerson;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guc on 2018/10/15.
 * 描述：aidl服务端代码
 */
public class PersonService extends Service {
    private final String TAG = this.getClass().getSimpleName();

    private List<BeanPerson> mPersons;
    private IBinder mIBinder;
    private ICallback mCallback;

    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 创建生成的本地 Binder 对象，实现 AIDL 制定的方法
         */
        mIBinder = new IPersonAidlInterface.Stub() {

            @Override
            public void registerCallback(ICallback callback) throws RemoteException {
                mCallback = callback;
            }

            @Override
            public void addPerson(BeanPerson person) throws RemoteException {
                if (mPersons == null) {
                    mPersons = new ArrayList<>();
                }
                mPersons.add(person);
                if (mCallback != null) {
                    mCallback.onAddPersonCallback(true, "添加成功，请重新获取");
                }
            }

            @Override
            public List<BeanPerson> getPersonList() throws RemoteException {
                if (mCallback != null) {
                    mCallback.onAddPersonCallback(true, "恭喜你，获取成功");
                }
                return mPersons;
            }
        };
    }

    /**
     * 客户端与服务端绑定时的回调，返回 mIBinder 后客户端就可以通过它远程调用服务端的方法，即实现了通讯
     *
     * @param intent
     * @return
     */
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }
}
