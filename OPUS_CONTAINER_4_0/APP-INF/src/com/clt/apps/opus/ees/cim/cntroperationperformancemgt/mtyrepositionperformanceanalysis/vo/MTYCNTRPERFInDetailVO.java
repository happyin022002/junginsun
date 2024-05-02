/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : MTYCNTRPERFInDetailVO.java
 *@FileTitle : MTYCNTRPERFInDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.29
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.12.29  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cim.cntroperationperformancemgt.mtyrepositionperformanceanalysis.vo;

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
public class MTYCNTRPERFInDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<MTYCNTRPERFInDetailVO>  models =	new	ArrayList<MTYCNTRPERFInDetailVO>();


	/*	Column Info	*/
	private  String	 yard   =  null;
	/*	Column Info	*/
	private  String	 por   =  null;
	/*	Column Info	*/
	private  String	 scRfaNoTaa   =  null;
	/*	Column Info	*/
	private  String	 lane   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 disposal   =  null;
	/*	Column Info	*/
	private  String	 pol   =  null;
	/*	Column Info	*/
	private  String	 del   =  null;
	/*	Column Info	*/
	private  String	 postEventdate   =  null;
	/*	Column Info	*/
	private  String	 pod   =  null;
	/*	Column Info	*/
	private  String	 imdtexit   =  null;
	/*	Column Info	*/
	private  String	 bkgno   =  null;
	/*	Column Info	*/
	private  String	 mvmt   =  null;
	/*	Column Info	*/
	private  String	 damage   =  null;
	/*	Column Info	*/
	private  String	 tvvd   =  null;
	/*	Column Info	*/
	private  String	 cntrno   =  null;
	/*	Column Info	*/
	private  String	 hngrrack   =  null;
	/*	Column Info	*/
	private  String	 tpsz   =  null;
	/*	Column Info	*/
	private  String	 company   =  null;
	/*	Column Info	*/
	private  String	 cnee   =  null;
	/*	Column Info	*/
	private  String	 seq   =  null;
	/*	Column Info	*/
	private  String	 eventdate   =  null;
	/*	Column Info	*/
	private  String	 autoflag   =  null;
	/*	Column Info	*/
	private  String	 shpr   =  null;
	/*	Column Info	*/
	private  String	 preEventdate   =  null;
	/*	Column Info	*/
	private  String	 dmgFlgDt   =  null;
	/*	Column Info	*/
	private  String	 dmgUnflgDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public MTYCNTRPERFInDetailVO(){}

	public MTYCNTRPERFInDetailVO(String yard,String por,String scRfaNoTaa,String lane,String pagerows,String ibflag,String disposal,String pol,String del,String postEventdate,String pod,String imdtexit,String bkgno,String mvmt,String damage,String tvvd,String cntrno,String hngrrack,String tpsz,String company,String cnee,String seq,String eventdate,String autoflag,String shpr,String preEventdate,String dmgFlgDt,String dmgUnflgDt)	{
		this.yard  = yard ;
		this.por  = por ;
		this.scRfaNoTaa  = scRfaNoTaa ;
		this.lane  = lane ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.disposal  = disposal ;
		this.pol  = pol ;
		this.del  = del ;
		this.postEventdate  = postEventdate ;
		this.pod  = pod ;
		this.imdtexit  = imdtexit ;
		this.bkgno  = bkgno ;
		this.mvmt  = mvmt ;
		this.damage  = damage ;
		this.tvvd  = tvvd ;
		this.cntrno  = cntrno ;
		this.hngrrack  = hngrrack ;
		this.tpsz  = tpsz ;
		this.company  = company ;
		this.cnee  = cnee ;
		this.seq  = seq ;
		this.eventdate  = eventdate ;
		this.autoflag  = autoflag ;
		this.shpr  = shpr ;
		this.preEventdate  = preEventdate ;
		this.dmgFlgDt  = dmgFlgDt ;
		this.dmgUnflgDt  = dmgUnflgDt ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("yard", getYard());		
		this.hashColumns.put("por", getPor());		
		this.hashColumns.put("sc_rfa_no_taa", getScRfaNoTaa());		
		this.hashColumns.put("lane", getLane());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("disposal", getDisposal());		
		this.hashColumns.put("pol", getPol());		
		this.hashColumns.put("del", getDel());		
		this.hashColumns.put("post_eventdate", getPostEventdate());		
		this.hashColumns.put("pod", getPod());		
		this.hashColumns.put("imdtexit", getImdtexit());		
		this.hashColumns.put("bkgno", getBkgno());		
		this.hashColumns.put("mvmt", getMvmt());		
		this.hashColumns.put("damage", getDamage());		
		this.hashColumns.put("tvvd", getTvvd());		
		this.hashColumns.put("cntrno", getCntrno());		
		this.hashColumns.put("hngrrack", getHngrrack());		
		this.hashColumns.put("tpsz", getTpsz());		
		this.hashColumns.put("company", getCompany());		
		this.hashColumns.put("cnee", getCnee());		
		this.hashColumns.put("seq", getSeq());		
		this.hashColumns.put("eventdate", getEventdate());		
		this.hashColumns.put("autoflag", getAutoflag());		
		this.hashColumns.put("shpr", getShpr());		
		this.hashColumns.put("pre_eventdate", getPreEventdate());		
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());		
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("yard", "yard");
		this.hashFields.put("por", "por");
		this.hashFields.put("sc_rfa_no_taa", "scRfaNoTaa");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("disposal", "disposal");
		this.hashFields.put("pol", "pol");
		this.hashFields.put("del", "del");
		this.hashFields.put("post_eventdate", "postEventdate");
		this.hashFields.put("pod", "pod");
		this.hashFields.put("imdtexit", "imdtexit");
		this.hashFields.put("bkgno", "bkgno");
		this.hashFields.put("mvmt", "mvmt");
		this.hashFields.put("damage", "damage");
		this.hashFields.put("tvvd", "tvvd");
		this.hashFields.put("cntrno", "cntrno");
		this.hashFields.put("hngrrack", "hngrrack");
		this.hashFields.put("tpsz", "tpsz");
		this.hashFields.put("company", "company");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("eventdate", "eventdate");
		this.hashFields.put("autoflag", "autoflag");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("pre_eventdate", "preEventdate");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  yard
	*/
	public void	setYard( String	yard ) {
		this.yard =	yard;
	}
 
	/**
	 * Column Info
	 * @return	yard
	 */
	 public	 String	getYard() {
		 return	this.yard;
	 } 
 	/**
	* Column Info
	* @param  por
	*/
	public void	setPor( String	por ) {
		this.por =	por;
	}
 
	/**
	 * Column Info
	 * @return	por
	 */
	 public	 String	getPor() {
		 return	this.por;
	 } 
 	/**
	* Column Info
	* @param  scRfaNoTaa
	*/
	public void	setScRfaNoTaa( String	scRfaNoTaa ) {
		this.scRfaNoTaa =	scRfaNoTaa;
	}
 
	/**
	 * Column Info
	 * @return	scRfaNoTaa
	 */
	 public	 String	getScRfaNoTaa() {
		 return	this.scRfaNoTaa;
	 } 
 	/**
	* Column Info
	* @param  lane
	*/
	public void	setLane( String	lane ) {
		this.lane =	lane;
	}
 
	/**
	 * Column Info
	 * @return	lane
	 */
	 public	 String	getLane() {
		 return	this.lane;
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
	* @param  disposal
	*/
	public void	setDisposal( String	disposal ) {
		this.disposal =	disposal;
	}
 
	/**
	 * Column Info
	 * @return	disposal
	 */
	 public	 String	getDisposal() {
		 return	this.disposal;
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
	* @param  del
	*/
	public void	setDel( String	del ) {
		this.del =	del;
	}
 
	/**
	 * Column Info
	 * @return	del
	 */
	 public	 String	getDel() {
		 return	this.del;
	 } 
 	/**
	* Column Info
	* @param  postEventdate
	*/
	public void	setPostEventdate( String	postEventdate ) {
		this.postEventdate =	postEventdate;
	}
 
	/**
	 * Column Info
	 * @return	postEventdate
	 */
	 public	 String	getPostEventdate() {
		 return	this.postEventdate;
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
	* @param  imdtexit
	*/
	public void	setImdtexit( String	imdtexit ) {
		this.imdtexit =	imdtexit;
	}
 
	/**
	 * Column Info
	 * @return	imdtexit
	 */
	 public	 String	getImdtexit() {
		 return	this.imdtexit;
	 } 
 	/**
	* Column Info
	* @param  bkgno
	*/
	public void	setBkgno( String	bkgno ) {
		this.bkgno =	bkgno;
	}
 
	/**
	 * Column Info
	 * @return	bkgno
	 */
	 public	 String	getBkgno() {
		 return	this.bkgno;
	 } 
 	/**
	* Column Info
	* @param  mvmt
	*/
	public void	setMvmt( String	mvmt ) {
		this.mvmt =	mvmt;
	}
 
	/**
	 * Column Info
	 * @return	mvmt
	 */
	 public	 String	getMvmt() {
		 return	this.mvmt;
	 } 
 	/**
	* Column Info
	* @param  damage
	*/
	public void	setDamage( String	damage ) {
		this.damage =	damage;
	}
 
	/**
	 * Column Info
	 * @return	damage
	 */
	 public	 String	getDamage() {
		 return	this.damage;
	 } 
 	/**
	* Column Info
	* @param  tvvd
	*/
	public void	setTvvd( String	tvvd ) {
		this.tvvd =	tvvd;
	}
 
	/**
	 * Column Info
	 * @return	tvvd
	 */
	 public	 String	getTvvd() {
		 return	this.tvvd;
	 } 
 	/**
	* Column Info
	* @param  cntrno
	*/
	public void	setCntrno( String	cntrno ) {
		this.cntrno =	cntrno;
	}
 
	/**
	 * Column Info
	 * @return	cntrno
	 */
	 public	 String	getCntrno() {
		 return	this.cntrno;
	 } 
 	/**
	* Column Info
	* @param  hngrrack
	*/
	public void	setHngrrack( String	hngrrack ) {
		this.hngrrack =	hngrrack;
	}
 
	/**
	 * Column Info
	 * @return	hngrrack
	 */
	 public	 String	getHngrrack() {
		 return	this.hngrrack;
	 } 
 	/**
	* Column Info
	* @param  tpsz
	*/
	public void	setTpsz( String	tpsz ) {
		this.tpsz =	tpsz;
	}
 
	/**
	 * Column Info
	 * @return	tpsz
	 */
	 public	 String	getTpsz() {
		 return	this.tpsz;
	 } 
 	/**
	* Column Info
	* @param  company
	*/
	public void	setCompany( String	company ) {
		this.company =	company;
	}
 
	/**
	 * Column Info
	 * @return	company
	 */
	 public	 String	getCompany() {
		 return	this.company;
	 } 
 	/**
	* Column Info
	* @param  cnee
	*/
	public void	setCnee( String	cnee ) {
		this.cnee =	cnee;
	}
 
	/**
	 * Column Info
	 * @return	cnee
	 */
	 public	 String	getCnee() {
		 return	this.cnee;
	 } 
 	/**
	* Column Info
	* @param  seq
	*/
	public void	setSeq( String	seq ) {
		this.seq =	seq;
	}
 
	/**
	 * Column Info
	 * @return	seq
	 */
	 public	 String	getSeq() {
		 return	this.seq;
	 } 
 	/**
	* Column Info
	* @param  eventdate
	*/
	public void	setEventdate( String	eventdate ) {
		this.eventdate =	eventdate;
	}
 
	/**
	 * Column Info
	 * @return	eventdate
	 */
	 public	 String	getEventdate() {
		 return	this.eventdate;
	 } 
 	/**
	* Column Info
	* @param  autoflag
	*/
	public void	setAutoflag( String	autoflag ) {
		this.autoflag =	autoflag;
	}
 
	/**
	 * Column Info
	 * @return	autoflag
	 */
	 public	 String	getAutoflag() {
		 return	this.autoflag;
	 } 
 	/**
	* Column Info
	* @param  shpr
	*/
	public void	setShpr( String	shpr ) {
		this.shpr =	shpr;
	}
 
	/**
	 * Column Info
	 * @return	shpr
	 */
	 public	 String	getShpr() {
		 return	this.shpr;
	 } 
 	/**
	* Column Info
	* @param  preEventdate
	*/
	public void	setPreEventdate( String	preEventdate ) {
		this.preEventdate =	preEventdate;
	}
 
	/**
	 * Column Info
	 * @return	preEventdate
	 */
	 public	 String	getPreEventdate() {
		 return	this.preEventdate;
	 } 
 	/**
	* Column Info
	* @param  dmgFlgDt
	*/
	public void	setDmgFlgDt( String	dmgFlgDt ) {
		this.dmgFlgDt =	dmgFlgDt;
	}
 
	/**
	 * Column Info
	 * @return	dmgFlgDt
	 */
	 public	 String	getDmgFlgDt() {
		 return	this.dmgFlgDt;
	 } 
 	/**
	* Column Info
	* @param  dmgUnflgDt
	*/
	public void	setDmgUnflgDt( String	dmgUnflgDt ) {
		this.dmgUnflgDt =	dmgUnflgDt;
	}
 
	/**
	 * Column Info
	 * @return	dmgUnflgDt
	 */
	 public	 String	getDmgUnflgDt() {
		 return	this.dmgUnflgDt;
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
		setYard(JSPUtil.getParameter(request,	prefix + "yard", ""));
		setPor(JSPUtil.getParameter(request,	prefix + "por", ""));
		setScRfaNoTaa(JSPUtil.getParameter(request,	prefix + "sc_rfa_no_taa", ""));
		setLane(JSPUtil.getParameter(request,	prefix + "lane", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setDisposal(JSPUtil.getParameter(request,	prefix + "disposal", ""));
		setPol(JSPUtil.getParameter(request,	prefix + "pol", ""));
		setDel(JSPUtil.getParameter(request,	prefix + "del", ""));
		setPostEventdate(JSPUtil.getParameter(request,	prefix + "post_eventdate", ""));
		setPod(JSPUtil.getParameter(request,	prefix + "pod", ""));
		setImdtexit(JSPUtil.getParameter(request,	prefix + "imdtexit", ""));
		setBkgno(JSPUtil.getParameter(request,	prefix + "bkgno", ""));
		setMvmt(JSPUtil.getParameter(request,	prefix + "mvmt", ""));
		setDamage(JSPUtil.getParameter(request,	prefix + "damage", ""));
		setTvvd(JSPUtil.getParameter(request,	prefix + "tvvd", ""));
		setCntrno(JSPUtil.getParameter(request,	prefix + "cntrno", ""));
		setHngrrack(JSPUtil.getParameter(request,	prefix + "hngrrack", ""));
		setTpsz(JSPUtil.getParameter(request,	prefix + "tpsz", ""));
		setCompany(JSPUtil.getParameter(request,	prefix + "company", ""));
		setCnee(JSPUtil.getParameter(request,	prefix + "cnee", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setEventdate(JSPUtil.getParameter(request,	prefix + "eventdate", ""));
		setAutoflag(JSPUtil.getParameter(request,	prefix + "autoflag", ""));
		setShpr(JSPUtil.getParameter(request,	prefix + "shpr", ""));
		setPreEventdate(JSPUtil.getParameter(request,	prefix + "pre_eventdate", ""));
		setDmgFlgDt(JSPUtil.getParameter(request,	prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request,	prefix + "dmg_unflg_dt", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return MTYCNTRPERFInDetailVO[]
	 */
	public MTYCNTRPERFInDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return MTYCNTRPERFInDetailVO[]
	 */
	public MTYCNTRPERFInDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		MTYCNTRPERFInDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] yard =	(JSPUtil.getParameter(request, prefix +	"yard".trim(),	length));
				String[] por =	(JSPUtil.getParameter(request, prefix +	"por".trim(),	length));
				String[] scRfaNoTaa =	(JSPUtil.getParameter(request, prefix +	"sc_rfa_no_taa".trim(),	length));
				String[] lane =	(JSPUtil.getParameter(request, prefix +	"lane".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] disposal =	(JSPUtil.getParameter(request, prefix +	"disposal".trim(),	length));
				String[] pol =	(JSPUtil.getParameter(request, prefix +	"pol".trim(),	length));
				String[] del =	(JSPUtil.getParameter(request, prefix +	"del".trim(),	length));
				String[] postEventdate =	(JSPUtil.getParameter(request, prefix +	"post_eventdate".trim(),	length));
				String[] pod =	(JSPUtil.getParameter(request, prefix +	"pod".trim(),	length));
				String[] imdtexit =	(JSPUtil.getParameter(request, prefix +	"imdtexit".trim(),	length));
				String[] bkgno =	(JSPUtil.getParameter(request, prefix +	"bkgno".trim(),	length));
				String[] mvmt =	(JSPUtil.getParameter(request, prefix +	"mvmt".trim(),	length));
				String[] damage =	(JSPUtil.getParameter(request, prefix +	"damage".trim(),	length));
				String[] tvvd =	(JSPUtil.getParameter(request, prefix +	"tvvd".trim(),	length));
				String[] cntrno =	(JSPUtil.getParameter(request, prefix +	"cntrno".trim(),	length));
				String[] hngrrack =	(JSPUtil.getParameter(request, prefix +	"hngrrack".trim(),	length));
				String[] tpsz =	(JSPUtil.getParameter(request, prefix +	"tpsz".trim(),	length));
				String[] company =	(JSPUtil.getParameter(request, prefix +	"company".trim(),	length));
				String[] cnee =	(JSPUtil.getParameter(request, prefix +	"cnee".trim(),	length));
				String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq".trim(),	length));
				String[] eventdate =	(JSPUtil.getParameter(request, prefix +	"eventdate".trim(),	length));
				String[] autoflag =	(JSPUtil.getParameter(request, prefix +	"autoflag".trim(),	length));
				String[] shpr =	(JSPUtil.getParameter(request, prefix +	"shpr".trim(),	length));
				String[] preEventdate =	(JSPUtil.getParameter(request, prefix +	"pre_eventdate".trim(),	length));
				String[] dmgFlgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_flg_dt".trim(),	length));
				String[] dmgUnflgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_unflg_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	MTYCNTRPERFInDetailVO();
						if ( yard[i] !=	null)
						model.setYard( yard[i]);
						if ( por[i] !=	null)
						model.setPor( por[i]);
						if ( scRfaNoTaa[i] !=	null)
						model.setScRfaNoTaa( scRfaNoTaa[i]);
						if ( lane[i] !=	null)
						model.setLane( lane[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( disposal[i] !=	null)
						model.setDisposal( disposal[i]);
						if ( pol[i] !=	null)
						model.setPol( pol[i]);
						if ( del[i] !=	null)
						model.setDel( del[i]);
						if ( postEventdate[i] !=	null)
						model.setPostEventdate( postEventdate[i]);
						if ( pod[i] !=	null)
						model.setPod( pod[i]);
						if ( imdtexit[i] !=	null)
						model.setImdtexit( imdtexit[i]);
						if ( bkgno[i] !=	null)
						model.setBkgno( bkgno[i]);
						if ( mvmt[i] !=	null)
						model.setMvmt( mvmt[i]);
						if ( damage[i] !=	null)
						model.setDamage( damage[i]);
						if ( tvvd[i] !=	null)
						model.setTvvd( tvvd[i]);
						if ( cntrno[i] !=	null)
						model.setCntrno( cntrno[i]);
						if ( hngrrack[i] !=	null)
						model.setHngrrack( hngrrack[i]);
						if ( tpsz[i] !=	null)
						model.setTpsz( tpsz[i]);
						if ( company[i] !=	null)
						model.setCompany( company[i]);
						if ( cnee[i] !=	null)
						model.setCnee( cnee[i]);
						if ( seq[i] !=	null)
						model.setSeq( seq[i]);
						if ( eventdate[i] !=	null)
						model.setEventdate( eventdate[i]);
						if ( autoflag[i] !=	null)
						model.setAutoflag( autoflag[i]);
						if ( shpr[i] !=	null)
						model.setShpr( shpr[i]);
						if ( preEventdate[i] !=	null)
						model.setPreEventdate( preEventdate[i]);
						if ( dmgFlgDt[i] !=	null)
						model.setDmgFlgDt( dmgFlgDt[i]);
						if ( dmgUnflgDt[i] !=	null)
						model.setDmgUnflgDt( dmgUnflgDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getMTYCNTRPERFInDetailVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return MTYCNTRPERFInDetailVO[]
	 */
	public MTYCNTRPERFInDetailVO[]	 getMTYCNTRPERFInDetailVOs(){
		MTYCNTRPERFInDetailVO[] vos = (MTYCNTRPERFInDetailVO[])models.toArray(new	MTYCNTRPERFInDetailVO[models.size()]);
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
		this.yard =	this.yard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.por =	this.por.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNoTaa =	this.scRfaNoTaa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane =	this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.disposal =	this.disposal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pol =	this.pol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.del =	this.del.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postEventdate =	this.postEventdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pod =	this.pod.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtexit =	this.imdtexit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgno =	this.bkgno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmt =	this.mvmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.damage =	this.damage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tvvd =	this.tvvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrno =	this.cntrno.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hngrrack =	this.hngrrack.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsz =	this.tpsz.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.company =	this.company.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee =	this.cnee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eventdate =	this.eventdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.autoflag =	this.autoflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr =	this.shpr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preEventdate =	this.preEventdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt =	this.dmgFlgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt =	this.dmgUnflgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}