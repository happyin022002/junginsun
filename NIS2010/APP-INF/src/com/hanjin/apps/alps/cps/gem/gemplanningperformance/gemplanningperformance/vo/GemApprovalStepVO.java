/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GemApprovalStepVO.java
*@FileTitle : GemApprovalStepVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.06.19 진윤오 
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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GemApprovalStepVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemApprovalStepVO> models = new ArrayList<GemApprovalStepVO>();
	
	/* Column Info */
	private String aprAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String marAmt = null;
	/* Column Info */
	private String augAmt = null;
	/* Column Info */
	private String novAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String genExpnAproStepCd = null;
	/* Column Info */
	private String mayAmt = null;
	/* Column Info */
	private String genExpnTrnsDivCd = null;
	/* Column Info */
	private String title = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String janAmt = null;
	/* Column Info */
	private String decAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String genExpnItmNo = null;
	/* Column Info */
	private String genExpnAproAuthOfcCd = null;
	/* Column Info */
	private String julAmt = null;
	/* Column Info */
	private String genExpnCd = null;
	/* Column Info */
	private String ttl = null;
	/* Column Info */
	private String febAmt = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String junAmt = null;
	/* Column Info */
	private String sumAmt = null;
	/* Column Info */
	private String aproOpinRmk = null;
	/* Column Info */
	private String octAmt = null;
	/* Column Info */
	private String sepAmt = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String genExpnApstsCd = null;
	/* Column Info */
	private String ticCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GemApprovalStepVO() {}

	public GemApprovalStepVO(String ibflag, String pagerows, String title, String ttl, String ticCd, String genExpnRqstNo, String ofcCd, String genExpnCd, String genExpnItmNo, String genExpnTrnsDivCd, String genExpnRqstSeq, String genExpnAproStepCd, String genExpnApstsCd, String genExpnAproAuthOfcCd, String janAmt, String febAmt, String marAmt, String aprAmt, String mayAmt, String junAmt, String julAmt, String augAmt, String sepAmt, String octAmt, String novAmt, String decAmt, String sumAmt, String aproOpinRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.aprAmt = aprAmt;
		this.creDt = creDt;
		this.marAmt = marAmt;
		this.augAmt = augAmt;
		this.novAmt = novAmt;
		this.pagerows = pagerows;
		this.genExpnAproStepCd = genExpnAproStepCd;
		this.mayAmt = mayAmt;
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
		this.title = title;
		this.ibflag = ibflag;
		this.genExpnRqstNo = genExpnRqstNo;
		this.updUsrId = updUsrId;
		this.janAmt = janAmt;
		this.decAmt = decAmt;
		this.updDt = updDt;
		this.genExpnItmNo = genExpnItmNo;
		this.genExpnAproAuthOfcCd = genExpnAproAuthOfcCd;
		this.julAmt = julAmt;
		this.genExpnCd = genExpnCd;
		this.ttl = ttl;
		this.febAmt = febAmt;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.junAmt = junAmt;
		this.sumAmt = sumAmt;
		this.aproOpinRmk = aproOpinRmk;
		this.octAmt = octAmt;
		this.sepAmt = sepAmt;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.genExpnApstsCd = genExpnApstsCd;
		this.ticCd = ticCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apr_amt", getAprAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mar_amt", getMarAmt());
		this.hashColumns.put("aug_amt", getAugAmt());
		this.hashColumns.put("nov_amt", getNovAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("gen_expn_apro_step_cd", getGenExpnAproStepCd());
		this.hashColumns.put("may_amt", getMayAmt());
		this.hashColumns.put("gen_expn_trns_div_cd", getGenExpnTrnsDivCd());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("jan_amt", getJanAmt());
		this.hashColumns.put("dec_amt", getDecAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("gen_expn_itm_no", getGenExpnItmNo());
		this.hashColumns.put("gen_expn_apro_auth_ofc_cd", getGenExpnAproAuthOfcCd());
		this.hashColumns.put("jul_amt", getJulAmt());
		this.hashColumns.put("gen_expn_cd", getGenExpnCd());
		this.hashColumns.put("ttl", getTtl());
		this.hashColumns.put("feb_amt", getFebAmt());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("jun_amt", getJunAmt());
		this.hashColumns.put("sum_amt", getSumAmt());
		this.hashColumns.put("apro_opin_rmk", getAproOpinRmk());
		this.hashColumns.put("oct_amt", getOctAmt());
		this.hashColumns.put("sep_amt", getSepAmt());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("gen_expn_apsts_cd", getGenExpnApstsCd());
		this.hashColumns.put("tic_cd", getTicCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apr_amt", "aprAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mar_amt", "marAmt");
		this.hashFields.put("aug_amt", "augAmt");
		this.hashFields.put("nov_amt", "novAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("gen_expn_apro_step_cd", "genExpnAproStepCd");
		this.hashFields.put("may_amt", "mayAmt");
		this.hashFields.put("gen_expn_trns_div_cd", "genExpnTrnsDivCd");
		this.hashFields.put("title", "title");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("jan_amt", "janAmt");
		this.hashFields.put("dec_amt", "decAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("gen_expn_itm_no", "genExpnItmNo");
		this.hashFields.put("gen_expn_apro_auth_ofc_cd", "genExpnAproAuthOfcCd");
		this.hashFields.put("jul_amt", "julAmt");
		this.hashFields.put("gen_expn_cd", "genExpnCd");
		this.hashFields.put("ttl", "ttl");
		this.hashFields.put("feb_amt", "febAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("jun_amt", "junAmt");
		this.hashFields.put("sum_amt", "sumAmt");
		this.hashFields.put("apro_opin_rmk", "aproOpinRmk");
		this.hashFields.put("oct_amt", "octAmt");
		this.hashFields.put("sep_amt", "sepAmt");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("gen_expn_apsts_cd", "genExpnApstsCd");
		this.hashFields.put("tic_cd", "ticCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aprAmt
	 */
	public String getAprAmt() {
		return this.aprAmt;
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
	 * @return marAmt
	 */
	public String getMarAmt() {
		return this.marAmt;
	}
	
	/**
	 * Column Info
	 * @return augAmt
	 */
	public String getAugAmt() {
		return this.augAmt;
	}
	
	/**
	 * Column Info
	 * @return novAmt
	 */
	public String getNovAmt() {
		return this.novAmt;
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
	 * @return genExpnAproStepCd
	 */
	public String getGenExpnAproStepCd() {
		return this.genExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @return mayAmt
	 */
	public String getMayAmt() {
		return this.mayAmt;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
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
	 * @return genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return this.genExpnRqstNo;
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
	 * @return janAmt
	 */
	public String getJanAmt() {
		return this.janAmt;
	}
	
	/**
	 * Column Info
	 * @return decAmt
	 */
	public String getDecAmt() {
		return this.decAmt;
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
	 * @return genExpnItmNo
	 */
	public String getGenExpnItmNo() {
		return this.genExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @return genExpnAproAuthOfcCd
	 */
	public String getGenExpnAproAuthOfcCd() {
		return this.genExpnAproAuthOfcCd;
	}
	
	/**
	 * Column Info
	 * @return julAmt
	 */
	public String getJulAmt() {
		return this.julAmt;
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
	 * @return ttl
	 */
	public String getTtl() {
		return this.ttl;
	}
	
	/**
	 * Column Info
	 * @return febAmt
	 */
	public String getFebAmt() {
		return this.febAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return junAmt
	 */
	public String getJunAmt() {
		return this.junAmt;
	}
	
	/**
	 * Column Info
	 * @return sumAmt
	 */
	public String getSumAmt() {
		return this.sumAmt;
	}
	
	/**
	 * Column Info
	 * @return aproOpinRmk
	 */
	public String getAproOpinRmk() {
		return this.aproOpinRmk;
	}
	
	/**
	 * Column Info
	 * @return octAmt
	 */
	public String getOctAmt() {
		return this.octAmt;
	}
	
	/**
	 * Column Info
	 * @return sepAmt
	 */
	public String getSepAmt() {
		return this.sepAmt;
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
	 * @return genExpnApstsCd
	 */
	public String getGenExpnApstsCd() {
		return this.genExpnApstsCd;
	}
	
	/**
	 * Column Info
	 * @return ticCd
	 */
	public String getTicCd() {
		return this.ticCd;
	}
	

	/**
	 * Column Info
	 * @param aprAmt
	 */
	public void setAprAmt(String aprAmt) {
		this.aprAmt = aprAmt;
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
	 * @param marAmt
	 */
	public void setMarAmt(String marAmt) {
		this.marAmt = marAmt;
	}
	
	/**
	 * Column Info
	 * @param augAmt
	 */
	public void setAugAmt(String augAmt) {
		this.augAmt = augAmt;
	}
	
	/**
	 * Column Info
	 * @param novAmt
	 */
	public void setNovAmt(String novAmt) {
		this.novAmt = novAmt;
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
	 * @param genExpnAproStepCd
	 */
	public void setGenExpnAproStepCd(String genExpnAproStepCd) {
		this.genExpnAproStepCd = genExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @param mayAmt
	 */
	public void setMayAmt(String mayAmt) {
		this.mayAmt = mayAmt;
	}
	
	/**
	 * Column Info
	 * @param genExpnTrnsDivCd
	 */
	public void setGenExpnTrnsDivCd(String genExpnTrnsDivCd) {
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
	}
	
	/**
	 * Column Info
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param genExpnRqstNo
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
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
	 * @param janAmt
	 */
	public void setJanAmt(String janAmt) {
		this.janAmt = janAmt;
	}
	
	/**
	 * Column Info
	 * @param decAmt
	 */
	public void setDecAmt(String decAmt) {
		this.decAmt = decAmt;
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
	 * @param genExpnItmNo
	 */
	public void setGenExpnItmNo(String genExpnItmNo) {
		this.genExpnItmNo = genExpnItmNo;
	}
	
	/**
	 * Column Info
	 * @param genExpnAproAuthOfcCd
	 */
	public void setGenExpnAproAuthOfcCd(String genExpnAproAuthOfcCd) {
		this.genExpnAproAuthOfcCd = genExpnAproAuthOfcCd;
	}
	
	/**
	 * Column Info
	 * @param julAmt
	 */
	public void setJulAmt(String julAmt) {
		this.julAmt = julAmt;
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
	 * @param ttl
	 */
	public void setTtl(String ttl) {
		this.ttl = ttl;
	}
	
	/**
	 * Column Info
	 * @param febAmt
	 */
	public void setFebAmt(String febAmt) {
		this.febAmt = febAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param junAmt
	 */
	public void setJunAmt(String junAmt) {
		this.junAmt = junAmt;
	}
	
	/**
	 * Column Info
	 * @param sumAmt
	 */
	public void setSumAmt(String sumAmt) {
		this.sumAmt = sumAmt;
	}
	
	/**
	 * Column Info
	 * @param aproOpinRmk
	 */
	public void setAproOpinRmk(String aproOpinRmk) {
		this.aproOpinRmk = aproOpinRmk;
	}
	
	/**
	 * Column Info
	 * @param octAmt
	 */
	public void setOctAmt(String octAmt) {
		this.octAmt = octAmt;
	}
	
	/**
	 * Column Info
	 * @param sepAmt
	 */
	public void setSepAmt(String sepAmt) {
		this.sepAmt = sepAmt;
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
	 * @param genExpnApstsCd
	 */
	public void setGenExpnApstsCd(String genExpnApstsCd) {
		this.genExpnApstsCd = genExpnApstsCd;
	}
	
	/**
	 * Column Info
	 * @param ticCd
	 */
	public void setTicCd(String ticCd) {
		this.ticCd = ticCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAprAmt(JSPUtil.getParameter(request, "apr_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setMarAmt(JSPUtil.getParameter(request, "mar_amt", ""));
		setAugAmt(JSPUtil.getParameter(request, "aug_amt", ""));
		setNovAmt(JSPUtil.getParameter(request, "nov_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGenExpnAproStepCd(JSPUtil.getParameter(request, "gen_expn_apro_step_cd", ""));
		setMayAmt(JSPUtil.getParameter(request, "may_amt", ""));
		setGenExpnTrnsDivCd(JSPUtil.getParameter(request, "gen_expn_trns_div_cd", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setJanAmt(JSPUtil.getParameter(request, "jan_amt", ""));
		setDecAmt(JSPUtil.getParameter(request, "dec_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setGenExpnItmNo(JSPUtil.getParameter(request, "gen_expn_itm_no", ""));
		setGenExpnAproAuthOfcCd(JSPUtil.getParameter(request, "gen_expn_apro_auth_ofc_cd", ""));
		setJulAmt(JSPUtil.getParameter(request, "jul_amt", ""));
		setGenExpnCd(JSPUtil.getParameter(request, "gen_expn_cd", ""));
		setTtl(JSPUtil.getParameter(request, "ttl", ""));
		setFebAmt(JSPUtil.getParameter(request, "feb_amt", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setJunAmt(JSPUtil.getParameter(request, "jun_amt", ""));
		setSumAmt(JSPUtil.getParameter(request, "sum_amt", ""));
		setAproOpinRmk(JSPUtil.getParameter(request, "apro_opin_rmk", ""));
		setOctAmt(JSPUtil.getParameter(request, "oct_amt", ""));
		setSepAmt(JSPUtil.getParameter(request, "sep_amt", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, "gen_expn_rqst_seq", ""));
		setGenExpnApstsCd(JSPUtil.getParameter(request, "gen_expn_apsts_cd", ""));
		setTicCd(JSPUtil.getParameter(request, "tic_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemApprovalStepVO[]
	 */
	public GemApprovalStepVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemApprovalStepVO[]
	 */
	public GemApprovalStepVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemApprovalStepVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aprAmt = (JSPUtil.getParameter(request, prefix	+ "apr_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] marAmt = (JSPUtil.getParameter(request, prefix	+ "mar_amt", length));
			String[] augAmt = (JSPUtil.getParameter(request, prefix	+ "aug_amt", length));
			String[] novAmt = (JSPUtil.getParameter(request, prefix	+ "nov_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] genExpnAproStepCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_apro_step_cd", length));
			String[] mayAmt = (JSPUtil.getParameter(request, prefix	+ "may_amt", length));
			String[] genExpnTrnsDivCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_trns_div_cd", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] janAmt = (JSPUtil.getParameter(request, prefix	+ "jan_amt", length));
			String[] decAmt = (JSPUtil.getParameter(request, prefix	+ "dec_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] genExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_no", length));
			String[] genExpnAproAuthOfcCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_apro_auth_ofc_cd", length));
			String[] julAmt = (JSPUtil.getParameter(request, prefix	+ "jul_amt", length));
			String[] genExpnCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_cd", length));
			String[] ttl = (JSPUtil.getParameter(request, prefix	+ "ttl", length));
			String[] febAmt = (JSPUtil.getParameter(request, prefix	+ "feb_amt", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] junAmt = (JSPUtil.getParameter(request, prefix	+ "jun_amt", length));
			String[] sumAmt = (JSPUtil.getParameter(request, prefix	+ "sum_amt", length));
			String[] aproOpinRmk = (JSPUtil.getParameter(request, prefix	+ "apro_opin_rmk", length));
			String[] octAmt = (JSPUtil.getParameter(request, prefix	+ "oct_amt", length));
			String[] sepAmt = (JSPUtil.getParameter(request, prefix	+ "sep_amt", length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq", length));
			String[] genExpnApstsCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_apsts_cd", length));
			String[] ticCd = (JSPUtil.getParameter(request, prefix	+ "tic_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemApprovalStepVO();
				if (aprAmt[i] != null)
					model.setAprAmt(aprAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (marAmt[i] != null)
					model.setMarAmt(marAmt[i]);
				if (augAmt[i] != null)
					model.setAugAmt(augAmt[i]);
				if (novAmt[i] != null)
					model.setNovAmt(novAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (genExpnAproStepCd[i] != null)
					model.setGenExpnAproStepCd(genExpnAproStepCd[i]);
				if (mayAmt[i] != null)
					model.setMayAmt(mayAmt[i]);
				if (genExpnTrnsDivCd[i] != null)
					model.setGenExpnTrnsDivCd(genExpnTrnsDivCd[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (janAmt[i] != null)
					model.setJanAmt(janAmt[i]);
				if (decAmt[i] != null)
					model.setDecAmt(decAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (genExpnItmNo[i] != null)
					model.setGenExpnItmNo(genExpnItmNo[i]);
				if (genExpnAproAuthOfcCd[i] != null)
					model.setGenExpnAproAuthOfcCd(genExpnAproAuthOfcCd[i]);
				if (julAmt[i] != null)
					model.setJulAmt(julAmt[i]);
				if (genExpnCd[i] != null)
					model.setGenExpnCd(genExpnCd[i]);
				if (ttl[i] != null)
					model.setTtl(ttl[i]);
				if (febAmt[i] != null)
					model.setFebAmt(febAmt[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (junAmt[i] != null)
					model.setJunAmt(junAmt[i]);
				if (sumAmt[i] != null)
					model.setSumAmt(sumAmt[i]);
				if (aproOpinRmk[i] != null)
					model.setAproOpinRmk(aproOpinRmk[i]);
				if (octAmt[i] != null)
					model.setOctAmt(octAmt[i]);
				if (sepAmt[i] != null)
					model.setSepAmt(sepAmt[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (genExpnApstsCd[i] != null)
					model.setGenExpnApstsCd(genExpnApstsCd[i]);
				if (ticCd[i] != null)
					model.setTicCd(ticCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemApprovalStepVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemApprovalStepVO[]
	 */
	public GemApprovalStepVO[] getGemApprovalStepVOs(){
		GemApprovalStepVO[] vos = (GemApprovalStepVO[])models.toArray(new GemApprovalStepVO[models.size()]);
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
		this.aprAmt = this.aprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marAmt = this.marAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.augAmt = this.augAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.novAmt = this.novAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAproStepCd = this.genExpnAproStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mayAmt = this.mayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnTrnsDivCd = this.genExpnTrnsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.janAmt = this.janAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.decAmt = this.decAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmNo = this.genExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAproAuthOfcCd = this.genExpnAproAuthOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.julAmt = this.julAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnCd = this.genExpnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttl = this.ttl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.febAmt = this.febAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.junAmt = this.junAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sumAmt = this.sumAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOpinRmk = this.aproOpinRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.octAmt = this.octAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepAmt = this.sepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnApstsCd = this.genExpnApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ticCd = this.ticCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
