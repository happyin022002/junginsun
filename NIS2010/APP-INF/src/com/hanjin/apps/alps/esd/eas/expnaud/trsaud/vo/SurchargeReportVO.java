/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : SurchargeReportVO.java
*@FileTitle : SurchargeReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.11.30
*@LastModifier : 
*@LastVersion : 1.0
* 2017.11.30  
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

public class SurchargeReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SurchargeReportVO> models = new ArrayList<SurchargeReportVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String invVndrSeq = null;
	/* Column Info */
	private String subRailSeq = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sTrnsModCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String sScgCd = null;
	/* Column Info */
	private String otrRmk = null;
	/* Column Info */
	private String chkUsrail = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String soOfcCd = null;
	/* Column Info */
	private String cntrSpe = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String consignee = null;
	/* Column Info */
	private String costNm = null;
	/* Column Info */
	private String sSrchOptCd = null;
	/* Column Info */
	private String woVndrSeq = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String negoRmk = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String sEacIf = null;
	/* Column Info */
	private String interRmk = null;
	/* Column Info */
	private String yrMon = null;
	/* Column Info */
	private String eacIfFlg = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String sFmDt = null;
	/* Column Info */
	private String invUsdScgAmt = null;
	/* Column Info */
	private String invVndrNm = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String woVndrNm = null;
	/* Column Info */
	private String sCgoTpCd = null;
	/* Column Info */
	private String scgUsdAmt = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String invOtrRmk = null;
	/* Column Info */
	private String trspPurpRsn = null;
	/* Column Info */
	private String shipper = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String soUsrNm = null;
	/* Column Info */
	private String sOfcTpCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String n3ptyBilFlg = null;
	/* Column Info */
	private String invScgAmt = null;
	/* Column Info */
	private String sDtTpCd = null;
	/* Column Info */
	private String invRmk = null;
	/* Column Info */
	private String lgsCostCd = null;
	/* Column Info */
	private String scgAmt = null;
	/* Column Info */
	private String viaNodCd = null;
	/* Column Info */
	private String hidUsrail = null;
	/* Column Info */
	private String diffBtwnAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SurchargeReportVO() {}

	public SurchargeReportVO(String ibflag, String pagerows, String sDtTpCd, String sFmDt, String sToDt, String sOfcTpCd, String sRhqOfcCd, String sOfcCd, String sTrnsModCd, String sScgCd, String sCgoTpCd, String sSrchOptCd, String sEacIf, String chk, String yrMon, String soNo, String woNo, String invNo, String bkgNo, String eqNo, String eqTpszCd, String cgoTpCd, String costNm, String currCd, String scgAmt, String scgUsdAmt, String invCurrCd, String invScgAmt, String invUsdScgAmt, String trspCrrModCd, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String trspBndCd, String otrRmk, String trspPurpRsn, String interRmk, String invOtrRmk, String invRmk, String rhqOfcCd, String soOfcCd, String soUsrNm, String n3ptyBilFlg, String woVndrSeq, String woVndrNm, String invVndrSeq, String invVndrNm, String scNo, String rfaNo, String shipper, String consignee, String eacIfFlg, String lgsCostCd, String cntrSpe, String negoRmk, String spclInstrRmk, String subRailSeq, String chkUsrail, String hidUsrail, String diffBtwnAmt) {
		this.toNodCd = toNodCd;
		this.invVndrSeq = invVndrSeq;
		this.subRailSeq = subRailSeq;
		this.cgoTpCd = cgoTpCd;
		this.pagerows = pagerows;
		this.sTrnsModCd = sTrnsModCd;
		this.scNo = scNo;
		this.sScgCd = sScgCd;
		this.otrRmk = otrRmk;
		this.chkUsrail = chkUsrail;
		this.soNo = soNo;
		this.sOfcCd = sOfcCd;
		this.soOfcCd = soOfcCd;
		this.cntrSpe = cntrSpe;
		this.eqTpszCd = eqTpszCd;
		this.rhqOfcCd = rhqOfcCd;
		this.bkgNo = bkgNo;
		this.chk = chk;
		this.sRhqOfcCd = sRhqOfcCd;
		this.currCd = currCd;
		this.consignee = consignee;
		this.costNm = costNm;
		this.sSrchOptCd = sSrchOptCd;
		this.woVndrSeq = woVndrSeq;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.negoRmk = negoRmk;
		this.eqNo = eqNo;
		this.sToDt = sToDt;
		this.sEacIf = sEacIf;
		this.interRmk = interRmk;
		this.yrMon = yrMon;
		this.eacIfFlg = eacIfFlg;
		this.dorNodCd = dorNodCd;
		this.woNo = woNo;
		this.sFmDt = sFmDt;
		this.invUsdScgAmt = invUsdScgAmt;
		this.invVndrNm = invVndrNm;
		this.spclInstrRmk = spclInstrRmk;
		this.trspCrrModCd = trspCrrModCd;
		this.woVndrNm = woVndrNm;
		this.sCgoTpCd = sCgoTpCd;
		this.scgUsdAmt = scgUsdAmt;
		this.trspBndCd = trspBndCd;
		this.invOtrRmk = invOtrRmk;
		this.trspPurpRsn = trspPurpRsn;
		this.shipper = shipper;
		this.invCurrCd = invCurrCd;
		this.soUsrNm = soUsrNm;
		this.sOfcTpCd = sOfcTpCd;
		this.invNo = invNo;
		this.fmNodCd = fmNodCd;
		this.n3ptyBilFlg = n3ptyBilFlg;
		this.invScgAmt = invScgAmt;
		this.sDtTpCd = sDtTpCd;
		this.invRmk = invRmk;
		this.lgsCostCd = lgsCostCd;
		this.scgAmt = scgAmt;
		this.viaNodCd = viaNodCd;
		this.hidUsrail = hidUsrail;
		this.diffBtwnAmt = diffBtwnAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
		this.hashColumns.put("sub_rail_seq", getSubRailSeq());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("s_trns_mod_cd", getSTrnsModCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("s_scg_cd", getSScgCd());
		this.hashColumns.put("otr_rmk", getOtrRmk());
		this.hashColumns.put("chk_usrail", getChkUsrail());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("so_ofc_cd", getSoOfcCd());
		this.hashColumns.put("cntr_spe", getCntrSpe());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("consignee", getConsignee());
		this.hashColumns.put("cost_nm", getCostNm());
		this.hashColumns.put("s_srch_opt_cd", getSSrchOptCd());
		this.hashColumns.put("wo_vndr_seq", getWoVndrSeq());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nego_rmk", getNegoRmk());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("s_eac_if", getSEacIf());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("yr_mon", getYrMon());
		this.hashColumns.put("eac_if_flg", getEacIfFlg());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		this.hashColumns.put("inv_usd_scg_amt", getInvUsdScgAmt());
		this.hashColumns.put("inv_vndr_nm", getInvVndrNm());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("wo_vndr_nm", getWoVndrNm());
		this.hashColumns.put("s_cgo_tp_cd", getSCgoTpCd());
		this.hashColumns.put("scg_usd_amt", getScgUsdAmt());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("inv_otr_rmk", getInvOtrRmk());
		this.hashColumns.put("trsp_purp_rsn", getTrspPurpRsn());
		this.hashColumns.put("shipper", getShipper());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("so_usr_nm", getSoUsrNm());
		this.hashColumns.put("s_ofc_tp_cd", getSOfcTpCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("inv_scg_amt", getInvScgAmt());
		this.hashColumns.put("s_dt_tp_cd", getSDtTpCd());
		this.hashColumns.put("inv_rmk", getInvRmk());
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());
		this.hashColumns.put("scg_amt", getScgAmt());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		this.hashColumns.put("hid_usrail", getHidUsrail());
		this.hashColumns.put("diff_btwn_amt", getDiffBtwnAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("inv_vndr_seq", "invVndrSeq");
		this.hashFields.put("sub_rail_seq", "subRailSeq");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("s_trns_mod_cd", "sTrnsModCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("s_scg_cd", "sScgCd");
		this.hashFields.put("otr_rmk", "otrRmk");
		this.hashFields.put("chk_usrail", "chkUsrail");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("so_ofc_cd", "soOfcCd");
		this.hashFields.put("cntr_spe", "cntrSpe");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("consignee", "consignee");
		this.hashFields.put("cost_nm", "costNm");
		this.hashFields.put("s_srch_opt_cd", "sSrchOptCd");
		this.hashFields.put("wo_vndr_seq", "woVndrSeq");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nego_rmk", "negoRmk");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("s_eac_if", "sEacIf");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("yr_mon", "yrMon");
		this.hashFields.put("eac_if_flg", "eacIfFlg");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("s_fm_dt", "sFmDt");
		this.hashFields.put("inv_usd_scg_amt", "invUsdScgAmt");
		this.hashFields.put("inv_vndr_nm", "invVndrNm");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("wo_vndr_nm", "woVndrNm");
		this.hashFields.put("s_cgo_tp_cd", "sCgoTpCd");
		this.hashFields.put("scg_usd_amt", "scgUsdAmt");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("inv_otr_rmk", "invOtrRmk");
		this.hashFields.put("trsp_purp_rsn", "trspPurpRsn");
		this.hashFields.put("shipper", "shipper");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("so_usr_nm", "soUsrNm");
		this.hashFields.put("s_ofc_tp_cd", "sOfcTpCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
		this.hashFields.put("inv_scg_amt", "invScgAmt");
		this.hashFields.put("s_dt_tp_cd", "sDtTpCd");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("scg_amt", "scgAmt");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		this.hashFields.put("hid_usrail", "hidUsrail");
		this.hashFields.put("diff_btwn_amt", "diffBtwnAmt");
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
	 * @return invVndrSeq
	 */
	public String getInvVndrSeq() {
		return this.invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return subRailSeq
	 */
	public String getSubRailSeq() {
		return this.subRailSeq;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
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
	 * @return sTrnsModCd
	 */
	public String getSTrnsModCd() {
		return this.sTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return sScgCd
	 */
	public String getSScgCd() {
		return this.sScgCd;
	}
	
	/**
	 * Column Info
	 * @return otrRmk
	 */
	public String getOtrRmk() {
		return this.otrRmk;
	}
	
	/**
	 * Column Info
	 * @return chkUsrail
	 */
	public String getChkUsrail() {
		return this.chkUsrail;
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
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return soOfcCd
	 */
	public String getSoOfcCd() {
		return this.soOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSpe
	 */
	public String getCntrSpe() {
		return this.cntrSpe;
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
	 * @return rhqOfcCd
	 */
	public String getRhqOfcCd() {
		return this.rhqOfcCd;
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
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
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
	 * @return consignee
	 */
	public String getConsignee() {
		return this.consignee;
	}
	
	/**
	 * Column Info
	 * @return costNm
	 */
	public String getCostNm() {
		return this.costNm;
	}
	
	/**
	 * Column Info
	 * @return sSrchOptCd
	 */
	public String getSSrchOptCd() {
		return this.sSrchOptCd;
	}
	
	/**
	 * Column Info
	 * @return woVndrSeq
	 */
	public String getWoVndrSeq() {
		return this.woVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return negoRmk
	 */
	public String getNegoRmk() {
		return this.negoRmk;
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
	 * @return yrMon
	 */
	public String getYrMon() {
		return this.yrMon;
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
	 * @return sFmDt
	 */
	public String getSFmDt() {
		return this.sFmDt;
	}
	
	/**
	 * Column Info
	 * @return invUsdScgAmt
	 */
	public String getInvUsdScgAmt() {
		return this.invUsdScgAmt;
	}
	
	/**
	 * Column Info
	 * @return invVndrNm
	 */
	public String getInvVndrNm() {
		return this.invVndrNm;
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
	 * @return woVndrNm
	 */
	public String getWoVndrNm() {
		return this.woVndrNm;
	}
	
	/**
	 * Column Info
	 * @return sCgoTpCd
	 */
	public String getSCgoTpCd() {
		return this.sCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return scgUsdAmt
	 */
	public String getScgUsdAmt() {
		return this.scgUsdAmt;
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
	 * @return invOtrRmk
	 */
	public String getInvOtrRmk() {
		return this.invOtrRmk;
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
	 * @return shipper
	 */
	public String getShipper() {
		return this.shipper;
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
	 * @return sOfcTpCd
	 */
	public String getSOfcTpCd() {
		return this.sOfcTpCd;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilFlg
	 */
	public String getN3ptyBilFlg() {
		return this.n3ptyBilFlg;
	}
	
	/**
	 * Column Info
	 * @return invScgAmt
	 */
	public String getInvScgAmt() {
		return this.invScgAmt;
	}
	
	/**
	 * Column Info
	 * @return sDtTpCd
	 */
	public String getSDtTpCd() {
		return this.sDtTpCd;
	}
	
	/**
	 * Column Info
	 * @return invRmk
	 */
	public String getInvRmk() {
		return this.invRmk;
	}
	
	/**
	 * Column Info
	 * @return lgsCostCd
	 */
	public String getLgsCostCd() {
		return this.lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return scgAmt
	 */
	public String getScgAmt() {
		return this.scgAmt;
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
	 * @return hidUsrail
	 */
	public String getHidUsrail() {
		return this.hidUsrail;
	}
	
	/**
	 * Column Info
	 * @return diffBtwnAmt
	 */	
	public String getDiffBtwnAmt() {
		return diffBtwnAmt;
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
	 * @param invVndrSeq
	 */
	public void setInvVndrSeq(String invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param subRailSeq
	 */
	public void setSubRailSeq(String subRailSeq) {
		this.subRailSeq = subRailSeq;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
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
	 * @param sTrnsModCd
	 */
	public void setSTrnsModCd(String sTrnsModCd) {
		this.sTrnsModCd = sTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param sScgCd
	 */
	public void setSScgCd(String sScgCd) {
		this.sScgCd = sScgCd;
	}
	
	/**
	 * Column Info
	 * @param otrRmk
	 */
	public void setOtrRmk(String otrRmk) {
		this.otrRmk = otrRmk;
	}
	
	/**
	 * Column Info
	 * @param chkUsrail
	 */
	public void setChkUsrail(String chkUsrail) {
		this.chkUsrail = chkUsrail;
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
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param soOfcCd
	 */
	public void setSoOfcCd(String soOfcCd) {
		this.soOfcCd = soOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSpe
	 */
	public void setCntrSpe(String cntrSpe) {
		this.cntrSpe = cntrSpe;
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
	 * @param rhqOfcCd
	 */
	public void setRhqOfcCd(String rhqOfcCd) {
		this.rhqOfcCd = rhqOfcCd;
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
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
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
	 * @param consignee
	 */
	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}
	
	/**
	 * Column Info
	 * @param costNm
	 */
	public void setCostNm(String costNm) {
		this.costNm = costNm;
	}
	
	/**
	 * Column Info
	 * @param sSrchOptCd
	 */
	public void setSSrchOptCd(String sSrchOptCd) {
		this.sSrchOptCd = sSrchOptCd;
	}
	
	/**
	 * Column Info
	 * @param woVndrSeq
	 */
	public void setWoVndrSeq(String woVndrSeq) {
		this.woVndrSeq = woVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param negoRmk
	 */
	public void setNegoRmk(String negoRmk) {
		this.negoRmk = negoRmk;
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
	 * @param yrMon
	 */
	public void setYrMon(String yrMon) {
		this.yrMon = yrMon;
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
	 * @param sFmDt
	 */
	public void setSFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
	}
	
	/**
	 * Column Info
	 * @param invUsdScgAmt
	 */
	public void setInvUsdScgAmt(String invUsdScgAmt) {
		this.invUsdScgAmt = invUsdScgAmt;
	}
	
	/**
	 * Column Info
	 * @param invVndrNm
	 */
	public void setInvVndrNm(String invVndrNm) {
		this.invVndrNm = invVndrNm;
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
	 * @param woVndrNm
	 */
	public void setWoVndrNm(String woVndrNm) {
		this.woVndrNm = woVndrNm;
	}
	
	/**
	 * Column Info
	 * @param sCgoTpCd
	 */
	public void setSCgoTpCd(String sCgoTpCd) {
		this.sCgoTpCd = sCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param scgUsdAmt
	 */
	public void setScgUsdAmt(String scgUsdAmt) {
		this.scgUsdAmt = scgUsdAmt;
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
	 * @param invOtrRmk
	 */
	public void setInvOtrRmk(String invOtrRmk) {
		this.invOtrRmk = invOtrRmk;
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
	 * @param shipper
	 */
	public void setShipper(String shipper) {
		this.shipper = shipper;
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
	 * @param sOfcTpCd
	 */
	public void setSOfcTpCd(String sOfcTpCd) {
		this.sOfcTpCd = sOfcTpCd;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilFlg
	 */
	public void setN3ptyBilFlg(String n3ptyBilFlg) {
		this.n3ptyBilFlg = n3ptyBilFlg;
	}
	
	/**
	 * Column Info
	 * @param invScgAmt
	 */
	public void setInvScgAmt(String invScgAmt) {
		this.invScgAmt = invScgAmt;
	}
	
	/**
	 * Column Info
	 * @param sDtTpCd
	 */
	public void setSDtTpCd(String sDtTpCd) {
		this.sDtTpCd = sDtTpCd;
	}
	
	/**
	 * Column Info
	 * @param invRmk
	 */
	public void setInvRmk(String invRmk) {
		this.invRmk = invRmk;
	}
	
	/**
	 * Column Info
	 * @param lgsCostCd
	 */
	public void setLgsCostCd(String lgsCostCd) {
		this.lgsCostCd = lgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param scgAmt
	 */
	public void setScgAmt(String scgAmt) {
		this.scgAmt = scgAmt;
	}
	
	/**
	 * Column Info
	 * @param viaNodCd
	 */
	public void setViaNodCd(String viaNodCd) {
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * Column Info
	 * @param hidUsrail
	 */
	public void setHidUsrail(String hidUsrail) {
		this.hidUsrail = hidUsrail;
	}
	
	/**
	 * Column Info
	 * @param diffBtwnAmt
	 */	
	public void setDiffBtwnAmt(String diffBtwnAmt) {
		this.diffBtwnAmt = diffBtwnAmt;
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
		setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
		setSubRailSeq(JSPUtil.getParameter(request, prefix + "sub_rail_seq", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSTrnsModCd(JSPUtil.getParameter(request, prefix + "s_trns_mod_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setSScgCd(JSPUtil.getParameter(request, prefix + "s_scg_cd", ""));
		setOtrRmk(JSPUtil.getParameter(request, prefix + "otr_rmk", ""));
		setChkUsrail(JSPUtil.getParameter(request, prefix + "chk_usrail", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setSoOfcCd(JSPUtil.getParameter(request, prefix + "so_ofc_cd", ""));
		setCntrSpe(JSPUtil.getParameter(request, prefix + "cntr_spe", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setConsignee(JSPUtil.getParameter(request, prefix + "consignee", ""));
		setCostNm(JSPUtil.getParameter(request, prefix + "cost_nm", ""));
		setSSrchOptCd(JSPUtil.getParameter(request, prefix + "s_srch_opt_cd", ""));
		setWoVndrSeq(JSPUtil.getParameter(request, prefix + "wo_vndr_seq", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNegoRmk(JSPUtil.getParameter(request, prefix + "nego_rmk", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setSEacIf(JSPUtil.getParameter(request, prefix + "s_eac_if", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setYrMon(JSPUtil.getParameter(request, prefix + "yr_mon", ""));
		setEacIfFlg(JSPUtil.getParameter(request, prefix + "eac_if_flg", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
		setInvUsdScgAmt(JSPUtil.getParameter(request, prefix + "inv_usd_scg_amt", ""));
		setInvVndrNm(JSPUtil.getParameter(request, prefix + "inv_vndr_nm", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setWoVndrNm(JSPUtil.getParameter(request, prefix + "wo_vndr_nm", ""));
		setSCgoTpCd(JSPUtil.getParameter(request, prefix + "s_cgo_tp_cd", ""));
		setScgUsdAmt(JSPUtil.getParameter(request, prefix + "scg_usd_amt", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setInvOtrRmk(JSPUtil.getParameter(request, prefix + "inv_otr_rmk", ""));
		setTrspPurpRsn(JSPUtil.getParameter(request, prefix + "trsp_purp_rsn", ""));
		setShipper(JSPUtil.getParameter(request, prefix + "shipper", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setSoUsrNm(JSPUtil.getParameter(request, prefix + "so_usr_nm", ""));
		setSOfcTpCd(JSPUtil.getParameter(request, prefix + "s_ofc_tp_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", ""));
		setInvScgAmt(JSPUtil.getParameter(request, prefix + "inv_scg_amt", ""));
		setSDtTpCd(JSPUtil.getParameter(request, prefix + "s_dt_tp_cd", ""));
		setInvRmk(JSPUtil.getParameter(request, prefix + "inv_rmk", ""));
		setLgsCostCd(JSPUtil.getParameter(request, prefix + "lgs_cost_cd", ""));
		setScgAmt(JSPUtil.getParameter(request, prefix + "scg_amt", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
		setHidUsrail(JSPUtil.getParameter(request, prefix + "hid_usrail", ""));
		setDiffBtwnAmt(JSPUtil.getParameter(request, prefix + "diff_btwn_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SurchargeReportVO[]
	 */
	public SurchargeReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SurchargeReportVO[]
	 */
	public SurchargeReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SurchargeReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] invVndrSeq = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq", length));
			String[] subRailSeq = (JSPUtil.getParameter(request, prefix	+ "sub_rail_seq", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "s_trns_mod_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] sScgCd = (JSPUtil.getParameter(request, prefix	+ "s_scg_cd", length));
			String[] otrRmk = (JSPUtil.getParameter(request, prefix	+ "otr_rmk", length));
			String[] chkUsrail = (JSPUtil.getParameter(request, prefix	+ "chk_usrail", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] soOfcCd = (JSPUtil.getParameter(request, prefix	+ "so_ofc_cd", length));
			String[] cntrSpe = (JSPUtil.getParameter(request, prefix	+ "cntr_spe", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] consignee = (JSPUtil.getParameter(request, prefix	+ "consignee", length));
			String[] costNm = (JSPUtil.getParameter(request, prefix	+ "cost_nm", length));
			String[] sSrchOptCd = (JSPUtil.getParameter(request, prefix	+ "s_srch_opt_cd", length));
			String[] woVndrSeq = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_seq", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] negoRmk = (JSPUtil.getParameter(request, prefix	+ "nego_rmk", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] sEacIf = (JSPUtil.getParameter(request, prefix	+ "s_eac_if", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] yrMon = (JSPUtil.getParameter(request, prefix	+ "yr_mon", length));
			String[] eacIfFlg = (JSPUtil.getParameter(request, prefix	+ "eac_if_flg", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			String[] invUsdScgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_usd_scg_amt", length));
			String[] invVndrNm = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_nm", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] woVndrNm = (JSPUtil.getParameter(request, prefix	+ "wo_vndr_nm", length));
			String[] sCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "s_cgo_tp_cd", length));
			String[] scgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "scg_usd_amt", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] invOtrRmk = (JSPUtil.getParameter(request, prefix	+ "inv_otr_rmk", length));
			String[] trspPurpRsn = (JSPUtil.getParameter(request, prefix	+ "trsp_purp_rsn", length));
			String[] shipper = (JSPUtil.getParameter(request, prefix	+ "shipper", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] soUsrNm = (JSPUtil.getParameter(request, prefix	+ "so_usr_nm", length));
			String[] sOfcTpCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_tp_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_flg", length));
			String[] invScgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_scg_amt", length));
			String[] sDtTpCd = (JSPUtil.getParameter(request, prefix	+ "s_dt_tp_cd", length));
			String[] invRmk = (JSPUtil.getParameter(request, prefix	+ "inv_rmk", length));
			String[] lgsCostCd = (JSPUtil.getParameter(request, prefix	+ "lgs_cost_cd", length));
			String[] scgAmt = (JSPUtil.getParameter(request, prefix	+ "scg_amt", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			String[] hidUsrail = (JSPUtil.getParameter(request, prefix	+ "hid_usrail", length));
			String[] diffBtwnAmt = (JSPUtil.getParameter(request, prefix	+ "diff_btwn_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SurchargeReportVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (invVndrSeq[i] != null)
					model.setInvVndrSeq(invVndrSeq[i]);
				if (subRailSeq[i] != null)
					model.setSubRailSeq(subRailSeq[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sTrnsModCd[i] != null)
					model.setSTrnsModCd(sTrnsModCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (sScgCd[i] != null)
					model.setSScgCd(sScgCd[i]);
				if (otrRmk[i] != null)
					model.setOtrRmk(otrRmk[i]);
				if (chkUsrail[i] != null)
					model.setChkUsrail(chkUsrail[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (soOfcCd[i] != null)
					model.setSoOfcCd(soOfcCd[i]);
				if (cntrSpe[i] != null)
					model.setCntrSpe(cntrSpe[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (consignee[i] != null)
					model.setConsignee(consignee[i]);
				if (costNm[i] != null)
					model.setCostNm(costNm[i]);
				if (sSrchOptCd[i] != null)
					model.setSSrchOptCd(sSrchOptCd[i]);
				if (woVndrSeq[i] != null)
					model.setWoVndrSeq(woVndrSeq[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (negoRmk[i] != null)
					model.setNegoRmk(negoRmk[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (sEacIf[i] != null)
					model.setSEacIf(sEacIf[i]);
				if (interRmk[i] != null)
					model.setInterRmk(interRmk[i]);
				if (yrMon[i] != null)
					model.setYrMon(yrMon[i]);
				if (eacIfFlg[i] != null)
					model.setEacIfFlg(eacIfFlg[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				if (invUsdScgAmt[i] != null)
					model.setInvUsdScgAmt(invUsdScgAmt[i]);
				if (invVndrNm[i] != null)
					model.setInvVndrNm(invVndrNm[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (woVndrNm[i] != null)
					model.setWoVndrNm(woVndrNm[i]);
				if (sCgoTpCd[i] != null)
					model.setSCgoTpCd(sCgoTpCd[i]);
				if (scgUsdAmt[i] != null)
					model.setScgUsdAmt(scgUsdAmt[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (invOtrRmk[i] != null)
					model.setInvOtrRmk(invOtrRmk[i]);
				if (trspPurpRsn[i] != null)
					model.setTrspPurpRsn(trspPurpRsn[i]);
				if (shipper[i] != null)
					model.setShipper(shipper[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (soUsrNm[i] != null)
					model.setSoUsrNm(soUsrNm[i]);
				if (sOfcTpCd[i] != null)
					model.setSOfcTpCd(sOfcTpCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (invScgAmt[i] != null)
					model.setInvScgAmt(invScgAmt[i]);
				if (sDtTpCd[i] != null)
					model.setSDtTpCd(sDtTpCd[i]);
				if (invRmk[i] != null)
					model.setInvRmk(invRmk[i]);
				if (lgsCostCd[i] != null)
					model.setLgsCostCd(lgsCostCd[i]);
				if (scgAmt[i] != null)
					model.setScgAmt(scgAmt[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				if (hidUsrail[i] != null)
					model.setHidUsrail(hidUsrail[i]);
				if (diffBtwnAmt[i] != null)
					model.setDiffBtwnAmt(diffBtwnAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSurchargeReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SurchargeReportVO[]
	 */
	public SurchargeReportVO[] getSurchargeReportVOs(){
		SurchargeReportVO[] vos = (SurchargeReportVO[])models.toArray(new SurchargeReportVO[models.size()]);
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
		this.invVndrSeq = this.invVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subRailSeq = this.subRailSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrnsModCd = this.sTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sScgCd = this.sScgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrRmk = this.otrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkUsrail = this.chkUsrail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soOfcCd = this.soOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSpe = this.cntrSpe .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignee = this.consignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNm = this.costNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSrchOptCd = this.sSrchOptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrSeq = this.woVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoRmk = this.negoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacIf = this.sEacIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrMon = this.yrMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacIfFlg = this.eacIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdScgAmt = this.invUsdScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrNm = this.invVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woVndrNm = this.woVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCgoTpCd = this.sCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgUsdAmt = this.scgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOtrRmk = this.invOtrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspPurpRsn = this.trspPurpRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipper = this.shipper .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soUsrNm = this.soUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcTpCd = this.sOfcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invScgAmt = this.invScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDtTpCd = this.sDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk = this.invRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd = this.lgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgAmt = this.scgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidUsrail = this.hidUsrail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffBtwnAmt = this.diffBtwnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
