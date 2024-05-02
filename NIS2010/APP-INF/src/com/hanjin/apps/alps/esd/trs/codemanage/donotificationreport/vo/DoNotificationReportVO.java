/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DoNotificationReportVO.java
*@FileTitle : DoNotificationReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.donotificationreport.vo;

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

public class DoNotificationReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoNotificationReportVO> models = new ArrayList<DoNotificationReportVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String dorNodNm = null;
	/* Column Info */
	private String ibVvdCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String result3 = null;
	/* Column Info */
	private String etaTime = null;
	/* Column Info */
	private String result4 = null;
	/* Column Info */
	private String result1 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String result2 = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String emlFax6 = null;
	/* Column Info */
	private String dorNodCd = null;
	/* Column Info */
	private String emlFax5 = null;
	/* Column Info */
	private String ntcSndDt = null;
	/* Column Info */
	private String emlFax7 = null;
	/* Column Info */
	private String result7 = null;
	/* Column Info */
	private String emlFax2 = null;
	/* Column Info */
	private String emlFax1 = null;
	/* Column Info */
	private String result5 = null;
	/* Column Info */
	private String emlFax4 = null;
	/* Column Info */
	private String result6 = null;
	/* Column Info */
	private String emlFax3 = null;
	/* Column Info */
	private String toYardCd = null;
	/* Column Info */
	private String dorYardCd = null;
	/* Column Info */
	private String fmYardCd = null;
	/* Column Info */
	private String trnkVvdCd = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String railEtaDt = null;
	/* Column Info */
	private String railEtaTime = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DoNotificationReportVO() {}

	public DoNotificationReportVO(String ibflag, String pagerows, String ctrlOfcCd, String ntcSndDt, String cntrNo, String cntrTpszCd, String fmNodCd, String fmYardCd, String toNodCd, String toYardCd, String dorNodCd, String dorYardCd, String dorNodNm, String bkgNo, String blNo, String scNo, String trnkVvdCd, String slanCd, String ibVvdCd, String etaDt, String etaTime, String custSeq, String custNm, String emlFax1, String emlFax2, String emlFax3, String emlFax4, String emlFax5, String emlFax6, String emlFax7, String result1, String result2, String result3, String result4, String result5, String result6, String result7, String railEtaDt, String railEtaTime) {
		this.toNodCd = toNodCd;
		this.dorNodNm = dorNodNm;
		this.ibVvdCd = ibVvdCd;
		this.custNm = custNm;
		this.etaDt = etaDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.result3 = result3;
		this.etaTime = etaTime;
		this.result4 = result4;
		this.result1 = result1;
		this.ibflag = ibflag;
		this.result2 = result2;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.emlFax6 = emlFax6;
		this.dorNodCd = dorNodCd;
		this.emlFax5 = emlFax5;
		this.ntcSndDt = ntcSndDt;
		this.emlFax7 = emlFax7;
		this.result7 = result7;
		this.emlFax2 = emlFax2;
		this.emlFax1 = emlFax1;
		this.result5 = result5;
		this.emlFax4 = emlFax4;
		this.result6 = result6;
		this.emlFax3 = emlFax3;
		this.toYardCd = toYardCd;
		this.dorYardCd = dorYardCd;
		this.fmYardCd = fmYardCd;
		this.trnkVvdCd = trnkVvdCd;
		this.ctrlOfcCd = ctrlOfcCd;
		this.custSeq = custSeq;
		this.fmNodCd = fmNodCd;
		this.bkgNo = bkgNo;
		this.slanCd = slanCd;
		this.cntrNo = cntrNo;
		this.etaDt = etaDt;
		this.railEtaTime = railEtaTime;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("dor_nod_nm", getDorNodNm());
		this.hashColumns.put("ib_vvd_cd", getIbVvdCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("result_3", getResult3());
		this.hashColumns.put("eta_time", getEtaTime());
		this.hashColumns.put("result_4", getResult4());
		this.hashColumns.put("result_1", getResult1());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("result_2", getResult2());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("eml_fax_6", getEmlFax6());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		this.hashColumns.put("eml_fax_5", getEmlFax5());
		this.hashColumns.put("ntc_snd_dt", getNtcSndDt());
		this.hashColumns.put("eml_fax_7", getEmlFax7());
		this.hashColumns.put("result_7", getResult7());
		this.hashColumns.put("eml_fax_2", getEmlFax2());
		this.hashColumns.put("eml_fax_1", getEmlFax1());
		this.hashColumns.put("result_5", getResult5());
		this.hashColumns.put("eml_fax_4", getEmlFax4());
		this.hashColumns.put("result_6", getResult6());
		this.hashColumns.put("eml_fax_3", getEmlFax3());
		this.hashColumns.put("to_yard_cd", getToYardCd());
		this.hashColumns.put("dor_yard_cd", getDorYardCd());
		this.hashColumns.put("fm_yard_cd", getFmYardCd());
		this.hashColumns.put("trnk_vvd_cd", getTrnkVvdCd());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("rail_eta_dt", getRailEtaDt());
		this.hashColumns.put("rail_eta_time", getRailEtaTime());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("dor_nod_nm", "dorNodNm");
		this.hashFields.put("ib_vvd_cd", "ibVvdCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("result_3", "result3");
		this.hashFields.put("eta_time", "etaTime");
		this.hashFields.put("result_4", "result4");
		this.hashFields.put("result_1", "result1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("result_2", "result2");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("eml_fax_6", "emlFax6");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		this.hashFields.put("eml_fax_5", "emlFax5");
		this.hashFields.put("ntc_snd_dt", "ntcSndDt");
		this.hashFields.put("eml_fax_7", "emlFax7");
		this.hashFields.put("result_7", "result7");
		this.hashFields.put("eml_fax_2", "emlFax2");
		this.hashFields.put("eml_fax_1", "emlFax1");
		this.hashFields.put("result_5", "result5");
		this.hashFields.put("eml_fax_4", "emlFax4");
		this.hashFields.put("result_6", "result6");
		this.hashFields.put("eml_fax_3", "emlFax3");
		this.hashFields.put("to_yard_cd", "toYardCd");
		this.hashFields.put("dor_yard_cd", "dorYardCd");
		this.hashFields.put("fm_yard_cd", "fmYardCd");
		this.hashFields.put("trnk_vvd_cd", "trnkVvdCd");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("rail_eta_dt", "railEtaDt");
		this.hashFields.put("rail_eta_time", "railEtaTime");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodNm
	 */
	public String getDorNodNm() {
		return this.dorNodNm;
	}
	
	/**
	 * Column Info
	 * @return ibVvdCd
	 */
	public String getIbVvdCd() {
		return this.ibVvdCd;
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
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
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
	 * @return result3
	 */
	public String getResult3() {
		return this.result3;
	}
	
	/**
	 * Column Info
	 * @return etaTime
	 */
	public String getEtaTime() {
		return this.etaTime;
	}
	
	/**
	 * Column Info
	 * @return result4
	 */
	public String getResult4() {
		return this.result4;
	}
	
	/**
	 * Column Info
	 * @return result1
	 */
	public String getResult1() {
		return this.result1;
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
	 * @return result2
	 */
	public String getResult2() {
		return this.result2;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return emlFax6
	 */
	public String getEmlFax6() {
		return this.emlFax6;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	
	/**
	 * Column Info
	 * @return emlFax5
	 */
	public String getEmlFax5() {
		return this.emlFax5;
	}
	
	/**
	 * Column Info
	 * @return ntcSndDt
	 */
	public String getNtcSndDt() {
		return this.ntcSndDt;
	}
	
	/**
	 * Column Info
	 * @return emlFax7
	 */
	public String getEmlFax7() {
		return this.emlFax7;
	}
	
	/**
	 * Column Info
	 * @return result7
	 */
	public String getResult7() {
		return this.result7;
	}
	
	/**
	 * Column Info
	 * @return emlFax2
	 */
	public String getEmlFax2() {
		return this.emlFax2;
	}
	
	/**
	 * Column Info
	 * @return emlFax1
	 */
	public String getEmlFax1() {
		return this.emlFax1;
	}
	
	/**
	 * Column Info
	 * @return result5
	 */
	public String getResult5() {
		return this.result5;
	}
	
	/**
	 * Column Info
	 * @return emlFax4
	 */
	public String getEmlFax4() {
		return this.emlFax4;
	}
	
	/**
	 * Column Info
	 * @return result6
	 */
	public String getResult6() {
		return this.result6;
	}
	
	/**
	 * Column Info
	 * @return emlFax3
	 */
	public String getEmlFax3() {
		return this.emlFax3;
	}
	
	/**
	 * Column Info
	 * @return toYardCd
	 */
	public String getToYardCd() {
		return this.toYardCd;
	}
	
	/**
	 * Column Info
	 * @return dorYardCd
	 */
	public String getDorYardCd() {
		return this.dorYardCd;
	}
	
	/**
	 * Column Info
	 * @return fmYardCd
	 */
	public String getFmYardCd() {
		return this.fmYardCd;
	}
	
	/**
	 * Column Info
	 * @return trnkVvdCd
	 */
	public String getTrnkVvdCd() {
		return this.trnkVvdCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
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
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param dorNodNm
	 */
	public void setDorNodNm(String dorNodNm) {
		this.dorNodNm = dorNodNm;
	}
	
	/**
	 * Column Info
	 * @param ibVvdCd
	 */
	public void setIbVvdCd(String ibVvdCd) {
		this.ibVvdCd = ibVvdCd;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
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
	 * @param result3
	 */
	public void setResult3(String result3) {
		this.result3 = result3;
	}
	
	/**
	 * Column Info
	 * @param etaTime
	 */
	public void setEtaTime(String etaTime) {
		this.etaTime = etaTime;
	}
	
	/**
	 * Column Info
	 * @param result4
	 */
	public void setResult4(String result4) {
		this.result4 = result4;
	}
	
	/**
	 * Column Info
	 * @param result1
	 */
	public void setResult1(String result1) {
		this.result1 = result1;
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
	 * @param result2
	 */
	public void setResult2(String result2) {
		this.result2 = result2;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param emlFax6
	 */
	public void setEmlFax6(String emlFax6) {
		this.emlFax6 = emlFax6;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * Column Info
	 * @param emlFax5
	 */
	public void setEmlFax5(String emlFax5) {
		this.emlFax5 = emlFax5;
	}
	
	/**
	 * Column Info
	 * @param ntcSndDt
	 */
	public void setNtcSndDt(String ntcSndDt) {
		this.ntcSndDt = ntcSndDt;
	}
	
	/**
	 * Column Info
	 * @param emlFax7
	 */
	public void setEmlFax7(String emlFax7) {
		this.emlFax7 = emlFax7;
	}
	
	/**
	 * Column Info
	 * @param result7
	 */
	public void setResult7(String result7) {
		this.result7 = result7;
	}
	
	/**
	 * Column Info
	 * @param emlFax2
	 */
	public void setEmlFax2(String emlFax2) {
		this.emlFax2 = emlFax2;
	}
	
	/**
	 * Column Info
	 * @param emlFax1
	 */
	public void setEmlFax1(String emlFax1) {
		this.emlFax1 = emlFax1;
	}
	
	/**
	 * Column Info
	 * @param result5
	 */
	public void setResult5(String result5) {
		this.result5 = result5;
	}
	
	/**
	 * Column Info
	 * @param emlFax4
	 */
	public void setEmlFax4(String emlFax4) {
		this.emlFax4 = emlFax4;
	}
	
	/**
	 * Column Info
	 * @param result6
	 */
	public void setResult6(String result6) {
		this.result6 = result6;
	}
	
	/**
	 * Column Info
	 * @param emlFax3
	 */
	public void setEmlFax3(String emlFax3) {
		this.emlFax3 = emlFax3;
	}
	
	/**
	 * Column Info
	 * @param toYardCd
	 */
	public void setToYardCd(String toYardCd) {
		this.toYardCd = toYardCd;
	}
	
	/**
	 * Column Info
	 * @param dorYardCd
	 */
	public void setDorYardCd(String dorYardCd) {
		this.dorYardCd = dorYardCd;
	}
	
	/**
	 * Column Info
	 * @param fmYardCd
	 */
	public void setFmYardCd(String fmYardCd) {
		this.fmYardCd = fmYardCd;
	}
	
	/**
	 * Column Info
	 * @param trnkVvdCd
	 */
	public void setTrnkVvdCd(String trnkVvdCd) {
		this.trnkVvdCd = trnkVvdCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
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
	 * @return railEtaDt
	 */
	public String getRailEtaDt() {
		return this.railEtaDt;
	}
	
	/**
	 * Column Info
	 * @param railEtaDt
	 */
	public void setRailEtaDt(String railEtaDt) {
		this.railEtaDt = railEtaDt;
	}
	
	/**
	 * Column Info
	 * @return railEtaTime
	 */
	public String getRailEtaTime() {
		return this.railEtaTime;
	}
	
	/**
	 * Column Info
	 * @param railEtaTime
	 */
	public void setRailEtaTime(String railEtaTime) {
		this.railEtaTime = railEtaTime;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setDorNodNm(JSPUtil.getParameter(request, prefix + "dor_nod_nm", ""));
		setIbVvdCd(JSPUtil.getParameter(request, prefix + "ib_vvd_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setResult3(JSPUtil.getParameter(request, prefix + "result_3", ""));
		setEtaTime(JSPUtil.getParameter(request, prefix + "eta_time", ""));
		setResult4(JSPUtil.getParameter(request, prefix + "result_4", ""));
		setResult1(JSPUtil.getParameter(request, prefix + "result_1", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setResult2(JSPUtil.getParameter(request, prefix + "result_2", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setEmlFax6(JSPUtil.getParameter(request, prefix + "eml_fax_6", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
		setEmlFax5(JSPUtil.getParameter(request, prefix + "eml_fax_5", ""));
		setNtcSndDt(JSPUtil.getParameter(request, prefix + "ntc_snd_dt", ""));
		setEmlFax7(JSPUtil.getParameter(request, prefix + "eml_fax_7", ""));
		setResult7(JSPUtil.getParameter(request, prefix + "result_7", ""));
		setEmlFax2(JSPUtil.getParameter(request, prefix + "eml_fax_2", ""));
		setEmlFax1(JSPUtil.getParameter(request, prefix + "eml_fax_1", ""));
		setResult5(JSPUtil.getParameter(request, prefix + "result_5", ""));
		setEmlFax4(JSPUtil.getParameter(request, prefix + "eml_fax_4", ""));
		setResult6(JSPUtil.getParameter(request, prefix + "result_6", ""));
		setEmlFax3(JSPUtil.getParameter(request, prefix + "eml_fax_3", ""));
		setToYardCd(JSPUtil.getParameter(request, prefix + "to_yard_cd", ""));
		setDorYardCd(JSPUtil.getParameter(request, prefix + "dor_yard_cd", ""));
		setFmYardCd(JSPUtil.getParameter(request, prefix + "fm_yard_cd", ""));
		setTrnkVvdCd(JSPUtil.getParameter(request, prefix + "trnk_vvd_cd", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setRailEtaDt(JSPUtil.getParameter(request, prefix + "rail_eta_dt", ""));
		setRailEtaTime(JSPUtil.getParameter(request, prefix + "rail_eta_time", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoNotificationReportVO[]
	 */
	public DoNotificationReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoNotificationReportVO[]
	 */
	public DoNotificationReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoNotificationReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] dorNodNm = (JSPUtil.getParameter(request, prefix	+ "dor_nod_nm", length));
			String[] ibVvdCd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] result3 = (JSPUtil.getParameter(request, prefix	+ "result_3", length));
			String[] etaTime = (JSPUtil.getParameter(request, prefix	+ "eta_time", length));
			String[] result4 = (JSPUtil.getParameter(request, prefix	+ "result_4", length));
			String[] result1 = (JSPUtil.getParameter(request, prefix	+ "result_1", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] result2 = (JSPUtil.getParameter(request, prefix	+ "result_2", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] emlFax6 = (JSPUtil.getParameter(request, prefix	+ "eml_fax_6", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			String[] emlFax5 = (JSPUtil.getParameter(request, prefix	+ "eml_fax_5", length));
			String[] ntcSndDt = (JSPUtil.getParameter(request, prefix	+ "ntc_snd_dt", length));
			String[] emlFax7 = (JSPUtil.getParameter(request, prefix	+ "eml_fax_7", length));
			String[] result7 = (JSPUtil.getParameter(request, prefix	+ "result_7", length));
			String[] emlFax2 = (JSPUtil.getParameter(request, prefix	+ "eml_fax_2", length));
			String[] emlFax1 = (JSPUtil.getParameter(request, prefix	+ "eml_fax_1", length));
			String[] result5 = (JSPUtil.getParameter(request, prefix	+ "result_5", length));
			String[] emlFax4 = (JSPUtil.getParameter(request, prefix	+ "eml_fax_4", length));
			String[] result6 = (JSPUtil.getParameter(request, prefix	+ "result_6", length));
			String[] emlFax3 = (JSPUtil.getParameter(request, prefix	+ "eml_fax_3", length));
			String[] toYardCd = (JSPUtil.getParameter(request, prefix	+ "to_yard_cd", length));
			String[] dorYardCd = (JSPUtil.getParameter(request, prefix	+ "dor_yard_cd", length));
			String[] fmYardCd = (JSPUtil.getParameter(request, prefix	+ "fm_yard_cd", length));
			String[] trnkVvdCd = (JSPUtil.getParameter(request, prefix	+ "trnk_vvd_cd", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] railEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_eta_dt", length));
			String[] railEtaTime = (JSPUtil.getParameter(request, prefix	+ "rail_eta_time", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoNotificationReportVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (dorNodNm[i] != null)
					model.setDorNodNm(dorNodNm[i]);
				if (ibVvdCd[i] != null)
					model.setIbVvdCd(ibVvdCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (result3[i] != null)
					model.setResult3(result3[i]);
				if (etaTime[i] != null)
					model.setEtaTime(etaTime[i]);
				if (result4[i] != null)
					model.setResult4(result4[i]);
				if (result1[i] != null)
					model.setResult1(result1[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (result2[i] != null)
					model.setResult2(result2[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (emlFax6[i] != null)
					model.setEmlFax6(emlFax6[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				if (emlFax5[i] != null)
					model.setEmlFax5(emlFax5[i]);
				if (ntcSndDt[i] != null)
					model.setNtcSndDt(ntcSndDt[i]);
				if (emlFax7[i] != null)
					model.setEmlFax7(emlFax7[i]);
				if (result7[i] != null)
					model.setResult7(result7[i]);
				if (emlFax2[i] != null)
					model.setEmlFax2(emlFax2[i]);
				if (emlFax1[i] != null)
					model.setEmlFax1(emlFax1[i]);
				if (result5[i] != null)
					model.setResult5(result5[i]);
				if (emlFax4[i] != null)
					model.setEmlFax4(emlFax4[i]);
				if (result6[i] != null)
					model.setResult6(result6[i]);
				if (emlFax3[i] != null)
					model.setEmlFax3(emlFax3[i]);
				if (toYardCd[i] != null)
					model.setToYardCd(toYardCd[i]);
				if (dorYardCd[i] != null)
					model.setDorYardCd(dorYardCd[i]);
				if (fmYardCd[i] != null)
					model.setFmYardCd(fmYardCd[i]);
				if (trnkVvdCd[i] != null)
					model.setTrnkVvdCd(trnkVvdCd[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (railEtaDt[i] != null)
					model.setRailEtaDt(railEtaDt[i]);
				if (railEtaTime[i] != null)
					model.setRailEtaTime(railEtaTime[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoNotificationReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoNotificationReportVO[]
	 */
	public DoNotificationReportVO[] getDoNotificationReportVOs(){
		DoNotificationReportVO[] vos = (DoNotificationReportVO[])models.toArray(new DoNotificationReportVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodNm = this.dorNodNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVvdCd = this.ibVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result3 = this.result3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaTime = this.etaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result4 = this.result4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result1 = this.result1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result2 = this.result2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFax6 = this.emlFax6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFax5 = this.emlFax5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcSndDt = this.ntcSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFax7 = this.emlFax7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result7 = this.result7 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFax2 = this.emlFax2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFax1 = this.emlFax1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result5 = this.result5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFax4 = this.emlFax4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.result6 = this.result6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlFax3 = this.emlFax3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYardCd = this.toYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorYardCd = this.dorYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYardCd = this.fmYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdCd = this.trnkVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railEtaDt = this.railEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railEtaTime = this.railEtaTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
