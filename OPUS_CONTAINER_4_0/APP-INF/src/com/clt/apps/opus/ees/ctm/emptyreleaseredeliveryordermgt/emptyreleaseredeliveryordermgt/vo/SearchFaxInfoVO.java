/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchFaxInfoVO.java
*@FileTitle : SearchFaxInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2009.11.27 김상수 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.ctm.emptyreleaseredeliveryordermgt.emptyreleaseredeliveryordermgt.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchFaxInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchFaxInfoVO> models = new ArrayList<SearchFaxInfoVO>();
	
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String cntrTpszDesc = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ydNm = null;
	/* Column Info */
	private String userInfo = null;
	/* Column Info */
	private String ydPicNm = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchFaxInfoVO() {}

	public SearchFaxInfoVO(String ibflag, String pagerows, String ydNm, String ydPicNm, String phnNo, String userInfo, String cntrTpszDesc) {
		this.phnNo = phnNo;
		this.cntrTpszDesc = cntrTpszDesc;
		this.ibflag = ibflag;
		this.ydNm = ydNm;
		this.userInfo = userInfo;
		this.ydPicNm = ydPicNm;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("cntr_tpsz_desc", getCntrTpszDesc());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("yd_nm", getYdNm());
		this.hashColumns.put("user_info", getUserInfo());
		this.hashColumns.put("yd_pic_nm", getYdPicNm());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("cntr_tpsz_desc", "cntrTpszDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("yd_nm", "ydNm");
		this.hashFields.put("user_info", "userInfo");
		this.hashFields.put("yd_pic_nm", "ydPicNm");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszDesc
	 */
	public String getCntrTpszDesc() {
		return this.cntrTpszDesc;
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
	 * @return ydNm
	 */
	public String getYdNm() {
		return this.ydNm;
	}
	
	/**
	 * Column Info
	 * @return userInfo
	 */
	public String getUserInfo() {
		return this.userInfo;
	}
	
	/**
	 * Column Info
	 * @return ydPicNm
	 */
	public String getYdPicNm() {
		return this.ydPicNm;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszDesc
	 */
	public void setCntrTpszDesc(String cntrTpszDesc) {
		this.cntrTpszDesc = cntrTpszDesc;
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
	 * @param ydNm
	 */
	public void setYdNm(String ydNm) {
		this.ydNm = ydNm;
	}
	
	/**
	 * Column Info
	 * @param userInfo
	 */
	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}
	
	/**
	 * Column Info
	 * @param ydPicNm
	 */
	public void setYdPicNm(String ydPicNm) {
		this.ydPicNm = ydPicNm;
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
		setPhnNo(JSPUtil.getParameter(request, "phn_no", ""));
		setCntrTpszDesc(JSPUtil.getParameter(request, "cntr_tpsz_desc", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setYdNm(JSPUtil.getParameter(request, "yd_nm", ""));
		setUserInfo(JSPUtil.getParameter(request, "user_info", ""));
		setYdPicNm(JSPUtil.getParameter(request, "yd_pic_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchFaxInfoVO[]
	 */
	public SearchFaxInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchFaxInfoVO[]
	 */
	public SearchFaxInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchFaxInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] cntrTpszDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_desc", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ydNm = (JSPUtil.getParameter(request, prefix	+ "yd_nm", length));
			String[] userInfo = (JSPUtil.getParameter(request, prefix	+ "user_info", length));
			String[] ydPicNm = (JSPUtil.getParameter(request, prefix	+ "yd_pic_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchFaxInfoVO();
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (cntrTpszDesc[i] != null)
					model.setCntrTpszDesc(cntrTpszDesc[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ydNm[i] != null)
					model.setYdNm(ydNm[i]);
				if (userInfo[i] != null)
					model.setUserInfo(userInfo[i]);
				if (ydPicNm[i] != null)
					model.setYdPicNm(ydPicNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchFaxInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchFaxInfoVO[]
	 */
	public SearchFaxInfoVO[] getSearchFaxInfoVOs(){
		SearchFaxInfoVO[] vos = (SearchFaxInfoVO[])models.toArray(new SearchFaxInfoVO[models.size()]);
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
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszDesc = this.cntrTpszDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydNm = this.ydNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userInfo = this.userInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydPicNm = this.ydPicNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
