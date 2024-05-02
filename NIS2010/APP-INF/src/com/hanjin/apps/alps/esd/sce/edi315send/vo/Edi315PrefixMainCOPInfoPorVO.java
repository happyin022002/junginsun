/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315PrefixMainCOPInfoPorVO.java
*@FileTitle : Edi315PrefixMainCOPInfoPorVO
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

public class Edi315PrefixMainCOPInfoPorVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixMainCOPInfoPorVO> models = new ArrayList<Edi315PrefixMainCOPInfoPorVO>();
	
	/* Column Info */
	private String porAmsport = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String porName = null;
	/* Column Info */
	private String porCode = null;
	/* Column Info */
	private String porAmsqual = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixMainCOPInfoPorVO() {}

	public Edi315PrefixMainCOPInfoPorVO(String ibflag, String pagerows, String porName, String porCode, String porAmsqual, String porAmsport) {
		this.porAmsport = porAmsport;
		this.ibflag = ibflag;
		this.porName = porName;
		this.porCode = porCode;
		this.porAmsqual = porAmsqual;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_amsport", getPorAmsport());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("por_name", getPorName());
		this.hashColumns.put("por_code", getPorCode());
		this.hashColumns.put("por_amsqual", getPorAmsqual());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_amsport", "porAmsport");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("por_name", "porName");
		this.hashFields.put("por_code", "porCode");
		this.hashFields.put("por_amsqual", "porAmsqual");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porAmsport
	 */
	public String getPorAmsport() {
		return this.porAmsport;
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
	 * @return porName
	 */
	public String getPorName() {
		return this.porName;
	}
	
	/**
	 * Column Info
	 * @return porCode
	 */
	public String getPorCode() {
		return this.porCode;
	}
	
	/**
	 * Column Info
	 * @return porAmsqual
	 */
	public String getPorAmsqual() {
		return this.porAmsqual;
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
	 * @param porAmsport
	 */
	public void setPorAmsport(String porAmsport) {
		this.porAmsport = porAmsport;
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
	 * @param porName
	 */
	public void setPorName(String porName) {
		this.porName = porName;
	}
	
	/**
	 * Column Info
	 * @param porCode
	 */
	public void setPorCode(String porCode) {
		this.porCode = porCode;
	}
	
	/**
	 * Column Info
	 * @param porAmsqual
	 */
	public void setPorAmsqual(String porAmsqual) {
		this.porAmsqual = porAmsqual;
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
		setPorAmsport(JSPUtil.getParameter(request, prefix + "por_amsport", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPorName(JSPUtil.getParameter(request, prefix + "por_name", ""));
		setPorCode(JSPUtil.getParameter(request, prefix + "por_code", ""));
		setPorAmsqual(JSPUtil.getParameter(request, prefix + "por_amsqual", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixMainCOPInfoPorVO[]
	 */
	public Edi315PrefixMainCOPInfoPorVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixMainCOPInfoPorVO[]
	 */
	public Edi315PrefixMainCOPInfoPorVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixMainCOPInfoPorVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porAmsport = (JSPUtil.getParameter(request, prefix	+ "por_amsport", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] porName = (JSPUtil.getParameter(request, prefix	+ "por_name", length));
			String[] porCode = (JSPUtil.getParameter(request, prefix	+ "por_code", length));
			String[] porAmsqual = (JSPUtil.getParameter(request, prefix	+ "por_amsqual", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixMainCOPInfoPorVO();
				if (porAmsport[i] != null)
					model.setPorAmsport(porAmsport[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (porName[i] != null)
					model.setPorName(porName[i]);
				if (porCode[i] != null)
					model.setPorCode(porCode[i]);
				if (porAmsqual[i] != null)
					model.setPorAmsqual(porAmsqual[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixMainCOPInfoPorVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixMainCOPInfoPorVO[]
	 */
	public Edi315PrefixMainCOPInfoPorVO[] getEdi315PrefixMainCOPInfoPorVOs(){
		Edi315PrefixMainCOPInfoPorVO[] vos = (Edi315PrefixMainCOPInfoPorVO[])models.toArray(new Edi315PrefixMainCOPInfoPorVO[models.size()]);
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
		this.porAmsport = this.porAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porName = this.porName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCode = this.porCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAmsqual = this.porAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
