/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : RsltRealCustInquiryVO.java
*@FileTitle : RsltRealCustInquiryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.09
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2011.11.09 서미진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.screalcustomerproposal.vo;

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
 * @author 서미진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRealCustInquiryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRealCustInquiryVO> models = new ArrayList<RsltRealCustInquiryVO>();
	
	/* Column Info */
	private String repCustFlg = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String custValSgmCd = null;
	/* Column Info */
	private String realCustNm = null;
	/* Column Info */
	private String realCustValSgm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String realCustSrepNm = null;
	/* Column Info */
	private String prcCtrtCustTpCd = null;
	/* Column Info */
	private String custSlsOfcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String custSrepCd = null;
	/* Column Info */
	private String realCustSeq = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRealCustInquiryVO() {}

	public RsltRealCustInquiryVO(String ibflag, String pagerows, String realCustSeq, String custCntCd, String custSeq, String custValSgmCd, String prcCtrtCustTpCd, String custSrepCd, String custSlsOfcCd, String repCustFlg, String propNo, String amdtSeq, String realCustNm, String realCustSrepNm, String realCustValSgm, String custLocCd) {
		this.repCustFlg = repCustFlg;
		this.amdtSeq = amdtSeq;
		this.custValSgmCd = custValSgmCd;
		this.realCustNm = realCustNm;
		this.realCustValSgm = realCustValSgm;
		this.custSeq = custSeq;
		this.custLocCd = custLocCd;
		this.pagerows = pagerows;
		this.realCustSrepNm = realCustSrepNm;
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
		this.custSlsOfcCd = custSlsOfcCd;
		this.ibflag = ibflag;
		this.propNo = propNo;
		this.custSrepCd = custSrepCd;
		this.realCustSeq = realCustSeq;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rep_cust_flg", getRepCustFlg());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cust_val_sgm_cd", getCustValSgmCd());
		this.hashColumns.put("real_cust_nm", getRealCustNm());
		this.hashColumns.put("real_cust_val_sgm", getRealCustValSgm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_loc_cd", getCustLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("real_cust_srep_nm", getRealCustSrepNm());
		this.hashColumns.put("prc_ctrt_cust_tp_cd", getPrcCtrtCustTpCd());
		this.hashColumns.put("cust_sls_ofc_cd", getCustSlsOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cust_srep_cd", getCustSrepCd());
		this.hashColumns.put("real_cust_seq", getRealCustSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rep_cust_flg", "repCustFlg");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cust_val_sgm_cd", "custValSgmCd");
		this.hashFields.put("real_cust_nm", "realCustNm");
		this.hashFields.put("real_cust_val_sgm", "realCustValSgm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_loc_cd", "custLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("real_cust_srep_nm", "realCustSrepNm");
		this.hashFields.put("prc_ctrt_cust_tp_cd", "prcCtrtCustTpCd");
		this.hashFields.put("cust_sls_ofc_cd", "custSlsOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cust_srep_cd", "custSrepCd");
		this.hashFields.put("real_cust_seq", "realCustSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return repCustFlg
	 */
	public String getRepCustFlg() {
		return this.repCustFlg;
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
	 * @return custValSgmCd
	 */
	public String getCustValSgmCd() {
		return this.custValSgmCd;
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
	 * @return realCustValSgm
	 */
	public String getRealCustValSgm() {
		return this.realCustValSgm;
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
	 * @return custLocCd
	 */
	public String getCustLocCd() {
		return this.custLocCd;
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
	 * @return realCustSrepNm
	 */
	public String getRealCustSrepNm() {
		return this.realCustSrepNm;
	}
	
	/**
	 * Column Info
	 * @return prcCtrtCustTpCd
	 */
	public String getPrcCtrtCustTpCd() {
		return this.prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @return custSlsOfcCd
	 */
	public String getCustSlsOfcCd() {
		return this.custSlsOfcCd;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return custSrepCd
	 */
	public String getCustSrepCd() {
		return this.custSrepCd;
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
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param repCustFlg
	 */
	public void setRepCustFlg(String repCustFlg) {
		this.repCustFlg = repCustFlg;
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
	 * @param custValSgmCd
	 */
	public void setCustValSgmCd(String custValSgmCd) {
		this.custValSgmCd = custValSgmCd;
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
	 * @param realCustValSgm
	 */
	public void setRealCustValSgm(String realCustValSgm) {
		this.realCustValSgm = realCustValSgm;
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
	 * @param custLocCd
	 */
	public void setCustLocCd(String custLocCd) {
		this.custLocCd = custLocCd;
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
	 * @param realCustSrepNm
	 */
	public void setRealCustSrepNm(String realCustSrepNm) {
		this.realCustSrepNm = realCustSrepNm;
	}
	
	/**
	 * Column Info
	 * @param prcCtrtCustTpCd
	 */
	public void setPrcCtrtCustTpCd(String prcCtrtCustTpCd) {
		this.prcCtrtCustTpCd = prcCtrtCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param custSlsOfcCd
	 */
	public void setCustSlsOfcCd(String custSlsOfcCd) {
		this.custSlsOfcCd = custSlsOfcCd;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param custSrepCd
	 */
	public void setCustSrepCd(String custSrepCd) {
		this.custSrepCd = custSrepCd;
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
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setRepCustFlg(JSPUtil.getParameter(request, prefix + "rep_cust_flg", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setCustValSgmCd(JSPUtil.getParameter(request, prefix + "cust_val_sgm_cd", ""));
		setRealCustNm(JSPUtil.getParameter(request, prefix + "real_cust_nm", ""));
		setRealCustValSgm(JSPUtil.getParameter(request, prefix + "real_cust_val_sgm", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustLocCd(JSPUtil.getParameter(request, prefix + "cust_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRealCustSrepNm(JSPUtil.getParameter(request, prefix + "real_cust_srep_nm", ""));
		setPrcCtrtCustTpCd(JSPUtil.getParameter(request, prefix + "prc_ctrt_cust_tp_cd", ""));
		setCustSlsOfcCd(JSPUtil.getParameter(request, prefix + "cust_sls_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setCustSrepCd(JSPUtil.getParameter(request, prefix + "cust_srep_cd", ""));
		setRealCustSeq(JSPUtil.getParameter(request, prefix + "real_cust_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRealCustInquiryVO[]
	 */
	public RsltRealCustInquiryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRealCustInquiryVO[]
	 */
	public RsltRealCustInquiryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRealCustInquiryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] repCustFlg = (JSPUtil.getParameter(request, prefix	+ "rep_cust_flg", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] custValSgmCd = (JSPUtil.getParameter(request, prefix	+ "cust_val_sgm_cd", length));
			String[] realCustNm = (JSPUtil.getParameter(request, prefix	+ "real_cust_nm", length));
			String[] realCustValSgm = (JSPUtil.getParameter(request, prefix	+ "real_cust_val_sgm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custLocCd = (JSPUtil.getParameter(request, prefix	+ "cust_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] realCustSrepNm = (JSPUtil.getParameter(request, prefix	+ "real_cust_srep_nm", length));
			String[] prcCtrtCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_ctrt_cust_tp_cd", length));
			String[] custSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "cust_sls_ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] custSrepCd = (JSPUtil.getParameter(request, prefix	+ "cust_srep_cd", length));
			String[] realCustSeq = (JSPUtil.getParameter(request, prefix	+ "real_cust_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRealCustInquiryVO();
				if (repCustFlg[i] != null)
					model.setRepCustFlg(repCustFlg[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (custValSgmCd[i] != null)
					model.setCustValSgmCd(custValSgmCd[i]);
				if (realCustNm[i] != null)
					model.setRealCustNm(realCustNm[i]);
				if (realCustValSgm[i] != null)
					model.setRealCustValSgm(realCustValSgm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custLocCd[i] != null)
					model.setCustLocCd(custLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (realCustSrepNm[i] != null)
					model.setRealCustSrepNm(realCustSrepNm[i]);
				if (prcCtrtCustTpCd[i] != null)
					model.setPrcCtrtCustTpCd(prcCtrtCustTpCd[i]);
				if (custSlsOfcCd[i] != null)
					model.setCustSlsOfcCd(custSlsOfcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (custSrepCd[i] != null)
					model.setCustSrepCd(custSrepCd[i]);
				if (realCustSeq[i] != null)
					model.setRealCustSeq(realCustSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRealCustInquiryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRealCustInquiryVO[]
	 */
	public RsltRealCustInquiryVO[] getRsltRealCustInquiryVOs(){
		RsltRealCustInquiryVO[] vos = (RsltRealCustInquiryVO[])models.toArray(new RsltRealCustInquiryVO[models.size()]);
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
		this.repCustFlg = this.repCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custValSgmCd = this.custValSgmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustNm = this.realCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustValSgm = this.realCustValSgm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLocCd = this.custLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSrepNm = this.realCustSrepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCtrtCustTpCd = this.prcCtrtCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSlsOfcCd = this.custSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSrepCd = this.custSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.realCustSeq = this.realCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
