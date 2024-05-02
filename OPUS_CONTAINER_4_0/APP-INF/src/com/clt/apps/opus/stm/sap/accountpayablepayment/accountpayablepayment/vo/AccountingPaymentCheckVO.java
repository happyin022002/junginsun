/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountingPaymentCheckVO.java
 *@FileTitle : AccountingPaymentCheckVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.05.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.05.20  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo;

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
public class AccountingPaymentCheckVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AccountingPaymentCheckVO>  models =	new	ArrayList<AccountingPaymentCheckVO>();


	/*	Column Info	*/
	private  String	 accountingRequestId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 accountingHeaderId   =  null;
	/*	Column Info	*/
	private  String	 paySeq   =  null;
	/*	Column Info	*/
	private  String	 accountingEventId   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 accountingLineNo   =  null;
	/*	Column Info	*/
	private  String	 coaSeq   =  null;
	/*	Column Info	*/
	private  String	 invDtrbSeq   =  null;
	/*	Column Info	*/
	private  String	 gainLossAmt   =  null;
	/*	Column Info	*/
	private  String	 functionalCurrency   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public AccountingPaymentCheckVO(){}

	public AccountingPaymentCheckVO(String accountingRequestId,String ibflag,String usrId,String accountingHeaderId,String paySeq,String accountingEventId,String pagerows,String accountingLineNo,String coaSeq,String invDtrbSeq,String gainLossAmt,String functionalCurrency)	{
		this.accountingRequestId  = accountingRequestId ;
		this.ibflag  = ibflag ;
		this.usrId  = usrId ;
		this.accountingHeaderId  = accountingHeaderId ;
		this.paySeq  = paySeq ;
		this.accountingEventId  = accountingEventId ;
		this.pagerows  = pagerows ;
		this.accountingLineNo  = accountingLineNo ;
		this.coaSeq  = coaSeq ;
		this.invDtrbSeq  = invDtrbSeq ;
		this.gainLossAmt  = gainLossAmt ;
		this.functionalCurrency  = functionalCurrency ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("accounting_request_id", getAccountingRequestId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("accounting_header_id", getAccountingHeaderId());		
		this.hashColumns.put("pay_seq", getPaySeq());		
		this.hashColumns.put("accounting_event_id", getAccountingEventId());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("accounting_line_no", getAccountingLineNo());		
		this.hashColumns.put("coa_seq", getCoaSeq());		
		this.hashColumns.put("inv_dtrb_seq", getInvDtrbSeq());		
		this.hashColumns.put("gain_loss_amt", getGainLossAmt());		
		this.hashColumns.put("functional_currency", getFunctionalCurrency());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("accounting_request_id", "accountingRequestId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("accounting_header_id", "accountingHeaderId");
		this.hashFields.put("pay_seq", "paySeq");
		this.hashFields.put("accounting_event_id", "accountingEventId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("accounting_line_no", "accountingLineNo");
		this.hashFields.put("coa_seq", "coaSeq");
		this.hashFields.put("inv_dtrb_seq", "invDtrbSeq");
		this.hashFields.put("gain_loss_amt", "gainLossAmt");
		this.hashFields.put("functional_currency", "functionalCurrency");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  accountingRequestId
	*/
	public void	setAccountingRequestId( String	accountingRequestId ) {
		this.accountingRequestId =	accountingRequestId;
	}
 
	/**
	 * Column Info
	 * @return	accountingRequestId
	 */
	 public	String	getAccountingRequestId() {
		 return	this.accountingRequestId;
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
	* @param  accountingHeaderId
	*/
	public void	setAccountingHeaderId( String	accountingHeaderId ) {
		this.accountingHeaderId =	accountingHeaderId;
	}
 
	/**
	 * Column Info
	 * @return	accountingHeaderId
	 */
	 public	String	getAccountingHeaderId() {
		 return	this.accountingHeaderId;
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
	 public	String	getPaySeq() {
		 return	this.paySeq;
	 } 
 	/**
	* Column Info
	* @param  accountingEventId
	*/
	public void	setAccountingEventId( String	accountingEventId ) {
		this.accountingEventId =	accountingEventId;
	}
 
	/**
	 * Column Info
	 * @return	accountingEventId
	 */
	 public	String	getAccountingEventId() {
		 return	this.accountingEventId;
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
	* @param  accountingLineNo
	*/
	public void	setAccountingLineNo( String	accountingLineNo ) {
		this.accountingLineNo =	accountingLineNo;
	}
 
	/**
	 * Column Info
	 * @return	accountingLineNo
	 */
	 public	String	getAccountingLineNo() {
		 return	this.accountingLineNo;
	 } 
 	/**
	* Column Info
	* @param  coaSeq
	*/
	public void	setCoaSeq( String	coaSeq ) {
		this.coaSeq =	coaSeq;
	}
 
	/**
	 * Column Info
	 * @return	coaSeq
	 */
	 public	String	getCoaSeq() {
		 return	this.coaSeq;
	 } 
 	/**
	* Column Info
	* @param  invDtrbSeq
	*/
	public void	setInvDtrbSeq( String	invDtrbSeq ) {
		this.invDtrbSeq =	invDtrbSeq;
	}
 
	/**
	 * Column Info
	 * @return	invDtrbSeq
	 */
	 public	String	getInvDtrbSeq() {
		 return	this.invDtrbSeq;
	 } 
 	/**
	* Column Info
	* @param  gainLossAmt
	*/
	public void	setGainLossAmt( String	gainLossAmt ) {
		this.gainLossAmt =	gainLossAmt;
	}
 
	/**
	 * Column Info
	 * @return	gainLossAmt
	 */
	 public	String	getGainLossAmt() {
		 return	this.gainLossAmt;
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
	 public	String	getFunctionalCurrency() {
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
		setAccountingRequestId(JSPUtil.getParameter(request,	prefix + "accounting_request_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setAccountingHeaderId(JSPUtil.getParameter(request,	prefix + "accounting_header_id", ""));
		setPaySeq(JSPUtil.getParameter(request,	prefix + "pay_seq", ""));
		setAccountingEventId(JSPUtil.getParameter(request,	prefix + "accounting_event_id", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAccountingLineNo(JSPUtil.getParameter(request,	prefix + "accounting_line_no", ""));
		setCoaSeq(JSPUtil.getParameter(request,	prefix + "coa_seq", ""));
		setInvDtrbSeq(JSPUtil.getParameter(request,	prefix + "inv_dtrb_seq", ""));
		setGainLossAmt(JSPUtil.getParameter(request,	prefix + "gain_loss_amt", ""));
		setFunctionalCurrency(JSPUtil.getParameter(request,	prefix + "functional_currency", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AccountingPaymentCheckVO[]
	 */
	public AccountingPaymentCheckVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AccountingPaymentCheckVO[]
	 */
	public AccountingPaymentCheckVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AccountingPaymentCheckVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] accountingRequestId =	(JSPUtil.getParameter(request, prefix +	"accounting_request_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] accountingHeaderId =	(JSPUtil.getParameter(request, prefix +	"accounting_header_id".trim(),	length));
				String[] paySeq =	(JSPUtil.getParameter(request, prefix +	"pay_seq".trim(),	length));
				String[] accountingEventId =	(JSPUtil.getParameter(request, prefix +	"accounting_event_id".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] accountingLineNo =	(JSPUtil.getParameter(request, prefix +	"accounting_line_no".trim(),	length));
				String[] coaSeq =	(JSPUtil.getParameter(request, prefix +	"coa_seq".trim(),	length));
				String[] invDtrbSeq =	(JSPUtil.getParameter(request, prefix +	"inv_dtrb_seq".trim(),	length));
				String[] gainLossAmt =	(JSPUtil.getParameter(request, prefix +	"gain_loss_amt".trim(),	length));
				String[] functionalCurrency =	(JSPUtil.getParameter(request, prefix +	"functional_currency".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AccountingPaymentCheckVO();
						if ( accountingRequestId[i] !=	null)
						model.setAccountingRequestId( accountingRequestId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( accountingHeaderId[i] !=	null)
						model.setAccountingHeaderId( accountingHeaderId[i]);
						if ( paySeq[i] !=	null)
						model.setPaySeq( paySeq[i]);
						if ( accountingEventId[i] !=	null)
						model.setAccountingEventId( accountingEventId[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( accountingLineNo[i] !=	null)
						model.setAccountingLineNo( accountingLineNo[i]);
						if ( coaSeq[i] !=	null)
						model.setCoaSeq( coaSeq[i]);
						if ( invDtrbSeq[i] !=	null)
						model.setInvDtrbSeq( invDtrbSeq[i]);
						if ( gainLossAmt[i] !=	null)
						model.setGainLossAmt( gainLossAmt[i]);
						if ( functionalCurrency[i] !=	null)
						model.setFunctionalCurrency( functionalCurrency[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAccountingPaymentCheckVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AccountingPaymentCheckVO[]
	 */
	public AccountingPaymentCheckVO[]	 getAccountingPaymentCheckVOs(){
		AccountingPaymentCheckVO[] vos = (AccountingPaymentCheckVO[])models.toArray(new	AccountingPaymentCheckVO[models.size()]);
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
		this.accountingRequestId =	this.accountingRequestId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountingHeaderId =	this.accountingHeaderId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paySeq =	this.paySeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountingEventId =	this.accountingEventId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountingLineNo =	this.accountingLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaSeq =	this.coaSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDtrbSeq =	this.invDtrbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainLossAmt =	this.gainLossAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalCurrency =	this.functionalCurrency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}