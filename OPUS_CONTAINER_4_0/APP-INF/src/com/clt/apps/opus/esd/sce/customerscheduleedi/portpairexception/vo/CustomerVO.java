/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JooCodeInfoVO.java
*@FileTitle : JooCodeInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.12 박희동 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.sce.customerscheduleedi.portpairexception.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer Object including Parameters)<br>
 * - 관련 Event에서 작성, 서버실행요청시 PDTO의 역할을 수행하는 Value Object<br>
 *
 * @author 박희동
 * @since J2EE 1.5
 */

public class CustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomerVO> models = new ArrayList<CustomerVO>();
	
	/* Column Info */
	private String code = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String superCd1 = null;
	/* Column Info */
	private String superCd2 = null;
	/* Column Info */
	private String name = null;
	/* Page Number */
	private String pagerows = null;

	/*	hashColumnInpo	*/
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	hashFildInpo	*/
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomerVO() {}

	public CustomerVO(String ibflag, String pagerows, String code, String name, String superCd1, String superCd2) {
		this.code = code;
		this.ibflag = ibflag;
		this.superCd1 = superCd1;
		this.superCd2 = superCd2;
		this.name = name;
		this.pagerows = pagerows;
	}
	
	/**
	 * hashColumnInpo
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("code", getCode());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("super_cd1", getSuperCd1());
		this.hashColumns.put("super_cd2", getSuperCd2());
		this.hashColumns.put("name", getName());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * hashFildInpo
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("code", "code");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("super_cd1", "superCd1");
		this.hashFields.put("super_cd2", "superCd2");
		this.hashFields.put("name", "name");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	public String getCode() {
		return this.code;
	}
	public String getIbflag() {
		return this.ibflag;
	}
	public String getSuperCd1() {
		return this.superCd1;
	}
	public String getSuperCd2() {
		return this.superCd2;
	}
	public String getName() {
		return this.name;
	}
	public String getPagerows() {
		return this.pagerows;
	}

	public void setCode(String code) {
		this.code = code;
		//this.code=true;
	}
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
		//this.ibflag=true;
	}
	public void setSuperCd1(String superCd1) {
		this.superCd1 = superCd1;
		//this.superCd1=true;
	}
	public void setSuperCd2(String superCd2) {
		this.superCd2 = superCd2;
		//this.superCd2=true;
	}
	public void setName(String name) {
		this.name = name;
		//this.name=true;
	}
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
		//this.pagerows=true;
	}
	public void fromRequest(HttpServletRequest request) {
		setCode(JSPUtil.getParameter(request, "code", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSuperCd1(JSPUtil.getParameter(request, "super_cd1", ""));
		setSuperCd2(JSPUtil.getParameter(request, "super_cd2", ""));
		setName(JSPUtil.getParameter(request, "name", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	public CustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	public CustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] code = (JSPUtil.getParameter(request, prefix	+ "code".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] superCd1 = (JSPUtil.getParameter(request, prefix	+ "super_cd1".trim(), length));
			String[] superCd2 = (JSPUtil.getParameter(request, prefix	+ "super_cd2".trim(), length));
			String[] name = (JSPUtil.getParameter(request, prefix	+ "name".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomerVO();
				if (code[i] != null)
					model.setCode(code[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (superCd1[i] != null)
					model.setSuperCd1(superCd1[i]);
				if (superCd2[i] != null)
					model.setSuperCd2(superCd2[i]);
				if (name[i] != null)
					model.setName(name[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {}
		return getJooCodeInfoVOs();
	}

	public CustomerVO[] getJooCodeInfoVOs(){
		CustomerVO[] vos = (CustomerVO[])models.toArray(new CustomerVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
	   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
    }
	
	/**
	* DataFormat 설정
	*/
	public void onDataFormat(){
		this.code = this.code .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.superCd1 = this.superCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.superCd2 = this.superCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.name = this.name .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
