/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BlIssRqstVO.java
*@FileTitle : BlIssRqstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.12.13
*@LastModifier : 
*@LastVersion : 1.0
* 2011.12.13  
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BlIssRqstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlIssRqstVO> models = new ArrayList<BlIssRqstVO>();
	
	/* Column Info */
	private String blObrdDt = null;
	/* Column Info */
	private String blIssActDt = null;
	/* Column Info */
	private String blIssReqDt = null;
	/* Column Info */
	private String blRqstRmk = null;
	/* Column Info */
	private String rqstCoName = null;
	/* Column Info */
	private String crrRemitAmt = null;
	/* Column Info */
	private String actShprRgstNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blIssueActualDt = null;
	/* Column Info */
	private String blIssDt = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String taxInvRcvrCoName = null;
	/* Column Info */
	private String biiVslNm = null;
	/* Column Info */
	private String deltId = null;
	/* Column Info */
	private String taxInvRcvrCoNm = null;
	/* Column Info */
	private String rqstPhnNo = null;
	/* Column Info */
	private String crrAcctCurrCd = null;
	/* Column Info */
	private String rqstRctLocCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String vesselName = null;
	/* Column Info */
	private String remitCoName = null;
	/* Column Info */
	private String crrAcctCurrCode = null;
	/* Column Info */
	private String locNm = null;
	/* Column Info */
	private String rqstCoNm = null;
	/* Column Info */
	private String blIssRqstDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String rqstBlTpCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String rqstToDt = null;
	/* Column Info */
	private String actShprNm = null;
	/* Column Info */
	private String crrBankNm = null;
	/* Column Info */
	private String rqstAtndNm = null;
	/* Column Info */
	private String shprName = null;
	/* Column Info */
	private String blIssRmk = null;
	/* Column Info */
	private String remitCoNm = null;
	/* Column Info */
	private String blIssRjctDt = null;
	/* Column Info */
	private String rqstUsrEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ofcCode = null;
	/* Column Info */
	private String crrBankName = null;
	/* Column Info */
	private String polCode = null;
	/* Column Info */
	private String rqstBlTypeCode = null;
	/* Column Info */
	private String actualShprName = null;
	/* Column Info */
	private String deleteFlag = null;
	/* Column Info */
	private String blIssStsCode = null;
	/* Column Info */
	private String biiVslName = null;
	/* Column Info */
	private String taxInvRcvrRgstNo = null;
	/* Column Info */
	private String biiVvd = null;
	/* Column Info */
	private String rqstFromDt = null;
	/* Column Info */
	private String blIssStsCd = null;
	/* Column Info */
	private String crrBankAcctNo = null;
	/* Column Info */
	private String rqstAtndName = null;
	/* Column Info */
	private String blIssueRjctDt = null;
	/* Column Info */
	private String blIssueUsrId = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String actualShprRgstNo = null;
	/* Column Info */
	private String xterRqstNo = null;
	/* Column Info */
	private String taxInvRcvratndNm = null;
	/* Column Info */
	private String taxInvRcvrPhnNo = null;
	/* Column Info */
	private String remitKndCd = null;
	/* Column Info */
	private String crrRemitDt = null;	
	/* Column Info */
	private String crrUsaBankNm = null;	
	/* Column Info */
	private String crrUsaBankAcctNo = null;	
	/* Column Info */
	private String crrUsaRemitAmt = null;	
	/* Column Info */
	private String crrUsaRemitDt = null;	
	/* Column Info */
	private String crrUsaAcctCurrCd= null;	
	/* Column Info */
	private String vslCd= null;
	/* Column Info */
	private String skdVoyNo= null;
	/* Column Info */
	private String skdDirCd= null;
	/* Column Info */
	private String rn= null;
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
	
	public BlIssRqstVO() {}

	public BlIssRqstVO(String ibflag, String pagerows, String shprName, String blIssRmk, String blIssReqDt, String blRqstRmk, String rqstCoName, String crrRemitAmt, String blIssRjctDt, String blIssRqstDt, String blNo, String rqstUsrEml, String blIssDt, String blIssueActualDt, String taxInvRcvrCoName, String crrBankName, String ofcCode, String rqstBlTypeCode, String polCode, String deltId, String actualShprName, String blIssStsCode, String deleteFlag, String rqstPhnNo, String vpsEtdDt, String vesselName, String biiVslName, String remitCoName, String taxInvRcvrRgstNo, String biiVvd, String crrAcctCurrCode, String rqstFromDt, String crrBankAcctNo, String vvd, String creUsrId, String bkgNo, String rqstAtndName, String rqstToDt, String blIssueRjctDt, String blIssueUsrId, String xterRqstSeq, String xterRqstNo, String actualShprRgstNo, String rqstBlTpCd, String actShprNm, String polCd, String blIssStsCd, String rqstRctLocCd, String blIssActDt, String locNm, String biiVslNm, String rqstCoNm, String crrBankNm, String crrAcctCurrCd, String remitCoNm, String taxInvRcvrCoNm, String actShprRgstNo, String rqstAtndNm, String taxInvRcvratndNm, String taxInvRcvrPhnNo, String remitKndCd, String crrRemitDt, String crrUsaBankNm, String crrUsaBankAcctNo, String crrUsaRemitAmt, String crrUsaRemitDt, String crrUsaAcctCurrCd, String vslCd, String skdVoyNo, String skdDirCd, String rn, String blIssRqstCd, String blRcvTpCd, String mnlBlObrdDt, String mnlBlIssDt, String certiExistFlg, String frtDpFlg, String blObrdDt) {
		this.blObrdDt = blObrdDt;
		this.blIssActDt = blIssActDt;
		this.blIssReqDt = blIssReqDt;
		this.blRqstRmk = blRqstRmk;
		this.rqstCoName = rqstCoName;
		this.crrRemitAmt = crrRemitAmt;
		this.actShprRgstNo = actShprRgstNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blIssueActualDt = blIssueActualDt;
		this.blIssDt = blIssDt;
		this.polCd = polCd;
		this.taxInvRcvrCoName = taxInvRcvrCoName;
		this.biiVslNm = biiVslNm;
		this.deltId = deltId;
		this.taxInvRcvrCoNm = taxInvRcvrCoNm;
		this.rqstPhnNo = rqstPhnNo;
		this.crrAcctCurrCd = crrAcctCurrCd;
		this.rqstRctLocCd = rqstRctLocCd;
		this.vpsEtdDt = vpsEtdDt;
		this.vesselName = vesselName;
		this.remitCoName = remitCoName;
		this.crrAcctCurrCode = crrAcctCurrCode;
		this.locNm = locNm;
		this.rqstCoNm = rqstCoNm;
		this.blIssRqstDt = blIssRqstDt;
		this.vvd = vvd;
		this.rqstBlTpCd = rqstBlTpCd;
		this.creUsrId = creUsrId;
		this.bkgNo = bkgNo;
		this.rqstToDt = rqstToDt;
		this.actShprNm = actShprNm;
		this.crrBankNm = crrBankNm;
		this.rqstAtndNm = rqstAtndNm;
		this.shprName = shprName;
		this.blIssRmk = blIssRmk;
		this.remitCoNm = remitCoNm;
		this.blIssRjctDt = blIssRjctDt;
		this.rqstUsrEml = rqstUsrEml;
		this.ibflag = ibflag;
		this.ofcCode = ofcCode;
		this.crrBankName = crrBankName;
		this.polCode = polCode;
		this.rqstBlTypeCode = rqstBlTypeCode;
		this.actualShprName = actualShprName;
		this.deleteFlag = deleteFlag;
		this.blIssStsCode = blIssStsCode;
		this.biiVslName = biiVslName;
		this.taxInvRcvrRgstNo = taxInvRcvrRgstNo;
		this.biiVvd = biiVvd;
		this.rqstFromDt = rqstFromDt;
		this.blIssStsCd = blIssStsCd;
		this.crrBankAcctNo = crrBankAcctNo;
		this.rqstAtndName = rqstAtndName;
		this.blIssueRjctDt = blIssueRjctDt;
		this.blIssueUsrId = blIssueUsrId;
		this.xterRqstSeq = xterRqstSeq;
		this.actualShprRgstNo = actualShprRgstNo;
		this.xterRqstNo = xterRqstNo;
		this.taxInvRcvratndNm = taxInvRcvratndNm;
		this.taxInvRcvrPhnNo = taxInvRcvrPhnNo;
		this.remitKndCd = remitKndCd;
		this.crrRemitDt = crrRemitDt;
		this.crrUsaBankNm = crrUsaBankNm;
		this.crrUsaBankAcctNo = crrUsaBankAcctNo;
		this.crrUsaRemitAmt = crrUsaRemitAmt;
		this.crrUsaRemitDt = crrUsaRemitDt;
		this.crrUsaAcctCurrCd = crrUsaAcctCurrCd;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.rn = rn;
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
		this.hashColumns.put("bl_obrd_dt", getBlObrdDt());
		this.hashColumns.put("bl_iss_act_dt", getBlIssActDt());
		this.hashColumns.put("bl_iss_req_dt", getBlIssReqDt());
		this.hashColumns.put("bl_rqst_rmk", getBlRqstRmk());
		this.hashColumns.put("rqst_co_name", getRqstCoName());
		this.hashColumns.put("crr_remit_amt", getCrrRemitAmt());
		this.hashColumns.put("act_shpr_rgst_no", getActShprRgstNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_issue_actual_dt", getBlIssueActualDt());
		this.hashColumns.put("bl_iss_dt", getBlIssDt());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("tax_inv_rcvr_co_name", getTaxInvRcvrCoName());
		this.hashColumns.put("bii_vsl_nm", getBiiVslNm());
		this.hashColumns.put("delt_id", getDeltId());
		this.hashColumns.put("tax_inv_rcvr_co_nm", getTaxInvRcvrCoNm());
		this.hashColumns.put("rqst_phn_no", getRqstPhnNo());
		this.hashColumns.put("crr_acct_curr_cd", getCrrAcctCurrCd());
		this.hashColumns.put("rqst_rct_loc_cd", getRqstRctLocCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("vessel_name", getVesselName());
		this.hashColumns.put("remit_co_name", getRemitCoName());
		this.hashColumns.put("crr_acct_curr_code", getCrrAcctCurrCode());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("rqst_co_nm", getRqstCoNm());
		this.hashColumns.put("bl_iss_rqst_dt", getBlIssRqstDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rqst_bl_tp_cd", getRqstBlTpCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("rqst_to_dt", getRqstToDt());
		this.hashColumns.put("act_shpr_nm", getActShprNm());
		this.hashColumns.put("crr_bank_nm", getCrrBankNm());
		this.hashColumns.put("rqst_atnd_nm", getRqstAtndNm());
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("bl_iss_rmk", getBlIssRmk());
		this.hashColumns.put("remit_co_nm", getRemitCoNm());
		this.hashColumns.put("bl_iss_rjct_dt", getBlIssRjctDt());
		this.hashColumns.put("rqst_usr_eml", getRqstUsrEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofc_code", getOfcCode());
		this.hashColumns.put("crr_bank_name", getCrrBankName());
		this.hashColumns.put("pol_code", getPolCode());
		this.hashColumns.put("rqst_bl_type_code", getRqstBlTypeCode());
		this.hashColumns.put("actual_shpr_name", getActualShprName());
		this.hashColumns.put("delete_flag", getDeleteFlag());
		this.hashColumns.put("bl_iss_sts_code", getBlIssStsCode());
		this.hashColumns.put("bii_vsl_name", getBiiVslName());
		this.hashColumns.put("tax_inv_rcvr_rgst_no", getTaxInvRcvrRgstNo());
		this.hashColumns.put("bii_vvd", getBiiVvd());
		this.hashColumns.put("rqst_from_dt", getRqstFromDt());
		this.hashColumns.put("bl_iss_sts_cd", getBlIssStsCd());
		this.hashColumns.put("crr_bank_acct_no", getCrrBankAcctNo());
		this.hashColumns.put("rqst_atnd_name", getRqstAtndName());
		this.hashColumns.put("bl_issue_rjct_dt", getBlIssueRjctDt());
		this.hashColumns.put("bl_issue_usr_id", getBlIssueUsrId());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("actual_shpr_rgst_no", getActualShprRgstNo());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		this.hashColumns.put("tax_inv_rcvr_atnd_nm", getTaxInvRcvratndNm());
		this.hashColumns.put("tax_inv_rcvr_phn_no", getTaxInvRcvrPhnNo());
		this.hashColumns.put("remit_knd_cd", getRemitKndCd());
		this.hashColumns.put("crr_remit_dt", getCrrRemitDt());
		this.hashColumns.put("crrUsaBankNm", getCrrUsaBankNm());
		this.hashColumns.put("crrUsaBankAcctNo", getCrrUsaBankAcctNo());
		this.hashColumns.put("crrUsaRemitAmt", getCrrUsaRemitAmt());
		this.hashColumns.put("crrUsaRemitDt", getCrrUsaRemitDt());
		this.hashColumns.put("crrUsaAcctCurrCd", getCrrUsaAcctCurrCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("rn", getRn());
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
		this.hashFields.put("bl_obrd_dt", "blObrdDt");
		this.hashFields.put("bl_iss_act_dt", "blIssActDt");
		this.hashFields.put("bl_iss_req_dt", "blIssReqDt");
		this.hashFields.put("bl_rqst_rmk", "blRqstRmk");
		this.hashFields.put("rqst_co_name", "rqstCoName");
		this.hashFields.put("crr_remit_amt", "crrRemitAmt");
		this.hashFields.put("act_shpr_rgst_no", "actShprRgstNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_issue_actual_dt", "blIssueActualDt");
		this.hashFields.put("bl_iss_dt", "blIssDt");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("tax_inv_rcvr_co_name", "taxInvRcvrCoName");
		this.hashFields.put("bii_vsl_nm", "biiVslNm");
		this.hashFields.put("delt_id", "deltId");
		this.hashFields.put("tax_inv_rcvr_co_nm", "taxInvRcvrCoNm");
		this.hashFields.put("rqst_phn_no", "rqstPhnNo");
		this.hashFields.put("crr_acct_curr_cd", "crrAcctCurrCd");
		this.hashFields.put("rqst_rct_loc_cd", "rqstRctLocCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("vessel_name", "vesselName");
		this.hashFields.put("remit_co_name", "remitCoName");
		this.hashFields.put("crr_acct_curr_code", "crrAcctCurrCode");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("rqst_co_nm", "rqstCoNm");
		this.hashFields.put("bl_iss_rqst_dt", "blIssRqstDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rqst_bl_tp_cd", "rqstBlTpCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rqst_to_dt", "rqstToDt");
		this.hashFields.put("act_shpr_nm", "actShprNm");
		this.hashFields.put("crr_bank_nm", "crrBankNm");
		this.hashFields.put("rqst_atnd_nm", "rqstAtndNm");
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("bl_iss_rmk", "blIssRmk");
		this.hashFields.put("remit_co_nm", "remitCoNm");
		this.hashFields.put("bl_iss_rjct_dt", "blIssRjctDt");
		this.hashFields.put("rqst_usr_eml", "rqstUsrEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_code", "ofcCode");
		this.hashFields.put("crr_bank_name", "crrBankName");
		this.hashFields.put("pol_code", "polCode");
		this.hashFields.put("rqst_bl_type_code", "rqstBlTypeCode");
		this.hashFields.put("actual_shpr_name", "actualShprName");
		this.hashFields.put("delete_flag", "deleteFlag");
		this.hashFields.put("bl_iss_sts_code", "blIssStsCode");
		this.hashFields.put("bii_vsl_name", "biiVslName");
		this.hashFields.put("tax_inv_rcvr_rgst_no", "taxInvRcvrRgstNo");
		this.hashFields.put("bii_vvd", "biiVvd");
		this.hashFields.put("rqst_from_dt", "rqstFromDt");
		this.hashFields.put("bl_iss_sts_cd", "blIssStsCd");
		this.hashFields.put("crr_bank_acct_no", "crrBankAcctNo");
		this.hashFields.put("rqst_atnd_name", "rqstAtndName");
		this.hashFields.put("bl_issue_rjct_dt", "blIssueRjctDt");
		this.hashFields.put("bl_issue_usr_id", "blIssueUsrId");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("actual_shpr_rgst_no", "actualShprRgstNo");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		this.hashFields.put("tax_inv_rcvr_atnd_nm", "taxInvRcvratndNm");
		this.hashFields.put("tax_inv_rcvr_phn_no", "taxInvRcvrPhnNo");
		this.hashFields.put("remit_knd_cd", "remitKndCd");
		this.hashFields.put("crr_remit_dt", "crrRemitDt");
		this.hashFields.put("crr_usa_bank_nm", "crrUsaBankNm");
		this.hashFields.put("crr_usa_bank_acct_no", "crrUsaBankAcctNo");
		this.hashFields.put("crr_usa_remit_amt", "crrUsaRemitAmt");
		this.hashFields.put("crr_usa_remit_dt", "crrUsaRemitDt");
		this.hashFields.put("crr_usa_acct_curr_cd", "crrUsaAcctCurrCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("rn", "rn");
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
	 * @return blObrdDt
	 */
	public String getBlObrdDt() {
		return this.blObrdDt;
	}
	
	/**
	 * Column Info
	 * @return blIssActDt
	 */
	public String getBlIssActDt() {
		return this.blIssActDt;
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
	 * @return rqstCoName
	 */
	public String getRqstCoName() {
		return this.rqstCoName;
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
	 * @return blIssueActualDt
	 */
	public String getBlIssueActualDt() {
		return this.blIssueActualDt;
	}
	
	/**
	 * Column Info
	 * @return blIssDt
	 */
	public String getBlIssDt() {
		return this.blIssDt;
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
	 * @return taxInvRcvrCoName
	 */
	public String getTaxInvRcvrCoName() {
		return this.taxInvRcvrCoName;
	}
	
	/**
	 * Column Info
	 * @return biiVslNm
	 */
	public String getBiiVslNm() {
		return this.biiVslNm;
	}
	
	/**
	 * Column Info
	 * @return deltId
	 */
	public String getDeltId() {
		return this.deltId;
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
	 * @return rqstPhnNo
	 */
	public String getRqstPhnNo() {
		return this.rqstPhnNo;
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
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return vesselName
	 */
	public String getVesselName() {
		return this.vesselName;
	}
	
	/**
	 * Column Info
	 * @return remitCoName
	 */
	public String getRemitCoName() {
		return this.remitCoName;
	}
	
	/**
	 * Column Info
	 * @return crrAcctCurrCode
	 */
	public String getCrrAcctCurrCode() {
		return this.crrAcctCurrCode;
	}
	
	/**
	 * Column Info
	 * @return locNm
	 */
	public String getLocNm() {
		return this.locNm;
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
	 * @return blIssRqstDt
	 */
	public String getBlIssRqstDt() {
		return this.blIssRqstDt;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return rqstToDt
	 */
	public String getRqstToDt() {
		return this.rqstToDt;
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
	 * @return crrBankNm
	 */
	public String getCrrBankNm() {
		return this.crrBankNm;
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
	 * @return shprName
	 */
	public String getShprName() {
		return this.shprName;
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
	 * @return remitCoNm
	 */
	public String getRemitCoNm() {
		return this.remitCoNm;
	}
	
	/**
	 * Column Info
	 * @return blIssRjctDt
	 */
	public String getBlIssRjctDt() {
		return this.blIssRjctDt;
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
	 * @return ofcCode
	 */
	public String getOfcCode() {
		return this.ofcCode;
	}
	
	/**
	 * Column Info
	 * @return crrBankName
	 */
	public String getCrrBankName() {
		return this.crrBankName;
	}
	
	/**
	 * Column Info
	 * @return polCode
	 */
	public String getPolCode() {
		return this.polCode;
	}
	
	/**
	 * Column Info
	 * @return rqstBlTypeCode
	 */
	public String getRqstBlTypeCode() {
		return this.rqstBlTypeCode;
	}
	
	/**
	 * Column Info
	 * @return actualShprName
	 */
	public String getActualShprName() {
		return this.actualShprName;
	}
	
	/**
	 * Column Info
	 * @return deleteFlag
	 */
	public String getDeleteFlag() {
		return this.deleteFlag;
	}
	
	/**
	 * Column Info
	 * @return blIssStsCode
	 */
	public String getBlIssStsCode() {
		return this.blIssStsCode;
	}
	
	/**
	 * Column Info
	 * @return biiVslName
	 */
	public String getBiiVslName() {
		return this.biiVslName;
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
	 * @return biiVvd
	 */
	public String getBiiVvd() {
		return this.biiVvd;
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
	 * @return blIssStsCd
	 */
	public String getBlIssStsCd() {
		return this.blIssStsCd;
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
	 * @return rqstAtndName
	 */
	public String getRqstAtndName() {
		return this.rqstAtndName;
	}
	
	/**
	 * Column Info
	 * @return blIssueRjctDt
	 */
	public String getBlIssueRjctDt() {
		return this.blIssueRjctDt;
	}
	
	/**
	 * Column Info
	 * @return blIssueUsrId
	 */
	public String getBlIssueUsrId() {
		return this.blIssueUsrId;
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
	 * @return actualShprRgstNo
	 */
	public String getActualShprRgstNo() {
		return this.actualShprRgstNo;
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
	 * @return remitKndCd
	 */
	public String getRemitKndCd() {
		return this.remitKndCd;
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
	 * @param blObrdDt
	 */
	public void setBlObrdDt(String blObrdDt) {
		this.blObrdDt = blObrdDt;
	}
	
	/**
	 * Column Info
	 * @param blIssActDt
	 */
	public void setBlIssActDt(String blIssActDt) {
		this.blIssActDt = blIssActDt;
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
	 * @param rqstCoName
	 */
	public void setRqstCoName(String rqstCoName) {
		this.rqstCoName = rqstCoName;
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
	 * @param blIssueActualDt
	 */
	public void setBlIssueActualDt(String blIssueActualDt) {
		this.blIssueActualDt = blIssueActualDt;
	}
	
	/**
	 * Column Info
	 * @param blIssDt
	 */
	public void setBlIssDt(String blIssDt) {
		this.blIssDt = blIssDt;
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
	 * @param taxInvRcvrCoName
	 */
	public void setTaxInvRcvrCoName(String taxInvRcvrCoName) {
		this.taxInvRcvrCoName = taxInvRcvrCoName;
	}
	
	/**
	 * Column Info
	 * @param biiVslNm
	 */
	public void setBiiVslNm(String biiVslNm) {
		this.biiVslNm = biiVslNm;
	}
	
	/**
	 * Column Info
	 * @param deltId
	 */
	public void setDeltId(String deltId) {
		this.deltId = deltId;
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
	 * @param rqstPhnNo
	 */
	public void setRqstPhnNo(String rqstPhnNo) {
		this.rqstPhnNo = rqstPhnNo;
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
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param vesselName
	 */
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	
	/**
	 * Column Info
	 * @param remitCoName
	 */
	public void setRemitCoName(String remitCoName) {
		this.remitCoName = remitCoName;
	}
	
	/**
	 * Column Info
	 * @param crrAcctCurrCode
	 */
	public void setCrrAcctCurrCode(String crrAcctCurrCode) {
		this.crrAcctCurrCode = crrAcctCurrCode;
	}
	
	/**
	 * Column Info
	 * @param locNm
	 */
	public void setLocNm(String locNm) {
		this.locNm = locNm;
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
	 * @param blIssRqstDt
	 */
	public void setBlIssRqstDt(String blIssRqstDt) {
		this.blIssRqstDt = blIssRqstDt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param rqstToDt
	 */
	public void setRqstToDt(String rqstToDt) {
		this.rqstToDt = rqstToDt;
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
	 * @param crrBankNm
	 */
	public void setCrrBankNm(String crrBankNm) {
		this.crrBankNm = crrBankNm;
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
	 * @param shprName
	 */
	public void setShprName(String shprName) {
		this.shprName = shprName;
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
	 * @param remitCoNm
	 */
	public void setRemitCoNm(String remitCoNm) {
		this.remitCoNm = remitCoNm;
	}
	
	/**
	 * Column Info
	 * @param blIssRjctDt
	 */
	public void setBlIssRjctDt(String blIssRjctDt) {
		this.blIssRjctDt = blIssRjctDt;
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
	 * @param ofcCode
	 */
	public void setOfcCode(String ofcCode) {
		this.ofcCode = ofcCode;
	}
	
	/**
	 * Column Info
	 * @param crrBankName
	 */
	public void setCrrBankName(String crrBankName) {
		this.crrBankName = crrBankName;
	}
	
	/**
	 * Column Info
	 * @param polCode
	 */
	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}
	
	/**
	 * Column Info
	 * @param rqstBlTypeCode
	 */
	public void setRqstBlTypeCode(String rqstBlTypeCode) {
		this.rqstBlTypeCode = rqstBlTypeCode;
	}
	
	/**
	 * Column Info
	 * @param actualShprName
	 */
	public void setActualShprName(String actualShprName) {
		this.actualShprName = actualShprName;
	}
	
	/**
	 * Column Info
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	/**
	 * Column Info
	 * @param blIssStsCode
	 */
	public void setBlIssStsCode(String blIssStsCode) {
		this.blIssStsCode = blIssStsCode;
	}
	
	/**
	 * Column Info
	 * @param biiVslName
	 */
	public void setBiiVslName(String biiVslName) {
		this.biiVslName = biiVslName;
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
	 * @param biiVvd
	 */
	public void setBiiVvd(String biiVvd) {
		this.biiVvd = biiVvd;
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
	 * @param blIssStsCd
	 */
	public void setBlIssStsCd(String blIssStsCd) {
		this.blIssStsCd = blIssStsCd;
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
	 * @param rqstAtndName
	 */
	public void setRqstAtndName(String rqstAtndName) {
		this.rqstAtndName = rqstAtndName;
	}
	
	/**
	 * Column Info
	 * @param blIssueRjctDt
	 */
	public void setBlIssueRjctDt(String blIssueRjctDt) {
		this.blIssueRjctDt = blIssueRjctDt;
	}
	
	/**
	 * Column Info
	 * @param blIssueUsrId
	 */
	public void setBlIssueUsrId(String blIssueUsrId) {
		this.blIssueUsrId = blIssueUsrId;
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
	 * @param actualShprRgstNo
	 */
	public void setActualShprRgstNo(String actualShprRgstNo) {
		this.actualShprRgstNo = actualShprRgstNo;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * @return the taxInvRcvratndNm
	 */
	public String getTaxInvRcvratndNm() {
		return taxInvRcvratndNm;
	}

	/**
	 * @param taxInvRcvratndNm the taxInvRcvratndNm to set
	 */
	public void setTaxInvRcvratndNm(String taxInvRcvratndNm) {
		this.taxInvRcvratndNm = taxInvRcvratndNm;
	}

	/**
	 * @return the taxInvRcvrPhnNo
	 */
	public String getTaxInvRcvrPhnNo() {
		return taxInvRcvrPhnNo;
	}

	/**
	 * @param taxInvRcvrPhnNo the taxInvRcvrPhnNo to set
	 */
	public void setTaxInvRcvrPhnNo(String taxInvRcvrPhnNo) {
		this.taxInvRcvrPhnNo = taxInvRcvrPhnNo;
	}
	
	/**
	 * Column Info
	 * @param actualShprRgstNo
	 */
	public void setRemitKndCd(String remitKndCd) {
		this.remitKndCd = remitKndCd;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setCrrRemitDt(String crrRemitDt) {
		this.crrRemitDt = crrRemitDt;
	}

	/**
	 * @return the crrUsaBankNm
	 */
	public String getCrrUsaBankNm() {
		return crrUsaBankNm;
	}

	/**
	 * @param crrUsaBankNm the crrUsaBankNm to set
	 */
	public void setCrrUsaBankNm(String crrUsaBankNm) {
		this.crrUsaBankNm = crrUsaBankNm;
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
	 * @param blIssRqstCd the blIssRqstCd to set
	 */
	public void setBlIssRqstCd(String blIssRqstCd) {
		this.blIssRqstCd = blIssRqstCd;
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
	 * @return the vslCd
	 */
	public String getVslCd() {
		return vslCd;
	}

	/**
	 * @param vslCd the vslCd to set
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * @return the skdVoyNo
	 */
	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	/**
	 * @param skdVoyNo the skdVoyNo to set
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/**
	 * @return the skdDirCd
	 */
	public String getSkdDirCd() {
		return skdDirCd;
	}

	/**
	 * @param skdDirCd the skdDirCd to set
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	/**
	 * @return the rn
	 */
	public String getRn() {
		return rn;
	}

	/**
	 * @param rn the rn to set
	 */
	public void setRn(String rn) {
		this.rn = rn;
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
		setBlObrdDt(JSPUtil.getParameter(request, prefix + "bl_obrd_dt", ""));
		setBlIssActDt(JSPUtil.getParameter(request, prefix + "bl_iss_act_dt", ""));
		setBlIssReqDt(JSPUtil.getParameter(request, prefix + "bl_iss_req_dt", ""));
		setBlRqstRmk(JSPUtil.getParameter(request, prefix + "bl_rqst_rmk", ""));
		setRqstCoName(JSPUtil.getParameter(request, prefix + "rqst_co_name", ""));
		setCrrRemitAmt(JSPUtil.getParameter(request, prefix + "crr_remit_amt", ""));
		setActShprRgstNo(JSPUtil.getParameter(request, prefix + "act_shpr_rgst_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBlIssueActualDt(JSPUtil.getParameter(request, prefix + "bl_issue_actual_dt", ""));
		setBlIssDt(JSPUtil.getParameter(request, prefix + "bl_iss_dt", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setTaxInvRcvrCoName(JSPUtil.getParameter(request, prefix + "tax_inv_rcvr_co_name", ""));
		setBiiVslNm(JSPUtil.getParameter(request, prefix + "bii_vsl_nm", ""));
		setDeltId(JSPUtil.getParameter(request, prefix + "delt_id", ""));
		setTaxInvRcvrCoNm(JSPUtil.getParameter(request, prefix + "tax_inv_rcvr_co_nm", ""));
		setRqstPhnNo(JSPUtil.getParameter(request, prefix + "rqst_phn_no", ""));
		setCrrAcctCurrCd(JSPUtil.getParameter(request, prefix + "crr_acct_curr_cd", ""));
		setRqstRctLocCd(JSPUtil.getParameter(request, prefix + "rqst_rct_loc_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setVesselName(JSPUtil.getParameter(request, prefix + "vessel_name", ""));
		setRemitCoName(JSPUtil.getParameter(request, prefix + "remit_co_name", ""));
		setCrrAcctCurrCode(JSPUtil.getParameter(request, prefix + "crr_acct_curr_code", ""));
		setLocNm(JSPUtil.getParameter(request, prefix + "loc_nm", ""));
		setRqstCoNm(JSPUtil.getParameter(request, prefix + "rqst_co_nm", ""));
		setBlIssRqstDt(JSPUtil.getParameter(request, prefix + "bl_iss_rqst_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRqstBlTpCd(JSPUtil.getParameter(request, prefix + "rqst_bl_tp_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setRqstToDt(JSPUtil.getParameter(request, prefix + "rqst_to_dt", ""));
		setActShprNm(JSPUtil.getParameter(request, prefix + "act_shpr_nm", ""));
		setCrrBankNm(JSPUtil.getParameter(request, prefix + "crr_bank_nm", ""));
		setRqstAtndNm(JSPUtil.getParameter(request, prefix + "rqst_atnd_nm", ""));
		setShprName(JSPUtil.getParameter(request, prefix + "shpr_name", ""));
		setBlIssRmk(JSPUtil.getParameter(request, prefix + "bl_iss_rmk", ""));
		setRemitCoNm(JSPUtil.getParameter(request, prefix + "remit_co_nm", ""));
		setBlIssRjctDt(JSPUtil.getParameter(request, prefix + "bl_iss_rjct_dt", ""));
		setRqstUsrEml(JSPUtil.getParameter(request, prefix + "rqst_usr_eml", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOfcCode(JSPUtil.getParameter(request, prefix + "ofc_code", ""));
		setCrrBankName(JSPUtil.getParameter(request, prefix + "crr_bank_name", ""));
		setPolCode(JSPUtil.getParameter(request, prefix + "pol_code", ""));
		setRqstBlTypeCode(JSPUtil.getParameter(request, prefix + "rqst_bl_type_code", ""));
		setActualShprName(JSPUtil.getParameter(request, prefix + "actual_shpr_name", ""));
		setDeleteFlag(JSPUtil.getParameter(request, prefix + "delete_flag", ""));
		setBlIssStsCode(JSPUtil.getParameter(request, prefix + "bl_iss_sts_code", ""));
		setBiiVslName(JSPUtil.getParameter(request, prefix + "bii_vsl_name", ""));
		setTaxInvRcvrRgstNo(JSPUtil.getParameter(request, prefix + "tax_inv_rcvr_rgst_no", ""));
		setBiiVvd(JSPUtil.getParameter(request, prefix + "bii_vvd", ""));
		setRqstFromDt(JSPUtil.getParameter(request, prefix + "rqst_from_dt", ""));
		setBlIssStsCd(JSPUtil.getParameter(request, prefix + "bl_iss_sts_cd", ""));
		setCrrBankAcctNo(JSPUtil.getParameter(request, prefix + "crr_bank_acct_no", ""));
		setRqstAtndName(JSPUtil.getParameter(request, prefix + "rqst_atnd_name", ""));
		setBlIssueRjctDt(JSPUtil.getParameter(request, prefix + "bl_issue_rjct_dt", ""));
		setBlIssueUsrId(JSPUtil.getParameter(request, prefix + "bl_issue_usr_id", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setActualShprRgstNo(JSPUtil.getParameter(request, prefix + "actual_shpr_rgst_no", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
		setTaxInvRcvratndNm(JSPUtil.getParameter(request, prefix + "tax_inv_rcvr_atnd_nm", ""));
		setTaxInvRcvrPhnNo(JSPUtil.getParameter(request, prefix + "tax_inv_rcvr_phn_no", ""));
		setRemitKndCd(JSPUtil.getParameter(request, prefix + "remit_knd_cd", ""));
		setCrrRemitDt(JSPUtil.getParameter(request, prefix + "crr_remit_dt", ""));
		setCrrUsaBankNm(JSPUtil.getParameter(request, prefix + "crr_usa_bank_nm", ""));
		setCrrUsaBankAcctNo(JSPUtil.getParameter(request, prefix + "crr_usa_bank_acct_no", ""));
		setCrrUsaRemitAmt(JSPUtil.getParameter(request, prefix + "crr_usa_remit_amt", ""));
		setCrrUsaRemitDt(JSPUtil.getParameter(request, prefix + "crr_usa_remit_dt", ""));
		setCrrUsaAcctCurrCd(JSPUtil.getParameter(request, prefix + "crr_usa_acct_curr_cd", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setRn(JSPUtil.getParameter(request, prefix + "rn", ""));
		setBlIssRqstCd(JSPUtil.getParameter(request, prefix + "bl_iss_rqst_cd", ""));
		setBlRcvTpCd(JSPUtil.getParameter(request, prefix + "bl_rcv_tp_cd", ""));
		setMnlBlObrdDt(JSPUtil.getParameter(request, prefix + "mnl_bl_obrd_dt", ""));
		setMnlBlIssDt(JSPUtil.getParameter(request, prefix + "mnl_bl_iss_dt", ""));
		setCertiExistFlg(JSPUtil.getParameter(request, prefix + "certi_exist_flg", ""));
		setFrtDpFlg(JSPUtil.getParameter(request, prefix + "frt_dp_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlIssRqstVO[]
	 */
	public BlIssRqstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlIssRqstVO[]
	 */
	public BlIssRqstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlIssRqstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blObrdDt = (JSPUtil.getParameter(request, prefix	+ "bl_obrd_dt", length));
			String[] blIssActDt = (JSPUtil.getParameter(request, prefix	+ "bl_iss_act_dt", length));
			String[] blIssReqDt = (JSPUtil.getParameter(request, prefix	+ "bl_iss_req_dt", length));
			String[] blRqstRmk = (JSPUtil.getParameter(request, prefix	+ "bl_rqst_rmk", length));
			String[] rqstCoName = (JSPUtil.getParameter(request, prefix	+ "rqst_co_name", length));
			String[] crrRemitAmt = (JSPUtil.getParameter(request, prefix	+ "crr_remit_amt", length));
			String[] actShprRgstNo = (JSPUtil.getParameter(request, prefix	+ "act_shpr_rgst_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blIssueActualDt = (JSPUtil.getParameter(request, prefix	+ "bl_issue_actual_dt", length));
			String[] blIssDt = (JSPUtil.getParameter(request, prefix	+ "bl_iss_dt", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] taxInvRcvrCoName = (JSPUtil.getParameter(request, prefix	+ "tax_inv_rcvr_co_name", length));
			String[] biiVslNm = (JSPUtil.getParameter(request, prefix	+ "bii_vsl_nm", length));
			String[] deltId = (JSPUtil.getParameter(request, prefix	+ "delt_id", length));
			String[] taxInvRcvrCoNm = (JSPUtil.getParameter(request, prefix	+ "tax_inv_rcvr_co_nm", length));
			String[] rqstPhnNo = (JSPUtil.getParameter(request, prefix	+ "rqst_phn_no", length));
			String[] crrAcctCurrCd = (JSPUtil.getParameter(request, prefix	+ "crr_acct_curr_cd", length));
			String[] rqstRctLocCd = (JSPUtil.getParameter(request, prefix	+ "rqst_rct_loc_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] vesselName = (JSPUtil.getParameter(request, prefix	+ "vessel_name", length));
			String[] remitCoName = (JSPUtil.getParameter(request, prefix	+ "remit_co_name", length));
			String[] crrAcctCurrCode = (JSPUtil.getParameter(request, prefix	+ "crr_acct_curr_code", length));
			String[] locNm = (JSPUtil.getParameter(request, prefix	+ "loc_nm", length));
			String[] rqstCoNm = (JSPUtil.getParameter(request, prefix	+ "rqst_co_nm", length));
			String[] blIssRqstDt = (JSPUtil.getParameter(request, prefix	+ "bl_iss_rqst_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] rqstBlTpCd = (JSPUtil.getParameter(request, prefix	+ "rqst_bl_tp_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] rqstToDt = (JSPUtil.getParameter(request, prefix	+ "rqst_to_dt", length));
			String[] actShprNm = (JSPUtil.getParameter(request, prefix	+ "act_shpr_nm", length));
			String[] crrBankNm = (JSPUtil.getParameter(request, prefix	+ "crr_bank_nm", length));
			String[] rqstAtndNm = (JSPUtil.getParameter(request, prefix	+ "rqst_atnd_nm", length));
			String[] shprName = (JSPUtil.getParameter(request, prefix	+ "shpr_name", length));
			String[] blIssRmk = (JSPUtil.getParameter(request, prefix	+ "bl_iss_rmk", length));
			String[] remitCoNm = (JSPUtil.getParameter(request, prefix	+ "remit_co_nm", length));
			String[] blIssRjctDt = (JSPUtil.getParameter(request, prefix	+ "bl_iss_rjct_dt", length));
			String[] rqstUsrEml = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ofcCode = (JSPUtil.getParameter(request, prefix	+ "ofc_code", length));
			String[] crrBankName = (JSPUtil.getParameter(request, prefix	+ "crr_bank_name", length));
			String[] polCode = (JSPUtil.getParameter(request, prefix	+ "pol_code", length));
			String[] rqstBlTypeCode = (JSPUtil.getParameter(request, prefix	+ "rqst_bl_type_code", length));
			String[] actualShprName = (JSPUtil.getParameter(request, prefix	+ "actual_shpr_name", length));
			String[] deleteFlag = (JSPUtil.getParameter(request, prefix	+ "delete_flag", length));
			String[] blIssStsCode = (JSPUtil.getParameter(request, prefix	+ "bl_iss_sts_code", length));
			String[] biiVslName = (JSPUtil.getParameter(request, prefix	+ "bii_vsl_name", length));
			String[] taxInvRcvrRgstNo = (JSPUtil.getParameter(request, prefix	+ "tax_inv_rcvr_rgst_no", length));
			String[] biiVvd = (JSPUtil.getParameter(request, prefix	+ "bii_vvd", length));
			String[] rqstFromDt = (JSPUtil.getParameter(request, prefix	+ "rqst_from_dt", length));
			String[] blIssStsCd = (JSPUtil.getParameter(request, prefix	+ "bl_iss_sts_cd", length));
			String[] crrBankAcctNo = (JSPUtil.getParameter(request, prefix	+ "crr_bank_acct_no", length));
			String[] rqstAtndName = (JSPUtil.getParameter(request, prefix	+ "rqst_atnd_name", length));
			String[] blIssueRjctDt = (JSPUtil.getParameter(request, prefix	+ "bl_issue_rjct_dt", length));
			String[] blIssueUsrId = (JSPUtil.getParameter(request, prefix	+ "bl_issue_usr_id", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] actualShprRgstNo = (JSPUtil.getParameter(request, prefix	+ "actual_shpr_rgst_no", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			String[] taxInvRcvratndNm = (JSPUtil.getParameter(request, prefix	+ "tax_inv_rcvr_atnd_nm", length));
			String[] taxInvRcvrPhnNo = (JSPUtil.getParameter(request, prefix	+ "tax_inv_rcvr_phn_no", length));
			String[] remitKndCd = (JSPUtil.getParameter(request, prefix	+ "remit_knd_cd", length));
			String[] crrRemitDt = (JSPUtil.getParameter(request, prefix	+ "crr_remit_dt", length));
			String[] crrUsaBankNm = (JSPUtil.getParameter(request, prefix + "crr_usa_bank_nm", length));
			String[] crrUsaBankAcctNo = (JSPUtil.getParameter(request, prefix + "crr_usa_bank_acct_no", length));
			String[] crrUsaRemitAmt = (JSPUtil.getParameter(request, prefix + "crr_usa_remit_amt", length));
			String[] crrUsaRemitDt = (JSPUtil.getParameter(request, prefix + "crr_usa_remit_dt", length));
			String[] crrUsaAcctCurrCd = (JSPUtil.getParameter(request, prefix + "crr_usa_acct_curr_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
			String[] rn = (JSPUtil.getParameter(request, prefix + "rn", length));
			String[] blIssRqstCd = (JSPUtil.getParameter(request, prefix + "bl_iss_rqst_cd", length));
			String[] blRcvTpCd = (JSPUtil.getParameter(request, prefix + "bl_rcv_tp_cd", length));
			String[] mnlBlObrdDt = (JSPUtil.getParameter(request, prefix + "mnl_bl_obrd_dt", length));
			String[] mnlBlIssDt = (JSPUtil.getParameter(request, prefix + "mnl_bl_iss_dt", length));
			String[] certiExistFlg = (JSPUtil.getParameter(request, prefix + "certi_exist_flg", length));
			String[] frtDpFlg = (JSPUtil.getParameter(request, prefix + "frt_dp_flg", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new BlIssRqstVO();
				if (blIssActDt[i] != null)
					model.setBlIssActDt(blIssActDt[i]);
				if (blIssReqDt[i] != null)
					model.setBlIssReqDt(blIssReqDt[i]);
				if (blRqstRmk[i] != null)
					model.setBlRqstRmk(blRqstRmk[i]);
				if (rqstCoName[i] != null)
					model.setRqstCoName(rqstCoName[i]);
				if (crrRemitAmt[i] != null)
					model.setCrrRemitAmt(crrRemitAmt[i]);
				if (actShprRgstNo[i] != null)
					model.setActShprRgstNo(actShprRgstNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blIssueActualDt[i] != null)
					model.setBlIssueActualDt(blIssueActualDt[i]);
				if (blIssDt[i] != null)
					model.setBlIssDt(blIssDt[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (taxInvRcvrCoName[i] != null)
					model.setTaxInvRcvrCoName(taxInvRcvrCoName[i]);
				if (biiVslNm[i] != null)
					model.setBiiVslNm(biiVslNm[i]);
				if (deltId[i] != null)
					model.setDeltId(deltId[i]);
				if (taxInvRcvrCoNm[i] != null)
					model.setTaxInvRcvrCoNm(taxInvRcvrCoNm[i]);
				if (rqstPhnNo[i] != null)
					model.setRqstPhnNo(rqstPhnNo[i]);
				if (crrAcctCurrCd[i] != null)
					model.setCrrAcctCurrCd(crrAcctCurrCd[i]);
				if (rqstRctLocCd[i] != null)
					model.setRqstRctLocCd(rqstRctLocCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (vesselName[i] != null)
					model.setVesselName(vesselName[i]);
				if (remitCoName[i] != null)
					model.setRemitCoName(remitCoName[i]);
				if (crrAcctCurrCode[i] != null)
					model.setCrrAcctCurrCode(crrAcctCurrCode[i]);
				if (locNm[i] != null)
					model.setLocNm(locNm[i]);
				if (rqstCoNm[i] != null)
					model.setRqstCoNm(rqstCoNm[i]);
				if (blIssRqstDt[i] != null)
					model.setBlIssRqstDt(blIssRqstDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (rqstBlTpCd[i] != null)
					model.setRqstBlTpCd(rqstBlTpCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (rqstToDt[i] != null)
					model.setRqstToDt(rqstToDt[i]);
				if (actShprNm[i] != null)
					model.setActShprNm(actShprNm[i]);
				if (crrBankNm[i] != null)
					model.setCrrBankNm(crrBankNm[i]);
				if (rqstAtndNm[i] != null)
					model.setRqstAtndNm(rqstAtndNm[i]);
				if (shprName[i] != null)
					model.setShprName(shprName[i]);
				if (blIssRmk[i] != null)
					model.setBlIssRmk(blIssRmk[i]);
				if (remitCoNm[i] != null)
					model.setRemitCoNm(remitCoNm[i]);
				if (blIssRjctDt[i] != null)
					model.setBlIssRjctDt(blIssRjctDt[i]);
				if (rqstUsrEml[i] != null)
					model.setRqstUsrEml(rqstUsrEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofcCode[i] != null)
					model.setOfcCode(ofcCode[i]);
				if (crrBankName[i] != null)
					model.setCrrBankName(crrBankName[i]);
				if (polCode[i] != null)
					model.setPolCode(polCode[i]);
				if (rqstBlTypeCode[i] != null)
					model.setRqstBlTypeCode(rqstBlTypeCode[i]);
				if (actualShprName[i] != null)
					model.setActualShprName(actualShprName[i]);
				if (deleteFlag[i] != null)
					model.setDeleteFlag(deleteFlag[i]);
				if (blIssStsCode[i] != null)
					model.setBlIssStsCode(blIssStsCode[i]);
				if (biiVslName[i] != null)
					model.setBiiVslName(biiVslName[i]);
				if (taxInvRcvrRgstNo[i] != null)
					model.setTaxInvRcvrRgstNo(taxInvRcvrRgstNo[i]);
				if (biiVvd[i] != null)
					model.setBiiVvd(biiVvd[i]);
				if (rqstFromDt[i] != null)
					model.setRqstFromDt(rqstFromDt[i]);
				if (blIssStsCd[i] != null)
					model.setBlIssStsCd(blIssStsCd[i]);
				if (crrBankAcctNo[i] != null)
					model.setCrrBankAcctNo(crrBankAcctNo[i]);
				if (rqstAtndName[i] != null)
					model.setRqstAtndName(rqstAtndName[i]);
				if (blIssueRjctDt[i] != null)
					model.setBlIssueRjctDt(blIssueRjctDt[i]);
				if (blIssueUsrId[i] != null)
					model.setBlIssueUsrId(blIssueUsrId[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (actualShprRgstNo[i] != null)
					model.setActualShprRgstNo(actualShprRgstNo[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				if (xterRqstNo[i] != null)
					model.setTaxInvRcvratndNm(taxInvRcvratndNm[i]);
				if (xterRqstNo[i] != null)
					model.setTaxInvRcvrPhnNo(taxInvRcvrPhnNo[i]);
				if (remitKndCd[i] != null)
					model.setRemitKndCd(remitKndCd[i]);
				if (crrRemitDt[i] != null)
					model.setCrrRemitDt(crrRemitDt[i]);
				if (crrUsaBankNm[i] != null)
					model.setCrrUsaBankNm(crrUsaBankNm[i]);
				if (crrUsaBankAcctNo[i] != null)
					model.setCrrUsaBankAcctNo(crrUsaBankAcctNo[i]);
				if (crrUsaRemitAmt[i] != null)
					model.setCrrUsaRemitAmt(crrUsaRemitAmt[i]);
				if (crrUsaRemitDt[i] != null)
					model.setCrrUsaRemitDt(crrUsaRemitDt[i]);
				if (crrUsaAcctCurrCd[i] != null)
					model.setCrrUsaAcctCurrCd(crrUsaAcctCurrCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);				
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
				if (blObrdDt[i] != null)
					model.setBlObrdDt(blObrdDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlIssRqstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlIssRqstVO[]
	 */
	public BlIssRqstVO[] getBlIssRqstVOs(){
		BlIssRqstVO[] vos = (BlIssRqstVO[])models.toArray(new BlIssRqstVO[models.size()]);
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
	* 화폐 표기 항목은 쉼표 나오도록 주석처리로 제외.
	*/
	public void unDataFormat(){
		this.blObrdDt = this.blObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssActDt = this.blIssActDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssReqDt = this.blIssReqDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRqstRmk = this.blRqstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstCoName = this.rqstCoName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.crrRemitAmt = this.crrRemitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprRgstNo = this.actShprRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssueActualDt = this.blIssueActualDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssDt = this.blIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvRcvrCoName = this.taxInvRcvrCoName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.biiVslNm = this.biiVslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltId = this.deltId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvRcvrCoNm = this.taxInvRcvrCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstPhnNo = this.rqstPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrAcctCurrCd = this.crrAcctCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRctLocCd = this.rqstRctLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselName = this.vesselName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remitCoName = this.remitCoName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrAcctCurrCode = this.crrAcctCurrCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm = this.locNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstCoNm = this.rqstCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssRqstDt = this.blIssRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstBlTpCd = this.rqstBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstToDt = this.rqstToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actShprNm = this.actShprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBankNm = this.crrBankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAtndNm = this.rqstAtndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprName = this.shprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssRmk = this.blIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remitCoNm = this.remitCoNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssRjctDt = this.blIssRjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrEml = this.rqstUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCode = this.ofcCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBankName = this.crrBankName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCode = this.polCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstBlTypeCode = this.rqstBlTypeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualShprName = this.actualShprName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deleteFlag = this.deleteFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssStsCode = this.blIssStsCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.biiVslName = this.biiVslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvRcvrRgstNo = this.taxInvRcvrRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.biiVvd = this.biiVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFromDt = this.rqstFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssStsCd = this.blIssStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBankAcctNo = this.crrBankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstAtndName = this.rqstAtndName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssueRjctDt = this.blIssueRjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssueUsrId = this.blIssueUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualShprRgstNo = this.actualShprRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvRcvratndNm = this.taxInvRcvratndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvRcvrPhnNo = this.taxInvRcvrPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remitKndCd = this.remitKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrRemitDt = this.crrRemitDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrUsaBankNm = this.crrUsaBankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrUsaBankAcctNo = this.crrUsaBankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
//		this.crrUsaRemitAmt = this.crrUsaRemitAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrUsaRemitDt = this.crrUsaRemitDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrUsaAcctCurrCd = this.crrUsaAcctCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blIssRqstCd = this.blIssRqstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.blRcvTpCd = this.blRcvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlBlObrdDt = this.mnlBlObrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlBlIssDt = this.mnlBlIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.certiExistFlg = this.certiExistFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtDpFlg = this.frtDpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
