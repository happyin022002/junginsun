/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpotBiddingSpUsrInfo.java
*@FileTitle : SpotBidding Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2015-06-22
*@LastModifier : SHIN DONG IL
*@LastVersion : 1.0
* 2015-06-22 SHIN DONG IL
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.spotbiddingmange.event;
/**
* ESD-TRS Business Logic ServiceCommand<br>
* - ESD-TRS 에 대한 비지니스 트랜잭션을 처리한다.<br>
* 
* @author SHIN DONG IL
* @see EventResponse,SpotBiddingManageDBDAO 참조
* @since J2EE 1.6
*/
public class SpotBiddingSpUsrInfo {
	
	private String vndr_seq = "";
	private String usr_id = "";
	private String vndr_ofc_cd = "";
	private String usr_eml = "";
	private String use_flg = "";
	private String cre_usr_id = "";
	private String cre_ofc_cd = "";
	
	public String getCre_ofc_cd() {
		return cre_ofc_cd;
	}
	public void setCre_ofc_cd(String cre_ofc_cd) {
		this.cre_ofc_cd = cre_ofc_cd;
	}
	public String getVndr_seq() {
		return vndr_seq;
	}
	public String getCre_usr_id() {
		return cre_usr_id;
	}
	public void setCre_usr_id(String cre_usr_id) {
		this.cre_usr_id = cre_usr_id;
	}
	public void setVndr_seq(String vndr_seq) {
		this.vndr_seq = vndr_seq;
	}
	public String getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(String usr_id) {
		this.usr_id = usr_id;
	}

	public String getVndr_ofc_cd() {
		return vndr_ofc_cd;
	}
	public void setVndr_ofc_cd(String vndr_ofc_cd) {
		this.vndr_ofc_cd = vndr_ofc_cd;
	}

	public String getUsr_eml() {
		return usr_eml;
	}
	public void setUsr_eml(String usr_eml) {
		this.usr_eml = usr_eml;
	}
	public String getUse_flg() {
		return use_flg;
	}
	public void setUse_flg(String use_flg) {
		this.use_flg = use_flg;
	}
}
