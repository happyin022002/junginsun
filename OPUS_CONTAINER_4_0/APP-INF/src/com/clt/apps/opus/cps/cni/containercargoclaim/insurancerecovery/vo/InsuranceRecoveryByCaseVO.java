/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InsuranceRecoveryByCaseVO.java
*@FileTitle : InsuranceRecoveryByCaseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 진윤오
*@LastVersion : 1.0
* 2010.04.08 진윤오 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.insurancerecovery.vo;

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
 * @author 진윤오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InsuranceRecoveryByCaseVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InsuranceRecoveryByCaseVO> models = new ArrayList<InsuranceRecoveryByCaseVO>();
	
	/* Column Info */
	private String cgoClmStlXchRt = null;
	/* Column Info */
	private String insurRcvrUsdAmt = null;
	/* Column Info */
	private String clmtLoclXchRt = null;
	/* Column Info */
	private String insurPtyNm = null;
	/* Column Info */
	private String cgoClmStsNm = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String clmtLoclAmt = null;
	/* Column Info */
	private String lablPtyRcvrUsdAmt = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String insurFmalClmDt = null;
	/* Column Info */
	private String clmCgoTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String insurClmPtyAbbrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String insurRmk = null;
	/* Column Info */
	private String cgoClmStsCd = null;
	/* Column Info */
	private String rcvrUsdAmt = null;
	/* Column Info */
	private String cgoClmStlUsdAmt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String prlmClmNtcDt = null;
	/* Column Info */
	private String lablPtyRcvrDt = null;
	/* Column Info */
	private String lablPtyRcvrLoclAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mjrClmDmgLssCd = null;
	/* Column Info */
	private String insurDmndUsdAmt = null;
	/* Column Info */
	private String nhp = null;
	/* Column Info */
	private String insurXchRt = null;
	/* Column Info */
	private String cgoClmStlLoclAmt = null;
	/* Column Info */
	private String cgoClmStlDt = null;
	/* Column Info */
	private String insurDmndCurrCd = null;
	/* Column Info */
	private String hpd = null;
	/* Column Info */
	private String clmtLoclCurrCd = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String cgoClmStlLoclCurrCd = null;
	/* Column Info */
	private String cgoClmStlTpCd = null;
	/* Column Info */
	private String minrClmDmgLssCd = null;
	/* Column Info */
	private String clmtUsdAmt = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String lablPtyRcvrLoclCurrCd = null;
	/* Column Info */
	private String insurRcvrDt = null;
	/* Column Info */
	private String cgoClmTpCd = null;
	/* Column Info */
	private String lablPtyRcvrLoclXchRt = null;
	/* Column Info */
	private String insurDmndAmt = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String clmAreaCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InsuranceRecoveryByCaseVO() {}

	public InsuranceRecoveryByCaseVO(String ibflag, String pagerows, String cgoClmNo, String clmAreaCd, String hdlrOfcCd, String hdlrUsrId, String updDt, String trnkRefVvdNo, String cgoClmStsNm, String cgoClmStsCd, String csClzDt, String hpd, String nhp, String cgoClmStlDt, String prlmClmNtcDt, String fmalClmRcvDt, String cgoClmStlTpCd, String cgoClmTpCd, String mjrClmDmgLssCd, String minrClmDmgLssCd, String inciPlcTpCd, String inciOccrDt, String clmCgoTpCd, String clmtLoclAmt, String clmtLoclCurrCd, String clmtLoclXchRt, String clmtUsdAmt, String insurClmPtyAbbrNm, String insurPtyNm, String insurClmPtyNo, String cgoClmStlLoclAmt, String cgoClmStlLoclCurrCd, String cgoClmStlXchRt, String cgoClmStlUsdAmt, String lablPtyRcvrLoclAmt, String lablPtyRcvrLoclCurrCd, String lablPtyRcvrDt, String lablPtyRcvrLoclXchRt, String lablPtyRcvrUsdAmt, String insurDmndAmt, String insurDmndCurrCd, String insurFmalClmDt, String insurXchRt, String insurDmndUsdAmt, String insurRcvrDt, String insurRcvrUsdAmt, String insurRmk, String rcvrUsdAmt) {
		this.cgoClmStlXchRt = cgoClmStlXchRt;
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
		this.clmtLoclXchRt = clmtLoclXchRt;
		this.insurPtyNm = insurPtyNm;
		this.cgoClmStsNm = cgoClmStsNm;
		this.csClzDt = csClzDt;
		this.clmtLoclAmt = clmtLoclAmt;
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.insurFmalClmDt = insurFmalClmDt;
		this.clmCgoTpCd = clmCgoTpCd;
		this.pagerows = pagerows;
		this.insurClmPtyAbbrNm = insurClmPtyAbbrNm;
		this.ibflag = ibflag;
		this.insurRmk = insurRmk;
		this.cgoClmStsCd = cgoClmStsCd;
		this.rcvrUsdAmt = rcvrUsdAmt;
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
		this.cgoClmNo = cgoClmNo;
		this.prlmClmNtcDt = prlmClmNtcDt;
		this.lablPtyRcvrDt = lablPtyRcvrDt;
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
		this.updDt = updDt;
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
		this.insurDmndUsdAmt = insurDmndUsdAmt;
		this.nhp = nhp;
		this.insurXchRt = insurXchRt;
		this.cgoClmStlLoclAmt = cgoClmStlLoclAmt;
		this.cgoClmStlDt = cgoClmStlDt;
		this.insurDmndCurrCd = insurDmndCurrCd;
		this.hpd = hpd;
		this.clmtLoclCurrCd = clmtLoclCurrCd;
		this.inciOccrDt = inciOccrDt;
		this.hdlrUsrId = hdlrUsrId;
		this.cgoClmStlLoclCurrCd = cgoClmStlLoclCurrCd;
		this.cgoClmStlTpCd = cgoClmStlTpCd;
		this.minrClmDmgLssCd = minrClmDmgLssCd;
		this.clmtUsdAmt = clmtUsdAmt;
		this.insurClmPtyNo = insurClmPtyNo;
		this.inciPlcTpCd = inciPlcTpCd;
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
		this.insurRcvrDt = insurRcvrDt;
		this.cgoClmTpCd = cgoClmTpCd;
		this.lablPtyRcvrLoclXchRt = lablPtyRcvrLoclXchRt;
		this.insurDmndAmt = insurDmndAmt;
		this.hdlrOfcCd = hdlrOfcCd;
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cgo_clm_stl_xch_rt", getCgoClmStlXchRt());
		this.hashColumns.put("insur_rcvr_usd_amt", getInsurRcvrUsdAmt());
		this.hashColumns.put("clmt_locl_xch_rt", getClmtLoclXchRt());
		this.hashColumns.put("insur_pty_nm", getInsurPtyNm());
		this.hashColumns.put("cgo_clm_sts_nm", getCgoClmStsNm());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("clmt_locl_amt", getClmtLoclAmt());
		this.hashColumns.put("labl_pty_rcvr_usd_amt", getLablPtyRcvrUsdAmt());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("insur_fmal_clm_dt", getInsurFmalClmDt());
		this.hashColumns.put("clm_cgo_tp_cd", getClmCgoTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("insur_clm_pty_abbr_nm", getInsurClmPtyAbbrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("insur_rmk", getInsurRmk());
		this.hashColumns.put("cgo_clm_sts_cd", getCgoClmStsCd());
		this.hashColumns.put("rcvr_usd_amt", getRcvrUsdAmt());
		this.hashColumns.put("cgo_clm_stl_usd_amt", getCgoClmStlUsdAmt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("prlm_clm_ntc_dt", getPrlmClmNtcDt());
		this.hashColumns.put("labl_pty_rcvr_dt", getLablPtyRcvrDt());
		this.hashColumns.put("labl_pty_rcvr_locl_amt", getLablPtyRcvrLoclAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mjr_clm_dmg_lss_cd", getMjrClmDmgLssCd());
		this.hashColumns.put("insur_dmnd_usd_amt", getInsurDmndUsdAmt());
		this.hashColumns.put("nhp", getNhp());
		this.hashColumns.put("insur_xch_rt", getInsurXchRt());
		this.hashColumns.put("cgo_clm_stl_locl_amt", getCgoClmStlLoclAmt());
		this.hashColumns.put("cgo_clm_stl_dt", getCgoClmStlDt());
		this.hashColumns.put("insur_dmnd_curr_cd", getInsurDmndCurrCd());
		this.hashColumns.put("hpd", getHpd());
		this.hashColumns.put("clmt_locl_curr_cd", getClmtLoclCurrCd());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("cgo_clm_stl_locl_curr_cd", getCgoClmStlLoclCurrCd());
		this.hashColumns.put("cgo_clm_stl_tp_cd", getCgoClmStlTpCd());
		this.hashColumns.put("minr_clm_dmg_lss_cd", getMinrClmDmgLssCd());
		this.hashColumns.put("clmt_usd_amt", getClmtUsdAmt());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("labl_pty_rcvr_locl_curr_cd", getLablPtyRcvrLoclCurrCd());
		this.hashColumns.put("insur_rcvr_dt", getInsurRcvrDt());
		this.hashColumns.put("cgo_clm_tp_cd", getCgoClmTpCd());
		this.hashColumns.put("labl_pty_rcvr_locl_xch_rt", getLablPtyRcvrLoclXchRt());
		this.hashColumns.put("insur_dmnd_amt", getInsurDmndAmt());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cgo_clm_stl_xch_rt", "cgoClmStlXchRt");
		this.hashFields.put("insur_rcvr_usd_amt", "insurRcvrUsdAmt");
		this.hashFields.put("clmt_locl_xch_rt", "clmtLoclXchRt");
		this.hashFields.put("insur_pty_nm", "insurPtyNm");
		this.hashFields.put("cgo_clm_sts_nm", "cgoClmStsNm");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("clmt_locl_amt", "clmtLoclAmt");
		this.hashFields.put("labl_pty_rcvr_usd_amt", "lablPtyRcvrUsdAmt");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("insur_fmal_clm_dt", "insurFmalClmDt");
		this.hashFields.put("clm_cgo_tp_cd", "clmCgoTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("insur_clm_pty_abbr_nm", "insurClmPtyAbbrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("insur_rmk", "insurRmk");
		this.hashFields.put("cgo_clm_sts_cd", "cgoClmStsCd");
		this.hashFields.put("rcvr_usd_amt", "rcvrUsdAmt");
		this.hashFields.put("cgo_clm_stl_usd_amt", "cgoClmStlUsdAmt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("prlm_clm_ntc_dt", "prlmClmNtcDt");
		this.hashFields.put("labl_pty_rcvr_dt", "lablPtyRcvrDt");
		this.hashFields.put("labl_pty_rcvr_locl_amt", "lablPtyRcvrLoclAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mjr_clm_dmg_lss_cd", "mjrClmDmgLssCd");
		this.hashFields.put("insur_dmnd_usd_amt", "insurDmndUsdAmt");
		this.hashFields.put("nhp", "nhp");
		this.hashFields.put("insur_xch_rt", "insurXchRt");
		this.hashFields.put("cgo_clm_stl_locl_amt", "cgoClmStlLoclAmt");
		this.hashFields.put("cgo_clm_stl_dt", "cgoClmStlDt");
		this.hashFields.put("insur_dmnd_curr_cd", "insurDmndCurrCd");
		this.hashFields.put("hpd", "hpd");
		this.hashFields.put("clmt_locl_curr_cd", "clmtLoclCurrCd");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("cgo_clm_stl_locl_curr_cd", "cgoClmStlLoclCurrCd");
		this.hashFields.put("cgo_clm_stl_tp_cd", "cgoClmStlTpCd");
		this.hashFields.put("minr_clm_dmg_lss_cd", "minrClmDmgLssCd");
		this.hashFields.put("clmt_usd_amt", "clmtUsdAmt");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("labl_pty_rcvr_locl_curr_cd", "lablPtyRcvrLoclCurrCd");
		this.hashFields.put("insur_rcvr_dt", "insurRcvrDt");
		this.hashFields.put("cgo_clm_tp_cd", "cgoClmTpCd");
		this.hashFields.put("labl_pty_rcvr_locl_xch_rt", "lablPtyRcvrLoclXchRt");
		this.hashFields.put("insur_dmnd_amt", "insurDmndAmt");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlXchRt
	 */
	public String getCgoClmStlXchRt() {
		return this.cgoClmStlXchRt;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrUsdAmt
	 */
	public String getInsurRcvrUsdAmt() {
		return this.insurRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return clmtLoclXchRt
	 */
	public String getClmtLoclXchRt() {
		return this.clmtLoclXchRt;
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
	 * @return cgoClmStsNm
	 */
	public String getCgoClmStsNm() {
		return this.cgoClmStsNm;
	}
	
	/**
	 * Column Info
	 * @return csClzDt
	 */
	public String getCsClzDt() {
		return this.csClzDt;
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
	 * @return trnkRefVvdNo
	 */
	public String getTrnkRefVvdNo() {
		return this.trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return fmalClmRcvDt
	 */
	public String getFmalClmRcvDt() {
		return this.fmalClmRcvDt;
	}
	
	/**
	 * Column Info
	 * @return insurFmalClmDt
	 */
	public String getInsurFmalClmDt() {
		return this.insurFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @return clmCgoTpCd
	 */
	public String getClmCgoTpCd() {
		return this.clmCgoTpCd;
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
	 * @return insurClmPtyAbbrNm
	 */
	public String getInsurClmPtyAbbrNm() {
		return this.insurClmPtyAbbrNm;
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
	 * @return insurRmk
	 */
	public String getInsurRmk() {
		return this.insurRmk;
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
	 * @return rcvrUsdAmt
	 */
	public String getRcvrUsdAmt() {
		return this.rcvrUsdAmt;
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
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return prlmClmNtcDt
	 */
	public String getPrlmClmNtcDt() {
		return this.prlmClmNtcDt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return mjrClmDmgLssCd
	 */
	public String getMjrClmDmgLssCd() {
		return this.mjrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @return insurDmndUsdAmt
	 */
	public String getInsurDmndUsdAmt() {
		return this.insurDmndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return nhp
	 */
	public String getNhp() {
		return this.nhp;
	}
	
	/**
	 * Column Info
	 * @return insurXchRt
	 */
	public String getInsurXchRt() {
		return this.insurXchRt;
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
	 * @return cgoClmStlDt
	 */
	public String getCgoClmStlDt() {
		return this.cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @return insurDmndCurrCd
	 */
	public String getInsurDmndCurrCd() {
		return this.insurDmndCurrCd;
	}
	
	/**
	 * Column Info
	 * @return hpd
	 */
	public String getHpd() {
		return this.hpd;
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
	 * @return inciOccrDt
	 */
	public String getInciOccrDt() {
		return this.inciOccrDt;
	}
	
	/**
	 * Column Info
	 * @return hdlrUsrId
	 */
	public String getHdlrUsrId() {
		return this.hdlrUsrId;
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
	 * @return cgoClmStlTpCd
	 */
	public String getCgoClmStlTpCd() {
		return this.cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @return minrClmDmgLssCd
	 */
	public String getMinrClmDmgLssCd() {
		return this.minrClmDmgLssCd;
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
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return inciPlcTpCd
	 */
	public String getInciPlcTpCd() {
		return this.inciPlcTpCd;
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
	 * @return insurRcvrDt
	 */
	public String getInsurRcvrDt() {
		return this.insurRcvrDt;
	}
	
	/**
	 * Column Info
	 * @return cgoClmTpCd
	 */
	public String getCgoClmTpCd() {
		return this.cgoClmTpCd;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrLoclXchRt
	 */
	public String getLablPtyRcvrLoclXchRt() {
		return this.lablPtyRcvrLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @return insurDmndAmt
	 */
	public String getInsurDmndAmt() {
		return this.insurDmndAmt;
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
	 * @return clmAreaCd
	 */
	public String getClmAreaCd() {
		return this.clmAreaCd;
	}
	

	/**
	 * Column Info
	 * @param cgoClmStlXchRt
	 */
	public void setCgoClmStlXchRt(String cgoClmStlXchRt) {
		this.cgoClmStlXchRt = cgoClmStlXchRt;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrUsdAmt
	 */
	public void setInsurRcvrUsdAmt(String insurRcvrUsdAmt) {
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param clmtLoclXchRt
	 */
	public void setClmtLoclXchRt(String clmtLoclXchRt) {
		this.clmtLoclXchRt = clmtLoclXchRt;
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
	 * @param cgoClmStsNm
	 */
	public void setCgoClmStsNm(String cgoClmStsNm) {
		this.cgoClmStsNm = cgoClmStsNm;
	}
	
	/**
	 * Column Info
	 * @param csClzDt
	 */
	public void setCsClzDt(String csClzDt) {
		this.csClzDt = csClzDt;
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
	 * @param trnkRefVvdNo
	 */
	public void setTrnkRefVvdNo(String trnkRefVvdNo) {
		this.trnkRefVvdNo = trnkRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param fmalClmRcvDt
	 */
	public void setFmalClmRcvDt(String fmalClmRcvDt) {
		this.fmalClmRcvDt = fmalClmRcvDt;
	}
	
	/**
	 * Column Info
	 * @param insurFmalClmDt
	 */
	public void setInsurFmalClmDt(String insurFmalClmDt) {
		this.insurFmalClmDt = insurFmalClmDt;
	}
	
	/**
	 * Column Info
	 * @param clmCgoTpCd
	 */
	public void setClmCgoTpCd(String clmCgoTpCd) {
		this.clmCgoTpCd = clmCgoTpCd;
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
	 * @param insurClmPtyAbbrNm
	 */
	public void setInsurClmPtyAbbrNm(String insurClmPtyAbbrNm) {
		this.insurClmPtyAbbrNm = insurClmPtyAbbrNm;
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
	 * @param insurRmk
	 */
	public void setInsurRmk(String insurRmk) {
		this.insurRmk = insurRmk;
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
	 * @param rcvrUsdAmt
	 */
	public void setRcvrUsdAmt(String rcvrUsdAmt) {
		this.rcvrUsdAmt = rcvrUsdAmt;
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
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param prlmClmNtcDt
	 */
	public void setPrlmClmNtcDt(String prlmClmNtcDt) {
		this.prlmClmNtcDt = prlmClmNtcDt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param mjrClmDmgLssCd
	 */
	public void setMjrClmDmgLssCd(String mjrClmDmgLssCd) {
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
	}
	
	/**
	 * Column Info
	 * @param insurDmndUsdAmt
	 */
	public void setInsurDmndUsdAmt(String insurDmndUsdAmt) {
		this.insurDmndUsdAmt = insurDmndUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param nhp
	 */
	public void setNhp(String nhp) {
		this.nhp = nhp;
	}
	
	/**
	 * Column Info
	 * @param insurXchRt
	 */
	public void setInsurXchRt(String insurXchRt) {
		this.insurXchRt = insurXchRt;
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
	 * @param cgoClmStlDt
	 */
	public void setCgoClmStlDt(String cgoClmStlDt) {
		this.cgoClmStlDt = cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @param insurDmndCurrCd
	 */
	public void setInsurDmndCurrCd(String insurDmndCurrCd) {
		this.insurDmndCurrCd = insurDmndCurrCd;
	}
	
	/**
	 * Column Info
	 * @param hpd
	 */
	public void setHpd(String hpd) {
		this.hpd = hpd;
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
	 * @param inciOccrDt
	 */
	public void setInciOccrDt(String inciOccrDt) {
		this.inciOccrDt = inciOccrDt;
	}
	
	/**
	 * Column Info
	 * @param hdlrUsrId
	 */
	public void setHdlrUsrId(String hdlrUsrId) {
		this.hdlrUsrId = hdlrUsrId;
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
	 * @param cgoClmStlTpCd
	 */
	public void setCgoClmStlTpCd(String cgoClmStlTpCd) {
		this.cgoClmStlTpCd = cgoClmStlTpCd;
	}
	
	/**
	 * Column Info
	 * @param minrClmDmgLssCd
	 */
	public void setMinrClmDmgLssCd(String minrClmDmgLssCd) {
		this.minrClmDmgLssCd = minrClmDmgLssCd;
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
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param inciPlcTpCd
	 */
	public void setInciPlcTpCd(String inciPlcTpCd) {
		this.inciPlcTpCd = inciPlcTpCd;
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
	 * @param insurRcvrDt
	 */
	public void setInsurRcvrDt(String insurRcvrDt) {
		this.insurRcvrDt = insurRcvrDt;
	}
	
	/**
	 * Column Info
	 * @param cgoClmTpCd
	 */
	public void setCgoClmTpCd(String cgoClmTpCd) {
		this.cgoClmTpCd = cgoClmTpCd;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrLoclXchRt
	 */
	public void setLablPtyRcvrLoclXchRt(String lablPtyRcvrLoclXchRt) {
		this.lablPtyRcvrLoclXchRt = lablPtyRcvrLoclXchRt;
	}
	
	/**
	 * Column Info
	 * @param insurDmndAmt
	 */
	public void setInsurDmndAmt(String insurDmndAmt) {
		this.insurDmndAmt = insurDmndAmt;
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
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
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
		setCgoClmStlXchRt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_xch_rt", ""));
		setInsurRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "insur_rcvr_usd_amt", ""));
		setClmtLoclXchRt(JSPUtil.getParameter(request, prefix + "clmt_locl_xch_rt", ""));
		setInsurPtyNm(JSPUtil.getParameter(request, prefix + "insur_pty_nm", ""));
		setCgoClmStsNm(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_nm", ""));
		setCsClzDt(JSPUtil.getParameter(request, prefix + "cs_clz_dt", ""));
		setClmtLoclAmt(JSPUtil.getParameter(request, prefix + "clmt_locl_amt", ""));
		setLablPtyRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_usd_amt", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, prefix + "trnk_ref_vvd_no", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_dt", ""));
		setInsurFmalClmDt(JSPUtil.getParameter(request, prefix + "insur_fmal_clm_dt", ""));
		setClmCgoTpCd(JSPUtil.getParameter(request, prefix + "clm_cgo_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInsurClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "insur_clm_pty_abbr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInsurRmk(JSPUtil.getParameter(request, prefix + "insur_rmk", ""));
		setCgoClmStsCd(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_cd", ""));
		setRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "rcvr_usd_amt", ""));
		setCgoClmStlUsdAmt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_usd_amt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setPrlmClmNtcDt(JSPUtil.getParameter(request, prefix + "prlm_clm_ntc_dt", ""));
		setLablPtyRcvrDt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_dt", ""));
		setLablPtyRcvrLoclAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setMjrClmDmgLssCd(JSPUtil.getParameter(request, prefix + "mjr_clm_dmg_lss_cd", ""));
		setInsurDmndUsdAmt(JSPUtil.getParameter(request, prefix + "insur_dmnd_usd_amt", ""));
		setNhp(JSPUtil.getParameter(request, prefix + "nhp", ""));
		setInsurXchRt(JSPUtil.getParameter(request, prefix + "insur_xch_rt", ""));
		setCgoClmStlLoclAmt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_locl_amt", ""));
		setCgoClmStlDt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_dt", ""));
		setInsurDmndCurrCd(JSPUtil.getParameter(request, prefix + "insur_dmnd_curr_cd", ""));
		setHpd(JSPUtil.getParameter(request, prefix + "hpd", ""));
		setClmtLoclCurrCd(JSPUtil.getParameter(request, prefix + "clmt_locl_curr_cd", ""));
		setInciOccrDt(JSPUtil.getParameter(request, prefix + "inci_occr_dt", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setCgoClmStlLoclCurrCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_locl_curr_cd", ""));
		setCgoClmStlTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_tp_cd", ""));
		setMinrClmDmgLssCd(JSPUtil.getParameter(request, prefix + "minr_clm_dmg_lss_cd", ""));
		setClmtUsdAmt(JSPUtil.getParameter(request, prefix + "clmt_usd_amt", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, prefix + "insur_clm_pty_no", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, prefix + "inci_plc_tp_cd", ""));
		setLablPtyRcvrLoclCurrCd(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_curr_cd", ""));
		setInsurRcvrDt(JSPUtil.getParameter(request, prefix + "insur_rcvr_dt", ""));
		setCgoClmTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_tp_cd", ""));
		setLablPtyRcvrLoclXchRt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_xch_rt", ""));
		setInsurDmndAmt(JSPUtil.getParameter(request, prefix + "insur_dmnd_amt", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setClmAreaCd(JSPUtil.getParameter(request, prefix + "clm_area_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InsuranceRecoveryByCaseVO[]
	 */
	public InsuranceRecoveryByCaseVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InsuranceRecoveryByCaseVO[]
	 */
	public InsuranceRecoveryByCaseVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InsuranceRecoveryByCaseVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cgoClmStlXchRt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_xch_rt", length));
			String[] insurRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_usd_amt", length));
			String[] clmtLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_xch_rt", length));
			String[] insurPtyNm = (JSPUtil.getParameter(request, prefix	+ "insur_pty_nm", length));
			String[] cgoClmStsNm = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_nm", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] clmtLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_amt", length));
			String[] lablPtyRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_usd_amt", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] insurFmalClmDt = (JSPUtil.getParameter(request, prefix	+ "insur_fmal_clm_dt", length));
			String[] clmCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_cgo_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] insurClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_abbr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] insurRmk = (JSPUtil.getParameter(request, prefix	+ "insur_rmk", length));
			String[] cgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_cd", length));
			String[] rcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "rcvr_usd_amt", length));
			String[] cgoClmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_usd_amt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] prlmClmNtcDt = (JSPUtil.getParameter(request, prefix	+ "prlm_clm_ntc_dt", length));
			String[] lablPtyRcvrDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_dt", length));
			String[] lablPtyRcvrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mjrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "mjr_clm_dmg_lss_cd", length));
			String[] insurDmndUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_dmnd_usd_amt", length));
			String[] nhp = (JSPUtil.getParameter(request, prefix	+ "nhp", length));
			String[] insurXchRt = (JSPUtil.getParameter(request, prefix	+ "insur_xch_rt", length));
			String[] cgoClmStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_amt", length));
			String[] cgoClmStlDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_dt", length));
			String[] insurDmndCurrCd = (JSPUtil.getParameter(request, prefix	+ "insur_dmnd_curr_cd", length));
			String[] hpd = (JSPUtil.getParameter(request, prefix	+ "hpd", length));
			String[] clmtLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_curr_cd", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] cgoClmStlLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_curr_cd", length));
			String[] cgoClmStlTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_tp_cd", length));
			String[] minrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "minr_clm_dmg_lss_cd", length));
			String[] clmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_usd_amt", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] lablPtyRcvrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_curr_cd", length));
			String[] insurRcvrDt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_dt", length));
			String[] cgoClmTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_tp_cd", length));
			String[] lablPtyRcvrLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_xch_rt", length));
			String[] insurDmndAmt = (JSPUtil.getParameter(request, prefix	+ "insur_dmnd_amt", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new InsuranceRecoveryByCaseVO();
				if (cgoClmStlXchRt[i] != null)
					model.setCgoClmStlXchRt(cgoClmStlXchRt[i]);
				if (insurRcvrUsdAmt[i] != null)
					model.setInsurRcvrUsdAmt(insurRcvrUsdAmt[i]);
				if (clmtLoclXchRt[i] != null)
					model.setClmtLoclXchRt(clmtLoclXchRt[i]);
				if (insurPtyNm[i] != null)
					model.setInsurPtyNm(insurPtyNm[i]);
				if (cgoClmStsNm[i] != null)
					model.setCgoClmStsNm(cgoClmStsNm[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (clmtLoclAmt[i] != null)
					model.setClmtLoclAmt(clmtLoclAmt[i]);
				if (lablPtyRcvrUsdAmt[i] != null)
					model.setLablPtyRcvrUsdAmt(lablPtyRcvrUsdAmt[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (insurFmalClmDt[i] != null)
					model.setInsurFmalClmDt(insurFmalClmDt[i]);
				if (clmCgoTpCd[i] != null)
					model.setClmCgoTpCd(clmCgoTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (insurClmPtyAbbrNm[i] != null)
					model.setInsurClmPtyAbbrNm(insurClmPtyAbbrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (insurRmk[i] != null)
					model.setInsurRmk(insurRmk[i]);
				if (cgoClmStsCd[i] != null)
					model.setCgoClmStsCd(cgoClmStsCd[i]);
				if (rcvrUsdAmt[i] != null)
					model.setRcvrUsdAmt(rcvrUsdAmt[i]);
				if (cgoClmStlUsdAmt[i] != null)
					model.setCgoClmStlUsdAmt(cgoClmStlUsdAmt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (prlmClmNtcDt[i] != null)
					model.setPrlmClmNtcDt(prlmClmNtcDt[i]);
				if (lablPtyRcvrDt[i] != null)
					model.setLablPtyRcvrDt(lablPtyRcvrDt[i]);
				if (lablPtyRcvrLoclAmt[i] != null)
					model.setLablPtyRcvrLoclAmt(lablPtyRcvrLoclAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mjrClmDmgLssCd[i] != null)
					model.setMjrClmDmgLssCd(mjrClmDmgLssCd[i]);
				if (insurDmndUsdAmt[i] != null)
					model.setInsurDmndUsdAmt(insurDmndUsdAmt[i]);
				if (nhp[i] != null)
					model.setNhp(nhp[i]);
				if (insurXchRt[i] != null)
					model.setInsurXchRt(insurXchRt[i]);
				if (cgoClmStlLoclAmt[i] != null)
					model.setCgoClmStlLoclAmt(cgoClmStlLoclAmt[i]);
				if (cgoClmStlDt[i] != null)
					model.setCgoClmStlDt(cgoClmStlDt[i]);
				if (insurDmndCurrCd[i] != null)
					model.setInsurDmndCurrCd(insurDmndCurrCd[i]);
				if (hpd[i] != null)
					model.setHpd(hpd[i]);
				if (clmtLoclCurrCd[i] != null)
					model.setClmtLoclCurrCd(clmtLoclCurrCd[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (cgoClmStlLoclCurrCd[i] != null)
					model.setCgoClmStlLoclCurrCd(cgoClmStlLoclCurrCd[i]);
				if (cgoClmStlTpCd[i] != null)
					model.setCgoClmStlTpCd(cgoClmStlTpCd[i]);
				if (minrClmDmgLssCd[i] != null)
					model.setMinrClmDmgLssCd(minrClmDmgLssCd[i]);
				if (clmtUsdAmt[i] != null)
					model.setClmtUsdAmt(clmtUsdAmt[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (lablPtyRcvrLoclCurrCd[i] != null)
					model.setLablPtyRcvrLoclCurrCd(lablPtyRcvrLoclCurrCd[i]);
				if (insurRcvrDt[i] != null)
					model.setInsurRcvrDt(insurRcvrDt[i]);
				if (cgoClmTpCd[i] != null)
					model.setCgoClmTpCd(cgoClmTpCd[i]);
				if (lablPtyRcvrLoclXchRt[i] != null)
					model.setLablPtyRcvrLoclXchRt(lablPtyRcvrLoclXchRt[i]);
				if (insurDmndAmt[i] != null)
					model.setInsurDmndAmt(insurDmndAmt[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInsuranceRecoveryByCaseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InsuranceRecoveryByCaseVO[]
	 */
	public InsuranceRecoveryByCaseVO[] getInsuranceRecoveryByCaseVOs(){
		InsuranceRecoveryByCaseVO[] vos = (InsuranceRecoveryByCaseVO[])models.toArray(new InsuranceRecoveryByCaseVO[models.size()]);
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
		this.cgoClmStlXchRt = this.cgoClmStlXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrUsdAmt = this.insurRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclXchRt = this.clmtLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurPtyNm = this.insurPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsNm = this.cgoClmStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclAmt = this.clmtLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrUsdAmt = this.lablPtyRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFmalClmDt = this.insurFmalClmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCgoTpCd = this.clmCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyAbbrNm = this.insurClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRmk = this.insurRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsCd = this.cgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrUsdAmt = this.rcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlUsdAmt = this.cgoClmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prlmClmNtcDt = this.prlmClmNtcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrDt = this.lablPtyRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclAmt = this.lablPtyRcvrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrClmDmgLssCd = this.mjrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurDmndUsdAmt = this.insurDmndUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nhp = this.nhp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurXchRt = this.insurXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclAmt = this.cgoClmStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlDt = this.cgoClmStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurDmndCurrCd = this.insurDmndCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hpd = this.hpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclCurrCd = this.clmtLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclCurrCd = this.cgoClmStlLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlTpCd = this.cgoClmStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minrClmDmgLssCd = this.minrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtUsdAmt = this.clmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclCurrCd = this.lablPtyRcvrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrDt = this.insurRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmTpCd = this.cgoClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclXchRt = this.lablPtyRcvrLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurDmndAmt = this.insurDmndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
