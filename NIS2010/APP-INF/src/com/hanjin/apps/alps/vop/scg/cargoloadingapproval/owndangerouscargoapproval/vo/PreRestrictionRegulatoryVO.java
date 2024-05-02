/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PreRestrictionRegulatoryVO.java
*@FileTitle : PreRestrictionRegulatoryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.15
*@LastModifier : 
*@LastVersion : 1.0
* 2013.03.15  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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

public class PreRestrictionRegulatoryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PreRestrictionRegulatoryVO> models = new ArrayList<PreRestrictionRegulatoryVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String pkgTpNm = null;
	/* Column Info */
	private String maxWgtRslt = null;
	/* Column Info */
	private String maxWgtNm = null;
	/* Column Info */
	private String reguVal = null;
	/* Column Info */
	private String pkgTpRslt = null;
	/* Column Info */
	private String divNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PreRestrictionRegulatoryVO() {}

	public PreRestrictionRegulatoryVO(String ibflag, String pagerows, String divNm, String reguVal, String maxWgtNm, String maxWgtRslt, String pkgTpNm, String pkgTpRslt) {
		this.ibflag = ibflag;
		this.pkgTpNm = pkgTpNm;
		this.maxWgtRslt = maxWgtRslt;
		this.maxWgtNm = maxWgtNm;
		this.reguVal = reguVal;
		this.pkgTpRslt = pkgTpRslt;
		this.divNm = divNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pkg_tp_nm", getPkgTpNm());
		this.hashColumns.put("max_wgt_rslt", getMaxWgtRslt());
		this.hashColumns.put("max_wgt_nm", getMaxWgtNm());
		this.hashColumns.put("regu_val", getReguVal());
		this.hashColumns.put("pkg_tp_rslt", getPkgTpRslt());
		this.hashColumns.put("div_nm", getDivNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pkg_tp_nm", "pkgTpNm");
		this.hashFields.put("max_wgt_rslt", "maxWgtRslt");
		this.hashFields.put("max_wgt_nm", "maxWgtNm");
		this.hashFields.put("regu_val", "reguVal");
		this.hashFields.put("pkg_tp_rslt", "pkgTpRslt");
		this.hashFields.put("div_nm", "divNm");
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
	 * @return pkgTpNm
	 */
	public String getPkgTpNm() {
		return this.pkgTpNm;
	}
	
	/**
	 * Column Info
	 * @return maxWgtRslt
	 */
	public String getMaxWgtRslt() {
		return this.maxWgtRslt;
	}
	
	/**
	 * Column Info
	 * @return maxWgtNm
	 */
	public String getMaxWgtNm() {
		return this.maxWgtNm;
	}
	
	/**
	 * Column Info
	 * @return reguVal
	 */
	public String getReguVal() {
		return this.reguVal;
	}
	
	/**
	 * Column Info
	 * @return pkgTpRslt
	 */
	public String getPkgTpRslt() {
		return this.pkgTpRslt;
	}
	
	/**
	 * Column Info
	 * @return divNm
	 */
	public String getDivNm() {
		return this.divNm;
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
	 * @param pkgTpNm
	 */
	public void setPkgTpNm(String pkgTpNm) {
		this.pkgTpNm = pkgTpNm;
	}
	
	/**
	 * Column Info
	 * @param maxWgtRslt
	 */
	public void setMaxWgtRslt(String maxWgtRslt) {
		this.maxWgtRslt = maxWgtRslt;
	}
	
	/**
	 * Column Info
	 * @param maxWgtNm
	 */
	public void setMaxWgtNm(String maxWgtNm) {
		this.maxWgtNm = maxWgtNm;
	}
	
	/**
	 * Column Info
	 * @param reguVal
	 */
	public void setReguVal(String reguVal) {
		this.reguVal = reguVal;
	}
	
	/**
	 * Column Info
	 * @param pkgTpRslt
	 */
	public void setPkgTpRslt(String pkgTpRslt) {
		this.pkgTpRslt = pkgTpRslt;
	}
	
	/**
	 * Column Info
	 * @param divNm
	 */
	public void setDivNm(String divNm) {
		this.divNm = divNm;
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
		setPkgTpNm(JSPUtil.getParameter(request, prefix + "pkg_tp_nm", ""));
		setMaxWgtRslt(JSPUtil.getParameter(request, prefix + "max_wgt_rslt", ""));
		setMaxWgtNm(JSPUtil.getParameter(request, prefix + "max_wgt_nm", ""));
		setReguVal(JSPUtil.getParameter(request, prefix + "regu_val", ""));
		setPkgTpRslt(JSPUtil.getParameter(request, prefix + "pkg_tp_rslt", ""));
		setDivNm(JSPUtil.getParameter(request, prefix + "div_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PreRestrictionRegulatoryVO[]
	 */
	public PreRestrictionRegulatoryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PreRestrictionRegulatoryVO[]
	 */
	public PreRestrictionRegulatoryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PreRestrictionRegulatoryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pkgTpNm = (JSPUtil.getParameter(request, prefix	+ "pkg_tp_nm", length));
			String[] maxWgtRslt = (JSPUtil.getParameter(request, prefix	+ "max_wgt_rslt", length));
			String[] maxWgtNm = (JSPUtil.getParameter(request, prefix	+ "max_wgt_nm", length));
			String[] reguVal = (JSPUtil.getParameter(request, prefix	+ "regu_val", length));
			String[] pkgTpRslt = (JSPUtil.getParameter(request, prefix	+ "pkg_tp_rslt", length));
			String[] divNm = (JSPUtil.getParameter(request, prefix	+ "div_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PreRestrictionRegulatoryVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (pkgTpNm[i] != null)
					model.setPkgTpNm(pkgTpNm[i]);
				if (maxWgtRslt[i] != null)
					model.setMaxWgtRslt(maxWgtRslt[i]);
				if (maxWgtNm[i] != null)
					model.setMaxWgtNm(maxWgtNm[i]);
				if (reguVal[i] != null)
					model.setReguVal(reguVal[i]);
				if (pkgTpRslt[i] != null)
					model.setPkgTpRslt(pkgTpRslt[i]);
				if (divNm[i] != null)
					model.setDivNm(divNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPreRestrictionRegulatoryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PreRestrictionRegulatoryVO[]
	 */
	public PreRestrictionRegulatoryVO[] getPreRestrictionRegulatoryVOs(){
		PreRestrictionRegulatoryVO[] vos = (PreRestrictionRegulatoryVO[])models.toArray(new PreRestrictionRegulatoryVO[models.size()]);
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
		this.pkgTpNm = this.pkgTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxWgtRslt = this.maxWgtRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxWgtNm = this.maxWgtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reguVal = this.reguVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgTpRslt = this.pkgTpRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divNm = this.divNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
