/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltPropMnInqVO.java
 *@FileTitle : RsltPropMnInqVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.09.29
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2014.09.29 jaewonLee 
 * 1.0 Creation 
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author jaewonLee
 * @since J2EE 1.6
 * @see	..
 */
public class RsltPropMnInqVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltPropMnInqVO>  models =	new	ArrayList<RsltPropMnInqVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String propAproDt = null;
	/*	Column Info	*/
	private String ctrtCustCntCd = null;
	/*	Column Info	*/
	private String ctrtEffDt = null;
	/*	Column Info	*/
	private String amdtSeq = null;
	/*	Column Info	*/
	private String creDt = null;
	/*	Column Info	*/
	private String prsCrntCmAmt = null;
	/*	Column Info	*/
	private String respbSlsOfcCd = null;
	/*	Column Info	*/
	private String propSts = null;
	/*	Column Info	*/
	private String rfaNo = null;
	/*	Column Info	*/
	private String effDt = null;
	/*	Column Info	*/
	private String propSrepNm = null;
	/*	Column Info	*/
	private String ctrtCustValSgm = null;
	/*	Column Info	*/
	private String ctrtCustSrepNm = null;
	/*	Column Info	*/
	private String propStsCd = null;
	/*	Column Info	*/
	private String prsEstmCmAmt = null;
	/*	Column Info	*/
	private String tgtMvcQty = null;
	/*	Column Info	*/
	private String expDt = null;
	/*	Column Info	*/
	private String slsLdNo = null;
	/*	Column Info	*/
	private String ctrtExpDt = null;
	/*	Column Info	*/
	private String fileDt = null;
	/*	Column Info	*/
	private String propSrepCd = null;
	/*	Column Info	*/
	private String ctrtCustSeq = null;
	/*	Column Info	*/
	private String respbSrepCd = null;
	/*	Column Info	*/
	private String dmdtFtTpCd = null;
	/*	Column Info	*/
	private String cntrLodUtCd = null;
	/*	Column Info	*/
	private String preAmdtSeq = null;
	/*	Column Info	*/
	private String prcCtrtCustTpCd = null;
	/*	Column Info	*/
	private String unit = null;
	/*	Column Info	*/
	private String ctrtPtyNm = null;
	/*	Column Info	*/
	private String propOfcCd = null;
	/*	Column Info	*/
	private String propAproOfcCd = null;
	/*	Column Info	*/
	private String propNo = null;
	/*	Column Info	*/
	private String propAproStaff = null;
	/*	Column Info	*/
	private String prcCtrtCustTpNm = null;
	/*	Column Info	*/
	private String ctrtCustValSgmCd = null;
	/*	Column Info	*/
	private String trfCtrtFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltPropMnInqVO(){}

	public RsltPropMnInqVO(String ibflag,String pagerows,String propAproDt,String ctrtCustCntCd,String ctrtEffDt,String amdtSeq,String creDt,String prsCrntCmAmt,String respbSlsOfcCd,String propSts,String rfaNo,String effDt,String propSrepNm,String ctrtCustValSgm,String ctrtCustSrepNm,String propStsCd,String prsEstmCmAmt,String tgtMvcQty,String expDt,String slsLdNo,String ctrtExpDt,String fileDt,String propSrepCd,String ctrtCustSeq,String respbSrepCd,String dmdtFtTpCd,String cntrLodUtCd,String preAmdtSeq,String prcCtrtCustTpCd,String unit,String ctrtPtyNm,String propOfcCd,String propAproOfcCd,String propNo,String propAproStaff,String prcCtrtCustTpNm,String ctrtCustValSgmCd,String trfCtrtFlg)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.propAproDt = propAproDt;
		this.ctrtCustCntCd = ctrtCustCntCd;
		this.ctrtEffDt = ctrtEffDt;
		this.amdtSeq = amdtSeq;
		this.creDt = creDt;
		this.prsCrntCmAmt = prsCrntCmAmt;
		this.respbSlsOfcCd = respbSlsOfcCd;
		this.propSts = propSts;
		this.rfaNo = rfaNo;
		this.effDt = effDt;
		this.propSrepNm = propSrepNm;
		this.ctrtCustValSgm = ctrtCustValSgm;
		this.ctrtCustSrepNm = ctrtCustSrepNm;
		this.propStsCd = propStsCd;
		this.prsEstmCmAmt = prsEstmCmAmt;
		this.tgtMvcQty = tgtMvcQty;
		this.expDt = expDt;
		this.slsLdNo = slsLdNo;
		this.ctrtExpDt = ctrtExpDt;
		this.fileDt = fileDt;
		this.propSrepCd = propSrepCd;
		this.ctrtCustSeq = ctrtCustSeq;
		this.respbSrepCd = respbSrepCd;
		this.dmdtFtTpCd = dmdtFtTpCd;
		this.cntrLodUtCd = cntrLodUtCd;
		this.preAmdtSeq = preAmdtSeq;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.unit = unit;
		this.ctrtPtyNm = ctrtPtyNm;
		this.propOfcCd = propOfcCd;
		this.propAproOfcCd = propAproOfcCd;
		this.propNo = propNo;
		this.propAproStaff = propAproStaff;
		this.prcCtrtCustTpNm = prcCtrtCustTpNm;
		this.ctrtCustValSgmCd = ctrtCustValSgmCd;
		this.trfCtrtFlg = trfCtrtFlg;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prop_apro_dt", getPropAproDt());
		this.hashColumns.put("ctrt_cust_cnt_cd", getCtrtCustCntCd());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("prs_crnt_cm_amt", getPrsCrntCmAmt());
		this.hashColumns.put("respb_sls_ofc_cd", getRespbSlsOfcCd());
		this.hashColumns.put("prop_sts", getPropSts());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("prop_srep_nm", getPropSrepNm());
		this.hashColumns.put("ctrt_cust_val_sgm", getCtrtCustValSgm());
		this.hashColumns.put("ctrt_cust_srep_nm", getCtrtCustSrepNm());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("prs_estm_cm_amt", getPrsEstmCmAmt());
		this.hashColumns.put("tgt_mvc_qty", getTgtMvcQty());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("sls_ld_no", getSlsLdNo());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("ctrt_cust_seq", getCtrtCustSeq());
		this.hashColumns.put("respb_srep_cd", getRespbSrepCd());
		this.hashColumns.put("dmdt_ft_tp_cd", getDmdtFtTpCd());
		this.hashColumns.put("cntr_lod_ut_cd", getCntrLodUtCd());
		this.hashColumns.put("pre_amdt_seq", getPreAmdtSeq());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("unit", getUnit());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_apro_ofc_cd", getPropAproOfcCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("prop_apro_staff", getPropAproStaff());
		this.hashColumns.put("prc_ctrt_cust_tp_nm", getPrcCtrtCustTpNm());
		this.hashColumns.put("ctrt_cust_val_sgm_cd", getCtrtCustValSgmCd());
		this.hashColumns.put("trf_ctrt_flg", getTrfCtrtFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prop_apro_dt", "propAproDt");
		this.hashFields.put("ctrt_cust_cnt_cd", "ctrtCustCntCd");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("prs_crnt_cm_amt", "prsCrntCmAmt");
		this.hashFields.put("respb_sls_ofc_cd", "respbSlsOfcCd");
		this.hashFields.put("prop_sts", "propSts");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("prop_srep_nm", "propSrepNm");
		this.hashFields.put("ctrt_cust_val_sgm", "ctrtCustValSgm");
		this.hashFields.put("ctrt_cust_srep_nm", "ctrtCustSrepNm");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("prs_estm_cm_amt", "prsEstmCmAmt");
		this.hashFields.put("tgt_mvc_qty", "tgtMvcQty");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("sls_ld_no", "slsLdNo");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("ctrt_cust_seq", "ctrtCustSeq");
		this.hashFields.put("respb_srep_cd", "respbSrepCd");
		this.hashFields.put("dmdt_ft_tp_cd", "dmdtFtTpCd");
		this.hashFields.put("cntr_lod_ut_cd", "cntrLodUtCd");
		this.hashFields.put("pre_amdt_seq", "preAmdtSeq");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("unit", "unit");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_apro_ofc_cd", "propAproOfcCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("prop_apro_staff", "propAproStaff");
		this.hashFields.put("prc_ctrt_cust_tp_nm", "prcCtrtCustTpNm");
		this.hashFields.put("ctrt_cust_val_sgm_cd", "ctrtCustValSgmCd");
		this.hashFields.put("trf_ctrt_flg", "trfCtrtFlg");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return propAproDt
	 */
	public	String getPropAproDt() {
		return	this.propAproDt;
	}

	/**
	 * Column Info
	 * @return ctrtCustCntCd
	 */
	public	String getCtrtCustCntCd() {
		return	this.ctrtCustCntCd;
	}

	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public	String getCtrtEffDt() {
		return	this.ctrtEffDt;
	}

	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public	String getAmdtSeq() {
		return	this.amdtSeq;
	}

	/**
	 * Column Info
	 * @return creDt
	 */
	public	String getCreDt() {
		return	this.creDt;
	}

	/**
	 * Column Info
	 * @return prsCrntCmAmt
	 */
	public	String getPrsCrntCmAmt() {
		return	this.prsCrntCmAmt;
	}

	/**
	 * Column Info
	 * @return respbSlsOfcCd
	 */
	public	String getRespbSlsOfcCd() {
		return	this.respbSlsOfcCd;
	}

	/**
	 * Column Info
	 * @return propSts
	 */
	public	String getPropSts() {
		return	this.propSts;
	}

	/**
	 * Column Info
	 * @return rfaNo
	 */
	public	String getRfaNo() {
		return	this.rfaNo;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public	String getEffDt() {
		return	this.effDt;
	}

	/**
	 * Column Info
	 * @return propSrepNm
	 */
	public	String getPropSrepNm() {
		return	this.propSrepNm;
	}

	/**
	 * Column Info
	 * @return ctrtCustValSgm
	 */
	public	String getCtrtCustValSgm() {
		return	this.ctrtCustValSgm;
	}

	/**
	 * Column Info
	 * @return ctrtCustSrepNm
	 */
	public	String getCtrtCustSrepNm() {
		return	this.ctrtCustSrepNm;
	}

	/**
	 * Column Info
	 * @return propStsCd
	 */
	public	String getPropStsCd() {
		return	this.propStsCd;
	}

	/**
	 * Column Info
	 * @return prsEstmCmAmt
	 */
	public	String getPrsEstmCmAmt() {
		return	this.prsEstmCmAmt;
	}

	/**
	 * Column Info
	 * @return tgtMvcQty
	 */
	public	String getTgtMvcQty() {
		return	this.tgtMvcQty;
	}

	/**
	 * Column Info
	 * @return expDt
	 */
	public	String getExpDt() {
		return	this.expDt;
	}

	/**
	 * Column Info
	 * @return slsLdNo
	 */
	public	String getSlsLdNo() {
		return	this.slsLdNo;
	}

	/**
	 * Column Info
	 * @return ctrtExpDt
	 */
	public	String getCtrtExpDt() {
		return	this.ctrtExpDt;
	}

	/**
	 * Column Info
	 * @return fileDt
	 */
	public	String getFileDt() {
		return	this.fileDt;
	}

	/**
	 * Column Info
	 * @return propSrepCd
	 */
	public	String getPropSrepCd() {
		return	this.propSrepCd;
	}

	/**
	 * Column Info
	 * @return ctrtCustSeq
	 */
	public	String getCtrtCustSeq() {
		return	this.ctrtCustSeq;
	}

	/**
	 * Column Info
	 * @return respbSrepCd
	 */
	public	String getRespbSrepCd() {
		return	this.respbSrepCd;
	}

	/**
	 * Column Info
	 * @return dmdtFtTpCd
	 */
	public	String getDmdtFtTpCd() {
		return	this.dmdtFtTpCd;
	}

	/**
	 * Column Info
	 * @return cntrLodUtCd
	 */
	public	String getCntrLodUtCd() {
		return	this.cntrLodUtCd;
	}

	/**
	 * Column Info
	 * @return preAmdtSeq
	 */
	public	String getPreAmdtSeq() {
		return	this.preAmdtSeq;
	}

	/**
	 * Column Info
	 * @return prcCtrtCustTpCd
	 */
	public	String getPrcCtrtCustTpCd() {
		return	this.prcCtrtCustTpCd;
	}

	/**
	 * Column Info
	 * @return unit
	 */
	public	String getUnit() {
		return	this.unit;
	}

	/**
	 * Column Info
	 * @return ctrtPtyNm
	 */
	public	String getCtrtPtyNm() {
		return	this.ctrtPtyNm;
	}

	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public	String getPropOfcCd() {
		return	this.propOfcCd;
	}

	/**
	 * Column Info
	 * @return propAproOfcCd
	 */
	public	String getPropAproOfcCd() {
		return	this.propAproOfcCd;
	}

	/**
	 * Column Info
	 * @return propNo
	 */
	public	String getPropNo() {
		return	this.propNo;
	}

	/**
	 * Column Info
	 * @return propAproStaff
	 */
	public	String getPropAproStaff() {
		return	this.propAproStaff;
	}

	/**
	 * Column Info
	 * @return prcCtrtCustTpNm
	 */
	public	String getPrcCtrtCustTpNm() {
		return	this.prcCtrtCustTpNm;
	}

	/**
	 * Column Info
	 * @return ctrtCustValSgmCd
	 */
	public	String getCtrtCustValSgmCd() {
		return	this.ctrtCustValSgmCd;
	}

	/**
	 * Column Info
	 * @return trfCtrtFlg
	 */
	public	String getTrfCtrtFlg() {
		return	this.trfCtrtFlg;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  propAproDt
 	 */
	public void	setPropAproDt(String propAproDt ) {
		this.propAproDt =	propAproDt;
	}
 	/**
	 * Column Info
	 * @param  ctrtCustCntCd
 	 */
	public void	setCtrtCustCntCd(String ctrtCustCntCd ) {
		this.ctrtCustCntCd =	ctrtCustCntCd;
	}
 	/**
	 * Column Info
	 * @param  ctrtEffDt
 	 */
	public void	setCtrtEffDt(String ctrtEffDt ) {
		this.ctrtEffDt =	ctrtEffDt;
	}
 	/**
	 * Column Info
	 * @param  amdtSeq
 	 */
	public void	setAmdtSeq(String amdtSeq ) {
		this.amdtSeq =	amdtSeq;
	}
 	/**
	 * Column Info
	 * @param  creDt
 	 */
	public void	setCreDt(String creDt ) {
		this.creDt =	creDt;
	}
 	/**
	 * Column Info
	 * @param  prsCrntCmAmt
 	 */
	public void	setPrsCrntCmAmt(String prsCrntCmAmt ) {
		this.prsCrntCmAmt =	prsCrntCmAmt;
	}
 	/**
	 * Column Info
	 * @param  respbSlsOfcCd
 	 */
	public void	setRespbSlsOfcCd(String respbSlsOfcCd ) {
		this.respbSlsOfcCd =	respbSlsOfcCd;
	}
 	/**
	 * Column Info
	 * @param  propSts
 	 */
	public void	setPropSts(String propSts ) {
		this.propSts =	propSts;
	}
 	/**
	 * Column Info
	 * @param  rfaNo
 	 */
	public void	setRfaNo(String rfaNo ) {
		this.rfaNo =	rfaNo;
	}
 	/**
	 * Column Info
	 * @param  effDt
 	 */
	public void	setEffDt(String effDt ) {
		this.effDt =	effDt;
	}
 	/**
	 * Column Info
	 * @param  propSrepNm
 	 */
	public void	setPropSrepNm(String propSrepNm ) {
		this.propSrepNm =	propSrepNm;
	}
 	/**
	 * Column Info
	 * @param  ctrtCustValSgm
 	 */
	public void	setCtrtCustValSgm(String ctrtCustValSgm ) {
		this.ctrtCustValSgm =	ctrtCustValSgm;
	}
 	/**
	 * Column Info
	 * @param  ctrtCustSrepNm
 	 */
	public void	setCtrtCustSrepNm(String ctrtCustSrepNm ) {
		this.ctrtCustSrepNm =	ctrtCustSrepNm;
	}
 	/**
	 * Column Info
	 * @param  propStsCd
 	 */
	public void	setPropStsCd(String propStsCd ) {
		this.propStsCd =	propStsCd;
	}
 	/**
	 * Column Info
	 * @param  prsEstmCmAmt
 	 */
	public void	setPrsEstmCmAmt(String prsEstmCmAmt ) {
		this.prsEstmCmAmt =	prsEstmCmAmt;
	}
 	/**
	 * Column Info
	 * @param  tgtMvcQty
 	 */
	public void	setTgtMvcQty(String tgtMvcQty ) {
		this.tgtMvcQty =	tgtMvcQty;
	}
 	/**
	 * Column Info
	 * @param  expDt
 	 */
	public void	setExpDt(String expDt ) {
		this.expDt =	expDt;
	}
 	/**
	 * Column Info
	 * @param  slsLdNo
 	 */
	public void	setSlsLdNo(String slsLdNo ) {
		this.slsLdNo =	slsLdNo;
	}
 	/**
	 * Column Info
	 * @param  ctrtExpDt
 	 */
	public void	setCtrtExpDt(String ctrtExpDt ) {
		this.ctrtExpDt =	ctrtExpDt;
	}
 	/**
	 * Column Info
	 * @param  fileDt
 	 */
	public void	setFileDt(String fileDt ) {
		this.fileDt =	fileDt;
	}
 	/**
	 * Column Info
	 * @param  propSrepCd
 	 */
	public void	setPropSrepCd(String propSrepCd ) {
		this.propSrepCd =	propSrepCd;
	}
 	/**
	 * Column Info
	 * @param  ctrtCustSeq
 	 */
	public void	setCtrtCustSeq(String ctrtCustSeq ) {
		this.ctrtCustSeq =	ctrtCustSeq;
	}
 	/**
	 * Column Info
	 * @param  respbSrepCd
 	 */
	public void	setRespbSrepCd(String respbSrepCd ) {
		this.respbSrepCd =	respbSrepCd;
	}
 	/**
	 * Column Info
	 * @param  dmdtFtTpCd
 	 */
	public void	setDmdtFtTpCd(String dmdtFtTpCd ) {
		this.dmdtFtTpCd =	dmdtFtTpCd;
	}
 	/**
	 * Column Info
	 * @param  cntrLodUtCd
 	 */
	public void	setCntrLodUtCd(String cntrLodUtCd ) {
		this.cntrLodUtCd =	cntrLodUtCd;
	}
 	/**
	 * Column Info
	 * @param  preAmdtSeq
 	 */
	public void	setPreAmdtSeq(String preAmdtSeq ) {
		this.preAmdtSeq =	preAmdtSeq;
	}
 	/**
	 * Column Info
	 * @param  prcCtrtCustTpCd
 	 */
	public void	setPrcCtrtCustTpCd(String prcCtrtCustTpCd ) {
		this.prcCtrtCustTpCd =	prcCtrtCustTpCd;
	}
 	/**
	 * Column Info
	 * @param  unit
 	 */
	public void	setUnit(String unit ) {
		this.unit =	unit;
	}
 	/**
	 * Column Info
	 * @param  ctrtPtyNm
 	 */
	public void	setCtrtPtyNm(String ctrtPtyNm ) {
		this.ctrtPtyNm =	ctrtPtyNm;
	}
 	/**
	 * Column Info
	 * @param  propOfcCd
 	 */
	public void	setPropOfcCd(String propOfcCd ) {
		this.propOfcCd =	propOfcCd;
	}
 	/**
	 * Column Info
	 * @param  propAproOfcCd
 	 */
	public void	setPropAproOfcCd(String propAproOfcCd ) {
		this.propAproOfcCd =	propAproOfcCd;
	}
 	/**
	 * Column Info
	 * @param  propNo
 	 */
	public void	setPropNo(String propNo ) {
		this.propNo =	propNo;
	}
 	/**
	 * Column Info
	 * @param  propAproStaff
 	 */
	public void	setPropAproStaff(String propAproStaff ) {
		this.propAproStaff =	propAproStaff;
	}
 	/**
	 * Column Info
	 * @param  prcCtrtCustTpNm
 	 */
	public void	setPrcCtrtCustTpNm(String prcCtrtCustTpNm ) {
		this.prcCtrtCustTpNm =	prcCtrtCustTpNm;
	}
 	/**
	 * Column Info
	 * @param  ctrtCustValSgmCd
 	 */
	public void	setCtrtCustValSgmCd(String ctrtCustValSgmCd ) {
		this.ctrtCustValSgmCd =	ctrtCustValSgmCd;
	}
 	/**
	 * Column Info
	 * @param  trfCtrtFlg
 	 */
	public void	setTrfCtrtFlg(String trfCtrtFlg ) {
		this.trfCtrtFlg =	trfCtrtFlg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPropAproDt(JSPUtil.getParameter(request,	prefix + "prop_apro_dt", ""));
		setCtrtCustCntCd(JSPUtil.getParameter(request,	prefix + "ctrt_cust_cnt_cd", ""));
		setCtrtEffDt(JSPUtil.getParameter(request,	prefix + "ctrt_eff_dt", ""));
		setAmdtSeq(JSPUtil.getParameter(request,	prefix + "amdt_seq", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setPrsCrntCmAmt(JSPUtil.getParameter(request,	prefix + "prs_crnt_cm_amt", ""));
		setRespbSlsOfcCd(JSPUtil.getParameter(request,	prefix + "respb_sls_ofc_cd", ""));
		setPropSts(JSPUtil.getParameter(request,	prefix + "prop_sts", ""));
		setRfaNo(JSPUtil.getParameter(request,	prefix + "rfa_no", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setPropSrepNm(JSPUtil.getParameter(request,	prefix + "prop_srep_nm", ""));
		setCtrtCustValSgm(JSPUtil.getParameter(request,	prefix + "ctrt_cust_val_sgm", ""));
		setCtrtCustSrepNm(JSPUtil.getParameter(request,	prefix + "ctrt_cust_srep_nm", ""));
		setPropStsCd(JSPUtil.getParameter(request,	prefix + "prop_sts_cd", ""));
		setPrsEstmCmAmt(JSPUtil.getParameter(request,	prefix + "prs_estm_cm_amt", ""));
		setTgtMvcQty(JSPUtil.getParameter(request,	prefix + "tgt_mvc_qty", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setSlsLdNo(JSPUtil.getParameter(request,	prefix + "sls_ld_no", ""));
		setCtrtExpDt(JSPUtil.getParameter(request,	prefix + "ctrt_exp_dt", ""));
		setFileDt(JSPUtil.getParameter(request,	prefix + "file_dt", ""));
		setPropSrepCd(JSPUtil.getParameter(request,	prefix + "prop_srep_cd", ""));
		setCtrtCustSeq(JSPUtil.getParameter(request,	prefix + "ctrt_cust_seq", ""));
		setRespbSrepCd(JSPUtil.getParameter(request,	prefix + "respb_srep_cd", ""));
		setDmdtFtTpCd(JSPUtil.getParameter(request,	prefix + "dmdt_ft_tp_cd", ""));
		setCntrLodUtCd(JSPUtil.getParameter(request,	prefix + "cntr_lod_ut_cd", ""));
		setPreAmdtSeq(JSPUtil.getParameter(request,	prefix + "pre_amdt_seq", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request,	prefix + "prc_ctrt_cust_tp_cd", ""));
		setUnit(JSPUtil.getParameter(request,	prefix + "unit", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request,	prefix + "ctrt_pty_nm", ""));
		setPropOfcCd(JSPUtil.getParameter(request,	prefix + "prop_ofc_cd", ""));
		setPropAproOfcCd(JSPUtil.getParameter(request,	prefix + "prop_apro_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request,	prefix + "prop_no", ""));
		setPropAproStaff(JSPUtil.getParameter(request,	prefix + "prop_apro_staff", ""));
		setPrcCtrtCustTpNm(JSPUtil.getParameter(request,	prefix + "prc_ctrt_cust_tp_nm", ""));
		setCtrtCustValSgmCd(JSPUtil.getParameter(request,	prefix + "ctrt_cust_val_sgm_cd", ""));
		setTrfCtrtFlg(JSPUtil.getParameter(request,	prefix + "trf_ctrt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPropMnInqVO[]
	 */
	public RsltPropMnInqVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltPropMnInqVO[]
	 */
	public RsltPropMnInqVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltPropMnInqVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] propAproDt =	(JSPUtil.getParameter(request, prefix +	"prop_apro_dt",	length));
			String[] ctrtCustCntCd =	(JSPUtil.getParameter(request, prefix +	"ctrt_cust_cnt_cd",	length));
			String[] ctrtEffDt =	(JSPUtil.getParameter(request, prefix +	"ctrt_eff_dt",	length));
			String[] amdtSeq =	(JSPUtil.getParameter(request, prefix +	"amdt_seq",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] prsCrntCmAmt =	(JSPUtil.getParameter(request, prefix +	"prs_crnt_cm_amt",	length));
			String[] respbSlsOfcCd =	(JSPUtil.getParameter(request, prefix +	"respb_sls_ofc_cd",	length));
			String[] propSts =	(JSPUtil.getParameter(request, prefix +	"prop_sts",	length));
			String[] rfaNo =	(JSPUtil.getParameter(request, prefix +	"rfa_no",	length));
			String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt",	length));
			String[] propSrepNm =	(JSPUtil.getParameter(request, prefix +	"prop_srep_nm",	length));
			String[] ctrtCustValSgm =	(JSPUtil.getParameter(request, prefix +	"ctrt_cust_val_sgm",	length));
			String[] ctrtCustSrepNm =	(JSPUtil.getParameter(request, prefix +	"ctrt_cust_srep_nm",	length));
			String[] propStsCd =	(JSPUtil.getParameter(request, prefix +	"prop_sts_cd",	length));
			String[] prsEstmCmAmt =	(JSPUtil.getParameter(request, prefix +	"prs_estm_cm_amt",	length));
			String[] tgtMvcQty =	(JSPUtil.getParameter(request, prefix +	"tgt_mvc_qty",	length));
			String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt",	length));
			String[] slsLdNo =	(JSPUtil.getParameter(request, prefix +	"sls_ld_no",	length));
			String[] ctrtExpDt =	(JSPUtil.getParameter(request, prefix +	"ctrt_exp_dt",	length));
			String[] fileDt =	(JSPUtil.getParameter(request, prefix +	"file_dt",	length));
			String[] propSrepCd =	(JSPUtil.getParameter(request, prefix +	"prop_srep_cd",	length));
			String[] ctrtCustSeq =	(JSPUtil.getParameter(request, prefix +	"ctrt_cust_seq",	length));
			String[] respbSrepCd =	(JSPUtil.getParameter(request, prefix +	"respb_srep_cd",	length));
			String[] dmdtFtTpCd =	(JSPUtil.getParameter(request, prefix +	"dmdt_ft_tp_cd",	length));
			String[] cntrLodUtCd =	(JSPUtil.getParameter(request, prefix +	"cntr_lod_ut_cd",	length));
			String[] preAmdtSeq =	(JSPUtil.getParameter(request, prefix +	"pre_amdt_seq",	length));
			String[] prcCtrtCustTpCd =	(JSPUtil.getParameter(request, prefix +	"prc_ctrt_cust_tp_cd",	length));
			String[] unit =	(JSPUtil.getParameter(request, prefix +	"unit",	length));
			String[] ctrtPtyNm =	(JSPUtil.getParameter(request, prefix +	"ctrt_pty_nm",	length));
			String[] propOfcCd =	(JSPUtil.getParameter(request, prefix +	"prop_ofc_cd",	length));
			String[] propAproOfcCd =	(JSPUtil.getParameter(request, prefix +	"prop_apro_ofc_cd",	length));
			String[] propNo =	(JSPUtil.getParameter(request, prefix +	"prop_no",	length));
			String[] propAproStaff =	(JSPUtil.getParameter(request, prefix +	"prop_apro_staff",	length));
			String[] prcCtrtCustTpNm =	(JSPUtil.getParameter(request, prefix +	"prc_ctrt_cust_tp_nm",	length));
			String[] ctrtCustValSgmCd =	(JSPUtil.getParameter(request, prefix +	"ctrt_cust_val_sgm_cd",	length));
			String[] trfCtrtFlg =	(JSPUtil.getParameter(request, prefix +	"trf_ctrt_flg",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltPropMnInqVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( propAproDt[i] !=	null)
					model.setPropAproDt( propAproDt[i]);
				if ( ctrtCustCntCd[i] !=	null)
					model.setCtrtCustCntCd( ctrtCustCntCd[i]);
				if ( ctrtEffDt[i] !=	null)
					model.setCtrtEffDt( ctrtEffDt[i]);
				if ( amdtSeq[i] !=	null)
					model.setAmdtSeq( amdtSeq[i]);
				if ( creDt[i] !=	null)
					model.setCreDt( creDt[i]);
				if ( prsCrntCmAmt[i] !=	null)
					model.setPrsCrntCmAmt( prsCrntCmAmt[i]);
				if ( respbSlsOfcCd[i] !=	null)
					model.setRespbSlsOfcCd( respbSlsOfcCd[i]);
				if ( propSts[i] !=	null)
					model.setPropSts( propSts[i]);
				if ( rfaNo[i] !=	null)
					model.setRfaNo( rfaNo[i]);
				if ( effDt[i] !=	null)
					model.setEffDt( effDt[i]);
				if ( propSrepNm[i] !=	null)
					model.setPropSrepNm( propSrepNm[i]);
				if ( ctrtCustValSgm[i] !=	null)
					model.setCtrtCustValSgm( ctrtCustValSgm[i]);
				if ( ctrtCustSrepNm[i] !=	null)
					model.setCtrtCustSrepNm( ctrtCustSrepNm[i]);
				if ( propStsCd[i] !=	null)
					model.setPropStsCd( propStsCd[i]);
				if ( prsEstmCmAmt[i] !=	null)
					model.setPrsEstmCmAmt( prsEstmCmAmt[i]);
				if ( tgtMvcQty[i] !=	null)
					model.setTgtMvcQty( tgtMvcQty[i]);
				if ( expDt[i] !=	null)
					model.setExpDt( expDt[i]);
				if ( slsLdNo[i] !=	null)
					model.setSlsLdNo( slsLdNo[i]);
				if ( ctrtExpDt[i] !=	null)
					model.setCtrtExpDt( ctrtExpDt[i]);
				if ( fileDt[i] !=	null)
					model.setFileDt( fileDt[i]);
				if ( propSrepCd[i] !=	null)
					model.setPropSrepCd( propSrepCd[i]);
				if ( ctrtCustSeq[i] !=	null)
					model.setCtrtCustSeq( ctrtCustSeq[i]);
				if ( respbSrepCd[i] !=	null)
					model.setRespbSrepCd( respbSrepCd[i]);
				if ( dmdtFtTpCd[i] !=	null)
					model.setDmdtFtTpCd( dmdtFtTpCd[i]);
				if ( cntrLodUtCd[i] !=	null)
					model.setCntrLodUtCd( cntrLodUtCd[i]);
				if ( preAmdtSeq[i] !=	null)
					model.setPreAmdtSeq( preAmdtSeq[i]);
				if ( prcCtrtCustTpCd[i] !=	null)
					model.setPrcCtrtCustTpCd( prcCtrtCustTpCd[i]);
				if ( unit[i] !=	null)
					model.setUnit( unit[i]);
				if ( ctrtPtyNm[i] !=	null)
					model.setCtrtPtyNm( ctrtPtyNm[i]);
				if ( propOfcCd[i] !=	null)
					model.setPropOfcCd( propOfcCd[i]);
				if ( propAproOfcCd[i] !=	null)
					model.setPropAproOfcCd( propAproOfcCd[i]);
				if ( propNo[i] !=	null)
					model.setPropNo( propNo[i]);
				if ( propAproStaff[i] !=	null)
					model.setPropAproStaff( propAproStaff[i]);
				if ( prcCtrtCustTpNm[i] !=	null)
					model.setPrcCtrtCustTpNm( prcCtrtCustTpNm[i]);
				if ( ctrtCustValSgmCd[i] !=	null)
					model.setCtrtCustValSgmCd( ctrtCustValSgmCd[i]);
				if ( trfCtrtFlg[i] !=	null)
					model.setTrfCtrtFlg( trfCtrtFlg[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltPropMnInqVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltPropMnInqVO[]
	 */
	public RsltPropMnInqVO[]	 getRsltPropMnInqVOs(){
		RsltPropMnInqVO[] vos = (RsltPropMnInqVO[])models.toArray(new	RsltPropMnInqVO[models.size()]);
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
	public void	unDataFormat(){
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproDt =	this.propAproDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustCntCd =	this.ctrtCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt =	this.ctrtEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq =	this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsCrntCmAmt =	this.prsCrntCmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSlsOfcCd =	this.respbSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSts =	this.propSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo =	this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepNm =	this.propSrepNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgm =	this.ctrtCustValSgm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepNm =	this.ctrtCustSrepNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd =	this.propStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prsEstmCmAmt =	this.prsEstmCmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tgtMvcQty =	this.tgtMvcQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsLdNo =	this.slsLdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt =	this.ctrtExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt =	this.fileDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propSrepCd =	this.propSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSeq =	this.ctrtCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbSrepCd =	this.respbSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtFtTpCd =	this.dmdtFtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodUtCd =	this.cntrLodUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preAmdtSeq =	this.preAmdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd =	this.prcCtrtCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unit =	this.unit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm =	this.ctrtPtyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd =	this.propOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproOfcCd =	this.propAproOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo =	this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propAproStaff =	this.propAproStaff.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpNm =	this.prcCtrtCustTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustValSgmCd =	this.ctrtCustValSgmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCtrtFlg =	this.trfCtrtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}