/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315PrefixMainCOPInfoDelVO.java
*@FileTitle : Edi315PrefixMainCOPInfoDelVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.18 이윤정 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315PrefixMainCOPInfoDelVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixMainCOPInfoDelVO> models = new ArrayList<Edi315PrefixMainCOPInfoDelVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String delAmsqual = null;
	/* Column Info */
	private String delAmsport = null;
	/* Column Info */
	private String delCode = null;
	/* Column Info */
	private String delName = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixMainCOPInfoDelVO() {}

	public Edi315PrefixMainCOPInfoDelVO(String ibflag, String pagerows, String delName, String delCode, String delAmsqual, String delAmsport) {
		this.ibflag = ibflag;
		this.delAmsqual = delAmsqual;
		this.delAmsport = delAmsport;
		this.delCode = delCode;
		this.delName = delName;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("del_amsqual", getDelAmsqual());
		this.hashColumns.put("del_amsport", getDelAmsport());
		this.hashColumns.put("del_code", getDelCode());
		this.hashColumns.put("del_name", getDelName());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("del_amsqual", "delAmsqual");
		this.hashFields.put("del_amsport", "delAmsport");
		this.hashFields.put("del_code", "delCode");
		this.hashFields.put("del_name", "delName");
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
	 * @return delAmsqual
	 */
	public String getDelAmsqual() {
		return this.delAmsqual;
	}
	
	/**
	 * Column Info
	 * @return delAmsport
	 */
	public String getDelAmsport() {
		return this.delAmsport;
	}
	
	/**
	 * Column Info
	 * @return delCode
	 */
	public String getDelCode() {
		return this.delCode;
	}
	
	/**
	 * Column Info
	 * @return delName
	 */
	public String getDelName() {
		return this.delName;
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
	 * @param delAmsqual
	 */
	public void setDelAmsqual(String delAmsqual) {
		this.delAmsqual = delAmsqual;
	}
	
	/**
	 * Column Info
	 * @param delAmsport
	 */
	public void setDelAmsport(String delAmsport) {
		this.delAmsport = delAmsport;
	}
	
	/**
	 * Column Info
	 * @param delCode
	 */
	public void setDelCode(String delCode) {
		this.delCode = delCode;
	}
	
	/**
	 * Column Info
	 * @param delName
	 */
	public void setDelName(String delName) {
		this.delName = delName;
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
		setDelAmsqual(JSPUtil.getParameter(request, prefix + "del_amsqual", ""));
		setDelAmsport(JSPUtil.getParameter(request, prefix + "del_amsport", ""));
		setDelCode(JSPUtil.getParameter(request, prefix + "del_code", ""));
		setDelName(JSPUtil.getParameter(request, prefix + "del_name", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixMainCOPInfoDelVO[]
	 */
	public Edi315PrefixMainCOPInfoDelVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixMainCOPInfoDelVO[]
	 */
	public Edi315PrefixMainCOPInfoDelVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixMainCOPInfoDelVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] delAmsqual = (JSPUtil.getParameter(request, prefix	+ "del_amsqual", length));
			String[] delAmsport = (JSPUtil.getParameter(request, prefix	+ "del_amsport", length));
			String[] delCode = (JSPUtil.getParameter(request, prefix	+ "del_code", length));
			String[] delName = (JSPUtil.getParameter(request, prefix	+ "del_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixMainCOPInfoDelVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (delAmsqual[i] != null)
					model.setDelAmsqual(delAmsqual[i]);
				if (delAmsport[i] != null)
					model.setDelAmsport(delAmsport[i]);
				if (delCode[i] != null)
					model.setDelCode(delCode[i]);
				if (delName[i] != null)
					model.setDelName(delName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixMainCOPInfoDelVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixMainCOPInfoDelVO[]
	 */
	public Edi315PrefixMainCOPInfoDelVO[] getEdi315PrefixMainCOPInfoDelVOs(){
		Edi315PrefixMainCOPInfoDelVO[] vos = (Edi315PrefixMainCOPInfoDelVO[])models.toArray(new Edi315PrefixMainCOPInfoDelVO[models.size()]);
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
		this.delAmsqual = this.delAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAmsport = this.delAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCode = this.delCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delName = this.delName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
