package app.vucinicvaso.resumebuilder.data.model.account;

import app.vucinicvaso.resumebuilder.core.cleanarchitecture.entity.WTEntity;

public class AccountModel extends WTEntity<AccountModel> {

    protected AccountModel(int id, String date, String firstname, String lastname, String email, boolean selected) {
        super(id, date);
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setSelected(selected);
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

    boolean selected;
    public void setSelected(boolean v) { selected = v; }
    public boolean getSelected() { return selected; }

}
