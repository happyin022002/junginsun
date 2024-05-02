/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AfterBkgRqstAproStsParamVO.java
*@FileTitle : AfterBkgRqstAproStsParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.03
*@LastModifier : KIM KI TAE
*@LastVersion : 1.0
* 2016.03.03 KIM KI TAE 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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
 * @author KIM KI TAE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AfterBkgRqstAproStsParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBkgRqstAproStsParamVO> models = new ArrayList<AfterBkgRqstAproStsParamVO>();
	
	/* Column Info */
	private String rqstStsCd = null;
	/* Column Info */
	private String tabCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String ofcTp = null;
	/* Column Info */
	private String trfCd = null;
	/* Column Info */
	private String dtTp = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String groupBy = null;
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AfterBkgRqstAproStsParamVO() {}

	public AfterBkgRqstAproStsParamVO(String rqstStsCd, String tabCd, String ibflag, String ofcCd, String ofcTp, String trfCd, String dtTp, String fmDt, String toDt, String darNo, String apvlNo, String bkgNo, String blNo, String scNo, String rfaNo, String taaNo, String custCd, String custNm, String groupBy) {
		this.rqstStsCd = rqstStsCd;
		this.tabCd = tabCd;
		this.ibflag = ibflag;
		this.ofcCd = ofcCd;
		this.ofcTp = ofcTp;
		this.trfCd = trfCd;
		this.dtTp = dtTp;
		this.fmDt = fmDt;
		this.toDt = toDt;
		this.darNo = darNo;
		this.apvlNo = apvlNo;
		this.bkgNo = bkgNo;
		this.blNo = blNo;
		this.scNo = scNo;
		this.rfaNo = rfaNo;
		this.taaNo = taaNo;
		this.custCd = custCd;
		this.custNm = custNm;
		this.groupBy = groupBy;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_sts_cd", getRqstStsCd());
		this.hashColumns.put("tab_cd", getTabCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ofc_tp", getOfcTp());
		this.hashColumns.put("trf_cd", getTrfCd());
		this.hashColumns.put("dt_tp", getDtTp());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("group_by", getGroupBy());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_sts_cd", "rqstStsCd");
		this.hashFields.put("tab_cd", "tabCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ofc_tp", "ofcTp");
		this.hashFields.put("trf_cd", "trfCd");
		this.hashFields.put("dt_tp", "dtTp");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("group_by", "groupBy");
		
		return this.hashFields;
	}
	
	
	
	public String getOfcTp() {
		return ofcTp;
	}

	public void setOfcTp(String ofcTp) {
		this.ofcTp = ofcTp;
	}

	public String getScNo() {
		return scNo;
	}

	public void setScNo(String scNo) {
		this.scNo = scNo;
	}

	public String getRfaNo() {
		return rfaNo;
	}

	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}

	public String getTaaNo() {
		return taaNo;
	}

	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	public String getCustNm() {
		return custNm;
	}
	
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getRqstStsCd() {
		return rqstStsCd;
	}

	public void setRqstStsCd(String rqstStsCd) {
		this.rqstStsCd = rqstStsCd;
	}

	public String getTabCd() {
		return tabCd;
	}

	public void setTabCd(String tabCd) {
		this.tabCd = tabCd;
	}

	public String getIbflag() {
		return ibflag;
	}

	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	public String getOfcCd() {
		return ofcCd;
	}

	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}

	public String getTrfCd() {
		return trfCd;
	}

	public void setTrfCd(String trfCd) {
		this.trfCd = trfCd;
	}

	public String getDtTp() {
		return dtTp;
	}

	public void setDtTp(String dtTp) {
		this.dtTp = dtTp;
	}

	public String getFmDt() {
		return fmDt;
	}

	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
	}

	public String getToDt() {
		return toDt;
	}

	public void setToDt(String toDt) {
		this.toDt = toDt;
	}

	public String getDarNo() {
		return darNo;
	}

	public void setDarNo(String darNo) {
		this.darNo = darNo;
	}

	public String getApvlNo() {
		return apvlNo;
	}

	public void setApvlNo(String apvlNo) {
		this.apvlNo = apvlNo;
	}

	public String getBkgNo() {
		return bkgNo;
	}

	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}

	public String getBlNo() {
		return blNo;
	}

	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}

	public String getGroupBy() {
		return groupBy;
	}

	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
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
		setApvlNo(JSPUtil.getParameter(request, prefix + "apvl_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setDarNo(JSPUtil.getParameter(request, prefix + "dar_no", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setDtTp(JSPUtil.getParameter(request, prefix + "dt_tp", ""));
		setFmDt(JSPUtil.getParameter(request, prefix + "fm_dt", ""));
		setGroupBy(JSPUtil.getParameter(request, prefix + "group_by", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setOfcTp(JSPUtil.getParameter(request, prefix + "ofc_tp", ""));
		setRqstStsCd(JSPUtil.getParameter(request, prefix + "rqst_sts_cd", ""));
		setTabCd(JSPUtil.getParameter(request, prefix + "tab_cd", ""));
		setToDt(JSPUtil.getParameter(request, prefix + "to_dt", ""));
		setTrfCd(JSPUtil.getParameter(request, prefix + "trf_cd", ""));		
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));		
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BasicTariffInfoParamVO[]
	 */
	public AfterBkgRqstAproStsParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BasicTariffInfoParamVO[]
	 */
	public AfterBkgRqstAproStsParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBkgRqstAproStsParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstStsCd = (JSPUtil.getParameter(request, prefix	+ "rqst_sts_cd", length));
			String[] tabCd = (JSPUtil.getParameter(request, prefix	+ "tab_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ofcTp = (JSPUtil.getParameter(request, prefix	+ "ofc_tp", length));
			String[] trfCd = (JSPUtil.getParameter(request, prefix	+ "trf_cd", length));
			String[] dtTp = (JSPUtil.getParameter(request, prefix	+ "dt_tp", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] custNm= (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] groupBy = (JSPUtil.getParameter(request, prefix	+ "group_by", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBkgRqstAproStsParamVO();
				if (rqstStsCd[i] != null)
					model.setRqstStsCd(rqstStsCd[i]);
				if (tabCd[i] != null)
					model.setTabCd(tabCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ofcTp[i] != null)
					model.setOfcTp(ofcTp[i]);
				if (trfCd[i] != null)
					model.setTrfCd(trfCd[i]);
				if (dtTp[i] != null)
					model.setDtTp(dtTp[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (groupBy[i] != null)
					model.setGroupBy(groupBy[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBkgRqstAproStsParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBkgRqstAproStsParamVO[]
	 */
	public AfterBkgRqstAproStsParamVO[] getAfterBkgRqstAproStsParamVOs(){
		AfterBkgRqstAproStsParamVO[] vos = (AfterBkgRqstAproStsParamVO[])models.toArray(new AfterBkgRqstAproStsParamVO[models.size()]);
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
		this.rqstStsCd = this.rqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tabCd = this.tabCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTp = this.ofcTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCd = this.trfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtTp = this.dtTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.groupBy = this.groupBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
