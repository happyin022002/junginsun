/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SearchFFBKGQTYInfoVO.java
*@FileTitle : SearchFFBKGQTYInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.19
*@LastModifier :
*@LastVersion : 1.0
* 2012.06.19
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.acm.acmcalculation.ffcommcalculation.vo;

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

public class SearchFFBKGQTYInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<SearchFFBKGQTYInfoVO> models = new ArrayList<SearchFFBKGQTYInfoVO>();

	/* Column Info */
	private String bkgRfeuQty = null;
	/* Column Info */
	private String bkgFeuQty = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgTeuQty = null;
	/* Column Info */
	private String bkgBxQty = null;
	/* Column Info */
	private String bkgRfQty = null;
	/* Column Info */
	private String bkgRteuQty = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public SearchFFBKGQTYInfoVO() {}

	public SearchFFBKGQTYInfoVO(String ibflag, String pagerows, String bkgTeuQty, String bkgFeuQty, String bkgRfQty, String bkgRteuQty, String bkgRfeuQty, String bkgBxQty) {
		this.bkgRfeuQty = bkgRfeuQty;
		this.bkgFeuQty = bkgFeuQty;
		this.ibflag = ibflag;
		this.bkgTeuQty = bkgTeuQty;
		this.bkgBxQty = bkgBxQty;
		this.bkgRfQty = bkgRfQty;
		this.bkgRteuQty = bkgRteuQty;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_rfeu_qty", getBkgRfeuQty());
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());
		this.hashColumns.put("bkg_bx_qty", getBkgBxQty());
		this.hashColumns.put("bkg_rf_qty", getBkgRfQty());
		this.hashColumns.put("bkg_rteu_qty", getBkgRteuQty());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_rfeu_qty", "bkgRfeuQty");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("bkg_bx_qty", "bkgBxQty");
		this.hashFields.put("bkg_rf_qty", "bkgRfQty");
		this.hashFields.put("bkg_rteu_qty", "bkgRteuQty");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return bkgRfeuQty
	 */
	public String getBkgRfeuQty() {
		return this.bkgRfeuQty;
	}

	/**
	 * Column Info
	 * @return bkgFeuQty
	 */
	public String getBkgFeuQty() {
		return this.bkgFeuQty;
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
	 * @return bkgTeuQty
	 */
	public String getBkgTeuQty() {
		return this.bkgTeuQty;
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
	 * @return bkgRfQty
	 */
	public String getBkgRfQty() {
		return this.bkgRfQty;
	}

	/**
	 * Column Info
	 * @return bkgRteuQty
	 */
	public String getBkgRteuQty() {
		return this.bkgRteuQty;
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
	 * @param bkgRfeuQty
	 */
	public void setBkgRfeuQty(String bkgRfeuQty) {
		this.bkgRfeuQty = bkgRfeuQty;
	}

	/**
	 * Column Info
	 * @param bkgFeuQty
	 */
	public void setBkgFeuQty(String bkgFeuQty) {
		this.bkgFeuQty = bkgFeuQty;
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
	 * @param bkgTeuQty
	 */
	public void setBkgTeuQty(String bkgTeuQty) {
		this.bkgTeuQty = bkgTeuQty;
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
	 * @param bkgRfQty
	 */
	public void setBkgRfQty(String bkgRfQty) {
		this.bkgRfQty = bkgRfQty;
	}

	/**
	 * Column Info
	 * @param bkgRteuQty
	 */
	public void setBkgRteuQty(String bkgRteuQty) {
		this.bkgRteuQty = bkgRteuQty;
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
		setBkgRfeuQty(JSPUtil.getParameter(request, prefix + "bkg_rfeu_qty", ""));
		setBkgFeuQty(JSPUtil.getParameter(request, prefix + "bkg_feu_qty", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgTeuQty(JSPUtil.getParameter(request, prefix + "bkg_teu_qty", ""));
		setBkgBxQty(JSPUtil.getParameter(request, prefix + "bkg_bx_qty", ""));
		setBkgRfQty(JSPUtil.getParameter(request, prefix + "bkg_rf_qty", ""));
		setBkgRteuQty(JSPUtil.getParameter(request, prefix + "bkg_rteu_qty", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFFBKGQTYInfoVO[]
	 */
	public SearchFFBKGQTYInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchFFBKGQTYInfoVO[]
	 */
	public SearchFFBKGQTYInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFFBKGQTYInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] bkgRfeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rfeu_qty", length));
			String[] bkgFeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_feu_qty", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgTeuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_teu_qty", length));
			String[] bkgBxQty = (JSPUtil.getParameter(request, prefix	+ "bkg_bx_qty", length));
			String[] bkgRfQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rf_qty", length));
			String[] bkgRteuQty = (JSPUtil.getParameter(request, prefix	+ "bkg_rteu_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new SearchFFBKGQTYInfoVO();
				if (bkgRfeuQty[i] != null)
					model.setBkgRfeuQty(bkgRfeuQty[i]);
				if (bkgFeuQty[i] != null)
					model.setBkgFeuQty(bkgFeuQty[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgTeuQty[i] != null)
					model.setBkgTeuQty(bkgTeuQty[i]);
				if (bkgBxQty[i] != null)
					model.setBkgBxQty(bkgBxQty[i]);
				if (bkgRfQty[i] != null)
					model.setBkgRfQty(bkgRfQty[i]);
				if (bkgRteuQty[i] != null)
					model.setBkgRteuQty(bkgRteuQty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFFBKGQTYInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFFBKGQTYInfoVO[]
	 */
	public SearchFFBKGQTYInfoVO[] getSearchFFBKGQTYInfoVOs(){
		SearchFFBKGQTYInfoVO[] vos = (SearchFFBKGQTYInfoVO[])models.toArray(new SearchFFBKGQTYInfoVO[models.size()]);
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
		this.bkgRfeuQty = this.bkgRfeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty = this.bkgFeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty = this.bkgTeuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBxQty = this.bkgBxQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRfQty = this.bkgRfQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRteuQty = this.bkgRteuQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
