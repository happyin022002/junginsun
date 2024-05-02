/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OtsInquiryParm2VO.java
*@FileTitle : OtsInquiryParm2VO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.02
*@LastModifier : 김기태
*@LastVersion : 1.0
* 2016.06.02 김기태 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
 * @author 김기태
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class OtsInquiryParm2VO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<OtsInquiryParm2VO> models = new ArrayList<OtsInquiryParm2VO>();
	
	/* Column Info */
	private String cutp = null;
	/* Column Info */
	private String chkSrepFlg2 = null;
	/* Column Info */
	private String ctof = null;
	/* Column Info */
	private String isof = null;
	/* Column Info */
	private String arif = null;
	/* Column Info */
	private String payc2 = null;
	/* Column Info */
	private String taano = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cuno2 = null;
	/* Column Info */
	private String tftp = null;
	/* Column Info */
	private String prgExInCd2 = null;
	/* Column Info */
	private String todt2 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frdt2 = null;
	/* Column Info */
	private String hRhqOff = null;
	/* Column Info */
	private String chkUsd = null;
	/* Column Info */
	private String payn2 = null;
	/* Column Info */
	private String cude2 = null;
	/* Column Info */
	private String obSrepCd2 = null;
	/* Column Info */
	private String rfan2 = null;
	/* Column Info */
	private String scno2 = null;
	/* Column Info */
	private String coll = null;
	/* Column Info */
	private String chkCtrtOfc = null;
	/* Column Info */
	private String chkCtrtCust = null;
	/* Column Info */
	private String chkCtrtNo = null;
	/* Column Info */
	private String chkPayrInfo = null;
	/* Column Info */
	private String ctrtCust = null;
	/* Column Info */
	private String gropCust = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public OtsInquiryParm2VO() {}

	public OtsInquiryParm2VO(String ibflag, String pagerows, String cuno2, String cutp, String frdt2, String todt2, String tftp, String arif, String cude2, String scno2, String rfan2, String taano, String chkUsd, String prgExInCd2, String obSrepCd2, String payc2, String payn2, String ctof, String isof, String chkSrepFlg2, String hRhqOff, String coll, String chkCtrtOfc, String chkCtrtCust, String chkCtrtNo, String chkPayrInfo, String ctrtCust, String gropCust) {
		this.cutp = cutp;
		this.chkSrepFlg2 = chkSrepFlg2;
		this.ctof = ctof;
		this.isof = isof;
		this.arif = arif;
		this.payc2 = payc2;
		this.taano = taano;
		this.pagerows = pagerows;
		this.cuno2 = cuno2;
		this.tftp = tftp;
		this.prgExInCd2 = prgExInCd2;
		this.todt2 = todt2;
		this.ibflag = ibflag;
		this.frdt2 = frdt2;
		this.hRhqOff = hRhqOff;
		this.chkUsd = chkUsd;
		this.payn2 = payn2;
		this.cude2 = cude2;
		this.obSrepCd2 = obSrepCd2;
		this.rfan2 = rfan2;
		this.scno2 = scno2;
		this.coll = coll;
		this.chkCtrtOfc = chkCtrtOfc;
		this.chkCtrtCust = chkCtrtCust;
		this.chkCtrtNo = chkCtrtNo;
		this.chkPayrInfo = chkPayrInfo;
		this.ctrtCust = ctrtCust;
		this.gropCust = gropCust;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cutp", getCutp());
		this.hashColumns.put("chk_srep_flg2", getChkSrepFlg2());
		this.hashColumns.put("ctof", getCtof());
		this.hashColumns.put("isof", getIsof());
		this.hashColumns.put("arif", getArif());
		this.hashColumns.put("payc2", getPayc2());
		this.hashColumns.put("taano", getTaano());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cuno2", getCuno2());
		this.hashColumns.put("tftp", getTftp());
		this.hashColumns.put("prg_ex_in_cd2", getPrgExInCd2());
		this.hashColumns.put("todt2", getTodt2());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frdt2", getFrdt2());
		this.hashColumns.put("h_rhq_off", getHRhqOff());
		this.hashColumns.put("chk_usd", getChkUsd());
		this.hashColumns.put("payn2", getPayn2());
		this.hashColumns.put("cude2", getCude2());
		this.hashColumns.put("ob_srep_cd2", getObSrepCd2());
		this.hashColumns.put("rfan2", getRfan2());
		this.hashColumns.put("scno2", getScno2());
		this.hashColumns.put("coll", getColl());
		this.hashColumns.put("chk_ctrt_ofc", getChkCtrtOfc());
		this.hashColumns.put("chk_ctrt_cust", getChkCtrtCust());
		this.hashColumns.put("chk_ctrt_no", getChkCtrtNo());
		this.hashColumns.put("chk_payr_info", getChkPayrInfo());
		this.hashColumns.put("ctrt_cust", getCtrtCust());
		this.hashColumns.put("grop_cust", getGropCust());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cutp", "cutp");
		this.hashFields.put("chk_srep_flg2", "chkSrepFlg2");
		this.hashFields.put("ctof", "ctof");
		this.hashFields.put("isof", "isof");
		this.hashFields.put("arif", "arif");
		this.hashFields.put("payc2", "payc2");
		this.hashFields.put("taano", "taano");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cuno2", "cuno2");
		this.hashFields.put("tftp", "tftp");
		this.hashFields.put("prg_ex_in_cd2", "prgExInCd2");
		this.hashFields.put("todt2", "todt2");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frdt2", "frdt2");
		this.hashFields.put("h_rhq_off", "hRhqOff");
		this.hashFields.put("chk_usd", "chkUsd");
		this.hashFields.put("payn2", "payn2");
		this.hashFields.put("cude2", "cude2");
		this.hashFields.put("ob_srep_cd2", "obSrepCd2");
		this.hashFields.put("rfan2", "rfan2");
		this.hashFields.put("scno2", "scno2");
		this.hashFields.put("coll", "coll");
		this.hashFields.put("chk_ctrt_ofc", "chkCtrtOfc");
		this.hashFields.put("chk_ctrt_cust", "chkCtrtCust");
		this.hashFields.put("chk_ctrt_no", "chkCtrtNo");
		this.hashFields.put("chk_payr_info", "chkPayrInfo");
		this.hashFields.put("ctrt_cust", "ctrtCust");
		this.hashFields.put("grop_cust", "gropCust");
		return this.hashFields;
	}
	
	public String getIsof() {
		return isof;
	}

	public void setIsof(String isof) {
		this.isof = isof;
	}		
	
	public String getColl() {
		return coll;
	}

	public void setColl(String coll) {
		this.coll = coll;
	}

	/**
	 * Column Info
	 * @return cutp
	 */
	public String getCutp() {
		return this.cutp;
	}
	
	/**
	 * Column Info
	 * @return chkSrepFlg2
	 */
	public String getChkSrepFlg2() {
		return this.chkSrepFlg2;
	}
	
	/**
	 * Column Info
	 * @return ctof
	 */
	public String getCtof() {
		return this.ctof;
	}
	
	/**
	 * Column Info
	 * @return arif
	 */
	public String getArif() {
		return this.arif;
	}
	
	/**
	 * Column Info
	 * @return payc2
	 */
	public String getPayc2() {
		return this.payc2;
	}
	
	/**
	 * Column Info
	 * @return taano
	 */
	public String getTaano() {
		return this.taano;
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
	 * @return cuno2
	 */
	public String getCuno2() {
		return this.cuno2;
	}
	
	/**
	 * Column Info
	 * @return tftp
	 */
	public String getTftp() {
		return this.tftp;
	}
	
	/**
	 * Column Info
	 * @return prgExInCd2
	 */
	public String getPrgExInCd2() {
		return this.prgExInCd2;
	}
	
	/**
	 * Column Info
	 * @return todt2
	 */
	public String getTodt2() {
		return this.todt2;
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
	 * @return frdt2
	 */
	public String getFrdt2() {
		return this.frdt2;
	}
	
	/**
	 * Column Info
	 * @return hRhqOff
	 */
	public String getHRhqOff() {
		return this.hRhqOff;
	}
	
	/**
	 * Column Info
	 * @return chkUsd
	 */
	public String getChkUsd() {
		return this.chkUsd;
	}
	
	/**
	 * Column Info
	 * @return payn2
	 */
	public String getPayn2() {
		return this.payn2;
	}
	
	/**
	 * Column Info
	 * @return cude2
	 */
	public String getCude2() {
		return this.cude2;
	}
	
	/**
	 * Column Info
	 * @return obSrepCd2
	 */
	public String getObSrepCd2() {
		return this.obSrepCd2;
	}
	
	/**
	 * Column Info
	 * @return rfan2
	 */
	public String getRfan2() {
		return this.rfan2;
	}
	
	/**
	 * Column Info
	 * @return scno2
	 */
	public String getScno2() {
		return this.scno2;
	}
	

	/**
	 * Column Info
	 * @param cutp
	 */
	public void setCutp(String cutp) {
		this.cutp = cutp;
	}
	
	/**
	 * Column Info
	 * @param chkSrepFlg2
	 */
	public void setChkSrepFlg2(String chkSrepFlg2) {
		this.chkSrepFlg2 = chkSrepFlg2;
	}
	
	/**
	 * Column Info
	 * @param ctof
	 */
	public void setCtof(String ctof) {
		this.ctof = ctof;
	}
	
	/**
	 * Column Info
	 * @param arif
	 */
	public void setArif(String arif) {
		this.arif = arif;
	}
	
	/**
	 * Column Info
	 * @param payc2
	 */
	public void setPayc2(String payc2) {
		this.payc2 = payc2;
	}
	
	/**
	 * Column Info
	 * @param taano
	 */
	public void setTaano(String taano) {
		this.taano = taano;
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
	 * @param cuno2
	 */
	public void setCuno2(String cuno2) {
		this.cuno2 = cuno2;
	}
	
	/**
	 * Column Info
	 * @param tftp
	 */
	public void setTftp(String tftp) {
		this.tftp = tftp;
	}
	
	/**
	 * Column Info
	 * @param prgExInCd2
	 */
	public void setPrgExInCd2(String prgExInCd2) {
		this.prgExInCd2 = prgExInCd2;
	}
	
	/**
	 * Column Info
	 * @param todt2
	 */
	public void setTodt2(String todt2) {
		this.todt2 = todt2;
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
	 * @param frdt2
	 */
	public void setFrdt2(String frdt2) {
		this.frdt2 = frdt2;
	}
	
	/**
	 * Column Info
	 * @param hRhqOff
	 */
	public void setHRhqOff(String hRhqOff) {
		this.hRhqOff = hRhqOff;
	}
	
	/**
	 * Column Info
	 * @param chkUsd
	 */
	public void setChkUsd(String chkUsd) {
		this.chkUsd = chkUsd;
	}
	
	/**
	 * Column Info
	 * @param payn2
	 */
	public void setPayn2(String payn2) {
		this.payn2 = payn2;
	}
	
	/**
	 * Column Info
	 * @param cude2
	 */
	public void setCude2(String cude2) {
		this.cude2 = cude2;
	}
	
	/**
	 * Column Info
	 * @param obSrepCd2
	 */
	public void setObSrepCd2(String obSrepCd2) {
		this.obSrepCd2 = obSrepCd2;
	}
	
	/**
	 * Column Info
	 * @param rfan2
	 */
	public void setRfan2(String rfan2) {
		this.rfan2 = rfan2;
	}
	
	/**
	 * Column Info
	 * @param scno2
	 */
	public void setScno2(String scno2) {
		this.scno2 = scno2;
	}
	
	public String getChkCtrtOfc() {
		return chkCtrtOfc;
	}

	public void setChkCtrtOfc(String chkCtrtOfc) {
		this.chkCtrtOfc = chkCtrtOfc;
	}

	public String getChkCtrtCust() {
		return chkCtrtCust;
	}

	public void setChkCtrtCust(String chkCtrtCust) {
		this.chkCtrtCust = chkCtrtCust;
	}

	public String getChkCtrtNo() {
		return chkCtrtNo;
	}

	public void setChkCtrtNo(String chkCtrtNo) {
		this.chkCtrtNo = chkCtrtNo;
	}

	public String getChkPayrInfo() {
		return chkPayrInfo;
	}

	public void setChkPayrInfo(String chkPayrInfo) {
		this.chkPayrInfo = chkPayrInfo;
	}

	public String getCtrtCust() {
		return ctrtCust;
	}

	public void setCtrtCust(String ctrtCust) {
		this.ctrtCust = ctrtCust;
	}

	public String getGropCust() {
		return gropCust;
	}

	public void setGropCust(String gropCust) {
		this.gropCust = gropCust;
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
		setCutp(JSPUtil.getParameter(request, prefix + "cutp", ""));
		setChkSrepFlg2(JSPUtil.getParameter(request, prefix + "chk_srep_flg2", ""));
		setCtof(JSPUtil.getParameter(request, prefix + "ctof", ""));
		setIsof(JSPUtil.getParameter(request, prefix + "isof", ""));
		setArif(JSPUtil.getParameter(request, prefix + "arif", ""));
		setPayc2(JSPUtil.getParameter(request, prefix + "payc2", ""));
		setTaano(JSPUtil.getParameter(request, prefix + "taano", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCuno2(JSPUtil.getParameter(request, prefix + "cuno2", ""));
		setTftp(JSPUtil.getParameter(request, prefix + "tftp", ""));
		setPrgExInCd2(JSPUtil.getParameter(request, prefix + "prg_ex_in_cd2", ""));
		setTodt2(JSPUtil.getParameter(request, prefix + "todt2", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrdt2(JSPUtil.getParameter(request, prefix + "frdt2", ""));
		setHRhqOff(JSPUtil.getParameter(request, prefix + "h_rhq_off", ""));
		setChkUsd(JSPUtil.getParameter(request, prefix + "chk_usd", ""));
		setPayn2(JSPUtil.getParameter(request, prefix + "payn2", ""));
		setCude2(JSPUtil.getParameter(request, prefix + "cude2", ""));
		setObSrepCd2(JSPUtil.getParameter(request, prefix + "ob_srep_cd2", ""));
		setRfan2(JSPUtil.getParameter(request, prefix + "rfan2", ""));
		setScno2(JSPUtil.getParameter(request, prefix + "scno2", ""));
		setColl(JSPUtil.getParameter(request, prefix + "coll", ""));
		setChkCtrtOfc(JSPUtil.getParameter(request, prefix + "chk_ctrt_ofc", ""));
		setChkCtrtCust(JSPUtil.getParameter(request, prefix + "chk_ctrt_cust", ""));
		setChkCtrtNo(JSPUtil.getParameter(request, prefix + "chk_ctrt_no", ""));
		setChkPayrInfo(JSPUtil.getParameter(request, prefix + "chk_payr_info", ""));
		setCtrtCust(JSPUtil.getParameter(request, prefix + "ctrt_cust", ""));
		setGropCust(JSPUtil.getParameter(request, prefix + "grop_cust", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OtsInquiryParm2VO[]
	 */
	public OtsInquiryParm2VO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return OtsInquiryParm2VO[]
	 */
	public OtsInquiryParm2VO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		OtsInquiryParm2VO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cutp = (JSPUtil.getParameter(request, prefix	+ "cutp", length));
			String[] chkSrepFlg2 = (JSPUtil.getParameter(request, prefix	+ "chk_srep_flg2", length));
			String[] ctof = (JSPUtil.getParameter(request, prefix	+ "ctof", length));
			String[] isof = (JSPUtil.getParameter(request, prefix	+ "isof", length));
			String[] arif = (JSPUtil.getParameter(request, prefix	+ "arif", length));
			String[] payc2 = (JSPUtil.getParameter(request, prefix	+ "payc2", length));
			String[] taano = (JSPUtil.getParameter(request, prefix	+ "taano", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cuno2 = (JSPUtil.getParameter(request, prefix	+ "cuno2", length));
			String[] tftp = (JSPUtil.getParameter(request, prefix	+ "tftp", length));
			String[] prgExInCd2 = (JSPUtil.getParameter(request, prefix	+ "prg_ex_in_cd2", length));
			String[] todt2 = (JSPUtil.getParameter(request, prefix	+ "todt2", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frdt2 = (JSPUtil.getParameter(request, prefix	+ "frdt2", length));
			String[] hRhqOff = (JSPUtil.getParameter(request, prefix	+ "h_rhq_off", length));
			String[] chkUsd = (JSPUtil.getParameter(request, prefix	+ "chk_usd", length));
			String[] payn2 = (JSPUtil.getParameter(request, prefix	+ "payn2", length));
			String[] cude2 = (JSPUtil.getParameter(request, prefix	+ "cude2", length));
			String[] obSrepCd2 = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd2", length));
			String[] rfan2 = (JSPUtil.getParameter(request, prefix	+ "rfan2", length));
			String[] scno2 = (JSPUtil.getParameter(request, prefix	+ "scno2", length));
			String[] coll = (JSPUtil.getParameter(request, prefix	+ "coll", length));
			String[] chkCtrtOfc = (JSPUtil.getParameter(request, prefix	+ "chk_ctrt_ofc", length));
			String[] chkCtrtCust = (JSPUtil.getParameter(request, prefix	+ "chk_ctrt_cust", length));
			String[] chkCtrtNo = (JSPUtil.getParameter(request, prefix	+ "chk_ctrt_no", length));
			String[] chkPayrInfo = (JSPUtil.getParameter(request, prefix	+ "chk_payr_info", length));
			String[] ctrtCust = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust", length));
			String[] gropCust = (JSPUtil.getParameter(request, prefix	+ "grop_cust", length));
			
			for (int i = 0; i < length; i++) {
				model = new OtsInquiryParm2VO();
				if (cutp[i] != null)
					model.setCutp(cutp[i]);
				if (chkSrepFlg2[i] != null)
					model.setChkSrepFlg2(chkSrepFlg2[i]);
				if (ctof[i] != null)
					model.setCtof(ctof[i]);
				if (isof[i] != null)
					model.setIsof(isof[i]);
				if (arif[i] != null)
					model.setArif(arif[i]);
				if (payc2[i] != null)
					model.setPayc2(payc2[i]);
				if (taano[i] != null)
					model.setTaano(taano[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cuno2[i] != null)
					model.setCuno2(cuno2[i]);
				if (tftp[i] != null)
					model.setTftp(tftp[i]);
				if (prgExInCd2[i] != null)
					model.setPrgExInCd2(prgExInCd2[i]);
				if (todt2[i] != null)
					model.setTodt2(todt2[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frdt2[i] != null)
					model.setFrdt2(frdt2[i]);
				if (hRhqOff[i] != null)
					model.setHRhqOff(hRhqOff[i]);
				if (chkUsd[i] != null)
					model.setChkUsd(chkUsd[i]);
				if (payn2[i] != null)
					model.setPayn2(payn2[i]);
				if (cude2[i] != null)
					model.setCude2(cude2[i]);
				if (obSrepCd2[i] != null)
					model.setObSrepCd2(obSrepCd2[i]);
				if (rfan2[i] != null)
					model.setRfan2(rfan2[i]);
				if (scno2[i] != null)
					model.setScno2(scno2[i]);
				if (coll[i] != null)
					model.setColl(coll[i]);
				if (chkCtrtOfc[i] != null)
					model.setChkCtrtOfc(chkCtrtOfc[i]);
				if (chkCtrtCust[i] != null)
					model.setChkCtrtCust(chkCtrtCust[i]);
				if (chkCtrtNo[i] != null)
					model.setChkCtrtNo(chkCtrtNo[i]);
				if (chkPayrInfo[i] != null)
					model.setChkPayrInfo(chkPayrInfo[i]);
				if (ctrtCust[i] != null)
					model.setCtrtCust(ctrtCust[i]);
				if (gropCust[i] != null)
					model.setGropCust(gropCust[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getOtsInquiryParm2VOs();
	}

	/**
	 * VO 배열을 반환
	 * @return OtsInquiryParm2VO[]
	 */
	public OtsInquiryParm2VO[] getOtsInquiryParm2VOs(){
		OtsInquiryParm2VO[] vos = (OtsInquiryParm2VO[])models.toArray(new OtsInquiryParm2VO[models.size()]);
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
		this.cutp = this.cutp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkSrepFlg2 = this.chkSrepFlg2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctof = this.ctof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isof = this.isof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arif = this.arif .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payc2 = this.payc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taano = this.taano .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cuno2 = this.cuno2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tftp = this.tftp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prgExInCd2 = this.prgExInCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.todt2 = this.todt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frdt2 = this.frdt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hRhqOff = this.hRhqOff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkUsd = this.chkUsd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payn2 = this.payn2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cude2 = this.cude2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd2 = this.obSrepCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfan2 = this.rfan2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scno2 = this.scno2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coll = this.coll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCtrtOfc = this.chkCtrtOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCtrtCust = this.chkCtrtCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkCtrtNo = this.chkCtrtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkPayrInfo = this.chkPayrInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCust = this.ctrtCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gropCust = this.gropCust .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
