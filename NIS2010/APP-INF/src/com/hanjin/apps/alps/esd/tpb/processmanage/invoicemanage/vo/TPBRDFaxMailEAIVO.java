/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBRDFaxMailEAIVO.java
*@FileTitle : TPBRDFaxMailEAIVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.26
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2009.11.26 박성진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.processmanage.invoicemanage.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TPBRDFaxMailEAIVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TPBRDFaxMailEAIVO> models = new ArrayList<TPBRDFaxMailEAIVO>();
	
	/* Column Info */
	private String subSysCd = null;
	/* Column Info */
	private String senderUsrEml = null;
	/* Column Info */
	private String tmplMrd = null;
	/* Column Info */
	private String receiverFax = null;
	/* Column Info */
	private String senderUsrNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String content = null;
	/* Column Info */
	private String senderUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String title = null;
	/* Column Info */
	private String senderUsrCnt = null;
	/* Column Info */
	private String tmplParam = null;
	/* Column Info */
	private String receiverEml = null;
	/* Column Info */
	private String senderUsrOfc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TPBRDFaxMailEAIVO() {}

	public TPBRDFaxMailEAIVO(String ibflag, String pagerows, String subSysCd, String senderUsrEml, String tmplMrd, String receiverFax, String senderUsrNm, String content, String senderUsrId, String title, String senderUsrCnt, String tmplParam, String receiverEml, String senderUsrOfc) {
		this.subSysCd = subSysCd;
		this.senderUsrEml = senderUsrEml;
		this.tmplMrd = tmplMrd;
		this.receiverFax = receiverFax;
		this.senderUsrNm = senderUsrNm;
		this.pagerows = pagerows;
		this.content = content;
		this.senderUsrId = senderUsrId;
		this.ibflag = ibflag;
		this.title = title;
		this.senderUsrCnt = senderUsrCnt;
		this.tmplParam = tmplParam;
		this.receiverEml = receiverEml;
		this.senderUsrOfc = senderUsrOfc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("sub_sys_cd", getSubSysCd());
		this.hashColumns.put("sender_usr_eml", getSenderUsrEml());
		this.hashColumns.put("tmpl_mrd", getTmplMrd());
		this.hashColumns.put("receiver_fax", getReceiverFax());
		this.hashColumns.put("sender_usr_nm", getSenderUsrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("content", getContent());
		this.hashColumns.put("sender_usr_id", getSenderUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("sender_usr_cnt", getSenderUsrCnt());
		this.hashColumns.put("tmpl_param", getTmplParam());
		this.hashColumns.put("receiver_eml", getReceiverEml());
		this.hashColumns.put("sender_usr_ofc", getSenderUsrOfc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("sub_sys_cd", "subSysCd");
		this.hashFields.put("sender_usr_eml", "senderUsrEml");
		this.hashFields.put("tmpl_mrd", "tmplMrd");
		this.hashFields.put("receiver_fax", "receiverFax");
		this.hashFields.put("sender_usr_nm", "senderUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("content", "content");
		this.hashFields.put("sender_usr_id", "senderUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("title", "title");
		this.hashFields.put("sender_usr_cnt", "senderUsrCnt");
		this.hashFields.put("tmpl_param", "tmplParam");
		this.hashFields.put("receiver_eml", "receiverEml");
		this.hashFields.put("sender_usr_ofc", "senderUsrOfc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return subSysCd
	 */
	public String getSubSysCd() {
		return this.subSysCd;
	}
	
	/**
	 * Column Info
	 * @return senderUsrEml
	 */
	public String getSenderUsrEml() {
		return this.senderUsrEml;
	}
	
	/**
	 * Column Info
	 * @return tmplMrd
	 */
	public String getTmplMrd() {
		return this.tmplMrd;
	}
	
	/**
	 * Column Info
	 * @return receiverFax
	 */
	public String getReceiverFax() {
		return this.receiverFax;
	}
	
	/**
	 * Column Info
	 * @return senderUsrNm
	 */
	public String getSenderUsrNm() {
		return this.senderUsrNm;
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
	 * @return content
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * Column Info
	 * @return senderUsrId
	 */
	public String getSenderUsrId() {
		return this.senderUsrId;
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
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * Column Info
	 * @return senderUsrCnt
	 */
	public String getSenderUsrCnt() {
		return this.senderUsrCnt;
	}
	
	/**
	 * Column Info
	 * @return tmplParam
	 */
	public String getTmplParam() {
		return this.tmplParam;
	}
	
	/**
	 * Column Info
	 * @return receiverEml
	 */
	public String getReceiverEml() {
		return this.receiverEml;
	}
	
	/**
	 * Column Info
	 * @return senderUsrOfc
	 */
	public String getSenderUsrOfc() {
		return this.senderUsrOfc;
	}
	

	/**
	 * Column Info
	 * @param subSysCd
	 */
	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd;
	}
	
	/**
	 * Column Info
	 * @param senderUsrEml
	 */
	public void setSenderUsrEml(String senderUsrEml) {
		this.senderUsrEml = senderUsrEml;
	}
	
	/**
	 * Column Info
	 * @param tmplMrd
	 */
	public void setTmplMrd(String tmplMrd) {
		this.tmplMrd = tmplMrd;
	}
	
	/**
	 * Column Info
	 * @param receiverFax
	 */
	public void setReceiverFax(String receiverFax) {
		this.receiverFax = receiverFax;
	}
	
	/**
	 * Column Info
	 * @param senderUsrNm
	 */
	public void setSenderUsrNm(String senderUsrNm) {
		this.senderUsrNm = senderUsrNm;
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
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Column Info
	 * @param senderUsrId
	 */
	public void setSenderUsrId(String senderUsrId) {
		this.senderUsrId = senderUsrId;
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
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Column Info
	 * @param senderUsrCnt
	 */
	public void setSenderUsrCnt(String senderUsrCnt) {
		this.senderUsrCnt = senderUsrCnt;
	}
	
	/**
	 * Column Info
	 * @param tmplParam
	 */
	public void setTmplParam(String tmplParam) {
		this.tmplParam = tmplParam;
	}
	
	/**
	 * Column Info
	 * @param receiverEml
	 */
	public void setReceiverEml(String receiverEml) {
		this.receiverEml = receiverEml;
	}
	
	/**
	 * Column Info
	 * @param senderUsrOfc
	 */
	public void setSenderUsrOfc(String senderUsrOfc) {
		this.senderUsrOfc = senderUsrOfc;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setSubSysCd(JSPUtil.getParameter(request, "sub_sys_cd", ""));
		setSenderUsrEml(JSPUtil.getParameter(request, "sender_usr_eml", ""));
		setTmplMrd(JSPUtil.getParameter(request, "tmpl_mrd", ""));
		setReceiverFax(JSPUtil.getParameter(request, "receiver_fax", ""));
		setSenderUsrNm(JSPUtil.getParameter(request, "sender_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setContent(JSPUtil.getParameter(request, "content", ""));
		setSenderUsrId(JSPUtil.getParameter(request, "sender_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setTitle(JSPUtil.getParameter(request, "title", ""));
		setSenderUsrCnt(JSPUtil.getParameter(request, "sender_usr_cnt", ""));
		setTmplParam(JSPUtil.getParameter(request, "tmpl_param", ""));
		setReceiverEml(JSPUtil.getParameter(request, "receiver_eml", ""));
		setSenderUsrOfc(JSPUtil.getParameter(request, "sender_usr_ofc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TPBRDFaxMailEAIVO[]
	 */
	public TPBRDFaxMailEAIVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TPBRDFaxMailEAIVO[]
	 */
	public TPBRDFaxMailEAIVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TPBRDFaxMailEAIVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] subSysCd = (JSPUtil.getParameter(request, prefix	+ "sub_sys_cd", length));
			String[] senderUsrEml = (JSPUtil.getParameter(request, prefix	+ "sender_usr_eml", length));
			String[] tmplMrd = (JSPUtil.getParameter(request, prefix	+ "tmpl_mrd", length));
			String[] receiverFax = (JSPUtil.getParameter(request, prefix	+ "receiver_fax", length));
			String[] senderUsrNm = (JSPUtil.getParameter(request, prefix	+ "sender_usr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] content = (JSPUtil.getParameter(request, prefix	+ "content", length));
			String[] senderUsrId = (JSPUtil.getParameter(request, prefix	+ "sender_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] title = (JSPUtil.getParameter(request, prefix	+ "title", length));
			String[] senderUsrCnt = (JSPUtil.getParameter(request, prefix	+ "sender_usr_cnt", length));
			String[] tmplParam = (JSPUtil.getParameter(request, prefix	+ "tmpl_param", length));
			String[] receiverEml = (JSPUtil.getParameter(request, prefix	+ "receiver_eml", length));
			String[] senderUsrOfc = (JSPUtil.getParameter(request, prefix	+ "sender_usr_ofc", length));
			
			for (int i = 0; i < length; i++) {
				model = new TPBRDFaxMailEAIVO();
				if (subSysCd[i] != null)
					model.setSubSysCd(subSysCd[i]);
				if (senderUsrEml[i] != null)
					model.setSenderUsrEml(senderUsrEml[i]);
				if (tmplMrd[i] != null)
					model.setTmplMrd(tmplMrd[i]);
				if (receiverFax[i] != null)
					model.setReceiverFax(receiverFax[i]);
				if (senderUsrNm[i] != null)
					model.setSenderUsrNm(senderUsrNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (content[i] != null)
					model.setContent(content[i]);
				if (senderUsrId[i] != null)
					model.setSenderUsrId(senderUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (senderUsrCnt[i] != null)
					model.setSenderUsrCnt(senderUsrCnt[i]);
				if (tmplParam[i] != null)
					model.setTmplParam(tmplParam[i]);
				if (receiverEml[i] != null)
					model.setReceiverEml(receiverEml[i]);
				if (senderUsrOfc[i] != null)
					model.setSenderUsrOfc(senderUsrOfc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTPBRDFaxMailEAIVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TPBRDFaxMailEAIVO[]
	 */
	public TPBRDFaxMailEAIVO[] getTPBRDFaxMailEAIVOs(){
		TPBRDFaxMailEAIVO[] vos = (TPBRDFaxMailEAIVO[])models.toArray(new TPBRDFaxMailEAIVO[models.size()]);
		return vos;
	}
	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.subSysCd = this.subSysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrEml = this.senderUsrEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplMrd = this.tmplMrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverFax = this.receiverFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrNm = this.senderUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.content = this.content .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrId = this.senderUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrCnt = this.senderUsrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplParam = this.tmplParam .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverEml = this.receiverEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrOfc = this.senderUsrOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
