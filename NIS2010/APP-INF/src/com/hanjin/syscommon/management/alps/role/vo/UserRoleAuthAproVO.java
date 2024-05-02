/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : UserRoleAuthAproVO.java
*@FileTitle : UserRoleAuthAproVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.18
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.18  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.management.alps.role.vo;

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

public class UserRoleAuthAproVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UserRoleAuthAproVO> models = new ArrayList<UserRoleAuthAproVO>();
	
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String aproRqstSeq = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String usrRoleCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rqstUsrEml = null;
	/* Column Info */
	private String rqstStDtHr = null;
	/* Column Info */
	private String rqstRmk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String aproRqstNo = null;
	/* Column Info */
	private String rqstStDt = null;
	/* Column Info */
	private String usrRoleNm = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String apstsCd = null;
	/* Column Info */
	private String roleModule = null;
	/* Column Info */
	private String aproRoleCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public UserRoleAuthAproVO() {}

	public UserRoleAuthAproVO(String ibflag, String pagerows, String aproRqstNo, String rqstUsrId, String rqstUsrNm, String rqstUsrEml, String rqstOfcCd, String rqstStDt, String rqstStDtHr, String roleModule, String usrRoleCd, String usrRoleNm, String rqstRmk, String aproRqstSeq, String apstsCd, String aproRmk, String aproRoleCd) {
		this.aproRmk = aproRmk;
		this.rqstUsrId = rqstUsrId;
		this.aproRqstSeq = aproRqstSeq;
		this.rqstUsrNm = rqstUsrNm;
		this.usrRoleCd = usrRoleCd;
		this.pagerows = pagerows;
		this.rqstUsrEml = rqstUsrEml;
		this.rqstStDtHr = rqstStDtHr;
		this.rqstRmk = rqstRmk;
		this.ibflag = ibflag;
		this.aproRqstNo = aproRqstNo;
		this.rqstStDt = rqstStDt;
		this.usrRoleNm = usrRoleNm;
		this.rqstOfcCd = rqstOfcCd;
		this.apstsCd = apstsCd;
		this.roleModule = roleModule;
		this.aproRoleCd = aproRoleCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("apro_rqst_seq", getAproRqstSeq());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("usr_role_cd", getUsrRoleCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rqst_usr_eml", getRqstUsrEml());
		this.hashColumns.put("rqst_st_dt_hr", getRqstStDtHr());
		this.hashColumns.put("rqst_rmk", getRqstRmk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("apro_rqst_no", getAproRqstNo());
		this.hashColumns.put("rqst_st_dt", getRqstStDt());
		this.hashColumns.put("usr_role_nm", getUsrRoleNm());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("apsts_cd", getApstsCd());
		this.hashColumns.put("role_module", getRoleModule());
		this.hashColumns.put("aproRoleCd", getAproRoleCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("apro_rqst_seq", "aproRqstSeq");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("usr_role_cd", "usrRoleCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rqst_usr_eml", "rqstUsrEml");
		this.hashFields.put("rqst_st_dt_hr", "rqstStDtHr");
		this.hashFields.put("rqst_rmk", "rqstRmk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("apro_rqst_no", "aproRqstNo");
		this.hashFields.put("rqst_st_dt", "rqstStDt");
		this.hashFields.put("usr_role_nm", "usrRoleNm");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("apsts_cd", "apstsCd");
		this.hashFields.put("role_module", "roleModule");
		this.hashFields.put("apro_role_cd", "aproRoleCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return aproRmk
	 */
	public String getAproRmk() {
		return this.aproRmk;
	}
	
	/**
	 * Column Info
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return aproRqstSeq
	 */
	public String getAproRqstSeq() {
		return this.aproRqstSeq;
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
	 * @return usrRoleCd
	 */
	public String getUsrRoleCd() {
		return this.usrRoleCd;
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
	 * @return rqstUsrEml
	 */
	public String getRqstUsrEml() {
		return this.rqstUsrEml;
	}
	
	/**
	 * Column Info
	 * @return rqstStDtHr
	 */
	public String getRqstStDtHr() {
		return this.rqstStDtHr;
	}
	
	/**
	 * Column Info
	 * @return rqstRmk
	 */
	public String getRqstRmk() {
		return this.rqstRmk;
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
	 * @return aproRqstNo
	 */
	public String getAproRqstNo() {
		return this.aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @return rqstStDt
	 */
	public String getRqstStDt() {
		return this.rqstStDt;
	}
	
	/**
	 * Column Info
	 * @return usrRoleNm
	 */
	public String getUsrRoleNm() {
		return this.usrRoleNm;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @return apstsCd
	 */
	public String getApstsCd() {
		return this.apstsCd;
	}
	
	/**
	 * Column Info
	 * @return roleModule
	 */
	public String getRoleModule() {
		return this.roleModule;
	}

	/**
	 * Column Info
	 * @return aproRoleCd
	 */
	public String getAproRoleCd() {
		return aproRoleCd;
	}

	/**
	 * Column Info
	 * @param aproRmk
	 */
	public void setAproRmk(String aproRmk) {
		this.aproRmk = aproRmk;
	}
	
	/**
	 * Column Info
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param aproRqstSeq
	 */
	public void setAproRqstSeq(String aproRqstSeq) {
		this.aproRqstSeq = aproRqstSeq;
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
	 * @param usrRoleCd
	 */
	public void setUsrRoleCd(String usrRoleCd) {
		this.usrRoleCd = usrRoleCd;
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
	 * @param rqstUsrEml
	 */
	public void setRqstUsrEml(String rqstUsrEml) {
		this.rqstUsrEml = rqstUsrEml;
	}
	
	/**
	 * Column Info
	 * @param rqstStDtHr
	 */
	public void setRqstStDtHr(String rqstStDtHr) {
		this.rqstStDtHr = rqstStDtHr;
	}
	
	/**
	 * Column Info
	 * @param rqstRmk
	 */
	public void setRqstRmk(String rqstRmk) {
		this.rqstRmk = rqstRmk;
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
	 * @param aproRqstNo
	 */
	public void setAproRqstNo(String aproRqstNo) {
		this.aproRqstNo = aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @param rqstStDt
	 */
	public void setRqstStDt(String rqstStDt) {
		this.rqstStDt = rqstStDt;
	}
	
	/**
	 * Column Info
	 * @param usrRoleNm
	 */
	public void setUsrRoleNm(String usrRoleNm) {
		this.usrRoleNm = usrRoleNm;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Column Info
	 * @param apstsCd
	 */
	public void setApstsCd(String apstsCd) {
		this.apstsCd = apstsCd;
	}
	
	/**
	 * Column Info
	 * @param roleModule
	 */
	public void setRoleModule(String roleModule) {
		this.roleModule = roleModule;
	}
	
	/**
	 * Column Info
	 * @return aproRqstNo
	 */
	public void setAproRoleCd(String aproRoleCd) {
		this.aproRoleCd = aproRoleCd;
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
		setAproRmk(JSPUtil.getParameter(request, prefix + "apro_rmk", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setAproRqstSeq(JSPUtil.getParameter(request, prefix + "apro_rqst_seq", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setUsrRoleCd(JSPUtil.getParameter(request, prefix + "usr_role_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRqstUsrEml(JSPUtil.getParameter(request, prefix + "rqst_usr_eml", ""));
		setRqstStDtHr(JSPUtil.getParameter(request, prefix + "rqst_st_dt_hr", ""));
		setRqstRmk(JSPUtil.getParameter(request, prefix + "rqst_rmk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAproRqstNo(JSPUtil.getParameter(request, prefix + "apro_rqst_no", ""));
		setRqstStDt(JSPUtil.getParameter(request, prefix + "rqst_st_dt", ""));
		setUsrRoleNm(JSPUtil.getParameter(request, prefix + "usr_role_nm", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setApstsCd(JSPUtil.getParameter(request, prefix + "apsts_cd", ""));
		setRoleModule(JSPUtil.getParameter(request, prefix + "role_module", ""));
		setAproRoleCd(JSPUtil.getParameter(request, prefix + "apro_role_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UserRoleAuthAproVO[]
	 */
	public UserRoleAuthAproVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UserRoleAuthAproVO[]
	 */
	public UserRoleAuthAproVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UserRoleAuthAproVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] aproRqstSeq = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_seq", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] usrRoleCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rqstUsrEml = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_eml", length));
			String[] rqstStDtHr = (JSPUtil.getParameter(request, prefix	+ "rqst_st_dt_hr", length));
			String[] rqstRmk = (JSPUtil.getParameter(request, prefix	+ "rqst_rmk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] aproRqstNo = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_no", length));
			String[] rqstStDt = (JSPUtil.getParameter(request, prefix	+ "rqst_st_dt", length));
			String[] usrRoleNm = (JSPUtil.getParameter(request, prefix	+ "usr_role_nm", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] apstsCd = (JSPUtil.getParameter(request, prefix	+ "apsts_cd", length));
			String[] roleModule = (JSPUtil.getParameter(request, prefix	+ "role_module", length));
			String[] aproRoleCd = (JSPUtil.getParameter(request, prefix	+ "apro_role_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UserRoleAuthAproVO();
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (aproRqstSeq[i] != null)
					model.setAproRqstSeq(aproRqstSeq[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (usrRoleCd[i] != null)
					model.setUsrRoleCd(usrRoleCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rqstUsrEml[i] != null)
					model.setRqstUsrEml(rqstUsrEml[i]);
				if (rqstStDtHr[i] != null)
					model.setRqstStDtHr(rqstStDtHr[i]);
				if (rqstRmk[i] != null)
					model.setRqstRmk(rqstRmk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (aproRqstNo[i] != null)
					model.setAproRqstNo(aproRqstNo[i]);
				if (rqstStDt[i] != null)
					model.setRqstStDt(rqstStDt[i]);
				if (usrRoleNm[i] != null)
					model.setUsrRoleNm(usrRoleNm[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (apstsCd[i] != null)
					model.setApstsCd(apstsCd[i]);
				if (roleModule[i] != null)
					model.setRoleModule(roleModule[i]);
				if (aproRoleCd[i] != null)
					model.setAproRoleCd(aproRoleCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUserRoleAuthAproVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UserRoleAuthAproVO[]
	 */
	public UserRoleAuthAproVO[] getUserRoleAuthAproVOs(){
		UserRoleAuthAproVO[] vos = (UserRoleAuthAproVO[])models.toArray(new UserRoleAuthAproVO[models.size()]);
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
		this.aproRmk = this.aproRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstSeq = this.aproRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleCd = this.usrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrEml = this.rqstUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstStDtHr = this.rqstStDtHr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRmk = this.rqstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstNo = this.aproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstStDt = this.rqstStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleNm = this.usrRoleNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apstsCd = this.apstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roleModule = this.roleModule .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRoleCd = this.aproRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
