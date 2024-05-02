/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvtCntrListVO.java
 *@FileTitle : InvtCntrListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.08.31
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.08.31  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo;

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
public class InvtCntrListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvtCntrListVO>  models =	new	ArrayList<InvtCntrListVO>();


	/*	Column Info	*/
	private  String	 ntfy   =  null;
	/*	Column Info	*/
	private  String	 actDys   =  null;
	/*	Column Info	*/
	private  String	 gwgt   =  null;
	/*	Column Info	*/
	private  String	 rccDate   =  null;
	/*	Column Info	*/
	private  String	 twgt   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 frtCltFlg   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 mnrHngrBarTpCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrBarAtchKnt   =  null;
	/*	Column Info	*/
	private  String	 obSlsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 uclmLsFlg   =  null;
	/*	Column Info	*/
	private  String	 repCmdtNm   =  null;
	/*	Column Info	*/
	private  String	 lessor   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 oblRdemFlg   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 dispFlg   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 uclmLsDivCd   =  null;
	/*	Column Info	*/
	private  String	 nextVvd   =  null;
	/*	Column Info	*/
	private  String	 fullFlg   =  null;
	/*	Column Info	*/
	private  String	 stayDays   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrRckCd   =  null;
	/*	Column Info	*/
	private  String	 pkupNo   =  null;
	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 dtyFreeDt   =  null;
	/*	Column Info	*/
	private  String	 dmgFlg   =  null;
	/*	Column Info	*/
	private  String	 mkDesc   =  null;
	/*	Column Info	*/
	private  String	 polEtd   =  null;
	/*	Column Info	*/
	private  String	 rfaNo   =  null;
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
	private  String	 plstFlrFlg   =  null;
	/*	Column Info	*/
	private  String	 cmdtNm   =  null;
	/*	Column Info	*/
	private  String	 mftDt   =  null;
	/*	Column Info	*/
	private  String	 deTermCd   =  null;
	/*	Column Info	*/
	private  String	 ftDys   =  null;
	/*	Column Info	*/
	private  String	 scRfaNo   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 pwgt   =  null;
	/*	Column Info	*/
	private  String	 seq   =  null;
	/*	Column Info	*/
	private  String	 cnee   =  null;
	/*	Column Info	*/
	private  String	 imdtExtFlg   =  null;
	/*	Column Info	*/
	private  String	 shpr   =  null;
	/*	Column Info	*/
	private  String	 rfTpCd   =  null;
	/*	Column Info	*/
	private  String	 cstmsClrFlg   =  null;
	/*	Column Info	*/
	private  String	 rstr_usg_lbl_nm   =  null;
	/*	Column Info	*/
	private  String	 rstr_usg_lbl_tp   =  null;
	/*	Column Info	*/
	private  String	 rstr_usg_lbl_desc   =  null;
	/*	Column Info	*/
	private  String	 apnt_bkg_no   =  null;
	/*	Column Info	*/
	private  String	 rfMkrSeq   =  null;
	/*	Column Info	*/
	private  String	 rfMdlNm   =  null;
	/*	Column Info	*/
	private  String	 rfHumidCtrlValCd   =  null;
	/*	Column Info	*/
	private  String	 agmt_no   =  null;
	/*	Column Info	*/
	private  String	 lessor_cd   =  null;
	/*	Column Info	*/
	private  String	 dmgFlgDt   =  null;
	/*	Column Info	*/
	private  String	 dmgUnflgDt   =  null;
	/*	Column Info	*/
	private  String	 refId   =  null;
	/*	Column Info	*/
	private  String	 cntrGrsWgt   =  null;
	/*	Column Info	*/
	private  String	 tareWgt   =  null;
	/*	Column Info	*/
	private  String	 payLoad   =  null;
	/*	Column Info	*/
	private  String	 cgoTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvtCntrListVO(){}

	public InvtCntrListVO(String ntfy,String actDys,String gwgt,String rccDate,String twgt,String blNo,String pagerows,String polCd,String frtCltFlg,String scNo,String mnrHngrBarTpCd,String cntrTpszCd,String cntrHngrBarAtchKnt,String obSlsOfcCd,String lstmCd,String uclmLsFlg,String repCmdtNm,String lessor,String cnmvDt,String delCd,String oblRdemFlg,String vvd,String podCd,String dispFlg,String bkgNo,String uclmLsDivCd,String nextVvd,String fullFlg,String stayDays,String cntrHngrRckCd,String pkupNo,String porCd,String crntYdCd,String dtyFreeDt,String dmgFlg,String mkDesc,String polEtd,String rfaNo,String cnmvStsCd,String ibflag,String ftEndDt,String subLocCd,String rccCd,String plstFlrFlg,String cmdtNm,String mftDt,String deTermCd,String ftDys,String scRfaNo,String cntrNo,String pwgt,String seq,String cnee,String imdtExtFlg,String shpr,String rfTpCd,String cstmsClrFlg,String rstr_usg_lbl_nm,String rstr_usg_lbl_tp,String rstr_usg_lbl_desc,String apnt_bkg_no,String rfMkrSeq,String rfMdlNm,String rfHumidCtrlValCd,String agmt_no,String lessor_cd,String dmgFlgDt,String dmgUnflgDt,String refId,String cntrGrsWgt,String tareWgt,String payLoad,String cgoTpCd)	{
		this.ntfy  = ntfy ;
		this.actDys  = actDys ;
		this.gwgt  = gwgt ;
		this.rccDate  = rccDate ;
		this.twgt  = twgt ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.polCd  = polCd ;
		this.frtCltFlg  = frtCltFlg ;
		this.scNo  = scNo ;
		this.mnrHngrBarTpCd  = mnrHngrBarTpCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.cntrHngrBarAtchKnt  = cntrHngrBarAtchKnt ;
		this.obSlsOfcCd  = obSlsOfcCd ;
		this.lstmCd  = lstmCd ;
		this.uclmLsFlg  = uclmLsFlg ;
		this.repCmdtNm  = repCmdtNm ;
		this.lessor  = lessor ;
		this.cnmvDt  = cnmvDt ;
		this.delCd  = delCd ;
		this.oblRdemFlg  = oblRdemFlg ;
		this.vvd  = vvd ;
		this.podCd  = podCd ;
		this.dispFlg  = dispFlg ;
		this.bkgNo  = bkgNo ;
		this.uclmLsDivCd  = uclmLsDivCd ;
		this.nextVvd  = nextVvd ;
		this.fullFlg  = fullFlg ;
		this.stayDays  = stayDays ;
		this.cntrHngrRckCd  = cntrHngrRckCd ;
		this.pkupNo  = pkupNo ;
		this.porCd  = porCd ;
		this.crntYdCd  = crntYdCd ;
		this.dtyFreeDt  = dtyFreeDt ;
		this.dmgFlg  = dmgFlg ;
		this.mkDesc  = mkDesc ;
		this.polEtd  = polEtd ;
		this.rfaNo  = rfaNo ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.ibflag  = ibflag ;
		this.ftEndDt  = ftEndDt ;
		this.subLocCd  = subLocCd ;
		this.rccCd  = rccCd ;
		this.plstFlrFlg  = plstFlrFlg ;
		this.cmdtNm  = cmdtNm ;
		this.mftDt  = mftDt ;
		this.deTermCd  = deTermCd ;
		this.ftDys  = ftDys ;
		this.scRfaNo  = scRfaNo ;
		this.cntrNo  = cntrNo ;
		this.pwgt  = pwgt ;
		this.seq  = seq ;
		this.cnee  = cnee ;
		this.imdtExtFlg  = imdtExtFlg ;
		this.shpr  = shpr ;
		this.rfTpCd  = rfTpCd ;
		this.cstmsClrFlg  = cstmsClrFlg ;
		this.rstr_usg_lbl_nm  = rstr_usg_lbl_nm ;
		this.rstr_usg_lbl_tp  = rstr_usg_lbl_tp ;
		this.rstr_usg_lbl_desc  = rstr_usg_lbl_desc ;
		this.apnt_bkg_no  = apnt_bkg_no ;
		this.rfMkrSeq  = rfMkrSeq ;
		this.rfMdlNm  = rfMdlNm ;
		this.rfHumidCtrlValCd  = rfHumidCtrlValCd ;
		this.agmt_no  = agmt_no ;
		this.lessor_cd  = lessor_cd ;
		this.dmgFlgDt  = dmgFlgDt ;
		this.dmgUnflgDt  = dmgUnflgDt ;
		this.refId  = refId ;
		this.cntrGrsWgt  = cntrGrsWgt ;
		this.tareWgt  = tareWgt ;
		this.payLoad  = payLoad ;
		this.cgoTpCd  = cgoTpCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ntfy", getNtfy());		
		this.hashColumns.put("act_dys", getActDys());		
		this.hashColumns.put("gwgt", getGwgt());		
		this.hashColumns.put("rcc_date", getRccDate());		
		this.hashColumns.put("twgt", getTwgt());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("frt_clt_flg", getFrtCltFlg());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("mnr_hngr_bar_tp_cd", getMnrHngrBarTpCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());		
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("uclm_ls_flg", getUclmLsFlg());		
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());		
		this.hashColumns.put("lessor", getLessor());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("disp_flg", getDispFlg());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());		
		this.hashColumns.put("next_vvd", getNextVvd());		
		this.hashColumns.put("full_flg", getFullFlg());		
		this.hashColumns.put("stay_days", getStayDays());		
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());		
		this.hashColumns.put("pkup_no", getPkupNo());		
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("dty_free_dt", getDtyFreeDt());		
		this.hashColumns.put("dmg_flg", getDmgFlg());		
		this.hashColumns.put("mk_desc", getMkDesc());		
		this.hashColumns.put("pol_etd", getPolEtd());		
		this.hashColumns.put("rfa_no", getRfaNo());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ft_end_dt", getFtEndDt());		
		this.hashColumns.put("sub_loc_cd", getSubLocCd());		
		this.hashColumns.put("rcc_cd", getRccCd());		
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());		
		this.hashColumns.put("cmdt_nm", getCmdtNm());		
		this.hashColumns.put("mft_dt", getMftDt());		
		this.hashColumns.put("de_term_cd", getDeTermCd());		
		this.hashColumns.put("ft_dys", getFtDys());		
		this.hashColumns.put("sc_rfa_no", getScRfaNo());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("pwgt", getPwgt());		
		this.hashColumns.put("seq", getSeq());		
		this.hashColumns.put("cnee", getCnee());		
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());		
		this.hashColumns.put("shpr", getShpr());		
		this.hashColumns.put("rf_tp_cd", getRfTpCd());		
		this.hashColumns.put("cstms_clr_flg", getCstmsClrFlg());		
		this.hashColumns.put("rstr_usg_lbl_nm", getRstr_usg_lbl_nm());		
		this.hashColumns.put("rstr_usg_lbl_tp", getRstr_usg_lbl_tp());		
		this.hashColumns.put("rstr_usg_lbl_desc", getRstr_usg_lbl_desc());		
		this.hashColumns.put("apnt_bkg_no", getApnt_bkg_no());		
		this.hashColumns.put("rf_mkr_seq", getRfMkrSeq());		
		this.hashColumns.put("rf_mdl_nm", getRfMdlNm());		
		this.hashColumns.put("rf_humid_ctrl_val_cd", getRfHumidCtrlValCd());		
		this.hashColumns.put("agmt_no", getAgmt_no());		
		this.hashColumns.put("lessor_cd", getLessor_cd());		
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());		
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());		
		this.hashColumns.put("ref_id", getRefId());		
		this.hashColumns.put("cntr_grs_wgt", getCntrGrsWgt());		
		this.hashColumns.put("tare_wgt", getTareWgt());		
		this.hashColumns.put("pay_load", getPayLoad());
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());				
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ntfy", "ntfy");
		this.hashFields.put("act_dys", "actDys");
		this.hashFields.put("gwgt", "gwgt");
		this.hashFields.put("rcc_date", "rccDate");
		this.hashFields.put("twgt", "twgt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("frt_clt_flg", "frtCltFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("mnr_hngr_bar_tp_cd", "mnrHngrBarTpCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("uclm_ls_flg", "uclmLsFlg");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("lessor", "lessor");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("dty_free_dt", "dtyFreeDt");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("sub_loc_cd", "subLocCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ft_dys", "ftDys");
		this.hashFields.put("sc_rfa_no", "scRfaNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pwgt", "pwgt");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("cnee", "cnee");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("shpr", "shpr");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("cstms_clr_flg", "cstmsClrFlg");
		this.hashFields.put("rstr_usg_lbl_nm", "rstr_usg_lbl_nm");
		this.hashFields.put("rstr_usg_lbl_tp", "rstr_usg_lbl_tp");
		this.hashFields.put("rstr_usg_lbl_desc", "rstr_usg_lbl_desc");
		this.hashFields.put("apnt_bkg_no", "apnt_bkg_no");
		this.hashFields.put("rf_mkr_seq", "rfMkrSeq");
		this.hashFields.put("rf_mdl_nm", "rfMdlNm");
		this.hashFields.put("rf_humid_ctrl_val_cd", "rfHumidCtrlValCd");
		this.hashFields.put("agmt_no", "agmt_no");
		this.hashFields.put("lessor_cd", "lessor_cd");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
		this.hashFields.put("ref_id", "refId");
		this.hashFields.put("cntr_grs_wgt", "cntrGrsWgt");
		this.hashFields.put("tare_wgt", "tareWgt");
		this.hashFields.put("pay_load", "payLoad");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
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
	* @param  gwgt
	*/
	public void	setGwgt( String	gwgt ) {
		this.gwgt =	gwgt;
	}
 
	/**
	 * Column Info
	 * @return	gwgt
	 */
	 public	 String	getGwgt() {
		 return	this.gwgt;
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
	* @param  twgt
	*/
	public void	setTwgt( String	twgt ) {
		this.twgt =	twgt;
	}
 
	/**
	 * Column Info
	 * @return	twgt
	 */
	 public	 String	getTwgt() {
		 return	this.twgt;
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
	* @param  frtCltFlg
	*/
	public void	setFrtCltFlg( String	frtCltFlg ) {
		this.frtCltFlg =	frtCltFlg;
	}
 
	/**
	 * Column Info
	 * @return	frtCltFlg
	 */
	 public	 String	getFrtCltFlg() {
		 return	this.frtCltFlg;
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
	 public	 String	getScNo() {
		 return	this.scNo;
	 } 
 	/**
	* Column Info
	* @param  mnrHngrBarTpCd
	*/
	public void	setMnrHngrBarTpCd( String	mnrHngrBarTpCd ) {
		this.mnrHngrBarTpCd =	mnrHngrBarTpCd;
	}
 
	/**
	 * Column Info
	 * @return	mnrHngrBarTpCd
	 */
	 public	 String	getMnrHngrBarTpCd() {
		 return	this.mnrHngrBarTpCd;
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
	* @param  cntrHngrBarAtchKnt
	*/
	public void	setCntrHngrBarAtchKnt( String	cntrHngrBarAtchKnt ) {
		this.cntrHngrBarAtchKnt =	cntrHngrBarAtchKnt;
	}
 
	/**
	 * Column Info
	 * @return	cntrHngrBarAtchKnt
	 */
	 public	 String	getCntrHngrBarAtchKnt() {
		 return	this.cntrHngrBarAtchKnt;
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
	* @param  lessor
	*/
	public void	setLessor( String	lessor ) {
		this.lessor =	lessor;
	}
 
	/**
	 * Column Info
	 * @return	lessor
	 */
	 public	 String	getLessor() {
		 return	this.lessor;
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
	* @param  oblRdemFlg
	*/
	public void	setOblRdemFlg( String	oblRdemFlg ) {
		this.oblRdemFlg =	oblRdemFlg;
	}
 
	/**
	 * Column Info
	 * @return	oblRdemFlg
	 */
	 public	 String	getOblRdemFlg() {
		 return	this.oblRdemFlg;
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
	* @param  nextVvd
	*/
	public void	setNextVvd( String	nextVvd ) {
		this.nextVvd =	nextVvd;
	}
 
	/**
	 * Column Info
	 * @return	nextVvd
	 */
	 public	 String	getNextVvd() {
		 return	this.nextVvd;
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
	* @param  cntrHngrRckCd
	*/
	public void	setCntrHngrRckCd( String	cntrHngrRckCd ) {
		this.cntrHngrRckCd =	cntrHngrRckCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrHngrRckCd
	 */
	 public	 String	getCntrHngrRckCd() {
		 return	this.cntrHngrRckCd;
	 } 
 	/**
	* Column Info
	* @param  pkupNo
	*/
	public void	setPkupNo( String	pkupNo ) {
		this.pkupNo =	pkupNo;
	}
 
	/**
	 * Column Info
	 * @return	pkupNo
	 */
	 public	 String	getPkupNo() {
		 return	this.pkupNo;
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
	* @param  dtyFreeDt
	*/
	public void	setDtyFreeDt( String	dtyFreeDt ) {
		this.dtyFreeDt =	dtyFreeDt;
	}
 
	/**
	 * Column Info
	 * @return	dtyFreeDt
	 */
	 public	 String	getDtyFreeDt() {
		 return	this.dtyFreeDt;
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
	* @param  rfaNo
	*/
	public void	setRfaNo( String	rfaNo ) {
		this.rfaNo =	rfaNo;
	}
 
	/**
	 * Column Info
	 * @return	rfaNo
	 */
	 public	 String	getRfaNo() {
		 return	this.rfaNo;
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
	* @param  plstFlrFlg
	*/
	public void	setPlstFlrFlg( String	plstFlrFlg ) {
		this.plstFlrFlg =	plstFlrFlg;
	}
 
	/**
	 * Column Info
	 * @return	plstFlrFlg
	 */
	 public	 String	getPlstFlrFlg() {
		 return	this.plstFlrFlg;
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
	* @param  mftDt
	*/
	public void	setMftDt( String	mftDt ) {
		this.mftDt =	mftDt;
	}
 
	/**
	 * Column Info
	 * @return	mftDt
	 */
	 public	 String	getMftDt() {
		 return	this.mftDt;
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
	* @param  pwgt
	*/
	public void	setPwgt( String	pwgt ) {
		this.pwgt =	pwgt;
	}
 
	/**
	 * Column Info
	 * @return	pwgt
	 */
	 public	 String	getPwgt() {
		 return	this.pwgt;
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
	* @param  imdtExtFlg
	*/
	public void	setImdtExtFlg( String	imdtExtFlg ) {
		this.imdtExtFlg =	imdtExtFlg;
	}
 
	/**
	 * Column Info
	 * @return	imdtExtFlg
	 */
	 public	 String	getImdtExtFlg() {
		 return	this.imdtExtFlg;
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
	* @param  cstmsClrFlg
	*/
	public void	setCstmsClrFlg( String	cstmsClrFlg ) {
		this.cstmsClrFlg =	cstmsClrFlg;
	}
 
	/**
	 * Column Info
	 * @return	cstmsClrFlg
	 */
	 public	 String	getCstmsClrFlg() {
		 return	this.cstmsClrFlg;
	 } 
 	/**
	* Column Info
	* @param  rstr_usg_lbl_nm
	*/
	public void	setRstr_usg_lbl_nm( String	rstr_usg_lbl_nm ) {
		this.rstr_usg_lbl_nm =	rstr_usg_lbl_nm;
	}
 
	/**
	 * Column Info
	 * @return	rstr_usg_lbl_nm
	 */
	 public	 String	getRstr_usg_lbl_nm() {
		 return	this.rstr_usg_lbl_nm;
	 } 
 	/**
	* Column Info
	* @param  rstr_usg_lbl_tp
	*/
	public void	setRstr_usg_lbl_tp( String	rstr_usg_lbl_tp ) {
		this.rstr_usg_lbl_tp =	rstr_usg_lbl_tp;
	}
 
	/**
	 * Column Info
	 * @return	rstr_usg_lbl_tp
	 */
	 public	 String	getRstr_usg_lbl_tp() {
		 return	this.rstr_usg_lbl_tp;
	 } 
 	/**
	* Column Info
	* @param  rstr_usg_lbl_desc
	*/
	public void	setRstr_usg_lbl_desc( String	rstr_usg_lbl_desc ) {
		this.rstr_usg_lbl_desc =	rstr_usg_lbl_desc;
	}
 
	/**
	 * Column Info
	 * @return	rstr_usg_lbl_desc
	 */
	 public	 String	getRstr_usg_lbl_desc() {
		 return	this.rstr_usg_lbl_desc;
	 } 
 	/**
	* Column Info
	* @param  apnt_bkg_no
	*/
	public void	setApnt_bkg_no( String	apnt_bkg_no ) {
		this.apnt_bkg_no =	apnt_bkg_no;
	}
 
	/**
	 * Column Info
	 * @return	apnt_bkg_no
	 */
	 public	 String	getApnt_bkg_no() {
		 return	this.apnt_bkg_no;
	 } 
 	/**
	* Column Info
	* @param  rfMkrSeq
	*/
	public void	setRfMkrSeq( String	rfMkrSeq ) {
		this.rfMkrSeq =	rfMkrSeq;
	}
 
	/**
	 * Column Info
	 * @return	rfMkrSeq
	 */
	 public	 String	getRfMkrSeq() {
		 return	this.rfMkrSeq;
	 } 
 	/**
	* Column Info
	* @param  rfMdlNm
	*/
	public void	setRfMdlNm( String	rfMdlNm ) {
		this.rfMdlNm =	rfMdlNm;
	}
 
	/**
	 * Column Info
	 * @return	rfMdlNm
	 */
	 public	 String	getRfMdlNm() {
		 return	this.rfMdlNm;
	 } 
 	/**
	* Column Info
	* @param  rfHumidCtrlValCd
	*/
	public void	setRfHumidCtrlValCd( String	rfHumidCtrlValCd ) {
		this.rfHumidCtrlValCd =	rfHumidCtrlValCd;
	}
 
	/**
	 * Column Info
	 * @return	rfHumidCtrlValCd
	 */
	 public	 String	getRfHumidCtrlValCd() {
		 return	this.rfHumidCtrlValCd;
	 } 
 	/**
	* Column Info
	* @param  agmt_no
	*/
	public void	setAgmt_no( String	agmt_no ) {
		this.agmt_no =	agmt_no;
	}
 
	/**
	 * Column Info
	 * @return	agmt_no
	 */
	 public	 String	getAgmt_no() {
		 return	this.agmt_no;
	 } 
 	/**
	* Column Info
	* @param  lessor_cd
	*/
	public void	setLessor_cd( String	lessor_cd ) {
		this.lessor_cd =	lessor_cd;
	}
 
	/**
	 * Column Info
	 * @return	lessor_cd
	 */
	 public	 String	getLessor_cd() {
		 return	this.lessor_cd;
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
	* Column Info
	* @param  refId
	*/
	public void	setRefId( String	refId ) {
		this.refId =	refId;
	}
 
	/**
	 * Column Info
	 * @return	refId
	 */
	 public	 String	getRefId() {
		 return	this.refId;
	 } 
 	/**
	* Column Info
	* @param  cntrGrsWgt
	*/
	public void	setCntrGrsWgt( String	cntrGrsWgt ) {
		this.cntrGrsWgt =	cntrGrsWgt;
	}
 
	/**
	 * Column Info
	 * @return	cntrGrsWgt
	 */
	 public	 String	getCntrGrsWgt() {
		 return	this.cntrGrsWgt;
	 } 
 	/**
	* Column Info
	* @param  tareWgt
	*/
	public void	setTareWgt( String	tareWgt ) {
		this.tareWgt =	tareWgt;
	}
 
	/**
	 * Column Info
	 * @return	tareWgt
	 */
	 public	 String	getTareWgt() {
		 return	this.tareWgt;
	 } 
 	/**
	* Column Info
	* @param  payLoad
	*/
	public void	setPayLoad( String	payLoad ) {
		this.payLoad =	payLoad;
	}
 
	/**
	 * Column Info
	 * @return	payLoad
	 */
	 public	 String	getPayLoad() {
		 return	this.payLoad;
	 }
	 
	 	/**
		* Column Info
		* @param  cgoTpCd
		*/
		public void	setCgoTpCd( String	cgoTpCd ) {
			this.cgoTpCd =	cgoTpCd;
		}
	 
		/**
		 * Column Info
		 * @return	cgoTpCd
		 */
		 public	 String	getCgoTpCd() {
			 return	this.cgoTpCd;
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
		setGwgt(JSPUtil.getParameter(request,	prefix + "gwgt", ""));
		setRccDate(JSPUtil.getParameter(request,	prefix + "rcc_date", ""));
		setTwgt(JSPUtil.getParameter(request,	prefix + "twgt", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setFrtCltFlg(JSPUtil.getParameter(request,	prefix + "frt_clt_flg", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setMnrHngrBarTpCd(JSPUtil.getParameter(request,	prefix + "mnr_hngr_bar_tp_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request,	prefix + "cntr_hngr_bar_atch_knt", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request,	prefix + "ob_sls_ofc_cd", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setUclmLsFlg(JSPUtil.getParameter(request,	prefix + "uclm_ls_flg", ""));
		setRepCmdtNm(JSPUtil.getParameter(request,	prefix + "rep_cmdt_nm", ""));
		setLessor(JSPUtil.getParameter(request,	prefix + "lessor", ""));
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setOblRdemFlg(JSPUtil.getParameter(request,	prefix + "obl_rdem_flg", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setDispFlg(JSPUtil.getParameter(request,	prefix + "disp_flg", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request,	prefix + "uclm_ls_div_cd", ""));
		setNextVvd(JSPUtil.getParameter(request,	prefix + "next_vvd", ""));
		setFullFlg(JSPUtil.getParameter(request,	prefix + "full_flg", ""));
		setStayDays(JSPUtil.getParameter(request,	prefix + "stay_days", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request,	prefix + "cntr_hngr_rck_cd", ""));
		setPkupNo(JSPUtil.getParameter(request,	prefix + "pkup_no", ""));
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setDtyFreeDt(JSPUtil.getParameter(request,	prefix + "dty_free_dt", ""));
		setDmgFlg(JSPUtil.getParameter(request,	prefix + "dmg_flg", ""));
		setMkDesc(JSPUtil.getParameter(request,	prefix + "mk_desc", ""));
		setPolEtd(JSPUtil.getParameter(request,	prefix + "pol_etd", ""));
		setRfaNo(JSPUtil.getParameter(request,	prefix + "rfa_no", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setFtEndDt(JSPUtil.getParameter(request,	prefix + "ft_end_dt", ""));
		setSubLocCd(JSPUtil.getParameter(request,	prefix + "sub_loc_cd", ""));
		setRccCd(JSPUtil.getParameter(request,	prefix + "rcc_cd", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request,	prefix + "plst_flr_flg", ""));
		setCmdtNm(JSPUtil.getParameter(request,	prefix + "cmdt_nm", ""));
		setMftDt(JSPUtil.getParameter(request,	prefix + "mft_dt", ""));
		setDeTermCd(JSPUtil.getParameter(request,	prefix + "de_term_cd", ""));
		setFtDys(JSPUtil.getParameter(request,	prefix + "ft_dys", ""));
		setScRfaNo(JSPUtil.getParameter(request,	prefix + "sc_rfa_no", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setPwgt(JSPUtil.getParameter(request,	prefix + "pwgt", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setCnee(JSPUtil.getParameter(request,	prefix + "cnee", ""));
		setImdtExtFlg(JSPUtil.getParameter(request,	prefix + "imdt_ext_flg", ""));
		setShpr(JSPUtil.getParameter(request,	prefix + "shpr", ""));
		setRfTpCd(JSPUtil.getParameter(request,	prefix + "rf_tp_cd", ""));
		setCstmsClrFlg(JSPUtil.getParameter(request,	prefix + "cstms_clr_flg", ""));
		setRstr_usg_lbl_nm(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_nm", ""));
		setRstr_usg_lbl_tp(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_tp", ""));
		setRstr_usg_lbl_desc(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_desc", ""));
		setApnt_bkg_no(JSPUtil.getParameter(request,	prefix + "apnt_bkg_no", ""));
		setRfMkrSeq(JSPUtil.getParameter(request,	prefix + "rf_mkr_seq", ""));
		setRfMdlNm(JSPUtil.getParameter(request,	prefix + "rf_mdl_nm", ""));
		setRfHumidCtrlValCd(JSPUtil.getParameter(request,	prefix + "rf_humid_ctrl_val_cd", ""));
		setAgmt_no(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setLessor_cd(JSPUtil.getParameter(request,	prefix + "lessor_cd", ""));
		setDmgFlgDt(JSPUtil.getParameter(request,	prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request,	prefix + "dmg_unflg_dt", ""));
		setRefId(JSPUtil.getParameter(request,	prefix + "ref_id", ""));
		setCntrGrsWgt(JSPUtil.getParameter(request,	prefix + "cntr_grs_wgt", ""));
		setTareWgt(JSPUtil.getParameter(request,	prefix + "tare_wgt", ""));
		setPayLoad(JSPUtil.getParameter(request,	prefix + "pay_load", ""));
		setCgoTpCd(JSPUtil.getParameter(request,	prefix + "cgo_tp_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return InvtCntrListVO[]
	 */
	public InvtCntrListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return InvtCntrListVO[]
	 */
	public InvtCntrListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvtCntrListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ntfy =	(JSPUtil.getParameter(request, prefix +	"ntfy".trim(),	length));
				String[] actDys =	(JSPUtil.getParameter(request, prefix +	"act_dys".trim(),	length));
				String[] gwgt =	(JSPUtil.getParameter(request, prefix +	"gwgt".trim(),	length));
				String[] rccDate =	(JSPUtil.getParameter(request, prefix +	"rcc_date".trim(),	length));
				String[] twgt =	(JSPUtil.getParameter(request, prefix +	"twgt".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] frtCltFlg =	(JSPUtil.getParameter(request, prefix +	"frt_clt_flg".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] mnrHngrBarTpCd =	(JSPUtil.getParameter(request, prefix +	"mnr_hngr_bar_tp_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] cntrHngrBarAtchKnt =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_bar_atch_knt".trim(),	length));
				String[] obSlsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ob_sls_ofc_cd".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] uclmLsFlg =	(JSPUtil.getParameter(request, prefix +	"uclm_ls_flg".trim(),	length));
				String[] repCmdtNm =	(JSPUtil.getParameter(request, prefix +	"rep_cmdt_nm".trim(),	length));
				String[] lessor =	(JSPUtil.getParameter(request, prefix +	"lessor".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] oblRdemFlg =	(JSPUtil.getParameter(request, prefix +	"obl_rdem_flg".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] dispFlg =	(JSPUtil.getParameter(request, prefix +	"disp_flg".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] uclmLsDivCd =	(JSPUtil.getParameter(request, prefix +	"uclm_ls_div_cd".trim(),	length));
				String[] nextVvd =	(JSPUtil.getParameter(request, prefix +	"next_vvd".trim(),	length));
				String[] fullFlg =	(JSPUtil.getParameter(request, prefix +	"full_flg".trim(),	length));
				String[] stayDays =	(JSPUtil.getParameter(request, prefix +	"stay_days".trim(),	length));
				String[] cntrHngrRckCd =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_rck_cd".trim(),	length));
				String[] pkupNo =	(JSPUtil.getParameter(request, prefix +	"pkup_no".trim(),	length));
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] dtyFreeDt =	(JSPUtil.getParameter(request, prefix +	"dty_free_dt".trim(),	length));
				String[] dmgFlg =	(JSPUtil.getParameter(request, prefix +	"dmg_flg".trim(),	length));
				String[] mkDesc =	(JSPUtil.getParameter(request, prefix +	"mk_desc".trim(),	length));
				String[] polEtd =	(JSPUtil.getParameter(request, prefix +	"pol_etd".trim(),	length));
				String[] rfaNo =	(JSPUtil.getParameter(request, prefix +	"rfa_no".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] ftEndDt =	(JSPUtil.getParameter(request, prefix +	"ft_end_dt".trim(),	length));
				String[] subLocCd =	(JSPUtil.getParameter(request, prefix +	"sub_loc_cd".trim(),	length));
				String[] rccCd =	(JSPUtil.getParameter(request, prefix +	"rcc_cd".trim(),	length));
				String[] plstFlrFlg =	(JSPUtil.getParameter(request, prefix +	"plst_flr_flg".trim(),	length));
				String[] cmdtNm =	(JSPUtil.getParameter(request, prefix +	"cmdt_nm".trim(),	length));
				String[] mftDt =	(JSPUtil.getParameter(request, prefix +	"mft_dt".trim(),	length));
				String[] deTermCd =	(JSPUtil.getParameter(request, prefix +	"de_term_cd".trim(),	length));
				String[] ftDys =	(JSPUtil.getParameter(request, prefix +	"ft_dys".trim(),	length));
				String[] scRfaNo =	(JSPUtil.getParameter(request, prefix +	"sc_rfa_no".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] pwgt =	(JSPUtil.getParameter(request, prefix +	"pwgt".trim(),	length));
				String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq".trim(),	length));
				String[] cnee =	(JSPUtil.getParameter(request, prefix +	"cnee".trim(),	length));
				String[] imdtExtFlg =	(JSPUtil.getParameter(request, prefix +	"imdt_ext_flg".trim(),	length));
				String[] shpr =	(JSPUtil.getParameter(request, prefix +	"shpr".trim(),	length));
				String[] rfTpCd =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd".trim(),	length));
				String[] cstmsClrFlg =	(JSPUtil.getParameter(request, prefix +	"cstms_clr_flg".trim(),	length));
				String[] rstr_usg_lbl_nm =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_nm".trim(),	length));
				String[] rstr_usg_lbl_tp =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_tp".trim(),	length));
				String[] rstr_usg_lbl_desc =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_desc".trim(),	length));
				String[] apnt_bkg_no =	(JSPUtil.getParameter(request, prefix +	"apnt_bkg_no".trim(),	length));
				String[] rfMkrSeq =	(JSPUtil.getParameter(request, prefix +	"rf_mkr_seq".trim(),	length));
				String[] rfMdlNm =	(JSPUtil.getParameter(request, prefix +	"rf_mdl_nm".trim(),	length));
				String[] rfHumidCtrlValCd =	(JSPUtil.getParameter(request, prefix +	"rf_humid_ctrl_val_cd".trim(),	length));
				String[] agmt_no =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] lessor_cd =	(JSPUtil.getParameter(request, prefix +	"lessor_cd".trim(),	length));
				String[] dmgFlgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_flg_dt".trim(),	length));
				String[] dmgUnflgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_unflg_dt".trim(),	length));
				String[] refId =	(JSPUtil.getParameter(request, prefix +	"ref_id".trim(),	length));
				String[] cntrGrsWgt =	(JSPUtil.getParameter(request, prefix +	"cntr_grs_wgt".trim(),	length));
				String[] tareWgt =	(JSPUtil.getParameter(request, prefix +	"tare_wgt".trim(),	length));
				String[] payLoad =	(JSPUtil.getParameter(request, prefix +	"pay_load".trim(),	length));
				String[] cgoTpCd =	(JSPUtil.getParameter(request, prefix +	"cgo_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvtCntrListVO();
						if ( ntfy[i] !=	null)
						model.setNtfy( ntfy[i]);
						if ( actDys[i] !=	null)
						model.setActDys( actDys[i]);
						if ( gwgt[i] !=	null)
						model.setGwgt( gwgt[i]);
						if ( rccDate[i] !=	null)
						model.setRccDate( rccDate[i]);
						if ( twgt[i] !=	null)
						model.setTwgt( twgt[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( frtCltFlg[i] !=	null)
						model.setFrtCltFlg( frtCltFlg[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( mnrHngrBarTpCd[i] !=	null)
						model.setMnrHngrBarTpCd( mnrHngrBarTpCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( cntrHngrBarAtchKnt[i] !=	null)
						model.setCntrHngrBarAtchKnt( cntrHngrBarAtchKnt[i]);
						if ( obSlsOfcCd[i] !=	null)
						model.setObSlsOfcCd( obSlsOfcCd[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( uclmLsFlg[i] !=	null)
						model.setUclmLsFlg( uclmLsFlg[i]);
						if ( repCmdtNm[i] !=	null)
						model.setRepCmdtNm( repCmdtNm[i]);
						if ( lessor[i] !=	null)
						model.setLessor( lessor[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( oblRdemFlg[i] !=	null)
						model.setOblRdemFlg( oblRdemFlg[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( dispFlg[i] !=	null)
						model.setDispFlg( dispFlg[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( uclmLsDivCd[i] !=	null)
						model.setUclmLsDivCd( uclmLsDivCd[i]);
						if ( nextVvd[i] !=	null)
						model.setNextVvd( nextVvd[i]);
						if ( fullFlg[i] !=	null)
						model.setFullFlg( fullFlg[i]);
						if ( stayDays[i] !=	null)
						model.setStayDays( stayDays[i]);
						if ( cntrHngrRckCd[i] !=	null)
						model.setCntrHngrRckCd( cntrHngrRckCd[i]);
						if ( pkupNo[i] !=	null)
						model.setPkupNo( pkupNo[i]);
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( dtyFreeDt[i] !=	null)
						model.setDtyFreeDt( dtyFreeDt[i]);
						if ( dmgFlg[i] !=	null)
						model.setDmgFlg( dmgFlg[i]);
						if ( mkDesc[i] !=	null)
						model.setMkDesc( mkDesc[i]);
						if ( polEtd[i] !=	null)
						model.setPolEtd( polEtd[i]);
						if ( rfaNo[i] !=	null)
						model.setRfaNo( rfaNo[i]);
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
						if ( plstFlrFlg[i] !=	null)
						model.setPlstFlrFlg( plstFlrFlg[i]);
						if ( cmdtNm[i] !=	null)
						model.setCmdtNm( cmdtNm[i]);
						if ( mftDt[i] !=	null)
						model.setMftDt( mftDt[i]);
						if ( deTermCd[i] !=	null)
						model.setDeTermCd( deTermCd[i]);
						if ( ftDys[i] !=	null)
						model.setFtDys( ftDys[i]);
						if ( scRfaNo[i] !=	null)
						model.setScRfaNo( scRfaNo[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( pwgt[i] !=	null)
						model.setPwgt( pwgt[i]);
						if ( seq[i] !=	null)
						model.setSeq( seq[i]);
						if ( cnee[i] !=	null)
						model.setCnee( cnee[i]);
						if ( imdtExtFlg[i] !=	null)
						model.setImdtExtFlg( imdtExtFlg[i]);
						if ( shpr[i] !=	null)
						model.setShpr( shpr[i]);
						if ( rfTpCd[i] !=	null)
						model.setRfTpCd( rfTpCd[i]);
						if ( cstmsClrFlg[i] !=	null)
						model.setCstmsClrFlg( cstmsClrFlg[i]);
						if ( rstr_usg_lbl_nm[i] !=	null)
						model.setRstr_usg_lbl_nm( rstr_usg_lbl_nm[i]);
						if ( rstr_usg_lbl_tp[i] !=	null)
						model.setRstr_usg_lbl_tp( rstr_usg_lbl_tp[i]);
						if ( rstr_usg_lbl_desc[i] !=	null)
						model.setRstr_usg_lbl_desc( rstr_usg_lbl_desc[i]);
						if ( apnt_bkg_no[i] !=	null)
						model.setApnt_bkg_no( apnt_bkg_no[i]);
						if ( rfMkrSeq[i] !=	null)
						model.setRfMkrSeq( rfMkrSeq[i]);
						if ( rfMdlNm[i] !=	null)
						model.setRfMdlNm( rfMdlNm[i]);
						if ( rfHumidCtrlValCd[i] !=	null)
						model.setRfHumidCtrlValCd( rfHumidCtrlValCd[i]);
						if ( agmt_no[i] !=	null)
						model.setAgmt_no( agmt_no[i]);
						if ( lessor_cd[i] !=	null)
						model.setLessor_cd( lessor_cd[i]);
						if ( dmgFlgDt[i] !=	null)
						model.setDmgFlgDt( dmgFlgDt[i]);
						if ( dmgUnflgDt[i] !=	null)
						model.setDmgUnflgDt( dmgUnflgDt[i]);
						if ( refId[i] !=	null)
						model.setRefId( refId[i]);
						if ( cntrGrsWgt[i] !=	null)
						model.setCntrGrsWgt( cntrGrsWgt[i]);
						if ( tareWgt[i] !=	null)
						model.setTareWgt( tareWgt[i]);
						if ( payLoad[i] !=	null)
						model.setPayLoad( payLoad[i]);
						model.setTareWgt( tareWgt[i]);
						if ( payLoad[i] !=	null)
						model.setPayLoad( payLoad[i]);
						if ( cgoTpCd[i] !=	null)
						model.setCgoTpCd( cgoTpCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvtCntrListVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return InvtCntrListVO[]
	 */
	public InvtCntrListVO[]	 getInvtCntrListVOs(){
		InvtCntrListVO[] vos = (InvtCntrListVO[])models.toArray(new	InvtCntrListVO[models.size()]);
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
		this.gwgt =	this.gwgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccDate =	this.rccDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twgt =	this.twgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtCltFlg =	this.frtCltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrHngrBarTpCd =	this.mnrHngrBarTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt =	this.cntrHngrBarAtchKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd =	this.obSlsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsFlg =	this.uclmLsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm =	this.repCmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor =	this.lessor.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg =	this.oblRdemFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg =	this.dispFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd =	this.uclmLsDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd =	this.nextVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg =	this.fullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays =	this.stayDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd =	this.cntrHngrRckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo =	this.pkupNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtyFreeDt =	this.dtyFreeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg =	this.dmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc =	this.mkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd =	this.polEtd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo =	this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt =	this.ftEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLocCd =	this.subLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd =	this.rccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg =	this.plstFlrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm =	this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt =	this.mftDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd =	this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftDys =	this.ftDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scRfaNo =	this.scRfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pwgt =	this.pwgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnee =	this.cnee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg =	this.imdtExtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpr =	this.shpr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd =	this.rfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsClrFlg =	this.cstmsClrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstr_usg_lbl_nm =	this.rstr_usg_lbl_nm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstr_usg_lbl_tp =	this.rstr_usg_lbl_tp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstr_usg_lbl_desc =	this.rstr_usg_lbl_desc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apnt_bkg_no =	this.apnt_bkg_no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMkrSeq =	this.rfMkrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMdlNm =	this.rfMdlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfHumidCtrlValCd =	this.rfHumidCtrlValCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmt_no =	this.agmt_no.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor_cd =	this.lessor_cd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt =	this.dmgFlgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt =	this.dmgUnflgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refId =	this.refId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrGrsWgt =	this.cntrGrsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tareWgt =	this.tareWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payLoad =	this.payLoad.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd =	this.cgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}