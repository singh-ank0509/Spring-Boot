package com.spring.batch.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feeder_detail")
public class FeederDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "meter_sr_no", length = 50)
    private String meterSrNo;

    @Column(name = "meter_make")
    private String meterMake;

    @Column(name = "make_code", length = 10)
    private String makeCode;

    @Column(name = "modem_type", length = 100)
    private String modemType;

    @Column(name = "modem_technology", length = 50)
    private String modemTechnology;

    @Column(name = "install_point", length = 50)
    private String installPoint;

    @Column(name = "feeder_bu", length = 30)
    private String feederBu;

    @Column(name = "feeder_code", length = 30)
    private String feederCode;

    @Column(name = "feeder_name")
    private String feederName;

    @Column(name = "substation_code", length = 30)
    private String substationCode;

    @Column(name = "substation_name")
    private String substationName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMeterSrNo() {
		return meterSrNo;
	}

	public void setMeterSrNo(String meterSrNo) {
		this.meterSrNo = meterSrNo;
	}

	public String getMeterMake() {
		return meterMake;
	}

	public void setMeterMake(String meterMake) {
		this.meterMake = meterMake;
	}

	public String getMakeCode() {
		return makeCode;
	}

	public void setMakeCode(String makeCode) {
		this.makeCode = makeCode;
	}

	public String getModemType() {
		return modemType;
	}

	public void setModemType(String modemType) {
		this.modemType = modemType;
	}

	public String getModemTechnology() {
		return modemTechnology;
	}

	public void setModemTechnology(String modemTechnology) {
		this.modemTechnology = modemTechnology;
	}

	public String getInstallPoint() {
		return installPoint;
	}

	public void setInstallPoint(String installPoint) {
		this.installPoint = installPoint;
	}

	public String getFeederBu() {
		return feederBu;
	}

	public void setFeederBu(String feederBu) {
		this.feederBu = feederBu;
	}

	public String getFeederCode() {
		return feederCode;
	}

	public void setFeederCode(String feederCode) {
		this.feederCode = feederCode;
	}

	public String getFeederName() {
		return feederName;
	}

	public void setFeederName(String feederName) {
		this.feederName = feederName;
	}

	public String getSubstationCode() {
		return substationCode;
	}

	public void setSubstationCode(String substationCode) {
		this.substationCode = substationCode;
	}

	public String getSubstationName() {
		return substationName;
	}

	public void setSubstationName(String substationName) {
		this.substationName = substationName;
	}
	
	public FeederDetails() {} 
	
	public FeederDetails(Integer id, String meterSrNo, String meterMake, String makeCode, String modemType,
			String modemTechnology, String installPoint, String feederBu, String feederCode, String feederName,
			String substationCode, String substationName) {
		super();
		this.id = id;
		this.meterSrNo = meterSrNo;
		this.meterMake = meterMake;
		this.makeCode = makeCode;
		this.modemType = modemType;
		this.modemTechnology = modemTechnology;
		this.installPoint = installPoint;
		this.feederBu = feederBu;
		this.feederCode = feederCode;
		this.feederName = feederName;
		this.substationCode = substationCode;
		this.substationName = substationName;
	}

	@Override
	public String toString() {
		return "FeederDetails [id=" + id + ", meterSrNo=" + meterSrNo + ", meterMake=" + meterMake + ", makeCode="
				+ makeCode + ", modemType=" + modemType + ", modemTechnology=" + modemTechnology + ", installPoint="
				+ installPoint + ", feederBu=" + feederBu + ", feederCode=" + feederCode + ", feederName=" + feederName
				+ ", substationCode=" + substationCode + ", substationName=" + substationName + "]";
	}
}
