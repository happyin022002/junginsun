/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MtyRlseOrdDetailOutVO.java
*@FileTitle : MtyRlseOrdDetailOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.11  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MtyRlseOrdDetailOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyRlseOrdDetailOutVO> models = new ArrayList<MtyRlseOrdDetailOutVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String emlSndRsltCd = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String faxSndRsltNm = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String mtyPkupYdCd = null;
	/* Column Info */
	private String faxSndRsltCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntcEml = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String ntcFaxNo = null;
	/* Column Info */
	private String cntrQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String mtyPkupDt = null;
	/* Column Info */
	private String fullRtnYdCd = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String sccCd = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String flexHgtFlg = null;
	/* Column Info */
	private String emlSndRsltNm = null;
	/* Column Info */
	private String faxSndDt = null;
	/* Column Info */
	private String ediSndDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MtyRlseOrdDetailOutVO() {}

	public MtyRlseOrdDetailOutVO(String ibflag, String pagerows, String bkgNo, String bkgStsCd, String rcvTermCd, String deTermCd, String porCd, String polCd, String eqCtrlOfcCd, String sccCd, String mtyPkupYdCd, String mtyPkupDt, String vvd, String fullRtnYdCd, String ediId, String ediSndDt, String ntcFaxNo, String faxSndDt, String faxSndRsltCd, String faxSndRsltNm, String ntcEml, String emlSndDt, String emlSndRsltCd, String emlSndRsltNm, String custNm, String cmdtCd, String cmdtNm, String diffRmk, String cntrQty, String xterRmk, String flexHgtFlg) {
		this.porCd = porCd;
		this.emlSndRsltCd = emlSndRsltCd;
		this.emlSndDt = emlSndDt;
		this.faxSndRsltNm = faxSndRsltNm;
		this.custNm = custNm;
		this.bkgStsCd = bkgStsCd;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.mtyPkupYdCd = mtyPkupYdCd;
		this.faxSndRsltCd = faxSndRsltCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.ntcEml = ntcEml;
		this.cmdtCd = cmdtCd;
		this.ntcFaxNo = ntcFaxNo;
		this.cntrQty = cntrQty;
		this.rcvTermCd = rcvTermCd;
		this.mtyPkupDt = mtyPkupDt;
		this.fullRtnYdCd = fullRtnYdCd;
		this.ediId = ediId;
		this.cmdtNm = cmdtNm;
		this.vvd = vvd;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.sccCd = sccCd;
		this.xterRmk = xterRmk;
		this.flexHgtFlg = flexHgtFlg;
		this.emlSndRsltNm = emlSndRsltNm;
		this.faxSndDt = faxSndDt;
		this.ediSndDt = ediSndDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("eml_snd_rslt_cd", getEmlSndRsltCd());
		this.hashColumns.put("eml_snd_dt", getEmlSndDt());
		this.hashColumns.put("fax_snd_rslt_nm", getFaxSndRsltNm());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("mty_pkup_yd_cd", getMtyPkupYdCd());
		this.hashColumns.put("fax_snd_rslt_cd", getFaxSndRsltCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("ntc_fax_no", getNtcFaxNo());
		this.hashColumns.put("cntr_qty", getCntrQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("mty_pkup_dt", getMtyPkupDt());
		this.hashColumns.put("full_rtn_yd_cd", getFullRtnYdCd());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("scc_cd", getSccCd());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
		this.hashColumns.put("eml_snd_rslt_nm", getEmlSndRsltNm());
		this.hashColumns.put("fax_snd_dt", getFaxSndDt());
		this.hashColumns.put("edi_snd_dt", getEdiSndDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("eml_snd_rslt_cd", "emlSndRsltCd");
		this.hashFields.put("eml_snd_dt", "emlSndDt");
		this.hashFields.put("fax_snd_rslt_nm", "faxSndRsltNm");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("mty_pkup_yd_cd", "mtyPkupYdCd");
		this.hashFields.put("fax_snd_rslt_cd", "faxSndRsltCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("ntc_fax_no", "ntcFaxNo");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("mty_pkup_dt", "mtyPkupDt");
		this.hashFields.put("full_rtn_yd_cd", "fullRtnYdCd");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
		this.hashFields.put("eml_snd_rslt_nm", "emlSndRsltNm");
		this.hashFields.put("fax_snd_dt", "faxSndDt");
		this.hashFields.put("edi_snd_dt", "ediSndDt");
		return this.hashFields;
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
	 * @return emlSndRsltCd
	 */
	public String getEmlSndRsltCd() {
		return this.emlSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return emlSndDt
	 */
	public String getEmlSndDt() {
		return this.emlSndDt;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltNm
	 */
	public String getFaxSndRsltNm() {
		return this.faxSndRsltNm;
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
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return eqCtrlOfcCd
	 */
	public String getEqCtrlOfcCd() {
		return this.eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupYdCd
	 */
	public String getMtyPkupYdCd() {
		return this.mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @return faxSndRsltCd
	 */
	public String getFaxSndRsltCd() {
		return this.faxSndRsltCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return ntcFaxNo
	 */
	public String getNtcFaxNo() {
		return this.ntcFaxNo;
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
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return mtyPkupDt
	 */
	public String getMtyPkupDt() {
		return this.mtyPkupDt;
	}
	
	/**
	 * Column Info
	 * @return fullRtnYdCd
	 */
	public String getFullRtnYdCd() {
		return this.fullRtnYdCd;
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
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return diffRmk
	 */
	public String getDiffRmk() {
		return this.diffRmk;
	}
	
	/**
	 * Column Info
	 * @return sccCd
	 */
	public String getSccCd() {
		return this.sccCd;
	}
	
	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}
	
	/**
	 * Column Info
	 * @return flexHgtFlg
	 */
	public String getFlexHgtFlg() {
		return this.flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @return emlSndRsltNm
	 */
	public String getEmlSndRsltNm() {
		return this.emlSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @return faxSndDt
	 */
	public String getFaxSndDt() {
		return this.faxSndDt;
	}
	
	/**
	 * Column Info
	 * @return ediSndDt
	 */
	public String getEdiSndDt() {
		return this.ediSndDt;
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
	 * @param emlSndRsltCd
	 */
	public void setEmlSndRsltCd(String emlSndRsltCd) {
		this.emlSndRsltCd = emlSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param emlSndDt
	 */
	public void setEmlSndDt(String emlSndDt) {
		this.emlSndDt = emlSndDt;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltNm
	 */
	public void setFaxSndRsltNm(String faxSndRsltNm) {
		this.faxSndRsltNm = faxSndRsltNm;
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
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param eqCtrlOfcCd
	 */
	public void setEqCtrlOfcCd(String eqCtrlOfcCd) {
		this.eqCtrlOfcCd = eqCtrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupYdCd
	 */
	public void setMtyPkupYdCd(String mtyPkupYdCd) {
		this.mtyPkupYdCd = mtyPkupYdCd;
	}
	
	/**
	 * Column Info
	 * @param faxSndRsltCd
	 */
	public void setFaxSndRsltCd(String faxSndRsltCd) {
		this.faxSndRsltCd = faxSndRsltCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param ntcFaxNo
	 */
	public void setNtcFaxNo(String ntcFaxNo) {
		this.ntcFaxNo = ntcFaxNo;
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
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param mtyPkupDt
	 */
	public void setMtyPkupDt(String mtyPkupDt) {
		this.mtyPkupDt = mtyPkupDt;
	}
	
	/**
	 * Column Info
	 * @param fullRtnYdCd
	 */
	public void setFullRtnYdCd(String fullRtnYdCd) {
		this.fullRtnYdCd = fullRtnYdCd;
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
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param diffRmk
	 */
	public void setDiffRmk(String diffRmk) {
		this.diffRmk = diffRmk;
	}
	
	/**
	 * Column Info
	 * @param sccCd
	 */
	public void setSccCd(String sccCd) {
		this.sccCd = sccCd;
	}
	
	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}
	
	/**
	 * Column Info
	 * @param flexHgtFlg
	 */
	public void setFlexHgtFlg(String flexHgtFlg) {
		this.flexHgtFlg = flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @param emlSndRsltNm
	 */
	public void setEmlSndRsltNm(String emlSndRsltNm) {
		this.emlSndRsltNm = emlSndRsltNm;
	}
	
	/**
	 * Column Info
	 * @param faxSndDt
	 */
	public void setFaxSndDt(String faxSndDt) {
		this.faxSndDt = faxSndDt;
	}
	
	/**
	 * Column Info
	 * @param ediSndDt
	 */
	public void setEdiSndDt(String ediSndDt) {
		this.ediSndDt = ediSndDt;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setEmlSndRsltCd(JSPUtil.getParameter(request, prefix + "eml_snd_rslt_cd", ""));
		setEmlSndDt(JSPUtil.getParameter(request, prefix + "eml_snd_dt", ""));
		setFaxSndRsltNm(JSPUtil.getParameter(request, prefix + "fax_snd_rslt_nm", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, prefix + "eq_ctrl_ofc_cd", ""));
		setMtyPkupYdCd(JSPUtil.getParameter(request, prefix + "mty_pkup_yd_cd", ""));
		setFaxSndRsltCd(JSPUtil.getParameter(request, prefix + "fax_snd_rslt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNtcEml(JSPUtil.getParameter(request, prefix + "ntc_eml", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setNtcFaxNo(JSPUtil.getParameter(request, prefix + "ntc_fax_no", ""));
		setCntrQty(JSPUtil.getParameter(request, prefix + "cntr_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setMtyPkupDt(JSPUtil.getParameter(request, prefix + "mty_pkup_dt", ""));
		setFullRtnYdCd(JSPUtil.getParameter(request, prefix + "full_rtn_yd_cd", ""));
		setEdiId(JSPUtil.getParameter(request, prefix + "edi_id", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, prefix + "diff_rmk", ""));
		setSccCd(JSPUtil.getParameter(request, prefix + "scc_cd", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
		setEmlSndRsltNm(JSPUtil.getParameter(request, prefix + "eml_snd_rslt_nm", ""));
		setFaxSndDt(JSPUtil.getParameter(request, prefix + "fax_snd_dt", ""));
		setEdiSndDt(JSPUtil.getParameter(request, prefix + "edi_snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRlseOrdDetailOutVO[]
	 */
	public MtyRlseOrdDetailOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRlseOrdDetailOutVO[]
	 */
	public MtyRlseOrdDetailOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyRlseOrdDetailOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] emlSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_cd", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] faxSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_nm", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] mtyPkupYdCd = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_yd_cd", length));
			String[] faxSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] ntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ntc_fax_no", length));
			String[] cntrQty = (JSPUtil.getParameter(request, prefix	+ "cntr_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] mtyPkupDt = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_dt", length));
			String[] fullRtnYdCd = (JSPUtil.getParameter(request, prefix	+ "full_rtn_yd_cd", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix	+ "flex_hgt_flg", length));
			String[] emlSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_nm", length));
			String[] faxSndDt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_dt", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MtyRlseOrdDetailOutVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (emlSndRsltCd[i] != null)
					model.setEmlSndRsltCd(emlSndRsltCd[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (faxSndRsltNm[i] != null)
					model.setFaxSndRsltNm(faxSndRsltNm[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (mtyPkupYdCd[i] != null)
					model.setMtyPkupYdCd(mtyPkupYdCd[i]);
				if (faxSndRsltCd[i] != null)
					model.setFaxSndRsltCd(faxSndRsltCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (ntcFaxNo[i] != null)
					model.setNtcFaxNo(ntcFaxNo[i]);
				if (cntrQty[i] != null)
					model.setCntrQty(cntrQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (mtyPkupDt[i] != null)
					model.setMtyPkupDt(mtyPkupDt[i]);
				if (fullRtnYdCd[i] != null)
					model.setFullRtnYdCd(fullRtnYdCd[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (flexHgtFlg[i] != null)
					model.setFlexHgtFlg(flexHgtFlg[i]);
				if (emlSndRsltNm[i] != null)
					model.setEmlSndRsltNm(emlSndRsltNm[i]);
				if (faxSndDt[i] != null)
					model.setFaxSndDt(faxSndDt[i]);
				if (ediSndDt[i] != null)
					model.setEdiSndDt(ediSndDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMtyRlseOrdDetailOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyRlseOrdDetailOutVO[]
	 */
	public MtyRlseOrdDetailOutVO[] getMtyRlseOrdDetailOutVOs(){
		MtyRlseOrdDetailOutVO[] vos = (MtyRlseOrdDetailOutVO[])models.toArray(new MtyRlseOrdDetailOutVO[models.size()]);
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
		this.emlSndRsltCd = this.emlSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltNm = this.faxSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupYdCd = this.mtyPkupYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltCd = this.faxSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFaxNo = this.ntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty = this.cntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupDt = this.mtyPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullRtnYdCd = this.fullRtnYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flexHgtFlg = this.flexHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltNm = this.emlSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt = this.faxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
