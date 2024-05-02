/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EACRgstVO.java
*@FileTitle : EACRgstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 최종혁
*@LastVersion : 1.0
* 2015.12.22 최종혁 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.eac.eacmgt.vo;

import java.lang.reflect.Field;
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
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최종혁
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EACRgstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EACRgstVO> models = new ArrayList<EACRgstVO>();
	
	/* Column Info */
	private String pIfStoCntrSzNm = null;
	/* Column Info */
	private String pIfIoBndCd = null;
	/* Column Info */
	private String n3ptyExpnTpCd = null;
	/* Column Info */
	private String audrUsrId = null;
	/* Column Info */
	private String pIfLgsCostCd = null;
	/* Column Info */
	private String eacRjctDesc = null;
	/* Column Info */
	private String pIfInvCfmDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String n3ptyOfcCd = null;
	/* Column Info */
	private String vndrCntcPntSeq = null;
	/* Column Info */
	private String pIfDcgoFlg = null;
	/* Column Info */
	private String eacAproTpCd = null;
	/* Column Info */
	private String n3ptySrcDt = null;
	/* Column Info */
	private String pIfSoNo = null;
	/* Column Info */
	private String fileflag = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String engAddr = null;
	/* Column Info */
	private String ntcKntCd = null;
	/* Column Info */
	private String pIfInvVndrSeq = null;
	/* Column Info */
	private String eqTpszCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String otsStsNm = null;
	/* Column Info */
	private String eacStsCd = null;
	/* Column Info */
	private String pIfInvNo = null;
	/* Column Info */
	private String tpbVndrCntCd = null;
	/* Column Info */
	private String soDtlSeq = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String woNoDesc = null;
	/* Column Info */
	private String pIfCalcTpCd = null;
	/* Column Info */
	private String eacRsnDesc = null;
	/* Column Info */
	private String pIfPortCd = null;
	/* Column Info */
	private String tpbOfcCd = null;
	/* Column Info */
	private String pIfRhndOfcCd = null;
	/* Column Info */
	private String eacAproStepSeq = null;
	/* Column Info */
	private String ofcEngNm = null;
	/* Column Info */
	private String eacRsnCd = null;
	/* Column Info */
	private String issCtyCd = null;
	/* Column Info */
	private String emlCtnt = null;
	/* Column Info */
	private String eacInpDt = null;
	/* Column Info */
	private String vndrCustDivCd = null;
	/* Column Info */
	private String ntcHisSeq = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String eacEmlUseFlg = null;
	/* Column Info */
	private String trdPartyNm = null;
	/* Column Info */
	private String eacDesc = null;
	/* Column Info */
	private String eacRjctRsn = null;
	/* Column Info */
	private String eacFaxUseFlg = null;
	/* Column Info */
	private String kpiOfcCd = null;
	/* Column Info */
	private String eacCmplCd = null;
	/* Column Info */
	private String tpbInvAmt = null;
	/* Column Info */
	private String invCngAmt = null;
	/* Column Info */
	private String eacSysIfCd = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String eacExpnTpCd = null;
	/* Column Info */
	private String atchFileId = null;
	/* Column Info */
	private String vndrEml = null;
	/* Column Info */
	private String eacBilTpCd = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String woNoCtnt = null;
	/* Column Info */
	private String emlSubjCtnt = null;
	/* Column Info */
	private String pIfTrspSoTpCd = null;
	/* Column Info */
	private String n3ptySrcNo = null;
	/* Column Info */
	private String eacRjctOfcCd = null;
	/* Column Info */
	private String isflag = null;
	/* Column Info */
	private String eacCostCdDesc = null;
	/* Column Info */
	private String pIfBkgNo = null;
	/* Column Info */
	private String vndrCntcPntNm = null;
	/* Column Info */
	private String pIfVvd = null;
	/* Column Info */
	private String pIfRcFlg = null;
	/* Column Info */
	private String pIfCalcCostGrpCd = null;
	/* Column Info */
	private String pIfCntrTpszCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String audrOfcCd = null;
	/* Column Info */
	private String eacRjctUsrNm = null;
	/* Column Info */
	private String eacStsNm = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String tpbVndrSeq = null;
	/* Column Info */
	private String stlToCltCngOfcCd = null;
	/* Column Info */
	private String n3ptyBilTpCd = null;
	/* Column Info */
	private String pIfTmlWrkDyCd = null;
	/* Column Info */
	private String diffInvAmt = null;
	/* Column Info */
	private String pIfRhndExpnSeq = null;
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String stlAmt = null;
	/* Column Info */
	private String pIfEqKndCd = null;
	/* Column Info */
	private String vvdDesc = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String eacCostDesc = null;
	/* Column Info */
	private String invAudAmt = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String expnEvidDesc = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String tpbVndrNm = null;
	/* Column Info */
	private String pIfMtyRtnYd = null;
	/* Column Info */
	private String pIfSubRailSeq = null;
	/* Column Info */
	private String ntcCcRcvEml = null;
	/* Column Info */
	private String vvdCdCtnt = null;
	/* Column Info */
	private String eacCmplFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String invAudUsdAmt = null;
	/* Column Info */
	private String pIfCostCd = null;
	/* Column Info */
	private String pIfClptIndSeq = null;
	/* Column Info */
	private String pIfCorrNo = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String eacRegUsrNm = null;
	/* Column Info */
	private String pIfExpnAudSeq = null;
	/* Column Info */
	private String eacYrmon = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String eacNo = null;
	/* Column Info */
	private String eacDtlSeq = null;
	/* Column Info */
	private String steNm = null;
	/* Column Info */
	private String pIfCntrNo = null;
	/* Column Info */
	private String eacInterRmk = null;
	/* Column Info */
	private String respbOfcCd = null;
	/* Column Info */
	private String pIfFpCalcPrdCd = null;
	/* Column Info */
	private String pIfWoNo = null;
	/* Column Info */
	private String eacTpCd = null;
	/* Column Info */
	private String trdPartyVal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EACRgstVO() {}

	public EACRgstVO(String ibflag, String pagerows, String eacRjctOfcCd, String audrUsrId, String n3ptyExpnTpCd, String isflag, String eacCostCdDesc, String vndrCntcPntNm, String blNo, String eacRjctDesc, String audrOfcCd, String eacStsNm, String eacRjctUsrNm, String n3ptyOfcCd, String vndrNm, String tpbVndrSeq, String stlToCltCngOfcCd, String n3ptyBilTpCd, String vndrCntcPntSeq, String diffInvAmt, String eacAproTpCd, String n3ptySrcDt, String fileflag, String custCntCd, String phnNo, String engAddr, String ntcKntCd, String status, String stlAmt, String custLglEngNm, String eqTpszCd, String vvdDesc, String eacStsCd, String otsStsNm, String bkgNo, String soDtlSeq, String tpbVndrCntCd, String eacCostDesc, String vndrSeq, String zipCd, String invAudAmt, String faxNo, String ctyNm, String woNoDesc, String eacRsnDesc, String expnEvidDesc, String tpbOfcCd, String currCd, String soSeq, String eacAproStepSeq, String vndrLglEngNm, String ofcEngNm, String eacRsnCd, String tpbVndrNm, String issCtyCd, String emlCtnt, String eacInpDt, String ntcCcRcvEml, String vvdCdCtnt, String vndrCustDivCd, String eacCmplFlg, String eqNo, String ntcHisSeq, String invAudUsdAmt, String n3ptyNo, String eacEmlUseFlg, String trdPartyNm, String invAmt, String eacDesc, String eacRegUsrNm, String eacRjctRsn, String eacFaxUseFlg, String eacCmplCd, String tpbInvAmt, String invCngAmt, String eacSysIfCd, String eacYrmon, String eqKndCd, String eacExpnTpCd, String custSeq, String atchFileId, String vndrEml, String eacNo, String eacBilTpCd, String eacDtlSeq, String steNm, String ydCd, String eacInterRmk, String respbOfcCd, String woNoCtnt, String eacTpCd, String emlSubjCtnt, String trdPartyVal, String n3ptySrcNo, String kpiOfcCd, String pIfSoNo, String pIfCostCd, String pIfVvd, String pIfPortCd, String pIfClptIndSeq, String pIfRhndExpnSeq, String pIfCntrNo, String pIfBkgNo, String pIfMtyRtnYd, String pIfRhndOfcCd, String pIfCorrNo, String pIfInvNo, String pIfInvVndrSeq, String pIfTrspSoTpCd, String pIfEqKndCd, String pIfWoNo, String pIfInvCfmDt, String pIfExpnAudSeq, String pIfCalcTpCd, String pIfLgsCostCd, String pIfCntrTpszCd, String pIfStoCntrSzNm, String pIfIoBndCd, String pIfDcgoFlg, String pIfRcFlg, String pIfTmlWrkDyCd, String pIfFpCalcPrdCd, String pIfCalcCostGrpCd, String pIfSubRailSeq) {
		this.pIfStoCntrSzNm = pIfStoCntrSzNm;
		this.pIfIoBndCd = pIfIoBndCd;
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
		this.audrUsrId = audrUsrId;
		this.pIfLgsCostCd = pIfLgsCostCd;
		this.eacRjctDesc = eacRjctDesc;
		this.pIfInvCfmDt = pIfInvCfmDt;
		this.pagerows = pagerows;
		this.n3ptyOfcCd = n3ptyOfcCd;
		this.vndrCntcPntSeq = vndrCntcPntSeq;
		this.pIfDcgoFlg = pIfDcgoFlg;
		this.eacAproTpCd = eacAproTpCd;
		this.n3ptySrcDt = n3ptySrcDt;
		this.pIfSoNo = pIfSoNo;
		this.fileflag = fileflag;
		this.custCntCd = custCntCd;
		this.engAddr = engAddr;
		this.ntcKntCd = ntcKntCd;
		this.pIfInvVndrSeq = pIfInvVndrSeq;
		this.eqTpszCd = eqTpszCd;
		this.custLglEngNm = custLglEngNm;
		this.bkgNo = bkgNo;
		this.otsStsNm = otsStsNm;
		this.eacStsCd = eacStsCd;
		this.pIfInvNo = pIfInvNo;
		this.tpbVndrCntCd = tpbVndrCntCd;
		this.soDtlSeq = soDtlSeq;
		this.zipCd = zipCd;
		this.woNoDesc = woNoDesc;
		this.pIfCalcTpCd = pIfCalcTpCd;
		this.eacRsnDesc = eacRsnDesc;
		this.pIfPortCd = pIfPortCd;
		this.tpbOfcCd = tpbOfcCd;
		this.pIfRhndOfcCd = pIfRhndOfcCd;
		this.eacAproStepSeq = eacAproStepSeq;
		this.ofcEngNm = ofcEngNm;
		this.eacRsnCd = eacRsnCd;
		this.issCtyCd = issCtyCd;
		this.emlCtnt = emlCtnt;
		this.eacInpDt = eacInpDt;
		this.vndrCustDivCd = vndrCustDivCd;
		this.ntcHisSeq = ntcHisSeq;
		this.n3ptyNo = n3ptyNo;
		this.eacEmlUseFlg = eacEmlUseFlg;
		this.trdPartyNm = trdPartyNm;
		this.eacDesc = eacDesc;
		this.eacRjctRsn = eacRjctRsn;
		this.eacFaxUseFlg = eacFaxUseFlg;
		this.kpiOfcCd = kpiOfcCd;
		this.eacCmplCd = eacCmplCd;
		this.tpbInvAmt = tpbInvAmt;
		this.invCngAmt = invCngAmt;
		this.eacSysIfCd = eacSysIfCd;
		this.eqKndCd = eqKndCd;
		this.eacExpnTpCd = eacExpnTpCd;
		this.atchFileId = atchFileId;
		this.vndrEml = vndrEml;
		this.eacBilTpCd = eacBilTpCd;
		this.ydCd = ydCd;
		this.woNoCtnt = woNoCtnt;
		this.emlSubjCtnt = emlSubjCtnt;
		this.pIfTrspSoTpCd = pIfTrspSoTpCd;
		this.n3ptySrcNo = n3ptySrcNo;
		this.eacRjctOfcCd = eacRjctOfcCd;
		this.isflag = isflag;
		this.eacCostCdDesc = eacCostCdDesc;
		this.pIfBkgNo = pIfBkgNo;
		this.vndrCntcPntNm = vndrCntcPntNm;
		this.pIfVvd = pIfVvd;
		this.pIfRcFlg = pIfRcFlg;
		this.pIfCalcCostGrpCd = pIfCalcCostGrpCd;
		this.pIfCntrTpszCd = pIfCntrTpszCd;
		this.blNo = blNo;
		this.audrOfcCd = audrOfcCd;
		this.eacRjctUsrNm = eacRjctUsrNm;
		this.eacStsNm = eacStsNm;
		this.vndrNm = vndrNm;
		this.tpbVndrSeq = tpbVndrSeq;
		this.stlToCltCngOfcCd = stlToCltCngOfcCd;
		this.n3ptyBilTpCd = n3ptyBilTpCd;
		this.pIfTmlWrkDyCd = pIfTmlWrkDyCd;
		this.diffInvAmt = diffInvAmt;
		this.pIfRhndExpnSeq = pIfRhndExpnSeq;
		this.phnNo = phnNo;
		this.status = status;
		this.stlAmt = stlAmt;
		this.pIfEqKndCd = pIfEqKndCd;
		this.vvdDesc = vvdDesc;
		this.vndrSeq = vndrSeq;
		this.eacCostDesc = eacCostDesc;
		this.invAudAmt = invAudAmt;
		this.faxNo = faxNo;
		this.ctyNm = ctyNm;
		this.expnEvidDesc = expnEvidDesc;
		this.currCd = currCd;
		this.soSeq = soSeq;
		this.vndrLglEngNm = vndrLglEngNm;
		this.tpbVndrNm = tpbVndrNm;
		this.pIfMtyRtnYd = pIfMtyRtnYd;
		this.pIfSubRailSeq = pIfSubRailSeq;
		this.ntcCcRcvEml = ntcCcRcvEml;
		this.vvdCdCtnt = vvdCdCtnt;
		this.eacCmplFlg = eacCmplFlg;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.invAudUsdAmt = invAudUsdAmt;
		this.pIfCostCd = pIfCostCd;
		this.pIfClptIndSeq = pIfClptIndSeq;
		this.pIfCorrNo = pIfCorrNo;
		this.invAmt = invAmt;
		this.eacRegUsrNm = eacRegUsrNm;
		this.pIfExpnAudSeq = pIfExpnAudSeq;
		this.eacYrmon = eacYrmon;
		this.custSeq = custSeq;
		this.eacNo = eacNo;
		this.eacDtlSeq = eacDtlSeq;
		this.steNm = steNm;
		this.pIfCntrNo = pIfCntrNo;
		this.eacInterRmk = eacInterRmk;
		this.respbOfcCd = respbOfcCd;
		this.pIfFpCalcPrdCd = pIfFpCalcPrdCd;
		this.pIfWoNo = pIfWoNo;
		this.eacTpCd = eacTpCd;
		this.trdPartyVal = trdPartyVal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("p_if_sto_cntr_sz_nm", getPIfStoCntrSzNm());
		this.hashColumns.put("p_if_io_bnd_cd", getPIfIoBndCd());
		this.hashColumns.put("n3pty_expn_tp_cd", getN3ptyExpnTpCd());
		this.hashColumns.put("audr_usr_id", getAudrUsrId());
		this.hashColumns.put("p_if_lgs_cost_cd", getPIfLgsCostCd());
		this.hashColumns.put("eac_rjct_desc", getEacRjctDesc());
		this.hashColumns.put("p_if_inv_cfm_dt", getPIfInvCfmDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("n3pty_ofc_cd", getN3ptyOfcCd());
		this.hashColumns.put("vndr_cntc_pnt_seq", getVndrCntcPntSeq());
		this.hashColumns.put("p_if_dcgo_flg", getPIfDcgoFlg());
		this.hashColumns.put("eac_apro_tp_cd", getEacAproTpCd());
		this.hashColumns.put("n3pty_src_dt", getN3ptySrcDt());
		this.hashColumns.put("p_if_so_no", getPIfSoNo());
		this.hashColumns.put("fileflag", getFileflag());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("eng_addr", getEngAddr());
		this.hashColumns.put("ntc_knt_cd", getNtcKntCd());
		this.hashColumns.put("p_if_inv_vndr_seq", getPIfInvVndrSeq());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ots_sts_nm", getOtsStsNm());
		this.hashColumns.put("eac_sts_cd", getEacStsCd());
		this.hashColumns.put("p_if_inv_no", getPIfInvNo());
		this.hashColumns.put("tpb_vndr_cnt_cd", getTpbVndrCntCd());
		this.hashColumns.put("so_dtl_seq", getSoDtlSeq());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("wo_no_desc", getWoNoDesc());
		this.hashColumns.put("p_if_calc_tp_cd", getPIfCalcTpCd());
		this.hashColumns.put("eac_rsn_desc", getEacRsnDesc());
		this.hashColumns.put("p_if_port_cd", getPIfPortCd());
		this.hashColumns.put("tpb_ofc_cd", getTpbOfcCd());
		this.hashColumns.put("p_if_rhnd_ofc_cd", getPIfRhndOfcCd());
		this.hashColumns.put("eac_apro_step_seq", getEacAproStepSeq());
		this.hashColumns.put("ofc_eng_nm", getOfcEngNm());
		this.hashColumns.put("eac_rsn_cd", getEacRsnCd());
		this.hashColumns.put("iss_cty_cd", getIssCtyCd());
		this.hashColumns.put("eml_ctnt", getEmlCtnt());
		this.hashColumns.put("eac_inp_dt", getEacInpDt());
		this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
		this.hashColumns.put("ntc_his_seq", getNtcHisSeq());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("eac_eml_use_flg", getEacEmlUseFlg());
		this.hashColumns.put("trd_party_nm", getTrdPartyNm());
		this.hashColumns.put("eac_desc", getEacDesc());
		this.hashColumns.put("eac_rjct_rsn", getEacRjctRsn());
		this.hashColumns.put("eac_fax_use_flg", getEacFaxUseFlg());
		this.hashColumns.put("kpi_ofc_cd", getKpiOfcCd());
		this.hashColumns.put("eac_cmpl_cd", getEacCmplCd());
		this.hashColumns.put("tpb_inv_amt", getTpbInvAmt());
		this.hashColumns.put("inv_cng_amt", getInvCngAmt());
		this.hashColumns.put("eac_sys_if_cd", getEacSysIfCd());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("eac_expn_tp_cd", getEacExpnTpCd());
		this.hashColumns.put("atch_file_id", getAtchFileId());
		this.hashColumns.put("vndr_eml", getVndrEml());
		this.hashColumns.put("eac_bil_tp_cd", getEacBilTpCd());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("wo_no_ctnt", getWoNoCtnt());
		this.hashColumns.put("eml_subj_ctnt", getEmlSubjCtnt());
		this.hashColumns.put("p_if_trsp_so_tp_cd", getPIfTrspSoTpCd());
		this.hashColumns.put("n3pty_src_no", getN3ptySrcNo());
		this.hashColumns.put("eac_rjct_ofc_cd", getEacRjctOfcCd());
		this.hashColumns.put("isflag", getIsflag());
		this.hashColumns.put("eac_cost_cd_desc", getEacCostCdDesc());
		this.hashColumns.put("p_if_bkg_no", getPIfBkgNo());
		this.hashColumns.put("vndr_cntc_pnt_nm", getVndrCntcPntNm());
		this.hashColumns.put("p_if_vvd", getPIfVvd());
		this.hashColumns.put("p_if_rc_flg", getPIfRcFlg());
		this.hashColumns.put("p_if_calc_cost_grp_cd", getPIfCalcCostGrpCd());
		this.hashColumns.put("p_if_cntr_tpsz_cd", getPIfCntrTpszCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("audr_ofc_cd", getAudrOfcCd());
		this.hashColumns.put("eac_rjct_usr_nm", getEacRjctUsrNm());
		this.hashColumns.put("eac_sts_nm", getEacStsNm());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("tpb_vndr_seq", getTpbVndrSeq());
		this.hashColumns.put("stl_to_clt_cng_ofc_cd", getStlToCltCngOfcCd());
		this.hashColumns.put("n3pty_bil_tp_cd", getN3ptyBilTpCd());
		this.hashColumns.put("p_if_tml_wrk_dy_cd", getPIfTmlWrkDyCd());
		this.hashColumns.put("diff_inv_amt", getDiffInvAmt());
		this.hashColumns.put("p_if_rhnd_expn_seq", getPIfRhndExpnSeq());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("stl_amt", getStlAmt());
		this.hashColumns.put("p_if_eq_knd_cd", getPIfEqKndCd());
		this.hashColumns.put("vvd_desc", getVvdDesc());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("eac_cost_desc", getEacCostDesc());
		this.hashColumns.put("inv_aud_amt", getInvAudAmt());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("expn_evid_desc", getExpnEvidDesc());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("tpb_vndr_nm", getTpbVndrNm());
		this.hashColumns.put("p_if_mty_rtn_yd", getPIfMtyRtnYd());
		this.hashColumns.put("p_if_sub_rail_seq", getPIfSubRailSeq());
		this.hashColumns.put("ntc_cc_rcv_eml", getNtcCcRcvEml());
		this.hashColumns.put("vvd_cd_ctnt", getVvdCdCtnt());
		this.hashColumns.put("eac_cmpl_flg", getEacCmplFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("inv_aud_usd_amt", getInvAudUsdAmt());
		this.hashColumns.put("p_if_cost_cd", getPIfCostCd());
		this.hashColumns.put("p_if_clpt_ind_seq", getPIfClptIndSeq());
		this.hashColumns.put("p_if_corr_no", getPIfCorrNo());
		this.hashColumns.put("inv_amt", getInvAmt());
		this.hashColumns.put("eac_reg_usr_nm", getEacRegUsrNm());
		this.hashColumns.put("p_if_expn_aud_seq", getPIfExpnAudSeq());
		this.hashColumns.put("eac_yrmon", getEacYrmon());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("eac_no", getEacNo());
		this.hashColumns.put("eac_dtl_seq", getEacDtlSeq());
		this.hashColumns.put("ste_nm", getSteNm());
		this.hashColumns.put("p_if_cntr_no", getPIfCntrNo());
		this.hashColumns.put("eac_inter_rmk", getEacInterRmk());
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());
		this.hashColumns.put("p_if_fp_calc_prd_cd", getPIfFpCalcPrdCd());
		this.hashColumns.put("p_if_wo_no", getPIfWoNo());
		this.hashColumns.put("eac_tp_cd", getEacTpCd());
		this.hashColumns.put("trd_party_val", getTrdPartyVal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("p_if_sto_cntr_sz_nm", "pIfStoCntrSzNm");
		this.hashFields.put("p_if_io_bnd_cd", "pIfIoBndCd");
		this.hashFields.put("n3pty_expn_tp_cd", "n3ptyExpnTpCd");
		this.hashFields.put("audr_usr_id", "audrUsrId");
		this.hashFields.put("p_if_lgs_cost_cd", "pIfLgsCostCd");
		this.hashFields.put("eac_rjct_desc", "eacRjctDesc");
		this.hashFields.put("p_if_inv_cfm_dt", "pIfInvCfmDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("n3pty_ofc_cd", "n3ptyOfcCd");
		this.hashFields.put("vndr_cntc_pnt_seq", "vndrCntcPntSeq");
		this.hashFields.put("p_if_dcgo_flg", "pIfDcgoFlg");
		this.hashFields.put("eac_apro_tp_cd", "eacAproTpCd");
		this.hashFields.put("n3pty_src_dt", "n3ptySrcDt");
		this.hashFields.put("p_if_so_no", "pIfSoNo");
		this.hashFields.put("fileflag", "fileflag");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("eng_addr", "engAddr");
		this.hashFields.put("ntc_knt_cd", "ntcKntCd");
		this.hashFields.put("p_if_inv_vndr_seq", "pIfInvVndrSeq");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ots_sts_nm", "otsStsNm");
		this.hashFields.put("eac_sts_cd", "eacStsCd");
		this.hashFields.put("p_if_inv_no", "pIfInvNo");
		this.hashFields.put("tpb_vndr_cnt_cd", "tpbVndrCntCd");
		this.hashFields.put("so_dtl_seq", "soDtlSeq");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("wo_no_desc", "woNoDesc");
		this.hashFields.put("p_if_calc_tp_cd", "pIfCalcTpCd");
		this.hashFields.put("eac_rsn_desc", "eacRsnDesc");
		this.hashFields.put("p_if_port_cd", "pIfPortCd");
		this.hashFields.put("tpb_ofc_cd", "tpbOfcCd");
		this.hashFields.put("p_if_rhnd_ofc_cd", "pIfRhndOfcCd");
		this.hashFields.put("eac_apro_step_seq", "eacAproStepSeq");
		this.hashFields.put("ofc_eng_nm", "ofcEngNm");
		this.hashFields.put("eac_rsn_cd", "eacRsnCd");
		this.hashFields.put("iss_cty_cd", "issCtyCd");
		this.hashFields.put("eml_ctnt", "emlCtnt");
		this.hashFields.put("eac_inp_dt", "eacInpDt");
		this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
		this.hashFields.put("ntc_his_seq", "ntcHisSeq");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("eac_eml_use_flg", "eacEmlUseFlg");
		this.hashFields.put("trd_party_nm", "trdPartyNm");
		this.hashFields.put("eac_desc", "eacDesc");
		this.hashFields.put("eac_rjct_rsn", "eacRjctRsn");
		this.hashFields.put("eac_fax_use_flg", "eacFaxUseFlg");
		this.hashFields.put("kpi_ofc_cd", "kpiOfcCd");
		this.hashFields.put("eac_cmpl_cd", "eacCmplCd");
		this.hashFields.put("tpb_inv_amt", "tpbInvAmt");
		this.hashFields.put("inv_cng_amt", "invCngAmt");
		this.hashFields.put("eac_sys_if_cd", "eacSysIfCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("eac_expn_tp_cd", "eacExpnTpCd");
		this.hashFields.put("atch_file_id", "atchFileId");
		this.hashFields.put("vndr_eml", "vndrEml");
		this.hashFields.put("eac_bil_tp_cd", "eacBilTpCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("wo_no_ctnt", "woNoCtnt");
		this.hashFields.put("eml_subj_ctnt", "emlSubjCtnt");
		this.hashFields.put("p_if_trsp_so_tp_cd", "pIfTrspSoTpCd");
		this.hashFields.put("n3pty_src_no", "n3ptySrcNo");
		this.hashFields.put("eac_rjct_ofc_cd", "eacRjctOfcCd");
		this.hashFields.put("isflag", "isflag");
		this.hashFields.put("eac_cost_cd_desc", "eacCostCdDesc");
		this.hashFields.put("p_if_bkg_no", "pIfBkgNo");
		this.hashFields.put("vndr_cntc_pnt_nm", "vndrCntcPntNm");
		this.hashFields.put("p_if_vvd", "pIfVvd");
		this.hashFields.put("p_if_rc_flg", "pIfRcFlg");
		this.hashFields.put("p_if_calc_cost_grp_cd", "pIfCalcCostGrpCd");
		this.hashFields.put("p_if_cntr_tpsz_cd", "pIfCntrTpszCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("audr_ofc_cd", "audrOfcCd");
		this.hashFields.put("eac_rjct_usr_nm", "eacRjctUsrNm");
		this.hashFields.put("eac_sts_nm", "eacStsNm");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("tpb_vndr_seq", "tpbVndrSeq");
		this.hashFields.put("stl_to_clt_cng_ofc_cd", "stlToCltCngOfcCd");
		this.hashFields.put("n3pty_bil_tp_cd", "n3ptyBilTpCd");
		this.hashFields.put("p_if_tml_wrk_dy_cd", "pIfTmlWrkDyCd");
		this.hashFields.put("diff_inv_amt", "diffInvAmt");
		this.hashFields.put("p_if_rhnd_expn_seq", "pIfRhndExpnSeq");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("status", "status");
		this.hashFields.put("stl_amt", "stlAmt");
		this.hashFields.put("p_if_eq_knd_cd", "pIfEqKndCd");
		this.hashFields.put("vvd_desc", "vvdDesc");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("eac_cost_desc", "eacCostDesc");
		this.hashFields.put("inv_aud_amt", "invAudAmt");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("expn_evid_desc", "expnEvidDesc");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("tpb_vndr_nm", "tpbVndrNm");
		this.hashFields.put("p_if_mty_rtn_yd", "pIfMtyRtnYd");
		this.hashFields.put("p_if_sub_rail_seq", "pIfSubRailSeq");
		this.hashFields.put("ntc_cc_rcv_eml", "ntcCcRcvEml");
		this.hashFields.put("vvd_cd_ctnt", "vvdCdCtnt");
		this.hashFields.put("eac_cmpl_flg", "eacCmplFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("inv_aud_usd_amt", "invAudUsdAmt");
		this.hashFields.put("p_if_cost_cd", "pIfCostCd");
		this.hashFields.put("p_if_clpt_ind_seq", "pIfClptIndSeq");
		this.hashFields.put("p_if_corr_no", "pIfCorrNo");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("eac_reg_usr_nm", "eacRegUsrNm");
		this.hashFields.put("p_if_expn_aud_seq", "pIfExpnAudSeq");
		this.hashFields.put("eac_yrmon", "eacYrmon");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("eac_no", "eacNo");
		this.hashFields.put("eac_dtl_seq", "eacDtlSeq");
		this.hashFields.put("ste_nm", "steNm");
		this.hashFields.put("p_if_cntr_no", "pIfCntrNo");
		this.hashFields.put("eac_inter_rmk", "eacInterRmk");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("p_if_fp_calc_prd_cd", "pIfFpCalcPrdCd");
		this.hashFields.put("p_if_wo_no", "pIfWoNo");
		this.hashFields.put("eac_tp_cd", "eacTpCd");
		this.hashFields.put("trd_party_val", "trdPartyVal");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return pIfStoCntrSzNm
	 */
	public String getPIfStoCntrSzNm() {
		return this.pIfStoCntrSzNm;
	}
	
	/**
	 * Column Info
	 * @return pIfIoBndCd
	 */
	public String getPIfIoBndCd() {
		return this.pIfIoBndCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyExpnTpCd
	 */
	public String getN3ptyExpnTpCd() {
		return this.n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return audrUsrId
	 */
	public String getAudrUsrId() {
		return this.audrUsrId;
	}
	
	/**
	 * Column Info
	 * @return pIfLgsCostCd
	 */
	public String getPIfLgsCostCd() {
		return this.pIfLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @return eacRjctDesc
	 */
	public String getEacRjctDesc() {
		return this.eacRjctDesc;
	}
	
	/**
	 * Column Info
	 * @return pIfInvCfmDt
	 */
	public String getPIfInvCfmDt() {
		return this.pIfInvCfmDt;
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
	 * @return n3ptyOfcCd
	 */
	public String getN3ptyOfcCd() {
		return this.n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @return vndrCntcPntSeq
	 */
	public String getVndrCntcPntSeq() {
		return this.vndrCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @return pIfDcgoFlg
	 */
	public String getPIfDcgoFlg() {
		return this.pIfDcgoFlg;
	}
	
	/**
	 * Column Info
	 * @return eacAproTpCd
	 */
	public String getEacAproTpCd() {
		return this.eacAproTpCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcDt
	 */
	public String getN3ptySrcDt() {
		return this.n3ptySrcDt;
	}
	
	/**
	 * Column Info
	 * @return pIfSoNo
	 */
	public String getPIfSoNo() {
		return this.pIfSoNo;
	}
	
	/**
	 * Column Info
	 * @return fileflag
	 */
	public String getFileflag() {
		return this.fileflag;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return engAddr
	 */
	public String getEngAddr() {
		return this.engAddr;
	}
	
	/**
	 * Column Info
	 * @return ntcKntCd
	 */
	public String getNtcKntCd() {
		return this.ntcKntCd;
	}
	
	/**
	 * Column Info
	 * @return pIfInvVndrSeq
	 */
	public String getPIfInvVndrSeq() {
		return this.pIfInvVndrSeq;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
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
	 * @return otsStsNm
	 */
	public String getOtsStsNm() {
		return this.otsStsNm;
	}
	
	/**
	 * Column Info
	 * @return eacStsCd
	 */
	public String getEacStsCd() {
		return this.eacStsCd;
	}
	
	/**
	 * Column Info
	 * @return pIfInvNo
	 */
	public String getPIfInvNo() {
		return this.pIfInvNo;
	}
	
	/**
	 * Column Info
	 * @return tpbVndrCntCd
	 */
	public String getTpbVndrCntCd() {
		return this.tpbVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @return soDtlSeq
	 */
	public String getSoDtlSeq() {
		return this.soDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return woNoDesc
	 */
	public String getWoNoDesc() {
		return this.woNoDesc;
	}
	
	/**
	 * Column Info
	 * @return pIfCalcTpCd
	 */
	public String getPIfCalcTpCd() {
		return this.pIfCalcTpCd;
	}
	
	/**
	 * Column Info
	 * @return eacRsnDesc
	 */
	public String getEacRsnDesc() {
		return this.eacRsnDesc;
	}
	
	/**
	 * Column Info
	 * @return pIfPortCd
	 */
	public String getPIfPortCd() {
		return this.pIfPortCd;
	}
	
	/**
	 * Column Info
	 * @return tpbOfcCd
	 */
	public String getTpbOfcCd() {
		return this.tpbOfcCd;
	}
	
	/**
	 * Column Info
	 * @return pIfRhndOfcCd
	 */
	public String getPIfRhndOfcCd() {
		return this.pIfRhndOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eacAproStepSeq
	 */
	public String getEacAproStepSeq() {
		return this.eacAproStepSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcEngNm
	 */
	public String getOfcEngNm() {
		return this.ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @return eacRsnCd
	 */
	public String getEacRsnCd() {
		return this.eacRsnCd;
	}
	
	/**
	 * Column Info
	 * @return issCtyCd
	 */
	public String getIssCtyCd() {
		return this.issCtyCd;
	}
	
	/**
	 * Column Info
	 * @return emlCtnt
	 */
	public String getEmlCtnt() {
		return this.emlCtnt;
	}
	
	/**
	 * Column Info
	 * @return eacInpDt
	 */
	public String getEacInpDt() {
		return this.eacInpDt;
	}
	
	/**
	 * Column Info
	 * @return vndrCustDivCd
	 */
	public String getVndrCustDivCd() {
		return this.vndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @return ntcHisSeq
	 */
	public String getNtcHisSeq() {
		return this.ntcHisSeq;
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
	 * @return eacEmlUseFlg
	 */
	public String getEacEmlUseFlg() {
		return this.eacEmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @return trdPartyNm
	 */
	public String getTrdPartyNm() {
		return this.trdPartyNm;
	}
	
	/**
	 * Column Info
	 * @return eacDesc
	 */
	public String getEacDesc() {
		return this.eacDesc;
	}
	
	/**
	 * Column Info
	 * @return eacRjctRsn
	 */
	public String getEacRjctRsn() {
		return this.eacRjctRsn;
	}
	
	/**
	 * Column Info
	 * @return eacFaxUseFlg
	 */
	public String getEacFaxUseFlg() {
		return this.eacFaxUseFlg;
	}
	
	/**
	 * Column Info
	 * @return kpiOfcCd
	 */
	public String getKpiOfcCd() {
		return this.kpiOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eacCmplCd
	 */
	public String getEacCmplCd() {
		return this.eacCmplCd;
	}
	
	/**
	 * Column Info
	 * @return tpbInvAmt
	 */
	public String getTpbInvAmt() {
		return this.tpbInvAmt;
	}
	
	/**
	 * Column Info
	 * @return invCngAmt
	 */
	public String getInvCngAmt() {
		return this.invCngAmt;
	}
	
	/**
	 * Column Info
	 * @return eacSysIfCd
	 */
	public String getEacSysIfCd() {
		return this.eacSysIfCd;
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
	 * @return eacExpnTpCd
	 */
	public String getEacExpnTpCd() {
		return this.eacExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @return atchFileId
	 */
	public String getAtchFileId() {
		return this.atchFileId;
	}
	
	/**
	 * Column Info
	 * @return vndrEml
	 */
	public String getVndrEml() {
		return this.vndrEml;
	}
	
	/**
	 * Column Info
	 * @return eacBilTpCd
	 */
	public String getEacBilTpCd() {
		return this.eacBilTpCd;
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
	 * @return woNoCtnt
	 */
	public String getWoNoCtnt() {
		return this.woNoCtnt;
	}
	
	/**
	 * Column Info
	 * @return emlSubjCtnt
	 */
	public String getEmlSubjCtnt() {
		return this.emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @return pIfTrspSoTpCd
	 */
	public String getPIfTrspSoTpCd() {
		return this.pIfTrspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptySrcNo
	 */
	public String getN3ptySrcNo() {
		return this.n3ptySrcNo;
	}
	
	/**
	 * Column Info
	 * @return eacRjctOfcCd
	 */
	public String getEacRjctOfcCd() {
		return this.eacRjctOfcCd;
	}
	
	/**
	 * Column Info
	 * @return isflag
	 */
	public String getIsflag() {
		return this.isflag;
	}
	
	/**
	 * Column Info
	 * @return eacCostCdDesc
	 */
	public String getEacCostCdDesc() {
		return this.eacCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @return pIfBkgNo
	 */
	public String getPIfBkgNo() {
		return this.pIfBkgNo;
	}
	
	/**
	 * Column Info
	 * @return vndrCntcPntNm
	 */
	public String getVndrCntcPntNm() {
		return this.vndrCntcPntNm;
	}
	
	/**
	 * Column Info
	 * @return pIfVvd
	 */
	public String getPIfVvd() {
		return this.pIfVvd;
	}
	
	/**
	 * Column Info
	 * @return pIfRcFlg
	 */
	public String getPIfRcFlg() {
		return this.pIfRcFlg;
	}
	
	/**
	 * Column Info
	 * @return pIfCalcCostGrpCd
	 */
	public String getPIfCalcCostGrpCd() {
		return this.pIfCalcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @return pIfCntrTpszCd
	 */
	public String getPIfCntrTpszCd() {
		return this.pIfCntrTpszCd;
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
	 * @return audrOfcCd
	 */
	public String getAudrOfcCd() {
		return this.audrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return eacRjctUsrNm
	 */
	public String getEacRjctUsrNm() {
		return this.eacRjctUsrNm;
	}
	
	/**
	 * Column Info
	 * @return eacStsNm
	 */
	public String getEacStsNm() {
		return this.eacStsNm;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return tpbVndrSeq
	 */
	public String getTpbVndrSeq() {
		return this.tpbVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return stlToCltCngOfcCd
	 */
	public String getStlToCltCngOfcCd() {
		return this.stlToCltCngOfcCd;
	}
	
	/**
	 * Column Info
	 * @return n3ptyBilTpCd
	 */
	public String getN3ptyBilTpCd() {
		return this.n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @return pIfTmlWrkDyCd
	 */
	public String getPIfTmlWrkDyCd() {
		return this.pIfTmlWrkDyCd;
	}
	
	/**
	 * Column Info
	 * @return diffInvAmt
	 */
	public String getDiffInvAmt() {
		return this.diffInvAmt;
	}
	
	/**
	 * Column Info
	 * @return pIfRhndExpnSeq
	 */
	public String getPIfRhndExpnSeq() {
		return this.pIfRhndExpnSeq;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return stlAmt
	 */
	public String getStlAmt() {
		return this.stlAmt;
	}
	
	/**
	 * Column Info
	 * @return pIfEqKndCd
	 */
	public String getPIfEqKndCd() {
		return this.pIfEqKndCd;
	}
	
	/**
	 * Column Info
	 * @return vvdDesc
	 */
	public String getVvdDesc() {
		return this.vvdDesc;
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
	 * @return eacCostDesc
	 */
	public String getEacCostDesc() {
		return this.eacCostDesc;
	}
	
	/**
	 * Column Info
	 * @return invAudAmt
	 */
	public String getInvAudAmt() {
		return this.invAudAmt;
	}
	
	/**
	 * Column Info
	 * @return faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 * Column Info
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
	}
	
	/**
	 * Column Info
	 * @return expnEvidDesc
	 */
	public String getExpnEvidDesc() {
		return this.expnEvidDesc;
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
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}
	
	/**
	 * Column Info
	 * @return vndrLglEngNm
	 */
	public String getVndrLglEngNm() {
		return this.vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return tpbVndrNm
	 */
	public String getTpbVndrNm() {
		return this.tpbVndrNm;
	}
	
	/**
	 * Column Info
	 * @return pIfMtyRtnYd
	 */
	public String getPIfMtyRtnYd() {
		return this.pIfMtyRtnYd;
	}
	
	/**
	 * Column Info
	 * @return pIfSubRailSeq
	 */
	public String getPIfSubRailSeq() {
		return this.pIfSubRailSeq;
	}
	
	/**
	 * Column Info
	 * @return ntcCcRcvEml
	 */
	public String getNtcCcRcvEml() {
		return this.ntcCcRcvEml;
	}
	
	/**
	 * Column Info
	 * @return vvdCdCtnt
	 */
	public String getVvdCdCtnt() {
		return this.vvdCdCtnt;
	}
	
	/**
	 * Column Info
	 * @return eacCmplFlg
	 */
	public String getEacCmplFlg() {
		return this.eacCmplFlg;
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
	 * @return invAudUsdAmt
	 */
	public String getInvAudUsdAmt() {
		return this.invAudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return pIfCostCd
	 */
	public String getPIfCostCd() {
		return this.pIfCostCd;
	}
	
	/**
	 * Column Info
	 * @return pIfClptIndSeq
	 */
	public String getPIfClptIndSeq() {
		return this.pIfClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return pIfCorrNo
	 */
	public String getPIfCorrNo() {
		return this.pIfCorrNo;
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
	 * @return eacRegUsrNm
	 */
	public String getEacRegUsrNm() {
		return this.eacRegUsrNm;
	}
	
	/**
	 * Column Info
	 * @return pIfExpnAudSeq
	 */
	public String getPIfExpnAudSeq() {
		return this.pIfExpnAudSeq;
	}
	
	/**
	 * Column Info
	 * @return eacYrmon
	 */
	public String getEacYrmon() {
		return this.eacYrmon;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return eacNo
	 */
	public String getEacNo() {
		return this.eacNo;
	}
	
	/**
	 * Column Info
	 * @return eacDtlSeq
	 */
	public String getEacDtlSeq() {
		return this.eacDtlSeq;
	}
	
	/**
	 * Column Info
	 * @return steNm
	 */
	public String getSteNm() {
		return this.steNm;
	}
	
	/**
	 * Column Info
	 * @return pIfCntrNo
	 */
	public String getPIfCntrNo() {
		return this.pIfCntrNo;
	}
	
	/**
	 * Column Info
	 * @return eacInterRmk
	 */
	public String getEacInterRmk() {
		return this.eacInterRmk;
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
	 * @return pIfFpCalcPrdCd
	 */
	public String getPIfFpCalcPrdCd() {
		return this.pIfFpCalcPrdCd;
	}
	
	/**
	 * Column Info
	 * @return pIfWoNo
	 */
	public String getPIfWoNo() {
		return this.pIfWoNo;
	}
	
	/**
	 * Column Info
	 * @return eacTpCd
	 */
	public String getEacTpCd() {
		return this.eacTpCd;
	}
	
	/**
	 * Column Info
	 * @return trdPartyVal
	 */
	public String getTrdPartyVal() {
		return this.trdPartyVal;
	}
	

	/**
	 * Column Info
	 * @param pIfStoCntrSzNm
	 */
	public void setPIfStoCntrSzNm(String pIfStoCntrSzNm) {
		this.pIfStoCntrSzNm = pIfStoCntrSzNm;
	}
	
	/**
	 * Column Info
	 * @param pIfIoBndCd
	 */
	public void setPIfIoBndCd(String pIfIoBndCd) {
		this.pIfIoBndCd = pIfIoBndCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyExpnTpCd
	 */
	public void setN3ptyExpnTpCd(String n3ptyExpnTpCd) {
		this.n3ptyExpnTpCd = n3ptyExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param audrUsrId
	 */
	public void setAudrUsrId(String audrUsrId) {
		this.audrUsrId = audrUsrId;
	}
	
	/**
	 * Column Info
	 * @param pIfLgsCostCd
	 */
	public void setPIfLgsCostCd(String pIfLgsCostCd) {
		this.pIfLgsCostCd = pIfLgsCostCd;
	}
	
	/**
	 * Column Info
	 * @param eacRjctDesc
	 */
	public void setEacRjctDesc(String eacRjctDesc) {
		this.eacRjctDesc = eacRjctDesc;
	}
	
	/**
	 * Column Info
	 * @param pIfInvCfmDt
	 */
	public void setPIfInvCfmDt(String pIfInvCfmDt) {
		this.pIfInvCfmDt = pIfInvCfmDt;
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
	 * @param n3ptyOfcCd
	 */
	public void setN3ptyOfcCd(String n3ptyOfcCd) {
		this.n3ptyOfcCd = n3ptyOfcCd;
	}
	
	/**
	 * Column Info
	 * @param vndrCntcPntSeq
	 */
	public void setVndrCntcPntSeq(String vndrCntcPntSeq) {
		this.vndrCntcPntSeq = vndrCntcPntSeq;
	}
	
	/**
	 * Column Info
	 * @param pIfDcgoFlg
	 */
	public void setPIfDcgoFlg(String pIfDcgoFlg) {
		this.pIfDcgoFlg = pIfDcgoFlg;
	}
	
	/**
	 * Column Info
	 * @param eacAproTpCd
	 */
	public void setEacAproTpCd(String eacAproTpCd) {
		this.eacAproTpCd = eacAproTpCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcDt
	 */
	public void setN3ptySrcDt(String n3ptySrcDt) {
		this.n3ptySrcDt = n3ptySrcDt;
	}
	
	/**
	 * Column Info
	 * @param pIfSoNo
	 */
	public void setPIfSoNo(String pIfSoNo) {
		this.pIfSoNo = pIfSoNo;
	}
	
	/**
	 * Column Info
	 * @param fileflag
	 */
	public void setFileflag(String fileflag) {
		this.fileflag = fileflag;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param engAddr
	 */
	public void setEngAddr(String engAddr) {
		this.engAddr = engAddr;
	}
	
	/**
	 * Column Info
	 * @param ntcKntCd
	 */
	public void setNtcKntCd(String ntcKntCd) {
		this.ntcKntCd = ntcKntCd;
	}
	
	/**
	 * Column Info
	 * @param pIfInvVndrSeq
	 */
	public void setPIfInvVndrSeq(String pIfInvVndrSeq) {
		this.pIfInvVndrSeq = pIfInvVndrSeq;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
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
	 * @param otsStsNm
	 */
	public void setOtsStsNm(String otsStsNm) {
		this.otsStsNm = otsStsNm;
	}
	
	/**
	 * Column Info
	 * @param eacStsCd
	 */
	public void setEacStsCd(String eacStsCd) {
		this.eacStsCd = eacStsCd;
	}
	
	/**
	 * Column Info
	 * @param pIfInvNo
	 */
	public void setPIfInvNo(String pIfInvNo) {
		this.pIfInvNo = pIfInvNo;
	}
	
	/**
	 * Column Info
	 * @param tpbVndrCntCd
	 */
	public void setTpbVndrCntCd(String tpbVndrCntCd) {
		this.tpbVndrCntCd = tpbVndrCntCd;
	}
	
	/**
	 * Column Info
	 * @param soDtlSeq
	 */
	public void setSoDtlSeq(String soDtlSeq) {
		this.soDtlSeq = soDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param woNoDesc
	 */
	public void setWoNoDesc(String woNoDesc) {
		this.woNoDesc = woNoDesc;
	}
	
	/**
	 * Column Info
	 * @param pIfCalcTpCd
	 */
	public void setPIfCalcTpCd(String pIfCalcTpCd) {
		this.pIfCalcTpCd = pIfCalcTpCd;
	}
	
	/**
	 * Column Info
	 * @param eacRsnDesc
	 */
	public void setEacRsnDesc(String eacRsnDesc) {
		this.eacRsnDesc = eacRsnDesc;
	}
	
	/**
	 * Column Info
	 * @param pIfPortCd
	 */
	public void setPIfPortCd(String pIfPortCd) {
		this.pIfPortCd = pIfPortCd;
	}
	
	/**
	 * Column Info
	 * @param tpbOfcCd
	 */
	public void setTpbOfcCd(String tpbOfcCd) {
		this.tpbOfcCd = tpbOfcCd;
	}
	
	/**
	 * Column Info
	 * @param pIfRhndOfcCd
	 */
	public void setPIfRhndOfcCd(String pIfRhndOfcCd) {
		this.pIfRhndOfcCd = pIfRhndOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eacAproStepSeq
	 */
	public void setEacAproStepSeq(String eacAproStepSeq) {
		this.eacAproStepSeq = eacAproStepSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcEngNm
	 */
	public void setOfcEngNm(String ofcEngNm) {
		this.ofcEngNm = ofcEngNm;
	}
	
	/**
	 * Column Info
	 * @param eacRsnCd
	 */
	public void setEacRsnCd(String eacRsnCd) {
		this.eacRsnCd = eacRsnCd;
	}
	
	/**
	 * Column Info
	 * @param issCtyCd
	 */
	public void setIssCtyCd(String issCtyCd) {
		this.issCtyCd = issCtyCd;
	}
	
	/**
	 * Column Info
	 * @param emlCtnt
	 */
	public void setEmlCtnt(String emlCtnt) {
		this.emlCtnt = emlCtnt;
	}
	
	/**
	 * Column Info
	 * @param eacInpDt
	 */
	public void setEacInpDt(String eacInpDt) {
		this.eacInpDt = eacInpDt;
	}
	
	/**
	 * Column Info
	 * @param vndrCustDivCd
	 */
	public void setVndrCustDivCd(String vndrCustDivCd) {
		this.vndrCustDivCd = vndrCustDivCd;
	}
	
	/**
	 * Column Info
	 * @param ntcHisSeq
	 */
	public void setNtcHisSeq(String ntcHisSeq) {
		this.ntcHisSeq = ntcHisSeq;
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
	 * @param eacEmlUseFlg
	 */
	public void setEacEmlUseFlg(String eacEmlUseFlg) {
		this.eacEmlUseFlg = eacEmlUseFlg;
	}
	
	/**
	 * Column Info
	 * @param trdPartyNm
	 */
	public void setTrdPartyNm(String trdPartyNm) {
		this.trdPartyNm = trdPartyNm;
	}
	
	/**
	 * Column Info
	 * @param eacDesc
	 */
	public void setEacDesc(String eacDesc) {
		this.eacDesc = eacDesc;
	}
	
	/**
	 * Column Info
	 * @param eacRjctRsn
	 */
	public void setEacRjctRsn(String eacRjctRsn) {
		this.eacRjctRsn = eacRjctRsn;
	}
	
	/**
	 * Column Info
	 * @param eacFaxUseFlg
	 */
	public void setEacFaxUseFlg(String eacFaxUseFlg) {
		this.eacFaxUseFlg = eacFaxUseFlg;
	}
	
	/**
	 * Column Info
	 * @param kpiOfcCd
	 */
	public void setKpiOfcCd(String kpiOfcCd) {
		this.kpiOfcCd = kpiOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eacCmplCd
	 */
	public void setEacCmplCd(String eacCmplCd) {
		this.eacCmplCd = eacCmplCd;
	}
	
	/**
	 * Column Info
	 * @param tpbInvAmt
	 */
	public void setTpbInvAmt(String tpbInvAmt) {
		this.tpbInvAmt = tpbInvAmt;
	}
	
	/**
	 * Column Info
	 * @param invCngAmt
	 */
	public void setInvCngAmt(String invCngAmt) {
		this.invCngAmt = invCngAmt;
	}
	
	/**
	 * Column Info
	 * @param eacSysIfCd
	 */
	public void setEacSysIfCd(String eacSysIfCd) {
		this.eacSysIfCd = eacSysIfCd;
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
	 * @param eacExpnTpCd
	 */
	public void setEacExpnTpCd(String eacExpnTpCd) {
		this.eacExpnTpCd = eacExpnTpCd;
	}
	
	/**
	 * Column Info
	 * @param atchFileId
	 */
	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}
	
	/**
	 * Column Info
	 * @param vndrEml
	 */
	public void setVndrEml(String vndrEml) {
		this.vndrEml = vndrEml;
	}
	
	/**
	 * Column Info
	 * @param eacBilTpCd
	 */
	public void setEacBilTpCd(String eacBilTpCd) {
		this.eacBilTpCd = eacBilTpCd;
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
	 * @param woNoCtnt
	 */
	public void setWoNoCtnt(String woNoCtnt) {
		this.woNoCtnt = woNoCtnt;
	}
	
	/**
	 * Column Info
	 * @param emlSubjCtnt
	 */
	public void setEmlSubjCtnt(String emlSubjCtnt) {
		this.emlSubjCtnt = emlSubjCtnt;
	}
	
	/**
	 * Column Info
	 * @param pIfTrspSoTpCd
	 */
	public void setPIfTrspSoTpCd(String pIfTrspSoTpCd) {
		this.pIfTrspSoTpCd = pIfTrspSoTpCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptySrcNo
	 */
	public void setN3ptySrcNo(String n3ptySrcNo) {
		this.n3ptySrcNo = n3ptySrcNo;
	}
	
	/**
	 * Column Info
	 * @param eacRjctOfcCd
	 */
	public void setEacRjctOfcCd(String eacRjctOfcCd) {
		this.eacRjctOfcCd = eacRjctOfcCd;
	}
	
	/**
	 * Column Info
	 * @param isflag
	 */
	public void setIsflag(String isflag) {
		this.isflag = isflag;
	}
	
	/**
	 * Column Info
	 * @param eacCostCdDesc
	 */
	public void setEacCostCdDesc(String eacCostCdDesc) {
		this.eacCostCdDesc = eacCostCdDesc;
	}
	
	/**
	 * Column Info
	 * @param pIfBkgNo
	 */
	public void setPIfBkgNo(String pIfBkgNo) {
		this.pIfBkgNo = pIfBkgNo;
	}
	
	/**
	 * Column Info
	 * @param vndrCntcPntNm
	 */
	public void setVndrCntcPntNm(String vndrCntcPntNm) {
		this.vndrCntcPntNm = vndrCntcPntNm;
	}
	
	/**
	 * Column Info
	 * @param pIfVvd
	 */
	public void setPIfVvd(String pIfVvd) {
		this.pIfVvd = pIfVvd;
	}
	
	/**
	 * Column Info
	 * @param pIfRcFlg
	 */
	public void setPIfRcFlg(String pIfRcFlg) {
		this.pIfRcFlg = pIfRcFlg;
	}
	
	/**
	 * Column Info
	 * @param pIfCalcCostGrpCd
	 */
	public void setPIfCalcCostGrpCd(String pIfCalcCostGrpCd) {
		this.pIfCalcCostGrpCd = pIfCalcCostGrpCd;
	}
	
	/**
	 * Column Info
	 * @param pIfCntrTpszCd
	 */
	public void setPIfCntrTpszCd(String pIfCntrTpszCd) {
		this.pIfCntrTpszCd = pIfCntrTpszCd;
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
	 * @param audrOfcCd
	 */
	public void setAudrOfcCd(String audrOfcCd) {
		this.audrOfcCd = audrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param eacRjctUsrNm
	 */
	public void setEacRjctUsrNm(String eacRjctUsrNm) {
		this.eacRjctUsrNm = eacRjctUsrNm;
	}
	
	/**
	 * Column Info
	 * @param eacStsNm
	 */
	public void setEacStsNm(String eacStsNm) {
		this.eacStsNm = eacStsNm;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param tpbVndrSeq
	 */
	public void setTpbVndrSeq(String tpbVndrSeq) {
		this.tpbVndrSeq = tpbVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param stlToCltCngOfcCd
	 */
	public void setStlToCltCngOfcCd(String stlToCltCngOfcCd) {
		this.stlToCltCngOfcCd = stlToCltCngOfcCd;
	}
	
	/**
	 * Column Info
	 * @param n3ptyBilTpCd
	 */
	public void setN3ptyBilTpCd(String n3ptyBilTpCd) {
		this.n3ptyBilTpCd = n3ptyBilTpCd;
	}
	
	/**
	 * Column Info
	 * @param pIfTmlWrkDyCd
	 */
	public void setPIfTmlWrkDyCd(String pIfTmlWrkDyCd) {
		this.pIfTmlWrkDyCd = pIfTmlWrkDyCd;
	}
	
	/**
	 * Column Info
	 * @param diffInvAmt
	 */
	public void setDiffInvAmt(String diffInvAmt) {
		this.diffInvAmt = diffInvAmt;
	}
	
	/**
	 * Column Info
	 * @param pIfRhndExpnSeq
	 */
	public void setPIfRhndExpnSeq(String pIfRhndExpnSeq) {
		this.pIfRhndExpnSeq = pIfRhndExpnSeq;
	}
	
	/**
	 * Column Info
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param stlAmt
	 */
	public void setStlAmt(String stlAmt) {
		this.stlAmt = stlAmt;
	}
	
	/**
	 * Column Info
	 * @param pIfEqKndCd
	 */
	public void setPIfEqKndCd(String pIfEqKndCd) {
		this.pIfEqKndCd = pIfEqKndCd;
	}
	
	/**
	 * Column Info
	 * @param vvdDesc
	 */
	public void setVvdDesc(String vvdDesc) {
		this.vvdDesc = vvdDesc;
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
	 * @param eacCostDesc
	 */
	public void setEacCostDesc(String eacCostDesc) {
		this.eacCostDesc = eacCostDesc;
	}
	
	/**
	 * Column Info
	 * @param invAudAmt
	 */
	public void setInvAudAmt(String invAudAmt) {
		this.invAudAmt = invAudAmt;
	}
	
	/**
	 * Column Info
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * Column Info
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
	}
	
	/**
	 * Column Info
	 * @param expnEvidDesc
	 */
	public void setExpnEvidDesc(String expnEvidDesc) {
		this.expnEvidDesc = expnEvidDesc;
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
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info
	 * @param vndrLglEngNm
	 */
	public void setVndrLglEngNm(String vndrLglEngNm) {
		this.vndrLglEngNm = vndrLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param tpbVndrNm
	 */
	public void setTpbVndrNm(String tpbVndrNm) {
		this.tpbVndrNm = tpbVndrNm;
	}
	
	/**
	 * Column Info
	 * @param pIfMtyRtnYd
	 */
	public void setPIfMtyRtnYd(String pIfMtyRtnYd) {
		this.pIfMtyRtnYd = pIfMtyRtnYd;
	}
	
	/**
	 * Column Info
	 * @param pIfSubRailSeq
	 */
	public void setPIfSubRailSeq(String pIfSubRailSeq) {
		this.pIfSubRailSeq = pIfSubRailSeq;
	}
	
	/**
	 * Column Info
	 * @param ntcCcRcvEml
	 */
	public void setNtcCcRcvEml(String ntcCcRcvEml) {
		this.ntcCcRcvEml = ntcCcRcvEml;
	}
	
	/**
	 * Column Info
	 * @param vvdCdCtnt
	 */
	public void setVvdCdCtnt(String vvdCdCtnt) {
		this.vvdCdCtnt = vvdCdCtnt;
	}
	
	/**
	 * Column Info
	 * @param eacCmplFlg
	 */
	public void setEacCmplFlg(String eacCmplFlg) {
		this.eacCmplFlg = eacCmplFlg;
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
	 * @param invAudUsdAmt
	 */
	public void setInvAudUsdAmt(String invAudUsdAmt) {
		this.invAudUsdAmt = invAudUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param pIfCostCd
	 */
	public void setPIfCostCd(String pIfCostCd) {
		this.pIfCostCd = pIfCostCd;
	}
	
	/**
	 * Column Info
	 * @param pIfClptIndSeq
	 */
	public void setPIfClptIndSeq(String pIfClptIndSeq) {
		this.pIfClptIndSeq = pIfClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param pIfCorrNo
	 */
	public void setPIfCorrNo(String pIfCorrNo) {
		this.pIfCorrNo = pIfCorrNo;
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
	 * @param eacRegUsrNm
	 */
	public void setEacRegUsrNm(String eacRegUsrNm) {
		this.eacRegUsrNm = eacRegUsrNm;
	}
	
	/**
	 * Column Info
	 * @param pIfExpnAudSeq
	 */
	public void setPIfExpnAudSeq(String pIfExpnAudSeq) {
		this.pIfExpnAudSeq = pIfExpnAudSeq;
	}
	
	/**
	 * Column Info
	 * @param eacYrmon
	 */
	public void setEacYrmon(String eacYrmon) {
		this.eacYrmon = eacYrmon;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param eacNo
	 */
	public void setEacNo(String eacNo) {
		this.eacNo = eacNo;
	}
	
	/**
	 * Column Info
	 * @param eacDtlSeq
	 */
	public void setEacDtlSeq(String eacDtlSeq) {
		this.eacDtlSeq = eacDtlSeq;
	}
	
	/**
	 * Column Info
	 * @param steNm
	 */
	public void setSteNm(String steNm) {
		this.steNm = steNm;
	}
	
	/**
	 * Column Info
	 * @param pIfCntrNo
	 */
	public void setPIfCntrNo(String pIfCntrNo) {
		this.pIfCntrNo = pIfCntrNo;
	}
	
	/**
	 * Column Info
	 * @param eacInterRmk
	 */
	public void setEacInterRmk(String eacInterRmk) {
		this.eacInterRmk = eacInterRmk;
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
	 * @param pIfFpCalcPrdCd
	 */
	public void setPIfFpCalcPrdCd(String pIfFpCalcPrdCd) {
		this.pIfFpCalcPrdCd = pIfFpCalcPrdCd;
	}
	
	/**
	 * Column Info
	 * @param pIfWoNo
	 */
	public void setPIfWoNo(String pIfWoNo) {
		this.pIfWoNo = pIfWoNo;
	}
	
	/**
	 * Column Info
	 * @param eacTpCd
	 */
	public void setEacTpCd(String eacTpCd) {
		this.eacTpCd = eacTpCd;
	}
	
	/**
	 * Column Info
	 * @param trdPartyVal
	 */
	public void setTrdPartyVal(String trdPartyVal) {
		this.trdPartyVal = trdPartyVal;
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
		setPIfStoCntrSzNm(JSPUtil.getParameter(request, prefix + "p_if_sto_cntr_sz_nm", ""));
		setPIfIoBndCd(JSPUtil.getParameter(request, prefix + "p_if_io_bnd_cd", ""));
		setN3ptyExpnTpCd(JSPUtil.getParameter(request, prefix + "n3pty_expn_tp_cd", ""));
		setAudrUsrId(JSPUtil.getParameter(request, prefix + "audr_usr_id", ""));
		setPIfLgsCostCd(JSPUtil.getParameter(request, prefix + "p_if_lgs_cost_cd", ""));
		setEacRjctDesc(JSPUtil.getParameter(request, prefix + "eac_rjct_desc", ""));
		setPIfInvCfmDt(JSPUtil.getParameter(request, prefix + "p_if_inv_cfm_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setN3ptyOfcCd(JSPUtil.getParameter(request, prefix + "n3pty_ofc_cd", ""));
		setVndrCntcPntSeq(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_seq", ""));
		setPIfDcgoFlg(JSPUtil.getParameter(request, prefix + "p_if_dcgo_flg", ""));
		setEacAproTpCd(JSPUtil.getParameter(request, prefix + "eac_apro_tp_cd", ""));
		setN3ptySrcDt(JSPUtil.getParameter(request, prefix + "n3pty_src_dt", ""));
		setPIfSoNo(JSPUtil.getParameter(request, prefix + "p_if_so_no", ""));
		setFileflag(JSPUtil.getParameter(request, prefix + "fileflag", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setEngAddr(JSPUtil.getParameter(request, prefix + "eng_addr", ""));
		setNtcKntCd(JSPUtil.getParameter(request, prefix + "ntc_knt_cd", ""));
		setPIfInvVndrSeq(JSPUtil.getParameter(request, prefix + "p_if_inv_vndr_seq", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setOtsStsNm(JSPUtil.getParameter(request, prefix + "ots_sts_nm", ""));
		setEacStsCd(JSPUtil.getParameter(request, prefix + "eac_sts_cd", ""));
		setPIfInvNo(JSPUtil.getParameter(request, prefix + "p_if_inv_no", ""));
		setTpbVndrCntCd(JSPUtil.getParameter(request, prefix + "tpb_vndr_cnt_cd", ""));
		setSoDtlSeq(JSPUtil.getParameter(request, prefix + "so_dtl_seq", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setWoNoDesc(JSPUtil.getParameter(request, prefix + "wo_no_desc", ""));
		setPIfCalcTpCd(JSPUtil.getParameter(request, prefix + "p_if_calc_tp_cd", ""));
		setEacRsnDesc(JSPUtil.getParameter(request, prefix + "eac_rsn_desc", ""));
		setPIfPortCd(JSPUtil.getParameter(request, prefix + "p_if_port_cd", ""));
		setTpbOfcCd(JSPUtil.getParameter(request, prefix + "tpb_ofc_cd", ""));
		setPIfRhndOfcCd(JSPUtil.getParameter(request, prefix + "p_if_rhnd_ofc_cd", ""));
		setEacAproStepSeq(JSPUtil.getParameter(request, prefix + "eac_apro_step_seq", ""));
		setOfcEngNm(JSPUtil.getParameter(request, prefix + "ofc_eng_nm", ""));
		setEacRsnCd(JSPUtil.getParameter(request, prefix + "eac_rsn_cd", ""));
		setIssCtyCd(JSPUtil.getParameter(request, prefix + "iss_cty_cd", ""));
		setEmlCtnt(JSPUtil.getParameter(request, prefix + "eml_ctnt", ""));
		setEacInpDt(JSPUtil.getParameter(request, prefix + "eac_inp_dt", ""));
		setVndrCustDivCd(JSPUtil.getParameter(request, prefix + "vndr_cust_div_cd", ""));
		setNtcHisSeq(JSPUtil.getParameter(request, prefix + "ntc_his_seq", ""));
		setN3ptyNo(JSPUtil.getParameter(request, prefix + "n3pty_no", ""));
		setEacEmlUseFlg(JSPUtil.getParameter(request, prefix + "eac_eml_use_flg", ""));
		setTrdPartyNm(JSPUtil.getParameter(request, prefix + "trd_party_nm", ""));
		setEacDesc(JSPUtil.getParameter(request, prefix + "eac_desc", ""));
		setEacRjctRsn(JSPUtil.getParameter(request, prefix + "eac_rjct_rsn", ""));
		setEacFaxUseFlg(JSPUtil.getParameter(request, prefix + "eac_fax_use_flg", ""));
		setKpiOfcCd(JSPUtil.getParameter(request, prefix + "kpi_ofc_cd", ""));
		setEacCmplCd(JSPUtil.getParameter(request, prefix + "eac_cmpl_cd", ""));
		setTpbInvAmt(JSPUtil.getParameter(request, prefix + "tpb_inv_amt", ""));
		setInvCngAmt(JSPUtil.getParameter(request, prefix + "inv_cng_amt", ""));
		setEacSysIfCd(JSPUtil.getParameter(request, prefix + "eac_sys_if_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setEacExpnTpCd(JSPUtil.getParameter(request, prefix + "eac_expn_tp_cd", ""));
		setAtchFileId(JSPUtil.getParameter(request, prefix + "atch_file_id", ""));
		setVndrEml(JSPUtil.getParameter(request, prefix + "vndr_eml", ""));
		setEacBilTpCd(JSPUtil.getParameter(request, prefix + "eac_bil_tp_cd", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setWoNoCtnt(JSPUtil.getParameter(request, prefix + "wo_no_ctnt", ""));
		setEmlSubjCtnt(JSPUtil.getParameter(request, prefix + "eml_subj_ctnt", ""));
		setPIfTrspSoTpCd(JSPUtil.getParameter(request, prefix + "p_if_trsp_so_tp_cd", ""));
		setN3ptySrcNo(JSPUtil.getParameter(request, prefix + "n3pty_src_no", ""));
		setEacRjctOfcCd(JSPUtil.getParameter(request, prefix + "eac_rjct_ofc_cd", ""));
		setIsflag(JSPUtil.getParameter(request, prefix + "isflag", ""));
		setEacCostCdDesc(JSPUtil.getParameter(request, prefix + "eac_cost_cd_desc", ""));
		setPIfBkgNo(JSPUtil.getParameter(request, prefix + "p_if_bkg_no", ""));
		setVndrCntcPntNm(JSPUtil.getParameter(request, prefix + "vndr_cntc_pnt_nm", ""));
		setPIfVvd(JSPUtil.getParameter(request, prefix + "p_if_vvd", ""));
		setPIfRcFlg(JSPUtil.getParameter(request, prefix + "p_if_rc_flg", ""));
		setPIfCalcCostGrpCd(JSPUtil.getParameter(request, prefix + "p_if_calc_cost_grp_cd", ""));
		setPIfCntrTpszCd(JSPUtil.getParameter(request, prefix + "p_if_cntr_tpsz_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setAudrOfcCd(JSPUtil.getParameter(request, prefix + "audr_ofc_cd", ""));
		setEacRjctUsrNm(JSPUtil.getParameter(request, prefix + "eac_rjct_usr_nm", ""));
		setEacStsNm(JSPUtil.getParameter(request, prefix + "eac_sts_nm", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setTpbVndrSeq(JSPUtil.getParameter(request, prefix + "tpb_vndr_seq", ""));
		setStlToCltCngOfcCd(JSPUtil.getParameter(request, prefix + "stl_to_clt_cng_ofc_cd", ""));
		setN3ptyBilTpCd(JSPUtil.getParameter(request, prefix + "n3pty_bil_tp_cd", ""));
		setPIfTmlWrkDyCd(JSPUtil.getParameter(request, prefix + "p_if_tml_wrk_dy_cd", ""));
		setDiffInvAmt(JSPUtil.getParameter(request, prefix + "diff_inv_amt", ""));
		setPIfRhndExpnSeq(JSPUtil.getParameter(request, prefix + "p_if_rhnd_expn_seq", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setStlAmt(JSPUtil.getParameter(request, prefix + "stl_amt", ""));
		setPIfEqKndCd(JSPUtil.getParameter(request, prefix + "p_if_eq_knd_cd", ""));
		setVvdDesc(JSPUtil.getParameter(request, prefix + "vvd_desc", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setEacCostDesc(JSPUtil.getParameter(request, prefix + "eac_cost_desc", ""));
		setInvAudAmt(JSPUtil.getParameter(request, prefix + "inv_aud_amt", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
		setExpnEvidDesc(JSPUtil.getParameter(request, prefix + "expn_evid_desc", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, prefix + "vndr_lgl_eng_nm", ""));
		setTpbVndrNm(JSPUtil.getParameter(request, prefix + "tpb_vndr_nm", ""));
		setPIfMtyRtnYd(JSPUtil.getParameter(request, prefix + "p_if_mty_rtn_yd", ""));
		setPIfSubRailSeq(JSPUtil.getParameter(request, prefix + "p_if_sub_rail_seq", ""));
		setNtcCcRcvEml(JSPUtil.getParameter(request, prefix + "ntc_cc_rcv_eml", ""));
		setVvdCdCtnt(JSPUtil.getParameter(request, prefix + "vvd_cd_ctnt", ""));
		setEacCmplFlg(JSPUtil.getParameter(request, prefix + "eac_cmpl_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setInvAudUsdAmt(JSPUtil.getParameter(request, prefix + "inv_aud_usd_amt", ""));
		setPIfCostCd(JSPUtil.getParameter(request, prefix + "p_if_cost_cd", ""));
		setPIfClptIndSeq(JSPUtil.getParameter(request, prefix + "p_if_clpt_ind_seq", ""));
		setPIfCorrNo(JSPUtil.getParameter(request, prefix + "p_if_corr_no", ""));
		setInvAmt(JSPUtil.getParameter(request, prefix + "inv_amt", ""));
		setEacRegUsrNm(JSPUtil.getParameter(request, prefix + "eac_reg_usr_nm", ""));
		setPIfExpnAudSeq(JSPUtil.getParameter(request, prefix + "p_if_expn_aud_seq", ""));
		setEacYrmon(JSPUtil.getParameter(request, prefix + "eac_yrmon", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setEacNo(JSPUtil.getParameter(request, prefix + "eac_no", ""));
		setEacDtlSeq(JSPUtil.getParameter(request, prefix + "eac_dtl_seq", ""));
		setSteNm(JSPUtil.getParameter(request, prefix + "ste_nm", ""));
		setPIfCntrNo(JSPUtil.getParameter(request, prefix + "p_if_cntr_no", ""));
		setEacInterRmk(JSPUtil.getParameter(request, prefix + "eac_inter_rmk", ""));
		setRespbOfcCd(JSPUtil.getParameter(request, prefix + "respb_ofc_cd", ""));
		setPIfFpCalcPrdCd(JSPUtil.getParameter(request, prefix + "p_if_fp_calc_prd_cd", ""));
		setPIfWoNo(JSPUtil.getParameter(request, prefix + "p_if_wo_no", ""));
		setEacTpCd(JSPUtil.getParameter(request, prefix + "eac_tp_cd", ""));
		setTrdPartyVal(JSPUtil.getParameter(request, prefix + "trd_party_val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EACRgstVO[]
	 */
	public EACRgstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EACRgstVO[]
	 */
	public EACRgstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EACRgstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pIfStoCntrSzNm = (JSPUtil.getParameter(request, prefix	+ "p_if_sto_cntr_sz_nm", length));
			String[] pIfIoBndCd = (JSPUtil.getParameter(request, prefix	+ "p_if_io_bnd_cd", length));
			String[] n3ptyExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_expn_tp_cd", length));
			String[] audrUsrId = (JSPUtil.getParameter(request, prefix	+ "audr_usr_id", length));
			String[] pIfLgsCostCd = (JSPUtil.getParameter(request, prefix	+ "p_if_lgs_cost_cd", length));
			String[] eacRjctDesc = (JSPUtil.getParameter(request, prefix	+ "eac_rjct_desc", length));
			String[] pIfInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "p_if_inv_cfm_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] n3ptyOfcCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_ofc_cd", length));
			String[] vndrCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_cntc_pnt_seq", length));
			String[] pIfDcgoFlg = (JSPUtil.getParameter(request, prefix	+ "p_if_dcgo_flg", length));
			String[] eacAproTpCd = (JSPUtil.getParameter(request, prefix	+ "eac_apro_tp_cd", length));
			String[] n3ptySrcDt = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_dt", length));
			String[] pIfSoNo = (JSPUtil.getParameter(request, prefix	+ "p_if_so_no", length));
			String[] fileflag = (JSPUtil.getParameter(request, prefix	+ "fileflag", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] engAddr = (JSPUtil.getParameter(request, prefix	+ "eng_addr", length));
			String[] ntcKntCd = (JSPUtil.getParameter(request, prefix	+ "ntc_knt_cd", length));
			String[] pIfInvVndrSeq = (JSPUtil.getParameter(request, prefix	+ "p_if_inv_vndr_seq", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] otsStsNm = (JSPUtil.getParameter(request, prefix	+ "ots_sts_nm", length));
			String[] eacStsCd = (JSPUtil.getParameter(request, prefix	+ "eac_sts_cd", length));
			String[] pIfInvNo = (JSPUtil.getParameter(request, prefix	+ "p_if_inv_no", length));
			String[] tpbVndrCntCd = (JSPUtil.getParameter(request, prefix	+ "tpb_vndr_cnt_cd", length));
			String[] soDtlSeq = (JSPUtil.getParameter(request, prefix	+ "so_dtl_seq", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] woNoDesc = (JSPUtil.getParameter(request, prefix	+ "wo_no_desc", length));
			String[] pIfCalcTpCd = (JSPUtil.getParameter(request, prefix	+ "p_if_calc_tp_cd", length));
			String[] eacRsnDesc = (JSPUtil.getParameter(request, prefix	+ "eac_rsn_desc", length));
			String[] pIfPortCd = (JSPUtil.getParameter(request, prefix	+ "p_if_port_cd", length));
			String[] tpbOfcCd = (JSPUtil.getParameter(request, prefix	+ "tpb_ofc_cd", length));
			String[] pIfRhndOfcCd = (JSPUtil.getParameter(request, prefix	+ "p_if_rhnd_ofc_cd", length));
			String[] eacAproStepSeq = (JSPUtil.getParameter(request, prefix	+ "eac_apro_step_seq", length));
			String[] ofcEngNm = (JSPUtil.getParameter(request, prefix	+ "ofc_eng_nm", length));
			String[] eacRsnCd = (JSPUtil.getParameter(request, prefix	+ "eac_rsn_cd", length));
			String[] issCtyCd = (JSPUtil.getParameter(request, prefix	+ "iss_cty_cd", length));
			String[] emlCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_ctnt", length));
			String[] eacInpDt = (JSPUtil.getParameter(request, prefix	+ "eac_inp_dt", length));
			String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_cd", length));
			String[] ntcHisSeq = (JSPUtil.getParameter(request, prefix	+ "ntc_his_seq", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] eacEmlUseFlg = (JSPUtil.getParameter(request, prefix	+ "eac_eml_use_flg", length));
			String[] trdPartyNm = (JSPUtil.getParameter(request, prefix	+ "trd_party_nm", length));
			String[] eacDesc = (JSPUtil.getParameter(request, prefix	+ "eac_desc", length));
			String[] eacRjctRsn = (JSPUtil.getParameter(request, prefix	+ "eac_rjct_rsn", length));
			String[] eacFaxUseFlg = (JSPUtil.getParameter(request, prefix	+ "eac_fax_use_flg", length));
			String[] kpiOfcCd = (JSPUtil.getParameter(request, prefix	+ "kpi_ofc_cd", length));
			String[] eacCmplCd = (JSPUtil.getParameter(request, prefix	+ "eac_cmpl_cd", length));
			String[] tpbInvAmt = (JSPUtil.getParameter(request, prefix	+ "tpb_inv_amt", length));
			String[] invCngAmt = (JSPUtil.getParameter(request, prefix	+ "inv_cng_amt", length));
			String[] eacSysIfCd = (JSPUtil.getParameter(request, prefix	+ "eac_sys_if_cd", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] eacExpnTpCd = (JSPUtil.getParameter(request, prefix	+ "eac_expn_tp_cd", length));
			String[] atchFileId = (JSPUtil.getParameter(request, prefix	+ "atch_file_id", length));
			String[] vndrEml = (JSPUtil.getParameter(request, prefix	+ "vndr_eml", length));
			String[] eacBilTpCd = (JSPUtil.getParameter(request, prefix	+ "eac_bil_tp_cd", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] woNoCtnt = (JSPUtil.getParameter(request, prefix	+ "wo_no_ctnt", length));
			String[] emlSubjCtnt = (JSPUtil.getParameter(request, prefix	+ "eml_subj_ctnt", length));
			String[] pIfTrspSoTpCd = (JSPUtil.getParameter(request, prefix	+ "p_if_trsp_so_tp_cd", length));
			String[] n3ptySrcNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_src_no", length));
			String[] eacRjctOfcCd = (JSPUtil.getParameter(request, prefix	+ "eac_rjct_ofc_cd", length));
			String[] isflag = (JSPUtil.getParameter(request, prefix	+ "isflag", length));
			String[] eacCostCdDesc = (JSPUtil.getParameter(request, prefix	+ "eac_cost_cd_desc", length));
			String[] pIfBkgNo = (JSPUtil.getParameter(request, prefix	+ "p_if_bkg_no", length));
			String[] vndrCntcPntNm = (JSPUtil.getParameter(request, prefix	+ "vndr_cntc_pnt_nm", length));
			String[] pIfVvd = (JSPUtil.getParameter(request, prefix	+ "p_if_vvd", length));
			String[] pIfRcFlg = (JSPUtil.getParameter(request, prefix	+ "p_if_rc_flg", length));
			String[] pIfCalcCostGrpCd = (JSPUtil.getParameter(request, prefix	+ "p_if_calc_cost_grp_cd", length));
			String[] pIfCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "p_if_cntr_tpsz_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] audrOfcCd = (JSPUtil.getParameter(request, prefix	+ "audr_ofc_cd", length));
			String[] eacRjctUsrNm = (JSPUtil.getParameter(request, prefix	+ "eac_rjct_usr_nm", length));
			String[] eacStsNm = (JSPUtil.getParameter(request, prefix	+ "eac_sts_nm", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] tpbVndrSeq = (JSPUtil.getParameter(request, prefix	+ "tpb_vndr_seq", length));
			String[] stlToCltCngOfcCd = (JSPUtil.getParameter(request, prefix	+ "stl_to_clt_cng_ofc_cd", length));
			String[] n3ptyBilTpCd = (JSPUtil.getParameter(request, prefix	+ "n3pty_bil_tp_cd", length));
			String[] pIfTmlWrkDyCd = (JSPUtil.getParameter(request, prefix	+ "p_if_tml_wrk_dy_cd", length));
			String[] diffInvAmt = (JSPUtil.getParameter(request, prefix	+ "diff_inv_amt", length));
			String[] pIfRhndExpnSeq = (JSPUtil.getParameter(request, prefix	+ "p_if_rhnd_expn_seq", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] stlAmt = (JSPUtil.getParameter(request, prefix	+ "stl_amt", length));
			String[] pIfEqKndCd = (JSPUtil.getParameter(request, prefix	+ "p_if_eq_knd_cd", length));
			String[] vvdDesc = (JSPUtil.getParameter(request, prefix	+ "vvd_desc", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] eacCostDesc = (JSPUtil.getParameter(request, prefix	+ "eac_cost_desc", length));
			String[] invAudAmt = (JSPUtil.getParameter(request, prefix	+ "inv_aud_amt", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] expnEvidDesc = (JSPUtil.getParameter(request, prefix	+ "expn_evid_desc", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] tpbVndrNm = (JSPUtil.getParameter(request, prefix	+ "tpb_vndr_nm", length));
			String[] pIfMtyRtnYd = (JSPUtil.getParameter(request, prefix	+ "p_if_mty_rtn_yd", length));
			String[] pIfSubRailSeq = (JSPUtil.getParameter(request, prefix	+ "p_if_sub_rail_seq", length));
			String[] ntcCcRcvEml = (JSPUtil.getParameter(request, prefix	+ "ntc_cc_rcv_eml", length));
			String[] vvdCdCtnt = (JSPUtil.getParameter(request, prefix	+ "vvd_cd_ctnt", length));
			String[] eacCmplFlg = (JSPUtil.getParameter(request, prefix	+ "eac_cmpl_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] invAudUsdAmt = (JSPUtil.getParameter(request, prefix	+ "inv_aud_usd_amt", length));
			String[] pIfCostCd = (JSPUtil.getParameter(request, prefix	+ "p_if_cost_cd", length));
			String[] pIfClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "p_if_clpt_ind_seq", length));
			String[] pIfCorrNo = (JSPUtil.getParameter(request, prefix	+ "p_if_corr_no", length));
			String[] invAmt = (JSPUtil.getParameter(request, prefix	+ "inv_amt", length));
			String[] eacRegUsrNm = (JSPUtil.getParameter(request, prefix	+ "eac_reg_usr_nm", length));
			String[] pIfExpnAudSeq = (JSPUtil.getParameter(request, prefix	+ "p_if_expn_aud_seq", length));
			String[] eacYrmon = (JSPUtil.getParameter(request, prefix	+ "eac_yrmon", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] eacNo = (JSPUtil.getParameter(request, prefix	+ "eac_no", length));
			String[] eacDtlSeq = (JSPUtil.getParameter(request, prefix	+ "eac_dtl_seq", length));
			String[] steNm = (JSPUtil.getParameter(request, prefix	+ "ste_nm", length));
			String[] pIfCntrNo = (JSPUtil.getParameter(request, prefix	+ "p_if_cntr_no", length));
			String[] eacInterRmk = (JSPUtil.getParameter(request, prefix	+ "eac_inter_rmk", length));
			String[] respbOfcCd = (JSPUtil.getParameter(request, prefix	+ "respb_ofc_cd", length));
			String[] pIfFpCalcPrdCd = (JSPUtil.getParameter(request, prefix	+ "p_if_fp_calc_prd_cd", length));
			String[] pIfWoNo = (JSPUtil.getParameter(request, prefix	+ "p_if_wo_no", length));
			String[] eacTpCd = (JSPUtil.getParameter(request, prefix	+ "eac_tp_cd", length));
			String[] trdPartyVal = (JSPUtil.getParameter(request, prefix	+ "trd_party_val", length));
			
			for (int i = 0; i < length; i++) {
				model = new EACRgstVO();
				if (pIfStoCntrSzNm[i] != null)
					model.setPIfStoCntrSzNm(pIfStoCntrSzNm[i]);
				if (pIfIoBndCd[i] != null)
					model.setPIfIoBndCd(pIfIoBndCd[i]);
				if (n3ptyExpnTpCd[i] != null)
					model.setN3ptyExpnTpCd(n3ptyExpnTpCd[i]);
				if (audrUsrId[i] != null)
					model.setAudrUsrId(audrUsrId[i]);
				if (pIfLgsCostCd[i] != null)
					model.setPIfLgsCostCd(pIfLgsCostCd[i]);
				if (eacRjctDesc[i] != null)
					model.setEacRjctDesc(eacRjctDesc[i]);
				if (pIfInvCfmDt[i] != null)
					model.setPIfInvCfmDt(pIfInvCfmDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (n3ptyOfcCd[i] != null)
					model.setN3ptyOfcCd(n3ptyOfcCd[i]);
				if (vndrCntcPntSeq[i] != null)
					model.setVndrCntcPntSeq(vndrCntcPntSeq[i]);
				if (pIfDcgoFlg[i] != null)
					model.setPIfDcgoFlg(pIfDcgoFlg[i]);
				if (eacAproTpCd[i] != null)
					model.setEacAproTpCd(eacAproTpCd[i]);
				if (n3ptySrcDt[i] != null)
					model.setN3ptySrcDt(n3ptySrcDt[i]);
				if (pIfSoNo[i] != null)
					model.setPIfSoNo(pIfSoNo[i]);
				if (fileflag[i] != null)
					model.setFileflag(fileflag[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (engAddr[i] != null)
					model.setEngAddr(engAddr[i]);
				if (ntcKntCd[i] != null)
					model.setNtcKntCd(ntcKntCd[i]);
				if (pIfInvVndrSeq[i] != null)
					model.setPIfInvVndrSeq(pIfInvVndrSeq[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (otsStsNm[i] != null)
					model.setOtsStsNm(otsStsNm[i]);
				if (eacStsCd[i] != null)
					model.setEacStsCd(eacStsCd[i]);
				if (pIfInvNo[i] != null)
					model.setPIfInvNo(pIfInvNo[i]);
				if (tpbVndrCntCd[i] != null)
					model.setTpbVndrCntCd(tpbVndrCntCd[i]);
				if (soDtlSeq[i] != null)
					model.setSoDtlSeq(soDtlSeq[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (woNoDesc[i] != null)
					model.setWoNoDesc(woNoDesc[i]);
				if (pIfCalcTpCd[i] != null)
					model.setPIfCalcTpCd(pIfCalcTpCd[i]);
				if (eacRsnDesc[i] != null)
					model.setEacRsnDesc(eacRsnDesc[i]);
				if (pIfPortCd[i] != null)
					model.setPIfPortCd(pIfPortCd[i]);
				if (tpbOfcCd[i] != null)
					model.setTpbOfcCd(tpbOfcCd[i]);
				if (pIfRhndOfcCd[i] != null)
					model.setPIfRhndOfcCd(pIfRhndOfcCd[i]);
				if (eacAproStepSeq[i] != null)
					model.setEacAproStepSeq(eacAproStepSeq[i]);
				if (ofcEngNm[i] != null)
					model.setOfcEngNm(ofcEngNm[i]);
				if (eacRsnCd[i] != null)
					model.setEacRsnCd(eacRsnCd[i]);
				if (issCtyCd[i] != null)
					model.setIssCtyCd(issCtyCd[i]);
				if (emlCtnt[i] != null)
					model.setEmlCtnt(emlCtnt[i]);
				if (eacInpDt[i] != null)
					model.setEacInpDt(eacInpDt[i]);
				if (vndrCustDivCd[i] != null)
					model.setVndrCustDivCd(vndrCustDivCd[i]);
				if (ntcHisSeq[i] != null)
					model.setNtcHisSeq(ntcHisSeq[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (eacEmlUseFlg[i] != null)
					model.setEacEmlUseFlg(eacEmlUseFlg[i]);
				if (trdPartyNm[i] != null)
					model.setTrdPartyNm(trdPartyNm[i]);
				if (eacDesc[i] != null)
					model.setEacDesc(eacDesc[i]);
				if (eacRjctRsn[i] != null)
					model.setEacRjctRsn(eacRjctRsn[i]);
				if (eacFaxUseFlg[i] != null)
					model.setEacFaxUseFlg(eacFaxUseFlg[i]);
				if (kpiOfcCd[i] != null)
					model.setKpiOfcCd(kpiOfcCd[i]);
				if (eacCmplCd[i] != null)
					model.setEacCmplCd(eacCmplCd[i]);
				if (tpbInvAmt[i] != null)
					model.setTpbInvAmt(tpbInvAmt[i]);
				if (invCngAmt[i] != null)
					model.setInvCngAmt(invCngAmt[i]);
				if (eacSysIfCd[i] != null)
					model.setEacSysIfCd(eacSysIfCd[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (eacExpnTpCd[i] != null)
					model.setEacExpnTpCd(eacExpnTpCd[i]);
				if (atchFileId[i] != null)
					model.setAtchFileId(atchFileId[i]);
				if (vndrEml[i] != null)
					model.setVndrEml(vndrEml[i]);
				if (eacBilTpCd[i] != null)
					model.setEacBilTpCd(eacBilTpCd[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (woNoCtnt[i] != null)
					model.setWoNoCtnt(woNoCtnt[i]);
				if (emlSubjCtnt[i] != null)
					model.setEmlSubjCtnt(emlSubjCtnt[i]);
				if (pIfTrspSoTpCd[i] != null)
					model.setPIfTrspSoTpCd(pIfTrspSoTpCd[i]);
				if (n3ptySrcNo[i] != null)
					model.setN3ptySrcNo(n3ptySrcNo[i]);
				if (eacRjctOfcCd[i] != null)
					model.setEacRjctOfcCd(eacRjctOfcCd[i]);
				if (isflag[i] != null)
					model.setIsflag(isflag[i]);
				if (eacCostCdDesc[i] != null)
					model.setEacCostCdDesc(eacCostCdDesc[i]);
				if (pIfBkgNo[i] != null)
					model.setPIfBkgNo(pIfBkgNo[i]);
				if (vndrCntcPntNm[i] != null)
					model.setVndrCntcPntNm(vndrCntcPntNm[i]);
				if (pIfVvd[i] != null)
					model.setPIfVvd(pIfVvd[i]);
				if (pIfRcFlg[i] != null)
					model.setPIfRcFlg(pIfRcFlg[i]);
				if (pIfCalcCostGrpCd[i] != null)
					model.setPIfCalcCostGrpCd(pIfCalcCostGrpCd[i]);
				if (pIfCntrTpszCd[i] != null)
					model.setPIfCntrTpszCd(pIfCntrTpszCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (audrOfcCd[i] != null)
					model.setAudrOfcCd(audrOfcCd[i]);
				if (eacRjctUsrNm[i] != null)
					model.setEacRjctUsrNm(eacRjctUsrNm[i]);
				if (eacStsNm[i] != null)
					model.setEacStsNm(eacStsNm[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (tpbVndrSeq[i] != null)
					model.setTpbVndrSeq(tpbVndrSeq[i]);
				if (stlToCltCngOfcCd[i] != null)
					model.setStlToCltCngOfcCd(stlToCltCngOfcCd[i]);
				if (n3ptyBilTpCd[i] != null)
					model.setN3ptyBilTpCd(n3ptyBilTpCd[i]);
				if (pIfTmlWrkDyCd[i] != null)
					model.setPIfTmlWrkDyCd(pIfTmlWrkDyCd[i]);
				if (diffInvAmt[i] != null)
					model.setDiffInvAmt(diffInvAmt[i]);
				if (pIfRhndExpnSeq[i] != null)
					model.setPIfRhndExpnSeq(pIfRhndExpnSeq[i]);
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (stlAmt[i] != null)
					model.setStlAmt(stlAmt[i]);
				if (pIfEqKndCd[i] != null)
					model.setPIfEqKndCd(pIfEqKndCd[i]);
				if (vvdDesc[i] != null)
					model.setVvdDesc(vvdDesc[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (eacCostDesc[i] != null)
					model.setEacCostDesc(eacCostDesc[i]);
				if (invAudAmt[i] != null)
					model.setInvAudAmt(invAudAmt[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (expnEvidDesc[i] != null)
					model.setExpnEvidDesc(expnEvidDesc[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (tpbVndrNm[i] != null)
					model.setTpbVndrNm(tpbVndrNm[i]);
				if (pIfMtyRtnYd[i] != null)
					model.setPIfMtyRtnYd(pIfMtyRtnYd[i]);
				if (pIfSubRailSeq[i] != null)
					model.setPIfSubRailSeq(pIfSubRailSeq[i]);
				if (ntcCcRcvEml[i] != null)
					model.setNtcCcRcvEml(ntcCcRcvEml[i]);
				if (vvdCdCtnt[i] != null)
					model.setVvdCdCtnt(vvdCdCtnt[i]);
				if (eacCmplFlg[i] != null)
					model.setEacCmplFlg(eacCmplFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (invAudUsdAmt[i] != null)
					model.setInvAudUsdAmt(invAudUsdAmt[i]);
				if (pIfCostCd[i] != null)
					model.setPIfCostCd(pIfCostCd[i]);
				if (pIfClptIndSeq[i] != null)
					model.setPIfClptIndSeq(pIfClptIndSeq[i]);
				if (pIfCorrNo[i] != null)
					model.setPIfCorrNo(pIfCorrNo[i]);
				if (invAmt[i] != null)
					model.setInvAmt(invAmt[i]);
				if (eacRegUsrNm[i] != null)
					model.setEacRegUsrNm(eacRegUsrNm[i]);
				if (pIfExpnAudSeq[i] != null)
					model.setPIfExpnAudSeq(pIfExpnAudSeq[i]);
				if (eacYrmon[i] != null)
					model.setEacYrmon(eacYrmon[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (eacNo[i] != null)
					model.setEacNo(eacNo[i]);
				if (eacDtlSeq[i] != null)
					model.setEacDtlSeq(eacDtlSeq[i]);
				if (steNm[i] != null)
					model.setSteNm(steNm[i]);
				if (pIfCntrNo[i] != null)
					model.setPIfCntrNo(pIfCntrNo[i]);
				if (eacInterRmk[i] != null)
					model.setEacInterRmk(eacInterRmk[i]);
				if (respbOfcCd[i] != null)
					model.setRespbOfcCd(respbOfcCd[i]);
				if (pIfFpCalcPrdCd[i] != null)
					model.setPIfFpCalcPrdCd(pIfFpCalcPrdCd[i]);
				if (pIfWoNo[i] != null)
					model.setPIfWoNo(pIfWoNo[i]);
				if (eacTpCd[i] != null)
					model.setEacTpCd(eacTpCd[i]);
				if (trdPartyVal[i] != null)
					model.setTrdPartyVal(trdPartyVal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEACRgstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EACRgstVO[]
	 */
	public EACRgstVO[] getEACRgstVOs(){
		EACRgstVO[] vos = (EACRgstVO[])models.toArray(new EACRgstVO[models.size()]);
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
		this.pIfStoCntrSzNm = this.pIfStoCntrSzNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfIoBndCd = this.pIfIoBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyExpnTpCd = this.n3ptyExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audrUsrId = this.audrUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfLgsCostCd = this.pIfLgsCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacRjctDesc = this.eacRjctDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfInvCfmDt = this.pIfInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyOfcCd = this.n3ptyOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntcPntSeq = this.vndrCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfDcgoFlg = this.pIfDcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacAproTpCd = this.eacAproTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcDt = this.n3ptySrcDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfSoNo = this.pIfSoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileflag = this.fileflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.engAddr = this.engAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKntCd = this.ntcKntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfInvVndrSeq = this.pIfInvVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsNm = this.otsStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacStsCd = this.eacStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfInvNo = this.pIfInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbVndrCntCd = this.tpbVndrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soDtlSeq = this.soDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNoDesc = this.woNoDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfCalcTpCd = this.pIfCalcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacRsnDesc = this.eacRsnDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfPortCd = this.pIfPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbOfcCd = this.tpbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfRhndOfcCd = this.pIfRhndOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacAproStepSeq = this.eacAproStepSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcEngNm = this.ofcEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacRsnCd = this.eacRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCtyCd = this.issCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlCtnt = this.emlCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacInpDt = this.eacInpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivCd = this.vndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcHisSeq = this.ntcHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacEmlUseFlg = this.eacEmlUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyNm = this.trdPartyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacDesc = this.eacDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacRjctRsn = this.eacRjctRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacFaxUseFlg = this.eacFaxUseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kpiOfcCd = this.kpiOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacCmplCd = this.eacCmplCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbInvAmt = this.tpbInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCngAmt = this.invCngAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacSysIfCd = this.eacSysIfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacExpnTpCd = this.eacExpnTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileId = this.atchFileId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrEml = this.vndrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacBilTpCd = this.eacBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNoCtnt = this.woNoCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSubjCtnt = this.emlSubjCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfTrspSoTpCd = this.pIfTrspSoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptySrcNo = this.n3ptySrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacRjctOfcCd = this.eacRjctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isflag = this.isflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacCostCdDesc = this.eacCostCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfBkgNo = this.pIfBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCntcPntNm = this.vndrCntcPntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfVvd = this.pIfVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfRcFlg = this.pIfRcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfCalcCostGrpCd = this.pIfCalcCostGrpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfCntrTpszCd = this.pIfCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.audrOfcCd = this.audrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacRjctUsrNm = this.eacRjctUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacStsNm = this.eacStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbVndrSeq = this.tpbVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlToCltCngOfcCd = this.stlToCltCngOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilTpCd = this.n3ptyBilTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfTmlWrkDyCd = this.pIfTmlWrkDyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffInvAmt = this.diffInvAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfRhndExpnSeq = this.pIfRhndExpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlAmt = this.stlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfEqKndCd = this.pIfEqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdDesc = this.vvdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacCostDesc = this.eacCostDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAudAmt = this.invAudAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expnEvidDesc = this.expnEvidDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpbVndrNm = this.tpbVndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfMtyRtnYd = this.pIfMtyRtnYd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfSubRailSeq = this.pIfSubRailSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcCcRcvEml = this.ntcCcRcvEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCdCtnt = this.vvdCdCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacCmplFlg = this.eacCmplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAudUsdAmt = this.invAudUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfCostCd = this.pIfCostCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfClptIndSeq = this.pIfClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfCorrNo = this.pIfCorrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt = this.invAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacRegUsrNm = this.eacRegUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfExpnAudSeq = this.pIfExpnAudSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacYrmon = this.eacYrmon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacNo = this.eacNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacDtlSeq = this.eacDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steNm = this.steNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfCntrNo = this.pIfCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacInterRmk = this.eacInterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd = this.respbOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfFpCalcPrdCd = this.pIfFpCalcPrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pIfWoNo = this.pIfWoNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacTpCd = this.eacTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyVal = this.trdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
