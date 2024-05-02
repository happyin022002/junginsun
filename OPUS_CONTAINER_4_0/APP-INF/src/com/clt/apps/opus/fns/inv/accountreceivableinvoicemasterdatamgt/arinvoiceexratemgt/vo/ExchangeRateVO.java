/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ExchangeRateVO.java
 *@FileTitle : ExchangeRateVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.01.02
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.01.02  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo;

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
public class ExchangeRateVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ExchangeRateVO>  models =	new	ArrayList<ExchangeRateVO>();


	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 fmDt   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 toDt   =  null;
	/*	Column Info	*/
	private  String	 chgCurrCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 portCd   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 ivsXchRt   =  null;
	/*	Column Info	*/
	private  String	 xchRtDt   =  null;
	/*	Column Info	*/
	private  String	 tmpIbFlag   =  null;
	/*	Column Info	*/
	private  String	 xchRtTmpSeq   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 xchKeyCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ExchangeRateVO(){}

	public ExchangeRateVO(String vslCd,String xchRtTpCd,String fmDt,String svcScpCd,String loclCurrCd,String skdVoyNo,String custSeq,String ioBndCd,String skdDirCd,String pagerows,String toDt,String chgCurrCd,String ibflag,String portCd,String invXchRt,String custCntCd,String arOfcCd,String ivsXchRt,String xchRtDt,String tmpIbFlag,String xchRtTmpSeq,String usrId,String xchKeyCd)	{
		this.vslCd  = vslCd ;
		this.xchRtTpCd  = xchRtTpCd ;
		this.fmDt  = fmDt ;
		this.svcScpCd  = svcScpCd ;
		this.loclCurrCd  = loclCurrCd ;
		this.skdVoyNo  = skdVoyNo ;
		this.custSeq  = custSeq ;
		this.ioBndCd  = ioBndCd ;
		this.skdDirCd  = skdDirCd ;
		this.pagerows  = pagerows ;
		this.toDt  = toDt ;
		this.chgCurrCd  = chgCurrCd ;
		this.ibflag  = ibflag ;
		this.portCd  = portCd ;
		this.invXchRt  = invXchRt ;
		this.custCntCd  = custCntCd ;
		this.arOfcCd  = arOfcCd ;
		this.ivsXchRt  = ivsXchRt ;
		this.xchRtDt  = xchRtDt ;
		this.tmpIbFlag  = tmpIbFlag ;
		this.xchRtTmpSeq  = xchRtTmpSeq ;
		this.usrId  = usrId ;
		this.xchKeyCd  = xchKeyCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());		
		this.hashColumns.put("fm_dt", getFmDt());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("to_dt", getToDt());		
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("port_cd", getPortCd());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("ivs_xch_rt", getIvsXchRt());		
		this.hashColumns.put("xch_rt_dt", getXchRtDt());		
		this.hashColumns.put("tmp_ib_flag", getTmpIbFlag());		
		this.hashColumns.put("xch_rt_tmp_seq", getXchRtTmpSeq());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("xch_key_cd", getXchKeyCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("ivs_xch_rt", "ivsXchRt");
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("tmp_ib_flag", "tmpIbFlag");
		this.hashFields.put("xch_rt_tmp_seq", "xchRtTmpSeq");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("xch_key_cd", "xchKeyCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  xchRtTpCd
	*/
	public void	setXchRtTpCd( String	xchRtTpCd ) {
		this.xchRtTpCd =	xchRtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	xchRtTpCd
	 */
	 public	 String	getXchRtTpCd() {
		 return	this.xchRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  fmDt
	*/
	public void	setFmDt( String	fmDt ) {
		this.fmDt =	fmDt;
	}
 
	/**
	 * Column Info
	 * @return	fmDt
	 */
	 public	 String	getFmDt() {
		 return	this.fmDt;
	 } 
 	/**
	* Column Info
	* @param  svcScpCd
	*/
	public void	setSvcScpCd( String	svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 
	/**
	 * Column Info
	 * @return	svcScpCd
	 */
	 public	 String	getSvcScpCd() {
		 return	this.svcScpCd;
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
	* @param  ioBndCd
	*/
	public void	setIoBndCd( String	ioBndCd ) {
		this.ioBndCd =	ioBndCd;
	}
 
	/**
	 * Column Info
	 * @return	ioBndCd
	 */
	 public	 String	getIoBndCd() {
		 return	this.ioBndCd;
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
	* @param  toDt
	*/
	public void	setToDt( String	toDt ) {
		this.toDt =	toDt;
	}
 
	/**
	 * Column Info
	 * @return	toDt
	 */
	 public	 String	getToDt() {
		 return	this.toDt;
	 } 
 	/**
	* Column Info
	* @param  chgCurrCd
	*/
	public void	setChgCurrCd( String	chgCurrCd ) {
		this.chgCurrCd =	chgCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	chgCurrCd
	 */
	 public	 String	getChgCurrCd() {
		 return	this.chgCurrCd;
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
	* @param  portCd
	*/
	public void	setPortCd( String	portCd ) {
		this.portCd =	portCd;
	}
 
	/**
	 * Column Info
	 * @return	portCd
	 */
	 public	 String	getPortCd() {
		 return	this.portCd;
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
	* @param  ivsXchRt
	*/
	public void	setIvsXchRt( String	ivsXchRt ) {
		this.ivsXchRt =	ivsXchRt;
	}
 
	/**
	 * Column Info
	 * @return	ivsXchRt
	 */
	 public	 String	getIvsXchRt() {
		 return	this.ivsXchRt;
	 } 
 	/**
	* Column Info
	* @param  xchRtDt
	*/
	public void	setXchRtDt( String	xchRtDt ) {
		this.xchRtDt =	xchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	xchRtDt
	 */
	 public	 String	getXchRtDt() {
		 return	this.xchRtDt;
	 } 
 	/**
	* Column Info
	* @param  tmpIbFlag
	*/
	public void	setTmpIbFlag( String	tmpIbFlag ) {
		this.tmpIbFlag =	tmpIbFlag;
	}
 
	/**
	 * Column Info
	 * @return	tmpIbFlag
	 */
	 public	 String	getTmpIbFlag() {
		 return	this.tmpIbFlag;
	 } 
 	/**
	* Column Info
	* @param  xchRtTmpSeq
	*/
	public void	setXchRtTmpSeq( String	xchRtTmpSeq ) {
		this.xchRtTmpSeq =	xchRtTmpSeq;
	}
 
	/**
	 * Column Info
	 * @return	xchRtTmpSeq
	 */
	 public	 String	getXchRtTmpSeq() {
		 return	this.xchRtTmpSeq;
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
	* @param  xchKeyCd
	*/
	public void	setXchKeyCd( String	xchKeyCd ) {
		this.xchKeyCd =	xchKeyCd;
	}
 
	/**
	 * Column Info
	 * @return	xchKeyCd
	 */
	 public	 String	getXchKeyCd() {
		 return	this.xchKeyCd;
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
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setXchRtTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_cd", ""));
		setFmDt(JSPUtil.getParameter(request,	prefix + "fm_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request,	prefix + "to_dt", ""));
		setChgCurrCd(JSPUtil.getParameter(request,	prefix + "chg_curr_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setIvsXchRt(JSPUtil.getParameter(request,	prefix + "ivs_xch_rt", ""));
		setXchRtDt(JSPUtil.getParameter(request,	prefix + "xch_rt_dt", ""));
		setTmpIbFlag(JSPUtil.getParameter(request,	prefix + "tmp_ib_flag", ""));
		setXchRtTmpSeq(JSPUtil.getParameter(request,	prefix + "xch_rt_tmp_seq", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setXchKeyCd(JSPUtil.getParameter(request,	prefix + "xch_key_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ExchangeRateVO[]
	 */
	public ExchangeRateVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ExchangeRateVO[]
	 */
	public ExchangeRateVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ExchangeRateVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] xchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_cd".trim(),	length));
				String[] fmDt =	(JSPUtil.getParameter(request, prefix +	"fm_dt".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] toDt =	(JSPUtil.getParameter(request, prefix +	"to_dt".trim(),	length));
				String[] chgCurrCd =	(JSPUtil.getParameter(request, prefix +	"chg_curr_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] ivsXchRt =	(JSPUtil.getParameter(request, prefix +	"ivs_xch_rt".trim(),	length));
				String[] xchRtDt =	(JSPUtil.getParameter(request, prefix +	"xch_rt_dt".trim(),	length));
				String[] tmpIbFlag =	(JSPUtil.getParameter(request, prefix +	"tmp_ib_flag".trim(),	length));
				String[] xchRtTmpSeq =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tmp_seq".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] xchKeyCd =	(JSPUtil.getParameter(request, prefix +	"xch_key_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ExchangeRateVO();
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( xchRtTpCd[i] !=	null)
						model.setXchRtTpCd( xchRtTpCd[i]);
						if ( fmDt[i] !=	null)
						model.setFmDt( fmDt[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( toDt[i] !=	null)
						model.setToDt( toDt[i]);
						if ( chgCurrCd[i] !=	null)
						model.setChgCurrCd( chgCurrCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( portCd[i] !=	null)
						model.setPortCd( portCd[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( ivsXchRt[i] !=	null)
						model.setIvsXchRt( ivsXchRt[i]);
						if ( xchRtDt[i] !=	null)
						model.setXchRtDt( xchRtDt[i]);
						if ( tmpIbFlag[i] !=	null)
						model.setTmpIbFlag( tmpIbFlag[i]);
						if ( xchRtTmpSeq[i] !=	null)
						model.setXchRtTmpSeq( xchRtTmpSeq[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( xchKeyCd[i] !=	null)
						model.setXchKeyCd( xchKeyCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getExchangeRateVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ExchangeRateVO[]
	 */
	public ExchangeRateVO[]	 getExchangeRateVOs(){
		ExchangeRateVO[] vos = (ExchangeRateVO[])models.toArray(new	ExchangeRateVO[models.size()]);
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
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd =	this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt =	this.fmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt =	this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd =	this.chgCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivsXchRt =	this.ivsXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDt =	this.xchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpIbFlag =	this.tmpIbFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTmpSeq =	this.xchRtTmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchKeyCd =	this.xchKeyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}