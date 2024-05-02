/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PaymentRequestLetterByEmailFaxVO.java
*@FileTitle : PaymentRequestLetterByEmailFaxVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.05
*@LastModifier : 
*@LastVersion : 1.0
* 2015.03.05  
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

public class PaymentRequestLetterByEmailFaxVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<PaymentRequestLetterByEmailFaxVO> models = new ArrayList<PaymentRequestLetterByEmailFaxVO>();
	
	/* Column Info */
	private String lclTime = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String ttlAmt = null;
	/* Column Info */
	private String sendType = null;
	/* Column Info */
	private String endTime = null;
	/* Column Info */
	private String custFlg = null;
	/* Column Info */
	private String senderOfcCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String emtCtnt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String senderUserId = null;
	/* Column Info */
	private String senderEml = null;
	/* Column Info */
	private String rdName = null;
	/* Column Info */
	private String emlTitle = null;
	/* Column Info */
	private String rctCustCntCd = null;
	/* Column Info */
	private String sendEmlNo = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String stTime = null;
	/* Column Info */
	private String fax = null;
	/* Column Info */
	private String csCustCntCd = null;
	/* Column Info */
	private String stmtRqstTpCd = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String senderUserNm = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String stmtHisSeq = null;
	/* Column Info */
	private String rctCustSeq = null;
	/* Column Info */
	private String csCustSeq = null;
	/* Column Info */
	private String email = null;
	/* Column Info */
	private String emlSeq = null;
	/* Column Info */
	private String custCode = null;
	/* Column Info */
	private String cnsdCustFlg = null;
	/* Column Info */
	private String custName = null;
	/* Column Info */
	private String refEml = null;
	/* Column Info */
	private String qeqFmt = null;
	/* Column Info */
	private String supYn = null;
	/* Column Info */
	private String blCnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public PaymentRequestLetterByEmailFaxVO() {}

	public PaymentRequestLetterByEmailFaxVO(String ibflag, String pagerows, String lclTime, String custNm, String sendType, String ttlAmt, String endTime, String custFlg, String senderOfcCd, String emtCtnt, String senderEml, String senderUserId, String rdName, String emlTitle, String rctCustCntCd, String sendEmlNo, String custCntCd, String stTime, String fax, String csCustCntCd, String stmtRqstTpCd, String custSeq, String senderUserNm, String arOfcCd, String stmtHisSeq, String rctCustSeq, String csCustSeq, String email, String emlSeq, String custCode, String cnsdCustFlg, String custName, String qeqFmt, String supYn, String blCnt, String refEml) {
		this.lclTime = lclTime;
		this.custNm = custNm;
		this.ttlAmt = ttlAmt;
		this.sendType = sendType;
		this.endTime = endTime;
		this.custFlg = custFlg;
		this.senderOfcCd = senderOfcCd;
		this.pagerows = pagerows;
		this.emtCtnt = emtCtnt;
		this.ibflag = ibflag;
		this.senderUserId = senderUserId;
		this.senderEml = senderEml;
		this.rdName = rdName;
		this.emlTitle = emlTitle;
		this.rctCustCntCd = rctCustCntCd;
		this.sendEmlNo = sendEmlNo;
		this.custCntCd = custCntCd;
		this.stTime = stTime;
		this.fax = fax;
		this.csCustCntCd = csCustCntCd;
		this.stmtRqstTpCd = stmtRqstTpCd;
		this.custSeq = custSeq;
		this.senderUserNm = senderUserNm;
		this.arOfcCd = arOfcCd;
		this.stmtHisSeq = stmtHisSeq;
		this.rctCustSeq = rctCustSeq;
		this.csCustSeq = csCustSeq;
		this.email = email;
		this.emlSeq = emlSeq;
		this.custCode = custCode;
		this.cnsdCustFlg = cnsdCustFlg;
		this.custName = custName;
		this.refEml = refEml;
		this.qeqFmt = qeqFmt;
		this.supYn = supYn;
		this.blCnt = blCnt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lcl_time", getLclTime());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("ttl_amt", getTtlAmt());
		this.hashColumns.put("send_type", getSendType());
		this.hashColumns.put("end_time", getEndTime());
		this.hashColumns.put("cust_flg", getCustFlg());
		this.hashColumns.put("sender_ofc_cd", getSenderOfcCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("emt_ctnt", getEmtCtnt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("sender_user_id", getSenderUserId());
		this.hashColumns.put("sender_eml", getSenderEml());
		this.hashColumns.put("rd_name", getRdName());
		this.hashColumns.put("eml_title", getEmlTitle());
		this.hashColumns.put("rct_cust_cnt_cd", getRctCustCntCd());
		this.hashColumns.put("send_eml_no", getSendEmlNo());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("st_time", getStTime());
		this.hashColumns.put("fax", getFax());
		this.hashColumns.put("cs_cust_cnt_cd", getCsCustCntCd());
		this.hashColumns.put("stmt_rqst_tp_cd", getStmtRqstTpCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("sender_user_nm", getSenderUserNm());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("stmt_his_seq", getStmtHisSeq());
		this.hashColumns.put("rct_cust_seq", getRctCustSeq());
		this.hashColumns.put("cs_cust_seq", getCsCustSeq());
		this.hashColumns.put("email", getEmail());
		this.hashColumns.put("eml_seq", getEmlSeq());
		this.hashColumns.put("cust_code", getCustCode());
		this.hashColumns.put("cnsd_cust_flg", getCnsdCustFlg());
		this.hashColumns.put("cust_name", getCustName());
		this.hashColumns.put("ref_eml", getRefEml());
		this.hashColumns.put("qeq_fmt", getQeqFmt());
		this.hashColumns.put("sup_yn", getSupYn());
		this.hashColumns.put("bl_cnt", getBlCnt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lcl_time", "lclTime");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("send_type", "sendType");
		this.hashFields.put("end_time", "endTime");
		this.hashFields.put("cust_flg", "custFlg");
		this.hashFields.put("sender_ofc_cd", "senderOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("emt_ctnt", "emtCtnt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sender_user_id", "senderUserId");
		this.hashFields.put("sender_eml", "senderEml");
		this.hashFields.put("rd_name", "rdName");
		this.hashFields.put("eml_title", "emlTitle");
		this.hashFields.put("rct_cust_cnt_cd", "rctCustCntCd");
		this.hashFields.put("send_eml_no", "sendEmlNo");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("st_time", "stTime");
		this.hashFields.put("fax", "fax");
		this.hashFields.put("cs_cust_cnt_cd", "csCustCntCd");
		this.hashFields.put("stmt_rqst_tp_cd", "stmtRqstTpCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("sender_user_nm", "senderUserNm");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("stmt_his_seq", "stmtHisSeq");
		this.hashFields.put("rct_cust_seq", "rctCustSeq");
		this.hashFields.put("cs_cust_seq", "csCustSeq");
		this.hashFields.put("email", "email");
		this.hashFields.put("eml_seq", "emlSeq");
		this.hashFields.put("cust_code", "custCode");
		this.hashFields.put("cnsd_cust_flg", "cnsdCustFlg");
		this.hashFields.put("cust_name", "custName");
		this.hashFields.put("ref_eml", "refEml");
		this.hashFields.put("qeq_fmt", "qeqFmt");
		this.hashFields.put("sup_yn", "supYn");
		this.hashFields.put("bl_cnt", "blCnt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return lclTime
	 */
	public String getLclTime() {
		return this.lclTime;
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
	 * @return ttlAmt
	 */
	public String getTtlAmt() {
		return this.ttlAmt;
	}
	
	/**
	 * Column Info
	 * @return sendType
	 */
	public String getSendType() {
		return this.sendType;
	}
	
	/**
	 * Column Info
	 * @return endTime
	 */
	public String getEndTime() {
		return this.endTime;
	}
	
	/**
	 * Column Info
	 * @return custFlg
	 */
	public String getCustFlg() {
		return this.custFlg;
	}
	
	/**
	 * Column Info
	 * @return senderOfcCd
	 */
	public String getSenderOfcCd() {
		return this.senderOfcCd;
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
	 * @return emtCtnt
	 */
	public String getEmtCtnt() {
		return this.emtCtnt;
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
	 * @return senderUserId
	 */
	public String getSenderUserId() {
		return this.senderUserId;
	}
	
	/**
	 * Column Info
	 * @return senderEml
	 */
	public String getSenderEml() {
		return this.senderEml;
	}
	
	/**
	 * Column Info
	 * @return rdName
	 */
	public String getRdName() {
		return this.rdName;
	}
	
	/**
	 * Column Info
	 * @return emlTitle
	 */
	public String getEmlTitle() {
		return this.emlTitle;
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
	 * @return sendEmlNo
	 */
	public String getSendEmlNo() {
		return this.sendEmlNo;
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
	 * @return stTime
	 */
	public String getStTime() {
		return this.stTime;
	}
	
	/**
	 * Column Info
	 * @return fax
	 */
	public String getFax() {
		return this.fax;
	}
	
	/**
	 * Column Info
	 * @return csCustCntCd
	 */
	public String getCsCustCntCd() {
		return this.csCustCntCd;
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
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return senderUserNm
	 */
	public String getSenderUserNm() {
		return this.senderUserNm;
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
	 * @return stmtHisSeq
	 */
	public String getStmtHisSeq() {
		return this.stmtHisSeq;
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
	 * @return csCustSeq
	 */
	public String getCsCustSeq() {
		return this.csCustSeq;
	}
	
	/**
	 * Column Info
	 * @return email
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Column Info
	 * @return emlSeq
	 */
	public String getEmlSeq() {
		return this.emlSeq;
	}
	
	/**
	 * Column Info
	 * @return custCode
	 */
	public String getCustCode() {
		return this.custCode;
	}
	
	/**
	 * Column Info
	 * @return cnsdCustFlg
	 */
	public String getCnsdCustFlg() {
		return this.cnsdCustFlg;
	}
	
	/**
	 * Column Info
	 * @return custName
	 */
	public String getCustName() {
		return this.custName;
	}
	
	/**
	 * Column Info
	 * @return refEml
	 */
	public String getRefEml() {
		return this.refEml;
	}
	
	/**
	 * Column Info
	 * @return qeqFmt
	 */
	public String getQeqFmt() {
		return this.qeqFmt;
	}
	
	/**
	 * Column Info
	 * @return supYn
	 */
	public String getSupYn() {
		return this.supYn;
	}
	
	/**
	 * Column Info
	 * @return blCnt
	 */
	public String getBlCnt() {
		return this.blCnt;
	}
	

	/**
	 * Column Info
	 * @param lclTime
	 */
	public void setLclTime(String lclTime) {
		this.lclTime = lclTime;
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
	 * @param ttlAmt
	 */
	public void setTtlAmt(String ttlAmt) {
		this.ttlAmt = ttlAmt;
	}
	
	/**
	 * Column Info
	 * @param sendType
	 */
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	
	/**
	 * Column Info
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * Column Info
	 * @param custFlg
	 */
	public void setCustFlg(String custFlg) {
		this.custFlg = custFlg;
	}
	
	/**
	 * Column Info
	 * @param senderOfcCd
	 */
	public void setSenderOfcCd(String senderOfcCd) {
		this.senderOfcCd = senderOfcCd;
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
	 * @param emtCtnt
	 */
	public void setEmtCtnt(String emtCtnt) {
		this.emtCtnt = emtCtnt;
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
	 * @param senderUserId
	 */
	public void setSenderUserId(String senderUserId) {
		this.senderUserId = senderUserId;
	}
	
	/**
	 * Column Info
	 * @param senderEml
	 */
	public void setSenderEml(String senderEml) {
		this.senderEml = senderEml;
	}
	
	/**
	 * Column Info
	 * @param rdName
	 */
	public void setRdName(String rdName) {
		this.rdName = rdName;
	}
	
	/**
	 * Column Info
	 * @param emlTitle
	 */
	public void setEmlTitle(String emlTitle) {
		this.emlTitle = emlTitle;
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
	 * @param sendEmlNo
	 */
	public void setSendEmlNo(String sendEmlNo) {
		this.sendEmlNo = sendEmlNo;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param stTime
	 */
	public void setStTime(String stTime) {
		this.stTime = stTime;
	}
	
	/**
	 * Column Info
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * Column Info
	 * @param csCustCntCd
	 */
	public void setCsCustCntCd(String csCustCntCd) {
		this.csCustCntCd = csCustCntCd;
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
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param senderUserNm
	 */
	public void setSenderUserNm(String senderUserNm) {
		this.senderUserNm = senderUserNm;
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
	 * @param stmtHisSeq
	 */
	public void setStmtHisSeq(String stmtHisSeq) {
		this.stmtHisSeq = stmtHisSeq;
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
	 * @param csCustSeq
	 */
	public void setCsCustSeq(String csCustSeq) {
		this.csCustSeq = csCustSeq;
	}
	
	/**
	 * Column Info
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Column Info
	 * @param emlSeq
	 */
	public void setEmlSeq(String emlSeq) {
		this.emlSeq = emlSeq;
	}
	
	/**
	 * Column Info
	 * @param custCode
	 */
	public void setCustCode(String custCode) {
		this.custCode = custCode;
	}
	
	/**
	 * Column Info
	 * @param cnsdCustFlg
	 */
	public void setCnsdCustFlg(String cnsdCustFlg) {
		this.cnsdCustFlg = cnsdCustFlg;
	}
	
	/**
	 * Column Info
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
	/**
	 * Column Info
	 * @param refEml
	 */
	public void setRefEml(String refEml) {
		this.refEml = refEml;
	}
	
	/**
	 * Column Info
	 * @param qeqFmt
	 */
	public void setQeqFmt(String qeqFmt) {
		this.qeqFmt = qeqFmt;
	}
	
	/**
	 * Column Info
	 * @param supYn
	 */
	public void setSupYn(String supYn) {
		this.supYn = supYn;
	}
	
	/**
	 * Column Info
	 * @param blCnt
	 */
	public void setBlCnt(String blCnt) {
		this.blCnt = blCnt;
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
		setLclTime(JSPUtil.getParameter(request, prefix + "lcl_time", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setTtlAmt(JSPUtil.getParameter(request, prefix + "ttl_amt", ""));
		setSendType(JSPUtil.getParameter(request, prefix + "send_type", ""));
		setEndTime(JSPUtil.getParameter(request, prefix + "end_time", ""));
		setCustFlg(JSPUtil.getParameter(request, prefix + "cust_flg", ""));
		setSenderOfcCd(JSPUtil.getParameter(request, prefix + "sender_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEmtCtnt(JSPUtil.getParameter(request, prefix + "emt_ctnt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setSenderUserId(JSPUtil.getParameter(request, prefix + "sender_user_id", ""));
		setSenderEml(JSPUtil.getParameter(request, prefix + "sender_eml", ""));
		setRdName(JSPUtil.getParameter(request, prefix + "rd_name", ""));
		setEmlTitle(JSPUtil.getParameter(request, prefix + "eml_title", ""));
		setRctCustCntCd(JSPUtil.getParameter(request, prefix + "rct_cust_cnt_cd", ""));
		setSendEmlNo(JSPUtil.getParameter(request, prefix + "send_eml_no", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setStTime(JSPUtil.getParameter(request, prefix + "st_time", ""));
		setFax(JSPUtil.getParameter(request, prefix + "fax", ""));
		setCsCustCntCd(JSPUtil.getParameter(request, prefix + "cs_cust_cnt_cd", ""));
		setStmtRqstTpCd(JSPUtil.getParameter(request, prefix + "stmt_rqst_tp_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setSenderUserNm(JSPUtil.getParameter(request, prefix + "sender_user_nm", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setStmtHisSeq(JSPUtil.getParameter(request, prefix + "stmt_his_seq", ""));
		setRctCustSeq(JSPUtil.getParameter(request, prefix + "rct_cust_seq", ""));
		setCsCustSeq(JSPUtil.getParameter(request, prefix + "cs_cust_seq", ""));
		setEmail(JSPUtil.getParameter(request, prefix + "email", ""));
		setEmlSeq(JSPUtil.getParameter(request, prefix + "eml_seq", ""));
		setCustCode(JSPUtil.getParameter(request, prefix + "cust_code", ""));
		setCnsdCustFlg(JSPUtil.getParameter(request, prefix + "cnsd_cust_flg", ""));
		setCustName(JSPUtil.getParameter(request, prefix + "cust_name", ""));
		setRefEml(JSPUtil.getParameter(request, prefix + "ref_eml", ""));
		setQeqFmt(JSPUtil.getParameter(request, prefix + "qeq_fmt", ""));
		setSupYn(JSPUtil.getParameter(request, prefix + "sup_yn", ""));
		setBlCnt(JSPUtil.getParameter(request, prefix + "bl_cnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentRequestLetterByEmailFaxVO[]
	 */
	public PaymentRequestLetterByEmailFaxVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return PaymentRequestLetterByEmailFaxVO[]
	 */
	public PaymentRequestLetterByEmailFaxVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		PaymentRequestLetterByEmailFaxVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] lclTime = (JSPUtil.getParameter(request, prefix	+ "lcl_time", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] ttlAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_amt", length));
			String[] sendType = (JSPUtil.getParameter(request, prefix	+ "send_type", length));
			String[] endTime = (JSPUtil.getParameter(request, prefix	+ "end_time", length));
			String[] custFlg = (JSPUtil.getParameter(request, prefix	+ "cust_flg", length));
			String[] senderOfcCd = (JSPUtil.getParameter(request, prefix	+ "sender_ofc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emtCtnt = (JSPUtil.getParameter(request, prefix	+ "emt_ctnt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] senderUserId = (JSPUtil.getParameter(request, prefix	+ "sender_user_id", length));
			String[] senderEml = (JSPUtil.getParameter(request, prefix	+ "sender_eml", length));
			String[] rdName = (JSPUtil.getParameter(request, prefix	+ "rd_name", length));
			String[] emlTitle = (JSPUtil.getParameter(request, prefix	+ "eml_title", length));
			String[] rctCustCntCd = (JSPUtil.getParameter(request, prefix	+ "rct_cust_cnt_cd", length));
			String[] sendEmlNo = (JSPUtil.getParameter(request, prefix	+ "send_eml_no", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] stTime = (JSPUtil.getParameter(request, prefix	+ "st_time", length));
			String[] fax = (JSPUtil.getParameter(request, prefix	+ "fax", length));
			String[] csCustCntCd = (JSPUtil.getParameter(request, prefix	+ "cs_cust_cnt_cd", length));
			String[] stmtRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "stmt_rqst_tp_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] senderUserNm = (JSPUtil.getParameter(request, prefix	+ "sender_user_nm", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] stmtHisSeq = (JSPUtil.getParameter(request, prefix	+ "stmt_his_seq", length));
			String[] rctCustSeq = (JSPUtil.getParameter(request, prefix	+ "rct_cust_seq", length));
			String[] csCustSeq = (JSPUtil.getParameter(request, prefix	+ "cs_cust_seq", length));
			String[] email = (JSPUtil.getParameter(request, prefix	+ "email", length));
			String[] emlSeq = (JSPUtil.getParameter(request, prefix	+ "eml_seq", length));
			String[] custCode = (JSPUtil.getParameter(request, prefix	+ "cust_code", length));
			String[] cnsdCustFlg = (JSPUtil.getParameter(request, prefix	+ "cnsd_cust_flg", length));
			String[] custName = (JSPUtil.getParameter(request, prefix	+ "cust_name", length));
			String[] refEml = (JSPUtil.getParameter(request, prefix	+ "ref_eml", length));
			String[] qeqFmt = (JSPUtil.getParameter(request, prefix	+ "qeq_fmt", length));
			String[] supYn = (JSPUtil.getParameter(request, prefix	+ "sup_yn", length));
			String[] blCnt = (JSPUtil.getParameter(request, prefix	+ "bl_cnt", length));
			
			for (int i = 0; i < length; i++) {
				model = new PaymentRequestLetterByEmailFaxVO();
				if (lclTime[i] != null)
					model.setLclTime(lclTime[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (ttlAmt[i] != null)
					model.setTtlAmt(ttlAmt[i]);
				if (sendType[i] != null)
					model.setSendType(sendType[i]);
				if (endTime[i] != null)
					model.setEndTime(endTime[i]);
				if (custFlg[i] != null)
					model.setCustFlg(custFlg[i]);
				if (senderOfcCd[i] != null)
					model.setSenderOfcCd(senderOfcCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (emtCtnt[i] != null)
					model.setEmtCtnt(emtCtnt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (senderUserId[i] != null)
					model.setSenderUserId(senderUserId[i]);
				if (senderEml[i] != null)
					model.setSenderEml(senderEml[i]);
				if (rdName[i] != null)
					model.setRdName(rdName[i]);
				if (emlTitle[i] != null)
					model.setEmlTitle(emlTitle[i]);
				if (rctCustCntCd[i] != null)
					model.setRctCustCntCd(rctCustCntCd[i]);
				if (sendEmlNo[i] != null)
					model.setSendEmlNo(sendEmlNo[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (stTime[i] != null)
					model.setStTime(stTime[i]);
				if (fax[i] != null)
					model.setFax(fax[i]);
				if (csCustCntCd[i] != null)
					model.setCsCustCntCd(csCustCntCd[i]);
				if (stmtRqstTpCd[i] != null)
					model.setStmtRqstTpCd(stmtRqstTpCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (senderUserNm[i] != null)
					model.setSenderUserNm(senderUserNm[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (stmtHisSeq[i] != null)
					model.setStmtHisSeq(stmtHisSeq[i]);
				if (rctCustSeq[i] != null)
					model.setRctCustSeq(rctCustSeq[i]);
				if (csCustSeq[i] != null)
					model.setCsCustSeq(csCustSeq[i]);
				if (email[i] != null)
					model.setEmail(email[i]);
				if (emlSeq[i] != null)
					model.setEmlSeq(emlSeq[i]);
				if (custCode[i] != null)
					model.setCustCode(custCode[i]);
				if (cnsdCustFlg[i] != null)
					model.setCnsdCustFlg(cnsdCustFlg[i]);
				if (custName[i] != null)
					model.setCustName(custName[i]);
				if (refEml[i] != null)
					model.setRefEml(refEml[i]);
				if (qeqFmt[i] != null)
					model.setQeqFmt(qeqFmt[i]);
				if (supYn[i] != null)
					model.setSupYn(supYn[i]);
				if (blCnt[i] != null)
					model.setBlCnt(blCnt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getPaymentRequestLetterByEmailFaxVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return PaymentRequestLetterByEmailFaxVO[]
	 */
	public PaymentRequestLetterByEmailFaxVO[] getPaymentRequestLetterByEmailFaxVOs(){
		PaymentRequestLetterByEmailFaxVO[] vos = (PaymentRequestLetterByEmailFaxVO[])models.toArray(new PaymentRequestLetterByEmailFaxVO[models.size()]);
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
		this.lclTime = this.lclTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt = this.ttlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendType = this.sendType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endTime = this.endTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custFlg = this.custFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderOfcCd = this.senderOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emtCtnt = this.emtCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUserId = this.senderUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderEml = this.senderEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdName = this.rdName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlTitle = this.emlTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustCntCd = this.rctCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sendEmlNo = this.sendEmlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stTime = this.stTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fax = this.fax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csCustCntCd = this.csCustCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stmtRqstTpCd = this.stmtRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.senderUserNm = this.senderUserNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stmtHisSeq = this.stmtHisSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustSeq = this.rctCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csCustSeq = this.csCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.email = this.email .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlSeq = this.emlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCode = this.custCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnsdCustFlg = this.cnsdCustFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custName = this.custName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refEml = this.refEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qeqFmt = this.qeqFmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supYn = this.supYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCnt = this.blCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
