/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UserRoleVO.java
*@FileTitle : UserRoleVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.07
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UserRoleVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UserRoleVO> models = new ArrayList<UserRoleVO>();
	
	/* Column Info */
	private String etc6 = null;
	/* Column Info */
	private String etc4 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String etc5 = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String usrRoleCd = null;
	/* Column Info */
	private String etc1 = null;
	/* Column Info */
	private String isAuthorized = null;
	/* Column Info */
	private String etc3 = null;
	/* Column Info */
	private String pgmNo = null;
	/* Column Info */
	private String etc2 = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UserRoleVO() {}

	public UserRoleVO(String ibflag, String pagerows, String usrId, String usrRoleCd, String pgmNo, String isAuthorized, String etc1, String etc2, String etc3, String etc4, String etc5, String etc6) {
		this.etc6 = etc6;
		this.etc4 = etc4;
		this.ibflag = ibflag;
		this.etc5 = etc5;
		this.usrId = usrId;
		this.usrRoleCd = usrRoleCd;
		this.etc1 = etc1;
		this.isAuthorized = isAuthorized;
		this.etc3 = etc3;
		this.pgmNo = pgmNo;
		this.etc2 = etc2;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("etc6", getEtc6());
		this.hashColumns.put("etc4", getEtc4());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("etc5", getEtc5());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("usr_role_cd", getUsrRoleCd());
		this.hashColumns.put("etc1", getEtc1());
		this.hashColumns.put("is_authorized", getIsAuthorized());
		this.hashColumns.put("etc3", getEtc3());
		this.hashColumns.put("pgm_no", getPgmNo());
		this.hashColumns.put("etc2", getEtc2());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("etc6", "etc6");
		this.hashFields.put("etc4", "etc4");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("etc5", "etc5");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("usr_role_cd", "usrRoleCd");
		this.hashFields.put("etc1", "etc1");
		this.hashFields.put("is_authorized", "isAuthorized");
		this.hashFields.put("etc3", "etc3");
		this.hashFields.put("pgm_no", "pgmNo");
		this.hashFields.put("etc2", "etc2");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return etc6
	 */
	public String getEtc6() {
		return this.etc6;
	}
	
	/**
	 * Column Info
	 * @return etc4
	 */
	public String getEtc4() {
		return this.etc4;
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
	 * @return etc5
	 */
	public String getEtc5() {
		return this.etc5;
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
	 * @return usrRoleCd
	 */
	public String getUsrRoleCd() {
		return this.usrRoleCd;
	}
	
	/**
	 * Column Info
	 * @return etc1
	 */
	public String getEtc1() {
		return this.etc1;
	}
	
	/**
	 * Column Info
	 * @return isAuthorized
	 */
	public String getIsAuthorized() {
		return this.isAuthorized;
	}
	
	/**
	 * Column Info
	 * @return etc3
	 */
	public String getEtc3() {
		return this.etc3;
	}
	
	/**
	 * Column Info
	 * @return pgmNo
	 */
	public String getPgmNo() {
		return this.pgmNo;
	}
	
	/**
	 * Column Info
	 * @return etc2
	 */
	public String getEtc2() {
		return this.etc2;
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
	 * @param etc6
	 */
	public void setEtc6(String etc6) {
		this.etc6 = etc6;
	}
	
	/**
	 * Column Info
	 * @param etc4
	 */
	public void setEtc4(String etc4) {
		this.etc4 = etc4;
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
	 * @param etc5
	 */
	public void setEtc5(String etc5) {
		this.etc5 = etc5;
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
	 * @param usrRoleCd
	 */
	public void setUsrRoleCd(String usrRoleCd) {
		this.usrRoleCd = usrRoleCd;
	}
	
	/**
	 * Column Info
	 * @param etc1
	 */
	public void setEtc1(String etc1) {
		this.etc1 = etc1;
	}
	
	/**
	 * Column Info
	 * @param isAuthorized
	 */
	public void setIsAuthorized(String isAuthorized) {
		this.isAuthorized = isAuthorized;
	}
	
	/**
	 * Column Info
	 * @param etc3
	 */
	public void setEtc3(String etc3) {
		this.etc3 = etc3;
	}
	
	/**
	 * Column Info
	 * @param pgmNo
	 */
	public void setPgmNo(String pgmNo) {
		this.pgmNo = pgmNo;
	}
	
	/**
	 * Column Info
	 * @param etc2
	 */
	public void setEtc2(String etc2) {
		this.etc2 = etc2;
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
		setEtc6(JSPUtil.getParameter(request, "etc6", ""));
		setEtc4(JSPUtil.getParameter(request, "etc4", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEtc5(JSPUtil.getParameter(request, "etc5", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setUsrRoleCd(JSPUtil.getParameter(request, "usr_role_cd", ""));
		setEtc1(JSPUtil.getParameter(request, "etc1", ""));
		setIsAuthorized(JSPUtil.getParameter(request, "is_authorized", ""));
		setEtc3(JSPUtil.getParameter(request, "etc3", ""));
		setPgmNo(JSPUtil.getParameter(request, "pgm_no", ""));
		setEtc2(JSPUtil.getParameter(request, "etc2", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UserRoleVO[]
	 */
	public UserRoleVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UserRoleVO[]
	 */
	public UserRoleVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UserRoleVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] etc6 = (JSPUtil.getParameter(request, prefix	+ "etc6", length));
			String[] etc4 = (JSPUtil.getParameter(request, prefix	+ "etc4", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] etc5 = (JSPUtil.getParameter(request, prefix	+ "etc5", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] usrRoleCd = (JSPUtil.getParameter(request, prefix	+ "usr_role_cd", length));
			String[] etc1 = (JSPUtil.getParameter(request, prefix	+ "etc1", length));
			String[] isAuthorized = (JSPUtil.getParameter(request, prefix	+ "is_authorized", length));
			String[] etc3 = (JSPUtil.getParameter(request, prefix	+ "etc3", length));
			String[] pgmNo = (JSPUtil.getParameter(request, prefix	+ "pgm_no", length));
			String[] etc2 = (JSPUtil.getParameter(request, prefix	+ "etc2", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UserRoleVO();
				if (etc6[i] != null)
					model.setEtc6(etc6[i]);
				if (etc4[i] != null)
					model.setEtc4(etc4[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (etc5[i] != null)
					model.setEtc5(etc5[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (usrRoleCd[i] != null)
					model.setUsrRoleCd(usrRoleCd[i]);
				if (etc1[i] != null)
					model.setEtc1(etc1[i]);
				if (isAuthorized[i] != null)
					model.setIsAuthorized(isAuthorized[i]);
				if (etc3[i] != null)
					model.setEtc3(etc3[i]);
				if (pgmNo[i] != null)
					model.setPgmNo(pgmNo[i]);
				if (etc2[i] != null)
					model.setEtc2(etc2[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUserRoleVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UserRoleVO[]
	 */
	public UserRoleVO[] getUserRoleVOs(){
		UserRoleVO[] vos = (UserRoleVO[])models.toArray(new UserRoleVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.etc6 = this.etc6 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc4 = this.etc4 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc5 = this.etc5 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrRoleCd = this.usrRoleCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc1 = this.etc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isAuthorized = this.isAuthorized .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc3 = this.etc3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pgmNo = this.pgmNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etc2 = this.etc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
