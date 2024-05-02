/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRFAExceptionParamVO.java
*@FileTitle : SCRFAExceptionParamVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.03
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.03  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.scexceptiontariffmgt.vo;

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

public class SCRFAExceptionParamVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SCRFAExceptionParamVO> models = new ArrayList<SCRFAExceptionParamVO>();
	
	/* Column Info */
	private String rgnCd = null;
	/* Column Info */
	private String fmDt = null;
	/* Column Info */
	private String darNo = null;
	/* Column Info */
	private String apvlNo = null;
	/* Column Info */
	private String verStsCd = null;
	/* Column Info */
	private String type = null;
	/* Column Info */
	private String rqstStsCd = null;
	/* Column Info */
	private String actCustCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String custTp = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String tariff = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String condTp = null;
	/* Column Info */
	private String steCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SCRFAExceptionParamVO() {}

	public SCRFAExceptionParamVO(String ibflag, String pagerows, String verStsCd, String rqstStsCd, String tariff, String ofcCd, String fmDt, String toDt, String cntCd, String rgnCd, String steCd, String locCd, String scNo, String rfaNo, String propNo, String darNo, String apvlNo, String type, String condTp, String custTp, String custCd, String actCustCd) {
		this.rgnCd = rgnCd;
		this.fmDt = fmDt;
		this.darNo = darNo;
		this.apvlNo = apvlNo;
		this.verStsCd = verStsCd;
		this.type = type;
		this.rqstStsCd = rqstStsCd;
		this.actCustCd = actCustCd;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.rfaNo = rfaNo;
		this.ofcCd = ofcCd;
		this.custTp = custTp;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.propNo = propNo;
		this.custCd = custCd;
		this.scNo = scNo;
		this.tariff = tariff;
		this.cntCd = cntCd;
		this.condTp = condTp;
		this.steCd = steCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("dar_no", getDarNo());
		this.hashColumns.put("apvl_no", getApvlNo());
		this.hashColumns.put("ver_sts_cd", getVerStsCd());
		this.hashColumns.put("type", getType());
		this.hashColumns.put("rqst_sts_cd", getRqstStsCd());
		this.hashColumns.put("act_cust_cd", getActCustCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cust_tp", getCustTp());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("tariff", getTariff());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("cond_tp", getCondTp());
		this.hashColumns.put("ste_cd", getSteCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("dar_no", "darNo");
		this.hashFields.put("apvl_no", "apvlNo");
		this.hashFields.put("ver_sts_cd", "verStsCd");
		this.hashFields.put("type", "type");
		this.hashFields.put("rqst_sts_cd", "rqstStsCd");
		this.hashFields.put("act_cust_cd", "actCustCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cust_tp", "custTp");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("tariff", "tariff");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cond_tp", "condTp");
		this.hashFields.put("ste_cd", "steCd");
		return this.hashFields;
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
	 * @return fmDt
	 */
	public String getFmDt() {
		return this.fmDt;
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
	 * @return verStsCd
	 */
	public String getVerStsCd() {
		return this.verStsCd;
	}
	
	/**
	 * Column Info
	 * @return type
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * Column Info
	 * @return rqstStsCd
	 */
	public String getRqstStsCd() {
		return this.rqstStsCd;
	}
	
	/**
	 * Column Info
	 * @return actCustCd
	 */
	public String getActCustCd() {
		return this.actCustCd;
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
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return custTp
	 */
	public String getCustTp() {
		return this.custTp;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return tariff
	 */
	public String getTariff() {
		return this.tariff;
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
	 * @return condTp
	 */
	public String getCondTp() {
		return this.condTp;
	}
	
	/**
	 * Column Info
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
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
	 * @param fmDt
	 */
	public void setFmDt(String fmDt) {
		this.fmDt = fmDt;
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
	 * @param verStsCd
	 */
	public void setVerStsCd(String verStsCd) {
		this.verStsCd = verStsCd;
	}
	
	/**
	 * Column Info
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Column Info
	 * @param rqstStsCd
	 */
	public void setRqstStsCd(String rqstStsCd) {
		this.rqstStsCd = rqstStsCd;
	}
	
	/**
	 * Column Info
	 * @param actCustCd
	 */
	public void setActCustCd(String actCustCd) {
		this.actCustCd = actCustCd;
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
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param custTp
	 */
	public void setCustTp(String custTp) {
		this.custTp = custTp;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param tariff
	 */
	public void setTariff(String tariff) {
		this.tariff = tariff;
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
	 * @param condTp
	 */
	public void setCondTp(String condTp) {
		this.condTp = condTp;
	}
	
	/**
	 * Column Info
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRgnCd(JSPUtil.getParameter(request, "rgn_cd", ""));
		setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
		setDarNo(JSPUtil.getParameter(request, "dar_no", ""));
		setApvlNo(JSPUtil.getParameter(request, "apvl_no", ""));
		setVerStsCd(JSPUtil.getParameter(request, "ver_sts_cd", ""));
		setType(JSPUtil.getParameter(request, "type", ""));
		setRqstStsCd(JSPUtil.getParameter(request, "rqst_sts_cd", ""));
		setActCustCd(JSPUtil.getParameter(request, "act_cust_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCustTp(JSPUtil.getParameter(request, "cust_tp", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setTariff(JSPUtil.getParameter(request, "tariff", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
		setCondTp(JSPUtil.getParameter(request, "cond_tp", ""));
		setSteCd(JSPUtil.getParameter(request, "ste_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SCRFAExceptionParamVO[]
	 */
	public SCRFAExceptionParamVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SCRFAExceptionParamVO[]
	 */
	public SCRFAExceptionParamVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SCRFAExceptionParamVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rgnCd = (JSPUtil.getParameter(request, prefix	+ "rgn_cd", length));
			String[] fmDt = (JSPUtil.getParameter(request, prefix	+ "fm_dt", length));
			String[] darNo = (JSPUtil.getParameter(request, prefix	+ "dar_no", length));
			String[] apvlNo = (JSPUtil.getParameter(request, prefix	+ "apvl_no", length));
			String[] verStsCd = (JSPUtil.getParameter(request, prefix	+ "ver_sts_cd", length));
			String[] type = (JSPUtil.getParameter(request, prefix	+ "type", length));
			String[] rqstStsCd = (JSPUtil.getParameter(request, prefix	+ "rqst_sts_cd", length));
			String[] actCustCd = (JSPUtil.getParameter(request, prefix	+ "act_cust_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] custTp = (JSPUtil.getParameter(request, prefix	+ "cust_tp", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] tariff = (JSPUtil.getParameter(request, prefix	+ "tariff", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] condTp = (JSPUtil.getParameter(request, prefix	+ "cond_tp", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SCRFAExceptionParamVO();
				if (rgnCd[i] != null)
					model.setRgnCd(rgnCd[i]);
				if (fmDt[i] != null)
					model.setFmDt(fmDt[i]);
				if (darNo[i] != null)
					model.setDarNo(darNo[i]);
				if (apvlNo[i] != null)
					model.setApvlNo(apvlNo[i]);
				if (verStsCd[i] != null)
					model.setVerStsCd(verStsCd[i]);
				if (type[i] != null)
					model.setType(type[i]);
				if (rqstStsCd[i] != null)
					model.setRqstStsCd(rqstStsCd[i]);
				if (actCustCd[i] != null)
					model.setActCustCd(actCustCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (custTp[i] != null)
					model.setCustTp(custTp[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (tariff[i] != null)
					model.setTariff(tariff[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (condTp[i] != null)
					model.setCondTp(condTp[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSCRFAExceptionParamVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SCRFAExceptionParamVO[]
	 */
	public SCRFAExceptionParamVO[] getSCRFAExceptionParamVOs(){
		SCRFAExceptionParamVO[] vos = (SCRFAExceptionParamVO[])models.toArray(new SCRFAExceptionParamVO[models.size()]);
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
		this.rgnCd = this.rgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt = this.fmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.darNo = this.darNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apvlNo = this.apvlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.verStsCd = this.verStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.type = this.type .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstStsCd = this.rqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCd = this.actCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTp = this.custTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tariff = this.tariff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condTp = this.condTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
