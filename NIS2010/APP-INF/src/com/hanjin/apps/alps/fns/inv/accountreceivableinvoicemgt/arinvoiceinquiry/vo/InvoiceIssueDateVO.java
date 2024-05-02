/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceIssueDateVO.java
 *@FileTitle : InvoiceIssueDateVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.09.11
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.09.11  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class InvoiceIssueDateVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceIssueDateVO>  models =	new	ArrayList<InvoiceIssueDateVO>();


	/*	Column Info	*/
	private  String	 office   =  null;
	/*	Column Info	*/
	private  String	 port   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 scope   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invClrFlg   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 revType   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 issOfcCd   =  null;
	/*	Column Info	*/
	private  String	 issToDt   =  null;
	/*	Column Info	*/
	private  String	 issFmDt   =  null;
	/*	Column Info	*/
	private  String	 bound   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 invType   =  null;
	/*	Column Info	*/
	private  String	 actInvNo   =  null;
	/*	Column Info	*/
	private  String	 svrId   =  null;
	/*	Column Info	*/
	private  String	 userOfcCd   =  null;
	/*	Column Info	*/
	private  String	 taxInvFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceIssueDateVO(){}

	public InvoiceIssueDateVO(String office,String port,String blSrcNo,String scope,String custNm,String custSeq,String pagerows,String invClrFlg,String invNo,String vvd,String ibflag,String revType,String usrId,String issOfcCd,String issToDt,String issFmDt,String bound,String custCntCd,String invType,String actInvNo,String svrId,String userOfcCd,String taxInvFlg)	{
		this.office  = office ;
		this.port  = port ;
		this.blSrcNo  = blSrcNo ;
		this.scope  = scope ;
		this.custNm  = custNm ;
		this.custSeq  = custSeq ;
		this.pagerows  = pagerows ;
		this.invClrFlg  = invClrFlg ;
		this.invNo  = invNo ;
		this.vvd  = vvd ;
		this.ibflag  = ibflag ;
		this.revType  = revType ;
		this.usrId  = usrId ;
		this.issOfcCd  = issOfcCd ;
		this.issToDt  = issToDt ;
		this.issFmDt  = issFmDt ;
		this.bound  = bound ;
		this.custCntCd  = custCntCd ;
		this.invType  = invType ;
		this.actInvNo  = actInvNo ;
		this.svrId  = svrId ;
		this.userOfcCd  = userOfcCd ;
		this.taxInvFlg  = taxInvFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("office", getOffice());		
		this.hashColumns.put("port", getPort());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("scope", getScope());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_clr_flg", getInvClrFlg());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("rev_type", getRevType());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());		
		this.hashColumns.put("iss_to_dt", getIssToDt());		
		this.hashColumns.put("iss_fm_dt", getIssFmDt());		
		this.hashColumns.put("bound", getBound());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("inv_type", getInvType());		
		this.hashColumns.put("act_inv_no", getActInvNo());		
		this.hashColumns.put("svr_id", getSvrId());		
		this.hashColumns.put("user_ofc_cd", getUserOfcCd());		
		this.hashColumns.put("tax_inv_flg", getTaxInvFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("office", "office");
		this.hashFields.put("port", "port");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("scope", "scope");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_clr_flg", "invClrFlg");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rev_type", "revType");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("iss_to_dt", "issToDt");
		this.hashFields.put("iss_fm_dt", "issFmDt");
		this.hashFields.put("bound", "bound");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("inv_type", "invType");
		this.hashFields.put("act_inv_no", "actInvNo");
		this.hashFields.put("svr_id", "svrId");
		this.hashFields.put("user_ofc_cd", "userOfcCd");
		this.hashFields.put("tax_inv_flg", "taxInvFlg");
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
	* @param  port
	*/
	public void	setPort( String	port ) {
		this.port =	port;
	}
 
	/**
	 * Column Info
	 * @return	port
	 */
	 public	 String	getPort() {
		 return	this.port;
	 } 
 	/**
	* Column Info
	* @param  blSrcNo
	*/
	public void	setBlSrcNo( String	blSrcNo ) {
		this.blSrcNo =	blSrcNo;
	}
 
	/**
	 * Column Info
	 * @return	blSrcNo
	 */
	 public	 String	getBlSrcNo() {
		 return	this.blSrcNo;
	 } 
 	/**
	* Column Info
	* @param  scope
	*/
	public void	setScope( String	scope ) {
		this.scope =	scope;
	}
 
	/**
	 * Column Info
	 * @return	scope
	 */
	 public	 String	getScope() {
		 return	this.scope;
	 } 
 	/**
	* Column Info
	* @param  custNm
	*/
	public void	setCustNm( String	custNm ) {
		this.custNm =	custNm;
	}
 
	/**
	 * Column Info
	 * @return	custNm
	 */
	 public	 String	getCustNm() {
		 return	this.custNm;
	 } 
 	/**
	* Column Info
	* @param  custSeq
	*/
	public void	setCustSeq( String	custSeq ) {
		this.custSeq =	custSeq;
	}
 
	/**
	 * Column Info
	 * @return	custSeq
	 */
	 public	 String	getCustSeq() {
		 return	this.custSeq;
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
	* @param  invClrFlg
	*/
	public void	setInvClrFlg( String	invClrFlg ) {
		this.invClrFlg =	invClrFlg;
	}
 
	/**
	 * Column Info
	 * @return	invClrFlg
	 */
	 public	 String	getInvClrFlg() {
		 return	this.invClrFlg;
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
	* @param  vvd
	*/
	public void	setVvd( String	vvd ) {
		this.vvd =	vvd;
	}
 
	/**
	 * Column Info
	 * @return	vvd
	 */
	 public	 String	getVvd() {
		 return	this.vvd;
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
	* @param  revType
	*/
	public void	setRevType( String	revType ) {
		this.revType =	revType;
	}
 
	/**
	 * Column Info
	 * @return	revType
	 */
	 public	 String	getRevType() {
		 return	this.revType;
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
	* @param  issOfcCd
	*/
	public void	setIssOfcCd( String	issOfcCd ) {
		this.issOfcCd =	issOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	issOfcCd
	 */
	 public	 String	getIssOfcCd() {
		 return	this.issOfcCd;
	 } 
 	/**
	* Column Info
	* @param  issToDt
	*/
	public void	setIssToDt( String	issToDt ) {
		this.issToDt =	issToDt;
	}
 
	/**
	 * Column Info
	 * @return	issToDt
	 */
	 public	 String	getIssToDt() {
		 return	this.issToDt;
	 } 
 	/**
	* Column Info
	* @param  issFmDt
	*/
	public void	setIssFmDt( String	issFmDt ) {
		this.issFmDt =	issFmDt;
	}
 
	/**
	 * Column Info
	 * @return	issFmDt
	 */
	 public	 String	getIssFmDt() {
		 return	this.issFmDt;
	 } 
 	/**
	* Column Info
	* @param  bound
	*/
	public void	setBound( String	bound ) {
		this.bound =	bound;
	}
 
	/**
	 * Column Info
	 * @return	bound
	 */
	 public	 String	getBound() {
		 return	this.bound;
	 } 
 	/**
	* Column Info
	* @param  custCntCd
	*/
	public void	setCustCntCd( String	custCntCd ) {
		this.custCntCd =	custCntCd;
	}
 
	/**
	 * Column Info
	 * @return	custCntCd
	 */
	 public	 String	getCustCntCd() {
		 return	this.custCntCd;
	 } 
 	/**
	* Column Info
	* @param  invType
	*/
	public void	setInvType( String	invType ) {
		this.invType =	invType;
	}
 
	/**
	 * Column Info
	 * @return	invType
	 */
	 public	 String	getInvType() {
		 return	this.invType;
	 } 
 	/**
	* Column Info
	* @param  actInvNo
	*/
	public void	setActInvNo( String	actInvNo ) {
		this.actInvNo =	actInvNo;
	}
 
	/**
	 * Column Info
	 * @return	actInvNo
	 */
	 public	 String	getActInvNo() {
		 return	this.actInvNo;
	 } 
 	/**
	* Column Info
	* @param  svrId
	*/
	public void	setSvrId( String	svrId ) {
		this.svrId =	svrId;
	}
 
	/**
	 * Column Info
	 * @return	svrId
	 */
	 public	 String	getSvrId() {
		 return	this.svrId;
	 } 
 	/**
	* Column Info
	* @param  userOfcCd
	*/
	public void	setUserOfcCd( String	userOfcCd ) {
		this.userOfcCd =	userOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	userOfcCd
	 */
	 public	 String	getUserOfcCd() {
		 return	this.userOfcCd;
	 } 
 	/**
	* Column Info
	* @param  taxInvFlg
	*/
	public void	setTaxInvFlg( String	taxInvFlg ) {
		this.taxInvFlg =	taxInvFlg;
	}
 
	/**
	 * Column Info
	 * @return	taxInvFlg
	 */
	 public	 String	getTaxInvFlg() {
		 return	this.taxInvFlg;
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
		setOffice(JSPUtil.getParameter(request,	prefix + "office", ""));
		setPort(JSPUtil.getParameter(request,	prefix + "port", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setScope(JSPUtil.getParameter(request,	prefix + "scope", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvClrFlg(JSPUtil.getParameter(request,	prefix + "inv_clr_flg", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRevType(JSPUtil.getParameter(request,	prefix + "rev_type", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setIssOfcCd(JSPUtil.getParameter(request,	prefix + "iss_ofc_cd", ""));
		setIssToDt(JSPUtil.getParameter(request,	prefix + "iss_to_dt", ""));
		setIssFmDt(JSPUtil.getParameter(request,	prefix + "iss_fm_dt", ""));
		setBound(JSPUtil.getParameter(request,	prefix + "bound", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setInvType(JSPUtil.getParameter(request,	prefix + "inv_type", ""));
		setActInvNo(JSPUtil.getParameter(request,	prefix + "act_inv_no", ""));
		setSvrId(JSPUtil.getParameter(request,	prefix + "svr_id", ""));
		setUserOfcCd(JSPUtil.getParameter(request,	prefix + "user_ofc_cd", ""));
		setTaxInvFlg(JSPUtil.getParameter(request,	prefix + "tax_inv_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceIssueDateVO[]
	 */
	public InvoiceIssueDateVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceIssueDateVO[]
	 */
	public InvoiceIssueDateVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceIssueDateVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] office =	(JSPUtil.getParameter(request, prefix +	"office".trim(),	length));
				String[] port =	(JSPUtil.getParameter(request, prefix +	"port".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] scope =	(JSPUtil.getParameter(request, prefix +	"scope".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invClrFlg =	(JSPUtil.getParameter(request, prefix +	"inv_clr_flg".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] revType =	(JSPUtil.getParameter(request, prefix +	"rev_type".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] issOfcCd =	(JSPUtil.getParameter(request, prefix +	"iss_ofc_cd".trim(),	length));
				String[] issToDt =	(JSPUtil.getParameter(request, prefix +	"iss_to_dt".trim(),	length));
				String[] issFmDt =	(JSPUtil.getParameter(request, prefix +	"iss_fm_dt".trim(),	length));
				String[] bound =	(JSPUtil.getParameter(request, prefix +	"bound".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] invType =	(JSPUtil.getParameter(request, prefix +	"inv_type".trim(),	length));
				String[] actInvNo =	(JSPUtil.getParameter(request, prefix +	"act_inv_no".trim(),	length));
				String[] svrId =	(JSPUtil.getParameter(request, prefix +	"svr_id".trim(),	length));
				String[] userOfcCd =	(JSPUtil.getParameter(request, prefix +	"user_ofc_cd".trim(),	length));
				String[] taxInvFlg =	(JSPUtil.getParameter(request, prefix +	"tax_inv_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceIssueDateVO();
						if ( office[i] !=	null)
						model.setOffice( office[i]);
						if ( port[i] !=	null)
						model.setPort( port[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( scope[i] !=	null)
						model.setScope( scope[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invClrFlg[i] !=	null)
						model.setInvClrFlg( invClrFlg[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( revType[i] !=	null)
						model.setRevType( revType[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( issOfcCd[i] !=	null)
						model.setIssOfcCd( issOfcCd[i]);
						if ( issToDt[i] !=	null)
						model.setIssToDt( issToDt[i]);
						if ( issFmDt[i] !=	null)
						model.setIssFmDt( issFmDt[i]);
						if ( bound[i] !=	null)
						model.setBound( bound[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( invType[i] !=	null)
						model.setInvType( invType[i]);
						if ( actInvNo[i] !=	null)
						model.setActInvNo( actInvNo[i]);
						if ( svrId[i] !=	null)
						model.setSvrId( svrId[i]);
						if ( userOfcCd[i] !=	null)
						model.setUserOfcCd( userOfcCd[i]);
						if ( taxInvFlg[i] !=	null)
						model.setTaxInvFlg( taxInvFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceIssueDateVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceIssueDateVO[]
	 */
	public InvoiceIssueDateVO[]	 getInvoiceIssueDateVOs(){
		InvoiceIssueDateVO[] vos = (InvoiceIssueDateVO[])models.toArray(new	InvoiceIssueDateVO[models.size()]);
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
		this.office =	this.office.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.port =	this.port.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scope =	this.scope.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invClrFlg =	this.invClrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revType =	this.revType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd =	this.issOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issToDt =	this.issToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issFmDt =	this.issFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound =	this.bound.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invType =	this.invType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvNo =	this.actInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svrId =	this.svrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userOfcCd =	this.userOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taxInvFlg =	this.taxInvFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}