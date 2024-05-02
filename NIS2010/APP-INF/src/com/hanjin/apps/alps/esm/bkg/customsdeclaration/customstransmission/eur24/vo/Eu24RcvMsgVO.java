/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Eu24RcvMsgVO.java
*@FileTitle : Eu24RcvMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.21 김보배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.vo;

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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Eu24RcvMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Eu24RcvMsgVO> models = new ArrayList<Eu24RcvMsgVO>();
	
	/* Column Info */
	private String eurEdiMsgTpId = null;
	/* Column Info */
	private String ediRcvDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ediRcvSeq = null;
	/* Column Info */
	private String cstmsErrId = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String msgRcvNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String eurCstmsAckCd = null;
	/* Column Info */
	private String rcvLogErrSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ediRcvMsgCtnt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String ediSndMsgNm = null;
	/* Column Info */
	private String mvmtRefNo = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cstmsErrRefNo2 = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rjctRsnRmk = null;
	/* Column Info */
	private String cstmsErrRefNo1 = null;
	/* Column Info */
	private String ackDt = null;
	/* Column Info */
	private String eurCstmsRjctCd = null;
	/* Column Info */
	private String msgAcptRefNo = null;
	/* Column Info */
	private String rcvTms = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String cstmsErrMsg = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String ackRcvStsCd = null;
	/* Column Info */
	private String rjctDt = null;
	/* Column Info */
	private String ediMsgTpId = null;
	/* Column Info */
	private String ackKndId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Eu24RcvMsgVO() {}

	public Eu24RcvMsgVO(String ibflag, String pagerows, String ediRcvDt, String ediRcvSeq, String eurEdiMsgTpId, String ediSndMsgNm, String msgRcvNo, String vslCd, String skdVoyNo, String skdDirCd, String cstmsPortCd, String blNo, String ackKndId, String ackRcvStsCd, String eurCstmsAckCd, String ackDt, String aproDt, String msgAcptRefNo, String mvmtRefNo, String eurCstmsRjctCd, String rjctRsnRmk, String rjctDt, String creUsrId, String creDt, String updUsrId, String updDt, String ediRcvMsgCtnt, String rcvLogErrSeq, String cstmsErrId, String cstmsErrMsg, String cstmsErrRefNo1, String cstmsErrRefNo2, String cntCd, String ediMsgTpId, String rcvTms) {
		this.eurEdiMsgTpId = eurEdiMsgTpId;
		this.ediRcvDt = ediRcvDt;
		this.vslCd = vslCd;
		this.ediRcvSeq = ediRcvSeq;
		this.cstmsErrId = cstmsErrId;
		this.creDt = creDt;
		this.msgRcvNo = msgRcvNo;
		this.blNo = blNo;
		this.eurCstmsAckCd = eurCstmsAckCd;
		this.rcvLogErrSeq = rcvLogErrSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ediRcvMsgCtnt = ediRcvMsgCtnt;
		this.cntCd = cntCd;
		this.ediSndMsgNm = ediSndMsgNm;
		this.mvmtRefNo = mvmtRefNo;
		this.cstmsPortCd = cstmsPortCd;
		this.updUsrId = updUsrId;
		this.cstmsErrRefNo2 = cstmsErrRefNo2;
		this.updDt = updDt;
		this.rjctRsnRmk = rjctRsnRmk;
		this.cstmsErrRefNo1 = cstmsErrRefNo1;
		this.ackDt = ackDt;
		this.eurCstmsRjctCd = eurCstmsRjctCd;
		this.msgAcptRefNo = msgAcptRefNo;
		this.rcvTms = rcvTms;
		this.skdVoyNo = skdVoyNo;
		this.cstmsErrMsg = cstmsErrMsg;
		this.aproDt = aproDt;
		this.skdDirCd = skdDirCd;
		this.creUsrId = creUsrId;
		this.ackRcvStsCd = ackRcvStsCd;
		this.rjctDt = rjctDt;
		this.ediMsgTpId = ediMsgTpId;
		this.ackKndId = ackKndId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eur_edi_msg_tp_id", getEurEdiMsgTpId());
		this.hashColumns.put("edi_rcv_dt", getEdiRcvDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("edi_rcv_seq", getEdiRcvSeq());
		this.hashColumns.put("cstms_err_id", getCstmsErrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("msg_rcv_no", getMsgRcvNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("eur_cstms_ack_cd", getEurCstmsAckCd());
		this.hashColumns.put("rcv_log_err_seq", getRcvLogErrSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edi_rcv_msg_ctnt", getEdiRcvMsgCtnt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("edi_snd_msg_nm", getEdiSndMsgNm());
		this.hashColumns.put("mvmt_ref_no", getMvmtRefNo());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cstms_err_ref_no2", getCstmsErrRefNo2());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rjct_rsn_rmk", getRjctRsnRmk());
		this.hashColumns.put("cstms_err_ref_no1", getCstmsErrRefNo1());
		this.hashColumns.put("ack_dt", getAckDt());
		this.hashColumns.put("eur_cstms_rjct_cd", getEurCstmsRjctCd());
		this.hashColumns.put("msg_acpt_ref_no", getMsgAcptRefNo());
		this.hashColumns.put("rcv_tms", getRcvTms());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("cstms_err_msg", getCstmsErrMsg());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ack_rcv_sts_cd", getAckRcvStsCd());
		this.hashColumns.put("rjct_dt", getRjctDt());
		this.hashColumns.put("edi_msg_tp_id", getEdiMsgTpId());
		this.hashColumns.put("ack_knd_id", getAckKndId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eur_edi_msg_tp_id", "eurEdiMsgTpId");
		this.hashFields.put("edi_rcv_dt", "ediRcvDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("edi_rcv_seq", "ediRcvSeq");
		this.hashFields.put("cstms_err_id", "cstmsErrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("msg_rcv_no", "msgRcvNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("eur_cstms_ack_cd", "eurCstmsAckCd");
		this.hashFields.put("rcv_log_err_seq", "rcvLogErrSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edi_rcv_msg_ctnt", "ediRcvMsgCtnt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("edi_snd_msg_nm", "ediSndMsgNm");
		this.hashFields.put("mvmt_ref_no", "mvmtRefNo");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cstms_err_ref_no2", "cstmsErrRefNo2");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rjct_rsn_rmk", "rjctRsnRmk");
		this.hashFields.put("cstms_err_ref_no1", "cstmsErrRefNo1");
		this.hashFields.put("ack_dt", "ackDt");
		this.hashFields.put("eur_cstms_rjct_cd", "eurCstmsRjctCd");
		this.hashFields.put("msg_acpt_ref_no", "msgAcptRefNo");
		this.hashFields.put("rcv_tms", "rcvTms");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cstms_err_msg", "cstmsErrMsg");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ack_rcv_sts_cd", "ackRcvStsCd");
		this.hashFields.put("rjct_dt", "rjctDt");
		this.hashFields.put("edi_msg_tp_id", "ediMsgTpId");
		this.hashFields.put("ack_knd_id", "ackKndId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eurEdiMsgTpId
	 */
	public String getEurEdiMsgTpId() {
		return this.eurEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return ediRcvDt
	 */
	public String getEdiRcvDt() {
		return this.ediRcvDt;
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
	 * @return ediRcvSeq
	 */
	public String getEdiRcvSeq() {
		return this.ediRcvSeq;
	}
	
	/**
	 * Column Info
	 * @return cstmsErrId
	 */
	public String getCstmsErrId() {
		return this.cstmsErrId;
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
	 * @return msgRcvNo
	 */
	public String getMsgRcvNo() {
		return this.msgRcvNo;
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
	 * @return eurCstmsAckCd
	 */
	public String getEurCstmsAckCd() {
		return this.eurCstmsAckCd;
	}
	
	/**
	 * Column Info
	 * @return rcvLogErrSeq
	 */
	public String getRcvLogErrSeq() {
		return this.rcvLogErrSeq;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ediRcvMsgCtnt
	 */
	public String getEdiRcvMsgCtnt() {
		return this.ediRcvMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return ediSndMsgNm
	 */
	public String getEdiSndMsgNm() {
		return this.ediSndMsgNm;
	}
	
	/**
	 * Column Info
	 * @return mvmtRefNo
	 */
	public String getMvmtRefNo() {
		return this.mvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
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
	 * @return cstmsErrRefNo2
	 */
	public String getCstmsErrRefNo2() {
		return this.cstmsErrRefNo2;
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
	 * @return rjctRsnRmk
	 */
	public String getRjctRsnRmk() {
		return this.rjctRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return cstmsErrRefNo1
	 */
	public String getCstmsErrRefNo1() {
		return this.cstmsErrRefNo1;
	}
	
	/**
	 * Column Info
	 * @return ackDt
	 */
	public String getAckDt() {
		return this.ackDt;
	}
	
	/**
	 * Column Info
	 * @return eurCstmsRjctCd
	 */
	public String getEurCstmsRjctCd() {
		return this.eurCstmsRjctCd;
	}
	
	/**
	 * Column Info
	 * @return msgAcptRefNo
	 */
	public String getMsgAcptRefNo() {
		return this.msgAcptRefNo;
	}
	
	/**
	 * Column Info
	 * @return rcvTms
	 */
	public String getRcvTms() {
		return this.rcvTms;
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
	 * @return cstmsErrMsg
	 */
	public String getCstmsErrMsg() {
		return this.cstmsErrMsg;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return ackRcvStsCd
	 */
	public String getAckRcvStsCd() {
		return this.ackRcvStsCd;
	}
	
	/**
	 * Column Info
	 * @return rjctDt
	 */
	public String getRjctDt() {
		return this.rjctDt;
	}
	
	/**
	 * Column Info
	 * @return ediMsgTpId
	 */
	public String getEdiMsgTpId() {
		return this.ediMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return ackKndId
	 */
	public String getAckKndId() {
		return this.ackKndId;
	}
	

	/**
	 * Column Info
	 * @param eurEdiMsgTpId
	 */
	public void setEurEdiMsgTpId(String eurEdiMsgTpId) {
		this.eurEdiMsgTpId = eurEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param ediRcvDt
	 */
	public void setEdiRcvDt(String ediRcvDt) {
		this.ediRcvDt = ediRcvDt;
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
	 * @param ediRcvSeq
	 */
	public void setEdiRcvSeq(String ediRcvSeq) {
		this.ediRcvSeq = ediRcvSeq;
	}
	
	/**
	 * Column Info
	 * @param cstmsErrId
	 */
	public void setCstmsErrId(String cstmsErrId) {
		this.cstmsErrId = cstmsErrId;
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
	 * @param msgRcvNo
	 */
	public void setMsgRcvNo(String msgRcvNo) {
		this.msgRcvNo = msgRcvNo;
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
	 * @param eurCstmsAckCd
	 */
	public void setEurCstmsAckCd(String eurCstmsAckCd) {
		this.eurCstmsAckCd = eurCstmsAckCd;
	}
	
	/**
	 * Column Info
	 * @param rcvLogErrSeq
	 */
	public void setRcvLogErrSeq(String rcvLogErrSeq) {
		this.rcvLogErrSeq = rcvLogErrSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ediRcvMsgCtnt
	 */
	public void setEdiRcvMsgCtnt(String ediRcvMsgCtnt) {
		this.ediRcvMsgCtnt = ediRcvMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param ediSndMsgNm
	 */
	public void setEdiSndMsgNm(String ediSndMsgNm) {
		this.ediSndMsgNm = ediSndMsgNm;
	}
	
	/**
	 * Column Info
	 * @param mvmtRefNo
	 */
	public void setMvmtRefNo(String mvmtRefNo) {
		this.mvmtRefNo = mvmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
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
	 * @param cstmsErrRefNo2
	 */
	public void setCstmsErrRefNo2(String cstmsErrRefNo2) {
		this.cstmsErrRefNo2 = cstmsErrRefNo2;
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
	 * @param rjctRsnRmk
	 */
	public void setRjctRsnRmk(String rjctRsnRmk) {
		this.rjctRsnRmk = rjctRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param cstmsErrRefNo1
	 */
	public void setCstmsErrRefNo1(String cstmsErrRefNo1) {
		this.cstmsErrRefNo1 = cstmsErrRefNo1;
	}
	
	/**
	 * Column Info
	 * @param ackDt
	 */
	public void setAckDt(String ackDt) {
		this.ackDt = ackDt;
	}
	
	/**
	 * Column Info
	 * @param eurCstmsRjctCd
	 */
	public void setEurCstmsRjctCd(String eurCstmsRjctCd) {
		this.eurCstmsRjctCd = eurCstmsRjctCd;
	}
	
	/**
	 * Column Info
	 * @param msgAcptRefNo
	 */
	public void setMsgAcptRefNo(String msgAcptRefNo) {
		this.msgAcptRefNo = msgAcptRefNo;
	}
	
	/**
	 * Column Info
	 * @param rcvTms
	 */
	public void setRcvTms(String rcvTms) {
		this.rcvTms = rcvTms;
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
	 * @param cstmsErrMsg
	 */
	public void setCstmsErrMsg(String cstmsErrMsg) {
		this.cstmsErrMsg = cstmsErrMsg;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param ackRcvStsCd
	 */
	public void setAckRcvStsCd(String ackRcvStsCd) {
		this.ackRcvStsCd = ackRcvStsCd;
	}
	
	/**
	 * Column Info
	 * @param rjctDt
	 */
	public void setRjctDt(String rjctDt) {
		this.rjctDt = rjctDt;
	}
	
	/**
	 * Column Info
	 * @param ediMsgTpId
	 */
	public void setEdiMsgTpId(String ediMsgTpId) {
		this.ediMsgTpId = ediMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param ackKndId
	 */
	public void setAckKndId(String ackKndId) {
		this.ackKndId = ackKndId;
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
		setEurEdiMsgTpId(JSPUtil.getParameter(request, prefix + "eur_edi_msg_tp_id", ""));
		setEdiRcvDt(JSPUtil.getParameter(request, prefix + "edi_rcv_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setEdiRcvSeq(JSPUtil.getParameter(request, prefix + "edi_rcv_seq", ""));
		setCstmsErrId(JSPUtil.getParameter(request, prefix + "cstms_err_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMsgRcvNo(JSPUtil.getParameter(request, prefix + "msg_rcv_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setEurCstmsAckCd(JSPUtil.getParameter(request, prefix + "eur_cstms_ack_cd", ""));
		setRcvLogErrSeq(JSPUtil.getParameter(request, prefix + "rcv_log_err_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdiRcvMsgCtnt(JSPUtil.getParameter(request, prefix + "edi_rcv_msg_ctnt", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setEdiSndMsgNm(JSPUtil.getParameter(request, prefix + "edi_snd_msg_nm", ""));
		setMvmtRefNo(JSPUtil.getParameter(request, prefix + "mvmt_ref_no", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCstmsErrRefNo2(JSPUtil.getParameter(request, prefix + "cstms_err_ref_no2", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRjctRsnRmk(JSPUtil.getParameter(request, prefix + "rjct_rsn_rmk", ""));
		setCstmsErrRefNo1(JSPUtil.getParameter(request, prefix + "cstms_err_ref_no1", ""));
		setAckDt(JSPUtil.getParameter(request, prefix + "ack_dt", ""));
		setEurCstmsRjctCd(JSPUtil.getParameter(request, prefix + "eur_cstms_rjct_cd", ""));
		setMsgAcptRefNo(JSPUtil.getParameter(request, prefix + "msg_acpt_ref_no", ""));
		setRcvTms(JSPUtil.getParameter(request, prefix + "rcv_tms", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setCstmsErrMsg(JSPUtil.getParameter(request, prefix + "cstms_err_msg", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAckRcvStsCd(JSPUtil.getParameter(request, prefix + "ack_rcv_sts_cd", ""));
		setRjctDt(JSPUtil.getParameter(request, prefix + "rjct_dt", ""));
		setEdiMsgTpId(JSPUtil.getParameter(request, prefix + "edi_msg_tp_id", ""));
		setAckKndId(JSPUtil.getParameter(request, prefix + "ack_knd_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Eu24RcvMsgVO[]
	 */
	public Eu24RcvMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Eu24RcvMsgVO[]
	 */
	public Eu24RcvMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Eu24RcvMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eurEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "eur_edi_msg_tp_id", length));
			String[] ediRcvDt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ediRcvSeq = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_seq", length));
			String[] cstmsErrId = (JSPUtil.getParameter(request, prefix	+ "cstms_err_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] msgRcvNo = (JSPUtil.getParameter(request, prefix	+ "msg_rcv_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] eurCstmsAckCd = (JSPUtil.getParameter(request, prefix	+ "eur_cstms_ack_cd", length));
			String[] rcvLogErrSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_err_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ediRcvMsgCtnt = (JSPUtil.getParameter(request, prefix	+ "edi_rcv_msg_ctnt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] ediSndMsgNm = (JSPUtil.getParameter(request, prefix	+ "edi_snd_msg_nm", length));
			String[] mvmtRefNo = (JSPUtil.getParameter(request, prefix	+ "mvmt_ref_no", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cstmsErrRefNo2 = (JSPUtil.getParameter(request, prefix	+ "cstms_err_ref_no2", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rjctRsnRmk = (JSPUtil.getParameter(request, prefix	+ "rjct_rsn_rmk", length));
			String[] cstmsErrRefNo1 = (JSPUtil.getParameter(request, prefix	+ "cstms_err_ref_no1", length));
			String[] ackDt = (JSPUtil.getParameter(request, prefix	+ "ack_dt", length));
			String[] eurCstmsRjctCd = (JSPUtil.getParameter(request, prefix	+ "eur_cstms_rjct_cd", length));
			String[] msgAcptRefNo = (JSPUtil.getParameter(request, prefix	+ "msg_acpt_ref_no", length));
			String[] rcvTms = (JSPUtil.getParameter(request, prefix	+ "rcv_tms", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] cstmsErrMsg = (JSPUtil.getParameter(request, prefix	+ "cstms_err_msg", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ackRcvStsCd = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_sts_cd", length));
			String[] rjctDt = (JSPUtil.getParameter(request, prefix	+ "rjct_dt", length));
			String[] ediMsgTpId = (JSPUtil.getParameter(request, prefix	+ "edi_msg_tp_id", length));
			String[] ackKndId = (JSPUtil.getParameter(request, prefix	+ "ack_knd_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new Eu24RcvMsgVO();
				if (eurEdiMsgTpId[i] != null)
					model.setEurEdiMsgTpId(eurEdiMsgTpId[i]);
				if (ediRcvDt[i] != null)
					model.setEdiRcvDt(ediRcvDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ediRcvSeq[i] != null)
					model.setEdiRcvSeq(ediRcvSeq[i]);
				if (cstmsErrId[i] != null)
					model.setCstmsErrId(cstmsErrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (msgRcvNo[i] != null)
					model.setMsgRcvNo(msgRcvNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (eurCstmsAckCd[i] != null)
					model.setEurCstmsAckCd(eurCstmsAckCd[i]);
				if (rcvLogErrSeq[i] != null)
					model.setRcvLogErrSeq(rcvLogErrSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ediRcvMsgCtnt[i] != null)
					model.setEdiRcvMsgCtnt(ediRcvMsgCtnt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (ediSndMsgNm[i] != null)
					model.setEdiSndMsgNm(ediSndMsgNm[i]);
				if (mvmtRefNo[i] != null)
					model.setMvmtRefNo(mvmtRefNo[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cstmsErrRefNo2[i] != null)
					model.setCstmsErrRefNo2(cstmsErrRefNo2[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rjctRsnRmk[i] != null)
					model.setRjctRsnRmk(rjctRsnRmk[i]);
				if (cstmsErrRefNo1[i] != null)
					model.setCstmsErrRefNo1(cstmsErrRefNo1[i]);
				if (ackDt[i] != null)
					model.setAckDt(ackDt[i]);
				if (eurCstmsRjctCd[i] != null)
					model.setEurCstmsRjctCd(eurCstmsRjctCd[i]);
				if (msgAcptRefNo[i] != null)
					model.setMsgAcptRefNo(msgAcptRefNo[i]);
				if (rcvTms[i] != null)
					model.setRcvTms(rcvTms[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (cstmsErrMsg[i] != null)
					model.setCstmsErrMsg(cstmsErrMsg[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ackRcvStsCd[i] != null)
					model.setAckRcvStsCd(ackRcvStsCd[i]);
				if (rjctDt[i] != null)
					model.setRjctDt(rjctDt[i]);
				if (ediMsgTpId[i] != null)
					model.setEdiMsgTpId(ediMsgTpId[i]);
				if (ackKndId[i] != null)
					model.setAckKndId(ackKndId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEu24RcvMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Eu24RcvMsgVO[]
	 */
	public Eu24RcvMsgVO[] getEu24RcvMsgVOs(){
		Eu24RcvMsgVO[] vos = (Eu24RcvMsgVO[])models.toArray(new Eu24RcvMsgVO[models.size()]);
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
		this.eurEdiMsgTpId = this.eurEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvDt = this.ediRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvSeq = this.ediRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrId = this.cstmsErrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRcvNo = this.msgRcvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurCstmsAckCd = this.eurCstmsAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogErrSeq = this.rcvLogErrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRcvMsgCtnt = this.ediRcvMsgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndMsgNm = this.ediSndMsgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtRefNo = this.mvmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrRefNo2 = this.cstmsErrRefNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctRsnRmk = this.rjctRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrRefNo1 = this.cstmsErrRefNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackDt = this.ackDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurCstmsRjctCd = this.eurCstmsRjctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAcptRefNo = this.msgAcptRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTms = this.rcvTms .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsErrMsg = this.cstmsErrMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvStsCd = this.ackRcvStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctDt = this.rjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsgTpId = this.ediMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackKndId = this.ackKndId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
