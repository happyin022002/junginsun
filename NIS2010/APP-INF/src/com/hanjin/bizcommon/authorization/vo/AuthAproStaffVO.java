/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthAproStaffVO.java
*@FileTitle : AuthAproStaffVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.20
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.20  
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

public class AuthAproStaffVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuthAproStaffVO> models = new ArrayList<AuthAproStaffVO>();
	
	/* Column Info */
	private String authAproJbTitNm = null;
	/* Column Info */
	private String authAproTpCd = null;
	/* Column Info */
	private String authAproUsrNm = null;
	/* Column Info */
	private String authAproOfcCd = null;
	/* Column Info */
	private String authAproRoutUsrSeq = null;
	/* Column Info */
	private String authAproRoutSeq = null;
	/* Column Info */
	private String ofcCdAuth = null;
	/* Column Info */
	private String authAproOfcNm = null;
	/* Column Info */
	private String pgmNm = null;
	/* Column Info */
	private String pgmNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String subSysCdAuth = null;
	/* Column Info */
	private String authAproUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AuthAproStaffVO() {}

	public AuthAproStaffVO(String ibflag, String pagerows, String subSysCdAuth, String pgmNo, String pgmNm, String authAproRoutUsrSeq, String authAproJbTitNm, String authAproUsrId, String authAproRoutSeq, String authAproUsrNm, String authAproOfcCd, String authAproOfcNm, String authAproTpCd, String ofcCdAuth, String ofcCd, String usrId, String usrNm) {
		this.authAproJbTitNm = authAproJbTitNm;
		this.authAproTpCd = authAproTpCd;
		this.authAproUsrNm = authAproUsrNm;
		this.authAproOfcCd = authAproOfcCd;
		this.authAproRoutUsrSeq = authAproRoutUsrSeq;
		this.authAproRoutSeq = authAproRoutSeq;
		this.ofcCdAuth = ofcCdAuth;
		this.authAproOfcNm = authAproOfcNm;
		this.pgmNm = pgmNm;
		this.pgmNo = pgmNo;
		this.pagerows = pagerows;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.usrNm = usrNm;
		this.usrId = usrId;
		this.subSysCdAuth = subSysCdAuth;
		this.authAproUsrId = authAproUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_apro_jb_tit_nm", getAuthAproJbTitNm());
		this.hashColumns.put("auth_apro_tp_cd", getAuthAproTpCd());
		this.hashColumns.put("auth_apro_usr_nm", getAuthAproUsrNm());
		this.hashColumns.put("auth_apro_ofc_cd", getAuthAproOfcCd());
		this.hashColumns.put("auth_apro_rout_usr_seq", getAuthAproRoutUsrSeq());
		this.hashColumns.put("auth_apro_rout_seq", getAuthAproRoutSeq());
		this.hashColumns.put("ofc_cd_auth", getOfcCdAuth());
		this.hashColumns.put("auth_apro_ofc_nm", getAuthAproOfcNm());
		this.hashColumns.put("pgm_nm", getPgmNm());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("sub_sys_cd_auth", getSubSysCdAuth());
		this.hashColumns.put("auth_apro_usr_id", getAuthAproUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_apro_jb_tit_nm", "authAproJbTitNm");
		this.hashFields.put("auth_apro_tp_cd", "authAproTpCd");
		this.hashFields.put("auth_apro_usr_nm", "authAproUsrNm");
		this.hashFields.put("auth_apro_ofc_cd", "authAproOfcCd");
		this.hashFields.put("auth_apro_rout_usr_seq", "authAproRoutUsrSeq");
		this.hashFields.put("auth_apro_rout_seq", "authAproRoutSeq");
		this.hashFields.put("ofc_cd_auth", "ofcCdAuth");
		this.hashFields.put("auth_apro_ofc_nm", "authAproOfcNm");
		this.hashFields.put("pgm_nm", "pgmNm");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("sub_sys_cd_auth", "subSysCdAuth");
		this.hashFields.put("auth_apro_usr_id", "authAproUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return authAproJbTitNm
	 */
	public String getAuthAproJbTitNm() {
		return this.authAproJbTitNm;
	}
	
	/**
	 * Column Info
	 * @return authAproTpCd
	 */
	public String getAuthAproTpCd() {
		return this.authAproTpCd;
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
	 * @return authAproOfcCd
	 */
	public String getAuthAproOfcCd() {
		return this.authAproOfcCd;
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
	 * @return authAproRoutSeq
	 */
	public String getAuthAproRoutSeq() {
		return this.authAproRoutSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcCdAuth
	 */
	public String getOfcCdAuth() {
		return this.ofcCdAuth;
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
	 * @return pgmNm
	 */
	public String getPgmNm() {
		return this.pgmNm;
	}
	
	/**
	 * Column Info
	 * @return pgmNo
	 */
	public String getPgmNo() {
		return this.pgmNo;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return subSysCdAuth
	 */
	public String getSubSysCdAuth() {
		return this.subSysCdAuth;
	}
	
	/**
	 * Column Info
	 * @return authAproUsrId
	 */
	public String getAuthAproUsrId() {
		return this.authAproUsrId;
	}
	

	/**
	 * Column Info
	 * @param authAproJbTitNm
	 */
	public void setAuthAproJbTitNm(String authAproJbTitNm) {
		this.authAproJbTitNm = authAproJbTitNm;
	}
	
	/**
	 * Column Info
	 * @param authAproTpCd
	 */
	public void setAuthAproTpCd(String authAproTpCd) {
		this.authAproTpCd = authAproTpCd;
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
	 * @param authAproOfcCd
	 */
	public void setAuthAproOfcCd(String authAproOfcCd) {
		this.authAproOfcCd = authAproOfcCd;
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
	 * @param authAproRoutSeq
	 */
	public void setAuthAproRoutSeq(String authAproRoutSeq) {
		this.authAproRoutSeq = authAproRoutSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcCdAuth
	 */
	public void setOfcCdAuth(String ofcCdAuth) {
		this.ofcCdAuth = ofcCdAuth;
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
	 * @param pgmNm
	 */
	public void setPgmNm(String pgmNm) {
		this.pgmNm = pgmNm;
	}
	
	/**
	 * Column Info
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param subSysCdAuth
	 */
	public void setSubSysCdAuth(String subSysCdAuth) {
		this.subSysCdAuth = subSysCdAuth;
	}
	
	/**
	 * Column Info
	 * @param authAproUsrId
	 */
	public void setAuthAproUsrId(String authAproUsrId) {
		this.authAproUsrId = authAproUsrId;
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
		setAuthAproJbTitNm(JSPUtil.getParameter(request, prefix + "auth_apro_jb_tit_nm", ""));
		setAuthAproTpCd(JSPUtil.getParameter(request, prefix + "auth_apro_tp_cd", ""));
		setAuthAproUsrNm(JSPUtil.getParameter(request, prefix + "auth_apro_usr_nm", ""));
		setAuthAproOfcCd(JSPUtil.getParameter(request, prefix + "auth_apro_ofc_cd", ""));
		setAuthAproRoutUsrSeq(JSPUtil.getParameter(request, prefix + "auth_apro_rout_usr_seq", ""));
		setAuthAproRoutSeq(JSPUtil.getParameter(request, prefix + "auth_apro_rout_seq", ""));
		setOfcCdAuth(JSPUtil.getParameter(request, prefix + "ofc_cd_auth", ""));
		setAuthAproOfcNm(JSPUtil.getParameter(request, prefix + "auth_apro_ofc_nm", ""));
		setPgmNm(JSPUtil.getParameter(request, prefix + "pgm_nm", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSubSysCdAuth(JSPUtil.getParameter(request, prefix + "sub_sys_cd_auth", ""));
		setAuthAproUsrId(JSPUtil.getParameter(request, prefix + "auth_apro_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuthAproStaffVO[]
	 */
	public AuthAproStaffVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuthAproStaffVO[]
	 */
	public AuthAproStaffVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuthAproStaffVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] authAproJbTitNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_jb_tit_nm", length));
			String[] authAproTpCd = (JSPUtil.getParameter(request, prefix	+ "auth_apro_tp_cd", length));
			String[] authAproUsrNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_nm", length));
			String[] authAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "auth_apro_ofc_cd", length));
			String[] authAproRoutUsrSeq = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rout_usr_seq", length));
			String[] authAproRoutSeq = (JSPUtil.getParameter(request, prefix	+ "auth_apro_rout_seq", length));
			String[] ofcCdAuth = (JSPUtil.getParameter(request, prefix	+ "ofc_cd_auth", length));
			String[] authAproOfcNm = (JSPUtil.getParameter(request, prefix	+ "auth_apro_ofc_nm", length));
			String[] pgmNm = (JSPUtil.getParameter(request, prefix	+ "pgm_nm", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] subSysCdAuth = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd_auth", length));
			String[] authAproUsrId = (JSPUtil.getParameter(request, prefix	+ "auth_apro_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new AuthAproStaffVO();
				if (authAproJbTitNm[i] != null)
					model.setAuthAproJbTitNm(authAproJbTitNm[i]);
				if (authAproTpCd[i] != null)
					model.setAuthAproTpCd(authAproTpCd[i]);
				if (authAproUsrNm[i] != null)
					model.setAuthAproUsrNm(authAproUsrNm[i]);
				if (authAproOfcCd[i] != null)
					model.setAuthAproOfcCd(authAproOfcCd[i]);
				if (authAproRoutUsrSeq[i] != null)
					model.setAuthAproRoutUsrSeq(authAproRoutUsrSeq[i]);
				if (authAproRoutSeq[i] != null)
					model.setAuthAproRoutSeq(authAproRoutSeq[i]);
				if (ofcCdAuth[i] != null)
					model.setOfcCdAuth(ofcCdAuth[i]);
				if (authAproOfcNm[i] != null)
					model.setAuthAproOfcNm(authAproOfcNm[i]);
				if (pgmNm[i] != null)
					model.setPgmNm(pgmNm[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (subSysCdAuth[i] != null)
					model.setSubSysCdAuth(subSysCdAuth[i]);
				if (authAproUsrId[i] != null)
					model.setAuthAproUsrId(authAproUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthAproStaffVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuthAproStaffVO[]
	 */
	public AuthAproStaffVO[] getAuthAproStaffVOs(){
		AuthAproStaffVO[] vos = (AuthAproStaffVO[])models.toArray(new AuthAproStaffVO[models.size()]);
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
		this.authAproJbTitNm = this.authAproJbTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproTpCd = this.authAproTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrNm = this.authAproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproOfcCd = this.authAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRoutUsrSeq = this.authAproRoutUsrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproRoutSeq = this.authAproRoutSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCdAuth = this.ofcCdAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproOfcNm = this.authAproOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNm = this.pgmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subSysCdAuth = this.subSysCdAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authAproUsrId = this.authAproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
