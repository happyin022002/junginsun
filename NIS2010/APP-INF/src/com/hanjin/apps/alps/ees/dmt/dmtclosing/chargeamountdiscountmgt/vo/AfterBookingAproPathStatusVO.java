/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AfterBookingAproPathStatusVO.java
*@FileTitle : AfterBookingAproPathStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.04.27
*@LastModifier : 
*@LastVersion : 1.0
* 2017.04.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AfterBookingAproPathStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AfterBookingAproPathStatusVO> models = new ArrayList<AfterBookingAproPathStatusVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dmdtExptRqstStsDesc = null;
	/* Column Info */
	private String dmdtExptRqstStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AfterBookingAproPathStatusVO() {}

	public AfterBookingAproPathStatusVO(String ibflag, String pagerows, String dmdtExptRqstStsCd, String dmdtExptRqstStsDesc) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.dmdtExptRqstStsDesc = dmdtExptRqstStsDesc;
		this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("dmdt_expt_rqst_sts_desc", getDmdtExptRqstStsDesc());
		this.hashColumns.put("dmdt_expt_rqst_sts_cd", getDmdtExptRqstStsCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dmdt_expt_rqst_sts_desc", "dmdtExptRqstStsDesc");
		this.hashFields.put("dmdt_expt_rqst_sts_cd", "dmdtExptRqstStsCd");
		return this.hashFields;
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
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptRqstStsDesc
	 */
	public String getDmdtExptRqstStsDesc() {
		return this.dmdtExptRqstStsDesc;
	}
	
	/**
	 * Column Info
	 * @return dmdtExptRqstStsCd
	 */
	public String getDmdtExptRqstStsCd() {
		return this.dmdtExptRqstStsCd;
	}
	

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param dmdtExptRqstStsDesc
	 */
	public void setDmdtExptRqstStsDesc(String dmdtExptRqstStsDesc) {
		this.dmdtExptRqstStsDesc = dmdtExptRqstStsDesc;
	}
	
	/**
	 * Column Info
	 * @param dmdtExptRqstStsCd
	 */
	public void setDmdtExptRqstStsCd(String dmdtExptRqstStsCd) {
		this.dmdtExptRqstStsCd = dmdtExptRqstStsCd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDmdtExptRqstStsDesc(JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_desc", ""));
		setDmdtExptRqstStsCd(JSPUtil.getParameter(request, prefix + "dmdt_expt_rqst_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AfterBookingAproPathStatusVO[]
	 */
	public AfterBookingAproPathStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AfterBookingAproPathStatusVO[]
	 */
	public AfterBookingAproPathStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AfterBookingAproPathStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] dmdtExptRqstStsDesc = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_rqst_sts_desc", length));
			String[] dmdtExptRqstStsCd = (JSPUtil.getParameter(request, prefix	+ "dmdt_expt_rqst_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AfterBookingAproPathStatusVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (dmdtExptRqstStsDesc[i] != null)
					model.setDmdtExptRqstStsDesc(dmdtExptRqstStsDesc[i]);
				if (dmdtExptRqstStsCd[i] != null)
					model.setDmdtExptRqstStsCd(dmdtExptRqstStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAfterBookingAproPathStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AfterBookingAproPathStatusVO[]
	 */
	public AfterBookingAproPathStatusVO[] getAfterBookingAproPathStatusVOs(){
		AfterBookingAproPathStatusVO[] vos = (AfterBookingAproPathStatusVO[])models.toArray(new AfterBookingAproPathStatusVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptRqstStsDesc = this.dmdtExptRqstStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtExptRqstStsCd = this.dmdtExptRqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
