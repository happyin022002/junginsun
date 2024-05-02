/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : RsltServiceScopePropertyMappingVO.java
*@FileTitle : RsltServiceScopePropertyMappingVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.24
*@LastModifier : 김성훈
*@LastVersion : 1.0
* 2012.04.24 김성훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.pricommondata.pricommondata.vo;

import java.lang.reflect.Field;
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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김성훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltServiceScopePropertyMappingVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltServiceScopePropertyMappingVO> models = new ArrayList<RsltServiceScopePropertyMappingVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String svcScpPptCd = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String svcScpPptDesc = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltServiceScopePropertyMappingVO() {}

	public RsltServiceScopePropertyMappingVO(String ibflag, String pagerows, String svcScpCd, String svcScpPptCd, String svcScpPptDesc) {
		this.ibflag = ibflag;
		this.svcScpPptCd = svcScpPptCd;
		this.svcScpCd = svcScpCd;
		this.svcScpPptDesc = svcScpPptDesc;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("svc_scp_ppt_cd", getSvcScpPptCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("svc_scp_ppt_desc", getSvcScpPptDesc());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("svc_scp_ppt_cd", "svcScpPptCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("svc_scp_ppt_desc", "svcScpPptDesc");
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
	 * @return svcScpPptCd
	 */
	public String getSvcScpPptCd() {
		return this.svcScpPptCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return svcScpPptDesc
	 */
	public String getSvcScpPptDesc() {
		return this.svcScpPptDesc;
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
	 * @param svcScpPptCd
	 */
	public void setSvcScpPptCd(String svcScpPptCd) {
		this.svcScpPptCd = svcScpPptCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param svcScpPptDesc
	 */
	public void setSvcScpPptDesc(String svcScpPptDesc) {
		this.svcScpPptDesc = svcScpPptDesc;
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
		setSvcScpPptCd(JSPUtil.getParameter(request, prefix + "svc_scp_ppt_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setSvcScpPptDesc(JSPUtil.getParameter(request, prefix + "svc_scp_ppt_desc", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltServiceScopePropertyMappingVO[]
	 */
	public RsltServiceScopePropertyMappingVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltServiceScopePropertyMappingVO[]
	 */
	public RsltServiceScopePropertyMappingVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltServiceScopePropertyMappingVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] svcScpPptCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_ppt_cd", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] svcScpPptDesc = (JSPUtil.getParameter(request, prefix	+ "svc_scp_ppt_desc", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltServiceScopePropertyMappingVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (svcScpPptCd[i] != null)
					model.setSvcScpPptCd(svcScpPptCd[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (svcScpPptDesc[i] != null)
					model.setSvcScpPptDesc(svcScpPptDesc[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltServiceScopePropertyMappingVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltServiceScopePropertyMappingVO[]
	 */
	public RsltServiceScopePropertyMappingVO[] getRsltServiceScopePropertyMappingVOs(){
		RsltServiceScopePropertyMappingVO[] vos = (RsltServiceScopePropertyMappingVO[])models.toArray(new RsltServiceScopePropertyMappingVO[models.size()]);
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
		this.svcScpPptCd = this.svcScpPptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpPptDesc = this.svcScpPptDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
