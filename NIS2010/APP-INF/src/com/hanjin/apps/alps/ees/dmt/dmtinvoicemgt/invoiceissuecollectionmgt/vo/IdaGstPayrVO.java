/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : IdaGstPayrVO.java
*@FileTitle : IdaGstPayrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2017.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2017.08.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo;

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
public class IdaGstPayrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<IdaGstPayrVO> models = new ArrayList<IdaGstPayrVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String idaPanNo = null;

	/* Column Info */
	private String idaGstRgstNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public IdaGstPayrVO() {}

	public IdaGstPayrVO(String ibflag, String pagerows, String idaPanNo, String idaGstRgstNo) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.idaPanNo = idaPanNo;
		this.idaGstRgstNo = idaGstRgstNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ida_pan_no", getIdaPanNo());
		this.hashColumns.put("ida_gst_rgst_no", getIdaGstRgstNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ida_pan_no", "idaPanNo");
		this.hashFields.put("ida_gst_rgst_no", "idaGstRgstNo");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String idaPanNo
	 */
	public void setIdaPanNo(String idaPanNo) {
		this.idaPanNo = idaPanNo;
	}
	
	/**
	 * 
	 * @return String idaPanNo
	 */
	public String getIdaPanNo() {
		return this.idaPanNo;
	}
	
	/**
	 *
	 * @param String idaGstRgstNo
	 */
	public void setIdaGstRgstNo(String idaGstRgstNo) {
		this.idaGstRgstNo = idaGstRgstNo;
	}
	
	/**
	 * 
	 * @return String idaGstRgstNo
	 */
	public String getIdaGstRgstNo() {
		return this.idaGstRgstNo;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIdaPanNo(JSPUtil.getParameter(request, prefix + "ida_pan_no", ""));
		setIdaGstRgstNo(JSPUtil.getParameter(request, prefix + "ida_gst_rgst_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return IdaGstPayrVO[]
	 */
	public IdaGstPayrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return IdaGstPayrVO[]
	 */
	public IdaGstPayrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		IdaGstPayrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] idaPanNo = (JSPUtil.getParameter(request, prefix	+ "ida_pan_no", length));
			String[] idaGstRgstNo = (JSPUtil.getParameter(request, prefix	+ "ida_gst_rgst_no", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new IdaGstPayrVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (idaPanNo[i] != null) 
					model.setIdaPanNo(idaPanNo[i]);
				if (idaGstRgstNo[i] != null) 
					model.setIdaGstRgstNo(idaGstRgstNo[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getIdaGstPayrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return IdaGstPayrVO[]
	 */
	public IdaGstPayrVO[] getIdaGstPayrVOs(){
		IdaGstPayrVO[] vos = (IdaGstPayrVO[])models.toArray(new IdaGstPayrVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaPanNo = this.idaPanNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaGstRgstNo = this.idaGstRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}