/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AvailableOffHireDetailVO.java
 *@FileTitle : AvailableOffHireDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.13  
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
public class AvailableOffHireDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AvailableOffHireDetailVO>  models =	new	ArrayList<AvailableOffHireDetailVO>();


	/*	Column Info	*/
	private  String	 onhYdCd   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 polEtdDt   =  null;
	/*	Column Info	*/
	private  String	 onhDt   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 offHireYard   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 usedDays   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 evntOfcCd   =  null;
	/*	Column Info	*/
	private  String	 mnrCost   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 podEtaDt   =  null;
	/*	Column Info	*/
	private  String	 minOnhDys   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 mvmtStsCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 offHireDueDate   =  null;
	/*	Column Info	*/
	private  String	 sccCd   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 fullFlg   =  null;
	/*	Column Info	*/
	private  String	 vndrAbbrNm   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 onhFreeDys   =  null;
	/*	Column Info	*/
	private  String	 remQty   =  null;
	/*	Column Info	*/
	private  String	 hldQty   =  null;
	/*	Column Info	*/
	private  String	 totQty   =  null;
	/*	Column Info	*/
	private  String	 cntrQty   =  null;
	/*	Column Info	*/
	private  String	 complexPk   =  null;
	/*	Column Info	*/
	private  String	 mtyRtnYdCd   =  null;
	/*	Column Info	*/
	private  String	 refNo   =  null;
	/*	Column Info	*/
	private  String	 cneeNm   =  null;
	/*	Column Info	*/
	private  String	 stayDys   =  null;
	/*	Column Info	*/
	private  String	 hlg   =  null;
	/*	Column Info	*/
	private  String	 yrBld   =  null;
	/*	Column Info	*/
	private  String	 rfUtMkr   =  null;
	/*	Column Info	*/
	private  String	 cntrAuthNo   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblTp   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblDesc   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AvailableOffHireDetailVO(){}

	public AvailableOffHireDetailVO(String onhYdCd,String crntYdCd,String polEtdDt,String onhDt,String cnmvDt,String blNo,String offHireYard,String pagerows,String ibflag,String usedDays,String polCd,String vvdCd,String cntrTpszCd,String agmtCtyCd,String lstmCd,String updUsrId,String evntOfcCd,String mnrCost,String agmtSeq,String agmtNo,String delCd,String podEtaDt,String minOnhDys,String podCd,String creUsrId,String mvmtStsCd,String bkgNo,String offHireDueDate,String sccCd,String cntrNo,String vndrSeq,String fullFlg,String vndrAbbrNm,String vndrLglEngNm,String onhFreeDys,String remQty,String hldQty,String totQty,String cntrQty,String complexPk,String mtyRtnYdCd,String refNo,String cneeNm,String stayDys,String hlg,String yrBld,String rfUtMkr,String cntrAuthNo,String rstrUsgLblTp,String rstrUsgLblDesc)	{
		this.onhYdCd  = onhYdCd ;
		this.crntYdCd  = crntYdCd ;
		this.polEtdDt  = polEtdDt ;
		this.onhDt  = onhDt ;
		this.cnmvDt  = cnmvDt ;
		this.blNo  = blNo ;
		this.offHireYard  = offHireYard ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.usedDays  = usedDays ;
		this.polCd  = polCd ;
		this.vvdCd  = vvdCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.lstmCd  = lstmCd ;
		this.updUsrId  = updUsrId ;
		this.evntOfcCd  = evntOfcCd ;
		this.mnrCost  = mnrCost ;
		this.agmtSeq  = agmtSeq ;
		this.agmtNo  = agmtNo ;
		this.delCd  = delCd ;
		this.podEtaDt  = podEtaDt ;
		this.minOnhDys  = minOnhDys ;
		this.podCd  = podCd ;
		this.creUsrId  = creUsrId ;
		this.mvmtStsCd  = mvmtStsCd ;
		this.bkgNo  = bkgNo ;
		this.offHireDueDate  = offHireDueDate ;
		this.sccCd  = sccCd ;
		this.cntrNo  = cntrNo ;
		this.vndrSeq  = vndrSeq ;
		this.fullFlg  = fullFlg ;
		this.vndrAbbrNm  = vndrAbbrNm ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.onhFreeDys  = onhFreeDys ;
		this.remQty  = remQty ;
		this.hldQty  = hldQty ;
		this.totQty  = totQty ;
		this.cntrQty  = cntrQty ;
		this.complexPk  = complexPk ;
		this.mtyRtnYdCd  = mtyRtnYdCd ;
		this.refNo  = refNo ;
		this.cneeNm  = cneeNm ;
		this.stayDys  = stayDys ;
		this.hlg  = hlg ;
		this.yrBld  = yrBld ;
		this.rfUtMkr  = rfUtMkr ;
		this.cntrAuthNo  = cntrAuthNo ;
		this.rstrUsgLblTp  = rstrUsgLblTp ;
		this.rstrUsgLblDesc  = rstrUsgLblDesc ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("pol_etd_dt", getPolEtdDt());		
		this.hashColumns.put("onh_dt", getOnhDt());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("off_hire_yard", getOffHireYard());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("used_days", getUsedDays());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());		
		this.hashColumns.put("mnr_cost", getMnrCost());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("pod_eta_dt", getPodEtaDt());		
		this.hashColumns.put("min_onh_dys", getMinOnhDys());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("off_hire_due_date", getOffHireDueDate());		
		this.hashColumns.put("scc_cd", getSccCd());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("full_flg", getFullFlg());		
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("onh_free_dys", getOnhFreeDys());		
		this.hashColumns.put("rem_qty", getRemQty());		
		this.hashColumns.put("hld_qty", getHldQty());		
		this.hashColumns.put("tot_qty", getTotQty());		
		this.hashColumns.put("cntr_qty", getCntrQty());		
		this.hashColumns.put("complex_pk", getComplexPk());		
		this.hashColumns.put("mty_rtn_yd_cd", getMtyRtnYdCd());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("cnee_nm", getCneeNm());		
		this.hashColumns.put("stay_dys", getStayDys());		
		this.hashColumns.put("hlg", getHlg());		
		this.hashColumns.put("yr_bld", getYrBld());		
		this.hashColumns.put("rf_ut_mkr", getRfUtMkr());		
		this.hashColumns.put("cntr_auth_no", getCntrAuthNo());	
		this.hashColumns.put("rstr_usg_lbl_tp", getRstrUsgLblTp());	
		this.hashColumns.put("rstr_usg_lbl_desc", getRstrUsgLblDesc());	
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("pol_etd_dt", "polEtdDt");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("off_hire_yard", "offHireYard");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("used_days", "usedDays");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("mnr_cost", "mnrCost");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_eta_dt", "podEtaDt");
		this.hashFields.put("min_onh_dys", "minOnhDys");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("off_hire_due_date", "offHireDueDate");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("onh_free_dys", "onhFreeDys");
		this.hashFields.put("rem_qty", "remQty");
		this.hashFields.put("hld_qty", "hldQty");
		this.hashFields.put("tot_qty", "totQty");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("complex_pk", "complexPk");
		this.hashFields.put("mty_rtn_yd_cd", "mtyRtnYdCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("cnee_nm", "cneeNm");
		this.hashFields.put("stay_dys", "stayDys");
		this.hashFields.put("hlg", "hlg");
		this.hashFields.put("yr_bld", "yrBld");
		this.hashFields.put("rf_ut_mkr", "rfUtMkr");
		this.hashFields.put("cntr_auth_no", "cntrAuthNo");
		this.hashFields.put("rstr_usg_lbl_tp", "rstrUsgLblTp");
		this.hashFields.put("rstr_usg_lbl_desc", "rstrUsgLblDesc");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  onhYdCd
	*/
	public void	setOnhYdCd( String	onhYdCd ) {
		this.onhYdCd =	onhYdCd;
	}
 
	/**
	 * Column Info
	 * @return	onhYdCd
	 */
	 public	 String	getOnhYdCd() {
		 return	this.onhYdCd;
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
	* @param  polEtdDt
	*/
	public void	setPolEtdDt( String	polEtdDt ) {
		this.polEtdDt =	polEtdDt;
	}
 
	/**
	 * Column Info
	 * @return	polEtdDt
	 */
	 public	 String	getPolEtdDt() {
		 return	this.polEtdDt;
	 } 
 	/**
	* Column Info
	* @param  onhDt
	*/
	public void	setOnhDt( String	onhDt ) {
		this.onhDt =	onhDt;
	}
 
	/**
	 * Column Info
	 * @return	onhDt
	 */
	 public	 String	getOnhDt() {
		 return	this.onhDt;
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
	* @param  offHireYard
	*/
	public void	setOffHireYard( String	offHireYard ) {
		this.offHireYard =	offHireYard;
	}
 
	/**
	 * Column Info
	 * @return	offHireYard
	 */
	 public	 String	getOffHireYard() {
		 return	this.offHireYard;
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
	* @param  usedDays
	*/
	public void	setUsedDays( String	usedDays ) {
		this.usedDays =	usedDays;
	}
 
	/**
	 * Column Info
	 * @return	usedDays
	 */
	 public	 String	getUsedDays() {
		 return	this.usedDays;
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
	* @param  evntOfcCd
	*/
	public void	setEvntOfcCd( String	evntOfcCd ) {
		this.evntOfcCd =	evntOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	evntOfcCd
	 */
	 public	 String	getEvntOfcCd() {
		 return	this.evntOfcCd;
	 } 
 	/**
	* Column Info
	* @param  mnrCost
	*/
	public void	setMnrCost( String	mnrCost ) {
		this.mnrCost =	mnrCost;
	}
 
	/**
	 * Column Info
	 * @return	mnrCost
	 */
	 public	 String	getMnrCost() {
		 return	this.mnrCost;
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
	* @param  agmtNo
	*/
	public void	setAgmtNo( String	agmtNo ) {
		this.agmtNo =	agmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtNo
	 */
	 public	 String	getAgmtNo() {
		 return	this.agmtNo;
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
	* @param  podEtaDt
	*/
	public void	setPodEtaDt( String	podEtaDt ) {
		this.podEtaDt =	podEtaDt;
	}
 
	/**
	 * Column Info
	 * @return	podEtaDt
	 */
	 public	 String	getPodEtaDt() {
		 return	this.podEtaDt;
	 } 
 	/**
	* Column Info
	* @param  minOnhDys
	*/
	public void	setMinOnhDys( String	minOnhDys ) {
		this.minOnhDys =	minOnhDys;
	}
 
	/**
	 * Column Info
	 * @return	minOnhDys
	 */
	 public	 String	getMinOnhDys() {
		 return	this.minOnhDys;
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
	* @param  mvmtStsCd
	*/
	public void	setMvmtStsCd( String	mvmtStsCd ) {
		this.mvmtStsCd =	mvmtStsCd;
	}
 
	/**
	 * Column Info
	 * @return	mvmtStsCd
	 */
	 public	 String	getMvmtStsCd() {
		 return	this.mvmtStsCd;
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
	* @param  offHireDueDate
	*/
	public void	setOffHireDueDate( String	offHireDueDate ) {
		this.offHireDueDate =	offHireDueDate;
	}
 
	/**
	 * Column Info
	 * @return	offHireDueDate
	 */
	 public	 String	getOffHireDueDate() {
		 return	this.offHireDueDate;
	 } 
 	/**
	* Column Info
	* @param  sccCd
	*/
	public void	setSccCd( String	sccCd ) {
		this.sccCd =	sccCd;
	}
 
	/**
	 * Column Info
	 * @return	sccCd
	 */
	 public	 String	getSccCd() {
		 return	this.sccCd;
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
	* @param  vndrAbbrNm
	*/
	public void	setVndrAbbrNm( String	vndrAbbrNm ) {
		this.vndrAbbrNm =	vndrAbbrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrAbbrNm
	 */
	 public	 String	getVndrAbbrNm() {
		 return	this.vndrAbbrNm;
	 } 
 	/**
	* Column Info
	* @param  vndrLglEngNm
	*/
	public void	setVndrLglEngNm( String	vndrLglEngNm ) {
		this.vndrLglEngNm =	vndrLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrLglEngNm
	 */
	 public	 String	getVndrLglEngNm() {
		 return	this.vndrLglEngNm;
	 } 
 	/**
	* Column Info
	* @param  onhFreeDys
	*/
	public void	setOnhFreeDys( String	onhFreeDys ) {
		this.onhFreeDys =	onhFreeDys;
	}
 
	/**
	 * Column Info
	 * @return	onhFreeDys
	 */
	 public	 String	getOnhFreeDys() {
		 return	this.onhFreeDys;
	 } 
 	/**
	* Column Info
	* @param  remQty
	*/
	public void	setRemQty( String	remQty ) {
		this.remQty =	remQty;
	}
 
	/**
	 * Column Info
	 * @return	remQty
	 */
	 public	 String	getRemQty() {
		 return	this.remQty;
	 } 
 	/**
	* Column Info
	* @param  hldQty
	*/
	public void	setHldQty( String	hldQty ) {
		this.hldQty =	hldQty;
	}
 
	/**
	 * Column Info
	 * @return	hldQty
	 */
	 public	 String	getHldQty() {
		 return	this.hldQty;
	 } 
 	/**
	* Column Info
	* @param  totQty
	*/
	public void	setTotQty( String	totQty ) {
		this.totQty =	totQty;
	}
 
	/**
	 * Column Info
	 * @return	totQty
	 */
	 public	 String	getTotQty() {
		 return	this.totQty;
	 } 
 	/**
	* Column Info
	* @param  cntrQty
	*/
	public void	setCntrQty( String	cntrQty ) {
		this.cntrQty =	cntrQty;
	}
 
	/**
	 * Column Info
	 * @return	cntrQty
	 */
	 public	 String	getCntrQty() {
		 return	this.cntrQty;
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
	* @param  mtyRtnYdCd
	*/
	public void	setMtyRtnYdCd( String	mtyRtnYdCd ) {
		this.mtyRtnYdCd =	mtyRtnYdCd;
	}
 
	/**
	 * Column Info
	 * @return	mtyRtnYdCd
	 */
	 public	 String	getMtyRtnYdCd() {
		 return	this.mtyRtnYdCd;
	 } 
 	/**
	* Column Info
	* @param  refNo
	*/
	public void	setRefNo( String	refNo ) {
		this.refNo =	refNo;
	}
 
	/**
	 * Column Info
	 * @return	refNo
	 */
	 public	 String	getRefNo() {
		 return	this.refNo;
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
	* @param  stayDys
	*/
	public void	setStayDys( String	stayDys ) {
		this.stayDys =	stayDys;
	}
 
	/**
	 * Column Info
	 * @return	stayDys
	 */
	 public	 String	getStayDys() {
		 return	this.stayDys;
	 } 
 	/**
	* Column Info
	* @param  hlg
	*/
	public void	setHlg( String	hlg ) {
		this.hlg =	hlg;
	}
 
	/**
	 * Column Info
	 * @return	hlg
	 */
	 public	 String	getHlg() {
		 return	this.hlg;
	 } 
 	/**
	* Column Info
	* @param  yrBld
	*/
	public void	setYrBld( String	yrBld ) {
		this.yrBld =	yrBld;
	}
 
	/**
	 * Column Info
	 * @return	yrBld
	 */
	 public	 String	getYrBld() {
		 return	this.yrBld;
	 } 
 	/**
	* Column Info
	* @param  rfUtMkr
	*/
	public void	setRfUtMkr( String	rfUtMkr ) {
		this.rfUtMkr =	rfUtMkr;
	}
 
	/**
	 * Column Info
	 * @return	rfUtMkr
	 */
	 public	 String	getRfUtMkr() {
		 return	this.rfUtMkr;
	 } 
 	/**
	* Column Info
	* @param  cntrAuthNo
	*/
	public void	setCntrAuthNo( String	cntrAuthNo ) {
		this.cntrAuthNo =	cntrAuthNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrAuthNo
	 */
	 public	 String	getCntrAuthNo() {
		 return	this.cntrAuthNo;
	 } 
	 
	 /**
	* Column Info
	* @param  rstrUsgLblTp
	*/
	public void	setRstrUsgLblTp( String	rstrUsgLblTp ) {
		this.rstrUsgLblTp =	rstrUsgLblTp;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblTp
	 */
	 public	 String	getRstrUsgLblTp() {
		 return	this.rstrUsgLblTp;
	 } 
		 
	 /**
	* Column Info
	* @param  rstrUsgLblDesc
	*/
	public void	setRstrUsgLblDesc( String	rstrUsgLblDesc ) {
		this.rstrUsgLblDesc =	rstrUsgLblDesc;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblDesc
	 */
	 public	 String	getRstrUsgLblDesc() {
		 return	this.rstrUsgLblDesc;
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
		setOnhYdCd(JSPUtil.getParameter(request,	prefix + "onh_yd_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setPolEtdDt(JSPUtil.getParameter(request,	prefix + "pol_etd_dt", ""));
		setOnhDt(JSPUtil.getParameter(request,	prefix + "onh_dt", ""));
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setOffHireYard(JSPUtil.getParameter(request,	prefix + "off_hire_yard", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setUsedDays(JSPUtil.getParameter(request,	prefix + "used_days", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setEvntOfcCd(JSPUtil.getParameter(request,	prefix + "evnt_ofc_cd", ""));
		setMnrCost(JSPUtil.getParameter(request,	prefix + "mnr_cost", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setPodEtaDt(JSPUtil.getParameter(request,	prefix + "pod_eta_dt", ""));
		setMinOnhDys(JSPUtil.getParameter(request,	prefix + "min_onh_dys", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setMvmtStsCd(JSPUtil.getParameter(request,	prefix + "mvmt_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setOffHireDueDate(JSPUtil.getParameter(request,	prefix + "off_hire_due_date", ""));
		setSccCd(JSPUtil.getParameter(request,	prefix + "scc_cd", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setFullFlg(JSPUtil.getParameter(request,	prefix + "full_flg", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request,	prefix + "vndr_abbr_nm", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setOnhFreeDys(JSPUtil.getParameter(request,	prefix + "onh_free_dys", ""));
		setRemQty(JSPUtil.getParameter(request,	prefix + "rem_qty", ""));
		setHldQty(JSPUtil.getParameter(request,	prefix + "hld_qty", ""));
		setTotQty(JSPUtil.getParameter(request,	prefix + "tot_qty", ""));
		setCntrQty(JSPUtil.getParameter(request,	prefix + "cntr_qty", ""));
		setComplexPk(JSPUtil.getParameter(request,	prefix + "complex_pk", ""));
		setMtyRtnYdCd(JSPUtil.getParameter(request,	prefix + "mty_rtn_yd_cd", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setCneeNm(JSPUtil.getParameter(request,	prefix + "cnee_nm", ""));
		setStayDys(JSPUtil.getParameter(request,	prefix + "stay_dys", ""));
		setHlg(JSPUtil.getParameter(request,	prefix + "hlg", ""));
		setYrBld(JSPUtil.getParameter(request,	prefix + "yr_bld", ""));
		setRfUtMkr(JSPUtil.getParameter(request,	prefix + "rf_ut_mkr", ""));
		setCntrAuthNo(JSPUtil.getParameter(request,	prefix + "cntr_auth_no", ""));
		setRstrUsgLblTp(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_tp", ""));
		setRstrUsgLblDesc(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_desc", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return AvailableOffHireDetailVO[]
	 */
	public AvailableOffHireDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return AvailableOffHireDetailVO[]
	 */
	public AvailableOffHireDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AvailableOffHireDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] onhYdCd =	(JSPUtil.getParameter(request, prefix +	"onh_yd_cd".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] polEtdDt =	(JSPUtil.getParameter(request, prefix +	"pol_etd_dt".trim(),	length));
				String[] onhDt =	(JSPUtil.getParameter(request, prefix +	"onh_dt".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] offHireYard =	(JSPUtil.getParameter(request, prefix +	"off_hire_yard".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] usedDays =	(JSPUtil.getParameter(request, prefix +	"used_days".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] evntOfcCd =	(JSPUtil.getParameter(request, prefix +	"evnt_ofc_cd".trim(),	length));
				String[] mnrCost =	(JSPUtil.getParameter(request, prefix +	"mnr_cost".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] podEtaDt =	(JSPUtil.getParameter(request, prefix +	"pod_eta_dt".trim(),	length));
				String[] minOnhDys =	(JSPUtil.getParameter(request, prefix +	"min_onh_dys".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] mvmtStsCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_sts_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] offHireDueDate =	(JSPUtil.getParameter(request, prefix +	"off_hire_due_date".trim(),	length));
				String[] sccCd =	(JSPUtil.getParameter(request, prefix +	"scc_cd".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] fullFlg =	(JSPUtil.getParameter(request, prefix +	"full_flg".trim(),	length));
				String[] vndrAbbrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_abbr_nm".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] onhFreeDys =	(JSPUtil.getParameter(request, prefix +	"onh_free_dys".trim(),	length));
				String[] remQty =	(JSPUtil.getParameter(request, prefix +	"rem_qty".trim(),	length));
				String[] hldQty =	(JSPUtil.getParameter(request, prefix +	"hld_qty".trim(),	length));
				String[] totQty =	(JSPUtil.getParameter(request, prefix +	"tot_qty".trim(),	length));
				String[] cntrQty =	(JSPUtil.getParameter(request, prefix +	"cntr_qty".trim(),	length));
				String[] complexPk =	(JSPUtil.getParameter(request, prefix +	"complex_pk".trim(),	length));
				String[] mtyRtnYdCd =	(JSPUtil.getParameter(request, prefix +	"mty_rtn_yd_cd".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] cneeNm =	(JSPUtil.getParameter(request, prefix +	"cnee_nm".trim(),	length));
				String[] stayDys =	(JSPUtil.getParameter(request, prefix +	"stay_dys".trim(),	length));
				String[] hlg =	(JSPUtil.getParameter(request, prefix +	"hlg".trim(),	length));
				String[] yrBld =	(JSPUtil.getParameter(request, prefix +	"yr_bld".trim(),	length));
				String[] rfUtMkr =	(JSPUtil.getParameter(request, prefix +	"rf_ut_mkr".trim(),	length));
				String[] cntrAuthNo =	(JSPUtil.getParameter(request, prefix +	"cntr_auth_no".trim(),	length));
				String[] rstrUsgLblTp =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_tp".trim(),	length));
				String[] rstrUsgLblDesc =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_desc".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AvailableOffHireDetailVO();
						if ( onhYdCd[i] !=	null)
						model.setOnhYdCd( onhYdCd[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( polEtdDt[i] !=	null)
						model.setPolEtdDt( polEtdDt[i]);
						if ( onhDt[i] !=	null)
						model.setOnhDt( onhDt[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( offHireYard[i] !=	null)
						model.setOffHireYard( offHireYard[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( usedDays[i] !=	null)
						model.setUsedDays( usedDays[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( evntOfcCd[i] !=	null)
						model.setEvntOfcCd( evntOfcCd[i]);
						if ( mnrCost[i] !=	null)
						model.setMnrCost( mnrCost[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( podEtaDt[i] !=	null)
						model.setPodEtaDt( podEtaDt[i]);
						if ( minOnhDys[i] !=	null)
						model.setMinOnhDys( minOnhDys[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( mvmtStsCd[i] !=	null)
						model.setMvmtStsCd( mvmtStsCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( offHireDueDate[i] !=	null)
						model.setOffHireDueDate( offHireDueDate[i]);
						if ( sccCd[i] !=	null)
						model.setSccCd( sccCd[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( fullFlg[i] !=	null)
						model.setFullFlg( fullFlg[i]);
						if ( vndrAbbrNm[i] !=	null)
						model.setVndrAbbrNm( vndrAbbrNm[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( onhFreeDys[i] !=	null)
						model.setOnhFreeDys( onhFreeDys[i]);
						if ( remQty[i] !=	null)
						model.setRemQty( remQty[i]);
						if ( hldQty[i] !=	null)
						model.setHldQty( hldQty[i]);
						if ( totQty[i] !=	null)
						model.setTotQty( totQty[i]);
						if ( cntrQty[i] !=	null)
						model.setCntrQty( cntrQty[i]);
						if ( complexPk[i] !=	null)
						model.setComplexPk( complexPk[i]);
						if ( mtyRtnYdCd[i] !=	null)
						model.setMtyRtnYdCd( mtyRtnYdCd[i]);
						if ( refNo[i] !=	null)
						model.setRefNo( refNo[i]);
						if ( cneeNm[i] !=	null)
						model.setCneeNm( cneeNm[i]);
						if ( stayDys[i] !=	null)
						model.setStayDys( stayDys[i]);
						if ( hlg[i] !=	null)
						model.setHlg( hlg[i]);
						if ( yrBld[i] !=	null)
						model.setYrBld( yrBld[i]);
						if ( rfUtMkr[i] !=	null)
						model.setRfUtMkr( rfUtMkr[i]);
						if ( cntrAuthNo[i] !=	null)
						model.setCntrAuthNo( cntrAuthNo[i]);
						if ( rstrUsgLblTp[i] !=	null)
						model.setRstrUsgLblTp( rstrUsgLblTp[i]);
						if ( rstrUsgLblDesc[i] !=	null)
						model.setRstrUsgLblDesc( rstrUsgLblDesc[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAvailableOffHireDetailVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return AvailableOffHireDetailVO[]
	 */
	public AvailableOffHireDetailVO[]	 getAvailableOffHireDetailVOs(){
		AvailableOffHireDetailVO[] vos = (AvailableOffHireDetailVO[])models.toArray(new	AvailableOffHireDetailVO[models.size()]);
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
		this.onhYdCd =	this.onhYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtdDt =	this.polEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt =	this.onhDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHireYard =	this.offHireYard.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedDays =	this.usedDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntOfcCd =	this.evntOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrCost =	this.mnrCost.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podEtaDt =	this.podEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOnhDys =	this.minOnhDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd =	this.mvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offHireDueDate =	this.offHireDueDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd =	this.sccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg =	this.fullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm =	this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhFreeDys =	this.onhFreeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remQty =	this.remQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldQty =	this.hldQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totQty =	this.totQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty =	this.cntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.complexPk =	this.complexPk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtyRtnYdCd =	this.mtyRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeNm =	this.cneeNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDys =	this.stayDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hlg =	this.hlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yrBld =	this.yrBld.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfUtMkr =	this.rfUtMkr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrAuthNo =	this.cntrAuthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblTp =	this.rstrUsgLblTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblDesc =	this.rstrUsgLblDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}