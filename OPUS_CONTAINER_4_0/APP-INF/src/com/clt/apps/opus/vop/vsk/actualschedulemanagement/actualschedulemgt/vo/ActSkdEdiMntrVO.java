/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ActSkdEdiMntrVO.java
*@FileTitle : ActSkdEdiMntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 정진우
*@LastVersion : 1.0
* 2010.03.12 정진우 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 정진우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ActSkdEdiMntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ActSkdEdiMntrVO> models = new ArrayList<ActSkdEdiMntrVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String actBrthDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rcvSeq = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String actArrDt = null;
	/* Column Info */
	private String tmlCd = null;
	/* Column Info */
	private String ediMsgProcId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vopPortRhqCd = null;
	/* Column Info */
	private String vskdPortRhqCd = null;
	/* Column Info */
	private String ediVvd = null;
	/* Column Info */
	private String ediVslNm = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String rsltMsg = null;
	/* Column Info */
	private String slsOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String shpCallNo = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String sndrTrdPrnrId = null;
	/* Column Info */
	private String scsFlg = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ediSkdVoyNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ediActArrDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ediSkdDirNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String actDepDt = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String ediActDepDt = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String ediActBrthDt = null;
	/* Column Info */
	private String rcvrTrdPrnrId = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String ediMsgTpId = null;

	private String dchgCmplDt = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ActSkdEdiMntrVO() {}

	public ActSkdEdiMntrVO(String ibflag, String pagerows, String rcvSeq, String vslSlanCd, String vpsPortCd, String clptIndSeq, String ydCd, String tmlCd, String ediVslNm, String ediSkdVoyNo, String ediSkdDirNm, String ediVvd, String vslCd, String skdVoyNo, String skdDirCd, String vvd, String ediActArrDt, String ediActBrthDt, String ediActDepDt, String actArrDt, String actBrthDt, String actDepDt, String rcvDt, String scsFlg, String rsltMsg, String sndrTrdPrnrId, String rcvrTrdPrnrId, String ediMsgTpId, String ediMsgProcId, String lloydNo, String callSgnNo, String shpCallNo, String creUsrId, String creDt, String updUsrId, String updDt, String fmDt, String toDt, String vopPortRhqCd, String vskdPortRhqCd, String slsOfcCd) {
		this.vslCd = vslCd;
		this.actBrthDt = actBrthDt;
		this.creDt = creDt;
		this.rcvSeq = rcvSeq;
		this.vslSlanCd = vslSlanCd;
		this.actArrDt = actArrDt;
		this.tmlCd = tmlCd;
		this.ediMsgProcId = ediMsgProcId;
		this.pagerows = pagerows;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.vopPortRhqCd = vopPortRhqCd;
		this.vskdPortRhqCd = vskdPortRhqCd;
		this.ediVvd = ediVvd;
		this.ediVslNm = ediVslNm;
		this.rcvDt = rcvDt;
		this.rsltMsg = rsltMsg;
		this.slsOfcCd = slsOfcCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.shpCallNo = shpCallNo;
		this.fmDt = fmDt;
		this.sndrTrdPrnrId = sndrTrdPrnrId;
		this.scsFlg = scsFlg;
		this.callSgnNo = callSgnNo;
		this.ediSkdVoyNo = ediSkdVoyNo;
		this.skdVoyNo = skdVoyNo;
		this.ediActArrDt = ediActArrDt;
		this.skdDirCd = skdDirCd;
		this.toDt = toDt;
		this.vvd = vvd;
		this.ediSkdDirNm = ediSkdDirNm;
		this.creUsrId = creUsrId;
		this.actDepDt = actDepDt;
		this.lloydNo = lloydNo;
		this.ediActDepDt = ediActDepDt;
		this.ydCd = ydCd;
		this.ediActBrthDt = ediActBrthDt;
		this.rcvrTrdPrnrId = rcvrTrdPrnrId;
		this.clptIndSeq = clptIndSeq;
		this.ediMsgTpId = ediMsgTpId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("act_brth_dt", getActBrthDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rcv_seq", getRcvSeq());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("act_arr_dt", getActArrDt());
		this.hashColumns.put("tml_cd", getTmlCd());
		this.hashColumns.put("edi_msg_proc_id", getEdiMsgProcId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vop_port_rhq_cd", getVopPortRhqCd());
		this.hashColumns.put("vskd_port_rhq_cd", getVskdPortRhqCd());
		this.hashColumns.put("edi_vvd", getEdiVvd());
		this.hashColumns.put("edi_vsl_nm", getEdiVslNm());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("rslt_msg", getRsltMsg());
		this.hashColumns.put("sls_ofc_cd", getSlsOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("shp_call_no", getShpCallNo());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("sndr_trd_prnr_id", getSndrTrdPrnrId());
		this.hashColumns.put("scs_flg", getScsFlg());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("edi_skd_voy_no", getEdiSkdVoyNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("edi_act_arr_dt", getEdiActArrDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("edi_skd_dir_nm", getEdiSkdDirNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("act_dep_dt", getActDepDt());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("edi_act_dep_dt", getEdiActDepDt());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("edi_act_brth_dt", getEdiActBrthDt());
		this.hashColumns.put("rcvr_trd_prnr_id", getRcvrTrdPrnrId());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("edi_msg_tp_id", getEdiMsgTpId());
		
		this.hashColumns.put("dchg_cmpl_dt"	 , getDchgCmplDt());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("act_brth_dt", "actBrthDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rcv_seq", "rcvSeq");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("act_arr_dt", "actArrDt");
		this.hashFields.put("tml_cd", "tmlCd");
		this.hashFields.put("edi_msg_proc_id", "ediMsgProcId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vop_port_rhq_cd", "vopPortRhqCd");
		this.hashFields.put("vskd_port_rhq_cd", "vskdPortRhqCd");
		this.hashFields.put("edi_vvd", "ediVvd");
		this.hashFields.put("edi_vsl_nm", "ediVslNm");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("rslt_msg", "rsltMsg");
		this.hashFields.put("sls_ofc_cd", "slsOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("shp_call_no", "shpCallNo");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("sndr_trd_prnr_id", "sndrTrdPrnrId");
		this.hashFields.put("scs_flg", "scsFlg");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("edi_skd_voy_no", "ediSkdVoyNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("edi_act_arr_dt", "ediActArrDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("edi_skd_dir_nm", "ediSkdDirNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("act_dep_dt", "actDepDt");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("edi_act_dep_dt", "ediActDepDt");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("edi_act_brth_dt", "ediActBrthDt");
		this.hashFields.put("rcvr_trd_prnr_id", "rcvrTrdPrnrId");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("edi_msg_tp_id", "ediMsgTpId");
		
		this.hashFields.put("dchg_cmpl_dt"		, "dchgCmplDt" );
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return actBrthDt
	 */
	public String getActBrthDt() {
		return this.actBrthDt;
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
	 * @return rcvSeq
	 */
	public String getRcvSeq() {
		return this.rcvSeq;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return actArrDt
	 */
	public String getActArrDt() {
		return this.actArrDt;
	}
	
	/**
	 * Column Info
	 * @return tmlCd
	 */
	public String getTmlCd() {
		return this.tmlCd;
	}
	
	/**
	 * Column Info
	 * @return ediMsgProcId
	 */
	public String getEdiMsgProcId() {
		return this.ediMsgProcId;
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
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return vopPortRhqCd
	 */
	public String getVopPortRhqCd() {
		return this.vopPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @return vskdPortRhqCd
	 */
	public String getVskdPortRhqCd() {
		return this.vskdPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @return ediVvd
	 */
	public String getEdiVvd() {
		return this.ediVvd;
	}
	
	/**
	 * Column Info
	 * @return ediVslNm
	 */
	public String getEdiVslNm() {
		return this.ediVslNm;
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
	 * @return rsltMsg
	 */
	public String getRsltMsg() {
		return this.rsltMsg;
	}
	
	/**
	 * Column Info
	 * @return slsOfcCd
	 */
	public String getSlsOfcCd() {
		return this.slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return shpCallNo
	 */
	public String getShpCallNo() {
		return this.shpCallNo;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return sndrTrdPrnrId
	 */
	public String getSndrTrdPrnrId() {
		return this.sndrTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @return scsFlg
	 */
	public String getScsFlg() {
		return this.scsFlg;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return ediSkdVoyNo
	 */
	public String getEdiSkdVoyNo() {
		return this.ediSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return ediActArrDt
	 */
	public String getEdiActArrDt() {
		return this.ediActArrDt;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ediSkdDirNm
	 */
	public String getEdiSkdDirNm() {
		return this.ediSkdDirNm;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return actDepDt
	 */
	public String getActDepDt() {
		return this.actDepDt;
	}
	
	/**
	 * Column Info
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return ediActDepDt
	 */
	public String getEdiActDepDt() {
		return this.ediActDepDt;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return ediActBrthDt
	 */
	public String getEdiActBrthDt() {
		return this.ediActBrthDt;
	}
	
	/**
	 * Column Info
	 * @return rcvrTrdPrnrId
	 */
	public String getRcvrTrdPrnrId() {
		return this.rcvrTrdPrnrId;
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
	 * @return ediMsgTpId
	 */
	public String getEdiMsgTpId() {
		return this.ediMsgTpId;
	}
	
	
	
	
	public String getDchgCmplDt() {
		return this.dchgCmplDt;
	}

	public void setDchgCmplDt(String dchgCmplDt) {
		this.dchgCmplDt = dchgCmplDt;
	}
	
	
	

	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param actBrthDt
	 */
	public void setActBrthDt(String actBrthDt) {
		this.actBrthDt = actBrthDt;
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
	 * @param rcvSeq
	 */
	public void setRcvSeq(String rcvSeq) {
		this.rcvSeq = rcvSeq;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param actArrDt
	 */
	public void setActArrDt(String actArrDt) {
		this.actArrDt = actArrDt;
	}
	
	/**
	 * Column Info
	 * @param tmlCd
	 */
	public void setTmlCd(String tmlCd) {
		this.tmlCd = tmlCd;
	}
	
	/**
	 * Column Info
	 * @param ediMsgProcId
	 */
	public void setEdiMsgProcId(String ediMsgProcId) {
		this.ediMsgProcId = ediMsgProcId;
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
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param vopPortRhqCd
	 */
	public void setVopPortRhqCd(String vopPortRhqCd) {
		this.vopPortRhqCd = vopPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @param vskdPortRhqCd
	 */
	public void setVskdPortRhqCd(String vskdPortRhqCd) {
		this.vskdPortRhqCd = vskdPortRhqCd;
	}
	
	/**
	 * Column Info
	 * @param ediVvd
	 */
	public void setEdiVvd(String ediVvd) {
		this.ediVvd = ediVvd;
	}
	
	/**
	 * Column Info
	 * @param ediVslNm
	 */
	public void setEdiVslNm(String ediVslNm) {
		this.ediVslNm = ediVslNm;
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
	 * @param rsltMsg
	 */
	public void setRsltMsg(String rsltMsg) {
		this.rsltMsg = rsltMsg;
	}
	
	/**
	 * Column Info
	 * @param slsOfcCd
	 */
	public void setSlsOfcCd(String slsOfcCd) {
		this.slsOfcCd = slsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param shpCallNo
	 */
	public void setShpCallNo(String shpCallNo) {
		this.shpCallNo = shpCallNo;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param sndrTrdPrnrId
	 */
	public void setSndrTrdPrnrId(String sndrTrdPrnrId) {
		this.sndrTrdPrnrId = sndrTrdPrnrId;
	}
	
	/**
	 * Column Info
	 * @param scsFlg
	 */
	public void setScsFlg(String scsFlg) {
		this.scsFlg = scsFlg;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param ediSkdVoyNo
	 */
	public void setEdiSkdVoyNo(String ediSkdVoyNo) {
		this.ediSkdVoyNo = ediSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param ediActArrDt
	 */
	public void setEdiActArrDt(String ediActArrDt) {
		this.ediActArrDt = ediActArrDt;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ediSkdDirNm
	 */
	public void setEdiSkdDirNm(String ediSkdDirNm) {
		this.ediSkdDirNm = ediSkdDirNm;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param actDepDt
	 */
	public void setActDepDt(String actDepDt) {
		this.actDepDt = actDepDt;
	}
	
	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param ediActDepDt
	 */
	public void setEdiActDepDt(String ediActDepDt) {
		this.ediActDepDt = ediActDepDt;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param ediActBrthDt
	 */
	public void setEdiActBrthDt(String ediActBrthDt) {
		this.ediActBrthDt = ediActBrthDt;
	}
	
	/**
	 * Column Info
	 * @param rcvrTrdPrnrId
	 */
	public void setRcvrTrdPrnrId(String rcvrTrdPrnrId) {
		this.rcvrTrdPrnrId = rcvrTrdPrnrId;
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
	 * @param ediMsgTpId
	 */
	public void setEdiMsgTpId(String ediMsgTpId) {
		this.ediMsgTpId = ediMsgTpId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setActBrthDt(JSPUtil.getParameter(request, "act_brth_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRcvSeq(JSPUtil.getParameter(request, "rcv_seq", ""));
		setVslSlanCd(JSPUtil.getParameter(request, "vsl_slan_cd", ""));
		setActArrDt(JSPUtil.getParameter(request, "act_arr_dt", ""));
		setTmlCd(JSPUtil.getParameter(request, "tml_cd", ""));
		setEdiMsgProcId(JSPUtil.getParameter(request, "edi_msg_proc_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVopPortRhqCd(JSPUtil.getParameter(request, "vop_port_rhq_cd", ""));
		setVskdPortRhqCd(JSPUtil.getParameter(request, "vskd_port_rhq_cd", ""));
		setEdiVvd(JSPUtil.getParameter(request, "edi_vvd", ""));
		setEdiVslNm(JSPUtil.getParameter(request, "edi_vsl_nm", ""));
		setRcvDt(JSPUtil.getParameter(request, "rcv_dt", ""));
		setRsltMsg(JSPUtil.getParameter(request, "rslt_msg", ""));
		setSlsOfcCd(JSPUtil.getParameter(request, "sls_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setShpCallNo(JSPUtil.getParameter(request, "shp_call_no", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setSndrTrdPrnrId(JSPUtil.getParameter(request, "sndr_trd_prnr_id", ""));
		setScsFlg(JSPUtil.getParameter(request, "scs_flg", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setEdiSkdVoyNo(JSPUtil.getParameter(request, "edi_skd_voy_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setEdiActArrDt(JSPUtil.getParameter(request, "edi_act_arr_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setEdiSkdDirNm(JSPUtil.getParameter(request, "edi_skd_dir_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setActDepDt(JSPUtil.getParameter(request, "act_dep_dt", ""));
		setLloydNo(JSPUtil.getParameter(request, "lloyd_no", ""));
		setEdiActDepDt(JSPUtil.getParameter(request, "edi_act_dep_dt", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setEdiActBrthDt(JSPUtil.getParameter(request, "edi_act_brth_dt", ""));
		setRcvrTrdPrnrId(JSPUtil.getParameter(request, "rcvr_trd_prnr_id", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setEdiMsgTpId(JSPUtil.getParameter(request, "edi_msg_tp_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActSkdEdiMntrVO[]
	 */
	public ActSkdEdiMntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ActSkdEdiMntrVO[]
	 */
	public ActSkdEdiMntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ActSkdEdiMntrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] actBrthDt = (JSPUtil.getParameter(request, prefix	+ "act_brth_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rcvSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_seq", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] actArrDt = (JSPUtil.getParameter(request, prefix	+ "act_arr_dt", length));
			String[] tmlCd = (JSPUtil.getParameter(request, prefix	+ "tml_cd", length));
			String[] ediMsgProcId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_proc_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vopPortRhqCd = (JSPUtil.getParameter(request, prefix	+ "vop_port_rhq_cd", length));
			String[] vskdPortRhqCd = (JSPUtil.getParameter(request, prefix	+ "vskd_port_rhq_cd", length));
			String[] ediVvd = (JSPUtil.getParameter(request, prefix	+ "edi_vvd", length));
			String[] ediVslNm = (JSPUtil.getParameter(request, prefix	+ "edi_vsl_nm", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] rsltMsg = (JSPUtil.getParameter(request, prefix	+ "rslt_msg", length));
			String[] slsOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] shpCallNo = (JSPUtil.getParameter(request, prefix	+ "shp_call_no", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] sndrTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "sndr_trd_prnr_id", length));
			String[] scsFlg = (JSPUtil.getParameter(request, prefix	+ "scs_flg", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ediSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "edi_skd_voy_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] ediActArrDt = (JSPUtil.getParameter(request, prefix	+ "edi_act_arr_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ediSkdDirNm = (JSPUtil.getParameter(request, prefix	+ "edi_skd_dir_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] actDepDt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] ediActDepDt = (JSPUtil.getParameter(request, prefix	+ "edi_act_dep_dt", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] ediActBrthDt = (JSPUtil.getParameter(request, prefix	+ "edi_act_brth_dt", length));
			String[] rcvrTrdPrnrId = (JSPUtil.getParameter(request, prefix	+ "rcvr_trd_prnr_id", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] ediMsgTpId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ActSkdEdiMntrVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (actBrthDt[i] != null)
					model.setActBrthDt(actBrthDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rcvSeq[i] != null)
					model.setRcvSeq(rcvSeq[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (actArrDt[i] != null)
					model.setActArrDt(actArrDt[i]);
				if (tmlCd[i] != null)
					model.setTmlCd(tmlCd[i]);
				if (ediMsgProcId[i] != null)
					model.setEdiMsgProcId(ediMsgProcId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vopPortRhqCd[i] != null)
					model.setVopPortRhqCd(vopPortRhqCd[i]);
				if (vskdPortRhqCd[i] != null)
					model.setVskdPortRhqCd(vskdPortRhqCd[i]);
				if (ediVvd[i] != null)
					model.setEdiVvd(ediVvd[i]);
				if (ediVslNm[i] != null)
					model.setEdiVslNm(ediVslNm[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (rsltMsg[i] != null)
					model.setRsltMsg(rsltMsg[i]);
				if (slsOfcCd[i] != null)
					model.setSlsOfcCd(slsOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (shpCallNo[i] != null)
					model.setShpCallNo(shpCallNo[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (sndrTrdPrnrId[i] != null)
					model.setSndrTrdPrnrId(sndrTrdPrnrId[i]);
				if (scsFlg[i] != null)
					model.setScsFlg(scsFlg[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ediSkdVoyNo[i] != null)
					model.setEdiSkdVoyNo(ediSkdVoyNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ediActArrDt[i] != null)
					model.setEdiActArrDt(ediActArrDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ediSkdDirNm[i] != null)
					model.setEdiSkdDirNm(ediSkdDirNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (actDepDt[i] != null)
					model.setActDepDt(actDepDt[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (ediActDepDt[i] != null)
					model.setEdiActDepDt(ediActDepDt[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (ediActBrthDt[i] != null)
					model.setEdiActBrthDt(ediActBrthDt[i]);
				if (rcvrTrdPrnrId[i] != null)
					model.setRcvrTrdPrnrId(rcvrTrdPrnrId[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (ediMsgTpId[i] != null)
					model.setEdiMsgTpId(ediMsgTpId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getActSkdEdiMntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ActSkdEdiMntrVO[]
	 */
	public ActSkdEdiMntrVO[] getActSkdEdiMntrVOs(){
		ActSkdEdiMntrVO[] vos = (ActSkdEdiMntrVO[])models.toArray(new ActSkdEdiMntrVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actBrthDt = this.actBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvSeq = this.rcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actArrDt = this.actArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCd = this.tmlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgProcId = this.ediMsgProcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vopPortRhqCd = this.vopPortRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdPortRhqCd = this.vskdPortRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVvd = this.ediVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVslNm = this.ediVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltMsg = this.rsltMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsOfcCd = this.slsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpCallNo = this.shpCallNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrTrdPrnrId = this.sndrTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scsFlg = this.scsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSkdVoyNo = this.ediSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediActArrDt = this.ediActArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSkdDirNm = this.ediSkdDirNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDt = this.actDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediActDepDt = this.ediActDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediActBrthDt = this.ediActBrthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrTrdPrnrId = this.rcvrTrdPrnrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpId = this.ediMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
