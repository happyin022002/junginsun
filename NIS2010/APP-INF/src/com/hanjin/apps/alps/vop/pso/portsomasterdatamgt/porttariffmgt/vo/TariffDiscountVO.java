/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffBaseVO.java
*@FileTitle : TariffBaseVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 박명종
*@LastVersion : 1.0
* 2009.06.19 박명종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 박명종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TariffDiscountVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TariffDiscountVO> models = new ArrayList<TariffDiscountVO>();
	
	/* Column Info */
	private String chgXprSeq = null;
	/* Column Info */
	private String objectCode = null;
	/* Column Info */
	private String objectName = null;
	/* Column Info */
	private String rateValue = null;
	/* Column Info */
	private String fomlDesc = null;
	/* Column Info */
	private String methodCode = null;
	/* Column Info */
	private String rateName = null;
	/* Column Info */
	private String rangeFrom = null;
	/* Column Info */
	private String rateCode = null;
	/* Column Info */
	private String currency = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rangeTo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String chgXprNo = null;
	/* Column Info */
	private String fomlNo = null;
	/* Column Info */
	private String condNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TariffDiscountVO() {}

	public TariffDiscountVO(String ibflag, String pagerows, String chgXprNo, String chgXprSeq, String fomlNo, String fomlDesc, String condNo, String objectCode, String seq, String objectName, String rateCode, String rateName, String rangeFrom, String rangeTo, String currency, String rateValue, String methodCode) {
		this.chgXprSeq = chgXprSeq;
		this.objectCode = objectCode;
		this.objectName = objectName;
		this.rateValue = rateValue;
		this.fomlDesc = fomlDesc;
		this.methodCode = methodCode;
		this.rateName = rateName;
		this.rangeFrom = rangeFrom;
		this.rateCode = rateCode;
		this.currency = currency;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rangeTo = rangeTo;
		this.seq = seq;
		this.chgXprNo = chgXprNo;
		this.fomlNo = fomlNo;
		this.condNo = condNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_xpr_seq", getChgXprSeq());
		this.hashColumns.put("object_code", getObjectCode());
		this.hashColumns.put("object_name", getObjectName());
		this.hashColumns.put("rate_value", getRateValue());
		this.hashColumns.put("foml_desc", getFomlDesc());
		this.hashColumns.put("method_code", getMethodCode());
		this.hashColumns.put("rate_name", getRateName());
		this.hashColumns.put("range_from", getRangeFrom());
		this.hashColumns.put("rate_code", getRateCode());
		this.hashColumns.put("currency", getCurrency());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("range_to", getRangeTo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("chg_xpr_no", getChgXprNo());
		this.hashColumns.put("foml_no", getFomlNo());
		this.hashColumns.put("cond_no", getCondNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("chg_xpr_seq", "chgXprSeq");
		this.hashFields.put("object_code", "objectCode");
		this.hashFields.put("object_name", "objectName");
		this.hashFields.put("rate_value", "rateValue");
		this.hashFields.put("foml_desc", "fomlDesc");
		this.hashFields.put("method_code", "methodCode");
		this.hashFields.put("rate_name", "rateName");
		this.hashFields.put("range_from", "rangeFrom");
		this.hashFields.put("rate_code", "rateCode");
		this.hashFields.put("currency", "currency");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("range_to", "rangeTo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("chg_xpr_no", "chgXprNo");
		this.hashFields.put("foml_no", "fomlNo");
		this.hashFields.put("cond_no", "condNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return chgXprSeq
	 */
	public String getChgXprSeq() {
		return this.chgXprSeq;
	}
	
	/**
	 * Column Info
	 * @return objectCode
	 */
	public String getObjectCode() {
		return this.objectCode;
	}
	
	/**
	 * Column Info
	 * @return objectName
	 */
	public String getObjectName() {
		return this.objectName;
	}
	
	/**
	 * Column Info
	 * @return rateValue
	 */
	public String getRateValue() {
		return this.rateValue;
	}
	
	/**
	 * Column Info
	 * @return fomlDesc
	 */
	public String getFomlDesc() {
		return this.fomlDesc;
	}
	
	/**
	 * Column Info
	 * @return methodCode
	 */
	public String getMethodCode() {
		return this.methodCode;
	}
	
	/**
	 * Column Info
	 * @return rateName
	 */
	public String getRateName() {
		return this.rateName;
	}
	
	/**
	 * Column Info
	 * @return rangeFrom
	 */
	public String getRangeFrom() {
		return this.rangeFrom;
	}
	
	/**
	 * Column Info
	 * @return rateCode
	 */
	public String getRateCode() {
		return this.rateCode;
	}
	
	/**
	 * Column Info
	 * @return currency
	 */
	public String getCurrency() {
		return this.currency;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return rangeTo
	 */
	public String getRangeTo() {
		return this.rangeTo;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return chgXprNo
	 */
	public String getChgXprNo() {
		return this.chgXprNo;
	}
	
	/**
	 * Column Info
	 * @return fomlNo
	 */
	public String getFomlNo() {
		return this.fomlNo;
	}
	
	/**
	 * Column Info
	 * @return condNo
	 */
	public String getCondNo() {
		return this.condNo;
	}
	

	/**
	 * Column Info
	 * @param chgXprSeq
	 */
	public void setChgXprSeq(String chgXprSeq) {
		this.chgXprSeq = chgXprSeq;
	}
	
	/**
	 * Column Info
	 * @param objectCode
	 */
	public void setObjectCode(String objectCode) {
		this.objectCode = objectCode;
	}
	
	/**
	 * Column Info
	 * @param objectName
	 */
	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
	
	/**
	 * Column Info
	 * @param rateValue
	 */
	public void setRateValue(String rateValue) {
		this.rateValue = rateValue;
	}
	
	/**
	 * Column Info
	 * @param fomlDesc
	 */
	public void setFomlDesc(String fomlDesc) {
		this.fomlDesc = fomlDesc;
	}
	
	/**
	 * Column Info
	 * @param methodCode
	 */
	public void setMethodCode(String methodCode) {
		this.methodCode = methodCode;
	}
	
	/**
	 * Column Info
	 * @param rateName
	 */
	public void setRateName(String rateName) {
		this.rateName = rateName;
	}
	
	/**
	 * Column Info
	 * @param rangeFrom
	 */
	public void setRangeFrom(String rangeFrom) {
		this.rangeFrom = rangeFrom;
	}
	
	/**
	 * Column Info
	 * @param rateCode
	 */
	public void setRateCode(String rateCode) {
		this.rateCode = rateCode;
	}
	
	/**
	 * Column Info
	 * @param currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param rangeTo
	 */
	public void setRangeTo(String rangeTo) {
		this.rangeTo = rangeTo;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param chgXprNo
	 */
	public void setChgXprNo(String chgXprNo) {
		this.chgXprNo = chgXprNo;
	}
	
	/**
	 * Column Info
	 * @param fomlNo
	 */
	public void setFomlNo(String fomlNo) {
		this.fomlNo = fomlNo;
	}
	
	/**
	 * Column Info
	 * @param condNo
	 */
	public void setCondNo(String condNo) {
		this.condNo = condNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setChgXprSeq(JSPUtil.getParameter(request, "chg_xpr_seq", ""));
		setObjectCode(JSPUtil.getParameter(request, "object_code", ""));
		setObjectName(JSPUtil.getParameter(request, "object_name", ""));
		setRateValue(JSPUtil.getParameter(request, "rate_value", ""));
		setFomlDesc(JSPUtil.getParameter(request, "foml_desc", ""));
		setMethodCode(JSPUtil.getParameter(request, "method_code", ""));
		setRateName(JSPUtil.getParameter(request, "rate_name", ""));
		setRangeFrom(JSPUtil.getParameter(request, "range_from", ""));
		setRateCode(JSPUtil.getParameter(request, "rate_code", ""));
		setCurrency(JSPUtil.getParameter(request, "currency", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRangeTo(JSPUtil.getParameter(request, "range_to", ""));
		setSeq(JSPUtil.getParameter(request, "seq", ""));
		setChgXprNo(JSPUtil.getParameter(request, "chg_xpr_no", ""));
		setFomlNo(JSPUtil.getParameter(request, "foml_no", ""));
		setCondNo(JSPUtil.getParameter(request, "cond_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TariffBaseVO[]
	 */
	public TariffDiscountVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TariffBaseVO[]
	 */
	public TariffDiscountVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TariffDiscountVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] chgXprSeq = (JSPUtil.getParameter(request, prefix	+ "chg_xpr_seq".trim(), length));
			String[] objectCode = (JSPUtil.getParameter(request, prefix	+ "object_code".trim(), length));
			String[] objectName = (JSPUtil.getParameter(request, prefix	+ "object_name".trim(), length));
			String[] rateValue = (JSPUtil.getParameter(request, prefix	+ "rate_value".trim(), length));
			String[] fomlDesc = (JSPUtil.getParameter(request, prefix	+ "foml_desc".trim(), length));
			String[] methodCode = (JSPUtil.getParameter(request, prefix	+ "method_code".trim(), length));
			String[] rateName = (JSPUtil.getParameter(request, prefix	+ "rate_name".trim(), length));
			String[] rangeFrom = (JSPUtil.getParameter(request, prefix	+ "range_from".trim(), length));
			String[] rateCode = (JSPUtil.getParameter(request, prefix	+ "rate_code".trim(), length));
			String[] currency = (JSPUtil.getParameter(request, prefix	+ "currency".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] rangeTo = (JSPUtil.getParameter(request, prefix	+ "range_to".trim(), length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq".trim(), length));
			String[] chgXprNo = (JSPUtil.getParameter(request, prefix	+ "chg_xpr_no".trim(), length));
			String[] fomlNo = (JSPUtil.getParameter(request, prefix	+ "foml_no".trim(), length));
			String[] condNo = (JSPUtil.getParameter(request, prefix	+ "cond_no".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new TariffDiscountVO();
				if (chgXprSeq[i] != null)
					model.setChgXprSeq(chgXprSeq[i]);
				if (objectCode[i] != null)
					model.setObjectCode(objectCode[i]);
				if (objectName[i] != null)
					model.setObjectName(objectName[i]);
				if (rateValue[i] != null)
					model.setRateValue(rateValue[i]);
				if (fomlDesc[i] != null)
					model.setFomlDesc(fomlDesc[i]);
				if (methodCode[i] != null)
					model.setMethodCode(methodCode[i]);
				if (rateName[i] != null)
					model.setRateName(rateName[i]);
				if (rangeFrom[i] != null)
					model.setRangeFrom(rangeFrom[i]);
				if (rateCode[i] != null)
					model.setRateCode(rateCode[i]);
				if (currency[i] != null)
					model.setCurrency(currency[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rangeTo[i] != null)
					model.setRangeTo(rangeTo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (chgXprNo[i] != null)
					model.setChgXprNo(chgXprNo[i]);
				if (fomlNo[i] != null)
					model.setFomlNo(fomlNo[i]);
				if (condNo[i] != null)
					model.setCondNo(condNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTariffBaseVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TariffBaseVO[]
	 */
	public TariffDiscountVO[] getTariffBaseVOs(){
		TariffDiscountVO[] vos = (TariffDiscountVO[])models.toArray(new TariffDiscountVO[models.size()]);
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
		this.chgXprSeq = this.chgXprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objectCode = this.objectCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objectName = this.objectName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateValue = this.rateValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlDesc = this.fomlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.methodCode = this.methodCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateName = this.rateName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rangeFrom = this.rangeFrom .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateCode = this.rateCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currency = this.currency .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rangeTo = this.rangeTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgXprNo = this.chgXprNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlNo = this.fomlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condNo = this.condNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
