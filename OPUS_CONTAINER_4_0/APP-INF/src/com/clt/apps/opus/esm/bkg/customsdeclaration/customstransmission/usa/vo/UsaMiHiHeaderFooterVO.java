/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : UsaMiHiHeaderFooterVO.java
*@FileTitle : UsaMiHiHeaderFooterVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.18
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.vo;

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

public class UsaMiHiHeaderFooterVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaMiHiHeaderFooterVO> models = new ArrayList<UsaMiHiHeaderFooterVO>();
	
	/* Column Info */
	private String footer = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String p01 = null;
	/* Column Info */
	private String j01 = null;
	/* Column Info */
	private String m01 = null;
	/* Column Info */
	private String m02 = null;
	/* Column Info */
	private String header = null;
	/* Column Info */
	private String acr = null;
	/* Column Info */
	private String zcr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UsaMiHiHeaderFooterVO() {}

	public UsaMiHiHeaderFooterVO(String ibflag, String pagerows, String acr, String m01, String m02, String p01, String j01, String zcr, String header, String footer) {
		this.footer = footer;
		this.ibflag = ibflag;
		this.p01 = p01;
		this.j01 = j01;
		this.m01 = m01;
		this.m02 = m02;
		this.header = header;
		this.acr = acr;
		this.zcr = zcr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("footer", getFooter());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("p01", getP01());
		this.hashColumns.put("j01", getJ01());
		this.hashColumns.put("m01", getM01());
		this.hashColumns.put("m02", getM02());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("acr", getAcr());
		this.hashColumns.put("zcr", getZcr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("footer", "footer");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("p01", "p01");
		this.hashFields.put("j01", "j01");
		this.hashFields.put("m01", "m01");
		this.hashFields.put("m02", "m02");
		this.hashFields.put("header", "header");
		this.hashFields.put("acr", "acr");
		this.hashFields.put("zcr", "zcr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return footer
	 */
	public String getFooter() {
		return this.footer;
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
	 * @return p01
	 */
	public String getP01() {
		return this.p01;
	}
	
	/**
	 * Column Info
	 * @return j01
	 */
	public String getJ01() {
		return this.j01;
	}
	
	/**
	 * Column Info
	 * @return m01
	 */
	public String getM01() {
		return this.m01;
	}
	
	/**
	 * Column Info
	 * @return m02
	 */
	public String getM02() {
		return this.m02;
	}
	
	/**
	 * Column Info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
	}
	
	/**
	 * Column Info
	 * @return acr
	 */
	public String getAcr() {
		return this.acr;
	}
	
	/**
	 * Column Info
	 * @return zcr
	 */
	public String getZcr() {
		return this.zcr;
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
	 * @param footer
	 */
	public void setFooter(String footer) {
		this.footer = footer;
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
	 * @param p01
	 */
	public void setP01(String p01) {
		this.p01 = p01;
	}
	
	/**
	 * Column Info
	 * @param j01
	 */
	public void setJ01(String j01) {
		this.j01 = j01;
	}
	
	/**
	 * Column Info
	 * @param m01
	 */
	public void setM01(String m01) {
		this.m01 = m01;
	}
	
	/**
	 * Column Info
	 * @param m02
	 */
	public void setM02(String m02) {
		this.m02 = m02;
	}
	
	/**
	 * Column Info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	/**
	 * Column Info
	 * @param acr
	 */
	public void setAcr(String acr) {
		this.acr = acr;
	}
	
	/**
	 * Column Info
	 * @param zcr
	 */
	public void setZcr(String zcr) {
		this.zcr = zcr;
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
		setFooter(JSPUtil.getParameter(request, prefix + "footer", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setP01(JSPUtil.getParameter(request, prefix + "p01", ""));
		setJ01(JSPUtil.getParameter(request, prefix + "j01", ""));
		setM01(JSPUtil.getParameter(request, prefix + "m01", ""));
		setM02(JSPUtil.getParameter(request, prefix + "m02", ""));
		setHeader(JSPUtil.getParameter(request, prefix + "header", ""));
		setAcr(JSPUtil.getParameter(request, prefix + "acr", ""));
		setZcr(JSPUtil.getParameter(request, prefix + "zcr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaMiHiHeaderFooterVO[]
	 */
	public UsaMiHiHeaderFooterVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaMiHiHeaderFooterVO[]
	 */
	public UsaMiHiHeaderFooterVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaMiHiHeaderFooterVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] footer = (JSPUtil.getParameter(request, prefix	+ "footer", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] p01 = (JSPUtil.getParameter(request, prefix	+ "p01", length));
			String[] j01 = (JSPUtil.getParameter(request, prefix	+ "j01", length));
			String[] m01 = (JSPUtil.getParameter(request, prefix	+ "m01", length));
			String[] m02 = (JSPUtil.getParameter(request, prefix	+ "m02", length));
			String[] header = (JSPUtil.getParameter(request, prefix	+ "header", length));
			String[] acr = (JSPUtil.getParameter(request, prefix	+ "acr", length));
			String[] zcr = (JSPUtil.getParameter(request, prefix	+ "zcr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaMiHiHeaderFooterVO();
				if (footer[i] != null)
					model.setFooter(footer[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (p01[i] != null)
					model.setP01(p01[i]);
				if (j01[i] != null)
					model.setJ01(j01[i]);
				if (m01[i] != null)
					model.setM01(m01[i]);
				if (m02[i] != null)
					model.setM02(m02[i]);
				if (header[i] != null)
					model.setHeader(header[i]);
				if (acr[i] != null)
					model.setAcr(acr[i]);
				if (zcr[i] != null)
					model.setZcr(zcr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaMiHiHeaderFooterVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaMiHiHeaderFooterVO[]
	 */
	public UsaMiHiHeaderFooterVO[] getUsaMiHiHeaderFooterVOs(){
		UsaMiHiHeaderFooterVO[] vos = (UsaMiHiHeaderFooterVO[])models.toArray(new UsaMiHiHeaderFooterVO[models.size()]);
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
		this.footer = this.footer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.p01 = this.p01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.j01 = this.j01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.m01 = this.m01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.m02 = this.m02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header = this.header .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acr = this.acr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zcr = this.zcr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
