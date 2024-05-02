/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : OutstandingHdrByBlVO.java
 *@FileTitle : OutstandingHdrByBlVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.17
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.12.17  
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
public class OutstandingHdrByBlVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<OutstandingHdrByBlVO>  models =	new	ArrayList<OutstandingHdrByBlVO>();


	/*	Column Info	*/
	private  String	 porCd   =  null;
	/*	Column Info	*/
	private  String	 laneCd   =  null;
	/*	Column Info	*/
	private  String	 custNm   =  null;
	/*	Column Info	*/
	private  String	 bilToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 otsTpCd   =  null;
	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 cltOfcCd   =  null;
	/*	Column Info	*/
	private  String	 bkgIoBndCd   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 obCrTermDys   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 condBkgNo   =  null;
	/*	Column Info	*/
	private  String	 ibCrTermDys   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 shipCustNm   =  null;
	/*	Column Info	*/
	private  String	 crAmt   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 otsGrpTpCd   =  null;
	/*	Column Info	*/
	private  String	 otsSrcCd   =  null;
	/*	Column Info	*/
	private  String	 dueDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 otsRtFlg   =  null;
	/*	Column Info	*/
	private  String	 shpToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 custNum   =  null;
	/*	Column Info	*/
	private  String	 rhqCd   =  null;
	/*	Column Info	*/
	private  String	 trnkVvdCd   =  null;
	/*	Column Info	*/
	private  String	 delCd   =  null;
	/*	Column Info	*/
	private  String	 bilToCustSeq   =  null;
	/*	Column Info	*/
	private  String	 crCurrCd   =  null;
	/*	Column Info	*/
	private  String	 bkgRefNo   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 otsRmk   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 shpToCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 custSrepCd   =  null;
	/*	Column Info	*/
	private  String	 shipCustNum   =  null;
	/*	Column Info	*/
	private  String	 condBlNo   =  null;
	/*	Column Info	*/
	private  String	 overDue   =  null;
	/*	Column Info	*/
	private  String	 invCurrCd   =  null;
	/*	Column Info	*/
	private  String	 otsPayCd   =  null;
	/*	Column Info	*/
	private  String	 orgInvNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public OutstandingHdrByBlVO(){}

	public OutstandingHdrByBlVO(String porCd,String laneCd,String custNm,String bilToCustCntCd,String otsTpCd,String svcScpCd,String cltOfcCd,String bkgIoBndCd,String blNo,String obCrTermDys,String sailArrDt,String pagerows,String condBkgNo,String ibCrTermDys,String polCd,String ibflag,String shipCustNm,String crAmt,String scNo,String otsGrpTpCd,String otsSrcCd,String dueDt,String updUsrId,String invDt,String otsRtFlg,String shpToCustSeq,String custNum,String rhqCd,String trnkVvdCd,String delCd,String bilToCustSeq,String crCurrCd,String bkgRefNo,String podCd,String invNo,String vvd,String creUsrId,String otsRmk,String bkgNo,String shpToCustCntCd,String otsOfcCd,String custSrepCd,String shipCustNum,String condBlNo,String overDue,String invCurrCd,String otsPayCd,String orgInvNo)	{
		this.porCd  = porCd ;
		this.laneCd  = laneCd ;
		this.custNm  = custNm ;
		this.bilToCustCntCd  = bilToCustCntCd ;
		this.otsTpCd  = otsTpCd ;
		this.svcScpCd  = svcScpCd ;
		this.cltOfcCd  = cltOfcCd ;
		this.bkgIoBndCd  = bkgIoBndCd ;
		this.blNo  = blNo ;
		this.obCrTermDys  = obCrTermDys ;
		this.sailArrDt  = sailArrDt ;
		this.pagerows  = pagerows ;
		this.condBkgNo  = condBkgNo ;
		this.ibCrTermDys  = ibCrTermDys ;
		this.polCd  = polCd ;
		this.ibflag  = ibflag ;
		this.shipCustNm  = shipCustNm ;
		this.crAmt  = crAmt ;
		this.scNo  = scNo ;
		this.otsGrpTpCd  = otsGrpTpCd ;
		this.otsSrcCd  = otsSrcCd ;
		this.dueDt  = dueDt ;
		this.updUsrId  = updUsrId ;
		this.invDt  = invDt ;
		this.otsRtFlg  = otsRtFlg ;
		this.shpToCustSeq  = shpToCustSeq ;
		this.custNum  = custNum ;
		this.rhqCd  = rhqCd ;
		this.trnkVvdCd  = trnkVvdCd ;
		this.delCd  = delCd ;
		this.bilToCustSeq  = bilToCustSeq ;
		this.crCurrCd  = crCurrCd ;
		this.bkgRefNo  = bkgRefNo ;
		this.podCd  = podCd ;
		this.invNo  = invNo ;
		this.vvd  = vvd ;
		this.creUsrId  = creUsrId ;
		this.otsRmk  = otsRmk ;
		this.bkgNo  = bkgNo ;
		this.shpToCustCntCd  = shpToCustCntCd ;
		this.otsOfcCd  = otsOfcCd ;
		this.custSrepCd  = custSrepCd ;
		this.shipCustNum  = shipCustNum ;
		this.condBlNo  = condBlNo ;
		this.overDue  = overDue ;
		this.invCurrCd  = invCurrCd ;
		this.otsPayCd  = otsPayCd ;
		this.orgInvNo  = orgInvNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());		
		this.hashColumns.put("lane_cd", getLaneCd());		
		this.hashColumns.put("cust_nm", getCustNm());		
		this.hashColumns.put("bil_to_cust_cnt_cd", getBilToCustCntCd());		
		this.hashColumns.put("ots_tp_cd", getOtsTpCd());		
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("clt_ofc_cd", getCltOfcCd());		
		this.hashColumns.put("bkg_io_bnd_cd", getBkgIoBndCd());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("ob_cr_term_dys", getObCrTermDys());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("cond_bkg_no", getCondBkgNo());		
		this.hashColumns.put("ib_cr_term_dys", getIbCrTermDys());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ship_cust_nm", getShipCustNm());		
		this.hashColumns.put("cr_amt", getCrAmt());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("ots_grp_tp_cd", getOtsGrpTpCd());		
		this.hashColumns.put("ots_src_cd", getOtsSrcCd());		
		this.hashColumns.put("due_dt", getDueDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("ots_rt_flg", getOtsRtFlg());		
		this.hashColumns.put("shp_to_cust_seq", getShpToCustSeq());		
		this.hashColumns.put("cust_num", getCustNum());		
		this.hashColumns.put("rhq_cd", getRhqCd());		
		this.hashColumns.put("trnk_vvd_cd", getTrnkVvdCd());		
		this.hashColumns.put("del_cd", getDelCd());		
		this.hashColumns.put("bil_to_cust_seq", getBilToCustSeq());		
		this.hashColumns.put("cr_curr_cd", getCrCurrCd());		
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ots_rmk", getOtsRmk());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("shp_to_cust_cnt_cd", getShpToCustCntCd());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("cust_srep_cd", getCustSrepCd());		
		this.hashColumns.put("ship_cust_num", getShipCustNum());		
		this.hashColumns.put("cond_bl_no", getCondBlNo());		
		this.hashColumns.put("over_due", getOverDue());		
		this.hashColumns.put("inv_curr_cd", getInvCurrCd());		
		this.hashColumns.put("ots_pay_cd", getOtsPayCd());		
		this.hashColumns.put("org_inv_no", getOrgInvNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("bil_to_cust_cnt_cd", "bilToCustCntCd");
		this.hashFields.put("ots_tp_cd", "otsTpCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("clt_ofc_cd", "cltOfcCd");
		this.hashFields.put("bkg_io_bnd_cd", "bkgIoBndCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("ob_cr_term_dys", "obCrTermDys");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cond_bkg_no", "condBkgNo");
		this.hashFields.put("ib_cr_term_dys", "ibCrTermDys");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ship_cust_nm", "shipCustNm");
		this.hashFields.put("cr_amt", "crAmt");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ots_grp_tp_cd", "otsGrpTpCd");
		this.hashFields.put("ots_src_cd", "otsSrcCd");
		this.hashFields.put("due_dt", "dueDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("ots_rt_flg", "otsRtFlg");
		this.hashFields.put("shp_to_cust_seq", "shpToCustSeq");
		this.hashFields.put("cust_num", "custNum");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("trnk_vvd_cd", "trnkVvdCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bil_to_cust_seq", "bilToCustSeq");
		this.hashFields.put("cr_curr_cd", "crCurrCd");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ots_rmk", "otsRmk");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("shp_to_cust_cnt_cd", "shpToCustCntCd");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("cust_srep_cd", "custSrepCd");
		this.hashFields.put("ship_cust_num", "shipCustNum");
		this.hashFields.put("cond_bl_no", "condBlNo");
		this.hashFields.put("over_due", "overDue");
		this.hashFields.put("inv_curr_cd", "invCurrCd");
		this.hashFields.put("ots_pay_cd", "otsPayCd");
		this.hashFields.put("org_inv_no", "orgInvNo");
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
	* @param  condBkgNo
	*/
	public void	setCondBkgNo( String	condBkgNo ) {
		this.condBkgNo =	condBkgNo;
	}
 
	/**
	 * Column Info
	 * @return	condBkgNo
	 */
	 public	 String	getCondBkgNo() {
		 return	this.condBkgNo;
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
	* @param  shipCustNm
	*/
	public void	setShipCustNm( String	shipCustNm ) {
		this.shipCustNm =	shipCustNm;
	}
 
	/**
	 * Column Info
	 * @return	shipCustNm
	 */
	 public	 String	getShipCustNm() {
		 return	this.shipCustNm;
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
	* @param  custNum
	*/
	public void	setCustNum( String	custNum ) {
		this.custNum =	custNum;
	}
 
	/**
	 * Column Info
	 * @return	custNum
	 */
	 public	 String	getCustNum() {
		 return	this.custNum;
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
	* @param  shipCustNum
	*/
	public void	setShipCustNum( String	shipCustNum ) {
		this.shipCustNum =	shipCustNum;
	}
 
	/**
	 * Column Info
	 * @return	shipCustNum
	 */
	 public	 String	getShipCustNum() {
		 return	this.shipCustNum;
	 } 
 	/**
	* Column Info
	* @param  condBlNo
	*/
	public void	setCondBlNo( String	condBlNo ) {
		this.condBlNo =	condBlNo;
	}
 
	/**
	 * Column Info
	 * @return	condBlNo
	 */
	 public	 String	getCondBlNo() {
		 return	this.condBlNo;
	 } 
 	/**
	* Column Info
	* @param  overDue
	*/
	public void	setOverDue( String	overDue ) {
		this.overDue =	overDue;
	}
 
	/**
	 * Column Info
	 * @return	overDue
	 */
	 public	 String	getOverDue() {
		 return	this.overDue;
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
	* @param  otsPayCd
	*/
	public void	setOtsPayCd( String	otsPayCd ) {
		this.otsPayCd =	otsPayCd;
	}
 
	/**
	 * Column Info
	 * @return	otsPayCd
	 */
	 public	 String	getOtsPayCd() {
		 return	this.otsPayCd;
	 } 
 	/**
	* Column Info
	* @param  orgInvNo
	*/
	public void	setOrgInvNo( String	orgInvNo ) {
		this.orgInvNo =	orgInvNo;
	}
 
	/**
	 * Column Info
	 * @return	orgInvNo
	 */
	 public	 String	getOrgInvNo() {
		 return	this.orgInvNo;
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
		setLaneCd(JSPUtil.getParameter(request,	prefix + "lane_cd", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setBilToCustCntCd(JSPUtil.getParameter(request,	prefix + "bil_to_cust_cnt_cd", ""));
		setOtsTpCd(JSPUtil.getParameter(request,	prefix + "ots_tp_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setCltOfcCd(JSPUtil.getParameter(request,	prefix + "clt_ofc_cd", ""));
		setBkgIoBndCd(JSPUtil.getParameter(request,	prefix + "bkg_io_bnd_cd", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setObCrTermDys(JSPUtil.getParameter(request,	prefix + "ob_cr_term_dys", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setCondBkgNo(JSPUtil.getParameter(request,	prefix + "cond_bkg_no", ""));
		setIbCrTermDys(JSPUtil.getParameter(request,	prefix + "ib_cr_term_dys", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setShipCustNm(JSPUtil.getParameter(request,	prefix + "ship_cust_nm", ""));
		setCrAmt(JSPUtil.getParameter(request,	prefix + "cr_amt", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setOtsGrpTpCd(JSPUtil.getParameter(request,	prefix + "ots_grp_tp_cd", ""));
		setOtsSrcCd(JSPUtil.getParameter(request,	prefix + "ots_src_cd", ""));
		setDueDt(JSPUtil.getParameter(request,	prefix + "due_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setOtsRtFlg(JSPUtil.getParameter(request,	prefix + "ots_rt_flg", ""));
		setShpToCustSeq(JSPUtil.getParameter(request,	prefix + "shp_to_cust_seq", ""));
		setCustNum(JSPUtil.getParameter(request,	prefix + "cust_num", ""));
		setRhqCd(JSPUtil.getParameter(request,	prefix + "rhq_cd", ""));
		setTrnkVvdCd(JSPUtil.getParameter(request,	prefix + "trnk_vvd_cd", ""));
		setDelCd(JSPUtil.getParameter(request,	prefix + "del_cd", ""));
		setBilToCustSeq(JSPUtil.getParameter(request,	prefix + "bil_to_cust_seq", ""));
		setCrCurrCd(JSPUtil.getParameter(request,	prefix + "cr_curr_cd", ""));
		setBkgRefNo(JSPUtil.getParameter(request,	prefix + "bkg_ref_no", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setOtsRmk(JSPUtil.getParameter(request,	prefix + "ots_rmk", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setShpToCustCntCd(JSPUtil.getParameter(request,	prefix + "shp_to_cust_cnt_cd", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setCustSrepCd(JSPUtil.getParameter(request,	prefix + "cust_srep_cd", ""));
		setShipCustNum(JSPUtil.getParameter(request,	prefix + "ship_cust_num", ""));
		setCondBlNo(JSPUtil.getParameter(request,	prefix + "cond_bl_no", ""));
		setOverDue(JSPUtil.getParameter(request,	prefix + "over_due", ""));
		setInvCurrCd(JSPUtil.getParameter(request,	prefix + "inv_curr_cd", ""));
		setOtsPayCd(JSPUtil.getParameter(request,	prefix + "ots_pay_cd", ""));
		setOrgInvNo(JSPUtil.getParameter(request,	prefix + "org_inv_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return OutstandingHdrByBlVO[]
	 */
	public OutstandingHdrByBlVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return OutstandingHdrByBlVO[]
	 */
	public OutstandingHdrByBlVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		OutstandingHdrByBlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] porCd =	(JSPUtil.getParameter(request, prefix +	"por_cd".trim(),	length));
				String[] laneCd =	(JSPUtil.getParameter(request, prefix +	"lane_cd".trim(),	length));
				String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm".trim(),	length));
				String[] bilToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_cnt_cd".trim(),	length));
				String[] otsTpCd =	(JSPUtil.getParameter(request, prefix +	"ots_tp_cd".trim(),	length));
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] cltOfcCd =	(JSPUtil.getParameter(request, prefix +	"clt_ofc_cd".trim(),	length));
				String[] bkgIoBndCd =	(JSPUtil.getParameter(request, prefix +	"bkg_io_bnd_cd".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] obCrTermDys =	(JSPUtil.getParameter(request, prefix +	"ob_cr_term_dys".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] condBkgNo =	(JSPUtil.getParameter(request, prefix +	"cond_bkg_no".trim(),	length));
				String[] ibCrTermDys =	(JSPUtil.getParameter(request, prefix +	"ib_cr_term_dys".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] shipCustNm =	(JSPUtil.getParameter(request, prefix +	"ship_cust_nm".trim(),	length));
				String[] crAmt =	(JSPUtil.getParameter(request, prefix +	"cr_amt".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] otsGrpTpCd =	(JSPUtil.getParameter(request, prefix +	"ots_grp_tp_cd".trim(),	length));
				String[] otsSrcCd =	(JSPUtil.getParameter(request, prefix +	"ots_src_cd".trim(),	length));
				String[] dueDt =	(JSPUtil.getParameter(request, prefix +	"due_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] otsRtFlg =	(JSPUtil.getParameter(request, prefix +	"ots_rt_flg".trim(),	length));
				String[] shpToCustSeq =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_seq".trim(),	length));
				String[] custNum =	(JSPUtil.getParameter(request, prefix +	"cust_num".trim(),	length));
				String[] rhqCd =	(JSPUtil.getParameter(request, prefix +	"rhq_cd".trim(),	length));
				String[] trnkVvdCd =	(JSPUtil.getParameter(request, prefix +	"trnk_vvd_cd".trim(),	length));
				String[] delCd =	(JSPUtil.getParameter(request, prefix +	"del_cd".trim(),	length));
				String[] bilToCustSeq =	(JSPUtil.getParameter(request, prefix +	"bil_to_cust_seq".trim(),	length));
				String[] crCurrCd =	(JSPUtil.getParameter(request, prefix +	"cr_curr_cd".trim(),	length));
				String[] bkgRefNo =	(JSPUtil.getParameter(request, prefix +	"bkg_ref_no".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] otsRmk =	(JSPUtil.getParameter(request, prefix +	"ots_rmk".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] shpToCustCntCd =	(JSPUtil.getParameter(request, prefix +	"shp_to_cust_cnt_cd".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] custSrepCd =	(JSPUtil.getParameter(request, prefix +	"cust_srep_cd".trim(),	length));
				String[] shipCustNum =	(JSPUtil.getParameter(request, prefix +	"ship_cust_num".trim(),	length));
				String[] condBlNo =	(JSPUtil.getParameter(request, prefix +	"cond_bl_no".trim(),	length));
				String[] overDue =	(JSPUtil.getParameter(request, prefix +	"over_due".trim(),	length));
				String[] invCurrCd =	(JSPUtil.getParameter(request, prefix +	"inv_curr_cd".trim(),	length));
				String[] otsPayCd =	(JSPUtil.getParameter(request, prefix +	"ots_pay_cd".trim(),	length));
				String[] orgInvNo =	(JSPUtil.getParameter(request, prefix +	"org_inv_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	OutstandingHdrByBlVO();
						if ( porCd[i] !=	null)
						model.setPorCd( porCd[i]);
						if ( laneCd[i] !=	null)
						model.setLaneCd( laneCd[i]);
						if ( custNm[i] !=	null)
						model.setCustNm( custNm[i]);
						if ( bilToCustCntCd[i] !=	null)
						model.setBilToCustCntCd( bilToCustCntCd[i]);
						if ( otsTpCd[i] !=	null)
						model.setOtsTpCd( otsTpCd[i]);
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( cltOfcCd[i] !=	null)
						model.setCltOfcCd( cltOfcCd[i]);
						if ( bkgIoBndCd[i] !=	null)
						model.setBkgIoBndCd( bkgIoBndCd[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( obCrTermDys[i] !=	null)
						model.setObCrTermDys( obCrTermDys[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( condBkgNo[i] !=	null)
						model.setCondBkgNo( condBkgNo[i]);
						if ( ibCrTermDys[i] !=	null)
						model.setIbCrTermDys( ibCrTermDys[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( shipCustNm[i] !=	null)
						model.setShipCustNm( shipCustNm[i]);
						if ( crAmt[i] !=	null)
						model.setCrAmt( crAmt[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( otsGrpTpCd[i] !=	null)
						model.setOtsGrpTpCd( otsGrpTpCd[i]);
						if ( otsSrcCd[i] !=	null)
						model.setOtsSrcCd( otsSrcCd[i]);
						if ( dueDt[i] !=	null)
						model.setDueDt( dueDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( otsRtFlg[i] !=	null)
						model.setOtsRtFlg( otsRtFlg[i]);
						if ( shpToCustSeq[i] !=	null)
						model.setShpToCustSeq( shpToCustSeq[i]);
						if ( custNum[i] !=	null)
						model.setCustNum( custNum[i]);
						if ( rhqCd[i] !=	null)
						model.setRhqCd( rhqCd[i]);
						if ( trnkVvdCd[i] !=	null)
						model.setTrnkVvdCd( trnkVvdCd[i]);
						if ( delCd[i] !=	null)
						model.setDelCd( delCd[i]);
						if ( bilToCustSeq[i] !=	null)
						model.setBilToCustSeq( bilToCustSeq[i]);
						if ( crCurrCd[i] !=	null)
						model.setCrCurrCd( crCurrCd[i]);
						if ( bkgRefNo[i] !=	null)
						model.setBkgRefNo( bkgRefNo[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( otsRmk[i] !=	null)
						model.setOtsRmk( otsRmk[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( shpToCustCntCd[i] !=	null)
						model.setShpToCustCntCd( shpToCustCntCd[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( custSrepCd[i] !=	null)
						model.setCustSrepCd( custSrepCd[i]);
						if ( shipCustNum[i] !=	null)
						model.setShipCustNum( shipCustNum[i]);
						if ( condBlNo[i] !=	null)
						model.setCondBlNo( condBlNo[i]);
						if ( overDue[i] !=	null)
						model.setOverDue( overDue[i]);
						if ( invCurrCd[i] !=	null)
						model.setInvCurrCd( invCurrCd[i]);
						if ( otsPayCd[i] !=	null)
						model.setOtsPayCd( otsPayCd[i]);
						if ( orgInvNo[i] !=	null)
						model.setOrgInvNo( orgInvNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getOutstandingHdrByBlVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return OutstandingHdrByBlVO[]
	 */
	public OutstandingHdrByBlVO[]	 getOutstandingHdrByBlVOs(){
		OutstandingHdrByBlVO[] vos = (OutstandingHdrByBlVO[])models.toArray(new	OutstandingHdrByBlVO[models.size()]);
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
		this.laneCd =	this.laneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustCntCd =	this.bilToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsTpCd =	this.otsTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltOfcCd =	this.cltOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgIoBndCd =	this.bkgIoBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCrTermDys =	this.obCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condBkgNo =	this.condBkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCrTermDys =	this.ibCrTermDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipCustNm =	this.shipCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crAmt =	this.crAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsGrpTpCd =	this.otsGrpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsSrcCd =	this.otsSrcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dueDt =	this.dueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRtFlg =	this.otsRtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustSeq =	this.shpToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNum =	this.custNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd =	this.rhqCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trnkVvdCd =	this.trnkVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd =	this.delCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bilToCustSeq =	this.bilToCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crCurrCd =	this.crCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo =	this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsRmk =	this.otsRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shpToCustCntCd =	this.shpToCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSrepCd =	this.custSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipCustNum =	this.shipCustNum.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condBlNo =	this.condBlNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overDue =	this.overDue.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCurrCd =	this.invCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsPayCd =	this.otsPayCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgInvNo =	this.orgInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}