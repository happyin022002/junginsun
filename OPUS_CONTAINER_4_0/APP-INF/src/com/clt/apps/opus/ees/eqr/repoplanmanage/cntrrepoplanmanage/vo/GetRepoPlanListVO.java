/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : GetRepoPlanListVO.java
 *@FileTitle : GetRepoPlanListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.01.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.01.22  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.eqr.repoplanmanage.cntrrepoplanmanage.vo;

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
public class GetRepoPlanListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<GetRepoPlanListVO>  models =	new	ArrayList<GetRepoPlanListVO>();


	/*	Column Info	*/
	private  String	 manual   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 repoPlnId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 scnrId   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 auto   =  null;
	/*	Column Info	*/
	private  String	 repoPlnDtrbFlg   =  null;
	/*	Column Info	*/
	private  String	 usrid   =  null;
	/*	Column Info	*/
	private  String	 repoPlnRmk   =  null;
	/*	Column Info	*/
	private  String	 week   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 bkg_no   =  null;
	/*	Column Info	*/
	private  String	 so_no   =  null;
	/*	Column Info	*/
	private  String	 fm_rcc_cd   =  null;
	/*	Column Info	*/
	private  String	 fm_lcc_cd   =  null;
	/*	Column Info	*/
	private  String	 fm_ecc_cd   =  null;
	/*	Column Info	*/
	private  String	 fm_loc_cd   =  null;
	/*	Column Info	*/
	private  String	 fm_yard_cd   =  null;
	/*	Column Info	*/
	private  String	 to_rcc_cd   =  null;
	/*	Column Info	*/
	private  String	 to_lcc_cd   =  null;
	/*	Column Info	*/
	private  String	 to_ecc_cd   =  null;
	/*	Column Info	*/
	private  String	 to_loc_cd   =  null;
	/*	Column Info	*/
	private  String	 to_yard_cd   =  null;
	/*	Column Info	*/
	private  String	 usr_id   =  null;
	/*	Column Info	*/
	private  String	 ref_id   =  null;
	/*	Column Info	*/
	private  String	 ep_tp_cd   =  null;
	/*	Column Info	*/
	private  String	 dat_tp_cd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public GetRepoPlanListVO(){}

	public GetRepoPlanListVO(String manual,String updDt,String repoPlnId,String ibflag,String scnrId,String creDt,String auto,String repoPlnDtrbFlg,String usrid,String repoPlnRmk,String week,String pagerows,String vvd,String bkg_no,String so_no,String fm_rcc_cd,String fm_lcc_cd,String fm_ecc_cd,String fm_loc_cd,String fm_yard_cd,String to_rcc_cd,String to_lcc_cd,String to_ecc_cd,String to_loc_cd,String to_yard_cd,String usr_id,String ref_id,String ep_tp_cd,String dat_tp_cd)	{
		this.manual  = manual ;
		this.updDt  = updDt ;
		this.repoPlnId  = repoPlnId ;
		this.ibflag  = ibflag ;
		this.scnrId  = scnrId ;
		this.creDt  = creDt ;
		this.auto  = auto ;
		this.repoPlnDtrbFlg  = repoPlnDtrbFlg ;
		this.usrid  = usrid ;
		this.repoPlnRmk  = repoPlnRmk ;
		this.week  = week ;
		this.pagerows  = pagerows ;
		this.vvd  = vvd ;
		this.bkg_no  = bkg_no ;
		this.so_no  = so_no ;
		this.fm_rcc_cd  = fm_rcc_cd ;
		this.fm_lcc_cd  = fm_lcc_cd ;
		this.fm_ecc_cd  = fm_ecc_cd ;
		this.fm_loc_cd  = fm_loc_cd ;
		this.fm_yard_cd  = fm_yard_cd ;
		this.to_rcc_cd  = to_rcc_cd ;
		this.to_lcc_cd  = to_lcc_cd ;
		this.to_ecc_cd  = to_ecc_cd ;
		this.to_loc_cd  = to_loc_cd ;
		this.to_yard_cd  = to_yard_cd ;
		this.usr_id  = usr_id ;
		this.ref_id  = ref_id ;
		this.ep_tp_cd  = ep_tp_cd ;
		this.dat_tp_cd  = dat_tp_cd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("manual", getManual());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("repo_pln_id", getRepoPlnId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("scnr_id", getScnrId());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("auto", getAuto());		
		this.hashColumns.put("repo_pln_dtrb_flg", getRepoPlnDtrbFlg());		
		this.hashColumns.put("usrid", getUsrid());		
		this.hashColumns.put("repo_pln_rmk", getRepoPlnRmk());		
		this.hashColumns.put("week", getWeek());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("bkg_no", getBkg_no());		
		this.hashColumns.put("so_no", getSo_no());		
		this.hashColumns.put("fm_rcc_cd", getFm_rcc_cd());		
		this.hashColumns.put("fm_lcc_cd", getFm_lcc_cd());		
		this.hashColumns.put("fm_ecc_cd", getFm_ecc_cd());		
		this.hashColumns.put("fm_loc_cd", getFm_loc_cd());		
		this.hashColumns.put("fm_yard_cd", getFm_yard_cd());		
		this.hashColumns.put("to_rcc_cd", getTo_rcc_cd());		
		this.hashColumns.put("to_lcc_cd", getTo_lcc_cd());		
		this.hashColumns.put("to_ecc_cd", getTo_ecc_cd());		
		this.hashColumns.put("to_loc_cd", getTo_loc_cd());		
		this.hashColumns.put("to_yard_cd", getTo_yard_cd());		
		this.hashColumns.put("usr_id", getUsr_id());		
		this.hashColumns.put("ref_id", getRef_id());		
		this.hashColumns.put("ep_tp_cd", getEp_tp_cd());		
		this.hashColumns.put("dat_tp_cd", getDat_tp_cd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("manual", "manual");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("auto", "auto");
		this.hashFields.put("repo_pln_dtrb_flg", "repoPlnDtrbFlg");
		this.hashFields.put("usrid", "usrid");
		this.hashFields.put("repo_pln_rmk", "repoPlnRmk");
		this.hashFields.put("week", "week");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_no", "bkg_no");
		this.hashFields.put("so_no", "so_no");
		this.hashFields.put("fm_rcc_cd", "fm_rcc_cd");
		this.hashFields.put("fm_lcc_cd", "fm_lcc_cd");
		this.hashFields.put("fm_ecc_cd", "fm_ecc_cd");
		this.hashFields.put("fm_loc_cd", "fm_loc_cd");
		this.hashFields.put("fm_yard_cd", "fm_yard_cd");
		this.hashFields.put("to_rcc_cd", "to_rcc_cd");
		this.hashFields.put("to_lcc_cd", "to_lcc_cd");
		this.hashFields.put("to_ecc_cd", "to_ecc_cd");
		this.hashFields.put("to_loc_cd", "to_loc_cd");
		this.hashFields.put("to_yard_cd", "to_yard_cd");
		this.hashFields.put("usr_id", "usr_id");
		this.hashFields.put("ref_id", "ref_id");
		this.hashFields.put("ep_tp_cd", "ep_tp_cd");
		this.hashFields.put("dat_tp_cd", "dat_tp_cd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  manual
	*/
	public void	setManual( String	manual ) {
		this.manual =	manual;
	}
 
	/**
	 * Column Info
	 * @return	manual
	 */
	 public	 String	getManual() {
		 return	this.manual;
	 } 
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
	* @param  repoPlnId
	*/
	public void	setRepoPlnId( String	repoPlnId ) {
		this.repoPlnId =	repoPlnId;
	}
 
	/**
	 * Column Info
	 * @return	repoPlnId
	 */
	 public	 String	getRepoPlnId() {
		 return	this.repoPlnId;
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
	* @param  scnrId
	*/
	public void	setScnrId( String	scnrId ) {
		this.scnrId =	scnrId;
	}
 
	/**
	 * Column Info
	 * @return	scnrId
	 */
	 public	 String	getScnrId() {
		 return	this.scnrId;
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
	* @param  auto
	*/
	public void	setAuto( String	auto ) {
		this.auto =	auto;
	}
 
	/**
	 * Column Info
	 * @return	auto
	 */
	 public	 String	getAuto() {
		 return	this.auto;
	 } 
 	/**
	* Column Info
	* @param  repoPlnDtrbFlg
	*/
	public void	setRepoPlnDtrbFlg( String	repoPlnDtrbFlg ) {
		this.repoPlnDtrbFlg =	repoPlnDtrbFlg;
	}
 
	/**
	 * Column Info
	 * @return	repoPlnDtrbFlg
	 */
	 public	 String	getRepoPlnDtrbFlg() {
		 return	this.repoPlnDtrbFlg;
	 } 
 	/**
	* Column Info
	* @param  usrid
	*/
	public void	setUsrid( String	usrid ) {
		this.usrid =	usrid;
	}
 
	/**
	 * Column Info
	 * @return	usrid
	 */
	 public	 String	getUsrid() {
		 return	this.usrid;
	 } 
 	/**
	* Column Info
	* @param  repoPlnRmk
	*/
	public void	setRepoPlnRmk( String	repoPlnRmk ) {
		this.repoPlnRmk =	repoPlnRmk;
	}
 
	/**
	 * Column Info
	 * @return	repoPlnRmk
	 */
	 public	 String	getRepoPlnRmk() {
		 return	this.repoPlnRmk;
	 } 
 	/**
	* Column Info
	* @param  week
	*/
	public void	setWeek( String	week ) {
		this.week =	week;
	}
 
	/**
	 * Column Info
	 * @return	week
	 */
	 public	 String	getWeek() {
		 return	this.week;
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
	* @param  vvd
	*/
	public void	setVvd( String	vvd ) {
		this.vvd =	vvd;
	}
 
	/**
	 * Column Info
	 * @return	vvd
	 */
	 public	 String	getVvd() {
		 return	this.vvd;
	 } 
 	/**
	* Column Info
	* @param  bkg_no
	*/
	public void	setBkg_no( String	bkg_no ) {
		this.bkg_no =	bkg_no;
	}
 
	/**
	 * Column Info
	 * @return	bkg_no
	 */
	 public	 String	getBkg_no() {
		 return	this.bkg_no;
	 } 
 	/**
	* Column Info
	* @param  so_no
	*/
	public void	setSo_no( String	so_no ) {
		this.so_no =	so_no;
	}
 
	/**
	 * Column Info
	 * @return	so_no
	 */
	 public	 String	getSo_no() {
		 return	this.so_no;
	 } 
 	/**
	* Column Info
	* @param  fm_rcc_cd
	*/
	public void	setFm_rcc_cd( String	fm_rcc_cd ) {
		this.fm_rcc_cd =	fm_rcc_cd;
	}
 
	/**
	 * Column Info
	 * @return	fm_rcc_cd
	 */
	 public	 String	getFm_rcc_cd() {
		 return	this.fm_rcc_cd;
	 } 
 	/**
	* Column Info
	* @param  fm_lcc_cd
	*/
	public void	setFm_lcc_cd( String	fm_lcc_cd ) {
		this.fm_lcc_cd =	fm_lcc_cd;
	}
 
	/**
	 * Column Info
	 * @return	fm_lcc_cd
	 */
	 public	 String	getFm_lcc_cd() {
		 return	this.fm_lcc_cd;
	 } 
 	/**
	* Column Info
	* @param  fm_ecc_cd
	*/
	public void	setFm_ecc_cd( String	fm_ecc_cd ) {
		this.fm_ecc_cd =	fm_ecc_cd;
	}
 
	/**
	 * Column Info
	 * @return	fm_ecc_cd
	 */
	 public	 String	getFm_ecc_cd() {
		 return	this.fm_ecc_cd;
	 } 
 	/**
	* Column Info
	* @param  fm_loc_cd
	*/
	public void	setFm_loc_cd( String	fm_loc_cd ) {
		this.fm_loc_cd =	fm_loc_cd;
	}
 
	/**
	 * Column Info
	 * @return	fm_loc_cd
	 */
	 public	 String	getFm_loc_cd() {
		 return	this.fm_loc_cd;
	 } 
 	/**
	* Column Info
	* @param  fm_yard_cd
	*/
	public void	setFm_yard_cd( String	fm_yard_cd ) {
		this.fm_yard_cd =	fm_yard_cd;
	}
 
	/**
	 * Column Info
	 * @return	fm_yard_cd
	 */
	 public	 String	getFm_yard_cd() {
		 return	this.fm_yard_cd;
	 } 
 	/**
	* Column Info
	* @param  to_rcc_cd
	*/
	public void	setTo_rcc_cd( String	to_rcc_cd ) {
		this.to_rcc_cd =	to_rcc_cd;
	}
 
	/**
	 * Column Info
	 * @return	to_rcc_cd
	 */
	 public	 String	getTo_rcc_cd() {
		 return	this.to_rcc_cd;
	 } 
 	/**
	* Column Info
	* @param  to_lcc_cd
	*/
	public void	setTo_lcc_cd( String	to_lcc_cd ) {
		this.to_lcc_cd =	to_lcc_cd;
	}
 
	/**
	 * Column Info
	 * @return	to_lcc_cd
	 */
	 public	 String	getTo_lcc_cd() {
		 return	this.to_lcc_cd;
	 } 
 	/**
	* Column Info
	* @param  to_ecc_cd
	*/
	public void	setTo_ecc_cd( String	to_ecc_cd ) {
		this.to_ecc_cd =	to_ecc_cd;
	}
 
	/**
	 * Column Info
	 * @return	to_ecc_cd
	 */
	 public	 String	getTo_ecc_cd() {
		 return	this.to_ecc_cd;
	 } 
 	/**
	* Column Info
	* @param  to_loc_cd
	*/
	public void	setTo_loc_cd( String	to_loc_cd ) {
		this.to_loc_cd =	to_loc_cd;
	}
 
	/**
	 * Column Info
	 * @return	to_loc_cd
	 */
	 public	 String	getTo_loc_cd() {
		 return	this.to_loc_cd;
	 } 
 	/**
	* Column Info
	* @param  to_yard_cd
	*/
	public void	setTo_yard_cd( String	to_yard_cd ) {
		this.to_yard_cd =	to_yard_cd;
	}
 
	/**
	 * Column Info
	 * @return	to_yard_cd
	 */
	 public	 String	getTo_yard_cd() {
		 return	this.to_yard_cd;
	 } 
 	/**
	* Column Info
	* @param  usr_id
	*/
	public void	setUsr_id( String	usr_id ) {
		this.usr_id =	usr_id;
	}
 
	/**
	 * Column Info
	 * @return	usr_id
	 */
	 public	 String	getUsr_id() {
		 return	this.usr_id;
	 } 
 	/**
	* Column Info
	* @param  ref_id
	*/
	public void	setRef_id( String	ref_id ) {
		this.ref_id =	ref_id;
	}
 
	/**
	 * Column Info
	 * @return	ref_id
	 */
	 public	 String	getRef_id() {
		 return	this.ref_id;
	 } 
 	/**
	* Column Info
	* @param  ep_tp_cd
	*/
	public void	setEp_tp_cd( String	ep_tp_cd ) {
		this.ep_tp_cd =	ep_tp_cd;
	}
 
	/**
	 * Column Info
	 * @return	ep_tp_cd
	 */
	 public	 String	getEp_tp_cd() {
		 return	this.ep_tp_cd;
	 } 
 	/**
	* Column Info
	* @param  dat_tp_cd
	*/
	public void	setDat_tp_cd( String	dat_tp_cd ) {
		this.dat_tp_cd =	dat_tp_cd;
	}
 
	/**
	 * Column Info
	 * @return	dat_tp_cd
	 */
	 public	 String	getDat_tp_cd() {
		 return	this.dat_tp_cd;
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
		setManual(JSPUtil.getParameter(request,	prefix + "manual", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setRepoPlnId(JSPUtil.getParameter(request,	prefix + "repo_pln_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setScnrId(JSPUtil.getParameter(request,	prefix + "scnr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setAuto(JSPUtil.getParameter(request,	prefix + "auto", ""));
		setRepoPlnDtrbFlg(JSPUtil.getParameter(request,	prefix + "repo_pln_dtrb_flg", ""));
		setUsrid(JSPUtil.getParameter(request,	prefix + "usrid", ""));
		setRepoPlnRmk(JSPUtil.getParameter(request,	prefix + "repo_pln_rmk", ""));
		setWeek(JSPUtil.getParameter(request,	prefix + "week", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setBkg_no(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setSo_no(JSPUtil.getParameter(request,	prefix + "so_no", ""));
		setFm_rcc_cd(JSPUtil.getParameter(request,	prefix + "fm_rcc_cd", ""));
		setFm_lcc_cd(JSPUtil.getParameter(request,	prefix + "fm_lcc_cd", ""));
		setFm_ecc_cd(JSPUtil.getParameter(request,	prefix + "fm_ecc_cd", ""));
		setFm_loc_cd(JSPUtil.getParameter(request,	prefix + "fm_loc_cd", ""));
		setFm_yard_cd(JSPUtil.getParameter(request,	prefix + "fm_yard_cd", ""));
		setTo_rcc_cd(JSPUtil.getParameter(request,	prefix + "to_rcc_cd", ""));
		setTo_lcc_cd(JSPUtil.getParameter(request,	prefix + "to_lcc_cd", ""));
		setTo_ecc_cd(JSPUtil.getParameter(request,	prefix + "to_ecc_cd", ""));
		setTo_loc_cd(JSPUtil.getParameter(request,	prefix + "to_loc_cd", ""));
		setTo_yard_cd(JSPUtil.getParameter(request,	prefix + "to_yard_cd", ""));
		setUsr_id(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setRef_id(JSPUtil.getParameter(request,	prefix + "ref_id", ""));
		setEp_tp_cd(JSPUtil.getParameter(request,	prefix + "ep_tp_cd", ""));
		setDat_tp_cd(JSPUtil.getParameter(request,	prefix + "dat_tp_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GetRepoPlanListVO[]
	 */
	public GetRepoPlanListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return GetRepoPlanListVO[]
	 */
	public GetRepoPlanListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		GetRepoPlanListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] manual =	(JSPUtil.getParameter(request, prefix +	"manual".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] repoPlnId =	(JSPUtil.getParameter(request, prefix +	"repo_pln_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] scnrId =	(JSPUtil.getParameter(request, prefix +	"scnr_id".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] auto =	(JSPUtil.getParameter(request, prefix +	"auto".trim(),	length));
				String[] repoPlnDtrbFlg =	(JSPUtil.getParameter(request, prefix +	"repo_pln_dtrb_flg".trim(),	length));
				String[] usrid =	(JSPUtil.getParameter(request, prefix +	"usrid".trim(),	length));
				String[] repoPlnRmk =	(JSPUtil.getParameter(request, prefix +	"repo_pln_rmk".trim(),	length));
				String[] week =	(JSPUtil.getParameter(request, prefix +	"week".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] bkg_no =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] so_no =	(JSPUtil.getParameter(request, prefix +	"so_no".trim(),	length));
				String[] fm_rcc_cd =	(JSPUtil.getParameter(request, prefix +	"fm_rcc_cd".trim(),	length));
				String[] fm_lcc_cd =	(JSPUtil.getParameter(request, prefix +	"fm_lcc_cd".trim(),	length));
				String[] fm_ecc_cd =	(JSPUtil.getParameter(request, prefix +	"fm_ecc_cd".trim(),	length));
				String[] fm_loc_cd =	(JSPUtil.getParameter(request, prefix +	"fm_loc_cd".trim(),	length));
				String[] fm_yard_cd =	(JSPUtil.getParameter(request, prefix +	"fm_yard_cd".trim(),	length));
				String[] to_rcc_cd =	(JSPUtil.getParameter(request, prefix +	"to_rcc_cd".trim(),	length));
				String[] to_lcc_cd =	(JSPUtil.getParameter(request, prefix +	"to_lcc_cd".trim(),	length));
				String[] to_ecc_cd =	(JSPUtil.getParameter(request, prefix +	"to_ecc_cd".trim(),	length));
				String[] to_loc_cd =	(JSPUtil.getParameter(request, prefix +	"to_loc_cd".trim(),	length));
				String[] to_yard_cd =	(JSPUtil.getParameter(request, prefix +	"to_yard_cd".trim(),	length));
				String[] usr_id =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] ref_id =	(JSPUtil.getParameter(request, prefix +	"ref_id".trim(),	length));
				String[] ep_tp_cd =	(JSPUtil.getParameter(request, prefix +	"ep_tp_cd".trim(),	length));
				String[] dat_tp_cd =	(JSPUtil.getParameter(request, prefix +	"dat_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	GetRepoPlanListVO();
						if ( manual[i] !=	null)
						model.setManual( manual[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( repoPlnId[i] !=	null)
						model.setRepoPlnId( repoPlnId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( scnrId[i] !=	null)
						model.setScnrId( scnrId[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( auto[i] !=	null)
						model.setAuto( auto[i]);
						if ( repoPlnDtrbFlg[i] !=	null)
						model.setRepoPlnDtrbFlg( repoPlnDtrbFlg[i]);
						if ( usrid[i] !=	null)
						model.setUsrid( usrid[i]);
						if ( repoPlnRmk[i] !=	null)
						model.setRepoPlnRmk( repoPlnRmk[i]);
						if ( week[i] !=	null)
						model.setWeek( week[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( bkg_no[i] !=	null)
						model.setBkg_no( bkg_no[i]);
						if ( so_no[i] !=	null)
						model.setSo_no( so_no[i]);
						if ( fm_rcc_cd[i] !=	null)
						model.setFm_rcc_cd( fm_rcc_cd[i]);
						if ( fm_lcc_cd[i] !=	null)
						model.setFm_lcc_cd( fm_lcc_cd[i]);
						if ( fm_ecc_cd[i] !=	null)
						model.setFm_ecc_cd( fm_ecc_cd[i]);
						if ( fm_loc_cd[i] !=	null)
						model.setFm_loc_cd( fm_loc_cd[i]);
						if ( fm_yard_cd[i] !=	null)
						model.setFm_yard_cd( fm_yard_cd[i]);
						if ( to_rcc_cd[i] !=	null)
						model.setTo_rcc_cd( to_rcc_cd[i]);
						if ( to_lcc_cd[i] !=	null)
						model.setTo_lcc_cd( to_lcc_cd[i]);
						if ( to_ecc_cd[i] !=	null)
						model.setTo_ecc_cd( to_ecc_cd[i]);
						if ( to_loc_cd[i] !=	null)
						model.setTo_loc_cd( to_loc_cd[i]);
						if ( to_yard_cd[i] !=	null)
						model.setTo_yard_cd( to_yard_cd[i]);
						if ( usr_id[i] !=	null)
						model.setUsr_id( usr_id[i]);
						if ( ref_id[i] !=	null)
						model.setRef_id( ref_id[i]);
						if ( ep_tp_cd[i] !=	null)
						model.setEp_tp_cd( ep_tp_cd[i]);
						if ( dat_tp_cd[i] !=	null)
						model.setDat_tp_cd( dat_tp_cd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getGetRepoPlanListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return GetRepoPlanListVO[]
	 */
	public GetRepoPlanListVO[]	 getGetRepoPlanListVOs(){
		GetRepoPlanListVO[] vos = (GetRepoPlanListVO[])models.toArray(new	GetRepoPlanListVO[models.size()]);
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
		this.manual =	this.manual.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId =	this.repoPlnId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId =	this.scnrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.auto =	this.auto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnDtrbFlg =	this.repoPlnDtrbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrid =	this.usrid.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnRmk =	this.repoPlnRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.week =	this.week.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkg_no =	this.bkg_no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.so_no =	this.so_no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm_rcc_cd =	this.fm_rcc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm_lcc_cd =	this.fm_lcc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm_ecc_cd =	this.fm_ecc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm_loc_cd =	this.fm_loc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fm_yard_cd =	this.fm_yard_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to_rcc_cd =	this.to_rcc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to_lcc_cd =	this.to_lcc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to_ecc_cd =	this.to_ecc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to_loc_cd =	this.to_loc_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.to_yard_cd =	this.to_yard_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usr_id =	this.usr_id.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ref_id =	this.ref_id.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ep_tp_cd =	this.ep_tp_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dat_tp_cd =	this.dat_tp_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}