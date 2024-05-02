/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FACAgreementVO.java
*@FileTitle : FACAgreementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.08
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.08 김봉균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmagreement.facommagreement.vo;

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
 * @author 김봉균
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FACAgreementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<FACAgreementVO> models = new ArrayList<FACAgreementVO>();

	/* Column Info */
	private String frtCntSeq = null;
	/* Column Info */
	private String bkgFacBlAmt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String porGrpTpCd = null;
	/* Column Info */
	private String facOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podRoutCd = null;
	/* Column Info */
	private String facSpclFeuAmt = null;
	/* Column Info */
	private String facTeuAmt = null;
	/* Column Info */
	private String ffSeq = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String fmEffDt = null;
	/* Column Info */
	private String porRoutCd = null;
	/* Column Info */
	private String delGrpTpCd = null;
	/* Column Info */
	private String shprLglEngNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String facSpclCntrTpCtnt1 = null;
	/* Column Info */
	private String shprCntCd = null;
	/* Column Info */
	private String facAproUsrId = null;
	/* Column Info */
	private String toEffDt = null;
	/* Column Info */
	private String facSpclCntrTpCtnt2 = null;
	/* Column Info */
	private String facRfFeuAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String facRqstUsrName = null;
	/* Column Info */
	private String facChgCtnt = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String podGrpTpCd = null;
	/* Column Info */
	private String facStsCd = null;
	/* Column Info */
	private String facBxAmt = null;
	/* Column Info */
	private String allInRtCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String facFeuAmt = null;
	/* Column Info */
	private String facRmk = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String facAproDt = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String facRqstUsrEml = null;
	/* Column Info */
	private String facAgmtSeq = null;
	/* Column Info */
	private String facRqstUsrId = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String facDblFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgFacRt = null;
	/* Column Info */
	private String facSglFlg = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String delRoutCd = null;
	/* Column Info */
	private String facDivCd = null;
	/* Column Info */
	private String polRoutCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String facAproUsrEml = null;
	/* Column Info */
	private String facSpclCntrRt2 = null;
	/* Column Info */
	private String polGrpTpCd = null;
	/* Column Info */
	private String facSpclCntrRt1 = null;
	/* Column Info */
	private String facRfTeuAmt = null;
	/* Column Info */
	private String ffLglEngNm = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String facSpclTeuAmt = null;
	/* Column Info */
	private String cmdtTpCd = null;
	/* Column Info */
	private String ffCntCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String shprCntSeq = null;
	/* Column Info */
	private String recipientsEml = null;
	/* Column Info */
	private String recipientsName = null;
	/* Column Info */
	private String cnt = null;
	/* Column Info */
	private String check = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String seq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public FACAgreementVO() {}

	public FACAgreementVO(String ibflag, String pagerows, String frtCntSeq, String shprCntCd, String shprSeq, String ffCntCd, String ffSeq, String ffLglEngNm, String shprCntSeq, String shprLglEngNm, String porGrpTpCd, String porRoutCd, String polGrpTpCd, String polRoutCd, String podGrpTpCd, String podRoutCd, String delGrpTpCd, String delRoutCd, String bkgRcvTermCd, String bkgDeTermCd, String facSglFlg, String facDblFlg, String allInRtCd, String svcScpCd, String fmEffDt, String toEffDt, String scNo, String rfaNo, String cmdtTpCd, String cmdtCd, String cmdtNm, String facDivCd, String bkgFacRt, String facSpclCntrTpCtnt1, String facSpclCntrRt1, String facSpclCntrTpCtnt2, String facSpclCntrRt2, String currCd, String bkgFacBlAmt, String facBxAmt, String facTeuAmt, String facFeuAmt, String facRfTeuAmt, String facRfFeuAmt, String facSpclTeuAmt, String facSpclFeuAmt, String facChgCtnt, String facStsCd, String facRqstUsrId, String facAproUsrId, String facAproDt, String facRmk, String facAgmtSeq, String facOfcCd, String facRqstUsrEml, String facAproUsrEml, String facRqstUsrName, String creUsrId, String creDt, String updUsrId, String updDt, String recipientsEml, String recipientsName, String cnt, String check, String arOfcCd, String seq) {
		this.frtCntSeq = frtCntSeq;
		this.bkgFacBlAmt = bkgFacBlAmt;
		this.svcScpCd = svcScpCd;
		this.porGrpTpCd = porGrpTpCd;
		this.facOfcCd = facOfcCd;
		this.pagerows = pagerows;
		this.podRoutCd = podRoutCd;
		this.facSpclFeuAmt = facSpclFeuAmt;
		this.facTeuAmt = facTeuAmt;
		this.ffSeq = ffSeq;
		this.scNo = scNo;
		this.fmEffDt = fmEffDt;
		this.porRoutCd = porRoutCd;
		this.delGrpTpCd = delGrpTpCd;
		this.shprLglEngNm = shprLglEngNm;
		this.updUsrId = updUsrId;
		this.facSpclCntrTpCtnt1 = facSpclCntrTpCtnt1;
		this.shprCntCd = shprCntCd;
		this.facAproUsrId = facAproUsrId;
		this.toEffDt = toEffDt;
		this.facSpclCntrTpCtnt2 = facSpclCntrTpCtnt2;
		this.facRfFeuAmt = facRfFeuAmt;
		this.creUsrId = creUsrId;
		this.facRqstUsrName = facRqstUsrName;
		this.facChgCtnt = facChgCtnt;
		this.shprSeq = shprSeq;
		this.podGrpTpCd = podGrpTpCd;
		this.facStsCd = facStsCd;
		this.facBxAmt = facBxAmt;
		this.allInRtCd = allInRtCd;
		this.currCd = currCd;
		this.facFeuAmt = facFeuAmt;
		this.facRmk = facRmk;
		this.creDt = creDt;
		this.facAproDt = facAproDt;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.facRqstUsrEml = facRqstUsrEml;
		this.facAgmtSeq = facAgmtSeq;
		this.facRqstUsrId = facRqstUsrId;
		this.rfaNo = rfaNo;
		this.facDblFlg = facDblFlg;
		this.ibflag = ibflag;
		this.bkgFacRt = bkgFacRt;
		this.facSglFlg = facSglFlg;
		this.cmdtCd = cmdtCd;
		this.delRoutCd = delRoutCd;
		this.facDivCd = facDivCd;
		this.polRoutCd = polRoutCd;
		this.updDt = updDt;
		this.facAproUsrEml = facAproUsrEml;
		this.facSpclCntrRt2 = facSpclCntrRt2;
		this.polGrpTpCd = polGrpTpCd;
		this.facSpclCntrRt1 = facSpclCntrRt1;
		this.facRfTeuAmt = facRfTeuAmt;
		this.ffLglEngNm = ffLglEngNm;
		this.cmdtNm = cmdtNm;
		this.facSpclTeuAmt = facSpclTeuAmt;
		this.cmdtTpCd = cmdtTpCd;
		this.ffCntCd = ffCntCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.shprCntSeq = shprCntSeq;
		this.recipientsEml = recipientsEml;
		this.recipientsName = recipientsName;
		this.cnt = cnt;
		this.check = check;
		this.arOfcCd = arOfcCd;
		this.seq = seq;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frt_cnt_seq", getFrtCntSeq());
		this.hashColumns.put("bkg_fac_bl_amt", getBkgFacBlAmt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("por_grp_tp_cd", getPorGrpTpCd());
		this.hashColumns.put("fac_ofc_cd", getFacOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_rout_cd", getPodRoutCd());
		this.hashColumns.put("fac_spcl_feu_amt", getFacSpclFeuAmt());
		this.hashColumns.put("fac_teu_amt", getFacTeuAmt());
		this.hashColumns.put("ff_seq", getFfSeq());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("fm_eff_dt", getFmEffDt());
		this.hashColumns.put("por_rout_cd", getPorRoutCd());
		this.hashColumns.put("del_grp_tp_cd", getDelGrpTpCd());
		this.hashColumns.put("shpr_lgl_eng_nm", getShprLglEngNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("fac_spcl_cntr_tp_ctnt1", getFacSpclCntrTpCtnt1());
		this.hashColumns.put("shpr_cnt_cd", getShprCntCd());
		this.hashColumns.put("fac_apro_usr_id", getFacAproUsrId());
		this.hashColumns.put("to_eff_dt", getToEffDt());
		this.hashColumns.put("fac_spcl_cntr_tp_ctnt2", getFacSpclCntrTpCtnt2());
		this.hashColumns.put("fac_rf_feu_amt", getFacRfFeuAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fac_rqst_usr_name", getFacRqstUsrName());
		this.hashColumns.put("fac_chg_ctnt", getFacChgCtnt());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("pod_grp_tp_cd", getPodGrpTpCd());
		this.hashColumns.put("fac_sts_cd", getFacStsCd());
		this.hashColumns.put("fac_bx_amt", getFacBxAmt());
		this.hashColumns.put("all_in_rt_cd", getAllInRtCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("fac_feu_amt", getFacFeuAmt());
		this.hashColumns.put("fac_rmk", getFacRmk());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("fac_apro_dt", getFacAproDt());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("fac_rqst_usr_eml", getFacRqstUsrEml());
		this.hashColumns.put("fac_agmt_seq", getFacAgmtSeq());
		this.hashColumns.put("fac_rqst_usr_id", getFacRqstUsrId());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("fac_dbl_flg", getFacDblFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_fac_rt", getBkgFacRt());
		this.hashColumns.put("fac_sgl_flg", getFacSglFlg());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("del_rout_cd", getDelRoutCd());
		this.hashColumns.put("fac_div_cd", getFacDivCd());
		this.hashColumns.put("pol_rout_cd", getPolRoutCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("fac_apro_usr_eml", getFacAproUsrEml());
		this.hashColumns.put("fac_spcl_cntr_rt2", getFacSpclCntrRt2());
		this.hashColumns.put("pol_grp_tp_cd", getPolGrpTpCd());
		this.hashColumns.put("fac_spcl_cntr_rt1", getFacSpclCntrRt1());
		this.hashColumns.put("fac_rf_teu_amt", getFacRfTeuAmt());
		this.hashColumns.put("ff_lgl_eng_nm", getFfLglEngNm());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("fac_spcl_teu_amt", getFacSpclTeuAmt());
		this.hashColumns.put("cmdt_tp_cd", getCmdtTpCd());
		this.hashColumns.put("ff_cnt_cd", getFfCntCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("shpr_cnt_seq", getShprCntSeq());
		this.hashColumns.put("recipients_eml", getRecipientsEml());
		this.hashColumns.put("recipients_name", getRecipientsName());
		this.hashColumns.put("cnt", getCnt());
		this.hashColumns.put("check", getCheck());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("seq", getSeq());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frt_cnt_seq", "frtCntSeq");
		this.hashFields.put("bkg_fac_bl_amt", "bkgFacBlAmt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("por_grp_tp_cd", "porGrpTpCd");
		this.hashFields.put("fac_ofc_cd", "facOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_rout_cd", "podRoutCd");
		this.hashFields.put("fac_spcl_feu_amt", "facSpclFeuAmt");
		this.hashFields.put("fac_teu_amt", "facTeuAmt");
		this.hashFields.put("ff_seq", "ffSeq");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("fm_eff_dt", "fmEffDt");
		this.hashFields.put("por_rout_cd", "porRoutCd");
		this.hashFields.put("del_grp_tp_cd", "delGrpTpCd");
		this.hashFields.put("shpr_lgl_eng_nm", "shprLglEngNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("fac_spcl_cntr_tp_ctnt1", "facSpclCntrTpCtnt1");
		this.hashFields.put("shpr_cnt_cd", "shprCntCd");
		this.hashFields.put("fac_apro_usr_id", "facAproUsrId");
		this.hashFields.put("to_eff_dt", "toEffDt");
		this.hashFields.put("fac_spcl_cntr_tp_ctnt2", "facSpclCntrTpCtnt2");
		this.hashFields.put("fac_rf_feu_amt", "facRfFeuAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fac_rqst_usr_name", "facRqstUsrName");
		this.hashFields.put("fac_chg_ctnt", "facChgCtnt");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("pod_grp_tp_cd", "podGrpTpCd");
		this.hashFields.put("fac_sts_cd", "facStsCd");
		this.hashFields.put("fac_bx_amt", "facBxAmt");
		this.hashFields.put("all_in_rt_cd", "allInRtCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("fac_feu_amt", "facFeuAmt");
		this.hashFields.put("fac_rmk", "facRmk");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("fac_apro_dt", "facAproDt");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("fac_rqst_usr_eml", "facRqstUsrEml");
		this.hashFields.put("fac_agmt_seq", "facAgmtSeq");
		this.hashFields.put("fac_rqst_usr_id", "facRqstUsrId");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("fac_dbl_flg", "facDblFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_fac_rt", "bkgFacRt");
		this.hashFields.put("fac_sgl_flg", "facSglFlg");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("del_rout_cd", "delRoutCd");
		this.hashFields.put("fac_div_cd", "facDivCd");
		this.hashFields.put("pol_rout_cd", "polRoutCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("fac_apro_usr_eml", "facAproUsrEml");
		this.hashFields.put("fac_spcl_cntr_rt2", "facSpclCntrRt2");
		this.hashFields.put("pol_grp_tp_cd", "polGrpTpCd");
		this.hashFields.put("fac_spcl_cntr_rt1", "facSpclCntrRt1");
		this.hashFields.put("fac_rf_teu_amt", "facRfTeuAmt");
		this.hashFields.put("ff_lgl_eng_nm", "ffLglEngNm");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("fac_spcl_teu_amt", "facSpclTeuAmt");
		this.hashFields.put("cmdt_tp_cd", "cmdtTpCd");
		this.hashFields.put("ff_cnt_cd", "ffCntCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("shpr_cnt_seq", "shprCntSeq");
		this.hashFields.put("recipients_eml", "recipientsEml");
		this.hashFields.put("recipients_name", "recipientsName");
		this.hashFields.put("cnt", "cnt");
		this.hashFields.put("check", "check");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("seq", "seq");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return frtCntSeq
	 */
	public String getFrtCntSeq() {
		return this.frtCntSeq;
	}

	/**
	 * Column Info
	 * @return bkgFacBlAmt
	 */
	public String getBkgFacBlAmt() {
		return this.bkgFacBlAmt;
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
	 * @return porGrpTpCd
	 */
	public String getPorGrpTpCd() {
		return this.porGrpTpCd;
	}

	/**
	 * Column Info
	 * @return facOfcCd
	 */
	public String getFacOfcCd() {
		return this.facOfcCd;
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
	 * @return podRoutCd
	 */
	public String getPodRoutCd() {
		return this.podRoutCd;
	}

	/**
	 * Column Info
	 * @return facSpclFeuAmt
	 */
	public String getFacSpclFeuAmt() {
		return this.facSpclFeuAmt;
	}

	/**
	 * Column Info
	 * @return facTeuAmt
	 */
	public String getFacTeuAmt() {
		return this.facTeuAmt;
	}

	/**
	 * Column Info
	 * @return ffSeq
	 */
	public String getFfSeq() {
		return this.ffSeq;
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
	 * @return fmEffDt
	 */
	public String getFmEffDt() {
		return this.fmEffDt;
	}

	/**
	 * Column Info
	 * @return porRoutCd
	 */
	public String getPorRoutCd() {
		return this.porRoutCd;
	}

	/**
	 * Column Info
	 * @return delGrpTpCd
	 */
	public String getDelGrpTpCd() {
		return this.delGrpTpCd;
	}

	/**
	 * Column Info
	 * @return shprLglEngNm
	 */
	public String getShprLglEngNm() {
		return this.shprLglEngNm;
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
	 * @return facSpclCntrTpCtnt1
	 */
	public String getFacSpclCntrTpCtnt1() {
		return this.facSpclCntrTpCtnt1;
	}

	/**
	 * Column Info
	 * @return shprCntCd
	 */
	public String getShprCntCd() {
		return this.shprCntCd;
	}

	/**
	 * Column Info
	 * @return facAproUsrId
	 */
	public String getFacAproUsrId() {
		return this.facAproUsrId;
	}

	/**
	 * Column Info
	 * @return toEffDt
	 */
	public String getToEffDt() {
		return this.toEffDt;
	}

	/**
	 * Column Info
	 * @return facSpclCntrTpCtnt2
	 */
	public String getFacSpclCntrTpCtnt2() {
		return this.facSpclCntrTpCtnt2;
	}

	/**
	 * Column Info
	 * @return facRfFeuAmt
	 */
	public String getFacRfFeuAmt() {
		return this.facRfFeuAmt;
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
	 * @return facRqstUsrName
	 */
	public String getFacRqstUsrName() {
		return this.facRqstUsrName;
	}

	/**
	 * Column Info
	 * @return facChgCtnt
	 */
	public String getFacChgCtnt() {
		return this.facChgCtnt;
	}

	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}

	/**
	 * Column Info
	 * @return podGrpTpCd
	 */
	public String getPodGrpTpCd() {
		return this.podGrpTpCd;
	}

	/**
	 * Column Info
	 * @return facStsCd
	 */
	public String getFacStsCd() {
		return this.facStsCd;
	}

	/**
	 * Column Info
	 * @return facBxAmt
	 */
	public String getFacBxAmt() {
		return this.facBxAmt;
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}

	/**
	 * Column Info
	 * @return facFeuAmt
	 */
	public String getFacFeuAmt() {
		return this.facFeuAmt;
	}

	/**
	 * Column Info
	 * @return facRmk
	 */
	public String getFacRmk() {
		return this.facRmk;
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
	 * @return facAproDt
	 */
	public String getFacAproDt() {
		return this.facAproDt;
	}

	/**
	 * Column Info
	 * @return bkgRcvTermCd
	 */
	public String getBkgRcvTermCd() {
		return this.bkgRcvTermCd;
	}

	/**
	 * Column Info
	 * @return facRqstUsrEml
	 */
	public String getFacRqstUsrEml() {
		return this.facRqstUsrEml;
	}

	/**
	 * Column Info
	 * @return facAgmtSeq
	 */
	public String getFacAgmtSeq() {
		return this.facAgmtSeq;
	}

	/**
	 * Column Info
	 * @return facRqstUsrId
	 */
	public String getFacRqstUsrId() {
		return this.facRqstUsrId;
	}

	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}

	/**
	 * Column Info
	 * @return facDblFlg
	 */
	public String getFacDblFlg() {
		return this.facDblFlg;
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
	 * @return bkgFacRt
	 */
	public String getBkgFacRt() {
		return this.bkgFacRt;
	}

	/**
	 * Column Info
	 * @return facSglFlg
	 */
	public String getFacSglFlg() {
		return this.facSglFlg;
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
	 * @return delRoutCd
	 */
	public String getDelRoutCd() {
		return this.delRoutCd;
	}

	/**
	 * Column Info
	 * @return facDivCd
	 */
	public String getFacDivCd() {
		return this.facDivCd;
	}

	/**
	 * Column Info
	 * @return polRoutCd
	 */
	public String getPolRoutCd() {
		return this.polRoutCd;
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
	 * @return facAproUsrEml
	 */
	public String getFacAproUsrEml() {
		return this.facAproUsrEml;
	}

	/**
	 * Column Info
	 * @return facSpclCntrRt2
	 */
	public String getFacSpclCntrRt2() {
		return this.facSpclCntrRt2;
	}

	/**
	 * Column Info
	 * @return polGrpTpCd
	 */
	public String getPolGrpTpCd() {
		return this.polGrpTpCd;
	}

	/**
	 * Column Info
	 * @return facSpclCntrRt1
	 */
	public String getFacSpclCntrRt1() {
		return this.facSpclCntrRt1;
	}

	/**
	 * Column Info
	 * @return facRfTeuAmt
	 */
	public String getFacRfTeuAmt() {
		return this.facRfTeuAmt;
	}

	/**
	 * Column Info
	 * @return ffLglEngNm
	 */
	public String getFfLglEngNm() {
		return this.ffLglEngNm;
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
	 * @return facSpclTeuAmt
	 */
	public String getFacSpclTeuAmt() {
		return this.facSpclTeuAmt;
	}

	/**
	 * Column Info
	 * @return cmdtTpCd
	 */
	public String getCmdtTpCd() {
		return this.cmdtTpCd;
	}

	/**
	 * Column Info
	 * @return ffCntCd
	 */
	public String getFfCntCd() {
		return this.ffCntCd;
	}

	/**
	 * Column Info
	 * @return bkgDeTermCd
	 */
	public String getBkgDeTermCd() {
		return this.bkgDeTermCd;
	}

	/**
	 * Column Info
	 * @return shprCntSeq
	 */
	public String getShprCntSeq() {
		return this.shprCntSeq;
	}

	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}

	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}

	/**
	 * Column Info
	 * @param frtCntSeq
	 */
	public void setFrtCntSeq(String frtCntSeq) {
		this.frtCntSeq = frtCntSeq;
	}

	/**
	 * Column Info
	 * @param bkgFacBlAmt
	 */
	public void setBkgFacBlAmt(String bkgFacBlAmt) {
		this.bkgFacBlAmt = bkgFacBlAmt;
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
	 * @param porGrpTpCd
	 */
	public void setPorGrpTpCd(String porGrpTpCd) {
		this.porGrpTpCd = porGrpTpCd;
	}

	/**
	 * Column Info
	 * @param facOfcCd
	 */
	public void setFacOfcCd(String facOfcCd) {
		this.facOfcCd = facOfcCd;
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
	 * @param podRoutCd
	 */
	public void setPodRoutCd(String podRoutCd) {
		this.podRoutCd = podRoutCd;
	}

	/**
	 * Column Info
	 * @param facSpclFeuAmt
	 */
	public void setFacSpclFeuAmt(String facSpclFeuAmt) {
		this.facSpclFeuAmt = facSpclFeuAmt;
	}

	/**
	 * Column Info
	 * @param facTeuAmt
	 */
	public void setFacTeuAmt(String facTeuAmt) {
		this.facTeuAmt = facTeuAmt;
	}

	/**
	 * Column Info
	 * @param ffSeq
	 */
	public void setFfSeq(String ffSeq) {
		this.ffSeq = ffSeq;
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
	 * @param fmEffDt
	 */
	public void setFmEffDt(String fmEffDt) {
		this.fmEffDt = fmEffDt;
	}

	/**
	 * Column Info
	 * @param porRoutCd
	 */
	public void setPorRoutCd(String porRoutCd) {
		this.porRoutCd = porRoutCd;
	}

	/**
	 * Column Info
	 * @param delGrpTpCd
	 */
	public void setDelGrpTpCd(String delGrpTpCd) {
		this.delGrpTpCd = delGrpTpCd;
	}

	/**
	 * Column Info
	 * @param shprLglEngNm
	 */
	public void setShprLglEngNm(String shprLglEngNm) {
		this.shprLglEngNm = shprLglEngNm;
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
	 * @param facSpclCntrTpCtnt1
	 */
	public void setFacSpclCntrTpCtnt1(String facSpclCntrTpCtnt1) {
		this.facSpclCntrTpCtnt1 = facSpclCntrTpCtnt1;
	}

	/**
	 * Column Info
	 * @param shprCntCd
	 */
	public void setShprCntCd(String shprCntCd) {
		this.shprCntCd = shprCntCd;
	}

	/**
	 * Column Info
	 * @param facAproUsrId
	 */
	public void setFacAproUsrId(String facAproUsrId) {
		this.facAproUsrId = facAproUsrId;
	}

	/**
	 * Column Info
	 * @param toEffDt
	 */
	public void setToEffDt(String toEffDt) {
		this.toEffDt = toEffDt;
	}

	/**
	 * Column Info
	 * @param facSpclCntrTpCtnt2
	 */
	public void setFacSpclCntrTpCtnt2(String facSpclCntrTpCtnt2) {
		this.facSpclCntrTpCtnt2 = facSpclCntrTpCtnt2;
	}

	/**
	 * Column Info
	 * @param facRfFeuAmt
	 */
	public void setFacRfFeuAmt(String facRfFeuAmt) {
		this.facRfFeuAmt = facRfFeuAmt;
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
	 * @param facRqstUsrName
	 */
	public void setFacRqstUsrName(String facRqstUsrName) {
		this.facRqstUsrName = facRqstUsrName;
	}

	/**
	 * Column Info
	 * @param facChgCtnt
	 */
	public void setFacChgCtnt(String facChgCtnt) {
		this.facChgCtnt = facChgCtnt;
	}

	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}

	/**
	 * Column Info
	 * @param podGrpTpCd
	 */
	public void setPodGrpTpCd(String podGrpTpCd) {
		this.podGrpTpCd = podGrpTpCd;
	}

	/**
	 * Column Info
	 * @param facStsCd
	 */
	public void setFacStsCd(String facStsCd) {
		this.facStsCd = facStsCd;
	}

	/**
	 * Column Info
	 * @param facBxAmt
	 */
	public void setFacBxAmt(String facBxAmt) {
		this.facBxAmt = facBxAmt;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}

	/**
	 * Column Info
	 * @param facFeuAmt
	 */
	public void setFacFeuAmt(String facFeuAmt) {
		this.facFeuAmt = facFeuAmt;
	}

	/**
	 * Column Info
	 * @param facRmk
	 */
	public void setFacRmk(String facRmk) {
		this.facRmk = facRmk;
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
	 * @param facAproDt
	 */
	public void setFacAproDt(String facAproDt) {
		this.facAproDt = facAproDt;
	}

	/**
	 * Column Info
	 * @param bkgRcvTermCd
	 */
	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}

	/**
	 * Column Info
	 * @param facRqstUsrEml
	 */
	public void setFacRqstUsrEml(String facRqstUsrEml) {
		this.facRqstUsrEml = facRqstUsrEml;
	}

	/**
	 * Column Info
	 * @param facAgmtSeq
	 */
	public void setFacAgmtSeq(String facAgmtSeq) {
		this.facAgmtSeq = facAgmtSeq;
	}

	/**
	 * Column Info
	 * @param facRqstUsrId
	 */
	public void setFacRqstUsrId(String facRqstUsrId) {
		this.facRqstUsrId = facRqstUsrId;
	}

	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	/**
	 * Column Info
	 * @param facDblFlg
	 */
	public void setFacDblFlg(String facDblFlg) {
		this.facDblFlg = facDblFlg;
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
	 * @param bkgFacRt
	 */
	public void setBkgFacRt(String bkgFacRt) {
		this.bkgFacRt = bkgFacRt;
	}

	/**
	 * Column Info
	 * @param facSglFlg
	 */
	public void setFacSglFlg(String facSglFlg) {
		this.facSglFlg = facSglFlg;
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
	 * @param delRoutCd
	 */
	public void setDelRoutCd(String delRoutCd) {
		this.delRoutCd = delRoutCd;
	}

	/**
	 * Column Info
	 * @param facDivCd
	 */
	public void setFacDivCd(String facDivCd) {
		this.facDivCd = facDivCd;
	}

	/**
	 * Column Info
	 * @param polRoutCd
	 */
	public void setPolRoutCd(String polRoutCd) {
		this.polRoutCd = polRoutCd;
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
	 * @param facAproUsrEml
	 */
	public void setFacAproUsrEml(String facAproUsrEml) {
		this.facAproUsrEml = facAproUsrEml;
	}

	/**
	 * Column Info
	 * @param facSpclCntrRt2
	 */
	public void setFacSpclCntrRt2(String facSpclCntrRt2) {
		this.facSpclCntrRt2 = facSpclCntrRt2;
	}

	/**
	 * Column Info
	 * @param polGrpTpCd
	 */
	public void setPolGrpTpCd(String polGrpTpCd) {
		this.polGrpTpCd = polGrpTpCd;
	}

	/**
	 * Column Info
	 * @param facSpclCntrRt1
	 */
	public void setFacSpclCntrRt1(String facSpclCntrRt1) {
		this.facSpclCntrRt1 = facSpclCntrRt1;
	}

	/**
	 * Column Info
	 * @param facRfTeuAmt
	 */
	public void setFacRfTeuAmt(String facRfTeuAmt) {
		this.facRfTeuAmt = facRfTeuAmt;
	}

	/**
	 * Column Info
	 * @param ffLglEngNm
	 */
	public void setFfLglEngNm(String ffLglEngNm) {
		this.ffLglEngNm = ffLglEngNm;
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
	 * @param facSpclTeuAmt
	 */
	public void setFacSpclTeuAmt(String facSpclTeuAmt) {
		this.facSpclTeuAmt = facSpclTeuAmt;
	}

	/**
	 * Column Info
	 * @param cmdtTpCd
	 */
	public void setCmdtTpCd(String cmdtTpCd) {
		this.cmdtTpCd = cmdtTpCd;
	}

	/**
	 * Column Info
	 * @param ffCntCd
	 */
	public void setFfCntCd(String ffCntCd) {
		this.ffCntCd = ffCntCd;
	}

	/**
	 * Column Info
	 * @param bkgDeTermCd
	 */
	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}

	/**
	 * Column Info
	 * @param shprCntSeq
	 */
	public void setShprCntSeq(String shprCntSeq) {
		this.shprCntSeq = shprCntSeq;
	}

	/**
	 * Column Info
	 * @return recipientsEml
	 */
	public String getRecipientsEml() {
		return recipientsEml;
	}

	/**
	 * Column Info
	 * @param recipientsEml
	 */
	public void setRecipientsEml(String recipientsEml) {
		this.recipientsEml = recipientsEml;
	}

	/**
	 * Column Info
	 * @return recipientsName
	 */
	public String getRecipientsName() {
		return recipientsEml;
	}

	/**
	 * Column Info
	 * @param recipientsName
	 */
	public void setRecipientsName(String recipientsName) {
		this.recipientsName = recipientsName;
	}

	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}

	/**
	 * Column Info
	 * @return cnt
	 */
	public String getCnt() {
		return cnt;
	}

	/**
	 * Column Info
	 * @param cnt
	 */
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	/**
	 * Column Info
	 * @return check
	 */
	public String getCheck() {
		return check;
	}

	/**
	 * Column Info
	 * @param check
	 */
	public void setCheck(String check) {
		this.check = check;
	}

	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
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
		setFrtCntSeq(JSPUtil.getParameter(request, prefix + "frt_cnt_seq", ""));
		setBkgFacBlAmt(JSPUtil.getParameter(request, prefix + "bkg_fac_bl_amt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPorGrpTpCd(JSPUtil.getParameter(request, prefix + "por_grp_tp_cd", ""));
		setFacOfcCd(JSPUtil.getParameter(request, prefix + "fac_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodRoutCd(JSPUtil.getParameter(request, prefix + "pod_rout_cd", ""));
		setFacSpclFeuAmt(JSPUtil.getParameter(request, prefix + "fac_spcl_feu_amt", ""));
		setFacTeuAmt(JSPUtil.getParameter(request, prefix + "fac_teu_amt", ""));
		setFfSeq(JSPUtil.getParameter(request, prefix + "ff_seq", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setFmEffDt(JSPUtil.getParameter(request, prefix + "fm_eff_dt", ""));
		setPorRoutCd(JSPUtil.getParameter(request, prefix + "por_rout_cd", ""));
		setDelGrpTpCd(JSPUtil.getParameter(request, prefix + "del_grp_tp_cd", ""));
		setShprLglEngNm(JSPUtil.getParameter(request, prefix + "shpr_lgl_eng_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setFacSpclCntrTpCtnt1(JSPUtil.getParameter(request, prefix + "fac_spcl_cntr_tp_ctnt1", ""));
		setShprCntCd(JSPUtil.getParameter(request, prefix + "shpr_cnt_cd", ""));
		setFacAproUsrId(JSPUtil.getParameter(request, prefix + "fac_apro_usr_id", ""));
		setToEffDt(JSPUtil.getParameter(request, prefix + "to_eff_dt", ""));
		setFacSpclCntrTpCtnt2(JSPUtil.getParameter(request, prefix + "fac_spcl_cntr_tp_ctnt2", ""));
		setFacRfFeuAmt(JSPUtil.getParameter(request, prefix + "fac_rf_feu_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFacRqstUsrName(JSPUtil.getParameter(request, prefix + "fac_rqst_usr_name", ""));
		setFacChgCtnt(JSPUtil.getParameter(request, prefix + "fac_chg_ctnt", ""));
		setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
		setPodGrpTpCd(JSPUtil.getParameter(request, prefix + "pod_grp_tp_cd", ""));
		setFacStsCd(JSPUtil.getParameter(request, prefix + "fac_sts_cd", ""));
		setFacBxAmt(JSPUtil.getParameter(request, prefix + "fac_bx_amt", ""));
		setAllInRtCd(JSPUtil.getParameter(request, prefix + "all_in_rt_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFacFeuAmt(JSPUtil.getParameter(request, prefix + "fac_feu_amt", ""));
		setFacRmk(JSPUtil.getParameter(request, prefix + "fac_rmk", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setFacAproDt(JSPUtil.getParameter(request, prefix + "fac_apro_dt", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setFacRqstUsrEml(JSPUtil.getParameter(request, prefix + "fac_rqst_usr_eml", ""));
		setFacAgmtSeq(JSPUtil.getParameter(request, prefix + "fac_agmt_seq", ""));
		setFacRqstUsrId(JSPUtil.getParameter(request, prefix + "fac_rqst_usr_id", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setFacDblFlg(JSPUtil.getParameter(request, prefix + "fac_dbl_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgFacRt(JSPUtil.getParameter(request, prefix + "bkg_fac_rt", ""));
		setFacSglFlg(JSPUtil.getParameter(request, prefix + "fac_sgl_flg", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setDelRoutCd(JSPUtil.getParameter(request, prefix + "del_rout_cd", ""));
		setFacDivCd(JSPUtil.getParameter(request, prefix + "fac_div_cd", ""));
		setPolRoutCd(JSPUtil.getParameter(request, prefix + "pol_rout_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setFacAproUsrEml(JSPUtil.getParameter(request, prefix + "fac_apro_usr_eml", ""));
		setFacSpclCntrRt2(JSPUtil.getParameter(request, prefix + "fac_spcl_cntr_rt2", ""));
		setPolGrpTpCd(JSPUtil.getParameter(request, prefix + "pol_grp_tp_cd", ""));
		setFacSpclCntrRt1(JSPUtil.getParameter(request, prefix + "fac_spcl_cntr_rt1", ""));
		setFacRfTeuAmt(JSPUtil.getParameter(request, prefix + "fac_rf_teu_amt", ""));
		setFfLglEngNm(JSPUtil.getParameter(request, prefix + "ff_lgl_eng_nm", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setFacSpclTeuAmt(JSPUtil.getParameter(request, prefix + "fac_spcl_teu_amt", ""));
		setCmdtTpCd(JSPUtil.getParameter(request, prefix + "cmdt_tp_cd", ""));
		setFfCntCd(JSPUtil.getParameter(request, prefix + "ff_cnt_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setShprCntSeq(JSPUtil.getParameter(request, prefix + "shpr_cnt_seq", ""));
		setRecipientsEml(JSPUtil.getParameter(request, prefix + "recipients_eml", ""));
		setRecipientsName(JSPUtil.getParameter(request, prefix + "recipients_name", ""));
		setCnt(JSPUtil.getParameter(request, prefix + "cnt", ""));
		setCheck(JSPUtil.getParameter(request, prefix + "check", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FACAgreementVO[]
	 */
	public FACAgreementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return FACAgreementVO[]
	 */
	public FACAgreementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FACAgreementVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] frtCntSeq = (JSPUtil.getParameter(request, prefix	+ "frt_cnt_seq", length));
			String[] bkgFacBlAmt = (JSPUtil.getParameter(request, prefix	+ "bkg_fac_bl_amt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] porGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "por_grp_tp_cd", length));
			String[] facOfcCd = (JSPUtil.getParameter(request, prefix	+ "fac_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podRoutCd = (JSPUtil.getParameter(request, prefix	+ "pod_rout_cd", length));
			String[] facSpclFeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_feu_amt", length));
			String[] facTeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_teu_amt", length));
			String[] ffSeq = (JSPUtil.getParameter(request, prefix	+ "ff_seq", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] fmEffDt = (JSPUtil.getParameter(request, prefix	+ "fm_eff_dt", length));
			String[] porRoutCd = (JSPUtil.getParameter(request, prefix	+ "por_rout_cd", length));
			String[] delGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "del_grp_tp_cd", length));
			String[] shprLglEngNm = (JSPUtil.getParameter(request, prefix	+ "shpr_lgl_eng_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] facSpclCntrTpCtnt1 = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_cntr_tp_ctnt1", length));
			String[] shprCntCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_cd", length));
			String[] facAproUsrId = (JSPUtil.getParameter(request, prefix	+ "fac_apro_usr_id", length));
			String[] toEffDt = (JSPUtil.getParameter(request, prefix	+ "to_eff_dt", length));
			String[] facSpclCntrTpCtnt2 = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_cntr_tp_ctnt2", length));
			String[] facRfFeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_feu_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] facRqstUsrName = (JSPUtil.getParameter(request, prefix	+ "fac_rqst_usr_name", length));
			String[] facChgCtnt = (JSPUtil.getParameter(request, prefix	+ "fac_chg_ctnt", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] podGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pod_grp_tp_cd", length));
			String[] facStsCd = (JSPUtil.getParameter(request, prefix	+ "fac_sts_cd", length));
			String[] facBxAmt = (JSPUtil.getParameter(request, prefix	+ "fac_bx_amt", length));
			String[] allInRtCd = (JSPUtil.getParameter(request, prefix	+ "all_in_rt_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] facFeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_feu_amt", length));
			String[] facRmk = (JSPUtil.getParameter(request, prefix	+ "fac_rmk", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] facAproDt = (JSPUtil.getParameter(request, prefix	+ "fac_apro_dt", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] facRqstUsrEml = (JSPUtil.getParameter(request, prefix	+ "fac_rqst_usr_eml", length));
			String[] facAgmtSeq = (JSPUtil.getParameter(request, prefix	+ "fac_agmt_seq", length));
			String[] facRqstUsrId = (JSPUtil.getParameter(request, prefix	+ "fac_rqst_usr_id", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] facDblFlg = (JSPUtil.getParameter(request, prefix	+ "fac_dbl_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgFacRt = (JSPUtil.getParameter(request, prefix	+ "bkg_fac_rt", length));
			String[] facSglFlg = (JSPUtil.getParameter(request, prefix	+ "fac_sgl_flg", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] delRoutCd = (JSPUtil.getParameter(request, prefix	+ "del_rout_cd", length));
			String[] facDivCd = (JSPUtil.getParameter(request, prefix	+ "fac_div_cd", length));
			String[] polRoutCd = (JSPUtil.getParameter(request, prefix	+ "pol_rout_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] facAproUsrEml = (JSPUtil.getParameter(request, prefix	+ "fac_apro_usr_eml", length));
			String[] facSpclCntrRt2 = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_cntr_rt2", length));
			String[] polGrpTpCd = (JSPUtil.getParameter(request, prefix	+ "pol_grp_tp_cd", length));
			String[] facSpclCntrRt1 = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_cntr_rt1", length));
			String[] facRfTeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_rf_teu_amt", length));
			String[] ffLglEngNm = (JSPUtil.getParameter(request, prefix	+ "ff_lgl_eng_nm", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] facSpclTeuAmt = (JSPUtil.getParameter(request, prefix	+ "fac_spcl_teu_amt", length));
			String[] cmdtTpCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_tp_cd", length));
			String[] ffCntCd = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] shprCntSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_cnt_seq", length));
			String[] recipientsEml = (JSPUtil.getParameter(request, prefix	+ "recipients_eml", length));
			String[] recipientsName = (JSPUtil.getParameter(request, prefix	+ "recipients_name", length));
			String[] cnt = (JSPUtil.getParameter(request, prefix	+ "cnt", length));
			String[] check = (JSPUtil.getParameter(request, prefix	+ "check", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));

			for (int i = 0; i < length; i++) {
				model = new FACAgreementVO();
				if (frtCntSeq[i] != null)
					model.setFrtCntSeq(frtCntSeq[i]);
				if (bkgFacBlAmt[i] != null)
					model.setBkgFacBlAmt(bkgFacBlAmt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (porGrpTpCd[i] != null)
					model.setPorGrpTpCd(porGrpTpCd[i]);
				if (facOfcCd[i] != null)
					model.setFacOfcCd(facOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podRoutCd[i] != null)
					model.setPodRoutCd(podRoutCd[i]);
				if (facSpclFeuAmt[i] != null)
					model.setFacSpclFeuAmt(facSpclFeuAmt[i]);
				if (facTeuAmt[i] != null)
					model.setFacTeuAmt(facTeuAmt[i]);
				if (ffSeq[i] != null)
					model.setFfSeq(ffSeq[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (fmEffDt[i] != null)
					model.setFmEffDt(fmEffDt[i]);
				if (porRoutCd[i] != null)
					model.setPorRoutCd(porRoutCd[i]);
				if (delGrpTpCd[i] != null)
					model.setDelGrpTpCd(delGrpTpCd[i]);
				if (shprLglEngNm[i] != null)
					model.setShprLglEngNm(shprLglEngNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (facSpclCntrTpCtnt1[i] != null)
					model.setFacSpclCntrTpCtnt1(facSpclCntrTpCtnt1[i]);
				if (shprCntCd[i] != null)
					model.setShprCntCd(shprCntCd[i]);
				if (facAproUsrId[i] != null)
					model.setFacAproUsrId(facAproUsrId[i]);
				if (toEffDt[i] != null)
					model.setToEffDt(toEffDt[i]);
				if (facSpclCntrTpCtnt2[i] != null)
					model.setFacSpclCntrTpCtnt2(facSpclCntrTpCtnt2[i]);
				if (facRfFeuAmt[i] != null)
					model.setFacRfFeuAmt(facRfFeuAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (facRqstUsrName[i] != null)
					model.setFacRqstUsrName(facRqstUsrName[i]);
				if (facChgCtnt[i] != null)
					model.setFacChgCtnt(facChgCtnt[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (podGrpTpCd[i] != null)
					model.setPodGrpTpCd(podGrpTpCd[i]);
				if (facStsCd[i] != null)
					model.setFacStsCd(facStsCd[i]);
				if (facBxAmt[i] != null)
					model.setFacBxAmt(facBxAmt[i]);
				if (allInRtCd[i] != null)
					model.setAllInRtCd(allInRtCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (facFeuAmt[i] != null)
					model.setFacFeuAmt(facFeuAmt[i]);
				if (facRmk[i] != null)
					model.setFacRmk(facRmk[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (facAproDt[i] != null)
					model.setFacAproDt(facAproDt[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (facRqstUsrEml[i] != null)
					model.setFacRqstUsrEml(facRqstUsrEml[i]);
				if (facAgmtSeq[i] != null)
					model.setFacAgmtSeq(facAgmtSeq[i]);
				if (facRqstUsrId[i] != null)
					model.setFacRqstUsrId(facRqstUsrId[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (facDblFlg[i] != null)
					model.setFacDblFlg(facDblFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgFacRt[i] != null)
					model.setBkgFacRt(bkgFacRt[i]);
				if (facSglFlg[i] != null)
					model.setFacSglFlg(facSglFlg[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (delRoutCd[i] != null)
					model.setDelRoutCd(delRoutCd[i]);
				if (facDivCd[i] != null)
					model.setFacDivCd(facDivCd[i]);
				if (polRoutCd[i] != null)
					model.setPolRoutCd(polRoutCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (facAproUsrEml[i] != null)
					model.setFacAproUsrEml(facAproUsrEml[i]);
				if (facSpclCntrRt2[i] != null)
					model.setFacSpclCntrRt2(facSpclCntrRt2[i]);
				if (polGrpTpCd[i] != null)
					model.setPolGrpTpCd(polGrpTpCd[i]);
				if (facSpclCntrRt1[i] != null)
					model.setFacSpclCntrRt1(facSpclCntrRt1[i]);
				if (facRfTeuAmt[i] != null)
					model.setFacRfTeuAmt(facRfTeuAmt[i]);
				if (ffLglEngNm[i] != null)
					model.setFfLglEngNm(ffLglEngNm[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (facSpclTeuAmt[i] != null)
					model.setFacSpclTeuAmt(facSpclTeuAmt[i]);
				if (cmdtTpCd[i] != null)
					model.setCmdtTpCd(cmdtTpCd[i]);
				if (ffCntCd[i] != null)
					model.setFfCntCd(ffCntCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (shprCntSeq[i] != null)
					model.setShprCntSeq(shprCntSeq[i]);
				if (recipientsEml[i] != null)
					model.setRecipientsEml(recipientsEml[i]);
				if (recipientsName[i] != null)
					model.setRecipientsName(recipientsName[i]);
				if (cnt[i] != null)
					model.setCnt(cnt[i]);
				if (check[i] != null)
					model.setCheck(check[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFACAgreementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FACAgreementVO[]
	 */
	public FACAgreementVO[] getFACAgreementVOs(){
		FACAgreementVO[] vos = (FACAgreementVO[])models.toArray(new FACAgreementVO[models.size()]);
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
		this.frtCntSeq = this.frtCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFacBlAmt = this.bkgFacBlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porGrpTpCd = this.porGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facOfcCd = this.facOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podRoutCd = this.podRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclFeuAmt = this.facSpclFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facTeuAmt = this.facTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffSeq = this.ffSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEffDt = this.fmEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porRoutCd = this.porRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delGrpTpCd = this.delGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprLglEngNm = this.shprLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclCntrTpCtnt1 = this.facSpclCntrTpCtnt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntCd = this.shprCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facAproUsrId = this.facAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEffDt = this.toEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclCntrTpCtnt2 = this.facSpclCntrTpCtnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfFeuAmt = this.facRfFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRqstUsrName = this.facRqstUsrName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facChgCtnt = this.facChgCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podGrpTpCd = this.podGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facStsCd = this.facStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facBxAmt = this.facBxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allInRtCd = this.allInRtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facFeuAmt = this.facFeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRmk = this.facRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facAproDt = this.facAproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRqstUsrEml = this.facRqstUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facAgmtSeq = this.facAgmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRqstUsrId = this.facRqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDblFlg = this.facDblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFacRt = this.bkgFacRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSglFlg = this.facSglFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delRoutCd = this.delRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facDivCd = this.facDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polRoutCd = this.polRoutCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facAproUsrEml = this.facAproUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclCntrRt2 = this.facSpclCntrRt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polGrpTpCd = this.polGrpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclCntrRt1 = this.facSpclCntrRt1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facRfTeuAmt = this.facRfTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffLglEngNm = this.ffLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.facSpclTeuAmt = this.facSpclTeuAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtTpCd = this.cmdtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntCd = this.ffCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntSeq = this.shprCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipientsEml = this.recipientsEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recipientsName = this.recipientsName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnt = this.cnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.check = this.check .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
