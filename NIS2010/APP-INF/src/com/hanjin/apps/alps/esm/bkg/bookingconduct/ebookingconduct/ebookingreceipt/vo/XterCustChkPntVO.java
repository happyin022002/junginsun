/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : XterCustChkPntVO.java
*@FileTitle : XterCustChkPntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.08
*@LastModifier : Do Soon Choi
*@LastVersion : 1.0
* 2015.07.08 Do Soon Choi 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

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
 * @author Do Soon Choi
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class XterCustChkPntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<XterCustChkPntVO> models = new ArrayList<XterCustChkPntVO>();
	
	/* Column Info */
	private String coYn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String mdYn = null;
	/* Column Info */
	private String cuYn = null;
	/* Column Info */
	private String cmYn = null;
	/* Column Info */
	private String raYn = null;
	/* Column Info */
	private String emYn = null;
	/* Column Info */
	private String cnYn = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public XterCustChkPntVO() {}

	public XterCustChkPntVO(String ibflag, String pagerows, String cuYn, String cnYn, String mdYn, String cmYn, String emYn, String raYn, String coYn) {
		this.coYn = coYn;
		this.ibflag = ibflag;
		this.mdYn = mdYn;
		this.cuYn = cuYn;
		this.cmYn = cmYn;
		this.raYn = raYn;
		this.emYn = emYn;
		this.cnYn = cnYn;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("co_yn", getCoYn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("md_yn", getMdYn());
		this.hashColumns.put("cu_yn", getCuYn());
		this.hashColumns.put("cm_yn", getCmYn());
		this.hashColumns.put("ra_yn", getRaYn());
		this.hashColumns.put("em_yn", getEmYn());
		this.hashColumns.put("cn_yn", getCnYn());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("co_yn", "coYn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("md_yn", "mdYn");
		this.hashFields.put("cu_yn", "cuYn");
		this.hashFields.put("cm_yn", "cmYn");
		this.hashFields.put("ra_yn", "raYn");
		this.hashFields.put("em_yn", "emYn");
		this.hashFields.put("cn_yn", "cnYn");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return coYn
	 */
	public String getCoYn() {
		return this.coYn;
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
	 * @return mdYn
	 */
	public String getMdYn() {
		return this.mdYn;
	}
	
	/**
	 * Column Info
	 * @return cuYn
	 */
	public String getCuYn() {
		return this.cuYn;
	}
	
	/**
	 * Column Info
	 * @return cmYn
	 */
	public String getCmYn() {
		return this.cmYn;
	}
	
	/**
	 * Column Info
	 * @return raYn
	 */
	public String getRaYn() {
		return this.raYn;
	}
	
	/**
	 * Column Info
	 * @return emYn
	 */
	public String getEmYn() {
		return this.emYn;
	}
	
	/**
	 * Column Info
	 * @return cnYn
	 */
	public String getCnYn() {
		return this.cnYn;
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
	 * @param coYn
	 */
	public void setCoYn(String coYn) {
		this.coYn = coYn;
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
	 * @param mdYn
	 */
	public void setMdYn(String mdYn) {
		this.mdYn = mdYn;
	}
	
	/**
	 * Column Info
	 * @param cuYn
	 */
	public void setCuYn(String cuYn) {
		this.cuYn = cuYn;
	}
	
	/**
	 * Column Info
	 * @param cmYn
	 */
	public void setCmYn(String cmYn) {
		this.cmYn = cmYn;
	}
	
	/**
	 * Column Info
	 * @param raYn
	 */
	public void setRaYn(String raYn) {
		this.raYn = raYn;
	}
	
	/**
	 * Column Info
	 * @param emYn
	 */
	public void setEmYn(String emYn) {
		this.emYn = emYn;
	}
	
	/**
	 * Column Info
	 * @param cnYn
	 */
	public void setCnYn(String cnYn) {
		this.cnYn = cnYn;
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
		setCoYn(JSPUtil.getParameter(request, prefix + "co_yn", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMdYn(JSPUtil.getParameter(request, prefix + "md_yn", ""));
		setCuYn(JSPUtil.getParameter(request, prefix + "cu_yn", ""));
		setCmYn(JSPUtil.getParameter(request, prefix + "cm_yn", ""));
		setRaYn(JSPUtil.getParameter(request, prefix + "ra_yn", ""));
		setEmYn(JSPUtil.getParameter(request, prefix + "em_yn", ""));
		setCnYn(JSPUtil.getParameter(request, prefix + "cn_yn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return XterCustChkPntVO[]
	 */
	public XterCustChkPntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return XterCustChkPntVO[]
	 */
	public XterCustChkPntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		XterCustChkPntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] coYn = (JSPUtil.getParameter(request, prefix	+ "co_yn", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] mdYn = (JSPUtil.getParameter(request, prefix	+ "md_yn", length));
			String[] cuYn = (JSPUtil.getParameter(request, prefix	+ "cu_yn", length));
			String[] cmYn = (JSPUtil.getParameter(request, prefix	+ "cm_yn", length));
			String[] raYn = (JSPUtil.getParameter(request, prefix	+ "ra_yn", length));
			String[] emYn = (JSPUtil.getParameter(request, prefix	+ "em_yn", length));
			String[] cnYn = (JSPUtil.getParameter(request, prefix	+ "cn_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new XterCustChkPntVO();
				if (coYn[i] != null)
					model.setCoYn(coYn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (mdYn[i] != null)
					model.setMdYn(mdYn[i]);
				if (cuYn[i] != null)
					model.setCuYn(cuYn[i]);
				if (cmYn[i] != null)
					model.setCmYn(cmYn[i]);
				if (raYn[i] != null)
					model.setRaYn(raYn[i]);
				if (emYn[i] != null)
					model.setEmYn(emYn[i]);
				if (cnYn[i] != null)
					model.setCnYn(cnYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getXterCustChkPntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return XterCustChkPntVO[]
	 */
	public XterCustChkPntVO[] getXterCustChkPntVOs(){
		XterCustChkPntVO[] vos = (XterCustChkPntVO[])models.toArray(new XterCustChkPntVO[models.size()]);
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
		this.coYn = this.coYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdYn = this.mdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cuYn = this.cuYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmYn = this.cmYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.raYn = this.raYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emYn = this.emYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnYn = this.cnYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
