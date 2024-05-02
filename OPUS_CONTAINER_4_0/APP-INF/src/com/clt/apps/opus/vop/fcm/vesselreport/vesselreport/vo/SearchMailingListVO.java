/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SearchMailingListVO.java
*@FileTitle : SearchMailingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.13
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.13  
* 1.0 Creation
* 
* 2014.05.19 박다은 [CHM-201429883] [FCM] Departure Report Tap내 mail Function 신설
=========================================================*/

package com.clt.apps.opus.vop.fcm.vesselreport.vesselreport.vo;

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

public class SearchMailingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchMailingListVO> models = new ArrayList<SearchMailingListVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ccPsn = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String subject = null;
	/* Column Info */
	private String toPsn = null;
	/* Column Info */
	private String fromPsn = null;
	/* Column Info */
	private String vslCdArr = null;
	/* Column Info */
	private String bodyConts = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SearchMailingListVO() {}

	public SearchMailingListVO(String ibflag, String pagerows, String subject, String bodyConts, String fromPsn, String toPsn, String ccPsn, String usrId, String vslCdArr) {
		this.ibflag = ibflag;
		this.ccPsn = ccPsn;
		this.usrId = usrId;
		this.subject = subject;
		this.toPsn = toPsn;
		this.fromPsn = fromPsn;
		this.vslCdArr = vslCdArr;
		this.bodyConts = bodyConts;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cc_psn", getCcPsn());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("subject", getSubject());
		this.hashColumns.put("to_psn", getToPsn());
		this.hashColumns.put("from_psn", getFromPsn());
		this.hashColumns.put("vsl_cd_arr", getVslCdArr());
		this.hashColumns.put("body_conts", getBodyConts());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cc_psn", "ccPsn");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("subject", "subject");
		this.hashFields.put("to_psn", "toPsn");
		this.hashFields.put("from_psn", "fromPsn");
		this.hashFields.put("vsl_cd_arr", "vslCdArr");
		this.hashFields.put("body_conts", "bodyConts");
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
	 * @return ccPsn
	 */
	public String getCcPsn() {
		return this.ccPsn;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return subject
	 */
	public String getSubject() {
		return this.subject;
	}
	
	/**
	 * Column Info
	 * @return toPsn
	 */
	public String getToPsn() {
		return this.toPsn;
	}
	
	/**
	 * Column Info
	 * @return fromPsn
	 */
	public String getFromPsn() {
		return this.fromPsn;
	}
	
	/**
	 * Column Info
	 * @return vslCdArr
	 */
	public String getVslCdArr() {
		return this.vslCdArr;
	}
	
	/**
	 * Column Info
	 * @return bodyConts
	 */
	public String getBodyConts() {
		return this.bodyConts;
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
	 * @param ccPsn
	 */
	public void setCcPsn(String ccPsn) {
		this.ccPsn = ccPsn;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	/**
	 * Column Info
	 * @param toPsn
	 */
	public void setToPsn(String toPsn) {
		this.toPsn = toPsn;
	}
	
	/**
	 * Column Info
	 * @param fromPsn
	 */
	public void setFromPsn(String fromPsn) {
		this.fromPsn = fromPsn;
	}
	
	/**
	 * Column Info
	 * @param vslCdArr
	 */
	public void setVslCdArr(String vslCdArr) {
		this.vslCdArr = vslCdArr;
	}
	
	/**
	 * Column Info
	 * @param bodyConts
	 */
	public void setBodyConts(String bodyConts) {
		this.bodyConts = bodyConts;
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
		setCcPsn(JSPUtil.getParameter(request, prefix + "cc_psn", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setSubject(JSPUtil.getParameter(request, prefix + "subject", ""));
		setToPsn(JSPUtil.getParameter(request, prefix + "to_psn", ""));
		setFromPsn(JSPUtil.getParameter(request, prefix + "from_psn", ""));
		setVslCdArr(JSPUtil.getParameter(request, prefix + "vsl_cd_arr", ""));
		setBodyConts(JSPUtil.getParameter(request, prefix + "body_conts", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchMailingListVO[]
	 */
	public SearchMailingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchMailingListVO[]
	 */
	public SearchMailingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchMailingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ccPsn = (JSPUtil.getParameter(request, prefix	+ "cc_psn", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] subject = (JSPUtil.getParameter(request, prefix	+ "subject", length));
			String[] toPsn = (JSPUtil.getParameter(request, prefix	+ "to_psn", length));
			String[] fromPsn = (JSPUtil.getParameter(request, prefix	+ "from_psn", length));
			String[] vslCdArr = (JSPUtil.getParameter(request, prefix	+ "vsl_cd_arr", length));
			String[] bodyConts = (JSPUtil.getParameter(request, prefix	+ "body_conts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchMailingListVO();
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ccPsn[i] != null)
					model.setCcPsn(ccPsn[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (subject[i] != null)
					model.setSubject(subject[i]);
				if (toPsn[i] != null)
					model.setToPsn(toPsn[i]);
				if (fromPsn[i] != null)
					model.setFromPsn(fromPsn[i]);
				if (vslCdArr[i] != null)
					model.setVslCdArr(vslCdArr[i]);
				if (bodyConts[i] != null)
					model.setBodyConts(bodyConts[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchMailingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchMailingListVO[]
	 */
	public SearchMailingListVO[] getSearchMailingListVOs(){
		SearchMailingListVO[] vos = (SearchMailingListVO[])models.toArray(new SearchMailingListVO[models.size()]);
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
		this.ccPsn = this.ccPsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subject = this.subject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPsn = this.toPsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromPsn = this.fromPsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCdArr = this.vslCdArr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bodyConts = this.bodyConts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
