/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ARInvoiceChargeByBLNoVO.java
 *@FileTitle : ARInvoiceChargeByBLNoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.08
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.08  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

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
public class ARInvoiceChargeByBLNoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ARInvoiceChargeByBLNoVO>  models =	new	ArrayList<ARInvoiceChargeByBLNoVO>();


	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 localTotal   =  null;
	/*	Column Info	*/
	private  String	 perTpCd   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 trfRtAmt   =  null;
	/*	Column Info	*/
	private  String	 chgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 chgAmt   =  null;
	/*	Column Info	*/
	private  String	 dpPrcsKntLocal   =  null;
	/*	Column Info	*/
	private  String	 ratAsCntrQty   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 mnlFlg   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 issXchRt   =  null;
	/*	Column Info	*/
	private  String	 invTotal   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ARInvoiceChargeByBLNoVO(){}

	public ARInvoiceChargeByBLNoVO(String blSrcNo,String localTotal,String perTpCd,String currCd,String trfRtAmt,String chgCd,String pagerows,String dpPrcsKnt,String podCd,String ibflag,String polCd,String chgAmt,String dpPrcsKntLocal,String ratAsCntrQty,String invXchRt,String mnlFlg,String invCurrCd,String issXchRt,String invTotal)	{
		this.blSrcNo  = blSrcNo ;
		this.localTotal  = localTotal ;
		this.perTpCd  = perTpCd ;
		this.currCd  = currCd ;
		this.trfRtAmt  = trfRtAmt ;
		this.chgCd  = chgCd ;
		this.pagerows  = pagerows ;
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.podCd  = podCd ;
		this.ibflag  = ibflag ;
		this.polCd  = polCd ;
		this.chgAmt  = chgAmt ;
		this.dpPrcsKntLocal  = dpPrcsKntLocal ;
		this.ratAsCntrQty  = ratAsCntrQty ;
		this.invXchRt  = invXchRt ;
		this.mnlFlg  = mnlFlg ;
		this.invCurrCd  = invCurrCd ;
		this.issXchRt  = issXchRt ;
		this.invTotal  = invTotal ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("local_total", getLocalTotal());		
		this.hashColumns.put("per_tp_cd", getPerTpCd());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());		
		this.hashColumns.put("chg_cd", getChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("chg_amt", getChgAmt());		
		this.hashColumns.put("dp_prcs_knt_local", getDpPrcsKntLocal());		
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("mnl_flg", getMnlFlg());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("iss_xch_rt", getIssXchRt());		
		this.hashColumns.put("inv_total", getInvTotal());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("local_total", "localTotal");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("dp_prcs_knt_local", "dpPrcsKntLocal");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("mnl_flg", "mnlFlg");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("iss_xch_rt", "issXchRt");
		this.hashFields.put("inv_total", "invTotal");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  localTotal
	*/
	public void	setLocalTotal( String	localTotal ) {
		this.localTotal =	localTotal;
	}
 
	/**
	 * Column Info
	 * @return	localTotal
	 */
	 public	 String	getLocalTotal() {
		 return	this.localTotal;
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
	* @param  dpPrcsKnt
	*/
	public void	setDpPrcsKnt( String	dpPrcsKnt ) {
		this.dpPrcsKnt =	dpPrcsKnt;
	}
 
	/**
	 * Column Info
	 * @return	dpPrcsKnt
	 */
	 public	 String	getDpPrcsKnt() {
		 return	this.dpPrcsKnt;
	 } 
 	/**
	* Column Info
	* @param  podCd
	*/
	public void	setPodCd( String	podCd ) {
		this.podCd =	podCd;
	}
 
	/**
	 * Column Info
	 * @return	podCd
	 */
	 public	 String	getPodCd() {
		 return	this.podCd;
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
	* @param  polCd
	*/
	public void	setPolCd( String	polCd ) {
		this.polCd =	polCd;
	}
 
	/**
	 * Column Info
	 * @return	polCd
	 */
	 public	 String	getPolCd() {
		 return	this.polCd;
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
	* @param  mnlFlg
	*/
	public void	setMnlFlg( String	mnlFlg ) {
		this.mnlFlg =	mnlFlg;
	}
 
	/**
	 * Column Info
	 * @return	mnlFlg
	 */
	 public	 String	getMnlFlg() {
		 return	this.mnlFlg;
	 } 
 	/**
	* Column Info
	* @param  invCurrCd
	*/
	public void	setInvCurrCd( String	invCurrCd ) {
		this.invCurrCd =	invCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invCurrCd
	 */
	 public	 String	getInvCurrCd() {
		 return	this.invCurrCd;
	 } 
 	/**
	* Column Info
	* @param  issXchRt
	*/
	public void	setIssXchRt( String	issXchRt ) {
		this.issXchRt =	issXchRt;
	}
 
	/**
	 * Column Info
	 * @return	issXchRt
	 */
	 public	 String	getIssXchRt() {
		 return	this.issXchRt;
	 } 
 	/**
	* Column Info
	* @param  invTotal
	*/
	public void	setInvTotal( String	invTotal ) {
		this.invTotal =	invTotal;
	}
 
	/**
	 * Column Info
	 * @return	invTotal
	 */
	 public	 String	getInvTotal() {
		 return	this.invTotal;
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
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setLocalTotal(JSPUtil.getParameter(request,	prefix + "local_total", ""));
		setPerTpCd(JSPUtil.getParameter(request,	prefix + "per_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setTrfRtAmt(JSPUtil.getParameter(request,	prefix + "trf_rt_amt", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setChgAmt(JSPUtil.getParameter(request,	prefix + "chg_amt", ""));
		setDpPrcsKntLocal(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt_local", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request,	prefix + "rat_as_cntr_qty", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setMnlFlg(JSPUtil.getParameter(request,	prefix + "mnl_flg", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setIssXchRt(JSPUtil.getParameter(request,	prefix + "iss_xch_rt", ""));
		setInvTotal(JSPUtil.getParameter(request,	prefix + "inv_total", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceChargeByBLNoVO[]
	 */
	public ARInvoiceChargeByBLNoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ARInvoiceChargeByBLNoVO[]
	 */
	public ARInvoiceChargeByBLNoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ARInvoiceChargeByBLNoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] localTotal =	(JSPUtil.getParameter(request, prefix +	"local_total".trim(),	length));
				String[] perTpCd =	(JSPUtil.getParameter(request, prefix +	"per_tp_cd".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] trfRtAmt =	(JSPUtil.getParameter(request, prefix +	"trf_rt_amt".trim(),	length));
				String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] chgAmt =	(JSPUtil.getParameter(request, prefix +	"chg_amt".trim(),	length));
				String[] dpPrcsKntLocal =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt_local".trim(),	length));
				String[] ratAsCntrQty =	(JSPUtil.getParameter(request, prefix +	"rat_as_cntr_qty".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] mnlFlg =	(JSPUtil.getParameter(request, prefix +	"mnl_flg".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] issXchRt =	(JSPUtil.getParameter(request, prefix +	"iss_xch_rt".trim(),	length));
				String[] invTotal =	(JSPUtil.getParameter(request, prefix +	"inv_total".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ARInvoiceChargeByBLNoVO();
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( localTotal[i] !=	null)
						model.setLocalTotal( localTotal[i]);
						if ( perTpCd[i] !=	null)
						model.setPerTpCd( perTpCd[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( trfRtAmt[i] !=	null)
						model.setTrfRtAmt( trfRtAmt[i]);
						if ( chgCd[i] !=	null)
						model.setChgCd( chgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( chgAmt[i] !=	null)
						model.setChgAmt( chgAmt[i]);
						if ( dpPrcsKntLocal[i] !=	null)
						model.setDpPrcsKntLocal( dpPrcsKntLocal[i]);
						if ( ratAsCntrQty[i] !=	null)
						model.setRatAsCntrQty( ratAsCntrQty[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( mnlFlg[i] !=	null)
						model.setMnlFlg( mnlFlg[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( issXchRt[i] !=	null)
						model.setIssXchRt( issXchRt[i]);
						if ( invTotal[i] !=	null)
						model.setInvTotal( invTotal[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getARInvoiceChargeByBLNoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ARInvoiceChargeByBLNoVO[]
	 */
	public ARInvoiceChargeByBLNoVO[]	 getARInvoiceChargeByBLNoVOs(){
		ARInvoiceChargeByBLNoVO[] vos = (ARInvoiceChargeByBLNoVO[])models.toArray(new	ARInvoiceChargeByBLNoVO[models.size()]);
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
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localTotal =	this.localTotal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd =	this.perTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt =	this.trfRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt =	this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpPrcsKntLocal =	this.dpPrcsKntLocal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty =	this.ratAsCntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnlFlg =	this.mnlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issXchRt =	this.issXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTotal =	this.invTotal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}