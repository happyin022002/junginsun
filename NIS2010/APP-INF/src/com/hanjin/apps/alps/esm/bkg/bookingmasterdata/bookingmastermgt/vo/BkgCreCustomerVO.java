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

package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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

public class BkgCreCustomerVO extends AbstractValueObject {

private static final long serialVersionUID = 1L;
	
	private Collection<BkgCreCustomerVO> models = new ArrayList<BkgCreCustomerVO>();
	
	/* Column Info */
	private String phnNo = null;
	/* Column Info */
	private String deltFlg = null;
	/* Column Info */
	private String noUseRsn = null;
	/* Column Info */
	private String arOfc = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String bzetAddr = null;
	/* Column Info */
	private String custRlseCtrlRmk = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String custLglEngNm = null;
	/* Column Info */
	private String locationCode = null;
	/* Column Info */
	private String rBklst = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String frtFwrdFmcNo = null;
	/* Column Info */
	private String zipCd = null;
	/* Column Info */
	private String srepNm = null;
	/* Column Info */
	private String pb = null;
	/* Column Info */
	private String customerCode = null;
	/* Column Info */
	private String ctyNm = null;
	/* Column Info */
	private String custDivFlag = null;
	/* Column Info */
	private String steCd = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public BkgCreCustomerVO() {}

