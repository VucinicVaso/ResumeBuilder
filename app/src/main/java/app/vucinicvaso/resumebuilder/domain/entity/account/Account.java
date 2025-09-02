package app.vucinicvaso.resumebuilder.domain.entity.account;

import app.vucinicvaso.resumebuilder.core.cleanarchitecture.entity.WTEntity;

public class Account extends WTEntity<Account> {

    public Account(int id, String date, String firstname, String lastname, String email) {
        super(id, date);
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
    }

    protected String firstname;
    public void setFirstname(String v) { firstname = v; }
    public String getFirstname() { return firstname; }

    protected String lastname;
    public void setLastname(String v) { lastname = v; }
    public String getLastname() { return lastname; }

    protected String email;
    public void setEmail(String v) { email = v; }
    public String getEmail() { return email; }

}
