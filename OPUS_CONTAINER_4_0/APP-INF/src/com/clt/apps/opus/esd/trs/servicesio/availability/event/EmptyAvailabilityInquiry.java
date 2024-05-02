/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : InvoiceNoticeInquiry.java
*@FileTitle : SPP TRS Invoice Inquiry List Value Object
*Open Issues :
*Change history :
* 2006-12-28 sunghwan cho : 신규 작성
* 2007-04-10 subghwan cho : parentVendorCode 추가
* 2007-05-15 subghwan cho : workOrderNo, serviceOrderNo, equipmentNo 추가 (Excel 추출을 위해 별도 Parameter로 추가)
* 2007-05-17 subghwan cho : vendorName 추가 (Excel 추출을 위해 별도 Parameter로 추가)
*@LastModifyDate : 2007-05-17
*@LastModifier : sunghwan cho
*@LastVersion : 1.3
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.availability.event;


/**
 * Value Object<br>
 * - SPP TRS Invoice Inquiry List Value Object<br>
 * 
 * @author sunghwan cho
 * @see 
 * @since J2EE 1.4
 */
public class EmptyAvailabilityInquiry {
	private String eqNo = "";
	private String eqTpszCd = "";
	private String cntrTpszIsoCd = "";
	private String isoNm = ""; 
	private String dorNodCd = "";
	private String dorNodName = "";
	private String dorLocNm = "";
	private String dorYdAddr = "";
	private String dorZipCd = "";
	private String dorFctryNm = "";
	private String dorOfcEngNm = "";
	private String dorPhnNo = "";
	private String toNodCd = "";
	private String toLocNm = "";
	private String toNodName = "";
	private String toYdAddr = "";
	private String toZipCd = "";
	private String toOfcEngNm = "";
	private String toPhnNo = "";
	private String avbSts = "";
	private String avbDt = "";
	private String firtFreeDt = "";
	private String lastFreeDt = "";
	private String copFshDt = "";
		
	public String getCop_fsh_dt() {
		return copFshDt;
	}
	public void setCop_fsh_dt(String cop_fsh_dt) {
		this.copFshDt = cop_fsh_dt;
	}
	public String getEq_no() {
		return eqNo;
	}
	public void setEq_no(String eq_no) {
		this.eqNo = eq_no;
	}
	public String getEq_tpsz_cd() {
		return eqTpszCd;
	}
	public void setEq_tpsz_cd(String eq_tpsz_cd) {
		this.eqTpszCd = eq_tpsz_cd;
	}
	public String getCntr_tpsz_iso_cd() {
		return cntrTpszIsoCd;
	}
	public void setCntr_tpsz_iso_cd(String cntr_tpsz_iso_cd) {
		this.cntrTpszIsoCd = cntr_tpsz_iso_cd;
	}
	public String getIso_nm() {
		return isoNm;
	}
	public void setIso_nm(String iso_nm) {
		this.isoNm = iso_nm;
	}
	public String getDor_nod_cd() {
		return dorNodCd;
	}
	public void setDor_nod_cd(String dor_nod_cd) {
		this.dorNodCd = dor_nod_cd;
	}
	public String getDor_nod_name() {
		return dorNodName;
	}
	public void setDor_nod_name(String dor_nod_name) {
		this.dorNodName = dor_nod_name;
	}
	public String getDor_loc_nm() {
		return dorLocNm;
	}
	public void setDor_loc_nm(String dor_loc_nm) {
		this.dorLocNm = dor_loc_nm;
	}
	public String getDor_yd_addr() {
		return dorYdAddr;
	}
	public void setDor_yd_addr(String dor_yd_addr) {
		this.dorYdAddr = dor_yd_addr;
	}
	public String getDor_zip_cd() {
		return dorZipCd;
	}
	public void setDor_zip_cd(String dor_zip_cd) {
		this.dorZipCd = dor_zip_cd;
	}
	public String getDor_fctry_nm() {
		return dorFctryNm;
	}
	public void setDor_fctry_nm(String dor_fctry_nm) {
		this.dorFctryNm = dor_fctry_nm;
	}
	public String getDor_ofc_eng_nm() {
		return dorOfcEngNm;
	}
	public void setDor_ofc_eng_nm(String dor_ofc_eng_nm) {
		this.dorOfcEngNm = dor_ofc_eng_nm;
	}
	public String getDor_phn_no() {
		return dorPhnNo;
	}
	public void setDor_phn_no(String dor_phn_no) {
		this.dorPhnNo = dor_phn_no;
	}
	public String getTo_nod_cd() {
		return toNodCd;
	}
	public void setTo_nod_cd(String to_nod_cd) {
		this.toNodCd = to_nod_cd;
	}
	public String getTo_loc_nm() {
		return toLocNm;
	}
	public void setTo_loc_nm(String to_loc_nm) {
		this.toLocNm = to_loc_nm;
	}
	public String getTo_nod_name() {
		return toNodName;
	}
	public void setTo_nod_name(String to_nod_name) {
		this.toNodName = to_nod_name;
	}
	public String getTo_yd_addr() {
		return toYdAddr;
	}
	public void setTo_yd_addr(String to_yd_addr) {
		this.toYdAddr = to_yd_addr;
	}
	public String getTo_zip_cd() {
		return toZipCd;
	}
	public void setTo_zip_cd(String to_zip_cd) {
		this.toZipCd = to_zip_cd;
	}
	public String getTo_ofc_eng_nm() {
		return toOfcEngNm;
	}
	public void setTo_ofc_eng_nm(String to_ofc_eng_nm) {
		this.toOfcEngNm = to_ofc_eng_nm;
	}
	public String getTo_phn_no() {
		return toPhnNo;
	}
	public void setTo_phn_no(String to_phn_no) {
		this.toPhnNo = to_phn_no;
	}
	public String getAvb_sts() {
		return avbSts;
	}
	public void setAvb_sts(String avb_sts) {
		this.avbSts = avb_sts;
	}
	public String getAvb_dt() {
		return avbDt;
	}
	public void setAvb_dt(String avb_dt) {
		this.avbDt = avb_dt;
	}
	public String getFirt_free_dt() {
		return firtFreeDt;
	}
	public void setFirt_free_dt(String firt_free_dt) {
		this.firtFreeDt = firt_free_dt;
	}
	public String getLast_free_dt() {
		return lastFreeDt;
	}
	public void setLast_free_dt(String last_free_dt) {
		this.lastFreeDt = last_free_dt;
	}
	
}