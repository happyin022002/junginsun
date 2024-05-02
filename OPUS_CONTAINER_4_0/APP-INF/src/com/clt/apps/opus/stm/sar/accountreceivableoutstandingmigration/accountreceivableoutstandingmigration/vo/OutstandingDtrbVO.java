/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OutstandingDtrbVO.java
 *@FileTitle : OutstandingDtrbVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.02.24
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.02.24  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo;

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
public class OutstandingDtrbVO	extends	 AbstractValueObject
{
 
	private	 static final long serialVersionUID = 1L;

	private	 Collection<OutstandingDtrbVO>  models =	new	ArrayList<OutstandingDtrbVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 chgTpCd   =  null;
	/*	Column Info	*/
	private  String	 inpDrAmt   =  null;
	/*	Column Info	*/
	private  String	 shpToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 acctClssCd   =  null;
	/*	Column Info	*/
	private  String	 bilToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 glTrnsDt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 bilToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 otsCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 inpCrAmt   =  null;
	/*	Column Info	*/
	private  String	 acctXchRtLvl   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 shpToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 convXchRt   =  null;
	/*	Column Info	*/
	private  String	 acctXchRtDt   =  null;
	/*	Column Info	*/
	private  String	 glTrnsSeq   =  null;
	/*	Column Info	*/
	private  String	 acctDrAmt   =  null;
	/*	Column Info	*/
	private  String	 otsHisSeq   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 acctCrAmt   =  null;
	/*	Column Info	*/
	private  String	 dtrbCnt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public OutstandingDtrbVO(){}

