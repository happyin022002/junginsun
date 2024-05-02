/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BeforeAfterStatusVO.java
*@FileTitle : BeforeAfterStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.10  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BeforeAfterStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BeforeAfterStatusVO> models = new ArrayList<BeforeAfterStatusVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String reqOfcCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String toCc = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String verNo = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String locCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String coverage = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String dmdtTrfCd = null;
	/* Column Info */
	private String finalOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BeforeAfterStatusVO() {}

	public BeforeAfterStatusVO(String ibflag, String pagerows, String toCc, String scNo, String verNo, String darNo, String apvlNo, String rfaNo, String status, String dmdtTrfCd, String coverage, String cntCd, String rgnCd, String locCd, String bkgNo, String blNo, String reqOfcCd, String aproOfcCd, String updDt, String propNo, String custCd, String custNm, String finalOfcCd) {
		this.updDt = updDt;
		this.rgnCd = rgnCd;
		this.reqOfcCd = reqOfcCd;
		this.custNm = custNm;
		this.toCc = toCc;
		this.status = status;
		this.darNo = darNo;
		this.apvlNo = apvlNo;
		this.aproOfcCd = aproOfcCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.verNo = verNo;
		this.rfaNo = rfaNo;
		this.bkgNo = bkgNo;
		this.locCd = locCd;
		this.ibflag = ibflag;
		this.propNo = propNo;
		this.coverage = coverage;
		this.custCd = custCd;
		this.scNo = scNo;
		this.cntCd = cntCd;
		this.dmdtTrfCd = dmdtTrfCd;
		this.finalOfcCd = finalOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("req_ofc_cd", getReqOfcCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("to_cc", getToCc());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ver_no", getVerNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("coverage", getCoverage());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("dmdt_trf_cd", getDmdtTrfCd());
		this.hashColumns.put("final_ofc_cd", getFinalOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("req_ofc_cd", "reqOfcCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("to_cc", "toCc");
		this.hashFields.put("status", "status");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ver_no", "verNo");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("coverage", "coverage");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("dmdt_trf_cd", "dmdtTrfCd");
		this.hashFields.put("final_ofc_cd", "finalOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return rgnCd
	 */
	public String getRgnCd() {
		return this.rgnCd;
	}
	
	/**
	 * Column Info
	 * @return reqOfcCd
	 */
	public String getReqOfcCd() {
		return this.reqOfcCd;
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
	 * @return toCc
	 */
	public String getToCc() {
		return this.toCc;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return darNo
	 */
	public String getDarNo() {
		return this.darNo;
	}
	
	/**
	 * Column Info
	 * @return apvlNo
	 */
	public String getApvlNo() {
		return this.apvlNo;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
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
	 * @return verNo
	 */
	public String getVerNo() {
		return this.verNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return coverage
	 */
	public String getCoverage() {
		return this.coverage;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param rgnCd
	 */
	public void setRgnCd(String rgnCd) {
		this.rgnCd = rgnCd;
	}
	
	/**
	 * Column Info
	 * @param reqOfcCd
	 */
	public void setReqOfcCd(String reqOfcCd) {
		this.reqOfcCd = reqOfcCd;
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
	 * @param toCc
	 */
	public void setToCc(String toCc) {
		this.toCc = toCc;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param darNo
	 */
	public void setDarNo(String darNo) {
		this.darNo = darNo;
	}
	
	/**
	 * Column Info
	 * @param apvlNo
	 */
	public void setApvlNo(String apvlNo) {
		this.apvlNo = apvlNo;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
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
	 * @param verNo
	 */
	public void setVerNo(String verNo) {
		this.verNo = verNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param coverage
	 */
	public void setCoverage(String coverage) {
		this.coverage = coverage;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Column Info
	 * @param dmdtTrfCd
	 */
	public void setDmdtTrfCd(String dmdtTrfCd) {
		this.dmdtTrfCd = dmdtTrfCd;
	}
	
	public String getFinalOfcCd() {
		return finalOfcCd;
	}

	public void setFinalOfcCd(String finalOfcCd) {
		this.finalOfcCd = finalOfcCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setReqOfcCd(JSPUtil.getParameter(request, "req_ofc_cd", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setToCc(JSPUtil.getParameter(request, "to_cc", ""));
		setStatus(JSPUtil.getParameter(request, "status", ""));
		setDarNo(JSPUtil.getParameter(request, "dar_no", ""));
		setApvlNo(JSPUtil.getParameter(request, "apvl_no", ""));
		setAproOfcCd(JSPUtil.getParameter(request, "apro_ofc_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVerNo(JSPUtil.getParameter(request, "ver_no", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCoverage(JSPUtil.getParameter(request, "coverage", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setDmdtTrfCd(JSPUtil.getParameter(request, "dmdt_trf_cd", ""));
		setFinalOfcCd(JSPUtil.getParameter(request, "final_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BeforeAfterStatusVO[]
	 */
	public BeforeAfterStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BeforeAfterStatusVO[]
	 */
	public BeforeAfterStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BeforeAfterStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] reqOfcCd = (JSPUtil.getParameter(request, prefix	+ "req_ofc_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] toCc = (JSPUtil.getParameter(request, prefix	+ "to_cc", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] verNo = (JSPUtil.getParameter(request, prefix	+ "ver_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] coverage = (JSPUtil.getParameter(request, prefix	+ "coverage", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] dmdtTrfCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_trf_cd", length));
			String[] finalOfcCd = (JSPUtil.getParameter(request, prefix	+ "final_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BeforeAfterStatusVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (reqOfcCd[i] != null)
					model.setReqOfcCd(reqOfcCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (toCc[i] != null)
					model.setToCc(toCc[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (verNo[i] != null)
					model.setVerNo(verNo[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (coverage[i] != null)
					model.setCoverage(coverage[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (dmdtTrfCd[i] != null)
					model.setDmdtTrfCd(dmdtTrfCd[i]);
				if (finalOfcCd[i] != null)
					model.setFinalOfcCd(finalOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBeforeAfterStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BeforeAfterStatusVO[]
	 */
	public BeforeAfterStatusVO[] getBeforeAfterStatusVOs(){
		BeforeAfterStatusVO[] vos = (BeforeAfterStatusVO[])models.toArray(new BeforeAfterStatusVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reqOfcCd = this.reqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCc = this.toCc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verNo = this.verNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coverage = this.coverage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtTrfCd = this.dmdtTrfCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalOfcCd = this.finalOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
