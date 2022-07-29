package be.digitalcity.introrestspring.services;

import java.util.List;

public interface CrudService<Entity, TID> {

    Entity getOne(TID id);
    List<Entity> getAll();

    Entity insert(Entity entity);

    Entity save(Entity entity);

    boolean delete(TID id);

}
