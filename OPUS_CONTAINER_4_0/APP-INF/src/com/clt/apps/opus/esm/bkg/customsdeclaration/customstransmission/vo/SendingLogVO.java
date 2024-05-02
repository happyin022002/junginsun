/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SendingLogVO.java
*@FileTitle : SendingLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.01
*@LastModifier : 김도완
*@LastVersion : 1.0
* 2009.07.01 김도완
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.01.31 민정호 [CHM-201215726-01] AMS 전송시 Customs 로직 추가 요청
* 2013.04.02 김보배 [CHM-201323809] [BKG] [US AMS] MI 전송 화면 & Transmission & receiving history 화면 보완
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김도완
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SendingLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SendingLogVO> models = new ArrayList<SendingLogVO>();

	/* Column Info */
	private String actFileSkdDirCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String ackSndKnt = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String ackTpNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etaDtFormat = null;
	/* Column Info */
	private String trsmMsgTpId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String ackRcvDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String autoVslDepRptFlg = null;
	/* Column Info */
	private String crrBatNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String vslDepRptFlg = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sndUsrOfcCd = null;
	/* Column Info */
	private String ediSndLogCtnt = null;
	/* Column Info */
	private String blParams = null;
	private String cstmsPortCd = null;
	/* Column Info */
	private String cgoTpCd = null;



	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SendingLogVO() {}

	public SendingLogVO(String ibflag, String pagerows, String cntCd, String ioBndCd, String sndDt, String hisSeq, String trsmMsgTpId, String vvd, String polCd, String podCd, String vslDepRptFlg, String autoVslDepRptFlg, String sndUsrId, String sndUsrOfcCd, String ackTpNo, String ackSndKnt, String creUsrId, String ackRcvDt, String dtlSeq, String ediSndLogCtnt, String updUsrId, String etaDt, String etaDtFormat, String crrBatNo, String blParams, String actFileSkdDirCd, String cstmsPortCd, String cgoTpCd) {
		this.actFileSkdDirCd = actFileSkdDirCd;
		this.etaDt = etaDt;
		this.ackSndKnt = ackSndKnt;
		this.sndDt = sndDt;
		this.ackTpNo = ackTpNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.etaDtFormat = etaDtFormat;
		this.trsmMsgTpId = trsmMsgTpId;
		this.cntCd = cntCd;
		this.hisSeq = hisSeq;
		this.dtlSeq = dtlSeq;
		this.ackRcvDt = ackRcvDt;
		this.updUsrId = updUsrId;
		this.autoVslDepRptFlg = autoVslDepRptFlg;
		this.crrBatNo = crrBatNo;
		this.ioBndCd = ioBndCd;
		this.vslDepRptFlg = vslDepRptFlg;
		this.podCd = podCd;
		this.vvd = vvd;
		this.sndUsrId = sndUsrId;
		this.creUsrId = creUsrId;
		this.sndUsrOfcCd = sndUsrOfcCd;
		this.ediSndLogCtnt = ediSndLogCtnt;
		this.blParams = blParams;
		this.cstmsPortCd = cstmsPortCd;
		this.cgoTpCd = cgoTpCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("act_file_skd_dir_cd", getActFileSkdDirCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("ack_snd_knt", getAckSndKnt());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("ack_tp_no", getAckTpNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eta_dt_format", getEtaDtFormat());
		this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("ack_rcv_dt", getAckRcvDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("auto_vsl_dep_rpt_flg", getAutoVslDepRptFlg());
		this.hashColumns.put("crr_bat_no", getCrrBatNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("vsl_dep_rpt_flg", getVslDepRptFlg());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("snd_usr_ofc_cd", getSndUsrOfcCd());
		this.hashColumns.put("edi_snd_log_ctnt", getEdiSndLogCtnt());
		this.hashColumns.put("bl_params", getBlParams());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());

		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("act_file_skd_dir_cd", "actFileSkdDirCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("ack_snd_knt", "ackSndKnt");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("ack_tp_no", "ackTpNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eta_dt_format", "etaDtFormat");
		this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("ack_rcv_dt", "ackRcvDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("auto_vsl_dep_rpt_flg", "autoVslDepRptFlg");
		this.hashFields.put("crr_bat_no", "crrBatNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("vsl_dep_rpt_flg", "vslDepRptFlg");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("snd_usr_ofc_cd", "sndUsrOfcCd");
		this.hashFields.put("edi_snd_log_ctnt", "ediSndLogCtnt");
		this.hashFields.put("bl_params", "blParams");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");

		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return actFileSkdDirCd
	 */
	public String getActFileSkdDirCd() {
		return this.actFileSkdDirCd;
	}

	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}

	/**
	 * Column Info
	 * @return ackSndKnt
	 */
	public String getAckSndKnt() {
		return this.ackSndKnt;
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
	 * @return ackTpNo
	 */
	public String getAckTpNo() {
		return this.ackTpNo;
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
	 * @return etaDtFormat
	 */
	public String getEtaDtFormat() {
		return this.etaDtFormat;
	}

	/**
	 * Column Info
	 * @return trsmMsgTpId
	 */
	public String getTrsmMsgTpId() {
		return this.trsmMsgTpId;
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
	 * @return hisSeq
	 */
	public String getHisSeq() {
		return this.hisSeq;
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
	 * @return ackRcvDt
	 */
	public String getAckRcvDt() {
		return this.ackRcvDt;
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
	 * @return autoVslDepRptFlg
	 */
	public String getAutoVslDepRptFlg() {
		return this.autoVslDepRptFlg;
	}

	/**
	 * Column Info
	 * @return crrBatNo
	 */
	public String getCrrBatNo() {
		return this.crrBatNo;
	}

	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}

	/**
	 * Column Info
	 * @return vslDepRptFlg
	 */
	public String getVslDepRptFlg() {
		return this.vslDepRptFlg;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}

	/**
	 * Column Info
	 * @return sndUsrId
	 */
	public String getSndUsrId() {
		return this.sndUsrId;
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
	 * @return sndUsrOfcCd
	 */
	public String getSndUsrOfcCd() {
		return this.sndUsrOfcCd;
	}

	/**
	 * Column Info
	 * @return ediSndLogCtnt
	 */
	public String getEdiSndLogCtnt() {
		return this.ediSndLogCtnt;
	}

	/**
	 * Column Info
	 * @return blParams
	 */
	public String getBlParams() {
		return this.blParams;
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
	 * @return cgoTpCd
	 */
	public String getCgoTpCd(){
		return this.cgoTpCd;
	}

	/**
	 * Column Info
	 * @param actFileSkdDirCd
	 */
	public void setActFileSkdDirCd(String actFileSkdDirCd) {
		this.actFileSkdDirCd = actFileSkdDirCd;
	}

	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}

	/**
	 * Column Info
	 * @param ackSndKnt
	 */
	public void setAckSndKnt(String ackSndKnt) {
		this.ackSndKnt = ackSndKnt;
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
	 * @param ackTpNo
	 */
	public void setAckTpNo(String ackTpNo) {
		this.ackTpNo = ackTpNo;
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
	 * @param etaDtFormat
	 */
	public void setEtaDtFormat(String etaDtFormat) {
		this.etaDtFormat = etaDtFormat;
	}

	/**
	 * Column Info
	 * @param trsmMsgTpId
	 */
	public void setTrsmMsgTpId(String trsmMsgTpId) {
		this.trsmMsgTpId = trsmMsgTpId;
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
	 * @param hisSeq
	 */
	public void setHisSeq(String hisSeq) {
		this.hisSeq = hisSeq;
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
	 * @param ackRcvDt
	 */
	public void setAckRcvDt(String ackRcvDt) {
		this.ackRcvDt = ackRcvDt;
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
	 * @param autoVslDepRptFlg
	 */
	public void setAutoVslDepRptFlg(String autoVslDepRptFlg) {
		this.autoVslDepRptFlg = autoVslDepRptFlg;
	}

	/**
	 * Column Info
	 * @param crrBatNo
	 */
	public void setCrrBatNo(String crrBatNo) {
		this.crrBatNo = crrBatNo;
	}

	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Column Info
	 * @param vslDepRptFlg
	 */
	public void setVslDepRptFlg(String vslDepRptFlg) {
		this.vslDepRptFlg = vslDepRptFlg;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	/**
	 * Column Info
	 * @param sndUsrId
	 */
	public void setSndUsrId(String sndUsrId) {
		this.sndUsrId = sndUsrId;
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
	 * @param sndUsrOfcCd
	 */
	public void setSndUsrOfcCd(String sndUsrOfcCd) {
		this.sndUsrOfcCd = sndUsrOfcCd;
	}

	/**
	 * Column Info
	 * @param ediSndLogCtnt
	 */
	public void setEdiSndLogCtnt(String ediSndLogCtnt) {
		this.ediSndLogCtnt = ediSndLogCtnt;
	}

	/**
	 * Column Info
	 * @param blParams
	 */
	public void setBlParams(String blParams) {
		this.blParams = blParams;
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
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd){
		this.cgoTpCd = cgoTpCd;
	}


	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setActFileSkdDirCd(JSPUtil.getParameter(request, "act_file_skd_dir_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setAckSndKnt(JSPUtil.getParameter(request, "ack_snd_knt", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setAckTpNo(JSPUtil.getParameter(request, "ack_tp_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEtaDtFormat(JSPUtil.getParameter(request, "eta_dt_format", ""));
		setTrsmMsgTpId(JSPUtil.getParameter(request, "trsm_msg_tp_id", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setDtlSeq(JSPUtil.getParameter(request, "dtl_seq", ""));
		setAckRcvDt(JSPUtil.getParameter(request, "ack_rcv_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAutoVslDepRptFlg(JSPUtil.getParameter(request, "auto_vsl_dep_rpt_flg", ""));
		setCrrBatNo(JSPUtil.getParameter(request, "crr_bat_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setVslDepRptFlg(JSPUtil.getParameter(request, "vsl_dep_rpt_flg", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSndUsrOfcCd(JSPUtil.getParameter(request, "snd_usr_ofc_cd", ""));
		setEdiSndLogCtnt(JSPUtil.getParameter(request, "edi_snd_log_ctnt", ""));
		setBlParams(JSPUtil.getParameter(request, "bl_params", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, "cstms_port_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "cgo_tp_cd", ""));

	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendingLogVO[]
	 */
	public SendingLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SendingLogVO[]
	 */
	public SendingLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SendingLogVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] actFileSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "act_file_skd_dir_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] ackSndKnt = (JSPUtil.getParameter(request, prefix	+ "ack_snd_knt", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] ackTpNo = (JSPUtil.getParameter(request, prefix	+ "ack_tp_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etaDtFormat = (JSPUtil.getParameter(request, prefix	+ "eta_dt_format", length));
			String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix	+ "trsm_msg_tp_id", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] ackRcvDt = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] autoVslDepRptFlg = (JSPUtil.getParameter(request, prefix	+ "auto_vsl_dep_rpt_flg", length));
			String[] crrBatNo = (JSPUtil.getParameter(request, prefix	+ "crr_bat_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] vslDepRptFlg = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_rpt_flg", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] sndUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_usr_ofc_cd", length));
			String[] ediSndLogCtnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_log_ctnt", length));
			String[] blParams = (JSPUtil.getParameter(request, prefix	+ "bl_params", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));

			for (int i = 0; i < length; i++) {
				model = new SendingLogVO();
				if (actFileSkdDirCd[i] != null)
					model.setActFileSkdDirCd(actFileSkdDirCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (ackSndKnt[i] != null)
					model.setAckSndKnt(ackSndKnt[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (ackTpNo[i] != null)
					model.setAckTpNo(ackTpNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etaDtFormat[i] != null)
					model.setEtaDtFormat(etaDtFormat[i]);
				if (trsmMsgTpId[i] != null)
					model.setTrsmMsgTpId(trsmMsgTpId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (ackRcvDt[i] != null)
					model.setAckRcvDt(ackRcvDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (autoVslDepRptFlg[i] != null)
					model.setAutoVslDepRptFlg(autoVslDepRptFlg[i]);
				if (crrBatNo[i] != null)
					model.setCrrBatNo(crrBatNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (vslDepRptFlg[i] != null)
					model.setVslDepRptFlg(vslDepRptFlg[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sndUsrOfcCd[i] != null)
					model.setSndUsrOfcCd(sndUsrOfcCd[i]);
				if (ediSndLogCtnt[i] != null)
					model.setEdiSndLogCtnt(ediSndLogCtnt[i]);
				if (blParams[i] != null)
					model.setBlParams(blParams[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);

				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSendingLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SendingLogVO[]
	 */
	public SendingLogVO[] getSendingLogVOs(){
		SendingLogVO[] vos = (SendingLogVO[])models.toArray(new SendingLogVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}

	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.actFileSkdDirCd = this.actFileSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackSndKnt = this.ackSndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackTpNo = this.ackTpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDtFormat = this.etaDtFormat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMsgTpId = this.trsmMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvDt = this.ackRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoVslDepRptFlg = this.autoVslDepRptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBatNo = this.crrBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepRptFlg = this.vslDepRptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrOfcCd = this.sndUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndLogCtnt = this.ediSndLogCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blParams = this.blParams .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
