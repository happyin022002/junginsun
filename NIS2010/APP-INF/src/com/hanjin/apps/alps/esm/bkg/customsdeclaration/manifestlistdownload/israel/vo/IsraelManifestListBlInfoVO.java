/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : IsraelManifestListBlInfoVO.java
*@FileTitle : IsraelManifestListBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.08.19 김보배 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.israel.vo;

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
 * @author 김보배
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class IsraelManifestListBlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IsraelManifestListBlInfoVO> models = new ArrayList<IsraelManifestListBlInfoVO>();
	
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String dtSeq = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String shAd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String errYn = null;
	/* Column Info */
	private String bPodCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String custToOrdFlg = null;
	/* Column Info */
	private String shNm = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String vslFullname = null;
	/* Column Info */
	private String ilEta = null;
	/* Column Info */
	private String vslCallsign = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ntfyAd = null;
	/* Column Info */
	private String ntfyNm = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String cneeAd = null;
	/* Column Info */
	private String bPolCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeNm = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vslLloydcode = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String ttlBl = null;
	/* Column Info */
	private String loclBl = null;
	/* Column Info */
	private String tsBl = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public IsraelManifestListBlInfoVO() {}

	public IsraelManifestListBlInfoVO(String ibflag, String pagerows, String blNo, String bkgNo, String dtSeq, String cntrNo, String bkgCgoTpCd, String polCd, String podCd, String bPolCd, String bPodCd, String delCd, String ilEta, String pckQty, String pckTpCd, String shNm, String shAd, String cneeNm, String cneeAd, String ntfyNm, String ntfyAd, String vslCallsign, String vslLloydcode, String vslFullname, String eta, String etd, String slanCd, String custToOrdFlg, String errYn, String ttlBl, String loclBl, String tsBl) {
		this.eta = eta;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.dtSeq = dtSeq;
		this.etd = etd;
		this.shAd = shAd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.errYn = errYn;
		this.bPodCd = bPodCd;
		this.pckQty = pckQty;
		this.custToOrdFlg = custToOrdFlg;
		this.shNm = shNm;
		this.pckTpCd = pckTpCd;
		this.vslFullname = vslFullname;
		this.ilEta = ilEta;
		this.vslCallsign = vslCallsign;
		this.delCd = delCd;
		this.ntfyAd = ntfyAd;
		this.ntfyNm = ntfyNm;
		this.podCd = podCd;
		this.cneeAd = cneeAd;
		this.bPolCd = bPolCd;
		this.bkgNo = bkgNo;
		this.cneeNm = cneeNm;
		this.slanCd = slanCd;
		this.vslLloydcode = vslLloydcode;
		this.cntrNo = cntrNo;
		this.ttlBl = ttlBl;
		this.loclBl = loclBl;
		this.tsBl = tsBl;				
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("dt_seq", getDtSeq());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("sh_ad", getShAd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("err_yn", getErrYn());
		this.hashColumns.put("b_pod_cd", getBPodCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("cust_to_ord_flg", getCustToOrdFlg());
		this.hashColumns.put("sh_nm", getShNm());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("vsl_fullname", getVslFullname());
		this.hashColumns.put("il_eta", getIlEta());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ntfy_ad", getNtfyAd());
		this.hashColumns.put("ntfy_nm", getNtfyNm());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cnee_ad", getCneeAd());
		this.hashColumns.put("b_pol_cd", getBPolCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_nm", getCneeNm());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vsl_lloydcode", getVslLloydcode());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ttl_bl", getTtlBl());
		this.hashColumns.put("locl_bl", getLoclBl());
		this.hashColumns.put("ts_bl", getTsBl());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("eta", "eta");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("dt_seq", "dtSeq");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("sh_ad", "shAd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("err_yn", "errYn");
		this.hashFields.put("b_pod_cd", "bPodCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("cust_to_ord_flg", "custToOrdFlg");
		this.hashFields.put("sh_nm", "shNm");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("vsl_fullname", "vslFullname");
		this.hashFields.put("il_eta", "ilEta");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ntfy_ad", "ntfyAd");
		this.hashFields.put("ntfy_nm", "ntfyNm");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cnee_ad", "cneeAd");
		this.hashFields.put("b_pol_cd", "bPolCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vsl_lloydcode", "vslLloydcode");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ttl_bl", "ttlBl");
		this.hashFields.put("locl_bl", "loclBl");
		this.hashFields.put("ts_bl", "tsBl");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @return dtSeq
	 */
	public String getDtSeq() {
		return this.dtSeq;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return shAd
	 */
	public String getShAd() {
		return this.shAd;
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
	 * @return errYn
	 */
	public String getErrYn() {
		return this.errYn;
	}
	
	/**
	 * Column Info
	 * @return bPodCd
	 */
	public String getBPodCd() {
		return this.bPodCd;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return custToOrdFlg
	 */
	public String getCustToOrdFlg() {
		return this.custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @return shNm
	 */
	public String getShNm() {
		return this.shNm;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslFullname
	 */
	public String getVslFullname() {
		return this.vslFullname;
	}
	
	/**
	 * Column Info
	 * @return ilEta
	 */
	public String getIlEta() {
		return this.ilEta;
	}
	
	/**
	 * Column Info
	 * @return vslCallsign
	 */
	public String getVslCallsign() {
		return this.vslCallsign;
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
	 * @return ntfyAd
	 */
	public String getNtfyAd() {
		return this.ntfyAd;
	}
	
	/**
	 * Column Info
	 * @return ntfyNm
	 */
	public String getNtfyNm() {
		return this.ntfyNm;
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
	 * @return cneeAd
	 */
	public String getCneeAd() {
		return this.cneeAd;
	}
	
	/**
	 * Column Info
	 * @return bPolCd
	 */
	public String getBPolCd() {
		return this.bPolCd;
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
	 * @return cneeNm
	 */
	public String getCneeNm() {
		return this.cneeNm;
	}
	
	/**
	 * Column Info
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return vslLloydcode
	 */
	public String getVslLloydcode() {
		return this.vslLloydcode;
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
	 * @return ttlBl
	 */
	public String getTtlBl() {
		return this.ttlBl;
	}
	
	/**
	 * Column Info
	 * @return loclBl
	 */
	public String getLoclBl() {
		return this.loclBl;
	}

	/**
	 * Column Info
	 * @return tsBl
	 */
	public String getTsBl() {
		return this.tsBl;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
	}
	
	/**
	 * Column Info
	 * @param dtSeq
	 */
	public void setDtSeq(String dtSeq) {
		this.dtSeq = dtSeq;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param shAd
	 */
	public void setShAd(String shAd) {
		this.shAd = shAd;
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
	 * @param errYn
	 */
	public void setErrYn(String errYn) {
		this.errYn = errYn;
	}
	
	/**
	 * Column Info
	 * @param bPodCd
	 */
	public void setBPodCd(String bPodCd) {
		this.bPodCd = bPodCd;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param custToOrdFlg
	 */
	public void setCustToOrdFlg(String custToOrdFlg) {
		this.custToOrdFlg = custToOrdFlg;
	}
	
	/**
	 * Column Info
	 * @param shNm
	 */
	public void setShNm(String shNm) {
		this.shNm = shNm;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslFullname
	 */
	public void setVslFullname(String vslFullname) {
		this.vslFullname = vslFullname;
	}
	
	/**
	 * Column Info
	 * @param ilEta
	 */
	public void setIlEta(String ilEta) {
		this.ilEta = ilEta;
	}
	
	/**
	 * Column Info
	 * @param vslCallsign
	 */
	public void setVslCallsign(String vslCallsign) {
		this.vslCallsign = vslCallsign;
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
	 * @param ntfyAd
	 */
	public void setNtfyAd(String ntfyAd) {
		this.ntfyAd = ntfyAd;
	}
	
	/**
	 * Column Info
	 * @param ntfyNm
	 */
	public void setNtfyNm(String ntfyNm) {
		this.ntfyNm = ntfyNm;
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
	 * @param cneeAd
	 */
	public void setCneeAd(String cneeAd) {
		this.cneeAd = cneeAd;
	}
	
	/**
	 * Column Info
	 * @param bPolCd
	 */
	public void setBPolCd(String bPolCd) {
		this.bPolCd = bPolCd;
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
	 * @param cneeNm
	 */
	public void setCneeNm(String cneeNm) {
		this.cneeNm = cneeNm;
	}
	
	/**
	 * Column Info
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param vslLloydcode
	 */
	public void setVslLloydcode(String vslLloydcode) {
		this.vslLloydcode = vslLloydcode;
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
	 * @param ttlBl
	 */
	public void setTtlBl(String ttlBl) {
		this.ttlBl = ttlBl;
	}	
	
	/**
	 * Column Info
	 * @param loclBl
	 */
	public void setLoclBl(String loclBl) {
		this.loclBl = loclBl;
	}
	
	/**
	 * Column Info
	 * @param tsBl
	 */
	public void setTsBl(String tsBl) {
		this.tsBl = tsBl;
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
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, prefix + "bkg_cgo_tp_cd", ""));
		setDtSeq(JSPUtil.getParameter(request, prefix + "dt_seq", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setShAd(JSPUtil.getParameter(request, prefix + "sh_ad", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setErrYn(JSPUtil.getParameter(request, prefix + "err_yn", ""));
		setBPodCd(JSPUtil.getParameter(request, prefix + "b_pod_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setCustToOrdFlg(JSPUtil.getParameter(request, prefix + "cust_to_ord_flg", ""));
		setShNm(JSPUtil.getParameter(request, prefix + "sh_nm", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setVslFullname(JSPUtil.getParameter(request, prefix + "vsl_fullname", ""));
		setIlEta(JSPUtil.getParameter(request, prefix + "il_eta", ""));
		setVslCallsign(JSPUtil.getParameter(request, prefix + "vsl_callsign", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setNtfyAd(JSPUtil.getParameter(request, prefix + "ntfy_ad", ""));
		setNtfyNm(JSPUtil.getParameter(request, prefix + "ntfy_nm", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setCneeAd(JSPUtil.getParameter(request, prefix + "cnee_ad", ""));
		setBPolCd(JSPUtil.getParameter(request, prefix + "b_pol_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCneeNm(JSPUtil.getParameter(request, prefix + "cnee_nm", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setVslLloydcode(JSPUtil.getParameter(request, prefix + "vsl_lloydcode", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setTtlBl(JSPUtil.getParameter(request, prefix + "ttl_bl", ""));
		setLoclBl(JSPUtil.getParameter(request, prefix + "locl_bl", ""));
		setTsBl(JSPUtil.getParameter(request, prefix + "ts_bl", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IsraelManifestListBlInfoVO[]
	 */
	public IsraelManifestListBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IsraelManifestListBlInfoVO[]
	 */
	public IsraelManifestListBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IsraelManifestListBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] dtSeq = (JSPUtil.getParameter(request, prefix	+ "dt_seq", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] shAd = (JSPUtil.getParameter(request, prefix	+ "sh_ad", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] errYn = (JSPUtil.getParameter(request, prefix	+ "err_yn", length));
			String[] bPodCd = (JSPUtil.getParameter(request, prefix	+ "b_pod_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] custToOrdFlg = (JSPUtil.getParameter(request, prefix	+ "cust_to_ord_flg", length));
			String[] shNm = (JSPUtil.getParameter(request, prefix	+ "sh_nm", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] vslFullname = (JSPUtil.getParameter(request, prefix	+ "vsl_fullname", length));
			String[] ilEta = (JSPUtil.getParameter(request, prefix	+ "il_eta", length));
			String[] vslCallsign = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] ntfyAd = (JSPUtil.getParameter(request, prefix	+ "ntfy_ad", length));
			String[] ntfyNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_nm", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] cneeAd = (JSPUtil.getParameter(request, prefix	+ "cnee_ad", length));
			String[] bPolCd = (JSPUtil.getParameter(request, prefix	+ "b_pol_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeNm = (JSPUtil.getParameter(request, prefix	+ "cnee_nm", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vslLloydcode = (JSPUtil.getParameter(request, prefix	+ "vsl_lloydcode", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] ttlBl = (JSPUtil.getParameter(request, prefix	+ "ttl_bl", length));
			String[] loclBl = (JSPUtil.getParameter(request, prefix	+ "locl_bl", length));
			String[] tsBl = (JSPUtil.getParameter(request, prefix	+ "ts_bl", length));
			
			for (int i = 0; i < length; i++) {
				model = new IsraelManifestListBlInfoVO();
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (dtSeq[i] != null)
					model.setDtSeq(dtSeq[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (shAd[i] != null)
					model.setShAd(shAd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (errYn[i] != null)
					model.setErrYn(errYn[i]);
				if (bPodCd[i] != null)
					model.setBPodCd(bPodCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (custToOrdFlg[i] != null)
					model.setCustToOrdFlg(custToOrdFlg[i]);
				if (shNm[i] != null)
					model.setShNm(shNm[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (vslFullname[i] != null)
					model.setVslFullname(vslFullname[i]);
				if (ilEta[i] != null)
					model.setIlEta(ilEta[i]);
				if (vslCallsign[i] != null)
					model.setVslCallsign(vslCallsign[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ntfyAd[i] != null)
					model.setNtfyAd(ntfyAd[i]);
				if (ntfyNm[i] != null)
					model.setNtfyNm(ntfyNm[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (cneeAd[i] != null)
					model.setCneeAd(cneeAd[i]);
				if (bPolCd[i] != null)
					model.setBPolCd(bPolCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeNm[i] != null)
					model.setCneeNm(cneeNm[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vslLloydcode[i] != null)
					model.setVslLloydcode(vslLloydcode[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ttlBl[i] != null)
					model.setTtlBl(ttlBl[i]);
				if (loclBl[i] != null)
					model.setLoclBl(loclBl[i]);
				if (tsBl[i] != null)
					model.setTsBl(tsBl[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIsraelManifestListBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IsraelManifestListBlInfoVO[]
	 */
	public IsraelManifestListBlInfoVO[] getIsraelManifestListBlInfoVOs(){
		IsraelManifestListBlInfoVO[] vos = (IsraelManifestListBlInfoVO[])models.toArray(new IsraelManifestListBlInfoVO[models.size()]);
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
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtSeq = this.dtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shAd = this.shAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errYn = this.errYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPodCd = this.bPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custToOrdFlg = this.custToOrdFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shNm = this.shNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFullname = this.vslFullname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ilEta = this.ilEta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign = this.vslCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAd = this.ntfyAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyNm = this.ntfyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeAd = this.cneeAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bPolCd = this.bPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm = this.cneeNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloydcode = this.vslLloydcode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlBl = this.ttlBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclBl = this.loclBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsBl = this.tsBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
