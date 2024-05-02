/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AfterBookingDetailReasonListVO.java
*@FileTitle : AfterBookingDetailReasonListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.24  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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

public class AfterBookingDetailReasonListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBookingDetailReasonListVO> models = new ArrayList<AfterBookingDetailReasonListVO>();
	
	/* Column Info */
	private String specRsnCd = null;
	/* Column Info */
	private String specRsnFieldValue = null;
	/* Column Info */
	private String specRsnFieldFormat = null;
	/* Column Info */
	private String specRsnFieldLevel = null;
	/* Column Info */
	private String specRsnFieldSize = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aftExptDarNo = null;
	/* Column Info */
	private String specRsnFieldPopup = null;
	/* Column Info */
	private String specRsnFieldItem = null;
	/* Column Info */
	private String specRsnFieldName = null;
	/* Column Info */
	private String specRsnFieldType = null;
	/* Column Info */
	private String specRsnFieldCond = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AfterBookingDetailReasonListVO() {}

	public AfterBookingDetailReasonListVO(String ibflag, String pagerows, String specRsnCd, String specRsnFieldLevel, String specRsnFieldName, String specRsnFieldType, String specRsnFieldSize, String specRsnFieldFormat, String specRsnFieldItem, String specRsnFieldCond, String specRsnFieldPopup, String specRsnFieldValue, String aftExptDarNo) {
		this.specRsnCd = specRsnCd;
		this.specRsnFieldValue = specRsnFieldValue;
		this.specRsnFieldFormat = specRsnFieldFormat;
		this.specRsnFieldLevel = specRsnFieldLevel;
		this.specRsnFieldSize = specRsnFieldSize;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.aftExptDarNo = aftExptDarNo;
		this.specRsnFieldPopup = specRsnFieldPopup;
		this.specRsnFieldItem = specRsnFieldItem;
		this.specRsnFieldName = specRsnFieldName;
		this.specRsnFieldType = specRsnFieldType;
		this.specRsnFieldCond = specRsnFieldCond;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("spec_rsn_cd", getSpecRsnCd());
		this.hashColumns.put("spec_rsn_field_value", getSpecRsnFieldValue());
		this.hashColumns.put("spec_rsn_field_format", getSpecRsnFieldFormat());
		this.hashColumns.put("spec_rsn_field_level", getSpecRsnFieldLevel());
		this.hashColumns.put("spec_rsn_field_size", getSpecRsnFieldSize());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aft_expt_dar_no", getAftExptDarNo());
		this.hashColumns.put("spec_rsn_field_popup", getSpecRsnFieldPopup());
		this.hashColumns.put("spec_rsn_field_item", getSpecRsnFieldItem());
		this.hashColumns.put("spec_rsn_field_name", getSpecRsnFieldName());
		this.hashColumns.put("spec_rsn_field_type", getSpecRsnFieldType());
		this.hashColumns.put("spec_rsn_field_cond", getSpecRsnFieldCond());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("spec_rsn_cd", "specRsnCd");
		this.hashFields.put("spec_rsn_field_value", "specRsnFieldValue");
		this.hashFields.put("spec_rsn_field_format", "specRsnFieldFormat");
		this.hashFields.put("spec_rsn_field_level", "specRsnFieldLevel");
		this.hashFields.put("spec_rsn_field_size", "specRsnFieldSize");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aft_expt_dar_no", "aftExptDarNo");
		this.hashFields.put("spec_rsn_field_popup", "specRsnFieldPopup");
		this.hashFields.put("spec_rsn_field_item", "specRsnFieldItem");
		this.hashFields.put("spec_rsn_field_name", "specRsnFieldName");
		this.hashFields.put("spec_rsn_field_type", "specRsnFieldType");
		this.hashFields.put("spec_rsn_field_cond", "specRsnFieldCond");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return specRsnCd
	 */
	public String getSpecRsnCd() {
		return this.specRsnCd;
	}
	
	/**
	 * Column Info
	 * @return specRsnFieldValue
	 */
	public String getSpecRsnFieldValue() {
		return this.specRsnFieldValue;
	}
	
	/**
	 * Column Info
	 * @return specRsnFieldFormat
	 */
	public String getSpecRsnFieldFormat() {
		return this.specRsnFieldFormat;
	}
	
	/**
	 * Column Info
	 * @return specRsnFieldLevel
	 */
	public String getSpecRsnFieldLevel() {
		return this.specRsnFieldLevel;
	}
	
	/**
	 * Column Info
	 * @return specRsnFieldSize
	 */
	public String getSpecRsnFieldSize() {
		return this.specRsnFieldSize;
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
	 * @return aftExptDarNo
	 */
	public String getAftExptDarNo() {
		return this.aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @return specRsnFieldPopup
	 */
	public String getSpecRsnFieldPopup() {
		return this.specRsnFieldPopup;
	}
	
	/**
	 * Column Info
	 * @return specRsnFieldItem
	 */
	public String getSpecRsnFieldItem() {
		return this.specRsnFieldItem;
	}
	
	/**
	 * Column Info
	 * @return specRsnFieldName
	 */
	public String getSpecRsnFieldName() {
		return this.specRsnFieldName;
	}
	
	/**
	 * Column Info
	 * @return specRsnFieldType
	 */
	public String getSpecRsnFieldType() {
		return this.specRsnFieldType;
	}
	
	/**
	 * Column Info
	 * @return specRsnFieldCond
	 */
	public String getSpecRsnFieldCond() {
		return this.specRsnFieldCond;
	}
	

	/**
	 * Column Info
	 * @param specRsnCd
	 */
	public void setSpecRsnCd(String specRsnCd) {
		this.specRsnCd = specRsnCd;
	}
	
	/**
	 * Column Info
	 * @param specRsnFieldValue
	 */
	public void setSpecRsnFieldValue(String specRsnFieldValue) {
		this.specRsnFieldValue = specRsnFieldValue;
	}
	
	/**
	 * Column Info
	 * @param specRsnFieldFormat
	 */
	public void setSpecRsnFieldFormat(String specRsnFieldFormat) {
		this.specRsnFieldFormat = specRsnFieldFormat;
	}
	
	/**
	 * Column Info
	 * @param specRsnFieldLevel
	 */
	public void setSpecRsnFieldLevel(String specRsnFieldLevel) {
		this.specRsnFieldLevel = specRsnFieldLevel;
	}
	
	/**
	 * Column Info
	 * @param specRsnFieldSize
	 */
	public void setSpecRsnFieldSize(String specRsnFieldSize) {
		this.specRsnFieldSize = specRsnFieldSize;
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
	 * @param aftExptDarNo
	 */
	public void setAftExptDarNo(String aftExptDarNo) {
		this.aftExptDarNo = aftExptDarNo;
	}
	
	/**
	 * Column Info
	 * @param specRsnFieldPopup
	 */
	public void setSpecRsnFieldPopup(String specRsnFieldPopup) {
		this.specRsnFieldPopup = specRsnFieldPopup;
	}
	
	/**
	 * Column Info
	 * @param specRsnFieldItem
	 */
	public void setSpecRsnFieldItem(String specRsnFieldItem) {
		this.specRsnFieldItem = specRsnFieldItem;
	}
	
	/**
	 * Column Info
	 * @param specRsnFieldName
	 */
	public void setSpecRsnFieldName(String specRsnFieldName) {
		this.specRsnFieldName = specRsnFieldName;
	}
	
	/**
	 * Column Info
	 * @param specRsnFieldType
	 */
	public void setSpecRsnFieldType(String specRsnFieldType) {
		this.specRsnFieldType = specRsnFieldType;
	}
	
	/**
	 * Column Info
	 * @param specRsnFieldCond
	 */
	public void setSpecRsnFieldCond(String specRsnFieldCond) {
		this.specRsnFieldCond = specRsnFieldCond;
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
		setSpecRsnCd(JSPUtil.getParameter(request, prefix + "spec_rsn_cd", ""));
		setSpecRsnFieldValue(JSPUtil.getParameter(request, prefix + "spec_rsn_field_value", ""));
		setSpecRsnFieldFormat(JSPUtil.getParameter(request, prefix + "spec_rsn_field_format", ""));
		setSpecRsnFieldLevel(JSPUtil.getParameter(request, prefix + "spec_rsn_field_level", ""));
		setSpecRsnFieldSize(JSPUtil.getParameter(request, prefix + "spec_rsn_field_size", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAftExptDarNo(JSPUtil.getParameter(request, prefix + "aft_expt_dar_no", ""));
		setSpecRsnFieldPopup(JSPUtil.getParameter(request, prefix + "spec_rsn_field_popup", ""));
		setSpecRsnFieldItem(JSPUtil.getParameter(request, prefix + "spec_rsn_field_item", ""));
		setSpecRsnFieldName(JSPUtil.getParameter(request, prefix + "spec_rsn_field_name", ""));
		setSpecRsnFieldType(JSPUtil.getParameter(request, prefix + "spec_rsn_field_type", ""));
		setSpecRsnFieldCond(JSPUtil.getParameter(request, prefix + "spec_rsn_field_cond", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBookingDetailReasonListVO[]
	 */
	public AfterBookingDetailReasonListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBookingDetailReasonListVO[]
	 */
	public AfterBookingDetailReasonListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBookingDetailReasonListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] specRsnCd = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_cd", length));
			String[] specRsnFieldValue = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_field_value", length));
			String[] specRsnFieldFormat = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_field_format", length));
			String[] specRsnFieldLevel = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_field_level", length));
			String[] specRsnFieldSize = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_field_size", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aftExptDarNo = (JSPUtil.getParameter(request, prefix	+ "aft_expt_dar_no", length));
			String[] specRsnFieldPopup = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_field_popup", length));
			String[] specRsnFieldItem = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_field_item", length));
			String[] specRsnFieldName = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_field_name", length));
			String[] specRsnFieldType = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_field_type", length));
			String[] specRsnFieldCond = (JSPUtil.getParameter(request, prefix	+ "spec_rsn_field_cond", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBookingDetailReasonListVO();
				if (specRsnCd[i] != null)
					model.setSpecRsnCd(specRsnCd[i]);
				if (specRsnFieldValue[i] != null)
					model.setSpecRsnFieldValue(specRsnFieldValue[i]);
				if (specRsnFieldFormat[i] != null)
					model.setSpecRsnFieldFormat(specRsnFieldFormat[i]);
				if (specRsnFieldLevel[i] != null)
					model.setSpecRsnFieldLevel(specRsnFieldLevel[i]);
				if (specRsnFieldSize[i] != null)
					model.setSpecRsnFieldSize(specRsnFieldSize[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aftExptDarNo[i] != null)
					model.setAftExptDarNo(aftExptDarNo[i]);
				if (specRsnFieldPopup[i] != null)
					model.setSpecRsnFieldPopup(specRsnFieldPopup[i]);
				if (specRsnFieldItem[i] != null)
					model.setSpecRsnFieldItem(specRsnFieldItem[i]);
				if (specRsnFieldName[i] != null)
					model.setSpecRsnFieldName(specRsnFieldName[i]);
				if (specRsnFieldType[i] != null)
					model.setSpecRsnFieldType(specRsnFieldType[i]);
				if (specRsnFieldCond[i] != null)
					model.setSpecRsnFieldCond(specRsnFieldCond[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBookingDetailReasonListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBookingDetailReasonListVO[]
	 */
	public AfterBookingDetailReasonListVO[] getAfterBookingDetailReasonListVOs(){
		AfterBookingDetailReasonListVO[] vos = (AfterBookingDetailReasonListVO[])models.toArray(new AfterBookingDetailReasonListVO[models.size()]);
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
		this.specRsnCd = this.specRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnFieldValue = this.specRsnFieldValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnFieldFormat = this.specRsnFieldFormat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnFieldLevel = this.specRsnFieldLevel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnFieldSize = this.specRsnFieldSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftExptDarNo = this.aftExptDarNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnFieldPopup = this.specRsnFieldPopup .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnFieldItem = this.specRsnFieldItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnFieldName = this.specRsnFieldName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnFieldType = this.specRsnFieldType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specRsnFieldCond = this.specRsnFieldCond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
