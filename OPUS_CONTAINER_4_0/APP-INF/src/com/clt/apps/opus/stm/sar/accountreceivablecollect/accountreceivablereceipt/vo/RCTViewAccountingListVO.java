/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RCTViewAccountingListVO.java
 *@FileTitle : RCTViewAccountingListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.09.30
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.09.30  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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
public class RCTViewAccountingListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RCTViewAccountingListVO>  models =	new	ArrayList<RCTViewAccountingListVO>();


	/*	Column Info	*/
	private  String	 inpDrAmt   =  null;
	/*	Column Info	*/
	private  String	 rctOfcCd   =  null;
	/*	Column Info	*/
	private  String	 rcvApplTpCd   =  null;
	/*	Column Info	*/
	private  String	 ifNo   =  null;
	/*	Column Info	*/
	private  String	 chgTpCd   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 dtrbSrcTpCd   =  null;
	/*	Column Info	*/
	private  String	 inpCrAmt   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 acctXchRtDt   =  null;
	/*	Column Info	*/
	private  String	 convXchRt   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt2   =  null;
	/*	Column Info	*/
	private  String	 acctDrAmt   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt3   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt1   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt6   =  null;
	/*	Column Info	*/
	private  String	 rctNo   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt4   =  null;
	/*	Column Info	*/
	private  String	 acctCrAmt   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt5   =  null;
	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 wrtfCd   =  null;
	/*	Column Info	*/
	private  String	 otsSmryCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public RCTViewAccountingListVO(){}

	public RCTViewAccountingListVO(String inpDrAmt,String rctOfcCd,String rcvApplTpCd,String ifNo,String chgTpCd,String currCd,String dtrbSrcTpCd,String inpCrAmt,String blNo,String pagerows,String ibflag,String acctXchRtDt,String convXchRt,String sgmCtnt2,String acctDrAmt,String sgmCtnt3,String sgmCtnt1,String sgmCtnt6,String rctNo,String sgmCtnt4,String acctCrAmt,String sgmCtnt5,String glDt,String wrtfCd,String otsSmryCd,String invNo)	{
		this.inpDrAmt  = inpDrAmt ;
		this.rctOfcCd  = rctOfcCd ;
		this.rcvApplTpCd  = rcvApplTpCd ;
		this.ifNo  = ifNo ;
		this.chgTpCd  = chgTpCd ;
		this.currCd  = currCd ;
		this.dtrbSrcTpCd  = dtrbSrcTpCd ;
		this.inpCrAmt  = inpCrAmt ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.acctXchRtDt  = acctXchRtDt ;
		this.convXchRt  = convXchRt ;
		this.sgmCtnt2  = sgmCtnt2 ;
		this.acctDrAmt  = acctDrAmt ;
		this.sgmCtnt3  = sgmCtnt3 ;
		this.sgmCtnt1  = sgmCtnt1 ;
		this.sgmCtnt6  = sgmCtnt6 ;
		this.rctNo  = rctNo ;
		this.sgmCtnt4  = sgmCtnt4 ;
		this.acctCrAmt  = acctCrAmt ;
		this.sgmCtnt5  = sgmCtnt5 ;
		this.glDt  = glDt ;
		this.wrtfCd  = wrtfCd ;
		this.otsSmryCd  = otsSmryCd ;
		this.invNo  = invNo ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inp_dr_amt", getInpDrAmt());		
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());		
		this.hashColumns.put("rcv_appl_tp_cd", getRcvApplTpCd());		
		this.hashColumns.put("if_no", getIfNo());		
		this.hashColumns.put("chg_tp_cd", getChgTpCd());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("dtrb_src_tp_cd", getDtrbSrcTpCd());		
		this.hashColumns.put("inp_cr_amt", getInpCrAmt());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("acct_xch_rt_dt", getAcctXchRtDt());		
		this.hashColumns.put("conv_xch_rt", getConvXchRt());		
		this.hashColumns.put("sgm_ctnt2", getSgmCtnt2());		
		this.hashColumns.put("acct_dr_amt", getAcctDrAmt());		
		this.hashColumns.put("sgm_ctnt3", getSgmCtnt3());		
		this.hashColumns.put("sgm_ctnt1", getSgmCtnt1());		
		this.hashColumns.put("sgm_ctnt6", getSgmCtnt6());		
		this.hashColumns.put("rct_no", getRctNo());		
		this.hashColumns.put("sgm_ctnt4", getSgmCtnt4());		
		this.hashColumns.put("acct_cr_amt", getAcctCrAmt());		
		this.hashColumns.put("sgm_ctnt5", getSgmCtnt5());		
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("wrtf_cd", getWrtfCd());		
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inp_dr_amt", "inpDrAmt");
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("rcv_appl_tp_cd", "rcvApplTpCd");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("dtrb_src_tp_cd", "dtrbSrcTpCd");
		this.hashFields.put("inp_cr_amt", "inpCrAmt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acct_xch_rt_dt", "acctXchRtDt");
		this.hashFields.put("conv_xch_rt", "convXchRt");
		this.hashFields.put("sgm_ctnt2", "sgmCtnt2");
		this.hashFields.put("acct_dr_amt", "acctDrAmt");
		this.hashFields.put("sgm_ctnt3", "sgmCtnt3");
		this.hashFields.put("sgm_ctnt1", "sgmCtnt1");
		this.hashFields.put("sgm_ctnt6", "sgmCtnt6");
		this.hashFields.put("rct_no", "rctNo");
		this.hashFields.put("sgm_ctnt4", "sgmCtnt4");
		this.hashFields.put("acct_cr_amt", "acctCrAmt");
		this.hashFields.put("sgm_ctnt5", "sgmCtnt5");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("wrtf_cd", "wrtfCd");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("inv_no", "invNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  inpDrAmt
	*/
	public void	setInpDrAmt( String	inpDrAmt ) {
		this.inpDrAmt =	inpDrAmt;
	}
 
	/**
	 * Column Info
	 * @return	inpDrAmt
	 */
	 public	 String	getInpDrAmt() {
		 return	this.inpDrAmt;
	 } 
 	/**
	* Column Info
	* @param  rctOfcCd
	*/
	public void	setRctOfcCd( String	rctOfcCd ) {
		this.rctOfcCd =	rctOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	rctOfcCd
	 */
	 public	 String	getRctOfcCd() {
		 return	this.rctOfcCd;
	 } 
 	/**
	* Column Info
	* @param  rcvApplTpCd
	*/
	public void	setRcvApplTpCd( String	rcvApplTpCd ) {
		this.rcvApplTpCd =	rcvApplTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rcvApplTpCd
	 */
	 public	 String	getRcvApplTpCd() {
		 return	this.rcvApplTpCd;
	 } 
 	/**
	* Column Info
	* @param  ifNo
	*/
	public void	setIfNo( String	ifNo ) {
		this.ifNo =	ifNo;
	}
 
	/**
	 * Column Info
	 * @return	ifNo
	 */
	 public	 String	getIfNo() {
		 return	this.ifNo;
	 } 
 	/**
	* Column Info
	* @param  chgTpCd
	*/
	public void	setChgTpCd( String	chgTpCd ) {
		this.chgTpCd =	chgTpCd;
	}
 
	/**
	 * Column Info
	 * @return	chgTpCd
	 */
	 public	 String	getChgTpCd() {
		 return	this.chgTpCd;
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
	* @param  dtrbSrcTpCd
	*/
	public void	setDtrbSrcTpCd( String	dtrbSrcTpCd ) {
		this.dtrbSrcTpCd =	dtrbSrcTpCd;
	}
 
	/**
	 * Column Info
	 * @return	dtrbSrcTpCd
	 */
	 public	 String	getDtrbSrcTpCd() {
		 return	this.dtrbSrcTpCd;
	 } 
 	/**
	* Column Info
	* @param  inpCrAmt
	*/
	public void	setInpCrAmt( String	inpCrAmt ) {
		this.inpCrAmt =	inpCrAmt;
	}
 
	/**
	 * Column Info
	 * @return	inpCrAmt
	 */
	 public	 String	getInpCrAmt() {
		 return	this.inpCrAmt;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
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
	* @param  acctXchRtDt
	*/
	public void	setAcctXchRtDt( String	acctXchRtDt ) {
		this.acctXchRtDt =	acctXchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	acctXchRtDt
	 */
	 public	 String	getAcctXchRtDt() {
		 return	this.acctXchRtDt;
	 } 
 	/**
	* Column Info
	* @param  convXchRt
	*/
	public void	setConvXchRt( String	convXchRt ) {
		this.convXchRt =	convXchRt;
	}
 
	/**
	 * Column Info
	 * @return	convXchRt
	 */
	 public	 String	getConvXchRt() {
		 return	this.convXchRt;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt2
	*/
	public void	setSgmCtnt2( String	sgmCtnt2 ) {
		this.sgmCtnt2 =	sgmCtnt2;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt2
	 */
	 public	 String	getSgmCtnt2() {
		 return	this.sgmCtnt2;
	 } 
 	/**
	* Column Info
	* @param  acctDrAmt
	*/
	public void	setAcctDrAmt( String	acctDrAmt ) {
		this.acctDrAmt =	acctDrAmt;
	}
 
	/**
	 * Column Info
	 * @return	acctDrAmt
	 */
	 public	 String	getAcctDrAmt() {
		 return	this.acctDrAmt;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt3
	*/
	public void	setSgmCtnt3( String	sgmCtnt3 ) {
		this.sgmCtnt3 =	sgmCtnt3;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt3
	 */
	 public	 String	getSgmCtnt3() {
		 return	this.sgmCtnt3;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt1
	*/
	public void	setSgmCtnt1( String	sgmCtnt1 ) {
		this.sgmCtnt1 =	sgmCtnt1;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt1
	 */
	 public	 String	getSgmCtnt1() {
		 return	this.sgmCtnt1;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt6
	*/
	public void	setSgmCtnt6( String	sgmCtnt6 ) {
		this.sgmCtnt6 =	sgmCtnt6;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt6
	 */
	 public	 String	getSgmCtnt6() {
		 return	this.sgmCtnt6;
	 } 
 	/**
	* Column Info
	* @param  rctNo
	*/
	public void	setRctNo( String	rctNo ) {
		this.rctNo =	rctNo;
	}
 
	/**
	 * Column Info
	 * @return	rctNo
	 */
	 public	 String	getRctNo() {
		 return	this.rctNo;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt4
	*/
	public void	setSgmCtnt4( String	sgmCtnt4 ) {
		this.sgmCtnt4 =	sgmCtnt4;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt4
	 */
	 public	 String	getSgmCtnt4() {
		 return	this.sgmCtnt4;
	 } 
 	/**
	* Column Info
	* @param  acctCrAmt
	*/
	public void	setAcctCrAmt( String	acctCrAmt ) {
		this.acctCrAmt =	acctCrAmt;
	}
 
	/**
	 * Column Info
	 * @return	acctCrAmt
	 */
	 public	 String	getAcctCrAmt() {
		 return	this.acctCrAmt;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt5
	*/
	public void	setSgmCtnt5( String	sgmCtnt5 ) {
		this.sgmCtnt5 =	sgmCtnt5;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt5
	 */
	 public	 String	getSgmCtnt5() {
		 return	this.sgmCtnt5;
	 } 
 	/**
	* Column Info
	* @param  glDt
	*/
	public void	setGlDt( String	glDt ) {
		this.glDt =	glDt;
	}
 
	/**
	 * Column Info
	 * @return	glDt
	 */
	 public	 String	getGlDt() {
		 return	this.glDt;
	 } 
 	/**
	* Column Info
	* @param  wrtfCd
	*/
	public void	setWrtfCd( String	wrtfCd ) {
		this.wrtfCd =	wrtfCd;
	}
 
	/**
	 * Column Info
	 * @return	wrtfCd
	 */
	 public	 String	getWrtfCd() {
		 return	this.wrtfCd;
	 } 
 	/**
	* Column Info
	* @param  otsSmryCd
	*/
	public void	setOtsSmryCd( String	otsSmryCd ) {
		this.otsSmryCd =	otsSmryCd;
	}
 
	/**
	 * Column Info
	 * @return	otsSmryCd
	 */
	 public	 String	getOtsSmryCd() {
		 return	this.otsSmryCd;
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
		setInpDrAmt(JSPUtil.getParameter(request,	prefix + "inp_dr_amt", ""));
		setRctOfcCd(JSPUtil.getParameter(request,	prefix + "rct_ofc_cd", ""));
		setRcvApplTpCd(JSPUtil.getParameter(request,	prefix + "rcv_appl_tp_cd", ""));
		setIfNo(JSPUtil.getParameter(request,	prefix + "if_no", ""));
		setChgTpCd(JSPUtil.getParameter(request,	prefix + "chg_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setDtrbSrcTpCd(JSPUtil.getParameter(request,	prefix + "dtrb_src_tp_cd", ""));
		setInpCrAmt(JSPUtil.getParameter(request,	prefix + "inp_cr_amt", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAcctXchRtDt(JSPUtil.getParameter(request,	prefix + "acct_xch_rt_dt", ""));
		setConvXchRt(JSPUtil.getParameter(request,	prefix + "conv_xch_rt", ""));
		setSgmCtnt2(JSPUtil.getParameter(request,	prefix + "sgm_ctnt2", ""));
		setAcctDrAmt(JSPUtil.getParameter(request,	prefix + "acct_dr_amt", ""));
		setSgmCtnt3(JSPUtil.getParameter(request,	prefix + "sgm_ctnt3", ""));
		setSgmCtnt1(JSPUtil.getParameter(request,	prefix + "sgm_ctnt1", ""));
		setSgmCtnt6(JSPUtil.getParameter(request,	prefix + "sgm_ctnt6", ""));
		setRctNo(JSPUtil.getParameter(request,	prefix + "rct_no", ""));
		setSgmCtnt4(JSPUtil.getParameter(request,	prefix + "sgm_ctnt4", ""));
		setAcctCrAmt(JSPUtil.getParameter(request,	prefix + "acct_cr_amt", ""));
		setSgmCtnt5(JSPUtil.getParameter(request,	prefix + "sgm_ctnt5", ""));
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setWrtfCd(JSPUtil.getParameter(request,	prefix + "wrtf_cd", ""));
		setOtsSmryCd(JSPUtil.getParameter(request,	prefix + "ots_smry_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return RCTViewAccountingListVO[]
	 */
	public RCTViewAccountingListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return RCTViewAccountingListVO[]
	 */
	public RCTViewAccountingListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RCTViewAccountingListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] inpDrAmt =	(JSPUtil.getParameter(request, prefix +	"inp_dr_amt".trim(),	length));
				String[] rctOfcCd =	(JSPUtil.getParameter(request, prefix +	"rct_ofc_cd".trim(),	length));
				String[] rcvApplTpCd =	(JSPUtil.getParameter(request, prefix +	"rcv_appl_tp_cd".trim(),	length));
				String[] ifNo =	(JSPUtil.getParameter(request, prefix +	"if_no".trim(),	length));
				String[] chgTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_tp_cd".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] dtrbSrcTpCd =	(JSPUtil.getParameter(request, prefix +	"dtrb_src_tp_cd".trim(),	length));
				String[] inpCrAmt =	(JSPUtil.getParameter(request, prefix +	"inp_cr_amt".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] acctXchRtDt =	(JSPUtil.getParameter(request, prefix +	"acct_xch_rt_dt".trim(),	length));
				String[] convXchRt =	(JSPUtil.getParameter(request, prefix +	"conv_xch_rt".trim(),	length));
				String[] sgmCtnt2 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt2".trim(),	length));
				String[] acctDrAmt =	(JSPUtil.getParameter(request, prefix +	"acct_dr_amt".trim(),	length));
				String[] sgmCtnt3 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt3".trim(),	length));
				String[] sgmCtnt1 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt1".trim(),	length));
				String[] sgmCtnt6 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt6".trim(),	length));
				String[] rctNo =	(JSPUtil.getParameter(request, prefix +	"rct_no".trim(),	length));
				String[] sgmCtnt4 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt4".trim(),	length));
				String[] acctCrAmt =	(JSPUtil.getParameter(request, prefix +	"acct_cr_amt".trim(),	length));
				String[] sgmCtnt5 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt5".trim(),	length));
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] wrtfCd =	(JSPUtil.getParameter(request, prefix +	"wrtf_cd".trim(),	length));
				String[] otsSmryCd =	(JSPUtil.getParameter(request, prefix +	"ots_smry_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	RCTViewAccountingListVO();
						if ( inpDrAmt[i] !=	null)
						model.setInpDrAmt( inpDrAmt[i]);
						if ( rctOfcCd[i] !=	null)
						model.setRctOfcCd( rctOfcCd[i]);
						if ( rcvApplTpCd[i] !=	null)
						model.setRcvApplTpCd( rcvApplTpCd[i]);
						if ( ifNo[i] !=	null)
						model.setIfNo( ifNo[i]);
						if ( chgTpCd[i] !=	null)
						model.setChgTpCd( chgTpCd[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( dtrbSrcTpCd[i] !=	null)
						model.setDtrbSrcTpCd( dtrbSrcTpCd[i]);
						if ( inpCrAmt[i] !=	null)
						model.setInpCrAmt( inpCrAmt[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( acctXchRtDt[i] !=	null)
						model.setAcctXchRtDt( acctXchRtDt[i]);
						if ( convXchRt[i] !=	null)
						model.setConvXchRt( convXchRt[i]);
						if ( sgmCtnt2[i] !=	null)
						model.setSgmCtnt2( sgmCtnt2[i]);
						if ( acctDrAmt[i] !=	null)
						model.setAcctDrAmt( acctDrAmt[i]);
						if ( sgmCtnt3[i] !=	null)
						model.setSgmCtnt3( sgmCtnt3[i]);
						if ( sgmCtnt1[i] !=	null)
						model.setSgmCtnt1( sgmCtnt1[i]);
						if ( sgmCtnt6[i] !=	null)
						model.setSgmCtnt6( sgmCtnt6[i]);
						if ( rctNo[i] !=	null)
						model.setRctNo( rctNo[i]);
						if ( sgmCtnt4[i] !=	null)
						model.setSgmCtnt4( sgmCtnt4[i]);
						if ( acctCrAmt[i] !=	null)
						model.setAcctCrAmt( acctCrAmt[i]);
						if ( sgmCtnt5[i] !=	null)
						model.setSgmCtnt5( sgmCtnt5[i]);
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( wrtfCd[i] !=	null)
						model.setWrtfCd( wrtfCd[i]);
						if ( otsSmryCd[i] !=	null)
						model.setOtsSmryCd( otsSmryCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getRCTViewAccountingListVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return RCTViewAccountingListVO[]
	 */
	public RCTViewAccountingListVO[]	 getRCTViewAccountingListVOs(){
		RCTViewAccountingListVO[] vos = (RCTViewAccountingListVO[])models.toArray(new	RCTViewAccountingListVO[models.size()]);
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
		this.inpDrAmt =	this.inpDrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcCd =	this.rctOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvApplTpCd =	this.rcvApplTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo =	this.ifNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd =	this.chgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbSrcTpCd =	this.dtrbSrcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpCrAmt =	this.inpCrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtDt =	this.acctXchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convXchRt =	this.convXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt2 =	this.sgmCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDrAmt =	this.acctDrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt3 =	this.sgmCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt1 =	this.sgmCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt6 =	this.sgmCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctNo =	this.rctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt4 =	this.sgmCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCrAmt =	this.acctCrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt5 =	this.sgmCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfCd =	this.wrtfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd =	this.otsSmryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}