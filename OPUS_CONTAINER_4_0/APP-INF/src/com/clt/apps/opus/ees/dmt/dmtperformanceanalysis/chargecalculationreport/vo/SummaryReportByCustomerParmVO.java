/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SummaryReportByCustomerParmVO.java
*@FileTitle : SummaryReportByCustomerParmVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.07
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.07 황효근 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtperformanceanalysis.chargecalculationreport.vo;

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
 * @author 황효근
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SummaryReportByCustomerParmVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SummaryReportByCustomerParmVO> models = new ArrayList<SummaryReportByCustomerParmVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String endDt = null;
	/* Column Info */
	private String ctrtOfc = null;
	/* Column Info */
	private String schFlg = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String cvrCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcFlg = null;
	/* Column Info */
	private String currFlg = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scRfaNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String startDt = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String dmdtTrfCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SummaryReportByCustomerParmVO() {}

	public SummaryReportByCustomerParmVO(String ibflag, String pagerows, String currFlg, String startDt, String endDt, String dmdtTrfCd, String ofcFlg, String ofcCd, String schFlg, String scRfaNo, String scNo, String rfaNo, String ctrtOfc, String custCd, String cvrCd, String porCd, String polCd, String podCd, String delCd) {
		this.porCd = porCd;
		this.endDt = endDt;
		this.ctrtOfc = ctrtOfc;
		this.schFlg = schFlg;
		this.delCd = delCd;
		this.cvrCd = cvrCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ofcFlg = ofcFlg;
		this.currFlg = currFlg;
		this.ofcCd = ofcCd;
		this.rfaNo = rfaNo;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.scRfaNo = scRfaNo;
		this.custCd = custCd;
		this.startDt = startDt;
		this.scNo = scNo;
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("end_dt", getEndDt());
		this.hashColumns.put("ctrt_ofc", getCtrtOfc());
		this.hashColumns.put("sch_flg", getSchFlg());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("cvr_cd", getCvrCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_flg", getOfcFlg());
		this.hashColumns.put("curr_flg", getCurrFlg());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_rfa_no", getScRfaNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("start_dt", getStartDt());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("end_dt", "endDt");
		this.hashFields.put("ctrt_ofc", "ctrtOfc");
		this.hashFields.put("sch_flg", "schFlg");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("cvr_cd", "cvrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_flg", "ofcFlg");
		this.hashFields.put("curr_flg", "currFlg");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("start_dt", "startDt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
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
	 * @return endDt
	 */
	public String getEndDt() {
		return this.endDt;
	}
	
	/**
	 * Column Info
	 * @return ctrtOfc
	 */
	public String getCtrtOfc() {
		return this.ctrtOfc;
	}
	
	/**
	 * Column Info
	 * @return schFlg
	 */
	public String getSchFlg() {
		return this.schFlg;
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
	 * @return cvrCd
	 */
	public String getCvrCd() {
		return this.cvrCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return ofcFlg
	 */
	public String getOfcFlg() {
		return this.ofcFlg;
	}
	
	/**
	 * Column Info
	 * @return currFlg
	 */
	public String getCurrFlg() {
		return this.currFlg;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return scRfaNo
	 */
	public String getScRfaNo() {
		return this.scRfaNo;
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
	 * @return startDt
	 */
	public String getStartDt() {
		return this.startDt;
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
	 * @return dmdtTrfCd
	 */
	public String getDmdtTrfCd() {
		return this.dmdtTrfCd;
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
	 * @param endDt
	 */
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	
	/**
	 * Column Info
	 * @param ctrtOfc
	 */
	public void setCtrtOfc(String ctrtOfc) {
		this.ctrtOfc = ctrtOfc;
	}
	
	/**
	 * Column Info
	 * @param schFlg
	 */
	public void setSchFlg(String schFlg) {
		this.schFlg = schFlg;
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
	 * @param cvrCd
	 */
	public void setCvrCd(String cvrCd) {
		this.cvrCd = cvrCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param ofcFlg
	 */
	public void setOfcFlg(String ofcFlg) {
		this.ofcFlg = ofcFlg;
	}
	
	/**
	 * Column Info
	 * @param currFlg
	 */
	public void setCurrFlg(String currFlg) {
		this.currFlg = currFlg;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param scRfaNo
	 */
	public void setScRfaNo(String scRfaNo) {
		this.scRfaNo = scRfaNo;
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
	 * @param startDt
	 */
	public void setStartDt(String startDt) {
		this.startDt = startDt;
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
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setEndDt(JSPUtil.getParameter(request, "end_dt", ""));
		setCtrtOfc(JSPUtil.getParameter(request, "ctrt_ofc", ""));
		setSchFlg(JSPUtil.getParameter(request, "sch_flg", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setCvrCd(JSPUtil.getParameter(request, "cvr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcFlg(JSPUtil.getParameter(request, "ofc_flg", ""));
		setCurrFlg(JSPUtil.getParameter(request, "curr_flg", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setScRfaNo(JSPUtil.getParameter(request, "sc_rfa_no", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setStartDt(JSPUtil.getParameter(request, "start_dt", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SummaryReportByCustomerParmVO[]
	 */
	public SummaryReportByCustomerParmVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SummaryReportByCustomerParmVO[]
	 */
	public SummaryReportByCustomerParmVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SummaryReportByCustomerParmVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] endDt = (JSPUtil.getParameter(request, prefix	+ "end_dt", length));
			String[] ctrtOfc = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc", length));
			String[] schFlg = (JSPUtil.getParameter(request, prefix	+ "sch_flg", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] cvrCd = (JSPUtil.getParameter(request, prefix	+ "cvr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcFlg = (JSPUtil.getParameter(request, prefix	+ "ofc_flg", length));
			String[] currFlg = (JSPUtil.getParameter(request, prefix	+ "curr_flg", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scRfaNo = (JSPUtil.getParameter(request, prefix	+ "sc_rfa_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] startDt = (JSPUtil.getParameter(request, prefix	+ "start_dt", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SummaryReportByCustomerParmVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (endDt[i] != null)
					model.setEndDt(endDt[i]);
				if (ctrtOfc[i] != null)
					model.setCtrtOfc(ctrtOfc[i]);
				if (schFlg[i] != null)
					model.setSchFlg(schFlg[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (cvrCd[i] != null)
					model.setCvrCd(cvrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcFlg[i] != null)
					model.setOfcFlg(ofcFlg[i]);
				if (currFlg[i] != null)
					model.setCurrFlg(currFlg[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scRfaNo[i] != null)
					model.setScRfaNo(scRfaNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (startDt[i] != null)
					model.setStartDt(startDt[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSummaryReportByCustomerParmVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SummaryReportByCustomerParmVO[]
	 */
	public SummaryReportByCustomerParmVO[] getSummaryReportByCustomerParmVOs(){
		SummaryReportByCustomerParmVO[] vos = (SummaryReportByCustomerParmVO[])models.toArray(new SummaryReportByCustomerParmVO[models.size()]);
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
		this.endDt = this.endDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfc = this.ctrtOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.schFlg = this.schFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvrCd = this.cvrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcFlg = this.ofcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currFlg = this.currFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo = this.scRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startDt = this.startDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
