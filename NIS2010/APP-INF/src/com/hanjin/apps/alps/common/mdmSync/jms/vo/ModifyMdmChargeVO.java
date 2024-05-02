/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ModifyMdmChargeVO.java
*@FileTitle : ModifyMdmChargeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 최 선
*@LastVersion : 1.0
* 2009.09.21 최 선 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.common.mdmSync.jms.vo;

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
 * @author 최 선
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ModifyMdmChargeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ModifyMdmChargeVO> models = new ArrayList<ModifyMdmChargeVO>();
	
	/* Column Info */
	private String sUpdDt = null;
	/* Column Info */
	private String sDeltFlg = null;
	/* Column Info */
	private String sFrtChgTpCd = null;
	/* Column Info */
	private String sChgEdiCd = null;
	/* Column Info */
	private String sChgRevTpCd = null;
	/* Column Info */
	private String sCfsRdTermFlg = null;
	/* Column Info */
	private String sEaiEvntDt = null;
	/* Column Info */
	private String sChgAplyAreaCd = null;
	/* Column Info */
	private String sDpSeq = null;
	/* Column Info */
	private String sUpdUsrId = null;
	/* Column Info */
	private String sUseCoTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sSenChgAcctCd = null;
	/* Column Info */
	private String sCreDt = null;
	/* Column Info */
	private String sNaRdTermFlg = null;
	/* Column Info */
	private String sTklTmlFlg = null;
	/* Column Info */
	private String sChgNm = null;
	/* Column Info */
	private String sAutoRatFlg = null;
	/* Column Info */
	private String sHjsChgAcctCd = null;
	/* Column Info */
	private String sChgCd = null;
	/* Column Info */
	private String eaiEvntDt = null;
	/* Column Info */
	private String sChgStsCd = null;
	/* Column Info */
	private String sChgAplyTpCd = null;
	/* Column Info */
	private String sSenGrpChgCd = null;
	/* Column Info */
	private String sAplySvcModFlg = null;
	/* Column Info */
	private String sCreUsrId = null;
	/* Column Info */
	private String sDorRdTermFlg = null;
	/* Column Info */
	private String sCyRdTermFlg = null;
	/* Column Info */
	private String sRepChgCd = null;
	/* Column Info */
	private String eaiIfId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ModifyMdmChargeVO() {}

	public ModifyMdmChargeVO(String ibflag, String pagerows, String sChgNm, String sFrtChgTpCd, String sSenChgAcctCd, String sHjsChgAcctCd, String sRepChgCd, String sChgRevTpCd, String sChgAplyTpCd, String sChgAplyAreaCd, String sCyRdTermFlg, String sCfsRdTermFlg, String sDorRdTermFlg, String sNaRdTermFlg, String sTklTmlFlg, String sAplySvcModFlg, String sUseCoTpCd, String sAutoRatFlg, String sSenGrpChgCd, String sChgEdiCd, String sDpSeq, String sChgStsCd, String sCreUsrId, String sCreDt, String sUpdUsrId, String sUpdDt, String sDeltFlg, String sEaiEvntDt, String sChgCd, String eaiEvntDt, String eaiIfId) {
		this.sUpdDt = sUpdDt;
		this.sDeltFlg = sDeltFlg;
		this.sFrtChgTpCd = sFrtChgTpCd;
		this.sChgEdiCd = sChgEdiCd;
		this.sChgRevTpCd = sChgRevTpCd;
		this.sCfsRdTermFlg = sCfsRdTermFlg;
		this.sEaiEvntDt = sEaiEvntDt;
		this.sChgAplyAreaCd = sChgAplyAreaCd;
		this.sDpSeq = sDpSeq;
		this.sUpdUsrId = sUpdUsrId;
		this.sUseCoTpCd = sUseCoTpCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.sSenChgAcctCd = sSenChgAcctCd;
		this.sCreDt = sCreDt;
		this.sNaRdTermFlg = sNaRdTermFlg;
		this.sTklTmlFlg = sTklTmlFlg;
		this.sChgNm = sChgNm;
		this.sAutoRatFlg = sAutoRatFlg;
		this.sHjsChgAcctCd = sHjsChgAcctCd;
		this.sChgCd = sChgCd;
		this.eaiEvntDt = eaiEvntDt;
		this.sChgStsCd = sChgStsCd;
		this.sChgAplyTpCd = sChgAplyTpCd;
		this.sSenGrpChgCd = sSenGrpChgCd;
		this.sAplySvcModFlg = sAplySvcModFlg;
		this.sCreUsrId = sCreUsrId;
		this.sDorRdTermFlg = sDorRdTermFlg;
		this.sCyRdTermFlg = sCyRdTermFlg;
		this.sRepChgCd = sRepChgCd;
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_upd_dt", getSUpdDt());
		this.hashColumns.put("s_delt_flg", getSDeltFlg());
		this.hashColumns.put("s_frt_chg_tp_cd", getSFrtChgTpCd());
		this.hashColumns.put("s_chg_edi_cd", getSChgEdiCd());
		this.hashColumns.put("s_chg_rev_tp_cd", getSChgRevTpCd());
		this.hashColumns.put("s_cfs_rd_term_flg", getSCfsRdTermFlg());
		this.hashColumns.put("s_eai_evnt_dt", getSEaiEvntDt());
		this.hashColumns.put("s_chg_aply_area_cd", getSChgAplyAreaCd());
		this.hashColumns.put("s_dp_seq", getSDpSeq());
		this.hashColumns.put("s_upd_usr_id", getSUpdUsrId());
		this.hashColumns.put("s_use_co_tp_cd", getSUseCoTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_sen_chg_acct_cd", getSSenChgAcctCd());
		this.hashColumns.put("s_cre_dt", getSCreDt());
		this.hashColumns.put("s_na_rd_term_flg", getSNaRdTermFlg());
		this.hashColumns.put("s_tkl_tml_flg", getSTklTmlFlg());
		this.hashColumns.put("s_chg_nm", getSChgNm());
		this.hashColumns.put("s_auto_rat_flg", getSAutoRatFlg());
		this.hashColumns.put("s_hjs_chg_acct_cd", getSHjsChgAcctCd());
		this.hashColumns.put("s_chg_cd", getSChgCd());
		this.hashColumns.put("eai_evnt_dt", getEaiEvntDt());
		this.hashColumns.put("s_chg_sts_cd", getSChgStsCd());
		this.hashColumns.put("s_chg_aply_tp_cd", getSChgAplyTpCd());
		this.hashColumns.put("s_sen_grp_chg_cd", getSSenGrpChgCd());
		this.hashColumns.put("s_aply_svc_mod_flg", getSAplySvcModFlg());
		this.hashColumns.put("s_cre_usr_id", getSCreUsrId());
		this.hashColumns.put("s_dor_rd_term_flg", getSDorRdTermFlg());
		this.hashColumns.put("s_cy_rd_term_flg", getSCyRdTermFlg());
		this.hashColumns.put("s_rep_chg_cd", getSRepChgCd());
		this.hashColumns.put("eai_if_id", getEaiIfId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_upd_dt", "sUpdDt");
		this.hashFields.put("s_delt_flg", "sDeltFlg");
		this.hashFields.put("s_frt_chg_tp_cd", "sFrtChgTpCd");
		this.hashFields.put("s_chg_edi_cd", "sChgEdiCd");
		this.hashFields.put("s_chg_rev_tp_cd", "sChgRevTpCd");
		this.hashFields.put("s_cfs_rd_term_flg", "sCfsRdTermFlg");
		this.hashFields.put("s_eai_evnt_dt", "sEaiEvntDt");
		this.hashFields.put("s_chg_aply_area_cd", "sChgAplyAreaCd");
		this.hashFields.put("s_dp_seq", "sDpSeq");
		this.hashFields.put("s_upd_usr_id", "sUpdUsrId");
		this.hashFields.put("s_use_co_tp_cd", "sUseCoTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_sen_chg_acct_cd", "sSenChgAcctCd");
		this.hashFields.put("s_cre_dt", "sCreDt");
		this.hashFields.put("s_na_rd_term_flg", "sNaRdTermFlg");
		this.hashFields.put("s_tkl_tml_flg", "sTklTmlFlg");
		this.hashFields.put("s_chg_nm", "sChgNm");
		this.hashFields.put("s_auto_rat_flg", "sAutoRatFlg");
		this.hashFields.put("s_hjs_chg_acct_cd", "sHjsChgAcctCd");
		this.hashFields.put("s_chg_cd", "sChgCd");
		this.hashFields.put("eai_evnt_dt", "eaiEvntDt");
		this.hashFields.put("s_chg_sts_cd", "sChgStsCd");
		this.hashFields.put("s_chg_aply_tp_cd", "sChgAplyTpCd");
		this.hashFields.put("s_sen_grp_chg_cd", "sSenGrpChgCd");
		this.hashFields.put("s_aply_svc_mod_flg", "sAplySvcModFlg");
		this.hashFields.put("s_cre_usr_id", "sCreUsrId");
		this.hashFields.put("s_dor_rd_term_flg", "sDorRdTermFlg");
		this.hashFields.put("s_cy_rd_term_flg", "sCyRdTermFlg");
		this.hashFields.put("s_rep_chg_cd", "sRepChgCd");
		this.hashFields.put("eai_if_id", "eaiIfId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sUpdDt
	 */
	public String getSUpdDt() {
		return this.sUpdDt;
	}
	
	/**
	 * Column Info
	 * @return sDeltFlg
	 */
	public String getSDeltFlg() {
		return this.sDeltFlg;
	}
	
	/**
	 * Column Info
	 * @return sFrtChgTpCd
	 */
	public String getSFrtChgTpCd() {
		return this.sFrtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return sChgEdiCd
	 */
	public String getSChgEdiCd() {
		return this.sChgEdiCd;
	}
	
	/**
	 * Column Info
	 * @return sChgRevTpCd
	 */
	public String getSChgRevTpCd() {
		return this.sChgRevTpCd;
	}
	
	/**
	 * Column Info
	 * @return sCfsRdTermFlg
	 */
	public String getSCfsRdTermFlg() {
		return this.sCfsRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @return sEaiEvntDt
	 */
	public String getSEaiEvntDt() {
		return this.sEaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return sChgAplyAreaCd
	 */
	public String getSChgAplyAreaCd() {
		return this.sChgAplyAreaCd;
	}
	
	/**
	 * Column Info
	 * @return sDpSeq
	 */
	public String getSDpSeq() {
		return this.sDpSeq;
	}
	
	/**
	 * Column Info
	 * @return sUpdUsrId
	 */
	public String getSUpdUsrId() {
		return this.sUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @return sUseCoTpCd
	 */
	public String getSUseCoTpCd() {
		return this.sUseCoTpCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return sSenChgAcctCd
	 */
	public String getSSenChgAcctCd() {
		return this.sSenChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @return sCreDt
	 */
	public String getSCreDt() {
		return this.sCreDt;
	}
	
	/**
	 * Column Info
	 * @return sNaRdTermFlg
	 */
	public String getSNaRdTermFlg() {
		return this.sNaRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @return sTklTmlFlg
	 */
	public String getSTklTmlFlg() {
		return this.sTklTmlFlg;
	}
	
	/**
	 * Column Info
	 * @return sChgNm
	 */
	public String getSChgNm() {
		return this.sChgNm;
	}
	
	/**
	 * Column Info
	 * @return sAutoRatFlg
	 */
	public String getSAutoRatFlg() {
		return this.sAutoRatFlg;
	}
	
	/**
	 * Column Info
	 * @return sHjsChgAcctCd
	 */
	public String getSHjsChgAcctCd() {
		return this.sHjsChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @return sChgCd
	 */
	public String getSChgCd() {
		return this.sChgCd;
	}
	
	/**
	 * Column Info
	 * @return eaiEvntDt
	 */
	public String getEaiEvntDt() {
		return this.eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @return sChgStsCd
	 */
	public String getSChgStsCd() {
		return this.sChgStsCd;
	}
	
	/**
	 * Column Info
	 * @return sChgAplyTpCd
	 */
	public String getSChgAplyTpCd() {
		return this.sChgAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @return sSenGrpChgCd
	 */
	public String getSSenGrpChgCd() {
		return this.sSenGrpChgCd;
	}
	
	/**
	 * Column Info
	 * @return sAplySvcModFlg
	 */
	public String getSAplySvcModFlg() {
		return this.sAplySvcModFlg;
	}
	
	/**
	 * Column Info
	 * @return sCreUsrId
	 */
	public String getSCreUsrId() {
		return this.sCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return sDorRdTermFlg
	 */
	public String getSDorRdTermFlg() {
		return this.sDorRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @return sCyRdTermFlg
	 */
	public String getSCyRdTermFlg() {
		return this.sCyRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @return sRepChgCd
	 */
	public String getSRepChgCd() {
		return this.sRepChgCd;
	}
	
	/**
	 * Column Info
	 * @return eaiIfId
	 */
	public String getEaiIfId() {
		return this.eaiIfId;
	}

	/**
	 * Column Info
	 * @param sUpdDt
	 */
	public void setSUpdDt(String sUpdDt) {
		this.sUpdDt = sUpdDt;
	}
	
	/**
	 * Column Info
	 * @param sDeltFlg
	 */
	public void setSDeltFlg(String sDeltFlg) {
		this.sDeltFlg = sDeltFlg;
	}
	
	/**
	 * Column Info
	 * @param sFrtChgTpCd
	 */
	public void setSFrtChgTpCd(String sFrtChgTpCd) {
		this.sFrtChgTpCd = sFrtChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param sChgEdiCd
	 */
	public void setSChgEdiCd(String sChgEdiCd) {
		this.sChgEdiCd = sChgEdiCd;
	}
	
	/**
	 * Column Info
	 * @param sChgRevTpCd
	 */
	public void setSChgRevTpCd(String sChgRevTpCd) {
		this.sChgRevTpCd = sChgRevTpCd;
	}
	
	/**
	 * Column Info
	 * @param sCfsRdTermFlg
	 */
	public void setSCfsRdTermFlg(String sCfsRdTermFlg) {
		this.sCfsRdTermFlg = sCfsRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @param sEaiEvntDt
	 */
	public void setSEaiEvntDt(String sEaiEvntDt) {
		this.sEaiEvntDt = sEaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param sChgAplyAreaCd
	 */
	public void setSChgAplyAreaCd(String sChgAplyAreaCd) {
		this.sChgAplyAreaCd = sChgAplyAreaCd;
	}
	
	/**
	 * Column Info
	 * @param sDpSeq
	 */
	public void setSDpSeq(String sDpSeq) {
		this.sDpSeq = sDpSeq;
	}
	
	/**
	 * Column Info
	 * @param sUpdUsrId
	 */
	public void setSUpdUsrId(String sUpdUsrId) {
		this.sUpdUsrId = sUpdUsrId;
	}
	
	/**
	 * Column Info
	 * @param sUseCoTpCd
	 */
	public void setSUseCoTpCd(String sUseCoTpCd) {
		this.sUseCoTpCd = sUseCoTpCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param sSenChgAcctCd
	 */
	public void setSSenChgAcctCd(String sSenChgAcctCd) {
		this.sSenChgAcctCd = sSenChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @param sCreDt
	 */
	public void setSCreDt(String sCreDt) {
		this.sCreDt = sCreDt;
	}
	
	/**
	 * Column Info
	 * @param sNaRdTermFlg
	 */
	public void setSNaRdTermFlg(String sNaRdTermFlg) {
		this.sNaRdTermFlg = sNaRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @param sTklTmlFlg
	 */
	public void setSTklTmlFlg(String sTklTmlFlg) {
		this.sTklTmlFlg = sTklTmlFlg;
	}
	
	/**
	 * Column Info
	 * @param sChgNm
	 */
	public void setSChgNm(String sChgNm) {
		this.sChgNm = sChgNm;
	}
	
	/**
	 * Column Info
	 * @param sAutoRatFlg
	 */
	public void setSAutoRatFlg(String sAutoRatFlg) {
		this.sAutoRatFlg = sAutoRatFlg;
	}
	
	/**
	 * Column Info
	 * @param sHjsChgAcctCd
	 */
	public void setSHjsChgAcctCd(String sHjsChgAcctCd) {
		this.sHjsChgAcctCd = sHjsChgAcctCd;
	}
	
	/**
	 * Column Info
	 * @param sChgCd
	 */
	public void setSChgCd(String sChgCd) {
		this.sChgCd = sChgCd;
	}
	
	/**
	 * Column Info
	 * @param eaiEvntDt
	 */
	public void setEaiEvntDt(String eaiEvntDt) {
		this.eaiEvntDt = eaiEvntDt;
	}
	
	/**
	 * Column Info
	 * @param sChgStsCd
	 */
	public void setSChgStsCd(String sChgStsCd) {
		this.sChgStsCd = sChgStsCd;
	}
	
	/**
	 * Column Info
	 * @param sChgAplyTpCd
	 */
	public void setSChgAplyTpCd(String sChgAplyTpCd) {
		this.sChgAplyTpCd = sChgAplyTpCd;
	}
	
	/**
	 * Column Info
	 * @param sSenGrpChgCd
	 */
	public void setSSenGrpChgCd(String sSenGrpChgCd) {
		this.sSenGrpChgCd = sSenGrpChgCd;
	}
	
	/**
	 * Column Info
	 * @param sAplySvcModFlg
	 */
	public void setSAplySvcModFlg(String sAplySvcModFlg) {
		this.sAplySvcModFlg = sAplySvcModFlg;
	}
	
	/**
	 * Column Info
	 * @param sCreUsrId
	 */
	public void setSCreUsrId(String sCreUsrId) {
		this.sCreUsrId = sCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param sDorRdTermFlg
	 */
	public void setSDorRdTermFlg(String sDorRdTermFlg) {
		this.sDorRdTermFlg = sDorRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @param sCyRdTermFlg
	 */
	public void setSCyRdTermFlg(String sCyRdTermFlg) {
		this.sCyRdTermFlg = sCyRdTermFlg;
	}
	
	/**
	 * Column Info
	 * @param sRepChgCd
	 */
	public void setSRepChgCd(String sRepChgCd) {
		this.sRepChgCd = sRepChgCd;
	}
	
	/**
	 * Column Info
	 * @param eaiIfId
	 */
	public void setEaiIfId(String eaiIfId) {
		this.eaiIfId = eaiIfId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSUpdDt(JSPUtil.getParameter(request, "s_upd_dt", ""));
		setSDeltFlg(JSPUtil.getParameter(request, "s_delt_flg", ""));
		setSFrtChgTpCd(JSPUtil.getParameter(request, "s_frt_chg_tp_cd", ""));
		setSChgEdiCd(JSPUtil.getParameter(request, "s_chg_edi_cd", ""));
		setSChgRevTpCd(JSPUtil.getParameter(request, "s_chg_rev_tp_cd", ""));
		setSCfsRdTermFlg(JSPUtil.getParameter(request, "s_cfs_rd_term_flg", ""));
		setSEaiEvntDt(JSPUtil.getParameter(request, "s_eai_evnt_dt", ""));
		setSChgAplyAreaCd(JSPUtil.getParameter(request, "s_chg_aply_area_cd", ""));
		setSDpSeq(JSPUtil.getParameter(request, "s_dp_seq", ""));
		setSUpdUsrId(JSPUtil.getParameter(request, "s_upd_usr_id", ""));
		setSUseCoTpCd(JSPUtil.getParameter(request, "s_use_co_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSSenChgAcctCd(JSPUtil.getParameter(request, "s_sen_chg_acct_cd", ""));
		setSCreDt(JSPUtil.getParameter(request, "s_cre_dt", ""));
		setSNaRdTermFlg(JSPUtil.getParameter(request, "s_na_rd_term_flg", ""));
		setSTklTmlFlg(JSPUtil.getParameter(request, "s_tkl_tml_flg", ""));
		setSChgNm(JSPUtil.getParameter(request, "s_chg_nm", ""));
		setSAutoRatFlg(JSPUtil.getParameter(request, "s_auto_rat_flg", ""));
		setSHjsChgAcctCd(JSPUtil.getParameter(request, "s_hjs_chg_acct_cd", ""));
		setSChgCd(JSPUtil.getParameter(request, "s_chg_cd", ""));
		setEaiEvntDt(JSPUtil.getParameter(request, "eai_evnt_dt", ""));
		setSChgStsCd(JSPUtil.getParameter(request, "s_chg_sts_cd", ""));
		setSChgAplyTpCd(JSPUtil.getParameter(request, "s_chg_aply_tp_cd", ""));
		setSSenGrpChgCd(JSPUtil.getParameter(request, "s_sen_grp_chg_cd", ""));
		setSAplySvcModFlg(JSPUtil.getParameter(request, "s_aply_svc_mod_flg", ""));
		setSCreUsrId(JSPUtil.getParameter(request, "s_cre_usr_id", ""));
		setSDorRdTermFlg(JSPUtil.getParameter(request, "s_dor_rd_term_flg", ""));
		setSCyRdTermFlg(JSPUtil.getParameter(request, "s_cy_rd_term_flg", ""));
		setSRepChgCd(JSPUtil.getParameter(request, "s_rep_chg_cd", ""));
		setEaiIfId(JSPUtil.getParameter(request, "eai_if_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ModifyMdmChargeVO[]
	 */
	public ModifyMdmChargeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ModifyMdmChargeVO[]
	 */
	public ModifyMdmChargeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ModifyMdmChargeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sUpdDt = (JSPUtil.getParameter(request, prefix	+ "s_upd_dt", length));
			String[] sDeltFlg = (JSPUtil.getParameter(request, prefix	+ "s_delt_flg", length));
			String[] sFrtChgTpCd = (JSPUtil.getParameter(request, prefix	+ "s_frt_chg_tp_cd", length));
			String[] sChgEdiCd = (JSPUtil.getParameter(request, prefix	+ "s_chg_edi_cd", length));
			String[] sChgRevTpCd = (JSPUtil.getParameter(request, prefix	+ "s_chg_rev_tp_cd", length));
			String[] sCfsRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "s_cfs_rd_term_flg", length));
			String[] sEaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "s_eai_evnt_dt", length));
			String[] sChgAplyAreaCd = (JSPUtil.getParameter(request, prefix	+ "s_chg_aply_area_cd", length));
			String[] sDpSeq = (JSPUtil.getParameter(request, prefix	+ "s_dp_seq", length));
			String[] sUpdUsrId = (JSPUtil.getParameter(request, prefix	+ "s_upd_usr_id", length));
			String[] sUseCoTpCd = (JSPUtil.getParameter(request, prefix	+ "s_use_co_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sSenChgAcctCd = (JSPUtil.getParameter(request, prefix	+ "s_sen_chg_acct_cd", length));
			String[] sCreDt = (JSPUtil.getParameter(request, prefix	+ "s_cre_dt", length));
			String[] sNaRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "s_na_rd_term_flg", length));
			String[] sTklTmlFlg = (JSPUtil.getParameter(request, prefix	+ "s_tkl_tml_flg", length));
			String[] sChgNm = (JSPUtil.getParameter(request, prefix	+ "s_chg_nm", length));
			String[] sAutoRatFlg = (JSPUtil.getParameter(request, prefix	+ "s_auto_rat_flg", length));
			String[] sHjsChgAcctCd = (JSPUtil.getParameter(request, prefix	+ "s_hjs_chg_acct_cd", length));
			String[] sChgCd = (JSPUtil.getParameter(request, prefix	+ "s_chg_cd", length));
			String[] eaiEvntDt = (JSPUtil.getParameter(request, prefix	+ "eai_evnt_dt", length));
			String[] sChgStsCd = (JSPUtil.getParameter(request, prefix	+ "s_chg_sts_cd", length));
			String[] sChgAplyTpCd = (JSPUtil.getParameter(request, prefix	+ "s_chg_aply_tp_cd", length));
			String[] sSenGrpChgCd = (JSPUtil.getParameter(request, prefix	+ "s_sen_grp_chg_cd", length));
			String[] sAplySvcModFlg = (JSPUtil.getParameter(request, prefix	+ "s_aply_svc_mod_flg", length));
			String[] sCreUsrId = (JSPUtil.getParameter(request, prefix	+ "s_cre_usr_id", length));
			String[] sDorRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "s_dor_rd_term_flg", length));
			String[] sCyRdTermFlg = (JSPUtil.getParameter(request, prefix	+ "s_cy_rd_term_flg", length));
			String[] sRepChgCd = (JSPUtil.getParameter(request, prefix	+ "s_rep_chg_cd", length));
			String[] eaiIfId = (JSPUtil.getParameter(request, prefix	+ "eai_if_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new ModifyMdmChargeVO();
				if (sUpdDt[i] != null)
					model.setSUpdDt(sUpdDt[i]);
				if (sDeltFlg[i] != null)
					model.setSDeltFlg(sDeltFlg[i]);
				if (sFrtChgTpCd[i] != null)
					model.setSFrtChgTpCd(sFrtChgTpCd[i]);
				if (sChgEdiCd[i] != null)
					model.setSChgEdiCd(sChgEdiCd[i]);
				if (sChgRevTpCd[i] != null)
					model.setSChgRevTpCd(sChgRevTpCd[i]);
				if (sCfsRdTermFlg[i] != null)
					model.setSCfsRdTermFlg(sCfsRdTermFlg[i]);
				if (sEaiEvntDt[i] != null)
					model.setSEaiEvntDt(sEaiEvntDt[i]);
				if (sChgAplyAreaCd[i] != null)
					model.setSChgAplyAreaCd(sChgAplyAreaCd[i]);
				if (sDpSeq[i] != null)
					model.setSDpSeq(sDpSeq[i]);
				if (sUpdUsrId[i] != null)
					model.setSUpdUsrId(sUpdUsrId[i]);
				if (sUseCoTpCd[i] != null)
					model.setSUseCoTpCd(sUseCoTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sSenChgAcctCd[i] != null)
					model.setSSenChgAcctCd(sSenChgAcctCd[i]);
				if (sCreDt[i] != null)
					model.setSCreDt(sCreDt[i]);
				if (sNaRdTermFlg[i] != null)
					model.setSNaRdTermFlg(sNaRdTermFlg[i]);
				if (sTklTmlFlg[i] != null)
					model.setSTklTmlFlg(sTklTmlFlg[i]);
				if (sChgNm[i] != null)
					model.setSChgNm(sChgNm[i]);
				if (sAutoRatFlg[i] != null)
					model.setSAutoRatFlg(sAutoRatFlg[i]);
				if (sHjsChgAcctCd[i] != null)
					model.setSHjsChgAcctCd(sHjsChgAcctCd[i]);
				if (sChgCd[i] != null)
					model.setSChgCd(sChgCd[i]);
				if (eaiEvntDt[i] != null)
					model.setEaiEvntDt(eaiEvntDt[i]);
				if (sChgStsCd[i] != null)
					model.setSChgStsCd(sChgStsCd[i]);
				if (sChgAplyTpCd[i] != null)
					model.setSChgAplyTpCd(sChgAplyTpCd[i]);
				if (sSenGrpChgCd[i] != null)
					model.setSSenGrpChgCd(sSenGrpChgCd[i]);
				if (sAplySvcModFlg[i] != null)
					model.setSAplySvcModFlg(sAplySvcModFlg[i]);
				if (sCreUsrId[i] != null)
					model.setSCreUsrId(sCreUsrId[i]);
				if (sDorRdTermFlg[i] != null)
					model.setSDorRdTermFlg(sDorRdTermFlg[i]);
				if (sCyRdTermFlg[i] != null)
					model.setSCyRdTermFlg(sCyRdTermFlg[i]);
				if (sRepChgCd[i] != null)
					model.setSRepChgCd(sRepChgCd[i]);
				if (eaiIfId[i] != null)
					model.setEaiIfId(eaiIfId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getModifyMdmChargeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ModifyMdmChargeVO[]
	 */
	public ModifyMdmChargeVO[] getModifyMdmChargeVOs(){
		ModifyMdmChargeVO[] vos = (ModifyMdmChargeVO[])models.toArray(new ModifyMdmChargeVO[models.size()]);
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
		this.sUpdDt = this.sUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDeltFlg = this.sDeltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFrtChgTpCd = this.sFrtChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChgEdiCd = this.sChgEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChgRevTpCd = this.sChgRevTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCfsRdTermFlg = this.sCfsRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEaiEvntDt = this.sEaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChgAplyAreaCd = this.sChgAplyAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDpSeq = this.sDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUpdUsrId = this.sUpdUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sUseCoTpCd = this.sUseCoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSenChgAcctCd = this.sSenChgAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCreDt = this.sCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNaRdTermFlg = this.sNaRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTklTmlFlg = this.sTklTmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChgNm = this.sChgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAutoRatFlg = this.sAutoRatFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sHjsChgAcctCd = this.sHjsChgAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChgCd = this.sChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiEvntDt = this.eaiEvntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChgStsCd = this.sChgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sChgAplyTpCd = this.sChgAplyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sSenGrpChgCd = this.sSenGrpChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAplySvcModFlg = this.sAplySvcModFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCreUsrId = this.sCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sDorRdTermFlg = this.sDorRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCyRdTermFlg = this.sCyRdTermFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRepChgCd = this.sRepChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiIfId = this.eaiIfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
