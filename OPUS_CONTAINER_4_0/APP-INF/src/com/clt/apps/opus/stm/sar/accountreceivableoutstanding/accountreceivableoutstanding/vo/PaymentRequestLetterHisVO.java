/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PaymentRequestLetterHisVO.java
*@FileTitle : PaymentRequestLetterHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.09  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

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

public class PaymentRequestLetterHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentRequestLetterHisVO> models = new ArrayList<PaymentRequestLetterHisVO>();
	
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String sendDtFm = null;
	/* Column Info */
	private String stmtStsCd = null;
	/* Column Info */
	private String stmtRqstTpCd = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String csCustCd = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String stmtUsrId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rType = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String sendDtTo = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String stmtRqstSeq = null;
	/* Column Info */
	private String stmtStDt = null;
	/* Column Info */
	private String custCntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentRequestLetterHisVO() {}

	public PaymentRequestLetterHisVO(String ibflag, String pagerows, String custNm, String sendDtFm, String stmtRqstTpCd, String ctrlOfcCd, String custSeq, String csCustCd, String arOfcCd, String stmtUsrId, String rType, String sendDtTo, String custCd, String stmtStDt, String stmtRqstSeq, String custCntCd, String stmtStsCd) {
		this.custNm = custNm;
		this.sendDtFm = sendDtFm;
		this.stmtStsCd = stmtStsCd;
		this.stmtRqstTpCd = stmtRqstTpCd;
		this.ctrlOfcCd = ctrlOfcCd;
		this.custSeq = custSeq;
		this.csCustCd = csCustCd;
		this.arOfcCd = arOfcCd;
		this.stmtUsrId = stmtUsrId;
		this.pagerows = pagerows;
		this.rType = rType;
		this.ibflag = ibflag;
		this.sendDtTo = sendDtTo;
		this.custCd = custCd;
		this.stmtRqstSeq = stmtRqstSeq;
		this.stmtStDt = stmtStDt;
		this.custCntCd = custCntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("send_dt_fm", getSendDtFm());
		this.hashColumns.put("stmt_sts_cd", getStmtStsCd());
		this.hashColumns.put("stmt_rqst_tp_cd", getStmtRqstTpCd());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cs_cust_cd", getCsCustCd());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("stmt_usr_id", getStmtUsrId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("r_type", getRType());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("send_dt_to", getSendDtTo());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("stmt_rqst_seq", getStmtRqstSeq());
		this.hashColumns.put("stmt_st_dt", getStmtStDt());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("send_dt_fm", "sendDtFm");
		this.hashFields.put("stmt_sts_cd", "stmtStsCd");
		this.hashFields.put("stmt_rqst_tp_cd", "stmtRqstTpCd");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cs_cust_cd", "csCustCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("stmt_usr_id", "stmtUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("r_type", "rType");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("send_dt_to", "sendDtTo");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("stmt_rqst_seq", "stmtRqstSeq");
		this.hashFields.put("stmt_st_dt", "stmtStDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return sendDtFm
	 */
	public String getSendDtFm() {
		return this.sendDtFm;
	}
	
	/**
	 * Column Info
	 * @return stmtStsCd
	 */
	public String getStmtStsCd() {
		return this.stmtStsCd;
	}
	
	/**
	 * Column Info
	 * @return stmtRqstTpCd
	 */
	public String getStmtRqstTpCd() {
		return this.stmtRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return csCustCd
	 */
	public String getCsCustCd() {
		return this.csCustCd;
	}
	
	/**
	 * Column Info
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return stmtUsrId
	 */
	public String getStmtUsrId() {
		return this.stmtUsrId;
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
	 * @return rType
	 */
	public String getRType() {
		return this.rType;
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
	 * @return sendDtTo
	 */
	public String getSendDtTo() {
		return this.sendDtTo;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return stmtRqstSeq
	 */
	public String getStmtRqstSeq() {
		return this.stmtRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return stmtStDt
	 */
	public String getStmtStDt() {
		return this.stmtStDt;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	

	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param sendDtFm
	 */
	public void setSendDtFm(String sendDtFm) {
		this.sendDtFm = sendDtFm;
	}
	
	/**
	 * Column Info
	 * @param stmtStsCd
	 */
	public void setStmtStsCd(String stmtStsCd) {
		this.stmtStsCd = stmtStsCd;
	}
	
	/**
	 * Column Info
	 * @param stmtRqstTpCd
	 */
	public void setStmtRqstTpCd(String stmtRqstTpCd) {
		this.stmtRqstTpCd = stmtRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param csCustCd
	 */
	public void setCsCustCd(String csCustCd) {
		this.csCustCd = csCustCd;
	}
	
	/**
	 * Column Info
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param stmtUsrId
	 */
	public void setStmtUsrId(String stmtUsrId) {
		this.stmtUsrId = stmtUsrId;
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
	 * @param rType
	 */
	public void setRType(String rType) {
		this.rType = rType;
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
	 * @param sendDtTo
	 */
	public void setSendDtTo(String sendDtTo) {
		this.sendDtTo = sendDtTo;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param stmtRqstSeq
	 */
	public void setStmtRqstSeq(String stmtRqstSeq) {
		this.stmtRqstSeq = stmtRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param stmtStDt
	 */
	public void setStmtStDt(String stmtStDt) {
		this.stmtStDt = stmtStDt;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
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
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setSendDtFm(JSPUtil.getParameter(request, prefix + "send_dt_fm", ""));
		setStmtStsCd(JSPUtil.getParameter(request, prefix + "stmt_sts_cd", ""));
		setStmtRqstTpCd(JSPUtil.getParameter(request, prefix + "stmt_rqst_tp_cd", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCsCustCd(JSPUtil.getParameter(request, prefix + "cs_cust_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setStmtUsrId(JSPUtil.getParameter(request, prefix + "stmt_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRType(JSPUtil.getParameter(request, prefix + "r_type", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSendDtTo(JSPUtil.getParameter(request, prefix + "send_dt_to", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setStmtRqstSeq(JSPUtil.getParameter(request, prefix + "stmt_rqst_seq", ""));
		setStmtStDt(JSPUtil.getParameter(request, prefix + "stmt_st_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentRequestLetterHisVO[]
	 */
	public PaymentRequestLetterHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentRequestLetterHisVO[]
	 */
	public PaymentRequestLetterHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentRequestLetterHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] sendDtFm = (JSPUtil.getParameter(request, prefix	+ "send_dt_fm", length));
			String[] stmtStsCd = (JSPUtil.getParameter(request, prefix	+ "stmt_sts_cd", length));
			String[] stmtRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "stmt_rqst_tp_cd", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] csCustCd = (JSPUtil.getParameter(request, prefix	+ "cs_cust_cd", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] stmtUsrId = (JSPUtil.getParameter(request, prefix	+ "stmt_usr_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rType = (JSPUtil.getParameter(request, prefix	+ "r_type", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] sendDtTo = (JSPUtil.getParameter(request, prefix	+ "send_dt_to", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] stmtRqstSeq = (JSPUtil.getParameter(request, prefix	+ "stmt_rqst_seq", length));
			String[] stmtStDt = (JSPUtil.getParameter(request, prefix	+ "stmt_st_dt", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentRequestLetterHisVO();
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (sendDtFm[i] != null)
					model.setSendDtFm(sendDtFm[i]);
				if (stmtStsCd[i] != null)
					model.setStmtStsCd(stmtStsCd[i]);
				if (stmtRqstTpCd[i] != null)
					model.setStmtRqstTpCd(stmtRqstTpCd[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (csCustCd[i] != null)
					model.setCsCustCd(csCustCd[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (stmtUsrId[i] != null)
					model.setStmtUsrId(stmtUsrId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rType[i] != null)
					model.setRType(rType[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (sendDtTo[i] != null)
					model.setSendDtTo(sendDtTo[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (stmtRqstSeq[i] != null)
					model.setStmtRqstSeq(stmtRqstSeq[i]);
				if (stmtStDt[i] != null)
					model.setStmtStDt(stmtStDt[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentRequestLetterHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentRequestLetterHisVO[]
	 */
	public PaymentRequestLetterHisVO[] getPaymentRequestLetterHisVOs(){
		PaymentRequestLetterHisVO[] vos = (PaymentRequestLetterHisVO[])models.toArray(new PaymentRequestLetterHisVO[models.size()]);
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
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDtFm = this.sendDtFm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stmtStsCd = this.stmtStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stmtRqstTpCd = this.stmtRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csCustCd = this.csCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stmtUsrId = this.stmtUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rType = this.rType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendDtTo = this.sendDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stmtRqstSeq = this.stmtRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stmtStDt = this.stmtStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
