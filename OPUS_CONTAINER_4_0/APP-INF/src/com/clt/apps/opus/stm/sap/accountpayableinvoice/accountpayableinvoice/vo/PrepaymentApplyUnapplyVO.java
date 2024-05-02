/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PrepaymentApplyUnapplyVO.java
 *@FileTitle : PrepaymentApplyUnapplyVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.04.28
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.04.28  
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
public class PrepaymentApplyUnapplyVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PrepaymentApplyUnapplyVO>  models =	new	ArrayList<PrepaymentApplyUnapplyVO>();


	/*	Column Info	*/
	private  String	 prepaymentInvSeq   =  null;
	/*	Column Info	*/
	private  String	 unapplyAmount   =  null;
	/*	Column Info	*/
	private  String	 unapplyGlDate   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 prepaymentLineNo   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 applyGlDate   =  null;
	/*	Column Info	*/
	private  String	 standardLineNo   =  null;
	/*	Column Info	*/
	private  String	 applyAmount   =  null;
	/*	Column Info	*/
	private  String	 standardInvSeq   =  null;
	/*	Column Info	*/
	private  String	 currency   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 functionalCurrency   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public PrepaymentApplyUnapplyVO(){}

	public PrepaymentApplyUnapplyVO(String prepaymentInvSeq,String unapplyAmount,String unapplyGlDate,String ibflag,String prepaymentLineNo,String usrId,String applyGlDate,String standardLineNo,String applyAmount,String standardInvSeq,String currency,String pagerows,String functionalCurrency)	{
		this.prepaymentInvSeq  = prepaymentInvSeq ;
		this.unapplyAmount  = unapplyAmount ;
		this.unapplyGlDate  = unapplyGlDate ;
		this.ibflag  = ibflag ;
		this.prepaymentLineNo  = prepaymentLineNo ;
		this.usrId  = usrId ;
		this.applyGlDate  = applyGlDate ;
		this.standardLineNo  = standardLineNo ;
		this.applyAmount  = applyAmount ;
		this.standardInvSeq  = standardInvSeq ;
		this.currency  = currency ;
		this.pagerows  = pagerows ;
		this.functionalCurrency  = functionalCurrency ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("prepayment_inv_seq", getPrepaymentInvSeq());		
		this.hashColumns.put("unapply_amount", getUnapplyAmount());		
		this.hashColumns.put("unapply_gl_date", getUnapplyGlDate());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("prepayment_line_no", getPrepaymentLineNo());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("apply_gl_date", getApplyGlDate());		
		this.hashColumns.put("standard_line_no", getStandardLineNo());		
		this.hashColumns.put("apply_amount", getApplyAmount());		
		this.hashColumns.put("standard_inv_seq", getStandardInvSeq());		
		this.hashColumns.put("currency", getCurrency());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("functional_currency", getFunctionalCurrency());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("prepayment_inv_seq", "prepaymentInvSeq");
		this.hashFields.put("unapply_amount", "unapplyAmount");
		this.hashFields.put("unapply_gl_date", "unapplyGlDate");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("prepayment_line_no", "prepaymentLineNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("apply_gl_date", "applyGlDate");
		this.hashFields.put("standard_line_no", "standardLineNo");
		this.hashFields.put("apply_amount", "applyAmount");
		this.hashFields.put("standard_inv_seq", "standardInvSeq");
		this.hashFields.put("currency", "currency");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("functional_currency", "functionalCurrency");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  prepaymentInvSeq
	*/
	public void	setPrepaymentInvSeq( String	prepaymentInvSeq ) {
		this.prepaymentInvSeq =	prepaymentInvSeq;
	}
 
	/**
	 * Column Info
	 * @return	prepaymentInvSeq
	 */
	 public	String	getPrepaymentInvSeq() {
		 return	this.prepaymentInvSeq;
	 } 
 	/**
	* Column Info
	* @param  unapplyAmount
	*/
	public void	setUnapplyAmount( String	unapplyAmount ) {
		this.unapplyAmount =	unapplyAmount;
	}
 
	/**
	 * Column Info
	 * @return	unapplyAmount
	 */
	 public	String	getUnapplyAmount() {
		 return	this.unapplyAmount;
	 } 
 	/**
	* Column Info
	* @param  unapplyGlDate
	*/
	public void	setUnapplyGlDate( String	unapplyGlDate ) {
		this.unapplyGlDate =	unapplyGlDate;
	}
 
	/**
	 * Column Info
	 * @return	unapplyGlDate
	 */
	 public	String	getUnapplyGlDate() {
		 return	this.unapplyGlDate;
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
	* @param  prepaymentLineNo
	*/
	public void	setPrepaymentLineNo( String	prepaymentLineNo ) {
		this.prepaymentLineNo =	prepaymentLineNo;
	}
 
	/**
	 * Column Info
	 * @return	prepaymentLineNo
	 */
	 public	String	getPrepaymentLineNo() {
		 return	this.prepaymentLineNo;
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
	* @param  applyGlDate
	*/
	public void	setApplyGlDate( String	applyGlDate ) {
		this.applyGlDate =	applyGlDate;
	}
 
	/**
	 * Column Info
	 * @return	applyGlDate
	 */
	 public	String	getApplyGlDate() {
		 return	this.applyGlDate;
	 } 
 	/**
	* Column Info
	* @param  standardLineNo
	*/
	public void	setStandardLineNo( String	standardLineNo ) {
		this.standardLineNo =	standardLineNo;
	}
 
	/**
	 * Column Info
	 * @return	standardLineNo
	 */
	 public	String	getStandardLineNo() {
		 return	this.standardLineNo;
	 } 
 	/**
	* Column Info
	* @param  applyAmount
	*/
	public void	setApplyAmount( String	applyAmount ) {
		this.applyAmount =	applyAmount;
	}
 
	/**
	 * Column Info
	 * @return	applyAmount
	 */
	 public	String	getApplyAmount() {
		 return	this.applyAmount;
	 } 
 	/**
	* Column Info
	* @param  standardInvSeq
	*/
	public void	setStandardInvSeq( String	standardInvSeq ) {
		this.standardInvSeq =	standardInvSeq;
	}
 
	/**
	 * Column Info
	 * @return	standardInvSeq
	 */
	 public	String	getStandardInvSeq() {
		 return	this.standardInvSeq;
	 } 
 	/**
	* Column Info
	* @param  currency
	*/
	public void	setCurrency( String	currency ) {
		this.currency =	currency;
	}
 
	/**
	 * Column Info
	 * @return	currency
	 */
	 public	String	getCurrency() {
		 return	this.currency;
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
		setPrepaymentInvSeq(JSPUtil.getParameter(request,	prefix + "prepayment_inv_seq", ""));
		setUnapplyAmount(JSPUtil.getParameter(request,	prefix + "unapply_amount", ""));
		setUnapplyGlDate(JSPUtil.getParameter(request,	prefix + "unapply_gl_date", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPrepaymentLineNo(JSPUtil.getParameter(request,	prefix + "prepayment_line_no", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setApplyGlDate(JSPUtil.getParameter(request,	prefix + "apply_gl_date", ""));
		setStandardLineNo(JSPUtil.getParameter(request,	prefix + "standard_line_no", ""));
		setApplyAmount(JSPUtil.getParameter(request,	prefix + "apply_amount", ""));
		setStandardInvSeq(JSPUtil.getParameter(request,	prefix + "standard_inv_seq", ""));
		setCurrency(JSPUtil.getParameter(request,	prefix + "currency", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setFunctionalCurrency(JSPUtil.getParameter(request,	prefix + "functional_currency", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrepaymentApplyUnapplyVO[]
	 */
	public PrepaymentApplyUnapplyVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PrepaymentApplyUnapplyVO[]
	 */
	public PrepaymentApplyUnapplyVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PrepaymentApplyUnapplyVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] prepaymentInvSeq =	(JSPUtil.getParameter(request, prefix +	"prepayment_inv_seq".trim(),	length));
				String[] unapplyAmount =	(JSPUtil.getParameter(request, prefix +	"unapply_amount".trim(),	length));
				String[] unapplyGlDate =	(JSPUtil.getParameter(request, prefix +	"unapply_gl_date".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] prepaymentLineNo =	(JSPUtil.getParameter(request, prefix +	"prepayment_line_no".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] applyGlDate =	(JSPUtil.getParameter(request, prefix +	"apply_gl_date".trim(),	length));
				String[] standardLineNo =	(JSPUtil.getParameter(request, prefix +	"standard_line_no".trim(),	length));
				String[] applyAmount =	(JSPUtil.getParameter(request, prefix +	"apply_amount".trim(),	length));
				String[] standardInvSeq =	(JSPUtil.getParameter(request, prefix +	"standard_inv_seq".trim(),	length));
				String[] currency =	(JSPUtil.getParameter(request, prefix +	"currency".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] functionalCurrency =	(JSPUtil.getParameter(request, prefix +	"functional_currency".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	PrepaymentApplyUnapplyVO();
						if ( prepaymentInvSeq[i] !=	null)
						model.setPrepaymentInvSeq( prepaymentInvSeq[i]);
						if ( unapplyAmount[i] !=	null)
						model.setUnapplyAmount( unapplyAmount[i]);
						if ( unapplyGlDate[i] !=	null)
						model.setUnapplyGlDate( unapplyGlDate[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( prepaymentLineNo[i] !=	null)
						model.setPrepaymentLineNo( prepaymentLineNo[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( applyGlDate[i] !=	null)
						model.setApplyGlDate( applyGlDate[i]);
						if ( standardLineNo[i] !=	null)
						model.setStandardLineNo( standardLineNo[i]);
						if ( applyAmount[i] !=	null)
						model.setApplyAmount( applyAmount[i]);
						if ( standardInvSeq[i] !=	null)
						model.setStandardInvSeq( standardInvSeq[i]);
						if ( currency[i] !=	null)
						model.setCurrency( currency[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( functionalCurrency[i] !=	null)
						model.setFunctionalCurrency( functionalCurrency[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getPrepaymentApplyUnapplyVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PrepaymentApplyUnapplyVO[]
	 */
	public PrepaymentApplyUnapplyVO[]	 getPrepaymentApplyUnapplyVOs(){
		PrepaymentApplyUnapplyVO[] vos = (PrepaymentApplyUnapplyVO[])models.toArray(new	PrepaymentApplyUnapplyVO[models.size()]);
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
		this.prepaymentInvSeq =	this.prepaymentInvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unapplyAmount =	this.unapplyAmount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unapplyGlDate =	this.unapplyGlDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prepaymentLineNo =	this.prepaymentLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applyGlDate =	this.applyGlDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.standardLineNo =	this.standardLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applyAmount =	this.applyAmount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.standardInvSeq =	this.standardInvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currency =	this.currency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.functionalCurrency =	this.functionalCurrency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}