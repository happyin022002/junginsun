/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ChinaCncusDangerCntrVO.java
*@FileTitle : ChinaCncusDangerCntrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier :
*@LastVersion : 1.0
* 2010.04.15
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.china.vo;

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

public class ChinaCncusDangerCntrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<ChinaCncusDangerCntrVO> models = new ArrayList<ChinaCncusDangerCntrVO>();

	/* Column Info */
	private String flashPoint = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String page = null;
	/* Column Info */
	private String contactName = null;
	/* Column Info */
	private String undgno = null;
	/* Column Info */
	private String label = null;
	/* Column Info */
	private String contactTel = null;
	/* Column Info */
	private String clss = null;
	/* Column Info */
	private String emsNo = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public ChinaCncusDangerCntrVO() {}

	public ChinaCncusDangerCntrVO(String ibflag, String pagerows, String clss, String page, String undgno, String label, String flashPoint, String emsNo, String contactName, String contactTel) {
		this.flashPoint = flashPoint;
		this.ibflag = ibflag;
		this.page = page;
		this.contactName = contactName;
		this.undgno = undgno;
		this.label = label;
		this.contactTel = contactTel;
		this.clss = clss;
		this.emsNo = emsNo;
		this.pagerows = pagerows;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("flash_point", getFlashPoint());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("page", getPage());
		this.hashColumns.put("contact_name", getContactName());
		this.hashColumns.put("undgno", getUndgno());
		this.hashColumns.put("label", getLabel());
		this.hashColumns.put("contact_tel", getContactTel());
		this.hashColumns.put("clss", getClss());
		this.hashColumns.put("ems_no", getEmsNo());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("flash_point", "flashPoint");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("page", "page");
		this.hashFields.put("contact_name", "contactName");
		this.hashFields.put("undgno", "undgno");
		this.hashFields.put("label", "label");
		this.hashFields.put("contact_tel", "contactTel");
		this.hashFields.put("clss", "clss");
		this.hashFields.put("ems_no", "emsNo");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return flashPoint
	 */
	public String getFlashPoint() {
		return this.flashPoint;
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
	 * @return page
	 */
	public String getPage() {
		return this.page;
	}

	/**
	 * Column Info
	 * @return contactName
	 */
	public String getContactName() {
		return this.contactName;
	}

	/**
	 * Column Info
	 * @return undgno
	 */
	public String getUndgno() {
		return this.undgno;
	}

	/**
	 * Column Info
	 * @return label
	 */
	public String getLabel() {
		return this.label;
	}

	/**
	 * Column Info
	 * @return contactTel
	 */
	public String getContactTel() {
		return this.contactTel;
	}

	/**
	 * Column Info
	 * @return clss
	 */
	public String getClss() {
		return this.clss;
	}

	/**
	 * Column Info
	 * @return emsNo
	 */
	public String getEmsNo() {
		return this.emsNo;
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
	 * @param flashPoint
	 */
	public void setFlashPoint(String flashPoint) {
		this.flashPoint = flashPoint;
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
	 * @param page
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * Column Info
	 * @param contactName
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	/**
	 * Column Info
	 * @param undgno
	 */
	public void setUndgno(String undgno) {
		this.undgno = undgno;
	}

	/**
	 * Column Info
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Column Info
	 * @param contactTel
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}

	/**
	 * Column Info
	 * @param clss
	 */
	public void setClss(String clss) {
		this.clss = clss;
	}

	/**
	 * Column Info
	 * @param emsNo
	 */
	public void setEmsNo(String emsNo) {
		this.emsNo = emsNo;
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
		setFlashPoint(JSPUtil.getParameter(request, prefix + "flash_point", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPage(JSPUtil.getParameter(request, prefix + "page", ""));
		setContactName(JSPUtil.getParameter(request, prefix + "contact_name", ""));
		setUndgno(JSPUtil.getParameter(request, prefix + "undgno", ""));
		setLabel(JSPUtil.getParameter(request, prefix + "label", ""));
		setContactTel(JSPUtil.getParameter(request, prefix + "contact_tel", ""));
		setClss(JSPUtil.getParameter(request, prefix + "clss", ""));
		setEmsNo(JSPUtil.getParameter(request, prefix + "ems_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaCncusDangerCntrVO[]
	 */
	public ChinaCncusDangerCntrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaCncusDangerCntrVO[]
	 */
	public ChinaCncusDangerCntrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ChinaCncusDangerCntrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] flashPoint = (JSPUtil.getParameter(request, prefix	+ "flash_point", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] page = (JSPUtil.getParameter(request, prefix	+ "page", length));
			String[] contactName = (JSPUtil.getParameter(request, prefix	+ "contact_name", length));
			String[] undgno = (JSPUtil.getParameter(request, prefix	+ "undgno", length));
			String[] label = (JSPUtil.getParameter(request, prefix	+ "label", length));
			String[] contactTel = (JSPUtil.getParameter(request, prefix	+ "contact_tel", length));
			String[] clss = (JSPUtil.getParameter(request, prefix	+ "clss", length));
			String[] emsNo = (JSPUtil.getParameter(request, prefix	+ "ems_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));

			for (int i = 0; i < length; i++) {
				model = new ChinaCncusDangerCntrVO();
				if (flashPoint[i] != null)
					model.setFlashPoint(flashPoint[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (page[i] != null)
					model.setPage(page[i]);
				if (contactName[i] != null)
					model.setContactName(contactName[i]);
				if (undgno[i] != null)
					model.setUndgno(undgno[i]);
				if (label[i] != null)
					model.setLabel(label[i]);
				if (contactTel[i] != null)
					model.setContactTel(contactTel[i]);
				if (clss[i] != null)
					model.setClss(clss[i]);
				if (emsNo[i] != null)
					model.setEmsNo(emsNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getChinaCncusDangerCntrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ChinaCncusDangerCntrVO[]
	 */
	public ChinaCncusDangerCntrVO[] getChinaCncusDangerCntrVOs(){
		ChinaCncusDangerCntrVO[] vos = (ChinaCncusDangerCntrVO[])models.toArray(new ChinaCncusDangerCntrVO[models.size()]);
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
		this.flashPoint = this.flashPoint .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.page = this.page .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactName = this.contactName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.undgno = this.undgno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.label = this.label .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactTel = this.contactTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clss = this.clss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emsNo = this.emsNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
