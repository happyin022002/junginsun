/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : SendDetailLogCndVO.java
*@FileTitle : SendDetailLogCndVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.07
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.07  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo;

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

public class SendDetailLogCndVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SendDetailLogCndVO> models = new ArrayList<SendDetailLogCndVO>();
	
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String errResult = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String pol = null;
	/* Column Info */
	private String dtlSeq = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String pod = null;
	/* Column Info */
	private String cstmsAckStsCd = null;
	/* Column Info */
	private String cstmsAckCd = null;
	/* Column Info */
	private String cntrCount = null;
	/* Column Info */
	private String errCode = null;
	/* Column Info */
	private String crrBatNo = null;
	/* Column Info */
	private String cstmsAckDesc = null;
	/* Column Info */
	private String msg = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String tmp2 = null;
	/* Column Info */
	private String errDesc = null;
	/* Column Info */
	private String tmp1 = null;
	/* Column Info */
	private String isfActCd = null;
	/* Column Info */
	private String sndProcId = null;
	/* Column Info */
	private String tmp3 = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String rcvDt = null;
	/* Column Info */
	private String cvyRefNo = null;
	/* Column Info */
	private String hiddenVvd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SendDetailLogCndVO() {}

	public SendDetailLogCndVO(String ibflag, String pagerows, String cntrCount, String sndDt, String blNo, String msg, String vvd, String ofcCd, String tmp2, String isfActCd, String tmp1, String tmp3, String sndProcId, String usrId, String pol, String seq, String dtlSeq, String pod, String cstmsPortCd, String crrBatNo, String cstmsAckStsCd, String cstmsAckCd, String cstmsAckDesc, String cntrNo, String errResult, String errCode, String errDesc, String rcvDt, String cvyRefNo, String hiddenVvd) {
		this.sndDt = sndDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.errResult = errResult;
		this.ibflag = ibflag;
		this.usrId = usrId;
		this.pol = pol;
		this.dtlSeq = dtlSeq;
		this.cstmsPortCd = cstmsPortCd;
		this.pod = pod;
		this.cstmsAckStsCd = cstmsAckStsCd;
		this.cstmsAckCd = cstmsAckCd;
		this.cntrCount = cntrCount;
		this.errCode = errCode;
		this.crrBatNo = crrBatNo;
		this.cstmsAckDesc = cstmsAckDesc;
		this.msg = msg;
		this.vvd = vvd;
		this.ofcCd = ofcCd;
		this.tmp2 = tmp2;
		this.errDesc = errDesc;
		this.tmp1 = tmp1;
		this.isfActCd = isfActCd;
		this.sndProcId = sndProcId;
		this.tmp3 = tmp3;
		this.cntrNo = cntrNo;
		this.seq = seq;
		this.rcvDt = rcvDt;
		this.cvyRefNo = cvyRefNo;
		this.hiddenVvd = hiddenVvd; 
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("err_result", getErrResult());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("pol", getPol());
		this.hashColumns.put("dtl_seq", getDtlSeq());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("pod", getPod());
		this.hashColumns.put("cstms_ack_sts_cd", getCstmsAckStsCd());
		this.hashColumns.put("cstms_ack_cd", getCstmsAckCd());
		this.hashColumns.put("cntr_count", getCntrCount());
		this.hashColumns.put("err_code", getErrCode());
		this.hashColumns.put("crr_bat_no", getCrrBatNo());
		this.hashColumns.put("cstms_ack_desc", getCstmsAckDesc());
		this.hashColumns.put("msg", getMsg());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("tmp2", getTmp2());
		this.hashColumns.put("err_desc", getErrDesc());
		this.hashColumns.put("tmp1", getTmp1());
		this.hashColumns.put("isf_act_cd", getIsfActCd());
		this.hashColumns.put("snd_proc_id", getSndProcId());
		this.hashColumns.put("tmp3", getTmp3());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("rcv_dt", getRcvDt());
		this.hashColumns.put("cvy_ref_no", getCvyRefNo());
		this.hashColumns.put("hidden_vvd", getHiddenVvd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("err_result", "errResult");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("dtl_seq", "dtlSeq");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("cstms_ack_sts_cd", "cstmsAckStsCd");
		this.hashFields.put("cstms_ack_cd", "cstmsAckCd");
		this.hashFields.put("cntr_count", "cntrCount");
		this.hashFields.put("err_code", "errCode");
		this.hashFields.put("crr_bat_no", "crrBatNo");
		this.hashFields.put("cstms_ack_desc", "cstmsAckDesc");
		this.hashFields.put("msg", "msg");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("tmp2", "tmp2");
		this.hashFields.put("err_desc", "errDesc");
		this.hashFields.put("tmp1", "tmp1");
		this.hashFields.put("isf_act_cd", "isfActCd");
		this.hashFields.put("snd_proc_id", "sndProcId");
		this.hashFields.put("tmp3", "tmp3");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("cvy_ref_no", "cvyRefNo");
		this.hashFields.put("hidden_vvd", "hiddenVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return sndDt
	 */
	public String getSndDt() {
		return this.sndDt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return errResult
	 */
	public String getErrResult() {
		return this.errResult;
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
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return pol
	 */
	public String getPol() {
		return this.pol;
	}

	/**
	 * Column Info
	 * @return dtlSeq
	 */
	public String getDtlSeq() {
		return this.dtlSeq;
	}
	
	/**
	 * Column Info
	 * @return rcvDt
	 */
	public String getRcvDt() {
		return this.rcvDt;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return pod
	 */
	public String getPod() {
		return this.pod;
	}
	
	/**
	 * Column Info
	 * @return cstmsAckStsCd
	 */
	public String getCstmsAckStsCd() {
		return this.cstmsAckStsCd;
	}
	
	/**
	 * Column Info
	 * @return cstmsAckCd
	 */
	public String getCstmsAckCd() {
		return this.cstmsAckCd;
	}
	
	/**
	 * Column Info
	 * @return cntrCount
	 */
	public String getCntrCount() {
		return this.cntrCount;
	}
	
	/**
	 * Column Info
	 * @return errCode
	 */
	public String getErrCode() {
		return this.errCode;
	}
	
	/**
	 * Column Info
	 * @return crrBatNo
	 */
	public String getCrrBatNo() {
		return this.crrBatNo;
	}
	
	/**
	 * Column Info
	 * @return cstmsAckDesc
	 */
	public String getCstmsAckDesc() {
		return this.cstmsAckDesc;
	}
	
	/**
	 * Column Info
	 * @return msg
	 */
	public String getMsg() {
		return this.msg;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return tmp2
	 */
	public String getTmp2() {
		return this.tmp2;
	}
	
	/**
	 * Column Info
	 * @return errDesc
	 */
	public String getErrDesc() {
		return this.errDesc;
	}
	
	/**
	 * Column Info
	 * @return tmp1
	 */
	public String getTmp1() {
		return this.tmp1;
	}
	
	/**
	 * Column Info
	 * @return isfActCd
	 */
	public String getIsfActCd() {
		return this.isfActCd;
	}
	
	/**
	 * Column Info
	 * @return sndProcId
	 */
	public String getSndProcId() {
		return this.sndProcId;
	}
	
	/**
	 * Column Info
	 * @return tmp3
	 */
	public String getTmp3() {
		return this.tmp3;
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
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return cvyRefNo
	 */
	public String getCvyRefNo() {
		return this.cvyRefNo;
	}
	
	/**
	 * Column Info
	 * @return hiddenVvd
	 */
	public String getHiddenVvd() {
		return this.hiddenVvd;
	}
	
	/**
	 * Column Info
	 * @param sndDt
	 */
	public void setSndDt(String sndDt) {
		this.sndDt = sndDt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param errResult
	 */
	public void setErrResult(String errResult) {
		this.errResult = errResult;
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
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param pol
	 */
	public void setPol(String pol) {
		this.pol = pol;
	}

	/**
	 * Column Info
	 * @param dtlSeq
	 */
	public void setDtlSeq(String dtlSeq) {
		this.dtlSeq = dtlSeq;
	}
	
	
	/**
	 * Column Info
	 * @param rcvDt
	 */
	public void setRcvDt(String rcvDt) {
		this.rcvDt = rcvDt;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param pod
	 */
	public void setPod(String pod) {
		this.pod = pod;
	}
	
	/**
	 * Column Info
	 * @param cstmsAckStsCd
	 */
	public void setCstmsAckStsCd(String cstmsAckStsCd) {
		this.cstmsAckStsCd = cstmsAckStsCd;
	}
	
	/**
	 * Column Info
	 * @param cstmsAckCd
	 */
	public void setCstmsAckCd(String cstmsAckCd) {
		this.cstmsAckCd = cstmsAckCd;
	}
	
	/**
	 * Column Info
	 * @param cntrCount
	 */
	public void setCntrCount(String cntrCount) {
		this.cntrCount = cntrCount;
	}
	
	/**
	 * Column Info
	 * @param errCode
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	/**
	 * Column Info
	 * @param crrBatNo
	 */
	public void setCrrBatNo(String crrBatNo) {
		this.crrBatNo = crrBatNo;
	}
	
	/**
	 * Column Info
	 * @param cstmsAckDesc
	 */
	public void setCstmsAckDesc(String cstmsAckDesc) {
		this.cstmsAckDesc = cstmsAckDesc;
	}
	
	/**
	 * Column Info
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param tmp2
	 */
	public void setTmp2(String tmp2) {
		this.tmp2 = tmp2;
	}
	
	/**
	 * Column Info
	 * @param errDesc
	 */
	public void setErrDesc(String errDesc) {
		this.errDesc = errDesc;
	}
	
	/**
	 * Column Info
	 * @param tmp1
	 */
	public void setTmp1(String tmp1) {
		this.tmp1 = tmp1;
	}
	
	/**
	 * Column Info
	 * @param isfActCd
	 */
	public void setIsfActCd(String isfActCd) {
		this.isfActCd = isfActCd;
	}
	
	/**
	 * Column Info
	 * @param sndProcId
	 */
	public void setSndProcId(String sndProcId) {
		this.sndProcId = sndProcId;
	}
	
	/**
	 * Column Info
	 * @param tmp3
	 */
	public void setTmp3(String tmp3) {
		this.tmp3 = tmp3;
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
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param cvyRefNo
	 */
	public void setCvyRefNo(String cvyRefNo) {
		this.cvyRefNo = cvyRefNo;
	}
	
	/**
	 * Column Info
	 * @param hiddenVvd
	 */
	public void setHiddenVvd(String hiddenVvd) {
		this.hiddenVvd = hiddenVvd;
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
		setSndDt(JSPUtil.getParameter(request, prefix + "snd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setErrResult(JSPUtil.getParameter(request, prefix + "err_result", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request, prefix + "usr_id", ""));
		setPol(JSPUtil.getParameter(request, prefix + "pol", ""));
		setDtlSeq(JSPUtil.getParameter(request, prefix + "dtl_seq", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, prefix + "cstms_port_cd", ""));
		setPod(JSPUtil.getParameter(request, prefix + "pod", ""));
		setCstmsAckStsCd(JSPUtil.getParameter(request, prefix + "cstms_ack_sts_cd", ""));
		setCstmsAckCd(JSPUtil.getParameter(request, prefix + "cstms_ack_cd", ""));
		setCntrCount(JSPUtil.getParameter(request, prefix + "cntr_count", ""));
		setErrCode(JSPUtil.getParameter(request, prefix + "err_code", ""));
		setCrrBatNo(JSPUtil.getParameter(request, prefix + "crr_bat_no", ""));
		setCstmsAckDesc(JSPUtil.getParameter(request, prefix + "cstms_ack_desc", ""));
		setMsg(JSPUtil.getParameter(request, prefix + "msg", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setTmp2(JSPUtil.getParameter(request, prefix + "tmp2", ""));
		setErrDesc(JSPUtil.getParameter(request, prefix + "err_desc", ""));
		setTmp1(JSPUtil.getParameter(request, prefix + "tmp1", ""));
		setIsfActCd(JSPUtil.getParameter(request, prefix + "isf_act_cd", ""));
		setSndProcId(JSPUtil.getParameter(request, prefix + "snd_proc_id", ""));
		setTmp3(JSPUtil.getParameter(request, prefix + "tmp3", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setRcvDt(JSPUtil.getParameter(request, prefix + "rcv_dt", ""));
		setCvyRefNo(JSPUtil.getParameter(request, prefix + "cvy_ref_no", ""));
		setHiddenVvd(JSPUtil.getParameter(request, prefix + "hidden_vvd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SendDetailLogCndVO[]
	 */
	public SendDetailLogCndVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SendDetailLogCndVO[]
	 */
	public SendDetailLogCndVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SendDetailLogCndVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] errResult = (JSPUtil.getParameter(request, prefix	+ "err_result", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] pol = (JSPUtil.getParameter(request, prefix	+ "pol", length));
			String[] dtlSeq = (JSPUtil.getParameter(request, prefix	+ "dtl_seq", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] pod = (JSPUtil.getParameter(request, prefix	+ "pod", length));
			String[] cstmsAckStsCd = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_sts_cd", length));
			String[] cstmsAckCd = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_cd", length));
			String[] cntrCount = (JSPUtil.getParameter(request, prefix	+ "cntr_count", length));
			String[] errCode = (JSPUtil.getParameter(request, prefix	+ "err_code", length));
			String[] crrBatNo = (JSPUtil.getParameter(request, prefix	+ "crr_bat_no", length));
			String[] cstmsAckDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_ack_desc", length));
			String[] msg = (JSPUtil.getParameter(request, prefix	+ "msg", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] tmp2 = (JSPUtil.getParameter(request, prefix	+ "tmp2", length));
			String[] errDesc = (JSPUtil.getParameter(request, prefix	+ "err_desc", length));
			String[] tmp1 = (JSPUtil.getParameter(request, prefix	+ "tmp1", length));
			String[] isfActCd = (JSPUtil.getParameter(request, prefix	+ "isf_act_cd", length));
			String[] sndProcId = (JSPUtil.getParameter(request, prefix	+ "snd_proc_id", length));
			String[] tmp3 = (JSPUtil.getParameter(request, prefix	+ "tmp3", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] rcvDt = (JSPUtil.getParameter(request, prefix	+ "rcv_dt", length));
			String[] cvyRefNo = (JSPUtil.getParameter(request, prefix	+ "cvy_ref_no", length));
			String[] hiddenVvd = (JSPUtil.getParameter(request, prefix	+ "hidden_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SendDetailLogCndVO();
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (errResult[i] != null)
					model.setErrResult(errResult[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (pol[i] != null)
					model.setPol(pol[i]);
				if (dtlSeq[i] != null)
					model.setDtlSeq(dtlSeq[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (pod[i] != null)
					model.setPod(pod[i]);
				if (cstmsAckStsCd[i] != null)
					model.setCstmsAckStsCd(cstmsAckStsCd[i]);
				if (cstmsAckCd[i] != null)
					model.setCstmsAckCd(cstmsAckCd[i]);
				if (cntrCount[i] != null)
					model.setCntrCount(cntrCount[i]);
				if (errCode[i] != null)
					model.setErrCode(errCode[i]);
				if (crrBatNo[i] != null)
					model.setCrrBatNo(crrBatNo[i]);
				if (cstmsAckDesc[i] != null)
					model.setCstmsAckDesc(cstmsAckDesc[i]);
				if (msg[i] != null)
					model.setMsg(msg[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (tmp2[i] != null)
					model.setTmp2(tmp2[i]);
				if (errDesc[i] != null)
					model.setErrDesc(errDesc[i]);
				if (tmp1[i] != null)
					model.setTmp1(tmp1[i]);
				if (isfActCd[i] != null)
					model.setIsfActCd(isfActCd[i]);
				if (sndProcId[i] != null)
					model.setSndProcId(sndProcId[i]);
				if (tmp3[i] != null)
					model.setTmp3(tmp3[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (rcvDt[i] != null)
					model.setRcvDt(rcvDt[i]);
				if (cvyRefNo[i] != null)
					model.setCvyRefNo(cvyRefNo[i]);
				if (hiddenVvd[i] != null)
					model.setHiddenVvd(hiddenVvd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSendDetailLogCndVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SendDetailLogCndVO[]
	 */
	public SendDetailLogCndVO[] getSendDetailLogCndVOs(){
		SendDetailLogCndVO[] vos = (SendDetailLogCndVO[])models.toArray(new SendDetailLogCndVO[models.size()]);
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
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errResult = this.errResult .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol = this.pol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtlSeq = this.dtlSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod = this.pod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckStsCd = this.cstmsAckStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckCd = this.cstmsAckCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCount = this.cntrCount .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCode = this.errCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrBatNo = this.crrBatNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsAckDesc = this.cstmsAckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msg = this.msg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp2 = this.tmp2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDesc = this.errDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp1 = this.tmp1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isfActCd = this.isfActCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndProcId = this.sndProcId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmp3 = this.tmp3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt = this.rcvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cvyRefNo = this.cvyRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hiddenVvd = this.hiddenVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
