/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OwnrAcctListVO.java
 *@FileTitle : OwnrAcctListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.04.25
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.04.25  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.fms.ownersaccount.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 愿��젴	Event�뿉�꽌	�옉�꽦,	�꽌踰꾩떎�뻾�슂泥��떆	PDTO�쓽 �뿭�븷�쓣 �닔�뻾�븯�뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class OwnrAcctListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<OwnrAcctListVO>  models =	new	ArrayList<OwnrAcctListVO>();


	/*	Column Info	*/
	private  String	 office   =  null;
	/*	Column Info	*/
	private  String	 csrNo   =  null;
	/*	Column Info	*/
	private  String	 ifErrDesc   =  null;
	/*	Column Info	*/
	private  String	 csrStatus   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 currency   =  null;
	/*	Column Info	*/
	private  String	 creationDt   =  null;
	/*	Column Info	*/
	private  String	 amount   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 description   =  null;
	/*	Column Info	*/
	private  String	 userId   =  null;
	/*	Column Info	*/
	private  String	 seq   =  null;
	/*	Column Info	*/
	private  String	 userName   =  null;
	/*	Column Info	*/
	private  String	 internalMeno   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 supplier   =  null;
	/*	Column Info	*/
	private  String	 vatCsrNo   =  null;
	/*	Column Info	*/
	private  String	 asaNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public OwnrAcctListVO(){}

	public OwnrAcctListVO(String office,String csrNo,String ifErrDesc,String csrStatus,String pagerows,String currency,String creationDt,String amount,String ibflag,String vndrSeq,String description,String userId,String seq,String userName,String internalMeno,String updUsrId,String supplier,String vatCsrNo,String asaNo)	{
		this.office  = office ;
		this.csrNo  = csrNo ;
		this.ifErrDesc  = ifErrDesc ;
		this.csrStatus  = csrStatus ;
		this.pagerows  = pagerows ;
		this.currency  = currency ;
		this.creationDt  = creationDt ;
		this.amount  = amount ;
		this.ibflag  = ibflag ;
		this.vndrSeq  = vndrSeq ;
		this.description  = description ;
		this.userId  = userId ;
		this.seq  = seq ;
		this.userName  = userName ;
		this.internalMeno  = internalMeno ;
		this.updUsrId  = updUsrId ;
		this.supplier  = supplier ;
		this.vatCsrNo  = vatCsrNo ;
		this.asaNo  = asaNo ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());		
		this.hashColumns.put("csr_no", getCsrNo());		
		this.hashColumns.put("if_err_desc", getIfErrDesc());		
		this.hashColumns.put("csr_status", getCsrStatus());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("currency", getCurrency());		
		this.hashColumns.put("creation_dt", getCreationDt());		
		this.hashColumns.put("amount", getAmount());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("description", getDescription());		
		this.hashColumns.put("user_id", getUserId());		
		this.hashColumns.put("seq", getSeq());		
		this.hashColumns.put("user_name", getUserName());		
		this.hashColumns.put("internal_meno", getInternalMeno());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("supplier", getSupplier());		
		this.hashColumns.put("vat_csr_no", getVatCsrNo());		
		this.hashColumns.put("asa_no", getAsaNo());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("if_err_desc", "ifErrDesc");
		this.hashFields.put("csr_status", "csrStatus");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("currency", "currency");
		this.hashFields.put("creation_dt", "creationDt");
		this.hashFields.put("amount", "amount");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("description", "description");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("user_name", "userName");
		this.hashFields.put("internal_meno", "internalMeno");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("supplier", "supplier");
		this.hashFields.put("vat_csr_no", "vatCsrNo");
		this.hashFields.put("asa_no", "asaNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  office
	*/
	public void	setOffice( String	office ) {
		this.office =	office;
	}
 
	/**
	 * Column Info
	 * @return	office
	 */
	 public	 String	getOffice() {
		 return	this.office;
	 } 
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
	 public	 String	getCsrNo() {
		 return	this.csrNo;
	 } 
 	/**
	* Column Info
	* @param  ifErrDesc
	*/
	public void	setIfErrDesc( String	ifErrDesc ) {
		this.ifErrDesc =	ifErrDesc;
	}
 
	/**
	 * Column Info
	 * @return	ifErrDesc
	 */
	 public	 String	getIfErrDesc() {
		 return	this.ifErrDesc;
	 } 
 	/**
	* Column Info
	* @param  csrStatus
	*/
	public void	setCsrStatus( String	csrStatus ) {
		this.csrStatus =	csrStatus;
	}
 
	/**
	 * Column Info
	 * @return	csrStatus
	 */
	 public	 String	getCsrStatus() {
		 return	this.csrStatus;
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
	* @param  currency
	*/
	public void	setCurrency( String	currency ) {
		this.currency =	currency;
	}
 
	/**
	 * Column Info
	 * @return	currency
	 */
	 public	 String	getCurrency() {
		 return	this.currency;
	 } 
 	/**
	* Column Info
	* @param  creationDt
	*/
	public void	setCreationDt( String	creationDt ) {
		this.creationDt =	creationDt;
	}
 
	/**
	 * Column Info
	 * @return	creationDt
	 */
	 public	 String	getCreationDt() {
		 return	this.creationDt;
	 } 
 	/**
	* Column Info
	* @param  amount
	*/
	public void	setAmount( String	amount ) {
		this.amount =	amount;
	}
 
	/**
	 * Column Info
	 * @return	amount
	 */
	 public	 String	getAmount() {
		 return	this.amount;
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
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  description
	*/
	public void	setDescription( String	description ) {
		this.description =	description;
	}
 
	/**
	 * Column Info
	 * @return	description
	 */
	 public	 String	getDescription() {
		 return	this.description;
	 } 
 	/**
	* Column Info
	* @param  userId
	*/
	public void	setUserId( String	userId ) {
		this.userId =	userId;
	}
 
	/**
	 * Column Info
	 * @return	userId
	 */
	 public	 String	getUserId() {
		 return	this.userId;
	 } 
 	/**
	* Column Info
	* @param  seq
	*/
	public void	setSeq( String	seq ) {
		this.seq =	seq;
	}
 
	/**
	 * Column Info
	 * @return	seq
	 */
	 public	 String	getSeq() {
		 return	this.seq;
	 } 
 	/**
	* Column Info
	* @param  userName
	*/
	public void	setUserName( String	userName ) {
		this.userName =	userName;
	}
 
	/**
	 * Column Info
	 * @return	userName
	 */
	 public	 String	getUserName() {
		 return	this.userName;
	 } 
 	/**
	* Column Info
	* @param  internalMeno
	*/
	public void	setInternalMeno( String	internalMeno ) {
		this.internalMeno =	internalMeno;
	}
 
	/**
	 * Column Info
	 * @return	internalMeno
	 */
	 public	 String	getInternalMeno() {
		 return	this.internalMeno;
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
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  supplier
	*/
	public void	setSupplier( String	supplier ) {
		this.supplier =	supplier;
	}
 
	/**
	 * Column Info
	 * @return	supplier
	 */
	 public	 String	getSupplier() {
		 return	this.supplier;
	 } 
 	/**
	* Column Info
	* @param  vatCsrNo
	*/
	public void	setVatCsrNo( String	vatCsrNo ) {
		this.vatCsrNo =	vatCsrNo;
	}
 
	/**
	 * Column Info
	 * @return	vatCsrNo
	 */
	 public	 String	getVatCsrNo() {
		 return	this.vatCsrNo;
	 } 
 	/**
	* Column Info
	* @param  asaNo
	*/
	public void	setAsaNo( String	asaNo ) {
		this.asaNo =	asaNo;
	}
 
	/**
	 * Column Info
	 * @return	asaNo
	 */
	 public	 String	getAsaNo() {
		 return	this.asaNo;
	 } 

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setOffice(JSPUtil.getParameter(request,	prefix + "office", ""));
		setCsrNo(JSPUtil.getParameter(request,	prefix + "csr_no", ""));
		setIfErrDesc(JSPUtil.getParameter(request,	prefix + "if_err_desc", ""));
		setCsrStatus(JSPUtil.getParameter(request,	prefix + "csr_status", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCurrency(JSPUtil.getParameter(request,	prefix + "currency", ""));
		setCreationDt(JSPUtil.getParameter(request,	prefix + "creation_dt", ""));
		setAmount(JSPUtil.getParameter(request,	prefix + "amount", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setDescription(JSPUtil.getParameter(request,	prefix + "description", ""));
		setUserId(JSPUtil.getParameter(request,	prefix + "user_id", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setUserName(JSPUtil.getParameter(request,	prefix + "user_name", ""));
		setInternalMeno(JSPUtil.getParameter(request,	prefix + "internal_meno", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setSupplier(JSPUtil.getParameter(request,	prefix + "supplier", ""));
		setVatCsrNo(JSPUtil.getParameter(request,	prefix + "vat_csr_no", ""));
		setAsaNo(JSPUtil.getParameter(request,	prefix + "asa_no", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return OwnrAcctListVO[]
	 */
	public OwnrAcctListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return OwnrAcctListVO[]
	 */
	public OwnrAcctListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		OwnrAcctListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] office =	(JSPUtil.getParameter(request, prefix +	"office".trim(),	length));
				String[] csrNo =	(JSPUtil.getParameter(request, prefix +	"csr_no".trim(),	length));
				String[] ifErrDesc =	(JSPUtil.getParameter(request, prefix +	"if_err_desc".trim(),	length));
				String[] csrStatus =	(JSPUtil.getParameter(request, prefix +	"csr_status".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] currency =	(JSPUtil.getParameter(request, prefix +	"currency".trim(),	length));
				String[] creationDt =	(JSPUtil.getParameter(request, prefix +	"creation_dt".trim(),	length));
				String[] amount =	(JSPUtil.getParameter(request, prefix +	"amount".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] description =	(JSPUtil.getParameter(request, prefix +	"description".trim(),	length));
				String[] userId =	(JSPUtil.getParameter(request, prefix +	"user_id".trim(),	length));
				String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq".trim(),	length));
				String[] userName =	(JSPUtil.getParameter(request, prefix +	"user_name".trim(),	length));
				String[] internalMeno =	(JSPUtil.getParameter(request, prefix +	"internal_meno".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] supplier =	(JSPUtil.getParameter(request, prefix +	"supplier".trim(),	length));
				String[] vatCsrNo =	(JSPUtil.getParameter(request, prefix +	"vat_csr_no".trim(),	length));
				String[] asaNo =	(JSPUtil.getParameter(request, prefix +	"asa_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	OwnrAcctListVO();
						if ( office[i] !=	null)
						model.setOffice( office[i]);
						if ( csrNo[i] !=	null)
						model.setCsrNo( csrNo[i]);
						if ( ifErrDesc[i] !=	null)
						model.setIfErrDesc( ifErrDesc[i]);
						if ( csrStatus[i] !=	null)
						model.setCsrStatus( csrStatus[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( currency[i] !=	null)
						model.setCurrency( currency[i]);
						if ( creationDt[i] !=	null)
						model.setCreationDt( creationDt[i]);
						if ( amount[i] !=	null)
						model.setAmount( amount[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( description[i] !=	null)
						model.setDescription( description[i]);
						if ( userId[i] !=	null)
						model.setUserId( userId[i]);
						if ( seq[i] !=	null)
						model.setSeq( seq[i]);
						if ( userName[i] !=	null)
						model.setUserName( userName[i]);
						if ( internalMeno[i] !=	null)
						model.setInternalMeno( internalMeno[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( supplier[i] !=	null)
						model.setSupplier( supplier[i]);
						if ( vatCsrNo[i] !=	null)
						model.setVatCsrNo( vatCsrNo[i]);
						if ( asaNo[i] !=	null)
						model.setAsaNo( asaNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getOwnrAcctListVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return OwnrAcctListVO[]
	 */
	public OwnrAcctListVO[]	 getOwnrAcctListVOs(){
		OwnrAcctListVO[] vos = (OwnrAcctListVO[])models.toArray(new	OwnrAcctListVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class�쓽 �궡�슜�쓣 String�쑝濡� 蹂��솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �룷留룻똿�맂 臾몄옄�뿴�뿉�꽌 �듅�닔臾몄옄 �젣嫄�("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.office =	this.office.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo =	this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifErrDesc =	this.ifErrDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrStatus =	this.csrStatus.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currency =	this.currency.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creationDt =	this.creationDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amount =	this.amount.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.description =	this.description.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId =	this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userName =	this.userName.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.internalMeno =	this.internalMeno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.supplier =	this.supplier.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatCsrNo =	this.vatCsrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo =	this.asaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}