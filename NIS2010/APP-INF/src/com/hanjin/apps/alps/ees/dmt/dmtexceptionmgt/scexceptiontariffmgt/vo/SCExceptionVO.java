/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCExceptionVO.java
*@FileTitle : SCExceptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SCExceptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SCExceptionVO> models = new ArrayList<SCExceptionVO>();
	
	/* Column Info */
	private String xcldSunFlg = null;
	/* Column Info */
	private String xcldSatFlg = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String ftTotDys = null;
	/* Column Info */
	private String actCustFlg = null;
	/* Column Info */
	private String scExptFmSteAllNm = null;
	/* Column Info */
	private String rtChkFlg = null;
	/* Column Info */
	private String scExptFmSteAllCd = null;
	/* Column Info */
	private String scExptVerSeq = null;
	/* Column Info */
	private String reqUsrNm = null;
	/* Column Info */
	private String ftAddFlg = null;
	/* Column Info */
	private String exptTrfRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String acctUsrNm = null;
	/* Column Info */
	private String acctOfcCd = null;
	/* Column Info */
	private String cvrgSeq = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String rcvDeTermCd = null;
	/* Column Info */
	private String rgnAllCd = null;
	/* Column Info */
	private String scExptFmRgnAllCd = null;
	/* Column Info */
	private String delDt = null;
	/* Column Info */
	private String updOfcCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rtAdjFlg = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String scExptFmCntAllNm = null;
	/* Column Info */
	private String scExptFmRgnAllNm = null;
	/* Column Info */
	private String ftFlg = null;
	/* Column Info */
	private String dmdtCntrCgoTpCd = null;
	/* Column Info */
	private String reqOfcCd = null;
	/* Column Info */
	private String fmToPairFlg = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String ftTir = null;
	/* Column Info */
	private String steAllCd = null;
	/* Column Info */
	private String scExptFmSteCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String scExptFmLocCd = null;
	/* Column Info */
	private String xcldHolFlg = null;
	/* Column Info */
	private String ftAddDys = null;
	/* Column Info */
	private String repCmdtFlg = null;
	/* Column Info */
	private String currCvrgMulti = null;
	/* Column Info */
	private String fnlDestRgnAllCd = null;
	/* Column Info */
	private String scExptFmContiCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String liveDt = null;
	/* Column Info */
	private String ftAdjFlg = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String dmdtExptVerStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String fnlDestRgnAllNm = null;
	/* Column Info */
	private String reqDt = null;
	/* Column Info */
	private String fnlDestRgnCd = null;
	/* Column Info */
	private String scExptFmRgnCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtChk = null;
	/* Column Info */
	private String fnlDestSteAllNm = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String scExptFmCntAllCd = null;
	/* Column Info */
	private String dmdtFtAdjTpCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String cmdtFlg = null;
	/* Column Info */
	private String fnlDestSteAllCd = null;
	/* Column Info */
	private String steAllNm = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String cvrgMulti = null;
	/* Column Info */
	private String rgnAllNm = null;
	/* Column Info */
	private String acctDt = null;
	/* Column Info */
	private String fullExptTrfRmk = null;
	/* Column Info */
	private String dmdtExptVerStsDesc = null;
	/* Column Info */
	private String scExptFmCntCd = null;
	/* Column Info */
	private String scExptGrpSeq = null;
	/* Column Info */
	private String fnlDestCntCd = null;
	/* Column Info */
	private String fnlDestLocCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String fnlDestSteCd = null;
	/* Column Info */
	private String repCmdtCd = null;
	/* Column Info */
	private String newFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SCExceptionVO() {}

	public SCExceptionVO(String ibflag, String pagerows, String propNo, String scNo, String scExptVerSeq, String scExptGrpSeq, String dmdtExptVerStsCd, String dmdtExptVerStsDesc, String effDt, String expDt, String dmdtTrfCd, String dmdtCntrCgoTpCd, String cvrgMulti, String currCvrgMulti, String cvrgSeq, String cntCd, String rgnAllCd, String rgnAllNm, String rgnCd, String steAllCd, String steAllNm, String steCd, String locCd, String ftFlg, String ftTir, String ftAddFlg, String ftAddDys, String ftTotDys, String cmdtFlg, String repCmdtCd, String repCmdtNm, String repCmdtFlg, String actCustFlg, String fmToPairFlg, String scExptFmContiCd, String scExptFmCntAllCd, String scExptFmCntAllNm, String scExptFmCntCd, String scExptFmRgnAllCd, String scExptFmRgnAllNm, String scExptFmRgnCd, String scExptFmSteAllCd, String scExptFmSteAllNm, String scExptFmSteCd, String scExptFmLocCd, String fnlDestCntCd, String fnlDestRgnAllCd, String fnlDestRgnAllNm, String fnlDestRgnCd, String fnlDestSteAllCd, String fnlDestSteAllNm, String fnlDestSteCd, String fnlDestLocCd, String rcvDeTermCd, String deltFlg, String xcldSatFlg, String xcldSunFlg, String xcldHolFlg, String dmdtFtAdjTpCd, String ftAdjFlg, String rtAdjFlg, String currCd, String exptTrfRmk, String fullExptTrfRmk, String creUsrId, String creDt, String creOfcCd, String updUsrId, String updDt, String updOfcCd, String reqOfcCd, String reqUsrNm, String reqDt, String acctOfcCd, String acctUsrNm, String acctDt, String liveDt, String delDt, String rtChkFlg, String rtChk, String newFlg) {
		this.xcldSunFlg = xcldSunFlg;
		this.xcldSatFlg = xcldSatFlg;
		this.rgnCd = rgnCd;
		this.ftTotDys = ftTotDys;
		this.actCustFlg = actCustFlg;
		this.scExptFmSteAllNm = scExptFmSteAllNm;
		this.rtChkFlg = rtChkFlg;
		this.scExptFmSteAllCd = scExptFmSteAllCd;
		this.scExptVerSeq = scExptVerSeq;
		this.reqUsrNm = reqUsrNm;
		this.ftAddFlg = ftAddFlg;
		this.exptTrfRmk = exptTrfRmk;
		this.pagerows = pagerows;
		this.locCd = locCd;
		this.effDt = effDt;
		this.acctUsrNm = acctUsrNm;
		this.acctOfcCd = acctOfcCd;
		this.cvrgSeq = cvrgSeq;
		this.scNo = scNo;
		this.cntCd = cntCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.rgnAllCd = rgnAllCd;
		this.scExptFmRgnAllCd = scExptFmRgnAllCd;
		this.delDt = delDt;
		this.updOfcCd = updOfcCd;
		this.updUsrId = updUsrId;
		this.rtAdjFlg = rtAdjFlg;
		this.dmdtTrfCd = dmdtTrfCd;
		this.scExptFmCntAllNm = scExptFmCntAllNm;
		this.scExptFmRgnAllNm = scExptFmRgnAllNm;
		this.ftFlg = ftFlg;
		this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
		this.reqOfcCd = reqOfcCd;
		this.fmToPairFlg = fmToPairFlg;
		this.repCmdtNm = repCmdtNm;
		this.ftTir = ftTir;
		this.steAllCd = steAllCd;
		this.scExptFmSteCd = scExptFmSteCd;
		this.creUsrId = creUsrId;
		this.scExptFmLocCd = scExptFmLocCd;
		this.xcldHolFlg = xcldHolFlg;
		this.ftAddDys = ftAddDys;
		this.repCmdtFlg = repCmdtFlg;
		this.currCvrgMulti = currCvrgMulti;
		this.fnlDestRgnAllCd = fnlDestRgnAllCd;
		this.scExptFmContiCd = scExptFmContiCd;
		this.currCd = currCd;
		this.liveDt = liveDt;
		this.ftAdjFlg = ftAdjFlg;
		this.deltFlg = deltFlg;
		this.dmdtExptVerStsCd = dmdtExptVerStsCd;
		this.creDt = creDt;
		this.fnlDestRgnAllNm = fnlDestRgnAllNm;
		this.reqDt = reqDt;
		this.fnlDestRgnCd = fnlDestRgnCd;
		this.scExptFmRgnCd = scExptFmRgnCd;
		this.ibflag = ibflag;
		this.rtChk = rtChk;
		this.fnlDestSteAllNm = fnlDestSteAllNm;
		this.creOfcCd = creOfcCd;
		this.scExptFmCntAllCd = scExptFmCntAllCd;
		this.dmdtFtAdjTpCd = dmdtFtAdjTpCd;
		this.expDt = expDt;
		this.cmdtFlg = cmdtFlg;
		this.fnlDestSteAllCd = fnlDestSteAllCd;
		this.steAllNm = steAllNm;
		this.updDt = updDt;
		this.cvrgMulti = cvrgMulti;
		this.rgnAllNm = rgnAllNm;
		this.acctDt = acctDt;
		this.fullExptTrfRmk = fullExptTrfRmk;
		this.dmdtExptVerStsDesc = dmdtExptVerStsDesc;
		this.scExptFmCntCd = scExptFmCntCd;
		this.scExptGrpSeq = scExptGrpSeq;
		this.fnlDestCntCd = fnlDestCntCd;
		this.fnlDestLocCd = fnlDestLocCd;
		this.propNo = propNo;
		this.steCd = steCd;
		this.fnlDestSteCd = fnlDestSteCd;
		this.repCmdtCd = repCmdtCd;
		this.newFlg = newFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("xcld_sun_flg", getXcldSunFlg());
		this.hashColumns.put("xcld_sat_flg", getXcldSatFlg());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("ft_tot_dys", getFtTotDys());
		this.hashColumns.put("act_cust_flg", getActCustFlg());
		this.hashColumns.put("sc_expt_fm_ste_all_nm", getScExptFmSteAllNm());
		this.hashColumns.put("rt_chk_flg", getRtChkFlg());
		this.hashColumns.put("sc_expt_fm_ste_all_cd", getScExptFmSteAllCd());
		this.hashColumns.put("sc_expt_ver_seq", getScExptVerSeq());
		this.hashColumns.put("req_usr_nm", getReqUsrNm());
		this.hashColumns.put("ft_add_flg", getFtAddFlg());
		this.hashColumns.put("expt_trf_rmk", getExptTrfRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("acct_usr_nm", getAcctUsrNm());
		this.hashColumns.put("acct_ofc_cd", getAcctOfcCd());
		this.hashColumns.put("cvrg_seq", getCvrgSeq());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("rgn_all_cd", getRgnAllCd());
		this.hashColumns.put("sc_expt_fm_rgn_all_cd", getScExptFmRgnAllCd());
		this.hashColumns.put("del_dt", getDelDt());
		this.hashColumns.put("upd_ofc_cd", getUpdOfcCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rt_adj_flg", getRtAdjFlg());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("sc_expt_fm_cnt_all_nm", getScExptFmCntAllNm());
		this.hashColumns.put("sc_expt_fm_rgn_all_nm", getScExptFmRgnAllNm());
		this.hashColumns.put("ft_flg", getFtFlg());
		this.hashColumns.put("dmdt_cntr_cgo_tp_cd", getDmdtCntrCgoTpCd());
		this.hashColumns.put("req_ofc_cd", getReqOfcCd());
		this.hashColumns.put("fm_to_pair_flg", getFmToPairFlg());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("ft_tir", getFtTir());
		this.hashColumns.put("ste_all_cd", getSteAllCd());
		this.hashColumns.put("sc_expt_fm_ste_cd", getScExptFmSteCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("sc_expt_fm_loc_cd", getScExptFmLocCd());
		this.hashColumns.put("xcld_hol_flg", getXcldHolFlg());
		this.hashColumns.put("ft_add_dys", getFtAddDys());
		this.hashColumns.put("rep_cmdt_flg", getRepCmdtFlg());
		this.hashColumns.put("curr_cvrg_multi", getCurrCvrgMulti());
		this.hashColumns.put("fnl_dest_rgn_all_cd", getFnlDestRgnAllCd());
		this.hashColumns.put("sc_expt_fm_conti_cd", getScExptFmContiCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("live_dt", getLiveDt());
		this.hashColumns.put("ft_adj_flg", getFtAdjFlg());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("dmdt_expt_ver_sts_cd", getDmdtExptVerStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fnl_dest_rgn_all_nm", getFnlDestRgnAllNm());
		this.hashColumns.put("req_dt", getReqDt());
		this.hashColumns.put("fnl_dest_rgn_cd", getFnlDestRgnCd());
		this.hashColumns.put("sc_expt_fm_rgn_cd", getScExptFmRgnCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rt_chk", getRtChk());
		this.hashColumns.put("fnl_dest_ste_all_nm", getFnlDestSteAllNm());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("sc_expt_fm_cnt_all_cd", getScExptFmCntAllCd());
		this.hashColumns.put("dmdt_ft_adj_tp_cd", getDmdtFtAdjTpCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("cmdt_flg", getCmdtFlg());
		this.hashColumns.put("fnl_dest_ste_all_cd", getFnlDestSteAllCd());
		this.hashColumns.put("ste_all_nm", getSteAllNm());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cvrg_multi", getCvrgMulti());
		this.hashColumns.put("rgn_all_nm", getRgnAllNm());
		this.hashColumns.put("acct_dt", getAcctDt());
		this.hashColumns.put("full_expt_trf_rmk", getFullExptTrfRmk());
		this.hashColumns.put("dmdt_expt_ver_sts_desc", getDmdtExptVerStsDesc());
		this.hashColumns.put("sc_expt_fm_cnt_cd", getScExptFmCntCd());
		this.hashColumns.put("sc_expt_grp_seq", getScExptGrpSeq());
		this.hashColumns.put("fnl_dest_cnt_cd", getFnlDestCntCd());
		this.hashColumns.put("fnl_dest_loc_cd", getFnlDestLocCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("fnl_dest_ste_cd", getFnlDestSteCd());
		this.hashColumns.put("rep_cmdt_cd", getRepCmdtCd());
		this.hashColumns.put("new_flg", getNewFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("xcld_sun_flg", "xcldSunFlg");
		this.hashFields.put("xcld_sat_flg", "xcldSatFlg");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("ft_tot_dys", "ftTotDys");
		this.hashFields.put("act_cust_flg", "actCustFlg");
		this.hashFields.put("sc_expt_fm_ste_all_nm", "scExptFmSteAllNm");
		this.hashFields.put("rt_chk_flg", "rtChkFlg");
		this.hashFields.put("sc_expt_fm_ste_all_cd", "scExptFmSteAllCd");
		this.hashFields.put("sc_expt_ver_seq", "scExptVerSeq");
		this.hashFields.put("req_usr_nm", "reqUsrNm");
		this.hashFields.put("ft_add_flg", "ftAddFlg");
		this.hashFields.put("expt_trf_rmk", "exptTrfRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("acct_usr_nm", "acctUsrNm");
		this.hashFields.put("acct_ofc_cd", "acctOfcCd");
		this.hashFields.put("cvrg_seq", "cvrgSeq");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("rgn_all_cd", "rgnAllCd");
		this.hashFields.put("sc_expt_fm_rgn_all_cd", "scExptFmRgnAllCd");
		this.hashFields.put("del_dt", "delDt");
		this.hashFields.put("upd_ofc_cd", "updOfcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rt_adj_flg", "rtAdjFlg");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("sc_expt_fm_cnt_all_nm", "scExptFmCntAllNm");
		this.hashFields.put("sc_expt_fm_rgn_all_nm", "scExptFmRgnAllNm");
		this.hashFields.put("ft_flg", "ftFlg");
		this.hashFields.put("dmdt_cntr_cgo_tp_cd", "dmdtCntrCgoTpCd");
		this.hashFields.put("req_ofc_cd", "reqOfcCd");
		this.hashFields.put("fm_to_pair_flg", "fmToPairFlg");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("ft_tir", "ftTir");
		this.hashFields.put("ste_all_cd", "steAllCd");
		this.hashFields.put("sc_expt_fm_ste_cd", "scExptFmSteCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sc_expt_fm_loc_cd", "scExptFmLocCd");
		this.hashFields.put("xcld_hol_flg", "xcldHolFlg");
		this.hashFields.put("ft_add_dys", "ftAddDys");
		this.hashFields.put("rep_cmdt_flg", "repCmdtFlg");
		this.hashFields.put("curr_cvrg_multi", "currCvrgMulti");
		this.hashFields.put("fnl_dest_rgn_all_cd", "fnlDestRgnAllCd");
		this.hashFields.put("sc_expt_fm_conti_cd", "scExptFmContiCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("live_dt", "liveDt");
		this.hashFields.put("ft_adj_flg", "ftAdjFlg");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("dmdt_expt_ver_sts_cd", "dmdtExptVerStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fnl_dest_rgn_all_nm", "fnlDestRgnAllNm");
		this.hashFields.put("req_dt", "reqDt");
		this.hashFields.put("fnl_dest_rgn_cd", "fnlDestRgnCd");
		this.hashFields.put("sc_expt_fm_rgn_cd", "scExptFmRgnCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rt_chk", "rtChk");
		this.hashFields.put("fnl_dest_ste_all_nm", "fnlDestSteAllNm");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("sc_expt_fm_cnt_all_cd", "scExptFmCntAllCd");
		this.hashFields.put("dmdt_ft_adj_tp_cd", "dmdtFtAdjTpCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("cmdt_flg", "cmdtFlg");
		this.hashFields.put("fnl_dest_ste_all_cd", "fnlDestSteAllCd");
		this.hashFields.put("ste_all_nm", "steAllNm");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cvrg_multi", "cvrgMulti");
		this.hashFields.put("rgn_all_nm", "rgnAllNm");
		this.hashFields.put("acct_dt", "acctDt");
		this.hashFields.put("full_expt_trf_rmk", "fullExptTrfRmk");
		this.hashFields.put("dmdt_expt_ver_sts_desc", "dmdtExptVerStsDesc");
		this.hashFields.put("sc_expt_fm_cnt_cd", "scExptFmCntCd");
		this.hashFields.put("sc_expt_grp_seq", "scExptGrpSeq");
		this.hashFields.put("fnl_dest_cnt_cd", "fnlDestCntCd");
		this.hashFields.put("fnl_dest_loc_cd", "fnlDestLocCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("fnl_dest_ste_cd", "fnlDestSteCd");
		this.hashFields.put("rep_cmdt_cd", "repCmdtCd");
		this.hashFields.put("new_flg", "newFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return xcldSunFlg
	 */
	public String getXcldSunFlg() {
		return this.xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @return xcldSatFlg
	 */
	public String getXcldSatFlg() {
		return this.xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return ftTotDys
	 */
	public String getFtTotDys() {
		return this.ftTotDys;
	}
	
	/**
	 * Column Info
	 * @return actCustFlg
	 */
	public String getActCustFlg() {
		return this.actCustFlg;
	}
	
	/**
	 * Column Info
	 * @return scExptFmSteAllNm
	 */
	public String getScExptFmSteAllNm() {
		return this.scExptFmSteAllNm;
	}
	
	/**
	 * Column Info
	 * @return rtChkFlg
	 */
	public String getRtChkFlg() {
		return this.rtChkFlg;
	}
	
	/**
	 * Column Info
	 * @return scExptFmSteAllCd
	 */
	public String getScExptFmSteAllCd() {
		return this.scExptFmSteAllCd;
	}
	
	/**
	 * Column Info
	 * @return scExptVerSeq
	 */
	public String getScExptVerSeq() {
		return this.scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @return reqUsrNm
	 */
	public String getReqUsrNm() {
		return this.reqUsrNm;
	}
	
	/**
	 * Column Info
	 * @return ftAddFlg
	 */
	public String getFtAddFlg() {
		return this.ftAddFlg;
	}
	
	/**
	 * Column Info
	 * @return exptTrfRmk
	 */
	public String getExptTrfRmk() {
		return this.exptTrfRmk;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return acctUsrNm
	 */
	public String getAcctUsrNm() {
		return this.acctUsrNm;
	}
	
	/**
	 * Column Info
	 * @return acctOfcCd
	 */
	public String getAcctOfcCd() {
		return this.acctOfcCd;
	}
	
	/**
	 * Column Info
	 * @return cvrgSeq
	 */
	public String getCvrgSeq() {
		return this.cvrgSeq;
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
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}
	
	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public String getRcvDeTermCd() {
		return this.rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @return rgnAllCd
	 */
	public String getRgnAllCd() {
		return this.rgnAllCd;
	}
	
	/**
	 * Column Info
	 * @return scExptFmRgnAllCd
	 */
	public String getScExptFmRgnAllCd() {
		return this.scExptFmRgnAllCd;
	}
	
	/**
	 * Column Info
	 * @return delDt
	 */
	public String getDelDt() {
		return this.delDt;
	}
	
	/**
	 * Column Info
	 * @return updOfcCd
	 */
	public String getUpdOfcCd() {
		return this.updOfcCd;
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
	 * @return rtAdjFlg
	 */
	public String getRtAdjFlg() {
		return this.rtAdjFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return scExptFmCntAllNm
	 */
	public String getScExptFmCntAllNm() {
		return this.scExptFmCntAllNm;
	}
	
	/**
	 * Column Info
	 * @return scExptFmRgnAllNm
	 */
	public String getScExptFmRgnAllNm() {
		return this.scExptFmRgnAllNm;
	}
	
	/**
	 * Column Info
	 * @return ftFlg
	 */
	public String getFtFlg() {
		return this.ftFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtCntrCgoTpCd
	 */
	public String getDmdtCntrCgoTpCd() {
		return this.dmdtCntrCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return reqOfcCd
	 */
	public String getReqOfcCd() {
		return this.reqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmToPairFlg
	 */
	public String getFmToPairFlg() {
		return this.fmToPairFlg;
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
	 * @return ftTir
	 */
	public String getFtTir() {
		return this.ftTir;
	}
	
	/**
	 * Column Info
	 * @return steAllCd
	 */
	public String getSteAllCd() {
		return this.steAllCd;
	}
	
	/**
	 * Column Info
	 * @return scExptFmSteCd
	 */
	public String getScExptFmSteCd() {
		return this.scExptFmSteCd;
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
	 * @return scExptFmLocCd
	 */
	public String getScExptFmLocCd() {
		return this.scExptFmLocCd;
	}
	
	/**
	 * Column Info
	 * @return xcldHolFlg
	 */
	public String getXcldHolFlg() {
		return this.xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @return ftAddDys
	 */
	public String getFtAddDys() {
		return this.ftAddDys;
	}
	
	/**
	 * Column Info
	 * @return repCmdtFlg
	 */
	public String getRepCmdtFlg() {
		return this.repCmdtFlg;
	}
	
	/**
	 * Column Info
	 * @return currCvrgMulti
	 */
	public String getCurrCvrgMulti() {
		return this.currCvrgMulti;
	}
	
	/**
	 * Column Info
	 * @return fnlDestRgnAllCd
	 */
	public String getFnlDestRgnAllCd() {
		return this.fnlDestRgnAllCd;
	}
	
	/**
	 * Column Info
	 * @return scExptFmContiCd
	 */
	public String getScExptFmContiCd() {
		return this.scExptFmContiCd;
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
	 * @return liveDt
	 */
	public String getLiveDt() {
		return this.liveDt;
	}
	
	/**
	 * Column Info
	 * @return ftAdjFlg
	 */
	public String getFtAdjFlg() {
		return this.ftAdjFlg;
	}
	
	/**
	 * Column Info
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptVerStsCd
	 */
	public String getDmdtExptVerStsCd() {
		return this.dmdtExptVerStsCd;
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
	 * @return fnlDestRgnAllNm
	 */
	public String getFnlDestRgnAllNm() {
		return this.fnlDestRgnAllNm;
	}
	
	/**
	 * Column Info
	 * @return reqDt
	 */
	public String getReqDt() {
		return this.reqDt;
	}
	
	/**
	 * Column Info
	 * @return fnlDestRgnCd
	 */
	public String getFnlDestRgnCd() {
		return this.fnlDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @return scExptFmRgnCd
	 */
	public String getScExptFmRgnCd() {
		return this.scExptFmRgnCd;
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
	 * @return rtChk
	 */
	public String getRtChk() {
		return this.rtChk;
	}
	
	/**
	 * Column Info
	 * @return fnlDestSteAllNm
	 */
	public String getFnlDestSteAllNm() {
		return this.fnlDestSteAllNm;
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
	 * @return scExptFmCntAllCd
	 */
	public String getScExptFmCntAllCd() {
		return this.scExptFmCntAllCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtFtAdjTpCd
	 */
	public String getDmdtFtAdjTpCd() {
		return this.dmdtFtAdjTpCd;
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
	 * @return cmdtFlg
	 */
	public String getCmdtFlg() {
		return this.cmdtFlg;
	}
	
	/**
	 * Column Info
	 * @return fnlDestSteAllCd
	 */
	public String getFnlDestSteAllCd() {
		return this.fnlDestSteAllCd;
	}
	
	/**
	 * Column Info
	 * @return steAllNm
	 */
	public String getSteAllNm() {
		return this.steAllNm;
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
	 * @return cvrgMulti
	 */
	public String getCvrgMulti() {
		return this.cvrgMulti;
	}
	
	/**
	 * Column Info
	 * @return rgnAllNm
	 */
	public String getRgnAllNm() {
		return this.rgnAllNm;
	}
	
	/**
	 * Column Info
	 * @return acctDt
	 */
	public String getAcctDt() {
		return this.acctDt;
	}
	
	/**
	 * Column Info
	 * @return fullExptTrfRmk
	 */
	public String getFullExptTrfRmk() {
		return this.fullExptTrfRmk;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptVerStsDesc
	 */
	public String getDmdtExptVerStsDesc() {
		return this.dmdtExptVerStsDesc;
	}
	
	/**
	 * Column Info
	 * @return scExptFmCntCd
	 */
	public String getScExptFmCntCd() {
		return this.scExptFmCntCd;
	}
	
	/**
	 * Column Info
	 * @return scExptGrpSeq
	 */
	public String getScExptGrpSeq() {
		return this.scExptGrpSeq;
	}
	
	/**
	 * Column Info
	 * @return fnlDestCntCd
	 */
	public String getFnlDestCntCd() {
		return this.fnlDestCntCd;
	}
	
	/**
	 * Column Info
	 * @return fnlDestLocCd
	 */
	public String getFnlDestLocCd() {
		return this.fnlDestLocCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
	}
	
	/**
	 * Column Info
	 * @return fnlDestSteCd
	 */
	public String getFnlDestSteCd() {
		return this.fnlDestSteCd;
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
	 * @return newFlg
	 */
	public String getNewFlg() {
		return newFlg;
	}

	/**
	 * Column Info
	 * @param xcldSunFlg
	 */
	public void setXcldSunFlg(String xcldSunFlg) {
		this.xcldSunFlg = xcldSunFlg;
	}
	
	/**
	 * Column Info
	 * @param xcldSatFlg
	 */
	public void setXcldSatFlg(String xcldSatFlg) {
		this.xcldSatFlg = xcldSatFlg;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param ftTotDys
	 */
	public void setFtTotDys(String ftTotDys) {
		this.ftTotDys = ftTotDys;
	}
	
	/**
	 * Column Info
	 * @param actCustFlg
	 */
	public void setActCustFlg(String actCustFlg) {
		this.actCustFlg = actCustFlg;
	}
	
	/**
	 * Column Info
	 * @param scExptFmSteAllNm
	 */
	public void setScExptFmSteAllNm(String scExptFmSteAllNm) {
		this.scExptFmSteAllNm = scExptFmSteAllNm;
	}
	
	/**
	 * Column Info
	 * @param rtChkFlg
	 */
	public void setRtChkFlg(String rtChkFlg) {
		this.rtChkFlg = rtChkFlg;
	}
	
	/**
	 * Column Info
	 * @param scExptFmSteAllCd
	 */
	public void setScExptFmSteAllCd(String scExptFmSteAllCd) {
		this.scExptFmSteAllCd = scExptFmSteAllCd;
	}
	
	/**
	 * Column Info
	 * @param scExptVerSeq
	 */
	public void setScExptVerSeq(String scExptVerSeq) {
		this.scExptVerSeq = scExptVerSeq;
	}
	
	/**
	 * Column Info
	 * @param reqUsrNm
	 */
	public void setReqUsrNm(String reqUsrNm) {
		this.reqUsrNm = reqUsrNm;
	}
	
	/**
	 * Column Info
	 * @param ftAddFlg
	 */
	public void setFtAddFlg(String ftAddFlg) {
		this.ftAddFlg = ftAddFlg;
	}
	
	/**
	 * Column Info
	 * @param exptTrfRmk
	 */
	public void setExptTrfRmk(String exptTrfRmk) {
		this.exptTrfRmk = exptTrfRmk;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param acctUsrNm
	 */
	public void setAcctUsrNm(String acctUsrNm) {
		this.acctUsrNm = acctUsrNm;
	}
	
	/**
	 * Column Info
	 * @param acctOfcCd
	 */
	public void setAcctOfcCd(String acctOfcCd) {
		this.acctOfcCd = acctOfcCd;
	}
	
	/**
	 * Column Info
	 * @param cvrgSeq
	 */
	public void setCvrgSeq(String cvrgSeq) {
		this.cvrgSeq = cvrgSeq;
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
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param rcvDeTermCd
	 */
	public void setRcvDeTermCd(String rcvDeTermCd) {
		this.rcvDeTermCd = rcvDeTermCd;
	}
	
	/**
	 * Column Info
	 * @param rgnAllCd
	 */
	public void setRgnAllCd(String rgnAllCd) {
		this.rgnAllCd = rgnAllCd;
	}
	
	/**
	 * Column Info
	 * @param scExptFmRgnAllCd
	 */
	public void setScExptFmRgnAllCd(String scExptFmRgnAllCd) {
		this.scExptFmRgnAllCd = scExptFmRgnAllCd;
	}
	
	/**
	 * Column Info
	 * @param delDt
	 */
	public void setDelDt(String delDt) {
		this.delDt = delDt;
	}
	
	/**
	 * Column Info
	 * @param updOfcCd
	 */
	public void setUpdOfcCd(String updOfcCd) {
		this.updOfcCd = updOfcCd;
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
	 * @param rtAdjFlg
	 */
	public void setRtAdjFlg(String rtAdjFlg) {
		this.rtAdjFlg = rtAdjFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param scExptFmCntAllNm
	 */
	public void setScExptFmCntAllNm(String scExptFmCntAllNm) {
		this.scExptFmCntAllNm = scExptFmCntAllNm;
	}
	
	/**
	 * Column Info
	 * @param scExptFmRgnAllNm
	 */
	public void setScExptFmRgnAllNm(String scExptFmRgnAllNm) {
		this.scExptFmRgnAllNm = scExptFmRgnAllNm;
	}
	
	/**
	 * Column Info
	 * @param ftFlg
	 */
	public void setFtFlg(String ftFlg) {
		this.ftFlg = ftFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtCntrCgoTpCd
	 */
	public void setDmdtCntrCgoTpCd(String dmdtCntrCgoTpCd) {
		this.dmdtCntrCgoTpCd = dmdtCntrCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param reqOfcCd
	 */
	public void setReqOfcCd(String reqOfcCd) {
		this.reqOfcCd = reqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmToPairFlg
	 */
	public void setFmToPairFlg(String fmToPairFlg) {
		this.fmToPairFlg = fmToPairFlg;
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
	 * @param ftTir
	 */
	public void setFtTir(String ftTir) {
		this.ftTir = ftTir;
	}
	
	/**
	 * Column Info
	 * @param steAllCd
	 */
	public void setSteAllCd(String steAllCd) {
		this.steAllCd = steAllCd;
	}
	
	/**
	 * Column Info
	 * @param scExptFmSteCd
	 */
	public void setScExptFmSteCd(String scExptFmSteCd) {
		this.scExptFmSteCd = scExptFmSteCd;
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
	 * @param scExptFmLocCd
	 */
	public void setScExptFmLocCd(String scExptFmLocCd) {
		this.scExptFmLocCd = scExptFmLocCd;
	}
	
	/**
	 * Column Info
	 * @param xcldHolFlg
	 */
	public void setXcldHolFlg(String xcldHolFlg) {
		this.xcldHolFlg = xcldHolFlg;
	}
	
	/**
	 * Column Info
	 * @param ftAddDys
	 */
	public void setFtAddDys(String ftAddDys) {
		this.ftAddDys = ftAddDys;
	}
	
	/**
	 * Column Info
	 * @param repCmdtFlg
	 */
	public void setRepCmdtFlg(String repCmdtFlg) {
		this.repCmdtFlg = repCmdtFlg;
	}
	
	/**
	 * Column Info
	 * @param currCvrgMulti
	 */
	public void setCurrCvrgMulti(String currCvrgMulti) {
		this.currCvrgMulti = currCvrgMulti;
	}
	
	/**
	 * Column Info
	 * @param fnlDestRgnAllCd
	 */
	public void setFnlDestRgnAllCd(String fnlDestRgnAllCd) {
		this.fnlDestRgnAllCd = fnlDestRgnAllCd;
	}
	
	/**
	 * Column Info
	 * @param scExptFmContiCd
	 */
	public void setScExptFmContiCd(String scExptFmContiCd) {
		this.scExptFmContiCd = scExptFmContiCd;
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
	 * @param liveDt
	 */
	public void setLiveDt(String liveDt) {
		this.liveDt = liveDt;
	}
	
	/**
	 * Column Info
	 * @param ftAdjFlg
	 */
	public void setFtAdjFlg(String ftAdjFlg) {
		this.ftAdjFlg = ftAdjFlg;
	}
	
	/**
	 * Column Info
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptVerStsCd
	 */
	public void setDmdtExptVerStsCd(String dmdtExptVerStsCd) {
		this.dmdtExptVerStsCd = dmdtExptVerStsCd;
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
	 * @param fnlDestRgnAllNm
	 */
	public void setFnlDestRgnAllNm(String fnlDestRgnAllNm) {
		this.fnlDestRgnAllNm = fnlDestRgnAllNm;
	}
	
	/**
	 * Column Info
	 * @param reqDt
	 */
	public void setReqDt(String reqDt) {
		this.reqDt = reqDt;
	}
	
	/**
	 * Column Info
	 * @param fnlDestRgnCd
	 */
	public void setFnlDestRgnCd(String fnlDestRgnCd) {
		this.fnlDestRgnCd = fnlDestRgnCd;
	}
	
	/**
	 * Column Info
	 * @param scExptFmRgnCd
	 */
	public void setScExptFmRgnCd(String scExptFmRgnCd) {
		this.scExptFmRgnCd = scExptFmRgnCd;
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
	 * @param rtChk
	 */
	public void setRtChk(String rtChk) {
		this.rtChk = rtChk;
	}
	
	/**
	 * Column Info
	 * @param fnlDestSteAllNm
	 */
	public void setFnlDestSteAllNm(String fnlDestSteAllNm) {
		this.fnlDestSteAllNm = fnlDestSteAllNm;
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
	 * @param scExptFmCntAllCd
	 */
	public void setScExptFmCntAllCd(String scExptFmCntAllCd) {
		this.scExptFmCntAllCd = scExptFmCntAllCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtFtAdjTpCd
	 */
	public void setDmdtFtAdjTpCd(String dmdtFtAdjTpCd) {
		this.dmdtFtAdjTpCd = dmdtFtAdjTpCd;
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
	 * @param cmdtFlg
	 */
	public void setCmdtFlg(String cmdtFlg) {
		this.cmdtFlg = cmdtFlg;
	}
	
	/**
	 * Column Info
	 * @param fnlDestSteAllCd
	 */
	public void setFnlDestSteAllCd(String fnlDestSteAllCd) {
		this.fnlDestSteAllCd = fnlDestSteAllCd;
	}
	
	/**
	 * Column Info
	 * @param steAllNm
	 */
	public void setSteAllNm(String steAllNm) {
		this.steAllNm = steAllNm;
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
	 * @param cvrgMulti
	 */
	public void setCvrgMulti(String cvrgMulti) {
		this.cvrgMulti = cvrgMulti;
	}
	
	/**
	 * Column Info
	 * @param rgnAllNm
	 */
	public void setRgnAllNm(String rgnAllNm) {
		this.rgnAllNm = rgnAllNm;
	}
	
	/**
	 * Column Info
	 * @param acctDt
	 */
	public void setAcctDt(String acctDt) {
		this.acctDt = acctDt;
	}
	
	/**
	 * Column Info
	 * @param fullExptTrfRmk
	 */
	public void setFullExptTrfRmk(String fullExptTrfRmk) {
		this.fullExptTrfRmk = fullExptTrfRmk;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptVerStsDesc
	 */
	public void setDmdtExptVerStsDesc(String dmdtExptVerStsDesc) {
		this.dmdtExptVerStsDesc = dmdtExptVerStsDesc;
	}
	
	/**
	 * Column Info
	 * @param scExptFmCntCd
	 */
	public void setScExptFmCntCd(String scExptFmCntCd) {
		this.scExptFmCntCd = scExptFmCntCd;
	}
	
	/**
	 * Column Info
	 * @param scExptGrpSeq
	 */
	public void setScExptGrpSeq(String scExptGrpSeq) {
		this.scExptGrpSeq = scExptGrpSeq;
	}
	
	/**
	 * Column Info
	 * @param fnlDestCntCd
	 */
	public void setFnlDestCntCd(String fnlDestCntCd) {
		this.fnlDestCntCd = fnlDestCntCd;
	}
	
	/**
	 * Column Info
	 * @param fnlDestLocCd
	 */
	public void setFnlDestLocCd(String fnlDestLocCd) {
		this.fnlDestLocCd = fnlDestLocCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Column Info
	 * @param fnlDestSteCd
	 */
	public void setFnlDestSteCd(String fnlDestSteCd) {
		this.fnlDestSteCd = fnlDestSteCd;
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
	 * @return newFlg
	 */
	public void setNewFlg(String newFlg) {
		this.newFlg = newFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setXcldSunFlg(JSPUtil.getParameter(request, "xcld_sun_flg", ""));
		setXcldSatFlg(JSPUtil.getParameter(request, "xcld_sat_flg", ""));
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setFtTotDys(JSPUtil.getParameter(request, "ft_tot_dys", ""));
		setActCustFlg(JSPUtil.getParameter(request, "act_cust_flg", ""));
		setScExptFmSteAllNm(JSPUtil.getParameter(request, "sc_expt_fm_ste_all_nm", ""));
		setRtChkFlg(JSPUtil.getParameter(request, "rt_chk_flg", ""));
		setScExptFmSteAllCd(JSPUtil.getParameter(request, "sc_expt_fm_ste_all_cd", ""));
		setScExptVerSeq(JSPUtil.getParameter(request, "sc_expt_ver_seq", ""));
		setReqUsrNm(JSPUtil.getParameter(request, "req_usr_nm", ""));
		setFtAddFlg(JSPUtil.getParameter(request, "ft_add_flg", ""));
		setExptTrfRmk(JSPUtil.getParameter(request, "expt_trf_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setAcctUsrNm(JSPUtil.getParameter(request, "acct_usr_nm", ""));
		setAcctOfcCd(JSPUtil.getParameter(request, "acct_ofc_cd", ""));
		setCvrgSeq(JSPUtil.getParameter(request, "cvrg_seq", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request, "rcv_de_term_cd", ""));
		setRgnAllCd(JSPUtil.getParameter(request, "rgn_all_cd", ""));
		setScExptFmRgnAllCd(JSPUtil.getParameter(request, "sc_expt_fm_rgn_all_cd", ""));
		setDelDt(JSPUtil.getParameter(request, "del_dt", ""));
		setUpdOfcCd(JSPUtil.getParameter(request, "upd_ofc_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRtAdjFlg(JSPUtil.getParameter(request, "rt_adj_flg", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setScExptFmCntAllNm(JSPUtil.getParameter(request, "sc_expt_fm_cnt_all_nm", ""));
		setScExptFmRgnAllNm(JSPUtil.getParameter(request, "sc_expt_fm_rgn_all_nm", ""));
		setFtFlg(JSPUtil.getParameter(request, "ft_flg", ""));
		setDmdtCntrCgoTpCd(JSPUtil.getParameter(request, "dmdt_cntr_cgo_tp_cd", ""));
		setReqOfcCd(JSPUtil.getParameter(request, "req_ofc_cd", ""));
		setFmToPairFlg(JSPUtil.getParameter(request, "fm_to_pair_flg", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setFtTir(JSPUtil.getParameter(request, "ft_tir", ""));
		setSteAllCd(JSPUtil.getParameter(request, "ste_all_cd", ""));
		setScExptFmSteCd(JSPUtil.getParameter(request, "sc_expt_fm_ste_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setScExptFmLocCd(JSPUtil.getParameter(request, "sc_expt_fm_loc_cd", ""));
		setXcldHolFlg(JSPUtil.getParameter(request, "xcld_hol_flg", ""));
		setFtAddDys(JSPUtil.getParameter(request, "ft_add_dys", ""));
		setRepCmdtFlg(JSPUtil.getParameter(request, "rep_cmdt_flg", ""));
		setCurrCvrgMulti(JSPUtil.getParameter(request, "curr_cvrg_multi", ""));
		setFnlDestRgnAllCd(JSPUtil.getParameter(request, "fnl_dest_rgn_all_cd", ""));
		setScExptFmContiCd(JSPUtil.getParameter(request, "sc_expt_fm_conti_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setLiveDt(JSPUtil.getParameter(request, "live_dt", ""));
		setFtAdjFlg(JSPUtil.getParameter(request, "ft_adj_flg", ""));
		setDeltFlg(JSPUtil.getParameter(request, "delt_flg", ""));
		setDmdtExptVerStsCd(JSPUtil.getParameter(request, "dmdt_expt_ver_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setFnlDestRgnAllNm(JSPUtil.getParameter(request, "fnl_dest_rgn_all_nm", ""));
		setReqDt(JSPUtil.getParameter(request, "req_dt", ""));
		setFnlDestRgnCd(JSPUtil.getParameter(request, "fnl_dest_rgn_cd", ""));
		setScExptFmRgnCd(JSPUtil.getParameter(request, "sc_expt_fm_rgn_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRtChk(JSPUtil.getParameter(request, "rt_chk", ""));
		setFnlDestSteAllNm(JSPUtil.getParameter(request, "fnl_dest_ste_all_nm", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setScExptFmCntAllCd(JSPUtil.getParameter(request, "sc_expt_fm_cnt_all_cd", ""));
		setDmdtFtAdjTpCd(JSPUtil.getParameter(request, "dmdt_ft_adj_tp_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setCmdtFlg(JSPUtil.getParameter(request, "cmdt_flg", ""));
		setFnlDestSteAllCd(JSPUtil.getParameter(request, "fnl_dest_ste_all_cd", ""));
		setSteAllNm(JSPUtil.getParameter(request, "ste_all_nm", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setCvrgMulti(JSPUtil.getParameter(request, "cvrg_multi", ""));
		setRgnAllNm(JSPUtil.getParameter(request, "rgn_all_nm", ""));
		setAcctDt(JSPUtil.getParameter(request, "acct_dt", ""));
		setFullExptTrfRmk(JSPUtil.getParameter(request, "full_expt_trf_rmk", ""));
		setDmdtExptVerStsDesc(JSPUtil.getParameter(request, "dmdt_expt_ver_sts_desc", ""));
		setScExptFmCntCd(JSPUtil.getParameter(request, "sc_expt_fm_cnt_cd", ""));
		setScExptGrpSeq(JSPUtil.getParameter(request, "sc_expt_grp_seq", ""));
		setFnlDestCntCd(JSPUtil.getParameter(request, "fnl_dest_cnt_cd", ""));
		setFnlDestLocCd(JSPUtil.getParameter(request, "fnl_dest_loc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setFnlDestSteCd(JSPUtil.getParameter(request, "fnl_dest_ste_cd", ""));
		setRepCmdtCd(JSPUtil.getParameter(request, "rep_cmdt_cd", ""));
		setNewFlg(JSPUtil.getParameter(request, "new_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCExceptionVO[]
	 */
	public SCExceptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCExceptionVO[]
	 */
	public SCExceptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCExceptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] xcldSunFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sun_flg", length));
			String[] xcldSatFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_sat_flg", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] ftTotDys = (JSPUtil.getParameter(request, prefix	+ "ft_tot_dys", length));
			String[] actCustFlg = (JSPUtil.getParameter(request, prefix	+ "act_cust_flg", length));
			String[] scExptFmSteAllNm = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_ste_all_nm", length));
			String[] rtChkFlg = (JSPUtil.getParameter(request, prefix	+ "rt_chk_flg", length));
			String[] scExptFmSteAllCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_ste_all_cd", length));
			String[] scExptVerSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_ver_seq", length));
			String[] reqUsrNm = (JSPUtil.getParameter(request, prefix	+ "req_usr_nm", length));
			String[] ftAddFlg = (JSPUtil.getParameter(request, prefix	+ "ft_add_flg", length));
			String[] exptTrfRmk = (JSPUtil.getParameter(request, prefix	+ "expt_trf_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] acctUsrNm = (JSPUtil.getParameter(request, prefix	+ "acct_usr_nm", length));
			String[] acctOfcCd = (JSPUtil.getParameter(request, prefix	+ "acct_ofc_cd", length));
			String[] cvrgSeq = (JSPUtil.getParameter(request, prefix	+ "cvrg_seq", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] rcvDeTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_de_term_cd", length));
			String[] rgnAllCd = (JSPUtil.getParameter(request, prefix	+ "rgn_all_cd", length));
			String[] scExptFmRgnAllCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_rgn_all_cd", length));
			String[] delDt = (JSPUtil.getParameter(request, prefix	+ "del_dt", length));
			String[] updOfcCd = (JSPUtil.getParameter(request, prefix	+ "upd_ofc_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rtAdjFlg = (JSPUtil.getParameter(request, prefix	+ "rt_adj_flg", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] scExptFmCntAllNm = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_cnt_all_nm", length));
			String[] scExptFmRgnAllNm = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_rgn_all_nm", length));
			String[] ftFlg = (JSPUtil.getParameter(request, prefix	+ "ft_flg", length));
			String[] dmdtCntrCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_cntr_cgo_tp_cd", length));
			String[] reqOfcCd = (JSPUtil.getParameter(request, prefix	+ "req_ofc_cd", length));
			String[] fmToPairFlg = (JSPUtil.getParameter(request, prefix	+ "fm_to_pair_flg", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] ftTir = (JSPUtil.getParameter(request, prefix	+ "ft_tir", length));
			String[] steAllCd = (JSPUtil.getParameter(request, prefix	+ "ste_all_cd", length));
			String[] scExptFmSteCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_ste_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] scExptFmLocCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_loc_cd", length));
			String[] xcldHolFlg = (JSPUtil.getParameter(request, prefix	+ "xcld_hol_flg", length));
			String[] ftAddDys = (JSPUtil.getParameter(request, prefix	+ "ft_add_dys", length));
			String[] repCmdtFlg = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_flg", length));
			String[] currCvrgMulti = (JSPUtil.getParameter(request, prefix	+ "curr_cvrg_multi", length));
			String[] fnlDestRgnAllCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_rgn_all_cd", length));
			String[] scExptFmContiCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_conti_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] liveDt = (JSPUtil.getParameter(request, prefix	+ "live_dt", length));
			String[] ftAdjFlg = (JSPUtil.getParameter(request, prefix	+ "ft_adj_flg", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] dmdtExptVerStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_ver_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] fnlDestRgnAllNm = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_rgn_all_nm", length));
			String[] reqDt = (JSPUtil.getParameter(request, prefix	+ "req_dt", length));
			String[] fnlDestRgnCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_rgn_cd", length));
			String[] scExptFmRgnCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_rgn_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtChk = (JSPUtil.getParameter(request, prefix	+ "rt_chk", length));
			String[] fnlDestSteAllNm = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_ste_all_nm", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] scExptFmCntAllCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_cnt_all_cd", length));
			String[] dmdtFtAdjTpCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_ft_adj_tp_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] cmdtFlg = (JSPUtil.getParameter(request, prefix	+ "cmdt_flg", length));
			String[] fnlDestSteAllCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_ste_all_cd", length));
			String[] steAllNm = (JSPUtil.getParameter(request, prefix	+ "ste_all_nm", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] cvrgMulti = (JSPUtil.getParameter(request, prefix	+ "cvrg_multi", length));
			String[] rgnAllNm = (JSPUtil.getParameter(request, prefix	+ "rgn_all_nm", length));
			String[] acctDt = (JSPUtil.getParameter(request, prefix	+ "acct_dt", length));
			String[] fullExptTrfRmk = (JSPUtil.getParameter(request, prefix	+ "full_expt_trf_rmk", length));
			String[] dmdtExptVerStsDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_ver_sts_desc", length));
			String[] scExptFmCntCd = (JSPUtil.getParameter(request, prefix	+ "sc_expt_fm_cnt_cd", length));
			String[] scExptGrpSeq = (JSPUtil.getParameter(request, prefix	+ "sc_expt_grp_seq", length));
			String[] fnlDestCntCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_cnt_cd", length));
			String[] fnlDestLocCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_loc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] fnlDestSteCd = (JSPUtil.getParameter(request, prefix	+ "fnl_dest_ste_cd", length));
			String[] repCmdtCd = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_cd", length));
			String[] newFlg = (JSPUtil.getParameter(request, prefix	+ "new_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new SCExceptionVO();
				if (xcldSunFlg[i] != null)
					model.setXcldSunFlg(xcldSunFlg[i]);
				if (xcldSatFlg[i] != null)
					model.setXcldSatFlg(xcldSatFlg[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (ftTotDys[i] != null)
					model.setFtTotDys(ftTotDys[i]);
				if (actCustFlg[i] != null)
					model.setActCustFlg(actCustFlg[i]);
				if (scExptFmSteAllNm[i] != null)
					model.setScExptFmSteAllNm(scExptFmSteAllNm[i]);
				if (rtChkFlg[i] != null)
					model.setRtChkFlg(rtChkFlg[i]);
				if (scExptFmSteAllCd[i] != null)
					model.setScExptFmSteAllCd(scExptFmSteAllCd[i]);
				if (scExptVerSeq[i] != null)
					model.setScExptVerSeq(scExptVerSeq[i]);
				if (reqUsrNm[i] != null)
					model.setReqUsrNm(reqUsrNm[i]);
				if (ftAddFlg[i] != null)
					model.setFtAddFlg(ftAddFlg[i]);
				if (exptTrfRmk[i] != null)
					model.setExptTrfRmk(exptTrfRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (acctUsrNm[i] != null)
					model.setAcctUsrNm(acctUsrNm[i]);
				if (acctOfcCd[i] != null)
					model.setAcctOfcCd(acctOfcCd[i]);
				if (cvrgSeq[i] != null)
					model.setCvrgSeq(cvrgSeq[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (rcvDeTermCd[i] != null)
					model.setRcvDeTermCd(rcvDeTermCd[i]);
				if (rgnAllCd[i] != null)
					model.setRgnAllCd(rgnAllCd[i]);
				if (scExptFmRgnAllCd[i] != null)
					model.setScExptFmRgnAllCd(scExptFmRgnAllCd[i]);
				if (delDt[i] != null)
					model.setDelDt(delDt[i]);
				if (updOfcCd[i] != null)
					model.setUpdOfcCd(updOfcCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rtAdjFlg[i] != null)
					model.setRtAdjFlg(rtAdjFlg[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (scExptFmCntAllNm[i] != null)
					model.setScExptFmCntAllNm(scExptFmCntAllNm[i]);
				if (scExptFmRgnAllNm[i] != null)
					model.setScExptFmRgnAllNm(scExptFmRgnAllNm[i]);
				if (ftFlg[i] != null)
					model.setFtFlg(ftFlg[i]);
				if (dmdtCntrCgoTpCd[i] != null)
					model.setDmdtCntrCgoTpCd(dmdtCntrCgoTpCd[i]);
				if (reqOfcCd[i] != null)
					model.setReqOfcCd(reqOfcCd[i]);
				if (fmToPairFlg[i] != null)
					model.setFmToPairFlg(fmToPairFlg[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (ftTir[i] != null)
					model.setFtTir(ftTir[i]);
				if (steAllCd[i] != null)
					model.setSteAllCd(steAllCd[i]);
				if (scExptFmSteCd[i] != null)
					model.setScExptFmSteCd(scExptFmSteCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (scExptFmLocCd[i] != null)
					model.setScExptFmLocCd(scExptFmLocCd[i]);
				if (xcldHolFlg[i] != null)
					model.setXcldHolFlg(xcldHolFlg[i]);
				if (ftAddDys[i] != null)
					model.setFtAddDys(ftAddDys[i]);
				if (repCmdtFlg[i] != null)
					model.setRepCmdtFlg(repCmdtFlg[i]);
				if (currCvrgMulti[i] != null)
					model.setCurrCvrgMulti(currCvrgMulti[i]);
				if (fnlDestRgnAllCd[i] != null)
					model.setFnlDestRgnAllCd(fnlDestRgnAllCd[i]);
				if (scExptFmContiCd[i] != null)
					model.setScExptFmContiCd(scExptFmContiCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (liveDt[i] != null)
					model.setLiveDt(liveDt[i]);
				if (ftAdjFlg[i] != null)
					model.setFtAdjFlg(ftAdjFlg[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (dmdtExptVerStsCd[i] != null)
					model.setDmdtExptVerStsCd(dmdtExptVerStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (fnlDestRgnAllNm[i] != null)
					model.setFnlDestRgnAllNm(fnlDestRgnAllNm[i]);
				if (reqDt[i] != null)
					model.setReqDt(reqDt[i]);
				if (fnlDestRgnCd[i] != null)
					model.setFnlDestRgnCd(fnlDestRgnCd[i]);
				if (scExptFmRgnCd[i] != null)
					model.setScExptFmRgnCd(scExptFmRgnCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtChk[i] != null)
					model.setRtChk(rtChk[i]);
				if (fnlDestSteAllNm[i] != null)
					model.setFnlDestSteAllNm(fnlDestSteAllNm[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (scExptFmCntAllCd[i] != null)
					model.setScExptFmCntAllCd(scExptFmCntAllCd[i]);
				if (dmdtFtAdjTpCd[i] != null)
					model.setDmdtFtAdjTpCd(dmdtFtAdjTpCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (cmdtFlg[i] != null)
					model.setCmdtFlg(cmdtFlg[i]);
				if (fnlDestSteAllCd[i] != null)
					model.setFnlDestSteAllCd(fnlDestSteAllCd[i]);
				if (steAllNm[i] != null)
					model.setSteAllNm(steAllNm[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (cvrgMulti[i] != null)
					model.setCvrgMulti(cvrgMulti[i]);
				if (rgnAllNm[i] != null)
					model.setRgnAllNm(rgnAllNm[i]);
				if (acctDt[i] != null)
					model.setAcctDt(acctDt[i]);
				if (fullExptTrfRmk[i] != null)
					model.setFullExptTrfRmk(fullExptTrfRmk[i]);
				if (dmdtExptVerStsDesc[i] != null)
					model.setDmdtExptVerStsDesc(dmdtExptVerStsDesc[i]);
				if (scExptFmCntCd[i] != null)
					model.setScExptFmCntCd(scExptFmCntCd[i]);
				if (scExptGrpSeq[i] != null)
					model.setScExptGrpSeq(scExptGrpSeq[i]);
				if (fnlDestCntCd[i] != null)
					model.setFnlDestCntCd(fnlDestCntCd[i]);
				if (fnlDestLocCd[i] != null)
					model.setFnlDestLocCd(fnlDestLocCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (fnlDestSteCd[i] != null)
					model.setFnlDestSteCd(fnlDestSteCd[i]);
				if (repCmdtCd[i] != null)
					model.setRepCmdtCd(repCmdtCd[i]);
				if (newFlg[i] != null)
					model.setNewFlg(newFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCExceptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCExceptionVO[]
	 */
	public SCExceptionVO[] getSCExceptionVOs(){
		SCExceptionVO[] vos = (SCExceptionVO[])models.toArray(new SCExceptionVO[models.size()]);
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
		this.xcldSunFlg = this.xcldSunFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldSatFlg = this.xcldSatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftTotDys = this.ftTotDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustFlg = this.actCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmSteAllNm = this.scExptFmSteAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtChkFlg = this.rtChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmSteAllCd = this.scExptFmSteAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptVerSeq = this.scExptVerSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqUsrNm = this.reqUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddFlg = this.ftAddFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptTrfRmk = this.exptTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctUsrNm = this.acctUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctOfcCd = this.acctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgSeq = this.cvrgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd = this.rcvDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnAllCd = this.rgnAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmRgnAllCd = this.scExptFmRgnAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDt = this.delDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updOfcCd = this.updOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAdjFlg = this.rtAdjFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmCntAllNm = this.scExptFmCntAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmRgnAllNm = this.scExptFmRgnAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftFlg = this.ftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtCntrCgoTpCd = this.dmdtCntrCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqOfcCd = this.reqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmToPairFlg = this.fmToPairFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftTir = this.ftTir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steAllCd = this.steAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmSteCd = this.scExptFmSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmLocCd = this.scExptFmLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xcldHolFlg = this.xcldHolFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddDys = this.ftAddDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtFlg = this.repCmdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCvrgMulti = this.currCvrgMulti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestRgnAllCd = this.fnlDestRgnAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmContiCd = this.scExptFmContiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.liveDt = this.liveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAdjFlg = this.ftAdjFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptVerStsCd = this.dmdtExptVerStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestRgnAllNm = this.fnlDestRgnAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqDt = this.reqDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestRgnCd = this.fnlDestRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmRgnCd = this.scExptFmRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtChk = this.rtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestSteAllNm = this.fnlDestSteAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmCntAllCd = this.scExptFmCntAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtFtAdjTpCd = this.dmdtFtAdjTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtFlg = this.cmdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestSteAllCd = this.fnlDestSteAllCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steAllNm = this.steAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrgMulti = this.cvrgMulti .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnAllNm = this.rgnAllNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDt = this.acctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullExptTrfRmk = this.fullExptTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptVerStsDesc = this.dmdtExptVerStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptFmCntCd = this.scExptFmCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExptGrpSeq = this.scExptGrpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestCntCd = this.fnlDestCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestLocCd = this.fnlDestLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlDestSteCd = this.fnlDestSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtCd = this.repCmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newFlg = this.newFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
