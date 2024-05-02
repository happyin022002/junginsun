/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CHSAgreementINVO.java
*@FileTitle : CHSAgreementINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.10.14 김창식 
* 1.0 Creation
* History
* 2014.11 Chagn Young Kim 10만불 결제관련
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

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
 * @author 김창식
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSAgreementINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSAgreementINVO> models = new ArrayList<CHSAgreementINVO>();
	
	/* Column Info */
	private String agmtEffDt = null;
	/* Column Info */
	private String keyRntlFmTrVal = null;
	/* Column Info */
	private String eqTpszCdSf4 = null;
	/* Column Info */
	private String drpOffLmtTpCd = null;
	/* Column Info */
	private String dppCvrgAmt = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String lmsmAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String monDpcRtAmt = null;
	/* Column Info */
	private String agmtIssOfcCd = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String drpOffLmtPrdCd = null;
	/* Column Info */
	private String rntlToTrVal = null;
	/* Column Info */
	private String eqTpszCdZt4 = null;
	/* Column Info */
	private String offhHndlRtAmt = null;
	/* Column Info */
	private String agmtExpDt = null;
	/* Column Info */
	private String ohnInitValAmt = null;
	/* Column Info */
	private String rntlToTitle = null;
	/* Column Info */
	private String eqTpszCdSf2 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String chssLseRtAmt = null;
	/* Column Info */
	private String eqTpszCdCb4 = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String initDpcRtAmt = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String keyRntlToTrVal = null;
	/* Column Info */
	private String rntlFmTitle = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String eqTpszCdGn4 = null;
	/* Column Info */
	private String eqTpszCdGn5 = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String lstVerFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String preEffDt = null;
	/* Column Info */
	private String eqTpszCdSl2 = null;
	/* Column Info */
	private String agmtDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String dppRtAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqTpszCdEg8 = null;
	/* Column Info */
	private String eqTpszCdTa2 = null;
	/* Column Info */
	private String eqTpszCdEg5 = null;
	/* Column Info */
	private String rntlFmTrVal = null;
	/* Column Info */
	private String actionFlag = null;
	/* Column Info */
	private String trRtAmt = null;
	/* Column Info */
	private String onhHndlRtAmt = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String preExpDt = null;
	/* Column Info */
	private String keySteCd = null;
	/* Column Info */
	private String eqRntlTpCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String rgstScgRtAmt = null;
	/* Column Info */
	private String drpOffLmtQty = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String drpOffLmtRto = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String maxDpcRtAmt = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String dppTpCd = null;
	/* Column Info */
	private String gwUqDocTitNm = null;
	/* Column Info */
	private String gwUqDocNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSAgreementINVO() {}

	public CHSAgreementINVO(String ibflag, String pagerows, String keyRntlFmTrVal, String eqTpszCdSf4, String drpOffLmtTpCd, String dppCvrgAmt, String chssPoolCd, String lmsmAmt, String monDpcRtAmt, String agmtIssOfcCd, String effDt, String drpOffLmtPrdCd, String rntlToTrVal, String eqTpszCdZt4, String offhHndlRtAmt, String ohnInitValAmt, String rntlToTitle, String updUsrId, String eqTpszCdSf2, String agmtRefNo, String chssLseRtAmt, String agmtSeq, String eqTpszCdCb4, String agmtNo, String agmtLstmCd, String payTermDys, String initDpcRtAmt, String eqTpszCd, String keyRntlToTrVal, String rntlFmTitle, String creUsrId, String eqTpszCdGn4, String eqTpszCdGn5, String vndrSeq, String agmtOfcCtyCd, String agmtVerNo, String lstVerFlg, String currCd, String preEffDt, String eqTpszCdSl2, String vndrLglEngNm, String creDt, String dppRtAmt, String eqTpszCdEg8, String eqTpszCdTa2, String eqTpszCdEg5, String rntlFmTrVal, String actionFlag, String trRtAmt, String expDt, String onhHndlRtAmt, String preExpDt, String keySteCd, String eqRntlTpCd, String eqKndCd, String rgstScgRtAmt, String drpOffLmtQty, String diffRmk, String steNm, String drpOffLmtRto, String maxDpcRtAmt, String steCd, String dppTpCd, String agmtDt, String agmtEffDt, String agmtExpDt, String gwUqDocTitNm, String gwUqDocNo) {
		this.agmtEffDt = agmtEffDt;
		this.keyRntlFmTrVal = keyRntlFmTrVal;
		this.eqTpszCdSf4 = eqTpszCdSf4;
		this.drpOffLmtTpCd = drpOffLmtTpCd;
		this.dppCvrgAmt = dppCvrgAmt;
		this.chssPoolCd = chssPoolCd;
		this.lmsmAmt = lmsmAmt;
		this.pagerows = pagerows;
		this.monDpcRtAmt = monDpcRtAmt;
		this.agmtIssOfcCd = agmtIssOfcCd;
		this.effDt = effDt;
		this.drpOffLmtPrdCd = drpOffLmtPrdCd;
		this.rntlToTrVal = rntlToTrVal;
		this.eqTpszCdZt4 = eqTpszCdZt4;
		this.offhHndlRtAmt = offhHndlRtAmt;
		this.agmtExpDt = agmtExpDt;
		this.ohnInitValAmt = ohnInitValAmt;
		this.rntlToTitle = rntlToTitle;
		this.eqTpszCdSf2 = eqTpszCdSf2;
		this.updUsrId = updUsrId;
		this.agmtRefNo = agmtRefNo;
		this.chssLseRtAmt = chssLseRtAmt;
		this.eqTpszCdCb4 = eqTpszCdCb4;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.agmtLstmCd = agmtLstmCd;
		this.payTermDys = payTermDys;
		this.initDpcRtAmt = initDpcRtAmt;
		this.eqTpszCd = eqTpszCd;
		this.keyRntlToTrVal = keyRntlToTrVal;
		this.rntlFmTitle = rntlFmTitle;
		this.creUsrId = creUsrId;
		this.eqTpszCdGn4 = eqTpszCdGn4;
		this.eqTpszCdGn5 = eqTpszCdGn5;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.agmtVerNo = agmtVerNo;
		this.lstVerFlg = lstVerFlg;
		this.currCd = currCd;
		this.preEffDt = preEffDt;
		this.eqTpszCdSl2 = eqTpszCdSl2;
		this.agmtDt = agmtDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.creDt = creDt;
		this.dppRtAmt = dppRtAmt;
		this.ibflag = ibflag;
		this.eqTpszCdEg8 = eqTpszCdEg8;
		this.eqTpszCdTa2 = eqTpszCdTa2;
		this.eqTpszCdEg5 = eqTpszCdEg5;
		this.rntlFmTrVal = rntlFmTrVal;
		this.actionFlag = actionFlag;
		this.trRtAmt = trRtAmt;
		this.onhHndlRtAmt = onhHndlRtAmt;
		this.expDt = expDt;
		this.preExpDt = preExpDt;
		this.keySteCd = keySteCd;
		this.eqRntlTpCd = eqRntlTpCd;
		this.eqKndCd = eqKndCd;
		this.rgstScgRtAmt = rgstScgRtAmt;
		this.drpOffLmtQty = drpOffLmtQty;
		this.diffRmk = diffRmk;
		this.drpOffLmtRto = drpOffLmtRto;
		this.steNm = steNm;
		this.maxDpcRtAmt = maxDpcRtAmt;
		this.steCd = steCd;
		this.dppTpCd = dppTpCd;
		this.gwUqDocTitNm = gwUqDocTitNm;
		this.gwUqDocNo = gwUqDocNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_eff_dt", getAgmtEffDt());
		this.hashColumns.put("key_rntl_fm_tr_val", getKeyRntlFmTrVal());
		this.hashColumns.put("eq_tpsz_cd_sf4", getEqTpszCdSf4());
		this.hashColumns.put("drp_off_lmt_tp_cd", getDrpOffLmtTpCd());
		this.hashColumns.put("dpp_cvrg_amt", getDppCvrgAmt());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("lmsm_amt", getLmsmAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mon_dpc_rt_amt", getMonDpcRtAmt());
		this.hashColumns.put("agmt_iss_ofc_cd", getAgmtIssOfcCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("drp_off_lmt_prd_cd", getDrpOffLmtPrdCd());
		this.hashColumns.put("rntl_to_tr_val", getRntlToTrVal());
		this.hashColumns.put("eq_tpsz_cd_zt4", getEqTpszCdZt4());
		this.hashColumns.put("offh_hndl_rt_amt", getOffhHndlRtAmt());
		this.hashColumns.put("agmt_exp_dt", getAgmtExpDt());
		this.hashColumns.put("ohn_init_val_amt", getOhnInitValAmt());
		this.hashColumns.put("rntl_to_title", getRntlToTitle());
		this.hashColumns.put("eq_tpsz_cd_sf2", getEqTpszCdSf2());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("chss_lse_rt_amt", getChssLseRtAmt());
		this.hashColumns.put("eq_tpsz_cd_cb4", getEqTpszCdCb4());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("init_dpc_rt_amt", getInitDpcRtAmt());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("key_rntl_to_tr_val", getKeyRntlToTrVal());
		this.hashColumns.put("rntl_fm_title", getRntlFmTitle());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eq_tpsz_cd_gn4", getEqTpszCdGn4());
		this.hashColumns.put("eq_tpsz_cd_gn5", getEqTpszCdGn5());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("lst_ver_flg", getLstVerFlg());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pre_eff_dt", getPreEffDt());
		this.hashColumns.put("eq_tpsz_cd_sl2", getEqTpszCdSl2());
		this.hashColumns.put("agmt_dt", getAgmtDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("dpp_rt_amt", getDppRtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_tpsz_cd_eg8", getEqTpszCdEg8());
		this.hashColumns.put("eq_tpsz_cd_ta2", getEqTpszCdTa2());
		this.hashColumns.put("eq_tpsz_cd_eg5", getEqTpszCdEg5());
		this.hashColumns.put("rntl_fm_tr_val", getRntlFmTrVal());
		this.hashColumns.put("action_flag", getActionFlag());
		this.hashColumns.put("tr_rt_amt", getTrRtAmt());
		this.hashColumns.put("onh_hndl_rt_amt", getOnhHndlRtAmt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("pre_exp_dt", getPreExpDt());
		this.hashColumns.put("key_ste_cd", getKeySteCd());
		this.hashColumns.put("eq_rntl_tp_cd", getEqRntlTpCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("rgst_scg_rt_amt", getRgstScgRtAmt());
		this.hashColumns.put("drp_off_lmt_qty", getDrpOffLmtQty());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("drp_off_lmt_rto", getDrpOffLmtRto());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("max_dpc_rt_amt", getMaxDpcRtAmt());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("dpp_tp_cd", getDppTpCd());
		this.hashColumns.put("gw_uq_doc_tit_nm", getGwUqDocTitNm());
		this.hashColumns.put("gw_uq_doc_no", getGwUqDocNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("agmt_eff_dt", "agmtEffDt");
		this.hashFields.put("key_rntl_fm_tr_val", "keyRntlFmTrVal");
		this.hashFields.put("eq_tpsz_cd_sf4", "eqTpszCdSf4");
		this.hashFields.put("drp_off_lmt_tp_cd", "drpOffLmtTpCd");
		this.hashFields.put("dpp_cvrg_amt", "dppCvrgAmt");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("lmsm_amt", "lmsmAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mon_dpc_rt_amt", "monDpcRtAmt");
		this.hashFields.put("agmt_iss_ofc_cd", "agmtIssOfcCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("drp_off_lmt_prd_cd", "drpOffLmtPrdCd");
		this.hashFields.put("rntl_to_tr_val", "rntlToTrVal");
		this.hashFields.put("eq_tpsz_cd_zt4", "eqTpszCdZt4");
		this.hashFields.put("offh_hndl_rt_amt", "offhHndlRtAmt");
		this.hashFields.put("agmt_exp_dt", "agmtExpDt");
		this.hashFields.put("ohn_init_val_amt", "ohnInitValAmt");
		this.hashFields.put("rntl_to_title", "rntlToTitle");
		this.hashFields.put("eq_tpsz_cd_sf2", "eqTpszCdSf2");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("chss_lse_rt_amt", "chssLseRtAmt");
		this.hashFields.put("eq_tpsz_cd_cb4", "eqTpszCdCb4");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("init_dpc_rt_amt", "initDpcRtAmt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("key_rntl_to_tr_val", "keyRntlToTrVal");
		this.hashFields.put("rntl_fm_title", "rntlFmTitle");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eq_tpsz_cd_gn4", "eqTpszCdGn4");
		this.hashFields.put("eq_tpsz_cd_gn5", "eqTpszCdGn5");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("lst_ver_flg", "lstVerFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pre_eff_dt", "preEffDt");
		this.hashFields.put("eq_tpsz_cd_sl2", "eqTpszCdSl2");
		this.hashFields.put("agmt_dt", "agmtDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("dpp_rt_amt", "dppRtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_tpsz_cd_eg8", "eqTpszCdEg8");
		this.hashFields.put("eq_tpsz_cd_ta2", "eqTpszCdTa2");
		this.hashFields.put("eq_tpsz_cd_eg5", "eqTpszCdEg5");
		this.hashFields.put("rntl_fm_tr_val", "rntlFmTrVal");
		this.hashFields.put("action_flag", "actionFlag");
		this.hashFields.put("tr_rt_amt", "trRtAmt");
		this.hashFields.put("onh_hndl_rt_amt", "onhHndlRtAmt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("pre_exp_dt", "preExpDt");
		this.hashFields.put("key_ste_cd", "keySteCd");
		this.hashFields.put("eq_rntl_tp_cd", "eqRntlTpCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("rgst_scg_rt_amt", "rgstScgRtAmt");
		this.hashFields.put("drp_off_lmt_qty", "drpOffLmtQty");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("drp_off_lmt_rto", "drpOffLmtRto");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("max_dpc_rt_amt", "maxDpcRtAmt");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("dpp_tp_cd", "dppTpCd");
		this.hashFields.put("gw_uq_doc_tit_nm", "gwUqDocTitNm");
		this.hashFields.put("gw_uq_doc_no", "gwUqDocNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return agmtEffDt
	 */
	public String getAgmtEffDt() {
		return this.agmtEffDt;
	}
	
	/**
	 * Column Info
	 * @return keyRntlFmTrVal
	 */
	public String getKeyRntlFmTrVal() {
		return this.keyRntlFmTrVal;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdSf4
	 */
	public String getEqTpszCdSf4() {
		return this.eqTpszCdSf4;
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
	 * @return agmtIssOfcCd
	 */
	public String getAgmtIssOfcCd() {
		return this.agmtIssOfcCd;
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
	 * @return drpOffLmtPrdCd
	 */
	public String getDrpOffLmtPrdCd() {
		return this.drpOffLmtPrdCd;
	}
	
	/**
	 * Column Info
	 * @return rntlToTrVal
	 */
	public String getRntlToTrVal() {
		return this.rntlToTrVal;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdZt4
	 */
	public String getEqTpszCdZt4() {
		return this.eqTpszCdZt4;
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
	 * @return agmtExpDt
	 */
	public String getAgmtExpDt() {
		return this.agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @return ohnInitValAmt
	 */
	public String getOhnInitValAmt() {
		return this.ohnInitValAmt;
	}
	
	/**
	 * Column Info
	 * @return rntlToTitle
	 */
	public String getRntlToTitle() {
		return this.rntlToTitle;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdSf2
	 */
	public String getEqTpszCdSf2() {
		return this.eqTpszCdSf2;
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
	 * @return agmtRefNo
	 */
	public String getAgmtRefNo() {
		return this.agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @return chssLseRtAmt
	 */
	public String getChssLseRtAmt() {
		return this.chssLseRtAmt;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdCb4
	 */
	public String getEqTpszCdCb4() {
		return this.eqTpszCdCb4;
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
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
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
	 * @return payTermDys
	 */
	public String getPayTermDys() {
		return this.payTermDys;
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
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return keyRntlToTrVal
	 */
	public String getKeyRntlToTrVal() {
		return this.keyRntlToTrVal;
	}
	
	/**
	 * Column Info
	 * @return rntlFmTitle
	 */
	public String getRntlFmTitle() {
		return this.rntlFmTitle;
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
	 * @return eqTpszCdGn4
	 */
	public String getEqTpszCdGn4() {
		return this.eqTpszCdGn4;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdGn5
	 */
	public String getEqTpszCdGn5() {
		return this.eqTpszCdGn5;
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
	 * @return preEffDt
	 */
	public String getPreEffDt() {
		return this.preEffDt;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdSl2
	 */
	public String getEqTpszCdSl2() {
		return this.eqTpszCdSl2;
	}
	
	/**
	 * Column Info
	 * @return agmtDt
	 */
	public String getAgmtDt() {
		return this.agmtDt;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * @return eqTpszCdEg8
	 */
	public String getEqTpszCdEg8() {
		return this.eqTpszCdEg8;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdTa2
	 */
	public String getEqTpszCdTa2() {
		return this.eqTpszCdTa2;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCdEg5
	 */
	public String getEqTpszCdEg5() {
		return this.eqTpszCdEg5;
	}
	
	/**
	 * Column Info
	 * @return rntlFmTrVal
	 */
	public String getRntlFmTrVal() {
		return this.rntlFmTrVal;
	}
	
	/**
	 * Column Info
	 * @return actionFlag
	 */
	public String getActionFlag() {
		return this.actionFlag;
	}
	
	/**
	 * Column Info
	 * @return trRtAmt
	 */
	public String getTrRtAmt() {
		return this.trRtAmt;
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
	 * @return preExpDt
	 */
	public String getPreExpDt() {
		return this.preExpDt;
	}
	
	/**
	 * Column Info
	 * @return keySteCd
	 */
	public String getKeySteCd() {
		return this.keySteCd;
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
	 * @return rgstScgRtAmt
	 */
	public String getRgstScgRtAmt() {
		return this.rgstScgRtAmt;
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
	 * @return steNm
	 */
	public String getSteNm() {
		return this.steNm;
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
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
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
	 * @param agmtEffDt
	 */
	public void setAgmtEffDt(String agmtEffDt) {
		this.agmtEffDt = agmtEffDt;
	}
	
	/**
	 * Column Info
	 * @param keyRntlFmTrVal
	 */
	public void setKeyRntlFmTrVal(String keyRntlFmTrVal) {
		this.keyRntlFmTrVal = keyRntlFmTrVal;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdSf4
	 */
	public void setEqTpszCdSf4(String eqTpszCdSf4) {
		this.eqTpszCdSf4 = eqTpszCdSf4;
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
	 * @param agmtIssOfcCd
	 */
	public void setAgmtIssOfcCd(String agmtIssOfcCd) {
		this.agmtIssOfcCd = agmtIssOfcCd;
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
	 * @param drpOffLmtPrdCd
	 */
	public void setDrpOffLmtPrdCd(String drpOffLmtPrdCd) {
		this.drpOffLmtPrdCd = drpOffLmtPrdCd;
	}
	
	/**
	 * Column Info
	 * @param rntlToTrVal
	 */
	public void setRntlToTrVal(String rntlToTrVal) {
		this.rntlToTrVal = rntlToTrVal;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdZt4
	 */
	public void setEqTpszCdZt4(String eqTpszCdZt4) {
		this.eqTpszCdZt4 = eqTpszCdZt4;
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
	 * @param agmtExpDt
	 */
	public void setAgmtExpDt(String agmtExpDt) {
		this.agmtExpDt = agmtExpDt;
	}
	
	/**
	 * Column Info
	 * @param ohnInitValAmt
	 */
	public void setOhnInitValAmt(String ohnInitValAmt) {
		this.ohnInitValAmt = ohnInitValAmt;
	}
	
	/**
	 * Column Info
	 * @param rntlToTitle
	 */
	public void setRntlToTitle(String rntlToTitle) {
		this.rntlToTitle = rntlToTitle;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdSf2
	 */
	public void setEqTpszCdSf2(String eqTpszCdSf2) {
		this.eqTpszCdSf2 = eqTpszCdSf2;
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
	 * @param agmtRefNo
	 */
	public void setAgmtRefNo(String agmtRefNo) {
		this.agmtRefNo = agmtRefNo;
	}
	
	/**
	 * Column Info
	 * @param chssLseRtAmt
	 */
	public void setChssLseRtAmt(String chssLseRtAmt) {
		this.chssLseRtAmt = chssLseRtAmt;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdCb4
	 */
	public void setEqTpszCdCb4(String eqTpszCdCb4) {
		this.eqTpszCdCb4 = eqTpszCdCb4;
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
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
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
	 * @param payTermDys
	 */
	public void setPayTermDys(String payTermDys) {
		this.payTermDys = payTermDys;
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
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param keyRntlToTrVal
	 */
	public void setKeyRntlToTrVal(String keyRntlToTrVal) {
		this.keyRntlToTrVal = keyRntlToTrVal;
	}
	
	/**
	 * Column Info
	 * @param rntlFmTitle
	 */
	public void setRntlFmTitle(String rntlFmTitle) {
		this.rntlFmTitle = rntlFmTitle;
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
	 * @param eqTpszCdGn4
	 */
	public void setEqTpszCdGn4(String eqTpszCdGn4) {
		this.eqTpszCdGn4 = eqTpszCdGn4;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdGn5
	 */
	public void setEqTpszCdGn5(String eqTpszCdGn5) {
		this.eqTpszCdGn5 = eqTpszCdGn5;
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
	 * @param preEffDt
	 */
	public void setPreEffDt(String preEffDt) {
		this.preEffDt = preEffDt;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdSl2
	 */
	public void setEqTpszCdSl2(String eqTpszCdSl2) {
		this.eqTpszCdSl2 = eqTpszCdSl2;
	}
	
	/**
	 * Column Info
	 * @param agmtDt
	 */
	public void setAgmtDt(String agmtDt) {
		this.agmtDt = agmtDt;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * @param eqTpszCdEg8
	 */
	public void setEqTpszCdEg8(String eqTpszCdEg8) {
		this.eqTpszCdEg8 = eqTpszCdEg8;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdTa2
	 */
	public void setEqTpszCdTa2(String eqTpszCdTa2) {
		this.eqTpszCdTa2 = eqTpszCdTa2;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCdEg5
	 */
	public void setEqTpszCdEg5(String eqTpszCdEg5) {
		this.eqTpszCdEg5 = eqTpszCdEg5;
	}
	
	/**
	 * Column Info
	 * @param rntlFmTrVal
	 */
	public void setRntlFmTrVal(String rntlFmTrVal) {
		this.rntlFmTrVal = rntlFmTrVal;
	}
	
	/**
	 * Column Info
	 * @param actionFlag
	 */
	public void setActionFlag(String actionFlag) {
		this.actionFlag = actionFlag;
	}
	
	/**
	 * Column Info
	 * @param trRtAmt
	 */
	public void setTrRtAmt(String trRtAmt) {
		this.trRtAmt = trRtAmt;
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
	 * @param preExpDt
	 */
	public void setPreExpDt(String preExpDt) {
		this.preExpDt = preExpDt;
	}
	
	/**
	 * Column Info
	 * @param keySteCd
	 */
	public void setKeySteCd(String keySteCd) {
		this.keySteCd = keySteCd;
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
	 * @param rgstScgRtAmt
	 */
	public void setRgstScgRtAmt(String rgstScgRtAmt) {
		this.rgstScgRtAmt = rgstScgRtAmt;
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
	 * @param steNm
	 */
	public void setSteNm(String steNm) {
		this.steNm = steNm;
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
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
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
	 * @return gwUqDocTitNm
	 */
	public String getGwUqDocTitNm() {
		return this.gwUqDocTitNm;
	}

	/**
	 * Column Info
	 * @return gwUqDocNo
	 */
	public String getGwUqDocNo() {
		return this.gwUqDocNo;
	}
	
	/**
	 * Column Info
	 * @return gwUqDocTitNm
	 */
	public void setGwUqDocTitNm(String gwUqDocTitNm) {
		this.gwUqDocTitNm = gwUqDocTitNm;
	}

	/**
	 * Column Info
	 * @return gwUqDocNo
	 */
	public void setGwUqDocNo(String gwUqDocNo) {
		this.gwUqDocNo = gwUqDocNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAgmtEffDt(JSPUtil.getParameter(request, "agmt_eff_dt", ""));
		setKeyRntlFmTrVal(JSPUtil.getParameter(request, "key_rntl_fm_tr_val", ""));
		setEqTpszCdSf4(JSPUtil.getParameter(request, "eq_tpsz_cd_sf4", ""));
		setDrpOffLmtTpCd(JSPUtil.getParameter(request, "drp_off_lmt_tp_cd", ""));
		setDppCvrgAmt(JSPUtil.getParameter(request, "dpp_cvrg_amt", ""));
		setChssPoolCd(JSPUtil.getParameter(request, "chss_pool_cd", ""));
		setLmsmAmt(JSPUtil.getParameter(request, "lmsm_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMonDpcRtAmt(JSPUtil.getParameter(request, "mon_dpc_rt_amt", ""));
		setAgmtIssOfcCd(JSPUtil.getParameter(request, "agmt_iss_ofc_cd", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setDrpOffLmtPrdCd(JSPUtil.getParameter(request, "drp_off_lmt_prd_cd", ""));
		setRntlToTrVal(JSPUtil.getParameter(request, "rntl_to_tr_val", ""));
		setEqTpszCdZt4(JSPUtil.getParameter(request, "eq_tpsz_cd_zt4", ""));
		setOffhHndlRtAmt(JSPUtil.getParameter(request, "offh_hndl_rt_amt", ""));
		setAgmtExpDt(JSPUtil.getParameter(request, "agmt_exp_dt", ""));
		setOhnInitValAmt(JSPUtil.getParameter(request, "ohn_init_val_amt", ""));
		setRntlToTitle(JSPUtil.getParameter(request, "rntl_to_title", ""));
		setEqTpszCdSf2(JSPUtil.getParameter(request, "eq_tpsz_cd_sf2", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setChssLseRtAmt(JSPUtil.getParameter(request, "chss_lse_rt_amt", ""));
		setEqTpszCdCb4(JSPUtil.getParameter(request, "eq_tpsz_cd_cb4", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setPayTermDys(JSPUtil.getParameter(request, "pay_term_dys", ""));
		setInitDpcRtAmt(JSPUtil.getParameter(request, "init_dpc_rt_amt", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setKeyRntlToTrVal(JSPUtil.getParameter(request, "key_rntl_to_tr_val", ""));
		setRntlFmTitle(JSPUtil.getParameter(request, "rntl_fm_title", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setEqTpszCdGn4(JSPUtil.getParameter(request, "eq_tpsz_cd_gn4", ""));
		setEqTpszCdGn5(JSPUtil.getParameter(request, "eq_tpsz_cd_gn5", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setLstVerFlg(JSPUtil.getParameter(request, "lst_ver_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPreEffDt(JSPUtil.getParameter(request, "pre_eff_dt", ""));
		setEqTpszCdSl2(JSPUtil.getParameter(request, "eq_tpsz_cd_sl2", ""));
		setAgmtDt(JSPUtil.getParameter(request, "agmt_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setDppRtAmt(JSPUtil.getParameter(request, "dpp_rt_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqTpszCdEg8(JSPUtil.getParameter(request, "eq_tpsz_cd_eg8", ""));
		setEqTpszCdTa2(JSPUtil.getParameter(request, "eq_tpsz_cd_ta2", ""));
		setEqTpszCdEg5(JSPUtil.getParameter(request, "eq_tpsz_cd_eg5", ""));
		setRntlFmTrVal(JSPUtil.getParameter(request, "rntl_fm_tr_val", ""));
		setActionFlag(JSPUtil.getParameter(request, "action_flag", ""));
		setTrRtAmt(JSPUtil.getParameter(request, "tr_rt_amt", ""));
		setOnhHndlRtAmt(JSPUtil.getParameter(request, "onh_hndl_rt_amt", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setPreExpDt(JSPUtil.getParameter(request, "pre_exp_dt", ""));
		setKeySteCd(JSPUtil.getParameter(request, "key_ste_cd", ""));
		setEqRntlTpCd(JSPUtil.getParameter(request, "eq_rntl_tp_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setRgstScgRtAmt(JSPUtil.getParameter(request, "rgst_scg_rt_amt", ""));
		setDrpOffLmtQty(JSPUtil.getParameter(request, "drp_off_lmt_qty", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setDrpOffLmtRto(JSPUtil.getParameter(request, "drp_off_lmt_rto", ""));
		setSteNm(JSPUtil.getParameter(request, "ste_nm", ""));
		setMaxDpcRtAmt(JSPUtil.getParameter(request, "max_dpc_rt_amt", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
		setDppTpCd(JSPUtil.getParameter(request, "dpp_tp_cd", ""));
		setGwUqDocTitNm(JSPUtil.getParameter(request, "gw_uq_doc_tit_nm", ""));
		setGwUqDocNo(JSPUtil.getParameter(request, "gw_uq_doc_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSAgreementINVO[]
	 */
	public CHSAgreementINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSAgreementINVO[]
	 */
	public CHSAgreementINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSAgreementINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtEffDt = (JSPUtil.getParameter(request, prefix	+ "agmt_eff_dt", length));
			String[] keyRntlFmTrVal = (JSPUtil.getParameter(request, prefix	+ "key_rntl_fm_tr_val", length));
			String[] eqTpszCdSf4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_sf4", length));
			String[] drpOffLmtTpCd = (JSPUtil.getParameter(request, prefix	+ "drp_off_lmt_tp_cd", length));
			String[] dppCvrgAmt = (JSPUtil.getParameter(request, prefix	+ "dpp_cvrg_amt", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] lmsmAmt = (JSPUtil.getParameter(request, prefix	+ "lmsm_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] monDpcRtAmt = (JSPUtil.getParameter(request, prefix	+ "mon_dpc_rt_amt", length));
			String[] agmtIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_iss_ofc_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] drpOffLmtPrdCd = (JSPUtil.getParameter(request, prefix	+ "drp_off_lmt_prd_cd", length));
			String[] rntlToTrVal = (JSPUtil.getParameter(request, prefix	+ "rntl_to_tr_val", length));
			String[] eqTpszCdZt4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_zt4", length));
			String[] offhHndlRtAmt = (JSPUtil.getParameter(request, prefix	+ "offh_hndl_rt_amt", length));
			String[] agmtExpDt = (JSPUtil.getParameter(request, prefix	+ "agmt_exp_dt", length));
			String[] ohnInitValAmt = (JSPUtil.getParameter(request, prefix	+ "ohn_init_val_amt", length));
			String[] rntlToTitle = (JSPUtil.getParameter(request, prefix	+ "rntl_to_title", length));
			String[] eqTpszCdSf2 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_sf2", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] chssLseRtAmt = (JSPUtil.getParameter(request, prefix	+ "chss_lse_rt_amt", length));
			String[] eqTpszCdCb4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_cb4", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] initDpcRtAmt = (JSPUtil.getParameter(request, prefix	+ "init_dpc_rt_amt", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] keyRntlToTrVal = (JSPUtil.getParameter(request, prefix	+ "key_rntl_to_tr_val", length));
			String[] rntlFmTitle = (JSPUtil.getParameter(request, prefix	+ "rntl_fm_title", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] eqTpszCdGn4 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_gn4", length));
			String[] eqTpszCdGn5 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_gn5", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] lstVerFlg = (JSPUtil.getParameter(request, prefix	+ "lst_ver_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] preEffDt = (JSPUtil.getParameter(request, prefix	+ "pre_eff_dt", length));
			String[] eqTpszCdSl2 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_sl2", length));
			String[] agmtDt = (JSPUtil.getParameter(request, prefix	+ "agmt_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] dppRtAmt = (JSPUtil.getParameter(request, prefix	+ "dpp_rt_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqTpszCdEg8 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_eg8", length));
			String[] eqTpszCdTa2 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_ta2", length));
			String[] eqTpszCdEg5 = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd_eg5", length));
			String[] rntlFmTrVal = (JSPUtil.getParameter(request, prefix	+ "rntl_fm_tr_val", length));
			String[] actionFlag = (JSPUtil.getParameter(request, prefix	+ "action_flag", length));
			String[] trRtAmt = (JSPUtil.getParameter(request, prefix	+ "tr_rt_amt", length));
			String[] onhHndlRtAmt = (JSPUtil.getParameter(request, prefix	+ "onh_hndl_rt_amt", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] preExpDt = (JSPUtil.getParameter(request, prefix	+ "pre_exp_dt", length));
			String[] keySteCd = (JSPUtil.getParameter(request, prefix	+ "key_ste_cd", length));
			String[] eqRntlTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_rntl_tp_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] rgstScgRtAmt = (JSPUtil.getParameter(request, prefix	+ "rgst_scg_rt_amt", length));
			String[] drpOffLmtQty = (JSPUtil.getParameter(request, prefix	+ "drp_off_lmt_qty", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] drpOffLmtRto = (JSPUtil.getParameter(request, prefix	+ "drp_off_lmt_rto", length));
			String[] steNm = (JSPUtil.getParameter(request, prefix	+ "ste_nm", length));
			String[] maxDpcRtAmt = (JSPUtil.getParameter(request, prefix	+ "max_dpc_rt_amt", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] dppTpCd = (JSPUtil.getParameter(request, prefix	+ "dpp_tp_cd", length));
			String[] gwUqDocTitNm = (JSPUtil.getParameter(request, prefix + "gw_uq_doc_tit_nm", length));
			String[] gwUqDocNo = (JSPUtil.getParameter(request, prefix + "gw_uq_doc_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSAgreementINVO();
				if (agmtEffDt[i] != null)
					model.setAgmtEffDt(agmtEffDt[i]);
				if (keyRntlFmTrVal[i] != null)
					model.setKeyRntlFmTrVal(keyRntlFmTrVal[i]);
				if (eqTpszCdSf4[i] != null)
					model.setEqTpszCdSf4(eqTpszCdSf4[i]);
				if (drpOffLmtTpCd[i] != null)
					model.setDrpOffLmtTpCd(drpOffLmtTpCd[i]);
				if (dppCvrgAmt[i] != null)
					model.setDppCvrgAmt(dppCvrgAmt[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (lmsmAmt[i] != null)
					model.setLmsmAmt(lmsmAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (monDpcRtAmt[i] != null)
					model.setMonDpcRtAmt(monDpcRtAmt[i]);
				if (agmtIssOfcCd[i] != null)
					model.setAgmtIssOfcCd(agmtIssOfcCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (drpOffLmtPrdCd[i] != null)
					model.setDrpOffLmtPrdCd(drpOffLmtPrdCd[i]);
				if (rntlToTrVal[i] != null)
					model.setRntlToTrVal(rntlToTrVal[i]);
				if (eqTpszCdZt4[i] != null)
					model.setEqTpszCdZt4(eqTpszCdZt4[i]);
				if (offhHndlRtAmt[i] != null)
					model.setOffhHndlRtAmt(offhHndlRtAmt[i]);
				if (agmtExpDt[i] != null)
					model.setAgmtExpDt(agmtExpDt[i]);
				if (ohnInitValAmt[i] != null)
					model.setOhnInitValAmt(ohnInitValAmt[i]);
				if (rntlToTitle[i] != null)
					model.setRntlToTitle(rntlToTitle[i]);
				if (eqTpszCdSf2[i] != null)
					model.setEqTpszCdSf2(eqTpszCdSf2[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (chssLseRtAmt[i] != null)
					model.setChssLseRtAmt(chssLseRtAmt[i]);
				if (eqTpszCdCb4[i] != null)
					model.setEqTpszCdCb4(eqTpszCdCb4[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (initDpcRtAmt[i] != null)
					model.setInitDpcRtAmt(initDpcRtAmt[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (keyRntlToTrVal[i] != null)
					model.setKeyRntlToTrVal(keyRntlToTrVal[i]);
				if (rntlFmTitle[i] != null)
					model.setRntlFmTitle(rntlFmTitle[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (eqTpszCdGn4[i] != null)
					model.setEqTpszCdGn4(eqTpszCdGn4[i]);
				if (eqTpszCdGn5[i] != null)
					model.setEqTpszCdGn5(eqTpszCdGn5[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (lstVerFlg[i] != null)
					model.setLstVerFlg(lstVerFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (preEffDt[i] != null)
					model.setPreEffDt(preEffDt[i]);
				if (eqTpszCdSl2[i] != null)
					model.setEqTpszCdSl2(eqTpszCdSl2[i]);
				if (agmtDt[i] != null)
					model.setAgmtDt(agmtDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (dppRtAmt[i] != null)
					model.setDppRtAmt(dppRtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqTpszCdEg8[i] != null)
					model.setEqTpszCdEg8(eqTpszCdEg8[i]);
				if (eqTpszCdTa2[i] != null)
					model.setEqTpszCdTa2(eqTpszCdTa2[i]);
				if (eqTpszCdEg5[i] != null)
					model.setEqTpszCdEg5(eqTpszCdEg5[i]);
				if (rntlFmTrVal[i] != null)
					model.setRntlFmTrVal(rntlFmTrVal[i]);
				if (actionFlag[i] != null)
					model.setActionFlag(actionFlag[i]);
				if (trRtAmt[i] != null)
					model.setTrRtAmt(trRtAmt[i]);
				if (onhHndlRtAmt[i] != null)
					model.setOnhHndlRtAmt(onhHndlRtAmt[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (preExpDt[i] != null)
					model.setPreExpDt(preExpDt[i]);
				if (keySteCd[i] != null)
					model.setKeySteCd(keySteCd[i]);
				if (eqRntlTpCd[i] != null)
					model.setEqRntlTpCd(eqRntlTpCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (rgstScgRtAmt[i] != null)
					model.setRgstScgRtAmt(rgstScgRtAmt[i]);
				if (drpOffLmtQty[i] != null)
					model.setDrpOffLmtQty(drpOffLmtQty[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (drpOffLmtRto[i] != null)
					model.setDrpOffLmtRto(drpOffLmtRto[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (maxDpcRtAmt[i] != null)
					model.setMaxDpcRtAmt(maxDpcRtAmt[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (dppTpCd[i] != null)
					model.setDppTpCd(dppTpCd[i]);
				if (gwUqDocTitNm[i] != null)
					model.setGwUqDocTitNm(gwUqDocTitNm[i]);
				if (gwUqDocNo[i] != null)
					model.setGwUqDocNo(gwUqDocNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSAgreementINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSAgreementINVO[]
	 */
	public CHSAgreementINVO[] getCHSAgreementINVOs(){
		CHSAgreementINVO[] vos = (CHSAgreementINVO[])models.toArray(new CHSAgreementINVO[models.size()]);
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
		this.agmtEffDt = this.agmtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyRntlFmTrVal = this.keyRntlFmTrVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSf4 = this.eqTpszCdSf4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtTpCd = this.drpOffLmtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppCvrgAmt = this.dppCvrgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lmsmAmt = this.lmsmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monDpcRtAmt = this.monDpcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtIssOfcCd = this.agmtIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtPrdCd = this.drpOffLmtPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlToTrVal = this.rntlToTrVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdZt4 = this.eqTpszCdZt4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhHndlRtAmt = this.offhHndlRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtExpDt = this.agmtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ohnInitValAmt = this.ohnInitValAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlToTitle = this.rntlToTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSf2 = this.eqTpszCdSf2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssLseRtAmt = this.chssLseRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdCb4 = this.eqTpszCdCb4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initDpcRtAmt = this.initDpcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyRntlToTrVal = this.keyRntlToTrVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlFmTitle = this.rntlFmTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdGn4 = this.eqTpszCdGn4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdGn5 = this.eqTpszCdGn5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstVerFlg = this.lstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEffDt = this.preEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdSl2 = this.eqTpszCdSl2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDt = this.agmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppRtAmt = this.dppRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdEg8 = this.eqTpszCdEg8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdTa2 = this.eqTpszCdTa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCdEg5 = this.eqTpszCdEg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlFmTrVal = this.rntlFmTrVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionFlag = this.actionFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trRtAmt = this.trRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhHndlRtAmt = this.onhHndlRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preExpDt = this.preExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keySteCd = this.keySteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRntlTpCd = this.eqRntlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstScgRtAmt = this.rgstScgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtQty = this.drpOffLmtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffLmtRto = this.drpOffLmtRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxDpcRtAmt = this.maxDpcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dppTpCd = this.dppTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwUqDocTitNm = this.gwUqDocTitNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwUqDocNo = this.gwUqDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
