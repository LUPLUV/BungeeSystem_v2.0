package dev.lupluv.manager.social;

import java.util.List;
import java.util.UUID;

public class Party {

    long id;
    UUID owner;
    List<PartyMember> partyMemberList;

    public Party(long id) {
        this.id = id;
    }

    public Party(UUID owner) {
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getOwner() {
        return owner;
    }

    public void setOwner(UUID owner) {
        this.owner = owner;
    }

    public List<PartyMember> getPartyMemberList() {
        return partyMemberList;
    }

    public void setPartyMemberList(List<PartyMember> partyMemberList) {
        this.partyMemberList = partyMemberList;
    }

    public void addPartyMember(PartyMember partyMember){
        this.partyMemberList.add(partyMember);
    }

    public void addPartyMember(UUID uuid, PartyRole partyRole){
        addPartyMember(new PartyMember(uuid, partyRole));
    }

    public void removePartyMember(PartyMember partyMember){
        this.partyMemberList.remove(partyMember);
    }

    public void removePartyMember(UUID uuid){
        this.partyMemberList.forEach(m ->{
            if(uuid.toString().equalsIgnoreCase(m.getUuid().toString())){
                this.partyMemberList.remove(m);
            }
        });
    }

    public boolean existsById(){

    }
}
