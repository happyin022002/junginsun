/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SendTsListVO.java
*@FileTitle : SendTsListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.11
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2010.01.11 최영희 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최영희
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SendTsListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SendTsListVO> models = new ArrayList<SendTsListVO>();
	
	/* Column Info */
	private String content = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String arrblno = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vsNm = null;
	/* Column Info */
	private String batchNo = null;
	/* Column Info */
	private String param = null;
	/* Column Info */
	private String faxmail = null;
	/* Column Info */
	private String sysApp = null;
	/* Column Info */
	private String mrd = null;
	/* Column Info */
	private String rdtitle = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SendTsListVO() {}

	public SendTsListVO(String ibflag, String pagerows, String content, String arrblno, String rdtitle, String locCd, String batchNo, String vsNm, String param, String faxmail, String sysApp, String mrd) {
		this.content = content;
		this.locCd = locCd;
		this.arrblno = arrblno;
		this.ibflag = ibflag;
		this.vsNm = vsNm;
		this.batchNo = batchNo;
		this.param = param;
		this.faxmail = faxmail;
		this.sysApp = sysApp;
		this.mrd = mrd;
		this.rdtitle = rdtitle;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("content", getContent());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("arrblno", getArrblno());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vs_nm", getVsNm());
		this.hashColumns.put("batch_no", getBatchNo());
		this.hashColumns.put("param", getParam());
		this.hashColumns.put("faxmail", getFaxmail());
		this.hashColumns.put("sys_app", getSysApp());
		this.hashColumns.put("mrd", getMrd());
		this.hashColumns.put("rdtitle", getRdtitle());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("content", "content");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("arrblno", "arrblno");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vs_nm", "vsNm");
		this.hashFields.put("batch_no", "batchNo");
		this.hashFields.put("param", "param");
		this.hashFields.put("faxmail", "faxmail");
		this.hashFields.put("sys_app", "sysApp");
		this.hashFields.put("mrd", "mrd");
		this.hashFields.put("rdtitle", "rdtitle");
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return arrblno
	 */
	public String getArrblno() {
		return this.arrblno;
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
	 * @return vsNm
	 */
	public String getVsNm() {
		return this.vsNm;
	}
	
	/**
	 * Column Info
	 * @return batchNo
	 */
	public String getBatchNo() {
		return this.batchNo;
	}
	
	/**
	 * Column Info
	 * @return param
	 */
	public String getParam() {
		return this.param;
	}
	
	/**
	 * Column Info
	 * @return faxmail
	 */
	public String getFaxmail() {
		return this.faxmail;
	}
	
	/**
	 * Column Info
	 * @return sysApp
	 */
	public String getSysApp() {
		return this.sysApp;
	}
	
	/**
	 * Column Info
	 * @return mrd
	 */
	public String getMrd() {
		return this.mrd;
	}
	
	/**
	 * Column Info
	 * @return rdtitle
	 */
	public String getRdtitle() {
		return this.rdtitle;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param arrblno
	 */
	public void setArrblno(String arrblno) {
		this.arrblno = arrblno;
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
	 * @param vsNm
	 */
	public void setVsNm(String vsNm) {
		this.vsNm = vsNm;
	}
	
	/**
	 * Column Info
	 * @param batchNo
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	/**
	 * Column Info
	 * @param param
	 */
	public void setParam(String param) {
		this.param = param;
	}
	
	/**
	 * Column Info
	 * @param faxmail
	 */
	public void setFaxmail(String faxmail) {
		this.faxmail = faxmail;
	}
	
	/**
	 * Column Info
	 * @param sysApp
	 */
	public void setSysApp(String sysApp) {
		this.sysApp = sysApp;
	}
	
	/**
	 * Column Info
	 * @param mrd
	 */
	public void setMrd(String mrd) {
		this.mrd = mrd;
	}
	
	/**
	 * Column Info
	 * @param rdtitle
	 */
	public void setRdtitle(String rdtitle) {
		this.rdtitle = rdtitle;
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
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setArrblno(JSPUtil.getParameter(request, prefix + "arrblno", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVsNm(JSPUtil.getParameter(request, prefix + "vs_nm", ""));
		setBatchNo(JSPUtil.getParameter(request, prefix + "batch_no", ""));
		setParam(JSPUtil.getParameter(request, prefix + "param", ""));
		setFaxmail(JSPUtil.getParameter(request, prefix + "faxmail", ""));
		setSysApp(JSPUtil.getParameter(request, prefix + "sys_app", ""));
		setMrd(JSPUtil.getParameter(request, prefix + "mrd", ""));
		setRdtitle(JSPUtil.getParameter(request, prefix + "rdtitle", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendTsListVO[]
	 */
	public SendTsListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SendTsListVO[]
	 */
	public SendTsListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SendTsListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] content = (JSPUtil.getParameter(request, prefix	+ "content", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] arrblno = (JSPUtil.getParameter(request, prefix	+ "arrblno", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vsNm = (JSPUtil.getParameter(request, prefix	+ "vs_nm", length));
			String[] batchNo = (JSPUtil.getParameter(request, prefix	+ "batch_no", length));
			String[] param = (JSPUtil.getParameter(request, prefix	+ "param", length));
			String[] faxmail = (JSPUtil.getParameter(request, prefix	+ "faxmail", length));
			String[] sysApp = (JSPUtil.getParameter(request, prefix	+ "sys_app", length));
			String[] mrd = (JSPUtil.getParameter(request, prefix	+ "mrd", length));
			String[] rdtitle = (JSPUtil.getParameter(request, prefix	+ "rdtitle", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SendTsListVO();
				if (content[i] != null)
					model.setContent(content[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (arrblno[i] != null)
					model.setArrblno(arrblno[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vsNm[i] != null)
					model.setVsNm(vsNm[i]);
				if (batchNo[i] != null)
					model.setBatchNo(batchNo[i]);
				if (param[i] != null)
					model.setParam(param[i]);
				if (faxmail[i] != null)
					model.setFaxmail(faxmail[i]);
				if (sysApp[i] != null)
					model.setSysApp(sysApp[i]);
				if (mrd[i] != null)
					model.setMrd(mrd[i]);
				if (rdtitle[i] != null)
					model.setRdtitle(rdtitle[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSendTsListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SendTsListVO[]
	 */
	public SendTsListVO[] getSendTsListVOs(){
		SendTsListVO[] vos = (SendTsListVO[])models.toArray(new SendTsListVO[models.size()]);
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
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrblno = this.arrblno .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsNm = this.vsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchNo = this.batchNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.param = this.param .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxmail = this.faxmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysApp = this.sysApp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrd = this.mrd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtitle = this.rdtitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
