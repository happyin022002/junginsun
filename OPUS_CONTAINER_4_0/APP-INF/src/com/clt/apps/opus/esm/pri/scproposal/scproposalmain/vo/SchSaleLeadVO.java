/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SchSaleLeadVO.java
*@FileTitle : SchSaleLeadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.12
*@LastModifier : 공백진
*@LastVersion : 1.0
* 2010.03.12 공백진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 공백진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SchSaleLeadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SchSaleLeadVO> models = new ArrayList<SchSaleLeadVO>();
	
	/* Column Info */
	private String firstSw = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String realCustSrepCd = null;
	/* Column Info */
	private String realCustSeq = null;
	/* Column Info */
	private String realCustCntCd = null;
	/* Column Info */
	private String ctrtCustSrepCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SchSaleLeadVO() {}

	public SchSaleLeadVO(String ibflag, String pagerows, String custCntCd, String custSeq, String ctrtCustSrepCd, String realCustCntCd, String realCustSeq, String realCustSrepCd, String propNo, String amdtSeq, String firstSw) {
		this.firstSw = firstSw;
		this.ibflag = ibflag;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.realCustSrepCd = realCustSrepCd;
		this.realCustSeq = realCustSeq;
		this.realCustCntCd = realCustCntCd;
		this.ctrtCustSrepCd = ctrtCustSrepCd;
		this.custSeq = custSeq;
		this.custCntCd = custCntCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("first_sw", getFirstSw());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("real_cust_srep_cd", getRealCustSrepCd());
		this.hashColumns.put("real_cust_seq", getRealCustSeq());
		this.hashColumns.put("real_cust_cnt_cd", getRealCustCntCd());
		this.hashColumns.put("ctrt_cust_srep_cd", getCtrtCustSrepCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("first_sw", "firstSw");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("real_cust_srep_cd", "realCustSrepCd");
		this.hashFields.put("real_cust_seq", "realCustSeq");
		this.hashFields.put("real_cust_cnt_cd", "realCustCntCd");
		this.hashFields.put("ctrt_cust_srep_cd", "ctrtCustSrepCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return firstSw
	 */
	public String getFirstSw() {
		return this.firstSw;
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
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
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
	 * @return realCustSrepCd
	 */
	public String getRealCustSrepCd() {
		return this.realCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @return realCustSeq
	 */
	public String getRealCustSeq() {
		return this.realCustSeq;
	}
	
	/**
	 * Column Info
	 * @return realCustCntCd
	 */
	public String getRealCustCntCd() {
		return this.realCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return ctrtCustSrepCd
	 */
	public String getCtrtCustSrepCd() {
		return this.ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
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
	 * @param firstSw
	 */
	public void setFirstSw(String firstSw) {
		this.firstSw = firstSw;
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
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
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
	 * @param realCustSrepCd
	 */
	public void setRealCustSrepCd(String realCustSrepCd) {
		this.realCustSrepCd = realCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @param realCustSeq
	 */
	public void setRealCustSeq(String realCustSeq) {
		this.realCustSeq = realCustSeq;
	}
	
	/**
	 * Column Info
	 * @param realCustCntCd
	 */
	public void setRealCustCntCd(String realCustCntCd) {
		this.realCustCntCd = realCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param ctrtCustSrepCd
	 */
	public void setCtrtCustSrepCd(String ctrtCustSrepCd) {
		this.ctrtCustSrepCd = ctrtCustSrepCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setFirstSw(JSPUtil.getParameter(request, prefix + "first_sw", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setRealCustSrepCd(JSPUtil.getParameter(request, prefix + "real_cust_srep_cd", ""));
		setRealCustSeq(JSPUtil.getParameter(request, prefix + "real_cust_seq", ""));
		setRealCustCntCd(JSPUtil.getParameter(request, prefix + "real_cust_cnt_cd", ""));
		setCtrtCustSrepCd(JSPUtil.getParameter(request, prefix + "ctrt_cust_srep_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SchSaleLeadVO[]
	 */
	public SchSaleLeadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SchSaleLeadVO[]
	 */
	public SchSaleLeadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SchSaleLeadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] firstSw = (JSPUtil.getParameter(request, prefix	+ "first_sw", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] realCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_srep_cd", length));
			String[] realCustSeq = (JSPUtil.getParameter(request, prefix	+ "real_cust_seq", length));
			String[] realCustCntCd = (JSPUtil.getParameter(request, prefix	+ "real_cust_cnt_cd", length));
			String[] ctrtCustSrepCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_cust_srep_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new SchSaleLeadVO();
				if (firstSw[i] != null)
					model.setFirstSw(firstSw[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (realCustSrepCd[i] != null)
					model.setRealCustSrepCd(realCustSrepCd[i]);
				if (realCustSeq[i] != null)
					model.setRealCustSeq(realCustSeq[i]);
				if (realCustCntCd[i] != null)
					model.setRealCustCntCd(realCustCntCd[i]);
				if (ctrtCustSrepCd[i] != null)
					model.setCtrtCustSrepCd(ctrtCustSrepCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSchSaleLeadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SchSaleLeadVO[]
	 */
	public SchSaleLeadVO[] getSchSaleLeadVOs(){
		SchSaleLeadVO[] vos = (SchSaleLeadVO[])models.toArray(new SchSaleLeadVO[models.size()]);
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
		this.firstSw = this.firstSw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSrepCd = this.realCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSeq = this.realCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustCntCd = this.realCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtCustSrepCd = this.ctrtCustSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
