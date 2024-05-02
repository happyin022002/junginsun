/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustomMnrRprRqstTmpHdrVO.java
*@FileTitle : CustomMnrRprRqstTmpHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.08.27 박명신 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박명신
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomMnrRprRqstTmpHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomMnrRprRqstTmpHdrVO> models = new ArrayList<CustomMnrRprRqstTmpHdrVO>();
	
	/* Column Info */
	private String aproOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrOrdOfcCtyCd = null;
	/* Column Info */
	private String eqDmgTpCd = null;
	/* Column Info */
	private String rprOffhFlg = null;
	/* Column Info */
	private String mnrLbrAmt = null;
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
	private String rprRqstTmpVerNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String agmtOfcCtyCd = null;
	/* Column Info */
	private String fileSeq = null;
	/* Column Info */
	private String agmtVerNo = null;
	/* Column Info */
	private String mnrMtrlAmt = null;
	/* Column Info */
	private String rprRsltDt = null;
	/* Column Info */
	private String ifTrcSeq = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String rqstRefNo = null;
	/* Column Info */
	private String eqDmgDt = null;
	/* Column Info */
	private String mnrInpTpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String eqPrefix = null;
	/* Column Info */
	private String rprWrkTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rprRqstTmpSeq = null;
	/* Column Info */
	private String rqstEqNo = null;
	/* Column Info */
	private String rprDtlStsCd = null;
	/* Column Info */
	private String rprYdCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String rprRqstLstVerFlg = null;
	/* Column Info */
	private String invOfcCd = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String n3ptyFlg = null;
	/* Column Info */
	private String mnrTtlAmt = null;
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
	private String aproUsrId = null;
	/* Column Info */
	private String mnrOrdSeq = null;
	/* Column Info */
	private String mnrOrdSndDt = null;
	/* Column Info */
	private String mnrMeasUtCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomMnrRprRqstTmpHdrVO() {}

	public CustomMnrRprRqstTmpHdrVO(String ibflag, String pagerows, String rqstEqNo, String rprRqstTmpSeq, String rprRqstTmpVerNo, String rprRqstLstVerFlg, String eqKndCd, String eqTpszCd, String vndrSeq, String rprStsCd, String rprDtlStsCd, String rqstRefNo, String mnrInpTpCd, String costOfcCd, String rqstDt, String rqstUsrId, String mnrMeasUtCd, String aproOfcCd, String aproDt, String aproUsrId, String rprOffhFlg, String rprRsltDt, String currCd, String rprYdCd, String eqDmgDt, String eqDmgTpCd, String rprWrkTpCd, String mnrEdiNm, String mnrOrdIssDt, String mnrOrdSndDt, String n3ptyFlg, String invOfcCd, String invNo, String ifTrcSeq, String mnrLbrAmt, String mnrMtrlAmt, String invAmt, String mnrTtlAmt, String dispFlg, String dispNo, String dispDtlSeq, String fileSeq, String mnrRprRmk, String ediId, String mnrOrdOfcCtyCd, String mnrOrdSeq, String agmtOfcCtyCd, String agmtSeq, String agmtVerNo, String creUsrId, String creDt, String updUsrId, String updDt, String eqPrefix) {
		this.aproOfcCd = aproOfcCd;
		this.pagerows = pagerows;
		this.mnrOrdOfcCtyCd = mnrOrdOfcCtyCd;
		this.eqDmgTpCd = eqDmgTpCd;
		this.rprOffhFlg = rprOffhFlg;
		this.mnrLbrAmt = mnrLbrAmt;
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
		this.rprRqstTmpVerNo = rprRqstTmpVerNo;
		this.vndrSeq = vndrSeq;
		this.agmtOfcCtyCd = agmtOfcCtyCd;
		this.fileSeq = fileSeq;
		this.agmtVerNo = agmtVerNo;
		this.mnrMtrlAmt = mnrMtrlAmt;
		this.rprRsltDt = rprRsltDt;
		this.ifTrcSeq = ifTrcSeq;
		this.rqstUsrId = rqstUsrId;
		this.currCd = currCd;
		this.rqstRefNo = rqstRefNo;
		this.eqDmgDt = eqDmgDt;
		this.mnrInpTpCd = mnrInpTpCd;
		this.creDt = creDt;
		this.eqPrefix = eqPrefix;
		this.rprWrkTpCd = rprWrkTpCd;
		this.ibflag = ibflag;
		this.rprRqstTmpSeq = rprRqstTmpSeq;
		this.rqstEqNo = rqstEqNo;
		this.rprDtlStsCd = rprDtlStsCd;
		this.rprYdCd = rprYdCd;
		this.invAmt = invAmt;
		this.rprRqstLstVerFlg = rprRqstLstVerFlg;
		this.invOfcCd = invOfcCd;
		this.updDt = updDt;
		this.n3ptyFlg = n3ptyFlg;
		this.mnrTtlAmt = mnrTtlAmt;
		this.rqstDt = rqstDt;
		this.costOfcCd = costOfcCd;
		this.eqKndCd = eqKndCd;
		this.dispDtlSeq = dispDtlSeq;
		this.invNo = invNo;
		this.aproUsrId = aproUsrId;
		this.mnrOrdSeq = mnrOrdSeq;
		this.mnrOrdSndDt = mnrOrdSndDt;
		this.mnrMeasUtCd = mnrMeasUtCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_ord_ofc_cty_cd", getMnrOrdOfcCtyCd());
		this.hashColumns.put("eq_dmg_tp_cd", getEqDmgTpCd());
		this.hashColumns.put("rpr_offh_flg", getRprOffhFlg());
		this.hashColumns.put("mnr_lbr_amt", getMnrLbrAmt());
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
		this.hashColumns.put("rpr_rqst_tmp_ver_no", getRprRqstTmpVerNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());
		this.hashColumns.put("file_seq", getFileSeq());
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());
		this.hashColumns.put("mnr_mtrl_amt", getMnrMtrlAmt());
		this.hashColumns.put("rpr_rslt_dt", getRprRsltDt());
		this.hashColumns.put("if_trc_seq", getIfTrcSeq());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("rqst_ref_no", getRqstRefNo());
		this.hashColumns.put("eq_dmg_dt", getEqDmgDt());
		this.hashColumns.put("mnr_inp_tp_cd", getMnrInpTpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("eq_prefix", getEqPrefix());
		this.hashColumns.put("rpr_wrk_tp_cd", getRprWrkTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rpr_rqst_tmp_seq", getRprRqstTmpSeq());
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());
		this.hashColumns.put("rpr_dtl_sts_cd", getRprDtlStsCd());
		this.hashColumns.put("rpr_yd_cd", getRprYdCd());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("rpr_rqst_lst_ver_flg", getRprRqstLstVerFlg());
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());
		this.hashColumns.put("mnr_ttl_amt", getMnrTtlAmt());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("disp_dtl_seq", getDispDtlSeq());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("mnr_ord_seq", getMnrOrdSeq());
		this.hashColumns.put("mnr_ord_snd_dt", getMnrOrdSndDt());
		this.hashColumns.put("mnr_meas_ut_cd", getMnrMeasUtCd());
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
		this.hashFields.put("eq_dmg_tp_cd", "eqDmgTpCd");
		this.hashFields.put("rpr_offh_flg", "rprOffhFlg");
		this.hashFields.put("mnr_lbr_amt", "mnrLbrAmt");
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
		this.hashFields.put("rpr_rqst_tmp_ver_no", "rprRqstTmpVerNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("mnr_mtrl_amt", "mnrMtrlAmt");
		this.hashFields.put("rpr_rslt_dt", "rprRsltDt");
		this.hashFields.put("if_trc_seq", "ifTrcSeq");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("rqst_ref_no", "rqstRefNo");
		this.hashFields.put("eq_dmg_dt", "eqDmgDt");
		this.hashFields.put("mnr_inp_tp_cd", "mnrInpTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eq_prefix", "eqPrefix");
		this.hashFields.put("rpr_wrk_tp_cd", "rprWrkTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rpr_rqst_tmp_seq", "rprRqstTmpSeq");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("rpr_dtl_sts_cd", "rprDtlStsCd");
		this.hashFields.put("rpr_yd_cd", "rprYdCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("rpr_rqst_lst_ver_flg", "rprRqstLstVerFlg");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("mnr_ttl_amt", "mnrTtlAmt");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("disp_dtl_seq", "dispDtlSeq");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("mnr_ord_seq", "mnrOrdSeq");
		this.hashFields.put("mnr_ord_snd_dt", "mnrOrdSndDt");
		this.hashFields.put("mnr_meas_ut_cd", "mnrMeasUtCd");
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
	 * @return mnrLbrAmt
	 */
	public String getMnrLbrAmt() {
		return this.mnrLbrAmt;
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
	 * @return rprRqstTmpVerNo
	 */
	public String getRprRqstTmpVerNo() {
		return this.rprRqstTmpVerNo;
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
	 * @return mnrMtrlAmt
	 */
	public String getMnrMtrlAmt() {
		return this.mnrMtrlAmt;
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
	 * @return rqstRefNo
	 */
	public String getRqstRefNo() {
		return this.rqstRefNo;
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
	 * @return mnrInpTpCd
	 */
	public String getMnrInpTpCd() {
		return this.mnrInpTpCd;
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
	 * @return eqPrefix
	 */
	public String getEqPrefix() {
		return this.eqPrefix;
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
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
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
	 * @return mnrTtlAmt
	 */
	public String getMnrTtlAmt() {
		return this.mnrTtlAmt;
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
	 * @param mnrLbrAmt
	 */
	public void setMnrLbrAmt(String mnrLbrAmt) {
		this.mnrLbrAmt = mnrLbrAmt;
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
	 * @param rprRqstTmpVerNo
	 */
	public void setRprRqstTmpVerNo(String rprRqstTmpVerNo) {
		this.rprRqstTmpVerNo = rprRqstTmpVerNo;
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
	 * @param mnrMtrlAmt
	 */
	public void setMnrMtrlAmt(String mnrMtrlAmt) {
		this.mnrMtrlAmt = mnrMtrlAmt;
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
	 * @param rqstRefNo
	 */
	public void setRqstRefNo(String rqstRefNo) {
		this.rqstRefNo = rqstRefNo;
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
	 * @param mnrInpTpCd
	 */
	public void setMnrInpTpCd(String mnrInpTpCd) {
		this.mnrInpTpCd = mnrInpTpCd;
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
	 * @param eqPrefix
	 */
	public void setEqPrefix(String eqPrefix) {
		this.eqPrefix = eqPrefix;
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
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
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
	 * @param mnrTtlAmt
	 */
	public void setMnrTtlAmt(String mnrTtlAmt) {
		this.mnrTtlAmt = mnrTtlAmt;
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
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAproOfcCd(JSPUtil.getParameter(request, "apro_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrOrdOfcCtyCd(JSPUtil.getParameter(request, "mnr_ord_ofc_cty_cd", ""));
		setEqDmgTpCd(JSPUtil.getParameter(request, "eq_dmg_tp_cd", ""));
		setRprOffhFlg(JSPUtil.getParameter(request, "rpr_offh_flg", ""));
		setMnrLbrAmt(JSPUtil.getParameter(request, "mnr_lbr_amt", ""));
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
		setRprRqstTmpVerNo(JSPUtil.getParameter(request, "rpr_rqst_tmp_ver_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request, "agmt_ofc_cty_cd", ""));
		setFileSeq(JSPUtil.getParameter(request, "file_seq", ""));
		setAgmtVerNo(JSPUtil.getParameter(request, "agmt_ver_no", ""));
		setMnrMtrlAmt(JSPUtil.getParameter(request, "mnr_mtrl_amt", ""));
		setRprRsltDt(JSPUtil.getParameter(request, "rpr_rslt_dt", ""));
		setIfTrcSeq(JSPUtil.getParameter(request, "if_trc_seq", ""));
		setRqstUsrId(JSPUtil.getParameter(request, "rqst_usr_id", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setRqstRefNo(JSPUtil.getParameter(request, "rqst_ref_no", ""));
		setEqDmgDt(JSPUtil.getParameter(request, "eq_dmg_dt", ""));
		setMnrInpTpCd(JSPUtil.getParameter(request, "mnr_inp_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setEqPrefix(JSPUtil.getParameter(request, "eq_prefix", ""));
		setRprWrkTpCd(JSPUtil.getParameter(request, "rpr_wrk_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRprRqstTmpSeq(JSPUtil.getParameter(request, "rpr_rqst_tmp_seq", ""));
		setRqstEqNo(JSPUtil.getParameter(request, "rqst_eq_no", ""));
		setRprDtlStsCd(JSPUtil.getParameter(request, "rpr_dtl_sts_cd", ""));
		setRprYdCd(JSPUtil.getParameter(request, "rpr_yd_cd", ""));
		setInvAmt(JSPUtil.getParameter(request, "inv_amt", ""));
		setRprRqstLstVerFlg(JSPUtil.getParameter(request, "rpr_rqst_lst_ver_flg", ""));
		setInvOfcCd(JSPUtil.getParameter(request, "inv_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setN3ptyFlg(JSPUtil.getParameter(request, "n3pty_flg", ""));
		setMnrTtlAmt(JSPUtil.getParameter(request, "mnr_ttl_amt", ""));
		setRqstDt(JSPUtil.getParameter(request, "rqst_dt", ""));
		setCostOfcCd(JSPUtil.getParameter(request, "cost_ofc_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setDispDtlSeq(JSPUtil.getParameter(request, "disp_dtl_seq", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setAproUsrId(JSPUtil.getParameter(request, "apro_usr_id", ""));
		setMnrOrdSeq(JSPUtil.getParameter(request, "mnr_ord_seq", ""));
		setMnrOrdSndDt(JSPUtil.getParameter(request, "mnr_ord_snd_dt", ""));
		setMnrMeasUtCd(JSPUtil.getParameter(request, "mnr_meas_ut_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomMnrRprRqstTmpHdrVO[]
	 */
	public CustomMnrRprRqstTmpHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomMnrRprRqstTmpHdrVO[]
	 */
	public CustomMnrRprRqstTmpHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomMnrRprRqstTmpHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrOrdOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_ofc_cty_cd", length));
			String[] eqDmgTpCd = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_tp_cd", length));
			String[] rprOffhFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_offh_flg", length));
			String[] mnrLbrAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_lbr_amt", length));
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
			String[] rprRqstTmpVerNo = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_tmp_ver_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] agmtOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "agmt_ofc_cty_cd", length));
			String[] fileSeq = (JSPUtil.getParameter(request, prefix	+ "file_seq", length));
			String[] agmtVerNo = (JSPUtil.getParameter(request, prefix	+ "agmt_ver_no", length));
			String[] mnrMtrlAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_mtrl_amt", length));
			String[] rprRsltDt = (JSPUtil.getParameter(request, prefix	+ "rpr_rslt_dt", length));
			String[] ifTrcSeq = (JSPUtil.getParameter(request, prefix	+ "if_trc_seq", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] rqstRefNo = (JSPUtil.getParameter(request, prefix	+ "rqst_ref_no", length));
			String[] eqDmgDt = (JSPUtil.getParameter(request, prefix	+ "eq_dmg_dt", length));
			String[] mnrInpTpCd = (JSPUtil.getParameter(request, prefix	+ "mnr_inp_tp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] eqPrefix = (JSPUtil.getParameter(request, prefix	+ "eq_prefix", length));
			String[] rprWrkTpCd = (JSPUtil.getParameter(request, prefix	+ "rpr_wrk_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rprRqstTmpSeq = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_tmp_seq", length));
			String[] rqstEqNo = (JSPUtil.getParameter(request, prefix	+ "rqst_eq_no", length));
			String[] rprDtlStsCd = (JSPUtil.getParameter(request, prefix	+ "rpr_dtl_sts_cd", length));
			String[] rprYdCd = (JSPUtil.getParameter(request, prefix	+ "rpr_yd_cd", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] rprRqstLstVerFlg = (JSPUtil.getParameter(request, prefix	+ "rpr_rqst_lst_ver_flg", length));
			String[] invOfcCd = (JSPUtil.getParameter(request, prefix	+ "inv_ofc_cd", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] n3ptyFlg = (JSPUtil.getParameter(request, prefix	+ "n3pty_flg", length));
			String[] mnrTtlAmt = (JSPUtil.getParameter(request, prefix	+ "mnr_ttl_amt", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] costOfcCd = (JSPUtil.getParameter(request, prefix	+ "cost_ofc_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] dispDtlSeq = (JSPUtil.getParameter(request, prefix	+ "disp_dtl_seq", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] mnrOrdSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_seq", length));
			String[] mnrOrdSndDt = (JSPUtil.getParameter(request, prefix	+ "mnr_ord_snd_dt", length));
			String[] mnrMeasUtCd = (JSPUtil.getParameter(request, prefix	+ "mnr_meas_ut_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomMnrRprRqstTmpHdrVO();
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrOrdOfcCtyCd[i] != null)
					model.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd[i]);
				if (eqDmgTpCd[i] != null)
					model.setEqDmgTpCd(eqDmgTpCd[i]);
				if (rprOffhFlg[i] != null)
					model.setRprOffhFlg(rprOffhFlg[i]);
				if (mnrLbrAmt[i] != null)
					model.setMnrLbrAmt(mnrLbrAmt[i]);
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
				if (rprRqstTmpVerNo[i] != null)
					model.setRprRqstTmpVerNo(rprRqstTmpVerNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (agmtOfcCtyCd[i] != null)
					model.setAgmtOfcCtyCd(agmtOfcCtyCd[i]);
				if (fileSeq[i] != null)
					model.setFileSeq(fileSeq[i]);
				if (agmtVerNo[i] != null)
					model.setAgmtVerNo(agmtVerNo[i]);
				if (mnrMtrlAmt[i] != null)
					model.setMnrMtrlAmt(mnrMtrlAmt[i]);
				if (rprRsltDt[i] != null)
					model.setRprRsltDt(rprRsltDt[i]);
				if (ifTrcSeq[i] != null)
					model.setIfTrcSeq(ifTrcSeq[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (rqstRefNo[i] != null)
					model.setRqstRefNo(rqstRefNo[i]);
				if (eqDmgDt[i] != null)
					model.setEqDmgDt(eqDmgDt[i]);
				if (mnrInpTpCd[i] != null)
					model.setMnrInpTpCd(mnrInpTpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (eqPrefix[i] != null)
					model.setEqPrefix(eqPrefix[i]);
				if (rprWrkTpCd[i] != null)
					model.setRprWrkTpCd(rprWrkTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rprRqstTmpSeq[i] != null)
					model.setRprRqstTmpSeq(rprRqstTmpSeq[i]);
				if (rqstEqNo[i] != null)
					model.setRqstEqNo(rqstEqNo[i]);
				if (rprDtlStsCd[i] != null)
					model.setRprDtlStsCd(rprDtlStsCd[i]);
				if (rprYdCd[i] != null)
					model.setRprYdCd(rprYdCd[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (rprRqstLstVerFlg[i] != null)
					model.setRprRqstLstVerFlg(rprRqstLstVerFlg[i]);
				if (invOfcCd[i] != null)
					model.setInvOfcCd(invOfcCd[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (n3ptyFlg[i] != null)
					model.setN3ptyFlg(n3ptyFlg[i]);
				if (mnrTtlAmt[i] != null)
					model.setMnrTtlAmt(mnrTtlAmt[i]);
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
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (mnrOrdSeq[i] != null)
					model.setMnrOrdSeq(mnrOrdSeq[i]);
				if (mnrOrdSndDt[i] != null)
					model.setMnrOrdSndDt(mnrOrdSndDt[i]);
				if (mnrMeasUtCd[i] != null)
					model.setMnrMeasUtCd(mnrMeasUtCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomMnrRprRqstTmpHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomMnrRprRqstTmpHdrVO[]
	 */
	public CustomMnrRprRqstTmpHdrVO[] getCustomMnrRprRqstTmpHdrVOs(){
		CustomMnrRprRqstTmpHdrVO[] vos = (CustomMnrRprRqstTmpHdrVO[])models.toArray(new CustomMnrRprRqstTmpHdrVO[models.size()]);
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
		this.eqDmgTpCd = this.eqDmgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprOffhFlg = this.rprOffhFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrLbrAmt = this.mnrLbrAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.rprRqstTmpVerNo = this.rprRqstTmpVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd = this.agmtOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq = this.fileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo = this.agmtVerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrMtrlAmt = this.mnrMtrlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRsltDt = this.rprRsltDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifTrcSeq = this.ifTrcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRefNo = this.rqstRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqDmgDt = this.eqDmgDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrInpTpCd = this.mnrInpTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqPrefix = this.eqPrefix .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprWrkTpCd = this.rprWrkTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstTmpSeq = this.rprRqstTmpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo = this.rqstEqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprDtlStsCd = this.rprDtlStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprYdCd = this.rprYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rprRqstLstVerFlg = this.rprRqstLstVerFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd = this.invOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg = this.n3ptyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTtlAmt = this.mnrTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd = this.costOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispDtlSeq = this.dispDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSeq = this.mnrOrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrOrdSndDt = this.mnrOrdSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrMeasUtCd = this.mnrMeasUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
