/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrTtlLssRqstDtlVO.java
*@FileTitle : CustomMnrTtlLssRqstDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.15
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.07.15 박명신
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrTtlLssRqstDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<CustomMnrTtlLssRqstDtlVO> models = new ArrayList<CustomMnrTtlLssRqstDtlVO>();

	/* Column Info */
	private String payerCode = null;
	/* Column Info */
	private String ttlLssNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String ttlLssCmplDt = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String bankNm = null;
	/* Column Info */
	private String arChkNo = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ttlLssCmplCd = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String ttlLssN3ptyTpCd = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String dpcValAmt = null;
	/* Column Info */
	private String ttlLssBilAmt = null;
	/* Column Info */
	private String vndrCustSeq = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String ttlLssPlcNm = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String eqOwnrFlg = null;
	/* Column Info */
	private String mnrSwiftNo = null;
	/* Column Info */
	private String ttlLssCfmFlg = null;
	/* Column Info */
	private String lessorNm = null;
	/* Column Info */
	private String ifTrcSeq = null;
	/* Column Info */
	private String tempSeq = null;
	/* Column Info */
	private String bankAcctNo = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String ttlLssDtlStsCd = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ttlLssYdCd = null;
	/* Column Info */
	private String ttlLssExpnAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String ttlLssBilDt = null;
	/* Column Info */
	private String invRgstNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ttlLssDtlSeq = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String ttlLssIncmAmt = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String mnrInvTpCd = null;
	/* Column Info */
	private String dtlRmk = null;
	/* Column Info */
	private String respbOfcCd = null;
	/* Column Info */
	private String payerName = null;
	/* Column Info */
	private String crEndDt = null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 revDirCd   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();

	public CustomMnrTtlLssRqstDtlVO() {}

	public CustomMnrTtlLssRqstDtlVO(String ibflag, String pagerows, String payerCode, String tempSeq, String bankAcctNo, String currCd, String ttlLssDtlStsCd, String payInvSeq, String ttlLssNo, String mnrPrnrCntCd, String creDt, String ttlLssYdCd, String mnrPrnrSeq, String ttlLssExpnAmt, String rqstEqNo, String n3ptyNo, String bankNm, String cntCd, String ttlLssBilDt, String arChkNo, String lstmCd, String updUsrId, String invRgstNo, String updDt, String ttlLssDtlSeq, String csrNo, String ttlLssN3ptyTpCd, String dispNo, String dpcValAmt, String ttlLssBilAmt, String vndrCustSeq, String eqKndCd, String ttlLssIncmAmt, String eqTpszCd, String invNo, String ttlLssPlcNm, String creUsrId, String ydCd, String eqOwnrFlg, String mnrSwiftNo, String ttlLssCfmFlg, String mnrInvTpCd, String dtlRmk, String respbOfcCd, String lessorNm, String ifTrcSeq, String payerName, String crEndDt, String ttlLssCmplCd, String ttlLssCmplDt, String vslCd, String skdVoyNo, String skdDirCd, String revDirCd, String slanCd) {
		this.payerCode = payerCode;
		this.ttlLssNo = ttlLssNo;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.ttlLssCmplDt = ttlLssCmplDt;
		this.cntCd = cntCd;
		this.bankNm = bankNm;
		this.arChkNo = arChkNo;
		this.lstmCd = lstmCd;
		this.updUsrId = updUsrId;
		this.ttlLssCmplCd = ttlLssCmplCd;
		this.csrNo = csrNo;
		this.ttlLssN3ptyTpCd = ttlLssN3ptyTpCd;
		this.dispNo = dispNo;
		this.dpcValAmt = dpcValAmt;
		this.ttlLssBilAmt = ttlLssBilAmt;
		this.vndrCustSeq = vndrCustSeq;
		this.eqTpszCd = eqTpszCd;
		this.ttlLssPlcNm = ttlLssPlcNm;
		this.creUsrId = creUsrId;
		this.eqOwnrFlg = eqOwnrFlg;
		this.mnrSwiftNo = mnrSwiftNo;
		this.ttlLssCfmFlg = ttlLssCfmFlg;
		this.lessorNm = lessorNm;
		this.ifTrcSeq = ifTrcSeq;
		this.tempSeq = tempSeq;
		this.bankAcctNo = bankAcctNo;
		this.currCd = currCd;
		this.ttlLssDtlStsCd = ttlLssDtlStsCd;
		this.payInvSeq = payInvSeq;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.creDt = creDt;
		this.ttlLssYdCd = ttlLssYdCd;
		this.ttlLssExpnAmt = ttlLssExpnAmt;
		this.ibflag = ibflag;
		this.rqstEqNo = rqstEqNo;
		this.n3ptyNo = n3ptyNo;
		this.ttlLssBilDt = ttlLssBilDt;
		this.invRgstNo = invRgstNo;
		this.updDt = updDt;
		this.ttlLssDtlSeq = ttlLssDtlSeq;
		this.eqKndCd = eqKndCd;
		this.ttlLssIncmAmt = ttlLssIncmAmt;
		this.invNo = invNo;
		this.ydCd = ydCd;
		this.mnrInvTpCd = mnrInvTpCd;
		this.dtlRmk = dtlRmk;
		this.respbOfcCd = respbOfcCd;
		this.payerName = payerName;
		this.crEndDt = crEndDt;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.revDirCd = revDirCd;
		this.slanCd = slanCd;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("payer_code", getPayerCode());
		this.hashColumns.put("ttl_lss_no", getTtlLssNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("ttl_lss_cmpl_dt", getTtlLssCmplDt());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("bank_nm", getBankNm());
		this.hashColumns.put("ar_chk_no", getArChkNo());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ttl_lss_cmpl_cd", getTtlLssCmplCd());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ttl_lss_n3pty_tp_cd", getTtlLssN3ptyTpCd());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("dpc_val_amt", getDpcValAmt());
		this.hashColumns.put("ttl_lss_bil_amt", getTtlLssBilAmt());
		this.hashColumns.put("vndr_cust_seq", getVndrCustSeq());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("ttl_lss_plc_nm", getTtlLssPlcNm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eq_ownr_flg", getEqOwnrFlg());
		this.hashColumns.put("mnr_swift_no", getMnrSwiftNo());
		this.hashColumns.put("ttl_lss_cfm_flg", getTtlLssCfmFlg());
		this.hashColumns.put("lessor_nm", getLessorNm());
		this.hashColumns.put("if_trc_seq", getIfTrcSeq());
		this.hashColumns.put("temp_seq", getTempSeq());
		this.hashColumns.put("bank_acct_no", getBankAcctNo());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ttl_lss_dtl_sts_cd", getTtlLssDtlStsCd());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("ttl_lss_yd_cd", getTtlLssYdCd());
		this.hashColumns.put("ttl_lss_expn_amt", getTtlLssExpnAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("ttl_lss_bil_dt", getTtlLssBilDt());
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ttl_lss_dtl_seq", getTtlLssDtlSeq());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("ttl_lss_incm_amt", getTtlLssIncmAmt());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("mnr_inv_tp_cd", getMnrInvTpCd());
		this.hashColumns.put("dtl_rmk", getDtlRmk());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("payer_name", getPayerName());
		this.hashColumns.put("cr_end_dt", getCrEndDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("payer_code", "payerCode");
		this.hashFields.put("ttl_lss_no", "ttlLssNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("ttl_lss_cmpl_dt", "ttlLssCmplDt");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("ar_chk_no", "arChkNo");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ttl_lss_cmpl_cd", "ttlLssCmplCd");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ttl_lss_n3pty_tp_cd", "ttlLssN3ptyTpCd");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("dpc_val_amt", "dpcValAmt");
		this.hashFields.put("ttl_lss_bil_amt", "ttlLssBilAmt");
		this.hashFields.put("vndr_cust_seq", "vndrCustSeq");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("ttl_lss_plc_nm", "ttlLssPlcNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eq_ownr_flg", "eqOwnrFlg");
		this.hashFields.put("mnr_swift_no", "mnrSwiftNo");
		this.hashFields.put("ttl_lss_cfm_flg", "ttlLssCfmFlg");
		this.hashFields.put("lessor_nm", "lessorNm");
		this.hashFields.put("if_trc_seq", "ifTrcSeq");
		this.hashFields.put("temp_seq", "tempSeq");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ttl_lss_dtl_sts_cd", "ttlLssDtlStsCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ttl_lss_yd_cd", "ttlLssYdCd");
		this.hashFields.put("ttl_lss_expn_amt", "ttlLssExpnAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("ttl_lss_bil_dt", "ttlLssBilDt");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ttl_lss_dtl_seq", "ttlLssDtlSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("ttl_lss_incm_amt", "ttlLssIncmAmt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("mnr_inv_tp_cd", "mnrInvTpCd");
		this.hashFields.put("dtl_rmk", "dtlRmk");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("payer_name", "payerName");
		this.hashFields.put("cr_end_dt", "crEndDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("slan_cd", "slanCd");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return payerCode
	 */
	public String getPayerCode() {
		return this.payerCode;
	}

	/**
	 * Column Info
	 * @return ttlLssNo
	 */
	public String getTtlLssNo() {
		return this.ttlLssNo;
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
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
	}

	/**
	 * Column Info
	 * @return ttlLssCmplDt
	 */
	public String getTtlLssCmplDt() {
		return this.ttlLssCmplDt;
	}

	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}

	/**
	 * Column Info
	 * @return bankNm
	 */
	public String getBankNm() {
		return this.bankNm;
	}

	/**
	 * Column Info
	 * @return arChkNo
	 */
	public String getArChkNo() {
		return this.arChkNo;
	}

	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
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
	 * @return ttlLssCmplCd
	 */
	public String getTtlLssCmplCd() {
		return this.ttlLssCmplCd;
	}

	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}

	/**
	 * Column Info
	 * @return ttlLssN3ptyTpCd
	 */
	public String getTtlLssN3ptyTpCd() {
		return this.ttlLssN3ptyTpCd;
	}

	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}

	/**
	 * Column Info
	 * @return dpcValAmt
	 */
	public String getDpcValAmt() {
		return this.dpcValAmt;
	}

	/**
	 * Column Info
	 * @return ttlLssBilAmt
	 */
	public String getTtlLssBilAmt() {
		return this.ttlLssBilAmt;
	}

	/**
	 * Column Info
	 * @return vndrCustSeq
	 */
	public String getVndrCustSeq() {
		return this.vndrCustSeq;
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
	 * @return ttlLssPlcNm
	 */
	public String getTtlLssPlcNm() {
		return this.ttlLssPlcNm;
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
	 * @return eqOwnrFlg
	 */
	public String getEqOwnrFlg() {
		return this.eqOwnrFlg;
	}

	/**
	 * Column Info
	 * @return mnrSwiftNo
	 */
	public String getMnrSwiftNo() {
		return this.mnrSwiftNo;
	}

	/**
	 * Column Info
	 * @return ttlLssCfmFlg
	 */
	public String getTtlLssCfmFlg() {
		return this.ttlLssCfmFlg;
	}

	/**
	 * Column Info
	 * @return lessorNm
	 */
	public String getLessorNm() {
		return this.lessorNm;
	}

	/**
	 * Column Info
	 * @return ifTrcSeq
	 */
	public String getIfTrcSeq() {
		return this.ifTrcSeq;
	}

	/**
	 * Column Info
	 * @return tempSeq
	 */
	public String getTempSeq() {
		return this.tempSeq;
	}

	/**
	 * Column Info
	 * @return bankAcctNo
	 */
	public String getBankAcctNo() {
		return this.bankAcctNo;
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
	 * @return ttlLssDtlStsCd
	 */
	public String getTtlLssDtlStsCd() {
		return this.ttlLssDtlStsCd;
	}

	/**
	 * Column Info
	 * @return payInvSeq
	 */
	public String getPayInvSeq() {
		return this.payInvSeq;
	}

	/**
	 * Column Info
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
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
	 * @return ttlLssYdCd
	 */
	public String getTtlLssYdCd() {
		return this.ttlLssYdCd;
	}

	/**
	 * Column Info
	 * @return ttlLssExpnAmt
	 */
	public String getTtlLssExpnAmt() {
		return this.ttlLssExpnAmt;
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
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
	}

	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}

	/**
	 * Column Info
	 * @return ttlLssBilDt
	 */
	public String getTtlLssBilDt() {
		return this.ttlLssBilDt;
	}

	/**
	 * Column Info
	 * @return invRgstNo
	 */
	public String getInvRgstNo() {
		return this.invRgstNo;
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
	 * @return ttlLssDtlSeq
	 */
	public String getTtlLssDtlSeq() {
		return this.ttlLssDtlSeq;
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
	 * @return ttlLssIncmAmt
	 */
	public String getTtlLssIncmAmt() {
		return this.ttlLssIncmAmt;
	}

	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return mnrInvTpCd
	 */
	public String getMnrInvTpCd() {
		return this.mnrInvTpCd;
	}

	/**
	 * Column Info
	 * @return dtlRmk
	 */
	public String getDtlRmk() {
		return this.dtlRmk;
	}

	/**
	 * Column Info
	 * @return respbOfcCd
	 */
	public String getRespbOfcCd() {
		return this.respbOfcCd;
	}

	/**
	 * Column Info
	 * @return payerName
	 */
	public String getPayerName() {
		return this.payerName;
	}

	/**
	 * Column Info
	 * @return crEndDt
	 */
	public String getCrEndDt() {
		return this.crEndDt;
	}


	/**
	 * Column Info
	 * @param payerCode
	 */
	public void setPayerCode(String payerCode) {
		this.payerCode = payerCode;
	}

	/**
	 * Column Info
	 * @param ttlLssNo
	 */
	public void setTtlLssNo(String ttlLssNo) {
		this.ttlLssNo = ttlLssNo;
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
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
	}

	/**
	 * Column Info
	 * @param ttlLssCmplDt
	 */
	public void setTtlLssCmplDt(String ttlLssCmplDt) {
		this.ttlLssCmplDt = ttlLssCmplDt;
	}

	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	/**
	 * Column Info
	 * @param bankNm
	 */
	public void setBankNm(String bankNm) {
		this.bankNm = bankNm;
	}

	/**
	 * Column Info
	 * @param arChkNo
	 */
	public void setArChkNo(String arChkNo) {
		this.arChkNo = arChkNo;
	}

	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
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
	 * @param ttlLssCmplCd
	 */
	public void setTtlLssCmplCd(String ttlLssCmplCd) {
		this.ttlLssCmplCd = ttlLssCmplCd;
	}

	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}

	/**
	 * Column Info
	 * @param ttlLssN3ptyTpCd
	 */
	public void setTtlLssN3ptyTpCd(String ttlLssN3ptyTpCd) {
		this.ttlLssN3ptyTpCd = ttlLssN3ptyTpCd;
	}

	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}

	/**
	 * Column Info
	 * @param dpcValAmt
	 */
	public void setDpcValAmt(String dpcValAmt) {
		this.dpcValAmt = dpcValAmt;
	}

	/**
	 * Column Info
	 * @param ttlLssBilAmt
	 */
	public void setTtlLssBilAmt(String ttlLssBilAmt) {
		this.ttlLssBilAmt = ttlLssBilAmt;
	}

	/**
	 * Column Info
	 * @param vndrCustSeq
	 */
	public void setVndrCustSeq(String vndrCustSeq) {
		this.vndrCustSeq = vndrCustSeq;
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
	 * @param ttlLssPlcNm
	 */
	public void setTtlLssPlcNm(String ttlLssPlcNm) {
		this.ttlLssPlcNm = ttlLssPlcNm;
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
	 * @param eqOwnrFlg
	 */
	public void setEqOwnrFlg(String eqOwnrFlg) {
		this.eqOwnrFlg = eqOwnrFlg;
	}

	/**
	 * Column Info
	 * @param mnrSwiftNo
	 */
	public void setMnrSwiftNo(String mnrSwiftNo) {
		this.mnrSwiftNo = mnrSwiftNo;
	}

	/**
	 * Column Info
	 * @param ttlLssCfmFlg
	 */
	public void setTtlLssCfmFlg(String ttlLssCfmFlg) {
		this.ttlLssCfmFlg = ttlLssCfmFlg;
	}

	/**
	 * Column Info
	 * @param lessorNm
	 */
	public void setLessorNm(String lessorNm) {
		this.lessorNm = lessorNm;
	}

	/**
	 * Column Info
	 * @param ifTrcSeq
	 */
	public void setIfTrcSeq(String ifTrcSeq) {
		this.ifTrcSeq = ifTrcSeq;
	}

	/**
	 * Column Info
	 * @param tempSeq
	 */
	public void setTempSeq(String tempSeq) {
		this.tempSeq = tempSeq;
	}

	/**
	 * Column Info
	 * @param bankAcctNo
	 */
	public void setBankAcctNo(String bankAcctNo) {
		this.bankAcctNo = bankAcctNo;
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
	 * @param ttlLssDtlStsCd
	 */
	public void setTtlLssDtlStsCd(String ttlLssDtlStsCd) {
		this.ttlLssDtlStsCd = ttlLssDtlStsCd;
	}

	/**
	 * Column Info
	 * @param payInvSeq
	 */
	public void setPayInvSeq(String payInvSeq) {
		this.payInvSeq = payInvSeq;
	}

	/**
	 * Column Info
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
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
	 * @param ttlLssYdCd
	 */
	public void setTtlLssYdCd(String ttlLssYdCd) {
		this.ttlLssYdCd = ttlLssYdCd;
	}

	/**
	 * Column Info
	 * @param ttlLssExpnAmt
	 */
	public void setTtlLssExpnAmt(String ttlLssExpnAmt) {
		this.ttlLssExpnAmt = ttlLssExpnAmt;
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
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}

	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}

	/**
	 * Column Info
	 * @param ttlLssBilDt
	 */
	public void setTtlLssBilDt(String ttlLssBilDt) {
		this.ttlLssBilDt = ttlLssBilDt;
	}

	/**
	 * Column Info
	 * @param invRgstNo
	 */
	public void setInvRgstNo(String invRgstNo) {
		this.invRgstNo = invRgstNo;
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
	 * @param ttlLssDtlSeq
	 */
	public void setTtlLssDtlSeq(String ttlLssDtlSeq) {
		this.ttlLssDtlSeq = ttlLssDtlSeq;
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
	 * @param ttlLssIncmAmt
	 */
	public void setTtlLssIncmAmt(String ttlLssIncmAmt) {
		this.ttlLssIncmAmt = ttlLssIncmAmt;
	}

	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param mnrInvTpCd
	 */
	public void setMnrInvTpCd(String mnrInvTpCd) {
		this.mnrInvTpCd = mnrInvTpCd;
	}

	/**
	 * Column Info
	 * @param dtlRmk
	 */
	public void setDtlRmk(String dtlRmk) {
		this.dtlRmk = dtlRmk;
	}

	/**
	 * Column Info
	 * @param respbOfcCd
	 */
	public void setRespbOfcCd(String respbOfcCd) {
		this.respbOfcCd = respbOfcCd;
	}

	/**
	 * Column Info
	 * @param payerName
	 */
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}

	/**
	 * Column Info
	 * @param crEndDt
	 */
	public void setCrEndDt(String crEndDt) {
		this.crEndDt = crEndDt;
	}
	
	public String getVslCd() {
		return vslCd;
	}

	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	public String getSkdVoyNo() {
		return skdVoyNo;
	}

	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	public String getSkdDirCd() {
		return skdDirCd;
	}

	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}

	public String getRevDirCd() {
		return revDirCd;
	}

	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
	}

	public String getSlanCd() {
		return slanCd;
	}

	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
		setPayerCode(JSPUtil.getParameter(request, prefix + "payer_code", ""));
		setTtlLssNo(JSPUtil.getParameter(request, prefix + "ttl_lss_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, prefix + "mnr_prnr_seq", ""));
		setTtlLssCmplDt(JSPUtil.getParameter(request, prefix + "ttl_lss_cmpl_dt", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setBankNm(JSPUtil.getParameter(request, prefix + "bank_nm", ""));
		setArChkNo(JSPUtil.getParameter(request, prefix + "ar_chk_no", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setTtlLssCmplCd(JSPUtil.getParameter(request, prefix + "ttl_lss_cmpl_cd", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setTtlLssN3ptyTpCd(JSPUtil.getParameter(request, prefix + "ttl_lss_n3pty_tp_cd", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setDpcValAmt(JSPUtil.getParameter(request, prefix + "dpc_val_amt", ""));
		setTtlLssBilAmt(JSPUtil.getParameter(request, prefix + "ttl_lss_bil_amt", ""));
		setVndrCustSeq(JSPUtil.getParameter(request, prefix + "vndr_cust_seq", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setTtlLssPlcNm(JSPUtil.getParameter(request, prefix + "ttl_lss_plc_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEqOwnrFlg(JSPUtil.getParameter(request, prefix + "eq_ownr_flg", ""));
		setMnrSwiftNo(JSPUtil.getParameter(request, prefix + "mnr_swift_no", ""));
		setTtlLssCfmFlg(JSPUtil.getParameter(request, prefix + "ttl_lss_cfm_flg", ""));
		setLessorNm(JSPUtil.getParameter(request, prefix + "lessor_nm", ""));
		setIfTrcSeq(JSPUtil.getParameter(request, prefix + "if_trc_seq", ""));
		setTempSeq(JSPUtil.getParameter(request, prefix + "temp_seq", ""));
		setBankAcctNo(JSPUtil.getParameter(request, prefix + "bank_acct_no", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setTtlLssDtlStsCd(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_sts_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request, prefix + "pay_inv_seq", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, prefix + "mnr_prnr_cnt_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setTtlLssYdCd(JSPUtil.getParameter(request, prefix + "ttl_lss_yd_cd", ""));
		setTtlLssExpnAmt(JSPUtil.getParameter(request, prefix + "ttl_lss_expn_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
		setTtlLssBilDt(JSPUtil.getParameter(request, prefix + "ttl_lss_bil_dt", ""));
		setInvRgstNo(JSPUtil.getParameter(request, prefix + "inv_rgst_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTtlLssDtlSeq(JSPUtil.getParameter(request, prefix + "ttl_lss_dtl_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setTtlLssIncmAmt(JSPUtil.getParameter(request, prefix + "ttl_lss_incm_amt", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setMnrInvTpCd(JSPUtil.getParameter(request, prefix + "mnr_inv_tp_cd", ""));
		setDtlRmk(JSPUtil.getParameter(request, prefix + "dtl_rmk", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setPayerName(JSPUtil.getParameter(request, prefix + "payer_name", ""));
		setCrEndDt(JSPUtil.getParameter(request, prefix + "cr_end_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrTtlLssRqstDtlVO[]
	 */
	public CustomMnrTtlLssRqstDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustomMnrTtlLssRqstDtlVO[]
	 */
	public CustomMnrTtlLssRqstDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrTtlLssRqstDtlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] payerCode = (JSPUtil.getParameter(request, prefix	+ "payer_code", length));
			String[] ttlLssNo = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] ttlLssCmplDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cmpl_dt", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] bankNm = (JSPUtil.getParameter(request, prefix	+ "bank_nm", length));
			String[] arChkNo = (JSPUtil.getParameter(request, prefix	+ "ar_chk_no", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ttlLssCmplCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cmpl_cd", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] ttlLssN3ptyTpCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_n3pty_tp_cd", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] dpcValAmt = (JSPUtil.getParameter(request, prefix	+ "dpc_val_amt", length));
			String[] ttlLssBilAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_bil_amt", length));
			String[] vndrCustSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_seq", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] ttlLssPlcNm = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_plc_nm", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] eqOwnrFlg = (JSPUtil.getParameter(request, prefix	+ "eq_ownr_flg", length));
			String[] mnrSwiftNo = (JSPUtil.getParameter(request, prefix	+ "mnr_swift_no", length));
			String[] ttlLssCfmFlg = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_cfm_flg", length));
			String[] lessorNm = (JSPUtil.getParameter(request, prefix	+ "lessor_nm", length));
			String[] ifTrcSeq = (JSPUtil.getParameter(request, prefix	+ "if_trc_seq", length));
			String[] tempSeq = (JSPUtil.getParameter(request, prefix	+ "temp_seq", length));
			String[] bankAcctNo = (JSPUtil.getParameter(request, prefix	+ "bank_acct_no", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] ttlLssDtlStsCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_sts_cd", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ttlLssYdCd = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_yd_cd", length));
			String[] ttlLssExpnAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_expn_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] ttlLssBilDt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_bil_dt", length));
			String[] invRgstNo = (JSPUtil.getParameter(request, prefix	+ "inv_rgst_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ttlLssDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_dtl_seq", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] ttlLssIncmAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_lss_incm_amt", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] mnrInvTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inv_tp_cd", length));
			String[] dtlRmk = (JSPUtil.getParameter(request, prefix	+ "dtl_rmk", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] payerName = (JSPUtil.getParameter(request, prefix	+ "payer_name", length));
			String[] crEndDt = (JSPUtil.getParameter(request, prefix	+ "cr_end_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skdDirCd", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "revDirCd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slanCd", length));

			for (int i = 0; i < length; i++) {
				model = new CustomMnrTtlLssRqstDtlVO();
				if (payerCode[i] != null)
					model.setPayerCode(payerCode[i]);
				if (ttlLssNo[i] != null)
					model.setTtlLssNo(ttlLssNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (ttlLssCmplDt[i] != null)
					model.setTtlLssCmplDt(ttlLssCmplDt[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (bankNm[i] != null)
					model.setBankNm(bankNm[i]);
				if (arChkNo[i] != null)
					model.setArChkNo(arChkNo[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ttlLssCmplCd[i] != null)
					model.setTtlLssCmplCd(ttlLssCmplCd[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (ttlLssN3ptyTpCd[i] != null)
					model.setTtlLssN3ptyTpCd(ttlLssN3ptyTpCd[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (dpcValAmt[i] != null)
					model.setDpcValAmt(dpcValAmt[i]);
				if (ttlLssBilAmt[i] != null)
					model.setTtlLssBilAmt(ttlLssBilAmt[i]);
				if (vndrCustSeq[i] != null)
					model.setVndrCustSeq(vndrCustSeq[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (ttlLssPlcNm[i] != null)
					model.setTtlLssPlcNm(ttlLssPlcNm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (eqOwnrFlg[i] != null)
					model.setEqOwnrFlg(eqOwnrFlg[i]);
				if (mnrSwiftNo[i] != null)
					model.setMnrSwiftNo(mnrSwiftNo[i]);
				if (ttlLssCfmFlg[i] != null)
					model.setTtlLssCfmFlg(ttlLssCfmFlg[i]);
				if (lessorNm[i] != null)
					model.setLessorNm(lessorNm[i]);
				if (ifTrcSeq[i] != null)
					model.setIfTrcSeq(ifTrcSeq[i]);
				if (tempSeq[i] != null)
					model.setTempSeq(tempSeq[i]);
				if (bankAcctNo[i] != null)
					model.setBankAcctNo(bankAcctNo[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (ttlLssDtlStsCd[i] != null)
					model.setTtlLssDtlStsCd(ttlLssDtlStsCd[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ttlLssYdCd[i] != null)
					model.setTtlLssYdCd(ttlLssYdCd[i]);
				if (ttlLssExpnAmt[i] != null)
					model.setTtlLssExpnAmt(ttlLssExpnAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (ttlLssBilDt[i] != null)
					model.setTtlLssBilDt(ttlLssBilDt[i]);
				if (invRgstNo[i] != null)
					model.setInvRgstNo(invRgstNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ttlLssDtlSeq[i] != null)
					model.setTtlLssDtlSeq(ttlLssDtlSeq[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (ttlLssIncmAmt[i] != null)
					model.setTtlLssIncmAmt(ttlLssIncmAmt[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (mnrInvTpCd[i] != null)
					model.setMnrInvTpCd(mnrInvTpCd[i]);
				if (dtlRmk[i] != null)
					model.setDtlRmk(dtlRmk[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (payerName[i] != null)
					model.setPayerName(payerName[i]);
				if (crEndDt[i] != null)
					model.setCrEndDt(crEndDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrTtlLssRqstDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrTtlLssRqstDtlVO[]
	 */
	public CustomMnrTtlLssRqstDtlVO[] getCustomMnrTtlLssRqstDtlVOs(){
		CustomMnrTtlLssRqstDtlVO[] vos = (CustomMnrTtlLssRqstDtlVO[])models.toArray(new CustomMnrTtlLssRqstDtlVO[models.size()]);
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
		this.payerCode = this.payerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssNo = this.ttlLssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCmplDt = this.ttlLssCmplDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm = this.bankNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arChkNo = this.arChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCmplCd = this.ttlLssCmplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssN3ptyTpCd = this.ttlLssN3ptyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpcValAmt = this.dpcValAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssBilAmt = this.ttlLssBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustSeq = this.vndrCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssPlcNm = this.ttlLssPlcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOwnrFlg = this.eqOwnrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrSwiftNo = this.mnrSwiftNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCfmFlg = this.ttlLssCfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorNm = this.lessorNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifTrcSeq = this.ifTrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempSeq = this.tempSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo = this.bankAcctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlStsCd = this.ttlLssDtlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq = this.payInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssYdCd = this.ttlLssYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssExpnAmt = this.ttlLssExpnAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssBilDt = this.ttlLssBilDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo = this.invRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlSeq = this.ttlLssDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssIncmAmt = this.ttlLssIncmAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInvTpCd = this.mnrInvTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlRmk = this.dtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payerName = this.payerName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crEndDt = this.crEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
