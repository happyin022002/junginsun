/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SupplementSearchVO.java
*@FileTitle : SupplementSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.28  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.supplementsomanage.supplementsomanage.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SupplementSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SupplementSearchVO> models = new ArrayList<SupplementSearchVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String trspSoSeq = null;
	/* Column Info */
	private String hidTpSz = null;
	/* Column Info */
	private String hidToNode = null;
	/* Column Info */
	private String hidViaNode = null;
	/* Column Info */
	private String refId = null;
	/* Column Info */
	private String hidTransmode = null;
	/* Column Info */
	private String wonumber = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String trspSoOfcCtyCd = null;
	/* Column Info */
	private String formUsrOfcCd = null;
	/* Column Info */
	private String refnumber = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hidFromNode = null;
	/* Column Info */
	private String eqnumber = null;
	/* Column Info */
	private String hidBoundmode = null;
	/* Column Info */
	private String invnumber = null;
	/* Column Info */
	private String bkgnumber = null;
	/* Column Info */
	private String hidCostmode = null;
	/* Column Info */
	private String vvdnumber = null;
	/* Column Info */
	private String formCreUsrId = null;
	/* Column Info */
	private String hidEqRadio = null;
	/* Column Info */
	private String hidKind = null;
	/* Column Info */
	private String trspWoSeq = null;
	/* Column Info */
	private String trunkvvd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String hidPeriod = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String trspWoOfcCtyCd = null;
	/* Column Info */
	private String hidProvider = null;
	/* Column Info */
	private String hidDorNode = null;
	/* Column Info */
	private String refSeq = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String sonumber = null;
	/* Column Info */
	private String blnumber = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SupplementSearchVO() {}

	public SupplementSearchVO(String ibflag, String pagerows, String sonumber, String wonumber, String bkgnumber, String blnumber, String eqnumber, String vvdnumber, String refnumber, String invnumber, String vslCd, String skdVoyNo, String skdDirCd, String refId, String refSeq, String trspSoOfcCtyCd, String trspSoSeq, String trspWoOfcCtyCd, String trspWoSeq, String fromDate, String toDate, String hidBoundmode, String hidCostmode, String hidTransmode, String hidProvider, String hidFromNode, String hidViaNode, String hidToNode, String hidDorNode, String hidKind, String hidEqRadio, String hidPeriod, String hidTpSz, String trunkvvd, String formUsrOfcCd, String formCreUsrId) {
		this.vslCd = vslCd;
		this.trspSoSeq = trspSoSeq;
		this.hidTpSz = hidTpSz;
		this.hidToNode = hidToNode;
		this.hidViaNode = hidViaNode;
		this.refId = refId;
		this.hidTransmode = hidTransmode;
		this.wonumber = wonumber;
		this.pagerows = pagerows;
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
		this.formUsrOfcCd = formUsrOfcCd;
		this.refnumber = refnumber;
		this.ibflag = ibflag;
		this.hidFromNode = hidFromNode;
		this.eqnumber = eqnumber;
		this.hidBoundmode = hidBoundmode;
		this.invnumber = invnumber;
		this.bkgnumber = bkgnumber;
		this.hidCostmode = hidCostmode;
		this.vvdnumber = vvdnumber;
		this.formCreUsrId = formCreUsrId;
		this.hidEqRadio = hidEqRadio;
		this.hidKind = hidKind;
		this.trspWoSeq = trspWoSeq;
		this.trunkvvd = trunkvvd;
		this.skdVoyNo = skdVoyNo;
		this.toDate = toDate;
		this.hidPeriod = hidPeriod;
		this.skdDirCd = skdDirCd;
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
		this.hidProvider = hidProvider;
		this.hidDorNode = hidDorNode;
		this.refSeq = refSeq;
		this.fromDate = fromDate;
		this.sonumber = sonumber;
		this.blnumber = blnumber;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("trsp_so_seq", getTrspSoSeq());
		this.hashColumns.put("hid_tp_sz", getHidTpSz());
		this.hashColumns.put("hid_to_node", getHidToNode());
		this.hashColumns.put("hid_via_node", getHidViaNode());
		this.hashColumns.put("ref_id", getRefId());
		this.hashColumns.put("hid_transmode", getHidTransmode());
		this.hashColumns.put("wonumber", getWonumber());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("trsp_so_ofc_cty_cd", getTrspSoOfcCtyCd());
		this.hashColumns.put("form_usr_ofc_cd", getFormUsrOfcCd());
		this.hashColumns.put("refnumber", getRefnumber());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hid_from_node", getHidFromNode());
		this.hashColumns.put("eqnumber", getEqnumber());
		this.hashColumns.put("hid_boundmode", getHidBoundmode());
		this.hashColumns.put("invnumber", getInvnumber());
		this.hashColumns.put("bkgnumber", getBkgnumber());
		this.hashColumns.put("hid_costmode", getHidCostmode());
		this.hashColumns.put("vvdnumber", getVvdnumber());
		this.hashColumns.put("form_cre_usr_id", getFormCreUsrId());
		this.hashColumns.put("hid_eq_radio", getHidEqRadio());
		this.hashColumns.put("hid_kind", getHidKind());
		this.hashColumns.put("trsp_wo_seq", getTrspWoSeq());
		this.hashColumns.put("trunkvvd", getTrunkvvd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("hid_period", getHidPeriod());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("trsp_wo_ofc_cty_cd", getTrspWoOfcCtyCd());
		this.hashColumns.put("hid_provider", getHidProvider());
		this.hashColumns.put("hid_dor_node", getHidDorNode());
		this.hashColumns.put("ref_seq", getRefSeq());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("sonumber", getSonumber());
		this.hashColumns.put("blnumber", getBlnumber());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("trsp_so_seq", "trspSoSeq");
		this.hashFields.put("hid_tp_sz", "hidTpSz");
		this.hashFields.put("hid_to_node", "hidToNode");
		this.hashFields.put("hid_via_node", "hidViaNode");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("hid_transmode", "hidTransmode");
		this.hashFields.put("wonumber", "wonumber");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("trsp_so_ofc_cty_cd", "trspSoOfcCtyCd");
		this.hashFields.put("form_usr_ofc_cd", "formUsrOfcCd");
		this.hashFields.put("refnumber", "refnumber");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hid_from_node", "hidFromNode");
		this.hashFields.put("eqnumber", "eqnumber");
		this.hashFields.put("hid_boundmode", "hidBoundmode");
		this.hashFields.put("invnumber", "invnumber");
		this.hashFields.put("bkgnumber", "bkgnumber");
		this.hashFields.put("hid_costmode", "hidCostmode");
		this.hashFields.put("vvdnumber", "vvdnumber");
		this.hashFields.put("form_cre_usr_id", "formCreUsrId");
		this.hashFields.put("hid_eq_radio", "hidEqRadio");
		this.hashFields.put("hid_kind", "hidKind");
		this.hashFields.put("trsp_wo_seq", "trspWoSeq");
		this.hashFields.put("trunkvvd", "trunkvvd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("hid_period", "hidPeriod");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("trsp_wo_ofc_cty_cd", "trspWoOfcCtyCd");
		this.hashFields.put("hid_provider", "hidProvider");
		this.hashFields.put("hid_dor_node", "hidDorNode");
		this.hashFields.put("ref_seq", "refSeq");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("sonumber", "sonumber");
		this.hashFields.put("blnumber", "blnumber");
		return this.hashFields;
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
	 * @return trspSoSeq
	 */
	public String getTrspSoSeq() {
		return this.trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @return hidTpSz
	 */
	public String getHidTpSz() {
		return this.hidTpSz;
	}
	
	/**
	 * Column Info
	 * @return hidToNode
	 */
	public String getHidToNode() {
		return this.hidToNode;
	}
	
	/**
	 * Column Info
	 * @return hidViaNode
	 */
	public String getHidViaNode() {
		return this.hidViaNode;
	}
	
	/**
	 * Column Info
	 * @return refId
	 */
	public String getRefId() {
		return this.refId;
	}
	
	/**
	 * Column Info
	 * @return hidTransmode
	 */
	public String getHidTransmode() {
		return this.hidTransmode;
	}
	
	/**
	 * Column Info
	 * @return wonumber
	 */
	public String getWonumber() {
		return this.wonumber;
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
	 * @return trspSoOfcCtyCd
	 */
	public String getTrspSoOfcCtyCd() {
		return this.trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return formUsrOfcCd
	 */
	public String getFormUsrOfcCd() {
		return this.formUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return refnumber
	 */
	public String getRefnumber() {
		return this.refnumber;
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
	 * @return hidFromNode
	 */
	public String getHidFromNode() {
		return this.hidFromNode;
	}
	
	/**
	 * Column Info
	 * @return eqnumber
	 */
	public String getEqnumber() {
		return this.eqnumber;
	}
	
	/**
	 * Column Info
	 * @return hidBoundmode
	 */
	public String getHidBoundmode() {
		return this.hidBoundmode;
	}
	
	/**
	 * Column Info
	 * @return invnumber
	 */
	public String getInvnumber() {
		return this.invnumber;
	}
	
	/**
	 * Column Info
	 * @return bkgnumber
	 */
	public String getBkgnumber() {
		return this.bkgnumber;
	}
	
	/**
	 * Column Info
	 * @return hidCostmode
	 */
	public String getHidCostmode() {
		return this.hidCostmode;
	}
	
	/**
	 * Column Info
	 * @return vvdnumber
	 */
	public String getVvdnumber() {
		return this.vvdnumber;
	}
	
	/**
	 * Column Info
	 * @return formCreUsrId
	 */
	public String getFormCreUsrId() {
		return this.formCreUsrId;
	}
	
	/**
	 * Column Info
	 * @return hidEqRadio
	 */
	public String getHidEqRadio() {
		return this.hidEqRadio;
	}
	
	/**
	 * Column Info
	 * @return hidKind
	 */
	public String getHidKind() {
		return this.hidKind;
	}
	
	/**
	 * Column Info
	 * @return trspWoSeq
	 */
	public String getTrspWoSeq() {
		return this.trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @return trunkvvd
	 */
	public String getTrunkvvd() {
		return this.trunkvvd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return hidPeriod
	 */
	public String getHidPeriod() {
		return this.hidPeriod;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	
	/**
	 * Column Info
	 * @return trspWoOfcCtyCd
	 */
	public String getTrspWoOfcCtyCd() {
		return this.trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @return hidProvider
	 */
	public String getHidProvider() {
		return this.hidProvider;
	}
	
	/**
	 * Column Info
	 * @return hidDorNode
	 */
	public String getHidDorNode() {
		return this.hidDorNode;
	}
	
	/**
	 * Column Info
	 * @return refSeq
	 */
	public String getRefSeq() {
		return this.refSeq;
	}
	
	/**
	 * Column Info
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return sonumber
	 */
	public String getSonumber() {
		return this.sonumber;
	}
	
	/**
	 * Column Info
	 * @return blnumber
	 */
	public String getBlnumber() {
		return this.blnumber;
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
	 * @param trspSoSeq
	 */
	public void setTrspSoSeq(String trspSoSeq) {
		this.trspSoSeq = trspSoSeq;
	}
	
	/**
	 * Column Info
	 * @param hidTpSz
	 */
	public void setHidTpSz(String hidTpSz) {
		this.hidTpSz = hidTpSz;
	}
	
	/**
	 * Column Info
	 * @param hidToNode
	 */
	public void setHidToNode(String hidToNode) {
		this.hidToNode = hidToNode;
	}
	
	/**
	 * Column Info
	 * @param hidViaNode
	 */
	public void setHidViaNode(String hidViaNode) {
		this.hidViaNode = hidViaNode;
	}
	
	/**
	 * Column Info
	 * @param refId
	 */
	public void setRefId(String refId) {
		this.refId = refId;
	}
	
	/**
	 * Column Info
	 * @param hidTransmode
	 */
	public void setHidTransmode(String hidTransmode) {
		this.hidTransmode = hidTransmode;
	}
	
	/**
	 * Column Info
	 * @param wonumber
	 */
	public void setWonumber(String wonumber) {
		this.wonumber = wonumber;
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
	 * @param trspSoOfcCtyCd
	 */
	public void setTrspSoOfcCtyCd(String trspSoOfcCtyCd) {
		this.trspSoOfcCtyCd = trspSoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param formUsrOfcCd
	 */
	public void setFormUsrOfcCd(String formUsrOfcCd) {
		this.formUsrOfcCd = formUsrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param refnumber
	 */
	public void setRefnumber(String refnumber) {
		this.refnumber = refnumber;
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
	 * @param hidFromNode
	 */
	public void setHidFromNode(String hidFromNode) {
		this.hidFromNode = hidFromNode;
	}
	
	/**
	 * Column Info
	 * @param eqnumber
	 */
	public void setEqnumber(String eqnumber) {
		this.eqnumber = eqnumber;
	}
	
	/**
	 * Column Info
	 * @param hidBoundmode
	 */
	public void setHidBoundmode(String hidBoundmode) {
		this.hidBoundmode = hidBoundmode;
	}
	
	/**
	 * Column Info
	 * @param invnumber
	 */
	public void setInvnumber(String invnumber) {
		this.invnumber = invnumber;
	}
	
	/**
	 * Column Info
	 * @param bkgnumber
	 */
	public void setBkgnumber(String bkgnumber) {
		this.bkgnumber = bkgnumber;
	}
	
	/**
	 * Column Info
	 * @param hidCostmode
	 */
	public void setHidCostmode(String hidCostmode) {
		this.hidCostmode = hidCostmode;
	}
	
	/**
	 * Column Info
	 * @param vvdnumber
	 */
	public void setVvdnumber(String vvdnumber) {
		this.vvdnumber = vvdnumber;
	}
	
	/**
	 * Column Info
	 * @param formCreUsrId
	 */
	public void setFormCreUsrId(String formCreUsrId) {
		this.formCreUsrId = formCreUsrId;
	}
	
	/**
	 * Column Info
	 * @param hidEqRadio
	 */
	public void setHidEqRadio(String hidEqRadio) {
		this.hidEqRadio = hidEqRadio;
	}
	
	/**
	 * Column Info
	 * @param hidKind
	 */
	public void setHidKind(String hidKind) {
		this.hidKind = hidKind;
	}
	
	/**
	 * Column Info
	 * @param trspWoSeq
	 */
	public void setTrspWoSeq(String trspWoSeq) {
		this.trspWoSeq = trspWoSeq;
	}
	
	/**
	 * Column Info
	 * @param trunkvvd
	 */
	public void setTrunkvvd(String trunkvvd) {
		this.trunkvvd = trunkvvd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param hidPeriod
	 */
	public void setHidPeriod(String hidPeriod) {
		this.hidPeriod = hidPeriod;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * Column Info
	 * @param trspWoOfcCtyCd
	 */
	public void setTrspWoOfcCtyCd(String trspWoOfcCtyCd) {
		this.trspWoOfcCtyCd = trspWoOfcCtyCd;
	}
	
	/**
	 * Column Info
	 * @param hidProvider
	 */
	public void setHidProvider(String hidProvider) {
		this.hidProvider = hidProvider;
	}
	
	/**
	 * Column Info
	 * @param hidDorNode
	 */
	public void setHidDorNode(String hidDorNode) {
		this.hidDorNode = hidDorNode;
	}
	
	/**
	 * Column Info
	 * @param refSeq
	 */
	public void setRefSeq(String refSeq) {
		this.refSeq = refSeq;
	}
	
	/**
	 * Column Info
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param sonumber
	 */
	public void setSonumber(String sonumber) {
		this.sonumber = sonumber;
	}
	
	/**
	 * Column Info
	 * @param blnumber
	 */
	public void setBlnumber(String blnumber) {
		this.blnumber = blnumber;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setTrspSoSeq(JSPUtil.getParameter(request, "trsp_so_seq", ""));
		setHidTpSz(JSPUtil.getParameter(request, "hid_tp_sz", ""));
		setHidToNode(JSPUtil.getParameter(request, "hid_to_node", ""));
		setHidViaNode(JSPUtil.getParameter(request, "hid_via_node", ""));
		setRefId(JSPUtil.getParameter(request, "ref_id", ""));
		setHidTransmode(JSPUtil.getParameter(request, "hid_transmode", ""));
		setWonumber(JSPUtil.getParameter(request, "wonumber", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setTrspSoOfcCtyCd(JSPUtil.getParameter(request, "trsp_so_ofc_cty_cd", ""));
		setFormUsrOfcCd(JSPUtil.getParameter(request, "form_usr_ofc_cd", ""));
		setRefnumber(JSPUtil.getParameter(request, "refnumber", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setHidFromNode(JSPUtil.getParameter(request, "hid_from_node", ""));
		setEqnumber(JSPUtil.getParameter(request, "eqnumber", ""));
		setHidBoundmode(JSPUtil.getParameter(request, "hid_boundmode", ""));
		setInvnumber(JSPUtil.getParameter(request, "invnumber", ""));
		setBkgnumber(JSPUtil.getParameter(request, "bkgnumber", ""));
		setHidCostmode(JSPUtil.getParameter(request, "hid_costmode", ""));
		setVvdnumber(JSPUtil.getParameter(request, "vvdnumber", ""));
		setFormCreUsrId(JSPUtil.getParameter(request, "form_cre_usr_id", ""));
		setHidEqRadio(JSPUtil.getParameter(request, "hid_eq_radio", ""));
		setHidKind(JSPUtil.getParameter(request, "hid_kind", ""));
		setTrspWoSeq(JSPUtil.getParameter(request, "trsp_wo_seq", ""));
		setTrunkvvd(JSPUtil.getParameter(request, "trunkvvd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setToDate(JSPUtil.getParameter(request, "to_date", ""));
		setHidPeriod(JSPUtil.getParameter(request, "hid_period", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setTrspWoOfcCtyCd(JSPUtil.getParameter(request, "trsp_wo_ofc_cty_cd", ""));
		setHidProvider(JSPUtil.getParameter(request, "hid_provider", ""));
		setHidDorNode(JSPUtil.getParameter(request, "hid_dor_node", ""));
		setRefSeq(JSPUtil.getParameter(request, "ref_seq", ""));
		setFromDate(JSPUtil.getParameter(request, "from_date", ""));
		setSonumber(JSPUtil.getParameter(request, "sonumber", ""));
		setBlnumber(JSPUtil.getParameter(request, "blnumber", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SupplementSearchVO[]
	 */
	public SupplementSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SupplementSearchVO[]
	 */
	public SupplementSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SupplementSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] trspSoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_so_seq", length));
			String[] hidTpSz = (JSPUtil.getParameter(request, prefix	+ "hid_tp_sz", length));
			String[] hidToNode = (JSPUtil.getParameter(request, prefix	+ "hid_to_node", length));
			String[] hidViaNode = (JSPUtil.getParameter(request, prefix	+ "hid_via_node", length));
			String[] refId = (JSPUtil.getParameter(request, prefix	+ "ref_id", length));
			String[] hidTransmode = (JSPUtil.getParameter(request, prefix	+ "hid_transmode", length));
			String[] wonumber = (JSPUtil.getParameter(request, prefix	+ "wonumber", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] trspSoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_so_ofc_cty_cd", length));
			String[] formUsrOfcCd = (JSPUtil.getParameter(request, prefix	+ "form_usr_ofc_cd", length));
			String[] refnumber = (JSPUtil.getParameter(request, prefix	+ "refnumber", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hidFromNode = (JSPUtil.getParameter(request, prefix	+ "hid_from_node", length));
			String[] eqnumber = (JSPUtil.getParameter(request, prefix	+ "eqnumber", length));
			String[] hidBoundmode = (JSPUtil.getParameter(request, prefix	+ "hid_boundmode", length));
			String[] invnumber = (JSPUtil.getParameter(request, prefix	+ "invnumber", length));
			String[] bkgnumber = (JSPUtil.getParameter(request, prefix	+ "bkgnumber", length));
			String[] hidCostmode = (JSPUtil.getParameter(request, prefix	+ "hid_costmode", length));
			String[] vvdnumber = (JSPUtil.getParameter(request, prefix	+ "vvdnumber", length));
			String[] formCreUsrId = (JSPUtil.getParameter(request, prefix	+ "form_cre_usr_id", length));
			String[] hidEqRadio = (JSPUtil.getParameter(request, prefix	+ "hid_eq_radio", length));
			String[] hidKind = (JSPUtil.getParameter(request, prefix	+ "hid_kind", length));
			String[] trspWoSeq = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_seq", length));
			String[] trunkvvd = (JSPUtil.getParameter(request, prefix	+ "trunkvvd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] hidPeriod = (JSPUtil.getParameter(request, prefix	+ "hid_period", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] trspWoOfcCtyCd = (JSPUtil.getParameter(request, prefix	+ "trsp_wo_ofc_cty_cd", length));
			String[] hidProvider = (JSPUtil.getParameter(request, prefix	+ "hid_provider", length));
			String[] hidDorNode = (JSPUtil.getParameter(request, prefix	+ "hid_dor_node", length));
			String[] refSeq = (JSPUtil.getParameter(request, prefix	+ "ref_seq", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] sonumber = (JSPUtil.getParameter(request, prefix	+ "sonumber", length));
			String[] blnumber = (JSPUtil.getParameter(request, prefix	+ "blnumber", length));
			
			for (int i = 0; i < length; i++) {
				model = new SupplementSearchVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (trspSoSeq[i] != null)
					model.setTrspSoSeq(trspSoSeq[i]);
				if (hidTpSz[i] != null)
					model.setHidTpSz(hidTpSz[i]);
				if (hidToNode[i] != null)
					model.setHidToNode(hidToNode[i]);
				if (hidViaNode[i] != null)
					model.setHidViaNode(hidViaNode[i]);
				if (refId[i] != null)
					model.setRefId(refId[i]);
				if (hidTransmode[i] != null)
					model.setHidTransmode(hidTransmode[i]);
				if (wonumber[i] != null)
					model.setWonumber(wonumber[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (trspSoOfcCtyCd[i] != null)
					model.setTrspSoOfcCtyCd(trspSoOfcCtyCd[i]);
				if (formUsrOfcCd[i] != null)
					model.setFormUsrOfcCd(formUsrOfcCd[i]);
				if (refnumber[i] != null)
					model.setRefnumber(refnumber[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hidFromNode[i] != null)
					model.setHidFromNode(hidFromNode[i]);
				if (eqnumber[i] != null)
					model.setEqnumber(eqnumber[i]);
				if (hidBoundmode[i] != null)
					model.setHidBoundmode(hidBoundmode[i]);
				if (invnumber[i] != null)
					model.setInvnumber(invnumber[i]);
				if (bkgnumber[i] != null)
					model.setBkgnumber(bkgnumber[i]);
				if (hidCostmode[i] != null)
					model.setHidCostmode(hidCostmode[i]);
				if (vvdnumber[i] != null)
					model.setVvdnumber(vvdnumber[i]);
				if (formCreUsrId[i] != null)
					model.setFormCreUsrId(formCreUsrId[i]);
				if (hidEqRadio[i] != null)
					model.setHidEqRadio(hidEqRadio[i]);
				if (hidKind[i] != null)
					model.setHidKind(hidKind[i]);
				if (trspWoSeq[i] != null)
					model.setTrspWoSeq(trspWoSeq[i]);
				if (trunkvvd[i] != null)
					model.setTrunkvvd(trunkvvd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (hidPeriod[i] != null)
					model.setHidPeriod(hidPeriod[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (trspWoOfcCtyCd[i] != null)
					model.setTrspWoOfcCtyCd(trspWoOfcCtyCd[i]);
				if (hidProvider[i] != null)
					model.setHidProvider(hidProvider[i]);
				if (hidDorNode[i] != null)
					model.setHidDorNode(hidDorNode[i]);
				if (refSeq[i] != null)
					model.setRefSeq(refSeq[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (sonumber[i] != null)
					model.setSonumber(sonumber[i]);
				if (blnumber[i] != null)
					model.setBlnumber(blnumber[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSupplementSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SupplementSearchVO[]
	 */
	public SupplementSearchVO[] getSupplementSearchVOs(){
		SupplementSearchVO[] vos = (SupplementSearchVO[])models.toArray(new SupplementSearchVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoSeq = this.trspSoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidTpSz = this.hidTpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidToNode = this.hidToNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidViaNode = this.hidViaNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId = this.refId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidTransmode = this.hidTransmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wonumber = this.wonumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoOfcCtyCd = this.trspSoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formUsrOfcCd = this.formUsrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refnumber = this.refnumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFromNode = this.hidFromNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqnumber = this.eqnumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidBoundmode = this.hidBoundmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invnumber = this.invnumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnumber = this.bkgnumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidCostmode = this.hidCostmode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdnumber = this.vvdnumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.formCreUsrId = this.formCreUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidEqRadio = this.hidEqRadio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidKind = this.hidKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoSeq = this.trspWoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkvvd = this.trunkvvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidPeriod = this.hidPeriod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspWoOfcCtyCd = this.trspWoOfcCtyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidProvider = this.hidProvider .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidDorNode = this.hidDorNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refSeq = this.refSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sonumber = this.sonumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnumber = this.blnumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
