/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SearchOwnerInvoiceListVO.java
 *@FileTitle : SearchOwnerInvoiceListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.06.01
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.06.01  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioinvoice.vo;

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
 * - 愿��젴	Event�뿉�꽌	�옉�꽦,	�꽌踰꾩떎�뻾�슂泥��떆	PDTO�쓽 �뿭�븷�쓣 �닔�뻾�븯�뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class SearchOwnerInvoiceListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SearchOwnerInvoiceListVO>  models =	new	ArrayList<SearchOwnerInvoiceListVO>();


	/*	Column Info	*/
	private  String	 n2ndCurrCd   =  null;
	/*	Column Info	*/
	private  String	 acctCd   =  null;
	/*	Column Info	*/
	private  String	 actXchRtAmt   =  null;
	/*	Column Info	*/
	private  String	 slpFuncCd   =  null;
	/*	Column Info	*/
	private  String	 apDesc4   =  null;
	/*	Column Info	*/
	private  String	 fletPpayRltCd   =  null;
	/*	Column Info	*/
	private  String	 apDesc1   =  null;
	/*	Column Info	*/
	private  String	 vvdCd1   =  null;
	/*	Column Info	*/
	private  String	 n1stAmt1   =  null;
	/*	Column Info	*/
	private  String	 apDesc   =  null;
	/*	Column Info	*/
	private  String	 manHrFlg   =  null;
	/*	Column Info	*/
	private  String	 orgSlpNo1   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 slpTeamCd   =  null;
	/*	Column Info	*/
	private  String	 apDesc2   =  null;
	/*	Column Info	*/
	private  String	 apDesc3   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 orgSlpNo   =  null;
	/*	Column Info	*/
	private  String	 skdDirCd   =  null;
	/*	Column Info	*/
	private  String	 aproFlg   =  null;
	/*	Column Info	*/
	private  String	 n2ndAmt   =  null;
	/*	Column Info	*/
	private  String	 n1stAmt   =  null;
	/*	Column Info	*/
	private  String	 slpIssDt   =  null;
	/*	Column Info	*/
	private  String	 slpTpCd   =  null;
	/*	Column Info	*/
	private  String	 apDesc5   =  null;
	/*	Column Info	*/
	private  String	 revDirCd   =  null;
	/*	Column Info	*/
	private  String	 ctrCd   =  null;
	/*	Column Info	*/
	private  String	 stlFlg1   =  null;
	/*	Column Info	*/
	private  String	 effDt   =  null;
	/*	Column Info	*/
	private  String	 slpSeqNo   =  null;
	/*	Column Info	*/
	private  String	 vvdCd   =  null;
	/*	Column Info	*/
	private  String	 skdVoyNo   =  null;
	/*	Column Info	*/
	private  String	 stlFlg   =  null;
	/*	Column Info	*/
	private  String	 slpSerNo   =  null;
	/*	Column Info	*/
	private  String	 n1stCurrCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 fletRctFlg   =  null;
	/*	Column Info	*/
	private  String	 slpNo   =  null;
	/*	Column Info	*/
	private  String	 cxlSlpNo   =  null;
	/*	Column Info	*/
	private  String	 stlDt   =  null;
	/*	Column Info	*/
	private  String	 orgSumAmt   =  null;
	/*	Column Info	*/
	private  String	 maxEffDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SearchOwnerInvoiceListVO(){}

	public SearchOwnerInvoiceListVO(String n2ndCurrCd,String acctCd,String actXchRtAmt,String slpFuncCd,String apDesc4,String fletPpayRltCd,String apDesc1,String vvdCd1,String n1stAmt1,String apDesc,String manHrFlg,String orgSlpNo1,String vslCd,String slpTeamCd,String apDesc2,String apDesc3,String ibflag,String orgSlpNo,String skdDirCd,String aproFlg,String n2ndAmt,String n1stAmt,String slpIssDt,String slpTpCd,String apDesc5,String revDirCd,String ctrCd,String stlFlg1,String effDt,String slpSeqNo,String vvdCd,String skdVoyNo,String stlFlg,String slpSerNo,String n1stCurrCd,String pagerows,String fletRctFlg,String slpNo,String cxlSlpNo,String stlDt,String orgSumAmt,String maxEffDt)	{
		this.n2ndCurrCd  = n2ndCurrCd ;
		this.acctCd  = acctCd ;
		this.actXchRtAmt  = actXchRtAmt ;
		this.slpFuncCd  = slpFuncCd ;
		this.apDesc4  = apDesc4 ;
		this.fletPpayRltCd  = fletPpayRltCd ;
		this.apDesc1  = apDesc1 ;
		this.vvdCd1  = vvdCd1 ;
		this.n1stAmt1  = n1stAmt1 ;
		this.apDesc  = apDesc ;
		this.manHrFlg  = manHrFlg ;
		this.orgSlpNo1  = orgSlpNo1 ;
		this.vslCd  = vslCd ;
		this.slpTeamCd  = slpTeamCd ;
		this.apDesc2  = apDesc2 ;
		this.apDesc3  = apDesc3 ;
		this.ibflag  = ibflag ;
		this.orgSlpNo  = orgSlpNo ;
		this.skdDirCd  = skdDirCd ;
		this.aproFlg  = aproFlg ;
		this.n2ndAmt  = n2ndAmt ;
		this.n1stAmt  = n1stAmt ;
		this.slpIssDt  = slpIssDt ;
		this.slpTpCd  = slpTpCd ;
		this.apDesc5  = apDesc5 ;
		this.revDirCd  = revDirCd ;
		this.ctrCd  = ctrCd ;
		this.stlFlg1  = stlFlg1 ;
		this.effDt  = effDt ;
		this.slpSeqNo  = slpSeqNo ;
		this.vvdCd  = vvdCd ;
		this.skdVoyNo  = skdVoyNo ;
		this.stlFlg  = stlFlg ;
		this.slpSerNo  = slpSerNo ;
		this.n1stCurrCd  = n1stCurrCd ;
		this.pagerows  = pagerows ;
		this.fletRctFlg  = fletRctFlg ;
		this.slpNo  = slpNo ;
		this.cxlSlpNo  = cxlSlpNo ;
		this.stlDt  = stlDt ;
		this.orgSumAmt  = orgSumAmt ;
		this.maxEffDt  = maxEffDt ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("n2nd_curr_cd", getN2ndCurrCd());		
		this.hashColumns.put("acct_cd", getAcctCd());		
		this.hashColumns.put("act_xch_rt_amt", getActXchRtAmt());		
		this.hashColumns.put("slp_func_cd", getSlpFuncCd());		
		this.hashColumns.put("ap_desc4", getApDesc4());		
		this.hashColumns.put("flet_ppay_rlt_cd", getFletPpayRltCd());		
		this.hashColumns.put("ap_desc1", getApDesc1());		
		this.hashColumns.put("vvd_cd1", getVvdCd1());		
		this.hashColumns.put("n1st_amt1", getN1stAmt1());		
		this.hashColumns.put("ap_desc", getApDesc());		
		this.hashColumns.put("man_hr_flg", getManHrFlg());		
		this.hashColumns.put("org_slp_no1", getOrgSlpNo1());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("slp_team_cd", getSlpTeamCd());		
		this.hashColumns.put("ap_desc2", getApDesc2());		
		this.hashColumns.put("ap_desc3", getApDesc3());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("org_slp_no", getOrgSlpNo());		
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());		
		this.hashColumns.put("apro_flg", getAproFlg());		
		this.hashColumns.put("n2nd_amt", getN2ndAmt());		
		this.hashColumns.put("n1st_amt", getN1stAmt());		
		this.hashColumns.put("slp_iss_dt", getSlpIssDt());		
		this.hashColumns.put("slp_tp_cd", getSlpTpCd());		
		this.hashColumns.put("ap_desc5", getApDesc5());		
		this.hashColumns.put("rev_dir_cd", getRevDirCd());		
		this.hashColumns.put("ctr_cd", getCtrCd());		
		this.hashColumns.put("stl_flg1", getStlFlg1());		
		this.hashColumns.put("eff_dt", getEffDt());		
		this.hashColumns.put("slp_seq_no", getSlpSeqNo());		
		this.hashColumns.put("vvd_cd", getVvdCd());		
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());		
		this.hashColumns.put("stl_flg", getStlFlg());		
		this.hashColumns.put("slp_ser_no", getSlpSerNo());		
		this.hashColumns.put("n1st_curr_cd", getN1stCurrCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("flet_rct_flg", getFletRctFlg());		
		this.hashColumns.put("slp_no", getSlpNo());		
		this.hashColumns.put("cxl_slp_no", getCxlSlpNo());		
		this.hashColumns.put("stl_dt", getStlDt());		
		this.hashColumns.put("org_sum_amt", getOrgSumAmt());		
		this.hashColumns.put("max_eff_dt", getMaxEffDt());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("n2nd_curr_cd", "n2ndCurrCd");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("act_xch_rt_amt", "actXchRtAmt");
		this.hashFields.put("slp_func_cd", "slpFuncCd");
		this.hashFields.put("ap_desc4", "apDesc4");
		this.hashFields.put("flet_ppay_rlt_cd", "fletPpayRltCd");
		this.hashFields.put("ap_desc1", "apDesc1");
		this.hashFields.put("vvd_cd1", "vvdCd1");
		this.hashFields.put("n1st_amt1", "n1stAmt1");
		this.hashFields.put("ap_desc", "apDesc");
		this.hashFields.put("man_hr_flg", "manHrFlg");
		this.hashFields.put("org_slp_no1", "orgSlpNo1");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("slp_team_cd", "slpTeamCd");
		this.hashFields.put("ap_desc2", "apDesc2");
		this.hashFields.put("ap_desc3", "apDesc3");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("org_slp_no", "orgSlpNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("apro_flg", "aproFlg");
		this.hashFields.put("n2nd_amt", "n2ndAmt");
		this.hashFields.put("n1st_amt", "n1stAmt");
		this.hashFields.put("slp_iss_dt", "slpIssDt");
		this.hashFields.put("slp_tp_cd", "slpTpCd");
		this.hashFields.put("ap_desc5", "apDesc5");
		this.hashFields.put("rev_dir_cd", "revDirCd");
		this.hashFields.put("ctr_cd", "ctrCd");
		this.hashFields.put("stl_flg1", "stlFlg1");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("slp_seq_no", "slpSeqNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("stl_flg", "stlFlg");
		this.hashFields.put("slp_ser_no", "slpSerNo");
		this.hashFields.put("n1st_curr_cd", "n1stCurrCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_rct_flg", "fletRctFlg");
		this.hashFields.put("slp_no", "slpNo");
		this.hashFields.put("cxl_slp_no", "cxlSlpNo");
		this.hashFields.put("stl_dt", "stlDt");
		this.hashFields.put("org_sum_amt", "orgSumAmt");
		this.hashFields.put("max_eff_dt", "maxEffDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  n2ndCurrCd
	*/
	public void	setN2ndCurrCd( String	n2ndCurrCd ) {
		this.n2ndCurrCd =	n2ndCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	n2ndCurrCd
	 */
	 public	 String	getN2ndCurrCd() {
		 return	this.n2ndCurrCd;
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
	* @param  actXchRtAmt
	*/
	public void	setActXchRtAmt( String	actXchRtAmt ) {
		this.actXchRtAmt =	actXchRtAmt;
	}
 
	/**
	 * Column Info
	 * @return	actXchRtAmt
	 */
	 public	 String	getActXchRtAmt() {
		 return	this.actXchRtAmt;
	 } 
 	/**
	* Column Info
	* @param  slpFuncCd
	*/
	public void	setSlpFuncCd( String	slpFuncCd ) {
		this.slpFuncCd =	slpFuncCd;
	}
 
	/**
	 * Column Info
	 * @return	slpFuncCd
	 */
	 public	 String	getSlpFuncCd() {
		 return	this.slpFuncCd;
	 } 
 	/**
	* Column Info
	* @param  apDesc4
	*/
	public void	setApDesc4( String	apDesc4 ) {
		this.apDesc4 =	apDesc4;
	}
 
	/**
	 * Column Info
	 * @return	apDesc4
	 */
	 public	 String	getApDesc4() {
		 return	this.apDesc4;
	 } 
 	/**
	* Column Info
	* @param  fletPpayRltCd
	*/
	public void	setFletPpayRltCd( String	fletPpayRltCd ) {
		this.fletPpayRltCd =	fletPpayRltCd;
	}
 
	/**
	 * Column Info
	 * @return	fletPpayRltCd
	 */
	 public	 String	getFletPpayRltCd() {
		 return	this.fletPpayRltCd;
	 } 
 	/**
	* Column Info
	* @param  apDesc1
	*/
	public void	setApDesc1( String	apDesc1 ) {
		this.apDesc1 =	apDesc1;
	}
 
	/**
	 * Column Info
	 * @return	apDesc1
	 */
	 public	 String	getApDesc1() {
		 return	this.apDesc1;
	 } 
 	/**
	* Column Info
	* @param  vvdCd1
	*/
	public void	setVvdCd1( String	vvdCd1 ) {
		this.vvdCd1 =	vvdCd1;
	}
 
	/**
	 * Column Info
	 * @return	vvdCd1
	 */
	 public	 String	getVvdCd1() {
		 return	this.vvdCd1;
	 } 
 	/**
	* Column Info
	* @param  n1stAmt1
	*/
	public void	setN1stAmt1( String	n1stAmt1 ) {
		this.n1stAmt1 =	n1stAmt1;
	}
 
	/**
	 * Column Info
	 * @return	n1stAmt1
	 */
	 public	 String	getN1stAmt1() {
		 return	this.n1stAmt1;
	 } 
 	/**
	* Column Info
	* @param  apDesc
	*/
	public void	setApDesc( String	apDesc ) {
		this.apDesc =	apDesc;
	}
 
	/**
	 * Column Info
	 * @return	apDesc
	 */
	 public	 String	getApDesc() {
		 return	this.apDesc;
	 } 
 	/**
	* Column Info
	* @param  manHrFlg
	*/
	public void	setManHrFlg( String	manHrFlg ) {
		this.manHrFlg =	manHrFlg;
	}
 
	/**
	 * Column Info
	 * @return	manHrFlg
	 */
	 public	 String	getManHrFlg() {
		 return	this.manHrFlg;
	 } 
 	/**
	* Column Info
	* @param  orgSlpNo1
	*/
	public void	setOrgSlpNo1( String	orgSlpNo1 ) {
		this.orgSlpNo1 =	orgSlpNo1;
	}
 
	/**
	 * Column Info
	 * @return	orgSlpNo1
	 */
	 public	 String	getOrgSlpNo1() {
		 return	this.orgSlpNo1;
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
	* @param  slpTeamCd
	*/
	public void	setSlpTeamCd( String	slpTeamCd ) {
		this.slpTeamCd =	slpTeamCd;
	}
 
	/**
	 * Column Info
	 * @return	slpTeamCd
	 */
	 public	 String	getSlpTeamCd() {
		 return	this.slpTeamCd;
	 } 
 	/**
	* Column Info
	* @param  apDesc2
	*/
	public void	setApDesc2( String	apDesc2 ) {
		this.apDesc2 =	apDesc2;
	}
 
	/**
	 * Column Info
	 * @return	apDesc2
	 */
	 public	 String	getApDesc2() {
		 return	this.apDesc2;
	 } 
 	/**
	* Column Info
	* @param  apDesc3
	*/
	public void	setApDesc3( String	apDesc3 ) {
		this.apDesc3 =	apDesc3;
	}
 
	/**
	 * Column Info
	 * @return	apDesc3
	 */
	 public	 String	getApDesc3() {
		 return	this.apDesc3;
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
	* @param  orgSlpNo
	*/
	public void	setOrgSlpNo( String	orgSlpNo ) {
		this.orgSlpNo =	orgSlpNo;
	}
 
	/**
	 * Column Info
	 * @return	orgSlpNo
	 */
	 public	 String	getOrgSlpNo() {
		 return	this.orgSlpNo;
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
	* @param  aproFlg
	*/
	public void	setAproFlg( String	aproFlg ) {
		this.aproFlg =	aproFlg;
	}
 
	/**
	 * Column Info
	 * @return	aproFlg
	 */
	 public	 String	getAproFlg() {
		 return	this.aproFlg;
	 } 
 	/**
	* Column Info
	* @param  n2ndAmt
	*/
	public void	setN2ndAmt( String	n2ndAmt ) {
		this.n2ndAmt =	n2ndAmt;
	}
 
	/**
	 * Column Info
	 * @return	n2ndAmt
	 */
	 public	 String	getN2ndAmt() {
		 return	this.n2ndAmt;
	 } 
 	/**
	* Column Info
	* @param  n1stAmt
	*/
	public void	setN1stAmt( String	n1stAmt ) {
		this.n1stAmt =	n1stAmt;
	}
 
	/**
	 * Column Info
	 * @return	n1stAmt
	 */
	 public	 String	getN1stAmt() {
		 return	this.n1stAmt;
	 } 
 	/**
	* Column Info
	* @param  slpIssDt
	*/
	public void	setSlpIssDt( String	slpIssDt ) {
		this.slpIssDt =	slpIssDt;
	}
 
	/**
	 * Column Info
	 * @return	slpIssDt
	 */
	 public	 String	getSlpIssDt() {
		 return	this.slpIssDt;
	 } 
 	/**
	* Column Info
	* @param  slpTpCd
	*/
	public void	setSlpTpCd( String	slpTpCd ) {
		this.slpTpCd =	slpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	slpTpCd
	 */
	 public	 String	getSlpTpCd() {
		 return	this.slpTpCd;
	 } 
 	/**
	* Column Info
	* @param  apDesc5
	*/
	public void	setApDesc5( String	apDesc5 ) {
		this.apDesc5 =	apDesc5;
	}
 
	/**
	 * Column Info
	 * @return	apDesc5
	 */
	 public	 String	getApDesc5() {
		 return	this.apDesc5;
	 } 
 	/**
	* Column Info
	* @param  revDirCd
	*/
	public void	setRevDirCd( String	revDirCd ) {
		this.revDirCd =	revDirCd;
	}
 
	/**
	 * Column Info
	 * @return	revDirCd
	 */
	 public	 String	getRevDirCd() {
		 return	this.revDirCd;
	 } 
 	/**
	* Column Info
	* @param  ctrCd
	*/
	public void	setCtrCd( String	ctrCd ) {
		this.ctrCd =	ctrCd;
	}
 
	/**
	 * Column Info
	 * @return	ctrCd
	 */
	 public	 String	getCtrCd() {
		 return	this.ctrCd;
	 } 
 	/**
	* Column Info
	* @param  stlFlg1
	*/
	public void	setStlFlg1( String	stlFlg1 ) {
		this.stlFlg1 =	stlFlg1;
	}
 
	/**
	 * Column Info
	 * @return	stlFlg1
	 */
	 public	 String	getStlFlg1() {
		 return	this.stlFlg1;
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
	* @param  slpSeqNo
	*/
	public void	setSlpSeqNo( String	slpSeqNo ) {
		this.slpSeqNo =	slpSeqNo;
	}
 
	/**
	 * Column Info
	 * @return	slpSeqNo
	 */
	 public	 String	getSlpSeqNo() {
		 return	this.slpSeqNo;
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
	* @param  slpSerNo
	*/
	public void	setSlpSerNo( String	slpSerNo ) {
		this.slpSerNo =	slpSerNo;
	}
 
	/**
	 * Column Info
	 * @return	slpSerNo
	 */
	 public	 String	getSlpSerNo() {
		 return	this.slpSerNo;
	 } 
 	/**
	* Column Info
	* @param  n1stCurrCd
	*/
	public void	setN1stCurrCd( String	n1stCurrCd ) {
		this.n1stCurrCd =	n1stCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	n1stCurrCd
	 */
	 public	 String	getN1stCurrCd() {
		 return	this.n1stCurrCd;
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
	* @param  fletRctFlg
	*/
	public void	setFletRctFlg( String	fletRctFlg ) {
		this.fletRctFlg =	fletRctFlg;
	}
 
	/**
	 * Column Info
	 * @return	fletRctFlg
	 */
	 public	 String	getFletRctFlg() {
		 return	this.fletRctFlg;
	 } 
 	/**
	* Column Info
	* @param  slpNo
	*/
	public void	setSlpNo( String	slpNo ) {
		this.slpNo =	slpNo;
	}
 
	/**
	 * Column Info
	 * @return	slpNo
	 */
	 public	 String	getSlpNo() {
		 return	this.slpNo;
	 } 
 	/**
	* Column Info
	* @param  cxlSlpNo
	*/
	public void	setCxlSlpNo( String	cxlSlpNo ) {
		this.cxlSlpNo =	cxlSlpNo;
	}
 
	/**
	 * Column Info
	 * @return	cxlSlpNo
	 */
	 public	 String	getCxlSlpNo() {
		 return	this.cxlSlpNo;
	 } 
 	/**
	* Column Info
	* @param  stlDt
	*/
	public void	setStlDt( String	stlDt ) {
		this.stlDt =	stlDt;
	}
 
	/**
	 * Column Info
	 * @return	stlDt
	 */
	 public	 String	getStlDt() {
		 return	this.stlDt;
	 } 
 	/**
	* Column Info
	* @param  orgSumAmt
	*/
	public void	setOrgSumAmt( String	orgSumAmt ) {
		this.orgSumAmt =	orgSumAmt;
	}
 
	/**
	 * Column Info
	 * @return	orgSumAmt
	 */
	 public	 String	getOrgSumAmt() {
		 return	this.orgSumAmt;
	 } 
 	/**
	* Column Info
	* @param  maxEffDt
	*/
	public void	setMaxEffDt( String	maxEffDt ) {
		this.maxEffDt =	maxEffDt;
	}
 
	/**
	 * Column Info
	 * @return	maxEffDt
	 */
	 public	 String	getMaxEffDt() {
		 return	this.maxEffDt;
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
		setN2ndCurrCd(JSPUtil.getParameter(request,	prefix + "n2nd_curr_cd", ""));
		setAcctCd(JSPUtil.getParameter(request,	prefix + "acct_cd", ""));
		setActXchRtAmt(JSPUtil.getParameter(request,	prefix + "act_xch_rt_amt", ""));
		setSlpFuncCd(JSPUtil.getParameter(request,	prefix + "slp_func_cd", ""));
		setApDesc4(JSPUtil.getParameter(request,	prefix + "ap_desc4", ""));
		setFletPpayRltCd(JSPUtil.getParameter(request,	prefix + "flet_ppay_rlt_cd", ""));
		setApDesc1(JSPUtil.getParameter(request,	prefix + "ap_desc1", ""));
		setVvdCd1(JSPUtil.getParameter(request,	prefix + "vvd_cd1", ""));
		setN1stAmt1(JSPUtil.getParameter(request,	prefix + "n1st_amt1", ""));
		setApDesc(JSPUtil.getParameter(request,	prefix + "ap_desc", ""));
		setManHrFlg(JSPUtil.getParameter(request,	prefix + "man_hr_flg", ""));
		setOrgSlpNo1(JSPUtil.getParameter(request,	prefix + "org_slp_no1", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSlpTeamCd(JSPUtil.getParameter(request,	prefix + "slp_team_cd", ""));
		setApDesc2(JSPUtil.getParameter(request,	prefix + "ap_desc2", ""));
		setApDesc3(JSPUtil.getParameter(request,	prefix + "ap_desc3", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setOrgSlpNo(JSPUtil.getParameter(request,	prefix + "org_slp_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setAproFlg(JSPUtil.getParameter(request,	prefix + "apro_flg", ""));
		setN2ndAmt(JSPUtil.getParameter(request,	prefix + "n2nd_amt", ""));
		setN1stAmt(JSPUtil.getParameter(request,	prefix + "n1st_amt", ""));
		setSlpIssDt(JSPUtil.getParameter(request,	prefix + "slp_iss_dt", ""));
		setSlpTpCd(JSPUtil.getParameter(request,	prefix + "slp_tp_cd", ""));
		setApDesc5(JSPUtil.getParameter(request,	prefix + "ap_desc5", ""));
		setRevDirCd(JSPUtil.getParameter(request,	prefix + "rev_dir_cd", ""));
		setCtrCd(JSPUtil.getParameter(request,	prefix + "ctr_cd", ""));
		setStlFlg1(JSPUtil.getParameter(request,	prefix + "stl_flg1", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setSlpSeqNo(JSPUtil.getParameter(request,	prefix + "slp_seq_no", ""));
		setVvdCd(JSPUtil.getParameter(request,	prefix + "vvd_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setStlFlg(JSPUtil.getParameter(request,	prefix + "stl_flg", ""));
		setSlpSerNo(JSPUtil.getParameter(request,	prefix + "slp_ser_no", ""));
		setN1stCurrCd(JSPUtil.getParameter(request,	prefix + "n1st_curr_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setFletRctFlg(JSPUtil.getParameter(request,	prefix + "flet_rct_flg", ""));
		setSlpNo(JSPUtil.getParameter(request,	prefix + "slp_no", ""));
		setCxlSlpNo(JSPUtil.getParameter(request,	prefix + "cxl_slp_no", ""));
		setStlDt(JSPUtil.getParameter(request,	prefix + "stl_dt", ""));
		setOrgSumAmt(JSPUtil.getParameter(request,	prefix + "org_sum_amt", ""));
		setMaxEffDt(JSPUtil.getParameter(request,	prefix + "max_eff_dt", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return SearchOwnerInvoiceListVO[]
	 */
	public SearchOwnerInvoiceListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return SearchOwnerInvoiceListVO[]
	 */
	public SearchOwnerInvoiceListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SearchOwnerInvoiceListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] n2ndCurrCd =	(JSPUtil.getParameter(request, prefix +	"n2nd_curr_cd".trim(),	length));
				String[] acctCd =	(JSPUtil.getParameter(request, prefix +	"acct_cd".trim(),	length));
				String[] actXchRtAmt =	(JSPUtil.getParameter(request, prefix +	"act_xch_rt_amt".trim(),	length));
				String[] slpFuncCd =	(JSPUtil.getParameter(request, prefix +	"slp_func_cd".trim(),	length));
				String[] apDesc4 =	(JSPUtil.getParameter(request, prefix +	"ap_desc4".trim(),	length));
				String[] fletPpayRltCd =	(JSPUtil.getParameter(request, prefix +	"flet_ppay_rlt_cd".trim(),	length));
				String[] apDesc1 =	(JSPUtil.getParameter(request, prefix +	"ap_desc1".trim(),	length));
				String[] vvdCd1 =	(JSPUtil.getParameter(request, prefix +	"vvd_cd1".trim(),	length));
				String[] n1stAmt1 =	(JSPUtil.getParameter(request, prefix +	"n1st_amt1".trim(),	length));
				String[] apDesc =	(JSPUtil.getParameter(request, prefix +	"ap_desc".trim(),	length));
				String[] manHrFlg =	(JSPUtil.getParameter(request, prefix +	"man_hr_flg".trim(),	length));
				String[] orgSlpNo1 =	(JSPUtil.getParameter(request, prefix +	"org_slp_no1".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] slpTeamCd =	(JSPUtil.getParameter(request, prefix +	"slp_team_cd".trim(),	length));
				String[] apDesc2 =	(JSPUtil.getParameter(request, prefix +	"ap_desc2".trim(),	length));
				String[] apDesc3 =	(JSPUtil.getParameter(request, prefix +	"ap_desc3".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] orgSlpNo =	(JSPUtil.getParameter(request, prefix +	"org_slp_no".trim(),	length));
				String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd".trim(),	length));
				String[] aproFlg =	(JSPUtil.getParameter(request, prefix +	"apro_flg".trim(),	length));
				String[] n2ndAmt =	(JSPUtil.getParameter(request, prefix +	"n2nd_amt".trim(),	length));
				String[] n1stAmt =	(JSPUtil.getParameter(request, prefix +	"n1st_amt".trim(),	length));
				String[] slpIssDt =	(JSPUtil.getParameter(request, prefix +	"slp_iss_dt".trim(),	length));
				String[] slpTpCd =	(JSPUtil.getParameter(request, prefix +	"slp_tp_cd".trim(),	length));
				String[] apDesc5 =	(JSPUtil.getParameter(request, prefix +	"ap_desc5".trim(),	length));
				String[] revDirCd =	(JSPUtil.getParameter(request, prefix +	"rev_dir_cd".trim(),	length));
				String[] ctrCd =	(JSPUtil.getParameter(request, prefix +	"ctr_cd".trim(),	length));
				String[] stlFlg1 =	(JSPUtil.getParameter(request, prefix +	"stl_flg1".trim(),	length));
				String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt".trim(),	length));
				String[] slpSeqNo =	(JSPUtil.getParameter(request, prefix +	"slp_seq_no".trim(),	length));
				String[] vvdCd =	(JSPUtil.getParameter(request, prefix +	"vvd_cd".trim(),	length));
				String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no".trim(),	length));
				String[] stlFlg =	(JSPUtil.getParameter(request, prefix +	"stl_flg".trim(),	length));
				String[] slpSerNo =	(JSPUtil.getParameter(request, prefix +	"slp_ser_no".trim(),	length));
				String[] n1stCurrCd =	(JSPUtil.getParameter(request, prefix +	"n1st_curr_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] fletRctFlg =	(JSPUtil.getParameter(request, prefix +	"flet_rct_flg".trim(),	length));
				String[] slpNo =	(JSPUtil.getParameter(request, prefix +	"slp_no".trim(),	length));
				String[] cxlSlpNo =	(JSPUtil.getParameter(request, prefix +	"cxl_slp_no".trim(),	length));
				String[] stlDt =	(JSPUtil.getParameter(request, prefix +	"stl_dt".trim(),	length));
				String[] orgSumAmt =	(JSPUtil.getParameter(request, prefix +	"org_sum_amt".trim(),	length));
				String[] maxEffDt =	(JSPUtil.getParameter(request, prefix +	"max_eff_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SearchOwnerInvoiceListVO();
						if ( n2ndCurrCd[i] !=	null)
						model.setN2ndCurrCd( n2ndCurrCd[i]);
						if ( acctCd[i] !=	null)
						model.setAcctCd( acctCd[i]);
						if ( actXchRtAmt[i] !=	null)
						model.setActXchRtAmt( actXchRtAmt[i]);
						if ( slpFuncCd[i] !=	null)
						model.setSlpFuncCd( slpFuncCd[i]);
						if ( apDesc4[i] !=	null)
						model.setApDesc4( apDesc4[i]);
						if ( fletPpayRltCd[i] !=	null)
						model.setFletPpayRltCd( fletPpayRltCd[i]);
						if ( apDesc1[i] !=	null)
						model.setApDesc1( apDesc1[i]);
						if ( vvdCd1[i] !=	null)
						model.setVvdCd1( vvdCd1[i]);
						if ( n1stAmt1[i] !=	null)
						model.setN1stAmt1( n1stAmt1[i]);
						if ( apDesc[i] !=	null)
						model.setApDesc( apDesc[i]);
						if ( manHrFlg[i] !=	null)
						model.setManHrFlg( manHrFlg[i]);
						if ( orgSlpNo1[i] !=	null)
						model.setOrgSlpNo1( orgSlpNo1[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( slpTeamCd[i] !=	null)
						model.setSlpTeamCd( slpTeamCd[i]);
						if ( apDesc2[i] !=	null)
						model.setApDesc2( apDesc2[i]);
						if ( apDesc3[i] !=	null)
						model.setApDesc3( apDesc3[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( orgSlpNo[i] !=	null)
						model.setOrgSlpNo( orgSlpNo[i]);
						if ( skdDirCd[i] !=	null)
						model.setSkdDirCd( skdDirCd[i]);
						if ( aproFlg[i] !=	null)
						model.setAproFlg( aproFlg[i]);
						if ( n2ndAmt[i] !=	null)
						model.setN2ndAmt( n2ndAmt[i]);
						if ( n1stAmt[i] !=	null)
						model.setN1stAmt( n1stAmt[i]);
						if ( slpIssDt[i] !=	null)
						model.setSlpIssDt( slpIssDt[i]);
						if ( slpTpCd[i] !=	null)
						model.setSlpTpCd( slpTpCd[i]);
						if ( apDesc5[i] !=	null)
						model.setApDesc5( apDesc5[i]);
						if ( revDirCd[i] !=	null)
						model.setRevDirCd( revDirCd[i]);
						if ( ctrCd[i] !=	null)
						model.setCtrCd( ctrCd[i]);
						if ( stlFlg1[i] !=	null)
						model.setStlFlg1( stlFlg1[i]);
						if ( effDt[i] !=	null)
						model.setEffDt( effDt[i]);
						if ( slpSeqNo[i] !=	null)
						model.setSlpSeqNo( slpSeqNo[i]);
						if ( vvdCd[i] !=	null)
						model.setVvdCd( vvdCd[i]);
						if ( skdVoyNo[i] !=	null)
						model.setSkdVoyNo( skdVoyNo[i]);
						if ( stlFlg[i] !=	null)
						model.setStlFlg( stlFlg[i]);
						if ( slpSerNo[i] !=	null)
						model.setSlpSerNo( slpSerNo[i]);
						if ( n1stCurrCd[i] !=	null)
						model.setN1stCurrCd( n1stCurrCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( fletRctFlg[i] !=	null)
						model.setFletRctFlg( fletRctFlg[i]);
						if ( slpNo[i] !=	null)
						model.setSlpNo( slpNo[i]);
						if ( cxlSlpNo[i] !=	null)
						model.setCxlSlpNo( cxlSlpNo[i]);
						if ( stlDt[i] !=	null)
						model.setStlDt( stlDt[i]);
						if ( orgSumAmt[i] !=	null)
						model.setOrgSumAmt( orgSumAmt[i]);
						if ( maxEffDt[i] !=	null)
						model.setMaxEffDt( maxEffDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSearchOwnerInvoiceListVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return SearchOwnerInvoiceListVO[]
	 */
	public SearchOwnerInvoiceListVO[]	 getSearchOwnerInvoiceListVOs(){
		SearchOwnerInvoiceListVO[] vos = (SearchOwnerInvoiceListVO[])models.toArray(new	SearchOwnerInvoiceListVO[models.size()]);
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
		this.n2ndCurrCd =	this.n2ndCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd =	this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actXchRtAmt =	this.actXchRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpFuncCd =	this.slpFuncCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc4 =	this.apDesc4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletPpayRltCd =	this.fletPpayRltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc1 =	this.apDesc1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd1 =	this.vvdCd1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAmt1 =	this.n1stAmt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc =	this.apDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.manHrFlg =	this.manHrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpNo1 =	this.orgSlpNo1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTeamCd =	this.slpTeamCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc2 =	this.apDesc2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc3 =	this.apDesc3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSlpNo =	this.orgSlpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproFlg =	this.aproFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndAmt =	this.n2ndAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stAmt =	this.n1stAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpIssDt =	this.slpIssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpTpCd =	this.slpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apDesc5 =	this.apDesc5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revDirCd =	this.revDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrCd =	this.ctrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg1 =	this.stlFlg1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSeqNo =	this.slpSeqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd =	this.vvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlFlg =	this.stlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpSerNo =	this.slpSerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCurrCd =	this.n1stCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletRctFlg =	this.fletRctFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slpNo =	this.slpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlSlpNo =	this.cxlSlpNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stlDt =	this.stlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgSumAmt =	this.orgSumAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxEffDt =	this.maxEffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}