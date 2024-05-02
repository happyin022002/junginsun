/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : MenuListVO.java
*@FileTitle : MenuListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.05.27
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2013.05.27 최덕우 
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

public class MenuListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MenuListVO> models = new ArrayList<MenuListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrRoleCd = null;
	/* Column Info */
	private String prntPgmNo = null;
	/* Column Info */
	private String pgmNm = null;
	/* Column Info */
	private String auth = null;
	/* Column Info */
	private String pgmNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String level = null;
	/* Page Number */
	private String pgmNoForm = null;
	/* Page Number */
	private String creUsrId = null;
	/* Page Number */
	private String updUsrId = null;
	/* Column Info */
	private String checkVal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public MenuListVO() {}

	public MenuListVO(String ibflag, String pagerows, String checkVal, String usrRoleCd, String prntPgmNo, String pgmNo, String pgmNm, String auth, String level, String pgmNoForm, String CreUsrId, String UpdUsrId) {
		this.ibflag = ibflag;
		this.checkVal = checkVal;
		this.usrRoleCd = usrRoleCd;
		this.prntPgmNo = prntPgmNo;
		this.pgmNm = pgmNm;
		this.auth = auth;
		this.pgmNo = pgmNo;
		this.pagerows = pagerows;
		this.level = level;
		this.pgmNoForm = pgmNoForm;
		this.creUsrId = creUsrId;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("check_val", getCheckVal());
		this.hashColumns.put("usr_role_cd", getUsrRoleCd());
		this.hashColumns.put("prnt_pgm_no", getPrntPgmNo());
		this.hashColumns.put("pgm_nm", getPgmNm());
		this.hashColumns.put("auth", getAuth());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("level", getLevel());
		this.hashColumns.put("pgm_no_form", getPgmNoForm());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("check_val", "checkVal");
		this.hashFields.put("usr_role_cd", "usrRoleCd");
		this.hashFields.put("prnt_pgm_no", "prntPgmNo");
		this.hashFields.put("pgm_nm", "pgmNm");
		this.hashFields.put("auth", "auth");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("level", "level");
		this.hashFields.put("pgm_no_form", "pgmNoForm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return usrRoleCd
	 */
	public String getUsrRoleCd() {
		return this.usrRoleCd;
	}
	
	/**
	 * Column Info
	 * @return prntPgmNo
	 */
	public String getPrntPgmNo() {
		return this.prntPgmNo;
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
	 * @return auth
	 */
	public String getAuth() {
		return this.auth;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
	 * @param prntPgmNo
	 */
	public void setPrntPgmNo(String prntPgmNo) {
		this.prntPgmNo = prntPgmNo;
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
	 * @param auth
	 */
	public void setAuth(String auth) {
		this.auth = auth;
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
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	/**
	 * @return the pgmNoForm
	 */
	public String getPgmNoForm() {
		return pgmNoForm;
	}

	/**
	 * @param pgmNoForm the pgmNoForm to set
	 */
	public void setPgmNoForm(String pgmNoForm) {
		this.pgmNoForm = pgmNoForm;
	}
	
	/**
	 * @return the creUsrId
	 */
	public String getCreUsrId() {
		return creUsrId;
	}

	/**
	 * @param creUsrId the creUsrId to set
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}

	/**
	 * @return the updUsrId
	 */
	public String getUpdUsrId() {
		return updUsrId;
	}

	/**
	 * @param updUsrId the updUsrId to set
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * @return the checkVal
	 */
	public String getCheckVal() {
		return checkVal;
	}

	/**
	 * @param checkVal the checkVal to set
	 */
	public void setCheckVal(String checkVal) {
		this.checkVal = checkVal;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCheckVal(JSPUtil.getParameter(request, prefix + "check_val", ""));
		setUsrRoleCd(JSPUtil.getParameter(request, prefix + "usr_role_cd", ""));
		setPrntPgmNo(JSPUtil.getParameter(request, prefix + "prnt_pgm_no", ""));
		setPgmNm(JSPUtil.getParameter(request, prefix + "pgm_nm", ""));
		setAuth(JSPUtil.getParameter(request, prefix + "auth", ""));
		setPgmNo(JSPUtil.getParameter(request, prefix + "pgm_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setLevel(JSPUtil.getParameter(request, prefix + "level", ""));
		setPgmNoForm(JSPUtil.getParameter(request, prefix + "pgm_no_form", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MenuListVO[]
	 */
	public MenuListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MenuListVO[]
	 */
	public MenuListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MenuListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] checkVal = (JSPUtil.getParameter(request, prefix	+ "check_val", length));
			String[] usrRoleCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_cd", length));
			String[] prntPgmNo = (JSPUtil.getParameter(request, prefix	+ "prnt_pgm_no", length));
			String[] pgmNm = (JSPUtil.getParameter(request, prefix	+ "pgm_nm", length));
			String[] auth = (JSPUtil.getParameter(request, prefix	+ "auth", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] level = (JSPUtil.getParameter(request, prefix	+ "level", length));
			String[] pgmNoForm = (JSPUtil.getParameter(request, prefix	+ "pgm_no_form", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new MenuListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (checkVal[i] != null)
					model.setCheckVal(checkVal[i]);
				if (usrRoleCd[i] != null)
					model.setUsrRoleCd(usrRoleCd[i]);
				if (prntPgmNo[i] != null)
					model.setPrntPgmNo(prntPgmNo[i]);
				if (pgmNm[i] != null)
					model.setPgmNm(pgmNm[i]);
				if (auth[i] != null)
					model.setAuth(auth[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (level[i] != null)
					model.setLevel(level[i]);
				if (pgmNoForm[i] != null)
					model.setPgmNoForm(pgmNoForm[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMenuListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MenuListVO[]
	 */
	public MenuListVO[] getMenuListVOs(){
		MenuListVO[] vos = (MenuListVO[])models.toArray(new MenuListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkVal = this.checkVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleCd = this.usrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prntPgmNo = this.prntPgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNm = this.pgmNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auth = this.auth .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.level = this.level .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNoForm = this.pgmNoForm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
