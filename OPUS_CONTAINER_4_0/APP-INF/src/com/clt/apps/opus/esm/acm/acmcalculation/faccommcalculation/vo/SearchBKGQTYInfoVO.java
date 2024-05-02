/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchBKGQTYInfoVO.java
*@FileTitle : SearchBKGQTYInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.13
*@LastModifier :
*@LastVersion : 1.0
* 2012.06.13
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmcalculation.faccommcalculation.vo;

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
 * @author
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchBKGQTYInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchBKGQTYInfoVO> models = new ArrayList<SearchBKGQTYInfoVO>();

	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgDryFeuQty = null;
	/* Column Info */
	private String bkgDryTeuQty = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String bkgSpclFeuQty = null;
	/* Column Info */
	private String bkgRfFeuQty = null;
	/* Column Info */
	private String bkgRfTeuQty = null;
	/* Column Info */
	private String bkgSpclTeuQty = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchBKGQTYInfoVO() {}

	public SearchBKGQTYInfoVO(String ibflag, String pagerows, String bkgDryTeuQty, String bkgDryFeuQty, String bkgRfTeuQty, String bkgRfFeuQty, String bkgBxQty, String bkgSpclTeuQty, String bkgSpclFeuQty) {
		this.ibflag = ibflag;
		this.bkgDryFeuQty = bkgDryFeuQty;
		this.bkgDryTeuQty = bkgDryTeuQty;
		this.bkgBxQty = bkgBxQty;
		this.bkgSpclFeuQty = bkgSpclFeuQty;
		this.bkgRfFeuQty = bkgRfFeuQty;
		this.bkgRfTeuQty = bkgRfTeuQty;
		this.bkgSpclTeuQty = bkgSpclTeuQty;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_dry_feu_qty", getBkgDryFeuQty());
		this.hashColumns.put("bkg_dry_teu_qty", getBkgDryTeuQty());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("bkg_spcl_feu_qty", getBkgSpclFeuQty());
		this.hashColumns.put("bkg_rf_feu_qty", getBkgRfFeuQty());
		this.hashColumns.put("bkg_rf_teu_qty", getBkgRfTeuQty());
		this.hashColumns.put("bkg_spcl_teu_qty", getBkgSpclTeuQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_dry_feu_qty", "bkgDryFeuQty");
		this.hashFields.put("bkg_dry_teu_qty", "bkgDryTeuQty");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("bkg_spcl_feu_qty", "bkgSpclFeuQty");
		this.hashFields.put("bkg_rf_feu_qty", "bkgRfFeuQty");
		this.hashFields.put("bkg_rf_teu_qty", "bkgRfTeuQty");
		this.hashFields.put("bkg_spcl_teu_qty", "bkgSpclTeuQty");
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
	 * @return bkgDryFeuQty
	 */
	public String getBkgDryFeuQty() {
		return this.bkgDryFeuQty;
	}

	/**
	 * Column Info
	 * @return bkgDryTeuQty
	 */
	public String getBkgDryTeuQty() {
		return this.bkgDryTeuQty;
	}

	/**
	 * Column Info
	 * @return bkgBxQty
	 */
	public String getBkgBxQty() {
		return this.bkgBxQty;
	}

	/**
	 * Column Info
	 * @return bkgSpclFeuQty
	 */
	public String getBkgSpclFeuQty() {
		return this.bkgSpclFeuQty;
	}

	/**
	 * Column Info
	 * @return bkgRfFeuQty
	 */
	public String getBkgRfFeuQty() {
		return this.bkgRfFeuQty;
	}

	/**
	 * Column Info
	 * @return bkgRfTeuQty
	 */
	public String getBkgRfTeuQty() {
		return this.bkgRfTeuQty;
	}

	/**
	 * Column Info
	 * @return bkgSpclTeuQty
	 */
	public String getBkgSpclTeuQty() {
		return this.bkgSpclTeuQty;
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
	 * @param bkgDryFeuQty
	 */
	public void setBkgDryFeuQty(String bkgDryFeuQty) {
		this.bkgDryFeuQty = bkgDryFeuQty;
	}

	/**
	 * Column Info
	 * @param bkgDryTeuQty
	 */
	public void setBkgDryTeuQty(String bkgDryTeuQty) {
		this.bkgDryTeuQty = bkgDryTeuQty;
	}

	/**
	 * Column Info
	 * @param bkgBxQty
	 */
	public void setBkgBxQty(String bkgBxQty) {
		this.bkgBxQty = bkgBxQty;
	}

	/**
	 * Column Info
	 * @param bkgSpclFeuQty
	 */
	public void setBkgSpclFeuQty(String bkgSpclFeuQty) {
		this.bkgSpclFeuQty = bkgSpclFeuQty;
	}

	/**
	 * Column Info
	 * @param bkgRfFeuQty
	 */
	public void setBkgRfFeuQty(String bkgRfFeuQty) {
		this.bkgRfFeuQty = bkgRfFeuQty;
	}

	/**
	 * Column Info
	 * @param bkgRfTeuQty
	 */
	public void setBkgRfTeuQty(String bkgRfTeuQty) {
		this.bkgRfTeuQty = bkgRfTeuQty;
	}

	/**
	 * Column Info
	 * @param bkgSpclTeuQty
	 */
	public void setBkgSpclTeuQty(String bkgSpclTeuQty) {
		this.bkgSpclTeuQty = bkgSpclTeuQty;
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
		setBkgDryFeuQty(JSPUtil.getParameter(request, prefix + "bkg_dry_feu_qty", ""));
		setBkgDryTeuQty(JSPUtil.getParameter(request, prefix + "bkg_dry_teu_qty", ""));
		setBkgBxQty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setBkgSpclFeuQty(JSPUtil.getParameter(request, prefix + "bkg_spcl_feu_qty", ""));
		setBkgRfFeuQty(JSPUtil.getParameter(request, prefix + "bkg_rf_feu_qty", ""));
		setBkgRfTeuQty(JSPUtil.getParameter(request, prefix + "bkg_rf_teu_qty", ""));
		setBkgSpclTeuQty(JSPUtil.getParameter(request, prefix + "bkg_spcl_teu_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBKGQTYInfoVO[]
	 */
	public SearchBKGQTYInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchBKGQTYInfoVO[]
	 */
	public SearchBKGQTYInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchBKGQTYInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgDryFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_dry_feu_qty", length));
			String[] bkgDryTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_dry_teu_qty", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] bkgSpclFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_spcl_feu_qty", length));
			String[] bkgRfFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_feu_qty", length));
			String[] bkgRfTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_teu_qty", length));
			String[] bkgSpclTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_spcl_teu_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new SearchBKGQTYInfoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgDryFeuQty[i] != null)
					model.setBkgDryFeuQty(bkgDryFeuQty[i]);
				if (bkgDryTeuQty[i] != null)
					model.setBkgDryTeuQty(bkgDryTeuQty[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (bkgSpclFeuQty[i] != null)
					model.setBkgSpclFeuQty(bkgSpclFeuQty[i]);
				if (bkgRfFeuQty[i] != null)
					model.setBkgRfFeuQty(bkgRfFeuQty[i]);
				if (bkgRfTeuQty[i] != null)
					model.setBkgRfTeuQty(bkgRfTeuQty[i]);
				if (bkgSpclTeuQty[i] != null)
					model.setBkgSpclTeuQty(bkgSpclTeuQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBKGQTYInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBKGQTYInfoVO[]
	 */
	public SearchBKGQTYInfoVO[] getSearchBKGQTYInfoVOs(){
		SearchBKGQTYInfoVO[] vos = (SearchBKGQTYInfoVO[])models.toArray(new SearchBKGQTYInfoVO[models.size()]);
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
		this.bkgDryFeuQty = this.bkgDryFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDryTeuQty = this.bkgDryTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpclFeuQty = this.bkgSpclFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfFeuQty = this.bkgRfFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfTeuQty = this.bkgRfTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSpclTeuQty = this.bkgSpclTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
