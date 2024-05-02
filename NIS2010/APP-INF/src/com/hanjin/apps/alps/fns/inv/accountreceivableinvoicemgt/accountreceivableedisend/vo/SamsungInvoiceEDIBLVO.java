/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SamsungInvoiceEDIBLVO.java
*@FileTitle : SamsungInvoiceEDIBLVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.07.11
*@LastModifier : 김상현
*@LastVersion : 1.1
* 2009.10.05 박정진 1.0 Creation
* 2012.07.11 김상현 1.1 [CHM-201218835] (Korea) Samsung Invoice EDI > Invoice No. Numbering 요청
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

public class SamsungInvoiceEDIBLVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamsungInvoiceEDIBLVO> models = new ArrayList<SamsungInvoiceEDIBLVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String srInvNo = null;
	/* Column Info */
	private String invEdiD4Qty = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String gerpCrrCd = null;
	/* Column Info */
	private String fctryCtnt = null;
	/* Column Info */
	private String invEdiD2Qty = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String grsCbmCapa = null;
	/* Column Info */
	private String msgNo = null;
	/* Column Info */
	private String issDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String gerpCrrNm = null;
	/* Column Info */
	private String grsCntrWgt = null;
	/* Column Info */
	private String msgId = null;
	/* Column Info */
	private String invEdiD5Qty = null;
	/* Column Info */
	private String invEdiF4Qty = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String sndFlg = null;
	/* Column Info */
	private String invEdiR2Qty = null;
	/* Column Info */
	private String invEdiD7Qty = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String gerpTrspCd = null;
	/* Column Info */
	private String gerpTrspNm = null;
	/* Column Info */
	private String obrdDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fctryNm = null;
	/* Column Info */
	private String blLineNo = null;
	/* Column Info */
	private String divCtnt = null;
	/* Column Info */
	private String invEdiR4Qty = null;
	/* Column Info */
	private String divNm = null;
	/* Column Info */
	private String invEdiEtcQty = null;
	/* Column Info */
	private String blCntrGrpCtnt = null;
	/* Column Info */
	private String srInvNoOrg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamsungInvoiceEDIBLVO() {}

	public SamsungInvoiceEDIBLVO(String ibflag, String pagerows, String msgId, String msgNo, String blLineNo, String blSrcNo, String fctryCtnt, String fctryNm, String divCtnt, String divNm, String srInvNo, String gerpTrspCd, String gerpTrspNm, String obrdDt, String gerpCrrCd, String gerpCrrNm, String porCd, String polCd, String podCd, String delCd, String issDt, String invEdiD2Qty, String invEdiD4Qty, String invEdiD5Qty, String invEdiD7Qty, String invEdiR2Qty, String invEdiR4Qty, String invEdiF4Qty, String grsCntrWgt, String grsCbmCapa, String sndFlg, String creUsrId, String creDt, String updUsrId, String updDt, String invEdiEtcQty, String blCntrGrpCtnt, String srInvNoOrg) {
		this.porCd = porCd;
		this.srInvNo = srInvNo;
		this.invEdiD4Qty = invEdiD4Qty;
		this.creDt = creDt;
		this.gerpCrrCd = gerpCrrCd;
		this.fctryCtnt = fctryCtnt;
		this.invEdiD2Qty = invEdiD2Qty;
		this.pagerows = pagerows;
		this.grsCbmCapa = grsCbmCapa;
		this.msgNo = msgNo;
		this.issDt = issDt;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.gerpCrrNm = gerpCrrNm;
		this.grsCntrWgt = grsCntrWgt;
		this.msgId = msgId;
		this.invEdiD5Qty = invEdiD5Qty;
		this.invEdiF4Qty = invEdiF4Qty;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.blSrcNo = blSrcNo;
		this.sndFlg = sndFlg;
		this.invEdiR2Qty = invEdiR2Qty;
		this.invEdiD7Qty = invEdiD7Qty;
		this.delCd = delCd;
		this.gerpTrspCd = gerpTrspCd;
		this.gerpTrspNm = gerpTrspNm;
		this.obrdDt = obrdDt;
		this.podCd = podCd;
		this.creUsrId = creUsrId;
		this.fctryNm = fctryNm;
		this.blLineNo = blLineNo;
		this.divCtnt = divCtnt;
		this.invEdiR4Qty = invEdiR4Qty;
		this.divNm = divNm;
		this.invEdiEtcQty = invEdiEtcQty;
		this.blCntrGrpCtnt = blCntrGrpCtnt;
		this.srInvNoOrg = srInvNoOrg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("sr_inv_no", getSrInvNo());
		this.hashColumns.put("inv_edi_d4_qty", getInvEdiD4Qty());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("gerp_crr_cd", getGerpCrrCd());
		this.hashColumns.put("fctry_ctnt", getFctryCtnt());
		this.hashColumns.put("inv_edi_d2_qty", getInvEdiD2Qty());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("grs_cbm_capa", getGrsCbmCapa());
		this.hashColumns.put("msg_no", getMsgNo());
		this.hashColumns.put("iss_dt", getIssDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("gerp_crr_nm", getGerpCrrNm());
		this.hashColumns.put("grs_cntr_wgt", getGrsCntrWgt());
		this.hashColumns.put("msg_id", getMsgId());
		this.hashColumns.put("inv_edi_d5_qty", getInvEdiD5Qty());
		this.hashColumns.put("inv_edi_f4_qty", getInvEdiF4Qty());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("snd_flg", getSndFlg());
		this.hashColumns.put("inv_edi_r2_qty", getInvEdiR2Qty());
		this.hashColumns.put("inv_edi_d7_qty", getInvEdiD7Qty());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("gerp_trsp_cd", getGerpTrspCd());
		this.hashColumns.put("gerp_trsp_nm", getGerpTrspNm());
		this.hashColumns.put("obrd_dt", getObrdDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("fctry_nm", getFctryNm());
		this.hashColumns.put("bl_line_no", getBlLineNo());
		this.hashColumns.put("div_ctnt", getDivCtnt());
		this.hashColumns.put("inv_edi_r4_qty", getInvEdiR4Qty());
		this.hashColumns.put("div_nm", getDivNm());
		this.hashColumns.put("inv_edi_etc_qty", getInvEdiEtcQty());
		this.hashColumns.put("bl_cntr_grp_ctnt", getBlCntrGrpCtnt());
		this.hashColumns.put("sr_inv_no_org", getSrInvNoOrg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("sr_inv_no", "srInvNo");
		this.hashFields.put("inv_edi_d4_qty", "invEdiD4Qty");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("gerp_crr_cd", "gerpCrrCd");
		this.hashFields.put("fctry_ctnt", "fctryCtnt");
		this.hashFields.put("inv_edi_d2_qty", "invEdiD2Qty");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("grs_cbm_capa", "grsCbmCapa");
		this.hashFields.put("msg_no", "msgNo");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("gerp_crr_nm", "gerpCrrNm");
		this.hashFields.put("grs_cntr_wgt", "grsCntrWgt");
		this.hashFields.put("msg_id", "msgId");
		this.hashFields.put("inv_edi_d5_qty", "invEdiD5Qty");
		this.hashFields.put("inv_edi_f4_qty", "invEdiF4Qty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("snd_flg", "sndFlg");
		this.hashFields.put("inv_edi_r2_qty", "invEdiR2Qty");
		this.hashFields.put("inv_edi_d7_qty", "invEdiD7Qty");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("gerp_trsp_cd", "gerpTrspCd");
		this.hashFields.put("gerp_trsp_nm", "gerpTrspNm");
		this.hashFields.put("obrd_dt", "obrdDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fctry_nm", "fctryNm");
		this.hashFields.put("bl_line_no", "blLineNo");
		this.hashFields.put("div_ctnt", "divCtnt");
		this.hashFields.put("inv_edi_r4_qty", "invEdiR4Qty");
		this.hashFields.put("div_nm", "divNm");
		this.hashFields.put("inv_edi_etc_qty", "invEdiEtcQty");
		this.hashFields.put("bl_cntr_grp_ctnt", "blCntrGrpCtnt");
		this.hashFields.put("sr_inv_no_org", "srInvNoOrg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return srInvNo
	 */
	public String getSrInvNo() {
		return this.srInvNo;
	}
	
	/**
	 * Column Info
	 * @return invEdiD4Qty
	 */
	public String getInvEdiD4Qty() {
		return this.invEdiD4Qty;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return gerpCrrCd
	 */
	public String getGerpCrrCd() {
		return this.gerpCrrCd;
	}
	
	/**
	 * Column Info
	 * @return fctryCtnt
	 */
	public String getFctryCtnt() {
		return this.fctryCtnt;
	}
	
	/**
	 * Column Info
	 * @return invEdiD2Qty
	 */
	public String getInvEdiD2Qty() {
		return this.invEdiD2Qty;
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
	 * @return grsCbmCapa
	 */
	public String getGrsCbmCapa() {
		return this.grsCbmCapa;
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
	 * @return issDt
	 */
	public String getIssDt() {
		return this.issDt;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return gerpCrrNm
	 */
	public String getGerpCrrNm() {
		return this.gerpCrrNm;
	}
	
	/**
	 * Column Info
	 * @return grsCntrWgt
	 */
	public String getGrsCntrWgt() {
		return this.grsCntrWgt;
	}
	
	/**
	 * Column Info
	 * @return msgId
	 */
	public String getMsgId() {
		return this.msgId;
	}
	
	/**
	 * Column Info
	 * @return invEdiD5Qty
	 */
	public String getInvEdiD5Qty() {
		return this.invEdiD5Qty;
	}
	
	/**
	 * Column Info
	 * @return invEdiF4Qty
	 */
	public String getInvEdiF4Qty() {
		return this.invEdiF4Qty;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return sndFlg
	 */
	public String getSndFlg() {
		return this.sndFlg;
	}
	
	/**
	 * Column Info
	 * @return invEdiR2Qty
	 */
	public String getInvEdiR2Qty() {
		return this.invEdiR2Qty;
	}
	
	/**
	 * Column Info
	 * @return invEdiD7Qty
	 */
	public String getInvEdiD7Qty() {
		return this.invEdiD7Qty;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return gerpTrspCd
	 */
	public String getGerpTrspCd() {
		return this.gerpTrspCd;
	}
	
	/**
	 * Column Info
	 * @return gerpTrspNm
	 */
	public String getGerpTrspNm() {
		return this.gerpTrspNm;
	}
	
	/**
	 * Column Info
	 * @return obrdDt
	 */
	public String getObrdDt() {
		return this.obrdDt;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return fctryNm
	 */
	public String getFctryNm() {
		return this.fctryNm;
	}
	
	/**
	 * Column Info
	 * @return blLineNo
	 */
	public String getBlLineNo() {
		return this.blLineNo;
	}
	
	/**
	 * Column Info
	 * @return divCtnt
	 */
	public String getDivCtnt() {
		return this.divCtnt;
	}
	
	/**
	 * Column Info
	 * @return invEdiR4Qty
	 */
	public String getInvEdiR4Qty() {
		return this.invEdiR4Qty;
	}
	
	/**
	 * Column Info
	 * @return divNm
	 */
	public String getDivNm() {
		return this.divNm;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param srInvNo
	 */
	public void setSrInvNo(String srInvNo) {
		this.srInvNo = srInvNo;
	}
	
	/**
	 * Column Info
	 * @param invEdiD4Qty
	 */
	public void setInvEdiD4Qty(String invEdiD4Qty) {
		this.invEdiD4Qty = invEdiD4Qty;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param gerpCrrCd
	 */
	public void setGerpCrrCd(String gerpCrrCd) {
		this.gerpCrrCd = gerpCrrCd;
	}
	
	/**
	 * Column Info
	 * @param fctryCtnt
	 */
	public void setFctryCtnt(String fctryCtnt) {
		this.fctryCtnt = fctryCtnt;
	}
	
	/**
	 * Column Info
	 * @param invEdiD2Qty
	 */
	public void setInvEdiD2Qty(String invEdiD2Qty) {
		this.invEdiD2Qty = invEdiD2Qty;
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
	 * @param grsCbmCapa
	 */
	public void setGrsCbmCapa(String grsCbmCapa) {
		this.grsCbmCapa = grsCbmCapa;
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
	 * @param issDt
	 */
	public void setIssDt(String issDt) {
		this.issDt = issDt;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param gerpCrrNm
	 */
	public void setGerpCrrNm(String gerpCrrNm) {
		this.gerpCrrNm = gerpCrrNm;
	}
	
	/**
	 * Column Info
	 * @param grsCntrWgt
	 */
	public void setGrsCntrWgt(String grsCntrWgt) {
		this.grsCntrWgt = grsCntrWgt;
	}
	
	/**
	 * Column Info
	 * @param msgId
	 */
	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	/**
	 * Column Info
	 * @param invEdiD5Qty
	 */
	public void setInvEdiD5Qty(String invEdiD5Qty) {
		this.invEdiD5Qty = invEdiD5Qty;
	}
	
	/**
	 * Column Info
	 * @param invEdiF4Qty
	 */
	public void setInvEdiF4Qty(String invEdiF4Qty) {
		this.invEdiF4Qty = invEdiF4Qty;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param sndFlg
	 */
	public void setSndFlg(String sndFlg) {
		this.sndFlg = sndFlg;
	}
	
	/**
	 * Column Info
	 * @param invEdiR2Qty
	 */
	public void setInvEdiR2Qty(String invEdiR2Qty) {
		this.invEdiR2Qty = invEdiR2Qty;
	}
	
	/**
	 * Column Info
	 * @param invEdiD7Qty
	 */
	public void setInvEdiD7Qty(String invEdiD7Qty) {
		this.invEdiD7Qty = invEdiD7Qty;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param gerpTrspCd
	 */
	public void setGerpTrspCd(String gerpTrspCd) {
		this.gerpTrspCd = gerpTrspCd;
	}
	
	/**
	 * Column Info
	 * @param gerpTrspNm
	 */
	public void setGerpTrspNm(String gerpTrspNm) {
		this.gerpTrspNm = gerpTrspNm;
	}
	
	/**
	 * Column Info
	 * @param obrdDt
	 */
	public void setObrdDt(String obrdDt) {
		this.obrdDt = obrdDt;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param fctryNm
	 */
	public void setFctryNm(String fctryNm) {
		this.fctryNm = fctryNm;
	}
	
	/**
	 * Column Info
	 * @param blLineNo
	 */
	public void setBlLineNo(String blLineNo) {
		this.blLineNo = blLineNo;
	}
	
	/**
	 * Column Info
	 * @param divCtnt
	 */
	public void setDivCtnt(String divCtnt) {
		this.divCtnt = divCtnt;
	}
	
	/**
	 * Column Info
	 * @param invEdiR4Qty
	 */
	public void setInvEdiR4Qty(String invEdiR4Qty) {
		this.invEdiR4Qty = invEdiR4Qty;
	}
	
	/**
	 * Column Info
	 * @param divNm
	 */
	public void setDivNm(String divNm) {
		this.divNm = divNm;
	}
	
	public String getInvEdiEtcQty() {
		return invEdiEtcQty;
	}

	public void setInvEdiEtcQty(String invEdiEtcQty) {
		this.invEdiEtcQty = invEdiEtcQty;
	}
	
	public String getBlCntrGrpCtnt() {
		return blCntrGrpCtnt;
	}

	public void setBlCntrGrpCtnt(String blCntrGrpCtnt) {
		this.blCntrGrpCtnt = blCntrGrpCtnt;
	}

	/**
	 * @return the srInvNoOrg
	 */
	public String getSrInvNoOrg() {
		return srInvNoOrg;
	}

	/**
	 * @param srInvNoOrg the srInvNoOrg to set
	 */
	public void setSrInvNoOrg(String srInvNoOrg) {
		this.srInvNoOrg = srInvNoOrg;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setSrInvNo(JSPUtil.getParameter(request, "sr_inv_no", ""));
		setInvEdiD4Qty(JSPUtil.getParameter(request, "inv_edi_d4_qty", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setGerpCrrCd(JSPUtil.getParameter(request, "gerp_crr_cd", ""));
		setFctryCtnt(JSPUtil.getParameter(request, "fctry_ctnt", ""));
		setInvEdiD2Qty(JSPUtil.getParameter(request, "inv_edi_d2_qty", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setGrsCbmCapa(JSPUtil.getParameter(request, "grs_cbm_capa", ""));
		setMsgNo(JSPUtil.getParameter(request, "msg_no", ""));
		setIssDt(JSPUtil.getParameter(request, "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setGerpCrrNm(JSPUtil.getParameter(request, "gerp_crr_nm", ""));
		setGrsCntrWgt(JSPUtil.getParameter(request, "grs_cntr_wgt", ""));
		setMsgId(JSPUtil.getParameter(request, "msg_id", ""));
		setInvEdiD5Qty(JSPUtil.getParameter(request, "inv_edi_d5_qty", ""));
		setInvEdiF4Qty(JSPUtil.getParameter(request, "inv_edi_f4_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, "bl_src_no", ""));
		setSndFlg(JSPUtil.getParameter(request, "snd_flg", ""));
		setInvEdiR2Qty(JSPUtil.getParameter(request, "inv_edi_r2_qty", ""));
		setInvEdiD7Qty(JSPUtil.getParameter(request, "inv_edi_d7_qty", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setGerpTrspCd(JSPUtil.getParameter(request, "gerp_trsp_cd", ""));
		setGerpTrspNm(JSPUtil.getParameter(request, "gerp_trsp_nm", ""));
		setObrdDt(JSPUtil.getParameter(request, "obrd_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setFctryNm(JSPUtil.getParameter(request, "fctry_nm", ""));
		setBlLineNo(JSPUtil.getParameter(request, "bl_line_no", ""));
		setDivCtnt(JSPUtil.getParameter(request, "div_ctnt", ""));
		setInvEdiR4Qty(JSPUtil.getParameter(request, "inv_edi_r4_qty", ""));
		setDivNm(JSPUtil.getParameter(request, "div_nm", ""));
		setInvEdiEtcQty(JSPUtil.getParameter(request, "inv_edi_etc_qty", ""));
		setBlCntrGrpCtnt(JSPUtil.getParameter(request, "bl_cntr_grp_ctnt", ""));
		setSrInvNoOrg(JSPUtil.getParameter(request, "sr_inv_no_org", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamsungInvoiceEDIBLVO[]
	 */
	public SamsungInvoiceEDIBLVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamsungInvoiceEDIBLVO[]
	 */
	public SamsungInvoiceEDIBLVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamsungInvoiceEDIBLVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] srInvNo = (JSPUtil.getParameter(request, prefix	+ "sr_inv_no", length));
			String[] invEdiD4Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_d4_qty", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] gerpCrrCd = (JSPUtil.getParameter(request, prefix	+ "gerp_crr_cd", length));
			String[] fctryCtnt = (JSPUtil.getParameter(request, prefix	+ "fctry_ctnt", length));
			String[] invEdiD2Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_d2_qty", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] grsCbmCapa = (JSPUtil.getParameter(request, prefix	+ "grs_cbm_capa", length));
			String[] msgNo = (JSPUtil.getParameter(request, prefix	+ "msg_no", length));
			String[] issDt = (JSPUtil.getParameter(request, prefix	+ "iss_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] gerpCrrNm = (JSPUtil.getParameter(request, prefix	+ "gerp_crr_nm", length));
			String[] grsCntrWgt = (JSPUtil.getParameter(request, prefix	+ "grs_cntr_wgt", length));
			String[] msgId = (JSPUtil.getParameter(request, prefix	+ "msg_id", length));
			String[] invEdiD5Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_d5_qty", length));
			String[] invEdiF4Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_f4_qty", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] sndFlg = (JSPUtil.getParameter(request, prefix	+ "snd_flg", length));
			String[] invEdiR2Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_r2_qty", length));
			String[] invEdiD7Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_d7_qty", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] gerpTrspCd = (JSPUtil.getParameter(request, prefix	+ "gerp_trsp_cd", length));
			String[] gerpTrspNm = (JSPUtil.getParameter(request, prefix	+ "gerp_trsp_nm", length));
			String[] obrdDt = (JSPUtil.getParameter(request, prefix	+ "obrd_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fctryNm = (JSPUtil.getParameter(request, prefix	+ "fctry_nm", length));
			String[] blLineNo = (JSPUtil.getParameter(request, prefix	+ "bl_line_no", length));
			String[] divCtnt = (JSPUtil.getParameter(request, prefix	+ "div_ctnt", length));
			String[] invEdiR4Qty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_r4_qty", length));
			String[] divNm = (JSPUtil.getParameter(request, prefix	+ "div_nm", length));
			String[] invEdiEtcQty = (JSPUtil.getParameter(request, prefix	+ "inv_edi_etc_qty", length));
			String[] blCntrGrpCtnt = (JSPUtil.getParameter(request, prefix	+ "bl_cntr_grp_ctnt", length));
			String[] srInvNoOrg = (JSPUtil.getParameter(request, prefix + "sr_inv_no_org", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamsungInvoiceEDIBLVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (srInvNo[i] != null)
					model.setSrInvNo(srInvNo[i]);
				if (invEdiD4Qty[i] != null)
					model.setInvEdiD4Qty(invEdiD4Qty[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (gerpCrrCd[i] != null)
					model.setGerpCrrCd(gerpCrrCd[i]);
				if (fctryCtnt[i] != null)
					model.setFctryCtnt(fctryCtnt[i]);
				if (invEdiD2Qty[i] != null)
					model.setInvEdiD2Qty(invEdiD2Qty[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (grsCbmCapa[i] != null)
					model.setGrsCbmCapa(grsCbmCapa[i]);
				if (msgNo[i] != null)
					model.setMsgNo(msgNo[i]);
				if (issDt[i] != null)
					model.setIssDt(issDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (gerpCrrNm[i] != null)
					model.setGerpCrrNm(gerpCrrNm[i]);
				if (grsCntrWgt[i] != null)
					model.setGrsCntrWgt(grsCntrWgt[i]);
				if (msgId[i] != null)
					model.setMsgId(msgId[i]);
				if (invEdiD5Qty[i] != null)
					model.setInvEdiD5Qty(invEdiD5Qty[i]);
				if (invEdiF4Qty[i] != null)
					model.setInvEdiF4Qty(invEdiF4Qty[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (sndFlg[i] != null)
					model.setSndFlg(sndFlg[i]);
				if (invEdiR2Qty[i] != null)
					model.setInvEdiR2Qty(invEdiR2Qty[i]);
				if (invEdiD7Qty[i] != null)
					model.setInvEdiD7Qty(invEdiD7Qty[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (gerpTrspCd[i] != null)
					model.setGerpTrspCd(gerpTrspCd[i]);
				if (gerpTrspNm[i] != null)
					model.setGerpTrspNm(gerpTrspNm[i]);
				if (obrdDt[i] != null)
					model.setObrdDt(obrdDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fctryNm[i] != null)
					model.setFctryNm(fctryNm[i]);
				if (blLineNo[i] != null)
					model.setBlLineNo(blLineNo[i]);
				if (divCtnt[i] != null)
					model.setDivCtnt(divCtnt[i]);
				if (invEdiR4Qty[i] != null)
					model.setInvEdiR4Qty(invEdiR4Qty[i]);
				if (divNm[i] != null)
					model.setDivNm(divNm[i]);
				if (invEdiEtcQty[i] != null)
					model.setInvEdiEtcQty(invEdiEtcQty[i]);
				if (blCntrGrpCtnt[i] != null)
					model.setBlCntrGrpCtnt(blCntrGrpCtnt[i]);
				if (srInvNoOrg[i] != null)
					model.setSrInvNoOrg(srInvNoOrg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamsungInvoiceEDIBLVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamsungInvoiceEDIBLVO[]
	 */
	public SamsungInvoiceEDIBLVO[] getSamsungInvoiceEDIBLVOs(){
		SamsungInvoiceEDIBLVO[] vos = (SamsungInvoiceEDIBLVO[])models.toArray(new SamsungInvoiceEDIBLVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srInvNo = this.srInvNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiD4Qty = this.invEdiD4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gerpCrrCd = this.gerpCrrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctryCtnt = this.fctryCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiD2Qty = this.invEdiD2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsCbmCapa = this.grsCbmCapa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgNo = this.msgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt = this.issDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gerpCrrNm = this.gerpCrrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsCntrWgt = this.grsCntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgId = this.msgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiD5Qty = this.invEdiD5Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiF4Qty = this.invEdiF4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndFlg = this.sndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiR2Qty = this.invEdiR2Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiD7Qty = this.invEdiD7Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gerpTrspCd = this.gerpTrspCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gerpTrspNm = this.gerpTrspNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obrdDt = this.obrdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fctryNm = this.fctryNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blLineNo = this.blLineNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divCtnt = this.divCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiR4Qty = this.invEdiR4Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.divNm = this.divNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiEtcQty = this.invEdiEtcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCntrGrpCtnt = this.blCntrGrpCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srInvNoOrg = this.srInvNoOrg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
