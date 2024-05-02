/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CustomMnrRprRqstVDtlVO.java
*@FileTitle : CustomMnrRprRqstVDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.06.03 김영오 
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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrRprRqstVDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrRprRqstVDtlVO> models = new ArrayList<CustomMnrRprRqstVDtlVO>();
	
	/* Column Info */
	private String inpMsg2 = null;
	/* Column Info */
	private String inpMsg3 = null;
	/* Column Info */
	private String tempValue9 = null;
	/* Column Info */
	private String inpMsg4 = null;
	/* Column Info */
	private String inpMsg5 = null;
	/* Column Info */
	private String tempValue7 = null;
	/* Column Info */
	private String tempValue8 = null;
	/* Column Info */
	private String tempValue5 = null;
	/* Column Info */
	private String tempValue6 = null;
	/* Column Info */
	private String inpMsg1 = null;
	/* Column Info */
	private String tempValue3 = null;
	/* Column Info */
	private String tempValue4 = null;
	/* Column Info */
	private String tempValue1 = null;
	/* Column Info */
	private String tempValue2 = null;
	/* Column Info */
	private String n3ptyBilLbrRt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String inpMsg48 = null;
	/* Column Info */
	private String inpMsg49 = null;
	/* Column Info */
	private String inpMsg46 = null;
	/* Column Info */
	private String inpMsg47 = null;
	/* Column Info */
	private String inpMsg44 = null;
	/* Column Info */
	private String inpMsg45 = null;
	/* Column Info */
	private String inpMsg42 = null;
	/* Column Info */
	private String inpMsg43 = null;
	/* Column Info */
	private String inpMsg40 = null;
	/* Column Info */
	private String volTpCd = null;
	/* Column Info */
	private String inpMsg41 = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String n3ptyBilLbrCostAmt = null;
	/* Column Info */
	private String trfOptCd = null;
	/* Column Info */
	private String eqRprCd = null;
	/* Column Info */
	private String mnrLrAcctFlg = null;
	/* Column Info */
	private String mtrlRecoAmt = null;
	/* Column Info */
	private String mtrlCostAmt = null;
	/* Column Info */
	private String inpMsg9 = null;
	/* Column Info */
	private String inpMsg50 = null;
	/* Column Info */
	private String inpMsg8 = null;
	/* Column Info */
	private String inpMsg7 = null;
	/* Column Info */
	private String tmpDtlSeq = null;
	/* Column Info */
	private String inpMsg6 = null;
	/* Column Info */
	private String mnrVrfyTpCd = null;
	/* Column Info */
	private String rprRqstVerNo = null;
	/* Column Info */
	private String rprLbrBzcHrs = null;
	/* Column Info */
	private String rprRqstDtlSeq = null;
	/* Column Info */
	private String mnrAgmtAmt = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String rprQty = null;
	/* Column Info */
	private String eqCmpoCdChkFlg = null;
	/* Column Info */
	private String tempValue10 = null;
	/* Column Info */
	private String rprRqstLstVerFlg = null;
	/* Column Info */
	private String eqCmpoCd = null;
	/* Column Info */
	private String costDtlCd = null;
	/* Column Info */
	private String eqLocCdChkFlg = null;
	/* Column Info */
	private String xchMtrlCostAmt = null;
	/* Column Info */
	private String lbrMtrlBzcAmt = null;
	/* Column Info */
	private String eqDmgCd = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String rprSzNo = null;
	/* Column Info */
	private String mnrWrkAmt = null;
	/* Column Info */
	private String rprWdtNo = null;
	/* Column Info */
	private String rprRqstSeq = null;
	/* Column Info */
	private String rprLenNo = null;
	/* Column Info */
	private String n3ptyBilAmt = null;
	/* Column Info */
	private String trfDivCd = null;
	/* Column Info */
	private String rprLbrBzcRt = null;
	/* Column Info */
	private String eqRprCdChkFlg = null;
	/* Column Info */
	private String eqDmgCdChkFlg = null;
	/* Column Info */
	private String n3ptyBilMtrlCostAmt = null;
	/* Column Info */
	private String inpMsg10 = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String inpMsg12 = null;
	/* Column Info */
	private String inpMsg11 = null;
	/* Column Info */
	private String inpMsg18 = null;
	/* Column Info */
	private String inpMsg17 = null;
	/* Column Info */
	private String rprLbrHrs = null;
	/* Column Info */
	private String inpMsg19 = null;
	/* Column Info */
	private String inpMsg14 = null;
	/* Column Info */
	private String inpMsg13 = null;
	/* Column Info */
	private String inpMsg16 = null;
	/* Column Info */
	private String inpMsg15 = null;
	/* Column Info */
	private String eqLocCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rprDtlRmk = null;
	/* Column Info */
	private String tmpSeq = null;
	/* Column Info */
	private String lbrCostAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String inpMsg23 = null;
	/* Column Info */
	private String inpMsg22 = null;
	/* Column Info */
	private String inpMsg21 = null;
	/* Column Info */
	private String inpMsg20 = null;
	/* Column Info */
	private String inpMsg27 = null;
	/* Column Info */
	private String inpMsg26 = null;
	/* Column Info */
	private String inpMsg25 = null;
	/* Column Info */
	private String inpMsg24 = null;
	/* Column Info */
	private String inpMsg29 = null;
	/* Column Info */
	private String inpMsg28 = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String mnrLbrBzcAmt = null;
	/* Column Info */
	private String inpMsg30 = null;
	/* Column Info */
	private String rprLbrRt = null;
	/* Column Info */
	private String inpMsg32 = null;
	/* Column Info */
	private String inpMsg31 = null;
	/* Column Info */
	private String inpMsg34 = null;
	/* Column Info */
	private String inpMsg33 = null;
	/* Column Info */
	private String inpMsg36 = null;
	/* Column Info */
	private String inpMsg35 = null;
	/* Column Info */
	private String inpMsg38 = null;
	/* Column Info */
	private String inpMsg37 = null;
	/* Column Info */
	private String inpMsg39 = null;
	/* Column Info */
	private String n3ptyBilLbrHrs = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrRprRqstVDtlVO() {}

	public CustomMnrRprRqstVDtlVO(String ibflag, String pagerows, String mnrVrfyTpCd, String eqLocCd, String xchMtrlCostAmt, String rprRqstVerNo, String creDt, String rprDtlRmk, String n3ptyBilLbrRt, String lbrMtrlBzcAmt, String rprLbrBzcHrs, String rprRqstDtlSeq, String lbrCostAmt, String eqDmgCd, String costCd, String rprSzNo, String rqstEqNo, String mnrWrkAmt, String rprWdtNo, String rprQty, String eqCmpoCdChkFlg, String rprRqstSeq, String volTpCd, String updUsrId, String rprRqstLstVerFlg, String eqCmpoCd, String updDt, String n3ptyBilAmt, String n3ptyFlg, String rprLenNo, String trfDivCd, String n3ptyBilLbrCostAmt, String rprLbrBzcRt, String eqRprCdChkFlg, String trfOptCd, String eqDmgCdChkFlg, String costDtlCd, String eqRprCd, String mnrLrAcctFlg, String n3ptyBilMtrlCostAmt, String mtrlRecoAmt, String mnrLbrBzcAmt, String creUsrId, String rprLbrRt, String mtrlCostAmt, String rprLbrHrs, String eqLocCdChkFlg, String n3ptyBilLbrHrs, String mnrAgmtAmt, String inpMsg2, String inpMsg3, String tempValue9, String inpMsg4, String inpMsg5, String tempValue7, String tempValue8, String tempValue5, String tempValue6, String inpMsg1, String tempValue3, String tempValue4, String tempValue1, String tempValue2, String inpMsg48, String inpMsg49, String inpMsg46, String inpMsg47, String inpMsg44, String inpMsg45, String inpMsg42, String inpMsg43, String inpMsg40, String inpMsg41, String inpMsg10, String inpMsg12, String inpMsg11, String inpMsg18, String inpMsg17, String inpMsg19, String inpMsg9, String inpMsg14, String inpMsg50, String inpMsg8, String inpMsg13, String inpMsg16, String inpMsg7, String tmpDtlSeq, String inpMsg15, String inpMsg6, String tmpSeq, String inpMsg23, String inpMsg22, String inpMsg21, String inpMsg20, String inpMsg27, String inpMsg26, String tempValue10, String inpMsg25, String inpMsg24, String inpMsg29, String inpMsg28, String inpMsg30, String inpMsg32, String inpMsg31, String inpMsg34, String inpMsg33, String inpMsg36, String inpMsg35, String inpMsg38, String inpMsg37, String inpMsg39) {
		this.inpMsg2 = inpMsg2;
		this.inpMsg3 = inpMsg3;
		this.tempValue9 = tempValue9;
		this.inpMsg4 = inpMsg4;
		this.inpMsg5 = inpMsg5;
		this.tempValue7 = tempValue7;
		this.tempValue8 = tempValue8;
		this.tempValue5 = tempValue5;
		this.tempValue6 = tempValue6;
		this.inpMsg1 = inpMsg1;
		this.tempValue3 = tempValue3;
		this.tempValue4 = tempValue4;
		this.tempValue1 = tempValue1;
		this.tempValue2 = tempValue2;
		this.n3ptyBilLbrRt = n3ptyBilLbrRt;
		this.pagerows = pagerows;
		this.inpMsg48 = inpMsg48;
		this.inpMsg49 = inpMsg49;
		this.inpMsg46 = inpMsg46;
		this.inpMsg47 = inpMsg47;
		this.inpMsg44 = inpMsg44;
		this.inpMsg45 = inpMsg45;
		this.inpMsg42 = inpMsg42;
		this.inpMsg43 = inpMsg43;
		this.inpMsg40 = inpMsg40;
		this.volTpCd = volTpCd;
		this.inpMsg41 = inpMsg41;
		this.updUsrId = updUsrId;
		this.n3ptyBilLbrCostAmt = n3ptyBilLbrCostAmt;
		this.trfOptCd = trfOptCd;
		this.eqRprCd = eqRprCd;
		this.mnrLrAcctFlg = mnrLrAcctFlg;
		this.mtrlRecoAmt = mtrlRecoAmt;
		this.mtrlCostAmt = mtrlCostAmt;
		this.inpMsg9 = inpMsg9;
		this.inpMsg50 = inpMsg50;
		this.inpMsg8 = inpMsg8;
		this.inpMsg7 = inpMsg7;
		this.tmpDtlSeq = tmpDtlSeq;
		this.inpMsg6 = inpMsg6;
		this.mnrVrfyTpCd = mnrVrfyTpCd;
		this.rprRqstVerNo = rprRqstVerNo;
		this.rprLbrBzcHrs = rprLbrBzcHrs;
		this.rprRqstDtlSeq = rprRqstDtlSeq;
		this.mnrAgmtAmt = mnrAgmtAmt;
		this.rqstEqNo = rqstEqNo;
		this.rprQty = rprQty;
		this.eqCmpoCdChkFlg = eqCmpoCdChkFlg;
		this.tempValue10 = tempValue10;
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
		this.eqCmpoCd = eqCmpoCd;
		this.costDtlCd = costDtlCd;
		this.eqLocCdChkFlg = eqLocCdChkFlg;
		this.xchMtrlCostAmt = xchMtrlCostAmt;
		this.lbrMtrlBzcAmt = lbrMtrlBzcAmt;
		this.eqDmgCd = eqDmgCd;
		this.costCd = costCd;
		this.rprSzNo = rprSzNo;
		this.mnrWrkAmt = mnrWrkAmt;
		this.rprWdtNo = rprWdtNo;
		this.rprRqstSeq = rprRqstSeq;
		this.rprLenNo = rprLenNo;
		this.n3ptyBilAmt = n3ptyBilAmt;
		this.trfDivCd = trfDivCd;
		this.rprLbrBzcRt = rprLbrBzcRt;
		this.eqRprCdChkFlg = eqRprCdChkFlg;
		this.eqDmgCdChkFlg = eqDmgCdChkFlg;
		this.n3ptyBilMtrlCostAmt = n3ptyBilMtrlCostAmt;
		this.inpMsg10 = inpMsg10;
		this.creUsrId = creUsrId;
		this.inpMsg12 = inpMsg12;
		this.inpMsg11 = inpMsg11;
		this.inpMsg18 = inpMsg18;
		this.inpMsg17 = inpMsg17;
		this.rprLbrHrs = rprLbrHrs;
		this.inpMsg19 = inpMsg19;
		this.inpMsg14 = inpMsg14;
		this.inpMsg13 = inpMsg13;
		this.inpMsg16 = inpMsg16;
		this.inpMsg15 = inpMsg15;
		this.eqLocCd = eqLocCd;
		this.creDt = creDt;
		this.rprDtlRmk = rprDtlRmk;
		this.tmpSeq = tmpSeq;
		this.lbrCostAmt = lbrCostAmt;
		this.ibflag = ibflag;
		this.inpMsg23 = inpMsg23;
		this.inpMsg22 = inpMsg22;
		this.inpMsg21 = inpMsg21;
		this.inpMsg20 = inpMsg20;
		this.inpMsg27 = inpMsg27;
		this.inpMsg26 = inpMsg26;
		this.inpMsg25 = inpMsg25;
		this.inpMsg24 = inpMsg24;
		this.inpMsg29 = inpMsg29;
		this.inpMsg28 = inpMsg28;
		this.n3ptyFlg = n3ptyFlg;
		this.updDt = updDt;
		this.mnrLbrBzcAmt = mnrLbrBzcAmt;
		this.inpMsg30 = inpMsg30;
		this.rprLbrRt = rprLbrRt;
		this.inpMsg32 = inpMsg32;
		this.inpMsg31 = inpMsg31;
		this.inpMsg34 = inpMsg34;
		this.inpMsg33 = inpMsg33;
		this.inpMsg36 = inpMsg36;
		this.inpMsg35 = inpMsg35;
		this.inpMsg38 = inpMsg38;
		this.inpMsg37 = inpMsg37;
		this.inpMsg39 = inpMsg39;
		this.n3ptyBilLbrHrs = n3ptyBilLbrHrs;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inp_msg2", getInpMsg2());
		this.hashColumns.put("inp_msg3", getInpMsg3());
		this.hashColumns.put("temp_value9", getTempValue9());
		this.hashColumns.put("inp_msg4", getInpMsg4());
		this.hashColumns.put("inp_msg5", getInpMsg5());
		this.hashColumns.put("temp_value7", getTempValue7());
		this.hashColumns.put("temp_value8", getTempValue8());
		this.hashColumns.put("temp_value5", getTempValue5());
		this.hashColumns.put("temp_value6", getTempValue6());
		this.hashColumns.put("inp_msg1", getInpMsg1());
		this.hashColumns.put("temp_value3", getTempValue3());
		this.hashColumns.put("temp_value4", getTempValue4());
		this.hashColumns.put("temp_value1", getTempValue1());
		this.hashColumns.put("temp_value2", getTempValue2());
		this.hashColumns.put("n3pty_bil_lbr_rt", getN3ptyBilLbrRt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inp_msg48", getInpMsg48());
		this.hashColumns.put("inp_msg49", getInpMsg49());
		this.hashColumns.put("inp_msg46", getInpMsg46());
		this.hashColumns.put("inp_msg47", getInpMsg47());
		this.hashColumns.put("inp_msg44", getInpMsg44());
		this.hashColumns.put("inp_msg45", getInpMsg45());
		this.hashColumns.put("inp_msg42", getInpMsg42());
		this.hashColumns.put("inp_msg43", getInpMsg43());
		this.hashColumns.put("inp_msg40", getInpMsg40());
		this.hashColumns.put("vol_tp_cd", getVolTpCd());
		this.hashColumns.put("inp_msg41", getInpMsg41());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("n3pty_bil_lbr_cost_amt", getN3ptyBilLbrCostAmt());
		this.hashColumns.put("trf_opt_cd", getTrfOptCd());
		this.hashColumns.put("eq_rpr_cd", getEqRprCd());
		this.hashColumns.put("mnr_lr_acct_flg", getMnrLrAcctFlg());
		this.hashColumns.put("mtrl_reco_amt", getMtrlRecoAmt());
		this.hashColumns.put("mtrl_cost_amt", getMtrlCostAmt());
		this.hashColumns.put("inp_msg9", getInpMsg9());
		this.hashColumns.put("inp_msg50", getInpMsg50());
		this.hashColumns.put("inp_msg8", getInpMsg8());
		this.hashColumns.put("inp_msg7", getInpMsg7());
		this.hashColumns.put("tmp_dtl_seq", getTmpDtlSeq());
		this.hashColumns.put("inp_msg6", getInpMsg6());
		this.hashColumns.put("mnr_vrfy_tp_cd", getMnrVrfyTpCd());
		this.hashColumns.put("rpr_rqst_ver_no", getRprRqstVerNo());
		this.hashColumns.put("rpr_lbr_bzc_hrs", getRprLbrBzcHrs());
		this.hashColumns.put("rpr_rqst_dtl_seq", getRprRqstDtlSeq());
		this.hashColumns.put("mnr_agmt_amt", getMnrAgmtAmt());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("rpr_qty", getRprQty());
		this.hashColumns.put("eq_cmpo_cd_chk_flg", getEqCmpoCdChkFlg());
		this.hashColumns.put("temp_value10", getTempValue10());
		this.hashColumns.put("rpr_rqst_lst_ver_flg", getRprRqstLstVerFlg());
		this.hashColumns.put("eq_cmpo_cd", getEqCmpoCd());
		this.hashColumns.put("cost_dtl_cd", getCostDtlCd());
		this.hashColumns.put("eq_loc_cd_chk_flg", getEqLocCdChkFlg());
		this.hashColumns.put("xch_mtrl_cost_amt", getXchMtrlCostAmt());
		this.hashColumns.put("lbr_mtrl_bzc_amt", getLbrMtrlBzcAmt());
		this.hashColumns.put("eq_dmg_cd", getEqDmgCd());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("rpr_sz_no", getRprSzNo());
		this.hashColumns.put("mnr_wrk_amt", getMnrWrkAmt());
		this.hashColumns.put("rpr_wdt_no", getRprWdtNo());
		this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());
		this.hashColumns.put("rpr_len_no", getRprLenNo());
		this.hashColumns.put("n3pty_bil_amt", getN3ptyBilAmt());
		this.hashColumns.put("trf_div_cd", getTrfDivCd());
		this.hashColumns.put("rpr_lbr_bzc_rt", getRprLbrBzcRt());
		this.hashColumns.put("eq_rpr_cd_chk_flg", getEqRprCdChkFlg());
		this.hashColumns.put("eq_dmg_cd_chk_flg", getEqDmgCdChkFlg());
		this.hashColumns.put("n3pty_bil_mtrl_cost_amt", getN3ptyBilMtrlCostAmt());
		this.hashColumns.put("inp_msg10", getInpMsg10());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("inp_msg12", getInpMsg12());
		this.hashColumns.put("inp_msg11", getInpMsg11());
		this.hashColumns.put("inp_msg18", getInpMsg18());
		this.hashColumns.put("inp_msg17", getInpMsg17());
		this.hashColumns.put("rpr_lbr_hrs", getRprLbrHrs());
		this.hashColumns.put("inp_msg19", getInpMsg19());
		this.hashColumns.put("inp_msg14", getInpMsg14());
		this.hashColumns.put("inp_msg13", getInpMsg13());
		this.hashColumns.put("inp_msg16", getInpMsg16());
		this.hashColumns.put("inp_msg15", getInpMsg15());
		this.hashColumns.put("eq_loc_cd", getEqLocCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rpr_dtl_rmk", getRprDtlRmk());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("lbr_cost_amt", getLbrCostAmt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inp_msg23", getInpMsg23());
		this.hashColumns.put("inp_msg22", getInpMsg22());
		this.hashColumns.put("inp_msg21", getInpMsg21());
		this.hashColumns.put("inp_msg20", getInpMsg20());
		this.hashColumns.put("inp_msg27", getInpMsg27());
		this.hashColumns.put("inp_msg26", getInpMsg26());
		this.hashColumns.put("inp_msg25", getInpMsg25());
		this.hashColumns.put("inp_msg24", getInpMsg24());
		this.hashColumns.put("inp_msg29", getInpMsg29());
		this.hashColumns.put("inp_msg28", getInpMsg28());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("mnr_lbr_bzc_amt", getMnrLbrBzcAmt());
		this.hashColumns.put("inp_msg30", getInpMsg30());
		this.hashColumns.put("rpr_lbr_rt", getRprLbrRt());
		this.hashColumns.put("inp_msg32", getInpMsg32());
		this.hashColumns.put("inp_msg31", getInpMsg31());
		this.hashColumns.put("inp_msg34", getInpMsg34());
		this.hashColumns.put("inp_msg33", getInpMsg33());
		this.hashColumns.put("inp_msg36", getInpMsg36());
		this.hashColumns.put("inp_msg35", getInpMsg35());
		this.hashColumns.put("inp_msg38", getInpMsg38());
		this.hashColumns.put("inp_msg37", getInpMsg37());
		this.hashColumns.put("inp_msg39", getInpMsg39());
		this.hashColumns.put("n3pty_bil_lbr_hrs", getN3ptyBilLbrHrs());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inp_msg2", "inpMsg2");
		this.hashFields.put("inp_msg3", "inpMsg3");
		this.hashFields.put("temp_value9", "tempValue9");
		this.hashFields.put("inp_msg4", "inpMsg4");
		this.hashFields.put("inp_msg5", "inpMsg5");
		this.hashFields.put("temp_value7", "tempValue7");
		this.hashFields.put("temp_value8", "tempValue8");
		this.hashFields.put("temp_value5", "tempValue5");
		this.hashFields.put("temp_value6", "tempValue6");
		this.hashFields.put("inp_msg1", "inpMsg1");
		this.hashFields.put("temp_value3", "tempValue3");
		this.hashFields.put("temp_value4", "tempValue4");
		this.hashFields.put("temp_value1", "tempValue1");
		this.hashFields.put("temp_value2", "tempValue2");
		this.hashFields.put("n3pty_bil_lbr_rt", "n3ptyBilLbrRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inp_msg48", "inpMsg48");
		this.hashFields.put("inp_msg49", "inpMsg49");
		this.hashFields.put("inp_msg46", "inpMsg46");
		this.hashFields.put("inp_msg47", "inpMsg47");
		this.hashFields.put("inp_msg44", "inpMsg44");
		this.hashFields.put("inp_msg45", "inpMsg45");
		this.hashFields.put("inp_msg42", "inpMsg42");
		this.hashFields.put("inp_msg43", "inpMsg43");
		this.hashFields.put("inp_msg40", "inpMsg40");
		this.hashFields.put("vol_tp_cd", "volTpCd");
		this.hashFields.put("inp_msg41", "inpMsg41");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("n3pty_bil_lbr_cost_amt", "n3ptyBilLbrCostAmt");
		this.hashFields.put("trf_opt_cd", "trfOptCd");
		this.hashFields.put("eq_rpr_cd", "eqRprCd");
		this.hashFields.put("mnr_lr_acct_flg", "mnrLrAcctFlg");
		this.hashFields.put("mtrl_reco_amt", "mtrlRecoAmt");
		this.hashFields.put("mtrl_cost_amt", "mtrlCostAmt");
		this.hashFields.put("inp_msg9", "inpMsg9");
		this.hashFields.put("inp_msg50", "inpMsg50");
		this.hashFields.put("inp_msg8", "inpMsg8");
		this.hashFields.put("inp_msg7", "inpMsg7");
		this.hashFields.put("tmp_dtl_seq", "tmpDtlSeq");
		this.hashFields.put("inp_msg6", "inpMsg6");
		this.hashFields.put("mnr_vrfy_tp_cd", "mnrVrfyTpCd");
		this.hashFields.put("rpr_rqst_ver_no", "rprRqstVerNo");
		this.hashFields.put("rpr_lbr_bzc_hrs", "rprLbrBzcHrs");
		this.hashFields.put("rpr_rqst_dtl_seq", "rprRqstDtlSeq");
		this.hashFields.put("mnr_agmt_amt", "mnrAgmtAmt");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("rpr_qty", "rprQty");
		this.hashFields.put("eq_cmpo_cd_chk_flg", "eqCmpoCdChkFlg");
		this.hashFields.put("temp_value10", "tempValue10");
		this.hashFields.put("rpr_rqst_lst_ver_flg", "rprRqstLstVerFlg");
		this.hashFields.put("eq_cmpo_cd", "eqCmpoCd");
		this.hashFields.put("cost_dtl_cd", "costDtlCd");
		this.hashFields.put("eq_loc_cd_chk_flg", "eqLocCdChkFlg");
		this.hashFields.put("xch_mtrl_cost_amt", "xchMtrlCostAmt");
		this.hashFields.put("lbr_mtrl_bzc_amt", "lbrMtrlBzcAmt");
		this.hashFields.put("eq_dmg_cd", "eqDmgCd");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("rpr_sz_no", "rprSzNo");
		this.hashFields.put("mnr_wrk_amt", "mnrWrkAmt");
		this.hashFields.put("rpr_wdt_no", "rprWdtNo");
		this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
		this.hashFields.put("rpr_len_no", "rprLenNo");
		this.hashFields.put("n3pty_bil_amt", "n3ptyBilAmt");
		this.hashFields.put("trf_div_cd", "trfDivCd");
		this.hashFields.put("rpr_lbr_bzc_rt", "rprLbrBzcRt");
		this.hashFields.put("eq_rpr_cd_chk_flg", "eqRprCdChkFlg");
		this.hashFields.put("eq_dmg_cd_chk_flg", "eqDmgCdChkFlg");
		this.hashFields.put("n3pty_bil_mtrl_cost_amt", "n3ptyBilMtrlCostAmt");
		this.hashFields.put("inp_msg10", "inpMsg10");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inp_msg12", "inpMsg12");
		this.hashFields.put("inp_msg11", "inpMsg11");
		this.hashFields.put("inp_msg18", "inpMsg18");
		this.hashFields.put("inp_msg17", "inpMsg17");
		this.hashFields.put("rpr_lbr_hrs", "rprLbrHrs");
		this.hashFields.put("inp_msg19", "inpMsg19");
		this.hashFields.put("inp_msg14", "inpMsg14");
		this.hashFields.put("inp_msg13", "inpMsg13");
		this.hashFields.put("inp_msg16", "inpMsg16");
		this.hashFields.put("inp_msg15", "inpMsg15");
		this.hashFields.put("eq_loc_cd", "eqLocCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rpr_dtl_rmk", "rprDtlRmk");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("lbr_cost_amt", "lbrCostAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inp_msg23", "inpMsg23");
		this.hashFields.put("inp_msg22", "inpMsg22");
		this.hashFields.put("inp_msg21", "inpMsg21");
		this.hashFields.put("inp_msg20", "inpMsg20");
		this.hashFields.put("inp_msg27", "inpMsg27");
		this.hashFields.put("inp_msg26", "inpMsg26");
		this.hashFields.put("inp_msg25", "inpMsg25");
		this.hashFields.put("inp_msg24", "inpMsg24");
		this.hashFields.put("inp_msg29", "inpMsg29");
		this.hashFields.put("inp_msg28", "inpMsg28");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("mnr_lbr_bzc_amt", "mnrLbrBzcAmt");
		this.hashFields.put("inp_msg30", "inpMsg30");
		this.hashFields.put("rpr_lbr_rt", "rprLbrRt");
		this.hashFields.put("inp_msg32", "inpMsg32");
		this.hashFields.put("inp_msg31", "inpMsg31");
		this.hashFields.put("inp_msg34", "inpMsg34");
		this.hashFields.put("inp_msg33", "inpMsg33");
		this.hashFields.put("inp_msg36", "inpMsg36");
		this.hashFields.put("inp_msg35", "inpMsg35");
		this.hashFields.put("inp_msg38", "inpMsg38");
		this.hashFields.put("inp_msg37", "inpMsg37");
		this.hashFields.put("inp_msg39", "inpMsg39");
		this.hashFields.put("n3pty_bil_lbr_hrs", "n3ptyBilLbrHrs");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inpMsg2
	 */
	public String getInpMsg2() {
		return this.inpMsg2;
	}
	
	/**
	 * Column Info
	 * @return inpMsg3
	 */
	public String getInpMsg3() {
		return this.inpMsg3;
	}
	
	/**
	 * Column Info
	 * @return tempValue9
	 */
	public String getTempValue9() {
		return this.tempValue9;
	}
	
	/**
	 * Column Info
	 * @return inpMsg4
	 */
	public String getInpMsg4() {
		return this.inpMsg4;
	}
	
	/**
	 * Column Info
	 * @return inpMsg5
	 */
	public String getInpMsg5() {
		return this.inpMsg5;
	}
	
	/**
	 * Column Info
	 * @return tempValue7
	 */
	public String getTempValue7() {
		return this.tempValue7;
	}
	
	/**
	 * Column Info
	 * @return tempValue8
	 */
	public String getTempValue8() {
		return this.tempValue8;
	}
	
	/**
	 * Column Info
	 * @return tempValue5
	 */
	public String getTempValue5() {
		return this.tempValue5;
	}
	
	/**
	 * Column Info
	 * @return tempValue6
	 */
	public String getTempValue6() {
		return this.tempValue6;
	}
	
	/**
	 * Column Info
	 * @return inpMsg1
	 */
	public String getInpMsg1() {
		return this.inpMsg1;
	}
	
	/**
	 * Column Info
	 * @return tempValue3
	 */
	public String getTempValue3() {
		return this.tempValue3;
	}
	
	/**
	 * Column Info
	 * @return tempValue4
	 */
	public String getTempValue4() {
		return this.tempValue4;
	}
	
	/**
	 * Column Info
	 * @return tempValue1
	 */
	public String getTempValue1() {
		return this.tempValue1;
	}
	
	/**
	 * Column Info
	 * @return tempValue2
	 */
	public String getTempValue2() {
		return this.tempValue2;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilLbrRt
	 */
	public String getN3ptyBilLbrRt() {
		return this.n3ptyBilLbrRt;
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
	 * @return inpMsg48
	 */
	public String getInpMsg48() {
		return this.inpMsg48;
	}
	
	/**
	 * Column Info
	 * @return inpMsg49
	 */
	public String getInpMsg49() {
		return this.inpMsg49;
	}
	
	/**
	 * Column Info
	 * @return inpMsg46
	 */
	public String getInpMsg46() {
		return this.inpMsg46;
	}
	
	/**
	 * Column Info
	 * @return inpMsg47
	 */
	public String getInpMsg47() {
		return this.inpMsg47;
	}
	
	/**
	 * Column Info
	 * @return inpMsg44
	 */
	public String getInpMsg44() {
		return this.inpMsg44;
	}
	
	/**
	 * Column Info
	 * @return inpMsg45
	 */
	public String getInpMsg45() {
		return this.inpMsg45;
	}
	
	/**
	 * Column Info
	 * @return inpMsg42
	 */
	public String getInpMsg42() {
		return this.inpMsg42;
	}
	
	/**
	 * Column Info
	 * @return inpMsg43
	 */
	public String getInpMsg43() {
		return this.inpMsg43;
	}
	
	/**
	 * Column Info
	 * @return inpMsg40
	 */
	public String getInpMsg40() {
		return this.inpMsg40;
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
	 * @return inpMsg41
	 */
	public String getInpMsg41() {
		return this.inpMsg41;
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
	 * @return n3ptyBilLbrCostAmt
	 */
	public String getN3ptyBilLbrCostAmt() {
		return this.n3ptyBilLbrCostAmt;
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
	 * @return mtrlCostAmt
	 */
	public String getMtrlCostAmt() {
		return this.mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return inpMsg9
	 */
	public String getInpMsg9() {
		return this.inpMsg9;
	}
	
	/**
	 * Column Info
	 * @return inpMsg50
	 */
	public String getInpMsg50() {
		return this.inpMsg50;
	}
	
	/**
	 * Column Info
	 * @return inpMsg8
	 */
	public String getInpMsg8() {
		return this.inpMsg8;
	}
	
	/**
	 * Column Info
	 * @return inpMsg7
	 */
	public String getInpMsg7() {
		return this.inpMsg7;
	}
	
	/**
	 * Column Info
	 * @return tmpDtlSeq
	 */
	public String getTmpDtlSeq() {
		return this.tmpDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return inpMsg6
	 */
	public String getInpMsg6() {
		return this.inpMsg6;
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
	 * @return rprRqstVerNo
	 */
	public String getRprRqstVerNo() {
		return this.rprRqstVerNo;
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
	 * @return mnrAgmtAmt
	 */
	public String getMnrAgmtAmt() {
		return this.mnrAgmtAmt;
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
	 * @return tempValue10
	 */
	public String getTempValue10() {
		return this.tempValue10;
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
	 * @return costDtlCd
	 */
	public String getCostDtlCd() {
		return this.costDtlCd;
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
	 * @return xchMtrlCostAmt
	 */
	public String getXchMtrlCostAmt() {
		return this.xchMtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return lbrMtrlBzcAmt
	 */
	public String getLbrMtrlBzcAmt() {
		return this.lbrMtrlBzcAmt;
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
	 * @return rprRqstSeq
	 */
	public String getRprRqstSeq() {
		return this.rprRqstSeq;
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
	 * @return eqDmgCdChkFlg
	 */
	public String getEqDmgCdChkFlg() {
		return this.eqDmgCdChkFlg;
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
	 * @return inpMsg10
	 */
	public String getInpMsg10() {
		return this.inpMsg10;
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
	 * @return inpMsg12
	 */
	public String getInpMsg12() {
		return this.inpMsg12;
	}
	
	/**
	 * Column Info
	 * @return inpMsg11
	 */
	public String getInpMsg11() {
		return this.inpMsg11;
	}
	
	/**
	 * Column Info
	 * @return inpMsg18
	 */
	public String getInpMsg18() {
		return this.inpMsg18;
	}
	
	/**
	 * Column Info
	 * @return inpMsg17
	 */
	public String getInpMsg17() {
		return this.inpMsg17;
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
	 * @return inpMsg19
	 */
	public String getInpMsg19() {
		return this.inpMsg19;
	}
	
	/**
	 * Column Info
	 * @return inpMsg14
	 */
	public String getInpMsg14() {
		return this.inpMsg14;
	}
	
	/**
	 * Column Info
	 * @return inpMsg13
	 */
	public String getInpMsg13() {
		return this.inpMsg13;
	}
	
	/**
	 * Column Info
	 * @return inpMsg16
	 */
	public String getInpMsg16() {
		return this.inpMsg16;
	}
	
	/**
	 * Column Info
	 * @return inpMsg15
	 */
	public String getInpMsg15() {
		return this.inpMsg15;
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
	 * @return tmpSeq
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
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
	 * @return inpMsg23
	 */
	public String getInpMsg23() {
		return this.inpMsg23;
	}
	
	/**
	 * Column Info
	 * @return inpMsg22
	 */
	public String getInpMsg22() {
		return this.inpMsg22;
	}
	
	/**
	 * Column Info
	 * @return inpMsg21
	 */
	public String getInpMsg21() {
		return this.inpMsg21;
	}
	
	/**
	 * Column Info
	 * @return inpMsg20
	 */
	public String getInpMsg20() {
		return this.inpMsg20;
	}
	
	/**
	 * Column Info
	 * @return inpMsg27
	 */
	public String getInpMsg27() {
		return this.inpMsg27;
	}
	
	/**
	 * Column Info
	 * @return inpMsg26
	 */
	public String getInpMsg26() {
		return this.inpMsg26;
	}
	
	/**
	 * Column Info
	 * @return inpMsg25
	 */
	public String getInpMsg25() {
		return this.inpMsg25;
	}
	
	/**
	 * Column Info
	 * @return inpMsg24
	 */
	public String getInpMsg24() {
		return this.inpMsg24;
	}
	
	/**
	 * Column Info
	 * @return inpMsg29
	 */
	public String getInpMsg29() {
		return this.inpMsg29;
	}
	
	/**
	 * Column Info
	 * @return inpMsg28
	 */
	public String getInpMsg28() {
		return this.inpMsg28;
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
	 * @return mnrLbrBzcAmt
	 */
	public String getMnrLbrBzcAmt() {
		return this.mnrLbrBzcAmt;
	}
	
	/**
	 * Column Info
	 * @return inpMsg30
	 */
	public String getInpMsg30() {
		return this.inpMsg30;
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
	 * @return inpMsg32
	 */
	public String getInpMsg32() {
		return this.inpMsg32;
	}
	
	/**
	 * Column Info
	 * @return inpMsg31
	 */
	public String getInpMsg31() {
		return this.inpMsg31;
	}
	
	/**
	 * Column Info
	 * @return inpMsg34
	 */
	public String getInpMsg34() {
		return this.inpMsg34;
	}
	
	/**
	 * Column Info
	 * @return inpMsg33
	 */
	public String getInpMsg33() {
		return this.inpMsg33;
	}
	
	/**
	 * Column Info
	 * @return inpMsg36
	 */
	public String getInpMsg36() {
		return this.inpMsg36;
	}
	
	/**
	 * Column Info
	 * @return inpMsg35
	 */
	public String getInpMsg35() {
		return this.inpMsg35;
	}
	
	/**
	 * Column Info
	 * @return inpMsg38
	 */
	public String getInpMsg38() {
		return this.inpMsg38;
	}
	
	/**
	 * Column Info
	 * @return inpMsg37
	 */
	public String getInpMsg37() {
		return this.inpMsg37;
	}
	
	/**
	 * Column Info
	 * @return inpMsg39
	 */
	public String getInpMsg39() {
		return this.inpMsg39;
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
	 * @param inpMsg2
	 */
	public void setInpMsg2(String inpMsg2) {
		this.inpMsg2 = inpMsg2;
	}
	
	/**
	 * Column Info
	 * @param inpMsg3
	 */
	public void setInpMsg3(String inpMsg3) {
		this.inpMsg3 = inpMsg3;
	}
	
	/**
	 * Column Info
	 * @param tempValue9
	 */
	public void setTempValue9(String tempValue9) {
		this.tempValue9 = tempValue9;
	}
	
	/**
	 * Column Info
	 * @param inpMsg4
	 */
	public void setInpMsg4(String inpMsg4) {
		this.inpMsg4 = inpMsg4;
	}
	
	/**
	 * Column Info
	 * @param inpMsg5
	 */
	public void setInpMsg5(String inpMsg5) {
		this.inpMsg5 = inpMsg5;
	}
	
	/**
	 * Column Info
	 * @param tempValue7
	 */
	public void setTempValue7(String tempValue7) {
		this.tempValue7 = tempValue7;
	}
	
	/**
	 * Column Info
	 * @param tempValue8
	 */
	public void setTempValue8(String tempValue8) {
		this.tempValue8 = tempValue8;
	}
	
	/**
	 * Column Info
	 * @param tempValue5
	 */
	public void setTempValue5(String tempValue5) {
		this.tempValue5 = tempValue5;
	}
	
	/**
	 * Column Info
	 * @param tempValue6
	 */
	public void setTempValue6(String tempValue6) {
		this.tempValue6 = tempValue6;
	}
	
	/**
	 * Column Info
	 * @param inpMsg1
	 */
	public void setInpMsg1(String inpMsg1) {
		this.inpMsg1 = inpMsg1;
	}
	
	/**
	 * Column Info
	 * @param tempValue3
	 */
	public void setTempValue3(String tempValue3) {
		this.tempValue3 = tempValue3;
	}
	
	/**
	 * Column Info
	 * @param tempValue4
	 */
	public void setTempValue4(String tempValue4) {
		this.tempValue4 = tempValue4;
	}
	
	/**
	 * Column Info
	 * @param tempValue1
	 */
	public void setTempValue1(String tempValue1) {
		this.tempValue1 = tempValue1;
	}
	
	/**
	 * Column Info
	 * @param tempValue2
	 */
	public void setTempValue2(String tempValue2) {
		this.tempValue2 = tempValue2;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilLbrRt
	 */
	public void setN3ptyBilLbrRt(String n3ptyBilLbrRt) {
		this.n3ptyBilLbrRt = n3ptyBilLbrRt;
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
	 * @param inpMsg48
	 */
	public void setInpMsg48(String inpMsg48) {
		this.inpMsg48 = inpMsg48;
	}
	
	/**
	 * Column Info
	 * @param inpMsg49
	 */
	public void setInpMsg49(String inpMsg49) {
		this.inpMsg49 = inpMsg49;
	}
	
	/**
	 * Column Info
	 * @param inpMsg46
	 */
	public void setInpMsg46(String inpMsg46) {
		this.inpMsg46 = inpMsg46;
	}
	
	/**
	 * Column Info
	 * @param inpMsg47
	 */
	public void setInpMsg47(String inpMsg47) {
		this.inpMsg47 = inpMsg47;
	}
	
	/**
	 * Column Info
	 * @param inpMsg44
	 */
	public void setInpMsg44(String inpMsg44) {
		this.inpMsg44 = inpMsg44;
	}
	
	/**
	 * Column Info
	 * @param inpMsg45
	 */
	public void setInpMsg45(String inpMsg45) {
		this.inpMsg45 = inpMsg45;
	}
	
	/**
	 * Column Info
	 * @param inpMsg42
	 */
	public void setInpMsg42(String inpMsg42) {
		this.inpMsg42 = inpMsg42;
	}
	
	/**
	 * Column Info
	 * @param inpMsg43
	 */
	public void setInpMsg43(String inpMsg43) {
		this.inpMsg43 = inpMsg43;
	}
	
	/**
	 * Column Info
	 * @param inpMsg40
	 */
	public void setInpMsg40(String inpMsg40) {
		this.inpMsg40 = inpMsg40;
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
	 * @param inpMsg41
	 */
	public void setInpMsg41(String inpMsg41) {
		this.inpMsg41 = inpMsg41;
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
	 * @param n3ptyBilLbrCostAmt
	 */
	public void setN3ptyBilLbrCostAmt(String n3ptyBilLbrCostAmt) {
		this.n3ptyBilLbrCostAmt = n3ptyBilLbrCostAmt;
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
	 * @param mtrlCostAmt
	 */
	public void setMtrlCostAmt(String mtrlCostAmt) {
		this.mtrlCostAmt = mtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param inpMsg9
	 */
	public void setInpMsg9(String inpMsg9) {
		this.inpMsg9 = inpMsg9;
	}
	
	/**
	 * Column Info
	 * @param inpMsg50
	 */
	public void setInpMsg50(String inpMsg50) {
		this.inpMsg50 = inpMsg50;
	}
	
	/**
	 * Column Info
	 * @param inpMsg8
	 */
	public void setInpMsg8(String inpMsg8) {
		this.inpMsg8 = inpMsg8;
	}
	
	/**
	 * Column Info
	 * @param inpMsg7
	 */
	public void setInpMsg7(String inpMsg7) {
		this.inpMsg7 = inpMsg7;
	}
	
	/**
	 * Column Info
	 * @param tmpDtlSeq
	 */
	public void setTmpDtlSeq(String tmpDtlSeq) {
		this.tmpDtlSeq = tmpDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param inpMsg6
	 */
	public void setInpMsg6(String inpMsg6) {
		this.inpMsg6 = inpMsg6;
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
	 * @param rprRqstVerNo
	 */
	public void setRprRqstVerNo(String rprRqstVerNo) {
		this.rprRqstVerNo = rprRqstVerNo;
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
	 * @param mnrAgmtAmt
	 */
	public void setMnrAgmtAmt(String mnrAgmtAmt) {
		this.mnrAgmtAmt = mnrAgmtAmt;
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
	 * @param tempValue10
	 */
	public void setTempValue10(String tempValue10) {
		this.tempValue10 = tempValue10;
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
	 * @param costDtlCd
	 */
	public void setCostDtlCd(String costDtlCd) {
		this.costDtlCd = costDtlCd;
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
	 * @param xchMtrlCostAmt
	 */
	public void setXchMtrlCostAmt(String xchMtrlCostAmt) {
		this.xchMtrlCostAmt = xchMtrlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param lbrMtrlBzcAmt
	 */
	public void setLbrMtrlBzcAmt(String lbrMtrlBzcAmt) {
		this.lbrMtrlBzcAmt = lbrMtrlBzcAmt;
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
	 * @param rprRqstSeq
	 */
	public void setRprRqstSeq(String rprRqstSeq) {
		this.rprRqstSeq = rprRqstSeq;
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
	 * @param eqDmgCdChkFlg
	 */
	public void setEqDmgCdChkFlg(String eqDmgCdChkFlg) {
		this.eqDmgCdChkFlg = eqDmgCdChkFlg;
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
	 * @param inpMsg10
	 */
	public void setInpMsg10(String inpMsg10) {
		this.inpMsg10 = inpMsg10;
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
	 * @param inpMsg12
	 */
	public void setInpMsg12(String inpMsg12) {
		this.inpMsg12 = inpMsg12;
	}
	
	/**
	 * Column Info
	 * @param inpMsg11
	 */
	public void setInpMsg11(String inpMsg11) {
		this.inpMsg11 = inpMsg11;
	}
	
	/**
	 * Column Info
	 * @param inpMsg18
	 */
	public void setInpMsg18(String inpMsg18) {
		this.inpMsg18 = inpMsg18;
	}
	
	/**
	 * Column Info
	 * @param inpMsg17
	 */
	public void setInpMsg17(String inpMsg17) {
		this.inpMsg17 = inpMsg17;
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
	 * @param inpMsg19
	 */
	public void setInpMsg19(String inpMsg19) {
		this.inpMsg19 = inpMsg19;
	}
	
	/**
	 * Column Info
	 * @param inpMsg14
	 */
	public void setInpMsg14(String inpMsg14) {
		this.inpMsg14 = inpMsg14;
	}
	
	/**
	 * Column Info
	 * @param inpMsg13
	 */
	public void setInpMsg13(String inpMsg13) {
		this.inpMsg13 = inpMsg13;
	}
	
	/**
	 * Column Info
	 * @param inpMsg16
	 */
	public void setInpMsg16(String inpMsg16) {
		this.inpMsg16 = inpMsg16;
	}
	
	/**
	 * Column Info
	 * @param inpMsg15
	 */
	public void setInpMsg15(String inpMsg15) {
		this.inpMsg15 = inpMsg15;
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
	 * @param tmpSeq
	 */
	public void setTmpSeq(String tmpSeq) {
		this.tmpSeq = tmpSeq;
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
	 * @param inpMsg23
	 */
	public void setInpMsg23(String inpMsg23) {
		this.inpMsg23 = inpMsg23;
	}
	
	/**
	 * Column Info
	 * @param inpMsg22
	 */
	public void setInpMsg22(String inpMsg22) {
		this.inpMsg22 = inpMsg22;
	}
	
	/**
	 * Column Info
	 * @param inpMsg21
	 */
	public void setInpMsg21(String inpMsg21) {
		this.inpMsg21 = inpMsg21;
	}
	
	/**
	 * Column Info
	 * @param inpMsg20
	 */
	public void setInpMsg20(String inpMsg20) {
		this.inpMsg20 = inpMsg20;
	}
	
	/**
	 * Column Info
	 * @param inpMsg27
	 */
	public void setInpMsg27(String inpMsg27) {
		this.inpMsg27 = inpMsg27;
	}
	
	/**
	 * Column Info
	 * @param inpMsg26
	 */
	public void setInpMsg26(String inpMsg26) {
		this.inpMsg26 = inpMsg26;
	}
	
	/**
	 * Column Info
	 * @param inpMsg25
	 */
	public void setInpMsg25(String inpMsg25) {
		this.inpMsg25 = inpMsg25;
	}
	
	/**
	 * Column Info
	 * @param inpMsg24
	 */
	public void setInpMsg24(String inpMsg24) {
		this.inpMsg24 = inpMsg24;
	}
	
	/**
	 * Column Info
	 * @param inpMsg29
	 */
	public void setInpMsg29(String inpMsg29) {
		this.inpMsg29 = inpMsg29;
	}
	
	/**
	 * Column Info
	 * @param inpMsg28
	 */
	public void setInpMsg28(String inpMsg28) {
		this.inpMsg28 = inpMsg28;
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
	 * @param mnrLbrBzcAmt
	 */
	public void setMnrLbrBzcAmt(String mnrLbrBzcAmt) {
		this.mnrLbrBzcAmt = mnrLbrBzcAmt;
	}
	
	/**
	 * Column Info
	 * @param inpMsg30
	 */
	public void setInpMsg30(String inpMsg30) {
		this.inpMsg30 = inpMsg30;
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
	 * @param inpMsg32
	 */
	public void setInpMsg32(String inpMsg32) {
		this.inpMsg32 = inpMsg32;
	}
	
	/**
	 * Column Info
	 * @param inpMsg31
	 */
	public void setInpMsg31(String inpMsg31) {
		this.inpMsg31 = inpMsg31;
	}
	
	/**
	 * Column Info
	 * @param inpMsg34
	 */
	public void setInpMsg34(String inpMsg34) {
		this.inpMsg34 = inpMsg34;
	}
	
	/**
	 * Column Info
	 * @param inpMsg33
	 */
	public void setInpMsg33(String inpMsg33) {
		this.inpMsg33 = inpMsg33;
	}
	
	/**
	 * Column Info
	 * @param inpMsg36
	 */
	public void setInpMsg36(String inpMsg36) {
		this.inpMsg36 = inpMsg36;
	}
	
	/**
	 * Column Info
	 * @param inpMsg35
	 */
	public void setInpMsg35(String inpMsg35) {
		this.inpMsg35 = inpMsg35;
	}
	
	/**
	 * Column Info
	 * @param inpMsg38
	 */
	public void setInpMsg38(String inpMsg38) {
		this.inpMsg38 = inpMsg38;
	}
	
	/**
	 * Column Info
	 * @param inpMsg37
	 */
	public void setInpMsg37(String inpMsg37) {
		this.inpMsg37 = inpMsg37;
	}
	
	/**
	 * Column Info
	 * @param inpMsg39
	 */
	public void setInpMsg39(String inpMsg39) {
		this.inpMsg39 = inpMsg39;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setInpMsg2(JSPUtil.getParameter(request, prefix + "inp_msg2", ""));
		setInpMsg3(JSPUtil.getParameter(request, prefix + "inp_msg3", ""));
		setTempValue9(JSPUtil.getParameter(request, prefix + "temp_value9", ""));
		setInpMsg4(JSPUtil.getParameter(request, prefix + "inp_msg4", ""));
		setInpMsg5(JSPUtil.getParameter(request, prefix + "inp_msg5", ""));
		setTempValue7(JSPUtil.getParameter(request, prefix + "temp_value7", ""));
		setTempValue8(JSPUtil.getParameter(request, prefix + "temp_value8", ""));
		setTempValue5(JSPUtil.getParameter(request, prefix + "temp_value5", ""));
		setTempValue6(JSPUtil.getParameter(request, prefix + "temp_value6", ""));
		setInpMsg1(JSPUtil.getParameter(request, prefix + "inp_msg1", ""));
		setTempValue3(JSPUtil.getParameter(request, prefix + "temp_value3", ""));
		setTempValue4(JSPUtil.getParameter(request, prefix + "temp_value4", ""));
		setTempValue1(JSPUtil.getParameter(request, prefix + "temp_value1", ""));
		setTempValue2(JSPUtil.getParameter(request, prefix + "temp_value2", ""));
		setN3ptyBilLbrRt(JSPUtil.getParameter(request, prefix + "n3pty_bil_lbr_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInpMsg48(JSPUtil.getParameter(request, prefix + "inp_msg48", ""));
		setInpMsg49(JSPUtil.getParameter(request, prefix + "inp_msg49", ""));
		setInpMsg46(JSPUtil.getParameter(request, prefix + "inp_msg46", ""));
		setInpMsg47(JSPUtil.getParameter(request, prefix + "inp_msg47", ""));
		setInpMsg44(JSPUtil.getParameter(request, prefix + "inp_msg44", ""));
		setInpMsg45(JSPUtil.getParameter(request, prefix + "inp_msg45", ""));
		setInpMsg42(JSPUtil.getParameter(request, prefix + "inp_msg42", ""));
		setInpMsg43(JSPUtil.getParameter(request, prefix + "inp_msg43", ""));
		setInpMsg40(JSPUtil.getParameter(request, prefix + "inp_msg40", ""));
		setVolTpCd(JSPUtil.getParameter(request, prefix + "vol_tp_cd", ""));
		setInpMsg41(JSPUtil.getParameter(request, prefix + "inp_msg41", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setN3ptyBilLbrCostAmt(JSPUtil.getParameter(request, prefix + "n3pty_bil_lbr_cost_amt", ""));
		setTrfOptCd(JSPUtil.getParameter(request, prefix + "trf_opt_cd", ""));
		setEqRprCd(JSPUtil.getParameter(request, prefix + "eq_rpr_cd", ""));
		setMnrLrAcctFlg(JSPUtil.getParameter(request, prefix + "mnr_lr_acct_flg", ""));
		setMtrlRecoAmt(JSPUtil.getParameter(request, prefix + "mtrl_reco_amt", ""));
		setMtrlCostAmt(JSPUtil.getParameter(request, prefix + "mtrl_cost_amt", ""));
		setInpMsg9(JSPUtil.getParameter(request, prefix + "inp_msg9", ""));
		setInpMsg50(JSPUtil.getParameter(request, prefix + "inp_msg50", ""));
		setInpMsg8(JSPUtil.getParameter(request, prefix + "inp_msg8", ""));
		setInpMsg7(JSPUtil.getParameter(request, prefix + "inp_msg7", ""));
		setTmpDtlSeq(JSPUtil.getParameter(request, prefix + "tmp_dtl_seq", ""));
		setInpMsg6(JSPUtil.getParameter(request, prefix + "inp_msg6", ""));
		setMnrVrfyTpCd(JSPUtil.getParameter(request, prefix + "mnr_vrfy_tp_cd", ""));
		setRprRqstVerNo(JSPUtil.getParameter(request, prefix + "rpr_rqst_ver_no", ""));
		setRprLbrBzcHrs(JSPUtil.getParameter(request, prefix + "rpr_lbr_bzc_hrs", ""));
		setRprRqstDtlSeq(JSPUtil.getParameter(request, prefix + "rpr_rqst_dtl_seq", ""));
		setMnrAgmtAmt(JSPUtil.getParameter(request, prefix + "mnr_agmt_amt", ""));
		setRqstEqNo(JSPUtil.getParameter(request, prefix + "rqst_eq_no", ""));
		setRprQty(JSPUtil.getParameter(request, prefix + "rpr_qty", ""));
		setEqCmpoCdChkFlg(JSPUtil.getParameter(request, prefix + "eq_cmpo_cd_chk_flg", ""));
		setTempValue10(JSPUtil.getParameter(request, prefix + "temp_value10", ""));
		setRprRqstLstVerFlg(JSPUtil.getParameter(request, prefix + "rpr_rqst_lst_ver_flg", ""));
		setEqCmpoCd(JSPUtil.getParameter(request, prefix + "eq_cmpo_cd", ""));
		setCostDtlCd(JSPUtil.getParameter(request, prefix + "cost_dtl_cd", ""));
		setEqLocCdChkFlg(JSPUtil.getParameter(request, prefix + "eq_loc_cd_chk_flg", ""));
		setXchMtrlCostAmt(JSPUtil.getParameter(request, prefix + "xch_mtrl_cost_amt", ""));
		setLbrMtrlBzcAmt(JSPUtil.getParameter(request, prefix + "lbr_mtrl_bzc_amt", ""));
		setEqDmgCd(JSPUtil.getParameter(request, prefix + "eq_dmg_cd", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setRprSzNo(JSPUtil.getParameter(request, prefix + "rpr_sz_no", ""));
		setMnrWrkAmt(JSPUtil.getParameter(request, prefix + "mnr_wrk_amt", ""));
		setRprWdtNo(JSPUtil.getParameter(request, prefix + "rpr_wdt_no", ""));
		setRprRqstSeq(JSPUtil.getParameter(request, prefix + "rpr_rqst_seq", ""));
		setRprLenNo(JSPUtil.getParameter(request, prefix + "rpr_len_no", ""));
		setN3ptyBilAmt(JSPUtil.getParameter(request, prefix + "n3pty_bil_amt", ""));
		setTrfDivCd(JSPUtil.getParameter(request, prefix + "trf_div_cd", ""));
		setRprLbrBzcRt(JSPUtil.getParameter(request, prefix + "rpr_lbr_bzc_rt", ""));
		setEqRprCdChkFlg(JSPUtil.getParameter(request, prefix + "eq_rpr_cd_chk_flg", ""));
		setEqDmgCdChkFlg(JSPUtil.getParameter(request, prefix + "eq_dmg_cd_chk_flg", ""));
		setN3ptyBilMtrlCostAmt(JSPUtil.getParameter(request, prefix + "n3pty_bil_mtrl_cost_amt", ""));
		setInpMsg10(JSPUtil.getParameter(request, prefix + "inp_msg10", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setInpMsg12(JSPUtil.getParameter(request, prefix + "inp_msg12", ""));
		setInpMsg11(JSPUtil.getParameter(request, prefix + "inp_msg11", ""));
		setInpMsg18(JSPUtil.getParameter(request, prefix + "inp_msg18", ""));
		setInpMsg17(JSPUtil.getParameter(request, prefix + "inp_msg17", ""));
		setRprLbrHrs(JSPUtil.getParameter(request, prefix + "rpr_lbr_hrs", ""));
		setInpMsg19(JSPUtil.getParameter(request, prefix + "inp_msg19", ""));
		setInpMsg14(JSPUtil.getParameter(request, prefix + "inp_msg14", ""));
		setInpMsg13(JSPUtil.getParameter(request, prefix + "inp_msg13", ""));
		setInpMsg16(JSPUtil.getParameter(request, prefix + "inp_msg16", ""));
		setInpMsg15(JSPUtil.getParameter(request, prefix + "inp_msg15", ""));
		setEqLocCd(JSPUtil.getParameter(request, prefix + "eq_loc_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setRprDtlRmk(JSPUtil.getParameter(request, prefix + "rpr_dtl_rmk", ""));
		setTmpSeq(JSPUtil.getParameter(request, prefix + "tmp_seq", ""));
		setLbrCostAmt(JSPUtil.getParameter(request, prefix + "lbr_cost_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInpMsg23(JSPUtil.getParameter(request, prefix + "inp_msg23", ""));
		setInpMsg22(JSPUtil.getParameter(request, prefix + "inp_msg22", ""));
		setInpMsg21(JSPUtil.getParameter(request, prefix + "inp_msg21", ""));
		setInpMsg20(JSPUtil.getParameter(request, prefix + "inp_msg20", ""));
		setInpMsg27(JSPUtil.getParameter(request, prefix + "inp_msg27", ""));
		setInpMsg26(JSPUtil.getParameter(request, prefix + "inp_msg26", ""));
		setInpMsg25(JSPUtil.getParameter(request, prefix + "inp_msg25", ""));
		setInpMsg24(JSPUtil.getParameter(request, prefix + "inp_msg24", ""));
		setInpMsg29(JSPUtil.getParameter(request, prefix + "inp_msg29", ""));
		setInpMsg28(JSPUtil.getParameter(request, prefix + "inp_msg28", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, prefix + "n3pty_flg", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setMnrLbrBzcAmt(JSPUtil.getParameter(request, prefix + "mnr_lbr_bzc_amt", ""));
		setInpMsg30(JSPUtil.getParameter(request, prefix + "inp_msg30", ""));
		setRprLbrRt(JSPUtil.getParameter(request, prefix + "rpr_lbr_rt", ""));
		setInpMsg32(JSPUtil.getParameter(request, prefix + "inp_msg32", ""));
		setInpMsg31(JSPUtil.getParameter(request, prefix + "inp_msg31", ""));
		setInpMsg34(JSPUtil.getParameter(request, prefix + "inp_msg34", ""));
		setInpMsg33(JSPUtil.getParameter(request, prefix + "inp_msg33", ""));
		setInpMsg36(JSPUtil.getParameter(request, prefix + "inp_msg36", ""));
		setInpMsg35(JSPUtil.getParameter(request, prefix + "inp_msg35", ""));
		setInpMsg38(JSPUtil.getParameter(request, prefix + "inp_msg38", ""));
		setInpMsg37(JSPUtil.getParameter(request, prefix + "inp_msg37", ""));
		setInpMsg39(JSPUtil.getParameter(request, prefix + "inp_msg39", ""));
		setN3ptyBilLbrHrs(JSPUtil.getParameter(request, prefix + "n3pty_bil_lbr_hrs", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrRprRqstVDtlVO[]
	 */
	public CustomMnrRprRqstVDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrRprRqstVDtlVO[]
	 */
	public CustomMnrRprRqstVDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrRprRqstVDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inpMsg2 = (JSPUtil.getParameter(request, prefix	+ "inp_msg2", length));
			String[] inpMsg3 = (JSPUtil.getParameter(request, prefix	+ "inp_msg3", length));
			String[] tempValue9 = (JSPUtil.getParameter(request, prefix	+ "temp_value9", length));
			String[] inpMsg4 = (JSPUtil.getParameter(request, prefix	+ "inp_msg4", length));
			String[] inpMsg5 = (JSPUtil.getParameter(request, prefix	+ "inp_msg5", length));
			String[] tempValue7 = (JSPUtil.getParameter(request, prefix	+ "temp_value7", length));
			String[] tempValue8 = (JSPUtil.getParameter(request, prefix	+ "temp_value8", length));
			String[] tempValue5 = (JSPUtil.getParameter(request, prefix	+ "temp_value5", length));
			String[] tempValue6 = (JSPUtil.getParameter(request, prefix	+ "temp_value6", length));
			String[] inpMsg1 = (JSPUtil.getParameter(request, prefix	+ "inp_msg1", length));
			String[] tempValue3 = (JSPUtil.getParameter(request, prefix	+ "temp_value3", length));
			String[] tempValue4 = (JSPUtil.getParameter(request, prefix	+ "temp_value4", length));
			String[] tempValue1 = (JSPUtil.getParameter(request, prefix	+ "temp_value1", length));
			String[] tempValue2 = (JSPUtil.getParameter(request, prefix	+ "temp_value2", length));
			String[] n3ptyBilLbrRt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] inpMsg48 = (JSPUtil.getParameter(request, prefix	+ "inp_msg48", length));
			String[] inpMsg49 = (JSPUtil.getParameter(request, prefix	+ "inp_msg49", length));
			String[] inpMsg46 = (JSPUtil.getParameter(request, prefix	+ "inp_msg46", length));
			String[] inpMsg47 = (JSPUtil.getParameter(request, prefix	+ "inp_msg47", length));
			String[] inpMsg44 = (JSPUtil.getParameter(request, prefix	+ "inp_msg44", length));
			String[] inpMsg45 = (JSPUtil.getParameter(request, prefix	+ "inp_msg45", length));
			String[] inpMsg42 = (JSPUtil.getParameter(request, prefix	+ "inp_msg42", length));
			String[] inpMsg43 = (JSPUtil.getParameter(request, prefix	+ "inp_msg43", length));
			String[] inpMsg40 = (JSPUtil.getParameter(request, prefix	+ "inp_msg40", length));
			String[] volTpCd = (JSPUtil.getParameter(request, prefix	+ "vol_tp_cd", length));
			String[] inpMsg41 = (JSPUtil.getParameter(request, prefix	+ "inp_msg41", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] n3ptyBilLbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_cost_amt", length));
			String[] trfOptCd = (JSPUtil.getParameter(request, prefix	+ "trf_opt_cd", length));
			String[] eqRprCd = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd", length));
			String[] mnrLrAcctFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_lr_acct_flg", length));
			String[] mtrlRecoAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_reco_amt", length));
			String[] mtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "mtrl_cost_amt", length));
			String[] inpMsg9 = (JSPUtil.getParameter(request, prefix	+ "inp_msg9", length));
			String[] inpMsg50 = (JSPUtil.getParameter(request, prefix	+ "inp_msg50", length));
			String[] inpMsg8 = (JSPUtil.getParameter(request, prefix	+ "inp_msg8", length));
			String[] inpMsg7 = (JSPUtil.getParameter(request, prefix	+ "inp_msg7", length));
			String[] tmpDtlSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_dtl_seq", length));
			String[] inpMsg6 = (JSPUtil.getParameter(request, prefix	+ "inp_msg6", length));
			String[] mnrVrfyTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_vrfy_tp_cd", length));
			String[] rprRqstVerNo = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_ver_no", length));
			String[] rprLbrBzcHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_bzc_hrs", length));
			String[] rprRqstDtlSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_dtl_seq", length));
			String[] mnrAgmtAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_agmt_amt", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] rprQty = (JSPUtil.getParameter(request, prefix	+ "rpr_qty", length));
			String[] eqCmpoCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd_chk_flg", length));
			String[] tempValue10 = (JSPUtil.getParameter(request, prefix	+ "temp_value10", length));
			String[] rprRqstLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_lst_ver_flg", length));
			String[] eqCmpoCd = (JSPUtil.getParameter(request, prefix	+ "eq_cmpo_cd", length));
			String[] costDtlCd = (JSPUtil.getParameter(request, prefix	+ "cost_dtl_cd", length));
			String[] eqLocCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd_chk_flg", length));
			String[] xchMtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "xch_mtrl_cost_amt", length));
			String[] lbrMtrlBzcAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_mtrl_bzc_amt", length));
			String[] eqDmgCd = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] rprSzNo = (JSPUtil.getParameter(request, prefix	+ "rpr_sz_no", length));
			String[] mnrWrkAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_wrk_amt", length));
			String[] rprWdtNo = (JSPUtil.getParameter(request, prefix	+ "rpr_wdt_no", length));
			String[] rprRqstSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_seq", length));
			String[] rprLenNo = (JSPUtil.getParameter(request, prefix	+ "rpr_len_no", length));
			String[] n3ptyBilAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_amt", length));
			String[] trfDivCd = (JSPUtil.getParameter(request, prefix	+ "trf_div_cd", length));
			String[] rprLbrBzcRt = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_bzc_rt", length));
			String[] eqRprCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_rpr_cd_chk_flg", length));
			String[] eqDmgCdChkFlg = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_cd_chk_flg", length));
			String[] n3ptyBilMtrlCostAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_mtrl_cost_amt", length));
			String[] inpMsg10 = (JSPUtil.getParameter(request, prefix	+ "inp_msg10", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] inpMsg12 = (JSPUtil.getParameter(request, prefix	+ "inp_msg12", length));
			String[] inpMsg11 = (JSPUtil.getParameter(request, prefix	+ "inp_msg11", length));
			String[] inpMsg18 = (JSPUtil.getParameter(request, prefix	+ "inp_msg18", length));
			String[] inpMsg17 = (JSPUtil.getParameter(request, prefix	+ "inp_msg17", length));
			String[] rprLbrHrs = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_hrs", length));
			String[] inpMsg19 = (JSPUtil.getParameter(request, prefix	+ "inp_msg19", length));
			String[] inpMsg14 = (JSPUtil.getParameter(request, prefix	+ "inp_msg14", length));
			String[] inpMsg13 = (JSPUtil.getParameter(request, prefix	+ "inp_msg13", length));
			String[] inpMsg16 = (JSPUtil.getParameter(request, prefix	+ "inp_msg16", length));
			String[] inpMsg15 = (JSPUtil.getParameter(request, prefix	+ "inp_msg15", length));
			String[] eqLocCd = (JSPUtil.getParameter(request, prefix	+ "eq_loc_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rprDtlRmk = (JSPUtil.getParameter(request, prefix	+ "rpr_dtl_rmk", length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] lbrCostAmt = (JSPUtil.getParameter(request, prefix	+ "lbr_cost_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] inpMsg23 = (JSPUtil.getParameter(request, prefix	+ "inp_msg23", length));
			String[] inpMsg22 = (JSPUtil.getParameter(request, prefix	+ "inp_msg22", length));
			String[] inpMsg21 = (JSPUtil.getParameter(request, prefix	+ "inp_msg21", length));
			String[] inpMsg20 = (JSPUtil.getParameter(request, prefix	+ "inp_msg20", length));
			String[] inpMsg27 = (JSPUtil.getParameter(request, prefix	+ "inp_msg27", length));
			String[] inpMsg26 = (JSPUtil.getParameter(request, prefix	+ "inp_msg26", length));
			String[] inpMsg25 = (JSPUtil.getParameter(request, prefix	+ "inp_msg25", length));
			String[] inpMsg24 = (JSPUtil.getParameter(request, prefix	+ "inp_msg24", length));
			String[] inpMsg29 = (JSPUtil.getParameter(request, prefix	+ "inp_msg29", length));
			String[] inpMsg28 = (JSPUtil.getParameter(request, prefix	+ "inp_msg28", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] mnrLbrBzcAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_lbr_bzc_amt", length));
			String[] inpMsg30 = (JSPUtil.getParameter(request, prefix	+ "inp_msg30", length));
			String[] rprLbrRt = (JSPUtil.getParameter(request, prefix	+ "rpr_lbr_rt", length));
			String[] inpMsg32 = (JSPUtil.getParameter(request, prefix	+ "inp_msg32", length));
			String[] inpMsg31 = (JSPUtil.getParameter(request, prefix	+ "inp_msg31", length));
			String[] inpMsg34 = (JSPUtil.getParameter(request, prefix	+ "inp_msg34", length));
			String[] inpMsg33 = (JSPUtil.getParameter(request, prefix	+ "inp_msg33", length));
			String[] inpMsg36 = (JSPUtil.getParameter(request, prefix	+ "inp_msg36", length));
			String[] inpMsg35 = (JSPUtil.getParameter(request, prefix	+ "inp_msg35", length));
			String[] inpMsg38 = (JSPUtil.getParameter(request, prefix	+ "inp_msg38", length));
			String[] inpMsg37 = (JSPUtil.getParameter(request, prefix	+ "inp_msg37", length));
			String[] inpMsg39 = (JSPUtil.getParameter(request, prefix	+ "inp_msg39", length));
			String[] n3ptyBilLbrHrs = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_lbr_hrs", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrRprRqstVDtlVO();
				if (inpMsg2[i] != null)
					model.setInpMsg2(inpMsg2[i]);
				if (inpMsg3[i] != null)
					model.setInpMsg3(inpMsg3[i]);
				if (tempValue9[i] != null)
					model.setTempValue9(tempValue9[i]);
				if (inpMsg4[i] != null)
					model.setInpMsg4(inpMsg4[i]);
				if (inpMsg5[i] != null)
					model.setInpMsg5(inpMsg5[i]);
				if (tempValue7[i] != null)
					model.setTempValue7(tempValue7[i]);
				if (tempValue8[i] != null)
					model.setTempValue8(tempValue8[i]);
				if (tempValue5[i] != null)
					model.setTempValue5(tempValue5[i]);
				if (tempValue6[i] != null)
					model.setTempValue6(tempValue6[i]);
				if (inpMsg1[i] != null)
					model.setInpMsg1(inpMsg1[i]);
				if (tempValue3[i] != null)
					model.setTempValue3(tempValue3[i]);
				if (tempValue4[i] != null)
					model.setTempValue4(tempValue4[i]);
				if (tempValue1[i] != null)
					model.setTempValue1(tempValue1[i]);
				if (tempValue2[i] != null)
					model.setTempValue2(tempValue2[i]);
				if (n3ptyBilLbrRt[i] != null)
					model.setN3ptyBilLbrRt(n3ptyBilLbrRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (inpMsg48[i] != null)
					model.setInpMsg48(inpMsg48[i]);
				if (inpMsg49[i] != null)
					model.setInpMsg49(inpMsg49[i]);
				if (inpMsg46[i] != null)
					model.setInpMsg46(inpMsg46[i]);
				if (inpMsg47[i] != null)
					model.setInpMsg47(inpMsg47[i]);
				if (inpMsg44[i] != null)
					model.setInpMsg44(inpMsg44[i]);
				if (inpMsg45[i] != null)
					model.setInpMsg45(inpMsg45[i]);
				if (inpMsg42[i] != null)
					model.setInpMsg42(inpMsg42[i]);
				if (inpMsg43[i] != null)
					model.setInpMsg43(inpMsg43[i]);
				if (inpMsg40[i] != null)
					model.setInpMsg40(inpMsg40[i]);
				if (volTpCd[i] != null)
					model.setVolTpCd(volTpCd[i]);
				if (inpMsg41[i] != null)
					model.setInpMsg41(inpMsg41[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (n3ptyBilLbrCostAmt[i] != null)
					model.setN3ptyBilLbrCostAmt(n3ptyBilLbrCostAmt[i]);
				if (trfOptCd[i] != null)
					model.setTrfOptCd(trfOptCd[i]);
				if (eqRprCd[i] != null)
					model.setEqRprCd(eqRprCd[i]);
				if (mnrLrAcctFlg[i] != null)
					model.setMnrLrAcctFlg(mnrLrAcctFlg[i]);
				if (mtrlRecoAmt[i] != null)
					model.setMtrlRecoAmt(mtrlRecoAmt[i]);
				if (mtrlCostAmt[i] != null)
					model.setMtrlCostAmt(mtrlCostAmt[i]);
				if (inpMsg9[i] != null)
					model.setInpMsg9(inpMsg9[i]);
				if (inpMsg50[i] != null)
					model.setInpMsg50(inpMsg50[i]);
				if (inpMsg8[i] != null)
					model.setInpMsg8(inpMsg8[i]);
				if (inpMsg7[i] != null)
					model.setInpMsg7(inpMsg7[i]);
				if (tmpDtlSeq[i] != null)
					model.setTmpDtlSeq(tmpDtlSeq[i]);
				if (inpMsg6[i] != null)
					model.setInpMsg6(inpMsg6[i]);
				if (mnrVrfyTpCd[i] != null)
					model.setMnrVrfyTpCd(mnrVrfyTpCd[i]);
				if (rprRqstVerNo[i] != null)
					model.setRprRqstVerNo(rprRqstVerNo[i]);
				if (rprLbrBzcHrs[i] != null)
					model.setRprLbrBzcHrs(rprLbrBzcHrs[i]);
				if (rprRqstDtlSeq[i] != null)
					model.setRprRqstDtlSeq(rprRqstDtlSeq[i]);
				if (mnrAgmtAmt[i] != null)
					model.setMnrAgmtAmt(mnrAgmtAmt[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (rprQty[i] != null)
					model.setRprQty(rprQty[i]);
				if (eqCmpoCdChkFlg[i] != null)
					model.setEqCmpoCdChkFlg(eqCmpoCdChkFlg[i]);
				if (tempValue10[i] != null)
					model.setTempValue10(tempValue10[i]);
				if (rprRqstLstVerFlg[i] != null)
					model.setRprRqstLstVerFlg(rprRqstLstVerFlg[i]);
				if (eqCmpoCd[i] != null)
					model.setEqCmpoCd(eqCmpoCd[i]);
				if (costDtlCd[i] != null)
					model.setCostDtlCd(costDtlCd[i]);
				if (eqLocCdChkFlg[i] != null)
					model.setEqLocCdChkFlg(eqLocCdChkFlg[i]);
				if (xchMtrlCostAmt[i] != null)
					model.setXchMtrlCostAmt(xchMtrlCostAmt[i]);
				if (lbrMtrlBzcAmt[i] != null)
					model.setLbrMtrlBzcAmt(lbrMtrlBzcAmt[i]);
				if (eqDmgCd[i] != null)
					model.setEqDmgCd(eqDmgCd[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (rprSzNo[i] != null)
					model.setRprSzNo(rprSzNo[i]);
				if (mnrWrkAmt[i] != null)
					model.setMnrWrkAmt(mnrWrkAmt[i]);
				if (rprWdtNo[i] != null)
					model.setRprWdtNo(rprWdtNo[i]);
				if (rprRqstSeq[i] != null)
					model.setRprRqstSeq(rprRqstSeq[i]);
				if (rprLenNo[i] != null)
					model.setRprLenNo(rprLenNo[i]);
				if (n3ptyBilAmt[i] != null)
					model.setN3ptyBilAmt(n3ptyBilAmt[i]);
				if (trfDivCd[i] != null)
					model.setTrfDivCd(trfDivCd[i]);
				if (rprLbrBzcRt[i] != null)
					model.setRprLbrBzcRt(rprLbrBzcRt[i]);
				if (eqRprCdChkFlg[i] != null)
					model.setEqRprCdChkFlg(eqRprCdChkFlg[i]);
				if (eqDmgCdChkFlg[i] != null)
					model.setEqDmgCdChkFlg(eqDmgCdChkFlg[i]);
				if (n3ptyBilMtrlCostAmt[i] != null)
					model.setN3ptyBilMtrlCostAmt(n3ptyBilMtrlCostAmt[i]);
				if (inpMsg10[i] != null)
					model.setInpMsg10(inpMsg10[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (inpMsg12[i] != null)
					model.setInpMsg12(inpMsg12[i]);
				if (inpMsg11[i] != null)
					model.setInpMsg11(inpMsg11[i]);
				if (inpMsg18[i] != null)
					model.setInpMsg18(inpMsg18[i]);
				if (inpMsg17[i] != null)
					model.setInpMsg17(inpMsg17[i]);
				if (rprLbrHrs[i] != null)
					model.setRprLbrHrs(rprLbrHrs[i]);
				if (inpMsg19[i] != null)
					model.setInpMsg19(inpMsg19[i]);
				if (inpMsg14[i] != null)
					model.setInpMsg14(inpMsg14[i]);
				if (inpMsg13[i] != null)
					model.setInpMsg13(inpMsg13[i]);
				if (inpMsg16[i] != null)
					model.setInpMsg16(inpMsg16[i]);
				if (inpMsg15[i] != null)
					model.setInpMsg15(inpMsg15[i]);
				if (eqLocCd[i] != null)
					model.setEqLocCd(eqLocCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rprDtlRmk[i] != null)
					model.setRprDtlRmk(rprDtlRmk[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (lbrCostAmt[i] != null)
					model.setLbrCostAmt(lbrCostAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (inpMsg23[i] != null)
					model.setInpMsg23(inpMsg23[i]);
				if (inpMsg22[i] != null)
					model.setInpMsg22(inpMsg22[i]);
				if (inpMsg21[i] != null)
					model.setInpMsg21(inpMsg21[i]);
				if (inpMsg20[i] != null)
					model.setInpMsg20(inpMsg20[i]);
				if (inpMsg27[i] != null)
					model.setInpMsg27(inpMsg27[i]);
				if (inpMsg26[i] != null)
					model.setInpMsg26(inpMsg26[i]);
				if (inpMsg25[i] != null)
					model.setInpMsg25(inpMsg25[i]);
				if (inpMsg24[i] != null)
					model.setInpMsg24(inpMsg24[i]);
				if (inpMsg29[i] != null)
					model.setInpMsg29(inpMsg29[i]);
				if (inpMsg28[i] != null)
					model.setInpMsg28(inpMsg28[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (mnrLbrBzcAmt[i] != null)
					model.setMnrLbrBzcAmt(mnrLbrBzcAmt[i]);
				if (inpMsg30[i] != null)
					model.setInpMsg30(inpMsg30[i]);
				if (rprLbrRt[i] != null)
					model.setRprLbrRt(rprLbrRt[i]);
				if (inpMsg32[i] != null)
					model.setInpMsg32(inpMsg32[i]);
				if (inpMsg31[i] != null)
					model.setInpMsg31(inpMsg31[i]);
				if (inpMsg34[i] != null)
					model.setInpMsg34(inpMsg34[i]);
				if (inpMsg33[i] != null)
					model.setInpMsg33(inpMsg33[i]);
				if (inpMsg36[i] != null)
					model.setInpMsg36(inpMsg36[i]);
				if (inpMsg35[i] != null)
					model.setInpMsg35(inpMsg35[i]);
				if (inpMsg38[i] != null)
					model.setInpMsg38(inpMsg38[i]);
				if (inpMsg37[i] != null)
					model.setInpMsg37(inpMsg37[i]);
				if (inpMsg39[i] != null)
					model.setInpMsg39(inpMsg39[i]);
				if (n3ptyBilLbrHrs[i] != null)
					model.setN3ptyBilLbrHrs(n3ptyBilLbrHrs[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrRprRqstVDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrRprRqstVDtlVO[]
	 */
	public CustomMnrRprRqstVDtlVO[] getCustomMnrRprRqstVDtlVOs(){
		CustomMnrRprRqstVDtlVO[] vos = (CustomMnrRprRqstVDtlVO[])models.toArray(new CustomMnrRprRqstVDtlVO[models.size()]);
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
		this.inpMsg2 = this.inpMsg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg3 = this.inpMsg3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue9 = this.tempValue9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg4 = this.inpMsg4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg5 = this.inpMsg5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue7 = this.tempValue7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue8 = this.tempValue8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue5 = this.tempValue5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue6 = this.tempValue6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg1 = this.inpMsg1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue3 = this.tempValue3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue4 = this.tempValue4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue1 = this.tempValue1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue2 = this.tempValue2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilLbrRt = this.n3ptyBilLbrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg48 = this.inpMsg48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg49 = this.inpMsg49 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg46 = this.inpMsg46 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg47 = this.inpMsg47 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg44 = this.inpMsg44 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg45 = this.inpMsg45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg42 = this.inpMsg42 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg43 = this.inpMsg43 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg40 = this.inpMsg40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTpCd = this.volTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg41 = this.inpMsg41 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilLbrCostAmt = this.n3ptyBilLbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfOptCd = this.trfOptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCd = this.eqRprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLrAcctFlg = this.mnrLrAcctFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlRecoAmt = this.mtrlRecoAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtrlCostAmt = this.mtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg9 = this.inpMsg9 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg50 = this.inpMsg50 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg8 = this.inpMsg8 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg7 = this.inpMsg7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpDtlSeq = this.tmpDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg6 = this.inpMsg6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrVrfyTpCd = this.mnrVrfyTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstVerNo = this.rprRqstVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrBzcHrs = this.rprLbrBzcHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstDtlSeq = this.rprRqstDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrAgmtAmt = this.mnrAgmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprQty = this.rprQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCdChkFlg = this.eqCmpoCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempValue10 = this.tempValue10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstLstVerFlg = this.rprRqstLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCmpoCd = this.eqCmpoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDtlCd = this.costDtlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocCdChkFlg = this.eqLocCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchMtrlCostAmt = this.xchMtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrMtrlBzcAmt = this.lbrMtrlBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgCd = this.eqDmgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprSzNo = this.rprSzNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWrkAmt = this.mnrWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprWdtNo = this.rprWdtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstSeq = this.rprRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLenNo = this.rprLenNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilAmt = this.n3ptyBilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfDivCd = this.trfDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrBzcRt = this.rprLbrBzcRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqRprCdChkFlg = this.eqRprCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgCdChkFlg = this.eqDmgCdChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilMtrlCostAmt = this.n3ptyBilMtrlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg10 = this.inpMsg10 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg12 = this.inpMsg12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg11 = this.inpMsg11 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg18 = this.inpMsg18 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg17 = this.inpMsg17 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrHrs = this.rprLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg19 = this.inpMsg19 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg14 = this.inpMsg14 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg13 = this.inpMsg13 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg16 = this.inpMsg16 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg15 = this.inpMsg15 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocCd = this.eqLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprDtlRmk = this.rprDtlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lbrCostAmt = this.lbrCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg23 = this.inpMsg23 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg22 = this.inpMsg22 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg21 = this.inpMsg21 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg20 = this.inpMsg20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg27 = this.inpMsg27 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg26 = this.inpMsg26 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg25 = this.inpMsg25 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg24 = this.inpMsg24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg29 = this.inpMsg29 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg28 = this.inpMsg28 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLbrBzcAmt = this.mnrLbrBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg30 = this.inpMsg30 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprLbrRt = this.rprLbrRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg32 = this.inpMsg32 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg31 = this.inpMsg31 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg34 = this.inpMsg34 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg33 = this.inpMsg33 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg36 = this.inpMsg36 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg35 = this.inpMsg35 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg38 = this.inpMsg38 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg37 = this.inpMsg37 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpMsg39 = this.inpMsg39 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilLbrHrs = this.n3ptyBilLbrHrs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
