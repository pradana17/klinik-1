/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.klinik.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dony pradana
 */
@Entity
@Table(name = "branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b")
    , @NamedQuery(name = "Branch.findByIdbranch", query = "SELECT b FROM Branch b WHERE b.idbranch = :idbranch")
    , @NamedQuery(name = "Branch.findByAlamat", query = "SELECT b FROM Branch b WHERE b.alamat = :alamat")})
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "IDBRANCH")
    private String idbranch;
    @Size(max = 10)
    @Column(name = "ALAMAT")
    private String alamat;
    @OneToMany(mappedBy = "idbranch", fetch = FetchType.LAZY)
    private List<Nutritionist> nutritionistList;
    @OneToMany(mappedBy = "idbranch", fetch = FetchType.LAZY)
    private List<Patient> patientList;

    public Branch() {
    }

    public Branch(String idbranch) {
        this.idbranch = idbranch;
    }

    public String getIdbranch() {
        return idbranch;
    }

    public void setIdbranch(String idbranch) {
        this.idbranch = idbranch;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @XmlTransient
    public List<Nutritionist> getNutritionistList() {
        return nutritionistList;
    }

    public void setNutritionistList(List<Nutritionist> nutritionistList) {
        this.nutritionistList = nutritionistList;
    }

    @XmlTransient
    public List<Patient> getPatientList() {
        return patientList;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idbranch != null ? idbranch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.idbranch == null && other.idbranch != null) || (this.idbranch != null && !this.idbranch.equals(other.idbranch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "klinik.Branch[ idbranch=" + idbranch + " ]";
    }
    
}
