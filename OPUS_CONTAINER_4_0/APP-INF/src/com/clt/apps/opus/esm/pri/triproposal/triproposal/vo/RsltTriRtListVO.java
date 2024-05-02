/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RsltTriRtListVO.java
*@FileTitle : RsltTriRtListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.25
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2011.02.25 송민석 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.triproposal.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltTriRtListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltTriRtListVO> models = new ArrayList<RsltTriRtListVO>();
	
	/* Column Info */
	private String triRmk = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String griApplAmt = null;
	/* Column Info */
	private String triPropNo = null;
	/* Column Info */
	private String pubDt = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String coffrFrtRtAmt = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String triRqstUsrId = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String triAproUsrId = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String triRqstUsrNm = null;
	/* Column Info */
	private String triRqstOfcCd = null;
	/* Column Info */
	private String triAproOfcCd = null;
	/* Column Info */
	private String griApplTpCd = null;
	/* Column Info */
	private String propFrtRtAmt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String noteConvMapgId = null;
	/* Column Info */
	private String propStsNm = null;
	/* Column Info */
	private String triAproUsrNm = null;
	/* Column Info */
	private String triNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltTriRtListVO() {}

	public RsltTriRtListVO(String ibflag, String pagerows, String triPropNo, String amdtSeq, String ratUtCd, String prcCgoTpCd, String currCd, String propFrtRtAmt, String coffrFrtRtAmt, String fnlFrtRtAmt, String noteCtnt, String noteConvMapgId, String effDt, String expDt, String triRqstOfcCd, String triRqstUsrId, String triRqstUsrNm, String triAproOfcCd, String triAproUsrId, String triAproUsrNm, String propStsCd, String propStsNm, String pubDt, String griApplTpCd, String griApplAmt, String triNo, String cmdtCd, String triRmk) {
		this.triRmk = triRmk;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.amdtSeq = amdtSeq;
		this.griApplAmt = griApplAmt;
		this.triPropNo = triPropNo;
		this.pubDt = pubDt;
		this.noteCtnt = noteCtnt;
		this.coffrFrtRtAmt = coffrFrtRtAmt;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.pagerows = pagerows;
		this.triRqstUsrId = triRqstUsrId;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.triAproUsrId = triAproUsrId;
		this.propStsCd = propStsCd;
		this.expDt = expDt;
		this.triRqstUsrNm = triRqstUsrNm;
		this.triRqstOfcCd = triRqstOfcCd;
		this.triAproOfcCd = triAproOfcCd;
		this.griApplTpCd = griApplTpCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.ratUtCd = ratUtCd;
		this.noteConvMapgId = noteConvMapgId;
		this.propStsNm = propStsNm;
		this.triAproUsrNm = triAproUsrNm;
		this.triNo = triNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tri_rmk", getTriRmk());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("gri_appl_amt", getGriApplAmt());
		this.hashColumns.put("tri_prop_no", getTriPropNo());
		this.hashColumns.put("pub_dt", getPubDt());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("coffr_frt_rt_amt", getCoffrFrtRtAmt());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tri_rqst_usr_id", getTriRqstUsrId());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("tri_apro_usr_id", getTriAproUsrId());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("tri_rqst_usr_nm", getTriRqstUsrNm());
		this.hashColumns.put("tri_rqst_ofc_cd", getTriRqstOfcCd());
		this.hashColumns.put("tri_apro_ofc_cd", getTriAproOfcCd());
		this.hashColumns.put("gri_appl_tp_cd", getGriApplTpCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
		this.hashColumns.put("prop_sts_nm", getPropStsNm());
		this.hashColumns.put("tri_apro_usr_nm", getTriAproUsrNm());
		this.hashColumns.put("tri_no", getTriNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("tri_rmk", "triRmk");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("gri_appl_amt", "griApplAmt");
		this.hashFields.put("tri_prop_no", "triPropNo");
		this.hashFields.put("pub_dt", "pubDt");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("coffr_frt_rt_amt", "coffrFrtRtAmt");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tri_rqst_usr_id", "triRqstUsrId");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("tri_apro_usr_id", "triAproUsrId");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("tri_rqst_usr_nm", "triRqstUsrNm");
		this.hashFields.put("tri_rqst_ofc_cd", "triRqstOfcCd");
		this.hashFields.put("tri_apro_ofc_cd", "triAproOfcCd");
		this.hashFields.put("gri_appl_tp_cd", "griApplTpCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("note_conv_mapg_id", "noteConvMapgId");
		this.hashFields.put("prop_sts_nm", "propStsNm");
		this.hashFields.put("tri_apro_usr_nm", "triAproUsrNm");
		this.hashFields.put("tri_no", "triNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return triRmk
	 */
	public String getTriRmk() {
		return this.triRmk;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return griApplAmt
	 */
	public String getGriApplAmt() {
		return this.griApplAmt;
	}
	
	/**
	 * Column Info
	 * @return triPropNo
	 */
	public String getTriPropNo() {
		return this.triPropNo;
	}
	
	/**
	 * Column Info
	 * @return pubDt
	 */
	public String getPubDt() {
		return this.pubDt;
	}
	
	/**
	 * Column Info
	 * @return noteCtnt
	 */
	public String getNoteCtnt() {
		return this.noteCtnt;
	}
	
	/**
	 * Column Info
	 * @return coffrFrtRtAmt
	 */
	public String getCoffrFrtRtAmt() {
		return this.coffrFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return fnlFrtRtAmt
	 */
	public String getFnlFrtRtAmt() {
		return this.fnlFrtRtAmt;
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
	 * @return triRqstUsrId
	 */
	public String getTriRqstUsrId() {
		return this.triRqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return triAproUsrId
	 */
	public String getTriAproUsrId() {
		return this.triAproUsrId;
	}
	
	/**
	 * Column Info
	 * @return propStsCd
	 */
	public String getPropStsCd() {
		return this.propStsCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return triRqstUsrNm
	 */
	public String getTriRqstUsrNm() {
		return this.triRqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return triRqstOfcCd
	 */
	public String getTriRqstOfcCd() {
		return this.triRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return triAproOfcCd
	 */
	public String getTriAproOfcCd() {
		return this.triAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return griApplTpCd
	 */
	public String getGriApplTpCd() {
		return this.griApplTpCd;
	}
	
	/**
	 * Column Info
	 * @return propFrtRtAmt
	 */
	public String getPropFrtRtAmt() {
		return this.propFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return noteConvMapgId
	 */
	public String getNoteConvMapgId() {
		return this.noteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return propStsNm
	 */
	public String getPropStsNm() {
		return this.propStsNm;
	}
	
	/**
	 * Column Info
	 * @return triAproUsrNm
	 */
	public String getTriAproUsrNm() {
		return this.triAproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return triNo
	 */
	public String getTriNo() {
		return this.triNo;
	}
	

	/**
	 * Column Info
	 * @param triRmk
	 */
	public void setTriRmk(String triRmk) {
		this.triRmk = triRmk;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param griApplAmt
	 */
	public void setGriApplAmt(String griApplAmt) {
		this.griApplAmt = griApplAmt;
	}
	
	/**
	 * Column Info
	 * @param triPropNo
	 */
	public void setTriPropNo(String triPropNo) {
		this.triPropNo = triPropNo;
	}
	
	/**
	 * Column Info
	 * @param pubDt
	 */
	public void setPubDt(String pubDt) {
		this.pubDt = pubDt;
	}
	
	/**
	 * Column Info
	 * @param noteCtnt
	 */
	public void setNoteCtnt(String noteCtnt) {
		this.noteCtnt = noteCtnt;
	}
	
	/**
	 * Column Info
	 * @param coffrFrtRtAmt
	 */
	public void setCoffrFrtRtAmt(String coffrFrtRtAmt) {
		this.coffrFrtRtAmt = coffrFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param fnlFrtRtAmt
	 */
	public void setFnlFrtRtAmt(String fnlFrtRtAmt) {
		this.fnlFrtRtAmt = fnlFrtRtAmt;
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
	 * @param triRqstUsrId
	 */
	public void setTriRqstUsrId(String triRqstUsrId) {
		this.triRqstUsrId = triRqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param triAproUsrId
	 */
	public void setTriAproUsrId(String triAproUsrId) {
		this.triAproUsrId = triAproUsrId;
	}
	
	/**
	 * Column Info
	 * @param propStsCd
	 */
	public void setPropStsCd(String propStsCd) {
		this.propStsCd = propStsCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param triRqstUsrNm
	 */
	public void setTriRqstUsrNm(String triRqstUsrNm) {
		this.triRqstUsrNm = triRqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param triRqstOfcCd
	 */
	public void setTriRqstOfcCd(String triRqstOfcCd) {
		this.triRqstOfcCd = triRqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param triAproOfcCd
	 */
	public void setTriAproOfcCd(String triAproOfcCd) {
		this.triAproOfcCd = triAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param griApplTpCd
	 */
	public void setGriApplTpCd(String griApplTpCd) {
		this.griApplTpCd = griApplTpCd;
	}
	
	/**
	 * Column Info
	 * @param propFrtRtAmt
	 */
	public void setPropFrtRtAmt(String propFrtRtAmt) {
		this.propFrtRtAmt = propFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param noteConvMapgId
	 */
	public void setNoteConvMapgId(String noteConvMapgId) {
		this.noteConvMapgId = noteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param propStsNm
	 */
	public void setPropStsNm(String propStsNm) {
		this.propStsNm = propStsNm;
	}
	
	/**
	 * Column Info
	 * @param triAproUsrNm
	 */
	public void setTriAproUsrNm(String triAproUsrNm) {
		this.triAproUsrNm = triAproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param triNo
	 */
	public void setTriNo(String triNo) {
		this.triNo = triNo;
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
		setTriRmk(JSPUtil.getParameter(request, prefix + "tri_rmk", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setGriApplAmt(JSPUtil.getParameter(request, prefix + "gri_appl_amt", ""));
		setTriPropNo(JSPUtil.getParameter(request, prefix + "tri_prop_no", ""));
		setPubDt(JSPUtil.getParameter(request, prefix + "pub_dt", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setCoffrFrtRtAmt(JSPUtil.getParameter(request, prefix + "coffr_frt_rt_amt", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTriRqstUsrId(JSPUtil.getParameter(request, prefix + "tri_rqst_usr_id", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setTriAproUsrId(JSPUtil.getParameter(request, prefix + "tri_apro_usr_id", ""));
		setPropStsCd(JSPUtil.getParameter(request, prefix + "prop_sts_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setTriRqstUsrNm(JSPUtil.getParameter(request, prefix + "tri_rqst_usr_nm", ""));
		setTriRqstOfcCd(JSPUtil.getParameter(request, prefix + "tri_rqst_ofc_cd", ""));
		setTriAproOfcCd(JSPUtil.getParameter(request, prefix + "tri_apro_ofc_cd", ""));
		setGriApplTpCd(JSPUtil.getParameter(request, prefix + "gri_appl_tp_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_rt_amt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request, prefix + "note_conv_mapg_id", ""));
		setPropStsNm(JSPUtil.getParameter(request, prefix + "prop_sts_nm", ""));
		setTriAproUsrNm(JSPUtil.getParameter(request, prefix + "tri_apro_usr_nm", ""));
		setTriNo(JSPUtil.getParameter(request, prefix + "tri_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltTriRtListVO[]
	 */
	public RsltTriRtListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltTriRtListVO[]
	 */
	public RsltTriRtListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltTriRtListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] triRmk = (JSPUtil.getParameter(request, prefix	+ "tri_rmk", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] griApplAmt = (JSPUtil.getParameter(request, prefix	+ "gri_appl_amt", length));
			String[] triPropNo = (JSPUtil.getParameter(request, prefix	+ "tri_prop_no", length));
			String[] pubDt = (JSPUtil.getParameter(request, prefix	+ "pub_dt", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] coffrFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "coffr_frt_rt_amt", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] triRqstUsrId = (JSPUtil.getParameter(request, prefix	+ "tri_rqst_usr_id", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] triAproUsrId = (JSPUtil.getParameter(request, prefix	+ "tri_apro_usr_id", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] triRqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "tri_rqst_usr_nm", length));
			String[] triRqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "tri_rqst_ofc_cd", length));
			String[] triAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "tri_apro_ofc_cd", length));
			String[] griApplTpCd = (JSPUtil.getParameter(request, prefix	+ "gri_appl_tp_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_rt_amt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] noteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "note_conv_mapg_id", length));
			String[] propStsNm = (JSPUtil.getParameter(request, prefix	+ "prop_sts_nm", length));
			String[] triAproUsrNm = (JSPUtil.getParameter(request, prefix	+ "tri_apro_usr_nm", length));
			String[] triNo = (JSPUtil.getParameter(request, prefix	+ "tri_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltTriRtListVO();
				if (triRmk[i] != null)
					model.setTriRmk(triRmk[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (griApplAmt[i] != null)
					model.setGriApplAmt(griApplAmt[i]);
				if (triPropNo[i] != null)
					model.setTriPropNo(triPropNo[i]);
				if (pubDt[i] != null)
					model.setPubDt(pubDt[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (coffrFrtRtAmt[i] != null)
					model.setCoffrFrtRtAmt(coffrFrtRtAmt[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (triRqstUsrId[i] != null)
					model.setTriRqstUsrId(triRqstUsrId[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (triAproUsrId[i] != null)
					model.setTriAproUsrId(triAproUsrId[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (triRqstUsrNm[i] != null)
					model.setTriRqstUsrNm(triRqstUsrNm[i]);
				if (triRqstOfcCd[i] != null)
					model.setTriRqstOfcCd(triRqstOfcCd[i]);
				if (triAproOfcCd[i] != null)
					model.setTriAproOfcCd(triAproOfcCd[i]);
				if (griApplTpCd[i] != null)
					model.setGriApplTpCd(griApplTpCd[i]);
				if (propFrtRtAmt[i] != null)
					model.setPropFrtRtAmt(propFrtRtAmt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (noteConvMapgId[i] != null)
					model.setNoteConvMapgId(noteConvMapgId[i]);
				if (propStsNm[i] != null)
					model.setPropStsNm(propStsNm[i]);
				if (triAproUsrNm[i] != null)
					model.setTriAproUsrNm(triAproUsrNm[i]);
				if (triNo[i] != null)
					model.setTriNo(triNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltTriRtListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltTriRtListVO[]
	 */
	public RsltTriRtListVO[] getRsltTriRtListVOs(){
		RsltTriRtListVO[] vos = (RsltTriRtListVO[])models.toArray(new RsltTriRtListVO[models.size()]);
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
		this.triRmk = this.triRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplAmt = this.griApplAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triPropNo = this.triPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pubDt = this.pubDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coffrFrtRtAmt = this.coffrFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRqstUsrId = this.triRqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAproUsrId = this.triAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRqstUsrNm = this.triRqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRqstOfcCd = this.triRqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAproOfcCd = this.triAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplTpCd = this.griApplTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvMapgId = this.noteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsNm = this.propStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triAproUsrNm = this.triAproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triNo = this.triNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
