/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : InvSumDtlVO.java
*@FileTitle : InvSumDtlVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.09
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2010.03.09 정명훈 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.pso.portchargebudget.budgetportchargemgt.vo;

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
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvSumDtlVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvSumDtlVO> models = new ArrayList<InvSumDtlVO>();
	
	/* Column Info */
	private String acctNm = null;
	/* Column Info */
	private String costNm = null;
	/* Column Info */
	private String fomlDesc = null;
	/* Column Info */
	private String soSeq = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String issCtyCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String revDirCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String acctCd = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String csrNo = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String loclAmt = null;
	/* Column Info */
	private String adjAmt = null;
	/* Column Info */
	private String calcAmt = null;
	/* Column Info */
	private String io = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String soDtlSeq = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String xprDesc = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public InvSumDtlVO() {}

	public InvSumDtlVO(String ibflag, String pagerows, String issCtyCd, String soSeq, String soDtlSeq, String rmk, String csrNo, String acctNm, String status, String fomlDesc, String costNm, String loclAmt, String rlaneCd, String calcAmt, String io, String invNo, String vvd, String revDirCd, String usdAmt, String costCd, String acctCd, String xprDesc, String portCd, String vndrSeq, String adjAmt) {
		this.acctNm = acctNm;
		this.costNm = costNm;
		this.fomlDesc = fomlDesc;
		this.soSeq = soSeq;
		this.rlaneCd = rlaneCd;
		this.issCtyCd = issCtyCd;
		this.pagerows = pagerows;
		this.revDirCd = revDirCd;
		this.ibflag = ibflag;
		this.costCd = costCd;
		this.acctCd = acctCd;
		this.portCd = portCd;
		this.rmk = rmk;
		this.csrNo = csrNo;
		this.status = status;
		this.loclAmt = loclAmt;
		this.adjAmt = adjAmt;
		this.calcAmt = calcAmt;
		this.io = io;
		this.invNo = invNo;
		this.vvd = vvd;
		this.usdAmt = usdAmt;
		this.soDtlSeq = soDtlSeq;
		this.vndrSeq = vndrSeq;
		this.xprDesc = xprDesc;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("acct_nm", getAcctNm());
		this.hashColumns.put("cost_nm", getCostNm());
		this.hashColumns.put("foml_desc", getFomlDesc());
		this.hashColumns.put("so_seq", getSoSeq());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("iss_cty_cd", getIssCtyCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rev_dir_cd", getRevDirCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("acct_cd", getAcctCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("csr_no", getCsrNo());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("locl_amt", getLoclAmt());
		this.hashColumns.put("adj_amt", getAdjAmt());
		this.hashColumns.put("calc_amt", getCalcAmt());
		this.hashColumns.put("io", getIo());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("so_dtl_seq", getSoDtlSeq());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("xpr_desc", getXprDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("acct_nm", "acctNm");
		this.hashFields.put("cost_nm", "costNm");
		this.hashFields.put("foml_desc", "fomlDesc");
		this.hashFields.put("so_seq", "soSeq");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("iss_cty_cd", "issCtyCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("status", "status");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("adj_amt", "adjAmt");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("io", "io");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("so_dtl_seq", "soDtlSeq");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("xpr_desc", "xprDesc");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return acctNm
	 */
	public String getAcctNm() {
		return this.acctNm;
	}
	
	/**
	 * Column Info
	 * @return costNm
	 */
	public String getCostNm() {
		return this.costNm;
	}
	
	/**
	 * Column Info
	 * @return fomlDesc
	 */
	public String getFomlDesc() {
		return this.fomlDesc;
	}
	
	/**
	 * Column Info
	 * @return soSeq
	 */
	public String getSoSeq() {
		return this.soSeq;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return issCtyCd
	 */
	public String getIssCtyCd() {
		return this.issCtyCd;
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
	 * @return revDirCd
	 */
	public String getRevDirCd() {
		return this.revDirCd;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return acctCd
	 */
	public String getAcctCd() {
		return this.acctCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
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
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return loclAmt
	 */
	public String getLoclAmt() {
		return this.loclAmt;
	}
	
	/**
	 * Column Info
	 * @return adjAmt
	 */
	public String getAdjAmt() {
		return this.adjAmt;
	}
	
	/**
	 * Column Info
	 * @return calcAmt
	 */
	public String getCalcAmt() {
		return this.calcAmt;
	}
	
	/**
	 * Column Info
	 * @return io
	 */
	public String getIo() {
		return this.io;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return soDtlSeq
	 */
	public String getSoDtlSeq() {
		return this.soDtlSeq;
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
	 * @return xprDesc
	 */
	public String getXprDesc() {
		return this.xprDesc;
	}
	

	/**
	 * Column Info
	 * @param acctNm
	 */
	public void setAcctNm(String acctNm) {
		this.acctNm = acctNm;
	}
	
	/**
	 * Column Info
	 * @param costNm
	 */
	public void setCostNm(String costNm) {
		this.costNm = costNm;
	}
	
	/**
	 * Column Info
	 * @param fomlDesc
	 */
	public void setFomlDesc(String fomlDesc) {
		this.fomlDesc = fomlDesc;
	}
	
	/**
	 * Column Info
	 * @param soSeq
	 */
	public void setSoSeq(String soSeq) {
		this.soSeq = soSeq;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param issCtyCd
	 */
	public void setIssCtyCd(String issCtyCd) {
		this.issCtyCd = issCtyCd;
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
	 * @param revDirCd
	 */
	public void setRevDirCd(String revDirCd) {
		this.revDirCd = revDirCd;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param acctCd
	 */
	public void setAcctCd(String acctCd) {
		this.acctCd = acctCd;
	}
	
	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
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
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param loclAmt
	 */
	public void setLoclAmt(String loclAmt) {
		this.loclAmt = loclAmt;
	}
	
	/**
	 * Column Info
	 * @param adjAmt
	 */
	public void setAdjAmt(String adjAmt) {
		this.adjAmt = adjAmt;
	}
	
	/**
	 * Column Info
	 * @param calcAmt
	 */
	public void setCalcAmt(String calcAmt) {
		this.calcAmt = calcAmt;
	}
	
	/**
	 * Column Info
	 * @param io
	 */
	public void setIo(String io) {
		this.io = io;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param soDtlSeq
	 */
	public void setSoDtlSeq(String soDtlSeq) {
		this.soDtlSeq = soDtlSeq;
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
	 * @param xprDesc
	 */
	public void setXprDesc(String xprDesc) {
		this.xprDesc = xprDesc;
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
		setAcctNm(JSPUtil.getParameter(request, prefix + "acct_nm", ""));
		setCostNm(JSPUtil.getParameter(request, prefix + "cost_nm", ""));
		setFomlDesc(JSPUtil.getParameter(request, prefix + "foml_desc", ""));
		setSoSeq(JSPUtil.getParameter(request, prefix + "so_seq", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setIssCtyCd(JSPUtil.getParameter(request, prefix + "iss_cty_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRevDirCd(JSPUtil.getParameter(request, prefix + "rev_dir_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setAcctCd(JSPUtil.getParameter(request, prefix + "acct_cd", ""));
		setPortCd(JSPUtil.getParameter(request, prefix + "port_cd", ""));
		setRmk(JSPUtil.getParameter(request, prefix + "rmk", ""));
		setCsrNo(JSPUtil.getParameter(request, prefix + "csr_no", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setLoclAmt(JSPUtil.getParameter(request, prefix + "locl_amt", ""));
		setAdjAmt(JSPUtil.getParameter(request, prefix + "adj_amt", ""));
		setCalcAmt(JSPUtil.getParameter(request, prefix + "calc_amt", ""));
		setIo(JSPUtil.getParameter(request, prefix + "io", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setSoDtlSeq(JSPUtil.getParameter(request, prefix + "so_dtl_seq", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setXprDesc(JSPUtil.getParameter(request, prefix + "xpr_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvSumDtlVO[]
	 */
	public InvSumDtlVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvSumDtlVO[]
	 */
	public InvSumDtlVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvSumDtlVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] acctNm = (JSPUtil.getParameter(request, prefix	+ "acct_nm", length));
			String[] costNm = (JSPUtil.getParameter(request, prefix	+ "cost_nm", length));
			String[] fomlDesc = (JSPUtil.getParameter(request, prefix	+ "foml_desc", length));
			String[] soSeq = (JSPUtil.getParameter(request, prefix	+ "so_seq", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] issCtyCd = (JSPUtil.getParameter(request, prefix	+ "iss_cty_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] revDirCd = (JSPUtil.getParameter(request, prefix	+ "rev_dir_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] acctCd = (JSPUtil.getParameter(request, prefix	+ "acct_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] csrNo = (JSPUtil.getParameter(request, prefix	+ "csr_no", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] loclAmt = (JSPUtil.getParameter(request, prefix	+ "locl_amt", length));
			String[] adjAmt = (JSPUtil.getParameter(request, prefix	+ "adj_amt", length));
			String[] calcAmt = (JSPUtil.getParameter(request, prefix	+ "calc_amt", length));
			String[] io = (JSPUtil.getParameter(request, prefix	+ "io", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] soDtlSeq = (JSPUtil.getParameter(request, prefix	+ "so_dtl_seq", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] xprDesc = (JSPUtil.getParameter(request, prefix	+ "xpr_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvSumDtlVO();
				if (acctNm[i] != null)
					model.setAcctNm(acctNm[i]);
				if (costNm[i] != null)
					model.setCostNm(costNm[i]);
				if (fomlDesc[i] != null)
					model.setFomlDesc(fomlDesc[i]);
				if (soSeq[i] != null)
					model.setSoSeq(soSeq[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (issCtyCd[i] != null)
					model.setIssCtyCd(issCtyCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (revDirCd[i] != null)
					model.setRevDirCd(revDirCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (acctCd[i] != null)
					model.setAcctCd(acctCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (csrNo[i] != null)
					model.setCsrNo(csrNo[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (loclAmt[i] != null)
					model.setLoclAmt(loclAmt[i]);
				if (adjAmt[i] != null)
					model.setAdjAmt(adjAmt[i]);
				if (calcAmt[i] != null)
					model.setCalcAmt(calcAmt[i]);
				if (io[i] != null)
					model.setIo(io[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (soDtlSeq[i] != null)
					model.setSoDtlSeq(soDtlSeq[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (xprDesc[i] != null)
					model.setXprDesc(xprDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvSumDtlVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvSumDtlVO[]
	 */
	public InvSumDtlVO[] getInvSumDtlVOs(){
		InvSumDtlVO[] vos = (InvSumDtlVO[])models.toArray(new InvSumDtlVO[models.size()]);
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
		this.acctNm = this.acctNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costNm = this.costNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fomlDesc = this.fomlDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soSeq = this.soSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issCtyCd = this.issCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd = this.revDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd = this.acctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo = this.csrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt = this.loclAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjAmt = this.adjAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt = this.calcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.io = this.io .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soDtlSeq = this.soDtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xprDesc = this.xprDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
