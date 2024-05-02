/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SearchParamVO.java
 *@FileTitle : SearchParamVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.16
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.04.16  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo;

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
public class SearchParamVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SearchParamVO>  models =	new	ArrayList<SearchParamVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 locTp   =  null;
	/*	Column Info	*/
	private  String	 strEstmDt   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 endEstmDt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 usedDys   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 locCase   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 freeDys   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 estmTp   =  null;
	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 minOnhDysTp   =  null;
	/*	Column Info	*/
	private  String	 portCd   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 complexPk   =  null;
	/*	Column Info	*/
	private  String	 complexPk2   =  null;
	/*	Column Info	*/
	private  String	 ydCd   =  null;
	/*	Column Info	*/
	private  String	 ydTp   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 rstr_usg_lbl   =  null;
	/*	Column Info	*/
	private  String	 ru_lable_type   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SearchParamVO(){}

	public SearchParamVO(String updDt,String locTp,String strEstmDt,String agmtSeq,String endEstmDt,String creDt,String usedDys,String delCd,String locCase,String pagerows,String creUsrId,String cnmvStsCd,String ibflag,String locCd,String vvdCd,String freeDys,String vndrSeq,String estmTp,String agmtCtyCd,String cntrTpszCd,String minOnhDysTp,String portCd,String slanCd,String lstmCd,String updUsrId,String complexPk,String complexPk2,String ydCd,String ydTp,String ofcCd,String rstr_usg_lbl,String ru_lable_type,String cntrNo)	{
		this.updDt  = updDt ;
		this.locTp  = locTp ;
		this.strEstmDt  = strEstmDt ;
		this.agmtSeq  = agmtSeq ;
		this.endEstmDt  = endEstmDt ;
		this.creDt  = creDt ;
		this.usedDys  = usedDys ;
		this.delCd  = delCd ;
		this.locCase  = locCase ;
		this.pagerows  = pagerows ;
		this.creUsrId  = creUsrId ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.ibflag  = ibflag ;
		this.locCd  = locCd ;
		this.vvdCd  = vvdCd ;
		this.freeDys  = freeDys ;
		this.vndrSeq  = vndrSeq ;
		this.estmTp  = estmTp ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.minOnhDysTp  = minOnhDysTp ;
		this.portCd  = portCd ;
		this.slanCd  = slanCd ;
		this.lstmCd  = lstmCd ;
		this.updUsrId  = updUsrId ;
		this.complexPk  = complexPk ;
		this.complexPk2  = complexPk2 ;
		this.ydCd  = ydCd ;
		this.ydTp  = ydTp ;
		this.ofcCd  = ofcCd ;
		this.rstr_usg_lbl  = rstr_usg_lbl ;
		this.ru_lable_type  = ru_lable_type ;
		this.cntrNo  = cntrNo ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("loc_tp", getLocTp());		
		this.hashColumns.put("str_estm_dt", getStrEstmDt());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("end_estm_dt", getEndEstmDt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("used_dys", getUsedDys());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("loc_case", getLocCase());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("free_dys", getFreeDys());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("estm_tp", getEstmTp());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("min_onh_dys_tp", getMinOnhDysTp());		
		this.hashColumns.put("port_cd", getPortCd());		
		this.hashColumns.put("slan_cd", getSlanCd());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("complex_pk", getComplexPk());		
		this.hashColumns.put("complex_pk2", getComplexPk2());		
		this.hashColumns.put("yd_cd", getYdCd());		
		this.hashColumns.put("yd_tp", getYdTp());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("rstr_usg_lbl", getRstr_usg_lbl());		
		this.hashColumns.put("ru_lable_type", getRu_lable_type());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("loc_tp", "locTp");
		this.hashFields.put("str_estm_dt", "strEstmDt");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("end_estm_dt", "endEstmDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("used_dys", "usedDys");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("loc_case", "locCase");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("estm_tp", "estmTp");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("min_onh_dys_tp", "minOnhDysTp");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("complex_pk", "complexPk");
		this.hashFields.put("complex_pk2", "complexPk2");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("yd_tp", "ydTp");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("rstr_usg_lbl", "rstr_usg_lbl");
		this.hashFields.put("ru_lable_type", "ru_lable_type");
		this.hashFields.put("cntr_no", "cntrNo");
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
	* @param  locTp
	*/
	public void	setLocTp( String	locTp ) {
		this.locTp =	locTp;
	}
 
	/**
	 * Column Info
	 * @return	locTp
	 */
	 public	 String	getLocTp() {
		 return	this.locTp;
	 } 
 	/**
	* Column Info
	* @param  strEstmDt
	*/
	public void	setStrEstmDt( String	strEstmDt ) {
		this.strEstmDt =	strEstmDt;
	}
 
	/**
	 * Column Info
	 * @return	strEstmDt
	 */
	 public	 String	getStrEstmDt() {
		 return	this.strEstmDt;
	 } 
 	/**
	* Column Info
	* @param  agmtSeq
	*/
	public void	setAgmtSeq( String	agmtSeq ) {
		this.agmtSeq =	agmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	agmtSeq
	 */
	 public	 String	getAgmtSeq() {
		 return	this.agmtSeq;
	 } 
 	/**
	* Column Info
	* @param  endEstmDt
	*/
	public void	setEndEstmDt( String	endEstmDt ) {
		this.endEstmDt =	endEstmDt;
	}
 
	/**
	 * Column Info
	 * @return	endEstmDt
	 */
	 public	 String	getEndEstmDt() {
		 return	this.endEstmDt;
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
	* @param  usedDys
	*/
	public void	setUsedDys( String	usedDys ) {
		this.usedDys =	usedDys;
	}
 
	/**
	 * Column Info
	 * @return	usedDys
	 */
	 public	 String	getUsedDys() {
		 return	this.usedDys;
	 } 
 	/**
	* Column Info
	* @param  delCd
	*/
	public void	setDelCd( String	delCd ) {
		this.delCd =	delCd;
	}
 
	/**
	 * Column Info
	 * @return	delCd
	 */
	 public	 String	getDelCd() {
		 return	this.delCd;
	 } 
 	/**
	* Column Info
	* @param  locCase
	*/
	public void	setLocCase( String	locCase ) {
		this.locCase =	locCase;
	}
 
	/**
	 * Column Info
	 * @return	locCase
	 */
	 public	 String	getLocCase() {
		 return	this.locCase;
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
	* @param  cnmvStsCd
	*/
	public void	setCnmvStsCd( String	cnmvStsCd ) {
		this.cnmvStsCd =	cnmvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd
	 */
	 public	 String	getCnmvStsCd() {
		 return	this.cnmvStsCd;
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
	* @param  freeDys
	*/
	public void	setFreeDys( String	freeDys ) {
		this.freeDys =	freeDys;
	}
 
	/**
	 * Column Info
	 * @return	freeDys
	 */
	 public	 String	getFreeDys() {
		 return	this.freeDys;
	 } 
 	/**
	* Column Info
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  estmTp
	*/
	public void	setEstmTp( String	estmTp ) {
		this.estmTp =	estmTp;
	}
 
	/**
	 * Column Info
	 * @return	estmTp
	 */
	 public	 String	getEstmTp() {
		 return	this.estmTp;
	 } 
 	/**
	* Column Info
	* @param  agmtCtyCd
	*/
	public void	setAgmtCtyCd( String	agmtCtyCd ) {
		this.agmtCtyCd =	agmtCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtCtyCd
	 */
	 public	 String	getAgmtCtyCd() {
		 return	this.agmtCtyCd;
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
	* Column Info
	* @param  minOnhDysTp
	*/
	public void	setMinOnhDysTp( String	minOnhDysTp ) {
		this.minOnhDysTp =	minOnhDysTp;
	}
 
	/**
	 * Column Info
	 * @return	minOnhDysTp
	 */
	 public	 String	getMinOnhDysTp() {
		 return	this.minOnhDysTp;
	 } 
 	/**
	* Column Info
	* @param  portCd
	*/
	public void	setPortCd( String	portCd ) {
		this.portCd =	portCd;
	}
 
	/**
	 * Column Info
	 * @return	portCd
	 */
	 public	 String	getPortCd() {
		 return	this.portCd;
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
	* @param  lstmCd
	*/
	public void	setLstmCd( String	lstmCd ) {
		this.lstmCd =	lstmCd;
	}
 
	/**
	 * Column Info
	 * @return	lstmCd
	 */
	 public	 String	getLstmCd() {
		 return	this.lstmCd;
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
	* @param  complexPk
	*/
	public void	setComplexPk( String	complexPk ) {
		this.complexPk =	complexPk;
	}
 
	/**
	 * Column Info
	 * @return	complexPk
	 */
	 public	 String	getComplexPk() {
		 return	this.complexPk;
	 } 
 	/**
	* Column Info
	* @param  complexPk2
	*/
	public void	setComplexPk2( String	complexPk2 ) {
		this.complexPk2 =	complexPk2;
	}
 
	/**
	 * Column Info
	 * @return	complexPk2
	 */
	 public	 String	getComplexPk2() {
		 return	this.complexPk2;
	 } 
 	/**
	* Column Info
	* @param  ydCd
	*/
	public void	setYdCd( String	ydCd ) {
		this.ydCd =	ydCd;
	}
 
	/**
	 * Column Info
	 * @return	ydCd
	 */
	 public	 String	getYdCd() {
		 return	this.ydCd;
	 } 
 	/**
	* Column Info
	* @param  ydTp
	*/
	public void	setYdTp( String	ydTp ) {
		this.ydTp =	ydTp;
	}
 
	/**
	 * Column Info
	 * @return	ydTp
	 */
	 public	 String	getYdTp() {
		 return	this.ydTp;
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
	* @param  rstr_usg_lbl
	*/
	public void	setRstr_usg_lbl( String	rstr_usg_lbl ) {
		this.rstr_usg_lbl =	rstr_usg_lbl;
	}
 
	/**
	 * Column Info
	 * @return	rstr_usg_lbl
	 */
	 public	 String	getRstr_usg_lbl() {
		 return	this.rstr_usg_lbl;
	 } 
 	/**
	* Column Info
	* @param  ru_lable_type
	*/
	public void	setRu_lable_type( String	ru_lable_type ) {
		this.ru_lable_type =	ru_lable_type;
	}
 
	/**
	 * Column Info
	 * @return	ru_lable_type
	 */
	 public	 String	getRu_lable_type() {
		 return	this.ru_lable_type;
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
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setLocTp(JSPUtil.getParameter(request,	prefix + "loc_tp", ""));
		setStrEstmDt(JSPUtil.getParameter(request,	prefix + "str_estm_dt", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setEndEstmDt(JSPUtil.getParameter(request,	prefix + "end_estm_dt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUsedDys(JSPUtil.getParameter(request,	prefix + "used_dys", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setLocCase(JSPUtil.getParameter(request,	prefix + "loc_case", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setFreeDys(JSPUtil.getParameter(request,	prefix + "free_dys", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setEstmTp(JSPUtil.getParameter(request,	prefix + "estm_tp", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setMinOnhDysTp(JSPUtil.getParameter(request,	prefix + "min_onh_dys_tp", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setComplexPk(JSPUtil.getParameter(request,	prefix + "complex_pk", ""));
		setComplexPk2(JSPUtil.getParameter(request,	prefix + "complex_pk2", ""));
		setYdCd(JSPUtil.getParameter(request,	prefix + "yd_cd", ""));
		setYdTp(JSPUtil.getParameter(request,	prefix + "yd_tp", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setRstr_usg_lbl(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl", ""));
		setRu_lable_type(JSPUtil.getParameter(request,	prefix + "ru_lable_type", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SearchParamVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] locTp =	(JSPUtil.getParameter(request, prefix +	"loc_tp".trim(),	length));
				String[] strEstmDt =	(JSPUtil.getParameter(request, prefix +	"str_estm_dt".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] endEstmDt =	(JSPUtil.getParameter(request, prefix +	"end_estm_dt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] usedDys =	(JSPUtil.getParameter(request, prefix +	"used_dys".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] locCase =	(JSPUtil.getParameter(request, prefix +	"loc_case".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] freeDys =	(JSPUtil.getParameter(request, prefix +	"free_dys".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] estmTp =	(JSPUtil.getParameter(request, prefix +	"estm_tp".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] minOnhDysTp =	(JSPUtil.getParameter(request, prefix +	"min_onh_dys_tp".trim(),	length));
				String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] complexPk =	(JSPUtil.getParameter(request, prefix +	"complex_pk".trim(),	length));
				String[] complexPk2 =	(JSPUtil.getParameter(request, prefix +	"complex_pk2".trim(),	length));
				String[] ydCd =	(JSPUtil.getParameter(request, prefix +	"yd_cd".trim(),	length));
				String[] ydTp =	(JSPUtil.getParameter(request, prefix +	"yd_tp".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] rstr_usg_lbl =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl".trim(),	length));
				String[] ru_lable_type =	(JSPUtil.getParameter(request, prefix +	"ru_lable_type".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SearchParamVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( locTp[i] !=	null)
						model.setLocTp( locTp[i]);
						if ( strEstmDt[i] !=	null)
						model.setStrEstmDt( strEstmDt[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( endEstmDt[i] !=	null)
						model.setEndEstmDt( endEstmDt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( usedDys[i] !=	null)
						model.setUsedDys( usedDys[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( locCase[i] !=	null)
						model.setLocCase( locCase[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( freeDys[i] !=	null)
						model.setFreeDys( freeDys[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( estmTp[i] !=	null)
						model.setEstmTp( estmTp[i]);
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( minOnhDysTp[i] !=	null)
						model.setMinOnhDysTp( minOnhDysTp[i]);
						if ( portCd[i] !=	null)
						model.setPortCd( portCd[i]);
						if ( slanCd[i] !=	null)
						model.setSlanCd( slanCd[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( complexPk[i] !=	null)
						model.setComplexPk( complexPk[i]);
						if ( complexPk2[i] !=	null)
						model.setComplexPk2( complexPk2[i]);
						if ( ydCd[i] !=	null)
						model.setYdCd( ydCd[i]);
						if ( ydTp[i] !=	null)
						model.setYdTp( ydTp[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( rstr_usg_lbl[i] !=	null)
						model.setRstr_usg_lbl( rstr_usg_lbl[i]);
						if ( ru_lable_type[i] !=	null)
						model.setRu_lable_type( ru_lable_type[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSearchParamVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return SearchParamVO[]
	 */
	public SearchParamVO[]	 getSearchParamVOs(){
		SearchParamVO[] vos = (SearchParamVO[])models.toArray(new	SearchParamVO[models.size()]);
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
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTp =	this.locTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.strEstmDt =	this.strEstmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endEstmDt =	this.endEstmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedDys =	this.usedDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCase =	this.locCase.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys =	this.freeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.estmTp =	this.estmTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOnhDysTp =	this.minOnhDysTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk =	this.complexPk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk2 =	this.complexPk2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd =	this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydTp =	this.ydTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstr_usg_lbl =	this.rstr_usg_lbl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ru_lable_type =	this.ru_lable_type.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}