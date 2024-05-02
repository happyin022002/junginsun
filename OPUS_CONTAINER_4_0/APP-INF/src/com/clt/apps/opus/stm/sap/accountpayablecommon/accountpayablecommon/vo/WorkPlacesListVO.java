/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : WorkPlacesListVO.java
*@FileTitle : WorkPlacesListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.28  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class WorkPlacesListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WorkPlacesListVO> models = new ArrayList<WorkPlacesListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String luCd = null;
	/* Column Info */
	private String luDesc = null;
	/* Column Info */
	private String registationNo = null;
	/* Column Info */
	private String corporateId = null;
	/* Column Info */
	private String taxablePerson = null;
	/* Column Info */
	private String industryClass = null;
	/* Column Info */
	private String industrySubclass = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public WorkPlacesListVO() {}

	public WorkPlacesListVO(String ibflag, String pagerows, String luCd, String luDesc, String registationNo, String corporateId, String taxablePerson, String industryClass, String industrySubclass) {
		this.ibflag = ibflag;
		this.luCd = luCd;
		this.luDesc = luDesc;
		this.registationNo = registationNo;
		this.corporateId = corporateId;
		this.taxablePerson = taxablePerson;
		this.industryClass = industryClass;
		this.industrySubclass = industrySubclass;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("lu_cd", getLuCd());
		this.hashColumns.put("lu_desc", getLuDesc());
		this.hashColumns.put("registation_no", getRegistationNo());
		this.hashColumns.put("corporate_id", getCorporateId());
		this.hashColumns.put("taxable_person", getTaxablePerson());
		this.hashColumns.put("industry_class", getIndustryClass());
		this.hashColumns.put("industry_subclass", getIndustrySubclass());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lu_cd", "luCd");
		this.hashFields.put("lu_desc", "luDesc");
		this.hashFields.put("registation_no", "registationNo");
		this.hashFields.put("corporate_id", "corporateId");
		this.hashFields.put("taxable_person", "taxablePerson");
		this.hashFields.put("industry_class", "industryClass");
		this.hashFields.put("industry_subclass", "industrySubclass");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return luCd
	 */
	public String getLuCd() {
		return this.luCd;
	}
	
	/**
	 * Column Info
	 * @return luDesc
	 */
	public String getLuDesc() {
		return this.luDesc;
	}
	
	/**
	 * Column Info
	 * @return registationNo
	 */
	public String getRegistationNo() {
		return this.registationNo;
	}
	
	/**
	 * Column Info
	 * @return corporateId
	 */
	public String getCorporateId() {
		return this.corporateId;
	}
	
	/**
	 * Column Info
	 * @return taxablePerson
	 */
	public String getTaxablePerson() {
		return this.taxablePerson;
	}
	
	/**
	 * Column Info
	 * @return industryClass
	 */
	public String getIndustryClass() {
		return this.industryClass;
	}
	
	/**
	 * Column Info
	 * @return industrySubclass
	 */
	public String getIndustrySubclass() {
		return this.industrySubclass;
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
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param luCd
	 */
	public void setLuCd(String luCd) {
		this.luCd = luCd;
	}
	
	/**
	 * Column Info
	 * @param luDesc
	 */
	public void setLuDesc(String luDesc) {
		this.luDesc = luDesc;
	}
	
	/**
	 * Column Info
	 * @param registationNo
	 */
	public void setRegistationNo(String registationNo) {
		this.registationNo = registationNo;
	}
	
	/**
	 * Column Info
	 * @param corporateId
	 */
	public void setCorporateId(String corporateId) {
		this.corporateId = corporateId;
	}
	
	/**
	 * Column Info
	 * @param taxablePerson
	 */
	public void setTaxablePerson(String taxablePerson) {
		this.taxablePerson = taxablePerson;
	}
	
	/**
	 * Column Info
	 * @param industryClass
	 */
	public void setIndustryClass(String industryClass) {
		this.industryClass = industryClass;
	}
	
	/**
	 * Column Info
	 * @param industrySubclass
	 */
	public void setIndustrySubclass(String industrySubclass) {
		this.industrySubclass = industrySubclass;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLuCd(JSPUtil.getParameter(request, prefix + "lu_cd", ""));
		setLuDesc(JSPUtil.getParameter(request, prefix + "lu_desc", ""));
		setRegistationNo(JSPUtil.getParameter(request, prefix + "registation_no", ""));
		setCorporateId(JSPUtil.getParameter(request, prefix + "corporate_id", ""));
		setTaxablePerson(JSPUtil.getParameter(request, prefix + "taxable_person", ""));
		setIndustryClass(JSPUtil.getParameter(request, prefix + "industry_class", ""));
		setIndustrySubclass(JSPUtil.getParameter(request, prefix + "industry_subclass", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WorkPlacesListVO[]
	 */
	public WorkPlacesListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WorkPlacesListVO[]
	 */
	public WorkPlacesListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WorkPlacesListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] luCd = (JSPUtil.getParameter(request, prefix	+ "lu_cd", length));
			String[] luDesc = (JSPUtil.getParameter(request, prefix	+ "lu_desc", length));
			String[] registationNo = (JSPUtil.getParameter(request, prefix	+ "registation_no", length));
			String[] corporateId = (JSPUtil.getParameter(request, prefix	+ "corporate_id", length));
			String[] taxablePerson = (JSPUtil.getParameter(request, prefix	+ "taxable_person", length));
			String[] industryClass = (JSPUtil.getParameter(request, prefix	+ "industry_class", length));
			String[] industrySubclass = (JSPUtil.getParameter(request, prefix	+ "industry_subclass", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new WorkPlacesListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (luCd[i] != null)
					model.setLuCd(luCd[i]);
				if (luDesc[i] != null)
					model.setLuDesc(luDesc[i]);
				if (registationNo[i] != null)
					model.setRegistationNo(registationNo[i]);
				if (corporateId[i] != null)
					model.setCorporateId(corporateId[i]);
				if (taxablePerson[i] != null)
					model.setTaxablePerson(taxablePerson[i]);
				if (industryClass[i] != null)
					model.setIndustryClass(industryClass[i]);
				if (industrySubclass[i] != null)
					model.setIndustrySubclass(industrySubclass[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWorkPlacesListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WorkPlacesListVO[]
	 */
	public WorkPlacesListVO[] getWorkPlacesListVOs(){
		WorkPlacesListVO[] vos = (WorkPlacesListVO[])models.toArray(new WorkPlacesListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.luCd = this.luCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.luDesc = this.luDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.registationNo = this.registationNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corporateId = this.corporateId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxablePerson = this.taxablePerson .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.industryClass = this.industryClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.industrySubclass = this.industrySubclass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
