/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : SearchEDIMovementListVO.java
 * @FileTitle : SearchEDIMovementListVO
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2016.08.01
 * @LastModifier : 
 * @LastVersion : 1.0
 * 2016.08.01 김상현 1.0 Creation
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo;

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
 * Table Value Object.
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
	private String endRowNo = null;
	/* Column Info */
	private String cntrStwgNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String errMsg = null;
	/* Column Info */
	private String ediGateIoCd = null;
	/* Column Info */
	private String vgmSigCtnt = null;
	/* Column Info */
	private String pkupNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String mvmtEdiTpCd = null;
	/* Column Info */
	private String cntrFullStsCd = null;
	/* Column Info */
	private String evntYdCd = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String crntVslCd = null;
	/* Column Info */
	private String wblNo = null;
	/* Column Info */
	private String vgmVrfyDt = null;
	/* Column Info */
	private String destYdCd = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String checkDigit = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vgmMzdTpCd = null;
	/* Column Info */
	private String tmlNm = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String vgmRefNo = null;
	/* Column Info */
	private String mvmtEdiMsgSeq = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String mvmtTrspModCd = null;
	/* Column Info */
	private String mvmtEdiMsgYrmondy = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String mvmtEdiMsgTpId = null;
	/* Column Info */
	private String vgmWgtPtyCtnt = null;
	/* Column Info */
	private String vvdCombo = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String pDate3 = null;
	/* Column Info */
	private String bkgBl = null;
	/* Column Info */
	private String userNm = null;
	/* Column Info */
	private String batchFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mvmtEdiRmk = null;
	/* Column Info */
	private String crntSkdVoyNo = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String eventReceive = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String callSgnLloyd = null;
	/* Column Info */
	private String ediBkgNo = null;
	/* Column Info */
	private String ediMvmtStsCd = null;
	/* Column Info */
	private String vvdValue = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String rtyKnt = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String crntSkdDirCd = null;
	/* Column Info */
	private String mvmtEdiSghtCd = null;
	/* Column Info */
	private String vgm = null;
	/* Column Info */
	private String creLoclDt = null;
	/* Column Info */
	private String vgmWgtUtCd = null;
	/* Column Info */
	private String cnmvRmk = null;
	/* Column Info */
	private String pCntrno = null;
	/* Column Info */
	private String vgmVrfyOrdCtnt = null;
	/* Column Info */
	private String vgmWgtQty = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String iPage = null;
	/* Column Info */
	private String mvmtEdiMsgAreaCd = null;
	/* Column Info */
	private String rtvTotal = null;
	/* Column Info */
	private String chssNo = null;
	/* Column Info */
	private String mvmtEdiRsltCd = null;
	/* Column Info */
	private String ediUiYn = null;
	/* Column Info */
	private String startRowNo = null;
	/* Column Info */
	private String mgstNo = null;
	/* Column Info */
	private String cntrNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchEDIMovementListVO() {}

	public SearchEDIMovementListVO(String ibflag, String pagerows, String endRowNo, String cntrStwgNo, String blNo, String bkgNo, String errMsg, String ediGateIoCd, String pkupNo, String vvdCd, String mvmtEdiTpCd, String cntrFullStsCd, String evntYdCd, String pYard1, String crntVslCd, String wblNo, String destYdCd, String pYard2, String cntrSealNo, String checkDigit, String tmlNm, String rccCd, String mvmtEdiMsgSeq, String evntDt, String mvmtTrspModCd, String mvmtEdiMsgYrmondy, String vndrSeq, String mvmtEdiMsgTpId, String vvdCombo, String pDate1, String cntrTpszCd, String pDate2, String pDate3, String bkgBl, String userNm, String batchFlg, String mvmtEdiRmk, String crntSkdVoyNo, String callSgnNo, String eventReceive, String polCd, String callSgnLloyd, String ediBkgNo, String ediMvmtStsCd, String vvdValue, String podCd, String rtyKnt, String lloydNo, String crntSkdDirCd, String mvmtEdiSghtCd, String vgm, String creLoclDt, String cnmvRmk, String pCntrno, String userId, String lccCd, String iPage, String mvmtEdiMsgAreaCd, String rtvTotal, String chssNo, String mvmtEdiRsltCd, String ediUiYn, String startRowNo, String mgstNo, String cntrNo, String vgmMzdTpCd, String vgmWgtUtCd, String vgmWgtQty, String vgmVrfyDt, String vgmSigCtnt, String vgmRefNo, String vgmWgtPtyCtnt, String vgmVrfyOrdCtnt) {
		this.endRowNo = endRowNo;
		this.cntrStwgNo = cntrStwgNo;
		this.blNo = blNo;
		this.bkgNo = bkgNo;
		this.errMsg = errMsg;
		this.ediGateIoCd = ediGateIoCd;
		this.vgmSigCtnt = vgmSigCtnt;
		this.pkupNo = pkupNo;
		this.vvdCd = vvdCd;
		this.mvmtEdiTpCd = mvmtEdiTpCd;
		this.cntrFullStsCd = cntrFullStsCd;
		this.evntYdCd = evntYdCd;
		this.pYard1 = pYard1;
		this.crntVslCd = crntVslCd;
		this.wblNo = wblNo;
		this.vgmVrfyDt = vgmVrfyDt;
		this.destYdCd = destYdCd;
		this.pYard2 = pYard2;
		this.cntrSealNo = cntrSealNo;
		this.checkDigit = checkDigit;
		this.pagerows = pagerows;
		this.vgmMzdTpCd = vgmMzdTpCd;
		this.tmlNm = tmlNm;
		this.rccCd = rccCd;
		this.vgmRefNo = vgmRefNo;
		this.mvmtEdiMsgSeq = mvmtEdiMsgSeq;
		this.evntDt = evntDt;
		this.mvmtTrspModCd = mvmtTrspModCd;
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
		this.vndrSeq = vndrSeq;
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
		this.vgmWgtPtyCtnt = vgmWgtPtyCtnt;
		this.vvdCombo = vvdCombo;
		this.pDate1 = pDate1;
		this.cntrTpszCd = cntrTpszCd;
		this.pDate2 = pDate2;
		this.pDate3 = pDate3;
		this.bkgBl = bkgBl;
		this.userNm = userNm;
		this.batchFlg = batchFlg;
		this.ibflag = ibflag;
		this.mvmtEdiRmk = mvmtEdiRmk;
		this.crntSkdVoyNo = crntSkdVoyNo;
		this.callSgnNo = callSgnNo;
		this.eventReceive = eventReceive;
		this.polCd = polCd;
		this.callSgnLloyd = callSgnLloyd;
		this.ediBkgNo = ediBkgNo;
		this.ediMvmtStsCd = ediMvmtStsCd;
		this.vvdValue = vvdValue;
		this.podCd = podCd;
		this.rtyKnt = rtyKnt;
		this.lloydNo = lloydNo;
		this.crntSkdDirCd = crntSkdDirCd;
		this.mvmtEdiSghtCd = mvmtEdiSghtCd;
		this.vgm = vgm;
		this.creLoclDt = creLoclDt;
		this.vgmWgtUtCd = vgmWgtUtCd;
		this.cnmvRmk = cnmvRmk;
		this.pCntrno = pCntrno;
		this.vgmVrfyOrdCtnt = vgmVrfyOrdCtnt;
		this.vgmWgtQty = vgmWgtQty;
		this.userId = userId;
		this.lccCd = lccCd;
		this.iPage = iPage;
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
		this.rtvTotal = rtvTotal;
		this.chssNo = chssNo;
		this.mvmtEdiRsltCd = mvmtEdiRsltCd;
		this.ediUiYn = ediUiYn;
		this.startRowNo = startRowNo;
		this.mgstNo = mgstNo;
		this.cntrNo = cntrNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("end_row_no", getEndRowNo());
		this.hashColumns.put("cntr_stwg_no", getCntrStwgNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("err_msg", getErrMsg());
		this.hashColumns.put("edi_gate_io_cd", getEdiGateIoCd());
		this.hashColumns.put("vgm_sig_ctnt", getVgmSigCtnt());
		this.hashColumns.put("pkup_no", getPkupNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("mvmt_edi_tp_cd", getMvmtEdiTpCd());
		this.hashColumns.put("cntr_full_sts_cd", getCntrFullStsCd());
		this.hashColumns.put("evnt_yd_cd", getEvntYdCd());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("crnt_vsl_cd", getCrntVslCd());
		this.hashColumns.put("wbl_no", getWblNo());
		this.hashColumns.put("vgm_vrfy_dt", getVgmVrfyDt());
		this.hashColumns.put("dest_yd_cd", getDestYdCd());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("check_digit", getCheckDigit());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vgm_mzd_tp_cd", getVgmMzdTpCd());
		this.hashColumns.put("tml_nm", getTmlNm());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("vgm_ref_no", getVgmRefNo());
		this.hashColumns.put("mvmt_edi_msg_seq", getMvmtEdiMsgSeq());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("mvmt_trsp_mod_cd", getMvmtTrspModCd());
		this.hashColumns.put("mvmt_edi_msg_yrmondy", getMvmtEdiMsgYrmondy());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("mvmt_edi_msg_tp_id", getMvmtEdiMsgTpId());
		this.hashColumns.put("vgm_wgt_pty_ctnt", getVgmWgtPtyCtnt());
		this.hashColumns.put("vvd_combo", getVvdCombo());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("p_date3", getPDate3());
		this.hashColumns.put("bkg_bl", getBkgBl());
		this.hashColumns.put("user_nm", getUserNm());
		this.hashColumns.put("batch_flg", getBatchFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("mvmt_edi_rmk", getMvmtEdiRmk());
		this.hashColumns.put("crnt_skd_voy_no", getCrntSkdVoyNo());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("event_receive", getEventReceive());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("call_sgn_lloyd", getCallSgnLloyd());
		this.hashColumns.put("edi_bkg_no", getEdiBkgNo());
		this.hashColumns.put("edi_mvmt_sts_cd", getEdiMvmtStsCd());
		this.hashColumns.put("vvd_value", getVvdValue());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("rty_knt", getRtyKnt());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("crnt_skd_dir_cd", getCrntSkdDirCd());
		this.hashColumns.put("mvmt_edi_sght_cd", getMvmtEdiSghtCd());
		this.hashColumns.put("vgm", getVgm());
		this.hashColumns.put("cre_locl_dt", getCreLoclDt());
		this.hashColumns.put("vgm_wgt_ut_cd", getVgmWgtUtCd());
		this.hashColumns.put("cnmv_rmk", getCnmvRmk());
		this.hashColumns.put("p_cntrno", getPCntrno());
		this.hashColumns.put("vgm_vrfy_ord_ctnt", getVgmVrfyOrdCtnt());
		this.hashColumns.put("vgm_wgt_qty", getVgmWgtQty());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("i_page", getIPage());
		this.hashColumns.put("mvmt_edi_msg_area_cd", getMvmtEdiMsgAreaCd());
		this.hashColumns.put("rtv_total", getRtvTotal());
		this.hashColumns.put("chss_no", getChssNo());
		this.hashColumns.put("mvmt_edi_rslt_cd", getMvmtEdiRsltCd());
		this.hashColumns.put("edi_ui_yn", getEdiUiYn());
		this.hashColumns.put("start_row_no", getStartRowNo());
		this.hashColumns.put("mgst_no", getMgstNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("end_row_no", "endRowNo");
		this.hashFields.put("cntr_stwg_no", "cntrStwgNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("err_msg", "errMsg");
		this.hashFields.put("edi_gate_io_cd", "ediGateIoCd");
		this.hashFields.put("vgm_sig_ctnt", "vgmSigCtnt");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("mvmt_edi_tp_cd", "mvmtEdiTpCd");
		this.hashFields.put("cntr_full_sts_cd", "cntrFullStsCd");
		this.hashFields.put("evnt_yd_cd", "evntYdCd");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("crnt_vsl_cd", "crntVslCd");
		this.hashFields.put("wbl_no", "wblNo");
		this.hashFields.put("vgm_vrfy_dt", "vgmVrfyDt");
		this.hashFields.put("dest_yd_cd", "destYdCd");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vgm_mzd_tp_cd", "vgmMzdTpCd");
		this.hashFields.put("tml_nm", "tmlNm");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("vgm_ref_no", "vgmRefNo");
		this.hashFields.put("mvmt_edi_msg_seq", "mvmtEdiMsgSeq");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("mvmt_trsp_mod_cd", "mvmtTrspModCd");
		this.hashFields.put("mvmt_edi_msg_yrmondy", "mvmtEdiMsgYrmondy");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("mvmt_edi_msg_tp_id", "mvmtEdiMsgTpId");
		this.hashFields.put("vgm_wgt_pty_ctnt", "vgmWgtPtyCtnt");
		this.hashFields.put("vvd_combo", "vvdCombo");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("p_date3", "pDate3");
		this.hashFields.put("bkg_bl", "bkgBl");
		this.hashFields.put("user_nm", "userNm");
		this.hashFields.put("batch_flg", "batchFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("mvmt_edi_rmk", "mvmtEdiRmk");
		this.hashFields.put("crnt_skd_voy_no", "crntSkdVoyNo");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("event_receive", "eventReceive");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("call_sgn_lloyd", "callSgnLloyd");
		this.hashFields.put("edi_bkg_no", "ediBkgNo");
		this.hashFields.put("edi_mvmt_sts_cd", "ediMvmtStsCd");
		this.hashFields.put("vvd_value", "vvdValue");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("rty_knt", "rtyKnt");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("crnt_skd_dir_cd", "crntSkdDirCd");
		this.hashFields.put("mvmt_edi_sght_cd", "mvmtEdiSghtCd");
		this.hashFields.put("vgm", "vgm");
		this.hashFields.put("cre_locl_dt", "creLoclDt");
		this.hashFields.put("vgm_wgt_ut_cd", "vgmWgtUtCd");
		this.hashFields.put("cnmv_rmk", "cnmvRmk");
		this.hashFields.put("p_cntrno", "pCntrno");
		this.hashFields.put("vgm_vrfy_ord_ctnt", "vgmVrfyOrdCtnt");
		this.hashFields.put("vgm_wgt_qty", "vgmWgtQty");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("i_page", "iPage");
		this.hashFields.put("mvmt_edi_msg_area_cd", "mvmtEdiMsgAreaCd");
		this.hashFields.put("rtv_total", "rtvTotal");
		this.hashFields.put("chss_no", "chssNo");
		this.hashFields.put("mvmt_edi_rslt_cd", "mvmtEdiRsltCd");
		this.hashFields.put("edi_ui_yn", "ediUiYn");
		this.hashFields.put("start_row_no", "startRowNo");
		this.hashFields.put("mgst_no", "mgstNo");
		this.hashFields.put("cntr_no", "cntrNo");
		return this.hashFields;
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
	 * @return cntrStwgNo
	 */
	public String getCntrStwgNo() {
		return this.cntrStwgNo;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return errMsg
	 */
	public String getErrMsg() {
		return this.errMsg;
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
	 * @return vgmSigCtnt
	 */
	public String getVgmSigCtnt() {
		return this.vgmSigCtnt;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
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
	 * @return cntrFullStsCd
	 */
	public String getCntrFullStsCd() {
		return this.cntrFullStsCd;
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
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
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
	 * @return wblNo
	 */
	public String getWblNo() {
		return this.wblNo;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfyDt
	 */
	public String getVgmVrfyDt() {
		return this.vgmVrfyDt;
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
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
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
	 * @return checkDigit
	 */
	public String getCheckDigit() {
		return this.checkDigit;
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
	 * @return vgmMzdTpCd
	 */
	public String getVgmMzdTpCd() {
		return this.vgmMzdTpCd;
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
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}
	
	/**
	 * Column Info
	 * @return vgmRefNo
	 */
	public String getVgmRefNo() {
		return this.vgmRefNo;
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
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
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
	 * @return mvmtEdiMsgYrmondy
	 */
	public String getMvmtEdiMsgYrmondy() {
		return this.mvmtEdiMsgYrmondy;
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
	 * @return mvmtEdiMsgTpId
	 */
	public String getMvmtEdiMsgTpId() {
		return this.mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtPtyCtnt
	 */
	public String getVgmWgtPtyCtnt() {
		return this.vgmWgtPtyCtnt;
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
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
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
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
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
	 * @return bkgBl
	 */
	public String getBkgBl() {
		return this.bkgBl;
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
	 * @return batchFlg
	 */
	public String getBatchFlg() {
		return this.batchFlg;
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
	 * @return mvmtEdiRmk
	 */
	public String getMvmtEdiRmk() {
		return this.mvmtEdiRmk;
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
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return ediBkgNo
	 */
	public String getEdiBkgNo() {
		return this.ediBkgNo;
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
	 * @return vvdValue
	 */
	public String getVvdValue() {
		return this.vvdValue;
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
	 * @return rtyKnt
	 */
	public String getRtyKnt() {
		return this.rtyKnt;
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
	 * @return crntSkdDirCd
	 */
	public String getCrntSkdDirCd() {
		return this.crntSkdDirCd;
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
	 * @return vgm
	 */
	public String getVgm() {
		return this.vgm;
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
	 * @return vgmWgtUtCd
	 */
	public String getVgmWgtUtCd() {
		return this.vgmWgtUtCd;
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
	 * @return pCntrno
	 */
	public String getPCntrno() {
		return this.pCntrno;
	}
	
	/**
	 * Column Info
	 * @return vgmVrfyOrdCtnt
	 */
	public String getVgmVrfyOrdCtnt() {
		return this.vgmVrfyOrdCtnt;
	}
	
	/**
	 * Column Info
	 * @return vgmWgtQty
	 */
	public String getVgmWgtQty() {
		return this.vgmWgtQty;
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
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
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
	 * @return mvmtEdiMsgAreaCd
	 */
	public String getMvmtEdiMsgAreaCd() {
		return this.mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @return rtvTotal
	 */
	public String getRtvTotal() {
		return this.rtvTotal;
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
	 * @return mvmtEdiRsltCd
	 */
	public String getMvmtEdiRsltCd() {
		return this.mvmtEdiRsltCd;
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
	 * @return startRowNo
	 */
	public String getStartRowNo() {
		return this.startRowNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
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
	 * @param cntrStwgNo
	 */
	public void setCntrStwgNo(String cntrStwgNo) {
		this.cntrStwgNo = cntrStwgNo;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param errMsg
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
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
	 * @param vgmSigCtnt
	 */
	public void setVgmSigCtnt(String vgmSigCtnt) {
		this.vgmSigCtnt = vgmSigCtnt;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
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
	 * @param cntrFullStsCd
	 */
	public void setCntrFullStsCd(String cntrFullStsCd) {
		this.cntrFullStsCd = cntrFullStsCd;
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
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
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
	 * @param wblNo
	 */
	public void setWblNo(String wblNo) {
		this.wblNo = wblNo;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfyDt
	 */
	public void setVgmVrfyDt(String vgmVrfyDt) {
		this.vgmVrfyDt = vgmVrfyDt;
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
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
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
	 * @param checkDigit
	 */
	public void setCheckDigit(String checkDigit) {
		this.checkDigit = checkDigit;
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
	 * @param vgmMzdTpCd
	 */
	public void setVgmMzdTpCd(String vgmMzdTpCd) {
		this.vgmMzdTpCd = vgmMzdTpCd;
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
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}
	
	/**
	 * Column Info
	 * @param vgmRefNo
	 */
	public void setVgmRefNo(String vgmRefNo) {
		this.vgmRefNo = vgmRefNo;
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
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
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
	 * @param mvmtEdiMsgYrmondy
	 */
	public void setMvmtEdiMsgYrmondy(String mvmtEdiMsgYrmondy) {
		this.mvmtEdiMsgYrmondy = mvmtEdiMsgYrmondy;
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
	 * @param mvmtEdiMsgTpId
	 */
	public void setMvmtEdiMsgTpId(String mvmtEdiMsgTpId) {
		this.mvmtEdiMsgTpId = mvmtEdiMsgTpId;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtPtyCtnt
	 */
	public void setVgmWgtPtyCtnt(String vgmWgtPtyCtnt) {
		this.vgmWgtPtyCtnt = vgmWgtPtyCtnt;
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
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
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
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
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
	 * @param bkgBl
	 */
	public void setBkgBl(String bkgBl) {
		this.bkgBl = bkgBl;
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
	 * @param batchFlg
	 */
	public void setBatchFlg(String batchFlg) {
		this.batchFlg = batchFlg;
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
	 * @param mvmtEdiRmk
	 */
	public void setMvmtEdiRmk(String mvmtEdiRmk) {
		this.mvmtEdiRmk = mvmtEdiRmk;
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
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param ediBkgNo
	 */
	public void setEdiBkgNo(String ediBkgNo) {
		this.ediBkgNo = ediBkgNo;
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
	 * @param vvdValue
	 */
	public void setVvdValue(String vvdValue) {
		this.vvdValue = vvdValue;
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
	 * @param rtyKnt
	 */
	public void setRtyKnt(String rtyKnt) {
		this.rtyKnt = rtyKnt;
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
	 * @param crntSkdDirCd
	 */
	public void setCrntSkdDirCd(String crntSkdDirCd) {
		this.crntSkdDirCd = crntSkdDirCd;
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
	 * @param vgm
	 */
	public void setVgm(String vgm) {
		this.vgm = vgm;
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
	 * @param vgmWgtUtCd
	 */
	public void setVgmWgtUtCd(String vgmWgtUtCd) {
		this.vgmWgtUtCd = vgmWgtUtCd;
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
	 * @param pCntrno
	 */
	public void setPCntrno(String pCntrno) {
		this.pCntrno = pCntrno;
	}
	
	/**
	 * Column Info
	 * @param vgmVrfyOrdCtnt
	 */
	public void setVgmVrfyOrdCtnt(String vgmVrfyOrdCtnt) {
		this.vgmVrfyOrdCtnt = vgmVrfyOrdCtnt;
	}
	
	/**
	 * Column Info
	 * @param vgmWgtQty
	 */
	public void setVgmWgtQty(String vgmWgtQty) {
		this.vgmWgtQty = vgmWgtQty;
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
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
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
	 * @param mvmtEdiMsgAreaCd
	 */
	public void setMvmtEdiMsgAreaCd(String mvmtEdiMsgAreaCd) {
		this.mvmtEdiMsgAreaCd = mvmtEdiMsgAreaCd;
	}
	
	/**
	 * Column Info
	 * @param rtvTotal
	 */
	public void setRtvTotal(String rtvTotal) {
		this.rtvTotal = rtvTotal;
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
	 * @param mvmtEdiRsltCd
	 */
	public void setMvmtEdiRsltCd(String mvmtEdiRsltCd) {
		this.mvmtEdiRsltCd = mvmtEdiRsltCd;
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
	 * @param startRowNo
	 */
	public void setStartRowNo(String startRowNo) {
		this.startRowNo = startRowNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
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
		setEndRowNo(JSPUtil.getParameter(request, prefix + "end_row_no", ""));
		setCntrStwgNo(JSPUtil.getParameter(request, prefix + "cntr_stwg_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setErrMsg(JSPUtil.getParameter(request, prefix + "err_msg", ""));
		setEdiGateIoCd(JSPUtil.getParameter(request, prefix + "edi_gate_io_cd", ""));
		setVgmSigCtnt(JSPUtil.getParameter(request, prefix + "vgm_sig_ctnt", ""));
		setPkupNo(JSPUtil.getParameter(request, prefix + "pkup_no", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setMvmtEdiTpCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_tp_cd", ""));
		setCntrFullStsCd(JSPUtil.getParameter(request, prefix + "cntr_full_sts_cd", ""));
		setEvntYdCd(JSPUtil.getParameter(request, prefix + "evnt_yd_cd", ""));
		setPYard1(JSPUtil.getParameter(request, prefix + "p_yard1", ""));
		setCrntVslCd(JSPUtil.getParameter(request, prefix + "crnt_vsl_cd", ""));
		setWblNo(JSPUtil.getParameter(request, prefix + "wbl_no", ""));
		setVgmVrfyDt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_dt", ""));
		setDestYdCd(JSPUtil.getParameter(request, prefix + "dest_yd_cd", ""));
		setPYard2(JSPUtil.getParameter(request, prefix + "p_yard2", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setCheckDigit(JSPUtil.getParameter(request, prefix + "check_digit", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVgmMzdTpCd(JSPUtil.getParameter(request, prefix + "vgm_mzd_tp_cd", ""));
		setTmlNm(JSPUtil.getParameter(request, prefix + "tml_nm", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setVgmRefNo(JSPUtil.getParameter(request, prefix + "vgm_ref_no", ""));
		setMvmtEdiMsgSeq(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_seq", ""));
		setEvntDt(JSPUtil.getParameter(request, prefix + "evnt_dt", ""));
		setMvmtTrspModCd(JSPUtil.getParameter(request, prefix + "mvmt_trsp_mod_cd", ""));
		setMvmtEdiMsgYrmondy(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_yrmondy", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setMvmtEdiMsgTpId(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_tp_id", ""));
		setVgmWgtPtyCtnt(JSPUtil.getParameter(request, prefix + "vgm_wgt_pty_ctnt", ""));
		setVvdCombo(JSPUtil.getParameter(request, prefix + "vvd_combo", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setPDate3(JSPUtil.getParameter(request, prefix + "p_date3", ""));
		setBkgBl(JSPUtil.getParameter(request, prefix + "bkg_bl", ""));
		setUserNm(JSPUtil.getParameter(request, prefix + "user_nm", ""));
		setBatchFlg(JSPUtil.getParameter(request, prefix + "batch_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMvmtEdiRmk(JSPUtil.getParameter(request, prefix + "mvmt_edi_rmk", ""));
		setCrntSkdVoyNo(JSPUtil.getParameter(request, prefix + "crnt_skd_voy_no", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setEventReceive(JSPUtil.getParameter(request, prefix + "event_receive", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCallSgnLloyd(JSPUtil.getParameter(request, prefix + "call_sgn_lloyd", ""));
		setEdiBkgNo(JSPUtil.getParameter(request, prefix + "edi_bkg_no", ""));
		setEdiMvmtStsCd(JSPUtil.getParameter(request, prefix + "edi_mvmt_sts_cd", ""));
		setVvdValue(JSPUtil.getParameter(request, prefix + "vvd_value", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setRtyKnt(JSPUtil.getParameter(request, prefix + "rty_knt", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setCrntSkdDirCd(JSPUtil.getParameter(request, prefix + "crnt_skd_dir_cd", ""));
		setMvmtEdiSghtCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_sght_cd", ""));
		setVgm(JSPUtil.getParameter(request, prefix + "vgm", ""));
		setCreLoclDt(JSPUtil.getParameter(request, prefix + "cre_locl_dt", ""));
		setVgmWgtUtCd(JSPUtil.getParameter(request, prefix + "vgm_wgt_ut_cd", ""));
		setCnmvRmk(JSPUtil.getParameter(request, prefix + "cnmv_rmk", ""));
		setPCntrno(JSPUtil.getParameter(request, prefix + "p_cntrno", ""));
		setVgmVrfyOrdCtnt(JSPUtil.getParameter(request, prefix + "vgm_vrfy_ord_ctnt", ""));
		setVgmWgtQty(JSPUtil.getParameter(request, prefix + "vgm_wgt_qty", ""));
		setUserId(JSPUtil.getParameter(request, prefix + "user_id", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setIPage(JSPUtil.getParameter(request, prefix + "i_page", ""));
		setMvmtEdiMsgAreaCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_msg_area_cd", ""));
		setRtvTotal(JSPUtil.getParameter(request, prefix + "rtv_total", ""));
		setChssNo(JSPUtil.getParameter(request, prefix + "chss_no", ""));
		setMvmtEdiRsltCd(JSPUtil.getParameter(request, prefix + "mvmt_edi_rslt_cd", ""));
		setEdiUiYn(JSPUtil.getParameter(request, prefix + "edi_ui_yn", ""));
		setStartRowNo(JSPUtil.getParameter(request, prefix + "start_row_no", ""));
		setMgstNo(JSPUtil.getParameter(request, prefix + "mgst_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
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
			String[] endRowNo = (JSPUtil.getParameter(request, prefix	+ "end_row_no", length));
			String[] cntrStwgNo = (JSPUtil.getParameter(request, prefix	+ "cntr_stwg_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] errMsg = (JSPUtil.getParameter(request, prefix	+ "err_msg", length));
			String[] ediGateIoCd = (JSPUtil.getParameter(request, prefix	+ "edi_gate_io_cd", length));
			String[] vgmSigCtnt = (JSPUtil.getParameter(request, prefix	+ "vgm_sig_ctnt", length));
			String[] pkupNo = (JSPUtil.getParameter(request, prefix	+ "pkup_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] mvmtEdiTpCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_tp_cd", length));
			String[] cntrFullStsCd = (JSPUtil.getParameter(request, prefix	+ "cntr_full_sts_cd", length));
			String[] evntYdCd = (JSPUtil.getParameter(request, prefix	+ "evnt_yd_cd", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] crntVslCd = (JSPUtil.getParameter(request, prefix	+ "crnt_vsl_cd", length));
			String[] wblNo = (JSPUtil.getParameter(request, prefix	+ "wbl_no", length));
			String[] vgmVrfyDt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_dt", length));
			String[] destYdCd = (JSPUtil.getParameter(request, prefix	+ "dest_yd_cd", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] checkDigit = (JSPUtil.getParameter(request, prefix	+ "check_digit", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vgmMzdTpCd = (JSPUtil.getParameter(request, prefix	+ "vgm_mzd_tp_cd", length));
			String[] tmlNm = (JSPUtil.getParameter(request, prefix	+ "tml_nm", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] vgmRefNo = (JSPUtil.getParameter(request, prefix	+ "vgm_ref_no", length));
			String[] mvmtEdiMsgSeq = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_seq", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] mvmtTrspModCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_trsp_mod_cd", length));
			String[] mvmtEdiMsgYrmondy = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_yrmondy", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] mvmtEdiMsgTpId = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_tp_id", length));
			String[] vgmWgtPtyCtnt = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_pty_ctnt", length));
			String[] vvdCombo = (JSPUtil.getParameter(request, prefix	+ "vvd_combo", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] pDate3 = (JSPUtil.getParameter(request, prefix	+ "p_date3", length));
			String[] bkgBl = (JSPUtil.getParameter(request, prefix	+ "bkg_bl", length));
			String[] userNm = (JSPUtil.getParameter(request, prefix	+ "user_nm", length));
			String[] batchFlg = (JSPUtil.getParameter(request, prefix	+ "batch_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mvmtEdiRmk = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_rmk", length));
			String[] crntSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_voy_no", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] eventReceive = (JSPUtil.getParameter(request, prefix	+ "event_receive", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] callSgnLloyd = (JSPUtil.getParameter(request, prefix	+ "call_sgn_lloyd", length));
			String[] ediBkgNo = (JSPUtil.getParameter(request, prefix	+ "edi_bkg_no", length));
			String[] ediMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "edi_mvmt_sts_cd", length));
			String[] vvdValue = (JSPUtil.getParameter(request, prefix	+ "vvd_value", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] rtyKnt = (JSPUtil.getParameter(request, prefix	+ "rty_knt", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] crntSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "crnt_skd_dir_cd", length));
			String[] mvmtEdiSghtCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_sght_cd", length));
			String[] vgm = (JSPUtil.getParameter(request, prefix	+ "vgm", length));
			String[] creLoclDt = (JSPUtil.getParameter(request, prefix	+ "cre_locl_dt", length));
			String[] vgmWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_ut_cd", length));
			String[] cnmvRmk = (JSPUtil.getParameter(request, prefix	+ "cnmv_rmk", length));
			String[] pCntrno = (JSPUtil.getParameter(request, prefix	+ "p_cntrno", length));
			String[] vgmVrfyOrdCtnt = (JSPUtil.getParameter(request, prefix	+ "vgm_vrfy_ord_ctnt", length));
			String[] vgmWgtQty = (JSPUtil.getParameter(request, prefix	+ "vgm_wgt_qty", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] iPage = (JSPUtil.getParameter(request, prefix	+ "i_page", length));
			String[] mvmtEdiMsgAreaCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_msg_area_cd", length));
			String[] rtvTotal = (JSPUtil.getParameter(request, prefix	+ "rtv_total", length));
			String[] chssNo = (JSPUtil.getParameter(request, prefix	+ "chss_no", length));
			String[] mvmtEdiRsltCd = (JSPUtil.getParameter(request, prefix	+ "mvmt_edi_rslt_cd", length));
			String[] ediUiYn = (JSPUtil.getParameter(request, prefix	+ "edi_ui_yn", length));
			String[] startRowNo = (JSPUtil.getParameter(request, prefix	+ "start_row_no", length));
			String[] mgstNo = (JSPUtil.getParameter(request, prefix	+ "mgst_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchEDIMovementListVO();
				if (endRowNo[i] != null)
					model.setEndRowNo(endRowNo[i]);
				if (cntrStwgNo[i] != null)
					model.setCntrStwgNo(cntrStwgNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (errMsg[i] != null)
					model.setErrMsg(errMsg[i]);
				if (ediGateIoCd[i] != null)
					model.setEdiGateIoCd(ediGateIoCd[i]);
				if (vgmSigCtnt[i] != null)
					model.setVgmSigCtnt(vgmSigCtnt[i]);
				if (pkupNo[i] != null)
					model.setPkupNo(pkupNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (mvmtEdiTpCd[i] != null)
					model.setMvmtEdiTpCd(mvmtEdiTpCd[i]);
				if (cntrFullStsCd[i] != null)
					model.setCntrFullStsCd(cntrFullStsCd[i]);
				if (evntYdCd[i] != null)
					model.setEvntYdCd(evntYdCd[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (crntVslCd[i] != null)
					model.setCrntVslCd(crntVslCd[i]);
				if (wblNo[i] != null)
					model.setWblNo(wblNo[i]);
				if (vgmVrfyDt[i] != null)
					model.setVgmVrfyDt(vgmVrfyDt[i]);
				if (destYdCd[i] != null)
					model.setDestYdCd(destYdCd[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (checkDigit[i] != null)
					model.setCheckDigit(checkDigit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vgmMzdTpCd[i] != null)
					model.setVgmMzdTpCd(vgmMzdTpCd[i]);
				if (tmlNm[i] != null)
					model.setTmlNm(tmlNm[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (vgmRefNo[i] != null)
					model.setVgmRefNo(vgmRefNo[i]);
				if (mvmtEdiMsgSeq[i] != null)
					model.setMvmtEdiMsgSeq(mvmtEdiMsgSeq[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (mvmtTrspModCd[i] != null)
					model.setMvmtTrspModCd(mvmtTrspModCd[i]);
				if (mvmtEdiMsgYrmondy[i] != null)
					model.setMvmtEdiMsgYrmondy(mvmtEdiMsgYrmondy[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (mvmtEdiMsgTpId[i] != null)
					model.setMvmtEdiMsgTpId(mvmtEdiMsgTpId[i]);
				if (vgmWgtPtyCtnt[i] != null)
					model.setVgmWgtPtyCtnt(vgmWgtPtyCtnt[i]);
				if (vvdCombo[i] != null)
					model.setVvdCombo(vvdCombo[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (pDate3[i] != null)
					model.setPDate3(pDate3[i]);
				if (bkgBl[i] != null)
					model.setBkgBl(bkgBl[i]);
				if (userNm[i] != null)
					model.setUserNm(userNm[i]);
				if (batchFlg[i] != null)
					model.setBatchFlg(batchFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mvmtEdiRmk[i] != null)
					model.setMvmtEdiRmk(mvmtEdiRmk[i]);
				if (crntSkdVoyNo[i] != null)
					model.setCrntSkdVoyNo(crntSkdVoyNo[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (eventReceive[i] != null)
					model.setEventReceive(eventReceive[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (callSgnLloyd[i] != null)
					model.setCallSgnLloyd(callSgnLloyd[i]);
				if (ediBkgNo[i] != null)
					model.setEdiBkgNo(ediBkgNo[i]);
				if (ediMvmtStsCd[i] != null)
					model.setEdiMvmtStsCd(ediMvmtStsCd[i]);
				if (vvdValue[i] != null)
					model.setVvdValue(vvdValue[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (rtyKnt[i] != null)
					model.setRtyKnt(rtyKnt[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (crntSkdDirCd[i] != null)
					model.setCrntSkdDirCd(crntSkdDirCd[i]);
				if (mvmtEdiSghtCd[i] != null)
					model.setMvmtEdiSghtCd(mvmtEdiSghtCd[i]);
				if (vgm[i] != null)
					model.setVgm(vgm[i]);
				if (creLoclDt[i] != null)
					model.setCreLoclDt(creLoclDt[i]);
				if (vgmWgtUtCd[i] != null)
					model.setVgmWgtUtCd(vgmWgtUtCd[i]);
				if (cnmvRmk[i] != null)
					model.setCnmvRmk(cnmvRmk[i]);
				if (pCntrno[i] != null)
					model.setPCntrno(pCntrno[i]);
				if (vgmVrfyOrdCtnt[i] != null)
					model.setVgmVrfyOrdCtnt(vgmVrfyOrdCtnt[i]);
				if (vgmWgtQty[i] != null)
					model.setVgmWgtQty(vgmWgtQty[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (iPage[i] != null)
					model.setIPage(iPage[i]);
				if (mvmtEdiMsgAreaCd[i] != null)
					model.setMvmtEdiMsgAreaCd(mvmtEdiMsgAreaCd[i]);
				if (rtvTotal[i] != null)
					model.setRtvTotal(rtvTotal[i]);
				if (chssNo[i] != null)
					model.setChssNo(chssNo[i]);
				if (mvmtEdiRsltCd[i] != null)
					model.setMvmtEdiRsltCd(mvmtEdiRsltCd[i]);
				if (ediUiYn[i] != null)
					model.setEdiUiYn(ediUiYn[i]);
				if (startRowNo[i] != null)
					model.setStartRowNo(startRowNo[i]);
				if (mgstNo[i] != null)
					model.setMgstNo(mgstNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
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
		this.endRowNo = this.endRowNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStwgNo = this.cntrStwgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errMsg = this.errMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGateIoCd = this.ediGateIoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmSigCtnt = this.vgmSigCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo = this.pkupNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiTpCd = this.mvmtEdiTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrFullStsCd = this.cntrFullStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntYdCd = this.evntYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntVslCd = this.crntVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wblNo = this.wblNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyDt = this.vgmVrfyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destYdCd = this.destYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit = this.checkDigit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmMzdTpCd = this.vgmMzdTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlNm = this.tmlNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmRefNo = this.vgmRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgSeq = this.mvmtEdiMsgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtTrspModCd = this.mvmtTrspModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgYrmondy = this.mvmtEdiMsgYrmondy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgTpId = this.mvmtEdiMsgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtPtyCtnt = this.vgmWgtPtyCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCombo = this.vvdCombo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate3 = this.pDate3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBl = this.bkgBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userNm = this.userNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchFlg = this.batchFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRmk = this.mvmtEdiRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdVoyNo = this.crntSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventReceive = this.eventReceive .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnLloyd = this.callSgnLloyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediBkgNo = this.ediBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMvmtStsCd = this.ediMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdValue = this.vvdValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtyKnt = this.rtyKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntSkdDirCd = this.crntSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiSghtCd = this.mvmtEdiSghtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgm = this.vgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creLoclDt = this.creLoclDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtUtCd = this.vgmWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvRmk = this.cnmvRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pCntrno = this.pCntrno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmVrfyOrdCtnt = this.vgmVrfyOrdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vgmWgtQty = this.vgmWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iPage = this.iPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiMsgAreaCd = this.mvmtEdiMsgAreaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtvTotal = this.rtvTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssNo = this.chssNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtEdiRsltCd = this.mvmtEdiRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediUiYn = this.ediUiYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startRowNo = this.startRowNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mgstNo = this.mgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
