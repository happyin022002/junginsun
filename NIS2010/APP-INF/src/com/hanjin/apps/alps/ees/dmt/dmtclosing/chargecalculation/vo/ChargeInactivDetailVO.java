/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChargeInactivDetailVO.java
*@FileTitle : ChargeInactivDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.06
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.06  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ChargeInactivDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ChargeInactivDetailVO> models = new ArrayList<ChargeInactivDetailVO>();
	
	/* Column Info */
	private String cntrCycNo = null;
	/* Column Info */
	private String chgSeq = null;
	/* Column Info */
	private String detail3Type = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String svrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deltSpecRsnRmkSeq = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String deltRmk = null;
	/* Column Info */
	private String inactAproNo = null;
	/* Column Info */
	private String dmdtChgDeltSpecRsnCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String detail4Type = null;
	/* Column Info */
	private String dmdtChgLocDivCd = null;
	/* Column Info */
	private String fileSavId = null;
	/* Column Info */
	private String chgType = null;
	/* Column Info */
	private String detail2Type = null;
	/* Column Info */
	private String detail1Type = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String detail5Type = null;
	/* Column Info */
	private String detail6Type = null;
	/* Column Info */
	private String inactRqstNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String chgDeltSpecRsnRmk = null;
	/* Column Info */
	private String deltSeq = null;
	/* Column Info */
	private String fileFlg = null;
	/* Column Info */
	private String chgDeltUsrYn = null;
	/* Column Info */
	private String fmMvmtDt = null;
	/* Column Info */
	private String toMvmtDt = null;
	/* Column Info */
	private String ftCmncDt = null;
	/* Column Info */
	private String ftEndDt = null;
	/* Column Info */
	private String bilAmt = null;
	/* Column Info */
	private String detail7Type = null;
	/* Column Info */
	private String detail8Type = null;
	/* Column Info */
	private String detail9Type = null;
	/* Column Info */
	private String ofcRhqCd = null;
	/* Column Info */
	private String fmMvmtStsCd = null;
	/* Column Info */
	private String toMvmtStsCd = null;
	/* Column Info */
	private String fmMvmtYdCd = null;
	/* Column Info */
	private String toMvmtYdCd = null;
	/* Column Info */
	private String bkgRcvTermCd = null;
	/* Column Info */
	private String bkgDeTermCd = null;
	/* Column Info */
	private String ch = null;
	/* Column Info */
	private String bzcTrfCurrCd = null;
	/* Column Info */
	private String fxFtOvrDys = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ChargeInactivDetailVO() {}

	public ChargeInactivDetailVO(String ibflag, String pagerows, String svrId, String cntrNo, String cntrCycNo, String dmdtTrfCd, String dmdtChgLocDivCd, String chgSeq, String ofcCd, String bkgNo, String chgType, String cntrTpszCd, String dmdtChgDeltSpecRsnCd, String deltRmk, String deltSpecRsnRmkSeq, String stsCd, String detail1Type, String detail2Type, String detail3Type, String detail4Type, String detail5Type, String detail6Type, String chgDeltSpecRsnRmk, String fileSavId, String inactAproNo, String inactRqstNo, String deltSeq, String fileFlg, String chgDeltUsrYn, String fmMvmtDt, String toMvmtDt, String ftCmncDt, String ftEndDt, String bilAmt, String detail7Type, String detail8Type, String detail9Type, String ofcRhqCd, String fmMvmtStsCd, String toMvmtStsCd, String fmMvmtYdCd, String toMvmtYdCd, String bkgRcvTermCd, String bkgDeTermCd, String ch, String bzcTrfCurrCd, String fxFtOvrDys ) {
		this.cntrCycNo = cntrCycNo;
		this.chgSeq = chgSeq;
		this.detail3Type = detail3Type;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.svrId = svrId;
		this.ibflag = ibflag;
		this.deltSpecRsnRmkSeq = deltSpecRsnRmkSeq;
		this.cntrTpszCd = cntrTpszCd;
		this.deltRmk = deltRmk;
		this.inactAproNo = inactAproNo;
		this.dmdtChgDeltSpecRsnCd = dmdtChgDeltSpecRsnCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.detail4Type = detail4Type;
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
		this.fileSavId = fileSavId;
		this.chgType = chgType;
		this.detail2Type = detail2Type;
		this.detail1Type = detail1Type;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.detail5Type = detail5Type;
		this.detail6Type = detail6Type;
		this.inactRqstNo = inactRqstNo;
		this.cntrNo = cntrNo;
		this.chgDeltSpecRsnRmk = chgDeltSpecRsnRmk;
		this.deltSeq = deltSeq;
		this.fileFlg = fileFlg;
		this.chgDeltUsrYn = chgDeltUsrYn;
		this.fmMvmtDt = fmMvmtDt;
		this.toMvmtDt = toMvmtDt;
		this.ftCmncDt = ftCmncDt;
		this.ftEndDt = ftEndDt;
		this.bilAmt = bilAmt;
		this.detail7Type = detail7Type;
		this.detail8Type = detail8Type;
		this.detail9Type = detail9Type;
		this.ofcRhqCd = ofcRhqCd;
		this.fmMvmtStsCd = fmMvmtStsCd;
		this.toMvmtStsCd = toMvmtStsCd;
		this.fmMvmtYdCd = fmMvmtYdCd;
		this.toMvmtYdCd = toMvmtYdCd;
		this.bkgRcvTermCd = bkgRcvTermCd;
		this.bkgDeTermCd = bkgDeTermCd;
		this.ch = ch;
		this.bzcTrfCurrCd = bzcTrfCurrCd;
		this.fxFtOvrDys = fxFtOvrDys;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_cyc_no", getCntrCycNo());
		this.hashColumns.put("chg_seq", getChgSeq());
		this.hashColumns.put("detail_3_type", getDetail3Type());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("svr_id", getSvrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_spec_rsn_rmk_seq", getDeltSpecRsnRmkSeq());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("delt_rmk", getDeltRmk());
		this.hashColumns.put("inact_apro_no", getInactAproNo());
		this.hashColumns.put("dmdt_chg_delt_spec_rsn_cd", getDmdtChgDeltSpecRsnCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("detail_4_type", getDetail4Type());
		this.hashColumns.put("dmdt_chg_loc_div_cd", getDmdtChgLocDivCd());
		this.hashColumns.put("file_sav_id", getFileSavId());
		this.hashColumns.put("chg_type", getChgType());
		this.hashColumns.put("detail_2_type", getDetail2Type());
		this.hashColumns.put("detail_1_type", getDetail1Type());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("detail_5_type", getDetail5Type());
		this.hashColumns.put("detail_6_type", getDetail6Type());
		this.hashColumns.put("inact_rqst_no", getInactRqstNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("chg_delt_spec_rsn_rmk", getChgDeltSpecRsnRmk());
		this.hashColumns.put("delt_seq", getDeltSeq());
		this.hashColumns.put("file_flg", getFileFlg());
		this.hashColumns.put("chg_delt_usr_yn", getChgDeltUsrYn());
		this.hashColumns.put("fm_mvmt_dt", getFmMvmtDt());
		this.hashColumns.put("to_mvmt_dt", getToMvmtDt());
		this.hashColumns.put("ft_cmnc_dt", getFtCmncDt());
		this.hashColumns.put("ft_end_dt", getFtEndDt());
		this.hashColumns.put("bil_amt", getBilAmt());
		this.hashColumns.put("detail_7_type", getDetail7Type());
		this.hashColumns.put("detail_8_type", getDetail8Type());
		this.hashColumns.put("detail_9_type", getDetail9Type());
		this.hashColumns.put("ofc_rhq_cd", getOfcRhqCd());
		this.hashColumns.put("fm_mvmt_sts_cd", getFmMvmtStsCd());
		this.hashColumns.put("to_mvmt_sts_cd", getToMvmtStsCd());
		this.hashColumns.put("fm_mvmt_yd_cd", getFmMvmtYdCd());
		this.hashColumns.put("to_mvmt_yd_cd", getToMvmtYdCd());
		this.hashColumns.put("bkg_rcv_term_cd", getBkgRcvTermCd());
		this.hashColumns.put("bkg_de_term_cd", getBkgDeTermCd());
		this.hashColumns.put("ch", getCh());
		this.hashColumns.put("bzcTrfCurrCd", getBzcTrfCurrCd());
		this.hashColumns.put("fx_ft_ovr_dys", getFxFtOvrDys());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cntr_cyc_no", "cntrCycNo");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("detail_3_type", "detail3Type");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_spec_rsn_rmk_seq", "deltSpecRsnRmkSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("delt_rmk", "deltRmk");
		this.hashFields.put("inact_apro_no", "inactAproNo");
		this.hashFields.put("dmdt_chg_delt_spec_rsn_cd", "dmdtChgDeltSpecRsnCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("detail_4_type", "detail4Type");
		this.hashFields.put("dmdt_chg_loc_div_cd", "dmdtChgLocDivCd");
		this.hashFields.put("file_sav_id", "fileSavId");
		this.hashFields.put("chg_type", "chgType");
		this.hashFields.put("detail_2_type", "detail2Type");
		this.hashFields.put("detail_1_type", "detail1Type");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("detail_5_type", "detail5Type");
		this.hashFields.put("detail_6_type", "detail6Type");
		this.hashFields.put("inact_rqst_no", "inactRqstNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("chg_delt_spec_rsn_rmk", "chgDeltSpecRsnRmk");
		this.hashFields.put("delt_seq", "deltSeq");
		this.hashFields.put("file_flg", "fileFlg");
		this.hashFields.put("chg_delt_usr_yn", "chgDeltUsrYn");
		this.hashFields.put("fm_mvmt_dt", "fmMvmtDt");
		this.hashFields.put("to_mvmt_dt", "toMvmtDt");
		this.hashFields.put("ft_cmnc_dt", "ftCmncDt");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("bil_amt", "bilAmt");
		this.hashFields.put("detail_7_type", "detail7Type");
		this.hashFields.put("detail_8_type", "detail8Type");
		this.hashFields.put("detail_9_type", "detail9Type");
		this.hashFields.put("ofc_rhq_cd", "ofcRhqCd");
		this.hashFields.put("fm_mvmt_sts_cd", "fmMvmtStsCd");
		this.hashFields.put("to_mvmt_sts_cd", "toMvmtStsCd");
		this.hashFields.put("fm_mvmt_yd_cd", "fmMvmtYdCd");
		this.hashFields.put("to_mvmt_yd_cd", "toMvmtYdCd");
		this.hashFields.put("bkg_rcv_term_cd", "bkgRcvTermCd");
		this.hashFields.put("bkg_de_term_cd", "bkgDeTermCd");
		this.hashFields.put("ch", "ch");
		this.hashFields.put("bzc_trf_curr_cd", "bzcTrfCurrCd");
		this.hashFields.put("fx_ft_ovr_dys", "fxFtOvrDys");
		return this.hashFields;
	}
	
	
	
	public String getFmMvmtYdCd() {
		return fmMvmtYdCd;
	}

	public void setFmMvmtYdCd(String fmMvmtYdCd) {
		this.fmMvmtYdCd = fmMvmtYdCd;
	}

	public String getToMvmtYdCd() {
		return toMvmtYdCd;
	}

	public void setToMvmtYdCd(String toMvmtYdCd) {
		this.toMvmtYdCd = toMvmtYdCd;
	}

	public String getBkgRcvTermCd() {
		return bkgRcvTermCd;
	}

	public void setBkgRcvTermCd(String bkgRcvTermCd) {
		this.bkgRcvTermCd = bkgRcvTermCd;
	}

	public String getBkgDeTermCd() {
		return bkgDeTermCd;
	}

	public void setBkgDeTermCd(String bkgDeTermCd) {
		this.bkgDeTermCd = bkgDeTermCd;
	}
	
	public String getCh() {
		return ch;
	}
	
	public void setCh(String ch) {
		this.ch = ch;
	}
	
	public String getBzcTrfCurrCd() {
		return bzcTrfCurrCd;
	}
	
	public void setBzcTrfCurrCd(String bzcTrfCurrCd) {
		this.bzcTrfCurrCd = bzcTrfCurrCd;
	}

	/**
	 * Column Info
	 * @return cntrCycNo
	 */
	public String getCntrCycNo() {
		return this.cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @return chgSeq
	 */
	public String getChgSeq() {
		return this.chgSeq;
	}
	
	/**
	 * Column Info
	 * @return detail3Type
	 */
	public String getDetail3Type() {
		return this.detail3Type;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}
	
	/**
	 * Column Info
	 * @return svrId
	 */
	public String getSvrId() {
		return this.svrId;
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
	 * @return deltSpecRsnRmkSeq
	 */
	public String getDeltSpecRsnRmkSeq() {
		return this.deltSpecRsnRmkSeq;
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
	 * @return deltRmk
	 */
	public String getDeltRmk() {
		return this.deltRmk;
	}
	
	/**
	 * Column Info
	 * @return inactAproNo
	 */
	public String getInactAproNo() {
		return this.inactAproNo;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgDeltSpecRsnCd
	 */
	public String getDmdtChgDeltSpecRsnCd() {
		return this.dmdtChgDeltSpecRsnCd;
	}
	
	/**
	 * Column Info
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @return detail4Type
	 */
	public String getDetail4Type() {
		return this.detail4Type;
	}
	
	/**
	 * Column Info
	 * @return dmdtChgLocDivCd
	 */
	public String getDmdtChgLocDivCd() {
		return this.dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @return fileSavId
	 */
	public String getFileSavId() {
		return this.fileSavId;
	}
	
	/**
	 * Column Info
	 * @return chgType
	 */
	public String getChgType() {
		return this.chgType;
	}
	
	/**
	 * Column Info
	 * @return detail2Type
	 */
	public String getDetail2Type() {
		return this.detail2Type;
	}
	
	/**
	 * Column Info
	 * @return detail1Type
	 */
	public String getDetail1Type() {
		return this.detail1Type;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return detail5Type
	 */
	public String getDetail5Type() {
		return this.detail5Type;
	}
	
	/**
	 * Column Info
	 * @return detail6Type
	 */
	public String getDetail6Type() {
		return this.detail6Type;
	}
	
	/**
	 * Column Info
	 * @return inactRqstNo
	 */
	public String getInactRqstNo() {
		return this.inactRqstNo;
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
	 * @return chgDeltSpecRsnRmk
	 */
	public String getChgDeltSpecRsnRmk() {
		return this.chgDeltSpecRsnRmk;
	}
	

	/**
	 * Column Info
	 * @param cntrCycNo
	 */
	public void setCntrCycNo(String cntrCycNo) {
		this.cntrCycNo = cntrCycNo;
	}
	
	/**
	 * Column Info
	 * @param chgSeq
	 */
	public void setChgSeq(String chgSeq) {
		this.chgSeq = chgSeq;
	}
	
	/**
	 * Column Info
	 * @param detail3Type
	 */
	public void setDetail3Type(String detail3Type) {
		this.detail3Type = detail3Type;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}
	
	/**
	 * Column Info
	 * @param svrId
	 */
	public void setSvrId(String svrId) {
		this.svrId = svrId;
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
	 * @param deltSpecRsnRmkSeq
	 */
	public void setDeltSpecRsnRmkSeq(String deltSpecRsnRmkSeq) {
		this.deltSpecRsnRmkSeq = deltSpecRsnRmkSeq;
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
	 * @param deltRmk
	 */
	public void setDeltRmk(String deltRmk) {
		this.deltRmk = deltRmk;
	}
	
	/**
	 * Column Info
	 * @param inactAproNo
	 */
	public void setInactAproNo(String inactAproNo) {
		this.inactAproNo = inactAproNo;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgDeltSpecRsnCd
	 */
	public void setDmdtChgDeltSpecRsnCd(String dmdtChgDeltSpecRsnCd) {
		this.dmdtChgDeltSpecRsnCd = dmdtChgDeltSpecRsnCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Column Info
	 * @param detail4Type
	 */
	public void setDetail4Type(String detail4Type) {
		this.detail4Type = detail4Type;
	}
	
	/**
	 * Column Info
	 * @param dmdtChgLocDivCd
	 */
	public void setDmdtChgLocDivCd(String dmdtChgLocDivCd) {
		this.dmdtChgLocDivCd = dmdtChgLocDivCd;
	}
	
	/**
	 * Column Info
	 * @param fileSavId
	 */
	public void setFileSavId(String fileSavId) {
		this.fileSavId = fileSavId;
	}
	
	/**
	 * Column Info
	 * @param chgType
	 */
	public void setChgType(String chgType) {
		this.chgType = chgType;
	}
	
	/**
	 * Column Info
	 * @param detail2Type
	 */
	public void setDetail2Type(String detail2Type) {
		this.detail2Type = detail2Type;
	}
	
	/**
	 * Column Info
	 * @param detail1Type
	 */
	public void setDetail1Type(String detail1Type) {
		this.detail1Type = detail1Type;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param detail5Type
	 */
	public void setDetail5Type(String detail5Type) {
		this.detail5Type = detail5Type;
	}
	
	/**
	 * Column Info
	 * @param detail6Type
	 */
	public void setDetail6Type(String detail6Type) {
		this.detail6Type = detail6Type;
	}
	
	/**
	 * Column Info
	 * @param inactRqstNo
	 */
	public void setInactRqstNo(String inactRqstNo) {
		this.inactRqstNo = inactRqstNo;
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
	 * @param chgDeltSpecRsnRmk
	 */
	public void setChgDeltSpecRsnRmk(String chgDeltSpecRsnRmk) {
		this.chgDeltSpecRsnRmk = chgDeltSpecRsnRmk;
	}
	
	public String getDeltSeq() {
		return deltSeq;
	}

	public void setDeltSeq(String deltSeq) {
		this.deltSeq = deltSeq;
	}

	public String getFileFlg() {
		return fileFlg;
	}

	public void setFileFlg(String fileFlg) {
		this.fileFlg = fileFlg;
	}

	public String getChgDeltUsrYn() {
		return chgDeltUsrYn;
	}

	public void setChgDeltUsrYn(String chgDeltUsrYn) {
		this.chgDeltUsrYn = chgDeltUsrYn;
	}

	public String getFmMvmtDt() {
		return fmMvmtDt;
	}

	public void setFmMvmtDt(String fmMvmtDt) {
		this.fmMvmtDt = fmMvmtDt;
	}

	public String getToMvmtDt() {
		return toMvmtDt;
	}

	public void setToMvmtDt(String toMvmtDt) {
		this.toMvmtDt = toMvmtDt;
	}

	public String getFtCmncDt() {
		return ftCmncDt;
	}

	public void setFtCmncDt(String ftCmncDt) {
		this.ftCmncDt = ftCmncDt;
	}

	public String getFtEndDt() {
		return ftEndDt;
	}

	public void setFtEndDt(String ftEndDt) {
		this.ftEndDt = ftEndDt;
	}

	public String getBilAmt() {
		return bilAmt;
	}

	public void setBilAmt(String bilAmt) {
		this.bilAmt = bilAmt;
	}

	public String getDetail7Type() {
		return detail7Type;
	}

	public void setDetail7Type(String detail7Type) {
		this.detail7Type = detail7Type;
	}

	public String getDetail8Type() {
		return detail8Type;
	}

	public void setDetail8Type(String detail8Type) {
		this.detail8Type = detail8Type;
	}

	public String getDetail9Type() {
		return detail9Type;
	}

	public void setDetail9Type(String detail9Type) {
		this.detail9Type = detail9Type;
	}

	public String getOfcRhqCd() {
		return ofcRhqCd;
	}

	public void setOfcRhqCd(String ofcRhqCd) {
		this.ofcRhqCd = ofcRhqCd;
	}

	public String getFmMvmtStsCd() {
		return fmMvmtStsCd;
	}

	public void setFmMvmtStsCd(String fmMvmtStsCd) {
		this.fmMvmtStsCd = fmMvmtStsCd;
	}

	public String getToMvmtStsCd() {
		return toMvmtStsCd;
	}

	public void setToMvmtStsCd(String toMvmtStsCd) {
		this.toMvmtStsCd = toMvmtStsCd;
	}
	
	public String getFxFtOvrDys() {
		return fxFtOvrDys;
	}

	public void setFxFtOvrDys(String fxFtOvrDys) {
		this.fxFtOvrDys = fxFtOvrDys;
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
		setCntrCycNo(JSPUtil.getParameter(request, prefix + "cntr_cyc_no", ""));
		setChgSeq(JSPUtil.getParameter(request, prefix + "chg_seq", ""));
		setDetail3Type(JSPUtil.getParameter(request, prefix + "detail_3_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setSvrId(JSPUtil.getParameter(request, prefix + "svr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDeltSpecRsnRmkSeq(JSPUtil.getParameter(request, prefix + "delt_spec_rsn_rmk_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDeltRmk(JSPUtil.getParameter(request, prefix + "delt_rmk", ""));
		setInactAproNo(JSPUtil.getParameter(request, prefix + "inact_apro_no", ""));
		setDmdtChgDeltSpecRsnCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_delt_spec_rsn_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, prefix + "dmdt_trf_cd", ""));
		setDetail4Type(JSPUtil.getParameter(request, prefix + "detail_4_type", ""));
		setDmdtChgLocDivCd(JSPUtil.getParameter(request, prefix + "dmdt_chg_loc_div_cd", ""));
		setFileSavId(JSPUtil.getParameter(request, prefix + "file_sav_id", ""));
		setChgType(JSPUtil.getParameter(request, prefix + "chg_type", ""));
		setDetail2Type(JSPUtil.getParameter(request, prefix + "detail_2_type", ""));
		setDetail1Type(JSPUtil.getParameter(request, prefix + "detail_1_type", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDetail5Type(JSPUtil.getParameter(request, prefix + "detail_5_type", ""));
		setDetail6Type(JSPUtil.getParameter(request, prefix + "detail_6_type", ""));
		setInactRqstNo(JSPUtil.getParameter(request, prefix + "inact_rqst_no", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setChgDeltSpecRsnRmk(JSPUtil.getParameter(request, prefix + "chg_delt_spec_rsn_rmk", ""));
		setDeltSeq(JSPUtil.getParameter(request, prefix + "delt_seq", ""));
		setFileFlg(JSPUtil.getParameter(request, prefix + "file_flg", ""));
		setChgDeltUsrYn(JSPUtil.getParameter(request, prefix + "chg_delt_usr_yn", ""));
		setFmMvmtDt(JSPUtil.getParameter(request, prefix + "fm_mvmt_dt", ""));
		setToMvmtDt(JSPUtil.getParameter(request, prefix + "to_mvmt_dt", ""));
		setFtCmncDt(JSPUtil.getParameter(request, prefix + "ft_cmnc_dt", ""));
		setFtEndDt(JSPUtil.getParameter(request, prefix + "ft_end_dt", ""));
		setBilAmt(JSPUtil.getParameter(request, prefix + "bil_amt", ""));
		setDetail7Type(JSPUtil.getParameter(request, prefix + "detail_7_type", ""));
		setDetail8Type(JSPUtil.getParameter(request, prefix + "detail_8_type", ""));
		setDetail9Type(JSPUtil.getParameter(request, prefix + "detail_9_type", ""));
		setOfcRhqCd(JSPUtil.getParameter(request, prefix + "ofc_rhq_cd", ""));
		setFmMvmtStsCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_sts_cd", ""));
		setToMvmtStsCd(JSPUtil.getParameter(request, prefix + "to_mvmt_sts_cd", ""));
		setFmMvmtYdCd(JSPUtil.getParameter(request, prefix + "fm_mvmt_yd_cd", ""));
		setToMvmtYdCd(JSPUtil.getParameter(request, prefix + "to_mvmt_yd_cd", ""));
		setBkgRcvTermCd(JSPUtil.getParameter(request, prefix + "bkg_rcv_term_cd", ""));
		setBkgDeTermCd(JSPUtil.getParameter(request, prefix + "bkg_de_term_cd", ""));
		setCh(JSPUtil.getParameter(request, prefix + "ch", ""));
		setBzcTrfCurrCd(JSPUtil.getParameter(request, prefix + "bzcTrfCurrCd", ""));
		setFxFtOvrDys(JSPUtil.getParameter(request, prefix + "fx_ft_ovr_dys", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChargeInactivDetailVO[]
	 */
	public ChargeInactivDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ChargeInactivDetailVO[]
	 */
	public ChargeInactivDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChargeInactivDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cntrCycNo = (JSPUtil.getParameter(request, prefix	+ "cntr_cyc_no", length));
			String[] chgSeq = (JSPUtil.getParameter(request, prefix	+ "chg_seq", length));
			String[] detail3Type = (JSPUtil.getParameter(request, prefix	+ "detail_3_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] svrId = (JSPUtil.getParameter(request, prefix	+ "svr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deltSpecRsnRmkSeq = (JSPUtil.getParameter(request, prefix	+ "delt_spec_rsn_rmk_seq", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] deltRmk = (JSPUtil.getParameter(request, prefix	+ "delt_rmk", length));
			String[] inactAproNo = (JSPUtil.getParameter(request, prefix	+ "inact_apro_no", length));
			String[] dmdtChgDeltSpecRsnCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_delt_spec_rsn_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] detail4Type = (JSPUtil.getParameter(request, prefix	+ "detail_4_type", length));
			String[] dmdtChgLocDivCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_chg_loc_div_cd", length));
			String[] fileSavId = (JSPUtil.getParameter(request, prefix	+ "file_sav_id", length));
			String[] chgType = (JSPUtil.getParameter(request, prefix	+ "chg_type", length));
			String[] detail2Type = (JSPUtil.getParameter(request, prefix	+ "detail_2_type", length));
			String[] detail1Type = (JSPUtil.getParameter(request, prefix	+ "detail_1_type", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] detail5Type = (JSPUtil.getParameter(request, prefix	+ "detail_5_type", length));
			String[] detail6Type = (JSPUtil.getParameter(request, prefix	+ "detail_6_type", length));
			String[] inactRqstNo = (JSPUtil.getParameter(request, prefix	+ "inact_rqst_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] chgDeltSpecRsnRmk = (JSPUtil.getParameter(request, prefix	+ "chg_delt_spec_rsn_rmk", length));
			String[] deltSeq = (JSPUtil.getParameter(request, prefix	+ "delt_seq", length));
			String[] fileFlg = (JSPUtil.getParameter(request, prefix	+ "file_flg", length));
			String[] chgDeltUsrYn = (JSPUtil.getParameter(request, prefix	+ "chg_delt_usr_yn", length));
			String[] fmMvmtDt = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_dt", length));
			String[] toMvmtDt = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_dt", length));
			String[] ftCmncDt = (JSPUtil.getParameter(request, prefix	+ "ft_cmnc_dt", length));
			String[] ftEndDt = (JSPUtil.getParameter(request, prefix	+ "ft_end_dt", length));
			String[] bilAmt = (JSPUtil.getParameter(request, prefix	+ "bil_amt", length));
			String[] detail7Type = (JSPUtil.getParameter(request, prefix	+ "detail_7_type", length));
			String[] detail8Type = (JSPUtil.getParameter(request, prefix	+ "detail_8_type", length));
			String[] detail9Type = (JSPUtil.getParameter(request, prefix	+ "detail_9_type", length));
			String[] ofcRhqCd = (JSPUtil.getParameter(request, prefix	+ "ofc_rhq_cd", length));
			String[] fmMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_sts_cd", length));
			String[] toMvmtStsCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_sts_cd", length));
			String[] fmMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "fm_mvmt_yd_cd", length));
			String[] toMvmtYdCd = (JSPUtil.getParameter(request, prefix	+ "to_mvmt_yd_cd", length));
			String[] bkgRcvTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_rcv_term_cd", length));
			String[] bkgDeTermCd = (JSPUtil.getParameter(request, prefix	+ "bkg_de_term_cd", length));
			String[] ch = (JSPUtil.getParameter(request, prefix	+ "ch", length));
			String[] bzcTrfCurrCd = (JSPUtil.getParameter(request, prefix	+ "bzcTrfCurrCd", length));
			String[] fxFtOvrDys = (JSPUtil.getParameter(request, prefix	+ "fx_ft_ovr_dys", length));
			
			for (int i = 0; i < length; i++) {
				model = new ChargeInactivDetailVO();
				if (cntrCycNo[i] != null)
					model.setCntrCycNo(cntrCycNo[i]);
				if (chgSeq[i] != null)
					model.setChgSeq(chgSeq[i]);
				if (detail3Type[i] != null)
					model.setDetail3Type(detail3Type[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (svrId[i] != null)
					model.setSvrId(svrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltSpecRsnRmkSeq[i] != null)
					model.setDeltSpecRsnRmkSeq(deltSpecRsnRmkSeq[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (deltRmk[i] != null)
					model.setDeltRmk(deltRmk[i]);
				if (inactAproNo[i] != null)
					model.setInactAproNo(inactAproNo[i]);
				if (dmdtChgDeltSpecRsnCd[i] != null)
					model.setDmdtChgDeltSpecRsnCd(dmdtChgDeltSpecRsnCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (detail4Type[i] != null)
					model.setDetail4Type(detail4Type[i]);
				if (dmdtChgLocDivCd[i] != null)
					model.setDmdtChgLocDivCd(dmdtChgLocDivCd[i]);
				if (fileSavId[i] != null)
					model.setFileSavId(fileSavId[i]);
				if (chgType[i] != null)
					model.setChgType(chgType[i]);
				if (detail2Type[i] != null)
					model.setDetail2Type(detail2Type[i]);
				if (detail1Type[i] != null)
					model.setDetail1Type(detail1Type[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (detail5Type[i] != null)
					model.setDetail5Type(detail5Type[i]);
				if (detail6Type[i] != null)
					model.setDetail6Type(detail6Type[i]);
				if (inactRqstNo[i] != null)
					model.setInactRqstNo(inactRqstNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (chgDeltSpecRsnRmk[i] != null)
					model.setChgDeltSpecRsnRmk(chgDeltSpecRsnRmk[i]);
				if (deltSeq[i] != null)
					model.setDeltSeq(deltSeq[i]);
				if (fileFlg[i] != null)
					model.setFileFlg(fileFlg[i]);
				if (chgDeltUsrYn[i] != null)
					model.setChgDeltUsrYn(chgDeltUsrYn[i]);
				if (fmMvmtDt[i] != null)
					model.setFmMvmtDt(fmMvmtDt[i]);
				if (toMvmtDt[i] != null)
					model.setToMvmtDt(toMvmtDt[i]);
				if (ftCmncDt[i] != null)
					model.setFtCmncDt(ftCmncDt[i]);
				if (ftEndDt[i] != null)
					model.setFtEndDt(ftEndDt[i]);
				if (bilAmt[i] != null)
					model.setBilAmt(bilAmt[i]);
				if (detail7Type[i] != null)
					model.setDetail7Type(detail7Type[i]);
				if (detail8Type[i] != null)
					model.setDetail8Type(detail8Type[i]);
				if (detail9Type[i] != null)
					model.setDetail9Type(detail9Type[i]);
				if (ofcRhqCd[i] != null)
					model.setOfcRhqCd(ofcRhqCd[i]);
				if (fmMvmtStsCd[i] != null)
					model.setFmMvmtStsCd(fmMvmtStsCd[i]);
				if (toMvmtStsCd[i] != null)
					model.setToMvmtStsCd(toMvmtStsCd[i]);
				if (fmMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtStsCd[i]);
				if (toMvmtYdCd[i] != null)
					model.setToMvmtYdCd(toMvmtStsCd[i]);
				if (bkgRcvTermCd[i] != null)
					model.setBkgRcvTermCd(bkgRcvTermCd[i]);
				if (bkgDeTermCd[i] != null)
					model.setBkgDeTermCd(bkgDeTermCd[i]);
				if (ch[i] != null)
					model.setCh(ch[i]);
				if (bzcTrfCurrCd[i] != null)
					model.setBzcTrfCurrCd(bzcTrfCurrCd[i]);
				if (fxFtOvrDys[i] != null)
					model.setFxFtOvrDys(fxFtOvrDys[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChargeInactivDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChargeInactivDetailVO[]
	 */
	public ChargeInactivDetailVO[] getChargeInactivDetailVOs(){
		ChargeInactivDetailVO[] vos = (ChargeInactivDetailVO[])models.toArray(new ChargeInactivDetailVO[models.size()]);
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
		this.cntrCycNo = this.cntrCycNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq = this.chgSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail3Type = this.detail3Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId = this.svrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltSpecRsnRmkSeq = this.deltSpecRsnRmkSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltRmk = this.deltRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactAproNo = this.inactAproNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgDeltSpecRsnCd = this.dmdtChgDeltSpecRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail4Type = this.detail4Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtChgLocDivCd = this.dmdtChgLocDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSavId = this.fileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgType = this.chgType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail2Type = this.detail2Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail1Type = this.detail1Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail5Type = this.detail5Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail6Type = this.detail6Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inactRqstNo = this.inactRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltSpecRsnRmk = this.chgDeltSpecRsnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltSeq = this.deltSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileFlg = this.fileFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgDeltUsrYn = this.chgDeltUsrYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtDt = this.fmMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtDt = this.toMvmtDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftCmncDt = this.ftCmncDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt = this.ftEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilAmt = this.bilAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail7Type = this.detail7Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail8Type = this.detail8Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.detail9Type = this.detail9Type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcRhqCd = this.ofcRhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtStsCd = this.fmMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtStsCd = this.toMvmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmMvmtYdCd = this.fmMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toMvmtYdCd = this.toMvmtYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRcvTermCd = this.bkgRcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDeTermCd = this.bkgDeTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ch = this.ch.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzcTrfCurrCd = this.bzcTrfCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fxFtOvrDys = this.fxFtOvrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
