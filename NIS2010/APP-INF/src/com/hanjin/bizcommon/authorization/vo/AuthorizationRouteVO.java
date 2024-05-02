/*=========================================================
*Copyright(c) 2015 CyberLogitec 
*@FileName : AuthorizationRouteVO.java
*@FileTitle : AuthorizationRouteVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.bizcommon.authorization.vo;

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

public class AuthorizationRouteVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuthorizationRouteVO> models = new ArrayList<AuthorizationRouteVO>();
	
	/* Column Info */
	private String authAproUsrJbTitNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String authAproRqstNo = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String authAproOfcCd = null;
	/* Column Info */
	private String authAproUsrNm = null;
	/* Column Info */
	private String authAproRoutUsrSeq = null;
	/* Column Info */
	private String authAproOfcNm = null;
	/* Column Info */
	private String authAproUsrId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AuthorizationRouteVO() {}

	public AuthorizationRouteVO(String ibflag, String pagerows, String authAproRqstNo, String authAproUsrJbTitNm, String authAproUsrId, String authAproRoutUsrSeq, String authAproUsrNm, String authAproOfcCd, String authAproOfcNm, String usrId) {
		this.authAproUsrJbTitNm = authAproUsrJbTitNm;
		this.ibflag = ibflag;
		this.authAproRqstNo = authAproRqstNo;
		this.usrId = usrId;
		this.authAproOfcCd = authAproOfcCd;
		this.authAproUsrNm = authAproUsrNm;
		this.authAproRoutUsrSeq = authAproRoutUsrSeq;
		this.authAproOfcNm = authAproOfcNm;
		this.authAproUsrId = authAproUsrId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_apro_usr_jb_tit_nm", getAuthAproUsrJbTitNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("auth_apro_rqst_no", getAuthAproRqstNo());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("auth_apro_ofc_cd", getAuthAproOfcCd());
		this.hashColumns.put("auth_apro_usr_nm", getAuthAproUsrNm());
		this.hashColumns.put("auth_apro_rout_usr_seq", getAuthAproRoutUsrSeq());
		this.hashColumns.put("auth_apro_ofc_nm", getAuthAproOfcNm());
		this.hashColumns.put("auth_apro_usr_id", getAuthAproUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_apro_usr_jb_tit_nm", "authAproUsrJbTitNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("auth_apro_rqst_no", "authAproRqstNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("auth_apro_ofc_cd", "authAproOfcCd");
		this.hashFields.put("auth_apro_usr_nm", "authAproUsrNm");
		this.hashFields.put("auth_apro_rout_usr_seq", "authAproRoutUsrSeq");
		this.hashFields.put("auth_apro_ofc_nm", "authAproOfcNm");
		this.hashFields.put("auth_apro_usr_id", "authAproUsrId");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return authAproUsrJbTitNm
	 */
	public String getAuthAproUsrJbTitNm() {
		return this.authAproUsrJbTitNm;
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
	 * @return authAproRqstNo
	 */
	public String getAuthAproRqstNo() {
		return this.authAproRqstNo;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return authAproOfcCd
	 */
	public String getAuthAproOfcCd() {
		return this.authAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return authAproUsrNm
	 */
	public String getAuthAproUsrNm() {
		return this.authAproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return authAproRoutUsrSeq
	 */
	public String getAuthAproRoutUsrSeq() {
		return this.authAproRoutUsrSeq;
	}
	
	/**
	 * Column Info
	 * @return authAproOfcNm
	 */
	public String getAuthAproOfcNm() {
		return this.authAproOfcNm;
	}
	
	/**
	 * Column Info
	 * @return authAproUsrId
	 */
	public String getAuthAproUsrId() {
		return this.authAproUsrId;
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
	 * @param authAproUsrJbTitNm
	 */
	public void setAuthAproUsrJbTitNm(String authAproUsrJbTitNm) {
		this.authAproUsrJbTitNm = authAproUsrJbTitNm;
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
	 * @param authAproRqstNo
	 */
	public void setAuthAproRqstNo(String authAproRqstNo) {
		this.authAproRqstNo = authAproRqstNo;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param authAproOfcCd
	 */
	public void setAuthAproOfcCd(String authAproOfcCd) {
		this.authAproOfcCd = authAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param authAproUsrNm
	 */
	public void setAuthAproUsrNm(String authAproUsrNm) {
		this.authAproUsrNm = authAproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param authAproRoutUsrSeq
	 */
	public void setAuthAproRoutUsrSeq(String authAproRoutUsrSeq) {
		this.authAproRoutUsrSeq = authAproRoutUsrSeq;
	}
	
	/**
	 * Column Info
	 * @param authAproOfcNm
	 */
	public void setAuthAproOfcNm(String authAproOfcNm) {
		this.authAproOfcNm = authAproOfcNm;
	}
	
	/**
	 * Column Info
	 * @param authAproUsrId
	 */
	public void setAuthAproUsrId(String authAproUsrId) {
		this.authAproUsrId = authAproUsrId;
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
		setAuthAproUsrJbTitNm(JSPUtil.getParameter(request, prefix + "auth_apro_usr_jb_tit_nm", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAuthAproRqstNo(JSPUtil.getParameter(request, prefix + "auth_apro_rqst_no", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAuthAproOfcCd(JSPUtil.getParameter(request, prefix + "auth_apro_ofc_cd", ""));
		setAuthAproUsrNm(JSPUtil.getParameter(request, prefix + "auth_apro_usr_nm", ""));
		setAuthAproRoutUsrSeq(JSPUtil.getParameter(request, prefix + "auth_apro_rout_usr_seq", ""));
		setAuthAproOfcNm(JSPUtil.getParameter(request, prefix + "auth_apro_ofc_nm", ""));
		setAuthAproUsrId(JSPUtil.getParameter(request, prefix + "auth_apro_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuthorizationRouteVO[]
	 */
	public AuthorizationRouteVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuthorizationRouteVO[]
	 */
	public AuthorizationRouteVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuthorizationRouteVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] authAproUsrJbTitNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_jb_tit_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] authAproRqstNo = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rqst_no", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] authAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "auth_apro_ofc_cd", length));
			String[] authAproUsrNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_nm", length));
			String[] authAproRoutUsrSeq = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rout_usr_seq", length));
			String[] authAproOfcNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_ofc_nm", length));
			String[] authAproUsrId = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AuthorizationRouteVO();
				if (authAproUsrJbTitNm[i] != null)
					model.setAuthAproUsrJbTitNm(authAproUsrJbTitNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (authAproRqstNo[i] != null)
					model.setAuthAproRqstNo(authAproRqstNo[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (authAproOfcCd[i] != null)
					model.setAuthAproOfcCd(authAproOfcCd[i]);
				if (authAproUsrNm[i] != null)
					model.setAuthAproUsrNm(authAproUsrNm[i]);
				if (authAproRoutUsrSeq[i] != null)
					model.setAuthAproRoutUsrSeq(authAproRoutUsrSeq[i]);
				if (authAproOfcNm[i] != null)
					model.setAuthAproOfcNm(authAproOfcNm[i]);
				if (authAproUsrId[i] != null)
					model.setAuthAproUsrId(authAproUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthorizationRouteVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuthorizationRouteVO[]
	 */
	public AuthorizationRouteVO[] getAuthorizationRouteVOs(){
		AuthorizationRouteVO[] vos = (AuthorizationRouteVO[])models.toArray(new AuthorizationRouteVO[models.size()]);
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
		this.authAproUsrJbTitNm = this.authAproUsrJbTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRqstNo = this.authAproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproOfcCd = this.authAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrNm = this.authAproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRoutUsrSeq = this.authAproRoutUsrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproOfcNm = this.authAproOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrId = this.authAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
