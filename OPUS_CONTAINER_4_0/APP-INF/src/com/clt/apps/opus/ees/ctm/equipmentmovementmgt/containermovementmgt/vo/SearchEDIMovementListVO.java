/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SearchEDIMovementListVO.java
*@FileTitle : SearchEDIMovementListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.08  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchEDIMovementListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchEDIMovementListVO> models = new ArrayList<SearchEDIMovementListVO>();
	
	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String mtyRepoNo = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String mvmtEdiMsgSeq = null;
	/* Column Info */
	private String tirNo = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String destNmCd = null;
	/* Column Info */
	private String destSteCd = null;
	/* Column Info */
	private String endRowNo = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mvmtEdiRmk = null;
	/* Column Info */
	private String batchFlg = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String evntYdCd = null;
	/* Column Info */
	private String pDate3 = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String iPage = null;
	/* Column Info */
	private String mvmtEdiTpCd = null;
	/* Column Info */
	private String eventReceive = null;
	/* Column Info */
	private String bkgBl = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String mvmtEdiMsgAreaCd = null;
	/* Column Info */
	private String ediMvmtStsCd = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String mvmtEdiRsltCd = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String userNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String pCntrno = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String mvmtEdiMsgYrmondy = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String callSgnLloyd = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String tmlNm = null;
	/* Column Info */
	private String startRowNo = null;
	/* Column Info */
	private String ediGateIoCd = null;
	/* Column Info */
	private String vvdCombo = null;
	/* Column Info */
	private String checkDigit = null;
	/* Column Info */
	private String fltFileRefNo = null;
	/* Column Info */
	private String rtvTotal = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rtyKnt = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String mvmtEdiSghtCd = null;
	/* Column Info */
	private String ediVvdCd = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String mtyPlnNo = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String cntrStwgNo = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String ediUiYn = null;
	/* Column Info */
	private String ediCrrNo = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String trspDocNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrFullStsCd = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String ediBkgNo = null;
	/* Column Info */
	private String crntVslCd = null;
	/* Column Info */
	private String vvdValue = null;
	/* Column Info */
	private String cntrDmgFlg = null;
	/* Column Info */
	private String dmgFlgDt = null;
	/* Column Info */
	private String dmgUnflgDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String ediMtyEqRepoRefNo = null;
	/* Column Info */
	private String nullFlg = null;
	/* Column Info */
	private String errWtOk = null;
	/* Column Info */
	private String vgmDocIdNo = null;
	/* Column Info */
	private String vgmWgt = null;
	/* Column Info */
	private String vgmEdiWgtUtCd = null;
	/* Column Info */
	private String vgmDocTpCd = null;
	/* Column Info */
	private String vgmDtTpCd = null;
	/* Column Info */
	private String vgmHndlDt = null;
	/* Column Info */
	private String vgmCustCntcTpCd = null;
	/* Column Info */
	private String vgmCustCntcNm = null;
	/* Column Info */
	private String vgmCustFaxNo = null;
	/* Column Info */
	private String vgmCustEml = null;
	/* Column Info */
	private String vgmCustPhnNo = null;
	/* Column Info */
	private String vgmCustAddr = null;
	/* Column Info */
	private String usaEdiCd = null;
	/* Column Info */
	private String cntrStwgPsnCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchEDIMovementListVO() {}

	public SearchEDIMovementListVO(String ibflag, String pagerows, String crntSkdVoyNo, String mvmtEdiMsgTpId, String chssNo, String mvmtTrspModCd, String mvmtEdiMsgSeq, String destYdCd, String destNmCd, String destSteCd, String endRowNo, String blNo, String mvmtEdiRmk, String batchFlg, String polCd, String pDate1, String evntYdCd, String vvdCd, String cntrDmgFlg, String dmgFlgDt, String dmgUnflgDt, String pDate3, String pDate2, String userId, String cntrTpszCd, String iPage, String mvmtEdiTpCd, String eventReceive, String bkgBl, String evntDt, String mvmtEdiMsgAreaCd, String ediMvmtStsCd, String callSgnNo, String mvmtEdiRsltCd, String wblNo, String userNm, String podCd, String pCntrno, String bkgNo, String lloydNo, String creLoclDt, String mvmtEdiMsgYrmondy, String cnmvRmk, String vndrSeq, String pYard2, String pYard1, String callSgnLloyd, String pkupNo, String tmlNm, String startRowNo, String ediGateIoCd, String vvdCombo, String checkDigit, String rtvTotal, String rtyKnt, String mvmtEdiSghtCd, String rccCd, String crntSkdDirCd, String ediUiYn, String mgstNo, String lccCd, String cntrNo, String cntrFullStsCd, String ediBkgNo, String cntrSealNo, String crntVslCd, String vvdValue, String cntrStwgNo, String errMsg, String ediCrrNo, String trspDocNo, String mtyRepoNo, String woNo, String mtyPlnNo, String tirNo, String ediVvdCd, String vslEngNm, String fltFileRefNo, String updUsrId, String ediMtyEqRepoRefNo, String nullFlg, String errWtOk,
			String vgmDocIdNo, String vgmWgt, String vgmEdiWgtUtCd, String vgmDocTpCd, String vgmDtTpCd, String vgmHndlDt, String vgmCustCntcTpCd, String vgmCustCntcNm, String vgmCustFaxNo, String vgmCustEml, String vgmCustPhnNo, String vgmCustAddr, String usaEdiCd, String cntrStwgPsnCtnt) {
		this.crntSkdVoyNo = crntSkdVoyNo;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.chssNo = chssNo;
		this.mtyRepoNo = mtyRepoNo;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
		this.tirNo = tirNo;
		this.destYdCd = destYdCd;
		this.destNmCd = destNmCd;
		this.destSteCd = destSteCd;
		this.endRowNo = endRowNo;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.mvmtEdiRmk = mvmtEdiRmk;
		this.batchFlg = batchFlg;
		this.pDate1 = pDate1;
		this.polCd = polCd;
		this.evntYdCd = evntYdCd;
		this.pDate3 = pDate3;
		this.vvdCd = vvdCd;
		this.cntrDmgFlg = cntrDmgFlg;
		this.dmgFlgDt = dmgFlgDt;
		this.dmgUnflgDt = dmgUnflgDt;
		this.pDate2 = pDate2;
		this.cntrTpszCd = cntrTpszCd;
		this.userId = userId;
		this.iPage = iPage;
		this.mvmtEdiTpCd = mvmtEdiTpCd;
		this.eventReceive = eventReceive;
		this.bkgBl = bkgBl;
		this.evntDt = evntDt;
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
		this.ediMvmtStsCd = ediMvmtStsCd;
		this.callSgnNo = callSgnNo;
		this.mvmtEdiRsltCd = mvmtEdiRsltCd;
		this.wblNo = wblNo;
		this.userNm = userNm;
		this.podCd = podCd;
		this.pCntrno = pCntrno;
		this.bkgNo = bkgNo;
		this.lloydNo = lloydNo;
		this.creLoclDt = creLoclDt;
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
		this.cnmvRmk = cnmvRmk;
		this.vndrSeq = vndrSeq;
		this.pYard2 = pYard2;
		this.errMsg = errMsg;
		this.pYard1 = pYard1;
		this.callSgnLloyd = callSgnLloyd;
		this.pkupNo = pkupNo;
		this.tmlNm = tmlNm;
		this.startRowNo = startRowNo;
		this.ediGateIoCd = ediGateIoCd;
		this.vvdCombo = vvdCombo;
		this.checkDigit = checkDigit;
		this.fltFileRefNo = fltFileRefNo;
		this.rtvTotal = rtvTotal;
		this.ibflag = ibflag;
		this.rtyKnt = rtyKnt;
		this.woNo = woNo;
		this.mvmtEdiSghtCd = mvmtEdiSghtCd;
		this.ediVvdCd = ediVvdCd;
		this.vslEngNm = vslEngNm;
		this.rccCd = rccCd;
		this.mtyPlnNo = mtyPlnNo;
		this.crntSkdDirCd = crntSkdDirCd;
		this.cntrStwgNo = cntrStwgNo;
		this.mgstNo = mgstNo;
		this.ediUiYn = ediUiYn;
		this.ediCrrNo = ediCrrNo;
		this.lccCd = lccCd;
		this.trspDocNo = trspDocNo;
		this.cntrNo = cntrNo;
		this.cntrFullStsCd = cntrFullStsCd;
		this.cntrSealNo = cntrSealNo;
		this.ediBkgNo = ediBkgNo;
		this.crntVslCd = crntVslCd;
		this.vvdValue = vvdValue;
		this.updUsrId = updUsrId;
		this.ediMtyEqRepoRefNo = ediMtyEqRepoRefNo;
		this.nullFlg = nullFlg;
		this.errWtOk = errWtOk;
		this.vgmDocIdNo = vgmDocIdNo;
		this.vgmWgt = vgmWgt;
		this.vgmEdiWgtUtCd = vgmEdiWgtUtCd;
		this.vgmDocTpCd = vgmDocTpCd;
		this.vgmDtTpCd = vgmDtTpCd;
		this.vgmHndlDt = vgmHndlDt;
		this.vgmCustCntcTpCd = vgmCustCntcTpCd;
		this.vgmCustCntcNm = vgmCustCntcNm;
		this.vgmCustFaxNo = vgmCustFaxNo;
		this.vgmCustEml = vgmCustEml;
		this.vgmCustPhnNo = vgmCustPhnNo;
		this.vgmCustAddr = vgmCustAddr;
		this.usaEdiCd = usaEdiCd;
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("mty_repo_no", getMtyRepoNo());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("mvmt_edi_msg_seq", getMvmtEdiMsgSeq());
		this.hashColumns.put("tir_no", getTirNo());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("dest_nm_cd", getDestNmCd());
		this.hashColumns.put("dest_ste_cd", getDestSteCd());
		this.hashColumns.put("end_row_no", getEndRowNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mvmt_edi_rmk", getMvmtEdiRmk());
		this.hashColumns.put("batch_flg", getBatchFlg());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("evnt_yd_cd", getEvntYdCd());
		this.hashColumns.put("p_date3", getPDate3());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("cntr_dmg_flg", getCntrDmgFlg());
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("i_page", getIPage());
		this.hashColumns.put("mvmt_edi_tp_cd", getMvmtEdiTpCd());
		this.hashColumns.put("event_receive", getEventReceive());
		this.hashColumns.put("bkg_bl", getBkgBl());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());
		this.hashColumns.put("edi_mvmt_sts_cd", getEdiMvmtStsCd());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("mvmt_edi_rslt_cd", getMvmtEdiRsltCd());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("mvmt_edi_msg_yrmondy", getMvmtEdiMsgYrmondy());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("call_sgn_lloyd", getCallSgnLloyd());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("tml_nm", getTmlNm());
		this.hashColumns.put("start_row_no", getStartRowNo());
		this.hashColumns.put("edi_gate_io_cd", getEdiGateIoCd());
		this.hashColumns.put("vvd_combo", getVvdCombo());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("flt_file_ref_no", getFltFileRefNo());
		this.hashColumns.put("rtv_total", getRtvTotal());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rty_knt", getRtyKnt());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("mvmt_edi_sght_cd", getMvmtEdiSghtCd());
		this.hashColumns.put("edi_vvd_cd", getEdiVvdCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("mty_pln_no", getMtyPlnNo());
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());
		this.hashColumns.put("cntr_stwg_no", getCntrStwgNo());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("edi_ui_yn", getEdiUiYn());
		this.hashColumns.put("edi_crr_no", getEdiCrrNo());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("trsp_doc_no", getTrspDocNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_full_sts_cd", getCntrFullStsCd());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("edi_bkg_no", getEdiBkgNo());
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());
		this.hashColumns.put("vvd_value", getVvdValue());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("edi_mty_eq_repo_ref_no", getEdiMtyEqRepoRefNo());
		this.hashColumns.put("null_flg", getNullFlg());
		this.hashColumns.put("err_wt_ok", getErrWtOk());
		this.hashColumns.put("vgm_doc_id_no", getVgmDocIdNo());
		this.hashColumns.put("vgm_wgt", getVgmWgt());
		this.hashColumns.put("vgm_edi_wgt_ut_cd", getVgmEdiWgtUtCd());
		this.hashColumns.put("vgm_doc_tp_cd", getVgmDocTpCd());
		this.hashColumns.put("vgm_dt_tp_cd", getVgmDtTpCd());
		this.hashColumns.put("vgm_hndl_dt", getVgmHndlDt());
		this.hashColumns.put("vgm_cust_cntc_tp_cd", getVgmCustCntcTpCd());
		this.hashColumns.put("vgm_cust_cntc_nm", getVgmCustCntcNm());
		this.hashColumns.put("vgm_cust_fax_no", getVgmCustFaxNo());
		this.hashColumns.put("vgm_cust_eml", getVgmCustEml());
		this.hashColumns.put("vgm_cust_phn_no", getVgmCustPhnNo());
		this.hashColumns.put("vgm_cust_addr", getVgmCustAddr());
		this.hashColumns.put("usa_edi_cd", getUsaEdiCd());
		this.hashColumns.put("cntr_stwg_psn_ctnt", getCntrStwgPsnCtnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mty_repo_no", "mtyRepoNo");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("mvmt_edi_msg_seq", "mvmtEdiMsgSeq");
		this.hashFields.put("tir_no", "tirNo");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("dest_nm_cd", "destNmCd");
		this.hashFields.put("dest_ste_cd", "destSteCd");
		this.hashFields.put("end_row_no", "endRowNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mvmt_edi_rmk", "mvmtEdiRmk");
		this.hashFields.put("batch_flg", "batchFlg");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("evnt_yd_cd", "evntYdCd");
		this.hashFields.put("p_date3", "pDate3");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_dmg_flg", "cntrDmgFlg");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("mvmt_edi_tp_cd", "mvmtEdiTpCd");
		this.hashFields.put("event_receive", "eventReceive");
		this.hashFields.put("bkg_bl", "bkgBl");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("edi_mvmt_sts_cd", "ediMvmtStsCd");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("mvmt_edi_rslt_cd", "mvmtEdiRsltCd");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("mvmt_edi_msg_yrmondy", "mvmtEdiMsgYrmondy");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("call_sgn_lloyd", "callSgnLloyd");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("tml_nm", "tmlNm");
		this.hashFields.put("start_row_no", "startRowNo");
		this.hashFields.put("edi_gate_io_cd", "ediGateIoCd");
		this.hashFields.put("vvd_combo", "vvdCombo");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("flt_file_ref_no", "fltFileRefNo");
		this.hashFields.put("rtv_total", "rtvTotal");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rty_knt", "rtyKnt");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("mvmt_edi_sght_cd", "mvmtEdiSghtCd");
		this.hashFields.put("edi_vvd_cd", "ediVvdCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("mty_pln_no", "mtyPlnNo");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("cntr_stwg_no", "cntrStwgNo");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("edi_ui_yn", "ediUiYn");
		this.hashFields.put("edi_crr_no", "ediCrrNo");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("trsp_doc_no", "trspDocNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_full_sts_cd", "cntrFullStsCd");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("edi_bkg_no", "ediBkgNo");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("vvd_value", "vvdValue");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("edi_mty_eq_repo_ref_no", "ediMtyEqRepoRefNo");
		this.hashFields.put("null_flg", "nullFlg");
		this.hashFields.put("err_wt_ok", "errWtOk");
		this.hashFields.put("vgm_doc_id_no", "vgmDocIdNo");
		this.hashFields.put("vgm_wgt", "vgmWgt");
		this.hashFields.put("vgm_edi_wgt_ut_cd", "vgmEdiWgtUtCd");
		this.hashFields.put("vgm_doc_tp_cd", "vgmDocTpCd");
		this.hashFields.put("vgm_dt_tp_cd", "vgmDtTpCd");
		this.hashFields.put("vgm_hndl_dt", "vgmHndlDt");
		this.hashFields.put("vgm_cust_cntc_tp_cd", "vgmCustCntcTpCd");
		this.hashFields.put("vgm_cust_cntc_nm", "vgmCustCntcNm");
		this.hashFields.put("vgm_cust_fax_no", "vgmCustFaxNo");
		this.hashFields.put("vgm_cust_eml", "vgmCustEml");
		this.hashFields.put("vgm_cust_phn_no", "vgmCustPhnNo");
		this.hashFields.put("vgm_cust_addr", "vgmCustAddr");
		this.hashFields.put("usa_edi_cd", "usaEdiCd");
		this.hashFields.put("cntr_stwg_psn_ctnt", "cntrStwgPsnCtnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return crntSkdVoyNo
	 */
	public String getCrntSkdVoyNo() {
		return this.crntSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return chssNo
	 */
	public String getChssNo() {
		return this.chssNo;
	}
	
	/**
	 * Column Info
	 * @return mtyRepoNo
	 */
	public String getMtyRepoNo() {
		return this.mtyRepoNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtTrspModCd
	 */
	public String getMvmtTrspModCd() {
		return this.mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgSeq
	 */
	public String getMvmtEdiMsgSeq() {
		return this.mvmtEdiMsgSeq;
	}
	
	/**
	 * Column Info
	 * @return tirNo
	 */
	public String getTirNo() {
		return this.tirNo;
	}
	
	/**
	 * Column Info
	 * @return destYdCd
	 */
	public String getDestYdCd() {
		return this.destYdCd;
	}
	
	/**
	 * Column Info
	 * @return destNmCd
	 */
	public String getDestNmCd() {
		return this.destNmCd;
	}
	
	/**
	 * Column Info
	 * @return destSteCd
	 */
	public String getDestSteCd() {
		return this.destSteCd;
	}
	
	/**
	 * Column Info
	 * @return endRowNo
	 */
	public String getEndRowNo() {
		return this.endRowNo;
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
	 * @return mvmtEdiRmk
	 */
	public String getMvmtEdiRmk() {
		return this.mvmtEdiRmk;
	}
	
	/**
	 * Column Info
	 * @return batchFlg
	 */
	public String getBatchFlg() {
		return this.batchFlg;
	}
	
	/**
	 * Column Info
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return evntYdCd
	 */
	public String getEvntYdCd() {
		return this.evntYdCd;
	}
	
	/**
	 * Column Info
	 * @return pDate3
	 */
	public String getPDate3() {
		return this.pDate3;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return cntrDmgFlg
	 */
	public String getCntrDmgFlg() {
		return this.cntrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @return dmgFlgDt
	 */
	public String getDmgFlgDt() {
		return this.dmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @return dmgUnflgDt
	 */
	public String getDmgUnflgDt() {
		return this.dmgUnflgDt;
	}
	
	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return iPage
	 */
	public String getIPage() {
		return this.iPage;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiTpCd
	 */
	public String getMvmtEdiTpCd() {
		return this.mvmtEdiTpCd;
	}
	
	/**
	 * Column Info
	 * @return eventReceive
	 */
	public String getEventReceive() {
		return this.eventReceive;
	}
	
	/**
	 * Column Info
	 * @return bkgBl
	 */
	public String getBkgBl() {
		return this.bkgBl;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgAreaCd
	 */
	public String getMvmtEdiMsgAreaCd() {
		return this.mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @return ediMvmtStsCd
	 */
	public String getEdiMvmtStsCd() {
		return this.ediMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiRsltCd
	 */
	public String getMvmtEdiRsltCd() {
		return this.mvmtEdiRsltCd;
	}
	
	/**
	 * Column Info
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
	}
	
	/**
	 * Column Info
	 * @return userNm
	 */
	public String getUserNm() {
		return this.userNm;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return pCntrno
	 */
	public String getPCntrno() {
		return this.pCntrno;
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
	 * @return lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return creLoclDt
	 */
	public String getCreLoclDt() {
		return this.creLoclDt;
	}
	
	/**
	 * Column Info
	 * @return mvmtEdiMsgYrmondy
	 */
	public String getMvmtEdiMsgYrmondy() {
		return this.mvmtEdiMsgYrmondy;
	}
	
	/**
	 * Column Info
	 * @return cnmvRmk
	 */
	public String getCnmvRmk() {
		return this.cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
	}
	
	/**
	 * Column Info
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
	}
	
	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}
	
	/**
	 * Column Info
	 * @return callSgnLloyd
	 */
	public String getCallSgnLloyd() {
		return this.callSgnLloyd;
	}
	
	/**
	 * Column Info
	 * @return pkupNo
	 */
	public String getPkupNo() {
		return this.pkupNo;
	}
	
	/**
	 * Column Info
	 * @return tmlNm
	 */
	public String getTmlNm() {
		return this.tmlNm;
	}
	
	/**
	 * Column Info
	 * @return startRowNo
	 */
	public String getStartRowNo() {
		return this.startRowNo;
	}
	
	/**
	 * Column Info
	 * @return ediGateIoCd
	 */
	public String getEdiGateIoCd() {
		return this.ediGateIoCd;
	}
	
	/**
	 * Column Info
	 * @return vvdCombo
	 */
	public String getVvdCombo() {
		return this.vvdCombo;
	}
	
	/**
	 * Column Info
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
	}
	
	/**
	 * Column Info
	 * @return fltFileRefNo
	 */
	public String getFltFileRefNo() {
		return this.fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @return rtvTotal
	 */
	public String getRtvTotal() {
		return this.rtvTotal;
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
	 * @return rtyKnt
	 */
	public String getRtyKnt() {
		return this.rtyKnt;
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
	 * @return mvmtEdiSghtCd
	 */
	public String getMvmtEdiSghtCd() {
		return this.mvmtEdiSghtCd;
	}
	
	/**
	 * Column Info
	 * @return ediVvdCd
	 */
	public String getEdiVvdCd() {
		return this.ediVvdCd;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPlnNo
	 */
	public String getMtyPlnNo() {
		return this.mtyPlnNo;
	}
	
	/**
	 * Column Info
	 * @return crntSkdDirCd
	 */
	public String getCrntSkdDirCd() {
		return this.crntSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStwgNo
	 */
	public String getCntrStwgNo() {
		return this.cntrStwgNo;
	}
	
	/**
	 * Column Info
	 * @return mgstNo
	 */
	public String getMgstNo() {
		return this.mgstNo;
	}
	
	/**
	 * Column Info
	 * @return ediUiYn
	 */
	public String getEdiUiYn() {
		return this.ediUiYn;
	}
	
	/**
	 * Column Info
	 * @return ediCrrNo
	 */
	public String getEdiCrrNo() {
		return this.ediCrrNo;
	}
	
	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}
	
	/**
	 * Column Info
	 * @return trspDocNo
	 */
	public String getTrspDocNo() {
		return this.trspDocNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrFullStsCd
	 */
	public String getCntrFullStsCd() {
		return this.cntrFullStsCd;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return ediBkgNo
	 */
	public String getEdiBkgNo() {
		return this.ediBkgNo;
	}
	
	/**
	 * Column Info
	 * @return crntVslCd
	 */
	public String getCrntVslCd() {
		return this.crntVslCd;
	}
	
	/**
	 * Column Info
	 * @return vvdValue
	 */
	public String getVvdValue() {
		return this.vvdValue;
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
	 * @return ediMtyEqRepoRefNo
	 */
	public String getEdiMtyEqRepoRefNo() {
		return this.ediMtyEqRepoRefNo;
	}
	
	/**
	 * Column Info
	 * @return nullFlg
	 */
	public String getNullFlg() {
		return this.nullFlg;
	}
	
	/**
	 * Column Info
	 * @return errWtOk
	 */
	public String getErrWtOk() {
		return this.errWtOk;
	}
	
	/**
	 * Column Info
	 * @return vgmDocIdNo
	 */
	public String getVgmDocIdNo() {
		return this.vgmDocIdNo;
	}
	
	/**
	 * Column Info
	 * @return vgmWgt
	 */
	public String getVgmWgt() {
		return this.vgmWgt;
	}
	
	/**
	 * Column Info
	 * @return vgmEdiWgtUtCd
	 */
	public String getVgmEdiWgtUtCd() {
		return this.vgmEdiWgtUtCd;
	}
	
	
	/**
	 * Column Info
	 * @return vgmDocTpCd
	 */
	public String getVgmDocTpCd() {
		return this.vgmDocTpCd;
	}
	
	
	/**
	 * Column Info
	 * @return vgmDtTpCd
	 */
	public String getVgmDtTpCd() {
		return this.vgmDtTpCd;
	}
	
	/**
	 * Column Info
	 * @return vgmHndlDt
	 */
	public String getVgmHndlDt() {
		return this.vgmHndlDt;
	}
	
	/**
	 * Column Info
	 * @return vgmCustCntcTpCd
	 */
	public String getVgmCustCntcTpCd() {
		return this.vgmCustCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @return vgmCustCntcNm
	 */
	public String getVgmCustCntcNm() {
		return this.vgmCustCntcNm;
	}
	
	/**
	 * Column Info
	 * @return vgmCustFaxNo
	 */
	public String getVgmCustFaxNo() {
		return this.vgmCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @return vgmCustEml
	 */
	public String getVgmCustEml() {
		return this.vgmCustEml;
	}
	
	/**
	 * Column Info
	 * @return vgmCustPhnNo
	 */
	public String getVgmCustPhnNo() {
		return this.vgmCustPhnNo;
	}
	
	/**
	 * Column Info
	 * @return vgmCustAddr
	 */
	public String getVgmCustAddr() {
		return this.vgmCustAddr;
	}
	
	/**
	 * Column Info
	 * @return usaEdiCd
	 */
	public String getUsaEdiCd() {
		return this.usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @return cntrStwgPsnCtnt
	 */
	public String getCntrStwgPsnCtnt() {
		return this.cntrStwgPsnCtnt;
	}
	

	/**
	 * Column Info
	 * @param crntSkdVoyNo
	 */
	public void setCrntSkdVoyNo(String crntSkdVoyNo) {
		this.crntSkdVoyNo = crntSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param chssNo
	 */
	public void setChssNo(String chssNo) {
		this.chssNo = chssNo;
	}
	
	/**
	 * Column Info
	 * @param mtyRepoNo
	 */
	public void setMtyRepoNo(String mtyRepoNo) {
		this.mtyRepoNo = mtyRepoNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtTrspModCd
	 */
	public void setMvmtTrspModCd(String mvmtTrspModCd) {
		this.mvmtTrspModCd = mvmtTrspModCd;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgSeq
	 */
	public void setMvmtEdiMsgSeq(String mvmtEdiMsgSeq) {
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
	}
	
	/**
	 * Column Info
	 * @param tirNo
	 */
	public void setTirNo(String tirNo) {
		this.tirNo = tirNo;
	}
	
	/**
	 * Column Info
	 * @param destYdCd
	 */
	public void setDestYdCd(String destYdCd) {
		this.destYdCd = destYdCd;
	}
	
	/**
	 * Column Info
	 * @param destNmCd
	 */
	public void setDestNmCd(String destNmCd) {
		this.destNmCd = destNmCd;
	}
	
	/**
	 * Column Info
	 * @param destSteCd
	 */
	public void setDestSteCd(String destSteCd) {
		this.destSteCd = destSteCd;
	}
	
	/**
	 * Column Info
	 * @param endRowNo
	 */
	public void setEndRowNo(String endRowNo) {
		this.endRowNo = endRowNo;
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
	 * @param mvmtEdiRmk
	 */
	public void setMvmtEdiRmk(String mvmtEdiRmk) {
		this.mvmtEdiRmk = mvmtEdiRmk;
	}
	
	/**
	 * Column Info
	 * @param batchFlg
	 */
	public void setBatchFlg(String batchFlg) {
		this.batchFlg = batchFlg;
	}
	
	/**
	 * Column Info
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param evntYdCd
	 */
	public void setEvntYdCd(String evntYdCd) {
		this.evntYdCd = evntYdCd;
	}
	
	/**
	 * Column Info
	 * @param pDate3
	 */
	public void setPDate3(String pDate3) {
		this.pDate3 = pDate3;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param cntrDmgFlg
	 */
	public void setCntrDmgFlg(String cntrDmgFlg) {
		this.cntrDmgFlg = cntrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @param dmgFlgDt
	 */
	public void setDmgFlgDt(String dmgFlgDt) {
		this.dmgFlgDt = dmgFlgDt;
	}
	
	/**
	 * Column Info
	 * @param dmgUnflgDt
	 */
	public void setDmgUnflgDt(String dmgUnflgDt) {
		this.dmgUnflgDt = dmgUnflgDt;
	}
	
	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param iPage
	 */
	public void setIPage(String iPage) {
		this.iPage = iPage;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiTpCd
	 */
	public void setMvmtEdiTpCd(String mvmtEdiTpCd) {
		this.mvmtEdiTpCd = mvmtEdiTpCd;
	}
	
	/**
	 * Column Info
	 * @param eventReceive
	 */
	public void setEventReceive(String eventReceive) {
		this.eventReceive = eventReceive;
	}
	
	/**
	 * Column Info
	 * @param bkgBl
	 */
	public void setBkgBl(String bkgBl) {
		this.bkgBl = bkgBl;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgAreaCd
	 */
	public void setMvmtEdiMsgAreaCd(String mvmtEdiMsgAreaCd) {
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @param ediMvmtStsCd
	 */
	public void setEdiMvmtStsCd(String ediMvmtStsCd) {
		this.ediMvmtStsCd = ediMvmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiRsltCd
	 */
	public void setMvmtEdiRsltCd(String mvmtEdiRsltCd) {
		this.mvmtEdiRsltCd = mvmtEdiRsltCd;
	}
	
	/**
	 * Column Info
	 * @param wblNo
	 */
	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
	}
	
	/**
	 * Column Info
	 * @param userNm
	 */
	public void setUserNm(String userNm) {
		this.userNm = userNm;
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
	 * @param pCntrno
	 */
	public void setPCntrno(String pCntrno) {
		this.pCntrno = pCntrno;
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
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	/**
	 * Column Info
	 * @param creLoclDt
	 */
	public void setCreLoclDt(String creLoclDt) {
		this.creLoclDt = creLoclDt;
	}
	
	/**
	 * Column Info
	 * @param mvmtEdiMsgYrmondy
	 */
	public void setMvmtEdiMsgYrmondy(String mvmtEdiMsgYrmondy) {
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
	}
	
	/**
	 * Column Info
	 * @param cnmvRmk
	 */
	public void setCnmvRmk(String cnmvRmk) {
		this.cnmvRmk = cnmvRmk;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
	}
	
	/**
	 * Column Info
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}
	
	/**
	 * Column Info
	 * @param callSgnLloyd
	 */
	public void setCallSgnLloyd(String callSgnLloyd) {
		this.callSgnLloyd = callSgnLloyd;
	}
	
	/**
	 * Column Info
	 * @param pkupNo
	 */
	public void setPkupNo(String pkupNo) {
		this.pkupNo = pkupNo;
	}
	
	/**
	 * Column Info
	 * @param tmlNm
	 */
	public void setTmlNm(String tmlNm) {
		this.tmlNm = tmlNm;
	}
	
	/**
	 * Column Info
	 * @param startRowNo
	 */
	public void setStartRowNo(String startRowNo) {
		this.startRowNo = startRowNo;
	}
	
	/**
	 * Column Info
	 * @param ediGateIoCd
	 */
	public void setEdiGateIoCd(String ediGateIoCd) {
		this.ediGateIoCd = ediGateIoCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCombo
	 */
	public void setVvdCombo(String vvdCombo) {
		this.vvdCombo = vvdCombo;
	}
	
	/**
	 * Column Info
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
	}
	
	/**
	 * Column Info
	 * @param fltFileRefNo
	 */
	public void setFltFileRefNo(String fltFileRefNo) {
		this.fltFileRefNo = fltFileRefNo;
	}
	
	/**
	 * Column Info
	 * @param rtvTotal
	 */
	public void setRtvTotal(String rtvTotal) {
		this.rtvTotal = rtvTotal;
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
	 * @param rtyKnt
	 */
	public void setRtyKnt(String rtyKnt) {
		this.rtyKnt = rtyKnt;
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
	 * @param mvmtEdiSghtCd
	 */
	public void setMvmtEdiSghtCd(String mvmtEdiSghtCd) {
		this.mvmtEdiSghtCd = mvmtEdiSghtCd;
	}
	
	/**
	 * Column Info
	 * @param ediVvdCd
	 */
	public void setEdiVvdCd(String ediVvdCd) {
		this.ediVvdCd = ediVvdCd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPlnNo
	 */
	public void setMtyPlnNo(String mtyPlnNo) {
		this.mtyPlnNo = mtyPlnNo;
	}
	
	/**
	 * Column Info
	 * @param crntSkdDirCd
	 */
	public void setCrntSkdDirCd(String crntSkdDirCd) {
		this.crntSkdDirCd = crntSkdDirCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStwgNo
	 */
	public void setCntrStwgNo(String cntrStwgNo) {
		this.cntrStwgNo = cntrStwgNo;
	}
	
	/**
	 * Column Info
	 * @param mgstNo
	 */
	public void setMgstNo(String mgstNo) {
		this.mgstNo = mgstNo;
	}
	
	/**
	 * Column Info
	 * @param ediUiYn
	 */
	public void setEdiUiYn(String ediUiYn) {
		this.ediUiYn = ediUiYn;
	}
	
	/**
	 * Column Info
	 * @param ediCrrNo
	 */
	public void setEdiCrrNo(String ediCrrNo) {
		this.ediCrrNo = ediCrrNo;
	}
	
	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}
	
	/**
	 * Column Info
	 * @param trspDocNo
	 */
	public void setTrspDocNo(String trspDocNo) {
		this.trspDocNo = trspDocNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrFullStsCd
	 */
	public void setCntrFullStsCd(String cntrFullStsCd) {
		this.cntrFullStsCd = cntrFullStsCd;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param ediBkgNo
	 */
	public void setEdiBkgNo(String ediBkgNo) {
		this.ediBkgNo = ediBkgNo;
	}
	
	/**
	 * Column Info
	 * @param crntVslCd
	 */
	public void setCrntVslCd(String crntVslCd) {
		this.crntVslCd = crntVslCd;
	}
	
	/**
	 * Column Info
	 * @param vvdValue
	 */
	public void setVvdValue(String vvdValue) {
		this.vvdValue = vvdValue;
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
	 * @param ediMtyEqRepoRefNo
	 */
	public void setEdiMtyEqRepoRefNo(String ediMtyEqRepoRefNo) {
		this.ediMtyEqRepoRefNo = ediMtyEqRepoRefNo;
	}
	
	/**
	 * Column Info
	 * @param nullFlg
	 */
	public void setNullFlg(String nullFlg) {
		this.nullFlg = nullFlg;
	}
	
	/**
	 * Column Info
	 * @param errWtOk
	 */
	public void setErrWtOk(String errWtOk) {
		this.errWtOk = errWtOk;
	}
	
	/**
	 * Column Info
	 * @param vgmDocIdNo
	 */
	public void setVgmDocIdNo(String vgmDocIdNo) {
		this.vgmDocIdNo = vgmDocIdNo;
	}
	
	/**
	 * Column Info
	 * @param vgmWgt
	 */
	public void setVgmWgt(String vgmWgt) {
		this.vgmWgt = vgmWgt;
	}
	
	
	/**
	 * Column Info
	 * @param vgmEdiWgtUtCd
	 */
	public void setVgmEdiWgtUtCd(String vgmEdiWgtUtCd) {
		this.vgmEdiWgtUtCd = vgmEdiWgtUtCd;
	}
	
	
	/**
	 * Column Info
	 * @param vgmDocTpCd
	 */
	public void setVgmDocTpCd(String vgmDocTpCd) {
		this.vgmDocTpCd = vgmDocTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmDtTpCd
	 */
	public void setVgmDtTpCd(String vgmDtTpCd) {
		this.vgmDtTpCd = vgmDtTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmHndlDt
	 */
	public void setVgmHndlDt(String vgmHndlDt) {
		this.vgmHndlDt = vgmHndlDt;
	}
	
	/**
	 * Column Info
	 * @param vgmCustCntcTpCd
	 */
	public void setVgmCustCntcTpCd(String vgmCustCntcTpCd) {
		this.vgmCustCntcTpCd = vgmCustCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @param vgmCustCntcNm
	 */
	public void setVgmCustCntcNm(String vgmCustCntcNm) {
		this.vgmCustCntcNm = vgmCustCntcNm;
	}
	
	/**
	 * Column Info
	 * @param vgmCustFaxNo
	 */
	public void setVgmCustFaxNo(String vgmCustFaxNo) {
		this.vgmCustFaxNo = vgmCustFaxNo;
	}
	
	/**
	 * Column Info
	 * @param vgmCustEml
	 */
	public void setVgmCustEml(String vgmCustEml) {
		this.vgmCustEml = vgmCustEml;
	}
	
	/**
	 * Column Info
	 * @param vgmCustPhnNo
	 */
	public void setVgmCustPhnNo(String vgmCustPhnNo) {
		this.vgmCustPhnNo = vgmCustPhnNo;
	}
	
	/**
	 * Column Info
	 * @param vgmCustAddr
	 */
	public void setVgmCustAddr(String vgmCustAddr) {
		this.vgmCustAddr = vgmCustAddr;
	}
	
	/**
	 * Column Info
	 * @param usaEdiCd
	 */
	public void setUsaEdiCd(String usaEdiCd) {
		this.usaEdiCd = usaEdiCd;
	}
	
	/**
	 * Column Info
	 * @param cntrStwgPsnCtnt
	 */
	public void setCntrStwgPsnCtnt(String cntrStwgPsnCtnt) {
		this.cntrStwgPsnCtnt = cntrStwgPsnCtnt;
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
		setCrntSkdVoyNo(JSPUtil.getParameter(request, prefix + "crnt_skd_voy_no", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setMtyRepoNo(JSPUtil.getParameter(request, prefix + "mty_repo_no", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, prefix + "mvmt_trsp_mod_cd", ""));
		setMvmtEdiMsgSeq(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_seq", ""));
		setTirNo(JSPUtil.getParameter(request, prefix + "tir_no", ""));
		setDestYdCd(JSPUtil.getParameter(request, prefix + "dest_yd_cd", ""));
		setDestNmCd(JSPUtil.getParameter(request, prefix + "dest_nm_cd", ""));
		setDestSteCd(JSPUtil.getParameter(request, prefix + "dest_ste_cd", ""));
		setEndRowNo(JSPUtil.getParameter(request, prefix + "end_row_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMvmtEdiRmk(JSPUtil.getParameter(request, prefix + "mvmt_edi_rmk", ""));
		setBatchFlg(JSPUtil.getParameter(request, prefix + "batch_flg", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setEvntYdCd(JSPUtil.getParameter(request, prefix + "evnt_yd_cd", ""));
		setPDate3(JSPUtil.getParameter(request, prefix + "p_date3", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setCntrDmgFlg(JSPUtil.getParameter(request, prefix + "cntr_dmg_flg", ""));
		setDmgFlgDt(JSPUtil.getParameter(request, prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request, prefix + "dmg_unflg_dt", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setIPage(JSPUtil.getParameter(request, prefix + "i_page", ""));
		setMvmtEdiTpCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_tp_cd", ""));
		setEventReceive(JSPUtil.getParameter(request, prefix + "event_receive", ""));
		setBkgBl(JSPUtil.getParameter(request, prefix + "bkg_bl", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_area_cd", ""));
		setEdiMvmtStsCd(JSPUtil.getParameter(request, prefix + "edi_mvmt_sts_cd", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setMvmtEdiRsltCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_rslt_cd", ""));
		setWblNo(JSPUtil.getParameter(request, prefix + "wbl_no", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPCntrno(JSPUtil.getParameter(request, prefix + "p_cntrno", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setMvmtEdiMsgYrmondy(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_yrmondy", ""));
		setCnmvRmk(JSPUtil.getParameter(request, prefix + "cnmv_rmk", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setPYard2(JSPUtil.getParameter(request, prefix + "p_yard2", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setPYard1(JSPUtil.getParameter(request, prefix + "p_yard1", ""));
		setCallSgnLloyd(JSPUtil.getParameter(request, prefix + "call_sgn_lloyd", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setTmlNm(JSPUtil.getParameter(request, prefix + "tml_nm", ""));
		setStartRowNo(JSPUtil.getParameter(request, prefix + "start_row_no", ""));
		setEdiGateIoCd(JSPUtil.getParameter(request, prefix + "edi_gate_io_cd", ""));
		setVvdCombo(JSPUtil.getParameter(request, prefix + "vvd_combo", ""));
		setCheckDigit(JSPUtil.getParameter(request, prefix + "check_digit", ""));
		setFltFileRefNo(JSPUtil.getParameter(request, prefix + "flt_file_ref_no", ""));
		setRtvTotal(JSPUtil.getParameter(request, prefix + "rtv_total", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRtyKnt(JSPUtil.getParameter(request, prefix + "rty_knt", ""));
		setWoNo(JSPUtil.getParameter(request, prefix + "wo_no", ""));
		setMvmtEdiSghtCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_sght_cd", ""));
		setEdiVvdCd(JSPUtil.getParameter(request, prefix + "edi_vvd_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setMtyPlnNo(JSPUtil.getParameter(request, prefix + "mty_pln_no", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request, prefix + "crnt_skd_dir_cd", ""));
		setCntrStwgNo(JSPUtil.getParameter(request, prefix + "cntr_stwg_no", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setEdiUiYn(JSPUtil.getParameter(request, prefix + "edi_ui_yn", ""));
		setEdiCrrNo(JSPUtil.getParameter(request, prefix + "edi_crr_no", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setTrspDocNo(JSPUtil.getParameter(request, prefix + "trsp_doc_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrFullStsCd(JSPUtil.getParameter(request, prefix + "cntr_full_sts_cd", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setEdiBkgNo(JSPUtil.getParameter(request, prefix + "edi_bkg_no", ""));
		setCrntVslCd(JSPUtil.getParameter(request, prefix + "crnt_vsl_cd", ""));
		setVvdValue(JSPUtil.getParameter(request, prefix + "vvd_value", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setEdiMtyEqRepoRefNo(JSPUtil.getParameter(request, prefix + "edi_mty_eq_repo_ref_no", ""));
		setNullFlg(JSPUtil.getParameter(request, prefix + "null_flg", ""));
		setErrWtOk(JSPUtil.getParameter(request, prefix + "err_wt_ok", ""));
		setVgmDocIdNo(JSPUtil.getParameter(request, prefix + "vgm_doc_id_no", ""));
		setVgmWgt(JSPUtil.getParameter(request, prefix + "vgm_wgt", ""));
		setVgmEdiWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_edi_wgt_ut_cd", ""));
		setVgmDocTpCd(JSPUtil.getParameter(request, prefix + "vgm_doc_tp_cd", ""));
		setVgmDtTpCd(JSPUtil.getParameter(request, prefix + "vgm_dt_tp_cd", ""));
		setVgmHndlDt(JSPUtil.getParameter(request, prefix + "vgm_hndl_dt", ""));
		setVgmCustCntcTpCd(JSPUtil.getParameter(request, prefix + "vgm_cust_cntc_tp_cd", ""));
		setVgmCustCntcNm(JSPUtil.getParameter(request, prefix + "vgm_cust_cntc_nm", ""));
		setVgmCustFaxNo(JSPUtil.getParameter(request, prefix + "vgm_cust_fax_no", ""));
		setVgmCustEml(JSPUtil.getParameter(request, prefix + "vgm_cust_eml", ""));
		setVgmCustPhnNo(JSPUtil.getParameter(request, prefix + "vgm_cust_phn_no", ""));
		setVgmCustAddr(JSPUtil.getParameter(request, prefix + "vgm_cust_addr", ""));
		setUsaEdiCd(JSPUtil.getParameter(request, prefix + "usa_edi_cd", ""));
		setCntrStwgPsnCtnt(JSPUtil.getParameter(request, prefix + "cntr_stwg_psn_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchEDIMovementListVO[]
	 */
	public SearchEDIMovementListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchEDIMovementListVO[]
	 */
	public SearchEDIMovementListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchEDIMovementListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] crntSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_voy_no", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] mtyRepoNo = (JSPUtil.getParameter(request, prefix	+ "mty_repo_no", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] mvmtEdiMsgSeq = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_seq", length));
			String[] tirNo = (JSPUtil.getParameter(request, prefix	+ "tir_no", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] destNmCd = (JSPUtil.getParameter(request, prefix	+ "dest_nm_cd", length));
			String[] destSteCd = (JSPUtil.getParameter(request, prefix	+ "dest_ste_cd", length));
			String[] endRowNo = (JSPUtil.getParameter(request, prefix	+ "end_row_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mvmtEdiRmk = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_rmk", length));
			String[] batchFlg = (JSPUtil.getParameter(request, prefix	+ "batch_flg", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] evntYdCd = (JSPUtil.getParameter(request, prefix	+ "evnt_yd_cd", length));
			String[] pDate3 = (JSPUtil.getParameter(request, prefix	+ "p_date3", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] cntrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_dmg_flg", length));
			String[] dmgFlgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_flg_dt", length));
			String[] dmgUnflgDt = (JSPUtil.getParameter(request, prefix	+ "dmg_unflg_dt", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			String[] mvmtEdiTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_tp_cd", length));
			String[] eventReceive = (JSPUtil.getParameter(request, prefix	+ "event_receive", length));
			String[] bkgBl = (JSPUtil.getParameter(request, prefix	+ "bkg_bl", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] mvmtEdiMsgAreaCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_area_cd", length));
			String[] ediMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_mvmt_sts_cd", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] mvmtEdiRsltCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_rslt_cd", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] mvmtEdiMsgYrmondy = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_yrmondy", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] callSgnLloyd = (JSPUtil.getParameter(request, prefix	+ "call_sgn_lloyd", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] tmlNm = (JSPUtil.getParameter(request, prefix	+ "tml_nm", length));
			String[] startRowNo = (JSPUtil.getParameter(request, prefix	+ "start_row_no", length));
			String[] ediGateIoCd = (JSPUtil.getParameter(request, prefix	+ "edi_gate_io_cd", length));
			String[] vvdCombo = (JSPUtil.getParameter(request, prefix	+ "vvd_combo", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] fltFileRefNo = (JSPUtil.getParameter(request, prefix	+ "flt_file_ref_no", length));
			String[] rtvTotal = (JSPUtil.getParameter(request, prefix	+ "rtv_total", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rtyKnt = (JSPUtil.getParameter(request, prefix	+ "rty_knt", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] mvmtEdiSghtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_sght_cd", length));
			String[] ediVvdCd = (JSPUtil.getParameter(request, prefix	+ "edi_vvd_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] mtyPlnNo = (JSPUtil.getParameter(request, prefix	+ "mty_pln_no", length));
			String[] crntSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_dir_cd", length));
			String[] cntrStwgNo = (JSPUtil.getParameter(request, prefix	+ "cntr_stwg_no", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] ediUiYn = (JSPUtil.getParameter(request, prefix	+ "edi_ui_yn", length));
			String[] ediCrrNo = (JSPUtil.getParameter(request, prefix	+ "edi_crr_no", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] trspDocNo = (JSPUtil.getParameter(request, prefix	+ "trsp_doc_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrFullStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_full_sts_cd", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] ediBkgNo = (JSPUtil.getParameter(request, prefix	+ "edi_bkg_no", length));
			String[] crntVslCd = (JSPUtil.getParameter(request, prefix	+ "crnt_vsl_cd", length));
			String[] vvdValue = (JSPUtil.getParameter(request, prefix	+ "vvd_value", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] ediMtyEqRepoRefNo = (JSPUtil.getParameter(request, prefix	+ "edi_mty_eq_repo_ref_no", length));
			String[] nullFlg = (JSPUtil.getParameter(request, prefix	+ "null_flg", length));
			String[] errWtOk = (JSPUtil.getParameter(request, prefix	+ "err_wt_ok", length));
			String[] vgmDocIdNo = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_id_no", length));
			String[] vgmWgt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt", length));
			String[] vgmEdiWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_edi_wgt_ut_cd", length));
			String[] vgmDocTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_doc_tp_cd", length));
			String[] vgmDtTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_dt_tp_cd", length));
			String[] vgmHndlDt = (JSPUtil.getParameter(request, prefix	+ "vgm_hndl_dt", length));
			String[] vgmCustCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_cntc_tp_cd", length));
			String[] vgmCustCntcNm = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_cntc_nm", length));
			String[] vgmCustFaxNo = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_fax_no", length));
			String[] vgmCustEml = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_eml", length));
			String[] vgmCustPhnNo = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_phn_no", length));
			String[] vgmCustAddr = (JSPUtil.getParameter(request, prefix	+ "vgm_cust_addr", length));
			String[] usaEdiCd = (JSPUtil.getParameter(request, prefix	+ "usa_edi_cd", length));
			String[] cntrStwgPsnCtnt = (JSPUtil.getParameter(request, prefix	+ "cntr_stwg_psn_ctnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEDIMovementListVO();
				if (crntSkdVoyNo[i] != null)
					model.setCrntSkdVoyNo(crntSkdVoyNo[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (mtyRepoNo[i] != null)
					model.setMtyRepoNo(mtyRepoNo[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (mvmtEdiMsgSeq[i] != null)
					model.setMvmtEdiMsgSeq(mvmtEdiMsgSeq[i]);
				if (tirNo[i] != null)
					model.setTirNo(tirNo[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (destNmCd[i] != null)
					model.setDestNmCd(destNmCd[i]);
				if (destSteCd[i] != null)
					model.setDestSteCd(destSteCd[i]);
				if (endRowNo[i] != null)
					model.setEndRowNo(endRowNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mvmtEdiRmk[i] != null)
					model.setMvmtEdiRmk(mvmtEdiRmk[i]);
				if (batchFlg[i] != null)
					model.setBatchFlg(batchFlg[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (evntYdCd[i] != null)
					model.setEvntYdCd(evntYdCd[i]);
				if (pDate3[i] != null)
					model.setPDate3(pDate3[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (cntrDmgFlg[i] != null)
					model.setCntrDmgFlg(cntrDmgFlg[i]);
				if (dmgFlgDt[i] != null)
					model.setDmgFlgDt(dmgFlgDt[i]);
				if (dmgUnflgDt[i] != null)
					model.setDmgUnflgDt(dmgUnflgDt[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				if (mvmtEdiTpCd[i] != null)
					model.setMvmtEdiTpCd(mvmtEdiTpCd[i]);
				if (eventReceive[i] != null)
					model.setEventReceive(eventReceive[i]);
				if (bkgBl[i] != null)
					model.setBkgBl(bkgBl[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (mvmtEdiMsgAreaCd[i] != null)
					model.setMvmtEdiMsgAreaCd(mvmtEdiMsgAreaCd[i]);
				if (ediMvmtStsCd[i] != null)
					model.setEdiMvmtStsCd(ediMvmtStsCd[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (mvmtEdiRsltCd[i] != null)
					model.setMvmtEdiRsltCd(mvmtEdiRsltCd[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (userNm[i] != null)
					model.setUserNm(userNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (mvmtEdiMsgYrmondy[i] != null)
					model.setMvmtEdiMsgYrmondy(mvmtEdiMsgYrmondy[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (callSgnLloyd[i] != null)
					model.setCallSgnLloyd(callSgnLloyd[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (tmlNm[i] != null)
					model.setTmlNm(tmlNm[i]);
				if (startRowNo[i] != null)
					model.setStartRowNo(startRowNo[i]);
				if (ediGateIoCd[i] != null)
					model.setEdiGateIoCd(ediGateIoCd[i]);
				if (vvdCombo[i] != null)
					model.setVvdCombo(vvdCombo[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (fltFileRefNo[i] != null)
					model.setFltFileRefNo(fltFileRefNo[i]);
				if (rtvTotal[i] != null)
					model.setRtvTotal(rtvTotal[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rtyKnt[i] != null)
					model.setRtyKnt(rtyKnt[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (mvmtEdiSghtCd[i] != null)
					model.setMvmtEdiSghtCd(mvmtEdiSghtCd[i]);
				if (ediVvdCd[i] != null)
					model.setEdiVvdCd(ediVvdCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (mtyPlnNo[i] != null)
					model.setMtyPlnNo(mtyPlnNo[i]);
				if (crntSkdDirCd[i] != null)
					model.setCrntSkdDirCd(crntSkdDirCd[i]);
				if (cntrStwgNo[i] != null)
					model.setCntrStwgNo(cntrStwgNo[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (ediUiYn[i] != null)
					model.setEdiUiYn(ediUiYn[i]);
				if (ediCrrNo[i] != null)
					model.setEdiCrrNo(ediCrrNo[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (trspDocNo[i] != null)
					model.setTrspDocNo(trspDocNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrFullStsCd[i] != null)
					model.setCntrFullStsCd(cntrFullStsCd[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (ediBkgNo[i] != null)
					model.setEdiBkgNo(ediBkgNo[i]);
				if (crntVslCd[i] != null)
					model.setCrntVslCd(crntVslCd[i]);
				if (vvdValue[i] != null)
					model.setVvdValue(vvdValue[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (ediMtyEqRepoRefNo[i] != null)
					model.setEdiMtyEqRepoRefNo(ediMtyEqRepoRefNo[i]);
				if (nullFlg[i] != null)
					model.setNullFlg(nullFlg[i]);
				if (errWtOk[i] != null)
					model.setErrWtOk(errWtOk[i]);
				if (vgmDocIdNo[i] != null)
					model.setVgmDocIdNo(vgmDocIdNo[i]);
				if (vgmWgt[i] != null)
					model.setVgmWgt(vgmWgt[i]);
				if (vgmEdiWgtUtCd[i] != null)
					model.setVgmEdiWgtUtCd(vgmEdiWgtUtCd[i]);
				if (vgmDocTpCd[i] != null)
					model.setVgmDocTpCd(vgmDocTpCd[i]);
				if (vgmDtTpCd[i] != null)
					model.setVgmDtTpCd(vgmDtTpCd[i]);
				if (vgmHndlDt[i] != null)
					model.setVgmHndlDt(vgmHndlDt[i]);
				if (vgmCustCntcTpCd[i] != null)
					model.setVgmCustCntcTpCd(vgmCustCntcTpCd[i]);
				if (vgmCustCntcNm[i] != null)
					model.setVgmCustCntcNm(vgmCustCntcNm[i]);
				if (vgmCustFaxNo[i] != null)
					model.setVgmCustFaxNo(vgmCustFaxNo[i]);
				if (vgmCustEml[i] != null)
					model.setVgmCustEml(vgmCustEml[i]);
				if (vgmCustPhnNo[i] != null)
					model.setVgmCustPhnNo(vgmCustPhnNo[i]);
				if (vgmCustAddr[i] != null)
					model.setVgmCustAddr(vgmCustAddr[i]);
				if (usaEdiCd[i] != null)
					model.setUsaEdiCd(usaEdiCd[i]);
				if (cntrStwgPsnCtnt[i] != null)
					model.setCntrStwgPsnCtnt(cntrStwgPsnCtnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchEDIMovementListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchEDIMovementListVO[]
	 */
	public SearchEDIMovementListVO[] getSearchEDIMovementListVOs(){
		SearchEDIMovementListVO[] vos = (SearchEDIMovementListVO[])models.toArray(new SearchEDIMovementListVO[models.size()]);
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
		this.crntSkdVoyNo = this.crntSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRepoNo = this.mtyRepoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgSeq = this.mvmtEdiMsgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tirNo = this.tirNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destNmCd = this.destNmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destSteCd = this.destSteCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endRowNo = this.endRowNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRmk = this.mvmtEdiRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchFlg = this.batchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntYdCd = this.evntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate3 = this.pDate3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDmgFlg = this.cntrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt = this.dmgFlgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt = this.dmgUnflgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiTpCd = this.mvmtEdiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventReceive = this.eventReceive .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBl = this.bkgBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd = this.mvmtEdiMsgAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMvmtStsCd = this.ediMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRsltCd = this.mvmtEdiRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgYrmondy = this.mvmtEdiMsgYrmondy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnLloyd = this.callSgnLloyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlNm = this.tmlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startRowNo = this.startRowNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGateIoCd = this.ediGateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCombo = this.vvdCombo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileRefNo = this.fltFileRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtvTotal = this.rtvTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtyKnt = this.rtyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiSghtCd = this.mvmtEdiSghtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediVvdCd = this.ediVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPlnNo = this.mtyPlnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd = this.crntSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStwgNo = this.cntrStwgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediUiYn = this.ediUiYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediCrrNo = this.ediCrrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDocNo = this.trspDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullStsCd = this.cntrFullStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediBkgNo = this.ediBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd = this.crntVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdValue = this.vvdValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMtyEqRepoRefNo = this.ediMtyEqRepoRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nullFlg = this.nullFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errWtOk = this.errWtOk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocIdNo = this.vgmDocIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgt = this.vgmWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmEdiWgtUtCd = this.vgmEdiWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDocTpCd = this.vgmDocTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmDtTpCd = this.vgmDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmHndlDt = this.vgmHndlDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustCntcTpCd = this.vgmCustCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustCntcNm = this.vgmCustCntcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustFaxNo = this.vgmCustFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustEml = this.vgmCustEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustPhnNo = this.vgmCustPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmCustAddr = this.vgmCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaEdiCd = this.usaEdiCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStwgPsnCtnt = this.cntrStwgPsnCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
