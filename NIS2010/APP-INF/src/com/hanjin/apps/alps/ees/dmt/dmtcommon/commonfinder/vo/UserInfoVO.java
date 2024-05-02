/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchUserInfoVO.java
*@FileTitle : SearchUserInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.17
*@LastModifier : 임창빈
*@LastVersion : 1.0
* 2013.04.17 임창빈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.dmt.dmtcommon.commonfinder.vo;

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
 * @author 임창빈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UserInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UserInfoVO> models = new ArrayList<UserInfoVO>();
	
	/* Column Info */
	private String lstLginOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cngRhqOfcCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UserInfoVO() {}

	public UserInfoVO(String ibflag, String pagerows, String cngRhqOfcCd, String lstLginOfcCd) {
		this.lstLginOfcCd = lstLginOfcCd;
		this.ibflag = ibflag;
		this.cngRhqOfcCd = cngRhqOfcCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lst_lgin_ofc_cd", getLstLginOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cng_rhq_ofc_cd", getCngRhqOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lst_lgin_ofc_cd", "lstLginOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cng_rhq_ofc_cd", "cngRhqOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lstLginOfcCd
	 */
	public String getLstLginOfcCd() {
		return this.lstLginOfcCd;
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
	 * @return cngRhqOfcCd
	 */
	public String getCngRhqOfcCd() {
		return this.cngRhqOfcCd;
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
	 * @param lstLginOfcCd
	 */
	public void setLstLginOfcCd(String lstLginOfcCd) {
		this.lstLginOfcCd = lstLginOfcCd;
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
	 * @param cngRhqOfcCd
	 */
	public void setCngRhqOfcCd(String cngRhqOfcCd) {
		this.cngRhqOfcCd = cngRhqOfcCd;
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
		setLstLginOfcCd(JSPUtil.getParameter(request, prefix + "lst_lgin_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCngRhqOfcCd(JSPUtil.getParameter(request, prefix + "cng_rhq_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchUserInfoVO[]
	 */
	public UserInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchUserInfoVO[]
	 */
	public UserInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UserInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lstLginOfcCd = (JSPUtil.getParameter(request, prefix	+ "lst_lgin_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cngRhqOfcCd = (JSPUtil.getParameter(request, prefix	+ "cng_rhq_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UserInfoVO();
				if (lstLginOfcCd[i] != null)
					model.setLstLginOfcCd(lstLginOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cngRhqOfcCd[i] != null)
					model.setCngRhqOfcCd(cngRhqOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUserInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchUserInfoVO[]
	 */
	public UserInfoVO[] getUserInfoVOs(){
		UserInfoVO[] vos = (UserInfoVO[])models.toArray(new UserInfoVO[models.size()]);
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
		this.lstLginOfcCd = this.lstLginOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngRhqOfcCd = this.cngRhqOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
