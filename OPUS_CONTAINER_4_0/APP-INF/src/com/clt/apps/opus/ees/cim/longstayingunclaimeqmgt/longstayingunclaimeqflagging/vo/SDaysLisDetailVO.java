/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SDaysLisDetailVO.java
 *@FileTitle : SDaysLisDetailVO
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
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class SDaysLisDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SDaysLisDetailVO>  models =	new	ArrayList<SDaysLisDetailVO>();


	/*	Column Info	*/
	private  String	 ntfy   =  null;
	/*	Column Info	*/
	private  String	 actDys   =  null;
	/*	Column Info	*/
	private  String	 gwgt   =  null;
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
	private  String	 stayDays11   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 stayDays12   =  null;
	/*	Column Info	*/
	private  String	 cnmvEvntDt   =  null;
	/*	Column Info	*/
	private  String	 oblRdemFlg   =  null;
	/*	Column Info	*/
	private  String	 stayDays13   =  null;
	/*	Column Info	*/
	private  String	 stayDays14   =  null;
	/*	Column Info	*/
	private  String	 stayDays15   =  null;
	/*	Column Info	*/
	private  String	 stayDays3   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 stayDays2   =  null;
	/*	Column Info	*/
	private  String	 dispFlg   =  null;
	/*	Column Info	*/
	private  String	 stayDays1   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 uclmLsDivCd   =  null;
	/*	Column Info	*/
	private  String	 stayDays7   =  null;
	/*	Column Info	*/
	private  String	 stayDays6   =  null;
	/*	Column Info	*/
	private  String	 stayDays10   =  null;
	/*	Column Info	*/
	private  String	 stayDays5   =  null;
	/*	Column Info	*/
	private  String	 stayDays4   =  null;
	/*	Column Info	*/
	private  String	 nextVvd   =  null;
	/*	Column Info	*/
	private  String	 fullFlg   =  null;
	/*	Column Info	*/
	private  String	 stayDays9   =  null;
	/*	Column Info	*/
	private  String	 stayDays8   =  null;
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
	private  String	 totDays   =  null;
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
	private  String	 orgYdCd   =  null;
	/*	Column Info	*/
	private  String	 plstFlrFlg   =  null;
	/*	Column Info	*/
	private  String	 cmdtNm   =  null;
	/*	Column Info	*/
	private  String	 mftDt   =  null;
	/*	Column Info	*/
	private  String	 deTermCd   =  null;
	/*	Column Info	*/
	private  String	 mvmtStsCd   =  null;
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
	private  String	 vndrCd   =  null;
	/*	Column Info	*/
	private  String	 vndrNm   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 slnCd   =  null;
	/*	Column Info	*/
	private  String	 slnLaneCd   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 dmgFlgDt   =  null;
	/*	Column Info	*/
	private  String	 dmgUnflgDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SDaysLisDetailVO(){}

	public SDaysLisDetailVO(String ntfy,String actDys,String gwgt,String twgt,String blNo,String pagerows,String polCd,String frtCltFlg,String scNo,String mnrHngrBarTpCd,String cntrTpszCd,String cntrHngrBarAtchKnt,String obSlsOfcCd,String lstmCd,String uclmLsFlg,String repCmdtNm,String lessor,String cnmvDt,String stayDays11,String delCd,String stayDays12,String cnmvEvntDt,String oblRdemFlg,String stayDays13,String stayDays14,String stayDays15,String stayDays3,String vvd,String podCd,String stayDays2,String dispFlg,String stayDays1,String bkgNo,String uclmLsDivCd,String stayDays7,String stayDays6,String stayDays10,String stayDays5,String stayDays4,String nextVvd,String fullFlg,String stayDays9,String stayDays8,String stayDays,String cntrHngrRckCd,String pkupNo,String porCd,String crntYdCd,String totDays,String dtyFreeDt,String dmgFlg,String mkDesc,String polEtd,String rfaNo,String cnmvStsCd,String ibflag,String ftEndDt,String subLocCd,String orgYdCd,String plstFlrFlg,String cmdtNm,String mftDt,String deTermCd,String mvmtStsCd,String ftDys,String scRfaNo,String cntrNo,String pwgt,String seq,String cnee,String imdtExtFlg,String shpr,String rfTpCd,String cstmsClrFlg,String vndrCd,String vndrNm,String agmtNo,String slnCd,String slnLaneCd,String svcScpCd,String dmgFlgDt,String dmgUnflgDt)	{
		this.ntfy  = ntfy ;
		this.actDys  = actDys ;
		this.gwgt  = gwgt ;
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
		this.stayDays11  = stayDays11 ;
		this.delCd  = delCd ;
		this.stayDays12  = stayDays12 ;
		this.cnmvEvntDt  = cnmvEvntDt ;
		this.oblRdemFlg  = oblRdemFlg ;
		this.stayDays13  = stayDays13 ;
		this.stayDays14  = stayDays14 ;
		this.stayDays15  = stayDays15 ;
		this.stayDays3  = stayDays3 ;
		this.vvd  = vvd ;
		this.podCd  = podCd ;
		this.stayDays2  = stayDays2 ;
		this.dispFlg  = dispFlg ;
		this.stayDays1  = stayDays1 ;
		this.bkgNo  = bkgNo ;
		this.uclmLsDivCd  = uclmLsDivCd ;
		this.stayDays7  = stayDays7 ;
		this.stayDays6  = stayDays6 ;
		this.stayDays10  = stayDays10 ;
		this.stayDays5  = stayDays5 ;
		this.stayDays4  = stayDays4 ;
		this.nextVvd  = nextVvd ;
		this.fullFlg  = fullFlg ;
		this.stayDays9  = stayDays9 ;
		this.stayDays8  = stayDays8 ;
		this.stayDays  = stayDays ;
		this.cntrHngrRckCd  = cntrHngrRckCd ;
		this.pkupNo  = pkupNo ;
		this.porCd  = porCd ;
		this.crntYdCd  = crntYdCd ;
		this.totDays  = totDays ;
		this.dtyFreeDt  = dtyFreeDt ;
		this.dmgFlg  = dmgFlg ;
		this.mkDesc  = mkDesc ;
		this.polEtd  = polEtd ;
		this.rfaNo  = rfaNo ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.ibflag  = ibflag ;
		this.ftEndDt  = ftEndDt ;
		this.subLocCd  = subLocCd ;
		this.orgYdCd  = orgYdCd ;
		this.plstFlrFlg  = plstFlrFlg ;
		this.cmdtNm  = cmdtNm ;
		this.mftDt  = mftDt ;
		this.deTermCd  = deTermCd ;
		this.mvmtStsCd  = mvmtStsCd ;
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
		this.vndrCd  = vndrCd ;
		this.vndrNm  = vndrNm ;
		this.agmtNo  = agmtNo ;
		this.slnCd  = slnCd ;
		this.slnLaneCd  = slnLaneCd ;
		this.svcScpCd  = svcScpCd ;
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
		this.hashColumns.put("gwgt", getGwgt());		
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
		this.hashColumns.put("stay_days11", getStayDays11());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("stay_days12", getStayDays12());		
		this.hashColumns.put("cnmv_evnt_dt", getCnmvEvntDt());		
		this.hashColumns.put("obl_rdem_flg", getOblRdemFlg());		
		this.hashColumns.put("stay_days13", getStayDays13());		
		this.hashColumns.put("stay_days14", getStayDays14());		
		this.hashColumns.put("stay_days15", getStayDays15());		
		this.hashColumns.put("stay_days3", getStayDays3());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("stay_days2", getStayDays2());		
		this.hashColumns.put("disp_flg", getDispFlg());		
		this.hashColumns.put("stay_days1", getStayDays1());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());		
		this.hashColumns.put("stay_days7", getStayDays7());		
		this.hashColumns.put("stay_days6", getStayDays6());		
		this.hashColumns.put("stay_days10", getStayDays10());		
		this.hashColumns.put("stay_days5", getStayDays5());		
		this.hashColumns.put("stay_days4", getStayDays4());		
		this.hashColumns.put("next_vvd", getNextVvd());		
		this.hashColumns.put("full_flg", getFullFlg());		
		this.hashColumns.put("stay_days9", getStayDays9());		
		this.hashColumns.put("stay_days8", getStayDays8());		
		this.hashColumns.put("stay_days", getStayDays());		
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());		
		this.hashColumns.put("pkup_no", getPkupNo());		
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("tot_days", getTotDays());		
		this.hashColumns.put("dty_free_dt", getDtyFreeDt());		
		this.hashColumns.put("dmg_flg", getDmgFlg());		
		this.hashColumns.put("mk_desc", getMkDesc());		
		this.hashColumns.put("pol_etd", getPolEtd());		
		this.hashColumns.put("rfa_no", getRfaNo());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ft_end_dt", getFtEndDt());		
		this.hashColumns.put("sub_loc_cd", getSubLocCd());		
		this.hashColumns.put("org_yd_cd", getOrgYdCd());		
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());		
		this.hashColumns.put("cmdt_nm", getCmdtNm());		
		this.hashColumns.put("mft_dt", getMftDt());		
		this.hashColumns.put("de_term_cd", getDeTermCd());		
		this.hashColumns.put("mvmt_sts_cd", getMvmtStsCd());		
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
		this.hashColumns.put("vndr_cd", getVndrCd());		
		this.hashColumns.put("vndr_nm", getVndrNm());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("sln_cd", getSlnCd());		
		this.hashColumns.put("sln_lane_cd", getSlnLaneCd());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
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
		this.hashFields.put("gwgt", "gwgt");
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
		this.hashFields.put("stay_days11", "stayDays11");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("stay_days12", "stayDays12");
		this.hashFields.put("cnmv_evnt_dt", "cnmvEvntDt");
		this.hashFields.put("obl_rdem_flg", "oblRdemFlg");
		this.hashFields.put("stay_days13", "stayDays13");
		this.hashFields.put("stay_days14", "stayDays14");
		this.hashFields.put("stay_days15", "stayDays15");
		this.hashFields.put("stay_days3", "stayDays3");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("stay_days2", "stayDays2");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("stay_days1", "stayDays1");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("stay_days7", "stayDays7");
		this.hashFields.put("stay_days6", "stayDays6");
		this.hashFields.put("stay_days10", "stayDays10");
		this.hashFields.put("stay_days5", "stayDays5");
		this.hashFields.put("stay_days4", "stayDays4");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("stay_days9", "stayDays9");
		this.hashFields.put("stay_days8", "stayDays8");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("pkup_no", "pkupNo");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("tot_days", "totDays");
		this.hashFields.put("dty_free_dt", "dtyFreeDt");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("pol_etd", "polEtd");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ft_end_dt", "ftEndDt");
		this.hashFields.put("sub_loc_cd", "subLocCd");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("mft_dt", "mftDt");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("mvmt_sts_cd", "mvmtStsCd");
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
		this.hashFields.put("vndr_cd", "vndrCd");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("sln_cd", "slnCd");
		this.hashFields.put("sln_lane_cd", "slnLaneCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
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
	* @param  stayDays11
	*/
	public void	setStayDays11( String	stayDays11 ) {
		this.stayDays11 =	stayDays11;
	}
 
	/**
	 * Column Info
	 * @return	stayDays11
	 */
	 public	 String	getStayDays11() {
		 return	this.stayDays11;
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
	* @param  stayDays12
	*/
	public void	setStayDays12( String	stayDays12 ) {
		this.stayDays12 =	stayDays12;
	}
 
	/**
	 * Column Info
	 * @return	stayDays12
	 */
	 public	 String	getStayDays12() {
		 return	this.stayDays12;
	 } 
 	/**
	* Column Info
	* @param  cnmvEvntDt
	*/
	public void	setCnmvEvntDt( String	cnmvEvntDt ) {
		this.cnmvEvntDt =	cnmvEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvEvntDt
	 */
	 public	 String	getCnmvEvntDt() {
		 return	this.cnmvEvntDt;
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
	* @param  stayDays13
	*/
	public void	setStayDays13( String	stayDays13 ) {
		this.stayDays13 =	stayDays13;
	}
 
	/**
	 * Column Info
	 * @return	stayDays13
	 */
	 public	 String	getStayDays13() {
		 return	this.stayDays13;
	 } 
 	/**
	* Column Info
	* @param  stayDays14
	*/
	public void	setStayDays14( String	stayDays14 ) {
		this.stayDays14 =	stayDays14;
	}
 
	/**
	 * Column Info
	 * @return	stayDays14
	 */
	 public	 String	getStayDays14() {
		 return	this.stayDays14;
	 } 
 	/**
	* Column Info
	* @param  stayDays15
	*/
	public void	setStayDays15( String	stayDays15 ) {
		this.stayDays15 =	stayDays15;
	}
 
	/**
	 * Column Info
	 * @return	stayDays15
	 */
	 public	 String	getStayDays15() {
		 return	this.stayDays15;
	 } 
 	/**
	* Column Info
	* @param  stayDays3
	*/
	public void	setStayDays3( String	stayDays3 ) {
		this.stayDays3 =	stayDays3;
	}
 
	/**
	 * Column Info
	 * @return	stayDays3
	 */
	 public	 String	getStayDays3() {
		 return	this.stayDays3;
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
	* @param  stayDays2
	*/
	public void	setStayDays2( String	stayDays2 ) {
		this.stayDays2 =	stayDays2;
	}
 
	/**
	 * Column Info
	 * @return	stayDays2
	 */
	 public	 String	getStayDays2() {
		 return	this.stayDays2;
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
	* @param  stayDays1
	*/
	public void	setStayDays1( String	stayDays1 ) {
		this.stayDays1 =	stayDays1;
	}
 
	/**
	 * Column Info
	 * @return	stayDays1
	 */
	 public	 String	getStayDays1() {
		 return	this.stayDays1;
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
	* @param  stayDays7
	*/
	public void	setStayDays7( String	stayDays7 ) {
		this.stayDays7 =	stayDays7;
	}
 
	/**
	 * Column Info
	 * @return	stayDays7
	 */
	 public	 String	getStayDays7() {
		 return	this.stayDays7;
	 } 
 	/**
	* Column Info
	* @param  stayDays6
	*/
	public void	setStayDays6( String	stayDays6 ) {
		this.stayDays6 =	stayDays6;
	}
 
	/**
	 * Column Info
	 * @return	stayDays6
	 */
	 public	 String	getStayDays6() {
		 return	this.stayDays6;
	 } 
 	/**
	* Column Info
	* @param  stayDays10
	*/
	public void	setStayDays10( String	stayDays10 ) {
		this.stayDays10 =	stayDays10;
	}
 
	/**
	 * Column Info
	 * @return	stayDays10
	 */
	 public	 String	getStayDays10() {
		 return	this.stayDays10;
	 } 
 	/**
	* Column Info
	* @param  stayDays5
	*/
	public void	setStayDays5( String	stayDays5 ) {
		this.stayDays5 =	stayDays5;
	}
 
	/**
	 * Column Info
	 * @return	stayDays5
	 */
	 public	 String	getStayDays5() {
		 return	this.stayDays5;
	 } 
 	/**
	* Column Info
	* @param  stayDays4
	*/
	public void	setStayDays4( String	stayDays4 ) {
		this.stayDays4 =	stayDays4;
	}
 
	/**
	 * Column Info
	 * @return	stayDays4
	 */
	 public	 String	getStayDays4() {
		 return	this.stayDays4;
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
	* @param  stayDays9
	*/
	public void	setStayDays9( String	stayDays9 ) {
		this.stayDays9 =	stayDays9;
	}
 
	/**
	 * Column Info
	 * @return	stayDays9
	 */
	 public	 String	getStayDays9() {
		 return	this.stayDays9;
	 } 
 	/**
	* Column Info
	* @param  stayDays8
	*/
	public void	setStayDays8( String	stayDays8 ) {
		this.stayDays8 =	stayDays8;
	}
 
	/**
	 * Column Info
	 * @return	stayDays8
	 */
	 public	 String	getStayDays8() {
		 return	this.stayDays8;
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
	* @param  totDays
	*/
	public void	setTotDays( String	totDays ) {
		this.totDays =	totDays;
	}
 
	/**
	 * Column Info
	 * @return	totDays
	 */
	 public	 String	getTotDays() {
		 return	this.totDays;
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
	* @param  orgYdCd
	*/
	public void	setOrgYdCd( String	orgYdCd ) {
		this.orgYdCd =	orgYdCd;
	}
 
	/**
	 * Column Info
	 * @return	orgYdCd
	 */
	 public	 String	getOrgYdCd() {
		 return	this.orgYdCd;
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
	* @param  vndrCd
	*/
	public void	setVndrCd( String	vndrCd ) {
		this.vndrCd =	vndrCd;
	}
 
	/**
	 * Column Info
	 * @return	vndrCd
	 */
	 public	 String	getVndrCd() {
		 return	this.vndrCd;
	 } 
 	/**
	* Column Info
	* @param  vndrNm
	*/
	public void	setVndrNm( String	vndrNm ) {
		this.vndrNm =	vndrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrNm
	 */
	 public	 String	getVndrNm() {
		 return	this.vndrNm;
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
	* @param  slnCd
	*/
	public void	setSlnCd( String	slnCd ) {
		this.slnCd =	slnCd;
	}
 
	/**
	 * Column Info
	 * @return	slnCd
	 */
	 public	 String	getSlnCd() {
		 return	this.slnCd;
	 } 
 	/**
	* Column Info
	* @param  slnLaneCd
	*/
	public void	setSlnLaneCd( String	slnLaneCd ) {
		this.slnLaneCd =	slnLaneCd;
	}
 
	/**
	 * Column Info
	 * @return	slnLaneCd
	 */
	 public	 String	getSlnLaneCd() {
		 return	this.slnLaneCd;
	 } 
 	/**
	* Column Info
	* @param  svcScpCd
	*/
	public void	setSvcScpCd( String	svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 
	/**
	 * Column Info
	 * @return	svcScpCd
	 */
	 public	 String	getSvcScpCd() {
		 return	this.svcScpCd;
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
		setGwgt(JSPUtil.getParameter(request,	prefix + "gwgt", ""));
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
		setStayDays11(JSPUtil.getParameter(request,	prefix + "stay_days11", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setStayDays12(JSPUtil.getParameter(request,	prefix + "stay_days12", ""));
		setCnmvEvntDt(JSPUtil.getParameter(request,	prefix + "cnmv_evnt_dt", ""));
		setOblRdemFlg(JSPUtil.getParameter(request,	prefix + "obl_rdem_flg", ""));
		setStayDays13(JSPUtil.getParameter(request,	prefix + "stay_days13", ""));
		setStayDays14(JSPUtil.getParameter(request,	prefix + "stay_days14", ""));
		setStayDays15(JSPUtil.getParameter(request,	prefix + "stay_days15", ""));
		setStayDays3(JSPUtil.getParameter(request,	prefix + "stay_days3", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setStayDays2(JSPUtil.getParameter(request,	prefix + "stay_days2", ""));
		setDispFlg(JSPUtil.getParameter(request,	prefix + "disp_flg", ""));
		setStayDays1(JSPUtil.getParameter(request,	prefix + "stay_days1", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request,	prefix + "uclm_ls_div_cd", ""));
		setStayDays7(JSPUtil.getParameter(request,	prefix + "stay_days7", ""));
		setStayDays6(JSPUtil.getParameter(request,	prefix + "stay_days6", ""));
		setStayDays10(JSPUtil.getParameter(request,	prefix + "stay_days10", ""));
		setStayDays5(JSPUtil.getParameter(request,	prefix + "stay_days5", ""));
		setStayDays4(JSPUtil.getParameter(request,	prefix + "stay_days4", ""));
		setNextVvd(JSPUtil.getParameter(request,	prefix + "next_vvd", ""));
		setFullFlg(JSPUtil.getParameter(request,	prefix + "full_flg", ""));
		setStayDays9(JSPUtil.getParameter(request,	prefix + "stay_days9", ""));
		setStayDays8(JSPUtil.getParameter(request,	prefix + "stay_days8", ""));
		setStayDays(JSPUtil.getParameter(request,	prefix + "stay_days", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request,	prefix + "cntr_hngr_rck_cd", ""));
		setPkupNo(JSPUtil.getParameter(request,	prefix + "pkup_no", ""));
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setTotDays(JSPUtil.getParameter(request,	prefix + "tot_days", ""));
		setDtyFreeDt(JSPUtil.getParameter(request,	prefix + "dty_free_dt", ""));
		setDmgFlg(JSPUtil.getParameter(request,	prefix + "dmg_flg", ""));
		setMkDesc(JSPUtil.getParameter(request,	prefix + "mk_desc", ""));
		setPolEtd(JSPUtil.getParameter(request,	prefix + "pol_etd", ""));
		setRfaNo(JSPUtil.getParameter(request,	prefix + "rfa_no", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setFtEndDt(JSPUtil.getParameter(request,	prefix + "ft_end_dt", ""));
		setSubLocCd(JSPUtil.getParameter(request,	prefix + "sub_loc_cd", ""));
		setOrgYdCd(JSPUtil.getParameter(request,	prefix + "org_yd_cd", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request,	prefix + "plst_flr_flg", ""));
		setCmdtNm(JSPUtil.getParameter(request,	prefix + "cmdt_nm", ""));
		setMftDt(JSPUtil.getParameter(request,	prefix + "mft_dt", ""));
		setDeTermCd(JSPUtil.getParameter(request,	prefix + "de_term_cd", ""));
		setMvmtStsCd(JSPUtil.getParameter(request,	prefix + "mvmt_sts_cd", ""));
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
		setVndrCd(JSPUtil.getParameter(request,	prefix + "vndr_cd", ""));
		setVndrNm(JSPUtil.getParameter(request,	prefix + "vndr_nm", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setSlnCd(JSPUtil.getParameter(request,	prefix + "sln_cd", ""));
		setSlnLaneCd(JSPUtil.getParameter(request,	prefix + "sln_lane_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setDmgFlgDt(JSPUtil.getParameter(request,	prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request,	prefix + "dmg_unflg_dt", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return SDaysLisDetailVO[]
	 */
	public SDaysLisDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return SDaysLisDetailVO[]
	 */
	public SDaysLisDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SDaysLisDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ntfy =	(JSPUtil.getParameter(request, prefix +	"ntfy".trim(),	length));
				String[] actDys =	(JSPUtil.getParameter(request, prefix +	"act_dys".trim(),	length));
				String[] gwgt =	(JSPUtil.getParameter(request, prefix +	"gwgt".trim(),	length));
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
				String[] stayDays11 =	(JSPUtil.getParameter(request, prefix +	"stay_days11".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] stayDays12 =	(JSPUtil.getParameter(request, prefix +	"stay_days12".trim(),	length));
				String[] cnmvEvntDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_evnt_dt".trim(),	length));
				String[] oblRdemFlg =	(JSPUtil.getParameter(request, prefix +	"obl_rdem_flg".trim(),	length));
				String[] stayDays13 =	(JSPUtil.getParameter(request, prefix +	"stay_days13".trim(),	length));
				String[] stayDays14 =	(JSPUtil.getParameter(request, prefix +	"stay_days14".trim(),	length));
				String[] stayDays15 =	(JSPUtil.getParameter(request, prefix +	"stay_days15".trim(),	length));
				String[] stayDays3 =	(JSPUtil.getParameter(request, prefix +	"stay_days3".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] stayDays2 =	(JSPUtil.getParameter(request, prefix +	"stay_days2".trim(),	length));
				String[] dispFlg =	(JSPUtil.getParameter(request, prefix +	"disp_flg".trim(),	length));
				String[] stayDays1 =	(JSPUtil.getParameter(request, prefix +	"stay_days1".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] uclmLsDivCd =	(JSPUtil.getParameter(request, prefix +	"uclm_ls_div_cd".trim(),	length));
				String[] stayDays7 =	(JSPUtil.getParameter(request, prefix +	"stay_days7".trim(),	length));
				String[] stayDays6 =	(JSPUtil.getParameter(request, prefix +	"stay_days6".trim(),	length));
				String[] stayDays10 =	(JSPUtil.getParameter(request, prefix +	"stay_days10".trim(),	length));
				String[] stayDays5 =	(JSPUtil.getParameter(request, prefix +	"stay_days5".trim(),	length));
				String[] stayDays4 =	(JSPUtil.getParameter(request, prefix +	"stay_days4".trim(),	length));
				String[] nextVvd =	(JSPUtil.getParameter(request, prefix +	"next_vvd".trim(),	length));
				String[] fullFlg =	(JSPUtil.getParameter(request, prefix +	"full_flg".trim(),	length));
				String[] stayDays9 =	(JSPUtil.getParameter(request, prefix +	"stay_days9".trim(),	length));
				String[] stayDays8 =	(JSPUtil.getParameter(request, prefix +	"stay_days8".trim(),	length));
				String[] stayDays =	(JSPUtil.getParameter(request, prefix +	"stay_days".trim(),	length));
				String[] cntrHngrRckCd =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_rck_cd".trim(),	length));
				String[] pkupNo =	(JSPUtil.getParameter(request, prefix +	"pkup_no".trim(),	length));
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] totDays =	(JSPUtil.getParameter(request, prefix +	"tot_days".trim(),	length));
				String[] dtyFreeDt =	(JSPUtil.getParameter(request, prefix +	"dty_free_dt".trim(),	length));
				String[] dmgFlg =	(JSPUtil.getParameter(request, prefix +	"dmg_flg".trim(),	length));
				String[] mkDesc =	(JSPUtil.getParameter(request, prefix +	"mk_desc".trim(),	length));
				String[] polEtd =	(JSPUtil.getParameter(request, prefix +	"pol_etd".trim(),	length));
				String[] rfaNo =	(JSPUtil.getParameter(request, prefix +	"rfa_no".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] ftEndDt =	(JSPUtil.getParameter(request, prefix +	"ft_end_dt".trim(),	length));
				String[] subLocCd =	(JSPUtil.getParameter(request, prefix +	"sub_loc_cd".trim(),	length));
				String[] orgYdCd =	(JSPUtil.getParameter(request, prefix +	"org_yd_cd".trim(),	length));
				String[] plstFlrFlg =	(JSPUtil.getParameter(request, prefix +	"plst_flr_flg".trim(),	length));
				String[] cmdtNm =	(JSPUtil.getParameter(request, prefix +	"cmdt_nm".trim(),	length));
				String[] mftDt =	(JSPUtil.getParameter(request, prefix +	"mft_dt".trim(),	length));
				String[] deTermCd =	(JSPUtil.getParameter(request, prefix +	"de_term_cd".trim(),	length));
				String[] mvmtStsCd =	(JSPUtil.getParameter(request, prefix +	"mvmt_sts_cd".trim(),	length));
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
				String[] vndrCd =	(JSPUtil.getParameter(request, prefix +	"vndr_cd".trim(),	length));
				String[] vndrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_nm".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] slnCd =	(JSPUtil.getParameter(request, prefix +	"sln_cd".trim(),	length));
				String[] slnLaneCd =	(JSPUtil.getParameter(request, prefix +	"sln_lane_cd".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] dmgFlgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_flg_dt".trim(),	length));
				String[] dmgUnflgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_unflg_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SDaysLisDetailVO();
						if ( ntfy[i] !=	null)
						model.setNtfy( ntfy[i]);
						if ( actDys[i] !=	null)
						model.setActDys( actDys[i]);
						if ( gwgt[i] !=	null)
						model.setGwgt( gwgt[i]);
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
						if ( stayDays11[i] !=	null)
						model.setStayDays11( stayDays11[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( stayDays12[i] !=	null)
						model.setStayDays12( stayDays12[i]);
						if ( cnmvEvntDt[i] !=	null)
						model.setCnmvEvntDt( cnmvEvntDt[i]);
						if ( oblRdemFlg[i] !=	null)
						model.setOblRdemFlg( oblRdemFlg[i]);
						if ( stayDays13[i] !=	null)
						model.setStayDays13( stayDays13[i]);
						if ( stayDays14[i] !=	null)
						model.setStayDays14( stayDays14[i]);
						if ( stayDays15[i] !=	null)
						model.setStayDays15( stayDays15[i]);
						if ( stayDays3[i] !=	null)
						model.setStayDays3( stayDays3[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( stayDays2[i] !=	null)
						model.setStayDays2( stayDays2[i]);
						if ( dispFlg[i] !=	null)
						model.setDispFlg( dispFlg[i]);
						if ( stayDays1[i] !=	null)
						model.setStayDays1( stayDays1[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( uclmLsDivCd[i] !=	null)
						model.setUclmLsDivCd( uclmLsDivCd[i]);
						if ( stayDays7[i] !=	null)
						model.setStayDays7( stayDays7[i]);
						if ( stayDays6[i] !=	null)
						model.setStayDays6( stayDays6[i]);
						if ( stayDays10[i] !=	null)
						model.setStayDays10( stayDays10[i]);
						if ( stayDays5[i] !=	null)
						model.setStayDays5( stayDays5[i]);
						if ( stayDays4[i] !=	null)
						model.setStayDays4( stayDays4[i]);
						if ( nextVvd[i] !=	null)
						model.setNextVvd( nextVvd[i]);
						if ( fullFlg[i] !=	null)
						model.setFullFlg( fullFlg[i]);
						if ( stayDays9[i] !=	null)
						model.setStayDays9( stayDays9[i]);
						if ( stayDays8[i] !=	null)
						model.setStayDays8( stayDays8[i]);
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
						if ( totDays[i] !=	null)
						model.setTotDays( totDays[i]);
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
						if ( orgYdCd[i] !=	null)
						model.setOrgYdCd( orgYdCd[i]);
						if ( plstFlrFlg[i] !=	null)
						model.setPlstFlrFlg( plstFlrFlg[i]);
						if ( cmdtNm[i] !=	null)
						model.setCmdtNm( cmdtNm[i]);
						if ( mftDt[i] !=	null)
						model.setMftDt( mftDt[i]);
						if ( deTermCd[i] !=	null)
						model.setDeTermCd( deTermCd[i]);
						if ( mvmtStsCd[i] !=	null)
						model.setMvmtStsCd( mvmtStsCd[i]);
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
						if ( vndrCd[i] !=	null)
						model.setVndrCd( vndrCd[i]);
						if ( vndrNm[i] !=	null)
						model.setVndrNm( vndrNm[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( slnCd[i] !=	null)
						model.setSlnCd( slnCd[i]);
						if ( slnLaneCd[i] !=	null)
						model.setSlnLaneCd( slnLaneCd[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( dmgFlgDt[i] !=	null)
						model.setDmgFlgDt( dmgFlgDt[i]);
						if ( dmgUnflgDt[i] !=	null)
						model.setDmgUnflgDt( dmgUnflgDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSDaysLisDetailVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return SDaysLisDetailVO[]
	 */
	public SDaysLisDetailVO[]	 getSDaysLisDetailVOs(){
		SDaysLisDetailVO[] vos = (SDaysLisDetailVO[])models.toArray(new	SDaysLisDetailVO[models.size()]);
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
		this.stayDays11 =	this.stayDays11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays12 =	this.stayDays12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvEvntDt =	this.cnmvEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRdemFlg =	this.oblRdemFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays13 =	this.stayDays13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays14 =	this.stayDays14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays15 =	this.stayDays15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays3 =	this.stayDays3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays2 =	this.stayDays2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg =	this.dispFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays1 =	this.stayDays1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd =	this.uclmLsDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays7 =	this.stayDays7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays6 =	this.stayDays6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays10 =	this.stayDays10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays5 =	this.stayDays5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays4 =	this.stayDays4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd =	this.nextVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg =	this.fullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays9 =	this.stayDays9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays8 =	this.stayDays8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays =	this.stayDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd =	this.cntrHngrRckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupNo =	this.pkupNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totDays =	this.totDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtyFreeDt =	this.dtyFreeDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg =	this.dmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc =	this.mkDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polEtd =	this.polEtd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo =	this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftEndDt =	this.ftEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subLocCd =	this.subLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd =	this.orgYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg =	this.plstFlrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm =	this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt =	this.mftDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd =	this.deTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mvmtStsCd =	this.mvmtStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
		this.vndrCd =	this.vndrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm =	this.vndrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slnCd =	this.slnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slnLaneCd =	this.slnLaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt =	this.dmgFlgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt =	this.dmgUnflgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}