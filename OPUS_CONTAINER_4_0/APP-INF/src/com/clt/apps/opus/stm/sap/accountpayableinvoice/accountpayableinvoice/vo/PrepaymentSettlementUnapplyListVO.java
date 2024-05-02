/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PrepaymentSettlementUnapplyListVO.java
 *@FileTitle : PrepaymentSettlementUnapplyListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.06
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.10.06  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo;

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
public class PrepaymentSettlementUnapplyListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PrepaymentSettlementUnapplyListVO>  models =	new	ArrayList<PrepaymentSettlementUnapplyListVO>();


	/*	Column Info	*/
	private  String	 taxAmountApplied   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 rowId   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 dtrbLineNo   =  null;
	/*	Column Info	*/
	private  String	 acctgDt   =  null;
	/*	Column Info	*/
	private  String	 prepayId   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ppayLineNo   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 unapplyAmount   =  null;
	/*	Column Info	*/
	private  String	 unapply   =  null;
	/*	Column Info	*/
	private  String	 unapplyGlDate   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 ppayInvSeq   =  null;
	/*	Column Info	*/
	private  String	 dtrbDesc   =  null;
	/*	Column Info	*/
	private  String	 prepayAmountApplied   =  null;
	/*	Column Info	*/
	private  String	 effYrmon   =  null;
	/*	Column Info	*/
	private  String	 ifFlag   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public PrepaymentSettlementUnapplyListVO(){}

	public PrepaymentSettlementUnapplyListVO(String taxAmountApplied,String vndrLglEngNm,String rowId,String invSeq,String dtrbLineNo,String acctgDt,String prepayId,String pagerows,String ppayLineNo,String invNo,String unapplyAmount,String unapply,String unapplyGlDate,String vndrNo,String ibflag,String ppayInvSeq,String dtrbDesc,String prepayAmountApplied,String effYrmon,String ifFlag)	{
		this.taxAmountApplied  = taxAmountApplied ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.rowId  = rowId ;
		this.invSeq  = invSeq ;
		this.dtrbLineNo  = dtrbLineNo ;
		this.acctgDt  = acctgDt ;
		this.prepayId  = prepayId ;
		this.pagerows  = pagerows ;
		this.ppayLineNo  = ppayLineNo ;
		this.invNo  = invNo ;
		this.unapplyAmount  = unapplyAmount ;
		this.unapply  = unapply ;
		this.unapplyGlDate  = unapplyGlDate ;
		this.vndrNo  = vndrNo ;
		this.ibflag  = ibflag ;
		this.ppayInvSeq  = ppayInvSeq ;
		this.dtrbDesc  = dtrbDesc ;
		this.prepayAmountApplied  = prepayAmountApplied ;
		this.effYrmon  = effYrmon ;
		this.ifFlag  = ifFlag ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tax_amount_applied", getTaxAmountApplied());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("row_id", getRowId());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("dtrb_line_no", getDtrbLineNo());		
		this.hashColumns.put("acctg_dt", getAcctgDt());		
		this.hashColumns.put("prepay_id", getPrepayId());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ppay_line_no", getPpayLineNo());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("unapply_amount", getUnapplyAmount());		
		this.hashColumns.put("unapply", getUnapply());		
		this.hashColumns.put("unapply_gl_date", getUnapplyGlDate());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ppay_inv_seq", getPpayInvSeq());		
		this.hashColumns.put("dtrb_desc", getDtrbDesc());		
		this.hashColumns.put("prepay_amount_applied", getPrepayAmountApplied());		
		this.hashColumns.put("eff_yrmon", getEffYrmon());		
		this.hashColumns.put("if_flag", getIfFlag());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("tax_amount_applied", "taxAmountApplied");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("row_id", "rowId");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("dtrb_line_no", "dtrbLineNo");
		this.hashFields.put("acctg_dt", "acctgDt");
		this.hashFields.put("prepay_id", "prepayId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ppay_line_no", "ppayLineNo");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("unapply_amount", "unapplyAmount");
		this.hashFields.put("unapply", "unapply");
		this.hashFields.put("unapply_gl_date", "unapplyGlDate");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ppay_inv_seq", "ppayInvSeq");
		this.hashFields.put("dtrb_desc", "dtrbDesc");
		this.hashFields.put("prepay_amount_applied", "prepayAmountApplied");
		this.hashFields.put("eff_yrmon", "effYrmon");
		this.hashFields.put("if_flag", "ifFlag");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  taxAmountApplied
	*/
	public void	setTaxAmountApplied( String	taxAmountApplied ) {
		this.taxAmountApplied =	taxAmountApplied;
	}
 
	/**
	 * Column Info
	 * @return	taxAmountApplied
	 */
	 public	 String	getTaxAmountApplied() {
		 return	this.taxAmountApplied;
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
	 public	 String	getVndrLglEngNm() {
		 return	this.vndrLglEngNm;
	 } 
 	/**
	* Column Info
	* @param  rowId
	*/
	public void	setRowId( String	rowId ) {
		this.rowId =	rowId;
	}
 
	/**
	 * Column Info
	 * @return	rowId
	 */
	 public	 String	getRowId() {
		 return	this.rowId;
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
	 public	 String	getInvSeq() {
		 return	this.invSeq;
	 } 
 	/**
	* Column Info
	* @param  dtrbLineNo
	*/
	public void	setDtrbLineNo( String	dtrbLineNo ) {
		this.dtrbLineNo =	dtrbLineNo;
	}
 
	/**
	 * Column Info
	 * @return	dtrbLineNo
	 */
	 public	 String	getDtrbLineNo() {
		 return	this.dtrbLineNo;
	 } 
 	/**
	* Column Info
	* @param  acctgDt
	*/
	public void	setAcctgDt( String	acctgDt ) {
		this.acctgDt =	acctgDt;
	}
 
	/**
	 * Column Info
	 * @return	acctgDt
	 */
	 public	 String	getAcctgDt() {
		 return	this.acctgDt;
	 } 
 	/**
	* Column Info
	* @param  prepayId
	*/
	public void	setPrepayId( String	prepayId ) {
		this.prepayId =	prepayId;
	}
 
	/**
	 * Column Info
	 * @return	prepayId
	 */
	 public	 String	getPrepayId() {
		 return	this.prepayId;
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
	* @param  ppayLineNo
	*/
	public void	setPpayLineNo( String	ppayLineNo ) {
		this.ppayLineNo =	ppayLineNo;
	}
 
	/**
	 * Column Info
	 * @return	ppayLineNo
	 */
	 public	 String	getPpayLineNo() {
		 return	this.ppayLineNo;
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
	 public	 String	getInvNo() {
		 return	this.invNo;
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
	 public	 String	getUnapplyAmount() {
		 return	this.unapplyAmount;
	 } 
 	/**
	* Column Info
	* @param  unapply
	*/
	public void	setUnapply( String	unapply ) {
		this.unapply =	unapply;
	}
 
	/**
	 * Column Info
	 * @return	unapply
	 */
	 public	 String	getUnapply() {
		 return	this.unapply;
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
	 public	 String	getUnapplyGlDate() {
		 return	this.unapplyGlDate;
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
	* @param  ppayInvSeq
	*/
	public void	setPpayInvSeq( String	ppayInvSeq ) {
		this.ppayInvSeq =	ppayInvSeq;
	}
 
	/**
	 * Column Info
	 * @return	ppayInvSeq
	 */
	 public	 String	getPpayInvSeq() {
		 return	this.ppayInvSeq;
	 } 
 	/**
	* Column Info
	* @param  dtrbDesc
	*/
	public void	setDtrbDesc( String	dtrbDesc ) {
		this.dtrbDesc =	dtrbDesc;
	}
 
	/**
	 * Column Info
	 * @return	dtrbDesc
	 */
	 public	 String	getDtrbDesc() {
		 return	this.dtrbDesc;
	 } 
 	/**
	* Column Info
	* @param  prepayAmountApplied
	*/
	public void	setPrepayAmountApplied( String	prepayAmountApplied ) {
		this.prepayAmountApplied =	prepayAmountApplied;
	}
 
	/**
	 * Column Info
	 * @return	prepayAmountApplied
	 */
	 public	 String	getPrepayAmountApplied() {
		 return	this.prepayAmountApplied;
	 } 
 	/**
	* Column Info
	* @param  effYrmon
	*/
	public void	setEffYrmon( String	effYrmon ) {
		this.effYrmon =	effYrmon;
	}
 
	/**
	 * Column Info
	 * @return	effYrmon
	 */
	 public	 String	getEffYrmon() {
		 return	this.effYrmon;
	 } 
 	/**
	* Column Info
	* @param  ifFlag
	*/
	public void	setIfFlag( String	ifFlag ) {
		this.ifFlag =	ifFlag;
	}
 
	/**
	 * Column Info
	 * @return	ifFlag
	 */
	 public	 String	getIfFlag() {
		 return	this.ifFlag;
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
		setTaxAmountApplied(JSPUtil.getParameter(request,	prefix + "tax_amount_applied", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setRowId(JSPUtil.getParameter(request,	prefix + "row_id", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setDtrbLineNo(JSPUtil.getParameter(request,	prefix + "dtrb_line_no", ""));
		setAcctgDt(JSPUtil.getParameter(request,	prefix + "acctg_dt", ""));
		setPrepayId(JSPUtil.getParameter(request,	prefix + "prepay_id", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPpayLineNo(JSPUtil.getParameter(request,	prefix + "ppay_line_no", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setUnapplyAmount(JSPUtil.getParameter(request,	prefix + "unapply_amount", ""));
		setUnapply(JSPUtil.getParameter(request,	prefix + "unapply", ""));
		setUnapplyGlDate(JSPUtil.getParameter(request,	prefix + "unapply_gl_date", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPpayInvSeq(JSPUtil.getParameter(request,	prefix + "ppay_inv_seq", ""));
		setDtrbDesc(JSPUtil.getParameter(request,	prefix + "dtrb_desc", ""));
		setPrepayAmountApplied(JSPUtil.getParameter(request,	prefix + "prepay_amount_applied", ""));
		setEffYrmon(JSPUtil.getParameter(request,	prefix + "eff_yrmon", ""));
		setIfFlag(JSPUtil.getParameter(request,	prefix + "if_flag", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PrepaymentSettlementUnapplyListVO[]
	 */
	public PrepaymentSettlementUnapplyListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PrepaymentSettlementUnapplyListVO[]
	 */
	public PrepaymentSettlementUnapplyListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PrepaymentSettlementUnapplyListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] taxAmountApplied =	(JSPUtil.getParameter(request, prefix +	"tax_amount_applied".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] rowId =	(JSPUtil.getParameter(request, prefix +	"row_id".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] dtrbLineNo =	(JSPUtil.getParameter(request, prefix +	"dtrb_line_no".trim(),	length));
				String[] acctgDt =	(JSPUtil.getParameter(request, prefix +	"acctg_dt".trim(),	length));
				String[] prepayId =	(JSPUtil.getParameter(request, prefix +	"prepay_id".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ppayLineNo =	(JSPUtil.getParameter(request, prefix +	"ppay_line_no".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] unapplyAmount =	(JSPUtil.getParameter(request, prefix +	"unapply_amount".trim(),	length));
				String[] unapply =	(JSPUtil.getParameter(request, prefix +	"unapply".trim(),	length));
				String[] unapplyGlDate =	(JSPUtil.getParameter(request, prefix +	"unapply_gl_date".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] ppayInvSeq =	(JSPUtil.getParameter(request, prefix +	"ppay_inv_seq".trim(),	length));
				String[] dtrbDesc =	(JSPUtil.getParameter(request, prefix +	"dtrb_desc".trim(),	length));
				String[] prepayAmountApplied =	(JSPUtil.getParameter(request, prefix +	"prepay_amount_applied".trim(),	length));
				String[] effYrmon =	(JSPUtil.getParameter(request, prefix +	"eff_yrmon".trim(),	length));
				String[] ifFlag =	(JSPUtil.getParameter(request, prefix +	"if_flag".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	PrepaymentSettlementUnapplyListVO();
						if ( taxAmountApplied[i] !=	null)
						model.setTaxAmountApplied( taxAmountApplied[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( rowId[i] !=	null)
						model.setRowId( rowId[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( dtrbLineNo[i] !=	null)
						model.setDtrbLineNo( dtrbLineNo[i]);
						if ( acctgDt[i] !=	null)
						model.setAcctgDt( acctgDt[i]);
						if ( prepayId[i] !=	null)
						model.setPrepayId( prepayId[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ppayLineNo[i] !=	null)
						model.setPpayLineNo( ppayLineNo[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( unapplyAmount[i] !=	null)
						model.setUnapplyAmount( unapplyAmount[i]);
						if ( unapply[i] !=	null)
						model.setUnapply( unapply[i]);
						if ( unapplyGlDate[i] !=	null)
						model.setUnapplyGlDate( unapplyGlDate[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( ppayInvSeq[i] !=	null)
						model.setPpayInvSeq( ppayInvSeq[i]);
						if ( dtrbDesc[i] !=	null)
						model.setDtrbDesc( dtrbDesc[i]);
						if ( prepayAmountApplied[i] !=	null)
						model.setPrepayAmountApplied( prepayAmountApplied[i]);
						if ( effYrmon[i] !=	null)
						model.setEffYrmon( effYrmon[i]);
						if ( ifFlag[i] !=	null)
						model.setIfFlag( ifFlag[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getPrepaymentSettlementUnapplyListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PrepaymentSettlementUnapplyListVO[]
	 */
	public PrepaymentSettlementUnapplyListVO[]	 getPrepaymentSettlementUnapplyListVOs(){
		PrepaymentSettlementUnapplyListVO[] vos = (PrepaymentSettlementUnapplyListVO[])models.toArray(new	PrepaymentSettlementUnapplyListVO[models.size()]);
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
		this.taxAmountApplied =	this.taxAmountApplied.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowId =	this.rowId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbLineNo =	this.dtrbLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgDt =	this.acctgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prepayId =	this.prepayId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayLineNo =	this.ppayLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unapplyAmount =	this.unapplyAmount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unapply =	this.unapply.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unapplyGlDate =	this.unapplyGlDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppayInvSeq =	this.ppayInvSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbDesc =	this.dtrbDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prepayAmountApplied =	this.prepayAmountApplied.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effYrmon =	this.effYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifFlag =	this.ifFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}