/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceCustomerChangeChargeVO.java
 *@FileTitle : InvoiceCustomerChangeChargeVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.06
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.03.06  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
public class InvoiceCustomerChangeChargeVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceCustomerChangeChargeVO>  models =	new	ArrayList<InvoiceCustomerChangeChargeVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 perTpCd   =  null;
	/*	Column Info	*/
	private  String	 invTtlLoclAmt   =  null;
	/*	Column Info	*/
	private  String	 chgAmt   =  null;
	/*	Column Info	*/
	private  String	 trfRtAmt   =  null;
	/*	Column Info	*/
	private  String	 chgSeq   =  null;
	/*	Column Info	*/
	private  String	 ratAsCntrQty   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 chgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 loclAmt   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKntLocal   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceCustomerChangeChargeVO(){}

	public InvoiceCustomerChangeChargeVO(String ibflag,String currCd,String perTpCd,String invTtlLoclAmt,String chgAmt,String trfRtAmt,String chgSeq,String ratAsCntrQty,String invXchRt,String chgCd,String pagerows,String loclAmt,String dpPrcsKntLocal)	{
		this.ibflag  = ibflag ;
		this.currCd  = currCd ;
		this.perTpCd  = perTpCd ;
		this.invTtlLoclAmt  = invTtlLoclAmt ;
		this.chgAmt  = chgAmt ;
		this.trfRtAmt  = trfRtAmt ;
		this.chgSeq  = chgSeq ;
		this.ratAsCntrQty  = ratAsCntrQty ;
		this.invXchRt  = invXchRt ;
		this.chgCd  = chgCd ;
		this.pagerows  = pagerows ;
		this.loclAmt  = loclAmt ;
		this.dpPrcsKntLocal  = dpPrcsKntLocal ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("per_tp_cd", getPerTpCd());		
		this.hashColumns.put("inv_ttl_locl_amt", getInvTtlLoclAmt());		
		this.hashColumns.put("chg_amt", getChgAmt());		
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());		
		this.hashColumns.put("chg_seq", getChgSeq());		
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("chg_cd", getChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("locl_amt", getLoclAmt());		
		this.hashColumns.put("dp_prcs_knt_local", getDpPrcsKntLocal());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("inv_ttl_locl_amt", "invTtlLoclAmt");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("locl_amt", "loclAmt");
		this.hashFields.put("dp_prcs_knt_local", "dpPrcsKntLocal");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  currCd
	*/
	public void	setCurrCd( String	currCd ) {
		this.currCd =	currCd;
	}
 
	/**
	 * Column Info
	 * @return	currCd
	 */
	 public	 String	getCurrCd() {
		 return	this.currCd;
	 } 
 	/**
	* Column Info
	* @param  perTpCd
	*/
	public void	setPerTpCd( String	perTpCd ) {
		this.perTpCd =	perTpCd;
	}
 
	/**
	 * Column Info
	 * @return	perTpCd
	 */
	 public	 String	getPerTpCd() {
		 return	this.perTpCd;
	 } 
 	/**
	* Column Info
	* @param  invTtlLoclAmt
	*/
	public void	setInvTtlLoclAmt( String	invTtlLoclAmt ) {
		this.invTtlLoclAmt =	invTtlLoclAmt;
	}
 
	/**
	 * Column Info
	 * @return	invTtlLoclAmt
	 */
	 public	 String	getInvTtlLoclAmt() {
		 return	this.invTtlLoclAmt;
	 } 
 	/**
	* Column Info
	* @param  chgAmt
	*/
	public void	setChgAmt( String	chgAmt ) {
		this.chgAmt =	chgAmt;
	}
 
	/**
	 * Column Info
	 * @return	chgAmt
	 */
	 public	 String	getChgAmt() {
		 return	this.chgAmt;
	 } 
 	/**
	* Column Info
	* @param  trfRtAmt
	*/
	public void	setTrfRtAmt( String	trfRtAmt ) {
		this.trfRtAmt =	trfRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	trfRtAmt
	 */
	 public	 String	getTrfRtAmt() {
		 return	this.trfRtAmt;
	 } 
 	/**
	* Column Info
	* @param  chgSeq
	*/
	public void	setChgSeq( String	chgSeq ) {
		this.chgSeq =	chgSeq;
	}
 
	/**
	 * Column Info
	 * @return	chgSeq
	 */
	 public	 String	getChgSeq() {
		 return	this.chgSeq;
	 } 
 	/**
	* Column Info
	* @param  ratAsCntrQty
	*/
	public void	setRatAsCntrQty( String	ratAsCntrQty ) {
		this.ratAsCntrQty =	ratAsCntrQty;
	}
 
	/**
	 * Column Info
	 * @return	ratAsCntrQty
	 */
	 public	 String	getRatAsCntrQty() {
		 return	this.ratAsCntrQty;
	 } 
 	/**
	* Column Info
	* @param  invXchRt
	*/
	public void	setInvXchRt( String	invXchRt ) {
		this.invXchRt =	invXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invXchRt
	 */
	 public	 String	getInvXchRt() {
		 return	this.invXchRt;
	 } 
 	/**
	* Column Info
	* @param  chgCd
	*/
	public void	setChgCd( String	chgCd ) {
		this.chgCd =	chgCd;
	}
 
	/**
	 * Column Info
	 * @return	chgCd
	 */
	 public	 String	getChgCd() {
		 return	this.chgCd;
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
	* @param  loclAmt
	*/
	public void	setLoclAmt( String	loclAmt ) {
		this.loclAmt =	loclAmt;
	}
 
	/**
	 * Column Info
	 * @return	loclAmt
	 */
	 public	 String	getLoclAmt() {
		 return	this.loclAmt;
	 } 
 	/**
	* Column Info
	* @param  dpPrcsKntLocal
	*/
	public void	setDpPrcsKntLocal( String	dpPrcsKntLocal ) {
		this.dpPrcsKntLocal =	dpPrcsKntLocal;
	}
 
	/**
	 * Column Info
	 * @return	dpPrcsKntLocal
	 */
	 public	 String	getDpPrcsKntLocal() {
		 return	this.dpPrcsKntLocal;
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
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setPerTpCd(JSPUtil.getParameter(request,	prefix + "per_tp_cd", ""));
		setInvTtlLoclAmt(JSPUtil.getParameter(request,	prefix + "inv_ttl_locl_amt", ""));
		setChgAmt(JSPUtil.getParameter(request,	prefix + "chg_amt", ""));
		setTrfRtAmt(JSPUtil.getParameter(request,	prefix + "trf_rt_amt", ""));
		setChgSeq(JSPUtil.getParameter(request,	prefix + "chg_seq", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request,	prefix + "rat_as_cntr_qty", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setLoclAmt(JSPUtil.getParameter(request,	prefix + "locl_amt", ""));
		setDpPrcsKntLocal(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt_local", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceCustomerChangeChargeVO[]
	 */
	public InvoiceCustomerChangeChargeVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceCustomerChangeChargeVO[]
	 */
	public InvoiceCustomerChangeChargeVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceCustomerChangeChargeVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] perTpCd =	(JSPUtil.getParameter(request, prefix +	"per_tp_cd".trim(),	length));
				String[] invTtlLoclAmt =	(JSPUtil.getParameter(request, prefix +	"inv_ttl_locl_amt".trim(),	length));
				String[] chgAmt =	(JSPUtil.getParameter(request, prefix +	"chg_amt".trim(),	length));
				String[] trfRtAmt =	(JSPUtil.getParameter(request, prefix +	"trf_rt_amt".trim(),	length));
				String[] chgSeq =	(JSPUtil.getParameter(request, prefix +	"chg_seq".trim(),	length));
				String[] ratAsCntrQty =	(JSPUtil.getParameter(request, prefix +	"rat_as_cntr_qty".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] loclAmt =	(JSPUtil.getParameter(request, prefix +	"locl_amt".trim(),	length));
				String[] dpPrcsKntLocal =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt_local".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceCustomerChangeChargeVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( perTpCd[i] !=	null)
						model.setPerTpCd( perTpCd[i]);
						if ( invTtlLoclAmt[i] !=	null)
						model.setInvTtlLoclAmt( invTtlLoclAmt[i]);
						if ( chgAmt[i] !=	null)
						model.setChgAmt( chgAmt[i]);
						if ( trfRtAmt[i] !=	null)
						model.setTrfRtAmt( trfRtAmt[i]);
						if ( chgSeq[i] !=	null)
						model.setChgSeq( chgSeq[i]);
						if ( ratAsCntrQty[i] !=	null)
						model.setRatAsCntrQty( ratAsCntrQty[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( chgCd[i] !=	null)
						model.setChgCd( chgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( loclAmt[i] !=	null)
						model.setLoclAmt( loclAmt[i]);
						if ( dpPrcsKntLocal[i] !=	null)
						model.setDpPrcsKntLocal( dpPrcsKntLocal[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceCustomerChangeChargeVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceCustomerChangeChargeVO[]
	 */
	public InvoiceCustomerChangeChargeVO[]	 getInvoiceCustomerChangeChargeVOs(){
		InvoiceCustomerChangeChargeVO[] vos = (InvoiceCustomerChangeChargeVO[])models.toArray(new	InvoiceCustomerChangeChargeVO[models.size()]);
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
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd =	this.perTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTtlLoclAmt =	this.invTtlLoclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt =	this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt =	this.trfRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq =	this.chgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty =	this.ratAsCntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclAmt =	this.loclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKntLocal =	this.dpPrcsKntLocal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}