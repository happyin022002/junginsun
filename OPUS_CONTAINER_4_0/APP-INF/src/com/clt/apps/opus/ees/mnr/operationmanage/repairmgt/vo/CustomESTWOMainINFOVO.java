/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomESTWOMainINFOVO.java
*@FileTitle : CustomESTWOMainINFOVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.10.14 김완규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomESTWOMainINFOVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomESTWOMainINFOVO> models = new ArrayList<CustomESTWOMainINFOVO>();
	
	/* Column Info */
	private String aproOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String mnrWrkAmt = null;
	/* Column Info */
	private String eqDmgTpCd = null;
	/* Column Info */
	private String rprOffhFlg = null;
	/* Column Info */
	private String n3ptyBilTtlAmt = null;
	/* Column Info */
	private String rprRqstSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String mnrEdiNm = null;
	/* Column Info */
	private String mnrOrdIssDt = null;
	/* Column Info */
	private String rprStsCd = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String agmtSeq = null;
	/* Column Info */
	private String mnrRprRmk = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String dispFlg = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String rprRsltDt = null;
	/* Column Info */
	private String ifTrcSeq = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rprRqstVerNo = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String mnrInpTpCd = null;
	/* Column Info */
	private String eqDmgDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rprWrkTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rprRqstTmpSeq = null;
	/* Column Info */
	private String mnrAgmtAmt = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String rprDtlStsCd = null;
	/* Column Info */
	private String rprYdCd = null;
	/* Column Info */
	private String woNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String woDt = null;
	/* Column Info */
	private String rprRqstLstVerFlg = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String costOfcCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String dispDtlSeq = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String mnrDmgFlg = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String hiddenMnrDmgFlg = null;
	/* Column Info */
	private String mnrOrdSndDt = null;
	/* Column Info */
	private String mnrMeasUtCd = null;
	/* Column Info */
	private String costCdNm = null;
	/* Column Info */
	private String tmpSeq = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String trdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustomESTWOMainINFOVO() {}

	public CustomESTWOMainINFOVO(String ibflag, String pagerows, String aproOfcCd, String mnrOrdOfcCtyCd, String eqKndNm, String costCd, String mnrWrkAmt, String eqDmgTpCd, String rprOffhFlg, String n3ptyBilTtlAmt, String rprRqstSeq, String updUsrId, String mnrEdiNm, String mnrOrdIssDt, String dispNo, String rprStsCd, String agmtSeq, String mnrRprRmk, String ediId, String aproDt, String eqTpszCd, String dispFlg, String creUsrId, String agmtOfcCtyCd, String vndrSeq, String fileSeq, String agmtVerNo, String rprRsltDt, String ifTrcSeq, String rqstUsrId, String currCd, String rprRqstVerNo, String rqstRefNo, String mnrInpTpCd, String eqDmgDt, String creDt, String rprWrkTpCd, String rprRqstTmpSeq, String mnrAgmtAmt, String rqstEqNo, String rprDtlStsCd, String rprYdCd, String woNo, String invAmt, String woDt, String rprRqstLstVerFlg, String invOfcCd, String updDt, String n3ptyFlg, String rqstDt, String costOfcCd, String dispDtlSeq, String eqKndCd, String invNo, String mnrDmgFlg, String aproUsrId, String mnrOrdSeq, String hiddenMnrDmgFlg, String mnrOrdSndDt, String mnrMeasUtCd, String costCdNm, String tmpSeq, String bkgNo, String trdCd) {
		this.aproOfcCd = aproOfcCd;
		this.pagerows = pagerows;
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.eqKndNm = eqKndNm;
		this.costCd = costCd;
		this.mnrWrkAmt = mnrWrkAmt;
		this.eqDmgTpCd = eqDmgTpCd;
		this.rprOffhFlg = rprOffhFlg;
		this.n3ptyBilTtlAmt = n3ptyBilTtlAmt;
		this.rprRqstSeq = rprRqstSeq;
		this.updUsrId = updUsrId;
		this.mnrEdiNm = mnrEdiNm;
		this.mnrOrdIssDt = mnrOrdIssDt;
		this.rprStsCd = rprStsCd;
		this.dispNo = dispNo;
		this.agmtSeq = agmtSeq;
		this.mnrRprRmk = mnrRprRmk;
		this.ediId = ediId;
		this.aproDt = aproDt;
		this.eqTpszCd = eqTpszCd;
		this.dispFlg = dispFlg;
		this.creUsrId = creUsrId;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.fileSeq = fileSeq;
		this.agmtVerNo = agmtVerNo;
		this.rprRsltDt = rprRsltDt;
		this.ifTrcSeq = ifTrcSeq;
		this.rqstUsrId = rqstUsrId;
		this.currCd = currCd;
		this.rprRqstVerNo = rprRqstVerNo;
		this.rqstRefNo = rqstRefNo;
		this.mnrInpTpCd = mnrInpTpCd;
		this.eqDmgDt = eqDmgDt;
		this.creDt = creDt;
		this.rprWrkTpCd = rprWrkTpCd;
		this.ibflag = ibflag;
		this.rprRqstTmpSeq = rprRqstTmpSeq;
		this.mnrAgmtAmt = mnrAgmtAmt;
		this.rqstEqNo = rqstEqNo;
		this.rprDtlStsCd = rprDtlStsCd;
		this.rprYdCd = rprYdCd;
		this.woNo = woNo;
		this.invAmt = invAmt;
		this.woDt = woDt;
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
		this.invOfcCd = invOfcCd;
		this.updDt = updDt;
		this.n3ptyFlg = n3ptyFlg;
		this.rqstDt = rqstDt;
		this.costOfcCd = costOfcCd;
		this.eqKndCd = eqKndCd;
		this.dispDtlSeq = dispDtlSeq;
		this.invNo = invNo;
		this.mnrDmgFlg = mnrDmgFlg;
		this.aproUsrId = aproUsrId;
		this.mnrOrdSeq = mnrOrdSeq;
		this.hiddenMnrDmgFlg = hiddenMnrDmgFlg;
		this.mnrOrdSndDt = mnrOrdSndDt;
		this.mnrMeasUtCd = mnrMeasUtCd;
		this.costCdNm = costCdNm;
		this.tmpSeq = tmpSeq;
		this.bkgNo = bkgNo;
		this.trdCd = trdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("mnr_wrk_amt", getMnrWrkAmt());
		this.hashColumns.put("eq_dmg_tp_cd", getEqDmgTpCd());
		this.hashColumns.put("rpr_offh_flg", getRprOffhFlg());
		this.hashColumns.put("n3pty_bil_ttl_amt", getN3ptyBilTtlAmt());
		this.hashColumns.put("rpr_rqst_seq", getRprRqstSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("mnr_edi_nm", getMnrEdiNm());
		this.hashColumns.put("mnr_ord_iss_dt", getMnrOrdIssDt());
		this.hashColumns.put("rpr_sts_cd", getRprStsCd());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("agmt_seq", getAgmtSeq());
		this.hashColumns.put("mnr_rpr_rmk", getMnrRprRmk());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("disp_flg", getDispFlg());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("rpr_rslt_dt", getRprRsltDt());
		this.hashColumns.put("if_trc_seq", getIfTrcSeq());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rpr_rqst_ver_no", getRprRqstVerNo());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("mnr_inp_tp_cd", getMnrInpTpCd());
		this.hashColumns.put("eq_dmg_dt", getEqDmgDt());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rpr_wrk_tp_cd", getRprWrkTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rpr_rqst_tmp_seq", getRprRqstTmpSeq());
		this.hashColumns.put("mnr_agmt_amt", getMnrAgmtAmt());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("rpr_dtl_sts_cd", getRprDtlStsCd());
		this.hashColumns.put("rpr_yd_cd", getRprYdCd());
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("wo_dt", getWoDt());
		this.hashColumns.put("rpr_rqst_lst_ver_flg", getRprRqstLstVerFlg());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("mnr_dmg_flg", getMnrDmgFlg());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("hidden_mnr_dmg_flg", getHiddenMnrDmgFlg());
		this.hashColumns.put("mnr_ord_snd_dt", getMnrOrdSndDt());
		this.hashColumns.put("mnr_meas_ut_cd", getMnrMeasUtCd());
		this.hashColumns.put("cost_cd_nm", getCostCdNm());
		this.hashColumns.put("tmp_seq", getTmpSeq());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("trd_cd", getTrdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_ord_ofc_cty_cd", "mnrOrdOfcCtyCd");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("mnr_wrk_amt", "mnrWrkAmt");
		this.hashFields.put("eq_dmg_tp_cd", "eqDmgTpCd");
		this.hashFields.put("rpr_offh_flg", "rprOffhFlg");
		this.hashFields.put("n3pty_bil_ttl_amt", "n3ptyBilTtlAmt");
		this.hashFields.put("rpr_rqst_seq", "rprRqstSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("mnr_edi_nm", "mnrEdiNm");
		this.hashFields.put("mnr_ord_iss_dt", "mnrOrdIssDt");
		this.hashFields.put("rpr_sts_cd", "rprStsCd");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("mnr_rpr_rmk", "mnrRprRmk");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("rpr_rslt_dt", "rprRsltDt");
		this.hashFields.put("if_trc_seq", "ifTrcSeq");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rpr_rqst_ver_no", "rprRqstVerNo");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("mnr_inp_tp_cd", "mnrInpTpCd");
		this.hashFields.put("eq_dmg_dt", "eqDmgDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rpr_wrk_tp_cd", "rprWrkTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rpr_rqst_tmp_seq", "rprRqstTmpSeq");
		this.hashFields.put("mnr_agmt_amt", "mnrAgmtAmt");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("rpr_dtl_sts_cd", "rprDtlStsCd");
		this.hashFields.put("rpr_yd_cd", "rprYdCd");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("wo_dt", "woDt");
		this.hashFields.put("rpr_rqst_lst_ver_flg", "rprRqstLstVerFlg");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("mnr_dmg_flg", "mnrDmgFlg");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("hidden_mnr_dmg_flg", "hiddenMnrDmgFlg");
		this.hashFields.put("mnr_ord_snd_dt", "mnrOrdSndDt");
		this.hashFields.put("mnr_meas_ut_cd", "mnrMeasUtCd");
		this.hashFields.put("cost_cd_nm", "costCdNm");
		this.hashFields.put("tmp_seq", "tmpSeq");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("trd_cd", "trdCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
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
	 * @return eqKndNm
	 */
	public String getEqKndNm() {
		return this.eqKndNm;
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
	 * @return mnrWrkAmt
	 */
	public String getMnrWrkAmt() {
		return this.mnrWrkAmt;
	}
	
	/**
	 * Column Info
	 * @return eqDmgTpCd
	 */
	public String getEqDmgTpCd() {
		return this.eqDmgTpCd;
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
	 * @return mnrEdiNm
	 */
	public String getMnrEdiNm() {
		return this.mnrEdiNm;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdIssDt
	 */
	public String getMnrOrdIssDt() {
		return this.mnrOrdIssDt;
	}
	
	/**
	 * Column Info
	 * @return rprStsCd
	 */
	public String getRprStsCd() {
		return this.rprStsCd;
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
	 * @return agmtSeq
	 */
	public String getAgmtSeq() {
		return this.agmtSeq;
	}
	
	/**
	 * Column Info
	 * @return mnrRprRmk
	 */
	public String getMnrRprRmk() {
		return this.mnrRprRmk;
	}
	
	/**
	 * Column Info
	 * @return ediId
	 */
	public String getEdiId() {
		return this.ediId;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return this.dispFlg;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return agmtOfcCtyCd
	 */
	public String getAgmtOfcCtyCd() {
		return this.agmtOfcCtyCd;
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
	 * @return agmtVerNo
	 */
	public String getAgmtVerNo() {
		return this.agmtVerNo;
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
	 * @return ifTrcSeq
	 */
	public String getIfTrcSeq() {
		return this.ifTrcSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
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
	 * @return mnrInpTpCd
	 */
	public String getMnrInpTpCd() {
		return this.mnrInpTpCd;
	}
	
	/**
	 * Column Info
	 * @return eqDmgDt
	 */
	public String getEqDmgDt() {
		return this.eqDmgDt;
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
	 * @return rprWrkTpCd
	 */
	public String getRprWrkTpCd() {
		return this.rprWrkTpCd;
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
	 * @return rqstEqNo
	 */
	public String getRqstEqNo() {
		return this.rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @return rprDtlStsCd
	 */
	public String getRprDtlStsCd() {
		return this.rprDtlStsCd;
	}
	
	/**
	 * Column Info
	 * @return rprYdCd
	 */
	public String getRprYdCd() {
		return this.rprYdCd;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @return rprRqstLstVerFlg
	 */
	public String getRprRqstLstVerFlg() {
		return this.rprRqstLstVerFlg;
	}
	
	/**
	 * Column Info
	 * @return invOfcCd
	 */
	public String getInvOfcCd() {
		return this.invOfcCd;
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
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
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
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return dispDtlSeq
	 */
	public String getDispDtlSeq() {
		return this.dispDtlSeq;
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
	 * @return mnrDmgFlg
	 */
	public String getMnrDmgFlg() {
		return this.mnrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
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
	 * @return hiddenMnrDmgFlg
	 */
	public String getHiddenMnrDmgFlg() {
		return this.hiddenMnrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @return mnrOrdSndDt
	 */
	public String getMnrOrdSndDt() {
		return this.mnrOrdSndDt;
	}
	
	/**
	 * Column Info
	 * @return mnrMeasUtCd
	 */
	public String getMnrMeasUtCd() {
		return this.mnrMeasUtCd;
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
	 * @return tmpSeq
	 */
	public String getTmpSeq() {
		return this.tmpSeq;
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
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
	}

	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
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
	 * @param eqKndNm
	 */
	public void setEqKndNm(String eqKndNm) {
		this.eqKndNm = eqKndNm;
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
	 * @param mnrWrkAmt
	 */
	public void setMnrWrkAmt(String mnrWrkAmt) {
		this.mnrWrkAmt = mnrWrkAmt;
	}
	
	/**
	 * Column Info
	 * @param eqDmgTpCd
	 */
	public void setEqDmgTpCd(String eqDmgTpCd) {
		this.eqDmgTpCd = eqDmgTpCd;
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
	 * @param mnrEdiNm
	 */
	public void setMnrEdiNm(String mnrEdiNm) {
		this.mnrEdiNm = mnrEdiNm;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdIssDt
	 */
	public void setMnrOrdIssDt(String mnrOrdIssDt) {
		this.mnrOrdIssDt = mnrOrdIssDt;
	}
	
	/**
	 * Column Info
	 * @param rprStsCd
	 */
	public void setRprStsCd(String rprStsCd) {
		this.rprStsCd = rprStsCd;
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
	 * @param agmtSeq
	 */
	public void setAgmtSeq(String agmtSeq) {
		this.agmtSeq = agmtSeq;
	}
	
	/**
	 * Column Info
	 * @param mnrRprRmk
	 */
	public void setMnrRprRmk(String mnrRprRmk) {
		this.mnrRprRmk = mnrRprRmk;
	}
	
	/**
	 * Column Info
	 * @param ediId
	 */
	public void setEdiId(String ediId) {
		this.ediId = ediId;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param dispFlg
	 */
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param agmtOfcCtyCd
	 */
	public void setAgmtOfcCtyCd(String agmtOfcCtyCd) {
		this.agmtOfcCtyCd = agmtOfcCtyCd;
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
	 * @param agmtVerNo
	 */
	public void setAgmtVerNo(String agmtVerNo) {
		this.agmtVerNo = agmtVerNo;
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
	 * @param ifTrcSeq
	 */
	public void setIfTrcSeq(String ifTrcSeq) {
		this.ifTrcSeq = ifTrcSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
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
	 * @param mnrInpTpCd
	 */
	public void setMnrInpTpCd(String mnrInpTpCd) {
		this.mnrInpTpCd = mnrInpTpCd;
	}
	
	/**
	 * Column Info
	 * @param eqDmgDt
	 */
	public void setEqDmgDt(String eqDmgDt) {
		this.eqDmgDt = eqDmgDt;
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
	 * @param rprWrkTpCd
	 */
	public void setRprWrkTpCd(String rprWrkTpCd) {
		this.rprWrkTpCd = rprWrkTpCd;
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
	 * @param rqstEqNo
	 */
	public void setRqstEqNo(String rqstEqNo) {
		this.rqstEqNo = rqstEqNo;
	}
	
	/**
	 * Column Info
	 * @param rprDtlStsCd
	 */
	public void setRprDtlStsCd(String rprDtlStsCd) {
		this.rprDtlStsCd = rprDtlStsCd;
	}
	
	/**
	 * Column Info
	 * @param rprYdCd
	 */
	public void setRprYdCd(String rprYdCd) {
		this.rprYdCd = rprYdCd;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
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
	 * @param rprRqstLstVerFlg
	 */
	public void setRprRqstLstVerFlg(String rprRqstLstVerFlg) {
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
	}
	
	/**
	 * Column Info
	 * @param invOfcCd
	 */
	public void setInvOfcCd(String invOfcCd) {
		this.invOfcCd = invOfcCd;
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
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
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
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param dispDtlSeq
	 */
	public void setDispDtlSeq(String dispDtlSeq) {
		this.dispDtlSeq = dispDtlSeq;
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
	 * @param mnrDmgFlg
	 */
	public void setMnrDmgFlg(String mnrDmgFlg) {
		this.mnrDmgFlg = mnrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
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
	 * @param hiddenMnrDmgFlg
	 */
	public void setHiddenMnrDmgFlg(String hiddenMnrDmgFlg) {
		this.hiddenMnrDmgFlg = hiddenMnrDmgFlg;
	}
	
	/**
	 * Column Info
	 * @param mnrOrdSndDt
	 */
	public void setMnrOrdSndDt(String mnrOrdSndDt) {
		this.mnrOrdSndDt = mnrOrdSndDt;
	}
	
	/**
	 * Column Info
	 * @param mnrMeasUtCd
	 */
	public void setMnrMeasUtCd(String mnrMeasUtCd) {
		this.mnrMeasUtCd = mnrMeasUtCd;
	}
	
	/**
	 * Column Info
	 * @param costCdNm
	 */
	public void setCostCdNm(String costCdNm) {
		this.costCdNm = costCdNm;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAproOfcCd(JSPUtil.getParameter(request, "apro_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, "mnr_ord_ofc_cty_cd", ""));
		setEqKndNm(JSPUtil.getParameter(request, "eq_knd_nm", ""));
		setCostCd(JSPUtil.getParameter(request, "cost_cd", ""));
		setMnrWrkAmt(JSPUtil.getParameter(request, "mnr_wrk_amt", ""));
		setEqDmgTpCd(JSPUtil.getParameter(request, "eq_dmg_tp_cd", ""));
		setRprOffhFlg(JSPUtil.getParameter(request, "rpr_offh_flg", ""));
		setN3ptyBilTtlAmt(JSPUtil.getParameter(request, "n3pty_bil_ttl_amt", ""));
		setRprRqstSeq(JSPUtil.getParameter(request, "rpr_rqst_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMnrEdiNm(JSPUtil.getParameter(request, "mnr_edi_nm", ""));
		setMnrOrdIssDt(JSPUtil.getParameter(request, "mnr_ord_iss_dt", ""));
		setRprStsCd(JSPUtil.getParameter(request, "rpr_sts_cd", ""));
		setDispNo(JSPUtil.getParameter(request, "disp_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request, "agmt_seq", ""));
		setMnrRprRmk(JSPUtil.getParameter(request, "mnr_rpr_rmk", ""));
		setEdiId(JSPUtil.getParameter(request, "edi_id", ""));
		setAproDt(JSPUtil.getParameter(request, "apro_dt", ""));
		setEqTpszCd(JSPUtil.getParameter(request, "eq_tpsz_cd", ""));
		setDispFlg(JSPUtil.getParameter(request, "disp_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setRprRsltDt(JSPUtil.getParameter(request, "rpr_rslt_dt", ""));
		setIfTrcSeq(JSPUtil.getParameter(request, "if_trc_seq", ""));
		setRqstUsrId(JSPUtil.getParameter(request, "rqst_usr_id", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setRprRqstVerNo(JSPUtil.getParameter(request, "rpr_rqst_ver_no", ""));
		setRqstRefNo(JSPUtil.getParameter(request, "rqst_ref_no", ""));
		setMnrInpTpCd(JSPUtil.getParameter(request, "mnr_inp_tp_cd", ""));
		setEqDmgDt(JSPUtil.getParameter(request, "eq_dmg_dt", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRprWrkTpCd(JSPUtil.getParameter(request, "rpr_wrk_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRprRqstTmpSeq(JSPUtil.getParameter(request, "rpr_rqst_tmp_seq", ""));
		setMnrAgmtAmt(JSPUtil.getParameter(request, "mnr_agmt_amt", ""));
		setRqstEqNo(JSPUtil.getParameter(request, "rqst_eq_no", ""));
		setRprDtlStsCd(JSPUtil.getParameter(request, "rpr_dtl_sts_cd", ""));
		setRprYdCd(JSPUtil.getParameter(request, "rpr_yd_cd", ""));
		setWoNo(JSPUtil.getParameter(request, "wo_no", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setWoDt(JSPUtil.getParameter(request, "wo_dt", ""));
		setRprRqstLstVerFlg(JSPUtil.getParameter(request, "rpr_rqst_lst_ver_flg", ""));
		setInvOfcCd(JSPUtil.getParameter(request, "inv_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, "n3pty_flg", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setDispDtlSeq(JSPUtil.getParameter(request, "disp_dtl_seq", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setMnrDmgFlg(JSPUtil.getParameter(request, "mnr_dmg_flg", ""));
		setAproUsrId(JSPUtil.getParameter(request, "apro_usr_id", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, "mnr_ord_seq", ""));
		setHiddenMnrDmgFlg(JSPUtil.getParameter(request, "hidden_mnr_dmg_flg", ""));
		setMnrOrdSndDt(JSPUtil.getParameter(request, "mnr_ord_snd_dt", ""));
		setMnrMeasUtCd(JSPUtil.getParameter(request, "mnr_meas_ut_cd", ""));
		setCostCdNm(JSPUtil.getParameter(request, "cost_cd_nm", ""));
		setTmpSeq(JSPUtil.getParameter(request, "tmp_seq", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setTrdCd(JSPUtil.getParameter(request, "trd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomESTWOMainINFOVO[]
	 */
	public CustomESTWOMainINFOVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomESTWOMainINFOVO[]
	 */
	public CustomESTWOMainINFOVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomESTWOMainINFOVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] mnrWrkAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_wrk_amt", length));
			String[] eqDmgTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_tp_cd", length));
			String[] rprOffhFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_offh_flg", length));
			String[] n3ptyBilTtlAmt = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_ttl_amt", length));
			String[] rprRqstSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] mnrEdiNm = (JSPUtil.getParameter(request, prefix	+ "mnr_edi_nm", length));
			String[] mnrOrdIssDt = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_iss_dt", length));
			String[] rprStsCd = (JSPUtil.getParameter(request, prefix	+ "rpr_sts_cd", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] agmtSeq = (JSPUtil.getParameter(request, prefix	+ "agmt_seq", length));
			String[] mnrRprRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_rpr_rmk", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] dispFlg = (JSPUtil.getParameter(request, prefix	+ "disp_flg", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] rprRsltDt = (JSPUtil.getParameter(request, prefix	+ "rpr_rslt_dt", length));
			String[] ifTrcSeq = (JSPUtil.getParameter(request, prefix	+ "if_trc_seq", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rprRqstVerNo = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_ver_no", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] mnrInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_tp_cd", length));
			String[] eqDmgDt = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_dt", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rprWrkTpCd = (JSPUtil.getParameter(request, prefix	+ "rpr_wrk_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rprRqstTmpSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_tmp_seq", length));
			String[] mnrAgmtAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_agmt_amt", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] rprDtlStsCd = (JSPUtil.getParameter(request, prefix	+ "rpr_dtl_sts_cd", length));
			String[] rprYdCd = (JSPUtil.getParameter(request, prefix	+ "rpr_yd_cd", length));
			String[] woNo = (JSPUtil.getParameter(request, prefix	+ "wo_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] woDt = (JSPUtil.getParameter(request, prefix	+ "wo_dt", length));
			String[] rprRqstLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_lst_ver_flg", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix	+ "disp_dtl_seq", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] mnrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "mnr_dmg_flg", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] hiddenMnrDmgFlg = (JSPUtil.getParameter(request, prefix	+ "hidden_mnr_dmg_flg", length));
			String[] mnrOrdSndDt = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_snd_dt", length));
			String[] mnrMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "mnr_meas_ut_cd", length));
			String[] costCdNm = (JSPUtil.getParameter(request, prefix	+ "cost_cd_nm", length));
			String[] tmpSeq = (JSPUtil.getParameter(request, prefix	+ "tmp_seq", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomESTWOMainINFOVO();
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (mnrWrkAmt[i] != null)
					model.setMnrWrkAmt(mnrWrkAmt[i]);
				if (eqDmgTpCd[i] != null)
					model.setEqDmgTpCd(eqDmgTpCd[i]);
				if (rprOffhFlg[i] != null)
					model.setRprOffhFlg(rprOffhFlg[i]);
				if (n3ptyBilTtlAmt[i] != null)
					model.setN3ptyBilTtlAmt(n3ptyBilTtlAmt[i]);
				if (rprRqstSeq[i] != null)
					model.setRprRqstSeq(rprRqstSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (mnrEdiNm[i] != null)
					model.setMnrEdiNm(mnrEdiNm[i]);
				if (mnrOrdIssDt[i] != null)
					model.setMnrOrdIssDt(mnrOrdIssDt[i]);
				if (rprStsCd[i] != null)
					model.setRprStsCd(rprStsCd[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (agmtSeq[i] != null)
					model.setAgmtSeq(agmtSeq[i]);
				if (mnrRprRmk[i] != null)
					model.setMnrRprRmk(mnrRprRmk[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (dispFlg[i] != null)
					model.setDispFlg(dispFlg[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (rprRsltDt[i] != null)
					model.setRprRsltDt(rprRsltDt[i]);
				if (ifTrcSeq[i] != null)
					model.setIfTrcSeq(ifTrcSeq[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rprRqstVerNo[i] != null)
					model.setRprRqstVerNo(rprRqstVerNo[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (mnrInpTpCd[i] != null)
					model.setMnrInpTpCd(mnrInpTpCd[i]);
				if (eqDmgDt[i] != null)
					model.setEqDmgDt(eqDmgDt[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rprWrkTpCd[i] != null)
					model.setRprWrkTpCd(rprWrkTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rprRqstTmpSeq[i] != null)
					model.setRprRqstTmpSeq(rprRqstTmpSeq[i]);
				if (mnrAgmtAmt[i] != null)
					model.setMnrAgmtAmt(mnrAgmtAmt[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (rprDtlStsCd[i] != null)
					model.setRprDtlStsCd(rprDtlStsCd[i]);
				if (rprYdCd[i] != null)
					model.setRprYdCd(rprYdCd[i]);
				if (woNo[i] != null)
					model.setWoNo(woNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (woDt[i] != null)
					model.setWoDt(woDt[i]);
				if (rprRqstLstVerFlg[i] != null)
					model.setRprRqstLstVerFlg(rprRqstLstVerFlg[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (costOfcCd[i] != null)
					model.setCostOfcCd(costOfcCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (dispDtlSeq[i] != null)
					model.setDispDtlSeq(dispDtlSeq[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (mnrDmgFlg[i] != null)
					model.setMnrDmgFlg(mnrDmgFlg[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (hiddenMnrDmgFlg[i] != null)
					model.setHiddenMnrDmgFlg(hiddenMnrDmgFlg[i]);
				if (mnrOrdSndDt[i] != null)
					model.setMnrOrdSndDt(mnrOrdSndDt[i]);
				if (mnrMeasUtCd[i] != null)
					model.setMnrMeasUtCd(mnrMeasUtCd[i]);
				if (costCdNm[i] != null)
					model.setCostCdNm(costCdNm[i]);
				if (tmpSeq[i] != null)
					model.setTmpSeq(tmpSeq[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomESTWOMainINFOVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomESTWOMainINFOVO[]
	 */
	public CustomESTWOMainINFOVO[] getCustomESTWOMainINFOVOs(){
		CustomESTWOMainINFOVO[] vos = (CustomESTWOMainINFOVO[])models.toArray(new CustomESTWOMainINFOVO[models.size()]);
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
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdOfcCtyCd = this.mnrOrdOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrWrkAmt = this.mnrWrkAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgTpCd = this.eqDmgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprOffhFlg = this.rprOffhFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTtlAmt = this.n3ptyBilTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstSeq = this.rprRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrEdiNm = this.mnrEdiNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdIssDt = this.mnrOrdIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprStsCd = this.rprStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq = this.agmtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrRprRmk = this.mnrRprRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg = this.dispFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRsltDt = this.rprRsltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifTrcSeq = this.ifTrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstVerNo = this.rprRqstVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpTpCd = this.mnrInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgDt = this.eqDmgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprWrkTpCd = this.rprWrkTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstTmpSeq = this.rprRqstTmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrAgmtAmt = this.mnrAgmtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprDtlStsCd = this.rprDtlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprYdCd = this.rprYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woDt = this.woDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstLstVerFlg = this.rprRqstLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq = this.dispDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrDmgFlg = this.mnrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiddenMnrDmgFlg = this.hiddenMnrDmgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSndDt = this.mnrOrdSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrMeasUtCd = this.mnrMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCdNm = this.costCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpSeq = this.tmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
