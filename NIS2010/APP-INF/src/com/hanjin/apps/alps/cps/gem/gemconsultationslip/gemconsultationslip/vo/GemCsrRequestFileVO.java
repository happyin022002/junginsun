/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GemCsrRequestFileVO.java
*@FileTitle : GemCsrRequestFileVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.08
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo;

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

public class GemCsrRequestFileVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemCsrRequestFileVO> models = new ArrayList<GemCsrRequestFileVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String lFileNm = null;
	/* Column Info */
	private String lFileModuleId = null;
	/* Column Info */
	private String lFileSavId = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GemCsrRequestFileVO() {}

	public GemCsrRequestFileVO(String ibflag, String pagerows, String lFileModuleId, String lFileSavId, String lFileNm) {
		this.ibflag = ibflag;
		this.lFileNm = lFileNm;
		this.lFileModuleId = lFileModuleId;
		this.lFileSavId = lFileSavId;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("l_file_nm", getLFileNm());
		this.hashColumns.put("l_file_module_id", getLFileModuleId());
		this.hashColumns.put("l_file_sav_id", getLFileSavId());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("l_file_nm", "lFileNm");
		this.hashFields.put("l_file_module_id", "lFileModuleId");
		this.hashFields.put("l_file_sav_id", "lFileSavId");
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
	 * @return lFileNm
	 */
	public String getLFileNm() {
		return this.lFileNm;
	}
	
	/**
	 * Column Info
	 * @return lFileModuleId
	 */
	public String getLFileModuleId() {
		return this.lFileModuleId;
	}
	
	/**
	 * Column Info
	 * @return lFileSavId
	 */
	public String getLFileSavId() {
		return this.lFileSavId;
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
	 * @param lFileNm
	 */
	public void setLFileNm(String lFileNm) {
		this.lFileNm = lFileNm;
	}
	
	/**
	 * Column Info
	 * @param lFileModuleId
	 */
	public void setLFileModuleId(String lFileModuleId) {
		this.lFileModuleId = lFileModuleId;
	}
	
	/**
	 * Column Info
	 * @param lFileSavId
	 */
	public void setLFileSavId(String lFileSavId) {
		this.lFileSavId = lFileSavId;
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
		setLFileNm(JSPUtil.getParameter(request, prefix + "l_file_nm", ""));
		setLFileModuleId(JSPUtil.getParameter(request, prefix + "l_file_module_id", ""));
		setLFileSavId(JSPUtil.getParameter(request, prefix + "l_file_sav_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemCsrRequestFileVO[]
	 */
	public GemCsrRequestFileVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemCsrRequestFileVO[]
	 */
	public GemCsrRequestFileVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemCsrRequestFileVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] lFileNm = (JSPUtil.getParameter(request, prefix	+ "l_file_nm", length));
			String[] lFileModuleId = (JSPUtil.getParameter(request, prefix	+ "l_file_module_id", length));
			String[] lFileSavId = (JSPUtil.getParameter(request, prefix	+ "l_file_sav_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemCsrRequestFileVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (lFileNm[i] != null)
					model.setLFileNm(lFileNm[i]);
				if (lFileModuleId[i] != null)
					model.setLFileModuleId(lFileModuleId[i]);
				if (lFileSavId[i] != null)
					model.setLFileSavId(lFileSavId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemCsrRequestFileVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemCsrRequestFileVO[]
	 */
	public GemCsrRequestFileVO[] getGemCsrRequestFileVOs(){
		GemCsrRequestFileVO[] vos = (GemCsrRequestFileVO[])models.toArray(new GemCsrRequestFileVO[models.size()]);
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
		this.lFileNm = this.lFileNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lFileModuleId = this.lFileModuleId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lFileSavId = this.lFileSavId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
