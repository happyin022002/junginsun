/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ChassisShipMentFlatFileVO.java
 *@FileTitle : ChassisShipMentFlatFileVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.25
 *@LastModifier : 박광석
 *@LastVersion : 1.0
 * 2014.11.25 박광석 
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cgm.cgmcommon.cgminterface.vo;

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
 * @author 박광석
 * @since J2EE 1.6
 * @see	..
 */
public class ChassisShipMentFlatFileVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ChassisShipMentFlatFileVO>  models =	new	ArrayList<ChassisShipMentFlatFileVO>();


	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 imex   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 blDt   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 bkgDt   =  null;
	/*	Column Info	*/
	private  String	 transTp   =  null;
	/*	Column Info	*/
	private  String	 mode   =  null;
	/*	Column Info	*/
	private  String	 eta   =  null;
	/*	Column Info	*/
	private  String	 etaGmt   =  null;
	/*	Column Info	*/
	private  String	 etd   =  null;
	/*	Column Info	*/
	private  String	 etdGmt   =  null;
	/*	Column Info	*/
	private  String	 arrLoc   =  null;
	/*	Column Info	*/
	private  String	 depLoc   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 cntrChk   =  null;
	/*	Column Info	*/
	private  String	 cntrTp   =  null;
	/*	Column Info	*/
	private  String	 shprCd   =  null;
	/*	Column Info	*/
	private  String	 shprNm   =  null;
	/*	Column Info	*/
	private  String	 fwCd   =  null;
	/*	Column Info	*/
	private  String	 fwNm   =  null;
	/*	Column Info	*/
	private  String	 cneeCd   =  null;
	/*	Column Info	*/
	private  String	 cneeNm   =  null;
	/*	Column Info	*/
	private  String	 destIm   =  null;
	/*	Column Info	*/
	private  String	 destEx   =  null;
	/*	Column Info	*/
	private  String	 eqrel   =  null;
	/*	Column Info	*/
	private  String	 eqrtn   =  null;
	/*	Column Info	*/
	private  String	 podSvc   =  null;
	/*	Column Info	*/
	private  String	 polSvc   =  null;
	/*	Column Info	*/
	private  String	 podVsl   =  null;
	/*	Column Info	*/
	private  String	 polVsl   =  null;
	/*	Column Info	*/
	private  String	 podVoy   =  null;
	/*	Column Info	*/
	private  String	 polVoy   =  null;
	/*	Column Info	*/
	private  String	 contract   =  null;
	/*	Column Info	*/
	private  String	 flatFile   =  null;
	/*	Column Info	*/
	private  String	 poolCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ChassisShipMentFlatFileVO(){}

	public ChassisShipMentFlatFileVO(String pagerows,String ibflag,String imex,String blNo,String blDt,String bkgNo,String bkgDt,String transTp,String mode,String eta,String etaGmt,String etd,String etdGmt,String arrLoc,String depLoc,String cntrNo,String cntrChk,String cntrTp,String shprCd,String shprNm,String fwCd,String fwNm,String cneeCd,String cneeNm,String destIm,String destEx,String eqrel,String eqrtn,String podSvc,String polSvc,String podVsl,String polVsl,String podVoy,String polVoy,String contract,String flatFile, String poolCd)	{
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.imex  = imex ;
		this.blNo  = blNo ;
		this.blDt  = blDt ;
		this.bkgNo  = bkgNo ;
		this.bkgDt  = bkgDt ;
		this.transTp  = transTp ;
		this.mode  = mode ;
		this.eta  = eta ;
		this.etaGmt  = etaGmt ;
		this.etd  = etd ;
		this.etdGmt  = etdGmt ;
		this.arrLoc  = arrLoc ;
		this.depLoc  = depLoc ;
		this.cntrNo  = cntrNo ;
		this.cntrChk  = cntrChk ;
		this.cntrTp  = cntrTp ;
		this.shprCd  = shprCd ;
		this.shprNm  = shprNm ;
		this.fwCd  = fwCd ;
		this.fwNm  = fwNm ;
		this.cneeCd  = cneeCd ;
		this.cneeNm  = cneeNm ;
		this.destIm  = destIm ;
		this.destEx  = destEx ;
		this.eqrel  = eqrel ;
		this.eqrtn  = eqrtn ;
		this.podSvc  = podSvc ;
		this.polSvc  = polSvc ;
		this.podVsl  = podVsl ;
		this.polVsl  = polVsl ;
		this.podVoy  = podVoy ;
		this.polVoy  = polVoy ;
		this.contract  = contract ;
		this.flatFile  = flatFile ;
		this.poolCd = poolCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("imex", getImex());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("bl_dt", getBlDt());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("bkg_dt", getBkgDt());		
		this.hashColumns.put("trans_tp", getTransTp());		
		this.hashColumns.put("mode", getMode());		
		this.hashColumns.put("eta", getEta());		
		this.hashColumns.put("eta_gmt", getEtaGmt());		
		this.hashColumns.put("etd", getEtd());		
		this.hashColumns.put("etd_gmt", getEtdGmt());		
		this.hashColumns.put("arr_loc", getArrLoc());		
		this.hashColumns.put("dep_loc", getDepLoc());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("cntr_chk", getCntrChk());		
		this.hashColumns.put("cntr_tp", getCntrTp());		
		this.hashColumns.put("shpr_cd", getShprCd());		
		this.hashColumns.put("shpr_nm", getShprNm());		
		this.hashColumns.put("fw_cd", getFwCd());		
		this.hashColumns.put("fw_nm", getFwNm());		
		this.hashColumns.put("cnee_cd", getCneeCd());		
		this.hashColumns.put("cnee_nm", getCneeNm());		
		this.hashColumns.put("dest_im", getDestIm());		
		this.hashColumns.put("dest_ex", getDestEx());		
		this.hashColumns.put("eqrel", getEqrel());		
		this.hashColumns.put("eqrtn", getEqrtn());		
		this.hashColumns.put("pod_svc", getPodSvc());		
		this.hashColumns.put("pol_svc", getPolSvc());		
		this.hashColumns.put("pod_vsl", getPodVsl());		
		this.hashColumns.put("pol_vsl", getPolVsl());		
		this.hashColumns.put("pod_voy", getPodVoy());		
		this.hashColumns.put("pol_voy", getPolVoy());		
		this.hashColumns.put("contract", getContract());		
		this.hashColumns.put("flat_file", getFlatFile());
		this.hashColumns.put("pool_cd", getPoolCd());
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("imex", "imex");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_dt", "blDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_dt", "bkgDt");
		this.hashFields.put("trans_tp", "transTp");
		this.hashFields.put("mode", "mode");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("eta_gmt", "etaGmt");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("etd_gmt", "etdGmt");
		this.hashFields.put("arr_loc", "arrLoc");
		this.hashFields.put("dep_loc", "depLoc");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_chk", "cntrChk");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("shpr_nm", "shprNm");
		this.hashFields.put("fw_cd", "fwCd");
		this.hashFields.put("fw_nm", "fwNm");
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("dest_im", "destIm");
		this.hashFields.put("dest_ex", "destEx");
		this.hashFields.put("eqrel", "eqrel");
		this.hashFields.put("eqrtn", "eqrtn");
		this.hashFields.put("pod_svc", "podSvc");
		this.hashFields.put("pol_svc", "polSvc");
		this.hashFields.put("pod_vsl", "podVsl");
		this.hashFields.put("pol_vsl", "polVsl");
		this.hashFields.put("pod_voy", "podVoy");
		this.hashFields.put("pol_voy", "polVoy");
		this.hashFields.put("contract", "contract");
		this.hashFields.put("flat_file", "flatFile");
		this.hashFields.put("pool_cd", "poolCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  imex
	*/
	public void	setImex( String	imex ) {
		this.imex =	imex;
	}
 
	/**
	 * Column Info
	 * @return	imex
	 */
	 public	 String	getImex() {
		 return	this.imex;
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
	* @param  blDt
	*/
	public void	setBlDt( String	blDt ) {
		this.blDt =	blDt;
	}
 
	/**
	 * Column Info
	 * @return	blDt
	 */
	 public	 String	getBlDt() {
		 return	this.blDt;
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
	* @param  bkgDt
	*/
	public void	setBkgDt( String	bkgDt ) {
		this.bkgDt =	bkgDt;
	}
 
	/**
	 * Column Info
	 * @return	bkgDt
	 */
	 public	 String	getBkgDt() {
		 return	this.bkgDt;
	 } 
 	/**
	* Column Info
	* @param  transTp
	*/
	public void	setTransTp( String	transTp ) {
		this.transTp =	transTp;
	}
 
	/**
	 * Column Info
	 * @return	transTp
	 */
	 public	 String	getTransTp() {
		 return	this.transTp;
	 } 
 	/**
	* Column Info
	* @param  mode
	*/
	public void	setMode( String	mode ) {
		this.mode =	mode;
	}
 
	/**
	 * Column Info
	 * @return	mode
	 */
	 public	 String	getMode() {
		 return	this.mode;
	 } 
 	/**
	* Column Info
	* @param  eta
	*/
	public void	setEta( String	eta ) {
		this.eta =	eta;
	}
 
	/**
	 * Column Info
	 * @return	eta
	 */
	 public	 String	getEta() {
		 return	this.eta;
	 } 
 	/**
	* Column Info
	* @param  etaGmt
	*/
	public void	setEtaGmt( String	etaGmt ) {
		this.etaGmt =	etaGmt;
	}
 
	/**
	 * Column Info
	 * @return	etaGmt
	 */
	 public	 String	getEtaGmt() {
		 return	this.etaGmt;
	 } 
 	/**
	* Column Info
	* @param  etd
	*/
	public void	setEtd( String	etd ) {
		this.etd =	etd;
	}
 
	/**
	 * Column Info
	 * @return	etd
	 */
	 public	 String	getEtd() {
		 return	this.etd;
	 } 
 	/**
	* Column Info
	* @param  etdGmt
	*/
	public void	setEtdGmt( String	etdGmt ) {
		this.etdGmt =	etdGmt;
	}
 
	/**
	 * Column Info
	 * @return	etdGmt
	 */
	 public	 String	getEtdGmt() {
		 return	this.etdGmt;
	 } 
 	/**
	* Column Info
	* @param  arrLoc
	*/
	public void	setArrLoc( String	arrLoc ) {
		this.arrLoc =	arrLoc;
	}
 
	/**
	 * Column Info
	 * @return	arrLoc
	 */
	 public	 String	getArrLoc() {
		 return	this.arrLoc;
	 } 
 	/**
	* Column Info
	* @param  depLoc
	*/
	public void	setDepLoc( String	depLoc ) {
		this.depLoc =	depLoc;
	}
 
	/**
	 * Column Info
	 * @return	depLoc
	 */
	 public	 String	getDepLoc() {
		 return	this.depLoc;
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
	* @param  cntrChk
	*/
	public void	setCntrChk( String	cntrChk ) {
		this.cntrChk =	cntrChk;
	}
 
	/**
	 * Column Info
	 * @return	cntrChk
	 */
	 public	 String	getCntrChk() {
		 return	this.cntrChk;
	 } 
 	/**
	* Column Info
	* @param  cntrTp
	*/
	public void	setCntrTp( String	cntrTp ) {
		this.cntrTp =	cntrTp;
	}
 
	/**
	 * Column Info
	 * @return	cntrTp
	 */
	 public	 String	getCntrTp() {
		 return	this.cntrTp;
	 } 
 	/**
	* Column Info
	* @param  shprCd
	*/
	public void	setShprCd( String	shprCd ) {
		this.shprCd =	shprCd;
	}
 
	/**
	 * Column Info
	 * @return	shprCd
	 */
	 public	 String	getShprCd() {
		 return	this.shprCd;
	 } 
 	/**
	* Column Info
	* @param  shprNm
	*/
	public void	setShprNm( String	shprNm ) {
		this.shprNm =	shprNm;
	}
 
	/**
	 * Column Info
	 * @return	shprNm
	 */
	 public	 String	getShprNm() {
		 return	this.shprNm;
	 } 
 	/**
	* Column Info
	* @param  fwCd
	*/
	public void	setFwCd( String	fwCd ) {
		this.fwCd =	fwCd;
	}
 
	/**
	 * Column Info
	 * @return	fwCd
	 */
	 public	 String	getFwCd() {
		 return	this.fwCd;
	 } 
 	/**
	* Column Info
	* @param  fwNm
	*/
	public void	setFwNm( String	fwNm ) {
		this.fwNm =	fwNm;
	}
 
	/**
	 * Column Info
	 * @return	fwNm
	 */
	 public	 String	getFwNm() {
		 return	this.fwNm;
	 } 
 	/**
	* Column Info
	* @param  cneeCd
	*/
	public void	setCneeCd( String	cneeCd ) {
		this.cneeCd =	cneeCd;
	}
 
	/**
	 * Column Info
	 * @return	cneeCd
	 */
	 public	 String	getCneeCd() {
		 return	this.cneeCd;
	 } 
 	/**
	* Column Info
	* @param  cneeNm
	*/
	public void	setCneeNm( String	cneeNm ) {
		this.cneeNm =	cneeNm;
	}
 
	/**
	 * Column Info
	 * @return	cneeNm
	 */
	 public	 String	getCneeNm() {
		 return	this.cneeNm;
	 } 
 	/**
	* Column Info
	* @param  destIm
	*/
	public void	setDestIm( String	destIm ) {
		this.destIm =	destIm;
	}
 
	/**
	 * Column Info
	 * @return	destIm
	 */
	 public	 String	getDestIm() {
		 return	this.destIm;
	 } 
 	/**
	* Column Info
	* @param  destEx
	*/
	public void	setDestEx( String	destEx ) {
		this.destEx =	destEx;
	}
 
	/**
	 * Column Info
	 * @return	destEx
	 */
	 public	 String	getDestEx() {
		 return	this.destEx;
	 } 
 	/**
	* Column Info
	* @param  eqrel
	*/
	public void	setEqrel( String	eqrel ) {
		this.eqrel =	eqrel;
	}
 
	/**
	 * Column Info
	 * @return	eqrel
	 */
	 public	 String	getEqrel() {
		 return	this.eqrel;
	 } 
 	/**
	* Column Info
	* @param  eqrtn
	*/
	public void	setEqrtn( String	eqrtn ) {
		this.eqrtn =	eqrtn;
	}
 
	/**
	 * Column Info
	 * @return	eqrtn
	 */
	 public	 String	getEqrtn() {
		 return	this.eqrtn;
	 } 
 	/**
	* Column Info
	* @param  podSvc
	*/
	public void	setPodSvc( String	podSvc ) {
		this.podSvc =	podSvc;
	}
 
	/**
	 * Column Info
	 * @return	podSvc
	 */
	 public	 String	getPodSvc() {
		 return	this.podSvc;
	 } 
 	/**
	* Column Info
	* @param  polSvc
	*/
	public void	setPolSvc( String	polSvc ) {
		this.polSvc =	polSvc;
	}
 
	/**
	 * Column Info
	 * @return	polSvc
	 */
	 public	 String	getPolSvc() {
		 return	this.polSvc;
	 } 
 	/**
	* Column Info
	* @param  podVsl
	*/
	public void	setPodVsl( String	podVsl ) {
		this.podVsl =	podVsl;
	}
 
	/**
	 * Column Info
	 * @return	podVsl
	 */
	 public	 String	getPodVsl() {
		 return	this.podVsl;
	 } 
 	/**
	* Column Info
	* @param  polVsl
	*/
	public void	setPolVsl( String	polVsl ) {
		this.polVsl =	polVsl;
	}
 
	/**
	 * Column Info
	 * @return	polVsl
	 */
	 public	 String	getPolVsl() {
		 return	this.polVsl;
	 } 
 	/**
	* Column Info
	* @param  podVoy
	*/
	public void	setPodVoy( String	podVoy ) {
		this.podVoy =	podVoy;
	}
 
	/**
	 * Column Info
	 * @return	podVoy
	 */
	 public	 String	getPodVoy() {
		 return	this.podVoy;
	 } 
 	/**
	* Column Info
	* @param  polVoy
	*/
	public void	setPolVoy( String	polVoy ) {
		this.polVoy =	polVoy;
	}
 
	/**
	 * Column Info
	 * @return	polVoy
	 */
	 public	 String	getPolVoy() {
		 return	this.polVoy;
	 } 
 	/**
	* Column Info
	* @param  contract
	*/
	public void	setContract( String	contract ) {
		this.contract =	contract;
	}
 
	/**
	 * Column Info
	 * @return	contract
	 */
	 public	 String	getContract() {
		 return	this.contract;
	 } 
 	/**
	* Column Info
	* @param  flatFile
	*/
	public void	setFlatFile( String	flatFile ) {
		this.flatFile =	flatFile;
	}
 
	/**
	 * Column Info
	 * @return	flatFile
	 */
	 public	 String	getFlatFile() {
		 return	this.flatFile;
	 } 
	 
	/**
	 * Column Info
	 * @param etd
	 */
	public void setPoolCd(String poolCd) {
		this.poolCd = poolCd;
	}

	/**
	 * Column Info
	 * @return poolCd
	 */
	public String getPoolCd() {
		return this.poolCd;
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
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setImex(JSPUtil.getParameter(request,	prefix + "imex", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setBlDt(JSPUtil.getParameter(request,	prefix + "bl_dt", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setBkgDt(JSPUtil.getParameter(request,	prefix + "bkg_dt", ""));
		setTransTp(JSPUtil.getParameter(request,	prefix + "trans_tp", ""));
		setMode(JSPUtil.getParameter(request,	prefix + "mode", ""));
		setEta(JSPUtil.getParameter(request,	prefix + "eta", ""));
		setEtaGmt(JSPUtil.getParameter(request,	prefix + "eta_gmt", ""));
		setEtd(JSPUtil.getParameter(request,	prefix + "etd", ""));
		setEtdGmt(JSPUtil.getParameter(request,	prefix + "etd_gmt", ""));
		setArrLoc(JSPUtil.getParameter(request,	prefix + "arr_loc", ""));
		setDepLoc(JSPUtil.getParameter(request,	prefix + "dep_loc", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCntrChk(JSPUtil.getParameter(request,	prefix + "cntr_chk", ""));
		setCntrTp(JSPUtil.getParameter(request,	prefix + "cntr_tp", ""));
		setShprCd(JSPUtil.getParameter(request,	prefix + "shpr_cd", ""));
		setShprNm(JSPUtil.getParameter(request,	prefix + "shpr_nm", ""));
		setFwCd(JSPUtil.getParameter(request,	prefix + "fw_cd", ""));
		setFwNm(JSPUtil.getParameter(request,	prefix + "fw_nm", ""));
		setCneeCd(JSPUtil.getParameter(request,	prefix + "cnee_cd", ""));
		setCneeNm(JSPUtil.getParameter(request,	prefix + "cnee_nm", ""));
		setDestIm(JSPUtil.getParameter(request,	prefix + "dest_im", ""));
		setDestEx(JSPUtil.getParameter(request,	prefix + "dest_ex", ""));
		setEqrel(JSPUtil.getParameter(request,	prefix + "eqrel", ""));
		setEqrtn(JSPUtil.getParameter(request,	prefix + "eqrtn", ""));
		setPodSvc(JSPUtil.getParameter(request,	prefix + "pod_svc", ""));
		setPolSvc(JSPUtil.getParameter(request,	prefix + "pol_svc", ""));
		setPodVsl(JSPUtil.getParameter(request,	prefix + "pod_vsl", ""));
		setPolVsl(JSPUtil.getParameter(request,	prefix + "pol_vsl", ""));
		setPodVoy(JSPUtil.getParameter(request,	prefix + "pod_voy", ""));
		setPolVoy(JSPUtil.getParameter(request,	prefix + "pol_voy", ""));
		setContract(JSPUtil.getParameter(request,	prefix + "contract", ""));
		setFlatFile(JSPUtil.getParameter(request,	prefix + "flat_file", ""));
		setPoolCd(JSPUtil.getParameter(request,	prefix + "pool_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChassisShipMentFlatFileVO[]
	 */
	public ChassisShipMentFlatFileVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChassisShipMentFlatFileVO[]
	 */
	public ChassisShipMentFlatFileVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ChassisShipMentFlatFileVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] imex =	(JSPUtil.getParameter(request, prefix +	"imex".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] blDt =	(JSPUtil.getParameter(request, prefix +	"bl_dt".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] bkgDt =	(JSPUtil.getParameter(request, prefix +	"bkg_dt".trim(),	length));
				String[] transTp =	(JSPUtil.getParameter(request, prefix +	"trans_tp".trim(),	length));
				String[] mode =	(JSPUtil.getParameter(request, prefix +	"mode".trim(),	length));
				String[] eta =	(JSPUtil.getParameter(request, prefix +	"eta".trim(),	length));
				String[] etaGmt =	(JSPUtil.getParameter(request, prefix +	"eta_gmt".trim(),	length));
				String[] etd =	(JSPUtil.getParameter(request, prefix +	"etd".trim(),	length));
				String[] etdGmt =	(JSPUtil.getParameter(request, prefix +	"etd_gmt".trim(),	length));
				String[] arrLoc =	(JSPUtil.getParameter(request, prefix +	"arr_loc".trim(),	length));
				String[] depLoc =	(JSPUtil.getParameter(request, prefix +	"dep_loc".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] cntrChk =	(JSPUtil.getParameter(request, prefix +	"cntr_chk".trim(),	length));
				String[] cntrTp =	(JSPUtil.getParameter(request, prefix +	"cntr_tp".trim(),	length));
				String[] shprCd =	(JSPUtil.getParameter(request, prefix +	"shpr_cd".trim(),	length));
				String[] shprNm =	(JSPUtil.getParameter(request, prefix +	"shpr_nm".trim(),	length));
				String[] fwCd =	(JSPUtil.getParameter(request, prefix +	"fw_cd".trim(),	length));
				String[] fwNm =	(JSPUtil.getParameter(request, prefix +	"fw_nm".trim(),	length));
				String[] cneeCd =	(JSPUtil.getParameter(request, prefix +	"cnee_cd".trim(),	length));
				String[] cneeNm =	(JSPUtil.getParameter(request, prefix +	"cnee_nm".trim(),	length));
				String[] destIm =	(JSPUtil.getParameter(request, prefix +	"dest_im".trim(),	length));
				String[] destEx =	(JSPUtil.getParameter(request, prefix +	"dest_ex".trim(),	length));
				String[] eqrel =	(JSPUtil.getParameter(request, prefix +	"eqrel".trim(),	length));
				String[] eqrtn =	(JSPUtil.getParameter(request, prefix +	"eqrtn".trim(),	length));
				String[] podSvc =	(JSPUtil.getParameter(request, prefix +	"pod_svc".trim(),	length));
				String[] polSvc =	(JSPUtil.getParameter(request, prefix +	"pol_svc".trim(),	length));
				String[] podVsl =	(JSPUtil.getParameter(request, prefix +	"pod_vsl".trim(),	length));
				String[] polVsl =	(JSPUtil.getParameter(request, prefix +	"pol_vsl".trim(),	length));
				String[] podVoy =	(JSPUtil.getParameter(request, prefix +	"pod_voy".trim(),	length));
				String[] polVoy =	(JSPUtil.getParameter(request, prefix +	"pol_voy".trim(),	length));
				String[] contract =	(JSPUtil.getParameter(request, prefix +	"contract".trim(),	length));
				String[] flatFile =	(JSPUtil.getParameter(request, prefix +	"flat_file".trim(),	length));
				String[] poolCd =	(JSPUtil.getParameter(request, prefix +	"pool_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ChassisShipMentFlatFileVO();
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( imex[i] !=	null)
						model.setImex( imex[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( blDt[i] !=	null)
						model.setBlDt( blDt[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( bkgDt[i] !=	null)
						model.setBkgDt( bkgDt[i]);
						if ( transTp[i] !=	null)
						model.setTransTp( transTp[i]);
						if ( mode[i] !=	null)
						model.setMode( mode[i]);
						if ( eta[i] !=	null)
						model.setEta( eta[i]);
						if ( etaGmt[i] !=	null)
						model.setEtaGmt( etaGmt[i]);
						if ( etd[i] !=	null)
						model.setEtd( etd[i]);
						if ( etdGmt[i] !=	null)
						model.setEtdGmt( etdGmt[i]);
						if ( arrLoc[i] !=	null)
						model.setArrLoc( arrLoc[i]);
						if ( depLoc[i] !=	null)
						model.setDepLoc( depLoc[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( cntrChk[i] !=	null)
						model.setCntrChk( cntrChk[i]);
						if ( cntrTp[i] !=	null)
						model.setCntrTp( cntrTp[i]);
						if ( shprCd[i] !=	null)
						model.setShprCd( shprCd[i]);
						if ( shprNm[i] !=	null)
						model.setShprNm( shprNm[i]);
						if ( fwCd[i] !=	null)
						model.setFwCd( fwCd[i]);
						if ( fwNm[i] !=	null)
						model.setFwNm( fwNm[i]);
						if ( cneeCd[i] !=	null)
						model.setCneeCd( cneeCd[i]);
						if ( cneeNm[i] !=	null)
						model.setCneeNm( cneeNm[i]);
						if ( destIm[i] !=	null)
						model.setDestIm( destIm[i]);
						if ( destEx[i] !=	null)
						model.setDestEx( destEx[i]);
						if ( eqrel[i] !=	null)
						model.setEqrel( eqrel[i]);
						if ( eqrtn[i] !=	null)
						model.setEqrtn( eqrtn[i]);
						if ( podSvc[i] !=	null)
						model.setPodSvc( podSvc[i]);
						if ( polSvc[i] !=	null)
						model.setPolSvc( polSvc[i]);
						if ( podVsl[i] !=	null)
						model.setPodVsl( podVsl[i]);
						if ( polVsl[i] !=	null)
						model.setPolVsl( polVsl[i]);
						if ( podVoy[i] !=	null)
						model.setPodVoy( podVoy[i]);
						if ( polVoy[i] !=	null)
						model.setPolVoy( polVoy[i]);
						if ( contract[i] !=	null)
						model.setContract( contract[i]);
						if ( flatFile[i] !=	null)
						model.setFlatFile( flatFile[i]);
						if ( poolCd[i] !=	null)
						model.setPoolCd( poolCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getChassisShipMentFlatFileVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ChassisShipMentFlatFileVO[]
	 */
	public ChassisShipMentFlatFileVO[]	 getChassisShipMentFlatFileVOs(){
		ChassisShipMentFlatFileVO[] vos = (ChassisShipMentFlatFileVO[])models.toArray(new	ChassisShipMentFlatFileVO[models.size()]);
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
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imex =	this.imex.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDt =	this.blDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDt =	this.bkgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.transTp =	this.transTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mode =	this.mode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta =	this.eta.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaGmt =	this.etaGmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd =	this.etd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdGmt =	this.etdGmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrLoc =	this.arrLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depLoc =	this.depLoc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrChk =	this.cntrChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTp =	this.cntrTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd =	this.shprCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprNm =	this.shprNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwCd =	this.fwCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwNm =	this.fwNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCd =	this.cneeCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm =	this.cneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destIm =	this.destIm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destEx =	this.destEx.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrel =	this.eqrel.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqrtn =	this.eqrtn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podSvc =	this.podSvc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polSvc =	this.polSvc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podVsl =	this.podVsl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polVsl =	this.polVsl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podVoy =	this.podVoy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polVoy =	this.polVoy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contract =	this.contract.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFile =	this.flatFile.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.poolCd =	this.poolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}