package org.example.formdemo;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class msgRepo {
    final List<messageModel> msglist = new ArrayList<>();

    public List<messageModel> getAll(){
        return msglist;
    }

    public void save(messageModel msg){
        msglist.add(msg);
    }

    public List<messageModel> filterList(String filter){
        List<messageModel> filterList = new ArrayList<>();
        for(messageModel m : msglist){
            if(m.getName().equalsIgnoreCase(filter) || m.getMessage().equalsIgnoreCase(filter)){
                filterList.add(m);
            }
        }
        return filterList;
    }
}
