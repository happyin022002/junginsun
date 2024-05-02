/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AutoSettlementSubInfoVO.java
 *@FileTitle : AutoSettlementSubInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.13  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

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
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class AutoSettlementSubInfoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AutoSettlementSubInfoVO>  models =	new	ArrayList<AutoSettlementSubInfoVO>();


	/*	Column Info	*/
	private  String	 ofcBalAmt   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 ofcBlCnt   =  null;
	/*	Column Info	*/
	private  String	 ofcUsdAmt   =  null;
	/*	Column Info	*/
	private  String	 ofcLclAmt   =  null;
	/*	Column Info	*/
	private  String	 ofcBlCurrCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 lclPrcs   =  null;
	/*	Column Info	*/
	private  String	 blPrcs   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AutoSettlementSubInfoVO(){}

	public AutoSettlementSubInfoVO(String ofcBalAmt,String ofcCd,String ibflag,String ofcBlCnt,String ofcUsdAmt,String ofcLclAmt,String ofcBlCurrCd,String pagerows,String lclPrcs,String blPrcs)	{
		this.ofcBalAmt  = ofcBalAmt ;
		this.ofcCd  = ofcCd ;
		this.ibflag  = ibflag ;
		this.ofcBlCnt  = ofcBlCnt ;
		this.ofcUsdAmt  = ofcUsdAmt ;
		this.ofcLclAmt  = ofcLclAmt ;
		this.ofcBlCurrCd  = ofcBlCurrCd ;
		this.pagerows  = pagerows ;
		this.lclPrcs  = lclPrcs ;
		this.blPrcs  = blPrcs ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_bal_amt", getOfcBalAmt());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ofc_bl_cnt", getOfcBlCnt());		
		this.hashColumns.put("ofc_usd_amt", getOfcUsdAmt());		
		this.hashColumns.put("ofc_lcl_amt", getOfcLclAmt());		
		this.hashColumns.put("ofc_bl_curr_cd", getOfcBlCurrCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("lcl_prcs", getLclPrcs());		
		this.hashColumns.put("bl_prcs", getBlPrcs());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ofc_bal_amt", "ofcBalAmt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ofc_bl_cnt", "ofcBlCnt");
		this.hashFields.put("ofc_usd_amt", "ofcUsdAmt");
		this.hashFields.put("ofc_lcl_amt", "ofcLclAmt");
		this.hashFields.put("ofc_bl_curr_cd", "ofcBlCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lcl_prcs", "lclPrcs");
		this.hashFields.put("bl_prcs", "blPrcs");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  ofcBalAmt
	*/
	public void	setOfcBalAmt( String	ofcBalAmt ) {
		this.ofcBalAmt =	ofcBalAmt;
	}
 
	/**
	 * Column Info
	 * @return	ofcBalAmt
	 */
	 public	 String	getOfcBalAmt() {
		 return	this.ofcBalAmt;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
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
	* @param  ofcBlCnt
	*/
	public void	setOfcBlCnt( String	ofcBlCnt ) {
		this.ofcBlCnt =	ofcBlCnt;
	}
 
	/**
	 * Column Info
	 * @return	ofcBlCnt
	 */
	 public	 String	getOfcBlCnt() {
		 return	this.ofcBlCnt;
	 } 
 	/**
	* Column Info
	* @param  ofcUsdAmt
	*/
	public void	setOfcUsdAmt( String	ofcUsdAmt ) {
		this.ofcUsdAmt =	ofcUsdAmt;
	}
 
	/**
	 * Column Info
	 * @return	ofcUsdAmt
	 */
	 public	 String	getOfcUsdAmt() {
		 return	this.ofcUsdAmt;
	 } 
 	/**
	* Column Info
	* @param  ofcLclAmt
	*/
	public void	setOfcLclAmt( String	ofcLclAmt ) {
		this.ofcLclAmt =	ofcLclAmt;
	}
 
	/**
	 * Column Info
	 * @return	ofcLclAmt
	 */
	 public	 String	getOfcLclAmt() {
		 return	this.ofcLclAmt;
	 } 
 	/**
	* Column Info
	* @param  ofcBlCurrCd
	*/
	public void	setOfcBlCurrCd( String	ofcBlCurrCd ) {
		this.ofcBlCurrCd =	ofcBlCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcBlCurrCd
	 */
	 public	 String	getOfcBlCurrCd() {
		 return	this.ofcBlCurrCd;
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
	* @param  lclPrcs
	*/
	public void	setLclPrcs( String	lclPrcs ) {
		this.lclPrcs =	lclPrcs;
	}
 
	/**
	 * Column Info
	 * @return	lclPrcs
	 */
	 public	 String	getLclPrcs() {
		 return	this.lclPrcs;
	 } 
 	/**
	* Column Info
	* @param  blPrcs
	*/
	public void	setBlPrcs( String	blPrcs ) {
		this.blPrcs =	blPrcs;
	}
 
	/**
	 * Column Info
	 * @return	blPrcs
	 */
	 public	 String	getBlPrcs() {
		 return	this.blPrcs;
	 } 

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setOfcBalAmt(JSPUtil.getParameter(request,	prefix + "ofc_bal_amt", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setOfcBlCnt(JSPUtil.getParameter(request,	prefix + "ofc_bl_cnt", ""));
		setOfcUsdAmt(JSPUtil.getParameter(request,	prefix + "ofc_usd_amt", ""));
		setOfcLclAmt(JSPUtil.getParameter(request,	prefix + "ofc_lcl_amt", ""));
		setOfcBlCurrCd(JSPUtil.getParameter(request,	prefix + "ofc_bl_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setLclPrcs(JSPUtil.getParameter(request,	prefix + "lcl_prcs", ""));
		setBlPrcs(JSPUtil.getParameter(request,	prefix + "bl_prcs", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return AutoSettlementSubInfoVO[]
	 */
	public AutoSettlementSubInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return AutoSettlementSubInfoVO[]
	 */
	public AutoSettlementSubInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AutoSettlementSubInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ofcBalAmt =	(JSPUtil.getParameter(request, prefix +	"ofc_bal_amt".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] ofcBlCnt =	(JSPUtil.getParameter(request, prefix +	"ofc_bl_cnt".trim(),	length));
				String[] ofcUsdAmt =	(JSPUtil.getParameter(request, prefix +	"ofc_usd_amt".trim(),	length));
				String[] ofcLclAmt =	(JSPUtil.getParameter(request, prefix +	"ofc_lcl_amt".trim(),	length));
				String[] ofcBlCurrCd =	(JSPUtil.getParameter(request, prefix +	"ofc_bl_curr_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] lclPrcs =	(JSPUtil.getParameter(request, prefix +	"lcl_prcs".trim(),	length));
				String[] blPrcs =	(JSPUtil.getParameter(request, prefix +	"bl_prcs".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AutoSettlementSubInfoVO();
						if ( ofcBalAmt[i] !=	null)
						model.setOfcBalAmt( ofcBalAmt[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( ofcBlCnt[i] !=	null)
						model.setOfcBlCnt( ofcBlCnt[i]);
						if ( ofcUsdAmt[i] !=	null)
						model.setOfcUsdAmt( ofcUsdAmt[i]);
						if ( ofcLclAmt[i] !=	null)
						model.setOfcLclAmt( ofcLclAmt[i]);
						if ( ofcBlCurrCd[i] !=	null)
						model.setOfcBlCurrCd( ofcBlCurrCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( lclPrcs[i] !=	null)
						model.setLclPrcs( lclPrcs[i]);
						if ( blPrcs[i] !=	null)
						model.setBlPrcs( blPrcs[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAutoSettlementSubInfoVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return AutoSettlementSubInfoVO[]
	 */
	public AutoSettlementSubInfoVO[]	 getAutoSettlementSubInfoVOs(){
		AutoSettlementSubInfoVO[] vos = (AutoSettlementSubInfoVO[])models.toArray(new	AutoSettlementSubInfoVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.ofcBalAmt =	this.ofcBalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcBlCnt =	this.ofcBlCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcUsdAmt =	this.ofcUsdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcLclAmt =	this.ofcLclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcBlCurrCd =	this.ofcBlCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclPrcs =	this.lclPrcs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blPrcs =	this.blPrcs.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}