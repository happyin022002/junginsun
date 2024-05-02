/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_028Event.java
 *@FileTitle : USA 404 EDI Status Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-11-28
 *@LastModifier : kim_sang_geun
 *@LastVersion : 1.0 
 * 2006-11-28 kim_sang_geun
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event;

import java.util.Arrays;
import java.util.HashMap;

import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.Multi01USA404EDIStatusInquiryVO;
import com.clt.framework.core.controller.html.HTMLAction;
import com.clt.framework.support.layer.event.EventSupport;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;

/**
 * ESD_TRS_028 에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * - ESD_TRS_028HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 * 
 * @author kim_sang_geun
 * @see HTMLAction 참조
 * @since J2EE 1.4
 */
public class EsdTrs0028Event extends EventSupport {

	/** TrsTrspEdiRailOrdVO Table Value Object */
	private TrsTrspEdiRailOrdVO trsTrspEdiRailOrdVo = null;

	/** TrsTrspEdiRailOrdVO[] Multi Action을 위한 Collection */
	private TrsTrspEdiRailOrdVO[] trsTrspEdiRailOrdVos = null;

	private Multi01USA404EDIStatusInquiryVO confirmationMsgSendVo = null;

	private Multi01USA404EDIStatusInquiryVO[] confirmationMsgSendVos = null;

	public EsdTrs0028Event() {
	}

	/**
	 * @param TrsTrspEdiRailOrdVo
	 */
	public EsdTrs0028Event(TrsTrspEdiRailOrdVO TrsTrspEdiRailOrdVo) {
		this.trsTrspEdiRailOrdVo = TrsTrspEdiRailOrdVo;
	}

	/**
	 * @param TrsTrspEdiRailOrdVo
	 * @param TrsTrspEdiRailOrdVos
	 */
	public EsdTrs0028Event(TrsTrspEdiRailOrdVO TrsTrspEdiRailOrdVo, TrsTrspEdiRailOrdVO[] TrsTrspEdiRailOrdVos) {
		this.trsTrspEdiRailOrdVo = TrsTrspEdiRailOrdVo;
		this.trsTrspEdiRailOrdVos = TrsTrspEdiRailOrdVos;
	}

	public TrsTrspEdiRailOrdVO getTrsTrspEdiRailOrdVO() {
		return trsTrspEdiRailOrdVo;
	}

	/** setTrsTrspEdiRailOrdVO */
	public void setTrsTrspEdiRailOrdVO(TrsTrspEdiRailOrdVO TrsTrspEdiRailOrdVo) {
		this.trsTrspEdiRailOrdVo = TrsTrspEdiRailOrdVo;
	}

	public TrsTrspEdiRailOrdVO[] getTrsTrspEdiRailOrdVOS() {
		TrsTrspEdiRailOrdVO[] rtnVOs = null;
		if (this.trsTrspEdiRailOrdVos != null) {
			rtnVOs = Arrays.copyOf(this.trsTrspEdiRailOrdVos, this.trsTrspEdiRailOrdVos.length);
		} // end if
		return rtnVOs;
	}

	/** setTrsTrspEdiRailOrdVos */
	public void setTrsTrspEdiRailOrdVos(TrsTrspEdiRailOrdVO[] TrsTrspEdiRailOrdVos) {
		if (TrsTrspEdiRailOrdVos != null) {
			TrsTrspEdiRailOrdVO[] tmpVOs = Arrays.copyOf(TrsTrspEdiRailOrdVos, TrsTrspEdiRailOrdVos.length);
			this.trsTrspEdiRailOrdVos = tmpVOs;
		} // end if
	}

	public Multi01USA404EDIStatusInquiryVO getConfirmationMsgSendVo() {
		return confirmationMsgSendVo;
	}

	public void setConfirmationMsgSendVo(Multi01USA404EDIStatusInquiryVO confirmationMsgSendVo) {
		this.confirmationMsgSendVo = confirmationMsgSendVo;
	}

	public Multi01USA404EDIStatusInquiryVO[] getConfirmationMsgSendVos() {
		Multi01USA404EDIStatusInquiryVO[] rtnVOs = null;
		if (this.confirmationMsgSendVos != null) {
			rtnVOs = Arrays.copyOf(this.confirmationMsgSendVos, this.confirmationMsgSendVos.length);
		} // end if
		return rtnVOs;
	}

	public void setConfirmationMsgSendVos(Multi01USA404EDIStatusInquiryVO[] confirmationMsgSendVos) {
		if (confirmationMsgSendVos != null) {
			Multi01USA404EDIStatusInquiryVO[] tmpVOs = Arrays.copyOf(confirmationMsgSendVos, confirmationMsgSendVos.length);
			this.confirmationMsgSendVos = tmpVOs;
		} // end if
	}

	// 2010 변환작업 시작
	private String radDate = null;
	private String frmDate = null;
	private String toDate = null;
	private String frmNode = null;
	private String toNode = null;
	private String radVendor = null;
	private String svcProvid = null;
	private String trunkVvd = null;
	private String bkgNo = null;
	private String billNo = null;
	private String cntrNo = null;
	private String status = null;
	private String edKind = null;
	private String fuEmpy = null;
	private String bound = null;
	private String liminq = null;
	private String through = null;
	private String ctrlOfcCd = null;
	private String incHistory = null;
	private String railRoad = null;
	private String bkgAtch = null;
	private String userId = null;
	private String ctrlUserId = null;

