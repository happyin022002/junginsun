/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : RequestVO.java
*@FileTitle : RequestVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.09.04
*@LastModifier :허은정 
*@LastVersion : 1.0
* 2013.09.04  허은정
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
 * @author Heo
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RequestVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RequestVO> models = new ArrayList<RequestVO>();
	
	/* Column Info */
	private String checkVal = null;
	/* Column Info */
	private String usrRoleRqstTpCd = null;
	/* Column Info */
	private String usrRoleRqstTpNm = null;
	/* Column Info */
	private String rqstUsrId = null;
	/* Column Info */
	private String pgmAsgn = null;
	/* Column Info */
	private String usrRoleCd = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String aproRqstNo = null;
	/* Column Info */
	private String usrRoleNm = null;
	/* Column Info */
	private String rqstOfcCd = null;
	/* Column Info */
	private String apstsCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RequestVO() {}

	public RequestVO(String ibflag, String pagerows, String aproRqstNo, String usrRoleCd, String usrRoleNm, String usrRoleRqstTpCd, String usrRoleRqstTpNm, String rqstUsrId, String rqstOfcCd, String creUsrId, String updUsrId, String checkVal, String pgmAsgn, String apstsCd) {
		this.checkVal = checkVal;
		this.usrRoleRqstTpCd = usrRoleRqstTpCd;
		this.usrRoleRqstTpNm = usrRoleRqstTpNm;
		this.rqstUsrId = rqstUsrId;
		this.pgmAsgn = pgmAsgn;
		this.usrRoleCd = usrRoleCd;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.aproRqstNo = aproRqstNo;
		this.usrRoleNm = usrRoleNm;
		this.rqstOfcCd = rqstOfcCd;
		this.apstsCd = apstsCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("check_val", getCheckVal());
		this.hashColumns.put("usr_role_rqst_tp_cd", getUsrRoleRqstTpCd());
		this.hashColumns.put("usr_role_rqst_tp_nm", getUsrRoleRqstTpNm());
		this.hashColumns.put("rqst_usr_id", getRqstUsrId());
		this.hashColumns.put("pgm_asgn", getPgmAsgn());
		this.hashColumns.put("usr_role_cd", getUsrRoleCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("apro_rqst_no", getAproRqstNo());
		this.hashColumns.put("usr_role_nm", getUsrRoleNm());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		this.hashColumns.put("apsts_cd", getApstsCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("check_val", "checkVal");
		this.hashFields.put("usr_role_rqst_tp_cd", "usrRoleRqstTpCd");
		this.hashFields.put("usr_role_rqst_tp_nm", "usrRoleRqstTpNm");
		this.hashFields.put("rqst_usr_id", "rqstUsrId");
		this.hashFields.put("pgm_asgn", "pgmAsgn");
		this.hashFields.put("usr_role_cd", "usrRoleCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("apro_rqst_no", "aproRqstNo");
		this.hashFields.put("usr_role_nm", "usrRoleNm");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("apsts_cd", "apstsCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return checkVal
	 */
	public String getCheckVal() {
		return this.checkVal;
	}
	
	/**
	 * Column Info
	 * @return usrRoleRqstTpCd
	 */
	public String getUsrRoleRqstTpCd() {
		return this.usrRoleRqstTpCd;
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
	 * @return rqstUsrId
	 */
	public String getRqstUsrId() {
		return this.rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @return pgmAsgn
	 */
	public String getPgmAsgn() {
		return this.pgmAsgn;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	

	/**
	 * Column Info
	 * @param checkVal
	 */
	public void setCheckVal(String checkVal) {
		this.checkVal = checkVal;
	}
	
	/**
	 * Column Info
	 * @param usrRoleRqstTpCd
	 */
	public void setUsrRoleRqstTpCd(String usrRoleRqstTpCd) {
		this.usrRoleRqstTpCd = usrRoleRqstTpCd;
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
	 * @param rqstUsrId
	 */
	public void setRqstUsrId(String rqstUsrId) {
		this.rqstUsrId = rqstUsrId;
	}
	
	/**
	 * Column Info
	 * @param pgmAsgn
	 */
	public void setPgmAsgn(String pgmAsgn) {
		this.pgmAsgn = pgmAsgn;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
		setCheckVal(JSPUtil.getParameter(request, prefix + "check_val", ""));
		setUsrRoleRqstTpCd(JSPUtil.getParameter(request, prefix + "usr_role_rqst_tp_cd", ""));
		setUsrRoleRqstTpNm(JSPUtil.getParameter(request, prefix + "usr_role_rqst_tp_nm", ""));
		setRqstUsrId(JSPUtil.getParameter(request, prefix + "rqst_usr_id", ""));
		setPgmAsgn(JSPUtil.getParameter(request, prefix + "pgm_asgn", ""));
		setUsrRoleCd(JSPUtil.getParameter(request, prefix + "usr_role_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setAproRqstNo(JSPUtil.getParameter(request, prefix + "apro_rqst_no", ""));
		setUsrRoleNm(JSPUtil.getParameter(request, prefix + "usr_role_nm", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, prefix + "rqst_ofc_cd", ""));
		setApstsCd(JSPUtil.getParameter(request, prefix + "apsts_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RequestVO[]
	 */
	public RequestVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RequestVO[]
	 */
	public RequestVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RequestVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] checkVal = (JSPUtil.getParameter(request, prefix	+ "check_val", length));
			String[] usrRoleRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_rqst_tp_cd", length));
			String[] usrRoleRqstTpNm = (JSPUtil.getParameter(request, prefix	+ "usr_role_rqst_tp_nm", length));
			String[] rqstUsrId = (JSPUtil.getParameter(request, prefix	+ "rqst_usr_id", length));
			String[] pgmAsgn = (JSPUtil.getParameter(request, prefix	+ "pgm_asgn", length));
			String[] usrRoleCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] aproRqstNo = (JSPUtil.getParameter(request, prefix	+ "apro_rqst_no", length));
			String[] usrRoleNm = (JSPUtil.getParameter(request, prefix	+ "usr_role_nm", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			String[] apstsCd = (JSPUtil.getParameter(request, prefix	+ "apsts_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RequestVO();
				if (checkVal[i] != null)
					model.setCheckVal(checkVal[i]);
				if (usrRoleRqstTpCd[i] != null)
					model.setUsrRoleRqstTpCd(usrRoleRqstTpCd[i]);
				if (usrRoleRqstTpNm[i] != null)
					model.setUsrRoleRqstTpNm(usrRoleRqstTpNm[i]);
				if (rqstUsrId[i] != null)
					model.setRqstUsrId(rqstUsrId[i]);
				if (pgmAsgn[i] != null)
					model.setPgmAsgn(pgmAsgn[i]);
				if (usrRoleCd[i] != null)
					model.setUsrRoleCd(usrRoleCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (aproRqstNo[i] != null)
					model.setAproRqstNo(aproRqstNo[i]);
				if (usrRoleNm[i] != null)
					model.setUsrRoleNm(usrRoleNm[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				if (apstsCd[i] != null)
					model.setApstsCd(apstsCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRequestVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RequestVO[]
	 */
	public RequestVO[] getRequestVOs(){
		RequestVO[] vos = (RequestVO[])models.toArray(new RequestVO[models.size()]);
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
		this.checkVal = this.checkVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleRqstTpCd = this.usrRoleRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleRqstTpNm = this.usrRoleRqstTpNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstUsrId = this.rqstUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmAsgn = this.pgmAsgn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleCd = this.usrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproRqstNo = this.aproRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleNm = this.usrRoleNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apstsCd = this.apstsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
