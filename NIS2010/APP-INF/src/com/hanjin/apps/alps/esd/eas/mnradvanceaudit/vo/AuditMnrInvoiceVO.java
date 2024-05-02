/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AuditMnrInvoiceVO.java
*@FileTitle : AuditMnrInvoiceVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.29
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.10.29 박정민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo;

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
 * @author 박정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class AuditMnrInvoiceVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<AuditMnrInvoiceVO> models = new ArrayList<AuditMnrInvoiceVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String autoAudit = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String autoAuditDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public AuditMnrInvoiceVO() {}

	public AuditMnrInvoiceVO(String ibflag, String pagerows, String autoAudit, String autoAuditDesc) {
		this.pagerows = pagerows;
		this.autoAudit = autoAudit;
		this.ibflag = ibflag;
		this.autoAuditDesc = autoAuditDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("auto_audit", getAutoAudit());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("auto_audit_desc", getAutoAuditDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("auto_audit", "autoAudit");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("auto_audit_desc", "autoAuditDesc");
		return this.hashFields;
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
	 * @return autoAudit
	 */
	public String getAutoAudit() {
		return this.autoAudit;
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
	 * @return autoAuditDesc
	 */
	public String getAutoAuditDesc() {
		return this.autoAuditDesc;
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
	 * @param autoAudit
	 */
	public void setAutoAudit(String autoAudit) {
		this.autoAudit = autoAudit;
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
	 * @param autoAuditDesc
	 */
	public void setAutoAuditDesc(String autoAuditDesc) {
		this.autoAuditDesc = autoAuditDesc;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAutoAudit(JSPUtil.getParameter(request, prefix + "auto_audit", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAutoAuditDesc(JSPUtil.getParameter(request, prefix + "auto_audit_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AuditMnrInvoiceVO[]
	 */
	public AuditMnrInvoiceVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return AuditMnrInvoiceVO[]
	 */
	public AuditMnrInvoiceVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		AuditMnrInvoiceVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] autoAudit = (JSPUtil.getParameter(request, prefix	+ "auto_audit", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] autoAuditDesc = (JSPUtil.getParameter(request, prefix	+ "auto_audit_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new AuditMnrInvoiceVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (autoAudit[i] != null)
					model.setAutoAudit(autoAudit[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (autoAuditDesc[i] != null)
					model.setAutoAuditDesc(autoAuditDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAuditMnrInvoiceVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return AuditMnrInvoiceVO[]
	 */
	public AuditMnrInvoiceVO[] getAuditMnrInvoiceVOs(){
		AuditMnrInvoiceVO[] vos = (AuditMnrInvoiceVO[])models.toArray(new AuditMnrInvoiceVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoAudit = this.autoAudit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoAuditDesc = this.autoAuditDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
