/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ExrateChgVO.java
 *@FileTitle : ExrateChgVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.16
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.03.16  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo;

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
public class ExrateChgVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ExrateChgVO>  models =	new	ArrayList<ExrateChgVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 invXchRtDt   =  null;
	/*	Column Info	*/
	private  String	 chgSeq   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 arIfSerNo   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 revVvd   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 noGoodFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ExrateChgVO(){}

	public ExrateChgVO(String ibflag,String currCd,String arIfNo,String invXchRtDt,String chgSeq,String updUsrId,String arIfSerNo,String invXchRt,String pagerows,String revVvd,String loclCurrCd,String noGoodFlg)	{
		this.ibflag  = ibflag ;
		this.currCd  = currCd ;
		this.arIfNo  = arIfNo ;
		this.invXchRtDt  = invXchRtDt ;
		this.chgSeq  = chgSeq ;
		this.updUsrId  = updUsrId ;
		this.arIfSerNo  = arIfSerNo ;
		this.invXchRt  = invXchRt ;
		this.pagerows  = pagerows ;
		this.revVvd  = revVvd ;
		this.loclCurrCd  = loclCurrCd ;
		this.noGoodFlg  = noGoodFlg ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("inv_xch_rt_dt", getInvXchRtDt());		
		this.hashColumns.put("chg_seq", getChgSeq());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("ar_if_ser_no", getArIfSerNo());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("rev_vvd", getRevVvd());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("no_good_flg", getNoGoodFlg());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("inv_xch_rt_dt", "invXchRtDt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("ar_if_ser_no", "arIfSerNo");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_vvd", "revVvd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("no_good_flg", "noGoodFlg");
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
	* @param  invXchRtDt
	*/
	public void	setInvXchRtDt( String	invXchRtDt ) {
		this.invXchRtDt =	invXchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	invXchRtDt
	 */
	 public	 String	getInvXchRtDt() {
		 return	this.invXchRtDt;
	 } 
 	/**
	* Column Info
	* @param  chgSeq
	*/
	public void	setChgSeq( String	chgSeq ) {
		this.chgSeq =	chgSeq;
	}
 
	/**
	 * Column Info
	 * @return	chgSeq
	 */
	 public	 String	getChgSeq() {
		 return	this.chgSeq;
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
	* @param  arIfSerNo
	*/
	public void	setArIfSerNo( String	arIfSerNo ) {
		this.arIfSerNo =	arIfSerNo;
	}
 
	/**
	 * Column Info
	 * @return	arIfSerNo
	 */
	 public	 String	getArIfSerNo() {
		 return	this.arIfSerNo;
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
	* @param  revVvd
	*/
	public void	setRevVvd( String	revVvd ) {
		this.revVvd =	revVvd;
	}
 
	/**
	 * Column Info
	 * @return	revVvd
	 */
	 public	 String	getRevVvd() {
		 return	this.revVvd;
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
	* @param  noGoodFlg
	*/
	public void	setNoGoodFlg( String	noGoodFlg ) {
		this.noGoodFlg =	noGoodFlg;
	}
 
	/**
	 * Column Info
	 * @return	noGoodFlg
	 */
	 public	 String	getNoGoodFlg() {
		 return	this.noGoodFlg;
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
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setInvXchRtDt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt_dt", ""));
		setChgSeq(JSPUtil.getParameter(request,	prefix + "chg_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setArIfSerNo(JSPUtil.getParameter(request,	prefix + "ar_if_ser_no", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRevVvd(JSPUtil.getParameter(request,	prefix + "rev_vvd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setNoGoodFlg(JSPUtil.getParameter(request,	prefix + "no_good_flg", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return ExrateChgVO[]
	 */
	public ExrateChgVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return ExrateChgVO[]
	 */
	public ExrateChgVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ExrateChgVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] invXchRtDt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt_dt".trim(),	length));
				String[] chgSeq =	(JSPUtil.getParameter(request, prefix +	"chg_seq".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] arIfSerNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_ser_no".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] revVvd =	(JSPUtil.getParameter(request, prefix +	"rev_vvd".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] noGoodFlg =	(JSPUtil.getParameter(request, prefix +	"no_good_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ExrateChgVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( invXchRtDt[i] !=	null)
						model.setInvXchRtDt( invXchRtDt[i]);
						if ( chgSeq[i] !=	null)
						model.setChgSeq( chgSeq[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( arIfSerNo[i] !=	null)
						model.setArIfSerNo( arIfSerNo[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( revVvd[i] !=	null)
						model.setRevVvd( revVvd[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( noGoodFlg[i] !=	null)
						model.setNoGoodFlg( noGoodFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getExrateChgVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return ExrateChgVO[]
	 */
	public ExrateChgVO[]	 getExrateChgVOs(){
		ExrateChgVO[] vos = (ExrateChgVO[])models.toArray(new	ExrateChgVO[models.size()]);
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
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtDt =	this.invXchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq =	this.chgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfSerNo =	this.arIfSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvd =	this.revVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noGoodFlg =	this.noGoodFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}