	// Confirmation MSG Send [FormCommand.SEARCH02]
	private String fTrspSoOfcCtyCd = null;
	private String fTrspSoSeq = null;
	private String vndrSeq = null;
	private String unplanned = null;
	private String refNo = null;
	private String podCd = null;
	private String podNodCd = null;

	public String getRadDate() {
		return radDate;
	}

	public void setRadDate(String radDate) {
		this.radDate = radDate;
	}

	public String getFrmDate() {
		return frmDate;
	}

	public void setFrmDate(String frmDate) {
		this.frmDate = frmDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getFrmNode() {
		return frmNode;
	}

	public void setFrmNode(String frmNode) {
		this.frmNode = frmNode;
	}

	public String getToNode() {
		return toNode;
	}

	public void setToNode(String toNode) {
		this.toNode = toNode;
	}

	public String getRadVendor() {
		return radVendor;
	}

	public void setRadVendor(String radVendor) {
		this.radVendor = radVendor;
	}

	public String getSvcProvid() {
		return svcProvid;
	}

	public void setSvcProvid(String svcProvid) {
		this.svcProvid = svcProvid;
	}

	public String getTrunkVvd() {
		return trunkVvd;
	}

	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEdKind() {
		return edKind;
	}

	public void setEdKind(String edKind) {
		this.edKind = edKind;
	}

	public String getFuEmpy() {
		return fuEmpy;
	}

	public void setFuEmpy(String fuEmpy) {
		this.fuEmpy = fuEmpy;
	}

	public String getBound() {
		return bound;
	}

	public void setBound(String bound) {
		this.bound = bound;
	}

	public String getLiminq() {
		return liminq;
	}

	public void setLiminq(String liminq) {
		this.liminq = liminq;
	}

	public String getThrough() {
		return through;
	}

	public void setThrough(String through) {
		this.through = through;
	}

	public String getCtrlOfcCd() {
		return ctrlOfcCd;
	}

	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}

	public String getIncHistory() {
		return incHistory;
	}

	public void setIncHistory(String incHistory) {
		this.incHistory = incHistory;
	}

	public String getRailRoad() {
		return railRoad;
	}

	public void setRailRoad(String railRoad) {
		this.railRoad = railRoad;
	}

	public String getBkgAtch() {
		return bkgAtch;
	}

	public void setBkgAtch(String bkgAtch) {
		this.bkgAtch = bkgAtch;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFTrspSoOfcCtyCd() {
		return fTrspSoOfcCtyCd;
	}

	public void setFTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.fTrspSoOfcCtyCd = trspSoOfcCtyCd;
	}

	public String getFTrspSoSeq() {
		return fTrspSoSeq;
	}

	public void setFTrspSoSeq(String trspSoSeq) {
		this.fTrspSoSeq = trspSoSeq;
	}

	public String getCtrlUserId() {
		return ctrlUserId;
	}

	public void setCtrlUserId(String ctrlUserId) {
		this.ctrlUserId = ctrlUserId;
	}

	public String getVndrSeq() {
		return vndrSeq;
	}

	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}

	public String getUnplanned() {
		return unplanned;
	}

	public void setUnplanned(String unplanned) {
		this.unplanned = unplanned;
	}

	public String getPodCd() {
		return podCd;
	}

	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}

	public String getPodNodCd() {
		return podNodCd;
	}

	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("radDate", getRadDate());
		this.hashColumns.put("frmDate", getFrmDate());
		this.hashColumns.put("toDate", getToDate());
		this.hashColumns.put("frmNode", getFrmNode());
		this.hashColumns.put("toNode", getToNode());
		this.hashColumns.put("radVendor", getRadVendor());
		this.hashColumns.put("svcProvid", getSvcProvid());
		this.hashColumns.put("trunkVvd", getTrunkVvd());
		this.hashColumns.put("bkgNo", getBkgNo());
		this.hashColumns.put("billNo", getBillNo());
		this.hashColumns.put("cntrNo", getCntrNo());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("edKind", getEdKind());
		this.hashColumns.put("fuEmpy", getFuEmpy());
		this.hashColumns.put("bound", getBound());
		this.hashColumns.put("liminq", getLiminq());
		this.hashColumns.put("through", getThrough());
		this.hashColumns.put("ctrlOfcCd", getCtrlOfcCd());
		this.hashColumns.put("incHistory", getIncHistory());
		this.hashColumns.put("railRoad", getRailRoad());
		this.hashColumns.put("bkgAtch", getBkgAtch());
		this.hashColumns.put("userId", getUserId());
		this.hashColumns.put("f_trsp_so_ofc_cty_cd", this.getFTrspSoOfcCtyCd());
		this.hashColumns.put("f_trsp_so_seq", this.getFTrspSoSeq());
		this.hashColumns.put("ctrlUserId", getCtrlUserId());
		this.hashColumns.put("unplanned", getUnplanned());
		this.hashColumns.put("podCd", getPodCd());
		this.hashColumns.put("podNodCd", getPodNodCd());
		return this.hashColumns;
	}

	public String getEventName() {
		return "EsdTrs0028Event";
	}

	public String toString() {
		return "EsdTrs0028Event";
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

}
