package com.kramar.purplist.entity;

import java.util.List;
import java.util.Map;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="list")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// @RequiredArgsConstructor
public class Purplist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name="name")
    private String name;

    @Lob
    @Column(name="content")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Boolean> content;
    
}
