/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RevenueDetailVO.java
*@FileTitle : RevenueDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.30
*@LastModifier : 
*@LastVersion : 1.0
* 2016.06.30  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.multidimensionrpt.precmsimulation.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RevenueDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RevenueDetailVO> models = new ArrayList<RevenueDetailVO>();
	
	/* Column Info */
	private String scgRmk = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String adjScgUsdAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String prcDeTermCd = null;
	/* Column Info */
	private String payTermCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String arrDt = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String porDefCd = null;
	/* Column Info */
	private String vslSlanCd = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polDefCd = null;
	/* Column Info */
	private String prcRcvTermCd = null;
	/* Column Info */
	private String delDefCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podDefCd = null;
	/* Column Info */
	private String scgAmt = null;
	/* Column Info */
	private String trfScgAmt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RevenueDetailVO() {}

	public RevenueDetailVO(String ibflag, String pagerows, String svcScpCd, String chgCd, String porDefCd, String polDefCd, String podDefCd, String delDefCd, String subTrdCd, String vslSlanCd, String prcRcvTermCd, String prcDeTermCd, String ratUtCd, String prcCgoTpCd, String currCd, String scgAmt, String adjScgUsdAmt, String trfScgAmt, String payTermCd, String effDt, String expDt, String updDt, String scgRmk, String updUsrNm, String arrDt) {
		this.scgRmk = scgRmk;
		this.updDt = updDt;
		this.adjScgUsdAmt = adjScgUsdAmt;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.prcDeTermCd = prcDeTermCd;
		this.payTermCd = payTermCd;
		this.svcScpCd = svcScpCd;
		this.arrDt = arrDt;
		this.ratUtCd = ratUtCd;
		this.porDefCd = porDefCd;
		this.vslSlanCd = vslSlanCd;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.polDefCd = polDefCd;
		this.prcRcvTermCd = prcRcvTermCd;
		this.delDefCd = delDefCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.podDefCd = podDefCd;
		this.scgAmt = scgAmt;
		this.trfScgAmt = trfScgAmt;
		this.expDt = expDt;
		this.updUsrNm = updUsrNm;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scg_rmk", getScgRmk());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("adj_scg_usd_amt", getAdjScgUsdAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("prc_de_term_cd", getPrcDeTermCd());
		this.hashColumns.put("pay_term_cd", getPayTermCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("arr_dt", getArrDt());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("por_def_cd", getPorDefCd());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_def_cd", getPolDefCd());
		this.hashColumns.put("prc_rcv_term_cd", getPrcRcvTermCd());
		this.hashColumns.put("del_def_cd", getDelDefCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_def_cd", getPodDefCd());
		this.hashColumns.put("scg_amt", getScgAmt());
		this.hashColumns.put("trf_scg_amt", getTrfScgAmt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scg_rmk", "scgRmk");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("adj_scg_usd_amt", "adjScgUsdAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("prc_de_term_cd", "prcDeTermCd");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("arr_dt", "arrDt");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("por_def_cd", "porDefCd");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_def_cd", "polDefCd");
		this.hashFields.put("prc_rcv_term_cd", "prcRcvTermCd");
		this.hashFields.put("del_def_cd", "delDefCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_def_cd", "podDefCd");
		this.hashFields.put("scg_amt", "scgAmt");
		this.hashFields.put("trf_scg_amt", "trfScgAmt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scgRmk
	 */
	public String getScgRmk() {
		return this.scgRmk;
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
	 * @return adjScgUsdAmt
	 */
	public String getAdjScgUsdAmt() {
		return this.adjScgUsdAmt;
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
	 * @return prcDeTermCd
	 */
	public String getPrcDeTermCd() {
		return this.prcDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return payTermCd
	 */
	public String getPayTermCd() {
		return this.payTermCd;
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
	 * @return arrDt
	 */
	public String getArrDt() {
		return this.arrDt;
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
	 * @return porDefCd
	 */
	public String getPorDefCd() {
		return this.porDefCd;
	}
	
	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public String getVslSlanCd() {
		return this.vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return polDefCd
	 */
	public String getPolDefCd() {
		return this.polDefCd;
	}
	
	/**
	 * Column Info
	 * @return prcRcvTermCd
	 */
	public String getPrcRcvTermCd() {
		return this.prcRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return delDefCd
	 */
	public String getDelDefCd() {
		return this.delDefCd;
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
	 * @return podDefCd
	 */
	public String getPodDefCd() {
		return this.podDefCd;
	}
	
	/**
	 * Column Info
	 * @return scgAmt
	 */
	public String getScgAmt() {
		return this.scgAmt;
	}
	
	/**
	 * Column Info
	 * @return trfScgAmt
	 */
	public String getTrfScgAmt() {
		return this.trfScgAmt;
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
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	

	/**
	 * Column Info
	 * @param scgRmk
	 */
	public void setScgRmk(String scgRmk) {
		this.scgRmk = scgRmk;
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
	 * @param adjScgUsdAmt
	 */
	public void setAdjScgUsdAmt(String adjScgUsdAmt) {
		this.adjScgUsdAmt = adjScgUsdAmt;
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
	 * @param prcDeTermCd
	 */
	public void setPrcDeTermCd(String prcDeTermCd) {
		this.prcDeTermCd = prcDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param payTermCd
	 */
	public void setPayTermCd(String payTermCd) {
		this.payTermCd = payTermCd;
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
	 * @param arrDt
	 */
	public void setArrDt(String arrDt) {
		this.arrDt = arrDt;
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
	 * @param porDefCd
	 */
	public void setPorDefCd(String porDefCd) {
		this.porDefCd = porDefCd;
	}
	
	/**
	 * Column Info
	 * @param vslSlanCd
	 */
	public void setVslSlanCd(String vslSlanCd) {
		this.vslSlanCd = vslSlanCd;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param polDefCd
	 */
	public void setPolDefCd(String polDefCd) {
		this.polDefCd = polDefCd;
	}
	
	/**
	 * Column Info
	 * @param prcRcvTermCd
	 */
	public void setPrcRcvTermCd(String prcRcvTermCd) {
		this.prcRcvTermCd = prcRcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param delDefCd
	 */
	public void setDelDefCd(String delDefCd) {
		this.delDefCd = delDefCd;
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
	 * @param podDefCd
	 */
	public void setPodDefCd(String podDefCd) {
		this.podDefCd = podDefCd;
	}
	
	/**
	 * Column Info
	 * @param scgAmt
	 */
	public void setScgAmt(String scgAmt) {
		this.scgAmt = scgAmt;
	}
	
	/**
	 * Column Info
	 * @param trfScgAmt
	 */
	public void setTrfScgAmt(String trfScgAmt) {
		this.trfScgAmt = trfScgAmt;
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
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
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
		setScgRmk(JSPUtil.getParameter(request, prefix + "scg_rmk", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setAdjScgUsdAmt(JSPUtil.getParameter(request, prefix + "adj_scg_usd_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setPrcDeTermCd(JSPUtil.getParameter(request, prefix + "prc_de_term_cd", ""));
		setPayTermCd(JSPUtil.getParameter(request, prefix + "pay_term_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setArrDt(JSPUtil.getParameter(request, prefix + "arr_dt", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setPorDefCd(JSPUtil.getParameter(request, prefix + "por_def_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request, prefix + "vsl_slan_cd", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolDefCd(JSPUtil.getParameter(request, prefix + "pol_def_cd", ""));
		setPrcRcvTermCd(JSPUtil.getParameter(request, prefix + "prc_rcv_term_cd", ""));
		setDelDefCd(JSPUtil.getParameter(request, prefix + "del_def_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodDefCd(JSPUtil.getParameter(request, prefix + "pod_def_cd", ""));
		setScgAmt(JSPUtil.getParameter(request, prefix + "scg_amt", ""));
		setTrfScgAmt(JSPUtil.getParameter(request, prefix + "trf_scg_amt", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RevenueDetailVO[]
	 */
	public RevenueDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RevenueDetailVO[]
	 */
	public RevenueDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RevenueDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scgRmk = (JSPUtil.getParameter(request, prefix	+ "scg_rmk", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] adjScgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "adj_scg_usd_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] prcDeTermCd = (JSPUtil.getParameter(request, prefix	+ "prc_de_term_cd", length));
			String[] payTermCd = (JSPUtil.getParameter(request, prefix	+ "pay_term_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] arrDt = (JSPUtil.getParameter(request, prefix	+ "arr_dt", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] porDefCd = (JSPUtil.getParameter(request, prefix	+ "por_def_cd", length));
			String[] vslSlanCd = (JSPUtil.getParameter(request, prefix	+ "vsl_slan_cd", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polDefCd = (JSPUtil.getParameter(request, prefix	+ "pol_def_cd", length));
			String[] prcRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "prc_rcv_term_cd", length));
			String[] delDefCd = (JSPUtil.getParameter(request, prefix	+ "del_def_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podDefCd = (JSPUtil.getParameter(request, prefix	+ "pod_def_cd", length));
			String[] scgAmt = (JSPUtil.getParameter(request, prefix	+ "scg_amt", length));
			String[] trfScgAmt = (JSPUtil.getParameter(request, prefix	+ "trf_scg_amt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RevenueDetailVO();
				if (scgRmk[i] != null)
					model.setScgRmk(scgRmk[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (adjScgUsdAmt[i] != null)
					model.setAdjScgUsdAmt(adjScgUsdAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (prcDeTermCd[i] != null)
					model.setPrcDeTermCd(prcDeTermCd[i]);
				if (payTermCd[i] != null)
					model.setPayTermCd(payTermCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (arrDt[i] != null)
					model.setArrDt(arrDt[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (porDefCd[i] != null)
					model.setPorDefCd(porDefCd[i]);
				if (vslSlanCd[i] != null)
					model.setVslSlanCd(vslSlanCd[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polDefCd[i] != null)
					model.setPolDefCd(polDefCd[i]);
				if (prcRcvTermCd[i] != null)
					model.setPrcRcvTermCd(prcRcvTermCd[i]);
				if (delDefCd[i] != null)
					model.setDelDefCd(delDefCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podDefCd[i] != null)
					model.setPodDefCd(podDefCd[i]);
				if (scgAmt[i] != null)
					model.setScgAmt(scgAmt[i]);
				if (trfScgAmt[i] != null)
					model.setTrfScgAmt(trfScgAmt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRevenueDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RevenueDetailVO[]
	 */
	public RevenueDetailVO[] getRevenueDetailVOs(){
		RevenueDetailVO[] vos = (RevenueDetailVO[])models.toArray(new RevenueDetailVO[models.size()]);
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
		this.scgRmk = this.scgRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjScgUsdAmt = this.adjScgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcDeTermCd = this.prcDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermCd = this.payTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrDt = this.arrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDefCd = this.porDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd = this.vslSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDefCd = this.polDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRcvTermCd = this.prcRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDefCd = this.delDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDefCd = this.podDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgAmt = this.scgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfScgAmt = this.trfScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
