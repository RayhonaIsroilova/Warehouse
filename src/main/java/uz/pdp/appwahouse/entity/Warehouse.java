package uz.pdp.appwahouse.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.appwahouse.entity.template.AbsEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Warehouse extends AbsEntity {
}
