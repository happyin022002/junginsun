/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RehandlingBkgCodVO.java
*@FileTitle : RehandlingBkgCodVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.expnaud.tesbkgaud.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RehandlingBkgCodVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RehandlingBkgCodVO> models = new ArrayList<RehandlingBkgCodVO>();
	
	/* Column Info */
	private String cPodCd = null;
	/* Column Info */
	private String corrDt = null;
	/* Column Info */
	private String dvcInclOftFlg = null;
	/* Column Info */
	private String dvcChgUsdAmt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String dvcCurrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String misCurrCd = null;
	/* Column Info */
	private String misInclOftFlg = null;
	/* Column Info */
	private String sScgCd = null;
	/* Column Info */
	private String oDelCd = null;
	/* Column Info */
	private String misRatAsQty = null;
	/* Column Info */
	private String ochInclOftFlg = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String sOfcCd = null;
	/* Column Info */
	private String dchInclOftFlg = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String sCaItemCd = null;
	/* Column Info */
	private String dvcTrfItmNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String chk = null;
	/* Column Info */
	private String misChgUsdAmt = null;
	/* Column Info */
	private String corrUsrNm = null;
	/* Column Info */
	private String misChgAmt = null;
	/* Column Info */
	private String ochChgUsdAmt = null;
	/* Column Info */
	private String ochTrfItmNo = null;
	/* Column Info */
	private String sRhqOfcCd = null;
	/* Column Info */
	private String sBkgNo = null;
	/* Column Info */
	private String dchChgUsdAmt = null;
	/* Column Info */
	private String cRlyPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sToDt = null;
	/* Column Info */
	private String sEacIf = null;
	/* Column Info */
	private String eacIfFlg = null;
	/* Column Info */
	private String ochRatAsQty = null;
	/* Column Info */
	private String misTrfItmNo = null;
	/* Column Info */
	private String sCaReason = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String sFmDt = null;
	/* Column Info */
	private String oRlyPortCd = null;
	/* Column Info */
	private String dvcChgAmt = null;
	/* Column Info */
	private String dchCurrCd = null;
	/* Column Info */
	private String corrOfcCd = null;
	/* Column Info */
	private String bkgCorrRmk = null;
	/* Column Info */
	private String caRsnCd = null;
	/* Column Info */
	private String cDelCd = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String oPodCd = null;
	/* Column Info */
	private String dchChgAmt = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String dchRatAsQty = null;
	/* Column Info */
	private String ochChgAmt = null;
	/* Column Info */
	private String dvcRatAsQty = null;
	/* Column Info */
	private String dchTrfItmNo = null;
	/* Column Info */
	private String ochCurrCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RehandlingBkgCodVO() {}

	public RehandlingBkgCodVO(String ibflag, String pagerows, String sRhqOfcCd, String sOfcCd, String sFmDt, String sToDt, String sScgCd, String sCaItemCd, String sCaReason, String sVvd, String sBkgNo, String sEacIf, String chk, String seq, String bkgNo, String cntrQty, String bkgOfcCd, String corrOfcCd, String corrDt, String vvd, String svcScpCd, String oPodCd, String oDelCd, String oRlyPortCd, String cPodCd, String cDelCd, String cRlyPortCd, String corrNo, String caRsnCd, String bkgCorrRmk, String corrUsrNm, String dvcTrfItmNo, String dvcCurrCd, String dvcChgAmt, String dvcChgUsdAmt, String dvcRatAsQty, String dvcInclOftFlg, String ochTrfItmNo, String ochCurrCd, String ochChgAmt, String ochChgUsdAmt, String ochRatAsQty, String ochInclOftFlg, String dchTrfItmNo, String dchCurrCd, String dchChgAmt, String dchChgUsdAmt, String dchRatAsQty, String dchInclOftFlg, String misTrfItmNo, String misCurrCd, String misChgAmt, String misChgUsdAmt, String misRatAsQty, String misInclOftFlg, String eacIfFlg) {
		this.cPodCd = cPodCd;
		this.corrDt = corrDt;
		this.dvcInclOftFlg = dvcInclOftFlg;
		this.dvcChgUsdAmt = dvcChgUsdAmt;
		this.svcScpCd = svcScpCd;
		this.dvcCurrCd = dvcCurrCd;
		this.pagerows = pagerows;
		this.misCurrCd = misCurrCd;
		this.misInclOftFlg = misInclOftFlg;
		this.sScgCd = sScgCd;
		this.oDelCd = oDelCd;
		this.misRatAsQty = misRatAsQty;
		this.ochInclOftFlg = ochInclOftFlg;
		this.bkgOfcCd = bkgOfcCd;
		this.sOfcCd = sOfcCd;
		this.dchInclOftFlg = dchInclOftFlg;
		this.vvd = vvd;
		this.sCaItemCd = sCaItemCd;
		this.dvcTrfItmNo = dvcTrfItmNo;
		this.bkgNo = bkgNo;
		this.chk = chk;
		this.misChgUsdAmt = misChgUsdAmt;
		this.corrUsrNm = corrUsrNm;
		this.misChgAmt = misChgAmt;
		this.ochChgUsdAmt = ochChgUsdAmt;
		this.ochTrfItmNo = ochTrfItmNo;
		this.sRhqOfcCd = sRhqOfcCd;
		this.sBkgNo = sBkgNo;
		this.dchChgUsdAmt = dchChgUsdAmt;
		this.cRlyPortCd = cRlyPortCd;
		this.ibflag = ibflag;
		this.sToDt = sToDt;
		this.sEacIf = sEacIf;
		this.eacIfFlg = eacIfFlg;
		this.ochRatAsQty = ochRatAsQty;
		this.misTrfItmNo = misTrfItmNo;
		this.sCaReason = sCaReason;
		this.cntrQty = cntrQty;
		this.sFmDt = sFmDt;
		this.oRlyPortCd = oRlyPortCd;
		this.dvcChgAmt = dvcChgAmt;
		this.dchCurrCd = dchCurrCd;
		this.corrOfcCd = corrOfcCd;
		this.bkgCorrRmk = bkgCorrRmk;
		this.caRsnCd = caRsnCd;
		this.cDelCd = cDelCd;
		this.corrNo = corrNo;
		this.oPodCd = oPodCd;
		this.dchChgAmt = dchChgAmt;
		this.sVvd = sVvd;
		this.seq = seq;
		this.dchRatAsQty = dchRatAsQty;
		this.ochChgAmt = ochChgAmt;
		this.dvcRatAsQty = dvcRatAsQty;
		this.dchTrfItmNo = dchTrfItmNo;
		this.ochCurrCd = ochCurrCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("c_pod_cd", getCPodCd());
		this.hashColumns.put("corr_dt", getCorrDt());
		this.hashColumns.put("dvc_incl_oft_flg", getDvcInclOftFlg());
		this.hashColumns.put("dvc_chg_usd_amt", getDvcChgUsdAmt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dvc_curr_cd", getDvcCurrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mis_curr_cd", getMisCurrCd());
		this.hashColumns.put("mis_incl_oft_flg", getMisInclOftFlg());
		this.hashColumns.put("s_scg_cd", getSScgCd());
		this.hashColumns.put("o_del_cd", getODelCd());
		this.hashColumns.put("mis_rat_as_qty", getMisRatAsQty());
		this.hashColumns.put("och_incl_oft_flg", getOchInclOftFlg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("s_ofc_cd", getSOfcCd());
		this.hashColumns.put("dch_incl_oft_flg", getDchInclOftFlg());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("s_ca_item_cd", getSCaItemCd());
		this.hashColumns.put("dvc_trf_itm_no", getDvcTrfItmNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("chk", getChk());
		this.hashColumns.put("mis_chg_usd_amt", getMisChgUsdAmt());
		this.hashColumns.put("corr_usr_nm", getCorrUsrNm());
		this.hashColumns.put("mis_chg_amt", getMisChgAmt());
		this.hashColumns.put("och_chg_usd_amt", getOchChgUsdAmt());
		this.hashColumns.put("och_trf_itm_no", getOchTrfItmNo());
		this.hashColumns.put("s_rhq_ofc_cd", getSRhqOfcCd());
		this.hashColumns.put("s_bkg_no", getSBkgNo());
		this.hashColumns.put("dch_chg_usd_amt", getDchChgUsdAmt());
		this.hashColumns.put("c_rly_port_cd", getCRlyPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("s_to_dt", getSToDt());
		this.hashColumns.put("s_eac_if", getSEacIf());
		this.hashColumns.put("eac_if_flg", getEacIfFlg());
		this.hashColumns.put("och_rat_as_qty", getOchRatAsQty());
		this.hashColumns.put("mis_trf_itm_no", getMisTrfItmNo());
		this.hashColumns.put("s_ca_reason", getSCaReason());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("s_fm_dt", getSFmDt());
		this.hashColumns.put("o_rly_port_cd", getORlyPortCd());
		this.hashColumns.put("dvc_chg_amt", getDvcChgAmt());
		this.hashColumns.put("dch_curr_cd", getDchCurrCd());
		this.hashColumns.put("corr_ofc_cd", getCorrOfcCd());
		this.hashColumns.put("bkg_corr_rmk", getBkgCorrRmk());
		this.hashColumns.put("ca_rsn_cd", getCaRsnCd());
		this.hashColumns.put("c_del_cd", getCDelCd());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("o_pod_cd", getOPodCd());
		this.hashColumns.put("dch_chg_amt", getDchChgAmt());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("dch_rat_as_qty", getDchRatAsQty());
		this.hashColumns.put("och_chg_amt", getOchChgAmt());
		this.hashColumns.put("dvc_rat_as_qty", getDvcRatAsQty());
		this.hashColumns.put("dch_trf_itm_no", getDchTrfItmNo());
		this.hashColumns.put("och_curr_cd", getOchCurrCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("c_pod_cd", "cPodCd");
		this.hashFields.put("corr_dt", "corrDt");
		this.hashFields.put("dvc_incl_oft_flg", "dvcInclOftFlg");
		this.hashFields.put("dvc_chg_usd_amt", "dvcChgUsdAmt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dvc_curr_cd", "dvcCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mis_curr_cd", "misCurrCd");
		this.hashFields.put("mis_incl_oft_flg", "misInclOftFlg");
		this.hashFields.put("s_scg_cd", "sScgCd");
		this.hashFields.put("o_del_cd", "oDelCd");
		this.hashFields.put("mis_rat_as_qty", "misRatAsQty");
		this.hashFields.put("och_incl_oft_flg", "ochInclOftFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("dch_incl_oft_flg", "dchInclOftFlg");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("s_ca_item_cd", "sCaItemCd");
		this.hashFields.put("dvc_trf_itm_no", "dvcTrfItmNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("chk", "chk");
		this.hashFields.put("mis_chg_usd_amt", "misChgUsdAmt");
		this.hashFields.put("corr_usr_nm", "corrUsrNm");
		this.hashFields.put("mis_chg_amt", "misChgAmt");
		this.hashFields.put("och_chg_usd_amt", "ochChgUsdAmt");
		this.hashFields.put("och_trf_itm_no", "ochTrfItmNo");
		this.hashFields.put("s_rhq_ofc_cd", "sRhqOfcCd");
		this.hashFields.put("s_bkg_no", "sBkgNo");
		this.hashFields.put("dch_chg_usd_amt", "dchChgUsdAmt");
		this.hashFields.put("c_rly_port_cd", "cRlyPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("s_to_dt", "sToDt");
		this.hashFields.put("s_eac_if", "sEacIf");
		this.hashFields.put("eac_if_flg", "eacIfFlg");
		this.hashFields.put("och_rat_as_qty", "ochRatAsQty");
		this.hashFields.put("mis_trf_itm_no", "misTrfItmNo");
		this.hashFields.put("s_ca_reason", "sCaReason");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("s_fm_dt", "sFmDt");
		this.hashFields.put("o_rly_port_cd", "oRlyPortCd");
		this.hashFields.put("dvc_chg_amt", "dvcChgAmt");
		this.hashFields.put("dch_curr_cd", "dchCurrCd");
		this.hashFields.put("corr_ofc_cd", "corrOfcCd");
		this.hashFields.put("bkg_corr_rmk", "bkgCorrRmk");
		this.hashFields.put("ca_rsn_cd", "caRsnCd");
		this.hashFields.put("c_del_cd", "cDelCd");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("o_pod_cd", "oPodCd");
		this.hashFields.put("dch_chg_amt", "dchChgAmt");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("dch_rat_as_qty", "dchRatAsQty");
		this.hashFields.put("och_chg_amt", "ochChgAmt");
		this.hashFields.put("dvc_rat_as_qty", "dvcRatAsQty");
		this.hashFields.put("dch_trf_itm_no", "dchTrfItmNo");
		this.hashFields.put("och_curr_cd", "ochCurrCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cPodCd
	 */
	public String getCPodCd() {
		return this.cPodCd;
	}
	
	/**
	 * Column Info
	 * @return corrDt
	 */
	public String getCorrDt() {
		return this.corrDt;
	}
	
	/**
	 * Column Info
	 * @return dvcInclOftFlg
	 */
	public String getDvcInclOftFlg() {
		return this.dvcInclOftFlg;
	}
	
	/**
	 * Column Info
	 * @return dvcChgUsdAmt
	 */
	public String getDvcChgUsdAmt() {
		return this.dvcChgUsdAmt;
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
	 * @return dvcCurrCd
	 */
	public String getDvcCurrCd() {
		return this.dvcCurrCd;
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
	 * @return misCurrCd
	 */
	public String getMisCurrCd() {
		return this.misCurrCd;
	}
	
	/**
	 * Column Info
	 * @return misInclOftFlg
	 */
	public String getMisInclOftFlg() {
		return this.misInclOftFlg;
	}
	
	/**
	 * Column Info
	 * @return sScgCd
	 */
	public String getSScgCd() {
		return this.sScgCd;
	}
	
	/**
	 * Column Info
	 * @return oDelCd
	 */
	public String getODelCd() {
		return this.oDelCd;
	}
	
	/**
	 * Column Info
	 * @return misRatAsQty
	 */
	public String getMisRatAsQty() {
		return this.misRatAsQty;
	}
	
	/**
	 * Column Info
	 * @return ochInclOftFlg
	 */
	public String getOchInclOftFlg() {
		return this.ochInclOftFlg;
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
	 * @return sOfcCd
	 */
	public String getSOfcCd() {
		return this.sOfcCd;
	}
	
	/**
	 * Column Info
	 * @return dchInclOftFlg
	 */
	public String getDchInclOftFlg() {
		return this.dchInclOftFlg;
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
	 * @return sCaItemCd
	 */
	public String getSCaItemCd() {
		return this.sCaItemCd;
	}
	
	/**
	 * Column Info
	 * @return dvcTrfItmNo
	 */
	public String getDvcTrfItmNo() {
		return this.dvcTrfItmNo;
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
	 * @return chk
	 */
	public String getChk() {
		return this.chk;
	}
	
	/**
	 * Column Info
	 * @return misChgUsdAmt
	 */
	public String getMisChgUsdAmt() {
		return this.misChgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return corrUsrNm
	 */
	public String getCorrUsrNm() {
		return this.corrUsrNm;
	}
	
	/**
	 * Column Info
	 * @return misChgAmt
	 */
	public String getMisChgAmt() {
		return this.misChgAmt;
	}
	
	/**
	 * Column Info
	 * @return ochChgUsdAmt
	 */
	public String getOchChgUsdAmt() {
		return this.ochChgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return ochTrfItmNo
	 */
	public String getOchTrfItmNo() {
		return this.ochTrfItmNo;
	}
	
	/**
	 * Column Info
	 * @return sRhqOfcCd
	 */
	public String getSRhqOfcCd() {
		return this.sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @return sBkgNo
	 */
	public String getSBkgNo() {
		return this.sBkgNo;
	}
	
	/**
	 * Column Info
	 * @return dchChgUsdAmt
	 */
	public String getDchChgUsdAmt() {
		return this.dchChgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return cRlyPortCd
	 */
	public String getCRlyPortCd() {
		return this.cRlyPortCd;
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
	 * @return sToDt
	 */
	public String getSToDt() {
		return this.sToDt;
	}
	
	/**
	 * Column Info
	 * @return sEacIf
	 */
	public String getSEacIf() {
		return this.sEacIf;
	}
	
	/**
	 * Column Info
	 * @return eacIfFlg
	 */
	public String getEacIfFlg() {
		return this.eacIfFlg;
	}
	
	/**
	 * Column Info
	 * @return ochRatAsQty
	 */
	public String getOchRatAsQty() {
		return this.ochRatAsQty;
	}
	
	/**
	 * Column Info
	 * @return misTrfItmNo
	 */
	public String getMisTrfItmNo() {
		return this.misTrfItmNo;
	}
	
	/**
	 * Column Info
	 * @return sCaReason
	 */
	public String getSCaReason() {
		return this.sCaReason;
	}
	
	/**
	 * Column Info
	 * @return cntrQty
	 */
	public String getCntrQty() {
		return this.cntrQty;
	}
	
	/**
	 * Column Info
	 * @return sFmDt
	 */
	public String getSFmDt() {
		return this.sFmDt;
	}
	
	/**
	 * Column Info
	 * @return oRlyPortCd
	 */
	public String getORlyPortCd() {
		return this.oRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @return dvcChgAmt
	 */
	public String getDvcChgAmt() {
		return this.dvcChgAmt;
	}
	
	/**
	 * Column Info
	 * @return dchCurrCd
	 */
	public String getDchCurrCd() {
		return this.dchCurrCd;
	}
	
	/**
	 * Column Info
	 * @return corrOfcCd
	 */
	public String getCorrOfcCd() {
		return this.corrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return bkgCorrRmk
	 */
	public String getBkgCorrRmk() {
		return this.bkgCorrRmk;
	}
	
	/**
	 * Column Info
	 * @return caRsnCd
	 */
	public String getCaRsnCd() {
		return this.caRsnCd;
	}
	
	/**
	 * Column Info
	 * @return cDelCd
	 */
	public String getCDelCd() {
		return this.cDelCd;
	}
	
	/**
	 * Column Info
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
	}
	
	/**
	 * Column Info
	 * @return oPodCd
	 */
	public String getOPodCd() {
		return this.oPodCd;
	}
	
	/**
	 * Column Info
	 * @return dchChgAmt
	 */
	public String getDchChgAmt() {
		return this.dchChgAmt;
	}
	
	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return dchRatAsQty
	 */
	public String getDchRatAsQty() {
		return this.dchRatAsQty;
	}
	
	/**
	 * Column Info
	 * @return ochChgAmt
	 */
	public String getOchChgAmt() {
		return this.ochChgAmt;
	}
	
	/**
	 * Column Info
	 * @return dvcRatAsQty
	 */
	public String getDvcRatAsQty() {
		return this.dvcRatAsQty;
	}
	
	/**
	 * Column Info
	 * @return dchTrfItmNo
	 */
	public String getDchTrfItmNo() {
		return this.dchTrfItmNo;
	}
	
	/**
	 * Column Info
	 * @return ochCurrCd
	 */
	public String getOchCurrCd() {
		return this.ochCurrCd;
	}
	

	/**
	 * Column Info
	 * @param cPodCd
	 */
	public void setCPodCd(String cPodCd) {
		this.cPodCd = cPodCd;
	}
	
	/**
	 * Column Info
	 * @param corrDt
	 */
	public void setCorrDt(String corrDt) {
		this.corrDt = corrDt;
	}
	
	/**
	 * Column Info
	 * @param dvcInclOftFlg
	 */
	public void setDvcInclOftFlg(String dvcInclOftFlg) {
		this.dvcInclOftFlg = dvcInclOftFlg;
	}
	
	/**
	 * Column Info
	 * @param dvcChgUsdAmt
	 */
	public void setDvcChgUsdAmt(String dvcChgUsdAmt) {
		this.dvcChgUsdAmt = dvcChgUsdAmt;
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
	 * @param dvcCurrCd
	 */
	public void setDvcCurrCd(String dvcCurrCd) {
		this.dvcCurrCd = dvcCurrCd;
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
	 * @param misCurrCd
	 */
	public void setMisCurrCd(String misCurrCd) {
		this.misCurrCd = misCurrCd;
	}
	
	/**
	 * Column Info
	 * @param misInclOftFlg
	 */
	public void setMisInclOftFlg(String misInclOftFlg) {
		this.misInclOftFlg = misInclOftFlg;
	}
	
	/**
	 * Column Info
	 * @param sScgCd
	 */
	public void setSScgCd(String sScgCd) {
		this.sScgCd = sScgCd;
	}
	
	/**
	 * Column Info
	 * @param oDelCd
	 */
	public void setODelCd(String oDelCd) {
		this.oDelCd = oDelCd;
	}
	
	/**
	 * Column Info
	 * @param misRatAsQty
	 */
	public void setMisRatAsQty(String misRatAsQty) {
		this.misRatAsQty = misRatAsQty;
	}
	
	/**
	 * Column Info
	 * @param ochInclOftFlg
	 */
	public void setOchInclOftFlg(String ochInclOftFlg) {
		this.ochInclOftFlg = ochInclOftFlg;
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
	 * @param sOfcCd
	 */
	public void setSOfcCd(String sOfcCd) {
		this.sOfcCd = sOfcCd;
	}
	
	/**
	 * Column Info
	 * @param dchInclOftFlg
	 */
	public void setDchInclOftFlg(String dchInclOftFlg) {
		this.dchInclOftFlg = dchInclOftFlg;
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
	 * @param sCaItemCd
	 */
	public void setSCaItemCd(String sCaItemCd) {
		this.sCaItemCd = sCaItemCd;
	}
	
	/**
	 * Column Info
	 * @param dvcTrfItmNo
	 */
	public void setDvcTrfItmNo(String dvcTrfItmNo) {
		this.dvcTrfItmNo = dvcTrfItmNo;
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
	 * @param chk
	 */
	public void setChk(String chk) {
		this.chk = chk;
	}
	
	/**
	 * Column Info
	 * @param misChgUsdAmt
	 */
	public void setMisChgUsdAmt(String misChgUsdAmt) {
		this.misChgUsdAmt = misChgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param corrUsrNm
	 */
	public void setCorrUsrNm(String corrUsrNm) {
		this.corrUsrNm = corrUsrNm;
	}
	
	/**
	 * Column Info
	 * @param misChgAmt
	 */
	public void setMisChgAmt(String misChgAmt) {
		this.misChgAmt = misChgAmt;
	}
	
	/**
	 * Column Info
	 * @param ochChgUsdAmt
	 */
	public void setOchChgUsdAmt(String ochChgUsdAmt) {
		this.ochChgUsdAmt = ochChgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param ochTrfItmNo
	 */
	public void setOchTrfItmNo(String ochTrfItmNo) {
		this.ochTrfItmNo = ochTrfItmNo;
	}
	
	/**
	 * Column Info
	 * @param sRhqOfcCd
	 */
	public void setSRhqOfcCd(String sRhqOfcCd) {
		this.sRhqOfcCd = sRhqOfcCd;
	}
	
	/**
	 * Column Info
	 * @param sBkgNo
	 */
	public void setSBkgNo(String sBkgNo) {
		this.sBkgNo = sBkgNo;
	}
	
	/**
	 * Column Info
	 * @param dchChgUsdAmt
	 */
	public void setDchChgUsdAmt(String dchChgUsdAmt) {
		this.dchChgUsdAmt = dchChgUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param cRlyPortCd
	 */
	public void setCRlyPortCd(String cRlyPortCd) {
		this.cRlyPortCd = cRlyPortCd;
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
	 * @param sToDt
	 */
	public void setSToDt(String sToDt) {
		this.sToDt = sToDt;
	}
	
	/**
	 * Column Info
	 * @param sEacIf
	 */
	public void setSEacIf(String sEacIf) {
		this.sEacIf = sEacIf;
	}
	
	/**
	 * Column Info
	 * @param eacIfFlg
	 */
	public void setEacIfFlg(String eacIfFlg) {
		this.eacIfFlg = eacIfFlg;
	}
	
	/**
	 * Column Info
	 * @param ochRatAsQty
	 */
	public void setOchRatAsQty(String ochRatAsQty) {
		this.ochRatAsQty = ochRatAsQty;
	}
	
	/**
	 * Column Info
	 * @param misTrfItmNo
	 */
	public void setMisTrfItmNo(String misTrfItmNo) {
		this.misTrfItmNo = misTrfItmNo;
	}
	
	/**
	 * Column Info
	 * @param sCaReason
	 */
	public void setSCaReason(String sCaReason) {
		this.sCaReason = sCaReason;
	}
	
	/**
	 * Column Info
	 * @param cntrQty
	 */
	public void setCntrQty(String cntrQty) {
		this.cntrQty = cntrQty;
	}
	
	/**
	 * Column Info
	 * @param sFmDt
	 */
	public void setSFmDt(String sFmDt) {
		this.sFmDt = sFmDt;
	}
	
	/**
	 * Column Info
	 * @param oRlyPortCd
	 */
	public void setORlyPortCd(String oRlyPortCd) {
		this.oRlyPortCd = oRlyPortCd;
	}
	
	/**
	 * Column Info
	 * @param dvcChgAmt
	 */
	public void setDvcChgAmt(String dvcChgAmt) {
		this.dvcChgAmt = dvcChgAmt;
	}
	
	/**
	 * Column Info
	 * @param dchCurrCd
	 */
	public void setDchCurrCd(String dchCurrCd) {
		this.dchCurrCd = dchCurrCd;
	}
	
	/**
	 * Column Info
	 * @param corrOfcCd
	 */
	public void setCorrOfcCd(String corrOfcCd) {
		this.corrOfcCd = corrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param bkgCorrRmk
	 */
	public void setBkgCorrRmk(String bkgCorrRmk) {
		this.bkgCorrRmk = bkgCorrRmk;
	}
	
	/**
	 * Column Info
	 * @param caRsnCd
	 */
	public void setCaRsnCd(String caRsnCd) {
		this.caRsnCd = caRsnCd;
	}
	
	/**
	 * Column Info
	 * @param cDelCd
	 */
	public void setCDelCd(String cDelCd) {
		this.cDelCd = cDelCd;
	}
	
	/**
	 * Column Info
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	
	/**
	 * Column Info
	 * @param oPodCd
	 */
	public void setOPodCd(String oPodCd) {
		this.oPodCd = oPodCd;
	}
	
	/**
	 * Column Info
	 * @param dchChgAmt
	 */
	public void setDchChgAmt(String dchChgAmt) {
		this.dchChgAmt = dchChgAmt;
	}
	
	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param dchRatAsQty
	 */
	public void setDchRatAsQty(String dchRatAsQty) {
		this.dchRatAsQty = dchRatAsQty;
	}
	
	/**
	 * Column Info
	 * @param ochChgAmt
	 */
	public void setOchChgAmt(String ochChgAmt) {
		this.ochChgAmt = ochChgAmt;
	}
	
	/**
	 * Column Info
	 * @param dvcRatAsQty
	 */
	public void setDvcRatAsQty(String dvcRatAsQty) {
		this.dvcRatAsQty = dvcRatAsQty;
	}
	
	/**
	 * Column Info
	 * @param dchTrfItmNo
	 */
	public void setDchTrfItmNo(String dchTrfItmNo) {
		this.dchTrfItmNo = dchTrfItmNo;
	}
	
	/**
	 * Column Info
	 * @param ochCurrCd
	 */
	public void setOchCurrCd(String ochCurrCd) {
		this.ochCurrCd = ochCurrCd;
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
		setCPodCd(JSPUtil.getParameter(request, prefix + "c_pod_cd", ""));
		setCorrDt(JSPUtil.getParameter(request, prefix + "corr_dt", ""));
		setDvcInclOftFlg(JSPUtil.getParameter(request, prefix + "dvc_incl_oft_flg", ""));
		setDvcChgUsdAmt(JSPUtil.getParameter(request, prefix + "dvc_chg_usd_amt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDvcCurrCd(JSPUtil.getParameter(request, prefix + "dvc_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMisCurrCd(JSPUtil.getParameter(request, prefix + "mis_curr_cd", ""));
		setMisInclOftFlg(JSPUtil.getParameter(request, prefix + "mis_incl_oft_flg", ""));
		setSScgCd(JSPUtil.getParameter(request, prefix + "s_scg_cd", ""));
		setODelCd(JSPUtil.getParameter(request, prefix + "o_del_cd", ""));
		setMisRatAsQty(JSPUtil.getParameter(request, prefix + "mis_rat_as_qty", ""));
		setOchInclOftFlg(JSPUtil.getParameter(request, prefix + "och_incl_oft_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setSOfcCd(JSPUtil.getParameter(request, prefix + "s_ofc_cd", ""));
		setDchInclOftFlg(JSPUtil.getParameter(request, prefix + "dch_incl_oft_flg", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSCaItemCd(JSPUtil.getParameter(request, prefix + "s_ca_item_cd", ""));
		setDvcTrfItmNo(JSPUtil.getParameter(request, prefix + "dvc_trf_itm_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setChk(JSPUtil.getParameter(request, prefix + "chk", ""));
		setMisChgUsdAmt(JSPUtil.getParameter(request, prefix + "mis_chg_usd_amt", ""));
		setCorrUsrNm(JSPUtil.getParameter(request, prefix + "corr_usr_nm", ""));
		setMisChgAmt(JSPUtil.getParameter(request, prefix + "mis_chg_amt", ""));
		setOchChgUsdAmt(JSPUtil.getParameter(request, prefix + "och_chg_usd_amt", ""));
		setOchTrfItmNo(JSPUtil.getParameter(request, prefix + "och_trf_itm_no", ""));
		setSRhqOfcCd(JSPUtil.getParameter(request, prefix + "s_rhq_ofc_cd", ""));
		setSBkgNo(JSPUtil.getParameter(request, prefix + "s_bkg_no", ""));
		setDchChgUsdAmt(JSPUtil.getParameter(request, prefix + "dch_chg_usd_amt", ""));
		setCRlyPortCd(JSPUtil.getParameter(request, prefix + "c_rly_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSToDt(JSPUtil.getParameter(request, prefix + "s_to_dt", ""));
		setSEacIf(JSPUtil.getParameter(request, prefix + "s_eac_if", ""));
		setEacIfFlg(JSPUtil.getParameter(request, prefix + "eac_if_flg", ""));
		setOchRatAsQty(JSPUtil.getParameter(request, prefix + "och_rat_as_qty", ""));
		setMisTrfItmNo(JSPUtil.getParameter(request, prefix + "mis_trf_itm_no", ""));
		setSCaReason(JSPUtil.getParameter(request, prefix + "s_ca_reason", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setSFmDt(JSPUtil.getParameter(request, prefix + "s_fm_dt", ""));
		setORlyPortCd(JSPUtil.getParameter(request, prefix + "o_rly_port_cd", ""));
		setDvcChgAmt(JSPUtil.getParameter(request, prefix + "dvc_chg_amt", ""));
		setDchCurrCd(JSPUtil.getParameter(request, prefix + "dch_curr_cd", ""));
		setCorrOfcCd(JSPUtil.getParameter(request, prefix + "corr_ofc_cd", ""));
		setBkgCorrRmk(JSPUtil.getParameter(request, prefix + "bkg_corr_rmk", ""));
		setCaRsnCd(JSPUtil.getParameter(request, prefix + "ca_rsn_cd", ""));
		setCDelCd(JSPUtil.getParameter(request, prefix + "c_del_cd", ""));
		setCorrNo(JSPUtil.getParameter(request, prefix + "corr_no", ""));
		setOPodCd(JSPUtil.getParameter(request, prefix + "o_pod_cd", ""));
		setDchChgAmt(JSPUtil.getParameter(request, prefix + "dch_chg_amt", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setDchRatAsQty(JSPUtil.getParameter(request, prefix + "dch_rat_as_qty", ""));
		setOchChgAmt(JSPUtil.getParameter(request, prefix + "och_chg_amt", ""));
		setDvcRatAsQty(JSPUtil.getParameter(request, prefix + "dvc_rat_as_qty", ""));
		setDchTrfItmNo(JSPUtil.getParameter(request, prefix + "dch_trf_itm_no", ""));
		setOchCurrCd(JSPUtil.getParameter(request, prefix + "och_curr_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RehandlingBkgCodVO[]
	 */
	public RehandlingBkgCodVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RehandlingBkgCodVO[]
	 */
	public RehandlingBkgCodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RehandlingBkgCodVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cPodCd = (JSPUtil.getParameter(request, prefix	+ "c_pod_cd", length));
			String[] corrDt = (JSPUtil.getParameter(request, prefix	+ "corr_dt", length));
			String[] dvcInclOftFlg = (JSPUtil.getParameter(request, prefix	+ "dvc_incl_oft_flg", length));
			String[] dvcChgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "dvc_chg_usd_amt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] dvcCurrCd = (JSPUtil.getParameter(request, prefix	+ "dvc_curr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] misCurrCd = (JSPUtil.getParameter(request, prefix	+ "mis_curr_cd", length));
			String[] misInclOftFlg = (JSPUtil.getParameter(request, prefix	+ "mis_incl_oft_flg", length));
			String[] sScgCd = (JSPUtil.getParameter(request, prefix	+ "s_scg_cd", length));
			String[] oDelCd = (JSPUtil.getParameter(request, prefix	+ "o_del_cd", length));
			String[] misRatAsQty = (JSPUtil.getParameter(request, prefix	+ "mis_rat_as_qty", length));
			String[] ochInclOftFlg = (JSPUtil.getParameter(request, prefix	+ "och_incl_oft_flg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] sOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_ofc_cd", length));
			String[] dchInclOftFlg = (JSPUtil.getParameter(request, prefix	+ "dch_incl_oft_flg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] sCaItemCd = (JSPUtil.getParameter(request, prefix	+ "s_ca_item_cd", length));
			String[] dvcTrfItmNo = (JSPUtil.getParameter(request, prefix	+ "dvc_trf_itm_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] chk = (JSPUtil.getParameter(request, prefix	+ "chk", length));
			String[] misChgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "mis_chg_usd_amt", length));
			String[] corrUsrNm = (JSPUtil.getParameter(request, prefix	+ "corr_usr_nm", length));
			String[] misChgAmt = (JSPUtil.getParameter(request, prefix	+ "mis_chg_amt", length));
			String[] ochChgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "och_chg_usd_amt", length));
			String[] ochTrfItmNo = (JSPUtil.getParameter(request, prefix	+ "och_trf_itm_no", length));
			String[] sRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "s_rhq_ofc_cd", length));
			String[] sBkgNo = (JSPUtil.getParameter(request, prefix	+ "s_bkg_no", length));
			String[] dchChgUsdAmt = (JSPUtil.getParameter(request, prefix	+ "dch_chg_usd_amt", length));
			String[] cRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "c_rly_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sToDt = (JSPUtil.getParameter(request, prefix	+ "s_to_dt", length));
			String[] sEacIf = (JSPUtil.getParameter(request, prefix	+ "s_eac_if", length));
			String[] eacIfFlg = (JSPUtil.getParameter(request, prefix	+ "eac_if_flg", length));
			String[] ochRatAsQty = (JSPUtil.getParameter(request, prefix	+ "och_rat_as_qty", length));
			String[] misTrfItmNo = (JSPUtil.getParameter(request, prefix	+ "mis_trf_itm_no", length));
			String[] sCaReason = (JSPUtil.getParameter(request, prefix	+ "s_ca_reason", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] sFmDt = (JSPUtil.getParameter(request, prefix	+ "s_fm_dt", length));
			String[] oRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "o_rly_port_cd", length));
			String[] dvcChgAmt = (JSPUtil.getParameter(request, prefix	+ "dvc_chg_amt", length));
			String[] dchCurrCd = (JSPUtil.getParameter(request, prefix	+ "dch_curr_cd", length));
			String[] corrOfcCd = (JSPUtil.getParameter(request, prefix	+ "corr_ofc_cd", length));
			String[] bkgCorrRmk = (JSPUtil.getParameter(request, prefix	+ "bkg_corr_rmk", length));
			String[] caRsnCd = (JSPUtil.getParameter(request, prefix	+ "ca_rsn_cd", length));
			String[] cDelCd = (JSPUtil.getParameter(request, prefix	+ "c_del_cd", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] oPodCd = (JSPUtil.getParameter(request, prefix	+ "o_pod_cd", length));
			String[] dchChgAmt = (JSPUtil.getParameter(request, prefix	+ "dch_chg_amt", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] dchRatAsQty = (JSPUtil.getParameter(request, prefix	+ "dch_rat_as_qty", length));
			String[] ochChgAmt = (JSPUtil.getParameter(request, prefix	+ "och_chg_amt", length));
			String[] dvcRatAsQty = (JSPUtil.getParameter(request, prefix	+ "dvc_rat_as_qty", length));
			String[] dchTrfItmNo = (JSPUtil.getParameter(request, prefix	+ "dch_trf_itm_no", length));
			String[] ochCurrCd = (JSPUtil.getParameter(request, prefix	+ "och_curr_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RehandlingBkgCodVO();
				if (cPodCd[i] != null)
					model.setCPodCd(cPodCd[i]);
				if (corrDt[i] != null)
					model.setCorrDt(corrDt[i]);
				if (dvcInclOftFlg[i] != null)
					model.setDvcInclOftFlg(dvcInclOftFlg[i]);
				if (dvcChgUsdAmt[i] != null)
					model.setDvcChgUsdAmt(dvcChgUsdAmt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (dvcCurrCd[i] != null)
					model.setDvcCurrCd(dvcCurrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (misCurrCd[i] != null)
					model.setMisCurrCd(misCurrCd[i]);
				if (misInclOftFlg[i] != null)
					model.setMisInclOftFlg(misInclOftFlg[i]);
				if (sScgCd[i] != null)
					model.setSScgCd(sScgCd[i]);
				if (oDelCd[i] != null)
					model.setODelCd(oDelCd[i]);
				if (misRatAsQty[i] != null)
					model.setMisRatAsQty(misRatAsQty[i]);
				if (ochInclOftFlg[i] != null)
					model.setOchInclOftFlg(ochInclOftFlg[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (sOfcCd[i] != null)
					model.setSOfcCd(sOfcCd[i]);
				if (dchInclOftFlg[i] != null)
					model.setDchInclOftFlg(dchInclOftFlg[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (sCaItemCd[i] != null)
					model.setSCaItemCd(sCaItemCd[i]);
				if (dvcTrfItmNo[i] != null)
					model.setDvcTrfItmNo(dvcTrfItmNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (chk[i] != null)
					model.setChk(chk[i]);
				if (misChgUsdAmt[i] != null)
					model.setMisChgUsdAmt(misChgUsdAmt[i]);
				if (corrUsrNm[i] != null)
					model.setCorrUsrNm(corrUsrNm[i]);
				if (misChgAmt[i] != null)
					model.setMisChgAmt(misChgAmt[i]);
				if (ochChgUsdAmt[i] != null)
					model.setOchChgUsdAmt(ochChgUsdAmt[i]);
				if (ochTrfItmNo[i] != null)
					model.setOchTrfItmNo(ochTrfItmNo[i]);
				if (sRhqOfcCd[i] != null)
					model.setSRhqOfcCd(sRhqOfcCd[i]);
				if (sBkgNo[i] != null)
					model.setSBkgNo(sBkgNo[i]);
				if (dchChgUsdAmt[i] != null)
					model.setDchChgUsdAmt(dchChgUsdAmt[i]);
				if (cRlyPortCd[i] != null)
					model.setCRlyPortCd(cRlyPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sToDt[i] != null)
					model.setSToDt(sToDt[i]);
				if (sEacIf[i] != null)
					model.setSEacIf(sEacIf[i]);
				if (eacIfFlg[i] != null)
					model.setEacIfFlg(eacIfFlg[i]);
				if (ochRatAsQty[i] != null)
					model.setOchRatAsQty(ochRatAsQty[i]);
				if (misTrfItmNo[i] != null)
					model.setMisTrfItmNo(misTrfItmNo[i]);
				if (sCaReason[i] != null)
					model.setSCaReason(sCaReason[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (sFmDt[i] != null)
					model.setSFmDt(sFmDt[i]);
				if (oRlyPortCd[i] != null)
					model.setORlyPortCd(oRlyPortCd[i]);
				if (dvcChgAmt[i] != null)
					model.setDvcChgAmt(dvcChgAmt[i]);
				if (dchCurrCd[i] != null)
					model.setDchCurrCd(dchCurrCd[i]);
				if (corrOfcCd[i] != null)
					model.setCorrOfcCd(corrOfcCd[i]);
				if (bkgCorrRmk[i] != null)
					model.setBkgCorrRmk(bkgCorrRmk[i]);
				if (caRsnCd[i] != null)
					model.setCaRsnCd(caRsnCd[i]);
				if (cDelCd[i] != null)
					model.setCDelCd(cDelCd[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (oPodCd[i] != null)
					model.setOPodCd(oPodCd[i]);
				if (dchChgAmt[i] != null)
					model.setDchChgAmt(dchChgAmt[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (dchRatAsQty[i] != null)
					model.setDchRatAsQty(dchRatAsQty[i]);
				if (ochChgAmt[i] != null)
					model.setOchChgAmt(ochChgAmt[i]);
				if (dvcRatAsQty[i] != null)
					model.setDvcRatAsQty(dvcRatAsQty[i]);
				if (dchTrfItmNo[i] != null)
					model.setDchTrfItmNo(dchTrfItmNo[i]);
				if (ochCurrCd[i] != null)
					model.setOchCurrCd(ochCurrCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRehandlingBkgCodVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RehandlingBkgCodVO[]
	 */
	public RehandlingBkgCodVO[] getRehandlingBkgCodVOs(){
		RehandlingBkgCodVO[] vos = (RehandlingBkgCodVO[])models.toArray(new RehandlingBkgCodVO[models.size()]);
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
		this.cPodCd = this.cPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrDt = this.corrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcInclOftFlg = this.dvcInclOftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcChgUsdAmt = this.dvcChgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcCurrCd = this.dvcCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misCurrCd = this.misCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misInclOftFlg = this.misInclOftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sScgCd = this.sScgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oDelCd = this.oDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misRatAsQty = this.misRatAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ochInclOftFlg = this.ochInclOftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd = this.sOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchInclOftFlg = this.dchInclOftFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCaItemCd = this.sCaItemCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcTrfItmNo = this.dvcTrfItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chk = this.chk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misChgUsdAmt = this.misChgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrUsrNm = this.corrUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misChgAmt = this.misChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ochChgUsdAmt = this.ochChgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ochTrfItmNo = this.ochTrfItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sRhqOfcCd = this.sRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sBkgNo = this.sBkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchChgUsdAmt = this.dchChgUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cRlyPortCd = this.cRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToDt = this.sToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sEacIf = this.sEacIf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eacIfFlg = this.eacIfFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ochRatAsQty = this.ochRatAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misTrfItmNo = this.misTrfItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCaReason = this.sCaReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFmDt = this.sFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oRlyPortCd = this.oRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcChgAmt = this.dvcChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchCurrCd = this.dchCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrOfcCd = this.corrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrRmk = this.bkgCorrRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caRsnCd = this.caRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cDelCd = this.cDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oPodCd = this.oPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchChgAmt = this.dchChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchRatAsQty = this.dchRatAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ochChgAmt = this.ochChgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvcRatAsQty = this.dvcRatAsQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchTrfItmNo = this.dchTrfItmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ochCurrCd = this.ochCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
