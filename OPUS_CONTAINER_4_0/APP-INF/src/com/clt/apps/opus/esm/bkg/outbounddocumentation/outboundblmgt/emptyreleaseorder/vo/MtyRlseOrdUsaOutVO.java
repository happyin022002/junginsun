/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : MtyRlseOrdUsaOutVO.java
*@FileTitle : MtyRlseOrdUsaOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.27
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2009.07.27 최도순 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MtyRlseOrdUsaOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MtyRlseOrdUsaOutVO> models = new ArrayList<MtyRlseOrdUsaOutVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String emlSndRsltCd = null;
	/* Column Info */
	private String emlSndDt = null;
	/* Column Info */
	private String faxSndRsltNm = null;
	/* Column Info */
	private String yard = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String eqCtrlOfcCd = null;
	/* Column Info */
	private String faxSndRsltCd = null;
	/* Column Info */
	private String lodgDueDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String yardType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ntcEml = null;
	/* Column Info */
	private String ntcFaxNo = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String mtyPkupDt = null;
	/* Column Info */
	private String usaSeq = null;
	/* Column Info */
	private String tvvd = null;
	/* Column Info */
	private String colChk = null;
	/* Column Info */
	private String ediId = null;
	/* Column Info */
	private String ip = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String diffRmk = null;
	/* Column Info */
	private String sccCd = null;
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
	
	public MtyRlseOrdUsaOutVO() {}

	public MtyRlseOrdUsaOutVO(String ibflag, String pagerows, String usaSeq, String colChk, String bkgNo, String bkgStsCd, String rcvTermCd, String deTermCd, String eqCtrlOfcCd, String sccCd, String tvvd, String porCd, String mtyPkupDt, String polCd, String lodgDueDt, String ip, String yardType, String yard, String ediId, String ediSndDt, String ntcFaxNo, String faxSndDt, String faxSndRsltCd, String ntcEml, String emlSndDt, String emlSndRsltCd, String diffRmk, String faxSndRsltNm, String emlSndRsltNm) {
		this.porCd = porCd;
		this.emlSndRsltCd = emlSndRsltCd;
		this.emlSndDt = emlSndDt;
		this.faxSndRsltNm = faxSndRsltNm;
		this.yard = yard;
		this.bkgStsCd = bkgStsCd;
		this.eqCtrlOfcCd = eqCtrlOfcCd;
		this.faxSndRsltCd = faxSndRsltCd;
		this.lodgDueDt = lodgDueDt;
		this.pagerows = pagerows;
		this.yardType = yardType;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.ntcEml = ntcEml;
		this.ntcFaxNo = ntcFaxNo;
		this.rcvTermCd = rcvTermCd;
		this.mtyPkupDt = mtyPkupDt;
		this.usaSeq = usaSeq;
		this.tvvd = tvvd;
		this.colChk = colChk;
		this.ediId = ediId;
		this.ip = ip;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.diffRmk = diffRmk;
		this.sccCd = sccCd;
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
		this.hashColumns.put("yard", getYard());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("eq_ctrl_ofc_cd", getEqCtrlOfcCd());
		this.hashColumns.put("fax_snd_rslt_cd", getFaxSndRsltCd());
		this.hashColumns.put("lodg_due_dt", getLodgDueDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("yard_type", getYardType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ntc_eml", getNtcEml());
		this.hashColumns.put("ntc_fax_no", getNtcFaxNo());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("mty_pkup_dt", getMtyPkupDt());
		this.hashColumns.put("usa_seq", getUsaSeq());
		this.hashColumns.put("tvvd", getTvvd());
		this.hashColumns.put("col_chk", getColChk());
		this.hashColumns.put("edi_id", getEdiId());
		this.hashColumns.put("ip", getIp());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("scc_cd", getSccCd());
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
		this.hashFields.put("yard", "yard");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("eq_ctrl_ofc_cd", "eqCtrlOfcCd");
		this.hashFields.put("fax_snd_rslt_cd", "faxSndRsltCd");
		this.hashFields.put("lodg_due_dt", "lodgDueDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("yard_type", "yardType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ntc_eml", "ntcEml");
		this.hashFields.put("ntc_fax_no", "ntcFaxNo");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("mty_pkup_dt", "mtyPkupDt");
		this.hashFields.put("usa_seq", "usaSeq");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("col_chk", "colChk");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("ip", "ip");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("scc_cd", "sccCd");
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
	 * @return yard
	 */
	public String getYard() {
		return this.yard;
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
	 * @return faxSndRsltCd
	 */
	public String getFaxSndRsltCd() {
		return this.faxSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @return lodgDueDt
	 */
	public String getLodgDueDt() {
		return this.lodgDueDt;
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
	 * @return yardType
	 */
	public String getYardType() {
		return this.yardType;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return ntcFaxNo
	 */
	public String getNtcFaxNo() {
		return this.ntcFaxNo;
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
	 * @return usaSeq
	 */
	public String getUsaSeq() {
		return this.usaSeq;
	}
	
	/**
	 * Column Info
	 * @return tvvd
	 */
	public String getTvvd() {
		return this.tvvd;
	}
	
	/**
	 * Column Info
	 * @return colChk
	 */
	public String getColChk() {
		return this.colChk;
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
	 * @return ip
	 */
	public String getIp() {
		return this.ip;
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
	 * @param yard
	 */
	public void setYard(String yard) {
		this.yard = yard;
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
	 * @param faxSndRsltCd
	 */
	public void setFaxSndRsltCd(String faxSndRsltCd) {
		this.faxSndRsltCd = faxSndRsltCd;
	}
	
	/**
	 * Column Info
	 * @param lodgDueDt
	 */
	public void setLodgDueDt(String lodgDueDt) {
		this.lodgDueDt = lodgDueDt;
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
	 * @param yardType
	 */
	public void setYardType(String yardType) {
		this.yardType = yardType;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param ntcFaxNo
	 */
	public void setNtcFaxNo(String ntcFaxNo) {
		this.ntcFaxNo = ntcFaxNo;
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
	 * @param usaSeq
	 */
	public void setUsaSeq(String usaSeq) {
		this.usaSeq = usaSeq;
	}
	
	/**
	 * Column Info
	 * @param tvvd
	 */
	public void setTvvd(String tvvd) {
		this.tvvd = tvvd;
	}
	
	/**
	 * Column Info
	 * @param colChk
	 */
	public void setColChk(String colChk) {
		this.colChk = colChk;
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
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
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
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setEmlSndRsltCd(JSPUtil.getParameter(request, "eml_snd_rslt_cd", ""));
		setEmlSndDt(JSPUtil.getParameter(request, "eml_snd_dt", ""));
		setFaxSndRsltNm(JSPUtil.getParameter(request, "fax_snd_rslt_nm", ""));
		setYard(JSPUtil.getParameter(request, "yard", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setEqCtrlOfcCd(JSPUtil.getParameter(request, "eq_ctrl_ofc_cd", ""));
		setFaxSndRsltCd(JSPUtil.getParameter(request, "fax_snd_rslt_cd", ""));
		setLodgDueDt(JSPUtil.getParameter(request, "lodg_due_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setYardType(JSPUtil.getParameter(request, "yard_type", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setNtcEml(JSPUtil.getParameter(request, "ntc_eml", ""));
		setNtcFaxNo(JSPUtil.getParameter(request, "ntc_fax_no", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setMtyPkupDt(JSPUtil.getParameter(request, "mty_pkup_dt", ""));
		setUsaSeq(JSPUtil.getParameter(request, "usa_seq", ""));
		setTvvd(JSPUtil.getParameter(request, "tvvd", ""));
		setColChk(JSPUtil.getParameter(request, "col_chk", ""));
		setEdiId(JSPUtil.getParameter(request, "edi_id", ""));
		setIp(JSPUtil.getParameter(request, "ip", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setDiffRmk(JSPUtil.getParameter(request, "diff_rmk", ""));
		setSccCd(JSPUtil.getParameter(request, "scc_cd", ""));
		setEmlSndRsltNm(JSPUtil.getParameter(request, "eml_snd_rslt_nm", ""));
		setFaxSndDt(JSPUtil.getParameter(request, "fax_snd_dt", ""));
		setEdiSndDt(JSPUtil.getParameter(request, "edi_snd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MtyRlseOrdUsaOutVO[]
	 */
	public MtyRlseOrdUsaOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MtyRlseOrdUsaOutVO[]
	 */
	public MtyRlseOrdUsaOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MtyRlseOrdUsaOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] emlSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_cd", length));
			String[] emlSndDt = (JSPUtil.getParameter(request, prefix	+ "eml_snd_dt", length));
			String[] faxSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_nm", length));
			String[] yard = (JSPUtil.getParameter(request, prefix	+ "yard", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] eqCtrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "eq_ctrl_ofc_cd", length));
			String[] faxSndRsltCd = (JSPUtil.getParameter(request, prefix	+ "fax_snd_rslt_cd", length));
			String[] lodgDueDt = (JSPUtil.getParameter(request, prefix	+ "lodg_due_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] yardType = (JSPUtil.getParameter(request, prefix	+ "yard_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ntcEml = (JSPUtil.getParameter(request, prefix	+ "ntc_eml", length));
			String[] ntcFaxNo = (JSPUtil.getParameter(request, prefix	+ "ntc_fax_no", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] mtyPkupDt = (JSPUtil.getParameter(request, prefix	+ "mty_pkup_dt", length));
			String[] usaSeq = (JSPUtil.getParameter(request, prefix	+ "usa_seq", length));
			String[] tvvd = (JSPUtil.getParameter(request, prefix	+ "tvvd", length));
			String[] colChk = (JSPUtil.getParameter(request, prefix	+ "col_chk", length));
			String[] ediId = (JSPUtil.getParameter(request, prefix	+ "edi_id", length));
			String[] ip = (JSPUtil.getParameter(request, prefix	+ "ip", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] diffRmk = (JSPUtil.getParameter(request, prefix	+ "diff_rmk", length));
			String[] sccCd = (JSPUtil.getParameter(request, prefix	+ "scc_cd", length));
			String[] emlSndRsltNm = (JSPUtil.getParameter(request, prefix	+ "eml_snd_rslt_nm", length));
			String[] faxSndDt = (JSPUtil.getParameter(request, prefix	+ "fax_snd_dt", length));
			String[] ediSndDt = (JSPUtil.getParameter(request, prefix	+ "edi_snd_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new MtyRlseOrdUsaOutVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (emlSndRsltCd[i] != null)
					model.setEmlSndRsltCd(emlSndRsltCd[i]);
				if (emlSndDt[i] != null)
					model.setEmlSndDt(emlSndDt[i]);
				if (faxSndRsltNm[i] != null)
					model.setFaxSndRsltNm(faxSndRsltNm[i]);
				if (yard[i] != null)
					model.setYard(yard[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (eqCtrlOfcCd[i] != null)
					model.setEqCtrlOfcCd(eqCtrlOfcCd[i]);
				if (faxSndRsltCd[i] != null)
					model.setFaxSndRsltCd(faxSndRsltCd[i]);
				if (lodgDueDt[i] != null)
					model.setLodgDueDt(lodgDueDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (yardType[i] != null)
					model.setYardType(yardType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ntcEml[i] != null)
					model.setNtcEml(ntcEml[i]);
				if (ntcFaxNo[i] != null)
					model.setNtcFaxNo(ntcFaxNo[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (mtyPkupDt[i] != null)
					model.setMtyPkupDt(mtyPkupDt[i]);
				if (usaSeq[i] != null)
					model.setUsaSeq(usaSeq[i]);
				if (tvvd[i] != null)
					model.setTvvd(tvvd[i]);
				if (colChk[i] != null)
					model.setColChk(colChk[i]);
				if (ediId[i] != null)
					model.setEdiId(ediId[i]);
				if (ip[i] != null)
					model.setIp(ip[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (diffRmk[i] != null)
					model.setDiffRmk(diffRmk[i]);
				if (sccCd[i] != null)
					model.setSccCd(sccCd[i]);
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
		return getMtyRlseOrdUsaOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MtyRlseOrdUsaOutVO[]
	 */
	public MtyRlseOrdUsaOutVO[] getMtyRlseOrdUsaOutVOs(){
		MtyRlseOrdUsaOutVO[] vos = (MtyRlseOrdUsaOutVO[])models.toArray(new MtyRlseOrdUsaOutVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltCd = this.emlSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndDt = this.emlSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltNm = this.faxSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yard = this.yard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqCtrlOfcCd = this.eqCtrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndRsltCd = this.faxSndRsltCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lodgDueDt = this.lodgDueDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardType = this.yardType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcEml = this.ntcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcFaxNo = this.ntcFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyPkupDt = this.mtyPkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaSeq = this.usaSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd = this.tvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colChk = this.colChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId = this.ediId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ip = this.ip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk = this.diffRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd = this.sccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSndRsltNm = this.emlSndRsltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxSndDt = this.faxSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndDt = this.ediSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
