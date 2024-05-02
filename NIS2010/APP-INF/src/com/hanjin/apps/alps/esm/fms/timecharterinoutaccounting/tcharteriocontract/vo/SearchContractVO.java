/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SearchContractVO.java
 *@FileTitle : SearchContractVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.11.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.11.13  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo;

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
public class SearchContractVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SearchContractVO>  models =	new	ArrayList<SearchContractVO>();


	/*	Column Info	*/
	private  String	 vslDzndCapa   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 acmmRtAmt   =  null;
	/*	Column Info	*/
	private  String	 fletCtrtTpCd   =  null;
	/*	Column Info	*/
	private  String	 doilBodOutPrc   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 foilBodOutPrc   =  null;
	/*	Column Info	*/
	private  String	 fletBrogRtAmt   =  null;
	/*	Column Info	*/
	private  String	 shpSpdQty   =  null;
	/*	Column Info	*/
	private  String	 fromTime   =  null;
	/*	Column Info	*/
	private  String	 rdeRngCtnt   =  null;
	/*	Column Info	*/
	private  String	 fletCtrtNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 nrtWgt   =  null;
	/*	Column Info	*/
	private  String	 vslBldDt   =  null;
	/*	Column Info	*/
	private  String	 foilBorOutPrc   =  null;
	/*	Column Info	*/
	private  String	 cntNm   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 effDt   =  null;
	/*	Column Info	*/
	private  String	 doilBorOutPrc   =  null;
	/*	Column Info	*/
	private  String	 vslEngNm   =  null;
	/*	Column Info	*/
	private  String	 ddwtCgoCapaQty   =  null;
	/*	Column Info	*/
	private  String	 actDoilBorQty   =  null;
	/*	Column Info	*/
	private  String	 cpDt   =  null;
	/*	Column Info	*/
	private  String	 expDt   =  null;
	/*	Column Info	*/
	private  String	 vslCntCd   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 actFoilBorQty   =  null;
	/*	Column Info	*/
	private  String	 rdeNtcCtnt   =  null;
	/*	Column Info	*/
	private  String	 fletCtrtFactCd   =  null;
	/*	Column Info	*/
	private  String	 fletGmtLmtCd   =  null;
	/*	Column Info	*/
	private  String	 actDoilBodQty   =  null;
	/*	Column Info	*/
	private  String	 borPortCd   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 toTime   =  null;
	/*	Column Info	*/
	private  String	 fletOlayCommRtAmt   =  null;
	/*	Column Info	*/
	private  String	 bodPortCd   =  null;
	/*	Column Info	*/
	private  String	 oaRsvAmt   =  null;
	/*	Column Info	*/
	private  String	 bse14tonVslCapa   =  null;
	/*	Column Info	*/
	private  String	 grFlg   =  null;
	/*	Column Info	*/
	private  String	 chtrPrdOptCtnt   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 ownrNm   =  null;
	/*	Column Info	*/
	private  String	 actFoilBodQty   =  null;
	/*	Column Info	*/
	private  String	 rfCntrPlgQty   =  null;
	/*	Column Info	*/
	private  String	 oaRsvCurrCd   =  null;
	/*	Column Info	*/
	private  String	 grsWgt   =  null;
	/*	Column Info	*/
	private  String	 declFlg   =  null;
	/*	Column Info	*/
	private  String	 agmtDocNo   =  null;
	/*	Column Info	*/
	private  String	 agmtDocDesc   =  null;
	/*	Column Info	*/
	private  String	 actLowSulpFoilBodQty   =  null;
	/*	Column Info	*/
	private  String	 actLowSulpGasOilBodQty   =  null;
	/*	Column Info	*/
	private  String	 actLowSulpFoilBorQty   =  null;
	/*	Column Info	*/
	private  String	 actLowSulpGasOilBorQty   =  null;
	/*	Column Info	*/
	private  String	 lowSulpFoilBodOutPrc   =  null;
	/*	Column Info	*/
	private  String	 lowSulpGasOilBodOutPrc   =  null;
	/*	Column Info	*/
	private  String	 lowSulpFoilBorOutPrc   =  null;
	/*	Column Info	*/
	private  String	 lowSulpGasOilBorOutPrc   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SearchContractVO(){}

	public SearchContractVO(String vslDzndCapa,String vslCd,String acmmRtAmt,String fletCtrtTpCd,String doilBodOutPrc,String vndrLglEngNm,String foilBodOutPrc,String fletBrogRtAmt,String shpSpdQty,String fromTime,String rdeRngCtnt,String fletCtrtNo,String pagerows,String nrtWgt,String vslBldDt,String foilBorOutPrc,String cntNm,String ibflag,String effDt,String doilBorOutPrc,String vslEngNm,String ddwtCgoCapaQty,String actDoilBorQty,String cpDt,String expDt,String vslCntCd,String custCntCd,String actFoilBorQty,String rdeNtcCtnt,String fletCtrtFactCd,String fletGmtLmtCd,String actDoilBodQty,String borPortCd,String custSeq,String toTime,String fletOlayCommRtAmt,String bodPortCd,String oaRsvAmt,String bse14tonVslCapa,String grFlg,String chtrPrdOptCtnt,String vndrSeq,String ownrNm,String actFoilBodQty,String rfCntrPlgQty,String oaRsvCurrCd,String grsWgt,String declFlg,String agmtDocNo,String agmtDocDesc,String actLowSulpFoilBodQty,String actLowSulpGasOilBodQty,String actLowSulpFoilBorQty,String actLowSulpGasOilBorQty,String lowSulpFoilBodOutPrc,String lowSulpGasOilBodOutPrc,String lowSulpFoilBorOutPrc,String lowSulpGasOilBorOutPrc)	{
		this.vslDzndCapa  = vslDzndCapa ;
		this.vslCd  = vslCd ;
		this.acmmRtAmt  = acmmRtAmt ;
		this.fletCtrtTpCd  = fletCtrtTpCd ;
		this.doilBodOutPrc  = doilBodOutPrc ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.foilBodOutPrc  = foilBodOutPrc ;
		this.fletBrogRtAmt  = fletBrogRtAmt ;
		this.shpSpdQty  = shpSpdQty ;
		this.fromTime  = fromTime ;
		this.rdeRngCtnt  = rdeRngCtnt ;
		this.fletCtrtNo  = fletCtrtNo ;
		this.pagerows  = pagerows ;
		this.nrtWgt  = nrtWgt ;
		this.vslBldDt  = vslBldDt ;
		this.foilBorOutPrc  = foilBorOutPrc ;
		this.cntNm  = cntNm ;
		this.ibflag  = ibflag ;
		this.effDt  = effDt ;
		this.doilBorOutPrc  = doilBorOutPrc ;
		this.vslEngNm  = vslEngNm ;
		this.ddwtCgoCapaQty  = ddwtCgoCapaQty ;
		this.actDoilBorQty  = actDoilBorQty ;
		this.cpDt  = cpDt ;
		this.expDt  = expDt ;
		this.vslCntCd  = vslCntCd ;
		this.custCntCd  = custCntCd ;
		this.actFoilBorQty  = actFoilBorQty ;
		this.rdeNtcCtnt  = rdeNtcCtnt ;
		this.fletCtrtFactCd  = fletCtrtFactCd ;
		this.fletGmtLmtCd  = fletGmtLmtCd ;
		this.actDoilBodQty  = actDoilBodQty ;
		this.borPortCd  = borPortCd ;
		this.custSeq  = custSeq ;
		this.toTime  = toTime ;
		this.fletOlayCommRtAmt  = fletOlayCommRtAmt ;
		this.bodPortCd  = bodPortCd ;
		this.oaRsvAmt  = oaRsvAmt ;
		this.bse14tonVslCapa  = bse14tonVslCapa ;
		this.grFlg  = grFlg ;
		this.chtrPrdOptCtnt  = chtrPrdOptCtnt ;
		this.vndrSeq  = vndrSeq ;
		this.ownrNm  = ownrNm ;
		this.actFoilBodQty  = actFoilBodQty ;
		this.rfCntrPlgQty  = rfCntrPlgQty ;
		this.oaRsvCurrCd  = oaRsvCurrCd ;
		this.grsWgt  = grsWgt ;
		this.declFlg  = declFlg ;
		this.agmtDocNo  = agmtDocNo ;
		this.agmtDocDesc  = agmtDocDesc ;
		this.actLowSulpFoilBodQty  = actLowSulpFoilBodQty ;
		this.actLowSulpGasOilBodQty  = actLowSulpGasOilBodQty ;
		this.actLowSulpFoilBorQty  = actLowSulpFoilBorQty ;
		this.actLowSulpGasOilBorQty  = actLowSulpGasOilBorQty ;
		this.lowSulpFoilBodOutPrc  = lowSulpFoilBodOutPrc ;
		this.lowSulpGasOilBodOutPrc  = lowSulpGasOilBodOutPrc ;
		this.lowSulpFoilBorOutPrc  = lowSulpFoilBorOutPrc ;
		this.lowSulpGasOilBorOutPrc  = lowSulpGasOilBorOutPrc ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_dznd_capa", getVslDzndCapa());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("acmm_rt_amt", getAcmmRtAmt());		
		this.hashColumns.put("flet_ctrt_tp_cd", getFletCtrtTpCd());		
		this.hashColumns.put("doil_bod_out_prc", getDoilBodOutPrc());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("foil_bod_out_prc", getFoilBodOutPrc());		
		this.hashColumns.put("flet_brog_rt_amt", getFletBrogRtAmt());		
		this.hashColumns.put("shp_spd_qty", getShpSpdQty());		
		this.hashColumns.put("from_time", getFromTime());		
		this.hashColumns.put("rde_rng_ctnt", getRdeRngCtnt());		
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("nrt_wgt", getNrtWgt());		
		this.hashColumns.put("vsl_bld_dt", getVslBldDt());		
		this.hashColumns.put("foil_bor_out_prc", getFoilBorOutPrc());		
		this.hashColumns.put("cnt_nm", getCntNm());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("eff_dt", getEffDt());		
		this.hashColumns.put("doil_bor_out_prc", getDoilBorOutPrc());		
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());		
		this.hashColumns.put("ddwt_cgo_capa_qty", getDdwtCgoCapaQty());		
		this.hashColumns.put("act_doil_bor_qty", getActDoilBorQty());		
		this.hashColumns.put("cp_dt", getCpDt());		
		this.hashColumns.put("exp_dt", getExpDt());		
		this.hashColumns.put("vsl_cnt_cd", getVslCntCd());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("act_foil_bor_qty", getActFoilBorQty());		
		this.hashColumns.put("rde_ntc_ctnt", getRdeNtcCtnt());		
		this.hashColumns.put("flet_ctrt_fact_cd", getFletCtrtFactCd());		
		this.hashColumns.put("flet_gmt_lmt_cd", getFletGmtLmtCd());		
		this.hashColumns.put("act_doil_bod_qty", getActDoilBodQty());		
		this.hashColumns.put("bor_port_cd", getBorPortCd());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("to_time", getToTime());		
		this.hashColumns.put("flet_olay_comm_rt_amt", getFletOlayCommRtAmt());		
		this.hashColumns.put("bod_port_cd", getBodPortCd());		
		this.hashColumns.put("oa_rsv_amt", getOaRsvAmt());		
		this.hashColumns.put("bse_14ton_vsl_capa", getBse14tonVslCapa());		
		this.hashColumns.put("gr_flg", getGrFlg());		
		this.hashColumns.put("chtr_prd_opt_ctnt", getChtrPrdOptCtnt());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("ownr_nm", getOwnrNm());		
		this.hashColumns.put("act_foil_bod_qty", getActFoilBodQty());		
		this.hashColumns.put("rf_cntr_plg_qty", getRfCntrPlgQty());		
		this.hashColumns.put("oa_rsv_curr_cd", getOaRsvCurrCd());		
		this.hashColumns.put("grs_wgt", getGrsWgt());		
		this.hashColumns.put("decl_flg", getDeclFlg());		
		this.hashColumns.put("agmt_doc_no", getAgmtDocNo());		
		this.hashColumns.put("agmt_doc_desc", getAgmtDocDesc());		
		this.hashColumns.put("act_low_sulp_foil_bod_qty", getActLowSulpFoilBodQty());		
		this.hashColumns.put("act_low_sulp_gas_oil_bod_qty", getActLowSulpGasOilBodQty());		
		this.hashColumns.put("act_low_sulp_foil_bor_qty", getActLowSulpFoilBorQty());		
		this.hashColumns.put("act_low_sulp_gas_oil_bor_qty", getActLowSulpGasOilBorQty());		
		this.hashColumns.put("low_sulp_foil_bod_out_prc", getLowSulpFoilBodOutPrc());		
		this.hashColumns.put("low_sulp_gas_oil_bod_out_prc", getLowSulpGasOilBodOutPrc());		
		this.hashColumns.put("low_sulp_foil_bor_out_prc", getLowSulpFoilBorOutPrc());		
		this.hashColumns.put("low_sulp_gas_oil_bor_out_prc", getLowSulpGasOilBorOutPrc());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("vsl_dznd_capa", "vslDzndCapa");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("acmm_rt_amt", "acmmRtAmt");
		this.hashFields.put("flet_ctrt_tp_cd", "fletCtrtTpCd");
		this.hashFields.put("doil_bod_out_prc", "doilBodOutPrc");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("foil_bod_out_prc", "foilBodOutPrc");
		this.hashFields.put("flet_brog_rt_amt", "fletBrogRtAmt");
		this.hashFields.put("shp_spd_qty", "shpSpdQty");
		this.hashFields.put("from_time", "fromTime");
		this.hashFields.put("rde_rng_ctnt", "rdeRngCtnt");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("nrt_wgt", "nrtWgt");
		this.hashFields.put("vsl_bld_dt", "vslBldDt");
		this.hashFields.put("foil_bor_out_prc", "foilBorOutPrc");
		this.hashFields.put("cnt_nm", "cntNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("doil_bor_out_prc", "doilBorOutPrc");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("ddwt_cgo_capa_qty", "ddwtCgoCapaQty");
		this.hashFields.put("act_doil_bor_qty", "actDoilBorQty");
		this.hashFields.put("cp_dt", "cpDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("vsl_cnt_cd", "vslCntCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("act_foil_bor_qty", "actFoilBorQty");
		this.hashFields.put("rde_ntc_ctnt", "rdeNtcCtnt");
		this.hashFields.put("flet_ctrt_fact_cd", "fletCtrtFactCd");
		this.hashFields.put("flet_gmt_lmt_cd", "fletGmtLmtCd");
		this.hashFields.put("act_doil_bod_qty", "actDoilBodQty");
		this.hashFields.put("bor_port_cd", "borPortCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("to_time", "toTime");
		this.hashFields.put("flet_olay_comm_rt_amt", "fletOlayCommRtAmt");
		this.hashFields.put("bod_port_cd", "bodPortCd");
		this.hashFields.put("oa_rsv_amt", "oaRsvAmt");
		this.hashFields.put("bse_14ton_vsl_capa", "bse14tonVslCapa");
		this.hashFields.put("gr_flg", "grFlg");
		this.hashFields.put("chtr_prd_opt_ctnt", "chtrPrdOptCtnt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("ownr_nm", "ownrNm");
		this.hashFields.put("act_foil_bod_qty", "actFoilBodQty");
		this.hashFields.put("rf_cntr_plg_qty", "rfCntrPlgQty");
		this.hashFields.put("oa_rsv_curr_cd", "oaRsvCurrCd");
		this.hashFields.put("grs_wgt", "grsWgt");
		this.hashFields.put("decl_flg", "declFlg");
		this.hashFields.put("agmt_doc_no", "agmtDocNo");
		this.hashFields.put("agmt_doc_desc", "agmtDocDesc");
		this.hashFields.put("act_low_sulp_foil_bod_qty", "actLowSulpFoilBodQty");
		this.hashFields.put("act_low_sulp_gas_oil_bod_qty", "actLowSulpGasOilBodQty");
		this.hashFields.put("act_low_sulp_foil_bor_qty", "actLowSulpFoilBorQty");
		this.hashFields.put("act_low_sulp_gas_oil_bor_qty", "actLowSulpGasOilBorQty");
		this.hashFields.put("low_sulp_foil_bod_out_prc", "lowSulpFoilBodOutPrc");
		this.hashFields.put("low_sulp_gas_oil_bod_out_prc", "lowSulpGasOilBodOutPrc");
		this.hashFields.put("low_sulp_foil_bor_out_prc", "lowSulpFoilBorOutPrc");
		this.hashFields.put("low_sulp_gas_oil_bor_out_prc", "lowSulpGasOilBorOutPrc");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  vslDzndCapa
	*/
	public void	setVslDzndCapa( String	vslDzndCapa ) {
		this.vslDzndCapa =	vslDzndCapa;
	}
 
	/**
	 * Column Info
	 * @return	vslDzndCapa
	 */
	 public	 String	getVslDzndCapa() {
		 return	this.vslDzndCapa;
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
	* @param  acmmRtAmt
	*/
	public void	setAcmmRtAmt( String	acmmRtAmt ) {
		this.acmmRtAmt =	acmmRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	acmmRtAmt
	 */
	 public	 String	getAcmmRtAmt() {
		 return	this.acmmRtAmt;
	 } 
 	/**
	* Column Info
	* @param  fletCtrtTpCd
	*/
	public void	setFletCtrtTpCd( String	fletCtrtTpCd ) {
		this.fletCtrtTpCd =	fletCtrtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	fletCtrtTpCd
	 */
	 public	 String	getFletCtrtTpCd() {
		 return	this.fletCtrtTpCd;
	 } 
 	/**
	* Column Info
	* @param  doilBodOutPrc
	*/
	public void	setDoilBodOutPrc( String	doilBodOutPrc ) {
		this.doilBodOutPrc =	doilBodOutPrc;
	}
 
	/**
	 * Column Info
	 * @return	doilBodOutPrc
	 */
	 public	 String	getDoilBodOutPrc() {
		 return	this.doilBodOutPrc;
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
	* @param  foilBodOutPrc
	*/
	public void	setFoilBodOutPrc( String	foilBodOutPrc ) {
		this.foilBodOutPrc =	foilBodOutPrc;
	}
 
	/**
	 * Column Info
	 * @return	foilBodOutPrc
	 */
	 public	 String	getFoilBodOutPrc() {
		 return	this.foilBodOutPrc;
	 } 
 	/**
	* Column Info
	* @param  fletBrogRtAmt
	*/
	public void	setFletBrogRtAmt( String	fletBrogRtAmt ) {
		this.fletBrogRtAmt =	fletBrogRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	fletBrogRtAmt
	 */
	 public	 String	getFletBrogRtAmt() {
		 return	this.fletBrogRtAmt;
	 } 
 	/**
	* Column Info
	* @param  shpSpdQty
	*/
	public void	setShpSpdQty( String	shpSpdQty ) {
		this.shpSpdQty =	shpSpdQty;
	}
 
	/**
	 * Column Info
	 * @return	shpSpdQty
	 */
	 public	 String	getShpSpdQty() {
		 return	this.shpSpdQty;
	 } 
 	/**
	* Column Info
	* @param  fromTime
	*/
	public void	setFromTime( String	fromTime ) {
		this.fromTime =	fromTime;
	}
 
	/**
	 * Column Info
	 * @return	fromTime
	 */
	 public	 String	getFromTime() {
		 return	this.fromTime;
	 } 
 	/**
	* Column Info
	* @param  rdeRngCtnt
	*/
	public void	setRdeRngCtnt( String	rdeRngCtnt ) {
		this.rdeRngCtnt =	rdeRngCtnt;
	}
 
	/**
	 * Column Info
	 * @return	rdeRngCtnt
	 */
	 public	 String	getRdeRngCtnt() {
		 return	this.rdeRngCtnt;
	 } 
 	/**
	* Column Info
	* @param  fletCtrtNo
	*/
	public void	setFletCtrtNo( String	fletCtrtNo ) {
		this.fletCtrtNo =	fletCtrtNo;
	}
 
	/**
	 * Column Info
	 * @return	fletCtrtNo
	 */
	 public	 String	getFletCtrtNo() {
		 return	this.fletCtrtNo;
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
	* @param  nrtWgt
	*/
	public void	setNrtWgt( String	nrtWgt ) {
		this.nrtWgt =	nrtWgt;
	}
 
	/**
	 * Column Info
	 * @return	nrtWgt
	 */
	 public	 String	getNrtWgt() {
		 return	this.nrtWgt;
	 } 
 	/**
	* Column Info
	* @param  vslBldDt
	*/
	public void	setVslBldDt( String	vslBldDt ) {
		this.vslBldDt =	vslBldDt;
	}
 
	/**
	 * Column Info
	 * @return	vslBldDt
	 */
	 public	 String	getVslBldDt() {
		 return	this.vslBldDt;
	 } 
 	/**
	* Column Info
	* @param  foilBorOutPrc
	*/
	public void	setFoilBorOutPrc( String	foilBorOutPrc ) {
		this.foilBorOutPrc =	foilBorOutPrc;
	}
 
	/**
	 * Column Info
	 * @return	foilBorOutPrc
	 */
	 public	 String	getFoilBorOutPrc() {
		 return	this.foilBorOutPrc;
	 } 
 	/**
	* Column Info
	* @param  cntNm
	*/
	public void	setCntNm( String	cntNm ) {
		this.cntNm =	cntNm;
	}
 
	/**
	 * Column Info
	 * @return	cntNm
	 */
	 public	 String	getCntNm() {
		 return	this.cntNm;
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
	* @param  effDt
	*/
	public void	setEffDt( String	effDt ) {
		this.effDt =	effDt;
	}
 
	/**
	 * Column Info
	 * @return	effDt
	 */
	 public	 String	getEffDt() {
		 return	this.effDt;
	 } 
 	/**
	* Column Info
	* @param  doilBorOutPrc
	*/
	public void	setDoilBorOutPrc( String	doilBorOutPrc ) {
		this.doilBorOutPrc =	doilBorOutPrc;
	}
 
	/**
	 * Column Info
	 * @return	doilBorOutPrc
	 */
	 public	 String	getDoilBorOutPrc() {
		 return	this.doilBorOutPrc;
	 } 
 	/**
	* Column Info
	* @param  vslEngNm
	*/
	public void	setVslEngNm( String	vslEngNm ) {
		this.vslEngNm =	vslEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vslEngNm
	 */
	 public	 String	getVslEngNm() {
		 return	this.vslEngNm;
	 } 
 	/**
	* Column Info
	* @param  ddwtCgoCapaQty
	*/
	public void	setDdwtCgoCapaQty( String	ddwtCgoCapaQty ) {
		this.ddwtCgoCapaQty =	ddwtCgoCapaQty;
	}
 
	/**
	 * Column Info
	 * @return	ddwtCgoCapaQty
	 */
	 public	 String	getDdwtCgoCapaQty() {
		 return	this.ddwtCgoCapaQty;
	 } 
 	/**
	* Column Info
	* @param  actDoilBorQty
	*/
	public void	setActDoilBorQty( String	actDoilBorQty ) {
		this.actDoilBorQty =	actDoilBorQty;
	}
 
	/**
	 * Column Info
	 * @return	actDoilBorQty
	 */
	 public	 String	getActDoilBorQty() {
		 return	this.actDoilBorQty;
	 } 
 	/**
	* Column Info
	* @param  cpDt
	*/
	public void	setCpDt( String	cpDt ) {
		this.cpDt =	cpDt;
	}
 
	/**
	 * Column Info
	 * @return	cpDt
	 */
	 public	 String	getCpDt() {
		 return	this.cpDt;
	 } 
 	/**
	* Column Info
	* @param  expDt
	*/
	public void	setExpDt( String	expDt ) {
		this.expDt =	expDt;
	}
 
	/**
	 * Column Info
	 * @return	expDt
	 */
	 public	 String	getExpDt() {
		 return	this.expDt;
	 } 
 	/**
	* Column Info
	* @param  vslCntCd
	*/
	public void	setVslCntCd( String	vslCntCd ) {
		this.vslCntCd =	vslCntCd;
	}
 
	/**
	 * Column Info
	 * @return	vslCntCd
	 */
	 public	 String	getVslCntCd() {
		 return	this.vslCntCd;
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
	* @param  actFoilBorQty
	*/
	public void	setActFoilBorQty( String	actFoilBorQty ) {
		this.actFoilBorQty =	actFoilBorQty;
	}
 
	/**
	 * Column Info
	 * @return	actFoilBorQty
	 */
	 public	 String	getActFoilBorQty() {
		 return	this.actFoilBorQty;
	 } 
 	/**
	* Column Info
	* @param  rdeNtcCtnt
	*/
	public void	setRdeNtcCtnt( String	rdeNtcCtnt ) {
		this.rdeNtcCtnt =	rdeNtcCtnt;
	}
 
	/**
	 * Column Info
	 * @return	rdeNtcCtnt
	 */
	 public	 String	getRdeNtcCtnt() {
		 return	this.rdeNtcCtnt;
	 } 
 	/**
	* Column Info
	* @param  fletCtrtFactCd
	*/
	public void	setFletCtrtFactCd( String	fletCtrtFactCd ) {
		this.fletCtrtFactCd =	fletCtrtFactCd;
	}
 
	/**
	 * Column Info
	 * @return	fletCtrtFactCd
	 */
	 public	 String	getFletCtrtFactCd() {
		 return	this.fletCtrtFactCd;
	 } 
 	/**
	* Column Info
	* @param  fletGmtLmtCd
	*/
	public void	setFletGmtLmtCd( String	fletGmtLmtCd ) {
		this.fletGmtLmtCd =	fletGmtLmtCd;
	}
 
	/**
	 * Column Info
	 * @return	fletGmtLmtCd
	 */
	 public	 String	getFletGmtLmtCd() {
		 return	this.fletGmtLmtCd;
	 } 
 	/**
	* Column Info
	* @param  actDoilBodQty
	*/
	public void	setActDoilBodQty( String	actDoilBodQty ) {
		this.actDoilBodQty =	actDoilBodQty;
	}
 
	/**
	 * Column Info
	 * @return	actDoilBodQty
	 */
	 public	 String	getActDoilBodQty() {
		 return	this.actDoilBodQty;
	 } 
 	/**
	* Column Info
	* @param  borPortCd
	*/
	public void	setBorPortCd( String	borPortCd ) {
		this.borPortCd =	borPortCd;
	}
 
	/**
	 * Column Info
	 * @return	borPortCd
	 */
	 public	 String	getBorPortCd() {
		 return	this.borPortCd;
	 } 
 	/**
	* Column Info
	* @param  custSeq
	*/
	public void	setCustSeq( String	custSeq ) {
		this.custSeq =	custSeq;
	}
 
	/**
	 * Column Info
	 * @return	custSeq
	 */
	 public	 String	getCustSeq() {
		 return	this.custSeq;
	 } 
 	/**
	* Column Info
	* @param  toTime
	*/
	public void	setToTime( String	toTime ) {
		this.toTime =	toTime;
	}
 
	/**
	 * Column Info
	 * @return	toTime
	 */
	 public	 String	getToTime() {
		 return	this.toTime;
	 } 
 	/**
	* Column Info
	* @param  fletOlayCommRtAmt
	*/
	public void	setFletOlayCommRtAmt( String	fletOlayCommRtAmt ) {
		this.fletOlayCommRtAmt =	fletOlayCommRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	fletOlayCommRtAmt
	 */
	 public	 String	getFletOlayCommRtAmt() {
		 return	this.fletOlayCommRtAmt;
	 } 
 	/**
	* Column Info
	* @param  bodPortCd
	*/
	public void	setBodPortCd( String	bodPortCd ) {
		this.bodPortCd =	bodPortCd;
	}
 
	/**
	 * Column Info
	 * @return	bodPortCd
	 */
	 public	 String	getBodPortCd() {
		 return	this.bodPortCd;
	 } 
 	/**
	* Column Info
	* @param  oaRsvAmt
	*/
	public void	setOaRsvAmt( String	oaRsvAmt ) {
		this.oaRsvAmt =	oaRsvAmt;
	}
 
	/**
	 * Column Info
	 * @return	oaRsvAmt
	 */
	 public	 String	getOaRsvAmt() {
		 return	this.oaRsvAmt;
	 } 
 	/**
	* Column Info
	* @param  bse14tonVslCapa
	*/
	public void	setBse14tonVslCapa( String	bse14tonVslCapa ) {
		this.bse14tonVslCapa =	bse14tonVslCapa;
	}
 
	/**
	 * Column Info
	 * @return	bse14tonVslCapa
	 */
	 public	 String	getBse14tonVslCapa() {
		 return	this.bse14tonVslCapa;
	 } 
 	/**
	* Column Info
	* @param  grFlg
	*/
	public void	setGrFlg( String	grFlg ) {
		this.grFlg =	grFlg;
	}
 
	/**
	 * Column Info
	 * @return	grFlg
	 */
	 public	 String	getGrFlg() {
		 return	this.grFlg;
	 } 
 	/**
	* Column Info
	* @param  chtrPrdOptCtnt
	*/
	public void	setChtrPrdOptCtnt( String	chtrPrdOptCtnt ) {
		this.chtrPrdOptCtnt =	chtrPrdOptCtnt;
	}
 
	/**
	 * Column Info
	 * @return	chtrPrdOptCtnt
	 */
	 public	 String	getChtrPrdOptCtnt() {
		 return	this.chtrPrdOptCtnt;
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
	* @param  ownrNm
	*/
	public void	setOwnrNm( String	ownrNm ) {
		this.ownrNm =	ownrNm;
	}
 
	/**
	 * Column Info
	 * @return	ownrNm
	 */
	 public	 String	getOwnrNm() {
		 return	this.ownrNm;
	 } 
 	/**
	* Column Info
	* @param  actFoilBodQty
	*/
	public void	setActFoilBodQty( String	actFoilBodQty ) {
		this.actFoilBodQty =	actFoilBodQty;
	}
 
	/**
	 * Column Info
	 * @return	actFoilBodQty
	 */
	 public	 String	getActFoilBodQty() {
		 return	this.actFoilBodQty;
	 } 
 	/**
	* Column Info
	* @param  rfCntrPlgQty
	*/
	public void	setRfCntrPlgQty( String	rfCntrPlgQty ) {
		this.rfCntrPlgQty =	rfCntrPlgQty;
	}
 
	/**
	 * Column Info
	 * @return	rfCntrPlgQty
	 */
	 public	 String	getRfCntrPlgQty() {
		 return	this.rfCntrPlgQty;
	 } 
 	/**
	* Column Info
	* @param  oaRsvCurrCd
	*/
	public void	setOaRsvCurrCd( String	oaRsvCurrCd ) {
		this.oaRsvCurrCd =	oaRsvCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	oaRsvCurrCd
	 */
	 public	 String	getOaRsvCurrCd() {
		 return	this.oaRsvCurrCd;
	 } 
 	/**
	* Column Info
	* @param  grsWgt
	*/
	public void	setGrsWgt( String	grsWgt ) {
		this.grsWgt =	grsWgt;
	}
 
	/**
	 * Column Info
	 * @return	grsWgt
	 */
	 public	 String	getGrsWgt() {
		 return	this.grsWgt;
	 } 
 	/**
	* Column Info
	* @param  declFlg
	*/
	public void	setDeclFlg( String	declFlg ) {
		this.declFlg =	declFlg;
	}
 
	/**
	 * Column Info
	 * @return	declFlg
	 */
	 public	 String	getDeclFlg() {
		 return	this.declFlg;
	 } 
 	/**
	* Column Info
	* @param  agmtDocNo
	*/
	public void	setAgmtDocNo( String	agmtDocNo ) {
		this.agmtDocNo =	agmtDocNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtDocNo
	 */
	 public	 String	getAgmtDocNo() {
		 return	this.agmtDocNo;
	 } 
 	/**
	* Column Info
	* @param  agmtDocDesc
	*/
	public void	setAgmtDocDesc( String	agmtDocDesc ) {
		this.agmtDocDesc =	agmtDocDesc;
	}
 
	/**
	 * Column Info
	 * @return	agmtDocDesc
	 */
	 public	 String	getAgmtDocDesc() {
		 return	this.agmtDocDesc;
	 } 
 	/**
	* Column Info
	* @param  actLowSulpFoilBodQty
	*/
	public void	setActLowSulpFoilBodQty( String	actLowSulpFoilBodQty ) {
		this.actLowSulpFoilBodQty =	actLowSulpFoilBodQty;
	}
 
	/**
	 * Column Info
	 * @return	actLowSulpFoilBodQty
	 */
	 public	 String	getActLowSulpFoilBodQty() {
		 return	this.actLowSulpFoilBodQty;
	 } 
 	/**
	* Column Info
	* @param  actLowSulpGasOilBodQty
	*/
	public void	setActLowSulpGasOilBodQty( String	actLowSulpGasOilBodQty ) {
		this.actLowSulpGasOilBodQty =	actLowSulpGasOilBodQty;
	}
 
	/**
	 * Column Info
	 * @return	actLowSulpGasOilBodQty
	 */
	 public	 String	getActLowSulpGasOilBodQty() {
		 return	this.actLowSulpGasOilBodQty;
	 } 
 	/**
	* Column Info
	* @param  actLowSulpFoilBorQty
	*/
	public void	setActLowSulpFoilBorQty( String	actLowSulpFoilBorQty ) {
		this.actLowSulpFoilBorQty =	actLowSulpFoilBorQty;
	}
 
	/**
	 * Column Info
	 * @return	actLowSulpFoilBorQty
	 */
	 public	 String	getActLowSulpFoilBorQty() {
		 return	this.actLowSulpFoilBorQty;
	 } 
 	/**
	* Column Info
	* @param  actLowSulpGasOilBorQty
	*/
	public void	setActLowSulpGasOilBorQty( String	actLowSulpGasOilBorQty ) {
		this.actLowSulpGasOilBorQty =	actLowSulpGasOilBorQty;
	}
 
	/**
	 * Column Info
	 * @return	actLowSulpGasOilBorQty
	 */
	 public	 String	getActLowSulpGasOilBorQty() {
		 return	this.actLowSulpGasOilBorQty;
	 } 
 	/**
	* Column Info
	* @param  lowSulpFoilBodOutPrc
	*/
	public void	setLowSulpFoilBodOutPrc( String	lowSulpFoilBodOutPrc ) {
		this.lowSulpFoilBodOutPrc =	lowSulpFoilBodOutPrc;
	}
 
	/**
	 * Column Info
	 * @return	lowSulpFoilBodOutPrc
	 */
	 public	 String	getLowSulpFoilBodOutPrc() {
		 return	this.lowSulpFoilBodOutPrc;
	 } 
 	/**
	* Column Info
	* @param  lowSulpGasOilBodOutPrc
	*/
	public void	setLowSulpGasOilBodOutPrc( String	lowSulpGasOilBodOutPrc ) {
		this.lowSulpGasOilBodOutPrc =	lowSulpGasOilBodOutPrc;
	}
 
	/**
	 * Column Info
	 * @return	lowSulpGasOilBodOutPrc
	 */
	 public	 String	getLowSulpGasOilBodOutPrc() {
		 return	this.lowSulpGasOilBodOutPrc;
	 } 
 	/**
	* Column Info
	* @param  lowSulpFoilBorOutPrc
	*/
	public void	setLowSulpFoilBorOutPrc( String	lowSulpFoilBorOutPrc ) {
		this.lowSulpFoilBorOutPrc =	lowSulpFoilBorOutPrc;
	}
 
	/**
	 * Column Info
	 * @return	lowSulpFoilBorOutPrc
	 */
	 public	 String	getLowSulpFoilBorOutPrc() {
		 return	this.lowSulpFoilBorOutPrc;
	 } 
 	/**
	* Column Info
	* @param  lowSulpGasOilBorOutPrc
	*/
	public void	setLowSulpGasOilBorOutPrc( String	lowSulpGasOilBorOutPrc ) {
		this.lowSulpGasOilBorOutPrc =	lowSulpGasOilBorOutPrc;
	}
 
	/**
	 * Column Info
	 * @return	lowSulpGasOilBorOutPrc
	 */
	 public	 String	getLowSulpGasOilBorOutPrc() {
		 return	this.lowSulpGasOilBorOutPrc;
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
		setVslDzndCapa(JSPUtil.getParameter(request,	prefix + "vsl_dznd_capa", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setAcmmRtAmt(JSPUtil.getParameter(request,	prefix + "acmm_rt_amt", ""));
		setFletCtrtTpCd(JSPUtil.getParameter(request,	prefix + "flet_ctrt_tp_cd", ""));
		setDoilBodOutPrc(JSPUtil.getParameter(request,	prefix + "doil_bod_out_prc", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setFoilBodOutPrc(JSPUtil.getParameter(request,	prefix + "foil_bod_out_prc", ""));
		setFletBrogRtAmt(JSPUtil.getParameter(request,	prefix + "flet_brog_rt_amt", ""));
		setShpSpdQty(JSPUtil.getParameter(request,	prefix + "shp_spd_qty", ""));
		setFromTime(JSPUtil.getParameter(request,	prefix + "from_time", ""));
		setRdeRngCtnt(JSPUtil.getParameter(request,	prefix + "rde_rng_ctnt", ""));
		setFletCtrtNo(JSPUtil.getParameter(request,	prefix + "flet_ctrt_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setNrtWgt(JSPUtil.getParameter(request,	prefix + "nrt_wgt", ""));
		setVslBldDt(JSPUtil.getParameter(request,	prefix + "vsl_bld_dt", ""));
		setFoilBorOutPrc(JSPUtil.getParameter(request,	prefix + "foil_bor_out_prc", ""));
		setCntNm(JSPUtil.getParameter(request,	prefix + "cnt_nm", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setDoilBorOutPrc(JSPUtil.getParameter(request,	prefix + "doil_bor_out_prc", ""));
		setVslEngNm(JSPUtil.getParameter(request,	prefix + "vsl_eng_nm", ""));
		setDdwtCgoCapaQty(JSPUtil.getParameter(request,	prefix + "ddwt_cgo_capa_qty", ""));
		setActDoilBorQty(JSPUtil.getParameter(request,	prefix + "act_doil_bor_qty", ""));
		setCpDt(JSPUtil.getParameter(request,	prefix + "cp_dt", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setVslCntCd(JSPUtil.getParameter(request,	prefix + "vsl_cnt_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setActFoilBorQty(JSPUtil.getParameter(request,	prefix + "act_foil_bor_qty", ""));
		setRdeNtcCtnt(JSPUtil.getParameter(request,	prefix + "rde_ntc_ctnt", ""));
		setFletCtrtFactCd(JSPUtil.getParameter(request,	prefix + "flet_ctrt_fact_cd", ""));
		setFletGmtLmtCd(JSPUtil.getParameter(request,	prefix + "flet_gmt_lmt_cd", ""));
		setActDoilBodQty(JSPUtil.getParameter(request,	prefix + "act_doil_bod_qty", ""));
		setBorPortCd(JSPUtil.getParameter(request,	prefix + "bor_port_cd", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setToTime(JSPUtil.getParameter(request,	prefix + "to_time", ""));
		setFletOlayCommRtAmt(JSPUtil.getParameter(request,	prefix + "flet_olay_comm_rt_amt", ""));
		setBodPortCd(JSPUtil.getParameter(request,	prefix + "bod_port_cd", ""));
		setOaRsvAmt(JSPUtil.getParameter(request,	prefix + "oa_rsv_amt", ""));
		setBse14tonVslCapa(JSPUtil.getParameter(request,	prefix + "bse_14ton_vsl_capa", ""));
		setGrFlg(JSPUtil.getParameter(request,	prefix + "gr_flg", ""));
		setChtrPrdOptCtnt(JSPUtil.getParameter(request,	prefix + "chtr_prd_opt_ctnt", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setOwnrNm(JSPUtil.getParameter(request,	prefix + "ownr_nm", ""));
		setActFoilBodQty(JSPUtil.getParameter(request,	prefix + "act_foil_bod_qty", ""));
		setRfCntrPlgQty(JSPUtil.getParameter(request,	prefix + "rf_cntr_plg_qty", ""));
		setOaRsvCurrCd(JSPUtil.getParameter(request,	prefix + "oa_rsv_curr_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request,	prefix + "grs_wgt", ""));
		setDeclFlg(JSPUtil.getParameter(request,	prefix + "decl_flg", ""));
		setAgmtDocNo(JSPUtil.getParameter(request,	prefix + "agmt_doc_no", ""));
		setAgmtDocDesc(JSPUtil.getParameter(request,	prefix + "agmt_doc_desc", ""));
		setActLowSulpFoilBodQty(JSPUtil.getParameter(request,	prefix + "act_low_sulp_foil_bod_qty", ""));
		setActLowSulpGasOilBodQty(JSPUtil.getParameter(request,	prefix + "act_low_sulp_gas_oil_bod_qty", ""));
		setActLowSulpFoilBorQty(JSPUtil.getParameter(request,	prefix + "act_low_sulp_foil_bor_qty", ""));
		setActLowSulpGasOilBorQty(JSPUtil.getParameter(request,	prefix + "act_low_sulp_gas_oil_bor_qty", ""));
		setLowSulpFoilBodOutPrc(JSPUtil.getParameter(request,	prefix + "low_sulp_foil_bod_out_prc", ""));
		setLowSulpGasOilBodOutPrc(JSPUtil.getParameter(request,	prefix + "low_sulp_gas_oil_bod_out_prc", ""));
		setLowSulpFoilBorOutPrc(JSPUtil.getParameter(request,	prefix + "low_sulp_foil_bor_out_prc", ""));
		setLowSulpGasOilBorOutPrc(JSPUtil.getParameter(request,	prefix + "low_sulp_gas_oil_bor_out_prc", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchContractVO[]
	 */
	public SearchContractVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return SearchContractVO[]
	 */
	public SearchContractVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SearchContractVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] vslDzndCapa =	(JSPUtil.getParameter(request, prefix +	"vsl_dznd_capa".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] acmmRtAmt =	(JSPUtil.getParameter(request, prefix +	"acmm_rt_amt".trim(),	length));
				String[] fletCtrtTpCd =	(JSPUtil.getParameter(request, prefix +	"flet_ctrt_tp_cd".trim(),	length));
				String[] doilBodOutPrc =	(JSPUtil.getParameter(request, prefix +	"doil_bod_out_prc".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] foilBodOutPrc =	(JSPUtil.getParameter(request, prefix +	"foil_bod_out_prc".trim(),	length));
				String[] fletBrogRtAmt =	(JSPUtil.getParameter(request, prefix +	"flet_brog_rt_amt".trim(),	length));
				String[] shpSpdQty =	(JSPUtil.getParameter(request, prefix +	"shp_spd_qty".trim(),	length));
				String[] fromTime =	(JSPUtil.getParameter(request, prefix +	"from_time".trim(),	length));
				String[] rdeRngCtnt =	(JSPUtil.getParameter(request, prefix +	"rde_rng_ctnt".trim(),	length));
				String[] fletCtrtNo =	(JSPUtil.getParameter(request, prefix +	"flet_ctrt_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] nrtWgt =	(JSPUtil.getParameter(request, prefix +	"nrt_wgt".trim(),	length));
				String[] vslBldDt =	(JSPUtil.getParameter(request, prefix +	"vsl_bld_dt".trim(),	length));
				String[] foilBorOutPrc =	(JSPUtil.getParameter(request, prefix +	"foil_bor_out_prc".trim(),	length));
				String[] cntNm =	(JSPUtil.getParameter(request, prefix +	"cnt_nm".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt".trim(),	length));
				String[] doilBorOutPrc =	(JSPUtil.getParameter(request, prefix +	"doil_bor_out_prc".trim(),	length));
				String[] vslEngNm =	(JSPUtil.getParameter(request, prefix +	"vsl_eng_nm".trim(),	length));
				String[] ddwtCgoCapaQty =	(JSPUtil.getParameter(request, prefix +	"ddwt_cgo_capa_qty".trim(),	length));
				String[] actDoilBorQty =	(JSPUtil.getParameter(request, prefix +	"act_doil_bor_qty".trim(),	length));
				String[] cpDt =	(JSPUtil.getParameter(request, prefix +	"cp_dt".trim(),	length));
				String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt".trim(),	length));
				String[] vslCntCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cnt_cd".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] actFoilBorQty =	(JSPUtil.getParameter(request, prefix +	"act_foil_bor_qty".trim(),	length));
				String[] rdeNtcCtnt =	(JSPUtil.getParameter(request, prefix +	"rde_ntc_ctnt".trim(),	length));
				String[] fletCtrtFactCd =	(JSPUtil.getParameter(request, prefix +	"flet_ctrt_fact_cd".trim(),	length));
				String[] fletGmtLmtCd =	(JSPUtil.getParameter(request, prefix +	"flet_gmt_lmt_cd".trim(),	length));
				String[] actDoilBodQty =	(JSPUtil.getParameter(request, prefix +	"act_doil_bod_qty".trim(),	length));
				String[] borPortCd =	(JSPUtil.getParameter(request, prefix +	"bor_port_cd".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] toTime =	(JSPUtil.getParameter(request, prefix +	"to_time".trim(),	length));
				String[] fletOlayCommRtAmt =	(JSPUtil.getParameter(request, prefix +	"flet_olay_comm_rt_amt".trim(),	length));
				String[] bodPortCd =	(JSPUtil.getParameter(request, prefix +	"bod_port_cd".trim(),	length));
				String[] oaRsvAmt =	(JSPUtil.getParameter(request, prefix +	"oa_rsv_amt".trim(),	length));
				String[] bse14tonVslCapa =	(JSPUtil.getParameter(request, prefix +	"bse_14ton_vsl_capa".trim(),	length));
				String[] grFlg =	(JSPUtil.getParameter(request, prefix +	"gr_flg".trim(),	length));
				String[] chtrPrdOptCtnt =	(JSPUtil.getParameter(request, prefix +	"chtr_prd_opt_ctnt".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] ownrNm =	(JSPUtil.getParameter(request, prefix +	"ownr_nm".trim(),	length));
				String[] actFoilBodQty =	(JSPUtil.getParameter(request, prefix +	"act_foil_bod_qty".trim(),	length));
				String[] rfCntrPlgQty =	(JSPUtil.getParameter(request, prefix +	"rf_cntr_plg_qty".trim(),	length));
				String[] oaRsvCurrCd =	(JSPUtil.getParameter(request, prefix +	"oa_rsv_curr_cd".trim(),	length));
				String[] grsWgt =	(JSPUtil.getParameter(request, prefix +	"grs_wgt".trim(),	length));
				String[] declFlg =	(JSPUtil.getParameter(request, prefix +	"decl_flg".trim(),	length));
				String[] agmtDocNo =	(JSPUtil.getParameter(request, prefix +	"agmt_doc_no".trim(),	length));
				String[] agmtDocDesc =	(JSPUtil.getParameter(request, prefix +	"agmt_doc_desc".trim(),	length));
				String[] actLowSulpFoilBodQty =	(JSPUtil.getParameter(request, prefix +	"act_low_sulp_foil_bod_qty".trim(),	length));
				String[] actLowSulpGasOilBodQty =	(JSPUtil.getParameter(request, prefix +	"act_low_sulp_gas_oil_bod_qty".trim(),	length));
				String[] actLowSulpFoilBorQty =	(JSPUtil.getParameter(request, prefix +	"act_low_sulp_foil_bor_qty".trim(),	length));
				String[] actLowSulpGasOilBorQty =	(JSPUtil.getParameter(request, prefix +	"act_low_sulp_gas_oil_bor_qty".trim(),	length));
				String[] lowSulpFoilBodOutPrc =	(JSPUtil.getParameter(request, prefix +	"low_sulp_foil_bod_out_prc".trim(),	length));
				String[] lowSulpGasOilBodOutPrc =	(JSPUtil.getParameter(request, prefix +	"low_sulp_gas_oil_bod_out_prc".trim(),	length));
				String[] lowSulpFoilBorOutPrc =	(JSPUtil.getParameter(request, prefix +	"low_sulp_foil_bor_out_prc".trim(),	length));
				String[] lowSulpGasOilBorOutPrc =	(JSPUtil.getParameter(request, prefix +	"low_sulp_gas_oil_bor_out_prc".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SearchContractVO();
						if ( vslDzndCapa[i] !=	null)
						model.setVslDzndCapa( vslDzndCapa[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( acmmRtAmt[i] !=	null)
						model.setAcmmRtAmt( acmmRtAmt[i]);
						if ( fletCtrtTpCd[i] !=	null)
						model.setFletCtrtTpCd( fletCtrtTpCd[i]);
						if ( doilBodOutPrc[i] !=	null)
						model.setDoilBodOutPrc( doilBodOutPrc[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( foilBodOutPrc[i] !=	null)
						model.setFoilBodOutPrc( foilBodOutPrc[i]);
						if ( fletBrogRtAmt[i] !=	null)
						model.setFletBrogRtAmt( fletBrogRtAmt[i]);
						if ( shpSpdQty[i] !=	null)
						model.setShpSpdQty( shpSpdQty[i]);
						if ( fromTime[i] !=	null)
						model.setFromTime( fromTime[i]);
						if ( rdeRngCtnt[i] !=	null)
						model.setRdeRngCtnt( rdeRngCtnt[i]);
						if ( fletCtrtNo[i] !=	null)
						model.setFletCtrtNo( fletCtrtNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( nrtWgt[i] !=	null)
						model.setNrtWgt( nrtWgt[i]);
						if ( vslBldDt[i] !=	null)
						model.setVslBldDt( vslBldDt[i]);
						if ( foilBorOutPrc[i] !=	null)
						model.setFoilBorOutPrc( foilBorOutPrc[i]);
						if ( cntNm[i] !=	null)
						model.setCntNm( cntNm[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( effDt[i] !=	null)
						model.setEffDt( effDt[i]);
						if ( doilBorOutPrc[i] !=	null)
						model.setDoilBorOutPrc( doilBorOutPrc[i]);
						if ( vslEngNm[i] !=	null)
						model.setVslEngNm( vslEngNm[i]);
						if ( ddwtCgoCapaQty[i] !=	null)
						model.setDdwtCgoCapaQty( ddwtCgoCapaQty[i]);
						if ( actDoilBorQty[i] !=	null)
						model.setActDoilBorQty( actDoilBorQty[i]);
						if ( cpDt[i] !=	null)
						model.setCpDt( cpDt[i]);
						if ( expDt[i] !=	null)
						model.setExpDt( expDt[i]);
						if ( vslCntCd[i] !=	null)
						model.setVslCntCd( vslCntCd[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( actFoilBorQty[i] !=	null)
						model.setActFoilBorQty( actFoilBorQty[i]);
						if ( rdeNtcCtnt[i] !=	null)
						model.setRdeNtcCtnt( rdeNtcCtnt[i]);
						if ( fletCtrtFactCd[i] !=	null)
						model.setFletCtrtFactCd( fletCtrtFactCd[i]);
						if ( fletGmtLmtCd[i] !=	null)
						model.setFletGmtLmtCd( fletGmtLmtCd[i]);
						if ( actDoilBodQty[i] !=	null)
						model.setActDoilBodQty( actDoilBodQty[i]);
						if ( borPortCd[i] !=	null)
						model.setBorPortCd( borPortCd[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( toTime[i] !=	null)
						model.setToTime( toTime[i]);
						if ( fletOlayCommRtAmt[i] !=	null)
						model.setFletOlayCommRtAmt( fletOlayCommRtAmt[i]);
						if ( bodPortCd[i] !=	null)
						model.setBodPortCd( bodPortCd[i]);
						if ( oaRsvAmt[i] !=	null)
						model.setOaRsvAmt( oaRsvAmt[i]);
						if ( bse14tonVslCapa[i] !=	null)
						model.setBse14tonVslCapa( bse14tonVslCapa[i]);
						if ( grFlg[i] !=	null)
						model.setGrFlg( grFlg[i]);
						if ( chtrPrdOptCtnt[i] !=	null)
						model.setChtrPrdOptCtnt( chtrPrdOptCtnt[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( ownrNm[i] !=	null)
						model.setOwnrNm( ownrNm[i]);
						if ( actFoilBodQty[i] !=	null)
						model.setActFoilBodQty( actFoilBodQty[i]);
						if ( rfCntrPlgQty[i] !=	null)
						model.setRfCntrPlgQty( rfCntrPlgQty[i]);
						if ( oaRsvCurrCd[i] !=	null)
						model.setOaRsvCurrCd( oaRsvCurrCd[i]);
						if ( grsWgt[i] !=	null)
						model.setGrsWgt( grsWgt[i]);
						if ( declFlg[i] !=	null)
						model.setDeclFlg( declFlg[i]);
						if ( agmtDocNo[i] !=	null)
						model.setAgmtDocNo( agmtDocNo[i]);
						if ( agmtDocDesc[i] !=	null)
						model.setAgmtDocDesc( agmtDocDesc[i]);
						if ( actLowSulpFoilBodQty[i] !=	null)
						model.setActLowSulpFoilBodQty( actLowSulpFoilBodQty[i]);
						if ( actLowSulpGasOilBodQty[i] !=	null)
						model.setActLowSulpGasOilBodQty( actLowSulpGasOilBodQty[i]);
						if ( actLowSulpFoilBorQty[i] !=	null)
						model.setActLowSulpFoilBorQty( actLowSulpFoilBorQty[i]);
						if ( actLowSulpGasOilBorQty[i] !=	null)
						model.setActLowSulpGasOilBorQty( actLowSulpGasOilBorQty[i]);
						if ( lowSulpFoilBodOutPrc[i] !=	null)
						model.setLowSulpFoilBodOutPrc( lowSulpFoilBodOutPrc[i]);
						if ( lowSulpGasOilBodOutPrc[i] !=	null)
						model.setLowSulpGasOilBodOutPrc( lowSulpGasOilBodOutPrc[i]);
						if ( lowSulpFoilBorOutPrc[i] !=	null)
						model.setLowSulpFoilBorOutPrc( lowSulpFoilBorOutPrc[i]);
						if ( lowSulpGasOilBorOutPrc[i] !=	null)
						model.setLowSulpGasOilBorOutPrc( lowSulpGasOilBorOutPrc[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSearchContractVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return SearchContractVO[]
	 */
	public SearchContractVO[]	 getSearchContractVOs(){
		SearchContractVO[] vos = (SearchContractVO[])models.toArray(new	SearchContractVO[models.size()]);
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
		this.vslDzndCapa =	this.vslDzndCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acmmRtAmt =	this.acmmRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtTpCd =	this.fletCtrtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilBodOutPrc =	this.doilBodOutPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilBodOutPrc =	this.foilBodOutPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletBrogRtAmt =	this.fletBrogRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpSpdQty =	this.shpSpdQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromTime =	this.fromTime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdeRngCtnt =	this.rdeRngCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo =	this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nrtWgt =	this.nrtWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslBldDt =	this.vslBldDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foilBorOutPrc =	this.foilBorOutPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntNm =	this.cntNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doilBorOutPrc =	this.doilBorOutPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm =	this.vslEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ddwtCgoCapaQty =	this.ddwtCgoCapaQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDoilBorQty =	this.actDoilBorQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cpDt =	this.cpDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCntCd =	this.vslCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFoilBorQty =	this.actFoilBorQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdeNtcCtnt =	this.rdeNtcCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtFactCd =	this.fletCtrtFactCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletGmtLmtCd =	this.fletGmtLmtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDoilBodQty =	this.actDoilBodQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.borPortCd =	this.borPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toTime =	this.toTime.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletOlayCommRtAmt =	this.fletOlayCommRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bodPortCd =	this.bodPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRsvAmt =	this.oaRsvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bse14tonVslCapa =	this.bse14tonVslCapa.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grFlg =	this.grFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chtrPrdOptCtnt =	this.chtrPrdOptCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrNm =	this.ownrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actFoilBodQty =	this.actFoilBodQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCntrPlgQty =	this.rfCntrPlgQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oaRsvCurrCd =	this.oaRsvCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt =	this.grsWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declFlg =	this.declFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocNo =	this.agmtDocNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDocDesc =	this.agmtDocDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actLowSulpFoilBodQty =	this.actLowSulpFoilBodQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actLowSulpGasOilBodQty =	this.actLowSulpGasOilBodQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actLowSulpFoilBorQty =	this.actLowSulpFoilBorQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actLowSulpGasOilBorQty =	this.actLowSulpGasOilBorQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowSulpFoilBodOutPrc =	this.lowSulpFoilBodOutPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowSulpGasOilBodOutPrc =	this.lowSulpGasOilBodOutPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowSulpFoilBorOutPrc =	this.lowSulpFoilBorOutPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lowSulpGasOilBorOutPrc =	this.lowSulpGasOilBorOutPrc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}