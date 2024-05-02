/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : TrsPreAudDtlListVO.java
*@FileTitle : TrsPreAudDtlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.26
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.04.26 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.trsadvanceaudit.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TrsPreAudDtlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TrsPreAudDtlListVO> models = new ArrayList<TrsPreAudDtlListVO>();
	
	/* Column Info */
	private String sHjlInvVndrSeq = null;
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String invVndrSeq = null;
	/* Column Info */
	private String noOptmRoutFlg = null;
	/* Column Info */
	private String invDiffAmt = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String cgoTpCd = null;
	/* Column Info */
	private String etcScgAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String exceedAvgDiffAmt = null;
	/* Column Info */
	private String trspCostDtlModCd = null;
	/* Column Info */
	private String sInvIssUsrNm = null;
	/* Column Info */
	private String audStsFlg = null;
	/* Column Info */
	private String otrRmk = null;
	/* Column Info */
	private String bkgRcvdeTermCd = null;
	/* Column Info */
	private String trspSoTpCd = null;
	/* Column Info */
	private String sHjlInvNo = null;
	/* Column Info */
	private String invDiffPct = null;
	/* Column Info */
	private String currCngFlg = null;
	/* Column Info */
	private String invEtcScgAmt = null;
	/* Column Info */
	private String woIssDt = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String exceedAvgRto = null;
	/* Column Info */
	private String invDiffRto = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String rhqOfcCd = null;
	/* Column Info */
	private String negoAmt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sInvNo = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String sInvVndrSeq = null;
	/* Column Info */
	private String sTrspCrrModCd = null;
	/* Column Info */
	private String exceedAvgFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String autoAudStsCd = null;
	/* Column Info */
	private String woIssPreMon = null;
	/* Column Info */
	private String woOfcCd = null;
	/* Column Info */
	private String sTrspSoTpCd = null;
	/* Column Info */
	private String invEtcScgNm = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String etcScgNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String negoRmk = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String sAudItmCd = null;
	/* Column Info */
	private String eacIfFlg = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String trspCrrModCd = null;
	/* Column Info */
	private String woAmt = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String sTrspCostDtlModCd = null;
	/* Column Info */
	private String trspBndCd = null;
	/* Column Info */
	private String invOtrRmk = null;
	/* Column Info */
	private String invCfmDt = null;
	/* Column Info */
	private String loclCreDt = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String invDiffAmtFlg = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String noAgmtFlg = null;
	/* Column Info */
	private String viaNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public TrsPreAudDtlListVO() {}

	public TrsPreAudDtlListVO(String ibflag, String pagerows, String sHjlInvVndrSeq, String toNodCd, String invVndrSeq, String noOptmRoutFlg, String invDiffAmt, String trspSoSeq, String cgoTpCd, String etcScgAmt, String exceedAvgDiffAmt, String trspCostDtlModCd, String sInvIssUsrNm, String audStsFlg, String otrRmk, String bkgRcvdeTermCd, String trspSoTpCd, String sHjlInvNo, String invDiffPct, String invEtcScgAmt, String currCngFlg, String soNo, String woIssDt, String invDiffRto, String exceedAvgRto, String eqTpszCd, String rhqOfcCd, String negoAmt, String bkgNo, String sInvNo, String chk, String sInvVndrSeq, String sTrspCrrModCd, String exceedAvgFlg, String currCd, String autoAudStsCd, String woIssPreMon, String woOfcCd, String sTrspSoTpCd, String invEtcScgNm, String trspSoOfcCtyCd, String etcScgNm, String negoRmk, String eqNo, String sAudItmCd, String eacIfFlg, String dorNodCd, String woNo, String invAmt, String trspCrrModCd, String invOfcCd, String woAmt, String trspBndCd, String sTrspCostDtlModCd, String invOtrRmk, String invCfmDt, String invNo, String invDiffAmtFlg, String fmNodCd, String noAgmtFlg, String viaNodCd, String loclCreDt) {
		this.sHjlInvVndrSeq = sHjlInvVndrSeq;
		this.toNodCd = toNodCd;
		this.invVndrSeq = invVndrSeq;
		this.noOptmRoutFlg = noOptmRoutFlg;
		this.invDiffAmt = invDiffAmt;
		this.trspSoSeq = trspSoSeq;
		this.cgoTpCd = cgoTpCd;
		this.etcScgAmt = etcScgAmt;
		this.pagerows = pagerows;
		this.exceedAvgDiffAmt = exceedAvgDiffAmt;
		this.trspCostDtlModCd = trspCostDtlModCd;
		this.sInvIssUsrNm = sInvIssUsrNm;
		this.audStsFlg = audStsFlg;
		this.otrRmk = otrRmk;
		this.bkgRcvdeTermCd = bkgRcvdeTermCd;
		this.trspSoTpCd = trspSoTpCd;
		this.sHjlInvNo = sHjlInvNo;
		this.invDiffPct = invDiffPct;
		this.currCngFlg = currCngFlg;
		this.invEtcScgAmt = invEtcScgAmt;
		this.woIssDt = woIssDt;
		this.soNo = soNo;
		this.exceedAvgRto = exceedAvgRto;
		this.invDiffRto = invDiffRto;
		this.eqTpszCd = eqTpszCd;
		this.rhqOfcCd = rhqOfcCd;
		this.negoAmt = negoAmt;
		this.bkgNo = bkgNo;
		this.sInvNo = sInvNo;
		this.chk = chk;
		this.sInvVndrSeq = sInvVndrSeq;
		this.sTrspCrrModCd = sTrspCrrModCd;
		this.exceedAvgFlg = exceedAvgFlg;
		this.currCd = currCd;
		this.autoAudStsCd = autoAudStsCd;
		this.woIssPreMon = woIssPreMon;
		this.woOfcCd = woOfcCd;
		this.sTrspSoTpCd = sTrspSoTpCd;
		this.invEtcScgNm = invEtcScgNm;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.etcScgNm = etcScgNm;
		this.ibflag = ibflag;
		this.negoRmk = negoRmk;
		this.eqNo = eqNo;
		this.sAudItmCd = sAudItmCd;
		this.eacIfFlg = eacIfFlg;
		this.dorNodCd = dorNodCd;
		this.woNo = woNo;
		this.invAmt = invAmt;
		this.trspCrrModCd = trspCrrModCd;
		this.woAmt = woAmt;
		this.invOfcCd = invOfcCd;
		this.sTrspCostDtlModCd = sTrspCostDtlModCd;
		this.trspBndCd = trspBndCd;
		this.invOtrRmk = invOtrRmk;
		this.invCfmDt = invCfmDt;
		this.loclCreDt = loclCreDt;
		this.fmNodCd = fmNodCd;
		this.invDiffAmtFlg = invDiffAmtFlg;
		this.invNo = invNo;
		this.noAgmtFlg = noAgmtFlg;
		this.viaNodCd = viaNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_hjl_inv_vndr_seq", getSHjlInvVndrSeq());
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
		this.hashColumns.put("no_optm_rout_flg", getNoOptmRoutFlg());
		this.hashColumns.put("inv_diff_amt", getInvDiffAmt());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());
		this.hashColumns.put("etc_scg_amt", getEtcScgAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("exceed_avg_diff_amt", getExceedAvgDiffAmt());
		this.hashColumns.put("trsp_cost_dtl_mod_cd", getTrspCostDtlModCd());
		this.hashColumns.put("s_inv_iss_usr_nm", getSInvIssUsrNm());
		this.hashColumns.put("aud_sts_flg", getAudStsFlg());
		this.hashColumns.put("otr_rmk", getOtrRmk());
		this.hashColumns.put("bkg_rcvde_term_cd", getBkgRcvdeTermCd());
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());
		this.hashColumns.put("s_hjl_inv_no", getSHjlInvNo());
		this.hashColumns.put("inv_diff_pct", getInvDiffPct());
		this.hashColumns.put("curr_cng_flg", getCurrCngFlg());
		this.hashColumns.put("inv_etc_scg_amt", getInvEtcScgAmt());
		this.hashColumns.put("wo_iss_dt", getWoIssDt());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("exceed_avg_rto", getExceedAvgRto());
		this.hashColumns.put("inv_diff_rto", getInvDiffRto());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("rhq_ofc_cd", getRhqOfcCd());
		this.hashColumns.put("nego_amt", getNegoAmt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("s_inv_no", getSInvNo());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("s_inv_vndr_seq", getSInvVndrSeq());
		this.hashColumns.put("s_trsp_crr_mod_cd", getSTrspCrrModCd());
		this.hashColumns.put("exceed_avg_flg", getExceedAvgFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("auto_aud_sts_cd", getAutoAudStsCd());
		this.hashColumns.put("wo_iss_pre_mon", getWoIssPreMon());
		this.hashColumns.put("wo_ofc_cd", getWoOfcCd());
		this.hashColumns.put("s_trsp_so_tp_cd", getSTrspSoTpCd());
		this.hashColumns.put("inv_etc_scg_nm", getInvEtcScgNm());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("etc_scg_nm", getEtcScgNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nego_rmk", getNegoRmk());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("s_aud_itm_cd", getSAudItmCd());
		this.hashColumns.put("eac_if_flg", getEacIfFlg());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("trsp_crr_mod_cd", getTrspCrrModCd());
		this.hashColumns.put("wo_amt", getWoAmt());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("s_trsp_cost_dtl_mod_cd", getSTrspCostDtlModCd());
		this.hashColumns.put("trsp_bnd_cd", getTrspBndCd());
		this.hashColumns.put("inv_otr_rmk", getInvOtrRmk());
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("inv_diff_amt_flg", getInvDiffAmtFlg());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("no_agmt_flg", getNoAgmtFlg());
		this.hashColumns.put("via_nod_cd", getViaNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_hjl_inv_vndr_seq", "sHjlInvVndrSeq");
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("inv_vndr_seq", "invVndrSeq");
		this.hashFields.put("no_optm_rout_flg", "noOptmRoutFlg");
		this.hashFields.put("inv_diff_amt", "invDiffAmt");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		this.hashFields.put("etc_scg_amt", "etcScgAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("exceed_avg_diff_amt", "exceedAvgDiffAmt");
		this.hashFields.put("trsp_cost_dtl_mod_cd", "trspCostDtlModCd");
		this.hashFields.put("s_inv_iss_usr_nm", "sInvIssUsrNm");
		this.hashFields.put("aud_sts_flg", "audStsFlg");
		this.hashFields.put("otr_rmk", "otrRmk");
		this.hashFields.put("bkg_rcvde_term_cd", "bkgRcvdeTermCd");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("s_hjl_inv_no", "sHjlInvNo");
		this.hashFields.put("inv_diff_pct", "invDiffPct");
		this.hashFields.put("curr_cng_flg", "currCngFlg");
		this.hashFields.put("inv_etc_scg_amt", "invEtcScgAmt");
		this.hashFields.put("wo_iss_dt", "woIssDt");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("exceed_avg_rto", "exceedAvgRto");
		this.hashFields.put("inv_diff_rto", "invDiffRto");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("rhq_ofc_cd", "rhqOfcCd");
		this.hashFields.put("nego_amt", "negoAmt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("s_inv_no", "sInvNo");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("s_inv_vndr_seq", "sInvVndrSeq");
		this.hashFields.put("s_trsp_crr_mod_cd", "sTrspCrrModCd");
		this.hashFields.put("exceed_avg_flg", "exceedAvgFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("auto_aud_sts_cd", "autoAudStsCd");
		this.hashFields.put("wo_iss_pre_mon", "woIssPreMon");
		this.hashFields.put("wo_ofc_cd", "woOfcCd");
		this.hashFields.put("s_trsp_so_tp_cd", "sTrspSoTpCd");
		this.hashFields.put("inv_etc_scg_nm", "invEtcScgNm");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("etc_scg_nm", "etcScgNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nego_rmk", "negoRmk");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("s_aud_itm_cd", "sAudItmCd");
		this.hashFields.put("eac_if_flg", "eacIfFlg");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("trsp_crr_mod_cd", "trspCrrModCd");
		this.hashFields.put("wo_amt", "woAmt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("s_trsp_cost_dtl_mod_cd", "sTrspCostDtlModCd");
		this.hashFields.put("trsp_bnd_cd", "trspBndCd");
		this.hashFields.put("inv_otr_rmk", "invOtrRmk");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("inv_diff_amt_flg", "invDiffAmtFlg");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("no_agmt_flg", "noAgmtFlg");
		this.hashFields.put("via_nod_cd", "viaNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sHjlInvVndrSeq
	 */
	public String getSHjlInvVndrSeq() {
		return this.sHjlInvVndrSeq;
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
	 * @return noOptmRoutFlg
	 */
	public String getNoOptmRoutFlg() {
		return this.noOptmRoutFlg;
	}
	
	/**
	 * Column Info
	 * @return invDiffAmt
	 */
	public String getInvDiffAmt() {
		return this.invDiffAmt;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return cgoTpCd
	 */
	public String getCgoTpCd() {
		return this.cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return etcScgAmt
	 */
	public String getEtcScgAmt() {
		return this.etcScgAmt;
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
	 * @return exceedAvgDiffAmt
	 */
	public String getExceedAvgDiffAmt() {
		return this.exceedAvgDiffAmt;
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
	 * @return sInvIssUsrNm
	 */
	public String getSInvIssUsrNm() {
		return this.sInvIssUsrNm;
	}
	
	/**
	 * Column Info
	 * @return audStsFlg
	 */
	public String getAudStsFlg() {
		return this.audStsFlg;
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
	 * @return bkgRcvdeTermCd
	 */
	public String getBkgRcvdeTermCd() {
		return this.bkgRcvdeTermCd;
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
	 * @return sHjlInvNo
	 */
	public String getSHjlInvNo() {
		return this.sHjlInvNo;
	}
	
	/**
	 * Column Info
	 * @return invDiffPct
	 */
	public String getInvDiffPct() {
		return this.invDiffPct;
	}
	
	/**
	 * Column Info
	 * @return currCngFlg
	 */
	public String getCurrCngFlg() {
		return this.currCngFlg;
	}
	
	/**
	 * Column Info
	 * @return invEtcScgAmt
	 */
	public String getInvEtcScgAmt() {
		return this.invEtcScgAmt;
	}
	
	/**
	 * Column Info
	 * @return woIssDt
	 */
	public String getWoIssDt() {
		return this.woIssDt;
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
	 * @return exceedAvgRto
	 */
	public String getExceedAvgRto() {
		return this.exceedAvgRto;
	}
	
	/**
	 * Column Info
	 * @return invDiffRto
	 */
	public String getInvDiffRto() {
		return this.invDiffRto;
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
	 * @return negoAmt
	 */
	public String getNegoAmt() {
		return this.negoAmt;
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
	 * @return sInvNo
	 */
	public String getSInvNo() {
		return this.sInvNo;
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
	 * @return sInvVndrSeq
	 */
	public String getSInvVndrSeq() {
		return this.sInvVndrSeq;
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
	 * @return exceedAvgFlg
	 */
	public String getExceedAvgFlg() {
		return this.exceedAvgFlg;
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
	 * @return autoAudStsCd
	 */
	public String getAutoAudStsCd() {
		return this.autoAudStsCd;
	}
	
	/**
	 * Column Info
	 * @return woIssPreMon
	 */
	public String getWoIssPreMon() {
		return this.woIssPreMon;
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
	 * @return sTrspSoTpCd
	 */
	public String getSTrspSoTpCd() {
		return this.sTrspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @return invEtcScgNm
	 */
	public String getInvEtcScgNm() {
		return this.invEtcScgNm;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return etcScgNm
	 */
	public String getEtcScgNm() {
		return this.etcScgNm;
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
	 * @return sAudItmCd
	 */
	public String getSAudItmCd() {
		return this.sAudItmCd;
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
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sTrspCostDtlModCd
	 */
	public String getSTrspCostDtlModCd() {
		return this.sTrspCostDtlModCd;
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
	 * @return invCfmDt
	 */
	public String getInvCfmDt() {
		return this.invCfmDt;
	}
	
	/**
	 * Column Info
	 * @return loclCreDt
	 */
	public String getLoclCreDt() {
		return this.loclCreDt;
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
	 * @return invDiffAmtFlg
	 */
	public String getInvDiffAmtFlg() {
		return this.invDiffAmtFlg;
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
	 * @return noAgmtFlg
	 */
	public String getNoAgmtFlg() {
		return this.noAgmtFlg;
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
	 * @param sHjlInvVndrSeq
	 */
	public void setSHjlInvVndrSeq(String sHjlInvVndrSeq) {
		this.sHjlInvVndrSeq = sHjlInvVndrSeq;
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
	 * @param noOptmRoutFlg
	 */
	public void setNoOptmRoutFlg(String noOptmRoutFlg) {
		this.noOptmRoutFlg = noOptmRoutFlg;
	}
	
	/**
	 * Column Info
	 * @param invDiffAmt
	 */
	public void setInvDiffAmt(String invDiffAmt) {
		this.invDiffAmt = invDiffAmt;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param cgoTpCd
	 */
	public void setCgoTpCd(String cgoTpCd) {
		this.cgoTpCd = cgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param etcScgAmt
	 */
	public void setEtcScgAmt(String etcScgAmt) {
		this.etcScgAmt = etcScgAmt;
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
	 * @param exceedAvgDiffAmt
	 */
	public void setExceedAvgDiffAmt(String exceedAvgDiffAmt) {
		this.exceedAvgDiffAmt = exceedAvgDiffAmt;
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
	 * @param sInvIssUsrNm
	 */
	public void setSInvIssUsrNm(String sInvIssUsrNm) {
		this.sInvIssUsrNm = sInvIssUsrNm;
	}
	
	/**
	 * Column Info
	 * @param audStsFlg
	 */
	public void setAudStsFlg(String audStsFlg) {
		this.audStsFlg = audStsFlg;
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
	 * @param bkgRcvdeTermCd
	 */
	public void setBkgRcvdeTermCd(String bkgRcvdeTermCd) {
		this.bkgRcvdeTermCd = bkgRcvdeTermCd;
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
	 * @param sHjlInvNo
	 */
	public void setSHjlInvNo(String sHjlInvNo) {
		this.sHjlInvNo = sHjlInvNo;
	}
	
	/**
	 * Column Info
	 * @param invDiffPct
	 */
	public void setInvDiffPct(String invDiffPct) {
		this.invDiffPct = invDiffPct;
	}
	
	/**
	 * Column Info
	 * @param currCngFlg
	 */
	public void setCurrCngFlg(String currCngFlg) {
		this.currCngFlg = currCngFlg;
	}
	
	/**
	 * Column Info
	 * @param invEtcScgAmt
	 */
	public void setInvEtcScgAmt(String invEtcScgAmt) {
		this.invEtcScgAmt = invEtcScgAmt;
	}
	
	/**
	 * Column Info
	 * @param woIssDt
	 */
	public void setWoIssDt(String woIssDt) {
		this.woIssDt = woIssDt;
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
	 * @param exceedAvgRto
	 */
	public void setExceedAvgRto(String exceedAvgRto) {
		this.exceedAvgRto = exceedAvgRto;
	}
	
	/**
	 * Column Info
	 * @param invDiffRto
	 */
	public void setInvDiffRto(String invDiffRto) {
		this.invDiffRto = invDiffRto;
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
	 * @param negoAmt
	 */
	public void setNegoAmt(String negoAmt) {
		this.negoAmt = negoAmt;
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
	 * @param sInvNo
	 */
	public void setSInvNo(String sInvNo) {
		this.sInvNo = sInvNo;
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
	 * @param sInvVndrSeq
	 */
	public void setSInvVndrSeq(String sInvVndrSeq) {
		this.sInvVndrSeq = sInvVndrSeq;
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
	 * @param exceedAvgFlg
	 */
	public void setExceedAvgFlg(String exceedAvgFlg) {
		this.exceedAvgFlg = exceedAvgFlg;
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
	 * @param autoAudStsCd
	 */
	public void setAutoAudStsCd(String autoAudStsCd) {
		this.autoAudStsCd = autoAudStsCd;
	}
	
	/**
	 * Column Info
	 * @param woIssPreMon
	 */
	public void setWoIssPreMon(String woIssPreMon) {
		this.woIssPreMon = woIssPreMon;
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
	 * @param sTrspSoTpCd
	 */
	public void setSTrspSoTpCd(String sTrspSoTpCd) {
		this.sTrspSoTpCd = sTrspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @param invEtcScgNm
	 */
	public void setInvEtcScgNm(String invEtcScgNm) {
		this.invEtcScgNm = invEtcScgNm;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param etcScgNm
	 */
	public void setEtcScgNm(String etcScgNm) {
		this.etcScgNm = etcScgNm;
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
	 * @param sAudItmCd
	 */
	public void setSAudItmCd(String sAudItmCd) {
		this.sAudItmCd = sAudItmCd;
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
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sTrspCostDtlModCd
	 */
	public void setSTrspCostDtlModCd(String sTrspCostDtlModCd) {
		this.sTrspCostDtlModCd = sTrspCostDtlModCd;
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
	 * @param invCfmDt
	 */
	public void setInvCfmDt(String invCfmDt) {
		this.invCfmDt = invCfmDt;
	}
	
	/**
	 * Column Info
	 * @param loclCreDt
	 */
	public void setLoclCreDt(String loclCreDt) {
		this.loclCreDt = loclCreDt;
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
	 * @param invDiffAmtFlg
	 */
	public void setInvDiffAmtFlg(String invDiffAmtFlg) {
		this.invDiffAmtFlg = invDiffAmtFlg;
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
	 * @param noAgmtFlg
	 */
	public void setNoAgmtFlg(String noAgmtFlg) {
		this.noAgmtFlg = noAgmtFlg;
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
		setSHjlInvVndrSeq(JSPUtil.getParameter(request, prefix + "s_hjl_inv_vndr_seq", ""));
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
		setNoOptmRoutFlg(JSPUtil.getParameter(request, prefix + "no_optm_rout_flg", ""));
		setInvDiffAmt(JSPUtil.getParameter(request, prefix + "inv_diff_amt", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, prefix + "trsp_so_seq", ""));
		setCgoTpCd(JSPUtil.getParameter(request, prefix + "cgo_tp_cd", ""));
		setEtcScgAmt(JSPUtil.getParameter(request, prefix + "etc_scg_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setExceedAvgDiffAmt(JSPUtil.getParameter(request, prefix + "exceed_avg_diff_amt", ""));
		setTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "trsp_cost_dtl_mod_cd", ""));
		setSInvIssUsrNm(JSPUtil.getParameter(request, prefix + "s_inv_iss_usr_nm", ""));
		setAudStsFlg(JSPUtil.getParameter(request, prefix + "aud_sts_flg", ""));
		setOtrRmk(JSPUtil.getParameter(request, prefix + "otr_rmk", ""));
		setBkgRcvdeTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcvde_term_cd", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request, prefix + "trsp_so_tp_cd", ""));
		setSHjlInvNo(JSPUtil.getParameter(request, prefix + "s_hjl_inv_no", ""));
		setInvDiffPct(JSPUtil.getParameter(request, prefix + "inv_diff_pct", ""));
		setCurrCngFlg(JSPUtil.getParameter(request, prefix + "curr_cng_flg", ""));
		setInvEtcScgAmt(JSPUtil.getParameter(request, prefix + "inv_etc_scg_amt", ""));
		setWoIssDt(JSPUtil.getParameter(request, prefix + "wo_iss_dt", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setExceedAvgRto(JSPUtil.getParameter(request, prefix + "exceed_avg_rto", ""));
		setInvDiffRto(JSPUtil.getParameter(request, prefix + "inv_diff_rto", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setRhqOfcCd(JSPUtil.getParameter(request, prefix + "rhq_ofc_cd", ""));
		setNegoAmt(JSPUtil.getParameter(request, prefix + "nego_amt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSInvNo(JSPUtil.getParameter(request, prefix + "s_inv_no", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setSInvVndrSeq(JSPUtil.getParameter(request, prefix + "s_inv_vndr_seq", ""));
		setSTrspCrrModCd(JSPUtil.getParameter(request, prefix + "s_trsp_crr_mod_cd", ""));
		setExceedAvgFlg(JSPUtil.getParameter(request, prefix + "exceed_avg_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setAutoAudStsCd(JSPUtil.getParameter(request, prefix + "auto_aud_sts_cd", ""));
		setWoIssPreMon(JSPUtil.getParameter(request, prefix + "wo_iss_pre_mon", ""));
		setWoOfcCd(JSPUtil.getParameter(request, prefix + "wo_ofc_cd", ""));
		setSTrspSoTpCd(JSPUtil.getParameter(request, prefix + "s_trsp_so_tp_cd", ""));
		setInvEtcScgNm(JSPUtil.getParameter(request, prefix + "inv_etc_scg_nm", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, prefix + "trsp_so_ofc_cty_cd", ""));
		setEtcScgNm(JSPUtil.getParameter(request, prefix + "etc_scg_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNegoRmk(JSPUtil.getParameter(request, prefix + "nego_rmk", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setSAudItmCd(JSPUtil.getParameter(request, prefix + "s_aud_itm_cd", ""));
		setEacIfFlg(JSPUtil.getParameter(request, prefix + "eac_if_flg", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setTrspCrrModCd(JSPUtil.getParameter(request, prefix + "trsp_crr_mod_cd", ""));
		setWoAmt(JSPUtil.getParameter(request, prefix + "wo_amt", ""));
		setInvOfcCd(JSPUtil.getParameter(request, prefix + "inv_ofc_cd", ""));
		setSTrspCostDtlModCd(JSPUtil.getParameter(request, prefix + "s_trsp_cost_dtl_mod_cd", ""));
		setTrspBndCd(JSPUtil.getParameter(request, prefix + "trsp_bnd_cd", ""));
		setInvOtrRmk(JSPUtil.getParameter(request, prefix + "inv_otr_rmk", ""));
		setInvCfmDt(JSPUtil.getParameter(request, prefix + "inv_cfm_dt", ""));
		setLoclCreDt(JSPUtil.getParameter(request, prefix + "locl_cre_dt", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setInvDiffAmtFlg(JSPUtil.getParameter(request, prefix + "inv_diff_amt_flg", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setNoAgmtFlg(JSPUtil.getParameter(request, prefix + "no_agmt_flg", ""));
		setViaNodCd(JSPUtil.getParameter(request, prefix + "via_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TrsPreAudDtlListVO[]
	 */
	public TrsPreAudDtlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TrsPreAudDtlListVO[]
	 */
	public TrsPreAudDtlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TrsPreAudDtlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sHjlInvVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_hjl_inv_vndr_seq", length));
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] invVndrSeq = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq", length));
			String[] noOptmRoutFlg = (JSPUtil.getParameter(request, prefix	+ "no_optm_rout_flg", length));
			String[] invDiffAmt = (JSPUtil.getParameter(request, prefix	+ "inv_diff_amt", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] cgoTpCd = (JSPUtil.getParameter(request, prefix	+ "cgo_tp_cd", length));
			String[] etcScgAmt = (JSPUtil.getParameter(request, prefix	+ "etc_scg_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] exceedAvgDiffAmt = (JSPUtil.getParameter(request, prefix	+ "exceed_avg_diff_amt", length));
			String[] trspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_cost_dtl_mod_cd", length));
			String[] sInvIssUsrNm = (JSPUtil.getParameter(request, prefix	+ "s_inv_iss_usr_nm", length));
			String[] audStsFlg = (JSPUtil.getParameter(request, prefix	+ "aud_sts_flg", length));
			String[] otrRmk = (JSPUtil.getParameter(request, prefix	+ "otr_rmk", length));
			String[] bkgRcvdeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcvde_term_cd", length));
			String[] trspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_tp_cd", length));
			String[] sHjlInvNo = (JSPUtil.getParameter(request, prefix	+ "s_hjl_inv_no", length));
			String[] invDiffPct = (JSPUtil.getParameter(request, prefix	+ "inv_diff_pct", length));
			String[] currCngFlg = (JSPUtil.getParameter(request, prefix	+ "curr_cng_flg", length));
			String[] invEtcScgAmt = (JSPUtil.getParameter(request, prefix	+ "inv_etc_scg_amt", length));
			String[] woIssDt = (JSPUtil.getParameter(request, prefix	+ "wo_iss_dt", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] exceedAvgRto = (JSPUtil.getParameter(request, prefix	+ "exceed_avg_rto", length));
			String[] invDiffRto = (JSPUtil.getParameter(request, prefix	+ "inv_diff_rto", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] rhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "rhq_ofc_cd", length));
			String[] negoAmt = (JSPUtil.getParameter(request, prefix	+ "nego_amt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sInvNo = (JSPUtil.getParameter(request, prefix	+ "s_inv_no", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] sInvVndrSeq = (JSPUtil.getParameter(request, prefix	+ "s_inv_vndr_seq", length));
			String[] sTrspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "s_trsp_crr_mod_cd", length));
			String[] exceedAvgFlg = (JSPUtil.getParameter(request, prefix	+ "exceed_avg_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] autoAudStsCd = (JSPUtil.getParameter(request, prefix	+ "auto_aud_sts_cd", length));
			String[] woIssPreMon = (JSPUtil.getParameter(request, prefix	+ "wo_iss_pre_mon", length));
			String[] woOfcCd = (JSPUtil.getParameter(request, prefix	+ "wo_ofc_cd", length));
			String[] sTrspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "s_trsp_so_tp_cd", length));
			String[] invEtcScgNm = (JSPUtil.getParameter(request, prefix	+ "inv_etc_scg_nm", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] etcScgNm = (JSPUtil.getParameter(request, prefix	+ "etc_scg_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] negoRmk = (JSPUtil.getParameter(request, prefix	+ "nego_rmk", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] sAudItmCd = (JSPUtil.getParameter(request, prefix	+ "s_aud_itm_cd", length));
			String[] eacIfFlg = (JSPUtil.getParameter(request, prefix	+ "eac_if_flg", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] trspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "trsp_crr_mod_cd", length));
			String[] woAmt = (JSPUtil.getParameter(request, prefix	+ "wo_amt", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] sTrspCostDtlModCd = (JSPUtil.getParameter(request, prefix	+ "s_trsp_cost_dtl_mod_cd", length));
			String[] trspBndCd = (JSPUtil.getParameter(request, prefix	+ "trsp_bnd_cd", length));
			String[] invOtrRmk = (JSPUtil.getParameter(request, prefix	+ "inv_otr_rmk", length));
			String[] invCfmDt = (JSPUtil.getParameter(request, prefix	+ "inv_cfm_dt", length));
			String[] loclCreDt = (JSPUtil.getParameter(request, prefix	+ "locl_cre_dt", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] invDiffAmtFlg = (JSPUtil.getParameter(request, prefix	+ "inv_diff_amt_flg", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] noAgmtFlg = (JSPUtil.getParameter(request, prefix	+ "no_agmt_flg", length));
			String[] viaNodCd = (JSPUtil.getParameter(request, prefix	+ "via_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new TrsPreAudDtlListVO();
				if (sHjlInvVndrSeq[i] != null)
					model.setSHjlInvVndrSeq(sHjlInvVndrSeq[i]);
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (invVndrSeq[i] != null)
					model.setInvVndrSeq(invVndrSeq[i]);
				if (noOptmRoutFlg[i] != null)
					model.setNoOptmRoutFlg(noOptmRoutFlg[i]);
				if (invDiffAmt[i] != null)
					model.setInvDiffAmt(invDiffAmt[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (cgoTpCd[i] != null)
					model.setCgoTpCd(cgoTpCd[i]);
				if (etcScgAmt[i] != null)
					model.setEtcScgAmt(etcScgAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (exceedAvgDiffAmt[i] != null)
					model.setExceedAvgDiffAmt(exceedAvgDiffAmt[i]);
				if (trspCostDtlModCd[i] != null)
					model.setTrspCostDtlModCd(trspCostDtlModCd[i]);
				if (sInvIssUsrNm[i] != null)
					model.setSInvIssUsrNm(sInvIssUsrNm[i]);
				if (audStsFlg[i] != null)
					model.setAudStsFlg(audStsFlg[i]);
				if (otrRmk[i] != null)
					model.setOtrRmk(otrRmk[i]);
				if (bkgRcvdeTermCd[i] != null)
					model.setBkgRcvdeTermCd(bkgRcvdeTermCd[i]);
				if (trspSoTpCd[i] != null)
					model.setTrspSoTpCd(trspSoTpCd[i]);
				if (sHjlInvNo[i] != null)
					model.setSHjlInvNo(sHjlInvNo[i]);
				if (invDiffPct[i] != null)
					model.setInvDiffPct(invDiffPct[i]);
				if (currCngFlg[i] != null)
					model.setCurrCngFlg(currCngFlg[i]);
				if (invEtcScgAmt[i] != null)
					model.setInvEtcScgAmt(invEtcScgAmt[i]);
				if (woIssDt[i] != null)
					model.setWoIssDt(woIssDt[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (exceedAvgRto[i] != null)
					model.setExceedAvgRto(exceedAvgRto[i]);
				if (invDiffRto[i] != null)
					model.setInvDiffRto(invDiffRto[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (rhqOfcCd[i] != null)
					model.setRhqOfcCd(rhqOfcCd[i]);
				if (negoAmt[i] != null)
					model.setNegoAmt(negoAmt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sInvNo[i] != null)
					model.setSInvNo(sInvNo[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (sInvVndrSeq[i] != null)
					model.setSInvVndrSeq(sInvVndrSeq[i]);
				if (sTrspCrrModCd[i] != null)
					model.setSTrspCrrModCd(sTrspCrrModCd[i]);
				if (exceedAvgFlg[i] != null)
					model.setExceedAvgFlg(exceedAvgFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (autoAudStsCd[i] != null)
					model.setAutoAudStsCd(autoAudStsCd[i]);
				if (woIssPreMon[i] != null)
					model.setWoIssPreMon(woIssPreMon[i]);
				if (woOfcCd[i] != null)
					model.setWoOfcCd(woOfcCd[i]);
				if (sTrspSoTpCd[i] != null)
					model.setSTrspSoTpCd(sTrspSoTpCd[i]);
				if (invEtcScgNm[i] != null)
					model.setInvEtcScgNm(invEtcScgNm[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (etcScgNm[i] != null)
					model.setEtcScgNm(etcScgNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (negoRmk[i] != null)
					model.setNegoRmk(negoRmk[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (sAudItmCd[i] != null)
					model.setSAudItmCd(sAudItmCd[i]);
				if (eacIfFlg[i] != null)
					model.setEacIfFlg(eacIfFlg[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (trspCrrModCd[i] != null)
					model.setTrspCrrModCd(trspCrrModCd[i]);
				if (woAmt[i] != null)
					model.setWoAmt(woAmt[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (sTrspCostDtlModCd[i] != null)
					model.setSTrspCostDtlModCd(sTrspCostDtlModCd[i]);
				if (trspBndCd[i] != null)
					model.setTrspBndCd(trspBndCd[i]);
				if (invOtrRmk[i] != null)
					model.setInvOtrRmk(invOtrRmk[i]);
				if (invCfmDt[i] != null)
					model.setInvCfmDt(invCfmDt[i]);
				if (loclCreDt[i] != null)
					model.setLoclCreDt(loclCreDt[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (invDiffAmtFlg[i] != null)
					model.setInvDiffAmtFlg(invDiffAmtFlg[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (noAgmtFlg[i] != null)
					model.setNoAgmtFlg(noAgmtFlg[i]);
				if (viaNodCd[i] != null)
					model.setViaNodCd(viaNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTrsPreAudDtlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TrsPreAudDtlListVO[]
	 */
	public TrsPreAudDtlListVO[] getTrsPreAudDtlListVOs(){
		TrsPreAudDtlListVO[] vos = (TrsPreAudDtlListVO[])models.toArray(new TrsPreAudDtlListVO[models.size()]);
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
		this.sHjlInvVndrSeq = this.sHjlInvVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrSeq = this.invVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noOptmRoutFlg = this.noOptmRoutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDiffAmt = this.invDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd = this.cgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcScgAmt = this.etcScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceedAvgDiffAmt = this.exceedAvgDiffAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCostDtlModCd = this.trspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvIssUsrNm = this.sInvIssUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audStsFlg = this.audStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otrRmk = this.otrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvdeTermCd = this.bkgRcvdeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd = this.trspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sHjlInvNo = this.sHjlInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDiffPct = this.invDiffPct .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCngFlg = this.currCngFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEtcScgAmt = this.invEtcScgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssDt = this.woIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceedAvgRto = this.exceedAvgRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDiffRto = this.invDiffRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqOfcCd = this.rhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoAmt = this.negoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvNo = this.sInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sInvVndrSeq = this.sInvVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrspCrrModCd = this.sTrspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exceedAvgFlg = this.exceedAvgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoAudStsCd = this.autoAudStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssPreMon = this.woIssPreMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woOfcCd = this.woOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrspSoTpCd = this.sTrspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEtcScgNm = this.invEtcScgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etcScgNm = this.etcScgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.negoRmk = this.negoRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAudItmCd = this.sAudItmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacIfFlg = this.eacIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspCrrModCd = this.trspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woAmt = this.woAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrspCostDtlModCd = this.sTrspCostDtlModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspBndCd = this.trspBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOtrRmk = this.invOtrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt = this.invCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt = this.loclCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDiffAmtFlg = this.invDiffAmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noAgmtFlg = this.noAgmtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaNodCd = this.viaNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
