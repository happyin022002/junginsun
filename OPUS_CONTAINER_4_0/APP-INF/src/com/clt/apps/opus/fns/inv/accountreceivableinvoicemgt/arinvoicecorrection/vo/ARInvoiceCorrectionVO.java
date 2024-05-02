/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ARInvoiceCorrectionVO.java
 *@FileTitle : ARInvoiceCorrectionVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.01.09
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.01.09  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArCntrVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.InvArMnVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceContainerVO;


/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class ARInvoiceCorrectionVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ARInvoiceCorrectionVO>  models =	new	ArrayList<ARInvoiceCorrectionVO>();
	
	private List<ARInvoiceChargeSumVO> listInvoiceChargeSumVO = null;
	
	private List<ARInvoiceChargeCorrectionVO> listInvoiceChargeCorrectionVO = null;
	
	private List<ARInvoiceContainerVO> listInvoiceContainerVO = null;
	
	private List<InvArCntrVO> invArCntrVO = null;
	
	private List<InvArMnVO> invArMnVO = null;

	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 whfDeclNo   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 obCrTermDys   =  null;
	/*	Column Info	*/
	private  String	 srepCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 crAmt   =  null;
	/*	Column Info	*/
	private  String	 invCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 mstBlNo   =  null;
	/*	Column Info	*/
	private  String	 cgoWgt   =  null;
	/*	Column Info	*/
	private  String	 bkgCorrNo   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 frtFwrdCustSeq   =  null;
	/*	Column Info	*/
	private  String	 coStfCtnt   =  null;
	/*	Column Info	*/
	private  String	 custLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 blInvCfmDt   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 siRefNo   =  null;
	/*	Column Info	*/
	private  String	 bkgTeuQty   =  null;
	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 whfDeclCfmDt   =  null;
	/*	Column Info	*/
	private  String	 trunkVvd   =  null;
	/*	Column Info	*/
	private  String	 custRgstNo   =  null;
	/*	Column Info	*/
	private  String	 crCltOfcCd   =  null;
	/*	Column Info	*/
	private  String	 issDt   =  null;
	/*	Column Info	*/
	private  String	 ibCrTermDys   =  null;
	/*	Column Info	*/
	private  String	 rfaNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 bkgFeuQty   =  null;
	/*	Column Info	*/
	private  String	 revSrcCd   =  null;
	/*	Column Info	*/
	private  String	 arIfNo   =  null;
	/*	Column Info	*/
	private  String	 actCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 dueDt   =  null;
	/*	Column Info	*/
	private  String	 bkgCorrDt   =  null;
	/*	Column Info	*/
	private  String	 cgoMeasQty   =  null;
	/*	Column Info	*/
	private  String	 blSrcNo   =  null;
	/*	Column Info	*/
	private  String	 blInvIfDt   =  null;
	/*	Column Info	*/
	private  String	 glEffDt   =  null;
	/*	Column Info	*/
	private  String	 invRefNo   =  null;
	/*	Column Info	*/
	private  String	 invCustSeq   =  null;
	/*	Column Info	*/
	private  String	 bkgNoSplit   =  null;
	/*	Column Info	*/
	private  String	 actCustSeq   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 crCurrCd   =  null;
	/*	Column Info	*/
	private  String	 revTpCd   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 invSplitCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 bkgRefNo   =  null;
	/*	Column Info	*/
	private  String	 slanCd   =  null;
	/*	Column Info	*/
	private  String	 invRmk   =  null;
	/*	Column Info	*/
	private  String	 frtFwrdCntCd   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 localVvd   =  null;
	/*	Column Info	*/
	private  String	 actInvFlag   =  null;
	/*	Column Info	*/
	private  String	 otherFlag   =  null;
	/*	Column Info	*/
	private  String	 znIocCd   =  null;
	/*	Column Info	*/
	private  String	 invDeltDivCd   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 trnkVslCd   =  null;
	/*	Column Info	*/
	private  String	 trnkSkdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 trnkSkdDirCd   =  null;
	/*	Column Info	*/
	private  String	 whfDecNo   =  null;
	/*	Column Info	*/
	private  String	 crFlg   =  null;
	/*	Column Info	*/
	private  String	 otsSmryCd   =  null;
	/*	Column Info	*/
	private  String	 loclCurrCd   =  null;
	/*	Column Info	*/
	private  String	 obrdCd   =  null;
	/*	Column Info	*/
	private  String	 crTermDys   =  null;
	/*	Column Info	*/
	private  String	 custCrFlg   =  null;
	/*	Column Info	*/
	private  String	 xchRtN3rdTpCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtUsdTpCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtDt   =  null;
	/*	Column Info	*/
	private  String	 sailDt   =  null;
	/*	Column Info	*/
	private  String	 usdXchRt   =  null;
	/*	Column Info	*/
	private  String	 destTrnsSvcModCd   =  null;
	/*	Column Info	*/
	private  String	 invSvcScpCd   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 dfltInvCurrDivCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ARInvoiceCorrectionVO(){}

	public ARInvoiceCorrectionVO(String svcScpCd,String whfDeclNo,String sailArrDt,String obCrTermDys,String srepCd,String pagerows,String polCd,String crAmt,String invCustCntCd,String scNo,String mstBlNo,String cgoWgt,String bkgCorrNo,String delCd,String frtFwrdCustSeq,String coStfCtnt,String custLglEngNm,String vvd,String podCd,String blInvCfmDt,String bkgNo,String siRefNo,String bkgTeuQty,String porCd,String whfDeclCfmDt,String trunkVvd,String custRgstNo,String crCltOfcCd,String issDt,String ibCrTermDys,String rfaNo,String ibflag,String bkgFeuQty,String revSrcCd,String arIfNo,String actCustCntCd,String dueDt,String bkgCorrDt,String cgoMeasQty,String blSrcNo,String blInvIfDt,String glEffDt,String invRefNo,String invCustSeq,String bkgNoSplit,String actCustSeq,String ioBndCd,String crCurrCd,String revTpCd,String arOfcCd,String invSplitCd,String invNo,String bkgRefNo,String slanCd,String invRmk,String frtFwrdCntCd,String custNm,String localVvd,String actInvFlag,String otherFlag,String znIocCd,String invDeltDivCd,String vslCd,String skdVoyNo,String skdDirCd,String trnkVslCd,String trnkSkdVoyNo,String trnkSkdDirCd,String whfDecNo,String crFlg,String otsSmryCd,String loclCurrCd,String obrdCd,String crTermDys,String custCrFlg,String xchRtN3rdTpCd,String xchRtUsdTpCd,String xchRtDt,String sailDt,String usdXchRt,String destTrnsSvcModCd,String invSvcScpCd,String invCurrCd,String dfltInvCurrDivCd)	{
		this.svcScpCd  = svcScpCd ;
		this.whfDeclNo  = whfDeclNo ;
		this.sailArrDt  = sailArrDt ;
		this.obCrTermDys  = obCrTermDys ;
		this.srepCd  = srepCd ;
		this.pagerows  = pagerows ;
		this.polCd  = polCd ;
		this.crAmt  = crAmt ;
		this.invCustCntCd  = invCustCntCd ;
		this.scNo  = scNo ;
		this.mstBlNo  = mstBlNo ;
		this.cgoWgt  = cgoWgt ;
		this.bkgCorrNo  = bkgCorrNo ;
		this.delCd  = delCd ;
		this.frtFwrdCustSeq  = frtFwrdCustSeq ;
		this.coStfCtnt  = coStfCtnt ;
		this.custLglEngNm  = custLglEngNm ;
		this.vvd  = vvd ;
		this.podCd  = podCd ;
		this.blInvCfmDt  = blInvCfmDt ;
		this.bkgNo  = bkgNo ;
		this.siRefNo  = siRefNo ;
		this.bkgTeuQty  = bkgTeuQty ;
		this.porCd  = porCd ;
		this.whfDeclCfmDt  = whfDeclCfmDt ;
		this.trunkVvd  = trunkVvd ;
		this.custRgstNo  = custRgstNo ;
		this.crCltOfcCd  = crCltOfcCd ;
		this.issDt  = issDt ;
		this.ibCrTermDys  = ibCrTermDys ;
		this.rfaNo  = rfaNo ;
		this.ibflag  = ibflag ;
		this.bkgFeuQty  = bkgFeuQty ;
		this.revSrcCd  = revSrcCd ;
		this.arIfNo  = arIfNo ;
		this.actCustCntCd  = actCustCntCd ;
		this.dueDt  = dueDt ;
		this.bkgCorrDt  = bkgCorrDt ;
		this.cgoMeasQty  = cgoMeasQty ;
		this.blSrcNo  = blSrcNo ;
		this.blInvIfDt  = blInvIfDt ;
		this.glEffDt  = glEffDt ;
		this.invRefNo  = invRefNo ;
		this.invCustSeq  = invCustSeq ;
		this.bkgNoSplit  = bkgNoSplit ;
		this.actCustSeq  = actCustSeq ;
		this.ioBndCd  = ioBndCd ;
		this.crCurrCd  = crCurrCd ;
		this.revTpCd  = revTpCd ;
		this.arOfcCd  = arOfcCd ;
		this.invSplitCd  = invSplitCd ;
		this.invNo  = invNo ;
		this.bkgRefNo  = bkgRefNo ;
		this.slanCd  = slanCd ;
		this.invRmk  = invRmk ;
		this.frtFwrdCntCd  = frtFwrdCntCd ;
		this.custNm  = custNm ;
		this.localVvd  = localVvd ;
		this.actInvFlag  = actInvFlag ;
		this.otherFlag  = otherFlag ;
		this.znIocCd  = znIocCd ;
		this.invDeltDivCd  = invDeltDivCd ;
		this.vslCd  = vslCd ;
		this.skdVoyNo  = skdVoyNo ;
		this.skdDirCd  = skdDirCd ;
		this.trnkVslCd  = trnkVslCd ;
		this.trnkSkdVoyNo  = trnkSkdVoyNo ;
		this.trnkSkdDirCd  = trnkSkdDirCd ;
		this.whfDecNo  = whfDecNo ;
		this.crFlg  = crFlg ;
		this.otsSmryCd  = otsSmryCd ;
		this.loclCurrCd  = loclCurrCd ;
		this.obrdCd  = obrdCd ;
		this.crTermDys  = crTermDys ;
		this.custCrFlg  = custCrFlg ;
		this.xchRtN3rdTpCd  = xchRtN3rdTpCd ;
		this.xchRtUsdTpCd  = xchRtUsdTpCd ;
		this.xchRtDt  = xchRtDt ;
		this.sailDt  = sailDt ;
		this.usdXchRt  = usdXchRt ;
		this.destTrnsSvcModCd  = destTrnsSvcModCd ;
		this.invSvcScpCd  = invSvcScpCd ;
		this.invCurrCd  = invCurrCd ;
		this.dfltInvCurrDivCd  = dfltInvCurrDivCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("whf_decl_no", getWhfDeclNo());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());		
		this.hashColumns.put("srep_cd", getSrepCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("cr_amt", getCrAmt());		
		this.hashColumns.put("inv_cust_cnt_cd", getInvCustCntCd());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("mst_bl_no", getMstBlNo());		
		this.hashColumns.put("cgo_wgt", getCgoWgt());		
		this.hashColumns.put("bkg_corr_no", getBkgCorrNo());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("frt_fwrd_cust_seq", getFrtFwrdCustSeq());		
		this.hashColumns.put("co_stf_ctnt", getCoStfCtnt());		
		this.hashColumns.put("cust_lgl_eng_nm", getCustLglEngNm());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("bl_inv_cfm_dt", getBlInvCfmDt());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("si_ref_no", getSiRefNo());		
		this.hashColumns.put("bkg_teu_qty", getBkgTeuQty());		
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("whf_decl_cfm_dt", getWhfDeclCfmDt());		
		this.hashColumns.put("trunk_vvd", getTrunkVvd());		
		this.hashColumns.put("cust_rgst_no", getCustRgstNo());		
		this.hashColumns.put("cr_clt_ofc_cd", getCrCltOfcCd());		
		this.hashColumns.put("iss_dt", getIssDt());		
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());		
		this.hashColumns.put("rfa_no", getRfaNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("bkg_feu_qty", getBkgFeuQty());		
		this.hashColumns.put("rev_src_cd", getRevSrcCd());		
		this.hashColumns.put("ar_if_no", getArIfNo());		
		this.hashColumns.put("act_cust_cnt_cd", getActCustCntCd());		
		this.hashColumns.put("due_dt", getDueDt());		
		this.hashColumns.put("bkg_corr_dt", getBkgCorrDt());		
		this.hashColumns.put("cgo_meas_qty", getCgoMeasQty());		
		this.hashColumns.put("bl_src_no", getBlSrcNo());		
		this.hashColumns.put("bl_inv_if_dt", getBlInvIfDt());		
		this.hashColumns.put("gl_eff_dt", getGlEffDt());		
		this.hashColumns.put("inv_ref_no", getInvRefNo());		
		this.hashColumns.put("inv_cust_seq", getInvCustSeq());		
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());		
		this.hashColumns.put("act_cust_seq", getActCustSeq());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());		
		this.hashColumns.put("rev_tp_cd", getRevTpCd());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("inv_split_cd", getInvSplitCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());		
		this.hashColumns.put("slan_cd", getSlanCd());		
		this.hashColumns.put("inv_rmk", getInvRmk());		
		this.hashColumns.put("frt_fwrd_cnt_cd", getFrtFwrdCntCd());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("local_vvd", getLocalVvd());		
		this.hashColumns.put("act_inv_flag", getActInvFlag());		
		this.hashColumns.put("other_flag", getOtherFlag());		
		this.hashColumns.put("zn_ioc_cd", getZnIocCd());		
		this.hashColumns.put("inv_delt_div_cd", getInvDeltDivCd());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("trnk_vsl_cd", getTrnkVslCd());		
		this.hashColumns.put("trnk_skd_voy_no", getTrnkSkdVoyNo());		
		this.hashColumns.put("trnk_skd_dir_cd", getTrnkSkdDirCd());		
		this.hashColumns.put("whf_dec_no", getWhfDecNo());		
		this.hashColumns.put("cr_flg", getCrFlg());		
		this.hashColumns.put("ots_smry_cd", getOtsSmryCd());		
		this.hashColumns.put("locl_curr_cd", getLoclCurrCd());		
		this.hashColumns.put("obrd_cd", getObrdCd());		
		this.hashColumns.put("cr_term_dys", getCrTermDys());		
		this.hashColumns.put("cust_cr_flg", getCustCrFlg());		
		this.hashColumns.put("xch_rt_n3rd_tp_cd", getXchRtN3rdTpCd());		
		this.hashColumns.put("xch_rt_usd_tp_cd", getXchRtUsdTpCd());		
		this.hashColumns.put("xch_rt_dt", getXchRtDt());		
		this.hashColumns.put("sail_dt", getSailDt());		
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());		
		this.hashColumns.put("dest_trns_svc_mod_cd", getDestTrnsSvcModCd());		
		this.hashColumns.put("inv_svc_scp_cd", getInvSvcScpCd());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("dflt_inv_curr_div_cd", getDfltInvCurrDivCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("whf_decl_no", "whfDeclNo");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("inv_cust_cnt_cd", "invCustCntCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("mst_bl_no", "mstBlNo");
		this.hashFields.put("cgo_wgt", "cgoWgt");
		this.hashFields.put("bkg_corr_no", "bkgCorrNo");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("frt_fwrd_cust_seq", "frtFwrdCustSeq");
		this.hashFields.put("co_stf_ctnt", "coStfCtnt");
		this.hashFields.put("cust_lgl_eng_nm", "custLglEngNm");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bl_inv_cfm_dt", "blInvCfmDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("si_ref_no", "siRefNo");
		this.hashFields.put("bkg_teu_qty", "bkgTeuQty");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("whf_decl_cfm_dt", "whfDeclCfmDt");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		this.hashFields.put("cust_rgst_no", "custRgstNo");
		this.hashFields.put("cr_clt_ofc_cd", "crCltOfcCd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_feu_qty", "bkgFeuQty");
		this.hashFields.put("rev_src_cd", "revSrcCd");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("act_cust_cnt_cd", "actCustCntCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("bkg_corr_dt", "bkgCorrDt");
		this.hashFields.put("cgo_meas_qty", "cgoMeasQty");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("bl_inv_if_dt", "blInvIfDt");
		this.hashFields.put("gl_eff_dt", "glEffDt");
		this.hashFields.put("inv_ref_no", "invRefNo");
		this.hashFields.put("inv_cust_seq", "invCustSeq");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("act_cust_seq", "actCustSeq");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("rev_tp_cd", "revTpCd");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("inv_split_cd", "invSplitCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("inv_rmk", "invRmk");
		this.hashFields.put("frt_fwrd_cnt_cd", "frtFwrdCntCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("local_vvd", "localVvd");
		this.hashFields.put("act_inv_flag", "actInvFlag");
		this.hashFields.put("other_flag", "otherFlag");
		this.hashFields.put("zn_ioc_cd", "znIocCd");
		this.hashFields.put("inv_delt_div_cd", "invDeltDivCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("trnk_vsl_cd", "trnkVslCd");
		this.hashFields.put("trnk_skd_voy_no", "trnkSkdVoyNo");
		this.hashFields.put("trnk_skd_dir_cd", "trnkSkdDirCd");
		this.hashFields.put("whf_dec_no", "whfDecNo");
		this.hashFields.put("cr_flg", "crFlg");
		this.hashFields.put("ots_smry_cd", "otsSmryCd");
		this.hashFields.put("locl_curr_cd", "loclCurrCd");
		this.hashFields.put("obrd_cd", "obrdCd");
		this.hashFields.put("cr_term_dys", "crTermDys");
		this.hashFields.put("cust_cr_flg", "custCrFlg");
		this.hashFields.put("xch_rt_n3rd_tp_cd", "xchRtN3rdTpCd");
		this.hashFields.put("xch_rt_usd_tp_cd", "xchRtUsdTpCd");
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("dest_trns_svc_mod_cd", "destTrnsSvcModCd");
		this.hashFields.put("inv_svc_scp_cd", "invSvcScpCd");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("dflt_inv_curr_div_cd", "dfltInvCurrDivCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  whfDeclNo
	*/
	public void	setWhfDeclNo( String	whfDeclNo ) {
		this.whfDeclNo =	whfDeclNo;
	}
 
	/**
	 * Column Info
	 * @return	whfDeclNo
	 */
	 public	 String	getWhfDeclNo() {
		 return	this.whfDeclNo;
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
	* @param  obCrTermDys
	*/
	public void	setObCrTermDys( String	obCrTermDys ) {
		this.obCrTermDys =	obCrTermDys;
	}
 
	/**
	 * Column Info
	 * @return	obCrTermDys
	 */
	 public	 String	getObCrTermDys() {
		 return	this.obCrTermDys;
	 } 
 	/**
	* Column Info
	* @param  srepCd
	*/
	public void	setSrepCd( String	srepCd ) {
		this.srepCd =	srepCd;
	}
 
	/**
	 * Column Info
	 * @return	srepCd
	 */
	 public	 String	getSrepCd() {
		 return	this.srepCd;
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
	* @param  crAmt
	*/
	public void	setCrAmt( String	crAmt ) {
		this.crAmt =	crAmt;
	}
 
	/**
	 * Column Info
	 * @return	crAmt
	 */
	 public	 String	getCrAmt() {
		 return	this.crAmt;
	 } 
 	/**
	* Column Info
	* @param  invCustCntCd
	*/
	public void	setInvCustCntCd( String	invCustCntCd ) {
		this.invCustCntCd =	invCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	invCustCntCd
	 */
	 public	 String	getInvCustCntCd() {
		 return	this.invCustCntCd;
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
	* @param  mstBlNo
	*/
	public void	setMstBlNo( String	mstBlNo ) {
		this.mstBlNo =	mstBlNo;
	}
 
	/**
	 * Column Info
	 * @return	mstBlNo
	 */
	 public	 String	getMstBlNo() {
		 return	this.mstBlNo;
	 } 
 	/**
	* Column Info
	* @param  cgoWgt
	*/
	public void	setCgoWgt( String	cgoWgt ) {
		this.cgoWgt =	cgoWgt;
	}
 
	/**
	 * Column Info
	 * @return	cgoWgt
	 */
	 public	 String	getCgoWgt() {
		 return	this.cgoWgt;
	 } 
 	/**
	* Column Info
	* @param  bkgCorrNo
	*/
	public void	setBkgCorrNo( String	bkgCorrNo ) {
		this.bkgCorrNo =	bkgCorrNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgCorrNo
	 */
	 public	 String	getBkgCorrNo() {
		 return	this.bkgCorrNo;
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
	* @param  frtFwrdCustSeq
	*/
	public void	setFrtFwrdCustSeq( String	frtFwrdCustSeq ) {
		this.frtFwrdCustSeq =	frtFwrdCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	frtFwrdCustSeq
	 */
	 public	 String	getFrtFwrdCustSeq() {
		 return	this.frtFwrdCustSeq;
	 } 
 	/**
	* Column Info
	* @param  coStfCtnt
	*/
	public void	setCoStfCtnt( String	coStfCtnt ) {
		this.coStfCtnt =	coStfCtnt;
	}
 
	/**
	 * Column Info
	 * @return	coStfCtnt
	 */
	 public	 String	getCoStfCtnt() {
		 return	this.coStfCtnt;
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
	* @param  blInvCfmDt
	*/
	public void	setBlInvCfmDt( String	blInvCfmDt ) {
		this.blInvCfmDt =	blInvCfmDt;
	}
 
	/**
	 * Column Info
	 * @return	blInvCfmDt
	 */
	 public	 String	getBlInvCfmDt() {
		 return	this.blInvCfmDt;
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
	* @param  siRefNo
	*/
	public void	setSiRefNo( String	siRefNo ) {
		this.siRefNo =	siRefNo;
	}
 
	/**
	 * Column Info
	 * @return	siRefNo
	 */
	 public	 String	getSiRefNo() {
		 return	this.siRefNo;
	 } 
 	/**
	* Column Info
	* @param  bkgTeuQty
	*/
	public void	setBkgTeuQty( String	bkgTeuQty ) {
		this.bkgTeuQty =	bkgTeuQty;
	}
 
	/**
	 * Column Info
	 * @return	bkgTeuQty
	 */
	 public	 String	getBkgTeuQty() {
		 return	this.bkgTeuQty;
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
	* @param  whfDeclCfmDt
	*/
	public void	setWhfDeclCfmDt( String	whfDeclCfmDt ) {
		this.whfDeclCfmDt =	whfDeclCfmDt;
	}
 
	/**
	 * Column Info
	 * @return	whfDeclCfmDt
	 */
	 public	 String	getWhfDeclCfmDt() {
		 return	this.whfDeclCfmDt;
	 } 
 	/**
	* Column Info
	* @param  trunkVvd
	*/
	public void	setTrunkVvd( String	trunkVvd ) {
		this.trunkVvd =	trunkVvd;
	}
 
	/**
	 * Column Info
	 * @return	trunkVvd
	 */
	 public	 String	getTrunkVvd() {
		 return	this.trunkVvd;
	 } 
 	/**
	* Column Info
	* @param  custRgstNo
	*/
	public void	setCustRgstNo( String	custRgstNo ) {
		this.custRgstNo =	custRgstNo;
	}
 
	/**
	 * Column Info
	 * @return	custRgstNo
	 */
	 public	 String	getCustRgstNo() {
		 return	this.custRgstNo;
	 } 
 	/**
	* Column Info
	* @param  crCltOfcCd
	*/
	public void	setCrCltOfcCd( String	crCltOfcCd ) {
		this.crCltOfcCd =	crCltOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	crCltOfcCd
	 */
	 public	 String	getCrCltOfcCd() {
		 return	this.crCltOfcCd;
	 } 
 	/**
	* Column Info
	* @param  issDt
	*/
	public void	setIssDt( String	issDt ) {
		this.issDt =	issDt;
	}
 
	/**
	 * Column Info
	 * @return	issDt
	 */
	 public	 String	getIssDt() {
		 return	this.issDt;
	 } 
 	/**
	* Column Info
	* @param  ibCrTermDys
	*/
	public void	setIbCrTermDys( String	ibCrTermDys ) {
		this.ibCrTermDys =	ibCrTermDys;
	}
 
	/**
	 * Column Info
	 * @return	ibCrTermDys
	 */
	 public	 String	getIbCrTermDys() {
		 return	this.ibCrTermDys;
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
	* @param  bkgFeuQty
	*/
	public void	setBkgFeuQty( String	bkgFeuQty ) {
		this.bkgFeuQty =	bkgFeuQty;
	}
 
	/**
	 * Column Info
	 * @return	bkgFeuQty
	 */
	 public	 String	getBkgFeuQty() {
		 return	this.bkgFeuQty;
	 } 
 	/**
	* Column Info
	* @param  revSrcCd
	*/
	public void	setRevSrcCd( String	revSrcCd ) {
		this.revSrcCd =	revSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	revSrcCd
	 */
	 public	 String	getRevSrcCd() {
		 return	this.revSrcCd;
	 } 
 	/**
	* Column Info
	* @param  arIfNo
	*/
	public void	setArIfNo( String	arIfNo ) {
		this.arIfNo =	arIfNo;
	}
 
	/**
	 * Column Info
	 * @return	arIfNo
	 */
	 public	 String	getArIfNo() {
		 return	this.arIfNo;
	 } 
 	/**
	* Column Info
	* @param  actCustCntCd
	*/
	public void	setActCustCntCd( String	actCustCntCd ) {
		this.actCustCntCd =	actCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	actCustCntCd
	 */
	 public	 String	getActCustCntCd() {
		 return	this.actCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  dueDt
	*/
	public void	setDueDt( String	dueDt ) {
		this.dueDt =	dueDt;
	}
 
	/**
	 * Column Info
	 * @return	dueDt
	 */
	 public	 String	getDueDt() {
		 return	this.dueDt;
	 } 
 	/**
	* Column Info
	* @param  bkgCorrDt
	*/
	public void	setBkgCorrDt( String	bkgCorrDt ) {
		this.bkgCorrDt =	bkgCorrDt;
	}
 
	/**
	 * Column Info
	 * @return	bkgCorrDt
	 */
	 public	 String	getBkgCorrDt() {
		 return	this.bkgCorrDt;
	 } 
 	/**
	* Column Info
	* @param  cgoMeasQty
	*/
	public void	setCgoMeasQty( String	cgoMeasQty ) {
		this.cgoMeasQty =	cgoMeasQty;
	}
 
	/**
	 * Column Info
	 * @return	cgoMeasQty
	 */
	 public	 String	getCgoMeasQty() {
		 return	this.cgoMeasQty;
	 } 
 	/**
	* Column Info
	* @param  blSrcNo
	*/
	public void	setBlSrcNo( String	blSrcNo ) {
		this.blSrcNo =	blSrcNo;
	}
 
	/**
	 * Column Info
	 * @return	blSrcNo
	 */
	 public	 String	getBlSrcNo() {
		 return	this.blSrcNo;
	 } 
 	/**
	* Column Info
	* @param  blInvIfDt
	*/
	public void	setBlInvIfDt( String	blInvIfDt ) {
		this.blInvIfDt =	blInvIfDt;
	}
 
	/**
	 * Column Info
	 * @return	blInvIfDt
	 */
	 public	 String	getBlInvIfDt() {
		 return	this.blInvIfDt;
	 } 
 	/**
	* Column Info
	* @param  glEffDt
	*/
	public void	setGlEffDt( String	glEffDt ) {
		this.glEffDt =	glEffDt;
	}
 
	/**
	 * Column Info
	 * @return	glEffDt
	 */
	 public	 String	getGlEffDt() {
		 return	this.glEffDt;
	 } 
 	/**
	* Column Info
	* @param  invRefNo
	*/
	public void	setInvRefNo( String	invRefNo ) {
		this.invRefNo =	invRefNo;
	}
 
	/**
	 * Column Info
	 * @return	invRefNo
	 */
	 public	 String	getInvRefNo() {
		 return	this.invRefNo;
	 } 
 	/**
	* Column Info
	* @param  invCustSeq
	*/
	public void	setInvCustSeq( String	invCustSeq ) {
		this.invCustSeq =	invCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	invCustSeq
	 */
	 public	 String	getInvCustSeq() {
		 return	this.invCustSeq;
	 } 
 	/**
	* Column Info
	* @param  bkgNoSplit
	*/
	public void	setBkgNoSplit( String	bkgNoSplit ) {
		this.bkgNoSplit =	bkgNoSplit;
	}
 
	/**
	 * Column Info
	 * @return	bkgNoSplit
	 */
	 public	 String	getBkgNoSplit() {
		 return	this.bkgNoSplit;
	 } 
 	/**
	* Column Info
	* @param  actCustSeq
	*/
	public void	setActCustSeq( String	actCustSeq ) {
		this.actCustSeq =	actCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	actCustSeq
	 */
	 public	 String	getActCustSeq() {
		 return	this.actCustSeq;
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
	* @param  crCurrCd
	*/
	public void	setCrCurrCd( String	crCurrCd ) {
		this.crCurrCd =	crCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	crCurrCd
	 */
	 public	 String	getCrCurrCd() {
		 return	this.crCurrCd;
	 } 
 	/**
	* Column Info
	* @param  revTpCd
	*/
	public void	setRevTpCd( String	revTpCd ) {
		this.revTpCd =	revTpCd;
	}
 
	/**
	 * Column Info
	 * @return	revTpCd
	 */
	 public	 String	getRevTpCd() {
		 return	this.revTpCd;
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
	* @param  invSplitCd
	*/
	public void	setInvSplitCd( String	invSplitCd ) {
		this.invSplitCd =	invSplitCd;
	}
 
	/**
	 * Column Info
	 * @return	invSplitCd
	 */
	 public	 String	getInvSplitCd() {
		 return	this.invSplitCd;
	 } 
 	/**
	* Column Info
	* @param  invNo
	*/
	public void	setInvNo( String	invNo ) {
		this.invNo =	invNo;
	}
 
	/**
	 * Column Info
	 * @return	invNo
	 */
	 public	 String	getInvNo() {
		 return	this.invNo;
	 } 
 	/**
	* Column Info
	* @param  bkgRefNo
	*/
	public void	setBkgRefNo( String	bkgRefNo ) {
		this.bkgRefNo =	bkgRefNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgRefNo
	 */
	 public	 String	getBkgRefNo() {
		 return	this.bkgRefNo;
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
	* @param  invRmk
	*/
	public void	setInvRmk( String	invRmk ) {
		this.invRmk =	invRmk;
	}
 
	/**
	 * Column Info
	 * @return	invRmk
	 */
	 public	 String	getInvRmk() {
		 return	this.invRmk;
	 } 
 	/**
	* Column Info
	* @param  frtFwrdCntCd
	*/
	public void	setFrtFwrdCntCd( String	frtFwrdCntCd ) {
		this.frtFwrdCntCd =	frtFwrdCntCd;
	}
 
	/**
	 * Column Info
	 * @return	frtFwrdCntCd
	 */
	 public	 String	getFrtFwrdCntCd() {
		 return	this.frtFwrdCntCd;
	 } 
 	/**
	* Column Info
	* @param  custNm
	*/
	public void	setCustNm( String	custNm ) {
		this.custNm =	custNm;
	}
 
	/**
	 * Column Info
	 * @return	custNm
	 */
	 public	 String	getCustNm() {
		 return	this.custNm;
	 } 
 	/**
	* Column Info
	* @param  localVvd
	*/
	public void	setLocalVvd( String	localVvd ) {
		this.localVvd =	localVvd;
	}
 
	/**
	 * Column Info
	 * @return	localVvd
	 */
	 public	 String	getLocalVvd() {
		 return	this.localVvd;
	 } 
 	/**
	* Column Info
	* @param  actInvFlag
	*/
	public void	setActInvFlag( String	actInvFlag ) {
		this.actInvFlag =	actInvFlag;
	}
 
	/**
	 * Column Info
	 * @return	actInvFlag
	 */
	 public	 String	getActInvFlag() {
		 return	this.actInvFlag;
	 } 
 	/**
	* Column Info
	* @param  otherFlag
	*/
	public void	setOtherFlag( String	otherFlag ) {
		this.otherFlag =	otherFlag;
	}
 
	/**
	 * Column Info
	 * @return	otherFlag
	 */
	 public	 String	getOtherFlag() {
		 return	this.otherFlag;
	 } 
 	/**
	* Column Info
	* @param  znIocCd
	*/
	public void	setZnIocCd( String	znIocCd ) {
		this.znIocCd =	znIocCd;
	}
 
	/**
	 * Column Info
	 * @return	znIocCd
	 */
	 public	 String	getZnIocCd() {
		 return	this.znIocCd;
	 } 
 	/**
	* Column Info
	* @param  invDeltDivCd
	*/
	public void	setInvDeltDivCd( String	invDeltDivCd ) {
		this.invDeltDivCd =	invDeltDivCd;
	}
 
	/**
	 * Column Info
	 * @return	invDeltDivCd
	 */
	 public	 String	getInvDeltDivCd() {
		 return	this.invDeltDivCd;
	 } 
 	/**
	* Column Info
	* @param  vslCd
	*/
	public void	setVslCd( String	vslCd ) {
		this.vslCd =	vslCd;
	}
 
	/**
	 * Column Info
	 * @return	vslCd
	 */
	 public	 String	getVslCd() {
		 return	this.vslCd;
	 } 
 	/**
	* Column Info
	* @param  skdVoyNo
	*/
	public void	setSkdVoyNo( String	skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	skdVoyNo
	 */
	 public	 String	getSkdVoyNo() {
		 return	this.skdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  skdDirCd
	*/
	public void	setSkdDirCd( String	skdDirCd ) {
		this.skdDirCd =	skdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	skdDirCd
	 */
	 public	 String	getSkdDirCd() {
		 return	this.skdDirCd;
	 } 
 	/**
	* Column Info
	* @param  trnkVslCd
	*/
	public void	setTrnkVslCd( String	trnkVslCd ) {
		this.trnkVslCd =	trnkVslCd;
	}
 
	/**
	 * Column Info
	 * @return	trnkVslCd
	 */
	 public	 String	getTrnkVslCd() {
		 return	this.trnkVslCd;
	 } 
 	/**
	* Column Info
	* @param  trnkSkdVoyNo
	*/
	public void	setTrnkSkdVoyNo( String	trnkSkdVoyNo ) {
		this.trnkSkdVoyNo =	trnkSkdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	trnkSkdVoyNo
	 */
	 public	 String	getTrnkSkdVoyNo() {
		 return	this.trnkSkdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  trnkSkdDirCd
	*/
	public void	setTrnkSkdDirCd( String	trnkSkdDirCd ) {
		this.trnkSkdDirCd =	trnkSkdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	trnkSkdDirCd
	 */
	 public	 String	getTrnkSkdDirCd() {
		 return	this.trnkSkdDirCd;
	 } 
 	/**
	* Column Info
	* @param  whfDecNo
	*/
	public void	setWhfDecNo( String	whfDecNo ) {
		this.whfDecNo =	whfDecNo;
	}
 
	/**
	 * Column Info
	 * @return	whfDecNo
	 */
	 public	 String	getWhfDecNo() {
		 return	this.whfDecNo;
	 } 
 	/**
	* Column Info
	* @param  crFlg
	*/
	public void	setCrFlg( String	crFlg ) {
		this.crFlg =	crFlg;
	}
 
	/**
	 * Column Info
	 * @return	crFlg
	 */
	 public	 String	getCrFlg() {
		 return	this.crFlg;
	 } 
 	/**
	* Column Info
	* @param  otsSmryCd
	*/
	public void	setOtsSmryCd( String	otsSmryCd ) {
		this.otsSmryCd =	otsSmryCd;
	}
 
	/**
	 * Column Info
	 * @return	otsSmryCd
	 */
	 public	 String	getOtsSmryCd() {
		 return	this.otsSmryCd;
	 } 
 	/**
	* Column Info
	* @param  loclCurrCd
	*/
	public void	setLoclCurrCd( String	loclCurrCd ) {
		this.loclCurrCd =	loclCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	loclCurrCd
	 */
	 public	 String	getLoclCurrCd() {
		 return	this.loclCurrCd;
	 } 
 	/**
	* Column Info
	* @param  obrdCd
	*/
	public void	setObrdCd( String	obrdCd ) {
		this.obrdCd =	obrdCd;
	}
 
	/**
	 * Column Info
	 * @return	obrdCd
	 */
	 public	 String	getObrdCd() {
		 return	this.obrdCd;
	 } 
 	/**
	* Column Info
	* @param  crTermDys
	*/
	public void	setCrTermDys( String	crTermDys ) {
		this.crTermDys =	crTermDys;
	}
 
	/**
	 * Column Info
	 * @return	crTermDys
	 */
	 public	 String	getCrTermDys() {
		 return	this.crTermDys;
	 } 
 	/**
	* Column Info
	* @param  custCrFlg
	*/
	public void	setCustCrFlg( String	custCrFlg ) {
		this.custCrFlg =	custCrFlg;
	}
 
	/**
	 * Column Info
	 * @return	custCrFlg
	 */
	 public	 String	getCustCrFlg() {
		 return	this.custCrFlg;
	 } 
 	/**
	* Column Info
	* @param  xchRtN3rdTpCd
	*/
	public void	setXchRtN3rdTpCd( String	xchRtN3rdTpCd ) {
		this.xchRtN3rdTpCd =	xchRtN3rdTpCd;
	}
 
	/**
	 * Column Info
	 * @return	xchRtN3rdTpCd
	 */
	 public	 String	getXchRtN3rdTpCd() {
		 return	this.xchRtN3rdTpCd;
	 } 
 	/**
	* Column Info
	* @param  xchRtUsdTpCd
	*/
	public void	setXchRtUsdTpCd( String	xchRtUsdTpCd ) {
		this.xchRtUsdTpCd =	xchRtUsdTpCd;
	}
 
	/**
	 * Column Info
	 * @return	xchRtUsdTpCd
	 */
	 public	 String	getXchRtUsdTpCd() {
		 return	this.xchRtUsdTpCd;
	 } 
 	/**
	* Column Info
	* @param  xchRtDt
	*/
	public void	setXchRtDt( String	xchRtDt ) {
		this.xchRtDt =	xchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	xchRtDt
	 */
	 public	 String	getXchRtDt() {
		 return	this.xchRtDt;
	 } 
 	/**
	* Column Info
	* @param  sailDt
	*/
	public void	setSailDt( String	sailDt ) {
		this.sailDt =	sailDt;
	}
 
	/**
	 * Column Info
	 * @return	sailDt
	 */
	 public	 String	getSailDt() {
		 return	this.sailDt;
	 } 
 	/**
	* Column Info
	* @param  usdXchRt
	*/
	public void	setUsdXchRt( String	usdXchRt ) {
		this.usdXchRt =	usdXchRt;
	}
 
	/**
	 * Column Info
	 * @return	usdXchRt
	 */
	 public	 String	getUsdXchRt() {
		 return	this.usdXchRt;
	 } 
 	/**
	* Column Info
	* @param  destTrnsSvcModCd
	*/
	public void	setDestTrnsSvcModCd( String	destTrnsSvcModCd ) {
		this.destTrnsSvcModCd =	destTrnsSvcModCd;
	}
 
	/**
	 * Column Info
	 * @return	destTrnsSvcModCd
	 */
	 public	 String	getDestTrnsSvcModCd() {
		 return	this.destTrnsSvcModCd;
	 } 
 	/**
	* Column Info
	* @param  invSvcScpCd
	*/
	public void	setInvSvcScpCd( String	invSvcScpCd ) {
		this.invSvcScpCd =	invSvcScpCd;
	}
 
	/**
	 * Column Info
	 * @return	invSvcScpCd
	 */
	 public	 String	getInvSvcScpCd() {
		 return	this.invSvcScpCd;
	 } 
 	/**
	* Column Info
	* @param  invCurrCd
	*/
	public void	setInvCurrCd( String	invCurrCd ) {
		this.invCurrCd =	invCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	invCurrCd
	 */
	 public	 String	getInvCurrCd() {
		 return	this.invCurrCd;
	 } 
 	/**
	* Column Info
	* @param  dfltInvCurrDivCd
	*/
	public void	setDfltInvCurrDivCd( String	dfltInvCurrDivCd ) {
		this.dfltInvCurrDivCd =	dfltInvCurrDivCd;
	}
 
	/**
	 * Column Info
	 * @return	dfltInvCurrDivCd
	 */
	 public	 String	getDfltInvCurrDivCd() {
		 return	this.dfltInvCurrDivCd;
	 } 

	public List<ARInvoiceChargeSumVO> getListInvoiceChargeSumVO() {
		return listInvoiceChargeSumVO;
	}

	public void setListInvoiceChargeSumVO(
			List<ARInvoiceChargeSumVO> listInvoiceChargeSumVO) {
		this.listInvoiceChargeSumVO = listInvoiceChargeSumVO;
	}

	public List<ARInvoiceChargeCorrectionVO> getListInvoiceChargeCorrectionVO() {
		return listInvoiceChargeCorrectionVO;
	}

	public void setListInvoiceChargeCorrectionVO(
			List<ARInvoiceChargeCorrectionVO> listInvoiceChargeCorrectionVO) {
		this.listInvoiceChargeCorrectionVO = listInvoiceChargeCorrectionVO;
	}

	public List<ARInvoiceContainerVO> getListInvoiceContainerVO() {
		return listInvoiceContainerVO;
	}

	public void setListInvoiceContainerVO(
			List<ARInvoiceContainerVO> listInvoiceContainerVO) {
		this.listInvoiceContainerVO = listInvoiceContainerVO;
	}

	public List<InvArCntrVO> getInvArCntrVO() {
		return invArCntrVO;
	}

	public void setInvArCntrVO(List<InvArCntrVO> invArCntrVO) {
		this.invArCntrVO = invArCntrVO;
	}

	public List<InvArMnVO> getInvArMnVO() {
		return invArMnVO;
	}

	public void setInvArMnVO(List<InvArMnVO> invArMnVO) {
		this.invArMnVO = invArMnVO;
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
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setWhfDeclNo(JSPUtil.getParameter(request,	prefix + "whf_decl_no", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setObCrTermDys(JSPUtil.getParameter(request,	prefix + "ob_cr_term_dys", ""));
		setSrepCd(JSPUtil.getParameter(request,	prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setCrAmt(JSPUtil.getParameter(request,	prefix + "cr_amt", ""));
		setInvCustCntCd(JSPUtil.getParameter(request,	prefix + "inv_cust_cnt_cd", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setMstBlNo(JSPUtil.getParameter(request,	prefix + "mst_bl_no", ""));
		setCgoWgt(JSPUtil.getParameter(request,	prefix + "cgo_wgt", ""));
		setBkgCorrNo(JSPUtil.getParameter(request,	prefix + "bkg_corr_no", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setFrtFwrdCustSeq(JSPUtil.getParameter(request,	prefix + "frt_fwrd_cust_seq", ""));
		setCoStfCtnt(JSPUtil.getParameter(request,	prefix + "co_stf_ctnt", ""));
		setCustLglEngNm(JSPUtil.getParameter(request,	prefix + "cust_lgl_eng_nm", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setBlInvCfmDt(JSPUtil.getParameter(request,	prefix + "bl_inv_cfm_dt", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setSiRefNo(JSPUtil.getParameter(request,	prefix + "si_ref_no", ""));
		setBkgTeuQty(JSPUtil.getParameter(request,	prefix + "bkg_teu_qty", ""));
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setWhfDeclCfmDt(JSPUtil.getParameter(request,	prefix + "whf_decl_cfm_dt", ""));
		setTrunkVvd(JSPUtil.getParameter(request,	prefix + "trunk_vvd", ""));
		setCustRgstNo(JSPUtil.getParameter(request,	prefix + "cust_rgst_no", ""));
		setCrCltOfcCd(JSPUtil.getParameter(request,	prefix + "cr_clt_ofc_cd", ""));
		setIssDt(JSPUtil.getParameter(request,	prefix + "iss_dt", ""));
		setIbCrTermDys(JSPUtil.getParameter(request,	prefix + "ib_cr_term_dys", ""));
		setRfaNo(JSPUtil.getParameter(request,	prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setBkgFeuQty(JSPUtil.getParameter(request,	prefix + "bkg_feu_qty", ""));
		setRevSrcCd(JSPUtil.getParameter(request,	prefix + "rev_src_cd", ""));
		setArIfNo(JSPUtil.getParameter(request,	prefix + "ar_if_no", ""));
		setActCustCntCd(JSPUtil.getParameter(request,	prefix + "act_cust_cnt_cd", ""));
		setDueDt(JSPUtil.getParameter(request,	prefix + "due_dt", ""));
		setBkgCorrDt(JSPUtil.getParameter(request,	prefix + "bkg_corr_dt", ""));
		setCgoMeasQty(JSPUtil.getParameter(request,	prefix + "cgo_meas_qty", ""));
		setBlSrcNo(JSPUtil.getParameter(request,	prefix + "bl_src_no", ""));
		setBlInvIfDt(JSPUtil.getParameter(request,	prefix + "bl_inv_if_dt", ""));
		setGlEffDt(JSPUtil.getParameter(request,	prefix + "gl_eff_dt", ""));
		setInvRefNo(JSPUtil.getParameter(request,	prefix + "inv_ref_no", ""));
		setInvCustSeq(JSPUtil.getParameter(request,	prefix + "inv_cust_seq", ""));
		setBkgNoSplit(JSPUtil.getParameter(request,	prefix + "bkg_no_split", ""));
		setActCustSeq(JSPUtil.getParameter(request,	prefix + "act_cust_seq", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setCrCurrCd(JSPUtil.getParameter(request,	prefix + "cr_curr_cd", ""));
		setRevTpCd(JSPUtil.getParameter(request,	prefix + "rev_tp_cd", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setInvSplitCd(JSPUtil.getParameter(request,	prefix + "inv_split_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setBkgRefNo(JSPUtil.getParameter(request,	prefix + "bkg_ref_no", ""));
		setSlanCd(JSPUtil.getParameter(request,	prefix + "slan_cd", ""));
		setInvRmk(JSPUtil.getParameter(request,	prefix + "inv_rmk", ""));
		setFrtFwrdCntCd(JSPUtil.getParameter(request,	prefix + "frt_fwrd_cnt_cd", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setLocalVvd(JSPUtil.getParameter(request,	prefix + "local_vvd", ""));
		setActInvFlag(JSPUtil.getParameter(request,	prefix + "act_inv_flag", ""));
		setOtherFlag(JSPUtil.getParameter(request,	prefix + "other_flag", ""));
		setZnIocCd(JSPUtil.getParameter(request,	prefix + "zn_ioc_cd", ""));
		setInvDeltDivCd(JSPUtil.getParameter(request,	prefix + "inv_delt_div_cd", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setTrnkVslCd(JSPUtil.getParameter(request,	prefix + "trnk_vsl_cd", ""));
		setTrnkSkdVoyNo(JSPUtil.getParameter(request,	prefix + "trnk_skd_voy_no", ""));
		setTrnkSkdDirCd(JSPUtil.getParameter(request,	prefix + "trnk_skd_dir_cd", ""));
		setWhfDecNo(JSPUtil.getParameter(request,	prefix + "whf_dec_no", ""));
		setCrFlg(JSPUtil.getParameter(request,	prefix + "cr_flg", ""));
		setOtsSmryCd(JSPUtil.getParameter(request,	prefix + "ots_smry_cd", ""));
		setLoclCurrCd(JSPUtil.getParameter(request,	prefix + "locl_curr_cd", ""));
		setObrdCd(JSPUtil.getParameter(request,	prefix + "obrd_cd", ""));
		setCrTermDys(JSPUtil.getParameter(request,	prefix + "cr_term_dys", ""));
		setCustCrFlg(JSPUtil.getParameter(request,	prefix + "cust_cr_flg", ""));
		setXchRtN3rdTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_n3rd_tp_cd", ""));
		setXchRtUsdTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_usd_tp_cd", ""));
		setXchRtDt(JSPUtil.getParameter(request,	prefix + "xch_rt_dt", ""));
		setSailDt(JSPUtil.getParameter(request,	prefix + "sail_dt", ""));
		setUsdXchRt(JSPUtil.getParameter(request,	prefix + "usd_xch_rt", ""));
		setDestTrnsSvcModCd(JSPUtil.getParameter(request,	prefix + "dest_trns_svc_mod_cd", ""));
		setInvSvcScpCd(JSPUtil.getParameter(request,	prefix + "inv_svc_scp_cd", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setDfltInvCurrDivCd(JSPUtil.getParameter(request,	prefix + "dflt_inv_curr_div_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ARInvoiceCorrectionVO[]
	 */
	public ARInvoiceCorrectionVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ARInvoiceCorrectionVO[]
	 */
	public ARInvoiceCorrectionVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ARInvoiceCorrectionVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] whfDeclNo =	(JSPUtil.getParameter(request, prefix +	"whf_decl_no".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] obCrTermDys =	(JSPUtil.getParameter(request, prefix +	"ob_cr_term_dys".trim(),	length));
				String[] srepCd =	(JSPUtil.getParameter(request, prefix +	"srep_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] crAmt =	(JSPUtil.getParameter(request, prefix +	"cr_amt".trim(),	length));
				String[] invCustCntCd =	(JSPUtil.getParameter(request, prefix +	"inv_cust_cnt_cd".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] mstBlNo =	(JSPUtil.getParameter(request, prefix +	"mst_bl_no".trim(),	length));
				String[] cgoWgt =	(JSPUtil.getParameter(request, prefix +	"cgo_wgt".trim(),	length));
				String[] bkgCorrNo =	(JSPUtil.getParameter(request, prefix +	"bkg_corr_no".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] frtFwrdCustSeq =	(JSPUtil.getParameter(request, prefix +	"frt_fwrd_cust_seq".trim(),	length));
				String[] coStfCtnt =	(JSPUtil.getParameter(request, prefix +	"co_stf_ctnt".trim(),	length));
				String[] custLglEngNm =	(JSPUtil.getParameter(request, prefix +	"cust_lgl_eng_nm".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] blInvCfmDt =	(JSPUtil.getParameter(request, prefix +	"bl_inv_cfm_dt".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] siRefNo =	(JSPUtil.getParameter(request, prefix +	"si_ref_no".trim(),	length));
				String[] bkgTeuQty =	(JSPUtil.getParameter(request, prefix +	"bkg_teu_qty".trim(),	length));
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] whfDeclCfmDt =	(JSPUtil.getParameter(request, prefix +	"whf_decl_cfm_dt".trim(),	length));
				String[] trunkVvd =	(JSPUtil.getParameter(request, prefix +	"trunk_vvd".trim(),	length));
				String[] custRgstNo =	(JSPUtil.getParameter(request, prefix +	"cust_rgst_no".trim(),	length));
				String[] crCltOfcCd =	(JSPUtil.getParameter(request, prefix +	"cr_clt_ofc_cd".trim(),	length));
				String[] issDt =	(JSPUtil.getParameter(request, prefix +	"iss_dt".trim(),	length));
				String[] ibCrTermDys =	(JSPUtil.getParameter(request, prefix +	"ib_cr_term_dys".trim(),	length));
				String[] rfaNo =	(JSPUtil.getParameter(request, prefix +	"rfa_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] bkgFeuQty =	(JSPUtil.getParameter(request, prefix +	"bkg_feu_qty".trim(),	length));
				String[] revSrcCd =	(JSPUtil.getParameter(request, prefix +	"rev_src_cd".trim(),	length));
				String[] arIfNo =	(JSPUtil.getParameter(request, prefix +	"ar_if_no".trim(),	length));
				String[] actCustCntCd =	(JSPUtil.getParameter(request, prefix +	"act_cust_cnt_cd".trim(),	length));
				String[] dueDt =	(JSPUtil.getParameter(request, prefix +	"due_dt".trim(),	length));
				String[] bkgCorrDt =	(JSPUtil.getParameter(request, prefix +	"bkg_corr_dt".trim(),	length));
				String[] cgoMeasQty =	(JSPUtil.getParameter(request, prefix +	"cgo_meas_qty".trim(),	length));
				String[] blSrcNo =	(JSPUtil.getParameter(request, prefix +	"bl_src_no".trim(),	length));
				String[] blInvIfDt =	(JSPUtil.getParameter(request, prefix +	"bl_inv_if_dt".trim(),	length));
				String[] glEffDt =	(JSPUtil.getParameter(request, prefix +	"gl_eff_dt".trim(),	length));
				String[] invRefNo =	(JSPUtil.getParameter(request, prefix +	"inv_ref_no".trim(),	length));
				String[] invCustSeq =	(JSPUtil.getParameter(request, prefix +	"inv_cust_seq".trim(),	length));
				String[] bkgNoSplit =	(JSPUtil.getParameter(request, prefix +	"bkg_no_split".trim(),	length));
				String[] actCustSeq =	(JSPUtil.getParameter(request, prefix +	"act_cust_seq".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] crCurrCd =	(JSPUtil.getParameter(request, prefix +	"cr_curr_cd".trim(),	length));
				String[] revTpCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_cd".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] invSplitCd =	(JSPUtil.getParameter(request, prefix +	"inv_split_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] bkgRefNo =	(JSPUtil.getParameter(request, prefix +	"bkg_ref_no".trim(),	length));
				String[] slanCd =	(JSPUtil.getParameter(request, prefix +	"slan_cd".trim(),	length));
				String[] invRmk =	(JSPUtil.getParameter(request, prefix +	"inv_rmk".trim(),	length));
				String[] frtFwrdCntCd =	(JSPUtil.getParameter(request, prefix +	"frt_fwrd_cnt_cd".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] localVvd =	(JSPUtil.getParameter(request, prefix +	"local_vvd".trim(),	length));
				String[] actInvFlag =	(JSPUtil.getParameter(request, prefix +	"act_inv_flag".trim(),	length));
				String[] otherFlag =	(JSPUtil.getParameter(request, prefix +	"other_flag".trim(),	length));
				String[] znIocCd =	(JSPUtil.getParameter(request, prefix +	"zn_ioc_cd".trim(),	length));
				String[] invDeltDivCd =	(JSPUtil.getParameter(request, prefix +	"inv_delt_div_cd".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] trnkVslCd =	(JSPUtil.getParameter(request, prefix +	"trnk_vsl_cd".trim(),	length));
				String[] trnkSkdVoyNo =	(JSPUtil.getParameter(request, prefix +	"trnk_skd_voy_no".trim(),	length));
				String[] trnkSkdDirCd =	(JSPUtil.getParameter(request, prefix +	"trnk_skd_dir_cd".trim(),	length));
				String[] whfDecNo =	(JSPUtil.getParameter(request, prefix +	"whf_dec_no".trim(),	length));
				String[] crFlg =	(JSPUtil.getParameter(request, prefix +	"cr_flg".trim(),	length));
				String[] otsSmryCd =	(JSPUtil.getParameter(request, prefix +	"ots_smry_cd".trim(),	length));
				String[] loclCurrCd =	(JSPUtil.getParameter(request, prefix +	"locl_curr_cd".trim(),	length));
				String[] obrdCd =	(JSPUtil.getParameter(request, prefix +	"obrd_cd".trim(),	length));
				String[] crTermDys =	(JSPUtil.getParameter(request, prefix +	"cr_term_dys".trim(),	length));
				String[] custCrFlg =	(JSPUtil.getParameter(request, prefix +	"cust_cr_flg".trim(),	length));
				String[] xchRtN3rdTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_n3rd_tp_cd".trim(),	length));
				String[] xchRtUsdTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_usd_tp_cd".trim(),	length));
				String[] xchRtDt =	(JSPUtil.getParameter(request, prefix +	"xch_rt_dt".trim(),	length));
				String[] sailDt =	(JSPUtil.getParameter(request, prefix +	"sail_dt".trim(),	length));
				String[] usdXchRt =	(JSPUtil.getParameter(request, prefix +	"usd_xch_rt".trim(),	length));
				String[] destTrnsSvcModCd =	(JSPUtil.getParameter(request, prefix +	"dest_trns_svc_mod_cd".trim(),	length));
				String[] invSvcScpCd =	(JSPUtil.getParameter(request, prefix +	"inv_svc_scp_cd".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] dfltInvCurrDivCd =	(JSPUtil.getParameter(request, prefix +	"dflt_inv_curr_div_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ARInvoiceCorrectionVO();
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( whfDeclNo[i] !=	null)
						model.setWhfDeclNo( whfDeclNo[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( obCrTermDys[i] !=	null)
						model.setObCrTermDys( obCrTermDys[i]);
						if ( srepCd[i] !=	null)
						model.setSrepCd( srepCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( crAmt[i] !=	null)
						model.setCrAmt( crAmt[i]);
						if ( invCustCntCd[i] !=	null)
						model.setInvCustCntCd( invCustCntCd[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( mstBlNo[i] !=	null)
						model.setMstBlNo( mstBlNo[i]);
						if ( cgoWgt[i] !=	null)
						model.setCgoWgt( cgoWgt[i]);
						if ( bkgCorrNo[i] !=	null)
						model.setBkgCorrNo( bkgCorrNo[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( frtFwrdCustSeq[i] !=	null)
						model.setFrtFwrdCustSeq( frtFwrdCustSeq[i]);
						if ( coStfCtnt[i] !=	null)
						model.setCoStfCtnt( coStfCtnt[i]);
						if ( custLglEngNm[i] !=	null)
						model.setCustLglEngNm( custLglEngNm[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( blInvCfmDt[i] !=	null)
						model.setBlInvCfmDt( blInvCfmDt[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( siRefNo[i] !=	null)
						model.setSiRefNo( siRefNo[i]);
						if ( bkgTeuQty[i] !=	null)
						model.setBkgTeuQty( bkgTeuQty[i]);
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( whfDeclCfmDt[i] !=	null)
						model.setWhfDeclCfmDt( whfDeclCfmDt[i]);
						if ( trunkVvd[i] !=	null)
						model.setTrunkVvd( trunkVvd[i]);
						if ( custRgstNo[i] !=	null)
						model.setCustRgstNo( custRgstNo[i]);
						if ( crCltOfcCd[i] !=	null)
						model.setCrCltOfcCd( crCltOfcCd[i]);
						if ( issDt[i] !=	null)
						model.setIssDt( issDt[i]);
						if ( ibCrTermDys[i] !=	null)
						model.setIbCrTermDys( ibCrTermDys[i]);
						if ( rfaNo[i] !=	null)
						model.setRfaNo( rfaNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( bkgFeuQty[i] !=	null)
						model.setBkgFeuQty( bkgFeuQty[i]);
						if ( revSrcCd[i] !=	null)
						model.setRevSrcCd( revSrcCd[i]);
						if ( arIfNo[i] !=	null)
						model.setArIfNo( arIfNo[i]);
						if ( actCustCntCd[i] !=	null)
						model.setActCustCntCd( actCustCntCd[i]);
						if ( dueDt[i] !=	null)
						model.setDueDt( dueDt[i]);
						if ( bkgCorrDt[i] !=	null)
						model.setBkgCorrDt( bkgCorrDt[i]);
						if ( cgoMeasQty[i] !=	null)
						model.setCgoMeasQty( cgoMeasQty[i]);
						if ( blSrcNo[i] !=	null)
						model.setBlSrcNo( blSrcNo[i]);
						if ( blInvIfDt[i] !=	null)
						model.setBlInvIfDt( blInvIfDt[i]);
						if ( glEffDt[i] !=	null)
						model.setGlEffDt( glEffDt[i]);
						if ( invRefNo[i] !=	null)
						model.setInvRefNo( invRefNo[i]);
						if ( invCustSeq[i] !=	null)
						model.setInvCustSeq( invCustSeq[i]);
						if ( bkgNoSplit[i] !=	null)
						model.setBkgNoSplit( bkgNoSplit[i]);
						if ( actCustSeq[i] !=	null)
						model.setActCustSeq( actCustSeq[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( crCurrCd[i] !=	null)
						model.setCrCurrCd( crCurrCd[i]);
						if ( revTpCd[i] !=	null)
						model.setRevTpCd( revTpCd[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( invSplitCd[i] !=	null)
						model.setInvSplitCd( invSplitCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( bkgRefNo[i] !=	null)
						model.setBkgRefNo( bkgRefNo[i]);
						if ( slanCd[i] !=	null)
						model.setSlanCd( slanCd[i]);
						if ( invRmk[i] !=	null)
						model.setInvRmk( invRmk[i]);
						if ( frtFwrdCntCd[i] !=	null)
						model.setFrtFwrdCntCd( frtFwrdCntCd[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( localVvd[i] !=	null)
						model.setLocalVvd( localVvd[i]);
						if ( actInvFlag[i] !=	null)
						model.setActInvFlag( actInvFlag[i]);
						if ( otherFlag[i] !=	null)
						model.setOtherFlag( otherFlag[i]);
						if ( znIocCd[i] !=	null)
						model.setZnIocCd( znIocCd[i]);
						if ( invDeltDivCd[i] !=	null)
						model.setInvDeltDivCd( invDeltDivCd[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( trnkVslCd[i] !=	null)
						model.setTrnkVslCd( trnkVslCd[i]);
						if ( trnkSkdVoyNo[i] !=	null)
						model.setTrnkSkdVoyNo( trnkSkdVoyNo[i]);
						if ( trnkSkdDirCd[i] !=	null)
						model.setTrnkSkdDirCd( trnkSkdDirCd[i]);
						if ( whfDecNo[i] !=	null)
						model.setWhfDecNo( whfDecNo[i]);
						if ( crFlg[i] !=	null)
						model.setCrFlg( crFlg[i]);
						if ( otsSmryCd[i] !=	null)
						model.setOtsSmryCd( otsSmryCd[i]);
						if ( loclCurrCd[i] !=	null)
						model.setLoclCurrCd( loclCurrCd[i]);
						if ( obrdCd[i] !=	null)
						model.setObrdCd( obrdCd[i]);
						if ( crTermDys[i] !=	null)
						model.setCrTermDys( crTermDys[i]);
						if ( custCrFlg[i] !=	null)
						model.setCustCrFlg( custCrFlg[i]);
						if ( xchRtN3rdTpCd[i] !=	null)
						model.setXchRtN3rdTpCd( xchRtN3rdTpCd[i]);
						if ( xchRtUsdTpCd[i] !=	null)
						model.setXchRtUsdTpCd( xchRtUsdTpCd[i]);
						if ( xchRtDt[i] !=	null)
						model.setXchRtDt( xchRtDt[i]);
						if ( sailDt[i] !=	null)
						model.setSailDt( sailDt[i]);
						if ( usdXchRt[i] !=	null)
						model.setUsdXchRt( usdXchRt[i]);
						if ( destTrnsSvcModCd[i] !=	null)
						model.setDestTrnsSvcModCd( destTrnsSvcModCd[i]);
						if ( invSvcScpCd[i] !=	null)
						model.setInvSvcScpCd( invSvcScpCd[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( dfltInvCurrDivCd[i] !=	null)
						model.setDfltInvCurrDivCd( dfltInvCurrDivCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getARInvoiceCorrectionVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ARInvoiceCorrectionVO[]
	 */
	public ARInvoiceCorrectionVO[]	 getARInvoiceCorrectionVOs(){
		ARInvoiceCorrectionVO[] vos = (ARInvoiceCorrectionVO[])models.toArray(new	ARInvoiceCorrectionVO[models.size()]);
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
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclNo =	this.whfDeclNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys =	this.obCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd =	this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt =	this.crAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustCntCd =	this.invCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstBlNo =	this.mstBlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoWgt =	this.cgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrNo =	this.bkgCorrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCustSeq =	this.frtFwrdCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coStfCtnt =	this.coStfCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custLglEngNm =	this.custLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvCfmDt =	this.blInvCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.siRefNo =	this.siRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTeuQty =	this.bkgTeuQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDeclCfmDt =	this.whfDeclCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd =	this.trunkVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custRgstNo =	this.custRgstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCltOfcCd =	this.crCltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt =	this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys =	this.ibCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo =	this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFeuQty =	this.bkgFeuQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revSrcCd =	this.revSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo =	this.arIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustCntCd =	this.actCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt =	this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCorrDt =	this.bkgCorrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoMeasQty =	this.cgoMeasQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo =	this.blSrcNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blInvIfDt =	this.blInvIfDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glEffDt =	this.glEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRefNo =	this.invRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCustSeq =	this.invCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit =	this.bkgNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustSeq =	this.actCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd =	this.crCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpCd =	this.revTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSplitCd =	this.invSplitCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo =	this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd =	this.slanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRmk =	this.invRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCntCd =	this.frtFwrdCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.localVvd =	this.localVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvFlag =	this.actInvFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otherFlag =	this.otherFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.znIocCd =	this.znIocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDeltDivCd =	this.invDeltDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVslCd =	this.trnkVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdVoyNo =	this.trnkSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkSkdDirCd =	this.trnkSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whfDecNo =	this.whfDecNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crFlg =	this.crFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSmryCd =	this.otsSmryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCurrCd =	this.loclCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obrdCd =	this.obrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crTermDys =	this.crTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCrFlg =	this.custCrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtN3rdTpCd =	this.xchRtN3rdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtUsdTpCd =	this.xchRtUsdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDt =	this.xchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt =	this.sailDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt =	this.usdXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsSvcModCd =	this.destTrnsSvcModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSvcScpCd =	this.invSvcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltInvCurrDivCd =	this.dfltInvCurrDivCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}