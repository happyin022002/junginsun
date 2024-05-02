/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvArIfChgVO.java
 *@FileTitle : InvArIfChgVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.07.18
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.07.18  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo;

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
public class InvArIfChgVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvArIfChgVO>  models =	new	ArrayList<InvArIfChgVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 srcIfSeq   =  null;
	/*	Column Info	*/
	private  String	 repChgCd   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 perTpCd   =  null;
	/*	Column Info	*/
	private  String	 chgFullNm   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 trfRtAmt   =  null;
	/*	Column Info	*/
	private  String	 srcIfDt   =  null;
	/*	Column Info	*/
	private  String	 chgSeq   =  null;
	/*	Column Info	*/
	private  String	 chgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 trfNo   =  null;
	/*	Column Info	*/
	private  String	 chgAmt   =  null;
	/*	Column Info	*/
	private  String	 ratAsCntrQty   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 tvaFlg   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 chgRmk   =  null;
	/*	Column Info	*/
	private  String	 usdXchRt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvArIfChgVO(){}

	public InvArIfChgVO(String updDt,String srcIfSeq,String repChgCd,String currCd,String perTpCd,String chgFullNm,String creDt,String trfRtAmt,String srcIfDt,String chgSeq,String chgCd,String pagerows,String creUsrId,String ibflag,String trfNo,String chgAmt,String ratAsCntrQty,String updUsrId,String tvaFlg,String invXchRt,String chgRmk,String usdXchRt)	{
		this.updDt  = updDt ;
		this.srcIfSeq  = srcIfSeq ;
		this.repChgCd  = repChgCd ;
		this.currCd  = currCd ;
		this.perTpCd  = perTpCd ;
		this.chgFullNm  = chgFullNm ;
		this.creDt  = creDt ;
		this.trfRtAmt  = trfRtAmt ;
		this.srcIfDt  = srcIfDt ;
		this.chgSeq  = chgSeq ;
		this.chgCd  = chgCd ;
		this.pagerows  = pagerows ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.trfNo  = trfNo ;
		this.chgAmt  = chgAmt ;
		this.ratAsCntrQty  = ratAsCntrQty ;
		this.updUsrId  = updUsrId ;
		this.tvaFlg  = tvaFlg ;
		this.invXchRt  = invXchRt ;
		this.chgRmk  = chgRmk ;
		this.usdXchRt  = usdXchRt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("src_if_seq", getSrcIfSeq());		
		this.hashColumns.put("rep_chg_cd", getRepChgCd());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("per_tp_cd", getPerTpCd());		
		this.hashColumns.put("chg_full_nm", getChgFullNm());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());		
		this.hashColumns.put("src_if_dt", getSrcIfDt());		
		this.hashColumns.put("chg_seq", getChgSeq());		
		this.hashColumns.put("chg_cd", getChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("trf_no", getTrfNo());		
		this.hashColumns.put("chg_amt", getChgAmt());		
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("tva_flg", getTvaFlg());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("chg_rmk", getChgRmk());		
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("src_if_seq", "srcIfSeq");
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("chg_full_nm", "chgFullNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("src_if_dt", "srcIfDt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("tva_flg", "tvaFlg");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("chg_rmk", "chgRmk");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
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
	* @param  srcIfSeq
	*/
	public void	setSrcIfSeq( String	srcIfSeq ) {
		this.srcIfSeq =	srcIfSeq;
	}
 
	/**
	 * Column Info
	 * @return	srcIfSeq
	 */
	 public	 String	getSrcIfSeq() {
		 return	this.srcIfSeq;
	 } 
 	/**
	* Column Info
	* @param  repChgCd
	*/
	public void	setRepChgCd( String	repChgCd ) {
		this.repChgCd =	repChgCd;
	}
 
	/**
	 * Column Info
	 * @return	repChgCd
	 */
	 public	 String	getRepChgCd() {
		 return	this.repChgCd;
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
	* @param  perTpCd
	*/
	public void	setPerTpCd( String	perTpCd ) {
		this.perTpCd =	perTpCd;
	}
 
	/**
	 * Column Info
	 * @return	perTpCd
	 */
	 public	 String	getPerTpCd() {
		 return	this.perTpCd;
	 } 
 	/**
	* Column Info
	* @param  chgFullNm
	*/
	public void	setChgFullNm( String	chgFullNm ) {
		this.chgFullNm =	chgFullNm;
	}
 
	/**
	 * Column Info
	 * @return	chgFullNm
	 */
	 public	 String	getChgFullNm() {
		 return	this.chgFullNm;
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
	* @param  trfRtAmt
	*/
	public void	setTrfRtAmt( String	trfRtAmt ) {
		this.trfRtAmt =	trfRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	trfRtAmt
	 */
	 public	 String	getTrfRtAmt() {
		 return	this.trfRtAmt;
	 } 
 	/**
	* Column Info
	* @param  srcIfDt
	*/
	public void	setSrcIfDt( String	srcIfDt ) {
		this.srcIfDt =	srcIfDt;
	}
 
	/**
	 * Column Info
	 * @return	srcIfDt
	 */
	 public	 String	getSrcIfDt() {
		 return	this.srcIfDt;
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
	* @param  trfNo
	*/
	public void	setTrfNo( String	trfNo ) {
		this.trfNo =	trfNo;
	}
 
	/**
	 * Column Info
	 * @return	trfNo
	 */
	 public	 String	getTrfNo() {
		 return	this.trfNo;
	 } 
 	/**
	* Column Info
	* @param  chgAmt
	*/
	public void	setChgAmt( String	chgAmt ) {
		this.chgAmt =	chgAmt;
	}
 
	/**
	 * Column Info
	 * @return	chgAmt
	 */
	 public	 String	getChgAmt() {
		 return	this.chgAmt;
	 } 
 	/**
	* Column Info
	* @param  ratAsCntrQty
	*/
	public void	setRatAsCntrQty( String	ratAsCntrQty ) {
		this.ratAsCntrQty =	ratAsCntrQty;
	}
 
	/**
	 * Column Info
	 * @return	ratAsCntrQty
	 */
	 public	 String	getRatAsCntrQty() {
		 return	this.ratAsCntrQty;
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
	* @param  tvaFlg
	*/
	public void	setTvaFlg( String	tvaFlg ) {
		this.tvaFlg =	tvaFlg;
	}
 
	/**
	 * Column Info
	 * @return	tvaFlg
	 */
	 public	 String	getTvaFlg() {
		 return	this.tvaFlg;
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
	* @param  chgRmk
	*/
	public void	setChgRmk( String	chgRmk ) {
		this.chgRmk =	chgRmk;
	}
 
	/**
	 * Column Info
	 * @return	chgRmk
	 */
	 public	 String	getChgRmk() {
		 return	this.chgRmk;
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
		setSrcIfSeq(JSPUtil.getParameter(request,	prefix + "src_if_seq", ""));
		setRepChgCd(JSPUtil.getParameter(request,	prefix + "rep_chg_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setPerTpCd(JSPUtil.getParameter(request,	prefix + "per_tp_cd", ""));
		setChgFullNm(JSPUtil.getParameter(request,	prefix + "chg_full_nm", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setTrfRtAmt(JSPUtil.getParameter(request,	prefix + "trf_rt_amt", ""));
		setSrcIfDt(JSPUtil.getParameter(request,	prefix + "src_if_dt", ""));
		setChgSeq(JSPUtil.getParameter(request,	prefix + "chg_seq", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setTrfNo(JSPUtil.getParameter(request,	prefix + "trf_no", ""));
		setChgAmt(JSPUtil.getParameter(request,	prefix + "chg_amt", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request,	prefix + "rat_as_cntr_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setTvaFlg(JSPUtil.getParameter(request,	prefix + "tva_flg", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setChgRmk(JSPUtil.getParameter(request,	prefix + "chg_rmk", ""));
		setUsdXchRt(JSPUtil.getParameter(request,	prefix + "usd_xch_rt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvArIfChgVO[]
	 */
	public InvArIfChgVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvArIfChgVO[]
	 */
	public InvArIfChgVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvArIfChgVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] srcIfSeq =	(JSPUtil.getParameter(request, prefix +	"src_if_seq".trim(),	length));
				String[] repChgCd =	(JSPUtil.getParameter(request, prefix +	"rep_chg_cd".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] perTpCd =	(JSPUtil.getParameter(request, prefix +	"per_tp_cd".trim(),	length));
				String[] chgFullNm =	(JSPUtil.getParameter(request, prefix +	"chg_full_nm".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] trfRtAmt =	(JSPUtil.getParameter(request, prefix +	"trf_rt_amt".trim(),	length));
				String[] srcIfDt =	(JSPUtil.getParameter(request, prefix +	"src_if_dt".trim(),	length));
				String[] chgSeq =	(JSPUtil.getParameter(request, prefix +	"chg_seq".trim(),	length));
				String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] trfNo =	(JSPUtil.getParameter(request, prefix +	"trf_no".trim(),	length));
				String[] chgAmt =	(JSPUtil.getParameter(request, prefix +	"chg_amt".trim(),	length));
				String[] ratAsCntrQty =	(JSPUtil.getParameter(request, prefix +	"rat_as_cntr_qty".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] tvaFlg =	(JSPUtil.getParameter(request, prefix +	"tva_flg".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] chgRmk =	(JSPUtil.getParameter(request, prefix +	"chg_rmk".trim(),	length));
				String[] usdXchRt =	(JSPUtil.getParameter(request, prefix +	"usd_xch_rt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvArIfChgVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( srcIfSeq[i] !=	null)
						model.setSrcIfSeq( srcIfSeq[i]);
						if ( repChgCd[i] !=	null)
						model.setRepChgCd( repChgCd[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( perTpCd[i] !=	null)
						model.setPerTpCd( perTpCd[i]);
						if ( chgFullNm[i] !=	null)
						model.setChgFullNm( chgFullNm[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( trfRtAmt[i] !=	null)
						model.setTrfRtAmt( trfRtAmt[i]);
						if ( srcIfDt[i] !=	null)
						model.setSrcIfDt( srcIfDt[i]);
						if ( chgSeq[i] !=	null)
						model.setChgSeq( chgSeq[i]);
						if ( chgCd[i] !=	null)
						model.setChgCd( chgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( trfNo[i] !=	null)
						model.setTrfNo( trfNo[i]);
						if ( chgAmt[i] !=	null)
						model.setChgAmt( chgAmt[i]);
						if ( ratAsCntrQty[i] !=	null)
						model.setRatAsCntrQty( ratAsCntrQty[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( tvaFlg[i] !=	null)
						model.setTvaFlg( tvaFlg[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( chgRmk[i] !=	null)
						model.setChgRmk( chgRmk[i]);
						if ( usdXchRt[i] !=	null)
						model.setUsdXchRt( usdXchRt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvArIfChgVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvArIfChgVO[]
	 */
	public InvArIfChgVO[]	 getInvArIfChgVOs(){
		InvArIfChgVO[] vos = (InvArIfChgVO[])models.toArray(new	InvArIfChgVO[models.size()]);
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
		this.srcIfSeq =	this.srcIfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgCd =	this.repChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd =	this.perTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgFullNm =	this.chgFullNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt =	this.trfRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcIfDt =	this.srcIfDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq =	this.chgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo =	this.trfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt =	this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty =	this.ratAsCntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaFlg =	this.tvaFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRmk =	this.chgRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt =	this.usdXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}