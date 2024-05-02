/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : RDFaxMailEAIVO.java
 *@FileTitle : RDFaxMailEAIVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.04.23
 *@LastModifier : 김상수
 *@LastVersion : 1.0
 * 2010.04.23 김상수 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RDFaxMailEAIVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<RDFaxMailEAIVO> models = new ArrayList<RDFaxMailEAIVO>();

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
	private String senderUsrDefaultEml = null;
	/* Column Info */
	private String content = null;
	/* Column Info */
	private String senderUsrId = null;
	/* Column Info */
	private String title = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rdContent = null;
	/* Column Info */
	private String senderUsrCnt = null;
	/* Column Info */
	private String tmplParam = null;
	/* Column Info */
	private String receiverEml = null;
	/* Column Info */
	private String senderUsrOfc = null;
	/* Column Info */
	private String receiverNm = null;
	/* Column Info */
	private String xfileNm = null;

	/* 테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/* 테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public RDFaxMailEAIVO() {
	}

	public RDFaxMailEAIVO(String ibflag, String pagerows, String content, String rdContent, String receiverEml, String receiverFax, String senderUsrCnt, String senderUsrEml,
			String senderUsrDefaultEml, String senderUsrId, String senderUsrNm, String senderUsrOfc, String subSysCd, String title, String tmplMrd, String tmplParam, String receiverNm, String xfileNm) {
		this.subSysCd = subSysCd;
		this.senderUsrEml = senderUsrEml;
		this.tmplMrd = tmplMrd;
		this.receiverFax = receiverFax;
		this.senderUsrNm = senderUsrNm;
		this.pagerows = pagerows;
		this.senderUsrDefaultEml = senderUsrDefaultEml;
		this.content = content;
		this.senderUsrId = senderUsrId;
		this.title = title;
		this.ibflag = ibflag;
		this.rdContent = rdContent;
		this.senderUsrCnt = senderUsrCnt;
		this.tmplParam = tmplParam;
		this.receiverEml = receiverEml;
		this.senderUsrOfc = senderUsrOfc;
		this.receiverNm = receiverNm;
		this.xfileNm = xfileNm;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * 
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues() {
		this.hashColumns.put("sub_sys_cd", getSubSysCd());
		this.hashColumns.put("sender_usr_eml", getSenderUsrEml());
		this.hashColumns.put("tmpl_mrd", getTmplMrd());
		this.hashColumns.put("receiver_fax", getReceiverFax());
		this.hashColumns.put("sender_usr_nm", getSenderUsrNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sender_usr_default_eml", getSenderUsrDefaultEml());
		this.hashColumns.put("content", getContent());
		this.hashColumns.put("sender_usr_id", getSenderUsrId());
		this.hashColumns.put("title", getTitle());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rd_content", getRdContent());
		this.hashColumns.put("sender_usr_cnt", getSenderUsrCnt());
		this.hashColumns.put("tmpl_param", getTmplParam());
		this.hashColumns.put("receiver_eml", getReceiverEml());
		this.hashColumns.put("sender_usr_ofc", getSenderUsrOfc());
		this.hashColumns.put("receiver_nm", getReceiverNm());
		this.hashColumns.put("xfile_nm", getXfileNm());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * 
	 * @return
	 */
	public HashMap<String, String> getFieldNames() {
		this.hashFields.put("sub_sys_cd", "subSysCd");
		this.hashFields.put("sender_usr_eml", "senderUsrEml");
		this.hashFields.put("tmpl_mrd", "tmplMrd");
		this.hashFields.put("receiver_fax", "receiverFax");
		this.hashFields.put("sender_usr_nm", "senderUsrNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sender_usr_default_eml", "senderUsrDefaultEml");
		this.hashFields.put("content", "content");
		this.hashFields.put("sender_usr_id", "senderUsrId");
		this.hashFields.put("title", "title");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rd_content", "rdContent");
		this.hashFields.put("sender_usr_cnt", "senderUsrCnt");
		this.hashFields.put("tmpl_param", "tmplParam");
		this.hashFields.put("receiver_eml", "receiverEml");
		this.hashFields.put("sender_usr_ofc", "senderUsrOfc");
		this.hashFields.put("receiver_nm", "receiverNm");
		this.hashFields.put("xfile_nm", "xfileNm");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * 
	 * @return subSysCd
	 */
	public String getSubSysCd() {
		return this.subSysCd;
	}

	/**
	 * Column Info
	 * 
	 * @return senderUsrEml
	 */
	public String getSenderUsrEml() {
		return this.senderUsrEml;
	}

	/**
	 * Column Info
	 * 
	 * @return tmplMrd
	 */
	public String getTmplMrd() {
		return this.tmplMrd;
	}

	/**
	 * Column Info
	 * 
	 * @return receiverFax
	 */
	public String getReceiverFax() {
		return this.receiverFax;
	}

	/**
	 * Column Info
	 * 
	 * @return senderUsrNm
	 */
	public String getSenderUsrNm() {
		return this.senderUsrNm;
	}

	/**
	 * Page Number
	 * 
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @return senderUsrDefaultEml
	 */
	public String getSenderUsrDefaultEml() {
		return this.senderUsrDefaultEml;
	}

	/**
	 * Column Info
	 * 
	 * @return content
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * Column Info
	 * 
	 * @return senderUsrId
	 */
	public String getSenderUsrId() {
		return this.senderUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @return title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @return rdContent
	 */
	public String getRdContent() {
		return this.rdContent;
	}

	/**
	 * Column Info
	 * 
	 * @return senderUsrCnt
	 */
	public String getSenderUsrCnt() {
		return this.senderUsrCnt;
	}

	/**
	 * Column Info
	 * 
	 * @return tmplParam
	 */
	public String getTmplParam() {
		return this.tmplParam;
	}

	/**
	 * Column Info
	 * 
	 * @return receiverEml
	 */
	public String getReceiverEml() {
		return this.receiverEml;
	}

	/**
	 * Column Info
	 * 
	 * @return senderUsrOfc
	 */
	public String getSenderUsrOfc() {
		return this.senderUsrOfc;
	}

	/**
	 * Column Info
	 * 
	 * @param subSysCd
	 */
	public void setSubSysCd(String subSysCd) {
		this.subSysCd = subSysCd;
	}

	/**
	 * Column Info
	 * 
	 * @param senderUsrEml
	 */
	public void setSenderUsrEml(String senderUsrEml) {
		this.senderUsrEml = senderUsrEml;
	}

	/**
	 * Column Info
	 * 
	 * @param tmplMrd
	 */
	public void setTmplMrd(String tmplMrd) {
		this.tmplMrd = tmplMrd;
	}

	/**
	 * Column Info
	 * 
	 * @param receiverFax
	 */
	public void setReceiverFax(String receiverFax) {
		this.receiverFax = receiverFax;
	}

	/**
	 * Column Info
	 * 
	 * @param senderUsrNm
	 */
	public void setSenderUsrNm(String senderUsrNm) {
		this.senderUsrNm = senderUsrNm;
	}

	/**
	 * Page Number
	 * 
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}

	/**
	 * Column Info
	 * 
	 * @param senderUsrDefaultEml
	 */
	public void setSenderUsrDefaultEml(String senderUsrDefaultEml) {
		this.senderUsrDefaultEml = senderUsrDefaultEml;
	}

	/**
	 * Column Info
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * Column Info
	 * 
	 * @param senderUsrId
	 */
	public void setSenderUsrId(String senderUsrId) {
		this.senderUsrId = senderUsrId;
	}

	/**
	 * Column Info
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * 
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}

	/**
	 * Column Info
	 * 
	 * @param rdContent
	 */
	public void setRdContent(String rdContent) {
		this.rdContent = rdContent;
	}

	/**
	 * Column Info
	 * 
	 * @param senderUsrCnt
	 */
	public void setSenderUsrCnt(String senderUsrCnt) {
		this.senderUsrCnt = senderUsrCnt;
	}

	/**
	 * Column Info
	 * 
	 * @param tmplParam
	 */
	public void setTmplParam(String tmplParam) {
		this.tmplParam = tmplParam;
	}

	/**
	 * Column Info
	 * 
	 * @param receiverEml
	 */
	public void setReceiverEml(String receiverEml) {
		this.receiverEml = receiverEml;
	}

	/**
	 * Column Info
	 * 
	 * @param senderUsrOfc
	 */
	public void setSenderUsrOfc(String senderUsrOfc) {
		this.senderUsrOfc = senderUsrOfc;
	}

	public String getReceiverNm() {
		return receiverNm;
	}

	public void setReceiverNm(String receiverNm) {
		this.receiverNm = receiverNm;
	}

	public String getXfileNm() {
		return xfileNm;
	}

	public void setXfileNm(String xfileNm) {
		this.xfileNm = xfileNm;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request, "");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * 
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setSubSysCd(JSPUtil.getParameter(request, prefix + "sub_sys_cd", ""));
		setSenderUsrEml(JSPUtil.getParameter(request, prefix + "sender_usr_eml", ""));
		setTmplMrd(JSPUtil.getParameter(request, prefix + "tmpl_mrd", ""));
		setReceiverFax(JSPUtil.getParameter(request, prefix + "receiver_fax", ""));
		setSenderUsrNm(JSPUtil.getParameter(request, prefix + "sender_usr_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSenderUsrDefaultEml(JSPUtil.getParameter(request, prefix + "sender_usr_default_eml", ""));
		setContent(JSPUtil.getParameter(request, prefix + "content", ""));
		setSenderUsrId(JSPUtil.getParameter(request, prefix + "sender_usr_id", ""));
		setTitle(JSPUtil.getParameter(request, prefix + "title", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRdContent(JSPUtil.getParameter(request, prefix + "rd_content", ""));
		setSenderUsrCnt(JSPUtil.getParameter(request, prefix + "sender_usr_cnt", ""));
		setTmplParam(JSPUtil.getParameter(request, prefix + "tmpl_param", ""));
		setReceiverEml(JSPUtil.getParameter(request, prefix + "receiver_eml", ""));
		setSenderUsrOfc(JSPUtil.getParameter(request, prefix + "sender_usr_ofc", ""));
		setReceiverNm(JSPUtil.getParameter(request, prefix + "receiver_nm", ""));
		setXfileNm(JSPUtil.getParameter(request, prefix + "xfile_nm", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * 
	 * @param request
	 * @return RDFaxMailEAIVO[]
	 */
	public RDFaxMailEAIVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * 
	 * @param request
	 * @param prefix
	 * @return RDFaxMailEAIVO[]
	 */
	public RDFaxMailEAIVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RDFaxMailEAIVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp == null)
			return null;

		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] subSysCd = (JSPUtil.getParameter(request, prefix + "sub_sys_cd", length));
			String[] senderUsrEml = (JSPUtil.getParameter(request, prefix + "sender_usr_eml", length));
			String[] tmplMrd = (JSPUtil.getParameter(request, prefix + "tmpl_mrd", length));
			String[] receiverFax = (JSPUtil.getParameter(request, prefix + "receiver_fax", length));
			String[] senderUsrNm = (JSPUtil.getParameter(request, prefix + "sender_usr_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix + "pagerows", length));
			String[] senderUsrDefaultEml = (JSPUtil.getParameter(request, prefix + "sender_usr_default_eml", length));
			String[] content = (JSPUtil.getParameter(request, prefix + "content", length));
			String[] senderUsrId = (JSPUtil.getParameter(request, prefix + "sender_usr_id", length));
			String[] title = (JSPUtil.getParameter(request, prefix + "title", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix + "ibflag", length));
			String[] rdContent = (JSPUtil.getParameter(request, prefix + "rd_content", length));
			String[] senderUsrCnt = (JSPUtil.getParameter(request, prefix + "sender_usr_cnt", length));
			String[] tmplParam = (JSPUtil.getParameter(request, prefix + "tmpl_param", length));
			String[] receiverEml = (JSPUtil.getParameter(request, prefix + "receiver_eml", length));
			String[] senderUsrOfc = (JSPUtil.getParameter(request, prefix + "sender_usr_ofc", length));
			String[] receiverNm = (JSPUtil.getParameter(request, prefix + "receiver_nm", length));
			String[] xfileNm = (JSPUtil.getParameter(request, prefix + "xfile_nm", length));

			for (int i = 0; i < length; i++) {
				model = new RDFaxMailEAIVO();
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
				if (senderUsrDefaultEml[i] != null)
					model.setSenderUsrDefaultEml(senderUsrDefaultEml[i]);
				if (content[i] != null)
					model.setContent(content[i]);
				if (senderUsrId[i] != null)
					model.setSenderUsrId(senderUsrId[i]);
				if (title[i] != null)
					model.setTitle(title[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rdContent[i] != null)
					model.setRdContent(rdContent[i]);
				if (senderUsrCnt[i] != null)
					model.setSenderUsrCnt(senderUsrCnt[i]);
				if (tmplParam[i] != null)
					model.setTmplParam(tmplParam[i]);
				if (receiverEml[i] != null)
					model.setReceiverEml(receiverEml[i]);
				if (senderUsrOfc[i] != null)
					model.setSenderUsrOfc(senderUsrOfc[i]);
				if (receiverNm[i] != null)
					model.setReceiverNm(receiverNm[i]);
				if (xfileNm[i] != null)
					model.setXfileNm(xfileNm[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRDFaxMailEAIVOs();
	}

	/**
	 * VO 배열을 반환
	 * 
	 * @return RDFaxMailEAIVO[]
	 */
	public RDFaxMailEAIVO[] getRDFaxMailEAIVOs() {
		RDFaxMailEAIVO[] vos = (RDFaxMailEAIVO[]) models.toArray(new RDFaxMailEAIVO[models.size()]);
		return vos;
	}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}

	/**
	 * 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	 */
	public void unDataFormat() {
		this.subSysCd = this.subSysCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrEml = this.senderUsrEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplMrd = this.tmplMrd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverFax = this.receiverFax.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrNm = this.senderUsrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrDefaultEml = this.senderUsrDefaultEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.content = this.content.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrId = this.senderUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.title = this.title.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdContent = this.rdContent.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrCnt = this.senderUsrCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmplParam = this.tmplParam.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverEml = this.receiverEml.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUsrOfc = this.senderUsrOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.receiverNm = this.receiverNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xfileNm = this.xfileNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
