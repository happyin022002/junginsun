/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : HandlingCostVO.java
 *@FileTitle : HandlingCostVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.04
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.04  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.cps.cni.containercargoclaim.claimmain.vo;

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
public class HandlingCostVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<HandlingCostVO>  models =	new	ArrayList<HandlingCostVO>();


	/*	Column Info	*/
	private  String	 payDt   =  null;
	/*	Column Info	*/
	private  String	 invUsdAmt   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 costDesc   =  null;
	/*	Column Info	*/
	private  String	 apPayDt   =  null;
	/*	Column Info	*/
	private  String	 cgoClmPayNo   =  null;
	/*	Column Info	*/
	private  String	 clmCostTpCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 clmPtyNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 invRmk   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 cgoClmNo   =  null;
	/*	Column Info	*/
	private  String	 clmPtyAbbrNm   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 invRgstNo   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public HandlingCostVO(){}

	public HandlingCostVO(String payDt,String invUsdAmt,String loclCurrCd,String costDesc,String apPayDt,String cgoClmPayNo,String clmCostTpCd,String pagerows,String invNo,String clmPtyNo,String ibflag,String invRmk,String invAmt,String cgoClmNo,String clmPtyAbbrNm,String invXchRt,String invRgstNo,String invDt,String vndrSeq)	{
		this.payDt  = payDt ;
		this.invUsdAmt  = invUsdAmt ;
		this.loclCurrCd  = loclCurrCd ;
		this.costDesc  = costDesc ;
		this.apPayDt  = apPayDt ;
		this.cgoClmPayNo  = cgoClmPayNo ;
		this.clmCostTpCd  = clmCostTpCd ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.clmPtyNo  = clmPtyNo ;
		this.ibflag  = ibflag ;
		this.invRmk  = invRmk ;
		this.invAmt  = invAmt ;
		this.cgoClmNo  = cgoClmNo ;
		this.clmPtyAbbrNm  = clmPtyAbbrNm ;
		this.invXchRt  = invXchRt ;
		this.invRgstNo  = invRgstNo ;
		this.invDt  = invDt ;
		this.vndrSeq  = vndrSeq ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());		
		this.hashColumns.put("inv_usd_amt", getInvUsdAmt());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("cost_desc", getCostDesc());		
		this.hashColumns.put("ap_pay_dt", getApPayDt());		
		this.hashColumns.put("cgo_clm_pay_no", getCgoClmPayNo());		
		this.hashColumns.put("clm_cost_tp_cd", getClmCostTpCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("clm_pty_no", getClmPtyNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("inv_rmk", getInvRmk());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("cgo_clm_no", getCgoClmNo());		
		this.hashColumns.put("clm_pty_abbr_nm", getClmPtyAbbrNm());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("inv_rgst_no", getInvRgstNo());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("inv_usd_amt", "invUsdAmt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("cost_desc", "costDesc");
		this.hashFields.put("ap_pay_dt", "apPayDt");
		this.hashFields.put("cgo_clm_pay_no", "cgoClmPayNo");
		this.hashFields.put("clm_cost_tp_cd", "clmCostTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("clm_pty_no", "clmPtyNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("cgo_clm_no", "cgoClmNo");
		this.hashFields.put("clm_pty_abbr_nm", "clmPtyAbbrNm");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("inv_rgst_no", "invRgstNo");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  payDt
	*/
	public void	setPayDt( String	payDt ) {
		this.payDt =	payDt;
	}
 
	/**
	 * Column Info
	 * @return	payDt
	 */
	 public	 String	getPayDt() {
		 return	this.payDt;
	 } 
 	/**
	* Column Info
	* @param  invUsdAmt
	*/
	public void	setInvUsdAmt( String	invUsdAmt ) {
		this.invUsdAmt =	invUsdAmt;
	}
 
	/**
	 * Column Info
	 * @return	invUsdAmt
	 */
	 public	 String	getInvUsdAmt() {
		 return	this.invUsdAmt;
	 } 
 	/**
	* Column Info
	* @param  loclCurrCd
	*/
	public void	setLoclCurrCd( String	loclCurrCd ) {
		this.loclCurrCd =	loclCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	loclCurrCd
	 */
	 public	 String	getLoclCurrCd() {
		 return	this.loclCurrCd;
	 } 
 	/**
	* Column Info
	* @param  costDesc
	*/
	public void	setCostDesc( String	costDesc ) {
		this.costDesc =	costDesc;
	}
 
	/**
	 * Column Info
	 * @return	costDesc
	 */
	 public	 String	getCostDesc() {
		 return	this.costDesc;
	 } 
 	/**
	* Column Info
	* @param  apPayDt
	*/
	public void	setApPayDt( String	apPayDt ) {
		this.apPayDt =	apPayDt;
	}
 
	/**
	 * Column Info
	 * @return	apPayDt
	 */
	 public	 String	getApPayDt() {
		 return	this.apPayDt;
	 } 
 	/**
	* Column Info
	* @param  cgoClmPayNo
	*/
	public void	setCgoClmPayNo( String	cgoClmPayNo ) {
		this.cgoClmPayNo =	cgoClmPayNo;
	}
 
	/**
	 * Column Info
	 * @return	cgoClmPayNo
	 */
	 public	 String	getCgoClmPayNo() {
		 return	this.cgoClmPayNo;
	 } 
 	/**
	* Column Info
	* @param  clmCostTpCd
	*/
	public void	setClmCostTpCd( String	clmCostTpCd ) {
		this.clmCostTpCd =	clmCostTpCd;
	}
 
	/**
	 * Column Info
	 * @return	clmCostTpCd
	 */
	 public	 String	getClmCostTpCd() {
		 return	this.clmCostTpCd;
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
	* @param  clmPtyNo
	*/
	public void	setClmPtyNo( String	clmPtyNo ) {
		this.clmPtyNo =	clmPtyNo;
	}
 
	/**
	 * Column Info
	 * @return	clmPtyNo
	 */
	 public	 String	getClmPtyNo() {
		 return	this.clmPtyNo;
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
	* @param  invAmt
	*/
	public void	setInvAmt( String	invAmt ) {
		this.invAmt =	invAmt;
	}
 
	/**
	 * Column Info
	 * @return	invAmt
	 */
	 public	 String	getInvAmt() {
		 return	this.invAmt;
	 } 
 	/**
	* Column Info
	* @param  cgoClmNo
	*/
	public void	setCgoClmNo( String	cgoClmNo ) {
		this.cgoClmNo =	cgoClmNo;
	}
 
	/**
	 * Column Info
	 * @return	cgoClmNo
	 */
	 public	 String	getCgoClmNo() {
		 return	this.cgoClmNo;
	 } 
 	/**
	* Column Info
	* @param  clmPtyAbbrNm
	*/
	public void	setClmPtyAbbrNm( String	clmPtyAbbrNm ) {
		this.clmPtyAbbrNm =	clmPtyAbbrNm;
	}
 
	/**
	 * Column Info
	 * @return	clmPtyAbbrNm
	 */
	 public	 String	getClmPtyAbbrNm() {
		 return	this.clmPtyAbbrNm;
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
	* @param  invRgstNo
	*/
	public void	setInvRgstNo( String	invRgstNo ) {
		this.invRgstNo =	invRgstNo;
	}
 
	/**
	 * Column Info
	 * @return	invRgstNo
	 */
	 public	 String	getInvRgstNo() {
		 return	this.invRgstNo;
	 } 
 	/**
	* Column Info
	* @param  invDt
	*/
	public void	setInvDt( String	invDt ) {
		this.invDt =	invDt;
	}
 
	/**
	 * Column Info
	 * @return	invDt
	 */
	 public	 String	getInvDt() {
		 return	this.invDt;
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
		setPayDt(JSPUtil.getParameter(request,	prefix + "pay_dt", ""));
		setInvUsdAmt(JSPUtil.getParameter(request,	prefix + "inv_usd_amt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setCostDesc(JSPUtil.getParameter(request,	prefix + "cost_desc", ""));
		setApPayDt(JSPUtil.getParameter(request,	prefix + "ap_pay_dt", ""));
		setCgoClmPayNo(JSPUtil.getParameter(request,	prefix + "cgo_clm_pay_no", ""));
		setClmCostTpCd(JSPUtil.getParameter(request,	prefix + "clm_cost_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setClmPtyNo(JSPUtil.getParameter(request,	prefix + "clm_pty_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setInvRmk(JSPUtil.getParameter(request,	prefix + "inv_rmk", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setCgoClmNo(JSPUtil.getParameter(request,	prefix + "cgo_clm_no", ""));
		setClmPtyAbbrNm(JSPUtil.getParameter(request,	prefix + "clm_pty_abbr_nm", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setInvRgstNo(JSPUtil.getParameter(request,	prefix + "inv_rgst_no", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HandlingCostVO[]
	 */
	public HandlingCostVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return HandlingCostVO[]
	 */
	public HandlingCostVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		HandlingCostVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] payDt =	(JSPUtil.getParameter(request, prefix +	"pay_dt".trim(),	length));
				String[] invUsdAmt =	(JSPUtil.getParameter(request, prefix +	"inv_usd_amt".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] costDesc =	(JSPUtil.getParameter(request, prefix +	"cost_desc".trim(),	length));
				String[] apPayDt =	(JSPUtil.getParameter(request, prefix +	"ap_pay_dt".trim(),	length));
				String[] cgoClmPayNo =	(JSPUtil.getParameter(request, prefix +	"cgo_clm_pay_no".trim(),	length));
				String[] clmCostTpCd =	(JSPUtil.getParameter(request, prefix +	"clm_cost_tp_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] clmPtyNo =	(JSPUtil.getParameter(request, prefix +	"clm_pty_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] invRmk =	(JSPUtil.getParameter(request, prefix +	"inv_rmk".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] cgoClmNo =	(JSPUtil.getParameter(request, prefix +	"cgo_clm_no".trim(),	length));
				String[] clmPtyAbbrNm =	(JSPUtil.getParameter(request, prefix +	"clm_pty_abbr_nm".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] invRgstNo =	(JSPUtil.getParameter(request, prefix +	"inv_rgst_no".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	HandlingCostVO();
						if ( payDt[i] !=	null)
						model.setPayDt( payDt[i]);
						if ( invUsdAmt[i] !=	null)
						model.setInvUsdAmt( invUsdAmt[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( costDesc[i] !=	null)
						model.setCostDesc( costDesc[i]);
						if ( apPayDt[i] !=	null)
						model.setApPayDt( apPayDt[i]);
						if ( cgoClmPayNo[i] !=	null)
						model.setCgoClmPayNo( cgoClmPayNo[i]);
						if ( clmCostTpCd[i] !=	null)
						model.setClmCostTpCd( clmCostTpCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( clmPtyNo[i] !=	null)
						model.setClmPtyNo( clmPtyNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( invRmk[i] !=	null)
						model.setInvRmk( invRmk[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( cgoClmNo[i] !=	null)
						model.setCgoClmNo( cgoClmNo[i]);
						if ( clmPtyAbbrNm[i] !=	null)
						model.setClmPtyAbbrNm( clmPtyAbbrNm[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( invRgstNo[i] !=	null)
						model.setInvRgstNo( invRgstNo[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getHandlingCostVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return HandlingCostVO[]
	 */
	public HandlingCostVO[]	 getHandlingCostVOs(){
		HandlingCostVO[] vos = (HandlingCostVO[])models.toArray(new	HandlingCostVO[models.size()]);
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
		this.payDt =	this.payDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdAmt =	this.invUsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costDesc =	this.costDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayDt =	this.apPayDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmPayNo =	this.cgoClmPayNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmCostTpCd =	this.clmCostTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyNo =	this.clmPtyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk =	this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoClmNo =	this.cgoClmNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clmPtyAbbrNm =	this.clmPtyAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRgstNo =	this.invRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}