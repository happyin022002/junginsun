/*=========================================================
 *@FileName : ESD_TRS_0231Event.java
 *@FileTitle : Agreement Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-05-11
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
 * 
 * 1.1 2011.05.11 민정호 [CHM-201110223] USER 에 의한 AGMT HISTORY 관리를 위한 기능 추가요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_0231 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0231HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author jong hyek choi
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0231Event extends EventSupport {
	String searchFmLoc    = null;
	String searchFmYard   = null;
	String searchViaLoc   = null;
	String searchViaYard  = null;
	String searchDoorLoc  = null;
	String searchDoorYard = null;
	String searchToLoc    = null;
	String searchToYard   = null;
	String costmode         = null;
	String cargo            = null;
	String eqtype           = null;
	String eqtpsz           = null;
	
	String fmAgmtTrspTpCd   = null;
	String fmEffectiveAgmt  = null;
	String fmVndrPrmrySeq   = null;
	String curPageCnt       = null;
	String pageSize         = null;
	
	String fmAgmtno 		= null;
	String effectiveDate	= null;
	String curPageCnt2		= null;
	String pageSize2		= null;
	String deleteYn		    = null;
	String approvalDate     = null;

	public String getSearch_fm_loc() {
		return searchFmLoc;
	}

	public void setSearch_fm_loc(String searchFmLoc) {
		this.searchFmLoc = searchFmLoc;
	}

	public String getSearch_fm_yard() {
		return searchFmYard;
	}

	public void setSearch_fm_yard(String searchFmYard) {
		this.searchFmYard = searchFmYard;
	}

	public String getSearch_via_loc() {
		return searchViaLoc;
	}

	public void setSearch_via_loc(String searchViaLoc) {
		this.searchViaLoc = searchViaLoc;
	}

	public String getSearch_via_yard() {
		return searchViaYard;
	}

	public void setSearch_via_yard(String searchViaYard) {
		this.searchViaYard = searchViaYard;
	}

	public String getSearch_door_loc() {
		return searchDoorLoc;
	}

	public void setSearch_door_loc(String searchDoorLoc) {
		this.searchDoorLoc = searchDoorLoc;
	}

	public String getSearch_door_yard() {
		return searchDoorYard;
	}

	public void setSearch_door_yard(String searchDoorYard) {
		this.searchDoorYard = searchDoorYard;
	}

	public String getSearch_to_loc() {
		return searchToLoc;
	}

	public void setSearch_to_loc(String searchToLoc) {
		this.searchToLoc = searchToLoc;
	}

	public String getSearch_to_yard() {
		return searchToYard;
	}

	public void setSearch_to_yard(String searchToYard) {
		this.searchToYard = searchToYard;
	}

	public String getCostmode() {
		return costmode;
	}

	public void setCostmode(String costmode) {
		this.costmode = costmode;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEqtype() {
		return eqtype;
	}

	public void setEqtype(String eqtype) {
		this.eqtype = eqtype;
	}

	public String getEqtpsz() {
		return eqtpsz;
	}

	public void setEqtpsz(String eqtpsz) {
		this.eqtpsz = eqtpsz;
	}

	public String getFmAgmtTrspTpCd() {
		return fmAgmtTrspTpCd;
	}

	public void setFmAgmtTrspTpCd(String fmAgmtTrspTpCd) {
		this.fmAgmtTrspTpCd = fmAgmtTrspTpCd;
	}

	public String getFmEffectiveAgmt() {
		return fmEffectiveAgmt;
	}

	public void setFmEffectiveAgmt(String fmEffectiveAgmt) {
		this.fmEffectiveAgmt = fmEffectiveAgmt;
	}

	public String getFmVndrPrmrySeq() {
		return fmVndrPrmrySeq;
	}

	public void setFmVndrPrmrySeq(String fmVndrPrmrySeq) {
		this.fmVndrPrmrySeq = fmVndrPrmrySeq;
	}

	public String getCurPageCnt() {
		return curPageCnt;
	}

	public void setCurPageCnt(String curPageCnt) {
		this.curPageCnt = curPageCnt;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getFmAgmtno(){
		return fmAgmtno;
	}
	
	public void setFmAgmtno(String fmAgmtno) {
		this.fmAgmtno = fmAgmtno;
	}
	
	public String getEffectiveDate(){
		return effectiveDate;
	}
	
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}	
			
	public String getCurPageCnt2() {
		return curPageCnt2;
	}

	public void setCurPageCnt2(String curPageCnt2) {
		this.curPageCnt2 = curPageCnt2;
	}

	public String getPageSize2() {
		return pageSize2;
	}

	public void setPageSize2(String pageSize2) {
		this.pageSize2 = pageSize2;
	}
	
	public String getDeleteYn() {
		return deleteYn;
	}

	public void setDeleteYn(String deleteYn) {
		this.deleteYn = deleteYn;
	}
	
	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}
}
