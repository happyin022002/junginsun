/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GuaranteeCommonVO.java
*@FileTitle : GuaranteeCommonVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.08
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.12.08 yOng hO lEE 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author yOng hO lEE
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class GuaranteeCommonVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GuaranteeCommonVO> models = new ArrayList<GuaranteeCommonVO>();
	
	/* Column Info */
	private String fmCreDt = null;
	/* Column Info */
	private String gnteCustCd = null;
	/* Column Info */
	private String rcvInfo = null;
	/* Column Info */
	private String param = null;
	/* Column Info */
	private String fCmd = null;
	/* Column Info */
	private String faxNum = null;
	/* Column Info */
	private String emailContents = null;
	/* Column Info */
	private String emailAddr = null;
	/* Column Info */
	private String emailTitle = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String gnteNo = null;
	/* Column Info */
	private String functionname = null;
	/* Column Info */
	private String def = null;
	/* Column Info */
	private String gnteFlg = null;
	/* Column Info */
	private String oid = null;
	/* Column Info */
	private String cntrSeq = null;
	/* Column Info */
	private String irrNo = null;
	/* Column Info */
	private String gnteTpCd = null;
	/* Column Info */
	private String bkgNoTmp = null;
	/* Column Info */
	private String ifrid = null;
	/* Column Info */
	private String faxTitle = null;
	/* Column Info */
	private String creFlg = null;
	/* Column Info */
	private String idx = null;
	/* Column Info */
	private String batchInd = null;
	/* Column Info */
	private String tesMode = null;
	/* Column Info */
	private String appCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String sysCd = null;
	/* Column Info */
	private String refNo = null;
	/* Column Info */
	private String cntrNoTmp = null;
	/* Column Info */
	private String toCreDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GuaranteeCommonVO() {}

	public GuaranteeCommonVO(String ibflag, String pagerows, String tesMode, String oid, String idx, String fCmd, String def, String functionname, String ifrid, String fmCreDt, String toCreDt, String cntrNoTmp, String bkgNoTmp, String gnteTpCd, String ofcCd, String refNo, String cntrNo, String blNo, String bkgNo, String invNo, String gnteCustCd, String gnteFlg, String gnteNo, String irrNo, String creFlg, String cntrSeq, String sysCd, String appCd, String batchInd, String faxTitle, String param, String rcvInfo, String emailTitle, String emailContents, String emailAddr, String faxNum) {
		this.fmCreDt = fmCreDt;
		this.gnteCustCd = gnteCustCd;
		this.rcvInfo = rcvInfo;
		this.param = param;
		this.fCmd = fCmd;
		this.faxNum = faxNum;
		this.emailContents = emailContents;
		this.emailAddr = emailAddr;
		this.emailTitle = emailTitle;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.gnteNo = gnteNo;
		this.functionname = functionname;
		this.def = def;
		this.gnteFlg = gnteFlg;
		this.oid = oid;
		this.cntrSeq = cntrSeq;
		this.irrNo = irrNo;
		this.gnteTpCd = gnteTpCd;
		this.bkgNoTmp = bkgNoTmp;
		this.ifrid = ifrid;
		this.faxTitle = faxTitle;
		this.creFlg = creFlg;
		this.idx = idx;
		this.batchInd = batchInd;
		this.tesMode = tesMode;
		this.appCd = appCd;
		this.invNo = invNo;
		this.ofcCd = ofcCd;
		this.bkgNo = bkgNo;
		this.cntrNo = cntrNo;
		this.sysCd = sysCd;
		this.refNo = refNo;
		this.cntrNoTmp = cntrNoTmp;
		this.toCreDt = toCreDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("fm_cre_dt", getFmCreDt());
		this.hashColumns.put("gnte_cust_cd", getGnteCustCd());
		this.hashColumns.put("rcv_info", getRcvInfo());
		this.hashColumns.put("param", getParam());
		this.hashColumns.put("f_cmd", getFCmd());
		this.hashColumns.put("fax_num", getFaxNum());
		this.hashColumns.put("email_contents", getEmailContents());
		this.hashColumns.put("email_addr", getEmailAddr());
		this.hashColumns.put("email_title", getEmailTitle());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("gnte_no", getGnteNo());
		this.hashColumns.put("functionname", getFunctionname());
		this.hashColumns.put("def", getDef());
		this.hashColumns.put("gnte_flg", getGnteFlg());
		this.hashColumns.put("oid", getOid());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("irr_no", getIrrNo());
		this.hashColumns.put("gnte_tp_cd", getGnteTpCd());
		this.hashColumns.put("bkg_no_tmp", getBkgNoTmp());
		this.hashColumns.put("ifrid", getIfrid());
		this.hashColumns.put("fax_title", getFaxTitle());
		this.hashColumns.put("cre_flg", getCreFlg());
		this.hashColumns.put("idx", getIdx());
		this.hashColumns.put("batch_ind", getBatchInd());
		this.hashColumns.put("tes_mode", getTesMode());
		this.hashColumns.put("app_cd", getAppCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sys_cd", getSysCd());
		this.hashColumns.put("ref_no", getRefNo());
		this.hashColumns.put("cntr_no_tmp", getCntrNoTmp());
		this.hashColumns.put("to_cre_dt", getToCreDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("fm_cre_dt", "fmCreDt");
		this.hashFields.put("gnte_cust_cd", "gnteCustCd");
		this.hashFields.put("rcv_info", "rcvInfo");
		this.hashFields.put("param", "param");
		this.hashFields.put("f_cmd", "fCmd");
		this.hashFields.put("fax_num", "faxNum");
		this.hashFields.put("email_contents", "emailContents");
		this.hashFields.put("email_addr", "emailAddr");
		this.hashFields.put("email_title", "emailTitle");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gnte_no", "gnteNo");
		this.hashFields.put("functionname", "functionname");
		this.hashFields.put("def", "def");
		this.hashFields.put("gnte_flg", "gnteFlg");
		this.hashFields.put("oid", "oid");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("irr_no", "irrNo");
		this.hashFields.put("gnte_tp_cd", "gnteTpCd");
		this.hashFields.put("bkg_no_tmp", "bkgNoTmp");
		this.hashFields.put("ifrid", "ifrid");
		this.hashFields.put("fax_title", "faxTitle");
		this.hashFields.put("cre_flg", "creFlg");
		this.hashFields.put("idx", "idx");
		this.hashFields.put("batch_ind", "batchInd");
		this.hashFields.put("tes_mode", "tesMode");
		this.hashFields.put("app_cd", "appCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sys_cd", "sysCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cntr_no_tmp", "cntrNoTmp");
		this.hashFields.put("to_cre_dt", "toCreDt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return fmCreDt
	 */
	public String getFmCreDt() {
		return this.fmCreDt;
	}
	
	/**
	 * Column Info
	 * @return gnteCustCd
	 */
	public String getGnteCustCd() {
		return this.gnteCustCd;
	}
	
	/**
	 * Column Info
	 * @return rcvInfo
	 */
	public String getRcvInfo() {
		return this.rcvInfo;
	}
	
	/**
	 * Column Info
	 * @return param
	 */
	public String getParam() {
		return this.param;
	}
	
	/**
	 * Column Info
	 * @return fCmd
	 */
	public String getFCmd() {
		return this.fCmd;
	}
	
	/**
	 * Column Info
	 * @return faxNum
	 */
	public String getFaxNum() {
		return this.faxNum;
	}
	
	/**
	 * Column Info
	 * @return emailContents
	 */
	public String getEmailContents() {
		return this.emailContents;
	}
	
	/**
	 * Column Info
	 * @return emailAddr
	 */
	public String getEmailAddr() {
		return this.emailAddr;
	}
	
	/**
	 * Column Info
	 * @return emailTitle
	 */
	public String getEmailTitle() {
		return this.emailTitle;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return gnteNo
	 */
	public String getGnteNo() {
		return this.gnteNo;
	}
	
	/**
	 * Column Info
	 * @return functionname
	 */
	public String getFunctionname() {
		return this.functionname;
	}
	
	/**
	 * Column Info
	 * @return def
	 */
	public String getDef() {
		return this.def;
	}
	
	/**
	 * Column Info
	 * @return gnteFlg
	 */
	public String getGnteFlg() {
		return this.gnteFlg;
	}
	
	/**
	 * Column Info
	 * @return oid
	 */
	public String getOid() {
		return this.oid;
	}
	
	/**
	 * Column Info
	 * @return cntrSeq
	 */
	public String getCntrSeq() {
		return this.cntrSeq;
	}
	
	/**
	 * Column Info
	 * @return irrNo
	 */
	public String getIrrNo() {
		return this.irrNo;
	}
	
	/**
	 * Column Info
	 * @return gnteTpCd
	 */
	public String getGnteTpCd() {
		return this.gnteTpCd;
	}
	
	/**
	 * Column Info
	 * @return bkgNoTmp
	 */
	public String getBkgNoTmp() {
		return this.bkgNoTmp;
	}
	
	/**
	 * Column Info
	 * @return ifrid
	 */
	public String getIfrid() {
		return this.ifrid;
	}
	
	/**
	 * Column Info
	 * @return faxTitle
	 */
	public String getFaxTitle() {
		return this.faxTitle;
	}
	
	/**
	 * Column Info
	 * @return creFlg
	 */
	public String getCreFlg() {
		return this.creFlg;
	}
	
	/**
	 * Column Info
	 * @return idx
	 */
	public String getIdx() {
		return this.idx;
	}
	
	/**
	 * Column Info
	 * @return batchInd
	 */
	public String getBatchInd() {
		return this.batchInd;
	}
	
	/**
	 * Column Info
	 * @return tesMode
	 */
	public String getTesMode() {
		return this.tesMode;
	}
	
	/**
	 * Column Info
	 * @return appCd
	 */
	public String getAppCd() {
		return this.appCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return sysCd
	 */
	public String getSysCd() {
		return this.sysCd;
	}
	
	/**
	 * Column Info
	 * @return refNo
	 */
	public String getRefNo() {
		return this.refNo;
	}
	
	/**
	 * Column Info
	 * @return cntrNoTmp
	 */
	public String getCntrNoTmp() {
		return this.cntrNoTmp;
	}
	
	/**
	 * Column Info
	 * @return toCreDt
	 */
	public String getToCreDt() {
		return this.toCreDt;
	}
	

	/**
	 * Column Info
	 * @param fmCreDt
	 */
	public void setFmCreDt(String fmCreDt) {
		this.fmCreDt = fmCreDt;
	}
	
	/**
	 * Column Info
	 * @param gnteCustCd
	 */
	public void setGnteCustCd(String gnteCustCd) {
		this.gnteCustCd = gnteCustCd;
	}
	
	/**
	 * Column Info
	 * @param rcvInfo
	 */
	public void setRcvInfo(String rcvInfo) {
		this.rcvInfo = rcvInfo;
	}
	
	/**
	 * Column Info
	 * @param param
	 */
	public void setParam(String param) {
		this.param = param;
	}
	
	/**
	 * Column Info
	 * @param fCmd
	 */
	public void setFCmd(String fCmd) {
		this.fCmd = fCmd;
	}
	
	/**
	 * Column Info
	 * @param faxNum
	 */
	public void setFaxNum(String faxNum) {
		this.faxNum = faxNum;
	}
	
	/**
	 * Column Info
	 * @param emailContents
	 */
	public void setEmailContents(String emailContents) {
		this.emailContents = emailContents;
	}
	
	/**
	 * Column Info
	 * @param emailAddr
	 */
	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}
	
	/**
	 * Column Info
	 * @param emailTitle
	 */
	public void setEmailTitle(String emailTitle) {
		this.emailTitle = emailTitle;
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
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param gnteNo
	 */
	public void setGnteNo(String gnteNo) {
		this.gnteNo = gnteNo;
	}
	
	/**
	 * Column Info
	 * @param functionname
	 */
	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}
	
	/**
	 * Column Info
	 * @param def
	 */
	public void setDef(String def) {
		this.def = def;
	}
	
	/**
	 * Column Info
	 * @param gnteFlg
	 */
	public void setGnteFlg(String gnteFlg) {
		this.gnteFlg = gnteFlg;
	}
	
	/**
	 * Column Info
	 * @param oid
	 */
	public void setOid(String oid) {
		this.oid = oid;
	}
	
	/**
	 * Column Info
	 * @param cntrSeq
	 */
	public void setCntrSeq(String cntrSeq) {
		this.cntrSeq = cntrSeq;
	}
	
	/**
	 * Column Info
	 * @param irrNo
	 */
	public void setIrrNo(String irrNo) {
		this.irrNo = irrNo;
	}
	
	/**
	 * Column Info
	 * @param gnteTpCd
	 */
	public void setGnteTpCd(String gnteTpCd) {
		this.gnteTpCd = gnteTpCd;
	}
	
	/**
	 * Column Info
	 * @param bkgNoTmp
	 */
	public void setBkgNoTmp(String bkgNoTmp) {
		this.bkgNoTmp = bkgNoTmp;
	}
	
	/**
	 * Column Info
	 * @param ifrid
	 */
	public void setIfrid(String ifrid) {
		this.ifrid = ifrid;
	}
	
	/**
	 * Column Info
	 * @param faxTitle
	 */
	public void setFaxTitle(String faxTitle) {
		this.faxTitle = faxTitle;
	}
	
	/**
	 * Column Info
	 * @param creFlg
	 */
	public void setCreFlg(String creFlg) {
		this.creFlg = creFlg;
	}
	
	/**
	 * Column Info
	 * @param idx
	 */
	public void setIdx(String idx) {
		this.idx = idx;
	}
	
	/**
	 * Column Info
	 * @param batchInd
	 */
	public void setBatchInd(String batchInd) {
		this.batchInd = batchInd;
	}
	
	/**
	 * Column Info
	 * @param tesMode
	 */
	public void setTesMode(String tesMode) {
		this.tesMode = tesMode;
	}
	
	/**
	 * Column Info
	 * @param appCd
	 */
	public void setAppCd(String appCd) {
		this.appCd = appCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param sysCd
	 */
	public void setSysCd(String sysCd) {
		this.sysCd = sysCd;
	}
	
	/**
	 * Column Info
	 * @param refNo
	 */
	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}
	
	/**
	 * Column Info
	 * @param cntrNoTmp
	 */
	public void setCntrNoTmp(String cntrNoTmp) {
		this.cntrNoTmp = cntrNoTmp;
	}
	
	/**
	 * Column Info
	 * @param toCreDt
	 */
	public void setToCreDt(String toCreDt) {
		this.toCreDt = toCreDt;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFmCreDt(JSPUtil.getParameter(request, "fm_cre_dt", ""));
		setGnteCustCd(JSPUtil.getParameter(request, "gnte_cust_cd", ""));
		setRcvInfo(JSPUtil.getParameter(request, "rcv_info", ""));
		setParam(JSPUtil.getParameter(request, "param", ""));
		setFCmd(JSPUtil.getParameter(request, "f_cmd", ""));
		setFaxNum(JSPUtil.getParameter(request, "fax_num", ""));
		setEmailContents(JSPUtil.getParameter(request, "email_contents", ""));
		setEmailAddr(JSPUtil.getParameter(request, "email_addr", ""));
		setEmailTitle(JSPUtil.getParameter(request, "email_title", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setGnteNo(JSPUtil.getParameter(request, "gnte_no", ""));
		setFunctionname(JSPUtil.getParameter(request, "functionname", ""));
		setDef(JSPUtil.getParameter(request, "def", ""));
		setGnteFlg(JSPUtil.getParameter(request, "gnte_flg", ""));
		setOid(JSPUtil.getParameter(request, "oid", ""));
		setCntrSeq(JSPUtil.getParameter(request, "cntr_seq", ""));
		setIrrNo(JSPUtil.getParameter(request, "irr_no", ""));
		setGnteTpCd(JSPUtil.getParameter(request, "gnte_tp_cd", ""));
		setBkgNoTmp(JSPUtil.getParameter(request, "bkg_no_tmp", ""));
		setIfrid(JSPUtil.getParameter(request, "ifrid", ""));
		setFaxTitle(JSPUtil.getParameter(request, "fax_title", ""));
		setCreFlg(JSPUtil.getParameter(request, "cre_flg", ""));
		setIdx(JSPUtil.getParameter(request, "idx", ""));
		setBatchInd(JSPUtil.getParameter(request, "batch_ind", ""));
		setTesMode(JSPUtil.getParameter(request, "tes_mode", ""));
		setAppCd(JSPUtil.getParameter(request, "app_cd", ""));
		setInvNo(JSPUtil.getParameter(request, "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setSysCd(JSPUtil.getParameter(request, "sys_cd", ""));
		setRefNo(JSPUtil.getParameter(request, "ref_no", ""));
		setCntrNoTmp(JSPUtil.getParameter(request, "cntr_no_tmp", ""));
		setToCreDt(JSPUtil.getParameter(request, "to_cre_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GuaranteeCommonVO[]
	 */
	public GuaranteeCommonVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GuaranteeCommonVO[]
	 */
	public GuaranteeCommonVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GuaranteeCommonVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] fmCreDt = (JSPUtil.getParameter(request, prefix	+ "fm_cre_dt", length));
			String[] gnteCustCd = (JSPUtil.getParameter(request, prefix	+ "gnte_cust_cd", length));
			String[] rcvInfo = (JSPUtil.getParameter(request, prefix	+ "rcv_info", length));
			String[] param = (JSPUtil.getParameter(request, prefix	+ "param", length));
			String[] fCmd = (JSPUtil.getParameter(request, prefix	+ "f_cmd", length));
			String[] faxNum = (JSPUtil.getParameter(request, prefix	+ "fax_num", length));
			String[] emailContents = (JSPUtil.getParameter(request, prefix	+ "email_contents", length));
			String[] emailAddr = (JSPUtil.getParameter(request, prefix	+ "email_addr", length));
			String[] emailTitle = (JSPUtil.getParameter(request, prefix	+ "email_title", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] gnteNo = (JSPUtil.getParameter(request, prefix	+ "gnte_no", length));
			String[] functionname = (JSPUtil.getParameter(request, prefix	+ "functionname", length));
			String[] def = (JSPUtil.getParameter(request, prefix	+ "def", length));
			String[] gnteFlg = (JSPUtil.getParameter(request, prefix	+ "gnte_flg", length));
			String[] oid = (JSPUtil.getParameter(request, prefix	+ "oid", length));
			String[] cntrSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_seq", length));
			String[] irrNo = (JSPUtil.getParameter(request, prefix	+ "irr_no", length));
			String[] gnteTpCd = (JSPUtil.getParameter(request, prefix	+ "gnte_tp_cd", length));
			String[] bkgNoTmp = (JSPUtil.getParameter(request, prefix	+ "bkg_no_tmp", length));
			String[] ifrid = (JSPUtil.getParameter(request, prefix	+ "ifrid", length));
			String[] faxTitle = (JSPUtil.getParameter(request, prefix	+ "fax_title", length));
			String[] creFlg = (JSPUtil.getParameter(request, prefix	+ "cre_flg", length));
			String[] idx = (JSPUtil.getParameter(request, prefix	+ "idx", length));
			String[] batchInd = (JSPUtil.getParameter(request, prefix	+ "batch_ind", length));
			String[] tesMode = (JSPUtil.getParameter(request, prefix	+ "tes_mode", length));
			String[] appCd = (JSPUtil.getParameter(request, prefix	+ "app_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] sysCd = (JSPUtil.getParameter(request, prefix	+ "sys_cd", length));
			String[] refNo = (JSPUtil.getParameter(request, prefix	+ "ref_no", length));
			String[] cntrNoTmp = (JSPUtil.getParameter(request, prefix	+ "cntr_no_tmp", length));
			String[] toCreDt = (JSPUtil.getParameter(request, prefix	+ "to_cre_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new GuaranteeCommonVO();
				if (fmCreDt[i] != null)
					model.setFmCreDt(fmCreDt[i]);
				if (gnteCustCd[i] != null)
					model.setGnteCustCd(gnteCustCd[i]);
				if (rcvInfo[i] != null)
					model.setRcvInfo(rcvInfo[i]);
				if (param[i] != null)
					model.setParam(param[i]);
				if (fCmd[i] != null)
					model.setFCmd(fCmd[i]);
				if (faxNum[i] != null)
					model.setFaxNum(faxNum[i]);
				if (emailContents[i] != null)
					model.setEmailContents(emailContents[i]);
				if (emailAddr[i] != null)
					model.setEmailAddr(emailAddr[i]);
				if (emailTitle[i] != null)
					model.setEmailTitle(emailTitle[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (gnteNo[i] != null)
					model.setGnteNo(gnteNo[i]);
				if (functionname[i] != null)
					model.setFunctionname(functionname[i]);
				if (def[i] != null)
					model.setDef(def[i]);
				if (gnteFlg[i] != null)
					model.setGnteFlg(gnteFlg[i]);
				if (oid[i] != null)
					model.setOid(oid[i]);
				if (cntrSeq[i] != null)
					model.setCntrSeq(cntrSeq[i]);
				if (irrNo[i] != null)
					model.setIrrNo(irrNo[i]);
				if (gnteTpCd[i] != null)
					model.setGnteTpCd(gnteTpCd[i]);
				if (bkgNoTmp[i] != null)
					model.setBkgNoTmp(bkgNoTmp[i]);
				if (ifrid[i] != null)
					model.setIfrid(ifrid[i]);
				if (faxTitle[i] != null)
					model.setFaxTitle(faxTitle[i]);
				if (creFlg[i] != null)
					model.setCreFlg(creFlg[i]);
				if (idx[i] != null)
					model.setIdx(idx[i]);
				if (batchInd[i] != null)
					model.setBatchInd(batchInd[i]);
				if (tesMode[i] != null)
					model.setTesMode(tesMode[i]);
				if (appCd[i] != null)
					model.setAppCd(appCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (sysCd[i] != null)
					model.setSysCd(sysCd[i]);
				if (refNo[i] != null)
					model.setRefNo(refNo[i]);
				if (cntrNoTmp[i] != null)
					model.setCntrNoTmp(cntrNoTmp[i]);
				if (toCreDt[i] != null)
					model.setToCreDt(toCreDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGuaranteeCommonVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GuaranteeCommonVO[]
	 */
	public GuaranteeCommonVO[] getGuaranteeCommonVOs(){
		GuaranteeCommonVO[] vos = (GuaranteeCommonVO[])models.toArray(new GuaranteeCommonVO[models.size()]);
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
		this.fmCreDt = this.fmCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteCustCd = this.gnteCustCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvInfo = this.rcvInfo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.param = this.param .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCmd = this.fCmd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxNum = this.faxNum .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailContents = this.emailContents .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailAddr = this.emailAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailTitle = this.emailTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteNo = this.gnteNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionname = this.functionname .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.def = this.def .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteFlg = this.gnteFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oid = this.oid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq = this.cntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irrNo = this.irrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gnteTpCd = this.gnteTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoTmp = this.bkgNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifrid = this.ifrid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxTitle = this.faxTitle .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creFlg = this.creFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idx = this.idx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.batchInd = this.batchInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tesMode = this.tesMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.appCd = this.appCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysCd = this.sysCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo = this.refNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoTmp = this.cntrNoTmp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toCreDt = this.toCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
