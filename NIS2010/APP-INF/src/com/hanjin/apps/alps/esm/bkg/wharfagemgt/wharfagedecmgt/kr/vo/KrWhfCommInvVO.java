/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : KrWhfCommInvVO.java
*@FileTitle : KrWhfCommInvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.08
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.08  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KrWhfCommInvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KrWhfCommInvVO> models = new ArrayList<KrWhfCommInvVO>();
	
	/* Column Info */
	private String payDt = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String ongubun = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String whfBndCd = null;
	/* Column Info */
	private String custKindCd = null;
	/* Column Info */
	private String hcnt = null;
	/* Column Info */
	private String ichcnt = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String ntcAmt = null;
	/* Column Info */
	private String whfNtcNo = null;
	/* Column Info */
	private String bkrcisnot = null;
	/* Column Info */
	private String whfDeclNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String sailDt = null;
	/* Column Info */
	private String commAmt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KrWhfCommInvVO() {}

	public KrWhfCommInvVO(String ibflag, String pagerows, String vslNm, String vslCd, String hcnt, String callSgnNo, String ichcnt, String ongubun, String whfBndCd, String sailDt, String bkrcisnot, String whfNtcNo, String whfDeclNo, String custKindCd, String ntcAmt, String payDt, String commAmt) {
		this.payDt = payDt;
		this.vslCd = vslCd;
		this.ongubun = ongubun;
		this.callSgnNo = callSgnNo;
		this.whfBndCd = whfBndCd;
		this.custKindCd = custKindCd;
		this.hcnt = hcnt;
		this.ichcnt = ichcnt;
		this.vslNm = vslNm;
		this.ntcAmt = ntcAmt;
		this.whfNtcNo = whfNtcNo;
		this.bkrcisnot = bkrcisnot;
		this.whfDeclNo = whfDeclNo;
		this.pagerows = pagerows;
		this.sailDt = sailDt;
		this.commAmt = commAmt;
		this.ibflag = ibflag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ongubun", getOngubun());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("whf_bnd_cd", getWhfBndCd());
		this.hashColumns.put("cust_kind_cd", getCustKindCd());
		this.hashColumns.put("hcnt", getHcnt());
		this.hashColumns.put("ichcnt", getIchcnt());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("ntc_amt", getNtcAmt());
		this.hashColumns.put("whf_ntc_no", getWhfNtcNo());
		this.hashColumns.put("bkrcisnot", getBkrcisnot());
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sail_dt", getSailDt());
		this.hashColumns.put("comm_amt", getCommAmt());
		this.hashColumns.put("ibflag", getIbflag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ongubun", "ongubun");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("whf_bnd_cd", "whfBndCd");
		this.hashFields.put("cust_kind_cd", "custKindCd");
		this.hashFields.put("hcnt", "hcnt");
		this.hashFields.put("ichcnt", "ichcnt");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("ntc_amt", "ntcAmt");
		this.hashFields.put("whf_ntc_no", "whfNtcNo");
		this.hashFields.put("bkrcisnot", "bkrcisnot");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("comm_amt", "commAmt");
		this.hashFields.put("ibflag", "ibflag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return payDt
	 */
	public String getPayDt() {
		return this.payDt;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return ongubun
	 */
	public String getOngubun() {
		return this.ongubun;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return whfBndCd
	 */
	public String getWhfBndCd() {
		return this.whfBndCd;
	}
	
	/**
	 * Column Info
	 * @return custKindCd
	 */
	public String getCustKindCd() {
		return this.custKindCd;
	}
	
	/**
	 * Column Info
	 * @return hcnt
	 */
	public String getHcnt() {
		return this.hcnt;
	}
	
	/**
	 * Column Info
	 * @return ichcnt
	 */
	public String getIchcnt() {
		return this.ichcnt;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return ntcAmt
	 */
	public String getNtcAmt() {
		return this.ntcAmt;
	}
	
	/**
	 * Column Info
	 * @return whfNtcNo
	 */
	public String getWhfNtcNo() {
		return this.whfNtcNo;
	}
	
	/**
	 * Column Info
	 * @return bkrcisnot
	 */
	public String getBkrcisnot() {
		return this.bkrcisnot;
	}
	
	/**
	 * Column Info
	 * @return whfDeclNo
	 */
	public String getWhfDeclNo() {
		return this.whfDeclNo;
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
	 * @return sailDt
	 */
	public String getSailDt() {
		return this.sailDt;
	}
	
	/**
	 * Column Info
	 * @return commAmt
	 */
	public String getCommAmt() {
		return this.commAmt;
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
	 * @param payDt
	 */
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param ongubun
	 */
	public void setOngubun(String ongubun) {
		this.ongubun = ongubun;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param whfBndCd
	 */
	public void setWhfBndCd(String whfBndCd) {
		this.whfBndCd = whfBndCd;
	}
	
	/**
	 * Column Info
	 * @param custKindCd
	 */
	public void setCustKindCd(String custKindCd) {
		this.custKindCd = custKindCd;
	}
	
	/**
	 * Column Info
	 * @param hcnt
	 */
	public void setHcnt(String hcnt) {
		this.hcnt = hcnt;
	}
	
	/**
	 * Column Info
	 * @param ichcnt
	 */
	public void setIchcnt(String ichcnt) {
		this.ichcnt = ichcnt;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param ntcAmt
	 */
	public void setNtcAmt(String ntcAmt) {
		this.ntcAmt = ntcAmt;
	}
	
	/**
	 * Column Info
	 * @param whfNtcNo
	 */
	public void setWhfNtcNo(String whfNtcNo) {
		this.whfNtcNo = whfNtcNo;
	}
	
	/**
	 * Column Info
	 * @param bkrcisnot
	 */
	public void setBkrcisnot(String bkrcisnot) {
		this.bkrcisnot = bkrcisnot;
	}
	
	/**
	 * Column Info
	 * @param whfDeclNo
	 */
	public void setWhfDeclNo(String whfDeclNo) {
		this.whfDeclNo = whfDeclNo;
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
	 * @param sailDt
	 */
	public void setSailDt(String sailDt) {
		this.sailDt = sailDt;
	}
	
	/**
	 * Column Info
	 * @param commAmt
	 */
	public void setCommAmt(String commAmt) {
		this.commAmt = commAmt;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
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
		setPayDt(JSPUtil.getParameter(request, prefix + "pay_dt", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setOngubun(JSPUtil.getParameter(request, prefix + "ongubun", ""));
		setCallSgnNo(JSPUtil.getParameter(request, prefix + "call_sgn_no", ""));
		setWhfBndCd(JSPUtil.getParameter(request, prefix + "whf_bnd_cd", ""));
		setCustKindCd(JSPUtil.getParameter(request, prefix + "cust_kind_cd", ""));
		setHcnt(JSPUtil.getParameter(request, prefix + "hcnt", ""));
		setIchcnt(JSPUtil.getParameter(request, prefix + "ichcnt", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setNtcAmt(JSPUtil.getParameter(request, prefix + "ntc_amt", ""));
		setWhfNtcNo(JSPUtil.getParameter(request, prefix + "whf_ntc_no", ""));
		setBkrcisnot(JSPUtil.getParameter(request, prefix + "bkrcisnot", ""));
		setWhfDeclNo(JSPUtil.getParameter(request, prefix + "whf_decl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setSailDt(JSPUtil.getParameter(request, prefix + "sail_dt", ""));
		setCommAmt(JSPUtil.getParameter(request, prefix + "comm_amt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KrWhfCommInvVO[]
	 */
	public KrWhfCommInvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KrWhfCommInvVO[]
	 */
	public KrWhfCommInvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KrWhfCommInvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] payDt = (JSPUtil.getParameter(request, prefix	+ "pay_dt", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] ongubun = (JSPUtil.getParameter(request, prefix	+ "ongubun", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] whfBndCd = (JSPUtil.getParameter(request, prefix	+ "whf_bnd_cd", length));
			String[] custKindCd = (JSPUtil.getParameter(request, prefix	+ "cust_kind_cd", length));
			String[] hcnt = (JSPUtil.getParameter(request, prefix	+ "hcnt", length));
			String[] ichcnt = (JSPUtil.getParameter(request, prefix	+ "ichcnt", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] ntcAmt = (JSPUtil.getParameter(request, prefix	+ "ntc_amt", length));
			String[] whfNtcNo = (JSPUtil.getParameter(request, prefix	+ "whf_ntc_no", length));
			String[] bkrcisnot = (JSPUtil.getParameter(request, prefix	+ "bkrcisnot", length));
			String[] whfDeclNo = (JSPUtil.getParameter(request, prefix	+ "whf_decl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] sailDt = (JSPUtil.getParameter(request, prefix	+ "sail_dt", length));
			String[] commAmt = (JSPUtil.getParameter(request, prefix	+ "comm_amt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			
			for (int i = 0; i < length; i++) {
				model = new KrWhfCommInvVO();
				if (payDt[i] != null)
					model.setPayDt(payDt[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ongubun[i] != null)
					model.setOngubun(ongubun[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (whfBndCd[i] != null)
					model.setWhfBndCd(whfBndCd[i]);
				if (custKindCd[i] != null)
					model.setCustKindCd(custKindCd[i]);
				if (hcnt[i] != null)
					model.setHcnt(hcnt[i]);
				if (ichcnt[i] != null)
					model.setIchcnt(ichcnt[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (ntcAmt[i] != null)
					model.setNtcAmt(ntcAmt[i]);
				if (whfNtcNo[i] != null)
					model.setWhfNtcNo(whfNtcNo[i]);
				if (bkrcisnot[i] != null)
					model.setBkrcisnot(bkrcisnot[i]);
				if (whfDeclNo[i] != null)
					model.setWhfDeclNo(whfDeclNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (sailDt[i] != null)
					model.setSailDt(sailDt[i]);
				if (commAmt[i] != null)
					model.setCommAmt(commAmt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKrWhfCommInvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KrWhfCommInvVO[]
	 */
	public KrWhfCommInvVO[] getKrWhfCommInvVOs(){
		KrWhfCommInvVO[] vos = (KrWhfCommInvVO[])models.toArray(new KrWhfCommInvVO[models.size()]);
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
		this.payDt = this.payDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ongubun = this.ongubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfBndCd = this.whfBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custKindCd = this.custKindCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcnt = this.hcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ichcnt = this.ichcnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntcAmt = this.ntcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfNtcNo = this.whfNtcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkrcisnot = this.bkrcisnot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo = this.whfDeclNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt = this.sailDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commAmt = this.commAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
