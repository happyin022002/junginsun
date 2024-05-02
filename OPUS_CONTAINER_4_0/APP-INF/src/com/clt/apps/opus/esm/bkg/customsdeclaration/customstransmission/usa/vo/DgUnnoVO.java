/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : DgUnnoVO.java
*@FileTitle : DgUnnoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 
*@LastVersion : 1.0
* 2014.12.15  
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

public class DgUnnoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DgUnnoVO> models = new ArrayList<DgUnnoVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String v01 = null;
	/* Column Info */
	private String v03 = null;
	/* Column Info */
	private String v02 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DgUnnoVO() {}

	public DgUnnoVO(String ibflag, String pagerows, String v01, String v02, String v03) {
		this.ibflag = ibflag;
		this.v01 = v01;
		this.v03 = v03;
		this.v02 = v02;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("v01", getV01());
		this.hashColumns.put("v03", getV03());
		this.hashColumns.put("v02", getV02());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("v01", "v01");
		this.hashFields.put("v03", "v03");
		this.hashFields.put("v02", "v02");
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
	 * @return v01
	 */
	public String getV01() {
		return this.v01;
	}
	
	/**
	 * Column Info
	 * @return v03
	 */
	public String getV03() {
		return this.v03;
	}
	
	/**
	 * Column Info
	 * @return v02
	 */
	public String getV02() {
		return this.v02;
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
	 * @param v01
	 */
	public void setV01(String v01) {
		this.v01 = v01;
	}
	
	/**
	 * Column Info
	 * @param v03
	 */
	public void setV03(String v03) {
		this.v03 = v03;
	}
	
	/**
	 * Column Info
	 * @param v02
	 */
	public void setV02(String v02) {
		this.v02 = v02;
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
		setV01(JSPUtil.getParameter(request, prefix + "v01", ""));
		setV03(JSPUtil.getParameter(request, prefix + "v03", ""));
		setV02(JSPUtil.getParameter(request, prefix + "v02", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgUnnoVO[]
	 */
	public DgUnnoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DgUnnoVO[]
	 */
	public DgUnnoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgUnnoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] v01 = (JSPUtil.getParameter(request, prefix	+ "v01", length));
			String[] v03 = (JSPUtil.getParameter(request, prefix	+ "v03", length));
			String[] v02 = (JSPUtil.getParameter(request, prefix	+ "v02", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new DgUnnoVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (v01[i] != null)
					model.setV01(v01[i]);
				if (v03[i] != null)
					model.setV03(v03[i]);
				if (v02[i] != null)
					model.setV02(v02[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgUnnoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgUnnoVO[]
	 */
	public DgUnnoVO[] getDgUnnoVOs(){
		DgUnnoVO[] vos = (DgUnnoVO[])models.toArray(new DgUnnoVO[models.size()]);
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
		this.v01 = this.v01 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.v03 = this.v03 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.v02 = this.v02 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
