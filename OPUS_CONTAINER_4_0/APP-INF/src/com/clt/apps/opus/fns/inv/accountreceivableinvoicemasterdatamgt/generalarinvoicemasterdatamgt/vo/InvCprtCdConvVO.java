/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvCprtCdConvVO.java
 *@FileTitle : InvCprtCdConvVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.14
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.14  
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
public class InvCprtCdConvVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvCprtCdConvVO>  models =	new	ArrayList<InvCprtCdConvVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 rfaNo   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cdRmk   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 custConvCdCtnt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 cprtConvTpCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 coCdCtnt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvCprtCdConvVO(){}

	public InvCprtCdConvVO(String updDt,String rfaNo,String creUsrId,String ibflag,String cdRmk,String scNo,String custConvCdCtnt,String creDt,String cprtConvTpCd,String updUsrId,String pagerows,String coCdCtnt)	{
		this.updDt  = updDt ;
		this.rfaNo  = rfaNo ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.cdRmk  = cdRmk ;
		this.scNo  = scNo ;
		this.custConvCdCtnt  = custConvCdCtnt ;
		this.creDt  = creDt ;
		this.cprtConvTpCd  = cprtConvTpCd ;
		this.updUsrId  = updUsrId ;
		this.pagerows  = pagerows ;
		this.coCdCtnt  = coCdCtnt ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("rfa_no", getRfaNo());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cd_rmk", getCdRmk());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("cust_conv_cd_ctnt", getCustConvCdCtnt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("cprt_conv_tp_cd", getCprtConvTpCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("co_cd_ctnt", getCoCdCtnt());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cd_rmk", "cdRmk");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cust_conv_cd_ctnt", "custConvCdCtnt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cprt_conv_tp_cd", "cprtConvTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("co_cd_ctnt", "coCdCtnt");
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
	* @param  rfaNo
	*/
	public void	setRfaNo( String	rfaNo ) {
		this.rfaNo =	rfaNo;
	}
 
	/**
	 * Column Info
	 * @return	rfaNo
	 */
	 public	 String	getRfaNo() {
		 return	this.rfaNo;
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
	* @param  cdRmk
	*/
	public void	setCdRmk( String	cdRmk ) {
		this.cdRmk =	cdRmk;
	}
 
	/**
	 * Column Info
	 * @return	cdRmk
	 */
	 public	 String	getCdRmk() {
		 return	this.cdRmk;
	 } 
 	/**
	* Column Info
	* @param  scNo
	*/
	public void	setScNo( String	scNo ) {
		this.scNo =	scNo;
	}
 
	/**
	 * Column Info
	 * @return	scNo
	 */
	 public	 String	getScNo() {
		 return	this.scNo;
	 } 
 	/**
	* Column Info
	* @param  custConvCdCtnt
	*/
	public void	setCustConvCdCtnt( String	custConvCdCtnt ) {
		this.custConvCdCtnt =	custConvCdCtnt;
	}
 
	/**
	 * Column Info
	 * @return	custConvCdCtnt
	 */
	 public	 String	getCustConvCdCtnt() {
		 return	this.custConvCdCtnt;
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
	* @param  cprtConvTpCd
	*/
	public void	setCprtConvTpCd( String	cprtConvTpCd ) {
		this.cprtConvTpCd =	cprtConvTpCd;
	}
 
	/**
	 * Column Info
	 * @return	cprtConvTpCd
	 */
	 public	 String	getCprtConvTpCd() {
		 return	this.cprtConvTpCd;
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
	* @param  coCdCtnt
	*/
	public void	setCoCdCtnt( String	coCdCtnt ) {
		this.coCdCtnt =	coCdCtnt;
	}
 
	/**
	 * Column Info
	 * @return	coCdCtnt
	 */
	 public	 String	getCoCdCtnt() {
		 return	this.coCdCtnt;
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
		setRfaNo(JSPUtil.getParameter(request,	prefix + "rfa_no", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCdRmk(JSPUtil.getParameter(request,	prefix + "cd_rmk", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setCustConvCdCtnt(JSPUtil.getParameter(request,	prefix + "cust_conv_cd_ctnt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setCprtConvTpCd(JSPUtil.getParameter(request,	prefix + "cprt_conv_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCoCdCtnt(JSPUtil.getParameter(request,	prefix + "co_cd_ctnt", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return InvCprtCdConvVO[]
	 */
	public InvCprtCdConvVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return InvCprtCdConvVO[]
	 */
	public InvCprtCdConvVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvCprtCdConvVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] rfaNo =	(JSPUtil.getParameter(request, prefix +	"rfa_no".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cdRmk =	(JSPUtil.getParameter(request, prefix +	"cd_rmk".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] custConvCdCtnt =	(JSPUtil.getParameter(request, prefix +	"cust_conv_cd_ctnt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] cprtConvTpCd =	(JSPUtil.getParameter(request, prefix +	"cprt_conv_tp_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] coCdCtnt =	(JSPUtil.getParameter(request, prefix +	"co_cd_ctnt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvCprtCdConvVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( rfaNo[i] !=	null)
						model.setRfaNo( rfaNo[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cdRmk[i] !=	null)
						model.setCdRmk( cdRmk[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( custConvCdCtnt[i] !=	null)
						model.setCustConvCdCtnt( custConvCdCtnt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( cprtConvTpCd[i] !=	null)
						model.setCprtConvTpCd( cprtConvTpCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( coCdCtnt[i] !=	null)
						model.setCoCdCtnt( coCdCtnt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvCprtCdConvVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return InvCprtCdConvVO[]
	 */
	public InvCprtCdConvVO[]	 getInvCprtCdConvVOs(){
		InvCprtCdConvVO[] vos = (InvCprtCdConvVO[])models.toArray(new	InvCprtCdConvVO[models.size()]);
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
		this.rfaNo =	this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdRmk =	this.cdRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custConvCdCtnt =	this.custConvCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cprtConvTpCd =	this.cprtConvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCdCtnt =	this.coCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}