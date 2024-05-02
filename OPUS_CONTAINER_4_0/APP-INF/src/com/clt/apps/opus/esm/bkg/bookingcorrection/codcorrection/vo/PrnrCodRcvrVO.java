/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : PrnrCodRcvrVO.java
*@FileTitle : PrnrCodRcvrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.03.22 류대영 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PrnrCodRcvrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PrnrCodRcvrVO> models = new ArrayList<PrnrCodRcvrVO>();
	
	/* Column Info */
	private String fromEml = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String globalName = null;
	/* Column Info */
	private String ccEml = null;
	/* Column Info */
	private String toEml = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public PrnrCodRcvrVO() {}

	public PrnrCodRcvrVO(String ibflag, String pagerows, String toEml, String ccEml, String fromEml, String globalName) {
		this.fromEml = fromEml;
		this.ibflag = ibflag;
		this.globalName = globalName;
		this.ccEml = ccEml;
		this.toEml = toEml;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_eml", getFromEml());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("global_name", getGlobalName());
		this.hashColumns.put("cc_eml", getCcEml());
		this.hashColumns.put("to_eml", getToEml());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_eml", "fromEml");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("global_name", "globalName");
		this.hashFields.put("cc_eml", "ccEml");
		this.hashFields.put("to_eml", "toEml");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromEml
	 */
	public String getFromEml() {
		return this.fromEml;
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
	 * @return globalName
	 */
	public String getGlobalName() {
		return this.globalName;
	}
	
	/**
	 * Column Info
	 * @return ccEml
	 */
	public String getCcEml() {
		return this.ccEml;
	}
	
	/**
	 * Column Info
	 * @return toEml
	 */
	public String getToEml() {
		return this.toEml;
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
	 * @param fromEml
	 */
	public void setFromEml(String fromEml) {
		this.fromEml = fromEml;
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
	 * @param globalName
	 */
	public void setGlobalName(String globalName) {
		this.globalName = globalName;
	}
	
	/**
	 * Column Info
	 * @param ccEml
	 */
	public void setCcEml(String ccEml) {
		this.ccEml = ccEml;
	}
	
	/**
	 * Column Info
	 * @param toEml
	 */
	public void setToEml(String toEml) {
		this.toEml = toEml;
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
		setFromEml(JSPUtil.getParameter(request, prefix + "from_eml", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGlobalName(JSPUtil.getParameter(request, prefix + "global_name", ""));
		setCcEml(JSPUtil.getParameter(request, prefix + "cc_eml", ""));
		setToEml(JSPUtil.getParameter(request, prefix + "to_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrnrCodRcvrVO[]
	 */
	public PrnrCodRcvrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PrnrCodRcvrVO[]
	 */
	public PrnrCodRcvrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PrnrCodRcvrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromEml = (JSPUtil.getParameter(request, prefix	+ "from_eml", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] globalName = (JSPUtil.getParameter(request, prefix	+ "global_name", length));
			String[] ccEml = (JSPUtil.getParameter(request, prefix	+ "cc_eml", length));
			String[] toEml = (JSPUtil.getParameter(request, prefix	+ "to_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new PrnrCodRcvrVO();
				if (fromEml[i] != null)
					model.setFromEml(fromEml[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (globalName[i] != null)
					model.setGlobalName(globalName[i]);
				if (ccEml[i] != null)
					model.setCcEml(ccEml[i]);
				if (toEml[i] != null)
					model.setToEml(toEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPrnrCodRcvrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PrnrCodRcvrVO[]
	 */
	public PrnrCodRcvrVO[] getPrnrCodRcvrVOs(){
		PrnrCodRcvrVO[] vos = (PrnrCodRcvrVO[])models.toArray(new PrnrCodRcvrVO[models.size()]);
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
		this.fromEml = this.fromEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.globalName = this.globalName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccEml = this.ccEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toEml = this.toEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
