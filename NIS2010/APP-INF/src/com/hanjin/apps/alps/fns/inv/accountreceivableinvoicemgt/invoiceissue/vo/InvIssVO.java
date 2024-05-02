/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvIssVO.java
 *@FileTitle : InvIssVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.07.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.07.20  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 愿��젴	Event�뿉�꽌	�옉�꽦,	�꽌踰꾩떎�뻾�슂泥��떆	PDTO�쓽 �뿭�븷�쓣 �닔�뻾�븯�뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class InvIssVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvIssVO>  models =	new	ArrayList<InvIssVO>();


	/*	Column Info	*/
	private  String	 invDupFlg   =  null;
	/*	Column Info	*/
	private  String	 otsSmryCd   =  null;
	/*	Column Info	*/
	private  String	 invMaxSeq   =  null;
	/*	Column Info	*/
	private  String	 invSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invMltBlIssFlg   =  null;
	/*	Column Info	*/
	private  String	 issDt   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 invIssTpCd   =  null;
	/*	Column Info	*/
	private  String	 userId   =  null;
	/*	Column Info	*/
	private  String	 invPfxCd   =  null;
	/*	Column Info	*/
	private  String	 wrkNo   =  null;
	/*	Column Info	*/
	private  String	 issueType   =  null;
	/*	Column Info	*/
	private  String	 emailFlag   =  null;
	/*	Column Info	*/
	private  String	 revType   =  null;
	/*	Column Info	*/
	private  String	 autoInvIssFlg   =  null;
	/*	Column Info	*/
	private  String	 loginOfcCd   =  null;
	/*	Column Info	*/
	private  String	 indIssTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvIssVO(){}

	public InvIssVO(String invDupFlg,String otsSmryCd,String invMaxSeq,String invSeq,String pagerows,String invMltBlIssFlg,String issDt,String ofcCd,String ibflag,String invIssTpCd,String userId,String invPfxCd,String wrkNo,String issueType,String emailFlag,String revType,String autoInvIssFlg,String loginOfcCd,String indIssTpCd)	{
		this.invDupFlg  = invDupFlg ;
		this.otsSmryCd  = otsSmryCd ;
		this.invMaxSeq  = invMaxSeq ;
		this.invSeq  = invSeq ;
		this.pagerows  = pagerows ;
		this.invMltBlIssFlg  = invMltBlIssFlg ;
		this.issDt  = issDt ;
		this.ofcCd  = ofcCd ;
		this.ibflag  = ibflag ;
		this.invIssTpCd  = invIssTpCd ;
		this.userId  = userId ;
		this.invPfxCd  = invPfxCd ;
		this.wrkNo  = wrkNo ;
		this.issueType  = issueType ;
		this.emailFlag  = emailFlag ;
		this.revType  = revType ;
		this.autoInvIssFlg  = autoInvIssFlg ;
		this.loginOfcCd  = loginOfcCd ;
		this.indIssTpCd  = indIssTpCd ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_dup_flg", getInvDupFlg());		
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());		
		this.hashColumns.put("inv_max_seq", getInvMaxSeq());		
		this.hashColumns.put("inv_seq", getInvSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_mlt_bl_iss_flg", getInvMltBlIssFlg());		
		this.hashColumns.put("iss_dt", getIssDt());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("inv_iss_tp_cd", getInvIssTpCd());		
		this.hashColumns.put("user_id", getUserId());		
		this.hashColumns.put("inv_pfx_cd", getInvPfxCd());		
		this.hashColumns.put("wrk_no", getWrkNo());		
		this.hashColumns.put("issue_type", getIssueType());		
		this.hashColumns.put("email_flag", getEmailFlag());		
		this.hashColumns.put("rev_type", getRevType());		
		this.hashColumns.put("auto_inv_iss_flg", getAutoInvIssFlg());		
		this.hashColumns.put("login_ofc_cd", getLoginOfcCd());		
		this.hashColumns.put("ind_iss_tp_cd", getIndIssTpCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inv_dup_flg", "invDupFlg");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("inv_max_seq", "invMaxSeq");
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_mlt_bl_iss_flg", "invMltBlIssFlg");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_iss_tp_cd", "invIssTpCd");
		this.hashFields.put("user_id", "userId");
		this.hashFields.put("inv_pfx_cd", "invPfxCd");
		this.hashFields.put("wrk_no", "wrkNo");
		this.hashFields.put("issue_type", "issueType");
		this.hashFields.put("email_flag", "emailFlag");
		this.hashFields.put("rev_type", "revType");
		this.hashFields.put("auto_inv_iss_flg", "autoInvIssFlg");
		this.hashFields.put("login_ofc_cd", "loginOfcCd");
		this.hashFields.put("ind_iss_tp_cd", "indIssTpCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  invMaxSeq
	*/
	public void	setInvMaxSeq( String	invMaxSeq ) {
		this.invMaxSeq =	invMaxSeq;
	}
 
	/**
	 * Column Info
	 * @return	invMaxSeq
	 */
	 public	 String	getInvMaxSeq() {
		 return	this.invMaxSeq;
	 } 
 	/**
	* Column Info
	* @param  invSeq
	*/
	public void	setInvSeq( String	invSeq ) {
		this.invSeq =	invSeq;
	}
 
	/**
	 * Column Info
	 * @return	invSeq
	 */
	 public	 String	getInvSeq() {
		 return	this.invSeq;
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
	* @param  issDt
	*/
	public void	setIssDt( String	issDt ) {
		this.issDt =	issDt;
	}
 
	/**
	 * Column Info
	 * @return	issDt
	 */
	 public	 String	getIssDt() {
		 return	this.issDt;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
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
	* @param  invPfxCd
	*/
	public void	setInvPfxCd( String	invPfxCd ) {
		this.invPfxCd =	invPfxCd;
	}
 
	/**
	 * Column Info
	 * @return	invPfxCd
	 */
	 public	 String	getInvPfxCd() {
		 return	this.invPfxCd;
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
	* @param  issueType
	*/
	public void	setIssueType( String	issueType ) {
		this.issueType =	issueType;
	}
 
	/**
	 * Column Info
	 * @return	issueType
	 */
	 public	 String	getIssueType() {
		 return	this.issueType;
	 } 
 	/**
	* Column Info
	* @param  emailFlag
	*/
	public void	setEmailFlag( String	emailFlag ) {
		this.emailFlag =	emailFlag;
	}
 
	/**
	 * Column Info
	 * @return	emailFlag
	 */
	 public	 String	getEmailFlag() {
		 return	this.emailFlag;
	 } 
 	/**
	* Column Info
	* @param  revType
	*/
	public void	setRevType( String	revType ) {
		this.revType =	revType;
	}
 
	/**
	 * Column Info
	 * @return	revType
	 */
	 public	 String	getRevType() {
		 return	this.revType;
	 } 
 	/**
	* Column Info
	* @param  autoInvIssFlg
	*/
	public void	setAutoInvIssFlg( String	autoInvIssFlg ) {
		this.autoInvIssFlg =	autoInvIssFlg;
	}
 
	/**
	 * Column Info
	 * @return	autoInvIssFlg
	 */
	 public	 String	getAutoInvIssFlg() {
		 return	this.autoInvIssFlg;
	 } 
 	/**
	* Column Info
	* @param  loginOfcCd
	*/
	public void	setLoginOfcCd( String	loginOfcCd ) {
		this.loginOfcCd =	loginOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	loginOfcCd
	 */
	 public	 String	getLoginOfcCd() {
		 return	this.loginOfcCd;
	 } 
 	/**
	* Column Info
	* @param  indIssTpCd
	*/
	public void	setIndIssTpCd( String	indIssTpCd ) {
		this.indIssTpCd =	indIssTpCd;
	}
 
	/**
	 * Column Info
	 * @return	indIssTpCd
	 */
	 public	 String	getIndIssTpCd() {
		 return	this.indIssTpCd;
	 } 

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setInvDupFlg(JSPUtil.getParameter(request,	prefix + "inv_dup_flg", ""));
		setOtsSmryCd(JSPUtil.getParameter(request,	prefix + "ots_smry_cd", ""));
		setInvMaxSeq(JSPUtil.getParameter(request,	prefix + "inv_max_seq", ""));
		setInvSeq(JSPUtil.getParameter(request,	prefix + "inv_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvMltBlIssFlg(JSPUtil.getParameter(request,	prefix + "inv_mlt_bl_iss_flg", ""));
		setIssDt(JSPUtil.getParameter(request,	prefix + "iss_dt", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setInvIssTpCd(JSPUtil.getParameter(request,	prefix + "inv_iss_tp_cd", ""));
		setUserId(JSPUtil.getParameter(request,	prefix + "user_id", ""));
		setInvPfxCd(JSPUtil.getParameter(request,	prefix + "inv_pfx_cd", ""));
		setWrkNo(JSPUtil.getParameter(request,	prefix + "wrk_no", ""));
		setIssueType(JSPUtil.getParameter(request,	prefix + "issue_type", ""));
		setEmailFlag(JSPUtil.getParameter(request,	prefix + "email_flag", ""));
		setRevType(JSPUtil.getParameter(request,	prefix + "rev_type", ""));
		setAutoInvIssFlg(JSPUtil.getParameter(request,	prefix + "auto_inv_iss_flg", ""));
		setLoginOfcCd(JSPUtil.getParameter(request,	prefix + "login_ofc_cd", ""));
		setIndIssTpCd(JSPUtil.getParameter(request,	prefix + "ind_iss_tp_cd", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return InvIssVO[]
	 */
	public InvIssVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return InvIssVO[]
	 */
	public InvIssVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvIssVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] invDupFlg =	(JSPUtil.getParameter(request, prefix +	"inv_dup_flg".trim(),	length));
				String[] otsSmryCd =	(JSPUtil.getParameter(request, prefix +	"ots_smry_cd".trim(),	length));
				String[] invMaxSeq =	(JSPUtil.getParameter(request, prefix +	"inv_max_seq".trim(),	length));
				String[] invSeq =	(JSPUtil.getParameter(request, prefix +	"inv_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invMltBlIssFlg =	(JSPUtil.getParameter(request, prefix +	"inv_mlt_bl_iss_flg".trim(),	length));
				String[] issDt =	(JSPUtil.getParameter(request, prefix +	"iss_dt".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] invIssTpCd =	(JSPUtil.getParameter(request, prefix +	"inv_iss_tp_cd".trim(),	length));
				String[] userId =	(JSPUtil.getParameter(request, prefix +	"user_id".trim(),	length));
				String[] invPfxCd =	(JSPUtil.getParameter(request, prefix +	"inv_pfx_cd".trim(),	length));
				String[] wrkNo =	(JSPUtil.getParameter(request, prefix +	"wrk_no".trim(),	length));
				String[] issueType =	(JSPUtil.getParameter(request, prefix +	"issue_type".trim(),	length));
				String[] emailFlag =	(JSPUtil.getParameter(request, prefix +	"email_flag".trim(),	length));
				String[] revType =	(JSPUtil.getParameter(request, prefix +	"rev_type".trim(),	length));
				String[] autoInvIssFlg =	(JSPUtil.getParameter(request, prefix +	"auto_inv_iss_flg".trim(),	length));
				String[] loginOfcCd =	(JSPUtil.getParameter(request, prefix +	"login_ofc_cd".trim(),	length));
				String[] indIssTpCd =	(JSPUtil.getParameter(request, prefix +	"ind_iss_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvIssVO();
						if ( invDupFlg[i] !=	null)
						model.setInvDupFlg( invDupFlg[i]);
						if ( otsSmryCd[i] !=	null)
						model.setOtsSmryCd( otsSmryCd[i]);
						if ( invMaxSeq[i] !=	null)
						model.setInvMaxSeq( invMaxSeq[i]);
						if ( invSeq[i] !=	null)
						model.setInvSeq( invSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invMltBlIssFlg[i] !=	null)
						model.setInvMltBlIssFlg( invMltBlIssFlg[i]);
						if ( issDt[i] !=	null)
						model.setIssDt( issDt[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( invIssTpCd[i] !=	null)
						model.setInvIssTpCd( invIssTpCd[i]);
						if ( userId[i] !=	null)
						model.setUserId( userId[i]);
						if ( invPfxCd[i] !=	null)
						model.setInvPfxCd( invPfxCd[i]);
						if ( wrkNo[i] !=	null)
						model.setWrkNo( wrkNo[i]);
						if ( issueType[i] !=	null)
						model.setIssueType( issueType[i]);
						if ( emailFlag[i] !=	null)
						model.setEmailFlag( emailFlag[i]);
						if ( revType[i] !=	null)
						model.setRevType( revType[i]);
						if ( autoInvIssFlg[i] !=	null)
						model.setAutoInvIssFlg( autoInvIssFlg[i]);
						if ( loginOfcCd[i] !=	null)
						model.setLoginOfcCd( loginOfcCd[i]);
						if ( indIssTpCd[i] !=	null)
						model.setIndIssTpCd( indIssTpCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvIssVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return InvIssVO[]
	 */
	public InvIssVO[]	 getInvIssVOs(){
		InvIssVO[] vos = (InvIssVO[])models.toArray(new	InvIssVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class�쓽 �궡�슜�쓣 String�쑝濡� 蹂��솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �룷留룻똿�맂 臾몄옄�뿴�뿉�꽌 �듅�닔臾몄옄 �젣嫄�("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.invDupFlg =	this.invDupFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd =	this.otsSmryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMaxSeq =	this.invMaxSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSeq =	this.invSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invMltBlIssFlg =	this.invMltBlIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt =	this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssTpCd =	this.invIssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.userId =	this.userId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invPfxCd =	this.invPfxCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkNo =	this.wrkNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issueType =	this.issueType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emailFlag =	this.emailFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revType =	this.revType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoInvIssFlg =	this.autoInvIssFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loginOfcCd =	this.loginOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.indIssTpCd =	this.indIssTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}