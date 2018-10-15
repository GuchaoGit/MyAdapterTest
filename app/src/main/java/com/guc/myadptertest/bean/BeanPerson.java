package com.guc.myadptertest.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by guc on 2018/10/15.
 * 描述：人实体类
 */
public class BeanPerson implements Parcelable {
    public static final Creator<BeanPerson> CREATOR = new Creator<BeanPerson>() {
        @Override
        public BeanPerson createFromParcel(Parcel source) {
            return new BeanPerson(source);
        }

        @Override
        public BeanPerson[] newArray(int size) {
            return new BeanPerson[size];
        }
    };
    public String name;
    public int age;


    public BeanPerson() {
    }

    protected BeanPerson(Parcel in) {
        this.name = in.readString();
        this.age = in.readInt();
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                "age='" + age + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }
}
