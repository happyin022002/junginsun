/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : APActualInterfaceDetailForBRKGVO.java
*@FileTitle : APActualInterfaceDetailForBRKGVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.22
*@LastModifier : 박성진
*@LastVersion : 1.0
* 2010.07.22 박성진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo;

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
 * @author 박성진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class APActualInterfaceDetailForBRKGVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APActualInterfaceDetailForBRKGVO> models = new ArrayList<APActualInterfaceDetailForBRKGVO>();
	
	/* Column Info */
	private String commProcRsltRsn = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String apOfcCd = null;
	/* Column Info */
	private String brogSeq = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String stsOption = null;
	/* Column Info */
	private String searchDtTo = null;
	/* Column Info */
	private String fwdr = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String vndr = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String actIfCommAmt = null;
	/* Column Info */
	private String ifOption = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String brogBkgRt = null;
	/* Column Info */
	private String searchDtFr = null;
	/* Column Info */
	private String brogRefNo = null;
	/* Column Info */
	private String brogType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public APActualInterfaceDetailForBRKGVO() {}

	public APActualInterfaceDetailForBRKGVO(String ibflag, String pagerows, String commProcRsltRsn, String csrNo, String apOfcCd, String brogSeq, String searchDtTo, String fwdr, String blNo, String vndr, String bkgNo, String actIfCommAmt, String vndrSeq, String searchDtFr, String brogBkgRt, String brogRefNo, String brogType, String stsOption, String ifOption, String bkgStsCd) {
		this.commProcRsltRsn = commProcRsltRsn;
		this.csrNo = csrNo;
		this.apOfcCd = apOfcCd;
		this.brogSeq = brogSeq;
		this.bkgStsCd = bkgStsCd;
		this.stsOption = stsOption;
		this.searchDtTo = searchDtTo;
		this.fwdr = fwdr;
		this.blNo = blNo;
		this.vndr = vndr;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.actIfCommAmt = actIfCommAmt;
		this.ifOption = ifOption;
		this.vndrSeq = vndrSeq;
		this.brogBkgRt = brogBkgRt;
		this.searchDtFr = searchDtFr;
		this.brogRefNo = brogRefNo;
		this.brogType = brogType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("comm_proc_rslt_rsn", getCommProcRsltRsn());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("ap_ofc_cd", getApOfcCd());
		this.hashColumns.put("brog_seq", getBrogSeq());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("sts_option", getStsOption());
		this.hashColumns.put("search_dt_to", getSearchDtTo());
		this.hashColumns.put("fwdr", getFwdr());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("vndr", getVndr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("act_if_comm_amt", getActIfCommAmt());
		this.hashColumns.put("if_option", getIfOption());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("brog_bkg_rt", getBrogBkgRt());
		this.hashColumns.put("search_dt_fr", getSearchDtFr());
		this.hashColumns.put("brog_ref_no", getBrogRefNo());
		this.hashColumns.put("brog_type", getBrogType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("comm_proc_rslt_rsn", "commProcRsltRsn");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ap_ofc_cd", "apOfcCd");
		this.hashFields.put("brog_seq", "brogSeq");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("sts_option", "stsOption");
		this.hashFields.put("search_dt_to", "searchDtTo");
		this.hashFields.put("fwdr", "fwdr");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("vndr", "vndr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("act_if_comm_amt", "actIfCommAmt");
		this.hashFields.put("if_option", "ifOption");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("brog_bkg_rt", "brogBkgRt");
		this.hashFields.put("search_dt_fr", "searchDtFr");
		this.hashFields.put("brog_ref_no", "brogRefNo");
		this.hashFields.put("brog_type", "brogType");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return commProcRsltRsn
	 */
	public String getCommProcRsltRsn() {
		return this.commProcRsltRsn;
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
	 * @return brogSeq
	 */
	public String getBrogSeq() {
		return this.brogSeq;
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
	 * @return stsOption
	 */
	public String getStsOption() {
		return this.stsOption;
	}
	
	/**
	 * Column Info
	 * @return searchDtTo
	 */
	public String getSearchDtTo() {
		return this.searchDtTo;
	}
	
	/**
	 * Column Info
	 * @return fwdr
	 */
	public String getFwdr() {
		return this.fwdr;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return actIfCommAmt
	 */
	public String getActIfCommAmt() {
		return this.actIfCommAmt;
	}
	
	/**
	 * Column Info
	 * @return ifOption
	 */
	public String getIfOption() {
		return this.ifOption;
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
	 * @return brogBkgRt
	 */
	public String getBrogBkgRt() {
		return this.brogBkgRt;
	}
	
	/**
	 * Column Info
	 * @return searchDtFr
	 */
	public String getSearchDtFr() {
		return this.searchDtFr;
	}
	
	/**
	 * Column Info
	 * @return brogRefNo
	 */
	public String getBrogRefNo() {
		return this.brogRefNo;
	}
	
	/**
	 * Column Info
	 * @return brogType
	 */
	public String getBrogType() {
		return this.brogType;
	}
	

	/**
	 * Column Info
	 * @param commProcRsltRsn
	 */
	public void setCommProcRsltRsn(String commProcRsltRsn) {
		this.commProcRsltRsn = commProcRsltRsn;
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
	 * @param brogSeq
	 */
	public void setBrogSeq(String brogSeq) {
		this.brogSeq = brogSeq;
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
	 * @param stsOption
	 */
	public void setStsOption(String stsOption) {
		this.stsOption = stsOption;
	}
	
	/**
	 * Column Info
	 * @param searchDtTo
	 */
	public void setSearchDtTo(String searchDtTo) {
		this.searchDtTo = searchDtTo;
	}
	
	/**
	 * Column Info
	 * @param fwdr
	 */
	public void setFwdr(String fwdr) {
		this.fwdr = fwdr;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param actIfCommAmt
	 */
	public void setActIfCommAmt(String actIfCommAmt) {
		this.actIfCommAmt = actIfCommAmt;
	}
	
	/**
	 * Column Info
	 * @param ifOption
	 */
	public void setIfOption(String ifOption) {
		this.ifOption = ifOption;
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
	 * @param brogBkgRt
	 */
	public void setBrogBkgRt(String brogBkgRt) {
		this.brogBkgRt = brogBkgRt;
	}
	
	/**
	 * Column Info
	 * @param searchDtFr
	 */
	public void setSearchDtFr(String searchDtFr) {
		this.searchDtFr = searchDtFr;
	}
	
	/**
	 * Column Info
	 * @param brogRefNo
	 */
	public void setBrogRefNo(String brogRefNo) {
		this.brogRefNo = brogRefNo;
	}
	
	/**
	 * Column Info
	 * @param brogType
	 */
	public void setBrogType(String brogType) {
		this.brogType = brogType;
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
		setCommProcRsltRsn(JSPUtil.getParameter(request, prefix + "comm_proc_rslt_rsn", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setApOfcCd(JSPUtil.getParameter(request, prefix + "ap_ofc_cd", ""));
		setBrogSeq(JSPUtil.getParameter(request, prefix + "brog_seq", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setStsOption(JSPUtil.getParameter(request, prefix + "sts_option", ""));
		setSearchDtTo(JSPUtil.getParameter(request, prefix + "search_dt_to", ""));
		setFwdr(JSPUtil.getParameter(request, prefix + "fwdr", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setVndr(JSPUtil.getParameter(request, prefix + "vndr", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setActIfCommAmt(JSPUtil.getParameter(request, prefix + "act_if_comm_amt", ""));
		setIfOption(JSPUtil.getParameter(request, prefix + "if_option", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setBrogBkgRt(JSPUtil.getParameter(request, prefix + "brog_bkg_rt", ""));
		setSearchDtFr(JSPUtil.getParameter(request, prefix + "search_dt_fr", ""));
		setBrogRefNo(JSPUtil.getParameter(request, prefix + "brog_ref_no", ""));
		setBrogType(JSPUtil.getParameter(request, prefix + "brog_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APActualInterfaceDetailForBRKGVO[]
	 */
	public APActualInterfaceDetailForBRKGVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APActualInterfaceDetailForBRKGVO[]
	 */
	public APActualInterfaceDetailForBRKGVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APActualInterfaceDetailForBRKGVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] commProcRsltRsn = (JSPUtil.getParameter(request, prefix	+ "comm_proc_rslt_rsn", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] apOfcCd = (JSPUtil.getParameter(request, prefix	+ "ap_ofc_cd", length));
			String[] brogSeq = (JSPUtil.getParameter(request, prefix	+ "brog_seq", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] stsOption = (JSPUtil.getParameter(request, prefix	+ "sts_option", length));
			String[] searchDtTo = (JSPUtil.getParameter(request, prefix	+ "search_dt_to", length));
			String[] fwdr = (JSPUtil.getParameter(request, prefix	+ "fwdr", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] vndr = (JSPUtil.getParameter(request, prefix	+ "vndr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] actIfCommAmt = (JSPUtil.getParameter(request, prefix	+ "act_if_comm_amt", length));
			String[] ifOption = (JSPUtil.getParameter(request, prefix	+ "if_option", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] brogBkgRt = (JSPUtil.getParameter(request, prefix	+ "brog_bkg_rt", length));
			String[] searchDtFr = (JSPUtil.getParameter(request, prefix	+ "search_dt_fr", length));
			String[] brogRefNo = (JSPUtil.getParameter(request, prefix	+ "brog_ref_no", length));
			String[] brogType = (JSPUtil.getParameter(request, prefix	+ "brog_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new APActualInterfaceDetailForBRKGVO();
				if (commProcRsltRsn[i] != null)
					model.setCommProcRsltRsn(commProcRsltRsn[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (apOfcCd[i] != null)
					model.setApOfcCd(apOfcCd[i]);
				if (brogSeq[i] != null)
					model.setBrogSeq(brogSeq[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (stsOption[i] != null)
					model.setStsOption(stsOption[i]);
				if (searchDtTo[i] != null)
					model.setSearchDtTo(searchDtTo[i]);
				if (fwdr[i] != null)
					model.setFwdr(fwdr[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (vndr[i] != null)
					model.setVndr(vndr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (actIfCommAmt[i] != null)
					model.setActIfCommAmt(actIfCommAmt[i]);
				if (ifOption[i] != null)
					model.setIfOption(ifOption[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (brogBkgRt[i] != null)
					model.setBrogBkgRt(brogBkgRt[i]);
				if (searchDtFr[i] != null)
					model.setSearchDtFr(searchDtFr[i]);
				if (brogRefNo[i] != null)
					model.setBrogRefNo(brogRefNo[i]);
				if (brogType[i] != null)
					model.setBrogType(brogType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPActualInterfaceDetailForBRKGVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APActualInterfaceDetailForBRKGVO[]
	 */
	public APActualInterfaceDetailForBRKGVO[] getAPActualInterfaceDetailForBRKGVOs(){
		APActualInterfaceDetailForBRKGVO[] vos = (APActualInterfaceDetailForBRKGVO[])models.toArray(new APActualInterfaceDetailForBRKGVO[models.size()]);
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
		this.commProcRsltRsn = this.commProcRsltRsn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apOfcCd = this.apOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogSeq = this.brogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsOption = this.stsOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtTo = this.searchDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdr = this.fwdr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndr = this.vndr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actIfCommAmt = this.actIfCommAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifOption = this.ifOption .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogBkgRt = this.brogBkgRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchDtFr = this.searchDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogRefNo = this.brogRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogType = this.brogType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
