/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceSlipListVO.java
 *@FileTitle : InvoiceSlipListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.03
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.02.03  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class InvoiceSlipListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceSlipListVO>  models =	new	ArrayList<InvoiceSlipListVO>();


	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 receiptNo   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 approval   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 rejectedBy   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 invDesc   =  null;
	/*	Column Info	*/
	private  String	 invTpLuCd   =  null;
	/*	Column Info	*/
	private  String	 usrNm   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 submitFlag   =  null;
	/*	Column Info	*/
	private  String	 apInvSrcCd   =  null;
	/*	Column Info	*/
	private  String	 vndrCd   =  null;
	/*	Column Info	*/
	private  String	 payDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceSlipListVO(){}

	public InvoiceSlipListVO(String glDt,String receiptNo,String vndrLglEngNm,String approval,String invSeq,String invCurrCd,String rejectedBy,String pagerows,String invNo,String ofcCd,String ibflag,String invDesc,String invTpLuCd,String usrNm,String invAmt,String invDt,String submitFlag,String apInvSrcCd,String vndrCd,String payDt)	{
		this.glDt  = glDt ;
		this.receiptNo  = receiptNo ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.approval  = approval ;
		this.invSeq  = invSeq ;
		this.invCurrCd  = invCurrCd ;
		this.rejectedBy  = rejectedBy ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.ibflag  = ibflag ;
		this.invDesc  = invDesc ;
		this.invTpLuCd  = invTpLuCd ;
		this.usrNm  = usrNm ;
		this.invAmt  = invAmt ;
		this.invDt  = invDt ;
		this.submitFlag  = submitFlag ;
		this.apInvSrcCd  = apInvSrcCd ;
		this.vndrCd  = vndrCd ;
		this.payDt  = payDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("receipt_no", getReceiptNo());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("approval", getApproval());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("rejected_by", getRejectedBy());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("inv_desc", getInvDesc());		
		this.hashColumns.put("inv_tp_lu_cd", getInvTpLuCd());		
		this.hashColumns.put("usr_nm", getUsrNm());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("submit_flag", getSubmitFlag());		
		this.hashColumns.put("ap_inv_src_cd", getApInvSrcCd());		
		this.hashColumns.put("vndr_cd", getVndrCd());		
		this.hashColumns.put("pay_dt", getPayDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("receipt_no", "receiptNo");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("approval", "approval");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("rejected_by", "rejectedBy");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("inv_tp_lu_cd", "invTpLuCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("submit_flag", "submitFlag");
		this.hashFields.put("ap_inv_src_cd", "apInvSrcCd");
		this.hashFields.put("vndr_cd", "vndrCd");
		this.hashFields.put("pay_dt", "payDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  glDt
	*/
	public void	setGlDt( String	glDt ) {
		this.glDt =	glDt;
	}
 
	/**
	 * Column Info
	 * @return	glDt
	 */
	 public	String	getGlDt() {
		 return	this.glDt;
	 } 
 	/**
	* Column Info
	* @param  receiptNo
	*/
	public void	setReceiptNo( String	receiptNo ) {
		this.receiptNo =	receiptNo;
	}
 
	/**
	 * Column Info
	 * @return	receiptNo
	 */
	 public	String	getReceiptNo() {
		 return	this.receiptNo;
	 } 
 	/**
	* Column Info
	* @param  vndrLglEngNm
	*/
	public void	setVndrLglEngNm( String	vndrLglEngNm ) {
		this.vndrLglEngNm =	vndrLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrLglEngNm
	 */
	 public	String	getVndrLglEngNm() {
		 return	this.vndrLglEngNm;
	 } 
 	/**
	* Column Info
	* @param  approval
	*/
	public void	setApproval( String	approval ) {
		this.approval =	approval;
	}
 
	/**
	 * Column Info
	 * @return	approval
	 */
	 public	String	getApproval() {
		 return	this.approval;
	 } 
 	/**
	* Column Info
	* @param  invSeq
	*/
	public void	setInvSeq( String	invSeq ) {
		this.invSeq =	invSeq;
	}
 
	/**
	 * Column Info
	 * @return	invSeq
	 */
	 public	String	getInvSeq() {
		 return	this.invSeq;
	 } 
 	/**
	* Column Info
	* @param  invCurrCd
	*/
	public void	setInvCurrCd( String	invCurrCd ) {
		this.invCurrCd =	invCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invCurrCd
	 */
	 public	String	getInvCurrCd() {
		 return	this.invCurrCd;
	 } 
 	/**
	* Column Info
	* @param  rejectedBy
	*/
	public void	setRejectedBy( String	rejectedBy ) {
		this.rejectedBy =	rejectedBy;
	}
 
	/**
	 * Column Info
	 * @return	rejectedBy
	 */
	 public	String	getRejectedBy() {
		 return	this.rejectedBy;
	 } 
 	/**
	* Column Info
	* @param  pagerows
	*/
	public void	setPagerows( String	pagerows ) {
		this.pagerows =	pagerows;
	}
 
	/**
	 * Column Info
	 * @return	pagerows
	 */
	 public	String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  invNo
	*/
	public void	setInvNo( String	invNo ) {
		this.invNo =	invNo;
	}
 
	/**
	 * Column Info
	 * @return	invNo
	 */
	 public	String	getInvNo() {
		 return	this.invNo;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  ibflag
	*/
	public void	setIbflag( String	ibflag ) {
		this.ibflag =	ibflag;
	}
 
	/**
	 * Column Info
	 * @return	ibflag
	 */
	 public	String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  invDesc
	*/
	public void	setInvDesc( String	invDesc ) {
		this.invDesc =	invDesc;
	}
 
	/**
	 * Column Info
	 * @return	invDesc
	 */
	 public	String	getInvDesc() {
		 return	this.invDesc;
	 } 
 	/**
	* Column Info
	* @param  invTpLuCd
	*/
	public void	setInvTpLuCd( String	invTpLuCd ) {
		this.invTpLuCd =	invTpLuCd;
	}
 
	/**
	 * Column Info
	 * @return	invTpLuCd
	 */
	 public	String	getInvTpLuCd() {
		 return	this.invTpLuCd;
	 } 
 	/**
	* Column Info
	* @param  usrNm
	*/
	public void	setUsrNm( String	usrNm ) {
		this.usrNm =	usrNm;
	}
 
	/**
	 * Column Info
	 * @return	usrNm
	 */
	 public	String	getUsrNm() {
		 return	this.usrNm;
	 } 
 	/**
	* Column Info
	* @param  invAmt
	*/
	public void	setInvAmt( String	invAmt ) {
		this.invAmt =	invAmt;
	}
 
	/**
	 * Column Info
	 * @return	invAmt
	 */
	 public	String	getInvAmt() {
		 return	this.invAmt;
	 } 
 	/**
	* Column Info
	* @param  invDt
	*/
	public void	setInvDt( String	invDt ) {
		this.invDt =	invDt;
	}
 
	/**
	 * Column Info
	 * @return	invDt
	 */
	 public	String	getInvDt() {
		 return	this.invDt;
	 } 
 	/**
	* Column Info
	* @param  submitFlag
	*/
	public void	setSubmitFlag( String	submitFlag ) {
		this.submitFlag =	submitFlag;
	}
 
	/**
	 * Column Info
	 * @return	submitFlag
	 */
	 public	String	getSubmitFlag() {
		 return	this.submitFlag;
	 } 
 	/**
	* Column Info
	* @param  apInvSrcCd
	*/
	public void	setApInvSrcCd( String	apInvSrcCd ) {
		this.apInvSrcCd =	apInvSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	apInvSrcCd
	 */
	 public	String	getApInvSrcCd() {
		 return	this.apInvSrcCd;
	 } 
 	/**
	* Column Info
	* @param  vndrCd
	*/
	public void	setVndrCd( String	vndrCd ) {
		this.vndrCd =	vndrCd;
	}
 
	/**
	 * Column Info
	 * @return	vndrCd
	 */
	 public	String	getVndrCd() {
		 return	this.vndrCd;
	 } 
 	/**
	* Column Info
	* @param  payDt
	*/
	public void	setPayDt( String	payDt ) {
		this.payDt =	payDt;
	}
 
	/**
	 * Column Info
	 * @return	payDt
	 */
	 public	String	getPayDt() {
		 return	this.payDt;
	 } 

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의	멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setReceiptNo(JSPUtil.getParameter(request,	prefix + "receipt_no", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setApproval(JSPUtil.getParameter(request,	prefix + "approval", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setRejectedBy(JSPUtil.getParameter(request,	prefix + "rejected_by", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setInvDesc(JSPUtil.getParameter(request,	prefix + "inv_desc", ""));
		setInvTpLuCd(JSPUtil.getParameter(request,	prefix + "inv_tp_lu_cd", ""));
		setUsrNm(JSPUtil.getParameter(request,	prefix + "usr_nm", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setSubmitFlag(JSPUtil.getParameter(request,	prefix + "submit_flag", ""));
		setApInvSrcCd(JSPUtil.getParameter(request,	prefix + "ap_inv_src_cd", ""));
		setVndrCd(JSPUtil.getParameter(request,	prefix + "vndr_cd", ""));
		setPayDt(JSPUtil.getParameter(request,	prefix + "pay_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceSlipListVO[]
	 */
	public InvoiceSlipListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceSlipListVO[]
	 */
	public InvoiceSlipListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceSlipListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] receiptNo =	(JSPUtil.getParameter(request, prefix +	"receipt_no".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] approval =	(JSPUtil.getParameter(request, prefix +	"approval".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] rejectedBy =	(JSPUtil.getParameter(request, prefix +	"rejected_by".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] invDesc =	(JSPUtil.getParameter(request, prefix +	"inv_desc".trim(),	length));
				String[] invTpLuCd =	(JSPUtil.getParameter(request, prefix +	"inv_tp_lu_cd".trim(),	length));
				String[] usrNm =	(JSPUtil.getParameter(request, prefix +	"usr_nm".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] submitFlag =	(JSPUtil.getParameter(request, prefix +	"submit_flag".trim(),	length));
				String[] apInvSrcCd =	(JSPUtil.getParameter(request, prefix +	"ap_inv_src_cd".trim(),	length));
				String[] vndrCd =	(JSPUtil.getParameter(request, prefix +	"vndr_cd".trim(),	length));
				String[] payDt =	(JSPUtil.getParameter(request, prefix +	"pay_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceSlipListVO();
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( receiptNo[i] !=	null)
						model.setReceiptNo( receiptNo[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( approval[i] !=	null)
						model.setApproval( approval[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( rejectedBy[i] !=	null)
						model.setRejectedBy( rejectedBy[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( invDesc[i] !=	null)
						model.setInvDesc( invDesc[i]);
						if ( invTpLuCd[i] !=	null)
						model.setInvTpLuCd( invTpLuCd[i]);
						if ( usrNm[i] !=	null)
						model.setUsrNm( usrNm[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( submitFlag[i] !=	null)
						model.setSubmitFlag( submitFlag[i]);
						if ( apInvSrcCd[i] !=	null)
						model.setApInvSrcCd( apInvSrcCd[i]);
						if ( vndrCd[i] !=	null)
						model.setVndrCd( vndrCd[i]);
						if ( payDt[i] !=	null)
						model.setPayDt( payDt[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceSlipListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceSlipListVO[]
	 */
	public InvoiceSlipListVO[]	 getInvoiceSlipListVOs(){
		InvoiceSlipListVO[] vos = (InvoiceSlipListVO[])models.toArray(new	InvoiceSlipListVO[models.size()]);
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
		this.receiptNo =	this.receiptNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approval =	this.approval.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rejectedBy =	this.rejectedBy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc =	this.invDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTpLuCd =	this.invTpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm =	this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.submitFlag =	this.submitFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apInvSrcCd =	this.apInvSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrCd =	this.vndrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDt =	this.payDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}