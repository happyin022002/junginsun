/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : INVMainInfoForIssueVO.java
 *@FileTitle : INVMainInfoForIssueVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.12
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.06.12  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
public class INVMainInfoForIssueVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<INVMainInfoForIssueVO>  models =	new	ArrayList<INVMainInfoForIssueVO>();


	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 usdXchRt   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 repCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 invCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 actCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 portCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 invCustSeq   =  null;
	/*	Column Info	*/
	private  String	 actCustSeq   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 invSplitCd   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 revTpSrcCd   =  null;
	/*	Column Info	*/
	private  String	 repCustSeq   =  null;
	/*	Column Info	*/
	private  String	 userId   =  null;
	/*	Column Info	*/
	private  String	 wrkNo   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invDeltDivCd   =  null;
	/*	Column Info	*/
	private  String	 bfrInvCurrCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public INVMainInfoForIssueVO(){}

	public INVMainInfoForIssueVO(String porCd,String vslCd,String svcScpCd,String usdXchRt,String sailArrDt,String pagerows,String ibflag,String polCd,String repCustCntCd,String invCustCntCd,String arIfNo,String actCustCntCd,String portCd,String updUsrId,String blSrcNo,String invCustSeq,String actCustSeq,String delCd,String skdVoyNo,String ioBndCd,String arOfcCd,String skdDirCd,String invSplitCd,String podCd,String creUsrId,String bkgNo,String revTpSrcCd,String repCustSeq,String userId,String wrkNo,String invCurrCd,String invDeltDivCd,String bfrInvCurrCd)	{
		this.porCd  = porCd ;
		this.vslCd  = vslCd ;
		this.svcScpCd  = svcScpCd ;
		this.usdXchRt  = usdXchRt ;
		this.sailArrDt  = sailArrDt ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.polCd  = polCd ;
		this.repCustCntCd  = repCustCntCd ;
		this.invCustCntCd  = invCustCntCd ;
		this.arIfNo  = arIfNo ;
		this.actCustCntCd  = actCustCntCd ;
		this.portCd  = portCd ;
		this.updUsrId  = updUsrId ;
		this.blSrcNo  = blSrcNo ;
		this.invCustSeq  = invCustSeq ;
		this.actCustSeq  = actCustSeq ;
		this.delCd  = delCd ;
		this.skdVoyNo  = skdVoyNo ;
		this.ioBndCd  = ioBndCd ;
		this.arOfcCd  = arOfcCd ;
		this.skdDirCd  = skdDirCd ;
		this.invSplitCd  = invSplitCd ;
		this.podCd  = podCd ;
		this.creUsrId  = creUsrId ;
		this.bkgNo  = bkgNo ;
		this.revTpSrcCd  = revTpSrcCd ;
		this.repCustSeq  = repCustSeq ;
		this.userId  = userId ;
		this.wrkNo  = wrkNo ;
		this.invCurrCd  = invCurrCd ;
		this.invDeltDivCd  = invDeltDivCd ;
		this.bfrInvCurrCd  = bfrInvCurrCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("rep_cust_cnt_cd", getRepCustCntCd());		
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());		
		this.hashColumns.put("port_cd", getPortCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());		
		this.hashColumns.put("act_cust_seq", getActCustSeq());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("inv_split_cd", getInvSplitCd());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("rev_tp_src_cd", getRevTpSrcCd());		
		this.hashColumns.put("rep_cust_seq", getRepCustSeq());		
		this.hashColumns.put("user_id", getUserId());		
		this.hashColumns.put("wrk_no", getWrkNo());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("inv_delt_div_cd", getInvDeltDivCd());		
		this.hashColumns.put("bfr_inv_curr_cd", getBfrInvCurrCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rep_cust_cnt_cd", "repCustCntCd");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("inv_split_cd", "invSplitCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("rev_tp_src_cd", "revTpSrcCd");
		this.hashFields.put("rep_cust_seq", "repCustSeq");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("wrk_no", "wrkNo");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_delt_div_cd", "invDeltDivCd");
		this.hashFields.put("bfr_inv_curr_cd", "bfrInvCurrCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  porCd
	*/
	public void	setPorCd( String	porCd ) {
		this.porCd =	porCd;
	}
 
	/**
	 * Column Info
	 * @return	porCd
	 */
	 public	 String	getPorCd() {
		 return	this.porCd;
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
	* @param  usdXchRt
	*/
	public void	setUsdXchRt( String	usdXchRt ) {
		this.usdXchRt =	usdXchRt;
	}
 
	/**
	 * Column Info
	 * @return	usdXchRt
	 */
	 public	 String	getUsdXchRt() {
		 return	this.usdXchRt;
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
	* @param  repCustCntCd
	*/
	public void	setRepCustCntCd( String	repCustCntCd ) {
		this.repCustCntCd =	repCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	repCustCntCd
	 */
	 public	 String	getRepCustCntCd() {
		 return	this.repCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  invCustCntCd
	*/
	public void	setInvCustCntCd( String	invCustCntCd ) {
		this.invCustCntCd =	invCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	invCustCntCd
	 */
	 public	 String	getInvCustCntCd() {
		 return	this.invCustCntCd;
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
	* @param  invCustSeq
	*/
	public void	setInvCustSeq( String	invCustSeq ) {
		this.invCustSeq =	invCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	invCustSeq
	 */
	 public	 String	getInvCustSeq() {
		 return	this.invCustSeq;
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
	* @param  delCd
	*/
	public void	setDelCd( String	delCd ) {
		this.delCd =	delCd;
	}
 
	/**
	 * Column Info
	 * @return	delCd
	 */
	 public	 String	getDelCd() {
		 return	this.delCd;
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
	* @param  invSplitCd
	*/
	public void	setInvSplitCd( String	invSplitCd ) {
		this.invSplitCd =	invSplitCd;
	}
 
	/**
	 * Column Info
	 * @return	invSplitCd
	 */
	 public	 String	getInvSplitCd() {
		 return	this.invSplitCd;
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
	* @param  revTpSrcCd
	*/
	public void	setRevTpSrcCd( String	revTpSrcCd ) {
		this.revTpSrcCd =	revTpSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	revTpSrcCd
	 */
	 public	 String	getRevTpSrcCd() {
		 return	this.revTpSrcCd;
	 } 
 	/**
	* Column Info
	* @param  repCustSeq
	*/
	public void	setRepCustSeq( String	repCustSeq ) {
		this.repCustSeq =	repCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	repCustSeq
	 */
	 public	 String	getRepCustSeq() {
		 return	this.repCustSeq;
	 } 
 	/**
	* Column Info
	* @param  userId
	*/
	public void	setUserId( String	userId ) {
		this.userId =	userId;
	}
 
	/**
	 * Column Info
	 * @return	userId
	 */
	 public	 String	getUserId() {
		 return	this.userId;
	 } 
 	/**
	* Column Info
	* @param  wrkNo
	*/
	public void	setWrkNo( String	wrkNo ) {
		this.wrkNo =	wrkNo;
	}
 
	/**
	 * Column Info
	 * @return	wrkNo
	 */
	 public	 String	getWrkNo() {
		 return	this.wrkNo;
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
	* @param  invDeltDivCd
	*/
	public void	setInvDeltDivCd( String	invDeltDivCd ) {
		this.invDeltDivCd =	invDeltDivCd;
	}
 
	/**
	 * Column Info
	 * @return	invDeltDivCd
	 */
	 public	 String	getInvDeltDivCd() {
		 return	this.invDeltDivCd;
	 } 
 	/**
	* Column Info
	* @param  bfrInvCurrCd
	*/
	public void	setBfrInvCurrCd( String	bfrInvCurrCd ) {
		this.bfrInvCurrCd =	bfrInvCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	bfrInvCurrCd
	 */
	 public	 String	getBfrInvCurrCd() {
		 return	this.bfrInvCurrCd;
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
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setUsdXchRt(JSPUtil.getParameter(request,	prefix + "usd_xch_rt", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setRepCustCntCd(JSPUtil.getParameter(request,	prefix + "rep_cust_cnt_cd", ""));
		setInvCustCntCd(JSPUtil.getParameter(request,	prefix + "inv_cust_cnt_cd", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setActCustCntCd(JSPUtil.getParameter(request,	prefix + "act_cust_cnt_cd", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setInvCustSeq(JSPUtil.getParameter(request,	prefix + "inv_cust_seq", ""));
		setActCustSeq(JSPUtil.getParameter(request,	prefix + "act_cust_seq", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setInvSplitCd(JSPUtil.getParameter(request,	prefix + "inv_split_cd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setRevTpSrcCd(JSPUtil.getParameter(request,	prefix + "rev_tp_src_cd", ""));
		setRepCustSeq(JSPUtil.getParameter(request,	prefix + "rep_cust_seq", ""));
		setUserId(JSPUtil.getParameter(request,	prefix + "user_id", ""));
		setWrkNo(JSPUtil.getParameter(request,	prefix + "wrk_no", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setInvDeltDivCd(JSPUtil.getParameter(request,	prefix + "inv_delt_div_cd", ""));
		setBfrInvCurrCd(JSPUtil.getParameter(request,	prefix + "bfr_inv_curr_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return INVMainInfoForIssueVO[]
	 */
	public INVMainInfoForIssueVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return INVMainInfoForIssueVO[]
	 */
	public INVMainInfoForIssueVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		INVMainInfoForIssueVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] usdXchRt =	(JSPUtil.getParameter(request, prefix +	"usd_xch_rt".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] repCustCntCd =	(JSPUtil.getParameter(request, prefix +	"rep_cust_cnt_cd".trim(),	length));
				String[] invCustCntCd =	(JSPUtil.getParameter(request, prefix +	"inv_cust_cnt_cd".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] actCustCntCd =	(JSPUtil.getParameter(request, prefix +	"act_cust_cnt_cd".trim(),	length));
				String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] invCustSeq =	(JSPUtil.getParameter(request, prefix +	"inv_cust_seq".trim(),	length));
				String[] actCustSeq =	(JSPUtil.getParameter(request, prefix +	"act_cust_seq".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] invSplitCd =	(JSPUtil.getParameter(request, prefix +	"inv_split_cd".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] revTpSrcCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_src_cd".trim(),	length));
				String[] repCustSeq =	(JSPUtil.getParameter(request, prefix +	"rep_cust_seq".trim(),	length));
				String[] userId =	(JSPUtil.getParameter(request, prefix +	"user_id".trim(),	length));
				String[] wrkNo =	(JSPUtil.getParameter(request, prefix +	"wrk_no".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] invDeltDivCd =	(JSPUtil.getParameter(request, prefix +	"inv_delt_div_cd".trim(),	length));
				String[] bfrInvCurrCd =	(JSPUtil.getParameter(request, prefix +	"bfr_inv_curr_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	INVMainInfoForIssueVO();
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( usdXchRt[i] !=	null)
						model.setUsdXchRt( usdXchRt[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( repCustCntCd[i] !=	null)
						model.setRepCustCntCd( repCustCntCd[i]);
						if ( invCustCntCd[i] !=	null)
						model.setInvCustCntCd( invCustCntCd[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( actCustCntCd[i] !=	null)
						model.setActCustCntCd( actCustCntCd[i]);
						if ( portCd[i] !=	null)
						model.setPortCd( portCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( invCustSeq[i] !=	null)
						model.setInvCustSeq( invCustSeq[i]);
						if ( actCustSeq[i] !=	null)
						model.setActCustSeq( actCustSeq[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( invSplitCd[i] !=	null)
						model.setInvSplitCd( invSplitCd[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( revTpSrcCd[i] !=	null)
						model.setRevTpSrcCd( revTpSrcCd[i]);
						if ( repCustSeq[i] !=	null)
						model.setRepCustSeq( repCustSeq[i]);
						if ( userId[i] !=	null)
						model.setUserId( userId[i]);
						if ( wrkNo[i] !=	null)
						model.setWrkNo( wrkNo[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( invDeltDivCd[i] !=	null)
						model.setInvDeltDivCd( invDeltDivCd[i]);
						if ( bfrInvCurrCd[i] !=	null)
						model.setBfrInvCurrCd( bfrInvCurrCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getINVMainInfoForIssueVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return INVMainInfoForIssueVO[]
	 */
	public INVMainInfoForIssueVO[]	 getINVMainInfoForIssueVOs(){
		INVMainInfoForIssueVO[] vos = (INVMainInfoForIssueVO[])models.toArray(new	INVMainInfoForIssueVO[models.size()]);
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
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt =	this.usdXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustCntCd =	this.repCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd =	this.invCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd =	this.actCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq =	this.invCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq =	this.actCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSplitCd =	this.invSplitCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpSrcCd =	this.revTpSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCustSeq =	this.repCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId =	this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkNo =	this.wrkNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDeltDivCd =	this.invDeltDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrInvCurrCd =	this.bfrInvCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}