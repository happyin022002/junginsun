/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CenterListVO.java
*@FileTitle : CenterListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.21
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.21  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.accountpayablecommon.vo;

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

public class CenterListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CenterListVO> models = new ArrayList<CenterListVO>();
	
	/* Column Info */
	private String ctrDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ctrErpNo = null;
	/* Column Info */
	private String fCenter = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CenterListVO() {}

	public CenterListVO(String ibflag, String pagerows, String ctrErpNo, String ctrDesc, String fCenter) {
		this.ctrDesc = ctrDesc;
		this.ibflag = ibflag;
		this.ctrErpNo = ctrErpNo;
		this.fCenter = fCenter;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ctr_desc", getCtrDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ctr_erp_no", getCtrErpNo());
		this.hashColumns.put("f_center", getFCenter());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ctr_desc", "ctrDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ctr_erp_no", "ctrErpNo");
		this.hashFields.put("f_center", "fCenter");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ctrDesc
	 */
	public String getCtrDesc() {
		return this.ctrDesc;
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
	 * @return ctrErpNo
	 */
	public String getCtrErpNo() {
		return this.ctrErpNo;
	}
	
	/**
	 * Column Info
	 * @return fCenter
	 */
	public String getFCenter() {
		return this.fCenter;
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
	 * @param ctrDesc
	 */
	public void setCtrDesc(String ctrDesc) {
		this.ctrDesc = ctrDesc;
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
	 * @param ctrErpNo
	 */
	public void setCtrErpNo(String ctrErpNo) {
		this.ctrErpNo = ctrErpNo;
	}
	
	/**
	 * Column Info
	 * @param fCenter
	 */
	public void setFCenter(String fCenter) {
		this.fCenter = fCenter;
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
		setCtrDesc(JSPUtil.getParameter(request, prefix + "ctr_desc", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCtrErpNo(JSPUtil.getParameter(request, prefix + "ctr_erp_no", ""));
		setFCenter(JSPUtil.getParameter(request, prefix + "f_center", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CenterListVO[]
	 */
	public CenterListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CenterListVO[]
	 */
	public CenterListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CenterListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ctrDesc = (JSPUtil.getParameter(request, prefix	+ "ctr_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ctrErpNo = (JSPUtil.getParameter(request, prefix	+ "ctr_erp_no", length));
			String[] fCenter = (JSPUtil.getParameter(request, prefix	+ "f_center", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new CenterListVO();
				if (ctrDesc[i] != null)
					model.setCtrDesc(ctrDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ctrErpNo[i] != null)
					model.setCtrErpNo(ctrErpNo[i]);
				if (fCenter[i] != null)
					model.setFCenter(fCenter[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCenterListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CenterListVO[]
	 */
	public CenterListVO[] getCenterListVOs(){
		CenterListVO[] vos = (CenterListVO[])models.toArray(new CenterListVO[models.size()]);
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
		this.ctrDesc = this.ctrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrErpNo = this.ctrErpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCenter = this.fCenter .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
