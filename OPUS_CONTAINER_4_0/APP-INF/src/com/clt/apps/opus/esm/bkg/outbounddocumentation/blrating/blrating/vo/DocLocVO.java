/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : DocLocVO.java
*@FileTitle : DocLocVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

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

public class DocLocVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocLocVO> models = new ArrayList<DocLocVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String docLocCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String chargeCode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DocLocVO() {}

	public DocLocVO(String ibflag, String pagerows, String chargeCode, String docLocCd) {
		this.pagerows = pagerows;
		this.docLocCd = docLocCd;
		this.ibflag = ibflag;
		this.chargeCode = chargeCode;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("doc_loc_cd", getDocLocCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("charge_code", getChargeCode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("doc_loc_cd", "docLocCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("charge_code", "chargeCode");
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
	 * @return docLocCd
	 */
	public String getDocLocCd() {
		return this.docLocCd;
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
	 * @return chargeCode
	 */
	public String getChargeCode() {
		return this.chargeCode;
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
	 * @param docLocCd
	 */
	public void setDocLocCd(String docLocCd) {
		this.docLocCd = docLocCd;
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
	 * @param chargeCode
	 */
	public void setChargeCode(String chargeCode) {
		this.chargeCode = chargeCode;
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
		setDocLocCd(JSPUtil.getParameter(request, prefix + "doc_loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setChargeCode(JSPUtil.getParameter(request, prefix + "charge_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocLocVO[]
	 */
	public DocLocVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocLocVO[]
	 */
	public DocLocVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocLocVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] docLocCd = (JSPUtil.getParameter(request, prefix	+ "doc_loc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] chargeCode = (JSPUtil.getParameter(request, prefix	+ "charge_code", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocLocVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (docLocCd[i] != null)
					model.setDocLocCd(docLocCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (chargeCode[i] != null)
					model.setChargeCode(chargeCode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocLocVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocLocVO[]
	 */
	public DocLocVO[] getDocLocVOs(){
		DocLocVO[] vos = (DocLocVO[])models.toArray(new DocLocVO[models.size()]);
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
		this.docLocCd = this.docLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chargeCode = this.chargeCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
