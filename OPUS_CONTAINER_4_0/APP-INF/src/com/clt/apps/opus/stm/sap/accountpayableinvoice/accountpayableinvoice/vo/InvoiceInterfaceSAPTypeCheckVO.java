/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceInterfaceSAPTypeCheckVO.java
 *@FileTitle : InvoiceInterfaceSAPTypeCheckVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.05.28
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.05.28  
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
public class InvoiceInterfaceSAPTypeCheckVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceInterfaceSAPTypeCheckVO>  models =	new	ArrayList<InvoiceInterfaceSAPTypeCheckVO>();


	/*	Column Info	*/
	private  String	 csrNo   =  null;
	/*	Column Info	*/
	private  String	 functionalCurrency   =  null;
	/*	Column Info	*/
	private  String	 itemTaxCount   =  null;
	/*	Column Info	*/
	private  String	 slipInterfaceSeq   =  null;
	/*	Column Info	*/
	private  String	 invoiceType   =  null;
	/*	Column Info	*/
	private  String	 prepayCount   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 holdFlag   =  null;
	/*	Column Info	*/
	private  String	 asaFlag   =  null;
	/*	Column Info	*/
	private  String	 approvalFlag   =  null;
	/*	Column Info	*/
	private  String	 cancelFlag   =  null;
	/*	Column Info	*/
	private  String	 wtaxCount   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 slipType   =  null;
	/*	Column Info	*/
	private  String	 categoryName   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 accrualFlag   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 ppayRemainingFlag   =  null;
	/*	Column Info	*/
	private  String	 taxCount   =  null;
	/*	Column Info	*/
	private  String	 ppayExDiffFlag   =  null;
	/*	Column Info	*/
	private  String	 prepayRound   =  null;
	/*	Column Info	*/
	private  String	 upstreamApply   =  null;
	/*	Column Info	*/
	private  String	 fullApplyFlag   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceInterfaceSAPTypeCheckVO(){}

	public InvoiceInterfaceSAPTypeCheckVO(String csrNo,String functionalCurrency,String itemTaxCount,String slipInterfaceSeq,String invoiceType,String prepayCount,String invSeq,String holdFlag,String asaFlag,String approvalFlag,String cancelFlag,String wtaxCount,String pagerows,String slipType,String categoryName,String ibflag,String accrualFlag,String usrId,String ppayRemainingFlag,String taxCount,String ppayExDiffFlag,String prepayRound,String upstreamApply,String fullApplyFlag)	{
		this.csrNo  = csrNo ;
		this.functionalCurrency  = functionalCurrency ;
		this.itemTaxCount  = itemTaxCount ;
		this.slipInterfaceSeq  = slipInterfaceSeq ;
		this.invoiceType  = invoiceType ;
		this.prepayCount  = prepayCount ;
		this.invSeq  = invSeq ;
		this.holdFlag  = holdFlag ;
		this.asaFlag  = asaFlag ;
		this.approvalFlag  = approvalFlag ;
		this.cancelFlag  = cancelFlag ;
		this.wtaxCount  = wtaxCount ;
		this.pagerows  = pagerows ;
		this.slipType  = slipType ;
		this.categoryName  = categoryName ;
		this.ibflag  = ibflag ;
		this.accrualFlag  = accrualFlag ;
		this.usrId  = usrId ;
		this.ppayRemainingFlag  = ppayRemainingFlag ;
		this.taxCount  = taxCount ;
		this.ppayExDiffFlag  = ppayExDiffFlag ;
		this.prepayRound  = prepayRound ;
		this.upstreamApply  = upstreamApply ;
		this.fullApplyFlag  = fullApplyFlag ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("csr_no", getCsrNo());		
		this.hashColumns.put("functional_currency", getFunctionalCurrency());		
		this.hashColumns.put("item_tax_count", getItemTaxCount());		
		this.hashColumns.put("slip_interface_seq", getSlipInterfaceSeq());		
		this.hashColumns.put("invoice_type", getInvoiceType());		
		this.hashColumns.put("prepay_count", getPrepayCount());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("hold_flag", getHoldFlag());		
		this.hashColumns.put("asa_flag", getAsaFlag());		
		this.hashColumns.put("approval_flag", getApprovalFlag());		
		this.hashColumns.put("cancel_flag", getCancelFlag());		
		this.hashColumns.put("wtax_count", getWtaxCount());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("slip_type", getSlipType());		
		this.hashColumns.put("category_name", getCategoryName());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("accrual_flag", getAccrualFlag());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("ppay_remaining_flag", getPpayRemainingFlag());		
		this.hashColumns.put("tax_count", getTaxCount());		
		this.hashColumns.put("ppay_ex_diff_flag", getPpayExDiffFlag());		
		this.hashColumns.put("prepay_round", getPrepayRound());		
		this.hashColumns.put("upstream_apply", getUpstreamApply());		
		this.hashColumns.put("full_apply_flag", getFullApplyFlag());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("functional_currency", "functionalCurrency");
		this.hashFields.put("item_tax_count", "itemTaxCount");
		this.hashFields.put("slip_interface_seq", "slipInterfaceSeq");
		this.hashFields.put("invoice_type", "invoiceType");
		this.hashFields.put("prepay_count", "prepayCount");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("hold_flag", "holdFlag");
		this.hashFields.put("asa_flag", "asaFlag");
		this.hashFields.put("approval_flag", "approvalFlag");
		this.hashFields.put("cancel_flag", "cancelFlag");
		this.hashFields.put("wtax_count", "wtaxCount");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("slip_type", "slipType");
		this.hashFields.put("category_name", "categoryName");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("accrual_flag", "accrualFlag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("ppay_remaining_flag", "ppayRemainingFlag");
		this.hashFields.put("tax_count", "taxCount");
		this.hashFields.put("ppay_ex_diff_flag", "ppayExDiffFlag");
		this.hashFields.put("prepay_round", "prepayRound");
		this.hashFields.put("upstream_apply", "upstreamApply");
		this.hashFields.put("full_apply_flag", "fullApplyFlag");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  csrNo
	*/
	public void	setCsrNo( String	csrNo ) {
		this.csrNo =	csrNo;
	}
 
	/**
	 * Column Info
	 * @return	csrNo
	 */
	 public	String	getCsrNo() {
		 return	this.csrNo;
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
	* @param  itemTaxCount
	*/
	public void	setItemTaxCount( String	itemTaxCount ) {
		this.itemTaxCount =	itemTaxCount;
	}
 
	/**
	 * Column Info
	 * @return	itemTaxCount
	 */
	 public	String	getItemTaxCount() {
		 return	this.itemTaxCount;
	 } 
 	/**
	* Column Info
	* @param  slipInterfaceSeq
	*/
	public void	setSlipInterfaceSeq( String	slipInterfaceSeq ) {
		this.slipInterfaceSeq =	slipInterfaceSeq;
	}
 
	/**
	 * Column Info
	 * @return	slipInterfaceSeq
	 */
	 public	String	getSlipInterfaceSeq() {
		 return	this.slipInterfaceSeq;
	 } 
 	/**
	* Column Info
	* @param  invoiceType
	*/
	public void	setInvoiceType( String	invoiceType ) {
		this.invoiceType =	invoiceType;
	}
 
	/**
	 * Column Info
	 * @return	invoiceType
	 */
	 public	String	getInvoiceType() {
		 return	this.invoiceType;
	 } 
 	/**
	* Column Info
	* @param  prepayCount
	*/
	public void	setPrepayCount( String	prepayCount ) {
		this.prepayCount =	prepayCount;
	}
 
	/**
	 * Column Info
	 * @return	prepayCount
	 */
	 public	String	getPrepayCount() {
		 return	this.prepayCount;
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
	* @param  holdFlag
	*/
	public void	setHoldFlag( String	holdFlag ) {
		this.holdFlag =	holdFlag;
	}
 
	/**
	 * Column Info
	 * @return	holdFlag
	 */
	 public	String	getHoldFlag() {
		 return	this.holdFlag;
	 } 
 	/**
	* Column Info
	* @param  asaFlag
	*/
	public void	setAsaFlag( String	asaFlag ) {
		this.asaFlag =	asaFlag;
	}
 
	/**
	 * Column Info
	 * @return	asaFlag
	 */
	 public	String	getAsaFlag() {
		 return	this.asaFlag;
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
	* @param  cancelFlag
	*/
	public void	setCancelFlag( String	cancelFlag ) {
		this.cancelFlag =	cancelFlag;
	}
 
	/**
	 * Column Info
	 * @return	cancelFlag
	 */
	 public	String	getCancelFlag() {
		 return	this.cancelFlag;
	 } 
 	/**
	* Column Info
	* @param  wtaxCount
	*/
	public void	setWtaxCount( String	wtaxCount ) {
		this.wtaxCount =	wtaxCount;
	}
 
	/**
	 * Column Info
	 * @return	wtaxCount
	 */
	 public	String	getWtaxCount() {
		 return	this.wtaxCount;
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
	* @param  slipType
	*/
	public void	setSlipType( String	slipType ) {
		this.slipType =	slipType;
	}
 
	/**
	 * Column Info
	 * @return	slipType
	 */
	 public	String	getSlipType() {
		 return	this.slipType;
	 } 
 	/**
	* Column Info
	* @param  categoryName
	*/
	public void	setCategoryName( String	categoryName ) {
		this.categoryName =	categoryName;
	}
 
	/**
	 * Column Info
	 * @return	categoryName
	 */
	 public	String	getCategoryName() {
		 return	this.categoryName;
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
	* @param  accrualFlag
	*/
	public void	setAccrualFlag( String	accrualFlag ) {
		this.accrualFlag =	accrualFlag;
	}
 
	/**
	 * Column Info
	 * @return	accrualFlag
	 */
	 public	String	getAccrualFlag() {
		 return	this.accrualFlag;
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
	* @param  ppayRemainingFlag
	*/
	public void	setPpayRemainingFlag( String	ppayRemainingFlag ) {
		this.ppayRemainingFlag =	ppayRemainingFlag;
	}
 
	/**
	 * Column Info
	 * @return	ppayRemainingFlag
	 */
	 public	String	getPpayRemainingFlag() {
		 return	this.ppayRemainingFlag;
	 } 
 	/**
	* Column Info
	* @param  taxCount
	*/
	public void	setTaxCount( String	taxCount ) {
		this.taxCount =	taxCount;
	}
 
	/**
	 * Column Info
	 * @return	taxCount
	 */
	 public	String	getTaxCount() {
		 return	this.taxCount;
	 } 
 	/**
	* Column Info
	* @param  ppayExDiffFlag
	*/
	public void	setPpayExDiffFlag( String	ppayExDiffFlag ) {
		this.ppayExDiffFlag =	ppayExDiffFlag;
	}
 
	/**
	 * Column Info
	 * @return	ppayExDiffFlag
	 */
	 public	String	getPpayExDiffFlag() {
		 return	this.ppayExDiffFlag;
	 } 
 	/**
	* Column Info
	* @param  prepayRound
	*/
	public void	setPrepayRound( String	prepayRound ) {
		this.prepayRound =	prepayRound;
	}
 
	/**
	 * Column Info
	 * @return	prepayRound
	 */
	 public	String	getPrepayRound() {
		 return	this.prepayRound;
	 } 
 	/**
	* Column Info
	* @param  upstreamApply
	*/
	public void	setUpstreamApply( String	upstreamApply ) {
		this.upstreamApply =	upstreamApply;
	}
 
	/**
	 * Column Info
	 * @return	upstreamApply
	 */
	 public	String	getUpstreamApply() {
		 return	this.upstreamApply;
	 } 
 	/**
	* Column Info
	* @param  fullApplyFlag
	*/
	public void	setFullApplyFlag( String	fullApplyFlag ) {
		this.fullApplyFlag =	fullApplyFlag;
	}
 
	/**
	 * Column Info
	 * @return	fullApplyFlag
	 */
	 public	String	getFullApplyFlag() {
		 return	this.fullApplyFlag;
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
		setCsrNo(JSPUtil.getParameter(request,	prefix + "csr_no", ""));
		setFunctionalCurrency(JSPUtil.getParameter(request,	prefix + "functional_currency", ""));
		setItemTaxCount(JSPUtil.getParameter(request,	prefix + "item_tax_count", ""));
		setSlipInterfaceSeq(JSPUtil.getParameter(request,	prefix + "slip_interface_seq", ""));
		setInvoiceType(JSPUtil.getParameter(request,	prefix + "invoice_type", ""));
		setPrepayCount(JSPUtil.getParameter(request,	prefix + "prepay_count", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setHoldFlag(JSPUtil.getParameter(request,	prefix + "hold_flag", ""));
		setAsaFlag(JSPUtil.getParameter(request,	prefix + "asa_flag", ""));
		setApprovalFlag(JSPUtil.getParameter(request,	prefix + "approval_flag", ""));
		setCancelFlag(JSPUtil.getParameter(request,	prefix + "cancel_flag", ""));
		setWtaxCount(JSPUtil.getParameter(request,	prefix + "wtax_count", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSlipType(JSPUtil.getParameter(request,	prefix + "slip_type", ""));
		setCategoryName(JSPUtil.getParameter(request,	prefix + "category_name", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAccrualFlag(JSPUtil.getParameter(request,	prefix + "accrual_flag", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setPpayRemainingFlag(JSPUtil.getParameter(request,	prefix + "ppay_remaining_flag", ""));
		setTaxCount(JSPUtil.getParameter(request,	prefix + "tax_count", ""));
		setPpayExDiffFlag(JSPUtil.getParameter(request,	prefix + "ppay_ex_diff_flag", ""));
		setPrepayRound(JSPUtil.getParameter(request,	prefix + "prepay_round", ""));
		setUpstreamApply(JSPUtil.getParameter(request,	prefix + "upstream_apply", ""));
		setFullApplyFlag(JSPUtil.getParameter(request,	prefix + "full_apply_flag", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceInterfaceSAPTypeCheckVO[]
	 */
	public InvoiceInterfaceSAPTypeCheckVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceInterfaceSAPTypeCheckVO[]
	 */
	public InvoiceInterfaceSAPTypeCheckVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceInterfaceSAPTypeCheckVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] csrNo =	(JSPUtil.getParameter(request, prefix +	"csr_no".trim(),	length));
				String[] functionalCurrency =	(JSPUtil.getParameter(request, prefix +	"functional_currency".trim(),	length));
				String[] itemTaxCount =	(JSPUtil.getParameter(request, prefix +	"item_tax_count".trim(),	length));
				String[] slipInterfaceSeq =	(JSPUtil.getParameter(request, prefix +	"slip_interface_seq".trim(),	length));
				String[] invoiceType =	(JSPUtil.getParameter(request, prefix +	"invoice_type".trim(),	length));
				String[] prepayCount =	(JSPUtil.getParameter(request, prefix +	"prepay_count".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] holdFlag =	(JSPUtil.getParameter(request, prefix +	"hold_flag".trim(),	length));
				String[] asaFlag =	(JSPUtil.getParameter(request, prefix +	"asa_flag".trim(),	length));
				String[] approvalFlag =	(JSPUtil.getParameter(request, prefix +	"approval_flag".trim(),	length));
				String[] cancelFlag =	(JSPUtil.getParameter(request, prefix +	"cancel_flag".trim(),	length));
				String[] wtaxCount =	(JSPUtil.getParameter(request, prefix +	"wtax_count".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] slipType =	(JSPUtil.getParameter(request, prefix +	"slip_type".trim(),	length));
				String[] categoryName =	(JSPUtil.getParameter(request, prefix +	"category_name".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] accrualFlag =	(JSPUtil.getParameter(request, prefix +	"accrual_flag".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] ppayRemainingFlag =	(JSPUtil.getParameter(request, prefix +	"ppay_remaining_flag".trim(),	length));
				String[] taxCount =	(JSPUtil.getParameter(request, prefix +	"tax_count".trim(),	length));
				String[] ppayExDiffFlag =	(JSPUtil.getParameter(request, prefix +	"ppay_ex_diff_flag".trim(),	length));
				String[] prepayRound =	(JSPUtil.getParameter(request, prefix +	"prepay_round".trim(),	length));
				String[] upstreamApply =	(JSPUtil.getParameter(request, prefix +	"upstream_apply".trim(),	length));
				String[] fullApplyFlag =	(JSPUtil.getParameter(request, prefix +	"full_apply_flag".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceInterfaceSAPTypeCheckVO();
						if ( csrNo[i] !=	null)
						model.setCsrNo( csrNo[i]);
						if ( functionalCurrency[i] !=	null)
						model.setFunctionalCurrency( functionalCurrency[i]);
						if ( itemTaxCount[i] !=	null)
						model.setItemTaxCount( itemTaxCount[i]);
						if ( slipInterfaceSeq[i] !=	null)
						model.setSlipInterfaceSeq( slipInterfaceSeq[i]);
						if ( invoiceType[i] !=	null)
						model.setInvoiceType( invoiceType[i]);
						if ( prepayCount[i] !=	null)
						model.setPrepayCount( prepayCount[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( holdFlag[i] !=	null)
						model.setHoldFlag( holdFlag[i]);
						if ( asaFlag[i] !=	null)
						model.setAsaFlag( asaFlag[i]);
						if ( approvalFlag[i] !=	null)
						model.setApprovalFlag( approvalFlag[i]);
						if ( cancelFlag[i] !=	null)
						model.setCancelFlag( cancelFlag[i]);
						if ( wtaxCount[i] !=	null)
						model.setWtaxCount( wtaxCount[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( slipType[i] !=	null)
						model.setSlipType( slipType[i]);
						if ( categoryName[i] !=	null)
						model.setCategoryName( categoryName[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( accrualFlag[i] !=	null)
						model.setAccrualFlag( accrualFlag[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( ppayRemainingFlag[i] !=	null)
						model.setPpayRemainingFlag( ppayRemainingFlag[i]);
						if ( taxCount[i] !=	null)
						model.setTaxCount( taxCount[i]);
						if ( ppayExDiffFlag[i] !=	null)
						model.setPpayExDiffFlag( ppayExDiffFlag[i]);
						if ( prepayRound[i] !=	null)
						model.setPrepayRound( prepayRound[i]);
						if ( upstreamApply[i] !=	null)
						model.setUpstreamApply( upstreamApply[i]);
						if ( fullApplyFlag[i] !=	null)
						model.setFullApplyFlag( fullApplyFlag[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceInterfaceSAPTypeCheckVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceInterfaceSAPTypeCheckVO[]
	 */
	public InvoiceInterfaceSAPTypeCheckVO[]	 getInvoiceInterfaceSAPTypeCheckVOs(){
		InvoiceInterfaceSAPTypeCheckVO[] vos = (InvoiceInterfaceSAPTypeCheckVO[])models.toArray(new	InvoiceInterfaceSAPTypeCheckVO[models.size()]);
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
		this.csrNo =	this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalCurrency =	this.functionalCurrency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.itemTaxCount =	this.itemTaxCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slipInterfaceSeq =	this.slipInterfaceSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceType =	this.invoiceType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prepayCount =	this.prepayCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.holdFlag =	this.holdFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaFlag =	this.asaFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalFlag =	this.approvalFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelFlag =	this.cancelFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wtaxCount =	this.wtaxCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slipType =	this.slipType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.categoryName =	this.categoryName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accrualFlag =	this.accrualFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayRemainingFlag =	this.ppayRemainingFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxCount =	this.taxCount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayExDiffFlag =	this.ppayExDiffFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prepayRound =	this.prepayRound.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upstreamApply =	this.upstreamApply.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullApplyFlag =	this.fullApplyFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}