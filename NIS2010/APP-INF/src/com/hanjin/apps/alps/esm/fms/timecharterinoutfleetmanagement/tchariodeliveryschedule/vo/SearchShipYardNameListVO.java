/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchShipYardNameListVO.java
*@FileTitle : SearchShipYardNameListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 
*@LastVersion : 1.0
* 2009.10.29  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.fms.timecharterinoutfleetmanagement.tchariodeliveryschedule.vo;

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

public class SearchShipYardNameListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchShipYardNameListVO> models = new ArrayList<SearchShipYardNameListVO>();
	
	/* Column Info */
	private String ydSeq = null;
	/* Column Info */
	private String deltYn = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String shpYdNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchShipYardNameListVO() {}

	public SearchShipYardNameListVO(String ibflag, String pagerows, String ydSeq, String shpYdNm, String deltYn) {
		this.ydSeq = ydSeq;
		this.deltYn = deltYn;
		this.ibflag = ibflag;
		this.shpYdNm = shpYdNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yd_seq", getYdSeq());
		this.hashColumns.put("delt_yn", getDeltYn());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("shp_yd_nm", getShpYdNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("yd_seq", "ydSeq");
		this.hashFields.put("delt_yn", "deltYn");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shp_yd_nm", "shpYdNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ydSeq
	 */
	public String getYdSeq() {
		return this.ydSeq;
	}
	
	/**
	 * Column Info
	 * @return deltYn
	 */
	public String getDeltYn() {
		return this.deltYn;
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
	 * @return shpYdNm
	 */
	public String getShpYdNm() {
		return this.shpYdNm;
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
	 * @param ydSeq
	 */
	public void setYdSeq(String ydSeq) {
		this.ydSeq = ydSeq;
	}
	
	/**
	 * Column Info
	 * @param deltYn
	 */
	public void setDeltYn(String deltYn) {
		this.deltYn = deltYn;
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
	 * @param shpYdNm
	 */
	public void setShpYdNm(String shpYdNm) {
		this.shpYdNm = shpYdNm;
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
		setYdSeq(JSPUtil.getParameter(request, "yd_seq", ""));
		setDeltYn(JSPUtil.getParameter(request, "delt_yn", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setShpYdNm(JSPUtil.getParameter(request, "shp_yd_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchShipYardNameListVO[]
	 */
	public SearchShipYardNameListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchShipYardNameListVO[]
	 */
	public SearchShipYardNameListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchShipYardNameListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ydSeq = (JSPUtil.getParameter(request, prefix	+ "yd_seq", length));
			String[] deltYn = (JSPUtil.getParameter(request, prefix	+ "delt_yn", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] shpYdNm = (JSPUtil.getParameter(request, prefix	+ "shp_yd_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchShipYardNameListVO();
				if (ydSeq[i] != null)
					model.setYdSeq(ydSeq[i]);
				if (deltYn[i] != null)
					model.setDeltYn(deltYn[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (shpYdNm[i] != null)
					model.setShpYdNm(shpYdNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchShipYardNameListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchShipYardNameListVO[]
	 */
	public SearchShipYardNameListVO[] getSearchShipYardNameListVOs(){
		SearchShipYardNameListVO[] vos = (SearchShipYardNameListVO[])models.toArray(new SearchShipYardNameListVO[models.size()]);
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
		this.ydSeq = this.ydSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltYn = this.deltYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpYdNm = this.shpYdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
