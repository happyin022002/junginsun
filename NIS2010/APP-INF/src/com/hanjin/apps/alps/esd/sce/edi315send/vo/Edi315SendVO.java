/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : Edi315SendVO.java
*@FileTitle : Edi315SendVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315SendVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315SendVO> models = new ArrayList<Edi315SendVO>();
	
	/* Column Info */
	private String callFmSrcId = null;
	/* Column Info */
	private String callFrom = null;
	/* Column Info */
	private String vdlByCntrAttach = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String actRcvIfKeyDt = null;
	/* Column Info */
	private String fmBtchFlg = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String ediIfKeyDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ediStatus = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eventDt = null;
	/* Column Info */
	private String actRcvIfKeyNo = null;
	/* Column Info */
	private String copInd = null;
	/* Column Info */
	private String copActCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String manFlg = null;
	/* Column Info */
	private String tmcFlg = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String reEventdt = null;
	/* Column Info */
	private String creId = null;
	/* Column Info */
	private String logFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ifRmk = null;
	/* Column Info */
	private String mvmtSts = null;
	/* Column Info */
	private String ediIfKeySeq = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String eventYard = null;
	/* Column Info */
	private String copDtlSeq = null;
	/* Column Info */
	private String currVvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String cntrCallCnt = null;
	/* Column Info */
	private String updId = null;
	/* Column Info */
	private String custStatus = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public Edi315SendVO() {}

	public Edi315SendVO(String ibflag, String pagerows, String rcvDt, String rcvSeq, String ediStatus, String custStatus, String mvmtSts, String copActCd, String bkgNo, String blNo, String cntrNo, String copNo, String copDtlSeq, String currVvd, String eventDt, String eventYard, String creDt, String creId, String callFrom, String manFlg, String logFlg, String ediGrpCd, String actRcvIfKeyDt, String actRcvIfKeyNo, String copInd, String costActGrpSeq, String updId, String updDt, String cntrCallCnt, String vdlByCntrAttach, String ediIfKeyDt, String ediIfKeySeq, String callFmSrcId, String fmBtchFlg, String ifRmk, String reEventdt, String clptIndSeq, String tmcFlg) {
		this.callFmSrcId = callFmSrcId;
		this.callFrom = callFrom;
		this.vdlByCntrAttach = vdlByCntrAttach;
		this.copNo = copNo;
		this.creDt = creDt;
		this.actRcvIfKeyDt = actRcvIfKeyDt;
		this.fmBtchFlg = fmBtchFlg;
		this.rcvSeq = rcvSeq;
		this.ediIfKeyDt = ediIfKeyDt;
		this.blNo = blNo;
		this.ediStatus = ediStatus;
		this.pagerows = pagerows;
		this.eventDt = eventDt;
		this.actRcvIfKeyNo = actRcvIfKeyNo;
		this.copInd = copInd;
		this.copActCd = copActCd;
		this.ibflag = ibflag;
		this.manFlg = manFlg;
		this.tmcFlg = tmcFlg;
		this.rcvDt = rcvDt;
		this.reEventdt = reEventdt;
		this.creId = creId;
		this.logFlg = logFlg;
		this.updDt = updDt;
		this.ifRmk = ifRmk;
		this.mvmtSts = mvmtSts;
		this.ediIfKeySeq = ediIfKeySeq;
		this.ediGrpCd = ediGrpCd;
		this.eventYard = eventYard;
		this.copDtlSeq = copDtlSeq;
		this.currVvd = currVvd;
		this.bkgNo = bkgNo;
		this.costActGrpSeq = costActGrpSeq;
		this.cntrNo = cntrNo;
		this.clptIndSeq = clptIndSeq;
		this.cntrCallCnt = cntrCallCnt;
		this.updId = updId;
		this.custStatus = custStatus;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("call_fm_src_id", getCallFmSrcId());
		this.hashColumns.put("call_from", getCallFrom());
		this.hashColumns.put("vdl_by_cntr_attach", getVdlByCntrAttach());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("act_rcv_if_key_dt", getActRcvIfKeyDt());
		this.hashColumns.put("fm_btch_flg", getFmBtchFlg());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("edi_if_key_dt", getEdiIfKeyDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("edi_status", getEdiStatus());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("act_rcv_if_key_no", getActRcvIfKeyNo());
		this.hashColumns.put("cop_ind", getCopInd());
		this.hashColumns.put("cop_act_cd", getCopActCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("man_flg", getManFlg());
		this.hashColumns.put("tmc_flg", getTmcFlg());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("re_eventDt", getReEventdt());
		this.hashColumns.put("cre_id", getCreId());
		this.hashColumns.put("log_flg", getLogFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("if_rmk", getIfRmk());
		this.hashColumns.put("mvmt_sts", getMvmtSts());
		this.hashColumns.put("edi_if_key_seq", getEdiIfKeySeq());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("event_yard", getEventYard());
		this.hashColumns.put("cop_dtl_seq", getCopDtlSeq());
		this.hashColumns.put("curr_vvd", getCurrVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("cntr_call_cnt", getCntrCallCnt());
		this.hashColumns.put("upd_id", getUpdId());
		this.hashColumns.put("cust_status", getCustStatus());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("call_fm_src_id", "callFmSrcId");
		this.hashFields.put("call_from", "callFrom");
		this.hashFields.put("vdl_by_cntr_attach", "vdlByCntrAttach");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("act_rcv_if_key_dt", "actRcvIfKeyDt");
		this.hashFields.put("fm_btch_flg", "fmBtchFlg");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("edi_if_key_dt", "ediIfKeyDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("edi_status", "ediStatus");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("act_rcv_if_key_no", "actRcvIfKeyNo");
		this.hashFields.put("cop_ind", "copInd");
		this.hashFields.put("cop_act_cd", "copActCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("man_flg", "manFlg");
		this.hashFields.put("tmc_flg", "tmcFlg");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("re_eventDt", "reEventdt");
		this.hashFields.put("cre_id", "creId");
		this.hashFields.put("log_flg", "logFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("if_rmk", "ifRmk");
		this.hashFields.put("mvmt_sts", "mvmtSts");
		this.hashFields.put("edi_if_key_seq", "ediIfKeySeq");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("event_yard", "eventYard");
		this.hashFields.put("cop_dtl_seq", "copDtlSeq");
		this.hashFields.put("curr_vvd", "currVvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("cntr_call_cnt", "cntrCallCnt");
		this.hashFields.put("upd_id", "updId");
		this.hashFields.put("cust_status", "custStatus");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return callFmSrcId
	 */
	public String getCallFmSrcId() {
		return this.callFmSrcId;
	}
	
	/**
	 * Column Info
	 * @return callFrom
	 */
	public String getCallFrom() {
		return this.callFrom;
	}
	
	/**
	 * Column Info
	 * @return vdlByCntrAttach
	 */
	public String getVdlByCntrAttach() {
		return this.vdlByCntrAttach;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return actRcvIfKeyDt
	 */
	public String getActRcvIfKeyDt() {
		return this.actRcvIfKeyDt;
	}
	
	/**
	 * Column Info
	 * @return fmBtchFlg
	 */
	public String getFmBtchFlg() {
		return this.fmBtchFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return ediIfKeyDt
	 */
	public String getEdiIfKeyDt() {
		return this.ediIfKeyDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return ediStatus
	 */
	public String getEdiStatus() {
		return this.ediStatus;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return eventDt
	 */
	public String getEventDt() {
		return this.eventDt;
	}
	
	/**
	 * Column Info
	 * @return actRcvIfKeyNo
	 */
	public String getActRcvIfKeyNo() {
		return this.actRcvIfKeyNo;
	}
	
	/**
	 * Column Info
	 * @return copInd
	 */
	public String getCopInd() {
		return this.copInd;
	}
	
	/**
	 * Column Info
	 * @return copActCd
	 */
	public String getCopActCd() {
		return this.copActCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return manFlg
	 */
	public String getManFlg() {
		return this.manFlg;
	}
	
	/**
	 * Column Info
	 * @return tmcFlg
	 */
	public String getTmcFlg() {
		return this.tmcFlg;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return reEventdt
	 */
	public String getReEventdt() {
		return this.reEventdt;
	}
	
	/**
	 * Column Info
	 * @return creId
	 */
	public String getCreId() {
		return this.creId;
	}
	
	/**
	 * Column Info
	 * @return logFlg
	 */
	public String getLogFlg() {
		return this.logFlg;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return ifRmk
	 */
	public String getIfRmk() {
		return this.ifRmk;
	}
	
	/**
	 * Column Info
	 * @return mvmtSts
	 */
	public String getMvmtSts() {
		return this.mvmtSts;
	}
	
	/**
	 * Column Info
	 * @return ediIfKeySeq
	 */
	public String getEdiIfKeySeq() {
		return this.ediIfKeySeq;
	}
	
	/**
	 * Column Info
	 * @return ediGrpCd
	 */
	public String getEdiGrpCd() {
		return this.ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @return eventYard
	 */
	public String getEventYard() {
		return this.eventYard;
	}
	
	/**
	 * Column Info
	 * @return copDtlSeq
	 */
	public String getCopDtlSeq() {
		return this.copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return currVvd
	 */
	public String getCurrVvd() {
		return this.currVvd;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return costActGrpSeq
	 */
	public String getCostActGrpSeq() {
		return this.costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrCallCnt
	 */
	public String getCntrCallCnt() {
		return this.cntrCallCnt;
	}
	
	/**
	 * Column Info
	 * @return updId
	 */
	public String getUpdId() {
		return this.updId;
	}
	
	/**
	 * Column Info
	 * @return custStatus
	 */
	public String getCustStatus() {
		return this.custStatus;
	}
	

	/**
	 * Column Info
	 * @param callFmSrcId
	 */
	public void setCallFmSrcId(String callFmSrcId) {
		this.callFmSrcId = callFmSrcId;
	}
	
	/**
	 * Column Info
	 * @param callFrom
	 */
	public void setCallFrom(String callFrom) {
		this.callFrom = callFrom;
	}
	
	/**
	 * Column Info
	 * @param vdlByCntrAttach
	 */
	public void setVdlByCntrAttach(String vdlByCntrAttach) {
		this.vdlByCntrAttach = vdlByCntrAttach;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param actRcvIfKeyDt
	 */
	public void setActRcvIfKeyDt(String actRcvIfKeyDt) {
		this.actRcvIfKeyDt = actRcvIfKeyDt;
	}
	
	/**
	 * Column Info
	 * @param fmBtchFlg
	 */
	public void setFmBtchFlg(String fmBtchFlg) {
		this.fmBtchFlg = fmBtchFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param ediIfKeyDt
	 */
	public void setEdiIfKeyDt(String ediIfKeyDt) {
		this.ediIfKeyDt = ediIfKeyDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param ediStatus
	 */
	public void setEdiStatus(String ediStatus) {
		this.ediStatus = ediStatus;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param eventDt
	 */
	public void setEventDt(String eventDt) {
		this.eventDt = eventDt;
	}
	
	/**
	 * Column Info
	 * @param actRcvIfKeyNo
	 */
	public void setActRcvIfKeyNo(String actRcvIfKeyNo) {
		this.actRcvIfKeyNo = actRcvIfKeyNo;
	}
	
	/**
	 * Column Info
	 * @param copInd
	 */
	public void setCopInd(String copInd) {
		this.copInd = copInd;
	}
	
	/**
	 * Column Info
	 * @param copActCd
	 */
	public void setCopActCd(String copActCd) {
		this.copActCd = copActCd;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param manFlg
	 */
	public void setManFlg(String manFlg) {
		this.manFlg = manFlg;
	}
	
	/**
	 * Column Info
	 * @param tmcFlg
	 */
	public void setTmcFlg(String tmcFlg) {
		this.tmcFlg = tmcFlg;
	}
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param reEventdt
	 */
	public void setReEventDt(String reEventdt) {
		this.reEventdt = reEventdt;
	}
	
	/**
	 * Column Info
	 * @param creId
	 */
	public void setCreId(String creId) {
		this.creId = creId;
	}
	
	/**
	 * Column Info
	 * @param logFlg
	 */
	public void setLogFlg(String logFlg) {
		this.logFlg = logFlg;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param ifRmk
	 */
	public void setIfRmk(String ifRmk) {
		this.ifRmk = ifRmk;
	}
	
	/**
	 * Column Info
	 * @param mvmtSts
	 */
	public void setMvmtSts(String mvmtSts) {
		this.mvmtSts = mvmtSts;
	}
	
	/**
	 * Column Info
	 * @param ediIfKeySeq
	 */
	public void setEdiIfKeySeq(String ediIfKeySeq) {
		this.ediIfKeySeq = ediIfKeySeq;
	}
	
	/**
	 * Column Info
	 * @param ediGrpCd
	 */
	public void setEdiGrpCd(String ediGrpCd) {
		this.ediGrpCd = ediGrpCd;
	}
	
	/**
	 * Column Info
	 * @param eventYard
	 */
	public void setEventYard(String eventYard) {
		this.eventYard = eventYard;
	}
	
	/**
	 * Column Info
	 * @param copDtlSeq
	 */
	public void setCopDtlSeq(String copDtlSeq) {
		this.copDtlSeq = copDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param currVvd
	 */
	public void setCurrVvd(String currVvd) {
		this.currVvd = currVvd;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param costActGrpSeq
	 */
	public void setCostActGrpSeq(String costActGrpSeq) {
		this.costActGrpSeq = costActGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrCallCnt
	 */
	public void setCntrCallCnt(String cntrCallCnt) {
		this.cntrCallCnt = cntrCallCnt;
	}
	
	/**
	 * Column Info
	 * @param updId
	 */
	public void setUpdId(String updId) {
		this.updId = updId;
	}
	
	/**
	 * Column Info
	 * @param custStatus
	 */
	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setCallFmSrcId(JSPUtil.getParameter(request, prefix + "call_fm_src_id", ""));
		setCallFrom(JSPUtil.getParameter(request, prefix + "call_from", ""));
		setVdlByCntrAttach(JSPUtil.getParameter(request, prefix + "vdl_by_cntr_attach", ""));
		setCopNo(JSPUtil.getParameter(request, prefix + "cop_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setActRcvIfKeyDt(JSPUtil.getParameter(request, prefix + "act_rcv_if_key_dt", ""));
		setFmBtchFlg(JSPUtil.getParameter(request, prefix + "fm_btch_flg", ""));
		setRcvSeq(JSPUtil.getParameter(request, prefix + "rcv_seq", ""));
		setEdiIfKeyDt(JSPUtil.getParameter(request, prefix + "edi_if_key_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setEdiStatus(JSPUtil.getParameter(request, prefix + "edi_status", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEventDt(JSPUtil.getParameter(request, prefix + "event_dt", ""));
		setActRcvIfKeyNo(JSPUtil.getParameter(request, prefix + "act_rcv_if_key_no", ""));
		setCopInd(JSPUtil.getParameter(request, prefix + "cop_ind", ""));
		setCopActCd(JSPUtil.getParameter(request, prefix + "cop_act_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setManFlg(JSPUtil.getParameter(request, prefix + "man_flg", ""));
		setTmcFlg(JSPUtil.getParameter(request, prefix + "tmc_flg", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setReEventDt(JSPUtil.getParameter(request, prefix + "re_eventDt", ""));
		setCreId(JSPUtil.getParameter(request, prefix + "cre_id", ""));
		setLogFlg(JSPUtil.getParameter(request, prefix + "log_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setIfRmk(JSPUtil.getParameter(request, prefix + "if_rmk", ""));
		setMvmtSts(JSPUtil.getParameter(request, prefix + "mvmt_sts", ""));
		setEdiIfKeySeq(JSPUtil.getParameter(request, prefix + "edi_if_key_seq", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, prefix + "edi_grp_cd", ""));
		setEventYard(JSPUtil.getParameter(request, prefix + "event_yard", ""));
		setCopDtlSeq(JSPUtil.getParameter(request, prefix + "cop_dtl_seq", ""));
		setCurrVvd(JSPUtil.getParameter(request, prefix + "curr_vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, prefix + "cost_act_grp_seq", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setClptIndSeq(JSPUtil.getParameter(request, prefix + "clpt_ind_seq", ""));
		setCntrCallCnt(JSPUtil.getParameter(request, prefix + "cntr_call_cnt", ""));
		setUpdId(JSPUtil.getParameter(request, prefix + "upd_id", ""));
		setCustStatus(JSPUtil.getParameter(request, prefix + "cust_status", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315SendVO[]
	 */
	public Edi315SendVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315SendVO[]
	 */
	public Edi315SendVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315SendVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] callFmSrcId = (JSPUtil.getParameter(request, prefix	+ "call_fm_src_id", length));
			String[] callFrom = (JSPUtil.getParameter(request, prefix	+ "call_from", length));
			String[] vdlByCntrAttach = (JSPUtil.getParameter(request, prefix	+ "vdl_by_cntr_attach", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] actRcvIfKeyDt = (JSPUtil.getParameter(request, prefix	+ "act_rcv_if_key_dt", length));
			String[] fmBtchFlg = (JSPUtil.getParameter(request, prefix	+ "fm_btch_flg", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] ediIfKeyDt = (JSPUtil.getParameter(request, prefix	+ "edi_if_key_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ediStatus = (JSPUtil.getParameter(request, prefix	+ "edi_status", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eventDt = (JSPUtil.getParameter(request, prefix	+ "event_dt", length));
			String[] actRcvIfKeyNo = (JSPUtil.getParameter(request, prefix	+ "act_rcv_if_key_no", length));
			String[] copInd = (JSPUtil.getParameter(request, prefix	+ "cop_ind", length));
			String[] copActCd = (JSPUtil.getParameter(request, prefix	+ "cop_act_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] manFlg = (JSPUtil.getParameter(request, prefix	+ "man_flg", length));
			String[] tmcFlg = (JSPUtil.getParameter(request, prefix	+ "tmc_flg", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] reEventdt = (JSPUtil.getParameter(request, prefix	+ "re_eventDt", length));
			String[] creId = (JSPUtil.getParameter(request, prefix	+ "cre_id", length));
			String[] logFlg = (JSPUtil.getParameter(request, prefix	+ "log_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ifRmk = (JSPUtil.getParameter(request, prefix	+ "if_rmk", length));
			String[] mvmtSts = (JSPUtil.getParameter(request, prefix	+ "mvmt_sts", length));
			String[] ediIfKeySeq = (JSPUtil.getParameter(request, prefix	+ "edi_if_key_seq", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] eventYard = (JSPUtil.getParameter(request, prefix	+ "event_yard", length));
			String[] copDtlSeq = (JSPUtil.getParameter(request, prefix	+ "cop_dtl_seq", length));
			String[] currVvd = (JSPUtil.getParameter(request, prefix	+ "curr_vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] cntrCallCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_call_cnt", length));
			String[] updId = (JSPUtil.getParameter(request, prefix	+ "upd_id", length));
			String[] custStatus = (JSPUtil.getParameter(request, prefix	+ "cust_status", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315SendVO();
				if (callFmSrcId[i] != null)
					model.setCallFmSrcId(callFmSrcId[i]);
				if (callFrom[i] != null)
					model.setCallFrom(callFrom[i]);
				if (vdlByCntrAttach[i] != null)
					model.setVdlByCntrAttach(vdlByCntrAttach[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (actRcvIfKeyDt[i] != null)
					model.setActRcvIfKeyDt(actRcvIfKeyDt[i]);
				if (fmBtchFlg[i] != null)
					model.setFmBtchFlg(fmBtchFlg[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (ediIfKeyDt[i] != null)
					model.setEdiIfKeyDt(ediIfKeyDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ediStatus[i] != null)
					model.setEdiStatus(ediStatus[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eventDt[i] != null)
					model.setEventDt(eventDt[i]);
				if (actRcvIfKeyNo[i] != null)
					model.setActRcvIfKeyNo(actRcvIfKeyNo[i]);
				if (copInd[i] != null)
					model.setCopInd(copInd[i]);
				if (copActCd[i] != null)
					model.setCopActCd(copActCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (manFlg[i] != null)
					model.setManFlg(manFlg[i]);
				if (tmcFlg[i] != null)
					model.setTmcFlg(tmcFlg[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (reEventdt[i] != null)
					model.setReEventDt(reEventdt[i]);
				if (creId[i] != null)
					model.setCreId(creId[i]);
				if (logFlg[i] != null)
					model.setLogFlg(logFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ifRmk[i] != null)
					model.setIfRmk(ifRmk[i]);
				if (mvmtSts[i] != null)
					model.setMvmtSts(mvmtSts[i]);
				if (ediIfKeySeq[i] != null)
					model.setEdiIfKeySeq(ediIfKeySeq[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (eventYard[i] != null)
					model.setEventYard(eventYard[i]);
				if (copDtlSeq[i] != null)
					model.setCopDtlSeq(copDtlSeq[i]);
				if (currVvd[i] != null)
					model.setCurrVvd(currVvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (cntrCallCnt[i] != null)
					model.setCntrCallCnt(cntrCallCnt[i]);
				if (updId[i] != null)
					model.setUpdId(updId[i]);
				if (custStatus[i] != null)
					model.setCustStatus(custStatus[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315SendVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315SendVO[]
	 */
	public Edi315SendVO[] getEdi315SendVOs(){
		Edi315SendVO[] vos = (Edi315SendVO[])models.toArray(new Edi315SendVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	   }

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.callFmSrcId = this.callFmSrcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callFrom = this.callFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vdlByCntrAttach = this.vdlByCntrAttach .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvIfKeyDt = this.actRcvIfKeyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmBtchFlg = this.fmBtchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediIfKeyDt = this.ediIfKeyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediStatus = this.ediStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDt = this.eventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvIfKeyNo = this.actRcvIfKeyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copInd = this.copInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copActCd = this.copActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manFlg = this.manFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmcFlg = this.tmcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reEventdt = this.reEventdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creId = this.creId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logFlg = this.logFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifRmk = this.ifRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtSts = this.mvmtSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediIfKeySeq = this.ediIfKeySeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventYard = this.eventYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copDtlSeq = this.copDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currVvd = this.currVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCallCnt = this.cntrCallCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updId = this.updId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custStatus = this.custStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
