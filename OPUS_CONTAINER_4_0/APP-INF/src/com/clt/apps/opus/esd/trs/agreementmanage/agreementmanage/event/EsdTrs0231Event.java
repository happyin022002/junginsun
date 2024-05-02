/*=========================================================
 *@FileName : ESD_TRS_0231Event.java
 *@FileTitle : Agreement Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-03-26
 *@LastModifier : jong hyek choi
 *@LastVersion : 1.0
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

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

	private static final long serialVersionUID = 1L;
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
	
}
