/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_921Event.java
 *@FileTitle : Rail Invoice Audit
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2007-01-10
 *@LastModifier : chkong
 *@LastVersion : 1.0
 * 2007-01-10 chkong
 * 1.0 최초 생성
 * 1.7 2010.09.09 이재위 [SRM-201008617] [TRS] More candidate 조회 조건 수정 / (2) S/P select default 값 정정 요청 CSR
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event;

import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;

/**
 * ESD_TRS_921 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_921HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kildong_hong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0921Event extends EventSupport {
	private static final long serialVersionUID = 1L;

	public EsdTrs0921Event() {
	}

	String trspSoOfcCtyCd;
	String trspSoSeq;
	String ctrlOfcCd;
	String vndrSeq;
	String basisDt;
	String wayTpCd;
	String eqKndCd;
	String eqTpSzCd;
	String cmbTpCd;
	String cgoTpCd;
	String boundCd;
	String crrModCd;
	String costmodCd;
	String custCntCd;
	String custSeq;
	String railSvcTpCd;
	String cmdtCd;
	String fromNodCd;
	String viaNodCd;
	String doorNodCd;
	String toNodCd;
	String bundleCnt;
	String wgtUom;
	String wgtQty;
	String woIssued;
	String fmVndrPrmrySeq;
	String spclCgoCntrTpCd;
	String trspAgmtOfcCtyCd;
	String trspAgmtSeq;
	String rvnMptCntr;

	String formUsrOfcCd; // 2010.09.07 추가 for ESD_TRS_0961 화면

	public String getFormUsrOfcCd() {
		return formUsrOfcCd;
	}

	public void setFormUsrOfcCd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}

	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	public String getTrspSoOfcCtyCd() {
		return trspSoOfcCtyCd;
	}

	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}

	public String getTrspSoSeq() {
		return trspSoSeq;
	}

	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}

	public String getCtrlOfcCd() {
		return ctrlOfcCd;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setBasisDt(String basisDt) {
		this.basisDt = basisDt;
	}

	public String getBasisDt() {
		return basisDt;
	}

	public void setWayTpCd(String wayTpCd) {
		this.wayTpCd = wayTpCd;
	}

	public String getWayTpCd() {
		return wayTpCd;
	}

	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}

	public String getEqKndCd() {
		return eqKndCd;
	}

	public void setEqTpSzCd(String eqTpSzCd) {
		this.eqTpSzCd = eqTpSzCd;
	}

	public String getEqTpSzCd() {
		return eqTpSzCd;
	}

	public void setCmbTpCd(String cmbTpCd) {
		this.cmbTpCd = cmbTpCd;
	}

	public String getCmbTpCd() {
		return cmbTpCd;
	}

	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}

	public String getCgoTpCd() {
		return cgoTpCd;
	}

	public void setBoundCd(String boundCd) {
		this.boundCd = boundCd;
	}

	public String getBoundCd() {
		return boundCd;
	}

	public void setCrrModCd(String crrModCd) {
		this.crrModCd = crrModCd;
	}

	public String getCrrModCd() {
		return crrModCd;
	}

	public void setCostmodCd(String costmodCd) {
		this.costmodCd = costmodCd;
	}

	public String getCostmodCd() {
		return costmodCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	public String getCustSeq() {
		return custSeq;
	}

	public void setRailSvcTpCd(String railSvcTpCd) {
		this.railSvcTpCd = railSvcTpCd;
	}

	public String getRailSvcTpCd() {
		return railSvcTpCd;
	}

	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}

	public String getCmdtCd() {
		return cmdtCd;
	}

	public void setFromNodCd(String fromNodCd) {
		this.fromNodCd = fromNodCd;
	}

	public String getFromNodCd() {
		return fromNodCd;
	}

	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}

	public String getViaNodCd() {
		return viaNodCd;
	}

	public void setDoorNodCd(String doorNodCd) {
		this.doorNodCd = doorNodCd;
	}

	public String getDoorNodCd() {
		return doorNodCd;
	}

	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}

	public String getToNodCd() {
		return toNodCd;
	}

	public void setBundleCnt(String bundleCnt) {
		this.bundleCnt = bundleCnt;
	}

	public String getBundleCnt() {
		return bundleCnt;
	}

	public void setWgtUom(String wgtUom) {
		this.wgtUom = wgtUom;
	}

	public String getWgtUom() {
		return wgtUom;
	}

	public void setWgtQty(String wgtQty) {
		this.wgtQty = wgtQty;
	}

	public String getWgtQty() {
		return wgtQty;
	}

	public String getEventName() {
		return "EsdTrs0921Event";
	}

	public String toString() {
		return "EsdTrs0921Event";
	}

	public String getWoIssued() {
		return woIssued;
	}

	public void setWoIssued(String woIssued) {
		this.woIssued = woIssued;
	}

	public String getFmVndrPrmrySeq() {
		return fmVndrPrmrySeq;
	}

	public void setFmVndrPrmrySeq(String fmVndrPrmrySeq) {
		this.fmVndrPrmrySeq = fmVndrPrmrySeq;
	}

	public String getSpclCgoCntrTpCd() {
		return spclCgoCntrTpCd;
	}

	public void setSpclCgoCntrTpCd(String spclCgoCntrTpCd) {
		this.spclCgoCntrTpCd = spclCgoCntrTpCd;
	}

	public String getTrspAgmtOfcCtyCd() {
		return trspAgmtOfcCtyCd;
	}

	public void setTrspAgmtOfcCtyCd(String trspAgmtOfcCtyCd) {
		this.trspAgmtOfcCtyCd = trspAgmtOfcCtyCd;
	}

	public String getTrspAgmtSeq() {
		return trspAgmtSeq;
	}

	public void setTrspAgmtSeq(String trspAgmtSeq) {
		this.trspAgmtSeq = trspAgmtSeq;
	}

	public String getRvnMptCntr() {
		return rvnMptCntr;
	}

	public void setRvnMptCntr(String rvnMptCntr) {
		this.rvnMptCntr = rvnMptCntr;
	}

}
