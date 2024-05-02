/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ActInvCustVO.java
 *@FileTitle : ActInvCustVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.09.08
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.09.08  
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo;

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
public class ActInvCustVO	extends	 AbstractValueObject
{
 
	private	 static final long serialVersionUID = 1L;

	private	 Collection<ActInvCustVO>  models =	new	ArrayList<ActInvCustVO>();


	/*	Column Info	*/
	private  String	 crTermDys   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 invCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 invCustSeq   =  null;
	/*	Column Info	*/
	private  String	 actCustSeq   =  null;
	/*	Column Info	*/
	private  String	 actCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 dueDt   =  null;
	/*	Column Info	*/
	private  String	 custCrFlg   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 bfrInvCurrCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ActInvCustVO(){}

	public ActInvCustVO(String crTermDys,String ibflag,String invCustCntCd,String invCustSeq,String actCustSeq,String actCustCntCd,String dueDt,String custCrFlg,String pagerows,String bfrInvCurrCd)	{
		this.crTermDys  = crTermDys ;
		this.ibflag  = ibflag ;
		this.invCustCntCd  = invCustCntCd ;
		this.invCustSeq  = invCustSeq ;
		this.actCustSeq  = actCustSeq ;
		this.actCustCntCd  = actCustCntCd ;
		this.dueDt  = dueDt ;
		this.custCrFlg  = custCrFlg ;
		this.pagerows  = pagerows ;
		this.bfrInvCurrCd  = bfrInvCurrCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cr_term_dys", getCrTermDys());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());		
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());		
		this.hashColumns.put("act_cust_seq", getActCustSeq());		
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());		
		this.hashColumns.put("due_dt", getDueDt());		
		this.hashColumns.put("cust_cr_flg", getCustCrFlg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("bfr_inv_curr_cd", getBfrInvCurrCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cr_term_dys", "crTermDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("cust_cr_flg", "custCrFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bfr_inv_curr_cd", "bfrInvCurrCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  crTermDys
	*/
	public void	setCrTermDys( String	crTermDys ) {
		this.crTermDys =	crTermDys;
	}
 
	/**
	 * Column Info
	 * @return	crTermDys
	 */
	 public	 String	getCrTermDys() {
		 return	this.crTermDys;
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
	* @param  dueDt
	*/
	public void	setDueDt( String	dueDt ) {
		this.dueDt =	dueDt;
	}
 
	/**
	 * Column Info
	 * @return	dueDt
	 */
	 public	 String	getDueDt() {
		 return	this.dueDt;
	 } 
 	/**
	* Column Info
	* @param  custCrFlg
	*/
	public void	setCustCrFlg( String	custCrFlg ) {
		this.custCrFlg =	custCrFlg;
	}
 
	/**
	 * Column Info
	 * @return	custCrFlg
	 */
	 public	 String	getCustCrFlg() {
		 return	this.custCrFlg;
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
		setCrTermDys(JSPUtil.getParameter(request,	prefix + "cr_term_dys", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setInvCustCntCd(JSPUtil.getParameter(request,	prefix + "inv_cust_cnt_cd", ""));
		setInvCustSeq(JSPUtil.getParameter(request,	prefix + "inv_cust_seq", ""));
		setActCustSeq(JSPUtil.getParameter(request,	prefix + "act_cust_seq", ""));
		setActCustCntCd(JSPUtil.getParameter(request,	prefix + "act_cust_cnt_cd", ""));
		setDueDt(JSPUtil.getParameter(request,	prefix + "due_dt", ""));
		setCustCrFlg(JSPUtil.getParameter(request,	prefix + "cust_cr_flg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setBfrInvCurrCd(JSPUtil.getParameter(request,	prefix + "bfr_inv_curr_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ActInvCustVO[]
	 */
	public ActInvCustVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ActInvCustVO[]
	 */
	public ActInvCustVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ActInvCustVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] crTermDys =	(JSPUtil.getParameter(request, prefix +	"cr_term_dys".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] invCustCntCd =	(JSPUtil.getParameter(request, prefix +	"inv_cust_cnt_cd".trim(),	length));
				String[] invCustSeq =	(JSPUtil.getParameter(request, prefix +	"inv_cust_seq".trim(),	length));
				String[] actCustSeq =	(JSPUtil.getParameter(request, prefix +	"act_cust_seq".trim(),	length));
				String[] actCustCntCd =	(JSPUtil.getParameter(request, prefix +	"act_cust_cnt_cd".trim(),	length));
				String[] dueDt =	(JSPUtil.getParameter(request, prefix +	"due_dt".trim(),	length));
				String[] custCrFlg =	(JSPUtil.getParameter(request, prefix +	"cust_cr_flg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] bfrInvCurrCd =	(JSPUtil.getParameter(request, prefix +	"bfr_inv_curr_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ActInvCustVO();
						if ( crTermDys[i] !=	null)
						model.setCrTermDys( crTermDys[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( invCustCntCd[i] !=	null)
						model.setInvCustCntCd( invCustCntCd[i]);
						if ( invCustSeq[i] !=	null)
						model.setInvCustSeq( invCustSeq[i]);
						if ( actCustSeq[i] !=	null)
						model.setActCustSeq( actCustSeq[i]);
						if ( actCustCntCd[i] !=	null)
						model.setActCustCntCd( actCustCntCd[i]);
						if ( dueDt[i] !=	null)
						model.setDueDt( dueDt[i]);
						if ( custCrFlg[i] !=	null)
						model.setCustCrFlg( custCrFlg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( bfrInvCurrCd[i] !=	null)
						model.setBfrInvCurrCd( bfrInvCurrCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getActInvCustVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ActInvCustVO[]
	 */
	public ActInvCustVO[]	 getActInvCustVOs(){
		ActInvCustVO[] vos = (ActInvCustVO[])models.toArray(new	ActInvCustVO[models.size()]);
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
		this.crTermDys =	this.crTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd =	this.invCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq =	this.invCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq =	this.actCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd =	this.actCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt =	this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrFlg =	this.custCrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bfrInvCurrCd =	this.bfrInvCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}