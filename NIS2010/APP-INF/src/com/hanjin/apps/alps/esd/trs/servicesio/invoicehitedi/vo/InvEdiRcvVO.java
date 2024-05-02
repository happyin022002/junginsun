/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : InvEdiRcvVO.java
*@FileTitle : InvEdiRcvVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.08
*@LastModifier : 신동일
*@LastVersion : 1.0
* 2016.07.08 신동일 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.servicesio.invoicehitedi.vo;

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
 * @author 신동일
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class InvEdiRcvVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvEdiRcvVO> models = new ArrayList<InvEdiRcvVO>();
	
	/* Column Info */
	private String valRmk = null;
	/* Column Info */
	private String invTtlAmt = null;
	/* Column Info */
	private String invVatAmt = null;
	/* Column Info */
	private String valChkFlg = null;
	/* Column Info */
	private String invVndrSeq = null;
	/* Column Info */
	private String invEdiRcvSeq = null;
	/* Column Info */
	private String rcvrId = null;
	/* Column Info */
	private String ediMsg = null;
	/* Column Info */
	private String invIssDt = null;
	/* Column Info */
	private String invCurrCd = null;
	/* Column Info */
	private String invWhldTaxAmt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String invNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String invEdiStsCd = null;
	/* Column Info */
	private String invAtchTpId = null;
	/* Column Info */
	private String invStsCd = null;
	/* Column Info */
	private String sndrId = null;
	/* Column Info */
	private String invBzcAmt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvEdiRcvVO() {}

	public InvEdiRcvVO(String ibflag, String pagerows, String invBzcAmt, String valRmk, String invTtlAmt, String invVatAmt, String valChkFlg, String invVndrSeq, String invEdiRcvSeq, String rcvrId, String ediMsg, String invIssDt, String invCurrCd, String invWhldTaxAmt, String invNo, String invEdiStsCd, String invStsCd, String invAtchTpId, String sndrId) {
		this.valRmk = valRmk;
		this.invTtlAmt = invTtlAmt;
		this.invVatAmt = invVatAmt;
		this.valChkFlg = valChkFlg;
		this.invVndrSeq = invVndrSeq;
		this.invEdiRcvSeq = invEdiRcvSeq;
		this.rcvrId = rcvrId;
		this.ediMsg = ediMsg;
		this.invIssDt = invIssDt;
		this.invCurrCd = invCurrCd;
		this.invWhldTaxAmt = invWhldTaxAmt;
		this.pagerows = pagerows;
		this.invNo = invNo;
		this.ibflag = ibflag;
		this.invEdiStsCd = invEdiStsCd;
		this.invAtchTpId = invAtchTpId;
		this.invStsCd = invStsCd;
		this.sndrId = sndrId;
		this.invBzcAmt = invBzcAmt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("val_rmk", getValRmk());
		this.hashColumns.put("inv_ttl_amt", getInvTtlAmt());
		this.hashColumns.put("inv_vat_amt", getInvVatAmt());
		this.hashColumns.put("val_chk_flg", getValChkFlg());
		this.hashColumns.put("inv_vndr_seq", getInvVndrSeq());
		this.hashColumns.put("inv_edi_rcv_seq", getInvEdiRcvSeq());
		this.hashColumns.put("rcvr_id", getRcvrId());
		this.hashColumns.put("edi_msg", getEdiMsg());
		this.hashColumns.put("inv_iss_dt", getInvIssDt());
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());
		this.hashColumns.put("inv_whld_tax_amt", getInvWhldTaxAmt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("inv_edi_sts_cd", getInvEdiStsCd());
		this.hashColumns.put("inv_atch_tp_id", getInvAtchTpId());
		this.hashColumns.put("inv_sts_cd", getInvStsCd());
		this.hashColumns.put("sndr_id", getSndrId());
		this.hashColumns.put("inv_bzc_amt", getInvBzcAmt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("val_rmk", "valRmk");
		this.hashFields.put("inv_ttl_amt", "invTtlAmt");
		this.hashFields.put("inv_vat_amt", "invVatAmt");
		this.hashFields.put("val_chk_flg", "valChkFlg");
		this.hashFields.put("inv_vndr_seq", "invVndrSeq");
		this.hashFields.put("inv_edi_rcv_seq", "invEdiRcvSeq");
		this.hashFields.put("rcvr_id", "rcvrId");
		this.hashFields.put("edi_msg", "ediMsg");
		this.hashFields.put("inv_iss_dt", "invIssDt");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_whld_tax_amt", "invWhldTaxAmt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_edi_sts_cd", "invEdiStsCd");
		this.hashFields.put("inv_atch_tp_id", "invAtchTpId");
		this.hashFields.put("inv_sts_cd", "invStsCd");
		this.hashFields.put("sndr_id", "sndrId");
		this.hashFields.put("inv_bzc_amt", "invBzcAmt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return valRmk
	 */
	public String getValRmk() {
		return this.valRmk;
	}
	
	/**
	 * Column Info
	 * @return invTtlAmt
	 */
	public String getInvTtlAmt() {
		return this.invTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return invVatAmt
	 */
	public String getInvVatAmt() {
		return this.invVatAmt;
	}
	
	/**
	 * Column Info
	 * @return valChkFlg
	 */
	public String getValChkFlg() {
		return this.valChkFlg;
	}
	
	/**
	 * Column Info
	 * @return invVndrSeq
	 */
	public String getInvVndrSeq() {
		return this.invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return invEdiRcvSeq
	 */
	public String getInvEdiRcvSeq() {
		return this.invEdiRcvSeq;
	}
	
	/**
	 * Column Info
	 * @return rcvrId
	 */
	public String getRcvrId() {
		return this.rcvrId;
	}
	
	/**
	 * Column Info
	 * @return ediMsg
	 */
	public String getEdiMsg() {
		return this.ediMsg;
	}
	
	/**
	 * Column Info
	 * @return invIssDt
	 */
	public String getInvIssDt() {
		return this.invIssDt;
	}
	
	/**
	 * Column Info
	 * @return invCurrCd
	 */
	public String getInvCurrCd() {
		return this.invCurrCd;
	}
	
	/**
	 * Column Info
	 * @return invWhldTaxAmt
	 */
	public String getInvWhldTaxAmt() {
		return this.invWhldTaxAmt;
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
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return invEdiStsCd
	 */
	public String getInvEdiStsCd() {
		return this.invEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @return invAtchTpId
	 */
	public String getInvAtchTpId() {
		return this.invAtchTpId;
	}
	
	/**
	 * Column Info
	 * @return invStsCd
	 */
	public String getInvStsCd() {
		return this.invStsCd;
	}
	
	/**
	 * Column Info
	 * @return sndrId
	 */
	public String getSndrId() {
		return this.sndrId;
	}
	
	/**
	 * Column Info
	 * @return invBzcAmt
	 */
	public String getInvBzcAmt() {
		return this.invBzcAmt;
	}
	

	/**
	 * Column Info
	 * @param valRmk
	 */
	public void setValRmk(String valRmk) {
		this.valRmk = valRmk;
	}
	
	/**
	 * Column Info
	 * @param invTtlAmt
	 */
	public void setInvTtlAmt(String invTtlAmt) {
		this.invTtlAmt = invTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param invVatAmt
	 */
	public void setInvVatAmt(String invVatAmt) {
		this.invVatAmt = invVatAmt;
	}
	
	/**
	 * Column Info
	 * @param valChkFlg
	 */
	public void setValChkFlg(String valChkFlg) {
		this.valChkFlg = valChkFlg;
	}
	
	/**
	 * Column Info
	 * @param invVndrSeq
	 */
	public void setInvVndrSeq(String invVndrSeq) {
		this.invVndrSeq = invVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param invEdiRcvSeq
	 */
	public void setInvEdiRcvSeq(String invEdiRcvSeq) {
		this.invEdiRcvSeq = invEdiRcvSeq;
	}
	
	/**
	 * Column Info
	 * @param rcvrId
	 */
	public void setRcvrId(String rcvrId) {
		this.rcvrId = rcvrId;
	}
	
	/**
	 * Column Info
	 * @param ediMsg
	 */
	public void setEdiMsg(String ediMsg) {
		this.ediMsg = ediMsg;
	}
	
	/**
	 * Column Info
	 * @param invIssDt
	 */
	public void setInvIssDt(String invIssDt) {
		this.invIssDt = invIssDt;
	}
	
	/**
	 * Column Info
	 * @param invCurrCd
	 */
	public void setInvCurrCd(String invCurrCd) {
		this.invCurrCd = invCurrCd;
	}
	
	/**
	 * Column Info
	 * @param invWhldTaxAmt
	 */
	public void setInvWhldTaxAmt(String invWhldTaxAmt) {
		this.invWhldTaxAmt = invWhldTaxAmt;
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
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param invEdiStsCd
	 */
	public void setInvEdiStsCd(String invEdiStsCd) {
		this.invEdiStsCd = invEdiStsCd;
	}
	
	/**
	 * Column Info
	 * @param invAtchTpId
	 */
	public void setInvAtchTpId(String invAtchTpId) {
		this.invAtchTpId = invAtchTpId;
	}
	
	/**
	 * Column Info
	 * @param invStsCd
	 */
	public void setInvStsCd(String invStsCd) {
		this.invStsCd = invStsCd;
	}
	
	/**
	 * Column Info
	 * @param sndrId
	 */
	public void setSndrId(String sndrId) {
		this.sndrId = sndrId;
	}
	
	/**
	 * Column Info
	 * @param invBzcAmt
	 */
	public void setInvBzcAmt(String invBzcAmt) {
		this.invBzcAmt = invBzcAmt;
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
		setValRmk(JSPUtil.getParameter(request, prefix + "val_rmk", ""));
		setInvTtlAmt(JSPUtil.getParameter(request, prefix + "inv_ttl_amt", ""));
		setInvVatAmt(JSPUtil.getParameter(request, prefix + "inv_vat_amt", ""));
		setValChkFlg(JSPUtil.getParameter(request, prefix + "val_chk_flg", ""));
		setInvVndrSeq(JSPUtil.getParameter(request, prefix + "inv_vndr_seq", ""));
		setInvEdiRcvSeq(JSPUtil.getParameter(request, prefix + "inv_edi_rcv_seq", ""));
		setRcvrId(JSPUtil.getParameter(request, prefix + "rcvr_id", ""));
		setEdiMsg(JSPUtil.getParameter(request, prefix + "edi_msg", ""));
		setInvIssDt(JSPUtil.getParameter(request, prefix + "inv_iss_dt", ""));
		setInvCurrCd(JSPUtil.getParameter(request, prefix + "inv_curr_cd", ""));
		setInvWhldTaxAmt(JSPUtil.getParameter(request, prefix + "inv_whld_tax_amt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setInvEdiStsCd(JSPUtil.getParameter(request, prefix + "inv_edi_sts_cd", ""));
		setInvAtchTpId(JSPUtil.getParameter(request, prefix + "inv_atch_tp_id", ""));
		setInvStsCd(JSPUtil.getParameter(request, prefix + "inv_sts_cd", ""));
		setSndrId(JSPUtil.getParameter(request, prefix + "sndr_id", ""));
		setInvBzcAmt(JSPUtil.getParameter(request, prefix + "inv_bzc_amt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvEdiRcvVO[]
	 */
	public InvEdiRcvVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvEdiRcvVO[]
	 */
	public InvEdiRcvVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvEdiRcvVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] valRmk = (JSPUtil.getParameter(request, prefix	+ "val_rmk", length));
			String[] invTtlAmt = (JSPUtil.getParameter(request, prefix	+ "inv_ttl_amt", length));
			String[] invVatAmt = (JSPUtil.getParameter(request, prefix	+ "inv_vat_amt", length));
			String[] valChkFlg = (JSPUtil.getParameter(request, prefix	+ "val_chk_flg", length));
			String[] invVndrSeq = (JSPUtil.getParameter(request, prefix	+ "inv_vndr_seq", length));
			String[] invEdiRcvSeq = (JSPUtil.getParameter(request, prefix	+ "inv_edi_rcv_seq", length));
			String[] rcvrId = (JSPUtil.getParameter(request, prefix	+ "rcvr_id", length));
			String[] ediMsg = (JSPUtil.getParameter(request, prefix	+ "edi_msg", length));
			String[] invIssDt = (JSPUtil.getParameter(request, prefix	+ "inv_iss_dt", length));
			String[] invCurrCd = (JSPUtil.getParameter(request, prefix	+ "inv_curr_cd", length));
			String[] invWhldTaxAmt = (JSPUtil.getParameter(request, prefix	+ "inv_whld_tax_amt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] invEdiStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_edi_sts_cd", length));
			String[] invAtchTpId = (JSPUtil.getParameter(request, prefix	+ "inv_atch_tp_id", length));
			String[] invStsCd = (JSPUtil.getParameter(request, prefix	+ "inv_sts_cd", length));
			String[] sndrId = (JSPUtil.getParameter(request, prefix	+ "sndr_id", length));
			String[] invBzcAmt = (JSPUtil.getParameter(request, prefix	+ "inv_bzc_amt", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvEdiRcvVO();
				if (valRmk[i] != null)
					model.setValRmk(valRmk[i]);
				if (invTtlAmt[i] != null)
					model.setInvTtlAmt(invTtlAmt[i]);
				if (invVatAmt[i] != null)
					model.setInvVatAmt(invVatAmt[i]);
				if (valChkFlg[i] != null)
					model.setValChkFlg(valChkFlg[i]);
				if (invVndrSeq[i] != null)
					model.setInvVndrSeq(invVndrSeq[i]);
				if (invEdiRcvSeq[i] != null)
					model.setInvEdiRcvSeq(invEdiRcvSeq[i]);
				if (rcvrId[i] != null)
					model.setRcvrId(rcvrId[i]);
				if (ediMsg[i] != null)
					model.setEdiMsg(ediMsg[i]);
				if (invIssDt[i] != null)
					model.setInvIssDt(invIssDt[i]);
				if (invCurrCd[i] != null)
					model.setInvCurrCd(invCurrCd[i]);
				if (invWhldTaxAmt[i] != null)
					model.setInvWhldTaxAmt(invWhldTaxAmt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (invEdiStsCd[i] != null)
					model.setInvEdiStsCd(invEdiStsCd[i]);
				if (invAtchTpId[i] != null)
					model.setInvAtchTpId(invAtchTpId[i]);
				if (invStsCd[i] != null)
					model.setInvStsCd(invStsCd[i]);
				if (sndrId[i] != null)
					model.setSndrId(sndrId[i]);
				if (invBzcAmt[i] != null)
					model.setInvBzcAmt(invBzcAmt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvEdiRcvVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvEdiRcvVO[]
	 */
	public InvEdiRcvVO[] getInvEdiRcvVOs(){
		InvEdiRcvVO[] vos = (InvEdiRcvVO[])models.toArray(new InvEdiRcvVO[models.size()]);
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
		this.valRmk = this.valRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlAmt = this.invTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatAmt = this.invVatAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.valChkFlg = this.valChkFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVndrSeq = this.invVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiRcvSeq = this.invEdiRcvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvrId = this.rcvrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediMsg = this.ediMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssDt = this.invIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd = this.invCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invWhldTaxAmt = this.invWhldTaxAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiStsCd = this.invEdiStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAtchTpId = this.invAtchTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invStsCd = this.invStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndrId = this.sndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBzcAmt = this.invBzcAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
