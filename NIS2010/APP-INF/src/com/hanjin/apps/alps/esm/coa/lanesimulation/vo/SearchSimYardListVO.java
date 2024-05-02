/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SearchSimYardListVO.java
*@FileTitle : SearchSimYardListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.10
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2010.12.10 김기종 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.coa.lanesimulation.vo;

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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchSimYardListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchSimYardListVO> models = new ArrayList<SearchSimYardListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String code = null;
	/* Column Info */
	private String portUsdAmt = null;
	/* Column Info */
	private String portCy = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchSimYardListVO() {}

	public SearchSimYardListVO(String ibflag, String pagerows, String portCy, String ydNm, String portUsdAmt, String code, String name) {
		this.ibflag = ibflag;
		this.name = name;
		this.ydNm = ydNm;
		this.code = code;
		this.portUsdAmt = portUsdAmt;
		this.portCy = portCy;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("port_usd_amt", getPortUsdAmt());
		this.hashColumns.put("port_cy", getPortCy());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("name", "name");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("code", "code");
		this.hashFields.put("port_usd_amt", "portUsdAmt");
		this.hashFields.put("port_cy", "portCy");
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
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Column Info
	 * @return portUsdAmt
	 */
	public String getPortUsdAmt() {
		return this.portUsdAmt;
	}
	
	/**
	 * Column Info
	 * @return portCy
	 */
	public String getPortCy() {
		return this.portCy;
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
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Column Info
	 * @param portUsdAmt
	 */
	public void setPortUsdAmt(String portUsdAmt) {
		this.portUsdAmt = portUsdAmt;
	}
	
	/**
	 * Column Info
	 * @param portCy
	 */
	public void setPortCy(String portCy) {
		this.portCy = portCy;
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
		setName(JSPUtil.getParameter(request, prefix + "name", ""));
		setYdNm(JSPUtil.getParameter(request, prefix + "yd_nm", ""));
		setCode(JSPUtil.getParameter(request, prefix + "code", ""));
		setPortUsdAmt(JSPUtil.getParameter(request, prefix + "port_usd_amt", ""));
		setPortCy(JSPUtil.getParameter(request, prefix + "port_cy", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchSimYardListVO[]
	 */
	public SearchSimYardListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchSimYardListVO[]
	 */
	public SearchSimYardListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchSimYardListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] portUsdAmt = (JSPUtil.getParameter(request, prefix	+ "port_usd_amt", length));
			String[] portCy = (JSPUtil.getParameter(request, prefix	+ "port_cy", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchSimYardListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (portUsdAmt[i] != null)
					model.setPortUsdAmt(portUsdAmt[i]);
				if (portCy[i] != null)
					model.setPortCy(portCy[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchSimYardListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchSimYardListVO[]
	 */
	public SearchSimYardListVO[] getSearchSimYardListVOs(){
		SearchSimYardListVO[] vos = (SearchSimYardListVO[])models.toArray(new SearchSimYardListVO[models.size()]);
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
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portUsdAmt = this.portUsdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCy = this.portCy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
