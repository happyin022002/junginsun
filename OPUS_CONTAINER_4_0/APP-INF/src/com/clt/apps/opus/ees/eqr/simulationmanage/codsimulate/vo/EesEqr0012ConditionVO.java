/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : EesEqr0012ConditionVO.java
 *@FileTitle : EesEqr0012ConditionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.10.08
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.10.08  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.eqr.simulationmanage.codsimulate.vo;

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
public class EesEqr0012ConditionVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<EesEqr0012ConditionVO>  models =	new	ArrayList<EesEqr0012ConditionVO>();


	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 col   =  null;
	/*	Column Info	*/
	private  String	 trade   =  null;
	/*	Column Info	*/
	private  String	 toplnwk   =  null;
	/*	Column Info	*/
	private  String	 cntrtpszcd   =  null;
	/*	Column Info	*/
	private  String	 vslLocCd   =  null;
	/*	Column Info	*/
	private  String	 searchkey   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 lane   =  null;
	/*	Column Info	*/
	private  String	 newrepoId   =  null;
	/*	Column Info	*/
	private  String	 vslLaneCd   =  null;
	/*	Column Info	*/
	private  String	 fmecccd   =  null;
	/*	Column Info	*/
	private  String	 conti   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 toplnyr   =  null;
	/*	Column Info	*/
	private  String	 totoplnwk   =  null;
	/*	Column Info	*/
	private  String	 viewadaptergubun   =  null;
	/*	Column Info	*/
	private  String	 colname1   =  null;
	/*	Column Info	*/
	private  String	 poscol   =  null;
	/*	Column Info	*/
	private  String	 scnrId   =  null;
	/*	Column Info	*/
	private  String	 colname2   =  null;
	/*	Column Info	*/
	private  String	 row1   =  null;
	/*	Column Info	*/
	private  String	 tpsztypeall   =  null;
	/*	Column Info	*/
	private  String	 toecccd   =  null;
	/*	Column Info	*/
	private  String	 fmtoplnwk   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 fmtoat2   =  null;
	/*	Column Info	*/
	private  String	 fmtype   =  null;
	/*	Column Info	*/
	private  String	 totoplnyr   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 fmtoplnyr   =  null;
	/*	Column Info	*/
	private  String	 lane1   =  null;
	/*	Column Info	*/
	private  String	 vvd1   =  null;
	/*	Column Info	*/
	private  String	 tofmplnyrwk2   =  null;
	/*	Column Info	*/
	private  String	 repoPlnId   =  null;
	/*	Column Info	*/
	private  String	 yyyyww   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 startdate   =  null;
	/*	Column Info	*/
	private  String	 plnyrwk   =  null;
	/*	Column Info	*/
	private  String	 fmplnyr   =  null;
	/*	Column Info	*/
	private  String	 totype   =  null;
	/*	Column Info	*/
	private  String	 seq   =  null;
	/*	Column Info	*/
	private  String	 atfmplnyrwk2   =  null;
	/*	Column Info	*/
	private  String	 enddate   =  null;
	/*	Column Info	*/
	private  String	 fmfmplnyrwk2   =  null;
	/*	Column Info	*/
	private  String	 fmplnwk   =  null;
	/*	Column Info	*/
	private  String	 repormk   =  null;
	/*	Column Info	*/
	private  String	 viewSc   =  null;
	/*	Column Info	*/
	private  String	 fmEtdDate   =  null;
	/*	Column Info	*/
	private  String	 fmContiCd   =  null;
	/*	Column Info	*/
	private  String	 toContiCd   =  null;
	/*	Column Info	*/
	private  String	 exectype   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public EesEqr0012ConditionVO(){}

	public EesEqr0012ConditionVO(String vslCd,String col,String trade,String toplnwk,String cntrtpszcd,String vslLocCd,String searchkey,String pagerows,String lane,String newrepoId,String vslLaneCd,String fmecccd,String conti,String ibflag,String toplnyr,String totoplnwk,String viewadaptergubun,String colname1,String poscol,String scnrId,String colname2,String row1,String tpsztypeall,String toecccd,String fmtoplnwk,String skdVoyNo,String fmtoat2,String fmtype,String totoplnyr,String skdDirCd,String fmtoplnyr,String lane1,String vvd1,String tofmplnyrwk2,String repoPlnId,String yyyyww,String vvd,String startdate,String plnyrwk,String fmplnyr,String totype,String seq,String atfmplnyrwk2,String enddate,String fmfmplnyrwk2,String fmplnwk,String repormk,String viewSc,String fmEtdDate,String fmContiCd,String toContiCd,String exectype)	{
		this.vslCd  = vslCd ;
		this.col  = col ;
		this.trade  = trade ;
		this.toplnwk  = toplnwk ;
		this.cntrtpszcd  = cntrtpszcd ;
		this.vslLocCd  = vslLocCd ;
		this.searchkey  = searchkey ;
		this.pagerows  = pagerows ;
		this.lane  = lane ;
		this.newrepoId  = newrepoId ;
		this.vslLaneCd  = vslLaneCd ;
		this.fmecccd  = fmecccd ;
		this.conti  = conti ;
		this.ibflag  = ibflag ;
		this.toplnyr  = toplnyr ;
		this.totoplnwk  = totoplnwk ;
		this.viewadaptergubun  = viewadaptergubun ;
		this.colname1  = colname1 ;
		this.poscol  = poscol ;
		this.scnrId  = scnrId ;
		this.colname2  = colname2 ;
		this.row1  = row1 ;
		this.tpsztypeall  = tpsztypeall ;
		this.toecccd  = toecccd ;
		this.fmtoplnwk  = fmtoplnwk ;
		this.skdVoyNo  = skdVoyNo ;
		this.fmtoat2  = fmtoat2 ;
		this.fmtype  = fmtype ;
		this.totoplnyr  = totoplnyr ;
		this.skdDirCd  = skdDirCd ;
		this.fmtoplnyr  = fmtoplnyr ;
		this.lane1  = lane1 ;
		this.vvd1  = vvd1 ;
		this.tofmplnyrwk2  = tofmplnyrwk2 ;
		this.repoPlnId  = repoPlnId ;
		this.yyyyww  = yyyyww ;
		this.vvd  = vvd ;
		this.startdate  = startdate ;
		this.plnyrwk  = plnyrwk ;
		this.fmplnyr  = fmplnyr ;
		this.totype  = totype ;
		this.seq  = seq ;
		this.atfmplnyrwk2  = atfmplnyrwk2 ;
		this.enddate  = enddate ;
		this.fmfmplnyrwk2  = fmfmplnyrwk2 ;
		this.fmplnwk  = fmplnwk ;
		this.repormk  = repormk ;
		this.viewSc  = viewSc ;
		this.fmEtdDate  = fmEtdDate ;
		this.fmContiCd  = fmContiCd ;
		this.toContiCd  = toContiCd ;
		this.exectype  = exectype ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("col", getCol());		
		this.hashColumns.put("trade", getTrade());		
		this.hashColumns.put("toplnwk", getToplnwk());		
		this.hashColumns.put("cntrtpszcd", getCntrtpszcd());		
		this.hashColumns.put("vsl_loc_cd", getVslLocCd());		
		this.hashColumns.put("searchkey", getSearchkey());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("lane", getLane());		
		this.hashColumns.put("newrepo_id", getNewrepoId());		
		this.hashColumns.put("vsl_lane_cd", getVslLaneCd());		
		this.hashColumns.put("fmecccd", getFmecccd());		
		this.hashColumns.put("conti", getConti());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("toplnyr", getToplnyr());		
		this.hashColumns.put("totoplnwk", getTotoplnwk());		
		this.hashColumns.put("viewadaptergubun", getViewadaptergubun());		
		this.hashColumns.put("colname1", getColname1());		
		this.hashColumns.put("poscol", getPoscol());		
		this.hashColumns.put("scnr_id", getScnrId());		
		this.hashColumns.put("colname2", getColname2());		
		this.hashColumns.put("row1", getRow1());		
		this.hashColumns.put("tpsztypeall", getTpsztypeall());		
		this.hashColumns.put("toecccd", getToecccd());		
		this.hashColumns.put("fmtoplnwk", getFmtoplnwk());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("fmtoat2", getFmtoat2());		
		this.hashColumns.put("fmtype", getFmtype());		
		this.hashColumns.put("totoplnyr", getTotoplnyr());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("fmtoplnyr", getFmtoplnyr());		
		this.hashColumns.put("lane1", getLane1());		
		this.hashColumns.put("vvd1", getVvd1());		
		this.hashColumns.put("tofmplnyrwk2", getTofmplnyrwk2());		
		this.hashColumns.put("repo_pln_id", getRepoPlnId());		
		this.hashColumns.put("yyyyww", getYyyyww());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("startdate", getStartdate());		
		this.hashColumns.put("plnyrwk", getPlnyrwk());		
		this.hashColumns.put("fmplnyr", getFmplnyr());		
		this.hashColumns.put("totype", getTotype());		
		this.hashColumns.put("seq", getSeq());		
		this.hashColumns.put("atfmplnyrwk2", getAtfmplnyrwk2());		
		this.hashColumns.put("enddate", getEnddate());		
		this.hashColumns.put("fmfmplnyrwk2", getFmfmplnyrwk2());		
		this.hashColumns.put("fmplnwk", getFmplnwk());		
		this.hashColumns.put("repormk", getRepormk());		
		this.hashColumns.put("view_sc", getViewSc());		
		this.hashColumns.put("fm_etd_date", getFmEtdDate());		
		this.hashColumns.put("fm_conti_cd", getFmContiCd());
		this.hashColumns.put("to_conti_cd", getToContiCd());
		this.hashColumns.put("exectype", getExectype());
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("col", "col");
		this.hashFields.put("trade", "trade");
		this.hashFields.put("toplnwk", "toplnwk");
		this.hashFields.put("cntrtpszcd", "cntrtpszcd");
		this.hashFields.put("vsl_loc_cd", "vslLocCd");
		this.hashFields.put("searchkey", "searchkey");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lane", "lane");
		this.hashFields.put("newrepo_id", "newrepoId");
		this.hashFields.put("vsl_lane_cd", "vslLaneCd");
		this.hashFields.put("fmecccd", "fmecccd");
		this.hashFields.put("conti", "conti");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("toplnyr", "toplnyr");
		this.hashFields.put("totoplnwk", "totoplnwk");
		this.hashFields.put("viewadaptergubun", "viewadaptergubun");
		this.hashFields.put("colname1", "colname1");
		this.hashFields.put("poscol", "poscol");
		this.hashFields.put("scnr_id", "scnrId");
		this.hashFields.put("colname2", "colname2");
		this.hashFields.put("row1", "row1");
		this.hashFields.put("tpsztypeall", "tpsztypeall");
		this.hashFields.put("toecccd", "toecccd");
		this.hashFields.put("fmtoplnwk", "fmtoplnwk");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("fmtoat2", "fmtoat2");
		this.hashFields.put("fmtype", "fmtype");
		this.hashFields.put("totoplnyr", "totoplnyr");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("fmtoplnyr", "fmtoplnyr");
		this.hashFields.put("lane1", "lane1");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("tofmplnyrwk2", "tofmplnyrwk2");
		this.hashFields.put("repo_pln_id", "repoPlnId");
		this.hashFields.put("yyyyww", "yyyyww");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("startdate", "startdate");
		this.hashFields.put("plnyrwk", "plnyrwk");
		this.hashFields.put("fmplnyr", "fmplnyr");
		this.hashFields.put("totype", "totype");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("atfmplnyrwk2", "atfmplnyrwk2");
		this.hashFields.put("enddate", "enddate");
		this.hashFields.put("fmfmplnyrwk2", "fmfmplnyrwk2");
		this.hashFields.put("fmplnwk", "fmplnwk");
		this.hashFields.put("repormk", "repormk");
		this.hashFields.put("view_sc", "viewSc");
		this.hashFields.put("fm_etd_date", "fmEtdDate");
		this.hashFields.put("fm_conti_cd", "fmContiCd");
		this.hashFields.put("to_conti_cd", "toContiCd");
		this.hashFields.put("exectype", "exectype");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  vslCd
	*/
	public void	setVslCd( String	vslCd ) {
		this.vslCd =	vslCd;
	}
 
	/**
	 * Column Info
	 * @return	vslCd
	 */
	 public	 String	getVslCd() {
		 return	this.vslCd;
	 } 
 	/**
	* Column Info
	* @param  col
	*/
	public void	setCol( String	col ) {
		this.col =	col;
	}
 
	/**
	 * Column Info
	 * @return	col
	 */
	 public	 String	getCol() {
		 return	this.col;
	 } 
 	/**
	* Column Info
	* @param  trade
	*/
	public void	setTrade( String	trade ) {
		this.trade =	trade;
	}
 
	/**
	 * Column Info
	 * @return	trade
	 */
	 public	 String	getTrade() {
		 return	this.trade;
	 } 
 	/**
	* Column Info
	* @param  toplnwk
	*/
	public void	setToplnwk( String	toplnwk ) {
		this.toplnwk =	toplnwk;
	}
 
	/**
	 * Column Info
	 * @return	toplnwk
	 */
	 public	 String	getToplnwk() {
		 return	this.toplnwk;
	 } 
 	/**
	* Column Info
	* @param  cntrtpszcd
	*/
	public void	setCntrtpszcd( String	cntrtpszcd ) {
		this.cntrtpszcd =	cntrtpszcd;
	}
 
	/**
	 * Column Info
	 * @return	cntrtpszcd
	 */
	 public	 String	getCntrtpszcd() {
		 return	this.cntrtpszcd;
	 } 
 	/**
	* Column Info
	* @param  vslLocCd
	*/
	public void	setVslLocCd( String	vslLocCd ) {
		this.vslLocCd =	vslLocCd;
	}
 
	/**
	 * Column Info
	 * @return	vslLocCd
	 */
	 public	 String	getVslLocCd() {
		 return	this.vslLocCd;
	 } 
 	/**
	* Column Info
	* @param  searchkey
	*/
	public void	setSearchkey( String	searchkey ) {
		this.searchkey =	searchkey;
	}
 
	/**
	 * Column Info
	 * @return	searchkey
	 */
	 public	 String	getSearchkey() {
		 return	this.searchkey;
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
	* @param  newrepoId
	*/
	public void	setNewrepoId( String	newrepoId ) {
		this.newrepoId =	newrepoId;
	}
 
	/**
	 * Column Info
	 * @return	newrepoId
	 */
	 public	 String	getNewrepoId() {
		 return	this.newrepoId;
	 } 
 	/**
	* Column Info
	* @param  vslLaneCd
	*/
	public void	setVslLaneCd( String	vslLaneCd ) {
		this.vslLaneCd =	vslLaneCd;
	}
 
	/**
	 * Column Info
	 * @return	vslLaneCd
	 */
	 public	 String	getVslLaneCd() {
		 return	this.vslLaneCd;
	 } 
 	/**
	* Column Info
	* @param  fmecccd
	*/
	public void	setFmecccd( String	fmecccd ) {
		this.fmecccd =	fmecccd;
	}
 
	/**
	 * Column Info
	 * @return	fmecccd
	 */
	 public	 String	getFmecccd() {
		 return	this.fmecccd;
	 } 
 	/**
	* Column Info
	* @param  conti
	*/
	public void	setConti( String	conti ) {
		this.conti =	conti;
	}
 
	/**
	 * Column Info
	 * @return	conti
	 */
	 public	 String	getConti() {
		 return	this.conti;
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
	* @param  toplnyr
	*/
	public void	setToplnyr( String	toplnyr ) {
		this.toplnyr =	toplnyr;
	}
 
	/**
	 * Column Info
	 * @return	toplnyr
	 */
	 public	 String	getToplnyr() {
		 return	this.toplnyr;
	 } 
 	/**
	* Column Info
	* @param  totoplnwk
	*/
	public void	setTotoplnwk( String	totoplnwk ) {
		this.totoplnwk =	totoplnwk;
	}
 
	/**
	 * Column Info
	 * @return	totoplnwk
	 */
	 public	 String	getTotoplnwk() {
		 return	this.totoplnwk;
	 } 
 	/**
	* Column Info
	* @param  viewadaptergubun
	*/
	public void	setViewadaptergubun( String	viewadaptergubun ) {
		this.viewadaptergubun =	viewadaptergubun;
	}
 
	/**
	 * Column Info
	 * @return	viewadaptergubun
	 */
	 public	 String	getViewadaptergubun() {
		 return	this.viewadaptergubun;
	 } 
 	/**
	* Column Info
	* @param  colname1
	*/
	public void	setColname1( String	colname1 ) {
		this.colname1 =	colname1;
	}
 
	/**
	 * Column Info
	 * @return	colname1
	 */
	 public	 String	getColname1() {
		 return	this.colname1;
	 } 
 	/**
	* Column Info
	* @param  poscol
	*/
	public void	setPoscol( String	poscol ) {
		this.poscol =	poscol;
	}
 
	/**
	 * Column Info
	 * @return	poscol
	 */
	 public	 String	getPoscol() {
		 return	this.poscol;
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
	* @param  colname2
	*/
	public void	setColname2( String	colname2 ) {
		this.colname2 =	colname2;
	}
 
	/**
	 * Column Info
	 * @return	colname2
	 */
	 public	 String	getColname2() {
		 return	this.colname2;
	 } 
 	/**
	* Column Info
	* @param  row1
	*/
	public void	setRow1( String	row1 ) {
		this.row1 =	row1;
	}
 
	/**
	 * Column Info
	 * @return	row1
	 */
	 public	 String	getRow1() {
		 return	this.row1;
	 } 
 	/**
	* Column Info
	* @param  tpsztypeall
	*/
	public void	setTpsztypeall( String	tpsztypeall ) {
		this.tpsztypeall =	tpsztypeall;
	}
 
	/**
	 * Column Info
	 * @return	tpsztypeall
	 */
	 public	 String	getTpsztypeall() {
		 return	this.tpsztypeall;
	 } 
 	/**
	* Column Info
	* @param  toecccd
	*/
	public void	setToecccd( String	toecccd ) {
		this.toecccd =	toecccd;
	}
 
	/**
	 * Column Info
	 * @return	toecccd
	 */
	 public	 String	getToecccd() {
		 return	this.toecccd;
	 } 
 	/**
	* Column Info
	* @param  fmtoplnwk
	*/
	public void	setFmtoplnwk( String	fmtoplnwk ) {
		this.fmtoplnwk =	fmtoplnwk;
	}
 
	/**
	 * Column Info
	 * @return	fmtoplnwk
	 */
	 public	 String	getFmtoplnwk() {
		 return	this.fmtoplnwk;
	 } 
 	/**
	* Column Info
	* @param  skdVoyNo
	*/
	public void	setSkdVoyNo( String	skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	skdVoyNo
	 */
	 public	 String	getSkdVoyNo() {
		 return	this.skdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  fmtoat2
	*/
	public void	setFmtoat2( String	fmtoat2 ) {
		this.fmtoat2 =	fmtoat2;
	}
 
	/**
	 * Column Info
	 * @return	fmtoat2
	 */
	 public	 String	getFmtoat2() {
		 return	this.fmtoat2;
	 } 
 	/**
	* Column Info
	* @param  fmtype
	*/
	public void	setFmtype( String	fmtype ) {
		this.fmtype =	fmtype;
	}
 
	/**
	 * Column Info
	 * @return	fmtype
	 */
	 public	 String	getFmtype() {
		 return	this.fmtype;
	 } 
 	/**
	* Column Info
	* @param  totoplnyr
	*/
	public void	setTotoplnyr( String	totoplnyr ) {
		this.totoplnyr =	totoplnyr;
	}
 
	/**
	 * Column Info
	 * @return	totoplnyr
	 */
	 public	 String	getTotoplnyr() {
		 return	this.totoplnyr;
	 } 
 	/**
	* Column Info
	* @param  skdDirCd
	*/
	public void	setSkdDirCd( String	skdDirCd ) {
		this.skdDirCd =	skdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	skdDirCd
	 */
	 public	 String	getSkdDirCd() {
		 return	this.skdDirCd;
	 } 
 	/**
	* Column Info
	* @param  fmtoplnyr
	*/
	public void	setFmtoplnyr( String	fmtoplnyr ) {
		this.fmtoplnyr =	fmtoplnyr;
	}
 
	/**
	 * Column Info
	 * @return	fmtoplnyr
	 */
	 public	 String	getFmtoplnyr() {
		 return	this.fmtoplnyr;
	 } 
 	/**
	* Column Info
	* @param  lane1
	*/
	public void	setLane1( String	lane1 ) {
		this.lane1 =	lane1;
	}
 
	/**
	 * Column Info
	 * @return	lane1
	 */
	 public	 String	getLane1() {
		 return	this.lane1;
	 } 
 	/**
	* Column Info
	* @param  vvd1
	*/
	public void	setVvd1( String	vvd1 ) {
		this.vvd1 =	vvd1;
	}
 
	/**
	 * Column Info
	 * @return	vvd1
	 */
	 public	 String	getVvd1() {
		 return	this.vvd1;
	 } 
 	/**
	* Column Info
	* @param  tofmplnyrwk2
	*/
	public void	setTofmplnyrwk2( String	tofmplnyrwk2 ) {
		this.tofmplnyrwk2 =	tofmplnyrwk2;
	}
 
	/**
	 * Column Info
	 * @return	tofmplnyrwk2
	 */
	 public	 String	getTofmplnyrwk2() {
		 return	this.tofmplnyrwk2;
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
	* @param  yyyyww
	*/
	public void	setYyyyww( String	yyyyww ) {
		this.yyyyww =	yyyyww;
	}
 
	/**
	 * Column Info
	 * @return	yyyyww
	 */
	 public	 String	getYyyyww() {
		 return	this.yyyyww;
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
	* @param  startdate
	*/
	public void	setStartdate( String	startdate ) {
		this.startdate =	startdate;
	}
 
	/**
	 * Column Info
	 * @return	startdate
	 */
	 public	 String	getStartdate() {
		 return	this.startdate;
	 } 
 	/**
	* Column Info
	* @param  plnyrwk
	*/
	public void	setPlnyrwk( String	plnyrwk ) {
		this.plnyrwk =	plnyrwk;
	}
 
	/**
	 * Column Info
	 * @return	plnyrwk
	 */
	 public	 String	getPlnyrwk() {
		 return	this.plnyrwk;
	 } 
 	/**
	* Column Info
	* @param  fmplnyr
	*/
	public void	setFmplnyr( String	fmplnyr ) {
		this.fmplnyr =	fmplnyr;
	}
 
	/**
	 * Column Info
	 * @return	fmplnyr
	 */
	 public	 String	getFmplnyr() {
		 return	this.fmplnyr;
	 } 
 	/**
	* Column Info
	* @param  totype
	*/
	public void	setTotype( String	totype ) {
		this.totype =	totype;
	}
 
	/**
	 * Column Info
	 * @return	totype
	 */
	 public	 String	getTotype() {
		 return	this.totype;
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
	* @param  atfmplnyrwk2
	*/
	public void	setAtfmplnyrwk2( String	atfmplnyrwk2 ) {
		this.atfmplnyrwk2 =	atfmplnyrwk2;
	}
 
	/**
	 * Column Info
	 * @return	atfmplnyrwk2
	 */
	 public	 String	getAtfmplnyrwk2() {
		 return	this.atfmplnyrwk2;
	 } 
 	/**
	* Column Info
	* @param  enddate
	*/
	public void	setEnddate( String	enddate ) {
		this.enddate =	enddate;
	}
 
	/**
	 * Column Info
	 * @return	enddate
	 */
	 public	 String	getEnddate() {
		 return	this.enddate;
	 } 
 	/**
	* Column Info
	* @param  fmfmplnyrwk2
	*/
	public void	setFmfmplnyrwk2( String	fmfmplnyrwk2 ) {
		this.fmfmplnyrwk2 =	fmfmplnyrwk2;
	}
 
	/**
	 * Column Info
	 * @return	fmfmplnyrwk2
	 */
	 public	 String	getFmfmplnyrwk2() {
		 return	this.fmfmplnyrwk2;
	 } 
 	/**
	* Column Info
	* @param  fmplnwk
	*/
	public void	setFmplnwk( String	fmplnwk ) {
		this.fmplnwk =	fmplnwk;
	}
 
	/**
	 * Column Info
	 * @return	fmplnwk
	 */
	 public	 String	getFmplnwk() {
		 return	this.fmplnwk;
	 } 
 	/**
	* Column Info
	* @param  repormk
	*/
	public void	setRepormk( String	repormk ) {
		this.repormk =	repormk;
	}
 
	/**
	 * Column Info
	 * @return	repormk
	 */
	 public	 String	getRepormk() {
		 return	this.repormk;
	 } 
 	/**
	* Column Info
	* @param  viewSc
	*/
	public void	setViewSc( String	viewSc ) {
		this.viewSc =	viewSc;
	}
 
	/**
	 * Column Info
	 * @return	viewSc
	 */
	 public	 String	getViewSc() {
		 return	this.viewSc;
	 } 
 	/**
	* Column Info
	* @param  fmEtdDate
	*/
	public void	setFmEtdDate( String	fmEtdDate ) {
		this.fmEtdDate =	fmEtdDate;
	}
 
	/**
	 * Column Info
	 * @return	fmEtdDate
	 */
	 public	 String	getFmEtdDate() {
		 return	this.fmEtdDate;
	 } 
	 
	 /**
	* Column Info
	* @param  fmContiCd
	*/
	public void	setFmContiCd( String	fmContiCd ) {
		this.fmContiCd =	fmContiCd;
	}
 
	/**
	 * Column Info
	 * @return	fmContiCd
	 */
	 public	 String	getFmContiCd() {
		 return	this.fmContiCd;
	 } 
	 
	 /**
	* Column Info
	* @param  toContiCd
	*/
	public void	setToContiCd( String	toContiCd ) {
		this.toContiCd =	toContiCd;
	}
 
	/**
	 * Column Info
	 * @return	fmContiCd
	 */
	 public	 String	getToContiCd() {
		 return	this.toContiCd;
	 } 
	 
	 /**
	* Column Info
	* @param  exectype
	*/
	public void	setExectype( String	exectype ) {
		this.exectype =	exectype;
	}
 
	/**
	 * Column Info
	 * @return	exectype
	 */
	 public	 String	getExectype() {
		 return	this.exectype;
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
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setCol(JSPUtil.getParameter(request,	prefix + "col", ""));
		setTrade(JSPUtil.getParameter(request,	prefix + "trade", ""));
		setToplnwk(JSPUtil.getParameter(request,	prefix + "toplnwk", ""));
		setCntrtpszcd(JSPUtil.getParameter(request,	prefix + "cntrtpszcd", ""));
		setVslLocCd(JSPUtil.getParameter(request,	prefix + "vsl_loc_cd", ""));
		setSearchkey(JSPUtil.getParameter(request,	prefix + "searchkey", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setLane(JSPUtil.getParameter(request,	prefix + "lane", ""));
		setNewrepoId(JSPUtil.getParameter(request,	prefix + "newrepo_id", ""));
		setVslLaneCd(JSPUtil.getParameter(request,	prefix + "vsl_lane_cd", ""));
		setFmecccd(JSPUtil.getParameter(request,	prefix + "fmecccd", ""));
		setConti(JSPUtil.getParameter(request,	prefix + "conti", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setToplnyr(JSPUtil.getParameter(request,	prefix + "toplnyr", ""));
		setTotoplnwk(JSPUtil.getParameter(request,	prefix + "totoplnwk", ""));
		setViewadaptergubun(JSPUtil.getParameter(request,	prefix + "viewadaptergubun", ""));
		setColname1(JSPUtil.getParameter(request,	prefix + "colname1", ""));
		setPoscol(JSPUtil.getParameter(request,	prefix + "poscol", ""));
		setScnrId(JSPUtil.getParameter(request,	prefix + "scnr_id", ""));
		setColname2(JSPUtil.getParameter(request,	prefix + "colname2", ""));
		setRow1(JSPUtil.getParameter(request,	prefix + "row1", ""));
		setTpsztypeall(JSPUtil.getParameter(request,	prefix + "tpsztypeall", ""));
		setToecccd(JSPUtil.getParameter(request,	prefix + "toecccd", ""));
		setFmtoplnwk(JSPUtil.getParameter(request,	prefix + "fmtoplnwk", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setFmtoat2(JSPUtil.getParameter(request,	prefix + "fmtoat2", ""));
		setFmtype(JSPUtil.getParameter(request,	prefix + "fmtype", ""));
		setTotoplnyr(JSPUtil.getParameter(request,	prefix + "totoplnyr", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setFmtoplnyr(JSPUtil.getParameter(request,	prefix + "fmtoplnyr", ""));
		setLane1(JSPUtil.getParameter(request,	prefix + "lane1", ""));
		setVvd1(JSPUtil.getParameter(request,	prefix + "vvd1", ""));
		setTofmplnyrwk2(JSPUtil.getParameter(request,	prefix + "tofmplnyrwk2", ""));
		setRepoPlnId(JSPUtil.getParameter(request,	prefix + "repo_pln_id", ""));
		setYyyyww(JSPUtil.getParameter(request,	prefix + "yyyyww", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setStartdate(JSPUtil.getParameter(request,	prefix + "startdate", ""));
		setPlnyrwk(JSPUtil.getParameter(request,	prefix + "plnyrwk", ""));
		setFmplnyr(JSPUtil.getParameter(request,	prefix + "fmplnyr", ""));
		setTotype(JSPUtil.getParameter(request,	prefix + "totype", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setAtfmplnyrwk2(JSPUtil.getParameter(request,	prefix + "atfmplnyrwk2", ""));
		setEnddate(JSPUtil.getParameter(request,	prefix + "enddate", ""));
		setFmfmplnyrwk2(JSPUtil.getParameter(request,	prefix + "fmfmplnyrwk2", ""));
		setFmplnwk(JSPUtil.getParameter(request,	prefix + "fmplnwk", ""));
		setRepormk(JSPUtil.getParameter(request,	prefix + "repormk", ""));
		setViewSc(JSPUtil.getParameter(request,	prefix + "view_sc", ""));
		setFmEtdDate(JSPUtil.getParameter(request,	prefix + "fm_etd_date", ""));
		setFmContiCd(JSPUtil.getParameter(request,	prefix + "fm_conti_cd", ""));
		setToContiCd(JSPUtil.getParameter(request,	prefix + "to_conti_cd", ""));
		setExectype(JSPUtil.getParameter(request,	prefix + "exectype", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return EesEqr0012ConditionVO[]
	 */
	public EesEqr0012ConditionVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return EesEqr0012ConditionVO[]
	 */
	public EesEqr0012ConditionVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		EesEqr0012ConditionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] col =	(JSPUtil.getParameter(request, prefix +	"col".trim(),	length));
				String[] trade =	(JSPUtil.getParameter(request, prefix +	"trade".trim(),	length));
				String[] toplnwk =	(JSPUtil.getParameter(request, prefix +	"toplnwk".trim(),	length));
				String[] cntrtpszcd =	(JSPUtil.getParameter(request, prefix +	"cntrtpszcd".trim(),	length));
				String[] vslLocCd =	(JSPUtil.getParameter(request, prefix +	"vsl_loc_cd".trim(),	length));
				String[] searchkey =	(JSPUtil.getParameter(request, prefix +	"searchkey".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] lane =	(JSPUtil.getParameter(request, prefix +	"lane".trim(),	length));
				String[] newrepoId =	(JSPUtil.getParameter(request, prefix +	"newrepo_id".trim(),	length));
				String[] vslLaneCd =	(JSPUtil.getParameter(request, prefix +	"vsl_lane_cd".trim(),	length));
				String[] fmecccd =	(JSPUtil.getParameter(request, prefix +	"fmecccd".trim(),	length));
				String[] conti =	(JSPUtil.getParameter(request, prefix +	"conti".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] toplnyr =	(JSPUtil.getParameter(request, prefix +	"toplnyr".trim(),	length));
				String[] totoplnwk =	(JSPUtil.getParameter(request, prefix +	"totoplnwk".trim(),	length));
				String[] viewadaptergubun =	(JSPUtil.getParameter(request, prefix +	"viewadaptergubun".trim(),	length));
				String[] colname1 =	(JSPUtil.getParameter(request, prefix +	"colname1".trim(),	length));
				String[] poscol =	(JSPUtil.getParameter(request, prefix +	"poscol".trim(),	length));
				String[] scnrId =	(JSPUtil.getParameter(request, prefix +	"scnr_id".trim(),	length));
				String[] colname2 =	(JSPUtil.getParameter(request, prefix +	"colname2".trim(),	length));
				String[] row1 =	(JSPUtil.getParameter(request, prefix +	"row1".trim(),	length));
				String[] tpsztypeall =	(JSPUtil.getParameter(request, prefix +	"tpsztypeall".trim(),	length));
				String[] toecccd =	(JSPUtil.getParameter(request, prefix +	"toecccd".trim(),	length));
				String[] fmtoplnwk =	(JSPUtil.getParameter(request, prefix +	"fmtoplnwk".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] fmtoat2 =	(JSPUtil.getParameter(request, prefix +	"fmtoat2".trim(),	length));
				String[] fmtype =	(JSPUtil.getParameter(request, prefix +	"fmtype".trim(),	length));
				String[] totoplnyr =	(JSPUtil.getParameter(request, prefix +	"totoplnyr".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] fmtoplnyr =	(JSPUtil.getParameter(request, prefix +	"fmtoplnyr".trim(),	length));
				String[] lane1 =	(JSPUtil.getParameter(request, prefix +	"lane1".trim(),	length));
				String[] vvd1 =	(JSPUtil.getParameter(request, prefix +	"vvd1".trim(),	length));
				String[] tofmplnyrwk2 =	(JSPUtil.getParameter(request, prefix +	"tofmplnyrwk2".trim(),	length));
				String[] repoPlnId =	(JSPUtil.getParameter(request, prefix +	"repo_pln_id".trim(),	length));
				String[] yyyyww =	(JSPUtil.getParameter(request, prefix +	"yyyyww".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] startdate =	(JSPUtil.getParameter(request, prefix +	"startdate".trim(),	length));
				String[] plnyrwk =	(JSPUtil.getParameter(request, prefix +	"plnyrwk".trim(),	length));
				String[] fmplnyr =	(JSPUtil.getParameter(request, prefix +	"fmplnyr".trim(),	length));
				String[] totype =	(JSPUtil.getParameter(request, prefix +	"totype".trim(),	length));
				String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq".trim(),	length));
				String[] atfmplnyrwk2 =	(JSPUtil.getParameter(request, prefix +	"atfmplnyrwk2".trim(),	length));
				String[] enddate =	(JSPUtil.getParameter(request, prefix +	"enddate".trim(),	length));
				String[] fmfmplnyrwk2 =	(JSPUtil.getParameter(request, prefix +	"fmfmplnyrwk2".trim(),	length));
				String[] fmplnwk =	(JSPUtil.getParameter(request, prefix +	"fmplnwk".trim(),	length));
				String[] repormk =	(JSPUtil.getParameter(request, prefix +	"repormk".trim(),	length));
				String[] viewSc =	(JSPUtil.getParameter(request, prefix +	"view_sc".trim(),	length));
				String[] fmEtdDate =	(JSPUtil.getParameter(request, prefix +	"fm_etd_date".trim(),	length));
				String[] fmContiCd =	(JSPUtil.getParameter(request, prefix +	"fm_conti_cd".trim(),	length));
				String[] toContiCd =	(JSPUtil.getParameter(request, prefix +	"to_conti_cd".trim(),	length));
				String[] exectype =	(JSPUtil.getParameter(request, prefix +	"exectype".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	EesEqr0012ConditionVO();
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( col[i] !=	null)
						model.setCol( col[i]);
						if ( trade[i] !=	null)
						model.setTrade( trade[i]);
						if ( toplnwk[i] !=	null)
						model.setToplnwk( toplnwk[i]);
						if ( cntrtpszcd[i] !=	null)
						model.setCntrtpszcd( cntrtpszcd[i]);
						if ( vslLocCd[i] !=	null)
						model.setVslLocCd( vslLocCd[i]);
						if ( searchkey[i] !=	null)
						model.setSearchkey( searchkey[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( lane[i] !=	null)
						model.setLane( lane[i]);
						if ( newrepoId[i] !=	null)
						model.setNewrepoId( newrepoId[i]);
						if ( vslLaneCd[i] !=	null)
						model.setVslLaneCd( vslLaneCd[i]);
						if ( fmecccd[i] !=	null)
						model.setFmecccd( fmecccd[i]);
						if ( conti[i] !=	null)
						model.setConti( conti[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( toplnyr[i] !=	null)
						model.setToplnyr( toplnyr[i]);
						if ( totoplnwk[i] !=	null)
						model.setTotoplnwk( totoplnwk[i]);
						if ( viewadaptergubun[i] !=	null)
						model.setViewadaptergubun( viewadaptergubun[i]);
						if ( colname1[i] !=	null)
						model.setColname1( colname1[i]);
						if ( poscol[i] !=	null)
						model.setPoscol( poscol[i]);
						if ( scnrId[i] !=	null)
						model.setScnrId( scnrId[i]);
						if ( colname2[i] !=	null)
						model.setColname2( colname2[i]);
						if ( row1[i] !=	null)
						model.setRow1( row1[i]);
						if ( tpsztypeall[i] !=	null)
						model.setTpsztypeall( tpsztypeall[i]);
						if ( toecccd[i] !=	null)
						model.setToecccd( toecccd[i]);
						if ( fmtoplnwk[i] !=	null)
						model.setFmtoplnwk( fmtoplnwk[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( fmtoat2[i] !=	null)
						model.setFmtoat2( fmtoat2[i]);
						if ( fmtype[i] !=	null)
						model.setFmtype( fmtype[i]);
						if ( totoplnyr[i] !=	null)
						model.setTotoplnyr( totoplnyr[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( fmtoplnyr[i] !=	null)
						model.setFmtoplnyr( fmtoplnyr[i]);
						if ( lane1[i] !=	null)
						model.setLane1( lane1[i]);
						if ( vvd1[i] !=	null)
						model.setVvd1( vvd1[i]);
						if ( tofmplnyrwk2[i] !=	null)
						model.setTofmplnyrwk2( tofmplnyrwk2[i]);
						if ( repoPlnId[i] !=	null)
						model.setRepoPlnId( repoPlnId[i]);
						if ( yyyyww[i] !=	null)
						model.setYyyyww( yyyyww[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( startdate[i] !=	null)
						model.setStartdate( startdate[i]);
						if ( plnyrwk[i] !=	null)
						model.setPlnyrwk( plnyrwk[i]);
						if ( fmplnyr[i] !=	null)
						model.setFmplnyr( fmplnyr[i]);
						if ( totype[i] !=	null)
						model.setTotype( totype[i]);
						if ( seq[i] !=	null)
						model.setSeq( seq[i]);
						if ( atfmplnyrwk2[i] !=	null)
						model.setAtfmplnyrwk2( atfmplnyrwk2[i]);
						if ( enddate[i] !=	null)
						model.setEnddate( enddate[i]);
						if ( fmfmplnyrwk2[i] !=	null)
						model.setFmfmplnyrwk2( fmfmplnyrwk2[i]);
						if ( fmplnwk[i] !=	null)
						model.setFmplnwk( fmplnwk[i]);
						if ( repormk[i] !=	null)
						model.setRepormk( repormk[i]);
						if ( viewSc[i] !=	null)
						model.setViewSc( viewSc[i]);
						if ( fmEtdDate[i] !=	null)
						model.setFmEtdDate( fmEtdDate[i]);
						if ( fmContiCd[i] !=	null)
						model.setFmContiCd( fmContiCd[i]);
						if ( toContiCd[i] !=	null)
						model.setToContiCd( toContiCd[i]);
						if ( exectype[i] !=	null)
						model.setExectype( exectype[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getEesEqr0012ConditionVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return EesEqr0012ConditionVO[]
	 */
	public EesEqr0012ConditionVO[]	 getEesEqr0012ConditionVOs(){
		EesEqr0012ConditionVO[] vos = (EesEqr0012ConditionVO[])models.toArray(new	EesEqr0012ConditionVO[models.size()]);
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
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.col =	this.col.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trade =	this.trade.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnwk =	this.toplnwk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrtpszcd =	this.cntrtpszcd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLocCd =	this.vslLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchkey =	this.searchkey.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane =	this.lane.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newrepoId =	this.newrepoId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLaneCd =	this.vslLaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmecccd =	this.fmecccd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.conti =	this.conti.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toplnyr =	this.toplnyr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnwk =	this.totoplnwk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewadaptergubun =	this.viewadaptergubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colname1 =	this.colname1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poscol =	this.poscol.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scnrId =	this.scnrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.colname2 =	this.colname2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.row1 =	this.row1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpsztypeall =	this.tpsztypeall.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toecccd =	this.toecccd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnwk =	this.fmtoplnwk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoat2 =	this.fmtoat2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtype =	this.fmtype.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totoplnyr =	this.totoplnyr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmtoplnyr =	this.fmtoplnyr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lane1 =	this.lane1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 =	this.vvd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tofmplnyrwk2 =	this.tofmplnyrwk2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repoPlnId =	this.repoPlnId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yyyyww =	this.yyyyww.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startdate =	this.startdate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plnyrwk =	this.plnyrwk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnyr =	this.fmplnyr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totype =	this.totype.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atfmplnyrwk2 =	this.atfmplnyrwk2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enddate =	this.enddate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmfmplnyrwk2 =	this.fmfmplnyrwk2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmplnwk =	this.fmplnwk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repormk =	this.repormk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewSc =	this.viewSc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmEtdDate =	this.fmEtdDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmContiCd =	this.fmContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toContiCd =	this.toContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exectype =	this.exectype.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}