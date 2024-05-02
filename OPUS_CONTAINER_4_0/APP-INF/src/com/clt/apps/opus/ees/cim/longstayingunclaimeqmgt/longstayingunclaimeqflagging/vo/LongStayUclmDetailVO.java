/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : LongStayUclmDetailVO.java
 *@FileTitle : LongStayUclmDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.29
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.12.29  
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
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class LongStayUclmDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<LongStayUclmDetailVO>  models =	new	ArrayList<LongStayUclmDetailVO>();


	/*	Column Info	*/
	private  String	 ntfy   =  null;
	/*	Column Info	*/
	private  String	 actDys   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 dmgFlg   =  null;
	/*	Column Info	*/
	private  String	 vslSlanCd   =  null;
	/*	Column Info	*/
	private  String	 mkDesc   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 cnmvGmtDt   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 orgUcFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 obSlsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 orgLsFlg   =  null;
	/*	Column Info	*/
	private  String	 ftEndDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 tempUclmRsn   =  null;
	/*	Column Info	*/
	private  String	 uclmDt   =  null;
	/*	Column Info	*/
	private  String	 repCmdtNm   =  null;
	/*	Column Info	*/
	private  String	 uclmFreeDys   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 cnmvIdNo   =  null;
	/*	Column Info	*/
	private  String	 uclmCntcPntNm   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 dispFlg   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 uclmEndDt   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 uclmLsDivCd   =  null;
	/*	Column Info	*/
	private  String	 ftDys   =  null;
	/*	Column Info	*/
	private  String	 uclmRsn   =  null;
	/*	Column Info	*/
	private  String	 ucFlg   =  null;
	/*	Column Info	*/
	private  String	 lsFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 uclmPlnRmk   =  null;
	/*	Column Info	*/
	private  String	 cnee   =  null;
	/*	Column Info	*/
	private  String	 fullFlg   =  null;
	/*	Column Info	*/
	private  String	 cnmvYr   =  null;
	/*	Column Info	*/
	private  String	 stayDays   =  null;
	/*	Column Info	*/
	private  String	 shpr   =  null;
	/*	Column Info	*/
	private  String	 dmgFlgDt   =  null;
	/*	Column Info	*/
	private  String	 dmgUnflgDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public LongStayUclmDetailVO(){}

	public LongStayUclmDetailVO(String ntfy,String actDys,String crntYdCd,String dmgFlg,String vslSlanCd,String mkDesc,String blNo,String pagerows,String cnmvGmtDt,String cnmvStsCd,String ibflag,String orgUcFlg,String cntrTpszCd,String obSlsOfcCd,String orgLsFlg,String ftEndDt,String updUsrId,String updDt,String tempUclmRsn,String uclmDt,String repCmdtNm,String uclmFreeDys,String cnmvDt,String cnmvIdNo,String uclmCntcPntNm,String vvd,String dispFlg,String creUsrId,String uclmEndDt,String bkgNo,String uclmLsDivCd,String ftDys,String uclmRsn,String ucFlg,String lsFlg,String cntrNo,String uclmPlnRmk,String cnee,String fullFlg,String cnmvYr,String stayDays,String shpr,String dmgFlgDt,String dmgUnflgDt)	{
		this.ntfy  = ntfy ;
		this.actDys  = actDys ;
		this.crntYdCd  = crntYdCd ;
		this.dmgFlg  = dmgFlg ;
		this.vslSlanCd  = vslSlanCd ;
		this.mkDesc  = mkDesc ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.cnmvGmtDt  = cnmvGmtDt ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.ibflag  = ibflag ;
		this.orgUcFlg  = orgUcFlg ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.obSlsOfcCd  = obSlsOfcCd ;
		this.orgLsFlg  = orgLsFlg ;
		this.ftEndDt  = ftEndDt ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.tempUclmRsn  = tempUclmRsn ;
		this.uclmDt  = uclmDt ;
		this.repCmdtNm  = repCmdtNm ;
		this.uclmFreeDys  = uclmFreeDys ;
		this.cnmvDt  = cnmvDt ;
		this.cnmvIdNo  = cnmvIdNo ;
		this.uclmCntcPntNm  = uclmCntcPntNm ;
		this.vvd  = vvd ;
		this.dispFlg  = dispFlg ;
		this.creUsrId  = creUsrId ;
		this.uclmEndDt  = uclmEndDt ;
		this.bkgNo  = bkgNo ;
		this.uclmLsDivCd  = uclmLsDivCd ;
		this.ftDys  = ftDys ;
		this.uclmRsn  = uclmRsn ;
		this.ucFlg  = ucFlg ;
		this.lsFlg  = lsFlg ;
		this.cntrNo  = cntrNo ;
		this.uclmPlnRmk  = uclmPlnRmk ;
		this.cnee  = cnee ;
		this.fullFlg  = fullFlg ;
		this.cnmvYr  = cnmvYr ;
		this.stayDays  = stayDays ;
		this.shpr  = shpr ;
		this.dmgFlgDt  = dmgFlgDt ;
		this.dmgUnflgDt  = dmgUnflgDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());		
		this.hashColumns.put("act_dys", getActDys());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("dmg_flg", getDmgFlg());		
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());		
		this.hashColumns.put("mk_desc", getMkDesc());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cnmv_gmt_dt", getCnmvGmtDt());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("org_uc_flg", getOrgUcFlg());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());		
		this.hashColumns.put("org_ls_flg", getOrgLsFlg());		
		this.hashColumns.put("ft_end_dt", getFtEndDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("temp_uclm_rsn", getTempUclmRsn());		
		this.hashColumns.put("uclm_dt", getUclmDt());		
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());		
		this.hashColumns.put("uclm_free_dys", getUclmFreeDys());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("cnmv_id_no", getCnmvIdNo());		
		this.hashColumns.put("uclm_cntc_pnt_nm", getUclmCntcPntNm());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("disp_flg", getDispFlg());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("uclm_end_dt", getUclmEndDt());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());		
		this.hashColumns.put("ft_dys", getFtDys());		
		this.hashColumns.put("uclm_rsn", getUclmRsn());		
		this.hashColumns.put("uc_flg", getUcFlg());		
		this.hashColumns.put("ls_flg", getLsFlg());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("uclm_pln_rmk", getUclmPlnRmk());		
		this.hashColumns.put("cnee", getCnee());		
		this.hashColumns.put("full_flg", getFullFlg());		
		this.hashColumns.put("cnmv_yr", getCnmvYr());		
		this.hashColumns.put("stay_days", getStayDays());		
		this.hashColumns.put("shpr", getShpr());		
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());		
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("act_dys", "actDys");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnmv_gmt_dt", "cnmvGmtDt");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_uc_flg", "orgUcFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("org_ls_flg", "orgLsFlg");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("temp_uclm_rsn", "tempUclmRsn");
		this.hashFields.put("uclm_dt", "uclmDt");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("uclm_free_dys", "uclmFreeDys");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("cnmv_id_no", "cnmvIdNo");
		this.hashFields.put("uclm_cntc_pnt_nm", "uclmCntcPntNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("uclm_end_dt", "uclmEndDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("uclm_rsn", "uclmRsn");
		this.hashFields.put("uc_flg", "ucFlg");
		this.hashFields.put("ls_flg", "lsFlg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("uclm_pln_rmk", "uclmPlnRmk");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("cnmv_yr", "cnmvYr");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("shpr", "shpr");
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
	* @param  vslSlanCd
	*/
	public void	setVslSlanCd( String	vslSlanCd ) {
		this.vslSlanCd =	vslSlanCd;
	}
 
	/**
	 * Column Info
	 * @return	vslSlanCd
	 */
	 public	 String	getVslSlanCd() {
		 return	this.vslSlanCd;
	 } 
 	/**
	* Column Info
	* @param  mkDesc
	*/
	public void	setMkDesc( String	mkDesc ) {
		this.mkDesc =	mkDesc;
	}
 
	/**
	 * Column Info
	 * @return	mkDesc
	 */
	 public	 String	getMkDesc() {
		 return	this.mkDesc;
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
	* @param  cnmvGmtDt
	*/
	public void	setCnmvGmtDt( String	cnmvGmtDt ) {
		this.cnmvGmtDt =	cnmvGmtDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvGmtDt
	 */
	 public	 String	getCnmvGmtDt() {
		 return	this.cnmvGmtDt;
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
	* @param  orgUcFlg
	*/
	public void	setOrgUcFlg( String	orgUcFlg ) {
		this.orgUcFlg =	orgUcFlg;
	}
 
	/**
	 * Column Info
	 * @return	orgUcFlg
	 */
	 public	 String	getOrgUcFlg() {
		 return	this.orgUcFlg;
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
	* @param  orgLsFlg
	*/
	public void	setOrgLsFlg( String	orgLsFlg ) {
		this.orgLsFlg =	orgLsFlg;
	}
 
	/**
	 * Column Info
	 * @return	orgLsFlg
	 */
	 public	 String	getOrgLsFlg() {
		 return	this.orgLsFlg;
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
	* @param  tempUclmRsn
	*/
	public void	setTempUclmRsn( String	tempUclmRsn ) {
		this.tempUclmRsn =	tempUclmRsn;
	}
 
	/**
	 * Column Info
	 * @return	tempUclmRsn
	 */
	 public	 String	getTempUclmRsn() {
		 return	this.tempUclmRsn;
	 } 
 	/**
	* Column Info
	* @param  uclmDt
	*/
	public void	setUclmDt( String	uclmDt ) {
		this.uclmDt =	uclmDt;
	}
 
	/**
	 * Column Info
	 * @return	uclmDt
	 */
	 public	 String	getUclmDt() {
		 return	this.uclmDt;
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
	* @param  uclmFreeDys
	*/
	public void	setUclmFreeDys( String	uclmFreeDys ) {
		this.uclmFreeDys =	uclmFreeDys;
	}
 
	/**
	 * Column Info
	 * @return	uclmFreeDys
	 */
	 public	 String	getUclmFreeDys() {
		 return	this.uclmFreeDys;
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
	* @param  cnmvIdNo
	*/
	public void	setCnmvIdNo( String	cnmvIdNo ) {
		this.cnmvIdNo =	cnmvIdNo;
	}
 
	/**
	 * Column Info
	 * @return	cnmvIdNo
	 */
	 public	 String	getCnmvIdNo() {
		 return	this.cnmvIdNo;
	 } 
 	/**
	* Column Info
	* @param  uclmCntcPntNm
	*/
	public void	setUclmCntcPntNm( String	uclmCntcPntNm ) {
		this.uclmCntcPntNm =	uclmCntcPntNm;
	}
 
	/**
	 * Column Info
	 * @return	uclmCntcPntNm
	 */
	 public	 String	getUclmCntcPntNm() {
		 return	this.uclmCntcPntNm;
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
	* @param  uclmEndDt
	*/
	public void	setUclmEndDt( String	uclmEndDt ) {
		this.uclmEndDt =	uclmEndDt;
	}
 
	/**
	 * Column Info
	 * @return	uclmEndDt
	 */
	 public	 String	getUclmEndDt() {
		 return	this.uclmEndDt;
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
	* @param  uclmRsn
	*/
	public void	setUclmRsn( String	uclmRsn ) {
		this.uclmRsn =	uclmRsn;
	}
 
	/**
	 * Column Info
	 * @return	uclmRsn
	 */
	 public	 String	getUclmRsn() {
		 return	this.uclmRsn;
	 } 
 	/**
	* Column Info
	* @param  ucFlg
	*/
	public void	setUcFlg( String	ucFlg ) {
		this.ucFlg =	ucFlg;
	}
 
	/**
	 * Column Info
	 * @return	ucFlg
	 */
	 public	 String	getUcFlg() {
		 return	this.ucFlg;
	 } 
 	/**
	* Column Info
	* @param  lsFlg
	*/
	public void	setLsFlg( String	lsFlg ) {
		this.lsFlg =	lsFlg;
	}
 
	/**
	 * Column Info
	 * @return	lsFlg
	 */
	 public	 String	getLsFlg() {
		 return	this.lsFlg;
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
	* @param  uclmPlnRmk
	*/
	public void	setUclmPlnRmk( String	uclmPlnRmk ) {
		this.uclmPlnRmk =	uclmPlnRmk;
	}
 
	/**
	 * Column Info
	 * @return	uclmPlnRmk
	 */
	 public	 String	getUclmPlnRmk() {
		 return	this.uclmPlnRmk;
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
	* @param  cnmvYr
	*/
	public void	setCnmvYr( String	cnmvYr ) {
		this.cnmvYr =	cnmvYr;
	}
 
	/**
	 * Column Info
	 * @return	cnmvYr
	 */
	 public	 String	getCnmvYr() {
		 return	this.cnmvYr;
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
		setNtfy(JSPUtil.getParameter(request,	prefix + "ntfy", ""));
		setActDys(JSPUtil.getParameter(request,	prefix + "act_dys", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request,	prefix + "dmg_flg", ""));
		setVslSlanCd(JSPUtil.getParameter(request,	prefix + "vsl_slan_cd", ""));
		setMkDesc(JSPUtil.getParameter(request,	prefix + "mk_desc", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCnmvGmtDt(JSPUtil.getParameter(request,	prefix + "cnmv_gmt_dt", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setOrgUcFlg(JSPUtil.getParameter(request,	prefix + "org_uc_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request,	prefix + "ob_sls_ofc_cd", ""));
		setOrgLsFlg(JSPUtil.getParameter(request,	prefix + "org_ls_flg", ""));
		setFtEndDt(JSPUtil.getParameter(request,	prefix + "ft_end_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setTempUclmRsn(JSPUtil.getParameter(request,	prefix + "temp_uclm_rsn", ""));
		setUclmDt(JSPUtil.getParameter(request,	prefix + "uclm_dt", ""));
		setRepCmdtNm(JSPUtil.getParameter(request,	prefix + "rep_cmdt_nm", ""));
		setUclmFreeDys(JSPUtil.getParameter(request,	prefix + "uclm_free_dys", ""));
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setCnmvIdNo(JSPUtil.getParameter(request,	prefix + "cnmv_id_no", ""));
		setUclmCntcPntNm(JSPUtil.getParameter(request,	prefix + "uclm_cntc_pnt_nm", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setDispFlg(JSPUtil.getParameter(request,	prefix + "disp_flg", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setUclmEndDt(JSPUtil.getParameter(request,	prefix + "uclm_end_dt", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request,	prefix + "uclm_ls_div_cd", ""));
		setFtDys(JSPUtil.getParameter(request,	prefix + "ft_dys", ""));
		setUclmRsn(JSPUtil.getParameter(request,	prefix + "uclm_rsn", ""));
		setUcFlg(JSPUtil.getParameter(request,	prefix + "uc_flg", ""));
		setLsFlg(JSPUtil.getParameter(request,	prefix + "ls_flg", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setUclmPlnRmk(JSPUtil.getParameter(request,	prefix + "uclm_pln_rmk", ""));
		setCnee(JSPUtil.getParameter(request,	prefix + "cnee", ""));
		setFullFlg(JSPUtil.getParameter(request,	prefix + "full_flg", ""));
		setCnmvYr(JSPUtil.getParameter(request,	prefix + "cnmv_yr", ""));
		setStayDays(JSPUtil.getParameter(request,	prefix + "stay_days", ""));
		setShpr(JSPUtil.getParameter(request,	prefix + "shpr", ""));
		setDmgFlgDt(JSPUtil.getParameter(request,	prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request,	prefix + "dmg_unflg_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LongStayUclmDetailVO[]
	 */
	public LongStayUclmDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return LongStayUclmDetailVO[]
	 */
	public LongStayUclmDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		LongStayUclmDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ntfy =	(JSPUtil.getParameter(request, prefix +	"ntfy".trim(),	length));
				String[] actDys =	(JSPUtil.getParameter(request, prefix +	"act_dys".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] dmgFlg =	(JSPUtil.getParameter(request, prefix +	"dmg_flg".trim(),	length));
				String[] vslSlanCd =	(JSPUtil.getParameter(request, prefix +	"vsl_slan_cd".trim(),	length));
				String[] mkDesc =	(JSPUtil.getParameter(request, prefix +	"mk_desc".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] cnmvGmtDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_gmt_dt".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] orgUcFlg =	(JSPUtil.getParameter(request, prefix +	"org_uc_flg".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] obSlsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ob_sls_ofc_cd".trim(),	length));
				String[] orgLsFlg =	(JSPUtil.getParameter(request, prefix +	"org_ls_flg".trim(),	length));
				String[] ftEndDt =	(JSPUtil.getParameter(request, prefix +	"ft_end_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] tempUclmRsn =	(JSPUtil.getParameter(request, prefix +	"temp_uclm_rsn".trim(),	length));
				String[] uclmDt =	(JSPUtil.getParameter(request, prefix +	"uclm_dt".trim(),	length));
				String[] repCmdtNm =	(JSPUtil.getParameter(request, prefix +	"rep_cmdt_nm".trim(),	length));
				String[] uclmFreeDys =	(JSPUtil.getParameter(request, prefix +	"uclm_free_dys".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] cnmvIdNo =	(JSPUtil.getParameter(request, prefix +	"cnmv_id_no".trim(),	length));
				String[] uclmCntcPntNm =	(JSPUtil.getParameter(request, prefix +	"uclm_cntc_pnt_nm".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] dispFlg =	(JSPUtil.getParameter(request, prefix +	"disp_flg".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] uclmEndDt =	(JSPUtil.getParameter(request, prefix +	"uclm_end_dt".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] uclmLsDivCd =	(JSPUtil.getParameter(request, prefix +	"uclm_ls_div_cd".trim(),	length));
				String[] ftDys =	(JSPUtil.getParameter(request, prefix +	"ft_dys".trim(),	length));
				String[] uclmRsn =	(JSPUtil.getParameter(request, prefix +	"uclm_rsn".trim(),	length));
				String[] ucFlg =	(JSPUtil.getParameter(request, prefix +	"uc_flg".trim(),	length));
				String[] lsFlg =	(JSPUtil.getParameter(request, prefix +	"ls_flg".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] uclmPlnRmk =	(JSPUtil.getParameter(request, prefix +	"uclm_pln_rmk".trim(),	length));
				String[] cnee =	(JSPUtil.getParameter(request, prefix +	"cnee".trim(),	length));
				String[] fullFlg =	(JSPUtil.getParameter(request, prefix +	"full_flg".trim(),	length));
				String[] cnmvYr =	(JSPUtil.getParameter(request, prefix +	"cnmv_yr".trim(),	length));
				String[] stayDays =	(JSPUtil.getParameter(request, prefix +	"stay_days".trim(),	length));
				String[] shpr =	(JSPUtil.getParameter(request, prefix +	"shpr".trim(),	length));
				String[] dmgFlgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_flg_dt".trim(),	length));
				String[] dmgUnflgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_unflg_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	LongStayUclmDetailVO();
						if ( ntfy[i] !=	null)
						model.setNtfy( ntfy[i]);
						if ( actDys[i] !=	null)
						model.setActDys( actDys[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( dmgFlg[i] !=	null)
						model.setDmgFlg( dmgFlg[i]);
						if ( vslSlanCd[i] !=	null)
						model.setVslSlanCd( vslSlanCd[i]);
						if ( mkDesc[i] !=	null)
						model.setMkDesc( mkDesc[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( cnmvGmtDt[i] !=	null)
						model.setCnmvGmtDt( cnmvGmtDt[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( orgUcFlg[i] !=	null)
						model.setOrgUcFlg( orgUcFlg[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( obSlsOfcCd[i] !=	null)
						model.setObSlsOfcCd( obSlsOfcCd[i]);
						if ( orgLsFlg[i] !=	null)
						model.setOrgLsFlg( orgLsFlg[i]);
						if ( ftEndDt[i] !=	null)
						model.setFtEndDt( ftEndDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( tempUclmRsn[i] !=	null)
						model.setTempUclmRsn( tempUclmRsn[i]);
						if ( uclmDt[i] !=	null)
						model.setUclmDt( uclmDt[i]);
						if ( repCmdtNm[i] !=	null)
						model.setRepCmdtNm( repCmdtNm[i]);
						if ( uclmFreeDys[i] !=	null)
						model.setUclmFreeDys( uclmFreeDys[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( cnmvIdNo[i] !=	null)
						model.setCnmvIdNo( cnmvIdNo[i]);
						if ( uclmCntcPntNm[i] !=	null)
						model.setUclmCntcPntNm( uclmCntcPntNm[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( dispFlg[i] !=	null)
						model.setDispFlg( dispFlg[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( uclmEndDt[i] !=	null)
						model.setUclmEndDt( uclmEndDt[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( uclmLsDivCd[i] !=	null)
						model.setUclmLsDivCd( uclmLsDivCd[i]);
						if ( ftDys[i] !=	null)
						model.setFtDys( ftDys[i]);
						if ( uclmRsn[i] !=	null)
						model.setUclmRsn( uclmRsn[i]);
						if ( ucFlg[i] !=	null)
						model.setUcFlg( ucFlg[i]);
						if ( lsFlg[i] !=	null)
						model.setLsFlg( lsFlg[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( uclmPlnRmk[i] !=	null)
						model.setUclmPlnRmk( uclmPlnRmk[i]);
						if ( cnee[i] !=	null)
						model.setCnee( cnee[i]);
						if ( fullFlg[i] !=	null)
						model.setFullFlg( fullFlg[i]);
						if ( cnmvYr[i] !=	null)
						model.setCnmvYr( cnmvYr[i]);
						if ( stayDays[i] !=	null)
						model.setStayDays( stayDays[i]);
						if ( shpr[i] !=	null)
						model.setShpr( shpr[i]);
						if ( dmgFlgDt[i] !=	null)
						model.setDmgFlgDt( dmgFlgDt[i]);
						if ( dmgUnflgDt[i] !=	null)
						model.setDmgUnflgDt( dmgUnflgDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getLongStayUclmDetailVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return LongStayUclmDetailVO[]
	 */
	public LongStayUclmDetailVO[]	 getLongStayUclmDetailVOs(){
		LongStayUclmDetailVO[] vos = (LongStayUclmDetailVO[])models.toArray(new	LongStayUclmDetailVO[models.size()]);
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
		this.ntfy =	this.ntfy.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDys =	this.actDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg =	this.dmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd =	this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc =	this.mkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvGmtDt =	this.cnmvGmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgUcFlg =	this.orgUcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd =	this.obSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgLsFlg =	this.orgLsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt =	this.ftEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tempUclmRsn =	this.tempUclmRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmDt =	this.uclmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm =	this.repCmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmFreeDys =	this.uclmFreeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvIdNo =	this.cnmvIdNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmCntcPntNm =	this.uclmCntcPntNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg =	this.dispFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmEndDt =	this.uclmEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd =	this.uclmLsDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys =	this.ftDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmRsn =	this.uclmRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ucFlg =	this.ucFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsFlg =	this.lsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmPlnRmk =	this.uclmPlnRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee =	this.cnee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg =	this.fullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvYr =	this.cnmvYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays =	this.stayDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr =	this.shpr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt =	this.dmgFlgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt =	this.dmgUnflgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}