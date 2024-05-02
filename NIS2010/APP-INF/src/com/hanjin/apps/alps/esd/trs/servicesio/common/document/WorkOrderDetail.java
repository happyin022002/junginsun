/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : WorkOrderDetail.java
*@FileTitle : WorkOrderDetail 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.servicesio.common.document;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * EXP_PAP_001Response 에 대한 WebService Document Object including Parameters<br>
 * - WorkOrderIWSProxy의 Output Parameter<br>
 * - EXP_PAP_001EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class WorkOrderDetail {
	/** (Param 객체) */

	private	String frFullNm			= "";
	private	String frAddress		= "";
	private	String frTel			= "";
	private	String frFax			= "";
	private	String frPic			= "";
	private	String frCode			= "";
	private	String viaFullNm   		= "";
	private	String viaAddress     	= "";
	private	String viaTel           = "";
	private	String viaFax           = "";
	private	String viaPic           = "";
	private	String viaCode          = "";
	private	String toFullNm     	= "";
	private	String toAddress      	= "";
	private	String toTel            = "";
	private	String toFax            = "";
	private	String toPic            = "";
	private	String toCode           = "";
	private	String doorFullNm 		= "";
	private	String doorAddress  	= "";
	private	String doorTel          = "";
	private	String doorFax          = "";
	private	String doorPic          = "";
	private	String doorCode        	= "";
	private String woIssKnt			= "";
	private String znNm				= "";
	private String woVndrSeq        = "";
	private String vndrNm           = "";
	private String ediSndDt         = "";
	private String phnNo            = "";
	private String vndrEml          = "";
	private String usrEml           = "";
	
	/**
	 * @return zn_nm을 리턴합니다.
	 */
	public String getZn_nm() {
		return znNm;
	}
	/**
	 * @param zn_nm 설정하려는 zn_nm입니다.
	 */
	public void setZn_nm(String zn_nm) {
		this.znNm = zn_nm;
	}
	/**
	 * @return door_address을 리턴합니다.
	 */
	public String getDoor_address() {
		return doorAddress;
	}
	/**
	 * @param door_address 설정하려는 door_address입니다.
	 */
	public void setDoor_address(String door_address) {
		this.doorAddress = StringEscapeUtils.escapeXml(door_address);
	}
	/**
	 * @return door_code을 리턴합니다.
	 */
	public String getDoor_code() {
		return doorCode;
	}
	/**
	 * @param door_code 설정하려는 door_code입니다.
	 */
	public void setDoor_code(String door_code) {
		this.doorCode = door_code;
	}
	/**
	 * @return door_fax을 리턴합니다.
	 */
	public String getDoor_fax() {
		return doorFax;
	}
	/**
	 * @param door_fax 설정하려는 door_fax입니다.
	 */
	public void setDoor_fax(String door_fax) {
		this.doorFax = StringEscapeUtils.escapeXml(door_fax);
	}
	/**
	 * @return door_full_nm을 리턴합니다.
	 */
	public String getDoor_full_nm() {
		return doorFullNm;
	}
	/**
	 * @param door_full_nm 설정하려는 door_full_nm입니다.
	 */
	public void setDoor_full_nm(String door_full_nm) {
		this.doorFullNm = StringEscapeUtils.escapeXml(door_full_nm);
	}
	/**
	 * @return door_pic을 리턴합니다.
	 */
	public String getDoor_pic() {
		return doorPic;
	}
	/**
	 * @param door_pic 설정하려는 door_pic입니다.
	 */
	public void setDoor_pic(String door_pic) {
		this.doorPic = StringEscapeUtils.escapeXml(door_pic);
	}
	/**
	 * @return door_tel을 리턴합니다.
	 */
	public String getDoor_tel() {
		return doorTel;
	}
	/**
	 * @param door_tel 설정하려는 door_tel입니다.
	 */
	public void setDoor_tel(String door_tel) {
		this.doorTel = StringEscapeUtils.escapeXml(door_tel);
	}
	/**
	 * @return fr_address을 리턴합니다.
	 */
	public String getFr_address() {
		return frAddress;
	}
	/**
	 * @param fr_address 설정하려는 fr_address입니다.
	 */
	public void setFr_address(String fr_address) {
		this.frAddress = StringEscapeUtils.escapeXml(fr_address);
	}
	/**
	 * @return fr_code을 리턴합니다.
	 */
	public String getFr_code() {
		return frCode;
	}
	/**
	 * @param fr_code 설정하려는 fr_code입니다.
	 */
	public void setFr_code(String fr_code) {
		this.frCode = fr_code;
	}
	/**
	 * @return fr_fax을 리턴합니다.
	 */
	public String getFr_fax() {
		return frFax;
	}
	/**
	 * @param fr_fax 설정하려는 fr_fax입니다.
	 */
	public void setFr_fax(String fr_fax) {
		this.frFax = StringEscapeUtils.escapeXml(fr_fax);
	}
	/**
	 * @return fr_full_nm을 리턴합니다.
	 */
	public String getFr_full_nm() {
		return frFullNm;
	}
	/**
	 * @param fr_full_nm 설정하려는 fr_full_nm입니다.
	 */
	public void setFr_full_nm(String fr_full_nm) {
		this.frFullNm =StringEscapeUtils.escapeXml(fr_full_nm);
	}
	/**
	 * @return fr_pic을 리턴합니다.
	 */
	public String getFr_pic() {
		return frPic;
	}
	/**
	 * @param fr_pic 설정하려는 fr_pic입니다.
	 */
	public void setFr_pic(String fr_pic) {
		this.frPic = StringEscapeUtils.escapeXml(fr_pic);
	}
	/**
	 * @return fr_tel을 리턴합니다.
	 */
	public String getFr_tel() {
		return frTel;
	}
	/**
	 * @param fr_tel 설정하려는 fr_tel입니다.
	 */
	public void setFr_tel(String fr_tel) {
		this.frTel = StringEscapeUtils.escapeXml(fr_tel);
	}
	/**
	 * @return to_address을 리턴합니다.
	 */
	public String getTo_address() {
		return toAddress;
	}
	/**
	 * @param to_address 설정하려는 to_address입니다.
	 */
	public void setTo_address(String to_address) {
		this.toAddress = StringEscapeUtils.escapeXml(to_address);
	}
	/**
	 * @return to_code을 리턴합니다.
	 */
	public String getTo_code() {
		return toCode;
	}
	/**
	 * @param to_code 설정하려는 to_code입니다.
	 */
	public void setTo_code(String to_code) {
		this.toCode = to_code;
	}
	/**
	 * @return to_fax을 리턴합니다.
	 */
	public String getTo_fax() {
		return toFax;
	}
	/**
	 * @param to_fax 설정하려는 to_fax입니다.
	 */
	public void setTo_fax(String to_fax) {
		this.toFax = StringEscapeUtils.escapeXml(to_fax);
	}
	/**
	 * @return to_full_nm을 리턴합니다.
	 */
	public String getTo_full_nm() {
		return toFullNm;
	}
	/**
	 * @param to_full_nm 설정하려는 to_full_nm입니다.
	 */
	public void setTo_full_nm(String to_full_nm) {
		this.toFullNm = StringEscapeUtils.escapeXml(to_full_nm);
	}
	/**
	 * @return to_pic을 리턴합니다.
	 */
	public String getTo_pic() {
		return toPic;
	}
	/**
	 * @param to_pic 설정하려는 to_pic입니다.
	 */
	public void setTo_pic(String to_pic) {
		this.toPic = StringEscapeUtils.escapeXml(to_pic);
	}
	/**
	 * @return to_tel을 리턴합니다.
	 */
	public String getTo_tel() {
		return toTel;
	}
	/**
	 * @param to_tel 설정하려는 to_tel입니다.
	 */
	public void setTo_tel(String to_tel) {
		this.toTel = StringEscapeUtils.escapeXml(to_tel);
	}
	/**
	 * @return via_address을 리턴합니다.
	 */
	public String getVia_address() {
		return viaAddress;
	}
	/**
	 * @param via_address 설정하려는 via_address입니다.
	 */
	public void setVia_address(String via_address) {
		this.viaAddress = StringEscapeUtils.escapeXml(via_address);
	}
	/**
	 * @return via_code을 리턴합니다.
	 */
	public String getVia_code() {
		return viaCode;
	}
	/**
	 * @param via_code 설정하려는 via_code입니다.
	 */
	public void setVia_code(String via_code) {
		this.viaCode = via_code;
	}
	/**
	 * @return via_fax을 리턴합니다.
	 */
	public String getVia_fax() {
		return viaFax;
	}
	/**
	 * @param via_fax 설정하려는 via_fax입니다.
	 */
	public void setVia_fax(String via_fax) {
		this.viaFax = StringEscapeUtils.escapeXml(via_fax);
	}
	/**
	 * @return via_full_nm을 리턴합니다.
	 */
	public String getVia_full_nm() {
		return viaFullNm;
	}
	/**
	 * @param via_full_nm 설정하려는 via_full_nm입니다.
	 */
	public void setVia_full_nm(String via_full_nm) {
		this.viaFullNm = StringEscapeUtils.escapeXml(via_full_nm);
	}
	/**
	 * @return via_pic을 리턴합니다.
	 */
	public String getVia_pic() {
		return viaPic;
	}
	/**
	 * @param via_pic 설정하려는 via_pic입니다.
	 */
	public void setVia_pic(String via_pic) {
		this.viaPic = StringEscapeUtils.escapeXml(via_pic);
	}
	/**
	 * @return via_tel을 리턴합니다.
	 */
	public String getVia_tel() {
		return viaTel;
	}
	/**
	 * @param via_tel 설정하려는 via_tel입니다.
	 */
	public void setVia_tel(String via_tel) {
		this.viaTel = StringEscapeUtils.escapeXml(via_tel);
	}

	/**
	 * @return wo_iss_knt을 리턴합니다.
	 */
	public String getWo_iss_knt() {
		return woIssKnt;
	}
	/**
	 * @param wo_iss_kntl 설정하려는 wo_iss_knt입니다.
	 */
	public void setWo_iss_knt(String wo_iss_knt) {
		this.woIssKnt = wo_iss_knt;
	}

	/**
	 * @return wo_vndr_seq을 리턴합니다.
	 */
	public String getWo_vndr_seq() {
		return woVndrSeq;
	}
	/**
	 * @param wo_vndr_seql 설정하려는 wo_vndr_seq입니다.
	 */
	public void setWo_vndr_seq(String wo_vndr_seq) {
		this.woVndrSeq = wo_vndr_seq;
	}
    
	/**
	 * @return vndr_nm을 리턴합니다.
	 */
	public String getVndr_nm() {
		return vndrNm;
	}
	/**
	 * @param vndr_nml 설정하려는 vndr_nm입니다.
	 */
	public void setVndr_nm(String vndr_nm) {
		this.vndrNm = vndr_nm;
	}
	
	/**
	 * @return edi_snd_dt을 리턴합니다.
	 */
	public String getEdi_snd_dt() {
		return ediSndDt;
	}
	/**
	 * @param edi_snd_dtl 설정하려는 edi_snd_dt입니다.
	 */
	public void setEdi_snd_dt(String edi_snd_dt) {
		this.ediSndDt = edi_snd_dt;
	}
	
	/**
	 * @return phn_no을 리턴합니다.
	 */
	public String getPhn_no() {
		return phnNo;
	}
	/**
	 * @param phn_nol 설정하려는 phn_no입니다.
	 */
	public void setPhn_no(String phn_no) {
		this.phnNo = phn_no;
	}
	
	/**
	 * @return vndr_eml을 리턴합니다.
	 */
	public String getVndr_eml() {
		return vndrEml;
	}
	/**
	 * @param vndr_emll 설정하려는 vndr_eml입니다.
	 */
	public void setVndr_eml(String vndr_eml) {
		this.vndrEml = vndr_eml;
	}
	
	/**
	 * @return usr_eml을 리턴합니다.
	 */
	public String getUsr_eml() {
		return usrEml;
	}
	/**
	 * @param usr_emll 설정하려는 usr_eml입니다.
	 */
	public void setUsr_eml(String usr_eml) {
		this.usrEml = usr_eml;
	}
}
