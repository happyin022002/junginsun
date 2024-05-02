/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : MaxIFMainVO.java
 *@FileTitle : MaxIFMainVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.25
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.05.25  
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
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class MaxIFMainVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<MaxIFMainVO>  models =	new	ArrayList<MaxIFMainVO>();


	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 createFlag   =  null;
	/*	Column Info	*/
	private  String	 rlaneCd   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 blInvCfmDt   =  null;
	/*	Column Info	*/
	private  String	 bkgFeuQty   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 bkgTeuQty   =  null;
	/*	Column Info	*/
	private  String	 revVvdCd   =  null;
	/*	Column Info	*/
	private  String	 invDeltDivCd   =  null;
	/*	Column Info	*/
	private  String	 blInvIfDt   =  null;
	/*	Column Info	*/
	private  String	 oldArIfNo   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public MaxIFMainVO(){}

	public MaxIFMainVO(String svcScpCd,String createFlag,String rlaneCd,String ioBndCd,String arOfcCd,String pagerows,String podCd,String blInvCfmDt,String bkgFeuQty,String locCd,String bkgNo,String ibflag,String polCd,String slanCd,String vvdCd,String arIfNo,String bkgTeuQty,String revVvdCd,String invDeltDivCd,String blInvIfDt,String oldArIfNo,String creUsrId,String loclCurrCd)	{
		this.svcScpCd  = svcScpCd ;
		this.createFlag  = createFlag ;
		this.rlaneCd  = rlaneCd ;
		this.ioBndCd  = ioBndCd ;
		this.arOfcCd  = arOfcCd ;
		this.pagerows  = pagerows ;
		this.podCd  = podCd ;
		this.blInvCfmDt  = blInvCfmDt ;
		this.bkgFeuQty  = bkgFeuQty ;
		this.locCd  = locCd ;
		this.bkgNo  = bkgNo ;
		this.ibflag  = ibflag ;
		this.polCd  = polCd ;
		this.slanCd  = slanCd ;
		this.vvdCd  = vvdCd ;
		this.arIfNo  = arIfNo ;
		this.bkgTeuQty  = bkgTeuQty ;
		this.revVvdCd  = revVvdCd ;
		this.invDeltDivCd  = invDeltDivCd ;
		this.blInvIfDt  = blInvIfDt ;
		this.oldArIfNo  = oldArIfNo ;
		this.creUsrId  = creUsrId ;
		this.loclCurrCd  = loclCurrCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("create_flag", getCreateFlag());		
		this.hashColumns.put("rlane_cd", getRlaneCd());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());		
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("slan_cd", getSlanCd());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());		
		this.hashColumns.put("rev_vvd_cd", getRevVvdCd());		
		this.hashColumns.put("inv_delt_div_cd", getInvDeltDivCd());		
		this.hashColumns.put("bl_inv_if_dt", getBlInvIfDt());		
		this.hashColumns.put("old_ar_if_no", getOldArIfNo());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("create_flag", "createFlag");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("rev_vvd_cd", "revVvdCd");
		this.hashFields.put("inv_delt_div_cd", "invDeltDivCd");
		this.hashFields.put("bl_inv_if_dt", "blInvIfDt");
		this.hashFields.put("old_ar_if_no", "oldArIfNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  svcScpCd
	*/
	public void	setSvcScpCd( String	svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 
	/**
	 * Column Info
	 * @return	svcScpCd
	 */
	 public	 String	getSvcScpCd() {
		 return	this.svcScpCd;
	 } 
 	/**
	* Column Info
	* @param  createFlag
	*/
	public void	setCreateFlag( String	createFlag ) {
		this.createFlag =	createFlag;
	}
 
	/**
	 * Column Info
	 * @return	createFlag
	 */
	 public	 String	getCreateFlag() {
		 return	this.createFlag;
	 } 
 	/**
	* Column Info
	* @param  rlaneCd
	*/
	public void	setRlaneCd( String	rlaneCd ) {
		this.rlaneCd =	rlaneCd;
	}
 
	/**
	 * Column Info
	 * @return	rlaneCd
	 */
	 public	 String	getRlaneCd() {
		 return	this.rlaneCd;
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
	* @param  arOfcCd
	*/
	public void	setArOfcCd( String	arOfcCd ) {
		this.arOfcCd =	arOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	arOfcCd
	 */
	 public	 String	getArOfcCd() {
		 return	this.arOfcCd;
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
	* @param  podCd
	*/
	public void	setPodCd( String	podCd ) {
		this.podCd =	podCd;
	}
 
	/**
	 * Column Info
	 * @return	podCd
	 */
	 public	 String	getPodCd() {
		 return	this.podCd;
	 } 
 	/**
	* Column Info
	* @param  blInvCfmDt
	*/
	public void	setBlInvCfmDt( String	blInvCfmDt ) {
		this.blInvCfmDt =	blInvCfmDt;
	}
 
	/**
	 * Column Info
	 * @return	blInvCfmDt
	 */
	 public	 String	getBlInvCfmDt() {
		 return	this.blInvCfmDt;
	 } 
 	/**
	* Column Info
	* @param  bkgFeuQty
	*/
	public void	setBkgFeuQty( String	bkgFeuQty ) {
		this.bkgFeuQty =	bkgFeuQty;
	}
 
	/**
	 * Column Info
	 * @return	bkgFeuQty
	 */
	 public	 String	getBkgFeuQty() {
		 return	this.bkgFeuQty;
	 } 
 	/**
	* Column Info
	* @param  locCd
	*/
	public void	setLocCd( String	locCd ) {
		this.locCd =	locCd;
	}
 
	/**
	 * Column Info
	 * @return	locCd
	 */
	 public	 String	getLocCd() {
		 return	this.locCd;
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
	* @param  polCd
	*/
	public void	setPolCd( String	polCd ) {
		this.polCd =	polCd;
	}
 
	/**
	 * Column Info
	 * @return	polCd
	 */
	 public	 String	getPolCd() {
		 return	this.polCd;
	 } 
 	/**
	* Column Info
	* @param  slanCd
	*/
	public void	setSlanCd( String	slanCd ) {
		this.slanCd =	slanCd;
	}
 
	/**
	 * Column Info
	 * @return	slanCd
	 */
	 public	 String	getSlanCd() {
		 return	this.slanCd;
	 } 
 	/**
	* Column Info
	* @param  vvdCd
	*/
	public void	setVvdCd( String	vvdCd ) {
		this.vvdCd =	vvdCd;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd
	 */
	 public	 String	getVvdCd() {
		 return	this.vvdCd;
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
	* @param  bkgTeuQty
	*/
	public void	setBkgTeuQty( String	bkgTeuQty ) {
		this.bkgTeuQty =	bkgTeuQty;
	}
 
	/**
	 * Column Info
	 * @return	bkgTeuQty
	 */
	 public	 String	getBkgTeuQty() {
		 return	this.bkgTeuQty;
	 } 
 	/**
	* Column Info
	* @param  revVvdCd
	*/
	public void	setRevVvdCd( String	revVvdCd ) {
		this.revVvdCd =	revVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	revVvdCd
	 */
	 public	 String	getRevVvdCd() {
		 return	this.revVvdCd;
	 } 
 	/**
	* Column Info
	* @param  invDeltDivCd
	*/
	public void	setInvDeltDivCd( String	invDeltDivCd ) {
		this.invDeltDivCd =	invDeltDivCd;
	}
 
	/**
	 * Column Info
	 * @return	invDeltDivCd
	 */
	 public	 String	getInvDeltDivCd() {
		 return	this.invDeltDivCd;
	 } 
 	/**
	* Column Info
	* @param  blInvIfDt
	*/
	public void	setBlInvIfDt( String	blInvIfDt ) {
		this.blInvIfDt =	blInvIfDt;
	}
 
	/**
	 * Column Info
	 * @return	blInvIfDt
	 */
	 public	 String	getBlInvIfDt() {
		 return	this.blInvIfDt;
	 } 
 	/**
	* Column Info
	* @param  oldArIfNo
	*/
	public void	setOldArIfNo( String	oldArIfNo ) {
		this.oldArIfNo =	oldArIfNo;
	}
 
	/**
	 * Column Info
	 * @return	oldArIfNo
	 */
	 public	 String	getOldArIfNo() {
		 return	this.oldArIfNo;
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
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setCreateFlag(JSPUtil.getParameter(request,	prefix + "create_flag", ""));
		setRlaneCd(JSPUtil.getParameter(request,	prefix + "rlane_cd", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request,	prefix + "bl_inv_cfm_dt", ""));
		setBkgFeuQty(JSPUtil.getParameter(request,	prefix + "bkg_feu_qty", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setBkgTeuQty(JSPUtil.getParameter(request,	prefix + "bkg_teu_qty", ""));
		setRevVvdCd(JSPUtil.getParameter(request,	prefix + "rev_vvd_cd", ""));
		setInvDeltDivCd(JSPUtil.getParameter(request,	prefix + "inv_delt_div_cd", ""));
		setBlInvIfDt(JSPUtil.getParameter(request,	prefix + "bl_inv_if_dt", ""));
		setOldArIfNo(JSPUtil.getParameter(request,	prefix + "old_ar_if_no", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MaxIFMainVO[]
	 */
	public MaxIFMainVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return MaxIFMainVO[]
	 */
	public MaxIFMainVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		MaxIFMainVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] createFlag =	(JSPUtil.getParameter(request, prefix +	"create_flag".trim(),	length));
				String[] rlaneCd =	(JSPUtil.getParameter(request, prefix +	"rlane_cd".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] blInvCfmDt =	(JSPUtil.getParameter(request, prefix +	"bl_inv_cfm_dt".trim(),	length));
				String[] bkgFeuQty =	(JSPUtil.getParameter(request, prefix +	"bkg_feu_qty".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] bkgTeuQty =	(JSPUtil.getParameter(request, prefix +	"bkg_teu_qty".trim(),	length));
				String[] revVvdCd =	(JSPUtil.getParameter(request, prefix +	"rev_vvd_cd".trim(),	length));
				String[] invDeltDivCd =	(JSPUtil.getParameter(request, prefix +	"inv_delt_div_cd".trim(),	length));
				String[] blInvIfDt =	(JSPUtil.getParameter(request, prefix +	"bl_inv_if_dt".trim(),	length));
				String[] oldArIfNo =	(JSPUtil.getParameter(request, prefix +	"old_ar_if_no".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	MaxIFMainVO();
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( createFlag[i] !=	null)
						model.setCreateFlag( createFlag[i]);
						if ( rlaneCd[i] !=	null)
						model.setRlaneCd( rlaneCd[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( blInvCfmDt[i] !=	null)
						model.setBlInvCfmDt( blInvCfmDt[i]);
						if ( bkgFeuQty[i] !=	null)
						model.setBkgFeuQty( bkgFeuQty[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( slanCd[i] !=	null)
						model.setSlanCd( slanCd[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( bkgTeuQty[i] !=	null)
						model.setBkgTeuQty( bkgTeuQty[i]);
						if ( revVvdCd[i] !=	null)
						model.setRevVvdCd( revVvdCd[i]);
						if ( invDeltDivCd[i] !=	null)
						model.setInvDeltDivCd( invDeltDivCd[i]);
						if ( blInvIfDt[i] !=	null)
						model.setBlInvIfDt( blInvIfDt[i]);
						if ( oldArIfNo[i] !=	null)
						model.setOldArIfNo( oldArIfNo[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getMaxIFMainVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return MaxIFMainVO[]
	 */
	public MaxIFMainVO[]	 getMaxIFMainVOs(){
		MaxIFMainVO[] vos = (MaxIFMainVO[])models.toArray(new	MaxIFMainVO[models.size()]);
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
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.createFlag =	this.createFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd =	this.rlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt =	this.blInvCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty =	this.bkgFeuQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty =	this.bkgTeuQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdCd =	this.revVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDeltDivCd =	this.invDeltDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvIfDt =	this.blInvIfDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldArIfNo =	this.oldArIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}