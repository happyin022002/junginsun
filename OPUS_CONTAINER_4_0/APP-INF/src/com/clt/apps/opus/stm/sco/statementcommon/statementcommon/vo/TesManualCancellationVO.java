/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : TesManualCancellationVO.java
 *@FileTitle : TesManualCancellationVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.06
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.06  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

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
public class TesManualCancellationVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<TesManualCancellationVO>  models =	new	ArrayList<TesManualCancellationVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 yardCode   =  null;
	/*	Column Info	*/
	private  String	 vendorCode   =  null;
	/*	Column Info	*/
	private  String	 costCode   =  null;
	/*	Column Info	*/
	private  String	 estmQty   =  null;
	/*	Column Info	*/
	private  String	 estmAmt   =  null;
	/*	Column Info	*/
	private  String	 actQty   =  null;
	/*	Column Info	*/
	private  String	 actAmt   =  null;
	/*	Column Info	*/
	private  String	 acclQty   =  null;
	/*	Column Info	*/
	private  String	 acclAmt   =  null;
	/*	Column Info	*/
	private  String	 cancelFlag   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 revDirCd   =  null;
	/*	Column Info	*/
	private  String	 actDt   =  null;
	/*	Column Info	*/
	private  String	 exeMonth   =  null;
	/*	Column Info	*/
	private  String	 revYrmon   =  null;
	/*	Column Info	*/
	private  String	 acctCd   =  null;
	/*	Column Info	*/
	private  String	 acclSeq   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public TesManualCancellationVO(){}

	public TesManualCancellationVO(String ibflag,String pagerows,String vvd,String yardCode,String vendorCode,String costCode,String estmQty,String estmAmt,String actQty,String actAmt,String acclQty,String acclAmt,String cancelFlag,String updUsrId,String updDt,String vslCd,String skdVoyNo,String skdDirCd,String revDirCd,String actDt,String exeMonth,String revYrmon,String acctCd,String acclSeq)	{
		this.ibflag  = ibflag ;
		this.pagerows  = pagerows ;
		this.vvd  = vvd ;
		this.yardCode  = yardCode ;
		this.vendorCode  = vendorCode ;
		this.costCode  = costCode ;
		this.estmQty  = estmQty ;
		this.estmAmt  = estmAmt ;
		this.actQty  = actQty ;
		this.actAmt  = actAmt ;
		this.acclQty  = acclQty ;
		this.acclAmt  = acclAmt ;
		this.cancelFlag  = cancelFlag ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.vslCd  = vslCd ;
		this.skdVoyNo  = skdVoyNo ;
		this.skdDirCd  = skdDirCd ;
		this.revDirCd  = revDirCd ;
		this.actDt  = actDt ;
		this.exeMonth  = exeMonth ;
		this.revYrmon  = revYrmon ;
		this.acctCd  = acctCd ;
		this.acclSeq  = acclSeq ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("yard_code", getYardCode());		
		this.hashColumns.put("vendor_code", getVendorCode());		
		this.hashColumns.put("cost_code", getCostCode());		
		this.hashColumns.put("estm_qty", getEstmQty());		
		this.hashColumns.put("estm_amt", getEstmAmt());		
		this.hashColumns.put("act_qty", getActQty());		
		this.hashColumns.put("act_amt", getActAmt());		
		this.hashColumns.put("accl_qty", getAcclQty());		
		this.hashColumns.put("accl_amt", getAcclAmt());		
		this.hashColumns.put("cancel_flag", getCancelFlag());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("rev_dir_cd", getRevDirCd());		
		this.hashColumns.put("act_dt", getActDt());		
		this.hashColumns.put("exe_month", getExeMonth());	
		this.hashColumns.put("rev_yrmon", getRevYrmon());		
		this.hashColumns.put("acct_cd", getAcctCd());		
		this.hashColumns.put("accl_seq", getAcclSeq());	
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("yard_code", "yardCode");
		this.hashFields.put("vendor_code", "vendorCode");
		this.hashFields.put("cost_code", "costCode");
		this.hashFields.put("estm_qty", "estmQty");
		this.hashFields.put("estm_amt", "estmAmt");
		this.hashFields.put("act_qty", "actQty");
		this.hashFields.put("act_amt", "actAmt");
		this.hashFields.put("accl_qty", "acclQty");
		this.hashFields.put("accl_amt", "acclAmt");
		this.hashFields.put("cancel_flag", "cancelFlag");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("exe_month", "exeMonth");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("accl_seq", "acclSeq");
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
	* @param  yardCode
	*/
	public void	setYardCode( String	yardCode ) {
		this.yardCode =	yardCode;
	}
 
	/**
	 * Column Info
	 * @return	yardCode
	 */
	 public	 String	getYardCode() {
		 return	this.yardCode;
	 } 
 	/**
	* Column Info
	* @param  vendorCode
	*/
	public void	setVendorCode( String	vendorCode ) {
		this.vendorCode =	vendorCode;
	}
 
	/**
	 * Column Info
	 * @return	vendorCode
	 */
	 public	 String	getVendorCode() {
		 return	this.vendorCode;
	 } 
 	/**
	* Column Info
	* @param  costCode
	*/
	public void	setCostCode( String	costCode ) {
		this.costCode =	costCode;
	}
 
	/**
	 * Column Info
	 * @return	costCode
	 */
	 public	 String	getCostCode() {
		 return	this.costCode;
	 } 
 	/**
	* Column Info
	* @param  estmQty
	*/
	public void	setEstmQty( String	estmQty ) {
		this.estmQty =	estmQty;
	}
 
	/**
	 * Column Info
	 * @return	estmQty
	 */
	 public	 String	getEstmQty() {
		 return	this.estmQty;
	 } 
 	/**
	* Column Info
	* @param  estmAmt
	*/
	public void	setEstmAmt( String	estmAmt ) {
		this.estmAmt =	estmAmt;
	}
 
	/**
	 * Column Info
	 * @return	estmAmt
	 */
	 public	 String	getEstmAmt() {
		 return	this.estmAmt;
	 } 
 	/**
	* Column Info
	* @param  actQty
	*/
	public void	setActQty( String	actQty ) {
		this.actQty =	actQty;
	}
 
	/**
	 * Column Info
	 * @return	actQty
	 */
	 public	 String	getActQty() {
		 return	this.actQty;
	 } 
 	/**
	* Column Info
	* @param  actAmt
	*/
	public void	setActAmt( String	actAmt ) {
		this.actAmt =	actAmt;
	}
 
	/**
	 * Column Info
	 * @return	actAmt
	 */
	 public	 String	getActAmt() {
		 return	this.actAmt;
	 } 
 	/**
	* Column Info
	* @param  acclQty
	*/
	public void	setAcclQty( String	acclQty ) {
		this.acclQty =	acclQty;
	}
 
	/**
	 * Column Info
	 * @return	acclQty
	 */
	 public	 String	getAcclQty() {
		 return	this.acclQty;
	 } 
 	/**
	* Column Info
	* @param  acclAmt
	*/
	public void	setAcclAmt( String	acclAmt ) {
		this.acclAmt =	acclAmt;
	}
 
	/**
	 * Column Info
	 * @return	acclAmt
	 */
	 public	 String	getAcclAmt() {
		 return	this.acclAmt;
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
	 public	 String	getCancelFlag() {
		 return	this.cancelFlag;
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
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	 String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  vslCd
	*/
	public void	setVslCd( String	vslCd ) {
		this.vslCd =	vslCd;
	}
 
	/**
	 * Column Info
	 * @return	vslCd
	 */
	 public	 String	getVslCd() {
		 return	this.vslCd;
	 } 
 	/**
	* Column Info
	* @param  skdVoyNo
	*/
	public void	setSkdVoyNo( String	skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	skdVoyNo
	 */
	 public	 String	getSkdVoyNo() {
		 return	this.skdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  skdDirCd
	*/
	public void	setSkdDirCd( String	skdDirCd ) {
		this.skdDirCd =	skdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	skdDirCd
	 */
	 public	 String	getSkdDirCd() {
		 return	this.skdDirCd;
	 } 
 	/**
	* Column Info
	* @param  revDirCd
	*/
	public void	setRevDirCd( String	revDirCd ) {
		this.revDirCd =	revDirCd;
	}
 
	/**
	 * Column Info
	 * @return	revDirCd
	 */
	 public	 String	getRevDirCd() {
		 return	this.revDirCd;
	 } 
 	/**
	* Column Info
	* @param  actDt
	*/
	public void	setActDt( String	actDt ) {
		this.actDt =	actDt;
	}
 
	/**
	 * Column Info
	 * @return	actDt
	 */
	 public	 String	getActDt() {
		 return	this.actDt;
	 } 
 	/**
	* Column Info
	* @param  exeMonth
	*/
	public void	setExeMonth( String	exeMonth ) {
		this.exeMonth =	exeMonth;
	}
 
	/**
	 * Column Info
	 * @return	exeMonth
	 */
	 public	 String	getExeMonth() {
		 return	this.exeMonth;
	 } 
	 /**
		* Column Info
		* @param  revYrmon
		*/
		public void	setRevYrmon( String	revYrmon ) {
			this.revYrmon =	revYrmon;
		}
	 
		/**
		 * Column Info
		 * @return	revYrmon
		 */
		 public	String	getRevYrmon() {
			 return	this.revYrmon;
		 } 
	 	/**
		* Column Info
		* @param  acctCd
		*/
		public void	setAcctCd( String	acctCd ) {
			this.acctCd =	acctCd;
		}
	 
		/**
		 * Column Info
		 * @return	acctCd
		 */
		 public	String	getAcctCd() {
			 return	this.acctCd;
		 } 
	 	/**
		* Column Info
		* @param  acclSeq
		*/
		public void	setAcclSeq( String	acclSeq ) {
			this.acclSeq =	acclSeq;
		}
	 
		/**
		 * Column Info
		 * @return	acclSeq
		 */
		 public	String	getAcclSeq() {
			 return	this.acclSeq;
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
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setYardCode(JSPUtil.getParameter(request,	prefix + "yard_code", ""));
		setVendorCode(JSPUtil.getParameter(request,	prefix + "vendor_code", ""));
		setCostCode(JSPUtil.getParameter(request,	prefix + "cost_code", ""));
		setEstmQty(JSPUtil.getParameter(request,	prefix + "estm_qty", ""));
		setEstmAmt(JSPUtil.getParameter(request,	prefix + "estm_amt", ""));
		setActQty(JSPUtil.getParameter(request,	prefix + "act_qty", ""));
		setActAmt(JSPUtil.getParameter(request,	prefix + "act_amt", ""));
		setAcclQty(JSPUtil.getParameter(request,	prefix + "accl_qty", ""));
		setAcclAmt(JSPUtil.getParameter(request,	prefix + "accl_amt", ""));
		setCancelFlag(JSPUtil.getParameter(request,	prefix + "cancel_flag", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setRevDirCd(JSPUtil.getParameter(request,	prefix + "rev_dir_cd", ""));
		setActDt(JSPUtil.getParameter(request,	prefix + "act_dt", ""));
		setExeMonth(JSPUtil.getParameter(request,	prefix + "exe_month", ""));
		setRevYrmon(JSPUtil.getParameter(request,	prefix + "rev_yrmon", ""));
		setAcctCd(JSPUtil.getParameter(request,	prefix + "acct_cd", ""));
		setAcclSeq(JSPUtil.getParameter(request,	prefix + "accl_seq", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return TesManualCancellationVO[]
	 */
	public TesManualCancellationVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return TesManualCancellationVO[]
	 */
	public TesManualCancellationVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		TesManualCancellationVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] yardCode =	(JSPUtil.getParameter(request, prefix +	"yard_code".trim(),	length));
				String[] vendorCode =	(JSPUtil.getParameter(request, prefix +	"vendor_code".trim(),	length));
				String[] costCode =	(JSPUtil.getParameter(request, prefix +	"cost_code".trim(),	length));
				String[] estmQty =	(JSPUtil.getParameter(request, prefix +	"estm_qty".trim(),	length));
				String[] estmAmt =	(JSPUtil.getParameter(request, prefix +	"estm_amt".trim(),	length));
				String[] actQty =	(JSPUtil.getParameter(request, prefix +	"act_qty".trim(),	length));
				String[] actAmt =	(JSPUtil.getParameter(request, prefix +	"act_amt".trim(),	length));
				String[] acclQty =	(JSPUtil.getParameter(request, prefix +	"accl_qty".trim(),	length));
				String[] acclAmt =	(JSPUtil.getParameter(request, prefix +	"accl_amt".trim(),	length));
				String[] cancelFlag =	(JSPUtil.getParameter(request, prefix +	"cancel_flag".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] revDirCd =	(JSPUtil.getParameter(request, prefix +	"rev_dir_cd".trim(),	length));
				String[] actDt =	(JSPUtil.getParameter(request, prefix +	"act_dt".trim(),	length));
				String[] exeMonth =	(JSPUtil.getParameter(request, prefix +	"exe_month".trim(),	length));
				String[] revYrmon =	(JSPUtil.getParameter(request, prefix +	"rev_yrmon".trim(),	length));
				String[] acctCd =	(JSPUtil.getParameter(request, prefix +	"acct_cd".trim(),	length));
				String[] acclSeq =	(JSPUtil.getParameter(request, prefix +	"accl_seq".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	TesManualCancellationVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( yardCode[i] !=	null)
						model.setYardCode( yardCode[i]);
						if ( vendorCode[i] !=	null)
						model.setVendorCode( vendorCode[i]);
						if ( costCode[i] !=	null)
						model.setCostCode( costCode[i]);
						if ( estmQty[i] !=	null)
						model.setEstmQty( estmQty[i]);
						if ( estmAmt[i] !=	null)
						model.setEstmAmt( estmAmt[i]);
						if ( actQty[i] !=	null)
						model.setActQty( actQty[i]);
						if ( actAmt[i] !=	null)
						model.setActAmt( actAmt[i]);
						if ( acclQty[i] !=	null)
						model.setAcclQty( acclQty[i]);
						if ( acclAmt[i] !=	null)
						model.setAcclAmt( acclAmt[i]);
						if ( cancelFlag[i] !=	null)
						model.setCancelFlag( cancelFlag[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( revDirCd[i] !=	null)
						model.setRevDirCd( revDirCd[i]);
						if ( actDt[i] !=	null)
						model.setActDt( actDt[i]);
						if ( exeMonth[i] !=	null)
						model.setExeMonth( exeMonth[i]);
						if ( revYrmon[i] !=	null)
						model.setRevYrmon( revYrmon[i]);
						if ( acctCd[i] !=	null)
						model.setAcctCd( acctCd[i]);
						if ( acclSeq[i] !=	null)
						model.setAcclSeq( acclSeq[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getTesManualCancellationVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return TesManualCancellationVO[]
	 */
	public TesManualCancellationVO[]	 getTesManualCancellationVOs(){
		TesManualCancellationVO[] vos = (TesManualCancellationVO[])models.toArray(new	TesManualCancellationVO[models.size()]);
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
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCode =	this.yardCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vendorCode =	this.vendorCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCode =	this.costCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmQty =	this.estmQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmAmt =	this.estmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actQty =	this.actQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actAmt =	this.actAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclQty =	this.acclQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclAmt =	this.acclAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cancelFlag =	this.cancelFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd =	this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt =	this.actDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exeMonth =	this.exeMonth.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon =	this.revYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd =	this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acclSeq =	this.acclSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}