	public BkgCreCustomerVO(String ibflag, String pagerows, String custCntCd, String custSeq, String customerCode, String pb, String custLglEngNm, String custDivFlag, String ofcCd, String bzetAddr, String frtFwrdFmcNo, String deltFlg, String arOfc, String srepNm, String custRlseCtrlRmk, String noUseRsn, String ctyNm, String steCd, String zipCd, String phnNo, String rBklst, String locationCode) {
		this.phnNo = phnNo;
		this.deltFlg = deltFlg;
		this.noUseRsn = noUseRsn;
		this.arOfc = arOfc;
		this.custSeq = custSeq;
		this.bzetAddr = bzetAddr;
		this.custRlseCtrlRmk = custRlseCtrlRmk;
		this.pagerows = pagerows;
		this.custLglEngNm = custLglEngNm;
		this.locationCode = locationCode;
		this.rBklst = rBklst;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.frtFwrdFmcNo = frtFwrdFmcNo;
		this.zipCd = zipCd;
		this.srepNm = srepNm;
		this.pb = pb;
		this.customerCode = customerCode;
		this.ctyNm = ctyNm;
		this.custDivFlag = custDivFlag;
		this.steCd = steCd;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("phn_no", getPhnNo());
		this.hashColumns.put("delt_flg", getDeltFlg());
		this.hashColumns.put("no_use_rsn", getNoUseRsn());
		this.hashColumns.put("ar_ofc", getArOfc());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("bzet_addr", getBzetAddr());
		this.hashColumns.put("cust_rlse_ctrl_rmk", getCustRlseCtrlRmk());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());
		this.hashColumns.put("location_code", getLocationCode());
		this.hashColumns.put("r_bklst", getRBklst());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("frt_fwrd_fmc_no", getFrtFwrdFmcNo());
		this.hashColumns.put("zip_cd", getZipCd());
		this.hashColumns.put("srep_nm", getSrepNm());
		this.hashColumns.put("pb", getPb());
		this.hashColumns.put("customer_code", getCustomerCode());
		this.hashColumns.put("cty_nm", getCtyNm());
		this.hashColumns.put("cust_div_flag", getCustDivFlag());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("phn_no", "phnNo");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("no_use_rsn", "noUseRsn");
		this.hashFields.put("ar_ofc", "arOfc");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("bzet_addr", "bzetAddr");
		this.hashFields.put("cust_rlse_ctrl_rmk", "custRlseCtrlRmk");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("location_code", "locationCode");
		this.hashFields.put("r_bklst", "rBklst");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("frt_fwrd_fmc_no", "frtFwrdFmcNo");
		this.hashFields.put("zip_cd", "zipCd");
		this.hashFields.put("srep_nm", "srepNm");
		this.hashFields.put("pb", "pb");
		this.hashFields.put("customer_code", "customerCode");
		this.hashFields.put("cty_nm", "ctyNm");
		this.hashFields.put("cust_div_flag", "custDivFlag");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return phnNo
	 */
	public String getPhnNo() {
		return this.phnNo;
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
	 * @return noUseRsn
	 */
	public String getNoUseRsn() {
		return this.noUseRsn;
	}
	
	/**
	 * Column Info
	 * @return arOfc
	 */
	public String getArOfc() {
		return this.arOfc;
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
	 * @return bzetAddr
	 */
	public String getBzetAddr() {
		return this.bzetAddr;
	}
	
	/**
	 * Column Info
	 * @return custRlseCtrlRmk
	 */
	public String getCustRlseCtrlRmk() {
		return this.custRlseCtrlRmk;
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
	 * @return custLglEngNm
	 */
	public String getCustLglEngNm() {
		return this.custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @return locationCode
	 */
	public String getLocationCode() {
		return this.locationCode;
	}
	
	/**
	 * Column Info
	 * @return rBklst
	 */
	public String getRBklst() {
		return this.rBklst;
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
	 * @return frtFwrdFmcNo
	 */
	public String getFrtFwrdFmcNo() {
		return this.frtFwrdFmcNo;
	}
	
	/**
	 * Column Info
	 * @return zipCd
	 */
	public String getZipCd() {
		return this.zipCd;
	}
	
	/**
	 * Column Info
	 * @return srepNm
	 */
	public String getSrepNm() {
		return this.srepNm;
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
	 * @return ctyNm
	 */
	public String getCtyNm() {
		return this.ctyNm;
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
	 * @return steCd
	 */
	public String getSteCd() {
		return this.steCd;
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
	 * @param phnNo
	 */
	public void setPhnNo(String phnNo) {
		this.phnNo = phnNo;
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
	 * @param noUseRsn
	 */
	public void setNoUseRsn(String noUseRsn) {
		this.noUseRsn = noUseRsn;
	}
	
	/**
	 * Column Info
	 * @param arOfc
	 */
	public void setArOfc(String arOfc) {
		this.arOfc = arOfc;
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
	 * @param bzetAddr
	 */
	public void setBzetAddr(String bzetAddr) {
		this.bzetAddr = bzetAddr;
	}
	
	/**
	 * Column Info
	 * @param custRlseCtrlRmk
	 */
	public void setCustRlseCtrlRmk(String custRlseCtrlRmk) {
		this.custRlseCtrlRmk = custRlseCtrlRmk;
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
	 * @param custLglEngNm
	 */
	public void setCustLglEngNm(String custLglEngNm) {
		this.custLglEngNm = custLglEngNm;
	}
	
	/**
	 * Column Info
	 * @param locationCode
	 */
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	
	/**
	 * Column Info
	 * @param rBklst
	 */
	public void setRBklst(String rBklst) {
		this.rBklst = rBklst;
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
	 * @param frtFwrdFmcNo
	 */
	public void setFrtFwrdFmcNo(String frtFwrdFmcNo) {
		this.frtFwrdFmcNo = frtFwrdFmcNo;
	}
	
	/**
	 * Column Info
	 * @param zipCd
	 */
	public void setZipCd(String zipCd) {
		this.zipCd = zipCd;
	}
	
	/**
	 * Column Info
	 * @param srepNm
	 */
	public void setSrepNm(String srepNm) {
		this.srepNm = srepNm;
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
	 * @param ctyNm
	 */
	public void setCtyNm(String ctyNm) {
		this.ctyNm = ctyNm;
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
	 * @param steCd
	 */
	public void setSteCd(String steCd) {
		this.steCd = steCd;
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
		setPhnNo(JSPUtil.getParameter(request, prefix + "phn_no", ""));
		setDeltFlg(JSPUtil.getParameter(request, prefix + "delt_flg", ""));
		setNoUseRsn(JSPUtil.getParameter(request, prefix + "no_use_rsn", ""));
		setArOfc(JSPUtil.getParameter(request, prefix + "ar_ofc", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setBzetAddr(JSPUtil.getParameter(request, prefix + "bzet_addr", ""));
		setCustRlseCtrlRmk(JSPUtil.getParameter(request, prefix + "cust_rlse_ctrl_rmk", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCustLglEngNm(JSPUtil.getParameter(request, prefix + "cust_lgl_eng_nm", ""));
		setLocationCode(JSPUtil.getParameter(request, prefix + "location_code", ""));
		setRBklst(JSPUtil.getParameter(request, prefix + "r_bklst", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setFrtFwrdFmcNo(JSPUtil.getParameter(request, prefix + "frt_fwrd_fmc_no", ""));
		setZipCd(JSPUtil.getParameter(request, prefix + "zip_cd", ""));
		setSrepNm(JSPUtil.getParameter(request, prefix + "srep_nm", ""));
		setPb(JSPUtil.getParameter(request, prefix + "pb", ""));
		setCustomerCode(JSPUtil.getParameter(request, prefix + "customer_code", ""));
		setCtyNm(JSPUtil.getParameter(request, prefix + "cty_nm", ""));
		setCustDivFlag(JSPUtil.getParameter(request, prefix + "cust_div_flag", ""));
		setSteCd(JSPUtil.getParameter(request, prefix + "ste_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
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
			String[] phnNo = (JSPUtil.getParameter(request, prefix	+ "phn_no", length));
			String[] deltFlg = (JSPUtil.getParameter(request, prefix	+ "delt_flg", length));
			String[] noUseRsn = (JSPUtil.getParameter(request, prefix	+ "no_use_rsn", length));
			String[] arOfc = (JSPUtil.getParameter(request, prefix	+ "ar_ofc", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] bzetAddr = (JSPUtil.getParameter(request, prefix	+ "bzet_addr", length));
			String[] custRlseCtrlRmk = (JSPUtil.getParameter(request, prefix	+ "cust_rlse_ctrl_rmk", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] custLglEngNm = (JSPUtil.getParameter(request, prefix	+ "cust_lgl_eng_nm", length));
			String[] locationCode = (JSPUtil.getParameter(request, prefix	+ "location_code", length));
			String[] rBklst = (JSPUtil.getParameter(request, prefix	+ "r_bklst", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] frtFwrdFmcNo = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_fmc_no", length));
			String[] zipCd = (JSPUtil.getParameter(request, prefix	+ "zip_cd", length));
			String[] srepNm = (JSPUtil.getParameter(request, prefix	+ "srep_nm", length));
			String[] pb = (JSPUtil.getParameter(request, prefix	+ "pb", length));
			String[] customerCode = (JSPUtil.getParameter(request, prefix	+ "customer_code", length));
			String[] ctyNm = (JSPUtil.getParameter(request, prefix	+ "cty_nm", length));
			String[] custDivFlag = (JSPUtil.getParameter(request, prefix	+ "cust_div_flag", length));
			String[] steCd = (JSPUtil.getParameter(request, prefix	+ "ste_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgCreCustomerVO();
				if (phnNo[i] != null)
					model.setPhnNo(phnNo[i]);
				if (deltFlg[i] != null)
					model.setDeltFlg(deltFlg[i]);
				if (noUseRsn[i] != null)
					model.setNoUseRsn(noUseRsn[i]);
				if (arOfc[i] != null)
					model.setArOfc(arOfc[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (bzetAddr[i] != null)
					model.setBzetAddr(bzetAddr[i]);
				if (custRlseCtrlRmk[i] != null)
					model.setCustRlseCtrlRmk(custRlseCtrlRmk[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (custLglEngNm[i] != null)
					model.setCustLglEngNm(custLglEngNm[i]);
				if (locationCode[i] != null)
					model.setLocationCode(locationCode[i]);
				if (rBklst[i] != null)
					model.setRBklst(rBklst[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (frtFwrdFmcNo[i] != null)
					model.setFrtFwrdFmcNo(frtFwrdFmcNo[i]);
				if (zipCd[i] != null)
					model.setZipCd(zipCd[i]);
				if (srepNm[i] != null)
					model.setSrepNm(srepNm[i]);
				if (pb[i] != null)
					model.setPb(pb[i]);
				if (customerCode[i] != null)
					model.setCustomerCode(customerCode[i]);
				if (ctyNm[i] != null)
					model.setCtyNm(ctyNm[i]);
				if (custDivFlag[i] != null)
					model.setCustDivFlag(custDivFlag[i]);
				if (steCd[i] != null)
					model.setSteCd(steCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
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
		this.phnNo = this.phnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg = this.deltFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noUseRsn = this.noUseRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfc = this.arOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bzetAddr = this.bzetAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRlseCtrlRmk = this.custRlseCtrlRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm = this.custLglEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCode = this.locationCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rBklst = this.rBklst .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdFmcNo = this.frtFwrdFmcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zipCd = this.zipCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepNm = this.srepNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pb = this.pb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerCode = this.customerCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctyNm = this.ctyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custDivFlag = this.custDivFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd = this.steCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
