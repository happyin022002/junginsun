/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SingleTransportationSOManageSearchVO.java
*@FileTitle : SingleTransportationSOManageSearchVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.26
*@LastModifier : 손은주(TRS)
*@LastVersion : 1.0
* 2010.01.26 손은주(TRS) 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo;

import java.lang.reflect.Field;
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
 * @author 손은주(TRS)
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SingleTransportationSOManageSearchVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SingleTransportationSOManageSearchVO> models = new ArrayList<SingleTransportationSOManageSearchVO>();
	
	/* Column Info */
	private String frmYard = null;
	/* Column Info */
	private String hidCntrNo = null;
	/* Column Info */
	private String hidTrspCostModCd = null;
	/* Column Info */
	private String hidToYardCd = null;
	/* Column Info */
	private String toNode = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNoVerify = null;
	/* Column Info */
	private String chkOffice = null;
	/* Column Info */
	private String oldOfcCd = null;
	/* Column Info */
	private String hidFrmreqdate = null;
	/* Column Info */
	private String ctrlUserId = null;
	/* Column Info */
	private String cbstatus = null;
	/* Column Info */
	private String selKind = null;
	/* Column Info */
	private String trspSoEqKind = null;
	/* Column Info */
	private String hidFmNodCd = null;
	/* Column Info */
	private String hidEqTpszCd = null;
	/* Column Info */
	private String ctrlSoOffice = null;
	/* Column Info */
	private String frmNodeVerify = null;
	/* Column Info */
	private String hidTrspCrrModCd = null;
	/* Column Info */
	private String hidToreqdate = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String frmReqdate = null;
	/* Column Info */
	private String hidCntrTpszCd = null;
	/* Column Info */
	private String toYard = null;
	/* Column Info */
	private String cntrType = null;
	/* Column Info */
	private String cntrSize = null;
	/* Column Info */
	private String frmNode = null;
	/* Column Info */
	private String hidToNodCd = null;
	/* Column Info */
	private String hidFmYardCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String hidRefId = null;
	/* Column Info */
	private String referenceNo = null;
	/* Column Info */
	private String toReqdate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SingleTransportationSOManageSearchVO() {}

	public SingleTransportationSOManageSearchVO(String ibflag, String pagerows, String hidFrmreqdate, String hidToreqdate, String frmReqdate, String toReqdate, String selKind, String ctrlSoOffice, String chkOffice, String frmNode, String frmYard, String toNode, String toYard, String cntrType, String cntrSize, String referenceNo, String cntrNo, String hidRefId, String hidFmNodCd, String hidToNodCd, String hidFmYardCd, String hidToYardCd, String hidEqTpszCd, String hidTrspCostModCd, String hidTrspCrrModCd, String hidCntrNo, String hidCntrTpszCd, String ctrlOfcCd, String ctrlUserId, String trspSoEqKind, String eqNoVerify, String frmNodeVerify, String oldOfcCd, String cbstatus) {
		this.frmYard = frmYard;
		this.hidCntrNo = hidCntrNo;
		this.hidTrspCostModCd = hidTrspCostModCd;
		this.hidToYardCd = hidToYardCd;
		this.toNode = toNode;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.eqNoVerify = eqNoVerify;
		this.chkOffice = chkOffice;
		this.oldOfcCd = oldOfcCd;
		this.hidFrmreqdate = hidFrmreqdate;
		this.ctrlUserId = ctrlUserId;
		this.cbstatus = cbstatus;
		this.selKind = selKind;
		this.trspSoEqKind = trspSoEqKind;
		this.hidFmNodCd = hidFmNodCd;
		this.hidEqTpszCd = hidEqTpszCd;
		this.ctrlSoOffice = ctrlSoOffice;
		this.frmNodeVerify = frmNodeVerify;
		this.hidTrspCrrModCd = hidTrspCrrModCd;
		this.hidToreqdate = hidToreqdate;
		this.ctrlOfcCd = ctrlOfcCd;
		this.frmReqdate = frmReqdate;
		this.hidCntrTpszCd = hidCntrTpszCd;
		this.toYard = toYard;
		this.cntrType = cntrType;
		this.cntrSize = cntrSize;
		this.frmNode = frmNode;
		this.hidToNodCd = hidToNodCd;
		this.hidFmYardCd = hidFmYardCd;
		this.cntrNo = cntrNo;
		this.hidRefId = hidRefId;
		this.referenceNo = referenceNo;
		this.toReqdate = toReqdate;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_yard", getFrmYard());
		this.hashColumns.put("hid_cntr_no", getHidCntrNo());
		this.hashColumns.put("hid_trsp_cost_mod_cd", getHidTrspCostModCd());
		this.hashColumns.put("hid_to_yard_cd", getHidToYardCd());
		this.hashColumns.put("to_node", getToNode());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no_verify", getEqNoVerify());
		this.hashColumns.put("chk_office", getChkOffice());
		this.hashColumns.put("old_ofc_cd", getOldOfcCd());
		this.hashColumns.put("hid_frmreqdate", getHidFrmreqdate());
		this.hashColumns.put("ctrl_user_id", getCtrlUserId());
		this.hashColumns.put("cbstatus", getCbstatus());
		this.hashColumns.put("sel_kind", getSelKind());
		this.hashColumns.put("trsp_so_eq_kind", getTrspSoEqKind());
		this.hashColumns.put("hid_fm_nod_cd", getHidFmNodCd());
		this.hashColumns.put("hid_eq_tpsz_cd", getHidEqTpszCd());
		this.hashColumns.put("ctrl_so_office", getCtrlSoOffice());
		this.hashColumns.put("frm_node_verify", getFrmNodeVerify());
		this.hashColumns.put("hid_trsp_crr_mod_cd", getHidTrspCrrModCd());
		this.hashColumns.put("hid_toreqdate", getHidToreqdate());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("frm_reqdate", getFrmReqdate());
		this.hashColumns.put("hid_cntr_tpsz_cd", getHidCntrTpszCd());
		this.hashColumns.put("to_yard", getToYard());
		this.hashColumns.put("cntr_type", getCntrType());
		this.hashColumns.put("cntr_size", getCntrSize());
		this.hashColumns.put("frm_node", getFrmNode());
		this.hashColumns.put("hid_to_nod_cd", getHidToNodCd());
		this.hashColumns.put("hid_fm_yard_cd", getHidFmYardCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("hid_ref_id", getHidRefId());
		this.hashColumns.put("reference_no", getReferenceNo());
		this.hashColumns.put("to_reqdate", getToReqdate());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_yard", "frmYard");
		this.hashFields.put("hid_cntr_no", "hidCntrNo");
		this.hashFields.put("hid_trsp_cost_mod_cd", "hidTrspCostModCd");
		this.hashFields.put("hid_to_yard_cd", "hidToYardCd");
		this.hashFields.put("to_node", "toNode");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no_verify", "eqNoVerify");
		this.hashFields.put("chk_office", "chkOffice");
		this.hashFields.put("old_ofc_cd", "oldOfcCd");
		this.hashFields.put("hid_frmreqdate", "hidFrmreqdate");
		this.hashFields.put("ctrl_user_id", "ctrlUserId");
		this.hashFields.put("cbstatus", "cbstatus");
		this.hashFields.put("sel_kind", "selKind");
		this.hashFields.put("trsp_so_eq_kind", "trspSoEqKind");
		this.hashFields.put("hid_fm_nod_cd", "hidFmNodCd");
		this.hashFields.put("hid_eq_tpsz_cd", "hidEqTpszCd");
		this.hashFields.put("ctrl_so_office", "ctrlSoOffice");
		this.hashFields.put("frm_node_verify", "frmNodeVerify");
		this.hashFields.put("hid_trsp_crr_mod_cd", "hidTrspCrrModCd");
		this.hashFields.put("hid_toreqdate", "hidToreqdate");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("frm_reqdate", "frmReqdate");
		this.hashFields.put("hid_cntr_tpsz_cd", "hidCntrTpszCd");
		this.hashFields.put("to_yard", "toYard");
		this.hashFields.put("cntr_type", "cntrType");
		this.hashFields.put("cntr_size", "cntrSize");
		this.hashFields.put("frm_node", "frmNode");
		this.hashFields.put("hid_to_nod_cd", "hidToNodCd");
		this.hashFields.put("hid_fm_yard_cd", "hidFmYardCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("hid_ref_id", "hidRefId");
		this.hashFields.put("reference_no", "referenceNo");
		this.hashFields.put("to_reqdate", "toReqdate");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frmYard
	 */
	public String getFrmYard() {
		return this.frmYard;
	}
	
	/**
	 * Column Info
	 * @return hidCntrNo
	 */
	public String getHidCntrNo() {
		return this.hidCntrNo;
	}
	
	/**
	 * Column Info
	 * @return hidTrspCostModCd
	 */
	public String getHidTrspCostModCd() {
		return this.hidTrspCostModCd;
	}
	
	/**
	 * Column Info
	 * @return hidToYardCd
	 */
	public String getHidToYardCd() {
		return this.hidToYardCd;
	}
	
	/**
	 * Column Info
	 * @return toNode
	 */
	public String getToNode() {
		return this.toNode;
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
	 * @return eqNoVerify
	 */
	public String getEqNoVerify() {
		return this.eqNoVerify;
	}
	
	/**
	 * Column Info
	 * @return chkOffice
	 */
	public String getChkOffice() {
		return this.chkOffice;
	}
	
	/**
	 * Column Info
	 * @return oldOfcCd
	 */
	public String getOldOfcCd() {
		return this.oldOfcCd;
	}
	
	/**
	 * Column Info
	 * @return hidFrmreqdate
	 */
	public String getHidFrmreqdate() {
		return this.hidFrmreqdate;
	}
	
	/**
	 * Column Info
	 * @return ctrlUserId
	 */
	public String getCtrlUserId() {
		return this.ctrlUserId;
	}
	
	/**
	 * Column Info
	 * @return cbstatus
	 */
	public String getCbstatus() {
		return this.cbstatus;
	}
	
	/**
	 * Column Info
	 * @return selKind
	 */
	public String getSelKind() {
		return this.selKind;
	}
	
	/**
	 * Column Info
	 * @return trspSoEqKind
	 */
	public String getTrspSoEqKind() {
		return this.trspSoEqKind;
	}
	
	/**
	 * Column Info
	 * @return hidFmNodCd
	 */
	public String getHidFmNodCd() {
		return this.hidFmNodCd;
	}
	
	/**
	 * Column Info
	 * @return hidEqTpszCd
	 */
	public String getHidEqTpszCd() {
		return this.hidEqTpszCd;
	}
	
	/**
	 * Column Info
	 * @return ctrlSoOffice
	 */
	public String getCtrlSoOffice() {
		return this.ctrlSoOffice;
	}
	
	/**
	 * Column Info
	 * @return frmNodeVerify
	 */
	public String getFrmNodeVerify() {
		return this.frmNodeVerify;
	}
	
	/**
	 * Column Info
	 * @return hidTrspCrrModCd
	 */
	public String getHidTrspCrrModCd() {
		return this.hidTrspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @return hidToreqdate
	 */
	public String getHidToreqdate() {
		return this.hidToreqdate;
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
	 * @return frmReqdate
	 */
	public String getFrmReqdate() {
		return this.frmReqdate;
	}
	
	/**
	 * Column Info
	 * @return hidCntrTpszCd
	 */
	public String getHidCntrTpszCd() {
		return this.hidCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return toYard
	 */
	public String getToYard() {
		return this.toYard;
	}
	
	/**
	 * Column Info
	 * @return cntrType
	 */
	public String getCntrType() {
		return this.cntrType;
	}
	
	/**
	 * Column Info
	 * @return cntrSize
	 */
	public String getCntrSize() {
		return this.cntrSize;
	}
	
	/**
	 * Column Info
	 * @return frmNode
	 */
	public String getFrmNode() {
		return this.frmNode;
	}
	
	/**
	 * Column Info
	 * @return hidToNodCd
	 */
	public String getHidToNodCd() {
		return this.hidToNodCd;
	}
	
	/**
	 * Column Info
	 * @return hidFmYardCd
	 */
	public String getHidFmYardCd() {
		return this.hidFmYardCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return hidRefId
	 */
	public String getHidRefId() {
		return this.hidRefId;
	}
	
	/**
	 * Column Info
	 * @return referenceNo
	 */
	public String getReferenceNo() {
		return this.referenceNo;
	}
	
	/**
	 * Column Info
	 * @return toReqdate
	 */
	public String getToReqdate() {
		return this.toReqdate;
	}
	

	/**
	 * Column Info
	 * @param frmYard
	 */
	public void setFrmYard(String frmYard) {
		this.frmYard = frmYard;
	}
	
	/**
	 * Column Info
	 * @param hidCntrNo
	 */
	public void setHidCntrNo(String hidCntrNo) {
		this.hidCntrNo = hidCntrNo;
	}
	
	/**
	 * Column Info
	 * @param hidTrspCostModCd
	 */
	public void setHidTrspCostModCd(String hidTrspCostModCd) {
		this.hidTrspCostModCd = hidTrspCostModCd;
	}
	
	/**
	 * Column Info
	 * @param hidToYardCd
	 */
	public void setHidToYardCd(String hidToYardCd) {
		this.hidToYardCd = hidToYardCd;
	}
	
	/**
	 * Column Info
	 * @param toNode
	 */
	public void setToNode(String toNode) {
		this.toNode = toNode;
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
	 * @param eqNoVerify
	 */
	public void setEqNoVerify(String eqNoVerify) {
		this.eqNoVerify = eqNoVerify;
	}
	
	/**
	 * Column Info
	 * @param chkOffice
	 */
	public void setChkOffice(String chkOffice) {
		this.chkOffice = chkOffice;
	}
	
	/**
	 * Column Info
	 * @param oldOfcCd
	 */
	public void setOldOfcCd(String oldOfcCd) {
		this.oldOfcCd = oldOfcCd;
	}
	
	/**
	 * Column Info
	 * @param hidFrmreqdate
	 */
	public void setHidFrmreqdate(String hidFrmreqdate) {
		this.hidFrmreqdate = hidFrmreqdate;
	}
	
	/**
	 * Column Info
	 * @param ctrlUserId
	 */
	public void setCtrlUserId(String ctrlUserId) {
		this.ctrlUserId = ctrlUserId;
	}
	
	/**
	 * Column Info
	 * @param cbstatus
	 */
	public void setCbstatus(String cbstatus) {
		this.cbstatus = cbstatus;
	}
	
	/**
	 * Column Info
	 * @param selKind
	 */
	public void setSelKind(String selKind) {
		this.selKind = selKind;
	}
	
	/**
	 * Column Info
	 * @param trspSoEqKind
	 */
	public void setTrspSoEqKind(String trspSoEqKind) {
		this.trspSoEqKind = trspSoEqKind;
	}
	
	/**
	 * Column Info
	 * @param hidFmNodCd
	 */
	public void setHidFmNodCd(String hidFmNodCd) {
		this.hidFmNodCd = hidFmNodCd;
	}
	
	/**
	 * Column Info
	 * @param hidEqTpszCd
	 */
	public void setHidEqTpszCd(String hidEqTpszCd) {
		this.hidEqTpszCd = hidEqTpszCd;
	}
	
	/**
	 * Column Info
	 * @param ctrlSoOffice
	 */
	public void setCtrlSoOffice(String ctrlSoOffice) {
		this.ctrlSoOffice = ctrlSoOffice;
	}
	
	/**
	 * Column Info
	 * @param frmNodeVerify
	 */
	public void setFrmNodeVerify(String frmNodeVerify) {
		this.frmNodeVerify = frmNodeVerify;
	}
	
	/**
	 * Column Info
	 * @param hidTrspCrrModCd
	 */
	public void setHidTrspCrrModCd(String hidTrspCrrModCd) {
		this.hidTrspCrrModCd = hidTrspCrrModCd;
	}
	
	/**
	 * Column Info
	 * @param hidToreqdate
	 */
	public void setHidToreqdate(String hidToreqdate) {
		this.hidToreqdate = hidToreqdate;
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
	 * @param frmReqdate
	 */
	public void setFrmReqdate(String frmReqdate) {
		this.frmReqdate = frmReqdate;
	}
	
	/**
	 * Column Info
	 * @param hidCntrTpszCd
	 */
	public void setHidCntrTpszCd(String hidCntrTpszCd) {
		this.hidCntrTpszCd = hidCntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param toYard
	 */
	public void setToYard(String toYard) {
		this.toYard = toYard;
	}
	
	/**
	 * Column Info
	 * @param cntrType
	 */
	public void setCntrType(String cntrType) {
		this.cntrType = cntrType;
	}
	
	/**
	 * Column Info
	 * @param cntrSize
	 */
	public void setCntrSize(String cntrSize) {
		this.cntrSize = cntrSize;
	}
	
	/**
	 * Column Info
	 * @param frmNode
	 */
	public void setFrmNode(String frmNode) {
		this.frmNode = frmNode;
	}
	
	/**
	 * Column Info
	 * @param hidToNodCd
	 */
	public void setHidToNodCd(String hidToNodCd) {
		this.hidToNodCd = hidToNodCd;
	}
	
	/**
	 * Column Info
	 * @param hidFmYardCd
	 */
	public void setHidFmYardCd(String hidFmYardCd) {
		this.hidFmYardCd = hidFmYardCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param hidRefId
	 */
	public void setHidRefId(String hidRefId) {
		this.hidRefId = hidRefId;
	}
	
	/**
	 * Column Info
	 * @param referenceNo
	 */
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	
	/**
	 * Column Info
	 * @param toReqdate
	 */
	public void setToReqdate(String toReqdate) {
		this.toReqdate = toReqdate;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFrmYard(JSPUtil.getParameter(request, "frm_yard", ""));
		setHidCntrNo(JSPUtil.getParameter(request, "hid_cntr_no", ""));
		setHidTrspCostModCd(JSPUtil.getParameter(request, "hid_trsp_cost_mod_cd", ""));
		setHidToYardCd(JSPUtil.getParameter(request, "hid_to_yard_cd", ""));
		setToNode(JSPUtil.getParameter(request, "to_node", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqNoVerify(JSPUtil.getParameter(request, "eq_no_verify", ""));
		setChkOffice(JSPUtil.getParameter(request, "chk_office", ""));
		setOldOfcCd(JSPUtil.getParameter(request, "old_ofc_cd", ""));
		setHidFrmreqdate(JSPUtil.getParameter(request, "hid_frmreqdate", ""));
		setCtrlUserId(JSPUtil.getParameter(request, "ctrl_user_id", ""));
		setCbstatus(JSPUtil.getParameter(request, "cbstatus", ""));
		setSelKind(JSPUtil.getParameter(request, "sel_kind", ""));
		setTrspSoEqKind(JSPUtil.getParameter(request, "trsp_so_eq_kind", ""));
		setHidFmNodCd(JSPUtil.getParameter(request, "hid_fm_nod_cd", ""));
		setHidEqTpszCd(JSPUtil.getParameter(request, "hid_eq_tpsz_cd", ""));
		setCtrlSoOffice(JSPUtil.getParameter(request, "ctrl_so_office", ""));
		setFrmNodeVerify(JSPUtil.getParameter(request, "frm_node_verify", ""));
		setHidTrspCrrModCd(JSPUtil.getParameter(request, "hid_trsp_crr_mod_cd", ""));
		setHidToreqdate(JSPUtil.getParameter(request, "hid_toreqdate", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, "ctrl_ofc_cd", ""));
		setFrmReqdate(JSPUtil.getParameter(request, "frm_reqdate", ""));
		setHidCntrTpszCd(JSPUtil.getParameter(request, "hid_cntr_tpsz_cd", ""));
		setToYard(JSPUtil.getParameter(request, "to_yard", ""));
		setCntrType(JSPUtil.getParameter(request, "cntr_type", ""));
		setCntrSize(JSPUtil.getParameter(request, "cntr_size", ""));
		setFrmNode(JSPUtil.getParameter(request, "frm_node", ""));
		setHidToNodCd(JSPUtil.getParameter(request, "hid_to_nod_cd", ""));
		setHidFmYardCd(JSPUtil.getParameter(request, "hid_fm_yard_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setHidRefId(JSPUtil.getParameter(request, "hid_ref_id", ""));
		setReferenceNo(JSPUtil.getParameter(request, "reference_no", ""));
		setToReqdate(JSPUtil.getParameter(request, "to_reqdate", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SingleTransportationSOManageSearchVO[]
	 */
	public SingleTransportationSOManageSearchVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SingleTransportationSOManageSearchVO[]
	 */
	public SingleTransportationSOManageSearchVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SingleTransportationSOManageSearchVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmYard = (JSPUtil.getParameter(request, prefix	+ "frm_yard", length));
			String[] hidCntrNo = (JSPUtil.getParameter(request, prefix	+ "hid_cntr_no", length));
			String[] hidTrspCostModCd = (JSPUtil.getParameter(request, prefix	+ "hid_trsp_cost_mod_cd", length));
			String[] hidToYardCd = (JSPUtil.getParameter(request, prefix	+ "hid_to_yard_cd", length));
			String[] toNode = (JSPUtil.getParameter(request, prefix	+ "to_node", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNoVerify = (JSPUtil.getParameter(request, prefix	+ "eq_no_verify", length));
			String[] chkOffice = (JSPUtil.getParameter(request, prefix	+ "chk_office", length));
			String[] oldOfcCd = (JSPUtil.getParameter(request, prefix	+ "old_ofc_cd", length));
			String[] hidFrmreqdate = (JSPUtil.getParameter(request, prefix	+ "hid_frmreqdate", length));
			String[] ctrlUserId = (JSPUtil.getParameter(request, prefix	+ "ctrl_user_id", length));
			String[] cbstatus = (JSPUtil.getParameter(request, prefix	+ "cbstatus", length));
			String[] selKind = (JSPUtil.getParameter(request, prefix	+ "sel_kind", length));
			String[] trspSoEqKind = (JSPUtil.getParameter(request, prefix	+ "trsp_so_eq_kind", length));
			String[] hidFmNodCd = (JSPUtil.getParameter(request, prefix	+ "hid_fm_nod_cd", length));
			String[] hidEqTpszCd = (JSPUtil.getParameter(request, prefix	+ "hid_eq_tpsz_cd", length));
			String[] ctrlSoOffice = (JSPUtil.getParameter(request, prefix	+ "ctrl_so_office", length));
			String[] frmNodeVerify = (JSPUtil.getParameter(request, prefix	+ "frm_node_verify", length));
			String[] hidTrspCrrModCd = (JSPUtil.getParameter(request, prefix	+ "hid_trsp_crr_mod_cd", length));
			String[] hidToreqdate = (JSPUtil.getParameter(request, prefix	+ "hid_toreqdate", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] frmReqdate = (JSPUtil.getParameter(request, prefix	+ "frm_reqdate", length));
			String[] hidCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "hid_cntr_tpsz_cd", length));
			String[] toYard = (JSPUtil.getParameter(request, prefix	+ "to_yard", length));
			String[] cntrType = (JSPUtil.getParameter(request, prefix	+ "cntr_type", length));
			String[] cntrSize = (JSPUtil.getParameter(request, prefix	+ "cntr_size", length));
			String[] frmNode = (JSPUtil.getParameter(request, prefix	+ "frm_node", length));
			String[] hidToNodCd = (JSPUtil.getParameter(request, prefix	+ "hid_to_nod_cd", length));
			String[] hidFmYardCd = (JSPUtil.getParameter(request, prefix	+ "hid_fm_yard_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] hidRefId = (JSPUtil.getParameter(request, prefix	+ "hid_ref_id", length));
			String[] referenceNo = (JSPUtil.getParameter(request, prefix	+ "reference_no", length));
			String[] toReqdate = (JSPUtil.getParameter(request, prefix	+ "to_reqdate", length));
			
			for (int i = 0; i < length; i++) {
				model = new SingleTransportationSOManageSearchVO();
				if (frmYard[i] != null)
					model.setFrmYard(frmYard[i]);
				if (hidCntrNo[i] != null)
					model.setHidCntrNo(hidCntrNo[i]);
				if (hidTrspCostModCd[i] != null)
					model.setHidTrspCostModCd(hidTrspCostModCd[i]);
				if (hidToYardCd[i] != null)
					model.setHidToYardCd(hidToYardCd[i]);
				if (toNode[i] != null)
					model.setToNode(toNode[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNoVerify[i] != null)
					model.setEqNoVerify(eqNoVerify[i]);
				if (chkOffice[i] != null)
					model.setChkOffice(chkOffice[i]);
				if (oldOfcCd[i] != null)
					model.setOldOfcCd(oldOfcCd[i]);
				if (hidFrmreqdate[i] != null)
					model.setHidFrmreqdate(hidFrmreqdate[i]);
				if (ctrlUserId[i] != null)
					model.setCtrlUserId(ctrlUserId[i]);
				if (cbstatus[i] != null)
					model.setCbstatus(cbstatus[i]);
				if (selKind[i] != null)
					model.setSelKind(selKind[i]);
				if (trspSoEqKind[i] != null)
					model.setTrspSoEqKind(trspSoEqKind[i]);
				if (hidFmNodCd[i] != null)
					model.setHidFmNodCd(hidFmNodCd[i]);
				if (hidEqTpszCd[i] != null)
					model.setHidEqTpszCd(hidEqTpszCd[i]);
				if (ctrlSoOffice[i] != null)
					model.setCtrlSoOffice(ctrlSoOffice[i]);
				if (frmNodeVerify[i] != null)
					model.setFrmNodeVerify(frmNodeVerify[i]);
				if (hidTrspCrrModCd[i] != null)
					model.setHidTrspCrrModCd(hidTrspCrrModCd[i]);
				if (hidToreqdate[i] != null)
					model.setHidToreqdate(hidToreqdate[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (frmReqdate[i] != null)
					model.setFrmReqdate(frmReqdate[i]);
				if (hidCntrTpszCd[i] != null)
					model.setHidCntrTpszCd(hidCntrTpszCd[i]);
				if (toYard[i] != null)
					model.setToYard(toYard[i]);
				if (cntrType[i] != null)
					model.setCntrType(cntrType[i]);
				if (cntrSize[i] != null)
					model.setCntrSize(cntrSize[i]);
				if (frmNode[i] != null)
					model.setFrmNode(frmNode[i]);
				if (hidToNodCd[i] != null)
					model.setHidToNodCd(hidToNodCd[i]);
				if (hidFmYardCd[i] != null)
					model.setHidFmYardCd(hidFmYardCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (hidRefId[i] != null)
					model.setHidRefId(hidRefId[i]);
				if (referenceNo[i] != null)
					model.setReferenceNo(referenceNo[i]);
				if (toReqdate[i] != null)
					model.setToReqdate(toReqdate[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSingleTransportationSOManageSearchVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SingleTransportationSOManageSearchVO[]
	 */
	public SingleTransportationSOManageSearchVO[] getSingleTransportationSOManageSearchVOs(){
		SingleTransportationSOManageSearchVO[] vos = (SingleTransportationSOManageSearchVO[])models.toArray(new SingleTransportationSOManageSearchVO[models.size()]);
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
		this.frmYard = this.frmYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidCntrNo = this.hidCntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidTrspCostModCd = this.hidTrspCostModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidToYardCd = this.hidToYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNode = this.toNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNoVerify = this.eqNoVerify .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkOffice = this.chkOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldOfcCd = this.oldOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFrmreqdate = this.hidFrmreqdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlUserId = this.ctrlUserId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cbstatus = this.cbstatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selKind = this.selKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoEqKind = this.trspSoEqKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFmNodCd = this.hidFmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidEqTpszCd = this.hidEqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlSoOffice = this.ctrlSoOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmNodeVerify = this.frmNodeVerify .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidTrspCrrModCd = this.hidTrspCrrModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidToreqdate = this.hidToreqdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmReqdate = this.frmReqdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidCntrTpszCd = this.hidCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYard = this.toYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrType = this.cntrType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSize = this.cntrSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmNode = this.frmNode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidToNodCd = this.hidToNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidFmYardCd = this.hidFmYardCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hidRefId = this.hidRefId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.referenceNo = this.referenceNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toReqdate = this.toReqdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
