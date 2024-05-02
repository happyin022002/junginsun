/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuthorityVO.java
*@FileTitle : AuthorityVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.24
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.06.24 최덕우 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.management.alps.role.vo;

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
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AuthorityVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuthorityVO> models = new ArrayList<AuthorityVO>();
	
	/* Column Info */
	private String aproRmk = null;
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String rqstUsrNm = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String usrRoleRqstTpNm = null;
	/* Column Info */
	private String usrRoleCd = null;
	/* Column Info */
	private String aproUsrNm = null;
	/* Column Info */
	private String apstsNm = null;
	/* Column Info */
	private String ofcTpCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rqstOfcNm = null;
	/* Column Info */
	private String rqstRmk = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrRoleNm = null;
	/* Column Info */
	private String rqstStDt = null;
	/* Column Info */
	private String aproRqstNo = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String apstsCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String roleModule = null;
	/* Column Info */
	private String roleAuth = null;
	/* Column Info */
	private String orgUsrRoleCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public AuthorityVO() {}

	public AuthorityVO(String ibflag, String roleModule, String pagerows, String aproDt, String aproRmk, String aproRqstNo, String aproUsrId, String aproUsrNm, String apstsCd, String apstsNm, String dateFm, String dateTo, String ofcTpCd, String rqstOfcCd, String rqstRmk, String rqstStDt, String rqstUsrId, String rqstUsrNm, String updUsrId, String creUsrId, String rqstOfcNm, String usrRoleCd, String usrRoleNm, String usrRoleRqstTpNm, String roleAuth, String orgUsrRoleCd) {
		this.aproRmk = aproRmk;
		this.dateFm = dateFm;
		this.rqstUsrId = rqstUsrId;
		this.rqstUsrNm = rqstUsrNm;
		this.dateTo = dateTo;
		this.usrRoleRqstTpNm = usrRoleRqstTpNm;
		this.usrRoleCd = usrRoleCd;
		this.aproUsrNm = aproUsrNm;
		this.apstsNm = apstsNm;
		this.ofcTpCd = ofcTpCd;
		this.aproDt = aproDt;
		this.pagerows = pagerows;
		this.rqstOfcNm = rqstOfcNm;
		this.rqstRmk = rqstRmk;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.usrRoleNm = usrRoleNm;
		this.rqstStDt = rqstStDt;
		this.aproRqstNo = aproRqstNo;
		this.aproUsrId = aproUsrId;
		this.rqstOfcCd = rqstOfcCd;
		this.apstsCd = apstsCd;
		this.updUsrId = updUsrId;
		this.roleModule = roleModule;
		this.roleAuth = roleAuth;
		this.orgUsrRoleCd = orgUsrRoleCd;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("apro_rmk", getAproRmk());
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("rqst_usr_nm", getRqstUsrNm());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("usr_role_rqst_tp_nm", getUsrRoleRqstTpNm());
		this.hashColumns.put("usr_role_cd", getUsrRoleCd());
		this.hashColumns.put("apro_usr_nm", getAproUsrNm());
		this.hashColumns.put("apsts_nm", getApstsNm());
		this.hashColumns.put("ofc_tp_cd", getOfcTpCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rqst_ofc_nm", getRqstOfcNm());
		this.hashColumns.put("rqst_rmk", getRqstRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_role_nm", getUsrRoleNm());
		this.hashColumns.put("rqst_st_dt", getRqstStDt());
		this.hashColumns.put("apro_rqst_no", getAproRqstNo());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("apsts_cd", getApstsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("role_module", getRoleModule());
		this.hashColumns.put("role_auth", getRoleAuth());
		this.hashColumns.put("org_usr_role_cd", getOrgUsrRoleCd());

		return this.hashColumns;
	}
	


	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("apro_rmk", "aproRmk");
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("rqst_usr_nm", "rqstUsrNm");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("usr_role_rqst_tp_nm", "usrRoleRqstTpNm");
		this.hashFields.put("usr_role_cd", "usrRoleCd");
		this.hashFields.put("apro_usr_nm", "aproUsrNm");
		this.hashFields.put("apsts_nm", "apstsNm");
		this.hashFields.put("ofc_tp_cd", "ofcTpCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rqst_ofc_nm", "rqstOfcNm");
		this.hashFields.put("rqst_rmk", "rqstRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_role_nm", "usrRoleNm");
		this.hashFields.put("rqst_st_dt", "rqstStDt");
		this.hashFields.put("apro_rqst_no", "aproRqstNo");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("apsts_cd", "apstsCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("role_module", "roleModule");
		this.hashFields.put("role_auth", "roleAuth");
		this.hashFields.put("org_usr_role_cd", "orgUsrRoleCd");
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
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
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
	 * @return rqstUsrNm
	 */
	public String getRqstUsrNm() {
		return this.rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}
	
	/**
	 * Column Info
	 * @return usrRoleRqstTpNm
	 */
	public String getUsrRoleRqstTpNm() {
		return this.usrRoleRqstTpNm;
	}
	
	/**
	 * Column Info
	 * @return usrRoleCd
	 */
	public String getUsrRoleCd() {
		return this.usrRoleCd;
	}
	
	/**
	 * Column Info
	 * @return aproUsrNm
	 */
	public String getAproUsrNm() {
		return this.aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @return apstsNm
	 */
	public String getApstsNm() {
		return this.apstsNm;
	}
	
	/**
	 * Column Info
	 * @return ofcTpCd
	 */
	public String getOfcTpCd() {
		return this.ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
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
	 * @return rqstOfcNm
	 */
	public String getRqstOfcNm() {
		return this.rqstOfcNm;
	}
	
	/**
	 * Column Info
	 * @return rqstRmk
	 */
	public String getRqstRmk() {
		return this.rqstRmk;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return usrRoleNm
	 */
	public String getUsrRoleNm() {
		return this.usrRoleNm;
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
	 * @return aproRqstNo
	 */
	public String getAproRqstNo() {
		return this.aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
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
	 * @return roleAuth
	 */
	public String getRoleAuth() {
		return this.roleAuth;
	}
	/**
	 * Column Info
	 * @return orgUsrRoleCd
	 */
	private String getOrgUsrRoleCd() {
		// TODO Auto-generated method stub
		return this.orgUsrRoleCd;
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
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
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
	 * @param rqstUsrNm
	 */
	public void setRqstUsrNm(String rqstUsrNm) {
		this.rqstUsrNm = rqstUsrNm;
	}
	
	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	/**
	 * Column Info
	 * @param usrRoleRqstTpNm
	 */
	public void setUsrRoleRqstTpNm(String usrRoleRqstTpNm) {
		this.usrRoleRqstTpNm = usrRoleRqstTpNm;
	}
	
	/**
	 * Column Info
	 * @param usrRoleCd
	 */
	public void setUsrRoleCd(String usrRoleCd) {
		this.usrRoleCd = usrRoleCd;
	}
	
	/**
	 * Column Info
	 * @param aproUsrNm
	 */
	public void setAproUsrNm(String aproUsrNm) {
		this.aproUsrNm = aproUsrNm;
	}
	
	/**
	 * Column Info
	 * @param apstsNm
	 */
	public void setApstsNm(String apstsNm) {
		this.apstsNm = apstsNm;
	}
	
	/**
	 * Column Info
	 * @param ofcTpCd
	 */
	public void setOfcTpCd(String ofcTpCd) {
		this.ofcTpCd = ofcTpCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
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
	 * @param rqstOfcNm
	 */
	public void setRqstOfcNm(String rqstOfcNm) {
		this.rqstOfcNm = rqstOfcNm;
	}
	
	/**
	 * Column Info
	 * @param rqstRmk
	 */
	public void setRqstRmk(String rqstRmk) {
		this.rqstRmk = rqstRmk;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param usrRoleNm
	 */
	public void setUsrRoleNm(String usrRoleNm) {
		this.usrRoleNm = usrRoleNm;
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
	 * @param aproRqstNo
	 */
	public void setAproRqstNo(String aproRqstNo) {
		this.aproRqstNo = aproRqstNo;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
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
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
	 * @param roleAuth
	 */
	public void setRoleAuth(String roleAuth) {
		this.roleAuth = roleAuth;
	}
	/**
	 * Column Info
	 * @param orgUsrRoleCd
	 */
	public void setOrgUsrRoleCd(String orgUsrRoleCd) {
		this.orgUsrRoleCd = orgUsrRoleCd;
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
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setRqstUsrNm(JSPUtil.getParameter(request, prefix + "rqst_usr_nm", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setUsrRoleRqstTpNm(JSPUtil.getParameter(request, prefix + "usr_role_rqst_tp_nm", ""));
		setUsrRoleCd(JSPUtil.getParameter(request, prefix + "usr_role_cd", ""));
		setAproUsrNm(JSPUtil.getParameter(request, prefix + "apro_usr_nm", ""));
		setApstsNm(JSPUtil.getParameter(request, prefix + "apsts_nm", ""));
		setOfcTpCd(JSPUtil.getParameter(request, prefix + "ofc_tp_cd", ""));
		setAproDt(JSPUtil.getParameter(request, prefix + "apro_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRqstOfcNm(JSPUtil.getParameter(request, prefix + "rqst_ofc_nm", ""));
		setRqstRmk(JSPUtil.getParameter(request, prefix + "rqst_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrRoleNm(JSPUtil.getParameter(request, prefix + "usr_role_nm", ""));
		setRqstStDt(JSPUtil.getParameter(request, prefix + "rqst_st_dt", ""));
		setAproRqstNo(JSPUtil.getParameter(request, prefix + "apro_rqst_no", ""));
		setAproUsrId(JSPUtil.getParameter(request, prefix + "apro_usr_id", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setApstsCd(JSPUtil.getParameter(request, prefix + "apsts_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setRoleModule(JSPUtil.getParameter(request, prefix + "role_module", ""));
		setRoleAuth(JSPUtil.getParameter(request, prefix + "role_auth", ""));
		setOrgUsrRoleCd(JSPUtil.getParameter(request, prefix + "org_usr_role_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AdjustmentVO[]
	 */
	public AuthorityVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AdjustmentVO[]
	 */
	public AuthorityVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuthorityVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] aproRmk = (JSPUtil.getParameter(request, prefix	+ "apro_rmk", length));
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] rqstUsrNm = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_nm", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] usrRoleRqstTpNm = (JSPUtil.getParameter(request, prefix	+ "usr_role_rqst_tp_nm", length));
			String[] usrRoleCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_cd", length));
			String[] aproUsrNm = (JSPUtil.getParameter(request, prefix	+ "apro_usr_nm", length));
			String[] apstsNm = (JSPUtil.getParameter(request, prefix	+ "apsts_nm", length));
			String[] ofcTpCd = (JSPUtil.getParameter(request, prefix	+ "ofc_tp_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rqstOfcNm = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_nm", length));
			String[] rqstRmk = (JSPUtil.getParameter(request, prefix	+ "rqst_rmk", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrRoleNm = (JSPUtil.getParameter(request, prefix	+ "usr_role_nm", length));
			String[] rqstStDt = (JSPUtil.getParameter(request, prefix	+ "rqst_st_dt", length));
			String[] aproRqstNo = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_no", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] apstsCd = (JSPUtil.getParameter(request, prefix	+ "apsts_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] roleModule = (JSPUtil.getParameter(request, prefix	+ "role_module", length));
			String[] roleAuth = (JSPUtil.getParameter(request, prefix	+ "role_auth", length));
			String[] orgUsrRoleCd = (JSPUtil.getParameter(request, prefix	+ "org_usr_role_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new AuthorityVO();
				if (aproRmk[i] != null)
					model.setAproRmk(aproRmk[i]);
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (rqstUsrNm[i] != null)
					model.setRqstUsrNm(rqstUsrNm[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (usrRoleRqstTpNm[i] != null)
					model.setUsrRoleRqstTpNm(usrRoleRqstTpNm[i]);
				if (usrRoleCd[i] != null)
					model.setUsrRoleCd(usrRoleCd[i]);
				if (aproUsrNm[i] != null)
					model.setAproUsrNm(aproUsrNm[i]);
				if (apstsNm[i] != null)
					model.setApstsNm(apstsNm[i]);
				if (ofcTpCd[i] != null)
					model.setOfcTpCd(ofcTpCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rqstOfcNm[i] != null)
					model.setRqstOfcNm(rqstOfcNm[i]);
				if (rqstRmk[i] != null)
					model.setRqstRmk(rqstRmk[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrRoleNm[i] != null)
					model.setUsrRoleNm(usrRoleNm[i]);
				if (rqstStDt[i] != null)
					model.setRqstStDt(rqstStDt[i]);
				if (aproRqstNo[i] != null)
					model.setAproRqstNo(aproRqstNo[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (apstsCd[i] != null)
					model.setApstsCd(apstsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (roleModule[i] != null)
					model.setRoleModule(roleModule[i]);
				if (roleAuth[i] != null)
					model.setRoleAuth(roleAuth[i]);
				if (orgUsrRoleCd[i] != null)
					model.setUsrRoleCd(orgUsrRoleCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuthorityVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AdjustmentVO[]
	 */
	public AuthorityVO[] getAuthorityVOs(){
		AuthorityVO[] vos = (AuthorityVO[])models.toArray(new AuthorityVO[models.size()]);
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
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrNm = this.rqstUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleRqstTpNm = this.usrRoleRqstTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleCd = this.usrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrNm = this.aproUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apstsNm = this.apstsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcTpCd = this.ofcTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcNm = this.rqstOfcNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstRmk = this.rqstRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleNm = this.usrRoleNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstStDt = this.rqstStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstNo = this.aproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apstsCd = this.apstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roleModule = this.roleModule .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roleAuth = this.roleAuth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgUsrRoleCd = this.orgUsrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
