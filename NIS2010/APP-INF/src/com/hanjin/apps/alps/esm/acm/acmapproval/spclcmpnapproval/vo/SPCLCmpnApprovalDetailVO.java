/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnApprovalDetailVO.java
*@FileTitle : SPCLCmpnApprovalDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.16
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.16 김영오 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmapproval.spclcmpnapproval.vo;

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
 * @author 김영오
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SPCLCmpnApprovalDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SPCLCmpnApprovalDetailVO> models = new ArrayList<SPCLCmpnApprovalDetailVO>();
	
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String ifOpt = null;
	/* Column Info */
	private String spclCmpnRmk = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String spclCmpnSeq = null;
	/* Column Info */
	private String hidFfCntSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String vndr = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String custCntSeq = null;
	/* Column Info */
	private String cmpnType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String spclBkgRt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SPCLCmpnApprovalDetailVO() {}

	public SPCLCmpnApprovalDetailVO(String ibflag, String pagerows, String dateFm, String csrNo, String apOfcCd, String arOfcCd, String ifOpt, String spclCmpnRmk, String bkgStsCd, String dateTo, String spclCmpnSeq, String hidFfCntSeq, String blNo, String vndr, String cmpnType, String custCntSeq, String bkgNo, String vndrSeq, String ifAmt, String dateDiv, String spclBkgRt) {
		this.dateFm = dateFm;
		this.csrNo = csrNo;
		this.apOfcCd = apOfcCd;
		this.ifOpt = ifOpt;
		this.spclCmpnRmk = spclCmpnRmk;
		this.bkgStsCd = bkgStsCd;
		this.dateTo = dateTo;
		this.spclCmpnSeq = spclCmpnSeq;
		this.hidFfCntSeq = hidFfCntSeq;
		this.blNo = blNo;
		this.vndr = vndr;
		this.arOfcCd = arOfcCd;
		this.custCntSeq = custCntSeq;
		this.cmpnType = cmpnType;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.vndrSeq = vndrSeq;
		this.dateDiv = dateDiv;
		this.ifAmt = ifAmt;
		this.spclBkgRt = spclBkgRt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("date_fm", getDateFm());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("if_opt", getIfOpt());
		this.hashColumns.put("spcl_cmpn_rmk", getSpclCmpnRmk());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("spcl_cmpn_seq", getSpclCmpnSeq());
		this.hashColumns.put("hid_ff_cnt_seq", getHidFfCntSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("vndr", getVndr());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("cust_cnt_seq", getCustCntSeq());
		this.hashColumns.put("cmpn_type", getCmpnType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("spcl_bkg_rt", getSpclBkgRt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("if_opt", "ifOpt");
		this.hashFields.put("spcl_cmpn_rmk", "spclCmpnRmk");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("spcl_cmpn_seq", "spclCmpnSeq");
		this.hashFields.put("hid_ff_cnt_seq", "hidFfCntSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("vndr", "vndr");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cust_cnt_seq", "custCntSeq");
		this.hashFields.put("cmpn_type", "cmpnType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("spcl_bkg_rt", "spclBkgRt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dateFm
	 */
	public String getDateFm() {
		return this.dateFm;
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
	 * @return apOfcCd
	 */
	public String getApOfcCd() {
		return this.apOfcCd;
	}
	
	/**
	 * Column Info
	 * @return ifOpt
	 */
	public String getIfOpt() {
		return this.ifOpt;
	}
	
	/**
	 * Column Info
	 * @return spclCmpnRmk
	 */
	public String getSpclCmpnRmk() {
		return this.spclCmpnRmk;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return dateTo
	 */
	public String getDateTo() {
		return this.dateTo;
	}
	
	/**
	 * Column Info
	 * @return spclCmpnSeq
	 */
	public String getSpclCmpnSeq() {
		return this.spclCmpnSeq;
	}
	
	/**
	 * Column Info
	 * @return hidFfCntSeq
	 */
	public String getHidFfCntSeq() {
		return this.hidFfCntSeq;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
	 * @return vndr
	 */
	public String getVndr() {
		return this.vndr;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custCntSeq
	 */
	public String getCustCntSeq() {
		return this.custCntSeq;
	}
	
	/**
	 * Column Info
	 * @return cmpnType
	 */
	public String getCmpnType() {
		return this.cmpnType;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return dateDiv
	 */
	public String getDateDiv() {
		return this.dateDiv;
	}
	
	/**
	 * Column Info
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
	}
	
	/**
	 * Column Info
	 * @return spclBkgRt
	 */
	public String getSpclBkgRt() {
		return this.spclBkgRt;
	}
	

	/**
	 * Column Info
	 * @param dateFm
	 */
	public void setDateFm(String dateFm) {
		this.dateFm = dateFm;
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
	 * @param apOfcCd
	 */
	public void setApOfcCd(String apOfcCd) {
		this.apOfcCd = apOfcCd;
	}
	
	/**
	 * Column Info
	 * @param ifOpt
	 */
	public void setIfOpt(String ifOpt) {
		this.ifOpt = ifOpt;
	}
	
	/**
	 * Column Info
	 * @param spclCmpnRmk
	 */
	public void setSpclCmpnRmk(String spclCmpnRmk) {
		this.spclCmpnRmk = spclCmpnRmk;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	
	/**
	 * Column Info
	 * @param spclCmpnSeq
	 */
	public void setSpclCmpnSeq(String spclCmpnSeq) {
		this.spclCmpnSeq = spclCmpnSeq;
	}
	
	/**
	 * Column Info
	 * @param hidFfCntSeq
	 */
	public void setHidFfCntSeq(String hidFfCntSeq) {
		this.hidFfCntSeq = hidFfCntSeq;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
	 * @param vndr
	 */
	public void setVndr(String vndr) {
		this.vndr = vndr;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custCntSeq
	 */
	public void setCustCntSeq(String custCntSeq) {
		this.custCntSeq = custCntSeq;
	}
	
	/**
	 * Column Info
	 * @param cmpnType
	 */
	public void setCmpnType(String cmpnType) {
		this.cmpnType = cmpnType;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param dateDiv
	 */
	public void setDateDiv(String dateDiv) {
		this.dateDiv = dateDiv;
	}
	
	/**
	 * Column Info
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
	}
	
	/**
	 * Column Info
	 * @param spclBkgRt
	 */
	public void setSpclBkgRt(String spclBkgRt) {
		this.spclBkgRt = spclBkgRt;
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
		setDateFm(JSPUtil.getParameter(request, prefix + "date_fm", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setIfOpt(JSPUtil.getParameter(request, prefix + "if_opt", ""));
		setSpclCmpnRmk(JSPUtil.getParameter(request, prefix + "spcl_cmpn_rmk", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setSpclCmpnSeq(JSPUtil.getParameter(request, prefix + "spcl_cmpn_seq", ""));
		setHidFfCntSeq(JSPUtil.getParameter(request, prefix + "hid_ff_cnt_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setVndr(JSPUtil.getParameter(request, prefix + "vndr", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setCustCntSeq(JSPUtil.getParameter(request, prefix + "cust_cnt_seq", ""));
		setCmpnType(JSPUtil.getParameter(request, prefix + "cmpn_type", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setSpclBkgRt(JSPUtil.getParameter(request, prefix + "spcl_bkg_rt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SPCLCmpnApprovalDetailVO[]
	 */
	public SPCLCmpnApprovalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SPCLCmpnApprovalDetailVO[]
	 */
	public SPCLCmpnApprovalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SPCLCmpnApprovalDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] ifOpt = (JSPUtil.getParameter(request, prefix	+ "if_opt", length));
			String[] spclCmpnRmk = (JSPUtil.getParameter(request, prefix	+ "spcl_cmpn_rmk", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] spclCmpnSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cmpn_seq", length));
			String[] hidFfCntSeq = (JSPUtil.getParameter(request, prefix	+ "hid_ff_cnt_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] vndr = (JSPUtil.getParameter(request, prefix	+ "vndr", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] custCntSeq = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_seq", length));
			String[] cmpnType = (JSPUtil.getParameter(request, prefix	+ "cmpn_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] spclBkgRt = (JSPUtil.getParameter(request, prefix	+ "spcl_bkg_rt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SPCLCmpnApprovalDetailVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (ifOpt[i] != null)
					model.setIfOpt(ifOpt[i]);
				if (spclCmpnRmk[i] != null)
					model.setSpclCmpnRmk(spclCmpnRmk[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (spclCmpnSeq[i] != null)
					model.setSpclCmpnSeq(spclCmpnSeq[i]);
				if (hidFfCntSeq[i] != null)
					model.setHidFfCntSeq(hidFfCntSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (vndr[i] != null)
					model.setVndr(vndr[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (custCntSeq[i] != null)
					model.setCustCntSeq(custCntSeq[i]);
				if (cmpnType[i] != null)
					model.setCmpnType(cmpnType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (spclBkgRt[i] != null)
					model.setSpclBkgRt(spclBkgRt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSPCLCmpnApprovalDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SPCLCmpnApprovalDetailVO[]
	 */
	public SPCLCmpnApprovalDetailVO[] getSPCLCmpnApprovalDetailVOs(){
		SPCLCmpnApprovalDetailVO[] vos = (SPCLCmpnApprovalDetailVO[])models.toArray(new SPCLCmpnApprovalDetailVO[models.size()]);
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
		this.dateFm = this.dateFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOpt = this.ifOpt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCmpnRmk = this.spclCmpnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCmpnSeq = this.spclCmpnSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFfCntSeq = this.hidFfCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr = this.vndr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntSeq = this.custCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpnType = this.cmpnType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclBkgRt = this.spclBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
