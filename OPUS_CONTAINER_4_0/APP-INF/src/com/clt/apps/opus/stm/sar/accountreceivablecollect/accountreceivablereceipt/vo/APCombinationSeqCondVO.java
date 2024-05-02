/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : APCombinationSeqCondVO.java
*@FileTitle : APCombinationSeqCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.05.23
*@LastModifier : 
*@LastVersion : 1.0
* 2014.05.23  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class APCombinationSeqCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<APCombinationSeqCondVO> models = new ArrayList<APCombinationSeqCondVO>();
	
	/* Column Info */
	private String rcvCdCmbSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String clrAcctCd = null;
	/* Column Info */
	private String apIfTblTpCd = null;
	/* Column Info */
	private String acctCtnt3 = null;
	/* Column Info */
	private String payAcctCd = null;
	/* Column Info */
	private String interCoCd = null;
	/* Column Info */
	private String apCtrCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public APCombinationSeqCondVO() {}

	public APCombinationSeqCondVO(String ibflag, String pagerows, String apCtrCd, String apIfTblTpCd, String payAcctCd, String clrAcctCd, String interCoCd, String rcvCdCmbSeq, String acctCtnt3) {
		this.rcvCdCmbSeq = rcvCdCmbSeq;
		this.ibflag = ibflag;
		this.clrAcctCd = clrAcctCd;
		this.apIfTblTpCd = apIfTblTpCd;
		this.acctCtnt3 = acctCtnt3;
		this.payAcctCd = payAcctCd;
		this.interCoCd = interCoCd;
		this.apCtrCd = apCtrCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rcv_cd_cmb_seq", getRcvCdCmbSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("clr_acct_cd", getClrAcctCd());
		this.hashColumns.put("ap_if_tbl_tp_cd", getApIfTblTpCd());
		this.hashColumns.put("acct_ctnt3", getAcctCtnt3());
		this.hashColumns.put("pay_acct_cd", getPayAcctCd());
		this.hashColumns.put("inter_co_cd", getInterCoCd());
		this.hashColumns.put("ap_ctr_cd", getApCtrCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rcv_cd_cmb_seq", "rcvCdCmbSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("clr_acct_cd", "clrAcctCd");
		this.hashFields.put("ap_if_tbl_tp_cd", "apIfTblTpCd");
		this.hashFields.put("acct_ctnt3", "acctCtnt3");
		this.hashFields.put("pay_acct_cd", "payAcctCd");
		this.hashFields.put("inter_co_cd", "interCoCd");
		this.hashFields.put("ap_ctr_cd", "apCtrCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return rcvCdCmbSeq
	 */
	public String getRcvCdCmbSeq() {
		return this.rcvCdCmbSeq;
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
	 * @return clrAcctCd
	 */
	public String getClrAcctCd() {
		return this.clrAcctCd;
	}
	
	/**
	 * Column Info
	 * @return apIfTblTpCd
	 */
	public String getApIfTblTpCd() {
		return this.apIfTblTpCd;
	}
	
	/**
	 * Column Info
	 * @return acctCtnt3
	 */
	public String getAcctCtnt3() {
		return this.acctCtnt3;
	}
	
	/**
	 * Column Info
	 * @return payAcctCd
	 */
	public String getPayAcctCd() {
		return this.payAcctCd;
	}
	
	/**
	 * Column Info
	 * @return interCoCd
	 */
	public String getInterCoCd() {
		return this.interCoCd;
	}
	
	/**
	 * Column Info
	 * @return apCtrCd
	 */
	public String getApCtrCd() {
		return this.apCtrCd;
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
	 * @param rcvCdCmbSeq
	 */
	public void setRcvCdCmbSeq(String rcvCdCmbSeq) {
		this.rcvCdCmbSeq = rcvCdCmbSeq;
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
	 * @param clrAcctCd
	 */
	public void setClrAcctCd(String clrAcctCd) {
		this.clrAcctCd = clrAcctCd;
	}
	
	/**
	 * Column Info
	 * @param apIfTblTpCd
	 */
	public void setApIfTblTpCd(String apIfTblTpCd) {
		this.apIfTblTpCd = apIfTblTpCd;
	}
	
	/**
	 * Column Info
	 * @param acctCtnt3
	 */
	public void setAcctCtnt3(String acctCtnt3) {
		this.acctCtnt3 = acctCtnt3;
	}
	
	/**
	 * Column Info
	 * @param payAcctCd
	 */
	public void setPayAcctCd(String payAcctCd) {
		this.payAcctCd = payAcctCd;
	}
	
	/**
	 * Column Info
	 * @param interCoCd
	 */
	public void setInterCoCd(String interCoCd) {
		this.interCoCd = interCoCd;
	}
	
	/**
	 * Column Info
	 * @param apCtrCd
	 */
	public void setApCtrCd(String apCtrCd) {
		this.apCtrCd = apCtrCd;
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
		setRcvCdCmbSeq(JSPUtil.getParameter(request, prefix + "rcv_cd_cmb_seq", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setClrAcctCd(JSPUtil.getParameter(request, prefix + "clr_acct_cd", ""));
		setApIfTblTpCd(JSPUtil.getParameter(request, prefix + "ap_if_tbl_tp_cd", ""));
		setAcctCtnt3(JSPUtil.getParameter(request, prefix + "acct_ctnt3", ""));
		setPayAcctCd(JSPUtil.getParameter(request, prefix + "pay_acct_cd", ""));
		setInterCoCd(JSPUtil.getParameter(request, prefix + "inter_co_cd", ""));
		setApCtrCd(JSPUtil.getParameter(request, prefix + "ap_ctr_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APCombinationSeqCondVO[]
	 */
	public APCombinationSeqCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return APCombinationSeqCondVO[]
	 */
	public APCombinationSeqCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		APCombinationSeqCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rcvCdCmbSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_cd_cmb_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] clrAcctCd = (JSPUtil.getParameter(request, prefix	+ "clr_acct_cd", length));
			String[] apIfTblTpCd = (JSPUtil.getParameter(request, prefix	+ "ap_if_tbl_tp_cd", length));
			String[] acctCtnt3 = (JSPUtil.getParameter(request, prefix	+ "acct_ctnt3", length));
			String[] payAcctCd = (JSPUtil.getParameter(request, prefix	+ "pay_acct_cd", length));
			String[] interCoCd = (JSPUtil.getParameter(request, prefix	+ "inter_co_cd", length));
			String[] apCtrCd = (JSPUtil.getParameter(request, prefix	+ "ap_ctr_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			
			for (int i = 0; i < length; i++) {
				model = new APCombinationSeqCondVO();
				if (rcvCdCmbSeq[i] != null)
					model.setRcvCdCmbSeq(rcvCdCmbSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (clrAcctCd[i] != null)
					model.setClrAcctCd(clrAcctCd[i]);
				if (apIfTblTpCd[i] != null)
					model.setApIfTblTpCd(apIfTblTpCd[i]);
				if (acctCtnt3[i] != null)
					model.setAcctCtnt3(acctCtnt3[i]);
				if (payAcctCd[i] != null)
					model.setPayAcctCd(payAcctCd[i]);
				if (interCoCd[i] != null)
					model.setInterCoCd(interCoCd[i]);
				if (apCtrCd[i] != null)
					model.setApCtrCd(apCtrCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getAPCombinationSeqCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return APCombinationSeqCondVO[]
	 */
	public APCombinationSeqCondVO[] getAPCombinationSeqCondVOs(){
		APCombinationSeqCondVO[] vos = (APCombinationSeqCondVO[])models.toArray(new APCombinationSeqCondVO[models.size()]);
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
		this.rcvCdCmbSeq = this.rcvCdCmbSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clrAcctCd = this.clrAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apIfTblTpCd = this.apIfTblTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt3 = this.acctCtnt3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAcctCd = this.payAcctCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interCoCd = this.interCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCtrCd = this.apCtrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
