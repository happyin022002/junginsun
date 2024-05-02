/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : CustCntcPntIfVO.java
*@FileTitle : CustCntcPntIfVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sam.custmanage.custmain.vo;

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
public class CustCntcPntIfVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustCntcPntIfVO> models = new ArrayList<CustCntcPntIfVO>();
	
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	
	/* Page Number */
	private String pagerows = null;

	/* Column Info */
	private String custCntcPntIfSeq = null;

	/* Column Info */
	private String custCntCd = null;

	/* Column Info */
	private String custSeq = null;

	/* Column Info */
	private String custCntcPntSeq = null;

	/* Column Info */
	private String custEml = null;

	/* Column Info */
	private String custIp = null;

	/* Column Info */
	private String custUrl = null;

	/* Column Info */
	private String intlPhnNo = null;

	/* Column Info */
	private String phnNo = null;

	/* Column Info */
	private String intlFaxNo = null;

	/* Column Info */
	private String faxNo = null;

	/* Column Info */
	private String r3InsfId = null;

	/* Column Info */
	private String r3InsfPrsId = null;

	/* Column Info */
	private String r3InsfDttm = null;

	/* Column Info */
	private String r3InsfCnqeVal = null;

	/* Column Info */
	private String r3InsfDvCd = null;

	/* Column Info */
	private String r3InsfCnqeCont = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CustCntcPntIfVO() {}

	public CustCntcPntIfVO(String ibflag, String pagerows, String custCntcPntIfSeq, String custCntCd, String custSeq, String custCntcPntSeq, String custEml, String custIp, String custUrl, String intlPhnNo, String phnNo, String intlFaxNo, String faxNo, String r3InsfId, String r3InsfPrsId, String r3InsfDttm, String r3InsfCnqeVal, String r3InsfDvCd, String r3InsfCnqeCont) {
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.custCntcPntIfSeq = custCntcPntIfSeq;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.custCntcPntSeq = custCntcPntSeq;
		this.custEml = custEml;
		this.custIp = custIp;
		this.custUrl = custUrl;
		this.intlPhnNo = intlPhnNo;
		this.phnNo = phnNo;
		this.intlFaxNo = intlFaxNo;
		this.faxNo = faxNo;
		this.r3InsfId = r3InsfId;
		this.r3InsfPrsId = r3InsfPrsId;
		this.r3InsfDttm = r3InsfDttm;
		this.r3InsfCnqeVal = r3InsfCnqeVal;
		this.r3InsfDvCd = r3InsfDvCd;
		this.r3InsfCnqeCont = r3InsfCnqeCont;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_cntc_pnt_if_seq", getCustCntcPntIfSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cntc_pnt_seq", getCustCntcPntSeq());
		this.hashColumns.put("cust_eml", getCustEml());
		this.hashColumns.put("cust_ip", getCustIp());
		this.hashColumns.put("cust_url", getCustUrl());
		this.hashColumns.put("intl_phn_no", getIntlPhnNo());
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("intl_fax_no", getIntlFaxNo());
		this.hashColumns.put("fax_no", getFaxNo());
		this.hashColumns.put("r3_insf_id", getR3InsfId());
		this.hashColumns.put("r3_insf_prs_id", getR3InsfPrsId());
		this.hashColumns.put("r3_insf_dttm", getR3InsfDttm());
		this.hashColumns.put("r3_insf_cnqe_val", getR3InsfCnqeVal());
		this.hashColumns.put("r3_insf_dv_cd", getR3InsfDvCd());
		this.hashColumns.put("r3_insf_cnqe_cont", getR3InsfCnqeCont());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_cntc_pnt_if_seq", "custCntcPntIfSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cntc_pnt_seq", "custCntcPntSeq");
		this.hashFields.put("cust_eml", "custEml");
		this.hashFields.put("cust_ip", "custIp");
		this.hashFields.put("cust_url", "custUrl");
		this.hashFields.put("intl_phn_no", "intlPhnNo");
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("intl_fax_no", "intlFaxNo");
		this.hashFields.put("fax_no", "faxNo");
		this.hashFields.put("r3_insf_id", "r3InsfId");
		this.hashFields.put("r3_insf_prs_id", "r3InsfPrsId");
		this.hashFields.put("r3_insf_dttm", "r3InsfDttm");
		this.hashFields.put("r3_insf_cnqe_val", "r3InsfCnqeVal");
		this.hashFields.put("r3_insf_dv_cd", "r3InsfDvCd");
		this.hashFields.put("r3_insf_cnqe_cont", "r3InsfCnqeCont");
		return this.hashFields;
	}
	
	/**
	 *
	 * @param String ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * 
	 * @return String ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 *
	 * @param String pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * 
	 * @return String pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 *
	 * @param String custCntcPntIfSeq
	 */
	public void setCustCntcPntIfSeq(String custCntcPntIfSeq) {
		this.custCntcPntIfSeq = custCntcPntIfSeq;
	}
	
	/**
	 * 
	 * @return String custCntcPntIfSeq
	 */
	public String getCustCntcPntIfSeq() {
		return this.custCntcPntIfSeq;
	}
	
	/**
	 *
	 * @param String custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 
	 * @return String custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 *
	 * @param String custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * 
	 * @return String custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 *
	 * @param String custCntcPntSeq
	 */
	public void setCustCntcPntSeq(String custCntcPntSeq) {
		this.custCntcPntSeq = custCntcPntSeq;
	}
	
	/**
	 * 
	 * @return String custCntcPntSeq
	 */
	public String getCustCntcPntSeq() {
		return this.custCntcPntSeq;
	}
	
	/**
	 *
	 * @param String custEml
	 */
	public void setCustEml(String custEml) {
		this.custEml = custEml;
	}
	
	/**
	 * 
	 * @return String custEml
	 */
	public String getCustEml() {
		return this.custEml;
	}
	
	/**
	 *
	 * @param String custIp
	 */
	public void setCustIp(String custIp) {
		this.custIp = custIp;
	}
	
	/**
	 * 
	 * @return String custIp
	 */
	public String getCustIp() {
		return this.custIp;
	}
	
	/**
	 *
	 * @param String custUrl
	 */
	public void setCustUrl(String custUrl) {
		this.custUrl = custUrl;
	}
	
	/**
	 * 
	 * @return String custUrl
	 */
	public String getCustUrl() {
		return this.custUrl;
	}
	
	/**
	 *
	 * @param String intlPhnNo
	 */
	public void setIntlPhnNo(String intlPhnNo) {
		this.intlPhnNo = intlPhnNo;
	}
	
	/**
	 * 
	 * @return String intlPhnNo
	 */
	public String getIntlPhnNo() {
		return this.intlPhnNo;
	}
	
	/**
	 *
	 * @param String phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
	}
	
	/**
	 * 
	 * @return String phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
	}
	
	/**
	 *
	 * @param String intlFaxNo
	 */
	public void setIntlFaxNo(String intlFaxNo) {
		this.intlFaxNo = intlFaxNo;
	}
	
	/**
	 * 
	 * @return String intlFaxNo
	 */
	public String getIntlFaxNo() {
		return this.intlFaxNo;
	}
	
	/**
	 *
	 * @param String faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	
	/**
	 * 
	 * @return String faxNo
	 */
	public String getFaxNo() {
		return this.faxNo;
	}
	
	/**
	 *
	 * @param String r3InsfId
	 */
	public void setR3InsfId(String r3InsfId) {
		this.r3InsfId = r3InsfId;
	}
	
	/**
	 * 
	 * @return String r3InsfId
	 */
	public String getR3InsfId() {
		return this.r3InsfId;
	}
	
	/**
	 *
	 * @param String r3InsfPrsId
	 */
	public void setR3InsfPrsId(String r3InsfPrsId) {
		this.r3InsfPrsId = r3InsfPrsId;
	}
	
	/**
	 * 
	 * @return String r3InsfPrsId
	 */
	public String getR3InsfPrsId() {
		return this.r3InsfPrsId;
	}
	
	/**
	 *
	 * @param String r3InsfDttm
	 */
	public void setR3InsfDttm(String r3InsfDttm) {
		this.r3InsfDttm = r3InsfDttm;
	}
	
	/**
	 * 
	 * @return String r3InsfDttm
	 */
	public String getR3InsfDttm() {
		return this.r3InsfDttm;
	}
	
	/**
	 *
	 * @param String r3InsfCnqeVal
	 */
	public void setR3InsfCnqeVal(String r3InsfCnqeVal) {
		this.r3InsfCnqeVal = r3InsfCnqeVal;
	}
	
	/**
	 * 
	 * @return String r3InsfCnqeVal
	 */
	public String getR3InsfCnqeVal() {
		return this.r3InsfCnqeVal;
	}
	
	/**
	 *
	 * @param String r3InsfDvCd
	 */
	public void setR3InsfDvCd(String r3InsfDvCd) {
		this.r3InsfDvCd = r3InsfDvCd;
	}
	
	/**
	 * 
	 * @return String r3InsfDvCd
	 */
	public String getR3InsfDvCd() {
		return this.r3InsfDvCd;
	}
	
	/**
	 *
	 * @param String r3InsfCnqeCont
	 */
	public void setR3InsfCnqeCont(String r3InsfCnqeCont) {
		this.r3InsfCnqeCont = r3InsfCnqeCont;
	}
	
	/**
	 * 
	 * @return String r3InsfCnqeCont
	 */
	public String getR3InsfCnqeCont() {
		return this.r3InsfCnqeCont;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustCntcPntIfSeq(JSPUtil.getParameter(request, prefix + "cust_cntc_pnt_if_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustCntcPntSeq(JSPUtil.getParameter(request, prefix + "cust_cntc_pnt_seq", ""));
		setCustEml(JSPUtil.getParameter(request, prefix + "cust_eml", ""));
		setCustIp(JSPUtil.getParameter(request, prefix + "cust_ip", ""));
		setCustUrl(JSPUtil.getParameter(request, prefix + "cust_url", ""));
		setIntlPhnNo(JSPUtil.getParameter(request, prefix + "intl_phn_no", ""));
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setIntlFaxNo(JSPUtil.getParameter(request, prefix + "intl_fax_no", ""));
		setFaxNo(JSPUtil.getParameter(request, prefix + "fax_no", ""));
		setR3InsfId(JSPUtil.getParameter(request, prefix + "r3_insf_id", ""));
		setR3InsfPrsId(JSPUtil.getParameter(request, prefix + "r3_insf_prs_id", ""));
		setR3InsfDttm(JSPUtil.getParameter(request, prefix + "r3_insf_dttm", ""));
		setR3InsfCnqeVal(JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_val", ""));
		setR3InsfDvCd(JSPUtil.getParameter(request, prefix + "r3_insf_dv_cd", ""));
		setR3InsfCnqeCont(JSPUtil.getParameter(request, prefix + "r3_insf_cnqe_cont", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustCntcPntIfVO[]
	 */
	public CustCntcPntIfVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustCntcPntIfVO[]
	 */
	public CustCntcPntIfVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustCntcPntIfVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custCntcPntIfSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_pnt_if_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custCntcPntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cntc_pnt_seq", length));
			String[] custEml = (JSPUtil.getParameter(request, prefix	+ "cust_eml", length));
			String[] custIp = (JSPUtil.getParameter(request, prefix	+ "cust_ip", length));
			String[] custUrl = (JSPUtil.getParameter(request, prefix	+ "cust_url", length));
			String[] intlPhnNo = (JSPUtil.getParameter(request, prefix	+ "intl_phn_no", length));
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] intlFaxNo = (JSPUtil.getParameter(request, prefix	+ "intl_fax_no", length));
			String[] faxNo = (JSPUtil.getParameter(request, prefix	+ "fax_no", length));
			String[] r3InsfId = (JSPUtil.getParameter(request, prefix	+ "r3_insf_id", length));
			String[] r3InsfPrsId = (JSPUtil.getParameter(request, prefix	+ "r3_insf_prs_id", length));
			String[] r3InsfDttm = (JSPUtil.getParameter(request, prefix	+ "r3_insf_dttm", length));
			String[] r3InsfCnqeVal = (JSPUtil.getParameter(request, prefix	+ "r3_insf_cnqe_val", length));
			String[] r3InsfDvCd = (JSPUtil.getParameter(request, prefix	+ "r3_insf_dv_cd", length));
			String[] r3InsfCnqeCont = (JSPUtil.getParameter(request, prefix	+ "r3_insf_cnqe_cont", length));
			/* Add a field line, do not delete */
			
			for (int i = 0; i < length; i++) {
				model = new CustCntcPntIfVO();
				if (ibflag[i] != null) 
					model.setIbflag(ibflag[i]);
				if (pagerows[i] != null) 
					model.setPagerows(pagerows[i]);
				if (custCntcPntIfSeq[i] != null) 
					model.setCustCntcPntIfSeq(custCntcPntIfSeq[i]);
				if (custCntCd[i] != null) 
					model.setCustCntCd(custCntCd[i]);
				if (custSeq[i] != null) 
					model.setCustSeq(custSeq[i]);
				if (custCntcPntSeq[i] != null) 
					model.setCustCntcPntSeq(custCntcPntSeq[i]);
				if (custEml[i] != null) 
					model.setCustEml(custEml[i]);
				if (custIp[i] != null) 
					model.setCustIp(custIp[i]);
				if (custUrl[i] != null) 
					model.setCustUrl(custUrl[i]);
				if (intlPhnNo[i] != null) 
					model.setIntlPhnNo(intlPhnNo[i]);
				if (phnNo[i] != null) 
					model.setPhnNo(phnNo[i]);
				if (intlFaxNo[i] != null) 
					model.setIntlFaxNo(intlFaxNo[i]);
				if (faxNo[i] != null) 
					model.setFaxNo(faxNo[i]);
				if (r3InsfId[i] != null) 
					model.setR3InsfId(r3InsfId[i]);
				if (r3InsfPrsId[i] != null) 
					model.setR3InsfPrsId(r3InsfPrsId[i]);
				if (r3InsfDttm[i] != null) 
					model.setR3InsfDttm(r3InsfDttm[i]);
				if (r3InsfCnqeVal[i] != null) 
					model.setR3InsfCnqeVal(r3InsfCnqeVal[i]);
				if (r3InsfDvCd[i] != null) 
					model.setR3InsfDvCd(r3InsfDvCd[i]);
				if (r3InsfCnqeCont[i] != null) 
					model.setR3InsfCnqeCont(r3InsfCnqeCont[i]);
				/* Add a Method line, do not delete */
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustCntcPntIfVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustCntcPntIfVO[]
	 */
	public CustCntcPntIfVO[] getCustCntcPntIfVOs(){
		CustCntcPntIfVO[] vos = (CustCntcPntIfVO[])models.toArray(new CustCntcPntIfVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcPntIfSeq = this.custCntcPntIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntcPntSeq = this.custCntcPntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custEml = this.custEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custIp = this.custIp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custUrl = this.custUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlPhnNo = this.intlPhnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intlFaxNo = this.intlFaxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNo = this.faxNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfId = this.r3InsfId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfPrsId = this.r3InsfPrsId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfDttm = this.r3InsfDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfCnqeVal = this.r3InsfCnqeVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfDvCd = this.r3InsfDvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.r3InsfCnqeCont = this.r3InsfCnqeCont .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}