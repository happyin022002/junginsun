/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrRprRqstDtlVO.java
*@FileTitle : CustomMnrRprRqstDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.07.15 박명신 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
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

public class CustomMnrRprRqstDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrRprRqstDtlVO> models = new ArrayList<CustomMnrRprRqstDtlVO>();
	
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String eqLocCd = null;
	/* Column Info */
	private String xchMtrlCostAmt = null;
	/* Column Info */
	private String rprRqstVerNo = null;
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
	private String rprRqstDtlSeq = null;
	/* Column Info */
	private String lbrCostAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqDmgCd = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String rprSzNo = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String rprWdtNo = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String eqCmpoCdChkFlg = null;
	/* Column Info */
	private String rprRqstSeq = null;
	/* Column Info */
	private String volTpCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String rprRqstLstVerFlg = null;
	/* Column Info */
	private String eqCmpoCd = null;
	/* Column Info */
	private String rprLenNo = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3ptyBilAmt = null;
	/* Column Info */
	private String trfDivCd = null;
	/* Column Info */
	private String n3ptyBilLbrCostAmt = null;
	/* Column Info */
	private String rprLbrBzcRt = null;
	/* Column Info */
	private String trfOptCd = null;
	/* Column Info */
	private String eqRprCdChkFlg = null;
	/* Column Info */
	private String eqDmgCdChkFlg = null;
	/* Column Info */
	private String costDtlCd = null;
	/* Column Info */
	private String eqRprCd = null;
	/* Column Info */
	private String mnrLrAcctFlg = null;
	/* Column Info */
	private String mtrlRecoAmt = null;
	/* Column Info */
	private String n3ptyBilMtrlCostAmt = null;
	/* Column Info */
	private String mnrLbrBzcAmt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rprLbrRt = null;
	/* Column Info */
	private String mtrlCostAmt = null;
	/* Column Info */
	private String rprLbrHrs = null;
	/* Column Info */
	private String eqLocCdChkFlg = null;
	/* Column Info */
	private String n3ptyBilLbrHrs = null;
	/* Column Info */
	private String mnrWrkAmt = null;
	/* Column Info */
	private String costCdNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomMnrRprRqstDtlVO() {}

	public CustomMnrRprRqstDtlVO(String ibflag, String pagerows, String mnrVrfyTpCd, String eqLocCd, String xchMtrlCostAmt, String rprRqstVerNo, String creDt, String rprDtlRmk, String n3ptyBilLbrRt, String lbrMtrlBzcAmt, String rprRqstDtlSeq, String lbrCostAmt, String eqDmgCd, String rprSzNo, String rqstEqNo, String rprWdtNo, String rprQty, String eqCmpoCdChkFlg, String rprRqstSeq, String volTpCd, String updUsrId, String rprRqstLstVerFlg, String eqCmpoCd, String updDt, String n3ptyBilAmt, String n3ptyFlg, String rprLenNo, String trfDivCd, String n3ptyBilLbrCostAmt, String eqRprCdChkFlg, String trfOptCd, String eqDmgCdChkFlg, String eqRprCd, String mnrLrAcctFlg, String n3ptyBilMtrlCostAmt, String mtrlRecoAmt, String mnrLbrBzcAmt, String creUsrId, String rprLbrRt, String mtrlCostAmt, String rprLbrHrs, String eqLocCdChkFlg, String n3ptyBilLbrHrs, String rprLbrBzcRt, String rprLbrBzcHrs, String costCd, String costDtlCd,String mnrWrkAmt, String costCdNm) {
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.eqLocCd = eqLocCd;
		this.xchMtrlCostAmt = xchMtrlCostAmt;
		this.rprRqstVerNo = rprRqstVerNo;
		this.creDt = creDt;
		this.rprDtlRmk = rprDtlRmk;
		this.n3ptyBilLbrRt = n3ptyBilLbrRt;
		this.lbrMtrlBzcAmt = lbrMtrlBzcAmt;
		this.pagerows = pagerows;
		this.rprLbrBzcHrs = rprLbrBzcHrs;
		this.rprRqstDtlSeq = rprRqstDtlSeq;
		this.lbrCostAmt = lbrCostAmt;
		this.ibflag = ibflag;
		this.eqDmgCd = eqDmgCd;
		this.costCd = costCd;
		this.rprSzNo = rprSzNo;
		this.rqstEqNo = rqstEqNo;
		this.rprWdtNo = rprWdtNo;
		this.rprQty = rprQty;
		this.eqCmpoCdChkFlg = eqCmpoCdChkFlg;
		this.rprRqstSeq = rprRqstSeq;
		this.volTpCd = volTpCd;
		this.updUsrId = updUsrId;
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
		this.eqCmpoCd = eqCmpoCd;
		this.rprLenNo = rprLenNo;
		this.n3ptyFlg = n3ptyFlg;
		this.updDt = updDt;
		this.n3ptyBilAmt = n3ptyBilAmt;
		this.trfDivCd = trfDivCd;
		this.n3ptyBilLbrCostAmt = n3ptyBilLbrCostAmt;
		this.rprLbrBzcRt = rprLbrBzcRt;
		this.trfOptCd = trfOptCd;
		this.eqRprCdChkFlg = eqRprCdChkFlg;
		this.eqDmgCdChkFlg = eqDmgCdChkFlg;
		this.costDtlCd = costDtlCd;
		this.eqRprCd = eqRprCd;
		this.mnrLrAcctFlg = mnrLrAcctFlg;
		this.mtrlRecoAmt = mtrlRecoAmt;
		this.n3ptyBilMtrlCostAmt = n3ptyBilMtrlCostAmt;
		this.mnrLbrBzcAmt = mnrLbrBzcAmt;
		this.creUsrId = creUsrId;
		this.rprLbrRt = rprLbrRt;
		this.mtrlCostAmt = mtrlCostAmt;
		this.rprLbrHrs = rprLbrHrs;
		this.eqLocCdChkFlg = eqLocCdChkFlg;
		this.n3ptyBilLbrHrs = n3ptyBilLbrHrs;
		this.mnrWrkAmt = mnrWrkAmt; 
		this.costCdNm = costCdNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vol_tp_cd", getVolTpCd());
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("rpr_sz_no", getRprSzNo());
		this.hashColumns.put("xch_mtrl_cost_amt", getXchMtrlCostAmt());
		this.hashColumns.put("mnr_lr_acct_flg", getMnrLrAcctFlg());
		this.hashColumns.put("n3pty_bil_lbr_hrs", getN3ptyBilLbrHrs());
		this.hashColumns.put("n3pty_bil_lbr_cost_amt", getN3ptyBilLbrCostAmt());
		this.hashColumns.put("lbr_cost_amt", getLbrCostAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_cmpo_cd_chk_flg", getEqCmpoCdChkFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("n3pty_bil_lbr_rt", getN3ptyBilLbrRt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("trf_opt_cd", getTrfOptCd());
		this.hashColumns.put("rpr_rqst_lst_ver_flg", getRprRqstLstVerFlg());
		this.hashColumns.put("rpr_rqst_ver_no", getRprRqstVerNo());
		this.hashColumns.put("rpr_rqst_dtl_seq", getRprRqstDtlSeq());
		this.hashColumns.put("eq_loc_cd", getEqLocCd());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("eq_loc_cd_chk_flg", getEqLocCdChkFlg());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("rpr_lbr_bzc_hrs", getRprLbrBzcHrs());
		this.hashColumns.put("rpr_lbr_hrs", getRprLbrHrs());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("lbr_mtrl_bzc_amt", getLbrMtrlBzcAmt());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		this.hashColumns.put("rpr_len_no", getRprLenNo());
		this.hashColumns.put("eq_rpr_cd_chk_flg", getEqRprCdChkFlg());
		this.hashColumns.put("trf_div_cd", getTrfDivCd());
		this.hashColumns.put("rpr_wdt_no", getRprWdtNo());
		this.hashColumns.put("rpr_dtl_rmk", getRprDtlRmk());
		this.hashColumns.put("mnr_wrk_amt", getMnrWrkAmt());
		this.hashColumns.put("eq_dmg_cd", getEqDmgCd());
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());
		this.hashColumns.put("rpr_lbr_rt", getRprLbrRt());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("n3pty_bil_amt", getN3ptyBilAmt());
		this.hashColumns.put("eq_dmg_cd_chk_flg", getEqDmgCdChkFlg());
		this.hashColumns.put("mtrl_reco_amt", getMtrlRecoAmt());
		this.hashColumns.put("eq_rpr_cd", getEqRprCd());
		this.hashColumns.put("rpr_lbr_bzc_rt", getRprLbrBzcRt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_lbr_bzc_amt", getMnrLbrBzcAmt());
		this.hashColumns.put("n3pty_bil_mtrl_cost_amt", getN3ptyBilMtrlCostAmt());
		this.hashColumns.put("mtrl_cost_amt", getMtrlCostAmt());
		this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());
		this.hashColumns.put("cost_cd_nm", getCostCdNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vol_tp_cd", "volTpCd");
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("rpr_sz_no", "rprSzNo");
		this.hashFields.put("xch_mtrl_cost_amt", "xchMtrlCostAmt");
		this.hashFields.put("mnr_lr_acct_flg", "mnrLrAcctFlg");
		this.hashFields.put("n3pty_bil_lbr_hrs", "n3ptyBilLbrHrs");
		this.hashFields.put("n3pty_bil_lbr_cost_amt", "n3ptyBilLbrCostAmt");
		this.hashFields.put("lbr_cost_amt", "lbrCostAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_cmpo_cd_chk_flg", "eqCmpoCdChkFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("n3pty_bil_lbr_rt", "n3ptyBilLbrRt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trf_opt_cd", "trfOptCd");
		this.hashFields.put("rpr_rqst_lst_ver_flg", "rprRqstLstVerFlg");
		this.hashFields.put("rpr_rqst_ver_no", "rprRqstVerNo");
		this.hashFields.put("rpr_rqst_dtl_seq", "rprRqstDtlSeq");
		this.hashFields.put("eq_loc_cd", "eqLocCd");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("eq_loc_cd_chk_flg", "eqLocCdChkFlg");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("rpr_lbr_bzc_hrs", "rprLbrBzcHrs");
		this.hashFields.put("rpr_lbr_hrs", "rprLbrHrs");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("lbr_mtrl_bzc_amt", "lbrMtrlBzcAmt");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		this.hashFields.put("rpr_len_no", "rprLenNo");
		this.hashFields.put("eq_rpr_cd_chk_flg", "eqRprCdChkFlg");
		this.hashFields.put("trf_div_cd", "trfDivCd");
		this.hashFields.put("rpr_wdt_no", "rprWdtNo");
		this.hashFields.put("rpr_dtl_rmk", "rprDtlRmk");
		this.hashFields.put("mnr_wrk_amt", "mnrWrkAmt");
		this.hashFields.put("eq_dmg_cd", "eqDmgCd");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		this.hashFields.put("rpr_lbr_rt", "rprLbrRt");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("n3pty_bil_amt", "n3ptyBilAmt");
		this.hashFields.put("eq_dmg_cd_chk_flg", "eqDmgCdChkFlg");
		this.hashFields.put("mtrl_reco_amt", "mtrlRecoAmt");
		this.hashFields.put("eq_rpr_cd", "eqRprCd");
		this.hashFields.put("rpr_lbr_bzc_rt", "rprLbrBzcRt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_lbr_bzc_amt", "mnrLbrBzcAmt");
		this.hashFields.put("n3pty_bil_mtrl_cost_amt", "n3ptyBilMtrlCostAmt");
		this.hashFields.put("mtrl_cost_amt", "mtrlCostAmt");
		this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
		this.hashFields.put("cost_cd_nm", "costCdNm");
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
	 * @return rprRqstVerNo
	 */
	public String getRprRqstVerNo() {
		return this.rprRqstVerNo;
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
	 * @return rprRqstDtlSeq
	 */
	public String getRprRqstDtlSeq() {
		return this.rprRqstDtlSeq;
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
	 * @return rprRqstSeq
	 */
	public String getRprRqstSeq() {
		return this.rprRqstSeq;
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
	 * @return rprLenNo
	 */
	public String getRprLenNo() {
		return this.rprLenNo;
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
	 * @return n3ptyBilAmt
	 */
	public String getN3ptyBilAmt() {
		return this.n3ptyBilAmt;
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
	 * @return trfOptCd
	 */
	public String getTrfOptCd() {
		return this.trfOptCd;
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
	 * @return eqDmgCdChkFlg
	 */
	public String getEqDmgCdChkFlg() {
		return this.eqDmgCdChkFlg;
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
	 * @return mtrlRecoAmt
	 */
	public String getMtrlRecoAmt() {
		return this.mtrlRecoAmt;
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
	 * @return costCdNm
	 */
	public String getCostCdNm() {
		return this.costCdNm;
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
	 * @param rprRqstVerNo
	 */
	public void setRprRqstVerNo(String rprRqstVerNo) {
		this.rprRqstVerNo = rprRqstVerNo;
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
	 * @param rprRqstDtlSeq
	 */
	public void setRprRqstDtlSeq(String rprRqstDtlSeq) {
		this.rprRqstDtlSeq = rprRqstDtlSeq;
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
	 * @param rprRqstSeq
	 */
	public void setRprRqstSeq(String rprRqstSeq) {
		this.rprRqstSeq = rprRqstSeq;
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
	 * @param rprLenNo
	 */
	public void setRprLenNo(String rprLenNo) {
		this.rprLenNo = rprLenNo;
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
	 * @param n3ptyBilAmt
	 */
	public void setN3ptyBilAmt(String n3ptyBilAmt) {
		this.n3ptyBilAmt = n3ptyBilAmt;
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
	 * @param trfOptCd
	 */
	public void setTrfOptCd(String trfOptCd) {
		this.trfOptCd = trfOptCd;
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
	 * @param eqDmgCdChkFlg
	 */
	public void setEqDmgCdChkFlg(String eqDmgCdChkFlg) {
		this.eqDmgCdChkFlg = eqDmgCdChkFlg;
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
	 * @param mtrlRecoAmt
	 */
	public void setMtrlRecoAmt(String mtrlRecoAmt) {
		this.mtrlRecoAmt = mtrlRecoAmt;
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
	 * Column Info
	 * @param mnrWrkAmt
	 */
	public String getMnrWrkAmt() {
		return mnrWrkAmt; 
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
	 * @param mnrWrkAmt
	 */
	public void setCostCdNm(String costCdNm) {
		this.costCdNm = costCdNm;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMnrVrfyTpCd(JSPUtil.getParameter(request, "mnr_vrfy_tp_cd", ""));
		setEqLocCd(JSPUtil.getParameter(request, "eq_loc_cd", ""));
		setXchMtrlCostAmt(JSPUtil.getParameter(request, "xch_mtrl_cost_amt", ""));
		setRprRqstVerNo(JSPUtil.getParameter(request, "rpr_rqst_ver_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRprDtlRmk(JSPUtil.getParameter(request, "rpr_dtl_rmk", ""));
		setN3ptyBilLbrRt(JSPUtil.getParameter(request, "n3pty_bil_lbr_rt", ""));
		setLbrMtrlBzcAmt(JSPUtil.getParameter(request, "lbr_mtrl_bzc_amt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRprLbrBzcHrs(JSPUtil.getParameter(request, "rpr_lbr_bzc_hrs", ""));
		setRprRqstDtlSeq(JSPUtil.getParameter(request, "rpr_rqst_dtl_seq", ""));
		setLbrCostAmt(JSPUtil.getParameter(request, "lbr_cost_amt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqDmgCd(JSPUtil.getParameter(request, "eq_dmg_cd", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setRprSzNo(JSPUtil.getParameter(request, "rpr_sz_no", ""));
		setRqstEqNo(JSPUtil.getParameter(request, "rqst_eq_no", ""));
		setRprWdtNo(JSPUtil.getParameter(request, "rpr_wdt_no", ""));
		setRprQty(JSPUtil.getParameter(request, "rpr_qty", ""));
		setEqCmpoCdChkFlg(JSPUtil.getParameter(request, "eq_cmpo_cd_chk_flg", ""));
		setRprRqstSeq(JSPUtil.getParameter(request, "rpr_rqst_seq", ""));
		setVolTpCd(JSPUtil.getParameter(request, "vol_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setRprRqstLstVerFlg(JSPUtil.getParameter(request, "rpr_rqst_lst_ver_flg", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, "eq_cmpo_cd", ""));
		setRprLenNo(JSPUtil.getParameter(request, "rpr_len_no", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, "n3pty_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setN3ptyBilAmt(JSPUtil.getParameter(request, "n3pty_bil_amt", ""));
		setTrfDivCd(JSPUtil.getParameter(request, "trf_div_cd", ""));
		setN3ptyBilLbrCostAmt(JSPUtil.getParameter(request, "n3pty_bil_lbr_cost_amt", ""));
		setRprLbrBzcRt(JSPUtil.getParameter(request, "rpr_lbr_bzc_rt", ""));
		setTrfOptCd(JSPUtil.getParameter(request, "trf_opt_cd", ""));
		setEqRprCdChkFlg(JSPUtil.getParameter(request, "eq_rpr_cd_chk_flg", ""));
		setEqDmgCdChkFlg(JSPUtil.getParameter(request, "eq_dmg_cd_chk_flg", ""));
		setCostDtlCd(JSPUtil.getParameter(request, "cost_dtl_cd", ""));
		setEqRprCd(JSPUtil.getParameter(request, "eq_rpr_cd", ""));
		setMnrLrAcctFlg(JSPUtil.getParameter(request, "mnr_lr_acct_flg", ""));
		setMtrlRecoAmt(JSPUtil.getParameter(request, "mtrl_reco_amt", ""));
		setN3ptyBilMtrlCostAmt(JSPUtil.getParameter(request, "n3pty_bil_mtrl_cost_amt", ""));
		setMnrLbrBzcAmt(JSPUtil.getParameter(request, "mnr_lbr_bzc_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setRprLbrRt(JSPUtil.getParameter(request, "rpr_lbr_rt", ""));
		setMtrlCostAmt(JSPUtil.getParameter(request, "mtrl_cost_amt", ""));
		setRprLbrHrs(JSPUtil.getParameter(request, "rpr_lbr_hrs", ""));
		setEqLocCdChkFlg(JSPUtil.getParameter(request, "eq_loc_cd_chk_flg", ""));
		setN3ptyBilLbrHrs(JSPUtil.getParameter(request, "n3pty_bil_lbr_hrs", ""));
		setMnrWrkAmt(JSPUtil.getParameter(request, "mnr_wrk_amt", ""));
		setCostCdNm(JSPUtil.getParameter(request, "cost_cd_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrRprRqstDtlVO[]
	 */
	public CustomMnrRprRqstDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrRprRqstDtlVO[]
	 */
	public CustomMnrRprRqstDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrRprRqstDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] eqLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd", length));
			String[] xchMtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "xch_mtrl_cost_amt", length));
			String[] rprRqstVerNo = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_ver_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rprDtlRmk = (JSPUtil.getParameter(request, prefix	+ "rpr_dtl_rmk", length));
			String[] n3ptyBilLbrRt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_rt", length));
			String[] lbrMtrlBzcAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_mtrl_bzc_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rprLbrBzcHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_bzc_hrs", length));
			String[] rprRqstDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_dtl_seq", length));
			String[] lbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_cost_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqDmgCd = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] rprSzNo = (JSPUtil.getParameter(request, prefix	+ "rpr_sz_no", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] rprWdtNo = (JSPUtil.getParameter(request, prefix	+ "rpr_wdt_no", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] eqCmpoCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd_chk_flg", length));
			String[] rprRqstSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_seq", length));
			String[] volTpCd = (JSPUtil.getParameter(request, prefix	+ "vol_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] rprRqstLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_lst_ver_flg", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			String[] rprLenNo = (JSPUtil.getParameter(request, prefix	+ "rpr_len_no", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3ptyBilAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_amt", length));
			String[] trfDivCd = (JSPUtil.getParameter(request, prefix	+ "trf_div_cd", length));
			String[] n3ptyBilLbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_cost_amt", length));
			String[] rprLbrBzcRt = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_bzc_rt", length));
			String[] trfOptCd = (JSPUtil.getParameter(request, prefix	+ "trf_opt_cd", length));
			String[] eqRprCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd_chk_flg", length));
			String[] eqDmgCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd_chk_flg", length));
			String[] costDtlCd = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length));
			String[] eqRprCd = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
			String[] mnrLrAcctFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_lr_acct_flg", length));
			String[] mtrlRecoAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_reco_amt", length));
			String[] n3ptyBilMtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_mtrl_cost_amt", length));
			String[] mnrLbrBzcAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_lbr_bzc_amt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rprLbrRt = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_rt", length));
			String[] mtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
			String[] rprLbrHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_hrs", length));
			String[] eqLocCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd_chk_flg", length));
			String[] n3ptyBilLbrHrs = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_hrs", length));
			String[] mnrWrkAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_wrk_amt", length));
			String[] costCdNm = (JSPUtil.getParameter(request, prefix	+ "cost_cd_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrRprRqstDtlVO();
				if (mnrVrfyTpCd[i] != null) 
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (eqLocCd[i] != null)
					model.setEqLocCd(eqLocCd[i]);
				if (xchMtrlCostAmt[i] != null)
					model.setXchMtrlCostAmt(xchMtrlCostAmt[i]);
				if (rprRqstVerNo[i] != null)
					model.setRprRqstVerNo(rprRqstVerNo[i]);
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
				if (rprRqstDtlSeq[i] != null)
					model.setRprRqstDtlSeq(rprRqstDtlSeq[i]);
				if (lbrCostAmt[i] != null)
					model.setLbrCostAmt(lbrCostAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqDmgCd[i] != null)
					model.setEqDmgCd(eqDmgCd[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (rprSzNo[i] != null)
					model.setRprSzNo(rprSzNo[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (rprWdtNo[i] != null)
					model.setRprWdtNo(rprWdtNo[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (eqCmpoCdChkFlg[i] != null)
					model.setEqCmpoCdChkFlg(eqCmpoCdChkFlg[i]);
				if (rprRqstSeq[i] != null)
					model.setRprRqstSeq(rprRqstSeq[i]);
				if (volTpCd[i] != null)
					model.setVolTpCd(volTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (rprRqstLstVerFlg[i] != null)
					model.setRprRqstLstVerFlg(rprRqstLstVerFlg[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				if (rprLenNo[i] != null)
					model.setRprLenNo(rprLenNo[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3ptyBilAmt[i] != null)
					model.setN3ptyBilAmt(n3ptyBilAmt[i]);
				if (trfDivCd[i] != null)
					model.setTrfDivCd(trfDivCd[i]);
				if (n3ptyBilLbrCostAmt[i] != null)
					model.setN3ptyBilLbrCostAmt(n3ptyBilLbrCostAmt[i]);
				if (rprLbrBzcRt[i] != null)
					model.setRprLbrBzcRt(rprLbrBzcRt[i]);
				if (trfOptCd[i] != null)
					model.setTrfOptCd(trfOptCd[i]);
				if (eqRprCdChkFlg[i] != null)
					model.setEqRprCdChkFlg(eqRprCdChkFlg[i]);
				if (eqDmgCdChkFlg[i] != null)
					model.setEqDmgCdChkFlg(eqDmgCdChkFlg[i]);
				if (costDtlCd[i] != null)
					model.setCostDtlCd(costDtlCd[i]);
				if (eqRprCd[i] != null)
					model.setEqRprCd(eqRprCd[i]);
				if (mnrLrAcctFlg[i] != null)
					model.setMnrLrAcctFlg(mnrLrAcctFlg[i]);
				if (mtrlRecoAmt[i] != null)
					model.setMtrlRecoAmt(mtrlRecoAmt[i]);
				if (n3ptyBilMtrlCostAmt[i] != null)
					model.setN3ptyBilMtrlCostAmt(n3ptyBilMtrlCostAmt[i]);
				if (mnrLbrBzcAmt[i] != null)
					model.setMnrLbrBzcAmt(mnrLbrBzcAmt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rprLbrRt[i] != null)
					model.setRprLbrRt(rprLbrRt[i]);
				if (mtrlCostAmt[i] != null)
					model.setMtrlCostAmt(mtrlCostAmt[i]);
				if (rprLbrHrs[i] != null)
					model.setRprLbrHrs(rprLbrHrs[i]);
				if (eqLocCdChkFlg[i] != null)
					model.setEqLocCdChkFlg(eqLocCdChkFlg[i]);
				if (n3ptyBilLbrHrs[i] != null)
					model.setN3ptyBilLbrHrs(n3ptyBilLbrHrs[i]);
				if (mnrWrkAmt[i] != null)
					model.setMnrWrkAmt(mnrWrkAmt[i]);
				if (costCdNm[i] != null)
					model.setCostCdNm(costCdNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrRprRqstDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrRprRqstDtlVO[]
	 */
	public CustomMnrRprRqstDtlVO[] getCustomMnrRprRqstDtlVOs(){
		CustomMnrRprRqstDtlVO[] vos = (CustomMnrRprRqstDtlVO[])models.toArray(new CustomMnrRprRqstDtlVO[models.size()]);
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
		this.rprRqstVerNo = this.rprRqstVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprDtlRmk = this.rprDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilLbrRt = this.n3ptyBilLbrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrMtrlBzcAmt = this.lbrMtrlBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrBzcHrs = this.rprLbrBzcHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstDtlSeq = this.rprRqstDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrCostAmt = this.lbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgCd = this.eqDmgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprSzNo = this.rprSzNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprWdtNo = this.rprWdtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCdChkFlg = this.eqCmpoCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstSeq = this.rprRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTpCd = this.volTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstLstVerFlg = this.rprRqstLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLenNo = this.rprLenNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilAmt = this.n3ptyBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDivCd = this.trfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilLbrCostAmt = this.n3ptyBilLbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrBzcRt = this.rprLbrBzcRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfOptCd = this.trfOptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCdChkFlg = this.eqRprCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgCdChkFlg = this.eqDmgCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd = this.costDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCd = this.eqRprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLrAcctFlg = this.mnrLrAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlRecoAmt = this.mtrlRecoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilMtrlCostAmt = this.n3ptyBilMtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLbrBzcAmt = this.mnrLbrBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrRt = this.rprLbrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCostAmt = this.mtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrHrs = this.rprLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocCdChkFlg = this.eqLocCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilLbrHrs = this.n3ptyBilLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWrkAmt = this.mnrWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCdNm = this.costCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
	
	//사용자 추가 항목   
	/**
	 * CustomMnrDatVrfyVO 배열을 반환	
	 * @return CustomMnrDatVrfyVO[]
	 */
	public CustomMnrDatVrfyVO[] getCustomMnrDatVrfyVOs( Collection<CustomMnrDatVrfyVO> models){ 
		CustomMnrDatVrfyVO[] vos = (CustomMnrDatVrfyVO[])models.toArray(new CustomMnrDatVrfyVO[models.size()]);
		return vos;	
	}	

	/**
	* Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	* @param request
	* @param prefix
	* @return CustomMnrDatVrfyVO[]
	*/	
	public CustomMnrDatVrfyVO[] fromDatVrfyVORequestGrid(HttpServletRequest request, String prefix) {
	CustomMnrDatVrfyVO model = null;		
	Collection<CustomMnrDatVrfyVO> models = new ArrayList<CustomMnrDatVrfyVO>();

	String[] tmp = request.getParameterValues(prefix + "ibflag");
	if(tmp == null)
	return null;

	int length = request.getParameterValues(prefix + "ibflag").length;

	try {
		String[] ibflag = (JSPUtil.getParameter(request, prefix		+ "ibflag", length));
		String[] inpMsg1 = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd", length));
		String[] inpMsg2 = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
		String[] inpMsg3 = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd", length));
			
		//4번이 result 
		String[] inpMsg4 = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
		
		String[] inpMsg5 = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
		String[] inpMsg6 = (JSPUtil.getParameter(request, prefix	+ "trf_opt_cd", length));
		String[] inpMsg7 = (JSPUtil.getParameter(request, prefix	+ "trf_div_cd", length));
		String[] inpMsg8 = (JSPUtil.getParameter(request, prefix	+ "vol_tp_cd", length)); 
		String[] inpMsg9 = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
		String[] inpMsg10 = (JSPUtil.getParameter(request, prefix	+ "rpr_sz_no", length));
		String[] inpMsg11 = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_hrs", length));
		String[] inpMsg12 = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_rt", length));
		String[] inpMsg13 = (JSPUtil.getParameter(request, prefix	+ "lbr_cost_amt", length));
		String[] inpMsg14 = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
		String[] inpMsg15 = (JSPUtil.getParameter(request, prefix	+ "mnr_wrk_amt", length));
		String[] inpMsg16 = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_bzc_hrs", length));
		String[] inpMsg17 = (JSPUtil.getParameter(request, prefix	+ "lbr_mtrl_bzc_amt", length));
		String[] inpMsg18 = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_bzc_rt", length));
		String[] inpMsg19 = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
		String[] inpMsg20 = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length)); 
		String[] inpMsg21 = (JSPUtil.getParameter(request, prefix	+ "mnr_lr_acct_flg", length)); 
		String[] inpMsg22 = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length)); 
		String[] inpMsg23 = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_hrs", length)); 
		String[] inpMsg24 = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_rt", length)); 
		String[] inpMsg25 = (JSPUtil.getParameter(request, prefix	+ "n3pty_lbr_cost_amt", length)); 
		String[] inpMsg26 = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_mtrl_cost_amt", length)); 
		String[] inpMsg27 = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_amt", length)); 
		String[] inpMsg28 = (JSPUtil.getParameter(request, prefix	+ "mnr_lbr_bzc_amt", length)); 
		String[] inpMsg29 = (JSPUtil.getParameter(request, prefix	+ "mnr_agmt_amt", length)); 
		String[] inpMsg30 = (JSPUtil.getParameter(request, prefix	+ "rpr_dtl_rmk", length)); 
			
		for (int i = 0; i < length; i++) {
			model = new CustomMnrDatVrfyVO();
			if (inpMsg2[i] != null)
				model.setInpMsg2(inpMsg2[i]);
			if (inpMsg3[i] != null)
				model.setInpMsg3(inpMsg3[i]);
			if (inpMsg4[i] != null)
				model.setInpMsg4(inpMsg4[i]);
			if (inpMsg5[i] != null)
				model.setInpMsg5(inpMsg5[i]);
			if (inpMsg1[i] != null)
				model.setInpMsg1(inpMsg1[i]);
			if (ibflag[i] != null)
				model.setIbflag(ibflag[i]);
			if (inpMsg10[i] != null)
				model.setInpMsg10(inpMsg10[i]);
			if (inpMsg12[i] != null)
				model.setInpMsg12(inpMsg12[i]);
			if (inpMsg11[i] != null)
				model.setInpMsg11(inpMsg11[i]);
			if (inpMsg9[i] != null)
				model.setInpMsg9(inpMsg9[i]);
			if (inpMsg14[i] != null)
				model.setInpMsg14(inpMsg14[i]);
			if (inpMsg8[i] != null)
				model.setInpMsg8(inpMsg8[i]);
			if (inpMsg13[i] != null)
				model.setInpMsg13(inpMsg13[i]);
			if (inpMsg7[i] != null)
				model.setInpMsg7(inpMsg7[i]);
			if (inpMsg6[i] != null)
				model.setInpMsg6(inpMsg6[i]);
			if (inpMsg15[i] != null)
				model.setInpMsg15(inpMsg15[i]);
			if (inpMsg16[i] != null)
				model.setInpMsg16(inpMsg16[i]);
			if (inpMsg17[i] != null)
				model.setInpMsg17(inpMsg17[i]);
			if (inpMsg18[i] != null)
				model.setInpMsg18(inpMsg18[i]);
			if (inpMsg19[i] != null)
				model.setInpMsg19(inpMsg19[i]);
			if (inpMsg20[i] != null) 
				model.setInpMsg20(inpMsg20[i]);
			if (inpMsg21[i] != null) 
				model.setInpMsg21(inpMsg21[i]);
			if (inpMsg22[i] != null) 
				model.setInpMsg22(inpMsg22[i]);
			if (inpMsg23[i] != null) 
				model.setInpMsg23(inpMsg23[i]);
			if (inpMsg24[i] != null) 
				model.setInpMsg24(inpMsg24[i]);
			if (inpMsg25[i] != null) 
				model.setInpMsg25(inpMsg25[i]);
			if (inpMsg26[i] != null) 
				model.setInpMsg26(inpMsg26[i]);
			if (inpMsg27[i] != null) 
				model.setInpMsg27(inpMsg27[i]);
			if (inpMsg28[i] != null) 
				model.setInpMsg28(inpMsg28[i]);
			if (inpMsg29[i] != null)    
				model.setInpMsg29(inpMsg29[i]);
			if (inpMsg30[i] != null)    
				model.setInpMsg30(inpMsg30[i]); 
			models.add(model);	    	
		}		
			
	} catch (Exception e) {
		return null;
	}
		return getCustomMnrDatVrfyVOs(models);
	}
}
