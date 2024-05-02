/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AdjustOusRDRVO.java
*@FileTitle : AdjustOusRDRVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.27
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.10.27 박희동 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AdjustOusRDRVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AdjustOusRDRVO> models = new ArrayList<AdjustOusRDRVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bsaQty = null;
	/* Column Info */
	private String rdrTeu = null;
	/* Column Info */
	private String fmPortCd = null;
	/* Column Info */
	private String joStlItmCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String usdSltWgt = null;
	/* Column Info */
	private String revDirCd = null;
	/* Column Info */
	private String ucAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ucBssPortCd = null;
	/* Column Info */
	private String usdSltBsaQty = null;
	/* Column Info */
	private String fmPortEtdDt = null;
	/* Column Info */
	private String iocCd = null;
	/* Column Info */
	private String diffTeu = null;
	/* Column Info */
	private String rdrWgt = null;
	/* Column Info */
	private String loclCurrCd = null;
	/* Column Info */
	private String coaTeu = null;
	/* Column Info */
	private String fnlOwnBsaQty = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String fnlBsaWgt = null;
	/* Column Info */
	private String coaWgt = null;
	/* Column Info */
	private String diffWgt = null;
	/* Column Info */
	private String bsaSltPrc = null;
	/* Column Info */
	private String stlCmbSeq = null;
	/* Column Info */
	private String scontiCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AdjustOusRDRVO() {}

	public AdjustOusRDRVO(String ibflag, String pagerows, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String ucBssPortCd, String iocCd, String scontiCd, String fmPortCd, String fmPortEtdDt, String joStlItmCd, String coaTeu, String coaWgt, String fnlOwnBsaQty, String fnlBsaWgt, String diffTeu, String diffWgt, String usdSltBsaQty, String usdSltWgt, String rdrTeu, String rdrWgt, String bsaQty, String ucAmt, String bsaSltPrc, String loclCurrCd, String stlCmbSeq) {
		this.vslCd = vslCd;
		this.bsaQty = bsaQty;
		this.rdrTeu = rdrTeu;
		this.fmPortCd = fmPortCd;
		this.joStlItmCd = joStlItmCd;
		this.pagerows = pagerows;
		this.usdSltWgt = usdSltWgt;
		this.revDirCd = revDirCd;
		this.ucAmt = ucAmt;
		this.ibflag = ibflag;
		this.ucBssPortCd = ucBssPortCd;
		this.usdSltBsaQty = usdSltBsaQty;
		this.fmPortEtdDt = fmPortEtdDt;
		this.iocCd = iocCd;
		this.diffTeu = diffTeu;
		this.rdrWgt = rdrWgt;
		this.loclCurrCd = loclCurrCd;
		this.coaTeu = coaTeu;
		this.fnlOwnBsaQty = fnlOwnBsaQty;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.fnlBsaWgt = fnlBsaWgt;
		this.coaWgt = coaWgt;
		this.diffWgt = diffWgt;
		this.bsaSltPrc = bsaSltPrc;
		this.stlCmbSeq = stlCmbSeq;
		this.scontiCd = scontiCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bsa_qty", getBsaQty());
		this.hashColumns.put("rdr_teu", getRdrTeu());
		this.hashColumns.put("fm_port_cd", getFmPortCd());
		this.hashColumns.put("jo_stl_itm_cd", getJoStlItmCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("usd_slt_wgt", getUsdSltWgt());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("uc_amt", getUcAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("uc_bss_port_cd", getUcBssPortCd());
		this.hashColumns.put("usd_slt_bsa_qty", getUsdSltBsaQty());
		this.hashColumns.put("fm_port_etd_dt", getFmPortEtdDt());
		this.hashColumns.put("ioc_cd", getIocCd());
		this.hashColumns.put("diff_teu", getDiffTeu());
		this.hashColumns.put("rdr_wgt", getRdrWgt());
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());
		this.hashColumns.put("coa_teu", getCoaTeu());
		this.hashColumns.put("fnl_own_bsa_qty", getFnlOwnBsaQty());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("fnl_bsa_wgt", getFnlBsaWgt());
		this.hashColumns.put("coa_wgt", getCoaWgt());
		this.hashColumns.put("diff_wgt", getDiffWgt());
		this.hashColumns.put("bsa_slt_prc", getBsaSltPrc());
		this.hashColumns.put("stl_cmb_seq", getStlCmbSeq());
		this.hashColumns.put("sconti_cd", getScontiCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bsa_qty", "bsaQty");
		this.hashFields.put("rdr_teu", "rdrTeu");
		this.hashFields.put("fm_port_cd", "fmPortCd");
		this.hashFields.put("jo_stl_itm_cd", "joStlItmCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usd_slt_wgt", "usdSltWgt");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("uc_amt", "ucAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("uc_bss_port_cd", "ucBssPortCd");
		this.hashFields.put("usd_slt_bsa_qty", "usdSltBsaQty");
		this.hashFields.put("fm_port_etd_dt", "fmPortEtdDt");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("diff_teu", "diffTeu");
		this.hashFields.put("rdr_wgt", "rdrWgt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("coa_teu", "coaTeu");
		this.hashFields.put("fnl_own_bsa_qty", "fnlOwnBsaQty");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fnl_bsa_wgt", "fnlBsaWgt");
		this.hashFields.put("coa_wgt", "coaWgt");
		this.hashFields.put("diff_wgt", "diffWgt");
		this.hashFields.put("bsa_slt_prc", "bsaSltPrc");
		this.hashFields.put("stl_cmb_seq", "stlCmbSeq");
		this.hashFields.put("sconti_cd", "scontiCd");
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
	 * @return bsaQty
	 */
	public String getBsaQty() {
		return this.bsaQty;
	}
	
	/**
	 * Column Info
	 * @return rdrTeu
	 */
	public String getRdrTeu() {
		return this.rdrTeu;
	}
	
	/**
	 * Column Info
	 * @return fmPortCd
	 */
	public String getFmPortCd() {
		return this.fmPortCd;
	}
	
	/**
	 * Column Info
	 * @return joStlItmCd
	 */
	public String getJoStlItmCd() {
		return this.joStlItmCd;
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
	 * @return usdSltWgt
	 */
	public String getUsdSltWgt() {
		return this.usdSltWgt;
	}
	
	/**
	 * Column Info
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
	}
	
	/**
	 * Column Info
	 * @return ucAmt
	 */
	public String getUcAmt() {
		return this.ucAmt;
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
	 * @return ucBssPortCd
	 */
	public String getUcBssPortCd() {
		return this.ucBssPortCd;
	}
	
	/**
	 * Column Info
	 * @return usdSltBsaQty
	 */
	public String getUsdSltBsaQty() {
		return this.usdSltBsaQty;
	}
	
	/**
	 * Column Info
	 * @return fmPortEtdDt
	 */
	public String getFmPortEtdDt() {
		return this.fmPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @return iocCd
	 */
	public String getIocCd() {
		return this.iocCd;
	}
	
	/**
	 * Column Info
	 * @return diffTeu
	 */
	public String getDiffTeu() {
		return this.diffTeu;
	}
	
	/**
	 * Column Info
	 * @return rdrWgt
	 */
	public String getRdrWgt() {
		return this.rdrWgt;
	}
	
	/**
	 * Column Info
	 * @return loclCurrCd
	 */
	public String getLoclCurrCd() {
		return this.loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return coaTeu
	 */
	public String getCoaTeu() {
		return this.coaTeu;
	}
	
	/**
	 * Column Info
	 * @return fnlOwnBsaQty
	 */
	public String getFnlOwnBsaQty() {
		return this.fnlOwnBsaQty;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return fnlBsaWgt
	 */
	public String getFnlBsaWgt() {
		return this.fnlBsaWgt;
	}
	
	/**
	 * Column Info
	 * @return coaWgt
	 */
	public String getCoaWgt() {
		return this.coaWgt;
	}
	
	/**
	 * Column Info
	 * @return diffWgt
	 */
	public String getDiffWgt() {
		return this.diffWgt;
	}
	
	/**
	 * Column Info
	 * @return bsaSltPrc
	 */
	public String getBsaSltPrc() {
		return this.bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @return stlCmbSeq
	 */
	public String getStlCmbSeq() {
		return this.stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @return scontiCd
	 */
	public String getScontiCd() {
		return this.scontiCd;
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
	 * @param bsaQty
	 */
	public void setBsaQty(String bsaQty) {
		this.bsaQty = bsaQty;
	}
	
	/**
	 * Column Info
	 * @param rdrTeu
	 */
	public void setRdrTeu(String rdrTeu) {
		this.rdrTeu = rdrTeu;
	}
	
	/**
	 * Column Info
	 * @param fmPortCd
	 */
	public void setFmPortCd(String fmPortCd) {
		this.fmPortCd = fmPortCd;
	}
	
	/**
	 * Column Info
	 * @param joStlItmCd
	 */
	public void setJoStlItmCd(String joStlItmCd) {
		this.joStlItmCd = joStlItmCd;
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
	 * @param usdSltWgt
	 */
	public void setUsdSltWgt(String usdSltWgt) {
		this.usdSltWgt = usdSltWgt;
	}
	
	/**
	 * Column Info
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}
	
	/**
	 * Column Info
	 * @param ucAmt
	 */
	public void setUcAmt(String ucAmt) {
		this.ucAmt = ucAmt;
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
	 * @param ucBssPortCd
	 */
	public void setUcBssPortCd(String ucBssPortCd) {
		this.ucBssPortCd = ucBssPortCd;
	}
	
	/**
	 * Column Info
	 * @param usdSltBsaQty
	 */
	public void setUsdSltBsaQty(String usdSltBsaQty) {
		this.usdSltBsaQty = usdSltBsaQty;
	}
	
	/**
	 * Column Info
	 * @param fmPortEtdDt
	 */
	public void setFmPortEtdDt(String fmPortEtdDt) {
		this.fmPortEtdDt = fmPortEtdDt;
	}
	
	/**
	 * Column Info
	 * @param iocCd
	 */
	public void setIocCd(String iocCd) {
		this.iocCd = iocCd;
	}
	
	/**
	 * Column Info
	 * @param diffTeu
	 */
	public void setDiffTeu(String diffTeu) {
		this.diffTeu = diffTeu;
	}
	
	/**
	 * Column Info
	 * @param rdrWgt
	 */
	public void setRdrWgt(String rdrWgt) {
		this.rdrWgt = rdrWgt;
	}
	
	/**
	 * Column Info
	 * @param loclCurrCd
	 */
	public void setLoclCurrCd(String loclCurrCd) {
		this.loclCurrCd = loclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param coaTeu
	 */
	public void setCoaTeu(String coaTeu) {
		this.coaTeu = coaTeu;
	}
	
	/**
	 * Column Info
	 * @param fnlOwnBsaQty
	 */
	public void setFnlOwnBsaQty(String fnlOwnBsaQty) {
		this.fnlOwnBsaQty = fnlOwnBsaQty;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param fnlBsaWgt
	 */
	public void setFnlBsaWgt(String fnlBsaWgt) {
		this.fnlBsaWgt = fnlBsaWgt;
	}
	
	/**
	 * Column Info
	 * @param coaWgt
	 */
	public void setCoaWgt(String coaWgt) {
		this.coaWgt = coaWgt;
	}
	
	/**
	 * Column Info
	 * @param diffWgt
	 */
	public void setDiffWgt(String diffWgt) {
		this.diffWgt = diffWgt;
	}
	
	/**
	 * Column Info
	 * @param bsaSltPrc
	 */
	public void setBsaSltPrc(String bsaSltPrc) {
		this.bsaSltPrc = bsaSltPrc;
	}
	
	/**
	 * Column Info
	 * @param stlCmbSeq
	 */
	public void setStlCmbSeq(String stlCmbSeq) {
		this.stlCmbSeq = stlCmbSeq;
	}
	
	/**
	 * Column Info
	 * @param scontiCd
	 */
	public void setScontiCd(String scontiCd) {
		this.scontiCd = scontiCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBsaQty(JSPUtil.getParameter(request, "bsa_qty", ""));
		setRdrTeu(JSPUtil.getParameter(request, "rdr_teu", ""));
		setFmPortCd(JSPUtil.getParameter(request, "fm_port_cd", ""));
		setJoStlItmCd(JSPUtil.getParameter(request, "jo_stl_itm_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setUsdSltWgt(JSPUtil.getParameter(request, "usd_slt_wgt", ""));
		setRevDirCd(JSPUtil.getParameter(request, "rev_dir_cd", ""));
		setUcAmt(JSPUtil.getParameter(request, "uc_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setUcBssPortCd(JSPUtil.getParameter(request, "uc_bss_port_cd", ""));
		setUsdSltBsaQty(JSPUtil.getParameter(request, "usd_slt_bsa_qty", ""));
		setFmPortEtdDt(JSPUtil.getParameter(request, "fm_port_etd_dt", ""));
		setIocCd(JSPUtil.getParameter(request, "ioc_cd", ""));
		setDiffTeu(JSPUtil.getParameter(request, "diff_teu", ""));
		setRdrWgt(JSPUtil.getParameter(request, "rdr_wgt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request, "locl_curr_cd", ""));
		setCoaTeu(JSPUtil.getParameter(request, "coa_teu", ""));
		setFnlOwnBsaQty(JSPUtil.getParameter(request, "fnl_own_bsa_qty", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setFnlBsaWgt(JSPUtil.getParameter(request, "fnl_bsa_wgt", ""));
		setCoaWgt(JSPUtil.getParameter(request, "coa_wgt", ""));
		setDiffWgt(JSPUtil.getParameter(request, "diff_wgt", ""));
		setBsaSltPrc(JSPUtil.getParameter(request, "bsa_slt_prc", ""));
		setStlCmbSeq(JSPUtil.getParameter(request, "stl_cmb_seq", ""));
		setScontiCd(JSPUtil.getParameter(request, "sconti_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdjustOusRDRVO[]
	 */
	public AdjustOusRDRVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdjustOusRDRVO[]
	 */
	public AdjustOusRDRVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AdjustOusRDRVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bsaQty = (JSPUtil.getParameter(request, prefix	+ "bsa_qty", length));
			String[] rdrTeu = (JSPUtil.getParameter(request, prefix	+ "rdr_teu", length));
			String[] fmPortCd = (JSPUtil.getParameter(request, prefix	+ "fm_port_cd", length));
			String[] joStlItmCd = (JSPUtil.getParameter(request, prefix	+ "jo_stl_itm_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] usdSltWgt = (JSPUtil.getParameter(request, prefix	+ "usd_slt_wgt", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ucAmt = (JSPUtil.getParameter(request, prefix	+ "uc_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ucBssPortCd = (JSPUtil.getParameter(request, prefix	+ "uc_bss_port_cd", length));
			String[] usdSltBsaQty = (JSPUtil.getParameter(request, prefix	+ "usd_slt_bsa_qty", length));
			String[] fmPortEtdDt = (JSPUtil.getParameter(request, prefix	+ "fm_port_etd_dt", length));
			String[] iocCd = (JSPUtil.getParameter(request, prefix	+ "ioc_cd", length));
			String[] diffTeu = (JSPUtil.getParameter(request, prefix	+ "diff_teu", length));
			String[] rdrWgt = (JSPUtil.getParameter(request, prefix	+ "rdr_wgt", length));
			String[] loclCurrCd = (JSPUtil.getParameter(request, prefix	+ "locl_curr_cd", length));
			String[] coaTeu = (JSPUtil.getParameter(request, prefix	+ "coa_teu", length));
			String[] fnlOwnBsaQty = (JSPUtil.getParameter(request, prefix	+ "fnl_own_bsa_qty", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] fnlBsaWgt = (JSPUtil.getParameter(request, prefix	+ "fnl_bsa_wgt", length));
			String[] coaWgt = (JSPUtil.getParameter(request, prefix	+ "coa_wgt", length));
			String[] diffWgt = (JSPUtil.getParameter(request, prefix	+ "diff_wgt", length));
			String[] bsaSltPrc = (JSPUtil.getParameter(request, prefix	+ "bsa_slt_prc", length));
			String[] stlCmbSeq = (JSPUtil.getParameter(request, prefix	+ "stl_cmb_seq", length));
			String[] scontiCd = (JSPUtil.getParameter(request, prefix	+ "sconti_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AdjustOusRDRVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bsaQty[i] != null)
					model.setBsaQty(bsaQty[i]);
				if (rdrTeu[i] != null)
					model.setRdrTeu(rdrTeu[i]);
				if (fmPortCd[i] != null)
					model.setFmPortCd(fmPortCd[i]);
				if (joStlItmCd[i] != null)
					model.setJoStlItmCd(joStlItmCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (usdSltWgt[i] != null)
					model.setUsdSltWgt(usdSltWgt[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ucAmt[i] != null)
					model.setUcAmt(ucAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ucBssPortCd[i] != null)
					model.setUcBssPortCd(ucBssPortCd[i]);
				if (usdSltBsaQty[i] != null)
					model.setUsdSltBsaQty(usdSltBsaQty[i]);
				if (fmPortEtdDt[i] != null)
					model.setFmPortEtdDt(fmPortEtdDt[i]);
				if (iocCd[i] != null)
					model.setIocCd(iocCd[i]);
				if (diffTeu[i] != null)
					model.setDiffTeu(diffTeu[i]);
				if (rdrWgt[i] != null)
					model.setRdrWgt(rdrWgt[i]);
				if (loclCurrCd[i] != null)
					model.setLoclCurrCd(loclCurrCd[i]);
				if (coaTeu[i] != null)
					model.setCoaTeu(coaTeu[i]);
				if (fnlOwnBsaQty[i] != null)
					model.setFnlOwnBsaQty(fnlOwnBsaQty[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (fnlBsaWgt[i] != null)
					model.setFnlBsaWgt(fnlBsaWgt[i]);
				if (coaWgt[i] != null)
					model.setCoaWgt(coaWgt[i]);
				if (diffWgt[i] != null)
					model.setDiffWgt(diffWgt[i]);
				if (bsaSltPrc[i] != null)
					model.setBsaSltPrc(bsaSltPrc[i]);
				if (stlCmbSeq[i] != null)
					model.setStlCmbSeq(stlCmbSeq[i]);
				if (scontiCd[i] != null)
					model.setScontiCd(scontiCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAdjustOusRDRVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdjustOusRDRVO[]
	 */
	public AdjustOusRDRVO[] getAdjustOusRDRVOs(){
		AdjustOusRDRVO[] vos = (AdjustOusRDRVO[])models.toArray(new AdjustOusRDRVO[models.size()]);
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
		this.bsaQty = this.bsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrTeu = this.rdrTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortCd = this.fmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joStlItmCd = this.joStlItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdSltWgt = this.usdSltWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucAmt = this.ucAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucBssPortCd = this.ucBssPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdSltBsaQty = this.usdSltBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPortEtdDt = this.fmPortEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd = this.iocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffTeu = this.diffTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdrWgt = this.rdrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd = this.loclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaTeu = this.coaTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlOwnBsaQty = this.fnlOwnBsaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlBsaWgt = this.fnlBsaWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaWgt = this.coaWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffWgt = this.diffWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsaSltPrc = this.bsaSltPrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlCmbSeq = this.stlCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd = this.scontiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
