/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : JobCodeManagementVO.java
*@FileTitle : JobCodeManagementVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.06.18
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.06.18 최덕우 
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.management.alps.jobcodemanagement.vo;

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

public class JobCodeManagementVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JobCodeManagementVO> models = new ArrayList<JobCodeManagementVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String usrRoleCd = null;
	/* Column Info */
	private String usrRoleDesc = null;
	/* Column Info */
	private String admAss = null;
	/* Column Info */
	private String pgmNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pgmAss = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrRoleNm = null;
	/* Column Info */
	private String ofcAss = null;
	/* Column Info */
	private String usr = null;
	/* Column Info */
	private String updUsrNm = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JobCodeManagementVO() {}

	public JobCodeManagementVO(String ibflag, String pagerows, String usrRoleCd, String usrRoleNm, String usrRoleDesc, String updUsrId, String updUsrNm, String updDt, String pgmNo, String ofcAss, String usr, String pgmAss, String admAss) {
		this.updDt = updDt;
		this.usrRoleCd = usrRoleCd;
		this.usrRoleDesc = usrRoleDesc;
		this.admAss = admAss;
		this.pgmNo = pgmNo;
		this.pagerows = pagerows;
		this.pgmAss = pgmAss;
		this.ibflag = ibflag;
		this.usrRoleNm = usrRoleNm;
		this.ofcAss = ofcAss;
		this.usr = usr;
		this.updUsrNm = updUsrNm;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("usr_role_cd", getUsrRoleCd());
		this.hashColumns.put("usr_role_desc", getUsrRoleDesc());
		this.hashColumns.put("adm_ass", getAdmAss());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pgm_ass", getPgmAss());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_role_nm", getUsrRoleNm());
		this.hashColumns.put("ofc_ass", getOfcAss());
		this.hashColumns.put("usr", getUsr());
		this.hashColumns.put("upd_usr_nm", getUpdUsrNm());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("usr_role_cd", "usrRoleCd");
		this.hashFields.put("usr_role_desc", "usrRoleDesc");
		this.hashFields.put("adm_ass", "admAss");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pgm_ass", "pgmAss");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_role_nm", "usrRoleNm");
		this.hashFields.put("ofc_ass", "ofcAss");
		this.hashFields.put("usr", "usr");
		this.hashFields.put("upd_usr_nm", "updUsrNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
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
	 * @return usrRoleDesc
	 */
	public String getUsrRoleDesc() {
		return this.usrRoleDesc;
	}
	
	/**
	 * Column Info
	 * @return admAss
	 */
	public String getAdmAss() {
		return this.admAss;
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
	 * @return pgmAss
	 */
	public String getPgmAss() {
		return this.pgmAss;
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
	 * @return ofcAss
	 */
	public String getOfcAss() {
		return this.ofcAss;
	}
	
	/**
	 * Column Info
	 * @return usr
	 */
	public String getUsr() {
		return this.usr;
	}
	
	/**
	 * Column Info
	 * @return updUsrNm
	 */
	public String getUpdUsrNm() {
		return this.updUsrNm;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
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
	 * @param usrRoleDesc
	 */
	public void setUsrRoleDesc(String usrRoleDesc) {
		this.usrRoleDesc = usrRoleDesc;
	}
	
	/**
	 * Column Info
	 * @param admAss
	 */
	public void setAdmAss(String admAss) {
		this.admAss = admAss;
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
	 * @param pgmAss
	 */
	public void setPgmAss(String pgmAss) {
		this.pgmAss = pgmAss;
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
	 * @param ofcAss
	 */
	public void setOfcAss(String ofcAss) {
		this.ofcAss = ofcAss;
	}
	
	/**
	 * Column Info
	 * @param usr
	 */
	public void setUsr(String usr) {
		this.usr = usr;
	}
	
	/**
	 * Column Info
	 * @param updUsrNm
	 */
	public void setUpdUsrNm(String updUsrNm) {
		this.updUsrNm = updUsrNm;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
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
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setUsrRoleCd(JSPUtil.getParameter(request, prefix + "usr_role_cd", ""));
		setUsrRoleDesc(JSPUtil.getParameter(request, prefix + "usr_role_desc", ""));
		setAdmAss(JSPUtil.getParameter(request, prefix + "adm_ass", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPgmAss(JSPUtil.getParameter(request, prefix + "pgm_ass", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrRoleNm(JSPUtil.getParameter(request, prefix + "usr_role_nm", ""));
		setOfcAss(JSPUtil.getParameter(request, prefix + "ofc_ass", ""));
		setUsr(JSPUtil.getParameter(request, prefix + "usr", ""));
		setUpdUsrNm(JSPUtil.getParameter(request, prefix + "upd_usr_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JobCodeManagementVO[]
	 */
	public JobCodeManagementVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JobCodeManagementVO[]
	 */
	public JobCodeManagementVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JobCodeManagementVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] usrRoleCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_cd", length));
			String[] usrRoleDesc = (JSPUtil.getParameter(request, prefix	+ "usr_role_desc", length));
			String[] admAss = (JSPUtil.getParameter(request, prefix	+ "adm_ass", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pgmAss = (JSPUtil.getParameter(request, prefix	+ "pgm_ass", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrRoleNm = (JSPUtil.getParameter(request, prefix	+ "usr_role_nm", length));
			String[] ofcAss = (JSPUtil.getParameter(request, prefix	+ "ofc_ass", length));
			String[] usr = (JSPUtil.getParameter(request, prefix	+ "usr", length));
			String[] updUsrNm = (JSPUtil.getParameter(request, prefix	+ "upd_usr_nm", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new JobCodeManagementVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (usrRoleCd[i] != null)
					model.setUsrRoleCd(usrRoleCd[i]);
				if (usrRoleDesc[i] != null)
					model.setUsrRoleDesc(usrRoleDesc[i]);
				if (admAss[i] != null)
					model.setAdmAss(admAss[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pgmAss[i] != null)
					model.setPgmAss(pgmAss[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrRoleNm[i] != null)
					model.setUsrRoleNm(usrRoleNm[i]);
				if (ofcAss[i] != null)
					model.setOfcAss(ofcAss[i]);
				if (usr[i] != null)
					model.setUsr(usr[i]);
				if (updUsrNm[i] != null)
					model.setUpdUsrNm(updUsrNm[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJobCodeManagementVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JobCodeManagementVO[]
	 */
	public JobCodeManagementVO[] getJobCodeManagementVOs(){
		JobCodeManagementVO[] vos = (JobCodeManagementVO[])models.toArray(new JobCodeManagementVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleCd = this.usrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleDesc = this.usrRoleDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.admAss = this.admAss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmAss = this.pgmAss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleNm = this.usrRoleNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcAss = this.ofcAss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usr = this.usr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrNm = this.updUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
