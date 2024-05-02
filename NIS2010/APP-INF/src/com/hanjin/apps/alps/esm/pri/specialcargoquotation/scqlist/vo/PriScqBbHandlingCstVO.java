/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : PriScqBbHandlingCstVO.java
*@FileTitle : PriScqBbHandlingCstVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.09
*@LastModifier : 
*@LastVersion : 1.0
* 2013.04.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.specialcargoquotation.scqlist.vo;

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

public class PriScqBbHandlingCstVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriScqBbHandlingCstVO> models = new ArrayList<PriScqBbHandlingCstVO>();
	
	/* Column Info */
	private String polSum = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String podSum = null;
	/* Column Info */
	private String aproRt = null;
	/* Column Info */
	private String propRt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PriScqBbHandlingCstVO() {}

	public PriScqBbHandlingCstVO(String ibflag, String pagerows, String polSum, String podSum, String propRt, String aproRt) {
		this.polSum = polSum;
		this.ibflag = ibflag;
		this.podSum = podSum;
		this.aproRt = aproRt;
		this.propRt = propRt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pol_sum", getPolSum());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pod_sum", getPodSum());
		this.hashColumns.put("apro_rt", getAproRt());
		this.hashColumns.put("prop_rt", getPropRt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pol_sum", "polSum");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pod_sum", "podSum");
		this.hashFields.put("apro_rt", "aproRt");
		this.hashFields.put("prop_rt", "propRt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return polSum
	 */
	public String getPolSum() {
		return this.polSum;
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
	 * @return podSum
	 */
	public String getPodSum() {
		return this.podSum;
	}
	
	/**
	 * Column Info
	 * @return aproRt
	 */
	public String getAproRt() {
		return this.aproRt;
	}
	
	/**
	 * Column Info
	 * @return propRt
	 */
	public String getPropRt() {
		return this.propRt;
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
	 * @param polSum
	 */
	public void setPolSum(String polSum) {
		this.polSum = polSum;
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
	 * @param podSum
	 */
	public void setPodSum(String podSum) {
		this.podSum = podSum;
	}
	
	/**
	 * Column Info
	 * @param aproRt
	 */
	public void setAproRt(String aproRt) {
		this.aproRt = aproRt;
	}
	
	/**
	 * Column Info
	 * @param propRt
	 */
	public void setPropRt(String propRt) {
		this.propRt = propRt;
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
		setPolSum(JSPUtil.getParameter(request, prefix + "pol_sum", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPodSum(JSPUtil.getParameter(request, prefix + "pod_sum", ""));
		setAproRt(JSPUtil.getParameter(request, prefix + "apro_rt", ""));
		setPropRt(JSPUtil.getParameter(request, prefix + "prop_rt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriScqBbHandlingCstVO[]
	 */
	public PriScqBbHandlingCstVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriScqBbHandlingCstVO[]
	 */
	public PriScqBbHandlingCstVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriScqBbHandlingCstVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] polSum = (JSPUtil.getParameter(request, prefix	+ "pol_sum", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] podSum = (JSPUtil.getParameter(request, prefix	+ "pod_sum", length));
			String[] aproRt = (JSPUtil.getParameter(request, prefix	+ "apro_rt", length));
			String[] propRt = (JSPUtil.getParameter(request, prefix	+ "prop_rt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriScqBbHandlingCstVO();
				if (polSum[i] != null)
					model.setPolSum(polSum[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (podSum[i] != null)
					model.setPodSum(podSum[i]);
				if (aproRt[i] != null)
					model.setAproRt(aproRt[i]);
				if (propRt[i] != null)
					model.setPropRt(propRt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriScqBbHandlingCstVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriScqBbHandlingCstVO[]
	 */
	public PriScqBbHandlingCstVO[] getPriScqBbHandlingCstVOs(){
		PriScqBbHandlingCstVO[] vos = (PriScqBbHandlingCstVO[])models.toArray(new PriScqBbHandlingCstVO[models.size()]);
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
		this.polSum = this.polSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSum = this.podSum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRt = this.aproRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propRt = this.propRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
