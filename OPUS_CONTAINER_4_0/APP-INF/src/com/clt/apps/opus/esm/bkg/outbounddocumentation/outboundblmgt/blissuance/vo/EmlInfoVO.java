/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : EmlInfoVO.java
*@FileTitle : EmlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2014.11.24 Maeda Atsushi 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author Maeda Atsushi
 * @since J2EE 1.6
 * @see AbstractValueObject 
 */

public class EmlInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EmlInfoVO> models = new ArrayList<EmlInfoVO>();
	
	/* Column Info */
	private String content = null;
	/* Column Info */
	private String ntcViaCd = null;
	/* Column Info */
	private String title = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rcveml = null;
	/* Column Info */
	private String ntcKndCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public EmlInfoVO() {}

	public EmlInfoVO(String ibflag, String pagerows, String content, String title, String rcveml, String ntcViaCd, String ntcKndCd) {
		this.content = content;
		this.ntcViaCd = ntcViaCd;
		this.title = title;
		this.ibflag = ibflag;
		this.rcveml = rcveml;
		this.ntcKndCd = ntcKndCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("content", getContent());
		this.hashColumns.put("ntc_via_cd", getNtcViaCd());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rcveml", getRcveml());
		this.hashColumns.put("ntc_knd_cd", getNtcKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("content", "content");
		this.hashFields.put("ntc_via_cd", "ntcViaCd");
		this.hashFields.put("title", "title");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rcveml", "rcveml");
		this.hashFields.put("ntc_knd_cd", "ntcKndCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return content
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * Column Info
	 * @return ntcViaCd
	 */
	public String getNtcViaCd() {
		return this.ntcViaCd;
	}
	
	/**
	 * Column Info
	 * @return title
	 */
	public String getTitle() {
		return this.title;
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
	 * @return rcveml
	 */
	public String getRcveml() {
		return this.rcveml;
	}
	
	/**
	 * Column Info
	 * @return ntcKndCd
	 */
	public String getNtcKndCd() {
		return this.ntcKndCd;
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
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Column Info
	 * @param ntcViaCd
	 */
	public void setNtcViaCd(String ntcViaCd) {
		this.ntcViaCd = ntcViaCd;
	}
	
	/**
	 * Column Info
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
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
	 * @param rcveml
	 */
	public void setRcveml(String rcveml) {
		this.rcveml = rcveml;
	}
	
	/**
	 * Column Info
	 * @param ntcKndCd
	 */
	public void setNtcKndCd(String ntcKndCd) {
		this.ntcKndCd = ntcKndCd;
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
		setContent(JSPUtil.getParameter(request, prefix + "content", ""));
		setNtcViaCd(JSPUtil.getParameter(request, prefix + "ntc_via_cd", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRcveml(JSPUtil.getParameter(request, prefix + "rcveml", ""));
		setNtcKndCd(JSPUtil.getParameter(request, prefix + "ntc_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EmlInfoVO[]
	 */
	public EmlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EmlInfoVO[]
	 */
	public EmlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EmlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] content = (JSPUtil.getParameter(request, prefix	+ "content", length));
			String[] ntcViaCd = (JSPUtil.getParameter(request, prefix	+ "ntc_via_cd", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rcveml = (JSPUtil.getParameter(request, prefix	+ "rcveml", length));
			String[] ntcKndCd = (JSPUtil.getParameter(request, prefix	+ "ntc_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new EmlInfoVO();
				if (content[i] != null)
					model.setContent(content[i]);
				if (ntcViaCd[i] != null)
					model.setNtcViaCd(ntcViaCd[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rcveml[i] != null)
					model.setRcveml(rcveml[i]);
				if (ntcKndCd[i] != null)
					model.setNtcKndCd(ntcKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEmlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EmlInfoVO[]
	 */
	public EmlInfoVO[] getEmlInfoVOs(){
		EmlInfoVO[] vos = (EmlInfoVO[])models.toArray(new EmlInfoVO[models.size()]);
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
		this.content = this.content .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcViaCd = this.ntcViaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcveml = this.rcveml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcKndCd = this.ntcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
