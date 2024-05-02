/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MultiRateBkgList1VO.java
*@FileTitle : MultiRateBkgList1VO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.12.01
*@LastModifier : 
*@LastVersion : 1.0
* 2017.12.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.vo;

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

public class MultiRateBkgList1VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MultiRateBkgList1VO> models = new ArrayList<MultiRateBkgList1VO>();
	
	/* Column Info */
	private String podDelEquals = null;
	/* Column Info */
	private String prcRtMtchPattCd2 = null;
	/* Column Info */
	private String multiCntr = null;
	/* Column Info */
	private String prcRtMtchPattCd1 = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String fnlFrtRtAmt1 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String oftCnt = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String fnlFrtRtAmt2 = null;
	/* Column Info */
	private String usrUpdCfmFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String tVvd = null;
	/* Column Info */
	private String blCnt = null;
	/* Column Info */
	private String actCust = null;
	/* Column Info */
	private String prcCgoTpCd = null;
	/* Column Info */
	private String porPolEquals = null;
	/* Column Info */
	private String cmdtNm1 = null;
	/* Column Info */
	private String cmdtNm2 = null;
	/* Column Info */
	private String cfmDt = null;
	/* Column Info */
	private String sglMltCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String plsZrMnusCd2 = null;
	/* Column Info */
	private String plsZrMnusCd1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String plsZrMnusCd3 = null;
	/* Column Info */
	private String dtType = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String usrUpdCtnt = null;
	/* Column Info */
	private String prcCgoTpCd2 = null;
	/* Column Info */
	private String smPrime = null;
	/* Column Info */
	private String prcCgoTpCd1 = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String noteCtnt2 = null;
	/* Column Info */
	private String noteCtnt1 = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String usrInsAmt = null;
	/* Column Info */
	private String rctRhqCd = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String ratUtCd1 = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String ratUtCd2 = null;
	/* Column Info */
	private String tpszCnt = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String psaNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MultiRateBkgList1VO() {}

	public MultiRateBkgList1VO(String ibflag, String pagerows, String bkgNo, String sglMltCd, String oftCnt, String tpszCnt, String rctRhqCd, String bkgOfcCd, String svcScpCd, String rtAplyDt, String bkgCreDt, String vpsEtdDt, String bdrFlg, String bkgCtrtTpCd, String ctrtNo, String cmdtCd, String cmdtNm, String prcCgoTpCd, String porCd, String polCd, String podCd, String delCd, String tVvd, String porPolEquals, String podDelEquals, String multiCntr, String prcRtMtchPattCd1, String cmdtNm1, String ratUtCd1, String prcCgoTpCd1, String fnlFrtRtAmt1, String noteCtnt1, String prcRtMtchPattCd2, String cmdtNm2, String ratUtCd2, String prcCgoTpCd2, String fnlFrtRtAmt2, String noteCtnt2, String ratAsQty, String chgUtAmt, String plsZrMnusCd1, String plsZrMnusCd2, String plsZrMnusCd3, String psaNo, String smPrime, String actCust, String usrUpdCtnt, String usrInsAmt, String usrUpdCfmFlg, String cfmDt, String updDt, String updUsrId, String blCnt, String dtType, String fromDt, String toDt) {
		this.podDelEquals = podDelEquals;
		this.prcRtMtchPattCd2 = prcRtMtchPattCd2;
		this.multiCntr = multiCntr;
		this.prcRtMtchPattCd1 = prcRtMtchPattCd1;
		this.bkgNo = bkgNo;
		this.fnlFrtRtAmt1 = fnlFrtRtAmt1;
		this.updUsrId = updUsrId;
		this.oftCnt = oftCnt;
		this.ctrtNo = ctrtNo;
		this.fnlFrtRtAmt2 = fnlFrtRtAmt2;
		this.usrUpdCfmFlg = usrUpdCfmFlg;
		this.pagerows = pagerows;
		this.bdrFlg = bdrFlg;
		this.tVvd = tVvd;
		this.blCnt = blCnt;
		this.actCust = actCust;
		this.prcCgoTpCd = prcCgoTpCd;
		this.porPolEquals = porPolEquals;
		this.cmdtNm1 = cmdtNm1;
		this.cmdtNm2 = cmdtNm2;
		this.cfmDt = cfmDt;
		this.sglMltCd = sglMltCd;
		this.updDt = updDt;
		this.ratAsQty = ratAsQty;
		this.plsZrMnusCd2 = plsZrMnusCd2;
		this.plsZrMnusCd1 = plsZrMnusCd1;
		this.ibflag = ibflag;
		this.plsZrMnusCd3 = plsZrMnusCd3;
		this.dtType = dtType;
		this.cmdtNm = cmdtNm;
		this.vpsEtdDt = vpsEtdDt;
		this.porCd = porCd;
		this.usrUpdCtnt = usrUpdCtnt;
		this.prcCgoTpCd2 = prcCgoTpCd2;
		this.smPrime = smPrime;
		this.prcCgoTpCd1 = prcCgoTpCd1;
		this.polCd = polCd;
		this.fromDt = fromDt;
		this.noteCtnt2 = noteCtnt2;
		this.noteCtnt1 = noteCtnt1;
		this.svcScpCd = svcScpCd;
		this.podCd = podCd;
		this.toDt = toDt;
		this.chgUtAmt = chgUtAmt;
		this.cmdtCd = cmdtCd;
		this.usrInsAmt = usrInsAmt;
		this.rctRhqCd = rctRhqCd;
		this.rtAplyDt = rtAplyDt;
		this.ratUtCd1 = ratUtCd1;
		this.bkgOfcCd = bkgOfcCd;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.ratUtCd2 = ratUtCd2;
		this.tpszCnt = tpszCnt;
		this.delCd = delCd;
		this.bkgCreDt = bkgCreDt;
		this.psaNo = psaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pod_del_equals", getPodDelEquals());
		this.hashColumns.put("prc_rt_mtch_patt_cd_2", getPrcRtMtchPattCd2());
		this.hashColumns.put("multi_cntr", getMultiCntr());
		this.hashColumns.put("prc_rt_mtch_patt_cd_1", getPrcRtMtchPattCd1());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fnl_frt_rt_amt_1", getFnlFrtRtAmt1());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("oft_cnt", getOftCnt());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("fnl_frt_rt_amt_2", getFnlFrtRtAmt2());
		this.hashColumns.put("usr_upd_cfm_flg", getUsrUpdCfmFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("t_vvd", getTVvd());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("act_cust", getActCust());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("por_pol_equals", getPorPolEquals());
		this.hashColumns.put("cmdt_nm_1", getCmdtNm1());
		this.hashColumns.put("cmdt_nm_2", getCmdtNm2());
		this.hashColumns.put("cfm_dt", getCfmDt());
		this.hashColumns.put("sgl_mlt_cd", getSglMltCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("pls_zr_mnus_cd_2", getPlsZrMnusCd2());
		this.hashColumns.put("pls_zr_mnus_cd_1", getPlsZrMnusCd1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pls_zr_mnus_cd_3", getPlsZrMnusCd3());
		this.hashColumns.put("dt_type", getDtType());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("usr_upd_ctnt", getUsrUpdCtnt());
		this.hashColumns.put("prc_cgo_tp_cd_2", getPrcCgoTpCd2());
		this.hashColumns.put("sm_prime", getSmPrime());
		this.hashColumns.put("prc_cgo_tp_cd_1", getPrcCgoTpCd1());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("note_ctnt_2", getNoteCtnt2());
		this.hashColumns.put("note_ctnt_1", getNoteCtnt1());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("usr_ins_amt", getUsrInsAmt());
		this.hashColumns.put("rct_rhq_cd", getRctRhqCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("rat_ut_cd_1", getRatUtCd1());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("rat_ut_cd_2", getRatUtCd2());
		this.hashColumns.put("tpsz_cnt", getTpszCnt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("psa_no", getPsaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pod_del_equals", "podDelEquals");
		this.hashFields.put("prc_rt_mtch_patt_cd_2", "prcRtMtchPattCd2");
		this.hashFields.put("multi_cntr", "multiCntr");
		this.hashFields.put("prc_rt_mtch_patt_cd_1", "prcRtMtchPattCd1");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fnl_frt_rt_amt_1", "fnlFrtRtAmt1");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("oft_cnt", "oftCnt");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("fnl_frt_rt_amt_2", "fnlFrtRtAmt2");
		this.hashFields.put("usr_upd_cfm_flg", "usrUpdCfmFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("t_vvd", "tVvd");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("act_cust", "actCust");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("por_pol_equals", "porPolEquals");
		this.hashFields.put("cmdt_nm_1", "cmdtNm1");
		this.hashFields.put("cmdt_nm_2", "cmdtNm2");
		this.hashFields.put("cfm_dt", "cfmDt");
		this.hashFields.put("sgl_mlt_cd", "sglMltCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("pls_zr_mnus_cd_2", "plsZrMnusCd2");
		this.hashFields.put("pls_zr_mnus_cd_1", "plsZrMnusCd1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pls_zr_mnus_cd_3", "plsZrMnusCd3");
		this.hashFields.put("dt_type", "dtType");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("usr_upd_ctnt", "usrUpdCtnt");
		this.hashFields.put("prc_cgo_tp_cd_2", "prcCgoTpCd2");
		this.hashFields.put("sm_prime", "smPrime");
		this.hashFields.put("prc_cgo_tp_cd_1", "prcCgoTpCd1");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("note_ctnt_2", "noteCtnt2");
		this.hashFields.put("note_ctnt_1", "noteCtnt1");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("usr_ins_amt", "usrInsAmt");
		this.hashFields.put("rct_rhq_cd", "rctRhqCd");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("rat_ut_cd_1", "ratUtCd1");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("rat_ut_cd_2", "ratUtCd2");
		this.hashFields.put("tpsz_cnt", "tpszCnt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("psa_no", "psaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return podDelEquals
	 */
	public String getPodDelEquals() {
		return this.podDelEquals;
	}
	
	/**
	 * Column Info
	 * @return prcRtMtchPattCd2
	 */
	public String getPrcRtMtchPattCd2() {
		return this.prcRtMtchPattCd2;
	}
	
	/**
	 * Column Info
	 * @return multiCntr
	 */
	public String getMultiCntr() {
		return this.multiCntr;
	}
	
	/**
	 * Column Info
	 * @return prcRtMtchPattCd1
	 */
	public String getPrcRtMtchPattCd1() {
		return this.prcRtMtchPattCd1;
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
	 * @return fnlFrtRtAmt1
	 */
	public String getFnlFrtRtAmt1() {
		return this.fnlFrtRtAmt1;
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
	 * @return oftCnt
	 */
	public String getOftCnt() {
		return this.oftCnt;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return fnlFrtRtAmt2
	 */
	public String getFnlFrtRtAmt2() {
		return this.fnlFrtRtAmt2;
	}
	
	/**
	 * Column Info
	 * @return usrUpdCfmFlg
	 */
	public String getUsrUpdCfmFlg() {
		return this.usrUpdCfmFlg;
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
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return tVvd
	 */
	public String getTVvd() {
		return this.tVvd;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	
	/**
	 * Column Info
	 * @return actCust
	 */
	public String getActCust() {
		return this.actCust;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public String getPrcCgoTpCd() {
		return this.prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return porPolEquals
	 */
	public String getPorPolEquals() {
		return this.porPolEquals;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm1
	 */
	public String getCmdtNm1() {
		return this.cmdtNm1;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm2
	 */
	public String getCmdtNm2() {
		return this.cmdtNm2;
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
	 * @return sglMltCd
	 */
	public String getSglMltCd() {
		return this.sglMltCd;
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
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return plsZrMnusCd2
	 */
	public String getPlsZrMnusCd2() {
		return this.plsZrMnusCd2;
	}
	
	/**
	 * Column Info
	 * @return plsZrMnusCd1
	 */
	public String getPlsZrMnusCd1() {
		return this.plsZrMnusCd1;
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
	 * @return plsZrMnusCd3
	 */
	public String getPlsZrMnusCd3() {
		return this.plsZrMnusCd3;
	}
	
	/**
	 * Column Info
	 * @return dtType
	 */
	public String getDtType() {
		return this.dtType;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
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
	 * @return usrUpdCtnt
	 */
	public String getUsrUpdCtnt() {
		return this.usrUpdCtnt;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd2
	 */
	public String getPrcCgoTpCd2() {
		return this.prcCgoTpCd2;
	}
	
	/**
	 * Column Info
	 * @return smPrime
	 */
	public String getSmPrime() {
		return this.smPrime;
	}
	
	/**
	 * Column Info
	 * @return prcCgoTpCd1
	 */
	public String getPrcCgoTpCd1() {
		return this.prcCgoTpCd1;
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
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return noteCtnt2
	 */
	public String getNoteCtnt2() {
		return this.noteCtnt2;
	}
	
	/**
	 * Column Info
	 * @return noteCtnt1
	 */
	public String getNoteCtnt1() {
		return this.noteCtnt1;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return usrInsAmt
	 */
	public String getUsrInsAmt() {
		return this.usrInsAmt;
	}
	
	/**
	 * Column Info
	 * @return rctRhqCd
	 */
	public String getRctRhqCd() {
		return this.rctRhqCd;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd1
	 */
	public String getRatUtCd1() {
		return this.ratUtCd1;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd2
	 */
	public String getRatUtCd2() {
		return this.ratUtCd2;
	}
	
	/**
	 * Column Info
	 * @return tpszCnt
	 */
	public String getTpszCnt() {
		return this.tpszCnt;
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
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @return psaNo
	 */
	public String getPsaNo() {
		return this.psaNo;
	}
	

	/**
	 * Column Info
	 * @param podDelEquals
	 */
	public void setPodDelEquals(String podDelEquals) {
		this.podDelEquals = podDelEquals;
	}
	
	/**
	 * Column Info
	 * @param prcRtMtchPattCd2
	 */
	public void setPrcRtMtchPattCd2(String prcRtMtchPattCd2) {
		this.prcRtMtchPattCd2 = prcRtMtchPattCd2;
	}
	
	/**
	 * Column Info
	 * @param multiCntr
	 */
	public void setMultiCntr(String multiCntr) {
		this.multiCntr = multiCntr;
	}
	
	/**
	 * Column Info
	 * @param prcRtMtchPattCd1
	 */
	public void setPrcRtMtchPattCd1(String prcRtMtchPattCd1) {
		this.prcRtMtchPattCd1 = prcRtMtchPattCd1;
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
	 * @param fnlFrtRtAmt1
	 */
	public void setFnlFrtRtAmt1(String fnlFrtRtAmt1) {
		this.fnlFrtRtAmt1 = fnlFrtRtAmt1;
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
	 * @param oftCnt
	 */
	public void setOftCnt(String oftCnt) {
		this.oftCnt = oftCnt;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param fnlFrtRtAmt2
	 */
	public void setFnlFrtRtAmt2(String fnlFrtRtAmt2) {
		this.fnlFrtRtAmt2 = fnlFrtRtAmt2;
	}
	
	/**
	 * Column Info
	 * @param usrUpdCfmFlg
	 */
	public void setUsrUpdCfmFlg(String usrUpdCfmFlg) {
		this.usrUpdCfmFlg = usrUpdCfmFlg;
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
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param tVvd
	 */
	public void setTVvd(String tVvd) {
		this.tVvd = tVvd;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
	}
	
	/**
	 * Column Info
	 * @param actCust
	 */
	public void setActCust(String actCust) {
		this.actCust = actCust;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd
	 */
	public void setPrcCgoTpCd(String prcCgoTpCd) {
		this.prcCgoTpCd = prcCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param porPolEquals
	 */
	public void setPorPolEquals(String porPolEquals) {
		this.porPolEquals = porPolEquals;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm1
	 */
	public void setCmdtNm1(String cmdtNm1) {
		this.cmdtNm1 = cmdtNm1;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm2
	 */
	public void setCmdtNm2(String cmdtNm2) {
		this.cmdtNm2 = cmdtNm2;
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
	 * @param sglMltCd
	 */
	public void setSglMltCd(String sglMltCd) {
		this.sglMltCd = sglMltCd;
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
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param plsZrMnusCd2
	 */
	public void setPlsZrMnusCd2(String plsZrMnusCd2) {
		this.plsZrMnusCd2 = plsZrMnusCd2;
	}
	
	/**
	 * Column Info
	 * @param plsZrMnusCd1
	 */
	public void setPlsZrMnusCd1(String plsZrMnusCd1) {
		this.plsZrMnusCd1 = plsZrMnusCd1;
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
	 * @param plsZrMnusCd3
	 */
	public void setPlsZrMnusCd3(String plsZrMnusCd3) {
		this.plsZrMnusCd3 = plsZrMnusCd3;
	}
	
	/**
	 * Column Info
	 * @param dtType
	 */
	public void setDtType(String dtType) {
		this.dtType = dtType;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
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
	 * @param usrUpdCtnt
	 */
	public void setUsrUpdCtnt(String usrUpdCtnt) {
		this.usrUpdCtnt = usrUpdCtnt;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd2
	 */
	public void setPrcCgoTpCd2(String prcCgoTpCd2) {
		this.prcCgoTpCd2 = prcCgoTpCd2;
	}
	
	/**
	 * Column Info
	 * @param smPrime
	 */
	public void setSmPrime(String smPrime) {
		this.smPrime = smPrime;
	}
	
	/**
	 * Column Info
	 * @param prcCgoTpCd1
	 */
	public void setPrcCgoTpCd1(String prcCgoTpCd1) {
		this.prcCgoTpCd1 = prcCgoTpCd1;
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
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param noteCtnt2
	 */
	public void setNoteCtnt2(String noteCtnt2) {
		this.noteCtnt2 = noteCtnt2;
	}
	
	/**
	 * Column Info
	 * @param noteCtnt1
	 */
	public void setNoteCtnt1(String noteCtnt1) {
		this.noteCtnt1 = noteCtnt1;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param usrInsAmt
	 */
	public void setUsrInsAmt(String usrInsAmt) {
		this.usrInsAmt = usrInsAmt;
	}
	
	/**
	 * Column Info
	 * @param rctRhqCd
	 */
	public void setRctRhqCd(String rctRhqCd) {
		this.rctRhqCd = rctRhqCd;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd1
	 */
	public void setRatUtCd1(String ratUtCd1) {
		this.ratUtCd1 = ratUtCd1;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd2
	 */
	public void setRatUtCd2(String ratUtCd2) {
		this.ratUtCd2 = ratUtCd2;
	}
	
	/**
	 * Column Info
	 * @param tpszCnt
	 */
	public void setTpszCnt(String tpszCnt) {
		this.tpszCnt = tpszCnt;
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
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @param psaNo
	 */
	public void setPsaNo(String psaNo) {
		this.psaNo = psaNo;
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
		setPodDelEquals(JSPUtil.getParameter(request, prefix + "pod_del_equals", ""));
		setPrcRtMtchPattCd2(JSPUtil.getParameter(request, prefix + "prc_rt_mtch_patt_cd_2", ""));
		setMultiCntr(JSPUtil.getParameter(request, prefix + "multi_cntr", ""));
		setPrcRtMtchPattCd1(JSPUtil.getParameter(request, prefix + "prc_rt_mtch_patt_cd_1", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFnlFrtRtAmt1(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt_1", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOftCnt(JSPUtil.getParameter(request, prefix + "oft_cnt", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setFnlFrtRtAmt2(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt_2", ""));
		setUsrUpdCfmFlg(JSPUtil.getParameter(request, prefix + "usr_upd_cfm_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setTVvd(JSPUtil.getParameter(request, prefix + "t_vvd", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		setActCust(JSPUtil.getParameter(request, prefix + "act_cust", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd", ""));
		setPorPolEquals(JSPUtil.getParameter(request, prefix + "por_pol_equals", ""));
		setCmdtNm1(JSPUtil.getParameter(request, prefix + "cmdt_nm_1", ""));
		setCmdtNm2(JSPUtil.getParameter(request, prefix + "cmdt_nm_2", ""));
		setCfmDt(JSPUtil.getParameter(request, prefix + "cfm_dt", ""));
		setSglMltCd(JSPUtil.getParameter(request, prefix + "sgl_mlt_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
		setPlsZrMnusCd2(JSPUtil.getParameter(request, prefix + "pls_zr_mnus_cd_2", ""));
		setPlsZrMnusCd1(JSPUtil.getParameter(request, prefix + "pls_zr_mnus_cd_1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPlsZrMnusCd3(JSPUtil.getParameter(request, prefix + "pls_zr_mnus_cd_3", ""));
		setDtType(JSPUtil.getParameter(request, prefix + "dt_type", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setUsrUpdCtnt(JSPUtil.getParameter(request, prefix + "usr_upd_ctnt", ""));
		setPrcCgoTpCd2(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd_2", ""));
		setSmPrime(JSPUtil.getParameter(request, prefix + "sm_prime", ""));
		setPrcCgoTpCd1(JSPUtil.getParameter(request, prefix + "prc_cgo_tp_cd_1", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setNoteCtnt2(JSPUtil.getParameter(request, prefix + "note_ctnt_2", ""));
		setNoteCtnt1(JSPUtil.getParameter(request, prefix + "note_ctnt_1", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setUsrInsAmt(JSPUtil.getParameter(request, prefix + "usr_ins_amt", ""));
		setRctRhqCd(JSPUtil.getParameter(request, prefix + "rct_rhq_cd", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setRatUtCd1(JSPUtil.getParameter(request, prefix + "rat_ut_cd_1", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setRatUtCd2(JSPUtil.getParameter(request, prefix + "rat_ut_cd_2", ""));
		setTpszCnt(JSPUtil.getParameter(request, prefix + "tpsz_cnt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setPsaNo(JSPUtil.getParameter(request, prefix + "psa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MultiRateBkgList1VO[]
	 */
	public MultiRateBkgList1VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MultiRateBkgList1VO[]
	 */
	public MultiRateBkgList1VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MultiRateBkgList1VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] podDelEquals = (JSPUtil.getParameter(request, prefix	+ "pod_del_equals", length));
			String[] prcRtMtchPattCd2 = (JSPUtil.getParameter(request, prefix	+ "prc_rt_mtch_patt_cd_2", length));
			String[] multiCntr = (JSPUtil.getParameter(request, prefix	+ "multi_cntr", length));
			String[] prcRtMtchPattCd1 = (JSPUtil.getParameter(request, prefix	+ "prc_rt_mtch_patt_cd_1", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] fnlFrtRtAmt1 = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt_1", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] oftCnt = (JSPUtil.getParameter(request, prefix	+ "oft_cnt", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] fnlFrtRtAmt2 = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt_2", length));
			String[] usrUpdCfmFlg = (JSPUtil.getParameter(request, prefix	+ "usr_upd_cfm_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] tVvd = (JSPUtil.getParameter(request, prefix	+ "t_vvd", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] actCust = (JSPUtil.getParameter(request, prefix	+ "act_cust", length));
			String[] prcCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd", length));
			String[] porPolEquals = (JSPUtil.getParameter(request, prefix	+ "por_pol_equals", length));
			String[] cmdtNm1 = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm_1", length));
			String[] cmdtNm2 = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm_2", length));
			String[] cfmDt = (JSPUtil.getParameter(request, prefix	+ "cfm_dt", length));
			String[] sglMltCd = (JSPUtil.getParameter(request, prefix	+ "sgl_mlt_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] plsZrMnusCd2 = (JSPUtil.getParameter(request, prefix	+ "pls_zr_mnus_cd_2", length));
			String[] plsZrMnusCd1 = (JSPUtil.getParameter(request, prefix	+ "pls_zr_mnus_cd_1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] plsZrMnusCd3 = (JSPUtil.getParameter(request, prefix	+ "pls_zr_mnus_cd_3", length));
			String[] dtType = (JSPUtil.getParameter(request, prefix	+ "dt_type", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] usrUpdCtnt = (JSPUtil.getParameter(request, prefix	+ "usr_upd_ctnt", length));
			String[] prcCgoTpCd2 = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd_2", length));
			String[] smPrime = (JSPUtil.getParameter(request, prefix	+ "sm_prime", length));
			String[] prcCgoTpCd1 = (JSPUtil.getParameter(request, prefix	+ "prc_cgo_tp_cd_1", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] noteCtnt2 = (JSPUtil.getParameter(request, prefix	+ "note_ctnt_2", length));
			String[] noteCtnt1 = (JSPUtil.getParameter(request, prefix	+ "note_ctnt_1", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] usrInsAmt = (JSPUtil.getParameter(request, prefix	+ "usr_ins_amt", length));
			String[] rctRhqCd = (JSPUtil.getParameter(request, prefix	+ "rct_rhq_cd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] ratUtCd1 = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd_1", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] ratUtCd2 = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd_2", length));
			String[] tpszCnt = (JSPUtil.getParameter(request, prefix	+ "tpsz_cnt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] psaNo = (JSPUtil.getParameter(request, prefix	+ "psa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new MultiRateBkgList1VO();
				if (podDelEquals[i] != null)
					model.setPodDelEquals(podDelEquals[i]);
				if (prcRtMtchPattCd2[i] != null)
					model.setPrcRtMtchPattCd2(prcRtMtchPattCd2[i]);
				if (multiCntr[i] != null)
					model.setMultiCntr(multiCntr[i]);
				if (prcRtMtchPattCd1[i] != null)
					model.setPrcRtMtchPattCd1(prcRtMtchPattCd1[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (fnlFrtRtAmt1[i] != null)
					model.setFnlFrtRtAmt1(fnlFrtRtAmt1[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (oftCnt[i] != null)
					model.setOftCnt(oftCnt[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (fnlFrtRtAmt2[i] != null)
					model.setFnlFrtRtAmt2(fnlFrtRtAmt2[i]);
				if (usrUpdCfmFlg[i] != null)
					model.setUsrUpdCfmFlg(usrUpdCfmFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (tVvd[i] != null)
					model.setTVvd(tVvd[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				if (actCust[i] != null)
					model.setActCust(actCust[i]);
				if (prcCgoTpCd[i] != null)
					model.setPrcCgoTpCd(prcCgoTpCd[i]);
				if (porPolEquals[i] != null)
					model.setPorPolEquals(porPolEquals[i]);
				if (cmdtNm1[i] != null)
					model.setCmdtNm1(cmdtNm1[i]);
				if (cmdtNm2[i] != null)
					model.setCmdtNm2(cmdtNm2[i]);
				if (cfmDt[i] != null)
					model.setCfmDt(cfmDt[i]);
				if (sglMltCd[i] != null)
					model.setSglMltCd(sglMltCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (plsZrMnusCd2[i] != null)
					model.setPlsZrMnusCd2(plsZrMnusCd2[i]);
				if (plsZrMnusCd1[i] != null)
					model.setPlsZrMnusCd1(plsZrMnusCd1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (plsZrMnusCd3[i] != null)
					model.setPlsZrMnusCd3(plsZrMnusCd3[i]);
				if (dtType[i] != null)
					model.setDtType(dtType[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (usrUpdCtnt[i] != null)
					model.setUsrUpdCtnt(usrUpdCtnt[i]);
				if (prcCgoTpCd2[i] != null)
					model.setPrcCgoTpCd2(prcCgoTpCd2[i]);
				if (smPrime[i] != null)
					model.setSmPrime(smPrime[i]);
				if (prcCgoTpCd1[i] != null)
					model.setPrcCgoTpCd1(prcCgoTpCd1[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (noteCtnt2[i] != null)
					model.setNoteCtnt2(noteCtnt2[i]);
				if (noteCtnt1[i] != null)
					model.setNoteCtnt1(noteCtnt1[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (usrInsAmt[i] != null)
					model.setUsrInsAmt(usrInsAmt[i]);
				if (rctRhqCd[i] != null)
					model.setRctRhqCd(rctRhqCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (ratUtCd1[i] != null)
					model.setRatUtCd1(ratUtCd1[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (ratUtCd2[i] != null)
					model.setRatUtCd2(ratUtCd2[i]);
				if (tpszCnt[i] != null)
					model.setTpszCnt(tpszCnt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (psaNo[i] != null)
					model.setPsaNo(psaNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMultiRateBkgList1VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MultiRateBkgList1VO[]
	 */
	public MultiRateBkgList1VO[] getMultiRateBkgList1VOs(){
		MultiRateBkgList1VO[] vos = (MultiRateBkgList1VO[])models.toArray(new MultiRateBkgList1VO[models.size()]);
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
		this.podDelEquals = this.podDelEquals .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtMtchPattCd2 = this.prcRtMtchPattCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.multiCntr = this.multiCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRtMtchPattCd1 = this.prcRtMtchPattCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt1 = this.fnlFrtRtAmt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftCnt = this.oftCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt2 = this.fnlFrtRtAmt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrUpdCfmFlg = this.usrUpdCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tVvd = this.tVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCust = this.actCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd = this.prcCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porPolEquals = this.porPolEquals .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm1 = this.cmdtNm1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm2 = this.cmdtNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmDt = this.cfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sglMltCd = this.sglMltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plsZrMnusCd2 = this.plsZrMnusCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plsZrMnusCd1 = this.plsZrMnusCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plsZrMnusCd3 = this.plsZrMnusCd3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtType = this.dtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrUpdCtnt = this.usrUpdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd2 = this.prcCgoTpCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smPrime = this.smPrime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd1 = this.prcCgoTpCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt2 = this.noteCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt1 = this.noteCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrInsAmt = this.usrInsAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctRhqCd = this.rctRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd1 = this.ratUtCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd2 = this.ratUtCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCnt = this.tpszCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.psaNo = this.psaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
