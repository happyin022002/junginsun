/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UseStatusConForVO.java
*@FileTitle : UseStatusConForVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.17
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.17 정명훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.pso.portsomasterdatamgt.porttariffmgt.vo;

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
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UseStatusConForVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<UseStatusConForVO> models = new ArrayList<UseStatusConForVO>();
	
	/* Column Info */
	private String caller = null;
	/* Column Info */
	private String formcond = null;
	/* Column Info */
	private String combo3 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String combo2 = null;
	/* Column Info */
	private String combo1 = null;
	/* Column Info */
	private String creUsr = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UseStatusConForVO() {}

	public UseStatusConForVO(String ibflag, String pagerows, String formcond, String combo3, String combo2, String combo1, String creUsr, String caller) {
		this.caller = caller;
		this.formcond = formcond;
		this.combo3 = combo3;
		this.ibflag = ibflag;
		this.combo2 = combo2;
		this.combo1 = combo1;
		this.creUsr = creUsr;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("caller", getCaller());
		this.hashColumns.put("formcond", getFormcond());
		this.hashColumns.put("combo3", getCombo3());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("combo2", getCombo2());
		this.hashColumns.put("combo1", getCombo1());
		this.hashColumns.put("cre_usr", getCreUsr());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("caller", "caller");
		this.hashFields.put("formcond", "formcond");
		this.hashFields.put("combo3", "combo3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("combo2", "combo2");
		this.hashFields.put("combo1", "combo1");
		this.hashFields.put("cre_usr", "creUsr");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return caller
	 */
	public String getCaller() {
		return this.caller;
	}
	
	/**
	 * Column Info
	 * @return formcond
	 */
	public String getFormcond() {
		return this.formcond;
	}
	
	/**
	 * Column Info
	 * @return combo3
	 */
	public String getCombo3() {
		return this.combo3;
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
	 * @return combo2
	 */
	public String getCombo2() {
		return this.combo2;
	}
	
	/**
	 * Column Info
	 * @return combo1
	 */
	public String getCombo1() {
		return this.combo1;
	}
	
	/**
	 * Column Info
	 * @return creUsr
	 */
	public String getCreUsr() {
		return this.creUsr;
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
	 * @param caller
	 */
	public void setCaller(String caller) {
		this.caller = caller;
	}
	
	/**
	 * Column Info
	 * @param formcond
	 */
	public void setFormcond(String formcond) {
		this.formcond = formcond;
	}
	
	/**
	 * Column Info
	 * @param combo3
	 */
	public void setCombo3(String combo3) {
		this.combo3 = combo3;
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
	 * @param combo2
	 */
	public void setCombo2(String combo2) {
		this.combo2 = combo2;
	}
	
	/**
	 * Column Info
	 * @param combo1
	 */
	public void setCombo1(String combo1) {
		this.combo1 = combo1;
	}
	
	/**
	 * Column Info
	 * @param creUsr
	 */
	public void setCreUsr(String creUsr) {
		this.creUsr = creUsr;
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
		setCaller(JSPUtil.getParameter(request, prefix + "caller", ""));
		setFormcond(JSPUtil.getParameter(request, prefix + "formcond", ""));
		setCombo3(JSPUtil.getParameter(request, prefix + "combo3", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCombo2(JSPUtil.getParameter(request, prefix + "combo2", ""));
		setCombo1(JSPUtil.getParameter(request, prefix + "combo1", ""));
		setCreUsr(JSPUtil.getParameter(request, prefix + "cre_usr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UseStatusConForVO[]
	 */
	public UseStatusConForVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UseStatusConForVO[]
	 */
	public UseStatusConForVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UseStatusConForVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] caller = (JSPUtil.getParameter(request, prefix	+ "caller", length));
			String[] formcond = (JSPUtil.getParameter(request, prefix	+ "formcond", length));
			String[] combo3 = (JSPUtil.getParameter(request, prefix	+ "combo3", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] combo2 = (JSPUtil.getParameter(request, prefix	+ "combo2", length));
			String[] combo1 = (JSPUtil.getParameter(request, prefix	+ "combo1", length));
			String[] creUsr = (JSPUtil.getParameter(request, prefix	+ "cre_usr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new UseStatusConForVO();
				if (caller[i] != null)
					model.setCaller(caller[i]);
				if (formcond[i] != null)
					model.setFormcond(formcond[i]);
				if (combo3[i] != null)
					model.setCombo3(combo3[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (combo2[i] != null)
					model.setCombo2(combo2[i]);
				if (combo1[i] != null)
					model.setCombo1(combo1[i]);
				if (creUsr[i] != null)
					model.setCreUsr(creUsr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUseStatusConForVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UseStatusConForVO[]
	 */
	public UseStatusConForVO[] getUseStatusConForVOs(){
		UseStatusConForVO[] vos = (UseStatusConForVO[])models.toArray(new UseStatusConForVO[models.size()]);
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
		this.caller = this.caller .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formcond = this.formcond .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo3 = this.combo3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo2 = this.combo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.combo1 = this.combo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsr = this.creUsr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
