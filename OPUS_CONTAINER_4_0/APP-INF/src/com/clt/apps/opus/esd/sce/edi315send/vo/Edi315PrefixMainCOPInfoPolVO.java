/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315PrefixMainCOPInfoPolVO.java
*@FileTitle : Edi315PrefixMainCOPInfoPolVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.03.18 이윤정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.edi315send.vo;

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
 * @author 이윤정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class Edi315PrefixMainCOPInfoPolVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixMainCOPInfoPolVO> models = new ArrayList<Edi315PrefixMainCOPInfoPolVO>();
	
	/* Column Info */
	private String polAmsqual = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCode = null;
	/* Column Info */
	private String polAmsport = null;
	/* Column Info */
	private String polName = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixMainCOPInfoPolVO() {}

	public Edi315PrefixMainCOPInfoPolVO(String ibflag, String pagerows, String polName, String polCode, String polAmsqual, String polAmsport) {
		this.polAmsqual = polAmsqual;
		this.ibflag = ibflag;
		this.polCode = polCode;
		this.polAmsport = polAmsport;
		this.polName = polName;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pol_amsqual", getPolAmsqual());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_code", getPolCode());
		this.hashColumns.put("pol_amsport", getPolAmsport());
		this.hashColumns.put("pol_name", getPolName());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pol_amsqual", "polAmsqual");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_code", "polCode");
		this.hashFields.put("pol_amsport", "polAmsport");
		this.hashFields.put("pol_name", "polName");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return polAmsqual
	 */
	public String getPolAmsqual() {
		return this.polAmsqual;
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
	 * @return polCode
	 */
	public String getPolCode() {
		return this.polCode;
	}
	
	/**
	 * Column Info
	 * @return polAmsport
	 */
	public String getPolAmsport() {
		return this.polAmsport;
	}
	
	/**
	 * Column Info
	 * @return polName
	 */
	public String getPolName() {
		return this.polName;
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
	 * @param polAmsqual
	 */
	public void setPolAmsqual(String polAmsqual) {
		this.polAmsqual = polAmsqual;
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
	 * @param polCode
	 */
	public void setPolCode(String polCode) {
		this.polCode = polCode;
	}
	
	/**
	 * Column Info
	 * @param polAmsport
	 */
	public void setPolAmsport(String polAmsport) {
		this.polAmsport = polAmsport;
	}
	
	/**
	 * Column Info
	 * @param polName
	 */
	public void setPolName(String polName) {
		this.polName = polName;
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
		setPolAmsqual(JSPUtil.getParameter(request, prefix + "pol_amsqual", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCode(JSPUtil.getParameter(request, prefix + "pol_code", ""));
		setPolAmsport(JSPUtil.getParameter(request, prefix + "pol_amsport", ""));
		setPolName(JSPUtil.getParameter(request, prefix + "pol_name", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixMainCOPInfoPolVO[]
	 */
	public Edi315PrefixMainCOPInfoPolVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixMainCOPInfoPolVO[]
	 */
	public Edi315PrefixMainCOPInfoPolVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixMainCOPInfoPolVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] polAmsqual = (JSPUtil.getParameter(request, prefix	+ "pol_amsqual", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCode = (JSPUtil.getParameter(request, prefix	+ "pol_code", length));
			String[] polAmsport = (JSPUtil.getParameter(request, prefix	+ "pol_amsport", length));
			String[] polName = (JSPUtil.getParameter(request, prefix	+ "pol_name", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixMainCOPInfoPolVO();
				if (polAmsqual[i] != null)
					model.setPolAmsqual(polAmsqual[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCode[i] != null)
					model.setPolCode(polCode[i]);
				if (polAmsport[i] != null)
					model.setPolAmsport(polAmsport[i]);
				if (polName[i] != null)
					model.setPolName(polName[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixMainCOPInfoPolVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixMainCOPInfoPolVO[]
	 */
	public Edi315PrefixMainCOPInfoPolVO[] getEdi315PrefixMainCOPInfoPolVOs(){
		Edi315PrefixMainCOPInfoPolVO[] vos = (Edi315PrefixMainCOPInfoPolVO[])models.toArray(new Edi315PrefixMainCOPInfoPolVO[models.size()]);
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
		this.polAmsqual = this.polAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCode = this.polCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAmsport = this.polAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polName = this.polName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
