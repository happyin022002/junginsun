/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrRprRqstTmpDtlVO.java
*@FileTitle : CustomMnrRprRqstTmpDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.08.27 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

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

public class CustomMnrRprRqstTmpDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrRprRqstTmpDtlVO> models = new ArrayList<CustomMnrRprRqstTmpDtlVO>();
	
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String eqLocCd = null;
	/* Column Info */
	private String xchMtrlCostAmt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rprDtlRmk = null;
	/* Column Info */
	private String n3ptyBilLbrRt = null;
	/* Column Info */
	private String lbrMtrlBzcAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rprLbrBzcHrs = null;
	/* Column Info */
	private String lbrCostAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqDmgCd = null;
	/* Column Info */
	private String rprRqstTmpSeq = null;
	/* Column Info */
	private String mnrAgmtAmt = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String rprSzNo = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String mnrWrkAmt = null;
	/* Column Info */
	private String rprWdtNo = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String eqCmpoCdChkFlg = null;
	/* Column Info */
	private String volTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rprRqstLstVerFlg = null;
	/* Column Info */
	private String eqCmpoCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3ptyBilAmt = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String rprLenNo = null;
	/* Column Info */
	private String trfDivCd = null;
	/* Column Info */
	private String n3ptyBilLbrCostAmt = null;
	/* Column Info */
	private String rprLbrBzcRt = null;
	/* Column Info */
	private String eqRprCdChkFlg = null;
	/* Column Info */
	private String trfOptCd = null;
	/* Column Info */
	private String rprRqstTmpDtlSeq = null;
	/* Column Info */
	private String eqDmgCdChkFlg = null;
	/* Column Info */
	private String eqRprCd = null;
	/* Column Info */
	private String mnrLrAcctFlg = null;
	/* Column Info */
	private String n3ptyBilMtrlCostAmt = null;
	/* Column Info */
	private String mtrlRecoAmt = null;
	/* Column Info */
	private String mnrLbrBzcAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rprLbrRt = null;
	/* Column Info */
	private String mtrlCostAmt = null;
	/* Column Info */
	private String rprRqstTmpVerNo = null;
	/* Column Info */
	private String rprLbrHrs = null;
	/* Column Info */
	private String eqLocCdChkFlg = null;
	/* Column Info */
	private String n3ptyBilLbrHrs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrRprRqstTmpDtlVO() {}

	public CustomMnrRprRqstTmpDtlVO(String ibflag, String pagerows, String rqstEqNo, String rprRqstTmpSeq, String rprRqstTmpVerNo, String rprRqstTmpDtlSeq, String rprRqstLstVerFlg, String costCd, String eqLocCd, String eqLocCdChkFlg, String eqCmpoCd, String eqCmpoCdChkFlg, String eqDmgCd, String eqDmgCdChkFlg, String eqRprCd, String eqRprCdChkFlg, String trfDivCd, String trfOptCd, String volTpCd, String rprQty, String rprSzNo, String rprLenNo, String rprWdtNo, String rprLbrHrs, String rprLbrRt, String rprLbrBzcHrs, String rprLbrBzcRt, String mnrLbrBzcAmt, String lbrMtrlBzcAmt, String lbrCostAmt, String mtrlCostAmt, String xchMtrlCostAmt, String mtrlRecoAmt, String mnrLrAcctFlg, String n3ptyFlg, String n3ptyBilLbrHrs, String n3ptyBilLbrRt, String n3ptyBilLbrCostAmt, String n3ptyBilMtrlCostAmt, String mnrAgmtAmt, String mnrWrkAmt, String n3ptyBilAmt, String rprDtlRmk, String mnrVrfyTpCd, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.eqLocCd = eqLocCd;
		this.xchMtrlCostAmt = xchMtrlCostAmt;
		this.creDt = creDt;
		this.rprDtlRmk = rprDtlRmk;
		this.n3ptyBilLbrRt = n3ptyBilLbrRt;
		this.lbrMtrlBzcAmt = lbrMtrlBzcAmt;
		this.pagerows = pagerows;
		this.rprLbrBzcHrs = rprLbrBzcHrs;
		this.lbrCostAmt = lbrCostAmt;
		this.ibflag = ibflag;
		this.eqDmgCd = eqDmgCd;
		this.rprRqstTmpSeq = rprRqstTmpSeq;
		this.mnrAgmtAmt = mnrAgmtAmt;
		this.costCd = costCd;
		this.rprSzNo = rprSzNo;
		this.rqstEqNo = rqstEqNo;
		this.mnrWrkAmt = mnrWrkAmt;
		this.rprWdtNo = rprWdtNo;
		this.rprQty = rprQty;
		this.eqCmpoCdChkFlg = eqCmpoCdChkFlg;
		this.volTpCd = volTpCd;
		this.updUsrId = updUsrId;
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
		this.eqCmpoCd = eqCmpoCd;
		this.updDt = updDt;
		this.n3ptyBilAmt = n3ptyBilAmt;
		this.n3ptyFlg = n3ptyFlg;
		this.rprLenNo = rprLenNo;
		this.trfDivCd = trfDivCd;
		this.n3ptyBilLbrCostAmt = n3ptyBilLbrCostAmt;
		this.rprLbrBzcRt = rprLbrBzcRt;
		this.eqRprCdChkFlg = eqRprCdChkFlg;
		this.trfOptCd = trfOptCd;
		this.rprRqstTmpDtlSeq = rprRqstTmpDtlSeq;
		this.eqDmgCdChkFlg = eqDmgCdChkFlg;
		this.eqRprCd = eqRprCd;
		this.mnrLrAcctFlg = mnrLrAcctFlg;
		this.n3ptyBilMtrlCostAmt = n3ptyBilMtrlCostAmt;
		this.mtrlRecoAmt = mtrlRecoAmt;
		this.mnrLbrBzcAmt = mnrLbrBzcAmt;
		this.creUsrId = creUsrId;
		this.rprLbrRt = rprLbrRt;
		this.mtrlCostAmt = mtrlCostAmt;
		this.rprRqstTmpVerNo = rprRqstTmpVerNo;
		this.rprLbrHrs = rprLbrHrs;
		this.eqLocCdChkFlg = eqLocCdChkFlg;
		this.n3ptyBilLbrHrs = n3ptyBilLbrHrs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("eq_loc_cd", getEqLocCd());
		this.hashColumns.put("xch_mtrl_cost_amt", getXchMtrlCostAmt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rpr_dtl_rmk", getRprDtlRmk());
		this.hashColumns.put("n3pty_bil_lbr_rt", getN3ptyBilLbrRt());
		this.hashColumns.put("lbr_mtrl_bzc_amt", getLbrMtrlBzcAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rpr_lbr_bzc_hrs", getRprLbrBzcHrs());
		this.hashColumns.put("lbr_cost_amt", getLbrCostAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_dmg_cd", getEqDmgCd());
		this.hashColumns.put("rpr_rqst_tmp_seq", getRprRqstTmpSeq());
		this.hashColumns.put("mnr_agmt_amt", getMnrAgmtAmt());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("rpr_sz_no", getRprSzNo());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("mnr_wrk_amt", getMnrWrkAmt());
		this.hashColumns.put("rpr_wdt_no", getRprWdtNo());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("eq_cmpo_cd_chk_flg", getEqCmpoCdChkFlg());
		this.hashColumns.put("vol_tp_cd", getVolTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("rpr_rqst_lst_ver_flg", getRprRqstLstVerFlg());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n3pty_bil_amt", getN3ptyBilAmt());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("rpr_len_no", getRprLenNo());
		this.hashColumns.put("trf_div_cd", getTrfDivCd());
		this.hashColumns.put("n3pty_bil_lbr_cost_amt", getN3ptyBilLbrCostAmt());
		this.hashColumns.put("rpr_lbr_bzc_rt", getRprLbrBzcRt());
		this.hashColumns.put("eq_rpr_cd_chk_flg", getEqRprCdChkFlg());
		this.hashColumns.put("trf_opt_cd", getTrfOptCd());
		this.hashColumns.put("rpr_rqst_tmp_dtl_seq", getRprRqstTmpDtlSeq());
		this.hashColumns.put("eq_dmg_cd_chk_flg", getEqDmgCdChkFlg());
		this.hashColumns.put("eq_rpr_cd", getEqRprCd());
		this.hashColumns.put("mnr_lr_acct_flg", getMnrLrAcctFlg());
		this.hashColumns.put("n3pty_bil_mtrl_cost_amt", getN3ptyBilMtrlCostAmt());
		this.hashColumns.put("mtrl_reco_amt", getMtrlRecoAmt());
		this.hashColumns.put("mnr_lbr_bzc_amt", getMnrLbrBzcAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("rpr_lbr_rt", getRprLbrRt());
		this.hashColumns.put("mtrl_cost_amt", getMtrlCostAmt());
		this.hashColumns.put("rpr_rqst_tmp_ver_no", getRprRqstTmpVerNo());
		this.hashColumns.put("rpr_lbr_hrs", getRprLbrHrs());
		this.hashColumns.put("eq_loc_cd_chk_flg", getEqLocCdChkFlg());
		this.hashColumns.put("n3pty_bil_lbr_hrs", getN3ptyBilLbrHrs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("eq_loc_cd", "eqLocCd");
		this.hashFields.put("xch_mtrl_cost_amt", "xchMtrlCostAmt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rpr_dtl_rmk", "rprDtlRmk");
		this.hashFields.put("n3pty_bil_lbr_rt", "n3ptyBilLbrRt");
		this.hashFields.put("lbr_mtrl_bzc_amt", "lbrMtrlBzcAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rpr_lbr_bzc_hrs", "rprLbrBzcHrs");
		this.hashFields.put("lbr_cost_amt", "lbrCostAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_dmg_cd", "eqDmgCd");
		this.hashFields.put("rpr_rqst_tmp_seq", "rprRqstTmpSeq");
		this.hashFields.put("mnr_agmt_amt", "mnrAgmtAmt");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("rpr_sz_no", "rprSzNo");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("mnr_wrk_amt", "mnrWrkAmt");
		this.hashFields.put("rpr_wdt_no", "rprWdtNo");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("eq_cmpo_cd_chk_flg", "eqCmpoCdChkFlg");
		this.hashFields.put("vol_tp_cd", "volTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("rpr_rqst_lst_ver_flg", "rprRqstLstVerFlg");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n3pty_bil_amt", "n3ptyBilAmt");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("rpr_len_no", "rprLenNo");
		this.hashFields.put("trf_div_cd", "trfDivCd");
		this.hashFields.put("n3pty_bil_lbr_cost_amt", "n3ptyBilLbrCostAmt");
		this.hashFields.put("rpr_lbr_bzc_rt", "rprLbrBzcRt");
		this.hashFields.put("eq_rpr_cd_chk_flg", "eqRprCdChkFlg");
		this.hashFields.put("trf_opt_cd", "trfOptCd");
		this.hashFields.put("rpr_rqst_tmp_dtl_seq", "rprRqstTmpDtlSeq");
		this.hashFields.put("eq_dmg_cd_chk_flg", "eqDmgCdChkFlg");
		this.hashFields.put("eq_rpr_cd", "eqRprCd");
		this.hashFields.put("mnr_lr_acct_flg", "mnrLrAcctFlg");
		this.hashFields.put("n3pty_bil_mtrl_cost_amt", "n3ptyBilMtrlCostAmt");
		this.hashFields.put("mtrl_reco_amt", "mtrlRecoAmt");
		this.hashFields.put("mnr_lbr_bzc_amt", "mnrLbrBzcAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("rpr_lbr_rt", "rprLbrRt");
		this.hashFields.put("mtrl_cost_amt", "mtrlCostAmt");
		this.hashFields.put("rpr_rqst_tmp_ver_no", "rprRqstTmpVerNo");
		this.hashFields.put("rpr_lbr_hrs", "rprLbrHrs");
		this.hashFields.put("eq_loc_cd_chk_flg", "eqLocCdChkFlg");
		this.hashFields.put("n3pty_bil_lbr_hrs", "n3ptyBilLbrHrs");
		return this.hashFields;
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
	 * @return eqLocCd
	 */
	public String getEqLocCd() {
		return this.eqLocCd;
	}
	
	/**
	 * Column Info
	 * @return xchMtrlCostAmt
	 */
	public String getXchMtrlCostAmt() {
		return this.xchMtrlCostAmt;
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
	 * @return rprDtlRmk
	 */
	public String getRprDtlRmk() {
		return this.rprDtlRmk;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilLbrRt
	 */
	public String getN3ptyBilLbrRt() {
		return this.n3ptyBilLbrRt;
	}
	
	/**
	 * Column Info
	 * @return lbrMtrlBzcAmt
	 */
	public String getLbrMtrlBzcAmt() {
		return this.lbrMtrlBzcAmt;
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
	 * @return rprLbrBzcHrs
	 */
	public String getRprLbrBzcHrs() {
		return this.rprLbrBzcHrs;
	}
	
	/**
	 * Column Info
	 * @return lbrCostAmt
	 */
	public String getLbrCostAmt() {
		return this.lbrCostAmt;
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
	 * @return eqDmgCd
	 */
	public String getEqDmgCd() {
		return this.eqDmgCd;
	}
	
	/**
	 * Column Info
	 * @return rprRqstTmpSeq
	 */
	public String getRprRqstTmpSeq() {
		return this.rprRqstTmpSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrAgmtAmt
	 */
	public String getMnrAgmtAmt() {
		return this.mnrAgmtAmt;
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
	 * @return rprSzNo
	 */
	public String getRprSzNo() {
		return this.rprSzNo;
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
	 * @return mnrWrkAmt
	 */
	public String getMnrWrkAmt() {
		return this.mnrWrkAmt;
	}
	
	/**
	 * Column Info
	 * @return rprWdtNo
	 */
	public String getRprWdtNo() {
		return this.rprWdtNo;
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
	 * @return eqCmpoCdChkFlg
	 */
	public String getEqCmpoCdChkFlg() {
		return this.eqCmpoCdChkFlg;
	}
	
	/**
	 * Column Info
	 * @return volTpCd
	 */
	public String getVolTpCd() {
		return this.volTpCd;
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
	 * @return rprRqstLstVerFlg
	 */
	public String getRprRqstLstVerFlg() {
		return this.rprRqstLstVerFlg;
	}
	
	/**
	 * Column Info
	 * @return eqCmpoCd
	 */
	public String getEqCmpoCd() {
		return this.eqCmpoCd;
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
	 * @return n3ptyBilAmt
	 */
	public String getN3ptyBilAmt() {
		return this.n3ptyBilAmt;
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
	 * @return rprLenNo
	 */
	public String getRprLenNo() {
		return this.rprLenNo;
	}
	
	/**
	 * Column Info
	 * @return trfDivCd
	 */
	public String getTrfDivCd() {
		return this.trfDivCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilLbrCostAmt
	 */
	public String getN3ptyBilLbrCostAmt() {
		return this.n3ptyBilLbrCostAmt;
	}
	
	/**
	 * Column Info
	 * @return rprLbrBzcRt
	 */
	public String getRprLbrBzcRt() {
		return this.rprLbrBzcRt;
	}
	
	/**
	 * Column Info
	 * @return eqRprCdChkFlg
	 */
	public String getEqRprCdChkFlg() {
		return this.eqRprCdChkFlg;
	}
	
	/**
	 * Column Info
	 * @return trfOptCd
	 */
	public String getTrfOptCd() {
		return this.trfOptCd;
	}
	
	/**
	 * Column Info
	 * @return rprRqstTmpDtlSeq
	 */
	public String getRprRqstTmpDtlSeq() {
		return this.rprRqstTmpDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return eqDmgCdChkFlg
	 */
	public String getEqDmgCdChkFlg() {
		return this.eqDmgCdChkFlg;
	}
	
	/**
	 * Column Info
	 * @return eqRprCd
	 */
	public String getEqRprCd() {
		return this.eqRprCd;
	}
	
	/**
	 * Column Info
	 * @return mnrLrAcctFlg
	 */
	public String getMnrLrAcctFlg() {
		return this.mnrLrAcctFlg;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilMtrlCostAmt
	 */
	public String getN3ptyBilMtrlCostAmt() {
		return this.n3ptyBilMtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return mtrlRecoAmt
	 */
	public String getMtrlRecoAmt() {
		return this.mtrlRecoAmt;
	}
	
	/**
	 * Column Info
	 * @return mnrLbrBzcAmt
	 */
	public String getMnrLbrBzcAmt() {
		return this.mnrLbrBzcAmt;
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
	 * @return rprLbrRt
	 */
	public String getRprLbrRt() {
		return this.rprLbrRt;
	}
	
	/**
	 * Column Info
	 * @return mtrlCostAmt
	 */
	public String getMtrlCostAmt() {
		return this.mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return rprRqstTmpVerNo
	 */
	public String getRprRqstTmpVerNo() {
		return this.rprRqstTmpVerNo;
	}
	
	/**
	 * Column Info
	 * @return rprLbrHrs
	 */
	public String getRprLbrHrs() {
		return this.rprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @return eqLocCdChkFlg
	 */
	public String getEqLocCdChkFlg() {
		return this.eqLocCdChkFlg;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilLbrHrs
	 */
	public String getN3ptyBilLbrHrs() {
		return this.n3ptyBilLbrHrs;
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
	 * @param eqLocCd
	 */
	public void setEqLocCd(String eqLocCd) {
		this.eqLocCd = eqLocCd;
	}
	
	/**
	 * Column Info
	 * @param xchMtrlCostAmt
	 */
	public void setXchMtrlCostAmt(String xchMtrlCostAmt) {
		this.xchMtrlCostAmt = xchMtrlCostAmt;
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
	 * @param rprDtlRmk
	 */
	public void setRprDtlRmk(String rprDtlRmk) {
		this.rprDtlRmk = rprDtlRmk;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilLbrRt
	 */
	public void setN3ptyBilLbrRt(String n3ptyBilLbrRt) {
		this.n3ptyBilLbrRt = n3ptyBilLbrRt;
	}
	
	/**
	 * Column Info
	 * @param lbrMtrlBzcAmt
	 */
	public void setLbrMtrlBzcAmt(String lbrMtrlBzcAmt) {
		this.lbrMtrlBzcAmt = lbrMtrlBzcAmt;
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
	 * @param rprLbrBzcHrs
	 */
	public void setRprLbrBzcHrs(String rprLbrBzcHrs) {
		this.rprLbrBzcHrs = rprLbrBzcHrs;
	}
	
	/**
	 * Column Info
	 * @param lbrCostAmt
	 */
	public void setLbrCostAmt(String lbrCostAmt) {
		this.lbrCostAmt = lbrCostAmt;
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
	 * @param eqDmgCd
	 */
	public void setEqDmgCd(String eqDmgCd) {
		this.eqDmgCd = eqDmgCd;
	}
	
	/**
	 * Column Info
	 * @param rprRqstTmpSeq
	 */
	public void setRprRqstTmpSeq(String rprRqstTmpSeq) {
		this.rprRqstTmpSeq = rprRqstTmpSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrAgmtAmt
	 */
	public void setMnrAgmtAmt(String mnrAgmtAmt) {
		this.mnrAgmtAmt = mnrAgmtAmt;
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
	 * @param rprSzNo
	 */
	public void setRprSzNo(String rprSzNo) {
		this.rprSzNo = rprSzNo;
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
	 * @param mnrWrkAmt
	 */
	public void setMnrWrkAmt(String mnrWrkAmt) {
		this.mnrWrkAmt = mnrWrkAmt;
	}
	
	/**
	 * Column Info
	 * @param rprWdtNo
	 */
	public void setRprWdtNo(String rprWdtNo) {
		this.rprWdtNo = rprWdtNo;
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
	 * @param eqCmpoCdChkFlg
	 */
	public void setEqCmpoCdChkFlg(String eqCmpoCdChkFlg) {
		this.eqCmpoCdChkFlg = eqCmpoCdChkFlg;
	}
	
	/**
	 * Column Info
	 * @param volTpCd
	 */
	public void setVolTpCd(String volTpCd) {
		this.volTpCd = volTpCd;
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
	 * @param rprRqstLstVerFlg
	 */
	public void setRprRqstLstVerFlg(String rprRqstLstVerFlg) {
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
	}
	
	/**
	 * Column Info
	 * @param eqCmpoCd
	 */
	public void setEqCmpoCd(String eqCmpoCd) {
		this.eqCmpoCd = eqCmpoCd;
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
	 * @param n3ptyBilAmt
	 */
	public void setN3ptyBilAmt(String n3ptyBilAmt) {
		this.n3ptyBilAmt = n3ptyBilAmt;
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
	 * @param rprLenNo
	 */
	public void setRprLenNo(String rprLenNo) {
		this.rprLenNo = rprLenNo;
	}
	
	/**
	 * Column Info
	 * @param trfDivCd
	 */
	public void setTrfDivCd(String trfDivCd) {
		this.trfDivCd = trfDivCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilLbrCostAmt
	 */
	public void setN3ptyBilLbrCostAmt(String n3ptyBilLbrCostAmt) {
		this.n3ptyBilLbrCostAmt = n3ptyBilLbrCostAmt;
	}
	
	/**
	 * Column Info
	 * @param rprLbrBzcRt
	 */
	public void setRprLbrBzcRt(String rprLbrBzcRt) {
		this.rprLbrBzcRt = rprLbrBzcRt;
	}
	
	/**
	 * Column Info
	 * @param eqRprCdChkFlg
	 */
	public void setEqRprCdChkFlg(String eqRprCdChkFlg) {
		this.eqRprCdChkFlg = eqRprCdChkFlg;
	}
	
	/**
	 * Column Info
	 * @param trfOptCd
	 */
	public void setTrfOptCd(String trfOptCd) {
		this.trfOptCd = trfOptCd;
	}
	
	/**
	 * Column Info
	 * @param rprRqstTmpDtlSeq
	 */
	public void setRprRqstTmpDtlSeq(String rprRqstTmpDtlSeq) {
		this.rprRqstTmpDtlSeq = rprRqstTmpDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param eqDmgCdChkFlg
	 */
	public void setEqDmgCdChkFlg(String eqDmgCdChkFlg) {
		this.eqDmgCdChkFlg = eqDmgCdChkFlg;
	}
	
	/**
	 * Column Info
	 * @param eqRprCd
	 */
	public void setEqRprCd(String eqRprCd) {
		this.eqRprCd = eqRprCd;
	}
	
	/**
	 * Column Info
	 * @param mnrLrAcctFlg
	 */
	public void setMnrLrAcctFlg(String mnrLrAcctFlg) {
		this.mnrLrAcctFlg = mnrLrAcctFlg;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilMtrlCostAmt
	 */
	public void setN3ptyBilMtrlCostAmt(String n3ptyBilMtrlCostAmt) {
		this.n3ptyBilMtrlCostAmt = n3ptyBilMtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param mtrlRecoAmt
	 */
	public void setMtrlRecoAmt(String mtrlRecoAmt) {
		this.mtrlRecoAmt = mtrlRecoAmt;
	}
	
	/**
	 * Column Info
	 * @param mnrLbrBzcAmt
	 */
	public void setMnrLbrBzcAmt(String mnrLbrBzcAmt) {
		this.mnrLbrBzcAmt = mnrLbrBzcAmt;
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
	 * @param rprLbrRt
	 */
	public void setRprLbrRt(String rprLbrRt) {
		this.rprLbrRt = rprLbrRt;
	}
	
	/**
	 * Column Info
	 * @param mtrlCostAmt
	 */
	public void setMtrlCostAmt(String mtrlCostAmt) {
		this.mtrlCostAmt = mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param rprRqstTmpVerNo
	 */
	public void setRprRqstTmpVerNo(String rprRqstTmpVerNo) {
		this.rprRqstTmpVerNo = rprRqstTmpVerNo;
	}
	
	/**
	 * Column Info
	 * @param rprLbrHrs
	 */
	public void setRprLbrHrs(String rprLbrHrs) {
		this.rprLbrHrs = rprLbrHrs;
	}
	
	/**
	 * Column Info
	 * @param eqLocCdChkFlg
	 */
	public void setEqLocCdChkFlg(String eqLocCdChkFlg) {
		this.eqLocCdChkFlg = eqLocCdChkFlg;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilLbrHrs
	 */
	public void setN3ptyBilLbrHrs(String n3ptyBilLbrHrs) {
		this.n3ptyBilLbrHrs = n3ptyBilLbrHrs;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMnrVrfyTpCd(JSPUtil.getParameter(request, "mnr_vrfy_tp_cd", ""));
		setEqLocCd(JSPUtil.getParameter(request, "eq_loc_cd", ""));
		setXchMtrlCostAmt(JSPUtil.getParameter(request, "xch_mtrl_cost_amt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRprDtlRmk(JSPUtil.getParameter(request, "rpr_dtl_rmk", ""));
		setN3ptyBilLbrRt(JSPUtil.getParameter(request, "n3pty_bil_lbr_rt", ""));
		setLbrMtrlBzcAmt(JSPUtil.getParameter(request, "lbr_mtrl_bzc_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRprLbrBzcHrs(JSPUtil.getParameter(request, "rpr_lbr_bzc_hrs", ""));
		setLbrCostAmt(JSPUtil.getParameter(request, "lbr_cost_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqDmgCd(JSPUtil.getParameter(request, "eq_dmg_cd", ""));
		setRprRqstTmpSeq(JSPUtil.getParameter(request, "rpr_rqst_tmp_seq", ""));
		setMnrAgmtAmt(JSPUtil.getParameter(request, "mnr_agmt_amt", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setRprSzNo(JSPUtil.getParameter(request, "rpr_sz_no", ""));
		setRqstEqNo(JSPUtil.getParameter(request, "rqst_eq_no", ""));
		setMnrWrkAmt(JSPUtil.getParameter(request, "mnr_wrk_amt", ""));
		setRprWdtNo(JSPUtil.getParameter(request, "rpr_wdt_no", ""));
		setRprQty(JSPUtil.getParameter(request, "rpr_qty", ""));
		setEqCmpoCdChkFlg(JSPUtil.getParameter(request, "eq_cmpo_cd_chk_flg", ""));
		setVolTpCd(JSPUtil.getParameter(request, "vol_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRprRqstLstVerFlg(JSPUtil.getParameter(request, "rpr_rqst_lst_ver_flg", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, "eq_cmpo_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setN3ptyBilAmt(JSPUtil.getParameter(request, "n3pty_bil_amt", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, "n3pty_flg", ""));
		setRprLenNo(JSPUtil.getParameter(request, "rpr_len_no", ""));
		setTrfDivCd(JSPUtil.getParameter(request, "trf_div_cd", ""));
		setN3ptyBilLbrCostAmt(JSPUtil.getParameter(request, "n3pty_bil_lbr_cost_amt", ""));
		setRprLbrBzcRt(JSPUtil.getParameter(request, "rpr_lbr_bzc_rt", ""));
		setEqRprCdChkFlg(JSPUtil.getParameter(request, "eq_rpr_cd_chk_flg", ""));
		setTrfOptCd(JSPUtil.getParameter(request, "trf_opt_cd", ""));
		setRprRqstTmpDtlSeq(JSPUtil.getParameter(request, "rpr_rqst_tmp_dtl_seq", ""));
		setEqDmgCdChkFlg(JSPUtil.getParameter(request, "eq_dmg_cd_chk_flg", ""));
		setEqRprCd(JSPUtil.getParameter(request, "eq_rpr_cd", ""));
		setMnrLrAcctFlg(JSPUtil.getParameter(request, "mnr_lr_acct_flg", ""));
		setN3ptyBilMtrlCostAmt(JSPUtil.getParameter(request, "n3pty_bil_mtrl_cost_amt", ""));
		setMtrlRecoAmt(JSPUtil.getParameter(request, "mtrl_reco_amt", ""));
		setMnrLbrBzcAmt(JSPUtil.getParameter(request, "mnr_lbr_bzc_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRprLbrRt(JSPUtil.getParameter(request, "rpr_lbr_rt", ""));
		setMtrlCostAmt(JSPUtil.getParameter(request, "mtrl_cost_amt", ""));
		setRprRqstTmpVerNo(JSPUtil.getParameter(request, "rpr_rqst_tmp_ver_no", ""));
		setRprLbrHrs(JSPUtil.getParameter(request, "rpr_lbr_hrs", ""));
		setEqLocCdChkFlg(JSPUtil.getParameter(request, "eq_loc_cd_chk_flg", ""));
		setN3ptyBilLbrHrs(JSPUtil.getParameter(request, "n3pty_bil_lbr_hrs", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrRprRqstTmpDtlVO[]
	 */
	public CustomMnrRprRqstTmpDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrRprRqstTmpDtlVO[]
	 */
	public CustomMnrRprRqstTmpDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrRprRqstTmpDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] eqLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd", length));
			String[] xchMtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "xch_mtrl_cost_amt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rprDtlRmk = (JSPUtil.getParameter(request, prefix	+ "rpr_dtl_rmk", length));
			String[] n3ptyBilLbrRt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_rt", length));
			String[] lbrMtrlBzcAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_mtrl_bzc_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rprLbrBzcHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_bzc_hrs", length));
			String[] lbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_cost_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqDmgCd = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd", length));
			String[] rprRqstTmpSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_tmp_seq", length));
			String[] mnrAgmtAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_agmt_amt", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] rprSzNo = (JSPUtil.getParameter(request, prefix	+ "rpr_sz_no", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] mnrWrkAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_wrk_amt", length));
			String[] rprWdtNo = (JSPUtil.getParameter(request, prefix	+ "rpr_wdt_no", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] eqCmpoCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd_chk_flg", length));
			String[] volTpCd = (JSPUtil.getParameter(request, prefix	+ "vol_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rprRqstLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_lst_ver_flg", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3ptyBilAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_amt", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] rprLenNo = (JSPUtil.getParameter(request, prefix	+ "rpr_len_no", length));
			String[] trfDivCd = (JSPUtil.getParameter(request, prefix	+ "trf_div_cd", length));
			String[] n3ptyBilLbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_cost_amt", length));
			String[] rprLbrBzcRt = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_bzc_rt", length));
			String[] eqRprCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd_chk_flg", length));
			String[] trfOptCd = (JSPUtil.getParameter(request, prefix	+ "trf_opt_cd", length));
			String[] rprRqstTmpDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_tmp_dtl_seq", length));
			String[] eqDmgCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd_chk_flg", length));
			String[] eqRprCd = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
			String[] mnrLrAcctFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_lr_acct_flg", length));
			String[] n3ptyBilMtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_mtrl_cost_amt", length));
			String[] mtrlRecoAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_reco_amt", length));
			String[] mnrLbrBzcAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_lbr_bzc_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rprLbrRt = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_rt", length));
			String[] mtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
			String[] rprRqstTmpVerNo = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_tmp_ver_no", length));
			String[] rprLbrHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_hrs", length));
			String[] eqLocCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd_chk_flg", length));
			String[] n3ptyBilLbrHrs = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_hrs", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrRprRqstTmpDtlVO();
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (eqLocCd[i] != null)
					model.setEqLocCd(eqLocCd[i]);
				if (xchMtrlCostAmt[i] != null)
					model.setXchMtrlCostAmt(xchMtrlCostAmt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rprDtlRmk[i] != null)
					model.setRprDtlRmk(rprDtlRmk[i]);
				if (n3ptyBilLbrRt[i] != null)
					model.setN3ptyBilLbrRt(n3ptyBilLbrRt[i]);
				if (lbrMtrlBzcAmt[i] != null)
					model.setLbrMtrlBzcAmt(lbrMtrlBzcAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rprLbrBzcHrs[i] != null)
					model.setRprLbrBzcHrs(rprLbrBzcHrs[i]);
				if (lbrCostAmt[i] != null)
					model.setLbrCostAmt(lbrCostAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqDmgCd[i] != null)
					model.setEqDmgCd(eqDmgCd[i]);
				if (rprRqstTmpSeq[i] != null)
					model.setRprRqstTmpSeq(rprRqstTmpSeq[i]);
				if (mnrAgmtAmt[i] != null)
					model.setMnrAgmtAmt(mnrAgmtAmt[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (rprSzNo[i] != null)
					model.setRprSzNo(rprSzNo[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (mnrWrkAmt[i] != null)
					model.setMnrWrkAmt(mnrWrkAmt[i]);
				if (rprWdtNo[i] != null)
					model.setRprWdtNo(rprWdtNo[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (eqCmpoCdChkFlg[i] != null)
					model.setEqCmpoCdChkFlg(eqCmpoCdChkFlg[i]);
				if (volTpCd[i] != null)
					model.setVolTpCd(volTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rprRqstLstVerFlg[i] != null)
					model.setRprRqstLstVerFlg(rprRqstLstVerFlg[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3ptyBilAmt[i] != null)
					model.setN3ptyBilAmt(n3ptyBilAmt[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (rprLenNo[i] != null)
					model.setRprLenNo(rprLenNo[i]);
				if (trfDivCd[i] != null)
					model.setTrfDivCd(trfDivCd[i]);
				if (n3ptyBilLbrCostAmt[i] != null)
					model.setN3ptyBilLbrCostAmt(n3ptyBilLbrCostAmt[i]);
				if (rprLbrBzcRt[i] != null)
					model.setRprLbrBzcRt(rprLbrBzcRt[i]);
				if (eqRprCdChkFlg[i] != null)
					model.setEqRprCdChkFlg(eqRprCdChkFlg[i]);
				if (trfOptCd[i] != null)
					model.setTrfOptCd(trfOptCd[i]);
				if (rprRqstTmpDtlSeq[i] != null)
					model.setRprRqstTmpDtlSeq(rprRqstTmpDtlSeq[i]);
				if (eqDmgCdChkFlg[i] != null)
					model.setEqDmgCdChkFlg(eqDmgCdChkFlg[i]);
				if (eqRprCd[i] != null)
					model.setEqRprCd(eqRprCd[i]);
				if (mnrLrAcctFlg[i] != null)
					model.setMnrLrAcctFlg(mnrLrAcctFlg[i]);
				if (n3ptyBilMtrlCostAmt[i] != null)
					model.setN3ptyBilMtrlCostAmt(n3ptyBilMtrlCostAmt[i]);
				if (mtrlRecoAmt[i] != null)
					model.setMtrlRecoAmt(mtrlRecoAmt[i]);
				if (mnrLbrBzcAmt[i] != null)
					model.setMnrLbrBzcAmt(mnrLbrBzcAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rprLbrRt[i] != null)
					model.setRprLbrRt(rprLbrRt[i]);
				if (mtrlCostAmt[i] != null)
					model.setMtrlCostAmt(mtrlCostAmt[i]);
				if (rprRqstTmpVerNo[i] != null)
					model.setRprRqstTmpVerNo(rprRqstTmpVerNo[i]);
				if (rprLbrHrs[i] != null)
					model.setRprLbrHrs(rprLbrHrs[i]);
				if (eqLocCdChkFlg[i] != null)
					model.setEqLocCdChkFlg(eqLocCdChkFlg[i]);
				if (n3ptyBilLbrHrs[i] != null)
					model.setN3ptyBilLbrHrs(n3ptyBilLbrHrs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrRprRqstTmpDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrRprRqstTmpDtlVO[]
	 */
	public CustomMnrRprRqstTmpDtlVO[] getCustomMnrRprRqstTmpDtlVOs(){
		CustomMnrRprRqstTmpDtlVO[] vos = (CustomMnrRprRqstTmpDtlVO[])models.toArray(new CustomMnrRprRqstTmpDtlVO[models.size()]);
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
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocCd = this.eqLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchMtrlCostAmt = this.xchMtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprDtlRmk = this.rprDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilLbrRt = this.n3ptyBilLbrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrMtrlBzcAmt = this.lbrMtrlBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrBzcHrs = this.rprLbrBzcHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrCostAmt = this.lbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgCd = this.eqDmgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstTmpSeq = this.rprRqstTmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrAgmtAmt = this.mnrAgmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprSzNo = this.rprSzNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWrkAmt = this.mnrWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprWdtNo = this.rprWdtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCdChkFlg = this.eqCmpoCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTpCd = this.volTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstLstVerFlg = this.rprRqstLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilAmt = this.n3ptyBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLenNo = this.rprLenNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDivCd = this.trfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilLbrCostAmt = this.n3ptyBilLbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrBzcRt = this.rprLbrBzcRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCdChkFlg = this.eqRprCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfOptCd = this.trfOptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstTmpDtlSeq = this.rprRqstTmpDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgCdChkFlg = this.eqDmgCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCd = this.eqRprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLrAcctFlg = this.mnrLrAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilMtrlCostAmt = this.n3ptyBilMtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlRecoAmt = this.mtrlRecoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLbrBzcAmt = this.mnrLbrBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrRt = this.rprLbrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCostAmt = this.mtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstTmpVerNo = this.rprRqstTmpVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrHrs = this.rprLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocCdChkFlg = this.eqLocCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilLbrHrs = this.n3ptyBilLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
