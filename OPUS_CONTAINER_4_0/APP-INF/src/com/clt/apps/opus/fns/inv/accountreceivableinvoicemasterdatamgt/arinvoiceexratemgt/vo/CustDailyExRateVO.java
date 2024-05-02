/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CustDailyExRateVO.java
 *@FileTitle : CustDailyExRateVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.23
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.23  
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
public class CustDailyExRateVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CustDailyExRateVO>  models =	new	ArrayList<CustDailyExRateVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 xchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtRvsFlg   =  null;
	/*	Column Info	*/
	private  String	 fmDt   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 checkDigit   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 toDt   =  null;
	/*	Column Info	*/
	private  String	 chgCurrCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 currNm   =  null;
	/*	Column Info	*/
	private  String	 ivsXchRt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 cngRmk   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 delChk   =  null;
	/*	Column Info	*/
	private  String	 tmpIbFlag   =  null;
	/*	Column Info	*/
	private  String	 vvdCnt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CustDailyExRateVO(){}

	public CustDailyExRateVO(String updDt,String xchRtTpCd,String xchRtRvsFlg,String fmDt,String loclCurrCd,String checkDigit,String creDt,String custSeq,String ioBndCd,String arOfcCd,String pagerows,String toDt,String chgCurrCd,String creUsrId,String ibflag,String currNm,String ivsXchRt,String updUsrId,String custCntCd,String invXchRt,String cngRmk,String usrId,String delChk,String tmpIbFlag,String vvdCnt)	{
		this.updDt  = updDt ;
		this.xchRtTpCd  = xchRtTpCd ;
		this.xchRtRvsFlg  = xchRtRvsFlg ;
		this.fmDt  = fmDt ;
		this.loclCurrCd  = loclCurrCd ;
		this.checkDigit  = checkDigit ;
		this.creDt  = creDt ;
		this.custSeq  = custSeq ;
		this.ioBndCd  = ioBndCd ;
		this.arOfcCd  = arOfcCd ;
		this.pagerows  = pagerows ;
		this.toDt  = toDt ;
		this.chgCurrCd  = chgCurrCd ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.currNm  = currNm ;
		this.ivsXchRt  = ivsXchRt ;
		this.updUsrId  = updUsrId ;
		this.custCntCd  = custCntCd ;
		this.invXchRt  = invXchRt ;
		this.cngRmk  = cngRmk ;
		this.usrId  = usrId ;
		this.delChk  = delChk ;
		this.tmpIbFlag  = tmpIbFlag ;
		this.vvdCnt  = vvdCnt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());		
		this.hashColumns.put("xch_rt_rvs_flg", getXchRtRvsFlg());		
		this.hashColumns.put("fm_dt", getFmDt());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("check_digit", getCheckDigit());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("to_dt", getToDt());		
		this.hashColumns.put("chg_curr_cd", getChgCurrCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("curr_nm", getCurrNm());		
		this.hashColumns.put("ivs_xch_rt", getIvsXchRt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("cng_rmk", getCngRmk());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("del_chk", getDelChk());		
		this.hashColumns.put("tmp_ib_flag", getTmpIbFlag());		
		this.hashColumns.put("vvd_cnt", getVvdCnt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("xch_rt_rvs_flg", "xchRtRvsFlg");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("check_digit", "checkDigit");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("chg_curr_cd", "chgCurrCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_nm", "currNm");
		this.hashFields.put("ivs_xch_rt", "ivsXchRt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("cng_rmk", "cngRmk");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("tmp_ib_flag", "tmpIbFlag");
		this.hashFields.put("vvd_cnt", "vvdCnt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  xchRtRvsFlg
	*/
	public void	setXchRtRvsFlg( String	xchRtRvsFlg ) {
		this.xchRtRvsFlg =	xchRtRvsFlg;
	}
 
	/**
	 * Column Info
	 * @return	xchRtRvsFlg
	 */
	 public	 String	getXchRtRvsFlg() {
		 return	this.xchRtRvsFlg;
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
	* @param  checkDigit
	*/
	public void	setCheckDigit( String	checkDigit ) {
		this.checkDigit =	checkDigit;
	}
 
	/**
	 * Column Info
	 * @return	checkDigit
	 */
	 public	 String	getCheckDigit() {
		 return	this.checkDigit;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	 String	getCreDt() {
		 return	this.creDt;
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
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
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
	* @param  currNm
	*/
	public void	setCurrNm( String	currNm ) {
		this.currNm =	currNm;
	}
 
	/**
	 * Column Info
	 * @return	currNm
	 */
	 public	 String	getCurrNm() {
		 return	this.currNm;
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
	* @param  cngRmk
	*/
	public void	setCngRmk( String	cngRmk ) {
		this.cngRmk =	cngRmk;
	}
 
	/**
	 * Column Info
	 * @return	cngRmk
	 */
	 public	 String	getCngRmk() {
		 return	this.cngRmk;
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
	* @param  delChk
	*/
	public void	setDelChk( String	delChk ) {
		this.delChk =	delChk;
	}
 
	/**
	 * Column Info
	 * @return	delChk
	 */
	 public	 String	getDelChk() {
		 return	this.delChk;
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
	* @param  vvdCnt
	*/
	public void	setVvdCnt( String	vvdCnt ) {
		this.vvdCnt =	vvdCnt;
	}
 
	/**
	 * Column Info
	 * @return	vvdCnt
	 */
	 public	 String	getVvdCnt() {
		 return	this.vvdCnt;
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
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setXchRtTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_cd", ""));
		setXchRtRvsFlg(JSPUtil.getParameter(request,	prefix + "xch_rt_rvs_flg", ""));
		setFmDt(JSPUtil.getParameter(request,	prefix + "fm_dt", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setCheckDigit(JSPUtil.getParameter(request,	prefix + "check_digit", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setToDt(JSPUtil.getParameter(request,	prefix + "to_dt", ""));
		setChgCurrCd(JSPUtil.getParameter(request,	prefix + "chg_curr_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCurrNm(JSPUtil.getParameter(request,	prefix + "curr_nm", ""));
		setIvsXchRt(JSPUtil.getParameter(request,	prefix + "ivs_xch_rt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setCngRmk(JSPUtil.getParameter(request,	prefix + "cng_rmk", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setDelChk(JSPUtil.getParameter(request,	prefix + "del_chk", ""));
		setTmpIbFlag(JSPUtil.getParameter(request,	prefix + "tmp_ib_flag", ""));
		setVvdCnt(JSPUtil.getParameter(request,	prefix + "vvd_cnt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustDailyExRateVO[]
	 */
	public CustDailyExRateVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustDailyExRateVO[]
	 */
	public CustDailyExRateVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CustDailyExRateVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] xchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_cd".trim(),	length));
				String[] xchRtRvsFlg =	(JSPUtil.getParameter(request, prefix +	"xch_rt_rvs_flg".trim(),	length));
				String[] fmDt =	(JSPUtil.getParameter(request, prefix +	"fm_dt".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] checkDigit =	(JSPUtil.getParameter(request, prefix +	"check_digit".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] toDt =	(JSPUtil.getParameter(request, prefix +	"to_dt".trim(),	length));
				String[] chgCurrCd =	(JSPUtil.getParameter(request, prefix +	"chg_curr_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] currNm =	(JSPUtil.getParameter(request, prefix +	"curr_nm".trim(),	length));
				String[] ivsXchRt =	(JSPUtil.getParameter(request, prefix +	"ivs_xch_rt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] cngRmk =	(JSPUtil.getParameter(request, prefix +	"cng_rmk".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] delChk =	(JSPUtil.getParameter(request, prefix +	"del_chk".trim(),	length));
				String[] tmpIbFlag =	(JSPUtil.getParameter(request, prefix +	"tmp_ib_flag".trim(),	length));
				String[] vvdCnt =	(JSPUtil.getParameter(request, prefix +	"vvd_cnt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CustDailyExRateVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( xchRtTpCd[i] !=	null)
						model.setXchRtTpCd( xchRtTpCd[i]);
						if ( xchRtRvsFlg[i] !=	null)
						model.setXchRtRvsFlg( xchRtRvsFlg[i]);
						if ( fmDt[i] !=	null)
						model.setFmDt( fmDt[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( checkDigit[i] !=	null)
						model.setCheckDigit( checkDigit[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( toDt[i] !=	null)
						model.setToDt( toDt[i]);
						if ( chgCurrCd[i] !=	null)
						model.setChgCurrCd( chgCurrCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( currNm[i] !=	null)
						model.setCurrNm( currNm[i]);
						if ( ivsXchRt[i] !=	null)
						model.setIvsXchRt( ivsXchRt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( cngRmk[i] !=	null)
						model.setCngRmk( cngRmk[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( delChk[i] !=	null)
						model.setDelChk( delChk[i]);
						if ( tmpIbFlag[i] !=	null)
						model.setTmpIbFlag( tmpIbFlag[i]);
						if ( vvdCnt[i] !=	null)
						model.setVvdCnt( vvdCnt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCustDailyExRateVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CustDailyExRateVO[]
	 */
	public CustDailyExRateVO[]	 getCustDailyExRateVOs(){
		CustDailyExRateVO[] vos = (CustDailyExRateVO[])models.toArray(new	CustDailyExRateVO[models.size()]);
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
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd =	this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtRvsFlg =	this.xchRtRvsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt =	this.fmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.checkDigit =	this.checkDigit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt =	this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCurrCd =	this.chgCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currNm =	this.currNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ivsXchRt =	this.ivsXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cngRmk =	this.cngRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk =	this.delChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpIbFlag =	this.tmpIbFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCnt =	this.vvdCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}