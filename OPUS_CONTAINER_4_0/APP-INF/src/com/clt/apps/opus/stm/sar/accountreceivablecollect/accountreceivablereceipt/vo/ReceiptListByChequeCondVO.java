/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiptListByChequeCondVO.java
*@FileTitle : ReceiptListByChequeCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2014.04.29  
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

public class ReceiptListByChequeCondVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReceiptListByChequeCondVO> models = new ArrayList<ReceiptListByChequeCondVO>();
	
	/* Column Info */
	private String bankAcctSeq = null;
	/* Column Info */
	private String rctDtFm = null;
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String chqNo = null;
	/* Column Info */
	private String rctCxlRsnCd = null;
	/* Column Info */
	private String rctUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rctUnpayStsFlg = null;
	/* Column Info */
	private String rctCustSeq = null;
	/* Column Info */
	private String rctDtTpCd = null;
	/* Column Info */
	private String rctDtTo = null;
	/* Column Info */
	private String rctTpCd = null;
	/* Column Info */
	private String asaNo = null;
	/* Column Info */
	private String rctCustCntCd = null;
	/* Column Info */
	private String rctStsCd = null;
	/* Column Info */
	private String rctNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ReceiptListByChequeCondVO() {}

	public ReceiptListByChequeCondVO(String ibflag, String pagerows, String rctDtTpCd, String rctOfcCd, String rctDtFm, String rctDtTo, String rctStsCd, String bankAcctSeq, String rctTpCd, String rctUsrId, String rctUnpayStsFlg, String rctCustCntCd, String rctCustSeq, String rctCxlRsnCd, String chqNo, String rctNo, String asaNo) {
		this.bankAcctSeq = bankAcctSeq;
		this.rctDtFm = rctDtFm;
		this.rctOfcCd = rctOfcCd;
		this.chqNo = chqNo;
		this.rctCxlRsnCd = rctCxlRsnCd;
		this.rctUsrId = rctUsrId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rctUnpayStsFlg = rctUnpayStsFlg;
		this.rctCustSeq = rctCustSeq;
		this.rctDtTpCd = rctDtTpCd;
		this.rctDtTo = rctDtTo;
		this.rctTpCd = rctTpCd;
		this.asaNo = asaNo;
		this.rctCustCntCd = rctCustCntCd;
		this.rctStsCd = rctStsCd;
		this.rctNo = rctNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());
		this.hashColumns.put("rct_dt_fm", getRctDtFm());
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("chq_no", getChqNo());
		this.hashColumns.put("rct_cxl_rsn_cd", getRctCxlRsnCd());
		this.hashColumns.put("rct_usr_id", getRctUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rct_unpay_sts_flg", getRctUnpayStsFlg());
		this.hashColumns.put("rct_cust_seq", getRctCustSeq());
		this.hashColumns.put("rct_dt_tp_cd", getRctDtTpCd());
		this.hashColumns.put("rct_dt_to", getRctDtTo());
		this.hashColumns.put("rct_tp_cd", getRctTpCd());
		this.hashColumns.put("asa_no", getAsaNo());
		this.hashColumns.put("rct_cust_cnt_cd", getRctCustCntCd());
		this.hashColumns.put("rct_sts_cd", getRctStsCd());
		this.hashColumns.put("rct_no", getRctNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("rct_dt_fm", "rctDtFm");
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("chq_no", "chqNo");
		this.hashFields.put("rct_cxl_rsn_cd", "rctCxlRsnCd");
		this.hashFields.put("rct_usr_id", "rctUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_unpay_sts_flg", "rctUnpayStsFlg");
		this.hashFields.put("rct_cust_seq", "rctCustSeq");
		this.hashFields.put("rct_dt_tp_cd", "rctDtTpCd");
		this.hashFields.put("rct_dt_to", "rctDtTo");
		this.hashFields.put("rct_tp_cd", "rctTpCd");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("rct_cust_cnt_cd", "rctCustCntCd");
		this.hashFields.put("rct_sts_cd", "rctStsCd");
		this.hashFields.put("rct_no", "rctNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bankAcctSeq
	 */
	public String getBankAcctSeq() {
		return this.bankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @return rctDtFm
	 */
	public String getRctDtFm() {
		return this.rctDtFm;
	}
	
	/**
	 * Column Info
	 * @return rctOfcCd
	 */
	public String getRctOfcCd() {
		return this.rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chqNo
	 */
	public String getChqNo() {
		return this.chqNo;
	}
	
	/**
	 * Column Info
	 * @return rctCxlRsnCd
	 */
	public String getRctCxlRsnCd() {
		return this.rctCxlRsnCd;
	}
	
	/**
	 * Column Info
	 * @return rctUsrId
	 */
	public String getRctUsrId() {
		return this.rctUsrId;
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
	 * @return rctUnpayStsFlg
	 */
	public String getRctUnpayStsFlg() {
		return this.rctUnpayStsFlg;
	}
	
	/**
	 * Column Info
	 * @return rctCustSeq
	 */
	public String getRctCustSeq() {
		return this.rctCustSeq;
	}
	
	/**
	 * Column Info
	 * @return rctDtTpCd
	 */
	public String getRctDtTpCd() {
		return this.rctDtTpCd;
	}
	
	/**
	 * Column Info
	 * @return rctDtTo
	 */
	public String getRctDtTo() {
		return this.rctDtTo;
	}
	
	/**
	 * Column Info
	 * @return rctTpCd
	 */
	public String getRctTpCd() {
		return this.rctTpCd;
	}
	
	/**
	 * Column Info
	 * @return asaNo
	 */
	public String getAsaNo() {
		return this.asaNo;
	}
	
	/**
	 * Column Info
	 * @return rctCustCntCd
	 */
	public String getRctCustCntCd() {
		return this.rctCustCntCd;
	}
	
	/**
	 * Column Info
	 * @return rctStsCd
	 */
	public String getRctStsCd() {
		return this.rctStsCd;
	}
	
	/**
	 * Column Info
	 * @return rctNo
	 */
	public String getRctNo() {
		return this.rctNo;
	}
	

	/**
	 * Column Info
	 * @param bankAcctSeq
	 */
	public void setBankAcctSeq(String bankAcctSeq) {
		this.bankAcctSeq = bankAcctSeq;
	}
	
	/**
	 * Column Info
	 * @param rctDtFm
	 */
	public void setRctDtFm(String rctDtFm) {
		this.rctDtFm = rctDtFm;
	}
	
	/**
	 * Column Info
	 * @param rctOfcCd
	 */
	public void setRctOfcCd(String rctOfcCd) {
		this.rctOfcCd = rctOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chqNo
	 */
	public void setChqNo(String chqNo) {
		this.chqNo = chqNo;
	}
	
	/**
	 * Column Info
	 * @param rctCxlRsnCd
	 */
	public void setRctCxlRsnCd(String rctCxlRsnCd) {
		this.rctCxlRsnCd = rctCxlRsnCd;
	}
	
	/**
	 * Column Info
	 * @param rctUsrId
	 */
	public void setRctUsrId(String rctUsrId) {
		this.rctUsrId = rctUsrId;
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
	 * @param rctUnpayStsFlg
	 */
	public void setRctUnpayStsFlg(String rctUnpayStsFlg) {
		this.rctUnpayStsFlg = rctUnpayStsFlg;
	}
	
	/**
	 * Column Info
	 * @param rctCustSeq
	 */
	public void setRctCustSeq(String rctCustSeq) {
		this.rctCustSeq = rctCustSeq;
	}
	
	/**
	 * Column Info
	 * @param rctDtTpCd
	 */
	public void setRctDtTpCd(String rctDtTpCd) {
		this.rctDtTpCd = rctDtTpCd;
	}
	
	/**
	 * Column Info
	 * @param rctDtTo
	 */
	public void setRctDtTo(String rctDtTo) {
		this.rctDtTo = rctDtTo;
	}
	
	/**
	 * Column Info
	 * @param rctTpCd
	 */
	public void setRctTpCd(String rctTpCd) {
		this.rctTpCd = rctTpCd;
	}
	
	/**
	 * Column Info
	 * @param asaNo
	 */
	public void setAsaNo(String asaNo) {
		this.asaNo = asaNo;
	}
	
	/**
	 * Column Info
	 * @param rctCustCntCd
	 */
	public void setRctCustCntCd(String rctCustCntCd) {
		this.rctCustCntCd = rctCustCntCd;
	}
	
	/**
	 * Column Info
	 * @param rctStsCd
	 */
	public void setRctStsCd(String rctStsCd) {
		this.rctStsCd = rctStsCd;
	}
	
	/**
	 * Column Info
	 * @param rctNo
	 */
	public void setRctNo(String rctNo) {
		this.rctNo = rctNo;
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
		setBankAcctSeq(JSPUtil.getParameter(request, prefix + "bank_acct_seq", ""));
		setRctDtFm(JSPUtil.getParameter(request, prefix + "rct_dt_fm", ""));
		setRctOfcCd(JSPUtil.getParameter(request, prefix + "rct_ofc_cd", ""));
		setChqNo(JSPUtil.getParameter(request, prefix + "chq_no", ""));
		setRctCxlRsnCd(JSPUtil.getParameter(request, prefix + "rct_cxl_rsn_cd", ""));
		setRctUsrId(JSPUtil.getParameter(request, prefix + "rct_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRctUnpayStsFlg(JSPUtil.getParameter(request, prefix + "rct_unpay_sts_flg", ""));
		setRctCustSeq(JSPUtil.getParameter(request, prefix + "rct_cust_seq", ""));
		setRctDtTpCd(JSPUtil.getParameter(request, prefix + "rct_dt_tp_cd", ""));
		setRctDtTo(JSPUtil.getParameter(request, prefix + "rct_dt_to", ""));
		setRctTpCd(JSPUtil.getParameter(request, prefix + "rct_tp_cd", ""));
		setAsaNo(JSPUtil.getParameter(request, prefix + "asa_no", ""));
		setRctCustCntCd(JSPUtil.getParameter(request, prefix + "rct_cust_cnt_cd", ""));
		setRctStsCd(JSPUtil.getParameter(request, prefix + "rct_sts_cd", ""));
		setRctNo(JSPUtil.getParameter(request, prefix + "rct_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceiptListByChequeCondVO[]
	 */
	public ReceiptListByChequeCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReceiptListByChequeCondVO[]
	 */
	public ReceiptListByChequeCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceiptListByChequeCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctSeq = (JSPUtil.getParameter(request, prefix	+ "bank_acct_seq", length));
			String[] rctDtFm = (JSPUtil.getParameter(request, prefix	+ "rct_dt_fm", length));
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] chqNo = (JSPUtil.getParameter(request, prefix	+ "chq_no", length));
			String[] rctCxlRsnCd = (JSPUtil.getParameter(request, prefix	+ "rct_cxl_rsn_cd", length));
			String[] rctUsrId = (JSPUtil.getParameter(request, prefix	+ "rct_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rctUnpayStsFlg = (JSPUtil.getParameter(request, prefix	+ "rct_unpay_sts_flg", length));
			String[] rctCustSeq = (JSPUtil.getParameter(request, prefix	+ "rct_cust_seq", length));
			String[] rctDtTpCd = (JSPUtil.getParameter(request, prefix	+ "rct_dt_tp_cd", length));
			String[] rctDtTo = (JSPUtil.getParameter(request, prefix	+ "rct_dt_to", length));
			String[] rctTpCd = (JSPUtil.getParameter(request, prefix	+ "rct_tp_cd", length));
			String[] asaNo = (JSPUtil.getParameter(request, prefix	+ "asa_no", length));
			String[] rctCustCntCd = (JSPUtil.getParameter(request, prefix	+ "rct_cust_cnt_cd", length));
			String[] rctStsCd = (JSPUtil.getParameter(request, prefix	+ "rct_sts_cd", length));
			String[] rctNo = (JSPUtil.getParameter(request, prefix	+ "rct_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReceiptListByChequeCondVO();
				if (bankAcctSeq[i] != null)
					model.setBankAcctSeq(bankAcctSeq[i]);
				if (rctDtFm[i] != null)
					model.setRctDtFm(rctDtFm[i]);
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (chqNo[i] != null)
					model.setChqNo(chqNo[i]);
				if (rctCxlRsnCd[i] != null)
					model.setRctCxlRsnCd(rctCxlRsnCd[i]);
				if (rctUsrId[i] != null)
					model.setRctUsrId(rctUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rctUnpayStsFlg[i] != null)
					model.setRctUnpayStsFlg(rctUnpayStsFlg[i]);
				if (rctCustSeq[i] != null)
					model.setRctCustSeq(rctCustSeq[i]);
				if (rctDtTpCd[i] != null)
					model.setRctDtTpCd(rctDtTpCd[i]);
				if (rctDtTo[i] != null)
					model.setRctDtTo(rctDtTo[i]);
				if (rctTpCd[i] != null)
					model.setRctTpCd(rctTpCd[i]);
				if (asaNo[i] != null)
					model.setAsaNo(asaNo[i]);
				if (rctCustCntCd[i] != null)
					model.setRctCustCntCd(rctCustCntCd[i]);
				if (rctStsCd[i] != null)
					model.setRctStsCd(rctStsCd[i]);
				if (rctNo[i] != null)
					model.setRctNo(rctNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceiptListByChequeCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceiptListByChequeCondVO[]
	 */
	public ReceiptListByChequeCondVO[] getReceiptListByChequeCondVOs(){
		ReceiptListByChequeCondVO[] vos = (ReceiptListByChequeCondVO[])models.toArray(new ReceiptListByChequeCondVO[models.size()]);
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
		this.bankAcctSeq = this.bankAcctSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDtFm = this.rctDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcCd = this.rctOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chqNo = this.chqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlRsnCd = this.rctCxlRsnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctUsrId = this.rctUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctUnpayStsFlg = this.rctUnpayStsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustSeq = this.rctCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDtTpCd = this.rctDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDtTo = this.rctDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTpCd = this.rctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo = this.asaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustCntCd = this.rctCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctStsCd = this.rctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctNo = this.rctNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
