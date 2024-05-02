/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EesEqr1013MtRepoPlanVO.java
*@FileTitle : EesEqr1013MtRepoPlanVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.06  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntrplanguide.cntrplanmtrepoplan.vo;

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
 * 관련 Event 에서 생성, 서버실행시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EesEqr1013MtRepoPlanVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EesEqr1013MtRepoPlanVO> models = new ArrayList<EesEqr1013MtRepoPlanVO>();
	
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String mtyLodgPlnTeu = null;
	/* Column Info */
	private String mtyLodgPlnTon = null;
	/* Column Info */
	private String repoGlineRmk = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String mtyPlnTeu = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mtyBkgQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String mtyPlnShwFlg = null;
	/* Column Info */
	private String fnlCbfFlg2 = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String podYdCd2 = null;
	/* Column Info */
	private String fnlCbfDt = null;
	/* Column Info */
	private String plnRsnHdrCd = null;
	/* Column Info */
	private String fnlCbfFlg = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String plnRsnRmk = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String plnRsnSubCd = null;
	/* Column Info */
	private String mtyLodgTpszVals = null;
	/* Column Info */
	private String mtyBkgTeu = null;
	/* Column Info */
	private String avlTon = null;
	/* Column Info */
	private String mtyPlnTon = null;
	/* Column Info */
	private String avlTeu = null;
	/* Column Info */
	private String subTrdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EesEqr1013MtRepoPlanVO() {}

	public EesEqr1013MtRepoPlanVO(String ibflag, String pagerows, String trdCd, String subTrdCd, String slanCd, String vvdCd, String polYdCd, String etaDt, String etdDt, String fnlCbfDt, String fnlCbfFlg, String fnlCbfFlg2, String avlTeu, String avlTon, String mtyPlnTeu, String mtyPlnTon, String mtyLodgPlnTeu, String mtyLodgPlnTon, String mtyLodgTpszVals, String mtyPlnShwFlg, String podYdCd, String podYdCd2, String repoGlineRmk, String mtyBkgTeu, String mtyBkgQty, String plnRsnHdrCd, String plnRsnSubCd, String plnRsnRmk) {
		this.etaDt = etaDt;
		this.mtyLodgPlnTeu = mtyLodgPlnTeu;
		this.mtyLodgPlnTon = mtyLodgPlnTon;
		this.repoGlineRmk = repoGlineRmk;
		this.trdCd = trdCd;
		this.mtyPlnTeu = mtyPlnTeu;
		this.pagerows = pagerows;
		this.mtyBkgQty = mtyBkgQty;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.mtyPlnShwFlg = mtyPlnShwFlg;
		this.fnlCbfFlg2 = fnlCbfFlg2;
		this.podYdCd = podYdCd;
		this.podYdCd2 = podYdCd2;
		this.fnlCbfDt = fnlCbfDt;
		this.plnRsnHdrCd = plnRsnHdrCd;
		this.fnlCbfFlg = fnlCbfFlg;
		this.etdDt = etdDt;
		this.plnRsnRmk = plnRsnRmk;
		this.slanCd = slanCd;
		this.polYdCd = polYdCd;
		this.plnRsnSubCd = plnRsnSubCd;
		this.mtyLodgTpszVals = mtyLodgTpszVals;
		this.mtyBkgTeu = mtyBkgTeu;
		this.avlTon = avlTon;
		this.mtyPlnTon = mtyPlnTon;
		this.avlTeu = avlTeu;
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("mty_lodg_pln_teu", getMtyLodgPlnTeu());
		this.hashColumns.put("mty_lodg_pln_ton", getMtyLodgPlnTon());
		this.hashColumns.put("repo_gline_rmk", getRepoGlineRmk());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("mty_pln_teu", getMtyPlnTeu());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mty_bkg_qty", getMtyBkgQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("mty_pln_shw_flg", getMtyPlnShwFlg());
		this.hashColumns.put("fnl_cbf_flg2", getFnlCbfFlg2());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("pod_yd_cd2", getPodYdCd2());
		this.hashColumns.put("fnl_cbf_dt", getFnlCbfDt());
		this.hashColumns.put("pln_rsn_hdr_cd", getPlnRsnHdrCd());
		this.hashColumns.put("fnl_cbf_flg", getFnlCbfFlg());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("pln_rsn_rmk", getPlnRsnRmk());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("pln_rsn_sub_cd", getPlnRsnSubCd());
		this.hashColumns.put("mty_lodg_tpsz_vals", getMtyLodgTpszVals());
		this.hashColumns.put("mty_bkg_teu", getMtyBkgTeu());
		this.hashColumns.put("avl_ton", getAvlTon());
		this.hashColumns.put("mty_pln_ton", getMtyPlnTon());
		this.hashColumns.put("avl_teu", getAvlTeu());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("mty_lodg_pln_teu", "mtyLodgPlnTeu");
		this.hashFields.put("mty_lodg_pln_ton", "mtyLodgPlnTon");
		this.hashFields.put("repo_gline_rmk", "repoGlineRmk");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("mty_pln_teu", "mtyPlnTeu");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mty_bkg_qty", "mtyBkgQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("mty_pln_shw_flg", "mtyPlnShwFlg");
		this.hashFields.put("fnl_cbf_flg2", "fnlCbfFlg2");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("pod_yd_cd2", "podYdCd2");
		this.hashFields.put("fnl_cbf_dt", "fnlCbfDt");
		this.hashFields.put("pln_rsn_hdr_cd", "plnRsnHdrCd");
		this.hashFields.put("fnl_cbf_flg", "fnlCbfFlg");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("pln_rsn_rmk", "plnRsnRmk");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pln_rsn_sub_cd", "plnRsnSubCd");
		this.hashFields.put("mty_lodg_tpsz_vals", "mtyLodgTpszVals");
		this.hashFields.put("mty_bkg_teu", "mtyBkgTeu");
		this.hashFields.put("avl_ton", "avlTon");
		this.hashFields.put("mty_pln_ton", "mtyPlnTon");
		this.hashFields.put("avl_teu", "avlTeu");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		return this.hashFields;
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
	 * @return mtyLodgPlnTeu
	 */
	public String getMtyLodgPlnTeu() {
		return this.mtyLodgPlnTeu;
	}
	
	/**
	 * Column Info
	 * @return mtyLodgPlnTon
	 */
	public String getMtyLodgPlnTon() {
		return this.mtyLodgPlnTon;
	}
	
	/**
	 * Column Info
	 * @return repoGlineRmk
	 */
	public String getRepoGlineRmk() {
		return this.repoGlineRmk;
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
	 * @return mtyPlnTeu
	 */
	public String getMtyPlnTeu() {
		return this.mtyPlnTeu;
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
	 * @return mtyBkgQty
	 */
	public String getMtyBkgQty() {
		return this.mtyBkgQty;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPlnShwFlg
	 */
	public String getMtyPlnShwFlg() {
		return this.mtyPlnShwFlg;
	}
	
	/**
	 * Column Info
	 * @return fnlCbfFlg2
	 */
	public String getFnlCbfFlg2() {
		return this.fnlCbfFlg2;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return podYdCd2
	 */
	public String getPodYdCd2() {
		return this.podYdCd2;
	}
	
	/**
	 * Column Info
	 * @return fnlCbfDt
	 */
	public String getFnlCbfDt() {
		return this.fnlCbfDt;
	}
	
	/**
	 * Column Info
	 * @return plnRsnHdrCd
	 */
	public String getPlnRsnHdrCd() {
		return this.plnRsnHdrCd;
	}
	
	/**
	 * Column Info
	 * @return fnlCbfFlg
	 */
	public String getFnlCbfFlg() {
		return this.fnlCbfFlg;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return plnRsnRmk
	 */
	public String getPlnRsnRmk() {
		return this.plnRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return plnRsnSubCd
	 */
	public String getPlnRsnSubCd() {
		return this.plnRsnSubCd;
	}
	
	/**
	 * Column Info
	 * @return mtyLodgTpszVals
	 */
	public String getMtyLodgTpszVals() {
		return this.mtyLodgTpszVals;
	}
	
	/**
	 * Column Info
	 * @return mtyBkgTeu
	 */
	public String getMtyBkgTeu() {
		return this.mtyBkgTeu;
	}
	
	/**
	 * Column Info
	 * @return avlTon
	 */
	public String getAvlTon() {
		return this.avlTon;
	}
	
	/**
	 * Column Info
	 * @return mtyPlnTon
	 */
	public String getMtyPlnTon() {
		return this.mtyPlnTon;
	}
	
	/**
	 * Column Info
	 * @return avlTeu
	 */
	public String getAvlTeu() {
		return this.avlTeu;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param mtyLodgPlnTeu
	 */
	public void setMtyLodgPlnTeu(String mtyLodgPlnTeu) {
		this.mtyLodgPlnTeu = mtyLodgPlnTeu;
	}
	
	/**
	 * Column Info
	 * @param mtyLodgPlnTon
	 */
	public void setMtyLodgPlnTon(String mtyLodgPlnTon) {
		this.mtyLodgPlnTon = mtyLodgPlnTon;
	}
	
	/**
	 * Column Info
	 * @param repoGlineRmk
	 */
	public void setRepoGlineRmk(String repoGlineRmk) {
		this.repoGlineRmk = repoGlineRmk;
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
	 * @param mtyPlnTeu
	 */
	public void setMtyPlnTeu(String mtyPlnTeu) {
		this.mtyPlnTeu = mtyPlnTeu;
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
	 * @param mtyBkgQty
	 */
	public void setMtyBkgQty(String mtyBkgQty) {
		this.mtyBkgQty = mtyBkgQty;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPlnShwFlg
	 */
	public void setMtyPlnShwFlg(String mtyPlnShwFlg) {
		this.mtyPlnShwFlg = mtyPlnShwFlg;
	}
	
	/**
	 * Column Info
	 * @param fnlCbfFlg2
	 */
	public void setFnlCbfFlg2(String fnlCbfFlg2) {
		this.fnlCbfFlg2 = fnlCbfFlg2;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param podYdCd2
	 */
	public void setPodYdCd2(String podYdCd2) {
		this.podYdCd2 = podYdCd2;
	}
	
	/**
	 * Column Info
	 * @param fnlCbfDt
	 */
	public void setFnlCbfDt(String fnlCbfDt) {
		this.fnlCbfDt = fnlCbfDt;
	}
	
	/**
	 * Column Info
	 * @param plnRsnHdrCd
	 */
	public void setPlnRsnHdrCd(String plnRsnHdrCd) {
		this.plnRsnHdrCd = plnRsnHdrCd;
	}
	
	/**
	 * Column Info
	 * @param fnlCbfFlg
	 */
	public void setFnlCbfFlg(String fnlCbfFlg) {
		this.fnlCbfFlg = fnlCbfFlg;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param plnRsnRmk
	 */
	public void setPlnRsnRmk(String plnRsnRmk) {
		this.plnRsnRmk = plnRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param plnRsnSubCd
	 */
	public void setPlnRsnSubCd(String plnRsnSubCd) {
		this.plnRsnSubCd = plnRsnSubCd;
	}
	
	/**
	 * Column Info
	 * @param mtyLodgTpszVals
	 */
	public void setMtyLodgTpszVals(String mtyLodgTpszVals) {
		this.mtyLodgTpszVals = mtyLodgTpszVals;
	}
	
	/**
	 * Column Info
	 * @param mtyBkgTeu
	 */
	public void setMtyBkgTeu(String mtyBkgTeu) {
		this.mtyBkgTeu = mtyBkgTeu;
	}
	
	/**
	 * Column Info
	 * @param avlTon
	 */
	public void setAvlTon(String avlTon) {
		this.avlTon = avlTon;
	}
	
	/**
	 * Column Info
	 * @param mtyPlnTon
	 */
	public void setMtyPlnTon(String mtyPlnTon) {
		this.mtyPlnTon = mtyPlnTon;
	}
	
	/**
	 * Column Info
	 * @param avlTeu
	 */
	public void setAvlTeu(String avlTeu) {
		this.avlTeu = avlTeu;
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
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setMtyLodgPlnTeu(JSPUtil.getParameter(request, prefix + "mty_lodg_pln_teu", ""));
		setMtyLodgPlnTon(JSPUtil.getParameter(request, prefix + "mty_lodg_pln_ton", ""));
		setRepoGlineRmk(JSPUtil.getParameter(request, prefix + "repo_gline_rmk", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setMtyPlnTeu(JSPUtil.getParameter(request, prefix + "mty_pln_teu", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMtyBkgQty(JSPUtil.getParameter(request, prefix + "mty_bkg_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setMtyPlnShwFlg(JSPUtil.getParameter(request, prefix + "mty_pln_shw_flg", ""));
		setFnlCbfFlg2(JSPUtil.getParameter(request, prefix + "fnl_cbf_flg2", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setPodYdCd2(JSPUtil.getParameter(request, prefix + "pod_yd_cd2", ""));
		setFnlCbfDt(JSPUtil.getParameter(request, prefix + "fnl_cbf_dt", ""));
		setPlnRsnHdrCd(JSPUtil.getParameter(request, prefix + "pln_rsn_hdr_cd", ""));
		setFnlCbfFlg(JSPUtil.getParameter(request, prefix + "fnl_cbf_flg", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setPlnRsnRmk(JSPUtil.getParameter(request, prefix + "pln_rsn_rmk", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setPlnRsnSubCd(JSPUtil.getParameter(request, prefix + "pln_rsn_sub_cd", ""));
		setMtyLodgTpszVals(JSPUtil.getParameter(request, prefix + "mty_lodg_tpsz_vals", ""));
		setMtyBkgTeu(JSPUtil.getParameter(request, prefix + "mty_bkg_teu", ""));
		setAvlTon(JSPUtil.getParameter(request, prefix + "avl_ton", ""));
		setMtyPlnTon(JSPUtil.getParameter(request, prefix + "mty_pln_ton", ""));
		setAvlTeu(JSPUtil.getParameter(request, prefix + "avl_teu", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EesEqr1013MtRepoPlanVO[]
	 */
	public EesEqr1013MtRepoPlanVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EesEqr1013MtRepoPlanVO[]
	 */
	public EesEqr1013MtRepoPlanVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EesEqr1013MtRepoPlanVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] mtyLodgPlnTeu = (JSPUtil.getParameter(request, prefix	+ "mty_lodg_pln_teu", length));
			String[] mtyLodgPlnTon = (JSPUtil.getParameter(request, prefix	+ "mty_lodg_pln_ton", length));
			String[] repoGlineRmk = (JSPUtil.getParameter(request, prefix	+ "repo_gline_rmk", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] mtyPlnTeu = (JSPUtil.getParameter(request, prefix	+ "mty_pln_teu", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mtyBkgQty = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] mtyPlnShwFlg = (JSPUtil.getParameter(request, prefix	+ "mty_pln_shw_flg", length));
			String[] fnlCbfFlg2 = (JSPUtil.getParameter(request, prefix	+ "fnl_cbf_flg2", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] podYdCd2 = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd2", length));
			String[] fnlCbfDt = (JSPUtil.getParameter(request, prefix	+ "fnl_cbf_dt", length));
			String[] plnRsnHdrCd = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_hdr_cd", length));
			String[] fnlCbfFlg = (JSPUtil.getParameter(request, prefix	+ "fnl_cbf_flg", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] plnRsnRmk = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_rmk", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] plnRsnSubCd = (JSPUtil.getParameter(request, prefix	+ "pln_rsn_sub_cd", length));
			String[] mtyLodgTpszVals = (JSPUtil.getParameter(request, prefix	+ "mty_lodg_tpsz_vals", length));
			String[] mtyBkgTeu = (JSPUtil.getParameter(request, prefix	+ "mty_bkg_teu", length));
			String[] avlTon = (JSPUtil.getParameter(request, prefix	+ "avl_ton", length));
			String[] mtyPlnTon = (JSPUtil.getParameter(request, prefix	+ "mty_pln_ton", length));
			String[] avlTeu = (JSPUtil.getParameter(request, prefix	+ "avl_teu", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new EesEqr1013MtRepoPlanVO();
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (mtyLodgPlnTeu[i] != null)
					model.setMtyLodgPlnTeu(mtyLodgPlnTeu[i]);
				if (mtyLodgPlnTon[i] != null)
					model.setMtyLodgPlnTon(mtyLodgPlnTon[i]);
				if (repoGlineRmk[i] != null)
					model.setRepoGlineRmk(repoGlineRmk[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (mtyPlnTeu[i] != null)
					model.setMtyPlnTeu(mtyPlnTeu[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mtyBkgQty[i] != null)
					model.setMtyBkgQty(mtyBkgQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (mtyPlnShwFlg[i] != null)
					model.setMtyPlnShwFlg(mtyPlnShwFlg[i]);
				if (fnlCbfFlg2[i] != null)
					model.setFnlCbfFlg2(fnlCbfFlg2[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (podYdCd2[i] != null)
					model.setPodYdCd2(podYdCd2[i]);
				if (fnlCbfDt[i] != null)
					model.setFnlCbfDt(fnlCbfDt[i]);
				if (plnRsnHdrCd[i] != null)
					model.setPlnRsnHdrCd(plnRsnHdrCd[i]);
				if (fnlCbfFlg[i] != null)
					model.setFnlCbfFlg(fnlCbfFlg[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (plnRsnRmk[i] != null)
					model.setPlnRsnRmk(plnRsnRmk[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (plnRsnSubCd[i] != null)
					model.setPlnRsnSubCd(plnRsnSubCd[i]);
				if (mtyLodgTpszVals[i] != null)
					model.setMtyLodgTpszVals(mtyLodgTpszVals[i]);
				if (mtyBkgTeu[i] != null)
					model.setMtyBkgTeu(mtyBkgTeu[i]);
				if (avlTon[i] != null)
					model.setAvlTon(avlTon[i]);
				if (mtyPlnTon[i] != null)
					model.setMtyPlnTon(mtyPlnTon[i]);
				if (avlTeu[i] != null)
					model.setAvlTeu(avlTeu[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEesEqr1013MtRepoPlanVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EesEqr1013MtRepoPlanVO[]
	 */
	public EesEqr1013MtRepoPlanVO[] getEesEqr1013MtRepoPlanVOs(){
		EesEqr1013MtRepoPlanVO[] vos = (EesEqr1013MtRepoPlanVO[])models.toArray(new EesEqr1013MtRepoPlanVO[models.size()]);
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
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyLodgPlnTeu = this.mtyLodgPlnTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyLodgPlnTon = this.mtyLodgPlnTon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoGlineRmk = this.repoGlineRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnTeu = this.mtyPlnTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgQty = this.mtyBkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnShwFlg = this.mtyPlnShwFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlCbfFlg2 = this.fnlCbfFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd2 = this.podYdCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlCbfDt = this.fnlCbfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnHdrCd = this.plnRsnHdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlCbfFlg = this.fnlCbfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnRmk = this.plnRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnRsnSubCd = this.plnRsnSubCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyLodgTpszVals = this.mtyLodgTpszVals .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyBkgTeu = this.mtyBkgTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avlTon = this.avlTon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnTon = this.mtyPlnTon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.avlTeu = this.avlTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
