/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CustVipReportInVO.java
*@FileTitle : CustVipReportInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.08.19 김경섭 
* 1.0 Creation
*----------------------------------------------------------
* History
* 2010.09.10 김영철 [ ] VIP REPORT 부분 오류 수정 ( 반영일 : 2010.09.24 )
=========================================================*/
package	 com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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
public class CustVipReportInVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CustVipReportInVO>  models =	new	ArrayList<CustVipReportInVO>();


	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 ediGrCd   =  null;
	/*	Column Info	*/
	private  String	 selectList   =  null;
	/*	Column Info	*/
	private  String	 gdiGrNm   =  null;
	/*	Column Info	*/
	private  String	 vpsEtaDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 rowsPerPage   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 currPage   =  null;
	/*	Column Info	*/
	private  String	 spCargoRf   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 polYardCd   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 credit   =  null;
	/*	Column Info	*/
	private  String	 custTpCd   =  null;
	/*	Column Info	*/
	private  String	 inOutCd   =  null;
	/*	Column Info	*/
	private  String	 custCntCd   =  null;
	/*	Column Info	*/
	private  String	 vpsEtdDt   =  null;
	/*	Column Info	*/
	private  String	 spCargoBb   =  null;
	/*	Column Info	*/
	private  String	 gcust   =  null;
	/*	Column Info	*/
	private  String	 podYardCd   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 pBkgRptKndCd   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 ediId   =  null;
	/*	Column Info	*/
	private  String	 eqOfcCd   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 spCargoAk   =  null;
	/*	Column Info	*/
	private  String	 spCargoDg   =  null;
	/*	Column Info	*/
	private  String	 rfaNo   =  null;
	/*	Column Info	*/
	private  String	 taaNo   =  null;
	/*	Column Info	*/
	private  String	 agmtActCntCd   =  null;
	/*	Column Info	*/
	private  String	 agmtActCustSeq   =  null;
	/*	Column Info	*/
	private  String	 wmsMultiPo   =  null;
	/*	Column Info	*/
	private  String	 scacFlg   =  null;
	/*	Column Info	*/
	private  String	 initPolPodCd   =  null;
	/*	Column Info	*/
	private  String	 initDtFm   =  null;
	/*	Column Info	*/
	private  String	 initDtTo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CustVipReportInVO(){}

	public CustVipReportInVO(String porCd,String custNm,String ediGrCd,String selectList,String gdiGrNm,String vpsEtaDt,String pagerows,String polCd,String rowsPerPage,String ibflag,String currPage,String spCargoRf,String vvdCd,String polYardCd,String scNo,String credit,String custTpCd,String inOutCd,String custCntCd,String vpsEtdDt,String spCargoBb,String gcust,String podYardCd,String delCd,String pBkgRptKndCd,String custSeq,String ediId,String eqOfcCd,String podCd,String spCargoAk,String spCargoDg,String rfaNo,String taaNo,String agmtActCntCd,String agmtActCustSeq,String wmsMultiPo, String scacFlg, String initPolPodCd, String initDtFm, String initDtTo )	{
		this.porCd  = porCd ;
		this.custNm  = custNm ;
		this.ediGrCd  = ediGrCd ;
		this.selectList  = selectList ;
		this.gdiGrNm  = gdiGrNm ;
		this.vpsEtaDt  = vpsEtaDt ;
		this.pagerows  = pagerows ;
		this.polCd  = polCd ;
		this.rowsPerPage  = rowsPerPage ;
		this.ibflag  = ibflag ;
		this.currPage  = currPage ;
		this.spCargoRf  = spCargoRf ;
		this.vvdCd  = vvdCd ;
		this.polYardCd  = polYardCd ;
		this.scNo  = scNo ;
		this.credit  = credit ;
		this.custTpCd  = custTpCd ;
		this.inOutCd  = inOutCd ;
		this.custCntCd  = custCntCd ;
		this.vpsEtdDt  = vpsEtdDt ;
		this.spCargoBb  = spCargoBb ;
		this.gcust  = gcust ;
		this.podYardCd  = podYardCd ;
		this.delCd  = delCd ;
		this.pBkgRptKndCd  = pBkgRptKndCd ;
		this.custSeq  = custSeq ;
		this.ediId  = ediId ;
		this.eqOfcCd  = eqOfcCd ;
		this.podCd  = podCd ;
		this.spCargoAk  = spCargoAk ;
		this.spCargoDg  = spCargoDg ;
		this.rfaNo  = rfaNo ;
		this.taaNo  = taaNo ;
		this.agmtActCntCd  = agmtActCntCd ;
		this.agmtActCustSeq  = agmtActCustSeq ;
		this.wmsMultiPo  = wmsMultiPo ;
		this.scacFlg  = scacFlg ;
		this.initPolPodCd = initPolPodCd;
		this.initDtFm     = initDtFm    ;
		this.initDtTo     = initDtTo    ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("edi_gr_cd", getEdiGrCd());		
		this.hashColumns.put("select_list", getSelectList());		
		this.hashColumns.put("gdi_gr_nm", getGdiGrNm());		
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("rows_per_page", getRowsPerPage());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("curr_page", getCurrPage());		
		this.hashColumns.put("sp_cargo_rf", getSpCargoRf());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("pol_yard_cd", getPolYardCd());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("credit", getCredit());		
		this.hashColumns.put("cust_tp_cd", getCustTpCd());		
		this.hashColumns.put("in_out_cd", getInOutCd());		
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());		
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());		
		this.hashColumns.put("sp_cargo_bb", getSpCargoBb());		
		this.hashColumns.put("gcust", getGcust());		
		this.hashColumns.put("pod_yard_cd", getPodYardCd());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("p_bkg_rpt_knd_cd", getPBkgRptKndCd());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("edi_id", getEdiId());		
		this.hashColumns.put("eq_ofc_cd", getEqOfcCd());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("sp_cargo_ak", getSpCargoAk());		
		this.hashColumns.put("sp_cargo_dg", getSpCargoDg());		
		this.hashColumns.put("rfa_no", getRfaNo());		
		this.hashColumns.put("taa_no", getTaaNo());		
		this.hashColumns.put("agmt_act_cnt_cd", getAgmtActCntCd());		
		this.hashColumns.put("agmt_act_cust_seq", getAgmtActCustSeq());		
		this.hashColumns.put("wms_multi_po", getWmsMultiPo());		
		this.hashColumns.put("scac_flg", getScacFlg());	

		this.hashColumns.put("init_pol_pod_cd", getInitPolPodCd());	
		this.hashColumns.put("init_dt_fm", getInitDtFm    ());	
		this.hashColumns.put("init_dt_to", getInitDtTo    ());	
		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("edi_gr_cd", "ediGrCd");
		this.hashFields.put("select_list", "selectList");
		this.hashFields.put("gdi_gr_nm", "gdiGrNm");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("sp_cargo_rf", "spCargoRf");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("pol_yard_cd", "polYardCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("credit", "credit");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("in_out_cd", "inOutCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("sp_cargo_bb", "spCargoBb");
		this.hashFields.put("gcust", "gcust");
		this.hashFields.put("pod_yard_cd", "podYardCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("p_bkg_rpt_knd_cd", "pBkgRptKndCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("edi_id", "ediId");
		this.hashFields.put("eq_ofc_cd", "eqOfcCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sp_cargo_ak", "spCargoAk");
		this.hashFields.put("sp_cargo_dg", "spCargoDg");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("agmt_act_cnt_cd", "agmtActCntCd");
		this.hashFields.put("agmt_act_cust_seq", "agmtActCustSeq");
		this.hashFields.put("wms_multi_po", "wmsMultiPo");
		this.hashFields.put("scac_flg", "scacFlg");

		this.hashFields.put("init_pol_pod_cd", "initPolPodCd");
		this.hashFields.put("init_dt_fm", "initDtFm");
		this.hashFields.put("init_dt_to", "initDtTo");
		
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
	* @param  ediGrCd
	*/
	public void	setEdiGrCd( String	ediGrCd ) {
		this.ediGrCd =	ediGrCd;
	}
 
	/**
	 * Column Info
	 * @return	ediGrCd
	 */
	 public	 String	getEdiGrCd() {
		 return	this.ediGrCd;
	 } 
 	/**
	* Column Info
	* @param  selectList
	*/
	public void	setSelectList( String	selectList ) {
		this.selectList =	selectList;
	}
 
	/**
	 * Column Info
	 * @return	selectList
	 */
	 public	 String	getSelectList() {
		 return	this.selectList;
	 } 
 	/**
	* Column Info
	* @param  gdiGrNm
	*/
	public void	setGdiGrNm( String	gdiGrNm ) {
		this.gdiGrNm =	gdiGrNm;
	}
 
	/**
	 * Column Info
	 * @return	gdiGrNm
	 */
	 public	 String	getGdiGrNm() {
		 return	this.gdiGrNm;
	 } 
 	/**
	* Column Info
	* @param  vpsEtaDt
	*/
	public void	setVpsEtaDt( String	vpsEtaDt ) {
		this.vpsEtaDt =	vpsEtaDt;
	}
 
	/**
	 * Column Info
	 * @return	vpsEtaDt
	 */
	 public	 String	getVpsEtaDt() {
		 return	this.vpsEtaDt;
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
	* @param  rowsPerPage
	*/
	public void	setRowsPerPage( String	rowsPerPage ) {
		this.rowsPerPage =	rowsPerPage;
	}
 
	/**
	 * Column Info
	 * @return	rowsPerPage
	 */
	 public	 String	getRowsPerPage() {
		 return	this.rowsPerPage;
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
	* @param  currPage
	*/
	public void	setCurrPage( String	currPage ) {
		this.currPage =	currPage;
	}
 
	/**
	 * Column Info
	 * @return	currPage
	 */
	 public	 String	getCurrPage() {
		 return	this.currPage;
	 } 
 	/**
	* Column Info
	* @param  spCargoRf
	*/
	public void	setSpCargoRf( String	spCargoRf ) {
		this.spCargoRf =	spCargoRf;
	}
 
	/**
	 * Column Info
	 * @return	spCargoRf
	 */
	 public	 String	getSpCargoRf() {
		 return	this.spCargoRf;
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
	* @param  polYardCd
	*/
	public void	setPolYardCd( String	polYardCd ) {
		this.polYardCd =	polYardCd;
	}
 
	/**
	 * Column Info
	 * @return	polYardCd
	 */
	 public	 String	getPolYardCd() {
		 return	this.polYardCd;
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
	* @param  credit
	*/
	public void	setCredit( String	credit ) {
		this.credit =	credit;
	}
 
	/**
	 * Column Info
	 * @return	credit
	 */
	 public	 String	getCredit() {
		 return	this.credit;
	 } 
 	/**
	* Column Info
	* @param  custTpCd
	*/
	public void	setCustTpCd( String	custTpCd ) {
		this.custTpCd =	custTpCd;
	}
 
	/**
	 * Column Info
	 * @return	custTpCd
	 */
	 public	 String	getCustTpCd() {
		 return	this.custTpCd;
	 } 
 	/**
	* Column Info
	* @param  inOutCd
	*/
	public void	setInOutCd( String	inOutCd ) {
		this.inOutCd =	inOutCd;
	}
 
	/**
	 * Column Info
	 * @return	inOutCd
	 */
	 public	 String	getInOutCd() {
		 return	this.inOutCd;
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
	* @param  vpsEtdDt
	*/
	public void	setVpsEtdDt( String	vpsEtdDt ) {
		this.vpsEtdDt =	vpsEtdDt;
	}
 
	/**
	 * Column Info
	 * @return	vpsEtdDt
	 */
	 public	 String	getVpsEtdDt() {
		 return	this.vpsEtdDt;
	 } 
 	/**
	* Column Info
	* @param  spCargoBb
	*/
	public void	setSpCargoBb( String	spCargoBb ) {
		this.spCargoBb =	spCargoBb;
	}
 
	/**
	 * Column Info
	 * @return	spCargoBb
	 */
	 public	 String	getSpCargoBb() {
		 return	this.spCargoBb;
	 } 
 	/**
	* Column Info
	* @param  gcust
	*/
	public void	setGcust( String	gcust ) {
		this.gcust =	gcust;
	}
 
	/**
	 * Column Info
	 * @return	gcust
	 */
	 public	 String	getGcust() {
		 return	this.gcust;
	 } 
 	/**
	* Column Info
	* @param  podYardCd
	*/
	public void	setPodYardCd( String	podYardCd ) {
		this.podYardCd =	podYardCd;
	}
 
	/**
	 * Column Info
	 * @return	podYardCd
	 */
	 public	 String	getPodYardCd() {
		 return	this.podYardCd;
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
	* @param  pBkgRptKndCd
	*/
	public void	setPBkgRptKndCd( String	pBkgRptKndCd ) {
		this.pBkgRptKndCd =	pBkgRptKndCd;
	}
 
	/**
	 * Column Info
	 * @return	pBkgRptKndCd
	 */
	 public	 String	getPBkgRptKndCd() {
		 return	this.pBkgRptKndCd;
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
	* @param  ediId
	*/
	public void	setEdiId( String	ediId ) {
		this.ediId =	ediId;
	}
 
	/**
	 * Column Info
	 * @return	ediId
	 */
	 public	 String	getEdiId() {
		 return	this.ediId;
	 } 
 	/**
	* Column Info
	* @param  eqOfcCd
	*/
	public void	setEqOfcCd( String	eqOfcCd ) {
		this.eqOfcCd =	eqOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	eqOfcCd
	 */
	 public	 String	getEqOfcCd() {
		 return	this.eqOfcCd;
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
	* @param  spCargoAk
	*/
	public void	setSpCargoAk( String	spCargoAk ) {
		this.spCargoAk =	spCargoAk;
	}
 
	/**
	 * Column Info
	 * @return	spCargoAk
	 */
	 public	 String	getSpCargoAk() {
		 return	this.spCargoAk;
	 } 
 	/**
	* Column Info
	* @param  spCargoDg
	*/
	public void	setSpCargoDg( String	spCargoDg ) {
		this.spCargoDg =	spCargoDg;
	}
 
	/**
	 * Column Info
	 * @return	spCargoDg
	 */
	 public	 String	getSpCargoDg() {
		 return	this.spCargoDg;
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
	* @param  taaNo
	*/
	public void	setTaaNo( String	taaNo ) {
		this.taaNo =	taaNo;
	}
 
	/**
	 * Column Info
	 * @return	taaNo
	 */
	 public	 String	getTaaNo() {
		 return	this.taaNo;
	 } 
 	/**
	* Column Info
	* @param  agmtActCntCd
	*/
	public void	setAgmtActCntCd( String	agmtActCntCd ) {
		this.agmtActCntCd =	agmtActCntCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtActCntCd
	 */
	 public	 String	getAgmtActCntCd() {
		 return	this.agmtActCntCd;
	 } 
 	/**
	* Column Info
	* @param  agmtActCustSeq
	*/
	public void	setAgmtActCustSeq( String	agmtActCustSeq ) {
		this.agmtActCustSeq =	agmtActCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	agmtActCustSeq
	 */
	 public	 String	getAgmtActCustSeq() {
		 return	this.agmtActCustSeq;
	 } 
 	/**
	* Column Info
	* @param  wmsMultiPo
	*/
	public void	setWmsMultiPo( String	wmsMultiPo ) {
		this.wmsMultiPo =	wmsMultiPo;
	}
 
	/**
	 * Column Info
	 * @return	wmsMultiPo
	 */
	 public	 String	getWmsMultiPo() {
		 return	this.wmsMultiPo;
	 } 

	public String getScacFlg() {
		return scacFlg;
	}

	public void setScacFlg(String scacFlg) {
		this.scacFlg = scacFlg;
	}

	public String getInitPolPodCd() {
		return initPolPodCd;
	}

	public void setInitPolPodCd(String initPolPodCd) {
		this.initPolPodCd = initPolPodCd;
	}

	public String getInitDtFm() {
		return initDtFm;
	}

	public void setInitDtFm(String initDtFm) {
		this.initDtFm = initDtFm;
	}

	public String getInitDtTo() {
		return initDtTo;
	}

	public void setInitDtTo(String initDtTo) {
		this.initDtTo = initDtTo;
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
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setEdiGrCd(JSPUtil.getParameter(request,	prefix + "edi_gr_cd", ""));
		setSelectList(JSPUtil.getParameter(request,	prefix + "select_list", ""));
		setGdiGrNm(JSPUtil.getParameter(request,	prefix + "gdi_gr_nm", ""));
		setVpsEtaDt(JSPUtil.getParameter(request,	prefix + "vps_eta_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request,	prefix + "rows_per_page", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCurrPage(JSPUtil.getParameter(request,	prefix + "curr_page", ""));
		setSpCargoRf(JSPUtil.getParameter(request,	prefix + "sp_cargo_rf", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setPolYardCd(JSPUtil.getParameter(request,	prefix + "pol_yard_cd", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setCredit(JSPUtil.getParameter(request,	prefix + "credit", ""));
		setCustTpCd(JSPUtil.getParameter(request,	prefix + "cust_tp_cd", ""));
		setInOutCd(JSPUtil.getParameter(request,	prefix + "in_out_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request,	prefix + "vps_etd_dt", ""));
		setSpCargoBb(JSPUtil.getParameter(request,	prefix + "sp_cargo_bb", ""));
		setGcust(JSPUtil.getParameter(request,	prefix + "gcust", ""));
		setPodYardCd(JSPUtil.getParameter(request,	prefix + "pod_yard_cd", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setPBkgRptKndCd(JSPUtil.getParameter(request,	prefix + "p_bkg_rpt_knd_cd", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setEdiId(JSPUtil.getParameter(request,	prefix + "edi_id", ""));
		setEqOfcCd(JSPUtil.getParameter(request,	prefix + "eq_ofc_cd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setSpCargoAk(JSPUtil.getParameter(request,	prefix + "sp_cargo_ak", ""));
		setSpCargoDg(JSPUtil.getParameter(request,	prefix + "sp_cargo_dg", ""));
		setRfaNo(JSPUtil.getParameter(request,	prefix + "rfa_no", ""));
		setTaaNo(JSPUtil.getParameter(request,	prefix + "taa_no", ""));
		setAgmtActCntCd(JSPUtil.getParameter(request,	prefix + "agmt_act_cnt_cd", ""));
		setAgmtActCustSeq(JSPUtil.getParameter(request,	prefix + "agmt_act_cust_seq", ""));
		setWmsMultiPo(JSPUtil.getParameter(request,	prefix + "wms_multi_po", ""));
		setScacFlg(JSPUtil.getParameter(request,	prefix + "scac_flg", ""));
		
		setInitPolPodCd(JSPUtil.getParameter(request,	prefix + "init_pol_pod_cd", ""));
		setInitDtFm    (JSPUtil.getParameter(request,	prefix + "init_dt_fm", ""));
		setInitDtTo    (JSPUtil.getParameter(request,	prefix + "init_dt_to", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustVipReportInVO[]
	 */
	public CustVipReportInVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CustVipReportInVO[]
	 */
	public CustVipReportInVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CustVipReportInVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] ediGrCd =	(JSPUtil.getParameter(request, prefix +	"edi_gr_cd".trim(),	length));
				String[] selectList =	(JSPUtil.getParameter(request, prefix +	"select_list".trim(),	length));
				String[] gdiGrNm =	(JSPUtil.getParameter(request, prefix +	"gdi_gr_nm".trim(),	length));
				String[] vpsEtaDt =	(JSPUtil.getParameter(request, prefix +	"vps_eta_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] rowsPerPage =	(JSPUtil.getParameter(request, prefix +	"rows_per_page".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] currPage =	(JSPUtil.getParameter(request, prefix +	"curr_page".trim(),	length));
				String[] spCargoRf =	(JSPUtil.getParameter(request, prefix +	"sp_cargo_rf".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] polYardCd =	(JSPUtil.getParameter(request, prefix +	"pol_yard_cd".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] credit =	(JSPUtil.getParameter(request, prefix +	"credit".trim(),	length));
				String[] custTpCd =	(JSPUtil.getParameter(request, prefix +	"cust_tp_cd".trim(),	length));
				String[] inOutCd =	(JSPUtil.getParameter(request, prefix +	"in_out_cd".trim(),	length));
				String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd".trim(),	length));
				String[] vpsEtdDt =	(JSPUtil.getParameter(request, prefix +	"vps_etd_dt".trim(),	length));
				String[] spCargoBb =	(JSPUtil.getParameter(request, prefix +	"sp_cargo_bb".trim(),	length));
				String[] gcust =	(JSPUtil.getParameter(request, prefix +	"gcust".trim(),	length));
				String[] podYardCd =	(JSPUtil.getParameter(request, prefix +	"pod_yard_cd".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] pBkgRptKndCd =	(JSPUtil.getParameter(request, prefix +	"p_bkg_rpt_knd_cd".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] ediId =	(JSPUtil.getParameter(request, prefix +	"edi_id".trim(),	length));
				String[] eqOfcCd =	(JSPUtil.getParameter(request, prefix +	"eq_ofc_cd".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] spCargoAk =	(JSPUtil.getParameter(request, prefix +	"sp_cargo_ak".trim(),	length));
				String[] spCargoDg =	(JSPUtil.getParameter(request, prefix +	"sp_cargo_dg".trim(),	length));
				String[] rfaNo =	(JSPUtil.getParameter(request, prefix +	"rfa_no".trim(),	length));
				String[] taaNo =	(JSPUtil.getParameter(request, prefix +	"taa_no".trim(),	length));
				String[] agmtActCntCd =	(JSPUtil.getParameter(request, prefix +	"agmt_act_cnt_cd".trim(),	length));
				String[] agmtActCustSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_act_cust_seq".trim(),	length));
				String[] wmsMultiPo =	(JSPUtil.getParameter(request, prefix +	"wms_multi_po".trim(),	length));
				String[] scacFlg =	(JSPUtil.getParameter(request, prefix +	"scac_flg".trim(),	length));

				String[] initPolPodCd =	(JSPUtil.getParameter(request, prefix +	"init_pol_pod_cd".trim(),	length));
				String[] initDtFm     =	(JSPUtil.getParameter(request, prefix +	"init_dt_fm".trim(),	length));
				String[] initDtTo     =	(JSPUtil.getParameter(request, prefix +	"init_dt_to".trim(),	length));
				
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CustVipReportInVO();
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( ediGrCd[i] !=	null)
						model.setEdiGrCd( ediGrCd[i]);
						if ( selectList[i] !=	null)
						model.setSelectList( selectList[i]);
						if ( gdiGrNm[i] !=	null)
						model.setGdiGrNm( gdiGrNm[i]);
						if ( vpsEtaDt[i] !=	null)
						model.setVpsEtaDt( vpsEtaDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( rowsPerPage[i] !=	null)
						model.setRowsPerPage( rowsPerPage[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( currPage[i] !=	null)
						model.setCurrPage( currPage[i]);
						if ( spCargoRf[i] !=	null)
						model.setSpCargoRf( spCargoRf[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( polYardCd[i] !=	null)
						model.setPolYardCd( polYardCd[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( credit[i] !=	null)
						model.setCredit( credit[i]);
						if ( custTpCd[i] !=	null)
						model.setCustTpCd( custTpCd[i]);
						if ( inOutCd[i] !=	null)
						model.setInOutCd( inOutCd[i]);
						if ( custCntCd[i] !=	null)
						model.setCustCntCd( custCntCd[i]);
						if ( vpsEtdDt[i] !=	null)
						model.setVpsEtdDt( vpsEtdDt[i]);
						if ( spCargoBb[i] !=	null)
						model.setSpCargoBb( spCargoBb[i]);
						if ( gcust[i] !=	null)
						model.setGcust( gcust[i]);
						if ( podYardCd[i] !=	null)
						model.setPodYardCd( podYardCd[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( pBkgRptKndCd[i] !=	null)
						model.setPBkgRptKndCd( pBkgRptKndCd[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( ediId[i] !=	null)
						model.setEdiId( ediId[i]);
						if ( eqOfcCd[i] !=	null)
						model.setEqOfcCd( eqOfcCd[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( spCargoAk[i] !=	null)
						model.setSpCargoAk( spCargoAk[i]);
						if ( spCargoDg[i] !=	null)
						model.setSpCargoDg( spCargoDg[i]);
						if ( rfaNo[i] !=	null)
						model.setRfaNo( rfaNo[i]);
						if ( taaNo[i] !=	null)
						model.setTaaNo( taaNo[i]);
						if ( agmtActCntCd[i] !=	null)
						model.setAgmtActCntCd( agmtActCntCd[i]);
						if ( agmtActCustSeq[i] !=	null)
						model.setAgmtActCustSeq( agmtActCustSeq[i]);
						if ( wmsMultiPo[i] !=	null)
						model.setWmsMultiPo( wmsMultiPo[i]);
						if ( scacFlg[i] !=	null)
							model.setScacFlg( scacFlg[i]);
						
						if ( initPolPodCd[i] !=	null)  model.setInitPolPodCd( initPolPodCd[i]);
						if ( initDtFm    [i] !=	null)  model.setInitDtFm    ( initDtFm    [i]);
						if ( initDtTo    [i] !=	null)  model.setInitDtTo    ( initDtTo    [i]);
						
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCustVipReportInVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CustVipReportInVO[]
	 */
	public CustVipReportInVO[]	 getCustVipReportInVOs(){
		CustVipReportInVO[] vos = (CustVipReportInVO[])models.toArray(new	CustVipReportInVO[models.size()]);
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
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediGrCd =	this.ediGrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectList =	this.selectList.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gdiGrNm =	this.gdiGrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt =	this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage =	this.rowsPerPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage =	this.currPage.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoRf =	this.spCargoRf.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYardCd =	this.polYardCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.credit =	this.credit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd =	this.custTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inOutCd =	this.inOutCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt =	this.vpsEtdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoBb =	this.spCargoBb.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gcust =	this.gcust.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYardCd =	this.podYardCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pBkgRptKndCd =	this.pBkgRptKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediId =	this.ediId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqOfcCd =	this.eqOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoAk =	this.spCargoAk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spCargoDg =	this.spCargoDg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo =	this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo =	this.taaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCntCd =	this.agmtActCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtActCustSeq =	this.agmtActCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wmsMultiPo =	this.wmsMultiPo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scacFlg =	this.scacFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

		this.initPolPodCd =	this.initPolPodCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initDtFm     =	this.initDtFm    .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.initDtTo     =	this.initDtTo    .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}