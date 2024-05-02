/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchSceCopHdrInfoVO.java
*@FileTitle : SearchSceCopHdrInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.01
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2009.09.01 오현경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo;

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
 * @author 오현경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSceCopHdrInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSceCopHdrInfoVO> models = new ArrayList<SearchSceCopHdrInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cnmvSeq = null;
	/* Column Info */
	private String copNo = null;
	/* Column Info */
	private String pctlNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obPctlNo = null;
	/* Column Info */
	private String trnkSkdDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String hngrSpclFlg = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String copStsCd = null;
	/* Column Info */
	private String dgSpclFlg = null;
	/* Column Info */
	private String spclAwkCgoFlg = null;
	/* Column Info */
	private String bbSpclFlg = null;
	/* Column Info */
	private String rfSpclFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String mstLclCd = null;
	/* Column Info */
	private String rdSpclFlg = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String ibPctlNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String trnkVslCd = null;
	/* Column Info */
	private String cnmvYr = null;
	/* Column Info */
	private String cntrVolQty = null;
	/* Column Info */
	private String trnkSkdVoyNo = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String code = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSceCopHdrInfoVO() {}

	public SearchSceCopHdrInfoVO(String ibflag, String pagerows, String chk, String mstLclCd, String cntrNo, String cntrTpszCd, String cnmvYr, String cnmvSeq, String bkgNo, String copStsCd, String cntrVolQty, String copNo, String pctlNo, String obPctlNo, String ibPctlNo, String polCd, String podCd, String porCd, String delCd, String trnkVslCd, String trnkSkdVoyNo, String trnkSkdDirCd, String dgSpclFlg, String rfSpclFlg, String spclAwkCgoFlg, String bbSpclFlg, String rdSpclFlg, String hngrSpclFlg, String socFlg, String bkgStsCd, String code) {
		this.porCd = porCd;
		this.cnmvSeq = cnmvSeq;
		this.copNo = copNo;
		this.pctlNo = pctlNo;
		this.pagerows = pagerows;
		this.obPctlNo = obPctlNo;
		this.trnkSkdDirCd = trnkSkdDirCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.hngrSpclFlg = hngrSpclFlg;
		this.cntrTpszCd = cntrTpszCd;
		this.copStsCd = copStsCd;
		this.dgSpclFlg = dgSpclFlg;
		this.spclAwkCgoFlg = spclAwkCgoFlg;
		this.bbSpclFlg = bbSpclFlg;
		this.rfSpclFlg = rfSpclFlg;
		this.delCd = delCd;
		this.mstLclCd = mstLclCd;
		this.rdSpclFlg = rdSpclFlg;
		this.socFlg = socFlg;
		this.ibPctlNo = ibPctlNo;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.chk = chk;
		this.cntrNo = cntrNo;
		this.trnkVslCd = trnkVslCd;
		this.cnmvYr = cnmvYr;
		this.cntrVolQty = cntrVolQty;
		this.trnkSkdVoyNo = trnkSkdVoyNo;
		this.bkgStsCd = bkgStsCd;
		this.code = code;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cnmv_seq", getCnmvSeq());
		this.hashColumns.put("cop_no", getCopNo());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_pctl_no", getObPctlNo());
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("hngr_spcl_flg", getHngrSpclFlg());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cop_sts_cd", getCopStsCd());
		this.hashColumns.put("dg_spcl_flg", getDgSpclFlg());
		this.hashColumns.put("spcl_awk_cgo_flg", getSpclAwkCgoFlg());
		this.hashColumns.put("bb_spcl_flg", getBbSpclFlg());
		this.hashColumns.put("rf_spcl_flg", getRfSpclFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("mst_lcl_cd", getMstLclCd());
		this.hashColumns.put("rd_spcl_flg", getRdSpclFlg());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("ib_pctl_no", getIbPctlNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());
		this.hashColumns.put("cnmv_yr", getCnmvYr());
		this.hashColumns.put("cntr_vol_qty", getCntrVolQty());
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("code", getCode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cnmv_seq", "cnmvSeq");
		this.hashFields.put("cop_no", "copNo");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_pctl_no", "obPctlNo");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("hngr_spcl_flg", "hngrSpclFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cop_sts_cd", "copStsCd");
		this.hashFields.put("dg_spcl_flg", "dgSpclFlg");
		this.hashFields.put("spcl_awk_cgo_flg", "spclAwkCgoFlg");
		this.hashFields.put("bb_spcl_flg", "bbSpclFlg");
		this.hashFields.put("rf_spcl_flg", "rfSpclFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("mst_lcl_cd", "mstLclCd");
		this.hashFields.put("rd_spcl_flg", "rdSpclFlg");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("ib_pctl_no", "ibPctlNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("cntr_vol_qty", "cntrVolQty");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");		
		this.hashFields.put("code", "code");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvSeq
	 */
	public String getCnmvSeq() {
		return this.cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @return copNo
	 */
	public String getCopNo() {
		return this.copNo;
	}
	
	/**
	 * Column Info
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
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
	 * @return obPctlNo
	 */
	public String getObPctlNo() {
		return this.obPctlNo;
	}
	
	/**
	 * Column Info
	 * @return trnkSkdDirCd
	 */
	public String getTrnkSkdDirCd() {
		return this.trnkSkdDirCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return hngrSpclFlg
	 */
	public String getHngrSpclFlg() {
		return this.hngrSpclFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return copStsCd
	 */
	public String getCopStsCd() {
		return this.copStsCd;
	}
	
	/**
	 * Column Info
	 * @return dgSpclFlg
	 */
	public String getDgSpclFlg() {
		return this.dgSpclFlg;
	}
	
	/**
	 * Column Info
	 * @return spclAwkCgoFlg
	 */
	public String getSpclAwkCgoFlg() {
		return this.spclAwkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @return bbSpclFlg
	 */
	public String getBbSpclFlg() {
		return this.bbSpclFlg;
	}
	
	/**
	 * Column Info
	 * @return rfSpclFlg
	 */
	public String getRfSpclFlg() {
		return this.rfSpclFlg;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return mstLclCd
	 */
	public String getMstLclCd() {
		return this.mstLclCd;
	}
	
	/**
	 * Column Info
	 * @return rdSpclFlg
	 */
	public String getRdSpclFlg() {
		return this.rdSpclFlg;
	}
	
	/**
	 * Column Info
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return ibPctlNo
	 */
	public String getIbPctlNo() {
		return this.ibPctlNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return trnkVslCd
	 */
	public String getTrnkVslCd() {
		return this.trnkVslCd;
	}
	
	/**
	 * Column Info
	 * @return cnmvYr
	 */
	public String getCnmvYr() {
		return this.cnmvYr;
	}
	
	/**
	 * Column Info
	 * @return cntrVolQty
	 */
	public String getCntrVolQty() {
		return this.cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @return trnkSkdVoyNo
	 */
	public String getTrnkSkdVoyNo() {
		return this.trnkSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvSeq
	 */
	public void setCnmvSeq(String cnmvSeq) {
		this.cnmvSeq = cnmvSeq;
	}
	
	/**
	 * Column Info
	 * @param copNo
	 */
	public void setCopNo(String copNo) {
		this.copNo = copNo;
	}
	
	/**
	 * Column Info
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
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
	 * @param obPctlNo
	 */
	public void setObPctlNo(String obPctlNo) {
		this.obPctlNo = obPctlNo;
	}
	
	/**
	 * Column Info
	 * @param trnkSkdDirCd
	 */
	public void setTrnkSkdDirCd(String trnkSkdDirCd) {
		this.trnkSkdDirCd = trnkSkdDirCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param hngrSpclFlg
	 */
	public void setHngrSpclFlg(String hngrSpclFlg) {
		this.hngrSpclFlg = hngrSpclFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param copStsCd
	 */
	public void setCopStsCd(String copStsCd) {
		this.copStsCd = copStsCd;
	}
	
	/**
	 * Column Info
	 * @param dgSpclFlg
	 */
	public void setDgSpclFlg(String dgSpclFlg) {
		this.dgSpclFlg = dgSpclFlg;
	}
	
	/**
	 * Column Info
	 * @param spclAwkCgoFlg
	 */
	public void setSpclAwkCgoFlg(String spclAwkCgoFlg) {
		this.spclAwkCgoFlg = spclAwkCgoFlg;
	}
	
	/**
	 * Column Info
	 * @param bbSpclFlg
	 */
	public void setBbSpclFlg(String bbSpclFlg) {
		this.bbSpclFlg = bbSpclFlg;
	}
	
	/**
	 * Column Info
	 * @param rfSpclFlg
	 */
	public void setRfSpclFlg(String rfSpclFlg) {
		this.rfSpclFlg = rfSpclFlg;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param mstLclCd
	 */
	public void setMstLclCd(String mstLclCd) {
		this.mstLclCd = mstLclCd;
	}
	
	/**
	 * Column Info
	 * @param rdSpclFlg
	 */
	public void setRdSpclFlg(String rdSpclFlg) {
		this.rdSpclFlg = rdSpclFlg;
	}
	
	/**
	 * Column Info
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param ibPctlNo
	 */
	public void setIbPctlNo(String ibPctlNo) {
		this.ibPctlNo = ibPctlNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param trnkVslCd
	 */
	public void setTrnkVslCd(String trnkVslCd) {
		this.trnkVslCd = trnkVslCd;
	}
	
	/**
	 * Column Info
	 * @param cnmvYr
	 */
	public void setCnmvYr(String cnmvYr) {
		this.cnmvYr = cnmvYr;
	}
	
	/**
	 * Column Info
	 * @param cntrVolQty
	 */
	public void setCntrVolQty(String cntrVolQty) {
		this.cntrVolQty = cntrVolQty;
	}
	
	/**
	 * Column Info
	 * @param trnkSkdVoyNo
	 */
	public void setTrnkSkdVoyNo(String trnkSkdVoyNo) {
		this.trnkSkdVoyNo = trnkSkdVoyNo;
	}
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}	
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCnmvSeq(JSPUtil.getParameter(request, "cnmv_seq", ""));
		setCopNo(JSPUtil.getParameter(request, "cop_no", ""));
		setPctlNo(JSPUtil.getParameter(request, "pctl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setObPctlNo(JSPUtil.getParameter(request, "ob_pctl_no", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request, "trnk_skd_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setHngrSpclFlg(JSPUtil.getParameter(request, "hngr_spcl_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setCopStsCd(JSPUtil.getParameter(request, "cop_sts_cd", ""));
		setDgSpclFlg(JSPUtil.getParameter(request, "dg_spcl_flg", ""));
		setSpclAwkCgoFlg(JSPUtil.getParameter(request, "spcl_awk_cgo_flg", ""));
		setBbSpclFlg(JSPUtil.getParameter(request, "bb_spcl_flg", ""));
		setRfSpclFlg(JSPUtil.getParameter(request, "rf_spcl_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setMstLclCd(JSPUtil.getParameter(request, "mst_lcl_cd", ""));
		setRdSpclFlg(JSPUtil.getParameter(request, "rd_spcl_flg", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setIbPctlNo(JSPUtil.getParameter(request, "ib_pctl_no", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setChk(JSPUtil.getParameter(request, "chk", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setTrnkVslCd(JSPUtil.getParameter(request, "trnk_vsl_cd", ""));
		setCnmvYr(JSPUtil.getParameter(request, "cnmv_yr", ""));
		setCntrVolQty(JSPUtil.getParameter(request, "cntr_vol_qty", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request, "trnk_skd_voy_no", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));	
		setCode(JSPUtil.getParameter(request, "code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSceCopHdrInfoVO[]
	 */
	public SearchSceCopHdrInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSceCopHdrInfoVO[]
	 */
	public SearchSceCopHdrInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSceCopHdrInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cnmvSeq = (JSPUtil.getParameter(request, prefix	+ "cnmv_seq", length));
			String[] copNo = (JSPUtil.getParameter(request, prefix	+ "cop_no", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obPctlNo = (JSPUtil.getParameter(request, prefix	+ "ob_pctl_no", length));
			String[] trnkSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] hngrSpclFlg = (JSPUtil.getParameter(request, prefix	+ "hngr_spcl_flg", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] copStsCd = (JSPUtil.getParameter(request, prefix	+ "cop_sts_cd", length));
			String[] dgSpclFlg = (JSPUtil.getParameter(request, prefix	+ "dg_spcl_flg", length));
			String[] spclAwkCgoFlg = (JSPUtil.getParameter(request, prefix	+ "spcl_awk_cgo_flg", length));
			String[] bbSpclFlg = (JSPUtil.getParameter(request, prefix	+ "bb_spcl_flg", length));
			String[] rfSpclFlg = (JSPUtil.getParameter(request, prefix	+ "rf_spcl_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] mstLclCd = (JSPUtil.getParameter(request, prefix	+ "mst_lcl_cd", length));
			String[] rdSpclFlg = (JSPUtil.getParameter(request, prefix	+ "rd_spcl_flg", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] ibPctlNo = (JSPUtil.getParameter(request, prefix	+ "ib_pctl_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] trnkVslCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vsl_cd", length));
			String[] cnmvYr = (JSPUtil.getParameter(request, prefix	+ "cnmv_yr", length));
			String[] cntrVolQty = (JSPUtil.getParameter(request, prefix	+ "cntr_vol_qty", length));
			String[] trnkSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "trnk_skd_voy_no", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));	
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));	
			
			for (int i = 0; i < length; i++) {
				model = new SearchSceCopHdrInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cnmvSeq[i] != null)
					model.setCnmvSeq(cnmvSeq[i]);
				if (copNo[i] != null)
					model.setCopNo(copNo[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obPctlNo[i] != null)
					model.setObPctlNo(obPctlNo[i]);
				if (trnkSkdDirCd[i] != null)
					model.setTrnkSkdDirCd(trnkSkdDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (hngrSpclFlg[i] != null)
					model.setHngrSpclFlg(hngrSpclFlg[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (copStsCd[i] != null)
					model.setCopStsCd(copStsCd[i]);
				if (dgSpclFlg[i] != null)
					model.setDgSpclFlg(dgSpclFlg[i]);
				if (spclAwkCgoFlg[i] != null)
					model.setSpclAwkCgoFlg(spclAwkCgoFlg[i]);
				if (bbSpclFlg[i] != null)
					model.setBbSpclFlg(bbSpclFlg[i]);
				if (rfSpclFlg[i] != null)
					model.setRfSpclFlg(rfSpclFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (mstLclCd[i] != null)
					model.setMstLclCd(mstLclCd[i]);
				if (rdSpclFlg[i] != null)
					model.setRdSpclFlg(rdSpclFlg[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (ibPctlNo[i] != null)
					model.setIbPctlNo(ibPctlNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (trnkVslCd[i] != null)
					model.setTrnkVslCd(trnkVslCd[i]);
				if (cnmvYr[i] != null)
					model.setCnmvYr(cnmvYr[i]);
				if (cntrVolQty[i] != null)
					model.setCntrVolQty(cntrVolQty[i]);
				if (trnkSkdVoyNo[i] != null)
					model.setTrnkSkdVoyNo(trnkSkdVoyNo[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSceCopHdrInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSceCopHdrInfoVO[]
	 */
	public SearchSceCopHdrInfoVO[] getSearchSceCopHdrInfoVOs(){
		SearchSceCopHdrInfoVO[] vos = (SearchSceCopHdrInfoVO[])models.toArray(new SearchSceCopHdrInfoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvSeq = this.cnmvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copNo = this.copNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obPctlNo = this.obPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd = this.trnkSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrSpclFlg = this.hngrSpclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.copStsCd = this.copStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgSpclFlg = this.dgSpclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclAwkCgoFlg = this.spclAwkCgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bbSpclFlg = this.bbSpclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfSpclFlg = this.rfSpclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstLclCd = this.mstLclCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdSpclFlg = this.rdSpclFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibPctlNo = this.ibPctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd = this.trnkVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr = this.cnmvYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVolQty = this.cntrVolQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo = this.trnkSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
