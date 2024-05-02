/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: MASCommonEvent.java
*@FileTitle 	: MASCommon
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-09-28
*@LastModifier 	: Park Eun Ju
*@LastVersion 	: 1.0
* 2006-09-28 Park Eun Ju
* 1.0 최초 생성
* 2013.12.13 김수정 [CHM-201328111] [MAS] EMU COST 변경 로직 Pre CM 반영 요청 - DEL Code, DEL Term 에 따른 MT Return CY 조회 추가
=========================================================*/
package com.hanjin.apps.alps.esm.mas.common.event;

import com.hanjin.apps.alps.esm.mas.common.vo.SearchConditionVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 *  1. 기능 : MASCommon 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 *  2. 처리개요 : <p>
 *    - ServiceCommand Layer로 전달하는 PDTO로 사용 <p>
 * 3. 주의사항 : <p>
 * ===================================<br>
 * 4. 작성자/작성일 : Park Eun Ju/2006.09.18<br>
 * ===================================<br>
 * 5. 수정사항<p>
 * 5.1 요구사항 ID :<p>
 * - 수정자/수정일 :<p>
 * - 수정사유/내역 :<p>
 * ===================================<br>
 * <p/>
 *
 * @author Park Eun Ju
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class CommonEvent extends MASEvent {
	private static final long serialVersionUID = 1L;
	
	private DBRowSet rowSet;
	private String year = "";
	private String month = "";
	private String week = "";
	private String frmMonth = "";
	private String toMonth = "";
	private String frmWeek = "";
	private String toWeek = "";
//	private String datePeriod = "";
	
	private String trdCd = "";
	
	private String bkgNo = "";
	private String bkgNoSplit = "";
	private String locCd = "";
	private String vslCd = "";
	private String skdVoyNo = "";
	private String skdDirCd = "";
	private String ofcCd = "";
	private String rlaneCd = "";
	
	private String stdCostCd = "";
	
	private String costYrmon = "";
	private String tblNm 	= "";
	private String tmnlCd 	= "";		// terminal/port code
	private String slaneCd = "";		// Service Lane code
//	private boolean ifStatus = false;
	private SearchConditionVO searchConditionVO = null;
	
	/**
	 * CommonEvent 생성자 함수 
	 */
	public CommonEvent(){
		//
	}
	
	/**
	 * 
	 * @param rowSet
	 */
	public CommonEvent(DBRowSet rowSet){
		this.rowSet = rowSet;
	}
	
	/**
	 * rowSet을 반환
	 * @return
	 */
	public DBRowSet getRs(){
		return rowSet;
	}
	
	/**
	 * year를 입력
	 * @param year
	 */
	public void setYear(String year){
		this.year = year;
	}
	
	/**
	 * Year을 반환 
	 * @return
	 */
	public String getYear(){
		return this.year;
	}
	
	/**
	 * Month를 입력
	 * @param month
	 */
	public void setMonth(String month){
		this.month = month;
	}
	
	/**
	 * Month를 반환
	 * @return
	 */
	public String getMonth(){
		return this.month;
	}
	
	/**
	 * Week를 입력
	 * @param week
	 */
	public void setWeek(String week){
		this.week= week;
	}
	
	/**
	 * Week를 반환
	 * @return
	 */
	public String getWeek(){
		return this.week;
	}
	
	/**
	 * from Month를 입력
	 * @param fmMonth
	 */
	public void setFrmMonth(String fmMonth){
		this.frmMonth = fmMonth;
	}
	
	/**
	 * from Month를 반환
	 * @return
	 */
	public String getFrmMonth(){
		return this.frmMonth;
	}
	
	/**
	 * to Month를 입력
	 * @param toMonth
	 */
	public void setToMonth(String toMonth){
		this.toMonth = toMonth;
	}
	
	/**
	 * to Month를 반환
	 * @return
	 */
	public String getToMonth(){
		return this.toMonth;
	}
	
	/**
	 * from Week를 입력
	 * @param fmWeek
	 */
	public void setFrmWeek(String fmWeek){
		this.frmWeek = fmWeek;
	}
	
	/**
	 * from Week를 반환
	 * @return
	 */
	public String getFrmWeek(){
		return this.frmWeek;
	}
	
	/**
	 * to Week를 입력
	 * @param toWeek
	 */
	public void setToWeek(String toWeek){
		this.toWeek = toWeek;
	}
	
	/**
	 * to Week를 반환
	 * @return
	 */
	public String getToWeek(){
		return this.toWeek;
	}
	
	/**
	 * booking number를 입력
	 * @param bkg_no
	 */
	public void setBkg_no(String bkg_no) {
		this.bkgNo = bkg_no;
	}

	/**
	 * booking number를 반환
	 * @return
	 */
	public String getBkg_no() {
		return this.bkgNo;
	}

	/**
	 * 
	 * @param bkg_no_split
	 */
	public void setBkg_no_split(String bkg_no_split) {
		this.bkgNoSplit = bkg_no_split;
	}

	/**
	 * 
	 * @return
	 */
	public String getBkg_no_split() {
		return this.bkgNoSplit;
	}

	/**
	 * 
	 * @param cost_yrmon
	 */
	public void setCost_yrmon(String cost_yrmon) {
		this.costYrmon = cost_yrmon;
	}

	/**
	 * 
	 * @return
	 */
	public String getCost_yrmon() {
		return this.costYrmon;
	}
	
	/**
	 * location code 입력
	 * @param loc_cd
	 */
	public void setLoc_cd(String loc_cd) {
		this.locCd = loc_cd;
	}

	/**
	 * location code 반환
	 * @return
	 */
	public String getLoc_cd() {
		return this.locCd;
	}

	/**
	 * office code 입력
	 * @param ofc_cd
	 */
	public void setOfc_cd(String ofc_cd) {
		this.ofcCd = ofc_cd;
	}

	/**
	 * office code 반환
	 * @return
	 */
	public String getOfc_cd() {
		return this.ofcCd;
	}

	/**
	 * revenue lane code 입ㄺ
	 * @param rlane_cd
	 */
	public void setRlane_cd(String rlane_cd) {
		this.rlaneCd = rlane_cd;
	}

	/**
	 * revenue lane code 반환
	 * @return
	 */
	public String getRlane_cd() {
		return this.rlaneCd;
	}

	/**
	 * standard direction code 입력
	 * @param skd_dir_cd
	 */
	public void setSkd_dir_cd(String skd_dir_cd) {
		this.skdDirCd = skd_dir_cd;
	}

	/**
	 * standard direction code 반환
	 * @return
	 */
	public String getSkd_dir_cd() {
		return this.skdDirCd;
	}

	/**
	 * standard voyage number 입력
	 * @param skd_voy_no
	 */
	public void setSkd_voy_no(String skd_voy_no) {
		this.skdVoyNo = skd_voy_no;
	}

	/**
	 * stardard voyage number 반환
	 * @return
	 */
	public String getSkd_voy_no() {
		return this.skdVoyNo;
	}

	/**
	 * vessel code 입력
	 * @param vsl_cd
	 */
	public void setVsl_cd(String vsl_cd) {
		this.vslCd = vsl_cd;
	}

	/**
	 * vessel code 반환
	 * @return
	 */
	public String getVsl_cd() {
		return this.vslCd;
	}

	/**
	 * 
	 * @param tbl_nm
	 */
	public void setTbl_nm(String tbl_nm) {
		this.tblNm = tbl_nm;
	}

	/**
	 * 
	 * @return
	 */
	public String getTbl_nm() {
		return this.tblNm;
	}

	/**
	 * Trade code를 입력
	 * @param trd_cd
	 */
	public void setTrd_cd(String trd_cd){
		this.trdCd = trd_cd;
	}
	
	/**
	 * Trade code를 반환
	 * @return
	 */
	public String getTrd_cd(){
		return this.trdCd;
	}

	/**
	 * port or node code 입력
	 * @param tmnl_cd
	 */
	public void setTmnl_cd(String tmnl_cd){
		this.tmnlCd = tmnl_cd;
	}

	/**
	 * port or node code 반환
	 * @return
	 */
	public String getTmnl_cd(){
		return this.tmnlCd;
	}
	
	/**
	 * service lane code 입력
	 * @param slane_cd
	 */
	public void setSlane_cd(String slane_cd){
		this.slaneCd = slane_cd;
	}
	
	/**
	 * service lane code 반환
	 * @return
	 */
	public String getSlane_cd(){
		return this.slaneCd;
	}
	
	/**
	 * 
	 *@param std_cost_cd
	 */
	public void setStd_cost_cd(String std_cost_cd){
		this.stdCostCd = std_cost_cd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getStd_cost_cd(){
		return this.stdCostCd;
	}
	/**
	 *  Event 명을 반환한다.
	 */
	public String getEventName() {
		return "CommonEvent";
	}

	/**
	 * SearchConditionVO 입력
	 * @param vo
	 */
	public void setSearchConditionVO(SearchConditionVO vo){
		this. searchConditionVO = vo;
	}
	
	/**
	 * SearchConditionVO 반환
	 * @return
	 */
	public SearchConditionVO getSearchConditionVO(){
		return searchConditionVO;
	}
	
}