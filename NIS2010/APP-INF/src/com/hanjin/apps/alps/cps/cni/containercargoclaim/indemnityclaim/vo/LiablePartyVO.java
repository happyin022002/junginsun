/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : LiablePartyVO.java
*@FileTitle : LiablePartyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.15
*@LastModifier : 박제성
*@LastVersion : 1.0
* 2009.12.15 박제성 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.indemnityclaim.vo;

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

public class LiablePartyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<LiablePartyVO> models = new ArrayList<LiablePartyVO>();
	
	/* Column Info */
	private String smnsSveDt = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String clmCgoTpCd = null;
	/* Column Info */
	private String hndlOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String lablPtyClmRmk = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String lablPtyPrlmClmNtfyDt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String lablPtyDmndAmt = null;
	/* Column Info */
	private String cgoClmRefBlNo = null;
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
	private String delCd = null;
	/* Column Info */
	private String clmtLoclCurrCd = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Column Info */
	private String hpc = null;
	/* Column Info */
	private String clmMiscNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cgoClmStlLoclCurrCd = null;
	/* Column Info */
	private String clmPtyNo = null;
	/* Column Info */
	private String cgoClmStlTpCd = null;
	/* Column Info */
	private String clmTmBarDt = null;
	/* Column Info */
	private String n3rdLablPtyCd = null;
	/* Column Info */
	private String clmtUsdAmt = null;
	/* Column Info */
	private String crmVocNo = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String lablPtyRcvrLoclCurrCd = null;
	/* Column Info */
	private String lablPtyFmalClmDt = null;
	/* Column Info */
	private String cgoClmTpCd = null;
	/* Column Info */
	private String lablPtyRcvrLoclXchRt = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String clmMiscCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cgoClmStlXchRt = null;
	/* Column Info */
	private String clmtLoclXchRt = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String clmtLoclAmt = null;
	/* Column Info */
	private String lablPtyRcvrUsdAmt = null;
	/* Column Info */
	private String deDt = null;
	/* Column Info */
	private String ptyNm = null;
	/* Column Info */
	private String lablPtyDmndUsdAmt = null;
	/* Column Info */
	private String lablPtyDmndCurrCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String crrTermCd = null;
	/* Column Info */
	private String cgoClmStlUsdAmt = null;
	/* Column Info */
	private String clmPtyAbbrNm = null;
	/* Column Info */
	private String lablPtyRcvrDt = null;
	/* Column Info */
	private String lablPtyRcvrLoclAmt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cgoClmStlDt = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String tmBarDt = null;
	/* Column Info */
	private String rctDt = null;
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
	
	public LiablePartyVO() {}

	public LiablePartyVO(String ibflag, String pagerows, String cgoClmNo, String clmAreaCd, String hdlrOfcCd, String hdlrUsrId, String updDt, String cgoClmInciNo, String crmVocNo, String clmMiscCd, String clmMiscNm, String hpc, String nhp, String cgoClmStlTpCd, String csClzDt, String clmTmBarDt, String smnsSveDt, String cgoClmRefBlNo, String crrTermCd, String porCd, String rctDt, String polCd, String podCd, String delCd, String deDt, String cgoClmTpCd, String mjrClmDmgLssCd, String n3rdLablPtyCd, String inciPlcTpCd, String inciOccrDt, String clmCgoTpCd, String cgoQltyDesc, String clmtLoclAmt, String clmtLoclCurrCd, String fmalClmRcvDt, String clmtLoclXchRt, String clmtUsdAmt, String cgoClmStlLoclAmt, String cgoClmStlLoclCurrCd, String cgoClmStlDt, String cgoClmStlXchRt, String cgoClmStlUsdAmt, String clmPtyNo, String clmPtyAbbrNm, String ptyNm, String hndlOfcCd, String lablPtyPrlmClmNtfyDt, String tmBarDt, String lablPtyDmndAmt, String lablPtyDmndCurrCd, String lablPtyFmalClmDt, String lablPtyXchRt, String lablPtyDmndUsdAmt, String lablPtyRcvrLoclAmt, String lablPtyRcvrLoclCurrCd, String lablPtyRcvrDt, String lablPtyRcvrLoclXchRt, String lablPtyRcvrUsdAmt, String lablPtyClmRmk, String updUsrId) {
		this.smnsSveDt = smnsSveDt;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.clmCgoTpCd = clmCgoTpCd;
		this.hndlOfcCd = hndlOfcCd;
		this.pagerows = pagerows;
		this.lablPtyClmRmk = lablPtyClmRmk;
		this.polCd = polCd;
		this.lablPtyPrlmClmNtfyDt = lablPtyPrlmClmNtfyDt;
		this.cgoClmNo = cgoClmNo;
		this.lablPtyDmndAmt = lablPtyDmndAmt;
		this.cgoClmRefBlNo = cgoClmRefBlNo;
		this.updUsrId = updUsrId;
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
		this.nhp = nhp;
		this.cgoClmStlLoclAmt = cgoClmStlLoclAmt;
		this.lablPtyXchRt = lablPtyXchRt;
		this.delCd = delCd;
		this.clmtLoclCurrCd = clmtLoclCurrCd;
		this.inciOccrDt = inciOccrDt;
		this.hpc = hpc;
		this.clmMiscNm = clmMiscNm;
		this.podCd = podCd;
		this.cgoClmStlLoclCurrCd = cgoClmStlLoclCurrCd;
		this.clmPtyNo = clmPtyNo;
		this.cgoClmStlTpCd = cgoClmStlTpCd;
		this.clmTmBarDt = clmTmBarDt;
		this.n3rdLablPtyCd = n3rdLablPtyCd;
		this.clmtUsdAmt = clmtUsdAmt;
		this.crmVocNo = crmVocNo;
		this.inciPlcTpCd = inciPlcTpCd;
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
		this.lablPtyFmalClmDt = lablPtyFmalClmDt;
		this.cgoClmTpCd = cgoClmTpCd;
		this.lablPtyRcvrLoclXchRt = lablPtyRcvrLoclXchRt;
		this.hdlrOfcCd = hdlrOfcCd;
		this.clmMiscCd = clmMiscCd;
		this.porCd = porCd;
		this.cgoClmStlXchRt = cgoClmStlXchRt;
		this.clmtLoclXchRt = clmtLoclXchRt;
		this.csClzDt = csClzDt;
		this.clmtLoclAmt = clmtLoclAmt;
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
		this.deDt = deDt;
		this.ptyNm = ptyNm;
		this.lablPtyDmndUsdAmt = lablPtyDmndUsdAmt;
		this.lablPtyDmndCurrCd = lablPtyDmndCurrCd;
		this.ibflag = ibflag;
		this.crrTermCd = crrTermCd;
		this.cgoClmStlUsdAmt = cgoClmStlUsdAmt;
		this.clmPtyAbbrNm = clmPtyAbbrNm;
		this.lablPtyRcvrDt = lablPtyRcvrDt;
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
		this.updDt = updDt;
		this.cgoClmStlDt = cgoClmStlDt;
		this.hdlrUsrId = hdlrUsrId;
		this.tmBarDt = tmBarDt;
		this.rctDt = rctDt;
		this.cgoClmInciNo = cgoClmInciNo;
		this.clmAreaCd = clmAreaCd;
		this.cgoQltyDesc = cgoQltyDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("smns_sve_dt", getSmnsSveDt());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("clm_cgo_tp_cd", getClmCgoTpCd());
		this.hashColumns.put("hndl_ofc_cd", getHndlOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("labl_pty_clm_rmk", getLablPtyClmRmk());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("labl_pty_prlm_clm_ntfy_dt", getLablPtyPrlmClmNtfyDt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("labl_pty_dmnd_amt", getLablPtyDmndAmt());
		this.hashColumns.put("cgo_clm_ref_bl_no", getCgoClmRefBlNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mjr_clm_dmg_lss_cd", getMjrClmDmgLssCd());
		this.hashColumns.put("nhp", getNhp());
		this.hashColumns.put("cgo_clm_stl_locl_amt", getCgoClmStlLoclAmt());
		this.hashColumns.put("labl_pty_xch_rt", getLablPtyXchRt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("clmt_locl_curr_cd", getClmtLoclCurrCd());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("hpc", getHpc());
		this.hashColumns.put("clm_misc_nm", getClmMiscNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cgo_clm_stl_locl_curr_cd", getCgoClmStlLoclCurrCd());
		this.hashColumns.put("clm_pty_no", getClmPtyNo());
		this.hashColumns.put("cgo_clm_stl_tp_cd", getCgoClmStlTpCd());
		this.hashColumns.put("clm_tm_bar_dt", getClmTmBarDt());
		this.hashColumns.put("n3rd_labl_pty_cd", getN3rdLablPtyCd());
		this.hashColumns.put("clmt_usd_amt", getClmtUsdAmt());
		this.hashColumns.put("crm_voc_no", getCrmVocNo());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("labl_pty_rcvr_locl_curr_cd", getLablPtyRcvrLoclCurrCd());
		this.hashColumns.put("labl_pty_fmal_clm_dt", getLablPtyFmalClmDt());
		this.hashColumns.put("cgo_clm_tp_cd", getCgoClmTpCd());
		this.hashColumns.put("labl_pty_rcvr_locl_xch_rt", getLablPtyRcvrLoclXchRt());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("clm_misc_cd", getClmMiscCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cgo_clm_stl_xch_rt", getCgoClmStlXchRt());
		this.hashColumns.put("clmt_locl_xch_rt", getClmtLoclXchRt());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("clmt_locl_amt", getClmtLoclAmt());
		this.hashColumns.put("labl_pty_rcvr_usd_amt", getLablPtyRcvrUsdAmt());
		this.hashColumns.put("de_dt", getDeDt());
		this.hashColumns.put("pty_nm", getPtyNm());
		this.hashColumns.put("labl_pty_dmnd_usd_amt", getLablPtyDmndUsdAmt());
		this.hashColumns.put("labl_pty_dmnd_curr_cd", getLablPtyDmndCurrCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("crr_term_cd", getCrrTermCd());
		this.hashColumns.put("cgo_clm_stl_usd_amt", getCgoClmStlUsdAmt());
		this.hashColumns.put("clm_pty_abbr_nm", getClmPtyAbbrNm());
		this.hashColumns.put("labl_pty_rcvr_dt", getLablPtyRcvrDt());
		this.hashColumns.put("labl_pty_rcvr_locl_amt", getLablPtyRcvrLoclAmt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cgo_clm_stl_dt", getCgoClmStlDt());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("tm_bar_dt", getTmBarDt());
		this.hashColumns.put("rct_dt", getRctDt());
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
		this.hashFields.put("smns_sve_dt", "smnsSveDt");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("clm_cgo_tp_cd", "clmCgoTpCd");
		this.hashFields.put("hndl_ofc_cd", "hndlOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("labl_pty_clm_rmk", "lablPtyClmRmk");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("labl_pty_prlm_clm_ntfy_dt", "lablPtyPrlmClmNtfyDt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("labl_pty_dmnd_amt", "lablPtyDmndAmt");
		this.hashFields.put("cgo_clm_ref_bl_no", "cgoClmRefBlNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mjr_clm_dmg_lss_cd", "mjrClmDmgLssCd");
		this.hashFields.put("nhp", "nhp");
		this.hashFields.put("cgo_clm_stl_locl_amt", "cgoClmStlLoclAmt");
		this.hashFields.put("labl_pty_xch_rt", "lablPtyXchRt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("clmt_locl_curr_cd", "clmtLoclCurrCd");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("hpc", "hpc");
		this.hashFields.put("clm_misc_nm", "clmMiscNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cgo_clm_stl_locl_curr_cd", "cgoClmStlLoclCurrCd");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("cgo_clm_stl_tp_cd", "cgoClmStlTpCd");
		this.hashFields.put("clm_tm_bar_dt", "clmTmBarDt");
		this.hashFields.put("n3rd_labl_pty_cd", "n3rdLablPtyCd");
		this.hashFields.put("clmt_usd_amt", "clmtUsdAmt");
		this.hashFields.put("crm_voc_no", "crmVocNo");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("labl_pty_rcvr_locl_curr_cd", "lablPtyRcvrLoclCurrCd");
		this.hashFields.put("labl_pty_fmal_clm_dt", "lablPtyFmalClmDt");
		this.hashFields.put("cgo_clm_tp_cd", "cgoClmTpCd");
		this.hashFields.put("labl_pty_rcvr_locl_xch_rt", "lablPtyRcvrLoclXchRt");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("clm_misc_cd", "clmMiscCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cgo_clm_stl_xch_rt", "cgoClmStlXchRt");
		this.hashFields.put("clmt_locl_xch_rt", "clmtLoclXchRt");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("clmt_locl_amt", "clmtLoclAmt");
		this.hashFields.put("labl_pty_rcvr_usd_amt", "lablPtyRcvrUsdAmt");
		this.hashFields.put("de_dt", "deDt");
		this.hashFields.put("pty_nm", "ptyNm");
		this.hashFields.put("labl_pty_dmnd_usd_amt", "lablPtyDmndUsdAmt");
		this.hashFields.put("labl_pty_dmnd_curr_cd", "lablPtyDmndCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("crr_term_cd", "crrTermCd");
		this.hashFields.put("cgo_clm_stl_usd_amt", "cgoClmStlUsdAmt");
		this.hashFields.put("clm_pty_abbr_nm", "clmPtyAbbrNm");
		this.hashFields.put("labl_pty_rcvr_dt", "lablPtyRcvrDt");
		this.hashFields.put("labl_pty_rcvr_locl_amt", "lablPtyRcvrLoclAmt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cgo_clm_stl_dt", "cgoClmStlDt");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("tm_bar_dt", "tmBarDt");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("cgo_clm_inci_no", "cgoClmInciNo");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		this.hashFields.put("cgo_qlty_desc", "cgoQltyDesc");
		return this.hashFields;
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
	 * @return lablPtyPrlmClmNtfyDt
	 */
	public String getLablPtyPrlmClmNtfyDt() {
		return this.lablPtyPrlmClmNtfyDt;
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
	 * @return cgoClmRefBlNo
	 */
	public String getCgoClmRefBlNo() {
		return this.cgoClmRefBlNo;
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
	 * @return clmMiscNm
	 */
	public String getClmMiscNm() {
		return this.clmMiscNm;
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
	 * @return lablPtyRcvrLoclCurrCd
	 */
	public String getLablPtyRcvrLoclCurrCd() {
		return this.lablPtyRcvrLoclCurrCd;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
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
	 * @return deDt
	 */
	public String getDeDt() {
		return this.deDt;
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
	 * @return lablPtyDmndCurrCd
	 */
	public String getLablPtyDmndCurrCd() {
		return this.lablPtyDmndCurrCd;
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
	 * @return crrTermCd
	 */
	public String getCrrTermCd() {
		return this.crrTermCd;
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
	 * @return cgoClmStlDt
	 */
	public String getCgoClmStlDt() {
		return this.cgoClmStlDt;
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
	 * @return rctDt
	 */
	public String getRctDt() {
		return this.rctDt;
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
	 * @param lablPtyPrlmClmNtfyDt
	 */
	public void setLablPtyPrlmClmNtfyDt(String lablPtyPrlmClmNtfyDt) {
		this.lablPtyPrlmClmNtfyDt = lablPtyPrlmClmNtfyDt;
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
	 * @param cgoClmRefBlNo
	 */
	public void setCgoClmRefBlNo(String cgoClmRefBlNo) {
		this.cgoClmRefBlNo = cgoClmRefBlNo;
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
	 * @param clmMiscNm
	 */
	public void setClmMiscNm(String clmMiscNm) {
		this.clmMiscNm = clmMiscNm;
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
	 * @param lablPtyRcvrLoclCurrCd
	 */
	public void setLablPtyRcvrLoclCurrCd(String lablPtyRcvrLoclCurrCd) {
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
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
	 * @param deDt
	 */
	public void setDeDt(String deDt) {
		this.deDt = deDt;
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
	 * @param lablPtyDmndCurrCd
	 */
	public void setLablPtyDmndCurrCd(String lablPtyDmndCurrCd) {
		this.lablPtyDmndCurrCd = lablPtyDmndCurrCd;
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
	 * @param crrTermCd
	 */
	public void setCrrTermCd(String crrTermCd) {
		this.crrTermCd = crrTermCd;
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
	 * @param cgoClmStlDt
	 */
	public void setCgoClmStlDt(String cgoClmStlDt) {
		this.cgoClmStlDt = cgoClmStlDt;
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
	 * @param rctDt
	 */
	public void setRctDt(String rctDt) {
		this.rctDt = rctDt;
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
		setSmnsSveDt(JSPUtil.getParameter(request, "smns_sve_dt", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, "fmal_clm_rcv_dt", ""));
		setClmCgoTpCd(JSPUtil.getParameter(request, "clm_cgo_tp_cd", ""));
		setHndlOfcCd(JSPUtil.getParameter(request, "hndl_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLablPtyClmRmk(JSPUtil.getParameter(request, "labl_pty_clm_rmk", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setLablPtyPrlmClmNtfyDt(JSPUtil.getParameter(request, "labl_pty_prlm_clm_ntfy_dt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, "cgo_clm_no", ""));
		setLablPtyDmndAmt(JSPUtil.getParameter(request, "labl_pty_dmnd_amt", ""));
		setCgoClmRefBlNo(JSPUtil.getParameter(request, "cgo_clm_ref_bl_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMjrClmDmgLssCd(JSPUtil.getParameter(request, "mjr_clm_dmg_lss_cd", ""));
		setNhp(JSPUtil.getParameter(request, "nhp", ""));
		setCgoClmStlLoclAmt(JSPUtil.getParameter(request, "cgo_clm_stl_locl_amt", ""));
		setLablPtyXchRt(JSPUtil.getParameter(request, "labl_pty_xch_rt", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setClmtLoclCurrCd(JSPUtil.getParameter(request, "clmt_locl_curr_cd", ""));
		setInciOccrDt(JSPUtil.getParameter(request, "inci_occr_dt", ""));
		setHpc(JSPUtil.getParameter(request, "hpc", ""));
		setClmMiscNm(JSPUtil.getParameter(request, "clm_misc_nm", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCgoClmStlLoclCurrCd(JSPUtil.getParameter(request, "cgo_clm_stl_locl_curr_cd", ""));
		setClmPtyNo(JSPUtil.getParameter(request, "clm_pty_no", ""));
		setCgoClmStlTpCd(JSPUtil.getParameter(request, "cgo_clm_stl_tp_cd", ""));
		setClmTmBarDt(JSPUtil.getParameter(request, "clm_tm_bar_dt", ""));
		setN3rdLablPtyCd(JSPUtil.getParameter(request, "n3rd_labl_pty_cd", ""));
		setClmtUsdAmt(JSPUtil.getParameter(request, "clmt_usd_amt", ""));
		setCrmVocNo(JSPUtil.getParameter(request, "crm_voc_no", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, "inci_plc_tp_cd", ""));
		setLablPtyRcvrLoclCurrCd(JSPUtil.getParameter(request, "labl_pty_rcvr_locl_curr_cd", ""));
		setLablPtyFmalClmDt(JSPUtil.getParameter(request, "labl_pty_fmal_clm_dt", ""));
		setCgoClmTpCd(JSPUtil.getParameter(request, "cgo_clm_tp_cd", ""));
		setLablPtyRcvrLoclXchRt(JSPUtil.getParameter(request, "labl_pty_rcvr_locl_xch_rt", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, "hdlr_ofc_cd", ""));
		setClmMiscCd(JSPUtil.getParameter(request, "clm_misc_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setCgoClmStlXchRt(JSPUtil.getParameter(request, "cgo_clm_stl_xch_rt", ""));
		setClmtLoclXchRt(JSPUtil.getParameter(request, "clmt_locl_xch_rt", ""));
		setCsClzDt(JSPUtil.getParameter(request, "cs_clz_dt", ""));
		setClmtLoclAmt(JSPUtil.getParameter(request, "clmt_locl_amt", ""));
		setLablPtyRcvrUsdAmt(JSPUtil.getParameter(request, "labl_pty_rcvr_usd_amt", ""));
		setDeDt(JSPUtil.getParameter(request, "de_dt", ""));
		setPtyNm(JSPUtil.getParameter(request, "pty_nm", ""));
		setLablPtyDmndUsdAmt(JSPUtil.getParameter(request, "labl_pty_dmnd_usd_amt", ""));
		setLablPtyDmndCurrCd(JSPUtil.getParameter(request, "labl_pty_dmnd_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCrrTermCd(JSPUtil.getParameter(request, "crr_term_cd", ""));
		setCgoClmStlUsdAmt(JSPUtil.getParameter(request, "cgo_clm_stl_usd_amt", ""));
		setClmPtyAbbrNm(JSPUtil.getParameter(request, "clm_pty_abbr_nm", ""));
		setLablPtyRcvrDt(JSPUtil.getParameter(request, "labl_pty_rcvr_dt", ""));
		setLablPtyRcvrLoclAmt(JSPUtil.getParameter(request, "labl_pty_rcvr_locl_amt", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCgoClmStlDt(JSPUtil.getParameter(request, "cgo_clm_stl_dt", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, "hdlr_usr_id", ""));
		setTmBarDt(JSPUtil.getParameter(request, "tm_bar_dt", ""));
		setRctDt(JSPUtil.getParameter(request, "rct_dt", ""));
		setCgoClmInciNo(JSPUtil.getParameter(request, "cgo_clm_inci_no", ""));
		setClmAreaCd(JSPUtil.getParameter(request, "clm_area_cd", ""));
		setCgoQltyDesc(JSPUtil.getParameter(request, "cgo_qlty_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LiablePartyVO[]
	 */
	public LiablePartyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return LiablePartyVO[]
	 */
	public LiablePartyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		LiablePartyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] smnsSveDt = (JSPUtil.getParameter(request, prefix	+ "smns_sve_dt", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] clmCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_cgo_tp_cd", length));
			String[] hndlOfcCd = (JSPUtil.getParameter(request, prefix	+ "hndl_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] lablPtyClmRmk = (JSPUtil.getParameter(request, prefix	+ "labl_pty_clm_rmk", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] lablPtyPrlmClmNtfyDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_prlm_clm_ntfy_dt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] lablPtyDmndAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_amt", length));
			String[] cgoClmRefBlNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_bl_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mjrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "mjr_clm_dmg_lss_cd", length));
			String[] nhp = (JSPUtil.getParameter(request, prefix	+ "nhp", length));
			String[] cgoClmStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_amt", length));
			String[] lablPtyXchRt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_xch_rt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] clmtLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_curr_cd", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] hpc = (JSPUtil.getParameter(request, prefix	+ "hpc", length));
			String[] clmMiscNm = (JSPUtil.getParameter(request, prefix	+ "clm_misc_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cgoClmStlLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_locl_curr_cd", length));
			String[] clmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_pty_no", length));
			String[] cgoClmStlTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_tp_cd", length));
			String[] clmTmBarDt = (JSPUtil.getParameter(request, prefix	+ "clm_tm_bar_dt", length));
			String[] n3rdLablPtyCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_labl_pty_cd", length));
			String[] clmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_usd_amt", length));
			String[] crmVocNo = (JSPUtil.getParameter(request, prefix	+ "crm_voc_no", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] lablPtyRcvrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_curr_cd", length));
			String[] lablPtyFmalClmDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_fmal_clm_dt", length));
			String[] cgoClmTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_tp_cd", length));
			String[] lablPtyRcvrLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_xch_rt", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] clmMiscCd = (JSPUtil.getParameter(request, prefix	+ "clm_misc_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cgoClmStlXchRt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_xch_rt", length));
			String[] clmtLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_xch_rt", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] clmtLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_amt", length));
			String[] lablPtyRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_usd_amt", length));
			String[] deDt = (JSPUtil.getParameter(request, prefix	+ "de_dt", length));
			String[] ptyNm = (JSPUtil.getParameter(request, prefix	+ "pty_nm", length));
			String[] lablPtyDmndUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_usd_amt", length));
			String[] lablPtyDmndCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_curr_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] crrTermCd = (JSPUtil.getParameter(request, prefix	+ "crr_term_cd", length));
			String[] cgoClmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_usd_amt", length));
			String[] clmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clm_pty_abbr_nm", length));
			String[] lablPtyRcvrDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_dt", length));
			String[] lablPtyRcvrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_amt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cgoClmStlDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_dt", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] tmBarDt = (JSPUtil.getParameter(request, prefix	+ "tm_bar_dt", length));
			String[] rctDt = (JSPUtil.getParameter(request, prefix	+ "rct_dt", length));
			String[] cgoClmInciNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_inci_no", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			String[] cgoQltyDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_qlty_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new LiablePartyVO();
				if (smnsSveDt[i] != null)
					model.setSmnsSveDt(smnsSveDt[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (clmCgoTpCd[i] != null)
					model.setClmCgoTpCd(clmCgoTpCd[i]);
				if (hndlOfcCd[i] != null)
					model.setHndlOfcCd(hndlOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (lablPtyClmRmk[i] != null)
					model.setLablPtyClmRmk(lablPtyClmRmk[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (lablPtyPrlmClmNtfyDt[i] != null)
					model.setLablPtyPrlmClmNtfyDt(lablPtyPrlmClmNtfyDt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (lablPtyDmndAmt[i] != null)
					model.setLablPtyDmndAmt(lablPtyDmndAmt[i]);
				if (cgoClmRefBlNo[i] != null)
					model.setCgoClmRefBlNo(cgoClmRefBlNo[i]);
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
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (clmtLoclCurrCd[i] != null)
					model.setClmtLoclCurrCd(clmtLoclCurrCd[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (hpc[i] != null)
					model.setHpc(hpc[i]);
				if (clmMiscNm[i] != null)
					model.setClmMiscNm(clmMiscNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cgoClmStlLoclCurrCd[i] != null)
					model.setCgoClmStlLoclCurrCd(cgoClmStlLoclCurrCd[i]);
				if (clmPtyNo[i] != null)
					model.setClmPtyNo(clmPtyNo[i]);
				if (cgoClmStlTpCd[i] != null)
					model.setCgoClmStlTpCd(cgoClmStlTpCd[i]);
				if (clmTmBarDt[i] != null)
					model.setClmTmBarDt(clmTmBarDt[i]);
				if (n3rdLablPtyCd[i] != null)
					model.setN3rdLablPtyCd(n3rdLablPtyCd[i]);
				if (clmtUsdAmt[i] != null)
					model.setClmtUsdAmt(clmtUsdAmt[i]);
				if (crmVocNo[i] != null)
					model.setCrmVocNo(crmVocNo[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (lablPtyRcvrLoclCurrCd[i] != null)
					model.setLablPtyRcvrLoclCurrCd(lablPtyRcvrLoclCurrCd[i]);
				if (lablPtyFmalClmDt[i] != null)
					model.setLablPtyFmalClmDt(lablPtyFmalClmDt[i]);
				if (cgoClmTpCd[i] != null)
					model.setCgoClmTpCd(cgoClmTpCd[i]);
				if (lablPtyRcvrLoclXchRt[i] != null)
					model.setLablPtyRcvrLoclXchRt(lablPtyRcvrLoclXchRt[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (clmMiscCd[i] != null)
					model.setClmMiscCd(clmMiscCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cgoClmStlXchRt[i] != null)
					model.setCgoClmStlXchRt(cgoClmStlXchRt[i]);
				if (clmtLoclXchRt[i] != null)
					model.setClmtLoclXchRt(clmtLoclXchRt[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (clmtLoclAmt[i] != null)
					model.setClmtLoclAmt(clmtLoclAmt[i]);
				if (lablPtyRcvrUsdAmt[i] != null)
					model.setLablPtyRcvrUsdAmt(lablPtyRcvrUsdAmt[i]);
				if (deDt[i] != null)
					model.setDeDt(deDt[i]);
				if (ptyNm[i] != null)
					model.setPtyNm(ptyNm[i]);
				if (lablPtyDmndUsdAmt[i] != null)
					model.setLablPtyDmndUsdAmt(lablPtyDmndUsdAmt[i]);
				if (lablPtyDmndCurrCd[i] != null)
					model.setLablPtyDmndCurrCd(lablPtyDmndCurrCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (crrTermCd[i] != null)
					model.setCrrTermCd(crrTermCd[i]);
				if (cgoClmStlUsdAmt[i] != null)
					model.setCgoClmStlUsdAmt(cgoClmStlUsdAmt[i]);
				if (clmPtyAbbrNm[i] != null)
					model.setClmPtyAbbrNm(clmPtyAbbrNm[i]);
				if (lablPtyRcvrDt[i] != null)
					model.setLablPtyRcvrDt(lablPtyRcvrDt[i]);
				if (lablPtyRcvrLoclAmt[i] != null)
					model.setLablPtyRcvrLoclAmt(lablPtyRcvrLoclAmt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cgoClmStlDt[i] != null)
					model.setCgoClmStlDt(cgoClmStlDt[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (tmBarDt[i] != null)
					model.setTmBarDt(tmBarDt[i]);
				if (rctDt[i] != null)
					model.setRctDt(rctDt[i]);
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
		return getLiablePartyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return LiablePartyVO[]
	 */
	public LiablePartyVO[] getLiablePartyVOs(){
		LiablePartyVO[] vos = (LiablePartyVO[])models.toArray(new LiablePartyVO[models.size()]);
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
		this.smnsSveDt = this.smnsSveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCgoTpCd = this.clmCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hndlOfcCd = this.hndlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyClmRmk = this.lablPtyClmRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyPrlmClmNtfyDt = this.lablPtyPrlmClmNtfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndAmt = this.lablPtyDmndAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefBlNo = this.cgoClmRefBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrClmDmgLssCd = this.mjrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nhp = this.nhp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclAmt = this.cgoClmStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyXchRt = this.lablPtyXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclCurrCd = this.clmtLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hpc = this.hpc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscNm = this.clmMiscNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlLoclCurrCd = this.cgoClmStlLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo = this.clmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlTpCd = this.cgoClmStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmTmBarDt = this.clmTmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLablPtyCd = this.n3rdLablPtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtUsdAmt = this.clmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crmVocNo = this.crmVocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclCurrCd = this.lablPtyRcvrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFmalClmDt = this.lablPtyFmalClmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmTpCd = this.cgoClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclXchRt = this.lablPtyRcvrLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmMiscCd = this.clmMiscCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlXchRt = this.cgoClmStlXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclXchRt = this.clmtLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclAmt = this.clmtLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrUsdAmt = this.lablPtyRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDt = this.deDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyNm = this.ptyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndUsdAmt = this.lablPtyDmndUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndCurrCd = this.lablPtyDmndCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrTermCd = this.crrTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlUsdAmt = this.cgoClmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm = this.clmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrDt = this.lablPtyRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclAmt = this.lablPtyRcvrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlDt = this.cgoClmStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmBarDt = this.tmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt = this.rctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmInciNo = this.cgoClmInciNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoQltyDesc = this.cgoQltyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
