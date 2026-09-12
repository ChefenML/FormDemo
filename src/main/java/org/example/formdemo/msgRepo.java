package org.example.formdemo;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class msgRepo {
    final List<MessageModel> msglist = new ArrayList<>();


    public msgRepo(){
        mockData();
    }
    public List<MessageModel> getAll(){
        return msglist;
    }

    public void save(MessageModel msg){
        msglist.add(msg);
    }

    public List<MessageModel> filterList(String filter){
        List<MessageModel> filterList = new ArrayList<>();
        for(MessageModel m : msglist){
            if(m.getName().equalsIgnoreCase(filter) || m.getMessage().equalsIgnoreCase(filter)){
                filterList.add(m);
            }
        }
        return filterList;
    }

    public void mockData(){
        msglist.add(new MessageModel("DrDouche","U all suck","Private", LocalDate.of(2025,2,2)));
        msglist.add(new MessageModel("AnotherShit","fucktards","Public", LocalDate.of(2025,5,5)));
        msglist.add(new MessageModel("DrShitPost","STFU","Network", LocalDate.of(2025,7,7)));
    }
}
