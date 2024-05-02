/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : JooCodeInfoVO.java
*@FileTitle : JooCodeInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.13
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2010.01.13 박희동 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo;

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
 * @author 박희동
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class JooCodeInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JooCodeInfoVO> models = new ArrayList<JooCodeInfoVO>();
	
	/* Column Info */
	private String authCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String superCd1 = null;
	/* Column Info */
	private String superCd2 = null;
	/* Column Info */
	private String name = null;
	/* Column Info */
	private String code = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String approval = null;	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JooCodeInfoVO() {}

	public JooCodeInfoVO(String ibflag, String pagerows, String code, String name, String superCd1, String superCd2, String authCd, String approval) {
		this.authCd = authCd;
		this.ibflag = ibflag;
		this.superCd1 = superCd1;
		this.superCd2 = superCd2;
		this.name = name;
		this.code = code;
		this.pagerows = pagerows;
		this.approval = approval;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("auth_cd", getAuthCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("super_cd1", getSuperCd1());
		this.hashColumns.put("super_cd2", getSuperCd2());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("approval", getApproval());		
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("auth_cd", "authCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("super_cd1", "superCd1");
		this.hashFields.put("super_cd2", "superCd2");
		this.hashFields.put("name", "name");
		this.hashFields.put("code", "code");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("approval", "approval");		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return authCd
	 */
	public String getAuthCd() {
		return this.authCd;
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
	 * @return superCd1
	 */
	public String getSuperCd1() {
		return this.superCd1;
	}
	
	/**
	 * Column Info
	 * @return superCd2
	 */
	public String getSuperCd2() {
		return this.superCd2;
	}
	
	/**
	 * Column Info
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Column Info
	 * @return code
	 */
	public String getCode() {
		return this.code;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Page approval
	 * @return approval
	 */
	public String getApproval() {
		return this.approval;
	}
	
	/**
	 * Column Info
	 * @param authCd
	 */
	public void setAuthCd(String authCd) {
		this.authCd = authCd;
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
	 * @param superCd1
	 */
	public void setSuperCd1(String superCd1) {
		this.superCd1 = superCd1;
	}
	
	/**
	 * Column Info
	 * @param superCd2
	 */
	public void setSuperCd2(String superCd2) {
		this.superCd2 = superCd2;
	}
	
	/**
	 * Column Info
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Column Info
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	

	/**
	 * approval
	 * @param approval
	 */
	public void setApproval(String approval) {
		this.approval = approval;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setAuthCd(JSPUtil.getParameter(request, "auth_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSuperCd1(JSPUtil.getParameter(request, "super_cd1", ""));
		setSuperCd2(JSPUtil.getParameter(request, "super_cd2", ""));
		setName(JSPUtil.getParameter(request, "name", ""));
		setCode(JSPUtil.getParameter(request, "code", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setApproval(JSPUtil.getParameter(request, "approval", ""));		
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JooCodeInfoVO[]
	 */
	public JooCodeInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JooCodeInfoVO[]
	 */
	public JooCodeInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JooCodeInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] authCd = (JSPUtil.getParameter(request, prefix	+ "auth_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] superCd1 = (JSPUtil.getParameter(request, prefix	+ "super_cd1", length));
			String[] superCd2 = (JSPUtil.getParameter(request, prefix	+ "super_cd2", length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name", length));
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] approval = (JSPUtil.getParameter(request, prefix	+ "approval", length));			
			
			
			for (int i = 0; i < length; i++) {
				model = new JooCodeInfoVO();
				if (authCd[i] != null)
					model.setAuthCd(authCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (superCd1[i] != null)
					model.setSuperCd1(superCd1[i]);
				if (superCd2[i] != null)
					model.setSuperCd2(superCd2[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (code[i] != null)
					model.setCode(code[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (approval[i] != null)
					model.setApproval(approval[i]);
				
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJooCodeInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JooCodeInfoVO[]
	 */
	public JooCodeInfoVO[] getJooCodeInfoVOs(){
		JooCodeInfoVO[] vos = (JooCodeInfoVO[])models.toArray(new JooCodeInfoVO[models.size()]);
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
		this.authCd = this.authCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.superCd1 = this.superCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.superCd2 = this.superCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approval = this.approval .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
		
	}
}
