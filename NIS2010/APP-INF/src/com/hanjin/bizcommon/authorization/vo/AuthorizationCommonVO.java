/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : AuthorizationCommonVO.java
*@FileTitle : AuthorizationCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.03
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.03  
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

public class AuthorizationCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuthorizationCommonVO> models = new ArrayList<AuthorizationCommonVO>();
	
	/* Column Info */
	private String rqstOfcNm = null;
	/* Column Info */
	private String authRqstRsn = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String authAproRqstNo = null;
	/* Column Info */
	private String authPgmBtnSeq = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String rqstTitNm = null;
	/* Column Info */
	private String authRqstKnt = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AuthorizationCommonVO() {}

	public AuthorizationCommonVO(String ibflag, String pagerows, String rqstOfcNm, String rqstUsrId, String authAproRqstNo, String rqstUsrNm, String authPgmBtnSeq, String rqstTitNm, String authRqstRsn, String authRqstKnt) {
		this.rqstOfcNm = rqstOfcNm;
		this.authRqstRsn = authRqstRsn;
		this.rqstUsrId = rqstUsrId;
		this.ibflag = ibflag;
		this.authAproRqstNo = authAproRqstNo;
		this.authPgmBtnSeq = authPgmBtnSeq;
		this.rqstUsrNm = rqstUsrNm;
		this.rqstTitNm = rqstTitNm;
		this.authRqstKnt = authRqstKnt;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rqst_ofc_nm", getRqstOfcNm());
		this.hashColumns.put("auth_rqst_rsn", getAuthRqstRsn());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("auth_apro_rqst_no", getAuthAproRqstNo());
		this.hashColumns.put("auth_pgm_btn_seq", getAuthPgmBtnSeq());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("rqst_tit_nm", getRqstTitNm());
		this.hashColumns.put("auth_rqst_knt", getAuthRqstKnt());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rqst_ofc_nm", "rqstOfcNm");
		this.hashFields.put("auth_rqst_rsn", "authRqstRsn");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("auth_apro_rqst_no", "authAproRqstNo");
		this.hashFields.put("auth_pgm_btn_seq", "authPgmBtnSeq");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("rqst_tit_nm", "rqstTitNm");
		this.hashFields.put("auth_rqst_knt", "authRqstKnt");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcNm
	 */
	public String getRqstOfcNm() {
		return this.rqstOfcNm;
	}
	
	/**
	 * Column Info
	 * @return authRqstRsn
	 */
	public String getAuthRqstRsn() {
		return this.authRqstRsn;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
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
	 * @return authPgmBtnSeq
	 */
	public String getAuthPgmBtnSeq() {
		return this.authPgmBtnSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return rqstTitNm
	 */
	public String getRqstTitNm() {
		return this.rqstTitNm;
	}
	
	/**
	 * Column Info
	 * @return authRqstKnt
	 */
	public String getAuthRqstKnt() {
		return this.authRqstKnt;
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
	 * @param rqstOfcNm
	 */
	public void setRqstOfcNm(String rqstOfcNm) {
		this.rqstOfcNm = rqstOfcNm;
	}
	
	/**
	 * Column Info
	 * @param authRqstRsn
	 */
	public void setAuthRqstRsn(String authRqstRsn) {
		this.authRqstRsn = authRqstRsn;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
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
	 * @param authPgmBtnSeq
	 */
	public void setAuthPgmBtnSeq(String authPgmBtnSeq) {
		this.authPgmBtnSeq = authPgmBtnSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param rqstTitNm
	 */
	public void setRqstTitNm(String rqstTitNm) {
		this.rqstTitNm = rqstTitNm;
	}
	
	/**
	 * Column Info
	 * @param authRqstKnt
	 */
	public void setAuthRqstKnt(String authRqstKnt) {
		this.authRqstKnt = authRqstKnt;
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
		setRqstOfcNm(JSPUtil.getParameter(request, prefix + "rqst_ofc_nm", ""));
		setAuthRqstRsn(JSPUtil.getParameter(request, prefix + "auth_rqst_rsn", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAuthAproRqstNo(JSPUtil.getParameter(request, prefix + "auth_apro_rqst_no", ""));
		setAuthPgmBtnSeq(JSPUtil.getParameter(request, prefix + "auth_pgm_btn_seq", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setRqstTitNm(JSPUtil.getParameter(request, prefix + "rqst_tit_nm", ""));
		setAuthRqstKnt(JSPUtil.getParameter(request, prefix + "auth_rqst_knt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuthorizationCommonVO[]
	 */
	public AuthorizationCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuthorizationCommonVO[]
	 */
	public AuthorizationCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuthorizationCommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rqstOfcNm = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_nm", length));
			String[] authRqstRsn = (JSPUtil.getParameter(request, prefix	+ "auth_rqst_rsn", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] authAproRqstNo = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rqst_no", length));
			String[] authPgmBtnSeq = (JSPUtil.getParameter(request, prefix	+ "auth_pgm_btn_seq", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] rqstTitNm = (JSPUtil.getParameter(request, prefix	+ "rqst_tit_nm", length));
			String[] authRqstKnt = (JSPUtil.getParameter(request, prefix	+ "auth_rqst_knt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new AuthorizationCommonVO();
				if (rqstOfcNm[i] != null)
					model.setRqstOfcNm(rqstOfcNm[i]);
				if (authRqstRsn[i] != null)
					model.setAuthRqstRsn(authRqstRsn[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (authAproRqstNo[i] != null)
					model.setAuthAproRqstNo(authAproRqstNo[i]);
				if (authPgmBtnSeq[i] != null)
					model.setAuthPgmBtnSeq(authPgmBtnSeq[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (rqstTitNm[i] != null)
					model.setRqstTitNm(rqstTitNm[i]);
				if (authRqstKnt[i] != null)
					model.setAuthRqstKnt(authRqstKnt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthorizationCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuthorizationCommonVO[]
	 */
	public AuthorizationCommonVO[] getAuthorizationCommonVOs(){
		AuthorizationCommonVO[] vos = (AuthorizationCommonVO[])models.toArray(new AuthorizationCommonVO[models.size()]);
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
		this.rqstOfcNm = this.rqstOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authRqstRsn = this.authRqstRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRqstNo = this.authAproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authPgmBtnSeq = this.authPgmBtnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstTitNm = this.rqstTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authRqstKnt = this.authRqstKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
