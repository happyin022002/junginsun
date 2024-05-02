/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCreCustomerVO.java
*@FileTitle : BkgCreCustomerVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.05  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

import java.lang.reflect.Field;
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

public class BkgCreCustomerVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgCreCustomerVO> models = new ArrayList<BkgCreCustomerVO>();
	
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String frtFwrdFmcNo = null;
	/* Column Info */
	private String pb = null;
	/* Column Info */
	private String customerCode = null;
	/* Column Info */
	private String custDivFlag = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String locCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgCreCustomerVO() {}

	public BkgCreCustomerVO(String ibflag, String pagerows, String custCntCd, String custSeq, String customerCode, String pb, String custLglEngNm, String custDivFlag, String ofcCd, String bzetAddr, String frtFwrdFmcNo, String deltFlg, String locCd) {
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.deltFlg = deltFlg;
		this.frtFwrdFmcNo = frtFwrdFmcNo;
		this.pb = pb;
		this.customerCode = customerCode;
		this.custDivFlag = custDivFlag;
		this.bzetAddr = bzetAddr;
		this.custSeq = custSeq;
		this.custCntCd = custCntCd;
		this.custLglEngNm = custLglEngNm;
		this.locCd = locCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("frt_fwrd_fmc_no", getFrtFwrdFmcNo());
		this.hashColumns.put("pb", getPb());
		this.hashColumns.put("customer_code", getCustomerCode());
		this.hashColumns.put("cust_div_flag", getCustDivFlag());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("frt_fwrd_fmc_no", "frtFwrdFmcNo");
		this.hashFields.put("pb", "pb");
		this.hashFields.put("customer_code", "customerCode");
		this.hashFields.put("cust_div_flag", "custDivFlag");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return deltFlg
	 */
	public String getDeltFlg() {
		return this.deltFlg;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdFmcNo
	 */
	public String getFrtFwrdFmcNo() {
		return this.frtFwrdFmcNo;
	}
	
	/**
	 * Column Info
	 * @return pb
	 */
	public String getPb() {
		return this.pb;
	}
	
	/**
	 * Column Info
	 * @return customerCode
	 */
	public String getCustomerCode() {
		return this.customerCode;
	}
	
	/**
	 * Column Info
	 * @return custDivFlag
	 */
	public String getCustDivFlag() {
		return this.custDivFlag;
	}
	
	/**
	 * Column Info
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
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
	 * Column Info
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param deltFlg
	 */
	public void setDeltFlg(String deltFlg) {
		this.deltFlg = deltFlg;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdFmcNo
	 */
	public void setFrtFwrdFmcNo(String frtFwrdFmcNo) {
		this.frtFwrdFmcNo = frtFwrdFmcNo;
	}
	
	/**
	 * Column Info
	 * @param pb
	 */
	public void setPb(String pb) {
		this.pb = pb;
	}
	
	/**
	 * Column Info
	 * @param customerCode
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}
	
	/**
	 * Column Info
	 * @param custDivFlag
	 */
	public void setCustDivFlag(String custDivFlag) {
		this.custDivFlag = custDivFlag;
	}
	
	/**
	 * Column Info
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
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
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param custLglEngNm
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setFrtFwrdFmcNo(JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", ""));
		setPb(JSPUtil.getParameter(request, prefix + "pb", ""));
		setCustomerCode(JSPUtil.getParameter(request, prefix + "customer_code", ""));
		setCustDivFlag(JSPUtil.getParameter(request, prefix + "cust_div_flag", ""));
		setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgCreCustomerVO[]
	 */
	public BkgCreCustomerVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgCreCustomerVO[]
	 */
	public BkgCreCustomerVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgCreCustomerVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] frtFwrdFmcNo = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_fmc_no", length));
			String[] pb = (JSPUtil.getParameter(request, prefix	+ "pb", length));
			String[] customerCode = (JSPUtil.getParameter(request, prefix	+ "customer_code", length));
			String[] custDivFlag = (JSPUtil.getParameter(request, prefix	+ "cust_div_flag", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCreCustomerVO();
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (frtFwrdFmcNo[i] != null)
					model.setFrtFwrdFmcNo(frtFwrdFmcNo[i]);
				if (pb[i] != null)
					model.setPb(pb[i]);
				if (customerCode[i] != null)
					model.setCustomerCode(customerCode[i]);
				if (custDivFlag[i] != null)
					model.setCustDivFlag(custDivFlag[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgCreCustomerVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgCreCustomerVO[]
	 */
	public BkgCreCustomerVO[] getBkgCreCustomerVOs(){
		BkgCreCustomerVO[] vos = (BkgCreCustomerVO[])models.toArray(new BkgCreCustomerVO[models.size()]);
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
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdFmcNo = this.frtFwrdFmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pb = this.pb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCode = this.customerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custDivFlag = this.custDivFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
