/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AGNCommRequestVO.java
 *@FileTitle : AGNCommRequestVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.11.02
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.11.02  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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
public class AGNCommRequestVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AGNCommRequestVO>  models =	new	ArrayList<AGNCommRequestVO>();


	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 acRlaneCd   =  null;
	/*	Column Info	*/
	private  String	 dateFm   =  null;
	/*	Column Info	*/
	private  String	 revDivCd   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 bkgStsCd   =  null;
	/*	Column Info	*/
	private  String	 bdrFlg   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 chfAmt   =  null;
	/*	Column Info	*/
	private  String	 xchRtAplyLvl   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 agnCd   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 crossAmt   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 creTm   =  null;
	/*	Column Info	*/
	private  String	 ddctSpclCmpnAmt   =  null;
	/*	Column Info	*/
	private  String	 dateDiv   =  null;
	/*	Column Info	*/
	private  String	 payIfAmt   =  null;
	/*	Column Info	*/
	private  String	 acStsCd   =  null;
	/*	Column Info	*/
	private  String	 cntrQty   =  null;
	/*	Column Info	*/
	private  String	 payXchRt   =  null;
	/*	Column Info	*/
	private  String	 brogAmt   =  null;
	/*	Column Info	*/
	private  String	 crntRevAmt   =  null;
	/*	Column Info	*/
	private  String	 brkgCrntRevAmt   =  null;
	/*	Column Info	*/
	private  String	 crsCrntRevAmt   =  null;
	/*	Column Info	*/
	private  String	 generalAmt   =  null;
	/*	Column Info	*/
	private  String	 ddctTrspAmt   =  null;
	/*	Column Info	*/
	private  String	 brkgDdctTrspAmt   =  null;
	/*	Column Info	*/
	private  String	 crsDdctTrspAmt   =  null;
	/*	Column Info	*/
	private  String	 commVvd   =  null;
	/*	Column Info	*/
	private  String	 ddctChgAmt   =  null;
	/*	Column Info	*/
	private  String	 brkgDdctChgAmt   =  null;
	/*	Column Info	*/
	private  String	 crsDdctChgAmt   =  null;
	/*	Column Info	*/
	private  String	 dateTo   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 ppdAmt   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 tsAmt   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 usdAmt   =  null;
	/*	Column Info	*/
	private  String	 acSeq   =  null;
	/*	Column Info	*/
	private  String	 postRevAmt   =  null;
	/*	Column Info	*/
	private  String	 brkgPostRevAmt   =  null;
	/*	Column Info	*/
	private  String	 crsPostRevAmt   =  null;
	/*	Column Info	*/
	private  String	 acProcDesc   =  null;
	/*	Column Info	*/
	private  String	 acOccrInfoCd   =  null;
	/*	Column Info	*/
	private  String	 vvdDiv   =  null;
	/*	Column Info	*/
	private  String	 revVvdCd   =  null;
	/*	Column Info	*/
	private  String	 trdCd   =  null;
	/*	Column Info	*/
	private  String	 subTrdCd   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 custLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 rqstFlg   =  null;
	/*	Column Info	*/
	private  String	 acTpCd   =  null;
	/*	Column Info	*/
	private  String	 ddctVipAmt   =  null;
	/*	Column Info	*/
	private  String	 brkgDdctVipAmt   =  null;
	/*	Column Info	*/
	private  String	 crsDdctVipAmt   =  null;
	/*	Column Info	*/
	private  String	 chgCommAmt   =  null;
	/*	Column Info	*/
	private  String	 chgCommFlg   =  null;
	/*	Column Info	*/
	private  String	 bkgOfcCd   =  null;
	/*	Column Info	*/
	private  String	 bkgPorCd   =  null;
	/*	Column Info	*/
	private  String	 bkgPolCd   =  null;
	/*	Column Info	*/
	private  String	 bkgPodCd   =  null;
	/*	Column Info	*/
	private  String	 bkgDelCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AGNCommRequestVO(){}

	public AGNCommRequestVO(String porCd,String acRlaneCd,String dateFm,String revDivCd,String currCd,String bkgStsCd,String bdrFlg,String creDt,String sailArrDt,String blNo,String chfAmt,String xchRtAplyLvl,String pagerows,String agnCd,String polCd,String ibflag,String crossAmt,String vvdCd,String usrId,String creTm,String ddctSpclCmpnAmt,String dateDiv,String payIfAmt,String acStsCd,String cntrQty,String payXchRt,String brogAmt,String crntRevAmt,String brkgCrntRevAmt,String crsCrntRevAmt,String generalAmt,String ddctTrspAmt,String brkgDdctTrspAmt,String crsDdctTrspAmt,String commVvd,String ddctChgAmt,String brkgDdctChgAmt,String crsDdctChgAmt,String dateTo,String delCd,String ppdAmt,String ioBndCd,String tsAmt,String arOfcCd,String podCd,String bkgNo,String usdAmt,String acSeq,String postRevAmt,String brkgPostRevAmt,String crsPostRevAmt,String acProcDesc,String acOccrInfoCd,String vvdDiv,String revVvdCd,String trdCd,String subTrdCd,String vndrSeq,String custLglEngNm,String custCntCd,String rqstFlg,String acTpCd,String ddctVipAmt,String brkgDdctVipAmt,String crsDdctVipAmt,String chgCommAmt,String chgCommFlg,String bkgOfcCd,String bkgPorCd,String bkgPolCd,String bkgPodCd,String bkgDelCd)	{
		this.porCd  = porCd ;
		this.acRlaneCd  = acRlaneCd ;
		this.dateFm  = dateFm ;
		this.revDivCd  = revDivCd ;
		this.currCd  = currCd ;
		this.bkgStsCd  = bkgStsCd ;
		this.bdrFlg  = bdrFlg ;
		this.creDt  = creDt ;
		this.sailArrDt  = sailArrDt ;
		this.blNo  = blNo ;
		this.chfAmt  = chfAmt ;
		this.xchRtAplyLvl  = xchRtAplyLvl ;
		this.pagerows  = pagerows ;
		this.agnCd  = agnCd ;
		this.polCd  = polCd ;
		this.ibflag  = ibflag ;
		this.crossAmt  = crossAmt ;
		this.vvdCd  = vvdCd ;
		this.usrId  = usrId ;
		this.creTm  = creTm ;
		this.ddctSpclCmpnAmt  = ddctSpclCmpnAmt ;
		this.dateDiv  = dateDiv ;
		this.payIfAmt  = payIfAmt ;
		this.acStsCd  = acStsCd ;
		this.cntrQty  = cntrQty ;
		this.payXchRt  = payXchRt ;
		this.brogAmt  = brogAmt ;
		this.crntRevAmt  = crntRevAmt ;
		this.brkgCrntRevAmt  = brkgCrntRevAmt ;
		this.crsCrntRevAmt  = crsCrntRevAmt ;
		this.generalAmt  = generalAmt ;
		this.ddctTrspAmt  = ddctTrspAmt ;
		this.brkgDdctTrspAmt  = brkgDdctTrspAmt ;
		this.crsDdctTrspAmt  = crsDdctTrspAmt ;
		this.commVvd  = commVvd ;
		this.ddctChgAmt  = ddctChgAmt ;
		this.brkgDdctChgAmt  = brkgDdctChgAmt ;
		this.crsDdctChgAmt  = crsDdctChgAmt ;
		this.dateTo  = dateTo ;
		this.delCd  = delCd ;
		this.ppdAmt  = ppdAmt ;
		this.ioBndCd  = ioBndCd ;
		this.tsAmt  = tsAmt ;
		this.arOfcCd  = arOfcCd ;
		this.podCd  = podCd ;
		this.bkgNo  = bkgNo ;
		this.usdAmt  = usdAmt ;
		this.acSeq  = acSeq ;
		this.postRevAmt  = postRevAmt ;
		this.brkgPostRevAmt  = brkgPostRevAmt ;
		this.crsPostRevAmt  = crsPostRevAmt ;
		this.acProcDesc  = acProcDesc ;
		this.acOccrInfoCd  = acOccrInfoCd ;
		this.vvdDiv  = vvdDiv ;
		this.revVvdCd  = revVvdCd ;
		this.trdCd  = trdCd ;
		this.subTrdCd  = subTrdCd ;
		this.vndrSeq  = vndrSeq ;
		this.custLglEngNm  = custLglEngNm ;
		this.custCntCd  = custCntCd ;
		this.rqstFlg  = rqstFlg ;
		this.acTpCd  = acTpCd ;
		this.ddctVipAmt  = ddctVipAmt ;
		this.brkgDdctVipAmt  = brkgDdctVipAmt ;
		this.crsDdctVipAmt  = crsDdctVipAmt ;
		this.chgCommAmt  = chgCommAmt ;
		this.chgCommFlg  = chgCommFlg ;
		this.bkgOfcCd  = bkgOfcCd ;
		this.bkgPorCd  = bkgPorCd ;
		this.bkgPolCd  = bkgPolCd ;
		this.bkgPodCd  = bkgPodCd ;
		this.bkgDelCd  = bkgDelCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("ac_rlane_cd", getAcRlaneCd());		
		this.hashColumns.put("date_fm", getDateFm());		
		this.hashColumns.put("rev_div_cd", getRevDivCd());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());		
		this.hashColumns.put("bdr_flg", getBdrFlg());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("chf_amt", getChfAmt());		
		this.hashColumns.put("xch_rt_aply_lvl", getXchRtAplyLvl());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("agn_cd", getAgnCd());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cross_amt", getCrossAmt());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("cre_tm", getCreTm());		
		this.hashColumns.put("ddct_spcl_cmpn_amt", getDdctSpclCmpnAmt());		
		this.hashColumns.put("date_div", getDateDiv());		
		this.hashColumns.put("pay_if_amt", getPayIfAmt());		
		this.hashColumns.put("ac_sts_cd", getAcStsCd());		
		this.hashColumns.put("cntr_qty", getCntrQty());		
		this.hashColumns.put("pay_xch_rt", getPayXchRt());		
		this.hashColumns.put("brog_amt", getBrogAmt());		
		this.hashColumns.put("crnt_rev_amt", getCrntRevAmt());		
		this.hashColumns.put("brkg_crnt_rev_amt", getBrkgCrntRevAmt());		
		this.hashColumns.put("crs_crnt_rev_amt", getCrsCrntRevAmt());		
		this.hashColumns.put("general_amt", getGeneralAmt());		
		this.hashColumns.put("ddct_trsp_amt", getDdctTrspAmt());		
		this.hashColumns.put("brkg_ddct_trsp_amt", getBrkgDdctTrspAmt());		
		this.hashColumns.put("crs_ddct_trsp_amt", getCrsDdctTrspAmt());		
		this.hashColumns.put("comm_vvd", getCommVvd());		
		this.hashColumns.put("ddct_chg_amt", getDdctChgAmt());		
		this.hashColumns.put("brkg_ddct_chg_amt", getBrkgDdctChgAmt());		
		this.hashColumns.put("crs_ddct_chg_amt", getCrsDdctChgAmt());		
		this.hashColumns.put("date_to", getDateTo());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("ppd_amt", getPpdAmt());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("ts_amt", getTsAmt());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("usd_amt", getUsdAmt());		
		this.hashColumns.put("ac_seq", getAcSeq());		
		this.hashColumns.put("post_rev_amt", getPostRevAmt());		
		this.hashColumns.put("brkg_post_rev_amt", getBrkgPostRevAmt());		
		this.hashColumns.put("crs_post_rev_amt", getCrsPostRevAmt());		
		this.hashColumns.put("ac_proc_desc", getAcProcDesc());		
		this.hashColumns.put("ac_occr_info_cd", getAcOccrInfoCd());		
		this.hashColumns.put("vvd_div", getVvdDiv());		
		this.hashColumns.put("rev_vvd_cd", getRevVvdCd());		
		this.hashColumns.put("trd_cd", getTrdCd());		
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("rqst_flg", getRqstFlg());		
		this.hashColumns.put("ac_tp_cd", getAcTpCd());		
		this.hashColumns.put("ddct_vip_amt", getDdctVipAmt());		
		this.hashColumns.put("brkg_ddct_vip_amt", getBrkgDdctVipAmt());		
		this.hashColumns.put("crs_ddct_vip_amt", getCrsDdctVipAmt());		
		this.hashColumns.put("chg_comm_amt", getChgCommAmt());		
		this.hashColumns.put("chg_comm_flg", getChgCommFlg());		
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());		
		this.hashColumns.put("bkg_por_cd", getBkgPorCd());		
		this.hashColumns.put("bkg_pol_cd", getBkgPolCd());		
		this.hashColumns.put("bkg_pod_cd", getBkgPodCd());		
		this.hashColumns.put("bkg_del_cd", getBkgDelCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("ac_rlane_cd", "acRlaneCd");
		this.hashFields.put("date_fm", "dateFm");
		this.hashFields.put("rev_div_cd", "revDivCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("chf_amt", "chfAmt");
		this.hashFields.put("xch_rt_aply_lvl", "xchRtAplyLvl");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cross_amt", "crossAmt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("cre_tm", "creTm");
		this.hashFields.put("ddct_spcl_cmpn_amt", "ddctSpclCmpnAmt");
		this.hashFields.put("date_div", "dateDiv");
		this.hashFields.put("pay_if_amt", "payIfAmt");
		this.hashFields.put("ac_sts_cd", "acStsCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("pay_xch_rt", "payXchRt");
		this.hashFields.put("brog_amt", "brogAmt");
		this.hashFields.put("crnt_rev_amt", "crntRevAmt");
		this.hashFields.put("brkg_crnt_rev_amt", "brkgCrntRevAmt");
		this.hashFields.put("crs_crnt_rev_amt", "crsCrntRevAmt");
		this.hashFields.put("general_amt", "generalAmt");
		this.hashFields.put("ddct_trsp_amt", "ddctTrspAmt");
		this.hashFields.put("brkg_ddct_trsp_amt", "brkgDdctTrspAmt");
		this.hashFields.put("crs_ddct_trsp_amt", "crsDdctTrspAmt");
		this.hashFields.put("comm_vvd", "commVvd");
		this.hashFields.put("ddct_chg_amt", "ddctChgAmt");
		this.hashFields.put("brkg_ddct_chg_amt", "brkgDdctChgAmt");
		this.hashFields.put("crs_ddct_chg_amt", "crsDdctChgAmt");
		this.hashFields.put("date_to", "dateTo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ppd_amt", "ppdAmt");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("ts_amt", "tsAmt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("ac_seq", "acSeq");
		this.hashFields.put("post_rev_amt", "postRevAmt");
		this.hashFields.put("brkg_post_rev_amt", "brkgPostRevAmt");
		this.hashFields.put("crs_post_rev_amt", "crsPostRevAmt");
		this.hashFields.put("ac_proc_desc", "acProcDesc");
		this.hashFields.put("ac_occr_info_cd", "acOccrInfoCd");
		this.hashFields.put("vvd_div", "vvdDiv");
		this.hashFields.put("rev_vvd_cd", "revVvdCd");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("rqst_flg", "rqstFlg");
		this.hashFields.put("ac_tp_cd", "acTpCd");
		this.hashFields.put("ddct_vip_amt", "ddctVipAmt");
		this.hashFields.put("brkg_ddct_vip_amt", "brkgDdctVipAmt");
		this.hashFields.put("crs_ddct_vip_amt", "crsDdctVipAmt");
		this.hashFields.put("chg_comm_amt", "chgCommAmt");
		this.hashFields.put("chg_comm_flg", "chgCommFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bkg_por_cd", "bkgPorCd");
		this.hashFields.put("bkg_pol_cd", "bkgPolCd");
		this.hashFields.put("bkg_pod_cd", "bkgPodCd");
		this.hashFields.put("bkg_del_cd", "bkgDelCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  acRlaneCd
	*/
	public void	setAcRlaneCd( String	acRlaneCd ) {
		this.acRlaneCd =	acRlaneCd;
	}
 
	/**
	 * Column Info
	 * @return	acRlaneCd
	 */
	 public	 String	getAcRlaneCd() {
		 return	this.acRlaneCd;
	 } 
 	/**
	* Column Info
	* @param  dateFm
	*/
	public void	setDateFm( String	dateFm ) {
		this.dateFm =	dateFm;
	}
 
	/**
	 * Column Info
	 * @return	dateFm
	 */
	 public	 String	getDateFm() {
		 return	this.dateFm;
	 } 
 	/**
	* Column Info
	* @param  revDivCd
	*/
	public void	setRevDivCd( String	revDivCd ) {
		this.revDivCd =	revDivCd;
	}
 
	/**
	 * Column Info
	 * @return	revDivCd
	 */
	 public	 String	getRevDivCd() {
		 return	this.revDivCd;
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
	 public	 String	getCurrCd() {
		 return	this.currCd;
	 } 
 	/**
	* Column Info
	* @param  bkgStsCd
	*/
	public void	setBkgStsCd( String	bkgStsCd ) {
		this.bkgStsCd =	bkgStsCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgStsCd
	 */
	 public	 String	getBkgStsCd() {
		 return	this.bkgStsCd;
	 } 
 	/**
	* Column Info
	* @param  bdrFlg
	*/
	public void	setBdrFlg( String	bdrFlg ) {
		this.bdrFlg =	bdrFlg;
	}
 
	/**
	 * Column Info
	 * @return	bdrFlg
	 */
	 public	 String	getBdrFlg() {
		 return	this.bdrFlg;
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
	* @param  sailArrDt
	*/
	public void	setSailArrDt( String	sailArrDt ) {
		this.sailArrDt =	sailArrDt;
	}
 
	/**
	 * Column Info
	 * @return	sailArrDt
	 */
	 public	 String	getSailArrDt() {
		 return	this.sailArrDt;
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
	* @param  chfAmt
	*/
	public void	setChfAmt( String	chfAmt ) {
		this.chfAmt =	chfAmt;
	}
 
	/**
	 * Column Info
	 * @return	chfAmt
	 */
	 public	 String	getChfAmt() {
		 return	this.chfAmt;
	 } 
 	/**
	* Column Info
	* @param  xchRtAplyLvl
	*/
	public void	setXchRtAplyLvl( String	xchRtAplyLvl ) {
		this.xchRtAplyLvl =	xchRtAplyLvl;
	}
 
	/**
	 * Column Info
	 * @return	xchRtAplyLvl
	 */
	 public	 String	getXchRtAplyLvl() {
		 return	this.xchRtAplyLvl;
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
	* @param  agnCd
	*/
	public void	setAgnCd( String	agnCd ) {
		this.agnCd =	agnCd;
	}
 
	/**
	 * Column Info
	 * @return	agnCd
	 */
	 public	 String	getAgnCd() {
		 return	this.agnCd;
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
	* @param  crossAmt
	*/
	public void	setCrossAmt( String	crossAmt ) {
		this.crossAmt =	crossAmt;
	}
 
	/**
	 * Column Info
	 * @return	crossAmt
	 */
	 public	 String	getCrossAmt() {
		 return	this.crossAmt;
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
	* @param  usrId
	*/
	public void	setUsrId( String	usrId ) {
		this.usrId =	usrId;
	}
 
	/**
	 * Column Info
	 * @return	usrId
	 */
	 public	 String	getUsrId() {
		 return	this.usrId;
	 } 
 	/**
	* Column Info
	* @param  creTm
	*/
	public void	setCreTm( String	creTm ) {
		this.creTm =	creTm;
	}
 
	/**
	 * Column Info
	 * @return	creTm
	 */
	 public	 String	getCreTm() {
		 return	this.creTm;
	 } 
 	/**
	* Column Info
	* @param  ddctSpclCmpnAmt
	*/
	public void	setDdctSpclCmpnAmt( String	ddctSpclCmpnAmt ) {
		this.ddctSpclCmpnAmt =	ddctSpclCmpnAmt;
	}
 
	/**
	 * Column Info
	 * @return	ddctSpclCmpnAmt
	 */
	 public	 String	getDdctSpclCmpnAmt() {
		 return	this.ddctSpclCmpnAmt;
	 } 
 	/**
	* Column Info
	* @param  dateDiv
	*/
	public void	setDateDiv( String	dateDiv ) {
		this.dateDiv =	dateDiv;
	}
 
	/**
	 * Column Info
	 * @return	dateDiv
	 */
	 public	 String	getDateDiv() {
		 return	this.dateDiv;
	 } 
 	/**
	* Column Info
	* @param  payIfAmt
	*/
	public void	setPayIfAmt( String	payIfAmt ) {
		this.payIfAmt =	payIfAmt;
	}
 
	/**
	 * Column Info
	 * @return	payIfAmt
	 */
	 public	 String	getPayIfAmt() {
		 return	this.payIfAmt;
	 } 
 	/**
	* Column Info
	* @param  acStsCd
	*/
	public void	setAcStsCd( String	acStsCd ) {
		this.acStsCd =	acStsCd;
	}
 
	/**
	 * Column Info
	 * @return	acStsCd
	 */
	 public	 String	getAcStsCd() {
		 return	this.acStsCd;
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
	* @param  payXchRt
	*/
	public void	setPayXchRt( String	payXchRt ) {
		this.payXchRt =	payXchRt;
	}
 
	/**
	 * Column Info
	 * @return	payXchRt
	 */
	 public	 String	getPayXchRt() {
		 return	this.payXchRt;
	 } 
 	/**
	* Column Info
	* @param  brogAmt
	*/
	public void	setBrogAmt( String	brogAmt ) {
		this.brogAmt =	brogAmt;
	}
 
	/**
	 * Column Info
	 * @return	brogAmt
	 */
	 public	 String	getBrogAmt() {
		 return	this.brogAmt;
	 } 
 	/**
	* Column Info
	* @param  crntRevAmt
	*/
	public void	setCrntRevAmt( String	crntRevAmt ) {
		this.crntRevAmt =	crntRevAmt;
	}
 
	/**
	 * Column Info
	 * @return	crntRevAmt
	 */
	 public	 String	getCrntRevAmt() {
		 return	this.crntRevAmt;
	 } 
 	/**
	* Column Info
	* @param  brkgCrntRevAmt
	*/
	public void	setBrkgCrntRevAmt( String	brkgCrntRevAmt ) {
		this.brkgCrntRevAmt =	brkgCrntRevAmt;
	}
 
	/**
	 * Column Info
	 * @return	brkgCrntRevAmt
	 */
	 public	 String	getBrkgCrntRevAmt() {
		 return	this.brkgCrntRevAmt;
	 } 
 	/**
	* Column Info
	* @param  crsCrntRevAmt
	*/
	public void	setCrsCrntRevAmt( String	crsCrntRevAmt ) {
		this.crsCrntRevAmt =	crsCrntRevAmt;
	}
 
	/**
	 * Column Info
	 * @return	crsCrntRevAmt
	 */
	 public	 String	getCrsCrntRevAmt() {
		 return	this.crsCrntRevAmt;
	 } 
 	/**
	* Column Info
	* @param  generalAmt
	*/
	public void	setGeneralAmt( String	generalAmt ) {
		this.generalAmt =	generalAmt;
	}
 
	/**
	 * Column Info
	 * @return	generalAmt
	 */
	 public	 String	getGeneralAmt() {
		 return	this.generalAmt;
	 } 
 	/**
	* Column Info
	* @param  ddctTrspAmt
	*/
	public void	setDdctTrspAmt( String	ddctTrspAmt ) {
		this.ddctTrspAmt =	ddctTrspAmt;
	}
 
	/**
	 * Column Info
	 * @return	ddctTrspAmt
	 */
	 public	 String	getDdctTrspAmt() {
		 return	this.ddctTrspAmt;
	 } 
 	/**
	* Column Info
	* @param  brkgDdctTrspAmt
	*/
	public void	setBrkgDdctTrspAmt( String	brkgDdctTrspAmt ) {
		this.brkgDdctTrspAmt =	brkgDdctTrspAmt;
	}
 
	/**
	 * Column Info
	 * @return	brkgDdctTrspAmt
	 */
	 public	 String	getBrkgDdctTrspAmt() {
		 return	this.brkgDdctTrspAmt;
	 } 
 	/**
	* Column Info
	* @param  crsDdctTrspAmt
	*/
	public void	setCrsDdctTrspAmt( String	crsDdctTrspAmt ) {
		this.crsDdctTrspAmt =	crsDdctTrspAmt;
	}
 
	/**
	 * Column Info
	 * @return	crsDdctTrspAmt
	 */
	 public	 String	getCrsDdctTrspAmt() {
		 return	this.crsDdctTrspAmt;
	 } 
 	/**
	* Column Info
	* @param  commVvd
	*/
	public void	setCommVvd( String	commVvd ) {
		this.commVvd =	commVvd;
	}
 
	/**
	 * Column Info
	 * @return	commVvd
	 */
	 public	 String	getCommVvd() {
		 return	this.commVvd;
	 } 
 	/**
	* Column Info
	* @param  ddctChgAmt
	*/
	public void	setDdctChgAmt( String	ddctChgAmt ) {
		this.ddctChgAmt =	ddctChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	ddctChgAmt
	 */
	 public	 String	getDdctChgAmt() {
		 return	this.ddctChgAmt;
	 } 
 	/**
	* Column Info
	* @param  brkgDdctChgAmt
	*/
	public void	setBrkgDdctChgAmt( String	brkgDdctChgAmt ) {
		this.brkgDdctChgAmt =	brkgDdctChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	brkgDdctChgAmt
	 */
	 public	 String	getBrkgDdctChgAmt() {
		 return	this.brkgDdctChgAmt;
	 } 
 	/**
	* Column Info
	* @param  crsDdctChgAmt
	*/
	public void	setCrsDdctChgAmt( String	crsDdctChgAmt ) {
		this.crsDdctChgAmt =	crsDdctChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	crsDdctChgAmt
	 */
	 public	 String	getCrsDdctChgAmt() {
		 return	this.crsDdctChgAmt;
	 } 
 	/**
	* Column Info
	* @param  dateTo
	*/
	public void	setDateTo( String	dateTo ) {
		this.dateTo =	dateTo;
	}
 
	/**
	 * Column Info
	 * @return	dateTo
	 */
	 public	 String	getDateTo() {
		 return	this.dateTo;
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
	* @param  ppdAmt
	*/
	public void	setPpdAmt( String	ppdAmt ) {
		this.ppdAmt =	ppdAmt;
	}
 
	/**
	 * Column Info
	 * @return	ppdAmt
	 */
	 public	 String	getPpdAmt() {
		 return	this.ppdAmt;
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
	* @param  tsAmt
	*/
	public void	setTsAmt( String	tsAmt ) {
		this.tsAmt =	tsAmt;
	}
 
	/**
	 * Column Info
	 * @return	tsAmt
	 */
	 public	 String	getTsAmt() {
		 return	this.tsAmt;
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
	* @param  usdAmt
	*/
	public void	setUsdAmt( String	usdAmt ) {
		this.usdAmt =	usdAmt;
	}
 
	/**
	 * Column Info
	 * @return	usdAmt
	 */
	 public	 String	getUsdAmt() {
		 return	this.usdAmt;
	 } 
 	/**
	* Column Info
	* @param  acSeq
	*/
	public void	setAcSeq( String	acSeq ) {
		this.acSeq =	acSeq;
	}
 
	/**
	 * Column Info
	 * @return	acSeq
	 */
	 public	 String	getAcSeq() {
		 return	this.acSeq;
	 } 
 	/**
	* Column Info
	* @param  postRevAmt
	*/
	public void	setPostRevAmt( String	postRevAmt ) {
		this.postRevAmt =	postRevAmt;
	}
 
	/**
	 * Column Info
	 * @return	postRevAmt
	 */
	 public	 String	getPostRevAmt() {
		 return	this.postRevAmt;
	 } 
 	/**
	* Column Info
	* @param  brkgPostRevAmt
	*/
	public void	setBrkgPostRevAmt( String	brkgPostRevAmt ) {
		this.brkgPostRevAmt =	brkgPostRevAmt;
	}
 
	/**
	 * Column Info
	 * @return	brkgPostRevAmt
	 */
	 public	 String	getBrkgPostRevAmt() {
		 return	this.brkgPostRevAmt;
	 } 
 	/**
	* Column Info
	* @param  crsPostRevAmt
	*/
	public void	setCrsPostRevAmt( String	crsPostRevAmt ) {
		this.crsPostRevAmt =	crsPostRevAmt;
	}
 
	/**
	 * Column Info
	 * @return	crsPostRevAmt
	 */
	 public	 String	getCrsPostRevAmt() {
		 return	this.crsPostRevAmt;
	 } 
 	/**
	* Column Info
	* @param  acProcDesc
	*/
	public void	setAcProcDesc( String	acProcDesc ) {
		this.acProcDesc =	acProcDesc;
	}
 
	/**
	 * Column Info
	 * @return	acProcDesc
	 */
	 public	 String	getAcProcDesc() {
		 return	this.acProcDesc;
	 } 
 	/**
	* Column Info
	* @param  acOccrInfoCd
	*/
	public void	setAcOccrInfoCd( String	acOccrInfoCd ) {
		this.acOccrInfoCd =	acOccrInfoCd;
	}
 
	/**
	 * Column Info
	 * @return	acOccrInfoCd
	 */
	 public	 String	getAcOccrInfoCd() {
		 return	this.acOccrInfoCd;
	 } 
 	/**
	* Column Info
	* @param  vvdDiv
	*/
	public void	setVvdDiv( String	vvdDiv ) {
		this.vvdDiv =	vvdDiv;
	}
 
	/**
	 * Column Info
	 * @return	vvdDiv
	 */
	 public	 String	getVvdDiv() {
		 return	this.vvdDiv;
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
	* @param  trdCd
	*/
	public void	setTrdCd( String	trdCd ) {
		this.trdCd =	trdCd;
	}
 
	/**
	 * Column Info
	 * @return	trdCd
	 */
	 public	 String	getTrdCd() {
		 return	this.trdCd;
	 } 
 	/**
	* Column Info
	* @param  subTrdCd
	*/
	public void	setSubTrdCd( String	subTrdCd ) {
		this.subTrdCd =	subTrdCd;
	}
 
	/**
	 * Column Info
	 * @return	subTrdCd
	 */
	 public	 String	getSubTrdCd() {
		 return	this.subTrdCd;
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
	* @param  custLglEngNm
	*/
	public void	setCustLglEngNm( String	custLglEngNm ) {
		this.custLglEngNm =	custLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	custLglEngNm
	 */
	 public	 String	getCustLglEngNm() {
		 return	this.custLglEngNm;
	 } 
 	/**
	* Column Info
	* @param  custCntCd
	*/
	public void	setCustCntCd( String	custCntCd ) {
		this.custCntCd =	custCntCd;
	}
 
	/**
	 * Column Info
	 * @return	custCntCd
	 */
	 public	 String	getCustCntCd() {
		 return	this.custCntCd;
	 } 
 	/**
	* Column Info
	* @param  rqstFlg
	*/
	public void	setRqstFlg( String	rqstFlg ) {
		this.rqstFlg =	rqstFlg;
	}
 
	/**
	 * Column Info
	 * @return	rqstFlg
	 */
	 public	 String	getRqstFlg() {
		 return	this.rqstFlg;
	 } 
 	/**
	* Column Info
	* @param  acTpCd
	*/
	public void	setAcTpCd( String	acTpCd ) {
		this.acTpCd =	acTpCd;
	}
 
	/**
	 * Column Info
	 * @return	acTpCd
	 */
	 public	 String	getAcTpCd() {
		 return	this.acTpCd;
	 } 
 	/**
	* Column Info
	* @param  ddctVipAmt
	*/
	public void	setDdctVipAmt( String	ddctVipAmt ) {
		this.ddctVipAmt =	ddctVipAmt;
	}
 
	/**
	 * Column Info
	 * @return	ddctVipAmt
	 */
	 public	 String	getDdctVipAmt() {
		 return	this.ddctVipAmt;
	 } 
 	/**
	* Column Info
	* @param  brkgDdctVipAmt
	*/
	public void	setBrkgDdctVipAmt( String	brkgDdctVipAmt ) {
		this.brkgDdctVipAmt =	brkgDdctVipAmt;
	}
 
	/**
	 * Column Info
	 * @return	brkgDdctVipAmt
	 */
	 public	 String	getBrkgDdctVipAmt() {
		 return	this.brkgDdctVipAmt;
	 } 
 	/**
	* Column Info
	* @param  crsDdctVipAmt
	*/
	public void	setCrsDdctVipAmt( String	crsDdctVipAmt ) {
		this.crsDdctVipAmt =	crsDdctVipAmt;
	}
 
	/**
	 * Column Info
	 * @return	crsDdctVipAmt
	 */
	 public	 String	getCrsDdctVipAmt() {
		 return	this.crsDdctVipAmt;
	 } 
 	/**
	* Column Info
	* @param  chgCommAmt
	*/
	public void	setChgCommAmt( String	chgCommAmt ) {
		this.chgCommAmt =	chgCommAmt;
	}
 
	/**
	 * Column Info
	 * @return	chgCommAmt
	 */
	 public	 String	getChgCommAmt() {
		 return	this.chgCommAmt;
	 } 
 	/**
	* Column Info
	* @param  chgCommFlg
	*/
	public void	setChgCommFlg( String	chgCommFlg ) {
		this.chgCommFlg =	chgCommFlg;
	}
 
	/**
	 * Column Info
	 * @return	chgCommFlg
	 */
	 public	 String	getChgCommFlg() {
		 return	this.chgCommFlg;
	 } 
 	/**
	* Column Info
	* @param  bkgOfcCd
	*/
	public void	setBkgOfcCd( String	bkgOfcCd ) {
		this.bkgOfcCd =	bkgOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgOfcCd
	 */
	 public	 String	getBkgOfcCd() {
		 return	this.bkgOfcCd;
	 } 
 	/**
	* Column Info
	* @param  bkgPorCd
	*/
	public void	setBkgPorCd( String	bkgPorCd ) {
		this.bkgPorCd =	bkgPorCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgPorCd
	 */
	 public	 String	getBkgPorCd() {
		 return	this.bkgPorCd;
	 } 
 	/**
	* Column Info
	* @param  bkgPolCd
	*/
	public void	setBkgPolCd( String	bkgPolCd ) {
		this.bkgPolCd =	bkgPolCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgPolCd
	 */
	 public	 String	getBkgPolCd() {
		 return	this.bkgPolCd;
	 } 
 	/**
	* Column Info
	* @param  bkgPodCd
	*/
	public void	setBkgPodCd( String	bkgPodCd ) {
		this.bkgPodCd =	bkgPodCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgPodCd
	 */
	 public	 String	getBkgPodCd() {
		 return	this.bkgPodCd;
	 } 
 	/**
	* Column Info
	* @param  bkgDelCd
	*/
	public void	setBkgDelCd( String	bkgDelCd ) {
		this.bkgDelCd =	bkgDelCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgDelCd
	 */
	 public	 String	getBkgDelCd() {
		 return	this.bkgDelCd;
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
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setAcRlaneCd(JSPUtil.getParameter(request,	prefix + "ac_rlane_cd", ""));
		setDateFm(JSPUtil.getParameter(request,	prefix + "date_fm", ""));
		setRevDivCd(JSPUtil.getParameter(request,	prefix + "rev_div_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request,	prefix + "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request,	prefix + "bdr_flg", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setChfAmt(JSPUtil.getParameter(request,	prefix + "chf_amt", ""));
		setXchRtAplyLvl(JSPUtil.getParameter(request,	prefix + "xch_rt_aply_lvl", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAgnCd(JSPUtil.getParameter(request,	prefix + "agn_cd", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCrossAmt(JSPUtil.getParameter(request,	prefix + "cross_amt", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setCreTm(JSPUtil.getParameter(request,	prefix + "cre_tm", ""));
		setDdctSpclCmpnAmt(JSPUtil.getParameter(request,	prefix + "ddct_spcl_cmpn_amt", ""));
		setDateDiv(JSPUtil.getParameter(request,	prefix + "date_div", ""));
		setPayIfAmt(JSPUtil.getParameter(request,	prefix + "pay_if_amt", ""));
		setAcStsCd(JSPUtil.getParameter(request,	prefix + "ac_sts_cd", ""));
		setCntrQty(JSPUtil.getParameter(request,	prefix + "cntr_qty", ""));
		setPayXchRt(JSPUtil.getParameter(request,	prefix + "pay_xch_rt", ""));
		setBrogAmt(JSPUtil.getParameter(request,	prefix + "brog_amt", ""));
		setCrntRevAmt(JSPUtil.getParameter(request,	prefix + "crnt_rev_amt", ""));
		setBrkgCrntRevAmt(JSPUtil.getParameter(request,	prefix + "brkg_crnt_rev_amt", ""));
		setCrsCrntRevAmt(JSPUtil.getParameter(request,	prefix + "crs_crnt_rev_amt", ""));
		setGeneralAmt(JSPUtil.getParameter(request,	prefix + "general_amt", ""));
		setDdctTrspAmt(JSPUtil.getParameter(request,	prefix + "ddct_trsp_amt", ""));
		setBrkgDdctTrspAmt(JSPUtil.getParameter(request,	prefix + "brkg_ddct_trsp_amt", ""));
		setCrsDdctTrspAmt(JSPUtil.getParameter(request,	prefix + "crs_ddct_trsp_amt", ""));
		setCommVvd(JSPUtil.getParameter(request,	prefix + "comm_vvd", ""));
		setDdctChgAmt(JSPUtil.getParameter(request,	prefix + "ddct_chg_amt", ""));
		setBrkgDdctChgAmt(JSPUtil.getParameter(request,	prefix + "brkg_ddct_chg_amt", ""));
		setCrsDdctChgAmt(JSPUtil.getParameter(request,	prefix + "crs_ddct_chg_amt", ""));
		setDateTo(JSPUtil.getParameter(request,	prefix + "date_to", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setPpdAmt(JSPUtil.getParameter(request,	prefix + "ppd_amt", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setTsAmt(JSPUtil.getParameter(request,	prefix + "ts_amt", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setUsdAmt(JSPUtil.getParameter(request,	prefix + "usd_amt", ""));
		setAcSeq(JSPUtil.getParameter(request,	prefix + "ac_seq", ""));
		setPostRevAmt(JSPUtil.getParameter(request,	prefix + "post_rev_amt", ""));
		setBrkgPostRevAmt(JSPUtil.getParameter(request,	prefix + "brkg_post_rev_amt", ""));
		setCrsPostRevAmt(JSPUtil.getParameter(request,	prefix + "crs_post_rev_amt", ""));
		setAcProcDesc(JSPUtil.getParameter(request,	prefix + "ac_proc_desc", ""));
		setAcOccrInfoCd(JSPUtil.getParameter(request,	prefix + "ac_occr_info_cd", ""));
		setVvdDiv(JSPUtil.getParameter(request,	prefix + "vvd_div", ""));
		setRevVvdCd(JSPUtil.getParameter(request,	prefix + "rev_vvd_cd", ""));
		setTrdCd(JSPUtil.getParameter(request,	prefix + "trd_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request,	prefix + "sub_trd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setCustLglEngNm(JSPUtil.getParameter(request,	prefix + "cust_lgl_eng_nm", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setRqstFlg(JSPUtil.getParameter(request,	prefix + "rqst_flg", ""));
		setAcTpCd(JSPUtil.getParameter(request,	prefix + "ac_tp_cd", ""));
		setDdctVipAmt(JSPUtil.getParameter(request,	prefix + "ddct_vip_amt", ""));
		setBrkgDdctVipAmt(JSPUtil.getParameter(request,	prefix + "brkg_ddct_vip_amt", ""));
		setCrsDdctVipAmt(JSPUtil.getParameter(request,	prefix + "crs_ddct_vip_amt", ""));
		setChgCommAmt(JSPUtil.getParameter(request,	prefix + "chg_comm_amt", ""));
		setChgCommFlg(JSPUtil.getParameter(request,	prefix + "chg_comm_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request,	prefix + "bkg_ofc_cd", ""));
		setBkgPorCd(JSPUtil.getParameter(request,	prefix + "bkg_por_cd", ""));
		setBkgPolCd(JSPUtil.getParameter(request,	prefix + "bkg_pol_cd", ""));
		setBkgPodCd(JSPUtil.getParameter(request,	prefix + "bkg_pod_cd", ""));
		setBkgDelCd(JSPUtil.getParameter(request,	prefix + "bkg_del_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AGNCommRequestVO[]
	 */
	public AGNCommRequestVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AGNCommRequestVO[]
	 */
	public AGNCommRequestVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AGNCommRequestVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] acRlaneCd =	(JSPUtil.getParameter(request, prefix +	"ac_rlane_cd".trim(),	length));
				String[] dateFm =	(JSPUtil.getParameter(request, prefix +	"date_fm".trim(),	length));
				String[] revDivCd =	(JSPUtil.getParameter(request, prefix +	"rev_div_cd".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] bkgStsCd =	(JSPUtil.getParameter(request, prefix +	"bkg_sts_cd".trim(),	length));
				String[] bdrFlg =	(JSPUtil.getParameter(request, prefix +	"bdr_flg".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] chfAmt =	(JSPUtil.getParameter(request, prefix +	"chf_amt".trim(),	length));
				String[] xchRtAplyLvl =	(JSPUtil.getParameter(request, prefix +	"xch_rt_aply_lvl".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] agnCd =	(JSPUtil.getParameter(request, prefix +	"agn_cd".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] crossAmt =	(JSPUtil.getParameter(request, prefix +	"cross_amt".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] creTm =	(JSPUtil.getParameter(request, prefix +	"cre_tm".trim(),	length));
				String[] ddctSpclCmpnAmt =	(JSPUtil.getParameter(request, prefix +	"ddct_spcl_cmpn_amt".trim(),	length));
				String[] dateDiv =	(JSPUtil.getParameter(request, prefix +	"date_div".trim(),	length));
				String[] payIfAmt =	(JSPUtil.getParameter(request, prefix +	"pay_if_amt".trim(),	length));
				String[] acStsCd =	(JSPUtil.getParameter(request, prefix +	"ac_sts_cd".trim(),	length));
				String[] cntrQty =	(JSPUtil.getParameter(request, prefix +	"cntr_qty".trim(),	length));
				String[] payXchRt =	(JSPUtil.getParameter(request, prefix +	"pay_xch_rt".trim(),	length));
				String[] brogAmt =	(JSPUtil.getParameter(request, prefix +	"brog_amt".trim(),	length));
				String[] crntRevAmt =	(JSPUtil.getParameter(request, prefix +	"crnt_rev_amt".trim(),	length));
				String[] brkgCrntRevAmt =	(JSPUtil.getParameter(request, prefix +	"brkg_crnt_rev_amt".trim(),	length));
				String[] crsCrntRevAmt =	(JSPUtil.getParameter(request, prefix +	"crs_crnt_rev_amt".trim(),	length));
				String[] generalAmt =	(JSPUtil.getParameter(request, prefix +	"general_amt".trim(),	length));
				String[] ddctTrspAmt =	(JSPUtil.getParameter(request, prefix +	"ddct_trsp_amt".trim(),	length));
				String[] brkgDdctTrspAmt =	(JSPUtil.getParameter(request, prefix +	"brkg_ddct_trsp_amt".trim(),	length));
				String[] crsDdctTrspAmt =	(JSPUtil.getParameter(request, prefix +	"crs_ddct_trsp_amt".trim(),	length));
				String[] commVvd =	(JSPUtil.getParameter(request, prefix +	"comm_vvd".trim(),	length));
				String[] ddctChgAmt =	(JSPUtil.getParameter(request, prefix +	"ddct_chg_amt".trim(),	length));
				String[] brkgDdctChgAmt =	(JSPUtil.getParameter(request, prefix +	"brkg_ddct_chg_amt".trim(),	length));
				String[] crsDdctChgAmt =	(JSPUtil.getParameter(request, prefix +	"crs_ddct_chg_amt".trim(),	length));
				String[] dateTo =	(JSPUtil.getParameter(request, prefix +	"date_to".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] ppdAmt =	(JSPUtil.getParameter(request, prefix +	"ppd_amt".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] tsAmt =	(JSPUtil.getParameter(request, prefix +	"ts_amt".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] usdAmt =	(JSPUtil.getParameter(request, prefix +	"usd_amt".trim(),	length));
				String[] acSeq =	(JSPUtil.getParameter(request, prefix +	"ac_seq".trim(),	length));
				String[] postRevAmt =	(JSPUtil.getParameter(request, prefix +	"post_rev_amt".trim(),	length));
				String[] brkgPostRevAmt =	(JSPUtil.getParameter(request, prefix +	"brkg_post_rev_amt".trim(),	length));
				String[] crsPostRevAmt =	(JSPUtil.getParameter(request, prefix +	"crs_post_rev_amt".trim(),	length));
				String[] acProcDesc =	(JSPUtil.getParameter(request, prefix +	"ac_proc_desc".trim(),	length));
				String[] acOccrInfoCd =	(JSPUtil.getParameter(request, prefix +	"ac_occr_info_cd".trim(),	length));
				String[] vvdDiv =	(JSPUtil.getParameter(request, prefix +	"vvd_div".trim(),	length));
				String[] revVvdCd =	(JSPUtil.getParameter(request, prefix +	"rev_vvd_cd".trim(),	length));
				String[] trdCd =	(JSPUtil.getParameter(request, prefix +	"trd_cd".trim(),	length));
				String[] subTrdCd =	(JSPUtil.getParameter(request, prefix +	"sub_trd_cd".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] custLglEngNm =	(JSPUtil.getParameter(request, prefix +	"cust_lgl_eng_nm".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] rqstFlg =	(JSPUtil.getParameter(request, prefix +	"rqst_flg".trim(),	length));
				String[] acTpCd =	(JSPUtil.getParameter(request, prefix +	"ac_tp_cd".trim(),	length));
				String[] ddctVipAmt =	(JSPUtil.getParameter(request, prefix +	"ddct_vip_amt".trim(),	length));
				String[] brkgDdctVipAmt =	(JSPUtil.getParameter(request, prefix +	"brkg_ddct_vip_amt".trim(),	length));
				String[] crsDdctVipAmt =	(JSPUtil.getParameter(request, prefix +	"crs_ddct_vip_amt".trim(),	length));
				String[] chgCommAmt =	(JSPUtil.getParameter(request, prefix +	"chg_comm_amt".trim(),	length));
				String[] chgCommFlg =	(JSPUtil.getParameter(request, prefix +	"chg_comm_flg".trim(),	length));
				String[] bkgOfcCd =	(JSPUtil.getParameter(request, prefix +	"bkg_ofc_cd".trim(),	length));
				String[] bkgPorCd =	(JSPUtil.getParameter(request, prefix +	"bkg_por_cd".trim(),	length));
				String[] bkgPolCd =	(JSPUtil.getParameter(request, prefix +	"bkg_pol_cd".trim(),	length));
				String[] bkgPodCd =	(JSPUtil.getParameter(request, prefix +	"bkg_pod_cd".trim(),	length));
				String[] bkgDelCd =	(JSPUtil.getParameter(request, prefix +	"bkg_del_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AGNCommRequestVO();
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( acRlaneCd[i] !=	null)
						model.setAcRlaneCd( acRlaneCd[i]);
						if ( dateFm[i] !=	null)
						model.setDateFm( dateFm[i]);
						if ( revDivCd[i] !=	null)
						model.setRevDivCd( revDivCd[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( bkgStsCd[i] !=	null)
						model.setBkgStsCd( bkgStsCd[i]);
						if ( bdrFlg[i] !=	null)
						model.setBdrFlg( bdrFlg[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( chfAmt[i] !=	null)
						model.setChfAmt( chfAmt[i]);
						if ( xchRtAplyLvl[i] !=	null)
						model.setXchRtAplyLvl( xchRtAplyLvl[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( agnCd[i] !=	null)
						model.setAgnCd( agnCd[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( crossAmt[i] !=	null)
						model.setCrossAmt( crossAmt[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( creTm[i] !=	null)
						model.setCreTm( creTm[i]);
						if ( ddctSpclCmpnAmt[i] !=	null)
						model.setDdctSpclCmpnAmt( ddctSpclCmpnAmt[i]);
						if ( dateDiv[i] !=	null)
						model.setDateDiv( dateDiv[i]);
						if ( payIfAmt[i] !=	null)
						model.setPayIfAmt( payIfAmt[i]);
						if ( acStsCd[i] !=	null)
						model.setAcStsCd( acStsCd[i]);
						if ( cntrQty[i] !=	null)
						model.setCntrQty( cntrQty[i]);
						if ( payXchRt[i] !=	null)
						model.setPayXchRt( payXchRt[i]);
						if ( brogAmt[i] !=	null)
						model.setBrogAmt( brogAmt[i]);
						if ( crntRevAmt[i] !=	null)
						model.setCrntRevAmt( crntRevAmt[i]);
						if ( brkgCrntRevAmt[i] !=	null)
						model.setBrkgCrntRevAmt( brkgCrntRevAmt[i]);
						if ( crsCrntRevAmt[i] !=	null)
						model.setCrsCrntRevAmt( crsCrntRevAmt[i]);
						if ( generalAmt[i] !=	null)
						model.setGeneralAmt( generalAmt[i]);
						if ( ddctTrspAmt[i] !=	null)
						model.setDdctTrspAmt( ddctTrspAmt[i]);
						if ( brkgDdctTrspAmt[i] !=	null)
						model.setBrkgDdctTrspAmt( brkgDdctTrspAmt[i]);
						if ( crsDdctTrspAmt[i] !=	null)
						model.setCrsDdctTrspAmt( crsDdctTrspAmt[i]);
						if ( commVvd[i] !=	null)
						model.setCommVvd( commVvd[i]);
						if ( ddctChgAmt[i] !=	null)
						model.setDdctChgAmt( ddctChgAmt[i]);
						if ( brkgDdctChgAmt[i] !=	null)
						model.setBrkgDdctChgAmt( brkgDdctChgAmt[i]);
						if ( crsDdctChgAmt[i] !=	null)
						model.setCrsDdctChgAmt( crsDdctChgAmt[i]);
						if ( dateTo[i] !=	null)
						model.setDateTo( dateTo[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( ppdAmt[i] !=	null)
						model.setPpdAmt( ppdAmt[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( tsAmt[i] !=	null)
						model.setTsAmt( tsAmt[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( usdAmt[i] !=	null)
						model.setUsdAmt( usdAmt[i]);
						if ( acSeq[i] !=	null)
						model.setAcSeq( acSeq[i]);
						if ( postRevAmt[i] !=	null)
						model.setPostRevAmt( postRevAmt[i]);
						if ( brkgPostRevAmt[i] !=	null)
						model.setBrkgPostRevAmt( brkgPostRevAmt[i]);
						if ( crsPostRevAmt[i] !=	null)
						model.setCrsPostRevAmt( crsPostRevAmt[i]);
						if ( acProcDesc[i] !=	null)
						model.setAcProcDesc( acProcDesc[i]);
						if ( acOccrInfoCd[i] !=	null)
						model.setAcOccrInfoCd( acOccrInfoCd[i]);
						if ( vvdDiv[i] !=	null)
						model.setVvdDiv( vvdDiv[i]);
						if ( revVvdCd[i] !=	null)
						model.setRevVvdCd( revVvdCd[i]);
						if ( trdCd[i] !=	null)
						model.setTrdCd( trdCd[i]);
						if ( subTrdCd[i] !=	null)
						model.setSubTrdCd( subTrdCd[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( custLglEngNm[i] !=	null)
						model.setCustLglEngNm( custLglEngNm[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( rqstFlg[i] !=	null)
						model.setRqstFlg( rqstFlg[i]);
						if ( acTpCd[i] !=	null)
						model.setAcTpCd( acTpCd[i]);
						if ( ddctVipAmt[i] !=	null)
						model.setDdctVipAmt( ddctVipAmt[i]);
						if ( brkgDdctVipAmt[i] !=	null)
						model.setBrkgDdctVipAmt( brkgDdctVipAmt[i]);
						if ( crsDdctVipAmt[i] !=	null)
						model.setCrsDdctVipAmt( crsDdctVipAmt[i]);
						if ( chgCommAmt[i] !=	null)
						model.setChgCommAmt( chgCommAmt[i]);
						if ( chgCommFlg[i] !=	null)
						model.setChgCommFlg( chgCommFlg[i]);
						if ( bkgOfcCd[i] !=	null)
						model.setBkgOfcCd( bkgOfcCd[i]);
						if ( bkgPorCd[i] !=	null)
						model.setBkgPorCd( bkgPorCd[i]);
						if ( bkgPolCd[i] !=	null)
						model.setBkgPolCd( bkgPolCd[i]);
						if ( bkgPodCd[i] !=	null)
						model.setBkgPodCd( bkgPodCd[i]);
						if ( bkgDelCd[i] !=	null)
						model.setBkgDelCd( bkgDelCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAGNCommRequestVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AGNCommRequestVO[]
	 */
	public AGNCommRequestVO[]	 getAGNCommRequestVOs(){
		AGNCommRequestVO[] vos = (AGNCommRequestVO[])models.toArray(new	AGNCommRequestVO[models.size()]);
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
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acRlaneCd =	this.acRlaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateFm =	this.dateFm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDivCd =	this.revDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd =	this.bkgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg =	this.bdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chfAmt =	this.chfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtAplyLvl =	this.xchRtAplyLvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd =	this.agnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crossAmt =	this.crossAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creTm =	this.creTm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctSpclCmpnAmt =	this.ddctSpclCmpnAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateDiv =	this.dateDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payIfAmt =	this.payIfAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acStsCd =	this.acStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty =	this.cntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payXchRt =	this.payXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brogAmt =	this.brogAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntRevAmt =	this.crntRevAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brkgCrntRevAmt =	this.brkgCrntRevAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsCrntRevAmt =	this.crsCrntRevAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.generalAmt =	this.generalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctTrspAmt =	this.ddctTrspAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brkgDdctTrspAmt =	this.brkgDdctTrspAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsDdctTrspAmt =	this.crsDdctTrspAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.commVvd =	this.commVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctChgAmt =	this.ddctChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brkgDdctChgAmt =	this.brkgDdctChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsDdctChgAmt =	this.crsDdctChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateTo =	this.dateTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ppdAmt =	this.ppdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsAmt =	this.tsAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt =	this.usdAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acSeq =	this.acSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.postRevAmt =	this.postRevAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brkgPostRevAmt =	this.brkgPostRevAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsPostRevAmt =	this.crsPostRevAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acProcDesc =	this.acProcDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acOccrInfoCd =	this.acOccrInfoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdDiv =	this.vvdDiv.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revVvdCd =	this.revVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd =	this.trdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd =	this.subTrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm =	this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstFlg =	this.rqstFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acTpCd =	this.acTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddctVipAmt =	this.ddctVipAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brkgDdctVipAmt =	this.brkgDdctVipAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crsDdctVipAmt =	this.crsDdctVipAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCommAmt =	this.chgCommAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCommFlg =	this.chgCommFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd =	this.bkgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPorCd =	this.bkgPorCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolCd =	this.bkgPolCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodCd =	this.bkgPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDelCd =	this.bkgDelCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}