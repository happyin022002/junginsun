/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomPayableInvoiceDetailINVO.java
*@FileTitle : CustomPayableInvoiceDetailINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.05
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.10.05 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.accountmanage.expensemgt.vo;

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

public class CustomPayableInvoiceDetailINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomPayableInvoiceDetailINVO> models = new ArrayList<CustomPayableInvoiceDetailINVO>();
	
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String payInvSeq = null;
	/* Column Info */
	private String rprRqstVerNo = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String sprPrtNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String mnrRtTpCd = null;
	/* Column Info */
	private String sprPrtNm = null;
	/* Column Info */
	private String mnrWoTpCd = null;
	/* Column Info */
	private String mnrWoTp = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String n3ptyBilTtlAmt = null;
	/* Column Info */
	private String rprRqstSeq = null;
	/* Column Info */
	private String sprPrtUcAmt = null;
	/* Column Info */
	private String woDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String ordDtlSeq = null;
	/* Column Info */
	private String ordDtlRmk = null;
	/* Column Info */
	private String costDtlCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String bzcAmt = null;
	/* Column Info */
	private String mnrExpnDtlNm = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String slsTaxAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String payInvDtlSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String sprPrtUtTpNm = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String rprRsltDt = null;
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
	
	public CustomPayableInvoiceDetailINVO() {}

	public CustomPayableInvoiceDetailINVO(String ibflag, String pagerows, String mnrVrfyTpCd, String currCd, String payInvSeq, String rprRqstVerNo, String rqstRefNo, String creDt, String sprPrtNo, String mnrRtTpCd, String sprPrtNm, String mnrWoTp, String mnrWoTpCd, String dpPrcsKnt, String mnrOrdOfcCtyCd, String eqNo, String costCd, String costAmt, String invAmt, String woNo, String rprQty, String n3ptyBilTtlAmt, String rprRqstSeq, String sprPrtUcAmt, String woDt, String updUsrId, String n3ptyFlg, String updDt, String costOfcCd, String ordDtlRmk, String ordDtlSeq, String costDtlCd, String eqKndCd, String mnrExpnDtlNm, String bzcAmt, String eqTpszCd, String invNo, String payInvDtlSeq, String creUsrId, String mnrOrdSeq, String ydCd, String fileSeq, String sprPrtUtTpNm, String rprRsltDt, String slsTaxAmt, String idaSacCd, String idaCgstRto, String idaSgstRto, String idaIgstRto, String idaUgstRto, String idaCgstAmt, String idaSgstAmt, String idaIgstAmt, String idaUgstAmt) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.currCd = currCd;
		this.payInvSeq = payInvSeq;
		this.rprRqstVerNo = rprRqstVerNo;
		this.rqstRefNo = rqstRefNo;
		this.sprPrtNo = sprPrtNo;
		this.creDt = creDt;
		this.mnrRtTpCd = mnrRtTpCd;
		this.sprPrtNm = sprPrtNm;
		this.mnrWoTpCd = mnrWoTpCd;
		this.mnrWoTp = mnrWoTp;
		this.pagerows = pagerows;
		this.dpPrcsKnt = dpPrcsKnt;
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.costCd = costCd;
		this.costAmt = costAmt;
		this.invAmt = invAmt;
		this.woNo = woNo;
		this.rprQty = rprQty;
		this.n3ptyBilTtlAmt = n3ptyBilTtlAmt;
		this.rprRqstSeq = rprRqstSeq;
		this.sprPrtUcAmt = sprPrtUcAmt;
		this.woDt = woDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.n3ptyFlg = n3ptyFlg;
		this.costOfcCd = costOfcCd;
		this.ordDtlSeq = ordDtlSeq;
		this.ordDtlRmk = ordDtlRmk;
		this.costDtlCd = costDtlCd;
		this.eqKndCd = eqKndCd;
		this.bzcAmt = bzcAmt;
		this.mnrExpnDtlNm = mnrExpnDtlNm;
		this.eqTpszCd = eqTpszCd;
		this.invNo = invNo;
		this.slsTaxAmt = slsTaxAmt;
		this.creUsrId = creUsrId;
		this.payInvDtlSeq = payInvDtlSeq;
		this.ydCd = ydCd;
		this.mnrOrdSeq = mnrOrdSeq;
		this.sprPrtUtTpNm = sprPrtUtTpNm;
		this.fileSeq = fileSeq;
		this.rprRsltDt = rprRsltDt;
		this.idaSacCd = idaSacCd;
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
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("pay_inv_seq", getPayInvSeq());
		this.hashColumns.put("rpr_rqst_ver_no", getRprRqstVerNo());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("spr_prt_no", getSprPrtNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("mnr_rt_tp_cd", getMnrRtTpCd());
		this.hashColumns.put("spr_prt_nm", getSprPrtNm());
		this.hashColumns.put("mnr_wo_tp_cd", getMnrWoTpCd());
		this.hashColumns.put("mnr_wo_tp", getMnrWoTp());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("n3pty_bil_ttl_amt", getN3ptyBilTtlAmt());
		this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());
		this.hashColumns.put("spr_prt_uc_amt", getSprPrtUcAmt());
		this.hashColumns.put("wo_dt", getWoDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("ord_dtl_seq", getOrdDtlSeq());
		this.hashColumns.put("ord_dtl_rmk", getOrdDtlRmk());
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("bzc_amt", getBzcAmt());
		this.hashColumns.put("mnr_expn_dtl_nm", getMnrExpnDtlNm());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("sls_tax_amt", getSlsTaxAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("pay_inv_dtl_seq", getPayInvDtlSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("spr_prt_ut_tp_nm", getSprPrtUtTpNm());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("rpr_rslt_dt", getRprRsltDt());
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
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("pay_inv_seq", "payInvSeq");
		this.hashFields.put("rpr_rqst_ver_no", "rprRqstVerNo");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("spr_prt_no", "sprPrtNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("mnr_rt_tp_cd", "mnrRtTpCd");
		this.hashFields.put("spr_prt_nm", "sprPrtNm");
		this.hashFields.put("mnr_wo_tp_cd", "mnrWoTpCd");
		this.hashFields.put("mnr_wo_tp", "mnrWoTp");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("n3pty_bil_ttl_amt", "n3ptyBilTtlAmt");
		this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
		this.hashFields.put("spr_prt_uc_amt", "sprPrtUcAmt");
		this.hashFields.put("wo_dt", "woDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("ord_dtl_seq", "ordDtlSeq");
		this.hashFields.put("ord_dtl_rmk", "ordDtlRmk");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("bzc_amt", "bzcAmt");
		this.hashFields.put("mnr_expn_dtl_nm", "mnrExpnDtlNm");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("sls_tax_amt", "slsTaxAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("pay_inv_dtl_seq", "payInvDtlSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("spr_prt_ut_tp_nm", "sprPrtUtTpNm");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("rpr_rslt_dt", "rprRsltDt");
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
	 * @return mnrVrfyTpCd
	 */
	public String getMnrVrfyTpCd() {
		return this.mnrVrfyTpCd;
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
	 * @return rqstRefNo
	 */
	public String getRqstRefNo() {
		return this.rqstRefNo;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
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
	 * Column Info
	 * @return mnrWoTpCd
	 */
	public String getMnrWoTpCd() {
		return this.mnrWoTpCd;
	}
	
	/**
	 * Column Info
	 * @return mnrWoTp
	 */
	public String getMnrWoTp() {
		return this.mnrWoTp;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdOfcCtyCd
	 */
	public String getMnrOrdOfcCtyCd() {
		return this.mnrOrdOfcCtyCd;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return woNo
	 */
	public String getWoNo() {
		return this.woNo;
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
	 * @return n3ptyBilTtlAmt
	 */
	public String getN3ptyBilTtlAmt() {
		return this.n3ptyBilTtlAmt;
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
	 * @return sprPrtUcAmt
	 */
	public String getSprPrtUcAmt() {
		return this.sprPrtUcAmt;
	}
	
	/**
	 * Column Info
	 * @return woDt
	 */
	public String getWoDt() {
		return this.woDt;
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
	 * @return n3ptyFlg
	 */
	public String getN3ptyFlg() {
		return this.n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @return costOfcCd
	 */
	public String getCostOfcCd() {
		return this.costOfcCd;
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
	 * @return ordDtlRmk
	 */
	public String getOrdDtlRmk() {
		return this.ordDtlRmk;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return payInvDtlSeq
	 */
	public String getPayInvDtlSeq() {
		return this.payInvDtlSeq;
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
	 * @return mnrOrdSeq
	 */
	public String getMnrOrdSeq() {
		return this.mnrOrdSeq;
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
	 * @return fileSeq
	 */
	public String getFileSeq() {
		return this.fileSeq;
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
	 * @param mnrVrfyTpCd
	 */
	public void setMnrVrfyTpCd(String mnrVrfyTpCd) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
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
	 * @param rqstRefNo
	 */
	public void setRqstRefNo(String rqstRefNo) {
		this.rqstRefNo = rqstRefNo;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
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
	 * Column Info
	 * @param mnrWoTpCd
	 */
	public void setMnrWoTpCd(String mnrWoTpCd) {
		this.mnrWoTpCd = mnrWoTpCd;
	}
	
	/**
	 * Column Info
	 * @param mnrWoTp
	 */
	public void setMnrWoTp(String mnrWoTp) {
		this.mnrWoTp = mnrWoTp;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdOfcCtyCd
	 */
	public void setMnrOrdOfcCtyCd(String mnrOrdOfcCtyCd) {
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
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
	 * @param n3ptyBilTtlAmt
	 */
	public void setN3ptyBilTtlAmt(String n3ptyBilTtlAmt) {
		this.n3ptyBilTtlAmt = n3ptyBilTtlAmt;
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
	 * @param sprPrtUcAmt
	 */
	public void setSprPrtUcAmt(String sprPrtUcAmt) {
		this.sprPrtUcAmt = sprPrtUcAmt;
	}
	
	/**
	 * Column Info
	 * @param woDt
	 */
	public void setWoDt(String woDt) {
		this.woDt = woDt;
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
	 * @param n3ptyFlg
	 */
	public void setN3ptyFlg(String n3ptyFlg) {
		this.n3ptyFlg = n3ptyFlg;
	}
	
	/**
	 * Column Info
	 * @param costOfcCd
	 */
	public void setCostOfcCd(String costOfcCd) {
		this.costOfcCd = costOfcCd;
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
	 * @param ordDtlRmk
	 */
	public void setOrdDtlRmk(String ordDtlRmk) {
		this.ordDtlRmk = ordDtlRmk;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param payInvDtlSeq
	 */
	public void setPayInvDtlSeq(String payInvDtlSeq) {
		this.payInvDtlSeq = payInvDtlSeq;
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
	 * @param mnrOrdSeq
	 */
	public void setMnrOrdSeq(String mnrOrdSeq) {
		this.mnrOrdSeq = mnrOrdSeq;
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
	 * @param fileSeq
	 */
	public void setFileSeq(String fileSeq) {
		this.fileSeq = fileSeq;
	}
	
	/**
	 * Column Info
	 * @param rprRsltDt
	 */
	public void setRprRsltDt(String rprRsltDt) {
		this.rprRsltDt = rprRsltDt;
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
		setMnrVrfyTpCd(JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setPayInvSeq(JSPUtil.getParameter(request, prefix + "pay_inv_seq", ""));
		setRprRqstVerNo(JSPUtil.getParameter(request, prefix + "rpr_rqst_ver_no", ""));
		setRqstRefNo(JSPUtil.getParameter(request, prefix + "rqst_ref_no", ""));
		setSprPrtNo(JSPUtil.getParameter(request, prefix + "spr_prt_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setMnrRtTpCd(JSPUtil.getParameter(request, prefix + "mnr_rt_tp_cd", ""));
		setSprPrtNm(JSPUtil.getParameter(request, prefix + "spr_prt_nm", ""));
		setMnrWoTpCd(JSPUtil.getParameter(request, prefix + "mnr_wo_tp_cd", ""));
		setMnrWoTp(JSPUtil.getParameter(request, prefix + "mnr_wo_tp", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, prefix + "dp_prcs_knt", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, prefix + "mnr_ord_ofc_cty_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setCostAmt(JSPUtil.getParameter(request, prefix + "cost_amt", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setRprQty(JSPUtil.getParameter(request, prefix + "rpr_qty", ""));
		setN3ptyBilTtlAmt(JSPUtil.getParameter(request, prefix + "n3pty_bil_ttl_amt", ""));
		setRprRqstSeq(JSPUtil.getParameter(request, prefix + "rpr_rqst_seq", ""));
		setSprPrtUcAmt(JSPUtil.getParameter(request, prefix + "spr_prt_uc_amt", ""));
		setWoDt(JSPUtil.getParameter(request, prefix + "wo_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
		setCostOfcCd(JSPUtil.getParameter(request, prefix + "cost_ofc_cd", ""));
		setOrdDtlSeq(JSPUtil.getParameter(request, prefix + "ord_dtl_seq", ""));
		setOrdDtlRmk(JSPUtil.getParameter(request, prefix + "ord_dtl_rmk", ""));
		setCostDtlCd(JSPUtil.getParameter(request, prefix + "cost_dtl_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setBzcAmt(JSPUtil.getParameter(request, prefix + "bzc_amt", ""));
		setMnrExpnDtlNm(JSPUtil.getParameter(request, prefix + "mnr_expn_dtl_nm", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setSlsTaxAmt(JSPUtil.getParameter(request, prefix + "sls_tax_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPayInvDtlSeq(JSPUtil.getParameter(request, prefix + "pay_inv_dtl_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, prefix + "mnr_ord_seq", ""));
		setSprPrtUtTpNm(JSPUtil.getParameter(request, prefix + "spr_prt_ut_tp_nm", ""));
		setFileSeq(JSPUtil.getParameter(request, prefix + "file_seq", ""));
		setRprRsltDt(JSPUtil.getParameter(request, prefix + "rpr_rslt_dt", ""));
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
	 * @return CustomPayableInvoiceDetailINVO[]
	 */
	public CustomPayableInvoiceDetailINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomPayableInvoiceDetailINVO[]
	 */
	public CustomPayableInvoiceDetailINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomPayableInvoiceDetailINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] payInvSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_seq", length));
			String[] rprRqstVerNo = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_ver_no", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] sprPrtNo = (JSPUtil.getParameter(request, prefix	+ "spr_prt_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] mnrRtTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_rt_tp_cd", length));
			String[] sprPrtNm = (JSPUtil.getParameter(request, prefix	+ "spr_prt_nm", length));
			String[] mnrWoTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_wo_tp_cd", length));
			String[] mnrWoTp = (JSPUtil.getParameter(request, prefix	+ "mnr_wo_tp", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] n3ptyBilTtlAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_ttl_amt", length));
			String[] rprRqstSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_seq", length));
			String[] sprPrtUcAmt = (JSPUtil.getParameter(request, prefix	+ "spr_prt_uc_amt", length));
			String[] woDt = (JSPUtil.getParameter(request, prefix	+ "wo_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] ordDtlSeq = (JSPUtil.getParameter(request, prefix	+ "ord_dtl_seq", length));
			String[] ordDtlRmk = (JSPUtil.getParameter(request, prefix	+ "ord_dtl_rmk", length));
			String[] costDtlCd = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] bzcAmt = (JSPUtil.getParameter(request, prefix	+ "bzc_amt", length));
			String[] mnrExpnDtlNm = (JSPUtil.getParameter(request, prefix	+ "mnr_expn_dtl_nm", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] slsTaxAmt = (JSPUtil.getParameter(request, prefix	+ "sls_tax_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] payInvDtlSeq = (JSPUtil.getParameter(request, prefix	+ "pay_inv_dtl_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] sprPrtUtTpNm = (JSPUtil.getParameter(request, prefix	+ "spr_prt_ut_tp_nm", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] rprRsltDt = (JSPUtil.getParameter(request, prefix	+ "rpr_rslt_dt", length));
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
				model = new CustomPayableInvoiceDetailINVO();
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (payInvSeq[i] != null)
					model.setPayInvSeq(payInvSeq[i]);
				if (rprRqstVerNo[i] != null)
					model.setRprRqstVerNo(rprRqstVerNo[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (sprPrtNo[i] != null)
					model.setSprPrtNo(sprPrtNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (mnrRtTpCd[i] != null)
					model.setMnrRtTpCd(mnrRtTpCd[i]);
				if (sprPrtNm[i] != null)
					model.setSprPrtNm(sprPrtNm[i]);
				if (mnrWoTpCd[i] != null)
					model.setMnrWoTpCd(mnrWoTpCd[i]);
				if (mnrWoTp[i] != null)
					model.setMnrWoTp(mnrWoTp[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (n3ptyBilTtlAmt[i] != null)
					model.setN3ptyBilTtlAmt(n3ptyBilTtlAmt[i]);
				if (rprRqstSeq[i] != null)
					model.setRprRqstSeq(rprRqstSeq[i]);
				if (sprPrtUcAmt[i] != null)
					model.setSprPrtUcAmt(sprPrtUcAmt[i]);
				if (woDt[i] != null)
					model.setWoDt(woDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (ordDtlSeq[i] != null)
					model.setOrdDtlSeq(ordDtlSeq[i]);
				if (ordDtlRmk[i] != null)
					model.setOrdDtlRmk(ordDtlRmk[i]);
				if (costDtlCd[i] != null)
					model.setCostDtlCd(costDtlCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (bzcAmt[i] != null)
					model.setBzcAmt(bzcAmt[i]);
				if (mnrExpnDtlNm[i] != null)
					model.setMnrExpnDtlNm(mnrExpnDtlNm[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (slsTaxAmt[i] != null)
					model.setSlsTaxAmt(slsTaxAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (payInvDtlSeq[i] != null)
					model.setPayInvDtlSeq(payInvDtlSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (sprPrtUtTpNm[i] != null)
					model.setSprPrtUtTpNm(sprPrtUtTpNm[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (rprRsltDt[i] != null)
					model.setRprRsltDt(rprRsltDt[i]);
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
		return getCustomPayableInvoiceDetailINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomPayableInvoiceDetailINVO[]
	 */
	public CustomPayableInvoiceDetailINVO[] getCustomPayableInvoiceDetailINVOs(){
		CustomPayableInvoiceDetailINVO[] vos = (CustomPayableInvoiceDetailINVO[])models.toArray(new CustomPayableInvoiceDetailINVO[models.size()]);
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
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvSeq = this.payInvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstVerNo = this.rprRqstVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNo = this.sprPrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRtTpCd = this.mnrRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtNm = this.sprPrtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWoTpCd = this.mnrWoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWoTp = this.mnrWoTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTtlAmt = this.n3ptyBilTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstSeq = this.rprRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtUcAmt = this.sprPrtUcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woDt = this.woDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordDtlSeq = this.ordDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ordDtlRmk = this.ordDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd = this.costDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcAmt = this.bzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrExpnDtlNm = this.mnrExpnDtlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsTaxAmt = this.slsTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payInvDtlSeq = this.payInvDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprPrtUtTpNm = this.sprPrtUtTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRsltDt = this.rprRsltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
