/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvArSplitIssVO.java
 *@FileTitle : InvArSplitIssVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2018.05.16
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2018.05.16  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
public class InvArSplitIssVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvArSplitIssVO>  models =	new	ArrayList<InvArSplitIssVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 actCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 actCustSeq   =  null;
	/*	Column Info	*/
	private  String	 invRmk   =  null;
	/*	Column Info	*/
	private  String	 invRefNo   =  null;
	/*	Column Info	*/
	private  String	 hjsStfCtnt   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 invSplitIssWrkNo   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 bankAcctPrnOptCd   =  null;
	/*	Column Info	*/
	private  String	 dueDt   =  null;
	/*	Column Info	*/
	private  String	 idaIssTpCd   =  null;
	/*	Column Info	*/
	private  String	 idaIssOfcCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvArSplitIssVO(){}

	public InvArSplitIssVO(String ibflag,String pagerows,String invNo,String invSeq,String arOfcCd,String actCustCntCd,String actCustSeq,String invRmk,String invRefNo,String hjsStfCtnt,String blSrcNo,String bkgNo,String arIfNo,String invSplitIssWrkNo,String sailArrDt,String bankAcctPrnOptCd,String dueDt,String idaIssTpCd,String idaIssOfcCd)	{
		this.ibflag  = ibflag ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.invSeq  = invSeq ;
		this.arOfcCd  = arOfcCd ;
		this.actCustCntCd  = actCustCntCd ;
		this.actCustSeq  = actCustSeq ;
		this.invRmk  = invRmk ;
		this.invRefNo  = invRefNo ;
		this.hjsStfCtnt  = hjsStfCtnt ;
		this.blSrcNo  = blSrcNo ;
		this.bkgNo  = bkgNo ;
		this.arIfNo  = arIfNo ;
		this.invSplitIssWrkNo  = invSplitIssWrkNo ;
		this.sailArrDt  = sailArrDt ;
		this.bankAcctPrnOptCd  = bankAcctPrnOptCd ;
		this.dueDt  = dueDt ;
		this.idaIssTpCd  = idaIssTpCd ;
		this.idaIssOfcCd  = idaIssOfcCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());		
		this.hashColumns.put("act_cust_seq", getActCustSeq());		
		this.hashColumns.put("inv_rmk", getInvRmk());		
		this.hashColumns.put("inv_ref_no", getInvRefNo());		
		this.hashColumns.put("hjs_stf_ctnt", getHjsStfCtnt());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("inv_split_iss_wrk_no", getInvSplitIssWrkNo());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("bank_acct_prn_opt_cd", getBankAcctPrnOptCd());		
		this.hashColumns.put("due_dt", getDueDt());		
		this.hashColumns.put("ida_iss_tp_cd", getIdaIssTpCd());		
		this.hashColumns.put("ida_iss_ofc_cd", getIdaIssOfcCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("hjs_stf_ctnt", "hjsStfCtnt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("inv_split_iss_wrk_no", "invSplitIssWrkNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bank_acct_prn_opt_cd", "bankAcctPrnOptCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("ida_iss_tp_cd", "idaIssTpCd");
		this.hashFields.put("ida_iss_ofc_cd", "idaIssOfcCd");
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
	* @param  arOfcCd
	*/
	public void	setArOfcCd( String	arOfcCd ) {
		this.arOfcCd =	arOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	arOfcCd
	 */
	 public	 String	getArOfcCd() {
		 return	this.arOfcCd;
	 } 
 	/**
	* Column Info
	* @param  actCustCntCd
	*/
	public void	setActCustCntCd( String	actCustCntCd ) {
		this.actCustCntCd =	actCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	actCustCntCd
	 */
	 public	 String	getActCustCntCd() {
		 return	this.actCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  actCustSeq
	*/
	public void	setActCustSeq( String	actCustSeq ) {
		this.actCustSeq =	actCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	actCustSeq
	 */
	 public	 String	getActCustSeq() {
		 return	this.actCustSeq;
	 } 
 	/**
	* Column Info
	* @param  invRmk
	*/
	public void	setInvRmk( String	invRmk ) {
		this.invRmk =	invRmk;
	}
 
	/**
	 * Column Info
	 * @return	invRmk
	 */
	 public	 String	getInvRmk() {
		 return	this.invRmk;
	 } 
 	/**
	* Column Info
	* @param  invRefNo
	*/
	public void	setInvRefNo( String	invRefNo ) {
		this.invRefNo =	invRefNo;
	}
 
	/**
	 * Column Info
	 * @return	invRefNo
	 */
	 public	 String	getInvRefNo() {
		 return	this.invRefNo;
	 } 
 	/**
	* Column Info
	* @param  hjsStfCtnt
	*/
	public void	setHjsStfCtnt( String	hjsStfCtnt ) {
		this.hjsStfCtnt =	hjsStfCtnt;
	}
 
	/**
	 * Column Info
	 * @return	hjsStfCtnt
	 */
	 public	 String	getHjsStfCtnt() {
		 return	this.hjsStfCtnt;
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
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
	 } 
 	/**
	* Column Info
	* @param  arIfNo
	*/
	public void	setArIfNo( String	arIfNo ) {
		this.arIfNo =	arIfNo;
	}
 
	/**
	 * Column Info
	 * @return	arIfNo
	 */
	 public	 String	getArIfNo() {
		 return	this.arIfNo;
	 } 
 	/**
	* Column Info
	* @param  invSplitIssWrkNo
	*/
	public void	setInvSplitIssWrkNo( String	invSplitIssWrkNo ) {
		this.invSplitIssWrkNo =	invSplitIssWrkNo;
	}
 
	/**
	 * Column Info
	 * @return	invSplitIssWrkNo
	 */
	 public	 String	getInvSplitIssWrkNo() {
		 return	this.invSplitIssWrkNo;
	 } 
 	/**
	* Column Info
	* @param  sailArrDt
	*/
	public void	setSailArrDt( String	sailArrDt ) {
		this.sailArrDt =	sailArrDt;
	}
 
	/**
	 * Column Info
	 * @return	sailArrDt
	 */
	 public	 String	getSailArrDt() {
		 return	this.sailArrDt;
	 } 
 	/**
	* Column Info
	* @param  bankAcctPrnOptCd
	*/
	public void	setBankAcctPrnOptCd( String	bankAcctPrnOptCd ) {
		this.bankAcctPrnOptCd =	bankAcctPrnOptCd;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctPrnOptCd
	 */
	 public	 String	getBankAcctPrnOptCd() {
		 return	this.bankAcctPrnOptCd;
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
	 public	 String	getDueDt() {
		 return	this.dueDt;
	 } 
 	/**
	* Column Info
	* @param  idaIssTpCd
	*/
	public void	setIdaIssTpCd( String	idaIssTpCd ) {
		this.idaIssTpCd =	idaIssTpCd;
	}
 
	/**
	 * Column Info
	 * @return	idaIssTpCd
	 */
	 public	 String	getIdaIssTpCd() {
		 return	this.idaIssTpCd;
	 } 
 	/**
	* Column Info
	* @param  idaIssOfcCd
	*/
	public void	setIdaIssOfcCd( String	idaIssOfcCd ) {
		this.idaIssOfcCd =	idaIssOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	idaIssOfcCd
	 */
	 public	 String	getIdaIssOfcCd() {
		 return	this.idaIssOfcCd;
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
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setActCustCntCd(JSPUtil.getParameter(request,	prefix + "act_cust_cnt_cd", ""));
		setActCustSeq(JSPUtil.getParameter(request,	prefix + "act_cust_seq", ""));
		setInvRmk(JSPUtil.getParameter(request,	prefix + "inv_rmk", ""));
		setInvRefNo(JSPUtil.getParameter(request,	prefix + "inv_ref_no", ""));
		setHjsStfCtnt(JSPUtil.getParameter(request,	prefix + "hjs_stf_ctnt", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setInvSplitIssWrkNo(JSPUtil.getParameter(request,	prefix + "inv_split_iss_wrk_no", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setBankAcctPrnOptCd(JSPUtil.getParameter(request,	prefix + "bank_acct_prn_opt_cd", ""));
		setDueDt(JSPUtil.getParameter(request,	prefix + "due_dt", ""));
		setIdaIssTpCd(JSPUtil.getParameter(request,	prefix + "ida_iss_tp_cd", ""));
		setIdaIssOfcCd(JSPUtil.getParameter(request,	prefix + "ida_iss_ofc_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArSplitIssVO[]
	 */
	public InvArSplitIssVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvArSplitIssVO[]
	 */
	public InvArSplitIssVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvArSplitIssVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] actCustCntCd =	(JSPUtil.getParameter(request, prefix +	"act_cust_cnt_cd".trim(),	length));
				String[] actCustSeq =	(JSPUtil.getParameter(request, prefix +	"act_cust_seq".trim(),	length));
				String[] invRmk =	(JSPUtil.getParameter(request, prefix +	"inv_rmk".trim(),	length));
				String[] invRefNo =	(JSPUtil.getParameter(request, prefix +	"inv_ref_no".trim(),	length));
				String[] hjsStfCtnt =	(JSPUtil.getParameter(request, prefix +	"hjs_stf_ctnt".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] invSplitIssWrkNo =	(JSPUtil.getParameter(request, prefix +	"inv_split_iss_wrk_no".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] bankAcctPrnOptCd =	(JSPUtil.getParameter(request, prefix +	"bank_acct_prn_opt_cd".trim(),	length));
				String[] dueDt =	(JSPUtil.getParameter(request, prefix +	"due_dt".trim(),	length));
				String[] idaIssTpCd =	(JSPUtil.getParameter(request, prefix +	"ida_iss_tp_cd".trim(),	length));
				String[] idaIssOfcCd =	(JSPUtil.getParameter(request, prefix +	"ida_iss_ofc_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvArSplitIssVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( actCustCntCd[i] !=	null)
						model.setActCustCntCd( actCustCntCd[i]);
						if ( actCustSeq[i] !=	null)
						model.setActCustSeq( actCustSeq[i]);
						if ( invRmk[i] !=	null)
						model.setInvRmk( invRmk[i]);
						if ( invRefNo[i] !=	null)
						model.setInvRefNo( invRefNo[i]);
						if ( hjsStfCtnt[i] !=	null)
						model.setHjsStfCtnt( hjsStfCtnt[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( invSplitIssWrkNo[i] !=	null)
						model.setInvSplitIssWrkNo( invSplitIssWrkNo[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( bankAcctPrnOptCd[i] !=	null)
						model.setBankAcctPrnOptCd( bankAcctPrnOptCd[i]);
						if ( dueDt[i] !=	null)
						model.setDueDt( dueDt[i]);
						if ( idaIssTpCd[i] !=	null)
						model.setIdaIssTpCd( idaIssTpCd[i]);
						if ( idaIssOfcCd[i] !=	null)
						model.setIdaIssOfcCd( idaIssOfcCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvArSplitIssVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvArSplitIssVO[]
	 */
	public InvArSplitIssVO[]	 getInvArSplitIssVOs(){
		InvArSplitIssVO[] vos = (InvArSplitIssVO[])models.toArray(new	InvArSplitIssVO[models.size()]);
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
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd =	this.actCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq =	this.actCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk =	this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo =	this.invRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hjsStfCtnt =	this.hjsStfCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSplitIssWrkNo =	this.invSplitIssWrkNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctPrnOptCd =	this.bankAcctPrnOptCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt =	this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIssTpCd =	this.idaIssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIssOfcCd =	this.idaIssOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}