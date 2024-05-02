/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceApprovalListVO.java
 *@FileTitle : InvoiceApprovalListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.26
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.03.26  
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
public class InvoiceApprovalListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceApprovalListVO>  models =	new	ArrayList<InvoiceApprovalListVO>();


	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 cteDt   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 approvalFlag   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 processingFlag   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 invDesc   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 usrNm   =  null;
	/*	Column Info	*/
	private  String	 invCurrPrcs   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 attrCateNm   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 apInvSrcCd   =  null;
	/*	Column Info	*/
	private  String	 dueDate   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceApprovalListVO(){}

	public InvoiceApprovalListVO(String glDt,String cteDt,String vndrLglEngNm,String invSeq,String approvalFlag,String invCurrCd,String pagerows,String invNo,String ofcCd,String processingFlag,String creUsrId,String invDesc,String ibflag,String vndrNo,String usrNm,String invCurrPrcs,String invAmt,String attrCateNm,String updUsrId,String invDt,String apInvSrcCd,String dueDate)	{
		this.glDt  = glDt ;
		this.cteDt  = cteDt ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.invSeq  = invSeq ;
		this.approvalFlag  = approvalFlag ;
		this.invCurrCd  = invCurrCd ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.processingFlag  = processingFlag ;
		this.creUsrId  = creUsrId ;
		this.invDesc  = invDesc ;
		this.ibflag  = ibflag ;
		this.vndrNo  = vndrNo ;
		this.usrNm  = usrNm ;
		this.invCurrPrcs  = invCurrPrcs ;
		this.invAmt  = invAmt ;
		this.attrCateNm  = attrCateNm ;
		this.updUsrId  = updUsrId ;
		this.invDt  = invDt ;
		this.apInvSrcCd  = apInvSrcCd ;
		this.dueDate  = dueDate ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("cte_dt", getCteDt());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("approval_flag", getApprovalFlag());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("processing_flag", getProcessingFlag());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("inv_desc", getInvDesc());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("usr_nm", getUsrNm());		
		this.hashColumns.put("inv_curr_prcs", getInvCurrPrcs());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("attr_cate_nm", getAttrCateNm());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("ap_inv_src_cd", getApInvSrcCd());		
		this.hashColumns.put("due_date", getDueDate());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("cte_dt", "cteDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("approval_flag", "approvalFlag");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("processing_flag", "processingFlag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("inv_curr_prcs", "invCurrPrcs");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("attr_cate_nm", "attrCateNm");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("ap_inv_src_cd", "apInvSrcCd");
		this.hashFields.put("due_date", "dueDate");
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
	* @param  cteDt
	*/
	public void	setCteDt( String	cteDt ) {
		this.cteDt =	cteDt;
	}
 
	/**
	 * Column Info
	 * @return	cteDt
	 */
	 public	String	getCteDt() {
		 return	this.cteDt;
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
	* @param  approvalFlag
	*/
	public void	setApprovalFlag( String	approvalFlag ) {
		this.approvalFlag =	approvalFlag;
	}
 
	/**
	 * Column Info
	 * @return	approvalFlag
	 */
	 public	String	getApprovalFlag() {
		 return	this.approvalFlag;
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
	* @param  processingFlag
	*/
	public void	setProcessingFlag( String	processingFlag ) {
		this.processingFlag =	processingFlag;
	}
 
	/**
	 * Column Info
	 * @return	processingFlag
	 */
	 public	String	getProcessingFlag() {
		 return	this.processingFlag;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	String	getCreUsrId() {
		 return	this.creUsrId;
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
	* @param  vndrNo
	*/
	public void	setVndrNo( String	vndrNo ) {
		this.vndrNo =	vndrNo;
	}
 
	/**
	 * Column Info
	 * @return	vndrNo
	 */
	 public	String	getVndrNo() {
		 return	this.vndrNo;
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
	* @param  invCurrPrcs
	*/
	public void	setInvCurrPrcs( String	invCurrPrcs ) {
		this.invCurrPrcs =	invCurrPrcs;
	}
 
	/**
	 * Column Info
	 * @return	invCurrPrcs
	 */
	 public	String	getInvCurrPrcs() {
		 return	this.invCurrPrcs;
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
	* @param  attrCateNm
	*/
	public void	setAttrCateNm( String	attrCateNm ) {
		this.attrCateNm =	attrCateNm;
	}
 
	/**
	 * Column Info
	 * @return	attrCateNm
	 */
	 public	String	getAttrCateNm() {
		 return	this.attrCateNm;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	String	getUpdUsrId() {
		 return	this.updUsrId;
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
	* @param  dueDate
	*/
	public void	setDueDate( String	dueDate ) {
		this.dueDate =	dueDate;
	}
 
	/**
	 * Column Info
	 * @return	dueDate
	 */
	 public	String	getDueDate() {
		 return	this.dueDate;
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
		setCteDt(JSPUtil.getParameter(request,	prefix + "cte_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setApprovalFlag(JSPUtil.getParameter(request,	prefix + "approval_flag", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setProcessingFlag(JSPUtil.getParameter(request,	prefix + "processing_flag", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setInvDesc(JSPUtil.getParameter(request,	prefix + "inv_desc", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setUsrNm(JSPUtil.getParameter(request,	prefix + "usr_nm", ""));
		setInvCurrPrcs(JSPUtil.getParameter(request,	prefix + "inv_curr_prcs", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setAttrCateNm(JSPUtil.getParameter(request,	prefix + "attr_cate_nm", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setApInvSrcCd(JSPUtil.getParameter(request,	prefix + "ap_inv_src_cd", ""));
		setDueDate(JSPUtil.getParameter(request,	prefix + "due_date", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceApprovalListVO[]
	 */
	public InvoiceApprovalListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceApprovalListVO[]
	 */
	public InvoiceApprovalListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceApprovalListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] cteDt =	(JSPUtil.getParameter(request, prefix +	"cte_dt".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] approvalFlag =	(JSPUtil.getParameter(request, prefix +	"approval_flag".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] processingFlag =	(JSPUtil.getParameter(request, prefix +	"processing_flag".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] invDesc =	(JSPUtil.getParameter(request, prefix +	"inv_desc".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] usrNm =	(JSPUtil.getParameter(request, prefix +	"usr_nm".trim(),	length));
				String[] invCurrPrcs =	(JSPUtil.getParameter(request, prefix +	"inv_curr_prcs".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] attrCateNm =	(JSPUtil.getParameter(request, prefix +	"attr_cate_nm".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] apInvSrcCd =	(JSPUtil.getParameter(request, prefix +	"ap_inv_src_cd".trim(),	length));
				String[] dueDate =	(JSPUtil.getParameter(request, prefix +	"due_date".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceApprovalListVO();
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( cteDt[i] !=	null)
						model.setCteDt( cteDt[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( approvalFlag[i] !=	null)
						model.setApprovalFlag( approvalFlag[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( processingFlag[i] !=	null)
						model.setProcessingFlag( processingFlag[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( invDesc[i] !=	null)
						model.setInvDesc( invDesc[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( usrNm[i] !=	null)
						model.setUsrNm( usrNm[i]);
						if ( invCurrPrcs[i] !=	null)
						model.setInvCurrPrcs( invCurrPrcs[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( attrCateNm[i] !=	null)
						model.setAttrCateNm( attrCateNm[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( apInvSrcCd[i] !=	null)
						model.setApInvSrcCd( apInvSrcCd[i]);
						if ( dueDate[i] !=	null)
						model.setDueDate( dueDate[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceApprovalListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceApprovalListVO[]
	 */
	public InvoiceApprovalListVO[]	 getInvoiceApprovalListVOs(){
		InvoiceApprovalListVO[] vos = (InvoiceApprovalListVO[])models.toArray(new	InvoiceApprovalListVO[models.size()]);
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
		this.cteDt =	this.cteDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalFlag =	this.approvalFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.processingFlag =	this.processingFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc =	this.invDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm =	this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrPrcs =	this.invCurrPrcs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCateNm =	this.attrCateNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apInvSrcCd =	this.apInvSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDate =	this.dueDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}