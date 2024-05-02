/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SearchDodTariffListVO.java
 *@FileTitle : SearchDodTariffListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.24
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.11.24  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.ees.dod.dodtariff.dropofftariff.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class SearchDodTariffListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SearchDodTariffListVO>  models =	new	ArrayList<SearchDodTariffListVO>();


	/*	Column Info	*/
	private  String	 sRtnLocCd   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfDivCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 spclCustNm   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfAmt   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfEffDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfRmk   =  null;
	/*	Column Info	*/
	private  String	 sCustCd   =  null;
	/*	Column Info	*/
	private  String	 sTrfExptFlg   =  null;
	/*	Column Info	*/
	private  String	 sYdSfxCd   =  null;
	/*	Column Info	*/
	private  String	 sFrmEffDt   =  null;
	/*	Column Info	*/
	private  String	 sCntCd   =  null;
	/*	Column Info	*/
	private  String	 polContiCd   =  null;
	/*	Column Info	*/
	private  String	 cntrRtnYdSfxCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 spclCustSeq   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfCfmFlg   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfExpFlg   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfCntCd   =  null;
	/*	Column Info	*/
	private  String	 spclCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 deltFlg   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfCfmUsrId   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfExpDt   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfCfmDt   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfExptFlg   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 rfaNo   =  null;
	/*	Column Info	*/
	private  String	 sTrfDivCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 spclCustCntSeq   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 sOfcCd   =  null;
	/*	Column Info	*/
	private  String	 cntrRtnLocCd   =  null;
	/*	Column Info	*/
	private  String	 drpOffChgTrfSeq   =  null;
	/*	Column Info	*/
	private  String	 sToEffDt   =  null;
	/*	Column Info	*/
	private  String	 chgCnt   =  null;
	/*	Column Info	*/
	private  String	 atchFileLnkCnt   =  null;
	/*	Column Info	*/
	private  String	 sNoType   =  null;
	/*	Column Info	*/
	private  String	 sNo   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	
	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public SearchDodTariffListVO(){}

	public SearchDodTariffListVO(String sRtnLocCd,String drpOffChgTrfDivCd,String ibflag,String scNo,String spclCustNm,String drpOffChgTrfAmt,String drpOffChgTrfEffDt,String updUsrId,String creUsrId,String drpOffChgTrfRmk,String sCustCd,String sTrfExptFlg,String sYdSfxCd,String sFrmEffDt,String sCntCd,String polContiCd,String cntrRtnYdSfxCd,String pagerows,String spclCustSeq,String drpOffChgTrfCfmFlg,String currCd,String drpOffChgTrfExpFlg,String drpOffChgTrfCntCd,String spclCustCntCd,String deltFlg,String drpOffChgTrfCfmUsrId,String drpOffChgTrfExpDt,String drpOffChgTrfCfmDt,String drpOffChgTrfExptFlg,String creDt,String rfaNo,String sTrfDivCd,String cntrTpszCd,String spclCustCntSeq,String delCd,String updDt,String sOfcCd,String cntrRtnLocCd,String drpOffChgTrfSeq,String sToEffDt,String chgCnt, String atchFileLnkCnt, String sNoType, String sNo, String custNm)	{
		this.sRtnLocCd  = sRtnLocCd ;
		this.drpOffChgTrfDivCd  = drpOffChgTrfDivCd ;
		this.ibflag  = ibflag ;
		this.scNo  = scNo ;
		this.spclCustNm  = spclCustNm ;
		this.drpOffChgTrfAmt  = drpOffChgTrfAmt ;
		this.drpOffChgTrfEffDt  = drpOffChgTrfEffDt ;
		this.updUsrId  = updUsrId ;
		this.creUsrId  = creUsrId ;
		this.drpOffChgTrfRmk  = drpOffChgTrfRmk ;
		this.sCustCd  = sCustCd ;
		this.sTrfExptFlg  = sTrfExptFlg ;
		this.sYdSfxCd  = sYdSfxCd ;
		this.sFrmEffDt  = sFrmEffDt ;
		this.sCntCd  = sCntCd ;
		this.polContiCd  = polContiCd ;
		this.cntrRtnYdSfxCd  = cntrRtnYdSfxCd ;
		this.pagerows  = pagerows ;
		this.spclCustSeq  = spclCustSeq ;
		this.drpOffChgTrfCfmFlg  = drpOffChgTrfCfmFlg ;
		this.currCd  = currCd ;
		this.drpOffChgTrfExpFlg  = drpOffChgTrfExpFlg ;
		this.drpOffChgTrfCntCd  = drpOffChgTrfCntCd ;
		this.spclCustCntCd  = spclCustCntCd ;
		this.deltFlg  = deltFlg ;
		this.drpOffChgTrfCfmUsrId  = drpOffChgTrfCfmUsrId ;
		this.drpOffChgTrfExpDt  = drpOffChgTrfExpDt ;
		this.drpOffChgTrfCfmDt  = drpOffChgTrfCfmDt ;
		this.drpOffChgTrfExptFlg  = drpOffChgTrfExptFlg ;
		this.creDt  = creDt ;
		this.rfaNo  = rfaNo ;
		this.sTrfDivCd  = sTrfDivCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.spclCustCntSeq  = spclCustCntSeq ;
		this.delCd  = delCd ;
		this.updDt  = updDt ;
		this.sOfcCd  = sOfcCd ;
		this.cntrRtnLocCd  = cntrRtnLocCd ;
		this.drpOffChgTrfSeq  = drpOffChgTrfSeq ;
		this.sToEffDt  = sToEffDt ;
		this.chgCnt  = chgCnt ;
		this.atchFileLnkCnt = atchFileLnkCnt;
		this.sNoType = sNoType;
		this.sNo = sNo;
		this.custNm = custNm;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_rtn_loc_cd", getSRtnLocCd());		
		this.hashColumns.put("drp_off_chg_trf_div_cd", getDrpOffChgTrfDivCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("spcl_cust_nm", getSpclCustNm());		
		this.hashColumns.put("drp_off_chg_trf_amt", getDrpOffChgTrfAmt());		
		this.hashColumns.put("drp_off_chg_trf_eff_dt", getDrpOffChgTrfEffDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("drp_off_chg_trf_rmk", getDrpOffChgTrfRmk());		
		this.hashColumns.put("s_cust_cd", getSCustCd());		
		this.hashColumns.put("s_trf_expt_flg", getSTrfExptFlg());		
		this.hashColumns.put("s_yd_sfx_cd", getSYdSfxCd());		
		this.hashColumns.put("s_frm_eff_dt", getSFrmEffDt());		
		this.hashColumns.put("s_cnt_cd", getSCntCd());		
		this.hashColumns.put("pol_conti_cd", getPolContiCd());		
		this.hashColumns.put("cntr_rtn_yd_sfx_cd", getCntrRtnYdSfxCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("spcl_cust_seq", getSpclCustSeq());		
		this.hashColumns.put("drp_off_chg_trf_cfm_flg", getDrpOffChgTrfCfmFlg());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("drp_off_chg_trf_exp_flg", getDrpOffChgTrfExpFlg());		
		this.hashColumns.put("drp_off_chg_trf_cnt_cd", getDrpOffChgTrfCntCd());		
		this.hashColumns.put("spcl_cust_cnt_cd", getSpclCustCntCd());		
		this.hashColumns.put("delt_flg", getDeltFlg());		
		this.hashColumns.put("drp_off_chg_trf_cfm_usr_id", getDrpOffChgTrfCfmUsrId());		
		this.hashColumns.put("drp_off_chg_trf_exp_dt", getDrpOffChgTrfExpDt());		
		this.hashColumns.put("drp_off_chg_trf_cfm_dt", getDrpOffChgTrfCfmDt());		
		this.hashColumns.put("drp_off_chg_trf_expt_flg", getDrpOffChgTrfExptFlg());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("rfa_no", getRfaNo());		
		this.hashColumns.put("s_trf_div_cd", getSTrfDivCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("spcl_cust_cnt_seq", getSpclCustCntSeq());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("s_ofc_cd", getSOfcCd());		
		this.hashColumns.put("cntr_rtn_loc_cd", getCntrRtnLocCd());		
		this.hashColumns.put("drp_off_chg_trf_seq", getDrpOffChgTrfSeq());		
		this.hashColumns.put("s_to_eff_dt", getSToEffDt());		
		this.hashColumns.put("chg_cnt", getChgCnt());	
		this.hashColumns.put("atch_file_lnk_cnt", getAtchFileLnkCnt());
		this.hashColumns.put("s_no_type", getsNoType());
		this.hashColumns.put("s_no", getsNo());
		this.hashColumns.put("cust_nm", getCustNm());
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("s_rtn_loc_cd", "sRtnLocCd");
		this.hashFields.put("drp_off_chg_trf_div_cd", "drpOffChgTrfDivCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("spcl_cust_nm", "spclCustNm");
		this.hashFields.put("drp_off_chg_trf_amt", "drpOffChgTrfAmt");
		this.hashFields.put("drp_off_chg_trf_eff_dt", "drpOffChgTrfEffDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("drp_off_chg_trf_rmk", "drpOffChgTrfRmk");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("s_trf_expt_flg", "sTrfExptFlg");
		this.hashFields.put("s_yd_sfx_cd", "sYdSfxCd");
		this.hashFields.put("s_frm_eff_dt", "sFrmEffDt");
		this.hashFields.put("s_cnt_cd", "sCntCd");
		this.hashFields.put("pol_conti_cd", "polContiCd");
		this.hashFields.put("cntr_rtn_yd_sfx_cd", "cntrRtnYdSfxCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("spcl_cust_seq", "spclCustSeq");
		this.hashFields.put("drp_off_chg_trf_cfm_flg", "drpOffChgTrfCfmFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("drp_off_chg_trf_exp_flg", "drpOffChgTrfExpFlg");
		this.hashFields.put("drp_off_chg_trf_cnt_cd", "drpOffChgTrfCntCd");
		this.hashFields.put("spcl_cust_cnt_cd", "spclCustCntCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("drp_off_chg_trf_cfm_usr_id", "drpOffChgTrfCfmUsrId");
		this.hashFields.put("drp_off_chg_trf_exp_dt", "drpOffChgTrfExpDt");
		this.hashFields.put("drp_off_chg_trf_cfm_dt", "drpOffChgTrfCfmDt");
		this.hashFields.put("drp_off_chg_trf_expt_flg", "drpOffChgTrfExptFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("s_trf_div_cd", "sTrfDivCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("spcl_cust_cnt_seq", "spclCustCntSeq");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("s_ofc_cd", "sOfcCd");
		this.hashFields.put("cntr_rtn_loc_cd", "cntrRtnLocCd");
		this.hashFields.put("drp_off_chg_trf_seq", "drpOffChgTrfSeq");
		this.hashFields.put("s_to_eff_dt", "sToEffDt");
		this.hashFields.put("chg_cnt", "chgCnt");
		this.hashFields.put("atch_file_lnk_cnt", "atchFileLnkCnt");
		this.hashFields.put("s_no_type", "sNoType");
		this.hashFields.put("s_no", "sNo");
		this.hashFields.put("cust_nm", "custNm");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  sRtnLocCd
	*/
	public void	setSRtnLocCd( String	sRtnLocCd ) {
		this.sRtnLocCd =	sRtnLocCd;
	}
 
	/**
	 * Column Info
	 * @return	sRtnLocCd
	 */
	 public	String	getSRtnLocCd() {
		 return	this.sRtnLocCd;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfDivCd
	*/
	public void	setDrpOffChgTrfDivCd( String	drpOffChgTrfDivCd ) {
		this.drpOffChgTrfDivCd =	drpOffChgTrfDivCd;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfDivCd
	 */
	 public	String	getDrpOffChgTrfDivCd() {
		 return	this.drpOffChgTrfDivCd;
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
	 public	String	getIbflag() {
		 return	this.ibflag;
	 } 
 	/**
	* Column Info
	* @param  scNo
	*/
	public void	setScNo( String	scNo ) {
		this.scNo =	scNo;
	}
 
	/**
	 * Column Info
	 * @return	scNo
	 */
	 public	String	getScNo() {
		 return	this.scNo;
	 } 
 	/**
	* Column Info
	* @param  spclCustNm
	*/
	public void	setSpclCustNm( String	spclCustNm ) {
		this.spclCustNm =	spclCustNm;
	}
 
	/**
	 * Column Info
	 * @return	spclCustNm
	 */
	 public	String	getSpclCustNm() {
		 return	this.spclCustNm;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfAmt
	*/
	public void	setDrpOffChgTrfAmt( String	drpOffChgTrfAmt ) {
		this.drpOffChgTrfAmt =	drpOffChgTrfAmt;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfAmt
	 */
	 public	String	getDrpOffChgTrfAmt() {
		 return	this.drpOffChgTrfAmt;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfEffDt
	*/
	public void	setDrpOffChgTrfEffDt( String	drpOffChgTrfEffDt ) {
		this.drpOffChgTrfEffDt =	drpOffChgTrfEffDt;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfEffDt
	 */
	 public	String	getDrpOffChgTrfEffDt() {
		 return	this.drpOffChgTrfEffDt;
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
	 public	String	getUpdUsrId() {
		 return	this.updUsrId;
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
	 public	String	getCreUsrId() {
		 return	this.creUsrId;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfRmk
	*/
	public void	setDrpOffChgTrfRmk( String	drpOffChgTrfRmk ) {
		this.drpOffChgTrfRmk =	drpOffChgTrfRmk;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfRmk
	 */
	 public	String	getDrpOffChgTrfRmk() {
		 return	this.drpOffChgTrfRmk;
	 } 
 	/**
	* Column Info
	* @param  sCustCd
	*/
	public void	setSCustCd( String	sCustCd ) {
		this.sCustCd =	sCustCd;
	}
 
	/**
	 * Column Info
	 * @return	sCustCd
	 */
	 public	String	getSCustCd() {
		 return	this.sCustCd;
	 } 
 	/**
	* Column Info
	* @param  sTrfExptFlg
	*/
	public void	setSTrfExptFlg( String	sTrfExptFlg ) {
		this.sTrfExptFlg =	sTrfExptFlg;
	}
 
	/**
	 * Column Info
	 * @return	sTrfExptFlg
	 */
	 public	String	getSTrfExptFlg() {
		 return	this.sTrfExptFlg;
	 } 
 	/**
	* Column Info
	* @param  sYdSfxCd
	*/
	public void	setSYdSfxCd( String	sYdSfxCd ) {
		this.sYdSfxCd =	sYdSfxCd;
	}
 
	/**
	 * Column Info
	 * @return	sYdSfxCd
	 */
	 public	String	getSYdSfxCd() {
		 return	this.sYdSfxCd;
	 } 
 	/**
	* Column Info
	* @param  sFrmEffDt
	*/
	public void	setSFrmEffDt( String	sFrmEffDt ) {
		this.sFrmEffDt =	sFrmEffDt;
	}
 
	/**
	 * Column Info
	 * @return	sFrmEffDt
	 */
	 public	String	getSFrmEffDt() {
		 return	this.sFrmEffDt;
	 } 
 	/**
	* Column Info
	* @param  sCntCd
	*/
	public void	setSCntCd( String	sCntCd ) {
		this.sCntCd =	sCntCd;
	}
 
	/**
	 * Column Info
	 * @return	sCntCd
	 */
	 public	String	getSCntCd() {
		 return	this.sCntCd;
	 } 
 	/**
	* Column Info
	* @param  polContiCd
	*/
	public void	setPolContiCd( String	polContiCd ) {
		this.polContiCd =	polContiCd;
	}
 
	/**
	 * Column Info
	 * @return	polContiCd
	 */
	 public	String	getPolContiCd() {
		 return	this.polContiCd;
	 } 
 	/**
	* Column Info
	* @param  cntrRtnYdSfxCd
	*/
	public void	setCntrRtnYdSfxCd( String	cntrRtnYdSfxCd ) {
		this.cntrRtnYdSfxCd =	cntrRtnYdSfxCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrRtnYdSfxCd
	 */
	 public	String	getCntrRtnYdSfxCd() {
		 return	this.cntrRtnYdSfxCd;
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
	 public	String	getPagerows() {
		 return	this.pagerows;
	 } 
 	/**
	* Column Info
	* @param  spclCustSeq
	*/
	public void	setSpclCustSeq( String	spclCustSeq ) {
		this.spclCustSeq =	spclCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	spclCustSeq
	 */
	 public	String	getSpclCustSeq() {
		 return	this.spclCustSeq;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfCfmFlg
	*/
	public void	setDrpOffChgTrfCfmFlg( String	drpOffChgTrfCfmFlg ) {
		this.drpOffChgTrfCfmFlg =	drpOffChgTrfCfmFlg;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfCfmFlg
	 */
	 public	String	getDrpOffChgTrfCfmFlg() {
		 return	this.drpOffChgTrfCfmFlg;
	 } 
 	/**
	* Column Info
	* @param  currCd
	*/
	public void	setCurrCd( String	currCd ) {
		this.currCd =	currCd;
	}
 
	/**
	 * Column Info
	 * @return	currCd
	 */
	 public	String	getCurrCd() {
		 return	this.currCd;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfExpFlg
	*/
	public void	setDrpOffChgTrfExpFlg( String	drpOffChgTrfExpFlg ) {
		this.drpOffChgTrfExpFlg =	drpOffChgTrfExpFlg;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfExpFlg
	 */
	 public	String	getDrpOffChgTrfExpFlg() {
		 return	this.drpOffChgTrfExpFlg;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfCntCd
	*/
	public void	setDrpOffChgTrfCntCd( String	drpOffChgTrfCntCd ) {
		this.drpOffChgTrfCntCd =	drpOffChgTrfCntCd;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfCntCd
	 */
	 public	String	getDrpOffChgTrfCntCd() {
		 return	this.drpOffChgTrfCntCd;
	 } 
 	/**
	* Column Info
	* @param  spclCustCntCd
	*/
	public void	setSpclCustCntCd( String	spclCustCntCd ) {
		this.spclCustCntCd =	spclCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	spclCustCntCd
	 */
	 public	String	getSpclCustCntCd() {
		 return	this.spclCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  deltFlg
	*/
	public void	setDeltFlg( String	deltFlg ) {
		this.deltFlg =	deltFlg;
	}
 
	/**
	 * Column Info
	 * @return	deltFlg
	 */
	 public	String	getDeltFlg() {
		 return	this.deltFlg;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfCfmUsrId
	*/
	public void	setDrpOffChgTrfCfmUsrId( String	drpOffChgTrfCfmUsrId ) {
		this.drpOffChgTrfCfmUsrId =	drpOffChgTrfCfmUsrId;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfCfmUsrId
	 */
	 public	String	getDrpOffChgTrfCfmUsrId() {
		 return	this.drpOffChgTrfCfmUsrId;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfExpDt
	*/
	public void	setDrpOffChgTrfExpDt( String	drpOffChgTrfExpDt ) {
		this.drpOffChgTrfExpDt =	drpOffChgTrfExpDt;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfExpDt
	 */
	 public	String	getDrpOffChgTrfExpDt() {
		 return	this.drpOffChgTrfExpDt;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfCfmDt
	*/
	public void	setDrpOffChgTrfCfmDt( String	drpOffChgTrfCfmDt ) {
		this.drpOffChgTrfCfmDt =	drpOffChgTrfCfmDt;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfCfmDt
	 */
	 public	String	getDrpOffChgTrfCfmDt() {
		 return	this.drpOffChgTrfCfmDt;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfExptFlg
	*/
	public void	setDrpOffChgTrfExptFlg( String	drpOffChgTrfExptFlg ) {
		this.drpOffChgTrfExptFlg =	drpOffChgTrfExptFlg;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfExptFlg
	 */
	 public	String	getDrpOffChgTrfExptFlg() {
		 return	this.drpOffChgTrfExptFlg;
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
	 public	String	getCreDt() {
		 return	this.creDt;
	 } 
 	/**
	* Column Info
	* @param  rfaNo
	*/
	public void	setRfaNo( String	rfaNo ) {
		this.rfaNo =	rfaNo;
	}
 
	/**
	 * Column Info
	 * @return	rfaNo
	 */
	 public	String	getRfaNo() {
		 return	this.rfaNo;
	 } 
 	/**
	* Column Info
	* @param  sTrfDivCd
	*/
	public void	setSTrfDivCd( String	sTrfDivCd ) {
		this.sTrfDivCd =	sTrfDivCd;
	}
 
	/**
	 * Column Info
	 * @return	sTrfDivCd
	 */
	 public	String	getSTrfDivCd() {
		 return	this.sTrfDivCd;
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
	 public	String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  spclCustCntSeq
	*/
	public void	setSpclCustCntSeq( String	spclCustCntSeq ) {
		this.spclCustCntSeq =	spclCustCntSeq;
	}
 
	/**
	 * Column Info
	 * @return	spclCustCntSeq
	 */
	 public	String	getSpclCustCntSeq() {
		 return	this.spclCustCntSeq;
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
	 public	String	getDelCd() {
		 return	this.delCd;
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
	 public	String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  sOfcCd
	*/
	public void	setSOfcCd( String	sOfcCd ) {
		this.sOfcCd =	sOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	sOfcCd
	 */
	 public	String	getSOfcCd() {
		 return	this.sOfcCd;
	 } 
 	/**
	* Column Info
	* @param  cntrRtnLocCd
	*/
	public void	setCntrRtnLocCd( String	cntrRtnLocCd ) {
		this.cntrRtnLocCd =	cntrRtnLocCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrRtnLocCd
	 */
	 public	String	getCntrRtnLocCd() {
		 return	this.cntrRtnLocCd;
	 } 
 	/**
	* Column Info
	* @param  drpOffChgTrfSeq
	*/
	public void	setDrpOffChgTrfSeq( String	drpOffChgTrfSeq ) {
		this.drpOffChgTrfSeq =	drpOffChgTrfSeq;
	}
 
	/**
	 * Column Info
	 * @return	drpOffChgTrfSeq
	 */
	 public	String	getDrpOffChgTrfSeq() {
		 return	this.drpOffChgTrfSeq;
	 } 
 	/**
	* Column Info
	* @param  sToEffDt
	*/
	public void	setSToEffDt( String	sToEffDt ) {
		this.sToEffDt =	sToEffDt;
	}
 
	/**
	 * Column Info
	 * @return	sToEffDt
	 */
	 public	String	getSToEffDt() {
		 return	this.sToEffDt;
	 } 
 	/**
	* Column Info
	* @param  chgCnt
	*/
	public void	setChgCnt( String	chgCnt ) {
		this.chgCnt =	chgCnt;
	}
 
	/**
	 * Column Info
	 * @return	chgCnt
	 */
	 public	String	getChgCnt() {
		 return	this.chgCnt;
	 } 

	/**
	 * Column Info
	 * @return	atchFileLnkCnt
	 */
	 public void setAtchFileLnkCnt(String atchFileLnkCnt) {
		 this.atchFileLnkCnt = atchFileLnkCnt;
	 }
	 
	/**
	 * Column Info
	 * @return	sNoType
	 */
	public String getsNoType() {
		return sNoType;
	}
	
	/**
	 * Column Info
	 * @return	sNoType
	 */
	public void setsNoType(String sNoType) {
		this.sNoType = sNoType;
	}
	
	/**
	 * Column Info
	 * @return	sNo
	 */
	public String getsNo() {
		return sNo;
	}
	
	/**
	 * Column Info
	 * @return	custNm
	 */
	public String getCustNm() {
		return custNm;
	}
	
	
	/**
	 * Column Info
	 * @return	sNo
	 */
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	
	/**
	 * Column Info
	 * @return	custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	/**
	 * Column Info
	 * @return	atchFileLnkCnt
	 */
	 public String getAtchFileLnkCnt() {
		 return atchFileLnkCnt;
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
		setSRtnLocCd(JSPUtil.getParameter(request,	prefix + "s_rtn_loc_cd", ""));
		setDrpOffChgTrfDivCd(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_div_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setSpclCustNm(JSPUtil.getParameter(request,	prefix + "spcl_cust_nm", ""));
		setDrpOffChgTrfAmt(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_amt", ""));
		setDrpOffChgTrfEffDt(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_eff_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setDrpOffChgTrfRmk(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_rmk", ""));
		setSCustCd(JSPUtil.getParameter(request,	prefix + "s_cust_cd", ""));
		setSTrfExptFlg(JSPUtil.getParameter(request,	prefix + "s_trf_expt_flg", ""));
		setSYdSfxCd(JSPUtil.getParameter(request,	prefix + "s_yd_sfx_cd", ""));
		setSFrmEffDt(JSPUtil.getParameter(request,	prefix + "s_frm_eff_dt", ""));
		setSCntCd(JSPUtil.getParameter(request,	prefix + "s_cnt_cd", ""));
		setPolContiCd(JSPUtil.getParameter(request,	prefix + "pol_conti_cd", ""));
		setCntrRtnYdSfxCd(JSPUtil.getParameter(request,	prefix + "cntr_rtn_yd_sfx_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setSpclCustSeq(JSPUtil.getParameter(request,	prefix + "spcl_cust_seq", ""));
		setDrpOffChgTrfCfmFlg(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_cfm_flg", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setDrpOffChgTrfExpFlg(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_exp_flg", ""));
		setDrpOffChgTrfCntCd(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_cnt_cd", ""));
		setSpclCustCntCd(JSPUtil.getParameter(request,	prefix + "spcl_cust_cnt_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request,	prefix + "delt_flg", ""));
		setDrpOffChgTrfCfmUsrId(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_cfm_usr_id", ""));
		setDrpOffChgTrfExpDt(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_exp_dt", ""));
		setDrpOffChgTrfCfmDt(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_cfm_dt", ""));
		setDrpOffChgTrfExptFlg(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_expt_flg", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setRfaNo(JSPUtil.getParameter(request,	prefix + "rfa_no", ""));
		setSTrfDivCd(JSPUtil.getParameter(request,	prefix + "s_trf_div_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setSpclCustCntSeq(JSPUtil.getParameter(request,	prefix + "spcl_cust_cnt_seq", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setSOfcCd(JSPUtil.getParameter(request,	prefix + "s_ofc_cd", ""));
		setCntrRtnLocCd(JSPUtil.getParameter(request,	prefix + "cntr_rtn_loc_cd", ""));
		setDrpOffChgTrfSeq(JSPUtil.getParameter(request,	prefix + "drp_off_chg_trf_seq", ""));
		setSToEffDt(JSPUtil.getParameter(request,	prefix + "s_to_eff_dt", ""));
		setChgCnt(JSPUtil.getParameter(request,	prefix + "chg_cnt", ""));
		setAtchFileLnkCnt(JSPUtil.getParameter(request,	prefix + "atch_file_lnk_cnt", ""));
		setsNoType(JSPUtil.getParameter(request,	prefix + "s_no_type", ""));
		setsNo(JSPUtil.getParameter(request,	prefix + "s_no", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchDodTariffListVO[]
	 */
	public SearchDodTariffListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchDodTariffListVO[]
	 */
	public SearchDodTariffListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SearchDodTariffListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] sRtnLocCd =	(JSPUtil.getParameter(request, prefix +	"s_rtn_loc_cd".trim(),	length));
				String[] drpOffChgTrfDivCd =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_div_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] spclCustNm =	(JSPUtil.getParameter(request, prefix +	"spcl_cust_nm".trim(),	length));
				String[] drpOffChgTrfAmt =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_amt".trim(),	length));
				String[] drpOffChgTrfEffDt =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_eff_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] drpOffChgTrfRmk =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_rmk".trim(),	length));
				String[] sCustCd =	(JSPUtil.getParameter(request, prefix +	"s_cust_cd".trim(),	length));
				String[] sTrfExptFlg =	(JSPUtil.getParameter(request, prefix +	"s_trf_expt_flg".trim(),	length));
				String[] sYdSfxCd =	(JSPUtil.getParameter(request, prefix +	"s_yd_sfx_cd".trim(),	length));
				String[] sFrmEffDt =	(JSPUtil.getParameter(request, prefix +	"s_frm_eff_dt".trim(),	length));
				String[] sCntCd =	(JSPUtil.getParameter(request, prefix +	"s_cnt_cd".trim(),	length));
				String[] polContiCd =	(JSPUtil.getParameter(request, prefix +	"pol_conti_cd".trim(),	length));
				String[] cntrRtnYdSfxCd =	(JSPUtil.getParameter(request, prefix +	"cntr_rtn_yd_sfx_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] spclCustSeq =	(JSPUtil.getParameter(request, prefix +	"spcl_cust_seq".trim(),	length));
				String[] drpOffChgTrfCfmFlg =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_cfm_flg".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] drpOffChgTrfExpFlg =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_exp_flg".trim(),	length));
				String[] drpOffChgTrfCntCd =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_cnt_cd".trim(),	length));
				String[] spclCustCntCd =	(JSPUtil.getParameter(request, prefix +	"spcl_cust_cnt_cd".trim(),	length));
				String[] deltFlg =	(JSPUtil.getParameter(request, prefix +	"delt_flg".trim(),	length));
				String[] drpOffChgTrfCfmUsrId =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_cfm_usr_id".trim(),	length));
				String[] drpOffChgTrfExpDt =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_exp_dt".trim(),	length));
				String[] drpOffChgTrfCfmDt =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_cfm_dt".trim(),	length));
				String[] drpOffChgTrfExptFlg =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_expt_flg".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] rfaNo =	(JSPUtil.getParameter(request, prefix +	"rfa_no".trim(),	length));
				String[] sTrfDivCd =	(JSPUtil.getParameter(request, prefix +	"s_trf_div_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] spclCustCntSeq =	(JSPUtil.getParameter(request, prefix +	"spcl_cust_cnt_seq".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] sOfcCd =	(JSPUtil.getParameter(request, prefix +	"s_ofc_cd".trim(),	length));
				String[] cntrRtnLocCd =	(JSPUtil.getParameter(request, prefix +	"cntr_rtn_loc_cd".trim(),	length));
				String[] drpOffChgTrfSeq =	(JSPUtil.getParameter(request, prefix +	"drp_off_chg_trf_seq".trim(),	length));
				String[] sToEffDt =	(JSPUtil.getParameter(request, prefix +	"s_to_eff_dt".trim(),	length));
				String[] chgCnt =	(JSPUtil.getParameter(request, prefix +	"chg_cnt".trim(),	length));
				String[] atchFileLnkCnt =	(JSPUtil.getParameter(request, prefix +	"atch_file_lnk_cnt".trim(),	length));
				String[] sNoType = (JSPUtil.getParameter(request, prefix +	"s_no_type".trim(),	length));
				String[] sNo = (JSPUtil.getParameter(request, prefix +	"s_no".trim(),	length));
				String[] custNm = (JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SearchDodTariffListVO();
						if ( sRtnLocCd[i] !=	null)
						model.setSRtnLocCd( sRtnLocCd[i]);
						if ( drpOffChgTrfDivCd[i] !=	null)
						model.setDrpOffChgTrfDivCd( drpOffChgTrfDivCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( spclCustNm[i] !=	null)
						model.setSpclCustNm( spclCustNm[i]);
						if ( drpOffChgTrfAmt[i] !=	null)
						model.setDrpOffChgTrfAmt( drpOffChgTrfAmt[i]);
						if ( drpOffChgTrfEffDt[i] !=	null)
						model.setDrpOffChgTrfEffDt( drpOffChgTrfEffDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( drpOffChgTrfRmk[i] !=	null)
						model.setDrpOffChgTrfRmk( drpOffChgTrfRmk[i]);
						if ( sCustCd[i] !=	null)
						model.setSCustCd( sCustCd[i]);
						if ( sTrfExptFlg[i] !=	null)
						model.setSTrfExptFlg( sTrfExptFlg[i]);
						if ( sYdSfxCd[i] !=	null)
						model.setSYdSfxCd( sYdSfxCd[i]);
						if ( sFrmEffDt[i] !=	null)
						model.setSFrmEffDt( sFrmEffDt[i]);
						if ( sCntCd[i] !=	null)
						model.setSCntCd( sCntCd[i]);
						if ( polContiCd[i] !=	null)
						model.setPolContiCd( polContiCd[i]);
						if ( cntrRtnYdSfxCd[i] !=	null)
						model.setCntrRtnYdSfxCd( cntrRtnYdSfxCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( spclCustSeq[i] !=	null)
						model.setSpclCustSeq( spclCustSeq[i]);
						if ( drpOffChgTrfCfmFlg[i] !=	null)
						model.setDrpOffChgTrfCfmFlg( drpOffChgTrfCfmFlg[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( drpOffChgTrfExpFlg[i] !=	null)
						model.setDrpOffChgTrfExpFlg( drpOffChgTrfExpFlg[i]);
						if ( drpOffChgTrfCntCd[i] !=	null)
						model.setDrpOffChgTrfCntCd( drpOffChgTrfCntCd[i]);
						if ( spclCustCntCd[i] !=	null)
						model.setSpclCustCntCd( spclCustCntCd[i]);
						if ( deltFlg[i] !=	null)
						model.setDeltFlg( deltFlg[i]);
						if ( drpOffChgTrfCfmUsrId[i] !=	null)
						model.setDrpOffChgTrfCfmUsrId( drpOffChgTrfCfmUsrId[i]);
						if ( drpOffChgTrfExpDt[i] !=	null)
						model.setDrpOffChgTrfExpDt( drpOffChgTrfExpDt[i]);
						if ( drpOffChgTrfCfmDt[i] !=	null)
						model.setDrpOffChgTrfCfmDt( drpOffChgTrfCfmDt[i]);
						if ( drpOffChgTrfExptFlg[i] !=	null)
						model.setDrpOffChgTrfExptFlg( drpOffChgTrfExptFlg[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( rfaNo[i] !=	null)
						model.setRfaNo( rfaNo[i]);
						if ( sTrfDivCd[i] !=	null)
						model.setSTrfDivCd( sTrfDivCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( spclCustCntSeq[i] !=	null)
						model.setSpclCustCntSeq( spclCustCntSeq[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( sOfcCd[i] !=	null)
						model.setSOfcCd( sOfcCd[i]);
						if ( cntrRtnLocCd[i] !=	null)
						model.setCntrRtnLocCd( cntrRtnLocCd[i]);
						if ( drpOffChgTrfSeq[i] !=	null)
						model.setDrpOffChgTrfSeq( drpOffChgTrfSeq[i]);
						if ( sToEffDt[i] !=	null)
						model.setSToEffDt( sToEffDt[i]);
						if ( chgCnt[i] !=	null)
						model.setChgCnt( chgCnt[i]);
						if ( atchFileLnkCnt[i] != null)
						model.setAtchFileLnkCnt( atchFileLnkCnt[i]);
						if ( sNoType[i] != null)
						model.setsNoType( sNoType[i]);
						if ( sNo[i] != null)
						model.setsNo( sNo[i]);
						if ( custNm[i] != null)
						model.setCustNm( custNm[i]);
						
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSearchDodTariffListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SearchDodTariffListVO[]
	 */
	public SearchDodTariffListVO[]	 getSearchDodTariffListVOs(){
		SearchDodTariffListVO[] vos = (SearchDodTariffListVO[])models.toArray(new	SearchDodTariffListVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.sRtnLocCd =	this.sRtnLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfDivCd =	this.drpOffChgTrfDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustNm =	this.spclCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfAmt =	this.drpOffChgTrfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfEffDt =	this.drpOffChgTrfEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfRmk =	this.drpOffChgTrfRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd =	this.sCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrfExptFlg =	this.sTrfExptFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sYdSfxCd =	this.sYdSfxCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sFrmEffDt =	this.sFrmEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCntCd =	this.sCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polContiCd =	this.polContiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdSfxCd =	this.cntrRtnYdSfxCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustSeq =	this.spclCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfCfmFlg =	this.drpOffChgTrfCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfExpFlg =	this.drpOffChgTrfExpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfCntCd =	this.drpOffChgTrfCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustCntCd =	this.spclCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg =	this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfCfmUsrId =	this.drpOffChgTrfCfmUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfExpDt =	this.drpOffChgTrfExpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfCfmDt =	this.drpOffChgTrfCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfExptFlg =	this.drpOffChgTrfExptFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo =	this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrfDivCd =	this.sTrfDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCustCntSeq =	this.spclCustCntSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sOfcCd =	this.sOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnLocCd =	this.cntrRtnLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.drpOffChgTrfSeq =	this.drpOffChgTrfSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sToEffDt =	this.sToEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCnt =	this.chgCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkCnt	=	this.atchFileLnkCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNoType	=	this.sNoType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNo	=	this.sNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm	=	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}