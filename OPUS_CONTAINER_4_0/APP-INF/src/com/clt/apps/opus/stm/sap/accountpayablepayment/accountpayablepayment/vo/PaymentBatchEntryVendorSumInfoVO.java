/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PaymentBatchEntryVendorSumInfoVO.java
 *@FileTitle : PaymentBatchEntryVendorSumInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.06.10
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.06.10  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo;

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
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class PaymentBatchEntryVendorSumInfoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PaymentBatchEntryVendorSumInfoVO>  models =	new	ArrayList<PaymentBatchEntryVendorSumInfoVO>();


	/*	Column Info	*/
	private  String	 bankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 payAmt   =  null;
	/*	Column Info	*/
	private  String	 payBatSeq   =  null;
	/*	Column Info	*/
	private  String	 docLastNo   =  null;
	/*	Column Info	*/
	private  String	 docFirstNo   =  null;
	/*	Column Info	*/
	private  String	 payBatNm   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 loopIndex   =  null;
	/*	Column Info	*/
	private  String	 paySeq   =  null;
	/*	Column Info	*/
	private  String	 functionalCurrency   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public PaymentBatchEntryVendorSumInfoVO(){}

	public PaymentBatchEntryVendorSumInfoVO(String bankAcctSeq,String vndrNo,String ibflag,String payAmt,String payBatSeq,String docLastNo,String docFirstNo,String payBatNm,String pagerows,String usrId,String loopIndex,String paySeq,String functionalCurrency)	{
		this.bankAcctSeq  = bankAcctSeq ;
		this.vndrNo  = vndrNo ;
		this.ibflag  = ibflag ;
		this.payAmt  = payAmt ;
		this.payBatSeq  = payBatSeq ;
		this.docLastNo  = docLastNo ;
		this.docFirstNo  = docFirstNo ;
		this.payBatNm  = payBatNm ;
		this.pagerows  = pagerows ;
		this.usrId  = usrId ;
		this.loopIndex  = loopIndex ;
		this.paySeq  = paySeq ;
		this.functionalCurrency  = functionalCurrency ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pay_amt", getPayAmt());		
		this.hashColumns.put("pay_bat_seq", getPayBatSeq());		
		this.hashColumns.put("doc_last_no", getDocLastNo());		
		this.hashColumns.put("doc_first_no", getDocFirstNo());		
		this.hashColumns.put("pay_bat_nm", getPayBatNm());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("loop_index", getLoopIndex());		
		this.hashColumns.put("pay_seq", getPaySeq());		
		this.hashColumns.put("functional_currency", getFunctionalCurrency());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pay_amt", "payAmt");
		this.hashFields.put("pay_bat_seq", "payBatSeq");
		this.hashFields.put("doc_last_no", "docLastNo");
		this.hashFields.put("doc_first_no", "docFirstNo");
		this.hashFields.put("pay_bat_nm", "payBatNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("loop_index", "loopIndex");
		this.hashFields.put("pay_seq", "paySeq");
		this.hashFields.put("functional_currency", "functionalCurrency");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  bankAcctSeq
	*/
	public void	setBankAcctSeq( String	bankAcctSeq ) {
		this.bankAcctSeq =	bankAcctSeq;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctSeq
	 */
	 public	 String	getBankAcctSeq() {
		 return	this.bankAcctSeq;
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
	 public	 String	getVndrNo() {
		 return	this.vndrNo;
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
	 public	 String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  payAmt
	*/
	public void	setPayAmt( String	payAmt ) {
		this.payAmt =	payAmt;
	}
 
	/**
	 * Column Info
	 * @return	payAmt
	 */
	 public	 String	getPayAmt() {
		 return	this.payAmt;
	 } 
 	/**
	* Column Info
	* @param  payBatSeq
	*/
	public void	setPayBatSeq( String	payBatSeq ) {
		this.payBatSeq =	payBatSeq;
	}
 
	/**
	 * Column Info
	 * @return	payBatSeq
	 */
	 public	 String	getPayBatSeq() {
		 return	this.payBatSeq;
	 } 
 	/**
	* Column Info
	* @param  docLastNo
	*/
	public void	setDocLastNo( String	docLastNo ) {
		this.docLastNo =	docLastNo;
	}
 
	/**
	 * Column Info
	 * @return	docLastNo
	 */
	 public	 String	getDocLastNo() {
		 return	this.docLastNo;
	 } 
 	/**
	* Column Info
	* @param  docFirstNo
	*/
	public void	setDocFirstNo( String	docFirstNo ) {
		this.docFirstNo =	docFirstNo;
	}
 
	/**
	 * Column Info
	 * @return	docFirstNo
	 */
	 public	 String	getDocFirstNo() {
		 return	this.docFirstNo;
	 } 
 	/**
	* Column Info
	* @param  payBatNm
	*/
	public void	setPayBatNm( String	payBatNm ) {
		this.payBatNm =	payBatNm;
	}
 
	/**
	 * Column Info
	 * @return	payBatNm
	 */
	 public	 String	getPayBatNm() {
		 return	this.payBatNm;
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
	 public	 String	getPagerows() {
		 return	this.pagerows;
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
	 public	 String	getUsrId() {
		 return	this.usrId;
	 } 
 	/**
	* Column Info
	* @param  loopIndex
	*/
	public void	setLoopIndex( String	loopIndex ) {
		this.loopIndex =	loopIndex;
	}
 
	/**
	 * Column Info
	 * @return	loopIndex
	 */
	 public	 String	getLoopIndex() {
		 return	this.loopIndex;
	 } 
 	/**
	* Column Info
	* @param  paySeq
	*/
	public void	setPaySeq( String	paySeq ) {
		this.paySeq =	paySeq;
	}
 
	/**
	 * Column Info
	 * @return	paySeq
	 */
	 public	 String	getPaySeq() {
		 return	this.paySeq;
	 } 
 	/**
	* Column Info
	* @param  functionalCurrency
	*/
	public void	setFunctionalCurrency( String	functionalCurrency ) {
		this.functionalCurrency =	functionalCurrency;
	}
 
	/**
	 * Column Info
	 * @return	functionalCurrency
	 */
	 public	 String	getFunctionalCurrency() {
		 return	this.functionalCurrency;
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
		setBankAcctSeq(JSPUtil.getParameter(request,	prefix + "bank_acct_seq", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPayAmt(JSPUtil.getParameter(request,	prefix + "pay_amt", ""));
		setPayBatSeq(JSPUtil.getParameter(request,	prefix + "pay_bat_seq", ""));
		setDocLastNo(JSPUtil.getParameter(request,	prefix + "doc_last_no", ""));
		setDocFirstNo(JSPUtil.getParameter(request,	prefix + "doc_first_no", ""));
		setPayBatNm(JSPUtil.getParameter(request,	prefix + "pay_bat_nm", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setLoopIndex(JSPUtil.getParameter(request,	prefix + "loop_index", ""));
		setPaySeq(JSPUtil.getParameter(request,	prefix + "pay_seq", ""));
		setFunctionalCurrency(JSPUtil.getParameter(request,	prefix + "functional_currency", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PaymentBatchEntryVendorSumInfoVO[]
	 */
	public PaymentBatchEntryVendorSumInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PaymentBatchEntryVendorSumInfoVO[]
	 */
	public PaymentBatchEntryVendorSumInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PaymentBatchEntryVendorSumInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] bankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"bank_acct_seq".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] payAmt =	(JSPUtil.getParameter(request, prefix +	"pay_amt".trim(),	length));
				String[] payBatSeq =	(JSPUtil.getParameter(request, prefix +	"pay_bat_seq".trim(),	length));
				String[] docLastNo =	(JSPUtil.getParameter(request, prefix +	"doc_last_no".trim(),	length));
				String[] docFirstNo =	(JSPUtil.getParameter(request, prefix +	"doc_first_no".trim(),	length));
				String[] payBatNm =	(JSPUtil.getParameter(request, prefix +	"pay_bat_nm".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] loopIndex =	(JSPUtil.getParameter(request, prefix +	"loop_index".trim(),	length));
				String[] paySeq =	(JSPUtil.getParameter(request, prefix +	"pay_seq".trim(),	length));
				String[] functionalCurrency =	(JSPUtil.getParameter(request, prefix +	"functional_currency".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	PaymentBatchEntryVendorSumInfoVO();
						if ( bankAcctSeq[i] !=	null)
						model.setBankAcctSeq( bankAcctSeq[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( payAmt[i] !=	null)
						model.setPayAmt( payAmt[i]);
						if ( payBatSeq[i] !=	null)
						model.setPayBatSeq( payBatSeq[i]);
						if ( docLastNo[i] !=	null)
						model.setDocLastNo( docLastNo[i]);
						if ( docFirstNo[i] !=	null)
						model.setDocFirstNo( docFirstNo[i]);
						if ( payBatNm[i] !=	null)
						model.setPayBatNm( payBatNm[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( loopIndex[i] !=	null)
						model.setLoopIndex( loopIndex[i]);
						if ( paySeq[i] !=	null)
						model.setPaySeq( paySeq[i]);
						if ( functionalCurrency[i] !=	null)
						model.setFunctionalCurrency( functionalCurrency[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getPaymentBatchEntryVendorSumInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PaymentBatchEntryVendorSumInfoVO[]
	 */
	public PaymentBatchEntryVendorSumInfoVO[]	 getPaymentBatchEntryVendorSumInfoVOs(){
		PaymentBatchEntryVendorSumInfoVO[] vos = (PaymentBatchEntryVendorSumInfoVO[])models.toArray(new	PaymentBatchEntryVendorSumInfoVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.bankAcctSeq =	this.bankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payAmt =	this.payAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatSeq =	this.payBatSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docLastNo =	this.docLastNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docFirstNo =	this.docFirstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payBatNm =	this.payBatNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loopIndex =	this.loopIndex.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySeq =	this.paySeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalCurrency =	this.functionalCurrency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}