/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SettlementVO.java
*@FileTitle : SettlementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2010.03.03 박제성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.settlementclaim.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박제성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SettlementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SettlementVO> models = new ArrayList<SettlementVO>();
	
	/* Column Info */
	private String insurRcvrUsdAmt = null;
	/* Column Info */
	private String smnsSveDt = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String clmCgoTpCd = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Column Info */
	private String cgoClmStlDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lablPtyPrlmClmNtfyDt = null;
	/* Column Info */
	private String clmStlAuthCdNm = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String lablPtyDmndAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mjrClmDmgLssCd = null;
	/* Column Info */
	private String nhp = null;
	/* Column Info */
	private String cgoClmStlLoclAmt = null;
	/* Column Info */
	private String lablPtyXchRt = null;
	/* Column Info */
	private String clmStlAuthNo = null;
	/* Column Info */
	private String clmtLoclCurrCd = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Column Info */
	private String hpc = null;
	/* Column Info */
	private String clmStlAuthRmk = null;
	/* Column Info */
	private String clmMiscNm = null;
	/* Column Info */
	private String cgoClmStlLoclCurrCd = null;
	/* Column Info */
	private String clmPtyNo = null;
	/* Column Info */
	private String cgoClmStlTpCd = null;
	/* Column Info */
	private String clmStlAuthCd = null;
	/* Column Info */
	private String clmTmBarDt = null;
	/* Column Info */
	private String n3rdLablPtyCd = null;
	/* Column Info */
	private String clmStlAuthOfcCd = null;
	/* Column Info */
	private String clmtUsdAmt = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String crmVocNo = null;
	/* Column Info */
	private String clmStlApplDt = null;
	/* Column Info */
	private String lablPtyRcvrLoclCurrCd = null;
	/* Column Info */
	private String cgoClmTpCd = null;
	/* Column Info */
	private String lablPtyFmalClmDt = null;
	/* Column Info */
	private String lablPtyRcvrLoclXchRt = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String clmMiscCd = null;
	/* Column Info */
	private String cgoClmStlXchRt = null;
	/* Column Info */
	private String clmtLoclXchRt = null;
	/* Column Info */
	private String clmtLoclAmt = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String lablPtyRcvrUsdAmt = null;
	/* Column Info */
	private String ptyNm = null;
	/* Column Info */
	private String lablPtyDmndUsdAmt = null;
	/* Column Info */
	private String clmStlApplOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lablPtyDmndCurrCd = null;
	/* Column Info */
	private String clmStlAuthDt = null;
	/* Column Info */
	private String cgoClmStlRmk = null;
	/* Column Info */
	private String cgoClmStlUsdAmt = null;
	/* Column Info */
	private String clmPtyAbbrNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lablPtyRcvrLoclAmt = null;
	/* Column Info */
	private String lablPtyRcvrDt = null;
	/* Column Info */
	private String cgoClmStlDt = null;
	/* Column Info */
	private String clmStlAuthUsrId = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String tmBarDt = null;
	/* Column Info */
	private String clmStlApplUsrId = null;
	/* Column Info */
	private String cgoClmInciNo = null;
	/* Column Info */
	private String clmAreaCd = null;
	/* Column Info */
	private String cgoQltyDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SettlementVO() {}

	public SettlementVO(String ibflag, String pagerows, String cgoClmNo, String clmAreaCd, String hdlrOfcCd, String hdlrUsrId, String updDt, String cgoClmInciNo, String crmVocNo, String clmMiscCd, String clmMiscNm, String hpc, String nhp, String csClzDt, String clmTmBarDt, String smnsSveDt, String cgoClmTpCd, String mjrClmDmgLssCd, String n3rdLablPtyCd, String inciPlcTpCd, String inciOccrDt, String clmCgoTpCd, String cgoQltyDesc, String cgoClmStlTpCd, String clmtLoclAmt, String clmtLoclCurrCd, String fmalClmRcvDt, String clmtLoclXchRt, String clmtUsdAmt, String cgoClmStlLoclAmt, String cgoClmStlLoclCurrCd, String cgoClmStlDt, String cgoClmStlXchRt, String cgoClmStlUsdAmt, String clmPtyNo, String clmPtyAbbrNm, String ptyNm, String hndlOfcCd, String lablPtyPrlmClmNtfyDt, String tmBarDt, String lablPtyDmndAmt, String lablPtyDmndCurrCd, String lablPtyFmalClmDt, String lablPtyXchRt, String lablPtyDmndUsdAmt, String lablPtyRcvrLoclAmt, String lablPtyRcvrLoclCurrCd, String lablPtyRcvrDt, String lablPtyRcvrLoclXchRt, String lablPtyRcvrUsdAmt, String cgoClmStlRmk, String updUsrId, String cgoClmStlDesc, String clmStlAuthCd, String clmStlAuthCdNm, String clmStlAuthNo, String clmStlAuthRmk, String clmStlApplDt, String clmStlApplUsrId, String clmStlApplOfcCd, String clmStlAuthDt, String clmStlAuthUsrId, String clmStlAuthOfcCd, String insurRcvrUsdAmt) {
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
		this.smnsSveDt = smnsSveDt;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.clmCgoTpCd = clmCgoTpCd;
		this.hndlOfcCd = hndlOfcCd;
		this.cgoClmStlDesc = cgoClmStlDesc;
		this.pagerows = pagerows;
		this.lablPtyPrlmClmNtfyDt = lablPtyPrlmClmNtfyDt;
		this.clmStlAuthCdNm = clmStlAuthCdNm;
		this.cgoClmNo = cgoClmNo;
		this.lablPtyDmndAmt = lablPtyDmndAmt;
		this.updUsrId = updUsrId;
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
		this.nhp = nhp;
		this.cgoClmStlLoclAmt = cgoClmStlLoclAmt;
		this.lablPtyXchRt = lablPtyXchRt;
		this.clmStlAuthNo = clmStlAuthNo;
		this.clmtLoclCurrCd = clmtLoclCurrCd;
		this.inciOccrDt = inciOccrDt;
		this.hpc = hpc;
		this.clmStlAuthRmk = clmStlAuthRmk;
		this.clmMiscNm = clmMiscNm;
		this.cgoClmStlLoclCurrCd = cgoClmStlLoclCurrCd;
		this.clmPtyNo = clmPtyNo;
		this.cgoClmStlTpCd = cgoClmStlTpCd;
		this.clmStlAuthCd = clmStlAuthCd;
		this.clmTmBarDt = clmTmBarDt;
		this.n3rdLablPtyCd = n3rdLablPtyCd;
		this.clmStlAuthOfcCd = clmStlAuthOfcCd;
		this.clmtUsdAmt = clmtUsdAmt;
		this.inciPlcTpCd = inciPlcTpCd;
		this.crmVocNo = crmVocNo;
		this.clmStlApplDt = clmStlApplDt;
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
		this.cgoClmTpCd = cgoClmTpCd;
		this.lablPtyFmalClmDt = lablPtyFmalClmDt;
		this.lablPtyRcvrLoclXchRt = lablPtyRcvrLoclXchRt;
		this.hdlrOfcCd = hdlrOfcCd;
		this.clmMiscCd = clmMiscCd;
		this.cgoClmStlXchRt = cgoClmStlXchRt;
		this.clmtLoclXchRt = clmtLoclXchRt;
		this.clmtLoclAmt = clmtLoclAmt;
		this.csClzDt = csClzDt;
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
		this.ptyNm = ptyNm;
		this.lablPtyDmndUsdAmt = lablPtyDmndUsdAmt;
		this.clmStlApplOfcCd = clmStlApplOfcCd;
		this.ibflag = ibflag;
		this.lablPtyDmndCurrCd = lablPtyDmndCurrCd;
		this.clmStlAuthDt = clmStlAuthDt;
		this.cgoClmStlRmk = cgoClmStlRmk;
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
		this.clmPtyAbbrNm = clmPtyAbbrNm;
		this.updDt = updDt;
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
		this.lablPtyRcvrDt = lablPtyRcvrDt;
		this.cgoClmStlDt = cgoClmStlDt;
		this.clmStlAuthUsrId = clmStlAuthUsrId;
		this.hdlrUsrId = hdlrUsrId;
		this.tmBarDt = tmBarDt;
		this.clmStlApplUsrId = clmStlApplUsrId;
		this.cgoClmInciNo = cgoClmInciNo;
		this.clmAreaCd = clmAreaCd;
		this.cgoQltyDesc = cgoQltyDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("insur_rcvr_usd_amt", getInsurRcvrUsdAmt());
		this.hashColumns.put("smns_sve_dt", getSmnsSveDt());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("clm_cgo_tp_cd", getClmCgoTpCd());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("cgo_clm_stl_desc", getCgoClmStlDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("labl_pty_prlm_clm_ntfy_dt", getLablPtyPrlmClmNtfyDt());
		this.hashColumns.put("clm_stl_auth_cd_nm", getClmStlAuthCdNm());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("labl_pty_dmnd_amt", getLablPtyDmndAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mjr_clm_dmg_lss_cd", getMjrClmDmgLssCd());
		this.hashColumns.put("nhp", getNhp());
		this.hashColumns.put("cgo_clm_stl_locl_amt", getCgoClmStlLoclAmt());
		this.hashColumns.put("labl_pty_xch_rt", getLablPtyXchRt());
		this.hashColumns.put("clm_stl_auth_no", getClmStlAuthNo());
		this.hashColumns.put("clmt_locl_curr_cd", getClmtLoclCurrCd());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("hpc", getHpc());
		this.hashColumns.put("clm_stl_auth_rmk", getClmStlAuthRmk());
		this.hashColumns.put("clm_misc_nm", getClmMiscNm());
		this.hashColumns.put("cgo_clm_stl_locl_curr_cd", getCgoClmStlLoclCurrCd());
		this.hashColumns.put("clm_pty_no", getClmPtyNo());
		this.hashColumns.put("cgo_clm_stl_tp_cd", getCgoClmStlTpCd());
		this.hashColumns.put("clm_stl_auth_cd", getClmStlAuthCd());
		this.hashColumns.put("clm_tm_bar_dt", getClmTmBarDt());
		this.hashColumns.put("n3rd_labl_pty_cd", getN3rdLablPtyCd());
		this.hashColumns.put("clm_stl_auth_ofc_cd", getClmStlAuthOfcCd());
		this.hashColumns.put("clmt_usd_amt", getClmtUsdAmt());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("crm_voc_no", getCrmVocNo());
		this.hashColumns.put("clm_stl_appl_dt", getClmStlApplDt());
		this.hashColumns.put("labl_pty_rcvr_locl_curr_cd", getLablPtyRcvrLoclCurrCd());
		this.hashColumns.put("cgo_clm_tp_cd", getCgoClmTpCd());
		this.hashColumns.put("labl_pty_fmal_clm_dt", getLablPtyFmalClmDt());
		this.hashColumns.put("labl_pty_rcvr_locl_xch_rt", getLablPtyRcvrLoclXchRt());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("clm_misc_cd", getClmMiscCd());
		this.hashColumns.put("cgo_clm_stl_xch_rt", getCgoClmStlXchRt());
		this.hashColumns.put("clmt_locl_xch_rt", getClmtLoclXchRt());
		this.hashColumns.put("clmt_locl_amt", getClmtLoclAmt());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("labl_pty_rcvr_usd_amt", getLablPtyRcvrUsdAmt());
		this.hashColumns.put("pty_nm", getPtyNm());
		this.hashColumns.put("labl_pty_dmnd_usd_amt", getLablPtyDmndUsdAmt());
		this.hashColumns.put("clm_stl_appl_ofc_cd", getClmStlApplOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("labl_pty_dmnd_curr_cd", getLablPtyDmndCurrCd());
		this.hashColumns.put("clm_stl_auth_dt", getClmStlAuthDt());
		this.hashColumns.put("cgo_clm_stl_rmk", getCgoClmStlRmk());
		this.hashColumns.put("cgo_clm_stl_usd_amt", getCgoClmStlUsdAmt());
		this.hashColumns.put("clm_pty_abbr_nm", getClmPtyAbbrNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("labl_pty_rcvr_locl_amt", getLablPtyRcvrLoclAmt());
		this.hashColumns.put("labl_pty_rcvr_dt", getLablPtyRcvrDt());
		this.hashColumns.put("cgo_clm_stl_dt", getCgoClmStlDt());
		this.hashColumns.put("clm_stl_auth_usr_id", getClmStlAuthUsrId());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("tm_bar_dt", getTmBarDt());
		this.hashColumns.put("clm_stl_appl_usr_id", getClmStlApplUsrId());
		this.hashColumns.put("cgo_clm_inci_no", getCgoClmInciNo());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		this.hashColumns.put("cgo_qlty_desc", getCgoQltyDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("insur_rcvr_usd_amt", "insurRcvrUsdAmt");
		this.hashFields.put("smns_sve_dt", "smnsSveDt");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("clm_cgo_tp_cd", "clmCgoTpCd");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("cgo_clm_stl_desc", "cgoClmStlDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("labl_pty_prlm_clm_ntfy_dt", "lablPtyPrlmClmNtfyDt");
		this.hashFields.put("clm_stl_auth_cd_nm", "clmStlAuthCdNm");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("labl_pty_dmnd_amt", "lablPtyDmndAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mjr_clm_dmg_lss_cd", "mjrClmDmgLssCd");
		this.hashFields.put("nhp", "nhp");
		this.hashFields.put("cgo_clm_stl_locl_amt", "cgoClmStlLoclAmt");
		this.hashFields.put("labl_pty_xch_rt", "lablPtyXchRt");
		this.hashFields.put("clm_stl_auth_no", "clmStlAuthNo");
		this.hashFields.put("clmt_locl_curr_cd", "clmtLoclCurrCd");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("hpc", "hpc");
		this.hashFields.put("clm_stl_auth_rmk", "clmStlAuthRmk");
		this.hashFields.put("clm_misc_nm", "clmMiscNm");
		this.hashFields.put("cgo_clm_stl_locl_curr_cd", "cgoClmStlLoclCurrCd");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("cgo_clm_stl_tp_cd", "cgoClmStlTpCd");
		this.hashFields.put("clm_stl_auth_cd", "clmStlAuthCd");
		this.hashFields.put("clm_tm_bar_dt", "clmTmBarDt");
		this.hashFields.put("n3rd_labl_pty_cd", "n3rdLablPtyCd");
		this.hashFields.put("clm_stl_auth_ofc_cd", "clmStlAuthOfcCd");
		this.hashFields.put("clmt_usd_amt", "clmtUsdAmt");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("crm_voc_no", "crmVocNo");
		this.hashFields.put("clm_stl_appl_dt", "clmStlApplDt");
		this.hashFields.put("labl_pty_rcvr_locl_curr_cd", "lablPtyRcvrLoclCurrCd");
		this.hashFields.put("cgo_clm_tp_cd", "cgoClmTpCd");
		this.hashFields.put("labl_pty_fmal_clm_dt", "lablPtyFmalClmDt");
		this.hashFields.put("labl_pty_rcvr_locl_xch_rt", "lablPtyRcvrLoclXchRt");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("clm_misc_cd", "clmMiscCd");
		this.hashFields.put("cgo_clm_stl_xch_rt", "cgoClmStlXchRt");
		this.hashFields.put("clmt_locl_xch_rt", "clmtLoclXchRt");
		this.hashFields.put("clmt_locl_amt", "clmtLoclAmt");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("labl_pty_rcvr_usd_amt", "lablPtyRcvrUsdAmt");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("labl_pty_dmnd_usd_amt", "lablPtyDmndUsdAmt");
		this.hashFields.put("clm_stl_appl_ofc_cd", "clmStlApplOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("labl_pty_dmnd_curr_cd", "lablPtyDmndCurrCd");
		this.hashFields.put("clm_stl_auth_dt", "clmStlAuthDt");
		this.hashFields.put("cgo_clm_stl_rmk", "cgoClmStlRmk");
		this.hashFields.put("cgo_clm_stl_usd_amt", "cgoClmStlUsdAmt");
		this.hashFields.put("clm_pty_abbr_nm", "clmPtyAbbrNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("labl_pty_rcvr_locl_amt", "lablPtyRcvrLoclAmt");
		this.hashFields.put("labl_pty_rcvr_dt", "lablPtyRcvrDt");
		this.hashFields.put("cgo_clm_stl_dt", "cgoClmStlDt");
		this.hashFields.put("clm_stl_auth_usr_id", "clmStlAuthUsrId");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("tm_bar_dt", "tmBarDt");
		this.hashFields.put("clm_stl_appl_usr_id", "clmStlApplUsrId");
		this.hashFields.put("cgo_clm_inci_no", "cgoClmInciNo");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		this.hashFields.put("cgo_qlty_desc", "cgoQltyDesc");
		return this.hashFields;
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
	 * @return smnsSveDt
	 */
	public String getSmnsSveDt() {
		return this.smnsSveDt;
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
	 * @return clmCgoTpCd
	 */
	public String getClmCgoTpCd() {
		return this.clmCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return hndlOfcCd
	 */
	public String getHndlOfcCd() {
		return this.hndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cgoClmStlDesc
	 */
	public String getCgoClmStlDesc() {
		return this.cgoClmStlDesc;
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
	 * @return lablPtyPrlmClmNtfyDt
	 */
	public String getLablPtyPrlmClmNtfyDt() {
		return this.lablPtyPrlmClmNtfyDt;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthCdNm
	 */
	public String getClmStlAuthCdNm() {
		return this.clmStlAuthCdNm;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return nhp
	 */
	public String getNhp() {
		return this.nhp;
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
	 * @return lablPtyXchRt
	 */
	public String getLablPtyXchRt() {
		return this.lablPtyXchRt;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthNo
	 */
	public String getClmStlAuthNo() {
		return this.clmStlAuthNo;
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
	 * @return hpc
	 */
	public String getHpc() {
		return this.hpc;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthRmk
	 */
	public String getClmStlAuthRmk() {
		return this.clmStlAuthRmk;
	}
	
	/**
	 * Column Info
	 * @return clmMiscNm
	 */
	public String getClmMiscNm() {
		return this.clmMiscNm;
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
	 * @return clmPtyNo
	 */
	public String getClmPtyNo() {
		return this.clmPtyNo;
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
	 * @return clmStlAuthCd
	 */
	public String getClmStlAuthCd() {
		return this.clmStlAuthCd;
	}
	
	/**
	 * Column Info
	 * @return clmTmBarDt
	 */
	public String getClmTmBarDt() {
		return this.clmTmBarDt;
	}
	
	/**
	 * Column Info
	 * @return n3rdLablPtyCd
	 */
	public String getN3rdLablPtyCd() {
		return this.n3rdLablPtyCd;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthOfcCd
	 */
	public String getClmStlAuthOfcCd() {
		return this.clmStlAuthOfcCd;
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
	 * @return inciPlcTpCd
	 */
	public String getInciPlcTpCd() {
		return this.inciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @return crmVocNo
	 */
	public String getCrmVocNo() {
		return this.crmVocNo;
	}
	
	/**
	 * Column Info
	 * @return clmStlApplDt
	 */
	public String getClmStlApplDt() {
		return this.clmStlApplDt;
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
	 * @return cgoClmTpCd
	 */
	public String getCgoClmTpCd() {
		return this.cgoClmTpCd;
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
	 * @return lablPtyRcvrLoclXchRt
	 */
	public String getLablPtyRcvrLoclXchRt() {
		return this.lablPtyRcvrLoclXchRt;
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
	 * @return clmMiscCd
	 */
	public String getClmMiscCd() {
		return this.clmMiscCd;
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
	 * @return clmtLoclXchRt
	 */
	public String getClmtLoclXchRt() {
		return this.clmtLoclXchRt;
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
	 * @return csClzDt
	 */
	public String getCsClzDt() {
		return this.csClzDt;
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
	 * @return ptyNm
	 */
	public String getPtyNm() {
		return this.ptyNm;
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
	 * @return clmStlApplOfcCd
	 */
	public String getClmStlApplOfcCd() {
		return this.clmStlApplOfcCd;
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
	 * @return lablPtyDmndCurrCd
	 */
	public String getLablPtyDmndCurrCd() {
		return this.lablPtyDmndCurrCd;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthDt
	 */
	public String getClmStlAuthDt() {
		return this.clmStlAuthDt;
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
	 * @return cgoClmStlUsdAmt
	 */
	public String getCgoClmStlUsdAmt() {
		return this.cgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return clmPtyAbbrNm
	 */
	public String getClmPtyAbbrNm() {
		return this.clmPtyAbbrNm;
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
	 * @return lablPtyRcvrLoclAmt
	 */
	public String getLablPtyRcvrLoclAmt() {
		return this.lablPtyRcvrLoclAmt;
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
	 * @return cgoClmStlDt
	 */
	public String getCgoClmStlDt() {
		return this.cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @return clmStlAuthUsrId
	 */
	public String getClmStlAuthUsrId() {
		return this.clmStlAuthUsrId;
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
	 * @return tmBarDt
	 */
	public String getTmBarDt() {
		return this.tmBarDt;
	}
	
	/**
	 * Column Info
	 * @return clmStlApplUsrId
	 */
	public String getClmStlApplUsrId() {
		return this.clmStlApplUsrId;
	}
	
	/**
	 * Column Info
	 * @return cgoClmInciNo
	 */
	public String getCgoClmInciNo() {
		return this.cgoClmInciNo;
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
	 * @return cgoQltyDesc
	 */
	public String getCgoQltyDesc() {
		return this.cgoQltyDesc;
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
	 * @param smnsSveDt
	 */
	public void setSmnsSveDt(String smnsSveDt) {
		this.smnsSveDt = smnsSveDt;
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
	 * @param clmCgoTpCd
	 */
	public void setClmCgoTpCd(String clmCgoTpCd) {
		this.clmCgoTpCd = clmCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param hndlOfcCd
	 */
	public void setHndlOfcCd(String hndlOfcCd) {
		this.hndlOfcCd = hndlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmStlDesc
	 */
	public void setCgoClmStlDesc(String cgoClmStlDesc) {
		this.cgoClmStlDesc = cgoClmStlDesc;
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
	 * @param lablPtyPrlmClmNtfyDt
	 */
	public void setLablPtyPrlmClmNtfyDt(String lablPtyPrlmClmNtfyDt) {
		this.lablPtyPrlmClmNtfyDt = lablPtyPrlmClmNtfyDt;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthCdNm
	 */
	public void setClmStlAuthCdNm(String clmStlAuthCdNm) {
		this.clmStlAuthCdNm = clmStlAuthCdNm;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param nhp
	 */
	public void setNhp(String nhp) {
		this.nhp = nhp;
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
	 * @param lablPtyXchRt
	 */
	public void setLablPtyXchRt(String lablPtyXchRt) {
		this.lablPtyXchRt = lablPtyXchRt;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthNo
	 */
	public void setClmStlAuthNo(String clmStlAuthNo) {
		this.clmStlAuthNo = clmStlAuthNo;
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
	 * @param hpc
	 */
	public void setHpc(String hpc) {
		this.hpc = hpc;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthRmk
	 */
	public void setClmStlAuthRmk(String clmStlAuthRmk) {
		this.clmStlAuthRmk = clmStlAuthRmk;
	}
	
	/**
	 * Column Info
	 * @param clmMiscNm
	 */
	public void setClmMiscNm(String clmMiscNm) {
		this.clmMiscNm = clmMiscNm;
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
	 * @param clmPtyNo
	 */
	public void setClmPtyNo(String clmPtyNo) {
		this.clmPtyNo = clmPtyNo;
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
	 * @param clmStlAuthCd
	 */
	public void setClmStlAuthCd(String clmStlAuthCd) {
		this.clmStlAuthCd = clmStlAuthCd;
	}
	
	/**
	 * Column Info
	 * @param clmTmBarDt
	 */
	public void setClmTmBarDt(String clmTmBarDt) {
		this.clmTmBarDt = clmTmBarDt;
	}
	
	/**
	 * Column Info
	 * @param n3rdLablPtyCd
	 */
	public void setN3rdLablPtyCd(String n3rdLablPtyCd) {
		this.n3rdLablPtyCd = n3rdLablPtyCd;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthOfcCd
	 */
	public void setClmStlAuthOfcCd(String clmStlAuthOfcCd) {
		this.clmStlAuthOfcCd = clmStlAuthOfcCd;
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
	 * @param inciPlcTpCd
	 */
	public void setInciPlcTpCd(String inciPlcTpCd) {
		this.inciPlcTpCd = inciPlcTpCd;
	}
	
	/**
	 * Column Info
	 * @param crmVocNo
	 */
	public void setCrmVocNo(String crmVocNo) {
		this.crmVocNo = crmVocNo;
	}
	
	/**
	 * Column Info
	 * @param clmStlApplDt
	 */
	public void setClmStlApplDt(String clmStlApplDt) {
		this.clmStlApplDt = clmStlApplDt;
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
	 * @param cgoClmTpCd
	 */
	public void setCgoClmTpCd(String cgoClmTpCd) {
		this.cgoClmTpCd = cgoClmTpCd;
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
	 * @param lablPtyRcvrLoclXchRt
	 */
	public void setLablPtyRcvrLoclXchRt(String lablPtyRcvrLoclXchRt) {
		this.lablPtyRcvrLoclXchRt = lablPtyRcvrLoclXchRt;
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
	 * @param clmMiscCd
	 */
	public void setClmMiscCd(String clmMiscCd) {
		this.clmMiscCd = clmMiscCd;
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
	 * @param clmtLoclXchRt
	 */
	public void setClmtLoclXchRt(String clmtLoclXchRt) {
		this.clmtLoclXchRt = clmtLoclXchRt;
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
	 * @param csClzDt
	 */
	public void setCsClzDt(String csClzDt) {
		this.csClzDt = csClzDt;
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
	 * @param ptyNm
	 */
	public void setPtyNm(String ptyNm) {
		this.ptyNm = ptyNm;
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
	 * @param clmStlApplOfcCd
	 */
	public void setClmStlApplOfcCd(String clmStlApplOfcCd) {
		this.clmStlApplOfcCd = clmStlApplOfcCd;
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
	 * @param lablPtyDmndCurrCd
	 */
	public void setLablPtyDmndCurrCd(String lablPtyDmndCurrCd) {
		this.lablPtyDmndCurrCd = lablPtyDmndCurrCd;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthDt
	 */
	public void setClmStlAuthDt(String clmStlAuthDt) {
		this.clmStlAuthDt = clmStlAuthDt;
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
	 * @param cgoClmStlUsdAmt
	 */
	public void setCgoClmStlUsdAmt(String cgoClmStlUsdAmt) {
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param clmPtyAbbrNm
	 */
	public void setClmPtyAbbrNm(String clmPtyAbbrNm) {
		this.clmPtyAbbrNm = clmPtyAbbrNm;
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
	 * @param lablPtyRcvrLoclAmt
	 */
	public void setLablPtyRcvrLoclAmt(String lablPtyRcvrLoclAmt) {
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
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
	 * @param cgoClmStlDt
	 */
	public void setCgoClmStlDt(String cgoClmStlDt) {
		this.cgoClmStlDt = cgoClmStlDt;
	}
	
	/**
	 * Column Info
	 * @param clmStlAuthUsrId
	 */
	public void setClmStlAuthUsrId(String clmStlAuthUsrId) {
		this.clmStlAuthUsrId = clmStlAuthUsrId;
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
	 * @param tmBarDt
	 */
	public void setTmBarDt(String tmBarDt) {
		this.tmBarDt = tmBarDt;
	}
	
	/**
	 * Column Info
	 * @param clmStlApplUsrId
	 */
	public void setClmStlApplUsrId(String clmStlApplUsrId) {
		this.clmStlApplUsrId = clmStlApplUsrId;
	}
	
	/**
	 * Column Info
	 * @param cgoClmInciNo
	 */
	public void setCgoClmInciNo(String cgoClmInciNo) {
		this.cgoClmInciNo = cgoClmInciNo;
	}
	
	/**
	 * Column Info
	 * @param clmAreaCd
	 */
	public void setClmAreaCd(String clmAreaCd) {
		this.clmAreaCd = clmAreaCd;
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
		setInsurRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "insur_rcvr_usd_amt", ""));
		setSmnsSveDt(JSPUtil.getParameter(request, prefix + "smns_sve_dt", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_dt", ""));
		setClmCgoTpCd(JSPUtil.getParameter(request, prefix + "clm_cgo_tp_cd", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, prefix + "hndl_ofc_cd", ""));
		setCgoClmStlDesc(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLablPtyPrlmClmNtfyDt(JSPUtil.getParameter(request, prefix + "labl_pty_prlm_clm_ntfy_dt", ""));
		setClmStlAuthCdNm(JSPUtil.getParameter(request, prefix + "clm_stl_auth_cd_nm", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setLablPtyDmndAmt(JSPUtil.getParameter(request, prefix + "labl_pty_dmnd_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setMjrClmDmgLssCd(JSPUtil.getParameter(request, prefix + "mjr_clm_dmg_lss_cd", ""));
		setNhp(JSPUtil.getParameter(request, prefix + "nhp", ""));
		setCgoClmStlLoclAmt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_locl_amt", ""));
		setLablPtyXchRt(JSPUtil.getParameter(request, prefix + "labl_pty_xch_rt", ""));
		setClmStlAuthNo(JSPUtil.getParameter(request, prefix + "clm_stl_auth_no", ""));
		setClmtLoclCurrCd(JSPUtil.getParameter(request, prefix + "clmt_locl_curr_cd", ""));
		setInciOccrDt(JSPUtil.getParameter(request, prefix + "inci_occr_dt", ""));
		setHpc(JSPUtil.getParameter(request, prefix + "hpc", ""));
		setClmStlAuthRmk(JSPUtil.getParameter(request, prefix + "clm_stl_auth_rmk", ""));
		setClmMiscNm(JSPUtil.getParameter(request, prefix + "clm_misc_nm", ""));
		setCgoClmStlLoclCurrCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_locl_curr_cd", ""));
		setClmPtyNo(JSPUtil.getParameter(request, prefix + "clm_pty_no", ""));
		setCgoClmStlTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_tp_cd", ""));
		setClmStlAuthCd(JSPUtil.getParameter(request, prefix + "clm_stl_auth_cd", ""));
		setClmTmBarDt(JSPUtil.getParameter(request, prefix + "clm_tm_bar_dt", ""));
		setN3rdLablPtyCd(JSPUtil.getParameter(request, prefix + "n3rd_labl_pty_cd", ""));
		setClmStlAuthOfcCd(JSPUtil.getParameter(request, prefix + "clm_stl_auth_ofc_cd", ""));
		setClmtUsdAmt(JSPUtil.getParameter(request, prefix + "clmt_usd_amt", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, prefix + "inci_plc_tp_cd", ""));
		setCrmVocNo(JSPUtil.getParameter(request, prefix + "crm_voc_no", ""));
		setClmStlApplDt(JSPUtil.getParameter(request, prefix + "clm_stl_appl_dt", ""));
		setLablPtyRcvrLoclCurrCd(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_curr_cd", ""));
		setCgoClmTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_tp_cd", ""));
		setLablPtyFmalClmDt(JSPUtil.getParameter(request, prefix + "labl_pty_fmal_clm_dt", ""));
		setLablPtyRcvrLoclXchRt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_xch_rt", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setClmMiscCd(JSPUtil.getParameter(request, prefix + "clm_misc_cd", ""));
		setCgoClmStlXchRt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_xch_rt", ""));
		setClmtLoclXchRt(JSPUtil.getParameter(request, prefix + "clmt_locl_xch_rt", ""));
		setClmtLoclAmt(JSPUtil.getParameter(request, prefix + "clmt_locl_amt", ""));
		setCsClzDt(JSPUtil.getParameter(request, prefix + "cs_clz_dt", ""));
		setLablPtyRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_usd_amt", ""));
		setPtyNm(JSPUtil.getParameter(request, prefix + "pty_nm", ""));
		setLablPtyDmndUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_dmnd_usd_amt", ""));
		setClmStlApplOfcCd(JSPUtil.getParameter(request, prefix + "clm_stl_appl_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLablPtyDmndCurrCd(JSPUtil.getParameter(request, prefix + "labl_pty_dmnd_curr_cd", ""));
		setClmStlAuthDt(JSPUtil.getParameter(request, prefix + "clm_stl_auth_dt", ""));
		setCgoClmStlRmk(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_rmk", ""));
		setCgoClmStlUsdAmt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_usd_amt", ""));
		setClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "clm_pty_abbr_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLablPtyRcvrLoclAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_amt", ""));
		setLablPtyRcvrDt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_dt", ""));
		setCgoClmStlDt(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_dt", ""));
		setClmStlAuthUsrId(JSPUtil.getParameter(request, prefix + "clm_stl_auth_usr_id", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setTmBarDt(JSPUtil.getParameter(request, prefix + "tm_bar_dt", ""));
		setClmStlApplUsrId(JSPUtil.getParameter(request, prefix + "clm_stl_appl_usr_id", ""));
		setCgoClmInciNo(JSPUtil.getParameter(request, prefix + "cgo_clm_inci_no", ""));
		setClmAreaCd(JSPUtil.getParameter(request, prefix + "clm_area_cd", ""));
		setCgoQltyDesc(JSPUtil.getParameter(request, prefix + "cgo_qlty_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SettlementVO[]
	 */
	public SettlementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SettlementVO[]
	 */
	public SettlementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SettlementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] insurRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_usd_amt", length));
			String[] smnsSveDt = (JSPUtil.getParameter(request, prefix	+ "smns_sve_dt", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] clmCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_cgo_tp_cd", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] cgoClmStlDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lablPtyPrlmClmNtfyDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_prlm_clm_ntfy_dt", length));
			String[] clmStlAuthCdNm = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_cd_nm", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] lablPtyDmndAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mjrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "mjr_clm_dmg_lss_cd", length));
			String[] nhp = (JSPUtil.getParameter(request, prefix	+ "nhp", length));
			String[] cgoClmStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_amt", length));
			String[] lablPtyXchRt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_xch_rt", length));
			String[] clmStlAuthNo = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_no", length));
			String[] clmtLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_curr_cd", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] hpc = (JSPUtil.getParameter(request, prefix	+ "hpc", length));
			String[] clmStlAuthRmk = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_rmk", length));
			String[] clmMiscNm = (JSPUtil.getParameter(request, prefix	+ "clm_misc_nm", length));
			String[] cgoClmStlLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_curr_cd", length));
			String[] clmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_no", length));
			String[] cgoClmStlTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_tp_cd", length));
			String[] clmStlAuthCd = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_cd", length));
			String[] clmTmBarDt = (JSPUtil.getParameter(request, prefix	+ "clm_tm_bar_dt", length));
			String[] n3rdLablPtyCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_labl_pty_cd", length));
			String[] clmStlAuthOfcCd = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_ofc_cd", length));
			String[] clmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_usd_amt", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] crmVocNo = (JSPUtil.getParameter(request, prefix	+ "crm_voc_no", length));
			String[] clmStlApplDt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_appl_dt", length));
			String[] lablPtyRcvrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_curr_cd", length));
			String[] cgoClmTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_tp_cd", length));
			String[] lablPtyFmalClmDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_fmal_clm_dt", length));
			String[] lablPtyRcvrLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_xch_rt", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] clmMiscCd = (JSPUtil.getParameter(request, prefix	+ "clm_misc_cd", length));
			String[] cgoClmStlXchRt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_xch_rt", length));
			String[] clmtLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_xch_rt", length));
			String[] clmtLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_amt", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] lablPtyRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_usd_amt", length));
			String[] ptyNm = (JSPUtil.getParameter(request, prefix	+ "pty_nm", length));
			String[] lablPtyDmndUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_usd_amt", length));
			String[] clmStlApplOfcCd = (JSPUtil.getParameter(request, prefix	+ "clm_stl_appl_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lablPtyDmndCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_curr_cd", length));
			String[] clmStlAuthDt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_dt", length));
			String[] cgoClmStlRmk = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_rmk", length));
			String[] cgoClmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_usd_amt", length));
			String[] clmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lablPtyRcvrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_amt", length));
			String[] lablPtyRcvrDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_dt", length));
			String[] cgoClmStlDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_dt", length));
			String[] clmStlAuthUsrId = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_usr_id", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] tmBarDt = (JSPUtil.getParameter(request, prefix	+ "tm_bar_dt", length));
			String[] clmStlApplUsrId = (JSPUtil.getParameter(request, prefix	+ "clm_stl_appl_usr_id", length));
			String[] cgoClmInciNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_inci_no", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			String[] cgoQltyDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_qlty_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new SettlementVO();
				if (insurRcvrUsdAmt[i] != null)
					model.setInsurRcvrUsdAmt(insurRcvrUsdAmt[i]);
				if (smnsSveDt[i] != null)
					model.setSmnsSveDt(smnsSveDt[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (clmCgoTpCd[i] != null)
					model.setClmCgoTpCd(clmCgoTpCd[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (cgoClmStlDesc[i] != null)
					model.setCgoClmStlDesc(cgoClmStlDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lablPtyPrlmClmNtfyDt[i] != null)
					model.setLablPtyPrlmClmNtfyDt(lablPtyPrlmClmNtfyDt[i]);
				if (clmStlAuthCdNm[i] != null)
					model.setClmStlAuthCdNm(clmStlAuthCdNm[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (lablPtyDmndAmt[i] != null)
					model.setLablPtyDmndAmt(lablPtyDmndAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mjrClmDmgLssCd[i] != null)
					model.setMjrClmDmgLssCd(mjrClmDmgLssCd[i]);
				if (nhp[i] != null)
					model.setNhp(nhp[i]);
				if (cgoClmStlLoclAmt[i] != null)
					model.setCgoClmStlLoclAmt(cgoClmStlLoclAmt[i]);
				if (lablPtyXchRt[i] != null)
					model.setLablPtyXchRt(lablPtyXchRt[i]);
				if (clmStlAuthNo[i] != null)
					model.setClmStlAuthNo(clmStlAuthNo[i]);
				if (clmtLoclCurrCd[i] != null)
					model.setClmtLoclCurrCd(clmtLoclCurrCd[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (hpc[i] != null)
					model.setHpc(hpc[i]);
				if (clmStlAuthRmk[i] != null)
					model.setClmStlAuthRmk(clmStlAuthRmk[i]);
				if (clmMiscNm[i] != null)
					model.setClmMiscNm(clmMiscNm[i]);
				if (cgoClmStlLoclCurrCd[i] != null)
					model.setCgoClmStlLoclCurrCd(cgoClmStlLoclCurrCd[i]);
				if (clmPtyNo[i] != null)
					model.setClmPtyNo(clmPtyNo[i]);
				if (cgoClmStlTpCd[i] != null)
					model.setCgoClmStlTpCd(cgoClmStlTpCd[i]);
				if (clmStlAuthCd[i] != null)
					model.setClmStlAuthCd(clmStlAuthCd[i]);
				if (clmTmBarDt[i] != null)
					model.setClmTmBarDt(clmTmBarDt[i]);
				if (n3rdLablPtyCd[i] != null)
					model.setN3rdLablPtyCd(n3rdLablPtyCd[i]);
				if (clmStlAuthOfcCd[i] != null)
					model.setClmStlAuthOfcCd(clmStlAuthOfcCd[i]);
				if (clmtUsdAmt[i] != null)
					model.setClmtUsdAmt(clmtUsdAmt[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (crmVocNo[i] != null)
					model.setCrmVocNo(crmVocNo[i]);
				if (clmStlApplDt[i] != null)
					model.setClmStlApplDt(clmStlApplDt[i]);
				if (lablPtyRcvrLoclCurrCd[i] != null)
					model.setLablPtyRcvrLoclCurrCd(lablPtyRcvrLoclCurrCd[i]);
				if (cgoClmTpCd[i] != null)
					model.setCgoClmTpCd(cgoClmTpCd[i]);
				if (lablPtyFmalClmDt[i] != null)
					model.setLablPtyFmalClmDt(lablPtyFmalClmDt[i]);
				if (lablPtyRcvrLoclXchRt[i] != null)
					model.setLablPtyRcvrLoclXchRt(lablPtyRcvrLoclXchRt[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (clmMiscCd[i] != null)
					model.setClmMiscCd(clmMiscCd[i]);
				if (cgoClmStlXchRt[i] != null)
					model.setCgoClmStlXchRt(cgoClmStlXchRt[i]);
				if (clmtLoclXchRt[i] != null)
					model.setClmtLoclXchRt(clmtLoclXchRt[i]);
				if (clmtLoclAmt[i] != null)
					model.setClmtLoclAmt(clmtLoclAmt[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (lablPtyRcvrUsdAmt[i] != null)
					model.setLablPtyRcvrUsdAmt(lablPtyRcvrUsdAmt[i]);
				if (ptyNm[i] != null)
					model.setPtyNm(ptyNm[i]);
				if (lablPtyDmndUsdAmt[i] != null)
					model.setLablPtyDmndUsdAmt(lablPtyDmndUsdAmt[i]);
				if (clmStlApplOfcCd[i] != null)
					model.setClmStlApplOfcCd(clmStlApplOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lablPtyDmndCurrCd[i] != null)
					model.setLablPtyDmndCurrCd(lablPtyDmndCurrCd[i]);
				if (clmStlAuthDt[i] != null)
					model.setClmStlAuthDt(clmStlAuthDt[i]);
				if (cgoClmStlRmk[i] != null)
					model.setCgoClmStlRmk(cgoClmStlRmk[i]);
				if (cgoClmStlUsdAmt[i] != null)
					model.setCgoClmStlUsdAmt(cgoClmStlUsdAmt[i]);
				if (clmPtyAbbrNm[i] != null)
					model.setClmPtyAbbrNm(clmPtyAbbrNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lablPtyRcvrLoclAmt[i] != null)
					model.setLablPtyRcvrLoclAmt(lablPtyRcvrLoclAmt[i]);
				if (lablPtyRcvrDt[i] != null)
					model.setLablPtyRcvrDt(lablPtyRcvrDt[i]);
				if (cgoClmStlDt[i] != null)
					model.setCgoClmStlDt(cgoClmStlDt[i]);
				if (clmStlAuthUsrId[i] != null)
					model.setClmStlAuthUsrId(clmStlAuthUsrId[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (tmBarDt[i] != null)
					model.setTmBarDt(tmBarDt[i]);
				if (clmStlApplUsrId[i] != null)
					model.setClmStlApplUsrId(clmStlApplUsrId[i]);
				if (cgoClmInciNo[i] != null)
					model.setCgoClmInciNo(cgoClmInciNo[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				if (cgoQltyDesc[i] != null)
					model.setCgoQltyDesc(cgoQltyDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSettlementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SettlementVO[]
	 */
	public SettlementVO[] getSettlementVOs(){
		SettlementVO[] vos = (SettlementVO[])models.toArray(new SettlementVO[models.size()]);
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
		this.insurRcvrUsdAmt = this.insurRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smnsSveDt = this.smnsSveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCgoTpCd = this.clmCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlDesc = this.cgoClmStlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyPrlmClmNtfyDt = this.lablPtyPrlmClmNtfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthCdNm = this.clmStlAuthCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndAmt = this.lablPtyDmndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrClmDmgLssCd = this.mjrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nhp = this.nhp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclAmt = this.cgoClmStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyXchRt = this.lablPtyXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthNo = this.clmStlAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclCurrCd = this.clmtLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hpc = this.hpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthRmk = this.clmStlAuthRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscNm = this.clmMiscNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclCurrCd = this.cgoClmStlLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo = this.clmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlTpCd = this.cgoClmStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthCd = this.clmStlAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmTmBarDt = this.clmTmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLablPtyCd = this.n3rdLablPtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthOfcCd = this.clmStlAuthOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtUsdAmt = this.clmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crmVocNo = this.crmVocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlApplDt = this.clmStlApplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclCurrCd = this.lablPtyRcvrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmTpCd = this.cgoClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFmalClmDt = this.lablPtyFmalClmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclXchRt = this.lablPtyRcvrLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscCd = this.clmMiscCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlXchRt = this.cgoClmStlXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclXchRt = this.clmtLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclAmt = this.clmtLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrUsdAmt = this.lablPtyRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm = this.ptyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndUsdAmt = this.lablPtyDmndUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlApplOfcCd = this.clmStlApplOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndCurrCd = this.lablPtyDmndCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthDt = this.clmStlAuthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlRmk = this.cgoClmStlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlUsdAmt = this.cgoClmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm = this.clmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclAmt = this.lablPtyRcvrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrDt = this.lablPtyRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlDt = this.cgoClmStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthUsrId = this.clmStlAuthUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmBarDt = this.tmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlApplUsrId = this.clmStlApplUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmInciNo = this.cgoClmInciNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoQltyDesc = this.cgoQltyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
