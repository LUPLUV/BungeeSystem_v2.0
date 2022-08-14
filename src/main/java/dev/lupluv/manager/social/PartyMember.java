package dev.lupluv.manager.social;

import java.util.UUID;

public class PartyMember {

    UUID uuid;
    PartyRole partyRole;

    public PartyMember(UUID uuid, PartyRole partyRole) {
        this.uuid = uuid;
        this.partyRole = partyRole;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public PartyRole getPartyRole() {
        return partyRole;
    }

    public void setPartyRole(PartyRole partyRole) {
        this.partyRole = partyRole;
    }
}
