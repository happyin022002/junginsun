/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnApprovalDetailVO.java
*@FileTitle : FFCmpnApprovalDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.08.08
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.08.08 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.acm.acmapproval.ffcmpnapproval.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FFCmpnApprovalDetailVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FFCmpnApprovalDetailVO> models = new ArrayList<FFCmpnApprovalDetailVO>();
	
	/* Column Info */
	private String dateFm = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String ifOpt = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String dateTo = null;
	/* Column Info */
	private String ffBkgRt = null;
	/* Column Info */
	private String hidFfCntSeq = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String ffCntSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ffType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String ffRefNo = null;
	/* Column Info */
	private String ffSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ifAmt = null;
	/* Column Info */
	private String dateDiv = null;
	/* Column Info */
	private String ffCmpnRmk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FFCmpnApprovalDetailVO() {}

	public FFCmpnApprovalDetailVO(String ibflag, String pagerows, String dateFm, String csrNo, String apOfcCd, String ifOpt, String dateTo, String hidFfCntSeq, String dateDiv, String ffCntSeq, String vndrSeq, String bkgNo, String blNo, String ffRefNo, String ifAmt, String ffType, String ffBkgRt, String bkgStsCd, String ffCmpnRmk, String ffSeq) {
		this.dateFm = dateFm;
		this.csrNo = csrNo;
		this.apOfcCd = apOfcCd;
		this.ifOpt = ifOpt;
		this.bkgStsCd = bkgStsCd;
		this.dateTo = dateTo;
		this.ffBkgRt = ffBkgRt;
		this.hidFfCntSeq = hidFfCntSeq;
		this.blNo = blNo;
		this.ffCntSeq = ffCntSeq;
		this.pagerows = pagerows;
		this.ffType = ffType;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.ffRefNo = ffRefNo;
		this.ffSeq = ffSeq;
		this.vndrSeq = vndrSeq;
		this.ifAmt = ifAmt;
		this.dateDiv = dateDiv;
		this.ffCmpnRmk = ffCmpnRmk;
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
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("date_to", getDateTo());
		this.hashColumns.put("ff_bkg_rt", getFfBkgRt());
		this.hashColumns.put("hid_ff_cnt_seq", getHidFfCntSeq());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("ff_cnt_seq", getFfCntSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ff_type", getFfType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ff_ref_no", getFfRefNo());
		this.hashColumns.put("ff_seq", getFfSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("if_amt", getIfAmt());
		this.hashColumns.put("date_div", getDateDiv());
		this.hashColumns.put("ff_cmpn_rmk", getFfCmpnRmk());
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
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("ff_bkg_rt", "ffBkgRt");
		this.hashFields.put("hid_ff_cnt_seq", "hidFfCntSeq");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ff_cnt_seq", "ffCntSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ff_type", "ffType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ff_ref_no", "ffRefNo");
		this.hashFields.put("ff_seq", "ffSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("if_amt", "ifAmt");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("ff_cmpn_rmk", "ffCmpnRmk");
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
	 * @return ffBkgRt
	 */
	public String getFfBkgRt() {
		return this.ffBkgRt;
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
	 * @return ffCntSeq
	 */
	public String getFfCntSeq() {
		return this.ffCntSeq;
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
	 * @return ffType
	 */
	public String getFfType() {
		return this.ffType;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return ffRefNo
	 */
	public String getFfRefNo() {
		return this.ffRefNo;
	}
	
	/**
	 * Column Info
	 * @return ffSeq
	 */
	public String getFfSeq() {
		return this.ffSeq;
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
	 * @return ifAmt
	 */
	public String getIfAmt() {
		return this.ifAmt;
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
	 * @return ffCmpnRmk
	 */
	public String getFfCmpnRmk() {
		return this.ffCmpnRmk;
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
	 * @param ffBkgRt
	 */
	public void setFfBkgRt(String ffBkgRt) {
		this.ffBkgRt = ffBkgRt;
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
	 * @param ffCntSeq
	 */
	public void setFfCntSeq(String ffCntSeq) {
		this.ffCntSeq = ffCntSeq;
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
	 * @param ffType
	 */
	public void setFfType(String ffType) {
		this.ffType = ffType;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param ffRefNo
	 */
	public void setFfRefNo(String ffRefNo) {
		this.ffRefNo = ffRefNo;
	}
	
	/**
	 * Column Info
	 * @param ffSeq
	 */
	public void setFfSeq(String ffSeq) {
		this.ffSeq = ffSeq;
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
	 * @param ifAmt
	 */
	public void setIfAmt(String ifAmt) {
		this.ifAmt = ifAmt;
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
	 * @param ffCmpnRmk
	 */
	public void setFfCmpnRmk(String ffCmpnRmk) {
		this.ffCmpnRmk = ffCmpnRmk;
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
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setDateTo(JSPUtil.getParameter(request, prefix + "date_to", ""));
		setFfBkgRt(JSPUtil.getParameter(request, prefix + "ff_bkg_rt", ""));
		setHidFfCntSeq(JSPUtil.getParameter(request, prefix + "hid_ff_cnt_seq", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setFfCntSeq(JSPUtil.getParameter(request, prefix + "ff_cnt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFfType(JSPUtil.getParameter(request, prefix + "ff_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setFfRefNo(JSPUtil.getParameter(request, prefix + "ff_ref_no", ""));
		setFfSeq(JSPUtil.getParameter(request, prefix + "ff_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setIfAmt(JSPUtil.getParameter(request, prefix + "if_amt", ""));
		setDateDiv(JSPUtil.getParameter(request, prefix + "date_div", ""));
		setFfCmpnRmk(JSPUtil.getParameter(request, prefix + "ff_cmpn_rmk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FFCmpnApprovalDetailVO[]
	 */
	public FFCmpnApprovalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FFCmpnApprovalDetailVO[]
	 */
	public FFCmpnApprovalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FFCmpnApprovalDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dateFm = (JSPUtil.getParameter(request, prefix	+ "date_fm", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] ifOpt = (JSPUtil.getParameter(request, prefix	+ "if_opt", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] dateTo = (JSPUtil.getParameter(request, prefix	+ "date_to", length));
			String[] ffBkgRt = (JSPUtil.getParameter(request, prefix	+ "ff_bkg_rt", length));
			String[] hidFfCntSeq = (JSPUtil.getParameter(request, prefix	+ "hid_ff_cnt_seq", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] ffCntSeq = (JSPUtil.getParameter(request, prefix	+ "ff_cnt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ffType = (JSPUtil.getParameter(request, prefix	+ "ff_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ffRefNo = (JSPUtil.getParameter(request, prefix	+ "ff_ref_no", length));
			String[] ffSeq = (JSPUtil.getParameter(request, prefix	+ "ff_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ifAmt = (JSPUtil.getParameter(request, prefix	+ "if_amt", length));
			String[] dateDiv = (JSPUtil.getParameter(request, prefix	+ "date_div", length));
			String[] ffCmpnRmk = (JSPUtil.getParameter(request, prefix	+ "ff_cmpn_rmk", length));
			
			for (int i = 0; i < length; i++) {
				model = new FFCmpnApprovalDetailVO();
				if (dateFm[i] != null)
					model.setDateFm(dateFm[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (ifOpt[i] != null)
					model.setIfOpt(ifOpt[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (dateTo[i] != null)
					model.setDateTo(dateTo[i]);
				if (ffBkgRt[i] != null)
					model.setFfBkgRt(ffBkgRt[i]);
				if (hidFfCntSeq[i] != null)
					model.setHidFfCntSeq(hidFfCntSeq[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (ffCntSeq[i] != null)
					model.setFfCntSeq(ffCntSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ffType[i] != null)
					model.setFfType(ffType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ffRefNo[i] != null)
					model.setFfRefNo(ffRefNo[i]);
				if (ffSeq[i] != null)
					model.setFfSeq(ffSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ifAmt[i] != null)
					model.setIfAmt(ifAmt[i]);
				if (dateDiv[i] != null)
					model.setDateDiv(dateDiv[i]);
				if (ffCmpnRmk[i] != null)
					model.setFfCmpnRmk(ffCmpnRmk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFFCmpnApprovalDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FFCmpnApprovalDetailVO[]
	 */
	public FFCmpnApprovalDetailVO[] getFFCmpnApprovalDetailVOs(){
		FFCmpnApprovalDetailVO[] vos = (FFCmpnApprovalDetailVO[])models.toArray(new FFCmpnApprovalDetailVO[models.size()]);
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
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo = this.dateTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffBkgRt = this.ffBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFfCntSeq = this.hidFfCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCntSeq = this.ffCntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffType = this.ffType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffRefNo = this.ffRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffSeq = this.ffSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifAmt = this.ifAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv = this.dateDiv .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffCmpnRmk = this.ffCmpnRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
