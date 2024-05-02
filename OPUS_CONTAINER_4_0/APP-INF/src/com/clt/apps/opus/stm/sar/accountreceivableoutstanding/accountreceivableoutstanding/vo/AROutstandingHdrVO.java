/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AROutstandingHdrVO.java
 *@FileTitle : AROutstandingHdrVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.08.01
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.08.01  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.vo;

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
public class AROutstandingHdrVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AROutstandingHdrVO>  models =	new	ArrayList<AROutstandingHdrVO>();


	/*	Column Info	*/
	private  String	 ifDt   =  null;
	/*	Column Info	*/
	private  String	 xchRtDt   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 bilToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 stlFlg   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 otsTpCd   =  null;
	/*	Column Info	*/
	private  String	 cltOfcCd   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 otsGrpTpCd   =  null;
	/*	Column Info	*/
	private  String	 ofcCurrCd   =  null;
	/*	Column Info	*/
	private  String	 otsSrcCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 shpToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtN3rdTpCd   =  null;
	/*	Column Info	*/
	private  String	 trnkVvdCd   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 bilToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 otsRmk   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 crMkFlg   =  null;
	/*	Column Info	*/
	private  String	 maxArIfNo   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 laneCd   =  null;
	/*	Column Info	*/
	private  String	 xchRtTpCd   =  null;
	/*	Column Info	*/
	private  String	 lstInvNo   =  null;
	/*	Column Info	*/
	private  String	 bkgIoBndCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 dirCd   =  null;
	/*	Column Info	*/
	private  String	 dueDt   =  null;
	/*	Column Info	*/
	private  String	 otsRtFlg   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 bkgNoSplit   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 bkgRefNo   =  null;
	/*	Column Info	*/
	private  String	 apArOffstNo   =  null;
	/*	Column Info	*/
	private  String	 shpToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 custSrepCd   =  null;
	/*	Column Info	*/
	private  String	 revTpSrcCd   =  null;
	/*	Column Info	*/
	private  String	 sailDt   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 invLoclXchRt   =  null;
	/*	Column Info	*/
	private  String	 invUsdXchRt   =  null;
	/*	Column Info	*/
	private  String	 arOfcCd   =  null;
	/*	Column Info	*/
	private  String	 oblIssOfcCd   =  null;
	/*	Column Info	*/
	private  String	 bkgStlFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AROutstandingHdrVO(){}

	public AROutstandingHdrVO(String ifDt,String xchRtDt,String vslCd,String bilToCustCntCd,String stlFlg,String svcScpCd,String otsTpCd,String cltOfcCd,String sailArrDt,String blNo,String pagerows,String polCd,String scNo,String otsGrpTpCd,String ofcCurrCd,String otsSrcCd,String updUsrId,String invDt,String shpToCustSeq,String rhqCd,String xchRtN3rdTpCd,String trnkVvdCd,String delCd,String skdVoyNo,String bilToCustSeq,String podCd,String bkgNo,String otsRmk,String creUsrId,String crMkFlg,String maxArIfNo,String otsOfcCd,String porCd,String laneCd,String xchRtTpCd,String lstInvNo,String bkgIoBndCd,String creDt,String ibflag,String dirCd,String dueDt,String otsRtFlg,String updDt,String bkgNoSplit,String invNo,String bkgRefNo,String apArOffstNo,String shpToCustCntCd,String custSrepCd,String revTpSrcCd,String sailDt,String invCurrCd,String invLoclXchRt,String invUsdXchRt,String arOfcCd,String oblIssOfcCd,String bkgStlFlg)	{
		this.ifDt  = ifDt ;
		this.xchRtDt  = xchRtDt ;
		this.vslCd  = vslCd ;
		this.bilToCustCntCd  = bilToCustCntCd ;
		this.stlFlg  = stlFlg ;
		this.svcScpCd  = svcScpCd ;
		this.otsTpCd  = otsTpCd ;
		this.cltOfcCd  = cltOfcCd ;
		this.sailArrDt  = sailArrDt ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.polCd  = polCd ;
		this.scNo  = scNo ;
		this.otsGrpTpCd  = otsGrpTpCd ;
		this.ofcCurrCd  = ofcCurrCd ;
		this.otsSrcCd  = otsSrcCd ;
		this.updUsrId  = updUsrId ;
		this.invDt  = invDt ;
		this.shpToCustSeq  = shpToCustSeq ;
		this.rhqCd  = rhqCd ;
		this.xchRtN3rdTpCd  = xchRtN3rdTpCd ;
		this.trnkVvdCd  = trnkVvdCd ;
		this.delCd  = delCd ;
		this.skdVoyNo  = skdVoyNo ;
		this.bilToCustSeq  = bilToCustSeq ;
		this.podCd  = podCd ;
		this.bkgNo  = bkgNo ;
		this.otsRmk  = otsRmk ;
		this.creUsrId  = creUsrId ;
		this.crMkFlg  = crMkFlg ;
		this.maxArIfNo  = maxArIfNo ;
		this.otsOfcCd  = otsOfcCd ;
		this.porCd  = porCd ;
		this.laneCd  = laneCd ;
		this.xchRtTpCd  = xchRtTpCd ;
		this.lstInvNo  = lstInvNo ;
		this.bkgIoBndCd  = bkgIoBndCd ;
		this.creDt  = creDt ;
		this.ibflag  = ibflag ;
		this.dirCd  = dirCd ;
		this.dueDt  = dueDt ;
		this.otsRtFlg  = otsRtFlg ;
		this.updDt  = updDt ;
		this.bkgNoSplit  = bkgNoSplit ;
		this.invNo  = invNo ;
		this.bkgRefNo  = bkgRefNo ;
		this.apArOffstNo  = apArOffstNo ;
		this.shpToCustCntCd  = shpToCustCntCd ;
		this.custSrepCd  = custSrepCd ;
		this.revTpSrcCd  = revTpSrcCd ;
		this.sailDt  = sailDt ;
		this.invCurrCd  = invCurrCd ;
		this.invLoclXchRt  = invLoclXchRt ;
		this.invUsdXchRt  = invUsdXchRt ;
		this.arOfcCd  = arOfcCd ;
		this.oblIssOfcCd  = oblIssOfcCd ;
		this.bkgStlFlg  = bkgStlFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("if_dt", getIfDt());		
		this.hashColumns.put("xch_rt_dt", getXchRtDt());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());		
		this.hashColumns.put("stl_flg", getStlFlg());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("ots_tp_cd", getOtsTpCd());		
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("ots_grp_tp_cd", getOtsGrpTpCd());		
		this.hashColumns.put("ofc_curr_cd", getOfcCurrCd());		
		this.hashColumns.put("ots_src_cd", getOtsSrcCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("shp_to_cust_seq", getShpToCustSeq());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("xch_rt_n3rd_tp_cd", getXchRtN3rdTpCd());		
		this.hashColumns.put("trnk_vvd_cd", getTrnkVvdCd());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ots_rmk", getOtsRmk());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("cr_mk_flg", getCrMkFlg());		
		this.hashColumns.put("max_ar_if_no", getMaxArIfNo());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("lane_cd", getLaneCd());		
		this.hashColumns.put("xch_rt_tp_cd", getXchRtTpCd());		
		this.hashColumns.put("lst_inv_no", getLstInvNo());		
		this.hashColumns.put("bkg_io_bnd_cd", getBkgIoBndCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("dir_cd", getDirCd());		
		this.hashColumns.put("due_dt", getDueDt());		
		this.hashColumns.put("ots_rt_flg", getOtsRtFlg());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("bkg_no_split", getBkgNoSplit());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());		
		this.hashColumns.put("ap_ar_offst_no", getApArOffstNo());		
		this.hashColumns.put("shp_to_cust_cnt_cd", getShpToCustCntCd());		
		this.hashColumns.put("cust_srep_cd", getCustSrepCd());		
		this.hashColumns.put("rev_tp_src_cd", getRevTpSrcCd());		
		this.hashColumns.put("sail_dt", getSailDt());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("inv_locl_xch_rt", getInvLoclXchRt());		
		this.hashColumns.put("inv_usd_xch_rt", getInvUsdXchRt());		
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());		
		this.hashColumns.put("obl_iss_ofc_cd", getOblIssOfcCd());		
		this.hashColumns.put("bkg_stl_flg", getBkgStlFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("if_dt", "ifDt");
		this.hashFields.put("xch_rt_dt", "xchRtDt");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("ots_tp_cd", "otsTpCd");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ots_grp_tp_cd", "otsGrpTpCd");
		this.hashFields.put("ofc_curr_cd", "ofcCurrCd");
		this.hashFields.put("ots_src_cd", "otsSrcCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("shp_to_cust_seq", "shpToCustSeq");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("xch_rt_n3rd_tp_cd", "xchRtN3rdTpCd");
		this.hashFields.put("trnk_vvd_cd", "trnkVvdCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cr_mk_flg", "crMkFlg");
		this.hashFields.put("max_ar_if_no", "maxArIfNo");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("xch_rt_tp_cd", "xchRtTpCd");
		this.hashFields.put("lst_inv_no", "lstInvNo");
		this.hashFields.put("bkg_io_bnd_cd", "bkgIoBndCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("ots_rt_flg", "otsRtFlg");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("bkg_no_split", "bkgNoSplit");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("ap_ar_offst_no", "apArOffstNo");
		this.hashFields.put("shp_to_cust_cnt_cd", "shpToCustCntCd");
		this.hashFields.put("cust_srep_cd", "custSrepCd");
		this.hashFields.put("rev_tp_src_cd", "revTpSrcCd");
		this.hashFields.put("sail_dt", "sailDt");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("inv_locl_xch_rt", "invLoclXchRt");
		this.hashFields.put("inv_usd_xch_rt", "invUsdXchRt");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("obl_iss_ofc_cd", "oblIssOfcCd");
		this.hashFields.put("bkg_stl_flg", "bkgStlFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  ifDt
	*/
	public void	setIfDt( String	ifDt ) {
		this.ifDt =	ifDt;
	}
 
	/**
	 * Column Info
	 * @return	ifDt
	 */
	 public	 String	getIfDt() {
		 return	this.ifDt;
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
	* @param  bilToCustCntCd
	*/
	public void	setBilToCustCntCd( String	bilToCustCntCd ) {
		this.bilToCustCntCd =	bilToCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	bilToCustCntCd
	 */
	 public	 String	getBilToCustCntCd() {
		 return	this.bilToCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  stlFlg
	*/
	public void	setStlFlg( String	stlFlg ) {
		this.stlFlg =	stlFlg;
	}
 
	/**
	 * Column Info
	 * @return	stlFlg
	 */
	 public	 String	getStlFlg() {
		 return	this.stlFlg;
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
	* @param  otsTpCd
	*/
	public void	setOtsTpCd( String	otsTpCd ) {
		this.otsTpCd =	otsTpCd;
	}
 
	/**
	 * Column Info
	 * @return	otsTpCd
	 */
	 public	 String	getOtsTpCd() {
		 return	this.otsTpCd;
	 } 
 	/**
	* Column Info
	* @param  cltOfcCd
	*/
	public void	setCltOfcCd( String	cltOfcCd ) {
		this.cltOfcCd =	cltOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	cltOfcCd
	 */
	 public	 String	getCltOfcCd() {
		 return	this.cltOfcCd;
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
	* @param  otsGrpTpCd
	*/
	public void	setOtsGrpTpCd( String	otsGrpTpCd ) {
		this.otsGrpTpCd =	otsGrpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	otsGrpTpCd
	 */
	 public	 String	getOtsGrpTpCd() {
		 return	this.otsGrpTpCd;
	 } 
 	/**
	* Column Info
	* @param  ofcCurrCd
	*/
	public void	setOfcCurrCd( String	ofcCurrCd ) {
		this.ofcCurrCd =	ofcCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCurrCd
	 */
	 public	 String	getOfcCurrCd() {
		 return	this.ofcCurrCd;
	 } 
 	/**
	* Column Info
	* @param  otsSrcCd
	*/
	public void	setOtsSrcCd( String	otsSrcCd ) {
		this.otsSrcCd =	otsSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	otsSrcCd
	 */
	 public	 String	getOtsSrcCd() {
		 return	this.otsSrcCd;
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
	* @param  invDt
	*/
	public void	setInvDt( String	invDt ) {
		this.invDt =	invDt;
	}
 
	/**
	 * Column Info
	 * @return	invDt
	 */
	 public	 String	getInvDt() {
		 return	this.invDt;
	 } 
 	/**
	* Column Info
	* @param  shpToCustSeq
	*/
	public void	setShpToCustSeq( String	shpToCustSeq ) {
		this.shpToCustSeq =	shpToCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	shpToCustSeq
	 */
	 public	 String	getShpToCustSeq() {
		 return	this.shpToCustSeq;
	 } 
 	/**
	* Column Info
	* @param  rhqCd
	*/
	public void	setRhqCd( String	rhqCd ) {
		this.rhqCd =	rhqCd;
	}
 
	/**
	 * Column Info
	 * @return	rhqCd
	 */
	 public	 String	getRhqCd() {
		 return	this.rhqCd;
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
	* @param  trnkVvdCd
	*/
	public void	setTrnkVvdCd( String	trnkVvdCd ) {
		this.trnkVvdCd =	trnkVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	trnkVvdCd
	 */
	 public	 String	getTrnkVvdCd() {
		 return	this.trnkVvdCd;
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
	* @param  bilToCustSeq
	*/
	public void	setBilToCustSeq( String	bilToCustSeq ) {
		this.bilToCustSeq =	bilToCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	bilToCustSeq
	 */
	 public	 String	getBilToCustSeq() {
		 return	this.bilToCustSeq;
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
	* @param  otsRmk
	*/
	public void	setOtsRmk( String	otsRmk ) {
		this.otsRmk =	otsRmk;
	}
 
	/**
	 * Column Info
	 * @return	otsRmk
	 */
	 public	 String	getOtsRmk() {
		 return	this.otsRmk;
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
	* @param  crMkFlg
	*/
	public void	setCrMkFlg( String	crMkFlg ) {
		this.crMkFlg =	crMkFlg;
	}
 
	/**
	 * Column Info
	 * @return	crMkFlg
	 */
	 public	 String	getCrMkFlg() {
		 return	this.crMkFlg;
	 } 
 	/**
	* Column Info
	* @param  maxArIfNo
	*/
	public void	setMaxArIfNo( String	maxArIfNo ) {
		this.maxArIfNo =	maxArIfNo;
	}
 
	/**
	 * Column Info
	 * @return	maxArIfNo
	 */
	 public	 String	getMaxArIfNo() {
		 return	this.maxArIfNo;
	 } 
 	/**
	* Column Info
	* @param  otsOfcCd
	*/
	public void	setOtsOfcCd( String	otsOfcCd ) {
		this.otsOfcCd =	otsOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	otsOfcCd
	 */
	 public	 String	getOtsOfcCd() {
		 return	this.otsOfcCd;
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
	* @param  xchRtTpCd
	*/
	public void	setXchRtTpCd( String	xchRtTpCd ) {
		this.xchRtTpCd =	xchRtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	xchRtTpCd
	 */
	 public	 String	getXchRtTpCd() {
		 return	this.xchRtTpCd;
	 } 
 	/**
	* Column Info
	* @param  lstInvNo
	*/
	public void	setLstInvNo( String	lstInvNo ) {
		this.lstInvNo =	lstInvNo;
	}
 
	/**
	 * Column Info
	 * @return	lstInvNo
	 */
	 public	 String	getLstInvNo() {
		 return	this.lstInvNo;
	 } 
 	/**
	* Column Info
	* @param  bkgIoBndCd
	*/
	public void	setBkgIoBndCd( String	bkgIoBndCd ) {
		this.bkgIoBndCd =	bkgIoBndCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgIoBndCd
	 */
	 public	 String	getBkgIoBndCd() {
		 return	this.bkgIoBndCd;
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
	* @param  dirCd
	*/
	public void	setDirCd( String	dirCd ) {
		this.dirCd =	dirCd;
	}
 
	/**
	 * Column Info
	 * @return	dirCd
	 */
	 public	 String	getDirCd() {
		 return	this.dirCd;
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
	* @param  otsRtFlg
	*/
	public void	setOtsRtFlg( String	otsRtFlg ) {
		this.otsRtFlg =	otsRtFlg;
	}
 
	/**
	 * Column Info
	 * @return	otsRtFlg
	 */
	 public	 String	getOtsRtFlg() {
		 return	this.otsRtFlg;
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
	* @param  apArOffstNo
	*/
	public void	setApArOffstNo( String	apArOffstNo ) {
		this.apArOffstNo =	apArOffstNo;
	}
 
	/**
	 * Column Info
	 * @return	apArOffstNo
	 */
	 public	 String	getApArOffstNo() {
		 return	this.apArOffstNo;
	 } 
 	/**
	* Column Info
	* @param  shpToCustCntCd
	*/
	public void	setShpToCustCntCd( String	shpToCustCntCd ) {
		this.shpToCustCntCd =	shpToCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	shpToCustCntCd
	 */
	 public	 String	getShpToCustCntCd() {
		 return	this.shpToCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  custSrepCd
	*/
	public void	setCustSrepCd( String	custSrepCd ) {
		this.custSrepCd =	custSrepCd;
	}
 
	/**
	 * Column Info
	 * @return	custSrepCd
	 */
	 public	 String	getCustSrepCd() {
		 return	this.custSrepCd;
	 } 
 	/**
	* Column Info
	* @param  revTpSrcCd
	*/
	public void	setRevTpSrcCd( String	revTpSrcCd ) {
		this.revTpSrcCd =	revTpSrcCd;
	}
 
	/**
	 * Column Info
	 * @return	revTpSrcCd
	 */
	 public	 String	getRevTpSrcCd() {
		 return	this.revTpSrcCd;
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
	* @param  invLoclXchRt
	*/
	public void	setInvLoclXchRt( String	invLoclXchRt ) {
		this.invLoclXchRt =	invLoclXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invLoclXchRt
	 */
	 public	 String	getInvLoclXchRt() {
		 return	this.invLoclXchRt;
	 } 
 	/**
	* Column Info
	* @param  invUsdXchRt
	*/
	public void	setInvUsdXchRt( String	invUsdXchRt ) {
		this.invUsdXchRt =	invUsdXchRt;
	}
 
	/**
	 * Column Info
	 * @return	invUsdXchRt
	 */
	 public	 String	getInvUsdXchRt() {
		 return	this.invUsdXchRt;
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
	* @param  oblIssOfcCd
	*/
	public void	setOblIssOfcCd( String	oblIssOfcCd ) {
		this.oblIssOfcCd =	oblIssOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	oblIssOfcCd
	 */
	 public	 String	getOblIssOfcCd() {
		 return	this.oblIssOfcCd;
	 } 
 	/**
	* Column Info
	* @param  bkgStlFlg
	*/
	public void	setBkgStlFlg( String	bkgStlFlg ) {
		this.bkgStlFlg =	bkgStlFlg;
	}
 
	/**
	 * Column Info
	 * @return	bkgStlFlg
	 */
	 public	 String	getBkgStlFlg() {
		 return	this.bkgStlFlg;
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
		setIfDt(JSPUtil.getParameter(request,	prefix + "if_dt", ""));
		setXchRtDt(JSPUtil.getParameter(request,	prefix + "xch_rt_dt", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request,	prefix + "bil_to_cust_cnt_cd", ""));
		setStlFlg(JSPUtil.getParameter(request,	prefix + "stl_flg", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setOtsTpCd(JSPUtil.getParameter(request,	prefix + "ots_tp_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request,	prefix + "clt_ofc_cd", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setOtsGrpTpCd(JSPUtil.getParameter(request,	prefix + "ots_grp_tp_cd", ""));
		setOfcCurrCd(JSPUtil.getParameter(request,	prefix + "ofc_curr_cd", ""));
		setOtsSrcCd(JSPUtil.getParameter(request,	prefix + "ots_src_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setShpToCustSeq(JSPUtil.getParameter(request,	prefix + "shp_to_cust_seq", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setXchRtN3rdTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_n3rd_tp_cd", ""));
		setTrnkVvdCd(JSPUtil.getParameter(request,	prefix + "trnk_vvd_cd", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setBilToCustSeq(JSPUtil.getParameter(request,	prefix + "bil_to_cust_seq", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setOtsRmk(JSPUtil.getParameter(request,	prefix + "ots_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCrMkFlg(JSPUtil.getParameter(request,	prefix + "cr_mk_flg", ""));
		setMaxArIfNo(JSPUtil.getParameter(request,	prefix + "max_ar_if_no", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setPorCd(JSPUtil.getParameter(request,	prefix + "por_cd", ""));
		setLaneCd(JSPUtil.getParameter(request,	prefix + "lane_cd", ""));
		setXchRtTpCd(JSPUtil.getParameter(request,	prefix + "xch_rt_tp_cd", ""));
		setLstInvNo(JSPUtil.getParameter(request,	prefix + "lst_inv_no", ""));
		setBkgIoBndCd(JSPUtil.getParameter(request,	prefix + "bkg_io_bnd_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setDirCd(JSPUtil.getParameter(request,	prefix + "dir_cd", ""));
		setDueDt(JSPUtil.getParameter(request,	prefix + "due_dt", ""));
		setOtsRtFlg(JSPUtil.getParameter(request,	prefix + "ots_rt_flg", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setBkgNoSplit(JSPUtil.getParameter(request,	prefix + "bkg_no_split", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setBkgRefNo(JSPUtil.getParameter(request,	prefix + "bkg_ref_no", ""));
		setApArOffstNo(JSPUtil.getParameter(request,	prefix + "ap_ar_offst_no", ""));
		setShpToCustCntCd(JSPUtil.getParameter(request,	prefix + "shp_to_cust_cnt_cd", ""));
		setCustSrepCd(JSPUtil.getParameter(request,	prefix + "cust_srep_cd", ""));
		setRevTpSrcCd(JSPUtil.getParameter(request,	prefix + "rev_tp_src_cd", ""));
		setSailDt(JSPUtil.getParameter(request,	prefix + "sail_dt", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setInvLoclXchRt(JSPUtil.getParameter(request,	prefix + "inv_locl_xch_rt", ""));
		setInvUsdXchRt(JSPUtil.getParameter(request,	prefix + "inv_usd_xch_rt", ""));
		setArOfcCd(JSPUtil.getParameter(request,	prefix + "ar_ofc_cd", ""));
		setOblIssOfcCd(JSPUtil.getParameter(request,	prefix + "obl_iss_ofc_cd", ""));
		setBkgStlFlg(JSPUtil.getParameter(request,	prefix + "bkg_stl_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AROutstandingHdrVO[]
	 */
	public AROutstandingHdrVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AROutstandingHdrVO[]
	 */
	public AROutstandingHdrVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AROutstandingHdrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ifDt =	(JSPUtil.getParameter(request, prefix +	"if_dt".trim(),	length));
				String[] xchRtDt =	(JSPUtil.getParameter(request, prefix +	"xch_rt_dt".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] bilToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_cnt_cd".trim(),	length));
				String[] stlFlg =	(JSPUtil.getParameter(request, prefix +	"stl_flg".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] otsTpCd =	(JSPUtil.getParameter(request, prefix +	"ots_tp_cd".trim(),	length));
				String[] cltOfcCd =	(JSPUtil.getParameter(request, prefix +	"clt_ofc_cd".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] otsGrpTpCd =	(JSPUtil.getParameter(request, prefix +	"ots_grp_tp_cd".trim(),	length));
				String[] ofcCurrCd =	(JSPUtil.getParameter(request, prefix +	"ofc_curr_cd".trim(),	length));
				String[] otsSrcCd =	(JSPUtil.getParameter(request, prefix +	"ots_src_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] shpToCustSeq =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_seq".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] xchRtN3rdTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_n3rd_tp_cd".trim(),	length));
				String[] trnkVvdCd =	(JSPUtil.getParameter(request, prefix +	"trnk_vvd_cd".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] bilToCustSeq =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_seq".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] otsRmk =	(JSPUtil.getParameter(request, prefix +	"ots_rmk".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] crMkFlg =	(JSPUtil.getParameter(request, prefix +	"cr_mk_flg".trim(),	length));
				String[] maxArIfNo =	(JSPUtil.getParameter(request, prefix +	"max_ar_if_no".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] laneCd =	(JSPUtil.getParameter(request, prefix +	"lane_cd".trim(),	length));
				String[] xchRtTpCd =	(JSPUtil.getParameter(request, prefix +	"xch_rt_tp_cd".trim(),	length));
				String[] lstInvNo =	(JSPUtil.getParameter(request, prefix +	"lst_inv_no".trim(),	length));
				String[] bkgIoBndCd =	(JSPUtil.getParameter(request, prefix +	"bkg_io_bnd_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] dirCd =	(JSPUtil.getParameter(request, prefix +	"dir_cd".trim(),	length));
				String[] dueDt =	(JSPUtil.getParameter(request, prefix +	"due_dt".trim(),	length));
				String[] otsRtFlg =	(JSPUtil.getParameter(request, prefix +	"ots_rt_flg".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] bkgNoSplit =	(JSPUtil.getParameter(request, prefix +	"bkg_no_split".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] bkgRefNo =	(JSPUtil.getParameter(request, prefix +	"bkg_ref_no".trim(),	length));
				String[] apArOffstNo =	(JSPUtil.getParameter(request, prefix +	"ap_ar_offst_no".trim(),	length));
				String[] shpToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_cnt_cd".trim(),	length));
				String[] custSrepCd =	(JSPUtil.getParameter(request, prefix +	"cust_srep_cd".trim(),	length));
				String[] revTpSrcCd =	(JSPUtil.getParameter(request, prefix +	"rev_tp_src_cd".trim(),	length));
				String[] sailDt =	(JSPUtil.getParameter(request, prefix +	"sail_dt".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] invLoclXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_locl_xch_rt".trim(),	length));
				String[] invUsdXchRt =	(JSPUtil.getParameter(request, prefix +	"inv_usd_xch_rt".trim(),	length));
				String[] arOfcCd =	(JSPUtil.getParameter(request, prefix +	"ar_ofc_cd".trim(),	length));
				String[] oblIssOfcCd =	(JSPUtil.getParameter(request, prefix +	"obl_iss_ofc_cd".trim(),	length));
				String[] bkgStlFlg =	(JSPUtil.getParameter(request, prefix +	"bkg_stl_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AROutstandingHdrVO();
						if ( ifDt[i] !=	null)
						model.setIfDt( ifDt[i]);
						if ( xchRtDt[i] !=	null)
						model.setXchRtDt( xchRtDt[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( bilToCustCntCd[i] !=	null)
						model.setBilToCustCntCd( bilToCustCntCd[i]);
						if ( stlFlg[i] !=	null)
						model.setStlFlg( stlFlg[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( otsTpCd[i] !=	null)
						model.setOtsTpCd( otsTpCd[i]);
						if ( cltOfcCd[i] !=	null)
						model.setCltOfcCd( cltOfcCd[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( otsGrpTpCd[i] !=	null)
						model.setOtsGrpTpCd( otsGrpTpCd[i]);
						if ( ofcCurrCd[i] !=	null)
						model.setOfcCurrCd( ofcCurrCd[i]);
						if ( otsSrcCd[i] !=	null)
						model.setOtsSrcCd( otsSrcCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( shpToCustSeq[i] !=	null)
						model.setShpToCustSeq( shpToCustSeq[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( xchRtN3rdTpCd[i] !=	null)
						model.setXchRtN3rdTpCd( xchRtN3rdTpCd[i]);
						if ( trnkVvdCd[i] !=	null)
						model.setTrnkVvdCd( trnkVvdCd[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( bilToCustSeq[i] !=	null)
						model.setBilToCustSeq( bilToCustSeq[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( otsRmk[i] !=	null)
						model.setOtsRmk( otsRmk[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( crMkFlg[i] !=	null)
						model.setCrMkFlg( crMkFlg[i]);
						if ( maxArIfNo[i] !=	null)
						model.setMaxArIfNo( maxArIfNo[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( laneCd[i] !=	null)
						model.setLaneCd( laneCd[i]);
						if ( xchRtTpCd[i] !=	null)
						model.setXchRtTpCd( xchRtTpCd[i]);
						if ( lstInvNo[i] !=	null)
						model.setLstInvNo( lstInvNo[i]);
						if ( bkgIoBndCd[i] !=	null)
						model.setBkgIoBndCd( bkgIoBndCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( dirCd[i] !=	null)
						model.setDirCd( dirCd[i]);
						if ( dueDt[i] !=	null)
						model.setDueDt( dueDt[i]);
						if ( otsRtFlg[i] !=	null)
						model.setOtsRtFlg( otsRtFlg[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( bkgNoSplit[i] !=	null)
						model.setBkgNoSplit( bkgNoSplit[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( bkgRefNo[i] !=	null)
						model.setBkgRefNo( bkgRefNo[i]);
						if ( apArOffstNo[i] !=	null)
						model.setApArOffstNo( apArOffstNo[i]);
						if ( shpToCustCntCd[i] !=	null)
						model.setShpToCustCntCd( shpToCustCntCd[i]);
						if ( custSrepCd[i] !=	null)
						model.setCustSrepCd( custSrepCd[i]);
						if ( revTpSrcCd[i] !=	null)
						model.setRevTpSrcCd( revTpSrcCd[i]);
						if ( sailDt[i] !=	null)
						model.setSailDt( sailDt[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( invLoclXchRt[i] !=	null)
						model.setInvLoclXchRt( invLoclXchRt[i]);
						if ( invUsdXchRt[i] !=	null)
						model.setInvUsdXchRt( invUsdXchRt[i]);
						if ( arOfcCd[i] !=	null)
						model.setArOfcCd( arOfcCd[i]);
						if ( oblIssOfcCd[i] !=	null)
						model.setOblIssOfcCd( oblIssOfcCd[i]);
						if ( bkgStlFlg[i] !=	null)
						model.setBkgStlFlg( bkgStlFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAROutstandingHdrVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AROutstandingHdrVO[]
	 */
	public AROutstandingHdrVO[]	 getAROutstandingHdrVOs(){
		AROutstandingHdrVO[] vos = (AROutstandingHdrVO[])models.toArray(new	AROutstandingHdrVO[models.size()]);
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
		this.ifDt =	this.ifDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtDt =	this.xchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd =	this.bilToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg =	this.stlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsTpCd =	this.otsTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd =	this.cltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsGrpTpCd =	this.otsGrpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCurrCd =	this.ofcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrcCd =	this.otsSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustSeq =	this.shpToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtN3rdTpCd =	this.xchRtN3rdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdCd =	this.trnkVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq =	this.bilToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk =	this.otsRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crMkFlg =	this.crMkFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxArIfNo =	this.maxArIfNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd =	this.porCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd =	this.laneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xchRtTpCd =	this.xchRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstInvNo =	this.lstInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIoBndCd =	this.bkgIoBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd =	this.dirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt =	this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRtFlg =	this.otsRtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNoSplit =	this.bkgNoSplit.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo =	this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apArOffstNo =	this.apArOffstNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustCntCd =	this.shpToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSrepCd =	this.custSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revTpSrcCd =	this.revTpSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailDt =	this.sailDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLoclXchRt =	this.invLoclXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invUsdXchRt =	this.invUsdXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd =	this.arOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssOfcCd =	this.oblIssOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStlFlg =	this.bkgStlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}