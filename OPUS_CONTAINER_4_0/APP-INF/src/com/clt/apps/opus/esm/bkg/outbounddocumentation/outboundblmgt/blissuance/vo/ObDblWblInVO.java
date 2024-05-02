/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ObDblWblInVO.java
*@FileTitle : ObDblWblInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.10
*@LastModifier : 이일민
*@LastVersion : 1.0
* 2009.09.10 이일민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 이일민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ObDblWblInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ObDblWblInVO> models = new ArrayList<ObDblWblInVO>();

	private String blTpCd = null;
	private String vslCd = null;
	private String skdVoyNo = null;
	private String skdDirCd = null;
	private String polCd = null;
	private String podCd = null;
	private String bkgOfcCd = null;
	private String docUsrId = null;
	private String bkgStsCd = null;
	private String bkgCustTpCd = null;
	private String custCntCd = null;
	private String custSeq = null;
	private String custNm = null;
	private String oblIssOfcCd = null;
	private String oblIssUsrId = null;
	private String obSlsOfcCd = null;
	private String obSrepCd = null;
	private String bkgNo = null;
	private String blNo = null;
	private String blObrdDtFrom = null;
	private String blObrdDtTo = null;
	private String oblIssDtFrom = null;
	private String oblIssDtTo = null;
	private String faxProcStsCd = null;
	private String emlProcStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ObDblWblInVO() {}

	public ObDblWblInVO(String blTpCd, String vslCd, String skdVoyNo, String skdDirCd, String polCd, String podCd, String bkgOfcCd, String docUsrId, String bkgStsCd, String bkgCustTpCd, String custCntCd, String custSeq, String custNm, String oblIssOfcCd, String oblIssUsrId, String obSlsOfcCd, String obSrepCd, String bkgNo, String blNo, String blObrdDtFrom, String blObrdDtTo, String oblIssDtFrom, String oblIssDtTo, String faxProcStsCd, String emlProcStsCd) {
		this.blTpCd = blTpCd;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.polCd = polCd;
		this.podCd = podCd;
		this.bkgOfcCd = bkgOfcCd;
		this.docUsrId = docUsrId;
		this.bkgStsCd = bkgStsCd;
		this.bkgCustTpCd = bkgCustTpCd;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.custNm = custNm;
		this.oblIssOfcCd = oblIssOfcCd;
		this.oblIssUsrId = oblIssUsrId;
		this.obSlsOfcCd = obSlsOfcCd;
		this.obSrepCd = obSrepCd;
		this.bkgNo = bkgNo;
		this.blNo = blNo;
		this.blObrdDtFrom = blObrdDtFrom;
		this.blObrdDtTo = blObrdDtTo;
		this.oblIssDtFrom = oblIssDtFrom;
		this.oblIssDtTo = oblIssDtTo;
		this.faxProcStsCd = faxProcStsCd;
		this.emlProcStsCd = emlProcStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bkg_cust_tp_cd", getBkgCustTpCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());
		this.hashColumns.put("obl_iss_usr_id", getOblIssUsrId());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_obrd_dt_from", getBlObrdDtFrom());
		this.hashColumns.put("bl_obrd_dt_to", getBlObrdDtTo());
		this.hashColumns.put("obl_iss_dt_from", getOblIssDtFrom());
		this.hashColumns.put("obl_iss_dt_to", getOblIssDtTo());
		this.hashColumns.put("fax_proc_sts_cd", getFaxProcStsCd());
		this.hashColumns.put("eml_proc_sts_cd", getEmlProcStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bkg_cust_tp_cd", "bkgCustTpCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("obl_iss_usr_id", "oblIssUsrId");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_obrd_dt_from", "blObrdDtFrom");
		this.hashFields.put("bl_obrd_dt_to", "blObrdDtTo");
		this.hashFields.put("obl_iss_dt_from", "oblIssDtFrom");
		this.hashFields.put("obl_iss_dt_to", "oblIssDtTo");
		this.hashFields.put("fax_proc_sts_cd", "faxProcStsCd");
		this.hashFields.put("eml_proc_sts_cd", "emlProcStsCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}

	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}

	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
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
	 * @return bkgCustTpCd
	 */
	public String getBkgCustTpCd() {
		return this.bkgCustTpCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
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
	 * @return oblIssOfcCd
	 */
	public String getOblIssOfcCd() {
		return this.oblIssOfcCd;
	}

	/**
	 * Column Info
	 * @return oblIssUsrId
	 */
	public String getOblIssUsrId() {
		return this.oblIssUsrId;
	}

	/**
	 * Column Info
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}

	/**
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}

	/**
	 * Column Info
	 * @return blObrdDtFrom
	 */
	public String getBlObrdDtFrom() {
		return this.blObrdDtFrom;
	}

	/**
	 * Column Info
	 * @return blObrdDtTo
	 */
	public String getBlObrdDtTo() {
		return this.blObrdDtTo;
	}

	/**
	 * Column Info
	 * @return oblIssDtFrom
	 */
	public String getOblIssDtFrom() {
		return this.oblIssDtFrom;
	}

	/**
	 * Column Info
	 * @return oblIssDtTo
	 */
	public String getOblIssDtTo() {
		return this.oblIssDtTo;
	}

	/**
	 * Column Info
	 * @return faxProcStsCd
	 */
	public String getFaxProcStsCd() {
		return this.faxProcStsCd;
	}

	/**
	 * Column Info
	 * @return emlProcStsCd
	 */
	public String getEmlProcStsCd() {
		return this.emlProcStsCd;
	}

	/**
	 * Column Info
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}

	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}

	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
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
	 * @param bkgCustTpCd
	 */
	public void setBkgCustTpCd(String bkgCustTpCd) {
		this.bkgCustTpCd = bkgCustTpCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
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
	 * @param oblIssOfcCd
	 */
	public void setOblIssOfcCd(String oblIssOfcCd) {
		this.oblIssOfcCd = oblIssOfcCd;
	}

	/**
	 * Column Info
	 * @param oblIssUsrId
	 */
	public void setOblIssUsrId(String oblIssUsrId) {
		this.oblIssUsrId = oblIssUsrId;
	}

	/**
	 * Column Info
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}

	/**
	 * Column Info
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	/**
	 * Column Info
	 * @param blObrdDtFrom
	 */
	public void setBlObrdDtFrom(String blObrdDtFrom) {
		this.blObrdDtFrom = blObrdDtFrom;
	}

	/**
	 * Column Info
	 * @param blObrdDtTo
	 */
	public void setBlObrdDtTo(String blObrdDtTo) {
		this.blObrdDtTo = blObrdDtTo;
	}

	/**
	 * Column Info
	 * @param oblIssDtFrom
	 */
	public void setOblIssDtFrom(String oblIssDtFrom) {
		this.oblIssDtFrom = oblIssDtFrom;
	}

	/**
	 * Column Info
	 * @param oblIssDtTo
	 */
	public void setOblIssDtTo(String oblIssDtTo) {
		this.oblIssDtTo = oblIssDtTo;
	}

	/**
	 * Column Info
	 * @param faxProcStsCd
	 */
	public void setFaxProcStsCd(String faxProcStsCd) {
		this.faxProcStsCd = faxProcStsCd;
	}

	/**
	 * Column Info
	 * @param emlProcStsCd
	 */
	public void setEmlProcStsCd(String emlProcStsCd) {
		this.emlProcStsCd = emlProcStsCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setDocUsrId(JSPUtil.getParameter(request, "doc_usr_id", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setBkgCustTpCd(JSPUtil.getParameter(request, "bkg_cust_tp_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request, "obl_iss_ofc_cd", ""));
		setOblIssUsrId(JSPUtil.getParameter(request, "obl_iss_usr_id", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, "ob_sls_ofc_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request, "ob_srep_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setBlObrdDtFrom(JSPUtil.getParameter(request, "bl_obrd_dt_from", ""));
		setBlObrdDtTo(JSPUtil.getParameter(request, "bl_obrd_dt_to", ""));
		setOblIssDtFrom(JSPUtil.getParameter(request, "obl_iss_dt_from", ""));
		setOblIssDtTo(JSPUtil.getParameter(request, "obl_iss_dt_to", ""));
		setFaxProcStsCd(JSPUtil.getParameter(request, "fax_proc_sts_cd", ""));
		setEmlProcStsCd(JSPUtil.getParameter(request, "eml_proc_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ObDblWblInVO[]
	 */
	public ObDblWblInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ObDblWblInVO[]
	 */
	public ObDblWblInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ObDblWblInVO model = null;

		String[] tmp = request.getParameterValues(prefix + "bl_tp_cd");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "bl_tp_cd").length;

		try {
			String[] blTpCd = (JSPUtil.getParameter(request, prefix + "bl_tp_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix + "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix + "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix + "skd_dir_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix + "pol_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix + "pod_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix + "doc_usr_id", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix + "bkg_sts_cd", length));
			String[] bkgCustTpCd = (JSPUtil.getParameter(request, prefix + "bkg_cust_tp_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix + "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix + "cust_seq", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix + "cust_nm", length));
			String[] oblIssOfcCd = (JSPUtil.getParameter(request, prefix + "obl_iss_ofc_cd", length));
			String[] oblIssUsrId = (JSPUtil.getParameter(request, prefix + "obl_iss_usr_id", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix + "ob_srep_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix + "bkg_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix + "bl_no", length));
			String[] blObrdDtFrom = (JSPUtil.getParameter(request, prefix + "bl_obrd_dt_from", length));
			String[] blObrdDtTo = (JSPUtil.getParameter(request, prefix + "bl_obrd_dt_to", length));
			String[] oblIssDtFrom = (JSPUtil.getParameter(request, prefix + "obl_iss_dt_from", length));
			String[] oblIssDtTo = (JSPUtil.getParameter(request, prefix + "obl_iss_dt_to", length));
			String[] faxProcStsCd = (JSPUtil.getParameter(request, prefix + "fax_proc_sts_cd", length));
			String[] emlProcStsCd = (JSPUtil.getParameter(request, prefix + "eml_proc_sts_cd", length));
			for (int i = 0; i < length; i++) {
				model = new ObDblWblInVO();
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bkgCustTpCd[i] != null)
					model.setBkgCustTpCd(bkgCustTpCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (oblIssOfcCd[i] != null)
					model.setOblIssOfcCd(oblIssOfcCd[i]);
				if (oblIssUsrId[i] != null)
					model.setOblIssUsrId(oblIssUsrId[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blObrdDtFrom[i] != null)
					model.setBlObrdDtFrom(blObrdDtFrom[i]);
				if (blObrdDtTo[i] != null)
					model.setBlObrdDtTo(blObrdDtTo[i]);
				if (oblIssDtFrom[i] != null)
					model.setOblIssDtFrom(oblIssDtFrom[i]);
				if (oblIssDtTo[i] != null)
					model.setOblIssDtTo(oblIssDtTo[i]);
				if (faxProcStsCd[i] != null)
					model.setFaxProcStsCd(faxProcStsCd[i]);
				if (emlProcStsCd[i] != null)
					model.setEmlProcStsCd(emlProcStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getObDblWblInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ObDblWblInVO[]
	 */
	public ObDblWblInVO[] getObDblWblInVOs(){
		ObDblWblInVO[] vos = (ObDblWblInVO[])models.toArray(new ObDblWblInVO[models.size()]);
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
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpCd = this.bkgCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd = this.oblIssOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssUsrId = this.oblIssUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtFrom = this.blObrdDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blObrdDtTo = this.blObrdDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDtFrom = this.oblIssDtFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssDtTo = this.oblIssDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxProcStsCd = this.faxProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlProcStsCd = this.emlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
