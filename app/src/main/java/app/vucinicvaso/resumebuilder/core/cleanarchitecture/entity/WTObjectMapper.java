package app.vucinicvaso.resumebuilder.core.cleanarchitecture.entity;

public abstract class WTObjectMapper<E, M> {

    public abstract E toEntity(M model);

    public abstract M toModel(E entity);

}
