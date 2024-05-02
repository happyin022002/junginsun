/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : DueDateInputVO.java
 *@FileTitle : DueDateInputVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.10
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.10  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

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
public class DueDateInputVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<DueDateInputVO>  models =	new	ArrayList<DueDateInputVO>();


	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 glEffDt   =  null;
	/*	Column Info	*/
	private  String	 saDt   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 bnd   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 sailDt   =  null;
	/*	Column Info	*/
	private  String	 seqDiv   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 revTpCd   =  null;
	/*	Column Info	*/
	private  String	 revSrcCd   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public DueDateInputVO(){}

	public DueDateInputVO(String invNo,String ofcCd,String bkgNo,String ibflag,String glEffDt,String saDt,String arIfNo,String bnd,String custSeq,String custCntCd,String sailDt,String seqDiv,String pagerows,String revTpCd,String revSrcCd,String invCurrCd)	{
		this.invNo  = invNo ;
		this.ofcCd  = ofcCd ;
		this.bkgNo  = bkgNo ;
		this.ibflag  = ibflag ;
		this.glEffDt  = glEffDt ;
		this.saDt  = saDt ;
		this.arIfNo  = arIfNo ;
		this.bnd  = bnd ;
		this.custSeq  = custSeq ;
		this.custCntCd  = custCntCd ;
		this.sailDt  = sailDt ;
		this.seqDiv  = seqDiv ;
		this.pagerows  = pagerows ;
		this.revTpCd  = revTpCd ;
		this.revSrcCd  = revSrcCd ;
		this.invCurrCd  = invCurrCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("gl_eff_dt", getGlEffDt());		
		this.hashColumns.put("sa_dt", getSaDt());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("bnd", getBnd());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("sail_dt", getSailDt());		
		this.hashColumns.put("seq_div", getSeqDiv());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("rev_tp_cd", getRevTpCd());		
		this.hashColumns.put("rev_src_cd", getRevSrcCd());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("sa_dt", "saDt");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("seq_div", "seqDiv");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
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
	* @param  glEffDt
	*/
	public void	setGlEffDt( String	glEffDt ) {
		this.glEffDt =	glEffDt;
	}
 
	/**
	 * Column Info
	 * @return	glEffDt
	 */
	 public	 String	getGlEffDt() {
		 return	this.glEffDt;
	 } 
 	/**
	* Column Info
	* @param  saDt
	*/
	public void	setSaDt( String	saDt ) {
		this.saDt =	saDt;
	}
 
	/**
	 * Column Info
	 * @return	saDt
	 */
	 public	 String	getSaDt() {
		 return	this.saDt;
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
	* @param  bnd
	*/
	public void	setBnd( String	bnd ) {
		this.bnd =	bnd;
	}
 
	/**
	 * Column Info
	 * @return	bnd
	 */
	 public	 String	getBnd() {
		 return	this.bnd;
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
	* @param  sailDt
	*/
	public void	setSailDt( String	sailDt ) {
		this.sailDt =	sailDt;
	}
 
	/**
	 * Column Info
	 * @return	sailDt
	 */
	 public	 String	getSailDt() {
		 return	this.sailDt;
	 } 
 	/**
	* Column Info
	* @param  seqDiv
	*/
	public void	setSeqDiv( String	seqDiv ) {
		this.seqDiv =	seqDiv;
	}
 
	/**
	 * Column Info
	 * @return	seqDiv
	 */
	 public	 String	getSeqDiv() {
		 return	this.seqDiv;
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
	* @param  revTpCd
	*/
	public void	setRevTpCd( String	revTpCd ) {
		this.revTpCd =	revTpCd;
	}
 
	/**
	 * Column Info
	 * @return	revTpCd
	 */
	 public	 String	getRevTpCd() {
		 return	this.revTpCd;
	 } 
 	/**
	* Column Info
	* @param  revSrcCd
	*/
	public void	setRevSrcCd( String	revSrcCd ) {
		this.revSrcCd =	revSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	revSrcCd
	 */
	 public	 String	getRevSrcCd() {
		 return	this.revSrcCd;
	 } 
 	/**
	* Column Info
	* @param  invCurrCd
	*/
	public void	setInvCurrCd( String	invCurrCd ) {
		this.invCurrCd =	invCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invCurrCd
	 */
	 public	 String	getInvCurrCd() {
		 return	this.invCurrCd;
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
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setGlEffDt(JSPUtil.getParameter(request,	prefix + "gl_eff_dt", ""));
		setSaDt(JSPUtil.getParameter(request,	prefix + "sa_dt", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setBnd(JSPUtil.getParameter(request,	prefix + "bnd", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setSailDt(JSPUtil.getParameter(request,	prefix + "sail_dt", ""));
		setSeqDiv(JSPUtil.getParameter(request,	prefix + "seq_div", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRevTpCd(JSPUtil.getParameter(request,	prefix + "rev_tp_cd", ""));
		setRevSrcCd(JSPUtil.getParameter(request,	prefix + "rev_src_cd", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DueDateInputVO[]
	 */
	public DueDateInputVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DueDateInputVO[]
	 */
	public DueDateInputVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		DueDateInputVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] glEffDt =	(JSPUtil.getParameter(request, prefix +	"gl_eff_dt".trim(),	length));
				String[] saDt =	(JSPUtil.getParameter(request, prefix +	"sa_dt".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] bnd =	(JSPUtil.getParameter(request, prefix +	"bnd".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] sailDt =	(JSPUtil.getParameter(request, prefix +	"sail_dt".trim(),	length));
				String[] seqDiv =	(JSPUtil.getParameter(request, prefix +	"seq_div".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] revTpCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_cd".trim(),	length));
				String[] revSrcCd =	(JSPUtil.getParameter(request, prefix +	"rev_src_cd".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	DueDateInputVO();
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( glEffDt[i] !=	null)
						model.setGlEffDt( glEffDt[i]);
						if ( saDt[i] !=	null)
						model.setSaDt( saDt[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( bnd[i] !=	null)
						model.setBnd( bnd[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( sailDt[i] !=	null)
						model.setSailDt( sailDt[i]);
						if ( seqDiv[i] !=	null)
						model.setSeqDiv( seqDiv[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( revTpCd[i] !=	null)
						model.setRevTpCd( revTpCd[i]);
						if ( revSrcCd[i] !=	null)
						model.setRevSrcCd( revSrcCd[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getDueDateInputVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return DueDateInputVO[]
	 */
	public DueDateInputVO[]	 getDueDateInputVOs(){
		DueDateInputVO[] vos = (DueDateInputVO[])models.toArray(new	DueDateInputVO[models.size()]);
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
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt =	this.glEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saDt =	this.saDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd =	this.bnd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt =	this.sailDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqDiv =	this.seqDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd =	this.revTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd =	this.revSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}