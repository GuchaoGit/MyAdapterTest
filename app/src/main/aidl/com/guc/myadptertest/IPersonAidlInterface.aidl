package com.guc.myadptertest;
import com.guc.myadptertest.bean.BeanPerson;
import java.util.List;
import com.guc.myadptertest.ICallback;
interface IPersonAidlInterface {

       void registerCallback(ICallback callback);

       void addPerson(in BeanPerson person);

       List<BeanPerson> getPersonList();

}
