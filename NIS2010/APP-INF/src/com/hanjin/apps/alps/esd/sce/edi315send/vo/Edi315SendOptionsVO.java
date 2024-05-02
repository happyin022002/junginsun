/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : Edi315SendOptionsVO.java
*@FileTitle : Edi315SendOptionsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.16
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2009.11.16 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315SendOptionsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315SendOptionsVO> models = new ArrayList<Edi315SendOptionsVO>();
	
	/* Column Info */
	private String vErrorCode = null;
	/* Column Info */
	private String ePolLoc = null;
	/* Column Info */
	private String custNo = null;
	/* Column Info */
	private String callFrom = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String eDelLoc = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String custEdiStsCd = null;
	/* Column Info */
	private String orgEdiStsCd = null;
	/* Column Info */
	private String vMessage = null;
	/* Column Info */
	private String actRcvIfKey = null;
	/* Column Info */
	private String cntrNo1 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eCopNo = null;
	/* Column Info */
	private String eventDt = null;
	/* Column Info */
	private String custTpId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String groupSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String creId = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String cnmvFullFlg = null;
	/* Column Info */
	private String ediSndFlg = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String nod = null;
	/* Column Info */
	private String eBkgNo = null;
	/* Column Info */
	private String bkgNoSplit = null;
	/* Column Info */
	private String ediGrpCd = null;
	/* Column Info */
	private String ePodLoc = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String currVvd = null;
	/* Column Info */
	private String rsltSndCnt = null;
	/* Column Info */
	private String sndSeq = null;
	/* Column Info */
	private String ediSts = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ediGroupCd = null;
	/* Column Info */
	private String issendTpCntr = null;
	/* Column Info */
	private String costActGrpSeq = null;
	/* Column Info */
	private String vBound = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ePorLoc = null;
	/* Column Info */
	private String ediSndItvalHr = null;
	/* Column Info */
	private String updId = null;
	/* Column Info */
	private String hostTpId = null;
	/* Column Info */
	private String actRcvDt = null;
	/* Column Info */
	private String cnmvYr = null;
	private String chkPortCd = null;
	private String isPodAtaReplace = null;
	private String podAtaEventDt = null;
    
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315SendOptionsVO() {}

	public Edi315SendOptionsVO(String ibflag, String pagerows, String ediGroupCd, String groupSeq, String bkgNo, String bkgNoSplit, String cntrNo, String cntrNo1, String ediSts, String cntrTpszCd, String orgYdCd, String eventDt, String nod, String ediGrpCd, String hostTpId, String custTpId, String custEdiStsCd, String cnmvFullFlg, String ediSndFlg, String custNo, String copNo, String callFrom, String creId, String updId, String cnmvYr, String cnmvSeq, String dtlSeq, String actRcvDt, String rsltSndCnt, String sndSeq, String custCntCd, String custSeq, String ediSndItvalHr, String issendTpCntr, String vMessage, String vErrorCode, String actRcvIfKey, String currVvd, String vBound, String orgEdiStsCd, String eBkgNo, String ePorLoc, String ePolLoc, String ePodLoc, String eDelLoc, String eCopNo, String costActGrpSeq, String chkPortCd, String isPodAtaReplace, String podAtaEventDt) {
		this.vErrorCode = vErrorCode;
		this.ePolLoc = ePolLoc;
		this.custNo = custNo;
		this.callFrom = callFrom;
		this.cnmvSeq = cnmvSeq;
		this.eDelLoc = eDelLoc;
		this.copNo = copNo;
		this.custEdiStsCd = custEdiStsCd;
		this.orgEdiStsCd = orgEdiStsCd;
		this.vMessage = vMessage;
		this.actRcvIfKey = actRcvIfKey;
		this.cntrNo1 = cntrNo1;
		this.pagerows = pagerows;
		this.eCopNo = eCopNo;
		this.eventDt = eventDt;
		this.custTpId = custTpId;
		this.ibflag = ibflag;
		this.groupSeq = groupSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.creId = creId;
		this.dtlSeq = dtlSeq;
		this.cnmvFullFlg = cnmvFullFlg;
		this.ediSndFlg = ediSndFlg;
		this.custCntCd = custCntCd;
		this.nod = nod;
		this.eBkgNo = eBkgNo;
		this.bkgNoSplit = bkgNoSplit;
		this.ediGrpCd = ediGrpCd;
		this.ePodLoc = ePodLoc;
		this.custSeq = custSeq;
		this.orgYdCd = orgYdCd;
		this.currVvd = currVvd;
		this.rsltSndCnt = rsltSndCnt;
		this.sndSeq = sndSeq;
		this.ediSts = ediSts;
		this.bkgNo = bkgNo;
		this.ediGroupCd = ediGroupCd;
		this.issendTpCntr = issendTpCntr;
		this.costActGrpSeq = costActGrpSeq;
		this.vBound = vBound;
		this.cntrNo = cntrNo;
		this.ePorLoc = ePorLoc;
		this.ediSndItvalHr = ediSndItvalHr;
		this.updId = updId;
		this.hostTpId = hostTpId;
		this.actRcvDt = actRcvDt;
		this.cnmvYr = cnmvYr;
		this.chkPortCd = chkPortCd;
		this.isPodAtaReplace = isPodAtaReplace;
		this.podAtaEventDt = podAtaEventDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("v_error_code", getVErrorCode());
		this.hashColumns.put("e_pol_loc", getEPolLoc());
		this.hashColumns.put("cust_no", getCustNo());
		this.hashColumns.put("call_from", getCallFrom());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("e_del_loc", getEDelLoc());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("cust_edi_sts_cd", getCustEdiStsCd());
		this.hashColumns.put("org_edi_sts_cd", getOrgEdiStsCd());
		this.hashColumns.put("v_message", getVMessage());
		this.hashColumns.put("act_rcv_if_key", getActRcvIfKey());
		this.hashColumns.put("cntr_no_1", getCntrNo1());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("e_cop_no", getECopNo());
		this.hashColumns.put("event_dt", getEventDt());
		this.hashColumns.put("cust_tp_id", getCustTpId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("group_seq", getGroupSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cre_id", getCreId());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("cnmv_full_flg", getCnmvFullFlg());
		this.hashColumns.put("edi_snd_flg", getEdiSndFlg());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("nod", getNod());
		this.hashColumns.put("e_bkg_no", getEBkgNo());
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());
		this.hashColumns.put("edi_grp_cd", getEdiGrpCd());
		this.hashColumns.put("e_pod_loc", getEPodLoc());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("curr_vvd", getCurrVvd());
		this.hashColumns.put("rslt_snd_cnt", getRsltSndCnt());
		this.hashColumns.put("snd_seq", getSndSeq());
		this.hashColumns.put("edi_sts", getEdiSts());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("edi_group_cd", getEdiGroupCd());
		this.hashColumns.put("issend_tp_cntr", getIssendTpCntr());
		this.hashColumns.put("cost_act_grp_seq", getCostActGrpSeq());
		this.hashColumns.put("v_bound", getVBound());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("e_por_loc", getEPorLoc());
		this.hashColumns.put("edi_snd_itval_hr", getEdiSndItvalHr());
		this.hashColumns.put("upd_id", getUpdId());
		this.hashColumns.put("host_tp_id", getHostTpId());
		this.hashColumns.put("act_rcv_dt", getActRcvDt());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("chk_port_cd", getChkPortCd());
		this.hashColumns.put("is_pod_ata_replace", getIsPodAtaReplace());		
		this.hashColumns.put("pod_ata_event_dt", getPodAtaEventDt());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("v_error_code", "vErrorCode");
		this.hashFields.put("e_pol_loc", "ePolLoc");
		this.hashFields.put("cust_no", "custNo");
		this.hashFields.put("call_from", "callFrom");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("e_del_loc", "eDelLoc");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("cust_edi_sts_cd", "custEdiStsCd");
		this.hashFields.put("org_edi_sts_cd", "orgEdiStsCd");
		this.hashFields.put("v_message", "vMessage");
		this.hashFields.put("act_rcv_if_key", "actRcvIfKey");
		this.hashFields.put("cntr_no_1", "cntrNo1");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("e_cop_no", "eCopNo");
		this.hashFields.put("event_dt", "eventDt");
		this.hashFields.put("cust_tp_id", "custTpId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("group_seq", "groupSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cre_id", "creId");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("cnmv_full_flg", "cnmvFullFlg");
		this.hashFields.put("edi_snd_flg", "ediSndFlg");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("nod", "nod");
		this.hashFields.put("e_bkg_no", "eBkgNo");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("edi_grp_cd", "ediGrpCd");
		this.hashFields.put("e_pod_loc", "ePodLoc");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("curr_vvd", "currVvd");
		this.hashFields.put("rslt_snd_cnt", "rsltSndCnt");
		this.hashFields.put("snd_seq", "sndSeq");
		this.hashFields.put("edi_sts", "ediSts");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("edi_group_cd", "ediGroupCd");
		this.hashFields.put("issend_tp_cntr", "issendTpCntr");
		this.hashFields.put("cost_act_grp_seq", "costActGrpSeq");
		this.hashFields.put("v_bound", "vBound");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("e_por_loc", "ePorLoc");
		this.hashFields.put("edi_snd_itval_hr", "ediSndItvalHr");
		this.hashFields.put("upd_id", "updId");
		this.hashFields.put("host_tp_id", "hostTpId");
		this.hashFields.put("act_rcv_dt", "actRcvDt");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("chk_port_cd", "chkPortCd");	
		this.hashFields.put("is_pod_ata_replace", "isPodAtaReplace");		
		this.hashFields.put("pod_ata_event_dt", "podAtaEventDt");
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vErrorCode
	 */
	public String getVErrorCode() {
		return this.vErrorCode;
	}
	
	/**
	 * Column Info
	 * @return ePolLoc
	 */
	public String getEPolLoc() {
		return this.ePolLoc;
	}
	
	/**
	 * Column Info
	 * @return custNo
	 */
	public String getCustNo() {
		return this.custNo;
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
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @return eDelLoc
	 */
	public String getEDelLoc() {
		return this.eDelLoc;
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
	 * @return custEdiStsCd
	 */
	public String getCustEdiStsCd() {
		return this.custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return orgEdiStsCd
	 */
	public String getOrgEdiStsCd() {
		return this.orgEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return vMessage
	 */
	public String getVMessage() {
		return this.vMessage;
	}
	
	/**
	 * Column Info
	 * @return actRcvIfKey
	 */
	public String getActRcvIfKey() {
		return this.actRcvIfKey;
	}
	
	/**
	 * Column Info
	 * @return cntrNo1
	 */
	public String getCntrNo1() {
		return this.cntrNo1;
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
	 * @return eCopNo
	 */
	public String getECopNo() {
		return this.eCopNo;
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
	 * @return custTpId
	 */
	public String getCustTpId() {
		return this.custTpId;
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
	 * @return groupSeq
	 */
	public String getGroupSeq() {
		return this.groupSeq;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
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
	 * @return dtlSeq
	 */
	public String getDtlSeq() {
		return this.dtlSeq;
	}
	
	/**
	 * Column Info
	 * @return cnmvFullFlg
	 */
	public String getCnmvFullFlg() {
		return this.cnmvFullFlg;
	}
	
	/**
	 * Column Info
	 * @return ediSndFlg
	 */
	public String getEdiSndFlg() {
		return this.ediSndFlg;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return nod
	 */
	public String getNod() {
		return this.nod;
	}
	
	/**
	 * Column Info
	 * @return eBkgNo
	 */
	public String getEBkgNo() {
		return this.eBkgNo;
	}
	
	/**
	 * Column Info
	 * @return bkgNoSplit
	 */
	public String getBkgNoSplit() {
		return this.bkgNoSplit;
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
	 * @return ePodLoc
	 */
	public String getEPodLoc() {
		return this.ePodLoc;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
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
	 * @return rsltSndCnt
	 */
	public String getRsltSndCnt() {
		return this.rsltSndCnt;
	}
	
	/**
	 * Column Info
	 * @return sndSeq
	 */
	public String getSndSeq() {
		return this.sndSeq;
	}
	
	/**
	 * Column Info
	 * @return ediSts
	 */
	public String getEdiSts() {
		return this.ediSts;
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
	 * @return ediGroupCd
	 */
	public String getEdiGroupCd() {
		return this.ediGroupCd;
	}
	
	/**
	 * Column Info
	 * @return issendTpCntr
	 */
	public String getIssendTpCntr() {
		return this.issendTpCntr;
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
	 * @return vBound
	 */
	public String getVBound() {
		return this.vBound;
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
	 * @return ePorLoc
	 */
	public String getEPorLoc() {
		return this.ePorLoc;
	}
	
	/**
	 * Column Info
	 * @return ediSndItvalHr
	 */
	public String getEdiSndItvalHr() {
		return this.ediSndItvalHr;
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
	 * @return hostTpId
	 */
	public String getHostTpId() {
		return this.hostTpId;
	}
	
	/**
	 * Column Info
	 * @return actRcvDt
	 */
	public String getActRcvDt() {
		return this.actRcvDt;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	public String getChkPortCd(){
		return this.chkPortCd;
	}
	public String getIsPodAtaReplace(){
		return this.isPodAtaReplace;
	}
	public String getPodAtaEventDt(){
		return this.podAtaEventDt;
	}	
		
		
	/**
	 * Column Info
	 * @param vErrorCode
	 */
	public void setVErrorCode(String vErrorCode) {
		this.vErrorCode = vErrorCode;
	}
	
	/**
	 * Column Info
	 * @param ePolLoc
	 */
	public void setEPolLoc(String ePolLoc) {
		this.ePolLoc = ePolLoc;
	}
	
	/**
	 * Column Info
	 * @param custNo
	 */
	public void setCustNo(String custNo) {
		this.custNo = custNo;
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
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param eDelLoc
	 */
	public void setEDelLoc(String eDelLoc) {
		this.eDelLoc = eDelLoc;
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
	 * @param custEdiStsCd
	 */
	public void setCustEdiStsCd(String custEdiStsCd) {
		this.custEdiStsCd = custEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param orgEdiStsCd
	 */
	public void setOrgEdiStsCd(String orgEdiStsCd) {
		this.orgEdiStsCd = orgEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param vMessage
	 */
	public void setVMessage(String vMessage) {
		this.vMessage = vMessage;
	}
	
	/**
	 * Column Info
	 * @param actRcvIfKey
	 */
	public void setActRcvIfKey(String actRcvIfKey) {
		this.actRcvIfKey = actRcvIfKey;
	}
	
	/**
	 * Column Info
	 * @param cntrNo1
	 */
	public void setCntrNo1(String cntrNo1) {
		this.cntrNo1 = cntrNo1;
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
	 * @param eCopNo
	 */
	public void setECopNo(String eCopNo) {
		this.eCopNo = eCopNo;
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
	 * @param custTpId
	 */
	public void setCustTpId(String custTpId) {
		this.custTpId = custTpId;
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
	 * @param groupSeq
	 */
	public void setGroupSeq(String groupSeq) {
		this.groupSeq = groupSeq;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
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
	 * @param dtlSeq
	 */
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
	}
	
	/**
	 * Column Info
	 * @param cnmvFullFlg
	 */
	public void setCnmvFullFlg(String cnmvFullFlg) {
		this.cnmvFullFlg = cnmvFullFlg;
	}
	
	/**
	 * Column Info
	 * @param ediSndFlg
	 */
	public void setEdiSndFlg(String ediSndFlg) {
		this.ediSndFlg = ediSndFlg;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param nod
	 */
	public void setNod(String nod) {
		this.nod = nod;
	}
	
	/**
	 * Column Info
	 * @param eBkgNo
	 */
	public void setEBkgNo(String eBkgNo) {
		this.eBkgNo = eBkgNo;
	}
	
	/**
	 * Column Info
	 * @param bkgNoSplit
	 */
	public void setBkgNoSplit(String bkgNoSplit) {
		this.bkgNoSplit = bkgNoSplit;
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
	 * @param ePodLoc
	 */
	public void setEPodLoc(String ePodLoc) {
		this.ePodLoc = ePodLoc;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
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
	 * @param rsltSndCnt
	 */
	public void setRsltSndCnt(String rsltSndCnt) {
		this.rsltSndCnt = rsltSndCnt;
	}
	
	/**
	 * Column Info
	 * @param sndSeq
	 */
	public void setSndSeq(String sndSeq) {
		this.sndSeq = sndSeq;
	}
	
	/**
	 * Column Info
	 * @param ediSts
	 */
	public void setEdiSts(String ediSts) {
		this.ediSts = ediSts;
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
	 * @param ediGroupCd
	 */
	public void setEdiGroupCd(String ediGroupCd) {
		this.ediGroupCd = ediGroupCd;
	}
	
	/**
	 * Column Info
	 * @param issendTpCntr
	 */
	public void setIssendTpCntr(String issendTpCntr) {
		this.issendTpCntr = issendTpCntr;
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
	 * @param vBound
	 */
	public void setVBound(String vBound) {
		this.vBound = vBound;
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
	 * @param ePorLoc
	 */
	public void setEPorLoc(String ePorLoc) {
		this.ePorLoc = ePorLoc;
	}
	
	/**
	 * Column Info
	 * @param ediSndItvalHr
	 */
	public void setEdiSndItvalHr(String ediSndItvalHr) {
		this.ediSndItvalHr = ediSndItvalHr;
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
	 * @param hostTpId
	 */
	public void setHostTpId(String hostTpId) {
		this.hostTpId = hostTpId;
	}
	
	/**
	 * Column Info
	 * @param actRcvDt
	 */
	public void setActRcvDt(String actRcvDt) {
		this.actRcvDt = actRcvDt;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	public void setChkPortCd(String chkPortCd){
		this.chkPortCd = chkPortCd;
	}
	public void setIsPodAtaReplace(String isPodAtaReplace){
		this.isPodAtaReplace = isPodAtaReplace;
	}
	public void setPodAtaEventDt(String podAtaEventDt){
		this.podAtaEventDt = podAtaEventDt;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVErrorCode(JSPUtil.getParameter(request, "v_error_code", ""));
		setEPolLoc(JSPUtil.getParameter(request, "e_pol_loc", ""));
		setCustNo(JSPUtil.getParameter(request, "cust_no", ""));
		setCallFrom(JSPUtil.getParameter(request, "call_from", ""));
		setCnmvSeq(JSPUtil.getParameter(request, "cnmv_seq", ""));
		setEDelLoc(JSPUtil.getParameter(request, "e_del_loc", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setCustEdiStsCd(JSPUtil.getParameter(request, "cust_edi_sts_cd", ""));
		setOrgEdiStsCd(JSPUtil.getParameter(request, "org_edi_sts_cd", ""));
		setVMessage(JSPUtil.getParameter(request, "v_message", ""));
		setActRcvIfKey(JSPUtil.getParameter(request, "act_rcv_if_key", ""));
		setCntrNo1(JSPUtil.getParameter(request, "cntr_no_1", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setECopNo(JSPUtil.getParameter(request, "e_cop_no", ""));
		setEventDt(JSPUtil.getParameter(request, "event_dt", ""));
		setCustTpId(JSPUtil.getParameter(request, "cust_tp_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGroupSeq(JSPUtil.getParameter(request, "group_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCreId(JSPUtil.getParameter(request, "cre_id", ""));
		setDtlSeq(JSPUtil.getParameter(request, "dtl_seq", ""));
		setCnmvFullFlg(JSPUtil.getParameter(request, "cnmv_full_flg", ""));
		setEdiSndFlg(JSPUtil.getParameter(request, "edi_snd_flg", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setNod(JSPUtil.getParameter(request, "nod", ""));
		setEBkgNo(JSPUtil.getParameter(request, "e_bkg_no", ""));
		setBkgNoSplit(JSPUtil.getParameter(request, "bkg_no_split", ""));
		setEdiGrpCd(JSPUtil.getParameter(request, "edi_grp_cd", ""));
		setEPodLoc(JSPUtil.getParameter(request, "e_pod_loc", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setOrgYdCd(JSPUtil.getParameter(request, "org_yd_cd", ""));
		setCurrVvd(JSPUtil.getParameter(request, "curr_vvd", ""));
		setRsltSndCnt(JSPUtil.getParameter(request, "rslt_snd_cnt", ""));
		setSndSeq(JSPUtil.getParameter(request, "snd_seq", ""));
		setEdiSts(JSPUtil.getParameter(request, "edi_sts", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setEdiGroupCd(JSPUtil.getParameter(request, "edi_group_cd", ""));
		setIssendTpCntr(JSPUtil.getParameter(request, "issend_tp_cntr", ""));
		setCostActGrpSeq(JSPUtil.getParameter(request, "cost_act_grp_seq", ""));
		setVBound(JSPUtil.getParameter(request, "v_bound", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setEPorLoc(JSPUtil.getParameter(request, "e_por_loc", ""));
		setEdiSndItvalHr(JSPUtil.getParameter(request, "edi_snd_itval_hr", ""));
		setUpdId(JSPUtil.getParameter(request, "upd_id", ""));
		setHostTpId(JSPUtil.getParameter(request, "host_tp_id", ""));
		setActRcvDt(JSPUtil.getParameter(request, "act_rcv_dt", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setChkPortCd(JSPUtil.getParameter(request, "chk_port_cd", ""));	
		setIsPodAtaReplace(JSPUtil.getParameter(request, "is_pod_ata_replace", ""));		
		setPodAtaEventDt(JSPUtil.getParameter(request, "pod_ata_event_dt", ""));		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315SendOptionsVO[]
	 */
	public Edi315SendOptionsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315SendOptionsVO[]
	 */
	public Edi315SendOptionsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315SendOptionsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vErrorCode = (JSPUtil.getParameter(request, prefix	+ "v_error_code", length));
			String[] ePolLoc = (JSPUtil.getParameter(request, prefix	+ "e_pol_loc", length));
			String[] custNo = (JSPUtil.getParameter(request, prefix	+ "cust_no", length));
			String[] callFrom = (JSPUtil.getParameter(request, prefix	+ "call_from", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] eDelLoc = (JSPUtil.getParameter(request, prefix	+ "e_del_loc", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] custEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "cust_edi_sts_cd", length));
			String[] orgEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "org_edi_sts_cd", length));
			String[] vMessage = (JSPUtil.getParameter(request, prefix	+ "v_message", length));
			String[] actRcvIfKey = (JSPUtil.getParameter(request, prefix	+ "act_rcv_if_key", length));
			String[] cntrNo1 = (JSPUtil.getParameter(request, prefix	+ "cntr_no_1", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eCopNo = (JSPUtil.getParameter(request, prefix	+ "e_cop_no", length));
			String[] eventDt = (JSPUtil.getParameter(request, prefix	+ "event_dt", length));
			String[] custTpId = (JSPUtil.getParameter(request, prefix	+ "cust_tp_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] groupSeq = (JSPUtil.getParameter(request, prefix	+ "group_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] creId = (JSPUtil.getParameter(request, prefix	+ "cre_id", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] cnmvFullFlg = (JSPUtil.getParameter(request, prefix	+ "cnmv_full_flg", length));
			String[] ediSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_flg", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] nod = (JSPUtil.getParameter(request, prefix	+ "nod", length));
			String[] eBkgNo = (JSPUtil.getParameter(request, prefix	+ "e_bkg_no", length));
			String[] bkgNoSplit = (JSPUtil.getParameter(request, prefix	+ "bkg_no_split", length));
			String[] ediGrpCd = (JSPUtil.getParameter(request, prefix	+ "edi_grp_cd", length));
			String[] ePodLoc = (JSPUtil.getParameter(request, prefix	+ "e_pod_loc", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] currVvd = (JSPUtil.getParameter(request, prefix	+ "curr_vvd", length));
			String[] rsltSndCnt = (JSPUtil.getParameter(request, prefix	+ "rslt_snd_cnt", length));
			String[] sndSeq = (JSPUtil.getParameter(request, prefix	+ "snd_seq", length));
			String[] ediSts = (JSPUtil.getParameter(request, prefix	+ "edi_sts", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ediGroupCd = (JSPUtil.getParameter(request, prefix	+ "edi_group_cd", length));
			String[] issendTpCntr = (JSPUtil.getParameter(request, prefix	+ "issend_tp_cntr", length));
			String[] costActGrpSeq = (JSPUtil.getParameter(request, prefix	+ "cost_act_grp_seq", length));
			String[] vBound = (JSPUtil.getParameter(request, prefix	+ "v_bound", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ePorLoc = (JSPUtil.getParameter(request, prefix	+ "e_por_loc", length));
			String[] ediSndItvalHr = (JSPUtil.getParameter(request, prefix	+ "edi_snd_itval_hr", length));
			String[] updId = (JSPUtil.getParameter(request, prefix	+ "upd_id", length));
			String[] hostTpId = (JSPUtil.getParameter(request, prefix	+ "host_tp_id", length));
			String[] actRcvDt = (JSPUtil.getParameter(request, prefix	+ "act_rcv_dt", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] chkPortCd = (JSPUtil.getParameter(request, prefix	+ "chk_port_cd", length));			
			String[] isPodAtaReplace = (JSPUtil.getParameter(request, prefix	+ "is_pod_ata_replace", length));
			String[] podAtaEventDt = (JSPUtil.getParameter(request, prefix	+ "pod_ata_event_dt", length));			
			
			for (int i = 0; i < length; i++) {
				model = new Edi315SendOptionsVO();
				if (vErrorCode[i] != null)
					model.setVErrorCode(vErrorCode[i]);
				if (ePolLoc[i] != null)
					model.setEPolLoc(ePolLoc[i]);
				if (custNo[i] != null)
					model.setCustNo(custNo[i]);
				if (callFrom[i] != null)
					model.setCallFrom(callFrom[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (eDelLoc[i] != null)
					model.setEDelLoc(eDelLoc[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (custEdiStsCd[i] != null)
					model.setCustEdiStsCd(custEdiStsCd[i]);
				if (orgEdiStsCd[i] != null)
					model.setOrgEdiStsCd(orgEdiStsCd[i]);
				if (vMessage[i] != null)
					model.setVMessage(vMessage[i]);
				if (actRcvIfKey[i] != null)
					model.setActRcvIfKey(actRcvIfKey[i]);
				if (cntrNo1[i] != null)
					model.setCntrNo1(cntrNo1[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eCopNo[i] != null)
					model.setECopNo(eCopNo[i]);
				if (eventDt[i] != null)
					model.setEventDt(eventDt[i]);
				if (custTpId[i] != null)
					model.setCustTpId(custTpId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (groupSeq[i] != null)
					model.setGroupSeq(groupSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (creId[i] != null)
					model.setCreId(creId[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (cnmvFullFlg[i] != null)
					model.setCnmvFullFlg(cnmvFullFlg[i]);
				if (ediSndFlg[i] != null)
					model.setEdiSndFlg(ediSndFlg[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (nod[i] != null)
					model.setNod(nod[i]);
				if (eBkgNo[i] != null)
					model.setEBkgNo(eBkgNo[i]);
				if (bkgNoSplit[i] != null)
					model.setBkgNoSplit(bkgNoSplit[i]);
				if (ediGrpCd[i] != null)
					model.setEdiGrpCd(ediGrpCd[i]);
				if (ePodLoc[i] != null)
					model.setEPodLoc(ePodLoc[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (currVvd[i] != null)
					model.setCurrVvd(currVvd[i]);
				if (rsltSndCnt[i] != null)
					model.setRsltSndCnt(rsltSndCnt[i]);
				if (sndSeq[i] != null)
					model.setSndSeq(sndSeq[i]);
				if (ediSts[i] != null)
					model.setEdiSts(ediSts[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ediGroupCd[i] != null)
					model.setEdiGroupCd(ediGroupCd[i]);
				if (issendTpCntr[i] != null)
					model.setIssendTpCntr(issendTpCntr[i]);
				if (costActGrpSeq[i] != null)
					model.setCostActGrpSeq(costActGrpSeq[i]);
				if (vBound[i] != null)
					model.setVBound(vBound[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ePorLoc[i] != null)
					model.setEPorLoc(ePorLoc[i]);
				if (ediSndItvalHr[i] != null)
					model.setEdiSndItvalHr(ediSndItvalHr[i]);
				if (updId[i] != null)
					model.setUpdId(updId[i]);
				if (hostTpId[i] != null)
					model.setHostTpId(hostTpId[i]);
				if (actRcvDt[i] != null)
					model.setActRcvDt(actRcvDt[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (chkPortCd[i] != null)
					model.setChkPortCd(chkPortCd[i]);	
				if (isPodAtaReplace[i] != null)
					model.setIsPodAtaReplace(isPodAtaReplace[i]);				
				if (podAtaEventDt[i] != null)
					model.setPodAtaEventDt(podAtaEventDt[i]);					

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315SendOptionsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315SendOptionsVO[]
	 */
	public Edi315SendOptionsVO[] getEdi315SendOptionsVOs(){
		Edi315SendOptionsVO[] vos = (Edi315SendOptionsVO[])models.toArray(new Edi315SendOptionsVO[models.size()]);
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
		this.vErrorCode = this.vErrorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ePolLoc = this.ePolLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNo = this.custNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callFrom = this.callFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eDelLoc = this.eDelLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEdiStsCd = this.custEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgEdiStsCd = this.orgEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vMessage = this.vMessage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvIfKey = this.actRcvIfKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo1 = this.cntrNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eCopNo = this.eCopNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventDt = this.eventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpId = this.custTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupSeq = this.groupSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creId = this.creId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvFullFlg = this.cnmvFullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndFlg = this.ediSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nod = this.nod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eBkgNo = this.eBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit = this.bkgNoSplit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrpCd = this.ediGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ePodLoc = this.ePodLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currVvd = this.currVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltSndCnt = this.rsltSndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndSeq = this.sndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSts = this.ediSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGroupCd = this.ediGroupCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issendTpCntr = this.issendTpCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costActGrpSeq = this.costActGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vBound = this.vBound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ePorLoc = this.ePorLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndItvalHr = this.ediSndItvalHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updId = this.updId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hostTpId = this.hostTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actRcvDt = this.actRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPortCd = this.chkPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isPodAtaReplace = this.isPodAtaReplace .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		this.podAtaEventDt = this.podAtaEventDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
				
	}
}
