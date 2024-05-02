/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RateCheckNoticeVO.java
*@FileTitle : RateCheckNoticeVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.09  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

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

public class RateCheckNoticeVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RateCheckNoticeVO> models = new ArrayList<RateCheckNoticeVO>();
	
	/* Column Info */
	private String body = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String title = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String oftMssFlg = null;
	/* Column Info */
	private String srepEml = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RateCheckNoticeVO() {}

	public RateCheckNoticeVO(String ibflag, String pagerows, String oftMssFlg, String srepEml, String title, String body, String bkgNo) {
		this.body = body;
		this.bkgNo = bkgNo;
		this.title = title;
		this.ibflag = ibflag;
		this.oftMssFlg = oftMssFlg;
		this.srepEml = srepEml;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("body", getBody());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("oft_mss_flg", getOftMssFlg());
		this.hashColumns.put("srep_eml", getSrepEml());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("body", "body");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("title", "title");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("oft_mss_flg", "oftMssFlg");
		this.hashFields.put("srep_eml", "srepEml");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return body
	 */
	public String getBody() {
		return this.body;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return oftMssFlg
	 */
	public String getOftMssFlg() {
		return this.oftMssFlg;
	}
	
	/**
	 * Column Info
	 * @return srepEml
	 */
	public String getSrepEml() {
		return this.srepEml;
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
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param oftMssFlg
	 */
	public void setOftMssFlg(String oftMssFlg) {
		this.oftMssFlg = oftMssFlg;
	}
	
	/**
	 * Column Info
	 * @param srepEml
	 */
	public void setSrepEml(String srepEml) {
		this.srepEml = srepEml;
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
		setBody(JSPUtil.getParameter(request, prefix + "body", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setOftMssFlg(JSPUtil.getParameter(request, prefix + "oft_mss_flg", ""));
		setSrepEml(JSPUtil.getParameter(request, prefix + "srep_eml", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RateCheckNoticeVO[]
	 */
	public RateCheckNoticeVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RateCheckNoticeVO[]
	 */
	public RateCheckNoticeVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RateCheckNoticeVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] body = (JSPUtil.getParameter(request, prefix	+ "body", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] oftMssFlg = (JSPUtil.getParameter(request, prefix	+ "oft_mss_flg", length));
			String[] srepEml = (JSPUtil.getParameter(request, prefix	+ "srep_eml", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new RateCheckNoticeVO();
				if (body[i] != null)
					model.setBody(body[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (oftMssFlg[i] != null)
					model.setOftMssFlg(oftMssFlg[i]);
				if (srepEml[i] != null)
					model.setSrepEml(srepEml[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRateCheckNoticeVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RateCheckNoticeVO[]
	 */
	public RateCheckNoticeVO[] getRateCheckNoticeVOs(){
		RateCheckNoticeVO[] vos = (RateCheckNoticeVO[])models.toArray(new RateCheckNoticeVO[models.size()]);
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
		this.body = this.body .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oftMssFlg = this.oftMssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepEml = this.srepEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
