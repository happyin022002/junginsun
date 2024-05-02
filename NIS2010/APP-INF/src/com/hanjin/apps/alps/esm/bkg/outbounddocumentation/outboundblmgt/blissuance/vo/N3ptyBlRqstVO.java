/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : N3ptyBlRqstVO.java
*@FileTitle : N3ptyBlRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.25
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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

public class N3ptyBlRqstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<N3ptyBlRqstVO> models = new ArrayList<N3ptyBlRqstVO>();
	
	/* Column Info */
	private String payrCustNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String n3ptyBlStsCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyOfcCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String blRmk = null;
	/* Column Info */
	private String payrCustCntCd = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String rqstFromDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String rqstBlTpCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String shprCntcPhnNo = null;
	/* Column Info */
	private String actDt = null;
	/* Column Info */
	private String payrCustSeq = null;
	/* Column Info */
	private String rqstToDt = null;
	/* Column Info */
	private String payrCustCd = null;
	/* Column Info */
	private String blAtch = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String n3ptyPaySts = null;
	/* Column Info */
	private String polOfcCd = null;
	/* Column Info */
	private String setSlctFlg = null;
	/* Column Info */
	private String setQryWhere = null;
	/* Column Info */
	private String chgFlg = null;
	/* Column Info */
	private String usrEml = null;
	/* Column Info */
	private String oldN3ptyBlStsCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String bkgUsrId = null;
	/* Column Info */
	private String n3ptyBlChgTtlAmt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String blIssOfcCd = null;
	/* Column Info */
	private String accssOfcCd = null;
	/* Column Info */
	private String podCd = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public N3ptyBlRqstVO() {}

	public N3ptyBlRqstVO(String ibflag, String pagerows, String bkgNo, String polCd, String n3ptyOfcCd, String payrCustCntCd, String payrCustSeq, String payrCustCd, String shprCntcPhnNo, String n3ptyBlStsCd, String rqstDt, String actDt, String usrId, String blRmk, String blAtch, String vvd, String etdDt, String creUsrId, String creDt, String updUsrId, String updDt, String rqstBlTpCd, String rqstFromDt, String rqstToDt, String shprCd, String frtTermCd, String n3ptyPaySts, String polOfcCd, String setSlctFlg, String setQryWhere,String oldN3ptyBlStsCd, String chgFlg, String usrEml, String bkgOfcCd, String bkgUsrId,String n3ptyBlChgTtlAmt, String blIssOfcCd, String rfaNo,String scNo, String accssOfcCd, String podCd, String payrCustNm) {
		this.creDt = creDt;
		this.n3ptyBlStsCd = n3ptyBlStsCd;
		this.pagerows = pagerows;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.blRmk = blRmk;
		this.payrCustCntCd = payrCustCntCd;
		this.shprCd = shprCd;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.rqstDt = rqstDt;
		this.etdDt = etdDt;
		this.rqstFromDt = rqstFromDt;
		this.vvd = vvd;
		this.rqstBlTpCd = rqstBlTpCd;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.shprCntcPhnNo = shprCntcPhnNo;
		this.actDt = actDt;
		this.payrCustSeq = payrCustSeq;
		this.rqstToDt = rqstToDt;
		this.payrCustCd = payrCustCd;
		this.blAtch = blAtch;
		this.frtTermCd = frtTermCd;
		this.n3ptyPaySts = n3ptyPaySts;
		this.polOfcCd = polOfcCd;
		this.setSlctFlg = setSlctFlg;
		this.setQryWhere = setQryWhere;
		this.chgFlg = chgFlg;
		this.usrEml = usrEml;
		this.oldN3ptyBlStsCd = oldN3ptyBlStsCd;
		this.bkgOfcCd = bkgOfcCd;
		this.bkgUsrId = bkgUsrId;
		this.n3ptyBlChgTtlAmt = n3ptyBlChgTtlAmt;
		this.accssOfcCd = accssOfcCd;
		this.podCd = podCd;
		this.scNo = scNo;
		this.rfaNo = rfaNo;
		this.blIssOfcCd = blIssOfcCd;
		this.payrCustNm = payrCustNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("n3pty_bl_sts_cd", getN3ptyBlStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("bl_rmk", getBlRmk());
		this.hashColumns.put("payr_cust_cnt_cd", getPayrCustCntCd());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("rqst_from_dt", getRqstFromDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rqst_bl_tp_cd", getRqstBlTpCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("shpr_cntc_phn_no", getShprCntcPhnNo());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("act_dt", getActDt());
		this.hashColumns.put("payr_cust_seq", getPayrCustSeq());
		this.hashColumns.put("rqst_to_dt", getRqstToDt());
		this.hashColumns.put("payr_cust_cd", getPayrCustCd());
		this.hashColumns.put("bl_atch", getBlAtch());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("n3pty_pay_sts", getN3ptyPaySts());
		this.hashColumns.put("pol_ofc_cd", getPolOfcCd());
		this.hashColumns.put("set_slct_flg", getSetSlctFlg());
		this.hashColumns.put("chg_flg", getChgFlg());
		this.hashColumns.put("usr_eml", getUsrEml());
		this.hashColumns.put("old_n3pty_bl_sts_cd", getOldN3ptyBlStsCd());
		this.hashColumns.put("set_qry_where", getSetQryWhere());
		this.hashColumns.put("bkg_usr_id", getBkgUsrId());
		this.hashColumns.put("n3pty_bl_chg_ttl_amt", getN3ptyBlChgTtlAmt());
		this.hashColumns.put("accss_ofc_cd", getAccssOfcCd());
		
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("bl_iss_ofc_cd", getBlIssOfcCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("payr_cust_nm", getPayrCustNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n3pty_bl_sts_cd", "n3ptyBlStsCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bl_rmk", "blRmk");
		this.hashFields.put("payr_cust_cnt_cd", "payrCustCntCd");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("rqst_from_dt", "rqstFromDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rqst_bl_tp_cd", "rqstBlTpCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("shpr_cntc_phn_no", "shprCntcPhnNo");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("payr_cust_seq", "payrCustSeq");
		this.hashFields.put("rqst_to_dt", "rqstToDt");
		this.hashFields.put("payr_cust_cd", "payrCustCd");
		this.hashFields.put("bl_atch", "blAtch");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("n3pty_pay_sts", "n3ptyPaySts");
		this.hashFields.put("pol_ofc_cd", "polOfcCd");
		this.hashFields.put("set_slct_flg", "setSlctFlg");
		this.hashFields.put("set_qry_where", "setQryWhere");
		this.hashFields.put("chg_flg", "chgFlg");
		this.hashFields.put("usr_eml", "usrEml");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("old_n3pty_bl_sts_cd", "oldN3ptyBlStsCd");
		this.hashFields.put("bkg_usr_id", "bkgUsrId");
		this.hashFields.put("n3pty_bl_chg_ttl_amt", "n3ptyBlChgTtlAmt");
		this.hashFields.put("accss_ofc_cd", "accssOfcCd");
		
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("bl_iss_ofc_cd", "blIssOfcCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("payr_cust_nm", "payrCustNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payrCustNm
	 */
	public String getPayrCustNm() {
		return this.payrCustNm;
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
	 * @return n3ptyBlStsCd
	 */
	public String getN3ptyBlStsCd() {
		return this.n3ptyBlStsCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return n3ptyOfcCd
	 */
	public String getN3ptyOfcCd() {
		return this.n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return blRmk
	 */
	public String getBlRmk() {
		return this.blRmk;
	}
	
	/**
	 * Column Info
	 * @return payrCustCntCd
	 */
	public String getPayrCustCntCd() {
		return this.payrCustCntCd;
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
	 * @return shprCd
	 */
	public String getShprCd() {
		return this.shprCd;
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
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return accssOfcCd
	 */
	public String getAccssOfcCd() {
		return this.accssOfcCd;
	}
	
	/**
	 * Column Info
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return rqstFromDt
	 */
	public String getRqstFromDt() {
		return this.rqstFromDt;
	}
	
	/**
	 * Column Info
	 * @return chgFlg
	 */
	public String getChgFlg() {
		return this.chgFlg;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	/**
	 * Column Info
	 * @return blIssOfcCd
	 */
	public String getBlIssOfcCd() {
		return this.blIssOfcCd;
	}
	/**
	 * Column Info
	 * @return oldN3ptyBlStsCd
	 */
	public String getOldN3ptyBlStsCd() {
		return this.oldN3ptyBlStsCd;
	}
	
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return rqstBlTpCd
	 */
	public String getRqstBlTpCd() {
		return this.rqstBlTpCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return shprCntcPhnNo
	 */
	public String getShprCntcPhnNo() {
		return this.shprCntcPhnNo;
	}
	
	/**
	 * Column Info
	 * @return actDt
	 */
	public String getActDt() {
		return this.actDt;
	}
	
	/**
	 * Column Info
	 * @return payrCustSeq
	 */
	public String getPayrCustSeq() {
		return this.payrCustSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstToDt
	 */
	public String getRqstToDt() {
		return this.rqstToDt;
	}
	
	/**
	 * Column Info
	 * @return payrCustCd
	 */
	public String getPayrCustCd() {
		return this.payrCustCd;
	}
	
	/**
	 * Column Info
	 * @return blAtch
	 */
	public String getBlAtch() {
		return this.blAtch;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	
	/**
	 * Column Info
	 * @return n3ptyPaySts
	 */
	public String getN3ptyPaySts() {
		return this.n3ptyPaySts;
	}
	
	/**
	 * Column Info
	 * @return polOfcCd
	 */
	public String getPolOfcCd() {
		return this.polOfcCd;
	}
	
	/**
	 * Column Info
	 * @return usrEml
	 */
	public String getUsrEml() {
		return this.usrEml;
	}
	
	/**
	 * Column Info
	 * @return setSlctFlg
	 */
	public String getSetSlctFlg() {
		return this.setSlctFlg;
	}
	
	
	/**
	 * Column Info
	 * @return setQryWhere
	 */
	public String getSetQryWhere() {
		return this.setQryWhere;
	}
	

	/**
	 * Column Info
	 * @return bkgUsrId
	 */
	public String getBkgUsrId() {
		return this.bkgUsrId;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBlChgTtlAmt
	 */
	public String getN3ptyBlChgTtlAmt() {
		return this.n3ptyBlChgTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param payrCustNm
	 */
	public void setPayrCustNm(String payrCustNm) {
		this.payrCustNm = payrCustNm;
	}
	

	/**
	 * Column Info
	 * @param n3ptyBlChgTtlAmt
	 */
	public void setN3ptyBlChgTtlAmt(String n3ptyBlChgTtlAmt) {
		this.n3ptyBlChgTtlAmt = n3ptyBlChgTtlAmt;
	}
	

	/**
	 * Column Info
	 * @param bkgUsrId
	 */
	public void setBkgUsrId(String bkgUsrId) {
		this.bkgUsrId = bkgUsrId;
	}
	
	/**
	 * Column Info
	 * @param setQryWhere
	 */
	public void setSetQryWhere(String setQryWhere) {
		this.setQryWhere = setQryWhere;
	}
	

	/**
	 * Column Info
	 * @param setSlctFlg
	 */
	public void setSetSlctFlg(String setSlctFlg) {
		this.setSlctFlg = setSlctFlg;
	}
	
	/**
	 * Column Info
	 * @param polOfcCd
	 */
	public void setPolOfcCd(String polOfcCd) {
		this.polOfcCd = polOfcCd;
	}
	
	
	/**
	 * Column Info
	 * @param n3ptyPaySts
	 */
	public void setN3ptyPaySts(String n3ptyPaySts) {
		this.n3ptyPaySts = n3ptyPaySts;
	}
	
	

	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param chgFlg
	 */
	public void setChgFlg(String chgFlg) {
		this.chgFlg = chgFlg;
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
	 * @param accssOfcCd
	 */
	public void setAccssOfcCd(String accssOfcCd) {
		this.accssOfcCd = accssOfcCd;
	}
	
	/**
	 * Column Info
	 * @param usrEml
	 */
	public void setUsrEml(String usrEml) {
		this.usrEml = usrEml;
	}
	
	
	/**
	 * Column Info
	 * @param oldN3ptyBlStsCd
	 */
	public void setOldN3ptyBlStsCd(String oldN3ptyBlStsCd) {
		this.oldN3ptyBlStsCd = oldN3ptyBlStsCd;
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
	 * @param n3ptyBlStsCd
	 */
	public void setN3ptyBlStsCd(String n3ptyBlStsCd) {
		this.n3ptyBlStsCd = n3ptyBlStsCd;
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
	 * @param n3ptyOfcCd
	 */
	public void setN3ptyOfcCd(String n3ptyOfcCd) {
		this.n3ptyOfcCd = n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param blRmk
	 */
	public void setBlRmk(String blRmk) {
		this.blRmk = blRmk;
	}
	
	/**
	 * Column Info
	 * @param payrCustCntCd
	 */
	public void setPayrCustCntCd(String payrCustCntCd) {
		this.payrCustCntCd = payrCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param shprCd
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param rqstFromDt
	 */
	public void setRqstFromDt(String rqstFromDt) {
		this.rqstFromDt = rqstFromDt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param rqstBlTpCd
	 */
	public void setRqstBlTpCd(String rqstBlTpCd) {
		this.rqstBlTpCd = rqstBlTpCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param shprCntcPhnNo
	 */
	public void setShprCntcPhnNo(String shprCntcPhnNo) {
		this.shprCntcPhnNo = shprCntcPhnNo;
	}
	
	/**
	 * Column Info
	 * @param actDt
	 */
	public void setActDt(String actDt) {
		this.actDt = actDt;
	}
	
	/**
	 * Column Info
	 * @param payrCustSeq
	 */
	public void setPayrCustSeq(String payrCustSeq) {
		this.payrCustSeq = payrCustSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstToDt
	 */
	public void setRqstToDt(String rqstToDt) {
		this.rqstToDt = rqstToDt;
	}
	
	/**
	 * Column Info
	 * @param payrCustCd
	 */
	public void setPayrCustCd(String payrCustCd) {
		this.payrCustCd = payrCustCd;
	}
	
	/**
	 * Column Info
	 * @param blAtch
	 */
	public void setBlAtch(String blAtch) {
		this.blAtch = blAtch;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	/**
	 * Column Info
	 * @param blIssOfcCd
	 */
	public void setBlIssOfcCd(String blIssOfcCd) {
		this.blIssOfcCd = blIssOfcCd;
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
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setN3ptyBlStsCd(JSPUtil.getParameter(request, prefix + "n3pty_bl_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_ofc_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setBlRmk(JSPUtil.getParameter(request, prefix + "bl_rmk", ""));
		setPayrCustCntCd(JSPUtil.getParameter(request, prefix + "payr_cust_cnt_cd", ""));
		setShprCd(JSPUtil.getParameter(request, prefix + "shpr_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setEtdDt(JSPUtil.getParameter(request, prefix + "etd_dt", ""));
		setRqstFromDt(JSPUtil.getParameter(request, prefix + "rqst_from_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRqstBlTpCd(JSPUtil.getParameter(request, prefix + "rqst_bl_tp_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setShprCntcPhnNo(JSPUtil.getParameter(request, prefix + "shpr_cntc_phn_no", ""));
		setActDt(JSPUtil.getParameter(request, prefix + "act_dt", ""));
		setPayrCustSeq(JSPUtil.getParameter(request, prefix + "payr_cust_seq", ""));
		setRqstToDt(JSPUtil.getParameter(request, prefix + "rqst_to_dt", ""));
		setPayrCustCd(JSPUtil.getParameter(request, prefix + "payr_cust_cd", ""));
		setBlAtch(JSPUtil.getParameter(request, prefix + "bl_atch", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setN3ptyPaySts(JSPUtil.getParameter(request, prefix + "n3pty_pay_sts", ""));
		setPolOfcCd(JSPUtil.getParameter(request, prefix + "pol_ofc_cd", ""));
		setSetSlctFlg(JSPUtil.getParameter(request, prefix + "set_slct_flg", ""));
		setSetQryWhere(JSPUtil.getParameter(request, prefix + "set_qry_where", ""));
		setChgFlg(JSPUtil.getParameter(request, prefix + "chg_flg", ""));
		setUsrEml(JSPUtil.getParameter(request, prefix + "usr_eml", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBkgUsrId(JSPUtil.getParameter(request, prefix + "bkg_usr_id", ""));
		setOldN3ptyBlStsCd(JSPUtil.getParameter(request, prefix + "old_n3pty_bl_sts_cd", ""));
		setN3ptyBlChgTtlAmt(JSPUtil.getParameter(request, prefix + "n3pty_bl_chg_ttl_amt", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setAccssOfcCd(JSPUtil.getParameter(request, prefix + "accss_ofc_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setBlIssOfcCd(JSPUtil.getParameter(request, prefix + "bl_iss_ofc_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPayrCustNm(JSPUtil.getParameter(request, prefix + "payr_cust_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return N3ptyBlRqstVO[]
	 */
	public N3ptyBlRqstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return N3ptyBlRqstVO[]
	 */
	public N3ptyBlRqstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		N3ptyBlRqstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] n3ptyBlStsCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bl_sts_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] blRmk = (JSPUtil.getParameter(request, prefix	+ "bl_rmk", length));
			String[] payrCustCntCd = (JSPUtil.getParameter(request, prefix	+ "payr_cust_cnt_cd", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] rqstFromDt = (JSPUtil.getParameter(request, prefix	+ "rqst_from_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] rqstBlTpCd = (JSPUtil.getParameter(request, prefix	+ "rqst_bl_tp_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] shprCntcPhnNo = (JSPUtil.getParameter(request, prefix	+ "shpr_cntc_phn_no", length));
			String[] actDt = (JSPUtil.getParameter(request, prefix	+ "act_dt", length));
			String[] payrCustSeq = (JSPUtil.getParameter(request, prefix	+ "payr_cust_seq", length));
			String[] rqstToDt = (JSPUtil.getParameter(request, prefix	+ "rqst_to_dt", length));
			String[] payrCustCd = (JSPUtil.getParameter(request, prefix	+ "payr_cust_cd", length));
			String[] blAtch = (JSPUtil.getParameter(request, prefix	+ "bl_atch", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] n3ptyPaySts = (JSPUtil.getParameter(request, prefix	+ "n3pty_pay_sts", length));
			String[] polOfcCd = (JSPUtil.getParameter(request, prefix	+ "pol_ofc_cd", length));
			String[] setSlctFlg = (JSPUtil.getParameter(request, prefix	+ "set_slct_flg", length));
			String[] setQryWhere = (JSPUtil.getParameter(request, prefix	+ "set_qry_where", length));
			String[] chgFlg = (JSPUtil.getParameter(request, prefix	+ "chg_flg", length));
			String[] usrEml = (JSPUtil.getParameter(request, prefix	+ "usr_eml", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] bkgUsrId = (JSPUtil.getParameter(request, prefix	+ "bkg_usr_id", length));
			String[] oldN3ptyBlStsCd = (JSPUtil.getParameter(request, prefix	+ "old_n3pty_bl_sts_cd", length));
			String[] n3ptyBlChgTtlAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bl_chg_ttl_amt", length));
			
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] blIssOfcCd = (JSPUtil.getParameter(request, prefix	+ "bl_iss_ofc_cd", length));
			String[] accssOfcCd = (JSPUtil.getParameter(request, prefix	+ "accss_ofc_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] payrCustNm = (JSPUtil.getParameter(request, prefix	+ "payr_cust_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new N3ptyBlRqstVO();
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (n3ptyBlStsCd[i] != null)
					model.setN3ptyBlStsCd(n3ptyBlStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (blRmk[i] != null)
					model.setBlRmk(blRmk[i]);
				if (payrCustCntCd[i] != null)
					model.setPayrCustCntCd(payrCustCntCd[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (rqstFromDt[i] != null)
					model.setRqstFromDt(rqstFromDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (rqstBlTpCd[i] != null)
					model.setRqstBlTpCd(rqstBlTpCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (shprCntcPhnNo[i] != null)
					model.setShprCntcPhnNo(shprCntcPhnNo[i]);
				if (actDt[i] != null)
					model.setActDt(actDt[i]);
				if (payrCustSeq[i] != null)
					model.setPayrCustSeq(payrCustSeq[i]);
				if (rqstToDt[i] != null)
					model.setRqstToDt(rqstToDt[i]);
				if (payrCustCd[i] != null)
					model.setPayrCustCd(payrCustCd[i]);
				if (blAtch[i] != null)
					model.setBlAtch(blAtch[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (n3ptyPaySts[i] != null)
					model.setN3ptyPaySts(n3ptyPaySts[i]);
				if (polOfcCd[i] != null)
					model.setPolOfcCd(polOfcCd[i]);
				if (setSlctFlg[i] != null)
					model.setSetSlctFlg(setSlctFlg[i]);
				if (setQryWhere[i] != null)
					model.setSetQryWhere(setQryWhere[i]);
				if (chgFlg[i] != null)
					model.setChgFlg(chgFlg[i]);
				if (oldN3ptyBlStsCd[i] != null)
					model.setOldN3ptyBlStsCd(oldN3ptyBlStsCd[i]);
				if (usrEml[i] != null)
					model.setUsrEml(usrEml[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (bkgUsrId[i] != null)
					model.setBkgUsrId(bkgUsrId[i]);
				if (n3ptyBlChgTtlAmt[i] != null)
					model.setN3ptyBlChgTtlAmt(n3ptyBlChgTtlAmt[i]);
				if (accssOfcCd[i] != null)
					model.setAccssOfcCd(accssOfcCd[i]);
				
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (blIssOfcCd[i] != null)
					model.setBlIssOfcCd(blIssOfcCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (payrCustNm[i] != null)
					model.setPayrCustNm(payrCustNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getN3ptyBlRqstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return N3ptyBlRqstVO[]
	 */
	public N3ptyBlRqstVO[] getN3ptyBlRqstVOs(){
		N3ptyBlRqstVO[] vos = (N3ptyBlRqstVO[])models.toArray(new N3ptyBlRqstVO[models.size()]);
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
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBlStsCd = this.n3ptyBlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRmk = this.blRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCustCntCd = this.payrCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFromDt = this.rqstFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstBlTpCd = this.rqstBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCntcPhnNo = this.shprCntcPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt = this.actDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCustSeq = this.payrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstToDt = this.rqstToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCustCd = this.payrCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blAtch = this.blAtch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyPaySts = this.n3ptyPaySts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polOfcCd = this.polOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.setSlctFlg = this.setSlctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.setQryWhere = this.setQryWhere .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFlg = this.chgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrEml = this.usrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUsrId = this.bkgUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldN3ptyBlStsCd = this.oldN3ptyBlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBlChgTtlAmt = this.n3ptyBlChgTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssOfcCd = this.blIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accssOfcCd = this.accssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payrCustNm = this.payrCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
