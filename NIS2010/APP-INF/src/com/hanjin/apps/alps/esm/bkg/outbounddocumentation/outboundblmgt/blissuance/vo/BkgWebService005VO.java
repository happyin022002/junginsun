/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BkgWebService005VO.java
*@FileTitle : BkgWebService005VO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.20
*@LastModifier : 김종호
*@LastVersion : 1.0
* 2011.10.20 김종호 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 김종호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgWebService005VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgWebService005VO> models = new ArrayList<BkgWebService005VO>();
	
	/* Column Info */
	private String result = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String rqstAtndNm = null;
	/* Column Info */
	private String blIssRmk = null;
	/* Column Info */
	private String blIssReqDt = null;
	/* Column Info */
	private String blRqstRmk = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String crrRemitAmt = null;
	/* Column Info */
	private String remitCoNm = null;
	/* Column Info */
	private String blIssUsrId = null;
	/* Column Info */
	private String actShprRgstNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rqstUsrEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taxInvRcvrCoNm = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rqstPhnNo = null;
	/* Column Info */
	private String crrRemitDt = null;
	/* Column Info */
	private String crrAcctCurrCd = null;
	/* Column Info */
	private String rqstRctLocCd = null;
	/* Column Info */
	private String taxInvRcvrRgstNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String blIssStsCd = null;
	/* Column Info */
	private String rqstCoNm = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String blIssRqstDt = null;
	/* Column Info */
	private String crrBankAcctNo = null;
	/* Column Info */
	private String rqstBlTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String remitKndCd = null;
	/* Column Info */
	private String crrBankCd = null;
	/* Column Info */
	private String taxInvRcvrPhnNo = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String actShprNm = null;
	/* Column Info */
	private String taxInvRcvrAtndNm = null;
	/* Column Info */
	private String crrUsaBankCd = null;	
	/* Column Info */
	private String crrUsaBankAcctNo = null;	
	/* Column Info */
	private String crrUsaRemitAmt = null;	
	/* Column Info */
	private String crrUsaRemitDt = null;	
	/* Column Info */
	private String crrUsaAcctCurrCd = null;	
	/* Column Info */
	private String blIssRqstCd = null;
	/* Column Info */
	private String blRcvTpCd = null;
	/* Column Info */
	private String mnlBlObrdDt = null;
	/* Column Info */
	private String mnlBlIssDt = null;
	/* Column Info */
	private String certiExistFlg = null;
	/* Column Info */
	private String frtDpFlg = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgWebService005VO() {}

	public BkgWebService005VO(String ibflag, String pagerows, String xterRqstNo, String xterRqstSeq, String blIssRqstDt, String rqstRctLocCd, String blNo, String vslCd, String skdVoyNo, String skdDirCd, String vslNm, String rqstBlTpCd, String rqstCoNm, String rqstUsrEml, String rqstAtndNm, String rqstPhnNo, String blRqstRmk, String actShprNm, String actShprRgstNo, String taxInvRcvrCoNm, String taxInvRcvrRgstNo, String taxInvRcvrAtndNm, String taxInvRcvrPhnNo, String remitCoNm, String remitKndCd, String crrBankCd, String crrBankAcctNo, String crrRemitAmt, String crrRemitDt, String blIssUsrId, String blIssStsCd, String blIssRmk, String deltFlg, String crrAcctCurrCd, String blIssReqDt, String creUsrId, String updUsrId, String result, String crrUsaBankCd, String crrUsaBankAcctNo, String crrUsaRemitAmt, String crrUsaRemitDt, String crrUsaAcctCurrCd, String blIssRqstCd, String blRcvTpCd, String mnlBlObrdDt, String mnlBlIssDt, String certiExistFlg, String frtDpFlg) {
		this.result = result;
		this.vslCd = vslCd;
		this.rqstAtndNm = rqstAtndNm;
		this.blIssRmk = blIssRmk;
		this.blIssReqDt = blIssReqDt;
		this.blRqstRmk = blRqstRmk;
		this.deltFlg = deltFlg;
		this.crrRemitAmt = crrRemitAmt;
		this.remitCoNm = remitCoNm;
		this.blIssUsrId = blIssUsrId;
		this.actShprRgstNo = actShprRgstNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.rqstUsrEml = rqstUsrEml;
		this.ibflag = ibflag;
		this.taxInvRcvrCoNm = taxInvRcvrCoNm;
		this.updUsrId = updUsrId;
		this.rqstPhnNo = rqstPhnNo;
		this.crrRemitDt = crrRemitDt;
		this.crrAcctCurrCd = crrAcctCurrCd;
		this.rqstRctLocCd = rqstRctLocCd;
		this.taxInvRcvrRgstNo = taxInvRcvrRgstNo;
		this.skdVoyNo = skdVoyNo;
		this.vslNm = vslNm;
		this.blIssStsCd = blIssStsCd;
		this.rqstCoNm = rqstCoNm;
		this.skdDirCd = skdDirCd;
		this.blIssRqstDt = blIssRqstDt;
		this.crrBankAcctNo = crrBankAcctNo;
		this.rqstBlTpCd = rqstBlTpCd;
		this.creUsrId = creUsrId;
		this.remitKndCd = remitKndCd;
		this.crrBankCd = crrBankCd;
		this.taxInvRcvrPhnNo = taxInvRcvrPhnNo;
		this.xterRqstSeq = xterRqstSeq;
		this.xterRqstNo = xterRqstNo;
		this.actShprNm = actShprNm;
		this.taxInvRcvrAtndNm = taxInvRcvrAtndNm;
		this.crrUsaBankCd = crrUsaBankCd;
		this.crrUsaBankAcctNo = crrUsaBankAcctNo;
		this.crrUsaRemitAmt = crrUsaRemitAmt;
		this.crrUsaRemitDt = crrUsaRemitDt;
		this.crrUsaAcctCurrCd = crrUsaAcctCurrCd;
		this.blIssRqstCd = blIssRqstCd;
		this.blRcvTpCd = blRcvTpCd;
		this.mnlBlObrdDt = mnlBlObrdDt;
		this.mnlBlIssDt = mnlBlIssDt;
		this.certiExistFlg = certiExistFlg;
		this.frtDpFlg = frtDpFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("result", getResult());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("rqst_atnd_nm", getRqstAtndNm());
		this.hashColumns.put("bl_iss_rmk", getBlIssRmk());
		this.hashColumns.put("bl_iss_req_dt", getBlIssReqDt());
		this.hashColumns.put("bl_rqst_rmk", getBlRqstRmk());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("crr_remit_amt", getCrrRemitAmt());
		this.hashColumns.put("remit_co_nm", getRemitCoNm());
		this.hashColumns.put("bl_iss_usr_id", getBlIssUsrId());
		this.hashColumns.put("act_shpr_rgst_no", getActShprRgstNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rqst_usr_eml", getRqstUsrEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tax_inv_rcvr_co_nm", getTaxInvRcvrCoNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rqst_phn_no", getRqstPhnNo());
		this.hashColumns.put("crr_remit_dt", getCrrRemitDt());
		this.hashColumns.put("crr_acct_curr_cd", getCrrAcctCurrCd());
		this.hashColumns.put("rqst_rct_loc_cd", getRqstRctLocCd());
		this.hashColumns.put("tax_inv_rcvr_rgst_no", getTaxInvRcvrRgstNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("bl_iss_sts_cd", getBlIssStsCd());
		this.hashColumns.put("rqst_co_nm", getRqstCoNm());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("bl_iss_rqst_dt", getBlIssRqstDt());
		this.hashColumns.put("crr_bank_acct_no", getCrrBankAcctNo());
		this.hashColumns.put("rqst_bl_tp_cd", getRqstBlTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("remit_knd_cd", getRemitKndCd());
		this.hashColumns.put("crr_bank_cd", getCrrBankCd());
		this.hashColumns.put("tax_inv_rcvr_phn_no", getTaxInvRcvrPhnNo());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("act_shpr_nm", getActShprNm());
		this.hashColumns.put("tax_inv_rcvr_atnd_nm", getTaxInvRcvrAtndNm());
		this.hashColumns.put("crr_usa_bank_cd", getCrrUsaBankCd());
		this.hashColumns.put("crr_usa_bank_acct_no", getCrrUsaBankAcctNo());
		this.hashColumns.put("crr_usa_remit_amt", getCrrUsaRemitAmt());
		this.hashColumns.put("crr_usa_remit_dt", getCrrUsaRemitDt());
		this.hashColumns.put("crr_usa_acct_curr_cd", getCrrUsaAcctCurrCd());
		this.hashColumns.put("bl_iss_rqst_cd", getBlIssRqstCd());
		this.hashColumns.put("bl_rcv_tp_cd", getBlRcvTpCd());
		this.hashColumns.put("mnl_bl_obrd_dt", getMnlBlObrdDt());
		this.hashColumns.put("mnl_bl_iss_dt", getMnlBlIssDt());
		this.hashColumns.put("certi_exist_flg", getCertiExistFlg());
		this.hashColumns.put("frt_dp_flg", getFrtDpFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("result", "result");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("rqst_atnd_nm", "rqstAtndNm");
		this.hashFields.put("bl_iss_rmk", "blIssRmk");
		this.hashFields.put("bl_iss_req_dt", "blIssReqDt");
		this.hashFields.put("bl_rqst_rmk", "blRqstRmk");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("crr_remit_amt", "crrRemitAmt");
		this.hashFields.put("remit_co_nm", "remitCoNm");
		this.hashFields.put("bl_iss_usr_id", "blIssUsrId");
		this.hashFields.put("act_shpr_rgst_no", "actShprRgstNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rqst_usr_eml", "rqstUsrEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tax_inv_rcvr_co_nm", "taxInvRcvrCoNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rqst_phn_no", "rqstPhnNo");
		this.hashFields.put("crr_remit_dt", "crrRemitDt");
		this.hashFields.put("crr_acct_curr_cd", "crrAcctCurrCd");
		this.hashFields.put("rqst_rct_loc_cd", "rqstRctLocCd");
		this.hashFields.put("tax_inv_rcvr_rgst_no", "taxInvRcvrRgstNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("bl_iss_sts_cd", "blIssStsCd");
		this.hashFields.put("rqst_co_nm", "rqstCoNm");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("bl_iss_rqst_dt", "blIssRqstDt");
		this.hashFields.put("crr_bank_acct_no", "crrBankAcctNo");
		this.hashFields.put("rqst_bl_tp_cd", "rqstBlTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("remit_knd_cd", "remitKndCd");
		this.hashFields.put("crr_bank_cd", "crrBankCd");
		this.hashFields.put("tax_inv_rcvr_phn_no", "taxInvRcvrPhnNo");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("act_shpr_nm", "actShprNm");
		this.hashFields.put("tax_inv_rcvr_atnd_nm", "taxInvRcvrAtndNm");
		this.hashFields.put("crr_usa_bank_cd", "crrUsaBankCd");
		this.hashFields.put("crr_usa_bank_acct_no", "crrUsaBankAcctNo");
		this.hashFields.put("crr_usa_remit_amt", "crrUsaRemitAmt");
		this.hashFields.put("crr_usa_remit_dt", "crrUsaRemitDt");
		this.hashFields.put("crr_usa_acct_curr_cd", "crrUsaAcctCurrCd");
		this.hashFields.put("bl_iss_rqst_cd", "blIssRqstCd");
		this.hashFields.put("bl_rcv_tp_cd", "blRcvTpCd");
		this.hashFields.put("mnl_bl_obrd_dt", "mnlBlObrdDt");
		this.hashFields.put("mnl_bl_iss_dt", "mnlBlIssDt");
		this.hashFields.put("certi_exist_flg", "certiExistFlg");
		this.hashFields.put("frt_dp_flg", "frtDpFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return result
	 */
	public String getResult() {
		return this.result;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return rqstAtndNm
	 */
	public String getRqstAtndNm() {
		return this.rqstAtndNm;
	}
	
	/**
	 * Column Info
	 * @return blIssRmk
	 */
	public String getBlIssRmk() {
		return this.blIssRmk;
	}
	
	/**
	 * Column Info
	 * @return blIssReqDt
	 */
	public String getBlIssReqDt() {
		return this.blIssReqDt;
	}
	
	/**
	 * Column Info
	 * @return blRqstRmk
	 */
	public String getBlRqstRmk() {
		return this.blRqstRmk;
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
	 * @return crrRemitAmt
	 */
	public String getCrrRemitAmt() {
		return this.crrRemitAmt;
	}
	
	/**
	 * Column Info
	 * @return remitCoNm
	 */
	public String getRemitCoNm() {
		return this.remitCoNm;
	}
	
	/**
	 * Column Info
	 * @return blIssUsrId
	 */
	public String getBlIssUsrId() {
		return this.blIssUsrId;
	}
	
	/**
	 * Column Info
	 * @return actShprRgstNo
	 */
	public String getActShprRgstNo() {
		return this.actShprRgstNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return rqstUsrEml
	 */
	public String getRqstUsrEml() {
		return this.rqstUsrEml;
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
	 * @return taxInvRcvrCoNm
	 */
	public String getTaxInvRcvrCoNm() {
		return this.taxInvRcvrCoNm;
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
	 * @return rqstPhnNo
	 */
	public String getRqstPhnNo() {
		return this.rqstPhnNo;
	}
	
	/**
	 * Column Info
	 * @return crrRemitDt
	 */
	public String getCrrRemitDt() {
		return this.crrRemitDt;
	}
	
	/**
	 * Column Info
	 * @return crrAcctCurrCd
	 */
	public String getCrrAcctCurrCd() {
		return this.crrAcctCurrCd;
	}
	
	/**
	 * Column Info
	 * @return rqstRctLocCd
	 */
	public String getRqstRctLocCd() {
		return this.rqstRctLocCd;
	}
	
	/**
	 * Column Info
	 * @return taxInvRcvrRgstNo
	 */
	public String getTaxInvRcvrRgstNo() {
		return this.taxInvRcvrRgstNo;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return blIssStsCd
	 */
	public String getBlIssStsCd() {
		return this.blIssStsCd;
	}
	
	/**
	 * Column Info
	 * @return rqstCoNm
	 */
	public String getRqstCoNm() {
		return this.rqstCoNm;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return blIssRqstDt
	 */
	public String getBlIssRqstDt() {
		return this.blIssRqstDt;
	}
	
	/**
	 * Column Info
	 * @return crrBankAcctNo
	 */
	public String getCrrBankAcctNo() {
		return this.crrBankAcctNo;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return remitKndCd
	 */
	public String getRemitKndCd() {
		return this.remitKndCd;
	}
	
	/**
	 * Column Info
	 * @return crrBankCd
	 */
	public String getCrrBankCd() {
		return this.crrBankCd;
	}
	
	/**
	 * Column Info
	 * @return taxInvRcvrPhnNo
	 */
	public String getTaxInvRcvrPhnNo() {
		return this.taxInvRcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @return actShprNm
	 */
	public String getActShprNm() {
		return this.actShprNm;
	}
	
	/**
	 * Column Info
	 * @return taxInvRcvrAtndNm
	 */
	public String getTaxInvRcvrAtndNm() {
		return this.taxInvRcvrAtndNm;
	}
	
	/**
	 * Column Info
	 * @return blIssRqstCd
	 */
	public String getBlIssRqstCd() {
		return this.blIssRqstCd;
	}
	
	
	/**
	 * Column Info
	 * @return blRcvTpCd
	 */
	public String getBlRcvTpCd() {
		return this.blRcvTpCd;
	}
	/**
	 * Column Info
	 * @return mnlBlObrdDt
	 */
	public String getMnlBlObrdDt() {
		return this.mnlBlObrdDt;
	}
	/**
	 * Column Info
	 * @return mnlBlIssDt
	 */
	public String getMnlBlIssDt() {
		return this.mnlBlIssDt;
	}
	/**
	 * Column Info
	 * @return certiExistFlg
	 */
	public String getCertiExistFlg() {
		return this.certiExistFlg;
	}
	/**
	 * Column Info
	 * @return frtDpFlg
	 */
	public String getFrtDpFlg() {
		return this.frtDpFlg;
	}
	

	/**
	 * Column Info
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param rqstAtndNm
	 */
	public void setRqstAtndNm(String rqstAtndNm) {
		this.rqstAtndNm = rqstAtndNm;
	}
	
	/**
	 * Column Info
	 * @param blIssRmk
	 */
	public void setBlIssRmk(String blIssRmk) {
		this.blIssRmk = blIssRmk;
	}
	
	/**
	 * Column Info
	 * @param blIssReqDt
	 */
	public void setBlIssReqDt(String blIssReqDt) {
		this.blIssReqDt = blIssReqDt;
	}
	
	/**
	 * Column Info
	 * @param blRqstRmk
	 */
	public void setBlRqstRmk(String blRqstRmk) {
		this.blRqstRmk = blRqstRmk;
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
	 * @param crrRemitAmt
	 */
	public void setCrrRemitAmt(String crrRemitAmt) {
		this.crrRemitAmt = crrRemitAmt;
	}
	
	/**
	 * Column Info
	 * @param remitCoNm
	 */
	public void setRemitCoNm(String remitCoNm) {
		this.remitCoNm = remitCoNm;
	}
	
	/**
	 * Column Info
	 * @param blIssUsrId
	 */
	public void setBlIssUsrId(String blIssUsrId) {
		this.blIssUsrId = blIssUsrId;
	}
	
	/**
	 * Column Info
	 * @param actShprRgstNo
	 */
	public void setActShprRgstNo(String actShprRgstNo) {
		this.actShprRgstNo = actShprRgstNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param rqstUsrEml
	 */
	public void setRqstUsrEml(String rqstUsrEml) {
		this.rqstUsrEml = rqstUsrEml;
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
	 * @param taxInvRcvrCoNm
	 */
	public void setTaxInvRcvrCoNm(String taxInvRcvrCoNm) {
		this.taxInvRcvrCoNm = taxInvRcvrCoNm;
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
	 * @param rqstPhnNo
	 */
	public void setRqstPhnNo(String rqstPhnNo) {
		this.rqstPhnNo = rqstPhnNo;
	}
	
	/**
	 * Column Info
	 * @param crrRemitDt
	 */
	public void setCrrRemitDt(String crrRemitDt) {
		this.crrRemitDt = crrRemitDt;
	}
	
	/**
	 * Column Info
	 * @param crrAcctCurrCd
	 */
	public void setCrrAcctCurrCd(String crrAcctCurrCd) {
		this.crrAcctCurrCd = crrAcctCurrCd;
	}
	
	/**
	 * Column Info
	 * @param rqstRctLocCd
	 */
	public void setRqstRctLocCd(String rqstRctLocCd) {
		this.rqstRctLocCd = rqstRctLocCd;
	}
	
	/**
	 * Column Info
	 * @param taxInvRcvrRgstNo
	 */
	public void setTaxInvRcvrRgstNo(String taxInvRcvrRgstNo) {
		this.taxInvRcvrRgstNo = taxInvRcvrRgstNo;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param blIssStsCd
	 */
	public void setBlIssStsCd(String blIssStsCd) {
		this.blIssStsCd = blIssStsCd;
	}
	
	/**
	 * Column Info
	 * @param rqstCoNm
	 */
	public void setRqstCoNm(String rqstCoNm) {
		this.rqstCoNm = rqstCoNm;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param blIssRqstDt
	 */
	public void setBlIssRqstDt(String blIssRqstDt) {
		this.blIssRqstDt = blIssRqstDt;
	}
	
	/**
	 * Column Info
	 * @param crrBankAcctNo
	 */
	public void setCrrBankAcctNo(String crrBankAcctNo) {
		this.crrBankAcctNo = crrBankAcctNo;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param remitKndCd
	 */
	public void setRemitKndCd(String remitKndCd) {
		this.remitKndCd = remitKndCd;
	}
	
	/**
	 * Column Info
	 * @param crrBankCd
	 */
	public void setCrrBankCd(String crrBankCd) {
		this.crrBankCd = crrBankCd;
	}
	
	/**
	 * Column Info
	 * @param taxInvRcvrPhnNo
	 */
	public void setTaxInvRcvrPhnNo(String taxInvRcvrPhnNo) {
		this.taxInvRcvrPhnNo = taxInvRcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * Column Info
	 * @param actShprNm
	 */
	public void setActShprNm(String actShprNm) {
		this.actShprNm = actShprNm;
	}
	
	/**
	 * Column Info
	 * @param taxInvRcvrAtndNm
	 */
	public void setTaxInvRcvrAtndNm(String taxInvRcvrAtndNm) {
		this.taxInvRcvrAtndNm = taxInvRcvrAtndNm;
	}
	
	/**	
	 * @return the crrUsaBankCd
	 */
	public String getCrrUsaBankCd() {
		return crrUsaBankCd;
	}

	/**
	 * @param crrUsaBankCd the crrUsaBankCd to set
	 */
	public void setCrrUsaBankCd(String crrUsaBankCd) {
		this.crrUsaBankCd = crrUsaBankCd;
	}

	/**
	 * @return the crrUsaBankAcctNo
	 */
	public String getCrrUsaBankAcctNo() {
		return crrUsaBankAcctNo;
	}

	/**
	 * @param crrUsaBankAcctNo the crrUsaBankAcctNo to set
	 */
	public void setCrrUsaBankAcctNo(String crrUsaBankAcctNo) {
		this.crrUsaBankAcctNo = crrUsaBankAcctNo;
	}

	/**
	 * @return the crrUsaRemitAmt
	 */
	public String getCrrUsaRemitAmt() {
		return crrUsaRemitAmt;
	}

	/**
	 * @param crrUsaRemitAmt the crrUsaRemitAmt to set
	 */
	public void setCrrUsaRemitAmt(String crrUsaRemitAmt) {
		this.crrUsaRemitAmt = crrUsaRemitAmt;
	}

	/**
	 * @return the crrUsaRemitDt
	 */
	public String getCrrUsaRemitDt() {
		return crrUsaRemitDt;
	}

	/**
	 * @param crrUsaRemitDt the crrUsaRemitDt to set
	 */
	public void setCrrUsaRemitDt(String crrUsaRemitDt) {
		this.crrUsaRemitDt = crrUsaRemitDt;
	}

	/**
	 * @return the crrUsaAcctCurrCd
	 */
	public String getCrrUsaAcctCurrCd() {
		return crrUsaAcctCurrCd;
	}

	/**
	 * @param crrUsaAcctCurrCd the crrUsaAcctCurrCd to set
	 */
	public void setCrrUsaAcctCurrCd(String crrUsaAcctCurrCd) {
		this.crrUsaAcctCurrCd = crrUsaAcctCurrCd;
	}
	
	/**
	 * @param blIssRqstCd the blIssRqstCd to set
	 */
	public void setBlIssRqstCd(String blIssRqstCd) {
		this.blIssRqstCd = blIssRqstCd;
	}
	
	/**
	 * @param blRcvTpCd the blRcvTpCd to set
	 */
	public void setBlRcvTpCd(String blRcvTpCd) {
		this.blRcvTpCd = blRcvTpCd;
	}
	/**
	 * @param mnlBlObrdDt the mnlBlObrdDt to set
	 */
	public void setMnlBlObrdDt(String mnlBlObrdDt) {
		this.mnlBlObrdDt = mnlBlObrdDt;
	}
	/**
	 * @param mnlBlIssDt the mnlBlIssDt to set
	 */
	public void setMnlBlIssDt(String mnlBlIssDt) {
		this.mnlBlIssDt = mnlBlIssDt;
	}
	/**
	 * @param certiExistFlg the certiExistFlg to set
	 */
	public void setCertiExistFlg(String certiExistFlg) {
		this.certiExistFlg = certiExistFlg;
	}
	/**
	 * @param frtDpFlg the frtDpFlg to set
	 */
	public void setFrtDpFlg(String frtDpFlg) {
		this.frtDpFlg = frtDpFlg;
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
		setResult(JSPUtil.getParameter(request, prefix + "result", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setRqstAtndNm(JSPUtil.getParameter(request, prefix + "rqst_atnd_nm", ""));
		setBlIssRmk(JSPUtil.getParameter(request, prefix + "bl_iss_rmk", ""));
		setBlIssReqDt(JSPUtil.getParameter(request, prefix + "bl_iss_req_dt", ""));
		setBlRqstRmk(JSPUtil.getParameter(request, prefix + "bl_rqst_rmk", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setCrrRemitAmt(JSPUtil.getParameter(request, prefix + "crr_remit_amt", ""));
		setRemitCoNm(JSPUtil.getParameter(request, prefix + "remit_co_nm", ""));
		setBlIssUsrId(JSPUtil.getParameter(request, prefix + "bl_iss_usr_id", ""));
		setActShprRgstNo(JSPUtil.getParameter(request, prefix + "act_shpr_rgst_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRqstUsrEml(JSPUtil.getParameter(request, prefix + "rqst_usr_eml", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTaxInvRcvrCoNm(JSPUtil.getParameter(request, prefix + "tax_inv_rcvr_co_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRqstPhnNo(JSPUtil.getParameter(request, prefix + "rqst_phn_no", ""));
		setCrrRemitDt(JSPUtil.getParameter(request, prefix + "crr_remit_dt", ""));
		setCrrAcctCurrCd(JSPUtil.getParameter(request, prefix + "crr_acct_curr_cd", ""));
		setRqstRctLocCd(JSPUtil.getParameter(request, prefix + "rqst_rct_loc_cd", ""));
		setTaxInvRcvrRgstNo(JSPUtil.getParameter(request, prefix + "tax_inv_rcvr_rgst_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setBlIssStsCd(JSPUtil.getParameter(request, prefix + "bl_iss_sts_cd", ""));
		setRqstCoNm(JSPUtil.getParameter(request, prefix + "rqst_co_nm", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setBlIssRqstDt(JSPUtil.getParameter(request, prefix + "bl_iss_rqst_dt", ""));
		setCrrBankAcctNo(JSPUtil.getParameter(request, prefix + "crr_bank_acct_no", ""));
		setRqstBlTpCd(JSPUtil.getParameter(request, prefix + "rqst_bl_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRemitKndCd(JSPUtil.getParameter(request, prefix + "remit_knd_cd", ""));
		setCrrBankCd(JSPUtil.getParameter(request, prefix + "crr_bank_cd", ""));
		setTaxInvRcvrPhnNo(JSPUtil.getParameter(request, prefix + "tax_inv_rcvr_phn_no", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setActShprNm(JSPUtil.getParameter(request, prefix + "act_shpr_nm", ""));
		setTaxInvRcvrAtndNm(JSPUtil.getParameter(request, prefix + "tax_inv_rcvr_atnd_nm", ""));
		setCrrUsaBankCd(JSPUtil.getParameter(request, prefix + "crr_usa_bank_cd", ""));
		setCrrUsaBankAcctNo(JSPUtil.getParameter(request, prefix + "crr_usa_bank_acct_no", ""));
		setCrrUsaRemitAmt(JSPUtil.getParameter(request, prefix + "crr_usa_remit_amt", ""));
		setCrrUsaRemitDt(JSPUtil.getParameter(request, prefix + "crr_usa_remit_dt", ""));
		setCrrUsaAcctCurrCd(JSPUtil.getParameter(request, prefix + "crr_usa_acct_curr_cd", ""));
		setBlIssRqstCd(JSPUtil.getParameter(request, prefix + "bl_Iss_rqst_cd", ""));
		setBlRcvTpCd(JSPUtil.getParameter(request, prefix + "bl_rcv_tp_cd", ""));
		setMnlBlObrdDt(JSPUtil.getParameter(request, prefix + "mnl_bl_obrd_dt", ""));
		setMnlBlIssDt(JSPUtil.getParameter(request, prefix + "mnl_bl_iss_dt", ""));
		setCertiExistFlg(JSPUtil.getParameter(request, prefix + "certi_exist_flg", ""));
		setFrtDpFlg(JSPUtil.getParameter(request, prefix + "frt_dp_flg", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgWebService005VO[]
	 */
	public BkgWebService005VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgWebService005VO[]
	 */
	public BkgWebService005VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgWebService005VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] result = (JSPUtil.getParameter(request, prefix	+ "result", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] rqstAtndNm = (JSPUtil.getParameter(request, prefix	+ "rqst_atnd_nm", length));
			String[] blIssRmk = (JSPUtil.getParameter(request, prefix	+ "bl_iss_rmk", length));
			String[] blIssReqDt = (JSPUtil.getParameter(request, prefix	+ "bl_iss_req_dt", length));
			String[] blRqstRmk = (JSPUtil.getParameter(request, prefix	+ "bl_rqst_rmk", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] crrRemitAmt = (JSPUtil.getParameter(request, prefix	+ "crr_remit_amt", length));
			String[] remitCoNm = (JSPUtil.getParameter(request, prefix	+ "remit_co_nm", length));
			String[] blIssUsrId = (JSPUtil.getParameter(request, prefix	+ "bl_iss_usr_id", length));
			String[] actShprRgstNo = (JSPUtil.getParameter(request, prefix	+ "act_shpr_rgst_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rqstUsrEml = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taxInvRcvrCoNm = (JSPUtil.getParameter(request, prefix	+ "tax_inv_rcvr_co_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rqstPhnNo = (JSPUtil.getParameter(request, prefix	+ "rqst_phn_no", length));
			String[] crrRemitDt = (JSPUtil.getParameter(request, prefix	+ "crr_remit_dt", length));
			String[] crrAcctCurrCd = (JSPUtil.getParameter(request, prefix	+ "crr_acct_curr_cd", length));
			String[] rqstRctLocCd = (JSPUtil.getParameter(request, prefix	+ "rqst_rct_loc_cd", length));
			String[] taxInvRcvrRgstNo = (JSPUtil.getParameter(request, prefix	+ "tax_inv_rcvr_rgst_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] blIssStsCd = (JSPUtil.getParameter(request, prefix	+ "bl_iss_sts_cd", length));
			String[] rqstCoNm = (JSPUtil.getParameter(request, prefix	+ "rqst_co_nm", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] blIssRqstDt = (JSPUtil.getParameter(request, prefix	+ "bl_iss_rqst_dt", length));
			String[] crrBankAcctNo = (JSPUtil.getParameter(request, prefix	+ "crr_bank_acct_no", length));
			String[] rqstBlTpCd = (JSPUtil.getParameter(request, prefix	+ "rqst_bl_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] remitKndCd = (JSPUtil.getParameter(request, prefix	+ "remit_knd_cd", length));
			String[] crrBankCd = (JSPUtil.getParameter(request, prefix	+ "crr_bank_cd", length));
			String[] taxInvRcvrPhnNo = (JSPUtil.getParameter(request, prefix	+ "tax_inv_rcvr_phn_no", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] actShprNm = (JSPUtil.getParameter(request, prefix	+ "act_shpr_nm", length));
			String[] taxInvRcvrAtndNm = (JSPUtil.getParameter(request, prefix	+ "tax_inv_rcvr_atnd_nm", length));
			String[] crrUsaBankCd = (JSPUtil.getParameter(request, prefix + "crr_usa_bank_cd", length));
			String[] crrUsaBankAcctNo = (JSPUtil.getParameter(request, prefix + "crr_usa_bank_acct_no", length));
			String[] crrUsaRemitAmt = (JSPUtil.getParameter(request, prefix + "crr_usa_remit_amt", length));
			String[] crrUsaRemitDt = (JSPUtil.getParameter(request, prefix + "crr_usa_remit_dt", length));
			String[] crrUsaAcctCurrCd = (JSPUtil.getParameter(request, prefix + "crr_usa_acct_curr_cd", length));
			String[] blIssRqstCd = (JSPUtil.getParameter(request, prefix + "bl_Iss_rqst_cd", length));
			String[] blRcvTpCd = (JSPUtil.getParameter(request, prefix + "bl_rcv_tp_cd", length));
			String[] mnlBlObrdDt = (JSPUtil.getParameter(request, prefix + "mnl_bl_obrd_dt", length));
			String[] mnlBlIssDt = (JSPUtil.getParameter(request, prefix + "mnl_bl_iss_dt", length));
			String[] certiExistFlg = (JSPUtil.getParameter(request, prefix + "certi_exist_flg", length));
			String[] frtDpFlg = (JSPUtil.getParameter(request, prefix + "frt_dp_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgWebService005VO();
				if (result[i] != null)
					model.setResult(result[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (rqstAtndNm[i] != null)
					model.setRqstAtndNm(rqstAtndNm[i]);
				if (blIssRmk[i] != null)
					model.setBlIssRmk(blIssRmk[i]);
				if (blIssReqDt[i] != null)
					model.setBlIssReqDt(blIssReqDt[i]);
				if (blRqstRmk[i] != null)
					model.setBlRqstRmk(blRqstRmk[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (crrRemitAmt[i] != null)
					model.setCrrRemitAmt(crrRemitAmt[i]);
				if (remitCoNm[i] != null)
					model.setRemitCoNm(remitCoNm[i]);
				if (blIssUsrId[i] != null)
					model.setBlIssUsrId(blIssUsrId[i]);
				if (actShprRgstNo[i] != null)
					model.setActShprRgstNo(actShprRgstNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rqstUsrEml[i] != null)
					model.setRqstUsrEml(rqstUsrEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taxInvRcvrCoNm[i] != null)
					model.setTaxInvRcvrCoNm(taxInvRcvrCoNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rqstPhnNo[i] != null)
					model.setRqstPhnNo(rqstPhnNo[i]);
				if (crrRemitDt[i] != null)
					model.setCrrRemitDt(crrRemitDt[i]);
				if (crrAcctCurrCd[i] != null)
					model.setCrrAcctCurrCd(crrAcctCurrCd[i]);
				if (rqstRctLocCd[i] != null)
					model.setRqstRctLocCd(rqstRctLocCd[i]);
				if (taxInvRcvrRgstNo[i] != null)
					model.setTaxInvRcvrRgstNo(taxInvRcvrRgstNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (blIssStsCd[i] != null)
					model.setBlIssStsCd(blIssStsCd[i]);
				if (rqstCoNm[i] != null)
					model.setRqstCoNm(rqstCoNm[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (blIssRqstDt[i] != null)
					model.setBlIssRqstDt(blIssRqstDt[i]);
				if (crrBankAcctNo[i] != null)
					model.setCrrBankAcctNo(crrBankAcctNo[i]);
				if (rqstBlTpCd[i] != null)
					model.setRqstBlTpCd(rqstBlTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (remitKndCd[i] != null)
					model.setRemitKndCd(remitKndCd[i]);
				if (crrBankCd[i] != null)
					model.setCrrBankCd(crrBankCd[i]);
				if (taxInvRcvrPhnNo[i] != null)
					model.setTaxInvRcvrPhnNo(taxInvRcvrPhnNo[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (actShprNm[i] != null)
					model.setActShprNm(actShprNm[i]);
				if (taxInvRcvrAtndNm[i] != null)
					model.setTaxInvRcvrAtndNm(taxInvRcvrAtndNm[i]);
				if (crrUsaBankCd[i] != null)
					model.setCrrUsaBankCd(crrUsaBankCd[i]);
				if (crrUsaBankAcctNo[i] != null)
					model.setCrrUsaBankAcctNo(crrUsaBankAcctNo[i]);
				if (crrUsaRemitAmt[i] != null)
					model.setCrrUsaRemitAmt(crrUsaRemitAmt[i]);
				if (crrUsaRemitDt[i] != null)
					model.setCrrUsaRemitDt(crrUsaRemitDt[i]);
				if (crrUsaAcctCurrCd[i] != null)
					model.setCrrUsaAcctCurrCd(crrUsaAcctCurrCd[i]);
				if (blIssRqstCd[i] != null)
					model.setBlIssRqstCd(blIssRqstCd[i]);				
				if (blRcvTpCd[i] != null)
					model.setBlRcvTpCd(blRcvTpCd[i]);
				if (mnlBlObrdDt[i] != null)
					model.setMnlBlObrdDt(mnlBlObrdDt[i]);
				if (mnlBlIssDt[i] != null)
					model.setMnlBlIssDt(mnlBlIssDt[i]);
				if (certiExistFlg[i] != null)
					model.setCertiExistFlg(certiExistFlg[i]);
				if (frtDpFlg[i] != null)
					model.setFrtDpFlg(frtDpFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgWebService005VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgWebService005VO[]
	 */
	public BkgWebService005VO[] getBkgWebService005VOs(){
		BkgWebService005VO[] vos = (BkgWebService005VO[])models.toArray(new BkgWebService005VO[models.size()]);
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
		this.result = this.result .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAtndNm = this.rqstAtndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssRmk = this.blIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssReqDt = this.blIssReqDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRqstRmk = this.blRqstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrRemitAmt = this.crrRemitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remitCoNm = this.remitCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssUsrId = this.blIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprRgstNo = this.actShprRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrEml = this.rqstUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvRcvrCoNm = this.taxInvRcvrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstPhnNo = this.rqstPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrRemitDt = this.crrRemitDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrAcctCurrCd = this.crrAcctCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRctLocCd = this.rqstRctLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvRcvrRgstNo = this.taxInvRcvrRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssStsCd = this.blIssStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstCoNm = this.rqstCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssRqstDt = this.blIssRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBankAcctNo = this.crrBankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstBlTpCd = this.rqstBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remitKndCd = this.remitKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBankCd = this.crrBankCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvRcvrPhnNo = this.taxInvRcvrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprNm = this.actShprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvRcvrAtndNm = this.taxInvRcvrAtndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrUsaBankCd = this.crrUsaBankCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrUsaBankAcctNo = this.crrUsaBankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrUsaRemitAmt = this.crrUsaRemitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrUsaRemitDt = this.crrUsaRemitDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrUsaAcctCurrCd = this.crrUsaAcctCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssRqstCd = this.blIssRqstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRcvTpCd = this.blRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlBlObrdDt = this.mnlBlObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlBlIssDt = this.mnlBlIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiExistFlg = this.certiExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtDpFlg = this.frtDpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
