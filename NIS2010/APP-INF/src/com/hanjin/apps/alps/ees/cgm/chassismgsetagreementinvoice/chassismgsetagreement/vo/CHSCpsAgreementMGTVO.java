/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CHSCpsAgreementMGTVO.java
*@FileTitle : CHSCpsAgreementMGTVO
*Open Issues :
*Change history : 1. 2014-07-18 stStopYdFlg 추가 (Start/Stop Flag), 신용찬
*@LastModifyDate : 2013.04.17
*@LastModifier : 이영헌
*@LastVersion : 1.0
* 2013.04.17 이영헌 
* 1.0 Creation
* History
* 2014.11 Chagn Young Kim 10만불 결제관련
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

import java.lang.reflect.Field;
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
 * @author 이영헌
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CHSCpsAgreementMGTVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CHSCpsAgreementMGTVO> models = new ArrayList<CHSCpsAgreementMGTVO>();
	
	/* Column Info */
	private String agmtEffDt = null;
	/* Column Info */
	private String lstVerFlg = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String chssPoolCd = null;
	/* Column Info */
	private String preEffDt = null;
	/* Column Info */
	private String chssPoolTaxRt = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String creDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ddctTpCd = null;
	/* Column Info */
	private String chssPoolRtAmt = null;
	/* Column Info */
	private String ctrtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String agmtIssOfcCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String agmtRmk = null;
	/* Column Info */
	private String agmtExpDt = null;
	/* Column Info */
	private String actionFlag = null;
	/* Column Info */
	private String lrLocNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String chssYdTpCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String preExpDt = null;
	/* Column Info */
	private String agmtRefNo = null;
	/* Column Info */
	private String dmstUsgFlg = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String agmtLstmCd = null;
	/* Column Info */
	private String payTermDys = null;
	/* Column Info */
	private String duration = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String amtAudFlg = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String onTmlChgFlg = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String dmstOnTmlChgFlg = null;
	/* Column Info */
	private String dmstPdChgFlg = null;
	/* Column Info */
	private String onTmlMtyChgFlg = null;
	/* Column Info */
	private String bilablSpclCntrTpNm = null;
	/* Column Info */
	private String stStopYdFlg = null;  // Start/Stop, 2014-07-18, 신용찬
	/* Column Info */
	private String gwUqDocTitNm = null;
	/* Column Info */
	private String gwUqDocNo = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CHSCpsAgreementMGTVO() {}

	public CHSCpsAgreementMGTVO(String ibflag, String pagerows, String agmtSeq, String agmtNo, String agmtOfcCtyCd, String agmtVerNo, String agmtLstmCd, String chssPoolCd, String currCd, String agmtEffDt, String agmtExpDt, String duration, String ctrtNo, String agmtRefNo, String vndrSeq, String vndrLglEngNm, String payTermDys, String agmtIssOfcCd, String creUsrId, String creDt, String updUsrId, String updDt, String diffRmk, String locCd, String amtAudFlg, String chssPoolRtAmt, String chssPoolTaxRt, String dmstUsgFlg, String agmtRmk, String ydCd, String ydNm, String chssYdTpCd, String lrLocNm, String onTmlChgFlg, String ddctTpCd, String actionFlag, String lstVerFlg, String preEffDt, String preExpDt, String dmstOnTmlChgFlg, String dmstPdChgFlg, String onTmlMtyChgFlg, String bilablSpclCntrTpNm, String stStopYdFlg, String gwUqDocTitNm, String gwUqDocNo) {
		this.agmtEffDt = agmtEffDt;
		this.lstVerFlg = lstVerFlg;
		this.currCd = currCd;
		this.chssPoolCd = chssPoolCd;
		this.preEffDt = preEffDt;
		this.chssPoolTaxRt = chssPoolTaxRt;
		this.vndrLglEngNm = vndrLglEngNm;
		this.creDt = creDt;
		this.pagerows = pagerows;
		this.ddctTpCd = ddctTpCd;
		this.chssPoolRtAmt = chssPoolRtAmt;
		this.ctrtNo = ctrtNo;
		this.ibflag = ibflag;
		this.agmtIssOfcCd = agmtIssOfcCd;
		this.locCd = locCd;
		this.agmtRmk = agmtRmk;
		this.agmtExpDt = agmtExpDt;
		this.actionFlag = actionFlag;
		this.lrLocNm = lrLocNm;
		this.updUsrId = updUsrId;
		this.chssYdTpCd = chssYdTpCd;
		this.updDt = updDt;
		this.preExpDt = preExpDt;
		this.agmtRefNo = agmtRefNo;
		this.dmstUsgFlg = dmstUsgFlg;
		this.agmtSeq = agmtSeq;
		this.agmtNo = agmtNo;
		this.agmtLstmCd = agmtLstmCd;
		this.payTermDys = payTermDys;
		this.duration = duration;
		this.creUsrId = creUsrId;
		this.diffRmk = diffRmk;
		this.amtAudFlg = amtAudFlg;
		this.ydCd = ydCd;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.vndrSeq = vndrSeq;
		this.ydNm = ydNm;
		this.onTmlChgFlg = onTmlChgFlg;
		this.agmtVerNo = agmtVerNo;
		this.dmstOnTmlChgFlg = dmstOnTmlChgFlg;
		this.dmstPdChgFlg = dmstPdChgFlg;
		this.onTmlMtyChgFlg = onTmlMtyChgFlg;
		this.bilablSpclCntrTpNm = bilablSpclCntrTpNm;
		this.stStopYdFlg = stStopYdFlg;
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
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("chss_pool_cd", getChssPoolCd());
		this.hashColumns.put("pre_eff_dt", getPreEffDt());
		this.hashColumns.put("chss_pool_tax_rt", getChssPoolTaxRt());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ddct_tp_cd", getDdctTpCd());
		this.hashColumns.put("chss_pool_rt_amt", getChssPoolRtAmt());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("agmt_iss_ofc_cd", getAgmtIssOfcCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("agmt_rmk", getAgmtRmk());
		this.hashColumns.put("agmt_exp_dt", getAgmtExpDt());
		this.hashColumns.put("action_flag", getActionFlag());
		this.hashColumns.put("lr_loc_nm", getLrLocNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("chss_yd_tp_cd", getChssYdTpCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("pre_exp_dt", getPreExpDt());
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());
		this.hashColumns.put("dmst_usg_flg", getDmstUsgFlg());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());
		this.hashColumns.put("pay_term_dys", getPayTermDys());
		this.hashColumns.put("duration", getDuration());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("amt_aud_flg", getAmtAudFlg());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("on_tml_chg_flg", getOnTmlChgFlg());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("dmst_on_tml_chg_flg", getDmstOnTmlChgFlg());
		this.hashColumns.put("dmst_pd_chg_flg", getDmstPdChgFlg());
		this.hashColumns.put("on_tml_mty_chg_flg", getOnTmlMtyChgFlg());
		this.hashColumns.put("bilabl_spcl_cntr_tp_nm", getBilablSpclCntrTpNm());
		
		this.hashColumns.put("st_stop_yd_flg", getStStopYdFlg());
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
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("chss_pool_cd", "chssPoolCd");
		this.hashFields.put("pre_eff_dt", "preEffDt");
		this.hashFields.put("chss_pool_tax_rt", "chssPoolTaxRt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ddct_tp_cd", "ddctTpCd");
		this.hashFields.put("chss_pool_rt_amt", "chssPoolRtAmt");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("agmt_iss_ofc_cd", "agmtIssOfcCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("agmt_rmk", "agmtRmk");
		this.hashFields.put("agmt_exp_dt", "agmtExpDt");
		this.hashFields.put("action_flag", "actionFlag");
		this.hashFields.put("lr_loc_nm", "lrLocNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("chss_yd_tp_cd", "chssYdTpCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("pre_exp_dt", "preExpDt");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("dmst_usg_flg", "dmstUsgFlg");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("pay_term_dys", "payTermDys");
		this.hashFields.put("duration", "duration");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("amt_aud_flg", "amtAudFlg");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("on_tml_chg_flg", "onTmlChgFlg");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("dmst_on_tml_chg_flg", "dmstOnTmlChgFlg");
		this.hashFields.put("dmst_pd_chg_flg", "dmstPdChgFlg");
		this.hashFields.put("on_tml_mty_chg_flg", "onTmlMtyChgFlg");
		this.hashFields.put("bilabl_spcl_cntr_tp_nm", "bilablSpclCntrTpNm");
		this.hashFields.put("st_stop_yd_flg", "stStopYdFlg");
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
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return preEffDt
	 */
	public String getPreEffDt() {
		return this.preEffDt;
	}
	
	/**
	 * Column Info
	 * @return chssPoolTaxRt
	 */
	public String getChssPoolTaxRt() {
		return this.chssPoolTaxRt;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return ddctTpCd
	 */
	public String getDdctTpCd() {
		return this.ddctTpCd;
	}
	
	/**
	 * Column Info
	 * @return chssPoolRtAmt
	 */
	public String getChssPoolRtAmt() {
		return this.chssPoolRtAmt;
	}
	
	/**
	 * Column Info
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
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
	 * @return agmtIssOfcCd
	 */
	public String getAgmtIssOfcCd() {
		return this.agmtIssOfcCd;
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
	 * @return agmtRmk
	 */
	public String getAgmtRmk() {
		return this.agmtRmk;
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
	 * @return lrLocNm
	 */
	public String getLrLocNm() {
		return this.lrLocNm;
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
	 * @return chssYdTpCd
	 */
	public String getChssYdTpCd() {
		return this.chssYdTpCd;
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
	 * @return dmstUsgFlg
	 */
	public String getDmstUsgFlg() {
		return this.dmstUsgFlg;
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
	 * @return duration
	 */
	public String getDuration() {
		return this.duration;
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
	 * @return amtAudFlg
	 */
	public String getAmtAudFlg() {
		return this.amtAudFlg;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return onTmlChgFlg
	 */
	public String getOnTmlChgFlg() {
		return this.onTmlChgFlg;
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
	 * @return dmstOnTmlChgFlg
	 */
	public String getDmstOnTmlChgFlg() {
		return this.dmstOnTmlChgFlg;
	}
	
	/**
	 * Column Info
	 * @return dmstPdChgFlg
	 */
	public String getDmstPdChgFlg() {
		return this.dmstPdChgFlg;
	}
	
	/**
	 * Column Info
	 * @return onTmlMtyChgFlg
	 */
	public String getOnTmlMtyChgFlg() {
		return this.onTmlMtyChgFlg;
	}
	
	/**
	 * Column Info
	 * @return bilablSpclCntrTpNm
	 */
	public String getBilablSpclCntrTpNm() {
		return this.bilablSpclCntrTpNm;
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
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param preEffDt
	 */
	public void setPreEffDt(String preEffDt) {
		this.preEffDt = preEffDt;
	}
	
	/**
	 * Column Info
	 * @param chssPoolTaxRt
	 */
	public void setChssPoolTaxRt(String chssPoolTaxRt) {
		this.chssPoolTaxRt = chssPoolTaxRt;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ddctTpCd
	 */
	public void setDdctTpCd(String ddctTpCd) {
		this.ddctTpCd = ddctTpCd;
	}
	
	/**
	 * Column Info
	 * @param chssPoolRtAmt
	 */
	public void setChssPoolRtAmt(String chssPoolRtAmt) {
		this.chssPoolRtAmt = chssPoolRtAmt;
	}
	
	/**
	 * Column Info
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
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
	 * @param agmtIssOfcCd
	 */
	public void setAgmtIssOfcCd(String agmtIssOfcCd) {
		this.agmtIssOfcCd = agmtIssOfcCd;
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
	 * @param agmtRmk
	 */
	public void setAgmtRmk(String agmtRmk) {
		this.agmtRmk = agmtRmk;
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
	 * @param lrLocNm
	 */
	public void setLrLocNm(String lrLocNm) {
		this.lrLocNm = lrLocNm;
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
	 * @param chssYdTpCd
	 */
	public void setChssYdTpCd(String chssYdTpCd) {
		this.chssYdTpCd = chssYdTpCd;
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
	 * @param dmstUsgFlg
	 */
	public void setDmstUsgFlg(String dmstUsgFlg) {
		this.dmstUsgFlg = dmstUsgFlg;
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
	 * @param duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
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
	 * @param amtAudFlg
	 */
	public void setAmtAudFlg(String amtAudFlg) {
		this.amtAudFlg = amtAudFlg;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param onTmlChgFlg
	 */
	public void setOnTmlChgFlg(String onTmlChgFlg) {
		this.onTmlChgFlg = onTmlChgFlg;
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
	 * @param dmstOnTmlChgFlg
	 */
	public void setDmstOnTmlChgFlg(String dmstOnTmlChgFlg) {
		this.dmstOnTmlChgFlg = dmstOnTmlChgFlg;
	}
	
	/**
	 * Column Info
	 * @param dmstPdChgFlg
	 */
	public void setDmstPdChgFlg(String dmstPdChgFlg) {
		this.dmstPdChgFlg = dmstPdChgFlg;
	}
	
	/**
	 * Column Info
	 * @param onTmlMtyChgFlg
	 */
	public void setOnTmlMtyChgFlg(String onTmlMtyChgFlg) {
		this.onTmlMtyChgFlg = onTmlMtyChgFlg;
	}
	
	/**
	 * Column Info
	 * @param bilablSpclCntrTpNm
	 */
	public void setBilablSpclCntrTpNm(String bilablSpclCntrTpNm) {
		this.bilablSpclCntrTpNm = bilablSpclCntrTpNm;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setAgmtEffDt(JSPUtil.getParameter(request, prefix + "agmt_eff_dt", ""));
		setLstVerFlg(JSPUtil.getParameter(request, prefix + "lst_ver_flg", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setChssPoolCd(JSPUtil.getParameter(request, prefix + "chss_pool_cd", ""));
		setPreEffDt(JSPUtil.getParameter(request, prefix + "pre_eff_dt", ""));
		setChssPoolTaxRt(JSPUtil.getParameter(request, prefix + "chss_pool_tax_rt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDdctTpCd(JSPUtil.getParameter(request, prefix + "ddct_tp_cd", ""));
		setChssPoolRtAmt(JSPUtil.getParameter(request, prefix + "chss_pool_rt_amt", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAgmtIssOfcCd(JSPUtil.getParameter(request, prefix + "agmt_iss_ofc_cd", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setAgmtRmk(JSPUtil.getParameter(request, prefix + "agmt_rmk", ""));
		setAgmtExpDt(JSPUtil.getParameter(request, prefix + "agmt_exp_dt", ""));
		setActionFlag(JSPUtil.getParameter(request, prefix + "action_flag", ""));
		setLrLocNm(JSPUtil.getParameter(request, prefix + "lr_loc_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setChssYdTpCd(JSPUtil.getParameter(request, prefix + "chss_yd_tp_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setPreExpDt(JSPUtil.getParameter(request, prefix + "pre_exp_dt", ""));
		setAgmtRefNo(JSPUtil.getParameter(request, prefix + "agmt_ref_no", ""));
		setDmstUsgFlg(JSPUtil.getParameter(request, prefix + "dmst_usg_flg", ""));
		setAgmtSeq(JSPUtil.getParameter(request, prefix + "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request, prefix + "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request, prefix + "agmt_lstm_cd", ""));
		setPayTermDys(JSPUtil.getParameter(request, prefix + "pay_term_dys", ""));
		setDuration(JSPUtil.getParameter(request, prefix + "duration", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setAmtAudFlg(JSPUtil.getParameter(request, prefix + "amt_aud_flg", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, prefix + "agmt_ofc_cty_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setOnTmlChgFlg(JSPUtil.getParameter(request, prefix + "on_tml_chg_flg", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, prefix + "agmt_ver_no", ""));
		setDmstOnTmlChgFlg(JSPUtil.getParameter(request, prefix + "dmst_on_tml_chg_flg", ""));
		setDmstPdChgFlg(JSPUtil.getParameter(request, prefix + "dmst_pd_chg_flg", ""));
		setOnTmlMtyChgFlg(JSPUtil.getParameter(request, prefix + "on_tml_mty_chg_flg", ""));
		setBilablSpclCntrTpNm(JSPUtil.getParameter(request, prefix + "bilabl_spcl_cntr_tp_nm", ""));
		setStStopYdFlg(JSPUtil.getParameter(request, prefix + "st_stop_yd_flg", ""));
		setGwUqDocTitNm(JSPUtil.getParameter(request, prefix + "gw_uq_doc_tit_nm", ""));
		setGwUqDocNo(JSPUtil.getParameter(request, prefix + "gw_uq_doc_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CHSCpsAgreementMGTVO[]
	 */
	public CHSCpsAgreementMGTVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CHSCpsAgreementMGTVO[]
	 */
	public CHSCpsAgreementMGTVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CHSCpsAgreementMGTVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] agmtEffDt = (JSPUtil.getParameter(request, prefix	+ "agmt_eff_dt", length));
			String[] lstVerFlg = (JSPUtil.getParameter(request, prefix	+ "lst_ver_flg", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] chssPoolCd = (JSPUtil.getParameter(request, prefix	+ "chss_pool_cd", length));
			String[] preEffDt = (JSPUtil.getParameter(request, prefix	+ "pre_eff_dt", length));
			String[] chssPoolTaxRt = (JSPUtil.getParameter(request, prefix	+ "chss_pool_tax_rt", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ddctTpCd = (JSPUtil.getParameter(request, prefix	+ "ddct_tp_cd", length));
			String[] chssPoolRtAmt = (JSPUtil.getParameter(request, prefix	+ "chss_pool_rt_amt", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] agmtIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "agmt_iss_ofc_cd", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] agmtRmk = (JSPUtil.getParameter(request, prefix	+ "agmt_rmk", length));
			String[] agmtExpDt = (JSPUtil.getParameter(request, prefix	+ "agmt_exp_dt", length));
			String[] actionFlag = (JSPUtil.getParameter(request, prefix	+ "action_flag", length));
			String[] lrLocNm = (JSPUtil.getParameter(request, prefix	+ "lr_loc_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] chssYdTpCd = (JSPUtil.getParameter(request, prefix	+ "chss_yd_tp_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] preExpDt = (JSPUtil.getParameter(request, prefix	+ "pre_exp_dt", length));
			String[] agmtRefNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ref_no", length));
			String[] dmstUsgFlg = (JSPUtil.getParameter(request, prefix	+ "dmst_usg_flg", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] agmtLstmCd = (JSPUtil.getParameter(request, prefix	+ "agmt_lstm_cd", length));
			String[] payTermDys = (JSPUtil.getParameter(request, prefix	+ "pay_term_dys", length));
			String[] duration = (JSPUtil.getParameter(request, prefix	+ "duration", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] amtAudFlg = (JSPUtil.getParameter(request, prefix	+ "amt_aud_flg", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] onTmlChgFlg = (JSPUtil.getParameter(request, prefix	+ "on_tml_chg_flg", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] dmstOnTmlChgFlg = (JSPUtil.getParameter(request, prefix	+ "dmst_on_tml_chg_flg", length));
			String[] dmstPdChgFlg = (JSPUtil.getParameter(request, prefix	+ "dmst_pd_chg_flg", length));
			String[] onTmlMtyChgFlg = (JSPUtil.getParameter(request, prefix	+ "on_tml_mty_chg_flg", length));
			String[] bilablSpclCntrTpNm = (JSPUtil.getParameter(request, prefix	+ "bilabl_spcl_cntr_tp_nm", length));
			String[] stStopYdFlg = (JSPUtil.getParameter(request, prefix	+ "st_stop_yd_flg", length));
			String[] gwUqDocTitNm = (JSPUtil.getParameter(request, prefix + "gw_uq_doc_tit_nm", length));
			String[] gwUqDocNo = (JSPUtil.getParameter(request, prefix + "gw_uq_doc_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new CHSCpsAgreementMGTVO();
				if (agmtEffDt[i] != null)
					model.setAgmtEffDt(agmtEffDt[i]);
				if (lstVerFlg[i] != null)
					model.setLstVerFlg(lstVerFlg[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (chssPoolCd[i] != null)
					model.setChssPoolCd(chssPoolCd[i]);
				if (preEffDt[i] != null)
					model.setPreEffDt(preEffDt[i]);
				if (chssPoolTaxRt[i] != null)
					model.setChssPoolTaxRt(chssPoolTaxRt[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ddctTpCd[i] != null)
					model.setDdctTpCd(ddctTpCd[i]);
				if (chssPoolRtAmt[i] != null)
					model.setChssPoolRtAmt(chssPoolRtAmt[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (agmtIssOfcCd[i] != null)
					model.setAgmtIssOfcCd(agmtIssOfcCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (agmtRmk[i] != null)
					model.setAgmtRmk(agmtRmk[i]);
				if (agmtExpDt[i] != null)
					model.setAgmtExpDt(agmtExpDt[i]);
				if (actionFlag[i] != null)
					model.setActionFlag(actionFlag[i]);
				if (lrLocNm[i] != null)
					model.setLrLocNm(lrLocNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (chssYdTpCd[i] != null)
					model.setChssYdTpCd(chssYdTpCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (preExpDt[i] != null)
					model.setPreExpDt(preExpDt[i]);
				if (agmtRefNo[i] != null)
					model.setAgmtRefNo(agmtRefNo[i]);
				if (dmstUsgFlg[i] != null)
					model.setDmstUsgFlg(dmstUsgFlg[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (agmtLstmCd[i] != null)
					model.setAgmtLstmCd(agmtLstmCd[i]);
				if (payTermDys[i] != null)
					model.setPayTermDys(payTermDys[i]);
				if (duration[i] != null)
					model.setDuration(duration[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (amtAudFlg[i] != null)
					model.setAmtAudFlg(amtAudFlg[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (onTmlChgFlg[i] != null)
					model.setOnTmlChgFlg(onTmlChgFlg[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (dmstOnTmlChgFlg[i] != null)
					model.setDmstOnTmlChgFlg(dmstOnTmlChgFlg[i]);
				if (dmstPdChgFlg[i] != null)
					model.setDmstPdChgFlg(dmstPdChgFlg[i]);
				if (onTmlMtyChgFlg[i] != null)
					model.setOnTmlMtyChgFlg(onTmlMtyChgFlg[i]);
				if (bilablSpclCntrTpNm[i] != null)
					model.setBilablSpclCntrTpNm(bilablSpclCntrTpNm[i]);
				if (stStopYdFlg[i] != null)
					model.setStStopYdFlg(stStopYdFlg[i]);
				if (gwUqDocTitNm[i] != null)
					model.setGwUqDocTitNm(gwUqDocTitNm[i]);
				if (gwUqDocNo[i] != null)
					model.setGwUqDocNo(gwUqDocNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCHSCpsAgreementMGTVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CHSCpsAgreementMGTVO[]
	 */
	public CHSCpsAgreementMGTVO[] getCHSCpsAgreementMGTVOs(){
		CHSCpsAgreementMGTVO[] vos = (CHSCpsAgreementMGTVO[])models.toArray(new CHSCpsAgreementMGTVO[models.size()]);
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
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolCd = this.chssPoolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEffDt = this.preEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolTaxRt = this.chssPoolTaxRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctTpCd = this.ddctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssPoolRtAmt = this.chssPoolRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtIssOfcCd = this.agmtIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRmk = this.agmtRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtExpDt = this.agmtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actionFlag = this.actionFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lrLocNm = this.lrLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssYdTpCd = this.chssYdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preExpDt = this.preExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo = this.agmtRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstUsgFlg = this.dmstUsgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd = this.agmtLstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermDys = this.payTermDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duration = this.duration .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amtAudFlg = this.amtAudFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTmlChgFlg = this.onTmlChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstOnTmlChgFlg = this.dmstOnTmlChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmstPdChgFlg = this.dmstPdChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onTmlMtyChgFlg = this.onTmlMtyChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilablSpclCntrTpNm = this.bilablSpclCntrTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stStopYdFlg = this.stStopYdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwUqDocTitNm = this.gwUqDocTitNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gwUqDocNo = this.gwUqDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}

	public String getStStopYdFlg() {
		return stStopYdFlg;
	}

	public void setStStopYdFlg(String stStopYdFlg) {
		this.stStopYdFlg = stStopYdFlg;
	}
}
