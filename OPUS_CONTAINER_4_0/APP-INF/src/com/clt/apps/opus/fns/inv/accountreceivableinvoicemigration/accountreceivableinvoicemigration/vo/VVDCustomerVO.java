/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VVDCustomerVO.java
 *@FileTitle : VVDCustomerVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.05
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.12.05  
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
public class VVDCustomerVO	extends	 AbstractValueObject
{
 
	private	 static final long serialVersionUID = 1L;

	private	 Collection<VVDCustomerVO>  models =	new	ArrayList<VVDCustomerVO>();


	/*	Column Info	*/
	private  String	 invCntryCd   =  null;
	/*	Column Info	*/
	private  String	 invCustCd   =  null;
	/*	Column Info	*/
	private  String	 voy   =  null;
	/*	Column Info	*/
	private  String	 lclCurr   =  null;
	/*	Column Info	*/
	private  String	 svcScp   =  null;
	/*	Column Info	*/
	private  String	 bnd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 saDt   =  null;
	/*	Column Info	*/
	private  String	 vsl   =  null;
	/*	Column Info	*/
	private  String	 pol   =  null;
	/*	Column Info	*/
	private  String	 curr   =  null;
	/*	Column Info	*/
	private  String	 dep   =  null;
	/*	Column Info	*/
	private  String	 pod   =  null;
	/*	Column Info	*/
	private  String	 obrdDt   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public VVDCustomerVO(){}

