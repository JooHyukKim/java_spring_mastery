package com.fastcampus.jpa.bookmanager.domain.listener;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class MyEntityListener {
    @PrePersist
    public void prePersist(Object o){
        if (o instanceof Auditable){
            System.out.println("MyEntityListener ------ prePersist");
            ((Auditable) o).setCreatedAt(LocalDateTime.now());
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }

    @PreUpdate
    public void preUpdate(Object o){
        if (o instanceof Auditable){
            System.out.println("MyEntityListener ------ preUpdate");
            ((Auditable) o).setUpdatedAt(LocalDateTime.now());
        }
    }
}
