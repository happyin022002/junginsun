/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorBkgDgVvdVO.java
*@FileTitle : KorBkgDgVvdVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.26
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009.08.26 박상훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea.vo;

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
 * @author 박상훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class KorBkgDgVvdVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorBkgDgVvdVO> models = new ArrayList<KorBkgDgVvdVO>();
	
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String portArea = null;
	/* Column Info */
	private String docNo = null;
	/* Column Info */
	private String data = null;
	/* Column Info */
	private String dgcoSeq = null;
	/* Column Info */
	private String sndTm = null;
	/* Column Info */
	private String sndDt = null;
	/* Column Info */
	private String contact = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String substance = null;
	/* Column Info */
	private String authority = null;
	/* Column Info */
	private String dchgComCd = null;
	/* Column Info */
	private String jobCode1 = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String arvDt = null;
	/* Column Info */
	private String userId = null;
	/* Column Info */
	private String callKnt = null;
	/* Column Info */
	private String portCd = null;
	/* Column Info */
	private String totalWgt = null;
	/* Column Info */
	private String jobCode2 = null;
	/* Column Info */
	private String prePort = null;
	/* Column Info */
	private String portAnch = null;
	/* Column Info */
	private String portDesc = null;
	/* Column Info */
	private String mrnChkNo = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String ioBndCd = null;
	/* Column Info */
	private String io = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String ioDt = null;
	/* Column Info */
	private String dschComNm = null;
	/* Column Info */
	private String totalCntr = null;
	/* Column Info */
	private String transCode = null;
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorBkgDgVvdVO() {}

	public KorBkgDgVvdVO(String ibflag, String pagerows, String mrnNo, String mrnChkNo, String vvd, String portCd, String ioBndCd, String vslEngNm, String callSgnNo, String sndDt, String sndTm, String docNo, String authority, String io, String callKnt, String arvDt, String transCode, String dchgComCd, String dschComNm, String totalCntr, String totalWgt, String jobCode1, String jobCode2, String fromDt, String toDt, String prePort, String portArea, String portAnch, String portDesc, String substance, String contact, String polCd, String podCd, String userId, String ioDt, String data, String dgcoSeq) {
		this.fromDt = fromDt;
		this.portArea = portArea;
		this.docNo = docNo;
		this.data = data;
		this.dgcoSeq = dgcoSeq;
		this.sndTm = sndTm;
		this.sndDt = sndDt;
		this.contact = contact;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.substance = substance;
		this.authority = authority;
		this.dchgComCd = dchgComCd;
		this.jobCode1 = jobCode1;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vslEngNm = vslEngNm;
		this.arvDt = arvDt;
		this.userId = userId;
		this.callKnt = callKnt;
		this.portCd = portCd;
		this.totalWgt = totalWgt;
		this.jobCode2 = jobCode2;
		this.prePort = prePort;
		this.portAnch = portAnch;
		this.portDesc = portDesc;
		this.mrnChkNo = mrnChkNo;
		this.callSgnNo = callSgnNo;
		this.ioBndCd = ioBndCd;
		this.io = io;
		this.podCd = podCd;
		this.vvd = vvd;
		this.toDt = toDt;
		this.ioDt = ioDt;
		this.dschComNm = dschComNm;
		this.totalCntr = totalCntr;
		this.transCode = transCode;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("port_area", getPortArea());
		this.hashColumns.put("doc_no", getDocNo());
		this.hashColumns.put("data", getData());
		this.hashColumns.put("dgco_seq", getDgcoSeq());
		this.hashColumns.put("snd_tm", getSndTm());
		this.hashColumns.put("snd_dt", getSndDt());
		this.hashColumns.put("contact", getContact());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("substance", getSubstance());
		this.hashColumns.put("authority", getAuthority());
		this.hashColumns.put("dchg_com_cd", getDchgComCd());
		this.hashColumns.put("job_code1", getJobCode1());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("arv_dt", getArvDt());
		this.hashColumns.put("user_id", getUserId());
		this.hashColumns.put("call_knt", getCallKnt());
		this.hashColumns.put("port_cd", getPortCd());
		this.hashColumns.put("total_wgt", getTotalWgt());
		this.hashColumns.put("job_code2", getJobCode2());
		this.hashColumns.put("pre_port", getPrePort());
		this.hashColumns.put("port_anch", getPortAnch());
		this.hashColumns.put("port_desc", getPortDesc());
		this.hashColumns.put("mrn_chk_no", getMrnChkNo());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		this.hashColumns.put("io", getIo());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("io_dt", getIoDt());
		this.hashColumns.put("dsch_com_nm", getDschComNm());
		this.hashColumns.put("total_cntr", getTotalCntr());
		this.hashColumns.put("trans_code", getTransCode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("port_area", "portArea");
		this.hashFields.put("doc_no", "docNo");
		this.hashFields.put("data", "data");
		this.hashFields.put("dgco_seq", "dgcoSeq");
		this.hashFields.put("snd_tm", "sndTm");
		this.hashFields.put("snd_dt", "sndDt");
		this.hashFields.put("contact", "contact");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("substance", "substance");
		this.hashFields.put("authority", "authority");
		this.hashFields.put("dchg_com_cd", "dchgComCd");
		this.hashFields.put("job_code1", "jobCode1");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("arv_dt", "arvDt");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("call_knt", "callKnt");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("total_wgt", "totalWgt");
		this.hashFields.put("job_code2", "jobCode2");
		this.hashFields.put("pre_port", "prePort");
		this.hashFields.put("port_anch", "portAnch");
		this.hashFields.put("port_desc", "portDesc");
		this.hashFields.put("mrn_chk_no", "mrnChkNo");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("io", "io");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("io_dt", "ioDt");
		this.hashFields.put("dsch_com_nm", "dschComNm");
		this.hashFields.put("total_cntr", "totalCntr");
		this.hashFields.put("trans_code", "transCode");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return portArea
	 */
	public String getPortArea() {
		return this.portArea;
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
	 * @return data
	 */
	public String getData() {
		return this.data;
	}
	
	/**
	 * Column Info
	 * @return dgcoSeq
	 */
	public String getDgcoSeq() {
		return this.dgcoSeq;
	}
	
	/**
	 * Column Info
	 * @return sndTm
	 */
	public String getSndTm() {
		return this.sndTm;
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
	 * @return contact
	 */
	public String getContact() {
		return this.contact;
	}
	
	/**
	 * Column Info
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return substance
	 */
	public String getSubstance() {
		return this.substance;
	}
	
	/**
	 * Column Info
	 * @return authority
	 */
	public String getAuthority() {
		return this.authority;
	}
	
	/**
	 * Column Info
	 * @return dchgComCd
	 */
	public String getDchgComCd() {
		return this.dchgComCd;
	}
	
	/**
	 * Column Info
	 * @return jobCode1
	 */
	public String getJobCode1() {
		return this.jobCode1;
	}
	
	/**
	 * Column Info
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return arvDt
	 */
	public String getArvDt() {
		return this.arvDt;
	}
	
	/**
	 * Column Info
	 * @return userId
	 */
	public String getUserId() {
		return this.userId;
	}
	
	/**
	 * Column Info
	 * @return callKnt
	 */
	public String getCallKnt() {
		return this.callKnt;
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
	 * @return totalWgt
	 */
	public String getTotalWgt() {
		return this.totalWgt;
	}
	
	/**
	 * Column Info
	 * @return jobCode2
	 */
	public String getJobCode2() {
		return this.jobCode2;
	}
	
	/**
	 * Column Info
	 * @return prePort
	 */
	public String getPrePort() {
		return this.prePort;
	}
	
	/**
	 * Column Info
	 * @return portAnch
	 */
	public String getPortAnch() {
		return this.portAnch;
	}
	
	/**
	 * Column Info
	 * @return portDesc
	 */
	public String getPortDesc() {
		return this.portDesc;
	}
	
	/**
	 * Column Info
	 * @return mrnChkNo
	 */
	public String getMrnChkNo() {
		return this.mrnChkNo;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
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
	 * @return io
	 */
	public String getIo() {
		return this.io;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
	}
	
	/**
	 * Column Info
	 * @return ioDt
	 */
	public String getIoDt() {
		return this.ioDt;
	}
	
	/**
	 * Column Info
	 * @return dschComNm
	 */
	public String getDschComNm() {
		return this.dschComNm;
	}
	
	/**
	 * Column Info
	 * @return totalCntr
	 */
	public String getTotalCntr() {
		return this.totalCntr;
	}
	
	/**
	 * Column Info
	 * @return transCode
	 */
	public String getTransCode() {
		return this.transCode;
	}
	

	/**
	 * Column Info
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param portArea
	 */
	public void setPortArea(String portArea) {
		this.portArea = portArea;
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
	 * @param data
	 */
	public void setData(String data) {
		this.data = data;
	}
	
	/**
	 * Column Info
	 * @param dgcoSeq
	 */
	public void setDgcoSeq(String dgcoSeq) {
		this.dgcoSeq = dgcoSeq;
	}
	
	/**
	 * Column Info
	 * @param sndTm
	 */
	public void setSndTm(String sndTm) {
		this.sndTm = sndTm;
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
	 * @param contact
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	/**
	 * Column Info
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param substance
	 */
	public void setSubstance(String substance) {
		this.substance = substance;
	}
	
	/**
	 * Column Info
	 * @param authority
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	/**
	 * Column Info
	 * @param dchgComCd
	 */
	public void setDchgComCd(String dchgComCd) {
		this.dchgComCd = dchgComCd;
	}
	
	/**
	 * Column Info
	 * @param jobCode1
	 */
	public void setJobCode1(String jobCode1) {
		this.jobCode1 = jobCode1;
	}
	
	/**
	 * Column Info
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param arvDt
	 */
	public void setArvDt(String arvDt) {
		this.arvDt = arvDt;
	}
	
	/**
	 * Column Info
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * Column Info
	 * @param callKnt
	 */
	public void setCallKnt(String callKnt) {
		this.callKnt = callKnt;
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
	 * @param totalWgt
	 */
	public void setTotalWgt(String totalWgt) {
		this.totalWgt = totalWgt;
	}
	
	/**
	 * Column Info
	 * @param jobCode2
	 */
	public void setJobCode2(String jobCode2) {
		this.jobCode2 = jobCode2;
	}
	
	/**
	 * Column Info
	 * @param prePort
	 */
	public void setPrePort(String prePort) {
		this.prePort = prePort;
	}
	
	/**
	 * Column Info
	 * @param portAnch
	 */
	public void setPortAnch(String portAnch) {
		this.portAnch = portAnch;
	}
	
	/**
	 * Column Info
	 * @param portDesc
	 */
	public void setPortDesc(String portDesc) {
		this.portDesc = portDesc;
	}
	
	/**
	 * Column Info
	 * @param mrnChkNo
	 */
	public void setMrnChkNo(String mrnChkNo) {
		this.mrnChkNo = mrnChkNo;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
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
	 * @param io
	 */
	public void setIo(String io) {
		this.io = io;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
	}
	
	/**
	 * Column Info
	 * @param ioDt
	 */
	public void setIoDt(String ioDt) {
		this.ioDt = ioDt;
	}
	
	/**
	 * Column Info
	 * @param dschComNm
	 */
	public void setDschComNm(String dschComNm) {
		this.dschComNm = dschComNm;
	}
	
	/**
	 * Column Info
	 * @param totalCntr
	 */
	public void setTotalCntr(String totalCntr) {
		this.totalCntr = totalCntr;
	}
	
	/**
	 * Column Info
	 * @param transCode
	 */
	public void setTransCode(String transCode) {
		this.transCode = transCode;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setPortArea(JSPUtil.getParameter(request, "port_area", ""));
		setDocNo(JSPUtil.getParameter(request, "doc_no", ""));
		setData(JSPUtil.getParameter(request, "data", ""));
		setDgcoSeq(JSPUtil.getParameter(request, "dgco_seq", ""));
		setSndTm(JSPUtil.getParameter(request, "snd_tm", ""));
		setSndDt(JSPUtil.getParameter(request, "snd_dt", ""));
		setContact(JSPUtil.getParameter(request, "contact", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setSubstance(JSPUtil.getParameter(request, "substance", ""));
		setAuthority(JSPUtil.getParameter(request, "authority", ""));
		setDchgComCd(JSPUtil.getParameter(request, "dchg_com_cd", ""));
		setJobCode1(JSPUtil.getParameter(request, "job_code1", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setArvDt(JSPUtil.getParameter(request, "arv_dt", ""));
		setUserId(JSPUtil.getParameter(request, "user_id", ""));
		setCallKnt(JSPUtil.getParameter(request, "call_knt", ""));
		setPortCd(JSPUtil.getParameter(request, "port_cd", ""));
		setTotalWgt(JSPUtil.getParameter(request, "total_wgt", ""));
		setJobCode2(JSPUtil.getParameter(request, "job_code2", ""));
		setPrePort(JSPUtil.getParameter(request, "pre_port", ""));
		setPortAnch(JSPUtil.getParameter(request, "port_anch", ""));
		setPortDesc(JSPUtil.getParameter(request, "port_desc", ""));
		setMrnChkNo(JSPUtil.getParameter(request, "mrn_chk_no", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setIoBndCd(JSPUtil.getParameter(request, "io_bnd_cd", ""));
		setIo(JSPUtil.getParameter(request, "io", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setIoDt(JSPUtil.getParameter(request, "io_dt", ""));
		setDschComNm(JSPUtil.getParameter(request, "dsch_com_nm", ""));
		setTotalCntr(JSPUtil.getParameter(request, "total_cntr", ""));
		setTransCode(JSPUtil.getParameter(request, "trans_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorBkgDgVvdVO[]
	 */
	public KorBkgDgVvdVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorBkgDgVvdVO[]
	 */
	public KorBkgDgVvdVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorBkgDgVvdVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt", length));
			String[] portArea = (JSPUtil.getParameter(request, prefix	+ "port_area", length));
			String[] docNo = (JSPUtil.getParameter(request, prefix	+ "doc_no", length));
			String[] data = (JSPUtil.getParameter(request, prefix	+ "data", length));
			String[] dgcoSeq = (JSPUtil.getParameter(request, prefix	+ "dgco_seq", length));
			String[] sndTm = (JSPUtil.getParameter(request, prefix	+ "snd_tm", length));
			String[] sndDt = (JSPUtil.getParameter(request, prefix	+ "snd_dt", length));
			String[] contact = (JSPUtil.getParameter(request, prefix	+ "contact", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] substance = (JSPUtil.getParameter(request, prefix	+ "substance", length));
			String[] authority = (JSPUtil.getParameter(request, prefix	+ "authority", length));
			String[] dchgComCd = (JSPUtil.getParameter(request, prefix	+ "dchg_com_cd", length));
			String[] jobCode1 = (JSPUtil.getParameter(request, prefix	+ "job_code1", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] arvDt = (JSPUtil.getParameter(request, prefix	+ "arv_dt", length));
			String[] userId = (JSPUtil.getParameter(request, prefix	+ "user_id", length));
			String[] callKnt = (JSPUtil.getParameter(request, prefix	+ "call_knt", length));
			String[] portCd = (JSPUtil.getParameter(request, prefix	+ "port_cd", length));
			String[] totalWgt = (JSPUtil.getParameter(request, prefix	+ "total_wgt", length));
			String[] jobCode2 = (JSPUtil.getParameter(request, prefix	+ "job_code2", length));
			String[] prePort = (JSPUtil.getParameter(request, prefix	+ "pre_port", length));
			String[] portAnch = (JSPUtil.getParameter(request, prefix	+ "port_anch", length));
			String[] portDesc = (JSPUtil.getParameter(request, prefix	+ "port_desc", length));
			String[] mrnChkNo = (JSPUtil.getParameter(request, prefix	+ "mrn_chk_no", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			String[] io = (JSPUtil.getParameter(request, prefix	+ "io", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt", length));
			String[] ioDt = (JSPUtil.getParameter(request, prefix	+ "io_dt", length));
			String[] dschComNm = (JSPUtil.getParameter(request, prefix	+ "dsch_com_nm", length));
			String[] totalCntr = (JSPUtil.getParameter(request, prefix	+ "total_cntr", length));
			String[] transCode = (JSPUtil.getParameter(request, prefix	+ "trans_code", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorBkgDgVvdVO();
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (portArea[i] != null)
					model.setPortArea(portArea[i]);
				if (docNo[i] != null)
					model.setDocNo(docNo[i]);
				if (data[i] != null)
					model.setData(data[i]);
				if (dgcoSeq[i] != null)
					model.setDgcoSeq(dgcoSeq[i]);
				if (sndTm[i] != null)
					model.setSndTm(sndTm[i]);
				if (sndDt[i] != null)
					model.setSndDt(sndDt[i]);
				if (contact[i] != null)
					model.setContact(contact[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (substance[i] != null)
					model.setSubstance(substance[i]);
				if (authority[i] != null)
					model.setAuthority(authority[i]);
				if (dchgComCd[i] != null)
					model.setDchgComCd(dchgComCd[i]);
				if (jobCode1[i] != null)
					model.setJobCode1(jobCode1[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (arvDt[i] != null)
					model.setArvDt(arvDt[i]);
				if (userId[i] != null)
					model.setUserId(userId[i]);
				if (callKnt[i] != null)
					model.setCallKnt(callKnt[i]);
				if (portCd[i] != null)
					model.setPortCd(portCd[i]);
				if (totalWgt[i] != null)
					model.setTotalWgt(totalWgt[i]);
				if (jobCode2[i] != null)
					model.setJobCode2(jobCode2[i]);
				if (prePort[i] != null)
					model.setPrePort(prePort[i]);
				if (portAnch[i] != null)
					model.setPortAnch(portAnch[i]);
				if (portDesc[i] != null)
					model.setPortDesc(portDesc[i]);
				if (mrnChkNo[i] != null)
					model.setMrnChkNo(mrnChkNo[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				if (io[i] != null)
					model.setIo(io[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (ioDt[i] != null)
					model.setIoDt(ioDt[i]);
				if (dschComNm[i] != null)
					model.setDschComNm(dschComNm[i]);
				if (totalCntr[i] != null)
					model.setTotalCntr(totalCntr[i]);
				if (transCode[i] != null)
					model.setTransCode(transCode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorBkgDgVvdVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorBkgDgVvdVO[]
	 */
	public KorBkgDgVvdVO[] getKorBkgDgVvdVOs(){
		KorBkgDgVvdVO[] vos = (KorBkgDgVvdVO[])models.toArray(new KorBkgDgVvdVO[models.size()]);
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
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portArea = this.portArea .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docNo = this.docNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.data = this.data .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgcoSeq = this.dgcoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndTm = this.sndTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sndDt = this.sndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contact = this.contact .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.substance = this.substance .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authority = this.authority .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dchgComCd = this.dchgComCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobCode1 = this.jobCode1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arvDt = this.arvDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId = this.userId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callKnt = this.callKnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd = this.portCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalWgt = this.totalWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jobCode2 = this.jobCode2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePort = this.prePort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portAnch = this.portAnch .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portDesc = this.portDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnChkNo = this.mrnChkNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.io = this.io .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioDt = this.ioDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dschComNm = this.dschComNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCntr = this.totalCntr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transCode = this.transCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
