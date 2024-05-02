/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SheetOptionSearchOptionVO.java
*@FileTitle : SheetOptionSearchOptionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.12.08 문중철 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 문중철
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SheetOptionSearchOptionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SheetOptionSearchOptionVO> models = new ArrayList<SheetOptionSearchOptionVO>();
	
	/* Column Info */
	private String cusvat = null;
	/* Column Info */
	private String dcamtr = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cusref = null;
	/* Column Info */
	private String toloca = null;
	/* Column Info */
	private String telfax = null;
	/* Column Info */
	private String isof = null;
	/* Column Info */
	private String rtovat = null;
	/* Column Info */
	private String taxrto = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SheetOptionSearchOptionVO() {}

	public SheetOptionSearchOptionVO(String ibflag, String pagerows, String cusvat, String cusref, String telfax, String toloca, String isof, String rtovat, String taxrto, String dcamtr) {
		this.cusvat = cusvat;
		this.dcamtr = dcamtr;
		this.ibflag = ibflag;
		this.cusref = cusref;
		this.toloca = toloca;
		this.telfax = telfax;
		this.isof = isof;
		this.rtovat = rtovat;
		this.taxrto = taxrto;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cusvat", getCusvat());
		this.hashColumns.put("dcamtr", getDcamtr());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cusref", getCusref());
		this.hashColumns.put("toloca", getToloca());
		this.hashColumns.put("telfax", getTelfax());
		this.hashColumns.put("isof", getIsof());
		this.hashColumns.put("rtovat", getRtovat());
		this.hashColumns.put("taxrto", getTaxrto());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cusvat", "cusvat");
		this.hashFields.put("dcamtr", "dcamtr");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cusref", "cusref");
		this.hashFields.put("toloca", "toloca");
		this.hashFields.put("telfax", "telfax");
		this.hashFields.put("isof", "isof");
		this.hashFields.put("rtovat", "rtovat");
		this.hashFields.put("taxrto", "taxrto");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cusvat
	 */
	public String getCusvat() {
		return this.cusvat;
	}
	
	/**
	 * Column Info
	 * @return dcamtr
	 */
	public String getDcamtr() {
		return this.dcamtr;
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
	 * @return cusref
	 */
	public String getCusref() {
		return this.cusref;
	}
	
	/**
	 * Column Info
	 * @return toloca
	 */
	public String getToloca() {
		return this.toloca;
	}
	
	/**
	 * Column Info
	 * @return telfax
	 */
	public String getTelfax() {
		return this.telfax;
	}
	
	/**
	 * Column Info
	 * @return isof
	 */
	public String getIsof() {
		return this.isof;
	}
	
	/**
	 * Column Info
	 * @return rtovat
	 */
	public String getRtovat() {
		return this.rtovat;
	}
	
	/**
	 * Column Info
	 * @return taxrto
	 */
	public String getTaxrto() {
		return this.taxrto;
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
	 * @param cusvat
	 */
	public void setCusvat(String cusvat) {
		this.cusvat = cusvat;
	}
	
	/**
	 * Column Info
	 * @param dcamtr
	 */
	public void setDcamtr(String dcamtr) {
		this.dcamtr = dcamtr;
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
	 * @param cusref
	 */
	public void setCusref(String cusref) {
		this.cusref = cusref;
	}
	
	/**
	 * Column Info
	 * @param toloca
	 */
	public void setToloca(String toloca) {
		this.toloca = toloca;
	}
	
	/**
	 * Column Info
	 * @param telfax
	 */
	public void setTelfax(String telfax) {
		this.telfax = telfax;
	}
	
	/**
	 * Column Info
	 * @param isof
	 */
	public void setIsof(String isof) {
		this.isof = isof;
	}
	
	/**
	 * Column Info
	 * @param rtovat
	 */
	public void setRtovat(String rtovat) {
		this.rtovat = rtovat;
	}
	
	/**
	 * Column Info
	 * @param taxrto
	 */
	public void setTaxrto(String taxrto) {
		this.taxrto = taxrto;
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
		setCusvat(JSPUtil.getParameter(request, "cusvat", ""));
		setDcamtr(JSPUtil.getParameter(request, "dcamtr", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCusref(JSPUtil.getParameter(request, "cusref", ""));
		setToloca(JSPUtil.getParameter(request, "toloca", ""));
		setTelfax(JSPUtil.getParameter(request, "telfax", ""));
		setIsof(JSPUtil.getParameter(request, "isof", ""));
		setRtovat(JSPUtil.getParameter(request, "rtovat", ""));
		setTaxrto(JSPUtil.getParameter(request, "taxrto", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SheetOptionSearchOptionVO[]
	 */
	public SheetOptionSearchOptionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SheetOptionSearchOptionVO[]
	 */
	public SheetOptionSearchOptionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SheetOptionSearchOptionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cusvat = (JSPUtil.getParameter(request, prefix	+ "cusvat", length));
			String[] dcamtr = (JSPUtil.getParameter(request, prefix	+ "dcamtr", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cusref = (JSPUtil.getParameter(request, prefix	+ "cusref", length));
			String[] toloca = (JSPUtil.getParameter(request, prefix	+ "toloca", length));
			String[] telfax = (JSPUtil.getParameter(request, prefix	+ "telfax", length));
			String[] isof = (JSPUtil.getParameter(request, prefix	+ "isof", length));
			String[] rtovat = (JSPUtil.getParameter(request, prefix	+ "rtovat", length));
			String[] taxrto = (JSPUtil.getParameter(request, prefix	+ "taxrto", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SheetOptionSearchOptionVO();
				if (cusvat[i] != null)
					model.setCusvat(cusvat[i]);
				if (dcamtr[i] != null)
					model.setDcamtr(dcamtr[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cusref[i] != null)
					model.setCusref(cusref[i]);
				if (toloca[i] != null)
					model.setToloca(toloca[i]);
				if (telfax[i] != null)
					model.setTelfax(telfax[i]);
				if (isof[i] != null)
					model.setIsof(isof[i]);
				if (rtovat[i] != null)
					model.setRtovat(rtovat[i]);
				if (taxrto[i] != null)
					model.setTaxrto(taxrto[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSheetOptionSearchOptionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SheetOptionSearchOptionVO[]
	 */
	public SheetOptionSearchOptionVO[] getSheetOptionSearchOptionVOs(){
		SheetOptionSearchOptionVO[] vos = (SheetOptionSearchOptionVO[])models.toArray(new SheetOptionSearchOptionVO[models.size()]);
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
		this.cusvat = this.cusvat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcamtr = this.dcamtr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cusref = this.cusref .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toloca = this.toloca .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.telfax = this.telfax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isof = this.isof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtovat = this.rtovat .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxrto = this.taxrto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
