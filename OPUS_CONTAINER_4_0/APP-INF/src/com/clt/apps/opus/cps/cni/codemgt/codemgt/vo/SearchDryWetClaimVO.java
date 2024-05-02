/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchDryWetClaimVO.java
*@FileTitle : SearchDryWetClaimVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.23
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.04.23 정행룡 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.cps.cni.codemgt.codemgt.vo;

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

public class SearchDryWetClaimVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchDryWetClaimVO> models = new ArrayList<SearchDryWetClaimVO>();
	
	/* Column Info */
	private String inciDevDesc = null;
	/* Column Info */
	private String insurRcvrUsdAmt = null;
	/* Column Info */
	private String clmStlXchRt = null;
	/* Column Info */
	private String lablPtyClmPtyNo = null;
	/* Column Info */
	private String deftAgnTelNo = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String deftClmPtyNm = null;
	/* Column Info */
	private String clmStlLoclCurrCd = null;
	/* Column Info */
	private String lablPtyClmPtyNm = null;
	/* Column Info */
	private String deftAgnEmail = null;
	/* Column Info */
	private String clmLoclAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String clmtAgnClmPtyNm = null;
	/* Column Info */
	private String clmtAgnClmPtyNo = null;
	/* Column Info */
	private String deftCtnt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String lablPtyCtnt = null;
	/* Column Info */
	private String lablPtyFileDt = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String lablPtyFileXchRt = null;
	/* Column Info */
	private String clmtAgnEmail = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Column Info */
	private String clmUsdAmt = null;
	/* Column Info */
	private String clmtAgnTelNo = null;
	/* Column Info */
	private String insurRcvrXchRt = null;
	/* Column Info */
	private String insurFileLoclAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String deftAgnRefNo = null;
	/* Column Info */
	private String dwCoCd = null;
	/* Column Info */
	private String dwClmAttDefTpCd = null;
	/* Column Info */
	private String deftAgnTpCd = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String insurFileLoclCurrCd = null;
	/* Column Info */
	private String lablPtyRcvrLoclCurrCd = null;
	/* Column Info */
	private String insurRcvrDt = null;
	/* Column Info */
	private String insurClmPtyNm = null;
	/* Column Info */
	private String rHandler = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String clmStlDt = null;
	/* Column Info */
	private String insurFileXchRt = null;
	/* Column Info */
	private String clmTrnsAuthCd = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String trnsFlg = null;
	/* Column Info */
	private String hdlrStlOpinDesc = null;
	/* Column Info */
	private String lablPtyRcvrUsdAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dwClmCsDesc = null;
	/* Column Info */
	private String clmtClmPtyNm = null;
	/* Column Info */
	private String clmtClmPtyNo = null;
	/* Column Info */
	private String lablPtyFileUsdAmt = null;
	/* Column Info */
	private String ddctUsdAmt = null;
	/* Column Info */
	private String clmStlUsdAmt = null;
	/* Column Info */
	private String lablPtyFileLoclCurrCd = null;
	/* Column Info */
	private String dwClmTpCd = null;
	/* Column Info */
	private String deftAgnApntDt = null;
	/* Column Info */
	private String clmtAgnApntDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String insurFileUsdAmt = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String lablPtyRcvrDt = null;
	/* Column Info */
	private String clmStlLoclAmt = null;
	/* Column Info */
	private String lablPtyRcvrLoclAmt = null;
	/* Column Info */
	private String lablPtyTmBarDt = null;
	/* Column Info */
	private String lablPtyRcvrXchRt = null;
	/* Column Info */
	private String dwClmRefVvdNo = null;
	/* Column Info */
	private String clmLoclCurrCd = null;
	/* Column Info */
	private String deftClmPtyNo = null;
	/* Column Info */
	private String litDt = null;
	/* Column Info */
	private String lablPtyFileLoclAmt = null;
	/* Column Info */
	private String insurFileDt = null;
	/* Column Info */
	private String clmtAgnTpCd = null;
	/* Column Info */
	private String insurRcvrLoclCurrCd = null;
	/* Column Info */
	private String insurRcvrLoclAmt = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String arbtDt = null;
	/* Column Info */
	private String clmtCtnt = null;
	/* Column Info */
	private String tmBarDt = null;
	/* Column Info */
	private String prlmClmNtfyDt = null;
	/* Column Info */
	private String dwClmStsCd = null;
	/* Column Info */
	private String deftAgnClmPtyNm = null;
	/* Column Info */
	private String deftAgnClmPtyNo = null;
	/* Column Info */
	private String clmtAgnRefNo = null;
	/* Column Info */
	private String clmXchRt = null;
	/* Column Info */
	private String dwClmNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchDryWetClaimVO() {}

	public SearchDryWetClaimVO(String ibflag, String pagerows, String dwClmNo, String dwClmTpCd, String dwCoCd, String dwClmRefVvdNo, String vslEngNm, String inciPlcTpCd, String inciOccrDt, String creOfcCd, String hdlrOfcCd, String hdlrUsrId, String tmBarDt, String litDt, String dwClmStsCd, String dwClmAttDefTpCd, String prlmClmNtfyDt, String csClzDt, String arbtDt, String clmtClmPtyNo, String clmtClmPtyNm, String clmtCtnt, String insurClmPtyNo, String insurClmPtyNm, String ddctUsdAmt, String deftClmPtyNo, String deftClmPtyNm, String deftCtnt, String lablPtyClmPtyNo, String lablPtyClmPtyNm, String lablPtyCtnt, String lablPtyTmBarDt, String clmLoclCurrCd, String clmLoclAmt, String fmalClmRcvDt, String clmXchRt, String clmUsdAmt, String clmStlLoclCurrCd, String clmStlLoclAmt, String clmStlDt, String clmStlXchRt, String clmStlUsdAmt, String lablPtyFileLoclCurrCd, String lablPtyFileLoclAmt, String lablPtyFileDt, String lablPtyFileXchRt, String lablPtyFileUsdAmt, String lablPtyRcvrLoclCurrCd, String lablPtyRcvrLoclAmt, String lablPtyRcvrDt, String lablPtyRcvrXchRt, String lablPtyRcvrUsdAmt, String insurFileLoclCurrCd, String insurFileLoclAmt, String insurFileDt, String insurFileXchRt, String insurFileUsdAmt, String insurRcvrLoclCurrCd, String insurRcvrLoclAmt, String insurRcvrDt, String insurRcvrXchRt, String insurRcvrUsdAmt, String dwClmCsDesc, String inciDevDesc, String hdlrStlOpinDesc, String clmtAgnClmPtyNo, String clmtAgnClmPtyNm, String clmtAgnTelNo, String clmtAgnEmail, String clmtAgnTpCd, String clmtAgnApntDt, String clmtAgnRefNo, String deftAgnClmPtyNo, String deftAgnClmPtyNm, String deftAgnTelNo, String deftAgnEmail, String deftAgnTpCd, String deftAgnApntDt, String deftAgnRefNo, String trnsFlg, String clmTrnsAuthCd, String trnsSeq, String creUsrId, String creDt, String updUsrId, String updDt, String rHandler) {
		this.inciDevDesc = inciDevDesc;
		this.insurRcvrUsdAmt = insurRcvrUsdAmt;
		this.clmStlXchRt = clmStlXchRt;
		this.lablPtyClmPtyNo = lablPtyClmPtyNo;
		this.deftAgnTelNo = deftAgnTelNo;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.deftClmPtyNm = deftClmPtyNm;
		this.clmStlLoclCurrCd = clmStlLoclCurrCd;
		this.lablPtyClmPtyNm = lablPtyClmPtyNm;
		this.deftAgnEmail = deftAgnEmail;
		this.clmLoclAmt = clmLoclAmt;
		this.pagerows = pagerows;
		this.clmtAgnClmPtyNm = clmtAgnClmPtyNm;
		this.clmtAgnClmPtyNo = clmtAgnClmPtyNo;
		this.deftCtnt = deftCtnt;
		this.updUsrId = updUsrId;
		this.lablPtyCtnt = lablPtyCtnt;
		this.lablPtyFileDt = lablPtyFileDt;
		this.trnsSeq = trnsSeq;
		this.lablPtyFileXchRt = lablPtyFileXchRt;
		this.clmtAgnEmail = clmtAgnEmail;
		this.inciOccrDt = inciOccrDt;
		this.clmUsdAmt = clmUsdAmt;
		this.clmtAgnTelNo = clmtAgnTelNo;
		this.insurRcvrXchRt = insurRcvrXchRt;
		this.insurFileLoclAmt = insurFileLoclAmt;
		this.creUsrId = creUsrId;
		this.deftAgnRefNo = deftAgnRefNo;
		this.dwCoCd = dwCoCd;
		this.dwClmAttDefTpCd = dwClmAttDefTpCd;
		this.deftAgnTpCd = deftAgnTpCd;
		this.insurClmPtyNo = insurClmPtyNo;
		this.inciPlcTpCd = inciPlcTpCd;
		this.insurFileLoclCurrCd = insurFileLoclCurrCd;
		this.lablPtyRcvrLoclCurrCd = lablPtyRcvrLoclCurrCd;
		this.insurRcvrDt = insurRcvrDt;
		this.insurClmPtyNm = insurClmPtyNm;
		this.rHandler = rHandler;
		this.hdlrOfcCd = hdlrOfcCd;
		this.clmStlDt = clmStlDt;
		this.insurFileXchRt = insurFileXchRt;
		this.clmTrnsAuthCd = clmTrnsAuthCd;
		this.csClzDt = csClzDt;
		this.trnsFlg = trnsFlg;
		this.hdlrStlOpinDesc = hdlrStlOpinDesc;
		this.lablPtyRcvrUsdAmt = lablPtyRcvrUsdAmt;
		this.creDt = creDt;
		this.dwClmCsDesc = dwClmCsDesc;
		this.clmtClmPtyNm = clmtClmPtyNm;
		this.clmtClmPtyNo = clmtClmPtyNo;
		this.lablPtyFileUsdAmt = lablPtyFileUsdAmt;
		this.ddctUsdAmt = ddctUsdAmt;
		this.clmStlUsdAmt = clmStlUsdAmt;
		this.lablPtyFileLoclCurrCd = lablPtyFileLoclCurrCd;
		this.dwClmTpCd = dwClmTpCd;
		this.deftAgnApntDt = deftAgnApntDt;
		this.clmtAgnApntDt = clmtAgnApntDt;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.insurFileUsdAmt = insurFileUsdAmt;
		this.creOfcCd = creOfcCd;
		this.updDt = updDt;
		this.lablPtyRcvrDt = lablPtyRcvrDt;
		this.clmStlLoclAmt = clmStlLoclAmt;
		this.lablPtyRcvrLoclAmt = lablPtyRcvrLoclAmt;
		this.lablPtyTmBarDt = lablPtyTmBarDt;
		this.lablPtyRcvrXchRt = lablPtyRcvrXchRt;
		this.dwClmRefVvdNo = dwClmRefVvdNo;
		this.clmLoclCurrCd = clmLoclCurrCd;
		this.deftClmPtyNo = deftClmPtyNo;
		this.litDt = litDt;
		this.lablPtyFileLoclAmt = lablPtyFileLoclAmt;
		this.insurFileDt = insurFileDt;
		this.clmtAgnTpCd = clmtAgnTpCd;
		this.insurRcvrLoclCurrCd = insurRcvrLoclCurrCd;
		this.insurRcvrLoclAmt = insurRcvrLoclAmt;
		this.hdlrUsrId = hdlrUsrId;
		this.arbtDt = arbtDt;
		this.clmtCtnt = clmtCtnt;
		this.tmBarDt = tmBarDt;
		this.prlmClmNtfyDt = prlmClmNtfyDt;
		this.dwClmStsCd = dwClmStsCd;
		this.deftAgnClmPtyNm = deftAgnClmPtyNm;
		this.deftAgnClmPtyNo = deftAgnClmPtyNo;
		this.clmtAgnRefNo = clmtAgnRefNo;
		this.clmXchRt = clmXchRt;
		this.dwClmNo = dwClmNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inci_dev_desc", getInciDevDesc());
		this.hashColumns.put("insur_rcvr_usd_amt", getInsurRcvrUsdAmt());
		this.hashColumns.put("clm_stl_xch_rt", getClmStlXchRt());
		this.hashColumns.put("labl_pty_clm_pty_no", getLablPtyClmPtyNo());
		this.hashColumns.put("deft_agn_tel_no", getDeftAgnTelNo());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("deft_clm_pty_nm", getDeftClmPtyNm());
		this.hashColumns.put("clm_stl_locl_curr_cd", getClmStlLoclCurrCd());
		this.hashColumns.put("labl_pty_clm_pty_nm", getLablPtyClmPtyNm());
		this.hashColumns.put("deft_agn_email", getDeftAgnEmail());
		this.hashColumns.put("clm_locl_amt", getClmLoclAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("clmt_agn_clm_pty_nm", getClmtAgnClmPtyNm());
		this.hashColumns.put("clmt_agn_clm_pty_no", getClmtAgnClmPtyNo());
		this.hashColumns.put("deft_ctnt", getDeftCtnt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("labl_pty_ctnt", getLablPtyCtnt());
		this.hashColumns.put("labl_pty_file_dt", getLablPtyFileDt());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("labl_pty_file_xch_rt", getLablPtyFileXchRt());
		this.hashColumns.put("clmt_agn_email", getClmtAgnEmail());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("clm_usd_amt", getClmUsdAmt());
		this.hashColumns.put("clmt_agn_tel_no", getClmtAgnTelNo());
		this.hashColumns.put("insur_rcvr_xch_rt", getInsurRcvrXchRt());
		this.hashColumns.put("insur_file_locl_amt", getInsurFileLoclAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("deft_agn_ref_no", getDeftAgnRefNo());
		this.hashColumns.put("dw_co_cd", getDwCoCd());
		this.hashColumns.put("dw_clm_att_def_tp_cd", getDwClmAttDefTpCd());
		this.hashColumns.put("deft_agn_tp_cd", getDeftAgnTpCd());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("insur_file_locl_curr_cd", getInsurFileLoclCurrCd());
		this.hashColumns.put("labl_pty_rcvr_locl_curr_cd", getLablPtyRcvrLoclCurrCd());
		this.hashColumns.put("insur_rcvr_dt", getInsurRcvrDt());
		this.hashColumns.put("insur_clm_pty_nm", getInsurClmPtyNm());
		this.hashColumns.put("r_handler", getRHandler());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("clm_stl_dt", getClmStlDt());
		this.hashColumns.put("insur_file_xch_rt", getInsurFileXchRt());
		this.hashColumns.put("clm_trns_auth_cd", getClmTrnsAuthCd());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("trns_flg", getTrnsFlg());
		this.hashColumns.put("hdlr_stl_opin_desc", getHdlrStlOpinDesc());
		this.hashColumns.put("labl_pty_rcvr_usd_amt", getLablPtyRcvrUsdAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dw_clm_cs_desc", getDwClmCsDesc());
		this.hashColumns.put("clmt_clm_pty_nm", getClmtClmPtyNm());
		this.hashColumns.put("clmt_clm_pty_no", getClmtClmPtyNo());
		this.hashColumns.put("labl_pty_file_usd_amt", getLablPtyFileUsdAmt());
		this.hashColumns.put("ddct_usd_amt", getDdctUsdAmt());
		this.hashColumns.put("clm_stl_usd_amt", getClmStlUsdAmt());
		this.hashColumns.put("labl_pty_file_locl_curr_cd", getLablPtyFileLoclCurrCd());
		this.hashColumns.put("dw_clm_tp_cd", getDwClmTpCd());
		this.hashColumns.put("deft_agn_apnt_dt", getDeftAgnApntDt());
		this.hashColumns.put("clmt_agn_apnt_dt", getClmtAgnApntDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("insur_file_usd_amt", getInsurFileUsdAmt());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("labl_pty_rcvr_dt", getLablPtyRcvrDt());
		this.hashColumns.put("clm_stl_locl_amt", getClmStlLoclAmt());
		this.hashColumns.put("labl_pty_rcvr_locl_amt", getLablPtyRcvrLoclAmt());
		this.hashColumns.put("labl_pty_tm_bar_dt", getLablPtyTmBarDt());
		this.hashColumns.put("labl_pty_rcvr_xch_rt", getLablPtyRcvrXchRt());
		this.hashColumns.put("dw_clm_ref_vvd_no", getDwClmRefVvdNo());
		this.hashColumns.put("clm_locl_curr_cd", getClmLoclCurrCd());
		this.hashColumns.put("deft_clm_pty_no", getDeftClmPtyNo());
		this.hashColumns.put("lit_dt", getLitDt());
		this.hashColumns.put("labl_pty_file_locl_amt", getLablPtyFileLoclAmt());
		this.hashColumns.put("insur_file_dt", getInsurFileDt());
		this.hashColumns.put("clmt_agn_tp_cd", getClmtAgnTpCd());
		this.hashColumns.put("insur_rcvr_locl_curr_cd", getInsurRcvrLoclCurrCd());
		this.hashColumns.put("insur_rcvr_locl_amt", getInsurRcvrLoclAmt());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("arbt_dt", getArbtDt());
		this.hashColumns.put("clmt_ctnt", getClmtCtnt());
		this.hashColumns.put("tm_bar_dt", getTmBarDt());
		this.hashColumns.put("prlm_clm_ntfy_dt", getPrlmClmNtfyDt());
		this.hashColumns.put("dw_clm_sts_cd", getDwClmStsCd());
		this.hashColumns.put("deft_agn_clm_pty_nm", getDeftAgnClmPtyNm());
		this.hashColumns.put("deft_agn_clm_pty_no", getDeftAgnClmPtyNo());
		this.hashColumns.put("clmt_agn_ref_no", getClmtAgnRefNo());
		this.hashColumns.put("clm_xch_rt", getClmXchRt());
		this.hashColumns.put("dw_clm_no", getDwClmNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inci_dev_desc", "inciDevDesc");
		this.hashFields.put("insur_rcvr_usd_amt", "insurRcvrUsdAmt");
		this.hashFields.put("clm_stl_xch_rt", "clmStlXchRt");
		this.hashFields.put("labl_pty_clm_pty_no", "lablPtyClmPtyNo");
		this.hashFields.put("deft_agn_tel_no", "deftAgnTelNo");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("deft_clm_pty_nm", "deftClmPtyNm");
		this.hashFields.put("clm_stl_locl_curr_cd", "clmStlLoclCurrCd");
		this.hashFields.put("labl_pty_clm_pty_nm", "lablPtyClmPtyNm");
		this.hashFields.put("deft_agn_email", "deftAgnEmail");
		this.hashFields.put("clm_locl_amt", "clmLoclAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("clmt_agn_clm_pty_nm", "clmtAgnClmPtyNm");
		this.hashFields.put("clmt_agn_clm_pty_no", "clmtAgnClmPtyNo");
		this.hashFields.put("deft_ctnt", "deftCtnt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("labl_pty_ctnt", "lablPtyCtnt");
		this.hashFields.put("labl_pty_file_dt", "lablPtyFileDt");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("labl_pty_file_xch_rt", "lablPtyFileXchRt");
		this.hashFields.put("clmt_agn_email", "clmtAgnEmail");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("clm_usd_amt", "clmUsdAmt");
		this.hashFields.put("clmt_agn_tel_no", "clmtAgnTelNo");
		this.hashFields.put("insur_rcvr_xch_rt", "insurRcvrXchRt");
		this.hashFields.put("insur_file_locl_amt", "insurFileLoclAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("deft_agn_ref_no", "deftAgnRefNo");
		this.hashFields.put("dw_co_cd", "dwCoCd");
		this.hashFields.put("dw_clm_att_def_tp_cd", "dwClmAttDefTpCd");
		this.hashFields.put("deft_agn_tp_cd", "deftAgnTpCd");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("insur_file_locl_curr_cd", "insurFileLoclCurrCd");
		this.hashFields.put("labl_pty_rcvr_locl_curr_cd", "lablPtyRcvrLoclCurrCd");
		this.hashFields.put("insur_rcvr_dt", "insurRcvrDt");
		this.hashFields.put("insur_clm_pty_nm", "insurClmPtyNm");
		this.hashFields.put("r_handler", "rHandler");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("clm_stl_dt", "clmStlDt");
		this.hashFields.put("insur_file_xch_rt", "insurFileXchRt");
		this.hashFields.put("clm_trns_auth_cd", "clmTrnsAuthCd");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("trns_flg", "trnsFlg");
		this.hashFields.put("hdlr_stl_opin_desc", "hdlrStlOpinDesc");
		this.hashFields.put("labl_pty_rcvr_usd_amt", "lablPtyRcvrUsdAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dw_clm_cs_desc", "dwClmCsDesc");
		this.hashFields.put("clmt_clm_pty_nm", "clmtClmPtyNm");
		this.hashFields.put("clmt_clm_pty_no", "clmtClmPtyNo");
		this.hashFields.put("labl_pty_file_usd_amt", "lablPtyFileUsdAmt");
		this.hashFields.put("ddct_usd_amt", "ddctUsdAmt");
		this.hashFields.put("clm_stl_usd_amt", "clmStlUsdAmt");
		this.hashFields.put("labl_pty_file_locl_curr_cd", "lablPtyFileLoclCurrCd");
		this.hashFields.put("dw_clm_tp_cd", "dwClmTpCd");
		this.hashFields.put("deft_agn_apnt_dt", "deftAgnApntDt");
		this.hashFields.put("clmt_agn_apnt_dt", "clmtAgnApntDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("insur_file_usd_amt", "insurFileUsdAmt");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("labl_pty_rcvr_dt", "lablPtyRcvrDt");
		this.hashFields.put("clm_stl_locl_amt", "clmStlLoclAmt");
		this.hashFields.put("labl_pty_rcvr_locl_amt", "lablPtyRcvrLoclAmt");
		this.hashFields.put("labl_pty_tm_bar_dt", "lablPtyTmBarDt");
		this.hashFields.put("labl_pty_rcvr_xch_rt", "lablPtyRcvrXchRt");
		this.hashFields.put("dw_clm_ref_vvd_no", "dwClmRefVvdNo");
		this.hashFields.put("clm_locl_curr_cd", "clmLoclCurrCd");
		this.hashFields.put("deft_clm_pty_no", "deftClmPtyNo");
		this.hashFields.put("lit_dt", "litDt");
		this.hashFields.put("labl_pty_file_locl_amt", "lablPtyFileLoclAmt");
		this.hashFields.put("insur_file_dt", "insurFileDt");
		this.hashFields.put("clmt_agn_tp_cd", "clmtAgnTpCd");
		this.hashFields.put("insur_rcvr_locl_curr_cd", "insurRcvrLoclCurrCd");
		this.hashFields.put("insur_rcvr_locl_amt", "insurRcvrLoclAmt");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("arbt_dt", "arbtDt");
		this.hashFields.put("clmt_ctnt", "clmtCtnt");
		this.hashFields.put("tm_bar_dt", "tmBarDt");
		this.hashFields.put("prlm_clm_ntfy_dt", "prlmClmNtfyDt");
		this.hashFields.put("dw_clm_sts_cd", "dwClmStsCd");
		this.hashFields.put("deft_agn_clm_pty_nm", "deftAgnClmPtyNm");
		this.hashFields.put("deft_agn_clm_pty_no", "deftAgnClmPtyNo");
		this.hashFields.put("clmt_agn_ref_no", "clmtAgnRefNo");
		this.hashFields.put("clm_xch_rt", "clmXchRt");
		this.hashFields.put("dw_clm_no", "dwClmNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inciDevDesc
	 */
	public String getInciDevDesc() {
		return this.inciDevDesc;
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
	 * @return clmStlXchRt
	 */
	public String getClmStlXchRt() {
		return this.clmStlXchRt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyClmPtyNo
	 */
	public String getLablPtyClmPtyNo() {
		return this.lablPtyClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return deftAgnTelNo
	 */
	public String getDeftAgnTelNo() {
		return this.deftAgnTelNo;
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
	 * @return deftClmPtyNm
	 */
	public String getDeftClmPtyNm() {
		return this.deftClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return clmStlLoclCurrCd
	 */
	public String getClmStlLoclCurrCd() {
		return this.clmStlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return lablPtyClmPtyNm
	 */
	public String getLablPtyClmPtyNm() {
		return this.lablPtyClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return deftAgnEmail
	 */
	public String getDeftAgnEmail() {
		return this.deftAgnEmail;
	}
	
	/**
	 * Column Info
	 * @return clmLoclAmt
	 */
	public String getClmLoclAmt() {
		return this.clmLoclAmt;
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
	 * @return clmtAgnClmPtyNm
	 */
	public String getClmtAgnClmPtyNm() {
		return this.clmtAgnClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return clmtAgnClmPtyNo
	 */
	public String getClmtAgnClmPtyNo() {
		return this.clmtAgnClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return deftCtnt
	 */
	public String getDeftCtnt() {
		return this.deftCtnt;
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
	 * @return lablPtyCtnt
	 */
	public String getLablPtyCtnt() {
		return this.lablPtyCtnt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyFileDt
	 */
	public String getLablPtyFileDt() {
		return this.lablPtyFileDt;
	}
	
	/**
	 * Column Info
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
	}
	
	/**
	 * Column Info
	 * @return lablPtyFileXchRt
	 */
	public String getLablPtyFileXchRt() {
		return this.lablPtyFileXchRt;
	}
	
	/**
	 * Column Info
	 * @return clmtAgnEmail
	 */
	public String getClmtAgnEmail() {
		return this.clmtAgnEmail;
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
	 * @return clmUsdAmt
	 */
	public String getClmUsdAmt() {
		return this.clmUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return clmtAgnTelNo
	 */
	public String getClmtAgnTelNo() {
		return this.clmtAgnTelNo;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrXchRt
	 */
	public String getInsurRcvrXchRt() {
		return this.insurRcvrXchRt;
	}
	
	/**
	 * Column Info
	 * @return insurFileLoclAmt
	 */
	public String getInsurFileLoclAmt() {
		return this.insurFileLoclAmt;
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
	 * @return deftAgnRefNo
	 */
	public String getDeftAgnRefNo() {
		return this.deftAgnRefNo;
	}
	
	/**
	 * Column Info
	 * @return dwCoCd
	 */
	public String getDwCoCd() {
		return this.dwCoCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmAttDefTpCd
	 */
	public String getDwClmAttDefTpCd() {
		return this.dwClmAttDefTpCd;
	}
	
	/**
	 * Column Info
	 * @return deftAgnTpCd
	 */
	public String getDeftAgnTpCd() {
		return this.deftAgnTpCd;
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
	 * @return insurFileLoclCurrCd
	 */
	public String getInsurFileLoclCurrCd() {
		return this.insurFileLoclCurrCd;
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
	 * @return insurClmPtyNm
	 */
	public String getInsurClmPtyNm() {
		return this.insurClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return rHandler
	 */
	public String getRHandler() {
		return this.rHandler;
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
	 * @return clmStlDt
	 */
	public String getClmStlDt() {
		return this.clmStlDt;
	}
	
	/**
	 * Column Info
	 * @return insurFileXchRt
	 */
	public String getInsurFileXchRt() {
		return this.insurFileXchRt;
	}
	
	/**
	 * Column Info
	 * @return clmTrnsAuthCd
	 */
	public String getClmTrnsAuthCd() {
		return this.clmTrnsAuthCd;
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
	 * @return trnsFlg
	 */
	public String getTrnsFlg() {
		return this.trnsFlg;
	}
	
	/**
	 * Column Info
	 * @return hdlrStlOpinDesc
	 */
	public String getHdlrStlOpinDesc() {
		return this.hdlrStlOpinDesc;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return dwClmCsDesc
	 */
	public String getDwClmCsDesc() {
		return this.dwClmCsDesc;
	}
	
	/**
	 * Column Info
	 * @return clmtClmPtyNm
	 */
	public String getClmtClmPtyNm() {
		return this.clmtClmPtyNm;
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
	 * @return lablPtyFileUsdAmt
	 */
	public String getLablPtyFileUsdAmt() {
		return this.lablPtyFileUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return ddctUsdAmt
	 */
	public String getDdctUsdAmt() {
		return this.ddctUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return clmStlUsdAmt
	 */
	public String getClmStlUsdAmt() {
		return this.clmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyFileLoclCurrCd
	 */
	public String getLablPtyFileLoclCurrCd() {
		return this.lablPtyFileLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return dwClmTpCd
	 */
	public String getDwClmTpCd() {
		return this.dwClmTpCd;
	}
	
	/**
	 * Column Info
	 * @return deftAgnApntDt
	 */
	public String getDeftAgnApntDt() {
		return this.deftAgnApntDt;
	}
	
	/**
	 * Column Info
	 * @return clmtAgnApntDt
	 */
	public String getClmtAgnApntDt() {
		return this.clmtAgnApntDt;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return insurFileUsdAmt
	 */
	public String getInsurFileUsdAmt() {
		return this.insurFileUsdAmt;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return clmStlLoclAmt
	 */
	public String getClmStlLoclAmt() {
		return this.clmStlLoclAmt;
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
	 * @return lablPtyTmBarDt
	 */
	public String getLablPtyTmBarDt() {
		return this.lablPtyTmBarDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyRcvrXchRt
	 */
	public String getLablPtyRcvrXchRt() {
		return this.lablPtyRcvrXchRt;
	}
	
	/**
	 * Column Info
	 * @return dwClmRefVvdNo
	 */
	public String getDwClmRefVvdNo() {
		return this.dwClmRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return clmLoclCurrCd
	 */
	public String getClmLoclCurrCd() {
		return this.clmLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return deftClmPtyNo
	 */
	public String getDeftClmPtyNo() {
		return this.deftClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return litDt
	 */
	public String getLitDt() {
		return this.litDt;
	}
	
	/**
	 * Column Info
	 * @return lablPtyFileLoclAmt
	 */
	public String getLablPtyFileLoclAmt() {
		return this.lablPtyFileLoclAmt;
	}
	
	/**
	 * Column Info
	 * @return insurFileDt
	 */
	public String getInsurFileDt() {
		return this.insurFileDt;
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
	 * @return insurRcvrLoclCurrCd
	 */
	public String getInsurRcvrLoclCurrCd() {
		return this.insurRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @return insurRcvrLoclAmt
	 */
	public String getInsurRcvrLoclAmt() {
		return this.insurRcvrLoclAmt;
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
	 * @return arbtDt
	 */
	public String getArbtDt() {
		return this.arbtDt;
	}
	
	/**
	 * Column Info
	 * @return clmtCtnt
	 */
	public String getClmtCtnt() {
		return this.clmtCtnt;
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
	 * @return prlmClmNtfyDt
	 */
	public String getPrlmClmNtfyDt() {
		return this.prlmClmNtfyDt;
	}
	
	/**
	 * Column Info
	 * @return dwClmStsCd
	 */
	public String getDwClmStsCd() {
		return this.dwClmStsCd;
	}
	
	/**
	 * Column Info
	 * @return deftAgnClmPtyNm
	 */
	public String getDeftAgnClmPtyNm() {
		return this.deftAgnClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return deftAgnClmPtyNo
	 */
	public String getDeftAgnClmPtyNo() {
		return this.deftAgnClmPtyNo;
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
	 * @return clmXchRt
	 */
	public String getClmXchRt() {
		return this.clmXchRt;
	}
	
	/**
	 * Column Info
	 * @return dwClmNo
	 */
	public String getDwClmNo() {
		return this.dwClmNo;
	}
	

	/**
	 * Column Info
	 * @param inciDevDesc
	 */
	public void setInciDevDesc(String inciDevDesc) {
		this.inciDevDesc = inciDevDesc;
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
	 * @param clmStlXchRt
	 */
	public void setClmStlXchRt(String clmStlXchRt) {
		this.clmStlXchRt = clmStlXchRt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyClmPtyNo
	 */
	public void setLablPtyClmPtyNo(String lablPtyClmPtyNo) {
		this.lablPtyClmPtyNo = lablPtyClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param deftAgnTelNo
	 */
	public void setDeftAgnTelNo(String deftAgnTelNo) {
		this.deftAgnTelNo = deftAgnTelNo;
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
	 * @param deftClmPtyNm
	 */
	public void setDeftClmPtyNm(String deftClmPtyNm) {
		this.deftClmPtyNm = deftClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param clmStlLoclCurrCd
	 */
	public void setClmStlLoclCurrCd(String clmStlLoclCurrCd) {
		this.clmStlLoclCurrCd = clmStlLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param lablPtyClmPtyNm
	 */
	public void setLablPtyClmPtyNm(String lablPtyClmPtyNm) {
		this.lablPtyClmPtyNm = lablPtyClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param deftAgnEmail
	 */
	public void setDeftAgnEmail(String deftAgnEmail) {
		this.deftAgnEmail = deftAgnEmail;
	}
	
	/**
	 * Column Info
	 * @param clmLoclAmt
	 */
	public void setClmLoclAmt(String clmLoclAmt) {
		this.clmLoclAmt = clmLoclAmt;
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
	 * @param clmtAgnClmPtyNm
	 */
	public void setClmtAgnClmPtyNm(String clmtAgnClmPtyNm) {
		this.clmtAgnClmPtyNm = clmtAgnClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param clmtAgnClmPtyNo
	 */
	public void setClmtAgnClmPtyNo(String clmtAgnClmPtyNo) {
		this.clmtAgnClmPtyNo = clmtAgnClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param deftCtnt
	 */
	public void setDeftCtnt(String deftCtnt) {
		this.deftCtnt = deftCtnt;
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
	 * @param lablPtyCtnt
	 */
	public void setLablPtyCtnt(String lablPtyCtnt) {
		this.lablPtyCtnt = lablPtyCtnt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyFileDt
	 */
	public void setLablPtyFileDt(String lablPtyFileDt) {
		this.lablPtyFileDt = lablPtyFileDt;
	}
	
	/**
	 * Column Info
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
	}
	
	/**
	 * Column Info
	 * @param lablPtyFileXchRt
	 */
	public void setLablPtyFileXchRt(String lablPtyFileXchRt) {
		this.lablPtyFileXchRt = lablPtyFileXchRt;
	}
	
	/**
	 * Column Info
	 * @param clmtAgnEmail
	 */
	public void setClmtAgnEmail(String clmtAgnEmail) {
		this.clmtAgnEmail = clmtAgnEmail;
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
	 * @param clmUsdAmt
	 */
	public void setClmUsdAmt(String clmUsdAmt) {
		this.clmUsdAmt = clmUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param clmtAgnTelNo
	 */
	public void setClmtAgnTelNo(String clmtAgnTelNo) {
		this.clmtAgnTelNo = clmtAgnTelNo;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrXchRt
	 */
	public void setInsurRcvrXchRt(String insurRcvrXchRt) {
		this.insurRcvrXchRt = insurRcvrXchRt;
	}
	
	/**
	 * Column Info
	 * @param insurFileLoclAmt
	 */
	public void setInsurFileLoclAmt(String insurFileLoclAmt) {
		this.insurFileLoclAmt = insurFileLoclAmt;
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
	 * @param deftAgnRefNo
	 */
	public void setDeftAgnRefNo(String deftAgnRefNo) {
		this.deftAgnRefNo = deftAgnRefNo;
	}
	
	/**
	 * Column Info
	 * @param dwCoCd
	 */
	public void setDwCoCd(String dwCoCd) {
		this.dwCoCd = dwCoCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmAttDefTpCd
	 */
	public void setDwClmAttDefTpCd(String dwClmAttDefTpCd) {
		this.dwClmAttDefTpCd = dwClmAttDefTpCd;
	}
	
	/**
	 * Column Info
	 * @param deftAgnTpCd
	 */
	public void setDeftAgnTpCd(String deftAgnTpCd) {
		this.deftAgnTpCd = deftAgnTpCd;
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
	 * @param insurFileLoclCurrCd
	 */
	public void setInsurFileLoclCurrCd(String insurFileLoclCurrCd) {
		this.insurFileLoclCurrCd = insurFileLoclCurrCd;
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
	 * @param insurClmPtyNm
	 */
	public void setInsurClmPtyNm(String insurClmPtyNm) {
		this.insurClmPtyNm = insurClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param rHandler
	 */
	public void setRHandler(String rHandler) {
		this.rHandler = rHandler;
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
	 * @param clmStlDt
	 */
	public void setClmStlDt(String clmStlDt) {
		this.clmStlDt = clmStlDt;
	}
	
	/**
	 * Column Info
	 * @param insurFileXchRt
	 */
	public void setInsurFileXchRt(String insurFileXchRt) {
		this.insurFileXchRt = insurFileXchRt;
	}
	
	/**
	 * Column Info
	 * @param clmTrnsAuthCd
	 */
	public void setClmTrnsAuthCd(String clmTrnsAuthCd) {
		this.clmTrnsAuthCd = clmTrnsAuthCd;
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
	 * @param trnsFlg
	 */
	public void setTrnsFlg(String trnsFlg) {
		this.trnsFlg = trnsFlg;
	}
	
	/**
	 * Column Info
	 * @param hdlrStlOpinDesc
	 */
	public void setHdlrStlOpinDesc(String hdlrStlOpinDesc) {
		this.hdlrStlOpinDesc = hdlrStlOpinDesc;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param dwClmCsDesc
	 */
	public void setDwClmCsDesc(String dwClmCsDesc) {
		this.dwClmCsDesc = dwClmCsDesc;
	}
	
	/**
	 * Column Info
	 * @param clmtClmPtyNm
	 */
	public void setClmtClmPtyNm(String clmtClmPtyNm) {
		this.clmtClmPtyNm = clmtClmPtyNm;
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
	 * @param lablPtyFileUsdAmt
	 */
	public void setLablPtyFileUsdAmt(String lablPtyFileUsdAmt) {
		this.lablPtyFileUsdAmt = lablPtyFileUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param ddctUsdAmt
	 */
	public void setDdctUsdAmt(String ddctUsdAmt) {
		this.ddctUsdAmt = ddctUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param clmStlUsdAmt
	 */
	public void setClmStlUsdAmt(String clmStlUsdAmt) {
		this.clmStlUsdAmt = clmStlUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyFileLoclCurrCd
	 */
	public void setLablPtyFileLoclCurrCd(String lablPtyFileLoclCurrCd) {
		this.lablPtyFileLoclCurrCd = lablPtyFileLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param dwClmTpCd
	 */
	public void setDwClmTpCd(String dwClmTpCd) {
		this.dwClmTpCd = dwClmTpCd;
	}
	
	/**
	 * Column Info
	 * @param deftAgnApntDt
	 */
	public void setDeftAgnApntDt(String deftAgnApntDt) {
		this.deftAgnApntDt = deftAgnApntDt;
	}
	
	/**
	 * Column Info
	 * @param clmtAgnApntDt
	 */
	public void setClmtAgnApntDt(String clmtAgnApntDt) {
		this.clmtAgnApntDt = clmtAgnApntDt;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param insurFileUsdAmt
	 */
	public void setInsurFileUsdAmt(String insurFileUsdAmt) {
		this.insurFileUsdAmt = insurFileUsdAmt;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param clmStlLoclAmt
	 */
	public void setClmStlLoclAmt(String clmStlLoclAmt) {
		this.clmStlLoclAmt = clmStlLoclAmt;
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
	 * @param lablPtyTmBarDt
	 */
	public void setLablPtyTmBarDt(String lablPtyTmBarDt) {
		this.lablPtyTmBarDt = lablPtyTmBarDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyRcvrXchRt
	 */
	public void setLablPtyRcvrXchRt(String lablPtyRcvrXchRt) {
		this.lablPtyRcvrXchRt = lablPtyRcvrXchRt;
	}
	
	/**
	 * Column Info
	 * @param dwClmRefVvdNo
	 */
	public void setDwClmRefVvdNo(String dwClmRefVvdNo) {
		this.dwClmRefVvdNo = dwClmRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param clmLoclCurrCd
	 */
	public void setClmLoclCurrCd(String clmLoclCurrCd) {
		this.clmLoclCurrCd = clmLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param deftClmPtyNo
	 */
	public void setDeftClmPtyNo(String deftClmPtyNo) {
		this.deftClmPtyNo = deftClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param litDt
	 */
	public void setLitDt(String litDt) {
		this.litDt = litDt;
	}
	
	/**
	 * Column Info
	 * @param lablPtyFileLoclAmt
	 */
	public void setLablPtyFileLoclAmt(String lablPtyFileLoclAmt) {
		this.lablPtyFileLoclAmt = lablPtyFileLoclAmt;
	}
	
	/**
	 * Column Info
	 * @param insurFileDt
	 */
	public void setInsurFileDt(String insurFileDt) {
		this.insurFileDt = insurFileDt;
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
	 * @param insurRcvrLoclCurrCd
	 */
	public void setInsurRcvrLoclCurrCd(String insurRcvrLoclCurrCd) {
		this.insurRcvrLoclCurrCd = insurRcvrLoclCurrCd;
	}
	
	/**
	 * Column Info
	 * @param insurRcvrLoclAmt
	 */
	public void setInsurRcvrLoclAmt(String insurRcvrLoclAmt) {
		this.insurRcvrLoclAmt = insurRcvrLoclAmt;
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
	 * @param arbtDt
	 */
	public void setArbtDt(String arbtDt) {
		this.arbtDt = arbtDt;
	}
	
	/**
	 * Column Info
	 * @param clmtCtnt
	 */
	public void setClmtCtnt(String clmtCtnt) {
		this.clmtCtnt = clmtCtnt;
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
	 * @param prlmClmNtfyDt
	 */
	public void setPrlmClmNtfyDt(String prlmClmNtfyDt) {
		this.prlmClmNtfyDt = prlmClmNtfyDt;
	}
	
	/**
	 * Column Info
	 * @param dwClmStsCd
	 */
	public void setDwClmStsCd(String dwClmStsCd) {
		this.dwClmStsCd = dwClmStsCd;
	}
	
	/**
	 * Column Info
	 * @param deftAgnClmPtyNm
	 */
	public void setDeftAgnClmPtyNm(String deftAgnClmPtyNm) {
		this.deftAgnClmPtyNm = deftAgnClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param deftAgnClmPtyNo
	 */
	public void setDeftAgnClmPtyNo(String deftAgnClmPtyNo) {
		this.deftAgnClmPtyNo = deftAgnClmPtyNo;
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
	 * @param clmXchRt
	 */
	public void setClmXchRt(String clmXchRt) {
		this.clmXchRt = clmXchRt;
	}
	
	/**
	 * Column Info
	 * @param dwClmNo
	 */
	public void setDwClmNo(String dwClmNo) {
		this.dwClmNo = dwClmNo;
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
		setInciDevDesc(JSPUtil.getParameter(request, prefix + "inci_dev_desc", ""));
		setInsurRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "insur_rcvr_usd_amt", ""));
		setClmStlXchRt(JSPUtil.getParameter(request, prefix + "clm_stl_xch_rt", ""));
		setLablPtyClmPtyNo(JSPUtil.getParameter(request, prefix + "labl_pty_clm_pty_no", ""));
		setDeftAgnTelNo(JSPUtil.getParameter(request, prefix + "deft_agn_tel_no", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_dt", ""));
		setDeftClmPtyNm(JSPUtil.getParameter(request, prefix + "deft_clm_pty_nm", ""));
		setClmStlLoclCurrCd(JSPUtil.getParameter(request, prefix + "clm_stl_locl_curr_cd", ""));
		setLablPtyClmPtyNm(JSPUtil.getParameter(request, prefix + "labl_pty_clm_pty_nm", ""));
		setDeftAgnEmail(JSPUtil.getParameter(request, prefix + "deft_agn_email", ""));
		setClmLoclAmt(JSPUtil.getParameter(request, prefix + "clm_locl_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setClmtAgnClmPtyNm(JSPUtil.getParameter(request, prefix + "clmt_agn_clm_pty_nm", ""));
		setClmtAgnClmPtyNo(JSPUtil.getParameter(request, prefix + "clmt_agn_clm_pty_no", ""));
		setDeftCtnt(JSPUtil.getParameter(request, prefix + "deft_ctnt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setLablPtyCtnt(JSPUtil.getParameter(request, prefix + "labl_pty_ctnt", ""));
		setLablPtyFileDt(JSPUtil.getParameter(request, prefix + "labl_pty_file_dt", ""));
		setTrnsSeq(JSPUtil.getParameter(request, prefix + "trns_seq", ""));
		setLablPtyFileXchRt(JSPUtil.getParameter(request, prefix + "labl_pty_file_xch_rt", ""));
		setClmtAgnEmail(JSPUtil.getParameter(request, prefix + "clmt_agn_email", ""));
		setInciOccrDt(JSPUtil.getParameter(request, prefix + "inci_occr_dt", ""));
		setClmUsdAmt(JSPUtil.getParameter(request, prefix + "clm_usd_amt", ""));
		setClmtAgnTelNo(JSPUtil.getParameter(request, prefix + "clmt_agn_tel_no", ""));
		setInsurRcvrXchRt(JSPUtil.getParameter(request, prefix + "insur_rcvr_xch_rt", ""));
		setInsurFileLoclAmt(JSPUtil.getParameter(request, prefix + "insur_file_locl_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDeftAgnRefNo(JSPUtil.getParameter(request, prefix + "deft_agn_ref_no", ""));
		setDwCoCd(JSPUtil.getParameter(request, prefix + "dw_co_cd", ""));
		setDwClmAttDefTpCd(JSPUtil.getParameter(request, prefix + "dw_clm_att_def_tp_cd", ""));
		setDeftAgnTpCd(JSPUtil.getParameter(request, prefix + "deft_agn_tp_cd", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, prefix + "insur_clm_pty_no", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, prefix + "inci_plc_tp_cd", ""));
		setInsurFileLoclCurrCd(JSPUtil.getParameter(request, prefix + "insur_file_locl_curr_cd", ""));
		setLablPtyRcvrLoclCurrCd(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_curr_cd", ""));
		setInsurRcvrDt(JSPUtil.getParameter(request, prefix + "insur_rcvr_dt", ""));
		setInsurClmPtyNm(JSPUtil.getParameter(request, prefix + "insur_clm_pty_nm", ""));
		setRHandler(JSPUtil.getParameter(request, prefix + "r_handler", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setClmStlDt(JSPUtil.getParameter(request, prefix + "clm_stl_dt", ""));
		setInsurFileXchRt(JSPUtil.getParameter(request, prefix + "insur_file_xch_rt", ""));
		setClmTrnsAuthCd(JSPUtil.getParameter(request, prefix + "clm_trns_auth_cd", ""));
		setCsClzDt(JSPUtil.getParameter(request, prefix + "cs_clz_dt", ""));
		setTrnsFlg(JSPUtil.getParameter(request, prefix + "trns_flg", ""));
		setHdlrStlOpinDesc(JSPUtil.getParameter(request, prefix + "hdlr_stl_opin_desc", ""));
		setLablPtyRcvrUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_usd_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setDwClmCsDesc(JSPUtil.getParameter(request, prefix + "dw_clm_cs_desc", ""));
		setClmtClmPtyNm(JSPUtil.getParameter(request, prefix + "clmt_clm_pty_nm", ""));
		setClmtClmPtyNo(JSPUtil.getParameter(request, prefix + "clmt_clm_pty_no", ""));
		setLablPtyFileUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_file_usd_amt", ""));
		setDdctUsdAmt(JSPUtil.getParameter(request, prefix + "ddct_usd_amt", ""));
		setClmStlUsdAmt(JSPUtil.getParameter(request, prefix + "clm_stl_usd_amt", ""));
		setLablPtyFileLoclCurrCd(JSPUtil.getParameter(request, prefix + "labl_pty_file_locl_curr_cd", ""));
		setDwClmTpCd(JSPUtil.getParameter(request, prefix + "dw_clm_tp_cd", ""));
		setDeftAgnApntDt(JSPUtil.getParameter(request, prefix + "deft_agn_apnt_dt", ""));
		setClmtAgnApntDt(JSPUtil.getParameter(request, prefix + "clmt_agn_apnt_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setInsurFileUsdAmt(JSPUtil.getParameter(request, prefix + "insur_file_usd_amt", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setLablPtyRcvrDt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_dt", ""));
		setClmStlLoclAmt(JSPUtil.getParameter(request, prefix + "clm_stl_locl_amt", ""));
		setLablPtyRcvrLoclAmt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_locl_amt", ""));
		setLablPtyTmBarDt(JSPUtil.getParameter(request, prefix + "labl_pty_tm_bar_dt", ""));
		setLablPtyRcvrXchRt(JSPUtil.getParameter(request, prefix + "labl_pty_rcvr_xch_rt", ""));
		setDwClmRefVvdNo(JSPUtil.getParameter(request, prefix + "dw_clm_ref_vvd_no", ""));
		setClmLoclCurrCd(JSPUtil.getParameter(request, prefix + "clm_locl_curr_cd", ""));
		setDeftClmPtyNo(JSPUtil.getParameter(request, prefix + "deft_clm_pty_no", ""));
		setLitDt(JSPUtil.getParameter(request, prefix + "lit_dt", ""));
		setLablPtyFileLoclAmt(JSPUtil.getParameter(request, prefix + "labl_pty_file_locl_amt", ""));
		setInsurFileDt(JSPUtil.getParameter(request, prefix + "insur_file_dt", ""));
		setClmtAgnTpCd(JSPUtil.getParameter(request, prefix + "clmt_agn_tp_cd", ""));
		setInsurRcvrLoclCurrCd(JSPUtil.getParameter(request, prefix + "insur_rcvr_locl_curr_cd", ""));
		setInsurRcvrLoclAmt(JSPUtil.getParameter(request, prefix + "insur_rcvr_locl_amt", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setArbtDt(JSPUtil.getParameter(request, prefix + "arbt_dt", ""));
		setClmtCtnt(JSPUtil.getParameter(request, prefix + "clmt_ctnt", ""));
		setTmBarDt(JSPUtil.getParameter(request, prefix + "tm_bar_dt", ""));
		setPrlmClmNtfyDt(JSPUtil.getParameter(request, prefix + "prlm_clm_ntfy_dt", ""));
		setDwClmStsCd(JSPUtil.getParameter(request, prefix + "dw_clm_sts_cd", ""));
		setDeftAgnClmPtyNm(JSPUtil.getParameter(request, prefix + "deft_agn_clm_pty_nm", ""));
		setDeftAgnClmPtyNo(JSPUtil.getParameter(request, prefix + "deft_agn_clm_pty_no", ""));
		setClmtAgnRefNo(JSPUtil.getParameter(request, prefix + "clmt_agn_ref_no", ""));
		setClmXchRt(JSPUtil.getParameter(request, prefix + "clm_xch_rt", ""));
		setDwClmNo(JSPUtil.getParameter(request, prefix + "dw_clm_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDryWetClaimVO[]
	 */
	public SearchDryWetClaimVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchDryWetClaimVO[]
	 */
	public SearchDryWetClaimVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchDryWetClaimVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inciDevDesc = (JSPUtil.getParameter(request, prefix	+ "inci_dev_desc", length));
			String[] insurRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_usd_amt", length));
			String[] clmStlXchRt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_xch_rt", length));
			String[] lablPtyClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "labl_pty_clm_pty_no", length));
			String[] deftAgnTelNo = (JSPUtil.getParameter(request, prefix	+ "deft_agn_tel_no", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] deftClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "deft_clm_pty_nm", length));
			String[] clmStlLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "clm_stl_locl_curr_cd", length));
			String[] lablPtyClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "labl_pty_clm_pty_nm", length));
			String[] deftAgnEmail = (JSPUtil.getParameter(request, prefix	+ "deft_agn_email", length));
			String[] clmLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clm_locl_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] clmtAgnClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_clm_pty_nm", length));
			String[] clmtAgnClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_clm_pty_no", length));
			String[] deftCtnt = (JSPUtil.getParameter(request, prefix	+ "deft_ctnt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] lablPtyCtnt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_ctnt", length));
			String[] lablPtyFileDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_file_dt", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] lablPtyFileXchRt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_file_xch_rt", length));
			String[] clmtAgnEmail = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_email", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] clmUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clm_usd_amt", length));
			String[] clmtAgnTelNo = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_tel_no", length));
			String[] insurRcvrXchRt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_xch_rt", length));
			String[] insurFileLoclAmt = (JSPUtil.getParameter(request, prefix	+ "insur_file_locl_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] deftAgnRefNo = (JSPUtil.getParameter(request, prefix	+ "deft_agn_ref_no", length));
			String[] dwCoCd = (JSPUtil.getParameter(request, prefix	+ "dw_co_cd", length));
			String[] dwClmAttDefTpCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_att_def_tp_cd", length));
			String[] deftAgnTpCd = (JSPUtil.getParameter(request, prefix	+ "deft_agn_tp_cd", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] insurFileLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "insur_file_locl_curr_cd", length));
			String[] lablPtyRcvrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_curr_cd", length));
			String[] insurRcvrDt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_dt", length));
			String[] insurClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_nm", length));
			String[] rHandler = (JSPUtil.getParameter(request, prefix	+ "r_handler", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] clmStlDt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_dt", length));
			String[] insurFileXchRt = (JSPUtil.getParameter(request, prefix	+ "insur_file_xch_rt", length));
			String[] clmTrnsAuthCd = (JSPUtil.getParameter(request, prefix	+ "clm_trns_auth_cd", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] trnsFlg = (JSPUtil.getParameter(request, prefix	+ "trns_flg", length));
			String[] hdlrStlOpinDesc = (JSPUtil.getParameter(request, prefix	+ "hdlr_stl_opin_desc", length));
			String[] lablPtyRcvrUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_usd_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dwClmCsDesc = (JSPUtil.getParameter(request, prefix	+ "dw_clm_cs_desc", length));
			String[] clmtClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_pty_nm", length));
			String[] clmtClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_pty_no", length));
			String[] lablPtyFileUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_file_usd_amt", length));
			String[] ddctUsdAmt = (JSPUtil.getParameter(request, prefix	+ "ddct_usd_amt", length));
			String[] clmStlUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_usd_amt", length));
			String[] lablPtyFileLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "labl_pty_file_locl_curr_cd", length));
			String[] dwClmTpCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_tp_cd", length));
			String[] deftAgnApntDt = (JSPUtil.getParameter(request, prefix	+ "deft_agn_apnt_dt", length));
			String[] clmtAgnApntDt = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_apnt_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] insurFileUsdAmt = (JSPUtil.getParameter(request, prefix	+ "insur_file_usd_amt", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] lablPtyRcvrDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_dt", length));
			String[] clmStlLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clm_stl_locl_amt", length));
			String[] lablPtyRcvrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_locl_amt", length));
			String[] lablPtyTmBarDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_tm_bar_dt", length));
			String[] lablPtyRcvrXchRt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_rcvr_xch_rt", length));
			String[] dwClmRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_ref_vvd_no", length));
			String[] clmLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "clm_locl_curr_cd", length));
			String[] deftClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "deft_clm_pty_no", length));
			String[] litDt = (JSPUtil.getParameter(request, prefix	+ "lit_dt", length));
			String[] lablPtyFileLoclAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_file_locl_amt", length));
			String[] insurFileDt = (JSPUtil.getParameter(request, prefix	+ "insur_file_dt", length));
			String[] clmtAgnTpCd = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_tp_cd", length));
			String[] insurRcvrLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_locl_curr_cd", length));
			String[] insurRcvrLoclAmt = (JSPUtil.getParameter(request, prefix	+ "insur_rcvr_locl_amt", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] arbtDt = (JSPUtil.getParameter(request, prefix	+ "arbt_dt", length));
			String[] clmtCtnt = (JSPUtil.getParameter(request, prefix	+ "clmt_ctnt", length));
			String[] tmBarDt = (JSPUtil.getParameter(request, prefix	+ "tm_bar_dt", length));
			String[] prlmClmNtfyDt = (JSPUtil.getParameter(request, prefix	+ "prlm_clm_ntfy_dt", length));
			String[] dwClmStsCd = (JSPUtil.getParameter(request, prefix	+ "dw_clm_sts_cd", length));
			String[] deftAgnClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "deft_agn_clm_pty_nm", length));
			String[] deftAgnClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "deft_agn_clm_pty_no", length));
			String[] clmtAgnRefNo = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_ref_no", length));
			String[] clmXchRt = (JSPUtil.getParameter(request, prefix	+ "clm_xch_rt", length));
			String[] dwClmNo = (JSPUtil.getParameter(request, prefix	+ "dw_clm_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchDryWetClaimVO();
				if (inciDevDesc[i] != null)
					model.setInciDevDesc(inciDevDesc[i]);
				if (insurRcvrUsdAmt[i] != null)
					model.setInsurRcvrUsdAmt(insurRcvrUsdAmt[i]);
				if (clmStlXchRt[i] != null)
					model.setClmStlXchRt(clmStlXchRt[i]);
				if (lablPtyClmPtyNo[i] != null)
					model.setLablPtyClmPtyNo(lablPtyClmPtyNo[i]);
				if (deftAgnTelNo[i] != null)
					model.setDeftAgnTelNo(deftAgnTelNo[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (deftClmPtyNm[i] != null)
					model.setDeftClmPtyNm(deftClmPtyNm[i]);
				if (clmStlLoclCurrCd[i] != null)
					model.setClmStlLoclCurrCd(clmStlLoclCurrCd[i]);
				if (lablPtyClmPtyNm[i] != null)
					model.setLablPtyClmPtyNm(lablPtyClmPtyNm[i]);
				if (deftAgnEmail[i] != null)
					model.setDeftAgnEmail(deftAgnEmail[i]);
				if (clmLoclAmt[i] != null)
					model.setClmLoclAmt(clmLoclAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (clmtAgnClmPtyNm[i] != null)
					model.setClmtAgnClmPtyNm(clmtAgnClmPtyNm[i]);
				if (clmtAgnClmPtyNo[i] != null)
					model.setClmtAgnClmPtyNo(clmtAgnClmPtyNo[i]);
				if (deftCtnt[i] != null)
					model.setDeftCtnt(deftCtnt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (lablPtyCtnt[i] != null)
					model.setLablPtyCtnt(lablPtyCtnt[i]);
				if (lablPtyFileDt[i] != null)
					model.setLablPtyFileDt(lablPtyFileDt[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (lablPtyFileXchRt[i] != null)
					model.setLablPtyFileXchRt(lablPtyFileXchRt[i]);
				if (clmtAgnEmail[i] != null)
					model.setClmtAgnEmail(clmtAgnEmail[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (clmUsdAmt[i] != null)
					model.setClmUsdAmt(clmUsdAmt[i]);
				if (clmtAgnTelNo[i] != null)
					model.setClmtAgnTelNo(clmtAgnTelNo[i]);
				if (insurRcvrXchRt[i] != null)
					model.setInsurRcvrXchRt(insurRcvrXchRt[i]);
				if (insurFileLoclAmt[i] != null)
					model.setInsurFileLoclAmt(insurFileLoclAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (deftAgnRefNo[i] != null)
					model.setDeftAgnRefNo(deftAgnRefNo[i]);
				if (dwCoCd[i] != null)
					model.setDwCoCd(dwCoCd[i]);
				if (dwClmAttDefTpCd[i] != null)
					model.setDwClmAttDefTpCd(dwClmAttDefTpCd[i]);
				if (deftAgnTpCd[i] != null)
					model.setDeftAgnTpCd(deftAgnTpCd[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (insurFileLoclCurrCd[i] != null)
					model.setInsurFileLoclCurrCd(insurFileLoclCurrCd[i]);
				if (lablPtyRcvrLoclCurrCd[i] != null)
					model.setLablPtyRcvrLoclCurrCd(lablPtyRcvrLoclCurrCd[i]);
				if (insurRcvrDt[i] != null)
					model.setInsurRcvrDt(insurRcvrDt[i]);
				if (insurClmPtyNm[i] != null)
					model.setInsurClmPtyNm(insurClmPtyNm[i]);
				if (rHandler[i] != null)
					model.setRHandler(rHandler[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (clmStlDt[i] != null)
					model.setClmStlDt(clmStlDt[i]);
				if (insurFileXchRt[i] != null)
					model.setInsurFileXchRt(insurFileXchRt[i]);
				if (clmTrnsAuthCd[i] != null)
					model.setClmTrnsAuthCd(clmTrnsAuthCd[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (trnsFlg[i] != null)
					model.setTrnsFlg(trnsFlg[i]);
				if (hdlrStlOpinDesc[i] != null)
					model.setHdlrStlOpinDesc(hdlrStlOpinDesc[i]);
				if (lablPtyRcvrUsdAmt[i] != null)
					model.setLablPtyRcvrUsdAmt(lablPtyRcvrUsdAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dwClmCsDesc[i] != null)
					model.setDwClmCsDesc(dwClmCsDesc[i]);
				if (clmtClmPtyNm[i] != null)
					model.setClmtClmPtyNm(clmtClmPtyNm[i]);
				if (clmtClmPtyNo[i] != null)
					model.setClmtClmPtyNo(clmtClmPtyNo[i]);
				if (lablPtyFileUsdAmt[i] != null)
					model.setLablPtyFileUsdAmt(lablPtyFileUsdAmt[i]);
				if (ddctUsdAmt[i] != null)
					model.setDdctUsdAmt(ddctUsdAmt[i]);
				if (clmStlUsdAmt[i] != null)
					model.setClmStlUsdAmt(clmStlUsdAmt[i]);
				if (lablPtyFileLoclCurrCd[i] != null)
					model.setLablPtyFileLoclCurrCd(lablPtyFileLoclCurrCd[i]);
				if (dwClmTpCd[i] != null)
					model.setDwClmTpCd(dwClmTpCd[i]);
				if (deftAgnApntDt[i] != null)
					model.setDeftAgnApntDt(deftAgnApntDt[i]);
				if (clmtAgnApntDt[i] != null)
					model.setClmtAgnApntDt(clmtAgnApntDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (insurFileUsdAmt[i] != null)
					model.setInsurFileUsdAmt(insurFileUsdAmt[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (lablPtyRcvrDt[i] != null)
					model.setLablPtyRcvrDt(lablPtyRcvrDt[i]);
				if (clmStlLoclAmt[i] != null)
					model.setClmStlLoclAmt(clmStlLoclAmt[i]);
				if (lablPtyRcvrLoclAmt[i] != null)
					model.setLablPtyRcvrLoclAmt(lablPtyRcvrLoclAmt[i]);
				if (lablPtyTmBarDt[i] != null)
					model.setLablPtyTmBarDt(lablPtyTmBarDt[i]);
				if (lablPtyRcvrXchRt[i] != null)
					model.setLablPtyRcvrXchRt(lablPtyRcvrXchRt[i]);
				if (dwClmRefVvdNo[i] != null)
					model.setDwClmRefVvdNo(dwClmRefVvdNo[i]);
				if (clmLoclCurrCd[i] != null)
					model.setClmLoclCurrCd(clmLoclCurrCd[i]);
				if (deftClmPtyNo[i] != null)
					model.setDeftClmPtyNo(deftClmPtyNo[i]);
				if (litDt[i] != null)
					model.setLitDt(litDt[i]);
				if (lablPtyFileLoclAmt[i] != null)
					model.setLablPtyFileLoclAmt(lablPtyFileLoclAmt[i]);
				if (insurFileDt[i] != null)
					model.setInsurFileDt(insurFileDt[i]);
				if (clmtAgnTpCd[i] != null)
					model.setClmtAgnTpCd(clmtAgnTpCd[i]);
				if (insurRcvrLoclCurrCd[i] != null)
					model.setInsurRcvrLoclCurrCd(insurRcvrLoclCurrCd[i]);
				if (insurRcvrLoclAmt[i] != null)
					model.setInsurRcvrLoclAmt(insurRcvrLoclAmt[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (arbtDt[i] != null)
					model.setArbtDt(arbtDt[i]);
				if (clmtCtnt[i] != null)
					model.setClmtCtnt(clmtCtnt[i]);
				if (tmBarDt[i] != null)
					model.setTmBarDt(tmBarDt[i]);
				if (prlmClmNtfyDt[i] != null)
					model.setPrlmClmNtfyDt(prlmClmNtfyDt[i]);
				if (dwClmStsCd[i] != null)
					model.setDwClmStsCd(dwClmStsCd[i]);
				if (deftAgnClmPtyNm[i] != null)
					model.setDeftAgnClmPtyNm(deftAgnClmPtyNm[i]);
				if (deftAgnClmPtyNo[i] != null)
					model.setDeftAgnClmPtyNo(deftAgnClmPtyNo[i]);
				if (clmtAgnRefNo[i] != null)
					model.setClmtAgnRefNo(clmtAgnRefNo[i]);
				if (clmXchRt[i] != null)
					model.setClmXchRt(clmXchRt[i]);
				if (dwClmNo[i] != null)
					model.setDwClmNo(dwClmNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchDryWetClaimVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchDryWetClaimVO[]
	 */
	public SearchDryWetClaimVO[] getSearchDryWetClaimVOs(){
		SearchDryWetClaimVO[] vos = (SearchDryWetClaimVO[])models.toArray(new SearchDryWetClaimVO[models.size()]);
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
		this.inciDevDesc = this.inciDevDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrUsdAmt = this.insurRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlXchRt = this.clmStlXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyClmPtyNo = this.lablPtyClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAgnTelNo = this.deftAgnTelNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftClmPtyNm = this.deftClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlLoclCurrCd = this.clmStlLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyClmPtyNm = this.lablPtyClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAgnEmail = this.deftAgnEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmLoclAmt = this.clmLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnClmPtyNm = this.clmtAgnClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnClmPtyNo = this.clmtAgnClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftCtnt = this.deftCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyCtnt = this.lablPtyCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFileDt = this.lablPtyFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFileXchRt = this.lablPtyFileXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnEmail = this.clmtAgnEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmUsdAmt = this.clmUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnTelNo = this.clmtAgnTelNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrXchRt = this.insurRcvrXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFileLoclAmt = this.insurFileLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAgnRefNo = this.deftAgnRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwCoCd = this.dwCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmAttDefTpCd = this.dwClmAttDefTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAgnTpCd = this.deftAgnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFileLoclCurrCd = this.insurFileLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclCurrCd = this.lablPtyRcvrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrDt = this.insurRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNm = this.insurClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rHandler = this.rHandler .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlDt = this.clmStlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFileXchRt = this.insurFileXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmTrnsAuthCd = this.clmTrnsAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsFlg = this.trnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrStlOpinDesc = this.hdlrStlOpinDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrUsdAmt = this.lablPtyRcvrUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmCsDesc = this.dwClmCsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmPtyNm = this.clmtClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmPtyNo = this.clmtClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFileUsdAmt = this.lablPtyFileUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctUsdAmt = this.ddctUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlUsdAmt = this.clmStlUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFileLoclCurrCd = this.lablPtyFileLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmTpCd = this.dwClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAgnApntDt = this.deftAgnApntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnApntDt = this.clmtAgnApntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFileUsdAmt = this.insurFileUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrDt = this.lablPtyRcvrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmStlLoclAmt = this.clmStlLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrLoclAmt = this.lablPtyRcvrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyTmBarDt = this.lablPtyTmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyRcvrXchRt = this.lablPtyRcvrXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmRefVvdNo = this.dwClmRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmLoclCurrCd = this.clmLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftClmPtyNo = this.deftClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.litDt = this.litDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFileLoclAmt = this.lablPtyFileLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurFileDt = this.insurFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnTpCd = this.clmtAgnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrLoclCurrCd = this.insurRcvrLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRcvrLoclAmt = this.insurRcvrLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbtDt = this.arbtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtCtnt = this.clmtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmBarDt = this.tmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prlmClmNtfyDt = this.prlmClmNtfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmStsCd = this.dwClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAgnClmPtyNm = this.deftAgnClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAgnClmPtyNo = this.deftAgnClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnRefNo = this.clmtAgnRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmXchRt = this.clmXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dwClmNo = this.dwClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
