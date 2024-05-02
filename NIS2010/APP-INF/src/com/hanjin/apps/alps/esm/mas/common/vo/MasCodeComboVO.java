/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : MasCodeComboVO.java
*@FileTitle : MasCodeComboVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.12.15
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2014.12.15 김종옥 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.common.vo;

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
 * @author 김종옥
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MasCodeComboVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<MasCodeComboVO> models = new ArrayList<MasCodeComboVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String codeId = null;
	/* Column Info */
	private String codeItem = null;
	/* Column Info */
	private String codeInit = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public MasCodeComboVO() {}

	public MasCodeComboVO(String ibflag, String pagerows, String codeItem, String codeId, String codeInit) {
		this.ibflag = ibflag;
		this.codeId = codeId;
		this.codeItem = codeItem;
		this.codeInit = codeInit;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("code_id", getCodeId());
		this.hashColumns.put("code_item", getCodeItem());
		this.hashColumns.put("code_init", getCodeInit());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("code_id", "codeId");
		this.hashFields.put("code_item", "codeItem");
		this.hashFields.put("code_init", "codeInit");
		this.hashFields.put("pagerows", "pagerows");
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
	 * @return codeId
	 */
	public String getCodeId() {
		return this.codeId;
	}
	
	/**
	 * Column Info
	 * @return codeItem
	 */
	public String getCodeItem() {
		return this.codeItem;
	}
	
	/**
	 * Column Info
	 * @return codeInit
	 */
	public String getCodeInit() {
		return this.codeInit;
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
	 * @param codeId
	 */
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	
	/**
	 * Column Info
	 * @param codeItem
	 */
	public void setCodeItem(String codeItem) {
		this.codeItem = codeItem;
	}
	
	/**
	 * Column Info
	 * @param codeInit
	 */
	public void setCodeInit(String codeInit) {
		this.codeInit = codeInit;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCodeId(JSPUtil.getParameter(request, prefix + "code_id", ""));
		setCodeItem(JSPUtil.getParameter(request, prefix + "code_item", ""));
		setCodeInit(JSPUtil.getParameter(request, prefix + "code_init", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MasCodeComboVO[]
	 */
	public MasCodeComboVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return MasCodeComboVO[]
	 */
	public MasCodeComboVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MasCodeComboVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] codeId = (JSPUtil.getParameter(request, prefix	+ "code_id", length));
			String[] codeItem = (JSPUtil.getParameter(request, prefix	+ "code_item", length));
			String[] codeInit = (JSPUtil.getParameter(request, prefix	+ "code_init", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new MasCodeComboVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (codeId[i] != null)
					model.setCodeId(codeId[i]);
				if (codeItem[i] != null)
					model.setCodeItem(codeItem[i]);
				if (codeInit[i] != null)
					model.setCodeInit(codeInit[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMasCodeComboVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MasCodeComboVO[]
	 */
	public MasCodeComboVO[] getMasCodeComboVOs(){
		MasCodeComboVO[] vos = (MasCodeComboVO[])models.toArray(new MasCodeComboVO[models.size()]);
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
		this.codeId = this.codeId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeItem = this.codeItem .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codeInit = this.codeInit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
