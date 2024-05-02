/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : InvoiceAccrualVO.java
*@FileTitle : InvoiceAccrualVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.11.10
*@LastModifier : 
*@LastVersion : 1.0
* 2014.11.10  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

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

public class InvoiceAccrualVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvoiceAccrualVO> models = new ArrayList<InvoiceAccrualVO>();
	
	/* Column Info */
	private String glDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String invSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String vndrNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String dtrbDesc = null;
	/* Column Info */
	private String locationCd = null;
	/* Column Info */
	private String invAmt = null;
	/* Column Info */
	private String interfaceFlag = null;
	/* Column Info */
	private String lineTpLuCd = null;
	/* Column Info */
	private String invXchRt = null;
	/* Column Info */
	private String dtrbCoa = null;
	/* Column Info */
	private String invDt = null;
	/* Column Info */
	private String serviceLane = null;
	/* Column Info */
	private String activityPlace = null;
	/* Column Info */
	private String lineNo = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String invTpLuCd = null;
	/* Column Info */
	private String dtrbAmt = null;
	/* Column Info */
	private String activityDate = null;
	/* Column Info */
	private String vndrInvDate = null;
	/* Column Info */
	private String accrualAcctCd = null;
	/* Column Info */
	private String vndrInvNo = null;
	/* Column Info */
	private String dtrbFuncAmt = null;
	/*	Column Info	*/
	private  String	 accrualIfFlag   =  null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvoiceAccrualVO() {}

	public InvoiceAccrualVO(String glDt,String currCd,String invSeq,String pagerows,String vndrNm,String vndrNo,String ibflag,String dtrbDesc,String locationCd,String invAmt,String interfaceFlag,String lineTpLuCd,String invXchRt,String dtrbCoa,String invDt,String serviceLane,String activityPlace,String lineNo,String invNo,String ofcCd,String invTpLuCd,String dtrbAmt,String activityDate,String vndrInvDate,String accrualAcctCd,String vndrInvNo,String dtrbFuncAmt,String accrualIfFlag)	{
		this.glDt  = glDt ;
		this.currCd  = currCd ;
		this.invSeq  = invSeq ;
		this.pagerows  = pagerows ;
		this.vndrNm  = vndrNm ;
		this.vndrNo  = vndrNo ;
		this.ibflag  = ibflag ;
		this.dtrbDesc  = dtrbDesc ;
		this.locationCd  = locationCd ;
		this.invAmt  = invAmt ;
		this.interfaceFlag  = interfaceFlag ;
		this.lineTpLuCd  = lineTpLuCd ;
		this.invXchRt  = invXchRt ;
		this.dtrbCoa  = dtrbCoa ;
		this.invDt  = invDt ;
		this.serviceLane  = serviceLane ;
		this.activityPlace  = activityPlace ;
		this.lineNo  = lineNo ;
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.invTpLuCd  = invTpLuCd ;
		this.dtrbAmt  = dtrbAmt ;
		this.activityDate  = activityDate ;
		this.vndrInvDate  = vndrInvDate ;
		this.accrualAcctCd  = accrualAcctCd ;
		this.vndrInvNo  = vndrInvNo ;
		this.dtrbFuncAmt  = dtrbFuncAmt ;
		this.accrualIfFlag  = accrualIfFlag ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vndr_nm", getVndrNm());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("dtrb_desc", getDtrbDesc());		
		this.hashColumns.put("location_cd", getLocationCd());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("interface_flag", getInterfaceFlag());		
		this.hashColumns.put("line_tp_lu_cd", getLineTpLuCd());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("dtrb_coa", getDtrbCoa());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("service_lane", getServiceLane());		
		this.hashColumns.put("activity_place", getActivityPlace());		
		this.hashColumns.put("line_no", getLineNo());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("inv_tp_lu_cd", getInvTpLuCd());		
		this.hashColumns.put("dtrb_amt", getDtrbAmt());		
		this.hashColumns.put("activity_date", getActivityDate());		
		this.hashColumns.put("vndr_inv_date", getVndrInvDate());		
		this.hashColumns.put("accrual_acct_cd", getAccrualAcctCd());		
		this.hashColumns.put("vndr_inv_no", getVndrInvNo());		
		this.hashColumns.put("dtrb_func_amt", getDtrbFuncAmt());		
		this.hashColumns.put("accrual_if_flag", getAccrualIfFlag());		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dtrb_desc", "dtrbDesc");
		this.hashFields.put("location_cd", "locationCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("interface_flag", "interfaceFlag");
		this.hashFields.put("line_tp_lu_cd", "lineTpLuCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("dtrb_coa", "dtrbCoa");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("service_lane", "serviceLane");
		this.hashFields.put("activity_place", "activityPlace");
		this.hashFields.put("line_no", "lineNo");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("inv_tp_lu_cd", "invTpLuCd");
		this.hashFields.put("dtrb_amt", "dtrbAmt");
		this.hashFields.put("activity_date", "activityDate");
		this.hashFields.put("vndr_inv_date", "vndrInvDate");
		this.hashFields.put("accrual_acct_cd", "accrualAcctCd");
		this.hashFields.put("vndr_inv_no", "vndrInvNo");
		this.hashFields.put("dtrb_func_amt", "dtrbFuncAmt");
		this.hashFields.put("accrual_if_flag", "accrualIfFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return glDt
	 */
	public String getGlDt() {
		return this.glDt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
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
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return vndrNo
	 */
	public String getVndrNo() {
		return this.vndrNo;
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
	 * @return dtrbDesc
	 */
	public String getDtrbDesc() {
		return this.dtrbDesc;
	}
	
	/**
	 * Column Info
	 * @return locationCd
	 */
	public String getLocationCd() {
		return this.locationCd;
	}
	
	/**
	 * Column Info
	 * @return invAmt
	 */
	public String getInvAmt() {
		return this.invAmt;
	}
	
	/**
	 * Column Info
	 * @return interfaceFlag
	 */
	public String getInterfaceFlag() {
		return this.interfaceFlag;
	}
	
	/**
	 * Column Info
	 * @return lineTpLuCd
	 */
	public String getLineTpLuCd() {
		return this.lineTpLuCd;
	}
	
	/**
	 * Column Info
	 * @return invXchRt
	 */
	public String getInvXchRt() {
		return this.invXchRt;
	}
	
	/**
	 * Column Info
	 * @return dtrbCoa
	 */
	public String getDtrbCoa() {
		return this.dtrbCoa;
	}
	
	/**
	 * Column Info
	 * @return invDt
	 */
	public String getInvDt() {
		return this.invDt;
	}
	
	/**
	 * Column Info
	 * @return serviceLane
	 */
	public String getServiceLane() {
		return this.serviceLane;
	}
	
	/**
	 * Column Info
	 * @return activityPlace
	 */
	public String getActivityPlace() {
		return this.activityPlace;
	}
	
	/**
	 * Column Info
	 * @return lineNo
	 */
	public String getLineNo() {
		return this.lineNo;
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
	 * @return invTpLuCd
	 */
	public String getInvTpLuCd() {
		return this.invTpLuCd;
	}
	
	/**
	 * Column Info
	 * @return dtrbAmt
	 */
	public String getDtrbAmt() {
		return this.dtrbAmt;
	}
	
	/**
	 * Column Info
	 * @return activityDate
	 */
	public String getActivityDate() {
		return this.activityDate;
	}
	
	/**
	 * Column Info
	 * @return vndrInvDate
	 */
	public String getVndrInvDate() {
		return this.vndrInvDate;
	}
	
	/**
	 * Column Info
	 * @return accrualAcctCd
	 */
	public String getAccrualAcctCd() {
		return this.accrualAcctCd;
	}
	
	/**
	 * Column Info
	 * @return vndrInvNo
	 */
	public String getVndrInvNo() {
		return this.vndrInvNo;
	}
	
	/**
	 * Column Info
	 * @return dtrbFuncAmt
	 */
	public String getDtrbFuncAmt() {
		return this.dtrbFuncAmt;
	}
	

	/**
	 * Column Info
	 * @param glDt
	 */
	public void setGlDt(String glDt) {
		this.glDt = glDt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
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
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param vndrNo
	 */
	public void setVndrNo(String vndrNo) {
		this.vndrNo = vndrNo;
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
	 * @param dtrbDesc
	 */
	public void setDtrbDesc(String dtrbDesc) {
		this.dtrbDesc = dtrbDesc;
	}
	
	/**
	 * Column Info
	 * @param locationCd
	 */
	public void setLocationCd(String locationCd) {
		this.locationCd = locationCd;
	}
	
	/**
	 * Column Info
	 * @param invAmt
	 */
	public void setInvAmt(String invAmt) {
		this.invAmt = invAmt;
	}
	
	/**
	 * Column Info
	 * @param interfaceFlag
	 */
	public void setInterfaceFlag(String interfaceFlag) {
		this.interfaceFlag = interfaceFlag;
	}
	
	/**
	 * Column Info
	 * @param lineTpLuCd
	 */
	public void setLineTpLuCd(String lineTpLuCd) {
		this.lineTpLuCd = lineTpLuCd;
	}
	
	/**
	 * Column Info
	 * @param invXchRt
	 */
	public void setInvXchRt(String invXchRt) {
		this.invXchRt = invXchRt;
	}
	
	/**
	 * Column Info
	 * @param dtrbCoa
	 */
	public void setDtrbCoa(String dtrbCoa) {
		this.dtrbCoa = dtrbCoa;
	}
	
	/**
	 * Column Info
	 * @param invDt
	 */
	public void setInvDt(String invDt) {
		this.invDt = invDt;
	}
	
	/**
	 * Column Info
	 * @param serviceLane
	 */
	public void setServiceLane(String serviceLane) {
		this.serviceLane = serviceLane;
	}
	
	/**
	 * Column Info
	 * @param activityPlace
	 */
	public void setActivityPlace(String activityPlace) {
		this.activityPlace = activityPlace;
	}
	
	/**
	 * Column Info
	 * @param lineNo
	 */
	public void setLineNo(String lineNo) {
		this.lineNo = lineNo;
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
	 * @param invTpLuCd
	 */
	public void setInvTpLuCd(String invTpLuCd) {
		this.invTpLuCd = invTpLuCd;
	}
	
	/**
	 * Column Info
	 * @param dtrbAmt
	 */
	public void setDtrbAmt(String dtrbAmt) {
		this.dtrbAmt = dtrbAmt;
	}
	
	/**
	 * Column Info
	 * @param activityDate
	 */
	public void setActivityDate(String activityDate) {
		this.activityDate = activityDate;
	}
	
	/**
	 * Column Info
	 * @param vndrInvDate
	 */
	public void setVndrInvDate(String vndrInvDate) {
		this.vndrInvDate = vndrInvDate;
	}
	
	/**
	 * Column Info
	 * @param accrualAcctCd
	 */
	public void setAccrualAcctCd(String accrualAcctCd) {
		this.accrualAcctCd = accrualAcctCd;
	}
	
	/**
	 * Column Info
	 * @param vndrInvNo
	 */
	public void setVndrInvNo(String vndrInvNo) {
		this.vndrInvNo = vndrInvNo;
	}
	
	/**
	 * Column Info
	 * @param dtrbFuncAmt
	 */
	public void setDtrbFuncAmt(String dtrbFuncAmt) {
		this.dtrbFuncAmt = dtrbFuncAmt;
	}
	
	/**
	* Column Info
	* @param  accrualIfFlag
	*/
	public void	setAccrualIfFlag( String	accrualIfFlag ) {
		this.accrualIfFlag =	accrualIfFlag;
	}
 
	/**
	 * Column Info
	 * @return	accrualIfFlag
	 */
	 public	String	getAccrualIfFlag() {
		 return	this.accrualIfFlag;
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
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVndrNm(JSPUtil.getParameter(request,	prefix + "vndr_nm", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setDtrbDesc(JSPUtil.getParameter(request,	prefix + "dtrb_desc", ""));
		setLocationCd(JSPUtil.getParameter(request,	prefix + "location_cd", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setInterfaceFlag(JSPUtil.getParameter(request,	prefix + "interface_flag", ""));
		setLineTpLuCd(JSPUtil.getParameter(request,	prefix + "line_tp_lu_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setDtrbCoa(JSPUtil.getParameter(request,	prefix + "dtrb_coa", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setServiceLane(JSPUtil.getParameter(request,	prefix + "service_lane", ""));
		setActivityPlace(JSPUtil.getParameter(request,	prefix + "activity_place", ""));
		setLineNo(JSPUtil.getParameter(request,	prefix + "line_no", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setInvTpLuCd(JSPUtil.getParameter(request,	prefix + "inv_tp_lu_cd", ""));
		setDtrbAmt(JSPUtil.getParameter(request,	prefix + "dtrb_amt", ""));
		setActivityDate(JSPUtil.getParameter(request,	prefix + "activity_date", ""));
		setVndrInvDate(JSPUtil.getParameter(request,	prefix + "vndr_inv_date", ""));
		setAccrualAcctCd(JSPUtil.getParameter(request,	prefix + "accrual_acct_cd", ""));
		setVndrInvNo(JSPUtil.getParameter(request,	prefix + "vndr_inv_no", ""));
		setDtrbFuncAmt(JSPUtil.getParameter(request,	prefix + "dtrb_func_amt", ""));
		setAccrualIfFlag(JSPUtil.getParameter(request,	prefix + "accrual_if_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceAccrualVO[]
	 */
	public InvoiceAccrualVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvoiceAccrualVO[]
	 */
	public InvoiceAccrualVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceAccrualVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vndrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_nm".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] dtrbDesc =	(JSPUtil.getParameter(request, prefix +	"dtrb_desc".trim(),	length));
				String[] locationCd =	(JSPUtil.getParameter(request, prefix +	"location_cd".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] interfaceFlag =	(JSPUtil.getParameter(request, prefix +	"interface_flag".trim(),	length));
				String[] lineTpLuCd =	(JSPUtil.getParameter(request, prefix +	"line_tp_lu_cd".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] dtrbCoa =	(JSPUtil.getParameter(request, prefix +	"dtrb_coa".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] serviceLane =	(JSPUtil.getParameter(request, prefix +	"service_lane".trim(),	length));
				String[] activityPlace =	(JSPUtil.getParameter(request, prefix +	"activity_place".trim(),	length));
				String[] lineNo =	(JSPUtil.getParameter(request, prefix +	"line_no".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] invTpLuCd =	(JSPUtil.getParameter(request, prefix +	"inv_tp_lu_cd".trim(),	length));
				String[] dtrbAmt =	(JSPUtil.getParameter(request, prefix +	"dtrb_amt".trim(),	length));
				String[] activityDate =	(JSPUtil.getParameter(request, prefix +	"activity_date".trim(),	length));
				String[] vndrInvDate =	(JSPUtil.getParameter(request, prefix +	"vndr_inv_date".trim(),	length));
				String[] accrualAcctCd =	(JSPUtil.getParameter(request, prefix +	"accrual_acct_cd".trim(),	length));
				String[] vndrInvNo =	(JSPUtil.getParameter(request, prefix +	"vndr_inv_no".trim(),	length));
				String[] dtrbFuncAmt =	(JSPUtil.getParameter(request, prefix +	"dtrb_func_amt".trim(),	length));
				String[] accrualIfFlag =	(JSPUtil.getParameter(request, prefix +	"accrual_if_flag".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceAccrualVO();
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vndrNm[i] !=	null)
						model.setVndrNm( vndrNm[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( dtrbDesc[i] !=	null)
						model.setDtrbDesc( dtrbDesc[i]);
						if ( locationCd[i] !=	null)
						model.setLocationCd( locationCd[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( interfaceFlag[i] !=	null)
						model.setInterfaceFlag( interfaceFlag[i]);
						if ( lineTpLuCd[i] !=	null)
						model.setLineTpLuCd( lineTpLuCd[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( dtrbCoa[i] !=	null)
						model.setDtrbCoa( dtrbCoa[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( serviceLane[i] !=	null)
						model.setServiceLane( serviceLane[i]);
						if ( activityPlace[i] !=	null)
						model.setActivityPlace( activityPlace[i]);
						if ( lineNo[i] !=	null)
						model.setLineNo( lineNo[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( invTpLuCd[i] !=	null)
						model.setInvTpLuCd( invTpLuCd[i]);
						if ( dtrbAmt[i] !=	null)
						model.setDtrbAmt( dtrbAmt[i]);
						if ( activityDate[i] !=	null)
						model.setActivityDate( activityDate[i]);
						if ( vndrInvDate[i] !=	null)
						model.setVndrInvDate( vndrInvDate[i]);
						if ( accrualAcctCd[i] !=	null)
						model.setAccrualAcctCd( accrualAcctCd[i]);
						if ( vndrInvNo[i] !=	null)
						model.setVndrInvNo( vndrInvNo[i]);
						if ( dtrbFuncAmt[i] !=	null)
						model.setDtrbFuncAmt( dtrbFuncAmt[i]);
						if ( accrualIfFlag[i] !=	null)
						model.setAccrualIfFlag( accrualIfFlag[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceAccrualVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvoiceAccrualVO[]
	 */
	public InvoiceAccrualVO[] getInvoiceAccrualVOs(){
		InvoiceAccrualVO[] vos = (InvoiceAccrualVO[])models.toArray(new InvoiceAccrualVO[models.size()]);
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
	public void	unDataFormat(){
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm =	this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbDesc =	this.dtrbDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locationCd =	this.locationCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interfaceFlag =	this.interfaceFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineTpLuCd =	this.lineTpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCoa =	this.dtrbCoa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.serviceLane =	this.serviceLane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.activityPlace =	this.activityPlace.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lineNo =	this.lineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpLuCd =	this.invTpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbAmt =	this.dtrbAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.activityDate =	this.activityDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrInvDate =	this.vndrInvDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accrualAcctCd =	this.accrualAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrInvNo =	this.vndrInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbFuncAmt =	this.dtrbFuncAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accrualIfFlag =	this.accrualIfFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