	public OutstandingDtrbVO(String updDt,String chgTpCd,String inpDrAmt,String shpToCustSeq,String currCd,String acctClssCd,String bilToCustCntCd,String glTrnsDt,String creDt,String bilToCustSeq,String otsCdCmbSeq,String inpCrAmt,String acctXchRtLvl,String pagerows,String creUsrId,String ibflag,String shpToCustCntCd,String convXchRt,String acctXchRtDt,String glTrnsSeq,String acctDrAmt,String otsHisSeq,String updUsrId,String acctCrAmt,String dtrbCnt)	{
		this.updDt  = updDt ;
		this.chgTpCd  = chgTpCd ;
		this.inpDrAmt  = inpDrAmt ;
		this.shpToCustSeq  = shpToCustSeq ;
		this.currCd  = currCd ;
		this.acctClssCd  = acctClssCd ;
		this.bilToCustCntCd  = bilToCustCntCd ;
		this.glTrnsDt  = glTrnsDt ;
		this.creDt  = creDt ;
		this.bilToCustSeq  = bilToCustSeq ;
		this.otsCdCmbSeq  = otsCdCmbSeq ;
		this.inpCrAmt  = inpCrAmt ;
		this.acctXchRtLvl  = acctXchRtLvl ;
		this.pagerows  = pagerows ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.shpToCustCntCd  = shpToCustCntCd ;
		this.convXchRt  = convXchRt ;
		this.acctXchRtDt  = acctXchRtDt ;
		this.glTrnsSeq  = glTrnsSeq ;
		this.acctDrAmt  = acctDrAmt ;
		this.otsHisSeq  = otsHisSeq ;
		this.updUsrId  = updUsrId ;
		this.acctCrAmt  = acctCrAmt ;
		this.dtrbCnt  = dtrbCnt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("chg_tp_cd", getChgTpCd());		
		this.hashColumns.put("inp_dr_amt", getInpDrAmt());		
		this.hashColumns.put("shp_to_cust_seq", getShpToCustSeq());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("acct_clss_cd", getAcctClssCd());		
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());		
		this.hashColumns.put("gl_trns_dt", getGlTrnsDt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());		
		this.hashColumns.put("ots_cd_cmb_seq", getOtsCdCmbSeq());		
		this.hashColumns.put("inp_cr_amt", getInpCrAmt());		
		this.hashColumns.put("acct_xch_rt_lvl", getAcctXchRtLvl());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("shp_to_cust_cnt_cd", getShpToCustCntCd());		
		this.hashColumns.put("conv_xch_rt", getConvXchRt());		
		this.hashColumns.put("acct_xch_rt_dt", getAcctXchRtDt());		
		this.hashColumns.put("gl_trns_seq", getGlTrnsSeq());		
		this.hashColumns.put("acct_dr_amt", getAcctDrAmt());		
		this.hashColumns.put("ots_his_seq", getOtsHisSeq());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("acct_cr_amt", getAcctCrAmt());		
		this.hashColumns.put("dtrb_cnt", getDtrbCnt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("inp_dr_amt", "inpDrAmt");
		this.hashFields.put("shp_to_cust_seq", "shpToCustSeq");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("acct_clss_cd", "acctClssCd");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("gl_trns_dt", "glTrnsDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("ots_cd_cmb_seq", "otsCdCmbSeq");
		this.hashFields.put("inp_cr_amt", "inpCrAmt");
		this.hashFields.put("acct_xch_rt_lvl", "acctXchRtLvl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("shp_to_cust_cnt_cd", "shpToCustCntCd");
		this.hashFields.put("conv_xch_rt", "convXchRt");
		this.hashFields.put("acct_xch_rt_dt", "acctXchRtDt");
		this.hashFields.put("gl_trns_seq", "glTrnsSeq");
		this.hashFields.put("acct_dr_amt", "acctDrAmt");
		this.hashFields.put("ots_his_seq", "otsHisSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("acct_cr_amt", "acctCrAmt");
		this.hashFields.put("dtrb_cnt", "dtrbCnt");
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
	* @param  shpToCustSeq
	*/
	public void	setShpToCustSeq( String	shpToCustSeq ) {
		this.shpToCustSeq =	shpToCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	shpToCustSeq
	 */
	 public	 String	getShpToCustSeq() {
		 return	this.shpToCustSeq;
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
	* @param  acctClssCd
	*/
	public void	setAcctClssCd( String	acctClssCd ) {
		this.acctClssCd =	acctClssCd;
	}
 
	/**
	 * Column Info
	 * @return	acctClssCd
	 */
	 public	 String	getAcctClssCd() {
		 return	this.acctClssCd;
	 } 
 	/**
	* Column Info
	* @param  bilToCustCntCd
	*/
	public void	setBilToCustCntCd( String	bilToCustCntCd ) {
		this.bilToCustCntCd =	bilToCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	bilToCustCntCd
	 */
	 public	 String	getBilToCustCntCd() {
		 return	this.bilToCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  glTrnsDt
	*/
	public void	setGlTrnsDt( String	glTrnsDt ) {
		this.glTrnsDt =	glTrnsDt;
	}
 
	/**
	 * Column Info
	 * @return	glTrnsDt
	 */
	 public	 String	getGlTrnsDt() {
		 return	this.glTrnsDt;
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
	* @param  bilToCustSeq
	*/
	public void	setBilToCustSeq( String	bilToCustSeq ) {
		this.bilToCustSeq =	bilToCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	bilToCustSeq
	 */
	 public	 String	getBilToCustSeq() {
		 return	this.bilToCustSeq;
	 } 
 	/**
	* Column Info
	* @param  otsCdCmbSeq
	*/
	public void	setOtsCdCmbSeq( String	otsCdCmbSeq ) {
		this.otsCdCmbSeq =	otsCdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	otsCdCmbSeq
	 */
	 public	 String	getOtsCdCmbSeq() {
		 return	this.otsCdCmbSeq;
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
	* @param  acctXchRtLvl
	*/
	public void	setAcctXchRtLvl( String	acctXchRtLvl ) {
		this.acctXchRtLvl =	acctXchRtLvl;
	}
 
	/**
	 * Column Info
	 * @return	acctXchRtLvl
	 */
	 public	 String	getAcctXchRtLvl() {
		 return	this.acctXchRtLvl;
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
	* @param  shpToCustCntCd
	*/
	public void	setShpToCustCntCd( String	shpToCustCntCd ) {
		this.shpToCustCntCd =	shpToCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	shpToCustCntCd
	 */
	 public	 String	getShpToCustCntCd() {
		 return	this.shpToCustCntCd;
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
	* @param  glTrnsSeq
	*/
	public void	setGlTrnsSeq( String	glTrnsSeq ) {
		this.glTrnsSeq =	glTrnsSeq;
	}
 
	/**
	 * Column Info
	 * @return	glTrnsSeq
	 */
	 public	 String	getGlTrnsSeq() {
		 return	this.glTrnsSeq;
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
	* @param  otsHisSeq
	*/
	public void	setOtsHisSeq( String	otsHisSeq ) {
		this.otsHisSeq =	otsHisSeq;
	}
 
	/**
	 * Column Info
	 * @return	otsHisSeq
	 */
	 public	 String	getOtsHisSeq() {
		 return	this.otsHisSeq;
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
	* @param  dtrbCnt
	*/
	public void	setDtrbCnt( String	dtrbCnt ) {
		this.dtrbCnt =	dtrbCnt;
	}
 
	/**
	 * Column Info
	 * @return	dtrbCnt
	 */
	 public	 String	getDtrbCnt() {
		 return	this.dtrbCnt;
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
		setChgTpCd(JSPUtil.getParameter(request,	prefix + "chg_tp_cd", ""));
		setInpDrAmt(JSPUtil.getParameter(request,	prefix + "inp_dr_amt", ""));
		setShpToCustSeq(JSPUtil.getParameter(request,	prefix + "shp_to_cust_seq", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setAcctClssCd(JSPUtil.getParameter(request,	prefix + "acct_clss_cd", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request,	prefix + "bil_to_cust_cnt_cd", ""));
		setGlTrnsDt(JSPUtil.getParameter(request,	prefix + "gl_trns_dt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setBilToCustSeq(JSPUtil.getParameter(request,	prefix + "bil_to_cust_seq", ""));
		setOtsCdCmbSeq(JSPUtil.getParameter(request,	prefix + "ots_cd_cmb_seq", ""));
		setInpCrAmt(JSPUtil.getParameter(request,	prefix + "inp_cr_amt", ""));
		setAcctXchRtLvl(JSPUtil.getParameter(request,	prefix + "acct_xch_rt_lvl", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setShpToCustCntCd(JSPUtil.getParameter(request,	prefix + "shp_to_cust_cnt_cd", ""));
		setConvXchRt(JSPUtil.getParameter(request,	prefix + "conv_xch_rt", ""));
		setAcctXchRtDt(JSPUtil.getParameter(request,	prefix + "acct_xch_rt_dt", ""));
		setGlTrnsSeq(JSPUtil.getParameter(request,	prefix + "gl_trns_seq", ""));
		setAcctDrAmt(JSPUtil.getParameter(request,	prefix + "acct_dr_amt", ""));
		setOtsHisSeq(JSPUtil.getParameter(request,	prefix + "ots_his_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setAcctCrAmt(JSPUtil.getParameter(request,	prefix + "acct_cr_amt", ""));
		setDtrbCnt(JSPUtil.getParameter(request,	prefix + "dtrb_cnt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutstandingDtrbVO[]
	 */
	public OutstandingDtrbVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return OutstandingDtrbVO[]
	 */
	public OutstandingDtrbVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		OutstandingDtrbVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] chgTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_tp_cd".trim(),	length));
				String[] inpDrAmt =	(JSPUtil.getParameter(request, prefix +	"inp_dr_amt".trim(),	length));
				String[] shpToCustSeq =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_seq".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] acctClssCd =	(JSPUtil.getParameter(request, prefix +	"acct_clss_cd".trim(),	length));
				String[] bilToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_cnt_cd".trim(),	length));
				String[] glTrnsDt =	(JSPUtil.getParameter(request, prefix +	"gl_trns_dt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] bilToCustSeq =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_seq".trim(),	length));
				String[] otsCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"ots_cd_cmb_seq".trim(),	length));
				String[] inpCrAmt =	(JSPUtil.getParameter(request, prefix +	"inp_cr_amt".trim(),	length));
				String[] acctXchRtLvl =	(JSPUtil.getParameter(request, prefix +	"acct_xch_rt_lvl".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] shpToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_cnt_cd".trim(),	length));
				String[] convXchRt =	(JSPUtil.getParameter(request, prefix +	"conv_xch_rt".trim(),	length));
				String[] acctXchRtDt =	(JSPUtil.getParameter(request, prefix +	"acct_xch_rt_dt".trim(),	length));
				String[] glTrnsSeq =	(JSPUtil.getParameter(request, prefix +	"gl_trns_seq".trim(),	length));
				String[] acctDrAmt =	(JSPUtil.getParameter(request, prefix +	"acct_dr_amt".trim(),	length));
				String[] otsHisSeq =	(JSPUtil.getParameter(request, prefix +	"ots_his_seq".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] acctCrAmt =	(JSPUtil.getParameter(request, prefix +	"acct_cr_amt".trim(),	length));
				String[] dtrbCnt =	(JSPUtil.getParameter(request, prefix +	"dtrb_cnt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	OutstandingDtrbVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( chgTpCd[i] !=	null)
						model.setChgTpCd( chgTpCd[i]);
						if ( inpDrAmt[i] !=	null)
						model.setInpDrAmt( inpDrAmt[i]);
						if ( shpToCustSeq[i] !=	null)
						model.setShpToCustSeq( shpToCustSeq[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( acctClssCd[i] !=	null)
						model.setAcctClssCd( acctClssCd[i]);
						if ( bilToCustCntCd[i] !=	null)
						model.setBilToCustCntCd( bilToCustCntCd[i]);
						if ( glTrnsDt[i] !=	null)
						model.setGlTrnsDt( glTrnsDt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( bilToCustSeq[i] !=	null)
						model.setBilToCustSeq( bilToCustSeq[i]);
						if ( otsCdCmbSeq[i] !=	null)
						model.setOtsCdCmbSeq( otsCdCmbSeq[i]);
						if ( inpCrAmt[i] !=	null)
						model.setInpCrAmt( inpCrAmt[i]);
						if ( acctXchRtLvl[i] !=	null)
						model.setAcctXchRtLvl( acctXchRtLvl[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( shpToCustCntCd[i] !=	null)
						model.setShpToCustCntCd( shpToCustCntCd[i]);
						if ( convXchRt[i] !=	null)
						model.setConvXchRt( convXchRt[i]);
						if ( acctXchRtDt[i] !=	null)
						model.setAcctXchRtDt( acctXchRtDt[i]);
						if ( glTrnsSeq[i] !=	null)
						model.setGlTrnsSeq( glTrnsSeq[i]);
						if ( acctDrAmt[i] !=	null)
						model.setAcctDrAmt( acctDrAmt[i]);
						if ( otsHisSeq[i] !=	null)
						model.setOtsHisSeq( otsHisSeq[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( acctCrAmt[i] !=	null)
						model.setAcctCrAmt( acctCrAmt[i]);
						if ( dtrbCnt[i] !=	null)
						model.setDtrbCnt( dtrbCnt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getOutstandingDtrbVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return OutstandingDtrbVO[]
	 */
	public OutstandingDtrbVO[]	 getOutstandingDtrbVOs(){
		OutstandingDtrbVO[] vos = (OutstandingDtrbVO[])models.toArray(new	OutstandingDtrbVO[models.size()]);
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
		this.chgTpCd =	this.chgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpDrAmt =	this.inpDrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustSeq =	this.shpToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctClssCd =	this.acctClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd =	this.bilToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glTrnsDt =	this.glTrnsDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq =	this.bilToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCdCmbSeq =	this.otsCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpCrAmt =	this.inpCrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtLvl =	this.acctXchRtLvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustCntCd =	this.shpToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convXchRt =	this.convXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctXchRtDt =	this.acctXchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glTrnsSeq =	this.glTrnsSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDrAmt =	this.acctDrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsHisSeq =	this.otsHisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCrAmt =	this.acctCrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtrbCnt =	this.dtrbCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}