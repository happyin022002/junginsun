/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ApplyListCondVO.java
 *@FileTitle : ApplyListCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.03
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.04.03  
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
public class ApplyListCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ApplyListCondVO>  models =	new	ArrayList<ApplyListCondVO>();


	/*	Column Info	*/
	private  String	 chgTpCd   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 blCurrCd   =  null;
	/*	Column Info	*/
	private  String	 otsSmryCd   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 rctCurrCd   =  null;
	/*	Column Info	*/
	private  String	 otsSrchFlg   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 otsCd   =  null;
	/*	Column Info	*/
	private  String	 repOtsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 localChgFlag   =  null;
	/*	Column Info	*/
	private  String	 boundType   =  null;
	/*	Column Info	*/
	private  String	 invoiceType   =  null;
	/*	Column Info	*/
	private  String	 otsRctTmpSeq   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ApplyListCondVO(){}

	public ApplyListCondVO(String chgTpCd,String rhqCd,String blCurrCd,String otsSmryCd,String blNo,String pagerows,String invNo,String ibflag,String rctCurrCd,String otsSrchFlg,String otsOfcCd,String otsCd,String repOtsOfcCd,String localChgFlag,String boundType,String invoiceType,String otsRctTmpSeq)	{
		this.chgTpCd  = chgTpCd ;
		this.rhqCd  = rhqCd ;
		this.blCurrCd  = blCurrCd ;
		this.otsSmryCd  = otsSmryCd ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.ibflag  = ibflag ;
		this.rctCurrCd  = rctCurrCd ;
		this.otsSrchFlg  = otsSrchFlg ;
		this.otsOfcCd  = otsOfcCd ;
		this.otsCd  = otsCd ;
		this.repOtsOfcCd  = repOtsOfcCd ;
		this.localChgFlag  = localChgFlag ;
		this.boundType  = boundType ;
		this.invoiceType  = invoiceType ;
		this.otsRctTmpSeq  = otsRctTmpSeq ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("chg_tp_cd", getChgTpCd());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());		
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());		
		this.hashColumns.put("ots_srch_flg", getOtsSrchFlg());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("ots_cd", getOtsCd());		
		this.hashColumns.put("rep_ots_ofc_cd", getRepOtsOfcCd());		
		this.hashColumns.put("local_chg_flag", getLocalChgFlag());		
		this.hashColumns.put("bound_type", getBoundType());		
		this.hashColumns.put("invoice_type", getInvoiceType());		
		this.hashColumns.put("ots_rct_tmp_seq", getOtsRctTmpSeq());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("ots_srch_flg", "otsSrchFlg");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("ots_cd", "otsCd");
		this.hashFields.put("rep_ots_ofc_cd", "repOtsOfcCd");
		this.hashFields.put("local_chg_flag", "localChgFlag");
		this.hashFields.put("bound_type", "boundType");
		this.hashFields.put("invoice_type", "invoiceType");
		this.hashFields.put("ots_rct_tmp_seq", "otsRctTmpSeq");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  rhqCd
	*/
	public void	setRhqCd( String	rhqCd ) {
		this.rhqCd =	rhqCd;
	}
 
	/**
	 * Column Info
	 * @return	rhqCd
	 */
	 public	 String	getRhqCd() {
		 return	this.rhqCd;
	 } 
 	/**
	* Column Info
	* @param  blCurrCd
	*/
	public void	setBlCurrCd( String	blCurrCd ) {
		this.blCurrCd =	blCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	blCurrCd
	 */
	 public	 String	getBlCurrCd() {
		 return	this.blCurrCd;
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
	* @param  rctCurrCd
	*/
	public void	setRctCurrCd( String	rctCurrCd ) {
		this.rctCurrCd =	rctCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCurrCd
	 */
	 public	 String	getRctCurrCd() {
		 return	this.rctCurrCd;
	 } 
 	/**
	* Column Info
	* @param  otsSrchFlg
	*/
	public void	setOtsSrchFlg( String	otsSrchFlg ) {
		this.otsSrchFlg =	otsSrchFlg;
	}
 
	/**
	 * Column Info
	 * @return	otsSrchFlg
	 */
	 public	 String	getOtsSrchFlg() {
		 return	this.otsSrchFlg;
	 } 
 	/**
	* Column Info
	* @param  otsOfcCd
	*/
	public void	setOtsOfcCd( String	otsOfcCd ) {
		this.otsOfcCd =	otsOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	otsOfcCd
	 */
	 public	 String	getOtsOfcCd() {
		 return	this.otsOfcCd;
	 } 
 	/**
	* Column Info
	* @param  otsCd
	*/
	public void	setOtsCd( String	otsCd ) {
		this.otsCd =	otsCd;
	}
 
	/**
	 * Column Info
	 * @return	otsCd
	 */
	 public	 String	getOtsCd() {
		 return	this.otsCd;
	 } 
 	/**
	* Column Info
	* @param  repOtsOfcCd
	*/
	public void	setRepOtsOfcCd( String	repOtsOfcCd ) {
		this.repOtsOfcCd =	repOtsOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	repOtsOfcCd
	 */
	 public	 String	getRepOtsOfcCd() {
		 return	this.repOtsOfcCd;
	 } 
 	/**
	* Column Info
	* @param  localChgFlag
	*/
	public void	setLocalChgFlag( String	localChgFlag ) {
		this.localChgFlag =	localChgFlag;
	}
 
	/**
	 * Column Info
	 * @return	localChgFlag
	 */
	 public	 String	getLocalChgFlag() {
		 return	this.localChgFlag;
	 } 
 	/**
	* Column Info
	* @param  boundType
	*/
	public void	setBoundType( String	boundType ) {
		this.boundType =	boundType;
	}
 
	/**
	 * Column Info
	 * @return	boundType
	 */
	 public	 String	getBoundType() {
		 return	this.boundType;
	 } 
 	/**
	* Column Info
	* @param  invoiceType
	*/
	public void	setInvoiceType( String	invoiceType ) {
		this.invoiceType =	invoiceType;
	}
 
	/**
	 * Column Info
	 * @return	invoiceType
	 */
	 public	 String	getInvoiceType() {
		 return	this.invoiceType;
	 } 
 	/**
	* Column Info
	* @param  otsRctTmpSeq
	*/
	public void	setOtsRctTmpSeq( String	otsRctTmpSeq ) {
		this.otsRctTmpSeq =	otsRctTmpSeq;
	}
 
	/**
	 * Column Info
	 * @return	otsRctTmpSeq
	 */
	 public	 String	getOtsRctTmpSeq() {
		 return	this.otsRctTmpSeq;
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
		setChgTpCd(JSPUtil.getParameter(request,	prefix + "chg_tp_cd", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setBlCurrCd(JSPUtil.getParameter(request,	prefix + "bl_curr_cd", ""));
		setOtsSmryCd(JSPUtil.getParameter(request,	prefix + "ots_smry_cd", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRctCurrCd(JSPUtil.getParameter(request,	prefix + "rct_curr_cd", ""));
		setOtsSrchFlg(JSPUtil.getParameter(request,	prefix + "ots_srch_flg", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setOtsCd(JSPUtil.getParameter(request,	prefix + "ots_cd", ""));
		setRepOtsOfcCd(JSPUtil.getParameter(request,	prefix + "rep_ots_ofc_cd", ""));
		setLocalChgFlag(JSPUtil.getParameter(request,	prefix + "local_chg_flag", ""));
		setBoundType(JSPUtil.getParameter(request,	prefix + "bound_type", ""));
		setInvoiceType(JSPUtil.getParameter(request,	prefix + "invoice_type", ""));
		setOtsRctTmpSeq(JSPUtil.getParameter(request,	prefix + "ots_rct_tmp_seq", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return ApplyListCondVO[]
	 */
	public ApplyListCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return ApplyListCondVO[]
	 */
	public ApplyListCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ApplyListCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] chgTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_tp_cd".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] blCurrCd =	(JSPUtil.getParameter(request, prefix +	"bl_curr_cd".trim(),	length));
				String[] otsSmryCd =	(JSPUtil.getParameter(request, prefix +	"ots_smry_cd".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] rctCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_curr_cd".trim(),	length));
				String[] otsSrchFlg =	(JSPUtil.getParameter(request, prefix +	"ots_srch_flg".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] otsCd =	(JSPUtil.getParameter(request, prefix +	"ots_cd".trim(),	length));
				String[] repOtsOfcCd =	(JSPUtil.getParameter(request, prefix +	"rep_ots_ofc_cd".trim(),	length));
				String[] localChgFlag =	(JSPUtil.getParameter(request, prefix +	"local_chg_flag".trim(),	length));
				String[] boundType =	(JSPUtil.getParameter(request, prefix +	"bound_type".trim(),	length));
				String[] invoiceType =	(JSPUtil.getParameter(request, prefix +	"invoice_type".trim(),	length));
				String[] otsRctTmpSeq =	(JSPUtil.getParameter(request, prefix +	"ots_rct_tmp_seq".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ApplyListCondVO();
						if ( chgTpCd[i] !=	null)
						model.setChgTpCd( chgTpCd[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( blCurrCd[i] !=	null)
						model.setBlCurrCd( blCurrCd[i]);
						if ( otsSmryCd[i] !=	null)
						model.setOtsSmryCd( otsSmryCd[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( rctCurrCd[i] !=	null)
						model.setRctCurrCd( rctCurrCd[i]);
						if ( otsSrchFlg[i] !=	null)
						model.setOtsSrchFlg( otsSrchFlg[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( otsCd[i] !=	null)
						model.setOtsCd( otsCd[i]);
						if ( repOtsOfcCd[i] !=	null)
						model.setRepOtsOfcCd( repOtsOfcCd[i]);
						if ( localChgFlag[i] !=	null)
						model.setLocalChgFlag( localChgFlag[i]);
						if ( boundType[i] !=	null)
						model.setBoundType( boundType[i]);
						if ( invoiceType[i] !=	null)
						model.setInvoiceType( invoiceType[i]);
						if ( otsRctTmpSeq[i] !=	null)
						model.setOtsRctTmpSeq( otsRctTmpSeq[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getApplyListCondVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return ApplyListCondVO[]
	 */
	public ApplyListCondVO[]	 getApplyListCondVOs(){
		ApplyListCondVO[] vos = (ApplyListCondVO[])models.toArray(new	ApplyListCondVO[models.size()]);
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
		this.chgTpCd =	this.chgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd =	this.blCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd =	this.otsSmryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd =	this.rctCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrchFlg =	this.otsSrchFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCd =	this.otsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repOtsOfcCd =	this.repOtsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localChgFlag =	this.localChgFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.boundType =	this.boundType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invoiceType =	this.invoiceType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRctTmpSeq =	this.otsRctTmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}