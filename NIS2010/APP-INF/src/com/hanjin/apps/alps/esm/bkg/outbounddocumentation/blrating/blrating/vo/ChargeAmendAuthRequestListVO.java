/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeAmendAuthRequestListVO.java
*@FileTitle : ChargeAmendAuthRequestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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

public class ChargeAmendAuthRequestListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeAmendAuthRequestListVO> models = new ArrayList<ChargeAmendAuthRequestListVO>();
	
	/* Column Info */
	private String mailTitle = null;
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String authFlg = null;
	/* Column Info */
	private String obSrep = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String chgAmdRmk = null;
	/* Column Info */
	private String chgCd = null;
	/* Column Info */
	private String rqstUsrEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chgAmdRqstStsCd = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String crntChgAmt = null;
	/* Column Info */
	private String amdChgAmt = null;
	/* Column Info */
	private String diffChgAmt = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String aproRqstRefUsrId = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String mailBody = null;
	/* Column Info */
	private String ctrtPtyNm = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chgAmdRsnCd = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String chgAmdSeq = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String inBkgNo = null;
	/* Column Info */
	private String ctrtSrep = null;
	/* Column Info */
	private String aproRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChargeAmendAuthRequestListVO() {}

	public ChargeAmendAuthRequestListVO(String ibflag, String pagerows, String bkgNo, String seq, String chgAmdSeq, String shprCd, String shprNm, String cneeCd, String cneeNm, String bkgCtrtTpCd, String ctrtNo, String ctrtPtyNm, String ctrtSrep, String obSrep, String chgAmdRsnCd, String chgAmdRmk, String chgCd, String currCd, String ratUtCd, String crntChgAmt, String amdChgAmt, String diffChgAmt, String rqstUsrId, String chgAmdRqstStsCd, String rqstOfcCd, String rqstUsrNm, String rqstUsrEml, String rqstDt, String aproUsrId, String aproOfcCd, String aproUsrNm, String aproDt, String authFlg, String fmDt, String toDt, String inBkgNo, String aproRqstRefUsrId, String mailBody, String mailTitle, String aproRmk) {
		this.mailTitle = mailTitle;
		this.cneeCd = cneeCd;
		this.authFlg = authFlg;
		this.obSrep = obSrep;
		this.rqstUsrId = rqstUsrId;
		this.currCd = currCd;
		this.aproUsrNm = aproUsrNm;
		this.aproOfcCd = aproOfcCd;
		this.chgAmdRmk = chgAmdRmk;
		this.chgCd = chgCd;
		this.rqstUsrEml = rqstUsrEml;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.ibflag = ibflag;
		this.chgAmdRqstStsCd = chgAmdRqstStsCd;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.shprNm = shprNm;
		this.shprCd = shprCd;
		this.rqstDt = rqstDt;
		this.crntChgAmt = crntChgAmt;
		this.amdChgAmt = amdChgAmt;
		this.diffChgAmt = diffChgAmt;
		this.fmDt = fmDt;
		this.rqstUsrNm = rqstUsrNm;
		this.aproRqstRefUsrId = aproRqstRefUsrId;
		this.ratUtCd = ratUtCd;
		this.aproDt = aproDt;
		this.toDt = toDt;
		this.mailBody = mailBody;
		this.ctrtPtyNm = ctrtPtyNm;
		this.cneeNm = cneeNm;
		this.bkgNo = bkgNo;
		this.chgAmdRsnCd = chgAmdRsnCd;
		this.aproUsrId = aproUsrId;
		this.chgAmdSeq = chgAmdSeq;
		this.rqstOfcCd = rqstOfcCd;
		this.seq = seq;
		this.inBkgNo = inBkgNo;
		this.ctrtSrep = ctrtSrep;
		this.aproRmk = aproRmk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mail_title", getMailTitle());
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("auth_flg", getAuthFlg());
		this.hashColumns.put("ob_srep", getObSrep());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("chg_amd_rmk", getChgAmdRmk());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("rqst_usr_eml", getRqstUsrEml());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chg_amd_rqst_sts_cd", getChgAmdRqstStsCd());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("crnt_chg_amt", getCrntChgAmt());
		this.hashColumns.put("amd_chg_amt", getAmdChgAmt());
		this.hashColumns.put("diff_chg_amt", getDiffChgAmt());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("apro_rqst_ref_usr_id", getAproRqstRefUsrId());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("mail_body", getMailBody());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chg_amd_rsn_cd", getChgAmdRsnCd());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("chg_amd_seq", getChgAmdSeq());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("in_bkg_no", getInBkgNo());
		this.hashColumns.put("ctrt_srep", getCtrtSrep());
		this.hashColumns.put("apro_rmk", getAproRmk());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mail_title", "mailTitle");
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("auth_flg", "authFlg");
		this.hashFields.put("ob_srep", "obSrep");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("chg_amd_rmk", "chgAmdRmk");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("rqst_usr_eml", "rqstUsrEml");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chg_amd_rqst_sts_cd", "chgAmdRqstStsCd");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("crnt_chg_amt", "crntChgAmt");
		this.hashFields.put("amd_chg_amt", "amdChgAmt");
		this.hashFields.put("diff_chg_amt", "diffChgAmt");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("apro_rqst_ref_usr_id", "aproRqstRefUsrId");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("mail_body", "mailBody");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chg_amd_rsn_cd", "chgAmdRsnCd");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("chg_amd_seq", "chgAmdSeq");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("in_bkg_no", "inBkgNo");
		this.hashFields.put("ctrt_srep", "ctrtSrep");
		this.hashFields.put("apro_rmk", "aproRmk");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mailTitle
	 */
	public String getMailTitle() {
		return this.mailTitle;
	}
	
	/**
	 * Column Info
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}
	
	/**
	 * Column Info
	 * @return authFlg
	 */
	public String getAuthFlg() {
		return this.authFlg;
	}
	
	/**
	 * Column Info
	 * @return obSrep
	 */
	public String getObSrep() {
		return this.obSrep;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
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
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chgAmdRmk
	 */
	public String getChgAmdRmk() {
		return this.chgAmdRmk;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrEml
	 */
	public String getRqstUsrEml() {
		return this.rqstUsrEml;
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
	 * @return chgAmdRqstStsCd
	 */
	public String getChgAmdRqstStsCd() {
		return this.chgAmdRqstStsCd;
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
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
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
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return crntChgAmt
	 */
	public String getCrntChgAmt() {
		return this.crntChgAmt;
	}
	
	/**
	 * Column Info
	 * @return amdChgAmt
	 */
	public String getAmdChgAmt() {
		return this.amdChgAmt;
	}
	
	/**
	 * Column Info
	 * @return diffChgAmt
	 */
	public String getDiffChgAmt() {
		return this.diffChgAmt;
	}
	
	/**
	 * Column Info
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return aproRqstRefUsrId
	 */
	public String getAproRqstRefUsrId() {
		return this.aproRqstRefUsrId;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return mailBody
	 */
	public String getMailBody() {
		return this.mailBody;
	}
	
	/**
	 * Column Info
	 * @return ctrtPtyNm
	 */
	public String getCtrtPtyNm() {
		return this.ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
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
	 * @return chgAmdRsnCd
	 */
	public String getChgAmdRsnCd() {
		return this.chgAmdRsnCd;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return chgAmdSeq
	 */
	public String getChgAmdSeq() {
		return this.chgAmdSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
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
	 * @return inBkgNo
	 */
	public String getInBkgNo() {
		return this.inBkgNo;
	}
	
	/**
	 * Column Info
	 * @return ctrtSrep
	 */
	public String getCtrtSrep() {
		return this.ctrtSrep;
	}
	
	
	/**
	 * Column Info
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}
	
	/**
	 * Column Info
	 * @param mailTitle
	 */
	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
	
	/**
	 * Column Info
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
	}
	
	/**
	 * Column Info
	 * @param authFlg
	 */
	public void setAuthFlg(String authFlg) {
		this.authFlg = authFlg;
	}
	
	/**
	 * Column Info
	 * @param obSrep
	 */
	public void setObSrep(String obSrep) {
		this.obSrep = obSrep;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
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
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chgAmdRmk
	 */
	public void setChgAmdRmk(String chgAmdRmk) {
		this.chgAmdRmk = chgAmdRmk;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrEml
	 */
	public void setRqstUsrEml(String rqstUsrEml) {
		this.rqstUsrEml = rqstUsrEml;
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
	 * @param chgAmdRqstStsCd
	 */
	public void setChgAmdRqstStsCd(String chgAmdRqstStsCd) {
		this.chgAmdRqstStsCd = chgAmdRqstStsCd;
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
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param crntChgAmt
	 */
	public void setCrntChgAmt(String crntChgAmt) {
		this.crntChgAmt = crntChgAmt;
	}
	
	/**
	 * Column Info
	 * @param amdChgAmt
	 */
	public void setAmdChgAmt(String amdChgAmt) {
		this.amdChgAmt = amdChgAmt;
	}
	
	/**
	 * Column Info
	 * @param diffChgAmt
	 */
	public void setDiffChgAmt(String diffChgAmt) {
		this.diffChgAmt = diffChgAmt;
	}
	
	/**
	 * Column Info
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param aproRqstRefUsrId
	 */
	public void setAproRqstRefUsrId(String aproRqstRefUsrId) {
		this.aproRqstRefUsrId = aproRqstRefUsrId;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param mailBody
	 */
	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}
	
	/**
	 * Column Info
	 * @param ctrtPtyNm
	 */
	public void setCtrtPtyNm(String ctrtPtyNm) {
		this.ctrtPtyNm = ctrtPtyNm;
	}
	
	/**
	 * Column Info
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
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
	 * @param chgAmdRsnCd
	 */
	public void setChgAmdRsnCd(String chgAmdRsnCd) {
		this.chgAmdRsnCd = chgAmdRsnCd;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param chgAmdSeq
	 */
	public void setChgAmdSeq(String chgAmdSeq) {
		this.chgAmdSeq = chgAmdSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param inBkgNo
	 */
	public void setInBkgNo(String inBkgNo) {
		this.inBkgNo = inBkgNo;
	}
	
	/**
	 * Column Info
	 * @param ctrtSrep
	 */
	public void setCtrtSrep(String ctrtSrep) {
		this.ctrtSrep = ctrtSrep;
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
		setMailTitle(JSPUtil.getParameter(request, prefix + "mail_title", ""));
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setAuthFlg(JSPUtil.getParameter(request, prefix + "auth_flg", ""));
		setObSrep(JSPUtil.getParameter(request, prefix + "ob_srep", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setAproOfcCd(JSPUtil.getParameter(request, prefix + "apro_ofc_cd", ""));
		setChgAmdRmk(JSPUtil.getParameter(request, prefix + "chg_amd_rmk", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setRqstUsrEml(JSPUtil.getParameter(request, prefix + "rqst_usr_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChgAmdRqstStsCd(JSPUtil.getParameter(request, prefix + "chg_amd_rqst_sts_cd", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setShprCd(JSPUtil.getParameter(request, prefix + "shpr_cd", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setCrntChgAmt(JSPUtil.getParameter(request, prefix + "crnt_chg_amt", ""));
		setAmdChgAmt(JSPUtil.getParameter(request, prefix + "amd_chg_amt", ""));
		setDiffChgAmt(JSPUtil.getParameter(request, prefix + "diff_chg_amt", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setAproRqstRefUsrId(JSPUtil.getParameter(request, prefix + "apro_rqst_ref_usr_id", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setMailBody(JSPUtil.getParameter(request, prefix + "mail_body", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request, prefix + "ctrt_pty_nm", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChgAmdRsnCd(JSPUtil.getParameter(request, prefix + "chg_amd_rsn_cd", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setChgAmdSeq(JSPUtil.getParameter(request, prefix + "chg_amd_seq", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setInBkgNo(JSPUtil.getParameter(request, prefix + "in_bkg_no", ""));
		setCtrtSrep(JSPUtil.getParameter(request, prefix + "ctrt_srep", ""));
		setAproRmk(JSPUtil.getParameter(request, prefix + "apro_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeAmendAuthRequestListVO[]
	 */
	public ChargeAmendAuthRequestListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeAmendAuthRequestListVO[]
	 */
	public ChargeAmendAuthRequestListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeAmendAuthRequestListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mailTitle = (JSPUtil.getParameter(request, prefix	+ "mail_title", length));
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] authFlg = (JSPUtil.getParameter(request, prefix	+ "auth_flg", length));
			String[] obSrep = (JSPUtil.getParameter(request, prefix	+ "ob_srep", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] chgAmdRmk = (JSPUtil.getParameter(request, prefix	+ "chg_amd_rmk", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] rqstUsrEml = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chgAmdRqstStsCd = (JSPUtil.getParameter(request, prefix	+ "chg_amd_rqst_sts_cd", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] crntChgAmt = (JSPUtil.getParameter(request, prefix	+ "crnt_chg_amt", length));
			String[] amdChgAmt = (JSPUtil.getParameter(request, prefix	+ "amd_chg_amt", length));
			String[] diffChgAmt = (JSPUtil.getParameter(request, prefix	+ "diff_chg_amt", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] aproRqstRefUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_ref_usr_id", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] mailBody = (JSPUtil.getParameter(request, prefix	+ "mail_body", length));
			String[] ctrtPtyNm = (JSPUtil.getParameter(request, prefix	+ "ctrt_pty_nm", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chgAmdRsnCd = (JSPUtil.getParameter(request, prefix	+ "chg_amd_rsn_cd", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] chgAmdSeq = (JSPUtil.getParameter(request, prefix	+ "chg_amd_seq", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] inBkgNo = (JSPUtil.getParameter(request, prefix	+ "in_bkg_no", length));
			String[] ctrtSrep = (JSPUtil.getParameter(request, prefix	+ "ctrt_srep", length));
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeAmendAuthRequestListVO();
				if (mailTitle[i] != null)
					model.setMailTitle(mailTitle[i]);
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (authFlg[i] != null)
					model.setAuthFlg(authFlg[i]);
				if (obSrep[i] != null)
					model.setObSrep(obSrep[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (chgAmdRmk[i] != null)
					model.setChgAmdRmk(chgAmdRmk[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (rqstUsrEml[i] != null)
					model.setRqstUsrEml(rqstUsrEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chgAmdRqstStsCd[i] != null)
					model.setChgAmdRqstStsCd(chgAmdRqstStsCd[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (crntChgAmt[i] != null)
					model.setCrntChgAmt(crntChgAmt[i]);
				if (amdChgAmt[i] != null)
					model.setAmdChgAmt(amdChgAmt[i]);
				if (diffChgAmt[i] != null)
					model.setDiffChgAmt(diffChgAmt[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (aproRqstRefUsrId[i] != null)
					model.setAproRqstRefUsrId(aproRqstRefUsrId[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (mailBody[i] != null)
					model.setMailBody(mailBody[i]);
				if (ctrtPtyNm[i] != null)
					model.setCtrtPtyNm(ctrtPtyNm[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chgAmdRsnCd[i] != null)
					model.setChgAmdRsnCd(chgAmdRsnCd[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (chgAmdSeq[i] != null)
					model.setChgAmdSeq(chgAmdSeq[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (inBkgNo[i] != null)
					model.setInBkgNo(inBkgNo[i]);
				if (ctrtSrep[i] != null)
					model.setCtrtSrep(ctrtSrep[i]);
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeAmendAuthRequestListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeAmendAuthRequestListVO[]
	 */
	public ChargeAmendAuthRequestListVO[] getChargeAmendAuthRequestListVOs(){
		ChargeAmendAuthRequestListVO[] vos = (ChargeAmendAuthRequestListVO[])models.toArray(new ChargeAmendAuthRequestListVO[models.size()]);
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
		this.mailTitle = this.mailTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authFlg = this.authFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrep = this.obSrep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdRmk = this.chgAmdRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrEml = this.rqstUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdRqstStsCd = this.chgAmdRqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntChgAmt = this.crntChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdChgAmt = this.amdChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffChgAmt = this.diffChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstRefUsrId = this.aproRqstRefUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mailBody = this.mailBody .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm = this.ctrtPtyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdRsnCd = this.chgAmdRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmdSeq = this.chgAmdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inBkgNo = this.inBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtSrep = this.ctrtSrep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
