/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchPreDispatchSentHistoryVO.java
*@FileTitle : SearchPreDispatchSentHistoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.13
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2009.11.13 손은주(TRS) 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.workordermanage.predispatchsenthistory.vo;

import java.lang.reflect.Field;
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
 * @author 손은주(TRS)
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchPreDispatchSentHistoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchPreDispatchSentHistoryVO> models = new ArrayList<SearchPreDispatchSentHistoryVO>();
	
	/* Column Info */
	private String emlSnd2No = null;
	/* Column Info */
	private String disN2ndEml = null;
	/* Column Info */
	private String emlSnd1No = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String faxSnd3No = null;
	/* Column Info */
	private String vndrLglEngNm = null;
	/* Column Info */
	private String disN1stFaxRsltFlg = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String faxSnd2No = null;
	/* Column Info */
	private String woIssKnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String disN2ndFaxRsltFlg = null;
	/* Column Info */
	private String creOfcCd = null;
	/* Column Info */
	private String disN3rdFaxNo = null;
	/* Column Info */
	private String disN1stEml = null;
	/* Column Info */
	private String emlSnd3No = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String disN2ndEmlRsltFlg = null;
	/* Column Info */
	private String disN1stEmlRsltFlg = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String disN3rdEmlRsltFlg = null;
	/* Column Info */
	private String disN1stFaxNo = null;
	/* Column Info */
	private String trspDisRefNo = null;
	/* Column Info */
	private String disN3rdFaxRsltFlg = null;
	/* Column Info */
	private String faxSnd1No = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String sntDt = null;
	/* Column Info */
	private String disN3rdEml = null;
	/* Column Info */
	private String batExeDt = null;
	/* Column Info */
	private String trspDisIssSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String disN2ndFaxNo = null;
	/* Column Info */
	private String vndrAbbrNm = null;
	
	private String woNo = null;
	private String cntrNo = null;
	/* Column Info */
	private String billNo = null;
	private String bkgNo = null;

	private String woIssOfcCd = null;
	private String comboSvcProvider = null;
	private String radWonotic = null;
	/* Column Info */
	private String hidFrmdate = null;
	/* Column Info */
	private String hidTodate = null;
	private String referenceNo = null;
	private String ctrlOfcCd = null;
	
	public String getWoIssOfcCd() {
		return woIssOfcCd;
	}

	public void setWoIssOfcCd(String woIssOfcCd) {
		this.woIssOfcCd = woIssOfcCd;
	}

	public String getComboSvcProvider() {
		return comboSvcProvider;
	}

	public void setComboSvcProvider(String comboSvcProvider) {
		this.comboSvcProvider = comboSvcProvider;
	}

	public String getRadWonotic() {
		return radWonotic;
	}

	public void setRadWonotic(String radWonotic) {
		this.radWonotic = radWonotic;
	}

	public String getHidFrmdate() {
		return hidFrmdate;
	}

	public void setHidFrmdate(String hidFrmdate) {
		this.hidFrmdate = hidFrmdate;
	}

	public String getHidTodate() {
		return hidTodate;
	}

	public void setHidTodate(String hidTodate) {
		this.hidTodate = hidTodate;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getCtrlOfcCd() {
		return ctrlOfcCd;
	}

	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchPreDispatchSentHistoryVO() {}

	public SearchPreDispatchSentHistoryVO(String ibflag, String pagerows, String trspSoOfcCtyCd, String trspSoSeq, String trspDisRefNo, String trspWoOfcCtyCd, String trspWoSeq, String woIssKnt, String vndrSeq, String vndrAbbrNm, String sntDt, String trspDisIssSeq, String disN1stFaxNo, String disN2ndFaxNo, String disN3rdFaxNo, String disN1stFaxRsltFlg, String disN2ndFaxRsltFlg, String disN3rdFaxRsltFlg, String disN1stEml, String disN2ndEml, String disN3rdEml, String disN1stEmlRsltFlg, String disN2ndEmlRsltFlg, String disN3rdEmlRsltFlg, String creOfcCd, String updUsrId, String vndrLglEngNm, String faxSnd1No, String faxSnd2No, String faxSnd3No, String emlSnd1No, String emlSnd2No, String emlSnd3No, String batExeDt) {
		this.emlSnd2No = emlSnd2No;
		this.disN2ndEml = disN2ndEml;
		this.emlSnd1No = emlSnd1No;
		this.trspSoSeq = trspSoSeq;
		this.faxSnd3No = faxSnd3No;
		this.vndrLglEngNm = vndrLglEngNm;
		this.disN1stFaxRsltFlg = disN1stFaxRsltFlg;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.pagerows = pagerows;
		this.faxSnd2No = faxSnd2No;
		this.woIssKnt = woIssKnt;
		this.ibflag = ibflag;
		this.disN2ndFaxRsltFlg = disN2ndFaxRsltFlg;
		this.creOfcCd = creOfcCd;
		this.disN3rdFaxNo = disN3rdFaxNo;
		this.disN1stEml = disN1stEml;
		this.emlSnd3No = emlSnd3No;
		this.updUsrId = updUsrId;
		this.disN2ndEmlRsltFlg = disN2ndEmlRsltFlg;
		this.disN1stEmlRsltFlg = disN1stEmlRsltFlg;
		this.trspWoSeq = trspWoSeq;
		this.disN3rdEmlRsltFlg = disN3rdEmlRsltFlg;
		this.disN1stFaxNo = disN1stFaxNo;
		this.trspDisRefNo = trspDisRefNo;
		this.disN3rdFaxRsltFlg = disN3rdFaxRsltFlg;
		this.faxSnd1No = faxSnd1No;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.sntDt = sntDt;
		this.disN3rdEml = disN3rdEml;
		this.batExeDt = batExeDt;
		this.trspDisIssSeq = trspDisIssSeq;
		this.vndrSeq = vndrSeq;
		this.disN2ndFaxNo = disN2ndFaxNo;
		this.vndrAbbrNm = vndrAbbrNm;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eml_snd2_no", getEmlSnd2No());
		this.hashColumns.put("dis_n2nd_eml", getDisN2ndEml());
		this.hashColumns.put("eml_snd1_no", getEmlSnd1No());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("fax_snd3_no", getFaxSnd3No());
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());
		this.hashColumns.put("dis_n1st_fax_rslt_flg", getDisN1stFaxRsltFlg());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fax_snd2_no", getFaxSnd2No());
		this.hashColumns.put("wo_iss_knt", getWoIssKnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dis_n2nd_fax_rslt_flg", getDisN2ndFaxRsltFlg());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("dis_n3rd_fax_no", getDisN3rdFaxNo());
		this.hashColumns.put("dis_n1st_eml", getDisN1stEml());
		this.hashColumns.put("eml_snd3_no", getEmlSnd3No());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dis_n2nd_eml_rslt_flg", getDisN2ndEmlRsltFlg());
		this.hashColumns.put("dis_n1st_eml_rslt_flg", getDisN1stEmlRsltFlg());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("dis_n3rd_eml_rslt_flg", getDisN3rdEmlRsltFlg());
		this.hashColumns.put("dis_n1st_fax_no", getDisN1stFaxNo());
		this.hashColumns.put("trsp_dis_ref_no", getTrspDisRefNo());
		this.hashColumns.put("dis_n3rd_fax_rslt_flg", getDisN3rdFaxRsltFlg());
		this.hashColumns.put("fax_snd1_no", getFaxSnd1No());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("snt_dt", getSntDt());
		this.hashColumns.put("dis_n3rd_eml", getDisN3rdEml());
		this.hashColumns.put("bat_exe_dt", getBatExeDt());
		this.hashColumns.put("trsp_dis_iss_seq", getTrspDisIssSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("dis_n2nd_fax_no", getDisN2ndFaxNo());
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());
		
		this.hashColumns.put("wo_no", getWoNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bill_no", getBillNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rad_wonotic", getRadWonotic());
		this.hashColumns.put("hid_frmdate", getHidFrmdate());
		this.hashColumns.put("hid_todate", getHidTodate());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("reference_no", getReferenceNo());
		this.hashColumns.put("wo_iss_ofc_cd", getWoIssOfcCd());
		this.hashColumns.put("combo_svc_provider", getComboSvcProvider());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eml_snd2_no", "emlSnd2No");
		this.hashFields.put("dis_n2nd_eml", "disN2ndEml");
		this.hashFields.put("eml_snd1_no", "emlSnd1No");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("fax_snd3_no", "faxSnd3No");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("dis_n1st_fax_rslt_flg", "disN1stFaxRsltFlg");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fax_snd2_no", "faxSnd2No");
		this.hashFields.put("wo_iss_knt", "woIssKnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dis_n2nd_fax_rslt_flg", "disN2ndFaxRsltFlg");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("dis_n3rd_fax_no", "disN3rdFaxNo");
		this.hashFields.put("dis_n1st_eml", "disN1stEml");
		this.hashFields.put("eml_snd3_no", "emlSnd3No");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dis_n2nd_eml_rslt_flg", "disN2ndEmlRsltFlg");
		this.hashFields.put("dis_n1st_eml_rslt_flg", "disN1stEmlRsltFlg");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("dis_n3rd_eml_rslt_flg", "disN3rdEmlRsltFlg");
		this.hashFields.put("dis_n1st_fax_no", "disN1stFaxNo");
		this.hashFields.put("trsp_dis_ref_no", "trspDisRefNo");
		this.hashFields.put("dis_n3rd_fax_rslt_flg", "disN3rdFaxRsltFlg");
		this.hashFields.put("fax_snd1_no", "faxSnd1No");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("snt_dt", "sntDt");
		this.hashFields.put("dis_n3rd_eml", "disN3rdEml");
		this.hashFields.put("bat_exe_dt", "batExeDt");
		this.hashFields.put("trsp_dis_iss_seq", "trspDisIssSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("dis_n2nd_fax_no", "disN2ndFaxNo");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("wo_no", "woNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bill_no", "billNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rad_wonotic", "radWonotic");
		this.hashFields.put("hid_frmdate", "hidFrmdate");
		this.hashFields.put("hid_todate", "hidTodate");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("reference_no", "referenceNo");
		this.hashFields.put("wo_iss_ofc_cd", "woIssOfcCd");
		this.hashFields.put("combo_svc_provider", "comboSvcProvider");
		return this.hashFields;
	}
	
	public String getCntrNo() {
		return cntrNo;
	}

	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}

	public String getBillNo() {
		return billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	/**
	 * Column Info
	 * @return emlSnd2No
	 */
	public String getEmlSnd2No() {
		return this.emlSnd2No;
	}
	
	/**
	 * Column Info
	 * @return disN2ndEml
	 */
	public String getDisN2ndEml() {
		return this.disN2ndEml;
	}
	
	/**
	 * Column Info
	 * @return emlSnd1No
	 */
	public String getEmlSnd1No() {
		return this.emlSnd1No;
	}
	
	/**
	 * Column Info
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return faxSnd3No
	 */
	public String getFaxSnd3No() {
		return this.faxSnd3No;
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
	 * @return disN1stFaxRsltFlg
	 */
	public String getDisN1stFaxRsltFlg() {
		return this.disN1stFaxRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
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
	 * @return faxSnd2No
	 */
	public String getFaxSnd2No() {
		return this.faxSnd2No;
	}
	
	/**
	 * Column Info
	 * @return woIssKnt
	 */
	public String getWoIssKnt() {
		return this.woIssKnt;
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
	 * @return disN2ndFaxRsltFlg
	 */
	public String getDisN2ndFaxRsltFlg() {
		return this.disN2ndFaxRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public String getCreOfcCd() {
		return this.creOfcCd;
	}
	
	/**
	 * Column Info
	 * @return disN3rdFaxNo
	 */
	public String getDisN3rdFaxNo() {
		return this.disN3rdFaxNo;
	}
	
	/**
	 * Column Info
	 * @return disN1stEml
	 */
	public String getDisN1stEml() {
		return this.disN1stEml;
	}
	
	/**
	 * Column Info
	 * @return emlSnd3No
	 */
	public String getEmlSnd3No() {
		return this.emlSnd3No;
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
	 * @return disN2ndEmlRsltFlg
	 */
	public String getDisN2ndEmlRsltFlg() {
		return this.disN2ndEmlRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return disN1stEmlRsltFlg
	 */
	public String getDisN1stEmlRsltFlg() {
		return this.disN1stEmlRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return disN3rdEmlRsltFlg
	 */
	public String getDisN3rdEmlRsltFlg() {
		return this.disN3rdEmlRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return disN1stFaxNo
	 */
	public String getDisN1stFaxNo() {
		return this.disN1stFaxNo;
	}
	
	/**
	 * Column Info
	 * @return trspDisRefNo
	 */
	public String getTrspDisRefNo() {
		return this.trspDisRefNo;
	}
	
	/**
	 * Column Info
	 * @return disN3rdFaxRsltFlg
	 */
	public String getDisN3rdFaxRsltFlg() {
		return this.disN3rdFaxRsltFlg;
	}
	
	/**
	 * Column Info
	 * @return faxSnd1No
	 */
	public String getFaxSnd1No() {
		return this.faxSnd1No;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return sntDt
	 */
	public String getSntDt() {
		return this.sntDt;
	}
	
	/**
	 * Column Info
	 * @return disN3rdEml
	 */
	public String getDisN3rdEml() {
		return this.disN3rdEml;
	}
	
	/**
	 * Column Info
	 * @return batExeDt
	 */
	public String getBatExeDt() {
		return this.batExeDt;
	}
	
	/**
	 * Column Info
	 * @return trspDisIssSeq
	 */
	public String getTrspDisIssSeq() {
		return this.trspDisIssSeq;
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
	 * @return disN2ndFaxNo
	 */
	public String getDisN2ndFaxNo() {
		return this.disN2ndFaxNo;
	}
	
	/**
	 * Column Info
	 * @return vndrAbbrNm
	 */
	public String getVndrAbbrNm() {
		return this.vndrAbbrNm;
	}
	

	/**
	 * Column Info
	 * @param emlSnd2No
	 */
	public void setEmlSnd2No(String emlSnd2No) {
		this.emlSnd2No = emlSnd2No;
	}
	
	/**
	 * Column Info
	 * @param disN2ndEml
	 */
	public void setDisN2ndEml(String disN2ndEml) {
		this.disN2ndEml = disN2ndEml;
	}
	
	/**
	 * Column Info
	 * @param emlSnd1No
	 */
	public void setEmlSnd1No(String emlSnd1No) {
		this.emlSnd1No = emlSnd1No;
	}
	
	/**
	 * Column Info
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param faxSnd3No
	 */
	public void setFaxSnd3No(String faxSnd3No) {
		this.faxSnd3No = faxSnd3No;
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
	 * @param disN1stFaxRsltFlg
	 */
	public void setDisN1stFaxRsltFlg(String disN1stFaxRsltFlg) {
		this.disN1stFaxRsltFlg = disN1stFaxRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
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
	 * @param faxSnd2No
	 */
	public void setFaxSnd2No(String faxSnd2No) {
		this.faxSnd2No = faxSnd2No;
	}
	
	/**
	 * Column Info
	 * @param woIssKnt
	 */
	public void setWoIssKnt(String woIssKnt) {
		this.woIssKnt = woIssKnt;
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
	 * @param disN2ndFaxRsltFlg
	 */
	public void setDisN2ndFaxRsltFlg(String disN2ndFaxRsltFlg) {
		this.disN2ndFaxRsltFlg = disN2ndFaxRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param creOfcCd
	 */
	public void setCreOfcCd(String creOfcCd) {
		this.creOfcCd = creOfcCd;
	}
	
	/**
	 * Column Info
	 * @param disN3rdFaxNo
	 */
	public void setDisN3rdFaxNo(String disN3rdFaxNo) {
		this.disN3rdFaxNo = disN3rdFaxNo;
	}
	
	/**
	 * Column Info
	 * @param disN1stEml
	 */
	public void setDisN1stEml(String disN1stEml) {
		this.disN1stEml = disN1stEml;
	}
	
	/**
	 * Column Info
	 * @param emlSnd3No
	 */
	public void setEmlSnd3No(String emlSnd3No) {
		this.emlSnd3No = emlSnd3No;
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
	 * @param disN2ndEmlRsltFlg
	 */
	public void setDisN2ndEmlRsltFlg(String disN2ndEmlRsltFlg) {
		this.disN2ndEmlRsltFlg = disN2ndEmlRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param disN1stEmlRsltFlg
	 */
	public void setDisN1stEmlRsltFlg(String disN1stEmlRsltFlg) {
		this.disN1stEmlRsltFlg = disN1stEmlRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param disN3rdEmlRsltFlg
	 */
	public void setDisN3rdEmlRsltFlg(String disN3rdEmlRsltFlg) {
		this.disN3rdEmlRsltFlg = disN3rdEmlRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param disN1stFaxNo
	 */
	public void setDisN1stFaxNo(String disN1stFaxNo) {
		this.disN1stFaxNo = disN1stFaxNo;
	}
	
	/**
	 * Column Info
	 * @param trspDisRefNo
	 */
	public void setTrspDisRefNo(String trspDisRefNo) {
		this.trspDisRefNo = trspDisRefNo;
	}
	
	/**
	 * Column Info
	 * @param disN3rdFaxRsltFlg
	 */
	public void setDisN3rdFaxRsltFlg(String disN3rdFaxRsltFlg) {
		this.disN3rdFaxRsltFlg = disN3rdFaxRsltFlg;
	}
	
	/**
	 * Column Info
	 * @param faxSnd1No
	 */
	public void setFaxSnd1No(String faxSnd1No) {
		this.faxSnd1No = faxSnd1No;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param sntDt
	 */
	public void setSntDt(String sntDt) {
		this.sntDt = sntDt;
	}
	
	/**
	 * Column Info
	 * @param disN3rdEml
	 */
	public void setDisN3rdEml(String disN3rdEml) {
		this.disN3rdEml = disN3rdEml;
	}
	
	/**
	 * Column Info
	 * @param batExeDt
	 */
	public void setBatExeDt(String batExeDt) {
		this.batExeDt = batExeDt;
	}
	
	/**
	 * Column Info
	 * @param trspDisIssSeq
	 */
	public void setTrspDisIssSeq(String trspDisIssSeq) {
		this.trspDisIssSeq = trspDisIssSeq;
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
	 * @param disN2ndFaxNo
	 */
	public void setDisN2ndFaxNo(String disN2ndFaxNo) {
		this.disN2ndFaxNo = disN2ndFaxNo;
	}
	
	/**
	 * Column Info
	 * @param vndrAbbrNm
	 */
	public void setVndrAbbrNm(String vndrAbbrNm) {
		this.vndrAbbrNm = vndrAbbrNm;
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
	 * @param woNo
	 */
	public void setWoNo(String woNo) {
		this.woNo = woNo;
	}	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setEmlSnd2No(JSPUtil.getParameter(request, "eml_snd2_no", ""));
		setDisN2ndEml(JSPUtil.getParameter(request, "dis_n2nd_eml", ""));
		setEmlSnd1No(JSPUtil.getParameter(request, "eml_snd1_no", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setFaxSnd3No(JSPUtil.getParameter(request, "fax_snd3_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request, "vndr_lgl_eng_nm", ""));
		setDisN1stFaxRsltFlg(JSPUtil.getParameter(request, "dis_n1st_fax_rslt_flg", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setFaxSnd2No(JSPUtil.getParameter(request, "fax_snd2_no", ""));
		setWoIssKnt(JSPUtil.getParameter(request, "wo_iss_knt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setDisN2ndFaxRsltFlg(JSPUtil.getParameter(request, "dis_n2nd_fax_rslt_flg", ""));
		setCreOfcCd(JSPUtil.getParameter(request, "cre_ofc_cd", ""));
		setDisN3rdFaxNo(JSPUtil.getParameter(request, "dis_n3rd_fax_no", ""));
		setDisN1stEml(JSPUtil.getParameter(request, "dis_n1st_eml", ""));
		setEmlSnd3No(JSPUtil.getParameter(request, "eml_snd3_no", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDisN2ndEmlRsltFlg(JSPUtil.getParameter(request, "dis_n2nd_eml_rslt_flg", ""));
		setDisN1stEmlRsltFlg(JSPUtil.getParameter(request, "dis_n1st_eml_rslt_flg", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, "trsp_wo_seq", ""));
		setDisN3rdEmlRsltFlg(JSPUtil.getParameter(request, "dis_n3rd_eml_rslt_flg", ""));
		setDisN1stFaxNo(JSPUtil.getParameter(request, "dis_n1st_fax_no", ""));
		setTrspDisRefNo(JSPUtil.getParameter(request, "trsp_dis_ref_no", ""));
		setDisN3rdFaxRsltFlg(JSPUtil.getParameter(request, "dis_n3rd_fax_rslt_flg", ""));
		setFaxSnd1No(JSPUtil.getParameter(request, "fax_snd1_no", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, "trsp_wo_ofc_cty_cd", ""));
		setSntDt(JSPUtil.getParameter(request, "snt_dt", ""));
		setDisN3rdEml(JSPUtil.getParameter(request, "dis_n3rd_eml", ""));
		setBatExeDt(JSPUtil.getParameter(request, "bat_exe_dt", ""));
		setTrspDisIssSeq(JSPUtil.getParameter(request, "trsp_dis_iss_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setDisN2ndFaxNo(JSPUtil.getParameter(request, "dis_n2nd_fax_no", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request, "vndr_abbr_nm", ""));
		setWoIssOfcCd(JSPUtil.getParameter(request, "wo_iss_ofc_cd", ""));
		setComboSvcProvider(JSPUtil.getParameter(request, "combo_svc_provider", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setRadWonotic(JSPUtil.getParameter(request, "rad_wonotic", ""));
		setHidFrmdate(JSPUtil.getParameter(request, "hid_frmdate", ""));
		setHidTodate(JSPUtil.getParameter(request, "hid_todate", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setBillNo(JSPUtil.getParameter(request, "bill_no", ""));
		setWoNo(JSPUtil.getParameter(request, "wo_no", ""));
		setReferenceNo(JSPUtil.getParameter(request, "reference_no", ""));		
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchPreDispatchSentHistoryVO[]
	 */
	public SearchPreDispatchSentHistoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchPreDispatchSentHistoryVO[]
	 */
	public SearchPreDispatchSentHistoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchPreDispatchSentHistoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] emlSnd2No = (JSPUtil.getParameter(request, prefix	+ "eml_snd2_no", length));
			String[] disN2ndEml = (JSPUtil.getParameter(request, prefix	+ "dis_n2nd_eml", length));
			String[] emlSnd1No = (JSPUtil.getParameter(request, prefix	+ "eml_snd1_no", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] faxSnd3No = (JSPUtil.getParameter(request, prefix	+ "fax_snd3_no", length));
			String[] vndrLglEngNm = (JSPUtil.getParameter(request, prefix	+ "vndr_lgl_eng_nm", length));
			String[] disN1stFaxRsltFlg = (JSPUtil.getParameter(request, prefix	+ "dis_n1st_fax_rslt_flg", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] faxSnd2No = (JSPUtil.getParameter(request, prefix	+ "fax_snd2_no", length));
			String[] woIssKnt = (JSPUtil.getParameter(request, prefix	+ "wo_iss_knt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] disN2ndFaxRsltFlg = (JSPUtil.getParameter(request, prefix	+ "dis_n2nd_fax_rslt_flg", length));
			String[] creOfcCd = (JSPUtil.getParameter(request, prefix	+ "cre_ofc_cd", length));
			String[] disN3rdFaxNo = (JSPUtil.getParameter(request, prefix	+ "dis_n3rd_fax_no", length));
			String[] disN1stEml = (JSPUtil.getParameter(request, prefix	+ "dis_n1st_eml", length));
			String[] emlSnd3No = (JSPUtil.getParameter(request, prefix	+ "eml_snd3_no", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] disN2ndEmlRsltFlg = (JSPUtil.getParameter(request, prefix	+ "dis_n2nd_eml_rslt_flg", length));
			String[] disN1stEmlRsltFlg = (JSPUtil.getParameter(request, prefix	+ "dis_n1st_eml_rslt_flg", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] disN3rdEmlRsltFlg = (JSPUtil.getParameter(request, prefix	+ "dis_n3rd_eml_rslt_flg", length));
			String[] disN1stFaxNo = (JSPUtil.getParameter(request, prefix	+ "dis_n1st_fax_no", length));
			String[] trspDisRefNo = (JSPUtil.getParameter(request, prefix	+ "trsp_dis_ref_no", length));
			String[] disN3rdFaxRsltFlg = (JSPUtil.getParameter(request, prefix	+ "dis_n3rd_fax_rslt_flg", length));
			String[] faxSnd1No = (JSPUtil.getParameter(request, prefix	+ "fax_snd1_no", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] sntDt = (JSPUtil.getParameter(request, prefix	+ "snt_dt", length));
			String[] disN3rdEml = (JSPUtil.getParameter(request, prefix	+ "dis_n3rd_eml", length));
			String[] batExeDt = (JSPUtil.getParameter(request, prefix	+ "bat_exe_dt", length));
			String[] trspDisIssSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_dis_iss_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] disN2ndFaxNo = (JSPUtil.getParameter(request, prefix	+ "dis_n2nd_fax_no", length));
			String[] vndrAbbrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_abbr_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchPreDispatchSentHistoryVO();
				if (emlSnd2No[i] != null)
					model.setEmlSnd2No(emlSnd2No[i]);
				if (disN2ndEml[i] != null)
					model.setDisN2ndEml(disN2ndEml[i]);
				if (emlSnd1No[i] != null)
					model.setEmlSnd1No(emlSnd1No[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (faxSnd3No[i] != null)
					model.setFaxSnd3No(faxSnd3No[i]);
				if (vndrLglEngNm[i] != null)
					model.setVndrLglEngNm(vndrLglEngNm[i]);
				if (disN1stFaxRsltFlg[i] != null)
					model.setDisN1stFaxRsltFlg(disN1stFaxRsltFlg[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (faxSnd2No[i] != null)
					model.setFaxSnd2No(faxSnd2No[i]);
				if (woIssKnt[i] != null)
					model.setWoIssKnt(woIssKnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (disN2ndFaxRsltFlg[i] != null)
					model.setDisN2ndFaxRsltFlg(disN2ndFaxRsltFlg[i]);
				if (creOfcCd[i] != null)
					model.setCreOfcCd(creOfcCd[i]);
				if (disN3rdFaxNo[i] != null)
					model.setDisN3rdFaxNo(disN3rdFaxNo[i]);
				if (disN1stEml[i] != null)
					model.setDisN1stEml(disN1stEml[i]);
				if (emlSnd3No[i] != null)
					model.setEmlSnd3No(emlSnd3No[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (disN2ndEmlRsltFlg[i] != null)
					model.setDisN2ndEmlRsltFlg(disN2ndEmlRsltFlg[i]);
				if (disN1stEmlRsltFlg[i] != null)
					model.setDisN1stEmlRsltFlg(disN1stEmlRsltFlg[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (disN3rdEmlRsltFlg[i] != null)
					model.setDisN3rdEmlRsltFlg(disN3rdEmlRsltFlg[i]);
				if (disN1stFaxNo[i] != null)
					model.setDisN1stFaxNo(disN1stFaxNo[i]);
				if (trspDisRefNo[i] != null)
					model.setTrspDisRefNo(trspDisRefNo[i]);
				if (disN3rdFaxRsltFlg[i] != null)
					model.setDisN3rdFaxRsltFlg(disN3rdFaxRsltFlg[i]);
				if (faxSnd1No[i] != null)
					model.setFaxSnd1No(faxSnd1No[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (sntDt[i] != null)
					model.setSntDt(sntDt[i]);
				if (disN3rdEml[i] != null)
					model.setDisN3rdEml(disN3rdEml[i]);
				if (batExeDt[i] != null)
					model.setBatExeDt(batExeDt[i]);
				if (trspDisIssSeq[i] != null)
					model.setTrspDisIssSeq(trspDisIssSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (disN2ndFaxNo[i] != null)
					model.setDisN2ndFaxNo(disN2ndFaxNo[i]);
				if (vndrAbbrNm[i] != null)
					model.setVndrAbbrNm(vndrAbbrNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchPreDispatchSentHistoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchPreDispatchSentHistoryVO[]
	 */
	public SearchPreDispatchSentHistoryVO[] getSearchPreDispatchSentHistoryVOs(){
		SearchPreDispatchSentHistoryVO[] vos = (SearchPreDispatchSentHistoryVO[])models.toArray(new SearchPreDispatchSentHistoryVO[models.size()]);
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
		this.emlSnd2No = this.emlSnd2No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN2ndEml = this.disN2ndEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSnd1No = this.emlSnd1No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSnd3No = this.faxSnd3No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm = this.vndrLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN1stFaxRsltFlg = this.disN1stFaxRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSnd2No = this.faxSnd2No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssKnt = this.woIssKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN2ndFaxRsltFlg = this.disN2ndFaxRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd = this.creOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN3rdFaxNo = this.disN3rdFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN1stEml = this.disN1stEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSnd3No = this.emlSnd3No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN2ndEmlRsltFlg = this.disN2ndEmlRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN1stEmlRsltFlg = this.disN1stEmlRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN3rdEmlRsltFlg = this.disN3rdEmlRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN1stFaxNo = this.disN1stFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDisRefNo = this.trspDisRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN3rdFaxRsltFlg = this.disN3rdFaxRsltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSnd1No = this.faxSnd1No .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sntDt = this.sntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN3rdEml = this.disN3rdEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batExeDt = this.batExeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspDisIssSeq = this.trspDisIssSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disN2ndFaxNo = this.disN2ndFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm = this.vndrAbbrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFrmdate = this.hidFrmdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidTodate = this.hidTodate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billNo = this.billNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woNo = this.woNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.referenceNo = this.referenceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboSvcProvider = this.comboSvcProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.woIssOfcCd = this.woIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.radWonotic = this.radWonotic .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
