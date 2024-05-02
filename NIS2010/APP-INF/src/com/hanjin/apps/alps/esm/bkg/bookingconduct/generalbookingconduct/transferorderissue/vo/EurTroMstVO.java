/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EurTroMstVO.java
*@FileTitle : EurTroMstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 이진서
*@LastVersion : 1.0
* 2010.02.17 이진서 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo;


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
 * @author 이진서
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurTroMstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurTroMstVO> models = new ArrayList<EurTroMstVO>();
	
	/* Column Info */
	private String soDt = null;
	/* Column Info */
	private String cntrPkupYdCd = null;
	/* Column Info */
	private String eurTrnsTpCd = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String awkCgoSeq = null;
	/* Column Info */
	private String hlgTpCdOld = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pctlNo = null;
	/* Column Info */
	private String corrFlg = null;
	/* Column Info */
	private String cntrRtnYdCd = null;
	/* Column Info */
	private String cfmCurrCd = null;
	/* Column Info */
	private String cstmsClrNo = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String cntrRtnDtHhmi = null;
	/* Column Info */
	private String cgoWgt = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String soNo = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String cntrTpszCdOld = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String cfmHlgTpCd = null;
	/* Column Info */
	private String cfmAllInRtCd = null;
	/* Column Info */
	private String soOfcCd = null;
	/* Column Info */
	private String troProcCd = null;
	/* Column Info */
	private String cfmVatFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rqstSubSeq = null;
	/* Column Info */
	private String rcSeq = null;
	/* Column Info */
	private String cfmUpdDt = null;
	/* Column Info */
	private String cfmUsrNm = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String soCtyCd = null;
	/* Column Info */
	private String trnsRevAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String soUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String allInRtCd = null;
	/* Column Info */
	private String actCntCd = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String vatFlg = null;
	/* Column Info */
	private String spclInstrRmk = null;
	/* Column Info */
	private String hlgTpCd = null;
	/* Column Info */
	private String t1DocFlg = null;
	/* Column Info */
	private String cntrRtnDt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String troCmdtCd = null;
	/* Column Info */
	private String troSeq = null;
	/* Column Info */
	private String actCustSeq = null;
	/* Column Info */
	private String cfmRevAmt = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String bkgTrspMzdCd = null;
	/* Column Info */
	private String nonTrnsRevAmt = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String soUsrNm = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String cfmOfcCd = null;
	/* Column Info */
	private String cntrPkupDtHhmi = null;
	/* Column Info */
	private String cntrPkupDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String addRevAmt = null;
	/* Column Info */
	private String addRevChgCd = null;
	/* Column Info */
	private String splitRmk = null;
	/* Column Info */
	private String addRevRmk = null;
	/* Column Info */
	private String optmStsCd = null;
	/* Column Info */
	private String notOptmRsn  = null;
	/* Column Info */
	private String addRevAmt2 = null;
	/* Column Info */
	private String addRevChgCd2 = null;
	/* Column Info */
	private String addRevAmt3 = null;
	/* Column Info */
	private String addRevChgCd3 = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurTroMstVO() {}

	public EurTroMstVO(String ibflag, String pagerows, String soDt, String cntrPkupYdCd, String eurTrnsTpCd, String cxlFlg, String awkCgoSeq, String hlgTpCdOld, String pctlNo, String corrFlg, String cntrRtnYdCd, String cfmCurrCd, String cstmsClrNo, String cntrTpszCd, String wgtUtCd, String cfmUsrId, String updUsrId, String cgoWgt, String cntrRtnDtHhmi, String cntrPrtFlg, String soNo, String cntrTpszCdOld, String repCmdtNm, String cfmHlgTpCd, String cfmDt, String cfmAllInRtCd, String soOfcCd, String troProcCd, String cfmVatFlg, String creUsrId, String bkgNo, String rqstSubSeq, String rcSeq, String cfmUpdDt, String cfmUsrNm, String currCd, String soCtyCd, String trnsRevAmt, String creDt, String soUsrId, String allInRtCd, String actCntCd, String creOfcCd, String vatFlg, String spclInstrRmk, String hlgTpCd, String t1DocFlg, String cntrRtnDt, String updDt, String troCmdtCd, String troSeq, String cfmRevAmt, String actCustSeq, String corrNo, String bkgTrspMzdCd, String soUsrNm, String ioBndCd, String cfmFlg, String cfmOfcCd, String cntrPkupDtHhmi, String cntrNo, String cntrPkupDt, String repCmdtCd, String nonTrnsRevAmt, String addRevAmt, String addRevChgCd, String splitRmk, String addRevRmk, String optmStsCd, String notOptmRsn, String addRevChgCd2, String addRevChgCd3, String addRevRmk2, String addRevRmk3 ) {
		this.soDt = soDt;
		this.cntrPkupYdCd = cntrPkupYdCd;
		this.eurTrnsTpCd = eurTrnsTpCd;
		this.cxlFlg = cxlFlg;
		this.awkCgoSeq = awkCgoSeq;
		this.hlgTpCdOld = hlgTpCdOld;
		this.pagerows = pagerows;
		this.pctlNo = pctlNo;
		this.corrFlg = corrFlg;
		this.cntrRtnYdCd = cntrRtnYdCd;
		this.cfmCurrCd = cfmCurrCd;
		this.cstmsClrNo = cstmsClrNo;
		this.wgtUtCd = wgtUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.cfmUsrId = cfmUsrId;
		this.updUsrId = updUsrId;
		this.cntrRtnDtHhmi = cntrRtnDtHhmi;
		this.cgoWgt = cgoWgt;
		this.cntrPrtFlg = cntrPrtFlg;
		this.soNo = soNo;
		this.repCmdtNm = repCmdtNm;
		this.cntrTpszCdOld = cntrTpszCdOld;
		this.cfmDt = cfmDt;
		this.cfmHlgTpCd = cfmHlgTpCd;
		this.cfmAllInRtCd = cfmAllInRtCd;
		this.soOfcCd = soOfcCd;
		this.troProcCd = troProcCd;
		this.cfmVatFlg = cfmVatFlg;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.rqstSubSeq = rqstSubSeq;
		this.rcSeq = rcSeq;
		this.cfmUpdDt = cfmUpdDt;
		this.cfmUsrNm = cfmUsrNm;
		this.currCd = currCd;
		this.soCtyCd = soCtyCd;
		this.trnsRevAmt = trnsRevAmt;
		this.creDt = creDt;
		this.soUsrId = soUsrId;
		this.ibflag = ibflag;
		this.allInRtCd = allInRtCd;
		this.actCntCd = actCntCd;
		this.creOfcCd = creOfcCd;
		this.vatFlg = vatFlg;
		this.spclInstrRmk = spclInstrRmk;
		this.hlgTpCd = hlgTpCd;
		this.t1DocFlg = t1DocFlg;
		this.cntrRtnDt = cntrRtnDt;
		this.updDt = updDt;
		this.troCmdtCd = troCmdtCd;
		this.troSeq = troSeq;
		this.actCustSeq = actCustSeq;
		this.cfmRevAmt = cfmRevAmt;
		this.corrNo = corrNo;
		this.bkgTrspMzdCd = bkgTrspMzdCd;
		this.nonTrnsRevAmt = nonTrnsRevAmt;
		this.ioBndCd = ioBndCd;
		this.soUsrNm = soUsrNm;
		this.cfmFlg = cfmFlg;
		this.cfmOfcCd = cfmOfcCd;
		this.cntrPkupDtHhmi = cntrPkupDtHhmi;
		this.cntrPkupDt = cntrPkupDt;
		this.cntrNo = cntrNo;
		this.repCmdtCd = repCmdtCd;
		this.addRevAmt = addRevAmt;
		this.addRevChgCd = addRevChgCd;
		this.splitRmk = splitRmk;
		this.addRevRmk = addRevRmk;
		this.optmStsCd = optmStsCd;
		this.notOptmRsn = notOptmRsn;
		this.addRevAmt2 = addRevAmt2;
		this.addRevChgCd2 = addRevChgCd2;
		this.addRevAmt3 = addRevAmt3;
		this.addRevChgCd3 = addRevChgCd3;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("so_dt", getSoDt());
		this.hashColumns.put("cntr_pkup_yd_cd", getCntrPkupYdCd());
		this.hashColumns.put("eur_trns_tp_cd", getEurTrnsTpCd());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("awk_cgo_seq", getAwkCgoSeq());
		this.hashColumns.put("hlg_tp_cd_old", getHlgTpCdOld());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pctl_no", getPctlNo());
		this.hashColumns.put("corr_flg", getCorrFlg());
		this.hashColumns.put("cntr_rtn_yd_cd", getCntrRtnYdCd());
		this.hashColumns.put("cfm_curr_cd", getCfmCurrCd());
		this.hashColumns.put("cstms_clr_no", getCstmsClrNo());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("cntr_rtn_dt_hhmi", getCntrRtnDtHhmi());
		this.hashColumns.put("cgo_wgt", getCgoWgt());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("so_no", getSoNo());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("cntr_tpsz_cd_old", getCntrTpszCdOld());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("cfm_hlg_tp_cd", getCfmHlgTpCd());
		this.hashColumns.put("cfm_all_in_rt_cd", getCfmAllInRtCd());
		this.hashColumns.put("so_ofc_cd", getSoOfcCd());
		this.hashColumns.put("tro_proc_cd", getTroProcCd());
		this.hashColumns.put("cfm_vat_flg", getCfmVatFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rqst_sub_seq", getRqstSubSeq());
		this.hashColumns.put("rc_seq", getRcSeq());
		this.hashColumns.put("cfm_upd_dt", getCfmUpdDt());
		this.hashColumns.put("cfm_usr_nm", getCfmUsrNm());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("so_cty_cd", getSoCtyCd());
		this.hashColumns.put("trns_rev_amt", getTrnsRevAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("so_usr_id", getSoUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("all_in_rt_cd", getAllInRtCd());
		this.hashColumns.put("act_cnt_cd", getActCntCd());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("vat_flg", getVatFlg());
		this.hashColumns.put("spcl_instr_rmk", getSpclInstrRmk());
		this.hashColumns.put("hlg_tp_cd", getHlgTpCd());
		this.hashColumns.put("t1_doc_flg", getT1DocFlg());
		this.hashColumns.put("cntr_rtn_dt", getCntrRtnDt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("tro_cmdt_cd", getTroCmdtCd());
		this.hashColumns.put("tro_seq", getTroSeq());
		this.hashColumns.put("act_cust_seq", getActCustSeq());
		this.hashColumns.put("cfm_rev_amt", getCfmRevAmt());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("bkg_trsp_mzd_cd", getBkgTrspMzdCd());
		this.hashColumns.put("non_trns_rev_amt", getNonTrnsRevAmt());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("so_usr_nm", getSoUsrNm());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("cfm_ofc_cd", getCfmOfcCd());
		this.hashColumns.put("cntr_pkup_dt_hhmi", getCntrPkupDtHhmi());
		this.hashColumns.put("cntr_pkup_dt", getCntrPkupDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("add_rev_amt", getAddRevAmt());
		this.hashColumns.put("add_rev_chg_cd", getAddRevChgCd());
		this.hashColumns.put("split_rmk", getSplitRmk());
		this.hashColumns.put("add_rev_rmk", getAddRevRmk());
		this.hashColumns.put("optm_sts_cd", getOptmStsCd());
		this.hashColumns.put("not_optm_rsn", getNotOptmRsn());
		this.hashColumns.put("add_rev_amt2", getAddRevAmt2());
		this.hashColumns.put("add_rev_chg_cd2", getAddRevChgCd2());
		this.hashColumns.put("add_rev_amt3", getAddRevAmt3());
		this.hashColumns.put("add_rev_chg_cd3", getAddRevChgCd3());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("so_dt", "soDt");
		this.hashFields.put("cntr_pkup_yd_cd", "cntrPkupYdCd");
		this.hashFields.put("eur_trns_tp_cd", "eurTrnsTpCd");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("awk_cgo_seq", "awkCgoSeq");
		this.hashFields.put("hlg_tp_cd_old", "hlgTpCdOld");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pctl_no", "pctlNo");
		this.hashFields.put("corr_flg", "corrFlg");
		this.hashFields.put("cntr_rtn_yd_cd", "cntrRtnYdCd");
		this.hashFields.put("cfm_curr_cd", "cfmCurrCd");
		this.hashFields.put("cstms_clr_no", "cstmsClrNo");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_rtn_dt_hhmi", "cntrRtnDtHhmi");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("so_no", "soNo");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("cntr_tpsz_cd_old", "cntrTpszCdOld");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("cfm_hlg_tp_cd", "cfmHlgTpCd");
		this.hashFields.put("cfm_all_in_rt_cd", "cfmAllInRtCd");
		this.hashFields.put("so_ofc_cd", "soOfcCd");
		this.hashFields.put("tro_proc_cd", "troProcCd");
		this.hashFields.put("cfm_vat_flg", "cfmVatFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rqst_sub_seq", "rqstSubSeq");
		this.hashFields.put("rc_seq", "rcSeq");
		this.hashFields.put("cfm_upd_dt", "cfmUpdDt");
		this.hashFields.put("cfm_usr_nm", "cfmUsrNm");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("so_cty_cd", "soCtyCd");
		this.hashFields.put("trns_rev_amt", "trnsRevAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("so_usr_id", "soUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("all_in_rt_cd", "allInRtCd");
		this.hashFields.put("act_cnt_cd", "actCntCd");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("vat_flg", "vatFlg");
		this.hashFields.put("spcl_instr_rmk", "spclInstrRmk");
		this.hashFields.put("hlg_tp_cd", "hlgTpCd");
		this.hashFields.put("t1_doc_flg", "t1DocFlg");
		this.hashFields.put("cntr_rtn_dt", "cntrRtnDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("tro_cmdt_cd", "troCmdtCd");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("cfm_rev_amt", "cfmRevAmt");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("bkg_trsp_mzd_cd", "bkgTrspMzdCd");
		this.hashFields.put("non_trns_rev_amt", "nonTrnsRevAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("so_usr_nm", "soUsrNm");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("cfm_ofc_cd", "cfmOfcCd");
		this.hashFields.put("cntr_pkup_dt_hhmi", "cntrPkupDtHhmi");
		this.hashFields.put("cntr_pkup_dt", "cntrPkupDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("add_rev_amt", "addRevAmt");
		this.hashFields.put("add_rev_chg_cd", "addRevChgCd");
		this.hashFields.put("split_rmk", "splitRmk");
		this.hashFields.put("add_rev_rmk", "addRevRmk");
		this.hashFields.put("optm_sts_cd", "optmStsCd");
		this.hashFields.put("not_optm_rsn", "notOptmRsn");
		this.hashFields.put("add_rev_amt2", "addRevAmt2");
		this.hashFields.put("add_rev_chg_cd2", "addRevChgCd2");
		this.hashFields.put("add_rev_amt3", "addRevAmt3");
		this.hashFields.put("add_rev_chg_cd3", "addRevChgCd3");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return splitRmk
	 */
	public String getSplitRmk() {
		return this.splitRmk;
	}
	
	
	
	/**
	 * Column Info
	 * @param splitRmk
	 */
	public void setSplitRmk(String splitRmk) {
		this.splitRmk = splitRmk;
	}
	
	/**
	 * Column Info
	 * @return soDt
	 */
	public String getSoDt() {
		return this.soDt;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupYdCd
	 */
	public String getCntrPkupYdCd() {
		return this.cntrPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return eurTrnsTpCd
	 */
	public String getEurTrnsTpCd() {
		return this.eurTrnsTpCd;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
	}
	
	/**
	 * Column Info
	 * @return awkCgoSeq
	 */
	public String getAwkCgoSeq() {
		return this.awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return hlgTpCdOld
	 */
	public String getHlgTpCdOld() {
		return this.hlgTpCdOld;
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
	 * @return pctlNo
	 */
	public String getPctlNo() {
		return this.pctlNo;
	}
	
	/**
	 * Column Info
	 * @return corrFlg
	 */
	public String getCorrFlg() {
		return this.corrFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrRtnYdCd
	 */
	public String getCntrRtnYdCd() {
		return this.cntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @return cfmCurrCd
	 */
	public String getCfmCurrCd() {
		return this.cfmCurrCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsClrNo
	 */
	public String getCstmsClrNo() {
		return this.cstmsClrNo;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
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
	 * @return cntrRtnDtHhmi
	 */
	public String getCntrRtnDtHhmi() {
		return this.cntrRtnDtHhmi;
	}
	
	/**
	 * Column Info
	 * @return cgoWgt
	 */
	public String getCgoWgt() {
		return this.cgoWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
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
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCdOld
	 */
	public String getCntrTpszCdOld() {
		return this.cntrTpszCdOld;
	}
	
	/**
	 * Column Info
	 * @return cfmDt
	 */
	public String getCfmDt() {
		return this.cfmDt;
	}
	
	/**
	 * Column Info
	 * @return cfmHlgTpCd
	 */
	public String getCfmHlgTpCd() {
		return this.cfmHlgTpCd;
	}
	
	/**
	 * Column Info
	 * @return cfmAllInRtCd
	 */
	public String getCfmAllInRtCd() {
		return this.cfmAllInRtCd;
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
	 * @return troProcCd
	 */
	public String getTroProcCd() {
		return this.troProcCd;
	}
	
	/**
	 * Column Info
	 * @return cfmVatFlg
	 */
	public String getCfmVatFlg() {
		return this.cfmVatFlg;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return rqstSubSeq
	 */
	public String getRqstSubSeq() {
		return this.rqstSubSeq;
	}
	
	/**
	 * Column Info
	 * @return rcSeq
	 */
	public String getRcSeq() {
		return this.rcSeq;
	}
	
	/**
	 * Column Info
	 * @return cfmUpdDt
	 */
	public String getCfmUpdDt() {
		return this.cfmUpdDt;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrNm
	 */
	public String getCfmUsrNm() {
		return this.cfmUsrNm;
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
	 * @return soCtyCd
	 */
	public String getSoCtyCd() {
		return this.soCtyCd;
	}
	
	/**
	 * Column Info
	 * @return trnsRevAmt
	 */
	public String getTrnsRevAmt() {
		return this.trnsRevAmt;
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
	 * @return soUsrId
	 */
	public String getSoUsrId() {
		return this.soUsrId;
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
	 * @return allInRtCd
	 */
	public String getAllInRtCd() {
		return this.allInRtCd;
	}
	
	/**
	 * Column Info
	 * @return actCntCd
	 */
	public String getActCntCd() {
		return this.actCntCd;
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
	 * @return vatFlg
	 */
	public String getVatFlg() {
		return this.vatFlg;
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
	 * @return hlgTpCd
	 */
	public String getHlgTpCd() {
		return this.hlgTpCd;
	}
	
	/**
	 * Column Info
	 * @return t1DocFlg
	 */
	public String getT1DocFlg() {
		return this.t1DocFlg;
	}
	
	/**
	 * Column Info
	 * @return cntrRtnDt
	 */
	public String getCntrRtnDt() {
		return this.cntrRtnDt;
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
	 * @return troCmdtCd
	 */
	public String getTroCmdtCd() {
		return this.troCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return troSeq
	 */
	public String getTroSeq() {
		return this.troSeq;
	}
	
	/**
	 * Column Info
	 * @return actCustSeq
	 */
	public String getActCustSeq() {
		return this.actCustSeq;
	}
	
	/**
	 * Column Info
	 * @return cfmRevAmt
	 */
	public String getCfmRevAmt() {
		return this.cfmRevAmt;
	}
	
	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
	}
	
	/**
	 * Column Info
	 * @return bkgTrspMzdCd
	 */
	public String getBkgTrspMzdCd() {
		return this.bkgTrspMzdCd;
	}
	
	/**
	 * Column Info
	 * @return nonTrnsRevAmt
	 */
	public String getNonTrnsRevAmt() {
		return this.nonTrnsRevAmt;
	}
	
	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
	}
	
	/**
	 * Column Info
	 * @return cfmOfcCd
	 */
	public String getCfmOfcCd() {
		return this.cfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupDtHhmi
	 */
	public String getCntrPkupDtHhmi() {
		return this.cntrPkupDtHhmi;
	}
	
	/**
	 * Column Info
	 * @return cntrPkupDt
	 */
	public String getCntrPkupDt() {
		return this.cntrPkupDt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return repCmdtCd
	 */
	public String getRepCmdtCd() {
		return this.repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @return addRevAmt
	 */
	public String getAddRevAmt() {
		return this.addRevAmt;
	}
	
	/**
	 * Column Info
	 * @return addRevChgCd
	 */
	public String getAddRevChgCd() {
		return this.addRevChgCd;
	}
	
	/**
	 * Column Info
	 * @return addRevAmt2
	 */
	public String getAddRevAmt2() {
		return this.addRevAmt2;
	}
	
	/**
	 * Column Info
	 * @return addRevChgCd2
	 */
	public String getAddRevChgCd2() {
		return this.addRevChgCd2;
	}
	
	
	/**
	 * Column Info
	 * @return addRevAmt3
	 */
	public String getAddRevAmt3() {
		return this.addRevAmt3;
	}
	
	/**
	 * Column Info
	 * @return addRevChgCd3
	 */
	public String getAddRevChgCd3() {
		return this.addRevChgCd3;
	}

	/**
	 * Column Info
	 * @return addRevRmk
	 */
	public String getAddRevRmk() {
		return addRevRmk;
	}
	
	/**
	 * Column Info
	 * @return optmStsCd
	 */
	public String getOptmStsCd() {
		return optmStsCd;
	}
	
	/**
	 * Column Info
	 * @return notOptmRsn
	 */
	public String getNotOptmRsn() {
		return notOptmRsn;
	}

	/**
	 * Column Info
	 * @param soDt
	 */
	public void setSoDt(String soDt) {
		this.soDt = soDt;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupYdCd
	 */
	public void setCntrPkupYdCd(String cntrPkupYdCd) {
		this.cntrPkupYdCd = cntrPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param eurTrnsTpCd
	 */
	public void setEurTrnsTpCd(String eurTrnsTpCd) {
		this.eurTrnsTpCd = eurTrnsTpCd;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
	}
	
	/**
	 * Column Info
	 * @param awkCgoSeq
	 */
	public void setAwkCgoSeq(String awkCgoSeq) {
		this.awkCgoSeq = awkCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param hlgTpCdOld
	 */
	public void setHlgTpCdOld(String hlgTpCdOld) {
		this.hlgTpCdOld = hlgTpCdOld;
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
	 * @param pctlNo
	 */
	public void setPctlNo(String pctlNo) {
		this.pctlNo = pctlNo;
	}
	
	/**
	 * Column Info
	 * @param corrFlg
	 */
	public void setCorrFlg(String corrFlg) {
		this.corrFlg = corrFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrRtnYdCd
	 */
	public void setCntrRtnYdCd(String cntrRtnYdCd) {
		this.cntrRtnYdCd = cntrRtnYdCd;
	}
	
	/**
	 * Column Info
	 * @param cfmCurrCd
	 */
	public void setCfmCurrCd(String cfmCurrCd) {
		this.cfmCurrCd = cfmCurrCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsClrNo
	 */
	public void setCstmsClrNo(String cstmsClrNo) {
		this.cstmsClrNo = cstmsClrNo;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
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
	 * @param cntrRtnDtHhmi
	 */
	public void setCntrRtnDtHhmi(String cntrRtnDtHhmi) {
		this.cntrRtnDtHhmi = cntrRtnDtHhmi;
	}
	
	/**
	 * Column Info
	 * @param cgoWgt
	 */
	public void setCgoWgt(String cgoWgt) {
		this.cgoWgt = cgoWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
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
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCdOld
	 */
	public void setCntrTpszCdOld(String cntrTpszCdOld) {
		this.cntrTpszCdOld = cntrTpszCdOld;
	}
	
	/**
	 * Column Info
	 * @param cfmDt
	 */
	public void setCfmDt(String cfmDt) {
		this.cfmDt = cfmDt;
	}
	
	/**
	 * Column Info
	 * @param cfmHlgTpCd
	 */
	public void setCfmHlgTpCd(String cfmHlgTpCd) {
		this.cfmHlgTpCd = cfmHlgTpCd;
	}
	
	/**
	 * Column Info
	 * @param cfmAllInRtCd
	 */
	public void setCfmAllInRtCd(String cfmAllInRtCd) {
		this.cfmAllInRtCd = cfmAllInRtCd;
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
	 * @param troProcCd
	 */
	public void setTroProcCd(String troProcCd) {
		this.troProcCd = troProcCd;
	}
	
	/**
	 * Column Info
	 * @param cfmVatFlg
	 */
	public void setCfmVatFlg(String cfmVatFlg) {
		this.cfmVatFlg = cfmVatFlg;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param rqstSubSeq
	 */
	public void setRqstSubSeq(String rqstSubSeq) {
		this.rqstSubSeq = rqstSubSeq;
	}
	
	/**
	 * Column Info
	 * @param rcSeq
	 */
	public void setRcSeq(String rcSeq) {
		this.rcSeq = rcSeq;
	}
	
	/**
	 * Column Info
	 * @param cfmUpdDt
	 */
	public void setCfmUpdDt(String cfmUpdDt) {
		this.cfmUpdDt = cfmUpdDt;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrNm
	 */
	public void setCfmUsrNm(String cfmUsrNm) {
		this.cfmUsrNm = cfmUsrNm;
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
	 * @param soCtyCd
	 */
	public void setSoCtyCd(String soCtyCd) {
		this.soCtyCd = soCtyCd;
	}
	
	/**
	 * Column Info
	 * @param trnsRevAmt
	 */
	public void setTrnsRevAmt(String trnsRevAmt) {
		this.trnsRevAmt = trnsRevAmt;
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
	 * @param soUsrId
	 */
	public void setSoUsrId(String soUsrId) {
		this.soUsrId = soUsrId;
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
	 * @param allInRtCd
	 */
	public void setAllInRtCd(String allInRtCd) {
		this.allInRtCd = allInRtCd;
	}
	
	/**
	 * Column Info
	 * @param actCntCd
	 */
	public void setActCntCd(String actCntCd) {
		this.actCntCd = actCntCd;
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
	 * @param vatFlg
	 */
	public void setVatFlg(String vatFlg) {
		this.vatFlg = vatFlg;
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
	 * @param hlgTpCd
	 */
	public void setHlgTpCd(String hlgTpCd) {
		this.hlgTpCd = hlgTpCd;
	}
	
	/**
	 * Column Info
	 * @param t1DocFlg
	 */
	public void setT1DocFlg(String t1DocFlg) {
		this.t1DocFlg = t1DocFlg;
	}
	
	/**
	 * Column Info
	 * @param cntrRtnDt
	 */
	public void setCntrRtnDt(String cntrRtnDt) {
		this.cntrRtnDt = cntrRtnDt;
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
	 * @param troCmdtCd
	 */
	public void setTroCmdtCd(String troCmdtCd) {
		this.troCmdtCd = troCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param troSeq
	 */
	public void setTroSeq(String troSeq) {
		this.troSeq = troSeq;
	}
	
	/**
	 * Column Info
	 * @param actCustSeq
	 */
	public void setActCustSeq(String actCustSeq) {
		this.actCustSeq = actCustSeq;
	}
	
	/**
	 * Column Info
	 * @param cfmRevAmt
	 */
	public void setCfmRevAmt(String cfmRevAmt) {
		this.cfmRevAmt = cfmRevAmt;
	}
	
	/**
	 * Column Info
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	
	/**
	 * Column Info
	 * @param bkgTrspMzdCd
	 */
	public void setBkgTrspMzdCd(String bkgTrspMzdCd) {
		this.bkgTrspMzdCd = bkgTrspMzdCd;
	}
	
	/**
	 * Column Info
	 * @param nonTrnsRevAmt
	 */
	public void setNonTrnsRevAmt(String nonTrnsRevAmt) {
		this.nonTrnsRevAmt = nonTrnsRevAmt;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
	}
	
	/**
	 * Column Info
	 * @param cfmOfcCd
	 */
	public void setCfmOfcCd(String cfmOfcCd) {
		this.cfmOfcCd = cfmOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupDtHhmi
	 */
	public void setCntrPkupDtHhmi(String cntrPkupDtHhmi) {
		this.cntrPkupDtHhmi = cntrPkupDtHhmi;
	}
	
	/**
	 * Column Info
	 * @param cntrPkupDt
	 */
	public void setCntrPkupDt(String cntrPkupDt) {
		this.cntrPkupDt = cntrPkupDt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param repCmdtCd
	 */
	public void setRepCmdtCd(String repCmdtCd) {
		this.repCmdtCd = repCmdtCd;
	}
	
	/**
	 * Column Info
	 * @param addRevAmt
	 */
	public void setAddRevAmt(String addRevAmt) {
		this.addRevAmt = addRevAmt;
	}
	
	/**
	 * Column Info
	 * @param addRevChgCd
	 */
	public void setAddRevChgCd(String addRevChgCd) {
		this.addRevChgCd = addRevChgCd;
	}

	/**
	 * Column Info
	 * @param addRevAmt2
	 */
	public void setAddRevAmt2(String addRevAmt2) {
		this.addRevAmt2 = addRevAmt2;
	}
	
	/**
	 * Column Info
	 * @param addRevChgCd3
	 */
	public void setAddRevChgCd3(String addRevChgCd3) {
		this.addRevChgCd3 = addRevChgCd3;
	}
	/**
	 * Column Info
	 * @param addRevAmt3
	 */
	public void setAddRevAmt3(String addRevAmt3) {
		this.addRevAmt3 = addRevAmt3;
	}
	
	/**
	 * Column Info
	 * @param addRevChgCd2
	 */
	public void setAddRevChgCd2(String addRevChgCd2) {
		this.addRevChgCd2 = addRevChgCd2;
	}
	/**
	 * Column Info
	 * @param optmStsCd
	 */
	public void setOptmStsCd(String optmStsCd) {
		this.optmStsCd = optmStsCd;
	}
	
	/**
	 * Column Info
	 * @param notOptmRsn
	 */
	public void setNotOptmRsn(String notOptmRsn) {
		this.notOptmRsn = notOptmRsn;
	}

	/**
	 * Column Info
	 * @param addRevRmk
	 */
	public void setAddRevRmk(String addRevRmk) {
		this.addRevRmk = addRevRmk;
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
		setSoDt(JSPUtil.getParameter(request, prefix + "so_dt", ""));
		setCntrPkupYdCd(JSPUtil.getParameter(request, prefix + "cntr_pkup_yd_cd", ""));
		setEurTrnsTpCd(JSPUtil.getParameter(request, prefix + "eur_trns_tp_cd", ""));
		setCxlFlg(JSPUtil.getParameter(request, prefix + "cxl_flg", ""));
		setAwkCgoSeq(JSPUtil.getParameter(request, prefix + "awk_cgo_seq", ""));
		setHlgTpCdOld(JSPUtil.getParameter(request, prefix + "hlg_tp_cd_old", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPctlNo(JSPUtil.getParameter(request, prefix + "pctl_no", ""));
		setCorrFlg(JSPUtil.getParameter(request, prefix + "corr_flg", ""));
		setCntrRtnYdCd(JSPUtil.getParameter(request, prefix + "cntr_rtn_yd_cd", ""));
		setCfmCurrCd(JSPUtil.getParameter(request, prefix + "cfm_curr_cd", ""));
		setCstmsClrNo(JSPUtil.getParameter(request, prefix + "cstms_clr_no", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setCntrRtnDtHhmi(JSPUtil.getParameter(request, prefix + "cntr_rtn_dt_hhmi", ""));
		setCgoWgt(JSPUtil.getParameter(request, prefix + "cgo_wgt", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, prefix + "cntr_prt_flg", ""));
		setSoNo(JSPUtil.getParameter(request, prefix + "so_no", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, prefix + "rep_cmdt_nm", ""));
		setCntrTpszCdOld(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd_old", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setCfmHlgTpCd(JSPUtil.getParameter(request, prefix + "cfm_hlg_tp_cd", ""));
		setCfmAllInRtCd(JSPUtil.getParameter(request, prefix + "cfm_all_in_rt_cd", ""));
		setSoOfcCd(JSPUtil.getParameter(request, prefix + "so_ofc_cd", ""));
		setTroProcCd(JSPUtil.getParameter(request, prefix + "tro_proc_cd", ""));
		setCfmVatFlg(JSPUtil.getParameter(request, prefix + "cfm_vat_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRqstSubSeq(JSPUtil.getParameter(request, prefix + "rqst_sub_seq", ""));
		setRcSeq(JSPUtil.getParameter(request, prefix + "rc_seq", ""));
		setCfmUpdDt(JSPUtil.getParameter(request, prefix + "cfm_upd_dt", ""));
		setCfmUsrNm(JSPUtil.getParameter(request, prefix + "cfm_usr_nm", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSoCtyCd(JSPUtil.getParameter(request, prefix + "so_cty_cd", ""));
		setTrnsRevAmt(JSPUtil.getParameter(request, prefix + "trns_rev_amt", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSoUsrId(JSPUtil.getParameter(request, prefix + "so_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAllInRtCd(JSPUtil.getParameter(request, prefix + "all_in_rt_cd", ""));
		setActCntCd(JSPUtil.getParameter(request, prefix + "act_cnt_cd", ""));
		setCreOfcCd(JSPUtil.getParameter(request, prefix + "cre_ofc_cd", ""));
		setVatFlg(JSPUtil.getParameter(request, prefix + "vat_flg", ""));
		setSpclInstrRmk(JSPUtil.getParameter(request, prefix + "spcl_instr_rmk", ""));
		setHlgTpCd(JSPUtil.getParameter(request, prefix + "hlg_tp_cd", ""));
		setT1DocFlg(JSPUtil.getParameter(request, prefix + "t1_doc_flg", ""));
		setCntrRtnDt(JSPUtil.getParameter(request, prefix + "cntr_rtn_dt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTroCmdtCd(JSPUtil.getParameter(request, prefix + "tro_cmdt_cd", ""));
		setTroSeq(JSPUtil.getParameter(request, prefix + "tro_seq", ""));
		setActCustSeq(JSPUtil.getParameter(request, prefix + "act_cust_seq", ""));
		setCfmRevAmt(JSPUtil.getParameter(request, prefix + "cfm_rev_amt", ""));
		setCorrNo(JSPUtil.getParameter(request, prefix + "corr_no", ""));
		setBkgTrspMzdCd(JSPUtil.getParameter(request, prefix + "bkg_trsp_mzd_cd", ""));
		setNonTrnsRevAmt(JSPUtil.getParameter(request, prefix + "non_trns_rev_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
		setSoUsrNm(JSPUtil.getParameter(request, prefix + "so_usr_nm", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setCfmOfcCd(JSPUtil.getParameter(request, prefix + "cfm_ofc_cd", ""));
		setCntrPkupDtHhmi(JSPUtil.getParameter(request, prefix + "cntr_pkup_dt_hhmi", ""));
		setCntrPkupDt(JSPUtil.getParameter(request, prefix + "cntr_pkup_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, prefix + "rep_cmdt_cd", ""));
		setAddRevAmt(JSPUtil.getParameter(request, prefix + "add_rev_amt", ""));
		setAddRevChgCd(JSPUtil.getParameter(request, prefix + "add_rev_chg_cd", ""));
		setSplitRmk(JSPUtil.getParameter(request, prefix + "split_rmk", ""));
		setAddRevRmk(JSPUtil.getParameter(request, prefix + "add_rev_rmk", ""));
		setOptmStsCd(JSPUtil.getParameter(request, prefix + "optm_sts_cd", ""));
		setNotOptmRsn(JSPUtil.getParameter(request, prefix + "not_optm_rsn", ""));
		
		setAddRevAmt2(JSPUtil.getParameter(request, prefix + "add_rev_amt2", ""));
		setAddRevChgCd2(JSPUtil.getParameter(request, prefix + "add_rev_chg_cd2", ""));
		setAddRevAmt3(JSPUtil.getParameter(request, prefix + "add_rev_amt3", ""));
		setAddRevChgCd3(JSPUtil.getParameter(request, prefix + "add_rev_chg_cd3", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurTroMstVO[]
	 */
	public EurTroMstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurTroMstVO[]
	 */
	public EurTroMstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurTroMstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] soDt = (JSPUtil.getParameter(request, prefix	+ "so_dt", length));
			String[] cntrPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_yd_cd", length));
			String[] eurTrnsTpCd = (JSPUtil.getParameter(request, prefix	+ "eur_trns_tp_cd", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] awkCgoSeq = (JSPUtil.getParameter(request, prefix	+ "awk_cgo_seq", length));
			String[] hlgTpCdOld = (JSPUtil.getParameter(request, prefix	+ "hlg_tp_cd_old", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pctlNo = (JSPUtil.getParameter(request, prefix	+ "pctl_no", length));
			String[] corrFlg = (JSPUtil.getParameter(request, prefix	+ "corr_flg", length));
			String[] cntrRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_yd_cd", length));
			String[] cfmCurrCd = (JSPUtil.getParameter(request, prefix	+ "cfm_curr_cd", length));
			String[] cstmsClrNo = (JSPUtil.getParameter(request, prefix	+ "cstms_clr_no", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] cntrRtnDtHhmi = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_dt_hhmi", length));
			String[] cgoWgt = (JSPUtil.getParameter(request, prefix	+ "cgo_wgt", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] soNo = (JSPUtil.getParameter(request, prefix	+ "so_no", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] cntrTpszCdOld = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd_old", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] cfmHlgTpCd = (JSPUtil.getParameter(request, prefix	+ "cfm_hlg_tp_cd", length));
			String[] cfmAllInRtCd = (JSPUtil.getParameter(request, prefix	+ "cfm_all_in_rt_cd", length));
			String[] soOfcCd = (JSPUtil.getParameter(request, prefix	+ "so_ofc_cd", length));
			String[] troProcCd = (JSPUtil.getParameter(request, prefix	+ "tro_proc_cd", length));
			String[] cfmVatFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_vat_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rqstSubSeq = (JSPUtil.getParameter(request, prefix	+ "rqst_sub_seq", length));
			String[] rcSeq = (JSPUtil.getParameter(request, prefix	+ "rc_seq", length));
			String[] cfmUpdDt = (JSPUtil.getParameter(request, prefix	+ "cfm_upd_dt", length));
			String[] cfmUsrNm = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_nm", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] soCtyCd = (JSPUtil.getParameter(request, prefix	+ "so_cty_cd", length));
			String[] trnsRevAmt = (JSPUtil.getParameter(request, prefix	+ "trns_rev_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] soUsrId = (JSPUtil.getParameter(request, prefix	+ "so_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] allInRtCd = (JSPUtil.getParameter(request, prefix	+ "all_in_rt_cd", length));
			String[] actCntCd = (JSPUtil.getParameter(request, prefix	+ "act_cnt_cd", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] vatFlg = (JSPUtil.getParameter(request, prefix	+ "vat_flg", length));
			String[] spclInstrRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_instr_rmk", length));
			String[] hlgTpCd = (JSPUtil.getParameter(request, prefix	+ "hlg_tp_cd", length));
			String[] t1DocFlg = (JSPUtil.getParameter(request, prefix	+ "t1_doc_flg", length));
			String[] cntrRtnDt = (JSPUtil.getParameter(request, prefix	+ "cntr_rtn_dt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] troCmdtCd = (JSPUtil.getParameter(request, prefix	+ "tro_cmdt_cd", length));
			String[] troSeq = (JSPUtil.getParameter(request, prefix	+ "tro_seq", length));
			String[] actCustSeq = (JSPUtil.getParameter(request, prefix	+ "act_cust_seq", length));
			String[] cfmRevAmt = (JSPUtil.getParameter(request, prefix	+ "cfm_rev_amt", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] bkgTrspMzdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_trsp_mzd_cd", length));
			String[] nonTrnsRevAmt = (JSPUtil.getParameter(request, prefix	+ "non_trns_rev_amt", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] soUsrNm = (JSPUtil.getParameter(request, prefix	+ "so_usr_nm", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] cfmOfcCd = (JSPUtil.getParameter(request, prefix	+ "cfm_ofc_cd", length));
			String[] cntrPkupDtHhmi = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_dt_hhmi", length));
			String[] cntrPkupDt = (JSPUtil.getParameter(request, prefix	+ "cntr_pkup_dt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] addRevAmt = (JSPUtil.getParameter(request, prefix	+ "add_rev_amt", length));
			String[] addRevChgCd = (JSPUtil.getParameter(request, prefix	+ "add_rev_chg_cd", length));
			String[] splitRmk = (JSPUtil.getParameter(request, prefix	+ "split_rmk", length));
			String[] addRevRmk = (JSPUtil.getParameter(request, prefix	+ "add_rev_rmk", length));
			String[] optmStsCd = (JSPUtil.getParameter(request, prefix	+ "optm_sts_cd", length));
			String[] notOptmRsn = (JSPUtil.getParameter(request, prefix	+ "not_optm_rsn", length));
			String[] addRevAmt2 = (JSPUtil.getParameter(request, prefix	+ "add_rev_amt2", length));
			String[] addRevChgCd2 = (JSPUtil.getParameter(request, prefix	+ "add_rev_chg_cd2", length));
			String[] addRevAmt3 = (JSPUtil.getParameter(request, prefix	+ "add_rev_amt3", length));
			String[] addRevChgCd3 = (JSPUtil.getParameter(request, prefix	+ "add_rev_chg_cd3", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurTroMstVO();
				if (soDt[i] != null)
					model.setSoDt(soDt[i]);
				if (cntrPkupYdCd[i] != null)
					model.setCntrPkupYdCd(cntrPkupYdCd[i]);
				if (eurTrnsTpCd[i] != null)
					model.setEurTrnsTpCd(eurTrnsTpCd[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (awkCgoSeq[i] != null)
					model.setAwkCgoSeq(awkCgoSeq[i]);
				if (hlgTpCdOld[i] != null)
					model.setHlgTpCdOld(hlgTpCdOld[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pctlNo[i] != null)
					model.setPctlNo(pctlNo[i]);
				if (corrFlg[i] != null)
					model.setCorrFlg(corrFlg[i]);
				if (cntrRtnYdCd[i] != null)
					model.setCntrRtnYdCd(cntrRtnYdCd[i]);
				if (cfmCurrCd[i] != null)
					model.setCfmCurrCd(cfmCurrCd[i]);
				if (cstmsClrNo[i] != null)
					model.setCstmsClrNo(cstmsClrNo[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (cntrRtnDtHhmi[i] != null)
					model.setCntrRtnDtHhmi(cntrRtnDtHhmi[i]);
				if (cgoWgt[i] != null)
					model.setCgoWgt(cgoWgt[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (soNo[i] != null)
					model.setSoNo(soNo[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (cntrTpszCdOld[i] != null)
					model.setCntrTpszCdOld(cntrTpszCdOld[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (cfmHlgTpCd[i] != null)
					model.setCfmHlgTpCd(cfmHlgTpCd[i]);
				if (cfmAllInRtCd[i] != null)
					model.setCfmAllInRtCd(cfmAllInRtCd[i]);
				if (soOfcCd[i] != null)
					model.setSoOfcCd(soOfcCd[i]);
				if (troProcCd[i] != null)
					model.setTroProcCd(troProcCd[i]);
				if (cfmVatFlg[i] != null)
					model.setCfmVatFlg(cfmVatFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rqstSubSeq[i] != null)
					model.setRqstSubSeq(rqstSubSeq[i]);
				if (rcSeq[i] != null)
					model.setRcSeq(rcSeq[i]);
				if (cfmUpdDt[i] != null)
					model.setCfmUpdDt(cfmUpdDt[i]);
				if (cfmUsrNm[i] != null)
					model.setCfmUsrNm(cfmUsrNm[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (soCtyCd[i] != null)
					model.setSoCtyCd(soCtyCd[i]);
				if (trnsRevAmt[i] != null)
					model.setTrnsRevAmt(trnsRevAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (soUsrId[i] != null)
					model.setSoUsrId(soUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (allInRtCd[i] != null)
					model.setAllInRtCd(allInRtCd[i]);
				if (actCntCd[i] != null)
					model.setActCntCd(actCntCd[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (vatFlg[i] != null)
					model.setVatFlg(vatFlg[i]);
				if (spclInstrRmk[i] != null)
					model.setSpclInstrRmk(spclInstrRmk[i]);
				if (hlgTpCd[i] != null)
					model.setHlgTpCd(hlgTpCd[i]);
				if (t1DocFlg[i] != null)
					model.setT1DocFlg(t1DocFlg[i]);
				if (cntrRtnDt[i] != null)
					model.setCntrRtnDt(cntrRtnDt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (troCmdtCd[i] != null)
					model.setTroCmdtCd(troCmdtCd[i]);
				if (troSeq[i] != null)
					model.setTroSeq(troSeq[i]);
				if (actCustSeq[i] != null)
					model.setActCustSeq(actCustSeq[i]);
				if (cfmRevAmt[i] != null)
					model.setCfmRevAmt(cfmRevAmt[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (bkgTrspMzdCd[i] != null)
					model.setBkgTrspMzdCd(bkgTrspMzdCd[i]);
				if (nonTrnsRevAmt[i] != null)
					model.setNonTrnsRevAmt(nonTrnsRevAmt[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (soUsrNm[i] != null)
					model.setSoUsrNm(soUsrNm[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (cfmOfcCd[i] != null)
					model.setCfmOfcCd(cfmOfcCd[i]);
				if (cntrPkupDtHhmi[i] != null)
					model.setCntrPkupDtHhmi(cntrPkupDtHhmi[i]);
				if (cntrPkupDt[i] != null)
					model.setCntrPkupDt(cntrPkupDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (addRevAmt[i] != null)
					model.setAddRevAmt(addRevAmt[i]);
				if (addRevChgCd[i] != null)
					model.setAddRevChgCd(addRevChgCd[i]);
				if (splitRmk[i] != null)
					model.setSplitRmk(splitRmk[i]);
				if (addRevRmk[i] != null)
					model.setAddRevRmk(addRevRmk[i]);
				if (optmStsCd[i] != null)
					model.setOptmStsCd(optmStsCd[i]);
				if (notOptmRsn[i] != null)
					model.setNotOptmRsn(notOptmRsn[i]);
				if (addRevAmt2[i] != null)
					model.setAddRevAmt2(addRevAmt2[i]);
				if (addRevChgCd2[i] != null)
					model.setAddRevChgCd2(addRevChgCd2[i]);
				if (addRevAmt3[i] != null)
					model.setAddRevAmt3(addRevAmt3[i]);
				if (addRevChgCd3[i] != null)
					model.setAddRevChgCd3(addRevChgCd3[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurTroMstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurTroMstVO[]
	 */
	public EurTroMstVO[] getEurTroMstVOs(){
		EurTroMstVO[] vos = (EurTroMstVO[])models.toArray(new EurTroMstVO[models.size()]);
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
		this.soDt = this.soDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupYdCd = this.cntrPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eurTrnsTpCd = this.eurTrnsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awkCgoSeq = this.awkCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlgTpCdOld = this.hlgTpCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pctlNo = this.pctlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrFlg = this.corrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdCd = this.cntrRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmCurrCd = this.cfmCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrNo = this.cstmsClrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnDtHhmi = this.cntrRtnDtHhmi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt = this.cgoWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soNo = this.soNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdOld = this.cntrTpszCdOld .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmHlgTpCd = this.cfmHlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmAllInRtCd = this.cfmAllInRtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soOfcCd = this.soOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troProcCd = this.troProcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmVatFlg = this.cfmVatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstSubSeq = this.rqstSubSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcSeq = this.rcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUpdDt = this.cfmUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrNm = this.cfmUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soCtyCd = this.soCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnsRevAmt = this.trnsRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soUsrId = this.soUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allInRtCd = this.allInRtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCntCd = this.actCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatFlg = this.vatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclInstrRmk = this.spclInstrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlgTpCd = this.hlgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.t1DocFlg = this.t1DocFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnDt = this.cntrRtnDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troCmdtCd = this.troCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq = this.troSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq = this.actCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmRevAmt = this.cfmRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspMzdCd = this.bkgTrspMzdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nonTrnsRevAmt = this.nonTrnsRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soUsrNm = this.soUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmOfcCd = this.cfmOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupDtHhmi = this.cntrPkupDtHhmi .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupDt = this.cntrPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevAmt = this.addRevAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevChgCd = this.addRevChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitRmk = this.splitRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevRmk = this.addRevRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.optmStsCd = this.optmStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.notOptmRsn = this.notOptmRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevAmt2 = this.addRevAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevChgCd2 = this.addRevChgCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevAmt3 = this.addRevAmt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addRevChgCd3 = this.addRevChgCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
