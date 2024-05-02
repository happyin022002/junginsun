/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : AROutstandingChgVO.java
*@FileTitle : AROutstandingChgVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.11.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.11.26  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.stm.sar.accountreceivableoutstandingmigration.accountreceivableoutstandingmigration.vo;

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
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
 
public class AROutstandingChgVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AROutstandingChgVO>  models =	new	ArrayList<AROutstandingChgVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 ifNo   =  null;
	/*	Column Info	*/
	private  String	 chgTpCd   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 blCurrCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 revAcctMtxSeq   =  null;
	/*	Column Info	*/
	private  String	 tjSrcNm   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 balAmt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 recAcctMtxSeq   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 otsHisSeq   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 orgBlCurrCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AROutstandingChgVO(){}

	public AROutstandingChgVO(String updDt,String glDt,String ifNo,String chgTpCd,String rhqCd,String blCurrCd,String creDt,String revAcctMtxSeq,String tjSrcNm,String blNo,String pagerows,String invNo,String balAmt,String ibflag,String creUsrId,String otsOfcCd,String recAcctMtxSeq,String invAmt,String otsHisSeq,String updUsrId,String orgBlCurrCd)	{
		this.updDt  = updDt ;
		this.glDt  = glDt ;
		this.ifNo  = ifNo ;
		this.chgTpCd  = chgTpCd ;
		this.rhqCd  = rhqCd ;
		this.blCurrCd  = blCurrCd ;
		this.creDt  = creDt ;
		this.revAcctMtxSeq  = revAcctMtxSeq ;
		this.tjSrcNm  = tjSrcNm ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.invNo  = invNo ;
		this.balAmt  = balAmt ;
		this.ibflag  = ibflag ;
		this.creUsrId  = creUsrId ;
		this.otsOfcCd  = otsOfcCd ;
		this.recAcctMtxSeq  = recAcctMtxSeq ;
		this.invAmt  = invAmt ;
		this.otsHisSeq  = otsHisSeq ;
		this.updUsrId  = updUsrId ;
		this.orgBlCurrCd  = orgBlCurrCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("if_no", getIfNo());		
		this.hashColumns.put("chg_tp_cd", getChgTpCd());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("bl_curr_cd", getBlCurrCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("rev_acct_mtx_seq", getRevAcctMtxSeq());		
		this.hashColumns.put("tj_src_nm", getTjSrcNm());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("bal_amt", getBalAmt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("rec_acct_mtx_seq", getRecAcctMtxSeq());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("ots_his_seq", getOtsHisSeq());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("org_bl_curr_cd", getOrgBlCurrCd());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("if_no", "ifNo");
		this.hashFields.put("chg_tp_cd", "chgTpCd");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("bl_curr_cd", "blCurrCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rev_acct_mtx_seq", "revAcctMtxSeq");
		this.hashFields.put("tj_src_nm", "tjSrcNm");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bal_amt", "balAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("rec_acct_mtx_seq", "recAcctMtxSeq");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("ots_his_seq", "otsHisSeq");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("org_bl_curr_cd", "orgBlCurrCd");
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
	* @param  glDt
	*/
	public void	setGlDt( String	glDt ) {
		this.glDt =	glDt;
	}
 
	/**
	 * Column Info
	 * @return	glDt
	 */
	 public	 String	getGlDt() {
		 return	this.glDt;
	 } 
 	/**
	* Column Info
	* @param  ifNo
	*/
	public void	setIfNo( String	ifNo ) {
		this.ifNo =	ifNo;
	}
 
	/**
	 * Column Info
	 * @return	ifNo
	 */
	 public	 String	getIfNo() {
		 return	this.ifNo;
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
	* @param  revAcctMtxSeq
	*/
	public void	setRevAcctMtxSeq( String	revAcctMtxSeq ) {
		this.revAcctMtxSeq =	revAcctMtxSeq;
	}
 
	/**
	 * Column Info
	 * @return	revAcctMtxSeq
	 */
	 public	 String	getRevAcctMtxSeq() {
		 return	this.revAcctMtxSeq;
	 } 
 	/**
	* Column Info
	* @param  tjSrcNm
	*/
	public void	setTjSrcNm( String	tjSrcNm ) {
		this.tjSrcNm =	tjSrcNm;
	}
 
	/**
	 * Column Info
	 * @return	tjSrcNm
	 */
	 public	 String	getTjSrcNm() {
		 return	this.tjSrcNm;
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
	* @param  balAmt
	*/
	public void	setBalAmt( String	balAmt ) {
		this.balAmt =	balAmt;
	}
 
	/**
	 * Column Info
	 * @return	balAmt
	 */
	 public	 String	getBalAmt() {
		 return	this.balAmt;
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
	* @param  recAcctMtxSeq
	*/
	public void	setRecAcctMtxSeq( String	recAcctMtxSeq ) {
		this.recAcctMtxSeq =	recAcctMtxSeq;
	}
 
	/**
	 * Column Info
	 * @return	recAcctMtxSeq
	 */
	 public	 String	getRecAcctMtxSeq() {
		 return	this.recAcctMtxSeq;
	 } 
 	/**
	* Column Info
	* @param  invAmt
	*/
	public void	setInvAmt( String	invAmt ) {
		this.invAmt =	invAmt;
	}
 
	/**
	 * Column Info
	 * @return	invAmt
	 */
	 public	 String	getInvAmt() {
		 return	this.invAmt;
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
	* @param  orgBlCurrCd
	*/
	public void	setOrgBlCurrCd( String	orgBlCurrCd ) {
		this.orgBlCurrCd =	orgBlCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	orgBlCurrCd
	 */
	 public	 String	getOrgBlCurrCd() {
		 return	this.orgBlCurrCd;
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
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setIfNo(JSPUtil.getParameter(request,	prefix + "if_no", ""));
		setChgTpCd(JSPUtil.getParameter(request,	prefix + "chg_tp_cd", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setBlCurrCd(JSPUtil.getParameter(request,	prefix + "bl_curr_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setRevAcctMtxSeq(JSPUtil.getParameter(request,	prefix + "rev_acct_mtx_seq", ""));
		setTjSrcNm(JSPUtil.getParameter(request,	prefix + "tj_src_nm", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setBalAmt(JSPUtil.getParameter(request,	prefix + "bal_amt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setRecAcctMtxSeq(JSPUtil.getParameter(request,	prefix + "rec_acct_mtx_seq", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setOtsHisSeq(JSPUtil.getParameter(request,	prefix + "ots_his_seq", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setOrgBlCurrCd(JSPUtil.getParameter(request,	prefix + "org_bl_curr_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return AROutstandingChgVO[]
	 */
	public AROutstandingChgVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return AROutstandingChgVO[]
	 */
	public AROutstandingChgVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AROutstandingChgVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] ifNo =	(JSPUtil.getParameter(request, prefix +	"if_no".trim(),	length));
				String[] chgTpCd =	(JSPUtil.getParameter(request, prefix +	"chg_tp_cd".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] blCurrCd =	(JSPUtil.getParameter(request, prefix +	"bl_curr_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] revAcctMtxSeq =	(JSPUtil.getParameter(request, prefix +	"rev_acct_mtx_seq".trim(),	length));
				String[] tjSrcNm =	(JSPUtil.getParameter(request, prefix +	"tj_src_nm".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] balAmt =	(JSPUtil.getParameter(request, prefix +	"bal_amt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] recAcctMtxSeq =	(JSPUtil.getParameter(request, prefix +	"rec_acct_mtx_seq".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] otsHisSeq =	(JSPUtil.getParameter(request, prefix +	"ots_his_seq".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] orgBlCurrCd =	(JSPUtil.getParameter(request, prefix +	"org_bl_curr_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AROutstandingChgVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( ifNo[i] !=	null)
						model.setIfNo( ifNo[i]);
						if ( chgTpCd[i] !=	null)
						model.setChgTpCd( chgTpCd[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( blCurrCd[i] !=	null)
						model.setBlCurrCd( blCurrCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( revAcctMtxSeq[i] !=	null)
						model.setRevAcctMtxSeq( revAcctMtxSeq[i]);
						if ( tjSrcNm[i] !=	null)
						model.setTjSrcNm( tjSrcNm[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( balAmt[i] !=	null)
						model.setBalAmt( balAmt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( recAcctMtxSeq[i] !=	null)
						model.setRecAcctMtxSeq( recAcctMtxSeq[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( otsHisSeq[i] !=	null)
						model.setOtsHisSeq( otsHisSeq[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( orgBlCurrCd[i] !=	null)
						model.setOrgBlCurrCd( orgBlCurrCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAROutstandingChgVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return AROutstandingChgVO[]
	 */
	public AROutstandingChgVO[]	 getAROutstandingChgVOs(){
		AROutstandingChgVO[] vos = (AROutstandingChgVO[])models.toArray(new	AROutstandingChgVO[models.size()]);
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
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ifNo =	this.ifNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgTpCd =	this.chgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCurrCd =	this.blCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revAcctMtxSeq =	this.revAcctMtxSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tjSrcNm =	this.tjSrcNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.balAmt =	this.balAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.recAcctMtxSeq =	this.recAcctMtxSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsHisSeq =	this.otsHisSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgBlCurrCd =	this.orgBlCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}