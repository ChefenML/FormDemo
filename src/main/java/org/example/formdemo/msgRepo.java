package org.example.formdemo;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class msgRepo {
    private final List<MessageModel> msglist = new ArrayList<>();
    private int nextId = 1;


    public msgRepo(){
        mockData();
    }
    public List<MessageModel> getAll(){
        return Collections.unmodifiableList(msglist);
    }

    public void save(MessageModel msg){
        msg.setId(nextId++);
        msglist.add(msg);
    }

    public List<MessageModel> filterList(String filter){
        List<MessageModel> filterList = new ArrayList<>();
        for(MessageModel m : msglist){
            if(m.getPrivpub().equalsIgnoreCase(filter)){
                filterList.add(m);
            }
        }
        return filterList;
    }

    public MessageModel findById(int id){
        for(MessageModel m : msglist){
            if(m.getId() == id){
                return m;
            }
        }
        return null;
    }

    public void mockData(){
        save(new MessageModel("DrDouche","U all suck","Private", LocalDate.of(2025,2,2)));
        save(new MessageModel("AnotherShit","fucktards","Public", LocalDate.of(2025,5,5)));
        save(new MessageModel("DrShitPost","STFU","Network", LocalDate.of(2025,7,7)));
    }
}
