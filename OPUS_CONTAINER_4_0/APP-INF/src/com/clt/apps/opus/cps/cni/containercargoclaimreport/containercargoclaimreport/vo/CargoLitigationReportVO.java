/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoLitigationReportVO.java
*@FileTitle : CargoLitigationReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.06.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaimreport.containercargoclaimreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CargoLitigationReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CargoLitigationReportVO> models = new ArrayList<CargoLitigationReportVO>();
	
	/* Column Info */
	private String cgoClmStsDt = null;
	/* Column Info */
	private String insurPtyNm = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String clmOfrtAmt = null;
	/* Column Info */
	private String smnsSveDt = null;
	/* Column Info */
	private String n1stPstRefVvdNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lablPtyClmRmk = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String crrTermMiscNm = null;
	/* Column Info */
	private String pltNm = null;
	/* Column Info */
	private String clmCuzDesc = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String lablPtyDmndAmt = null;
	/* Column Info */
	private String deftAttyPtyNm = null;
	/* Column Info */
	private String cgoClmRefBlNo = null;
	/* Column Info */
	private String n1stPreTsDt = null;
	/* Column Info */
	private String cgoClmStlLoclAmt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String clmtLoclCurrCd = null;
	/* Column Info */
	private String crtCsNo = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cgoClmStlLoclCurrCd = null;
	/* Column Info */
	private String ltgtCsDesc = null;
	/* Column Info */
	private String clmtUsdAmt = null;
	/* Column Info */
	private String lablPtyRcvrLoclCurrCd = null;
	/* Column Info */
	private String agnPtyNm = null;
	/* Column Info */
	private String lablPtyFmalClmDt = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String clmtLoclAmt = null;
	/* Column Info */
	private String lablPtyRcvrUsdAmt = null;
	/* Column Info */
	private String deDt = null;
	/* Column Info */
	private String lablPtyDmndUsdAmt = null;
	/* Column Info */
	private String n1stPreTsLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deftNm = null;
	/* Column Info */
	private String lablPtyDmndCurrCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String cgoClmStlRmk = null;
	/* Column Info */
	private String cgoClmStsCd = null;
	/* Column Info */
	private String n1stPstTsDt = null;
	/* Column Info */
	private String cgoClmStlUsdAmt = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String lablPtyPtyNm = null;
	/* Column Info */
	private String lablPtyRcvrDt = null;
	/* Column Info */
	private String lablPtyRcvrLoclAmt = null;
	/* Column Info */
	private String cgoClmStlDt = null;
	/* Column Info */
	private String n1stPstTsLocCd = null;
	/* Column Info */
	private String dchgDt = null;
	/* Column Info */
	private String ofrtTermMiscNm = null;
	/* Column Info */
	private String crtNm = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String cgoClmRefCntrNo = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String lodgDt = null;
	/* Column Info */
	private String curDt = null;
	/* Column Info */
	private String n1stPreRefVvdNo = null;
	/* Column Info */
	private String rctDt = null;
	/* Column Info */
	private String cgoQltyDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CargoLitigationReportVO() {}

	public CargoLitigationReportVO(String ibflag, String pagerows, String hdlrOfcCd, String cgoClmStsCd, String cgoClmStsDt, String curDt, String cgoClmNo, String vslEngNm, String trnkRefVvdNo, String cgoClmRefBlNo, String cgoClmRefCntrNo, String shprNm, String cneeNm, String ntfyNm, String cgoQltyDesc, String crrTermMiscNm, String porCd, String rctDt, String polCd, String lodgDt, String podCd, String dchgDt, String delCd, String deDt, String n1stPreRefVvdNo, String n1stPreTsLocCd, String n1stPreTsDt, String n1stPstRefVvdNo, String n1stPstTsLocCd, String n1stPstTsDt, String clmOfrtAmt, String ofrtTermMiscNm, String insurPtyNm, String pltNm, String agnPtyNm, String deftNm, String deftAttyPtyNm, String smnsSveDt, String crtNm, String crtCsNo, String clmtLoclCurrCd, String clmtLoclAmt, String clmtUsdAmt, String clmCuzDesc, String ltgtCsDesc, String lablPtyPtyNm, String lablPtyDmndCurrCd, String lablPtyDmndAmt, String lablPtyDmndUsdAmt, String lablPtyFmalClmDt, String lablPtyRcvrLoclCurrCd, String lablPtyRcvrLoclAmt, String lablPtyRcvrUsdAmt, String lablPtyRcvrDt, String lablPtyClmRmk, String cgoClmStlRmk, String cgoClmStlLoclCurrCd, String cgoClmStlLoclAmt, String cgoClmStlUsdAmt, String cgoClmStlDt) {
		this.cgoClmStsDt = cgoClmStsDt;
		this.insurPtyNm = insurPtyNm;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.clmOfrtAmt = clmOfrtAmt;
		this.smnsSveDt = smnsSveDt;
		this.n1stPstRefVvdNo = n1stPstRefVvdNo;
		this.pagerows = pagerows;
		this.lablPtyClmRmk = lablPtyClmRmk;
		this.polCd = polCd;
		this.crrTermMiscNm = crrTermMiscNm;
		this.pltNm = pltNm;
		this.clmCuzDesc = clmCuzDesc;
		this.cgoClmNo = cgoClmNo;
		this.lablPtyDmndAmt = lablPtyDmndAmt;
		this.deftAttyPtyNm = deftAttyPtyNm;
		this.cgoClmRefBlNo = cgoClmRefBlNo;
		this.n1stPreTsDt = n1stPreTsDt;
		this.cgoClmStlLoclAmt = cgoClmStlLoclAmt;
		this.delCd = delCd;
		this.clmtLoclCurrCd = clmtLoclCurrCd;
		this.crtCsNo = crtCsNo;
		this.podCd = podCd;
		this.cgoClmStlLoclCurrCd = cgoClmStlLoclCurrCd;
		this.ltgtCsDesc = ltgtCsDesc;
		this.clmtUsdAmt = clmtUsdAmt;
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
		this.agnPtyNm = agnPtyNm;
		this.lablPtyFmalClmDt = lablPtyFmalClmDt;
		this.hdlrOfcCd = hdlrOfcCd;
		this.porCd = porCd;
		this.clmtLoclAmt = clmtLoclAmt;
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
		this.deDt = deDt;
		this.lablPtyDmndUsdAmt = lablPtyDmndUsdAmt;
		this.n1stPreTsLocCd = n1stPreTsLocCd;
		this.ibflag = ibflag;
		this.deftNm = deftNm;
		this.lablPtyDmndCurrCd = lablPtyDmndCurrCd;
		this.vslEngNm = vslEngNm;
		this.cgoClmStlRmk = cgoClmStlRmk;
		this.cgoClmStsCd = cgoClmStsCd;
		this.n1stPstTsDt = n1stPstTsDt;
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
		this.shprNm = shprNm;
		this.lablPtyPtyNm = lablPtyPtyNm;
		this.lablPtyRcvrDt = lablPtyRcvrDt;
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
		this.cgoClmStlDt = cgoClmStlDt;
		this.n1stPstTsLocCd = n1stPstTsLocCd;
		this.dchgDt = dchgDt;
		this.ofrtTermMiscNm = ofrtTermMiscNm;
		this.crtNm = crtNm;
		this.ntfyNm = ntfyNm;
		this.cgoClmRefCntrNo = cgoClmRefCntrNo;
		this.cneeNm = cneeNm;
		this.lodgDt = lodgDt;
		this.curDt = curDt;
		this.n1stPreRefVvdNo = n1stPreRefVvdNo;
		this.rctDt = rctDt;
		this.cgoQltyDesc = cgoQltyDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_clm_sts_dt", getCgoClmStsDt());
		this.hashColumns.put("insur_pty_nm", getInsurPtyNm());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("clm_ofrt_amt", getClmOfrtAmt());
		this.hashColumns.put("smns_sve_dt", getSmnsSveDt());
		this.hashColumns.put("n1st_pst_ref_vvd_no", getN1stPstRefVvdNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("labl_pty_clm_rmk", getLablPtyClmRmk());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("crr_term_misc_nm", getCrrTermMiscNm());
		this.hashColumns.put("plt_nm", getPltNm());
		this.hashColumns.put("clm_cuz_desc", getClmCuzDesc());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("labl_pty_dmnd_amt", getLablPtyDmndAmt());
		this.hashColumns.put("deft_atty_pty_nm", getDeftAttyPtyNm());
		this.hashColumns.put("cgo_clm_ref_bl_no", getCgoClmRefBlNo());
		this.hashColumns.put("n1st_pre_ts_dt", getN1stPreTsDt());
		this.hashColumns.put("cgo_clm_stl_locl_amt", getCgoClmStlLoclAmt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("clmt_locl_curr_cd", getClmtLoclCurrCd());
		this.hashColumns.put("crt_cs_no", getCrtCsNo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cgo_clm_stl_locl_curr_cd", getCgoClmStlLoclCurrCd());
		this.hashColumns.put("ltgt_cs_desc", getLtgtCsDesc());
		this.hashColumns.put("clmt_usd_amt", getClmtUsdAmt());
		this.hashColumns.put("labl_pty_rcvr_locl_curr_cd", getLablPtyRcvrLoclCurrCd());
		this.hashColumns.put("agn_pty_nm", getAgnPtyNm());
		this.hashColumns.put("labl_pty_fmal_clm_dt", getLablPtyFmalClmDt());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("clmt_locl_amt", getClmtLoclAmt());
		this.hashColumns.put("labl_pty_rcvr_usd_amt", getLablPtyRcvrUsdAmt());
		this.hashColumns.put("de_dt", getDeDt());
		this.hashColumns.put("labl_pty_dmnd_usd_amt", getLablPtyDmndUsdAmt());
		this.hashColumns.put("n1st_pre_ts_loc_cd", getN1stPreTsLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("deft_nm", getDeftNm());
		this.hashColumns.put("labl_pty_dmnd_curr_cd", getLablPtyDmndCurrCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("cgo_clm_stl_rmk", getCgoClmStlRmk());
		this.hashColumns.put("cgo_clm_sts_cd", getCgoClmStsCd());
		this.hashColumns.put("n1st_pst_ts_dt", getN1stPstTsDt());
		this.hashColumns.put("cgo_clm_stl_usd_amt", getCgoClmStlUsdAmt());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("labl_pty_pty_nm", getLablPtyPtyNm());
		this.hashColumns.put("labl_pty_rcvr_dt", getLablPtyRcvrDt());
		this.hashColumns.put("labl_pty_rcvr_locl_amt", getLablPtyRcvrLoclAmt());
		this.hashColumns.put("cgo_clm_stl_dt", getCgoClmStlDt());
		this.hashColumns.put("n1st_pst_ts_loc_cd", getN1stPstTsLocCd());
		this.hashColumns.put("dchg_dt", getDchgDt());
		this.hashColumns.put("ofrt_term_misc_nm", getOfrtTermMiscNm());
		this.hashColumns.put("crt_nm", getCrtNm());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("cgo_clm_ref_cntr_no", getCgoClmRefCntrNo());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("lodg_dt", getLodgDt());
		this.hashColumns.put("cur_dt", getCurDt());
		this.hashColumns.put("n1st_pre_ref_vvd_no", getN1stPreRefVvdNo());
		this.hashColumns.put("rct_dt", getRctDt());
		this.hashColumns.put("cgo_qlty_desc", getCgoQltyDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_clm_sts_dt", "cgoClmStsDt");
		this.hashFields.put("insur_pty_nm", "insurPtyNm");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("clm_ofrt_amt", "clmOfrtAmt");
		this.hashFields.put("smns_sve_dt", "smnsSveDt");
		this.hashFields.put("n1st_pst_ref_vvd_no", "n1stPstRefVvdNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("labl_pty_clm_rmk", "lablPtyClmRmk");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("crr_term_misc_nm", "crrTermMiscNm");
		this.hashFields.put("plt_nm", "pltNm");
		this.hashFields.put("clm_cuz_desc", "clmCuzDesc");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("labl_pty_dmnd_amt", "lablPtyDmndAmt");
		this.hashFields.put("deft_atty_pty_nm", "deftAttyPtyNm");
		this.hashFields.put("cgo_clm_ref_bl_no", "cgoClmRefBlNo");
		this.hashFields.put("n1st_pre_ts_dt", "n1stPreTsDt");
		this.hashFields.put("cgo_clm_stl_locl_amt", "cgoClmStlLoclAmt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("clmt_locl_curr_cd", "clmtLoclCurrCd");
		this.hashFields.put("crt_cs_no", "crtCsNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cgo_clm_stl_locl_curr_cd", "cgoClmStlLoclCurrCd");
		this.hashFields.put("ltgt_cs_desc", "ltgtCsDesc");
		this.hashFields.put("clmt_usd_amt", "clmtUsdAmt");
		this.hashFields.put("labl_pty_rcvr_locl_curr_cd", "lablPtyRcvrLoclCurrCd");
		this.hashFields.put("agn_pty_nm", "agnPtyNm");
		this.hashFields.put("labl_pty_fmal_clm_dt", "lablPtyFmalClmDt");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("clmt_locl_amt", "clmtLoclAmt");
		this.hashFields.put("labl_pty_rcvr_usd_amt", "lablPtyRcvrUsdAmt");
		this.hashFields.put("de_dt", "deDt");
		this.hashFields.put("labl_pty_dmnd_usd_amt", "lablPtyDmndUsdAmt");
		this.hashFields.put("n1st_pre_ts_loc_cd", "n1stPreTsLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("deft_nm", "deftNm");
		this.hashFields.put("labl_pty_dmnd_curr_cd", "lablPtyDmndCurrCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("cgo_clm_stl_rmk", "cgoClmStlRmk");
		this.hashFields.put("cgo_clm_sts_cd", "cgoClmStsCd");
		this.hashFields.put("n1st_pst_ts_dt", "n1stPstTsDt");
		this.hashFields.put("cgo_clm_stl_usd_amt", "cgoClmStlUsdAmt");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("labl_pty_pty_nm", "lablPtyPtyNm");
		this.hashFields.put("labl_pty_rcvr_dt", "lablPtyRcvrDt");
		this.hashFields.put("labl_pty_rcvr_locl_amt", "lablPtyRcvrLoclAmt");
		this.hashFields.put("cgo_clm_stl_dt", "cgoClmStlDt");
		this.hashFields.put("n1st_pst_ts_loc_cd", "n1stPstTsLocCd");
		this.hashFields.put("dchg_dt", "dchgDt");
		this.hashFields.put("ofrt_term_misc_nm", "ofrtTermMiscNm");
		this.hashFields.put("crt_nm", "crtNm");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("cgo_clm_ref_cntr_no", "cgoClmRefCntrNo");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("lodg_dt", "lodgDt");
		this.hashFields.put("cur_dt", "curDt");
		this.hashFields.put("n1st_pre_ref_vvd_no", "n1stPreRefVvdNo");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("cgo_qlty_desc", "cgoQltyDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStsDt
	 */
	public String getCgoClmStsDt() {
		return this.cgoClmStsDt;
	}
	
	/**
	 * Column Info
	 * @return insurPtyNm
	 */
	public String getInsurPtyNm() {
		return this.insurPtyNm;
	}
	
	/**
	 * Column Info
	 * @return trnkRefVvdNo
	 */
	public String getTrnkRefVvdNo() {
		return this.trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return clmOfrtAmt
	 */
	public String getClmOfrtAmt() {
		return this.clmOfrtAmt;
	}
	
	/**
	 * Column Info
	 * @return smnsSveDt
	 */
	public String getSmnsSveDt() {
		return this.smnsSveDt;
	}
	
	/**
	 * Column Info
	 * @return n1stPstRefVvdNo
	 */
	public String getN1stPstRefVvdNo() {
		return this.n1stPstRefVvdNo;
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
	 * @return lablPtyClmRmk
	 */
	public String getLablPtyClmRmk() {
		return this.lablPtyClmRmk;
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
	 * @return crrTermMiscNm
	 */
	public String getCrrTermMiscNm() {
		return this.crrTermMiscNm;
	}
	
	/**
	 * Column Info
	 * @return pltNm
	 */
	public String getPltNm() {
		return this.pltNm;
	}
	
	/**
	 * Column Info
	 * @return clmCuzDesc
	 */
	public String getClmCuzDesc() {
		return this.clmCuzDesc;
	}
	
	/**
	 * Column Info
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return lablPtyDmndAmt
	 */
	public String getLablPtyDmndAmt() {
		return this.lablPtyDmndAmt;
	}
	
	/**
	 * Column Info
	 * @return deftAttyPtyNm
	 */
	public String getDeftAttyPtyNm() {
		return this.deftAttyPtyNm;
	}
	
	/**
	 * Column Info
	 * @return cgoClmRefBlNo
	 */
	public String getCgoClmRefBlNo() {
		return this.cgoClmRefBlNo;
	}
	
	/**
	 * Column Info
	 * @return n1stPreTsDt
	 */
	public String getN1stPreTsDt() {
		return this.n1stPreTsDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlLoclAmt
	 */
	public String getCgoClmStlLoclAmt() {
		return this.cgoClmStlLoclAmt;
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
	 * @return clmtLoclCurrCd
	 */
	public String getClmtLoclCurrCd() {
		return this.clmtLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return crtCsNo
	 */
	public String getCrtCsNo() {
		return this.crtCsNo;
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
	 * @return cgoClmStlLoclCurrCd
	 */
	public String getCgoClmStlLoclCurrCd() {
		return this.cgoClmStlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return ltgtCsDesc
	 */
	public String getLtgtCsDesc() {
		return this.ltgtCsDesc;
	}
	
	/**
	 * Column Info
	 * @return clmtUsdAmt
	 */
	public String getClmtUsdAmt() {
		return this.clmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrLoclCurrCd
	 */
	public String getLablPtyRcvrLoclCurrCd() {
		return this.lablPtyRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return agnPtyNm
	 */
	public String getAgnPtyNm() {
		return this.agnPtyNm;
	}
	
	/**
	 * Column Info
	 * @return lablPtyFmalClmDt
	 */
	public String getLablPtyFmalClmDt() {
		return this.lablPtyFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
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
	 * @return clmtLoclAmt
	 */
	public String getClmtLoclAmt() {
		return this.clmtLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrUsdAmt
	 */
	public String getLablPtyRcvrUsdAmt() {
		return this.lablPtyRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return deDt
	 */
	public String getDeDt() {
		return this.deDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyDmndUsdAmt
	 */
	public String getLablPtyDmndUsdAmt() {
		return this.lablPtyDmndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return n1stPreTsLocCd
	 */
	public String getN1stPreTsLocCd() {
		return this.n1stPreTsLocCd;
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
	 * @return deftNm
	 */
	public String getDeftNm() {
		return this.deftNm;
	}
	
	/**
	 * Column Info
	 * @return lablPtyDmndCurrCd
	 */
	public String getLablPtyDmndCurrCd() {
		return this.lablPtyDmndCurrCd;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlRmk
	 */
	public String getCgoClmStlRmk() {
		return this.cgoClmStlRmk;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStsCd
	 */
	public String getCgoClmStsCd() {
		return this.cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPstTsDt
	 */
	public String getN1stPstTsDt() {
		return this.n1stPstTsDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlUsdAmt
	 */
	public String getCgoClmStlUsdAmt() {
		return this.cgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return lablPtyPtyNm
	 */
	public String getLablPtyPtyNm() {
		return this.lablPtyPtyNm;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrDt
	 */
	public String getLablPtyRcvrDt() {
		return this.lablPtyRcvrDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrLoclAmt
	 */
	public String getLablPtyRcvrLoclAmt() {
		return this.lablPtyRcvrLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlDt
	 */
	public String getCgoClmStlDt() {
		return this.cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @return n1stPstTsLocCd
	 */
	public String getN1stPstTsLocCd() {
		return this.n1stPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @return dchgDt
	 */
	public String getDchgDt() {
		return this.dchgDt;
	}
	
	/**
	 * Column Info
	 * @return ofrtTermMiscNm
	 */
	public String getOfrtTermMiscNm() {
		return this.ofrtTermMiscNm;
	}
	
	/**
	 * Column Info
	 * @return crtNm
	 */
	public String getCrtNm() {
		return this.crtNm;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
	}
	
	/**
	 * Column Info
	 * @return cgoClmRefCntrNo
	 */
	public String getCgoClmRefCntrNo() {
		return this.cgoClmRefCntrNo;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return lodgDt
	 */
	public String getLodgDt() {
		return this.lodgDt;
	}
	
	/**
	 * Column Info
	 * @return curDt
	 */
	public String getCurDt() {
		return this.curDt;
	}
	
	/**
	 * Column Info
	 * @return n1stPreRefVvdNo
	 */
	public String getN1stPreRefVvdNo() {
		return this.n1stPreRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return rctDt
	 */
	public String getRctDt() {
		return this.rctDt;
	}
	
	/**
	 * Column Info
	 * @return cgoQltyDesc
	 */
	public String getCgoQltyDesc() {
		return this.cgoQltyDesc;
	}
	

	/**
	 * Column Info
	 * @param cgoClmStsDt
	 */
	public void setCgoClmStsDt(String cgoClmStsDt) {
		this.cgoClmStsDt = cgoClmStsDt;
	}
	
	/**
	 * Column Info
	 * @param insurPtyNm
	 */
	public void setInsurPtyNm(String insurPtyNm) {
		this.insurPtyNm = insurPtyNm;
	}
	
	/**
	 * Column Info
	 * @param trnkRefVvdNo
	 */
	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param clmOfrtAmt
	 */
	public void setClmOfrtAmt(String clmOfrtAmt) {
		this.clmOfrtAmt = clmOfrtAmt;
	}
	
	/**
	 * Column Info
	 * @param smnsSveDt
	 */
	public void setSmnsSveDt(String smnsSveDt) {
		this.smnsSveDt = smnsSveDt;
	}
	
	/**
	 * Column Info
	 * @param n1stPstRefVvdNo
	 */
	public void setN1stPstRefVvdNo(String n1stPstRefVvdNo) {
		this.n1stPstRefVvdNo = n1stPstRefVvdNo;
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
	 * @param lablPtyClmRmk
	 */
	public void setLablPtyClmRmk(String lablPtyClmRmk) {
		this.lablPtyClmRmk = lablPtyClmRmk;
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
	 * @param crrTermMiscNm
	 */
	public void setCrrTermMiscNm(String crrTermMiscNm) {
		this.crrTermMiscNm = crrTermMiscNm;
	}
	
	/**
	 * Column Info
	 * @param pltNm
	 */
	public void setPltNm(String pltNm) {
		this.pltNm = pltNm;
	}
	
	/**
	 * Column Info
	 * @param clmCuzDesc
	 */
	public void setClmCuzDesc(String clmCuzDesc) {
		this.clmCuzDesc = clmCuzDesc;
	}
	
	/**
	 * Column Info
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param lablPtyDmndAmt
	 */
	public void setLablPtyDmndAmt(String lablPtyDmndAmt) {
		this.lablPtyDmndAmt = lablPtyDmndAmt;
	}
	
	/**
	 * Column Info
	 * @param deftAttyPtyNm
	 */
	public void setDeftAttyPtyNm(String deftAttyPtyNm) {
		this.deftAttyPtyNm = deftAttyPtyNm;
	}
	
	/**
	 * Column Info
	 * @param cgoClmRefBlNo
	 */
	public void setCgoClmRefBlNo(String cgoClmRefBlNo) {
		this.cgoClmRefBlNo = cgoClmRefBlNo;
	}
	
	/**
	 * Column Info
	 * @param n1stPreTsDt
	 */
	public void setN1stPreTsDt(String n1stPreTsDt) {
		this.n1stPreTsDt = n1stPreTsDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlLoclAmt
	 */
	public void setCgoClmStlLoclAmt(String cgoClmStlLoclAmt) {
		this.cgoClmStlLoclAmt = cgoClmStlLoclAmt;
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
	 * @param clmtLoclCurrCd
	 */
	public void setClmtLoclCurrCd(String clmtLoclCurrCd) {
		this.clmtLoclCurrCd = clmtLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param crtCsNo
	 */
	public void setCrtCsNo(String crtCsNo) {
		this.crtCsNo = crtCsNo;
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
	 * @param cgoClmStlLoclCurrCd
	 */
	public void setCgoClmStlLoclCurrCd(String cgoClmStlLoclCurrCd) {
		this.cgoClmStlLoclCurrCd = cgoClmStlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param ltgtCsDesc
	 */
	public void setLtgtCsDesc(String ltgtCsDesc) {
		this.ltgtCsDesc = ltgtCsDesc;
	}
	
	/**
	 * Column Info
	 * @param clmtUsdAmt
	 */
	public void setClmtUsdAmt(String clmtUsdAmt) {
		this.clmtUsdAmt = clmtUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrLoclCurrCd
	 */
	public void setLablPtyRcvrLoclCurrCd(String lablPtyRcvrLoclCurrCd) {
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param agnPtyNm
	 */
	public void setAgnPtyNm(String agnPtyNm) {
		this.agnPtyNm = agnPtyNm;
	}
	
	/**
	 * Column Info
	 * @param lablPtyFmalClmDt
	 */
	public void setLablPtyFmalClmDt(String lablPtyFmalClmDt) {
		this.lablPtyFmalClmDt = lablPtyFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
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
	 * @param clmtLoclAmt
	 */
	public void setClmtLoclAmt(String clmtLoclAmt) {
		this.clmtLoclAmt = clmtLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrUsdAmt
	 */
	public void setLablPtyRcvrUsdAmt(String lablPtyRcvrUsdAmt) {
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param deDt
	 */
	public void setDeDt(String deDt) {
		this.deDt = deDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyDmndUsdAmt
	 */
	public void setLablPtyDmndUsdAmt(String lablPtyDmndUsdAmt) {
		this.lablPtyDmndUsdAmt = lablPtyDmndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param n1stPreTsLocCd
	 */
	public void setN1stPreTsLocCd(String n1stPreTsLocCd) {
		this.n1stPreTsLocCd = n1stPreTsLocCd;
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
	 * @param deftNm
	 */
	public void setDeftNm(String deftNm) {
		this.deftNm = deftNm;
	}
	
	/**
	 * Column Info
	 * @param lablPtyDmndCurrCd
	 */
	public void setLablPtyDmndCurrCd(String lablPtyDmndCurrCd) {
		this.lablPtyDmndCurrCd = lablPtyDmndCurrCd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlRmk
	 */
	public void setCgoClmStlRmk(String cgoClmStlRmk) {
		this.cgoClmStlRmk = cgoClmStlRmk;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStsCd
	 */
	public void setCgoClmStsCd(String cgoClmStsCd) {
		this.cgoClmStsCd = cgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPstTsDt
	 */
	public void setN1stPstTsDt(String n1stPstTsDt) {
		this.n1stPstTsDt = n1stPstTsDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlUsdAmt
	 */
	public void setCgoClmStlUsdAmt(String cgoClmStlUsdAmt) {
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param lablPtyPtyNm
	 */
	public void setLablPtyPtyNm(String lablPtyPtyNm) {
		this.lablPtyPtyNm = lablPtyPtyNm;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrDt
	 */
	public void setLablPtyRcvrDt(String lablPtyRcvrDt) {
		this.lablPtyRcvrDt = lablPtyRcvrDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrLoclAmt
	 */
	public void setLablPtyRcvrLoclAmt(String lablPtyRcvrLoclAmt) {
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlDt
	 */
	public void setCgoClmStlDt(String cgoClmStlDt) {
		this.cgoClmStlDt = cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @param n1stPstTsLocCd
	 */
	public void setN1stPstTsLocCd(String n1stPstTsLocCd) {
		this.n1stPstTsLocCd = n1stPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param dchgDt
	 */
	public void setDchgDt(String dchgDt) {
		this.dchgDt = dchgDt;
	}
	
	/**
	 * Column Info
	 * @param ofrtTermMiscNm
	 */
	public void setOfrtTermMiscNm(String ofrtTermMiscNm) {
		this.ofrtTermMiscNm = ofrtTermMiscNm;
	}
	
	/**
	 * Column Info
	 * @param crtNm
	 */
	public void setCrtNm(String crtNm) {
		this.crtNm = crtNm;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
	}
	
	/**
	 * Column Info
	 * @param cgoClmRefCntrNo
	 */
	public void setCgoClmRefCntrNo(String cgoClmRefCntrNo) {
		this.cgoClmRefCntrNo = cgoClmRefCntrNo;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param lodgDt
	 */
	public void setLodgDt(String lodgDt) {
		this.lodgDt = lodgDt;
	}
	
	/**
	 * Column Info
	 * @param curDt
	 */
	public void setCurDt(String curDt) {
		this.curDt = curDt;
	}
	
	/**
	 * Column Info
	 * @param n1stPreRefVvdNo
	 */
	public void setN1stPreRefVvdNo(String n1stPreRefVvdNo) {
		this.n1stPreRefVvdNo = n1stPreRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param rctDt
	 */
	public void setRctDt(String rctDt) {
		this.rctDt = rctDt;
	}
	
	/**
	 * Column Info
	 * @param cgoQltyDesc
	 */
	public void setCgoQltyDesc(String cgoQltyDesc) {
		this.cgoQltyDesc = cgoQltyDesc;
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
		setCgoClmStsDt(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_dt", ""));
		setInsurPtyNm(JSPUtil.getParameter(request, prefix + "insur_pty_nm", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, prefix + "trnk_ref_vvd_no", ""));
		setClmOfrtAmt(JSPUtil.getParameter(request, prefix + "clm_ofrt_amt", ""));
		setSmnsSveDt(JSPUtil.getParameter(request, prefix + "smns_sve_dt", ""));
		setN1stPstRefVvdNo(JSPUtil.getParameter(request, prefix + "n1st_pst_ref_vvd_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLablPtyClmRmk(JSPUtil.getParameter(request, prefix + "labl_pty_clm_rmk", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCrrTermMiscNm(JSPUtil.getParameter(request, prefix + "crr_term_misc_nm", ""));
		setPltNm(JSPUtil.getParameter(request, prefix + "plt_nm", ""));
		setClmCuzDesc(JSPUtil.getParameter(request, prefix + "clm_cuz_desc", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setLablPtyDmndAmt(JSPUtil.getParameter(request, prefix + "labl_pty_dmnd_amt", ""));
		setDeftAttyPtyNm(JSPUtil.getParameter(request, prefix + "deft_atty_pty_nm", ""));
		setCgoClmRefBlNo(JSPUtil.getParameter(request, prefix + "cgo_clm_ref_bl_no", ""));
		setN1stPreTsDt(JSPUtil.getParameter(request, prefix + "n1st_pre_ts_dt", ""));
		setCgoClmStlLoclAmt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_locl_amt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setClmtLoclCurrCd(JSPUtil.getParameter(request, prefix + "clmt_locl_curr_cd", ""));
		setCrtCsNo(JSPUtil.getParameter(request, prefix + "crt_cs_no", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCgoClmStlLoclCurrCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_locl_curr_cd", ""));
		setLtgtCsDesc(JSPUtil.getParameter(request, prefix + "ltgt_cs_desc", ""));
		setClmtUsdAmt(JSPUtil.getParameter(request, prefix + "clmt_usd_amt", ""));
		setLablPtyRcvrLoclCurrCd(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_curr_cd", ""));
		setAgnPtyNm(JSPUtil.getParameter(request, prefix + "agn_pty_nm", ""));
		setLablPtyFmalClmDt(JSPUtil.getParameter(request, prefix + "labl_pty_fmal_clm_dt", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setClmtLoclAmt(JSPUtil.getParameter(request, prefix + "clmt_locl_amt", ""));
		setLablPtyRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_usd_amt", ""));
		setDeDt(JSPUtil.getParameter(request, prefix + "de_dt", ""));
		setLablPtyDmndUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_dmnd_usd_amt", ""));
		setN1stPreTsLocCd(JSPUtil.getParameter(request, prefix + "n1st_pre_ts_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDeftNm(JSPUtil.getParameter(request, prefix + "deft_nm", ""));
		setLablPtyDmndCurrCd(JSPUtil.getParameter(request, prefix + "labl_pty_dmnd_curr_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setCgoClmStlRmk(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_rmk", ""));
		setCgoClmStsCd(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_cd", ""));
		setN1stPstTsDt(JSPUtil.getParameter(request, prefix + "n1st_pst_ts_dt", ""));
		setCgoClmStlUsdAmt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_usd_amt", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setLablPtyPtyNm(JSPUtil.getParameter(request, prefix + "labl_pty_pty_nm", ""));
		setLablPtyRcvrDt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_dt", ""));
		setLablPtyRcvrLoclAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_amt", ""));
		setCgoClmStlDt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_dt", ""));
		setN1stPstTsLocCd(JSPUtil.getParameter(request, prefix + "n1st_pst_ts_loc_cd", ""));
		setDchgDt(JSPUtil.getParameter(request, prefix + "dchg_dt", ""));
		setOfrtTermMiscNm(JSPUtil.getParameter(request, prefix + "ofrt_term_misc_nm", ""));
		setCrtNm(JSPUtil.getParameter(request, prefix + "crt_nm", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setCgoClmRefCntrNo(JSPUtil.getParameter(request, prefix + "cgo_clm_ref_cntr_no", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setLodgDt(JSPUtil.getParameter(request, prefix + "lodg_dt", ""));
		setCurDt(JSPUtil.getParameter(request, prefix + "cur_dt", ""));
		setN1stPreRefVvdNo(JSPUtil.getParameter(request, prefix + "n1st_pre_ref_vvd_no", ""));
		setRctDt(JSPUtil.getParameter(request, prefix + "rct_dt", ""));
		setCgoQltyDesc(JSPUtil.getParameter(request, prefix + "cgo_qlty_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CargoLitigationReportVO[]
	 */
	public CargoLitigationReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CargoLitigationReportVO[]
	 */
	public CargoLitigationReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CargoLitigationReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoClmStsDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_dt", length));
			String[] insurPtyNm = (JSPUtil.getParameter(request, prefix	+ "insur_pty_nm", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] clmOfrtAmt = (JSPUtil.getParameter(request, prefix	+ "clm_ofrt_amt", length));
			String[] smnsSveDt = (JSPUtil.getParameter(request, prefix	+ "smns_sve_dt", length));
			String[] n1stPstRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ref_vvd_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lablPtyClmRmk = (JSPUtil.getParameter(request, prefix	+ "labl_pty_clm_rmk", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] crrTermMiscNm = (JSPUtil.getParameter(request, prefix	+ "crr_term_misc_nm", length));
			String[] pltNm = (JSPUtil.getParameter(request, prefix	+ "plt_nm", length));
			String[] clmCuzDesc = (JSPUtil.getParameter(request, prefix	+ "clm_cuz_desc", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] lablPtyDmndAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_amt", length));
			String[] deftAttyPtyNm = (JSPUtil.getParameter(request, prefix	+ "deft_atty_pty_nm", length));
			String[] cgoClmRefBlNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_bl_no", length));
			String[] n1stPreTsDt = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ts_dt", length));
			String[] cgoClmStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_amt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] clmtLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_curr_cd", length));
			String[] crtCsNo = (JSPUtil.getParameter(request, prefix	+ "crt_cs_no", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cgoClmStlLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_curr_cd", length));
			String[] ltgtCsDesc = (JSPUtil.getParameter(request, prefix	+ "ltgt_cs_desc", length));
			String[] clmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_usd_amt", length));
			String[] lablPtyRcvrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_curr_cd", length));
			String[] agnPtyNm = (JSPUtil.getParameter(request, prefix	+ "agn_pty_nm", length));
			String[] lablPtyFmalClmDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_fmal_clm_dt", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] clmtLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_amt", length));
			String[] lablPtyRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_usd_amt", length));
			String[] deDt = (JSPUtil.getParameter(request, prefix	+ "de_dt", length));
			String[] lablPtyDmndUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_usd_amt", length));
			String[] n1stPreTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ts_loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deftNm = (JSPUtil.getParameter(request, prefix	+ "deft_nm", length));
			String[] lablPtyDmndCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_curr_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] cgoClmStlRmk = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_rmk", length));
			String[] cgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_cd", length));
			String[] n1stPstTsDt = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ts_dt", length));
			String[] cgoClmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_usd_amt", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] lablPtyPtyNm = (JSPUtil.getParameter(request, prefix	+ "labl_pty_pty_nm", length));
			String[] lablPtyRcvrDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_dt", length));
			String[] lablPtyRcvrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_amt", length));
			String[] cgoClmStlDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_dt", length));
			String[] n1stPstTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ts_loc_cd", length));
			String[] dchgDt = (JSPUtil.getParameter(request, prefix	+ "dchg_dt", length));
			String[] ofrtTermMiscNm = (JSPUtil.getParameter(request, prefix	+ "ofrt_term_misc_nm", length));
			String[] crtNm = (JSPUtil.getParameter(request, prefix	+ "crt_nm", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] cgoClmRefCntrNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_cntr_no", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] lodgDt = (JSPUtil.getParameter(request, prefix	+ "lodg_dt", length));
			String[] curDt = (JSPUtil.getParameter(request, prefix	+ "cur_dt", length));
			String[] n1stPreRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ref_vvd_no", length));
			String[] rctDt = (JSPUtil.getParameter(request, prefix	+ "rct_dt", length));
			String[] cgoQltyDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_qlty_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new CargoLitigationReportVO();
				if (cgoClmStsDt[i] != null)
					model.setCgoClmStsDt(cgoClmStsDt[i]);
				if (insurPtyNm[i] != null)
					model.setInsurPtyNm(insurPtyNm[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (clmOfrtAmt[i] != null)
					model.setClmOfrtAmt(clmOfrtAmt[i]);
				if (smnsSveDt[i] != null)
					model.setSmnsSveDt(smnsSveDt[i]);
				if (n1stPstRefVvdNo[i] != null)
					model.setN1stPstRefVvdNo(n1stPstRefVvdNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lablPtyClmRmk[i] != null)
					model.setLablPtyClmRmk(lablPtyClmRmk[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (crrTermMiscNm[i] != null)
					model.setCrrTermMiscNm(crrTermMiscNm[i]);
				if (pltNm[i] != null)
					model.setPltNm(pltNm[i]);
				if (clmCuzDesc[i] != null)
					model.setClmCuzDesc(clmCuzDesc[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (lablPtyDmndAmt[i] != null)
					model.setLablPtyDmndAmt(lablPtyDmndAmt[i]);
				if (deftAttyPtyNm[i] != null)
					model.setDeftAttyPtyNm(deftAttyPtyNm[i]);
				if (cgoClmRefBlNo[i] != null)
					model.setCgoClmRefBlNo(cgoClmRefBlNo[i]);
				if (n1stPreTsDt[i] != null)
					model.setN1stPreTsDt(n1stPreTsDt[i]);
				if (cgoClmStlLoclAmt[i] != null)
					model.setCgoClmStlLoclAmt(cgoClmStlLoclAmt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (clmtLoclCurrCd[i] != null)
					model.setClmtLoclCurrCd(clmtLoclCurrCd[i]);
				if (crtCsNo[i] != null)
					model.setCrtCsNo(crtCsNo[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cgoClmStlLoclCurrCd[i] != null)
					model.setCgoClmStlLoclCurrCd(cgoClmStlLoclCurrCd[i]);
				if (ltgtCsDesc[i] != null)
					model.setLtgtCsDesc(ltgtCsDesc[i]);
				if (clmtUsdAmt[i] != null)
					model.setClmtUsdAmt(clmtUsdAmt[i]);
				if (lablPtyRcvrLoclCurrCd[i] != null)
					model.setLablPtyRcvrLoclCurrCd(lablPtyRcvrLoclCurrCd[i]);
				if (agnPtyNm[i] != null)
					model.setAgnPtyNm(agnPtyNm[i]);
				if (lablPtyFmalClmDt[i] != null)
					model.setLablPtyFmalClmDt(lablPtyFmalClmDt[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (clmtLoclAmt[i] != null)
					model.setClmtLoclAmt(clmtLoclAmt[i]);
				if (lablPtyRcvrUsdAmt[i] != null)
					model.setLablPtyRcvrUsdAmt(lablPtyRcvrUsdAmt[i]);
				if (deDt[i] != null)
					model.setDeDt(deDt[i]);
				if (lablPtyDmndUsdAmt[i] != null)
					model.setLablPtyDmndUsdAmt(lablPtyDmndUsdAmt[i]);
				if (n1stPreTsLocCd[i] != null)
					model.setN1stPreTsLocCd(n1stPreTsLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deftNm[i] != null)
					model.setDeftNm(deftNm[i]);
				if (lablPtyDmndCurrCd[i] != null)
					model.setLablPtyDmndCurrCd(lablPtyDmndCurrCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (cgoClmStlRmk[i] != null)
					model.setCgoClmStlRmk(cgoClmStlRmk[i]);
				if (cgoClmStsCd[i] != null)
					model.setCgoClmStsCd(cgoClmStsCd[i]);
				if (n1stPstTsDt[i] != null)
					model.setN1stPstTsDt(n1stPstTsDt[i]);
				if (cgoClmStlUsdAmt[i] != null)
					model.setCgoClmStlUsdAmt(cgoClmStlUsdAmt[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (lablPtyPtyNm[i] != null)
					model.setLablPtyPtyNm(lablPtyPtyNm[i]);
				if (lablPtyRcvrDt[i] != null)
					model.setLablPtyRcvrDt(lablPtyRcvrDt[i]);
				if (lablPtyRcvrLoclAmt[i] != null)
					model.setLablPtyRcvrLoclAmt(lablPtyRcvrLoclAmt[i]);
				if (cgoClmStlDt[i] != null)
					model.setCgoClmStlDt(cgoClmStlDt[i]);
				if (n1stPstTsLocCd[i] != null)
					model.setN1stPstTsLocCd(n1stPstTsLocCd[i]);
				if (dchgDt[i] != null)
					model.setDchgDt(dchgDt[i]);
				if (ofrtTermMiscNm[i] != null)
					model.setOfrtTermMiscNm(ofrtTermMiscNm[i]);
				if (crtNm[i] != null)
					model.setCrtNm(crtNm[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (cgoClmRefCntrNo[i] != null)
					model.setCgoClmRefCntrNo(cgoClmRefCntrNo[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (lodgDt[i] != null)
					model.setLodgDt(lodgDt[i]);
				if (curDt[i] != null)
					model.setCurDt(curDt[i]);
				if (n1stPreRefVvdNo[i] != null)
					model.setN1stPreRefVvdNo(n1stPreRefVvdNo[i]);
				if (rctDt[i] != null)
					model.setRctDt(rctDt[i]);
				if (cgoQltyDesc[i] != null)
					model.setCgoQltyDesc(cgoQltyDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCargoLitigationReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CargoLitigationReportVO[]
	 */
	public CargoLitigationReportVO[] getCargoLitigationReportVOs(){
		CargoLitigationReportVO[] vos = (CargoLitigationReportVO[])models.toArray(new CargoLitigationReportVO[models.size()]);
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
		this.cgoClmStsDt = this.cgoClmStsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPtyNm = this.insurPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmOfrtAmt = this.clmOfrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smnsSveDt = this.smnsSveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstRefVvdNo = this.n1stPstRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyClmRmk = this.lablPtyClmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrTermMiscNm = this.crrTermMiscNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltNm = this.pltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCuzDesc = this.clmCuzDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndAmt = this.lablPtyDmndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAttyPtyNm = this.deftAttyPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefBlNo = this.cgoClmRefBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreTsDt = this.n1stPreTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclAmt = this.cgoClmStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclCurrCd = this.clmtLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtCsNo = this.crtCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclCurrCd = this.cgoClmStlLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltgtCsDesc = this.ltgtCsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtUsdAmt = this.clmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclCurrCd = this.lablPtyRcvrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnPtyNm = this.agnPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFmalClmDt = this.lablPtyFmalClmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclAmt = this.clmtLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrUsdAmt = this.lablPtyRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDt = this.deDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndUsdAmt = this.lablPtyDmndUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreTsLocCd = this.n1stPreTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftNm = this.deftNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndCurrCd = this.lablPtyDmndCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlRmk = this.cgoClmStlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsCd = this.cgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstTsDt = this.n1stPstTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlUsdAmt = this.cgoClmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyPtyNm = this.lablPtyPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrDt = this.lablPtyRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclAmt = this.lablPtyRcvrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlDt = this.cgoClmStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstTsLocCd = this.n1stPstTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgDt = this.dchgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofrtTermMiscNm = this.ofrtTermMiscNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtNm = this.crtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefCntrNo = this.cgoClmRefCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgDt = this.lodgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curDt = this.curDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreRefVvdNo = this.n1stPreRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt = this.rctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoQltyDesc = this.cgoQltyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
