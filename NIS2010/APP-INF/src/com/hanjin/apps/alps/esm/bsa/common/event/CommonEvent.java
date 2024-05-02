/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: CommonEvent.java
*@FileTitle 	: Common
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-09-28
*@LastModifier 	: Park Eun Ju
*@LastVersion 	: 1.0
* 2006-09-28 Park Eun Ju
* 1.0 최초 생성
* 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
==================================================================================================================
* History :
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
*/
package com.hanjin.apps.alps.esm.bsa.common.event;

import com.hanjin.apps.alps.esm.bsa.common.vo.ComboVO;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.controller.html.HTMLAction;

/**
 *  1. 기능 : Common 에 대한 PDTO(Data Transfer Object including Parameters)<br>
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
@SuppressWarnings("serial")
public class CommonEvent extends BSAEvent {
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
	private String crrCd = "";			// mdm carrier code
//	private boolean ifStatus = false;
	
	private ComboVO comboVO = new ComboVO();
	
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
	public void setBkg_no(String bkgNo) {
		this.bkgNo = bkgNo;
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
	public void setBkg_no_split(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
	public void setCost_yrmon(String costYrmon) {
		this.costYrmon = costYrmon;
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
	public void setLoc_cd(String locCd) {
		this.locCd = locCd;
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
	public void setOfc_cd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	public void setRlane_cd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
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
	 * @param skdDirCd
	 */
	public void setSkd_dir_cd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	/**
	 * standard direction code 반환
	 * @return
	 */
	public String skdDirCd() {
		return this.skdDirCd;
	}

	/**
	 * standard voyage number 입력
	 * @param skd_voy_no
	 */
	public void setSkd_voy_no(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
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
	public void setVsl_cd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * vessel code 반환
	 * @return
	 */
	public String getVslCd() {
		return this.vslCd;
	}

	/**
	 * 
	 * @param tbl_nm
	 */
	public void setTbl_nm(String tblNm) {
		this.tblNm = tblNm;
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
	public void setTrd_cd(String trdCd){
		this.trdCd = trdCd;
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
	public void setTmnl_cd(String tmnlCd){
		this.tmnlCd = tmnlCd;
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
	public void setSlane_cd(String slaneCd){
		this.slaneCd = slaneCd;
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
	public void setStd_cost_cd(String stdCostCd){
		this.stdCostCd = stdCostCd;
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
	 * Event 명을 반환한다.
	 */
	public String toString() {
		return "CommonEvent";
	}
	
	/**
	 * 
	 *@param crr_cd
	 */
	public String getCrr_cd() {
		return crrCd;
	}
	
	/**
	 * 
	 *@param crr_cd
	 */
	public void setCrr_cd(String crrCd) {
		this.crrCd = crrCd;
	}

	
	public ComboVO getComboVO() {
		return comboVO;
	}

	public void setComboVO(ComboVO comboVO) {
		this.comboVO = comboVO;
	}
}