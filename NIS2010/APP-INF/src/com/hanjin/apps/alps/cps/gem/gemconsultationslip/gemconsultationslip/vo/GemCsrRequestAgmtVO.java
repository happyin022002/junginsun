/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GemCsrRequestAgmtVO.java
*@FileTitle : GemCsrRequestAgmtVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.10.30
*@LastModifier : 
*@LastVersion : 1.0
* 2014.10.30  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.cps.gem.gemconsultationslip.gemconsultationslip.vo;

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

public class GemCsrRequestAgmtVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GemCsrRequestAgmtVO> models = new ArrayList<GemCsrRequestAgmtVO>();
	
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String lDocumentTitle = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String lAssetcd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public GemCsrRequestAgmtVO() {}

	public GemCsrRequestAgmtVO(String ibflag, String pagerows, String lDocumentTitle, String lAssetcd, String csrNo, String vndrSeq, String invNo) {
		this.invNo = invNo;
		this.csrNo = csrNo;
		this.lDocumentTitle = lDocumentTitle;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.lAssetcd = lAssetcd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("l_document_title", getLDocumentTitle());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("l_assetcd", getLAssetcd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("l_document_title", "lDocumentTitle");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("l_assetcd", "lAssetcd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return csrNo
	 */
	public String getCsrNo() {
		return this.csrNo;
	}
	
	/**
	 * Column Info
	 * @return lDocumentTitle
	 */
	public String getLDocumentTitle() {
		return this.lDocumentTitle;
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
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return lAssetcd
	 */
	public String getLAssetcd() {
		return this.lAssetcd;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param csrNo
	 */
	public void setCsrNo(String csrNo) {
		this.csrNo = csrNo;
	}
	
	/**
	 * Column Info
	 * @param lDocumentTitle
	 */
	public void setLDocumentTitle(String lDocumentTitle) {
		this.lDocumentTitle = lDocumentTitle;
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
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param lAssetcd
	 */
	public void setLAssetcd(String lAssetcd) {
		this.lAssetcd = lAssetcd;
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
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setLDocumentTitle(JSPUtil.getParameter(request, prefix + "l_document_title", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setLAssetcd(JSPUtil.getParameter(request, prefix + "l_assetcd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GemCsrRequestAgmtVO[]
	 */
	public GemCsrRequestAgmtVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GemCsrRequestAgmtVO[]
	 */
	public GemCsrRequestAgmtVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GemCsrRequestAgmtVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] lDocumentTitle = (JSPUtil.getParameter(request, prefix	+ "l_document_title", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] lAssetcd = (JSPUtil.getParameter(request, prefix	+ "l_assetcd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new GemCsrRequestAgmtVO();
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (lDocumentTitle[i] != null)
					model.setLDocumentTitle(lDocumentTitle[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (lAssetcd[i] != null)
					model.setLAssetcd(lAssetcd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGemCsrRequestAgmtVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GemCsrRequestAgmtVO[]
	 */
	public GemCsrRequestAgmtVO[] getGemCsrRequestAgmtVOs(){
		GemCsrRequestAgmtVO[] vos = (GemCsrRequestAgmtVO[])models.toArray(new GemCsrRequestAgmtVO[models.size()]);
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
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lDocumentTitle = this.lDocumentTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lAssetcd = this.lAssetcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
