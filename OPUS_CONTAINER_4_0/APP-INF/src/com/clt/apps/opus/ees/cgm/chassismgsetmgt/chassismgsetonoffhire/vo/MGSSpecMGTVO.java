/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MGSSpecINVO.java
*@FileTitle : MGSSpecINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 박의수
*@LastVersion : 1.0
* 2009.06.30 박의수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박의수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MGSSpecMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSSpecINVO> models = new ArrayList<MGSSpecINVO>();
	
	/* Column Info */
	private String drpOffLmtTpCd = null;
	/* Column Info */
	private String dppCvrgAmt = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String vndrLglEngNmEqspec = null;
	/* Column Info */
	private String lmsmAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String monDpcRtAmt = null;
	/* Column Info */
	private String chssPayldWgt = null;
	/* Column Info */
	private String agmtIssOfcCd = null;
	/* Column Info */
	private String drpOffLmtPrdCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String chssTtlDimHgt = null;
	/* Column Info */
	private String offhHndlRtAmt = null;
	/* Column Info */
	private String eqLotNoEtc = null;
	/* Column Info */
	private String toSerNo = null;
	/* Column Info */
	private String chssTareWgt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agreementNo = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String creDtc = null;
	/* Column Info */
	private String creDta = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqSpecNoTmp = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String mgsetRange = null;
	/* Column Info */
	private String eqSpecNoEtc = null;
	/* Column Info */
	private String initDpcRtAmt = null;
	/* Column Info */
	private String vndrSeqAgree = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String eqLotIssDt = null;
	/* Column Info */
	private String lstVerFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String fmSerNo = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String mgstFuelCapa = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fincVndrLglEngNm = null;
	/* Column Info */
	private String chssTtlDimLen = null;
	/* Column Info */
	private String eqPfxCd = null;
	/* Column Info */
	private String dppRtAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String fincVndrSeq = null;
	/* Column Info */
	private String onhHndlRtAmt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String eqSpecNo = null;
	/* Column Info */
	private String vndrSeqEqspec = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String vndrLglEngNmAgree = null;
	/* Column Info */
	private String mgstVltgCapa = null;
	/* Column Info */
	private String eqRntlTpCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eqLotNoTmp = null;
	/* Column Info */
	private String units = null;
	/* Column Info */
	private String drpOffLmtQty = null;
	/* Column Info */
	private String deYrmon = null;
	/* Column Info */
	private String serialNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String drpOffLmtRto = null;
	/* Column Info */
	private String eqLotNo = null;
	/* Column Info */
	private String maxDpcRtAmt = null;
	/* Column Info */
	private String certChassisNo = null;
	/* Column Info */
	private String dppTpCd = null;
	/* Column Info */
	private String chssTtlDimWdt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSSpecMGTVO() {}

	public MGSSpecMGTVO(String ibflag, String pagerows, String agreementNo, String agmtIssOfcCd, String agmtLstmCd, String agmtOfcCtyCd, String agmtRefNo, String agmtSeq, String agmtVerNo, String certChassisNo, String chssPayldWgt, String chssPoolCd, String chssTareWgt, String chssTtlDimHgt, String chssTtlDimLen, String chssTtlDimWdt, String creDt, String creDta, String creDtc, String creUsrId, String currCd, String deYrmon, String diffRmk, String dppCvrgAmt, String dppRtAmt, String dppTpCd, String drpOffLmtPrdCd, String drpOffLmtQty, String drpOffLmtRto, String drpOffLmtTpCd, String effDt, String eqKndCd, String eqLotIssDt, String eqLotNo, String eqLotNoTmp, String eqLotNoEtc, String eqPfxCd, String eqRntlTpCd, String eqSpecNo, String eqSpecNoTmp, String eqSpecNoEtc, String eqTpszCd, String expDt, String fincVndrSeq, String fincVndrLglEngNm, String fmSerNo, String initDpcRtAmt, String lmsmAmt, String lstVerFlg, String maxDpcRtAmt, String mgsetRange, String mgstFuelCapa, String mgstVltgCapa, String monDpcRtAmt, String offhHndlRtAmt, String onhHndlRtAmt, String payTermDys, String serialNo, String toSerNo, String updDt, String updUsrId, String units, String vndrLglEngNm, String vndrLglEngNmAgree, String vndrLglEngNmEqspec, String vndrSeq, String vndrSeqAgree, String vndrSeqEqspec) {
		this.drpOffLmtTpCd = drpOffLmtTpCd;
		this.dppCvrgAmt = dppCvrgAmt;
		this.chssPoolCd = chssPoolCd;
		this.vndrLglEngNmEqspec = vndrLglEngNmEqspec;
		this.lmsmAmt = lmsmAmt;
		this.pagerows = pagerows;
		this.monDpcRtAmt = monDpcRtAmt;
		this.chssPayldWgt = chssPayldWgt;
		this.agmtIssOfcCd = agmtIssOfcCd;
		this.drpOffLmtPrdCd = drpOffLmtPrdCd;
		this.effDt = effDt;
		this.chssTtlDimHgt = chssTtlDimHgt;
		this.offhHndlRtAmt = offhHndlRtAmt;
		this.eqLotNoEtc = eqLotNoEtc;
		this.toSerNo = toSerNo;
		this.chssTareWgt = chssTareWgt;
		this.updUsrId = updUsrId;
		this.agreementNo = agreementNo;
		this.agmtRefNo = agmtRefNo;
		this.creDtc = creDtc;
		this.creDta = creDta;
		this.agmtSeq = agmtSeq;
		this.agmtLstmCd = agmtLstmCd;
		this.eqSpecNoTmp = eqSpecNoTmp;
		this.payTermDys = payTermDys;
		this.mgsetRange = mgsetRange;
		this.eqSpecNoEtc = eqSpecNoEtc;
		this.initDpcRtAmt = initDpcRtAmt;
		this.vndrSeqAgree = vndrSeqAgree;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.agmtVerNo = agmtVerNo;
		this.eqLotIssDt = eqLotIssDt;
		this.lstVerFlg = lstVerFlg;
		this.currCd = currCd;
		this.fmSerNo = fmSerNo;
		this.vndrLglEngNm = vndrLglEngNm;
		this.mgstFuelCapa = mgstFuelCapa;
		this.creDt = creDt;
		this.fincVndrLglEngNm = fincVndrLglEngNm;
		this.chssTtlDimLen = chssTtlDimLen;
		this.eqPfxCd = eqPfxCd;
		this.dppRtAmt = dppRtAmt;
		this.ibflag = ibflag;
		this.fincVndrSeq = fincVndrSeq;
		this.onhHndlRtAmt = onhHndlRtAmt;
		this.expDt = expDt;
		this.eqSpecNo = eqSpecNo;
		this.vndrSeqEqspec = vndrSeqEqspec;
		this.updDt = updDt;
		this.vndrLglEngNmAgree = vndrLglEngNmAgree;
		this.mgstVltgCapa = mgstVltgCapa;
		this.eqRntlTpCd = eqRntlTpCd;
		this.eqKndCd = eqKndCd;
		this.eqLotNoTmp = eqLotNoTmp;
		this.units = units;
		this.drpOffLmtQty = drpOffLmtQty;
		this.deYrmon = deYrmon;
		this.serialNo = serialNo;
		this.diffRmk = diffRmk;
		this.drpOffLmtRto = drpOffLmtRto;
		this.eqLotNo = eqLotNo;
		this.maxDpcRtAmt = maxDpcRtAmt;
		this.certChassisNo = certChassisNo;
		this.dppTpCd = dppTpCd;
		this.chssTtlDimWdt = chssTtlDimWdt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("drp_off_lmt_tp_cd", getDrpOffLmtTpCd());
		this.hashColumns.put("dpp_cvrg_amt", getDppCvrgAmt());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("vndr_lgl_eng_nm_eqspec", getVndrLglEngNmEqspec());
		this.hashColumns.put("lmsm_amt", getLmsmAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mon_dpc_rt_amt", getMonDpcRtAmt());
		this.hashColumns.put("chss_payld_wgt", getChssPayldWgt());
		this.hashColumns.put("agmt_iss_ofc_cd", getAgmtIssOfcCd());
		this.hashColumns.put("drp_off_lmt_prd_cd", getDrpOffLmtPrdCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("chss_ttl_dim_hgt", getChssTtlDimHgt());
		this.hashColumns.put("offh_hndl_rt_amt", getOffhHndlRtAmt());
		this.hashColumns.put("eq_lot_no_etc", getEqLotNoEtc());
		this.hashColumns.put("to_ser_no", getToSerNo());
		this.hashColumns.put("chss_tare_wgt", getChssTareWgt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agreement_no", getAgreementNo());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("cre_dtc", getCreDtc());
		this.hashColumns.put("cre_dta", getCreDta());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_spec_no_tmp", getEqSpecNoTmp());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("mgset_range", getMgsetRange());
		this.hashColumns.put("eq_spec_no_etc", getEqSpecNoEtc());
		this.hashColumns.put("init_dpc_rt_amt", getInitDpcRtAmt());
		this.hashColumns.put("vndr_seq_agree", getVndrSeqAgree());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("eq_lot_iss_dt", getEqLotIssDt());
		this.hashColumns.put("lst_ver_flg", getLstVerFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("fm_ser_no", getFmSerNo());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("mgst_fuel_capa", getMgstFuelCapa());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("finc_vndr_lgl_eng_nm", getFincVndrLglEngNm());
		this.hashColumns.put("chss_ttl_dim_len", getChssTtlDimLen());
		this.hashColumns.put("eq_pfx_cd", getEqPfxCd());
		this.hashColumns.put("dpp_rt_amt", getDppRtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("finc_vndr_seq", getFincVndrSeq());
		this.hashColumns.put("onh_hndl_rt_amt", getOnhHndlRtAmt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("eq_spec_no", getEqSpecNo());
		this.hashColumns.put("vndr_seq_eqspec", getVndrSeqEqspec());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vndr_lgl_eng_nm_agree", getVndrLglEngNmAgree());
		this.hashColumns.put("mgst_vltg_capa", getMgstVltgCapa());
		this.hashColumns.put("eq_rntl_tp_cd", getEqRntlTpCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eq_lot_no_tmp", getEqLotNoTmp());
		this.hashColumns.put("units", getUnits());
		this.hashColumns.put("drp_off_lmt_qty", getDrpOffLmtQty());
		this.hashColumns.put("de_yrmon", getDeYrmon());
		this.hashColumns.put("serial_no", getSerialNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("drp_off_lmt_rto", getDrpOffLmtRto());
		this.hashColumns.put("eq_lot_no", getEqLotNo());
		this.hashColumns.put("max_dpc_rt_amt", getMaxDpcRtAmt());
		this.hashColumns.put("cert_chassis_no", getCertChassisNo());
		this.hashColumns.put("dpp_tp_cd", getDppTpCd());
		this.hashColumns.put("chss_ttl_dim_wdt", getChssTtlDimWdt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("drp_off_lmt_tp_cd", "drpOffLmtTpCd");
		this.hashFields.put("dpp_cvrg_amt", "dppCvrgAmt");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("vndr_lgl_eng_nm_eqspec", "vndrLglEngNmEqspec");
		this.hashFields.put("lmsm_amt", "lmsmAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mon_dpc_rt_amt", "monDpcRtAmt");
		this.hashFields.put("chss_payld_wgt", "chssPayldWgt");
		this.hashFields.put("agmt_iss_ofc_cd", "agmtIssOfcCd");
		this.hashFields.put("drp_off_lmt_prd_cd", "drpOffLmtPrdCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("chss_ttl_dim_hgt", "chssTtlDimHgt");
		this.hashFields.put("offh_hndl_rt_amt", "offhHndlRtAmt");
		this.hashFields.put("eq_lot_no_etc", "eqLotNoEtc");
		this.hashFields.put("to_ser_no", "toSerNo");
		this.hashFields.put("chss_tare_wgt", "chssTareWgt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agreement_no", "agreementNo");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("cre_dtc", "creDtc");
		this.hashFields.put("cre_dta", "creDta");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_spec_no_tmp", "eqSpecNoTmp");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("mgset_range", "mgsetRange");
		this.hashFields.put("eq_spec_no_etc", "eqSpecNoEtc");
		this.hashFields.put("init_dpc_rt_amt", "initDpcRtAmt");
		this.hashFields.put("vndr_seq_agree", "vndrSeqAgree");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("eq_lot_iss_dt", "eqLotIssDt");
		this.hashFields.put("lst_ver_flg", "lstVerFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("fm_ser_no", "fmSerNo");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("mgst_fuel_capa", "mgstFuelCapa");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("finc_vndr_lgl_eng_nm", "fincVndrLglEngNm");
		this.hashFields.put("chss_ttl_dim_len", "chssTtlDimLen");
		this.hashFields.put("eq_pfx_cd", "eqPfxCd");
		this.hashFields.put("dpp_rt_amt", "dppRtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("finc_vndr_seq", "fincVndrSeq");
		this.hashFields.put("onh_hndl_rt_amt", "onhHndlRtAmt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("eq_spec_no", "eqSpecNo");
		this.hashFields.put("vndr_seq_eqspec", "vndrSeqEqspec");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vndr_lgl_eng_nm_agree", "vndrLglEngNmAgree");
		this.hashFields.put("mgst_vltg_capa", "mgstVltgCapa");
		this.hashFields.put("eq_rntl_tp_cd", "eqRntlTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eq_lot_no_tmp", "eqLotNoTmp");
		this.hashFields.put("units", "units");
		this.hashFields.put("drp_off_lmt_qty", "drpOffLmtQty");
		this.hashFields.put("de_yrmon", "deYrmon");
		this.hashFields.put("serial_no", "serialNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("drp_off_lmt_rto", "drpOffLmtRto");
		this.hashFields.put("eq_lot_no", "eqLotNo");
		this.hashFields.put("max_dpc_rt_amt", "maxDpcRtAmt");
		this.hashFields.put("cert_chassis_no", "certChassisNo");
		this.hashFields.put("dpp_tp_cd", "dppTpCd");
		this.hashFields.put("chss_ttl_dim_wdt", "chssTtlDimWdt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return drpOffLmtTpCd
	 */
	public String getDrpOffLmtTpCd() {
		return this.drpOffLmtTpCd;
	}
	
	/**
	 * Column Info
	 * @return dppCvrgAmt
	 */
	public String getDppCvrgAmt() {
		return this.dppCvrgAmt;
	}
	
	/**
	 * Column Info
	 * @return chssPoolCd
	 */
	public String getChssPoolCd() {
		return this.chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNmEqspec
	 */
	public String getVndrLglEngNmEqspec() {
		return this.vndrLglEngNmEqspec;
	}
	
	/**
	 * Column Info
	 * @return lmsmAmt
	 */
	public String getLmsmAmt() {
		return this.lmsmAmt;
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
	 * @return monDpcRtAmt
	 */
	public String getMonDpcRtAmt() {
		return this.monDpcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return chssPayldWgt
	 */
	public String getChssPayldWgt() {
		return this.chssPayldWgt;
	}
	
	/**
	 * Column Info
	 * @return agmtIssOfcCd
	 */
	public String getAgmtIssOfcCd() {
		return this.agmtIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return drpOffLmtPrdCd
	 */
	public String getDrpOffLmtPrdCd() {
		return this.drpOffLmtPrdCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return chssTtlDimHgt
	 */
	public String getChssTtlDimHgt() {
		return this.chssTtlDimHgt;
	}
	
	/**
	 * Column Info
	 * @return offhHndlRtAmt
	 */
	public String getOffhHndlRtAmt() {
		return this.offhHndlRtAmt;
	}
	
	/**
	 * Column Info
	 * @return eqLotNoEtc
	 */
	public String getEqLotNoEtc() {
		return this.eqLotNoEtc;
	}
	
	/**
	 * Column Info
	 * @return toSerNo
	 */
	public String getToSerNo() {
		return this.toSerNo;
	}
	
	/**
	 * Column Info
	 * @return chssTareWgt
	 */
	public String getChssTareWgt() {
		return this.chssTareWgt;
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
	 * @return agreementNo
	 */
	public String getAgreementNo() {
		return this.agreementNo;
	}
	
	/**
	 * Column Info
	 * @return agmtRefNo
	 */
	public String getAgmtRefNo() {
		return this.agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return creDtc
	 */
	public String getCreDtc() {
		return this.creDtc;
	}
	
	/**
	 * Column Info
	 * @return creDta
	 */
	public String getCreDta() {
		return this.creDta;
	}
	
	/**
	 * Column Info
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtLstmCd
	 */
	public String getAgmtLstmCd() {
		return this.agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @return eqSpecNoTmp
	 */
	public String getEqSpecNoTmp() {
		return this.eqSpecNoTmp;
	}
	
	/**
	 * Column Info
	 * @return payTermDys
	 */
	public String getPayTermDys() {
		return this.payTermDys;
	}
	
	/**
	 * Column Info
	 * @return mgsetRange
	 */
	public String getMgsetRange() {
		return this.mgsetRange;
	}
	
	/**
	 * Column Info
	 * @return eqSpecNoEtc
	 */
	public String getEqSpecNoEtc() {
		return this.eqSpecNoEtc;
	}
	
	/**
	 * Column Info
	 * @return initDpcRtAmt
	 */
	public String getInitDpcRtAmt() {
		return this.initDpcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeqAgree
	 */
	public String getVndrSeqAgree() {
		return this.vndrSeqAgree;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @return eqLotIssDt
	 */
	public String getEqLotIssDt() {
		return this.eqLotIssDt;
	}
	
	/**
	 * Column Info
	 * @return lstVerFlg
	 */
	public String getLstVerFlg() {
		return this.lstVerFlg;
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
	 * @return fmSerNo
	 */
	public String getFmSerNo() {
		return this.fmSerNo;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return mgstFuelCapa
	 */
	public String getMgstFuelCapa() {
		return this.mgstFuelCapa;
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
	 * @return fincVndrLglEngNm
	 */
	public String getFincVndrLglEngNm() {
		return this.fincVndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return chssTtlDimLen
	 */
	public String getChssTtlDimLen() {
		return this.chssTtlDimLen;
	}
	
	/**
	 * Column Info
	 * @return eqPfxCd
	 */
	public String getEqPfxCd() {
		return this.eqPfxCd;
	}
	
	/**
	 * Column Info
	 * @return dppRtAmt
	 */
	public String getDppRtAmt() {
		return this.dppRtAmt;
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
	 * @return fincVndrSeq
	 */
	public String getFincVndrSeq() {
		return this.fincVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return onhHndlRtAmt
	 */
	public String getOnhHndlRtAmt() {
		return this.onhHndlRtAmt;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return eqSpecNo
	 */
	public String getEqSpecNo() {
		return this.eqSpecNo;
	}
	
	/**
	 * Column Info
	 * @return vndrSeqEqspec
	 */
	public String getVndrSeqEqspec() {
		return this.vndrSeqEqspec;
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
	 * @return vndrLglEngNmAgree
	 */
	public String getVndrLglEngNmAgree() {
		return this.vndrLglEngNmAgree;
	}
	
	/**
	 * Column Info
	 * @return mgstVltgCapa
	 */
	public String getMgstVltgCapa() {
		return this.mgstVltgCapa;
	}
	
	/**
	 * Column Info
	 * @return eqRntlTpCd
	 */
	public String getEqRntlTpCd() {
		return this.eqRntlTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return eqLotNoTmp
	 */
	public String getEqLotNoTmp() {
		return this.eqLotNoTmp;
	}
	
	/**
	 * Column Info
	 * @return units
	 */
	public String getUnits() {
		return this.units;
	}
	
	/**
	 * Column Info
	 * @return drpOffLmtQty
	 */
	public String getDrpOffLmtQty() {
		return this.drpOffLmtQty;
	}
	
	/**
	 * Column Info
	 * @return deYrmon
	 */
	public String getDeYrmon() {
		return this.deYrmon;
	}
	
	/**
	 * Column Info
	 * @return serialNo
	 */
	public String getSerialNo() {
		return this.serialNo;
	}
	
	/**
	 * Column Info
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return drpOffLmtRto
	 */
	public String getDrpOffLmtRto() {
		return this.drpOffLmtRto;
	}
	
	/**
	 * Column Info
	 * @return eqLotNo
	 */
	public String getEqLotNo() {
		return this.eqLotNo;
	}
	
	/**
	 * Column Info
	 * @return maxDpcRtAmt
	 */
	public String getMaxDpcRtAmt() {
		return this.maxDpcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return certChassisNo
	 */
	public String getCertChassisNo() {
		return this.certChassisNo;
	}
	
	/**
	 * Column Info
	 * @return dppTpCd
	 */
	public String getDppTpCd() {
		return this.dppTpCd;
	}
	
	/**
	 * Column Info
	 * @return chssTtlDimWdt
	 */
	public String getChssTtlDimWdt() {
		return this.chssTtlDimWdt;
	}
	

	/**
	 * Column Info
	 * @param drpOffLmtTpCd
	 */
	public void setDrpOffLmtTpCd(String drpOffLmtTpCd) {
		this.drpOffLmtTpCd = drpOffLmtTpCd;
	}
	
	/**
	 * Column Info
	 * @param dppCvrgAmt
	 */
	public void setDppCvrgAmt(String dppCvrgAmt) {
		this.dppCvrgAmt = dppCvrgAmt;
	}
	
	/**
	 * Column Info
	 * @param chssPoolCd
	 */
	public void setChssPoolCd(String chssPoolCd) {
		this.chssPoolCd = chssPoolCd;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNmEqspec
	 */
	public void setVndrLglEngNmEqspec(String vndrLglEngNmEqspec) {
		this.vndrLglEngNmEqspec = vndrLglEngNmEqspec;
	}
	
	/**
	 * Column Info
	 * @param lmsmAmt
	 */
	public void setLmsmAmt(String lmsmAmt) {
		this.lmsmAmt = lmsmAmt;
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
	 * @param monDpcRtAmt
	 */
	public void setMonDpcRtAmt(String monDpcRtAmt) {
		this.monDpcRtAmt = monDpcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param chssPayldWgt
	 */
	public void setChssPayldWgt(String chssPayldWgt) {
		this.chssPayldWgt = chssPayldWgt;
	}
	
	/**
	 * Column Info
	 * @param agmtIssOfcCd
	 */
	public void setAgmtIssOfcCd(String agmtIssOfcCd) {
		this.agmtIssOfcCd = agmtIssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param drpOffLmtPrdCd
	 */
	public void setDrpOffLmtPrdCd(String drpOffLmtPrdCd) {
		this.drpOffLmtPrdCd = drpOffLmtPrdCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param chssTtlDimHgt
	 */
	public void setChssTtlDimHgt(String chssTtlDimHgt) {
		this.chssTtlDimHgt = chssTtlDimHgt;
	}
	
	/**
	 * Column Info
	 * @param offhHndlRtAmt
	 */
	public void setOffhHndlRtAmt(String offhHndlRtAmt) {
		this.offhHndlRtAmt = offhHndlRtAmt;
	}
	
	/**
	 * Column Info
	 * @param eqLotNoEtc
	 */
	public void setEqLotNoEtc(String eqLotNoEtc) {
		this.eqLotNoEtc = eqLotNoEtc;
	}
	
	/**
	 * Column Info
	 * @param toSerNo
	 */
	public void setToSerNo(String toSerNo) {
		this.toSerNo = toSerNo;
	}
	
	/**
	 * Column Info
	 * @param chssTareWgt
	 */
	public void setChssTareWgt(String chssTareWgt) {
		this.chssTareWgt = chssTareWgt;
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
	 * @param agreementNo
	 */
	public void setAgreementNo(String agreementNo) {
		this.agreementNo = agreementNo;
	}
	
	/**
	 * Column Info
	 * @param agmtRefNo
	 */
	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param creDtc
	 */
	public void setCreDtc(String creDtc) {
		this.creDtc = creDtc;
	}
	
	/**
	 * Column Info
	 * @param creDta
	 */
	public void setCreDta(String creDta) {
		this.creDta = creDta;
	}
	
	/**
	 * Column Info
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtLstmCd
	 */
	public void setAgmtLstmCd(String agmtLstmCd) {
		this.agmtLstmCd = agmtLstmCd;
	}
	
	/**
	 * Column Info
	 * @param eqSpecNoTmp
	 */
	public void setEqSpecNoTmp(String eqSpecNoTmp) {
		this.eqSpecNoTmp = eqSpecNoTmp;
	}
	
	/**
	 * Column Info
	 * @param payTermDys
	 */
	public void setPayTermDys(String payTermDys) {
		this.payTermDys = payTermDys;
	}
	
	/**
	 * Column Info
	 * @param mgsetRange
	 */
	public void setMgsetRange(String mgsetRange) {
		this.mgsetRange = mgsetRange;
	}
	
	/**
	 * Column Info
	 * @param eqSpecNoEtc
	 */
	public void setEqSpecNoEtc(String eqSpecNoEtc) {
		this.eqSpecNoEtc = eqSpecNoEtc;
	}
	
	/**
	 * Column Info
	 * @param initDpcRtAmt
	 */
	public void setInitDpcRtAmt(String initDpcRtAmt) {
		this.initDpcRtAmt = initDpcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeqAgree
	 */
	public void setVndrSeqAgree(String vndrSeqAgree) {
		this.vndrSeqAgree = vndrSeqAgree;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
	}
	
	/**
	 * Column Info
	 * @param eqLotIssDt
	 */
	public void setEqLotIssDt(String eqLotIssDt) {
		this.eqLotIssDt = eqLotIssDt;
	}
	
	/**
	 * Column Info
	 * @param lstVerFlg
	 */
	public void setLstVerFlg(String lstVerFlg) {
		this.lstVerFlg = lstVerFlg;
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
	 * @param fmSerNo
	 */
	public void setFmSerNo(String fmSerNo) {
		this.fmSerNo = fmSerNo;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param mgstFuelCapa
	 */
	public void setMgstFuelCapa(String mgstFuelCapa) {
		this.mgstFuelCapa = mgstFuelCapa;
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
	 * @param fincVndrLglEngNm
	 */
	public void setFincVndrLglEngNm(String fincVndrLglEngNm) {
		this.fincVndrLglEngNm = fincVndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param chssTtlDimLen
	 */
	public void setChssTtlDimLen(String chssTtlDimLen) {
		this.chssTtlDimLen = chssTtlDimLen;
	}
	
	/**
	 * Column Info
	 * @param eqPfxCd
	 */
	public void setEqPfxCd(String eqPfxCd) {
		this.eqPfxCd = eqPfxCd;
	}
	
	/**
	 * Column Info
	 * @param dppRtAmt
	 */
	public void setDppRtAmt(String dppRtAmt) {
		this.dppRtAmt = dppRtAmt;
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
	 * @param fincVndrSeq
	 */
	public void setFincVndrSeq(String fincVndrSeq) {
		this.fincVndrSeq = fincVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param onhHndlRtAmt
	 */
	public void setOnhHndlRtAmt(String onhHndlRtAmt) {
		this.onhHndlRtAmt = onhHndlRtAmt;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param eqSpecNo
	 */
	public void setEqSpecNo(String eqSpecNo) {
		this.eqSpecNo = eqSpecNo;
	}
	
	/**
	 * Column Info
	 * @param vndrSeqEqspec
	 */
	public void setVndrSeqEqspec(String vndrSeqEqspec) {
		this.vndrSeqEqspec = vndrSeqEqspec;
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
	 * @param vndrLglEngNmAgree
	 */
	public void setVndrLglEngNmAgree(String vndrLglEngNmAgree) {
		this.vndrLglEngNmAgree = vndrLglEngNmAgree;
	}
	
	/**
	 * Column Info
	 * @param mgstVltgCapa
	 */
	public void setMgstVltgCapa(String mgstVltgCapa) {
		this.mgstVltgCapa = mgstVltgCapa;
	}
	
	/**
	 * Column Info
	 * @param eqRntlTpCd
	 */
	public void setEqRntlTpCd(String eqRntlTpCd) {
		this.eqRntlTpCd = eqRntlTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param eqLotNoTmp
	 */
	public void setEqLotNoTmp(String eqLotNoTmp) {
		this.eqLotNoTmp = eqLotNoTmp;
	}
	
	/**
	 * Column Info
	 * @param units
	 */
	public void setUnits(String units) {
		this.units = units;
	}
	
	/**
	 * Column Info
	 * @param drpOffLmtQty
	 */
	public void setDrpOffLmtQty(String drpOffLmtQty) {
		this.drpOffLmtQty = drpOffLmtQty;
	}
	
	/**
	 * Column Info
	 * @param deYrmon
	 */
	public void setDeYrmon(String deYrmon) {
		this.deYrmon = deYrmon;
	}
	
	/**
	 * Column Info
	 * @param serialNo
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
	/**
	 * Column Info
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param drpOffLmtRto
	 */
	public void setDrpOffLmtRto(String drpOffLmtRto) {
		this.drpOffLmtRto = drpOffLmtRto;
	}
	
	/**
	 * Column Info
	 * @param eqLotNo
	 */
	public void setEqLotNo(String eqLotNo) {
		this.eqLotNo = eqLotNo;
	}
	
	/**
	 * Column Info
	 * @param maxDpcRtAmt
	 */
	public void setMaxDpcRtAmt(String maxDpcRtAmt) {
		this.maxDpcRtAmt = maxDpcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param certChassisNo
	 */
	public void setCertChassisNo(String certChassisNo) {
		this.certChassisNo = certChassisNo;
	}
	
	/**
	 * Column Info
	 * @param dppTpCd
	 */
	public void setDppTpCd(String dppTpCd) {
		this.dppTpCd = dppTpCd;
	}
	
	/**
	 * Column Info
	 * @param chssTtlDimWdt
	 */
	public void setChssTtlDimWdt(String chssTtlDimWdt) {
		this.chssTtlDimWdt = chssTtlDimWdt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDrpOffLmtTpCd(JSPUtil.getParameter(request, "drp_off_lmt_tp_cd", ""));
		setDppCvrgAmt(JSPUtil.getParameter(request, "dpp_cvrg_amt", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setVndrLglEngNmEqspec(JSPUtil.getParameter(request, "vndr_lgl_eng_nm_eqspec", ""));
		setLmsmAmt(JSPUtil.getParameter(request, "lmsm_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMonDpcRtAmt(JSPUtil.getParameter(request, "mon_dpc_rt_amt", ""));
		setChssPayldWgt(JSPUtil.getParameter(request, "chss_payld_wgt", ""));
		setAgmtIssOfcCd(JSPUtil.getParameter(request, "agmt_iss_ofc_cd", ""));
		setDrpOffLmtPrdCd(JSPUtil.getParameter(request, "drp_off_lmt_prd_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setChssTtlDimHgt(JSPUtil.getParameter(request, "chss_ttl_dim_hgt", ""));
		setOffhHndlRtAmt(JSPUtil.getParameter(request, "offh_hndl_rt_amt", ""));
		setEqLotNoEtc(JSPUtil.getParameter(request, "eq_lot_no_etc", ""));
		setToSerNo(JSPUtil.getParameter(request, "to_ser_no", ""));
		setChssTareWgt(JSPUtil.getParameter(request, "chss_tare_wgt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAgreementNo(JSPUtil.getParameter(request, "agreement_no", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setCreDtc(JSPUtil.getParameter(request, "cre_dtc", ""));
		setCreDta(JSPUtil.getParameter(request, "cre_dta", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqSpecNoTmp(JSPUtil.getParameter(request, "eq_spec_no_tmp", ""));
		setPayTermDys(JSPUtil.getParameter(request, "pay_term_dys", ""));
		setMgsetRange(JSPUtil.getParameter(request, "mgset_range", ""));
		setEqSpecNoEtc(JSPUtil.getParameter(request, "eq_spec_no_etc", ""));
		setInitDpcRtAmt(JSPUtil.getParameter(request, "init_dpc_rt_amt", ""));
		setVndrSeqAgree(JSPUtil.getParameter(request, "vndr_seq_agree", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setEqLotIssDt(JSPUtil.getParameter(request, "eq_lot_iss_dt", ""));
		setLstVerFlg(JSPUtil.getParameter(request, "lst_ver_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setFmSerNo(JSPUtil.getParameter(request, "fm_ser_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setMgstFuelCapa(JSPUtil.getParameter(request, "mgst_fuel_capa", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFincVndrLglEngNm(JSPUtil.getParameter(request, "finc_vndr_lgl_eng_nm", ""));
		setChssTtlDimLen(JSPUtil.getParameter(request, "chss_ttl_dim_len", ""));
		setEqPfxCd(JSPUtil.getParameter(request, "eq_pfx_cd", ""));
		setDppRtAmt(JSPUtil.getParameter(request, "dpp_rt_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setFincVndrSeq(JSPUtil.getParameter(request, "finc_vndr_seq", ""));
		setOnhHndlRtAmt(JSPUtil.getParameter(request, "onh_hndl_rt_amt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setEqSpecNo(JSPUtil.getParameter(request, "eq_spec_no", ""));
		setVndrSeqEqspec(JSPUtil.getParameter(request, "vndr_seq_eqspec", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setVndrLglEngNmAgree(JSPUtil.getParameter(request, "vndr_lgl_eng_nm_agree", ""));
		setMgstVltgCapa(JSPUtil.getParameter(request, "mgst_vltg_capa", ""));
		setEqRntlTpCd(JSPUtil.getParameter(request, "eq_rntl_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setEqLotNoTmp(JSPUtil.getParameter(request, "eq_lot_no_tmp", ""));
		setUnits(JSPUtil.getParameter(request, "units", ""));
		setDrpOffLmtQty(JSPUtil.getParameter(request, "drp_off_lmt_qty", ""));
		setDeYrmon(JSPUtil.getParameter(request, "de_yrmon", ""));
		setSerialNo(JSPUtil.getParameter(request, "serial_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setDrpOffLmtRto(JSPUtil.getParameter(request, "drp_off_lmt_rto", ""));
		setEqLotNo(JSPUtil.getParameter(request, "eq_lot_no", ""));
		setMaxDpcRtAmt(JSPUtil.getParameter(request, "max_dpc_rt_amt", ""));
		setCertChassisNo(JSPUtil.getParameter(request, "cert_chassis_no", ""));
		setDppTpCd(JSPUtil.getParameter(request, "dpp_tp_cd", ""));
		setChssTtlDimWdt(JSPUtil.getParameter(request, "chss_ttl_dim_wdt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSSpecINVO[]
	 */
	public MGSSpecINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSSpecINVO[]
	 */
	public MGSSpecINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSSpecINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] drpOffLmtTpCd = (JSPUtil.getParameter(request, prefix	+ "drp_off_lmt_tp_cd", length));
			String[] dppCvrgAmt = (JSPUtil.getParameter(request, prefix	+ "dpp_cvrg_amt", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] vndrLglEngNmEqspec = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm_eqspec", length));
			String[] lmsmAmt = (JSPUtil.getParameter(request, prefix	+ "lmsm_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] monDpcRtAmt = (JSPUtil.getParameter(request, prefix	+ "mon_dpc_rt_amt", length));
			String[] chssPayldWgt = (JSPUtil.getParameter(request, prefix	+ "chss_payld_wgt", length));
			String[] agmtIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_iss_ofc_cd", length));
			String[] drpOffLmtPrdCd = (JSPUtil.getParameter(request, prefix	+ "drp_off_lmt_prd_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] chssTtlDimHgt = (JSPUtil.getParameter(request, prefix	+ "chss_ttl_dim_hgt", length));
			String[] offhHndlRtAmt = (JSPUtil.getParameter(request, prefix	+ "offh_hndl_rt_amt", length));
			String[] eqLotNoEtc = (JSPUtil.getParameter(request, prefix	+ "eq_lot_no_etc", length));
			String[] toSerNo = (JSPUtil.getParameter(request, prefix	+ "to_ser_no", length));
			String[] chssTareWgt = (JSPUtil.getParameter(request, prefix	+ "chss_tare_wgt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agreementNo = (JSPUtil.getParameter(request, prefix	+ "agreement_no", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] creDtc = (JSPUtil.getParameter(request, prefix	+ "cre_dtc", length));
			String[] creDta = (JSPUtil.getParameter(request, prefix	+ "cre_dta", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqSpecNoTmp = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no_tmp", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] mgsetRange = (JSPUtil.getParameter(request, prefix	+ "mgset_range", length));
			String[] eqSpecNoEtc = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no_etc", length));
			String[] initDpcRtAmt = (JSPUtil.getParameter(request, prefix	+ "init_dpc_rt_amt", length));
			String[] vndrSeqAgree = (JSPUtil.getParameter(request, prefix	+ "vndr_seq_agree", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] eqLotIssDt = (JSPUtil.getParameter(request, prefix	+ "eq_lot_iss_dt", length));
			String[] lstVerFlg = (JSPUtil.getParameter(request, prefix	+ "lst_ver_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] fmSerNo = (JSPUtil.getParameter(request, prefix	+ "fm_ser_no", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] mgstFuelCapa = (JSPUtil.getParameter(request, prefix	+ "mgst_fuel_capa", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fincVndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "finc_vndr_lgl_eng_nm", length));
			String[] chssTtlDimLen = (JSPUtil.getParameter(request, prefix	+ "chss_ttl_dim_len", length));
			String[] eqPfxCd = (JSPUtil.getParameter(request, prefix	+ "eq_pfx_cd", length));
			String[] dppRtAmt = (JSPUtil.getParameter(request, prefix	+ "dpp_rt_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] fincVndrSeq = (JSPUtil.getParameter(request, prefix	+ "finc_vndr_seq", length));
			String[] onhHndlRtAmt = (JSPUtil.getParameter(request, prefix	+ "onh_hndl_rt_amt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] eqSpecNo = (JSPUtil.getParameter(request, prefix	+ "eq_spec_no", length));
			String[] vndrSeqEqspec = (JSPUtil.getParameter(request, prefix	+ "vndr_seq_eqspec", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] vndrLglEngNmAgree = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm_agree", length));
			String[] mgstVltgCapa = (JSPUtil.getParameter(request, prefix	+ "mgst_vltg_capa", length));
			String[] eqRntlTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_rntl_tp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eqLotNoTmp = (JSPUtil.getParameter(request, prefix	+ "eq_lot_no_tmp", length));
			String[] units = (JSPUtil.getParameter(request, prefix	+ "units", length));
			String[] drpOffLmtQty = (JSPUtil.getParameter(request, prefix	+ "drp_off_lmt_qty", length));
			String[] deYrmon = (JSPUtil.getParameter(request, prefix	+ "de_yrmon", length));
			String[] serialNo = (JSPUtil.getParameter(request, prefix	+ "serial_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] drpOffLmtRto = (JSPUtil.getParameter(request, prefix	+ "drp_off_lmt_rto", length));
			String[] eqLotNo = (JSPUtil.getParameter(request, prefix	+ "eq_lot_no", length));
			String[] maxDpcRtAmt = (JSPUtil.getParameter(request, prefix	+ "max_dpc_rt_amt", length));
			String[] certChassisNo = (JSPUtil.getParameter(request, prefix	+ "cert_chassis_no", length));
			String[] dppTpCd = (JSPUtil.getParameter(request, prefix	+ "dpp_tp_cd", length));
			String[] chssTtlDimWdt = (JSPUtil.getParameter(request, prefix	+ "chss_ttl_dim_wdt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSSpecINVO();
				if (drpOffLmtTpCd[i] != null)
					model.setDrpOffLmtTpCd(drpOffLmtTpCd[i]);
				if (dppCvrgAmt[i] != null)
					model.setDppCvrgAmt(dppCvrgAmt[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (vndrLglEngNmEqspec[i] != null)
					model.setVndrLglEngNmEqspec(vndrLglEngNmEqspec[i]);
				if (lmsmAmt[i] != null)
					model.setLmsmAmt(lmsmAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (monDpcRtAmt[i] != null)
					model.setMonDpcRtAmt(monDpcRtAmt[i]);
				if (chssPayldWgt[i] != null)
					model.setChssPayldWgt(chssPayldWgt[i]);
				if (agmtIssOfcCd[i] != null)
					model.setAgmtIssOfcCd(agmtIssOfcCd[i]);
				if (drpOffLmtPrdCd[i] != null)
					model.setDrpOffLmtPrdCd(drpOffLmtPrdCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (chssTtlDimHgt[i] != null)
					model.setChssTtlDimHgt(chssTtlDimHgt[i]);
				if (offhHndlRtAmt[i] != null)
					model.setOffhHndlRtAmt(offhHndlRtAmt[i]);
				if (eqLotNoEtc[i] != null)
					model.setEqLotNoEtc(eqLotNoEtc[i]);
				if (toSerNo[i] != null)
					model.setToSerNo(toSerNo[i]);
				if (chssTareWgt[i] != null)
					model.setChssTareWgt(chssTareWgt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agreementNo[i] != null)
					model.setAgreementNo(agreementNo[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (creDtc[i] != null)
					model.setCreDtc(creDtc[i]);
				if (creDta[i] != null)
					model.setCreDta(creDta[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqSpecNoTmp[i] != null)
					model.setEqSpecNoTmp(eqSpecNoTmp[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (mgsetRange[i] != null)
					model.setMgsetRange(mgsetRange[i]);
				if (eqSpecNoEtc[i] != null)
					model.setEqSpecNoEtc(eqSpecNoEtc[i]);
				if (initDpcRtAmt[i] != null)
					model.setInitDpcRtAmt(initDpcRtAmt[i]);
				if (vndrSeqAgree[i] != null)
					model.setVndrSeqAgree(vndrSeqAgree[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (eqLotIssDt[i] != null)
					model.setEqLotIssDt(eqLotIssDt[i]);
				if (lstVerFlg[i] != null)
					model.setLstVerFlg(lstVerFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (fmSerNo[i] != null)
					model.setFmSerNo(fmSerNo[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (mgstFuelCapa[i] != null)
					model.setMgstFuelCapa(mgstFuelCapa[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fincVndrLglEngNm[i] != null)
					model.setFincVndrLglEngNm(fincVndrLglEngNm[i]);
				if (chssTtlDimLen[i] != null)
					model.setChssTtlDimLen(chssTtlDimLen[i]);
				if (eqPfxCd[i] != null)
					model.setEqPfxCd(eqPfxCd[i]);
				if (dppRtAmt[i] != null)
					model.setDppRtAmt(dppRtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (fincVndrSeq[i] != null)
					model.setFincVndrSeq(fincVndrSeq[i]);
				if (onhHndlRtAmt[i] != null)
					model.setOnhHndlRtAmt(onhHndlRtAmt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (eqSpecNo[i] != null)
					model.setEqSpecNo(eqSpecNo[i]);
				if (vndrSeqEqspec[i] != null)
					model.setVndrSeqEqspec(vndrSeqEqspec[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (vndrLglEngNmAgree[i] != null)
					model.setVndrLglEngNmAgree(vndrLglEngNmAgree[i]);
				if (mgstVltgCapa[i] != null)
					model.setMgstVltgCapa(mgstVltgCapa[i]);
				if (eqRntlTpCd[i] != null)
					model.setEqRntlTpCd(eqRntlTpCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eqLotNoTmp[i] != null)
					model.setEqLotNoTmp(eqLotNoTmp[i]);
				if (units[i] != null)
					model.setUnits(units[i]);
				if (drpOffLmtQty[i] != null)
					model.setDrpOffLmtQty(drpOffLmtQty[i]);
				if (deYrmon[i] != null)
					model.setDeYrmon(deYrmon[i]);
				if (serialNo[i] != null)
					model.setSerialNo(serialNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (drpOffLmtRto[i] != null)
					model.setDrpOffLmtRto(drpOffLmtRto[i]);
				if (eqLotNo[i] != null)
					model.setEqLotNo(eqLotNo[i]);
				if (maxDpcRtAmt[i] != null)
					model.setMaxDpcRtAmt(maxDpcRtAmt[i]);
				if (certChassisNo[i] != null)
					model.setCertChassisNo(certChassisNo[i]);
				if (dppTpCd[i] != null)
					model.setDppTpCd(dppTpCd[i]);
				if (chssTtlDimWdt[i] != null)
					model.setChssTtlDimWdt(chssTtlDimWdt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSSpecINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSSpecINVO[]
	 */
	public MGSSpecINVO[] getMGSSpecINVOs(){
		MGSSpecINVO[] vos = (MGSSpecINVO[])models.toArray(new MGSSpecINVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.drpOffLmtTpCd = this.drpOffLmtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppCvrgAmt = this.dppCvrgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNmEqspec = this.vndrLglEngNmEqspec .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmsmAmt = this.lmsmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monDpcRtAmt = this.monDpcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPayldWgt = this.chssPayldWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtIssOfcCd = this.agmtIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtPrdCd = this.drpOffLmtPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTtlDimHgt = this.chssTtlDimHgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhHndlRtAmt = this.offhHndlRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLotNoEtc = this.eqLotNoEtc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSerNo = this.toSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTareWgt = this.chssTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agreementNo = this.agreementNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDtc = this.creDtc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDta = this.creDta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNoTmp = this.eqSpecNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgsetRange = this.mgsetRange .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNoEtc = this.eqSpecNoEtc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initDpcRtAmt = this.initDpcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeqAgree = this.vndrSeqAgree .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLotIssDt = this.eqLotIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstVerFlg = this.lstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmSerNo = this.fmSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstFuelCapa = this.mgstFuelCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincVndrLglEngNm = this.fincVndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTtlDimLen = this.chssTtlDimLen .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqPfxCd = this.eqPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppRtAmt = this.dppRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincVndrSeq = this.fincVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhHndlRtAmt = this.onhHndlRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqSpecNo = this.eqSpecNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeqEqspec = this.vndrSeqEqspec .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNmAgree = this.vndrLglEngNmAgree .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstVltgCapa = this.mgstVltgCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRntlTpCd = this.eqRntlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLotNoTmp = this.eqLotNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.units = this.units .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtQty = this.drpOffLmtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deYrmon = this.deYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serialNo = this.serialNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtRto = this.drpOffLmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLotNo = this.eqLotNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxDpcRtAmt = this.maxDpcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certChassisNo = this.certChassisNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppTpCd = this.dppTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssTtlDimWdt = this.chssTtlDimWdt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
