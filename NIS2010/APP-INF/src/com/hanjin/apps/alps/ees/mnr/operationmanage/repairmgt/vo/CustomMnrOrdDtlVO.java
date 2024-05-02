/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomMnrOrdDtlVO.java
*@FileTitle : CustomMnrOrdDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.22
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.22 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo;

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
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrOrdDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrOrdDtlVO> models = new ArrayList<CustomMnrOrdDtlVO>();
	
	/* Column Info */
	private String mnrHngrTrfOtrDesc = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String mnrHngrBarTpCd = null;
	/* Column Info */
	private String mnrLostHngrQty = null;
	/* Column Info */
	private String rprOffhFlg = null;
	/* Column Info */
	private String n3ptyBilTtlAmt = null;
	/* Column Info */
	private String mnrDispHngrQty = null;
	/* Column Info */
	private String sprPrtUcAmt = null;
	/* Column Info */
	private String rprRqstSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ordDtlRmk = null;
	/* Column Info */
	private String mnrOrgHngrBarTpCd = null;
	/* Column Info */
	private String mnrHngrFlgDt = null;
	/* Column Info */
	private String mnrExpnDtlNm = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String slsTaxAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String sprPrtUtTpNm = null;
	/* Column Info */
	private String mnrHngrDmgQty = null;
	/* Column Info */
	private String rprRsltDt = null;
	/* Column Info */
	private String recentRprQty = null;
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String rprRqstVerNo = null;
	/* Column Info */
	private String barIfChk = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String sprPrtNo = null;
	/* Column Info */
	private String mnrRtTpCd = null;
	/* Column Info */
	private String sprPrtNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String mnrHngrDtlOffrDesc = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrHngrFlgYdCd = null;
	/* Column Info */
	private String ordDtlSeq = null;
	/* Column Info */
	private String costDtlCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String actInvtQty = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String mnrHngrRckCd = null;
	/* Column Info */
	private String mnrHngrTrfCd = null;
	/* Column Info */
	private String envChgTax = null;
	/* Column Info */
	private String idaSacCd = null;
	/* Column Info */
	private String idaCgstRto = null;
	/* Column Info */
	private String idaSgstRto = null;
	/* Column Info */
	private String idaIgstRto = null;
	/* Column Info */
	private String idaUgstRto = null;
	/* Column Info */
	private String idaCgstAmt = null;
	/* Column Info */
	private String idaSgstAmt = null;
	/* Column Info */
	private String idaIgstAmt = null;
	/* Column Info */
	private String idaUgstAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrOrdDtlVO() {}

	public CustomMnrOrdDtlVO(String ibflag, String pagerows, String recentRprQty, String mnrVrfyTpCd, String payInvSeq, String rprRqstVerNo, String barIfChk, String rqstRefNo, String creDt, String sprPrtNo, String mnrRtTpCd, String sprPrtNm, String mnrOrdOfcCtyCd, String eqNo, String costCd, String costAmt, String acctCd, String mnrHngrBarTpCd, String invAmt, String rprQty, String n3ptyBilTtlAmt, String rprOffhFlg, String rprRqstSeq, String sprPrtUcAmt, String updUsrId, String n3ptyFlg, String updDt, String mnrHngrFlgYdCd, String ordDtlRmk, String ordDtlSeq, String mnrOrgHngrBarTpCd, String costDtlCd, String eqKndCd, String mnrHngrFlgDt, String mnrExpnDtlNm, String bzcAmt, String eqTpszCd, String invNo, String slsTaxAmt, String creUsrId, String mnrOrdSeq, String ydCd, String mnrHngrRckCd, String fileSeq, String sprPrtUtTpNm, String rprRsltDt, String mnrHngrDtlOffrDesc, String mnrHngrTrfCd, String mnrHngrTrfOtrDesc, String mnrHngrDmgQty, String actInvtQty, String mnrLostHngrQty, String mnrDispHngrQty, String envChgTax, String idaSacCd, String idaCgstRto, String idaSgstRto, String idaIgstRto, String idaUgstRto, String idaCgstAmt, String idaSgstAmt, String idaIgstAmt, String idaUgstAmt) {
		this.mnrHngrTrfOtrDesc = mnrHngrTrfOtrDesc;
		this.pagerows = pagerows;
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.costCd = costCd;
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
		this.mnrLostHngrQty = mnrLostHngrQty;
		this.rprOffhFlg = rprOffhFlg;
		this.n3ptyBilTtlAmt = n3ptyBilTtlAmt;
		this.mnrDispHngrQty = mnrDispHngrQty;
		this.sprPrtUcAmt = sprPrtUcAmt;
		this.rprRqstSeq = rprRqstSeq;
		this.updUsrId = updUsrId;
		this.ordDtlRmk = ordDtlRmk;
		this.mnrOrgHngrBarTpCd = mnrOrgHngrBarTpCd;
		this.mnrHngrFlgDt = mnrHngrFlgDt;
		this.mnrExpnDtlNm = mnrExpnDtlNm;
		this.eqTpszCd = eqTpszCd;
		this.slsTaxAmt = slsTaxAmt;
		this.creUsrId = creUsrId;
		this.fileSeq = fileSeq;
		this.sprPrtUtTpNm = sprPrtUtTpNm;
		this.mnrHngrDmgQty = mnrHngrDmgQty;
		this.rprRsltDt = rprRsltDt;
		this.recentRprQty = recentRprQty;
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.payInvSeq = payInvSeq;
		this.rprRqstVerNo = rprRqstVerNo;
		this.barIfChk = barIfChk;
		this.rqstRefNo = rqstRefNo;
		this.creDt = creDt;
		this.sprPrtNo = sprPrtNo;
		this.mnrRtTpCd = mnrRtTpCd;
		this.sprPrtNm = sprPrtNm;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.costAmt = costAmt;
		this.acctCd = acctCd;
		this.rprQty = rprQty;
		this.invAmt = invAmt;
		this.mnrHngrDtlOffrDesc = mnrHngrDtlOffrDesc;
		this.n3ptyFlg = n3ptyFlg;
		this.updDt = updDt;
		this.mnrHngrFlgYdCd = mnrHngrFlgYdCd;
		this.ordDtlSeq = ordDtlSeq;
		this.costDtlCd = costDtlCd;
		this.eqKndCd = eqKndCd;
		this.bzcAmt = bzcAmt;
		this.actInvtQty = actInvtQty;
		this.invNo = invNo;
		this.mnrOrdSeq = mnrOrdSeq;
		this.ydCd = ydCd;
		this.mnrHngrRckCd = mnrHngrRckCd;
		this.mnrHngrTrfCd = mnrHngrTrfCd;
		this.envChgTax = envChgTax;
		this.idaCgstRto = idaCgstRto;
		this.idaSgstRto = idaSgstRto;
		this.idaIgstRto = idaIgstRto;
		this.idaUgstRto = idaUgstRto;
		this.idaCgstAmt = idaCgstAmt;
		this.idaSgstAmt = idaSgstAmt;
		this.idaIgstAmt = idaIgstAmt;
		this.idaUgstAmt = idaUgstAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_hngr_trf_otr_desc", getMnrHngrTrfOtrDesc());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("mnr_hngr_bar_tp_cd", getMnrHngrBarTpCd());
		this.hashColumns.put("mnr_lost_hngr_qty", getMnrLostHngrQty());
		this.hashColumns.put("rpr_offh_flg", getRprOffhFlg());
		this.hashColumns.put("n3pty_bil_ttl_amt", getN3ptyBilTtlAmt());
		this.hashColumns.put("mnr_disp_hngr_qty", getMnrDispHngrQty());
		this.hashColumns.put("spr_prt_uc_amt", getSprPrtUcAmt());
		this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("ord_dtl_rmk", getOrdDtlRmk());
		this.hashColumns.put("mnr_org_hngr_bar_tp_cd", getMnrOrgHngrBarTpCd());
		this.hashColumns.put("mnr_hngr_flg_dt", getMnrHngrFlgDt());
		this.hashColumns.put("mnr_expn_dtl_nm", getMnrExpnDtlNm());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("sls_tax_amt", getSlsTaxAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("spr_prt_ut_tp_nm", getSprPrtUtTpNm());
		this.hashColumns.put("mnr_hngr_dmg_qty", getMnrHngrDmgQty());
		this.hashColumns.put("rpr_rslt_dt", getRprRsltDt());
		this.hashColumns.put("recent_rpr_qty", getRecentRprQty());
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("rpr_rqst_ver_no", getRprRqstVerNo());
		this.hashColumns.put("bar_if_chk", getBarIfChk());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("spr_prt_no", getSprPrtNo());
		this.hashColumns.put("mnr_rt_tp_cd", getMnrRtTpCd());
		this.hashColumns.put("spr_prt_nm", getSprPrtNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("mnr_hngr_dtl_offr_desc", getMnrHngrDtlOffrDesc());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_hngr_flg_yd_cd", getMnrHngrFlgYdCd());
		this.hashColumns.put("ord_dtl_seq", getOrdDtlSeq());
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("act_invt_qty", getActInvtQty());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("mnr_hngr_rck_cd", getMnrHngrRckCd());
		this.hashColumns.put("mnr_hngr_trf_cd", getMnrHngrTrfCd());
		this.hashColumns.put("env_chg_tax", getEnvChgTax());
		this.hashColumns.put("ida_sac_cd", getIdaSacCd());
		this.hashColumns.put("ida_cgst_rto", getIdaCgstRto());
		this.hashColumns.put("ida_sgst_rto", getIdaSgstRto());
		this.hashColumns.put("ida_igst_rto", getIdaIgstRto());
		this.hashColumns.put("ida_ugst_rto", getIdaUgstRto());
		this.hashColumns.put("ida_cgst_amt", getIdaCgstAmt());
		this.hashColumns.put("ida_sgst_amt", getIdaSgstAmt());
		this.hashColumns.put("ida_igst_amt", getIdaIgstAmt());
		this.hashColumns.put("ida_ugst_amt", getIdaUgstAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_hngr_trf_otr_desc", "mnrHngrTrfOtrDesc");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("mnr_hngr_bar_tp_cd", "mnrHngrBarTpCd");
		this.hashFields.put("mnr_lost_hngr_qty", "mnrLostHngrQty");
		this.hashFields.put("rpr_offh_flg", "rprOffhFlg");
		this.hashFields.put("n3pty_bil_ttl_amt", "n3ptyBilTtlAmt");
		this.hashFields.put("mnr_disp_hngr_qty", "mnrDispHngrQty");
		this.hashFields.put("spr_prt_uc_amt", "sprPrtUcAmt");
		this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ord_dtl_rmk", "ordDtlRmk");
		this.hashFields.put("mnr_org_hngr_bar_tp_cd", "mnrOrgHngrBarTpCd");
		this.hashFields.put("mnr_hngr_flg_dt", "mnrHngrFlgDt");
		this.hashFields.put("mnr_expn_dtl_nm", "mnrExpnDtlNm");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("sls_tax_amt", "slsTaxAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("spr_prt_ut_tp_nm", "sprPrtUtTpNm");
		this.hashFields.put("mnr_hngr_dmg_qty", "mnrHngrDmgQty");
		this.hashFields.put("rpr_rslt_dt", "rprRsltDt");
		this.hashFields.put("recent_rpr_qty", "recentRprQty");
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("rpr_rqst_ver_no", "rprRqstVerNo");
		this.hashFields.put("bar_if_chk", "barIfChk");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("spr_prt_no", "sprPrtNo");
		this.hashFields.put("mnr_rt_tp_cd", "mnrRtTpCd");
		this.hashFields.put("spr_prt_nm", "sprPrtNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("mnr_hngr_dtl_offr_desc", "mnrHngrDtlOffrDesc");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_hngr_flg_yd_cd", "mnrHngrFlgYdCd");
		this.hashFields.put("ord_dtl_seq", "ordDtlSeq");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("act_invt_qty", "actInvtQty");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("mnr_hngr_rck_cd", "mnrHngrRckCd");
		this.hashFields.put("mnr_hngr_trf_cd", "mnrHngrTrfCd");
		this.hashFields.put("env_chg_tax", "envChgTax");
		this.hashFields.put("ida_sac_cd", "idaSacCd");
		this.hashFields.put("ida_cgst_rto", "idaCgstRto");
		this.hashFields.put("ida_sgst_rto", "idaSgstRto");
		this.hashFields.put("ida_igst_rto", "idaIgstRto");
		this.hashFields.put("ida_ugst_rto", "idaUgstRto");
		this.hashFields.put("ida_cgst_amt", "idaCgstAmt");
		this.hashFields.put("ida_sgst_amt", "idaSgstAmt");
		this.hashFields.put("ida_igst_amt", "idaIgstAmt");
		this.hashFields.put("ida_ugst_amt", "idaUgstAmt");
		return this.hashFields;
	}
	
	
	/**
	 * @return the idaSacCd
	 */
	public String getIdaSacCd() {
		return idaSacCd;
	}

	/**
	 * @param idaSacCd the idaSacCd to set
	 */
	public void setIdaSacCd(String idaSacCd) {
		this.idaSacCd = idaSacCd;
	}

	/**
	 * @return the idaCgstRto
	 */
	public String getIdaCgstRto() {
		return idaCgstRto;
	}

	/**
	 * @param idaCgstRto the idaCgstRto to set
	 */
	public void setIdaCgstRto(String idaCgstRto) {
		this.idaCgstRto = idaCgstRto;
	}

	/**
	 * @return the idaSgstRto
	 */
	public String getIdaSgstRto() {
		return idaSgstRto;
	}

	/**
	 * @param idaSgstRto the idaSgstRto to set
	 */
	public void setIdaSgstRto(String idaSgstRto) {
		this.idaSgstRto = idaSgstRto;
	}

	/**
	 * @return the idaIgstRto
	 */
	public String getIdaIgstRto() {
		return idaIgstRto;
	}

	/**
	 * @param idaIgstRto the idaIgstRto to set
	 */
	public void setIdaIgstRto(String idaIgstRto) {
		this.idaIgstRto = idaIgstRto;
	}

	/**
	 * @return the idaUgstRto
	 */
	public String getIdaUgstRto() {
		return idaUgstRto;
	}

	/**
	 * @param idaUgstRto the idaUgstRto to set
	 */
	public void setIdaUgstRto(String idaUgstRto) {
		this.idaUgstRto = idaUgstRto;
	}

	/**
	 * @return the idaCgstAmt
	 */
	public String getIdaCgstAmt() {
		return idaCgstAmt;
	}

	/**
	 * @param idaCgstAmt the idaCgstAmt to set
	 */
	public void setIdaCgstAmt(String idaCgstAmt) {
		this.idaCgstAmt = idaCgstAmt;
	}

	/**
	 * @return the idaSgstAmt
	 */
	public String getIdaSgstAmt() {
		return idaSgstAmt;
	}

	/**
	 * @param idaSgstAmt the idaSgstAmt to set
	 */
	public void setIdaSgstAmt(String idaSgstAmt) {
		this.idaSgstAmt = idaSgstAmt;
	}

	/**
	 * @return the idaIgstAmt
	 */
	public String getIdaIgstAmt() {
		return idaIgstAmt;
	}

	/**
	 * @param idaIgstAmt the idaIgstAmt to set
	 */
	public void setIdaIgstAmt(String idaIgstAmt) {
		this.idaIgstAmt = idaIgstAmt;
	}

	/**
	 * @return the idaUgstAmt
	 */
	public String getIdaUgstAmt() {
		return idaUgstAmt;
	}

	/**
	 * @param idaUgstAmt the idaUgstAmt to set
	 */
	public void setIdaUgstAmt(String idaUgstAmt) {
		this.idaUgstAmt = idaUgstAmt;
	}

	/**
	 * Column Info
	 * @return mnrHngrTrfOtrDesc
	 */
	public String getMnrHngrTrfOtrDesc() {
		return this.mnrHngrTrfOtrDesc;
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
	 * @return mnrOrdOfcCtyCd
	 */
	public String getMnrOrdOfcCtyCd() {
		return this.mnrOrdOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrBarTpCd
	 */
	public String getMnrHngrBarTpCd() {
		return this.mnrHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrLostHngrQty
	 */
	public String getMnrLostHngrQty() {
		return this.mnrLostHngrQty;
	}
	
	/**
	 * Column Info
	 * @return rprOffhFlg
	 */
	public String getRprOffhFlg() {
		return this.rprOffhFlg;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTtlAmt
	 */
	public String getN3ptyBilTtlAmt() {
		return this.n3ptyBilTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return mnrDispHngrQty
	 */
	public String getMnrDispHngrQty() {
		return this.mnrDispHngrQty;
	}
	
	/**
	 * Column Info
	 * @return sprPrtUcAmt
	 */
	public String getSprPrtUcAmt() {
		return this.sprPrtUcAmt;
	}
	
	/**
	 * Column Info
	 * @return rprRqstSeq
	 */
	public String getRprRqstSeq() {
		return this.rprRqstSeq;
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
	 * @return ordDtlRmk
	 */
	public String getOrdDtlRmk() {
		return this.ordDtlRmk;
	}
	
	/**
	 * Column Info
	 * @return mnrOrgHngrBarTpCd
	 */
	public String getMnrOrgHngrBarTpCd() {
		return this.mnrOrgHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrFlgDt
	 */
	public String getMnrHngrFlgDt() {
		return this.mnrHngrFlgDt;
	}
	
	/**
	 * Column Info
	 * @return mnrExpnDtlNm
	 */
	public String getMnrExpnDtlNm() {
		return this.mnrExpnDtlNm;
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
	 * @return slsTaxAmt
	 */
	public String getSlsTaxAmt() {
		return this.slsTaxAmt;
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
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
	}
	
	/**
	 * Column Info
	 * @return sprPrtUtTpNm
	 */
	public String getSprPrtUtTpNm() {
		return this.sprPrtUtTpNm;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrDmgQty
	 */
	public String getMnrHngrDmgQty() {
		return this.mnrHngrDmgQty;
	}
	
	/**
	 * Column Info
	 * @return rprRsltDt
	 */
	public String getRprRsltDt() {
		return this.rprRsltDt;
	}
	
	/**
	 * Column Info
	 * @return recentRprQty
	 */
	public String getRecentRprQty() {
		return this.recentRprQty;
	}
	
	/**
	 * Column Info
	 * @return mnrVrfyTpCd
	 */
	public String getMnrVrfyTpCd() {
		return this.mnrVrfyTpCd;
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
	 * @return rprRqstVerNo
	 */
	public String getRprRqstVerNo() {
		return this.rprRqstVerNo;
	}
	
	/**
	 * Column Info
	 * @return barIfChk
	 */
	public String getBarIfChk() {
		return this.barIfChk;
	}
	
	/**
	 * Column Info
	 * @return rqstRefNo
	 */
	public String getRqstRefNo() {
		return this.rqstRefNo;
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
	 * @return sprPrtNo
	 */
	public String getSprPrtNo() {
		return this.sprPrtNo;
	}
	
	/**
	 * Column Info
	 * @return mnrRtTpCd
	 */
	public String getMnrRtTpCd() {
		return this.mnrRtTpCd;
	}
	
	/**
	 * Column Info
	 * @return sprPrtNm
	 */
	public String getSprPrtNm() {
		return this.sprPrtNm;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return costAmt
	 */
	public String getCostAmt() {
		return this.costAmt;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return rprQty
	 */
	public String getRprQty() {
		return this.rprQty;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrDtlOffrDesc
	 */
	public String getMnrHngrDtlOffrDesc() {
		return this.mnrHngrDtlOffrDesc;
	}
	
	/**
	 * Column Info
	 * @return n3ptyFlg
	 */
	public String getN3ptyFlg() {
		return this.n3ptyFlg;
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
	 * @return mnrHngrFlgYdCd
	 */
	public String getMnrHngrFlgYdCd() {
		return this.mnrHngrFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @return ordDtlSeq
	 */
	public String getOrdDtlSeq() {
		return this.ordDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return costDtlCd
	 */
	public String getCostDtlCd() {
		return this.costDtlCd;
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
	 * @return bzcAmt
	 */
	public String getBzcAmt() {
		return this.bzcAmt;
	}
	
	/**
	 * Column Info
	 * @return actInvtQty
	 */
	public String getActInvtQty() {
		return this.actInvtQty;
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
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
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
	 * @return mnrHngrRckCd
	 */
	public String getMnrHngrRckCd() {
		return this.mnrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @return mnrHngrTrfCd
	 */
	public String getMnrHngrTrfCd() {
		return this.mnrHngrTrfCd;
	}
	
	/**
	 * Column Info
	 * @return envChgTax
	 */
	public String getEnvChgTax() {
		return this.envChgTax;
	}
	

	/**
	 * Column Info
	 * @param mnrHngrTrfOtrDesc
	 */
	public void setMnrHngrTrfOtrDesc(String mnrHngrTrfOtrDesc) {
		this.mnrHngrTrfOtrDesc = mnrHngrTrfOtrDesc;
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
	 * @param mnrOrdOfcCtyCd
	 */
	public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrBarTpCd
	 */
	public void setMnrHngrBarTpCd(String mnrHngrBarTpCd) {
		this.mnrHngrBarTpCd = mnrHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrLostHngrQty
	 */
	public void setMnrLostHngrQty(String mnrLostHngrQty) {
		this.mnrLostHngrQty = mnrLostHngrQty;
	}
	
	/**
	 * Column Info
	 * @param rprOffhFlg
	 */
	public void setRprOffhFlg(String rprOffhFlg) {
		this.rprOffhFlg = rprOffhFlg;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTtlAmt
	 */
	public void setN3ptyBilTtlAmt(String n3ptyBilTtlAmt) {
		this.n3ptyBilTtlAmt = n3ptyBilTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param mnrDispHngrQty
	 */
	public void setMnrDispHngrQty(String mnrDispHngrQty) {
		this.mnrDispHngrQty = mnrDispHngrQty;
	}
	
	/**
	 * Column Info
	 * @param sprPrtUcAmt
	 */
	public void setSprPrtUcAmt(String sprPrtUcAmt) {
		this.sprPrtUcAmt = sprPrtUcAmt;
	}
	
	/**
	 * Column Info
	 * @param rprRqstSeq
	 */
	public void setRprRqstSeq(String rprRqstSeq) {
		this.rprRqstSeq = rprRqstSeq;
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
	 * @param ordDtlRmk
	 */
	public void setOrdDtlRmk(String ordDtlRmk) {
		this.ordDtlRmk = ordDtlRmk;
	}
	
	/**
	 * Column Info
	 * @param mnrOrgHngrBarTpCd
	 */
	public void setMnrOrgHngrBarTpCd(String mnrOrgHngrBarTpCd) {
		this.mnrOrgHngrBarTpCd = mnrOrgHngrBarTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrFlgDt
	 */
	public void setMnrHngrFlgDt(String mnrHngrFlgDt) {
		this.mnrHngrFlgDt = mnrHngrFlgDt;
	}
	
	/**
	 * Column Info
	 * @param mnrExpnDtlNm
	 */
	public void setMnrExpnDtlNm(String mnrExpnDtlNm) {
		this.mnrExpnDtlNm = mnrExpnDtlNm;
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
	 * @param slsTaxAmt
	 */
	public void setSlsTaxAmt(String slsTaxAmt) {
		this.slsTaxAmt = slsTaxAmt;
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
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param sprPrtUtTpNm
	 */
	public void setSprPrtUtTpNm(String sprPrtUtTpNm) {
		this.sprPrtUtTpNm = sprPrtUtTpNm;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrDmgQty
	 */
	public void setMnrHngrDmgQty(String mnrHngrDmgQty) {
		this.mnrHngrDmgQty = mnrHngrDmgQty;
	}
	
	/**
	 * Column Info
	 * @param rprRsltDt
	 */
	public void setRprRsltDt(String rprRsltDt) {
		this.rprRsltDt = rprRsltDt;
	}
	
	/**
	 * Column Info
	 * @param recentRprQty
	 */
	public void setRecentRprQty(String recentRprQty) {
		this.recentRprQty = recentRprQty;
	}
	
	/**
	 * Column Info
	 * @param mnrVrfyTpCd
	 */
	public void setMnrVrfyTpCd(String mnrVrfyTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
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
	 * @param rprRqstVerNo
	 */
	public void setRprRqstVerNo(String rprRqstVerNo) {
		this.rprRqstVerNo = rprRqstVerNo;
	}
	
	/**
	 * Column Info
	 * @param barIfChk
	 */
	public void setBarIfChk(String barIfChk) {
		this.barIfChk = barIfChk;
	}
	
	/**
	 * Column Info
	 * @param rqstRefNo
	 */
	public void setRqstRefNo(String rqstRefNo) {
		this.rqstRefNo = rqstRefNo;
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
	 * @param sprPrtNo
	 */
	public void setSprPrtNo(String sprPrtNo) {
		this.sprPrtNo = sprPrtNo;
	}
	
	/**
	 * Column Info
	 * @param mnrRtTpCd
	 */
	public void setMnrRtTpCd(String mnrRtTpCd) {
		this.mnrRtTpCd = mnrRtTpCd;
	}
	
	/**
	 * Column Info
	 * @param sprPrtNm
	 */
	public void setSprPrtNm(String sprPrtNm) {
		this.sprPrtNm = sprPrtNm;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param costAmt
	 */
	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param rprQty
	 */
	public void setRprQty(String rprQty) {
		this.rprQty = rprQty;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrDtlOffrDesc
	 */
	public void setMnrHngrDtlOffrDesc(String mnrHngrDtlOffrDesc) {
		this.mnrHngrDtlOffrDesc = mnrHngrDtlOffrDesc;
	}
	
	/**
	 * Column Info
	 * @param n3ptyFlg
	 */
	public void setN3ptyFlg(String n3ptyFlg) {
		this.n3ptyFlg = n3ptyFlg;
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
	 * @param mnrHngrFlgYdCd
	 */
	public void setMnrHngrFlgYdCd(String mnrHngrFlgYdCd) {
		this.mnrHngrFlgYdCd = mnrHngrFlgYdCd;
	}
	
	/**
	 * Column Info
	 * @param ordDtlSeq
	 */
	public void setOrdDtlSeq(String ordDtlSeq) {
		this.ordDtlSeq = ordDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param costDtlCd
	 */
	public void setCostDtlCd(String costDtlCd) {
		this.costDtlCd = costDtlCd;
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
	 * @param bzcAmt
	 */
	public void setBzcAmt(String bzcAmt) {
		this.bzcAmt = bzcAmt;
	}
	
	/**
	 * Column Info
	 * @param actInvtQty
	 */
	public void setActInvtQty(String actInvtQty) {
		this.actInvtQty = actInvtQty;
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
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
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
	 * @param mnrHngrRckCd
	 */
	public void setMnrHngrRckCd(String mnrHngrRckCd) {
		this.mnrHngrRckCd = mnrHngrRckCd;
	}
	
	/**
	 * Column Info
	 * @param mnrHngrTrfCd
	 */
	public void setMnrHngrTrfCd(String mnrHngrTrfCd) {
		this.mnrHngrTrfCd = mnrHngrTrfCd;
	}
	
	/**
	 * Column Info
	 * @param envChgTax
	 */
	public void setEnvChgTax(String envChgTax) {
		this.envChgTax = envChgTax;
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
		setMnrHngrTrfOtrDesc(JSPUtil.getParameter(request, prefix + "mnr_hngr_trf_otr_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setMnrHngrBarTpCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_bar_tp_cd", ""));
		setMnrLostHngrQty(JSPUtil.getParameter(request, prefix + "mnr_lost_hngr_qty", ""));
		setRprOffhFlg(JSPUtil.getParameter(request, prefix + "rpr_offh_flg", ""));
		setN3ptyBilTtlAmt(JSPUtil.getParameter(request, prefix + "n3pty_bil_ttl_amt", ""));
		setMnrDispHngrQty(JSPUtil.getParameter(request, prefix + "mnr_disp_hngr_qty", ""));
		setSprPrtUcAmt(JSPUtil.getParameter(request, prefix + "spr_prt_uc_amt", ""));
		setRprRqstSeq(JSPUtil.getParameter(request, prefix + "rpr_rqst_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setOrdDtlRmk(JSPUtil.getParameter(request, prefix + "ord_dtl_rmk", ""));
		setMnrOrgHngrBarTpCd(JSPUtil.getParameter(request, prefix + "mnr_org_hngr_bar_tp_cd", ""));
		setMnrHngrFlgDt(JSPUtil.getParameter(request, prefix + "mnr_hngr_flg_dt", ""));
		setMnrExpnDtlNm(JSPUtil.getParameter(request, prefix + "mnr_expn_dtl_nm", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setSlsTaxAmt(JSPUtil.getParameter(request, prefix + "sls_tax_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setSprPrtUtTpNm(JSPUtil.getParameter(request, prefix + "spr_prt_ut_tp_nm", ""));
		setMnrHngrDmgQty(JSPUtil.getParameter(request, prefix + "mnr_hngr_dmg_qty", ""));
		setRprRsltDt(JSPUtil.getParameter(request, prefix + "rpr_rslt_dt", ""));
		setRecentRprQty(JSPUtil.getParameter(request, prefix + "recent_rpr_qty", ""));
		setMnrVrfyTpCd(JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request, prefix + "pay_inv_seq", ""));
		setRprRqstVerNo(JSPUtil.getParameter(request, prefix + "rpr_rqst_ver_no", ""));
		setBarIfChk(JSPUtil.getParameter(request, prefix + "bar_if_chk", ""));
		setRqstRefNo(JSPUtil.getParameter(request, prefix + "rqst_ref_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setSprPrtNo(JSPUtil.getParameter(request, prefix + "spr_prt_no", ""));
		setMnrRtTpCd(JSPUtil.getParameter(request, prefix + "mnr_rt_tp_cd", ""));
		setSprPrtNm(JSPUtil.getParameter(request, prefix + "spr_prt_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCostAmt(JSPUtil.getParameter(request, prefix + "cost_amt", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setRprQty(JSPUtil.getParameter(request, prefix + "rpr_qty", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setMnrHngrDtlOffrDesc(JSPUtil.getParameter(request, prefix + "mnr_hngr_dtl_offr_desc", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setMnrHngrFlgYdCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_flg_yd_cd", ""));
		setOrdDtlSeq(JSPUtil.getParameter(request, prefix + "ord_dtl_seq", ""));
		setCostDtlCd(JSPUtil.getParameter(request, prefix + "cost_dtl_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setActInvtQty(JSPUtil.getParameter(request, prefix + "act_invt_qty", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setMnrHngrRckCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_rck_cd", ""));
		setMnrHngrTrfCd(JSPUtil.getParameter(request, prefix + "mnr_hngr_trf_cd", ""));
		setEnvChgTax(JSPUtil.getParameter(request, prefix + "env_chg_tax", ""));
		setIdaSacCd(JSPUtil.getParameter(request, prefix + "ida_sac_cd", ""));
		setIdaCgstRto(JSPUtil.getParameter(request, prefix + "ida_cgst_rto", ""));
		setIdaSgstRto(JSPUtil.getParameter(request, prefix + "ida_sgst_rto", ""));
		setIdaIgstRto(JSPUtil.getParameter(request, prefix + "ida_igst_rto", ""));
		setIdaUgstRto(JSPUtil.getParameter(request, prefix + "ida_ugst_rto", ""));
		setIdaCgstAmt(JSPUtil.getParameter(request, prefix + "ida_cgst_amt", ""));
		setIdaSgstAmt(JSPUtil.getParameter(request, prefix + "ida_sgst_amt", ""));
		setIdaIgstAmt(JSPUtil.getParameter(request, prefix + "ida_igst_amt", ""));
		setIdaUgstAmt(JSPUtil.getParameter(request, prefix + "ida_ugst_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrOrdDtlVO[]
	 */
	public CustomMnrOrdDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrOrdDtlVO[]
	 */
	public CustomMnrOrdDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrOrdDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrHngrTrfOtrDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_trf_otr_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] mnrHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_bar_tp_cd", length));
			String[] mnrLostHngrQty = (JSPUtil.getParameter(request, prefix	+ "mnr_lost_hngr_qty", length));
			String[] rprOffhFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_offh_flg", length));
			String[] n3ptyBilTtlAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_ttl_amt", length));
			String[] mnrDispHngrQty = (JSPUtil.getParameter(request, prefix	+ "mnr_disp_hngr_qty", length));
			String[] sprPrtUcAmt = (JSPUtil.getParameter(request, prefix	+ "spr_prt_uc_amt", length));
			String[] rprRqstSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ordDtlRmk = (JSPUtil.getParameter(request, prefix	+ "ord_dtl_rmk", length));
			String[] mnrOrgHngrBarTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_org_hngr_bar_tp_cd", length));
			String[] mnrHngrFlgDt = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_flg_dt", length));
			String[] mnrExpnDtlNm = (JSPUtil.getParameter(request, prefix	+ "mnr_expn_dtl_nm", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] slsTaxAmt = (JSPUtil.getParameter(request, prefix	+ "sls_tax_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] sprPrtUtTpNm = (JSPUtil.getParameter(request, prefix	+ "spr_prt_ut_tp_nm", length));
			String[] mnrHngrDmgQty = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_dmg_qty", length));
			String[] rprRsltDt = (JSPUtil.getParameter(request, prefix	+ "rpr_rslt_dt", length));
			String[] recentRprQty = (JSPUtil.getParameter(request, prefix	+ "recent_rpr_qty", length));
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] rprRqstVerNo = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_ver_no", length));
			String[] barIfChk = (JSPUtil.getParameter(request, prefix	+ "bar_if_chk", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] sprPrtNo = (JSPUtil.getParameter(request, prefix	+ "spr_prt_no", length));
			String[] mnrRtTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_rt_tp_cd", length));
			String[] sprPrtNm = (JSPUtil.getParameter(request, prefix	+ "spr_prt_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] mnrHngrDtlOffrDesc = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_dtl_offr_desc", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrHngrFlgYdCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_flg_yd_cd", length));
			String[] ordDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ord_dtl_seq", length));
			String[] costDtlCd = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] actInvtQty = (JSPUtil.getParameter(request, prefix	+ "act_invt_qty", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] mnrHngrRckCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_rck_cd", length));
			String[] mnrHngrTrfCd = (JSPUtil.getParameter(request, prefix	+ "mnr_hngr_trf_cd", length));
			String[] envChgTax = (JSPUtil.getParameter(request, prefix	+ "env_chg_tax", length));
			String[] idaSacCd = (JSPUtil.getParameter(request, prefix	+ "ida_sac_cd", length));
			String[] idaCgstRto = (JSPUtil.getParameter(request, prefix	+ "ida_cgst_rto", length));
			String[] idaSgstRto = (JSPUtil.getParameter(request, prefix	+ "ida_sgst_rto", length));
			String[] idaIgstRto = (JSPUtil.getParameter(request, prefix	+ "ida_igst_rto", length));
			String[] idaUgstRto = (JSPUtil.getParameter(request, prefix	+ "ida_ugst_rto", length));
			String[] idaCgstAmt = (JSPUtil.getParameter(request, prefix	+ "ida_cgst_amt", length));
			String[] idaSgstAmt = (JSPUtil.getParameter(request, prefix	+ "ida_sgst_amt", length));
			String[] idaIgstAmt = (JSPUtil.getParameter(request, prefix	+ "ida_igst_amt", length));
			String[] idaUgstAmt = (JSPUtil.getParameter(request, prefix	+ "ida_ugst_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrOrdDtlVO();
				if (mnrHngrTrfOtrDesc[i] != null)
					model.setMnrHngrTrfOtrDesc(mnrHngrTrfOtrDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (mnrHngrBarTpCd[i] != null)
					model.setMnrHngrBarTpCd(mnrHngrBarTpCd[i]);
				if (mnrLostHngrQty[i] != null)
					model.setMnrLostHngrQty(mnrLostHngrQty[i]);
				if (rprOffhFlg[i] != null)
					model.setRprOffhFlg(rprOffhFlg[i]);
				if (n3ptyBilTtlAmt[i] != null)
					model.setN3ptyBilTtlAmt(n3ptyBilTtlAmt[i]);
				if (mnrDispHngrQty[i] != null)
					model.setMnrDispHngrQty(mnrDispHngrQty[i]);
				if (sprPrtUcAmt[i] != null)
					model.setSprPrtUcAmt(sprPrtUcAmt[i]);
				if (rprRqstSeq[i] != null)
					model.setRprRqstSeq(rprRqstSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ordDtlRmk[i] != null)
					model.setOrdDtlRmk(ordDtlRmk[i]);
				if (mnrOrgHngrBarTpCd[i] != null)
					model.setMnrOrgHngrBarTpCd(mnrOrgHngrBarTpCd[i]);
				if (mnrHngrFlgDt[i] != null)
					model.setMnrHngrFlgDt(mnrHngrFlgDt[i]);
				if (mnrExpnDtlNm[i] != null)
					model.setMnrExpnDtlNm(mnrExpnDtlNm[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (slsTaxAmt[i] != null)
					model.setSlsTaxAmt(slsTaxAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (sprPrtUtTpNm[i] != null)
					model.setSprPrtUtTpNm(sprPrtUtTpNm[i]);
				if (mnrHngrDmgQty[i] != null)
					model.setMnrHngrDmgQty(mnrHngrDmgQty[i]);
				if (rprRsltDt[i] != null)
					model.setRprRsltDt(rprRsltDt[i]);
				if (recentRprQty[i] != null)
					model.setRecentRprQty(recentRprQty[i]);
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (rprRqstVerNo[i] != null)
					model.setRprRqstVerNo(rprRqstVerNo[i]);
				if (barIfChk[i] != null)
					model.setBarIfChk(barIfChk[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (sprPrtNo[i] != null)
					model.setSprPrtNo(sprPrtNo[i]);
				if (mnrRtTpCd[i] != null)
					model.setMnrRtTpCd(mnrRtTpCd[i]);
				if (sprPrtNm[i] != null)
					model.setSprPrtNm(sprPrtNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (mnrHngrDtlOffrDesc[i] != null)
					model.setMnrHngrDtlOffrDesc(mnrHngrDtlOffrDesc[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrHngrFlgYdCd[i] != null)
					model.setMnrHngrFlgYdCd(mnrHngrFlgYdCd[i]);
				if (ordDtlSeq[i] != null)
					model.setOrdDtlSeq(ordDtlSeq[i]);
				if (costDtlCd[i] != null)
					model.setCostDtlCd(costDtlCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (actInvtQty[i] != null)
					model.setActInvtQty(actInvtQty[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (mnrHngrRckCd[i] != null)
					model.setMnrHngrRckCd(mnrHngrRckCd[i]);
				if (mnrHngrTrfCd[i] != null)
					model.setMnrHngrTrfCd(mnrHngrTrfCd[i]);
				if (envChgTax[i] != null)
					model.setEnvChgTax(envChgTax[i]);
				if (idaSacCd[i] != null)
					model.setIdaSacCd(idaSacCd[i]);
				if (idaCgstRto[i] != null)
					model.setIdaCgstRto(idaCgstRto[i]);
				if (idaSgstRto[i] != null)
					model.setIdaSgstRto(idaSgstRto[i]);
				if (idaIgstRto[i] != null)
					model.setIdaIgstRto(idaIgstRto[i]);
				if (idaUgstRto[i] != null)
					model.setIdaUgstRto(idaUgstRto[i]);
				if (idaCgstAmt[i] != null)
					model.setIdaCgstAmt(idaCgstAmt[i]);
				if (idaSgstAmt[i] != null)
					model.setIdaSgstAmt(idaSgstAmt[i]);
				if (idaIgstAmt[i] != null)
					model.setIdaIgstAmt(idaIgstAmt[i]);
				if (idaUgstAmt[i] != null)
					model.setIdaUgstAmt(idaUgstAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrOrdDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrOrdDtlVO[]
	 */
	public CustomMnrOrdDtlVO[] getCustomMnrOrdDtlVOs(){
		CustomMnrOrdDtlVO[] vos = (CustomMnrOrdDtlVO[])models.toArray(new CustomMnrOrdDtlVO[models.size()]);
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
		this.mnrHngrTrfOtrDesc = this.mnrHngrTrfOtrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrBarTpCd = this.mnrHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLostHngrQty = this.mnrLostHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprOffhFlg = this.rprOffhFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTtlAmt = this.n3ptyBilTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDispHngrQty = this.mnrDispHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtUcAmt = this.sprPrtUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstSeq = this.rprRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordDtlRmk = this.ordDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrgHngrBarTpCd = this.mnrOrgHngrBarTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrFlgDt = this.mnrHngrFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrExpnDtlNm = this.mnrExpnDtlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsTaxAmt = this.slsTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtUtTpNm = this.sprPrtUtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrDmgQty = this.mnrHngrDmgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRsltDt = this.rprRsltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recentRprQty = this.recentRprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq = this.payInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstVerNo = this.rprRqstVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.barIfChk = this.barIfChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNo = this.sprPrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRtTpCd = this.mnrRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNm = this.sprPrtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrDtlOffrDesc = this.mnrHngrDtlOffrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrFlgYdCd = this.mnrHngrFlgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordDtlSeq = this.ordDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd = this.costDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvtQty = this.actInvtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrRckCd = this.mnrHngrRckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrTrfCd = this.mnrHngrTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.envChgTax = this.envChgTax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSacCd = this.idaSacCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstRto = this.idaCgstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstRto = this.idaSgstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstRto = this.idaIgstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstRto = this.idaUgstRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstAmt = this.idaCgstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstAmt = this.idaSgstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstAmt = this.idaIgstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstAmt = this.idaUgstAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
