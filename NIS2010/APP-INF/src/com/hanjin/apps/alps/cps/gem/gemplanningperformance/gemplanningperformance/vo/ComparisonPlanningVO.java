/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ComparisonPlanningVO.java
*@FileTitle : ComparisonPlanningVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 박창준
*@LastVersion : 1.0
* 2009.06.17 박창준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박창준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ComparisonPlanningVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ComparisonPlanningVO> models = new ArrayList<ComparisonPlanningVO>();
	
	/* Column Info */
	private String toLoclCurrCd = null;
	/* Column Info */
	private String fmAbbrNm = null;
	/* Column Info */
	private String fmCoAmt = null;
	/* Column Info */
	private String toGenExpnCd = null;
	/* Column Info */
	private String toTcAmt = null;
	/* Column Info */
	private String fmLoclCurrCd = null;
	/* Column Info */
	private String fmOfcCd = null;
	/* Column Info */
	private String fmHqAmt = null;
	/* Column Info */
	private String fmGenExpnCd = null;
	/* Column Info */
	private String toCoAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toAbbrNm = null;
	/* Column Info */
	private String toDiff = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String toHqAmt = null;
	/* Column Info */
	private String fmTcAmt = null;
	/* Column Info */
	private String toOfcCd = null;
	/* Column Info */
	private String toRqAmt = null;
	/* Column Info */
	private String fmDiff = null;
	/* Column Info */
	private String fmRqAmt = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String genExpnItmNo = null;
	/* Column Info */
	private String plnYr = null;
	/* Column Info */
	private String fmRqstUtVal = null;
	/* Column Info */
	private String toRqstUtVal = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String genExpnTrnsDivCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ComparisonPlanningVO() {}

	public ComparisonPlanningVO(String ibflag, String pagerows, String fmOfcCd, String toOfcCd, String fmGenExpnCd, String toGenExpnCd, String fmLoclCurrCd, String toLoclCurrCd, String fmRqAmt, String toRqAmt, String fmHqAmt, String toHqAmt, String fmTcAmt, String toTcAmt, String fmCoAmt, String toCoAmt, String fmDiff, String toDiff, String fmAbbrNm, String toAbbrNm, String genExpnRqstNo, String genExpnCd, String genExpnItmNo, String plnYr, String fmRqstUtVal, String toRqstUtVal, String genExpnRqstSeq, String genExpnTrnsDivCd) {
		this.toLoclCurrCd = toLoclCurrCd;
		this.fmAbbrNm = fmAbbrNm;
		this.fmCoAmt = fmCoAmt;
		this.toGenExpnCd = toGenExpnCd;
		this.toTcAmt = toTcAmt;
		this.fmLoclCurrCd = fmLoclCurrCd;
		this.fmOfcCd = fmOfcCd;
		this.fmHqAmt = fmHqAmt;
		this.fmGenExpnCd = fmGenExpnCd;
		this.toCoAmt = toCoAmt;
		this.pagerows = pagerows;
		this.toAbbrNm = toAbbrNm;
		this.toDiff = toDiff;
		this.ibflag = ibflag;
		this.toHqAmt = toHqAmt;
		this.fmTcAmt = fmTcAmt;
		this.toOfcCd = toOfcCd;
		this.toRqAmt = toRqAmt;
		this.fmDiff = fmDiff;
		this.fmRqAmt = fmRqAmt;
		this.genExpnRqstNo = genExpnRqstNo;
		this.genExpnCd = genExpnCd;
		this.genExpnItmNo = genExpnItmNo;
		this.plnYr = plnYr;
		this.fmRqstUtVal = fmRqstUtVal;
		this.toRqstUtVal = toRqstUtVal;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_locl_curr_cd", getToLoclCurrCd());
		this.hashColumns.put("fm_abbr_nm", getFmAbbrNm());
		this.hashColumns.put("fm_co_amt", getFmCoAmt());
		this.hashColumns.put("to_gen_expn_cd", getToGenExpnCd());
		this.hashColumns.put("to_tc_amt", getToTcAmt());
		this.hashColumns.put("fm_locl_curr_cd", getFmLoclCurrCd());
		this.hashColumns.put("fm_ofc_cd", getFmOfcCd());
		this.hashColumns.put("fm_hq_amt", getFmHqAmt());
		this.hashColumns.put("fm_gen_expn_cd", getFmGenExpnCd());
		this.hashColumns.put("to_co_amt", getToCoAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_abbr_nm", getToAbbrNm());
		this.hashColumns.put("to_diff", getToDiff());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("to_hq_amt", getToHqAmt());
		this.hashColumns.put("fm_tc_amt", getFmTcAmt());
		this.hashColumns.put("to_ofc_cd", getToOfcCd());
		this.hashColumns.put("to_rq_amt", getToRqAmt());
		this.hashColumns.put("fm_diff", getFmDiff());
		this.hashColumns.put("fm_rq_amt", getFmRqAmt());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("gen_expn_itm_no", getGenExpnItmNo());
		this.hashColumns.put("pln_yr", getPlnYr());
		this.hashColumns.put("fm_rqst_ut_val", getFmRqstUtVal());
		this.hashColumns.put("to_rqst_ut_val", getToRqstUtVal());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("gen_expn_trns_div_cd", getGenExpnTrnsDivCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_locl_curr_cd", "toLoclCurrCd");
		this.hashFields.put("fm_abbr_nm", "fmAbbrNm");
		this.hashFields.put("fm_co_amt", "fmCoAmt");
		this.hashFields.put("to_gen_expn_cd", "toGenExpnCd");
		this.hashFields.put("to_tc_amt", "toTcAmt");
		this.hashFields.put("fm_locl_curr_cd", "fmLoclCurrCd");
		this.hashFields.put("fm_ofc_cd", "fmOfcCd");
		this.hashFields.put("fm_hq_amt", "fmHqAmt");
		this.hashFields.put("fm_gen_expn_cd", "fmGenExpnCd");
		this.hashFields.put("to_co_amt", "toCoAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_abbr_nm", "toAbbrNm");
		this.hashFields.put("to_diff", "toDiff");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("to_hq_amt", "toHqAmt");
		this.hashFields.put("fm_tc_amt", "fmTcAmt");
		this.hashFields.put("to_ofc_cd", "toOfcCd");
		this.hashFields.put("to_rq_amt", "toRqAmt");
		this.hashFields.put("fm_diff", "fmDiff");
		this.hashFields.put("fm_rq_amt", "fmRqAmt");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("gen_expn_itm_no", "genExpnItmNo");
		this.hashFields.put("pln_yr", "plnYr");
		this.hashFields.put("fm_rqst_ut_val", "fmRqstUtVal");
		this.hashFields.put("to_rqst_ut_val", "toRqstUtVal");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("gen_expn_trns_div_cd", "genExpnTrnsDivCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toLoclCurrCd
	 */
	public String getToLoclCurrCd() {
		return this.toLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fmAbbrNm
	 */
	public String getFmAbbrNm() {
		return this.fmAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return fmCoAmt
	 */
	public String getFmCoAmt() {
		return this.fmCoAmt;
	}
	
	/**
	 * Column Info
	 * @return toGenExpnCd
	 */
	public String getToGenExpnCd() {
		return this.toGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return toTcAmt
	 */
	public String getToTcAmt() {
		return this.toTcAmt;
	}
	
	/**
	 * Column Info
	 * @return fmLoclCurrCd
	 */
	public String getFmLoclCurrCd() {
		return this.fmLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return fmOfcCd
	 */
	public String getFmOfcCd() {
		return this.fmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmHqAmt
	 */
	public String getFmHqAmt() {
		return this.fmHqAmt;
	}
	
	/**
	 * Column Info
	 * @return fmGenExpnCd
	 */
	public String getFmGenExpnCd() {
		return this.fmGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @return toCoAmt
	 */
	public String getToCoAmt() {
		return this.toCoAmt;
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
	 * @return toAbbrNm
	 */
	public String getToAbbrNm() {
		return this.toAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return toDiff
	 */
	public String getToDiff() {
		return this.toDiff;
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
	 * @return toHqAmt
	 */
	public String getToHqAmt() {
		return this.toHqAmt;
	}
	
	/**
	 * Column Info
	 * @return fmTcAmt
	 */
	public String getFmTcAmt() {
		return this.fmTcAmt;
	}
	
	/**
	 * Column Info
	 * @return toOfcCd
	 */
	public String getToOfcCd() {
		return this.toOfcCd;
	}
	
	/**
	 * Column Info
	 * @return toRqAmt
	 */
	public String getToRqAmt() {
		return this.toRqAmt;
	}
	
	/**
	 * Column Info
	 * @return fmDiff
	 */
	public String getFmDiff() {
		return this.fmDiff;
	}
	
	/**
	 * Column Info
	 * @return fmRqAmt
	 */
	public String getFmRqAmt() {
		return this.fmRqAmt;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return this.genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @return genExpnCd
	 */
	public String getGenExpnCd() {
		return this.genExpnCd;
	}
	
	/**
	 * Column Info
	 * @return genExpnItmNo
	 */
	public String getGenExpnItmNo() {
		return this.genExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return plnYr
	 */
	public String getPlnYr() {
		return this.plnYr;
	}
	
	/**
	 * Column Info
	 * @return fmRqstUtVal
	 */
	public String getFmRqstUtVal() {
		return this.fmRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return toRqstUtVal
	 */
	public String getToRqstUtVal() {
		return this.toRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @return genExpnRqstSeq
	 */
	public String getGenExpnRqstSeq() {
		return this.genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return genExpnTrnsDivCd
	 */
	public String getGenExpnTrnsDivCd() {
		return this.genExpnTrnsDivCd;
	}
	

	/**
	 * Column Info
	 * @param toLoclCurrCd
	 */
	public void setToLoclCurrCd(String toLoclCurrCd) {
		this.toLoclCurrCd = toLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fmAbbrNm
	 */
	public void setFmAbbrNm(String fmAbbrNm) {
		this.fmAbbrNm = fmAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param fmCoAmt
	 */
	public void setFmCoAmt(String fmCoAmt) {
		this.fmCoAmt = fmCoAmt;
	}
	
	/**
	 * Column Info
	 * @param toGenExpnCd
	 */
	public void setToGenExpnCd(String toGenExpnCd) {
		this.toGenExpnCd = toGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param toTcAmt
	 */
	public void setToTcAmt(String toTcAmt) {
		this.toTcAmt = toTcAmt;
	}
	
	/**
	 * Column Info
	 * @param fmLoclCurrCd
	 */
	public void setFmLoclCurrCd(String fmLoclCurrCd) {
		this.fmLoclCurrCd = fmLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param fmOfcCd
	 */
	public void setFmOfcCd(String fmOfcCd) {
		this.fmOfcCd = fmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmHqAmt
	 */
	public void setFmHqAmt(String fmHqAmt) {
		this.fmHqAmt = fmHqAmt;
	}
	
	/**
	 * Column Info
	 * @param fmGenExpnCd
	 */
	public void setFmGenExpnCd(String fmGenExpnCd) {
		this.fmGenExpnCd = fmGenExpnCd;
	}
	
	/**
	 * Column Info
	 * @param toCoAmt
	 */
	public void setToCoAmt(String toCoAmt) {
		this.toCoAmt = toCoAmt;
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
	 * @param toAbbrNm
	 */
	public void setToAbbrNm(String toAbbrNm) {
		this.toAbbrNm = toAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param toDiff
	 */
	public void setToDiff(String toDiff) {
		this.toDiff = toDiff;
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
	 * @param toHqAmt
	 */
	public void setToHqAmt(String toHqAmt) {
		this.toHqAmt = toHqAmt;
	}
	
	/**
	 * Column Info
	 * @param fmTcAmt
	 */
	public void setFmTcAmt(String fmTcAmt) {
		this.fmTcAmt = fmTcAmt;
	}
	
	/**
	 * Column Info
	 * @param toOfcCd
	 */
	public void setToOfcCd(String toOfcCd) {
		this.toOfcCd = toOfcCd;
	}
	
	/**
	 * Column Info
	 * @param toRqAmt
	 */
	public void setToRqAmt(String toRqAmt) {
		this.toRqAmt = toRqAmt;
	}
	
	/**
	 * Column Info
	 * @param fmDiff
	 */
	public void setFmDiff(String fmDiff) {
		this.fmDiff = fmDiff;
	}
	
	/**
	 * Column Info
	 * @param fmRqAmt
	 */
	public void setFmRqAmt(String fmRqAmt) {
		this.fmRqAmt = fmRqAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstNo
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
	}
	
	/**
	 * Column Info
	 * @param genExpnCd
	 */
	public void setGenExpnCd(String genExpnCd) {
		this.genExpnCd = genExpnCd;
	}
	
	/**
	 * Column Info
	 * @param genExpnItmNo
	 */
	public void setGenExpnItmNo(String genExpnItmNo) {
		this.genExpnItmNo = genExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param plnYr
	 */
	public void setPlnYr(String plnYr) {
		this.plnYr = plnYr;
	}
	
	/**
	 * Column Info
	 * @param fmRqstUtVal
	 */
	public void setFmRqstUtVal(String fmRqstUtVal) {
		this.fmRqstUtVal = fmRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param toRqstUtVal
	 */
	public void setToRqstUtVal(String toRqstUtVal) {
		this.toRqstUtVal = toRqstUtVal;
	}
	
	/**
	 * Column Info
	 * @param genExpnRqstSeq
	 */
	public void setGenExpnRqstSeq(String genExpnRqstSeq) {
		this.genExpnRqstSeq = genExpnRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param genExpnTrnsDivCd
	 */
	public void setGenExpnTrnsDivCd(String genExpnTrnsDivCd) {
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setToLoclCurrCd(JSPUtil.getParameter(request, "to_locl_curr_cd", ""));
		setFmAbbrNm(JSPUtil.getParameter(request, "fm_abbr_nm", ""));
		setFmCoAmt(JSPUtil.getParameter(request, "fm_co_amt", ""));
		setToGenExpnCd(JSPUtil.getParameter(request, "to_gen_expn_cd", ""));
		setToTcAmt(JSPUtil.getParameter(request, "to_tc_amt", ""));
		setFmLoclCurrCd(JSPUtil.getParameter(request, "fm_locl_curr_cd", ""));
		setFmOfcCd(JSPUtil.getParameter(request, "fm_ofc_cd", ""));
		setFmHqAmt(JSPUtil.getParameter(request, "fm_hq_amt", ""));
		setFmGenExpnCd(JSPUtil.getParameter(request, "fm_gen_expn_cd", ""));
		setToCoAmt(JSPUtil.getParameter(request, "to_co_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToAbbrNm(JSPUtil.getParameter(request, "to_abbr_nm", ""));
		setToDiff(JSPUtil.getParameter(request, "to_diff", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setToHqAmt(JSPUtil.getParameter(request, "to_hq_amt", ""));
		setFmTcAmt(JSPUtil.getParameter(request, "fm_tc_amt", ""));
		setToOfcCd(JSPUtil.getParameter(request, "to_ofc_cd", ""));
		setToRqAmt(JSPUtil.getParameter(request, "to_rq_amt", ""));
		setFmDiff(JSPUtil.getParameter(request, "fm_diff", ""));
		setFmRqAmt(JSPUtil.getParameter(request, "fm_rq_amt", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setGenExpnItmNo(JSPUtil.getParameter(request, "gen_expn_itm_no", ""));
		setPlnYr(JSPUtil.getParameter(request, "pln_yr", ""));
		setFmRqstUtVal(JSPUtil.getParameter(request, "fm_rqst_ut_val", ""));
		setToRqstUtVal(JSPUtil.getParameter(request, "to_rqst_ut_val", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, "gen_expn_rqst_seq", ""));
		setGenExpnTrnsDivCd(JSPUtil.getParameter(request, "gen_expn_trns_div_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ComparisonPlanningVO[]
	 */
	public ComparisonPlanningVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ComparisonPlanningVO[]
	 */
	public ComparisonPlanningVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ComparisonPlanningVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "to_locl_curr_cd", length));
			String[] fmAbbrNm = (JSPUtil.getParameter(request, prefix	+ "fm_abbr_nm", length));
			String[] fmCoAmt = (JSPUtil.getParameter(request, prefix	+ "fm_co_amt", length));
			String[] toGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "to_gen_expn_cd", length));
			String[] toTcAmt = (JSPUtil.getParameter(request, prefix	+ "to_tc_amt", length));
			String[] fmLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "fm_locl_curr_cd", length));
			String[] fmOfcCd = (JSPUtil.getParameter(request, prefix	+ "fm_ofc_cd", length));
			String[] fmHqAmt = (JSPUtil.getParameter(request, prefix	+ "fm_hq_amt", length));
			String[] fmGenExpnCd = (JSPUtil.getParameter(request, prefix	+ "fm_gen_expn_cd", length));
			String[] toCoAmt = (JSPUtil.getParameter(request, prefix	+ "to_co_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toAbbrNm = (JSPUtil.getParameter(request, prefix	+ "to_abbr_nm", length));
			String[] toDiff = (JSPUtil.getParameter(request, prefix	+ "to_diff", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] toHqAmt = (JSPUtil.getParameter(request, prefix	+ "to_hq_amt", length));
			String[] fmTcAmt = (JSPUtil.getParameter(request, prefix	+ "fm_tc_amt", length));
			String[] toOfcCd = (JSPUtil.getParameter(request, prefix	+ "to_ofc_cd", length));
			String[] toRqAmt = (JSPUtil.getParameter(request, prefix	+ "to_rq_amt", length));
			String[] fmDiff = (JSPUtil.getParameter(request, prefix	+ "fm_diff", length));
			String[] fmRqAmt = (JSPUtil.getParameter(request, prefix	+ "fm_rq_amt", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] genExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_no", length));
			String[] plnYr = (JSPUtil.getParameter(request, prefix	+ "pln_yr", length));
			String[] fmRqstUtVal = (JSPUtil.getParameter(request, prefix	+ "fm_rqst_ut_val", length));
			String[] toRqstUtVal = (JSPUtil.getParameter(request, prefix	+ "to_rqst_ut_val", length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq", length));
			String[] genExpnTrnsDivCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_trns_div_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ComparisonPlanningVO();
				if (toLoclCurrCd[i] != null)
					model.setToLoclCurrCd(toLoclCurrCd[i]);
				if (fmAbbrNm[i] != null)
					model.setFmAbbrNm(fmAbbrNm[i]);
				if (fmCoAmt[i] != null)
					model.setFmCoAmt(fmCoAmt[i]);
				if (toGenExpnCd[i] != null)
					model.setToGenExpnCd(toGenExpnCd[i]);
				if (toTcAmt[i] != null)
					model.setToTcAmt(toTcAmt[i]);
				if (fmLoclCurrCd[i] != null)
					model.setFmLoclCurrCd(fmLoclCurrCd[i]);
				if (fmOfcCd[i] != null)
					model.setFmOfcCd(fmOfcCd[i]);
				if (fmHqAmt[i] != null)
					model.setFmHqAmt(fmHqAmt[i]);
				if (fmGenExpnCd[i] != null)
					model.setFmGenExpnCd(fmGenExpnCd[i]);
				if (toCoAmt[i] != null)
					model.setToCoAmt(toCoAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toAbbrNm[i] != null)
					model.setToAbbrNm(toAbbrNm[i]);
				if (toDiff[i] != null)
					model.setToDiff(toDiff[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (toHqAmt[i] != null)
					model.setToHqAmt(toHqAmt[i]);
				if (fmTcAmt[i] != null)
					model.setFmTcAmt(fmTcAmt[i]);
				if (toOfcCd[i] != null)
					model.setToOfcCd(toOfcCd[i]);
				if (toRqAmt[i] != null)
					model.setToRqAmt(toRqAmt[i]);
				if (fmDiff[i] != null)
					model.setFmDiff(fmDiff[i]);
				if (fmRqAmt[i] != null)
					model.setFmRqAmt(fmRqAmt[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (genExpnItmNo[i] != null)
					model.setGenExpnItmNo(genExpnItmNo[i]);
				if (plnYr[i] != null)
					model.setPlnYr(plnYr[i]);
				if (fmRqstUtVal[i] != null)
					model.setFmRqstUtVal(fmRqstUtVal[i]);
				if (toRqstUtVal[i] != null)
					model.setToRqstUtVal(toRqstUtVal[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (genExpnTrnsDivCd[i] != null)
					model.setGenExpnTrnsDivCd(genExpnTrnsDivCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getComparisonPlanningVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ComparisonPlanningVO[]
	 */
	public ComparisonPlanningVO[] getComparisonPlanningVOs(){
		ComparisonPlanningVO[] vos = (ComparisonPlanningVO[])models.toArray(new ComparisonPlanningVO[models.size()]);
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
		this.toLoclCurrCd = this.toLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmAbbrNm = this.fmAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmCoAmt = this.fmCoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toGenExpnCd = this.toGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTcAmt = this.toTcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmLoclCurrCd = this.fmLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmOfcCd = this.fmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmHqAmt = this.fmHqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmGenExpnCd = this.fmGenExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCoAmt = this.toCoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toAbbrNm = this.toAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDiff = this.toDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toHqAmt = this.toHqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTcAmt = this.fmTcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toOfcCd = this.toOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqAmt = this.toRqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDiff = this.fmDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqAmt = this.fmRqAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmNo = this.genExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnYr = this.plnYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmRqstUtVal = this.fmRqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toRqstUtVal = this.toRqstUtVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnTrnsDivCd = this.genExpnTrnsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
