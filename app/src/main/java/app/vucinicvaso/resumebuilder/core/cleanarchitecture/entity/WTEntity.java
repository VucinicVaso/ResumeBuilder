package app.vucinicvaso.resumebuilder.core.cleanarchitecture.entity;

public abstract class WTEntity<T> {

    protected WTEntity(int id, String date) {
        setId(id);
        setDate(date);
    }

    protected int id;
    public void setId(int v) { id = v; }
    public int getId() { return id; }

    protected String date;
    public void setDate(String v) { date = v; }
    public String getDate() { return date; }

}
