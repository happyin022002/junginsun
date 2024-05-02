/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgEmlEdtVO.java
*@FileTitle : BkgEmlEdtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.27
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.27  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgEmlEdtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgEmlEdtVO> models = new ArrayList<BkgEmlEdtVO>();
	
	/* Column Info */
	private String edtBkgNoList = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String edtFromEml = null;
	/* Column Info */
	private String edtContents = null;
	/* Column Info */
	private String edtSubject = null;
	/* Column Info */
	private String edtCcEml = null;
	/* Column Info */
	private String edtToEml = null;
	/* Column Info */
	private String edtNtcKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Page Number */
	private String comRecipient = null;
	/* Page Number */
	private String comSubject = null;
	/* Page Number */
	private String comContent = null;
	/* Page Number */
	private String codStsCd = null;
	/* Page Number */
	private String codRqstSeq = null;
	/* Page Number */
	private String oldPol = null;
	/* Page Number */
	private String oldPod = null;
	/* Page Number */
	private String newPod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgEmlEdtVO() {}

	public BkgEmlEdtVO(String ibflag, String pagerows, String edtBkgNoList, String edtNtcKndCd, String edtToEml, String edtCcEml, String edtFromEml, String edtSubject, String edtContents, String comFrom, String comRecipient, String comSubject, String comContent, String codStsCd, String codRqstSeq, String oldPol, String oldPod, String newPod) {
		this.edtBkgNoList = edtBkgNoList;
		this.ibflag = ibflag;
		this.edtFromEml = edtFromEml;
		this.edtContents = edtContents;
		this.edtSubject = edtSubject;
		this.edtCcEml = edtCcEml;
		this.edtToEml = edtToEml;
		this.edtNtcKndCd = edtNtcKndCd;
		this.pagerows = pagerows;
		this.comRecipient = comRecipient;
		this.comSubject = comSubject;
		this.comContent = comContent;
		this.codStsCd = codStsCd;
		this.codRqstSeq = codRqstSeq;
		this.oldPol = oldPol;
		this.oldPod = oldPod;
		this.newPod = newPod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("edt_bkg_no_list", getEdtBkgNoList());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("edt_from_eml", getEdtFromEml());
		this.hashColumns.put("edt_contents", getEdtContents());
		this.hashColumns.put("edt_subject", getEdtSubject());
		this.hashColumns.put("edt_cc_eml", getEdtCcEml());
		this.hashColumns.put("edt_to_eml", getEdtToEml());
		this.hashColumns.put("edt_ntc_knd_cd", getEdtNtcKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("com_recipient", getComRecipient());
		this.hashColumns.put("com_subject", getComSubject());
		this.hashColumns.put("com_content", getComContent());
		this.hashColumns.put("cod_sts_cd", getCodStsCd());
		this.hashColumns.put("cod_rqst_seq", getCodRqstSeq());
		this.hashColumns.put("old_pol", getOldPol());
		this.hashColumns.put("old_pod", getOldPod());
		this.hashColumns.put("new_pod", getNewPod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("edt_bkg_no_list", "edtBkgNoList");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("edt_from_eml", "edtFromEml");
		this.hashFields.put("edt_contents", "edtContents");
		this.hashFields.put("edt_subject", "edtSubject");
		this.hashFields.put("edt_cc_eml", "edtCcEml");
		this.hashFields.put("edt_to_eml", "edtToEml");
		this.hashFields.put("edt_ntc_knd_cd", "edtNtcKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("com_recipient", "comRecipient");
		this.hashFields.put("com_subject", "comSubject");
		this.hashFields.put("com_content", "comContent");
		this.hashFields.put("cod_sts_cd", "codStsCd");
		this.hashFields.put("cod_rqst_seq", "codRqstSeq");
		this.hashFields.put("old_pol", "oldPol");
		this.hashFields.put("old_pod", "oldPod");
		this.hashFields.put("new_pod", "newPod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return edtBkgNoList
	 */
	public String getEdtBkgNoList() {
		return this.edtBkgNoList;
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
	 * @return edtFromEml
	 */
	public String getEdtFromEml() {
		return this.edtFromEml;
	}
	
	/**
	 * Column Info
	 * @return edtContents
	 */
	public String getEdtContents() {
		return this.edtContents;
	}
	
	/**
	 * Column Info
	 * @return edtSubject
	 */
	public String getEdtSubject() {
		return this.edtSubject;
	}
	
	/**
	 * Column Info
	 * @return edtCcEml
	 */
	public String getEdtCcEml() {
		return this.edtCcEml;
	}
	
	/**
	 * Column Info
	 * @return edtToEml
	 */
	public String getEdtToEml() {
		return this.edtToEml;
	}
	
	/**
	 * Column Info
	 * @return edtNtcKndCd
	 */
	public String getEdtNtcKndCd() {
		return this.edtNtcKndCd;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}

	/**
	 * Page Number
	 * @return comRecipient
	 */
	public String getComRecipient() {
		return this.comRecipient;
	}
	
	/**
	 * Page Number
	 * @return comSubject
	 */
	public String getComSubject() {
		return this.comSubject;
	}
	
	/**
	 * Page Number
	 * @return comContent
	 */
	public String getComContent() {
		return this.comContent;
	}
	
	/**
	 * Page Number
	 * @return codStsCd
	 */
	public String getCodStsCd() {
		return this.codStsCd;
	}
	
	/**
	 * Page Number
	 * @return codRqstSeq
	 */
	public String getCodRqstSeq() {
		return this.codRqstSeq;
	}
	
	/**
	 * Page Number
	 * @return oldPol
	 */
	public String getOldPol() {
		return this.oldPol;
	}
	
	/**
	 * Page Number
	 * @return oldPod
	 */
	public String getOldPod() {
		return this.oldPod;
	}
	
	/**
	 * Page Number
	 * @return newPod
	 */
	public String getNewPod() {
		return this.newPod;
	}

	/**
	 * Column Info
	 * @param edtBkgNoList
	 */
	public void setEdtBkgNoList(String edtBkgNoList) {
		this.edtBkgNoList = edtBkgNoList;
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
	 * @param edtFromEml
	 */
	public void setEdtFromEml(String edtFromEml) {
		this.edtFromEml = edtFromEml;
	}
	
	/**
	 * Column Info
	 * @param edtContents
	 */
	public void setEdtContents(String edtContents) {
		this.edtContents = edtContents;
	}
	
	/**
	 * Column Info
	 * @param edtSubject
	 */
	public void setEdtSubject(String edtSubject) {
		this.edtSubject = edtSubject;
	}
	
	/**
	 * Column Info
	 * @param edtCcEml
	 */
	public void setEdtCcEml(String edtCcEml) {
		this.edtCcEml = edtCcEml;
	}
	
	/**
	 * Column Info
	 * @param edtToEml
	 */
	public void setEdtToEml(String edtToEml) {
		this.edtToEml = edtToEml;
	}
	
	/**
	 * Column Info
	 * @param edtNtcKndCd
	 */
	public void setEdtNtcKndCd(String edtNtcKndCd) {
		this.edtNtcKndCd = edtNtcKndCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Page Number
	 * @param comRecipient
	 */
	public void setComRecipient(String comRecipient) {
		this.comRecipient = comRecipient;
	}
	
	/**
	 * Page Number
	 * @param comSubject
	 */
	public void setComSubject(String comSubject) {
		this.comSubject = comSubject;
	}
	
	/**
	 * Page Number
	 * @param comContent
	 */
	public void setComContent(String comContent) {
		this.comContent = comContent;
	}
	
	/**
	 * Page Number
	 * @param codStsCd
	 */
	public void setCodStsCd(String codStsCd) {
		this.codStsCd = codStsCd;
	}
	
	/**
	 * Page Number
	 * @param codRqstSeq
	 */
	public void setCodRqstSeq(String codRqstSeq) {
		this.codRqstSeq = codRqstSeq;
	}
	
	/**
	 * Page Number
	 * @param oldPol
	 */
	public void setOldPol(String oldPol) {
		this.oldPol = oldPol;
	}
	
	/**
	 * Page Number
	 * @param oldPod
	 */
	public void setOldPod(String oldPod) {
		this.oldPod = oldPod;
	}
	
	/**
	 * Page Number
	 * @param newPod
	 */
	public void setNewPod(String newPod) {
		this.newPod = newPod;
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
		setEdtBkgNoList(JSPUtil.getParameter(request, prefix + "edt_bkg_no_list", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEdtFromEml(JSPUtil.getParameter(request, prefix + "edt_from_eml", ""));
		setEdtContents(JSPUtil.getParameter(request, prefix + "edt_contents", ""));
		setEdtSubject(JSPUtil.getParameter(request, prefix + "edt_subject", ""));
		setEdtCcEml(JSPUtil.getParameter(request, prefix + "edt_cc_eml", ""));
		setEdtToEml(JSPUtil.getParameter(request, prefix + "edt_to_eml", ""));
		setEdtNtcKndCd(JSPUtil.getParameter(request, prefix + "edt_ntc_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setComRecipient(JSPUtil.getParameter(request, prefix + "com_recipient", ""));
		setComSubject(JSPUtil.getParameter(request, prefix + "com_subject", ""));
		setComContent(JSPUtil.getParameter(request, prefix + "com_content", ""));
		setCodStsCd(JSPUtil.getParameter(request, prefix + "cod_sts_cd", ""));
		setCodRqstSeq(JSPUtil.getParameter(request, prefix + "cod_rqst_seq", ""));
		setOldPol(JSPUtil.getParameter(request, prefix + "old_pol", ""));
		setOldPod(JSPUtil.getParameter(request, prefix + "old_pod", ""));
		setNewPod(JSPUtil.getParameter(request, prefix + "new_pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgEmlEdtVO[]
	 */
	public BkgEmlEdtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgEmlEdtVO[]
	 */
	public BkgEmlEdtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgEmlEdtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] edtBkgNoList = (JSPUtil.getParameter(request, prefix	+ "edt_bkg_no_list", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] edtFromEml = (JSPUtil.getParameter(request, prefix	+ "edt_from_eml", length));
			String[] edtContents = (JSPUtil.getParameter(request, prefix	+ "edt_contents", length));
			String[] edtSubject = (JSPUtil.getParameter(request, prefix	+ "edt_subject", length));
			String[] edtCcEml = (JSPUtil.getParameter(request, prefix	+ "edt_cc_eml", length));
			String[] edtToEml = (JSPUtil.getParameter(request, prefix	+ "edt_to_eml", length));
			String[] edtNtcKndCd = (JSPUtil.getParameter(request, prefix	+ "edt_ntc_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] comRecipient = (JSPUtil.getParameter(request, prefix + "com_recipient", length));
			String[] comSubject = (JSPUtil.getParameter(request, prefix + "com_subject", length));
			String[] comContent = (JSPUtil.getParameter(request, prefix + "com_content", length));
			String[] codStsCd = (JSPUtil.getParameter(request, prefix + "cod_sts_cd", length));
			String[] codRqstSeq = (JSPUtil.getParameter(request, prefix + "cod_rqst_seq", length));
			String[] oldPol	= (JSPUtil.getParameter(request, prefix + "old_pol", length));
			String[] oldPod = (JSPUtil.getParameter(request, prefix + "old_pod", length));
			String[] newPod = (JSPUtil.getParameter(request, prefix + "new_pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgEmlEdtVO();
				if (edtBkgNoList[i] != null)
					model.setEdtBkgNoList(edtBkgNoList[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (edtFromEml[i] != null)
					model.setEdtFromEml(edtFromEml[i]);
				if (edtContents[i] != null)
					model.setEdtContents(edtContents[i]);
				if (edtSubject[i] != null)
					model.setEdtSubject(edtSubject[i]);
				if (edtCcEml[i] != null)
					model.setEdtCcEml(edtCcEml[i]);
				if (edtToEml[i] != null)
					model.setEdtToEml(edtToEml[i]);
				if (edtNtcKndCd[i] != null)
					model.setEdtNtcKndCd(edtNtcKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (comRecipient[i] != null)
					model.setComRecipient(comRecipient[i]);
				if (comSubject[i] != null)
					model.setComSubject(comSubject[i]);
				if (comContent[i] != null)
					model.setComContent(comContent[i]);
				if (codStsCd[i] != null)
					model.setCodStsCd(codStsCd[i]);
				if (codRqstSeq[i] != null)
					model.setCodRqstSeq(codRqstSeq[i]);
				if (oldPol[i] != null)
					model.setOldPol(oldPol[i]);
				if (oldPod[i] != null)
					model.setOldPod(oldPod[i]);
				if (newPod[i] != null)
					model.setNewPod(newPod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgEmlEdtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgEmlEdtVO[]
	 */
	public BkgEmlEdtVO[] getBkgEmlEdtVOs(){
		BkgEmlEdtVO[] vos = (BkgEmlEdtVO[])models.toArray(new BkgEmlEdtVO[models.size()]);
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
		this.edtBkgNoList = this.edtBkgNoList .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtFromEml = this.edtFromEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtContents = this.edtContents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtSubject = this.edtSubject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtCcEml = this.edtCcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtToEml = this.edtToEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edtNtcKndCd = this.edtNtcKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comRecipient = this.comRecipient .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comSubject = this.comSubject .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comContent = this.comContent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codStsCd = this.codStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.codRqstSeq = this.codRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPol = this.oldPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldPod	= this.oldPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPod = this.newPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
