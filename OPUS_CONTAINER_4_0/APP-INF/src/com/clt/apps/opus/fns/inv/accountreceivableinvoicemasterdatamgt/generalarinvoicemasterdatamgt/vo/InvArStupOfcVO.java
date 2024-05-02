/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvArStupOfcVO.java
 *@FileTitle : InvArStupOfcVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.10.06
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.10.06  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo;

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
public class InvArStupOfcVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvArStupOfcVO>  models =	new	ArrayList<InvArStupOfcVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 invSndTpCd   =  null;
	/*	Column Info	*/
	private  String	 invDupFlg   =  null;
	/*	Column Info	*/
	private  String	 dmdtInvAplyBlFlg   =  null;
	/*	Column Info	*/
	private  String	 xchRtRvsFlg   =  null;
	/*	Column Info	*/
	private  String	 invVatChgCd   =  null;
	/*	Column Info	*/
	private  String	 deltFlg   =  null;
	/*	Column Info	*/
	private  String	 otsSmryCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtN3rdTpCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 n3ptyBilArInvFlg   =  null;
	/*	Column Info	*/
	private  String	 chgCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invMltBlIssFlg   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 invIssTpCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtUsdTpCd   =  null;
	/*	Column Info	*/
	private  String	 dmdtArInvIssFlg   =  null;
	/*	Column Info	*/
	private  String	 cpyInvKnt   =  null;
	/*	Column Info	*/
	private  String	 tmlInvIssFlg   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 invVatChgRt   =  null;
	/*	Column Info	*/
	private  String	 mnrArInvIssFlg   =  null;
	/*	Column Info	*/
	private  String	 invTopRmk   =  null;
	/*	Column Info	*/
	private  String	 invBtmRmk   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvArStupOfcVO(){}

	public InvArStupOfcVO(String updDt,String invSndTpCd,String invDupFlg,String dmdtInvAplyBlFlg,String xchRtRvsFlg,String invVatChgCd,String deltFlg,String otsSmryCd,String xchRtN3rdTpCd,String creDt,String n3ptyBilArInvFlg,String chgCd,String arOfcCd,String pagerows,String invMltBlIssFlg,String creUsrId,String ibflag,String invIssTpCd,String xchRtUsdTpCd,String dmdtArInvIssFlg,String cpyInvKnt,String tmlInvIssFlg,String updUsrId,String invVatChgRt,String mnrArInvIssFlg,String invTopRmk,String invBtmRmk)	{
		this.updDt  = updDt ;
		this.invSndTpCd  = invSndTpCd ;
		this.invDupFlg  = invDupFlg ;
		this.dmdtInvAplyBlFlg  = dmdtInvAplyBlFlg ;
		this.xchRtRvsFlg  = xchRtRvsFlg ;
		this.invVatChgCd  = invVatChgCd ;
		this.deltFlg  = deltFlg ;
		this.otsSmryCd  = otsSmryCd ;
		this.xchRtN3rdTpCd  = xchRtN3rdTpCd ;
		this.creDt  = creDt ;
		this.n3ptyBilArInvFlg  = n3ptyBilArInvFlg ;
		this.chgCd  = chgCd ;
		this.arOfcCd  = arOfcCd ;
		this.pagerows  = pagerows ;
		this.invMltBlIssFlg  = invMltBlIssFlg ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.invIssTpCd  = invIssTpCd ;
		this.xchRtUsdTpCd  = xchRtUsdTpCd ;
		this.dmdtArInvIssFlg  = dmdtArInvIssFlg ;
		this.cpyInvKnt  = cpyInvKnt ;
		this.tmlInvIssFlg  = tmlInvIssFlg ;
		this.updUsrId  = updUsrId ;
		this.invVatChgRt  = invVatChgRt ;
		this.mnrArInvIssFlg  = mnrArInvIssFlg ;
		this.invTopRmk  = invTopRmk ;
		this.invBtmRmk  = invBtmRmk ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("inv_snd_tp_cd", getInvSndTpCd());		
		this.hashColumns.put("inv_dup_flg", getInvDupFlg());		
		this.hashColumns.put("dmdt_inv_aply_bl_flg", getDmdtInvAplyBlFlg());		
		this.hashColumns.put("xch_rt_rvs_flg", getXchRtRvsFlg());		
		this.hashColumns.put("inv_vat_chg_cd", getInvVatChgCd());		
		this.hashColumns.put("delt_flg", getDeltFlg());		
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());		
		this.hashColumns.put("xch_rt_n3rd_tp_cd", getXchRtN3rdTpCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("n3pty_bil_ar_inv_flg", getN3ptyBilArInvFlg());		
		this.hashColumns.put("chg_cd", getChgCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_mlt_bl_iss_flg", getInvMltBlIssFlg());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("inv_iss_tp_cd", getInvIssTpCd());		
		this.hashColumns.put("xch_rt_usd_tp_cd", getXchRtUsdTpCd());		
		this.hashColumns.put("dmdt_ar_inv_iss_flg", getDmdtArInvIssFlg());		
		this.hashColumns.put("cpy_inv_knt", getCpyInvKnt());		
		this.hashColumns.put("tml_inv_iss_flg", getTmlInvIssFlg());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("inv_vat_chg_rt", getInvVatChgRt());		
		this.hashColumns.put("mnr_ar_inv_iss_flg", getMnrArInvIssFlg());		
		this.hashColumns.put("inv_top_rmk", getInvTopRmk());		
		this.hashColumns.put("inv_btm_rmk", getInvBtmRmk());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("inv_snd_tp_cd", "invSndTpCd");
		this.hashFields.put("inv_dup_flg", "invDupFlg");
		this.hashFields.put("dmdt_inv_aply_bl_flg", "dmdtInvAplyBlFlg");
		this.hashFields.put("xch_rt_rvs_flg", "xchRtRvsFlg");
		this.hashFields.put("inv_vat_chg_cd", "invVatChgCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("xch_rt_n3rd_tp_cd", "xchRtN3rdTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("n3pty_bil_ar_inv_flg", "n3ptyBilArInvFlg");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_mlt_bl_iss_flg", "invMltBlIssFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_iss_tp_cd", "invIssTpCd");
		this.hashFields.put("xch_rt_usd_tp_cd", "xchRtUsdTpCd");
		this.hashFields.put("dmdt_ar_inv_iss_flg", "dmdtArInvIssFlg");
		this.hashFields.put("cpy_inv_knt", "cpyInvKnt");
		this.hashFields.put("tml_inv_iss_flg", "tmlInvIssFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_vat_chg_rt", "invVatChgRt");
		this.hashFields.put("mnr_ar_inv_iss_flg", "mnrArInvIssFlg");
		this.hashFields.put("inv_top_rmk", "invTopRmk");
		this.hashFields.put("inv_btm_rmk", "invBtmRmk");
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
	* @param  invSndTpCd
	*/
	public void	setInvSndTpCd( String	invSndTpCd ) {
		this.invSndTpCd =	invSndTpCd;
	}
 
	/**
	 * Column Info
	 * @return	invSndTpCd
	 */
	 public	 String	getInvSndTpCd() {
		 return	this.invSndTpCd;
	 } 
 	/**
	* Column Info
	* @param  invDupFlg
	*/
	public void	setInvDupFlg( String	invDupFlg ) {
		this.invDupFlg =	invDupFlg;
	}
 
	/**
	 * Column Info
	 * @return	invDupFlg
	 */
	 public	 String	getInvDupFlg() {
		 return	this.invDupFlg;
	 } 
 	/**
	* Column Info
	* @param  dmdtInvAplyBlFlg
	*/
	public void	setDmdtInvAplyBlFlg( String	dmdtInvAplyBlFlg ) {
		this.dmdtInvAplyBlFlg =	dmdtInvAplyBlFlg;
	}
 
	/**
	 * Column Info
	 * @return	dmdtInvAplyBlFlg
	 */
	 public	 String	getDmdtInvAplyBlFlg() {
		 return	this.dmdtInvAplyBlFlg;
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
	* @param  invVatChgCd
	*/
	public void	setInvVatChgCd( String	invVatChgCd ) {
		this.invVatChgCd =	invVatChgCd;
	}
 
	/**
	 * Column Info
	 * @return	invVatChgCd
	 */
	 public	 String	getInvVatChgCd() {
		 return	this.invVatChgCd;
	 } 
 	/**
	* Column Info
	* @param  deltFlg
	*/
	public void	setDeltFlg( String	deltFlg ) {
		this.deltFlg =	deltFlg;
	}
 
	/**
	 * Column Info
	 * @return	deltFlg
	 */
	 public	 String	getDeltFlg() {
		 return	this.deltFlg;
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
	* @param  xchRtN3rdTpCd
	*/
	public void	setXchRtN3rdTpCd( String	xchRtN3rdTpCd ) {
		this.xchRtN3rdTpCd =	xchRtN3rdTpCd;
	}
 
	/**
	 * Column Info
	 * @return	xchRtN3rdTpCd
	 */
	 public	 String	getXchRtN3rdTpCd() {
		 return	this.xchRtN3rdTpCd;
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
	* @param  n3ptyBilArInvFlg
	*/
	public void	setN3ptyBilArInvFlg( String	n3ptyBilArInvFlg ) {
		this.n3ptyBilArInvFlg =	n3ptyBilArInvFlg;
	}
 
	/**
	 * Column Info
	 * @return	n3ptyBilArInvFlg
	 */
	 public	 String	getN3ptyBilArInvFlg() {
		 return	this.n3ptyBilArInvFlg;
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
	* @param  invMltBlIssFlg
	*/
	public void	setInvMltBlIssFlg( String	invMltBlIssFlg ) {
		this.invMltBlIssFlg =	invMltBlIssFlg;
	}
 
	/**
	 * Column Info
	 * @return	invMltBlIssFlg
	 */
	 public	 String	getInvMltBlIssFlg() {
		 return	this.invMltBlIssFlg;
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
	* @param  invIssTpCd
	*/
	public void	setInvIssTpCd( String	invIssTpCd ) {
		this.invIssTpCd =	invIssTpCd;
	}
 
	/**
	 * Column Info
	 * @return	invIssTpCd
	 */
	 public	 String	getInvIssTpCd() {
		 return	this.invIssTpCd;
	 } 
 	/**
	* Column Info
	* @param  xchRtUsdTpCd
	*/
	public void	setXchRtUsdTpCd( String	xchRtUsdTpCd ) {
		this.xchRtUsdTpCd =	xchRtUsdTpCd;
	}
 
	/**
	 * Column Info
	 * @return	xchRtUsdTpCd
	 */
	 public	 String	getXchRtUsdTpCd() {
		 return	this.xchRtUsdTpCd;
	 } 
 	/**
	* Column Info
	* @param  dmdtArInvIssFlg
	*/
	public void	setDmdtArInvIssFlg( String	dmdtArInvIssFlg ) {
		this.dmdtArInvIssFlg =	dmdtArInvIssFlg;
	}
 
	/**
	 * Column Info
	 * @return	dmdtArInvIssFlg
	 */
	 public	 String	getDmdtArInvIssFlg() {
		 return	this.dmdtArInvIssFlg;
	 } 
 	/**
	* Column Info
	* @param  cpyInvKnt
	*/
	public void	setCpyInvKnt( String	cpyInvKnt ) {
		this.cpyInvKnt =	cpyInvKnt;
	}
 
	/**
	 * Column Info
	 * @return	cpyInvKnt
	 */
	 public	 String	getCpyInvKnt() {
		 return	this.cpyInvKnt;
	 } 
 	/**
	* Column Info
	* @param  tmlInvIssFlg
	*/
	public void	setTmlInvIssFlg( String	tmlInvIssFlg ) {
		this.tmlInvIssFlg =	tmlInvIssFlg;
	}
 
	/**
	 * Column Info
	 * @return	tmlInvIssFlg
	 */
	 public	 String	getTmlInvIssFlg() {
		 return	this.tmlInvIssFlg;
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
	* @param  invVatChgRt
	*/
	public void	setInvVatChgRt( String	invVatChgRt ) {
		this.invVatChgRt =	invVatChgRt;
	}
 
	/**
	 * Column Info
	 * @return	invVatChgRt
	 */
	 public	 String	getInvVatChgRt() {
		 return	this.invVatChgRt;
	 } 
 	/**
	* Column Info
	* @param  mnrArInvIssFlg
	*/
	public void	setMnrArInvIssFlg( String	mnrArInvIssFlg ) {
		this.mnrArInvIssFlg =	mnrArInvIssFlg;
	}
 
	/**
	 * Column Info
	 * @return	mnrArInvIssFlg
	 */
	 public	 String	getMnrArInvIssFlg() {
		 return	this.mnrArInvIssFlg;
	 } 
 	/**
	* Column Info
	* @param  invTopRmk
	*/
	public void	setInvTopRmk( String	invTopRmk ) {
		this.invTopRmk =	invTopRmk;
	}
 
	/**
	 * Column Info
	 * @return	invTopRmk
	 */
	 public	 String	getInvTopRmk() {
		 return	this.invTopRmk;
	 } 
 	/**
	* Column Info
	* @param  invBtmRmk
	*/
	public void	setInvBtmRmk( String	invBtmRmk ) {
		this.invBtmRmk =	invBtmRmk;
	}
 
	/**
	 * Column Info
	 * @return	invBtmRmk
	 */
	 public	 String	getInvBtmRmk() {
		 return	this.invBtmRmk;
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
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setInvSndTpCd(JSPUtil.getParameter(request,	prefix + "inv_snd_tp_cd", ""));
		setInvDupFlg(JSPUtil.getParameter(request,	prefix + "inv_dup_flg", ""));
		setDmdtInvAplyBlFlg(JSPUtil.getParameter(request,	prefix + "dmdt_inv_aply_bl_flg", ""));
		setXchRtRvsFlg(JSPUtil.getParameter(request,	prefix + "xch_rt_rvs_flg", ""));
		setInvVatChgCd(JSPUtil.getParameter(request,	prefix + "inv_vat_chg_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request,	prefix + "delt_flg", ""));
		setOtsSmryCd(JSPUtil.getParameter(request,	prefix + "ots_smry_cd", ""));
		setXchRtN3rdTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_n3rd_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setN3ptyBilArInvFlg(JSPUtil.getParameter(request,	prefix + "n3pty_bil_ar_inv_flg", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvMltBlIssFlg(JSPUtil.getParameter(request,	prefix + "inv_mlt_bl_iss_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setInvIssTpCd(JSPUtil.getParameter(request,	prefix + "inv_iss_tp_cd", ""));
		setXchRtUsdTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_usd_tp_cd", ""));
		setDmdtArInvIssFlg(JSPUtil.getParameter(request,	prefix + "dmdt_ar_inv_iss_flg", ""));
		setCpyInvKnt(JSPUtil.getParameter(request,	prefix + "cpy_inv_knt", ""));
		setTmlInvIssFlg(JSPUtil.getParameter(request,	prefix + "tml_inv_iss_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setInvVatChgRt(JSPUtil.getParameter(request,	prefix + "inv_vat_chg_rt", ""));
		setMnrArInvIssFlg(JSPUtil.getParameter(request,	prefix + "mnr_ar_inv_iss_flg", ""));
		setInvTopRmk(JSPUtil.getParameter(request,	prefix + "inv_top_rmk", ""));
		setInvBtmRmk(JSPUtil.getParameter(request,	prefix + "inv_btm_rmk", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return InvArStupOfcVO[]
	 */
	public InvArStupOfcVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return InvArStupOfcVO[]
	 */
	public InvArStupOfcVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvArStupOfcVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] invSndTpCd =	(JSPUtil.getParameter(request, prefix +	"inv_snd_tp_cd".trim(),	length));
				String[] invDupFlg =	(JSPUtil.getParameter(request, prefix +	"inv_dup_flg".trim(),	length));
				String[] dmdtInvAplyBlFlg =	(JSPUtil.getParameter(request, prefix +	"dmdt_inv_aply_bl_flg".trim(),	length));
				String[] xchRtRvsFlg =	(JSPUtil.getParameter(request, prefix +	"xch_rt_rvs_flg".trim(),	length));
				String[] invVatChgCd =	(JSPUtil.getParameter(request, prefix +	"inv_vat_chg_cd".trim(),	length));
				String[] deltFlg =	(JSPUtil.getParameter(request, prefix +	"delt_flg".trim(),	length));
				String[] otsSmryCd =	(JSPUtil.getParameter(request, prefix +	"ots_smry_cd".trim(),	length));
				String[] xchRtN3rdTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_n3rd_tp_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] n3ptyBilArInvFlg =	(JSPUtil.getParameter(request, prefix +	"n3pty_bil_ar_inv_flg".trim(),	length));
				String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invMltBlIssFlg =	(JSPUtil.getParameter(request, prefix +	"inv_mlt_bl_iss_flg".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] invIssTpCd =	(JSPUtil.getParameter(request, prefix +	"inv_iss_tp_cd".trim(),	length));
				String[] xchRtUsdTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_usd_tp_cd".trim(),	length));
				String[] dmdtArInvIssFlg =	(JSPUtil.getParameter(request, prefix +	"dmdt_ar_inv_iss_flg".trim(),	length));
				String[] cpyInvKnt =	(JSPUtil.getParameter(request, prefix +	"cpy_inv_knt".trim(),	length));
				String[] tmlInvIssFlg =	(JSPUtil.getParameter(request, prefix +	"tml_inv_iss_flg".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] invVatChgRt =	(JSPUtil.getParameter(request, prefix +	"inv_vat_chg_rt".trim(),	length));
				String[] mnrArInvIssFlg =	(JSPUtil.getParameter(request, prefix +	"mnr_ar_inv_iss_flg".trim(),	length));
				String[] invTopRmk =	(JSPUtil.getParameter(request, prefix +	"inv_top_rmk".trim(),	length));
				String[] invBtmRmk =	(JSPUtil.getParameter(request, prefix +	"inv_btm_rmk".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvArStupOfcVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( invSndTpCd[i] !=	null)
						model.setInvSndTpCd( invSndTpCd[i]);
						if ( invDupFlg[i] !=	null)
						model.setInvDupFlg( invDupFlg[i]);
						if ( dmdtInvAplyBlFlg[i] !=	null)
						model.setDmdtInvAplyBlFlg( dmdtInvAplyBlFlg[i]);
						if ( xchRtRvsFlg[i] !=	null)
						model.setXchRtRvsFlg( xchRtRvsFlg[i]);
						if ( invVatChgCd[i] !=	null)
						model.setInvVatChgCd( invVatChgCd[i]);
						if ( deltFlg[i] !=	null)
						model.setDeltFlg( deltFlg[i]);
						if ( otsSmryCd[i] !=	null)
						model.setOtsSmryCd( otsSmryCd[i]);
						if ( xchRtN3rdTpCd[i] !=	null)
						model.setXchRtN3rdTpCd( xchRtN3rdTpCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( n3ptyBilArInvFlg[i] !=	null)
						model.setN3ptyBilArInvFlg( n3ptyBilArInvFlg[i]);
						if ( chgCd[i] !=	null)
						model.setChgCd( chgCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invMltBlIssFlg[i] !=	null)
						model.setInvMltBlIssFlg( invMltBlIssFlg[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( invIssTpCd[i] !=	null)
						model.setInvIssTpCd( invIssTpCd[i]);
						if ( xchRtUsdTpCd[i] !=	null)
						model.setXchRtUsdTpCd( xchRtUsdTpCd[i]);
						if ( dmdtArInvIssFlg[i] !=	null)
						model.setDmdtArInvIssFlg( dmdtArInvIssFlg[i]);
						if ( cpyInvKnt[i] !=	null)
						model.setCpyInvKnt( cpyInvKnt[i]);
						if ( tmlInvIssFlg[i] !=	null)
						model.setTmlInvIssFlg( tmlInvIssFlg[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( invVatChgRt[i] !=	null)
						model.setInvVatChgRt( invVatChgRt[i]);
						if ( mnrArInvIssFlg[i] !=	null)
						model.setMnrArInvIssFlg( mnrArInvIssFlg[i]);
						if ( invTopRmk[i] !=	null)
						model.setInvTopRmk( invTopRmk[i]);
						if ( invBtmRmk[i] !=	null)
						model.setInvBtmRmk( invBtmRmk[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvArStupOfcVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return InvArStupOfcVO[]
	 */
	public InvArStupOfcVO[]	 getInvArStupOfcVOs(){
		InvArStupOfcVO[] vos = (InvArStupOfcVO[])models.toArray(new	InvArStupOfcVO[models.size()]);
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
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSndTpCd =	this.invSndTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDupFlg =	this.invDupFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtInvAplyBlFlg =	this.dmdtInvAplyBlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtRvsFlg =	this.xchRtRvsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatChgCd =	this.invVatChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg =	this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd =	this.otsSmryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtN3rdTpCd =	this.xchRtN3rdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyBilArInvFlg =	this.n3ptyBilArInvFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMltBlIssFlg =	this.invMltBlIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssTpCd =	this.invIssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtUsdTpCd =	this.xchRtUsdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmdtArInvIssFlg =	this.dmdtArInvIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpyInvKnt =	this.cpyInvKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvIssFlg =	this.tmlInvIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVatChgRt =	this.invVatChgRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrArInvIssFlg =	this.mnrArInvIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invTopRmk =	this.invTopRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invBtmRmk =	this.invBtmRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}