	public VVDCustomerVO(String invCntryCd,String invCustCd,String voy,String lclCurr,String svcScp,String bnd,String pagerows,String ofcCd,String bkgNo,String ibflag,String saDt,String vsl,String pol,String curr,String dep,String pod,String obrdDt,String blSrcNo)	{
		this.invCntryCd  = invCntryCd ;
		this.invCustCd  = invCustCd ;
		this.voy  = voy ;
		this.lclCurr  = lclCurr ;
		this.svcScp  = svcScp ;
		this.bnd  = bnd ;
		this.pagerows  = pagerows ;
		this.ofcCd  = ofcCd ;
		this.bkgNo  = bkgNo ;
		this.ibflag  = ibflag ;
		this.saDt  = saDt ;
		this.vsl  = vsl ;
		this.pol  = pol ;
		this.curr  = curr ;
		this.dep  = dep ;
		this.pod  = pod ;
		this.obrdDt  = obrdDt ;
		this.blSrcNo  = blSrcNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_cntry_cd", getInvCntryCd());		
		this.hashColumns.put("inv_cust_cd", getInvCustCd());		
		this.hashColumns.put("voy", getVoy());		
		this.hashColumns.put("lcl_curr", getLclCurr());		
		this.hashColumns.put("svc_scp", getSvcScp());		
		this.hashColumns.put("bnd", getBnd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("sa_dt", getSaDt());		
		this.hashColumns.put("vsl", getVsl());		
		this.hashColumns.put("pol", getPol());		
		this.hashColumns.put("curr", getCurr());		
		this.hashColumns.put("dep", getDep());		
		this.hashColumns.put("pod", getPod());		
		this.hashColumns.put("obrd_dt", getObrdDt());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inv_cntry_cd", "invCntryCd");
		this.hashFields.put("inv_cust_cd", "invCustCd");
		this.hashFields.put("voy", "voy");
		this.hashFields.put("lcl_curr", "lclCurr");
		this.hashFields.put("svc_scp", "svcScp");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sa_dt", "saDt");
		this.hashFields.put("vsl", "vsl");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("dep", "dep");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("obrd_dt", "obrdDt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  invCntryCd
	*/
	public void	setInvCntryCd( String	invCntryCd ) {
		this.invCntryCd =	invCntryCd;
	}
 
	/**
	 * Column Info
	 * @return	invCntryCd
	 */
	 public	 String	getInvCntryCd() {
		 return	this.invCntryCd;
	 } 
 	/**
	* Column Info
	* @param  invCustCd
	*/
	public void	setInvCustCd( String	invCustCd ) {
		this.invCustCd =	invCustCd;
	}
 
	/**
	 * Column Info
	 * @return	invCustCd
	 */
	 public	 String	getInvCustCd() {
		 return	this.invCustCd;
	 } 
 	/**
	* Column Info
	* @param  voy
	*/
	public void	setVoy( String	voy ) {
		this.voy =	voy;
	}
 
	/**
	 * Column Info
	 * @return	voy
	 */
	 public	 String	getVoy() {
		 return	this.voy;
	 } 
 	/**
	* Column Info
	* @param  lclCurr
	*/
	public void	setLclCurr( String	lclCurr ) {
		this.lclCurr =	lclCurr;
	}
 
	/**
	 * Column Info
	 * @return	lclCurr
	 */
	 public	 String	getLclCurr() {
		 return	this.lclCurr;
	 } 
 	/**
	* Column Info
	* @param  svcScp
	*/
	public void	setSvcScp( String	svcScp ) {
		this.svcScp =	svcScp;
	}
 
	/**
	 * Column Info
	 * @return	svcScp
	 */
	 public	 String	getSvcScp() {
		 return	this.svcScp;
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
	* @param  vsl
	*/
	public void	setVsl( String	vsl ) {
		this.vsl =	vsl;
	}
 
	/**
	 * Column Info
	 * @return	vsl
	 */
	 public	 String	getVsl() {
		 return	this.vsl;
	 } 
 	/**
	* Column Info
	* @param  pol
	*/
	public void	setPol( String	pol ) {
		this.pol =	pol;
	}
 
	/**
	 * Column Info
	 * @return	pol
	 */
	 public	 String	getPol() {
		 return	this.pol;
	 } 
 	/**
	* Column Info
	* @param  curr
	*/
	public void	setCurr( String	curr ) {
		this.curr =	curr;
	}
 
	/**
	 * Column Info
	 * @return	curr
	 */
	 public	 String	getCurr() {
		 return	this.curr;
	 } 
 	/**
	* Column Info
	* @param  dep
	*/
	public void	setDep( String	dep ) {
		this.dep =	dep;
	}
 
	/**
	 * Column Info
	 * @return	dep
	 */
	 public	 String	getDep() {
		 return	this.dep;
	 } 
 	/**
	* Column Info
	* @param  pod
	*/
	public void	setPod( String	pod ) {
		this.pod =	pod;
	}
 
	/**
	 * Column Info
	 * @return	pod
	 */
	 public	 String	getPod() {
		 return	this.pod;
	 } 
 	/**
	* Column Info
	* @param  obrdDt
	*/
	public void	setObrdDt( String	obrdDt ) {
		this.obrdDt =	obrdDt;
	}
 
	/**
	 * Column Info
	 * @return	obrdDt
	 */
	 public	 String	getObrdDt() {
		 return	this.obrdDt;
	 } 
 	/**
	* Column Info
	* @param  blSrcNo
	*/
	public void	setBlSrcNo( String	blSrcNo ) {
		this.blSrcNo =	blSrcNo;
	}
 
	/**
	 * Column Info
	 * @return	blSrcNo
	 */
	 public	 String	getBlSrcNo() {
		 return	this.blSrcNo;
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
		setInvCntryCd(JSPUtil.getParameter(request,	prefix + "inv_cntry_cd", ""));
		setInvCustCd(JSPUtil.getParameter(request,	prefix + "inv_cust_cd", ""));
		setVoy(JSPUtil.getParameter(request,	prefix + "voy", ""));
		setLclCurr(JSPUtil.getParameter(request,	prefix + "lcl_curr", ""));
		setSvcScp(JSPUtil.getParameter(request,	prefix + "svc_scp", ""));
		setBnd(JSPUtil.getParameter(request,	prefix + "bnd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setSaDt(JSPUtil.getParameter(request,	prefix + "sa_dt", ""));
		setVsl(JSPUtil.getParameter(request,	prefix + "vsl", ""));
		setPol(JSPUtil.getParameter(request,	prefix + "pol", ""));
		setCurr(JSPUtil.getParameter(request,	prefix + "curr", ""));
		setDep(JSPUtil.getParameter(request,	prefix + "dep", ""));
		setPod(JSPUtil.getParameter(request,	prefix + "pod", ""));
		setObrdDt(JSPUtil.getParameter(request,	prefix + "obrd_dt", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VVDCustomerVO[]
	 */
	public VVDCustomerVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return VVDCustomerVO[]
	 */
	public VVDCustomerVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		VVDCustomerVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] invCntryCd =	(JSPUtil.getParameter(request, prefix +	"inv_cntry_cd".trim(),	length));
				String[] invCustCd =	(JSPUtil.getParameter(request, prefix +	"inv_cust_cd".trim(),	length));
				String[] voy =	(JSPUtil.getParameter(request, prefix +	"voy".trim(),	length));
				String[] lclCurr =	(JSPUtil.getParameter(request, prefix +	"lcl_curr".trim(),	length));
				String[] svcScp =	(JSPUtil.getParameter(request, prefix +	"svc_scp".trim(),	length));
				String[] bnd =	(JSPUtil.getParameter(request, prefix +	"bnd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] saDt =	(JSPUtil.getParameter(request, prefix +	"sa_dt".trim(),	length));
				String[] vsl =	(JSPUtil.getParameter(request, prefix +	"vsl".trim(),	length));
				String[] pol =	(JSPUtil.getParameter(request, prefix +	"pol".trim(),	length));
				String[] curr =	(JSPUtil.getParameter(request, prefix +	"curr".trim(),	length));
				String[] dep =	(JSPUtil.getParameter(request, prefix +	"dep".trim(),	length));
				String[] pod =	(JSPUtil.getParameter(request, prefix +	"pod".trim(),	length));
				String[] obrdDt =	(JSPUtil.getParameter(request, prefix +	"obrd_dt".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	VVDCustomerVO();
						if ( invCntryCd[i] !=	null)
						model.setInvCntryCd( invCntryCd[i]);
						if ( invCustCd[i] !=	null)
						model.setInvCustCd( invCustCd[i]);
						if ( voy[i] !=	null)
						model.setVoy( voy[i]);
						if ( lclCurr[i] !=	null)
						model.setLclCurr( lclCurr[i]);
						if ( svcScp[i] !=	null)
						model.setSvcScp( svcScp[i]);
						if ( bnd[i] !=	null)
						model.setBnd( bnd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( saDt[i] !=	null)
						model.setSaDt( saDt[i]);
						if ( vsl[i] !=	null)
						model.setVsl( vsl[i]);
						if ( pol[i] !=	null)
						model.setPol( pol[i]);
						if ( curr[i] !=	null)
						model.setCurr( curr[i]);
						if ( dep[i] !=	null)
						model.setDep( dep[i]);
						if ( pod[i] !=	null)
						model.setPod( pod[i]);
						if ( obrdDt[i] !=	null)
						model.setObrdDt( obrdDt[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getVVDCustomerVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return VVDCustomerVO[]
	 */
	public VVDCustomerVO[]	 getVVDCustomerVOs(){
		VVDCustomerVO[] vos = (VVDCustomerVO[])models.toArray(new	VVDCustomerVO[models.size()]);
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
		this.invCntryCd =	this.invCntryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCd =	this.invCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voy =	this.voy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCurr =	this.lclCurr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScp =	this.svcScp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd =	this.bnd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saDt =	this.saDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vsl =	this.vsl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol =	this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr =	this.curr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dep =	this.dep.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod =	this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obrdDt =	this.obrdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}