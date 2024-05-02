/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TblMsgHistVO.java
*@FileTitle : TblMsgHistVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.27
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.syscommon.common.table;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class TblMsgHistVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TblMsgHistVO> models = new ArrayList<TblMsgHistVO>();
	
	/* Column Info */
	private String contentPath = null;
	/* Column Info */
	private String reservedFg = null;
	/* Column Info */
	private String reservedDttm = null;
	/* Column Info */
	private String natCd = null;
	/* Column Info */
	private String contentMimeType = null;
	/* Column Info */
	private String cmpMsgGroupId = null;
	/* Column Info */
	private String cmpRcvDttm = null;
	/* Column Info */
	private String sndPhnId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String regSndDttm = null;
	/* Column Info */
	private String smsStatus = null;
	/* Column Info */
	private String savedFg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String callbackUrl = null;
	/* Column Info */
	private String telcoId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String assignCd = null;
	/* Column Info */
	private String regRcvDttm = null;
	/* Column Info */
	private String msgTitle = null;
	/* Column Info */
	private String cmpSndDttm = null;
	/* Column Info */
	private String machineId = null;
	/* Column Info */
	private String rsltVal = null;
	/* Column Info */
	private String cmpMsgId = null;
	/* Column Info */
	private String rcvPhnId = null;
	/* Column Info */
	private String contentCnt = null;
	/* Column Info */
	private String usedCd = null;
	/* Column Info */
	private String sndMsg = null;
	/* Column Info */
	private String smsGb = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TblMsgHistVO() {}

	public TblMsgHistVO(String ibflag, String pagerows, String cmpMsgId, String cmpMsgGroupId, String usrId, String smsGb, String usedCd, String reservedFg, String reservedDttm, String savedFg, String rcvPhnId, String sndPhnId, String natCd, String assignCd, String sndMsg, String callbackUrl, String contentCnt, String contentMimeType, String contentPath, String cmpSndDttm, String cmpRcvDttm, String regSndDttm, String regRcvDttm, String machineId, String smsStatus, String rsltVal, String msgTitle, String telcoId) {
		this.contentPath = contentPath;
		this.reservedFg = reservedFg;
		this.reservedDttm = reservedDttm;
		this.natCd = natCd;
		this.contentMimeType = contentMimeType;
		this.cmpMsgGroupId = cmpMsgGroupId;
		this.cmpRcvDttm = cmpRcvDttm;
		this.sndPhnId = sndPhnId;
		this.pagerows = pagerows;
		this.regSndDttm = regSndDttm;
		this.smsStatus = smsStatus;
		this.savedFg = savedFg;
		this.ibflag = ibflag;
		this.callbackUrl = callbackUrl;
		this.telcoId = telcoId;
		this.usrId = usrId;
		this.assignCd = assignCd;
		this.regRcvDttm = regRcvDttm;
		this.msgTitle = msgTitle;
		this.cmpSndDttm = cmpSndDttm;
		this.machineId = machineId;
		this.rsltVal = rsltVal;
		this.cmpMsgId = cmpMsgId;
		this.rcvPhnId = rcvPhnId;
		this.contentCnt = contentCnt;
		this.usedCd = usedCd;
		this.sndMsg = sndMsg;
		this.smsGb = smsGb;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("content_path", getContentPath());
		this.hashColumns.put("reserved_fg", getReservedFg());
		this.hashColumns.put("reserved_dttm", getReservedDttm());
		this.hashColumns.put("nat_cd", getNatCd());
		this.hashColumns.put("content_mime_type", getContentMimeType());
		this.hashColumns.put("cmp_msg_group_id", getCmpMsgGroupId());
		this.hashColumns.put("cmp_rcv_dttm", getCmpRcvDttm());
		this.hashColumns.put("snd_phn_id", getSndPhnId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("reg_snd_dttm", getRegSndDttm());
		this.hashColumns.put("sms_status", getSmsStatus());
		this.hashColumns.put("saved_fg", getSavedFg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("callback_url", getCallbackUrl());
		this.hashColumns.put("telco_id", getTelcoId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("assign_cd", getAssignCd());
		this.hashColumns.put("reg_rcv_dttm", getRegRcvDttm());
		this.hashColumns.put("msg_title", getMsgTitle());
		this.hashColumns.put("cmp_snd_dttm", getCmpSndDttm());
		this.hashColumns.put("machine_id", getMachineId());
		this.hashColumns.put("rslt_val", getRsltVal());
		this.hashColumns.put("cmp_msg_id", getCmpMsgId());
		this.hashColumns.put("rcv_phn_id", getRcvPhnId());
		this.hashColumns.put("content_cnt", getContentCnt());
		this.hashColumns.put("used_cd", getUsedCd());
		this.hashColumns.put("snd_msg", getSndMsg());
		this.hashColumns.put("sms_gb", getSmsGb());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("content_path", "contentPath");
		this.hashFields.put("reserved_fg", "reservedFg");
		this.hashFields.put("reserved_dttm", "reservedDttm");
		this.hashFields.put("nat_cd", "natCd");
		this.hashFields.put("content_mime_type", "contentMimeType");
		this.hashFields.put("cmp_msg_group_id", "cmpMsgGroupId");
		this.hashFields.put("cmp_rcv_dttm", "cmpRcvDttm");
		this.hashFields.put("snd_phn_id", "sndPhnId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("reg_snd_dttm", "regSndDttm");
		this.hashFields.put("sms_status", "smsStatus");
		this.hashFields.put("saved_fg", "savedFg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("callback_url", "callbackUrl");
		this.hashFields.put("telco_id", "telcoId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("assign_cd", "assignCd");
		this.hashFields.put("reg_rcv_dttm", "regRcvDttm");
		this.hashFields.put("msg_title", "msgTitle");
		this.hashFields.put("cmp_snd_dttm", "cmpSndDttm");
		this.hashFields.put("machine_id", "machineId");
		this.hashFields.put("rslt_val", "rsltVal");
		this.hashFields.put("cmp_msg_id", "cmpMsgId");
		this.hashFields.put("rcv_phn_id", "rcvPhnId");
		this.hashFields.put("content_cnt", "contentCnt");
		this.hashFields.put("used_cd", "usedCd");
		this.hashFields.put("snd_msg", "sndMsg");
		this.hashFields.put("sms_gb", "smsGb");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return contentPath
	 */
	public String getContentPath() {
		return this.contentPath;
	}
	
	/**
	 * Column Info
	 * @return reservedFg
	 */
	public String getReservedFg() {
		return this.reservedFg;
	}
	
	/**
	 * Column Info
	 * @return reservedDttm
	 */
	public String getReservedDttm() {
		return this.reservedDttm;
	}
	
	/**
	 * Column Info
	 * @return natCd
	 */
	public String getNatCd() {
		return this.natCd;
	}
	
	/**
	 * Column Info
	 * @return contentMimeType
	 */
	public String getContentMimeType() {
		return this.contentMimeType;
	}
	
	/**
	 * Column Info
	 * @return cmpMsgGroupId
	 */
	public String getCmpMsgGroupId() {
		return this.cmpMsgGroupId;
	}
	
	/**
	 * Column Info
	 * @return cmpRcvDttm
	 */
	public String getCmpRcvDttm() {
		return this.cmpRcvDttm;
	}
	
	/**
	 * Column Info
	 * @return sndPhnId
	 */
	public String getSndPhnId() {
		return this.sndPhnId;
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
	 * @return regSndDttm
	 */
	public String getRegSndDttm() {
		return this.regSndDttm;
	}
	
	/**
	 * Column Info
	 * @return smsStatus
	 */
	public String getSmsStatus() {
		return this.smsStatus;
	}
	
	/**
	 * Column Info
	 * @return savedFg
	 */
	public String getSavedFg() {
		return this.savedFg;
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
	 * @return callbackUrl
	 */
	public String getCallbackUrl() {
		return this.callbackUrl;
	}
	
	/**
	 * Column Info
	 * @return telcoId
	 */
	public String getTelcoId() {
		return this.telcoId;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return assignCd
	 */
	public String getAssignCd() {
		return this.assignCd;
	}
	
	/**
	 * Column Info
	 * @return regRcvDttm
	 */
	public String getRegRcvDttm() {
		return this.regRcvDttm;
	}
	
	/**
	 * Column Info
	 * @return msgTitle
	 */
	public String getMsgTitle() {
		return this.msgTitle;
	}
	
	/**
	 * Column Info
	 * @return cmpSndDttm
	 */
	public String getCmpSndDttm() {
		return this.cmpSndDttm;
	}
	
	/**
	 * Column Info
	 * @return machineId
	 */
	public String getMachineId() {
		return this.machineId;
	}
	
	/**
	 * Column Info
	 * @return rsltVal
	 */
	public String getRsltVal() {
		return this.rsltVal;
	}
	
	/**
	 * Column Info
	 * @return cmpMsgId
	 */
	public String getCmpMsgId() {
		return this.cmpMsgId;
	}
	
	/**
	 * Column Info
	 * @return rcvPhnId
	 */
	public String getRcvPhnId() {
		return this.rcvPhnId;
	}
	
	/**
	 * Column Info
	 * @return contentCnt
	 */
	public String getContentCnt() {
		return this.contentCnt;
	}
	
	/**
	 * Column Info
	 * @return usedCd
	 */
	public String getUsedCd() {
		return this.usedCd;
	}
	
	/**
	 * Column Info
	 * @return sndMsg
	 */
	public String getSndMsg() {
		return this.sndMsg;
	}
	
	/**
	 * Column Info
	 * @return smsGb
	 */
	public String getSmsGb() {
		return this.smsGb;
	}
	

	/**
	 * Column Info
	 * @param contentPath
	 */
	public void setContentPath(String contentPath) {
		this.contentPath = contentPath;
	}
	
	/**
	 * Column Info
	 * @param reservedFg
	 */
	public void setReservedFg(String reservedFg) {
		this.reservedFg = reservedFg;
	}
	
	/**
	 * Column Info
	 * @param reservedDttm
	 */
	public void setReservedDttm(String reservedDttm) {
		this.reservedDttm = reservedDttm;
	}
	
	/**
	 * Column Info
	 * @param natCd
	 */
	public void setNatCd(String natCd) {
		this.natCd = natCd;
	}
	
	/**
	 * Column Info
	 * @param contentMimeType
	 */
	public void setContentMimeType(String contentMimeType) {
		this.contentMimeType = contentMimeType;
	}
	
	/**
	 * Column Info
	 * @param cmpMsgGroupId
	 */
	public void setCmpMsgGroupId(String cmpMsgGroupId) {
		this.cmpMsgGroupId = cmpMsgGroupId;
	}
	
	/**
	 * Column Info
	 * @param cmpRcvDttm
	 */
	public void setCmpRcvDttm(String cmpRcvDttm) {
		this.cmpRcvDttm = cmpRcvDttm;
	}
	
	/**
	 * Column Info
	 * @param sndPhnId
	 */
	public void setSndPhnId(String sndPhnId) {
		this.sndPhnId = sndPhnId;
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
	 * @param regSndDttm
	 */
	public void setRegSndDttm(String regSndDttm) {
		this.regSndDttm = regSndDttm;
	}
	
	/**
	 * Column Info
	 * @param smsStatus
	 */
	public void setSmsStatus(String smsStatus) {
		this.smsStatus = smsStatus;
	}
	
	/**
	 * Column Info
	 * @param savedFg
	 */
	public void setSavedFg(String savedFg) {
		this.savedFg = savedFg;
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
	 * @param callbackUrl
	 */
	public void setCallbackUrl(String callbackUrl) {
		this.callbackUrl = callbackUrl;
	}
	
	/**
	 * Column Info
	 * @param telcoId
	 */
	public void setTelcoId(String telcoId) {
		this.telcoId = telcoId;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param assignCd
	 */
	public void setAssignCd(String assignCd) {
		this.assignCd = assignCd;
	}
	
	/**
	 * Column Info
	 * @param regRcvDttm
	 */
	public void setRegRcvDttm(String regRcvDttm) {
		this.regRcvDttm = regRcvDttm;
	}
	
	/**
	 * Column Info
	 * @param msgTitle
	 */
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}
	
	/**
	 * Column Info
	 * @param cmpSndDttm
	 */
	public void setCmpSndDttm(String cmpSndDttm) {
		this.cmpSndDttm = cmpSndDttm;
	}
	
	/**
	 * Column Info
	 * @param machineId
	 */
	public void setMachineId(String machineId) {
		this.machineId = machineId;
	}
	
	/**
	 * Column Info
	 * @param rsltVal
	 */
	public void setRsltVal(String rsltVal) {
		this.rsltVal = rsltVal;
	}
	
	/**
	 * Column Info
	 * @param cmpMsgId
	 */
	public void setCmpMsgId(String cmpMsgId) {
		this.cmpMsgId = cmpMsgId;
	}
	
	/**
	 * Column Info
	 * @param rcvPhnId
	 */
	public void setRcvPhnId(String rcvPhnId) {
		this.rcvPhnId = rcvPhnId;
	}
	
	/**
	 * Column Info
	 * @param contentCnt
	 */
	public void setContentCnt(String contentCnt) {
		this.contentCnt = contentCnt;
	}
	
	/**
	 * Column Info
	 * @param usedCd
	 */
	public void setUsedCd(String usedCd) {
		this.usedCd = usedCd;
	}
	
	/**
	 * Column Info
	 * @param sndMsg
	 */
	public void setSndMsg(String sndMsg) {
		this.sndMsg = sndMsg;
	}
	
	/**
	 * Column Info
	 * @param smsGb
	 */
	public void setSmsGb(String smsGb) {
		this.smsGb = smsGb;
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
		setContentPath(JSPUtil.getParameter(request, prefix + "content_path", ""));
		setReservedFg(JSPUtil.getParameter(request, prefix + "reserved_fg", ""));
		setReservedDttm(JSPUtil.getParameter(request, prefix + "reserved_dttm", ""));
		setNatCd(JSPUtil.getParameter(request, prefix + "nat_cd", ""));
		setContentMimeType(JSPUtil.getParameter(request, prefix + "content_mime_type", ""));
		setCmpMsgGroupId(JSPUtil.getParameter(request, prefix + "cmp_msg_group_id", ""));
		setCmpRcvDttm(JSPUtil.getParameter(request, prefix + "cmp_rcv_dttm", ""));
		setSndPhnId(JSPUtil.getParameter(request, prefix + "snd_phn_id", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRegSndDttm(JSPUtil.getParameter(request, prefix + "reg_snd_dttm", ""));
		setSmsStatus(JSPUtil.getParameter(request, prefix + "sms_status", ""));
		setSavedFg(JSPUtil.getParameter(request, prefix + "saved_fg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCallbackUrl(JSPUtil.getParameter(request, prefix + "callback_url", ""));
		setTelcoId(JSPUtil.getParameter(request, prefix + "telco_id", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setAssignCd(JSPUtil.getParameter(request, prefix + "assign_cd", ""));
		setRegRcvDttm(JSPUtil.getParameter(request, prefix + "reg_rcv_dttm", ""));
		setMsgTitle(JSPUtil.getParameter(request, prefix + "msg_title", ""));
		setCmpSndDttm(JSPUtil.getParameter(request, prefix + "cmp_snd_dttm", ""));
		setMachineId(JSPUtil.getParameter(request, prefix + "machine_id", ""));
		setRsltVal(JSPUtil.getParameter(request, prefix + "rslt_val", ""));
		setCmpMsgId(JSPUtil.getParameter(request, prefix + "cmp_msg_id", ""));
		setRcvPhnId(JSPUtil.getParameter(request, prefix + "rcv_phn_id", ""));
		setContentCnt(JSPUtil.getParameter(request, prefix + "content_cnt", ""));
		setUsedCd(JSPUtil.getParameter(request, prefix + "used_cd", ""));
		setSndMsg(JSPUtil.getParameter(request, prefix + "snd_msg", ""));
		setSmsGb(JSPUtil.getParameter(request, prefix + "sms_gb", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TblMsgHistVO[]
	 */
	public TblMsgHistVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TblMsgHistVO[]
	 */
	public TblMsgHistVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TblMsgHistVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] contentPath = (JSPUtil.getParameter(request, prefix	+ "content_path", length));
			String[] reservedFg = (JSPUtil.getParameter(request, prefix	+ "reserved_fg", length));
			String[] reservedDttm = (JSPUtil.getParameter(request, prefix	+ "reserved_dttm", length));
			String[] natCd = (JSPUtil.getParameter(request, prefix	+ "nat_cd", length));
			String[] contentMimeType = (JSPUtil.getParameter(request, prefix	+ "content_mime_type", length));
			String[] cmpMsgGroupId = (JSPUtil.getParameter(request, prefix	+ "cmp_msg_group_id", length));
			String[] cmpRcvDttm = (JSPUtil.getParameter(request, prefix	+ "cmp_rcv_dttm", length));
			String[] sndPhnId = (JSPUtil.getParameter(request, prefix	+ "snd_phn_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] regSndDttm = (JSPUtil.getParameter(request, prefix	+ "reg_snd_dttm", length));
			String[] smsStatus = (JSPUtil.getParameter(request, prefix	+ "sms_status", length));
			String[] savedFg = (JSPUtil.getParameter(request, prefix	+ "saved_fg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] callbackUrl = (JSPUtil.getParameter(request, prefix	+ "callback_url", length));
			String[] telcoId = (JSPUtil.getParameter(request, prefix	+ "telco_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] assignCd = (JSPUtil.getParameter(request, prefix	+ "assign_cd", length));
			String[] regRcvDttm = (JSPUtil.getParameter(request, prefix	+ "reg_rcv_dttm", length));
			String[] msgTitle = (JSPUtil.getParameter(request, prefix	+ "msg_title", length));
			String[] cmpSndDttm = (JSPUtil.getParameter(request, prefix	+ "cmp_snd_dttm", length));
			String[] machineId = (JSPUtil.getParameter(request, prefix	+ "machine_id", length));
			String[] rsltVal = (JSPUtil.getParameter(request, prefix	+ "rslt_val", length));
			String[] cmpMsgId = (JSPUtil.getParameter(request, prefix	+ "cmp_msg_id", length));
			String[] rcvPhnId = (JSPUtil.getParameter(request, prefix	+ "rcv_phn_id", length));
			String[] contentCnt = (JSPUtil.getParameter(request, prefix	+ "content_cnt", length));
			String[] usedCd = (JSPUtil.getParameter(request, prefix	+ "used_cd", length));
			String[] sndMsg = (JSPUtil.getParameter(request, prefix	+ "snd_msg", length));
			String[] smsGb = (JSPUtil.getParameter(request, prefix	+ "sms_gb", length));
			
			for (int i = 0; i < length; i++) {
				model = new TblMsgHistVO();
				if (contentPath[i] != null)
					model.setContentPath(contentPath[i]);
				if (reservedFg[i] != null)
					model.setReservedFg(reservedFg[i]);
				if (reservedDttm[i] != null)
					model.setReservedDttm(reservedDttm[i]);
				if (natCd[i] != null)
					model.setNatCd(natCd[i]);
				if (contentMimeType[i] != null)
					model.setContentMimeType(contentMimeType[i]);
				if (cmpMsgGroupId[i] != null)
					model.setCmpMsgGroupId(cmpMsgGroupId[i]);
				if (cmpRcvDttm[i] != null)
					model.setCmpRcvDttm(cmpRcvDttm[i]);
				if (sndPhnId[i] != null)
					model.setSndPhnId(sndPhnId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (regSndDttm[i] != null)
					model.setRegSndDttm(regSndDttm[i]);
				if (smsStatus[i] != null)
					model.setSmsStatus(smsStatus[i]);
				if (savedFg[i] != null)
					model.setSavedFg(savedFg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (callbackUrl[i] != null)
					model.setCallbackUrl(callbackUrl[i]);
				if (telcoId[i] != null)
					model.setTelcoId(telcoId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (assignCd[i] != null)
					model.setAssignCd(assignCd[i]);
				if (regRcvDttm[i] != null)
					model.setRegRcvDttm(regRcvDttm[i]);
				if (msgTitle[i] != null)
					model.setMsgTitle(msgTitle[i]);
				if (cmpSndDttm[i] != null)
					model.setCmpSndDttm(cmpSndDttm[i]);
				if (machineId[i] != null)
					model.setMachineId(machineId[i]);
				if (rsltVal[i] != null)
					model.setRsltVal(rsltVal[i]);
				if (cmpMsgId[i] != null)
					model.setCmpMsgId(cmpMsgId[i]);
				if (rcvPhnId[i] != null)
					model.setRcvPhnId(rcvPhnId[i]);
				if (contentCnt[i] != null)
					model.setContentCnt(contentCnt[i]);
				if (usedCd[i] != null)
					model.setUsedCd(usedCd[i]);
				if (sndMsg[i] != null)
					model.setSndMsg(sndMsg[i]);
				if (smsGb[i] != null)
					model.setSmsGb(smsGb[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTblMsgHistVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TblMsgHistVO[]
	 */
	public TblMsgHistVO[] getTblMsgHistVOs(){
		TblMsgHistVO[] vos = (TblMsgHistVO[])models.toArray(new TblMsgHistVO[models.size()]);
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
		this.contentPath = this.contentPath .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reservedFg = this.reservedFg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reservedDttm = this.reservedDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.natCd = this.natCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contentMimeType = this.contentMimeType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpMsgGroupId = this.cmpMsgGroupId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpRcvDttm = this.cmpRcvDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndPhnId = this.sndPhnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regSndDttm = this.regSndDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smsStatus = this.smsStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.savedFg = this.savedFg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callbackUrl = this.callbackUrl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.telcoId = this.telcoId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.assignCd = this.assignCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.regRcvDttm = this.regRcvDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgTitle = this.msgTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpSndDttm = this.cmpSndDttm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.machineId = this.machineId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsltVal = this.rsltVal .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmpMsgId = this.cmpMsgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvPhnId = this.rcvPhnId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contentCnt = this.contentCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedCd = this.usedCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndMsg = this.sndMsg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.smsGb = this.smsGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
