/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchMonthlyQuotaAdjustmentSlsRHQRMK0156List01VO.java
*@FileTitle : SearchMonthlyQuotaAdjustmentSlsRHQRMK0156List01VO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최민철
*@LastVersion : 1.0
* 2009.09.22 최민철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.saq.monthlysalesquotamanage.monthlyquotaadjustmentslsrhq.vo;

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
 * @author 최민철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO> models = new ArrayList<SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO>();
	
	/* Column Info */
	private String creSeq = null;
	/* Column Info */
	private String saqStsCd = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String bseYr = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String subjCtnt = null;
	/* Column Info */
	private String sprtGrpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bseMon = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bseQtrCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmtCtnt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String mqtaStepCd = null;
	/* Column Info */
	private String rmkCreGdt = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String bsaGrpCd = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String rnk = null;
	/* Column Info */
	private String mqtaVerNo = null;
	/* Column Info */
	private String rlaneGrp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO() {}

	public SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO(String ibflag, String pagerows, String mqtaStepCd, String bseYr, String bseQtrCd, String trdCd, String dirCd, String mqtaVerNo, String rlaneGrp, String rlaneCd, String sprtGrpCd, String bsaGrpCd, String slsRgnOfcCd, String polCd, String podCd, String bseMon, String creSeq, String subjCtnt, String creOfcCd, String cmtCtnt, String saqStsCd, String rmkCreGdt, String rnk) {
		this.creSeq = creSeq;
		this.saqStsCd = saqStsCd;
		this.trdCd = trdCd;
		this.bseYr = bseYr;
		this.rlaneCd = rlaneCd;
		this.subjCtnt = subjCtnt;
		this.sprtGrpCd = sprtGrpCd;
		this.pagerows = pagerows;
		this.bseMon = bseMon;
		this.podCd = podCd;
		this.bseQtrCd = bseQtrCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cmtCtnt = cmtCtnt;
		this.creOfcCd = creOfcCd;
		this.mqtaStepCd = mqtaStepCd;
		this.rmkCreGdt = rmkCreGdt;
		this.dirCd = dirCd;
		this.bsaGrpCd = bsaGrpCd;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.rnk = rnk;
		this.mqtaVerNo = mqtaVerNo;
		this.rlaneGrp = rlaneGrp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_seq", getCreSeq());
		this.hashColumns.put("saq_sts_cd", getSaqStsCd());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("bse_yr", getBseYr());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("subj_ctnt", getSubjCtnt());
		this.hashColumns.put("sprt_grp_cd", getSprtGrpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bse_mon", getBseMon());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bse_qtr_cd", getBseQtrCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmt_ctnt", getCmtCtnt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("mqta_step_cd", getMqtaStepCd());
		this.hashColumns.put("rmk_cre_gdt", getRmkCreGdt());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("bsa_grp_cd", getBsaGrpCd());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("rnk", getRnk());
		this.hashColumns.put("mqta_ver_no", getMqtaVerNo());
		this.hashColumns.put("rlane_grp", getRlaneGrp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_seq", "creSeq");
		this.hashFields.put("saq_sts_cd", "saqStsCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("bse_yr", "bseYr");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("subj_ctnt", "subjCtnt");
		this.hashFields.put("sprt_grp_cd", "sprtGrpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bse_mon", "bseMon");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bse_qtr_cd", "bseQtrCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmt_ctnt", "cmtCtnt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("mqta_step_cd", "mqtaStepCd");
		this.hashFields.put("rmk_cre_gdt", "rmkCreGdt");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("bsa_grp_cd", "bsaGrpCd");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("rnk", "rnk");
		this.hashFields.put("mqta_ver_no", "mqtaVerNo");
		this.hashFields.put("rlane_grp", "rlaneGrp");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return creSeq
	 */
	public String getCreSeq() {
		return this.creSeq;
	}
	
	/**
	 * Column Info
	 * @return saqStsCd
	 */
	public String getSaqStsCd() {
		return this.saqStsCd;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}
	
	/**
	 * Column Info
	 * @return bseYr
	 */
	public String getBseYr() {
		return this.bseYr;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return subjCtnt
	 */
	public String getSubjCtnt() {
		return this.subjCtnt;
	}
	
	/**
	 * Column Info
	 * @return sprtGrpCd
	 */
	public String getSprtGrpCd() {
		return this.sprtGrpCd;
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
	 * @return bseMon
	 */
	public String getBseMon() {
		return this.bseMon;
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
	 * @return bseQtrCd
	 */
	public String getBseQtrCd() {
		return this.bseQtrCd;
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
	 * @return cmtCtnt
	 */
	public String getCmtCtnt() {
		return this.cmtCtnt;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mqtaStepCd
	 */
	public String getMqtaStepCd() {
		return this.mqtaStepCd;
	}
	
	/**
	 * Column Info
	 * @return rmkCreGdt
	 */
	public String getRmkCreGdt() {
		return this.rmkCreGdt;
	}
	
	/**
	 * Column Info
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return bsaGrpCd
	 */
	public String getBsaGrpCd() {
		return this.bsaGrpCd;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return rnk
	 */
	public String getRnk() {
		return this.rnk;
	}
	
	/**
	 * Column Info
	 * @return mqtaVerNo
	 */
	public String getMqtaVerNo() {
		return this.mqtaVerNo;
	}
	
	/**
	 * Column Info
	 * @return rlaneGrp
	 */
	public String getRlaneGrp() {
		return this.rlaneGrp;
	}
	

	/**
	 * Column Info
	 * @param creSeq
	 */
	public void setCreSeq(String creSeq) {
		this.creSeq = creSeq;
	}
	
	/**
	 * Column Info
	 * @param saqStsCd
	 */
	public void setSaqStsCd(String saqStsCd) {
		this.saqStsCd = saqStsCd;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Column Info
	 * @param bseYr
	 */
	public void setBseYr(String bseYr) {
		this.bseYr = bseYr;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param subjCtnt
	 */
	public void setSubjCtnt(String subjCtnt) {
		this.subjCtnt = subjCtnt;
	}
	
	/**
	 * Column Info
	 * @param sprtGrpCd
	 */
	public void setSprtGrpCd(String sprtGrpCd) {
		this.sprtGrpCd = sprtGrpCd;
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
	 * @param bseMon
	 */
	public void setBseMon(String bseMon) {
		this.bseMon = bseMon;
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
	 * @param bseQtrCd
	 */
	public void setBseQtrCd(String bseQtrCd) {
		this.bseQtrCd = bseQtrCd;
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
	 * @param cmtCtnt
	 */
	public void setCmtCtnt(String cmtCtnt) {
		this.cmtCtnt = cmtCtnt;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mqtaStepCd
	 */
	public void setMqtaStepCd(String mqtaStepCd) {
		this.mqtaStepCd = mqtaStepCd;
	}
	
	/**
	 * Column Info
	 * @param rmkCreGdt
	 */
	public void setRmkCreGdt(String rmkCreGdt) {
		this.rmkCreGdt = rmkCreGdt;
	}
	
	/**
	 * Column Info
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param bsaGrpCd
	 */
	public void setBsaGrpCd(String bsaGrpCd) {
		this.bsaGrpCd = bsaGrpCd;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param rnk
	 */
	public void setRnk(String rnk) {
		this.rnk = rnk;
	}
	
	/**
	 * Column Info
	 * @param mqtaVerNo
	 */
	public void setMqtaVerNo(String mqtaVerNo) {
		this.mqtaVerNo = mqtaVerNo;
	}
	
	/**
	 * Column Info
	 * @param rlaneGrp
	 */
	public void setRlaneGrp(String rlaneGrp) {
		this.rlaneGrp = rlaneGrp;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCreSeq(JSPUtil.getParameter(request, "cre_seq", ""));
		setSaqStsCd(JSPUtil.getParameter(request, "saq_sts_cd", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
		setBseYr(JSPUtil.getParameter(request, "bse_yr", ""));
		setRlaneCd(JSPUtil.getParameter(request, "rlane_cd", ""));
		setSubjCtnt(JSPUtil.getParameter(request, "subj_ctnt", ""));
		setSprtGrpCd(JSPUtil.getParameter(request, "sprt_grp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBseMon(JSPUtil.getParameter(request, "bse_mon", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBseQtrCd(JSPUtil.getParameter(request, "bse_qtr_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCmtCtnt(JSPUtil.getParameter(request, "cmt_ctnt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setMqtaStepCd(JSPUtil.getParameter(request, "mqta_step_cd", ""));
		setRmkCreGdt(JSPUtil.getParameter(request, "rmk_cre_gdt", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setBsaGrpCd(JSPUtil.getParameter(request, "bsa_grp_cd", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, "sls_rgn_ofc_cd", ""));
		setRnk(JSPUtil.getParameter(request, "rnk", ""));
		setMqtaVerNo(JSPUtil.getParameter(request, "mqta_ver_no", ""));
		setRlaneGrp(JSPUtil.getParameter(request, "rlane_grp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMonthlyQuotaAdjustmentSlsRHQRMK0156List01VO[]
	 */
	public SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMonthlyQuotaAdjustmentSlsRHQRMK0156List01VO[]
	 */
	public SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creSeq = (JSPUtil.getParameter(request, prefix	+ "cre_seq", length));
			String[] saqStsCd = (JSPUtil.getParameter(request, prefix	+ "saq_sts_cd", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] bseYr = (JSPUtil.getParameter(request, prefix	+ "bse_yr", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] subjCtnt = (JSPUtil.getParameter(request, prefix	+ "subj_ctnt", length));
			String[] sprtGrpCd = (JSPUtil.getParameter(request, prefix	+ "sprt_grp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bseMon = (JSPUtil.getParameter(request, prefix	+ "bse_mon", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bseQtrCd = (JSPUtil.getParameter(request, prefix	+ "bse_qtr_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmtCtnt = (JSPUtil.getParameter(request, prefix	+ "cmt_ctnt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] mqtaStepCd = (JSPUtil.getParameter(request, prefix	+ "mqta_step_cd", length));
			String[] rmkCreGdt = (JSPUtil.getParameter(request, prefix	+ "rmk_cre_gdt", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] bsaGrpCd = (JSPUtil.getParameter(request, prefix	+ "bsa_grp_cd", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] rnk = (JSPUtil.getParameter(request, prefix	+ "rnk", length));
			String[] mqtaVerNo = (JSPUtil.getParameter(request, prefix	+ "mqta_ver_no", length));
			String[] rlaneGrp = (JSPUtil.getParameter(request, prefix	+ "rlane_grp", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO();
				if (creSeq[i] != null)
					model.setCreSeq(creSeq[i]);
				if (saqStsCd[i] != null)
					model.setSaqStsCd(saqStsCd[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (bseYr[i] != null)
					model.setBseYr(bseYr[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (subjCtnt[i] != null)
					model.setSubjCtnt(subjCtnt[i]);
				if (sprtGrpCd[i] != null)
					model.setSprtGrpCd(sprtGrpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bseMon[i] != null)
					model.setBseMon(bseMon[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bseQtrCd[i] != null)
					model.setBseQtrCd(bseQtrCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmtCtnt[i] != null)
					model.setCmtCtnt(cmtCtnt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (mqtaStepCd[i] != null)
					model.setMqtaStepCd(mqtaStepCd[i]);
				if (rmkCreGdt[i] != null)
					model.setRmkCreGdt(rmkCreGdt[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (bsaGrpCd[i] != null)
					model.setBsaGrpCd(bsaGrpCd[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (rnk[i] != null)
					model.setRnk(rnk[i]);
				if (mqtaVerNo[i] != null)
					model.setMqtaVerNo(mqtaVerNo[i]);
				if (rlaneGrp[i] != null)
					model.setRlaneGrp(rlaneGrp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMonthlyQuotaAdjustmentSlsRHQRMK0156List01VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMonthlyQuotaAdjustmentSlsRHQRMK0156List01VO[]
	 */
	public SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO[] getSearchMonthlyQuotaAdjustmentSlsRHQRMK0156List01VOs(){
		SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO[] vos = (SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO[])models.toArray(new SearchMonthlyQuotaAdjustmentSlsRhqRMKListVO[models.size()]);
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
		this.creSeq = this.creSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saqStsCd = this.saqStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseYr = this.bseYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subjCtnt = this.subjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprtGrpCd = this.sprtGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseMon = this.bseMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseQtrCd = this.bseQtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmtCtnt = this.cmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaStepCd = this.mqtaStepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmkCreGdt = this.rmkCreGdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaGrpCd = this.bsaGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rnk = this.rnk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mqtaVerNo = this.mqtaVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneGrp = this.rlaneGrp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
