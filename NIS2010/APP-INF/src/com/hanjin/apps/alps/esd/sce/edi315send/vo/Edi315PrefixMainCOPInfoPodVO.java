/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315PrefixMainCOPInfoPodVO.java
*@FileTitle : Edi315PrefixMainCOPInfoPodVO
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

public class Edi315PrefixMainCOPInfoPodVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<Edi315PrefixMainCOPInfoPodVO> models = new ArrayList<Edi315PrefixMainCOPInfoPodVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podName = null;
	/* Column Info */
	private String podCode = null;
	/* Column Info */
	private String podAmsqual = null;
	/* Column Info */
	private String podAmsport = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public Edi315PrefixMainCOPInfoPodVO() {}

	public Edi315PrefixMainCOPInfoPodVO(String ibflag, String pagerows, String podName, String podCode, String podAmsqual, String podAmsport) {
		this.ibflag = ibflag;
		this.podName = podName;
		this.podCode = podCode;
		this.podAmsqual = podAmsqual;
		this.podAmsport = podAmsport;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_name", getPodName());
		this.hashColumns.put("pod_code", getPodCode());
		this.hashColumns.put("pod_amsqual", getPodAmsqual());
		this.hashColumns.put("pod_amsport", getPodAmsport());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_name", "podName");
		this.hashFields.put("pod_code", "podCode");
		this.hashFields.put("pod_amsqual", "podAmsqual");
		this.hashFields.put("pod_amsport", "podAmsport");
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
	 * @return podName
	 */
	public String getPodName() {
		return this.podName;
	}
	
	/**
	 * Column Info
	 * @return podCode
	 */
	public String getPodCode() {
		return this.podCode;
	}
	
	/**
	 * Column Info
	 * @return podAmsqual
	 */
	public String getPodAmsqual() {
		return this.podAmsqual;
	}
	
	/**
	 * Column Info
	 * @return podAmsport
	 */
	public String getPodAmsport() {
		return this.podAmsport;
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
	 * @param podName
	 */
	public void setPodName(String podName) {
		this.podName = podName;
	}
	
	/**
	 * Column Info
	 * @param podCode
	 */
	public void setPodCode(String podCode) {
		this.podCode = podCode;
	}
	
	/**
	 * Column Info
	 * @param podAmsqual
	 */
	public void setPodAmsqual(String podAmsqual) {
		this.podAmsqual = podAmsqual;
	}
	
	/**
	 * Column Info
	 * @param podAmsport
	 */
	public void setPodAmsport(String podAmsport) {
		this.podAmsport = podAmsport;
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
		setPodName(JSPUtil.getParameter(request, prefix + "pod_name", ""));
		setPodCode(JSPUtil.getParameter(request, prefix + "pod_code", ""));
		setPodAmsqual(JSPUtil.getParameter(request, prefix + "pod_amsqual", ""));
		setPodAmsport(JSPUtil.getParameter(request, prefix + "pod_amsport", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return Edi315PrefixMainCOPInfoPodVO[]
	 */
	public Edi315PrefixMainCOPInfoPodVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return Edi315PrefixMainCOPInfoPodVO[]
	 */
	public Edi315PrefixMainCOPInfoPodVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		Edi315PrefixMainCOPInfoPodVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podName = (JSPUtil.getParameter(request, prefix	+ "pod_name", length));
			String[] podCode = (JSPUtil.getParameter(request, prefix	+ "pod_code", length));
			String[] podAmsqual = (JSPUtil.getParameter(request, prefix	+ "pod_amsqual", length));
			String[] podAmsport = (JSPUtil.getParameter(request, prefix	+ "pod_amsport", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new Edi315PrefixMainCOPInfoPodVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podName[i] != null)
					model.setPodName(podName[i]);
				if (podCode[i] != null)
					model.setPodCode(podCode[i]);
				if (podAmsqual[i] != null)
					model.setPodAmsqual(podAmsqual[i]);
				if (podAmsport[i] != null)
					model.setPodAmsport(podAmsport[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdi315PrefixMainCOPInfoPodVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return Edi315PrefixMainCOPInfoPodVO[]
	 */
	public Edi315PrefixMainCOPInfoPodVO[] getEdi315PrefixMainCOPInfoPodVOs(){
		Edi315PrefixMainCOPInfoPodVO[] vos = (Edi315PrefixMainCOPInfoPodVO[])models.toArray(new Edi315PrefixMainCOPInfoPodVO[models.size()]);
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
		this.podName = this.podName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCode = this.podCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAmsqual = this.podAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAmsport = this.podAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
