/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountingPaymentLineCheckVO.java
 *@FileTitle : AccountingPaymentLineCheckVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.05.15
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.05.15  
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
public class AccountingPaymentLineCheckVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AccountingPaymentLineCheckVO>  models =	new	ArrayList<AccountingPaymentLineCheckVO>();


	/*	Column Info	*/
	private  String	 accountingRequestId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 invPaySeq   =  null;
	/*	Column Info	*/
	private  String	 accountingHeaderId   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 accountingEventId   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 functionalCurrency   =  null;
	/*	Column Info	*/
	private  String	 accountingLineNo   =  null;
	/*	Column Info	*/
	private  String	 gainLossAmt   =  null;
	/*	Column Info	*/
	private  String	 coaSeq   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public AccountingPaymentLineCheckVO(){}

	public AccountingPaymentLineCheckVO(String accountingRequestId,String ibflag,String usrId,String invPaySeq,String accountingHeaderId,String invSeq,String accountingEventId,String pagerows,String functionalCurrency,String accountingLineNo,String gainLossAmt,String coaSeq)	{
		this.accountingRequestId  = accountingRequestId ;
		this.ibflag  = ibflag ;
		this.usrId  = usrId ;
		this.invPaySeq  = invPaySeq ;
		this.accountingHeaderId  = accountingHeaderId ;
		this.invSeq  = invSeq ;
		this.accountingEventId  = accountingEventId ;
		this.pagerows  = pagerows ;
		this.functionalCurrency  = functionalCurrency ;
		this.accountingLineNo  = accountingLineNo ;
		this.gainLossAmt  = gainLossAmt ;
		this.coaSeq  = coaSeq ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("accounting_request_id", getAccountingRequestId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("inv_pay_seq", getInvPaySeq());		
		this.hashColumns.put("accounting_header_id", getAccountingHeaderId());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("accounting_event_id", getAccountingEventId());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("functional_currency", getFunctionalCurrency());		
		this.hashColumns.put("accounting_line_no", getAccountingLineNo());		
		this.hashColumns.put("gain_loss_amt", getGainLossAmt());		
		this.hashColumns.put("coa_seq", getCoaSeq());		
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
		this.hashFields.put("inv_pay_seq", "invPaySeq");
		this.hashFields.put("accounting_header_id", "accountingHeaderId");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("accounting_event_id", "accountingEventId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("functional_currency", "functionalCurrency");
		this.hashFields.put("accounting_line_no", "accountingLineNo");
		this.hashFields.put("gain_loss_amt", "gainLossAmt");
		this.hashFields.put("coa_seq", "coaSeq");
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
	* @param  invPaySeq
	*/
	public void	setInvPaySeq( String	invPaySeq ) {
		this.invPaySeq =	invPaySeq;
	}
 
	/**
	 * Column Info
	 * @return	invPaySeq
	 */
	 public	String	getInvPaySeq() {
		 return	this.invPaySeq;
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
		setInvPaySeq(JSPUtil.getParameter(request,	prefix + "inv_pay_seq", ""));
		setAccountingHeaderId(JSPUtil.getParameter(request,	prefix + "accounting_header_id", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setAccountingEventId(JSPUtil.getParameter(request,	prefix + "accounting_event_id", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setFunctionalCurrency(JSPUtil.getParameter(request,	prefix + "functional_currency", ""));
		setAccountingLineNo(JSPUtil.getParameter(request,	prefix + "accounting_line_no", ""));
		setGainLossAmt(JSPUtil.getParameter(request,	prefix + "gain_loss_amt", ""));
		setCoaSeq(JSPUtil.getParameter(request,	prefix + "coa_seq", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AccountingPaymentLineCheckVO[]
	 */
	public AccountingPaymentLineCheckVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AccountingPaymentLineCheckVO[]
	 */
	public AccountingPaymentLineCheckVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AccountingPaymentLineCheckVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] accountingRequestId =	(JSPUtil.getParameter(request, prefix +	"accounting_request_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] invPaySeq =	(JSPUtil.getParameter(request, prefix +	"inv_pay_seq".trim(),	length));
				String[] accountingHeaderId =	(JSPUtil.getParameter(request, prefix +	"accounting_header_id".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] accountingEventId =	(JSPUtil.getParameter(request, prefix +	"accounting_event_id".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] functionalCurrency =	(JSPUtil.getParameter(request, prefix +	"functional_currency".trim(),	length));
				String[] accountingLineNo =	(JSPUtil.getParameter(request, prefix +	"accounting_line_no".trim(),	length));
				String[] gainLossAmt =	(JSPUtil.getParameter(request, prefix +	"gain_loss_amt".trim(),	length));
				String[] coaSeq =	(JSPUtil.getParameter(request, prefix +	"coa_seq".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AccountingPaymentLineCheckVO();
						if ( accountingRequestId[i] !=	null)
						model.setAccountingRequestId( accountingRequestId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( invPaySeq[i] !=	null)
						model.setInvPaySeq( invPaySeq[i]);
						if ( accountingHeaderId[i] !=	null)
						model.setAccountingHeaderId( accountingHeaderId[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( accountingEventId[i] !=	null)
						model.setAccountingEventId( accountingEventId[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( functionalCurrency[i] !=	null)
						model.setFunctionalCurrency( functionalCurrency[i]);
						if ( accountingLineNo[i] !=	null)
						model.setAccountingLineNo( accountingLineNo[i]);
						if ( gainLossAmt[i] !=	null)
						model.setGainLossAmt( gainLossAmt[i]);
						if ( coaSeq[i] !=	null)
						model.setCoaSeq( coaSeq[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAccountingPaymentLineCheckVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AccountingPaymentLineCheckVO[]
	 */
	public AccountingPaymentLineCheckVO[]	 getAccountingPaymentLineCheckVOs(){
		AccountingPaymentLineCheckVO[] vos = (AccountingPaymentLineCheckVO[])models.toArray(new	AccountingPaymentLineCheckVO[models.size()]);
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
		this.invPaySeq =	this.invPaySeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountingHeaderId =	this.accountingHeaderId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountingEventId =	this.accountingEventId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalCurrency =	this.functionalCurrency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accountingLineNo =	this.accountingLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gainLossAmt =	this.gainLossAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaSeq =	this.coaSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}