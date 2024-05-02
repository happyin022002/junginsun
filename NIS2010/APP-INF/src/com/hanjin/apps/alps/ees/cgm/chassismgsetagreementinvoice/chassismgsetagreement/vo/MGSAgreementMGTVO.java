/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MGSAgreementMGTVO.java
*@FileTitle : MGSAgreementMGTVO
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

public class MGSAgreementMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MGSAgreementMGTVO> models = new ArrayList<MGSAgreementMGTVO>();
	
	/* Column Info */
	private String agmtEffDt = null;
	/* Column Info */
	private String lstVerFlg = null;
	/* Column Info */
	private String mgstPotcScgRtAmt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String preEffDt = null;
	/* Column Info */
	private String onhInitValAmtUmg = null;
	/* Column Info */
	private String agmtDt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String onhInitValAmt = null;
	/* Column Info */
	private String mgstBldpRtAmtUmg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String monDpcRtAmt = null;
	/* Column Info */
	private String mgstBldpRtAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String agmtIssOfcCd = null;
	/* Column Info */
	private String offhHndlRtAmt = null;
	/* Column Info */
	private String agmtExpDt = null;
	/* Column Info */
	private String actionFlag = null;
	/* Column Info */
	private String mgstPotcScgRtAmtClg = null;
	/* Column Info */
	private String mgstLseFxRtAmtClg = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String onhHndlRtAmt = null;
	/* Column Info */
	private String onhInitValAmtClg = null;
	/* Column Info */
	private String mgstPrtcScgRtAmt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String preExpDt = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String mgstPotcScgRtAmtUmg = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String initDpcRtAmt = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String maxDpcRtAmt = null;
	/* Column Info */
	private String mgstPrtcScgRtAmtUmg = null;
	/* Column Info */
	private String mgstLseFxRtAmt = null;
	/* Column Info */
	private String mgstLseFxRtAmtUmg = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String mgstBldpRtAmtClg = null;
	/* Column Info */
	private String mgstPrtcScgRtAmtClg = null;
	/* Column Info */
	private String gwUqDocTitNm = null;
	/* Column Info */
	private String gwUqDocNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MGSAgreementMGTVO() {}

	public MGSAgreementMGTVO(String ibflag, String pagerows, String mgstPotcScgRtAmt, String lstVerFlg, String currCd, String onhInitValAmtUmg, String preEffDt, String creDt, String vndrLglEngNm, String mgstBldpRtAmtUmg, String onhInitValAmt, String monDpcRtAmt, String mgstBldpRtAmt, String effDt, String agmtIssOfcCd, String offhHndlRtAmt, String actionFlag, String mgstPotcScgRtAmtClg, String mgstLseFxRtAmtClg, String expDt, String onhHndlRtAmt, String onhInitValAmtClg, String mgstPrtcScgRtAmt, String updUsrId, String agmtRefNo, String preExpDt, String mgstPotcScgRtAmtUmg, String agmtSeq, String agmtNo, String agmtLstmCd, String eqKndCd, String payTermDys, String initDpcRtAmt, String eqTpszCd, String creUsrId, String diffRmk, String agmtOfcCtyCd, String vndrSeq, String maxDpcRtAmt, String mgstPrtcScgRtAmtUmg, String mgstLseFxRtAmt, String mgstLseFxRtAmtUmg, String agmtVerNo, String mgstPrtcScgRtAmtClg, String mgstBldpRtAmtClg, String agmtDt, String agmtEffDt, String agmtExpDt, String gwUqDocTitNm, String gwUqDocNo) {
		this.agmtEffDt = agmtEffDt;
		this.lstVerFlg = lstVerFlg;
		this.mgstPotcScgRtAmt = mgstPotcScgRtAmt;
		this.currCd = currCd;
		this.preEffDt = preEffDt;
		this.onhInitValAmtUmg = onhInitValAmtUmg;
		this.agmtDt = agmtDt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.creDt = creDt;
		this.onhInitValAmt = onhInitValAmt;
		this.mgstBldpRtAmtUmg = mgstBldpRtAmtUmg;
		this.pagerows = pagerows;
		this.monDpcRtAmt = monDpcRtAmt;
		this.mgstBldpRtAmt = mgstBldpRtAmt;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.agmtIssOfcCd = agmtIssOfcCd;
		this.offhHndlRtAmt = offhHndlRtAmt;
		this.agmtExpDt = agmtExpDt;
		this.actionFlag = actionFlag;
		this.mgstPotcScgRtAmtClg = mgstPotcScgRtAmtClg;
		this.mgstLseFxRtAmtClg = mgstLseFxRtAmtClg;
		this.expDt = expDt;
		this.onhHndlRtAmt = onhHndlRtAmt;
		this.onhInitValAmtClg = onhInitValAmtClg;
		this.mgstPrtcScgRtAmt = mgstPrtcScgRtAmt;
		this.updUsrId = updUsrId;
		this.preExpDt = preExpDt;
		this.agmtRefNo = agmtRefNo;
		this.mgstPotcScgRtAmtUmg = mgstPotcScgRtAmtUmg;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.agmtLstmCd = agmtLstmCd;
		this.eqKndCd = eqKndCd;
		this.initDpcRtAmt = initDpcRtAmt;
		this.payTermDys = payTermDys;
		this.eqTpszCd = eqTpszCd;
		this.creUsrId = creUsrId;
		this.diffRmk = diffRmk;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.maxDpcRtAmt = maxDpcRtAmt;
		this.mgstPrtcScgRtAmtUmg = mgstPrtcScgRtAmtUmg;
		this.mgstLseFxRtAmt = mgstLseFxRtAmt;
		this.mgstLseFxRtAmtUmg = mgstLseFxRtAmtUmg;
		this.agmtVerNo = agmtVerNo;
		this.mgstBldpRtAmtClg = mgstBldpRtAmtClg;
		this.mgstPrtcScgRtAmtClg = mgstPrtcScgRtAmtClg;
		this.gwUqDocTitNm = gwUqDocTitNm;
		this.gwUqDocNo = gwUqDocNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_eff_dt", getAgmtEffDt());
		this.hashColumns.put("lst_ver_flg", getLstVerFlg());
		this.hashColumns.put("mgst_potc_scg_rt_amt", getMgstPotcScgRtAmt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pre_eff_dt", getPreEffDt());
		this.hashColumns.put("onh_init_val_amt_umg", getOnhInitValAmtUmg());
		this.hashColumns.put("agmt_dt", getAgmtDt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("onh_init_val_amt", getOnhInitValAmt());
		this.hashColumns.put("mgst_bldp_rt_amt_umg", getMgstBldpRtAmtUmg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mon_dpc_rt_amt", getMonDpcRtAmt());
		this.hashColumns.put("mgst_bldp_rt_amt", getMgstBldpRtAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("agmt_iss_ofc_cd", getAgmtIssOfcCd());
		this.hashColumns.put("offh_hndl_rt_amt", getOffhHndlRtAmt());
		this.hashColumns.put("agmt_exp_dt", getAgmtExpDt());
		this.hashColumns.put("action_flag", getActionFlag());
		this.hashColumns.put("mgst_potc_scg_rt_amt_clg", getMgstPotcScgRtAmtClg());
		this.hashColumns.put("mgst_lse_fx_rt_amt_clg", getMgstLseFxRtAmtClg());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("onh_hndl_rt_amt", getOnhHndlRtAmt());
		this.hashColumns.put("onh_init_val_amt_clg", getOnhInitValAmtClg());
		this.hashColumns.put("mgst_prtc_scg_rt_amt", getMgstPrtcScgRtAmt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("pre_exp_dt", getPreExpDt());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("mgst_potc_scg_rt_amt_umg", getMgstPotcScgRtAmtUmg());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("init_dpc_rt_amt", getInitDpcRtAmt());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("max_dpc_rt_amt", getMaxDpcRtAmt());
		this.hashColumns.put("mgst_prtc_scg_rt_amt_umg", getMgstPrtcScgRtAmtUmg());
		this.hashColumns.put("mgst_lse_fx_rt_amt", getMgstLseFxRtAmt());
		this.hashColumns.put("mgst_lse_fx_rt_amt_umg", getMgstLseFxRtAmtUmg());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("mgst_bldp_rt_amt_clg", getMgstBldpRtAmtClg());
		this.hashColumns.put("mgst_prtc_scg_rt_amt_clg", getMgstPrtcScgRtAmtClg());
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
		this.hashFields.put("lst_ver_flg", "lstVerFlg");
		this.hashFields.put("mgst_potc_scg_rt_amt", "mgstPotcScgRtAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pre_eff_dt", "preEffDt");
		this.hashFields.put("onh_init_val_amt_umg", "onhInitValAmtUmg");
		this.hashFields.put("agmt_dt", "agmtDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("onh_init_val_amt", "onhInitValAmt");
		this.hashFields.put("mgst_bldp_rt_amt_umg", "mgstBldpRtAmtUmg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mon_dpc_rt_amt", "monDpcRtAmt");
		this.hashFields.put("mgst_bldp_rt_amt", "mgstBldpRtAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("agmt_iss_ofc_cd", "agmtIssOfcCd");
		this.hashFields.put("offh_hndl_rt_amt", "offhHndlRtAmt");
		this.hashFields.put("agmt_exp_dt", "agmtExpDt");
		this.hashFields.put("action_flag", "actionFlag");
		this.hashFields.put("mgst_potc_scg_rt_amt_clg", "mgstPotcScgRtAmtClg");
		this.hashFields.put("mgst_lse_fx_rt_amt_clg", "mgstLseFxRtAmtClg");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("onh_hndl_rt_amt", "onhHndlRtAmt");
		this.hashFields.put("onh_init_val_amt_clg", "onhInitValAmtClg");
		this.hashFields.put("mgst_prtc_scg_rt_amt", "mgstPrtcScgRtAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pre_exp_dt", "preExpDt");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("mgst_potc_scg_rt_amt_umg", "mgstPotcScgRtAmtUmg");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("init_dpc_rt_amt", "initDpcRtAmt");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("max_dpc_rt_amt", "maxDpcRtAmt");
		this.hashFields.put("mgst_prtc_scg_rt_amt_umg", "mgstPrtcScgRtAmtUmg");
		this.hashFields.put("mgst_lse_fx_rt_amt", "mgstLseFxRtAmt");
		this.hashFields.put("mgst_lse_fx_rt_amt_umg", "mgstLseFxRtAmtUmg");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("mgst_bldp_rt_amt_clg", "mgstBldpRtAmtClg");
		this.hashFields.put("mgst_prtc_scg_rt_amt_clg", "mgstPrtcScgRtAmtClg");
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
	 * @return lstVerFlg
	 */
	public String getLstVerFlg() {
		return this.lstVerFlg;
	}
	
	/**
	 * Column Info
	 * @return mgstPotcScgRtAmt
	 */
	public String getMgstPotcScgRtAmt() {
		return this.mgstPotcScgRtAmt;
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
	 * @return onhInitValAmtUmg
	 */
	public String getOnhInitValAmtUmg() {
		return this.onhInitValAmtUmg;
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
	 * @return onhInitValAmt
	 */
	public String getOnhInitValAmt() {
		return this.onhInitValAmt;
	}
	
	/**
	 * Column Info
	 * @return mgstBldpRtAmtUmg
	 */
	public String getMgstBldpRtAmtUmg() {
		return this.mgstBldpRtAmtUmg;
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
	 * @return mgstBldpRtAmt
	 */
	public String getMgstBldpRtAmt() {
		return this.mgstBldpRtAmt;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return actionFlag
	 */
	public String getActionFlag() {
		return this.actionFlag;
	}
	
	/**
	 * Column Info
	 * @return mgstPotcScgRtAmtClg
	 */
	public String getMgstPotcScgRtAmtClg() {
		return this.mgstPotcScgRtAmtClg;
	}
	
	/**
	 * Column Info
	 * @return mgstLseFxRtAmtClg
	 */
	public String getMgstLseFxRtAmtClg() {
		return this.mgstLseFxRtAmtClg;
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
	 * @return onhHndlRtAmt
	 */
	public String getOnhHndlRtAmt() {
		return this.onhHndlRtAmt;
	}
	
	/**
	 * Column Info
	 * @return onhInitValAmtClg
	 */
	public String getOnhInitValAmtClg() {
		return this.onhInitValAmtClg;
	}
	
	/**
	 * Column Info
	 * @return mgstPrtcScgRtAmt
	 */
	public String getMgstPrtcScgRtAmt() {
		return this.mgstPrtcScgRtAmt;
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
	 * @return preExpDt
	 */
	public String getPreExpDt() {
		return this.preExpDt;
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
	 * @return mgstPotcScgRtAmtUmg
	 */
	public String getMgstPotcScgRtAmtUmg() {
		return this.mgstPotcScgRtAmtUmg;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return payTermDys
	 */
	public String getPayTermDys() {
		return this.payTermDys;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
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
	 * @return maxDpcRtAmt
	 */
	public String getMaxDpcRtAmt() {
		return this.maxDpcRtAmt;
	}
	
	/**
	 * Column Info
	 * @return mgstPrtcScgRtAmtUmg
	 */
	public String getMgstPrtcScgRtAmtUmg() {
		return this.mgstPrtcScgRtAmtUmg;
	}
	
	/**
	 * Column Info
	 * @return mgstLseFxRtAmt
	 */
	public String getMgstLseFxRtAmt() {
		return this.mgstLseFxRtAmt;
	}
	
	/**
	 * Column Info
	 * @return mgstLseFxRtAmtUmg
	 */
	public String getMgstLseFxRtAmtUmg() {
		return this.mgstLseFxRtAmtUmg;
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
	 * @return mgstBldpRtAmtClg
	 */
	public String getMgstBldpRtAmtClg() {
		return this.mgstBldpRtAmtClg;
	}
	
	/**
	 * Column Info
	 * @return mgstPrtcScgRtAmtClg
	 */
	public String getMgstPrtcScgRtAmtClg() {
		return this.mgstPrtcScgRtAmtClg;
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
	 * @param lstVerFlg
	 */
	public void setLstVerFlg(String lstVerFlg) {
		this.lstVerFlg = lstVerFlg;
	}
	
	/**
	 * Column Info
	 * @param mgstPotcScgRtAmt
	 */
	public void setMgstPotcScgRtAmt(String mgstPotcScgRtAmt) {
		this.mgstPotcScgRtAmt = mgstPotcScgRtAmt;
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
	 * @param onhInitValAmtUmg
	 */
	public void setOnhInitValAmtUmg(String onhInitValAmtUmg) {
		this.onhInitValAmtUmg = onhInitValAmtUmg;
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
	 * @param onhInitValAmt
	 */
	public void setOnhInitValAmt(String onhInitValAmt) {
		this.onhInitValAmt = onhInitValAmt;
	}
	
	/**
	 * Column Info
	 * @param mgstBldpRtAmtUmg
	 */
	public void setMgstBldpRtAmtUmg(String mgstBldpRtAmtUmg) {
		this.mgstBldpRtAmtUmg = mgstBldpRtAmtUmg;
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
	 * @param mgstBldpRtAmt
	 */
	public void setMgstBldpRtAmt(String mgstBldpRtAmt) {
		this.mgstBldpRtAmt = mgstBldpRtAmt;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param actionFlag
	 */
	public void setActionFlag(String actionFlag) {
		this.actionFlag = actionFlag;
	}
	
	/**
	 * Column Info
	 * @param mgstPotcScgRtAmtClg
	 */
	public void setMgstPotcScgRtAmtClg(String mgstPotcScgRtAmtClg) {
		this.mgstPotcScgRtAmtClg = mgstPotcScgRtAmtClg;
	}
	
	/**
	 * Column Info
	 * @param mgstLseFxRtAmtClg
	 */
	public void setMgstLseFxRtAmtClg(String mgstLseFxRtAmtClg) {
		this.mgstLseFxRtAmtClg = mgstLseFxRtAmtClg;
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
	 * @param onhHndlRtAmt
	 */
	public void setOnhHndlRtAmt(String onhHndlRtAmt) {
		this.onhHndlRtAmt = onhHndlRtAmt;
	}
	
	/**
	 * Column Info
	 * @param onhInitValAmtClg
	 */
	public void setOnhInitValAmtClg(String onhInitValAmtClg) {
		this.onhInitValAmtClg = onhInitValAmtClg;
	}
	
	/**
	 * Column Info
	 * @param mgstPrtcScgRtAmt
	 */
	public void setMgstPrtcScgRtAmt(String mgstPrtcScgRtAmt) {
		this.mgstPrtcScgRtAmt = mgstPrtcScgRtAmt;
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
	 * @param preExpDt
	 */
	public void setPreExpDt(String preExpDt) {
		this.preExpDt = preExpDt;
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
	 * @param mgstPotcScgRtAmtUmg
	 */
	public void setMgstPotcScgRtAmtUmg(String mgstPotcScgRtAmtUmg) {
		this.mgstPotcScgRtAmtUmg = mgstPotcScgRtAmtUmg;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param payTermDys
	 */
	public void setPayTermDys(String payTermDys) {
		this.payTermDys = payTermDys;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
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
	 * @param maxDpcRtAmt
	 */
	public void setMaxDpcRtAmt(String maxDpcRtAmt) {
		this.maxDpcRtAmt = maxDpcRtAmt;
	}
	
	/**
	 * Column Info
	 * @param mgstPrtcScgRtAmtUmg
	 */
	public void setMgstPrtcScgRtAmtUmg(String mgstPrtcScgRtAmtUmg) {
		this.mgstPrtcScgRtAmtUmg = mgstPrtcScgRtAmtUmg;
	}
	
	/**
	 * Column Info
	 * @param mgstLseFxRtAmt
	 */
	public void setMgstLseFxRtAmt(String mgstLseFxRtAmt) {
		this.mgstLseFxRtAmt = mgstLseFxRtAmt;
	}
	
	/**
	 * Column Info
	 * @param mgstLseFxRtAmtUmg
	 */
	public void setMgstLseFxRtAmtUmg(String mgstLseFxRtAmtUmg) {
		this.mgstLseFxRtAmtUmg = mgstLseFxRtAmtUmg;
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
	 * @param mgstBldpRtAmtClg
	 */
	public void setMgstBldpRtAmtClg(String mgstBldpRtAmtClg) {
		this.mgstBldpRtAmtClg = mgstBldpRtAmtClg;
	}
	
	/**
	 * Column Info
	 * @param mgstPrtcScgRtAmtClg
	 */
	public void setMgstPrtcScgRtAmtClg(String mgstPrtcScgRtAmtClg) {
		this.mgstPrtcScgRtAmtClg = mgstPrtcScgRtAmtClg;
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
		setLstVerFlg(JSPUtil.getParameter(request, "lst_ver_flg", ""));
		setMgstPotcScgRtAmt(JSPUtil.getParameter(request, "mgst_potc_scg_rt_amt", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setPreEffDt(JSPUtil.getParameter(request, "pre_eff_dt", ""));
		setOnhInitValAmtUmg(JSPUtil.getParameter(request, "onh_init_val_amt_umg", ""));
		setAgmtDt(JSPUtil.getParameter(request, "agmt_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setOnhInitValAmt(JSPUtil.getParameter(request, "onh_init_val_amt", ""));
		setMgstBldpRtAmtUmg(JSPUtil.getParameter(request, "mgst_bldp_rt_amt_umg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMonDpcRtAmt(JSPUtil.getParameter(request, "mon_dpc_rt_amt", ""));
		setMgstBldpRtAmt(JSPUtil.getParameter(request, "mgst_bldp_rt_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setAgmtIssOfcCd(JSPUtil.getParameter(request, "agmt_iss_ofc_cd", ""));
		setOffhHndlRtAmt(JSPUtil.getParameter(request, "offh_hndl_rt_amt", ""));
		setAgmtExpDt(JSPUtil.getParameter(request, "agmt_exp_dt", ""));
		setActionFlag(JSPUtil.getParameter(request, "action_flag", ""));
		setMgstPotcScgRtAmtClg(JSPUtil.getParameter(request, "mgst_potc_scg_rt_amt_clg", ""));
		setMgstLseFxRtAmtClg(JSPUtil.getParameter(request, "mgst_lse_fx_rt_amt_clg", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setOnhHndlRtAmt(JSPUtil.getParameter(request, "onh_hndl_rt_amt", ""));
		setOnhInitValAmtClg(JSPUtil.getParameter(request, "onh_init_val_amt_clg", ""));
		setMgstPrtcScgRtAmt(JSPUtil.getParameter(request, "mgst_prtc_scg_rt_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setPreExpDt(JSPUtil.getParameter(request, "pre_exp_dt", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, "agmt_ref_no", ""));
		setMgstPotcScgRtAmtUmg(JSPUtil.getParameter(request, "mgst_potc_scg_rt_amt_umg", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setInitDpcRtAmt(JSPUtil.getParameter(request, "init_dpc_rt_amt", ""));
		setPayTermDys(JSPUtil.getParameter(request, "pay_term_dys", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setMaxDpcRtAmt(JSPUtil.getParameter(request, "max_dpc_rt_amt", ""));
		setMgstPrtcScgRtAmtUmg(JSPUtil.getParameter(request, "mgst_prtc_scg_rt_amt_umg", ""));
		setMgstLseFxRtAmt(JSPUtil.getParameter(request, "mgst_lse_fx_rt_amt", ""));
		setMgstLseFxRtAmtUmg(JSPUtil.getParameter(request, "mgst_lse_fx_rt_amt_umg", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setMgstBldpRtAmtClg(JSPUtil.getParameter(request, "mgst_bldp_rt_amt_clg", ""));
		setMgstPrtcScgRtAmtClg(JSPUtil.getParameter(request, "mgst_prtc_scg_rt_amt_clg", ""));
		setGwUqDocTitNm(JSPUtil.getParameter(request, "gw_uq_doc_tit_nm", ""));
		setGwUqDocNo(JSPUtil.getParameter(request, "gw_uq_doc_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSAgreementMGTVO[]
	 */
	public MGSAgreementMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MGSAgreementMGTVO[]
	 */
	public MGSAgreementMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MGSAgreementMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtEffDt = (JSPUtil.getParameter(request, prefix	+ "agmt_eff_dt", length));
			String[] lstVerFlg = (JSPUtil.getParameter(request, prefix	+ "lst_ver_flg", length));
			String[] mgstPotcScgRtAmt = (JSPUtil.getParameter(request, prefix	+ "mgst_potc_scg_rt_amt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] preEffDt = (JSPUtil.getParameter(request, prefix	+ "pre_eff_dt", length));
			String[] onhInitValAmtUmg = (JSPUtil.getParameter(request, prefix	+ "onh_init_val_amt_umg", length));
			String[] agmtDt = (JSPUtil.getParameter(request, prefix	+ "agmt_dt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] onhInitValAmt = (JSPUtil.getParameter(request, prefix	+ "onh_init_val_amt", length));
			String[] mgstBldpRtAmtUmg = (JSPUtil.getParameter(request, prefix	+ "mgst_bldp_rt_amt_umg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] monDpcRtAmt = (JSPUtil.getParameter(request, prefix	+ "mon_dpc_rt_amt", length));
			String[] mgstBldpRtAmt = (JSPUtil.getParameter(request, prefix	+ "mgst_bldp_rt_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] agmtIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_iss_ofc_cd", length));
			String[] offhHndlRtAmt = (JSPUtil.getParameter(request, prefix	+ "offh_hndl_rt_amt", length));
			String[] agmtExpDt = (JSPUtil.getParameter(request, prefix	+ "agmt_exp_dt", length));
			String[] actionFlag = (JSPUtil.getParameter(request, prefix	+ "action_flag", length));
			String[] mgstPotcScgRtAmtClg = (JSPUtil.getParameter(request, prefix	+ "mgst_potc_scg_rt_amt_clg", length));
			String[] mgstLseFxRtAmtClg = (JSPUtil.getParameter(request, prefix	+ "mgst_lse_fx_rt_amt_clg", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] onhHndlRtAmt = (JSPUtil.getParameter(request, prefix	+ "onh_hndl_rt_amt", length));
			String[] onhInitValAmtClg = (JSPUtil.getParameter(request, prefix	+ "onh_init_val_amt_clg", length));
			String[] mgstPrtcScgRtAmt = (JSPUtil.getParameter(request, prefix	+ "mgst_prtc_scg_rt_amt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] preExpDt = (JSPUtil.getParameter(request, prefix	+ "pre_exp_dt", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] mgstPotcScgRtAmtUmg = (JSPUtil.getParameter(request, prefix	+ "mgst_potc_scg_rt_amt_umg", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] initDpcRtAmt = (JSPUtil.getParameter(request, prefix	+ "init_dpc_rt_amt", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] maxDpcRtAmt = (JSPUtil.getParameter(request, prefix	+ "max_dpc_rt_amt", length));
			String[] mgstPrtcScgRtAmtUmg = (JSPUtil.getParameter(request, prefix	+ "mgst_prtc_scg_rt_amt_umg", length));
			String[] mgstLseFxRtAmt = (JSPUtil.getParameter(request, prefix	+ "mgst_lse_fx_rt_amt", length));
			String[] mgstLseFxRtAmtUmg = (JSPUtil.getParameter(request, prefix	+ "mgst_lse_fx_rt_amt_umg", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] mgstBldpRtAmtClg = (JSPUtil.getParameter(request, prefix	+ "mgst_bldp_rt_amt_clg", length));
			String[] mgstPrtcScgRtAmtClg = (JSPUtil.getParameter(request, prefix	+ "mgst_prtc_scg_rt_amt_clg", length));
			String[] gwUqDocTitNm = (JSPUtil.getParameter(request, prefix + "gw_uq_doc_tit_nm", length));
			String[] gwUqDocNo = (JSPUtil.getParameter(request, prefix + "gw_uq_doc_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new MGSAgreementMGTVO();
				if (agmtEffDt[i] != null)
					model.setAgmtEffDt(agmtEffDt[i]);
				if (lstVerFlg[i] != null)
					model.setLstVerFlg(lstVerFlg[i]);
				if (mgstPotcScgRtAmt[i] != null)
					model.setMgstPotcScgRtAmt(mgstPotcScgRtAmt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (preEffDt[i] != null)
					model.setPreEffDt(preEffDt[i]);
				if (onhInitValAmtUmg[i] != null)
					model.setOnhInitValAmtUmg(onhInitValAmtUmg[i]);
				if (agmtDt[i] != null)
					model.setAgmtDt(agmtDt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (onhInitValAmt[i] != null)
					model.setOnhInitValAmt(onhInitValAmt[i]);
				if (mgstBldpRtAmtUmg[i] != null)
					model.setMgstBldpRtAmtUmg(mgstBldpRtAmtUmg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (monDpcRtAmt[i] != null)
					model.setMonDpcRtAmt(monDpcRtAmt[i]);
				if (mgstBldpRtAmt[i] != null)
					model.setMgstBldpRtAmt(mgstBldpRtAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (agmtIssOfcCd[i] != null)
					model.setAgmtIssOfcCd(agmtIssOfcCd[i]);
				if (offhHndlRtAmt[i] != null)
					model.setOffhHndlRtAmt(offhHndlRtAmt[i]);
				if (agmtExpDt[i] != null)
					model.setAgmtExpDt(agmtExpDt[i]);
				if (actionFlag[i] != null)
					model.setActionFlag(actionFlag[i]);
				if (mgstPotcScgRtAmtClg[i] != null)
					model.setMgstPotcScgRtAmtClg(mgstPotcScgRtAmtClg[i]);
				if (mgstLseFxRtAmtClg[i] != null)
					model.setMgstLseFxRtAmtClg(mgstLseFxRtAmtClg[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (onhHndlRtAmt[i] != null)
					model.setOnhHndlRtAmt(onhHndlRtAmt[i]);
				if (onhInitValAmtClg[i] != null)
					model.setOnhInitValAmtClg(onhInitValAmtClg[i]);
				if (mgstPrtcScgRtAmt[i] != null)
					model.setMgstPrtcScgRtAmt(mgstPrtcScgRtAmt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (preExpDt[i] != null)
					model.setPreExpDt(preExpDt[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (mgstPotcScgRtAmtUmg[i] != null)
					model.setMgstPotcScgRtAmtUmg(mgstPotcScgRtAmtUmg[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (initDpcRtAmt[i] != null)
					model.setInitDpcRtAmt(initDpcRtAmt[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (maxDpcRtAmt[i] != null)
					model.setMaxDpcRtAmt(maxDpcRtAmt[i]);
				if (mgstPrtcScgRtAmtUmg[i] != null)
					model.setMgstPrtcScgRtAmtUmg(mgstPrtcScgRtAmtUmg[i]);
				if (mgstLseFxRtAmt[i] != null)
					model.setMgstLseFxRtAmt(mgstLseFxRtAmt[i]);
				if (mgstLseFxRtAmtUmg[i] != null)
					model.setMgstLseFxRtAmtUmg(mgstLseFxRtAmtUmg[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (mgstBldpRtAmtClg[i] != null)
					model.setMgstBldpRtAmtClg(mgstBldpRtAmtClg[i]);
				if (mgstPrtcScgRtAmtClg[i] != null)
					model.setMgstPrtcScgRtAmtClg(mgstPrtcScgRtAmtClg[i]);
				if (gwUqDocTitNm[i] != null)
					model.setGwUqDocTitNm(gwUqDocTitNm[i]);
				if (gwUqDocNo[i] != null)
					model.setGwUqDocNo(gwUqDocNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMGSAgreementMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MGSAgreementMGTVO[]
	 */
	public MGSAgreementMGTVO[] getMGSAgreementMGTVOs(){
		MGSAgreementMGTVO[] vos = (MGSAgreementMGTVO[])models.toArray(new MGSAgreementMGTVO[models.size()]);
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
		this.lstVerFlg = this.lstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPotcScgRtAmt = this.mgstPotcScgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEffDt = this.preEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhInitValAmtUmg = this.onhInitValAmtUmg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDt = this.agmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhInitValAmt = this.onhInitValAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstBldpRtAmtUmg = this.mgstBldpRtAmtUmg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.monDpcRtAmt = this.monDpcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstBldpRtAmt = this.mgstBldpRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtIssOfcCd = this.agmtIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhHndlRtAmt = this.offhHndlRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtExpDt = this.agmtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionFlag = this.actionFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPotcScgRtAmtClg = this.mgstPotcScgRtAmtClg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstLseFxRtAmtClg = this.mgstLseFxRtAmtClg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhHndlRtAmt = this.onhHndlRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhInitValAmtClg = this.onhInitValAmtClg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPrtcScgRtAmt = this.mgstPrtcScgRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preExpDt = this.preExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPotcScgRtAmtUmg = this.mgstPotcScgRtAmtUmg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initDpcRtAmt = this.initDpcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxDpcRtAmt = this.maxDpcRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPrtcScgRtAmtUmg = this.mgstPrtcScgRtAmtUmg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstLseFxRtAmt = this.mgstLseFxRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstLseFxRtAmtUmg = this.mgstLseFxRtAmtUmg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstBldpRtAmtClg = this.mgstBldpRtAmtClg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstPrtcScgRtAmtClg = this.mgstPrtcScgRtAmtClg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwUqDocTitNm = this.gwUqDocTitNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwUqDocNo = this.gwUqDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
