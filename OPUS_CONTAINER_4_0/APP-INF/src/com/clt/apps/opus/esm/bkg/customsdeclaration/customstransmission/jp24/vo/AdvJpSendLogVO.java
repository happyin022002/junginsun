/*========================================================= 
*Copyright(c) 2016 CyberLogitec
*@FileName : AdvJpSendLogVO.java
*@FileTitle : AdvJpSendLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.28  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.jp24.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AdvJpSendLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdvJpSendLogVO> models = new ArrayList<AdvJpSendLogVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String corrRsnCd = null;
	/* Column Info */
	private String polNm = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String corrRsn = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String jpSndLogId = null;
	/* Column Info */
	private String rcvKeyDatCtnt = null;
	/* Column Info */
	private String hblNo = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String emlSndRsltFlg = null;
	/* Column Info */
	private String cntcPsonEml = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String msgSndDiv = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ibCssmVoyNo = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blOfcNm = null;
	/* Column Info */
	private String podSplitNo = null;
	/* Column Info */
	private String polSplitNo = null;
	/* Column Info */
	private String ediSndMsgCtnt = null;
	/* Column Info */
	private String ediRefId = null;
	/* Column Info */
	private String msgSndSeq = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String tSType = null;
	/* Column Info */
	private String rcvPreNotice = null;
	/* Column Info */
	private String logSeq = null;
	/* Column Info */
	private String flatFile = null;
	/* Column Info */
	private String msgSndNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AdvJpSendLogVO() {}

	public AdvJpSendLogVO(String ibflag, String pagerows, String blNo, String blOfcNm, String callSgnNo, String cneeNm, String cntcPsonEml, String corrRsn, String corrRsnCd, String delCd, String ediRefId, String ediSndMsgCtnt, String emlSndRsltFlg, String flatFile, String hblNo, String ibCssmVoyNo, String jpSndLogId, String logSeq, String msgSndDiv, String msgSndNo, String msgSndSeq, String ofcCd, String podCd, String podNm, String podSplitNo, String polCd, String polNm, String polSplitNo, String porCd, String rcvKeyDatCtnt, String rcvPreNotice, String shprNm, String sndDt, String tSType, String usrId, String vvd) {
		this.porCd = porCd;
		this.corrRsnCd = corrRsnCd;
		this.polNm = polNm;
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.corrRsn = corrRsn;
		this.usrId = usrId;
		this.jpSndLogId = jpSndLogId;
		this.rcvKeyDatCtnt = rcvKeyDatCtnt;
		this.hblNo = hblNo;
		this.shprNm = shprNm;
		this.emlSndRsltFlg = emlSndRsltFlg;
		this.cntcPsonEml = cntcPsonEml;
		this.podNm = podNm;
		this.msgSndDiv = msgSndDiv;
		this.callSgnNo = callSgnNo;
		this.ibCssmVoyNo = ibCssmVoyNo;
		this.delCd = delCd;
		this.blOfcNm = blOfcNm;
		this.podSplitNo = podSplitNo;
		this.polSplitNo = polSplitNo;
		this.ediSndMsgCtnt = ediSndMsgCtnt;
		this.ediRefId = ediRefId;
		this.msgSndSeq = msgSndSeq;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.cneeNm = cneeNm;
		this.tSType = tSType;
		this.rcvPreNotice = rcvPreNotice;
		this.logSeq = logSeq;
		this.flatFile = flatFile;
		this.msgSndNo = msgSndNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("corr_rsn_cd", getCorrRsnCd());
		this.hashColumns.put("pol_nm", getPolNm());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("corr_rsn", getCorrRsn());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("jp_snd_log_id", getJpSndLogId());
		this.hashColumns.put("rcv_key_dat_ctnt", getRcvKeyDatCtnt());
		this.hashColumns.put("hbl_no", getHblNo());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("eml_snd_rslt_flg", getEmlSndRsltFlg());
		this.hashColumns.put("cntc_pson_eml", getCntcPsonEml());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("msg_snd_div", getMsgSndDiv());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_ofc_nm", getBlOfcNm());
		this.hashColumns.put("pod_split_no", getPodSplitNo());
		this.hashColumns.put("pol_split_no", getPolSplitNo());
		this.hashColumns.put("edi_snd_msg_ctnt", getEdiSndMsgCtnt());
		this.hashColumns.put("edi_ref_id", getEdiRefId());
		this.hashColumns.put("msg_snd_seq", getMsgSndSeq());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("t_s_type", getTSType());
		this.hashColumns.put("rcv_pre_notice", getRcvPreNotice());
		this.hashColumns.put("log_seq", getLogSeq());
		this.hashColumns.put("flat_file", getFlatFile());
		this.hashColumns.put("msg_snd_no", getMsgSndNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("corr_rsn_cd", "corrRsnCd");
		this.hashFields.put("pol_nm", "polNm");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("corr_rsn", "corrRsn");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("jp_snd_log_id", "jpSndLogId");
		this.hashFields.put("rcv_key_dat_ctnt", "rcvKeyDatCtnt");
		this.hashFields.put("hbl_no", "hblNo");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("eml_snd_rslt_flg", "emlSndRsltFlg");
		this.hashFields.put("cntc_pson_eml", "cntcPsonEml");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("msg_snd_div", "msgSndDiv");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_ofc_nm", "blOfcNm");
		this.hashFields.put("pod_split_no", "podSplitNo");
		this.hashFields.put("pol_split_no", "polSplitNo");
		this.hashFields.put("edi_snd_msg_ctnt", "ediSndMsgCtnt");
		this.hashFields.put("edi_ref_id", "ediRefId");
		this.hashFields.put("msg_snd_seq", "msgSndSeq");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("t_s_type", "tSType");
		this.hashFields.put("rcv_pre_notice", "rcvPreNotice");
		this.hashFields.put("log_seq", "logSeq");
		this.hashFields.put("flat_file", "flatFile");
		this.hashFields.put("msg_snd_no", "msgSndNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return corrRsnCd
	 */
	public String getCorrRsnCd() {
		return this.corrRsnCd;
	}
	
	/**
	 * Column Info
	 * @return polNm
	 */
	public String getPolNm() {
		return this.polNm;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return corrRsn
	 */
	public String getCorrRsn() {
		return this.corrRsn;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return jpSndLogId
	 */
	public String getJpSndLogId() {
		return this.jpSndLogId;
	}
	
	/**
	 * Column Info
	 * @return rcvKeyDatCtnt
	 */
	public String getRcvKeyDatCtnt() {
		return this.rcvKeyDatCtnt;
	}
	
	/**
	 * Column Info
	 * @return hblNo
	 */
	public String getHblNo() {
		return this.hblNo;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltFlg
	 */
	public String getEmlSndRsltFlg() {
		return this.emlSndRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonEml
	 */
	public String getCntcPsonEml() {
		return this.cntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return msgSndDiv
	 */
	public String getMsgSndDiv() {
		return this.msgSndDiv;
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
	 * @return ibCssmVoyNo
	 */
	public String getIbCssmVoyNo() {
		return this.ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return blOfcNm
	 */
	public String getBlOfcNm() {
		return this.blOfcNm;
	}
	
	/**
	 * Column Info
	 * @return podSplitNo
	 */
	public String getPodSplitNo() {
		return this.podSplitNo;
	}
	
	/**
	 * Column Info
	 * @return polSplitNo
	 */
	public String getPolSplitNo() {
		return this.polSplitNo;
	}
	
	/**
	 * Column Info
	 * @return ediSndMsgCtnt
	 */
	public String getEdiSndMsgCtnt() {
		return this.ediSndMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @return ediRefId
	 */
	public String getEdiRefId() {
		return this.ediRefId;
	}
	
	/**
	 * Column Info
	 * @return msgSndSeq
	 */
	public String getMsgSndSeq() {
		return this.msgSndSeq;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return tSType
	 */
	public String getTSType() {
		return this.tSType;
	}
	
	/**
	 * Column Info
	 * @return rcvPreNotice
	 */
	public String getRcvPreNotice() {
		return this.rcvPreNotice;
	}
	
	/**
	 * Column Info
	 * @return logSeq
	 */
	public String getLogSeq() {
		return this.logSeq;
	}
	
	/**
	 * Column Info
	 * @return flatFile
	 */
	public String getFlatFile() {
		return this.flatFile;
	}
	
	/**
	 * Column Info
	 * @return msgSndNo
	 */
	public String getMsgSndNo() {
		return this.msgSndNo;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param corrRsnCd
	 */
	public void setCorrRsnCd(String corrRsnCd) {
		this.corrRsnCd = corrRsnCd;
	}
	
	/**
	 * Column Info
	 * @param polNm
	 */
	public void setPolNm(String polNm) {
		this.polNm = polNm;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param corrRsn
	 */
	public void setCorrRsn(String corrRsn) {
		this.corrRsn = corrRsn;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param jpSndLogId
	 */
	public void setJpSndLogId(String jpSndLogId) {
		this.jpSndLogId = jpSndLogId;
	}
	
	/**
	 * Column Info
	 * @param rcvKeyDatCtnt
	 */
	public void setRcvKeyDatCtnt(String rcvKeyDatCtnt) {
		this.rcvKeyDatCtnt = rcvKeyDatCtnt;
	}
	
	/**
	 * Column Info
	 * @param hblNo
	 */
	public void setHblNo(String hblNo) {
		this.hblNo = hblNo;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltFlg
	 */
	public void setEmlSndRsltFlg(String emlSndRsltFlg) {
		this.emlSndRsltFlg = emlSndRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonEml
	 */
	public void setCntcPsonEml(String cntcPsonEml) {
		this.cntcPsonEml = cntcPsonEml;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param msgSndDiv
	 */
	public void setMsgSndDiv(String msgSndDiv) {
		this.msgSndDiv = msgSndDiv;
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
	 * @param ibCssmVoyNo
	 */
	public void setIbCssmVoyNo(String ibCssmVoyNo) {
		this.ibCssmVoyNo = ibCssmVoyNo;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param blOfcNm
	 */
	public void setBlOfcNm(String blOfcNm) {
		this.blOfcNm = blOfcNm;
	}
	
	/**
	 * Column Info
	 * @param podSplitNo
	 */
	public void setPodSplitNo(String podSplitNo) {
		this.podSplitNo = podSplitNo;
	}
	
	/**
	 * Column Info
	 * @param polSplitNo
	 */
	public void setPolSplitNo(String polSplitNo) {
		this.polSplitNo = polSplitNo;
	}
	
	/**
	 * Column Info
	 * @param ediSndMsgCtnt
	 */
	public void setEdiSndMsgCtnt(String ediSndMsgCtnt) {
		this.ediSndMsgCtnt = ediSndMsgCtnt;
	}
	
	/**
	 * Column Info
	 * @param ediRefId
	 */
	public void setEdiRefId(String ediRefId) {
		this.ediRefId = ediRefId;
	}
	
	/**
	 * Column Info
	 * @param msgSndSeq
	 */
	public void setMsgSndSeq(String msgSndSeq) {
		this.msgSndSeq = msgSndSeq;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param tSType
	 */
	public void setTSType(String tSType) {
		this.tSType = tSType;
	}
	
	/**
	 * Column Info
	 * @param rcvPreNotice
	 */
	public void setRcvPreNotice(String rcvPreNotice) {
		this.rcvPreNotice = rcvPreNotice;
	}
	
	/**
	 * Column Info
	 * @param logSeq
	 */
	public void setLogSeq(String logSeq) {
		this.logSeq = logSeq;
	}
	
	/**
	 * Column Info
	 * @param flatFile
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}
	
	/**
	 * Column Info
	 * @param msgSndNo
	 */
	public void setMsgSndNo(String msgSndNo) {
		this.msgSndNo = msgSndNo;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCorrRsnCd(JSPUtil.getParameter(request, prefix + "corr_rsn_cd", ""));
		setPolNm(JSPUtil.getParameter(request, prefix + "pol_nm", ""));
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCorrRsn(JSPUtil.getParameter(request, prefix + "corr_rsn", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setJpSndLogId(JSPUtil.getParameter(request, prefix + "jp_snd_log_id", ""));
		setRcvKeyDatCtnt(JSPUtil.getParameter(request, prefix + "rcv_key_dat_ctnt", ""));
		setHblNo(JSPUtil.getParameter(request, prefix + "hbl_no", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setEmlSndRsltFlg(JSPUtil.getParameter(request, prefix + "eml_snd_rslt_flg", ""));
		setCntcPsonEml(JSPUtil.getParameter(request, prefix + "cntc_pson_eml", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setMsgSndDiv(JSPUtil.getParameter(request, prefix + "msg_snd_div", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setIbCssmVoyNo(JSPUtil.getParameter(request, prefix + "ib_cssm_voy_no", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBlOfcNm(JSPUtil.getParameter(request, prefix + "bl_ofc_nm", ""));
		setPodSplitNo(JSPUtil.getParameter(request, prefix + "pod_split_no", ""));
		setPolSplitNo(JSPUtil.getParameter(request, prefix + "pol_split_no", ""));
		setEdiSndMsgCtnt(JSPUtil.getParameter(request, prefix + "edi_snd_msg_ctnt", ""));
		setEdiRefId(JSPUtil.getParameter(request, prefix + "edi_ref_id", ""));
		setMsgSndSeq(JSPUtil.getParameter(request, prefix + "msg_snd_seq", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setTSType(JSPUtil.getParameter(request, prefix + "t_s_type", ""));
		setRcvPreNotice(JSPUtil.getParameter(request, prefix + "rcv_pre_notice", ""));
		setLogSeq(JSPUtil.getParameter(request, prefix + "log_seq", ""));
		setFlatFile(JSPUtil.getParameter(request, prefix + "flat_file", ""));
		setMsgSndNo(JSPUtil.getParameter(request, prefix + "msg_snd_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdvJpSendLogVO[]
	 */
	public AdvJpSendLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdvJpSendLogVO[]
	 */
	public AdvJpSendLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdvJpSendLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] corrRsnCd = (JSPUtil.getParameter(request, prefix	+ "corr_rsn_cd", length));
			String[] polNm = (JSPUtil.getParameter(request, prefix	+ "pol_nm", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] corrRsn = (JSPUtil.getParameter(request, prefix	+ "corr_rsn", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] jpSndLogId = (JSPUtil.getParameter(request, prefix	+ "jp_snd_log_id", length));
			String[] rcvKeyDatCtnt = (JSPUtil.getParameter(request, prefix	+ "rcv_key_dat_ctnt", length));
			String[] hblNo = (JSPUtil.getParameter(request, prefix	+ "hbl_no", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] emlSndRsltFlg = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_flg", length));
			String[] cntcPsonEml = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_eml", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] msgSndDiv = (JSPUtil.getParameter(request, prefix	+ "msg_snd_div", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ibCssmVoyNo = (JSPUtil.getParameter(request, prefix	+ "ib_cssm_voy_no", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blOfcNm = (JSPUtil.getParameter(request, prefix	+ "bl_ofc_nm", length));
			String[] podSplitNo = (JSPUtil.getParameter(request, prefix	+ "pod_split_no", length));
			String[] polSplitNo = (JSPUtil.getParameter(request, prefix	+ "pol_split_no", length));
			String[] ediSndMsgCtnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_msg_ctnt", length));
			String[] ediRefId = (JSPUtil.getParameter(request, prefix	+ "edi_ref_id", length));
			String[] msgSndSeq = (JSPUtil.getParameter(request, prefix	+ "msg_snd_seq", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] tSType = (JSPUtil.getParameter(request, prefix	+ "t_s_type", length));
			String[] rcvPreNotice = (JSPUtil.getParameter(request, prefix	+ "rcv_pre_notice", length));
			String[] logSeq = (JSPUtil.getParameter(request, prefix	+ "log_seq", length));
			String[] flatFile = (JSPUtil.getParameter(request, prefix	+ "flat_file", length));
			String[] msgSndNo = (JSPUtil.getParameter(request, prefix	+ "msg_snd_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new AdvJpSendLogVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (corrRsnCd[i] != null)
					model.setCorrRsnCd(corrRsnCd[i]);
				if (polNm[i] != null)
					model.setPolNm(polNm[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (corrRsn[i] != null)
					model.setCorrRsn(corrRsn[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (jpSndLogId[i] != null)
					model.setJpSndLogId(jpSndLogId[i]);
				if (rcvKeyDatCtnt[i] != null)
					model.setRcvKeyDatCtnt(rcvKeyDatCtnt[i]);
				if (hblNo[i] != null)
					model.setHblNo(hblNo[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (emlSndRsltFlg[i] != null)
					model.setEmlSndRsltFlg(emlSndRsltFlg[i]);
				if (cntcPsonEml[i] != null)
					model.setCntcPsonEml(cntcPsonEml[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (msgSndDiv[i] != null)
					model.setMsgSndDiv(msgSndDiv[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ibCssmVoyNo[i] != null)
					model.setIbCssmVoyNo(ibCssmVoyNo[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blOfcNm[i] != null)
					model.setBlOfcNm(blOfcNm[i]);
				if (podSplitNo[i] != null)
					model.setPodSplitNo(podSplitNo[i]);
				if (polSplitNo[i] != null)
					model.setPolSplitNo(polSplitNo[i]);
				if (ediSndMsgCtnt[i] != null)
					model.setEdiSndMsgCtnt(ediSndMsgCtnt[i]);
				if (ediRefId[i] != null)
					model.setEdiRefId(ediRefId[i]);
				if (msgSndSeq[i] != null)
					model.setMsgSndSeq(msgSndSeq[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (tSType[i] != null)
					model.setTSType(tSType[i]);
				if (rcvPreNotice[i] != null)
					model.setRcvPreNotice(rcvPreNotice[i]);
				if (logSeq[i] != null)
					model.setLogSeq(logSeq[i]);
				if (flatFile[i] != null)
					model.setFlatFile(flatFile[i]);
				if (msgSndNo[i] != null)
					model.setMsgSndNo(msgSndNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdvJpSendLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdvJpSendLogVO[]
	 */
	public AdvJpSendLogVO[] getAdvJpSendLogVOs(){
		AdvJpSendLogVO[] vos = (AdvJpSendLogVO[])models.toArray(new AdvJpSendLogVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsnCd = this.corrRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNm = this.polNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrRsn = this.corrRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpSndLogId = this.jpSndLogId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvKeyDatCtnt = this.rcvKeyDatCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hblNo = this.hblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltFlg = this.emlSndRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonEml = this.cntcPsonEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndDiv = this.msgSndDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCssmVoyNo = this.ibCssmVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blOfcNm = this.blOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSplitNo = this.podSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSplitNo = this.polSplitNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndMsgCtnt = this.ediSndMsgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediRefId = this.ediRefId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndSeq = this.msgSndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tSType = this.tSType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvPreNotice = this.rcvPreNotice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.logSeq = this.logSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFile = this.flatFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgSndNo = this.msgSndNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
