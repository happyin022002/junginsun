/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialSoOfTrsVO.java
*@FileTitle : SpecialSoOfTrsVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.03
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.03.03 최종혁 
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
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpecialSoOfTrsVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpecialSoOfTrsVO> models = new ArrayList<SpecialSoOfTrsVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String invVndrSeq = null;
	/* Column Info */
	private String soLoclCreDt = null;
	/* Column Info */
	private String woLoclCreDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String trspSoTpCd = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String negoAmt = null;
	/* Column Info */
	private String woTotAmt = null;
	/* Column Info */
	private String woUsdTotAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String sTrspCrrModCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String prntVndrSeq = null;
	/* Column Info */
	private String sBndCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String prntVndrNm = null;
	/* Column Info */
	private String ord = null;
	/* Column Info */
	private String scgVatAmt = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Column Info */
	private String woUsrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String eqNo = null;
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
	private String sFmDt = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String etcAddAmt = null;
	/* Column Info */
	private String trspPurpRsn = null;
	/* Column Info */
	private String soUsrNm = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String fuelScgAmt = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String n3ptyBilFlg = null;
	/* Column Info */
	private String viaNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SpecialSoOfTrsVO() {}

	public SpecialSoOfTrsVO(String ibflag, String pagerows, String sRhqOfcCd, String sOfcCd, String sFmDt, String sToDt, String sBndCd, String sEacIf, String sTrspCrrModCd, String eqNo, String eqTpszCd, String trspCrrModCd, String trspSoTpCd, String soNo, String soLoclCreDt, String soUsrNm, String woNo, String woLoclCreDt, String woOfcCd, String woUsrNm, String fmNodCd, String viaNodCd, String toNodCd, String dorNodCd, String vndrSeq, String vndrNm, String prntVndrSeq, String prntVndrNm, String n3ptyBilFlg, String currCd, String bzcAmt, String negoAmt, String fuelScgAmt, String scgVatAmt, String etcAddAmt, String woTotAmt, String woUsdTotAmt, String invNo, String invVndrSeq, String trspPurpRsn, String interRmk, String spclInstrRmk, String bkgNo, String porCd, String polCd, String podCd, String delCd, String eacIfFlg, String ord) {
		this.toNodCd = toNodCd;
		this.invVndrSeq = invVndrSeq;
		this.soLoclCreDt = soLoclCreDt;
		this.woLoclCreDt = woLoclCreDt;
		this.pagerows = pagerows;
		this.vndrNm = vndrNm;
		this.polCd = polCd;
		this.trspSoTpCd = trspSoTpCd;
		this.soNo = soNo;
		this.sOfcCd = sOfcCd;
		this.delCd = delCd;
		this.eqTpszCd = eqTpszCd;
		this.podCd = podCd;
		this.negoAmt = negoAmt;
		this.woTotAmt = woTotAmt;
		this.woUsdTotAmt = woUsdTotAmt;
		this.bkgNo = bkgNo;
		this.vndrSeq = vndrSeq;
		this.sTrspCrrModCd = sTrspCrrModCd;
		this.porCd = porCd;
		this.sRhqOfcCd = sRhqOfcCd;
		this.prntVndrSeq = prntVndrSeq;
		this.sBndCd = sBndCd;
		this.currCd = currCd;
		this.prntVndrNm = prntVndrNm;
		this.ord = ord;
		this.scgVatAmt = scgVatAmt;
		this.woOfcCd = woOfcCd;
		this.woUsrNm = woUsrNm;
		this.ibflag = ibflag;
		this.sToDt = sToDt;
		this.eqNo = eqNo;
		this.sEacIf = sEacIf;
		this.interRmk = interRmk;
		this.eacIfFlg = eacIfFlg;
		this.dorNodCd = dorNodCd;
		this.woNo = woNo;
		this.sFmDt = sFmDt;
		this.spclInstrRmk = spclInstrRmk;
		this.trspCrrModCd = trspCrrModCd;
		this.etcAddAmt = etcAddAmt;
		this.trspPurpRsn = trspPurpRsn;
		this.soUsrNm = soUsrNm;
		this.bzcAmt = bzcAmt;
		this.fuelScgAmt = fuelScgAmt;
		this.fmNodCd = fmNodCd;
		this.invNo = invNo;
		this.n3ptyBilFlg = n3ptyBilFlg;
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
		this.hashColumns.put("so_locl_cre_dt", getSoLoclCreDt());
		this.hashColumns.put("wo_locl_cre_dt", getWoLoclCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("wo_tot_amt", getWoTotAmt());
		this.hashColumns.put("wo_usd_tot_amt", getWoUsdTotAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("s_trsp_crr_mod_cd", getSTrspCrrModCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("prnt_vndr_seq", getPrntVndrSeq());
		this.hashColumns.put("s_bnd_cd", getSBndCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prnt_vndr_nm", getPrntVndrNm());
		this.hashColumns.put("ord", getOrd());
		this.hashColumns.put("scg_vat_amt", getScgVatAmt());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("wo_usr_nm", getWoUsrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("s_eac_if", getSEacIf());
		this.hashColumns.put("inter_rmk", getInterRmk());
		this.hashColumns.put("eac_if_flg", getEacIfFlg());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("etc_add_amt", getEtcAddAmt());
		this.hashColumns.put("trsp_purp_rsn", getTrspPurpRsn());
		this.hashColumns.put("so_usr_nm", getSoUsrNm());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("fuel_scg_amt", getFuelScgAmt());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("n3pty_bil_flg", getN3ptyBilFlg());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("inv_vndr_seq", "invVndrSeq");
		this.hashFields.put("so_locl_cre_dt", "soLoclCreDt");
		this.hashFields.put("wo_locl_cre_dt", "woLoclCreDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("wo_tot_amt", "woTotAmt");
		this.hashFields.put("wo_usd_tot_amt", "woUsdTotAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("s_trsp_crr_mod_cd", "sTrspCrrModCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("prnt_vndr_seq", "prntVndrSeq");
		this.hashFields.put("s_bnd_cd", "sBndCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prnt_vndr_nm", "prntVndrNm");
		this.hashFields.put("ord", "ord");
		this.hashFields.put("scg_vat_amt", "scgVatAmt");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("wo_usr_nm", "woUsrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("s_eac_if", "sEacIf");
		this.hashFields.put("inter_rmk", "interRmk");
		this.hashFields.put("eac_if_flg", "eacIfFlg");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("s_fm_dt", "sFmDt");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("etc_add_amt", "etcAddAmt");
		this.hashFields.put("trsp_purp_rsn", "trspPurpRsn");
		this.hashFields.put("so_usr_nm", "soUsrNm");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("fuel_scg_amt", "fuelScgAmt");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("n3pty_bil_flg", "n3ptyBilFlg");
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
	 * @return invVndrSeq
	 */
	public String getInvVndrSeq() {
		return this.invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return soLoclCreDt
	 */
	public String getSoLoclCreDt() {
		return this.soLoclCreDt;
	}
	
	/**
	 * Column Info
	 * @return woLoclCreDt
	 */
	public String getWoLoclCreDt() {
		return this.woLoclCreDt;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return trspSoTpCd
	 */
	public String getTrspSoTpCd() {
		return this.trspSoTpCd;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return negoAmt
	 */
	public String getNegoAmt() {
		return this.negoAmt;
	}
	
	/**
	 * Column Info
	 * @return woTotAmt
	 */
	public String getWoTotAmt() {
		return this.woTotAmt;
	}
	
	/**
	 * Column Info
	 * @return woUsdTotAmt
	 */
	public String getWoUsdTotAmt() {
		return this.woUsdTotAmt;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return sTrspCrrModCd
	 */
	public String getSTrspCrrModCd() {
		return this.sTrspCrrModCd;
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
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return prntVndrSeq
	 */
	public String getPrntVndrSeq() {
		return this.prntVndrSeq;
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
	 * @return prntVndrNm
	 */
	public String getPrntVndrNm() {
		return this.prntVndrNm;
	}
	
	/**
	 * Column Info
	 * @return ord
	 */
	public String getOrd() {
		return this.ord;
	}
	
	/**
	 * Column Info
	 * @return scgVatAmt
	 */
	public String getScgVatAmt() {
		return this.scgVatAmt;
	}
	
	/**
	 * Column Info
	 * @return woOfcCd
	 */
	public String getWoOfcCd() {
		return this.woOfcCd;
	}
	
	/**
	 * Column Info
	 * @return woUsrNm
	 */
	public String getWoUsrNm() {
		return this.woUsrNm;
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
	 * @return sToDt
	 */
	public String getSToDt() {
		return this.sToDt;
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
	 * @return sFmDt
	 */
	public String getSFmDt() {
		return this.sFmDt;
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
	 * @return etcAddAmt
	 */
	public String getEtcAddAmt() {
		return this.etcAddAmt;
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
	 * @return soUsrNm
	 */
	public String getSoUsrNm() {
		return this.soUsrNm;
	}
	
	/**
	 * Column Info
	 * @return bzcAmt
	 */
	public String getBzcAmt() {
		return this.bzcAmt;
	}
	
	/**
	 * Column Info
	 * @return fuelScgAmt
	 */
	public String getFuelScgAmt() {
		return this.fuelScgAmt;
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
	 * @return n3ptyBilFlg
	 */
	public String getN3ptyBilFlg() {
		return this.n3ptyBilFlg;
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
	 * @param invVndrSeq
	 */
	public void setInvVndrSeq(String invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param soLoclCreDt
	 */
	public void setSoLoclCreDt(String soLoclCreDt) {
		this.soLoclCreDt = soLoclCreDt;
	}
	
	/**
	 * Column Info
	 * @param woLoclCreDt
	 */
	public void setWoLoclCreDt(String woLoclCreDt) {
		this.woLoclCreDt = woLoclCreDt;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param trspSoTpCd
	 */
	public void setTrspSoTpCd(String trspSoTpCd) {
		this.trspSoTpCd = trspSoTpCd;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param negoAmt
	 */
	public void setNegoAmt(String negoAmt) {
		this.negoAmt = negoAmt;
	}
	
	/**
	 * Column Info
	 * @param woTotAmt
	 */
	public void setWoTotAmt(String woTotAmt) {
		this.woTotAmt = woTotAmt;
	}
	
	/**
	 * Column Info
	 * @param woUsdTotAmt
	 */
	public void setWoUsdTotAmt(String woUsdTotAmt) {
		this.woUsdTotAmt = woUsdTotAmt;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param sTrspCrrModCd
	 */
	public void setSTrspCrrModCd(String sTrspCrrModCd) {
		this.sTrspCrrModCd = sTrspCrrModCd;
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
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param prntVndrSeq
	 */
	public void setPrntVndrSeq(String prntVndrSeq) {
		this.prntVndrSeq = prntVndrSeq;
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
	 * @param prntVndrNm
	 */
	public void setPrntVndrNm(String prntVndrNm) {
		this.prntVndrNm = prntVndrNm;
	}
	
	/**
	 * Column Info
	 * @param ord
	 */
	public void setOrd(String ord) {
		this.ord = ord;
	}
	
	/**
	 * Column Info
	 * @param scgVatAmt
	 */
	public void setScgVatAmt(String scgVatAmt) {
		this.scgVatAmt = scgVatAmt;
	}
	
	/**
	 * Column Info
	 * @param woOfcCd
	 */
	public void setWoOfcCd(String woOfcCd) {
		this.woOfcCd = woOfcCd;
	}
	
	/**
	 * Column Info
	 * @param woUsrNm
	 */
	public void setWoUsrNm(String woUsrNm) {
		this.woUsrNm = woUsrNm;
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
	 * @param sToDt
	 */
	public void setSToDt(String sToDt) {
		this.sToDt = sToDt;
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
	 * @param sFmDt
	 */
	public void setSFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
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
	 * @param etcAddAmt
	 */
	public void setEtcAddAmt(String etcAddAmt) {
		this.etcAddAmt = etcAddAmt;
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
	 * @param soUsrNm
	 */
	public void setSoUsrNm(String soUsrNm) {
		this.soUsrNm = soUsrNm;
	}
	
	/**
	 * Column Info
	 * @param bzcAmt
	 */
	public void setBzcAmt(String bzcAmt) {
		this.bzcAmt = bzcAmt;
	}
	
	/**
	 * Column Info
	 * @param fuelScgAmt
	 */
	public void setFuelScgAmt(String fuelScgAmt) {
		this.fuelScgAmt = fuelScgAmt;
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
	 * @param n3ptyBilFlg
	 */
	public void setN3ptyBilFlg(String n3ptyBilFlg) {
		this.n3ptyBilFlg = n3ptyBilFlg;
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
		setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
		setSoLoclCreDt(JSPUtil.getParameter(request, prefix + "so_locl_cre_dt", ""));
		setWoLoclCreDt(JSPUtil.getParameter(request, prefix + "wo_locl_cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setNegoAmt(JSPUtil.getParameter(request, prefix + "nego_amt", ""));
		setWoTotAmt(JSPUtil.getParameter(request, prefix + "wo_tot_amt", ""));
		setWoUsdTotAmt(JSPUtil.getParameter(request, prefix + "wo_usd_tot_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setSTrspCrrModCd(JSPUtil.getParameter(request, prefix + "s_trsp_crr_mod_cd", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setPrntVndrSeq(JSPUtil.getParameter(request, prefix + "prnt_vndr_seq", ""));
		setSBndCd(JSPUtil.getParameter(request, prefix + "s_bnd_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPrntVndrNm(JSPUtil.getParameter(request, prefix + "prnt_vndr_nm", ""));
		setOrd(JSPUtil.getParameter(request, prefix + "ord", ""));
		setScgVatAmt(JSPUtil.getParameter(request, prefix + "scg_vat_amt", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setWoUsrNm(JSPUtil.getParameter(request, prefix + "wo_usr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setSEacIf(JSPUtil.getParameter(request, prefix + "s_eac_if", ""));
		setInterRmk(JSPUtil.getParameter(request, prefix + "inter_rmk", ""));
		setEacIfFlg(JSPUtil.getParameter(request, prefix + "eac_if_flg", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setEtcAddAmt(JSPUtil.getParameter(request, prefix + "etc_add_amt", ""));
		setTrspPurpRsn(JSPUtil.getParameter(request, prefix + "trsp_purp_rsn", ""));
		setSoUsrNm(JSPUtil.getParameter(request, prefix + "so_usr_nm", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setFuelScgAmt(JSPUtil.getParameter(request, prefix + "fuel_scg_amt", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setN3ptyBilFlg(JSPUtil.getParameter(request, prefix + "n3pty_bil_flg", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpecialSoOfTrsVO[]
	 */
	public SpecialSoOfTrsVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpecialSoOfTrsVO[]
	 */
	public SpecialSoOfTrsVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpecialSoOfTrsVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] invVndrSeq = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq", length));
			String[] soLoclCreDt = (JSPUtil.getParameter(request, prefix	+ "so_locl_cre_dt", length));
			String[] woLoclCreDt = (JSPUtil.getParameter(request, prefix	+ "wo_locl_cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_cd", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] negoAmt = (JSPUtil.getParameter(request, prefix	+ "nego_amt", length));
			String[] woTotAmt = (JSPUtil.getParameter(request, prefix	+ "wo_tot_amt", length));
			String[] woUsdTotAmt = (JSPUtil.getParameter(request, prefix	+ "wo_usd_tot_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] sTrspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "s_trsp_crr_mod_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] prntVndrSeq = (JSPUtil.getParameter(request, prefix	+ "prnt_vndr_seq", length));
			String[] sBndCd = (JSPUtil.getParameter(request, prefix	+ "s_bnd_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] prntVndrNm = (JSPUtil.getParameter(request, prefix	+ "prnt_vndr_nm", length));
			String[] ord = (JSPUtil.getParameter(request, prefix	+ "ord", length));
			String[] scgVatAmt = (JSPUtil.getParameter(request, prefix	+ "scg_vat_amt", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] woUsrNm = (JSPUtil.getParameter(request, prefix	+ "wo_usr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sEacIf = (JSPUtil.getParameter(request, prefix	+ "s_eac_if", length));
			String[] interRmk = (JSPUtil.getParameter(request, prefix	+ "inter_rmk", length));
			String[] eacIfFlg = (JSPUtil.getParameter(request, prefix	+ "eac_if_flg", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] etcAddAmt = (JSPUtil.getParameter(request, prefix	+ "etc_add_amt", length));
			String[] trspPurpRsn = (JSPUtil.getParameter(request, prefix	+ "trsp_purp_rsn", length));
			String[] soUsrNm = (JSPUtil.getParameter(request, prefix	+ "so_usr_nm", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] fuelScgAmt = (JSPUtil.getParameter(request, prefix	+ "fuel_scg_amt", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] n3ptyBilFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_flg", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpecialSoOfTrsVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (invVndrSeq[i] != null)
					model.setInvVndrSeq(invVndrSeq[i]);
				if (soLoclCreDt[i] != null)
					model.setSoLoclCreDt(soLoclCreDt[i]);
				if (woLoclCreDt[i] != null)
					model.setWoLoclCreDt(woLoclCreDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (negoAmt[i] != null)
					model.setNegoAmt(negoAmt[i]);
				if (woTotAmt[i] != null)
					model.setWoTotAmt(woTotAmt[i]);
				if (woUsdTotAmt[i] != null)
					model.setWoUsdTotAmt(woUsdTotAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (sTrspCrrModCd[i] != null)
					model.setSTrspCrrModCd(sTrspCrrModCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (prntVndrSeq[i] != null)
					model.setPrntVndrSeq(prntVndrSeq[i]);
				if (sBndCd[i] != null)
					model.setSBndCd(sBndCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (prntVndrNm[i] != null)
					model.setPrntVndrNm(prntVndrNm[i]);
				if (ord[i] != null)
					model.setOrd(ord[i]);
				if (scgVatAmt[i] != null)
					model.setScgVatAmt(scgVatAmt[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (woUsrNm[i] != null)
					model.setWoUsrNm(woUsrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
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
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (etcAddAmt[i] != null)
					model.setEtcAddAmt(etcAddAmt[i]);
				if (trspPurpRsn[i] != null)
					model.setTrspPurpRsn(trspPurpRsn[i]);
				if (soUsrNm[i] != null)
					model.setSoUsrNm(soUsrNm[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (fuelScgAmt[i] != null)
					model.setFuelScgAmt(fuelScgAmt[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (n3ptyBilFlg[i] != null)
					model.setN3ptyBilFlg(n3ptyBilFlg[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpecialSoOfTrsVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpecialSoOfTrsVO[]
	 */
	public SpecialSoOfTrsVO[] getSpecialSoOfTrsVOs(){
		SpecialSoOfTrsVO[] vos = (SpecialSoOfTrsVO[])models.toArray(new SpecialSoOfTrsVO[models.size()]);
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
		this.soLoclCreDt = this.soLoclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woLoclCreDt = this.woLoclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt = this.negoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woTotAmt = this.woTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woUsdTotAmt = this.woUsdTotAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrspCrrModCd = this.sTrspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntVndrSeq = this.prntVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBndCd = this.sBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntVndrNm = this.prntVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ord = this.ord .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgVatAmt = this.scgVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woUsrNm = this.woUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacIf = this.sEacIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interRmk = this.interRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacIfFlg = this.eacIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcAddAmt = this.etcAddAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspPurpRsn = this.trspPurpRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soUsrNm = this.soUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fuelScgAmt = this.fuelScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilFlg = this.n3ptyBilFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
