/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CstmsSendLogVO.java
*@FileTitle : CstmsSendLogVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.02
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2009.06.02 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CstmsSendLogVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CstmsSendLogVO> models = new ArrayList<CstmsSendLogVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String creDt = null;
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
	private String trsmMsgTpId = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String hisSeq = null;
	/* Column Info */
	private String ackRcvDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ackAcptKnt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ackRcvTpId = null;
	/* Column Info */
	private String autoVslDepRptFlg = null;
	/* Column Info */
	private String crrBatNo = null;
	/* Column Info */
	private String ackRcvKnt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String vslDepRptFlg = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String sndUsrId = null;
	/* Column Info */
	private String sndUsrOfcCd = null;
	/* Column Info */
	private String etlSeq = null;
	/* Column Info */
	private String ediSndLogCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CstmsSendLogVO() {}

	public CstmsSendLogVO(String ibflag, String pagerows, String cntCd, String ioBndCd, String sndDt, String hisSeq, String trsmMsgTpId, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String vslDepRptFlg, String autoVslDepRptFlg, String sndUsrId, String sndUsrOfcCd, String ackTpNo, String ackRcvDt, String crrBatNo, String ackRcvTpId, String ackSndKnt, String ackRcvKnt, String ackAcptKnt, String deltFlg, String etlSeq, String ediSndLogCtnt, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.vslCd = vslCd;
		this.deltFlg = deltFlg;
		this.creDt = creDt;
		this.ackSndKnt = ackSndKnt;
		this.sndDt = sndDt;
		this.ackTpNo = ackTpNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.trsmMsgTpId = trsmMsgTpId;
		this.cntCd = cntCd;
		this.hisSeq = hisSeq;
		this.ackRcvDt = ackRcvDt;
		this.updUsrId = updUsrId;
		this.ackAcptKnt = ackAcptKnt;
		this.updDt = updDt;
		this.ackRcvTpId = ackRcvTpId;
		this.autoVslDepRptFlg = autoVslDepRptFlg;
		this.crrBatNo = crrBatNo;
		this.ackRcvKnt = ackRcvKnt;
		this.skdVoyNo = skdVoyNo;
		this.ioBndCd = ioBndCd;
		this.vslDepRptFlg = vslDepRptFlg;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.sndUsrId = sndUsrId;
		this.sndUsrOfcCd = sndUsrOfcCd;
		this.etlSeq = etlSeq;
		this.ediSndLogCtnt = ediSndLogCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ack_snd_knt", getAckSndKnt());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("ack_tp_no", getAckTpNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("trsm_msg_tp_id", getTrsmMsgTpId());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("his_seq", getHisSeq());
		this.hashColumns.put("ack_rcv_dt", getAckRcvDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ack_acpt_knt", getAckAcptKnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ack_rcv_tp_id", getAckRcvTpId());
		this.hashColumns.put("auto_vsl_dep_rpt_flg", getAutoVslDepRptFlg());
		this.hashColumns.put("crr_bat_no", getCrrBatNo());
		this.hashColumns.put("ack_rcv_knt", getAckRcvKnt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("vsl_dep_rpt_flg", getVslDepRptFlg());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("snd_usr_id", getSndUsrId());
		this.hashColumns.put("snd_usr_ofc_cd", getSndUsrOfcCd());
		this.hashColumns.put("etl_seq", getEtlSeq());
		this.hashColumns.put("edi_snd_log_ctnt", getEdiSndLogCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ack_snd_knt", "ackSndKnt");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("ack_tp_no", "ackTpNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trsm_msg_tp_id", "trsmMsgTpId");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("his_seq", "hisSeq");
		this.hashFields.put("ack_rcv_dt", "ackRcvDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ack_acpt_knt", "ackAcptKnt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ack_rcv_tp_id", "ackRcvTpId");
		this.hashFields.put("auto_vsl_dep_rpt_flg", "autoVslDepRptFlg");
		this.hashFields.put("crr_bat_no", "crrBatNo");
		this.hashFields.put("ack_rcv_knt", "ackRcvKnt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("vsl_dep_rpt_flg", "vslDepRptFlg");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("snd_usr_id", "sndUsrId");
		this.hashFields.put("snd_usr_ofc_cd", "sndUsrOfcCd");
		this.hashFields.put("etl_seq", "etlSeq");
		this.hashFields.put("edi_snd_log_ctnt", "ediSndLogCtnt");
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
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
	 * @return ackAcptKnt
	 */
	public String getAckAcptKnt() {
		return this.ackAcptKnt;
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
	 * @return ackRcvTpId
	 */
	public String getAckRcvTpId() {
		return this.ackRcvTpId;
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
	 * @return ackRcvKnt
	 */
	public String getAckRcvKnt() {
		return this.ackRcvKnt;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return sndUsrOfcCd
	 */
	public String getSndUsrOfcCd() {
		return this.sndUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return etlSeq
	 */
	public String getEtlSeq() {
		return this.etlSeq;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
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
	 * @param ackAcptKnt
	 */
	public void setAckAcptKnt(String ackAcptKnt) {
		this.ackAcptKnt = ackAcptKnt;
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
	 * @param ackRcvTpId
	 */
	public void setAckRcvTpId(String ackRcvTpId) {
		this.ackRcvTpId = ackRcvTpId;
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
	 * @param ackRcvKnt
	 */
	public void setAckRcvKnt(String ackRcvKnt) {
		this.ackRcvKnt = ackRcvKnt;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param sndUsrOfcCd
	 */
	public void setSndUsrOfcCd(String sndUsrOfcCd) {
		this.sndUsrOfcCd = sndUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param etlSeq
	 */
	public void setEtlSeq(String etlSeq) {
		this.etlSeq = etlSeq;
	}
	
	/**
	 * Column Info
	 * @param ediSndLogCtnt
	 */
	public void setEdiSndLogCtnt(String ediSndLogCtnt) {
		this.ediSndLogCtnt = ediSndLogCtnt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAckSndKnt(JSPUtil.getParameter(request, "ack_snd_knt", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setAckTpNo(JSPUtil.getParameter(request, "ack_tp_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTrsmMsgTpId(JSPUtil.getParameter(request, "trsm_msg_tp_id", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setHisSeq(JSPUtil.getParameter(request, "his_seq", ""));
		setAckRcvDt(JSPUtil.getParameter(request, "ack_rcv_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAckAcptKnt(JSPUtil.getParameter(request, "ack_acpt_knt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setAckRcvTpId(JSPUtil.getParameter(request, "ack_rcv_tp_id", ""));
		setAutoVslDepRptFlg(JSPUtil.getParameter(request, "auto_vsl_dep_rpt_flg", ""));
		setCrrBatNo(JSPUtil.getParameter(request, "crr_bat_no", ""));
		setAckRcvKnt(JSPUtil.getParameter(request, "ack_rcv_knt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setVslDepRptFlg(JSPUtil.getParameter(request, "vsl_dep_rpt_flg", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setSndUsrId(JSPUtil.getParameter(request, "snd_usr_id", ""));
		setSndUsrOfcCd(JSPUtil.getParameter(request, "snd_usr_ofc_cd", ""));
		setEtlSeq(JSPUtil.getParameter(request, "etl_seq", ""));
		setEdiSndLogCtnt(JSPUtil.getParameter(request, "edi_snd_log_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstmsSendLogVO[]
	 */
	public CstmsSendLogVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CstmsSendLogVO[]
	 */
	public CstmsSendLogVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CstmsSendLogVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] ackSndKnt = (JSPUtil.getParameter(request, prefix	+ "ack_snd_knt".trim(), length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt".trim(), length));
			String[] ackTpNo = (JSPUtil.getParameter(request, prefix	+ "ack_tp_no".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] trsmMsgTpId = (JSPUtil.getParameter(request, prefix	+ "trsm_msg_tp_id".trim(), length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd".trim(), length));
			String[] hisSeq = (JSPUtil.getParameter(request, prefix	+ "his_seq".trim(), length));
			String[] ackRcvDt = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_dt".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] ackAcptKnt = (JSPUtil.getParameter(request, prefix	+ "ack_acpt_knt".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] ackRcvTpId = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_tp_id".trim(), length));
			String[] autoVslDepRptFlg = (JSPUtil.getParameter(request, prefix	+ "auto_vsl_dep_rpt_flg".trim(), length));
			String[] crrBatNo = (JSPUtil.getParameter(request, prefix	+ "crr_bat_no".trim(), length));
			String[] ackRcvKnt = (JSPUtil.getParameter(request, prefix	+ "ack_rcv_knt".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd".trim(), length));
			String[] vslDepRptFlg = (JSPUtil.getParameter(request, prefix	+ "vsl_dep_rpt_flg".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] sndUsrId = (JSPUtil.getParameter(request, prefix	+ "snd_usr_id".trim(), length));
			String[] sndUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "snd_usr_ofc_cd".trim(), length));
			String[] etlSeq = (JSPUtil.getParameter(request, prefix	+ "etl_seq".trim(), length));
			String[] ediSndLogCtnt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_log_ctnt".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CstmsSendLogVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
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
				if (trsmMsgTpId[i] != null)
					model.setTrsmMsgTpId(trsmMsgTpId[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (hisSeq[i] != null)
					model.setHisSeq(hisSeq[i]);
				if (ackRcvDt[i] != null)
					model.setAckRcvDt(ackRcvDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ackAcptKnt[i] != null)
					model.setAckAcptKnt(ackAcptKnt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ackRcvTpId[i] != null)
					model.setAckRcvTpId(ackRcvTpId[i]);
				if (autoVslDepRptFlg[i] != null)
					model.setAutoVslDepRptFlg(autoVslDepRptFlg[i]);
				if (crrBatNo[i] != null)
					model.setCrrBatNo(crrBatNo[i]);
				if (ackRcvKnt[i] != null)
					model.setAckRcvKnt(ackRcvKnt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (vslDepRptFlg[i] != null)
					model.setVslDepRptFlg(vslDepRptFlg[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (sndUsrId[i] != null)
					model.setSndUsrId(sndUsrId[i]);
				if (sndUsrOfcCd[i] != null)
					model.setSndUsrOfcCd(sndUsrOfcCd[i]);
				if (etlSeq[i] != null)
					model.setEtlSeq(etlSeq[i]);
				if (ediSndLogCtnt[i] != null)
					model.setEdiSndLogCtnt(ediSndLogCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCstmsSendLogVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CstmsSendLogVO[]
	 */
	public CstmsSendLogVO[] getCstmsSendLogVOs(){
		CstmsSendLogVO[] vos = (CstmsSendLogVO[])models.toArray(new CstmsSendLogVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackSndKnt = this.ackSndKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackTpNo = this.ackTpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmMsgTpId = this.trsmMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hisSeq = this.hisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvDt = this.ackRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackAcptKnt = this.ackAcptKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvTpId = this.ackRcvTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoVslDepRptFlg = this.autoVslDepRptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBatNo = this.crrBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ackRcvKnt = this.ackRcvKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslDepRptFlg = this.vslDepRptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrId = this.sndUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndUsrOfcCd = this.sndUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etlSeq = this.etlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndLogCtnt = this.ediSndLogCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
