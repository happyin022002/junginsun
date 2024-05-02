/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : CLMInquiry.java
*@FileTitle : ServiceProvicerVisibility Web-Service
*Open Issues :
*Change history :
*@LastModifyDate : 2008-07-02
*@LastModifier : Park Yeon-Jin
*@LastVersion : 1.0
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.sce.servicesio.serviceprovidervisibility.clm.event;

/**
 * SPP-SCE PDTO(Data Transfer Object including Parameters)<br>
 * - SPP-SCE에 대한 데이터 전달하는 PDTO로 사용<br>
 *
 * @author yeon-jin park
 * @see SppSce0003EventResponse 참조
 * @since J2EE 1.4
 */
public class ClmInquiry implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String cntrNo = "";
	private String cnmvYr = "";
	private String cnmvIdNo = "";
	private String clmSeq = "";
	private String fullMty = "";
	private String eventNm = "";
	private String crrntLoc = "";
	private String crrntState = "";
	private String arrDate = "";
	private String arrTime = "";
	private String clmCrrNm = "";
	private String trspModTpCd = "";
	private String fmNodCd = "";
	private String fmSteCd = "";
	private String toNodCd = "";
	private String toSteCd = "";
	private String trnNo = "";
	private String fcarNo = "";
	
	
    /**
     * get cntr_no
     * 
     * @return String cntr_no
     */
	public String getCntr_no(){
		return cntrNo;
	}
	
    /**
     * set cntr_no
     * 
     * @param cntr_no String
     */
	public void setCntr_no(String cntr_no){
		this.cntrNo = cntr_no;
	}
	
    /**
     * get cnmv_yr
     * 
     * @return String cnmv_yr
     */
	public String getCnmv_yr(){
		return cnmvYr;
	}
	
    /**
     * set cnmv_yr
     * 
     * @param cnmv_yr String
     */
	public void setCnmv_yr(String cnmv_yr){
		this.cnmvYr = cnmv_yr;
	}

	/**
     * get cnmv_id_no
     * 
     * @return String cnmv_id_no
     */
	public String getCnmv_id_no(){
		return cnmvIdNo;
	}
	
    /**
     * set cnmv_id_no
     * 
     * @param cnmv_id_no String
     */
	public void setCnmv_id_no(String cnmv_id_no){
		this.cnmvIdNo = cnmv_id_no;
	}
	
    /**
     * get clm_seq
     * 
     * @return String clm_seq
     */
	public String getClm_seq(){
		return clmSeq;
	}
	
    /**
     * set clm_seq
     * 
     * @param clm_seq String
     */
	public void setClm_seq(String clm_seq){
		this.clmSeq = clm_seq;
	}
    /**
     * get full_mty
     * 
     * @return String full_mty
     */
	public String getfull_mty(){
		return fullMty;
	}
	
    /**
     * set full_mty
     * 
     * @param full_mty String
     */
	public void setFull_mty(String full_mty){
		this.fullMty = full_mty;
	}
    /**
     * get event_nm
     * 
     * @return String event_nm
     */
	public String getEvent_nm(){
		return eventNm;
	}
	
    /**
     * set event_nm
     * 
     * @param event_nm String
     */
	public void setEvent_nm(String event_nm){
		this.eventNm = event_nm;
	}
	
    /**
     * get crrnt_loc
     * 
     * @return String crrnt_loc
     */
	public String getCrrnt_loc(){
		return crrntLoc;
	}
	
    /**
     * set crrnt_loc
     * 
     * @param crrnt_loc String
     */
	public void setCrrnt_loc(String crrnt_loc){
		this.crrntLoc = crrnt_loc;
	}
    /**
     * get crrnt_state
     * 
     * @return String crrnt_state
     */
	public String getCrrnt_state(){
		return crrntState;
	}
	
    /**
     * set crrnt_state
     * 
     * @param crrnt_state String
     */
	public void setCrrnt_state(String crrnt_state){
		this.crrntState = crrnt_state;
	}
    /**
     * get arr_date
     * 
     * @return String arr_date
     */
	public String getArr_date(){
		return arrDate;
	}
	
    /**
     * set arr_date
     * 
     * @param arr_date String
     */
	public void setArr_date(String arr_date){
		this.arrDate = arr_date;
	}
    /**
     * get arr_time
     * 
     * @return String arr_time
     */
	public String getArr_time(){
		return arrTime;
	}
	
    /**
     * set arr_time
     * 
     * @param arr_time String
     */
	public void setArr_time(String arr_time){
		this.arrTime = arr_time;
	}
    /**
     * get clm_crr_nm
     * 
     * @return String clm_crr_nm
     */
	public String getClm_crr_nm(){
		return clmCrrNm;
	}
	
    /**
     * set clm_crr_nm
     * 
     * @param clm_crr_nm String
     */
	public void setClm_crr_nm(String clm_crr_nm){
		this.clmCrrNm = clm_crr_nm;
	}
    /**
     * get trsp_mod_tp_cd
     * 
     * @return String trsp_mod_tp_cd
     */
	public String getTrsp_mod_tp_cd(){
		return trspModTpCd;
	}
	
    /**
     * set trsp_mod_tp_cd
     * 
     * @param trsp_mod_tp_cd String
     */
	public void setTrsp_mod_tp_cd(String trsp_mod_tp_cd){
		this.trspModTpCd = trsp_mod_tp_cd;
	}
    /**
     * get fm_nod_cd
     * 
     * @return String fm_nod_cd
     */
	public String getFm_nod_cd(){
		return fmNodCd;
	}
	
    /**
     * set fm_nod_cd
     * 
     * @param fm_nod_cd String
     */
	public void setFm_nod_cd(String fm_nod_cd){
		this.fmNodCd = fm_nod_cd;
	}
    /**
     * get fm_ste_cd
     * 
     * @return String fm_ste_cd
     */
	public String getFm_ste_cd(){
		return fmSteCd;
	}
	
    /**
     * set fm_ste_cd
     * 
     * @param fm_ste_cd String
     */
	public void setFm_ste_cd(String fm_ste_cd){
		this.fmSteCd = fm_ste_cd;
	}
    /**
     * get to_nod_cd
     * 
     * @return String to_nod_cd
     */
	public String getTo_nod_cd(){
		return toNodCd;
	}
	
    /**
     * set to_nod_cd
     * 
     * @param to_nod_cd String
     */
	public void setTo_nod_cd(String to_nod_cd){
		this.toNodCd = to_nod_cd;
	}
    /**
     * get to_ste_cd
     * 
     * @return String to_ste_cd
     */
	public String getTo_ste_cd(){
		return toSteCd;
	}
	
    /**
     * set to_ste_cd
     * 
     * @param to_ste_cd String
     */
	public void setTo_ste_cd(String to_ste_cd){
		this.toSteCd = to_ste_cd;
	}
    /**
     * get trn_no
     * 
     * @return String trn_no
     */
	public String getTrn_no(){
		return trnNo;
	}
	
    /**
     * set trn_no
     * 
     * @param trn_no String
     */
	public void setTrn_no(String trn_no){
		this.trnNo = trn_no;
	}
    /**
     * get fcar_no
     * 
     * @return String fcar_no
     */
	public String getFcar_no(){
		return fcarNo;
	}
	
    /**
     * set fcar_no
     * 
     * @param String fcar_no 
     */
	public void setFcar_no(String fcar_no){
		this.fcarNo = fcar_no;
	}

	/**
	 * @return Returns the full_mty.
	 */
	public String getFull_mty() {
		return fullMty;
	}
	
}
