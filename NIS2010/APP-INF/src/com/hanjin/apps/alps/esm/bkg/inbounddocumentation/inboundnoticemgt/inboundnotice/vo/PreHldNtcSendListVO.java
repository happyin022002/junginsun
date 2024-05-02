/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PreHldNtcSendListVO.java
*@FileTitle : PreHldNtcSendListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.11
*@LastModifier : 박미옥
*@LastVersion : 1.0
* 2009.12.11 박미옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo;

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
 * @author 박미옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PreHldNtcSendListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreHldNtcSendListVO> models = new ArrayList<PreHldNtcSendListVO>();
	
	/* Column Info */
	private String preHldDt = null;
	/* Column Info */
	private String hldNtcTpCd = null;
	/* Column Info */
	private String hldEclzOblFlg = null;
	/* Column Info */
	private String hldEmlSndRsltNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String hldEmlSndDt = null;
	/* Column Info */
	private String custCntcTpCd = null;
	/* Column Info */
	private String cstmsPreHldCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String hldFaxSndDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntcEml = null;
	/* Column Info */
	private String hldFaxSndRsltNm = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String cstmsHldNtcFomCd = null;
	/* Column Info */
	private String cstmsHldLocCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String ntcSeq = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String hldFaxSndRslt = null;
	/* Column Info */
	private String hldSndDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String hldDiffRmk = null;
	/* Column Info */
	private String faxNo = null;
	/* Column Info */
	private String ntcWdYn = null;
	/* Column Info */
	private String hldEmlSndRslt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PreHldNtcSendListVO() {}

	public PreHldNtcSendListVO(String ibflag, String pagerows, String bkgNo, String ntcSeq, String hldNtcTpCd, String cstmsHldNtcFomCd, String cstmsHldLocCd, String custCntCd, String custSeq, String custCd, String custNm, String cstmsPreHldCd, String preHldDt, String hldEclzOblFlg, String hldDiffRmk, String blNo, String vvd, String podCd, String delCd, String ofcCd, String custCntcTpCd, String faxNo, String ntcEml, String ntcWdYn, String hldFaxSndDt, String hldEmlSndDt, String hldSndDt, String hldFaxSndRsltNm, String hldEmlSndRsltNm, String hldFaxSndRslt, String hldEmlSndRslt) {
		this.preHldDt = preHldDt;
		this.hldNtcTpCd = hldNtcTpCd;
		this.hldEclzOblFlg = hldEclzOblFlg;
		this.hldEmlSndRsltNm = hldEmlSndRsltNm;
		this.custNm = custNm;
		this.hldEmlSndDt = hldEmlSndDt;
		this.custCntcTpCd = custCntcTpCd;
		this.cstmsPreHldCd = cstmsPreHldCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.hldFaxSndDt = hldFaxSndDt;
		this.ibflag = ibflag;
		this.ntcEml = ntcEml;
		this.hldFaxSndRsltNm = hldFaxSndRsltNm;
		this.custCntCd = custCntCd;
		this.cstmsHldNtcFomCd = cstmsHldNtcFomCd;
		this.cstmsHldLocCd = cstmsHldLocCd;
		this.delCd = delCd;
		this.custSeq = custSeq;
		this.ntcSeq = ntcSeq;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.hldFaxSndRslt = hldFaxSndRslt;
		this.hldSndDt = hldSndDt;
		this.bkgNo = bkgNo;
		this.custCd = custCd;
		this.hldDiffRmk = hldDiffRmk;
		this.faxNo = faxNo;
		this.ntcWdYn = ntcWdYn;
		this.hldEmlSndRslt = hldEmlSndRslt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pre_hld_dt", getPreHldDt());
		this.hashColumns.put("hld_ntc_tp_cd", getHldNtcTpCd());
		this.hashColumns.put("hld_eclz_obl_flg", getHldEclzOblFlg());
		this.hashColumns.put("hld_eml_snd_rslt_nm", getHldEmlSndRsltNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("hld_eml_snd_dt", getHldEmlSndDt());
		this.hashColumns.put("cust_cntc_tp_cd", getCustCntcTpCd());
		this.hashColumns.put("cstms_pre_hld_cd", getCstmsPreHldCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("hld_fax_snd_dt", getHldFaxSndDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("hld_fax_snd_rslt_nm", getHldFaxSndRsltNm());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cstms_hld_ntc_fom_cd", getCstmsHldNtcFomCd());
		this.hashColumns.put("cstms_hld_loc_cd", getCstmsHldLocCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ntc_seq", getNtcSeq());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("hld_fax_snd_rslt", getHldFaxSndRslt());
		this.hashColumns.put("hld_snd_dt", getHldSndDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("hld_diff_rmk", getHldDiffRmk());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("ntc_wd_yn", getNtcWdYn());
		this.hashColumns.put("hld_eml_snd_rslt", getHldEmlSndRslt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pre_hld_dt", "preHldDt");
		this.hashFields.put("hld_ntc_tp_cd", "hldNtcTpCd");
		this.hashFields.put("hld_eclz_obl_flg", "hldEclzOblFlg");
		this.hashFields.put("hld_eml_snd_rslt_nm", "hldEmlSndRsltNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("hld_eml_snd_dt", "hldEmlSndDt");
		this.hashFields.put("cust_cntc_tp_cd", "custCntcTpCd");
		this.hashFields.put("cstms_pre_hld_cd", "cstmsPreHldCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("hld_fax_snd_dt", "hldFaxSndDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("hld_fax_snd_rslt_nm", "hldFaxSndRsltNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cstms_hld_ntc_fom_cd", "cstmsHldNtcFomCd");
		this.hashFields.put("cstms_hld_loc_cd", "cstmsHldLocCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ntc_seq", "ntcSeq");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("hld_fax_snd_rslt", "hldFaxSndRslt");
		this.hashFields.put("hld_snd_dt", "hldSndDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("hld_diff_rmk", "hldDiffRmk");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("ntc_wd_yn", "ntcWdYn");
		this.hashFields.put("hld_eml_snd_rslt", "hldEmlSndRslt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return preHldDt
	 */
	public String getPreHldDt() {
		return this.preHldDt;
	}
	
	/**
	 * Column Info
	 * @return hldNtcTpCd
	 */
	public String getHldNtcTpCd() {
		return this.hldNtcTpCd;
	}
	
	/**
	 * Column Info
	 * @return hldEclzOblFlg
	 */
	public String getHldEclzOblFlg() {
		return this.hldEclzOblFlg;
	}
	
	/**
	 * Column Info
	 * @return hldEmlSndRsltNm
	 */
	public String getHldEmlSndRsltNm() {
		return this.hldEmlSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return hldEmlSndDt
	 */
	public String getHldEmlSndDt() {
		return this.hldEmlSndDt;
	}
	
	/**
	 * Column Info
	 * @return custCntcTpCd
	 */
	public String getCustCntcTpCd() {
		return this.custCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsPreHldCd
	 */
	public String getCstmsPreHldCd() {
		return this.cstmsPreHldCd;
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
	 * @return hldFaxSndDt
	 */
	public String getHldFaxSndDt() {
		return this.hldFaxSndDt;
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
	 * @return ntcEml
	 */
	public String getNtcEml() {
		return this.ntcEml;
	}
	
	/**
	 * Column Info
	 * @return hldFaxSndRsltNm
	 */
	public String getHldFaxSndRsltNm() {
		return this.hldFaxSndRsltNm;
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
	 * @return cstmsHldNtcFomCd
	 */
	public String getCstmsHldNtcFomCd() {
		return this.cstmsHldNtcFomCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsHldLocCd
	 */
	public String getCstmsHldLocCd() {
		return this.cstmsHldLocCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return ntcSeq
	 */
	public String getNtcSeq() {
		return this.ntcSeq;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return hldFaxSndRslt
	 */
	public String getHldFaxSndRslt() {
		return this.hldFaxSndRslt;
	}
	
	/**
	 * Column Info
	 * @return hldSndDt
	 */
	public String getHldSndDt() {
		return this.hldSndDt;
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
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return hldDiffRmk
	 */
	public String getHldDiffRmk() {
		return this.hldDiffRmk;
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
	 * @return ntcWdYn
	 */
	public String getNtcWdYn() {
		return this.ntcWdYn;
	}
	
	/**
	 * Column Info
	 * @return hldEmlSndRslt
	 */
	public String getHldEmlSndRslt() {
		return this.hldEmlSndRslt;
	}
	

	/**
	 * Column Info
	 * @param preHldDt
	 */
	public void setPreHldDt(String preHldDt) {
		this.preHldDt = preHldDt;
	}
	
	/**
	 * Column Info
	 * @param hldNtcTpCd
	 */
	public void setHldNtcTpCd(String hldNtcTpCd) {
		this.hldNtcTpCd = hldNtcTpCd;
	}
	
	/**
	 * Column Info
	 * @param hldEclzOblFlg
	 */
	public void setHldEclzOblFlg(String hldEclzOblFlg) {
		this.hldEclzOblFlg = hldEclzOblFlg;
	}
	
	/**
	 * Column Info
	 * @param hldEmlSndRsltNm
	 */
	public void setHldEmlSndRsltNm(String hldEmlSndRsltNm) {
		this.hldEmlSndRsltNm = hldEmlSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param hldEmlSndDt
	 */
	public void setHldEmlSndDt(String hldEmlSndDt) {
		this.hldEmlSndDt = hldEmlSndDt;
	}
	
	/**
	 * Column Info
	 * @param custCntcTpCd
	 */
	public void setCustCntcTpCd(String custCntcTpCd) {
		this.custCntcTpCd = custCntcTpCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsPreHldCd
	 */
	public void setCstmsPreHldCd(String cstmsPreHldCd) {
		this.cstmsPreHldCd = cstmsPreHldCd;
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
	 * @param hldFaxSndDt
	 */
	public void setHldFaxSndDt(String hldFaxSndDt) {
		this.hldFaxSndDt = hldFaxSndDt;
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
	 * @param ntcEml
	 */
	public void setNtcEml(String ntcEml) {
		this.ntcEml = ntcEml;
	}
	
	/**
	 * Column Info
	 * @param hldFaxSndRsltNm
	 */
	public void setHldFaxSndRsltNm(String hldFaxSndRsltNm) {
		this.hldFaxSndRsltNm = hldFaxSndRsltNm;
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
	 * @param cstmsHldNtcFomCd
	 */
	public void setCstmsHldNtcFomCd(String cstmsHldNtcFomCd) {
		this.cstmsHldNtcFomCd = cstmsHldNtcFomCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsHldLocCd
	 */
	public void setCstmsHldLocCd(String cstmsHldLocCd) {
		this.cstmsHldLocCd = cstmsHldLocCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param ntcSeq
	 */
	public void setNtcSeq(String ntcSeq) {
		this.ntcSeq = ntcSeq;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param hldFaxSndRslt
	 */
	public void setHldFaxSndRslt(String hldFaxSndRslt) {
		this.hldFaxSndRslt = hldFaxSndRslt;
	}
	
	/**
	 * Column Info
	 * @param hldSndDt
	 */
	public void setHldSndDt(String hldSndDt) {
		this.hldSndDt = hldSndDt;
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
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param hldDiffRmk
	 */
	public void setHldDiffRmk(String hldDiffRmk) {
		this.hldDiffRmk = hldDiffRmk;
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
	 * @param ntcWdYn
	 */
	public void setNtcWdYn(String ntcWdYn) {
		this.ntcWdYn = ntcWdYn;
	}
	
	/**
	 * Column Info
	 * @param hldEmlSndRslt
	 */
	public void setHldEmlSndRslt(String hldEmlSndRslt) {
		this.hldEmlSndRslt = hldEmlSndRslt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPreHldDt(JSPUtil.getParameter(request, "pre_hld_dt", ""));
		setHldNtcTpCd(JSPUtil.getParameter(request, "hld_ntc_tp_cd", ""));
		setHldEclzOblFlg(JSPUtil.getParameter(request, "hld_eclz_obl_flg", ""));
		setHldEmlSndRsltNm(JSPUtil.getParameter(request, "hld_eml_snd_rslt_nm", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setHldEmlSndDt(JSPUtil.getParameter(request, "hld_eml_snd_dt", ""));
		setCustCntcTpCd(JSPUtil.getParameter(request, "cust_cntc_tp_cd", ""));
		setCstmsPreHldCd(JSPUtil.getParameter(request, "cstms_pre_hld_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setHldFaxSndDt(JSPUtil.getParameter(request, "hld_fax_snd_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNtcEml(JSPUtil.getParameter(request, "ntc_eml", ""));
		setHldFaxSndRsltNm(JSPUtil.getParameter(request, "hld_fax_snd_rslt_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCstmsHldNtcFomCd(JSPUtil.getParameter(request, "cstms_hld_ntc_fom_cd", ""));
		setCstmsHldLocCd(JSPUtil.getParameter(request, "cstms_hld_loc_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setNtcSeq(JSPUtil.getParameter(request, "ntc_seq", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setHldFaxSndRslt(JSPUtil.getParameter(request, "hld_fax_snd_rslt", ""));
		setHldSndDt(JSPUtil.getParameter(request, "hld_snd_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setHldDiffRmk(JSPUtil.getParameter(request, "hld_diff_rmk", ""));
		setFaxNo(JSPUtil.getParameter(request, "fax_no", ""));
		setNtcWdYn(JSPUtil.getParameter(request, "ntc_wd_yn", ""));
		setHldEmlSndRslt(JSPUtil.getParameter(request, "hld_eml_snd_rslt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreHldNtcSendListVO[]
	 */
	public PreHldNtcSendListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreHldNtcSendListVO[]
	 */
	public PreHldNtcSendListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreHldNtcSendListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] preHldDt = (JSPUtil.getParameter(request, prefix	+ "pre_hld_dt", length));
			String[] hldNtcTpCd = (JSPUtil.getParameter(request, prefix	+ "hld_ntc_tp_cd", length));
			String[] hldEclzOblFlg = (JSPUtil.getParameter(request, prefix	+ "hld_eclz_obl_flg", length));
			String[] hldEmlSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "hld_eml_snd_rslt_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] hldEmlSndDt = (JSPUtil.getParameter(request, prefix	+ "hld_eml_snd_dt", length));
			String[] custCntcTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_tp_cd", length));
			String[] cstmsPreHldCd = (JSPUtil.getParameter(request, prefix	+ "cstms_pre_hld_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] hldFaxSndDt = (JSPUtil.getParameter(request, prefix	+ "hld_fax_snd_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] hldFaxSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "hld_fax_snd_rslt_nm", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] cstmsHldNtcFomCd = (JSPUtil.getParameter(request, prefix	+ "cstms_hld_ntc_fom_cd", length));
			String[] cstmsHldLocCd = (JSPUtil.getParameter(request, prefix	+ "cstms_hld_loc_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] ntcSeq = (JSPUtil.getParameter(request, prefix	+ "ntc_seq", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] hldFaxSndRslt = (JSPUtil.getParameter(request, prefix	+ "hld_fax_snd_rslt", length));
			String[] hldSndDt = (JSPUtil.getParameter(request, prefix	+ "hld_snd_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] hldDiffRmk = (JSPUtil.getParameter(request, prefix	+ "hld_diff_rmk", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] ntcWdYn = (JSPUtil.getParameter(request, prefix	+ "ntc_wd_yn", length));
			String[] hldEmlSndRslt = (JSPUtil.getParameter(request, prefix	+ "hld_eml_snd_rslt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreHldNtcSendListVO();
				if (preHldDt[i] != null)
					model.setPreHldDt(preHldDt[i]);
				if (hldNtcTpCd[i] != null)
					model.setHldNtcTpCd(hldNtcTpCd[i]);
				if (hldEclzOblFlg[i] != null)
					model.setHldEclzOblFlg(hldEclzOblFlg[i]);
				if (hldEmlSndRsltNm[i] != null)
					model.setHldEmlSndRsltNm(hldEmlSndRsltNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (hldEmlSndDt[i] != null)
					model.setHldEmlSndDt(hldEmlSndDt[i]);
				if (custCntcTpCd[i] != null)
					model.setCustCntcTpCd(custCntcTpCd[i]);
				if (cstmsPreHldCd[i] != null)
					model.setCstmsPreHldCd(cstmsPreHldCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (hldFaxSndDt[i] != null)
					model.setHldFaxSndDt(hldFaxSndDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (hldFaxSndRsltNm[i] != null)
					model.setHldFaxSndRsltNm(hldFaxSndRsltNm[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (cstmsHldNtcFomCd[i] != null)
					model.setCstmsHldNtcFomCd(cstmsHldNtcFomCd[i]);
				if (cstmsHldLocCd[i] != null)
					model.setCstmsHldLocCd(cstmsHldLocCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (ntcSeq[i] != null)
					model.setNtcSeq(ntcSeq[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (hldFaxSndRslt[i] != null)
					model.setHldFaxSndRslt(hldFaxSndRslt[i]);
				if (hldSndDt[i] != null)
					model.setHldSndDt(hldSndDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (hldDiffRmk[i] != null)
					model.setHldDiffRmk(hldDiffRmk[i]);
				if (faxNo[i] != null)
					model.setFaxNo(faxNo[i]);
				if (ntcWdYn[i] != null)
					model.setNtcWdYn(ntcWdYn[i]);
				if (hldEmlSndRslt[i] != null)
					model.setHldEmlSndRslt(hldEmlSndRslt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreHldNtcSendListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreHldNtcSendListVO[]
	 */
	public PreHldNtcSendListVO[] getPreHldNtcSendListVOs(){
		PreHldNtcSendListVO[] vos = (PreHldNtcSendListVO[])models.toArray(new PreHldNtcSendListVO[models.size()]);
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
		this.preHldDt = this.preHldDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldNtcTpCd = this.hldNtcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldEclzOblFlg = this.hldEclzOblFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldEmlSndRsltNm = this.hldEmlSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldEmlSndDt = this.hldEmlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcTpCd = this.custCntcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPreHldCd = this.cstmsPreHldCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldFaxSndDt = this.hldFaxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldFaxSndRsltNm = this.hldFaxSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsHldNtcFomCd = this.cstmsHldNtcFomCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsHldLocCd = this.cstmsHldLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSeq = this.ntcSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldFaxSndRslt = this.hldFaxSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldSndDt = this.hldSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldDiffRmk = this.hldDiffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcWdYn = this.ntcWdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldEmlSndRslt = this.hldEmlSndRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
