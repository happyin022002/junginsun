/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DblWblVO.java
*@FileTitle : DblWblVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.19
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.19  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DblWblVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DblWblVO> models = new ArrayList<DblWblVO>();
	
	/* Column Info */
	private String qtyBkg = null;
	/* Column Info */
	private String qtyCntr = null;
	/* Column Info */
	private String qtyFlg = null;
	/* Column Info */
	private String porCd = null; 
	/* Column Info */
	private String eml = null;
	/* Column Info */
	private String grpFlag = null;
	/* Column Info */
	private String cnsnCd = null;
	/* Column Info */
	private String tmplmrdpdf = null;
	/* Column Info */
	private String itr = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String emlDate = null;
	/* Column Info */
	private String ffCd = null;
	/* Column Info */
	private String faxReason = null;
	/* Column Info */
	private String emlResult = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hiddOpt = null;
	/* Column Info */
	private String frtPpdFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String frtCltFlg = null;
	/* Column Info */
	private String cntcPsonNm = null;
	/* Column Info */
	private String faxDate = null;
	/* Column Info */
	private String historyGubun = null;
	/* Column Info */
	private String cnsnNm = null;
	/* Column Info */
	private String shprNm = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String rcvinfo = null;
	/* Column Info */
	private String syscd = null;
	/* Column Info */
	private String tmplparam = null;
	/* Column Info */
	private String tmplmrd = null;
	/* Column Info */
	private String contents = null;
	/* Column Info */
	private String rcveml = null;
	/* Column Info */
	private String ntcKndCd = null;
	/* Column Info */
	private String frtAllFlg = null;
	/* Column Info */
	private String shortShprNm = null;
	/* Column Info */
	private String filekey = null;
	/* Column Info */
	private String batchflg = null;
	/* Column Info */
	private String frtChgFlg = null;
	/* Column Info */
	private String emlReason = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String faxResult = null;
	/* Column Info */
	private String frtArrFlg = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String sndnm = null;
	/* Column Info */
	private String sndeml = null;
	/* Column Info */
	private String gubun = null;
	/* Column Info */
	private String tmplparam2 = null;
	/* Column Info */
	private String fntEmlFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DblWblVO() {}

	public DblWblVO(String ibflag, String pagerows, String eml, String cnsnCd, String tmplmrdpdf, String itr, String remark, String bkgStsCd, String emlDate, String faxReason, String blNo, String emlResult, String hiddOpt, String frtPpdFlg, String title, String polCd, String frtCltFlg, String cntcPsonNm, String faxDate, String cnsnNm, String shprNm, String shprCd, String rcvinfo, String syscd, String tmplparam, String tmplmrd, String rcveml, String contents, String ntcKndCd, String frtAllFlg, String filekey, String shortShprNm, String batchflg, String frtChgFlg, String emlReason, String podCd, String vvd, String bkgNo, String faxResult, String sndnm, String faxNo, String frtArrFlg, String sndeml, String grpFlag, String ffCd, String historyGubun, String porCd, String gubun,  String tmplparam2, String fntEmlFlg, String qtyFlg, String qtyCntr, String qtyBkg) {
		this.qtyBkg = qtyBkg;
		this.qtyCntr = qtyCntr;
		this.qtyFlg = qtyFlg;
		this.porCd = porCd;
		this.eml = eml;
		this.grpFlag = grpFlag;
		this.cnsnCd = cnsnCd;
		this.tmplmrdpdf = tmplmrdpdf;
		this.itr = itr;
		this.remark = remark;
		this.bkgStsCd = bkgStsCd;
		this.emlDate = emlDate;
		this.ffCd = ffCd;
		this.faxReason = faxReason;
		this.emlResult = emlResult;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.hiddOpt = hiddOpt;
		this.frtPpdFlg = frtPpdFlg;
		this.ibflag = ibflag;
		this.title = title;
		this.polCd = polCd;
		this.frtCltFlg = frtCltFlg;
		this.cntcPsonNm = cntcPsonNm;
		this.faxDate = faxDate;
		this.historyGubun = historyGubun;
		this.cnsnNm = cnsnNm;
		this.shprNm = shprNm;
		this.shprCd = shprCd;
		this.rcvinfo = rcvinfo;
		this.syscd = syscd;
		this.tmplparam = tmplparam;
		this.tmplmrd = tmplmrd;
		this.contents = contents;
		this.rcveml = rcveml;
		this.ntcKndCd = ntcKndCd;
		this.frtAllFlg = frtAllFlg;
		this.shortShprNm = shortShprNm;
		this.filekey = filekey;
		this.gubun = gubun;
		this.batchflg = batchflg;
		this.frtChgFlg = frtChgFlg;
		this.emlReason = emlReason;
		this.vvd = vvd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.faxResult = faxResult;
		this.frtArrFlg = frtArrFlg;
		this.faxNo = faxNo;
		this.sndnm = sndnm;
		this.sndeml = sndeml;
		this.tmplparam2 = tmplparam2;
		this.fntEmlFlg = fntEmlFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("qty_bkg", getQtyBkg());
		this.hashColumns.put("qty_cntr", getQtyCntr());
		this.hashColumns.put("qty_flg", getQtyFlg());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("eml", getEml());
		this.hashColumns.put("grp_flag", getGrpFlag());
		this.hashColumns.put("cnsn_cd", getCnsnCd());
		this.hashColumns.put("tmplmrdpdf", getTmplmrdpdf());
		this.hashColumns.put("itr", getItr());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("eml_date", getEmlDate());
		this.hashColumns.put("ff_cd", getFfCd());
		this.hashColumns.put("fax_reason", getFaxReason());
		this.hashColumns.put("eml_result", getEmlResult());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hidd_opt", getHiddOpt());
		this.hashColumns.put("frt_ppd_flg", getFrtPpdFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());
		this.hashColumns.put("cntc_pson_nm", getCntcPsonNm());
		this.hashColumns.put("fax_date", getFaxDate());
		this.hashColumns.put("history_gubun", getHistoryGubun());
		this.hashColumns.put("cnsn_nm", getCnsnNm());
		this.hashColumns.put("shpr_nm", getShprNm());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("rcvinfo", getRcvinfo());
		this.hashColumns.put("syscd", getSyscd());
		this.hashColumns.put("tmplparam", getTmplparam());
		this.hashColumns.put("tmplparam2", getTmplparam2());
		this.hashColumns.put("tmplmrd", getTmplmrd());
		this.hashColumns.put("contents", getContents());
		this.hashColumns.put("rcveml", getRcveml());
		this.hashColumns.put("ntc_knd_cd", getNtcKndCd());
		this.hashColumns.put("frt_all_flg", getFrtAllFlg());
		this.hashColumns.put("short_shpr_nm", getShortShprNm());
		this.hashColumns.put("filekey", getFilekey());
		this.hashColumns.put("batchflg", getBatchflg());
		this.hashColumns.put("frt_chg_flg", getFrtChgFlg());
		this.hashColumns.put("eml_reason", getEmlReason());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("fax_result", getFaxResult());
		this.hashColumns.put("frt_arr_flg", getFrtArrFlg());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("sndnm", getSndnm());
		this.hashColumns.put("sndeml", getSndeml());
		this.hashColumns.put("gubun", getGubun());
		this.hashColumns.put("fnt_eml_flg", getFntEmlFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("qty_bkg", "qtyBkg");
		this.hashFields.put("qty_cntr", "qtyCntr");
		this.hashFields.put("qty_flg", "qtyFlg");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("eml", "eml");
		this.hashFields.put("grp_flag", "grpFlag");
		this.hashFields.put("cnsn_cd", "cnsnCd");
		this.hashFields.put("tmplmrdpdf", "tmplmrdpdf");
		this.hashFields.put("itr", "itr");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("eml_date", "emlDate");
		this.hashFields.put("ff_cd", "ffCd");
		this.hashFields.put("fax_reason", "faxReason");
		this.hashFields.put("eml_result", "emlResult");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hidd_opt", "hiddOpt");
		this.hashFields.put("frt_ppd_flg", "frtPpdFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("title", "title");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("cntc_pson_nm", "cntcPsonNm");
		this.hashFields.put("fax_date", "faxDate");
		this.hashFields.put("history_gubun", "historyGubun");
		this.hashFields.put("cnsn_nm", "cnsnNm");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("rcvinfo", "rcvinfo");
		this.hashFields.put("syscd", "syscd");
		this.hashFields.put("tmplparam", "tmplparam");
		this.hashFields.put("tmplparam2", "tmplparam2");
		this.hashFields.put("tmplmrd", "tmplmrd");
		this.hashFields.put("contents", "contents");
		this.hashFields.put("rcveml", "rcveml");
		this.hashFields.put("ntc_knd_cd", "ntcKndCd");
		this.hashFields.put("frt_all_flg", "frtAllFlg");
		this.hashFields.put("short_shpr_nm", "shortShprNm");
		this.hashFields.put("filekey", "filekey");
		this.hashFields.put("batchflg", "batchflg");
		this.hashFields.put("frt_chg_flg", "frtChgFlg");
		this.hashFields.put("eml_reason", "emlReason");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("fax_result", "faxResult");
		this.hashFields.put("frt_arr_flg", "frtArrFlg");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("sndnm", "sndnm");
		this.hashFields.put("sndeml", "sndeml");
		this.hashFields.put("gubun", "gubun");
		this.hashFields.put("fnt_eml_flg", "fntEmlFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return qtyBkg
	 */
	public String getQtyBkg() {
		return this.qtyBkg;
	}
	
	/**
	 * Column Info
	 * @return qtyCntr
	 */
	public String getQtyCntr() {
		return this.qtyCntr;
	}
	
	/**
	 * Column Info
	 * @return qtyFlg
	 */
	public String getQtyFlg() {
		return this.qtyFlg;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return eml
	 */
	public String getEml() {
		return this.eml;
	}
	
	/**
	 * Column Info
	 * @return grpFlag
	 */
	public String getGrpFlag() {
		return this.grpFlag;
	}
	
	/**
	 * Column Info
	 * @return cnsnCd
	 */
	public String getCnsnCd() {
		return this.cnsnCd;
	}
	
	/**
	 * Column Info
	 * @return tmplmrdpdf
	 */
	public String getTmplmrdpdf() {
		return this.tmplmrdpdf;
	}
	
	/**
	 * Column Info
	 * @return itr
	 */
	public String getItr() {
		return this.itr;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return emlDate
	 */
	public String getEmlDate() {
		return this.emlDate;
	}
	
	/**
	 * Column Info
	 * @return ffCd
	 */
	public String getFfCd() {
		return this.ffCd;
	}
	
	/**
	 * Column Info
	 * @return faxReason
	 */
	public String getFaxReason() {
		return this.faxReason;
	}
	
	/**
	 * Column Info
	 * @return emlResult
	 */
	public String getEmlResult() {
		return this.emlResult;
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
	 * @return hiddOpt
	 */
	public String getHiddOpt() {
		return this.hiddOpt;
	}
	
	/**
	 * Column Info
	 * @return frtPpdFlg
	 */
	public String getFrtPpdFlg() {
		return this.frtPpdFlg;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
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
	 * @return frtCltFlg
	 */
	public String getFrtCltFlg() {
		return this.frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @return cntcPsonNm
	 */
	public String getCntcPsonNm() {
		return this.cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @return faxDate
	 */
	public String getFaxDate() {
		return this.faxDate;
	}
	
	/**
	 * Column Info
	 * @return historyGubun
	 */
	public String getHistoryGubun() {
		return this.historyGubun;
	}
	
	/**
	 * Column Info
	 * @return cnsnNm
	 */
	public String getCnsnNm() {
		return this.cnsnNm;
	}
	
	/**
	 * Column Info
	 * @return shprNm
	 */
	public String getShprNm() {
		return this.shprNm;
	}
	
	/**
	 * Column Info
	 * @return shprCd
	 */
	public String getShprCd() {
		return this.shprCd;
	}
	
	/**
	 * Column Info
	 * @return rcvinfo
	 */
	public String getRcvinfo() {
		return this.rcvinfo;
	}
	
	/**
	 * Column Info
	 * @return syscd
	 */
	public String getSyscd() {
		return this.syscd;
	}
	
	/**
	 * Column Info
	 * @return tmplparam
	 */
	public String getTmplparam() {
		return this.tmplparam;
	}
	
	/**
	 * Column Info
	 * @return tmplparam2
	 */
	public String getTmplparam2() {
		return this.tmplparam2;
	}
	
	/**
	 * Column Info
	 * @return tmplmrd
	 */
	public String getTmplmrd() {
		return this.tmplmrd;
	}
	
	/**
	 * Column Info
	 * @return contents
	 */
	public String getContents() {
		return this.contents;
	}
	
	/**
	 * Column Info
	 * @return rcveml
	 */
	public String getRcveml() {
		return this.rcveml;
	}
	
	/**
	 * Column Info
	 * @return ntcKndCd
	 */
	public String getNtcKndCd() {
		return this.ntcKndCd;
	}
	
	/**
	 * Column Info
	 * @return frtAllFlg
	 */
	public String getFrtAllFlg() {
		return this.frtAllFlg;
	}
	
	/**
	 * Column Info
	 * @return shortShprNm
	 */
	public String getShortShprNm() {
		return this.shortShprNm;
	}
	
	/**
	 * Column Info
	 * @return filekey
	 */
	public String getFilekey() {
		return this.filekey;
	}
	
	/**
	 * Column Info
	 * @return batchflg
	 */
	public String getBatchflg() {
		return this.batchflg;
	}
	
	/**
	 * Column Info
	 * @return frtChgFlg
	 */
	public String getFrtChgFlg() {
		return this.frtChgFlg;
	}
	
	/**
	 * Column Info
	 * @return emlReason
	 */
	public String getEmlReason() {
		return this.emlReason;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return faxResult
	 */
	public String getFaxResult() {
		return this.faxResult;
	}
	
	/**
	 * Column Info
	 * @return frtArrFlg
	 */
	public String getFrtArrFlg() {
		return this.frtArrFlg;
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
	 * @return sndnm
	 */
	public String getSndnm() {
		return this.sndnm;
	}
	
	/**
	 * Column Info
	 * @return sndeml
	 */
	public String getSndeml() {
		return this.sndeml;
	}
	
	/**
	 * Column Info
	 * @return gubun
	 */
	public String getGubun() {
		return this.gubun;
	}
	
	
	/**
	 * Column Info
	 * @return fntEmlFlg
	 */
	public String getFntEmlFlg() {
		return this.fntEmlFlg;
	}
	
	/**
	 * Column Info
	 * @param qtyBkg
	 */
	public void setQtyBkg(String qtyBkg) {
		this.qtyBkg = qtyBkg;
	}
	
	/**
	 * Column Info
	 * @param qtyCntr
	 */
	public void setQtyCntr(String qtyCntr) {
		this.qtyCntr = qtyCntr;
	}
	
	/**
	 * Column Info
	 * @param qtyFlg
	 */
	public void setQtyFlg(String qtyFlg) {
		this.qtyFlg = qtyFlg;
	}
	

	/**
	 * Column Info
	 * @param fntEmlFlg
	 */
	public void setFntEmlFlg(String fntEmlFlg) {
		this.fntEmlFlg = fntEmlFlg;
	}
	

	/**
	 * Column Info
	 * @param gubun
	 */
	public void setGubun(String gubun) {
		this.gubun = gubun;
	}
	
	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param eml
	 */
	public void setEml(String eml) {
		this.eml = eml;
	}
	
	/**
	 * Column Info
	 * @param grpFlag
	 */
	public void setGrpFlag(String grpFlag) {
		this.grpFlag = grpFlag;
	}
	
	/**
	 * Column Info
	 * @param cnsnCd
	 */
	public void setCnsnCd(String cnsnCd) {
		this.cnsnCd = cnsnCd;
	}
	
	/**
	 * Column Info
	 * @param tmplmrdpdf
	 */
	public void setTmplmrdpdf(String tmplmrdpdf) {
		this.tmplmrdpdf = tmplmrdpdf;
	}
	
	/**
	 * Column Info
	 * @param itr
	 */
	public void setItr(String itr) {
		this.itr = itr;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param emlDate
	 */
	public void setEmlDate(String emlDate) {
		this.emlDate = emlDate;
	}
	
	/**
	 * Column Info
	 * @param ffCd
	 */
	public void setFfCd(String ffCd) {
		this.ffCd = ffCd;
	}
	
	/**
	 * Column Info
	 * @param faxReason
	 */
	public void setFaxReason(String faxReason) {
		this.faxReason = faxReason;
	}
	
	/**
	 * Column Info
	 * @param emlResult
	 */
	public void setEmlResult(String emlResult) {
		this.emlResult = emlResult;
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
	 * @param hiddOpt
	 */
	public void setHiddOpt(String hiddOpt) {
		this.hiddOpt = hiddOpt;
	}
	
	/**
	 * Column Info
	 * @param frtPpdFlg
	 */
	public void setFrtPpdFlg(String frtPpdFlg) {
		this.frtPpdFlg = frtPpdFlg;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param frtCltFlg
	 */
	public void setFrtCltFlg(String frtCltFlg) {
		this.frtCltFlg = frtCltFlg;
	}
	
	/**
	 * Column Info
	 * @param cntcPsonNm
	 */
	public void setCntcPsonNm(String cntcPsonNm) {
		this.cntcPsonNm = cntcPsonNm;
	}
	
	/**
	 * Column Info
	 * @param faxDate
	 */
	public void setFaxDate(String faxDate) {
		this.faxDate = faxDate;
	}
	
	/**
	 * Column Info
	 * @param historyGubun
	 */
	public void setHistoryGubun(String historyGubun) {
		this.historyGubun = historyGubun;
	}
	
	/**
	 * Column Info
	 * @param cnsnNm
	 */
	public void setCnsnNm(String cnsnNm) {
		this.cnsnNm = cnsnNm;
	}
	
	/**
	 * Column Info
	 * @param shprNm
	 */
	public void setShprNm(String shprNm) {
		this.shprNm = shprNm;
	}
	
	/**
	 * Column Info
	 * @param shprCd
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}
	
	/**
	 * Column Info
	 * @param rcvinfo
	 */
	public void setRcvinfo(String rcvinfo) {
		this.rcvinfo = rcvinfo;
	}
	
	/**
	 * Column Info
	 * @param syscd
	 */
	public void setSyscd(String syscd) {
		this.syscd = syscd;
	}
	
	/**
	 * Column Info
	 * @param tmplparam
	 */
	public void setTmplparam(String tmplparam) {
		this.tmplparam = tmplparam;
	}
	
	/**
	 * Column Info
	 * @param tmplparam2
	 */
	public void setTmplparam2(String tmplparam2) {
		this.tmplparam2 = tmplparam2;
	}
	
	
	/**
	 * Column Info
	 * @param tmplmrd
	 */
	public void setTmplmrd(String tmplmrd) {
		this.tmplmrd = tmplmrd;
	}
	
	/**
	 * Column Info
	 * @param contents
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	
	/**
	 * Column Info
	 * @param rcveml
	 */
	public void setRcveml(String rcveml) {
		this.rcveml = rcveml;
	}
	
	/**
	 * Column Info
	 * @param ntcKndCd
	 */
	public void setNtcKndCd(String ntcKndCd) {
		this.ntcKndCd = ntcKndCd;
	}
	
	/**
	 * Column Info
	 * @param frtAllFlg
	 */
	public void setFrtAllFlg(String frtAllFlg) {
		this.frtAllFlg = frtAllFlg;
	}
	
	/**
	 * Column Info
	 * @param shortShprNm
	 */
	public void setShortShprNm(String shortShprNm) {
		this.shortShprNm = shortShprNm;
	}
	
	/**
	 * Column Info
	 * @param filekey
	 */
	public void setFilekey(String filekey) {
		this.filekey = filekey;
	}
	
	/**
	 * Column Info
	 * @param batchflg
	 */
	public void setBatchflg(String batchflg) {
		this.batchflg = batchflg;
	}
	
	/**
	 * Column Info
	 * @param frtChgFlg
	 */
	public void setFrtChgFlg(String frtChgFlg) {
		this.frtChgFlg = frtChgFlg;
	}
	
	/**
	 * Column Info
	 * @param emlReason
	 */
	public void setEmlReason(String emlReason) {
		this.emlReason = emlReason;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param faxResult
	 */
	public void setFaxResult(String faxResult) {
		this.faxResult = faxResult;
	}
	
	/**
	 * Column Info
	 * @param frtArrFlg
	 */
	public void setFrtArrFlg(String frtArrFlg) {
		this.frtArrFlg = frtArrFlg;
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
	 * @param sndnm
	 */
	public void setSndnm(String sndnm) {
		this.sndnm = sndnm;
	}
	
	/**
	 * Column Info
	 * @param sndeml
	 */
	public void setSndeml(String sndeml) {
		this.sndeml = sndeml;
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
		setQtyBkg(JSPUtil.getParameter(request, prefix + "qty_bkg", ""));
		setQtyCntr(JSPUtil.getParameter(request, prefix + "qty_cntr", ""));
		setQtyFlg(JSPUtil.getParameter(request, prefix + "qty_flg", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setEml(JSPUtil.getParameter(request, prefix + "eml", ""));
		setGrpFlag(JSPUtil.getParameter(request, prefix + "grp_flag", ""));
		setCnsnCd(JSPUtil.getParameter(request, prefix + "cnsn_cd", ""));
		setTmplmrdpdf(JSPUtil.getParameter(request, prefix + "tmplmrdpdf", ""));
		setItr(JSPUtil.getParameter(request, prefix + "itr", ""));
		setRemark(JSPUtil.getParameter(request, prefix + "remark", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setEmlDate(JSPUtil.getParameter(request, prefix + "eml_date", ""));
		setFfCd(JSPUtil.getParameter(request, prefix + "ff_cd", ""));
		setFaxReason(JSPUtil.getParameter(request, prefix + "fax_reason", ""));
		setEmlResult(JSPUtil.getParameter(request, prefix + "eml_result", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setHiddOpt(JSPUtil.getParameter(request, prefix + "hidd_opt", ""));
		setFrtPpdFlg(JSPUtil.getParameter(request, prefix + "frt_ppd_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setFrtCltFlg(JSPUtil.getParameter(request, prefix + "frt_clt_flg", ""));
		setCntcPsonNm(JSPUtil.getParameter(request, prefix + "cntc_pson_nm", ""));
		setFaxDate(JSPUtil.getParameter(request, prefix + "fax_date", ""));
		setHistoryGubun(JSPUtil.getParameter(request, prefix + "history_gubun", ""));
		setCnsnNm(JSPUtil.getParameter(request, prefix + "cnsn_nm", ""));
		setShprNm(JSPUtil.getParameter(request, prefix + "shpr_nm", ""));
		setShprCd(JSPUtil.getParameter(request, prefix + "shpr_cd", ""));
		setRcvinfo(JSPUtil.getParameter(request, prefix + "rcvinfo", ""));
		setSyscd(JSPUtil.getParameter(request, prefix + "syscd", ""));
		setTmplparam(JSPUtil.getParameter(request, prefix + "tmplparam", ""));
		setTmplparam2(JSPUtil.getParameter(request, prefix + "tmplparam2", ""));
		setTmplmrd(JSPUtil.getParameter(request, prefix + "tmplmrd", ""));
		setContents(JSPUtil.getParameter(request, prefix + "contents", ""));
		setRcveml(JSPUtil.getParameter(request, prefix + "rcveml", ""));
		setNtcKndCd(JSPUtil.getParameter(request, prefix + "ntc_knd_cd", ""));
		setFrtAllFlg(JSPUtil.getParameter(request, prefix + "frt_all_flg", ""));
		setShortShprNm(JSPUtil.getParameter(request, prefix + "short_shpr_nm", ""));
		setFilekey(JSPUtil.getParameter(request, prefix + "filekey", ""));
		setBatchflg(JSPUtil.getParameter(request, prefix + "batchflg", ""));
		setFrtChgFlg(JSPUtil.getParameter(request, prefix + "frt_chg_flg", ""));
		setEmlReason(JSPUtil.getParameter(request, prefix + "eml_reason", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFaxResult(JSPUtil.getParameter(request, prefix + "fax_result", ""));
		setFrtArrFlg(JSPUtil.getParameter(request, prefix + "frt_arr_flg", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setSndnm(JSPUtil.getParameter(request, prefix + "sndnm", ""));
		setSndeml(JSPUtil.getParameter(request, prefix + "sndeml", ""));
		setGubun(JSPUtil.getParameter(request, prefix + "gubun", ""));
		setFntEmlFlg(JSPUtil.getParameter(request, prefix + "fntEmlFlg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DblWblVO[]
	 */
	public DblWblVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DblWblVO[]
	 */
	public DblWblVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DblWblVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] eml = (JSPUtil.getParameter(request, prefix	+ "eml", length));
			String[] grpFlag = (JSPUtil.getParameter(request, prefix	+ "grp_flag", length));
			String[] cnsnCd = (JSPUtil.getParameter(request, prefix	+ "cnsn_cd", length));
			String[] tmplmrdpdf = (JSPUtil.getParameter(request, prefix	+ "tmplmrdpdf", length));
			String[] itr = (JSPUtil.getParameter(request, prefix	+ "itr", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] emlDate = (JSPUtil.getParameter(request, prefix	+ "eml_date", length));
			String[] ffCd = (JSPUtil.getParameter(request, prefix	+ "ff_cd", length));
			String[] faxReason = (JSPUtil.getParameter(request, prefix	+ "fax_reason", length));
			String[] emlResult = (JSPUtil.getParameter(request, prefix	+ "eml_result", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hiddOpt = (JSPUtil.getParameter(request, prefix	+ "hidd_opt", length));
			String[] frtPpdFlg = (JSPUtil.getParameter(request, prefix	+ "frt_ppd_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] frtCltFlg = (JSPUtil.getParameter(request, prefix	+ "frt_clt_flg", length));
			String[] cntcPsonNm = (JSPUtil.getParameter(request, prefix	+ "cntc_pson_nm", length));
			String[] faxDate = (JSPUtil.getParameter(request, prefix	+ "fax_date", length));
			String[] historyGubun = (JSPUtil.getParameter(request, prefix	+ "history_gubun", length));
			String[] cnsnNm = (JSPUtil.getParameter(request, prefix	+ "cnsn_nm", length));
			String[] shprNm = (JSPUtil.getParameter(request, prefix	+ "shpr_nm", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] rcvinfo = (JSPUtil.getParameter(request, prefix	+ "rcvinfo", length));
			String[] syscd = (JSPUtil.getParameter(request, prefix	+ "syscd", length));
			String[] tmplparam = (JSPUtil.getParameter(request, prefix	+ "tmplparam", length));
			String[] tmplparam2 = (JSPUtil.getParameter(request, prefix	+ "tmplparam2", length));
			String[] tmplmrd = (JSPUtil.getParameter(request, prefix	+ "tmplmrd", length));
			String[] contents = (JSPUtil.getParameter(request, prefix	+ "contents", length));
			String[] rcveml = (JSPUtil.getParameter(request, prefix	+ "rcveml", length));
			String[] ntcKndCd = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_cd", length));
			String[] frtAllFlg = (JSPUtil.getParameter(request, prefix	+ "frt_all_flg", length));
			String[] shortShprNm = (JSPUtil.getParameter(request, prefix	+ "short_shpr_nm", length));
			String[] filekey = (JSPUtil.getParameter(request, prefix	+ "filekey", length));
			String[] batchflg = (JSPUtil.getParameter(request, prefix	+ "batchflg", length));
			String[] frtChgFlg = (JSPUtil.getParameter(request, prefix	+ "frt_chg_flg", length));
			String[] emlReason = (JSPUtil.getParameter(request, prefix	+ "eml_reason", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] faxResult = (JSPUtil.getParameter(request, prefix	+ "fax_result", length));
			String[] frtArrFlg = (JSPUtil.getParameter(request, prefix	+ "frt_arr_flg", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] sndnm = (JSPUtil.getParameter(request, prefix	+ "sndnm", length));
			String[] sndeml = (JSPUtil.getParameter(request, prefix	+ "sndeml", length));
			String[] gubun = (JSPUtil.getParameter(request, prefix	+ "gubun", length));
			String[] fntEmlFlg = (JSPUtil.getParameter(request, prefix	+ "fnt_eml_flg", length));
			String[] qtyBkg = (JSPUtil.getParameter(request, prefix	+ "qty_bkg", length));
			String[] qtyCntr = (JSPUtil.getParameter(request, prefix	+ "qty_cntr", length));
			String[] qtyFlg = (JSPUtil.getParameter(request, prefix	+ "qty_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new DblWblVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (eml[i] != null)
					model.setEml(eml[i]);
				if (grpFlag[i] != null)
					model.setGrpFlag(grpFlag[i]);
				if (cnsnCd[i] != null)
					model.setCnsnCd(cnsnCd[i]);
				if (tmplmrdpdf[i] != null)
					model.setTmplmrdpdf(tmplmrdpdf[i]);
				if (itr[i] != null)
					model.setItr(itr[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (emlDate[i] != null)
					model.setEmlDate(emlDate[i]);
				if (ffCd[i] != null)
					model.setFfCd(ffCd[i]);
				if (faxReason[i] != null)
					model.setFaxReason(faxReason[i]);
				if (emlResult[i] != null)
					model.setEmlResult(emlResult[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hiddOpt[i] != null)
					model.setHiddOpt(hiddOpt[i]);
				if (frtPpdFlg[i] != null)
					model.setFrtPpdFlg(frtPpdFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (frtCltFlg[i] != null)
					model.setFrtCltFlg(frtCltFlg[i]);
				if (cntcPsonNm[i] != null)
					model.setCntcPsonNm(cntcPsonNm[i]);
				if (faxDate[i] != null)
					model.setFaxDate(faxDate[i]);
				if (historyGubun[i] != null)
					model.setHistoryGubun(historyGubun[i]);
				if (cnsnNm[i] != null)
					model.setCnsnNm(cnsnNm[i]);
				if (shprNm[i] != null)
					model.setShprNm(shprNm[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (rcvinfo[i] != null)
					model.setRcvinfo(rcvinfo[i]);
				if (syscd[i] != null)
					model.setSyscd(syscd[i]);
				if (tmplparam[i] != null)
					model.setTmplparam(tmplparam[i]);
				if (tmplparam2[i] != null)
					model.setTmplparam2(tmplparam2[i]);
				if (tmplmrd[i] != null)
					model.setTmplmrd(tmplmrd[i]);
				if (contents[i] != null)
					model.setContents(contents[i]);
				if (rcveml[i] != null)
					model.setRcveml(rcveml[i]);
				if (ntcKndCd[i] != null)
					model.setNtcKndCd(ntcKndCd[i]);
				if (frtAllFlg[i] != null)
					model.setFrtAllFlg(frtAllFlg[i]);
				if (shortShprNm[i] != null)
					model.setShortShprNm(shortShprNm[i]);
				if (filekey[i] != null)
					model.setFilekey(filekey[i]);
				if (batchflg[i] != null)
					model.setBatchflg(batchflg[i]);
				if (frtChgFlg[i] != null)
					model.setFrtChgFlg(frtChgFlg[i]);
				if (emlReason[i] != null)
					model.setEmlReason(emlReason[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (faxResult[i] != null)
					model.setFaxResult(faxResult[i]);
				if (frtArrFlg[i] != null)
					model.setFrtArrFlg(frtArrFlg[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (sndnm[i] != null)
					model.setSndnm(sndnm[i]);
				if (sndeml[i] != null)
					model.setSndeml(sndeml[i]);
				if (gubun[i] != null)
					model.setGubun(gubun[i]);				
				if (fntEmlFlg[i] != null)
					model.setFntEmlFlg(fntEmlFlg[i]);
				if (qtyBkg[i] != null)
					model.setQtyBkg(qtyBkg[i]);
				if (qtyCntr[i] != null)
					model.setQtyCntr(qtyCntr[i]);				
				if (qtyFlg[i] != null)
					model.setQtyFlg(qtyFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDblWblVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DblWblVO[]
	 */
	public DblWblVO[] getDblWblVOs(){
		DblWblVO[] vos = (DblWblVO[])models.toArray(new DblWblVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eml = this.eml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpFlag = this.grpFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnsnCd = this.cnsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplmrdpdf = this.tmplmrdpdf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itr = this.itr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlDate = this.emlDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCd = this.ffCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxReason = this.faxReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlResult = this.emlResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiddOpt = this.hiddOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtPpdFlg = this.frtPpdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg = this.frtCltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcPsonNm = this.cntcPsonNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxDate = this.faxDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.historyGubun = this.historyGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnsnNm = this.cnsnNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm = this.shprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvinfo = this.rcvinfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.syscd = this.syscd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplparam = this.tmplparam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplparam2 = this.tmplparam2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplmrd = this.tmplmrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contents = this.contents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcveml = this.rcveml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndCd = this.ntcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtAllFlg = this.frtAllFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shortShprNm = this.shortShprNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.filekey = this.filekey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchflg = this.batchflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtChgFlg = this.frtChgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlReason = this.emlReason .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxResult = this.faxResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtArrFlg = this.frtArrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndnm = this.sndnm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndeml = this.sndeml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gubun = this.gubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fntEmlFlg = this.fntEmlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyBkg = this.qtyBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyCntr = this.qtyCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qtyFlg = this.qtyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
