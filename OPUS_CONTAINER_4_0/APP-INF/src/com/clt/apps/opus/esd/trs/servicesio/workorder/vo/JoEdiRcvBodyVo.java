package com.clt.apps.opus.esd.trs.servicesio.workorder.vo;

import java.util.List;

public class JoEdiRcvBodyVo {
	// JO_ITEM_MSG_TYPE
	private String joItemMsgType;
	// SND_CD
	private String sndCd;
	// RCV_CD
	private String rcvCd;
	// JO_ITEM_REF
	private String joItemRef;

	// REASON_CD
	private String reasonCd;

	// STOP_NO
	private String stopNo;

	// GATE_IN_START
	private String gateInStart;

	// GATE_IN_END
	private String gateInEnd;

	// GATE_IN_FORM
	private String gateInForm;

	// GATE_OUT_START
	private String gateOutStart;

	// GATE_OUT_EDN
	private String gateOutEdn;

	// GATE_OUT_FORM
	private String gateOutForm;

	// GATE_IN
	private String gateIn;

	// GATE_OUT
	private String gateOut;

	// BKG_NO
	private String bkgNo;

	// BL_NO
	private String blNo;

	// CUTOFF_DT
	private String cutoffDt;

	//
	List<JoEdiRcvEqmentVo> joEdiRcvEqmentVos;

	List<JoEdiRcvStopVo> joEdiRcvStopVos;

	public String getJoItemMsgType() {
		return joItemMsgType;
	}

	public void setJoItemMsgType(String joItemMsgType) {
		this.joItemMsgType = joItemMsgType;
	}

	public String getSndCd() {
		return sndCd;
	}

	public void setSndCd(String sndCd) {
		this.sndCd = sndCd;
	}

	public String getRcvCd() {
		return rcvCd;
	}

	public void setRcvCd(String rcvCd) {
		this.rcvCd = rcvCd;
	}

	public String getJoItemRef() {
		return joItemRef;
	}

	public void setJoItemRef(String joItemRef) {
		this.joItemRef = joItemRef;
	}

	public String getReasonCd() {
		return reasonCd;
	}

	public void setReasonCd(String reasonCd) {
		this.reasonCd = reasonCd;
	}

	public String getStopNo() {
		return stopNo;
	}

	public void setStopNo(String stopNo) {
		this.stopNo = stopNo;
	}

	public String getGateInStart() {
		return gateInStart;
	}

	public void setGateInStart(String gateInStart) {
		this.gateInStart = gateInStart;
	}

	public String getGateInEnd() {
		return gateInEnd;
	}

	public void setGateInEnd(String gateInEnd) {
		this.gateInEnd = gateInEnd;
	}

	public String getGateInForm() {
		return gateInForm;
	}

	public void setGateInForm(String gateInForm) {
		this.gateInForm = gateInForm;
	}

	public String getGateOutStart() {
		return gateOutStart;
	}

	public void setGateOutStart(String gateOutStart) {
		this.gateOutStart = gateOutStart;
	}

	public String getGateOutEdn() {
		return gateOutEdn;
	}

	public void setGateOutEdn(String gateOutEdn) {
		this.gateOutEdn = gateOutEdn;
	}

	public String getGateOutForm() {
		return gateOutForm;
	}

	public void setGateOutForm(String gateOutForm) {
		this.gateOutForm = gateOutForm;
	}

	public String getGateIn() {
		return gateIn;
	}

	public void setGateIn(String gateIn) {
		this.gateIn = gateIn;
	}

	public String getGateOut() {
		return gateOut;
	}

	public void setGateOut(String gateOut) {
		this.gateOut = gateOut;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getCutoffDt() {
		return cutoffDt;
	}

	public void setCutoffDt(String cutoffDt) {
		this.cutoffDt = cutoffDt;
	}

	public List<JoEdiRcvEqmentVo> getJoEdiRcvEqmentVos() {
		return joEdiRcvEqmentVos;
	}

	public void setJoEdiRcvEqmentVos(List<JoEdiRcvEqmentVo> joEdiRcvEqmentVos) {
		this.joEdiRcvEqmentVos = joEdiRcvEqmentVos;
	}

	public List<JoEdiRcvStopVo> getJoEdiRcvStopVos() {
		return joEdiRcvStopVos;
	}

	public void setJoEdiRcvStopVos(List<JoEdiRcvStopVo> joEdiRcvStopVos) {
		this.joEdiRcvStopVos = joEdiRcvStopVos;
	}
}
