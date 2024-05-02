/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SamsungEDISendBLVO.java
*@FileTitle : SamsungEDISendBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.14
*@LastModifier : 박정진
*@LastVersion : 1.0
* 2009.10.14 박정진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 박정진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamsungEDISendBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamsungEDISendBLVO> models = new ArrayList<SamsungEDISendBLVO>();
	
	/* Column Info */
	private String custCdCa = null;
	/* Column Info */
	private String locTpCdDel = null;
	/* Column Info */
	private String msgIdBl = null;
	/* Column Info */
	private String remark = null;
	/* Column Info */
	private String actualDate = null;
	/* Column Info */
	private String locCdDel = null;
	/* Column Info */
	private String rlydocDocNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String divTyCd = null;
	/* Column Info */
	private String locCntCdPor = null;
	/* Column Info */
	private String msgNo = null;
	/* Column Info */
	private String rlydocDocDate = null;
	/* Column Info */
	private String locCntCdPol = null;
	/* Column Info */
	private String msgFuncCd = null;
	/* Column Info */
	private String locCntCdDel = null;
	/* Column Info */
	private String locCntCdPod = null;
	/* Column Info */
	private String customerTpCdFw = null;
	/* Column Info */
	private String plantDesc = null;
	/* Column Info */
	private String divCdDesc = null;
	/* Column Info */
	private String custCdFw = null;
	/* Column Info */
	private String customerTpCdCa = null;
	/* Column Info */
	private String header = null;
	/* Column Info */
	private String meaCd = null;
	/* Column Info */
	private String rlydocMsgNo = null;
	/* Column Info */
	private String locNamePol = null;
	/* Column Info */
	private String locNameDel = null;
	/* Column Info */
	private String locCdPod = null;
	/* Column Info */
	private String custNameFw = null;
	/* Column Info */
	private String docNo = null;
	/* Column Info */
	private String locNamePor = null;
	/* Column Info */
	private String meaQty = null;
	/* Column Info */
	private String locCdPol = null;
	/* Column Info */
	private String locTpCdPod = null;
	/* Column Info */
	private String locCntNamePor = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locTpCdPol = null;
	/* Column Info */
	private String locTpCdPor = null;
	/* Column Info */
	private String locCdPor = null;
	/* Column Info */
	private String locCntNamePol = null;
	/* Column Info */
	private String blLineNoBl = null;
	/* Column Info */
	private String docDate = null;
	/* Column Info */
	private String locCntNameDel = null;
	/* Column Info */
	private String locCntNamePod = null;
	/* Column Info */
	private String custNameCa = null;
	/* Column Info */
	private String blSrcNoBl = null;
	/* Column Info */
	private String billingDate = null;
	/* Column Info */
	private String csMeaCd = null;
	/* Column Info */
	private String plantCd = null;
	/* Column Info */
	private String rlydocDocNo2 = null;
	/* Column Info */
	private String rlydocDocNo1 = null;
	/* Column Info */
	private String msgNoBl = null;
	/* Column Info */
	private String locNamePod = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamsungEDISendBLVO() {}

	public SamsungEDISendBLVO(String ibflag, String pagerows, String header, String msgNo, String msgFuncCd, String docNo, String docDate, String billingDate, String divTyCd, String divCdDesc, String rlydocMsgNo, String rlydocDocNo, String rlydocDocDate, String rlydocDocNo1, String rlydocDocNo2, String actualDate, String plantCd, String plantDesc, String remark, String customerTpCdCa, String custCdCa, String custNameCa, String customerTpCdFw, String custCdFw, String custNameFw, String locTpCdPor, String locCdPor, String locNamePor, String locCntCdPor, String locCntNamePor, String locTpCdPol, String locCdPol, String locNamePol, String locCntCdPol, String locCntNamePol, String locTpCdPod, String locCdPod, String locNamePod, String locCntCdPod, String locCntNamePod, String locTpCdDel, String locCdDel, String locNameDel, String locCntCdDel, String locCntNameDel, String csMeaCd, String meaQty, String meaCd, String msgIdBl, String msgNoBl, String blLineNoBl, String blSrcNoBl) {
		this.custCdCa = custCdCa;
		this.locTpCdDel = locTpCdDel;
		this.msgIdBl = msgIdBl;
		this.remark = remark;
		this.actualDate = actualDate;
		this.locCdDel = locCdDel;
		this.rlydocDocNo = rlydocDocNo;
		this.pagerows = pagerows;
		this.divTyCd = divTyCd;
		this.locCntCdPor = locCntCdPor;
		this.msgNo = msgNo;
		this.rlydocDocDate = rlydocDocDate;
		this.locCntCdPol = locCntCdPol;
		this.msgFuncCd = msgFuncCd;
		this.locCntCdDel = locCntCdDel;
		this.locCntCdPod = locCntCdPod;
		this.customerTpCdFw = customerTpCdFw;
		this.plantDesc = plantDesc;
		this.divCdDesc = divCdDesc;
		this.custCdFw = custCdFw;
		this.customerTpCdCa = customerTpCdCa;
		this.header = header;
		this.meaCd = meaCd;
		this.rlydocMsgNo = rlydocMsgNo;
		this.locNamePol = locNamePol;
		this.locNameDel = locNameDel;
		this.locCdPod = locCdPod;
		this.custNameFw = custNameFw;
		this.docNo = docNo;
		this.locNamePor = locNamePor;
		this.meaQty = meaQty;
		this.locCdPol = locCdPol;
		this.locTpCdPod = locTpCdPod;
		this.locCntNamePor = locCntNamePor;
		this.ibflag = ibflag;
		this.locTpCdPol = locTpCdPol;
		this.locTpCdPor = locTpCdPor;
		this.locCdPor = locCdPor;
		this.locCntNamePol = locCntNamePol;
		this.blLineNoBl = blLineNoBl;
		this.docDate = docDate;
		this.locCntNameDel = locCntNameDel;
		this.locCntNamePod = locCntNamePod;
		this.custNameCa = custNameCa;
		this.blSrcNoBl = blSrcNoBl;
		this.billingDate = billingDate;
		this.csMeaCd = csMeaCd;
		this.plantCd = plantCd;
		this.rlydocDocNo2 = rlydocDocNo2;
		this.rlydocDocNo1 = rlydocDocNo1;
		this.msgNoBl = msgNoBl;
		this.locNamePod = locNamePod;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cust_cd_ca", getCustCdCa());
		this.hashColumns.put("loc_tp_cd_del", getLocTpCdDel());
		this.hashColumns.put("msg_id_bl", getMsgIdBl());
		this.hashColumns.put("remark", getRemark());
		this.hashColumns.put("actual_date", getActualDate());
		this.hashColumns.put("loc_cd_del", getLocCdDel());
		this.hashColumns.put("rlydoc_doc_no", getRlydocDocNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("div_ty_cd", getDivTyCd());
		this.hashColumns.put("loc_cnt_cd_por", getLocCntCdPor());
		this.hashColumns.put("msg_no", getMsgNo());
		this.hashColumns.put("rlydoc_doc_date", getRlydocDocDate());
		this.hashColumns.put("loc_cnt_cd_pol", getLocCntCdPol());
		this.hashColumns.put("msg_func_cd", getMsgFuncCd());
		this.hashColumns.put("loc_cnt_cd_del", getLocCntCdDel());
		this.hashColumns.put("loc_cnt_cd_pod", getLocCntCdPod());
		this.hashColumns.put("customer_tp_cd_fw", getCustomerTpCdFw());
		this.hashColumns.put("plant_desc", getPlantDesc());
		this.hashColumns.put("div_cd_desc", getDivCdDesc());
		this.hashColumns.put("cust_cd_fw", getCustCdFw());
		this.hashColumns.put("customer_tp_cd_ca", getCustomerTpCdCa());
		this.hashColumns.put("header", getHeader());
		this.hashColumns.put("mea_cd", getMeaCd());
		this.hashColumns.put("rlydoc_msg_no", getRlydocMsgNo());
		this.hashColumns.put("loc_name_pol", getLocNamePol());
		this.hashColumns.put("loc_name_del", getLocNameDel());
		this.hashColumns.put("loc_cd_pod", getLocCdPod());
		this.hashColumns.put("cust_name_fw", getCustNameFw());
		this.hashColumns.put("doc_no", getDocNo());
		this.hashColumns.put("loc_name_por", getLocNamePor());
		this.hashColumns.put("mea_qty", getMeaQty());
		this.hashColumns.put("loc_cd_pol", getLocCdPol());
		this.hashColumns.put("loc_tp_cd_pod", getLocTpCdPod());
		this.hashColumns.put("loc_cnt_name_por", getLocCntNamePor());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_tp_cd_pol", getLocTpCdPol());
		this.hashColumns.put("loc_tp_cd_por", getLocTpCdPor());
		this.hashColumns.put("loc_cd_por", getLocCdPor());
		this.hashColumns.put("loc_cnt_name_pol", getLocCntNamePol());
		this.hashColumns.put("bl_line_no_bl", getBlLineNoBl());
		this.hashColumns.put("doc_date", getDocDate());
		this.hashColumns.put("loc_cnt_name_del", getLocCntNameDel());
		this.hashColumns.put("loc_cnt_name_pod", getLocCntNamePod());
		this.hashColumns.put("cust_name_ca", getCustNameCa());
		this.hashColumns.put("bl_src_no_bl", getBlSrcNoBl());
		this.hashColumns.put("billing_date", getBillingDate());
		this.hashColumns.put("cs_mea_cd", getCsMeaCd());
		this.hashColumns.put("plant_cd", getPlantCd());
		this.hashColumns.put("rlydoc_doc_no2", getRlydocDocNo2());
		this.hashColumns.put("rlydoc_doc_no1", getRlydocDocNo1());
		this.hashColumns.put("msg_no_bl", getMsgNoBl());
		this.hashColumns.put("loc_name_pod", getLocNamePod());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cust_cd_ca", "custCdCa");
		this.hashFields.put("loc_tp_cd_del", "locTpCdDel");
		this.hashFields.put("msg_id_bl", "msgIdBl");
		this.hashFields.put("remark", "remark");
		this.hashFields.put("actual_date", "actualDate");
		this.hashFields.put("loc_cd_del", "locCdDel");
		this.hashFields.put("rlydoc_doc_no", "rlydocDocNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("div_ty_cd", "divTyCd");
		this.hashFields.put("loc_cnt_cd_por", "locCntCdPor");
		this.hashFields.put("msg_no", "msgNo");
		this.hashFields.put("rlydoc_doc_date", "rlydocDocDate");
		this.hashFields.put("loc_cnt_cd_pol", "locCntCdPol");
		this.hashFields.put("msg_func_cd", "msgFuncCd");
		this.hashFields.put("loc_cnt_cd_del", "locCntCdDel");
		this.hashFields.put("loc_cnt_cd_pod", "locCntCdPod");
		this.hashFields.put("customer_tp_cd_fw", "customerTpCdFw");
		this.hashFields.put("plant_desc", "plantDesc");
		this.hashFields.put("div_cd_desc", "divCdDesc");
		this.hashFields.put("cust_cd_fw", "custCdFw");
		this.hashFields.put("customer_tp_cd_ca", "customerTpCdCa");
		this.hashFields.put("header", "header");
		this.hashFields.put("mea_cd", "meaCd");
		this.hashFields.put("rlydoc_msg_no", "rlydocMsgNo");
		this.hashFields.put("loc_name_pol", "locNamePol");
		this.hashFields.put("loc_name_del", "locNameDel");
		this.hashFields.put("loc_cd_pod", "locCdPod");
		this.hashFields.put("cust_name_fw", "custNameFw");
		this.hashFields.put("doc_no", "docNo");
		this.hashFields.put("loc_name_por", "locNamePor");
		this.hashFields.put("mea_qty", "meaQty");
		this.hashFields.put("loc_cd_pol", "locCdPol");
		this.hashFields.put("loc_tp_cd_pod", "locTpCdPod");
		this.hashFields.put("loc_cnt_name_por", "locCntNamePor");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_tp_cd_pol", "locTpCdPol");
		this.hashFields.put("loc_tp_cd_por", "locTpCdPor");
		this.hashFields.put("loc_cd_por", "locCdPor");
		this.hashFields.put("loc_cnt_name_pol", "locCntNamePol");
		this.hashFields.put("bl_line_no_bl", "blLineNoBl");
		this.hashFields.put("doc_date", "docDate");
		this.hashFields.put("loc_cnt_name_del", "locCntNameDel");
		this.hashFields.put("loc_cnt_name_pod", "locCntNamePod");
		this.hashFields.put("cust_name_ca", "custNameCa");
		this.hashFields.put("bl_src_no_bl", "blSrcNoBl");
		this.hashFields.put("billing_date", "billingDate");
		this.hashFields.put("cs_mea_cd", "csMeaCd");
		this.hashFields.put("plant_cd", "plantCd");
		this.hashFields.put("rlydoc_doc_no2", "rlydocDocNo2");
		this.hashFields.put("rlydoc_doc_no1", "rlydocDocNo1");
		this.hashFields.put("msg_no_bl", "msgNoBl");
		this.hashFields.put("loc_name_pod", "locNamePod");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return custCdCa
	 */
	public String getCustCdCa() {
		return this.custCdCa;
	}
	
	/**
	 * Column Info
	 * @return locTpCdDel
	 */
	public String getLocTpCdDel() {
		return this.locTpCdDel;
	}
	
	/**
	 * Column Info
	 * @return msgIdBl
	 */
	public String getMsgIdBl() {
		return this.msgIdBl;
	}
	
	/**
	 * Column Info
	 * @return remark
	 */
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * Column Info
	 * @return actualDate
	 */
	public String getActualDate() {
		return this.actualDate;
	}
	
	/**
	 * Column Info
	 * @return locCdDel
	 */
	public String getLocCdDel() {
		return this.locCdDel;
	}
	
	/**
	 * Column Info
	 * @return rlydocDocNo
	 */
	public String getRlydocDocNo() {
		return this.rlydocDocNo;
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
	 * @return divTyCd
	 */
	public String getDivTyCd() {
		return this.divTyCd;
	}
	
	/**
	 * Column Info
	 * @return locCntCdPor
	 */
	public String getLocCntCdPor() {
		return this.locCntCdPor;
	}
	
	/**
	 * Column Info
	 * @return msgNo
	 */
	public String getMsgNo() {
		return this.msgNo;
	}
	
	/**
	 * Column Info
	 * @return rlydocDocDate
	 */
	public String getRlydocDocDate() {
		return this.rlydocDocDate;
	}
	
	/**
	 * Column Info
	 * @return locCntCdPol
	 */
	public String getLocCntCdPol() {
		return this.locCntCdPol;
	}
	
	/**
	 * Column Info
	 * @return msgFuncCd
	 */
	public String getMsgFuncCd() {
		return this.msgFuncCd;
	}
	
	/**
	 * Column Info
	 * @return locCntCdDel
	 */
	public String getLocCntCdDel() {
		return this.locCntCdDel;
	}
	
	/**
	 * Column Info
	 * @return locCntCdPod
	 */
	public String getLocCntCdPod() {
		return this.locCntCdPod;
	}
	
	/**
	 * Column Info
	 * @return customerTpCdFw
	 */
	public String getCustomerTpCdFw() {
		return this.customerTpCdFw;
	}
	
	/**
	 * Column Info
	 * @return plantDesc
	 */
	public String getPlantDesc() {
		return this.plantDesc;
	}
	
	/**
	 * Column Info
	 * @return divCdDesc
	 */
	public String getDivCdDesc() {
		return this.divCdDesc;
	}
	
	/**
	 * Column Info
	 * @return custCdFw
	 */
	public String getCustCdFw() {
		return this.custCdFw;
	}
	
	/**
	 * Column Info
	 * @return customerTpCdCa
	 */
	public String getCustomerTpCdCa() {
		return this.customerTpCdCa;
	}
	
	/**
	 * Column Info
	 * @return header
	 */
	public String getHeader() {
		return this.header;
	}
	
	/**
	 * Column Info
	 * @return meaCd
	 */
	public String getMeaCd() {
		return this.meaCd;
	}
	
	/**
	 * Column Info
	 * @return rlydocMsgNo
	 */
	public String getRlydocMsgNo() {
		return this.rlydocMsgNo;
	}
	
	/**
	 * Column Info
	 * @return locNamePol
	 */
	public String getLocNamePol() {
		return this.locNamePol;
	}
	
	/**
	 * Column Info
	 * @return locNameDel
	 */
	public String getLocNameDel() {
		return this.locNameDel;
	}
	
	/**
	 * Column Info
	 * @return locCdPod
	 */
	public String getLocCdPod() {
		return this.locCdPod;
	}
	
	/**
	 * Column Info
	 * @return custNameFw
	 */
	public String getCustNameFw() {
		return this.custNameFw;
	}
	
	/**
	 * Column Info
	 * @return docNo
	 */
	public String getDocNo() {
		return this.docNo;
	}
	
	/**
	 * Column Info
	 * @return locNamePor
	 */
	public String getLocNamePor() {
		return this.locNamePor;
	}
	
	/**
	 * Column Info
	 * @return meaQty
	 */
	public String getMeaQty() {
		return this.meaQty;
	}
	
	/**
	 * Column Info
	 * @return locCdPol
	 */
	public String getLocCdPol() {
		return this.locCdPol;
	}
	
	/**
	 * Column Info
	 * @return locTpCdPod
	 */
	public String getLocTpCdPod() {
		return this.locTpCdPod;
	}
	
	/**
	 * Column Info
	 * @return locCntNamePor
	 */
	public String getLocCntNamePor() {
		return this.locCntNamePor;
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
	 * @return locTpCdPol
	 */
	public String getLocTpCdPol() {
		return this.locTpCdPol;
	}
	
	/**
	 * Column Info
	 * @return locTpCdPor
	 */
	public String getLocTpCdPor() {
		return this.locTpCdPor;
	}
	
	/**
	 * Column Info
	 * @return locCdPor
	 */
	public String getLocCdPor() {
		return this.locCdPor;
	}
	
	/**
	 * Column Info
	 * @return locCntNamePol
	 */
	public String getLocCntNamePol() {
		return this.locCntNamePol;
	}
	
	/**
	 * Column Info
	 * @return blLineNoBl
	 */
	public String getBlLineNoBl() {
		return this.blLineNoBl;
	}
	
	/**
	 * Column Info
	 * @return docDate
	 */
	public String getDocDate() {
		return this.docDate;
	}
	
	/**
	 * Column Info
	 * @return locCntNameDel
	 */
	public String getLocCntNameDel() {
		return this.locCntNameDel;
	}
	
	/**
	 * Column Info
	 * @return locCntNamePod
	 */
	public String getLocCntNamePod() {
		return this.locCntNamePod;
	}
	
	/**
	 * Column Info
	 * @return custNameCa
	 */
	public String getCustNameCa() {
		return this.custNameCa;
	}
	
	/**
	 * Column Info
	 * @return blSrcNoBl
	 */
	public String getBlSrcNoBl() {
		return this.blSrcNoBl;
	}
	
	/**
	 * Column Info
	 * @return billingDate
	 */
	public String getBillingDate() {
		return this.billingDate;
	}
	
	/**
	 * Column Info
	 * @return csMeaCd
	 */
	public String getCsMeaCd() {
		return this.csMeaCd;
	}
	
	/**
	 * Column Info
	 * @return plantCd
	 */
	public String getPlantCd() {
		return this.plantCd;
	}
	
	/**
	 * Column Info
	 * @return rlydocDocNo2
	 */
	public String getRlydocDocNo2() {
		return this.rlydocDocNo2;
	}
	
	/**
	 * Column Info
	 * @return rlydocDocNo1
	 */
	public String getRlydocDocNo1() {
		return this.rlydocDocNo1;
	}
	
	/**
	 * Column Info
	 * @return msgNoBl
	 */
	public String getMsgNoBl() {
		return this.msgNoBl;
	}
	
	/**
	 * Column Info
	 * @return locNamePod
	 */
	public String getLocNamePod() {
		return this.locNamePod;
	}
	

	/**
	 * Column Info
	 * @param custCdCa
	 */
	public void setCustCdCa(String custCdCa) {
		this.custCdCa = custCdCa;
	}
	
	/**
	 * Column Info
	 * @param locTpCdDel
	 */
	public void setLocTpCdDel(String locTpCdDel) {
		this.locTpCdDel = locTpCdDel;
	}
	
	/**
	 * Column Info
	 * @param msgIdBl
	 */
	public void setMsgIdBl(String msgIdBl) {
		this.msgIdBl = msgIdBl;
	}
	
	/**
	 * Column Info
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/**
	 * Column Info
	 * @param actualDate
	 */
	public void setActualDate(String actualDate) {
		this.actualDate = actualDate;
	}
	
	/**
	 * Column Info
	 * @param locCdDel
	 */
	public void setLocCdDel(String locCdDel) {
		this.locCdDel = locCdDel;
	}
	
	/**
	 * Column Info
	 * @param rlydocDocNo
	 */
	public void setRlydocDocNo(String rlydocDocNo) {
		this.rlydocDocNo = rlydocDocNo;
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
	 * @param divTyCd
	 */
	public void setDivTyCd(String divTyCd) {
		this.divTyCd = divTyCd;
	}
	
	/**
	 * Column Info
	 * @param locCntCdPor
	 */
	public void setLocCntCdPor(String locCntCdPor) {
		this.locCntCdPor = locCntCdPor;
	}
	
	/**
	 * Column Info
	 * @param msgNo
	 */
	public void setMsgNo(String msgNo) {
		this.msgNo = msgNo;
	}
	
	/**
	 * Column Info
	 * @param rlydocDocDate
	 */
	public void setRlydocDocDate(String rlydocDocDate) {
		this.rlydocDocDate = rlydocDocDate;
	}
	
	/**
	 * Column Info
	 * @param locCntCdPol
	 */
	public void setLocCntCdPol(String locCntCdPol) {
		this.locCntCdPol = locCntCdPol;
	}
	
	/**
	 * Column Info
	 * @param msgFuncCd
	 */
	public void setMsgFuncCd(String msgFuncCd) {
		this.msgFuncCd = msgFuncCd;
	}
	
	/**
	 * Column Info
	 * @param locCntCdDel
	 */
	public void setLocCntCdDel(String locCntCdDel) {
		this.locCntCdDel = locCntCdDel;
	}
	
	/**
	 * Column Info
	 * @param locCntCdPod
	 */
	public void setLocCntCdPod(String locCntCdPod) {
		this.locCntCdPod = locCntCdPod;
	}
	
	/**
	 * Column Info
	 * @param customerTpCdFw
	 */
	public void setCustomerTpCdFw(String customerTpCdFw) {
		this.customerTpCdFw = customerTpCdFw;
	}
	
	/**
	 * Column Info
	 * @param plantDesc
	 */
	public void setPlantDesc(String plantDesc) {
		this.plantDesc = plantDesc;
	}
	
	/**
	 * Column Info
	 * @param divCdDesc
	 */
	public void setDivCdDesc(String divCdDesc) {
		this.divCdDesc = divCdDesc;
	}
	
	/**
	 * Column Info
	 * @param custCdFw
	 */
	public void setCustCdFw(String custCdFw) {
		this.custCdFw = custCdFw;
	}
	
	/**
	 * Column Info
	 * @param customerTpCdCa
	 */
	public void setCustomerTpCdCa(String customerTpCdCa) {
		this.customerTpCdCa = customerTpCdCa;
	}
	
	/**
	 * Column Info
	 * @param header
	 */
	public void setHeader(String header) {
		this.header = header;
	}
	
	/**
	 * Column Info
	 * @param meaCd
	 */
	public void setMeaCd(String meaCd) {
		this.meaCd = meaCd;
	}
	
	/**
	 * Column Info
	 * @param rlydocMsgNo
	 */
	public void setRlydocMsgNo(String rlydocMsgNo) {
		this.rlydocMsgNo = rlydocMsgNo;
	}
	
	/**
	 * Column Info
	 * @param locNamePol
	 */
	public void setLocNamePol(String locNamePol) {
		this.locNamePol = locNamePol;
	}
	
	/**
	 * Column Info
	 * @param locNameDel
	 */
	public void setLocNameDel(String locNameDel) {
		this.locNameDel = locNameDel;
	}
	
	/**
	 * Column Info
	 * @param locCdPod
	 */
	public void setLocCdPod(String locCdPod) {
		this.locCdPod = locCdPod;
	}
	
	/**
	 * Column Info
	 * @param custNameFw
	 */
	public void setCustNameFw(String custNameFw) {
		this.custNameFw = custNameFw;
	}
	
	/**
	 * Column Info
	 * @param docNo
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
	}
	
	/**
	 * Column Info
	 * @param locNamePor
	 */
	public void setLocNamePor(String locNamePor) {
		this.locNamePor = locNamePor;
	}
	
	/**
	 * Column Info
	 * @param meaQty
	 */
	public void setMeaQty(String meaQty) {
		this.meaQty = meaQty;
	}
	
	/**
	 * Column Info
	 * @param locCdPol
	 */
	public void setLocCdPol(String locCdPol) {
		this.locCdPol = locCdPol;
	}
	
	/**
	 * Column Info
	 * @param locTpCdPod
	 */
	public void setLocTpCdPod(String locTpCdPod) {
		this.locTpCdPod = locTpCdPod;
	}
	
	/**
	 * Column Info
	 * @param locCntNamePor
	 */
	public void setLocCntNamePor(String locCntNamePor) {
		this.locCntNamePor = locCntNamePor;
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
	 * @param locTpCdPol
	 */
	public void setLocTpCdPol(String locTpCdPol) {
		this.locTpCdPol = locTpCdPol;
	}
	
	/**
	 * Column Info
	 * @param locTpCdPor
	 */
	public void setLocTpCdPor(String locTpCdPor) {
		this.locTpCdPor = locTpCdPor;
	}
	
	/**
	 * Column Info
	 * @param locCdPor
	 */
	public void setLocCdPor(String locCdPor) {
		this.locCdPor = locCdPor;
	}
	
	/**
	 * Column Info
	 * @param locCntNamePol
	 */
	public void setLocCntNamePol(String locCntNamePol) {
		this.locCntNamePol = locCntNamePol;
	}
	
	/**
	 * Column Info
	 * @param blLineNoBl
	 */
	public void setBlLineNoBl(String blLineNoBl) {
		this.blLineNoBl = blLineNoBl;
	}
	
	/**
	 * Column Info
	 * @param docDate
	 */
	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}
	
	/**
	 * Column Info
	 * @param locCntNameDel
	 */
	public void setLocCntNameDel(String locCntNameDel) {
		this.locCntNameDel = locCntNameDel;
	}
	
	/**
	 * Column Info
	 * @param locCntNamePod
	 */
	public void setLocCntNamePod(String locCntNamePod) {
		this.locCntNamePod = locCntNamePod;
	}
	
	/**
	 * Column Info
	 * @param custNameCa
	 */
	public void setCustNameCa(String custNameCa) {
		this.custNameCa = custNameCa;
	}
	
	/**
	 * Column Info
	 * @param blSrcNoBl
	 */
	public void setBlSrcNoBl(String blSrcNoBl) {
		this.blSrcNoBl = blSrcNoBl;
	}
	
	/**
	 * Column Info
	 * @param billingDate
	 */
	public void setBillingDate(String billingDate) {
		this.billingDate = billingDate;
	}
	
	/**
	 * Column Info
	 * @param csMeaCd
	 */
	public void setCsMeaCd(String csMeaCd) {
		this.csMeaCd = csMeaCd;
	}
	
	/**
	 * Column Info
	 * @param plantCd
	 */
	public void setPlantCd(String plantCd) {
		this.plantCd = plantCd;
	}
	
	/**
	 * Column Info
	 * @param rlydocDocNo2
	 */
	public void setRlydocDocNo2(String rlydocDocNo2) {
		this.rlydocDocNo2 = rlydocDocNo2;
	}
	
	/**
	 * Column Info
	 * @param rlydocDocNo1
	 */
	public void setRlydocDocNo1(String rlydocDocNo1) {
		this.rlydocDocNo1 = rlydocDocNo1;
	}
	
	/**
	 * Column Info
	 * @param msgNoBl
	 */
	public void setMsgNoBl(String msgNoBl) {
		this.msgNoBl = msgNoBl;
	}
	
	/**
	 * Column Info
	 * @param locNamePod
	 */
	public void setLocNamePod(String locNamePod) {
		this.locNamePod = locNamePod;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setCustCdCa(JSPUtil.getParameter(request, "cust_cd_ca", ""));
		setLocTpCdDel(JSPUtil.getParameter(request, "loc_tp_cd_del", ""));
		setMsgIdBl(JSPUtil.getParameter(request, "msg_id_bl", ""));
		setRemark(JSPUtil.getParameter(request, "remark", ""));
		setActualDate(JSPUtil.getParameter(request, "actual_date", ""));
		setLocCdDel(JSPUtil.getParameter(request, "loc_cd_del", ""));
		setRlydocDocNo(JSPUtil.getParameter(request, "rlydoc_doc_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDivTyCd(JSPUtil.getParameter(request, "div_ty_cd", ""));
		setLocCntCdPor(JSPUtil.getParameter(request, "loc_cnt_cd_por", ""));
		setMsgNo(JSPUtil.getParameter(request, "msg_no", ""));
		setRlydocDocDate(JSPUtil.getParameter(request, "rlydoc_doc_date", ""));
		setLocCntCdPol(JSPUtil.getParameter(request, "loc_cnt_cd_pol", ""));
		setMsgFuncCd(JSPUtil.getParameter(request, "msg_func_cd", ""));
		setLocCntCdDel(JSPUtil.getParameter(request, "loc_cnt_cd_del", ""));
		setLocCntCdPod(JSPUtil.getParameter(request, "loc_cnt_cd_pod", ""));
		setCustomerTpCdFw(JSPUtil.getParameter(request, "customer_tp_cd_fw", ""));
		setPlantDesc(JSPUtil.getParameter(request, "plant_desc", ""));
		setDivCdDesc(JSPUtil.getParameter(request, "div_cd_desc", ""));
		setCustCdFw(JSPUtil.getParameter(request, "cust_cd_fw", ""));
		setCustomerTpCdCa(JSPUtil.getParameter(request, "customer_tp_cd_ca", ""));
		setHeader(JSPUtil.getParameter(request, "header", ""));
		setMeaCd(JSPUtil.getParameter(request, "mea_cd", ""));
		setRlydocMsgNo(JSPUtil.getParameter(request, "rlydoc_msg_no", ""));
		setLocNamePol(JSPUtil.getParameter(request, "loc_name_pol", ""));
		setLocNameDel(JSPUtil.getParameter(request, "loc_name_del", ""));
		setLocCdPod(JSPUtil.getParameter(request, "loc_cd_pod", ""));
		setCustNameFw(JSPUtil.getParameter(request, "cust_name_fw", ""));
		setDocNo(JSPUtil.getParameter(request, "doc_no", ""));
		setLocNamePor(JSPUtil.getParameter(request, "loc_name_por", ""));
		setMeaQty(JSPUtil.getParameter(request, "mea_qty", ""));
		setLocCdPol(JSPUtil.getParameter(request, "loc_cd_pol", ""));
		setLocTpCdPod(JSPUtil.getParameter(request, "loc_tp_cd_pod", ""));
		setLocCntNamePor(JSPUtil.getParameter(request, "loc_cnt_name_por", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocTpCdPol(JSPUtil.getParameter(request, "loc_tp_cd_pol", ""));
		setLocTpCdPor(JSPUtil.getParameter(request, "loc_tp_cd_por", ""));
		setLocCdPor(JSPUtil.getParameter(request, "loc_cd_por", ""));
		setLocCntNamePol(JSPUtil.getParameter(request, "loc_cnt_name_pol", ""));
		setBlLineNoBl(JSPUtil.getParameter(request, "bl_line_no_bl", ""));
		setDocDate(JSPUtil.getParameter(request, "doc_date", ""));
		setLocCntNameDel(JSPUtil.getParameter(request, "loc_cnt_name_del", ""));
		setLocCntNamePod(JSPUtil.getParameter(request, "loc_cnt_name_pod", ""));
		setCustNameCa(JSPUtil.getParameter(request, "cust_name_ca", ""));
		setBlSrcNoBl(JSPUtil.getParameter(request, "bl_src_no_bl", ""));
		setBillingDate(JSPUtil.getParameter(request, "billing_date", ""));
		setCsMeaCd(JSPUtil.getParameter(request, "cs_mea_cd", ""));
		setPlantCd(JSPUtil.getParameter(request, "plant_cd", ""));
		setRlydocDocNo2(JSPUtil.getParameter(request, "rlydoc_doc_no2", ""));
		setRlydocDocNo1(JSPUtil.getParameter(request, "rlydoc_doc_no1", ""));
		setMsgNoBl(JSPUtil.getParameter(request, "msg_no_bl", ""));
		setLocNamePod(JSPUtil.getParameter(request, "loc_name_pod", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamsungEDISendBLVO[]
	 */
	public SamsungEDISendBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamsungEDISendBLVO[]
	 */
	public SamsungEDISendBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamsungEDISendBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] custCdCa = (JSPUtil.getParameter(request, prefix	+ "cust_cd_ca", length));
			String[] locTpCdDel = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd_del", length));
			String[] msgIdBl = (JSPUtil.getParameter(request, prefix	+ "msg_id_bl", length));
			String[] remark = (JSPUtil.getParameter(request, prefix	+ "remark", length));
			String[] actualDate = (JSPUtil.getParameter(request, prefix	+ "actual_date", length));
			String[] locCdDel = (JSPUtil.getParameter(request, prefix	+ "loc_cd_del", length));
			String[] rlydocDocNo = (JSPUtil.getParameter(request, prefix	+ "rlydoc_doc_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] divTyCd = (JSPUtil.getParameter(request, prefix	+ "div_ty_cd", length));
			String[] locCntCdPor = (JSPUtil.getParameter(request, prefix	+ "loc_cnt_cd_por", length));
			String[] msgNo = (JSPUtil.getParameter(request, prefix	+ "msg_no", length));
			String[] rlydocDocDate = (JSPUtil.getParameter(request, prefix	+ "rlydoc_doc_date", length));
			String[] locCntCdPol = (JSPUtil.getParameter(request, prefix	+ "loc_cnt_cd_pol", length));
			String[] msgFuncCd = (JSPUtil.getParameter(request, prefix	+ "msg_func_cd", length));
			String[] locCntCdDel = (JSPUtil.getParameter(request, prefix	+ "loc_cnt_cd_del", length));
			String[] locCntCdPod = (JSPUtil.getParameter(request, prefix	+ "loc_cnt_cd_pod", length));
			String[] customerTpCdFw = (JSPUtil.getParameter(request, prefix	+ "customer_tp_cd_fw", length));
			String[] plantDesc = (JSPUtil.getParameter(request, prefix	+ "plant_desc", length));
			String[] divCdDesc = (JSPUtil.getParameter(request, prefix	+ "div_cd_desc", length));
			String[] custCdFw = (JSPUtil.getParameter(request, prefix	+ "cust_cd_fw", length));
			String[] customerTpCdCa = (JSPUtil.getParameter(request, prefix	+ "customer_tp_cd_ca", length));
			String[] header = (JSPUtil.getParameter(request, prefix	+ "header", length));
			String[] meaCd = (JSPUtil.getParameter(request, prefix	+ "mea_cd", length));
			String[] rlydocMsgNo = (JSPUtil.getParameter(request, prefix	+ "rlydoc_msg_no", length));
			String[] locNamePol = (JSPUtil.getParameter(request, prefix	+ "loc_name_pol", length));
			String[] locNameDel = (JSPUtil.getParameter(request, prefix	+ "loc_name_del", length));
			String[] locCdPod = (JSPUtil.getParameter(request, prefix	+ "loc_cd_pod", length));
			String[] custNameFw = (JSPUtil.getParameter(request, prefix	+ "cust_name_fw", length));
			String[] docNo = (JSPUtil.getParameter(request, prefix	+ "doc_no", length));
			String[] locNamePor = (JSPUtil.getParameter(request, prefix	+ "loc_name_por", length));
			String[] meaQty = (JSPUtil.getParameter(request, prefix	+ "mea_qty", length));
			String[] locCdPol = (JSPUtil.getParameter(request, prefix	+ "loc_cd_pol", length));
			String[] locTpCdPod = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd_pod", length));
			String[] locCntNamePor = (JSPUtil.getParameter(request, prefix	+ "loc_cnt_name_por", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locTpCdPol = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd_pol", length));
			String[] locTpCdPor = (JSPUtil.getParameter(request, prefix	+ "loc_tp_cd_por", length));
			String[] locCdPor = (JSPUtil.getParameter(request, prefix	+ "loc_cd_por", length));
			String[] locCntNamePol = (JSPUtil.getParameter(request, prefix	+ "loc_cnt_name_pol", length));
			String[] blLineNoBl = (JSPUtil.getParameter(request, prefix	+ "bl_line_no_bl", length));
			String[] docDate = (JSPUtil.getParameter(request, prefix	+ "doc_date", length));
			String[] locCntNameDel = (JSPUtil.getParameter(request, prefix	+ "loc_cnt_name_del", length));
			String[] locCntNamePod = (JSPUtil.getParameter(request, prefix	+ "loc_cnt_name_pod", length));
			String[] custNameCa = (JSPUtil.getParameter(request, prefix	+ "cust_name_ca", length));
			String[] blSrcNoBl = (JSPUtil.getParameter(request, prefix	+ "bl_src_no_bl", length));
			String[] billingDate = (JSPUtil.getParameter(request, prefix	+ "billing_date", length));
			String[] csMeaCd = (JSPUtil.getParameter(request, prefix	+ "cs_mea_cd", length));
			String[] plantCd = (JSPUtil.getParameter(request, prefix	+ "plant_cd", length));
			String[] rlydocDocNo2 = (JSPUtil.getParameter(request, prefix	+ "rlydoc_doc_no2", length));
			String[] rlydocDocNo1 = (JSPUtil.getParameter(request, prefix	+ "rlydoc_doc_no1", length));
			String[] msgNoBl = (JSPUtil.getParameter(request, prefix	+ "msg_no_bl", length));
			String[] locNamePod = (JSPUtil.getParameter(request, prefix	+ "loc_name_pod", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamsungEDISendBLVO();
				if (custCdCa[i] != null)
					model.setCustCdCa(custCdCa[i]);
				if (locTpCdDel[i] != null)
					model.setLocTpCdDel(locTpCdDel[i]);
				if (msgIdBl[i] != null)
					model.setMsgIdBl(msgIdBl[i]);
				if (remark[i] != null)
					model.setRemark(remark[i]);
				if (actualDate[i] != null)
					model.setActualDate(actualDate[i]);
				if (locCdDel[i] != null)
					model.setLocCdDel(locCdDel[i]);
				if (rlydocDocNo[i] != null)
					model.setRlydocDocNo(rlydocDocNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (divTyCd[i] != null)
					model.setDivTyCd(divTyCd[i]);
				if (locCntCdPor[i] != null)
					model.setLocCntCdPor(locCntCdPor[i]);
				if (msgNo[i] != null)
					model.setMsgNo(msgNo[i]);
				if (rlydocDocDate[i] != null)
					model.setRlydocDocDate(rlydocDocDate[i]);
				if (locCntCdPol[i] != null)
					model.setLocCntCdPol(locCntCdPol[i]);
				if (msgFuncCd[i] != null)
					model.setMsgFuncCd(msgFuncCd[i]);
				if (locCntCdDel[i] != null)
					model.setLocCntCdDel(locCntCdDel[i]);
				if (locCntCdPod[i] != null)
					model.setLocCntCdPod(locCntCdPod[i]);
				if (customerTpCdFw[i] != null)
					model.setCustomerTpCdFw(customerTpCdFw[i]);
				if (plantDesc[i] != null)
					model.setPlantDesc(plantDesc[i]);
				if (divCdDesc[i] != null)
					model.setDivCdDesc(divCdDesc[i]);
				if (custCdFw[i] != null)
					model.setCustCdFw(custCdFw[i]);
				if (customerTpCdCa[i] != null)
					model.setCustomerTpCdCa(customerTpCdCa[i]);
				if (header[i] != null)
					model.setHeader(header[i]);
				if (meaCd[i] != null)
					model.setMeaCd(meaCd[i]);
				if (rlydocMsgNo[i] != null)
					model.setRlydocMsgNo(rlydocMsgNo[i]);
				if (locNamePol[i] != null)
					model.setLocNamePol(locNamePol[i]);
				if (locNameDel[i] != null)
					model.setLocNameDel(locNameDel[i]);
				if (locCdPod[i] != null)
					model.setLocCdPod(locCdPod[i]);
				if (custNameFw[i] != null)
					model.setCustNameFw(custNameFw[i]);
				if (docNo[i] != null)
					model.setDocNo(docNo[i]);
				if (locNamePor[i] != null)
					model.setLocNamePor(locNamePor[i]);
				if (meaQty[i] != null)
					model.setMeaQty(meaQty[i]);
				if (locCdPol[i] != null)
					model.setLocCdPol(locCdPol[i]);
				if (locTpCdPod[i] != null)
					model.setLocTpCdPod(locTpCdPod[i]);
				if (locCntNamePor[i] != null)
					model.setLocCntNamePor(locCntNamePor[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locTpCdPol[i] != null)
					model.setLocTpCdPol(locTpCdPol[i]);
				if (locTpCdPor[i] != null)
					model.setLocTpCdPor(locTpCdPor[i]);
				if (locCdPor[i] != null)
					model.setLocCdPor(locCdPor[i]);
				if (locCntNamePol[i] != null)
					model.setLocCntNamePol(locCntNamePol[i]);
				if (blLineNoBl[i] != null)
					model.setBlLineNoBl(blLineNoBl[i]);
				if (docDate[i] != null)
					model.setDocDate(docDate[i]);
				if (locCntNameDel[i] != null)
					model.setLocCntNameDel(locCntNameDel[i]);
				if (locCntNamePod[i] != null)
					model.setLocCntNamePod(locCntNamePod[i]);
				if (custNameCa[i] != null)
					model.setCustNameCa(custNameCa[i]);
				if (blSrcNoBl[i] != null)
					model.setBlSrcNoBl(blSrcNoBl[i]);
				if (billingDate[i] != null)
					model.setBillingDate(billingDate[i]);
				if (csMeaCd[i] != null)
					model.setCsMeaCd(csMeaCd[i]);
				if (plantCd[i] != null)
					model.setPlantCd(plantCd[i]);
				if (rlydocDocNo2[i] != null)
					model.setRlydocDocNo2(rlydocDocNo2[i]);
				if (rlydocDocNo1[i] != null)
					model.setRlydocDocNo1(rlydocDocNo1[i]);
				if (msgNoBl[i] != null)
					model.setMsgNoBl(msgNoBl[i]);
				if (locNamePod[i] != null)
					model.setLocNamePod(locNamePod[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamsungEDISendBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamsungEDISendBLVO[]
	 */
	public SamsungEDISendBLVO[] getSamsungEDISendBLVOs(){
		SamsungEDISendBLVO[] vos = (SamsungEDISendBLVO[])models.toArray(new SamsungEDISendBLVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.custCdCa = this.custCdCa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCdDel = this.locTpCdDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgIdBl = this.msgIdBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remark = this.remark .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actualDate = this.actualDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdDel = this.locCdDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlydocDocNo = this.rlydocDocNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divTyCd = this.divTyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCntCdPor = this.locCntCdPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgNo = this.msgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlydocDocDate = this.rlydocDocDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCntCdPol = this.locCntCdPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFuncCd = this.msgFuncCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCntCdDel = this.locCntCdDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCntCdPod = this.locCntCdPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerTpCdFw = this.customerTpCdFw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plantDesc = this.plantDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divCdDesc = this.divCdDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCdFw = this.custCdFw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customerTpCdCa = this.customerTpCdCa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.header = this.header .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meaCd = this.meaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlydocMsgNo = this.rlydocMsgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNamePol = this.locNamePol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNameDel = this.locNameDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdPod = this.locCdPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNameFw = this.custNameFw .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docNo = this.docNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNamePor = this.locNamePor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meaQty = this.meaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdPol = this.locCdPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCdPod = this.locTpCdPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCntNamePor = this.locCntNamePor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCdPol = this.locTpCdPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTpCdPor = this.locTpCdPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCdPor = this.locCdPor .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCntNamePol = this.locCntNamePol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blLineNoBl = this.blLineNoBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docDate = this.docDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCntNameDel = this.locCntNameDel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCntNamePod = this.locCntNamePod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNameCa = this.custNameCa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNoBl = this.blSrcNoBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.billingDate = this.billingDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csMeaCd = this.csMeaCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plantCd = this.plantCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlydocDocNo2 = this.rlydocDocNo2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlydocDocNo1 = this.rlydocDocNo1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgNoBl = this.msgNoBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNamePod = this.locNamePod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
