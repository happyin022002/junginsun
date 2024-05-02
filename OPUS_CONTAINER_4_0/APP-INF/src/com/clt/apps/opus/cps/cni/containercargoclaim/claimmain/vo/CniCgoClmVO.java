/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CniCgoClmVO.java
*@FileTitle : CniCgoClmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.03.18 정행룡 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo;

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
 * @author 정행룡
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CniCgoClmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CniCgoClmVO> models = new ArrayList<CniCgoClmVO>();
	
	/* Column Info */
	private String csClzUsrId = null;
	/* Column Info */
	private String preCgoClmClzCd = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pastCgoClmNo = null;
	/* Column Info */
	private String clmCuzDesc = null;
	/* Column Info */
	private String csClzRopnOfcCd = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String prlmClmNtcDt = null;
	/* Column Info */
	private String payRmk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cgoClmDivCd = null;
	/* Column Info */
	private String mjrClmDmgLssCd = null;
	/* Column Info */
	private String cgoClmCxlFlg = null;
	/* Column Info */
	private String clmStlAuthNo = null;
	/* Column Info */
	private String clmtLoclCurrCd = null;
	/* Column Info */
	private String cpDesc = null;
	/* Column Info */
	private String cgoClmAcknakDt = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Column Info */
	private String clmtAgnDesc = null;
	/* Column Info */
	private String clmStlAuthRmk = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String clmStlAuthCd = null;
	/* Column Info */
	private String fmalClmRcvOfcCd = null;
	/* Column Info */
	private String minrClmDmgLssCd = null;
	/* Column Info */
	private String clmStlAuthOfcCd = null;
	/* Column Info */
	private String clmtUsdAmt = null;
	/* Column Info */
	private String crmVocNo = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String clmStlApplDt = null;
	/* Column Info */
	private String cgoClmTpCd = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String clmtLoclXchRt = null;
	/* Column Info */
	private String clmtRefNo = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String clmtLoclAmt = null;
	/* Column Info */
	private String trnsFlg = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String bfrCgoClmStsCd = null;
	/* Column Info */
	private String fmalClmRcvUsrId = null;
	/* Column Info */
	private String clmtClmPtyNo = null;
	/* Column Info */
	private String csClzRopnFlg = null;
	/* Column Info */
	private String clmtDesc = null;
	/* Column Info */
	private String clmtAgnApntDt = null;
	/* Column Info */
	private String clmStlApplOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String csClzRopnUsrId = null;
	/* Column Info */
	private String clmStlAuthDt = null;
	/* Column Info */
	private String cgoClmRcvOfcCd = null;
	/* Column Info */
	private String cgoClmStsCd = null;
	/* Column Info */
	private String clmRvwDesc = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String factFndDesc = null;
	/* Column Info */
	private String csClzRopnDt = null;
	/* Column Info */
	private String agnClmPtyNo = null;
	/* Column Info */
	private String cgoClmSuitFlg = null;
	/* Column Info */
	private String clmtAgnTpCd = null;
	/* Column Info */
	private String clmStlAuthUsrId = null;
	/* Column Info */
	private String clmtClmTpCd = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String factFndDt = null;
	/* Column Info */
	private String csClzOfcCd = null;
	/* Column Info */
	private String tmBarDt = null;
	/* Column Info */
	private String cgoClmInciNo = null;
	/* Column Info */
	private String clmStlApplUsrId = null;
	/* Column Info */
	private String clmtAgnRefNo = null;
	/* Column Info */
	private String cgoClmClzCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CniCgoClmVO() {}

	public CniCgoClmVO(String ibflag, String pagerows, String cgoClmNo, String hdlrUsrId, String hdlrOfcCd, String csClzDt, String csClzOfcCd, String csClzUsrId, String tmBarDt, String prlmClmNtcDt, String cgoClmAcknakDt, String factFndDt, String factFndDesc, String trnsFlg, String csClzRopnFlg, String csClzRopnDt, String csClzRopnOfcCd, String csClzRopnUsrId, String cgoClmDivCd, String cpDesc, String clmtClmPtyNo, String clmtDesc, String clmtClmTpCd, String clmtRefNo, String fmalClmRcvOfcCd, String fmalClmRcvDt, String fmalClmRcvUsrId, String cgoClmTpCd, String mjrClmDmgLssCd, String minrClmDmgLssCd, String cgoClmInciNo, String inciPlcTpCd, String inciOccrDt, String clmtLoclAmt, String clmtLoclCurrCd, String clmtLoclXchRt, String clmtUsdAmt, String clmCuzDesc, String clmRvwDesc, String agnClmPtyNo, String clmtAgnTpCd, String clmtAgnApntDt, String clmtAgnRefNo, String cgoClmRcvOfcCd, String cgoClmSuitFlg, String clmStlApplDt, String clmStlApplUsrId, String clmStlApplOfcCd, String clmStlAuthDt, String clmStlAuthUsrId, String clmStlAuthOfcCd, String clmStlAuthCd, String clmStlAuthRmk, String clmStlAuthNo, String payRmk, String clmtAgnDesc, String cgoClmStsCd, String bfrCgoClmStsCd, String cgoClmClzCd, String preCgoClmClzCd, String cgoClmCxlFlg, String pastCgoClmNo, String crmVocNo, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.csClzUsrId = csClzUsrId;
		this.preCgoClmClzCd = preCgoClmClzCd;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.pagerows = pagerows;
		this.pastCgoClmNo = pastCgoClmNo;
		this.clmCuzDesc = clmCuzDesc;
		this.csClzRopnOfcCd = csClzRopnOfcCd;
		this.cgoClmNo = cgoClmNo;
		this.prlmClmNtcDt = prlmClmNtcDt;
		this.payRmk = payRmk;
		this.updUsrId = updUsrId;
		this.cgoClmDivCd = cgoClmDivCd;
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
		this.cgoClmCxlFlg = cgoClmCxlFlg;
		this.clmStlAuthNo = clmStlAuthNo;
		this.clmtLoclCurrCd = clmtLoclCurrCd;
		this.cpDesc = cpDesc;
		this.cgoClmAcknakDt = cgoClmAcknakDt;
		this.inciOccrDt = inciOccrDt;
		this.clmtAgnDesc = clmtAgnDesc;
		this.clmStlAuthRmk = clmStlAuthRmk;
		this.creUsrId = creUsrId;
		this.clmStlAuthCd = clmStlAuthCd;
		this.fmalClmRcvOfcCd = fmalClmRcvOfcCd;
		this.minrClmDmgLssCd = minrClmDmgLssCd;
		this.clmStlAuthOfcCd = clmStlAuthOfcCd;
		this.clmtUsdAmt = clmtUsdAmt;
		this.crmVocNo = crmVocNo;
		this.inciPlcTpCd = inciPlcTpCd;
		this.clmStlApplDt = clmStlApplDt;
		this.cgoClmTpCd = cgoClmTpCd;
		this.hdlrOfcCd = hdlrOfcCd;
		this.clmtLoclXchRt = clmtLoclXchRt;
		this.clmtRefNo = clmtRefNo;
		this.csClzDt = csClzDt;
		this.clmtLoclAmt = clmtLoclAmt;
		this.trnsFlg = trnsFlg;
		this.creDt = creDt;
		this.bfrCgoClmStsCd = bfrCgoClmStsCd;
		this.fmalClmRcvUsrId = fmalClmRcvUsrId;
		this.clmtClmPtyNo = clmtClmPtyNo;
		this.csClzRopnFlg = csClzRopnFlg;
		this.clmtDesc = clmtDesc;
		this.clmtAgnApntDt = clmtAgnApntDt;
		this.clmStlApplOfcCd = clmStlApplOfcCd;
		this.ibflag = ibflag;
		this.csClzRopnUsrId = csClzRopnUsrId;
		this.clmStlAuthDt = clmStlAuthDt;
		this.cgoClmRcvOfcCd = cgoClmRcvOfcCd;
		this.cgoClmStsCd = cgoClmStsCd;
		this.clmRvwDesc = clmRvwDesc;
		this.updDt = updDt;
		this.factFndDesc = factFndDesc;
		this.csClzRopnDt = csClzRopnDt;
		this.agnClmPtyNo = agnClmPtyNo;
		this.cgoClmSuitFlg = cgoClmSuitFlg;
		this.clmtAgnTpCd = clmtAgnTpCd;
		this.clmStlAuthUsrId = clmStlAuthUsrId;
		this.clmtClmTpCd = clmtClmTpCd;
		this.hdlrUsrId = hdlrUsrId;
		this.factFndDt = factFndDt;
		this.csClzOfcCd = csClzOfcCd;
		this.tmBarDt = tmBarDt;
		this.cgoClmInciNo = cgoClmInciNo;
		this.clmStlApplUsrId = clmStlApplUsrId;
		this.clmtAgnRefNo = clmtAgnRefNo;
		this.cgoClmClzCd = cgoClmClzCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cs_clz_usr_id", getCsClzUsrId());
		this.hashColumns.put("pre_cgo_clm_clz_cd", getPreCgoClmClzCd());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("past_cgo_clm_no", getPastCgoClmNo());
		this.hashColumns.put("clm_cuz_desc", getClmCuzDesc());
		this.hashColumns.put("cs_clz_ropn_ofc_cd", getCsClzRopnOfcCd());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("prlm_clm_ntc_dt", getPrlmClmNtcDt());
		this.hashColumns.put("pay_rmk", getPayRmk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cgo_clm_div_cd", getCgoClmDivCd());
		this.hashColumns.put("mjr_clm_dmg_lss_cd", getMjrClmDmgLssCd());
		this.hashColumns.put("cgo_clm_cxl_flg", getCgoClmCxlFlg());
		this.hashColumns.put("clm_stl_auth_no", getClmStlAuthNo());
		this.hashColumns.put("clmt_locl_curr_cd", getClmtLoclCurrCd());
		this.hashColumns.put("cp_desc", getCpDesc());
		this.hashColumns.put("cgo_clm_acknak_dt", getCgoClmAcknakDt());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("clmt_agn_desc", getClmtAgnDesc());
		this.hashColumns.put("clm_stl_auth_rmk", getClmStlAuthRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("clm_stl_auth_cd", getClmStlAuthCd());
		this.hashColumns.put("fmal_clm_rcv_ofc_cd", getFmalClmRcvOfcCd());
		this.hashColumns.put("minr_clm_dmg_lss_cd", getMinrClmDmgLssCd());
		this.hashColumns.put("clm_stl_auth_ofc_cd", getClmStlAuthOfcCd());
		this.hashColumns.put("clmt_usd_amt", getClmtUsdAmt());
		this.hashColumns.put("crm_voc_no", getCrmVocNo());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("clm_stl_appl_dt", getClmStlApplDt());
		this.hashColumns.put("cgo_clm_tp_cd", getCgoClmTpCd());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("clmt_locl_xch_rt", getClmtLoclXchRt());
		this.hashColumns.put("clmt_ref_no", getClmtRefNo());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("clmt_locl_amt", getClmtLoclAmt());
		this.hashColumns.put("trns_flg", getTrnsFlg());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("bfr_cgo_clm_sts_cd", getBfrCgoClmStsCd());
		this.hashColumns.put("fmal_clm_rcv_usr_id", getFmalClmRcvUsrId());
		this.hashColumns.put("clmt_clm_pty_no", getClmtClmPtyNo());
		this.hashColumns.put("cs_clz_ropn_flg", getCsClzRopnFlg());
		this.hashColumns.put("clmt_desc", getClmtDesc());
		this.hashColumns.put("clmt_agn_apnt_dt", getClmtAgnApntDt());
		this.hashColumns.put("clm_stl_appl_ofc_cd", getClmStlApplOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cs_clz_ropn_usr_id", getCsClzRopnUsrId());
		this.hashColumns.put("clm_stl_auth_dt", getClmStlAuthDt());
		this.hashColumns.put("cgo_clm_rcv_ofc_cd", getCgoClmRcvOfcCd());
		this.hashColumns.put("cgo_clm_sts_cd", getCgoClmStsCd());
		this.hashColumns.put("clm_rvw_desc", getClmRvwDesc());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("fact_fnd_desc", getFactFndDesc());
		this.hashColumns.put("cs_clz_ropn_dt", getCsClzRopnDt());
		this.hashColumns.put("agn_clm_pty_no", getAgnClmPtyNo());
		this.hashColumns.put("cgo_clm_suit_flg", getCgoClmSuitFlg());
		this.hashColumns.put("clmt_agn_tp_cd", getClmtAgnTpCd());
		this.hashColumns.put("clm_stl_auth_usr_id", getClmStlAuthUsrId());
		this.hashColumns.put("clmt_clm_tp_cd", getClmtClmTpCd());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("fact_fnd_dt", getFactFndDt());
		this.hashColumns.put("cs_clz_ofc_cd", getCsClzOfcCd());
		this.hashColumns.put("tm_bar_dt", getTmBarDt());
		this.hashColumns.put("cgo_clm_inci_no", getCgoClmInciNo());
		this.hashColumns.put("clm_stl_appl_usr_id", getClmStlApplUsrId());
		this.hashColumns.put("clmt_agn_ref_no", getClmtAgnRefNo());
		this.hashColumns.put("cgo_clm_clz_cd", getCgoClmClzCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cs_clz_usr_id", "csClzUsrId");
		this.hashFields.put("pre_cgo_clm_clz_cd", "preCgoClmClzCd");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("past_cgo_clm_no", "pastCgoClmNo");
		this.hashFields.put("clm_cuz_desc", "clmCuzDesc");
		this.hashFields.put("cs_clz_ropn_ofc_cd", "csClzRopnOfcCd");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("prlm_clm_ntc_dt", "prlmClmNtcDt");
		this.hashFields.put("pay_rmk", "payRmk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cgo_clm_div_cd", "cgoClmDivCd");
		this.hashFields.put("mjr_clm_dmg_lss_cd", "mjrClmDmgLssCd");
		this.hashFields.put("cgo_clm_cxl_flg", "cgoClmCxlFlg");
		this.hashFields.put("clm_stl_auth_no", "clmStlAuthNo");
		this.hashFields.put("clmt_locl_curr_cd", "clmtLoclCurrCd");
		this.hashFields.put("cp_desc", "cpDesc");
		this.hashFields.put("cgo_clm_acknak_dt", "cgoClmAcknakDt");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("clmt_agn_desc", "clmtAgnDesc");
		this.hashFields.put("clm_stl_auth_rmk", "clmStlAuthRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("clm_stl_auth_cd", "clmStlAuthCd");
		this.hashFields.put("fmal_clm_rcv_ofc_cd", "fmalClmRcvOfcCd");
		this.hashFields.put("minr_clm_dmg_lss_cd", "minrClmDmgLssCd");
		this.hashFields.put("clm_stl_auth_ofc_cd", "clmStlAuthOfcCd");
		this.hashFields.put("clmt_usd_amt", "clmtUsdAmt");
		this.hashFields.put("crm_voc_no", "crmVocNo");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("clm_stl_appl_dt", "clmStlApplDt");
		this.hashFields.put("cgo_clm_tp_cd", "cgoClmTpCd");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("clmt_locl_xch_rt", "clmtLoclXchRt");
		this.hashFields.put("clmt_ref_no", "clmtRefNo");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("clmt_locl_amt", "clmtLoclAmt");
		this.hashFields.put("trns_flg", "trnsFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bfr_cgo_clm_sts_cd", "bfrCgoClmStsCd");
		this.hashFields.put("fmal_clm_rcv_usr_id", "fmalClmRcvUsrId");
		this.hashFields.put("clmt_clm_pty_no", "clmtClmPtyNo");
		this.hashFields.put("cs_clz_ropn_flg", "csClzRopnFlg");
		this.hashFields.put("clmt_desc", "clmtDesc");
		this.hashFields.put("clmt_agn_apnt_dt", "clmtAgnApntDt");
		this.hashFields.put("clm_stl_appl_ofc_cd", "clmStlApplOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cs_clz_ropn_usr_id", "csClzRopnUsrId");
		this.hashFields.put("clm_stl_auth_dt", "clmStlAuthDt");
		this.hashFields.put("cgo_clm_rcv_ofc_cd", "cgoClmRcvOfcCd");
		this.hashFields.put("cgo_clm_sts_cd", "cgoClmStsCd");
		this.hashFields.put("clm_rvw_desc", "clmRvwDesc");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("fact_fnd_desc", "factFndDesc");
		this.hashFields.put("cs_clz_ropn_dt", "csClzRopnDt");
		this.hashFields.put("agn_clm_pty_no", "agnClmPtyNo");
		this.hashFields.put("cgo_clm_suit_flg", "cgoClmSuitFlg");
		this.hashFields.put("clmt_agn_tp_cd", "clmtAgnTpCd");
		this.hashFields.put("clm_stl_auth_usr_id", "clmStlAuthUsrId");
		this.hashFields.put("clmt_clm_tp_cd", "clmtClmTpCd");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("fact_fnd_dt", "factFndDt");
		this.hashFields.put("cs_clz_ofc_cd", "csClzOfcCd");
		this.hashFields.put("tm_bar_dt", "tmBarDt");
		this.hashFields.put("cgo_clm_inci_no", "cgoClmInciNo");
		this.hashFields.put("clm_stl_appl_usr_id", "clmStlApplUsrId");
		this.hashFields.put("clmt_agn_ref_no", "clmtAgnRefNo");
		this.hashFields.put("cgo_clm_clz_cd", "cgoClmClzCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return csClzUsrId
	 */
	public String getCsClzUsrId() {
		return this.csClzUsrId;
	}
	
	/**
	 * Column Info
	 * @return preCgoClmClzCd
	 */
	public String getPreCgoClmClzCd() {
		return this.preCgoClmClzCd;
	}
	
	/**
	 * Column Info
	 * @return fmalClmRcvDt
	 */
	public String getFmalClmRcvDt() {
		return this.fmalClmRcvDt;
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
	 * @return pastCgoClmNo
	 */
	public String getPastCgoClmNo() {
		return this.pastCgoClmNo;
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
	 * @return csClzRopnOfcCd
	 */
	public String getCsClzRopnOfcCd() {
		return this.csClzRopnOfcCd;
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
	 * @return payRmk
	 */
	public String getPayRmk() {
		return this.payRmk;
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
	 * @return cgoClmDivCd
	 */
	public String getCgoClmDivCd() {
		return this.cgoClmDivCd;
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
	 * @return cgoClmCxlFlg
	 */
	public String getCgoClmCxlFlg() {
		return this.cgoClmCxlFlg;
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
	 * @return cpDesc
	 */
	public String getCpDesc() {
		return this.cpDesc;
	}
	
	/**
	 * Column Info
	 * @return cgoClmAcknakDt
	 */
	public String getCgoClmAcknakDt() {
		return this.cgoClmAcknakDt;
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
	 * @return clmtAgnDesc
	 */
	public String getClmtAgnDesc() {
		return this.clmtAgnDesc;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return fmalClmRcvOfcCd
	 */
	public String getFmalClmRcvOfcCd() {
		return this.fmalClmRcvOfcCd;
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
	 * @return crmVocNo
	 */
	public String getCrmVocNo() {
		return this.crmVocNo;
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
	 * @return clmStlApplDt
	 */
	public String getClmStlApplDt() {
		return this.clmStlApplDt;
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
	 * @return hdlrOfcCd
	 */
	public String getHdlrOfcCd() {
		return this.hdlrOfcCd;
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
	 * @return clmtRefNo
	 */
	public String getClmtRefNo() {
		return this.clmtRefNo;
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
	 * @return trnsFlg
	 */
	public String getTrnsFlg() {
		return this.trnsFlg;
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
	 * @return bfrCgoClmStsCd
	 */
	public String getBfrCgoClmStsCd() {
		return this.bfrCgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return fmalClmRcvUsrId
	 */
	public String getFmalClmRcvUsrId() {
		return this.fmalClmRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @return clmtClmPtyNo
	 */
	public String getClmtClmPtyNo() {
		return this.clmtClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return csClzRopnFlg
	 */
	public String getCsClzRopnFlg() {
		return this.csClzRopnFlg;
	}
	
	/**
	 * Column Info
	 * @return clmtDesc
	 */
	public String getClmtDesc() {
		return this.clmtDesc;
	}
	
	/**
	 * Column Info
	 * @return clmtAgnApntDt
	 */
	public String getClmtAgnApntDt() {
		return this.clmtAgnApntDt;
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
	 * @return csClzRopnUsrId
	 */
	public String getCsClzRopnUsrId() {
		return this.csClzRopnUsrId;
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
	 * @return cgoClmRcvOfcCd
	 */
	public String getCgoClmRcvOfcCd() {
		return this.cgoClmRcvOfcCd;
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
	 * @return clmRvwDesc
	 */
	public String getClmRvwDesc() {
		return this.clmRvwDesc;
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
	 * @return factFndDesc
	 */
	public String getFactFndDesc() {
		return this.factFndDesc;
	}
	
	/**
	 * Column Info
	 * @return csClzRopnDt
	 */
	public String getCsClzRopnDt() {
		return this.csClzRopnDt;
	}
	
	/**
	 * Column Info
	 * @return agnClmPtyNo
	 */
	public String getAgnClmPtyNo() {
		return this.agnClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmSuitFlg
	 */
	public String getCgoClmSuitFlg() {
		return this.cgoClmSuitFlg;
	}
	
	/**
	 * Column Info
	 * @return clmtAgnTpCd
	 */
	public String getClmtAgnTpCd() {
		return this.clmtAgnTpCd;
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
	 * @return clmtClmTpCd
	 */
	public String getClmtClmTpCd() {
		return this.clmtClmTpCd;
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
	 * @return factFndDt
	 */
	public String getFactFndDt() {
		return this.factFndDt;
	}
	
	/**
	 * Column Info
	 * @return csClzOfcCd
	 */
	public String getCsClzOfcCd() {
		return this.csClzOfcCd;
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
	 * @return cgoClmInciNo
	 */
	public String getCgoClmInciNo() {
		return this.cgoClmInciNo;
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
	 * @return clmtAgnRefNo
	 */
	public String getClmtAgnRefNo() {
		return this.clmtAgnRefNo;
	}
	
	/**
	 * Column Info
	 * @return cgoClmClzCd
	 */
	public String getCgoClmClzCd() {
		return this.cgoClmClzCd;
	}
	

	/**
	 * Column Info
	 * @param csClzUsrId
	 */
	public void setCsClzUsrId(String csClzUsrId) {
		this.csClzUsrId = csClzUsrId;
	}
	
	/**
	 * Column Info
	 * @param preCgoClmClzCd
	 */
	public void setPreCgoClmClzCd(String preCgoClmClzCd) {
		this.preCgoClmClzCd = preCgoClmClzCd;
	}
	
	/**
	 * Column Info
	 * @param fmalClmRcvDt
	 */
	public void setFmalClmRcvDt(String fmalClmRcvDt) {
		this.fmalClmRcvDt = fmalClmRcvDt;
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
	 * @param pastCgoClmNo
	 */
	public void setPastCgoClmNo(String pastCgoClmNo) {
		this.pastCgoClmNo = pastCgoClmNo;
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
	 * @param csClzRopnOfcCd
	 */
	public void setCsClzRopnOfcCd(String csClzRopnOfcCd) {
		this.csClzRopnOfcCd = csClzRopnOfcCd;
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
	 * @param payRmk
	 */
	public void setPayRmk(String payRmk) {
		this.payRmk = payRmk;
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
	 * @param cgoClmDivCd
	 */
	public void setCgoClmDivCd(String cgoClmDivCd) {
		this.cgoClmDivCd = cgoClmDivCd;
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
	 * @param cgoClmCxlFlg
	 */
	public void setCgoClmCxlFlg(String cgoClmCxlFlg) {
		this.cgoClmCxlFlg = cgoClmCxlFlg;
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
	 * @param cpDesc
	 */
	public void setCpDesc(String cpDesc) {
		this.cpDesc = cpDesc;
	}
	
	/**
	 * Column Info
	 * @param cgoClmAcknakDt
	 */
	public void setCgoClmAcknakDt(String cgoClmAcknakDt) {
		this.cgoClmAcknakDt = cgoClmAcknakDt;
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
	 * @param clmtAgnDesc
	 */
	public void setClmtAgnDesc(String clmtAgnDesc) {
		this.clmtAgnDesc = clmtAgnDesc;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param fmalClmRcvOfcCd
	 */
	public void setFmalClmRcvOfcCd(String fmalClmRcvOfcCd) {
		this.fmalClmRcvOfcCd = fmalClmRcvOfcCd;
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
	 * @param crmVocNo
	 */
	public void setCrmVocNo(String crmVocNo) {
		this.crmVocNo = crmVocNo;
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
	 * @param clmStlApplDt
	 */
	public void setClmStlApplDt(String clmStlApplDt) {
		this.clmStlApplDt = clmStlApplDt;
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
	 * @param hdlrOfcCd
	 */
	public void setHdlrOfcCd(String hdlrOfcCd) {
		this.hdlrOfcCd = hdlrOfcCd;
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
	 * @param clmtRefNo
	 */
	public void setClmtRefNo(String clmtRefNo) {
		this.clmtRefNo = clmtRefNo;
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
	 * @param trnsFlg
	 */
	public void setTrnsFlg(String trnsFlg) {
		this.trnsFlg = trnsFlg;
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
	 * @param bfrCgoClmStsCd
	 */
	public void setBfrCgoClmStsCd(String bfrCgoClmStsCd) {
		this.bfrCgoClmStsCd = bfrCgoClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param fmalClmRcvUsrId
	 */
	public void setFmalClmRcvUsrId(String fmalClmRcvUsrId) {
		this.fmalClmRcvUsrId = fmalClmRcvUsrId;
	}
	
	/**
	 * Column Info
	 * @param clmtClmPtyNo
	 */
	public void setClmtClmPtyNo(String clmtClmPtyNo) {
		this.clmtClmPtyNo = clmtClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param csClzRopnFlg
	 */
	public void setCsClzRopnFlg(String csClzRopnFlg) {
		this.csClzRopnFlg = csClzRopnFlg;
	}
	
	/**
	 * Column Info
	 * @param clmtDesc
	 */
	public void setClmtDesc(String clmtDesc) {
		this.clmtDesc = clmtDesc;
	}
	
	/**
	 * Column Info
	 * @param clmtAgnApntDt
	 */
	public void setClmtAgnApntDt(String clmtAgnApntDt) {
		this.clmtAgnApntDt = clmtAgnApntDt;
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
	 * @param csClzRopnUsrId
	 */
	public void setCsClzRopnUsrId(String csClzRopnUsrId) {
		this.csClzRopnUsrId = csClzRopnUsrId;
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
	 * @param cgoClmRcvOfcCd
	 */
	public void setCgoClmRcvOfcCd(String cgoClmRcvOfcCd) {
		this.cgoClmRcvOfcCd = cgoClmRcvOfcCd;
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
	 * @param clmRvwDesc
	 */
	public void setClmRvwDesc(String clmRvwDesc) {
		this.clmRvwDesc = clmRvwDesc;
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
	 * @param factFndDesc
	 */
	public void setFactFndDesc(String factFndDesc) {
		this.factFndDesc = factFndDesc;
	}
	
	/**
	 * Column Info
	 * @param csClzRopnDt
	 */
	public void setCsClzRopnDt(String csClzRopnDt) {
		this.csClzRopnDt = csClzRopnDt;
	}
	
	/**
	 * Column Info
	 * @param agnClmPtyNo
	 */
	public void setAgnClmPtyNo(String agnClmPtyNo) {
		this.agnClmPtyNo = agnClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmSuitFlg
	 */
	public void setCgoClmSuitFlg(String cgoClmSuitFlg) {
		this.cgoClmSuitFlg = cgoClmSuitFlg;
	}
	
	/**
	 * Column Info
	 * @param clmtAgnTpCd
	 */
	public void setClmtAgnTpCd(String clmtAgnTpCd) {
		this.clmtAgnTpCd = clmtAgnTpCd;
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
	 * @param clmtClmTpCd
	 */
	public void setClmtClmTpCd(String clmtClmTpCd) {
		this.clmtClmTpCd = clmtClmTpCd;
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
	 * @param factFndDt
	 */
	public void setFactFndDt(String factFndDt) {
		this.factFndDt = factFndDt;
	}
	
	/**
	 * Column Info
	 * @param csClzOfcCd
	 */
	public void setCsClzOfcCd(String csClzOfcCd) {
		this.csClzOfcCd = csClzOfcCd;
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
	 * @param cgoClmInciNo
	 */
	public void setCgoClmInciNo(String cgoClmInciNo) {
		this.cgoClmInciNo = cgoClmInciNo;
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
	 * @param clmtAgnRefNo
	 */
	public void setClmtAgnRefNo(String clmtAgnRefNo) {
		this.clmtAgnRefNo = clmtAgnRefNo;
	}
	
	/**
	 * Column Info
	 * @param cgoClmClzCd
	 */
	public void setCgoClmClzCd(String cgoClmClzCd) {
		this.cgoClmClzCd = cgoClmClzCd;
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
		setCsClzUsrId(JSPUtil.getParameter(request, prefix + "cs_clz_usr_id", ""));
		setPreCgoClmClzCd(JSPUtil.getParameter(request, prefix + "pre_cgo_clm_clz_cd", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPastCgoClmNo(JSPUtil.getParameter(request, prefix + "past_cgo_clm_no", ""));
		setClmCuzDesc(JSPUtil.getParameter(request, prefix + "clm_cuz_desc", ""));
		setCsClzRopnOfcCd(JSPUtil.getParameter(request, prefix + "cs_clz_ropn_ofc_cd", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setPrlmClmNtcDt(JSPUtil.getParameter(request, prefix + "prlm_clm_ntc_dt", ""));
		setPayRmk(JSPUtil.getParameter(request, prefix + "pay_rmk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCgoClmDivCd(JSPUtil.getParameter(request, prefix + "cgo_clm_div_cd", ""));
		setMjrClmDmgLssCd(JSPUtil.getParameter(request, prefix + "mjr_clm_dmg_lss_cd", ""));
		setCgoClmCxlFlg(JSPUtil.getParameter(request, prefix + "cgo_clm_cxl_flg", ""));
		setClmStlAuthNo(JSPUtil.getParameter(request, prefix + "clm_stl_auth_no", ""));
		setClmtLoclCurrCd(JSPUtil.getParameter(request, prefix + "clmt_locl_curr_cd", ""));
		setCpDesc(JSPUtil.getParameter(request, prefix + "cp_desc", ""));
		setCgoClmAcknakDt(JSPUtil.getParameter(request, prefix + "cgo_clm_acknak_dt", ""));
		setInciOccrDt(JSPUtil.getParameter(request, prefix + "inci_occr_dt", ""));
		setClmtAgnDesc(JSPUtil.getParameter(request, prefix + "clmt_agn_desc", ""));
		setClmStlAuthRmk(JSPUtil.getParameter(request, prefix + "clm_stl_auth_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setClmStlAuthCd(JSPUtil.getParameter(request, prefix + "clm_stl_auth_cd", ""));
		setFmalClmRcvOfcCd(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_ofc_cd", ""));
		setMinrClmDmgLssCd(JSPUtil.getParameter(request, prefix + "minr_clm_dmg_lss_cd", ""));
		setClmStlAuthOfcCd(JSPUtil.getParameter(request, prefix + "clm_stl_auth_ofc_cd", ""));
		setClmtUsdAmt(JSPUtil.getParameter(request, prefix + "clmt_usd_amt", ""));
		setCrmVocNo(JSPUtil.getParameter(request, prefix + "crm_voc_no", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, prefix + "inci_plc_tp_cd", ""));
		setClmStlApplDt(JSPUtil.getParameter(request, prefix + "clm_stl_appl_dt", ""));
		setCgoClmTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_tp_cd", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setClmtLoclXchRt(JSPUtil.getParameter(request, prefix + "clmt_locl_xch_rt", ""));
		setClmtRefNo(JSPUtil.getParameter(request, prefix + "clmt_ref_no", ""));
		setCsClzDt(JSPUtil.getParameter(request, prefix + "cs_clz_dt", ""));
		setClmtLoclAmt(JSPUtil.getParameter(request, prefix + "clmt_locl_amt", ""));
		setTrnsFlg(JSPUtil.getParameter(request, prefix + "trns_flg", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setBfrCgoClmStsCd(JSPUtil.getParameter(request, prefix + "bfr_cgo_clm_sts_cd", ""));
		setFmalClmRcvUsrId(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_usr_id", ""));
		setClmtClmPtyNo(JSPUtil.getParameter(request, prefix + "clmt_clm_pty_no", ""));
		setCsClzRopnFlg(JSPUtil.getParameter(request, prefix + "cs_clz_ropn_flg", ""));
		setClmtDesc(JSPUtil.getParameter(request, prefix + "clmt_desc", ""));
		setClmtAgnApntDt(JSPUtil.getParameter(request, prefix + "clmt_agn_apnt_dt", ""));
		setClmStlApplOfcCd(JSPUtil.getParameter(request, prefix + "clm_stl_appl_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCsClzRopnUsrId(JSPUtil.getParameter(request, prefix + "cs_clz_ropn_usr_id", ""));
		setClmStlAuthDt(JSPUtil.getParameter(request, prefix + "clm_stl_auth_dt", ""));
		setCgoClmRcvOfcCd(JSPUtil.getParameter(request, prefix + "cgo_clm_rcv_ofc_cd", ""));
		setCgoClmStsCd(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_cd", ""));
		setClmRvwDesc(JSPUtil.getParameter(request, prefix + "clm_rvw_desc", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFactFndDesc(JSPUtil.getParameter(request, prefix + "fact_fnd_desc", ""));
		setCsClzRopnDt(JSPUtil.getParameter(request, prefix + "cs_clz_ropn_dt", ""));
		setAgnClmPtyNo(JSPUtil.getParameter(request, prefix + "agn_clm_pty_no", ""));
		setCgoClmSuitFlg(JSPUtil.getParameter(request, prefix + "cgo_clm_suit_flg", ""));
		setClmtAgnTpCd(JSPUtil.getParameter(request, prefix + "clmt_agn_tp_cd", ""));
		setClmStlAuthUsrId(JSPUtil.getParameter(request, prefix + "clm_stl_auth_usr_id", ""));
		setClmtClmTpCd(JSPUtil.getParameter(request, prefix + "clmt_clm_tp_cd", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setFactFndDt(JSPUtil.getParameter(request, prefix + "fact_fnd_dt", ""));
		setCsClzOfcCd(JSPUtil.getParameter(request, prefix + "cs_clz_ofc_cd", ""));
		setTmBarDt(JSPUtil.getParameter(request, prefix + "tm_bar_dt", ""));
		setCgoClmInciNo(JSPUtil.getParameter(request, prefix + "cgo_clm_inci_no", ""));
		setClmStlApplUsrId(JSPUtil.getParameter(request, prefix + "clm_stl_appl_usr_id", ""));
		setClmtAgnRefNo(JSPUtil.getParameter(request, prefix + "clmt_agn_ref_no", ""));
		setCgoClmClzCd(JSPUtil.getParameter(request, prefix + "cgo_clm_clz_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CniCgoClmVO[]
	 */
	public CniCgoClmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CniCgoClmVO[]
	 */
	public CniCgoClmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CniCgoClmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csClzUsrId = (JSPUtil.getParameter(request, prefix	+ "cs_clz_usr_id", length));
			String[] preCgoClmClzCd = (JSPUtil.getParameter(request, prefix	+ "pre_cgo_clm_clz_cd", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pastCgoClmNo = (JSPUtil.getParameter(request, prefix	+ "past_cgo_clm_no", length));
			String[] clmCuzDesc = (JSPUtil.getParameter(request, prefix	+ "clm_cuz_desc", length));
			String[] csClzRopnOfcCd = (JSPUtil.getParameter(request, prefix	+ "cs_clz_ropn_ofc_cd", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] prlmClmNtcDt = (JSPUtil.getParameter(request, prefix	+ "prlm_clm_ntc_dt", length));
			String[] payRmk = (JSPUtil.getParameter(request, prefix	+ "pay_rmk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cgoClmDivCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_div_cd", length));
			String[] mjrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "mjr_clm_dmg_lss_cd", length));
			String[] cgoClmCxlFlg = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_cxl_flg", length));
			String[] clmStlAuthNo = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_no", length));
			String[] clmtLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_curr_cd", length));
			String[] cpDesc = (JSPUtil.getParameter(request, prefix	+ "cp_desc", length));
			String[] cgoClmAcknakDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_acknak_dt", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] clmtAgnDesc = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_desc", length));
			String[] clmStlAuthRmk = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] clmStlAuthCd = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_cd", length));
			String[] fmalClmRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_ofc_cd", length));
			String[] minrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "minr_clm_dmg_lss_cd", length));
			String[] clmStlAuthOfcCd = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_ofc_cd", length));
			String[] clmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_usd_amt", length));
			String[] crmVocNo = (JSPUtil.getParameter(request, prefix	+ "crm_voc_no", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] clmStlApplDt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_appl_dt", length));
			String[] cgoClmTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_tp_cd", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] clmtLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_xch_rt", length));
			String[] clmtRefNo = (JSPUtil.getParameter(request, prefix	+ "clmt_ref_no", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] clmtLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_amt", length));
			String[] trnsFlg = (JSPUtil.getParameter(request, prefix	+ "trns_flg", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] bfrCgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "bfr_cgo_clm_sts_cd", length));
			String[] fmalClmRcvUsrId = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_usr_id", length));
			String[] clmtClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_pty_no", length));
			String[] csClzRopnFlg = (JSPUtil.getParameter(request, prefix	+ "cs_clz_ropn_flg", length));
			String[] clmtDesc = (JSPUtil.getParameter(request, prefix	+ "clmt_desc", length));
			String[] clmtAgnApntDt = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_apnt_dt", length));
			String[] clmStlApplOfcCd = (JSPUtil.getParameter(request, prefix	+ "clm_stl_appl_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] csClzRopnUsrId = (JSPUtil.getParameter(request, prefix	+ "cs_clz_ropn_usr_id", length));
			String[] clmStlAuthDt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_dt", length));
			String[] cgoClmRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_rcv_ofc_cd", length));
			String[] cgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_cd", length));
			String[] clmRvwDesc = (JSPUtil.getParameter(request, prefix	+ "clm_rvw_desc", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] factFndDesc = (JSPUtil.getParameter(request, prefix	+ "fact_fnd_desc", length));
			String[] csClzRopnDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_ropn_dt", length));
			String[] agnClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "agn_clm_pty_no", length));
			String[] cgoClmSuitFlg = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_suit_flg", length));
			String[] clmtAgnTpCd = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_tp_cd", length));
			String[] clmStlAuthUsrId = (JSPUtil.getParameter(request, prefix	+ "clm_stl_auth_usr_id", length));
			String[] clmtClmTpCd = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_tp_cd", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] factFndDt = (JSPUtil.getParameter(request, prefix	+ "fact_fnd_dt", length));
			String[] csClzOfcCd = (JSPUtil.getParameter(request, prefix	+ "cs_clz_ofc_cd", length));
			String[] tmBarDt = (JSPUtil.getParameter(request, prefix	+ "tm_bar_dt", length));
			String[] cgoClmInciNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_inci_no", length));
			String[] clmStlApplUsrId = (JSPUtil.getParameter(request, prefix	+ "clm_stl_appl_usr_id", length));
			String[] clmtAgnRefNo = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_ref_no", length));
			String[] cgoClmClzCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_clz_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CniCgoClmVO();
				if (csClzUsrId[i] != null)
					model.setCsClzUsrId(csClzUsrId[i]);
				if (preCgoClmClzCd[i] != null)
					model.setPreCgoClmClzCd(preCgoClmClzCd[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pastCgoClmNo[i] != null)
					model.setPastCgoClmNo(pastCgoClmNo[i]);
				if (clmCuzDesc[i] != null)
					model.setClmCuzDesc(clmCuzDesc[i]);
				if (csClzRopnOfcCd[i] != null)
					model.setCsClzRopnOfcCd(csClzRopnOfcCd[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (prlmClmNtcDt[i] != null)
					model.setPrlmClmNtcDt(prlmClmNtcDt[i]);
				if (payRmk[i] != null)
					model.setPayRmk(payRmk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cgoClmDivCd[i] != null)
					model.setCgoClmDivCd(cgoClmDivCd[i]);
				if (mjrClmDmgLssCd[i] != null)
					model.setMjrClmDmgLssCd(mjrClmDmgLssCd[i]);
				if (cgoClmCxlFlg[i] != null)
					model.setCgoClmCxlFlg(cgoClmCxlFlg[i]);
				if (clmStlAuthNo[i] != null)
					model.setClmStlAuthNo(clmStlAuthNo[i]);
				if (clmtLoclCurrCd[i] != null)
					model.setClmtLoclCurrCd(clmtLoclCurrCd[i]);
				if (cpDesc[i] != null)
					model.setCpDesc(cpDesc[i]);
				if (cgoClmAcknakDt[i] != null)
					model.setCgoClmAcknakDt(cgoClmAcknakDt[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (clmtAgnDesc[i] != null)
					model.setClmtAgnDesc(clmtAgnDesc[i]);
				if (clmStlAuthRmk[i] != null)
					model.setClmStlAuthRmk(clmStlAuthRmk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (clmStlAuthCd[i] != null)
					model.setClmStlAuthCd(clmStlAuthCd[i]);
				if (fmalClmRcvOfcCd[i] != null)
					model.setFmalClmRcvOfcCd(fmalClmRcvOfcCd[i]);
				if (minrClmDmgLssCd[i] != null)
					model.setMinrClmDmgLssCd(minrClmDmgLssCd[i]);
				if (clmStlAuthOfcCd[i] != null)
					model.setClmStlAuthOfcCd(clmStlAuthOfcCd[i]);
				if (clmtUsdAmt[i] != null)
					model.setClmtUsdAmt(clmtUsdAmt[i]);
				if (crmVocNo[i] != null)
					model.setCrmVocNo(crmVocNo[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (clmStlApplDt[i] != null)
					model.setClmStlApplDt(clmStlApplDt[i]);
				if (cgoClmTpCd[i] != null)
					model.setCgoClmTpCd(cgoClmTpCd[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (clmtLoclXchRt[i] != null)
					model.setClmtLoclXchRt(clmtLoclXchRt[i]);
				if (clmtRefNo[i] != null)
					model.setClmtRefNo(clmtRefNo[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (clmtLoclAmt[i] != null)
					model.setClmtLoclAmt(clmtLoclAmt[i]);
				if (trnsFlg[i] != null)
					model.setTrnsFlg(trnsFlg[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (bfrCgoClmStsCd[i] != null)
					model.setBfrCgoClmStsCd(bfrCgoClmStsCd[i]);
				if (fmalClmRcvUsrId[i] != null)
					model.setFmalClmRcvUsrId(fmalClmRcvUsrId[i]);
				if (clmtClmPtyNo[i] != null)
					model.setClmtClmPtyNo(clmtClmPtyNo[i]);
				if (csClzRopnFlg[i] != null)
					model.setCsClzRopnFlg(csClzRopnFlg[i]);
				if (clmtDesc[i] != null)
					model.setClmtDesc(clmtDesc[i]);
				if (clmtAgnApntDt[i] != null)
					model.setClmtAgnApntDt(clmtAgnApntDt[i]);
				if (clmStlApplOfcCd[i] != null)
					model.setClmStlApplOfcCd(clmStlApplOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (csClzRopnUsrId[i] != null)
					model.setCsClzRopnUsrId(csClzRopnUsrId[i]);
				if (clmStlAuthDt[i] != null)
					model.setClmStlAuthDt(clmStlAuthDt[i]);
				if (cgoClmRcvOfcCd[i] != null)
					model.setCgoClmRcvOfcCd(cgoClmRcvOfcCd[i]);
				if (cgoClmStsCd[i] != null)
					model.setCgoClmStsCd(cgoClmStsCd[i]);
				if (clmRvwDesc[i] != null)
					model.setClmRvwDesc(clmRvwDesc[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (factFndDesc[i] != null)
					model.setFactFndDesc(factFndDesc[i]);
				if (csClzRopnDt[i] != null)
					model.setCsClzRopnDt(csClzRopnDt[i]);
				if (agnClmPtyNo[i] != null)
					model.setAgnClmPtyNo(agnClmPtyNo[i]);
				if (cgoClmSuitFlg[i] != null)
					model.setCgoClmSuitFlg(cgoClmSuitFlg[i]);
				if (clmtAgnTpCd[i] != null)
					model.setClmtAgnTpCd(clmtAgnTpCd[i]);
				if (clmStlAuthUsrId[i] != null)
					model.setClmStlAuthUsrId(clmStlAuthUsrId[i]);
				if (clmtClmTpCd[i] != null)
					model.setClmtClmTpCd(clmtClmTpCd[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (factFndDt[i] != null)
					model.setFactFndDt(factFndDt[i]);
				if (csClzOfcCd[i] != null)
					model.setCsClzOfcCd(csClzOfcCd[i]);
				if (tmBarDt[i] != null)
					model.setTmBarDt(tmBarDt[i]);
				if (cgoClmInciNo[i] != null)
					model.setCgoClmInciNo(cgoClmInciNo[i]);
				if (clmStlApplUsrId[i] != null)
					model.setClmStlApplUsrId(clmStlApplUsrId[i]);
				if (clmtAgnRefNo[i] != null)
					model.setClmtAgnRefNo(clmtAgnRefNo[i]);
				if (cgoClmClzCd[i] != null)
					model.setCgoClmClzCd(cgoClmClzCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCniCgoClmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CniCgoClmVO[]
	 */
	public CniCgoClmVO[] getCniCgoClmVOs(){
		CniCgoClmVO[] vos = (CniCgoClmVO[])models.toArray(new CniCgoClmVO[models.size()]);
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
		this.csClzUsrId = this.csClzUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCgoClmClzCd = this.preCgoClmClzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pastCgoClmNo = this.pastCgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCuzDesc = this.clmCuzDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzRopnOfcCd = this.csClzRopnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prlmClmNtcDt = this.prlmClmNtcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payRmk = this.payRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmDivCd = this.cgoClmDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrClmDmgLssCd = this.mjrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmCxlFlg = this.cgoClmCxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthNo = this.clmStlAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclCurrCd = this.clmtLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpDesc = this.cpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmAcknakDt = this.cgoClmAcknakDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnDesc = this.clmtAgnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthRmk = this.clmStlAuthRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthCd = this.clmStlAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvOfcCd = this.fmalClmRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minrClmDmgLssCd = this.minrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthOfcCd = this.clmStlAuthOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtUsdAmt = this.clmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crmVocNo = this.crmVocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlApplDt = this.clmStlApplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmTpCd = this.cgoClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclXchRt = this.clmtLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtRefNo = this.clmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclAmt = this.clmtLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsFlg = this.trnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrCgoClmStsCd = this.bfrCgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvUsrId = this.fmalClmRcvUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmPtyNo = this.clmtClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzRopnFlg = this.csClzRopnFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtDesc = this.clmtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnApntDt = this.clmtAgnApntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlApplOfcCd = this.clmStlApplOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzRopnUsrId = this.csClzRopnUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthDt = this.clmStlAuthDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRcvOfcCd = this.cgoClmRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsCd = this.cgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmRvwDesc = this.clmRvwDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.factFndDesc = this.factFndDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzRopnDt = this.csClzRopnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnClmPtyNo = this.agnClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmSuitFlg = this.cgoClmSuitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnTpCd = this.clmtAgnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlAuthUsrId = this.clmStlAuthUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmTpCd = this.clmtClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.factFndDt = this.factFndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzOfcCd = this.csClzOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmBarDt = this.tmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmInciNo = this.cgoClmInciNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlApplUsrId = this.clmStlApplUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnRefNo = this.clmtAgnRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmClzCd = this.cgoClmClzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
