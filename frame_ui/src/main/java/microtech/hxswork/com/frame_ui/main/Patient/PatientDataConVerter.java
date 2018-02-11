package microtech.hxswork.com.frame_ui.main.Patient;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

import microtech.hxswork.com.frame_core.ui.OrderQianFields;
import microtech.hxswork.com.frame_core.ui.recyclew.DataConVerter;
import microtech.hxswork.com.frame_core.ui.recyclew.MultipleFields;
import microtech.hxswork.com.frame_core.ui.recyclew.MultipleItemEntity;

/**
 * Created by microtech on 2017/11/20.
 */

public final class PatientDataConVerter extends DataConVerter {
    @Override
    public ArrayList<MultipleItemEntity> CONVERT() {
        final JSONObject object = JSON.parseObject(getJsonData()).getJSONObject("obj");
        final  JSONArray array = object.getJSONArray("list");
        final  int size = array.size();
        for(int i =0 ; i < size ;i++) {
            final JSONObject data = array.getJSONObject(i);
            String name = data.getString("name");
            String sex = data.getString("sex");
            //long birthday = data.getLong("birthday");
            String thumb = "";
            if (data.getString("avatar") != null) {
                thumb = data.getString("avatar");
            }
            String statue = data.getString("effect");
            String time = data.getString("timeu");
            String bir="";
            if (data.get("birthday") != null)
            {
                final JSONObject bir_data = data.getJSONObject("birthday");
                bir = bir_data.getString("$numberLong")+"";
            }

            List<String> list_bin = new ArrayList<>();
            final JSONArray array_list_bin = data.getJSONArray("diseases");
            if(array_list_bin!=null)
            {
                for(int j= 0 ; j < array_list_bin.size() ; j ++)
                {
                    list_bin.add(array_list_bin.getString(j));
                }
            }
            /*
            * "diseases":[
                    "1",
                    "2"
                ],
            * */
            String number = data.getString("number_no");
            String id_card ="";
              if(data.getString("id_card")!=null)
              {
                  id_card=data.getString("id_card");
              }
            String address = data.getString("address");
            String bin = data.getString("marking");
            String userid = data.getString("_id");
            String region_id = data.getString("region_id");
            String gov_id = data.getString("gov_id");
            String doctor_id = data.getString("doctor_id");
            String phone = data.getString("phone");
            String age  = data.getString("age");
            String chat ="";//= data.getInteger("chat")+"";
            if(data.getInteger("chat")!=null)
            {
                chat= data.getInteger("chat")+"";
            }
            String peoples="";
                 if( data.getString("peoples")!=null)
                 {
                     peoples=data.getString("peoples");
                 }
            String accid="";
            String tokent="";
            final JSONObject im_conment = data.getJSONObject("im_account");
            if(im_conment!=null)
            {
                accid = im_conment.getString("accid");
                tokent = im_conment.getString("token");
            }

            MultipleItemEntity entity = MultipleItemEntity.builder()
                    .setItemType(PatientItemType.ITEM_PATIENT)
                    .setField(MultipleFields.NAME,name)
                    .setField(MultipleFields.SPAN_SIZE,2)
                    .setField(MultipleFields.SEX,sex)
                    .setField(MultipleFields.BIN,bin)
                    .setField(MultipleFields.BIRTHDAY,bir)
                    .setField(MultipleFields.THUMB,thumb)
                    .setField(MultipleFields.STATUE,statue)
                    .setField(MultipleFields.TIME,time)
                    .setField(MultipleFields.NUMBER,number)
                    .setField(MultipleFields.USER_ID,userid)
                    .setField(OrderQianFields.ZHU,peoples)
                    .setField(OrderQianFields.AGE,age)
                    .setField(OrderQianFields.ID_CARD,id_card)
                    .setField(OrderQianFields.REGON_ID,region_id)
                    .setField(OrderQianFields.GOV_ID,gov_id)
                    .setField(OrderQianFields.DOCTOR_ID,doctor_id)
                    .setField(OrderQianFields.PHONE,phone)
                    .setField(OrderQianFields.ADDRESS,address)
                    .setField(MultipleFields.ACCID,accid)
                    .setField(MultipleFields.TOKEN,tokent)
                    .setField(MultipleFields.CHAT,chat)
                    .setField(OrderQianFields.IMAGE_ARRAY, list_bin)
                    .build();
            ENTITYES.add(entity);
        }
        return ENTITYES;
    }
}
