/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ADIDASEdiCustInfoVO.java
*@FileTitle : ADIDASEdiCustInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.11  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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

public class ADIDASEdiCustInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ADIDASEdiCustInfoVO> models = new ArrayList<ADIDASEdiCustInfoVO>();
	
	/* Column Info */
	private String ptName = null;
	/* Column Info */
	private String ptBa = null;
	/* Column Info */
	private String ptZipCd = null;
	/* Column Info */
	private String ptVatId = null;
	/* Column Info */
	private String ptEml = null;
	/* Column Info */
	private String ptCountryCd = null;
	/* Column Info */
	private String ptAddress1 = null;
	/* Column Info */
	private String ptAddress3 = null;
	/* Column Info */
	private String ptAddress2 = null;
	/* Column Info */
	private String ptCd = null;
	/* Column Info */
	private String ptAddress4 = null;
	/* Column Info */
	private String ptStProvCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ptCityName = null;
	/* Column Info */
	private String ptAddress = null;
	/* Column Info */
	private String ptType = null;
	/* Column Info */
	private String ptTel = null;
	/* Column Info */
	private String ptFax = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ADIDASEdiCustInfoVO() {}

	public ADIDASEdiCustInfoVO(String ibflag, String pagerows, String ptType, String ptCd, String ptName, String ptAddress, String ptAddress1, String ptAddress2, String ptAddress3, String ptAddress4, String ptVatId, String ptCityName, String ptStProvCd, String ptZipCd, String ptCountryCd, String ptEml, String ptFax, String ptTel, String ptBa) {
		this.ptName = ptName;
		this.ptBa = ptBa;
		this.ptZipCd = ptZipCd;
		this.ptVatId = ptVatId;
		this.ptEml = ptEml;
		this.ptCountryCd = ptCountryCd;
		this.ptAddress1 = ptAddress1;
		this.ptAddress3 = ptAddress3;
		this.ptAddress2 = ptAddress2;
		this.ptCd = ptCd;
		this.ptAddress4 = ptAddress4;
		this.ptStProvCd = ptStProvCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ptCityName = ptCityName;
		this.ptAddress = ptAddress;
		this.ptType = ptType;
		this.ptTel = ptTel;
		this.ptFax = ptFax;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pt_name", getPtName());
		this.hashColumns.put("pt_ba", getPtBa());
		this.hashColumns.put("pt_zip_cd", getPtZipCd());
		this.hashColumns.put("pt_vat_id", getPtVatId());
		this.hashColumns.put("pt_eml", getPtEml());
		this.hashColumns.put("pt_country_cd", getPtCountryCd());
		this.hashColumns.put("pt_address1", getPtAddress1());
		this.hashColumns.put("pt_address3", getPtAddress3());
		this.hashColumns.put("pt_address2", getPtAddress2());
		this.hashColumns.put("pt_cd", getPtCd());
		this.hashColumns.put("pt_address4", getPtAddress4());
		this.hashColumns.put("pt_st_prov_cd", getPtStProvCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pt_city_name", getPtCityName());
		this.hashColumns.put("pt_address", getPtAddress());
		this.hashColumns.put("pt_type", getPtType());
		this.hashColumns.put("pt_tel", getPtTel());
		this.hashColumns.put("pt_fax", getPtFax());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pt_name", "ptName");
		this.hashFields.put("pt_ba", "ptBa");
		this.hashFields.put("pt_zip_cd", "ptZipCd");
		this.hashFields.put("pt_vat_id", "ptVatId");
		this.hashFields.put("pt_eml", "ptEml");
		this.hashFields.put("pt_country_cd", "ptCountryCd");
		this.hashFields.put("pt_address1", "ptAddress1");
		this.hashFields.put("pt_address3", "ptAddress3");
		this.hashFields.put("pt_address2", "ptAddress2");
		this.hashFields.put("pt_cd", "ptCd");
		this.hashFields.put("pt_address4", "ptAddress4");
		this.hashFields.put("pt_st_prov_cd", "ptStProvCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pt_city_name", "ptCityName");
		this.hashFields.put("pt_address", "ptAddress");
		this.hashFields.put("pt_type", "ptType");
		this.hashFields.put("pt_tel", "ptTel");
		this.hashFields.put("pt_fax", "ptFax");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ptName
	 */
	public String getPtName() {
		return this.ptName;
	}
	
	/**
	 * Column Info
	 * @return ptBa
	 */
	public String getPtBa() {
		return this.ptBa;
	}
	
	/**
	 * Column Info
	 * @return ptZipCd
	 */
	public String getPtZipCd() {
		return this.ptZipCd;
	}
	
	/**
	 * Column Info
	 * @return ptVatId
	 */
	public String getPtVatId() {
		return this.ptVatId;
	}
	
	/**
	 * Column Info
	 * @return ptEml
	 */
	public String getPtEml() {
		return this.ptEml;
	}
	
	/**
	 * Column Info
	 * @return ptCountryCd
	 */
	public String getPtCountryCd() {
		return this.ptCountryCd;
	}
	
	/**
	 * Column Info
	 * @return ptAddress1
	 */
	public String getPtAddress1() {
		return this.ptAddress1;
	}
	
	/**
	 * Column Info
	 * @return ptAddress3
	 */
	public String getPtAddress3() {
		return this.ptAddress3;
	}
	
	/**
	 * Column Info
	 * @return ptAddress2
	 */
	public String getPtAddress2() {
		return this.ptAddress2;
	}
	
	/**
	 * Column Info
	 * @return ptCd
	 */
	public String getPtCd() {
		return this.ptCd;
	}
	
	/**
	 * Column Info
	 * @return ptAddress4
	 */
	public String getPtAddress4() {
		return this.ptAddress4;
	}
	
	/**
	 * Column Info
	 * @return ptStProvCd
	 */
	public String getPtStProvCd() {
		return this.ptStProvCd;
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
	 * @return ptCityName
	 */
	public String getPtCityName() {
		return this.ptCityName;
	}
	
	/**
	 * Column Info
	 * @return ptAddress
	 */
	public String getPtAddress() {
		return this.ptAddress;
	}
	
	/**
	 * Column Info
	 * @return ptType
	 */
	public String getPtType() {
		return this.ptType;
	}
	
	/**
	 * Column Info
	 * @return ptTel
	 */
	public String getPtTel() {
		return this.ptTel;
	}
	
	/**
	 * Column Info
	 * @return ptFax
	 */
	public String getPtFax() {
		return this.ptFax;
	}
	

	/**
	 * Column Info
	 * @param ptName
	 */
	public void setPtName(String ptName) {
		this.ptName = ptName;
	}
	
	/**
	 * Column Info
	 * @param ptBa
	 */
	public void setPtBa(String ptBa) {
		this.ptBa = ptBa;
	}
	
	/**
	 * Column Info
	 * @param ptZipCd
	 */
	public void setPtZipCd(String ptZipCd) {
		this.ptZipCd = ptZipCd;
	}
	
	/**
	 * Column Info
	 * @param ptVatId
	 */
	public void setPtVatId(String ptVatId) {
		this.ptVatId = ptVatId;
	}
	
	/**
	 * Column Info
	 * @param ptEml
	 */
	public void setPtEml(String ptEml) {
		this.ptEml = ptEml;
	}
	
	/**
	 * Column Info
	 * @param ptCountryCd
	 */
	public void setPtCountryCd(String ptCountryCd) {
		this.ptCountryCd = ptCountryCd;
	}
	
	/**
	 * Column Info
	 * @param ptAddress1
	 */
	public void setPtAddress1(String ptAddress1) {
		this.ptAddress1 = ptAddress1;
	}
	
	/**
	 * Column Info
	 * @param ptAddress3
	 */
	public void setPtAddress3(String ptAddress3) {
		this.ptAddress3 = ptAddress3;
	}
	
	/**
	 * Column Info
	 * @param ptAddress2
	 */
	public void setPtAddress2(String ptAddress2) {
		this.ptAddress2 = ptAddress2;
	}
	
	/**
	 * Column Info
	 * @param ptCd
	 */
	public void setPtCd(String ptCd) {
		this.ptCd = ptCd;
	}
	
	/**
	 * Column Info
	 * @param ptAddress4
	 */
	public void setPtAddress4(String ptAddress4) {
		this.ptAddress4 = ptAddress4;
	}
	
	/**
	 * Column Info
	 * @param ptStProvCd
	 */
	public void setPtStProvCd(String ptStProvCd) {
		this.ptStProvCd = ptStProvCd;
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
	 * @param ptCityName
	 */
	public void setPtCityName(String ptCityName) {
		this.ptCityName = ptCityName;
	}
	
	/**
	 * Column Info
	 * @param ptAddress
	 */
	public void setPtAddress(String ptAddress) {
		this.ptAddress = ptAddress;
	}
	
	/**
	 * Column Info
	 * @param ptType
	 */
	public void setPtType(String ptType) {
		this.ptType = ptType;
	}
	
	/**
	 * Column Info
	 * @param ptTel
	 */
	public void setPtTel(String ptTel) {
		this.ptTel = ptTel;
	}
	
	/**
	 * Column Info
	 * @param ptFax
	 */
	public void setPtFax(String ptFax) {
		this.ptFax = ptFax;
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
		setPtName(JSPUtil.getParameter(request, prefix + "pt_name", ""));
		setPtBa(JSPUtil.getParameter(request, prefix + "pt_ba", ""));
		setPtZipCd(JSPUtil.getParameter(request, prefix + "pt_zip_cd", ""));
		setPtVatId(JSPUtil.getParameter(request, prefix + "pt_vat_id", ""));
		setPtEml(JSPUtil.getParameter(request, prefix + "pt_eml", ""));
		setPtCountryCd(JSPUtil.getParameter(request, prefix + "pt_country_cd", ""));
		setPtAddress1(JSPUtil.getParameter(request, prefix + "pt_address1", ""));
		setPtAddress3(JSPUtil.getParameter(request, prefix + "pt_address3", ""));
		setPtAddress2(JSPUtil.getParameter(request, prefix + "pt_address2", ""));
		setPtCd(JSPUtil.getParameter(request, prefix + "pt_cd", ""));
		setPtAddress4(JSPUtil.getParameter(request, prefix + "pt_address4", ""));
		setPtStProvCd(JSPUtil.getParameter(request, prefix + "pt_st_prov_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPtCityName(JSPUtil.getParameter(request, prefix + "pt_city_name", ""));
		setPtAddress(JSPUtil.getParameter(request, prefix + "pt_address", ""));
		setPtType(JSPUtil.getParameter(request, prefix + "pt_type", ""));
		setPtTel(JSPUtil.getParameter(request, prefix + "pt_tel", ""));
		setPtFax(JSPUtil.getParameter(request, prefix + "pt_fax", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ADIDASEdiCustInfoVO[]
	 */
	public ADIDASEdiCustInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ADIDASEdiCustInfoVO[]
	 */
	public ADIDASEdiCustInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ADIDASEdiCustInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ptName = (JSPUtil.getParameter(request, prefix	+ "pt_name", length));
			String[] ptBa = (JSPUtil.getParameter(request, prefix	+ "pt_ba", length));
			String[] ptZipCd = (JSPUtil.getParameter(request, prefix	+ "pt_zip_cd", length));
			String[] ptVatId = (JSPUtil.getParameter(request, prefix	+ "pt_vat_id", length));
			String[] ptEml = (JSPUtil.getParameter(request, prefix	+ "pt_eml", length));
			String[] ptCountryCd = (JSPUtil.getParameter(request, prefix	+ "pt_country_cd", length));
			String[] ptAddress1 = (JSPUtil.getParameter(request, prefix	+ "pt_address1", length));
			String[] ptAddress3 = (JSPUtil.getParameter(request, prefix	+ "pt_address3", length));
			String[] ptAddress2 = (JSPUtil.getParameter(request, prefix	+ "pt_address2", length));
			String[] ptCd = (JSPUtil.getParameter(request, prefix	+ "pt_cd", length));
			String[] ptAddress4 = (JSPUtil.getParameter(request, prefix	+ "pt_address4", length));
			String[] ptStProvCd = (JSPUtil.getParameter(request, prefix	+ "pt_st_prov_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ptCityName = (JSPUtil.getParameter(request, prefix	+ "pt_city_name", length));
			String[] ptAddress = (JSPUtil.getParameter(request, prefix	+ "pt_address", length));
			String[] ptType = (JSPUtil.getParameter(request, prefix	+ "pt_type", length));
			String[] ptTel = (JSPUtil.getParameter(request, prefix	+ "pt_tel", length));
			String[] ptFax = (JSPUtil.getParameter(request, prefix	+ "pt_fax", length));
			
			for (int i = 0; i < length; i++) {
				model = new ADIDASEdiCustInfoVO();
				if (ptName[i] != null)
					model.setPtName(ptName[i]);
				if (ptBa[i] != null)
					model.setPtBa(ptBa[i]);
				if (ptZipCd[i] != null)
					model.setPtZipCd(ptZipCd[i]);
				if (ptVatId[i] != null)
					model.setPtVatId(ptVatId[i]);
				if (ptEml[i] != null)
					model.setPtEml(ptEml[i]);
				if (ptCountryCd[i] != null)
					model.setPtCountryCd(ptCountryCd[i]);
				if (ptAddress1[i] != null)
					model.setPtAddress1(ptAddress1[i]);
				if (ptAddress3[i] != null)
					model.setPtAddress3(ptAddress3[i]);
				if (ptAddress2[i] != null)
					model.setPtAddress2(ptAddress2[i]);
				if (ptCd[i] != null)
					model.setPtCd(ptCd[i]);
				if (ptAddress4[i] != null)
					model.setPtAddress4(ptAddress4[i]);
				if (ptStProvCd[i] != null)
					model.setPtStProvCd(ptStProvCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ptCityName[i] != null)
					model.setPtCityName(ptCityName[i]);
				if (ptAddress[i] != null)
					model.setPtAddress(ptAddress[i]);
				if (ptType[i] != null)
					model.setPtType(ptType[i]);
				if (ptTel[i] != null)
					model.setPtTel(ptTel[i]);
				if (ptFax[i] != null)
					model.setPtFax(ptFax[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getADIDASEdiCustInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ADIDASEdiCustInfoVO[]
	 */
	public ADIDASEdiCustInfoVO[] getADIDASEdiCustInfoVOs(){
		ADIDASEdiCustInfoVO[] vos = (ADIDASEdiCustInfoVO[])models.toArray(new ADIDASEdiCustInfoVO[models.size()]);
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
		this.ptName = this.ptName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptBa = this.ptBa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptZipCd = this.ptZipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptVatId = this.ptVatId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptEml = this.ptEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptCountryCd = this.ptCountryCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress1 = this.ptAddress1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress3 = this.ptAddress3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress2 = this.ptAddress2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptCd = this.ptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress4 = this.ptAddress4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptStProvCd = this.ptStProvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptCityName = this.ptCityName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptAddress = this.ptAddress .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptType = this.ptType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptTel = this.ptTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptFax = this.ptFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
