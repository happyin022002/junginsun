/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltSearchAuditByHangerInstallationListVO.java
*@FileTitle : RsltSearchAuditByHangerInstallationListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.05
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2010.02.05 김대호 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.revenueaudit.unmatchbl.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김대호
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltSearchAuditByHangerInstallationListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltSearchAuditByHangerInstallationListVO> models = new ArrayList<RsltSearchAuditByHangerInstallationListVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String crrHngrSglBarQty = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rtAplyDt = null;
	/* Column Info */
	private String bkgRhqCd = null;
	/* Column Info */
	private String searchDate = null;
	/* Column Info */
	private String rdnNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtNo = null;
	/* Column Info */
	private String crrHngrDblBarQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String bkgCreDt = null;
	/* Column Info */
	private String bkgCtrtTpCd = null;
	/* Column Info */
	private String merHngrQty = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String chgUtAmt = null;
	/* Column Info */
	private String crrHngrQty = null;
	/* Column Info */
	private String ctrtCntrTpszCd = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ctrtCntrTpszCd2 = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String ratAsQty = null;
	/* Column Info */
	private String crrHngrTplBarQty = null;
	/* Column Info */
	private String splitNm = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String umchRsnRmk = null;
	/* Column Info */
	private String rgnGrpAvcRmk = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String chargeFlg = null;
	/* Column Info */
	private String chargeNm = null;
	/* Column Info */
	private String rtBlTpCd = null;
	/* Column Info */
	private String rtBlTpNm = null;
	/* Column Info */
	private String billTypeB = null;
	/* Column Info */
	private String billTypeC = null;
	/* Column Info */
	private String billTypeN = null;
	/* Column Info */
	private String billTypeM = null;
	/* Column Info */
	private String polEtd = null;
	/* Column Info */
	private String rowCnt = null;
	/* Column Info */
	private String blCnt = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String bkgRevAudTpCd = null;
	/* Column Info */
	private String bkgRevAudSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String umchBkgSeq = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String rdnStsNm = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltSearchAuditByHangerInstallationListVO() {}

	public RsltSearchAuditByHangerInstallationListVO(String ibflag, String pagerows, String bkgRhqCd, String bkgOfcCd, String bkgNo, String blNo, String bkgCreDt, String rtAplyDt, String svcScpCd, String vvd, String bkgCtrtTpCd, String ctrtNo, String ctrtCntrTpszCd, String ctrtCntrTpszCd2, String opCntrQty, String crrHngrSglBarQty, String crrHngrDblBarQty, String crrHngrTplBarQty, String crrHngrQty, String merHngrQty, String chgCd, String currCd, String chgUtAmt, String ratAsQty, String ratUtCd, String chgAmt, String rdnNo, String fromDt, String toDt, String searchDate, String splitNm, String splitFlg, String umchRsnRmk, String rgnGrpAvcRmk, String bdrFlg,String chargeFlg,String chargeNm, String billTypeN, String billTypeM, String billTypeC, String billTypeB, String rtBlTpCd, String rtBlTpNm, String polEtd,String rowCnt,String blCnt, String creUsrId, String creDt, String updUsrId, String updDt, String bkgRevAudTpCd,String bkgRevAudSeq,String cntrTpszCd, String umchBkgSeq,String usrId, String rdnStsNm) {
		this.fromDt = fromDt;
		this.crrHngrSglBarQty = crrHngrSglBarQty;
		this.currCd = currCd;
		this.svcScpCd = svcScpCd;
		this.rtAplyDt = rtAplyDt;
		this.bkgRhqCd = bkgRhqCd;
		this.searchDate = searchDate;
		this.rdnNo = rdnNo;
		this.blNo = blNo;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.ctrtNo = ctrtNo;
		this.crrHngrDblBarQty = crrHngrDblBarQty;
		this.ibflag = ibflag;
		this.chgAmt = chgAmt;
		this.bkgCreDt = bkgCreDt;
		this.bkgCtrtTpCd = bkgCtrtTpCd;
		this.merHngrQty = merHngrQty;
		this.bkgOfcCd = bkgOfcCd;
		this.chgUtAmt = chgUtAmt;
		this.crrHngrQty = crrHngrQty;
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
		this.ratUtCd = ratUtCd;
		this.toDt = toDt;
		this.vvd = vvd;
		this.bkgNo = bkgNo;
		this.ctrtCntrTpszCd2 = ctrtCntrTpszCd2;
		this.opCntrQty = opCntrQty;
		this.ratAsQty = ratAsQty;
		this.crrHngrTplBarQty = crrHngrTplBarQty;
		this.splitNm = splitNm;
		this.splitFlg = splitFlg;
		this.umchRsnRmk = umchRsnRmk;
		this.rgnGrpAvcRmk = rgnGrpAvcRmk;
		this.bdrFlg = bdrFlg;
		this.chargeFlg = chargeFlg;
		this.chargeNm = chargeNm;
		this.rtBlTpCd = rtBlTpCd;
		this.rtBlTpNm = rtBlTpNm;
		this.billTypeB = billTypeB;
		this.billTypeC = billTypeC;
		this.billTypeN = billTypeN;
		this.billTypeM = billTypeM;
		this.polEtd = polEtd;
		this.rowCnt = rowCnt;
		this.blCnt = blCnt;
		this.updDt = updDt;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.bkgRevAudTpCd = bkgRevAudTpCd;
		this.bkgRevAudSeq = bkgRevAudSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.umchBkgSeq = umchBkgSeq;
		this.usrId = usrId;
		this.rdnStsNm = rdnStsNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("crr_hngr_sgl_bar_qty", getCrrHngrSglBarQty());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rt_aply_dt", getRtAplyDt());
		this.hashColumns.put("bkg_rhq_cd", getBkgRhqCd());
		this.hashColumns.put("search_date", getSearchDate());
		this.hashColumns.put("rdn_no", getRdnNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("crr_hngr_dbl_bar_qty", getCrrHngrDblBarQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());
		this.hashColumns.put("mer_hngr_qty", getMerHngrQty());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("chg_ut_amt", getChgUtAmt());
		this.hashColumns.put("crr_hngr_qty", getCrrHngrQty());
		this.hashColumns.put("ctrt_cntr_tpsz_cd", getCtrtCntrTpszCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ctrt_cntr_tpsz_cd2", getCtrtCntrTpszCd2());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("rat_as_qty", getRatAsQty());
		this.hashColumns.put("crr_hngr_tpl_bar_qty", getCrrHngrTplBarQty());
		this.hashColumns.put("split_nm", getSplitNm());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("umch_rsn_rmk", getUmchRsnRmk());
		this.hashColumns.put("rgn_grp_avc_rmk", getRgnGrpAvcRmk());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("charge_flg", getChargeFlg());
		this.hashColumns.put("charge_nm", getChargeNm());
		this.hashColumns.put("rt_bl_tp_cd", getRtBlTpCd());
		this.hashColumns.put("rt_bl_tp_nm", getRtBlTpNm());
		this.hashColumns.put("bill_type_b", getBillTypeB());
		this.hashColumns.put("bill_type_c", getBillTypeC());
		this.hashColumns.put("bill_type_n", getBillTypeN());
		this.hashColumns.put("bill_type_m", getBillTypeM());
		this.hashColumns.put("pol_etd", getPolEtd());//추가
		this.hashColumns.put("row_cnt", getRowCnt());
		this.hashColumns.put("bl_cnt", getBlCnt());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("bkg_rev_aud_tp_cd", getBkgRevAudTpCd());
		this.hashColumns.put("bkg_rev_aud_seq", getBkgRevAudSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("umch_bkg_seq", getUmchBkgSeq());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("rdn_sts_nm", getRdnStsNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("crr_hngr_sgl_bar_qty", "crrHngrSglBarQty");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("rt_aply_dt", "rtAplyDt");
		this.hashFields.put("bkg_rhq_cd", "bkgRhqCd");
		this.hashFields.put("search_date", "searchDate");
		this.hashFields.put("rdn_no", "rdnNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("crr_hngr_dbl_bar_qty", "crrHngrDblBarQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("mer_hngr_qty", "merHngrQty");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("chg_ut_amt", "chgUtAmt");
		this.hashFields.put("crr_hngr_qty", "crrHngrQty");
		this.hashFields.put("ctrt_cntr_tpsz_cd", "ctrtCntrTpszCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ctrt_cntr_tpsz_cd2", "ctrtCntrTpszCd2");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("rat_as_qty", "ratAsQty");
		this.hashFields.put("crr_hngr_tpl_bar_qty", "crrHngrTplBarQty");
		this.hashFields.put("split_nm", "splitNm");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("umch_rsn_rmk", "umchRsnRmk");
		this.hashFields.put("rgn_grp_avc_rmk", "rgnGrpAvcRmk");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("charge_nm", "chargeNm");
		this.hashFields.put("charge_flg", "chargeFlg");
		this.hashFields.put("rt_bl_tp_cd", "rtBlTpCd");
		this.hashFields.put("rt_bl_tp_nm", "rtBlTpNm");
		this.hashFields.put("bill_type_b", "billTypeB");
		this.hashFields.put("bill_type_c", "billTypeC");
		this.hashFields.put("bill_type_n", "billTypeN");
		this.hashFields.put("bill_type_m", "billTypeM");
		this.hashFields.put("pol_etd", "polEtd");//추가
		this.hashFields.put("row_cnt", "rowCnt");
		this.hashFields.put("bl_cnt", "blCnt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_rev_aud_tp_cd", "bkgRevAudTpCd");
		this.hashFields.put("bkg_rev_aud_seq", "bkgRevAudSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("umch_bkg_seq", "umchBkgSeq");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rdn_sts_nm", "rdnStsNm");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return crrHngrSglBarQty
	 */
	public String getCrrHngrSglBarQty() {
		return this.crrHngrSglBarQty;
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
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return rtAplyDt
	 */
	public String getRtAplyDt() {
		return this.rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @return bkgRhqCd
	 */
	public String getBkgRhqCd() {
		return this.bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @return searchDate
	 */
	public String getSearchDate() {
		return this.searchDate;
	}
	
	/**
	 * Column Info
	 * @return rdnNo
	 */
	public String getRdnNo() {
		return this.rdnNo;
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
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return ctrtNo
	 */
	public String getCtrtNo() {
		return this.ctrtNo;
	}
	
	/**
	 * Column Info
	 * @return crrHngrDblBarQty
	 */
	public String getCrrHngrDblBarQty() {
		return this.crrHngrDblBarQty;
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
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @return bkgCtrtTpCd
	 */
	public String getBkgCtrtTpCd() {
		return this.bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @return merHngrQty
	 */
	public String getMerHngrQty() {
		return this.merHngrQty;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chgUtAmt
	 */
	public String getChgUtAmt() {
		return this.chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @return crrHngrQty
	 */
	public String getCrrHngrQty() {
		return this.crrHngrQty;
	}
	
	/**
	 * Column Info
	 * @return ctrtCntrTpszCd
	 */
	public String getCtrtCntrTpszCd() {
		return this.ctrtCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return ctrtCntrTpszCd2
	 */
	public String getCtrtCntrTpszCd2() {
		return this.ctrtCntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return ratAsQty
	 */
	public String getRatAsQty() {
		return this.ratAsQty;
	}
	
	/**
	 * Column Info
	 * @return crrHngrTplBarQty
	 */
	public String getCrrHngrTplBarQty() {
		return this.crrHngrTplBarQty;
	}
	
	/**
	 * Column Info
	 * @return splitNm
	 */
	public String getSplitNm() {
		return this.splitNm;
	}
	
	/**
	 * Column Info
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
	}
	
	/**
	 * Column Info
	 * @return umchRsnRmk
	 */
	public String getUmchRsnRmk() {
		return this.umchRsnRmk;
	}
	
	/**
	 * Column Info
	 * @return rgnGrpAvcRmk
	 */
	public String getRgnGrpAvcRmk() {
		return this.rgnGrpAvcRmk;
	}
	
	/**
	 * Column Info
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
	}
	
	/**
	 * Column Info
	 * @return chargeNm
	 */
	public String getChargeNm() {
		return this.chargeNm;
	}
	
	/**
	 * Column Info
	 * @return chargeFlg
	 */
	public String getChargeFlg() {
		return this.chargeFlg;
	}
	
	/**
	 * Column Info
	 * @return rtBlTpCd
	 */
	public String getRtBlTpCd() {
		return this.rtBlTpCd;
	}
	
	/**
	 * Column Info
	 * @return billTypeB
	 */
	public String getBillTypeB() {
		return this.billTypeB;
	}
	
	/**
	 * Column Info
	 * @return billTypeC
	 */
	public String getBillTypeC() {
		return this.billTypeC;
	}
	
	/**
	 * Column Info
	 * @return billTypeN
	 */
	public String getBillTypeN() {
		return this.billTypeN;
	}
	
	/**
	 * Column Info
	 * @return billTypeM
	 */
	public String getBillTypeM() {
		return this.billTypeM;
	}
	
	/**
	 * Column Info
	 * @return rtBlTpNm
	 */
	public String getRtBlTpNm() {
		return this.rtBlTpNm;
	}
	
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getPolEtd() {    //추가
		return this.polEtd;    
	}

	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getRowCnt() {    //추가
		return this.rowCnt;    
	}
	
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getBlCnt() {    //추가
		return this.blCnt;    
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return updUsrId
	 */
	public String getBkgRevAudTpCd() {
		return this.bkgRevAudTpCd;
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
	 * @return updUsrId
	 */
	public String getBkgRevAudSeq() {
		return this.bkgRevAudSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return umchBkgSeq
	 */
	public String getUmchBkgSeq() {
		return this.umchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return rdnStsNm
	 */
	public String getRdnStsNm() {
		return this.rdnStsNm;
	}
	

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param crrHngrSglBarQty
	 */
	public void setCrrHngrSglBarQty(String crrHngrSglBarQty) {
		this.crrHngrSglBarQty = crrHngrSglBarQty;
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
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param rtAplyDt
	 */
	public void setRtAplyDt(String rtAplyDt) {
		this.rtAplyDt = rtAplyDt;
	}
	
	/**
	 * Column Info
	 * @param bkgRhqCd
	 */
	public void setBkgRhqCd(String bkgRhqCd) {
		this.bkgRhqCd = bkgRhqCd;
	}
	
	/**
	 * Column Info
	 * @param searchDate
	 */
	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}
	
	/**
	 * Column Info
	 * @param rdnNo
	 */
	public void setRdnNo(String rdnNo) {
		this.rdnNo = rdnNo;
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
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param ctrtNo
	 */
	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}
	
	/**
	 * Column Info
	 * @param crrHngrDblBarQty
	 */
	public void setCrrHngrDblBarQty(String crrHngrDblBarQty) {
		this.crrHngrDblBarQty = crrHngrDblBarQty;
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
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
	}
	
	/**
	 * Column Info
	 * @param bkgCtrtTpCd
	 */
	public void setBkgCtrtTpCd(String bkgCtrtTpCd) {
		this.bkgCtrtTpCd = bkgCtrtTpCd;
	}
	
	/**
	 * Column Info
	 * @param merHngrQty
	 */
	public void setMerHngrQty(String merHngrQty) {
		this.merHngrQty = merHngrQty;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chgUtAmt
	 */
	public void setChgUtAmt(String chgUtAmt) {
		this.chgUtAmt = chgUtAmt;
	}
	
	/**
	 * Column Info
	 * @param crrHngrQty
	 */
	public void setCrrHngrQty(String crrHngrQty) {
		this.crrHngrQty = crrHngrQty;
	}
	
	/**
	 * Column Info
	 * @param ctrtCntrTpszCd
	 */
	public void setCtrtCntrTpszCd(String ctrtCntrTpszCd) {
		this.ctrtCntrTpszCd = ctrtCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param ctrtCntrTpszCd2
	 */
	public void setCtrtCntrTpszCd2(String ctrtCntrTpszCd2) {
		this.ctrtCntrTpszCd2 = ctrtCntrTpszCd2;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param ratAsQty
	 */
	public void setRatAsQty(String ratAsQty) {
		this.ratAsQty = ratAsQty;
	}
	
	/**
	 * Column Info
	 * @param crrHngrTplBarQty
	 */
	public void setCrrHngrTplBarQty(String crrHngrTplBarQty) {
		this.crrHngrTplBarQty = crrHngrTplBarQty;
	}
	
	/**
	 * Column Info
	 * @param splitNm
	 */
	public void setSplitNm(String splitNm) {
		this.splitNm = splitNm;
	}
	
	/**
	 * Column Info
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}
	
	/**
	 * Column Info
	 * @param umchRsnRmk
	 */
	public void setUmchRsnRmk(String umchRsnRmk) {
		this.umchRsnRmk = umchRsnRmk;
	}
	
	/**
	 * Column Info
	 * @param rgnGrpAvcRmk
	 */
	public void setRgnGrpAvcRmk(String rgnGrpAvcRmk) {
		this.rgnGrpAvcRmk = rgnGrpAvcRmk;
	}
	
	/**
	 * Column Info
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
	}
	
	/**
	 * Column Info
	 * @param chargeNm
	 */
	public void setChargeNm(String chargeNm) {
		this.chargeNm = chargeNm;
	}
	
	/**
	 * Column Info
	 * @param chargeFlg
	 */
	public void setChargeFlg(String chargeFlg) {
		this.chargeFlg = chargeFlg;
	}
	
	/**
	 * Column Info
	 * @param rtBlTpCd
	 */
	public void setRtBlTpCd(String rtBlTpCd) {
		this.rtBlTpCd = rtBlTpCd;
	}
	
	/**
	 * Column Info
	 * @param billTypeB
	 */
	public void setBillTypeB(String billTypeB) {
		this.billTypeB = billTypeB;
	}
	
	/**
	 * Column Info
	 * @param billTypeC
	 */
	public void setBillTypeC(String billTypeC) {
		this.billTypeC = billTypeC;
	}
	
	/**
	 * Column Info
	 * @param billTypeN
	 */
	public void setBillTypeN(String billTypeN) {
		this.billTypeN = billTypeN;
	}
	
	/**
	 * Column Info
	 * @param billTypeM
	 */
	public void setBillTypeM(String billTypeM) {
		this.billTypeM = billTypeM;
	}
	
	/**
	 * Column Info
	 * @param rtBlTpNm
	 */
	public void setRtBlTpNm(String rtBlTpNm) {
		this.rtBlTpNm = rtBlTpNm;
	}
	
	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setPolEtd(String polEtd) { //추가
		this.polEtd = polEtd;
	}
	
	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setRowCnt(String rowCnt) { //추가
		this.rowCnt = rowCnt;
	}
	
	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setBlCnt(String blCnt) { //추가
		this.blCnt = blCnt;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setBkgRevAudTpCd(String bkgRevAudTpCd) {
		this.bkgRevAudTpCd = bkgRevAudTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setBkgRevAudSeq(String bkgRevAudSeq) {
		this.bkgRevAudSeq = bkgRevAudSeq;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param umchBkgSeq
	 */
	public void setUmchBkgSeq(String umchBkgSeq) {
		this.umchBkgSeq = umchBkgSeq;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param rdnStsNm
	 */
	public void setRdnStsNm(String rdnStsNm) {
		this.rdnStsNm = rdnStsNm;
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
		setFromDt(JSPUtil.getParameter(request, prefix + "from_dt", ""));
		setCrrHngrSglBarQty(JSPUtil.getParameter(request, prefix + "crr_hngr_sgl_bar_qty", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setRtAplyDt(JSPUtil.getParameter(request, prefix + "rt_aply_dt", ""));
		setBkgRhqCd(JSPUtil.getParameter(request, prefix + "bkg_rhq_cd", ""));
		setSearchDate(JSPUtil.getParameter(request, prefix + "search_date", ""));
		setRdnNo(JSPUtil.getParameter(request, prefix + "rdn_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setChgCd(JSPUtil.getParameter(request, prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtNo(JSPUtil.getParameter(request, prefix + "ctrt_no", ""));
		setCrrHngrDblBarQty(JSPUtil.getParameter(request, prefix + "crr_hngr_dbl_bar_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChgAmt(JSPUtil.getParameter(request, prefix + "chg_amt", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request, prefix + "bkg_ctrt_tp_cd", ""));
		setMerHngrQty(JSPUtil.getParameter(request, prefix + "mer_hngr_qty", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setChgUtAmt(JSPUtil.getParameter(request, prefix + "chg_ut_amt", ""));
		setCrrHngrQty(JSPUtil.getParameter(request, prefix + "crr_hngr_qty", ""));
		setCtrtCntrTpszCd(JSPUtil.getParameter(request, prefix + "ctrt_cntr_tpsz_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCtrtCntrTpszCd2(JSPUtil.getParameter(request, prefix + "ctrt_cntr_tpsz_cd2", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setRatAsQty(JSPUtil.getParameter(request, prefix + "rat_as_qty", ""));
		setCrrHngrTplBarQty(JSPUtil.getParameter(request, prefix + "crr_hngr_tpl_bar_qty", ""));
		setSplitNm(JSPUtil.getParameter(request, prefix + "split_nm", ""));
		setSplitFlg(JSPUtil.getParameter(request, prefix + "split_flg", ""));
		setUmchRsnRmk(JSPUtil.getParameter(request, prefix + "umch_rsn_rmk", ""));
		setRgnGrpAvcRmk(JSPUtil.getParameter(request, prefix + "rgn_grp_avc_rmk", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setChargeFlg(JSPUtil.getParameter(request, prefix + "charge_flg", ""));
		setChargeNm(JSPUtil.getParameter(request, prefix + "charge_nm", ""));
		setRtBlTpCd(JSPUtil.getParameter(request, prefix + "rt_bl_tp_cd", ""));
		setRtBlTpNm(JSPUtil.getParameter(request, prefix + "rt_bl_tp_nm", ""));
		setBillTypeB(JSPUtil.getParameter(request, prefix + "bill_type_b", ""));
		setBillTypeC(JSPUtil.getParameter(request, prefix + "bill_type_c", ""));
		setBillTypeN(JSPUtil.getParameter(request, prefix + "bill_type_n", ""));
		setBillTypeM(JSPUtil.getParameter(request, prefix + "bill_type_m", ""));
		setPolEtd(JSPUtil.getParameter(request, prefix + "pol_etd", "")); //추가
		setRowCnt(JSPUtil.getParameter(request, prefix + "row_cnt", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix +"upd_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix +"cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request, prefix +"cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix +"upd_usr_id", ""));
		setBkgRevAudTpCd(JSPUtil.getParameter(request, prefix +"bkg_rev_aud_tp_cd", ""));
		setBkgRevAudSeq(JSPUtil.getParameter(request, prefix +"bkg_rev_aud_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix +"cntr_tpsz_cd", ""));
		setUmchBkgSeq(JSPUtil.getParameter(request, "umch_bkg_seq", ""));
		setUsrId(JSPUtil.getParameter(request, prefix +"usr_id", ""));
		setRdnStsNm(JSPUtil.getParameter(request, prefix + "rdn_sts_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchAuditByHangerInstallationListVO[]
	 */
	public RsltSearchAuditByHangerInstallationListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltSearchAuditByHangerInstallationListVO[]
	 */
	public RsltSearchAuditByHangerInstallationListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltSearchAuditByHangerInstallationListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] crrHngrSglBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_sgl_bar_qty", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rtAplyDt = (JSPUtil.getParameter(request, prefix	+ "rt_aply_dt", length));
			String[] bkgRhqCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rhq_cd", length));
			String[] searchDate = (JSPUtil.getParameter(request, prefix	+ "search_date", length));
			String[] rdnNo = (JSPUtil.getParameter(request, prefix	+ "rdn_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtNo = (JSPUtil.getParameter(request, prefix	+ "ctrt_no", length));
			String[] crrHngrDblBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_dbl_bar_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			String[] bkgCtrtTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ctrt_tp_cd", length));
			String[] merHngrQty = (JSPUtil.getParameter(request, prefix	+ "mer_hngr_qty", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] chgUtAmt = (JSPUtil.getParameter(request, prefix	+ "chg_ut_amt", length));
			String[] crrHngrQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_qty", length));
			String[] ctrtCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cntr_tpsz_cd", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ctrtCntrTpszCd2 = (JSPUtil.getParameter(request, prefix	+ "ctrt_cntr_tpsz_cd2", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] ratAsQty = (JSPUtil.getParameter(request, prefix	+ "rat_as_qty", length));
			String[] crrHngrTplBarQty = (JSPUtil.getParameter(request, prefix	+ "crr_hngr_tpl_bar_qty", length));
			String[] splitNm = (JSPUtil.getParameter(request, prefix	+ "split_nm", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] umchRsnRmk = (JSPUtil.getParameter(request, prefix	+ "umch_rsn_rmk", length));
			String[] rgnGrpAvcRmk = (JSPUtil.getParameter(request, prefix	+ "rgn_grp_avc_rmk", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] chargeFlg = (JSPUtil.getParameter(request, prefix	+ "charge_flg", length));
			String[] chargeNm = (JSPUtil.getParameter(request, prefix	+ "charge_nm", length));
			String[] rtBlTpCd = (JSPUtil.getParameter(request, prefix	+ "rt_bl_tp_cd", length));
			String[] rtBlTpNm = (JSPUtil.getParameter(request, prefix	+ "rt_bl_tp_nm", length));
			String[] billTypeB = (JSPUtil.getParameter(request, prefix	+ "bill_type_b", length));
			String[] billTypeC = (JSPUtil.getParameter(request, prefix	+ "bill_type_c", length));
			String[] billTypeN = (JSPUtil.getParameter(request, prefix	+ "bill_type_n", length));
			String[] billTypeM = (JSPUtil.getParameter(request, prefix	+ "bill_type_m", length));
			String[] polEtd = (JSPUtil.getParameter(request, prefix	+ "pol_etd", length));//추가
			String[] rowCnt = (JSPUtil.getParameter(request, prefix	+ "row_cnt", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] bkgRevAudTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rev_aud_tp_cd", length));
			String[] bkgRevAudSeq = (JSPUtil.getParameter(request, prefix	+ "bkg_rev_aud_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] umchBkgSeq = (JSPUtil.getParameter(request, prefix	+ "umch_bkg_seq", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] rdnStsNm = (JSPUtil.getParameter(request, prefix	+ "rdn_sts_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltSearchAuditByHangerInstallationListVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (crrHngrSglBarQty[i] != null)
					model.setCrrHngrSglBarQty(crrHngrSglBarQty[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rtAplyDt[i] != null)
					model.setRtAplyDt(rtAplyDt[i]);
				if (bkgRhqCd[i] != null)
					model.setBkgRhqCd(bkgRhqCd[i]);
				if (searchDate[i] != null)
					model.setSearchDate(searchDate[i]);
				if (rdnNo[i] != null)
					model.setRdnNo(rdnNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtNo[i] != null)
					model.setCtrtNo(ctrtNo[i]);
				if (crrHngrDblBarQty[i] != null)
					model.setCrrHngrDblBarQty(crrHngrDblBarQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				if (bkgCtrtTpCd[i] != null)
					model.setBkgCtrtTpCd(bkgCtrtTpCd[i]);
				if (merHngrQty[i] != null)
					model.setMerHngrQty(merHngrQty[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (chgUtAmt[i] != null)
					model.setChgUtAmt(chgUtAmt[i]);
				if (crrHngrQty[i] != null)
					model.setCrrHngrQty(crrHngrQty[i]);
				if (ctrtCntrTpszCd[i] != null)
					model.setCtrtCntrTpszCd(ctrtCntrTpszCd[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ctrtCntrTpszCd2[i] != null)
					model.setCtrtCntrTpszCd2(ctrtCntrTpszCd2[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (ratAsQty[i] != null)
					model.setRatAsQty(ratAsQty[i]);
				if (crrHngrTplBarQty[i] != null)
					model.setCrrHngrTplBarQty(crrHngrTplBarQty[i]);
				if (splitNm[i] != null)
					model.setSplitNm(splitNm[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (umchRsnRmk[i] != null)
					model.setUmchRsnRmk(umchRsnRmk[i]);
				if (rgnGrpAvcRmk[i] != null)
					model.setRgnGrpAvcRmk(rgnGrpAvcRmk[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (chargeNm[i] != null)
					model.setChargeNm(chargeNm[i]);
				if (chargeFlg[i] != null)
					model.setChargeFlg(chargeFlg[i]);
				if (rtBlTpCd[i] != null)
					model.setRtBlTpCd(rtBlTpCd[i]);
				if (rtBlTpNm[i] != null)
					model.setRtBlTpNm(rtBlTpNm[i]);
				if (billTypeB[i] != null)
					model.setBillTypeB(billTypeB[i]);
				if (billTypeC[i] != null)
					model.setBillTypeC(billTypeC[i]);
				if (billTypeN[i] != null)
					model.setBillTypeN(billTypeN[i]);
				if (billTypeM[i] != null)
					model.setBillTypeM(billTypeM[i]);
				if (polEtd[i] != null) //추가
					model.setPolEtd(polEtd[i]);
				if (blCnt[i] != null) //추가
					model.setBlCnt(blCnt[i]);
				if (rowCnt[i] != null) //추가
					model.setRowCnt(rowCnt[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (bkgRevAudTpCd[i] != null)
					model.setBkgRevAudTpCd(bkgRevAudTpCd[i]);
				if (bkgRevAudSeq[i] != null)
					model.setBkgRevAudSeq(bkgRevAudSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (umchBkgSeq[i] != null)
					model.setUmchBkgSeq(umchBkgSeq[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (rdnStsNm[i] != null)
					model.setRdnStsNm(rdnStsNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltSearchAuditByHangerInstallationListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltSearchAuditByHangerInstallationListVO[]
	 */
	public RsltSearchAuditByHangerInstallationListVO[] getRsltSearchAuditByHangerInstallationListVOs(){
		RsltSearchAuditByHangerInstallationListVO[] vos = (RsltSearchAuditByHangerInstallationListVO[])models.toArray(new RsltSearchAuditByHangerInstallationListVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrSglBarQty = this.crrHngrSglBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtAplyDt = this.rtAplyDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRhqCd = this.bkgRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDate = this.searchDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnNo = this.rdnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo = this.ctrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrDblBarQty = this.crrHngrDblBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd = this.bkgCtrtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.merHngrQty = this.merHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgUtAmt = this.chgUtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrQty = this.crrHngrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCntrTpszCd = this.ctrtCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCntrTpszCd2 = this.ctrtCntrTpszCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsQty = this.ratAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrHngrTplBarQty = this.crrHngrTplBarQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitNm = this.splitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchRsnRmk = this.umchRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnGrpAvcRmk = this.rgnGrpAvcRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeNm = this.chargeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeFlg = this.chargeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtBlTpCd = this.rtBlTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtBlTpNm = this.rtBlTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billTypeB = this.billTypeB .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billTypeC = this.billTypeC .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billTypeN = this.billTypeN .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billTypeM = this.billTypeM .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd = this.polEtd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");//추가
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowCnt = this.rowCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRevAudTpCd = this.bkgRevAudTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRevAudSeq = this.bkgRevAudSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.umchBkgSeq = this.umchBkgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdnStsNm = this.rdnStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
