/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AvailabilityList.java
*@FileTitle : AvailabilityList 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-12-20
*@LastModifier : doomi
*@LastVersion : 1.0
* 2006-12-20 doomi
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.common.document;

/**
 * EXP_PAP_004Response 에 대한 WebService Document Object including Parameters<br>
 * - AvailabilityIWSProxy의 Output Parameter<br>
 * - EXP_PAP_004EventResponse에서 변환하여 사용<br>
 *
 * @author doomi
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class AvailabilityList {
	/** (Param 객체) */

	private int seq = 0;
	private	String eqNo						= "";	//Container Number                                         
	private	String eqTpszCd				= "";	//Type/Size                                                   
	private	String eqTpszNm				= "";	//Type/Size                                                   
	private	String isoCd					= "";	//ISO : EQ의 Type/Size의 ISO Code                 
	private	String isoNm					= "";	//ISO : EQ의 Type/Size의 ISO Code                 
	private	String availCd					= "";	//Availability                                                   
	private	String availNm					= "";	//Availability                                                   
	private	String cntrWgt					= "";	//Weight                                                        
	private	String freightCollectFlg		= "";	//F : Freight Collect 여부                                  
	private	String originalBlFlg			= "";	//O : Original B/L 회수 여부                             
	private	String customsFlg				= "";	//C : 세관통관여부                                          
	private	String etaRailDestDt			= "";	//ETA at Rail Destination                                  
	private	String cntrPkupNo				= "";	//Pickup Number                                             
	private	String avalDt						= "";	//Available Date                                              
	private	String lstFreeDt					= "";	//Last Free Date                                             
	private	String trspWoNo				= "";	//Work Order No                                             
	private	String blNo						= "";	//Bill of Lading No   
	private String bkgNo					= "";
	private String copNo					= "";
	private String woFmtTpCd				= "";

	// 에러 방지를 위해 임시로 추가
	private String woIssKnt				= "";  
	private String bkgNoSplit				= "";

    /**
	 * @return avail_cd을 리턴합니다.
	 */
	public String getAvail_cd() {
		return availCd;
	}
	/**
	 * @param avail_cd 설정하려는 avail_cd입니다.
	 */
	public void setAvail_cd(String avail_cd) {
		this.availCd = avail_cd;
	}
	/**
	 * @return avail_nm을 리턴합니다.
	 */
	public String getAvail_nm() {
		return availNm;
	}
	/**
	 * @param avail_nm 설정하려는 avail_nm입니다.
	 */
	public void setAvail_nm(String avail_nm) {
		this.availNm = avail_nm;
	}
	/**
	 * @return aval_dt을 리턴합니다.
	 */
	public String getAval_dt() {
		return avalDt;
	}
	/**
	 * @param aval_dt 설정하려는 aval_dt입니다.
	 */
	public void setAval_dt(String aval_dt) {
		this.avalDt = aval_dt;
	}
	/**
	 * @return bl_no을 리턴합니다.
	 */
	public String getBl_no() {
		return blNo;
	}
	/**
	 * @param bl_no 설정하려는 bl_no입니다.
	 */
	public void setBl_no(String bl_no) {
		this.blNo = bl_no;
	}
	/**
	 * @return cntr_pkup_no을 리턴합니다.
	 */
	public String getCntr_pkup_no() {
		return cntrPkupNo;
	}
	/**
	 * @param cntr_pkup_no 설정하려는 cntr_pkup_no입니다.
	 */
	public void setCntr_pkup_no(String cntr_pkup_no) {
		this.cntrPkupNo = cntr_pkup_no;
	}
	/**
	 * @return cntr_wgt을 리턴합니다.
	 */
	public String getCntr_wgt() {
		return cntrWgt;
	}
	/**
	 * @param cntr_wgt 설정하려는 cntr_wgt입니다.
	 */
	public void setCntr_wgt(String cntr_wgt) {
		this.cntrWgt = cntr_wgt;
	}
	/**
	 * @return customs_flg을 리턴합니다.
	 */
	public String getCustoms_flg() {
		return customsFlg;
	}
	/**
	 * @param customs_flg 설정하려는 customs_flg입니다.
	 */
	public void setCustoms_flg(String customs_flg) {
		this.customsFlg = customs_flg;
	}
	/**
	 * @return eq_no을 리턴합니다.
	 */
	public String getEq_no() {
		return eqNo;
	}
	/**
	 * @param eq_no 설정하려는 eq_no입니다.
	 */
	public void setEq_no(String eq_no) {
		this.eqNo = eq_no;
	}
	/**
	 * @return eq_tpsz_cd을 리턴합니다.
	 */
	public String getEq_tpsz_cd() {
		return eqTpszCd;
	}
	/**
	 * @param eq_tpsz_cd 설정하려는 eq_tpsz_cd입니다.
	 */
	public void setEq_tpsz_cd(String eq_tpsz_cd) {
		this.eqTpszCd = eq_tpsz_cd;
	}
	/**
	 * @return eq_tpsz_nm을 리턴합니다.
	 */
	public String getEq_tpsz_nm() {
		return eqTpszNm;
	}
	/**
	 * @param eq_tpsz_nm 설정하려는 eq_tpsz_nm입니다.
	 */
	public void setEq_tpsz_nm(String eq_tpsz_nm) {
		this.eqTpszNm = eq_tpsz_nm;
	}
	/**
	 * @return eta_rail_dest_dt을 리턴합니다.
	 */
	public String getEta_rail_dest_dt() {
		return etaRailDestDt;
	}
	/**
	 * @param eta_rail_dest_dt 설정하려는 eta_rail_dest_dt입니다.
	 */
	public void setEta_rail_dest_dt(String eta_rail_dest_dt) {
		this.etaRailDestDt = eta_rail_dest_dt;
	}
	/**
	 * @return freight_collect_flg을 리턴합니다.
	 */
	public String getFreight_collect_flg() {
		return freightCollectFlg;
	}
	/**
	 * @param freight_collect_flg 설정하려는 freight_collect_flg입니다.
	 */
	public void setFreight_collect_flg(String freight_collect_flg) {
		this.freightCollectFlg = freight_collect_flg;
	}
	/**
	 * @return iso_cd을 리턴합니다.
	 */
	public String getIso_cd() {
		return isoCd;
	}
	/**
	 * @param iso_cd 설정하려는 iso_cd입니다.
	 */
	public void setIso_cd(String iso_cd) {
		this.isoCd = iso_cd;
	}
	/**
	 * @return iso_nm을 리턴합니다.
	 */
	public String getIso_nm() {
		return isoNm;
	}
	/**
	 * @param iso_nm 설정하려는 iso_nm입니다.
	 */
	public void setIso_nm(String iso_nm) {
		this.isoNm = iso_nm;
	}
	/**
	 * @return lst_free_dt을 리턴합니다.
	 */
	public String getLst_free_dt() {
		return lstFreeDt;
	}
	/**
	 * @param lst_free_dt 설정하려는 lst_free_dt입니다.
	 */
	public void setLst_free_dt(String lst_free_dt) {
		this.lstFreeDt = lst_free_dt;
	}
	/**
	 * @return original_bl_flg을 리턴합니다.
	 */
	public String getOriginal_bl_flg() {
		return originalBlFlg;
	}
	/**
	 * @param original_bl_flg 설정하려는 original_bl_flg입니다.
	 */
	public void setOriginal_bl_flg(String original_bl_flg) {
		this.originalBlFlg = original_bl_flg;
	}
	/**
	 * @return seq을 리턴합니다.
	 */
	public int getSeq() {
		return seq;
	}
	/**
	 * @param seq 설정하려는 seq입니다.
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}
	/**
	 * @return trsp_wo_no을 리턴합니다.
	 */
	public String getTrsp_wo_no() {
		return trspWoNo;
	}
	/**
	 * @param trsp_wo_no 설정하려는 trsp_wo_no입니다.
	 */
	public void setTrsp_wo_no(String trsp_wo_no) {
		this.trspWoNo = trsp_wo_no;
	}

	public String getBkg_no(){
		return bkgNo;
		
	}
	
	public void setBkg_no(String bkg_no){
		this.bkgNo = bkg_no;
	}
    
	public String getCop_no(){
		return copNo;
	}
	
	public void setCop_no(String cop_no){
		this.copNo = cop_no;
	}
	
	public String getWoFmtTpCd() {
		return woFmtTpCd;
	}
	
	public void setWoFmtTpCd(String woFmtTpCd) {
		this.woFmtTpCd = woFmtTpCd;
	}
	
	public String getWo_iss_knt() {
		return woIssKnt;
	}
	
	public void setWo_iss_knt(String wo_iss_knt) {
		this.woIssKnt = wo_iss_knt;
	}
	
	public String getBkg_no_split() {
		return bkgNoSplit;
	}
	
	public void setBkg_no_split(String bkg_no_split) {
		this.bkgNoSplit = bkg_no_split;
	}
	
	
	
}
