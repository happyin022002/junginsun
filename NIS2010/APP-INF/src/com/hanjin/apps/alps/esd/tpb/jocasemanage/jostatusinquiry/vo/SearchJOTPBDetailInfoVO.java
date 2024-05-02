/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SearchJOTPBDetailInfoVO.java
*@FileTitle : SearchJOTPBDetailInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.29
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2009.10.29 변종건 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.tpb.jocasemanage.jostatusinquiry.vo;

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
 * @author 변종건
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchJOTPBDetailInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchJOTPBDetailInfoVO> models = new ArrayList<SearchJOTPBDetailInfoVO>();
	
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String sN3ptyNo = null;
	/* Column Info */
	private String n3ptyInvNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrCustDivCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String otsStsNm = null;
	/* Column Info */
	private String rocIn = null;
	/* Column Info */
	private String rocOut = null;
	/* Column Info */
	private String overdue = null;
	/* Column Info */
	private String sN3ptyInvNo = null;
	/* Column Info */
	private String n3ptyNo = null;
	/* Column Info */
	private String trdPartyNm = null;
	/* Column Info */
	private String fileNo = null;
	/* Column Info */
	private String trdPartyVal = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchJOTPBDetailInfoVO() {}

	public SearchJOTPBDetailInfoVO(String ibflag, String pagerows, String n3ptyNo, String n3ptyInvNo, String ofcCd, String otsStsNm, String overdue, String vndrCustDivCd, String trdPartyVal, String trdPartyNm, String csrNo, String rocIn, String rocOut, String fileNo, String sN3ptyNo, String sN3ptyInvNo) {
		this.csrNo = csrNo;
		this.sN3ptyNo = sN3ptyNo;
		this.n3ptyInvNo = n3ptyInvNo;
		this.pagerows = pagerows;
		this.vndrCustDivCd = vndrCustDivCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.otsStsNm = otsStsNm;
		this.rocIn = rocIn;
		this.rocOut = rocOut;
		this.overdue = overdue;
		this.sN3ptyInvNo = sN3ptyInvNo;
		this.n3ptyNo = n3ptyNo;
		this.trdPartyNm = trdPartyNm;
		this.fileNo = fileNo;
		this.trdPartyVal = trdPartyVal;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("s_n3pty_no", getSN3ptyNo());
		this.hashColumns.put("n3pty_inv_no", getN3ptyInvNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vndr_cust_div_cd", getVndrCustDivCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ots_sts_nm", getOtsStsNm());
		this.hashColumns.put("roc_in", getRocIn());
		this.hashColumns.put("roc_out", getRocOut());
		this.hashColumns.put("overdue", getOverdue());
		this.hashColumns.put("s_n3pty_inv_no", getSN3ptyInvNo());
		this.hashColumns.put("n3pty_no", getN3ptyNo());
		this.hashColumns.put("trd_party_nm", getTrdPartyNm());
		this.hashColumns.put("file_no", getFileNo());
		this.hashColumns.put("trd_party_val", getTrdPartyVal());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("s_n3pty_no", "sN3ptyNo");
		this.hashFields.put("n3pty_inv_no", "n3ptyInvNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_cust_div_cd", "vndrCustDivCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ots_sts_nm", "otsStsNm");
		this.hashFields.put("roc_in", "rocIn");
		this.hashFields.put("roc_out", "rocOut");
		this.hashFields.put("overdue", "overdue");
		this.hashFields.put("s_n3pty_inv_no", "sN3ptyInvNo");
		this.hashFields.put("n3pty_no", "n3ptyNo");
		this.hashFields.put("trd_party_nm", "trdPartyNm");
		this.hashFields.put("file_no", "fileNo");
		this.hashFields.put("trd_party_val", "trdPartyVal");
		return this.hashFields;
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
	 * @return sN3ptyNo
	 */
	public String getSN3ptyNo() {
		return this.sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyInvNo
	 */
	public String getN3ptyInvNo() {
		return this.n3ptyInvNo;
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
	 * @return vndrCustDivCd
	 */
	public String getVndrCustDivCd() {
		return this.vndrCustDivCd;
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
	 * @return otsStsNm
	 */
	public String getOtsStsNm() {
		return this.otsStsNm;
	}
	
	/**
	 * Column Info
	 * @return rocIn
	 */
	public String getRocIn() {
		return this.rocIn;
	}
	
	/**
	 * Column Info
	 * @return rocOut
	 */
	public String getRocOut() {
		return this.rocOut;
	}
	
	/**
	 * Column Info
	 * @return overdue
	 */
	public String getOverdue() {
		return this.overdue;
	}
	
	/**
	 * Column Info
	 * @return sN3ptyInvNo
	 */
	public String getSN3ptyInvNo() {
		return this.sN3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @return n3ptyNo
	 */
	public String getN3ptyNo() {
		return this.n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @return trdPartyNm
	 */
	public String getTrdPartyNm() {
		return this.trdPartyNm;
	}
	
	/**
	 * Column Info
	 * @return fileNo
	 */
	public String getFileNo() {
		return this.fileNo;
	}
	
	/**
	 * Column Info
	 * @return trdPartyVal
	 */
	public String getTrdPartyVal() {
		return this.trdPartyVal;
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
	 * @param sN3ptyNo
	 */
	public void setSN3ptyNo(String sN3ptyNo) {
		this.sN3ptyNo = sN3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyInvNo
	 */
	public void setN3ptyInvNo(String n3ptyInvNo) {
		this.n3ptyInvNo = n3ptyInvNo;
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
	 * @param vndrCustDivCd
	 */
	public void setVndrCustDivCd(String vndrCustDivCd) {
		this.vndrCustDivCd = vndrCustDivCd;
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
	 * @param otsStsNm
	 */
	public void setOtsStsNm(String otsStsNm) {
		this.otsStsNm = otsStsNm;
	}
	
	/**
	 * Column Info
	 * @param rocIn
	 */
	public void setRocIn(String rocIn) {
		this.rocIn = rocIn;
	}
	
	/**
	 * Column Info
	 * @param rocOut
	 */
	public void setRocOut(String rocOut) {
		this.rocOut = rocOut;
	}
	
	/**
	 * Column Info
	 * @param overdue
	 */
	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}
	
	/**
	 * Column Info
	 * @param sN3ptyInvNo
	 */
	public void setSN3ptyInvNo(String sN3ptyInvNo) {
		this.sN3ptyInvNo = sN3ptyInvNo;
	}
	
	/**
	 * Column Info
	 * @param n3ptyNo
	 */
	public void setN3ptyNo(String n3ptyNo) {
		this.n3ptyNo = n3ptyNo;
	}
	
	/**
	 * Column Info
	 * @param trdPartyNm
	 */
	public void setTrdPartyNm(String trdPartyNm) {
		this.trdPartyNm = trdPartyNm;
	}
	
	/**
	 * Column Info
	 * @param fileNo
	 */
	public void setFileNo(String fileNo) {
		this.fileNo = fileNo;
	}
	
	/**
	 * Column Info
	 * @param trdPartyVal
	 */
	public void setTrdPartyVal(String trdPartyVal) {
		this.trdPartyVal = trdPartyVal;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCsrNo(JSPUtil.getParameter(request, "csr_no", ""));
		setSN3ptyNo(JSPUtil.getParameter(request, "s_n3pty_no", ""));
		setN3ptyInvNo(JSPUtil.getParameter(request, "n3pty_inv_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setVndrCustDivCd(JSPUtil.getParameter(request, "vndr_cust_div_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setOtsStsNm(JSPUtil.getParameter(request, "ots_sts_nm", ""));
		setRocIn(JSPUtil.getParameter(request, "roc_in", ""));
		setRocOut(JSPUtil.getParameter(request, "roc_out", ""));
		setOverdue(JSPUtil.getParameter(request, "overdue", ""));
		setSN3ptyInvNo(JSPUtil.getParameter(request, "s_n3pty_inv_no", ""));
		setN3ptyNo(JSPUtil.getParameter(request, "n3pty_no", ""));
		setTrdPartyNm(JSPUtil.getParameter(request, "trd_party_nm", ""));
		setFileNo(JSPUtil.getParameter(request, "file_no", ""));
		setTrdPartyVal(JSPUtil.getParameter(request, "trd_party_val", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchJOTPBDetailInfoVO[]
	 */
	public SearchJOTPBDetailInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchJOTPBDetailInfoVO[]
	 */
	public SearchJOTPBDetailInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchJOTPBDetailInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] sN3ptyNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_no", length));
			String[] n3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_inv_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vndrCustDivCd = (JSPUtil.getParameter(request, prefix	+ "vndr_cust_div_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] otsStsNm = (JSPUtil.getParameter(request, prefix	+ "ots_sts_nm", length));
			String[] rocIn = (JSPUtil.getParameter(request, prefix	+ "roc_in", length));
			String[] rocOut = (JSPUtil.getParameter(request, prefix	+ "roc_out", length));
			String[] overdue = (JSPUtil.getParameter(request, prefix	+ "overdue", length));
			String[] sN3ptyInvNo = (JSPUtil.getParameter(request, prefix	+ "s_n3pty_inv_no", length));
			String[] n3ptyNo = (JSPUtil.getParameter(request, prefix	+ "n3pty_no", length));
			String[] trdPartyNm = (JSPUtil.getParameter(request, prefix	+ "trd_party_nm", length));
			String[] fileNo = (JSPUtil.getParameter(request, prefix	+ "file_no", length));
			String[] trdPartyVal = (JSPUtil.getParameter(request, prefix	+ "trd_party_val", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchJOTPBDetailInfoVO();
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (sN3ptyNo[i] != null)
					model.setSN3ptyNo(sN3ptyNo[i]);
				if (n3ptyInvNo[i] != null)
					model.setN3ptyInvNo(n3ptyInvNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vndrCustDivCd[i] != null)
					model.setVndrCustDivCd(vndrCustDivCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (otsStsNm[i] != null)
					model.setOtsStsNm(otsStsNm[i]);
				if (rocIn[i] != null)
					model.setRocIn(rocIn[i]);
				if (rocOut[i] != null)
					model.setRocOut(rocOut[i]);
				if (overdue[i] != null)
					model.setOverdue(overdue[i]);
				if (sN3ptyInvNo[i] != null)
					model.setSN3ptyInvNo(sN3ptyInvNo[i]);
				if (n3ptyNo[i] != null)
					model.setN3ptyNo(n3ptyNo[i]);
				if (trdPartyNm[i] != null)
					model.setTrdPartyNm(trdPartyNm[i]);
				if (fileNo[i] != null)
					model.setFileNo(fileNo[i]);
				if (trdPartyVal[i] != null)
					model.setTrdPartyVal(trdPartyVal[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchJOTpbDetailInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchJOTPBDetailInfoVO[]
	 */
	public SearchJOTPBDetailInfoVO[] getSearchJOTpbDetailInfoVOs(){
		SearchJOTPBDetailInfoVO[] vos = (SearchJOTPBDetailInfoVO[])models.toArray(new SearchJOTPBDetailInfoVO[models.size()]);
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
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyNo = this.sN3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyInvNo = this.n3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCustDivCd = this.vndrCustDivCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsStsNm = this.otsStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rocIn = this.rocIn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rocOut = this.rocOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overdue = this.overdue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sN3ptyInvNo = this.sN3ptyInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyNo = this.n3ptyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyNm = this.trdPartyNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileNo = this.fileNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdPartyVal = this.trdPartyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
