/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvtOptionVO.java
 *@FileTitle : InvtOptionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.08.21
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.08.21  
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
public class InvtOptionVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvtOptionVO>  models =	new	ArrayList<InvtOptionVO>();


	/*	Column Info	*/
	private  String	 cntrTpszCd14   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd15   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd16   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd17   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd18   =  null;
	/*	Column Info	*/
	private  String	 toDur   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd19   =  null;
	/*	Column Info	*/
	private  String	 rfTpCdReefer   =  null;
	/*	Column Info	*/
	private  String	 rccDate   =  null;
	/*	Column Info	*/
	private  String	 viewFlg   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 rfCntr   =  null;
	/*	Column Info	*/
	private  String	 rfTpCdM   =  null;
	/*	Column Info	*/
	private  String	 cntCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 tpCd   =  null;
	/*	Column Info	*/
	private  String	 rfTpCdC   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrBarAtchKnt   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd11   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd10   =  null;
	/*	Column Info	*/
	private  String	 rfTpCdH   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd13   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd12   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd27   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd28   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd25   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd26   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrRckCdO   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd29   =  null;
	/*	Column Info	*/
	private  String	 toPrd   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 vvd2   =  null;
	/*	Column Info	*/
	private  String	 viewCustomer   =  null;
	/*	Column Info	*/
	private  String	 vvd3   =  null;
	/*	Column Info	*/
	private  String	 queryStr   =  null;
	/*	Column Info	*/
	private  String	 vvd1   =  null;
	/*	Column Info	*/
	private  String	 tsCntrBehind   =  null;
	/*	Column Info	*/
	private  String	 bseDt   =  null;
	/*	Column Info	*/
	private  String	 toBseDt   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 dispFlg   =  null;
	/*	Column Info	*/
	private  String	 overStayDays   =  null;
	/*	Column Info	*/
	private  String	 overFreeDays   =  null;
	/*	Column Info	*/
	private  String	 uclmLsDivCd   =  null;
	/*	Column Info	*/
	private  String	 lvl   =  null;
	/*	Column Info	*/
	private  String	 yardCd   =  null;
	/*	Column Info	*/
	private  String	 longStayCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd20   =  null;
	/*	Column Info	*/
	private  String	 nextVvd   =  null;
	/*	Column Info	*/
	private  String	 fullFlg   =  null;
	/*	Column Info	*/
	private  String	 stayDays   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd24   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd23   =  null;
	/*	Column Info	*/
	private  String	 fmStkJbDt   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrRckCdR   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd22   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd21   =  null;
	/*	Column Info	*/
	private  String	 cntrHngrRckCd   =  null;
	/*	Column Info	*/
	private  String	 headCntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntrUseCoCd   =  null;
	/*	Column Info	*/
	private  String	 rdCgoFlg   =  null;
	/*	Column Info	*/
	private  String	 routeTpCd   =  null;
	/*	Column Info	*/
	private  String	 dmgFlg   =  null;
	/*	Column Info	*/
	private  String	 locTypeCode   =  null;
	/*	Column Info	*/
	private  String	 opTrndTpCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 fromBseDt   =  null;
	/*	Column Info	*/
	private  String	 objCntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 toStkJbDt   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd30   =  null;
	/*	Column Info	*/
	private  String	 coCd   =  null;
	/*	Column Info	*/
	private  String	 fmPrd   =  null;
	/*	Column Info	*/
	private  String	 polPodWise   =  null;
	/*	Column Info	*/
	private  String	 d2PayldFlg   =  null;
	/*	Column Info	*/
	private  String	 rccCd   =  null;
	/*	Column Info	*/
	private  String	 plstFlrFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd6   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd5   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd8   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd7   =  null;
	/*	Column Info	*/
	private  String	 viewCommodity   =  null;
	/*	Column Info	*/
	private  String	 socCd   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd9   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 imdtExtFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd2   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd1   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd4   =  null;
	/*	Column Info	*/
	private  String	 fmDur   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd3   =  null;
	/*	Column Info	*/
	private  String	 froms   =  null;
	/*	Column Info	*/
	private  String	 tos   =  null;
	/*	Column Info	*/
	private  String	 rstr_usg_lbl   =  null;
	/*	Column Info	*/
	private  String	 ru_lable_type   =  null;
	/*	Column Info	*/
	private  String	 cgoTpCd   =  null;
	/* Column Info */
	private int iPage = 1;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvtOptionVO(){}

	public InvtOptionVO(String cntrTpszCd14,String cntrTpszCd15,String cntrTpszCd16,String cntrTpszCd17,String cntrTpszCd18,String toDur,String cntrTpszCd19,String rfTpCdReefer,String rccDate,String viewFlg,String pagerows,String locCd,String polCd,String rfCntr,String rfTpCdM,String cntCd,String cntrTpszCd,String tpCd,String rfTpCdC,String cntrHngrBarAtchKnt,String cntrTpszCd11,String lstmCd,String cntrTpszCd10,String rfTpCdH,String cntrTpszCd13,String cntrTpszCd12,String cntrTpszCd27,String cntrTpszCd28,String cntrTpszCd25,String cntrTpszCd26,String cntrHngrRckCdO,String cntrTpszCd29,String toPrd,String delCd,String vvd2,String viewCustomer,String vvd3,String queryStr,String vvd1,String tsCntrBehind,String bseDt,String toBseDt,String podCd,String dispFlg,String overStayDays,String overFreeDays,String uclmLsDivCd,String lvl,String yardCd,String longStayCd,String cntrTpszCd20,String nextVvd,String fullFlg,String stayDays,String cntrTpszCd24,String cntrTpszCd23,String fmStkJbDt,String cntrHngrRckCdR,String cntrTpszCd22,String cntrTpszCd21,String cntrHngrRckCd,String headCntrTpszCd,String cntrUseCoCd,String rdCgoFlg,String routeTpCd,String dmgFlg,String locTypeCode,String opTrndTpCd,String ibflag,String cnmvStsCd,String fromBseDt,String objCntrTpszCd,String toStkJbDt,String cntrTpszCd30,String coCd,String fmPrd,String polPodWise,String d2PayldFlg,String rccCd,String plstFlrFlg,String cntrTpszCd6,String cntrTpszCd5,String ofcCd,String cntrTpszCd8,String cntrTpszCd7,String viewCommodity,String socCd,String slanCd,String cntrTpszCd9,String cntrNo,String imdtExtFlg,String cntrTpszCd2,String cntrTpszCd1,String cntrTpszCd4,String fmDur,String cntrTpszCd3,String froms,String tos,String rstr_usg_lbl,String ru_lable_type,String cgoTpCd)	{
		this.cntrTpszCd14  = cntrTpszCd14 ;
		this.cntrTpszCd15  = cntrTpszCd15 ;
		this.cntrTpszCd16  = cntrTpszCd16 ;
		this.cntrTpszCd17  = cntrTpszCd17 ;
		this.cntrTpszCd18  = cntrTpszCd18 ;
		this.toDur  = toDur ;
		this.cntrTpszCd19  = cntrTpszCd19 ;
		this.rfTpCdReefer  = rfTpCdReefer ;
		this.rccDate  = rccDate ;
		this.viewFlg  = viewFlg ;
		this.pagerows  = pagerows ;
		this.locCd  = locCd ;
		this.polCd  = polCd ;
		this.rfCntr  = rfCntr ;
		this.rfTpCdM  = rfTpCdM ;
		this.cntCd  = cntCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.tpCd  = tpCd ;
		this.rfTpCdC  = rfTpCdC ;
		this.cntrHngrBarAtchKnt  = cntrHngrBarAtchKnt ;
		this.cntrTpszCd11  = cntrTpszCd11 ;
		this.lstmCd  = lstmCd ;
		this.cntrTpszCd10  = cntrTpszCd10 ;
		this.rfTpCdH  = rfTpCdH ;
		this.cntrTpszCd13  = cntrTpszCd13 ;
		this.cntrTpszCd12  = cntrTpszCd12 ;
		this.cntrTpszCd27  = cntrTpszCd27 ;
		this.cntrTpszCd28  = cntrTpszCd28 ;
		this.cntrTpszCd25  = cntrTpszCd25 ;
		this.cntrTpszCd26  = cntrTpszCd26 ;
		this.cntrHngrRckCdO  = cntrHngrRckCdO ;
		this.cntrTpszCd29  = cntrTpszCd29 ;
		this.toPrd  = toPrd ;
		this.delCd  = delCd ;
		this.vvd2  = vvd2 ;
		this.viewCustomer  = viewCustomer ;
		this.vvd3  = vvd3 ;
		this.queryStr  = queryStr ;
		this.vvd1  = vvd1 ;
		this.tsCntrBehind  = tsCntrBehind ;
		this.bseDt  = bseDt ;
		this.toBseDt  = toBseDt ;
		this.podCd  = podCd ;
		this.dispFlg  = dispFlg ;
		this.overStayDays  = overStayDays ;
		this.overFreeDays  = overFreeDays ;
		this.uclmLsDivCd  = uclmLsDivCd ;
		this.lvl  = lvl ;
		this.yardCd  = yardCd ;
		this.longStayCd  = longStayCd ;
		this.cntrTpszCd20  = cntrTpszCd20 ;
		this.nextVvd  = nextVvd ;
		this.fullFlg  = fullFlg ;
		this.stayDays  = stayDays ;
		this.cntrTpszCd24  = cntrTpszCd24 ;
		this.cntrTpszCd23  = cntrTpszCd23 ;
		this.fmStkJbDt  = fmStkJbDt ;
		this.cntrHngrRckCdR  = cntrHngrRckCdR ;
		this.cntrTpszCd22  = cntrTpszCd22 ;
		this.cntrTpszCd21  = cntrTpszCd21 ;
		this.cntrHngrRckCd  = cntrHngrRckCd ;
		this.headCntrTpszCd  = headCntrTpszCd ;
		this.cntrUseCoCd  = cntrUseCoCd ;
		this.rdCgoFlg  = rdCgoFlg ;
		this.routeTpCd  = routeTpCd ;
		this.dmgFlg  = dmgFlg ;
		this.locTypeCode  = locTypeCode ;
		this.opTrndTpCd  = opTrndTpCd ;
		this.ibflag  = ibflag ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.fromBseDt  = fromBseDt ;
		this.objCntrTpszCd  = objCntrTpszCd ;
		this.toStkJbDt  = toStkJbDt ;
		this.cntrTpszCd30  = cntrTpszCd30 ;
		this.coCd  = coCd ;
		this.fmPrd  = fmPrd ;
		this.polPodWise  = polPodWise ;
		this.d2PayldFlg  = d2PayldFlg ;
		this.rccCd  = rccCd ;
		this.plstFlrFlg  = plstFlrFlg ;
		this.cntrTpszCd6  = cntrTpszCd6 ;
		this.cntrTpszCd5  = cntrTpszCd5 ;
		this.ofcCd  = ofcCd ;
		this.cntrTpszCd8  = cntrTpszCd8 ;
		this.cntrTpszCd7  = cntrTpszCd7 ;
		this.viewCommodity  = viewCommodity ;
		this.socCd  = socCd ;
		this.slanCd  = slanCd ;
		this.cntrTpszCd9  = cntrTpszCd9 ;
		this.cntrNo  = cntrNo ;
		this.imdtExtFlg  = imdtExtFlg ;
		this.cntrTpszCd2  = cntrTpszCd2 ;
		this.cntrTpszCd1  = cntrTpszCd1 ;
		this.cntrTpszCd4  = cntrTpszCd4 ;
		this.fmDur  = fmDur ;
		this.cntrTpszCd3  = cntrTpszCd3 ;
		this.froms  = froms ;
		this.tos  = tos ;
		this.rstr_usg_lbl  = rstr_usg_lbl ;
		this.ru_lable_type  = ru_lable_type ;
		this.cgoTpCd  = cgoTpCd ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_tpsz_cd14", getCntrTpszCd14());		
		this.hashColumns.put("cntr_tpsz_cd15", getCntrTpszCd15());		
		this.hashColumns.put("cntr_tpsz_cd16", getCntrTpszCd16());		
		this.hashColumns.put("cntr_tpsz_cd17", getCntrTpszCd17());		
		this.hashColumns.put("cntr_tpsz_cd18", getCntrTpszCd18());		
		this.hashColumns.put("to_dur", getToDur());		
		this.hashColumns.put("cntr_tpsz_cd19", getCntrTpszCd19());		
		this.hashColumns.put("rf_tp_cd_reefer", getRfTpCdReefer());		
		this.hashColumns.put("rcc_date", getRccDate());		
		this.hashColumns.put("view_flg", getViewFlg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("rf_cntr", getRfCntr());		
		this.hashColumns.put("rf_tp_cd_m", getRfTpCdM());		
		this.hashColumns.put("cnt_cd", getCntCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("tp_cd", getTpCd());		
		this.hashColumns.put("rf_tp_cd_c", getRfTpCdC());		
		this.hashColumns.put("cntr_hngr_bar_atch_knt", getCntrHngrBarAtchKnt());		
		this.hashColumns.put("cntr_tpsz_cd11", getCntrTpszCd11());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("cntr_tpsz_cd10", getCntrTpszCd10());		
		this.hashColumns.put("rf_tp_cd_h", getRfTpCdH());		
		this.hashColumns.put("cntr_tpsz_cd13", getCntrTpszCd13());		
		this.hashColumns.put("cntr_tpsz_cd12", getCntrTpszCd12());		
		this.hashColumns.put("cntr_tpsz_cd27", getCntrTpszCd27());		
		this.hashColumns.put("cntr_tpsz_cd28", getCntrTpszCd28());		
		this.hashColumns.put("cntr_tpsz_cd25", getCntrTpszCd25());		
		this.hashColumns.put("cntr_tpsz_cd26", getCntrTpszCd26());		
		this.hashColumns.put("cntr_hngr_rck_cd_o", getCntrHngrRckCdO());		
		this.hashColumns.put("cntr_tpsz_cd29", getCntrTpszCd29());		
		this.hashColumns.put("to_prd", getToPrd());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("vvd2", getVvd2());		
		this.hashColumns.put("view_customer", getViewCustomer());		
		this.hashColumns.put("vvd3", getVvd3());		
		this.hashColumns.put("query_str", getQueryStr());		
		this.hashColumns.put("vvd1", getVvd1());		
		this.hashColumns.put("ts_cntr_behind", getTsCntrBehind());		
		this.hashColumns.put("bse_dt", getBseDt());		
		this.hashColumns.put("to_bse_dt", getToBseDt());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("disp_flg", getDispFlg());		
		this.hashColumns.put("over_stay_days", getOverStayDays());		
		this.hashColumns.put("over_free_days", getOverFreeDays());		
		this.hashColumns.put("uclm_ls_div_cd", getUclmLsDivCd());		
		this.hashColumns.put("lvl", getLvl());		
		this.hashColumns.put("yard_cd", getYardCd());		
		this.hashColumns.put("long_stay_cd", getLongStayCd());		
		this.hashColumns.put("cntr_tpsz_cd20", getCntrTpszCd20());		
		this.hashColumns.put("next_vvd", getNextVvd());		
		this.hashColumns.put("full_flg", getFullFlg());		
		this.hashColumns.put("stay_days", getStayDays());		
		this.hashColumns.put("cntr_tpsz_cd24", getCntrTpszCd24());		
		this.hashColumns.put("cntr_tpsz_cd23", getCntrTpszCd23());		
		this.hashColumns.put("fm_stk_jb_dt", getFmStkJbDt());		
		this.hashColumns.put("cntr_hngr_rck_cd_r", getCntrHngrRckCdR());		
		this.hashColumns.put("cntr_tpsz_cd22", getCntrTpszCd22());		
		this.hashColumns.put("cntr_tpsz_cd21", getCntrTpszCd21());		
		this.hashColumns.put("cntr_hngr_rck_cd", getCntrHngrRckCd());		
		this.hashColumns.put("head_cntr_tpsz_cd", getHeadCntrTpszCd());		
		this.hashColumns.put("cntr_use_co_cd", getCntrUseCoCd());		
		this.hashColumns.put("rd_cgo_flg", getRdCgoFlg());		
		this.hashColumns.put("route_tp_cd", getRouteTpCd());		
		this.hashColumns.put("dmg_flg", getDmgFlg());		
		this.hashColumns.put("loc_type_code", getLocTypeCode());		
		this.hashColumns.put("op_trnd_tp_cd", getOpTrndTpCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("from_bse_dt", getFromBseDt());		
		this.hashColumns.put("obj_cntr_tpsz_cd", getObjCntrTpszCd());		
		this.hashColumns.put("to_stk_jb_dt", getToStkJbDt());		
		this.hashColumns.put("cntr_tpsz_cd30", getCntrTpszCd30());		
		this.hashColumns.put("co_cd", getCoCd());		
		this.hashColumns.put("fm_prd", getFmPrd());		
		this.hashColumns.put("pol_pod_wise", getPolPodWise());		
		this.hashColumns.put("d2_payld_flg", getD2PayldFlg());		
		this.hashColumns.put("rcc_cd", getRccCd());		
		this.hashColumns.put("plst_flr_flg", getPlstFlrFlg());		
		this.hashColumns.put("cntr_tpsz_cd6", getCntrTpszCd6());		
		this.hashColumns.put("cntr_tpsz_cd5", getCntrTpszCd5());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("cntr_tpsz_cd8", getCntrTpszCd8());		
		this.hashColumns.put("cntr_tpsz_cd7", getCntrTpszCd7());		
		this.hashColumns.put("view_commodity", getViewCommodity());		
		this.hashColumns.put("soc_cd", getSocCd());		
		this.hashColumns.put("slan_cd", getSlanCd());		
		this.hashColumns.put("cntr_tpsz_cd9", getCntrTpszCd9());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("imdt_ext_flg", getImdtExtFlg());		
		this.hashColumns.put("cntr_tpsz_cd2", getCntrTpszCd2());		
		this.hashColumns.put("cntr_tpsz_cd1", getCntrTpszCd1());		
		this.hashColumns.put("cntr_tpsz_cd4", getCntrTpszCd4());		
		this.hashColumns.put("fm_dur", getFmDur());		
		this.hashColumns.put("cntr_tpsz_cd3", getCntrTpszCd3());		
		this.hashColumns.put("froms", getFroms());		
		this.hashColumns.put("tos", getTos());		
		this.hashColumns.put("rstr_usg_lbl", getRstr_usg_lbl());		
		this.hashColumns.put("ru_lable_type", getRu_lable_type());	
		this.hashColumns.put("cgo_tp_cd", getCgoTpCd());			
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cntr_tpsz_cd14", "cntrTpszCd14");
		this.hashFields.put("cntr_tpsz_cd15", "cntrTpszCd15");
		this.hashFields.put("cntr_tpsz_cd16", "cntrTpszCd16");
		this.hashFields.put("cntr_tpsz_cd17", "cntrTpszCd17");
		this.hashFields.put("cntr_tpsz_cd18", "cntrTpszCd18");
		this.hashFields.put("to_dur", "toDur");
		this.hashFields.put("cntr_tpsz_cd19", "cntrTpszCd19");
		this.hashFields.put("rf_tp_cd_reefer", "rfTpCdReefer");
		this.hashFields.put("rcc_date", "rccDate");
		this.hashFields.put("view_flg", "viewFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rf_cntr", "rfCntr");
		this.hashFields.put("rf_tp_cd_m", "rfTpCdM");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("tp_cd", "tpCd");
		this.hashFields.put("rf_tp_cd_c", "rfTpCdC");
		this.hashFields.put("cntr_hngr_bar_atch_knt", "cntrHngrBarAtchKnt");
		this.hashFields.put("cntr_tpsz_cd11", "cntrTpszCd11");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("cntr_tpsz_cd10", "cntrTpszCd10");
		this.hashFields.put("rf_tp_cd_h", "rfTpCdH");
		this.hashFields.put("cntr_tpsz_cd13", "cntrTpszCd13");
		this.hashFields.put("cntr_tpsz_cd12", "cntrTpszCd12");
		this.hashFields.put("cntr_tpsz_cd27", "cntrTpszCd27");
		this.hashFields.put("cntr_tpsz_cd28", "cntrTpszCd28");
		this.hashFields.put("cntr_tpsz_cd25", "cntrTpszCd25");
		this.hashFields.put("cntr_tpsz_cd26", "cntrTpszCd26");
		this.hashFields.put("cntr_hngr_rck_cd_o", "cntrHngrRckCdO");
		this.hashFields.put("cntr_tpsz_cd29", "cntrTpszCd29");
		this.hashFields.put("to_prd", "toPrd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("vvd2", "vvd2");
		this.hashFields.put("view_customer", "viewCustomer");
		this.hashFields.put("vvd3", "vvd3");
		this.hashFields.put("query_str", "queryStr");
		this.hashFields.put("vvd1", "vvd1");
		this.hashFields.put("ts_cntr_behind", "tsCntrBehind");
		this.hashFields.put("bse_dt", "bseDt");
		this.hashFields.put("to_bse_dt", "toBseDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("disp_flg", "dispFlg");
		this.hashFields.put("over_stay_days", "overStayDays");
		this.hashFields.put("over_free_days", "overFreeDays");
		this.hashFields.put("uclm_ls_div_cd", "uclmLsDivCd");
		this.hashFields.put("lvl", "lvl");
		this.hashFields.put("yard_cd", "yardCd");
		this.hashFields.put("long_stay_cd", "longStayCd");
		this.hashFields.put("cntr_tpsz_cd20", "cntrTpszCd20");
		this.hashFields.put("next_vvd", "nextVvd");
		this.hashFields.put("full_flg", "fullFlg");
		this.hashFields.put("stay_days", "stayDays");
		this.hashFields.put("cntr_tpsz_cd24", "cntrTpszCd24");
		this.hashFields.put("cntr_tpsz_cd23", "cntrTpszCd23");
		this.hashFields.put("fm_stk_jb_dt", "fmStkJbDt");
		this.hashFields.put("cntr_hngr_rck_cd_r", "cntrHngrRckCdR");
		this.hashFields.put("cntr_tpsz_cd22", "cntrTpszCd22");
		this.hashFields.put("cntr_tpsz_cd21", "cntrTpszCd21");
		this.hashFields.put("cntr_hngr_rck_cd", "cntrHngrRckCd");
		this.hashFields.put("head_cntr_tpsz_cd", "headCntrTpszCd");
		this.hashFields.put("cntr_use_co_cd", "cntrUseCoCd");
		this.hashFields.put("rd_cgo_flg", "rdCgoFlg");
		this.hashFields.put("route_tp_cd", "routeTpCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("loc_type_code", "locTypeCode");
		this.hashFields.put("op_trnd_tp_cd", "opTrndTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("from_bse_dt", "fromBseDt");
		this.hashFields.put("obj_cntr_tpsz_cd", "objCntrTpszCd");
		this.hashFields.put("to_stk_jb_dt", "toStkJbDt");
		this.hashFields.put("cntr_tpsz_cd30", "cntrTpszCd30");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("fm_prd", "fmPrd");
		this.hashFields.put("pol_pod_wise", "polPodWise");
		this.hashFields.put("d2_payld_flg", "d2PayldFlg");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("plst_flr_flg", "plstFlrFlg");
		this.hashFields.put("cntr_tpsz_cd6", "cntrTpszCd6");
		this.hashFields.put("cntr_tpsz_cd5", "cntrTpszCd5");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cntr_tpsz_cd8", "cntrTpszCd8");
		this.hashFields.put("cntr_tpsz_cd7", "cntrTpszCd7");
		this.hashFields.put("view_commodity", "viewCommodity");
		this.hashFields.put("soc_cd", "socCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("cntr_tpsz_cd9", "cntrTpszCd9");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("imdt_ext_flg", "imdtExtFlg");
		this.hashFields.put("cntr_tpsz_cd2", "cntrTpszCd2");
		this.hashFields.put("cntr_tpsz_cd1", "cntrTpszCd1");
		this.hashFields.put("cntr_tpsz_cd4", "cntrTpszCd4");
		this.hashFields.put("fm_dur", "fmDur");
		this.hashFields.put("cntr_tpsz_cd3", "cntrTpszCd3");
		this.hashFields.put("froms", "froms");
		this.hashFields.put("tos", "tos");
		this.hashFields.put("rstr_usg_lbl", "rstr_usg_lbl");
		this.hashFields.put("ru_lable_type", "ru_lable_type");
		this.hashFields.put("cgo_tp_cd", "cgoTpCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  cntrTpszCd14
	*/
	public void	setCntrTpszCd14( String	cntrTpszCd14 ) {
		this.cntrTpszCd14 =	cntrTpszCd14;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd14
	 */
	 public	 String	getCntrTpszCd14() {
		 return	this.cntrTpszCd14;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd15
	*/
	public void	setCntrTpszCd15( String	cntrTpszCd15 ) {
		this.cntrTpszCd15 =	cntrTpszCd15;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd15
	 */
	 public	 String	getCntrTpszCd15() {
		 return	this.cntrTpszCd15;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd16
	*/
	public void	setCntrTpszCd16( String	cntrTpszCd16 ) {
		this.cntrTpszCd16 =	cntrTpszCd16;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd16
	 */
	 public	 String	getCntrTpszCd16() {
		 return	this.cntrTpszCd16;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd17
	*/
	public void	setCntrTpszCd17( String	cntrTpszCd17 ) {
		this.cntrTpszCd17 =	cntrTpszCd17;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd17
	 */
	 public	 String	getCntrTpszCd17() {
		 return	this.cntrTpszCd17;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd18
	*/
	public void	setCntrTpszCd18( String	cntrTpszCd18 ) {
		this.cntrTpszCd18 =	cntrTpszCd18;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd18
	 */
	 public	 String	getCntrTpszCd18() {
		 return	this.cntrTpszCd18;
	 } 
 	/**
	* Column Info
	* @param  toDur
	*/
	public void	setToDur( String	toDur ) {
		this.toDur =	toDur;
	}
 
	/**
	 * Column Info
	 * @return	toDur
	 */
	 public	 String	getToDur() {
		 return	this.toDur;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd19
	*/
	public void	setCntrTpszCd19( String	cntrTpszCd19 ) {
		this.cntrTpszCd19 =	cntrTpszCd19;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd19
	 */
	 public	 String	getCntrTpszCd19() {
		 return	this.cntrTpszCd19;
	 } 
 	/**
	* Column Info
	* @param  rfTpCdReefer
	*/
	public void	setRfTpCdReefer( String	rfTpCdReefer ) {
		this.rfTpCdReefer =	rfTpCdReefer;
	}
 
	/**
	 * Column Info
	 * @return	rfTpCdReefer
	 */
	 public	 String	getRfTpCdReefer() {
		 return	this.rfTpCdReefer;
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
	* @param  viewFlg
	*/
	public void	setViewFlg( String	viewFlg ) {
		this.viewFlg =	viewFlg;
	}
 
	/**
	 * Column Info
	 * @return	viewFlg
	 */
	 public	 String	getViewFlg() {
		 return	this.viewFlg;
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
	* @param  rfCntr
	*/
	public void	setRfCntr( String	rfCntr ) {
		this.rfCntr =	rfCntr;
	}
 
	/**
	 * Column Info
	 * @return	rfCntr
	 */
	 public	 String	getRfCntr() {
		 return	this.rfCntr;
	 } 
 	/**
	* Column Info
	* @param  rfTpCdM
	*/
	public void	setRfTpCdM( String	rfTpCdM ) {
		this.rfTpCdM =	rfTpCdM;
	}
 
	/**
	 * Column Info
	 * @return	rfTpCdM
	 */
	 public	 String	getRfTpCdM() {
		 return	this.rfTpCdM;
	 } 
 	/**
	* Column Info
	* @param  cntCd
	*/
	public void	setCntCd( String	cntCd ) {
		this.cntCd =	cntCd;
	}
 
	/**
	 * Column Info
	 * @return	cntCd
	 */
	 public	 String	getCntCd() {
		 return	this.cntCd;
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
	* @param  tpCd
	*/
	public void	setTpCd( String	tpCd ) {
		this.tpCd =	tpCd;
	}
 
	/**
	 * Column Info
	 * @return	tpCd
	 */
	 public	 String	getTpCd() {
		 return	this.tpCd;
	 } 
 	/**
	* Column Info
	* @param  rfTpCdC
	*/
	public void	setRfTpCdC( String	rfTpCdC ) {
		this.rfTpCdC =	rfTpCdC;
	}
 
	/**
	 * Column Info
	 * @return	rfTpCdC
	 */
	 public	 String	getRfTpCdC() {
		 return	this.rfTpCdC;
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
	* @param  cntrTpszCd11
	*/
	public void	setCntrTpszCd11( String	cntrTpszCd11 ) {
		this.cntrTpszCd11 =	cntrTpszCd11;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd11
	 */
	 public	 String	getCntrTpszCd11() {
		 return	this.cntrTpszCd11;
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
	* @param  cntrTpszCd10
	*/
	public void	setCntrTpszCd10( String	cntrTpszCd10 ) {
		this.cntrTpszCd10 =	cntrTpszCd10;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd10
	 */
	 public	 String	getCntrTpszCd10() {
		 return	this.cntrTpszCd10;
	 } 
 	/**
	* Column Info
	* @param  rfTpCdH
	*/
	public void	setRfTpCdH( String	rfTpCdH ) {
		this.rfTpCdH =	rfTpCdH;
	}
 
	/**
	 * Column Info
	 * @return	rfTpCdH
	 */
	 public	 String	getRfTpCdH() {
		 return	this.rfTpCdH;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd13
	*/
	public void	setCntrTpszCd13( String	cntrTpszCd13 ) {
		this.cntrTpszCd13 =	cntrTpszCd13;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd13
	 */
	 public	 String	getCntrTpszCd13() {
		 return	this.cntrTpszCd13;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd12
	*/
	public void	setCntrTpszCd12( String	cntrTpszCd12 ) {
		this.cntrTpszCd12 =	cntrTpszCd12;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd12
	 */
	 public	 String	getCntrTpszCd12() {
		 return	this.cntrTpszCd12;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd27
	*/
	public void	setCntrTpszCd27( String	cntrTpszCd27 ) {
		this.cntrTpszCd27 =	cntrTpszCd27;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd27
	 */
	 public	 String	getCntrTpszCd27() {
		 return	this.cntrTpszCd27;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd28
	*/
	public void	setCntrTpszCd28( String	cntrTpszCd28 ) {
		this.cntrTpszCd28 =	cntrTpszCd28;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd28
	 */
	 public	 String	getCntrTpszCd28() {
		 return	this.cntrTpszCd28;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd25
	*/
	public void	setCntrTpszCd25( String	cntrTpszCd25 ) {
		this.cntrTpszCd25 =	cntrTpszCd25;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd25
	 */
	 public	 String	getCntrTpszCd25() {
		 return	this.cntrTpszCd25;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd26
	*/
	public void	setCntrTpszCd26( String	cntrTpszCd26 ) {
		this.cntrTpszCd26 =	cntrTpszCd26;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd26
	 */
	 public	 String	getCntrTpszCd26() {
		 return	this.cntrTpszCd26;
	 } 
 	/**
	* Column Info
	* @param  cntrHngrRckCdO
	*/
	public void	setCntrHngrRckCdO( String	cntrHngrRckCdO ) {
		this.cntrHngrRckCdO =	cntrHngrRckCdO;
	}
 
	/**
	 * Column Info
	 * @return	cntrHngrRckCdO
	 */
	 public	 String	getCntrHngrRckCdO() {
		 return	this.cntrHngrRckCdO;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd29
	*/
	public void	setCntrTpszCd29( String	cntrTpszCd29 ) {
		this.cntrTpszCd29 =	cntrTpszCd29;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd29
	 */
	 public	 String	getCntrTpszCd29() {
		 return	this.cntrTpszCd29;
	 } 
 	/**
	* Column Info
	* @param  toPrd
	*/
	public void	setToPrd( String	toPrd ) {
		this.toPrd =	toPrd;
	}
 
	/**
	 * Column Info
	 * @return	toPrd
	 */
	 public	 String	getToPrd() {
		 return	this.toPrd;
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
	* @param  vvd2
	*/
	public void	setVvd2( String	vvd2 ) {
		this.vvd2 =	vvd2;
	}
 
	/**
	 * Column Info
	 * @return	vvd2
	 */
	 public	 String	getVvd2() {
		 return	this.vvd2;
	 } 
 	/**
	* Column Info
	* @param  viewCustomer
	*/
	public void	setViewCustomer( String	viewCustomer ) {
		this.viewCustomer =	viewCustomer;
	}
 
	/**
	 * Column Info
	 * @return	viewCustomer
	 */
	 public	 String	getViewCustomer() {
		 return	this.viewCustomer;
	 } 
 	/**
	* Column Info
	* @param  vvd3
	*/
	public void	setVvd3( String	vvd3 ) {
		this.vvd3 =	vvd3;
	}
 
	/**
	 * Column Info
	 * @return	vvd3
	 */
	 public	 String	getVvd3() {
		 return	this.vvd3;
	 } 
 	/**
	* Column Info
	* @param  queryStr
	*/
	public void	setQueryStr( String	queryStr ) {
		this.queryStr =	queryStr;
	}
 
	/**
	 * Column Info
	 * @return	queryStr
	 */
	 public	 String	getQueryStr() {
		 return	this.queryStr;
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
	* @param  tsCntrBehind
	*/
	public void	setTsCntrBehind( String	tsCntrBehind ) {
		this.tsCntrBehind =	tsCntrBehind;
	}
 
	/**
	 * Column Info
	 * @return	tsCntrBehind
	 */
	 public	 String	getTsCntrBehind() {
		 return	this.tsCntrBehind;
	 } 
 	/**
	* Column Info
	* @param  bseDt
	*/
	public void	setBseDt( String	bseDt ) {
		this.bseDt =	bseDt;
	}
 
	/**
	 * Column Info
	 * @return	bseDt
	 */
	 public	 String	getBseDt() {
		 return	this.bseDt;
	 } 
 	/**
	* Column Info
	* @param  toBseDt
	*/
	public void	setToBseDt( String	toBseDt ) {
		this.toBseDt =	toBseDt;
	}
 
	/**
	 * Column Info
	 * @return	toBseDt
	 */
	 public	 String	getToBseDt() {
		 return	this.toBseDt;
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
	* @param  overStayDays
	*/
	public void	setOverStayDays( String	overStayDays ) {
		this.overStayDays =	overStayDays;
	}
 
	/**
	 * Column Info
	 * @return	overStayDays
	 */
	 public	 String	getOverStayDays() {
		 return	this.overStayDays;
	 } 
 	/**
	* Column Info
	* @param  overFreeDays
	*/
	public void	setOverFreeDays( String	overFreeDays ) {
		this.overFreeDays =	overFreeDays;
	}
 
	/**
	 * Column Info
	 * @return	overFreeDays
	 */
	 public	 String	getOverFreeDays() {
		 return	this.overFreeDays;
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
	* @param  lvl
	*/
	public void	setLvl( String	lvl ) {
		this.lvl =	lvl;
	}
 
	/**
	 * Column Info
	 * @return	lvl
	 */
	 public	 String	getLvl() {
		 return	this.lvl;
	 } 
 	/**
	* Column Info
	* @param  yardCd
	*/
	public void	setYardCd( String	yardCd ) {
		this.yardCd =	yardCd;
	}
 
	/**
	 * Column Info
	 * @return	yardCd
	 */
	 public	 String	getYardCd() {
		 return	this.yardCd;
	 } 
 	/**
	* Column Info
	* @param  longStayCd
	*/
	public void	setLongStayCd( String	longStayCd ) {
		this.longStayCd =	longStayCd;
	}
 
	/**
	 * Column Info
	 * @return	longStayCd
	 */
	 public	 String	getLongStayCd() {
		 return	this.longStayCd;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd20
	*/
	public void	setCntrTpszCd20( String	cntrTpszCd20 ) {
		this.cntrTpszCd20 =	cntrTpszCd20;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd20
	 */
	 public	 String	getCntrTpszCd20() {
		 return	this.cntrTpszCd20;
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
	* @param  cntrTpszCd24
	*/
	public void	setCntrTpszCd24( String	cntrTpszCd24 ) {
		this.cntrTpszCd24 =	cntrTpszCd24;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd24
	 */
	 public	 String	getCntrTpszCd24() {
		 return	this.cntrTpszCd24;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd23
	*/
	public void	setCntrTpszCd23( String	cntrTpszCd23 ) {
		this.cntrTpszCd23 =	cntrTpszCd23;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd23
	 */
	 public	 String	getCntrTpszCd23() {
		 return	this.cntrTpszCd23;
	 } 
 	/**
	* Column Info
	* @param  fmStkJbDt
	*/
	public void	setFmStkJbDt( String	fmStkJbDt ) {
		this.fmStkJbDt =	fmStkJbDt;
	}
 
	/**
	 * Column Info
	 * @return	fmStkJbDt
	 */
	 public	 String	getFmStkJbDt() {
		 return	this.fmStkJbDt;
	 } 
 	/**
	* Column Info
	* @param  cntrHngrRckCdR
	*/
	public void	setCntrHngrRckCdR( String	cntrHngrRckCdR ) {
		this.cntrHngrRckCdR =	cntrHngrRckCdR;
	}
 
	/**
	 * Column Info
	 * @return	cntrHngrRckCdR
	 */
	 public	 String	getCntrHngrRckCdR() {
		 return	this.cntrHngrRckCdR;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd22
	*/
	public void	setCntrTpszCd22( String	cntrTpszCd22 ) {
		this.cntrTpszCd22 =	cntrTpszCd22;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd22
	 */
	 public	 String	getCntrTpszCd22() {
		 return	this.cntrTpszCd22;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd21
	*/
	public void	setCntrTpszCd21( String	cntrTpszCd21 ) {
		this.cntrTpszCd21 =	cntrTpszCd21;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd21
	 */
	 public	 String	getCntrTpszCd21() {
		 return	this.cntrTpszCd21;
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
	* @param  headCntrTpszCd
	*/
	public void	setHeadCntrTpszCd( String	headCntrTpszCd ) {
		this.headCntrTpszCd =	headCntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	headCntrTpszCd
	 */
	 public	 String	getHeadCntrTpszCd() {
		 return	this.headCntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  cntrUseCoCd
	*/
	public void	setCntrUseCoCd( String	cntrUseCoCd ) {
		this.cntrUseCoCd =	cntrUseCoCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrUseCoCd
	 */
	 public	 String	getCntrUseCoCd() {
		 return	this.cntrUseCoCd;
	 } 
 	/**
	* Column Info
	* @param  rdCgoFlg
	*/
	public void	setRdCgoFlg( String	rdCgoFlg ) {
		this.rdCgoFlg =	rdCgoFlg;
	}
 
	/**
	 * Column Info
	 * @return	rdCgoFlg
	 */
	 public	 String	getRdCgoFlg() {
		 return	this.rdCgoFlg;
	 } 
 	/**
	* Column Info
	* @param  routeTpCd
	*/
	public void	setRouteTpCd( String	routeTpCd ) {
		this.routeTpCd =	routeTpCd;
	}
 
	/**
	 * Column Info
	 * @return	routeTpCd
	 */
	 public	 String	getRouteTpCd() {
		 return	this.routeTpCd;
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
	* @param  locTypeCode
	*/
	public void	setLocTypeCode( String	locTypeCode ) {
		this.locTypeCode =	locTypeCode;
	}
 
	/**
	 * Column Info
	 * @return	locTypeCode
	 */
	 public	 String	getLocTypeCode() {
		 return	this.locTypeCode;
	 } 
 	/**
	* Column Info
	* @param  opTrndTpCd
	*/
	public void	setOpTrndTpCd( String	opTrndTpCd ) {
		this.opTrndTpCd =	opTrndTpCd;
	}
 
	/**
	 * Column Info
	 * @return	opTrndTpCd
	 */
	 public	 String	getOpTrndTpCd() {
		 return	this.opTrndTpCd;
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
	* @param  fromBseDt
	*/
	public void	setFromBseDt( String	fromBseDt ) {
		this.fromBseDt =	fromBseDt;
	}
 
	/**
	 * Column Info
	 * @return	fromBseDt
	 */
	 public	 String	getFromBseDt() {
		 return	this.fromBseDt;
	 } 
 	/**
	* Column Info
	* @param  objCntrTpszCd
	*/
	public void	setObjCntrTpszCd( String	objCntrTpszCd ) {
		this.objCntrTpszCd =	objCntrTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	objCntrTpszCd
	 */
	 public	 String	getObjCntrTpszCd() {
		 return	this.objCntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  toStkJbDt
	*/
	public void	setToStkJbDt( String	toStkJbDt ) {
		this.toStkJbDt =	toStkJbDt;
	}
 
	/**
	 * Column Info
	 * @return	toStkJbDt
	 */
	 public	 String	getToStkJbDt() {
		 return	this.toStkJbDt;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd30
	*/
	public void	setCntrTpszCd30( String	cntrTpszCd30 ) {
		this.cntrTpszCd30 =	cntrTpszCd30;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd30
	 */
	 public	 String	getCntrTpszCd30() {
		 return	this.cntrTpszCd30;
	 } 
 	/**
	* Column Info
	* @param  coCd
	*/
	public void	setCoCd( String	coCd ) {
		this.coCd =	coCd;
	}
 
	/**
	 * Column Info
	 * @return	coCd
	 */
	 public	 String	getCoCd() {
		 return	this.coCd;
	 } 
 	/**
	* Column Info
	* @param  fmPrd
	*/
	public void	setFmPrd( String	fmPrd ) {
		this.fmPrd =	fmPrd;
	}
 
	/**
	 * Column Info
	 * @return	fmPrd
	 */
	 public	 String	getFmPrd() {
		 return	this.fmPrd;
	 } 
 	/**
	* Column Info
	* @param  polPodWise
	*/
	public void	setPolPodWise( String	polPodWise ) {
		this.polPodWise =	polPodWise;
	}
 
	/**
	 * Column Info
	 * @return	polPodWise
	 */
	 public	 String	getPolPodWise() {
		 return	this.polPodWise;
	 } 
 	/**
	* Column Info
	* @param  d2PayldFlg
	*/
	public void	setD2PayldFlg( String	d2PayldFlg ) {
		this.d2PayldFlg =	d2PayldFlg;
	}
 
	/**
	 * Column Info
	 * @return	d2PayldFlg
	 */
	 public	 String	getD2PayldFlg() {
		 return	this.d2PayldFlg;
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
	* @param  cntrTpszCd6
	*/
	public void	setCntrTpszCd6( String	cntrTpszCd6 ) {
		this.cntrTpszCd6 =	cntrTpszCd6;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd6
	 */
	 public	 String	getCntrTpszCd6() {
		 return	this.cntrTpszCd6;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd5
	*/
	public void	setCntrTpszCd5( String	cntrTpszCd5 ) {
		this.cntrTpszCd5 =	cntrTpszCd5;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd5
	 */
	 public	 String	getCntrTpszCd5() {
		 return	this.cntrTpszCd5;
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
	* @param  cntrTpszCd8
	*/
	public void	setCntrTpszCd8( String	cntrTpszCd8 ) {
		this.cntrTpszCd8 =	cntrTpszCd8;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd8
	 */
	 public	 String	getCntrTpszCd8() {
		 return	this.cntrTpszCd8;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd7
	*/
	public void	setCntrTpszCd7( String	cntrTpszCd7 ) {
		this.cntrTpszCd7 =	cntrTpszCd7;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd7
	 */
	 public	 String	getCntrTpszCd7() {
		 return	this.cntrTpszCd7;
	 } 
 	/**
	* Column Info
	* @param  viewCommodity
	*/
	public void	setViewCommodity( String	viewCommodity ) {
		this.viewCommodity =	viewCommodity;
	}
 
	/**
	 * Column Info
	 * @return	viewCommodity
	 */
	 public	 String	getViewCommodity() {
		 return	this.viewCommodity;
	 } 
 	/**
	* Column Info
	* @param  socCd
	*/
	public void	setSocCd( String	socCd ) {
		this.socCd =	socCd;
	}
 
	/**
	 * Column Info
	 * @return	socCd
	 */
	 public	 String	getSocCd() {
		 return	this.socCd;
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
	* @param  cntrTpszCd9
	*/
	public void	setCntrTpszCd9( String	cntrTpszCd9 ) {
		this.cntrTpszCd9 =	cntrTpszCd9;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd9
	 */
	 public	 String	getCntrTpszCd9() {
		 return	this.cntrTpszCd9;
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
	* @param  cntrTpszCd2
	*/
	public void	setCntrTpszCd2( String	cntrTpszCd2 ) {
		this.cntrTpszCd2 =	cntrTpszCd2;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd2
	 */
	 public	 String	getCntrTpszCd2() {
		 return	this.cntrTpszCd2;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd1
	*/
	public void	setCntrTpszCd1( String	cntrTpszCd1 ) {
		this.cntrTpszCd1 =	cntrTpszCd1;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd1
	 */
	 public	 String	getCntrTpszCd1() {
		 return	this.cntrTpszCd1;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd4
	*/
	public void	setCntrTpszCd4( String	cntrTpszCd4 ) {
		this.cntrTpszCd4 =	cntrTpszCd4;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd4
	 */
	 public	 String	getCntrTpszCd4() {
		 return	this.cntrTpszCd4;
	 } 
 	/**
	* Column Info
	* @param  fmDur
	*/
	public void	setFmDur( String	fmDur ) {
		this.fmDur =	fmDur;
	}
 
	/**
	 * Column Info
	 * @return	fmDur
	 */
	 public	 String	getFmDur() {
		 return	this.fmDur;
	 } 
 	/**
	* Column Info
	* @param  cntrTpszCd3
	*/
	public void	setCntrTpszCd3( String	cntrTpszCd3 ) {
		this.cntrTpszCd3 =	cntrTpszCd3;
	}
 
	/**
	 * Column Info
	 * @return	cntrTpszCd3
	 */
	 public	 String	getCntrTpszCd3() {
		 return	this.cntrTpszCd3;
	 } 
 	/**
	* Column Info
	* @param  froms
	*/
	public void	setFroms( String	froms ) {
		this.froms =	froms;
	}
 
	/**
	 * Column Info
	 * @return	froms
	 */
	 public	 String	getFroms() {
		 return	this.froms;
	 } 
 	/**
	* Column Info
	* @param  tos
	*/
	public void	setTos( String	tos ) {
		this.tos =	tos;
	}
 
	/**
	 * Column Info
	 * @return	tos
	 */
	 public	 String	getTos() {
		 return	this.tos;
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
	 * Page No
	 * @param iPage
	 */
	public void setIPage(int iPage) {
		this.iPage = iPage;
	}

	/**
	 * Page No
	 * @param iPage
	 */
	public int getIPage() {
		return iPage;
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
		setCntrTpszCd14(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd14", ""));
		setCntrTpszCd15(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd15", ""));
		setCntrTpszCd16(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd16", ""));
		setCntrTpszCd17(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd17", ""));
		setCntrTpszCd18(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd18", ""));
		setToDur(JSPUtil.getParameter(request,	prefix + "to_dur", ""));
		setCntrTpszCd19(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd19", ""));
		setRfTpCdReefer(JSPUtil.getParameter(request,	prefix + "rf_tp_cd_reefer", ""));
		setRccDate(JSPUtil.getParameter(request,	prefix + "rcc_date", ""));
		setViewFlg(JSPUtil.getParameter(request,	prefix + "view_flg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setRfCntr(JSPUtil.getParameter(request,	prefix + "rf_cntr", ""));
		setRfTpCdM(JSPUtil.getParameter(request,	prefix + "rf_tp_cd_m", ""));
		setCntCd(JSPUtil.getParameter(request,	prefix + "cnt_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setTpCd(JSPUtil.getParameter(request,	prefix + "tp_cd", ""));
		setRfTpCdC(JSPUtil.getParameter(request,	prefix + "rf_tp_cd_c", ""));
		setCntrHngrBarAtchKnt(JSPUtil.getParameter(request,	prefix + "cntr_hngr_bar_atch_knt", ""));
		setCntrTpszCd11(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd11", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setCntrTpszCd10(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd10", ""));
		setRfTpCdH(JSPUtil.getParameter(request,	prefix + "rf_tp_cd_h", ""));
		setCntrTpszCd13(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd13", ""));
		setCntrTpszCd12(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd12", ""));
		setCntrTpszCd27(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd27", ""));
		setCntrTpszCd28(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd28", ""));
		setCntrTpszCd25(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd25", ""));
		setCntrTpszCd26(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd26", ""));
		setCntrHngrRckCdO(JSPUtil.getParameter(request,	prefix + "cntr_hngr_rck_cd_o", ""));
		setCntrTpszCd29(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd29", ""));
		setToPrd(JSPUtil.getParameter(request,	prefix + "to_prd", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setVvd2(JSPUtil.getParameter(request,	prefix + "vvd2", ""));
		setViewCustomer(JSPUtil.getParameter(request,	prefix + "view_customer", ""));
		setVvd3(JSPUtil.getParameter(request,	prefix + "vvd3", ""));
		setQueryStr(JSPUtil.getParameter(request,	prefix + "query_str", ""));
		setVvd1(JSPUtil.getParameter(request,	prefix + "vvd1", ""));
		setTsCntrBehind(JSPUtil.getParameter(request,	prefix + "ts_cntr_behind", ""));
		setBseDt(JSPUtil.getParameter(request,	prefix + "bse_dt", ""));
		setToBseDt(JSPUtil.getParameter(request,	prefix + "to_bse_dt", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setDispFlg(JSPUtil.getParameter(request,	prefix + "disp_flg", ""));
		setOverStayDays(JSPUtil.getParameter(request,	prefix + "over_stay_days", ""));
		setOverFreeDays(JSPUtil.getParameter(request,	prefix + "over_free_days", ""));
		setUclmLsDivCd(JSPUtil.getParameter(request,	prefix + "uclm_ls_div_cd", ""));
		setLvl(JSPUtil.getParameter(request,	prefix + "lvl", ""));
		setYardCd(JSPUtil.getParameter(request,	prefix + "yard_cd", ""));
		setLongStayCd(JSPUtil.getParameter(request,	prefix + "long_stay_cd", ""));
		setCntrTpszCd20(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd20", ""));
		setNextVvd(JSPUtil.getParameter(request,	prefix + "next_vvd", ""));
		setFullFlg(JSPUtil.getParameter(request,	prefix + "full_flg", ""));
		setStayDays(JSPUtil.getParameter(request,	prefix + "stay_days", ""));
		setCntrTpszCd24(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd24", ""));
		setCntrTpszCd23(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd23", ""));
		setFmStkJbDt(JSPUtil.getParameter(request,	prefix + "fm_stk_jb_dt", ""));
		setCntrHngrRckCdR(JSPUtil.getParameter(request,	prefix + "cntr_hngr_rck_cd_r", ""));
		setCntrTpszCd22(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd22", ""));
		setCntrTpszCd21(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd21", ""));
		setCntrHngrRckCd(JSPUtil.getParameter(request,	prefix + "cntr_hngr_rck_cd", ""));
		setHeadCntrTpszCd(JSPUtil.getParameter(request,	prefix + "head_cntr_tpsz_cd", ""));
		setCntrUseCoCd(JSPUtil.getParameter(request,	prefix + "cntr_use_co_cd", ""));
		setRdCgoFlg(JSPUtil.getParameter(request,	prefix + "rd_cgo_flg", ""));
		setRouteTpCd(JSPUtil.getParameter(request,	prefix + "route_tp_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request,	prefix + "dmg_flg", ""));
		setLocTypeCode(JSPUtil.getParameter(request,	prefix + "loc_type_code", ""));
		setOpTrndTpCd(JSPUtil.getParameter(request,	prefix + "op_trnd_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setFromBseDt(JSPUtil.getParameter(request,	prefix + "from_bse_dt", ""));
		setObjCntrTpszCd(JSPUtil.getParameter(request,	prefix + "obj_cntr_tpsz_cd", ""));
		setToStkJbDt(JSPUtil.getParameter(request,	prefix + "to_stk_jb_dt", ""));
		setCntrTpszCd30(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd30", ""));
		setCoCd(JSPUtil.getParameter(request,	prefix + "co_cd", ""));
		setFmPrd(JSPUtil.getParameter(request,	prefix + "fm_prd", ""));
		setPolPodWise(JSPUtil.getParameter(request,	prefix + "pol_pod_wise", ""));
		setD2PayldFlg(JSPUtil.getParameter(request,	prefix + "d2_payld_flg", ""));
		setRccCd(JSPUtil.getParameter(request,	prefix + "rcc_cd", ""));
		setPlstFlrFlg(JSPUtil.getParameter(request,	prefix + "plst_flr_flg", ""));
		setCntrTpszCd6(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd6", ""));
		setCntrTpszCd5(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd5", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setCntrTpszCd8(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd8", ""));
		setCntrTpszCd7(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd7", ""));
		setViewCommodity(JSPUtil.getParameter(request,	prefix + "view_commodity", ""));
		setSocCd(JSPUtil.getParameter(request,	prefix + "soc_cd", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setCntrTpszCd9(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd9", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setImdtExtFlg(JSPUtil.getParameter(request,	prefix + "imdt_ext_flg", ""));
		setCntrTpszCd2(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd2", ""));
		setCntrTpszCd1(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd1", ""));
		setCntrTpszCd4(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd4", ""));
		setFmDur(JSPUtil.getParameter(request,	prefix + "fm_dur", ""));
		setCntrTpszCd3(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd3", ""));
		setFroms(JSPUtil.getParameter(request,	prefix + "froms", ""));
		setTos(JSPUtil.getParameter(request,	prefix + "tos", ""));
		setRstr_usg_lbl(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl", ""));
		setRu_lable_type(JSPUtil.getParameter(request,	prefix + "ru_lable_type", ""));
		setIPage(JSPUtil.getParameterAsInt(request, prefix + "iPage", 1));
		setCgoTpCd(JSPUtil.getParameter(request,	prefix + "cgo_tp_cd", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return InvtOptionVO[]
	 */
	public InvtOptionVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return InvtOptionVO[]
	 */
	public InvtOptionVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvtOptionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] cntrTpszCd14 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd14".trim(),	length));
				String[] cntrTpszCd15 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd15".trim(),	length));
				String[] cntrTpszCd16 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd16".trim(),	length));
				String[] cntrTpszCd17 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd17".trim(),	length));
				String[] cntrTpszCd18 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd18".trim(),	length));
				String[] toDur =	(JSPUtil.getParameter(request, prefix +	"to_dur".trim(),	length));
				String[] cntrTpszCd19 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd19".trim(),	length));
				String[] rfTpCdReefer =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd_reefer".trim(),	length));
				String[] rccDate =	(JSPUtil.getParameter(request, prefix +	"rcc_date".trim(),	length));
				String[] viewFlg =	(JSPUtil.getParameter(request, prefix +	"view_flg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] rfCntr =	(JSPUtil.getParameter(request, prefix +	"rf_cntr".trim(),	length));
				String[] rfTpCdM =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd_m".trim(),	length));
				String[] cntCd =	(JSPUtil.getParameter(request, prefix +	"cnt_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] tpCd =	(JSPUtil.getParameter(request, prefix +	"tp_cd".trim(),	length));
				String[] rfTpCdC =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd_c".trim(),	length));
				String[] cntrHngrBarAtchKnt =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_bar_atch_knt".trim(),	length));
				String[] cntrTpszCd11 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd11".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] cntrTpszCd10 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd10".trim(),	length));
				String[] rfTpCdH =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd_h".trim(),	length));
				String[] cntrTpszCd13 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd13".trim(),	length));
				String[] cntrTpszCd12 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd12".trim(),	length));
				String[] cntrTpszCd27 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd27".trim(),	length));
				String[] cntrTpszCd28 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd28".trim(),	length));
				String[] cntrTpszCd25 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd25".trim(),	length));
				String[] cntrTpszCd26 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd26".trim(),	length));
				String[] cntrHngrRckCdO =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_rck_cd_o".trim(),	length));
				String[] cntrTpszCd29 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd29".trim(),	length));
				String[] toPrd =	(JSPUtil.getParameter(request, prefix +	"to_prd".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] vvd2 =	(JSPUtil.getParameter(request, prefix +	"vvd2".trim(),	length));
				String[] viewCustomer =	(JSPUtil.getParameter(request, prefix +	"view_customer".trim(),	length));
				String[] vvd3 =	(JSPUtil.getParameter(request, prefix +	"vvd3".trim(),	length));
				String[] queryStr =	(JSPUtil.getParameter(request, prefix +	"query_str".trim(),	length));
				String[] vvd1 =	(JSPUtil.getParameter(request, prefix +	"vvd1".trim(),	length));
				String[] tsCntrBehind =	(JSPUtil.getParameter(request, prefix +	"ts_cntr_behind".trim(),	length));
				String[] bseDt =	(JSPUtil.getParameter(request, prefix +	"bse_dt".trim(),	length));
				String[] toBseDt =	(JSPUtil.getParameter(request, prefix +	"to_bse_dt".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] dispFlg =	(JSPUtil.getParameter(request, prefix +	"disp_flg".trim(),	length));
				String[] overStayDays =	(JSPUtil.getParameter(request, prefix +	"over_stay_days".trim(),	length));
				String[] overFreeDays =	(JSPUtil.getParameter(request, prefix +	"over_free_days".trim(),	length));
				String[] uclmLsDivCd =	(JSPUtil.getParameter(request, prefix +	"uclm_ls_div_cd".trim(),	length));
				String[] lvl =	(JSPUtil.getParameter(request, prefix +	"lvl".trim(),	length));
				String[] yardCd =	(JSPUtil.getParameter(request, prefix +	"yard_cd".trim(),	length));
				String[] longStayCd =	(JSPUtil.getParameter(request, prefix +	"long_stay_cd".trim(),	length));
				String[] cntrTpszCd20 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd20".trim(),	length));
				String[] nextVvd =	(JSPUtil.getParameter(request, prefix +	"next_vvd".trim(),	length));
				String[] fullFlg =	(JSPUtil.getParameter(request, prefix +	"full_flg".trim(),	length));
				String[] stayDays =	(JSPUtil.getParameter(request, prefix +	"stay_days".trim(),	length));
				String[] cntrTpszCd24 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd24".trim(),	length));
				String[] cntrTpszCd23 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd23".trim(),	length));
				String[] fmStkJbDt =	(JSPUtil.getParameter(request, prefix +	"fm_stk_jb_dt".trim(),	length));
				String[] cntrHngrRckCdR =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_rck_cd_r".trim(),	length));
				String[] cntrTpszCd22 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd22".trim(),	length));
				String[] cntrTpszCd21 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd21".trim(),	length));
				String[] cntrHngrRckCd =	(JSPUtil.getParameter(request, prefix +	"cntr_hngr_rck_cd".trim(),	length));
				String[] headCntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"head_cntr_tpsz_cd".trim(),	length));
				String[] cntrUseCoCd =	(JSPUtil.getParameter(request, prefix +	"cntr_use_co_cd".trim(),	length));
				String[] rdCgoFlg =	(JSPUtil.getParameter(request, prefix +	"rd_cgo_flg".trim(),	length));
				String[] routeTpCd =	(JSPUtil.getParameter(request, prefix +	"route_tp_cd".trim(),	length));
				String[] dmgFlg =	(JSPUtil.getParameter(request, prefix +	"dmg_flg".trim(),	length));
				String[] locTypeCode =	(JSPUtil.getParameter(request, prefix +	"loc_type_code".trim(),	length));
				String[] opTrndTpCd =	(JSPUtil.getParameter(request, prefix +	"op_trnd_tp_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] fromBseDt =	(JSPUtil.getParameter(request, prefix +	"from_bse_dt".trim(),	length));
				String[] objCntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"obj_cntr_tpsz_cd".trim(),	length));
				String[] toStkJbDt =	(JSPUtil.getParameter(request, prefix +	"to_stk_jb_dt".trim(),	length));
				String[] cntrTpszCd30 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd30".trim(),	length));
				String[] coCd =	(JSPUtil.getParameter(request, prefix +	"co_cd".trim(),	length));
				String[] fmPrd =	(JSPUtil.getParameter(request, prefix +	"fm_prd".trim(),	length));
				String[] polPodWise =	(JSPUtil.getParameter(request, prefix +	"pol_pod_wise".trim(),	length));
				String[] d2PayldFlg =	(JSPUtil.getParameter(request, prefix +	"d2_payld_flg".trim(),	length));
				String[] rccCd =	(JSPUtil.getParameter(request, prefix +	"rcc_cd".trim(),	length));
				String[] plstFlrFlg =	(JSPUtil.getParameter(request, prefix +	"plst_flr_flg".trim(),	length));
				String[] cntrTpszCd6 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd6".trim(),	length));
				String[] cntrTpszCd5 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd5".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] cntrTpszCd8 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd8".trim(),	length));
				String[] cntrTpszCd7 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd7".trim(),	length));
				String[] viewCommodity =	(JSPUtil.getParameter(request, prefix +	"view_commodity".trim(),	length));
				String[] socCd =	(JSPUtil.getParameter(request, prefix +	"soc_cd".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] cntrTpszCd9 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd9".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] imdtExtFlg =	(JSPUtil.getParameter(request, prefix +	"imdt_ext_flg".trim(),	length));
				String[] cntrTpszCd2 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd2".trim(),	length));
				String[] cntrTpszCd1 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd1".trim(),	length));
				String[] cntrTpszCd4 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd4".trim(),	length));
				String[] fmDur =	(JSPUtil.getParameter(request, prefix +	"fm_dur".trim(),	length));
				String[] cntrTpszCd3 =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd3".trim(),	length));
				String[] froms =	(JSPUtil.getParameter(request, prefix +	"froms".trim(),	length));
				String[] tos =	(JSPUtil.getParameter(request, prefix +	"tos".trim(),	length));
				String[] rstr_usg_lbl =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl".trim(),	length));
				String[] ru_lable_type =	(JSPUtil.getParameter(request, prefix +	"ru_lable_type".trim(),	length));
				String[] cgoTpCd =	(JSPUtil.getParameter(request, prefix +	"cgo_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvtOptionVO();
						if ( cntrTpszCd14[i] !=	null)
						model.setCntrTpszCd14( cntrTpszCd14[i]);
						if ( cntrTpszCd15[i] !=	null)
						model.setCntrTpszCd15( cntrTpszCd15[i]);
						if ( cntrTpszCd16[i] !=	null)
						model.setCntrTpszCd16( cntrTpszCd16[i]);
						if ( cntrTpszCd17[i] !=	null)
						model.setCntrTpszCd17( cntrTpszCd17[i]);
						if ( cntrTpszCd18[i] !=	null)
						model.setCntrTpszCd18( cntrTpszCd18[i]);
						if ( toDur[i] !=	null)
						model.setToDur( toDur[i]);
						if ( cntrTpszCd19[i] !=	null)
						model.setCntrTpszCd19( cntrTpszCd19[i]);
						if ( rfTpCdReefer[i] !=	null)
						model.setRfTpCdReefer( rfTpCdReefer[i]);
						if ( rccDate[i] !=	null)
						model.setRccDate( rccDate[i]);
						if ( viewFlg[i] !=	null)
						model.setViewFlg( viewFlg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( rfCntr[i] !=	null)
						model.setRfCntr( rfCntr[i]);
						if ( rfTpCdM[i] !=	null)
						model.setRfTpCdM( rfTpCdM[i]);
						if ( cntCd[i] !=	null)
						model.setCntCd( cntCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( tpCd[i] !=	null)
						model.setTpCd( tpCd[i]);
						if ( rfTpCdC[i] !=	null)
						model.setRfTpCdC( rfTpCdC[i]);
						if ( cntrHngrBarAtchKnt[i] !=	null)
						model.setCntrHngrBarAtchKnt( cntrHngrBarAtchKnt[i]);
						if ( cntrTpszCd11[i] !=	null)
						model.setCntrTpszCd11( cntrTpszCd11[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( cntrTpszCd10[i] !=	null)
						model.setCntrTpszCd10( cntrTpszCd10[i]);
						if ( rfTpCdH[i] !=	null)
						model.setRfTpCdH( rfTpCdH[i]);
						if ( cntrTpszCd13[i] !=	null)
						model.setCntrTpszCd13( cntrTpszCd13[i]);
						if ( cntrTpszCd12[i] !=	null)
						model.setCntrTpszCd12( cntrTpszCd12[i]);
						if ( cntrTpszCd27[i] !=	null)
						model.setCntrTpszCd27( cntrTpszCd27[i]);
						if ( cntrTpszCd28[i] !=	null)
						model.setCntrTpszCd28( cntrTpszCd28[i]);
						if ( cntrTpszCd25[i] !=	null)
						model.setCntrTpszCd25( cntrTpszCd25[i]);
						if ( cntrTpszCd26[i] !=	null)
						model.setCntrTpszCd26( cntrTpszCd26[i]);
						if ( cntrHngrRckCdO[i] !=	null)
						model.setCntrHngrRckCdO( cntrHngrRckCdO[i]);
						if ( cntrTpszCd29[i] !=	null)
						model.setCntrTpszCd29( cntrTpszCd29[i]);
						if ( toPrd[i] !=	null)
						model.setToPrd( toPrd[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( vvd2[i] !=	null)
						model.setVvd2( vvd2[i]);
						if ( viewCustomer[i] !=	null)
						model.setViewCustomer( viewCustomer[i]);
						if ( vvd3[i] !=	null)
						model.setVvd3( vvd3[i]);
						if ( queryStr[i] !=	null)
						model.setQueryStr( queryStr[i]);
						if ( vvd1[i] !=	null)
						model.setVvd1( vvd1[i]);
						if ( tsCntrBehind[i] !=	null)
						model.setTsCntrBehind( tsCntrBehind[i]);
						if ( bseDt[i] !=	null)
						model.setBseDt( bseDt[i]);
						if ( toBseDt[i] !=	null)
						model.setToBseDt( toBseDt[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( dispFlg[i] !=	null)
						model.setDispFlg( dispFlg[i]);
						if ( overStayDays[i] !=	null)
						model.setOverStayDays( overStayDays[i]);
						if ( overFreeDays[i] !=	null)
						model.setOverFreeDays( overFreeDays[i]);
						if ( uclmLsDivCd[i] !=	null)
						model.setUclmLsDivCd( uclmLsDivCd[i]);
						if ( lvl[i] !=	null)
						model.setLvl( lvl[i]);
						if ( yardCd[i] !=	null)
						model.setYardCd( yardCd[i]);
						if ( longStayCd[i] !=	null)
						model.setLongStayCd( longStayCd[i]);
						if ( cntrTpszCd20[i] !=	null)
						model.setCntrTpszCd20( cntrTpszCd20[i]);
						if ( nextVvd[i] !=	null)
						model.setNextVvd( nextVvd[i]);
						if ( fullFlg[i] !=	null)
						model.setFullFlg( fullFlg[i]);
						if ( stayDays[i] !=	null)
						model.setStayDays( stayDays[i]);
						if ( cntrTpszCd24[i] !=	null)
						model.setCntrTpszCd24( cntrTpszCd24[i]);
						if ( cntrTpszCd23[i] !=	null)
						model.setCntrTpszCd23( cntrTpszCd23[i]);
						if ( fmStkJbDt[i] !=	null)
						model.setFmStkJbDt( fmStkJbDt[i]);
						if ( cntrHngrRckCdR[i] !=	null)
						model.setCntrHngrRckCdR( cntrHngrRckCdR[i]);
						if ( cntrTpszCd22[i] !=	null)
						model.setCntrTpszCd22( cntrTpszCd22[i]);
						if ( cntrTpszCd21[i] !=	null)
						model.setCntrTpszCd21( cntrTpszCd21[i]);
						if ( cntrHngrRckCd[i] !=	null)
						model.setCntrHngrRckCd( cntrHngrRckCd[i]);
						if ( headCntrTpszCd[i] !=	null)
						model.setHeadCntrTpszCd( headCntrTpszCd[i]);
						if ( cntrUseCoCd[i] !=	null)
						model.setCntrUseCoCd( cntrUseCoCd[i]);
						if ( rdCgoFlg[i] !=	null)
						model.setRdCgoFlg( rdCgoFlg[i]);
						if ( routeTpCd[i] !=	null)
						model.setRouteTpCd( routeTpCd[i]);
						if ( dmgFlg[i] !=	null)
						model.setDmgFlg( dmgFlg[i]);
						if ( locTypeCode[i] !=	null)
						model.setLocTypeCode( locTypeCode[i]);
						if ( opTrndTpCd[i] !=	null)
						model.setOpTrndTpCd( opTrndTpCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( fromBseDt[i] !=	null)
						model.setFromBseDt( fromBseDt[i]);
						if ( objCntrTpszCd[i] !=	null)
						model.setObjCntrTpszCd( objCntrTpszCd[i]);
						if ( toStkJbDt[i] !=	null)
						model.setToStkJbDt( toStkJbDt[i]);
						if ( cntrTpszCd30[i] !=	null)
						model.setCntrTpszCd30( cntrTpszCd30[i]);
						if ( coCd[i] !=	null)
						model.setCoCd( coCd[i]);
						if ( fmPrd[i] !=	null)
						model.setFmPrd( fmPrd[i]);
						if ( polPodWise[i] !=	null)
						model.setPolPodWise( polPodWise[i]);
						if ( d2PayldFlg[i] !=	null)
						model.setD2PayldFlg( d2PayldFlg[i]);
						if ( rccCd[i] !=	null)
						model.setRccCd( rccCd[i]);
						if ( plstFlrFlg[i] !=	null)
						model.setPlstFlrFlg( plstFlrFlg[i]);
						if ( cntrTpszCd6[i] !=	null)
						model.setCntrTpszCd6( cntrTpszCd6[i]);
						if ( cntrTpszCd5[i] !=	null)
						model.setCntrTpszCd5( cntrTpszCd5[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( cntrTpszCd8[i] !=	null)
						model.setCntrTpszCd8( cntrTpszCd8[i]);
						if ( cntrTpszCd7[i] !=	null)
						model.setCntrTpszCd7( cntrTpszCd7[i]);
						if ( viewCommodity[i] !=	null)
						model.setViewCommodity( viewCommodity[i]);
						if ( socCd[i] !=	null)
						model.setSocCd( socCd[i]);
						if ( slanCd[i] !=	null)
						model.setSlanCd( slanCd[i]);
						if ( cntrTpszCd9[i] !=	null)
						model.setCntrTpszCd9( cntrTpszCd9[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( imdtExtFlg[i] !=	null)
						model.setImdtExtFlg( imdtExtFlg[i]);
						if ( cntrTpszCd2[i] !=	null)
						model.setCntrTpszCd2( cntrTpszCd2[i]);
						if ( cntrTpszCd1[i] !=	null)
						model.setCntrTpszCd1( cntrTpszCd1[i]);
						if ( cntrTpszCd4[i] !=	null)
						model.setCntrTpszCd4( cntrTpszCd4[i]);
						if ( fmDur[i] !=	null)
						model.setFmDur( fmDur[i]);
						if ( cntrTpszCd3[i] !=	null)
						model.setCntrTpszCd3( cntrTpszCd3[i]);
						if ( froms[i] !=	null)
						model.setFroms( froms[i]);
						if ( tos[i] !=	null)
						model.setTos( tos[i]);
						if ( rstr_usg_lbl[i] !=	null)
						model.setRstr_usg_lbl( rstr_usg_lbl[i]);
						if ( ru_lable_type[i] !=	null)
						model.setRu_lable_type( ru_lable_type[i]);
						if ( cgoTpCd[i] !=	null)
						model.setCgoTpCd( cgoTpCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvtOptionVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return InvtOptionVO[]
	 */
	public InvtOptionVO[]	 getInvtOptionVOs(){
		InvtOptionVO[] vos = (InvtOptionVO[])models.toArray(new	InvtOptionVO[models.size()]);
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
		this.cntrTpszCd14 =	this.cntrTpszCd14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd15 =	this.cntrTpszCd15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd16 =	this.cntrTpszCd16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd17 =	this.cntrTpszCd17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd18 =	this.cntrTpszCd18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDur =	this.toDur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd19 =	this.cntrTpszCd19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdReefer =	this.rfTpCdReefer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccDate =	this.rccDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewFlg =	this.viewFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntr =	this.rfCntr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdM =	this.rfTpCdM.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd =	this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCd =	this.tpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdC =	this.rfTpCdC.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrBarAtchKnt =	this.cntrHngrBarAtchKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd11 =	this.cntrTpszCd11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd10 =	this.cntrTpszCd10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCdH =	this.rfTpCdH.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd13 =	this.cntrTpszCd13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd12 =	this.cntrTpszCd12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd27 =	this.cntrTpszCd27.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd28 =	this.cntrTpszCd28.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd25 =	this.cntrTpszCd25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd26 =	this.cntrTpszCd26.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCdO =	this.cntrHngrRckCdO.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd29 =	this.cntrTpszCd29.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrd =	this.toPrd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd2 =	this.vvd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewCustomer =	this.viewCustomer.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd3 =	this.vvd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.queryStr =	this.queryStr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd1 =	this.vvd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsCntrBehind =	this.tsCntrBehind.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bseDt =	this.bseDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toBseDt =	this.toBseDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispFlg =	this.dispFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overStayDays =	this.overStayDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overFreeDays =	this.overFreeDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uclmLsDivCd =	this.uclmLsDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lvl =	this.lvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.yardCd =	this.yardCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.longStayCd =	this.longStayCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd20 =	this.cntrTpszCd20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nextVvd =	this.nextVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullFlg =	this.fullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDays =	this.stayDays.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd24 =	this.cntrTpszCd24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd23 =	this.cntrTpszCd23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmStkJbDt =	this.fmStkJbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCdR =	this.cntrHngrRckCdR.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd22 =	this.cntrTpszCd22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd21 =	this.cntrTpszCd21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrHngrRckCd =	this.cntrHngrRckCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.headCntrTpszCd =	this.headCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrUseCoCd =	this.cntrUseCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdCgoFlg =	this.rdCgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routeTpCd =	this.routeTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg =	this.dmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locTypeCode =	this.locTypeCode.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opTrndTpCd =	this.opTrndTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromBseDt =	this.fromBseDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.objCntrTpszCd =	this.objCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toStkJbDt =	this.toStkJbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd30 =	this.cntrTpszCd30.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd =	this.coCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrd =	this.fmPrd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polPodWise =	this.polPodWise.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.d2PayldFlg =	this.d2PayldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd =	this.rccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plstFlrFlg =	this.plstFlrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd6 =	this.cntrTpszCd6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd5 =	this.cntrTpszCd5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd8 =	this.cntrTpszCd8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd7 =	this.cntrTpszCd7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viewCommodity =	this.viewCommodity.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socCd =	this.socCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd9 =	this.cntrTpszCd9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdtExtFlg =	this.imdtExtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd2 =	this.cntrTpszCd2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd1 =	this.cntrTpszCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd4 =	this.cntrTpszCd4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDur =	this.fmDur.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd3 =	this.cntrTpszCd3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.froms =	this.froms.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tos =	this.tos.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstr_usg_lbl =	this.rstr_usg_lbl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ru_lable_type =	this.ru_lable_type.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTpCd =	this.cgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}