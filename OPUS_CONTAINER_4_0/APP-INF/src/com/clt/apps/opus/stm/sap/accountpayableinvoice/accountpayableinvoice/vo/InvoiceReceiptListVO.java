/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceReceiptListVO.java
 *@FileTitle : InvoiceReceiptListVO
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
public class InvoiceReceiptListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceReceiptListVO>  models =	new	ArrayList<InvoiceReceiptListVO>();


	/*	Column Info	*/
	private  String	 bankAcctNo   =  null;
	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 bankBrncNm   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 apPayGrpLuCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 invDesc   =  null;
	/*	Column Info	*/
	private  String	 payMzdLuCd   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 bankNm   =  null;
	/*	Column Info	*/
	private  String	 payStsFlg   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 invRctNo   =  null;
	/*	Column Info	*/
	private  String	 dueDt   =  null;
	/*	Column Info	*/
	private  String	 invTermNm   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 apInvSrcCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceReceiptListVO(){}

	public InvoiceReceiptListVO(String bankAcctNo,String glDt,String creDt,String vndrLglEngNm,String invSeq,String invCurrCd,String pagerows,String invNo,String bankBrncNm,String ofcCd,String apPayGrpLuCd,String ibflag,String vndrNo,String invDesc,String payMzdLuCd,String usrId,String bankNm,String payStsFlg,String invAmt,String invRctNo,String dueDt,String invTermNm,String invDt,String apInvSrcCd)	{
		this.bankAcctNo  = bankAcctNo ;
		this.glDt  = glDt ;
		this.creDt  = creDt ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.invSeq  = invSeq ;
		this.invCurrCd  = invCurrCd ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.bankBrncNm  = bankBrncNm ;
		this.ofcCd  = ofcCd ;
		this.apPayGrpLuCd  = apPayGrpLuCd ;
		this.ibflag  = ibflag ;
		this.vndrNo  = vndrNo ;
		this.invDesc  = invDesc ;
		this.payMzdLuCd  = payMzdLuCd ;
		this.usrId  = usrId ;
		this.bankNm  = bankNm ;
		this.payStsFlg  = payStsFlg ;
		this.invAmt  = invAmt ;
		this.invRctNo  = invRctNo ;
		this.dueDt  = dueDt ;
		this.invTermNm  = invTermNm ;
		this.invDt  = invDt ;
		this.apInvSrcCd  = apInvSrcCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_no", getBankAcctNo());		
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("bank_brnc_nm", getBankBrncNm());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ap_pay_grp_lu_cd", getApPayGrpLuCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("inv_desc", getInvDesc());		
		this.hashColumns.put("pay_mzd_lu_cd", getPayMzdLuCd());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("bank_nm", getBankNm());		
		this.hashColumns.put("pay_sts_flg", getPayStsFlg());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("inv_rct_no", getInvRctNo());		
		this.hashColumns.put("due_dt", getDueDt());		
		this.hashColumns.put("inv_term_nm", getInvTermNm());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("ap_inv_src_cd", getApInvSrcCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bank_brnc_nm", "bankBrncNm");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ap_pay_grp_lu_cd", "apPayGrpLuCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("inv_desc", "invDesc");
		this.hashFields.put("pay_mzd_lu_cd", "payMzdLuCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("pay_sts_flg", "payStsFlg");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("inv_rct_no", "invRctNo");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("inv_term_nm", "invTermNm");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("ap_inv_src_cd", "apInvSrcCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  bankAcctNo
	*/
	public void	setBankAcctNo( String	bankAcctNo ) {
		this.bankAcctNo =	bankAcctNo;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctNo
	 */
	 public	String	getBankAcctNo() {
		 return	this.bankAcctNo;
	 } 
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
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	String	getCreDt() {
		 return	this.creDt;
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
	* @param  bankBrncNm
	*/
	public void	setBankBrncNm( String	bankBrncNm ) {
		this.bankBrncNm =	bankBrncNm;
	}
 
	/**
	 * Column Info
	 * @return	bankBrncNm
	 */
	 public	String	getBankBrncNm() {
		 return	this.bankBrncNm;
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
	* @param  apPayGrpLuCd
	*/
	public void	setApPayGrpLuCd( String	apPayGrpLuCd ) {
		this.apPayGrpLuCd =	apPayGrpLuCd;
	}
 
	/**
	 * Column Info
	 * @return	apPayGrpLuCd
	 */
	 public	String	getApPayGrpLuCd() {
		 return	this.apPayGrpLuCd;
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
	* @param  payMzdLuCd
	*/
	public void	setPayMzdLuCd( String	payMzdLuCd ) {
		this.payMzdLuCd =	payMzdLuCd;
	}
 
	/**
	 * Column Info
	 * @return	payMzdLuCd
	 */
	 public	String	getPayMzdLuCd() {
		 return	this.payMzdLuCd;
	 } 
 	/**
	* Column Info
	* @param  usrId
	*/
	public void	setUsrId( String	usrId ) {
		this.usrId =	usrId;
	}
 
	/**
	 * Column Info
	 * @return	usrId
	 */
	 public	String	getUsrId() {
		 return	this.usrId;
	 } 
 	/**
	* Column Info
	* @param  bankNm
	*/
	public void	setBankNm( String	bankNm ) {
		this.bankNm =	bankNm;
	}
 
	/**
	 * Column Info
	 * @return	bankNm
	 */
	 public	String	getBankNm() {
		 return	this.bankNm;
	 } 
 	/**
	* Column Info
	* @param  payStsFlg
	*/
	public void	setPayStsFlg( String	payStsFlg ) {
		this.payStsFlg =	payStsFlg;
	}
 
	/**
	 * Column Info
	 * @return	payStsFlg
	 */
	 public	String	getPayStsFlg() {
		 return	this.payStsFlg;
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
	* @param  invRctNo
	*/
	public void	setInvRctNo( String	invRctNo ) {
		this.invRctNo =	invRctNo;
	}
 
	/**
	 * Column Info
	 * @return	invRctNo
	 */
	 public	String	getInvRctNo() {
		 return	this.invRctNo;
	 } 
 	/**
	* Column Info
	* @param  dueDt
	*/
	public void	setDueDt( String	dueDt ) {
		this.dueDt =	dueDt;
	}
 
	/**
	 * Column Info
	 * @return	dueDt
	 */
	 public	String	getDueDt() {
		 return	this.dueDt;
	 } 
 	/**
	* Column Info
	* @param  invTermNm
	*/
	public void	setInvTermNm( String	invTermNm ) {
		this.invTermNm =	invTermNm;
	}
 
	/**
	 * Column Info
	 * @return	invTermNm
	 */
	 public	String	getInvTermNm() {
		 return	this.invTermNm;
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
		setBankAcctNo(JSPUtil.getParameter(request,	prefix + "bank_acct_no", ""));
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setBankBrncNm(JSPUtil.getParameter(request,	prefix + "bank_brnc_nm", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setApPayGrpLuCd(JSPUtil.getParameter(request,	prefix + "ap_pay_grp_lu_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setInvDesc(JSPUtil.getParameter(request,	prefix + "inv_desc", ""));
		setPayMzdLuCd(JSPUtil.getParameter(request,	prefix + "pay_mzd_lu_cd", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setBankNm(JSPUtil.getParameter(request,	prefix + "bank_nm", ""));
		setPayStsFlg(JSPUtil.getParameter(request,	prefix + "pay_sts_flg", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setInvRctNo(JSPUtil.getParameter(request,	prefix + "inv_rct_no", ""));
		setDueDt(JSPUtil.getParameter(request,	prefix + "due_dt", ""));
		setInvTermNm(JSPUtil.getParameter(request,	prefix + "inv_term_nm", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setApInvSrcCd(JSPUtil.getParameter(request,	prefix + "ap_inv_src_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceReceiptListVO[]
	 */
	public InvoiceReceiptListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceReceiptListVO[]
	 */
	public InvoiceReceiptListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceReceiptListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] bankAcctNo =	(JSPUtil.getParameter(request, prefix +	"bank_acct_no".trim(),	length));
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] bankBrncNm =	(JSPUtil.getParameter(request, prefix +	"bank_brnc_nm".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] apPayGrpLuCd =	(JSPUtil.getParameter(request, prefix +	"ap_pay_grp_lu_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] invDesc =	(JSPUtil.getParameter(request, prefix +	"inv_desc".trim(),	length));
				String[] payMzdLuCd =	(JSPUtil.getParameter(request, prefix +	"pay_mzd_lu_cd".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] bankNm =	(JSPUtil.getParameter(request, prefix +	"bank_nm".trim(),	length));
				String[] payStsFlg =	(JSPUtil.getParameter(request, prefix +	"pay_sts_flg".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] invRctNo =	(JSPUtil.getParameter(request, prefix +	"inv_rct_no".trim(),	length));
				String[] dueDt =	(JSPUtil.getParameter(request, prefix +	"due_dt".trim(),	length));
				String[] invTermNm =	(JSPUtil.getParameter(request, prefix +	"inv_term_nm".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] apInvSrcCd =	(JSPUtil.getParameter(request, prefix +	"ap_inv_src_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceReceiptListVO();
						if ( bankAcctNo[i] !=	null)
						model.setBankAcctNo( bankAcctNo[i]);
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( bankBrncNm[i] !=	null)
						model.setBankBrncNm( bankBrncNm[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( apPayGrpLuCd[i] !=	null)
						model.setApPayGrpLuCd( apPayGrpLuCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( invDesc[i] !=	null)
						model.setInvDesc( invDesc[i]);
						if ( payMzdLuCd[i] !=	null)
						model.setPayMzdLuCd( payMzdLuCd[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( bankNm[i] !=	null)
						model.setBankNm( bankNm[i]);
						if ( payStsFlg[i] !=	null)
						model.setPayStsFlg( payStsFlg[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( invRctNo[i] !=	null)
						model.setInvRctNo( invRctNo[i]);
						if ( dueDt[i] !=	null)
						model.setDueDt( dueDt[i]);
						if ( invTermNm[i] !=	null)
						model.setInvTermNm( invTermNm[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( apInvSrcCd[i] !=	null)
						model.setApInvSrcCd( apInvSrcCd[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceReceiptListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceReceiptListVO[]
	 */
	public InvoiceReceiptListVO[]	 getInvoiceReceiptListVOs(){
		InvoiceReceiptListVO[] vos = (InvoiceReceiptListVO[])models.toArray(new	InvoiceReceiptListVO[models.size()]);
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
		this.bankAcctNo =	this.bankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankBrncNm =	this.bankBrncNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayGrpLuCd =	this.apPayGrpLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDesc =	this.invDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payMzdLuCd =	this.payMzdLuCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm =	this.bankNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payStsFlg =	this.payStsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRctNo =	this.invRctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt =	this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTermNm =	this.invTermNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apInvSrcCd =	this.apInvSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}