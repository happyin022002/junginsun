/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : TesTmlSoDtlVO.java
 *@FileTitle : TesTmlSoDtlVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.07.26
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.07.26  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.syscommon.common.table;

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
 * - 愿��젴	Event�뿉�꽌	�옉�꽦,	�꽌踰꾩떎�뻾�슂泥��떆	PDTO�쓽 �뿭�븷�쓣 �닔�뻾�븯�뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class TesTmlSoDtlVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<TesTmlSoDtlVO>  models =	new	ArrayList<TesTmlSoDtlVO>();


	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 stkVolQty   =  null;
	/*	Column Info	*/
	private  String	 toTrVolVal   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 fincVslCd   =  null;
	/*	Column Info	*/
	private  String	 tmlAgmtVerNo   =  null;
	/*	Column Info	*/
	private  String	 freeDyXcldDys   =  null;
	/*	Column Info	*/
	private  String	 volTrUtCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 calcVolQty   =  null;
	/*	Column Info	*/
	private  String	 tmlSoDtlSeq   =  null;
	/*	Column Info	*/
	private  String	 invXchRt   =  null;
	/*	Column Info	*/
	private  String	 revYrmon   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 dcgoIndCd   =  null;
	/*	Column Info	*/
	private  String	 calcAmt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 fpTeuQty   =  null;
	/*	Column Info	*/
	private  String	 tmlAgmtSeq   =  null;
	/*	Column Info	*/
	private  String	 tmlSoSeq   =  null;
	/*	Column Info	*/
	private  String	 loclUpdDt   =  null;
	/*	Column Info	*/
	private  String	 rcFlg   =  null;
	/*	Column Info	*/
	private  String	 ovrDys   =  null;
	/*	Column Info	*/
	private  String	 laneCd   =  null;
	/*	Column Info	*/
	private  String	 ediSoDtlId   =  null;
	/*	Column Info	*/
	private  String	 tmlTrnsModCd   =  null;
	/*	Column Info	*/
	private  String	 semiAutoCalcFlg   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 fincSkdDirCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 tmlCrrCd   =  null;
	/*	Column Info	*/
	private  String	 calcCostGrpCd   =  null;
	/*	Column Info	*/
	private  String	 atbDt   =  null;
	/*	Column Info	*/
	private  String	 calcTpCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 stayDys   =  null;
	/*	Column Info	*/
	private  String	 fpCalcPrdCd   =  null;
	/*	Column Info	*/
	private  String	 acctCd   =  null;
	/*	Column Info	*/
	private  String	 invAmt   =  null;
	/*	Column Info	*/
	private  String	 wrkDt   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 n3ptyFlg   =  null;
	/*	Column Info	*/
	private  String	 iocCd   =  null;
	/*	Column Info	*/
	private  String	 ovrVolQty   =  null;
	/*	Column Info	*/
	private  String	 tmlAgmtOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 fincSkdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 rvisVolQty   =  null;
	/*	Column Info	*/
	private  String	 ctrtRt   =  null;
	/*	Column Info	*/
	private  String	 refVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 calcRmk   =  null;
	/*	Column Info	*/
	private  String	 loclCreDt   =  null;
	/*	Column Info	*/
	private  String	 fmTrVolVal   =  null;
	/*	Column Info	*/
	private  String	 diffVolQty   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 payDys   =  null;
	/*	Column Info	*/
	private  String	 freeDys   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 lgsCostCd   =  null;
	/*	Column Info	*/
	private  String	 rfMntrDys   =  null;
	/*	Column Info	*/
	private  String	 plugTerm   =  null;
	/*	Column Info	*/
	private  String	 tmlWrkDyCd   =  null;
	/*	Column Info	*/
	private  String	 invVolQty   =  null;
	/*	Column Info	*/
	private  String	 tmlSoOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 lgOfcCd   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 idaSacCd   =  null;
	/*	Column Info	*/
	private  String	 idaPayTpCd   =  null;
	/*	Column Info	*/
	private  String	 idaCgstRto   =  null;
	/*	Column Info	*/
	private  String	 idaCgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaSgstRto   =  null;
	/*	Column Info	*/
	private  String	 idaSgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaIgstRto   =  null;
	/*	Column Info	*/
	private  String	 idaIgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaUgstRto   =  null;
	/*	Column Info	*/
	private  String	 idaUgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaGstRto   =  null;
	/*	Column Info	*/
	private  String	 idaGstAmt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public TesTmlSoDtlVO(){}

	public TesTmlSoDtlVO(String vslCd,String stkVolQty,String toTrVolVal,String pagerows,String fincVslCd,String tmlAgmtVerNo,String freeDyXcldDys,String volTrUtCd,String cntrTpszCd,String updUsrId,String calcVolQty,String tmlSoDtlSeq,String invXchRt,String revYrmon,String skdVoyNo,String dcgoIndCd,String calcAmt,String creUsrId,String fpTeuQty,String tmlAgmtSeq,String tmlSoSeq,String loclUpdDt,String rcFlg,String ovrDys,String laneCd,String ediSoDtlId,String tmlTrnsModCd,String semiAutoCalcFlg,String currCd,String fincSkdDirCd,String creDt,String tmlCrrCd,String calcCostGrpCd,String atbDt,String calcTpCd,String ibflag,String stayDys,String fpCalcPrdCd,String acctCd,String invAmt,String wrkDt,String updDt,String n3ptyFlg,String iocCd,String ovrVolQty,String tmlAgmtOfcCtyCd,String fincSkdVoyNo,String rvisVolQty,String ctrtRt,String refVndrSeq,String calcRmk,String loclCreDt,String fmTrVolVal,String diffVolQty,String ioBndCd,String skdDirCd,String payDys,String freeDys,String cntrNo,String lgsCostCd,String rfMntrDys,String plugTerm,String tmlWrkDyCd,String invVolQty,String tmlSoOfcCtyCd,String bkgNo,String lgOfcCd,String vvd,String idaSacCd,String idaPayTpCd,String idaCgstRto,String idaCgstAmt,String idaSgstRto,String idaSgstAmt,String idaIgstRto,String idaIgstAmt,String idaUgstRto,String idaUgstAmt,String idaGstRto,String idaGstAmt)	{
		this.vslCd  = vslCd ;
		this.stkVolQty  = stkVolQty ;
		this.toTrVolVal  = toTrVolVal ;
		this.pagerows  = pagerows ;
		this.fincVslCd  = fincVslCd ;
		this.tmlAgmtVerNo  = tmlAgmtVerNo ;
		this.freeDyXcldDys  = freeDyXcldDys ;
		this.volTrUtCd  = volTrUtCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.updUsrId  = updUsrId ;
		this.calcVolQty  = calcVolQty ;
		this.tmlSoDtlSeq  = tmlSoDtlSeq ;
		this.invXchRt  = invXchRt ;
		this.revYrmon  = revYrmon ;
		this.skdVoyNo  = skdVoyNo ;
		this.dcgoIndCd  = dcgoIndCd ;
		this.calcAmt  = calcAmt ;
		this.creUsrId  = creUsrId ;
		this.fpTeuQty  = fpTeuQty ;
		this.tmlAgmtSeq  = tmlAgmtSeq ;
		this.tmlSoSeq  = tmlSoSeq ;
		this.loclUpdDt  = loclUpdDt ;
		this.rcFlg  = rcFlg ;
		this.ovrDys  = ovrDys ;
		this.laneCd  = laneCd ;
		this.ediSoDtlId  = ediSoDtlId ;
		this.tmlTrnsModCd  = tmlTrnsModCd ;
		this.semiAutoCalcFlg  = semiAutoCalcFlg ;
		this.currCd  = currCd ;
		this.fincSkdDirCd  = fincSkdDirCd ;
		this.creDt  = creDt ;
		this.tmlCrrCd  = tmlCrrCd ;
		this.calcCostGrpCd  = calcCostGrpCd ;
		this.atbDt  = atbDt ;
		this.calcTpCd  = calcTpCd ;
		this.ibflag  = ibflag ;
		this.stayDys  = stayDys ;
		this.fpCalcPrdCd  = fpCalcPrdCd ;
		this.acctCd  = acctCd ;
		this.invAmt  = invAmt ;
		this.wrkDt  = wrkDt ;
		this.updDt  = updDt ;
		this.n3ptyFlg  = n3ptyFlg ;
		this.iocCd  = iocCd ;
		this.ovrVolQty  = ovrVolQty ;
		this.tmlAgmtOfcCtyCd  = tmlAgmtOfcCtyCd ;
		this.fincSkdVoyNo  = fincSkdVoyNo ;
		this.rvisVolQty  = rvisVolQty ;
		this.ctrtRt  = ctrtRt ;
		this.refVndrSeq  = refVndrSeq ;
		this.calcRmk  = calcRmk ;
		this.loclCreDt  = loclCreDt ;
		this.fmTrVolVal  = fmTrVolVal ;
		this.diffVolQty  = diffVolQty ;
		this.ioBndCd  = ioBndCd ;
		this.skdDirCd  = skdDirCd ;
		this.payDys  = payDys ;
		this.freeDys  = freeDys ;
		this.cntrNo  = cntrNo ;
		this.lgsCostCd  = lgsCostCd ;
		this.rfMntrDys  = rfMntrDys ;
		this.plugTerm  = plugTerm ;
		this.tmlWrkDyCd  = tmlWrkDyCd ;
		this.invVolQty  = invVolQty ;
		this.tmlSoOfcCtyCd  = tmlSoOfcCtyCd ;
		this.bkgNo  = bkgNo ;
		this.lgOfcCd  = lgOfcCd ;
		this.vvd  = vvd ;
		this.idaSacCd  = idaSacCd ;
		this.idaPayTpCd  = idaPayTpCd ;
		this.idaCgstRto  = idaCgstRto ;
		this.idaCgstAmt  = idaCgstAmt ;
		this.idaSgstRto  = idaSgstRto ;
		this.idaSgstAmt  = idaSgstAmt ;
		this.idaIgstRto  = idaIgstRto ;
		this.idaIgstAmt  = idaIgstAmt ;
		this.idaUgstRto  = idaUgstRto ;
		this.idaUgstAmt  = idaUgstAmt ;
		this.idaGstRto  = idaGstRto ;
		this.idaGstAmt  = idaGstAmt ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("stk_vol_qty", getStkVolQty());		
		this.hashColumns.put("to_tr_vol_val", getToTrVolVal());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("finc_vsl_cd", getFincVslCd());		
		this.hashColumns.put("tml_agmt_ver_no", getTmlAgmtVerNo());		
		this.hashColumns.put("free_dy_xcld_dys", getFreeDyXcldDys());		
		this.hashColumns.put("vol_tr_ut_cd", getVolTrUtCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("calc_vol_qty", getCalcVolQty());		
		this.hashColumns.put("tml_so_dtl_seq", getTmlSoDtlSeq());		
		this.hashColumns.put("inv_xch_rt", getInvXchRt());		
		this.hashColumns.put("rev_yrmon", getRevYrmon());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("dcgo_ind_cd", getDcgoIndCd());		
		this.hashColumns.put("calc_amt", getCalcAmt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("fp_teu_qty", getFpTeuQty());		
		this.hashColumns.put("tml_agmt_seq", getTmlAgmtSeq());		
		this.hashColumns.put("tml_so_seq", getTmlSoSeq());		
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());		
		this.hashColumns.put("rc_flg", getRcFlg());		
		this.hashColumns.put("ovr_dys", getOvrDys());		
		this.hashColumns.put("lane_cd", getLaneCd());		
		this.hashColumns.put("edi_so_dtl_id", getEdiSoDtlId());		
		this.hashColumns.put("tml_trns_mod_cd", getTmlTrnsModCd());		
		this.hashColumns.put("semi_auto_calc_flg", getSemiAutoCalcFlg());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("finc_skd_dir_cd", getFincSkdDirCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("tml_crr_cd", getTmlCrrCd());		
		this.hashColumns.put("calc_cost_grp_cd", getCalcCostGrpCd());		
		this.hashColumns.put("atb_dt", getAtbDt());		
		this.hashColumns.put("calc_tp_cd", getCalcTpCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("stay_dys", getStayDys());		
		this.hashColumns.put("fp_calc_prd_cd", getFpCalcPrdCd());		
		this.hashColumns.put("acct_cd", getAcctCd());		
		this.hashColumns.put("inv_amt", getInvAmt());		
		this.hashColumns.put("wrk_dt", getWrkDt());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("n3pty_flg", getN3ptyFlg());		
		this.hashColumns.put("ioc_cd", getIocCd());		
		this.hashColumns.put("ovr_vol_qty", getOvrVolQty());		
		this.hashColumns.put("tml_agmt_ofc_cty_cd", getTmlAgmtOfcCtyCd());		
		this.hashColumns.put("finc_skd_voy_no", getFincSkdVoyNo());		
		this.hashColumns.put("rvis_vol_qty", getRvisVolQty());		
		this.hashColumns.put("ctrt_rt", getCtrtRt());		
		this.hashColumns.put("ref_vndr_seq", getRefVndrSeq());		
		this.hashColumns.put("calc_rmk", getCalcRmk());		
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());		
		this.hashColumns.put("fm_tr_vol_val", getFmTrVolVal());		
		this.hashColumns.put("diff_vol_qty", getDiffVolQty());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("pay_dys", getPayDys());		
		this.hashColumns.put("free_dys", getFreeDys());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("lgs_cost_cd", getLgsCostCd());		
		this.hashColumns.put("rf_mntr_dys", getRfMntrDys());		
		this.hashColumns.put("plug_term", getPlugTerm());		
		this.hashColumns.put("tml_wrk_dy_cd", getTmlWrkDyCd());		
		this.hashColumns.put("inv_vol_qty", getInvVolQty());		
		this.hashColumns.put("tml_so_ofc_cty_cd", getTmlSoOfcCtyCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("lg_ofc_cd", getLgOfcCd());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("ida_sac_cd", getIdaSacCd());		
		this.hashColumns.put("ida_pay_tp_cd", getIdaPayTpCd());		
		this.hashColumns.put("ida_cgst_rto", getIdaCgstRto());		
		this.hashColumns.put("ida_cgst_amt", getIdaCgstAmt());		
		this.hashColumns.put("ida_sgst_rto", getIdaSgstRto());		
		this.hashColumns.put("ida_sgst_amt", getIdaSgstAmt());		
		this.hashColumns.put("ida_igst_rto", getIdaIgstRto());		
		this.hashColumns.put("ida_igst_amt", getIdaIgstAmt());		
		this.hashColumns.put("ida_ugst_rto", getIdaUgstRto());		
		this.hashColumns.put("ida_ugst_amt", getIdaUgstAmt());		
		this.hashColumns.put("ida_gst_rto", getIdaGstRto());		
		this.hashColumns.put("ida_gst_amt", getIdaGstAmt());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("stk_vol_qty", "stkVolQty");
		this.hashFields.put("to_tr_vol_val", "toTrVolVal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("finc_vsl_cd", "fincVslCd");
		this.hashFields.put("tml_agmt_ver_no", "tmlAgmtVerNo");
		this.hashFields.put("free_dy_xcld_dys", "freeDyXcldDys");
		this.hashFields.put("vol_tr_ut_cd", "volTrUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("calc_vol_qty", "calcVolQty");
		this.hashFields.put("tml_so_dtl_seq", "tmlSoDtlSeq");
		this.hashFields.put("inv_xch_rt", "invXchRt");
		this.hashFields.put("rev_yrmon", "revYrmon");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("dcgo_ind_cd", "dcgoIndCd");
		this.hashFields.put("calc_amt", "calcAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("fp_teu_qty", "fpTeuQty");
		this.hashFields.put("tml_agmt_seq", "tmlAgmtSeq");
		this.hashFields.put("tml_so_seq", "tmlSoSeq");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("ovr_dys", "ovrDys");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("edi_so_dtl_id", "ediSoDtlId");
		this.hashFields.put("tml_trns_mod_cd", "tmlTrnsModCd");
		this.hashFields.put("semi_auto_calc_flg", "semiAutoCalcFlg");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("finc_skd_dir_cd", "fincSkdDirCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tml_crr_cd", "tmlCrrCd");
		this.hashFields.put("calc_cost_grp_cd", "calcCostGrpCd");
		this.hashFields.put("atb_dt", "atbDt");
		this.hashFields.put("calc_tp_cd", "calcTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stay_dys", "stayDys");
		this.hashFields.put("fp_calc_prd_cd", "fpCalcPrdCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("inv_amt", "invAmt");
		this.hashFields.put("wrk_dt", "wrkDt");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("n3pty_flg", "n3ptyFlg");
		this.hashFields.put("ioc_cd", "iocCd");
		this.hashFields.put("ovr_vol_qty", "ovrVolQty");
		this.hashFields.put("tml_agmt_ofc_cty_cd", "tmlAgmtOfcCtyCd");
		this.hashFields.put("finc_skd_voy_no", "fincSkdVoyNo");
		this.hashFields.put("rvis_vol_qty", "rvisVolQty");
		this.hashFields.put("ctrt_rt", "ctrtRt");
		this.hashFields.put("ref_vndr_seq", "refVndrSeq");
		this.hashFields.put("calc_rmk", "calcRmk");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("fm_tr_vol_val", "fmTrVolVal");
		this.hashFields.put("diff_vol_qty", "diffVolQty");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pay_dys", "payDys");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("lgs_cost_cd", "lgsCostCd");
		this.hashFields.put("rf_mntr_dys", "rfMntrDys");
		this.hashFields.put("plug_term", "plugTerm");
		this.hashFields.put("tml_wrk_dy_cd", "tmlWrkDyCd");
		this.hashFields.put("inv_vol_qty", "invVolQty");
		this.hashFields.put("tml_so_ofc_cty_cd", "tmlSoOfcCtyCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("lg_ofc_cd", "lgOfcCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("ida_sac_cd", "idaSacCd");
		this.hashFields.put("ida_pay_tp_cd", "idaPayTpCd");
		this.hashFields.put("ida_cgst_rto", "idaCgstRto");
		this.hashFields.put("ida_cgst_amt", "idaCgstAmt");
		this.hashFields.put("ida_sgst_rto", "idaSgstRto");
		this.hashFields.put("ida_sgst_amt", "idaSgstAmt");
		this.hashFields.put("ida_igst_rto", "idaIgstRto");
		this.hashFields.put("ida_igst_amt", "idaIgstAmt");
		this.hashFields.put("ida_ugst_rto", "idaUgstRto");
		this.hashFields.put("ida_ugst_amt", "idaUgstAmt");
		this.hashFields.put("ida_gst_rto", "idaGstRto");
		this.hashFields.put("ida_gst_amt", "idaGstAmt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  stkVolQty
	*/
	public void	setStkVolQty( String	stkVolQty ) {
		this.stkVolQty =	stkVolQty;
	}
 
	/**
	 * Column Info
	 * @return	stkVolQty
	 */
	 public	 String	getStkVolQty() {
		 return	this.stkVolQty;
	 } 
 	/**
	* Column Info
	* @param  toTrVolVal
	*/
	public void	setToTrVolVal( String	toTrVolVal ) {
		this.toTrVolVal =	toTrVolVal;
	}
 
	/**
	 * Column Info
	 * @return	toTrVolVal
	 */
	 public	 String	getToTrVolVal() {
		 return	this.toTrVolVal;
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
	* @param  fincVslCd
	*/
	public void	setFincVslCd( String	fincVslCd ) {
		this.fincVslCd =	fincVslCd;
	}
 
	/**
	 * Column Info
	 * @return	fincVslCd
	 */
	 public	 String	getFincVslCd() {
		 return	this.fincVslCd;
	 } 
 	/**
	* Column Info
	* @param  tmlAgmtVerNo
	*/
	public void	setTmlAgmtVerNo( String	tmlAgmtVerNo ) {
		this.tmlAgmtVerNo =	tmlAgmtVerNo;
	}
 
	/**
	 * Column Info
	 * @return	tmlAgmtVerNo
	 */
	 public	 String	getTmlAgmtVerNo() {
		 return	this.tmlAgmtVerNo;
	 } 
 	/**
	* Column Info
	* @param  freeDyXcldDys
	*/
	public void	setFreeDyXcldDys( String	freeDyXcldDys ) {
		this.freeDyXcldDys =	freeDyXcldDys;
	}
 
	/**
	 * Column Info
	 * @return	freeDyXcldDys
	 */
	 public	 String	getFreeDyXcldDys() {
		 return	this.freeDyXcldDys;
	 } 
 	/**
	* Column Info
	* @param  volTrUtCd
	*/
	public void	setVolTrUtCd( String	volTrUtCd ) {
		this.volTrUtCd =	volTrUtCd;
	}
 
	/**
	 * Column Info
	 * @return	volTrUtCd
	 */
	 public	 String	getVolTrUtCd() {
		 return	this.volTrUtCd;
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
	* @param  calcVolQty
	*/
	public void	setCalcVolQty( String	calcVolQty ) {
		this.calcVolQty =	calcVolQty;
	}
 
	/**
	 * Column Info
	 * @return	calcVolQty
	 */
	 public	 String	getCalcVolQty() {
		 return	this.calcVolQty;
	 } 
 	/**
	* Column Info
	* @param  tmlSoDtlSeq
	*/
	public void	setTmlSoDtlSeq( String	tmlSoDtlSeq ) {
		this.tmlSoDtlSeq =	tmlSoDtlSeq;
	}
 
	/**
	 * Column Info
	 * @return	tmlSoDtlSeq
	 */
	 public	 String	getTmlSoDtlSeq() {
		 return	this.tmlSoDtlSeq;
	 } 
 	/**
	* Column Info
	* @param  invXchRt
	*/
	public void	setInvXchRt( String	invXchRt ) {
		this.invXchRt =	invXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invXchRt
	 */
	 public	 String	getInvXchRt() {
		 return	this.invXchRt;
	 } 
 	/**
	* Column Info
	* @param  revYrmon
	*/
	public void	setRevYrmon( String	revYrmon ) {
		this.revYrmon =	revYrmon;
	}
 
	/**
	 * Column Info
	 * @return	revYrmon
	 */
	 public	 String	getRevYrmon() {
		 return	this.revYrmon;
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
	* @param  dcgoIndCd
	*/
	public void	setDcgoIndCd( String	dcgoIndCd ) {
		this.dcgoIndCd =	dcgoIndCd;
	}
 
	/**
	 * Column Info
	 * @return	dcgoIndCd
	 */
	 public	 String	getDcgoIndCd() {
		 return	this.dcgoIndCd;
	 } 
 	/**
	* Column Info
	* @param  calcAmt
	*/
	public void	setCalcAmt( String	calcAmt ) {
		this.calcAmt =	calcAmt;
	}
 
	/**
	 * Column Info
	 * @return	calcAmt
	 */
	 public	 String	getCalcAmt() {
		 return	this.calcAmt;
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
	* @param  fpTeuQty
	*/
	public void	setFpTeuQty( String	fpTeuQty ) {
		this.fpTeuQty =	fpTeuQty;
	}
 
	/**
	 * Column Info
	 * @return	fpTeuQty
	 */
	 public	 String	getFpTeuQty() {
		 return	this.fpTeuQty;
	 } 
 	/**
	* Column Info
	* @param  tmlAgmtSeq
	*/
	public void	setTmlAgmtSeq( String	tmlAgmtSeq ) {
		this.tmlAgmtSeq =	tmlAgmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	tmlAgmtSeq
	 */
	 public	 String	getTmlAgmtSeq() {
		 return	this.tmlAgmtSeq;
	 } 
 	/**
	* Column Info
	* @param  tmlSoSeq
	*/
	public void	setTmlSoSeq( String	tmlSoSeq ) {
		this.tmlSoSeq =	tmlSoSeq;
	}
 
	/**
	 * Column Info
	 * @return	tmlSoSeq
	 */
	 public	 String	getTmlSoSeq() {
		 return	this.tmlSoSeq;
	 } 
 	/**
	* Column Info
	* @param  loclUpdDt
	*/
	public void	setLoclUpdDt( String	loclUpdDt ) {
		this.loclUpdDt =	loclUpdDt;
	}
 
	/**
	 * Column Info
	 * @return	loclUpdDt
	 */
	 public	 String	getLoclUpdDt() {
		 return	this.loclUpdDt;
	 } 
 	/**
	* Column Info
	* @param  rcFlg
	*/
	public void	setRcFlg( String	rcFlg ) {
		this.rcFlg =	rcFlg;
	}
 
	/**
	 * Column Info
	 * @return	rcFlg
	 */
	 public	 String	getRcFlg() {
		 return	this.rcFlg;
	 } 
 	/**
	* Column Info
	* @param  ovrDys
	*/
	public void	setOvrDys( String	ovrDys ) {
		this.ovrDys =	ovrDys;
	}
 
	/**
	 * Column Info
	 * @return	ovrDys
	 */
	 public	 String	getOvrDys() {
		 return	this.ovrDys;
	 } 
 	/**
	* Column Info
	* @param  laneCd
	*/
	public void	setLaneCd( String	laneCd ) {
		this.laneCd =	laneCd;
	}
 
	/**
	 * Column Info
	 * @return	laneCd
	 */
	 public	 String	getLaneCd() {
		 return	this.laneCd;
	 } 
 	/**
	* Column Info
	* @param  ediSoDtlId
	*/
	public void	setEdiSoDtlId( String	ediSoDtlId ) {
		this.ediSoDtlId =	ediSoDtlId;
	}
 
	/**
	 * Column Info
	 * @return	ediSoDtlId
	 */
	 public	 String	getEdiSoDtlId() {
		 return	this.ediSoDtlId;
	 } 
 	/**
	* Column Info
	* @param  tmlTrnsModCd
	*/
	public void	setTmlTrnsModCd( String	tmlTrnsModCd ) {
		this.tmlTrnsModCd =	tmlTrnsModCd;
	}
 
	/**
	 * Column Info
	 * @return	tmlTrnsModCd
	 */
	 public	 String	getTmlTrnsModCd() {
		 return	this.tmlTrnsModCd;
	 } 
 	/**
	* Column Info
	* @param  semiAutoCalcFlg
	*/
	public void	setSemiAutoCalcFlg( String	semiAutoCalcFlg ) {
		this.semiAutoCalcFlg =	semiAutoCalcFlg;
	}
 
	/**
	 * Column Info
	 * @return	semiAutoCalcFlg
	 */
	 public	 String	getSemiAutoCalcFlg() {
		 return	this.semiAutoCalcFlg;
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
	* @param  fincSkdDirCd
	*/
	public void	setFincSkdDirCd( String	fincSkdDirCd ) {
		this.fincSkdDirCd =	fincSkdDirCd;
	}
 
	/**
	 * Column Info
	 * @return	fincSkdDirCd
	 */
	 public	 String	getFincSkdDirCd() {
		 return	this.fincSkdDirCd;
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
	* @param  tmlCrrCd
	*/
	public void	setTmlCrrCd( String	tmlCrrCd ) {
		this.tmlCrrCd =	tmlCrrCd;
	}
 
	/**
	 * Column Info
	 * @return	tmlCrrCd
	 */
	 public	 String	getTmlCrrCd() {
		 return	this.tmlCrrCd;
	 } 
 	/**
	* Column Info
	* @param  calcCostGrpCd
	*/
	public void	setCalcCostGrpCd( String	calcCostGrpCd ) {
		this.calcCostGrpCd =	calcCostGrpCd;
	}
 
	/**
	 * Column Info
	 * @return	calcCostGrpCd
	 */
	 public	 String	getCalcCostGrpCd() {
		 return	this.calcCostGrpCd;
	 } 
 	/**
	* Column Info
	* @param  atbDt
	*/
	public void	setAtbDt( String	atbDt ) {
		this.atbDt =	atbDt;
	}
 
	/**
	 * Column Info
	 * @return	atbDt
	 */
	 public	 String	getAtbDt() {
		 return	this.atbDt;
	 } 
 	/**
	* Column Info
	* @param  calcTpCd
	*/
	public void	setCalcTpCd( String	calcTpCd ) {
		this.calcTpCd =	calcTpCd;
	}
 
	/**
	 * Column Info
	 * @return	calcTpCd
	 */
	 public	 String	getCalcTpCd() {
		 return	this.calcTpCd;
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
	* @param  fpCalcPrdCd
	*/
	public void	setFpCalcPrdCd( String	fpCalcPrdCd ) {
		this.fpCalcPrdCd =	fpCalcPrdCd;
	}
 
	/**
	 * Column Info
	 * @return	fpCalcPrdCd
	 */
	 public	 String	getFpCalcPrdCd() {
		 return	this.fpCalcPrdCd;
	 } 
 	/**
	* Column Info
	* @param  acctCd
	*/
	public void	setAcctCd( String	acctCd ) {
		this.acctCd =	acctCd;
	}
 
	/**
	 * Column Info
	 * @return	acctCd
	 */
	 public	 String	getAcctCd() {
		 return	this.acctCd;
	 } 
 	/**
	* Column Info
	* @param  invAmt
	*/
	public void	setInvAmt( String	invAmt ) {
		this.invAmt =	invAmt;
	}
 
	/**
	 * Column Info
	 * @return	invAmt
	 */
	 public	 String	getInvAmt() {
		 return	this.invAmt;
	 } 
 	/**
	* Column Info
	* @param  wrkDt
	*/
	public void	setWrkDt( String	wrkDt ) {
		this.wrkDt =	wrkDt;
	}
 
	/**
	 * Column Info
	 * @return	wrkDt
	 */
	 public	 String	getWrkDt() {
		 return	this.wrkDt;
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
	* @param  n3ptyFlg
	*/
	public void	setN3ptyFlg( String	n3ptyFlg ) {
		this.n3ptyFlg =	n3ptyFlg;
	}
 
	/**
	 * Column Info
	 * @return	n3ptyFlg
	 */
	 public	 String	getN3ptyFlg() {
		 return	this.n3ptyFlg;
	 } 
 	/**
	* Column Info
	* @param  iocCd
	*/
	public void	setIocCd( String	iocCd ) {
		this.iocCd =	iocCd;
	}
 
	/**
	 * Column Info
	 * @return	iocCd
	 */
	 public	 String	getIocCd() {
		 return	this.iocCd;
	 } 
 	/**
	* Column Info
	* @param  ovrVolQty
	*/
	public void	setOvrVolQty( String	ovrVolQty ) {
		this.ovrVolQty =	ovrVolQty;
	}
 
	/**
	 * Column Info
	 * @return	ovrVolQty
	 */
	 public	 String	getOvrVolQty() {
		 return	this.ovrVolQty;
	 } 
 	/**
	* Column Info
	* @param  tmlAgmtOfcCtyCd
	*/
	public void	setTmlAgmtOfcCtyCd( String	tmlAgmtOfcCtyCd ) {
		this.tmlAgmtOfcCtyCd =	tmlAgmtOfcCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	tmlAgmtOfcCtyCd
	 */
	 public	 String	getTmlAgmtOfcCtyCd() {
		 return	this.tmlAgmtOfcCtyCd;
	 } 
 	/**
	* Column Info
	* @param  fincSkdVoyNo
	*/
	public void	setFincSkdVoyNo( String	fincSkdVoyNo ) {
		this.fincSkdVoyNo =	fincSkdVoyNo;
	}
 
	/**
	 * Column Info
	 * @return	fincSkdVoyNo
	 */
	 public	 String	getFincSkdVoyNo() {
		 return	this.fincSkdVoyNo;
	 } 
 	/**
	* Column Info
	* @param  rvisVolQty
	*/
	public void	setRvisVolQty( String	rvisVolQty ) {
		this.rvisVolQty =	rvisVolQty;
	}
 
	/**
	 * Column Info
	 * @return	rvisVolQty
	 */
	 public	 String	getRvisVolQty() {
		 return	this.rvisVolQty;
	 } 
 	/**
	* Column Info
	* @param  ctrtRt
	*/
	public void	setCtrtRt( String	ctrtRt ) {
		this.ctrtRt =	ctrtRt;
	}
 
	/**
	 * Column Info
	 * @return	ctrtRt
	 */
	 public	 String	getCtrtRt() {
		 return	this.ctrtRt;
	 } 
 	/**
	* Column Info
	* @param  refVndrSeq
	*/
	public void	setRefVndrSeq( String	refVndrSeq ) {
		this.refVndrSeq =	refVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	refVndrSeq
	 */
	 public	 String	getRefVndrSeq() {
		 return	this.refVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  calcRmk
	*/
	public void	setCalcRmk( String	calcRmk ) {
		this.calcRmk =	calcRmk;
	}
 
	/**
	 * Column Info
	 * @return	calcRmk
	 */
	 public	 String	getCalcRmk() {
		 return	this.calcRmk;
	 } 
 	/**
	* Column Info
	* @param  loclCreDt
	*/
	public void	setLoclCreDt( String	loclCreDt ) {
		this.loclCreDt =	loclCreDt;
	}
 
	/**
	 * Column Info
	 * @return	loclCreDt
	 */
	 public	 String	getLoclCreDt() {
		 return	this.loclCreDt;
	 } 
 	/**
	* Column Info
	* @param  fmTrVolVal
	*/
	public void	setFmTrVolVal( String	fmTrVolVal ) {
		this.fmTrVolVal =	fmTrVolVal;
	}
 
	/**
	 * Column Info
	 * @return	fmTrVolVal
	 */
	 public	 String	getFmTrVolVal() {
		 return	this.fmTrVolVal;
	 } 
 	/**
	* Column Info
	* @param  diffVolQty
	*/
	public void	setDiffVolQty( String	diffVolQty ) {
		this.diffVolQty =	diffVolQty;
	}
 
	/**
	 * Column Info
	 * @return	diffVolQty
	 */
	 public	 String	getDiffVolQty() {
		 return	this.diffVolQty;
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
	* @param  payDys
	*/
	public void	setPayDys( String	payDys ) {
		this.payDys =	payDys;
	}
 
	/**
	 * Column Info
	 * @return	payDys
	 */
	 public	 String	getPayDys() {
		 return	this.payDys;
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
	* @param  lgsCostCd
	*/
	public void	setLgsCostCd( String	lgsCostCd ) {
		this.lgsCostCd =	lgsCostCd;
	}
 
	/**
	 * Column Info
	 * @return	lgsCostCd
	 */
	 public	 String	getLgsCostCd() {
		 return	this.lgsCostCd;
	 } 
 	/**
	* Column Info
	* @param  rfMntrDys
	*/
	public void	setRfMntrDys( String	rfMntrDys ) {
		this.rfMntrDys =	rfMntrDys;
	}
 
	/**
	 * Column Info
	 * @return	rfMntrDys
	 */
	 public	 String	getRfMntrDys() {
		 return	this.rfMntrDys;
	 } 
 	/**
	* Column Info
	* @param  plugTerm
	*/
	public void	setPlugTerm( String	plugTerm ) {
		this.plugTerm =	plugTerm;
	}
 
	/**
	 * Column Info
	 * @return	plugTerm
	 */
	 public	 String	getPlugTerm() {
		 return	this.plugTerm;
	 } 
 	/**
	* Column Info
	* @param  tmlWrkDyCd
	*/
	public void	setTmlWrkDyCd( String	tmlWrkDyCd ) {
		this.tmlWrkDyCd =	tmlWrkDyCd;
	}
 
	/**
	 * Column Info
	 * @return	tmlWrkDyCd
	 */
	 public	 String	getTmlWrkDyCd() {
		 return	this.tmlWrkDyCd;
	 } 
 	/**
	* Column Info
	* @param  invVolQty
	*/
	public void	setInvVolQty( String	invVolQty ) {
		this.invVolQty =	invVolQty;
	}
 
	/**
	 * Column Info
	 * @return	invVolQty
	 */
	 public	 String	getInvVolQty() {
		 return	this.invVolQty;
	 } 
 	/**
	* Column Info
	* @param  tmlSoOfcCtyCd
	*/
	public void	setTmlSoOfcCtyCd( String	tmlSoOfcCtyCd ) {
		this.tmlSoOfcCtyCd =	tmlSoOfcCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	tmlSoOfcCtyCd
	 */
	 public	 String	getTmlSoOfcCtyCd() {
		 return	this.tmlSoOfcCtyCd;
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
	* @param  lgOfcCd
	*/
	public void	setLgOfcCd( String	lgOfcCd ) {
		this.lgOfcCd =	lgOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	lgOfcCd
	 */
	 public	 String	getLgOfcCd() {
		 return	this.lgOfcCd;
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
	* @param  idaSacCd
	*/
	public void	setIdaSacCd( String	idaSacCd ) {
		this.idaSacCd =	idaSacCd;
	}
 
	/**
	 * Column Info
	 * @return	idaSacCd
	 */
	 public	 String	getIdaSacCd() {
		 return	this.idaSacCd;
	 } 
 	/**
	* Column Info
	* @param  idaPayTpCd
	*/
	public void	setIdaPayTpCd( String	idaPayTpCd ) {
		this.idaPayTpCd =	idaPayTpCd;
	}
 
	/**
	 * Column Info
	 * @return	idaPayTpCd
	 */
	 public	 String	getIdaPayTpCd() {
		 return	this.idaPayTpCd;
	 } 
 	/**
	* Column Info
	* @param  idaCgstRto
	*/
	public void	setIdaCgstRto( String	idaCgstRto ) {
		this.idaCgstRto =	idaCgstRto;
	}
 
	/**
	 * Column Info
	 * @return	idaCgstRto
	 */
	 public	 String	getIdaCgstRto() {
		 return	this.idaCgstRto;
	 } 
 	/**
	* Column Info
	* @param  idaCgstAmt
	*/
	public void	setIdaCgstAmt( String	idaCgstAmt ) {
		this.idaCgstAmt =	idaCgstAmt;
	}
 
	/**
	 * Column Info
	 * @return	idaCgstAmt
	 */
	 public	 String	getIdaCgstAmt() {
		 return	this.idaCgstAmt;
	 } 
 	/**
	* Column Info
	* @param  idaSgstRto
	*/
	public void	setIdaSgstRto( String	idaSgstRto ) {
		this.idaSgstRto =	idaSgstRto;
	}
 
	/**
	 * Column Info
	 * @return	idaSgstRto
	 */
	 public	 String	getIdaSgstRto() {
		 return	this.idaSgstRto;
	 } 
 	/**
	* Column Info
	* @param  idaSgstAmt
	*/
	public void	setIdaSgstAmt( String	idaSgstAmt ) {
		this.idaSgstAmt =	idaSgstAmt;
	}
 
	/**
	 * Column Info
	 * @return	idaSgstAmt
	 */
	 public	 String	getIdaSgstAmt() {
		 return	this.idaSgstAmt;
	 } 
 	/**
	* Column Info
	* @param  idaIgstRto
	*/
	public void	setIdaIgstRto( String	idaIgstRto ) {
		this.idaIgstRto =	idaIgstRto;
	}
 
	/**
	 * Column Info
	 * @return	idaIgstRto
	 */
	 public	 String	getIdaIgstRto() {
		 return	this.idaIgstRto;
	 } 
 	/**
	* Column Info
	* @param  idaIgstAmt
	*/
	public void	setIdaIgstAmt( String	idaIgstAmt ) {
		this.idaIgstAmt =	idaIgstAmt;
	}
 
	/**
	 * Column Info
	 * @return	idaIgstAmt
	 */
	 public	 String	getIdaIgstAmt() {
		 return	this.idaIgstAmt;
	 } 
 	/**
	* Column Info
	* @param  idaUgstRto
	*/
	public void	setIdaUgstRto( String	idaUgstRto ) {
		this.idaUgstRto =	idaUgstRto;
	}
 
	/**
	 * Column Info
	 * @return	idaUgstRto
	 */
	 public	 String	getIdaUgstRto() {
		 return	this.idaUgstRto;
	 } 
 	/**
	* Column Info
	* @param  idaUgstAmt
	*/
	public void	setIdaUgstAmt( String	idaUgstAmt ) {
		this.idaUgstAmt =	idaUgstAmt;
	}
 
	/**
	 * Column Info
	 * @return	idaUgstAmt
	 */
	 public	 String	getIdaUgstAmt() {
		 return	this.idaUgstAmt;
	 } 
 	/**
	* Column Info
	* @param  idaGstRto
	*/
	public void	setIdaGstRto( String	idaGstRto ) {
		this.idaGstRto =	idaGstRto;
	}
 
	/**
	 * Column Info
	 * @return	idaGstRto
	 */
	 public	 String	getIdaGstRto() {
		 return	this.idaGstRto;
	 } 
 	/**
	* Column Info
	* @param  idaGstAmt
	*/
	public void	setIdaGstAmt( String	idaGstAmt ) {
		this.idaGstAmt =	idaGstAmt;
	}
 
	/**
	 * Column Info
	 * @return	idaGstAmt
	 */
	 public	 String	getIdaGstAmt() {
		 return	this.idaGstAmt;
	 } 

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request �쓽 �뜲�씠�꽣瑜� 異붿텧�븯�뿬 VO �쓽	硫ㅻ쾭蹂��닔�뿉 �꽕�젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setStkVolQty(JSPUtil.getParameter(request,	prefix + "stk_vol_qty", ""));
		setToTrVolVal(JSPUtil.getParameter(request,	prefix + "to_tr_vol_val", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setFincVslCd(JSPUtil.getParameter(request,	prefix + "finc_vsl_cd", ""));
		setTmlAgmtVerNo(JSPUtil.getParameter(request,	prefix + "tml_agmt_ver_no", ""));
		setFreeDyXcldDys(JSPUtil.getParameter(request,	prefix + "free_dy_xcld_dys", ""));
		setVolTrUtCd(JSPUtil.getParameter(request,	prefix + "vol_tr_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setCalcVolQty(JSPUtil.getParameter(request,	prefix + "calc_vol_qty", ""));
		setTmlSoDtlSeq(JSPUtil.getParameter(request,	prefix + "tml_so_dtl_seq", ""));
		setInvXchRt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt", ""));
		setRevYrmon(JSPUtil.getParameter(request,	prefix + "rev_yrmon", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setDcgoIndCd(JSPUtil.getParameter(request,	prefix + "dcgo_ind_cd", ""));
		setCalcAmt(JSPUtil.getParameter(request,	prefix + "calc_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setFpTeuQty(JSPUtil.getParameter(request,	prefix + "fp_teu_qty", ""));
		setTmlAgmtSeq(JSPUtil.getParameter(request,	prefix + "tml_agmt_seq", ""));
		setTmlSoSeq(JSPUtil.getParameter(request,	prefix + "tml_so_seq", ""));
		setLoclUpdDt(JSPUtil.getParameter(request,	prefix + "locl_upd_dt", ""));
		setRcFlg(JSPUtil.getParameter(request,	prefix + "rc_flg", ""));
		setOvrDys(JSPUtil.getParameter(request,	prefix + "ovr_dys", ""));
		setLaneCd(JSPUtil.getParameter(request,	prefix + "lane_cd", ""));
		setEdiSoDtlId(JSPUtil.getParameter(request,	prefix + "edi_so_dtl_id", ""));
		setTmlTrnsModCd(JSPUtil.getParameter(request,	prefix + "tml_trns_mod_cd", ""));
		setSemiAutoCalcFlg(JSPUtil.getParameter(request,	prefix + "semi_auto_calc_flg", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setFincSkdDirCd(JSPUtil.getParameter(request,	prefix + "finc_skd_dir_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setTmlCrrCd(JSPUtil.getParameter(request,	prefix + "tml_crr_cd", ""));
		setCalcCostGrpCd(JSPUtil.getParameter(request,	prefix + "calc_cost_grp_cd", ""));
		setAtbDt(JSPUtil.getParameter(request,	prefix + "atb_dt", ""));
		setCalcTpCd(JSPUtil.getParameter(request,	prefix + "calc_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setStayDys(JSPUtil.getParameter(request,	prefix + "stay_dys", ""));
		setFpCalcPrdCd(JSPUtil.getParameter(request,	prefix + "fp_calc_prd_cd", ""));
		setAcctCd(JSPUtil.getParameter(request,	prefix + "acct_cd", ""));
		setInvAmt(JSPUtil.getParameter(request,	prefix + "inv_amt", ""));
		setWrkDt(JSPUtil.getParameter(request,	prefix + "wrk_dt", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setN3ptyFlg(JSPUtil.getParameter(request,	prefix + "n3pty_flg", ""));
		setIocCd(JSPUtil.getParameter(request,	prefix + "ioc_cd", ""));
		setOvrVolQty(JSPUtil.getParameter(request,	prefix + "ovr_vol_qty", ""));
		setTmlAgmtOfcCtyCd(JSPUtil.getParameter(request,	prefix + "tml_agmt_ofc_cty_cd", ""));
		setFincSkdVoyNo(JSPUtil.getParameter(request,	prefix + "finc_skd_voy_no", ""));
		setRvisVolQty(JSPUtil.getParameter(request,	prefix + "rvis_vol_qty", ""));
		setCtrtRt(JSPUtil.getParameter(request,	prefix + "ctrt_rt", ""));
		setRefVndrSeq(JSPUtil.getParameter(request,	prefix + "ref_vndr_seq", ""));
		setCalcRmk(JSPUtil.getParameter(request,	prefix + "calc_rmk", ""));
		setLoclCreDt(JSPUtil.getParameter(request,	prefix + "locl_cre_dt", ""));
		setFmTrVolVal(JSPUtil.getParameter(request,	prefix + "fm_tr_vol_val", ""));
		setDiffVolQty(JSPUtil.getParameter(request,	prefix + "diff_vol_qty", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setPayDys(JSPUtil.getParameter(request,	prefix + "pay_dys", ""));
		setFreeDys(JSPUtil.getParameter(request,	prefix + "free_dys", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setLgsCostCd(JSPUtil.getParameter(request,	prefix + "lgs_cost_cd", ""));
		setRfMntrDys(JSPUtil.getParameter(request,	prefix + "rf_mntr_dys", ""));
		setPlugTerm(JSPUtil.getParameter(request,	prefix + "plug_term", ""));
		setTmlWrkDyCd(JSPUtil.getParameter(request,	prefix + "tml_wrk_dy_cd", ""));
		setInvVolQty(JSPUtil.getParameter(request,	prefix + "inv_vol_qty", ""));
		setTmlSoOfcCtyCd(JSPUtil.getParameter(request,	prefix + "tml_so_ofc_cty_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setLgOfcCd(JSPUtil.getParameter(request,	prefix + "lg_ofc_cd", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setIdaSacCd(JSPUtil.getParameter(request,	prefix + "ida_sac_cd", ""));
		setIdaPayTpCd(JSPUtil.getParameter(request,	prefix + "ida_pay_tp_cd", ""));
		setIdaCgstRto(JSPUtil.getParameter(request,	prefix + "ida_cgst_rto", ""));
		setIdaCgstAmt(JSPUtil.getParameter(request,	prefix + "ida_cgst_amt", ""));
		setIdaSgstRto(JSPUtil.getParameter(request,	prefix + "ida_sgst_rto", ""));
		setIdaSgstAmt(JSPUtil.getParameter(request,	prefix + "ida_sgst_amt", ""));
		setIdaIgstRto(JSPUtil.getParameter(request,	prefix + "ida_igst_rto", ""));
		setIdaIgstAmt(JSPUtil.getParameter(request,	prefix + "ida_igst_amt", ""));
		setIdaUgstRto(JSPUtil.getParameter(request,	prefix + "ida_ugst_rto", ""));
		setIdaUgstAmt(JSPUtil.getParameter(request,	prefix + "ida_ugst_amt", ""));
		setIdaGstRto(JSPUtil.getParameter(request,	prefix + "ida_gst_rto", ""));
		setIdaGstAmt(JSPUtil.getParameter(request,	prefix + "ida_gst_amt", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return TesTmlSoDtlVO[]
	 */
	public TesTmlSoDtlVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return TesTmlSoDtlVO[]
	 */
	public TesTmlSoDtlVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		TesTmlSoDtlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] stkVolQty =	(JSPUtil.getParameter(request, prefix +	"stk_vol_qty".trim(),	length));
				String[] toTrVolVal =	(JSPUtil.getParameter(request, prefix +	"to_tr_vol_val".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] fincVslCd =	(JSPUtil.getParameter(request, prefix +	"finc_vsl_cd".trim(),	length));
				String[] tmlAgmtVerNo =	(JSPUtil.getParameter(request, prefix +	"tml_agmt_ver_no".trim(),	length));
				String[] freeDyXcldDys =	(JSPUtil.getParameter(request, prefix +	"free_dy_xcld_dys".trim(),	length));
				String[] volTrUtCd =	(JSPUtil.getParameter(request, prefix +	"vol_tr_ut_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] calcVolQty =	(JSPUtil.getParameter(request, prefix +	"calc_vol_qty".trim(),	length));
				String[] tmlSoDtlSeq =	(JSPUtil.getParameter(request, prefix +	"tml_so_dtl_seq".trim(),	length));
				String[] invXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt".trim(),	length));
				String[] revYrmon =	(JSPUtil.getParameter(request, prefix +	"rev_yrmon".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] dcgoIndCd =	(JSPUtil.getParameter(request, prefix +	"dcgo_ind_cd".trim(),	length));
				String[] calcAmt =	(JSPUtil.getParameter(request, prefix +	"calc_amt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] fpTeuQty =	(JSPUtil.getParameter(request, prefix +	"fp_teu_qty".trim(),	length));
				String[] tmlAgmtSeq =	(JSPUtil.getParameter(request, prefix +	"tml_agmt_seq".trim(),	length));
				String[] tmlSoSeq =	(JSPUtil.getParameter(request, prefix +	"tml_so_seq".trim(),	length));
				String[] loclUpdDt =	(JSPUtil.getParameter(request, prefix +	"locl_upd_dt".trim(),	length));
				String[] rcFlg =	(JSPUtil.getParameter(request, prefix +	"rc_flg".trim(),	length));
				String[] ovrDys =	(JSPUtil.getParameter(request, prefix +	"ovr_dys".trim(),	length));
				String[] laneCd =	(JSPUtil.getParameter(request, prefix +	"lane_cd".trim(),	length));
				String[] ediSoDtlId =	(JSPUtil.getParameter(request, prefix +	"edi_so_dtl_id".trim(),	length));
				String[] tmlTrnsModCd =	(JSPUtil.getParameter(request, prefix +	"tml_trns_mod_cd".trim(),	length));
				String[] semiAutoCalcFlg =	(JSPUtil.getParameter(request, prefix +	"semi_auto_calc_flg".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] fincSkdDirCd =	(JSPUtil.getParameter(request, prefix +	"finc_skd_dir_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] tmlCrrCd =	(JSPUtil.getParameter(request, prefix +	"tml_crr_cd".trim(),	length));
				String[] calcCostGrpCd =	(JSPUtil.getParameter(request, prefix +	"calc_cost_grp_cd".trim(),	length));
				String[] atbDt =	(JSPUtil.getParameter(request, prefix +	"atb_dt".trim(),	length));
				String[] calcTpCd =	(JSPUtil.getParameter(request, prefix +	"calc_tp_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] stayDys =	(JSPUtil.getParameter(request, prefix +	"stay_dys".trim(),	length));
				String[] fpCalcPrdCd =	(JSPUtil.getParameter(request, prefix +	"fp_calc_prd_cd".trim(),	length));
				String[] acctCd =	(JSPUtil.getParameter(request, prefix +	"acct_cd".trim(),	length));
				String[] invAmt =	(JSPUtil.getParameter(request, prefix +	"inv_amt".trim(),	length));
				String[] wrkDt =	(JSPUtil.getParameter(request, prefix +	"wrk_dt".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] n3ptyFlg =	(JSPUtil.getParameter(request, prefix +	"n3pty_flg".trim(),	length));
				String[] iocCd =	(JSPUtil.getParameter(request, prefix +	"ioc_cd".trim(),	length));
				String[] ovrVolQty =	(JSPUtil.getParameter(request, prefix +	"ovr_vol_qty".trim(),	length));
				String[] tmlAgmtOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"tml_agmt_ofc_cty_cd".trim(),	length));
				String[] fincSkdVoyNo =	(JSPUtil.getParameter(request, prefix +	"finc_skd_voy_no".trim(),	length));
				String[] rvisVolQty =	(JSPUtil.getParameter(request, prefix +	"rvis_vol_qty".trim(),	length));
				String[] ctrtRt =	(JSPUtil.getParameter(request, prefix +	"ctrt_rt".trim(),	length));
				String[] refVndrSeq =	(JSPUtil.getParameter(request, prefix +	"ref_vndr_seq".trim(),	length));
				String[] calcRmk =	(JSPUtil.getParameter(request, prefix +	"calc_rmk".trim(),	length));
				String[] loclCreDt =	(JSPUtil.getParameter(request, prefix +	"locl_cre_dt".trim(),	length));
				String[] fmTrVolVal =	(JSPUtil.getParameter(request, prefix +	"fm_tr_vol_val".trim(),	length));
				String[] diffVolQty =	(JSPUtil.getParameter(request, prefix +	"diff_vol_qty".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] payDys =	(JSPUtil.getParameter(request, prefix +	"pay_dys".trim(),	length));
				String[] freeDys =	(JSPUtil.getParameter(request, prefix +	"free_dys".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] lgsCostCd =	(JSPUtil.getParameter(request, prefix +	"lgs_cost_cd".trim(),	length));
				String[] rfMntrDys =	(JSPUtil.getParameter(request, prefix +	"rf_mntr_dys".trim(),	length));
				String[] plugTerm =	(JSPUtil.getParameter(request, prefix +	"plug_term".trim(),	length));
				String[] tmlWrkDyCd =	(JSPUtil.getParameter(request, prefix +	"tml_wrk_dy_cd".trim(),	length));
				String[] invVolQty =	(JSPUtil.getParameter(request, prefix +	"inv_vol_qty".trim(),	length));
				String[] tmlSoOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"tml_so_ofc_cty_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] lgOfcCd =	(JSPUtil.getParameter(request, prefix +	"lg_ofc_cd".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] idaSacCd =	(JSPUtil.getParameter(request, prefix +	"ida_sac_cd".trim(),	length));
				String[] idaPayTpCd =	(JSPUtil.getParameter(request, prefix +	"ida_pay_tp_cd".trim(),	length));
				String[] idaCgstRto =	(JSPUtil.getParameter(request, prefix +	"ida_cgst_rto".trim(),	length));
				String[] idaCgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_cgst_amt".trim(),	length));
				String[] idaSgstRto =	(JSPUtil.getParameter(request, prefix +	"ida_sgst_rto".trim(),	length));
				String[] idaSgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_sgst_amt".trim(),	length));
				String[] idaIgstRto =	(JSPUtil.getParameter(request, prefix +	"ida_igst_rto".trim(),	length));
				String[] idaIgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_igst_amt".trim(),	length));
				String[] idaUgstRto =	(JSPUtil.getParameter(request, prefix +	"ida_ugst_rto".trim(),	length));
				String[] idaUgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_ugst_amt".trim(),	length));
				String[] idaGstRto =	(JSPUtil.getParameter(request, prefix +	"ida_gst_rto".trim(),	length));
				String[] idaGstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_gst_amt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	TesTmlSoDtlVO();
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( stkVolQty[i] !=	null)
						model.setStkVolQty( stkVolQty[i]);
						if ( toTrVolVal[i] !=	null)
						model.setToTrVolVal( toTrVolVal[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( fincVslCd[i] !=	null)
						model.setFincVslCd( fincVslCd[i]);
						if ( tmlAgmtVerNo[i] !=	null)
						model.setTmlAgmtVerNo( tmlAgmtVerNo[i]);
						if ( freeDyXcldDys[i] !=	null)
						model.setFreeDyXcldDys( freeDyXcldDys[i]);
						if ( volTrUtCd[i] !=	null)
						model.setVolTrUtCd( volTrUtCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( calcVolQty[i] !=	null)
						model.setCalcVolQty( calcVolQty[i]);
						if ( tmlSoDtlSeq[i] !=	null)
						model.setTmlSoDtlSeq( tmlSoDtlSeq[i]);
						if ( invXchRt[i] !=	null)
						model.setInvXchRt( invXchRt[i]);
						if ( revYrmon[i] !=	null)
						model.setRevYrmon( revYrmon[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( dcgoIndCd[i] !=	null)
						model.setDcgoIndCd( dcgoIndCd[i]);
						if ( calcAmt[i] !=	null)
						model.setCalcAmt( calcAmt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( fpTeuQty[i] !=	null)
						model.setFpTeuQty( fpTeuQty[i]);
						if ( tmlAgmtSeq[i] !=	null)
						model.setTmlAgmtSeq( tmlAgmtSeq[i]);
						if ( tmlSoSeq[i] !=	null)
						model.setTmlSoSeq( tmlSoSeq[i]);
						if ( loclUpdDt[i] !=	null)
						model.setLoclUpdDt( loclUpdDt[i]);
						if ( rcFlg[i] !=	null)
						model.setRcFlg( rcFlg[i]);
						if ( ovrDys[i] !=	null)
						model.setOvrDys( ovrDys[i]);
						if ( laneCd[i] !=	null)
						model.setLaneCd( laneCd[i]);
						if ( ediSoDtlId[i] !=	null)
						model.setEdiSoDtlId( ediSoDtlId[i]);
						if ( tmlTrnsModCd[i] !=	null)
						model.setTmlTrnsModCd( tmlTrnsModCd[i]);
						if ( semiAutoCalcFlg[i] !=	null)
						model.setSemiAutoCalcFlg( semiAutoCalcFlg[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( fincSkdDirCd[i] !=	null)
						model.setFincSkdDirCd( fincSkdDirCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( tmlCrrCd[i] !=	null)
						model.setTmlCrrCd( tmlCrrCd[i]);
						if ( calcCostGrpCd[i] !=	null)
						model.setCalcCostGrpCd( calcCostGrpCd[i]);
						if ( atbDt[i] !=	null)
						model.setAtbDt( atbDt[i]);
						if ( calcTpCd[i] !=	null)
						model.setCalcTpCd( calcTpCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( stayDys[i] !=	null)
						model.setStayDys( stayDys[i]);
						if ( fpCalcPrdCd[i] !=	null)
						model.setFpCalcPrdCd( fpCalcPrdCd[i]);
						if ( acctCd[i] !=	null)
						model.setAcctCd( acctCd[i]);
						if ( invAmt[i] !=	null)
						model.setInvAmt( invAmt[i]);
						if ( wrkDt[i] !=	null)
						model.setWrkDt( wrkDt[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( n3ptyFlg[i] !=	null)
						model.setN3ptyFlg( n3ptyFlg[i]);
						if ( iocCd[i] !=	null)
						model.setIocCd( iocCd[i]);
						if ( ovrVolQty[i] !=	null)
						model.setOvrVolQty( ovrVolQty[i]);
						if ( tmlAgmtOfcCtyCd[i] !=	null)
						model.setTmlAgmtOfcCtyCd( tmlAgmtOfcCtyCd[i]);
						if ( fincSkdVoyNo[i] !=	null)
						model.setFincSkdVoyNo( fincSkdVoyNo[i]);
						if ( rvisVolQty[i] !=	null)
						model.setRvisVolQty( rvisVolQty[i]);
						if ( ctrtRt[i] !=	null)
						model.setCtrtRt( ctrtRt[i]);
						if ( refVndrSeq[i] !=	null)
						model.setRefVndrSeq( refVndrSeq[i]);
						if ( calcRmk[i] !=	null)
						model.setCalcRmk( calcRmk[i]);
						if ( loclCreDt[i] !=	null)
						model.setLoclCreDt( loclCreDt[i]);
						if ( fmTrVolVal[i] !=	null)
						model.setFmTrVolVal( fmTrVolVal[i]);
						if ( diffVolQty[i] !=	null)
						model.setDiffVolQty( diffVolQty[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( payDys[i] !=	null)
						model.setPayDys( payDys[i]);
						if ( freeDys[i] !=	null)
						model.setFreeDys( freeDys[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( lgsCostCd[i] !=	null)
						model.setLgsCostCd( lgsCostCd[i]);
						if ( rfMntrDys[i] !=	null)
						model.setRfMntrDys( rfMntrDys[i]);
						if ( plugTerm[i] !=	null)
						model.setPlugTerm( plugTerm[i]);
						if ( tmlWrkDyCd[i] !=	null)
						model.setTmlWrkDyCd( tmlWrkDyCd[i]);
						if ( invVolQty[i] !=	null)
						model.setInvVolQty( invVolQty[i]);
						if ( tmlSoOfcCtyCd[i] !=	null)
						model.setTmlSoOfcCtyCd( tmlSoOfcCtyCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( lgOfcCd[i] !=	null)
						model.setLgOfcCd( lgOfcCd[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( idaSacCd[i] !=	null)
						model.setIdaSacCd( idaSacCd[i]);
						if ( idaPayTpCd[i] !=	null)
						model.setIdaPayTpCd( idaPayTpCd[i]);
						if ( idaCgstRto[i] !=	null)
						model.setIdaCgstRto( idaCgstRto[i]);
						if ( idaCgstAmt[i] !=	null)
						model.setIdaCgstAmt( idaCgstAmt[i]);
						if ( idaSgstRto[i] !=	null)
						model.setIdaSgstRto( idaSgstRto[i]);
						if ( idaSgstAmt[i] !=	null)
						model.setIdaSgstAmt( idaSgstAmt[i]);
						if ( idaIgstRto[i] !=	null)
						model.setIdaIgstRto( idaIgstRto[i]);
						if ( idaIgstAmt[i] !=	null)
						model.setIdaIgstAmt( idaIgstAmt[i]);
						if ( idaUgstRto[i] !=	null)
						model.setIdaUgstRto( idaUgstRto[i]);
						if ( idaUgstAmt[i] !=	null)
						model.setIdaUgstAmt( idaUgstAmt[i]);
						if ( idaGstRto[i] !=	null)
						model.setIdaGstRto( idaGstRto[i]);
						if ( idaGstAmt[i] !=	null)
						model.setIdaGstAmt( idaGstAmt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getTesTmlSoDtlVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return TesTmlSoDtlVO[]
	 */
	public TesTmlSoDtlVO[]	 getTesTmlSoDtlVOs(){
		TesTmlSoDtlVO[] vos = (TesTmlSoDtlVO[])models.toArray(new	TesTmlSoDtlVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class�쓽 �궡�슜�쓣 String�쑝濡� 蹂��솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �룷留룻똿�맂 臾몄옄�뿴�뿉�꽌 �듅�닔臾몄옄 �젣嫄�("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkVolQty =	this.stkVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTrVolVal =	this.toTrVolVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincVslCd =	this.fincVslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtVerNo =	this.tmlAgmtVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDyXcldDys =	this.freeDyXcldDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.volTrUtCd =	this.volTrUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcVolQty =	this.calcVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoDtlSeq =	this.tmlSoDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRt =	this.invXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revYrmon =	this.revYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoIndCd =	this.dcgoIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcAmt =	this.calcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpTeuQty =	this.fpTeuQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtSeq =	this.tmlAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoSeq =	this.tmlSoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt =	this.loclUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg =	this.rcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDys =	this.ovrDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd =	this.laneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSoDtlId =	this.ediSoDtlId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlTrnsModCd =	this.tmlTrnsModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.semiAutoCalcFlg =	this.semiAutoCalcFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincSkdDirCd =	this.fincSkdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCrrCd =	this.tmlCrrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcCostGrpCd =	this.calcCostGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atbDt =	this.atbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcTpCd =	this.calcTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDys =	this.stayDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fpCalcPrdCd =	this.fpCalcPrdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd =	this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invAmt =	this.invAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrkDt =	this.wrkDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n3ptyFlg =	this.n3ptyFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iocCd =	this.iocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrVolQty =	this.ovrVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlAgmtOfcCtyCd =	this.tmlAgmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fincSkdVoyNo =	this.fincSkdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvisVolQty =	this.rvisVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtRt =	this.ctrtRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refVndrSeq =	this.refVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calcRmk =	this.calcRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt =	this.loclCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmTrVolVal =	this.fmTrVolVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffVolQty =	this.diffVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDys =	this.payDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys =	this.freeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgsCostCd =	this.lgsCostCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMntrDys =	this.rfMntrDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.plugTerm =	this.plugTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlWrkDyCd =	this.tmlWrkDyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invVolQty =	this.invVolQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoOfcCtyCd =	this.tmlSoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lgOfcCd =	this.lgOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSacCd =	this.idaSacCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaPayTpCd =	this.idaPayTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstRto =	this.idaCgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstAmt =	this.idaCgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstRto =	this.idaSgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstAmt =	this.idaSgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstRto =	this.idaIgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstAmt =	this.idaIgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstRto =	this.idaUgstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstAmt =	this.idaUgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaGstRto =	this.idaGstRto.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaGstAmt =	this.idaGstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}