/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurRcvMsgVO.java
*@FileTitle : EurRcvMsgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.10.23 경종윤 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo;

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
 * @author 경종윤
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EurRcvMsgVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EurRcvMsgVO> models = new ArrayList<EurRcvMsgVO>();
	
	/* Column Info */
	private String msgTpId = null;
	/* Column Info */
	private String msgAckTp = null;
	/* Column Info */
	private String msgPhone = null;
	/* Column Info */
	private String msgAcceptRef = null;
	/* Column Info */
	private String msgUdtFlg = null;
	/* Column Info */
	private String msgRRef1 = null;
	/* Column Info */
	private String msgRErrorCode = null;
	/* Column Info */
	private String orgMsgTp = null;
	/* Column Info */
	private String orgMsgCntr = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String msgFax = null;
	/* Column Info */
	private String msgAckRslt = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String msgRRef2 = null;
	/* Column Info */
	private String msgAckDt = null;
	/* Column Info */
	private String orgMsgNm = null;
	/* Column Info */
	private String msgApproveDt = null;
	/* Column Info */
	private String secFileNbr = null;
	/* Column Info */
	private String orgMsgBl = null;
	/* Column Info */
	private String rcvLogSeq = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String msgRErrorMsg = null;
	/* Column Info */
	private String keyVal = null;
	/* Column Info */
	private String orgMsgKey = null;
	/* Column Info */
	private String msgAckCd = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String portCd = null;	
	/* Column Info */
	private String msgAckRefNo = null;	
	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EurRcvMsgVO() {}

	public EurRcvMsgVO(String ibflag, String pagerows, String keyVal, String rcvLogSeq, String orgMsgTp, String msgUdtFlg, String orgMsgNm, String msgAckTp, String msgAckRslt, String msgAckDt, String msgApproveDt, String msgPhone, String msgFax, String orgMsgCntr, String orgMsgBl, String msgRErrorCode, String msgRErrorMsg, String msgRRef1, String msgRRef2, String secFileNbr
						, String msgAcceptRef, String creUsrId, String updUsrId, String msgTpId, String orgMsgKey, String msgAckCd, String vvdCd, String ioBndCd, String portCd, String msgAckRefNo) {
		this.msgTpId = msgTpId;
		this.msgAckTp = msgAckTp;
		this.msgPhone = msgPhone;
		this.msgAcceptRef = msgAcceptRef;
		this.msgUdtFlg = msgUdtFlg;
		this.msgRRef1 = msgRRef1;
		this.msgRErrorCode = msgRErrorCode;
		this.orgMsgTp = orgMsgTp;
		this.orgMsgCntr = orgMsgCntr;
		this.pagerows = pagerows;
		this.msgFax = msgFax;
		this.msgAckRslt = msgAckRslt;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.msgRRef2 = msgRRef2;
		this.msgAckDt = msgAckDt;
		this.orgMsgNm = orgMsgNm;
		this.msgApproveDt = msgApproveDt;
		this.secFileNbr = secFileNbr;
		this.orgMsgBl = orgMsgBl;
		this.rcvLogSeq = rcvLogSeq;
		this.updUsrId = updUsrId;
		this.msgRErrorMsg = msgRErrorMsg;
		this.keyVal = keyVal;
		this.orgMsgKey = orgMsgKey;
		this.msgAckCd = msgAckCd;
		this.vvdCd = vvdCd;
		this.ioBndCd = ioBndCd;
		this.portCd = portCd;
		this.msgAckRefNo = msgAckRefNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("msg_tp_id", getMsgTpId());
		this.hashColumns.put("msg_ack_tp", getMsgAckTp());
		this.hashColumns.put("msg_phone", getMsgPhone());
		this.hashColumns.put("msg_accept_ref", getMsgAcceptRef());
		this.hashColumns.put("msg_udt_flg", getMsgUdtFlg());
		this.hashColumns.put("msg_r_ref1", getMsgRRef1());
		this.hashColumns.put("msg_r_error_code", getMsgRErrorCode());
		this.hashColumns.put("org_msg_tp", getOrgMsgTp());
		this.hashColumns.put("org_msg_cntr", getOrgMsgCntr());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("msg_fax", getMsgFax());
		this.hashColumns.put("msg_ack_rslt", getMsgAckRslt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("msg_r_ref2", getMsgRRef2());
		this.hashColumns.put("msg_ack_dt", getMsgAckDt());
		this.hashColumns.put("org_msg_nm", getOrgMsgNm());
		this.hashColumns.put("msg_approve_dt", getMsgApproveDt());
		this.hashColumns.put("sec_file_nbr", getSecFileNbr());
		this.hashColumns.put("org_msg_bl", getOrgMsgBl());
		this.hashColumns.put("rcv_log_seq", getRcvLogSeq());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("msg_r_error_msg", getMsgRErrorMsg());
		this.hashColumns.put("key_val", getKeyVal());
		this.hashColumns.put("org_msg_key", getOrgMsgKey());
		this.hashColumns.put("msg_ack_cd", getMsgAckCd());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("msg_ack_ref_no", getMsgAckRefNo());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("msg_tp_id", "msgTpId");
		this.hashFields.put("msg_ack_tp", "msgAckTp");
		this.hashFields.put("msg_phone", "msgPhone");
		this.hashFields.put("msg_accept_ref", "msgAcceptRef");
		this.hashFields.put("msg_udt_flg", "msgUdtFlg");
		this.hashFields.put("msg_r_ref1", "msgRRef1");
		this.hashFields.put("msg_r_error_code", "msgRErrorCode");
		this.hashFields.put("org_msg_tp", "orgMsgTp");
		this.hashFields.put("org_msg_cntr", "orgMsgCntr");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("msg_fax", "msgFax");
		this.hashFields.put("msg_ack_rslt", "msgAckRslt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("msg_r_ref2", "msgRRef2");
		this.hashFields.put("msg_ack_dt", "msgAckDt");
		this.hashFields.put("org_msg_nm", "orgMsgNm");
		this.hashFields.put("msg_approve_dt", "msgApproveDt");
		this.hashFields.put("sec_file_nbr", "secFileNbr");
		this.hashFields.put("org_msg_bl", "orgMsgBl");
		this.hashFields.put("rcv_log_seq", "rcvLogSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("msg_r_error_msg", "msgRErrorMsg");
		this.hashFields.put("key_val", "keyVal");
		this.hashFields.put("org_msg_key", "orgMsgKey");
		this.hashFields.put("msg_ack_cd", "msgAckCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("msg_ack_ref_no", "msgAckRefNo");
		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return msgTpId
	 */
	public String getMsgTpId() {
		return this.msgTpId;
	}
	
	/**
	 * Column Info
	 * @return msgAckTp
	 */
	public String getMsgAckTp() {
		return this.msgAckTp;
	}
	
	/**
	 * Column Info
	 * @return msgPhone
	 */
	public String getMsgPhone() {
		return this.msgPhone;
	}
	
	/**
	 * Column Info
	 * @return msgAcceptRef
	 */
	public String getMsgAcceptRef() {
		return this.msgAcceptRef;
	}
	
	/**
	 * Column Info
	 * @return msgUdtFlg
	 */
	public String getMsgUdtFlg() {
		return this.msgUdtFlg;
	}
	
	/**
	 * Column Info
	 * @return msgRRef1
	 */
	public String getMsgRRef1() {
		return this.msgRRef1;
	}
	
	/**
	 * Column Info
	 * @return msgRErrorCode
	 */
	public String getMsgRErrorCode() {
		return this.msgRErrorCode;
	}
	
	/**
	 * Column Info
	 * @return orgMsgTp
	 */
	public String getOrgMsgTp() {
		return this.orgMsgTp;
	}
	
	/**
	 * Column Info
	 * @return orgMsgCntr
	 */
	public String getOrgMsgCntr() {
		return this.orgMsgCntr;
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
	 * @return msgFax
	 */
	public String getMsgFax() {
		return this.msgFax;
	}
	
	/**
	 * Column Info
	 * @return msgAckRslt
	 */
	public String getMsgAckRslt() {
		return this.msgAckRslt;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return msgRRef2
	 */
	public String getMsgRRef2() {
		return this.msgRRef2;
	}
	
	/**
	 * Column Info
	 * @return msgAckDt
	 */
	public String getMsgAckDt() {
		return this.msgAckDt;
	}
	
	/**
	 * Column Info
	 * @return orgMsgNm
	 */
	public String getOrgMsgNm() {
		return this.orgMsgNm;
	}
	
	/**
	 * Column Info
	 * @return msgApproveDt
	 */
	public String getMsgApproveDt() {
		return this.msgApproveDt;
	}
	
	/**
	 * Column Info
	 * @return secFileNbr
	 */
	public String getSecFileNbr() {
		return this.secFileNbr;
	}
	
	/**
	 * Column Info
	 * @return orgMsgBl
	 */
	public String getOrgMsgBl() {
		return this.orgMsgBl;
	}
	
	/**
	 * Column Info
	 * @return rcvLogSeq
	 */
	public String getRcvLogSeq() {
		return this.rcvLogSeq;
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
	 * @return msgRErrorMsg
	 */
	public String getMsgRErrorMsg() {
		return this.msgRErrorMsg;
	}
	
	/**
	 * Column Info
	 * @return keyVal
	 */
	public String getKeyVal() {
		return this.keyVal;
	}
	
	/**
	 * Column Info
	 * @return orgMsgKey
	 */
	public String getOrgMsgKey() {
		return this.orgMsgKey;
	}
	
	/**
	 * Column Info
	 * @return msgAckCd
	 */
	public String getMsgAckCd() {
		return this.msgAckCd;
	}	
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}

	/**
	 * Column Info
	 * @return ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
	}
	
	/**
	 * Column Info
	 * @return portCd
	 */
	public String getPortCd() {
		return this.portCd;
	}
	
	/**
	 * Column Info
	 * @return msgAckRefNo
	 */
	public String getMsgAckRefNo() {
		return this.msgAckRefNo;
	}
	
	/**
	 * Column Info
	 * @param msgTpId
	 */
	public void setMsgTpId(String msgTpId) {
		this.msgTpId = msgTpId;
	}
	
	/**
	 * Column Info
	 * @param msgAckTp
	 */
	public void setMsgAckTp(String msgAckTp) {
		this.msgAckTp = msgAckTp;
	}
	
	/**
	 * Column Info
	 * @param msgPhone
	 */
	public void setMsgPhone(String msgPhone) {
		this.msgPhone = msgPhone;
	}
	
	/**
	 * Column Info
	 * @param msgAcceptRef
	 */
	public void setMsgAcceptRef(String msgAcceptRef) {
		this.msgAcceptRef = msgAcceptRef;
	}
	
	/**
	 * Column Info
	 * @param msgUdtFlg
	 */
	public void setMsgUdtFlg(String msgUdtFlg) {
		this.msgUdtFlg = msgUdtFlg;
	}
	
	/**
	 * Column Info
	 * @param msgRRef1
	 */
	public void setMsgRRef1(String msgRRef1) {
		this.msgRRef1 = msgRRef1;
	}
	
	/**
	 * Column Info
	 * @param msgRErrorCode
	 */
	public void setMsgRErrorCode(String msgRErrorCode) {
		this.msgRErrorCode = msgRErrorCode;
	}
	
	/**
	 * Column Info
	 * @param orgMsgTp
	 */
	public void setOrgMsgTp(String orgMsgTp) {
		this.orgMsgTp = orgMsgTp;
	}
	
	/**
	 * Column Info
	 * @param orgMsgCntr
	 */
	public void setOrgMsgCntr(String orgMsgCntr) {
		this.orgMsgCntr = orgMsgCntr;
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
	 * @param msgFax
	 */
	public void setMsgFax(String msgFax) {
		this.msgFax = msgFax;
	}
	
	/**
	 * Column Info
	 * @param msgAckRslt
	 */
	public void setMsgAckRslt(String msgAckRslt) {
		this.msgAckRslt = msgAckRslt;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param msgRRef2
	 */
	public void setMsgRRef2(String msgRRef2) {
		this.msgRRef2 = msgRRef2;
	}
	
	/**
	 * Column Info
	 * @param msgAckDt
	 */
	public void setMsgAckDt(String msgAckDt) {
		this.msgAckDt = msgAckDt;
	}
	
	/**
	 * Column Info
	 * @param orgMsgNm
	 */
	public void setOrgMsgNm(String orgMsgNm) {
		this.orgMsgNm = orgMsgNm;
	}
	
	/**
	 * Column Info
	 * @param msgApproveDt
	 */
	public void setMsgApproveDt(String msgApproveDt) {
		this.msgApproveDt = msgApproveDt;
	}
	
	/**
	 * Column Info
	 * @param secFileNbr
	 */
	public void setSecFileNbr(String secFileNbr) {
		this.secFileNbr = secFileNbr;
	}
	
	/**
	 * Column Info
	 * @param orgMsgBl
	 */
	public void setOrgMsgBl(String orgMsgBl) {
		this.orgMsgBl = orgMsgBl;
	}
	
	/**
	 * Column Info
	 * @param rcvLogSeq
	 */
	public void setRcvLogSeq(String rcvLogSeq) {
		this.rcvLogSeq = rcvLogSeq;
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
	 * @param msgRErrorMsg
	 */
	public void setMsgRErrorMsg(String msgRErrorMsg) {
		this.msgRErrorMsg = msgRErrorMsg;
	}
	
	/**
	 * Column Info
	 * @param keyVal
	 */
	public void setKeyVal(String keyVal) {
		this.keyVal = keyVal;
	}

	/**
	 * Column Info
	 * @param orgMsgKey
	 */
	public void setOrgMsgKey(String orgMsgKey) {
		this.orgMsgKey = orgMsgKey;
	}

	/**
	 * Column Info
	 * @param msgAckCd
	 */
	public void setMsgAckCd(String msgAckCd) {
		this.msgAckCd = msgAckCd;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
	}

	/**
	 * Column Info
	 * @param portCd
	 */
	public void setPortCd(String portCd) {
		this.portCd = portCd;
	}

	/**
	 * Column Info
	 * @param msgAckRefNo
	 */
	public void setMsgAckRefNo(String msgAckRefNo) {
		this.msgAckRefNo = msgAckRefNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMsgTpId(JSPUtil.getParameter(request, "msg_tp_id", ""));
		setMsgAckTp(JSPUtil.getParameter(request, "msg_ack_tp", ""));
		setMsgPhone(JSPUtil.getParameter(request, "msg_phone", ""));
		setMsgAcceptRef(JSPUtil.getParameter(request, "msg_accept_ref", ""));
		setMsgUdtFlg(JSPUtil.getParameter(request, "msg_udt_flg", ""));
		setMsgRRef1(JSPUtil.getParameter(request, "msg_r_ref1", ""));
		setMsgRErrorCode(JSPUtil.getParameter(request, "msg_r_error_code", ""));
		setOrgMsgTp(JSPUtil.getParameter(request, "org_msg_tp", ""));
		setOrgMsgCntr(JSPUtil.getParameter(request, "org_msg_cntr", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMsgFax(JSPUtil.getParameter(request, "msg_fax", ""));
		setMsgAckRslt(JSPUtil.getParameter(request, "msg_ack_rslt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setMsgRRef2(JSPUtil.getParameter(request, "msg_r_ref2", ""));
		setMsgAckDt(JSPUtil.getParameter(request, "msg_ack_dt", ""));
		setOrgMsgNm(JSPUtil.getParameter(request, "org_msg_nm", ""));
		setMsgApproveDt(JSPUtil.getParameter(request, "msg_approve_dt", ""));
		setSecFileNbr(JSPUtil.getParameter(request, "sec_file_nbr", ""));
		setOrgMsgBl(JSPUtil.getParameter(request, "org_msg_bl", ""));
		setRcvLogSeq(JSPUtil.getParameter(request, "rcv_log_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setMsgRErrorMsg(JSPUtil.getParameter(request, "msg_r_error_msg", ""));
		setKeyVal(JSPUtil.getParameter(request, "key_val", ""));
		setOrgMsgKey(JSPUtil.getParameter(request, "org_msg_key", ""));
		setMsgAckCd(JSPUtil.getParameter(request, "msg_ack_cd", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setMsgAckRefNo(JSPUtil.getParameter(request, "msg_ack_ref_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EurRcvMsgVO[]
	 */
	public EurRcvMsgVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EurRcvMsgVO[]
	 */
	public EurRcvMsgVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EurRcvMsgVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] msgTpId = (JSPUtil.getParameter(request, prefix	+ "msg_tp_id", length));
			String[] msgAckTp = (JSPUtil.getParameter(request, prefix	+ "msg_ack_tp", length));
			String[] msgPhone = (JSPUtil.getParameter(request, prefix	+ "msg_phone", length));
			String[] msgAcceptRef = (JSPUtil.getParameter(request, prefix	+ "msg_accept_ref", length));
			String[] msgUdtFlg = (JSPUtil.getParameter(request, prefix	+ "msg_udt_flg", length));
			String[] msgRRef1 = (JSPUtil.getParameter(request, prefix	+ "msg_r_ref1", length));
			String[] msgRErrorCode = (JSPUtil.getParameter(request, prefix	+ "msg_r_error_code", length));
			String[] orgMsgTp = (JSPUtil.getParameter(request, prefix	+ "org_msg_tp", length));
			String[] orgMsgCntr = (JSPUtil.getParameter(request, prefix	+ "org_msg_cntr", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] msgFax = (JSPUtil.getParameter(request, prefix	+ "msg_fax", length));
			String[] msgAckRslt = (JSPUtil.getParameter(request, prefix	+ "msg_ack_rslt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] msgRRef2 = (JSPUtil.getParameter(request, prefix	+ "msg_r_ref2", length));
			String[] msgAckDt = (JSPUtil.getParameter(request, prefix	+ "msg_ack_dt", length));
			String[] orgMsgNm = (JSPUtil.getParameter(request, prefix	+ "org_msg_nm", length));
			String[] msgApproveDt = (JSPUtil.getParameter(request, prefix	+ "msg_approve_dt", length));
			String[] secFileNbr = (JSPUtil.getParameter(request, prefix	+ "sec_file_nbr", length));
			String[] orgMsgBl = (JSPUtil.getParameter(request, prefix	+ "org_msg_bl", length));
			String[] rcvLogSeq = (JSPUtil.getParameter(request, prefix	+ "rcv_log_seq", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] msgRErrorMsg = (JSPUtil.getParameter(request, prefix	+ "msg_r_error_msg", length));
			String[] keyVal = (JSPUtil.getParameter(request, prefix	+ "key_val", length));
			String[] orgMsgKey = (JSPUtil.getParameter(request, prefix	+ "org_msg_key", length));
			String[] msgAckCd = (JSPUtil.getParameter(request, prefix	+ "msg_ack_cd", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] msgAckRefNo = (JSPUtil.getParameter(request, prefix	+ "msg_ack_ref_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new EurRcvMsgVO();
				if (msgTpId[i] != null)
					model.setMsgTpId(msgTpId[i]);
				if (msgAckTp[i] != null)
					model.setMsgAckTp(msgAckTp[i]);
				if (msgPhone[i] != null)
					model.setMsgPhone(msgPhone[i]);
				if (msgAcceptRef[i] != null)
					model.setMsgAcceptRef(msgAcceptRef[i]);
				if (msgUdtFlg[i] != null)
					model.setMsgUdtFlg(msgUdtFlg[i]);
				if (msgRRef1[i] != null)
					model.setMsgRRef1(msgRRef1[i]);
				if (msgRErrorCode[i] != null)
					model.setMsgRErrorCode(msgRErrorCode[i]);
				if (orgMsgTp[i] != null)
					model.setOrgMsgTp(orgMsgTp[i]);
				if (orgMsgCntr[i] != null)
					model.setOrgMsgCntr(orgMsgCntr[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (msgFax[i] != null)
					model.setMsgFax(msgFax[i]);
				if (msgAckRslt[i] != null)
					model.setMsgAckRslt(msgAckRslt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (msgRRef2[i] != null)
					model.setMsgRRef2(msgRRef2[i]);
				if (msgAckDt[i] != null)
					model.setMsgAckDt(msgAckDt[i]);
				if (orgMsgNm[i] != null)
					model.setOrgMsgNm(orgMsgNm[i]);
				if (msgApproveDt[i] != null)
					model.setMsgApproveDt(msgApproveDt[i]);
				if (secFileNbr[i] != null)
					model.setSecFileNbr(secFileNbr[i]);
				if (orgMsgBl[i] != null)
					model.setOrgMsgBl(orgMsgBl[i]);
				if (rcvLogSeq[i] != null)
					model.setRcvLogSeq(rcvLogSeq[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (msgRErrorMsg[i] != null)
					model.setMsgRErrorMsg(msgRErrorMsg[i]);
				if (keyVal[i] != null)
					model.setKeyVal(keyVal[i]);
				if (orgMsgKey[i] != null)
					model.setOrgMsgKey(orgMsgKey[i]);
				if (msgAckCd[i] != null)
					model.setMsgAckCd(msgAckCd[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (msgAckRefNo[i] != null)
					model.setMsgAckRefNo(msgAckRefNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEurRcvMsgVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EurRcvMsgVO[]
	 */
	public EurRcvMsgVO[] getEurRcvMsgVOs(){
		EurRcvMsgVO[] vos = (EurRcvMsgVO[])models.toArray(new EurRcvMsgVO[models.size()]);
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
		this.msgTpId = this.msgTpId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAckTp = this.msgAckTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgPhone = this.msgPhone .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAcceptRef = this.msgAcceptRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgUdtFlg = this.msgUdtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRRef1 = this.msgRRef1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRErrorCode = this.msgRErrorCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgTp = this.orgMsgTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgCntr = this.orgMsgCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgFax = this.msgFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAckRslt = this.msgAckRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRRef2 = this.msgRRef2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAckDt = this.msgAckDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgNm = this.orgMsgNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgApproveDt = this.msgApproveDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.secFileNbr = this.secFileNbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgBl = this.orgMsgBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvLogSeq = this.rcvLogSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRErrorMsg = this.msgRErrorMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.keyVal = this.keyVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgMsgKey = this.orgMsgKey .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAckCd = this.msgAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgAckRefNo = this.msgAckRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
