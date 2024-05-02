/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EDI310InputVO.java
 *@FileTitle : EDI310InputVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.22  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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
public class EDI310InputVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<EDI310InputVO>  models =	new	ArrayList<EDI310InputVO>();


	/*	Column Info	*/
	private  String	 tvvdCd   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 invEdiLvlCd   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 chgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 cntcTpCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 saFromDt   =  null;
	/*	Column Info	*/
	private  String	 scRfaNo   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 bdrIndFlg   =  null;
	/*	Column Info	*/
	private  String	 saToDt   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 custCd   =  null;
	/*	Column Info	*/
	private  String	 sourceCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public EDI310InputVO(){}

	public EDI310InputVO(String tvvdCd,String svcScpCd,String invEdiLvlCd,String custSeq,String ioBndCd,String blNo,String chgCd,String pagerows,String cntcTpCd,String ibflag,String saFromDt,String scRfaNo,String cntrNo,String bdrIndFlg,String saToDt,String custCntCd,String arOfcCd,String custCd,String sourceCd)	{
		this.tvvdCd  = tvvdCd ;
		this.svcScpCd  = svcScpCd ;
		this.invEdiLvlCd  = invEdiLvlCd ;
		this.custSeq  = custSeq ;
		this.ioBndCd  = ioBndCd ;
		this.blNo  = blNo ;
		this.chgCd  = chgCd ;
		this.pagerows  = pagerows ;
		this.cntcTpCd  = cntcTpCd ;
		this.ibflag  = ibflag ;
		this.saFromDt  = saFromDt ;
		this.scRfaNo  = scRfaNo ;
		this.cntrNo  = cntrNo ;
		this.bdrIndFlg  = bdrIndFlg ;
		this.saToDt  = saToDt ;
		this.custCntCd  = custCntCd ;
		this.arOfcCd  = arOfcCd ;
		this.custCd  = custCd ;
		this.sourceCd  = sourceCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tvvd_cd", getTvvdCd());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("inv_edi_lvl_cd", getInvEdiLvlCd());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("chg_cd", getChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cntc_tp_cd", getCntcTpCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("sa_from_dt", getSaFromDt());		
		this.hashColumns.put("sc_rfa_no", getScRfaNo());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("bdr_ind_flg", getBdrIndFlg());		
		this.hashColumns.put("sa_to_dt", getSaToDt());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("cust_cd", getCustCd());		
		this.hashColumns.put("source_cd", getSourceCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("tvvd_cd", "tvvdCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("inv_edi_lvl_cd", "invEdiLvlCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntc_tp_cd", "cntcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sa_from_dt", "saFromDt");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("bdr_ind_flg", "bdrIndFlg");
		this.hashFields.put("sa_to_dt", "saToDt");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("source_cd", "sourceCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  tvvdCd
	*/
	public void	setTvvdCd( String	tvvdCd ) {
		this.tvvdCd =	tvvdCd;
	}
 
	/**
	 * Column Info
	 * @return	tvvdCd
	 */
	 public	 String	getTvvdCd() {
		 return	this.tvvdCd;
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
	* @param  invEdiLvlCd
	*/
	public void	setInvEdiLvlCd( String	invEdiLvlCd ) {
		this.invEdiLvlCd =	invEdiLvlCd;
	}
 
	/**
	 * Column Info
	 * @return	invEdiLvlCd
	 */
	 public	 String	getInvEdiLvlCd() {
		 return	this.invEdiLvlCd;
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
	* @param  cntcTpCd
	*/
	public void	setCntcTpCd( String	cntcTpCd ) {
		this.cntcTpCd =	cntcTpCd;
	}
 
	/**
	 * Column Info
	 * @return	cntcTpCd
	 */
	 public	 String	getCntcTpCd() {
		 return	this.cntcTpCd;
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
	* @param  saFromDt
	*/
	public void	setSaFromDt( String	saFromDt ) {
		this.saFromDt =	saFromDt;
	}
 
	/**
	 * Column Info
	 * @return	saFromDt
	 */
	 public	 String	getSaFromDt() {
		 return	this.saFromDt;
	 } 
 	/**
	* Column Info
	* @param  scRfaNo
	*/
	public void	setScRfaNo( String	scRfaNo ) {
		this.scRfaNo =	scRfaNo;
	}
 
	/**
	 * Column Info
	 * @return	scRfaNo
	 */
	 public	 String	getScRfaNo() {
		 return	this.scRfaNo;
	 } 
 	/**
	* Column Info
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	 String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  bdrIndFlg
	*/
	public void	setBdrIndFlg( String	bdrIndFlg ) {
		this.bdrIndFlg =	bdrIndFlg;
	}
 
	/**
	 * Column Info
	 * @return	bdrIndFlg
	 */
	 public	 String	getBdrIndFlg() {
		 return	this.bdrIndFlg;
	 } 
 	/**
	* Column Info
	* @param  saToDt
	*/
	public void	setSaToDt( String	saToDt ) {
		this.saToDt =	saToDt;
	}
 
	/**
	 * Column Info
	 * @return	saToDt
	 */
	 public	 String	getSaToDt() {
		 return	this.saToDt;
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
	* @param  custCd
	*/
	public void	setCustCd( String	custCd ) {
		this.custCd =	custCd;
	}
 
	/**
	 * Column Info
	 * @return	custCd
	 */
	 public	 String	getCustCd() {
		 return	this.custCd;
	 } 
 	/**
	* Column Info
	* @param  sourceCd
	*/
	public void	setSourceCd( String	sourceCd ) {
		this.sourceCd =	sourceCd;
	}
 
	/**
	 * Column Info
	 * @return	sourceCd
	 */
	 public	 String	getSourceCd() {
		 return	this.sourceCd;
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
		setTvvdCd(JSPUtil.getParameter(request,	prefix + "tvvd_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setInvEdiLvlCd(JSPUtil.getParameter(request,	prefix + "inv_edi_lvl_cd", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCntcTpCd(JSPUtil.getParameter(request,	prefix + "cntc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setSaFromDt(JSPUtil.getParameter(request,	prefix + "sa_from_dt", ""));
		setScRfaNo(JSPUtil.getParameter(request,	prefix + "sc_rfa_no", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setBdrIndFlg(JSPUtil.getParameter(request,	prefix + "bdr_ind_flg", ""));
		setSaToDt(JSPUtil.getParameter(request,	prefix + "sa_to_dt", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setCustCd(JSPUtil.getParameter(request,	prefix + "cust_cd", ""));
		setSourceCd(JSPUtil.getParameter(request,	prefix + "source_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return EDI310InputVO[]
	 */
	public EDI310InputVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return EDI310InputVO[]
	 */
	public EDI310InputVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		EDI310InputVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] tvvdCd =	(JSPUtil.getParameter(request, prefix +	"tvvd_cd".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] invEdiLvlCd =	(JSPUtil.getParameter(request, prefix +	"inv_edi_lvl_cd".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] cntcTpCd =	(JSPUtil.getParameter(request, prefix +	"cntc_tp_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] saFromDt =	(JSPUtil.getParameter(request, prefix +	"sa_from_dt".trim(),	length));
				String[] scRfaNo =	(JSPUtil.getParameter(request, prefix +	"sc_rfa_no".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] bdrIndFlg =	(JSPUtil.getParameter(request, prefix +	"bdr_ind_flg".trim(),	length));
				String[] saToDt =	(JSPUtil.getParameter(request, prefix +	"sa_to_dt".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] custCd =	(JSPUtil.getParameter(request, prefix +	"cust_cd".trim(),	length));
				String[] sourceCd =	(JSPUtil.getParameter(request, prefix +	"source_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	EDI310InputVO();
						if ( tvvdCd[i] !=	null)
						model.setTvvdCd( tvvdCd[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( invEdiLvlCd[i] !=	null)
						model.setInvEdiLvlCd( invEdiLvlCd[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( chgCd[i] !=	null)
						model.setChgCd( chgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( cntcTpCd[i] !=	null)
						model.setCntcTpCd( cntcTpCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( saFromDt[i] !=	null)
						model.setSaFromDt( saFromDt[i]);
						if ( scRfaNo[i] !=	null)
						model.setScRfaNo( scRfaNo[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( bdrIndFlg[i] !=	null)
						model.setBdrIndFlg( bdrIndFlg[i]);
						if ( saToDt[i] !=	null)
						model.setSaToDt( saToDt[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( custCd[i] !=	null)
						model.setCustCd( custCd[i]);
						if ( sourceCd[i] !=	null)
						model.setSourceCd( sourceCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getEDI310InputVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return EDI310InputVO[]
	 */
	public EDI310InputVO[]	 getEDI310InputVOs(){
		EDI310InputVO[] vos = (EDI310InputVO[])models.toArray(new	EDI310InputVO[models.size()]);
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
		this.tvvdCd =	this.tvvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invEdiLvlCd =	this.invEdiLvlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntcTpCd =	this.cntcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saFromDt =	this.saFromDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo =	this.scRfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrIndFlg =	this.bdrIndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saToDt =	this.saToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd =	this.custCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sourceCd =	this.sourceCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}