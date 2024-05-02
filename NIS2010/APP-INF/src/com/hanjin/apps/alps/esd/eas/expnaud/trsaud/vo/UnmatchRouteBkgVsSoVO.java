/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchRouteBkgVsSoVO.java
*@FileTitle : UnmatchRouteBkgVsSoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.04.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.04.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.trsaud.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UnmatchRouteBkgVsSoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UnmatchRouteBkgVsSoVO> models = new ArrayList<UnmatchRouteBkgVsSoVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String cngRsnDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String bkgRcvdeTermCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String bkgScgUsdAmt = null;
	/* Column Info */
	private String troFlg = null;
	/* Column Info */
	private String invUsdAmt = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String bkgCurrCd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sDlvryTrm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String sBndCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String sXcldOftIncl = null;
	/* Column Info */
	private String sWoStsCd = null;
	/* Column Info */
	private String woVndrSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String sEacIf = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String eacIfFlg = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String sFmDt = null;
	/* Column Info */
	private String bkgScgAmt = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String woAmt = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String trspPurpRsn = null;
	/* Column Info */
	private String sRcvTrm = null;
	/* Column Info */
	private String invUsrNm = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String soUsrNm = null;
	/* Column Info */
	private String sCstCd = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String viaNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UnmatchRouteBkgVsSoVO() {}

	public UnmatchRouteBkgVsSoVO(String ibflag, String pagerows, String sRhqOfcCd, String sOfcCd, String sFmDt, String sToDt, String sWoStsCd, String sBndCd, String sBkgNo, String sEacIf, String sXcldOftIncl, String sRcvTrm, String sDlvryTrm, String sCstCd, String chk, String slanCd, String vvd, String bkgNo, String eqNo, String eqTpszCd, String trspBndCd, String bkgRcvdeTermCd, String troFlg, String porNodCd, String polNodCd, String podNodCd, String delNodCd, String bkgCurrCd, String bkgScgAmt, String bkgScgUsdAmt, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String trspCrrModCd, String soNo, String woNo, String woVndrSeq, String invNo, String currCd, String woAmt, String invCurrCd, String invAmt, String invUsdAmt, String soUsrNm, String invUsrNm, String interRmk, String spclInstrRmk, String eacIfFlg, String trspPurpRsn, String cngRsnDesc, String trspCostDtlModCd) {
		this.toNodCd = toNodCd;
		this.cngRsnDesc = cngRsnDesc;
		this.pagerows = pagerows;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.bkgRcvdeTermCd = bkgRcvdeTermCd;
		this.delNodCd = delNodCd;
		this.bkgScgUsdAmt = bkgScgUsdAmt;
		this.troFlg = troFlg;
		this.invUsdAmt = invUsdAmt;
		this.soNo = soNo;
		this.bkgCurrCd = bkgCurrCd;
		this.sOfcCd = sOfcCd;
		this.eqTpszCd = eqTpszCd;
		this.vvd = vvd;
		this.sDlvryTrm = sDlvryTrm;
		this.bkgNo = bkgNo;
		this.podNodCd = podNodCd;
		this.chk = chk;
		this.sRhqOfcCd = sRhqOfcCd;
		this.sBndCd = sBndCd;
		this.currCd = currCd;
		this.sBkgNo = sBkgNo;
		this.sXcldOftIncl = sXcldOftIncl;
		this.sWoStsCd = sWoStsCd;
		this.woVndrSeq = woVndrSeq;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.sToDt = sToDt;
		this.sEacIf = sEacIf;
		this.interRmk = interRmk;
		this.eacIfFlg = eacIfFlg;
		this.dorNodCd = dorNodCd;
		this.woNo = woNo;
		this.invAmt = invAmt;
		this.sFmDt = sFmDt;
		this.bkgScgAmt = bkgScgAmt;
		this.spclInstrRmk = spclInstrRmk;
		this.trspCrrModCd = trspCrrModCd;
		this.woAmt = woAmt;
		this.porNodCd = porNodCd;
		this.trspBndCd = trspBndCd;
		this.trspPurpRsn = trspPurpRsn;
		this.sRcvTrm = sRcvTrm;
		this.invUsrNm = invUsrNm;
		this.polNodCd = polNodCd;
		this.invCurrCd = invCurrCd;
		this.soUsrNm = soUsrNm;
		this.sCstCd = sCstCd;
		this.fmNodCd = fmNodCd;
		this.invNo = invNo;
		this.slanCd = slanCd;
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("cng_rsn_desc", getCngRsnDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("bkg_rcvde_term_cd", getBkgRcvdeTermCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("bkg_scg_usd_amt", getBkgScgUsdAmt());
		this.hashColumns.put("tro_flg", getTroFlg());
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("bkg_curr_cd", getBkgCurrCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("s_dlvry_trm", getSDlvryTrm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("s_bnd_cd", getSBndCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("s_xcld_oft_incl", getSXcldOftIncl());
		this.hashColumns.put("s_wo_sts_cd", getSWoStsCd());
		this.hashColumns.put("wo_vndr_seq", getWoVndrSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("s_eac_if", getSEacIf());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("eac_if_flg", getEacIfFlg());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		this.hashColumns.put("bkg_scg_amt", getBkgScgAmt());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("wo_amt", getWoAmt());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("trsp_purp_rsn", getTrspPurpRsn());
		this.hashColumns.put("s_rcv_trm", getSRcvTrm());
		this.hashColumns.put("inv_usr_nm", getInvUsrNm());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("so_usr_nm", getSoUsrNm());
		this.hashColumns.put("s_cst_cd", getSCstCd());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("cng_rsn_desc", "cngRsnDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("bkg_rcvde_term_cd", "bkgRcvdeTermCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("bkg_scg_usd_amt", "bkgScgUsdAmt");
		this.hashFields.put("tro_flg", "troFlg");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("bkg_curr_cd", "bkgCurrCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("s_dlvry_trm", "sDlvryTrm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("s_bnd_cd", "sBndCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("s_xcld_oft_incl", "sXcldOftIncl");
		this.hashFields.put("s_wo_sts_cd", "sWoStsCd");
		this.hashFields.put("wo_vndr_seq", "woVndrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("s_eac_if", "sEacIf");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("eac_if_flg", "eacIfFlg");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("s_fm_dt", "sFmDt");
		this.hashFields.put("bkg_scg_amt", "bkgScgAmt");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("wo_amt", "woAmt");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("trsp_purp_rsn", "trspPurpRsn");
		this.hashFields.put("s_rcv_trm", "sRcvTrm");
		this.hashFields.put("inv_usr_nm", "invUsrNm");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("so_usr_nm", "soUsrNm");
		this.hashFields.put("s_cst_cd", "sCstCd");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return cngRsnDesc
	 */
	public String getCngRsnDesc() {
		return this.cngRsnDesc;
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
	 * @return trspCostDtlModCd
	 */
	public String getTrspCostDtlModCd() {
		return this.trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @return bkgRcvdeTermCd
	 */
	public String getBkgRcvdeTermCd() {
		return this.bkgRcvdeTermCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return bkgScgUsdAmt
	 */
	public String getBkgScgUsdAmt() {
		return this.bkgScgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return troFlg
	 */
	public String getTroFlg() {
		return this.troFlg;
	}
	
	/**
	 * Column Info
	 * @return invUsdAmt
	 */
	public String getInvUsdAmt() {
		return this.invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return soNo
	 */
	public String getSoNo() {
		return this.soNo;
	}
	
	/**
	 * Column Info
	 * @return bkgCurrCd
	 */
	public String getBkgCurrCd() {
		return this.bkgCurrCd;
	}
	
	/**
	 * Column Info
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return sDlvryTrm
	 */
	public String getSDlvryTrm() {
		return this.sDlvryTrm;
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
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
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
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sBndCd
	 */
	public String getSBndCd() {
		return this.sBndCd;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @return sXcldOftIncl
	 */
	public String getSXcldOftIncl() {
		return this.sXcldOftIncl;
	}
	
	/**
	 * Column Info
	 * @return sWoStsCd
	 */
	public String getSWoStsCd() {
		return this.sWoStsCd;
	}
	
	/**
	 * Column Info
	 * @return woVndrSeq
	 */
	public String getWoVndrSeq() {
		return this.woVndrSeq;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return sToDt
	 */
	public String getSToDt() {
		return this.sToDt;
	}
	
	/**
	 * Column Info
	 * @return sEacIf
	 */
	public String getSEacIf() {
		return this.sEacIf;
	}
	
	/**
	 * Column Info
	 * @return interRmk
	 */
	public String getInterRmk() {
		return this.interRmk;
	}
	
	/**
	 * Column Info
	 * @return eacIfFlg
	 */
	public String getEacIfFlg() {
		return this.eacIfFlg;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return sFmDt
	 */
	public String getSFmDt() {
		return this.sFmDt;
	}
	
	/**
	 * Column Info
	 * @return bkgScgAmt
	 */
	public String getBkgScgAmt() {
		return this.bkgScgAmt;
	}
	
	/**
	 * Column Info
	 * @return spclInstrRmk
	 */
	public String getSpclInstrRmk() {
		return this.spclInstrRmk;
	}
	
	/**
	 * Column Info
	 * @return trspCrrModCd
	 */
	public String getTrspCrrModCd() {
		return this.trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return woAmt
	 */
	public String getWoAmt() {
		return this.woAmt;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return trspBndCd
	 */
	public String getTrspBndCd() {
		return this.trspBndCd;
	}
	
	/**
	 * Column Info
	 * @return trspPurpRsn
	 */
	public String getTrspPurpRsn() {
		return this.trspPurpRsn;
	}
	
	/**
	 * Column Info
	 * @return sRcvTrm
	 */
	public String getSRcvTrm() {
		return this.sRcvTrm;
	}
	
	/**
	 * Column Info
	 * @return invUsrNm
	 */
	public String getInvUsrNm() {
		return this.invUsrNm;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return soUsrNm
	 */
	public String getSoUsrNm() {
		return this.soUsrNm;
	}
	
	/**
	 * Column Info
	 * @return sCstCd
	 */
	public String getSCstCd() {
		return this.sCstCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return viaNodCd
	 */
	public String getViaNodCd() {
		return this.viaNodCd;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param cngRsnDesc
	 */
	public void setCngRsnDesc(String cngRsnDesc) {
		this.cngRsnDesc = cngRsnDesc;
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
	 * @param trspCostDtlModCd
	 */
	public void setTrspCostDtlModCd(String trspCostDtlModCd) {
		this.trspCostDtlModCd = trspCostDtlModCd;
	}
	
	/**
	 * Column Info
	 * @param bkgRcvdeTermCd
	 */
	public void setBkgRcvdeTermCd(String bkgRcvdeTermCd) {
		this.bkgRcvdeTermCd = bkgRcvdeTermCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param bkgScgUsdAmt
	 */
	public void setBkgScgUsdAmt(String bkgScgUsdAmt) {
		this.bkgScgUsdAmt = bkgScgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param troFlg
	 */
	public void setTroFlg(String troFlg) {
		this.troFlg = troFlg;
	}
	
	/**
	 * Column Info
	 * @param invUsdAmt
	 */
	public void setInvUsdAmt(String invUsdAmt) {
		this.invUsdAmt = invUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param soNo
	 */
	public void setSoNo(String soNo) {
		this.soNo = soNo;
	}
	
	/**
	 * Column Info
	 * @param bkgCurrCd
	 */
	public void setBkgCurrCd(String bkgCurrCd) {
		this.bkgCurrCd = bkgCurrCd;
	}
	
	/**
	 * Column Info
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param sDlvryTrm
	 */
	public void setSDlvryTrm(String sDlvryTrm) {
		this.sDlvryTrm = sDlvryTrm;
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
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
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
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sBndCd
	 */
	public void setSBndCd(String sBndCd) {
		this.sBndCd = sBndCd;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param sXcldOftIncl
	 */
	public void setSXcldOftIncl(String sXcldOftIncl) {
		this.sXcldOftIncl = sXcldOftIncl;
	}
	
	/**
	 * Column Info
	 * @param sWoStsCd
	 */
	public void setSWoStsCd(String sWoStsCd) {
		this.sWoStsCd = sWoStsCd;
	}
	
	/**
	 * Column Info
	 * @param woVndrSeq
	 */
	public void setWoVndrSeq(String woVndrSeq) {
		this.woVndrSeq = woVndrSeq;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param sToDt
	 */
	public void setSToDt(String sToDt) {
		this.sToDt = sToDt;
	}
	
	/**
	 * Column Info
	 * @param sEacIf
	 */
	public void setSEacIf(String sEacIf) {
		this.sEacIf = sEacIf;
	}
	
	/**
	 * Column Info
	 * @param interRmk
	 */
	public void setInterRmk(String interRmk) {
		this.interRmk = interRmk;
	}
	
	/**
	 * Column Info
	 * @param eacIfFlg
	 */
	public void setEacIfFlg(String eacIfFlg) {
		this.eacIfFlg = eacIfFlg;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param sFmDt
	 */
	public void setSFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
	}
	
	/**
	 * Column Info
	 * @param bkgScgAmt
	 */
	public void setBkgScgAmt(String bkgScgAmt) {
		this.bkgScgAmt = bkgScgAmt;
	}
	
	/**
	 * Column Info
	 * @param spclInstrRmk
	 */
	public void setSpclInstrRmk(String spclInstrRmk) {
		this.spclInstrRmk = spclInstrRmk;
	}
	
	/**
	 * Column Info
	 * @param trspCrrModCd
	 */
	public void setTrspCrrModCd(String trspCrrModCd) {
		this.trspCrrModCd = trspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param woAmt
	 */
	public void setWoAmt(String woAmt) {
		this.woAmt = woAmt;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param trspBndCd
	 */
	public void setTrspBndCd(String trspBndCd) {
		this.trspBndCd = trspBndCd;
	}
	
	/**
	 * Column Info
	 * @param trspPurpRsn
	 */
	public void setTrspPurpRsn(String trspPurpRsn) {
		this.trspPurpRsn = trspPurpRsn;
	}
	
	/**
	 * Column Info
	 * @param sRcvTrm
	 */
	public void setSRcvTrm(String sRcvTrm) {
		this.sRcvTrm = sRcvTrm;
	}
	
	/**
	 * Column Info
	 * @param invUsrNm
	 */
	public void setInvUsrNm(String invUsrNm) {
		this.invUsrNm = invUsrNm;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param soUsrNm
	 */
	public void setSoUsrNm(String soUsrNm) {
		this.soUsrNm = soUsrNm;
	}
	
	/**
	 * Column Info
	 * @param sCstCd
	 */
	public void setSCstCd(String sCstCd) {
		this.sCstCd = sCstCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setCngRsnDesc(JSPUtil.getParameter(request, prefix + "cng_rsn_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setBkgRcvdeTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcvde_term_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, prefix + "del_nod_cd", ""));
		setBkgScgUsdAmt(JSPUtil.getParameter(request, prefix + "bkg_scg_usd_amt", ""));
		setTroFlg(JSPUtil.getParameter(request, prefix + "tro_flg", ""));
		setInvUsdAmt(JSPUtil.getParameter(request, prefix + "inv_usd_amt", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setBkgCurrCd(JSPUtil.getParameter(request, prefix + "bkg_curr_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSDlvryTrm(JSPUtil.getParameter(request, prefix + "s_dlvry_trm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setSBndCd(JSPUtil.getParameter(request, prefix + "s_bnd_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setSXcldOftIncl(JSPUtil.getParameter(request, prefix + "s_xcld_oft_incl", ""));
		setSWoStsCd(JSPUtil.getParameter(request, prefix + "s_wo_sts_cd", ""));
		setWoVndrSeq(JSPUtil.getParameter(request, prefix + "wo_vndr_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setSEacIf(JSPUtil.getParameter(request, prefix + "s_eac_if", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setEacIfFlg(JSPUtil.getParameter(request, prefix + "eac_if_flg", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
		setBkgScgAmt(JSPUtil.getParameter(request, prefix + "bkg_scg_amt", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setWoAmt(JSPUtil.getParameter(request, prefix + "wo_amt", ""));
		setPorNodCd(JSPUtil.getParameter(request, prefix + "por_nod_cd", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setTrspPurpRsn(JSPUtil.getParameter(request, prefix + "trsp_purp_rsn", ""));
		setSRcvTrm(JSPUtil.getParameter(request, prefix + "s_rcv_trm", ""));
		setInvUsrNm(JSPUtil.getParameter(request, prefix + "inv_usr_nm", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setSoUsrNm(JSPUtil.getParameter(request, prefix + "so_usr_nm", ""));
		setSCstCd(JSPUtil.getParameter(request, prefix + "s_cst_cd", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UnmatchRouteBkgVsSoVO[]
	 */
	public UnmatchRouteBkgVsSoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UnmatchRouteBkgVsSoVO[]
	 */
	public UnmatchRouteBkgVsSoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UnmatchRouteBkgVsSoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] cngRsnDesc = (JSPUtil.getParameter(request, prefix	+ "cng_rsn_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] bkgRcvdeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcvde_term_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] bkgScgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_usd_amt", length));
			String[] troFlg = (JSPUtil.getParameter(request, prefix	+ "tro_flg", length));
			String[] invUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_amt", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] bkgCurrCd = (JSPUtil.getParameter(request, prefix	+ "bkg_curr_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sDlvryTrm = (JSPUtil.getParameter(request, prefix	+ "s_dlvry_trm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] sBndCd = (JSPUtil.getParameter(request, prefix	+ "s_bnd_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] sXcldOftIncl = (JSPUtil.getParameter(request, prefix	+ "s_xcld_oft_incl", length));
			String[] sWoStsCd = (JSPUtil.getParameter(request, prefix	+ "s_wo_sts_cd", length));
			String[] woVndrSeq = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] sEacIf = (JSPUtil.getParameter(request, prefix	+ "s_eac_if", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] eacIfFlg = (JSPUtil.getParameter(request, prefix	+ "eac_if_flg", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			String[] bkgScgAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_scg_amt", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] woAmt = (JSPUtil.getParameter(request, prefix	+ "wo_amt", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] trspPurpRsn = (JSPUtil.getParameter(request, prefix	+ "trsp_purp_rsn", length));
			String[] sRcvTrm = (JSPUtil.getParameter(request, prefix	+ "s_rcv_trm", length));
			String[] invUsrNm = (JSPUtil.getParameter(request, prefix	+ "inv_usr_nm", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] soUsrNm = (JSPUtil.getParameter(request, prefix	+ "so_usr_nm", length));
			String[] sCstCd = (JSPUtil.getParameter(request, prefix	+ "s_cst_cd", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UnmatchRouteBkgVsSoVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (cngRsnDesc[i] != null)
					model.setCngRsnDesc(cngRsnDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (bkgRcvdeTermCd[i] != null)
					model.setBkgRcvdeTermCd(bkgRcvdeTermCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (bkgScgUsdAmt[i] != null)
					model.setBkgScgUsdAmt(bkgScgUsdAmt[i]);
				if (troFlg[i] != null)
					model.setTroFlg(troFlg[i]);
				if (invUsdAmt[i] != null)
					model.setInvUsdAmt(invUsdAmt[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (bkgCurrCd[i] != null)
					model.setBkgCurrCd(bkgCurrCd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sDlvryTrm[i] != null)
					model.setSDlvryTrm(sDlvryTrm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (sBndCd[i] != null)
					model.setSBndCd(sBndCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (sXcldOftIncl[i] != null)
					model.setSXcldOftIncl(sXcldOftIncl[i]);
				if (sWoStsCd[i] != null)
					model.setSWoStsCd(sWoStsCd[i]);
				if (woVndrSeq[i] != null)
					model.setWoVndrSeq(woVndrSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (sEacIf[i] != null)
					model.setSEacIf(sEacIf[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (eacIfFlg[i] != null)
					model.setEacIfFlg(eacIfFlg[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				if (bkgScgAmt[i] != null)
					model.setBkgScgAmt(bkgScgAmt[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (woAmt[i] != null)
					model.setWoAmt(woAmt[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (trspPurpRsn[i] != null)
					model.setTrspPurpRsn(trspPurpRsn[i]);
				if (sRcvTrm[i] != null)
					model.setSRcvTrm(sRcvTrm[i]);
				if (invUsrNm[i] != null)
					model.setInvUsrNm(invUsrNm[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (soUsrNm[i] != null)
					model.setSoUsrNm(soUsrNm[i]);
				if (sCstCd[i] != null)
					model.setSCstCd(sCstCd[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUnmatchRouteBkgVsSoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UnmatchRouteBkgVsSoVO[]
	 */
	public UnmatchRouteBkgVsSoVO[] getUnmatchRouteBkgVsSoVOs(){
		UnmatchRouteBkgVsSoVO[] vos = (UnmatchRouteBkgVsSoVO[])models.toArray(new UnmatchRouteBkgVsSoVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngRsnDesc = this.cngRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvdeTermCd = this.bkgRcvdeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgUsdAmt = this.bkgScgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troFlg = this.troFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdAmt = this.invUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCurrCd = this.bkgCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDlvryTrm = this.sDlvryTrm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBndCd = this.sBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sXcldOftIncl = this.sXcldOftIncl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sWoStsCd = this.sWoStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrSeq = this.woVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacIf = this.sEacIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacIfFlg = this.eacIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgScgAmt = this.bkgScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woAmt = this.woAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspPurpRsn = this.trspPurpRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRcvTrm = this.sRcvTrm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsrNm = this.invUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soUsrNm = this.soUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCstCd = this.sCstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
