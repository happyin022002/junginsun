/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ARInvoiceHistoryByBLNoVO.java
*@FileTitle : ARInvoiceHistoryByBLNoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.16
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.12.16 박정진 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ARInvoiceHistoryByBLNoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ARInvoiceHistoryByBLNoVO> models = new ArrayList<ARInvoiceHistoryByBLNoVO>();
	
	/* Column Info */
	private String blInvIfDt = null;
	/* Column Info */
	private String localTotal = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String arIfNoInvSplitCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invSplitCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String dpPrcsKnt = null;
	/* Column Info */
	private String blInvCfmDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String revType = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String chgAmt = null;
	/* Column Info */
	private String dpPrcsKntLocal = null;
	/* Column Info */
	private String invClrFlg = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String custCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ARInvoiceHistoryByBLNoVO() {}

	public ARInvoiceHistoryByBLNoVO(String ibflag, String pagerows, String arIfNo, String invSplitCd, String arIfNoInvSplitCd, String revType, String blInvIfDt, String blInvCfmDt, String invNo, String currCd, String chgAmt, String dpPrcsKnt, String invXchRt, String localTotal, String dpPrcsKntLocal, String invClrFlg, String vvd, String custCd) {
		this.blInvIfDt = blInvIfDt;
		this.localTotal = localTotal;
		this.currCd = currCd;
		this.arIfNoInvSplitCd = arIfNoInvSplitCd;
		this.pagerows = pagerows;
		this.invSplitCd = invSplitCd;
		this.invNo = invNo;
		this.dpPrcsKnt = dpPrcsKnt;
		this.blInvCfmDt = blInvCfmDt;
		this.ibflag = ibflag;
		this.revType = revType;
		this.arIfNo = arIfNo;
		this.chgAmt = chgAmt;
		this.dpPrcsKntLocal = dpPrcsKntLocal;
		this.invClrFlg = invClrFlg;
		this.invXchRt = invXchRt;
		this.vvd = vvd;
		this.custCd = custCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_inv_if_dt", getBlInvIfDt());
		this.hashColumns.put("local_total", getLocalTotal());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("ar_if_no_inv_split_cd", getArIfNoInvSplitCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_split_cd", getInvSplitCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rev_type", getRevType());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("chg_amt", getChgAmt());
		this.hashColumns.put("dp_prcs_knt_local", getDpPrcsKntLocal());
		this.hashColumns.put("inv_clr_flg", getInvClrFlg());
		this.hashColumns.put("inv_xch_rt", getInvXchRt());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cust_cd", getCustCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bl_inv_if_dt", "blInvIfDt");
		this.hashFields.put("local_total", "localTotal");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ar_if_no_inv_split_cd", "arIfNoInvSplitCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_split_cd", "invSplitCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_type", "revType");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("dp_prcs_knt_local", "dpPrcsKntLocal");
		this.hashFields.put("inv_clr_flg", "invClrFlg");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cust_cd", "custCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return blInvIfDt
	 */
	public String getBlInvIfDt() {
		return this.blInvIfDt;
	}
	
	/**
	 * Column Info
	 * @return localTotal
	 */
	public String getLocalTotal() {
		return this.localTotal;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return arIfNoInvSplitCd
	 */
	public String getArIfNoInvSplitCd() {
		return this.arIfNoInvSplitCd;
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
	 * @return invSplitCd
	 */
	public String getInvSplitCd() {
		return this.invSplitCd;
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
	 * @return dpPrcsKnt
	 */
	public String getDpPrcsKnt() {
		return this.dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @return blInvCfmDt
	 */
	public String getBlInvCfmDt() {
		return this.blInvCfmDt;
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
	 * @return revType
	 */
	public String getRevType() {
		return this.revType;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
	}
	
	/**
	 * Column Info
	 * @return chgAmt
	 */
	public String getChgAmt() {
		return this.chgAmt;
	}
	
	/**
	 * Column Info
	 * @return dpPrcsKntLocal
	 */
	public String getDpPrcsKntLocal() {
		return this.dpPrcsKntLocal;
	}
	
	/**
	 * Column Info
	 * @return invClrFlg
	 */
	public String getInvClrFlg() {
		return this.invClrFlg;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	

	/**
	 * Column Info
	 * @param blInvIfDt
	 */
	public void setBlInvIfDt(String blInvIfDt) {
		this.blInvIfDt = blInvIfDt;
	}
	
	/**
	 * Column Info
	 * @param localTotal
	 */
	public void setLocalTotal(String localTotal) {
		this.localTotal = localTotal;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param arIfNoInvSplitCd
	 */
	public void setArIfNoInvSplitCd(String arIfNoInvSplitCd) {
		this.arIfNoInvSplitCd = arIfNoInvSplitCd;
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
	 * @param invSplitCd
	 */
	public void setInvSplitCd(String invSplitCd) {
		this.invSplitCd = invSplitCd;
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
	 * @param dpPrcsKnt
	 */
	public void setDpPrcsKnt(String dpPrcsKnt) {
		this.dpPrcsKnt = dpPrcsKnt;
	}
	
	/**
	 * Column Info
	 * @param blInvCfmDt
	 */
	public void setBlInvCfmDt(String blInvCfmDt) {
		this.blInvCfmDt = blInvCfmDt;
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
	 * @param revType
	 */
	public void setRevType(String revType) {
		this.revType = revType;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
	}
	
	/**
	 * Column Info
	 * @param chgAmt
	 */
	public void setChgAmt(String chgAmt) {
		this.chgAmt = chgAmt;
	}
	
	/**
	 * Column Info
	 * @param dpPrcsKntLocal
	 */
	public void setDpPrcsKntLocal(String dpPrcsKntLocal) {
		this.dpPrcsKntLocal = dpPrcsKntLocal;
	}
	
	/**
	 * Column Info
	 * @param invClrFlg
	 */
	public void setInvClrFlg(String invClrFlg) {
		this.invClrFlg = invClrFlg;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	public String getVvd() {
		return vvd;
	}

	public void setVvd(String vvd) {
		this.vvd = vvd;
	}

	public String getCustCd() {
		return custCd;
	}

	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBlInvIfDt(JSPUtil.getParameter(request, "bl_inv_if_dt", ""));
		setLocalTotal(JSPUtil.getParameter(request, "local_total", ""));
		setCurrCd(JSPUtil.getParameter(request, "curr_cd", ""));
		setArIfNoInvSplitCd(JSPUtil.getParameter(request, "ar_if_no_inv_split_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setInvSplitCd(JSPUtil.getParameter(request, "inv_split_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request, "dp_prcs_knt", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request, "bl_inv_cfm_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setRevType(JSPUtil.getParameter(request, "rev_type", ""));
		setArIfNo(JSPUtil.getParameter(request, "ar_if_no", ""));
		setChgAmt(JSPUtil.getParameter(request, "chg_amt", ""));
		setDpPrcsKntLocal(JSPUtil.getParameter(request, "dp_prcs_knt_local", ""));
		setInvClrFlg(JSPUtil.getParameter(request, "inv_clr_flg", ""));
		setInvXchRt(JSPUtil.getParameter(request, "inv_xch_rt", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceHistoryByBLNoVO[]
	 */
	public ARInvoiceHistoryByBLNoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ARInvoiceHistoryByBLNoVO[]
	 */
	public ARInvoiceHistoryByBLNoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ARInvoiceHistoryByBLNoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] blInvIfDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_if_dt", length));
			String[] localTotal = (JSPUtil.getParameter(request, prefix	+ "local_total", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] arIfNoInvSplitCd = (JSPUtil.getParameter(request, prefix	+ "ar_if_no_inv_split_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invSplitCd = (JSPUtil.getParameter(request, prefix	+ "inv_split_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] dpPrcsKnt = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt", length));
			String[] blInvCfmDt = (JSPUtil.getParameter(request, prefix	+ "bl_inv_cfm_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] revType = (JSPUtil.getParameter(request, prefix	+ "rev_type", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] chgAmt = (JSPUtil.getParameter(request, prefix	+ "chg_amt", length));
			String[] dpPrcsKntLocal = (JSPUtil.getParameter(request, prefix	+ "dp_prcs_knt_local", length));
			String[] invClrFlg = (JSPUtil.getParameter(request, prefix	+ "inv_clr_flg", length));
			String[] invXchRt = (JSPUtil.getParameter(request, prefix	+ "inv_xch_rt", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ARInvoiceHistoryByBLNoVO();
				if (blInvIfDt[i] != null)
					model.setBlInvIfDt(blInvIfDt[i]);
				if (localTotal[i] != null)
					model.setLocalTotal(localTotal[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (arIfNoInvSplitCd[i] != null)
					model.setArIfNoInvSplitCd(arIfNoInvSplitCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invSplitCd[i] != null)
					model.setInvSplitCd(invSplitCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (dpPrcsKnt[i] != null)
					model.setDpPrcsKnt(dpPrcsKnt[i]);
				if (blInvCfmDt[i] != null)
					model.setBlInvCfmDt(blInvCfmDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (revType[i] != null)
					model.setRevType(revType[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (chgAmt[i] != null)
					model.setChgAmt(chgAmt[i]);
				if (dpPrcsKntLocal[i] != null)
					model.setDpPrcsKntLocal(dpPrcsKntLocal[i]);
				if (invClrFlg[i] != null)
					model.setInvClrFlg(invClrFlg[i]);
				if (invXchRt[i] != null)
					model.setInvXchRt(invXchRt[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getARInvoiceHistoryByBLNoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ARInvoiceHistoryByBLNoVO[]
	 */
	public ARInvoiceHistoryByBLNoVO[] getARInvoiceHistoryByBLNoVOs(){
		ARInvoiceHistoryByBLNoVO[] vos = (ARInvoiceHistoryByBLNoVO[])models.toArray(new ARInvoiceHistoryByBLNoVO[models.size()]);
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
		this.blInvIfDt = this.blInvIfDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTotal = this.localTotal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNoInvSplitCd = this.arIfNoInvSplitCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSplitCd = this.invSplitCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt = this.dpPrcsKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt = this.blInvCfmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revType = this.revType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt = this.chgAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKntLocal = this.dpPrcsKntLocal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invClrFlg = this.invClrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt = this.invXchRt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
