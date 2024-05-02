/*=========================================================
*Copyright(c) 2018 Hipluscard
*@FileName : PriSpInqRecListVO.java
*@FileTitle : PriSpInqRecListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.10
*@LastModifier : 송민석
*@LastVersion : 1.0
* 2018.01.10 송민석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 송민석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class PriSpInqRecListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PriSpInqRecListVO> models = new ArrayList<PriSpInqRecListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String fileDt = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String uiName = null;
	/* Column Info */
	private String ipAddr = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String realCustNm = null;
	/* Column Info */
	private String lginId = null;
	/* Column Info */
	private String lginOfc = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String inquiryTime = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String propOfcCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String status = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PriSpInqRecListVO() {}

	public PriSpInqRecListVO(String ibflag, String pagerows, String scNo, String amdtSeq, String propNo, String custNm, String realCustNm, String custTpCd, String status, String fileDt, String lginId, String usrNm, String lginOfc, String srepCd, String ipAddr, String uiName, String inquiryTime, String propOfcCd) {
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.scNo = scNo;
		this.custNm = custNm;
		this.fileDt = fileDt;
		this.custTpCd = custTpCd;
		this.uiName = uiName;
		this.ipAddr = ipAddr;
		this.amdtSeq = amdtSeq;
		this.realCustNm = realCustNm;
		this.lginId = lginId;
		this.lginOfc = lginOfc;
		this.usrNm = usrNm;
		this.inquiryTime = inquiryTime;
		this.srepCd = srepCd;
		this.propOfcCd = propOfcCd;
		this.propNo = propNo;
		this.status = status;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("file_dt", getFileDt());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("ui_name", getUiName());
		this.hashColumns.put("ip_addr", getIpAddr());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("real_cust_nm", getRealCustNm());
		this.hashColumns.put("lgin_id", getLginId());
		this.hashColumns.put("lgin_ofc", getLginOfc());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("inquiry_time", getInquiryTime());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("status", getStatus());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("file_dt", "fileDt");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("ui_name", "uiName");
		this.hashFields.put("ip_addr", "ipAddr");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("real_cust_nm", "realCustNm");
		this.hashFields.put("lgin_id", "lginId");
		this.hashFields.put("lgin_ofc", "lginOfc");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("inquiry_time", "inquiryTime");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("status", "status");
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return fileDt
	 */
	public String getFileDt() {
		return this.fileDt;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return uiName
	 */
	public String getUiName() {
		return this.uiName;
	}
	
	/**
	 * Column Info
	 * @return ipAddr
	 */
	public String getIpAddr() {
		return this.ipAddr;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return realCustNm
	 */
	public String getRealCustNm() {
		return this.realCustNm;
	}
	
	/**
	 * Column Info
	 * @return lginId
	 */
	public String getLginId() {
		return this.lginId;
	}
	
	/**
	 * Column Info
	 * @return lginOfc
	 */
	public String getLginOfc() {
		return this.lginOfc;
	}
	
	/**
	 * Column Info
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
	}
	
	/**
	 * Column Info
	 * @return inquiryTime
	 */
	public String getInquiryTime() {
		return this.inquiryTime;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return propOfcCd
	 */
	public String getPropOfcCd() {
		return this.propOfcCd;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	

	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param fileDt
	 */
	public void setFileDt(String fileDt) {
		this.fileDt = fileDt;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param uiName
	 */
	public void setUiName(String uiName) {
		this.uiName = uiName;
	}
	
	/**
	 * Column Info
	 * @param ipAddr
	 */
	public void setIpAddr(String ipAddr) {
		this.ipAddr = ipAddr;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param realCustNm
	 */
	public void setRealCustNm(String realCustNm) {
		this.realCustNm = realCustNm;
	}
	
	/**
	 * Column Info
	 * @param lginId
	 */
	public void setLginId(String lginId) {
		this.lginId = lginId;
	}
	
	/**
	 * Column Info
	 * @param lginOfc
	 */
	public void setLginOfc(String lginOfc) {
		this.lginOfc = lginOfc;
	}
	
	/**
	 * Column Info
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	
	/**
	 * Column Info
	 * @param inquiryTime
	 */
	public void setInquiryTime(String inquiryTime) {
		this.inquiryTime = inquiryTime;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param propOfcCd
	 */
	public void setPropOfcCd(String propOfcCd) {
		this.propOfcCd = propOfcCd;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
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
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setFileDt(JSPUtil.getParameter(request, prefix + "file_dt", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setUiName(JSPUtil.getParameter(request, prefix + "ui_name", ""));
		setIpAddr(JSPUtil.getParameter(request, prefix + "ip_addr", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setRealCustNm(JSPUtil.getParameter(request, prefix + "real_cust_nm", ""));
		setLginId(JSPUtil.getParameter(request, prefix + "lgin_id", ""));
		setLginOfc(JSPUtil.getParameter(request, prefix + "lgin_ofc", ""));
		setUsrNm(JSPUtil.getParameter(request, prefix + "usr_nm", ""));
		setInquiryTime(JSPUtil.getParameter(request, prefix + "inquiry_time", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPropOfcCd(JSPUtil.getParameter(request, prefix + "prop_ofc_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriSpInqRecListVO[]
	 */
	public PriSpInqRecListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PriSpInqRecListVO[]
	 */
	public PriSpInqRecListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PriSpInqRecListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] fileDt = (JSPUtil.getParameter(request, prefix	+ "file_dt", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] uiName = (JSPUtil.getParameter(request, prefix	+ "ui_name", length));
			String[] ipAddr = (JSPUtil.getParameter(request, prefix	+ "ip_addr", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] realCustNm = (JSPUtil.getParameter(request, prefix	+ "real_cust_nm", length));
			String[] lginId = (JSPUtil.getParameter(request, prefix	+ "lgin_id", length));
			String[] lginOfc = (JSPUtil.getParameter(request, prefix	+ "lgin_ofc", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] inquiryTime = (JSPUtil.getParameter(request, prefix	+ "inquiry_time", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] propOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_ofc_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			
			for (int i = 0; i < length; i++) {
				model = new PriSpInqRecListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (fileDt[i] != null)
					model.setFileDt(fileDt[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (uiName[i] != null)
					model.setUiName(uiName[i]);
				if (ipAddr[i] != null)
					model.setIpAddr(ipAddr[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (realCustNm[i] != null)
					model.setRealCustNm(realCustNm[i]);
				if (lginId[i] != null)
					model.setLginId(lginId[i]);
				if (lginOfc[i] != null)
					model.setLginOfc(lginOfc[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (inquiryTime[i] != null)
					model.setInquiryTime(inquiryTime[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (propOfcCd[i] != null)
					model.setPropOfcCd(propOfcCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPriSpInqRecListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PriSpInqRecListVO[]
	 */
	public PriSpInqRecListVO[] getPriSpInqRecListVOs(){
		PriSpInqRecListVO[] vos = (PriSpInqRecListVO[])models.toArray(new PriSpInqRecListVO[models.size()]);
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
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileDt = this.fileDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uiName = this.uiName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ipAddr = this.ipAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustNm = this.realCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginId = this.lginId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lginOfc = this.lginOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inquiryTime = this.inquiryTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd = this.propOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
