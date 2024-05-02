/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExpenseInfoVO.java
*@FileTitle : ExpenseInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.13
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2009.05.13 진윤오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemplanningperformance.gemplanningperformance.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 진윤오
 * @since J2EE 1.5
 * @see AbstractValueObject
 */

public class ExpenseInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ExpenseInfoVO> models = new ArrayList<ExpenseInfoVO>();
	
	/* Column Info */
	private String genExpnTrnsDivCd = null;
	/* Column Info */
	private String novAmt = null;
	/* Column Info */
	private String janAmt = null;
	/* Column Info */
	private String genExpnRqstNo = null;
	/* Column Info */
	private String aproOpinRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String genExpnAproAuthOfcCd = null;
	/* Column Info */
	private String sepAmt = null;
	/* Column Info */
	private String genExpnItmNo = null;
	/* Column Info */
	private String genExpnRqstSeq = null;
	/* Column Info */
	private String genExpnAproStepCd = null;
	/* Column Info */
	private String octAmt = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String mayAmt = null;
	/* Column Info */
	private String augAmt = null;
	/* Column Info */
	private String genExpnApstsCd = null;
	/* Column Info */
	private String febAmt = null;
	/* Column Info */
	private String marAmt = null;
	/* Column Info */
	private String decAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String julAmt = null;
	/* Column Info */
	private String junAmt = null;
	/* Column Info */
	private String aprAmt = null;
	/* Page Number */
	private String pagerows = null;

	/*	Table Column name으로 맴버변수 value 담는다*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	Table Column name으로 맴버변수 name 	담는다*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ExpenseInfoVO() {}

	public ExpenseInfoVO(String ibflag, String pagerows, String genExpnRqstNo, String genExpnItmNo, String genExpnTrnsDivCd, String genExpnRqstSeq, String genExpnAproStepCd, String genExpnApstsCd, String genExpnAproAuthOfcCd, String janAmt, String febAmt, String marAmt, String aprAmt, String mayAmt, String junAmt, String julAmt, String augAmt, String sepAmt, String octAmt, String novAmt, String decAmt, String aproOpinRmk, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
		this.novAmt = novAmt;
		this.janAmt = janAmt;
		this.genExpnRqstNo = genExpnRqstNo;
		this.aproOpinRmk = aproOpinRmk;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.genExpnAproAuthOfcCd = genExpnAproAuthOfcCd;
		this.sepAmt = sepAmt;
		this.genExpnItmNo = genExpnItmNo;
		this.genExpnRqstSeq = genExpnRqstSeq;
		this.genExpnAproStepCd = genExpnAproStepCd;
		this.octAmt = octAmt;
		this.ibflag = ibflag;
		this.mayAmt = mayAmt;
		this.augAmt = augAmt;
		this.genExpnApstsCd = genExpnApstsCd;
		this.febAmt = febAmt;
		this.marAmt = marAmt;
		this.decAmt = decAmt;
		this.creDt = creDt;
		this.creUsrId = creUsrId;
		this.julAmt = julAmt;
		this.junAmt = junAmt;
		this.aprAmt = aprAmt;
		this.pagerows = pagerows;
	}
	
	/**
	 * Table Column name 으로 맴버변수에 value를 리턴한다.
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gen_expn_trns_div_cd", getGenExpnTrnsDivCd());
		this.hashColumns.put("nov_amt", getNovAmt());
		this.hashColumns.put("jan_amt", getJanAmt());
		this.hashColumns.put("gen_expn_rqst_no", getGenExpnRqstNo());
		this.hashColumns.put("apro_opin_rmk", getAproOpinRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("gen_expn_apro_auth_ofc_cd", getGenExpnAproAuthOfcCd());
		this.hashColumns.put("sep_amt", getSepAmt());
		this.hashColumns.put("gen_expn_itm_no", getGenExpnItmNo());
		this.hashColumns.put("gen_expn_rqst_seq", getGenExpnRqstSeq());
		this.hashColumns.put("gen_expn_apro_step_cd", getGenExpnAproStepCd());
		this.hashColumns.put("oct_amt", getOctAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("may_amt", getMayAmt());
		this.hashColumns.put("aug_amt", getAugAmt());
		this.hashColumns.put("gen_expn_apsts_cd", getGenExpnApstsCd());
		this.hashColumns.put("feb_amt", getFebAmt());
		this.hashColumns.put("mar_amt", getMarAmt());
		this.hashColumns.put("dec_amt", getDecAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("jul_amt", getJulAmt());
		this.hashColumns.put("jun_amt", getJunAmt());
		this.hashColumns.put("apr_amt", getAprAmt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * Table Column name 으로 맴버변수를 호출한다
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("gen_expn_trns_div_cd", "genExpnTrnsDivCd");
		this.hashFields.put("nov_amt", "novAmt");
		this.hashFields.put("jan_amt", "janAmt");
		this.hashFields.put("gen_expn_rqst_no", "genExpnRqstNo");
		this.hashFields.put("apro_opin_rmk", "aproOpinRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("gen_expn_apro_auth_ofc_cd", "genExpnAproAuthOfcCd");
		this.hashFields.put("sep_amt", "sepAmt");
		this.hashFields.put("gen_expn_itm_no", "genExpnItmNo");
		this.hashFields.put("gen_expn_rqst_seq", "genExpnRqstSeq");
		this.hashFields.put("gen_expn_apro_step_cd", "genExpnAproStepCd");
		this.hashFields.put("oct_amt", "octAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("may_amt", "mayAmt");
		this.hashFields.put("aug_amt", "augAmt");
		this.hashFields.put("gen_expn_apsts_cd", "genExpnApstsCd");
		this.hashFields.put("feb_amt", "febAmt");
		this.hashFields.put("mar_amt", "marAmt");
		this.hashFields.put("dec_amt", "decAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("jul_amt", "julAmt");
		this.hashFields.put("jun_amt", "junAmt");
		this.hashFields.put("apr_amt", "aprAmt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return novAmt
	 */
	public String getNovAmt() {
		return this.novAmt;
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
	 * @return genExpnRqstNo
	 */
	public String getGenExpnRqstNo() {
		return this.genExpnRqstNo;
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
	 * @return genExpnAproAuthOfcCd
	 */
	public String getGenExpnAproAuthOfcCd() {
		return this.genExpnAproAuthOfcCd;
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
	 * @return genExpnItmNo
	 */
	public String getGenExpnItmNo() {
		return this.genExpnItmNo;
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
	 * @return genExpnAproStepCd
	 */
	public String getGenExpnAproStepCd() {
		return this.genExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @return octAmt
	 */
	public String getOctAmt() {
		return this.octAmt;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
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
	 * @return augAmt
	 */
	public String getAugAmt() {
		return this.augAmt;
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
	 * @return febAmt
	 */
	public String getFebAmt() {
		return this.febAmt;
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
	 * @return decAmt
	 */
	public String getDecAmt() {
		return this.decAmt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return junAmt
	 */
	public String getJunAmt() {
		return this.junAmt;
	}
	
	/**
	 * Column Info
	 * @return aprAmt
	 */
	public String getAprAmt() {
		return this.aprAmt;
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
	 * @param genExpnTrnsDivCd
	 */
	public void setGenExpnTrnsDivCd(String genExpnTrnsDivCd) {
		this.genExpnTrnsDivCd = genExpnTrnsDivCd;
	}
	
	/**
	 * Column Info
	 * @param novAmt
	 */
	public void setNovAmt(String novAmt) {
		this.novAmt = novAmt;
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
	 * @param genExpnRqstNo
	 */
	public void setGenExpnRqstNo(String genExpnRqstNo) {
		this.genExpnRqstNo = genExpnRqstNo;
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
	 * @param genExpnAproAuthOfcCd
	 */
	public void setGenExpnAproAuthOfcCd(String genExpnAproAuthOfcCd) {
		this.genExpnAproAuthOfcCd = genExpnAproAuthOfcCd;
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
	 * @param genExpnItmNo
	 */
	public void setGenExpnItmNo(String genExpnItmNo) {
		this.genExpnItmNo = genExpnItmNo;
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
	 * @param genExpnAproStepCd
	 */
	public void setGenExpnAproStepCd(String genExpnAproStepCd) {
		this.genExpnAproStepCd = genExpnAproStepCd;
	}
	
	/**
	 * Column Info
	 * @param octAmt
	 */
	public void setOctAmt(String octAmt) {
		this.octAmt = octAmt;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param augAmt
	 */
	public void setAugAmt(String augAmt) {
		this.augAmt = augAmt;
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
	 * @param febAmt
	 */
	public void setFebAmt(String febAmt) {
		this.febAmt = febAmt;
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
	 * @param decAmt
	 */
	public void setDecAmt(String decAmt) {
		this.decAmt = decAmt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param junAmt
	 */
	public void setJunAmt(String junAmt) {
		this.junAmt = junAmt;
	}
	
	/**
	 * Column Info
	 * @param aprAmt
	 */
	public void setAprAmt(String aprAmt) {
		this.aprAmt = aprAmt;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 넘어온 단건 DATA를 VO Class 에 담는다. 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setGenExpnTrnsDivCd(JSPUtil.getParameter(request, "gen_expn_trns_div_cd", ""));
		setNovAmt(JSPUtil.getParameter(request, "nov_amt", ""));
		setJanAmt(JSPUtil.getParameter(request, "jan_amt", ""));
		setGenExpnRqstNo(JSPUtil.getParameter(request, "gen_expn_rqst_no", ""));
		setAproOpinRmk(JSPUtil.getParameter(request, "apro_opin_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setGenExpnAproAuthOfcCd(JSPUtil.getParameter(request, "gen_expn_apro_auth_ofc_cd", ""));
		setSepAmt(JSPUtil.getParameter(request, "sep_amt", ""));
		setGenExpnItmNo(JSPUtil.getParameter(request, "gen_expn_itm_no", ""));
		setGenExpnRqstSeq(JSPUtil.getParameter(request, "gen_expn_rqst_seq", ""));
		setGenExpnAproStepCd(JSPUtil.getParameter(request, "gen_expn_apro_step_cd", ""));
		setOctAmt(JSPUtil.getParameter(request, "oct_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMayAmt(JSPUtil.getParameter(request, "may_amt", ""));
		setAugAmt(JSPUtil.getParameter(request, "aug_amt", ""));
		setGenExpnApstsCd(JSPUtil.getParameter(request, "gen_expn_apsts_cd", ""));
		setFebAmt(JSPUtil.getParameter(request, "feb_amt", ""));
		setMarAmt(JSPUtil.getParameter(request, "mar_amt", ""));
		setDecAmt(JSPUtil.getParameter(request, "dec_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setJulAmt(JSPUtil.getParameter(request, "jul_amt", ""));
		setJunAmt(JSPUtil.getParameter(request, "jun_amt", ""));
		setAprAmt(JSPUtil.getParameter(request, "apr_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request를 VO Class를 담는다.
	 * @param request
	 * @return ExpenseInfoVO[]
	 */
	public ExpenseInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ExpenseInfoVO[]
	 */
	public ExpenseInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ExpenseInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] genExpnTrnsDivCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_trns_div_cd".trim(), length));
			String[] novAmt = (JSPUtil.getParameter(request, prefix	+ "nov_amt".trim(), length));
			String[] janAmt = (JSPUtil.getParameter(request, prefix	+ "jan_amt".trim(), length));
			String[] genExpnRqstNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_no".trim(), length));
			String[] aproOpinRmk = (JSPUtil.getParameter(request, prefix	+ "apro_opin_rmk".trim(), length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id".trim(), length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt".trim(), length));
			String[] genExpnAproAuthOfcCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_apro_auth_ofc_cd".trim(), length));
			String[] sepAmt = (JSPUtil.getParameter(request, prefix	+ "sep_amt".trim(), length));
			String[] genExpnItmNo = (JSPUtil.getParameter(request, prefix	+ "gen_expn_itm_no".trim(), length));
			String[] genExpnRqstSeq = (JSPUtil.getParameter(request, prefix	+ "gen_expn_rqst_seq".trim(), length));
			String[] genExpnAproStepCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_apro_step_cd".trim(), length));
			String[] octAmt = (JSPUtil.getParameter(request, prefix	+ "oct_amt".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] mayAmt = (JSPUtil.getParameter(request, prefix	+ "may_amt".trim(), length));
			String[] augAmt = (JSPUtil.getParameter(request, prefix	+ "aug_amt".trim(), length));
			String[] genExpnApstsCd = (JSPUtil.getParameter(request, prefix	+ "gen_expn_apsts_cd".trim(), length));
			String[] febAmt = (JSPUtil.getParameter(request, prefix	+ "feb_amt".trim(), length));
			String[] marAmt = (JSPUtil.getParameter(request, prefix	+ "mar_amt".trim(), length));
			String[] decAmt = (JSPUtil.getParameter(request, prefix	+ "dec_amt".trim(), length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt".trim(), length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id".trim(), length));
			String[] julAmt = (JSPUtil.getParameter(request, prefix	+ "jul_amt".trim(), length));
			String[] junAmt = (JSPUtil.getParameter(request, prefix	+ "jun_amt".trim(), length));
			String[] aprAmt = (JSPUtil.getParameter(request, prefix	+ "apr_amt".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new ExpenseInfoVO();
				if (genExpnTrnsDivCd[i] != null)
					model.setGenExpnTrnsDivCd(genExpnTrnsDivCd[i]);
				if (novAmt[i] != null)
					model.setNovAmt(novAmt[i]);
				if (janAmt[i] != null)
					model.setJanAmt(janAmt[i]);
				if (genExpnRqstNo[i] != null)
					model.setGenExpnRqstNo(genExpnRqstNo[i]);
				if (aproOpinRmk[i] != null)
					model.setAproOpinRmk(aproOpinRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (genExpnAproAuthOfcCd[i] != null)
					model.setGenExpnAproAuthOfcCd(genExpnAproAuthOfcCd[i]);
				if (sepAmt[i] != null)
					model.setSepAmt(sepAmt[i]);
				if (genExpnItmNo[i] != null)
					model.setGenExpnItmNo(genExpnItmNo[i]);
				if (genExpnRqstSeq[i] != null)
					model.setGenExpnRqstSeq(genExpnRqstSeq[i]);
				if (genExpnAproStepCd[i] != null)
					model.setGenExpnAproStepCd(genExpnAproStepCd[i]);
				if (octAmt[i] != null)
					model.setOctAmt(octAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mayAmt[i] != null)
					model.setMayAmt(mayAmt[i]);
				if (augAmt[i] != null)
					model.setAugAmt(augAmt[i]);
				if (genExpnApstsCd[i] != null)
					model.setGenExpnApstsCd(genExpnApstsCd[i]);
				if (febAmt[i] != null)
					model.setFebAmt(febAmt[i]);
				if (marAmt[i] != null)
					model.setMarAmt(marAmt[i]);
				if (decAmt[i] != null)
					model.setDecAmt(decAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (julAmt[i] != null)
					model.setJulAmt(julAmt[i]);
				if (junAmt[i] != null)
					model.setJunAmt(junAmt[i]);
				if (aprAmt[i] != null)
					model.setAprAmt(aprAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getExpenseInfoVOs();
	}

	/**
	 * 여러 VO Calss를 배열화 한다 
	 * @return ExpenseInfoVO[]
	 */
	public ExpenseInfoVO[] getExpenseInfoVOs(){
		ExpenseInfoVO[] vos = (ExpenseInfoVO[])models.toArray(new ExpenseInfoVO[models.size()]);
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
	 * 각 클래스 해당하는 필드 정보를 배열에 담는다 
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = getFieldCatct(field, i, arr);
		}
		return arr;
	}
	
	/**
	 * getField 에서 catch문에 대한 로직
	 * @param field
	 * @param i
	 * @param arr
	 * @return arr
	 */
	private String[] getFieldCatct(Field[] field, int i, String[] arr) {
		try {
			arr = new String[1];
			arr[0] = String.valueOf(field[i].get(this));
		} catch (IllegalAccessException e) {
			return null;
		}
		return arr;
	}
	
	/**
	* DataFormat 설정
	*/
	public void unDataFormat(){
		this.genExpnTrnsDivCd = this.genExpnTrnsDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.novAmt = this.novAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.janAmt = this.janAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstNo = this.genExpnRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOpinRmk = this.aproOpinRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAproAuthOfcCd = this.genExpnAproAuthOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sepAmt = this.sepAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnItmNo = this.genExpnItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnRqstSeq = this.genExpnRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnAproStepCd = this.genExpnAproStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.octAmt = this.octAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mayAmt = this.mayAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.augAmt = this.augAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genExpnApstsCd = this.genExpnApstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.febAmt = this.febAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.marAmt = this.marAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.decAmt = this.decAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.julAmt = this.julAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.junAmt = this.junAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aprAmt = this.aprAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
