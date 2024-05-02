/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ReceiptListByBankConditionVO.java
*@FileTitle : ReceiptListByBankConditionVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.28
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.28  
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

public class ReceiptListByBankConditionVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ReceiptListByBankConditionVO> models = new ArrayList<ReceiptListByBankConditionVO>();
	
	/* Column Info */
	private String bankAcctSeq = null;
	/* Column Info */
	private String rctDtFm = null;
	/* Column Info */
	private String rctOfcCd = null;
	/* Column Info */
	private String rctDpsDtFm = null;
	/* Column Info */
	private String rctUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rctCurrCd = null;
	/* Column Info */
	private String rctDtTpCd = null;
	/* Column Info */
	private String rctDtTo = null;
	/* Column Info */
	private String rctTpCd = null;
	/* Column Info */
	private String rctDpsDtTo = null;
	/* Column Info */
	private String rctStsCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public ReceiptListByBankConditionVO() {}

	public ReceiptListByBankConditionVO(String ibflag, String pagerows, String rctDtTpCd, String rctOfcCd, String rctDtFm, String rctDtTo, String rctDpsDtFm, String rctDpsDtTo, String rctStsCd, String bankAcctSeq, String rctTpCd, String rctUsrId, String rctCurrCd) {
		this.bankAcctSeq = bankAcctSeq;
		this.rctDtFm = rctDtFm;
		this.rctOfcCd = rctOfcCd;
		this.rctDpsDtFm = rctDpsDtFm;
		this.rctUsrId = rctUsrId;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.rctCurrCd = rctCurrCd;
		this.rctDtTpCd = rctDtTpCd;
		this.rctDtTo = rctDtTo;
		this.rctTpCd = rctTpCd;
		this.rctDpsDtTo = rctDpsDtTo;
		this.rctStsCd = rctStsCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());
		this.hashColumns.put("rct_dt_fm", getRctDtFm());
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());
		this.hashColumns.put("rct_dps_dt_fm", getRctDpsDtFm());
		this.hashColumns.put("rct_usr_id", getRctUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());
		this.hashColumns.put("rct_dt_tp_cd", getRctDtTpCd());
		this.hashColumns.put("rct_dt_to", getRctDtTo());
		this.hashColumns.put("rct_tp_cd", getRctTpCd());
		this.hashColumns.put("rct_dps_dt_to", getRctDpsDtTo());
		this.hashColumns.put("rct_sts_cd", getRctStsCd());
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
		this.hashFields.put("rct_dps_dt_fm", "rctDpsDtFm");
		this.hashFields.put("rct_usr_id", "rctUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("rct_dt_tp_cd", "rctDtTpCd");
		this.hashFields.put("rct_dt_to", "rctDtTo");
		this.hashFields.put("rct_tp_cd", "rctTpCd");
		this.hashFields.put("rct_dps_dt_to", "rctDpsDtTo");
		this.hashFields.put("rct_sts_cd", "rctStsCd");
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
	 * @return rctDpsDtFm
	 */
	public String getRctDpsDtFm() {
		return this.rctDpsDtFm;
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
	 * @return rctCurrCd
	 */
	public String getRctCurrCd() {
		return this.rctCurrCd;
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
	 * @return rctDpsDtTo
	 */
	public String getRctDpsDtTo() {
		return this.rctDpsDtTo;
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
	 * @param rctDpsDtFm
	 */
	public void setRctDpsDtFm(String rctDpsDtFm) {
		this.rctDpsDtFm = rctDpsDtFm;
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
	 * @param rctCurrCd
	 */
	public void setRctCurrCd(String rctCurrCd) {
		this.rctCurrCd = rctCurrCd;
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
	 * @param rctDpsDtTo
	 */
	public void setRctDpsDtTo(String rctDpsDtTo) {
		this.rctDpsDtTo = rctDpsDtTo;
	}
	
	/**
	 * Column Info
	 * @param rctStsCd
	 */
	public void setRctStsCd(String rctStsCd) {
		this.rctStsCd = rctStsCd;
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
		setRctDpsDtFm(JSPUtil.getParameter(request, prefix + "rct_dps_dt_fm", ""));
		setRctUsrId(JSPUtil.getParameter(request, prefix + "rct_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRctCurrCd(JSPUtil.getParameter(request, prefix + "rct_curr_cd", ""));
		setRctDtTpCd(JSPUtil.getParameter(request, prefix + "rct_dt_tp_cd", ""));
		setRctDtTo(JSPUtil.getParameter(request, prefix + "rct_dt_to", ""));
		setRctTpCd(JSPUtil.getParameter(request, prefix + "rct_tp_cd", ""));
		setRctDpsDtTo(JSPUtil.getParameter(request, prefix + "rct_dps_dt_to", ""));
		setRctStsCd(JSPUtil.getParameter(request, prefix + "rct_sts_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceiptListByBankConditionVO[]
	 */
	public ReceiptListByBankConditionVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ReceiptListByBankConditionVO[]
	 */
	public ReceiptListByBankConditionVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ReceiptListByBankConditionVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bankAcctSeq = (JSPUtil.getParameter(request, prefix	+ "bank_acct_seq", length));
			String[] rctDtFm = (JSPUtil.getParameter(request, prefix	+ "rct_dt_fm", length));
			String[] rctOfcCd = (JSPUtil.getParameter(request, prefix	+ "rct_ofc_cd", length));
			String[] rctDpsDtFm = (JSPUtil.getParameter(request, prefix	+ "rct_dps_dt_fm", length));
			String[] rctUsrId = (JSPUtil.getParameter(request, prefix	+ "rct_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rctCurrCd = (JSPUtil.getParameter(request, prefix	+ "rct_curr_cd", length));
			String[] rctDtTpCd = (JSPUtil.getParameter(request, prefix	+ "rct_dt_tp_cd", length));
			String[] rctDtTo = (JSPUtil.getParameter(request, prefix	+ "rct_dt_to", length));
			String[] rctTpCd = (JSPUtil.getParameter(request, prefix	+ "rct_tp_cd", length));
			String[] rctDpsDtTo = (JSPUtil.getParameter(request, prefix	+ "rct_dps_dt_to", length));
			String[] rctStsCd = (JSPUtil.getParameter(request, prefix	+ "rct_sts_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ReceiptListByBankConditionVO();
				if (bankAcctSeq[i] != null)
					model.setBankAcctSeq(bankAcctSeq[i]);
				if (rctDtFm[i] != null)
					model.setRctDtFm(rctDtFm[i]);
				if (rctOfcCd[i] != null)
					model.setRctOfcCd(rctOfcCd[i]);
				if (rctDpsDtFm[i] != null)
					model.setRctDpsDtFm(rctDpsDtFm[i]);
				if (rctUsrId[i] != null)
					model.setRctUsrId(rctUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rctCurrCd[i] != null)
					model.setRctCurrCd(rctCurrCd[i]);
				if (rctDtTpCd[i] != null)
					model.setRctDtTpCd(rctDtTpCd[i]);
				if (rctDtTo[i] != null)
					model.setRctDtTo(rctDtTo[i]);
				if (rctTpCd[i] != null)
					model.setRctTpCd(rctTpCd[i]);
				if (rctDpsDtTo[i] != null)
					model.setRctDpsDtTo(rctDpsDtTo[i]);
				if (rctStsCd[i] != null)
					model.setRctStsCd(rctStsCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getReceiptListByBankConditionVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ReceiptListByBankConditionVO[]
	 */
	public ReceiptListByBankConditionVO[] getReceiptListByBankConditionVOs(){
		ReceiptListByBankConditionVO[] vos = (ReceiptListByBankConditionVO[])models.toArray(new ReceiptListByBankConditionVO[models.size()]);
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
		this.rctDpsDtFm = this.rctDpsDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctUsrId = this.rctUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd = this.rctCurrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDtTpCd = this.rctDtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDtTo = this.rctDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTpCd = this.rctTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDpsDtTo = this.rctDpsDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctStsCd = this.rctStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
