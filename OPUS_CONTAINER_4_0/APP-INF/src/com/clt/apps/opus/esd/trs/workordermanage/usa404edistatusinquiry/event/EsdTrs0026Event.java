/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESD_TRS_0026Event.java
 *@FileTitle : Add Additional Cost for USA/CA Rail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015-06-30
 *@LastModifier : SWKIM
 *@LastVersion : 1.0
 * 2015-06-30 SWKIM
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event;

import java.util.Arrays;

import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.TrsTrspRailBilVndrSetVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;

/**
 * ESD_TRS_0026 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_0026HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author Kildong_hong
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0026Event extends EventSupport {
	private static final long serialVersionUID = 1L;
	
	public EsdTrs0026Event() {
	}

	String trspSoOfcCtyCd; //OK
	String trspSoSeq; //OK
	String ctrlOfcCd;
	String vndrSeq; //OK
	String basisDt; //OK
	String wayTpCd;
	String eqKndCd;
	String eqTpSzCd; //OK
	String cmbTpCd;
	String cgoTpCd; //OK
	String boundCd; //OK
	String crrModCd;
	String costmodCd;
	String custCntCd;
	String custSeq;
	String railSvcTpCd;
	String cmdtCd;
	String fromNodCd; //OK
	String viaNodCd;
	String doorNodCd;
	String toNodCd; //OK
	String bundleCnt;
	String wgtUom;
	String wgtQty; //OK
	String woIssued;
	String fmVndrPrmrySeq;
	String spclCgoCntrTpCd;
	
	String agmtOfcCtyCd; //OK
	String agmtSeq; //OK
	String currCd; //OK
	
	// append MULTI case
//	String  ibflag;
//	String  trspAgmtScgSeq;
//	String  applRt;
	
	private TrsTrspRailBilVndrSetVO trsTrspRailBilVndrSetVO = null;
	private TrsTrspRailBilVndrSetVO[] trsTrspRailBilVndrSetVOs = null;

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
		return "EsdTrs0026Event";
	}

	public String toString() {
		return "EsdTrs0026Event";
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

	public String getAgmtOfcCtyCd() {
		return agmtOfcCtyCd;
	}

	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}

	public String getAgmtSeq() {
		return agmtSeq;
	}

	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}

	public String getCurrCd() {
		return currCd;
	}

	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

//	public String getIbflag() {
//		return ibflag;
//	}
//
//	public void setIbflag(String ibflag) {
//		this.ibflag = ibflag;
//	}
//
//	public String getTrspAgmtScgSeq() {
//		return trspAgmtScgSeq;
//	}
//
//	public void setTrspAgmtScgSeq(String trspAgmtScgSeq) {
//		this.trspAgmtScgSeq = trspAgmtScgSeq;
//	}
//
//	public String getApplRt() {
//		return applRt;
//	}
//
//	public void setApplRt(String applRt) {
//		this.applRt = applRt;
//	}

	public TrsTrspRailBilVndrSetVO getTrsTrspRailBilVndrSetVO() {
		return trsTrspRailBilVndrSetVO;
	}

	public void setTrsTrspRailBilVndrSetVO(TrsTrspRailBilVndrSetVO trsTrspRailBilVndrSetVO) {
		this.trsTrspRailBilVndrSetVO = trsTrspRailBilVndrSetVO;
	}

	public TrsTrspRailBilVndrSetVO[] getTrsTrspRailBilVndrSetVOs() {
		TrsTrspRailBilVndrSetVO[] rtnVOs = null;
		if (this.trsTrspRailBilVndrSetVOs != null) {
			rtnVOs = Arrays.copyOf(this.trsTrspRailBilVndrSetVOs, this.trsTrspRailBilVndrSetVOs.length);
		} // end if
		return rtnVOs;
	}

	public void setTrsTrspRailBilVndrSetVOs(TrsTrspRailBilVndrSetVO[] trsTrspRailBilVndrSetVOs) {
		if (trsTrspRailBilVndrSetVOs != null) {
			TrsTrspRailBilVndrSetVO[] tmpVOs = Arrays.copyOf(trsTrspRailBilVndrSetVOs, trsTrspRailBilVndrSetVOs.length);
			this.trsTrspRailBilVndrSetVOs = tmpVOs;
		} // end if
	}

}
