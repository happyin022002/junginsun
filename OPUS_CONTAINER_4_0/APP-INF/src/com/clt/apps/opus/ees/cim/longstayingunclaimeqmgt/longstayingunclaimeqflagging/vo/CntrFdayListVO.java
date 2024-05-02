/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CntrFdayListVO.java
 *@FileTitle : CntrFdayListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.30
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.12.30  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cim.longstayingunclaimeqmgt.longstayingunclaimeqflagging.vo;

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
public class CntrFdayListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CntrFdayListVO>  models =	new	ArrayList<CntrFdayListVO>();


	/*	Column Info	*/
	private  String	 ntfy   =  null;
	/*	Column Info	*/
	private  String	 actDys   =  null;
	/*	Column Info	*/
	private  String	 rccDate   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 obSlsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 obSrepCd   =  null;
	/*	Column Info	*/
	private  String	 uclmLsFlg   =  null;
	/*	Column Info	*/
	private  String	 repCmdtNm   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 loadVvd   =  null;
	/*	Column Info	*/
	private  String	 discVvd   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 dispFlg   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 uclmLsDivCd   =  null;
	/*	Column Info	*/
	private  String	 fullFlg   =  null;
	/*	Column Info	*/
	private  String	 stayDays   =  null;
	/*	Column Info	*/
	private  String	 freeDays   =  null;
	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 dmgFlg   =  null;
	/*	Column Info	*/
	private  String	 polEtd   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 ftEndDt   =  null;
	/*	Column Info	*/
	private  String	 subLocCd   =  null;
	/*	Column Info	*/
	private  String	 rccCd   =  null;
	/*	Column Info	*/
	private  String	 cmdtNm   =  null;
	/*	Column Info	*/
	private  String	 deTermCd   =  null;
	/*	Column Info	*/
	private  String	 ftDys   =  null;
	/*	Column Info	*/
	private  String	 scRfaNo   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 seq   =  null;
	/*	Column Info	*/
	private  String	 cnee   =  null;
	/*	Column Info	*/
	private  String	 shpr   =  null;
	/*	Column Info	*/
	private  String	 rfTpCd   =  null;
	/*	Column Info	*/
	private  String	 bkgCgoTpCd   =  null;
	/*	Column Info	*/
	private  String	 dmgFlgDt   =  null;
	/*	Column Info	*/
	private  String	 dmgUnflgDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CntrFdayListVO(){}

	public CntrFdayListVO(String ntfy,String actDys,String rccDate,String blNo,String pagerows,String polCd,String cntrTpszCd,String obSlsOfcCd,String obSrepCd,String uclmLsFlg,String repCmdtNm,String cnmvDt,String delCd,String vvd,String loadVvd,String discVvd,String podCd,String dispFlg,String bkgNo,String uclmLsDivCd,String fullFlg,String stayDays,String freeDays,String porCd,String crntYdCd,String lstmCd,String dmgFlg,String polEtd,String cnmvStsCd,String ibflag,String ftEndDt,String subLocCd,String rccCd,String cmdtNm,String deTermCd,String ftDys,String scRfaNo,String cntrNo,String seq,String cnee,String shpr,String rfTpCd,String bkgCgoTpCd,String dmgFlgDt,String dmgUnflgDt)	{
		this.ntfy  = ntfy ;
		this.actDys  = actDys ;
		this.rccDate  = rccDate ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.polCd  = polCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.obSlsOfcCd  = obSlsOfcCd ;
		this.obSrepCd  = obSrepCd ;
		this.uclmLsFlg  = uclmLsFlg ;
		this.repCmdtNm  = repCmdtNm ;
		this.cnmvDt  = cnmvDt ;
		this.delCd  = delCd ;
		this.vvd  = vvd ;
		this.loadVvd  = loadVvd ;
		this.discVvd  = discVvd ;
		this.podCd  = podCd ;
		this.dispFlg  = dispFlg ;
		this.bkgNo  = bkgNo ;
		this.uclmLsDivCd  = uclmLsDivCd ;
		this.fullFlg  = fullFlg ;
		this.stayDays  = stayDays ;
		this.freeDays  = freeDays ;
		this.porCd  = porCd ;
		this.crntYdCd  = crntYdCd ;
		this.lstmCd  = lstmCd ;
		this.dmgFlg  = dmgFlg ;
		this.polEtd  = polEtd ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.ibflag  = ibflag ;
		this.ftEndDt  = ftEndDt ;
		this.subLocCd  = subLocCd ;
		this.rccCd  = rccCd ;
		this.cmdtNm  = cmdtNm ;
		this.deTermCd  = deTermCd ;
		this.ftDys  = ftDys ;
		this.scRfaNo  = scRfaNo ;
		this.cntrNo  = cntrNo ;
		this.seq  = seq ;
		this.cnee  = cnee ;
		this.shpr  = shpr ;
		this.rfTpCd  = rfTpCd ;
		this.bkgCgoTpCd  = bkgCgoTpCd ;
		this.dmgFlgDt  = dmgFlgDt ;
		this.dmgUnflgDt  = dmgUnflgDt ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());		
		this.hashColumns.put("act_dys", getActDys());		
		this.hashColumns.put("rcc_date", getRccDate());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());		
		this.hashColumns.put("ob_srep_cd", getObSrepCd());		
		this.hashColumns.put("uclm_ls_flg", getUclmLsFlg());		
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("load_vvd", getLoadVvd());		
		this.hashColumns.put("disc_vvd", getDiscVvd());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("disp_flg", getDispFlg());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());		
		this.hashColumns.put("full_flg", getFullFlg());		
		this.hashColumns.put("stay_days", getStayDays());		
		this.hashColumns.put("free_days", getFreeDays());		
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("dmg_flg", getDmgFlg());		
		this.hashColumns.put("pol_etd", getPolEtd());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ft_end_dt", getFtEndDt());		
		this.hashColumns.put("sub_loc_cd", getSubLocCd());		
		this.hashColumns.put("rcc_cd", getRccCd());		
		this.hashColumns.put("cmdt_nm", getCmdtNm());		
		this.hashColumns.put("de_term_cd", getDeTermCd());		
		this.hashColumns.put("ft_dys", getFtDys());		
		this.hashColumns.put("sc_rfa_no", getScRfaNo());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("seq", getSeq());		
		this.hashColumns.put("cnee", getCnee());		
		this.hashColumns.put("shpr", getShpr());		
		this.hashColumns.put("rf_tp_cd", getRfTpCd());		
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());		
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());		
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("act_dys", "actDys");
		this.hashFields.put("rcc_date", "rccDate");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("uclm_ls_flg", "uclmLsFlg");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("load_vvd", "loadVvd");
		this.hashFields.put("disc_vvd", "discVvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("free_days", "freeDays");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("sub_loc_cd", "subLocCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  ntfy
	*/
	public void	setNtfy( String	ntfy ) {
		this.ntfy =	ntfy;
	}
 
	/**
	 * Column Info
	 * @return	ntfy
	 */
	 public	 String	getNtfy() {
		 return	this.ntfy;
	 } 
 	/**
	* Column Info
	* @param  actDys
	*/
	public void	setActDys( String	actDys ) {
		this.actDys =	actDys;
	}
 
	/**
	 * Column Info
	 * @return	actDys
	 */
	 public	 String	getActDys() {
		 return	this.actDys;
	 } 
 	/**
	* Column Info
	* @param  rccDate
	*/
	public void	setRccDate( String	rccDate ) {
		this.rccDate =	rccDate;
	}
 
	/**
	 * Column Info
	 * @return	rccDate
	 */
	 public	 String	getRccDate() {
		 return	this.rccDate;
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
	* @param  obSlsOfcCd
	*/
	public void	setObSlsOfcCd( String	obSlsOfcCd ) {
		this.obSlsOfcCd =	obSlsOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	obSlsOfcCd
	 */
	 public	 String	getObSlsOfcCd() {
		 return	this.obSlsOfcCd;
	 } 
 	/**
	* Column Info
	* @param  obSrepCd
	*/
	public void	setObSrepCd( String	obSrepCd ) {
		this.obSrepCd =	obSrepCd;
	}
 
	/**
	 * Column Info
	 * @return	obSrepCd
	 */
	 public	 String	getObSrepCd() {
		 return	this.obSrepCd;
	 } 
 	/**
	* Column Info
	* @param  uclmLsFlg
	*/
	public void	setUclmLsFlg( String	uclmLsFlg ) {
		this.uclmLsFlg =	uclmLsFlg;
	}
 
	/**
	 * Column Info
	 * @return	uclmLsFlg
	 */
	 public	 String	getUclmLsFlg() {
		 return	this.uclmLsFlg;
	 } 
 	/**
	* Column Info
	* @param  repCmdtNm
	*/
	public void	setRepCmdtNm( String	repCmdtNm ) {
		this.repCmdtNm =	repCmdtNm;
	}
 
	/**
	 * Column Info
	 * @return	repCmdtNm
	 */
	 public	 String	getRepCmdtNm() {
		 return	this.repCmdtNm;
	 } 
 	/**
	* Column Info
	* @param  cnmvDt
	*/
	public void	setCnmvDt( String	cnmvDt ) {
		this.cnmvDt =	cnmvDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvDt
	 */
	 public	 String	getCnmvDt() {
		 return	this.cnmvDt;
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
	* @param  loadVvd
	*/
	public void	setLoadVvd( String	loadVvd ) {
		this.loadVvd =	loadVvd;
	}
 
	/**
	 * Column Info
	 * @return	loadVvd
	 */
	 public	 String	getLoadVvd() {
		 return	this.loadVvd;
	 } 
 	/**
	* Column Info
	* @param  discVvd
	*/
	public void	setDiscVvd( String	discVvd ) {
		this.discVvd =	discVvd;
	}
 
	/**
	 * Column Info
	 * @return	discVvd
	 */
	 public	 String	getDiscVvd() {
		 return	this.discVvd;
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
	* @param  dispFlg
	*/
	public void	setDispFlg( String	dispFlg ) {
		this.dispFlg =	dispFlg;
	}
 
	/**
	 * Column Info
	 * @return	dispFlg
	 */
	 public	 String	getDispFlg() {
		 return	this.dispFlg;
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
	* @param  uclmLsDivCd
	*/
	public void	setUclmLsDivCd( String	uclmLsDivCd ) {
		this.uclmLsDivCd =	uclmLsDivCd;
	}
 
	/**
	 * Column Info
	 * @return	uclmLsDivCd
	 */
	 public	 String	getUclmLsDivCd() {
		 return	this.uclmLsDivCd;
	 } 
 	/**
	* Column Info
	* @param  fullFlg
	*/
	public void	setFullFlg( String	fullFlg ) {
		this.fullFlg =	fullFlg;
	}
 
	/**
	 * Column Info
	 * @return	fullFlg
	 */
	 public	 String	getFullFlg() {
		 return	this.fullFlg;
	 } 
 	/**
	* Column Info
	* @param  stayDays
	*/
	public void	setStayDays( String	stayDays ) {
		this.stayDays =	stayDays;
	}
 
	/**
	 * Column Info
	 * @return	stayDays
	 */
	 public	 String	getStayDays() {
		 return	this.stayDays;
	 } 
 	/**
	* Column Info
	* @param  freeDays
	*/
	public void	setFreeDays( String	freeDays ) {
		this.freeDays =	freeDays;
	}
 
	/**
	 * Column Info
	 * @return	freeDays
	 */
	 public	 String	getFreeDays() {
		 return	this.freeDays;
	 } 
 	/**
	* Column Info
	* @param  porCd
	*/
	public void	setPorCd( String	porCd ) {
		this.porCd =	porCd;
	}
 
	/**
	 * Column Info
	 * @return	porCd
	 */
	 public	 String	getPorCd() {
		 return	this.porCd;
	 } 
 	/**
	* Column Info
	* @param  crntYdCd
	*/
	public void	setCrntYdCd( String	crntYdCd ) {
		this.crntYdCd =	crntYdCd;
	}
 
	/**
	 * Column Info
	 * @return	crntYdCd
	 */
	 public	 String	getCrntYdCd() {
		 return	this.crntYdCd;
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
	* @param  dmgFlg
	*/
	public void	setDmgFlg( String	dmgFlg ) {
		this.dmgFlg =	dmgFlg;
	}
 
	/**
	 * Column Info
	 * @return	dmgFlg
	 */
	 public	 String	getDmgFlg() {
		 return	this.dmgFlg;
	 } 
 	/**
	* Column Info
	* @param  polEtd
	*/
	public void	setPolEtd( String	polEtd ) {
		this.polEtd =	polEtd;
	}
 
	/**
	 * Column Info
	 * @return	polEtd
	 */
	 public	 String	getPolEtd() {
		 return	this.polEtd;
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
	* @param  ftEndDt
	*/
	public void	setFtEndDt( String	ftEndDt ) {
		this.ftEndDt =	ftEndDt;
	}
 
	/**
	 * Column Info
	 * @return	ftEndDt
	 */
	 public	 String	getFtEndDt() {
		 return	this.ftEndDt;
	 } 
 	/**
	* Column Info
	* @param  subLocCd
	*/
	public void	setSubLocCd( String	subLocCd ) {
		this.subLocCd =	subLocCd;
	}
 
	/**
	 * Column Info
	 * @return	subLocCd
	 */
	 public	 String	getSubLocCd() {
		 return	this.subLocCd;
	 } 
 	/**
	* Column Info
	* @param  rccCd
	*/
	public void	setRccCd( String	rccCd ) {
		this.rccCd =	rccCd;
	}
 
	/**
	 * Column Info
	 * @return	rccCd
	 */
	 public	 String	getRccCd() {
		 return	this.rccCd;
	 } 
 	/**
	* Column Info
	* @param  cmdtNm
	*/
	public void	setCmdtNm( String	cmdtNm ) {
		this.cmdtNm =	cmdtNm;
	}
 
	/**
	 * Column Info
	 * @return	cmdtNm
	 */
	 public	 String	getCmdtNm() {
		 return	this.cmdtNm;
	 } 
 	/**
	* Column Info
	* @param  deTermCd
	*/
	public void	setDeTermCd( String	deTermCd ) {
		this.deTermCd =	deTermCd;
	}
 
	/**
	 * Column Info
	 * @return	deTermCd
	 */
	 public	 String	getDeTermCd() {
		 return	this.deTermCd;
	 } 
 	/**
	* Column Info
	* @param  ftDys
	*/
	public void	setFtDys( String	ftDys ) {
		this.ftDys =	ftDys;
	}
 
	/**
	 * Column Info
	 * @return	ftDys
	 */
	 public	 String	getFtDys() {
		 return	this.ftDys;
	 } 
 	/**
	* Column Info
	* @param  scRfaNo
	*/
	public void	setScRfaNo( String	scRfaNo ) {
		this.scRfaNo =	scRfaNo;
	}
 
	/**
	 * Column Info
	 * @return	scRfaNo
	 */
	 public	 String	getScRfaNo() {
		 return	this.scRfaNo;
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
	* @param  rfTpCd
	*/
	public void	setRfTpCd( String	rfTpCd ) {
		this.rfTpCd =	rfTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rfTpCd
	 */
	 public	 String	getRfTpCd() {
		 return	this.rfTpCd;
	 } 
 	/**
	* Column Info
	* @param  bkgCgoTpCd
	*/
	public void	setBkgCgoTpCd( String	bkgCgoTpCd ) {
		this.bkgCgoTpCd =	bkgCgoTpCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgCgoTpCd
	 */
	 public	 String	getBkgCgoTpCd() {
		 return	this.bkgCgoTpCd;
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
		setNtfy(JSPUtil.getParameter(request,	prefix + "ntfy", ""));
		setActDys(JSPUtil.getParameter(request,	prefix + "act_dys", ""));
		setRccDate(JSPUtil.getParameter(request,	prefix + "rcc_date", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request,	prefix + "ob_sls_ofc_cd", ""));
		setObSrepCd(JSPUtil.getParameter(request,	prefix + "ob_srep_cd", ""));
		setUclmLsFlg(JSPUtil.getParameter(request,	prefix + "uclm_ls_flg", ""));
		setRepCmdtNm(JSPUtil.getParameter(request,	prefix + "rep_cmdt_nm", ""));
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setLoadVvd(JSPUtil.getParameter(request,	prefix + "load_vvd", ""));
		setDiscVvd(JSPUtil.getParameter(request,	prefix + "disc_vvd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setDispFlg(JSPUtil.getParameter(request,	prefix + "disp_flg", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request,	prefix + "uclm_ls_div_cd", ""));
		setFullFlg(JSPUtil.getParameter(request,	prefix + "full_flg", ""));
		setStayDays(JSPUtil.getParameter(request,	prefix + "stay_days", ""));
		setFreeDays(JSPUtil.getParameter(request,	prefix + "free_days", ""));
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request,	prefix + "dmg_flg", ""));
		setPolEtd(JSPUtil.getParameter(request,	prefix + "pol_etd", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setFtEndDt(JSPUtil.getParameter(request,	prefix + "ft_end_dt", ""));
		setSubLocCd(JSPUtil.getParameter(request,	prefix + "sub_loc_cd", ""));
		setRccCd(JSPUtil.getParameter(request,	prefix + "rcc_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request,	prefix + "cmdt_nm", ""));
		setDeTermCd(JSPUtil.getParameter(request,	prefix + "de_term_cd", ""));
		setFtDys(JSPUtil.getParameter(request,	prefix + "ft_dys", ""));
		setScRfaNo(JSPUtil.getParameter(request,	prefix + "sc_rfa_no", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setCnee(JSPUtil.getParameter(request,	prefix + "cnee", ""));
		setShpr(JSPUtil.getParameter(request,	prefix + "shpr", ""));
		setRfTpCd(JSPUtil.getParameter(request,	prefix + "rf_tp_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request,	prefix + "bkg_cgo_tp_cd", ""));
		setDmgFlgDt(JSPUtil.getParameter(request,	prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request,	prefix + "dmg_unflg_dt", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return CntrFdayListVO[]
	 */
	public CntrFdayListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return CntrFdayListVO[]
	 */
	public CntrFdayListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CntrFdayListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ntfy =	(JSPUtil.getParameter(request, prefix +	"ntfy".trim(),	length));
				String[] actDys =	(JSPUtil.getParameter(request, prefix +	"act_dys".trim(),	length));
				String[] rccDate =	(JSPUtil.getParameter(request, prefix +	"rcc_date".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] obSlsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ob_sls_ofc_cd".trim(),	length));
				String[] obSrepCd =	(JSPUtil.getParameter(request, prefix +	"ob_srep_cd".trim(),	length));
				String[] uclmLsFlg =	(JSPUtil.getParameter(request, prefix +	"uclm_ls_flg".trim(),	length));
				String[] repCmdtNm =	(JSPUtil.getParameter(request, prefix +	"rep_cmdt_nm".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] loadVvd =	(JSPUtil.getParameter(request, prefix +	"load_vvd".trim(),	length));
				String[] discVvd =	(JSPUtil.getParameter(request, prefix +	"disc_vvd".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] dispFlg =	(JSPUtil.getParameter(request, prefix +	"disp_flg".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] uclmLsDivCd =	(JSPUtil.getParameter(request, prefix +	"uclm_ls_div_cd".trim(),	length));
				String[] fullFlg =	(JSPUtil.getParameter(request, prefix +	"full_flg".trim(),	length));
				String[] stayDays =	(JSPUtil.getParameter(request, prefix +	"stay_days".trim(),	length));
				String[] freeDays =	(JSPUtil.getParameter(request, prefix +	"free_days".trim(),	length));
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] dmgFlg =	(JSPUtil.getParameter(request, prefix +	"dmg_flg".trim(),	length));
				String[] polEtd =	(JSPUtil.getParameter(request, prefix +	"pol_etd".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] ftEndDt =	(JSPUtil.getParameter(request, prefix +	"ft_end_dt".trim(),	length));
				String[] subLocCd =	(JSPUtil.getParameter(request, prefix +	"sub_loc_cd".trim(),	length));
				String[] rccCd =	(JSPUtil.getParameter(request, prefix +	"rcc_cd".trim(),	length));
				String[] cmdtNm =	(JSPUtil.getParameter(request, prefix +	"cmdt_nm".trim(),	length));
				String[] deTermCd =	(JSPUtil.getParameter(request, prefix +	"de_term_cd".trim(),	length));
				String[] ftDys =	(JSPUtil.getParameter(request, prefix +	"ft_dys".trim(),	length));
				String[] scRfaNo =	(JSPUtil.getParameter(request, prefix +	"sc_rfa_no".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq".trim(),	length));
				String[] cnee =	(JSPUtil.getParameter(request, prefix +	"cnee".trim(),	length));
				String[] shpr =	(JSPUtil.getParameter(request, prefix +	"shpr".trim(),	length));
				String[] rfTpCd =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd".trim(),	length));
				String[] bkgCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_cgo_tp_cd".trim(),	length));
				String[] dmgFlgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_flg_dt".trim(),	length));
				String[] dmgUnflgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_unflg_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CntrFdayListVO();
						if ( ntfy[i] !=	null)
						model.setNtfy( ntfy[i]);
						if ( actDys[i] !=	null)
						model.setActDys( actDys[i]);
						if ( rccDate[i] !=	null)
						model.setRccDate( rccDate[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( obSlsOfcCd[i] !=	null)
						model.setObSlsOfcCd( obSlsOfcCd[i]);
						if ( obSrepCd[i] !=	null)
						model.setObSrepCd( obSrepCd[i]);
						if ( uclmLsFlg[i] !=	null)
						model.setUclmLsFlg( uclmLsFlg[i]);
						if ( repCmdtNm[i] !=	null)
						model.setRepCmdtNm( repCmdtNm[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( loadVvd[i] !=	null)
						model.setLoadVvd( loadVvd[i]);
						if ( discVvd[i] !=	null)
						model.setDiscVvd( discVvd[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( dispFlg[i] !=	null)
						model.setDispFlg( dispFlg[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( uclmLsDivCd[i] !=	null)
						model.setUclmLsDivCd( uclmLsDivCd[i]);
						if ( fullFlg[i] !=	null)
						model.setFullFlg( fullFlg[i]);
						if ( stayDays[i] !=	null)
						model.setStayDays( stayDays[i]);
						if ( freeDays[i] !=	null)
						model.setFreeDays( freeDays[i]);
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( dmgFlg[i] !=	null)
						model.setDmgFlg( dmgFlg[i]);
						if ( polEtd[i] !=	null)
						model.setPolEtd( polEtd[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( ftEndDt[i] !=	null)
						model.setFtEndDt( ftEndDt[i]);
						if ( subLocCd[i] !=	null)
						model.setSubLocCd( subLocCd[i]);
						if ( rccCd[i] !=	null)
						model.setRccCd( rccCd[i]);
						if ( cmdtNm[i] !=	null)
						model.setCmdtNm( cmdtNm[i]);
						if ( deTermCd[i] !=	null)
						model.setDeTermCd( deTermCd[i]);
						if ( ftDys[i] !=	null)
						model.setFtDys( ftDys[i]);
						if ( scRfaNo[i] !=	null)
						model.setScRfaNo( scRfaNo[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( seq[i] !=	null)
						model.setSeq( seq[i]);
						if ( cnee[i] !=	null)
						model.setCnee( cnee[i]);
						if ( shpr[i] !=	null)
						model.setShpr( shpr[i]);
						if ( rfTpCd[i] !=	null)
						model.setRfTpCd( rfTpCd[i]);
						if ( bkgCgoTpCd[i] !=	null)
						model.setBkgCgoTpCd( bkgCgoTpCd[i]);
						if ( dmgFlgDt[i] !=	null)
						model.setDmgFlgDt( dmgFlgDt[i]);
						if ( dmgUnflgDt[i] !=	null)
						model.setDmgUnflgDt( dmgUnflgDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCntrFdayListVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return CntrFdayListVO[]
	 */
	public CntrFdayListVO[]	 getCntrFdayListVOs(){
		CntrFdayListVO[] vos = (CntrFdayListVO[])models.toArray(new	CntrFdayListVO[models.size()]);
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
		this.ntfy =	this.ntfy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDys =	this.actDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccDate =	this.rccDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd =	this.obSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd =	this.obSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsFlg =	this.uclmLsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm =	this.repCmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadVvd =	this.loadVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discVvd =	this.discVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg =	this.dispFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd =	this.uclmLsDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg =	this.fullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays =	this.stayDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDays =	this.freeDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg =	this.dmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd =	this.polEtd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt =	this.ftEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLocCd =	this.subLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd =	this.rccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm =	this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd =	this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys =	this.ftDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo =	this.scRfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee =	this.cnee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr =	this.shpr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd =	this.rfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd =	this.bkgCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt =	this.dmgFlgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt =	this.dmgUnflgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}