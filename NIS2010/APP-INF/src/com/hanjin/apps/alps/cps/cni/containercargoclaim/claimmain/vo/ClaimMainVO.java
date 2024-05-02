/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ClaimMainVO.java
*@FileTitle : ClaimMainVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.11
*@LastModifier : 정행룡
*@LastVersion : 1.0
* 2010.02.11 정행룡 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.cni.containercargoclaim.claimmain.vo;

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
 * @author 정행룡
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ClaimMainVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ClaimMainVO> models = new ArrayList<ClaimMainVO>();
	
	/* Column Info */
	private String ligtUpdDt = null;
	/* Column Info */
	private String trnkRefVvdNo = null;
	/* Column Info */
	private String n3rdPreRefVvdNo = null;
	/* Column Info */
	private String smnsSveDt = null;
	/* Column Info */
	private String fmalClmRcvDt = null;
	/* Column Info */
	private String clmOfrtAmt = null;
	/* Column Info */
	private String agnCrspnTpCd = null;
	/* Column Info */
	private String clmtClmPtyAbbrNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sveyClmPtyNo = null;
	/* Column Info */
	private String insurClmPtyAbbrNm = null;
	/* Column Info */
	private String mnBlFlg = null;
	/* Column Info */
	private String pltNm = null;
	/* Column Info */
	private String lablClmPtyNo = null;
	/* Column Info */
	private String clmCuzDesc = null;
	/* Column Info */
	private String clmOfrtTermCd = null;
	/* Column Info */
	private String cgoClmRefBlNo = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cgoClmDivCd = null;
	/* Column Info */
	private String nhp = null;
	/* Column Info */
	private String trnsSeq = null;
	/* Column Info */
	private String hpd = null;
	/* Column Info */
	private String cgoClmAcknakDt = null;
	/* Column Info */
	private String inciOccrDt = null;
	/* Column Info */
	private String jmtRsltDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cgoClmStlTpCd = null;
	/* Column Info */
	private String ltgtCsDesc = null;
	/* Column Info */
	private String clmTmBarDt = null;
	/* Column Info */
	private String fmalClmRcvOfcCd = null;
	/* Column Info */
	private String clmAgnIntlPhnNo = null;
	/* Column Info */
	private String n3rdLablPtyCd = null;
	/* Column Info */
	private String inciPlcTpCd = null;
	/* Column Info */
	private String lablPtyFmalClmDt = null;
	/* Column Info */
	private String hdlrOfcCd = null;
	/* Column Info */
	private String sveyClmPtyAbbrNm = null;
	/* Column Info */
	private String clmtLoclXchRt = null;
	/* Column Info */
	private String clmtRefNo = null;
	/* Column Info */
	private String clmtLoclAmt = null;
	/* Column Info */
	private String trnsFlg = null;
	/* Column Info */
	private String bfrCgoClmStsCd = null;
	/* Column Info */
	private String deDt = null;
	/* Column Info */
	private String lablPtyDmndUsdAmt = null;
	/* Column Info */
	private String crrTermCd = null;
	/* Column Info */
	private String deftAttyClmPtyNm = null;
	/* Column Info */
	private String n1stPstTsDt = null;
	/* Column Info */
	private String agnCrspnApntDt = null;
	/* Column Info */
	private String n2ndPreTsDt = null;
	/* Column Info */
	private String insurAgnClmPtyAbbrNm = null;
	/* Column Info */
	private String deftAttyClmPtyNo = null;
	/* Column Info */
	private String factFndDesc = null;
	/* Column Info */
	private String lablTmBarDt = null;
	/* Column Info */
	private String csClzRopnDt = null;
	/* Column Info */
	private String insurAgnClmPtyNm = null;
	/* Column Info */
	private String clmAgnPtyEml = null;
	/* Column Info */
	private String crtNm = null;
	/* Column Info */
	private String insurAgnClmPtyNo = null;
	/* Column Info */
	private String insurAgnIntlPhnNo = null;
	/* Column Info */
	private String ligtUpdUsrId = null;
	/* Column Info */
	private String factFndDt = null;
	/* Column Info */
	private String cgoClmRefCntrNo = null;
	/* Column Info */
	private String n2ndPreRefVvdNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String lodgDt = null;
	/* Column Info */
	private String insurAgnPhnNo = null;
	/* Column Info */
	private String cgoClmInciNo = null;
	/* Column Info */
	private String clmtAgnRefNo = null;
	/* Column Info */
	private String jmtRsltCd = null;
	/* Column Info */
	private String n2ndPstTsLocCd = null;
	/* Column Info */
	private String cgoClmClzCd = null;
	/* Column Info */
	private String svyrTpCd = null;
	/* Column Info */
	private String cgoQltyDesc = null;
	/* Column Info */
	private String n2ndPstTsDt = null;
	/* Column Info */
	private String cgoClmStsNm = null;
	/* Column Info */
	private String preCgoClmClzCd = null;
	/* Column Info */
	private String n1stPstRefVvdNo = null;
	/* Column Info */
	private String insurRefNo = null;
	/* Column Info */
	private String clmCgoTpCd = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String n3rdPstRefVvdNo = null;
	/* Column Info */
	private String prlmClmNtcDt = null;
	/* Column Info */
	private String cgoClmNo = null;
	/* Column Info */
	private String agnCrspnRefNo = null;
	/* Column Info */
	private String mjrClmDmgLssCd = null;
	/* Column Info */
	private String n1stPreTsDt = null;
	/* Column Info */
	private String clmAgnClmPtyNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String sveyInpDt = null;
	/* Column Info */
	private String clmtLoclCurrCd = null;
	/* Column Info */
	private String clmAgnClmPtyNo = null;
	/* Column Info */
	private String cpDesc = null;
	/* Column Info */
	private String crtCsNo = null;
	/* Column Info */
	private String insurVslOshpCd = null;
	/* Column Info */
	private String clmtUsdAmt = null;
	/* Column Info */
	private String crmVocNo = null;
	/* Column Info */
	private String insurClmPtyNo = null;
	/* Column Info */
	private String cgoClmTpCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String clmAgnClmPtyAbbrNm = null;
	/* Column Info */
	private String csClzDt = null;
	/* Column Info */
	private String clmTrnsAuthCd = null;
	/* Column Info */
	private String clmtClmPtyNm = null;
	/* Column Info */
	private String lablClmPtyAbbrNm = null;
	/* Column Info */
	private String clmtClmPtyNo = null;
	/* Column Info */
	private String n1stPreTsLocCd = null;
	/* Column Info */
	private String clmtAgnApntDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deftNm = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String n2ndPstRefVvdNo = null;
	/* Column Info */
	private String cgoClmStsCd = null;
	/* Column Info */
	private String clmRvwDesc = null;
	/* Column Info */
	private String insurAgnPtyEml = null;
	/* Column Info */
	private String n2ndPreTsLocCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n1stPstTsLocCd = null;
	/* Column Info */
	private String dchgDt = null;
	/* Column Info */
	private String deftAttyClmPtyAbbrNm = null;
	/* Column Info */
	private String insurVslTpCd = null;
	/* Column Info */
	private String clmtAgnTpCd = null;
	/* Column Info */
	private String clmtClmTpCd = null;
	/* Column Info */
	private String clmAgnPhnNo = null;
	/* Column Info */
	private String cplnFileDt = null;
	/* Column Info */
	private String deftAttyApntDt = null;
	/* Column Info */
	private String hdlrUsrId = null;
	/* Column Info */
	private String clmOfrtFlg = null;
	/* Column Info */
	private String rctDt = null;
	/* Column Info */
	private String n1stPreRefVvdNo = null;
	/* Column Info */
	private String refDeftAttyNo = null;
	/* Column Info */
	private String clmAreaCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ClaimMainVO() {}

	public ClaimMainVO(String ibflag, String pagerows, String cgoClmNo, String hdlrUsrId, String hdlrOfcCd, String csClzDt, String clmTmBarDt, String lablTmBarDt, String prlmClmNtcDt, String cgoClmAcknakDt, String hpd, String nhp, String factFndDt, String factFndDesc, String trnsFlg, String clmTrnsAuthCd, String trnsSeq, String csClzRopnDt, String cgoClmDivCd, String cpDesc, String clmtClmPtyNo, String clmtClmTpCd, String clmtRefNo, String fmalClmRcvOfcCd, String fmalClmRcvDt, String cgoClmTpCd, String mjrClmDmgLssCd, String n3rdLablPtyCd, String cgoClmInciNo, String clmtLoclAmt, String clmtLoclCurrCd, String clmtLoclXchRt, String clmtUsdAmt, String clmCuzDesc, String clmAgnClmPtyNo, String insurAgnClmPtyNo, String clmtAgnTpCd, String clmtAgnApntDt, String clmtAgnRefNo, String clmRvwDesc, String cgoClmStsCd, String cgoClmStsNm, String bfrCgoClmStsCd, String cgoClmClzCd, String preCgoClmClzCd, String crmVocNo, String updUsrId, String updDt, String trnkRefVvdNo, String clmCgoTpCd, String cgoQltyDesc, String crrTermCd, String clmOfrtAmt, String clmOfrtTermCd, String clmOfrtFlg, String porCd, String rctDt, String polCd, String lodgDt, String podCd, String dchgDt, String delCd, String deDt, String n1stPreRefVvdNo, String n2ndPreRefVvdNo, String n3rdPreRefVvdNo, String n1stPreTsLocCd, String n1stPreTsDt, String n2ndPreTsLocCd, String n2ndPreTsDt, String n1stPstRefVvdNo, String n2ndPstRefVvdNo, String n3rdPstRefVvdNo, String n1stPstTsLocCd, String n1stPstTsDt, String n2ndPstTsLocCd, String n2ndPstTsDt, String slanCd, String inciPlcTpCd, String inciOccrDt, String insurClmPtyNo, String insurRefNo, String agnCrspnTpCd, String agnCrspnApntDt, String agnCrspnRefNo, String lablPtyFmalClmDt, String lablPtyDmndUsdAmt, String lablClmPtyNo, String lablClmPtyAbbrNm, String sveyClmPtyNo, String sveyClmPtyAbbrNm, String cgoClmStlTpCd, String svyrTpCd, String sveyInpDt, String clmAreaCd, String pltNm, String deftNm, String deftAttyClmPtyNo, String deftAttyApntDt, String refDeftAttyNo, String crtNm, String crtCsNo, String cplnFileDt, String jmtRsltCd, String jmtRsltDt, String smnsSveDt, String ltgtCsDesc, String cgoClmRefCntrNo, String ligtUpdUsrId, String ligtUpdDt, String cgoClmRefBlNo, String mnBlFlg, String clmAgnClmPtyAbbrNm, String clmAgnClmPtyNm, String clmAgnIntlPhnNo, String clmAgnPhnNo, String clmAgnPtyEml, String insurAgnClmPtyAbbrNm, String insurAgnClmPtyNm, String insurAgnIntlPhnNo, String insurAgnPhnNo, String insurAgnPtyEml, String deftAttyClmPtyAbbrNm, String deftAttyClmPtyNm, String insurClmPtyAbbrNm, String clmtClmPtyAbbrNm, String clmtClmPtyNm, String vslEngNm, String insurVslTpCd, String insurVslOshpCd) {
		this.ligtUpdDt = ligtUpdDt;
		this.trnkRefVvdNo = trnkRefVvdNo;
		this.n3rdPreRefVvdNo = n3rdPreRefVvdNo;
		this.smnsSveDt = smnsSveDt;
		this.fmalClmRcvDt = fmalClmRcvDt;
		this.clmOfrtAmt = clmOfrtAmt;
		this.agnCrspnTpCd = agnCrspnTpCd;
		this.clmtClmPtyAbbrNm = clmtClmPtyAbbrNm;
		this.pagerows = pagerows;
		this.sveyClmPtyNo = sveyClmPtyNo;
		this.insurClmPtyAbbrNm = insurClmPtyAbbrNm;
		this.mnBlFlg = mnBlFlg;
		this.pltNm = pltNm;
		this.lablClmPtyNo = lablClmPtyNo;
		this.clmCuzDesc = clmCuzDesc;
		this.clmOfrtTermCd = clmOfrtTermCd;
		this.cgoClmRefBlNo = cgoClmRefBlNo;
		this.updUsrId = updUsrId;
		this.cgoClmDivCd = cgoClmDivCd;
		this.nhp = nhp;
		this.trnsSeq = trnsSeq;
		this.hpd = hpd;
		this.cgoClmAcknakDt = cgoClmAcknakDt;
		this.inciOccrDt = inciOccrDt;
		this.jmtRsltDt = jmtRsltDt;
		this.podCd = podCd;
		this.cgoClmStlTpCd = cgoClmStlTpCd;
		this.ltgtCsDesc = ltgtCsDesc;
		this.clmTmBarDt = clmTmBarDt;
		this.fmalClmRcvOfcCd = fmalClmRcvOfcCd;
		this.clmAgnIntlPhnNo = clmAgnIntlPhnNo;
		this.n3rdLablPtyCd = n3rdLablPtyCd;
		this.inciPlcTpCd = inciPlcTpCd;
		this.lablPtyFmalClmDt = lablPtyFmalClmDt;
		this.hdlrOfcCd = hdlrOfcCd;
		this.sveyClmPtyAbbrNm = sveyClmPtyAbbrNm;
		this.clmtLoclXchRt = clmtLoclXchRt;
		this.clmtRefNo = clmtRefNo;
		this.clmtLoclAmt = clmtLoclAmt;
		this.trnsFlg = trnsFlg;
		this.bfrCgoClmStsCd = bfrCgoClmStsCd;
		this.deDt = deDt;
		this.lablPtyDmndUsdAmt = lablPtyDmndUsdAmt;
		this.crrTermCd = crrTermCd;
		this.deftAttyClmPtyNm = deftAttyClmPtyNm;
		this.n1stPstTsDt = n1stPstTsDt;
		this.agnCrspnApntDt = agnCrspnApntDt;
		this.n2ndPreTsDt = n2ndPreTsDt;
		this.insurAgnClmPtyAbbrNm = insurAgnClmPtyAbbrNm;
		this.deftAttyClmPtyNo = deftAttyClmPtyNo;
		this.factFndDesc = factFndDesc;
		this.lablTmBarDt = lablTmBarDt;
		this.csClzRopnDt = csClzRopnDt;
		this.insurAgnClmPtyNm = insurAgnClmPtyNm;
		this.clmAgnPtyEml = clmAgnPtyEml;
		this.crtNm = crtNm;
		this.insurAgnClmPtyNo = insurAgnClmPtyNo;
		this.insurAgnIntlPhnNo = insurAgnIntlPhnNo;
		this.ligtUpdUsrId = ligtUpdUsrId;
		this.factFndDt = factFndDt;
		this.cgoClmRefCntrNo = cgoClmRefCntrNo;
		this.n2ndPreRefVvdNo = n2ndPreRefVvdNo;
		this.slanCd = slanCd;
		this.lodgDt = lodgDt;
		this.insurAgnPhnNo = insurAgnPhnNo;
		this.cgoClmInciNo = cgoClmInciNo;
		this.clmtAgnRefNo = clmtAgnRefNo;
		this.jmtRsltCd = jmtRsltCd;
		this.n2ndPstTsLocCd = n2ndPstTsLocCd;
		this.cgoClmClzCd = cgoClmClzCd;
		this.svyrTpCd = svyrTpCd;
		this.cgoQltyDesc = cgoQltyDesc;
		this.n2ndPstTsDt = n2ndPstTsDt;
		this.cgoClmStsNm = cgoClmStsNm;
		this.preCgoClmClzCd = preCgoClmClzCd;
		this.n1stPstRefVvdNo = n1stPstRefVvdNo;
		this.insurRefNo = insurRefNo;
		this.clmCgoTpCd = clmCgoTpCd;
		this.polCd = polCd;
		this.n3rdPstRefVvdNo = n3rdPstRefVvdNo;
		this.prlmClmNtcDt = prlmClmNtcDt;
		this.cgoClmNo = cgoClmNo;
		this.agnCrspnRefNo = agnCrspnRefNo;
		this.mjrClmDmgLssCd = mjrClmDmgLssCd;
		this.n1stPreTsDt = n1stPreTsDt;
		this.clmAgnClmPtyNm = clmAgnClmPtyNm;
		this.delCd = delCd;
		this.sveyInpDt = sveyInpDt;
		this.clmtLoclCurrCd = clmtLoclCurrCd;
		this.clmAgnClmPtyNo = clmAgnClmPtyNo;
		this.cpDesc = cpDesc;
		this.crtCsNo = crtCsNo;
		this.insurVslOshpCd = insurVslOshpCd;
		this.clmtUsdAmt = clmtUsdAmt;
		this.crmVocNo = crmVocNo;
		this.insurClmPtyNo = insurClmPtyNo;
		this.cgoClmTpCd = cgoClmTpCd;
		this.porCd = porCd;
		this.clmAgnClmPtyAbbrNm = clmAgnClmPtyAbbrNm;
		this.csClzDt = csClzDt;
		this.clmTrnsAuthCd = clmTrnsAuthCd;
		this.clmtClmPtyNm = clmtClmPtyNm;
		this.lablClmPtyAbbrNm = lablClmPtyAbbrNm;
		this.clmtClmPtyNo = clmtClmPtyNo;
		this.n1stPreTsLocCd = n1stPreTsLocCd;
		this.clmtAgnApntDt = clmtAgnApntDt;
		this.ibflag = ibflag;
		this.deftNm = deftNm;
		this.vslEngNm = vslEngNm;
		this.n2ndPstRefVvdNo = n2ndPstRefVvdNo;
		this.cgoClmStsCd = cgoClmStsCd;
		this.clmRvwDesc = clmRvwDesc;
		this.insurAgnPtyEml = insurAgnPtyEml;
		this.n2ndPreTsLocCd = n2ndPreTsLocCd;
		this.updDt = updDt;
		this.n1stPstTsLocCd = n1stPstTsLocCd;
		this.dchgDt = dchgDt;
		this.deftAttyClmPtyAbbrNm = deftAttyClmPtyAbbrNm;
		this.insurVslTpCd = insurVslTpCd;
		this.clmtAgnTpCd = clmtAgnTpCd;
		this.clmtClmTpCd = clmtClmTpCd;
		this.clmAgnPhnNo = clmAgnPhnNo;
		this.cplnFileDt = cplnFileDt;
		this.deftAttyApntDt = deftAttyApntDt;
		this.hdlrUsrId = hdlrUsrId;
		this.clmOfrtFlg = clmOfrtFlg;
		this.rctDt = rctDt;
		this.n1stPreRefVvdNo = n1stPreRefVvdNo;
		this.refDeftAttyNo = refDeftAttyNo;
		this.clmAreaCd = clmAreaCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ligt_upd_dt", getLigtUpdDt());
		this.hashColumns.put("trnk_ref_vvd_no", getTrnkRefVvdNo());
		this.hashColumns.put("n3rd_pre_ref_vvd_no", getN3rdPreRefVvdNo());
		this.hashColumns.put("smns_sve_dt", getSmnsSveDt());
		this.hashColumns.put("fmal_clm_rcv_dt", getFmalClmRcvDt());
		this.hashColumns.put("clm_ofrt_amt", getClmOfrtAmt());
		this.hashColumns.put("agn_crspn_tp_cd", getAgnCrspnTpCd());
		this.hashColumns.put("clmt_clm_pty_abbr_nm", getClmtClmPtyAbbrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("svey_clm_pty_no", getSveyClmPtyNo());
		this.hashColumns.put("insur_clm_pty_abbr_nm", getInsurClmPtyAbbrNm());
		this.hashColumns.put("mn_bl_flg", getMnBlFlg());
		this.hashColumns.put("plt_nm", getPltNm());
		this.hashColumns.put("labl_clm_pty_no", getLablClmPtyNo());
		this.hashColumns.put("clm_cuz_desc", getClmCuzDesc());
		this.hashColumns.put("clm_ofrt_term_cd", getClmOfrtTermCd());
		this.hashColumns.put("cgo_clm_ref_bl_no", getCgoClmRefBlNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cgo_clm_div_cd", getCgoClmDivCd());
		this.hashColumns.put("nhp", getNhp());
		this.hashColumns.put("trns_seq", getTrnsSeq());
		this.hashColumns.put("hpd", getHpd());
		this.hashColumns.put("cgo_clm_acknak_dt", getCgoClmAcknakDt());
		this.hashColumns.put("inci_occr_dt", getInciOccrDt());
		this.hashColumns.put("jmt_rslt_dt", getJmtRsltDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cgo_clm_stl_tp_cd", getCgoClmStlTpCd());
		this.hashColumns.put("ltgt_cs_desc", getLtgtCsDesc());
		this.hashColumns.put("clm_tm_bar_dt", getClmTmBarDt());
		this.hashColumns.put("fmal_clm_rcv_ofc_cd", getFmalClmRcvOfcCd());
		this.hashColumns.put("clm_agn_intl_phn_no", getClmAgnIntlPhnNo());
		this.hashColumns.put("n3rd_labl_pty_cd", getN3rdLablPtyCd());
		this.hashColumns.put("inci_plc_tp_cd", getInciPlcTpCd());
		this.hashColumns.put("labl_pty_fmal_clm_dt", getLablPtyFmalClmDt());
		this.hashColumns.put("hdlr_ofc_cd", getHdlrOfcCd());
		this.hashColumns.put("svey_clm_pty_abbr_nm", getSveyClmPtyAbbrNm());
		this.hashColumns.put("clmt_locl_xch_rt", getClmtLoclXchRt());
		this.hashColumns.put("clmt_ref_no", getClmtRefNo());
		this.hashColumns.put("clmt_locl_amt", getClmtLoclAmt());
		this.hashColumns.put("trns_flg", getTrnsFlg());
		this.hashColumns.put("bfr_cgo_clm_sts_cd", getBfrCgoClmStsCd());
		this.hashColumns.put("de_dt", getDeDt());
		this.hashColumns.put("labl_pty_dmnd_usd_amt", getLablPtyDmndUsdAmt());
		this.hashColumns.put("crr_term_cd", getCrrTermCd());
		this.hashColumns.put("deft_atty_clm_pty_nm", getDeftAttyClmPtyNm());
		this.hashColumns.put("n1st_pst_ts_dt", getN1stPstTsDt());
		this.hashColumns.put("agn_crspn_apnt_dt", getAgnCrspnApntDt());
		this.hashColumns.put("n2nd_pre_ts_dt", getN2ndPreTsDt());
		this.hashColumns.put("insur_agn_clm_pty_abbr_nm", getInsurAgnClmPtyAbbrNm());
		this.hashColumns.put("deft_atty_clm_pty_no", getDeftAttyClmPtyNo());
		this.hashColumns.put("fact_fnd_desc", getFactFndDesc());
		this.hashColumns.put("labl_tm_bar_dt", getLablTmBarDt());
		this.hashColumns.put("cs_clz_ropn_dt", getCsClzRopnDt());
		this.hashColumns.put("insur_agn_clm_pty_nm", getInsurAgnClmPtyNm());
		this.hashColumns.put("clm_agn_pty_eml", getClmAgnPtyEml());
		this.hashColumns.put("crt_nm", getCrtNm());
		this.hashColumns.put("insur_agn_clm_pty_no", getInsurAgnClmPtyNo());
		this.hashColumns.put("insur_agn_intl_phn_no", getInsurAgnIntlPhnNo());
		this.hashColumns.put("ligt_upd_usr_id", getLigtUpdUsrId());
		this.hashColumns.put("fact_fnd_dt", getFactFndDt());
		this.hashColumns.put("cgo_clm_ref_cntr_no", getCgoClmRefCntrNo());
		this.hashColumns.put("n2nd_pre_ref_vvd_no", getN2ndPreRefVvdNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("lodg_dt", getLodgDt());
		this.hashColumns.put("insur_agn_phn_no", getInsurAgnPhnNo());
		this.hashColumns.put("cgo_clm_inci_no", getCgoClmInciNo());
		this.hashColumns.put("clmt_agn_ref_no", getClmtAgnRefNo());
		this.hashColumns.put("jmt_rslt_cd", getJmtRsltCd());
		this.hashColumns.put("n2nd_pst_ts_loc_cd", getN2ndPstTsLocCd());
		this.hashColumns.put("cgo_clm_clz_cd", getCgoClmClzCd());
		this.hashColumns.put("svyr_tp_cd", getSvyrTpCd());
		this.hashColumns.put("cgo_qlty_desc", getCgoQltyDesc());
		this.hashColumns.put("n2nd_pst_ts_dt", getN2ndPstTsDt());
		this.hashColumns.put("cgo_clm_sts_nm", getCgoClmStsNm());
		this.hashColumns.put("pre_cgo_clm_clz_cd", getPreCgoClmClzCd());
		this.hashColumns.put("n1st_pst_ref_vvd_no", getN1stPstRefVvdNo());
		this.hashColumns.put("insur_ref_no", getInsurRefNo());
		this.hashColumns.put("clm_cgo_tp_cd", getClmCgoTpCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("n3rd_pst_ref_vvd_no", getN3rdPstRefVvdNo());
		this.hashColumns.put("prlm_clm_ntc_dt", getPrlmClmNtcDt());
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());
		this.hashColumns.put("agn_crspn_ref_no", getAgnCrspnRefNo());
		this.hashColumns.put("mjr_clm_dmg_lss_cd", getMjrClmDmgLssCd());
		this.hashColumns.put("n1st_pre_ts_dt", getN1stPreTsDt());
		this.hashColumns.put("clm_agn_clm_pty_nm", getClmAgnClmPtyNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("svey_inp_dt", getSveyInpDt());
		this.hashColumns.put("clmt_locl_curr_cd", getClmtLoclCurrCd());
		this.hashColumns.put("clm_agn_clm_pty_no", getClmAgnClmPtyNo());
		this.hashColumns.put("cp_desc", getCpDesc());
		this.hashColumns.put("crt_cs_no", getCrtCsNo());
		this.hashColumns.put("insur_vsl_oshp_cd", getInsurVslOshpCd());
		this.hashColumns.put("clmt_usd_amt", getClmtUsdAmt());
		this.hashColumns.put("crm_voc_no", getCrmVocNo());
		this.hashColumns.put("insur_clm_pty_no", getInsurClmPtyNo());
		this.hashColumns.put("cgo_clm_tp_cd", getCgoClmTpCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("clm_agn_clm_pty_abbr_nm", getClmAgnClmPtyAbbrNm());
		this.hashColumns.put("cs_clz_dt", getCsClzDt());
		this.hashColumns.put("clm_trns_auth_cd", getClmTrnsAuthCd());
		this.hashColumns.put("clmt_clm_pty_nm", getClmtClmPtyNm());
		this.hashColumns.put("labl_clm_pty_abbr_nm", getLablClmPtyAbbrNm());
		this.hashColumns.put("clmt_clm_pty_no", getClmtClmPtyNo());
		this.hashColumns.put("n1st_pre_ts_loc_cd", getN1stPreTsLocCd());
		this.hashColumns.put("clmt_agn_apnt_dt", getClmtAgnApntDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("deft_nm", getDeftNm());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("n2nd_pst_ref_vvd_no", getN2ndPstRefVvdNo());
		this.hashColumns.put("cgo_clm_sts_cd", getCgoClmStsCd());
		this.hashColumns.put("clm_rvw_desc", getClmRvwDesc());
		this.hashColumns.put("insur_agn_pty_eml", getInsurAgnPtyEml());
		this.hashColumns.put("n2nd_pre_ts_loc_cd", getN2ndPreTsLocCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n1st_pst_ts_loc_cd", getN1stPstTsLocCd());
		this.hashColumns.put("dchg_dt", getDchgDt());
		this.hashColumns.put("deft_atty_clm_pty_abbr_nm", getDeftAttyClmPtyAbbrNm());
		this.hashColumns.put("insur_vsl_tp_cd", getInsurVslTpCd());
		this.hashColumns.put("clmt_agn_tp_cd", getClmtAgnTpCd());
		this.hashColumns.put("clmt_clm_tp_cd", getClmtClmTpCd());
		this.hashColumns.put("clm_agn_phn_no", getClmAgnPhnNo());
		this.hashColumns.put("cpln_file_dt", getCplnFileDt());
		this.hashColumns.put("deft_atty_apnt_dt", getDeftAttyApntDt());
		this.hashColumns.put("hdlr_usr_id", getHdlrUsrId());
		this.hashColumns.put("clm_ofrt_flg", getClmOfrtFlg());
		this.hashColumns.put("rct_dt", getRctDt());
		this.hashColumns.put("n1st_pre_ref_vvd_no", getN1stPreRefVvdNo());
		this.hashColumns.put("ref_deft_atty_no", getRefDeftAttyNo());
		this.hashColumns.put("clm_area_cd", getClmAreaCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ligt_upd_dt", "ligtUpdDt");
		this.hashFields.put("trnk_ref_vvd_no", "trnkRefVvdNo");
		this.hashFields.put("n3rd_pre_ref_vvd_no", "n3rdPreRefVvdNo");
		this.hashFields.put("smns_sve_dt", "smnsSveDt");
		this.hashFields.put("fmal_clm_rcv_dt", "fmalClmRcvDt");
		this.hashFields.put("clm_ofrt_amt", "clmOfrtAmt");
		this.hashFields.put("agn_crspn_tp_cd", "agnCrspnTpCd");
		this.hashFields.put("clmt_clm_pty_abbr_nm", "clmtClmPtyAbbrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("svey_clm_pty_no", "sveyClmPtyNo");
		this.hashFields.put("insur_clm_pty_abbr_nm", "insurClmPtyAbbrNm");
		this.hashFields.put("mn_bl_flg", "mnBlFlg");
		this.hashFields.put("plt_nm", "pltNm");
		this.hashFields.put("labl_clm_pty_no", "lablClmPtyNo");
		this.hashFields.put("clm_cuz_desc", "clmCuzDesc");
		this.hashFields.put("clm_ofrt_term_cd", "clmOfrtTermCd");
		this.hashFields.put("cgo_clm_ref_bl_no", "cgoClmRefBlNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cgo_clm_div_cd", "cgoClmDivCd");
		this.hashFields.put("nhp", "nhp");
		this.hashFields.put("trns_seq", "trnsSeq");
		this.hashFields.put("hpd", "hpd");
		this.hashFields.put("cgo_clm_acknak_dt", "cgoClmAcknakDt");
		this.hashFields.put("inci_occr_dt", "inciOccrDt");
		this.hashFields.put("jmt_rslt_dt", "jmtRsltDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cgo_clm_stl_tp_cd", "cgoClmStlTpCd");
		this.hashFields.put("ltgt_cs_desc", "ltgtCsDesc");
		this.hashFields.put("clm_tm_bar_dt", "clmTmBarDt");
		this.hashFields.put("fmal_clm_rcv_ofc_cd", "fmalClmRcvOfcCd");
		this.hashFields.put("clm_agn_intl_phn_no", "clmAgnIntlPhnNo");
		this.hashFields.put("n3rd_labl_pty_cd", "n3rdLablPtyCd");
		this.hashFields.put("inci_plc_tp_cd", "inciPlcTpCd");
		this.hashFields.put("labl_pty_fmal_clm_dt", "lablPtyFmalClmDt");
		this.hashFields.put("hdlr_ofc_cd", "hdlrOfcCd");
		this.hashFields.put("svey_clm_pty_abbr_nm", "sveyClmPtyAbbrNm");
		this.hashFields.put("clmt_locl_xch_rt", "clmtLoclXchRt");
		this.hashFields.put("clmt_ref_no", "clmtRefNo");
		this.hashFields.put("clmt_locl_amt", "clmtLoclAmt");
		this.hashFields.put("trns_flg", "trnsFlg");
		this.hashFields.put("bfr_cgo_clm_sts_cd", "bfrCgoClmStsCd");
		this.hashFields.put("de_dt", "deDt");
		this.hashFields.put("labl_pty_dmnd_usd_amt", "lablPtyDmndUsdAmt");
		this.hashFields.put("crr_term_cd", "crrTermCd");
		this.hashFields.put("deft_atty_clm_pty_nm", "deftAttyClmPtyNm");
		this.hashFields.put("n1st_pst_ts_dt", "n1stPstTsDt");
		this.hashFields.put("agn_crspn_apnt_dt", "agnCrspnApntDt");
		this.hashFields.put("n2nd_pre_ts_dt", "n2ndPreTsDt");
		this.hashFields.put("insur_agn_clm_pty_abbr_nm", "insurAgnClmPtyAbbrNm");
		this.hashFields.put("deft_atty_clm_pty_no", "deftAttyClmPtyNo");
		this.hashFields.put("fact_fnd_desc", "factFndDesc");
		this.hashFields.put("labl_tm_bar_dt", "lablTmBarDt");
		this.hashFields.put("cs_clz_ropn_dt", "csClzRopnDt");
		this.hashFields.put("insur_agn_clm_pty_nm", "insurAgnClmPtyNm");
		this.hashFields.put("clm_agn_pty_eml", "clmAgnPtyEml");
		this.hashFields.put("crt_nm", "crtNm");
		this.hashFields.put("insur_agn_clm_pty_no", "insurAgnClmPtyNo");
		this.hashFields.put("insur_agn_intl_phn_no", "insurAgnIntlPhnNo");
		this.hashFields.put("ligt_upd_usr_id", "ligtUpdUsrId");
		this.hashFields.put("fact_fnd_dt", "factFndDt");
		this.hashFields.put("cgo_clm_ref_cntr_no", "cgoClmRefCntrNo");
		this.hashFields.put("n2nd_pre_ref_vvd_no", "n2ndPreRefVvdNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("lodg_dt", "lodgDt");
		this.hashFields.put("insur_agn_phn_no", "insurAgnPhnNo");
		this.hashFields.put("cgo_clm_inci_no", "cgoClmInciNo");
		this.hashFields.put("clmt_agn_ref_no", "clmtAgnRefNo");
		this.hashFields.put("jmt_rslt_cd", "jmtRsltCd");
		this.hashFields.put("n2nd_pst_ts_loc_cd", "n2ndPstTsLocCd");
		this.hashFields.put("cgo_clm_clz_cd", "cgoClmClzCd");
		this.hashFields.put("svyr_tp_cd", "svyrTpCd");
		this.hashFields.put("cgo_qlty_desc", "cgoQltyDesc");
		this.hashFields.put("n2nd_pst_ts_dt", "n2ndPstTsDt");
		this.hashFields.put("cgo_clm_sts_nm", "cgoClmStsNm");
		this.hashFields.put("pre_cgo_clm_clz_cd", "preCgoClmClzCd");
		this.hashFields.put("n1st_pst_ref_vvd_no", "n1stPstRefVvdNo");
		this.hashFields.put("insur_ref_no", "insurRefNo");
		this.hashFields.put("clm_cgo_tp_cd", "clmCgoTpCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("n3rd_pst_ref_vvd_no", "n3rdPstRefVvdNo");
		this.hashFields.put("prlm_clm_ntc_dt", "prlmClmNtcDt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("agn_crspn_ref_no", "agnCrspnRefNo");
		this.hashFields.put("mjr_clm_dmg_lss_cd", "mjrClmDmgLssCd");
		this.hashFields.put("n1st_pre_ts_dt", "n1stPreTsDt");
		this.hashFields.put("clm_agn_clm_pty_nm", "clmAgnClmPtyNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("svey_inp_dt", "sveyInpDt");
		this.hashFields.put("clmt_locl_curr_cd", "clmtLoclCurrCd");
		this.hashFields.put("clm_agn_clm_pty_no", "clmAgnClmPtyNo");
		this.hashFields.put("cp_desc", "cpDesc");
		this.hashFields.put("crt_cs_no", "crtCsNo");
		this.hashFields.put("insur_vsl_oshp_cd", "insurVslOshpCd");
		this.hashFields.put("clmt_usd_amt", "clmtUsdAmt");
		this.hashFields.put("crm_voc_no", "crmVocNo");
		this.hashFields.put("insur_clm_pty_no", "insurClmPtyNo");
		this.hashFields.put("cgo_clm_tp_cd", "cgoClmTpCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("clm_agn_clm_pty_abbr_nm", "clmAgnClmPtyAbbrNm");
		this.hashFields.put("cs_clz_dt", "csClzDt");
		this.hashFields.put("clm_trns_auth_cd", "clmTrnsAuthCd");
		this.hashFields.put("clmt_clm_pty_nm", "clmtClmPtyNm");
		this.hashFields.put("labl_clm_pty_abbr_nm", "lablClmPtyAbbrNm");
		this.hashFields.put("clmt_clm_pty_no", "clmtClmPtyNo");
		this.hashFields.put("n1st_pre_ts_loc_cd", "n1stPreTsLocCd");
		this.hashFields.put("clmt_agn_apnt_dt", "clmtAgnApntDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("deft_nm", "deftNm");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("n2nd_pst_ref_vvd_no", "n2ndPstRefVvdNo");
		this.hashFields.put("cgo_clm_sts_cd", "cgoClmStsCd");
		this.hashFields.put("clm_rvw_desc", "clmRvwDesc");
		this.hashFields.put("insur_agn_pty_eml", "insurAgnPtyEml");
		this.hashFields.put("n2nd_pre_ts_loc_cd", "n2ndPreTsLocCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n1st_pst_ts_loc_cd", "n1stPstTsLocCd");
		this.hashFields.put("dchg_dt", "dchgDt");
		this.hashFields.put("deft_atty_clm_pty_abbr_nm", "deftAttyClmPtyAbbrNm");
		this.hashFields.put("insur_vsl_tp_cd", "insurVslTpCd");
		this.hashFields.put("clmt_agn_tp_cd", "clmtAgnTpCd");
		this.hashFields.put("clmt_clm_tp_cd", "clmtClmTpCd");
		this.hashFields.put("clm_agn_phn_no", "clmAgnPhnNo");
		this.hashFields.put("cpln_file_dt", "cplnFileDt");
		this.hashFields.put("deft_atty_apnt_dt", "deftAttyApntDt");
		this.hashFields.put("hdlr_usr_id", "hdlrUsrId");
		this.hashFields.put("clm_ofrt_flg", "clmOfrtFlg");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("n1st_pre_ref_vvd_no", "n1stPreRefVvdNo");
		this.hashFields.put("ref_deft_atty_no", "refDeftAttyNo");
		this.hashFields.put("clm_area_cd", "clmAreaCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ligtUpdDt
	 */
	public String getLigtUpdDt() {
		return this.ligtUpdDt;
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
	 * @return n3rdPreRefVvdNo
	 */
	public String getN3rdPreRefVvdNo() {
		return this.n3rdPreRefVvdNo;
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
	 * @return clmOfrtAmt
	 */
	public String getClmOfrtAmt() {
		return this.clmOfrtAmt;
	}
	
	/**
	 * Column Info
	 * @return agnCrspnTpCd
	 */
	public String getAgnCrspnTpCd() {
		return this.agnCrspnTpCd;
	}
	
	/**
	 * Column Info
	 * @return clmtClmPtyAbbrNm
	 */
	public String getClmtClmPtyAbbrNm() {
		return this.clmtClmPtyAbbrNm;
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
	 * @return sveyClmPtyNo
	 */
	public String getSveyClmPtyNo() {
		return this.sveyClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return insurClmPtyAbbrNm
	 */
	public String getInsurClmPtyAbbrNm() {
		return this.insurClmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return mnBlFlg
	 */
	public String getMnBlFlg() {
		return this.mnBlFlg;
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
	 * @return lablClmPtyNo
	 */
	public String getLablClmPtyNo() {
		return this.lablClmPtyNo;
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
	 * @return clmOfrtTermCd
	 */
	public String getClmOfrtTermCd() {
		return this.clmOfrtTermCd;
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
	 * @return cgoClmDivCd
	 */
	public String getCgoClmDivCd() {
		return this.cgoClmDivCd;
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
	 * @return trnsSeq
	 */
	public String getTrnsSeq() {
		return this.trnsSeq;
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
	 * @return jmtRsltDt
	 */
	public String getJmtRsltDt() {
		return this.jmtRsltDt;
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
	 * @return cgoClmStlTpCd
	 */
	public String getCgoClmStlTpCd() {
		return this.cgoClmStlTpCd;
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
	 * @return clmTmBarDt
	 */
	public String getClmTmBarDt() {
		return this.clmTmBarDt;
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
	 * @return clmAgnIntlPhnNo
	 */
	public String getClmAgnIntlPhnNo() {
		return this.clmAgnIntlPhnNo;
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
	 * @return inciPlcTpCd
	 */
	public String getInciPlcTpCd() {
		return this.inciPlcTpCd;
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
	 * @return sveyClmPtyAbbrNm
	 */
	public String getSveyClmPtyAbbrNm() {
		return this.sveyClmPtyAbbrNm;
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
	 * @return bfrCgoClmStsCd
	 */
	public String getBfrCgoClmStsCd() {
		return this.bfrCgoClmStsCd;
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
	 * @return crrTermCd
	 */
	public String getCrrTermCd() {
		return this.crrTermCd;
	}
	
	/**
	 * Column Info
	 * @return deftAttyClmPtyNm
	 */
	public String getDeftAttyClmPtyNm() {
		return this.deftAttyClmPtyNm;
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
	 * @return agnCrspnApntDt
	 */
	public String getAgnCrspnApntDt() {
		return this.agnCrspnApntDt;
	}
	
	/**
	 * Column Info
	 * @return n2ndPreTsDt
	 */
	public String getN2ndPreTsDt() {
		return this.n2ndPreTsDt;
	}
	
	/**
	 * Column Info
	 * @return insurAgnClmPtyAbbrNm
	 */
	public String getInsurAgnClmPtyAbbrNm() {
		return this.insurAgnClmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return deftAttyClmPtyNo
	 */
	public String getDeftAttyClmPtyNo() {
		return this.deftAttyClmPtyNo;
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
	 * @return lablTmBarDt
	 */
	public String getLablTmBarDt() {
		return this.lablTmBarDt;
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
	 * @return insurAgnClmPtyNm
	 */
	public String getInsurAgnClmPtyNm() {
		return this.insurAgnClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @return clmAgnPtyEml
	 */
	public String getClmAgnPtyEml() {
		return this.clmAgnPtyEml;
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
	 * @return insurAgnClmPtyNo
	 */
	public String getInsurAgnClmPtyNo() {
		return this.insurAgnClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @return insurAgnIntlPhnNo
	 */
	public String getInsurAgnIntlPhnNo() {
		return this.insurAgnIntlPhnNo;
	}
	
	/**
	 * Column Info
	 * @return ligtUpdUsrId
	 */
	public String getLigtUpdUsrId() {
		return this.ligtUpdUsrId;
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
	 * @return cgoClmRefCntrNo
	 */
	public String getCgoClmRefCntrNo() {
		return this.cgoClmRefCntrNo;
	}
	
	/**
	 * Column Info
	 * @return n2ndPreRefVvdNo
	 */
	public String getN2ndPreRefVvdNo() {
		return this.n2ndPreRefVvdNo;
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
	 * @return lodgDt
	 */
	public String getLodgDt() {
		return this.lodgDt;
	}
	
	/**
	 * Column Info
	 * @return insurAgnPhnNo
	 */
	public String getInsurAgnPhnNo() {
		return this.insurAgnPhnNo;
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
	 * @return clmtAgnRefNo
	 */
	public String getClmtAgnRefNo() {
		return this.clmtAgnRefNo;
	}
	
	/**
	 * Column Info
	 * @return jmtRsltCd
	 */
	public String getJmtRsltCd() {
		return this.jmtRsltCd;
	}
	
	/**
	 * Column Info
	 * @return n2ndPstTsLocCd
	 */
	public String getN2ndPstTsLocCd() {
		return this.n2ndPstTsLocCd;
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
	 * @return svyrTpCd
	 */
	public String getSvyrTpCd() {
		return this.svyrTpCd;
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
	 * @return n2ndPstTsDt
	 */
	public String getN2ndPstTsDt() {
		return this.n2ndPstTsDt;
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
	 * @return preCgoClmClzCd
	 */
	public String getPreCgoClmClzCd() {
		return this.preCgoClmClzCd;
	}
	
	/**
	 * Column Info
	 * @return n1stPstRefVvdNo
	 */
	public String getN1stPstRefVvdNo() {
		return this.n1stPstRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return insurRefNo
	 */
	public String getInsurRefNo() {
		return this.insurRefNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return n3rdPstRefVvdNo
	 */
	public String getN3rdPstRefVvdNo() {
		return this.n3rdPstRefVvdNo;
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
	 * @return cgoClmNo
	 */
	public String getCgoClmNo() {
		return this.cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @return agnCrspnRefNo
	 */
	public String getAgnCrspnRefNo() {
		return this.agnCrspnRefNo;
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
	 * @return n1stPreTsDt
	 */
	public String getN1stPreTsDt() {
		return this.n1stPreTsDt;
	}
	
	/**
	 * Column Info
	 * @return clmAgnClmPtyNm
	 */
	public String getClmAgnClmPtyNm() {
		return this.clmAgnClmPtyNm;
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
	 * @return sveyInpDt
	 */
	public String getSveyInpDt() {
		return this.sveyInpDt;
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
	 * @return clmAgnClmPtyNo
	 */
	public String getClmAgnClmPtyNo() {
		return this.clmAgnClmPtyNo;
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
	 * @return crtCsNo
	 */
	public String getCrtCsNo() {
		return this.crtCsNo;
	}
	
	/**
	 * Column Info
	 * @return insurVslOshpCd
	 */
	public String getInsurVslOshpCd() {
		return this.insurVslOshpCd;
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
	 * @return insurClmPtyNo
	 */
	public String getInsurClmPtyNo() {
		return this.insurClmPtyNo;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return clmAgnClmPtyAbbrNm
	 */
	public String getClmAgnClmPtyAbbrNm() {
		return this.clmAgnClmPtyAbbrNm;
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
	 * @return clmTrnsAuthCd
	 */
	public String getClmTrnsAuthCd() {
		return this.clmTrnsAuthCd;
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
	 * @return lablClmPtyAbbrNm
	 */
	public String getLablClmPtyAbbrNm() {
		return this.lablClmPtyAbbrNm;
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
	 * @return n1stPreTsLocCd
	 */
	public String getN1stPreTsLocCd() {
		return this.n1stPreTsLocCd;
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
	 * @return deftNm
	 */
	public String getDeftNm() {
		return this.deftNm;
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
	 * @return n2ndPstRefVvdNo
	 */
	public String getN2ndPstRefVvdNo() {
		return this.n2ndPstRefVvdNo;
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
	 * @return insurAgnPtyEml
	 */
	public String getInsurAgnPtyEml() {
		return this.insurAgnPtyEml;
	}
	
	/**
	 * Column Info
	 * @return n2ndPreTsLocCd
	 */
	public String getN2ndPreTsLocCd() {
		return this.n2ndPreTsLocCd;
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
	 * @return deftAttyClmPtyAbbrNm
	 */
	public String getDeftAttyClmPtyAbbrNm() {
		return this.deftAttyClmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @return insurVslTpCd
	 */
	public String getInsurVslTpCd() {
		return this.insurVslTpCd;
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
	 * @return clmtClmTpCd
	 */
	public String getClmtClmTpCd() {
		return this.clmtClmTpCd;
	}
	
	/**
	 * Column Info
	 * @return clmAgnPhnNo
	 */
	public String getClmAgnPhnNo() {
		return this.clmAgnPhnNo;
	}
	
	/**
	 * Column Info
	 * @return cplnFileDt
	 */
	public String getCplnFileDt() {
		return this.cplnFileDt;
	}
	
	/**
	 * Column Info
	 * @return deftAttyApntDt
	 */
	public String getDeftAttyApntDt() {
		return this.deftAttyApntDt;
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
	 * @return clmOfrtFlg
	 */
	public String getClmOfrtFlg() {
		return this.clmOfrtFlg;
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
	 * @return n1stPreRefVvdNo
	 */
	public String getN1stPreRefVvdNo() {
		return this.n1stPreRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @return refDeftAttyNo
	 */
	public String getRefDeftAttyNo() {
		return this.refDeftAttyNo;
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
	 * @param ligtUpdDt
	 */
	public void setLigtUpdDt(String ligtUpdDt) {
		this.ligtUpdDt = ligtUpdDt;
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
	 * @param n3rdPreRefVvdNo
	 */
	public void setN3rdPreRefVvdNo(String n3rdPreRefVvdNo) {
		this.n3rdPreRefVvdNo = n3rdPreRefVvdNo;
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
	 * @param clmOfrtAmt
	 */
	public void setClmOfrtAmt(String clmOfrtAmt) {
		this.clmOfrtAmt = clmOfrtAmt;
	}
	
	/**
	 * Column Info
	 * @param agnCrspnTpCd
	 */
	public void setAgnCrspnTpCd(String agnCrspnTpCd) {
		this.agnCrspnTpCd = agnCrspnTpCd;
	}
	
	/**
	 * Column Info
	 * @param clmtClmPtyAbbrNm
	 */
	public void setClmtClmPtyAbbrNm(String clmtClmPtyAbbrNm) {
		this.clmtClmPtyAbbrNm = clmtClmPtyAbbrNm;
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
	 * @param sveyClmPtyNo
	 */
	public void setSveyClmPtyNo(String sveyClmPtyNo) {
		this.sveyClmPtyNo = sveyClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param insurClmPtyAbbrNm
	 */
	public void setInsurClmPtyAbbrNm(String insurClmPtyAbbrNm) {
		this.insurClmPtyAbbrNm = insurClmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param mnBlFlg
	 */
	public void setMnBlFlg(String mnBlFlg) {
		this.mnBlFlg = mnBlFlg;
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
	 * @param lablClmPtyNo
	 */
	public void setLablClmPtyNo(String lablClmPtyNo) {
		this.lablClmPtyNo = lablClmPtyNo;
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
	 * @param clmOfrtTermCd
	 */
	public void setClmOfrtTermCd(String clmOfrtTermCd) {
		this.clmOfrtTermCd = clmOfrtTermCd;
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
	 * @param cgoClmDivCd
	 */
	public void setCgoClmDivCd(String cgoClmDivCd) {
		this.cgoClmDivCd = cgoClmDivCd;
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
	 * @param trnsSeq
	 */
	public void setTrnsSeq(String trnsSeq) {
		this.trnsSeq = trnsSeq;
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
	 * @param jmtRsltDt
	 */
	public void setJmtRsltDt(String jmtRsltDt) {
		this.jmtRsltDt = jmtRsltDt;
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
	 * @param cgoClmStlTpCd
	 */
	public void setCgoClmStlTpCd(String cgoClmStlTpCd) {
		this.cgoClmStlTpCd = cgoClmStlTpCd;
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
	 * @param clmTmBarDt
	 */
	public void setClmTmBarDt(String clmTmBarDt) {
		this.clmTmBarDt = clmTmBarDt;
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
	 * @param clmAgnIntlPhnNo
	 */
	public void setClmAgnIntlPhnNo(String clmAgnIntlPhnNo) {
		this.clmAgnIntlPhnNo = clmAgnIntlPhnNo;
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
	 * @param inciPlcTpCd
	 */
	public void setInciPlcTpCd(String inciPlcTpCd) {
		this.inciPlcTpCd = inciPlcTpCd;
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
	 * @param sveyClmPtyAbbrNm
	 */
	public void setSveyClmPtyAbbrNm(String sveyClmPtyAbbrNm) {
		this.sveyClmPtyAbbrNm = sveyClmPtyAbbrNm;
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
	 * @param bfrCgoClmStsCd
	 */
	public void setBfrCgoClmStsCd(String bfrCgoClmStsCd) {
		this.bfrCgoClmStsCd = bfrCgoClmStsCd;
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
	 * @param crrTermCd
	 */
	public void setCrrTermCd(String crrTermCd) {
		this.crrTermCd = crrTermCd;
	}
	
	/**
	 * Column Info
	 * @param deftAttyClmPtyNm
	 */
	public void setDeftAttyClmPtyNm(String deftAttyClmPtyNm) {
		this.deftAttyClmPtyNm = deftAttyClmPtyNm;
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
	 * @param agnCrspnApntDt
	 */
	public void setAgnCrspnApntDt(String agnCrspnApntDt) {
		this.agnCrspnApntDt = agnCrspnApntDt;
	}
	
	/**
	 * Column Info
	 * @param n2ndPreTsDt
	 */
	public void setN2ndPreTsDt(String n2ndPreTsDt) {
		this.n2ndPreTsDt = n2ndPreTsDt;
	}
	
	/**
	 * Column Info
	 * @param insurAgnClmPtyAbbrNm
	 */
	public void setInsurAgnClmPtyAbbrNm(String insurAgnClmPtyAbbrNm) {
		this.insurAgnClmPtyAbbrNm = insurAgnClmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param deftAttyClmPtyNo
	 */
	public void setDeftAttyClmPtyNo(String deftAttyClmPtyNo) {
		this.deftAttyClmPtyNo = deftAttyClmPtyNo;
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
	 * @param lablTmBarDt
	 */
	public void setLablTmBarDt(String lablTmBarDt) {
		this.lablTmBarDt = lablTmBarDt;
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
	 * @param insurAgnClmPtyNm
	 */
	public void setInsurAgnClmPtyNm(String insurAgnClmPtyNm) {
		this.insurAgnClmPtyNm = insurAgnClmPtyNm;
	}
	
	/**
	 * Column Info
	 * @param clmAgnPtyEml
	 */
	public void setClmAgnPtyEml(String clmAgnPtyEml) {
		this.clmAgnPtyEml = clmAgnPtyEml;
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
	 * @param insurAgnClmPtyNo
	 */
	public void setInsurAgnClmPtyNo(String insurAgnClmPtyNo) {
		this.insurAgnClmPtyNo = insurAgnClmPtyNo;
	}
	
	/**
	 * Column Info
	 * @param insurAgnIntlPhnNo
	 */
	public void setInsurAgnIntlPhnNo(String insurAgnIntlPhnNo) {
		this.insurAgnIntlPhnNo = insurAgnIntlPhnNo;
	}
	
	/**
	 * Column Info
	 * @param ligtUpdUsrId
	 */
	public void setLigtUpdUsrId(String ligtUpdUsrId) {
		this.ligtUpdUsrId = ligtUpdUsrId;
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
	 * @param cgoClmRefCntrNo
	 */
	public void setCgoClmRefCntrNo(String cgoClmRefCntrNo) {
		this.cgoClmRefCntrNo = cgoClmRefCntrNo;
	}
	
	/**
	 * Column Info
	 * @param n2ndPreRefVvdNo
	 */
	public void setN2ndPreRefVvdNo(String n2ndPreRefVvdNo) {
		this.n2ndPreRefVvdNo = n2ndPreRefVvdNo;
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
	 * @param lodgDt
	 */
	public void setLodgDt(String lodgDt) {
		this.lodgDt = lodgDt;
	}
	
	/**
	 * Column Info
	 * @param insurAgnPhnNo
	 */
	public void setInsurAgnPhnNo(String insurAgnPhnNo) {
		this.insurAgnPhnNo = insurAgnPhnNo;
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
	 * @param clmtAgnRefNo
	 */
	public void setClmtAgnRefNo(String clmtAgnRefNo) {
		this.clmtAgnRefNo = clmtAgnRefNo;
	}
	
	/**
	 * Column Info
	 * @param jmtRsltCd
	 */
	public void setJmtRsltCd(String jmtRsltCd) {
		this.jmtRsltCd = jmtRsltCd;
	}
	
	/**
	 * Column Info
	 * @param n2ndPstTsLocCd
	 */
	public void setN2ndPstTsLocCd(String n2ndPstTsLocCd) {
		this.n2ndPstTsLocCd = n2ndPstTsLocCd;
	}
	
	/**
	 * Column Info
	 * @param cgoClmClzCd
	 */
	public void setCgoClmClzCd(String cgoClmClzCd) {
		this.cgoClmClzCd = cgoClmClzCd;
	}
	
	/**
	 * Column Info
	 * @param svyrTpCd
	 */
	public void setSvyrTpCd(String svyrTpCd) {
		this.svyrTpCd = svyrTpCd;
	}
	
	/**
	 * Column Info
	 * @param cgoQltyDesc
	 */
	public void setCgoQltyDesc(String cgoQltyDesc) {
		this.cgoQltyDesc = cgoQltyDesc;
	}
	
	/**
	 * Column Info
	 * @param n2ndPstTsDt
	 */
	public void setN2ndPstTsDt(String n2ndPstTsDt) {
		this.n2ndPstTsDt = n2ndPstTsDt;
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
	 * @param preCgoClmClzCd
	 */
	public void setPreCgoClmClzCd(String preCgoClmClzCd) {
		this.preCgoClmClzCd = preCgoClmClzCd;
	}
	
	/**
	 * Column Info
	 * @param n1stPstRefVvdNo
	 */
	public void setN1stPstRefVvdNo(String n1stPstRefVvdNo) {
		this.n1stPstRefVvdNo = n1stPstRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param insurRefNo
	 */
	public void setInsurRefNo(String insurRefNo) {
		this.insurRefNo = insurRefNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param n3rdPstRefVvdNo
	 */
	public void setN3rdPstRefVvdNo(String n3rdPstRefVvdNo) {
		this.n3rdPstRefVvdNo = n3rdPstRefVvdNo;
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
	 * @param cgoClmNo
	 */
	public void setCgoClmNo(String cgoClmNo) {
		this.cgoClmNo = cgoClmNo;
	}
	
	/**
	 * Column Info
	 * @param agnCrspnRefNo
	 */
	public void setAgnCrspnRefNo(String agnCrspnRefNo) {
		this.agnCrspnRefNo = agnCrspnRefNo;
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
	 * @param n1stPreTsDt
	 */
	public void setN1stPreTsDt(String n1stPreTsDt) {
		this.n1stPreTsDt = n1stPreTsDt;
	}
	
	/**
	 * Column Info
	 * @param clmAgnClmPtyNm
	 */
	public void setClmAgnClmPtyNm(String clmAgnClmPtyNm) {
		this.clmAgnClmPtyNm = clmAgnClmPtyNm;
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
	 * @param sveyInpDt
	 */
	public void setSveyInpDt(String sveyInpDt) {
		this.sveyInpDt = sveyInpDt;
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
	 * @param clmAgnClmPtyNo
	 */
	public void setClmAgnClmPtyNo(String clmAgnClmPtyNo) {
		this.clmAgnClmPtyNo = clmAgnClmPtyNo;
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
	 * @param crtCsNo
	 */
	public void setCrtCsNo(String crtCsNo) {
		this.crtCsNo = crtCsNo;
	}
	
	/**
	 * Column Info
	 * @param insurVslOshpCd
	 */
	public void setInsurVslOshpCd(String insurVslOshpCd) {
		this.insurVslOshpCd = insurVslOshpCd;
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
	 * @param insurClmPtyNo
	 */
	public void setInsurClmPtyNo(String insurClmPtyNo) {
		this.insurClmPtyNo = insurClmPtyNo;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param clmAgnClmPtyAbbrNm
	 */
	public void setClmAgnClmPtyAbbrNm(String clmAgnClmPtyAbbrNm) {
		this.clmAgnClmPtyAbbrNm = clmAgnClmPtyAbbrNm;
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
	 * @param clmTrnsAuthCd
	 */
	public void setClmTrnsAuthCd(String clmTrnsAuthCd) {
		this.clmTrnsAuthCd = clmTrnsAuthCd;
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
	 * @param lablClmPtyAbbrNm
	 */
	public void setLablClmPtyAbbrNm(String lablClmPtyAbbrNm) {
		this.lablClmPtyAbbrNm = lablClmPtyAbbrNm;
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
	 * @param n1stPreTsLocCd
	 */
	public void setN1stPreTsLocCd(String n1stPreTsLocCd) {
		this.n1stPreTsLocCd = n1stPreTsLocCd;
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
	 * @param deftNm
	 */
	public void setDeftNm(String deftNm) {
		this.deftNm = deftNm;
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
	 * @param n2ndPstRefVvdNo
	 */
	public void setN2ndPstRefVvdNo(String n2ndPstRefVvdNo) {
		this.n2ndPstRefVvdNo = n2ndPstRefVvdNo;
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
	 * @param insurAgnPtyEml
	 */
	public void setInsurAgnPtyEml(String insurAgnPtyEml) {
		this.insurAgnPtyEml = insurAgnPtyEml;
	}
	
	/**
	 * Column Info
	 * @param n2ndPreTsLocCd
	 */
	public void setN2ndPreTsLocCd(String n2ndPreTsLocCd) {
		this.n2ndPreTsLocCd = n2ndPreTsLocCd;
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
	 * @param deftAttyClmPtyAbbrNm
	 */
	public void setDeftAttyClmPtyAbbrNm(String deftAttyClmPtyAbbrNm) {
		this.deftAttyClmPtyAbbrNm = deftAttyClmPtyAbbrNm;
	}
	
	/**
	 * Column Info
	 * @param insurVslTpCd
	 */
	public void setInsurVslTpCd(String insurVslTpCd) {
		this.insurVslTpCd = insurVslTpCd;
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
	 * @param clmtClmTpCd
	 */
	public void setClmtClmTpCd(String clmtClmTpCd) {
		this.clmtClmTpCd = clmtClmTpCd;
	}
	
	/**
	 * Column Info
	 * @param clmAgnPhnNo
	 */
	public void setClmAgnPhnNo(String clmAgnPhnNo) {
		this.clmAgnPhnNo = clmAgnPhnNo;
	}
	
	/**
	 * Column Info
	 * @param cplnFileDt
	 */
	public void setCplnFileDt(String cplnFileDt) {
		this.cplnFileDt = cplnFileDt;
	}
	
	/**
	 * Column Info
	 * @param deftAttyApntDt
	 */
	public void setDeftAttyApntDt(String deftAttyApntDt) {
		this.deftAttyApntDt = deftAttyApntDt;
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
	 * @param clmOfrtFlg
	 */
	public void setClmOfrtFlg(String clmOfrtFlg) {
		this.clmOfrtFlg = clmOfrtFlg;
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
	 * @param n1stPreRefVvdNo
	 */
	public void setN1stPreRefVvdNo(String n1stPreRefVvdNo) {
		this.n1stPreRefVvdNo = n1stPreRefVvdNo;
	}
	
	/**
	 * Column Info
	 * @param refDeftAttyNo
	 */
	public void setRefDeftAttyNo(String refDeftAttyNo) {
		this.refDeftAttyNo = refDeftAttyNo;
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
		setLigtUpdDt(JSPUtil.getParameter(request, prefix + "ligt_upd_dt", ""));
		setTrnkRefVvdNo(JSPUtil.getParameter(request, prefix + "trnk_ref_vvd_no", ""));
		setN3rdPreRefVvdNo(JSPUtil.getParameter(request, prefix + "n3rd_pre_ref_vvd_no", ""));
		setSmnsSveDt(JSPUtil.getParameter(request, prefix + "smns_sve_dt", ""));
		setFmalClmRcvDt(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_dt", ""));
		setClmOfrtAmt(JSPUtil.getParameter(request, prefix + "clm_ofrt_amt", ""));
		setAgnCrspnTpCd(JSPUtil.getParameter(request, prefix + "agn_crspn_tp_cd", ""));
		setClmtClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "clmt_clm_pty_abbr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSveyClmPtyNo(JSPUtil.getParameter(request, prefix + "svey_clm_pty_no", ""));
		setInsurClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "insur_clm_pty_abbr_nm", ""));
		setMnBlFlg(JSPUtil.getParameter(request, prefix + "mn_bl_flg", ""));
		setPltNm(JSPUtil.getParameter(request, prefix + "plt_nm", ""));
		setLablClmPtyNo(JSPUtil.getParameter(request, prefix + "labl_clm_pty_no", ""));
		setClmCuzDesc(JSPUtil.getParameter(request, prefix + "clm_cuz_desc", ""));
		setClmOfrtTermCd(JSPUtil.getParameter(request, prefix + "clm_ofrt_term_cd", ""));
		setCgoClmRefBlNo(JSPUtil.getParameter(request, prefix + "cgo_clm_ref_bl_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCgoClmDivCd(JSPUtil.getParameter(request, prefix + "cgo_clm_div_cd", ""));
		setNhp(JSPUtil.getParameter(request, prefix + "nhp", ""));
		setTrnsSeq(JSPUtil.getParameter(request, prefix + "trns_seq", ""));
		setHpd(JSPUtil.getParameter(request, prefix + "hpd", ""));
		setCgoClmAcknakDt(JSPUtil.getParameter(request, prefix + "cgo_clm_acknak_dt", ""));
		setInciOccrDt(JSPUtil.getParameter(request, prefix + "inci_occr_dt", ""));
		setJmtRsltDt(JSPUtil.getParameter(request, prefix + "jmt_rslt_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCgoClmStlTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_stl_tp_cd", ""));
		setLtgtCsDesc(JSPUtil.getParameter(request, prefix + "ltgt_cs_desc", ""));
		setClmTmBarDt(JSPUtil.getParameter(request, prefix + "clm_tm_bar_dt", ""));
		setFmalClmRcvOfcCd(JSPUtil.getParameter(request, prefix + "fmal_clm_rcv_ofc_cd", ""));
		setClmAgnIntlPhnNo(JSPUtil.getParameter(request, prefix + "clm_agn_intl_phn_no", ""));
		setN3rdLablPtyCd(JSPUtil.getParameter(request, prefix + "n3rd_labl_pty_cd", ""));
		setInciPlcTpCd(JSPUtil.getParameter(request, prefix + "inci_plc_tp_cd", ""));
		setLablPtyFmalClmDt(JSPUtil.getParameter(request, prefix + "labl_pty_fmal_clm_dt", ""));
		setHdlrOfcCd(JSPUtil.getParameter(request, prefix + "hdlr_ofc_cd", ""));
		setSveyClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "svey_clm_pty_abbr_nm", ""));
		setClmtLoclXchRt(JSPUtil.getParameter(request, prefix + "clmt_locl_xch_rt", ""));
		setClmtRefNo(JSPUtil.getParameter(request, prefix + "clmt_ref_no", ""));
		setClmtLoclAmt(JSPUtil.getParameter(request, prefix + "clmt_locl_amt", ""));
		setTrnsFlg(JSPUtil.getParameter(request, prefix + "trns_flg", ""));
		setBfrCgoClmStsCd(JSPUtil.getParameter(request, prefix + "bfr_cgo_clm_sts_cd", ""));
		setDeDt(JSPUtil.getParameter(request, prefix + "de_dt", ""));
		setLablPtyDmndUsdAmt(JSPUtil.getParameter(request, prefix + "labl_pty_dmnd_usd_amt", ""));
		setCrrTermCd(JSPUtil.getParameter(request, prefix + "crr_term_cd", ""));
		setDeftAttyClmPtyNm(JSPUtil.getParameter(request, prefix + "deft_atty_clm_pty_nm", ""));
		setN1stPstTsDt(JSPUtil.getParameter(request, prefix + "n1st_pst_ts_dt", ""));
		setAgnCrspnApntDt(JSPUtil.getParameter(request, prefix + "agn_crspn_apnt_dt", ""));
		setN2ndPreTsDt(JSPUtil.getParameter(request, prefix + "n2nd_pre_ts_dt", ""));
		setInsurAgnClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "insur_agn_clm_pty_abbr_nm", ""));
		setDeftAttyClmPtyNo(JSPUtil.getParameter(request, prefix + "deft_atty_clm_pty_no", ""));
		setFactFndDesc(JSPUtil.getParameter(request, prefix + "fact_fnd_desc", ""));
		setLablTmBarDt(JSPUtil.getParameter(request, prefix + "labl_tm_bar_dt", ""));
		setCsClzRopnDt(JSPUtil.getParameter(request, prefix + "cs_clz_ropn_dt", ""));
		setInsurAgnClmPtyNm(JSPUtil.getParameter(request, prefix + "insur_agn_clm_pty_nm", ""));
		setClmAgnPtyEml(JSPUtil.getParameter(request, prefix + "clm_agn_pty_eml", ""));
		setCrtNm(JSPUtil.getParameter(request, prefix + "crt_nm", ""));
		setInsurAgnClmPtyNo(JSPUtil.getParameter(request, prefix + "insur_agn_clm_pty_no", ""));
		setInsurAgnIntlPhnNo(JSPUtil.getParameter(request, prefix + "insur_agn_intl_phn_no", ""));
		setLigtUpdUsrId(JSPUtil.getParameter(request, prefix + "ligt_upd_usr_id", ""));
		setFactFndDt(JSPUtil.getParameter(request, prefix + "fact_fnd_dt", ""));
		setCgoClmRefCntrNo(JSPUtil.getParameter(request, prefix + "cgo_clm_ref_cntr_no", ""));
		setN2ndPreRefVvdNo(JSPUtil.getParameter(request, prefix + "n2nd_pre_ref_vvd_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setLodgDt(JSPUtil.getParameter(request, prefix + "lodg_dt", ""));
		setInsurAgnPhnNo(JSPUtil.getParameter(request, prefix + "insur_agn_phn_no", ""));
		setCgoClmInciNo(JSPUtil.getParameter(request, prefix + "cgo_clm_inci_no", ""));
		setClmtAgnRefNo(JSPUtil.getParameter(request, prefix + "clmt_agn_ref_no", ""));
		setJmtRsltCd(JSPUtil.getParameter(request, prefix + "jmt_rslt_cd", ""));
		setN2ndPstTsLocCd(JSPUtil.getParameter(request, prefix + "n2nd_pst_ts_loc_cd", ""));
		setCgoClmClzCd(JSPUtil.getParameter(request, prefix + "cgo_clm_clz_cd", ""));
		setSvyrTpCd(JSPUtil.getParameter(request, prefix + "svyr_tp_cd", ""));
		setCgoQltyDesc(JSPUtil.getParameter(request, prefix + "cgo_qlty_desc", ""));
		setN2ndPstTsDt(JSPUtil.getParameter(request, prefix + "n2nd_pst_ts_dt", ""));
		setCgoClmStsNm(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_nm", ""));
		setPreCgoClmClzCd(JSPUtil.getParameter(request, prefix + "pre_cgo_clm_clz_cd", ""));
		setN1stPstRefVvdNo(JSPUtil.getParameter(request, prefix + "n1st_pst_ref_vvd_no", ""));
		setInsurRefNo(JSPUtil.getParameter(request, prefix + "insur_ref_no", ""));
		setClmCgoTpCd(JSPUtil.getParameter(request, prefix + "clm_cgo_tp_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setN3rdPstRefVvdNo(JSPUtil.getParameter(request, prefix + "n3rd_pst_ref_vvd_no", ""));
		setPrlmClmNtcDt(JSPUtil.getParameter(request, prefix + "prlm_clm_ntc_dt", ""));
		setCgoClmNo(JSPUtil.getParameter(request, prefix + "cgo_clm_no", ""));
		setAgnCrspnRefNo(JSPUtil.getParameter(request, prefix + "agn_crspn_ref_no", ""));
		setMjrClmDmgLssCd(JSPUtil.getParameter(request, prefix + "mjr_clm_dmg_lss_cd", ""));
		setN1stPreTsDt(JSPUtil.getParameter(request, prefix + "n1st_pre_ts_dt", ""));
		setClmAgnClmPtyNm(JSPUtil.getParameter(request, prefix + "clm_agn_clm_pty_nm", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setSveyInpDt(JSPUtil.getParameter(request, prefix + "svey_inp_dt", ""));
		setClmtLoclCurrCd(JSPUtil.getParameter(request, prefix + "clmt_locl_curr_cd", ""));
		setClmAgnClmPtyNo(JSPUtil.getParameter(request, prefix + "clm_agn_clm_pty_no", ""));
		setCpDesc(JSPUtil.getParameter(request, prefix + "cp_desc", ""));
		setCrtCsNo(JSPUtil.getParameter(request, prefix + "crt_cs_no", ""));
		setInsurVslOshpCd(JSPUtil.getParameter(request, prefix + "insur_vsl_oshp_cd", ""));
		setClmtUsdAmt(JSPUtil.getParameter(request, prefix + "clmt_usd_amt", ""));
		setCrmVocNo(JSPUtil.getParameter(request, prefix + "crm_voc_no", ""));
		setInsurClmPtyNo(JSPUtil.getParameter(request, prefix + "insur_clm_pty_no", ""));
		setCgoClmTpCd(JSPUtil.getParameter(request, prefix + "cgo_clm_tp_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setClmAgnClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "clm_agn_clm_pty_abbr_nm", ""));
		setCsClzDt(JSPUtil.getParameter(request, prefix + "cs_clz_dt", ""));
		setClmTrnsAuthCd(JSPUtil.getParameter(request, prefix + "clm_trns_auth_cd", ""));
		setClmtClmPtyNm(JSPUtil.getParameter(request, prefix + "clmt_clm_pty_nm", ""));
		setLablClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "labl_clm_pty_abbr_nm", ""));
		setClmtClmPtyNo(JSPUtil.getParameter(request, prefix + "clmt_clm_pty_no", ""));
		setN1stPreTsLocCd(JSPUtil.getParameter(request, prefix + "n1st_pre_ts_loc_cd", ""));
		setClmtAgnApntDt(JSPUtil.getParameter(request, prefix + "clmt_agn_apnt_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDeftNm(JSPUtil.getParameter(request, prefix + "deft_nm", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setN2ndPstRefVvdNo(JSPUtil.getParameter(request, prefix + "n2nd_pst_ref_vvd_no", ""));
		setCgoClmStsCd(JSPUtil.getParameter(request, prefix + "cgo_clm_sts_cd", ""));
		setClmRvwDesc(JSPUtil.getParameter(request, prefix + "clm_rvw_desc", ""));
		setInsurAgnPtyEml(JSPUtil.getParameter(request, prefix + "insur_agn_pty_eml", ""));
		setN2ndPreTsLocCd(JSPUtil.getParameter(request, prefix + "n2nd_pre_ts_loc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN1stPstTsLocCd(JSPUtil.getParameter(request, prefix + "n1st_pst_ts_loc_cd", ""));
		setDchgDt(JSPUtil.getParameter(request, prefix + "dchg_dt", ""));
		setDeftAttyClmPtyAbbrNm(JSPUtil.getParameter(request, prefix + "deft_atty_clm_pty_abbr_nm", ""));
		setInsurVslTpCd(JSPUtil.getParameter(request, prefix + "insur_vsl_tp_cd", ""));
		setClmtAgnTpCd(JSPUtil.getParameter(request, prefix + "clmt_agn_tp_cd", ""));
		setClmtClmTpCd(JSPUtil.getParameter(request, prefix + "clmt_clm_tp_cd", ""));
		setClmAgnPhnNo(JSPUtil.getParameter(request, prefix + "clm_agn_phn_no", ""));
		setCplnFileDt(JSPUtil.getParameter(request, prefix + "cpln_file_dt", ""));
		setDeftAttyApntDt(JSPUtil.getParameter(request, prefix + "deft_atty_apnt_dt", ""));
		setHdlrUsrId(JSPUtil.getParameter(request, prefix + "hdlr_usr_id", ""));
		setClmOfrtFlg(JSPUtil.getParameter(request, prefix + "clm_ofrt_flg", ""));
		setRctDt(JSPUtil.getParameter(request, prefix + "rct_dt", ""));
		setN1stPreRefVvdNo(JSPUtil.getParameter(request, prefix + "n1st_pre_ref_vvd_no", ""));
		setRefDeftAttyNo(JSPUtil.getParameter(request, prefix + "ref_deft_atty_no", ""));
		setClmAreaCd(JSPUtil.getParameter(request, prefix + "clm_area_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ClaimMainVO[]
	 */
	public ClaimMainVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ClaimMainVO[]
	 */
	public ClaimMainVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ClaimMainVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ligtUpdDt = (JSPUtil.getParameter(request, prefix	+ "ligt_upd_dt", length));
			String[] trnkRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "trnk_ref_vvd_no", length));
			String[] n3rdPreRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_pre_ref_vvd_no", length));
			String[] smnsSveDt = (JSPUtil.getParameter(request, prefix	+ "smns_sve_dt", length));
			String[] fmalClmRcvDt = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_dt", length));
			String[] clmOfrtAmt = (JSPUtil.getParameter(request, prefix	+ "clm_ofrt_amt", length));
			String[] agnCrspnTpCd = (JSPUtil.getParameter(request, prefix	+ "agn_crspn_tp_cd", length));
			String[] clmtClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_pty_abbr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sveyClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "svey_clm_pty_no", length));
			String[] insurClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_abbr_nm", length));
			String[] mnBlFlg = (JSPUtil.getParameter(request, prefix	+ "mn_bl_flg", length));
			String[] pltNm = (JSPUtil.getParameter(request, prefix	+ "plt_nm", length));
			String[] lablClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "labl_clm_pty_no", length));
			String[] clmCuzDesc = (JSPUtil.getParameter(request, prefix	+ "clm_cuz_desc", length));
			String[] clmOfrtTermCd = (JSPUtil.getParameter(request, prefix	+ "clm_ofrt_term_cd", length));
			String[] cgoClmRefBlNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_bl_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cgoClmDivCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_div_cd", length));
			String[] nhp = (JSPUtil.getParameter(request, prefix	+ "nhp", length));
			String[] trnsSeq = (JSPUtil.getParameter(request, prefix	+ "trns_seq", length));
			String[] hpd = (JSPUtil.getParameter(request, prefix	+ "hpd", length));
			String[] cgoClmAcknakDt = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_acknak_dt", length));
			String[] inciOccrDt = (JSPUtil.getParameter(request, prefix	+ "inci_occr_dt", length));
			String[] jmtRsltDt = (JSPUtil.getParameter(request, prefix	+ "jmt_rslt_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cgoClmStlTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_stl_tp_cd", length));
			String[] ltgtCsDesc = (JSPUtil.getParameter(request, prefix	+ "ltgt_cs_desc", length));
			String[] clmTmBarDt = (JSPUtil.getParameter(request, prefix	+ "clm_tm_bar_dt", length));
			String[] fmalClmRcvOfcCd = (JSPUtil.getParameter(request, prefix	+ "fmal_clm_rcv_ofc_cd", length));
			String[] clmAgnIntlPhnNo = (JSPUtil.getParameter(request, prefix	+ "clm_agn_intl_phn_no", length));
			String[] n3rdLablPtyCd = (JSPUtil.getParameter(request, prefix	+ "n3rd_labl_pty_cd", length));
			String[] inciPlcTpCd = (JSPUtil.getParameter(request, prefix	+ "inci_plc_tp_cd", length));
			String[] lablPtyFmalClmDt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_fmal_clm_dt", length));
			String[] hdlrOfcCd = (JSPUtil.getParameter(request, prefix	+ "hdlr_ofc_cd", length));
			String[] sveyClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "svey_clm_pty_abbr_nm", length));
			String[] clmtLoclXchRt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_xch_rt", length));
			String[] clmtRefNo = (JSPUtil.getParameter(request, prefix	+ "clmt_ref_no", length));
			String[] clmtLoclAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_amt", length));
			String[] trnsFlg = (JSPUtil.getParameter(request, prefix	+ "trns_flg", length));
			String[] bfrCgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "bfr_cgo_clm_sts_cd", length));
			String[] deDt = (JSPUtil.getParameter(request, prefix	+ "de_dt", length));
			String[] lablPtyDmndUsdAmt = (JSPUtil.getParameter(request, prefix	+ "labl_pty_dmnd_usd_amt", length));
			String[] crrTermCd = (JSPUtil.getParameter(request, prefix	+ "crr_term_cd", length));
			String[] deftAttyClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "deft_atty_clm_pty_nm", length));
			String[] n1stPstTsDt = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ts_dt", length));
			String[] agnCrspnApntDt = (JSPUtil.getParameter(request, prefix	+ "agn_crspn_apnt_dt", length));
			String[] n2ndPreTsDt = (JSPUtil.getParameter(request, prefix	+ "n2nd_pre_ts_dt", length));
			String[] insurAgnClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "insur_agn_clm_pty_abbr_nm", length));
			String[] deftAttyClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "deft_atty_clm_pty_no", length));
			String[] factFndDesc = (JSPUtil.getParameter(request, prefix	+ "fact_fnd_desc", length));
			String[] lablTmBarDt = (JSPUtil.getParameter(request, prefix	+ "labl_tm_bar_dt", length));
			String[] csClzRopnDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_ropn_dt", length));
			String[] insurAgnClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "insur_agn_clm_pty_nm", length));
			String[] clmAgnPtyEml = (JSPUtil.getParameter(request, prefix	+ "clm_agn_pty_eml", length));
			String[] crtNm = (JSPUtil.getParameter(request, prefix	+ "crt_nm", length));
			String[] insurAgnClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_agn_clm_pty_no", length));
			String[] insurAgnIntlPhnNo = (JSPUtil.getParameter(request, prefix	+ "insur_agn_intl_phn_no", length));
			String[] ligtUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "ligt_upd_usr_id", length));
			String[] factFndDt = (JSPUtil.getParameter(request, prefix	+ "fact_fnd_dt", length));
			String[] cgoClmRefCntrNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_ref_cntr_no", length));
			String[] n2ndPreRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_pre_ref_vvd_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] lodgDt = (JSPUtil.getParameter(request, prefix	+ "lodg_dt", length));
			String[] insurAgnPhnNo = (JSPUtil.getParameter(request, prefix	+ "insur_agn_phn_no", length));
			String[] cgoClmInciNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_inci_no", length));
			String[] clmtAgnRefNo = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_ref_no", length));
			String[] jmtRsltCd = (JSPUtil.getParameter(request, prefix	+ "jmt_rslt_cd", length));
			String[] n2ndPstTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pst_ts_loc_cd", length));
			String[] cgoClmClzCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_clz_cd", length));
			String[] svyrTpCd = (JSPUtil.getParameter(request, prefix	+ "svyr_tp_cd", length));
			String[] cgoQltyDesc = (JSPUtil.getParameter(request, prefix	+ "cgo_qlty_desc", length));
			String[] n2ndPstTsDt = (JSPUtil.getParameter(request, prefix	+ "n2nd_pst_ts_dt", length));
			String[] cgoClmStsNm = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_nm", length));
			String[] preCgoClmClzCd = (JSPUtil.getParameter(request, prefix	+ "pre_cgo_clm_clz_cd", length));
			String[] n1stPstRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ref_vvd_no", length));
			String[] insurRefNo = (JSPUtil.getParameter(request, prefix	+ "insur_ref_no", length));
			String[] clmCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "clm_cgo_tp_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] n3rdPstRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n3rd_pst_ref_vvd_no", length));
			String[] prlmClmNtcDt = (JSPUtil.getParameter(request, prefix	+ "prlm_clm_ntc_dt", length));
			String[] cgoClmNo = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_no", length));
			String[] agnCrspnRefNo = (JSPUtil.getParameter(request, prefix	+ "agn_crspn_ref_no", length));
			String[] mjrClmDmgLssCd = (JSPUtil.getParameter(request, prefix	+ "mjr_clm_dmg_lss_cd", length));
			String[] n1stPreTsDt = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ts_dt", length));
			String[] clmAgnClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "clm_agn_clm_pty_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] sveyInpDt = (JSPUtil.getParameter(request, prefix	+ "svey_inp_dt", length));
			String[] clmtLoclCurrCd = (JSPUtil.getParameter(request, prefix	+ "clmt_locl_curr_cd", length));
			String[] clmAgnClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clm_agn_clm_pty_no", length));
			String[] cpDesc = (JSPUtil.getParameter(request, prefix	+ "cp_desc", length));
			String[] crtCsNo = (JSPUtil.getParameter(request, prefix	+ "crt_cs_no", length));
			String[] insurVslOshpCd = (JSPUtil.getParameter(request, prefix	+ "insur_vsl_oshp_cd", length));
			String[] clmtUsdAmt = (JSPUtil.getParameter(request, prefix	+ "clmt_usd_amt", length));
			String[] crmVocNo = (JSPUtil.getParameter(request, prefix	+ "crm_voc_no", length));
			String[] insurClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "insur_clm_pty_no", length));
			String[] cgoClmTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_tp_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] clmAgnClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "clm_agn_clm_pty_abbr_nm", length));
			String[] csClzDt = (JSPUtil.getParameter(request, prefix	+ "cs_clz_dt", length));
			String[] clmTrnsAuthCd = (JSPUtil.getParameter(request, prefix	+ "clm_trns_auth_cd", length));
			String[] clmtClmPtyNm = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_pty_nm", length));
			String[] lablClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "labl_clm_pty_abbr_nm", length));
			String[] clmtClmPtyNo = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_pty_no", length));
			String[] n1stPreTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ts_loc_cd", length));
			String[] clmtAgnApntDt = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_apnt_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deftNm = (JSPUtil.getParameter(request, prefix	+ "deft_nm", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] n2ndPstRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n2nd_pst_ref_vvd_no", length));
			String[] cgoClmStsCd = (JSPUtil.getParameter(request, prefix	+ "cgo_clm_sts_cd", length));
			String[] clmRvwDesc = (JSPUtil.getParameter(request, prefix	+ "clm_rvw_desc", length));
			String[] insurAgnPtyEml = (JSPUtil.getParameter(request, prefix	+ "insur_agn_pty_eml", length));
			String[] n2ndPreTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n2nd_pre_ts_loc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n1stPstTsLocCd = (JSPUtil.getParameter(request, prefix	+ "n1st_pst_ts_loc_cd", length));
			String[] dchgDt = (JSPUtil.getParameter(request, prefix	+ "dchg_dt", length));
			String[] deftAttyClmPtyAbbrNm = (JSPUtil.getParameter(request, prefix	+ "deft_atty_clm_pty_abbr_nm", length));
			String[] insurVslTpCd = (JSPUtil.getParameter(request, prefix	+ "insur_vsl_tp_cd", length));
			String[] clmtAgnTpCd = (JSPUtil.getParameter(request, prefix	+ "clmt_agn_tp_cd", length));
			String[] clmtClmTpCd = (JSPUtil.getParameter(request, prefix	+ "clmt_clm_tp_cd", length));
			String[] clmAgnPhnNo = (JSPUtil.getParameter(request, prefix	+ "clm_agn_phn_no", length));
			String[] cplnFileDt = (JSPUtil.getParameter(request, prefix	+ "cpln_file_dt", length));
			String[] deftAttyApntDt = (JSPUtil.getParameter(request, prefix	+ "deft_atty_apnt_dt", length));
			String[] hdlrUsrId = (JSPUtil.getParameter(request, prefix	+ "hdlr_usr_id", length));
			String[] clmOfrtFlg = (JSPUtil.getParameter(request, prefix	+ "clm_ofrt_flg", length));
			String[] rctDt = (JSPUtil.getParameter(request, prefix	+ "rct_dt", length));
			String[] n1stPreRefVvdNo = (JSPUtil.getParameter(request, prefix	+ "n1st_pre_ref_vvd_no", length));
			String[] refDeftAttyNo = (JSPUtil.getParameter(request, prefix	+ "ref_deft_atty_no", length));
			String[] clmAreaCd = (JSPUtil.getParameter(request, prefix	+ "clm_area_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ClaimMainVO();
				if (ligtUpdDt[i] != null)
					model.setLigtUpdDt(ligtUpdDt[i]);
				if (trnkRefVvdNo[i] != null)
					model.setTrnkRefVvdNo(trnkRefVvdNo[i]);
				if (n3rdPreRefVvdNo[i] != null)
					model.setN3rdPreRefVvdNo(n3rdPreRefVvdNo[i]);
				if (smnsSveDt[i] != null)
					model.setSmnsSveDt(smnsSveDt[i]);
				if (fmalClmRcvDt[i] != null)
					model.setFmalClmRcvDt(fmalClmRcvDt[i]);
				if (clmOfrtAmt[i] != null)
					model.setClmOfrtAmt(clmOfrtAmt[i]);
				if (agnCrspnTpCd[i] != null)
					model.setAgnCrspnTpCd(agnCrspnTpCd[i]);
				if (clmtClmPtyAbbrNm[i] != null)
					model.setClmtClmPtyAbbrNm(clmtClmPtyAbbrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sveyClmPtyNo[i] != null)
					model.setSveyClmPtyNo(sveyClmPtyNo[i]);
				if (insurClmPtyAbbrNm[i] != null)
					model.setInsurClmPtyAbbrNm(insurClmPtyAbbrNm[i]);
				if (mnBlFlg[i] != null)
					model.setMnBlFlg(mnBlFlg[i]);
				if (pltNm[i] != null)
					model.setPltNm(pltNm[i]);
				if (lablClmPtyNo[i] != null)
					model.setLablClmPtyNo(lablClmPtyNo[i]);
				if (clmCuzDesc[i] != null)
					model.setClmCuzDesc(clmCuzDesc[i]);
				if (clmOfrtTermCd[i] != null)
					model.setClmOfrtTermCd(clmOfrtTermCd[i]);
				if (cgoClmRefBlNo[i] != null)
					model.setCgoClmRefBlNo(cgoClmRefBlNo[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cgoClmDivCd[i] != null)
					model.setCgoClmDivCd(cgoClmDivCd[i]);
				if (nhp[i] != null)
					model.setNhp(nhp[i]);
				if (trnsSeq[i] != null)
					model.setTrnsSeq(trnsSeq[i]);
				if (hpd[i] != null)
					model.setHpd(hpd[i]);
				if (cgoClmAcknakDt[i] != null)
					model.setCgoClmAcknakDt(cgoClmAcknakDt[i]);
				if (inciOccrDt[i] != null)
					model.setInciOccrDt(inciOccrDt[i]);
				if (jmtRsltDt[i] != null)
					model.setJmtRsltDt(jmtRsltDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cgoClmStlTpCd[i] != null)
					model.setCgoClmStlTpCd(cgoClmStlTpCd[i]);
				if (ltgtCsDesc[i] != null)
					model.setLtgtCsDesc(ltgtCsDesc[i]);
				if (clmTmBarDt[i] != null)
					model.setClmTmBarDt(clmTmBarDt[i]);
				if (fmalClmRcvOfcCd[i] != null)
					model.setFmalClmRcvOfcCd(fmalClmRcvOfcCd[i]);
				if (clmAgnIntlPhnNo[i] != null)
					model.setClmAgnIntlPhnNo(clmAgnIntlPhnNo[i]);
				if (n3rdLablPtyCd[i] != null)
					model.setN3rdLablPtyCd(n3rdLablPtyCd[i]);
				if (inciPlcTpCd[i] != null)
					model.setInciPlcTpCd(inciPlcTpCd[i]);
				if (lablPtyFmalClmDt[i] != null)
					model.setLablPtyFmalClmDt(lablPtyFmalClmDt[i]);
				if (hdlrOfcCd[i] != null)
					model.setHdlrOfcCd(hdlrOfcCd[i]);
				if (sveyClmPtyAbbrNm[i] != null)
					model.setSveyClmPtyAbbrNm(sveyClmPtyAbbrNm[i]);
				if (clmtLoclXchRt[i] != null)
					model.setClmtLoclXchRt(clmtLoclXchRt[i]);
				if (clmtRefNo[i] != null)
					model.setClmtRefNo(clmtRefNo[i]);
				if (clmtLoclAmt[i] != null)
					model.setClmtLoclAmt(clmtLoclAmt[i]);
				if (trnsFlg[i] != null)
					model.setTrnsFlg(trnsFlg[i]);
				if (bfrCgoClmStsCd[i] != null)
					model.setBfrCgoClmStsCd(bfrCgoClmStsCd[i]);
				if (deDt[i] != null)
					model.setDeDt(deDt[i]);
				if (lablPtyDmndUsdAmt[i] != null)
					model.setLablPtyDmndUsdAmt(lablPtyDmndUsdAmt[i]);
				if (crrTermCd[i] != null)
					model.setCrrTermCd(crrTermCd[i]);
				if (deftAttyClmPtyNm[i] != null)
					model.setDeftAttyClmPtyNm(deftAttyClmPtyNm[i]);
				if (n1stPstTsDt[i] != null)
					model.setN1stPstTsDt(n1stPstTsDt[i]);
				if (agnCrspnApntDt[i] != null)
					model.setAgnCrspnApntDt(agnCrspnApntDt[i]);
				if (n2ndPreTsDt[i] != null)
					model.setN2ndPreTsDt(n2ndPreTsDt[i]);
				if (insurAgnClmPtyAbbrNm[i] != null)
					model.setInsurAgnClmPtyAbbrNm(insurAgnClmPtyAbbrNm[i]);
				if (deftAttyClmPtyNo[i] != null)
					model.setDeftAttyClmPtyNo(deftAttyClmPtyNo[i]);
				if (factFndDesc[i] != null)
					model.setFactFndDesc(factFndDesc[i]);
				if (lablTmBarDt[i] != null)
					model.setLablTmBarDt(lablTmBarDt[i]);
				if (csClzRopnDt[i] != null)
					model.setCsClzRopnDt(csClzRopnDt[i]);
				if (insurAgnClmPtyNm[i] != null)
					model.setInsurAgnClmPtyNm(insurAgnClmPtyNm[i]);
				if (clmAgnPtyEml[i] != null)
					model.setClmAgnPtyEml(clmAgnPtyEml[i]);
				if (crtNm[i] != null)
					model.setCrtNm(crtNm[i]);
				if (insurAgnClmPtyNo[i] != null)
					model.setInsurAgnClmPtyNo(insurAgnClmPtyNo[i]);
				if (insurAgnIntlPhnNo[i] != null)
					model.setInsurAgnIntlPhnNo(insurAgnIntlPhnNo[i]);
				if (ligtUpdUsrId[i] != null)
					model.setLigtUpdUsrId(ligtUpdUsrId[i]);
				if (factFndDt[i] != null)
					model.setFactFndDt(factFndDt[i]);
				if (cgoClmRefCntrNo[i] != null)
					model.setCgoClmRefCntrNo(cgoClmRefCntrNo[i]);
				if (n2ndPreRefVvdNo[i] != null)
					model.setN2ndPreRefVvdNo(n2ndPreRefVvdNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (lodgDt[i] != null)
					model.setLodgDt(lodgDt[i]);
				if (insurAgnPhnNo[i] != null)
					model.setInsurAgnPhnNo(insurAgnPhnNo[i]);
				if (cgoClmInciNo[i] != null)
					model.setCgoClmInciNo(cgoClmInciNo[i]);
				if (clmtAgnRefNo[i] != null)
					model.setClmtAgnRefNo(clmtAgnRefNo[i]);
				if (jmtRsltCd[i] != null)
					model.setJmtRsltCd(jmtRsltCd[i]);
				if (n2ndPstTsLocCd[i] != null)
					model.setN2ndPstTsLocCd(n2ndPstTsLocCd[i]);
				if (cgoClmClzCd[i] != null)
					model.setCgoClmClzCd(cgoClmClzCd[i]);
				if (svyrTpCd[i] != null)
					model.setSvyrTpCd(svyrTpCd[i]);
				if (cgoQltyDesc[i] != null)
					model.setCgoQltyDesc(cgoQltyDesc[i]);
				if (n2ndPstTsDt[i] != null)
					model.setN2ndPstTsDt(n2ndPstTsDt[i]);
				if (cgoClmStsNm[i] != null)
					model.setCgoClmStsNm(cgoClmStsNm[i]);
				if (preCgoClmClzCd[i] != null)
					model.setPreCgoClmClzCd(preCgoClmClzCd[i]);
				if (n1stPstRefVvdNo[i] != null)
					model.setN1stPstRefVvdNo(n1stPstRefVvdNo[i]);
				if (insurRefNo[i] != null)
					model.setInsurRefNo(insurRefNo[i]);
				if (clmCgoTpCd[i] != null)
					model.setClmCgoTpCd(clmCgoTpCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (n3rdPstRefVvdNo[i] != null)
					model.setN3rdPstRefVvdNo(n3rdPstRefVvdNo[i]);
				if (prlmClmNtcDt[i] != null)
					model.setPrlmClmNtcDt(prlmClmNtcDt[i]);
				if (cgoClmNo[i] != null)
					model.setCgoClmNo(cgoClmNo[i]);
				if (agnCrspnRefNo[i] != null)
					model.setAgnCrspnRefNo(agnCrspnRefNo[i]);
				if (mjrClmDmgLssCd[i] != null)
					model.setMjrClmDmgLssCd(mjrClmDmgLssCd[i]);
				if (n1stPreTsDt[i] != null)
					model.setN1stPreTsDt(n1stPreTsDt[i]);
				if (clmAgnClmPtyNm[i] != null)
					model.setClmAgnClmPtyNm(clmAgnClmPtyNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (sveyInpDt[i] != null)
					model.setSveyInpDt(sveyInpDt[i]);
				if (clmtLoclCurrCd[i] != null)
					model.setClmtLoclCurrCd(clmtLoclCurrCd[i]);
				if (clmAgnClmPtyNo[i] != null)
					model.setClmAgnClmPtyNo(clmAgnClmPtyNo[i]);
				if (cpDesc[i] != null)
					model.setCpDesc(cpDesc[i]);
				if (crtCsNo[i] != null)
					model.setCrtCsNo(crtCsNo[i]);
				if (insurVslOshpCd[i] != null)
					model.setInsurVslOshpCd(insurVslOshpCd[i]);
				if (clmtUsdAmt[i] != null)
					model.setClmtUsdAmt(clmtUsdAmt[i]);
				if (crmVocNo[i] != null)
					model.setCrmVocNo(crmVocNo[i]);
				if (insurClmPtyNo[i] != null)
					model.setInsurClmPtyNo(insurClmPtyNo[i]);
				if (cgoClmTpCd[i] != null)
					model.setCgoClmTpCd(cgoClmTpCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (clmAgnClmPtyAbbrNm[i] != null)
					model.setClmAgnClmPtyAbbrNm(clmAgnClmPtyAbbrNm[i]);
				if (csClzDt[i] != null)
					model.setCsClzDt(csClzDt[i]);
				if (clmTrnsAuthCd[i] != null)
					model.setClmTrnsAuthCd(clmTrnsAuthCd[i]);
				if (clmtClmPtyNm[i] != null)
					model.setClmtClmPtyNm(clmtClmPtyNm[i]);
				if (lablClmPtyAbbrNm[i] != null)
					model.setLablClmPtyAbbrNm(lablClmPtyAbbrNm[i]);
				if (clmtClmPtyNo[i] != null)
					model.setClmtClmPtyNo(clmtClmPtyNo[i]);
				if (n1stPreTsLocCd[i] != null)
					model.setN1stPreTsLocCd(n1stPreTsLocCd[i]);
				if (clmtAgnApntDt[i] != null)
					model.setClmtAgnApntDt(clmtAgnApntDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deftNm[i] != null)
					model.setDeftNm(deftNm[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (n2ndPstRefVvdNo[i] != null)
					model.setN2ndPstRefVvdNo(n2ndPstRefVvdNo[i]);
				if (cgoClmStsCd[i] != null)
					model.setCgoClmStsCd(cgoClmStsCd[i]);
				if (clmRvwDesc[i] != null)
					model.setClmRvwDesc(clmRvwDesc[i]);
				if (insurAgnPtyEml[i] != null)
					model.setInsurAgnPtyEml(insurAgnPtyEml[i]);
				if (n2ndPreTsLocCd[i] != null)
					model.setN2ndPreTsLocCd(n2ndPreTsLocCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n1stPstTsLocCd[i] != null)
					model.setN1stPstTsLocCd(n1stPstTsLocCd[i]);
				if (dchgDt[i] != null)
					model.setDchgDt(dchgDt[i]);
				if (deftAttyClmPtyAbbrNm[i] != null)
					model.setDeftAttyClmPtyAbbrNm(deftAttyClmPtyAbbrNm[i]);
				if (insurVslTpCd[i] != null)
					model.setInsurVslTpCd(insurVslTpCd[i]);
				if (clmtAgnTpCd[i] != null)
					model.setClmtAgnTpCd(clmtAgnTpCd[i]);
				if (clmtClmTpCd[i] != null)
					model.setClmtClmTpCd(clmtClmTpCd[i]);
				if (clmAgnPhnNo[i] != null)
					model.setClmAgnPhnNo(clmAgnPhnNo[i]);
				if (cplnFileDt[i] != null)
					model.setCplnFileDt(cplnFileDt[i]);
				if (deftAttyApntDt[i] != null)
					model.setDeftAttyApntDt(deftAttyApntDt[i]);
				if (hdlrUsrId[i] != null)
					model.setHdlrUsrId(hdlrUsrId[i]);
				if (clmOfrtFlg[i] != null)
					model.setClmOfrtFlg(clmOfrtFlg[i]);
				if (rctDt[i] != null)
					model.setRctDt(rctDt[i]);
				if (n1stPreRefVvdNo[i] != null)
					model.setN1stPreRefVvdNo(n1stPreRefVvdNo[i]);
				if (refDeftAttyNo[i] != null)
					model.setRefDeftAttyNo(refDeftAttyNo[i]);
				if (clmAreaCd[i] != null)
					model.setClmAreaCd(clmAreaCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getClaimMainVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ClaimMainVO[]
	 */
	public ClaimMainVO[] getClaimMainVOs(){
		ClaimMainVO[] vos = (ClaimMainVO[])models.toArray(new ClaimMainVO[models.size()]);
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
		this.ligtUpdDt = this.ligtUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkRefVvdNo = this.trnkRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPreRefVvdNo = this.n3rdPreRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smnsSveDt = this.smnsSveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvDt = this.fmalClmRcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmOfrtAmt = this.clmOfrtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCrspnTpCd = this.agnCrspnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmPtyAbbrNm = this.clmtClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sveyClmPtyNo = this.sveyClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyAbbrNm = this.insurClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnBlFlg = this.mnBlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltNm = this.pltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablClmPtyNo = this.lablClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCuzDesc = this.clmCuzDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmOfrtTermCd = this.clmOfrtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefBlNo = this.cgoClmRefBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmDivCd = this.cgoClmDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nhp = this.nhp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsSeq = this.trnsSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hpd = this.hpd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmAcknakDt = this.cgoClmAcknakDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciOccrDt = this.inciOccrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jmtRsltDt = this.jmtRsltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStlTpCd = this.cgoClmStlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ltgtCsDesc = this.ltgtCsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmTmBarDt = this.clmTmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmalClmRcvOfcCd = this.fmalClmRcvOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAgnIntlPhnNo = this.clmAgnIntlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdLablPtyCd = this.n3rdLablPtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inciPlcTpCd = this.inciPlcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyFmalClmDt = this.lablPtyFmalClmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrOfcCd = this.hdlrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sveyClmPtyAbbrNm = this.sveyClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclXchRt = this.clmtLoclXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtRefNo = this.clmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclAmt = this.clmtLoclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsFlg = this.trnsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrCgoClmStsCd = this.bfrCgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deDt = this.deDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablPtyDmndUsdAmt = this.lablPtyDmndUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrTermCd = this.crrTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAttyClmPtyNm = this.deftAttyClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstTsDt = this.n1stPstTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCrspnApntDt = this.agnCrspnApntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPreTsDt = this.n2ndPreTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurAgnClmPtyAbbrNm = this.insurAgnClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAttyClmPtyNo = this.deftAttyClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.factFndDesc = this.factFndDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablTmBarDt = this.lablTmBarDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzRopnDt = this.csClzRopnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurAgnClmPtyNm = this.insurAgnClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAgnPtyEml = this.clmAgnPtyEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtNm = this.crtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurAgnClmPtyNo = this.insurAgnClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurAgnIntlPhnNo = this.insurAgnIntlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ligtUpdUsrId = this.ligtUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.factFndDt = this.factFndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmRefCntrNo = this.cgoClmRefCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPreRefVvdNo = this.n2ndPreRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgDt = this.lodgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurAgnPhnNo = this.insurAgnPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmInciNo = this.cgoClmInciNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnRefNo = this.clmtAgnRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jmtRsltCd = this.jmtRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPstTsLocCd = this.n2ndPstTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmClzCd = this.cgoClmClzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svyrTpCd = this.svyrTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoQltyDesc = this.cgoQltyDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPstTsDt = this.n2ndPstTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsNm = this.cgoClmStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCgoClmClzCd = this.preCgoClmClzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstRefVvdNo = this.n1stPstRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurRefNo = this.insurRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCgoTpCd = this.clmCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3rdPstRefVvdNo = this.n3rdPstRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prlmClmNtcDt = this.prlmClmNtcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo = this.cgoClmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCrspnRefNo = this.agnCrspnRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mjrClmDmgLssCd = this.mjrClmDmgLssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreTsDt = this.n1stPreTsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAgnClmPtyNm = this.clmAgnClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sveyInpDt = this.sveyInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtLoclCurrCd = this.clmtLoclCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAgnClmPtyNo = this.clmAgnClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpDesc = this.cpDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crtCsNo = this.crtCsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurVslOshpCd = this.insurVslOshpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtUsdAmt = this.clmtUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crmVocNo = this.crmVocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurClmPtyNo = this.insurClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmTpCd = this.cgoClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAgnClmPtyAbbrNm = this.clmAgnClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csClzDt = this.csClzDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmTrnsAuthCd = this.clmTrnsAuthCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmPtyNm = this.clmtClmPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lablClmPtyAbbrNm = this.lablClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmPtyNo = this.clmtClmPtyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreTsLocCd = this.n1stPreTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnApntDt = this.clmtAgnApntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftNm = this.deftNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPstRefVvdNo = this.n2ndPstRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmStsCd = this.cgoClmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmRvwDesc = this.clmRvwDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurAgnPtyEml = this.insurAgnPtyEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndPreTsLocCd = this.n2ndPreTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPstTsLocCd = this.n1stPstTsLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgDt = this.dchgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAttyClmPtyAbbrNm = this.deftAttyClmPtyAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.insurVslTpCd = this.insurVslTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtAgnTpCd = this.clmtAgnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmtClmTpCd = this.clmtClmTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAgnPhnNo = this.clmAgnPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cplnFileDt = this.cplnFileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deftAttyApntDt = this.deftAttyApntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hdlrUsrId = this.hdlrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmOfrtFlg = this.clmOfrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt = this.rctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stPreRefVvdNo = this.n1stPreRefVvdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refDeftAttyNo = this.refDeftAttyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmAreaCd = this.clmAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
