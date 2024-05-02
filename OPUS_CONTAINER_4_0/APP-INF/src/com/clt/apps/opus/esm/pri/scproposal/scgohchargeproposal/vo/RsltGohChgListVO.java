/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltGohChgListVO.java
*@FileTitle : RsltGohChgListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.17
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.05.17 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scgohchargeproposal.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltGohChgListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltGohChgListVO> models = new ArrayList<RsltGohChgListVO>();
	
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String routPntLocDefCd = null;
	/* Column Info */
	private String perType = null;
	/* Column Info */
	private String coffrFrtRtAmt = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String routPntLocTpCd = null;
	/* Column Info */
	private String gohChgSeq = null;
	/* Column Info */
	private String acptOfcCd = null;
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String routPntLocDefNm = null;
	/* Column Info */
	private String acptUsrNm = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String acptUsrId = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String propFrtRtAmt = null;
	/* Column Info */
	private String prcHngrBarTpSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String prcHngrBarTpCd = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String propNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltGohChgListVO() {}

	public RsltGohChgListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String gohChgSeq, String routPntLocTpCd, String routPntLocDefCd, String routPntLocDefNm, String ratUtCd, String prcHngrBarTpCd, String prcHngrBarTpSeq, String currCd, String propFrtRtAmt, String coffrFrtRtAmt, String fnlFrtRtAmt, String prcProgStsCd, String srcInfoCd, String acptUsrId, String acptUsrNm, String acptOfcCd, String acptDt, String creUsrId, String updUsrId, String n1stCmncAmdtSeq, String effDt, String expDt, String perType) {
		this.currCd = currCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.routPntLocDefCd = routPntLocDefCd;
		this.perType = perType;
		this.coffrFrtRtAmt = coffrFrtRtAmt;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.pagerows = pagerows;
		this.prcProgStsCd = prcProgStsCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.expDt = expDt;
		this.updUsrId = updUsrId;
		this.routPntLocTpCd = routPntLocTpCd;
		this.gohChgSeq = gohChgSeq;
		this.acptOfcCd = acptOfcCd;
		this.acptDt = acptDt;
		this.routPntLocDefNm = routPntLocDefNm;
		this.acptUsrNm = acptUsrNm;
		this.srcInfoCd = srcInfoCd;
		this.acptUsrId = acptUsrId;
		this.ratUtCd = ratUtCd;
		this.propFrtRtAmt = propFrtRtAmt;
		this.prcHngrBarTpSeq = prcHngrBarTpSeq;
		this.creUsrId = creUsrId;
		this.prcHngrBarTpCd = prcHngrBarTpCd;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.propNo = propNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("per_type", getPerType());
		this.hashColumns.put("coffr_frt_rt_amt", getCoffrFrtRtAmt());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
		this.hashColumns.put("goh_chg_seq", getGohChgSeq());
		this.hashColumns.put("acpt_ofc_cd", getAcptOfcCd());
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("rout_pnt_loc_def_nm", getRoutPntLocDefNm());
		this.hashColumns.put("acpt_usr_nm", getAcptUsrNm());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("acpt_usr_id", getAcptUsrId());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("prop_frt_rt_amt", getPropFrtRtAmt());
		this.hashColumns.put("prc_hngr_bar_tp_seq", getPrcHngrBarTpSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prc_hngr_bar_tp_cd", getPrcHngrBarTpCd());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("per_type", "perType");
		this.hashFields.put("coffr_frt_rt_amt", "coffrFrtRtAmt");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
		this.hashFields.put("goh_chg_seq", "gohChgSeq");
		this.hashFields.put("acpt_ofc_cd", "acptOfcCd");
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("rout_pnt_loc_def_nm", "routPntLocDefNm");
		this.hashFields.put("acpt_usr_nm", "acptUsrNm");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("acpt_usr_id", "acptUsrId");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("prop_frt_rt_amt", "propFrtRtAmt");
		this.hashFields.put("prc_hngr_bar_tp_seq", "prcHngrBarTpSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prc_hngr_bar_tp_cd", "prcHngrBarTpCd");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		return this.hashFields;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return routPntLocDefCd
	 */
	public String getRoutPntLocDefCd() {
		return this.routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return perType
	 */
	public String getPerType() {
		return this.perType;
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
	 * @return prcProgStsCd
	 */
	public String getPrcProgStsCd() {
		return this.prcProgStsCd;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
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
	 * @return routPntLocTpCd
	 */
	public String getRoutPntLocTpCd() {
		return this.routPntLocTpCd;
	}
	
	/**
	 * Column Info
	 * @return gohChgSeq
	 */
	public String getGohChgSeq() {
		return this.gohChgSeq;
	}
	
	/**
	 * Column Info
	 * @return acptOfcCd
	 */
	public String getAcptOfcCd() {
		return this.acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
	}
	
	/**
	 * Column Info
	 * @return routPntLocDefNm
	 */
	public String getRoutPntLocDefNm() {
		return this.routPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @return acptUsrNm
	 */
	public String getAcptUsrNm() {
		return this.acptUsrNm;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return acptUsrId
	 */
	public String getAcptUsrId() {
		return this.acptUsrId;
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
	 * @return propFrtRtAmt
	 */
	public String getPropFrtRtAmt() {
		return this.propFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return prcHngrBarTpSeq
	 */
	public String getPrcHngrBarTpSeq() {
		return this.prcHngrBarTpSeq;
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
	 * @return prcHngrBarTpCd
	 */
	public String getPrcHngrBarTpCd() {
		return this.prcHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param routPntLocDefCd
	 */
	public void setRoutPntLocDefCd(String routPntLocDefCd) {
		this.routPntLocDefCd = routPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param perType
	 */
	public void setPerType(String perType) {
		this.perType = perType;
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
	 * @param prcProgStsCd
	 */
	public void setPrcProgStsCd(String prcProgStsCd) {
		this.prcProgStsCd = prcProgStsCd;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
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
	 * @param routPntLocTpCd
	 */
	public void setRoutPntLocTpCd(String routPntLocTpCd) {
		this.routPntLocTpCd = routPntLocTpCd;
	}
	
	/**
	 * Column Info
	 * @param gohChgSeq
	 */
	public void setGohChgSeq(String gohChgSeq) {
		this.gohChgSeq = gohChgSeq;
	}
	
	/**
	 * Column Info
	 * @param acptOfcCd
	 */
	public void setAcptOfcCd(String acptOfcCd) {
		this.acptOfcCd = acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
	}
	
	/**
	 * Column Info
	 * @param routPntLocDefNm
	 */
	public void setRoutPntLocDefNm(String routPntLocDefNm) {
		this.routPntLocDefNm = routPntLocDefNm;
	}
	
	/**
	 * Column Info
	 * @param acptUsrNm
	 */
	public void setAcptUsrNm(String acptUsrNm) {
		this.acptUsrNm = acptUsrNm;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param acptUsrId
	 */
	public void setAcptUsrId(String acptUsrId) {
		this.acptUsrId = acptUsrId;
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
	 * @param propFrtRtAmt
	 */
	public void setPropFrtRtAmt(String propFrtRtAmt) {
		this.propFrtRtAmt = propFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param prcHngrBarTpSeq
	 */
	public void setPrcHngrBarTpSeq(String prcHngrBarTpSeq) {
		this.prcHngrBarTpSeq = prcHngrBarTpSeq;
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
	 * @param prcHngrBarTpCd
	 */
	public void setPrcHngrBarTpCd(String prcHngrBarTpCd) {
		this.prcHngrBarTpCd = prcHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
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
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_cd", ""));
		setPerType(JSPUtil.getParameter(request, prefix + "per_type", ""));
		setCoffrFrtRtAmt(JSPUtil.getParameter(request, prefix + "coffr_frt_rt_amt", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, prefix + "prc_prog_sts_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRoutPntLocTpCd(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_tp_cd", ""));
		setGohChgSeq(JSPUtil.getParameter(request, prefix + "goh_chg_seq", ""));
		setAcptOfcCd(JSPUtil.getParameter(request, prefix + "acpt_ofc_cd", ""));
		setAcptDt(JSPUtil.getParameter(request, prefix + "acpt_dt", ""));
		setRoutPntLocDefNm(JSPUtil.getParameter(request, prefix + "rout_pnt_loc_def_nm", ""));
		setAcptUsrNm(JSPUtil.getParameter(request, prefix + "acpt_usr_nm", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, prefix + "src_info_cd", ""));
		setAcptUsrId(JSPUtil.getParameter(request, prefix + "acpt_usr_id", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPropFrtRtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_rt_amt", ""));
		setPrcHngrBarTpSeq(JSPUtil.getParameter(request, prefix + "prc_hngr_bar_tp_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPrcHngrBarTpCd(JSPUtil.getParameter(request, prefix + "prc_hngr_bar_tp_cd", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltGohChgListVO[]
	 */
	public RsltGohChgListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltGohChgListVO[]
	 */
	public RsltGohChgListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltGohChgListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] routPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_cd", length));
			String[] perType = (JSPUtil.getParameter(request, prefix	+ "per_type", length));
			String[] coffrFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "coffr_frt_rt_amt", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] routPntLocTpCd = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_tp_cd", length));
			String[] gohChgSeq = (JSPUtil.getParameter(request, prefix	+ "goh_chg_seq", length));
			String[] acptOfcCd = (JSPUtil.getParameter(request, prefix	+ "acpt_ofc_cd", length));
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] routPntLocDefNm = (JSPUtil.getParameter(request, prefix	+ "rout_pnt_loc_def_nm", length));
			String[] acptUsrNm = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_nm", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] acptUsrId = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_id", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] propFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_rt_amt", length));
			String[] prcHngrBarTpSeq = (JSPUtil.getParameter(request, prefix	+ "prc_hngr_bar_tp_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] prcHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_hngr_bar_tp_cd", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltGohChgListVO();
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (routPntLocDefCd[i] != null)
					model.setRoutPntLocDefCd(routPntLocDefCd[i]);
				if (perType[i] != null)
					model.setPerType(perType[i]);
				if (coffrFrtRtAmt[i] != null)
					model.setCoffrFrtRtAmt(coffrFrtRtAmt[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (routPntLocTpCd[i] != null)
					model.setRoutPntLocTpCd(routPntLocTpCd[i]);
				if (gohChgSeq[i] != null)
					model.setGohChgSeq(gohChgSeq[i]);
				if (acptOfcCd[i] != null)
					model.setAcptOfcCd(acptOfcCd[i]);
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (routPntLocDefNm[i] != null)
					model.setRoutPntLocDefNm(routPntLocDefNm[i]);
				if (acptUsrNm[i] != null)
					model.setAcptUsrNm(acptUsrNm[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (acptUsrId[i] != null)
					model.setAcptUsrId(acptUsrId[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (propFrtRtAmt[i] != null)
					model.setPropFrtRtAmt(propFrtRtAmt[i]);
				if (prcHngrBarTpSeq[i] != null)
					model.setPrcHngrBarTpSeq(prcHngrBarTpSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (prcHngrBarTpCd[i] != null)
					model.setPrcHngrBarTpCd(prcHngrBarTpCd[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltGohChgListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltGohChgListVO[]
	 */
	public RsltGohChgListVO[] getRsltGohChgListVOs(){
		RsltGohChgListVO[] vos = (RsltGohChgListVO[])models.toArray(new RsltGohChgListVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd = this.routPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perType = this.perType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coffrFrtRtAmt = this.coffrFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocTpCd = this.routPntLocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohChgSeq = this.gohChgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptOfcCd = this.acptOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefNm = this.routPntLocDefNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrNm = this.acptUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrId = this.acptUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtRtAmt = this.propFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcHngrBarTpSeq = this.prcHngrBarTpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcHngrBarTpCd = this.prcHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
