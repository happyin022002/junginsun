/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvEDIChgVO.java
 *@FileTitle : InvEDIChgVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.05.13  
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
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class InvEDIChgVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvEDIChgVO>  models =	new	ArrayList<InvEDIChgVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 chgRefNo   =  null;
	/*	Column Info	*/
	private  String	 repChgCd   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 perTpCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 trfRtAmt   =  null;
	/*	Column Info	*/
	private  String	 chgSeq   =  null;
	/*	Column Info	*/
	private  String	 chgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 chgAmt   =  null;
	/*	Column Info	*/
	private  String	 ediHdrSeq   =  null;
	/*	Column Info	*/
	private  String	 ratAsCntrQty   =  null;
	/*	Column Info	*/
	private  String	 tvaFlg   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvEDIChgVO(){}

	public InvEDIChgVO(String updDt,String chgRefNo,String repChgCd,String currCd,String perTpCd,String creDt,String trfRtAmt,String chgSeq,String chgCd,String pagerows,String ibflag,String creUsrId,String chgAmt,String ediHdrSeq,String ratAsCntrQty,String tvaFlg,String updUsrId,String blNo,String ioBndCd,String cntrNo,String cntrTpszCd)	{
		this.updDt  = updDt ;
		this.chgRefNo  = chgRefNo ;
		this.repChgCd  = repChgCd ;
		this.currCd  = currCd ;
		this.perTpCd  = perTpCd ;
		this.creDt  = creDt ;
		this.trfRtAmt  = trfRtAmt ;
		this.chgSeq  = chgSeq ;
		this.chgCd  = chgCd ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.creUsrId  = creUsrId ;
		this.chgAmt  = chgAmt ;
		this.ediHdrSeq  = ediHdrSeq ;
		this.ratAsCntrQty  = ratAsCntrQty ;
		this.tvaFlg  = tvaFlg ;
		this.updUsrId  = updUsrId ;
		this.blNo  = blNo ;
		this.ioBndCd  = ioBndCd ;
		this.cntrNo  = cntrNo ;
		this.cntrTpszCd  = cntrTpszCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("chg_ref_no", getChgRefNo());		
		this.hashColumns.put("rep_chg_cd", getRepChgCd());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("per_tp_cd", getPerTpCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("trf_rt_amt", getTrfRtAmt());		
		this.hashColumns.put("chg_seq", getChgSeq());		
		this.hashColumns.put("chg_cd", getChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("chg_amt", getChgAmt());		
		this.hashColumns.put("edi_hdr_seq", getEdiHdrSeq());		
		this.hashColumns.put("rat_as_cntr_qty", getRatAsCntrQty());		
		this.hashColumns.put("tva_flg", getTvaFlg());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("chg_ref_no", "chgRefNo");
		this.hashFields.put("rep_chg_cd", "repChgCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("per_tp_cd", "perTpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("trf_rt_amt", "trfRtAmt");
		this.hashFields.put("chg_seq", "chgSeq");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("chg_amt", "chgAmt");
		this.hashFields.put("edi_hdr_seq", "ediHdrSeq");
		this.hashFields.put("rat_as_cntr_qty", "ratAsCntrQty");
		this.hashFields.put("tva_flg", "tvaFlg");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
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
	* @param  chgRefNo
	*/
	public void	setChgRefNo( String	chgRefNo ) {
		this.chgRefNo =	chgRefNo;
	}
 
	/**
	 * Column Info
	 * @return	chgRefNo
	 */
	 public	 String	getChgRefNo() {
		 return	this.chgRefNo;
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
	* @param  ediHdrSeq
	*/
	public void	setEdiHdrSeq( String	ediHdrSeq ) {
		this.ediHdrSeq =	ediHdrSeq;
	}
 
	/**
	 * Column Info
	 * @return	ediHdrSeq
	 */
	 public	 String	getEdiHdrSeq() {
		 return	this.ediHdrSeq;
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
	* @param  cntrTpszCd
	*/
	public void	setCntrTpszCd( String	cntrTpszCd ) {
		this.cntrTpszCd =	cntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd
	 */
	 public	 String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
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
		setChgRefNo(JSPUtil.getParameter(request,	prefix + "chg_ref_no", ""));
		setRepChgCd(JSPUtil.getParameter(request,	prefix + "rep_chg_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setPerTpCd(JSPUtil.getParameter(request,	prefix + "per_tp_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setTrfRtAmt(JSPUtil.getParameter(request,	prefix + "trf_rt_amt", ""));
		setChgSeq(JSPUtil.getParameter(request,	prefix + "chg_seq", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setChgAmt(JSPUtil.getParameter(request,	prefix + "chg_amt", ""));
		setEdiHdrSeq(JSPUtil.getParameter(request,	prefix + "edi_hdr_seq", ""));
		setRatAsCntrQty(JSPUtil.getParameter(request,	prefix + "rat_as_cntr_qty", ""));
		setTvaFlg(JSPUtil.getParameter(request,	prefix + "tva_flg", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvEDIChgVO[]
	 */
	public InvEDIChgVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvEDIChgVO[]
	 */
	public InvEDIChgVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvEDIChgVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] chgRefNo =	(JSPUtil.getParameter(request, prefix +	"chg_ref_no".trim(),	length));
				String[] repChgCd =	(JSPUtil.getParameter(request, prefix +	"rep_chg_cd".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] perTpCd =	(JSPUtil.getParameter(request, prefix +	"per_tp_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] trfRtAmt =	(JSPUtil.getParameter(request, prefix +	"trf_rt_amt".trim(),	length));
				String[] chgSeq =	(JSPUtil.getParameter(request, prefix +	"chg_seq".trim(),	length));
				String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] chgAmt =	(JSPUtil.getParameter(request, prefix +	"chg_amt".trim(),	length));
				String[] ediHdrSeq =	(JSPUtil.getParameter(request, prefix +	"edi_hdr_seq".trim(),	length));
				String[] ratAsCntrQty =	(JSPUtil.getParameter(request, prefix +	"rat_as_cntr_qty".trim(),	length));
				String[] tvaFlg =	(JSPUtil.getParameter(request, prefix +	"tva_flg".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvEDIChgVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( chgRefNo[i] !=	null)
						model.setChgRefNo( chgRefNo[i]);
						if ( repChgCd[i] !=	null)
						model.setRepChgCd( repChgCd[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( perTpCd[i] !=	null)
						model.setPerTpCd( perTpCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( trfRtAmt[i] !=	null)
						model.setTrfRtAmt( trfRtAmt[i]);
						if ( chgSeq[i] !=	null)
						model.setChgSeq( chgSeq[i]);
						if ( chgCd[i] !=	null)
						model.setChgCd( chgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( chgAmt[i] !=	null)
						model.setChgAmt( chgAmt[i]);
						if ( ediHdrSeq[i] !=	null)
						model.setEdiHdrSeq( ediHdrSeq[i]);
						if ( ratAsCntrQty[i] !=	null)
						model.setRatAsCntrQty( ratAsCntrQty[i]);
						if ( tvaFlg[i] !=	null)
						model.setTvaFlg( tvaFlg[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvEDIChgVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvEDIChgVO[]
	 */
	public InvEDIChgVO[]	 getInvEDIChgVOs(){
		InvEDIChgVO[] vos = (InvEDIChgVO[])models.toArray(new	InvEDIChgVO[models.size()]);
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
		this.chgRefNo =	this.chgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repChgCd =	this.repChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perTpCd =	this.perTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfRtAmt =	this.trfRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgSeq =	this.chgSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgAmt =	this.chgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediHdrSeq =	this.ediHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratAsCntrQty =	this.ratAsCntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvaFlg =	this.tvaFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}