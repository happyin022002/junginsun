/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ReceiptListByDetailVO.java
 *@FileTitle : ReceiptListByDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.11.13  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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
public class ReceiptListByDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ReceiptListByDetailVO>  models =	new	ArrayList<ReceiptListByDetailVO>();


	/*	Column Info	*/
	private  String	 svcScpCd   =  null;
	/*	Column Info	*/
	private  String	 otsCustNm   =  null;
	/*	Column Info	*/
	private  String	 sailArrDt   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 rctCxlRsnCd   =  null;
	/*	Column Info	*/
	private  String	 rctAplyChgCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 polCd   =  null;
	/*	Column Info	*/
	private  String	 rctCustCntCd   =  null;
	/*	Column Info	*/
	private  String	 rctAplySrcCurrCd   =  null;
	/*	Column Info	*/
	private  String	 wrtfCd   =  null;
	/*	Column Info	*/
	private  String	 rctDpsDt   =  null;
	/*	Column Info	*/
	private  String	 rvsFlg   =  null;
	/*	Column Info	*/
	private  String	 rctCxlRmk   =  null;
	/*	Column Info	*/
	private  String	 invDt   =  null;
	/*	Column Info	*/
	private  String	 bankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 rctAmt   =  null;
	/*	Column Info	*/
	private  String	 loclVvdCd   =  null;
	/*	Column Info	*/
	private  String	 otsAplyAmt   =  null;
	/*	Column Info	*/
	private  String	 rctCustNm   =  null;
	/*	Column Info	*/
	private  String	 rctCxlDt   =  null;
	/*	Column Info	*/
	private  String	 usrOfc   =  null;
	/*	Column Info	*/
	private  String	 rctAplyXchRt   =  null;
	/*	Column Info	*/
	private  String	 podCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 otsOfcCd   =  null;
	/*	Column Info	*/
	private  String	 unappFlg   =  null;
	/*	Column Info	*/
	private  String	 cCustCd   =  null;
	/*	Column Info	*/
	private  String	 asaNo   =  null;
	/*	Column Info	*/
	private  String	 cxlUsrId   =  null;
	/*	Column Info	*/
	private  String	 bankChgAmt   =  null;
	/*	Column Info	*/
	private  String	 rctNo   =  null;
	/*	Column Info	*/
	private  String	 laneCd   =  null;
	/*	Column Info	*/
	private  String	 rctOfcCd   =  null;
	/*	Column Info	*/
	private  String	 cCustNm   =  null;
	/*	Column Info	*/
	private  String	 rctAplyTgtCurrCd   =  null;
	/*	Column Info	*/
	private  String	 cxlRsnFlg   =  null;
	/*	Column Info	*/
	private  String	 otsBalAmt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 rctCurrCd   =  null;
	/*	Column Info	*/
	private  String	 rctAplyAmt   =  null;
	/*	Column Info	*/
	private  String	 usrNm   =  null;
	/*	Column Info	*/
	private  String	 rctCustCd   =  null;
	/*	Column Info	*/
	private  String	 rctSeq   =  null;
	/*	Column Info	*/
	private  String	 sCustCd   =  null;
	/*	Column Info	*/
	private  String	 otsCustCd   =  null;
	/*	Column Info	*/
	private  String	 bankAcctNm   =  null;
	/*	Column Info	*/
	private  String	 sCustNm   =  null;
	/*	Column Info	*/
	private  String	 chqNo   =  null;
	/*	Column Info	*/
	private  String	 vslNm   =  null;
	/*	Column Info	*/
	private  String	 cltTerm   =  null;
	/*	Column Info	*/
	private  String	 ioBndCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 rctCustSeq   =  null;
	/*	Column Info	*/
	private  String	 rctTpCd   =  null;
	/*	Column Info	*/
	private  String	 rctDt   =  null;
	/*	Column Info	*/
	private  String	 totalCnt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ReceiptListByDetailVO(){}

	public ReceiptListByDetailVO(String svcScpCd,String otsCustNm,String sailArrDt,String blNo,String rctCxlRsnCd,String rctAplyChgCd,String pagerows,String polCd,String rctCustCntCd,String rctAplySrcCurrCd,String wrtfCd,String rctDpsDt,String rvsFlg,String rctCxlRmk,String invDt,String bankAcctSeq,String rctAmt,String loclVvdCd,String otsAplyAmt,String rctCustNm,String rctCxlDt,String usrOfc,String rctAplyXchRt,String podCd,String creUsrId,String bkgNo,String otsOfcCd,String unappFlg,String cCustCd,String asaNo,String cxlUsrId,String bankChgAmt,String rctNo,String laneCd,String rctOfcCd,String cCustNm,String rctAplyTgtCurrCd,String cxlRsnFlg,String otsBalAmt,String ibflag,String rctCurrCd,String rctAplyAmt,String usrNm,String rctCustCd,String rctSeq,String sCustCd,String otsCustCd,String bankAcctNm,String sCustNm,String chqNo,String vslNm,String cltTerm,String ioBndCd,String invNo,String rctCustSeq,String rctTpCd,String rctDt,String totalCnt)	{
		this.svcScpCd  = svcScpCd ;
		this.otsCustNm  = otsCustNm ;
		this.sailArrDt  = sailArrDt ;
		this.blNo  = blNo ;
		this.rctCxlRsnCd  = rctCxlRsnCd ;
		this.rctAplyChgCd  = rctAplyChgCd ;
		this.pagerows  = pagerows ;
		this.polCd  = polCd ;
		this.rctCustCntCd  = rctCustCntCd ;
		this.rctAplySrcCurrCd  = rctAplySrcCurrCd ;
		this.wrtfCd  = wrtfCd ;
		this.rctDpsDt  = rctDpsDt ;
		this.rvsFlg  = rvsFlg ;
		this.rctCxlRmk  = rctCxlRmk ;
		this.invDt  = invDt ;
		this.bankAcctSeq  = bankAcctSeq ;
		this.rctAmt  = rctAmt ;
		this.loclVvdCd  = loclVvdCd ;
		this.otsAplyAmt  = otsAplyAmt ;
		this.rctCustNm  = rctCustNm ;
		this.rctCxlDt  = rctCxlDt ;
		this.usrOfc  = usrOfc ;
		this.rctAplyXchRt  = rctAplyXchRt ;
		this.podCd  = podCd ;
		this.creUsrId  = creUsrId ;
		this.bkgNo  = bkgNo ;
		this.otsOfcCd  = otsOfcCd ;
		this.unappFlg  = unappFlg ;
		this.cCustCd  = cCustCd ;
		this.asaNo  = asaNo ;
		this.cxlUsrId  = cxlUsrId ;
		this.bankChgAmt  = bankChgAmt ;
		this.rctNo  = rctNo ;
		this.laneCd  = laneCd ;
		this.rctOfcCd  = rctOfcCd ;
		this.cCustNm  = cCustNm ;
		this.rctAplyTgtCurrCd  = rctAplyTgtCurrCd ;
		this.cxlRsnFlg  = cxlRsnFlg ;
		this.otsBalAmt  = otsBalAmt ;
		this.ibflag  = ibflag ;
		this.rctCurrCd  = rctCurrCd ;
		this.rctAplyAmt  = rctAplyAmt ;
		this.usrNm  = usrNm ;
		this.rctCustCd  = rctCustCd ;
		this.rctSeq  = rctSeq ;
		this.sCustCd  = sCustCd ;
		this.otsCustCd  = otsCustCd ;
		this.bankAcctNm  = bankAcctNm ;
		this.sCustNm  = sCustNm ;
		this.chqNo  = chqNo ;
		this.vslNm  = vslNm ;
		this.cltTerm  = cltTerm ;
		this.ioBndCd  = ioBndCd ;
		this.invNo  = invNo ;
		this.rctCustSeq  = rctCustSeq ;
		this.rctTpCd  = rctTpCd ;
		this.rctDt  = rctDt ;
		this.totalCnt  = totalCnt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());		
		this.hashColumns.put("ots_cust_nm", getOtsCustNm());		
		this.hashColumns.put("sail_arr_dt", getSailArrDt());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("rct_cxl_rsn_cd", getRctCxlRsnCd());		
		this.hashColumns.put("rct_aply_chg_cd", getRctAplyChgCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("pol_cd", getPolCd());		
		this.hashColumns.put("rct_cust_cnt_cd", getRctCustCntCd());		
		this.hashColumns.put("rct_aply_src_curr_cd", getRctAplySrcCurrCd());		
		this.hashColumns.put("wrtf_cd", getWrtfCd());		
		this.hashColumns.put("rct_dps_dt", getRctDpsDt());		
		this.hashColumns.put("rvs_flg", getRvsFlg());		
		this.hashColumns.put("rct_cxl_rmk", getRctCxlRmk());		
		this.hashColumns.put("inv_dt", getInvDt());		
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());		
		this.hashColumns.put("rct_amt", getRctAmt());		
		this.hashColumns.put("locl_vvd_cd", getLoclVvdCd());		
		this.hashColumns.put("ots_aply_amt", getOtsAplyAmt());		
		this.hashColumns.put("rct_cust_nm", getRctCustNm());		
		this.hashColumns.put("rct_cxl_dt", getRctCxlDt());		
		this.hashColumns.put("usr_ofc", getUsrOfc());		
		this.hashColumns.put("rct_aply_xch_rt", getRctAplyXchRt());		
		this.hashColumns.put("pod_cd", getPodCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("ots_ofc_cd", getOtsOfcCd());		
		this.hashColumns.put("unapp_flg", getUnappFlg());		
		this.hashColumns.put("c_cust_cd", getCCustCd());		
		this.hashColumns.put("asa_no", getAsaNo());		
		this.hashColumns.put("cxl_usr_id", getCxlUsrId());		
		this.hashColumns.put("bank_chg_amt", getBankChgAmt());		
		this.hashColumns.put("rct_no", getRctNo());		
		this.hashColumns.put("lane_cd", getLaneCd());		
		this.hashColumns.put("rct_ofc_cd", getRctOfcCd());		
		this.hashColumns.put("c_cust_nm", getCCustNm());		
		this.hashColumns.put("rct_aply_tgt_curr_cd", getRctAplyTgtCurrCd());		
		this.hashColumns.put("cxl_rsn_flg", getCxlRsnFlg());		
		this.hashColumns.put("ots_bal_amt", getOtsBalAmt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("rct_curr_cd", getRctCurrCd());		
		this.hashColumns.put("rct_aply_amt", getRctAplyAmt());		
		this.hashColumns.put("usr_nm", getUsrNm());		
		this.hashColumns.put("rct_cust_cd", getRctCustCd());		
		this.hashColumns.put("rct_seq", getRctSeq());		
		this.hashColumns.put("s_cust_cd", getSCustCd());		
		this.hashColumns.put("ots_cust_cd", getOtsCustCd());		
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());		
		this.hashColumns.put("s_cust_nm", getSCustNm());		
		this.hashColumns.put("chq_no", getChqNo());		
		this.hashColumns.put("vsl_nm", getVslNm());		
		this.hashColumns.put("clt_term", getCltTerm());		
		this.hashColumns.put("io_bnd_cd", getIoBndCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("rct_cust_seq", getRctCustSeq());		
		this.hashColumns.put("rct_tp_cd", getRctTpCd());		
		this.hashColumns.put("rct_dt", getRctDt());		
		this.hashColumns.put("total_cnt", getTotalCnt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("ots_cust_nm", "otsCustNm");
		this.hashFields.put("sail_arr_dt", "sailArrDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("rct_cxl_rsn_cd", "rctCxlRsnCd");
		this.hashFields.put("rct_aply_chg_cd", "rctAplyChgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("rct_cust_cnt_cd", "rctCustCntCd");
		this.hashFields.put("rct_aply_src_curr_cd", "rctAplySrcCurrCd");
		this.hashFields.put("wrtf_cd", "wrtfCd");
		this.hashFields.put("rct_dps_dt", "rctDpsDt");
		this.hashFields.put("rvs_flg", "rvsFlg");
		this.hashFields.put("rct_cxl_rmk", "rctCxlRmk");
		this.hashFields.put("inv_dt", "invDt");
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("rct_amt", "rctAmt");
		this.hashFields.put("locl_vvd_cd", "loclVvdCd");
		this.hashFields.put("ots_aply_amt", "otsAplyAmt");
		this.hashFields.put("rct_cust_nm", "rctCustNm");
		this.hashFields.put("rct_cxl_dt", "rctCxlDt");
		this.hashFields.put("usr_ofc", "usrOfc");
		this.hashFields.put("rct_aply_xch_rt", "rctAplyXchRt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ots_ofc_cd", "otsOfcCd");
		this.hashFields.put("unapp_flg", "unappFlg");
		this.hashFields.put("c_cust_cd", "cCustCd");
		this.hashFields.put("asa_no", "asaNo");
		this.hashFields.put("cxl_usr_id", "cxlUsrId");
		this.hashFields.put("bank_chg_amt", "bankChgAmt");
		this.hashFields.put("rct_no", "rctNo");
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("rct_ofc_cd", "rctOfcCd");
		this.hashFields.put("c_cust_nm", "cCustNm");
		this.hashFields.put("rct_aply_tgt_curr_cd", "rctAplyTgtCurrCd");
		this.hashFields.put("cxl_rsn_flg", "cxlRsnFlg");
		this.hashFields.put("ots_bal_amt", "otsBalAmt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rct_curr_cd", "rctCurrCd");
		this.hashFields.put("rct_aply_amt", "rctAplyAmt");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("rct_cust_cd", "rctCustCd");
		this.hashFields.put("rct_seq", "rctSeq");
		this.hashFields.put("s_cust_cd", "sCustCd");
		this.hashFields.put("ots_cust_cd", "otsCustCd");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("s_cust_nm", "sCustNm");
		this.hashFields.put("chq_no", "chqNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("clt_term", "cltTerm");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("rct_cust_seq", "rctCustSeq");
		this.hashFields.put("rct_tp_cd", "rctTpCd");
		this.hashFields.put("rct_dt", "rctDt");
		this.hashFields.put("total_cnt", "totalCnt");
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
	* @param  otsCustNm
	*/
	public void	setOtsCustNm( String	otsCustNm ) {
		this.otsCustNm =	otsCustNm;
	}
 
	/**
	 * Column Info
	 * @return	otsCustNm
	 */
	 public	 String	getOtsCustNm() {
		 return	this.otsCustNm;
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
	* @param  rctCxlRsnCd
	*/
	public void	setRctCxlRsnCd( String	rctCxlRsnCd ) {
		this.rctCxlRsnCd =	rctCxlRsnCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCxlRsnCd
	 */
	 public	 String	getRctCxlRsnCd() {
		 return	this.rctCxlRsnCd;
	 } 
 	/**
	* Column Info
	* @param  rctAplyChgCd
	*/
	public void	setRctAplyChgCd( String	rctAplyChgCd ) {
		this.rctAplyChgCd =	rctAplyChgCd;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyChgCd
	 */
	 public	 String	getRctAplyChgCd() {
		 return	this.rctAplyChgCd;
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
	* @param  rctCustCntCd
	*/
	public void	setRctCustCntCd( String	rctCustCntCd ) {
		this.rctCustCntCd =	rctCustCntCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCustCntCd
	 */
	 public	 String	getRctCustCntCd() {
		 return	this.rctCustCntCd;
	 } 
 	/**
	* Column Info
	* @param  rctAplySrcCurrCd
	*/
	public void	setRctAplySrcCurrCd( String	rctAplySrcCurrCd ) {
		this.rctAplySrcCurrCd =	rctAplySrcCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	rctAplySrcCurrCd
	 */
	 public	 String	getRctAplySrcCurrCd() {
		 return	this.rctAplySrcCurrCd;
	 } 
 	/**
	* Column Info
	* @param  wrtfCd
	*/
	public void	setWrtfCd( String	wrtfCd ) {
		this.wrtfCd =	wrtfCd;
	}
 
	/**
	 * Column Info
	 * @return	wrtfCd
	 */
	 public	 String	getWrtfCd() {
		 return	this.wrtfCd;
	 } 
 	/**
	* Column Info
	* @param  rctDpsDt
	*/
	public void	setRctDpsDt( String	rctDpsDt ) {
		this.rctDpsDt =	rctDpsDt;
	}
 
	/**
	 * Column Info
	 * @return	rctDpsDt
	 */
	 public	 String	getRctDpsDt() {
		 return	this.rctDpsDt;
	 } 
 	/**
	* Column Info
	* @param  rvsFlg
	*/
	public void	setRvsFlg( String	rvsFlg ) {
		this.rvsFlg =	rvsFlg;
	}
 
	/**
	 * Column Info
	 * @return	rvsFlg
	 */
	 public	 String	getRvsFlg() {
		 return	this.rvsFlg;
	 } 
 	/**
	* Column Info
	* @param  rctCxlRmk
	*/
	public void	setRctCxlRmk( String	rctCxlRmk ) {
		this.rctCxlRmk =	rctCxlRmk;
	}
 
	/**
	 * Column Info
	 * @return	rctCxlRmk
	 */
	 public	 String	getRctCxlRmk() {
		 return	this.rctCxlRmk;
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
	* @param  bankAcctSeq
	*/
	public void	setBankAcctSeq( String	bankAcctSeq ) {
		this.bankAcctSeq =	bankAcctSeq;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctSeq
	 */
	 public	 String	getBankAcctSeq() {
		 return	this.bankAcctSeq;
	 } 
 	/**
	* Column Info
	* @param  rctAmt
	*/
	public void	setRctAmt( String	rctAmt ) {
		this.rctAmt =	rctAmt;
	}
 
	/**
	 * Column Info
	 * @return	rctAmt
	 */
	 public	 String	getRctAmt() {
		 return	this.rctAmt;
	 } 
 	/**
	* Column Info
	* @param  loclVvdCd
	*/
	public void	setLoclVvdCd( String	loclVvdCd ) {
		this.loclVvdCd =	loclVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	loclVvdCd
	 */
	 public	 String	getLoclVvdCd() {
		 return	this.loclVvdCd;
	 } 
 	/**
	* Column Info
	* @param  otsAplyAmt
	*/
	public void	setOtsAplyAmt( String	otsAplyAmt ) {
		this.otsAplyAmt =	otsAplyAmt;
	}
 
	/**
	 * Column Info
	 * @return	otsAplyAmt
	 */
	 public	 String	getOtsAplyAmt() {
		 return	this.otsAplyAmt;
	 } 
 	/**
	* Column Info
	* @param  rctCustNm
	*/
	public void	setRctCustNm( String	rctCustNm ) {
		this.rctCustNm =	rctCustNm;
	}
 
	/**
	 * Column Info
	 * @return	rctCustNm
	 */
	 public	 String	getRctCustNm() {
		 return	this.rctCustNm;
	 } 
 	/**
	* Column Info
	* @param  rctCxlDt
	*/
	public void	setRctCxlDt( String	rctCxlDt ) {
		this.rctCxlDt =	rctCxlDt;
	}
 
	/**
	 * Column Info
	 * @return	rctCxlDt
	 */
	 public	 String	getRctCxlDt() {
		 return	this.rctCxlDt;
	 } 
 	/**
	* Column Info
	* @param  usrOfc
	*/
	public void	setUsrOfc( String	usrOfc ) {
		this.usrOfc =	usrOfc;
	}
 
	/**
	 * Column Info
	 * @return	usrOfc
	 */
	 public	 String	getUsrOfc() {
		 return	this.usrOfc;
	 } 
 	/**
	* Column Info
	* @param  rctAplyXchRt
	*/
	public void	setRctAplyXchRt( String	rctAplyXchRt ) {
		this.rctAplyXchRt =	rctAplyXchRt;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyXchRt
	 */
	 public	 String	getRctAplyXchRt() {
		 return	this.rctAplyXchRt;
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
	* @param  unappFlg
	*/
	public void	setUnappFlg( String	unappFlg ) {
		this.unappFlg =	unappFlg;
	}
 
	/**
	 * Column Info
	 * @return	unappFlg
	 */
	 public	 String	getUnappFlg() {
		 return	this.unappFlg;
	 } 
 	/**
	* Column Info
	* @param  cCustCd
	*/
	public void	setCCustCd( String	cCustCd ) {
		this.cCustCd =	cCustCd;
	}
 
	/**
	 * Column Info
	 * @return	cCustCd
	 */
	 public	 String	getCCustCd() {
		 return	this.cCustCd;
	 } 
 	/**
	* Column Info
	* @param  asaNo
	*/
	public void	setAsaNo( String	asaNo ) {
		this.asaNo =	asaNo;
	}
 
	/**
	 * Column Info
	 * @return	asaNo
	 */
	 public	 String	getAsaNo() {
		 return	this.asaNo;
	 } 
 	/**
	* Column Info
	* @param  cxlUsrId
	*/
	public void	setCxlUsrId( String	cxlUsrId ) {
		this.cxlUsrId =	cxlUsrId;
	}
 
	/**
	 * Column Info
	 * @return	cxlUsrId
	 */
	 public	 String	getCxlUsrId() {
		 return	this.cxlUsrId;
	 } 
 	/**
	* Column Info
	* @param  bankChgAmt
	*/
	public void	setBankChgAmt( String	bankChgAmt ) {
		this.bankChgAmt =	bankChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	bankChgAmt
	 */
	 public	 String	getBankChgAmt() {
		 return	this.bankChgAmt;
	 } 
 	/**
	* Column Info
	* @param  rctNo
	*/
	public void	setRctNo( String	rctNo ) {
		this.rctNo =	rctNo;
	}
 
	/**
	 * Column Info
	 * @return	rctNo
	 */
	 public	 String	getRctNo() {
		 return	this.rctNo;
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
	* @param  rctOfcCd
	*/
	public void	setRctOfcCd( String	rctOfcCd ) {
		this.rctOfcCd =	rctOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	rctOfcCd
	 */
	 public	 String	getRctOfcCd() {
		 return	this.rctOfcCd;
	 } 
 	/**
	* Column Info
	* @param  cCustNm
	*/
	public void	setCCustNm( String	cCustNm ) {
		this.cCustNm =	cCustNm;
	}
 
	/**
	 * Column Info
	 * @return	cCustNm
	 */
	 public	 String	getCCustNm() {
		 return	this.cCustNm;
	 } 
 	/**
	* Column Info
	* @param  rctAplyTgtCurrCd
	*/
	public void	setRctAplyTgtCurrCd( String	rctAplyTgtCurrCd ) {
		this.rctAplyTgtCurrCd =	rctAplyTgtCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyTgtCurrCd
	 */
	 public	 String	getRctAplyTgtCurrCd() {
		 return	this.rctAplyTgtCurrCd;
	 } 
 	/**
	* Column Info
	* @param  cxlRsnFlg
	*/
	public void	setCxlRsnFlg( String	cxlRsnFlg ) {
		this.cxlRsnFlg =	cxlRsnFlg;
	}
 
	/**
	 * Column Info
	 * @return	cxlRsnFlg
	 */
	 public	 String	getCxlRsnFlg() {
		 return	this.cxlRsnFlg;
	 } 
 	/**
	* Column Info
	* @param  otsBalAmt
	*/
	public void	setOtsBalAmt( String	otsBalAmt ) {
		this.otsBalAmt =	otsBalAmt;
	}
 
	/**
	 * Column Info
	 * @return	otsBalAmt
	 */
	 public	 String	getOtsBalAmt() {
		 return	this.otsBalAmt;
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
	* @param  rctCurrCd
	*/
	public void	setRctCurrCd( String	rctCurrCd ) {
		this.rctCurrCd =	rctCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCurrCd
	 */
	 public	 String	getRctCurrCd() {
		 return	this.rctCurrCd;
	 } 
 	/**
	* Column Info
	* @param  rctAplyAmt
	*/
	public void	setRctAplyAmt( String	rctAplyAmt ) {
		this.rctAplyAmt =	rctAplyAmt;
	}
 
	/**
	 * Column Info
	 * @return	rctAplyAmt
	 */
	 public	 String	getRctAplyAmt() {
		 return	this.rctAplyAmt;
	 } 
 	/**
	* Column Info
	* @param  usrNm
	*/
	public void	setUsrNm( String	usrNm ) {
		this.usrNm =	usrNm;
	}
 
	/**
	 * Column Info
	 * @return	usrNm
	 */
	 public	 String	getUsrNm() {
		 return	this.usrNm;
	 } 
 	/**
	* Column Info
	* @param  rctCustCd
	*/
	public void	setRctCustCd( String	rctCustCd ) {
		this.rctCustCd =	rctCustCd;
	}
 
	/**
	 * Column Info
	 * @return	rctCustCd
	 */
	 public	 String	getRctCustCd() {
		 return	this.rctCustCd;
	 } 
 	/**
	* Column Info
	* @param  rctSeq
	*/
	public void	setRctSeq( String	rctSeq ) {
		this.rctSeq =	rctSeq;
	}
 
	/**
	 * Column Info
	 * @return	rctSeq
	 */
	 public	 String	getRctSeq() {
		 return	this.rctSeq;
	 } 
 	/**
	* Column Info
	* @param  sCustCd
	*/
	public void	setSCustCd( String	sCustCd ) {
		this.sCustCd =	sCustCd;
	}
 
	/**
	 * Column Info
	 * @return	sCustCd
	 */
	 public	 String	getSCustCd() {
		 return	this.sCustCd;
	 } 
 	/**
	* Column Info
	* @param  otsCustCd
	*/
	public void	setOtsCustCd( String	otsCustCd ) {
		this.otsCustCd =	otsCustCd;
	}
 
	/**
	 * Column Info
	 * @return	otsCustCd
	 */
	 public	 String	getOtsCustCd() {
		 return	this.otsCustCd;
	 } 
 	/**
	* Column Info
	* @param  bankAcctNm
	*/
	public void	setBankAcctNm( String	bankAcctNm ) {
		this.bankAcctNm =	bankAcctNm;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctNm
	 */
	 public	 String	getBankAcctNm() {
		 return	this.bankAcctNm;
	 } 
 	/**
	* Column Info
	* @param  sCustNm
	*/
	public void	setSCustNm( String	sCustNm ) {
		this.sCustNm =	sCustNm;
	}
 
	/**
	 * Column Info
	 * @return	sCustNm
	 */
	 public	 String	getSCustNm() {
		 return	this.sCustNm;
	 } 
 	/**
	* Column Info
	* @param  chqNo
	*/
	public void	setChqNo( String	chqNo ) {
		this.chqNo =	chqNo;
	}
 
	/**
	 * Column Info
	 * @return	chqNo
	 */
	 public	 String	getChqNo() {
		 return	this.chqNo;
	 } 
 	/**
	* Column Info
	* @param  vslNm
	*/
	public void	setVslNm( String	vslNm ) {
		this.vslNm =	vslNm;
	}
 
	/**
	 * Column Info
	 * @return	vslNm
	 */
	 public	 String	getVslNm() {
		 return	this.vslNm;
	 } 
 	/**
	* Column Info
	* @param  cltTerm
	*/
	public void	setCltTerm( String	cltTerm ) {
		this.cltTerm =	cltTerm;
	}
 
	/**
	 * Column Info
	 * @return	cltTerm
	 */
	 public	 String	getCltTerm() {
		 return	this.cltTerm;
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
	* @param  rctCustSeq
	*/
	public void	setRctCustSeq( String	rctCustSeq ) {
		this.rctCustSeq =	rctCustSeq;
	}
 
	/**
	 * Column Info
	 * @return	rctCustSeq
	 */
	 public	 String	getRctCustSeq() {
		 return	this.rctCustSeq;
	 } 
 	/**
	* Column Info
	* @param  rctTpCd
	*/
	public void	setRctTpCd( String	rctTpCd ) {
		this.rctTpCd =	rctTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rctTpCd
	 */
	 public	 String	getRctTpCd() {
		 return	this.rctTpCd;
	 } 
 	/**
	* Column Info
	* @param  rctDt
	*/
	public void	setRctDt( String	rctDt ) {
		this.rctDt =	rctDt;
	}
 
	/**
	 * Column Info
	 * @return	rctDt
	 */
	 public	 String	getRctDt() {
		 return	this.rctDt;
	 } 
 	/**
	* Column Info
	* @param  totalCnt
	*/
	public void	setTotalCnt( String	totalCnt ) {
		this.totalCnt =	totalCnt;
	}
 
	/**
	 * Column Info
	 * @return	totalCnt
	 */
	 public	 String	getTotalCnt() {
		 return	this.totalCnt;
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
		setOtsCustNm(JSPUtil.getParameter(request,	prefix + "ots_cust_nm", ""));
		setSailArrDt(JSPUtil.getParameter(request,	prefix + "sail_arr_dt", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setRctCxlRsnCd(JSPUtil.getParameter(request,	prefix + "rct_cxl_rsn_cd", ""));
		setRctAplyChgCd(JSPUtil.getParameter(request,	prefix + "rct_aply_chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setRctCustCntCd(JSPUtil.getParameter(request,	prefix + "rct_cust_cnt_cd", ""));
		setRctAplySrcCurrCd(JSPUtil.getParameter(request,	prefix + "rct_aply_src_curr_cd", ""));
		setWrtfCd(JSPUtil.getParameter(request,	prefix + "wrtf_cd", ""));
		setRctDpsDt(JSPUtil.getParameter(request,	prefix + "rct_dps_dt", ""));
		setRvsFlg(JSPUtil.getParameter(request,	prefix + "rvs_flg", ""));
		setRctCxlRmk(JSPUtil.getParameter(request,	prefix + "rct_cxl_rmk", ""));
		setInvDt(JSPUtil.getParameter(request,	prefix + "inv_dt", ""));
		setBankAcctSeq(JSPUtil.getParameter(request,	prefix + "bank_acct_seq", ""));
		setRctAmt(JSPUtil.getParameter(request,	prefix + "rct_amt", ""));
		setLoclVvdCd(JSPUtil.getParameter(request,	prefix + "locl_vvd_cd", ""));
		setOtsAplyAmt(JSPUtil.getParameter(request,	prefix + "ots_aply_amt", ""));
		setRctCustNm(JSPUtil.getParameter(request,	prefix + "rct_cust_nm", ""));
		setRctCxlDt(JSPUtil.getParameter(request,	prefix + "rct_cxl_dt", ""));
		setUsrOfc(JSPUtil.getParameter(request,	prefix + "usr_ofc", ""));
		setRctAplyXchRt(JSPUtil.getParameter(request,	prefix + "rct_aply_xch_rt", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setOtsOfcCd(JSPUtil.getParameter(request,	prefix + "ots_ofc_cd", ""));
		setUnappFlg(JSPUtil.getParameter(request,	prefix + "unapp_flg", ""));
		setCCustCd(JSPUtil.getParameter(request,	prefix + "c_cust_cd", ""));
		setAsaNo(JSPUtil.getParameter(request,	prefix + "asa_no", ""));
		setCxlUsrId(JSPUtil.getParameter(request,	prefix + "cxl_usr_id", ""));
		setBankChgAmt(JSPUtil.getParameter(request,	prefix + "bank_chg_amt", ""));
		setRctNo(JSPUtil.getParameter(request,	prefix + "rct_no", ""));
		setLaneCd(JSPUtil.getParameter(request,	prefix + "lane_cd", ""));
		setRctOfcCd(JSPUtil.getParameter(request,	prefix + "rct_ofc_cd", ""));
		setCCustNm(JSPUtil.getParameter(request,	prefix + "c_cust_nm", ""));
		setRctAplyTgtCurrCd(JSPUtil.getParameter(request,	prefix + "rct_aply_tgt_curr_cd", ""));
		setCxlRsnFlg(JSPUtil.getParameter(request,	prefix + "cxl_rsn_flg", ""));
		setOtsBalAmt(JSPUtil.getParameter(request,	prefix + "ots_bal_amt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setRctCurrCd(JSPUtil.getParameter(request,	prefix + "rct_curr_cd", ""));
		setRctAplyAmt(JSPUtil.getParameter(request,	prefix + "rct_aply_amt", ""));
		setUsrNm(JSPUtil.getParameter(request,	prefix + "usr_nm", ""));
		setRctCustCd(JSPUtil.getParameter(request,	prefix + "rct_cust_cd", ""));
		setRctSeq(JSPUtil.getParameter(request,	prefix + "rct_seq", ""));
		setSCustCd(JSPUtil.getParameter(request,	prefix + "s_cust_cd", ""));
		setOtsCustCd(JSPUtil.getParameter(request,	prefix + "ots_cust_cd", ""));
		setBankAcctNm(JSPUtil.getParameter(request,	prefix + "bank_acct_nm", ""));
		setSCustNm(JSPUtil.getParameter(request,	prefix + "s_cust_nm", ""));
		setChqNo(JSPUtil.getParameter(request,	prefix + "chq_no", ""));
		setVslNm(JSPUtil.getParameter(request,	prefix + "vsl_nm", ""));
		setCltTerm(JSPUtil.getParameter(request,	prefix + "clt_term", ""));
		setIoBndCd(JSPUtil.getParameter(request,	prefix + "io_bnd_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setRctCustSeq(JSPUtil.getParameter(request,	prefix + "rct_cust_seq", ""));
		setRctTpCd(JSPUtil.getParameter(request,	prefix + "rct_tp_cd", ""));
		setRctDt(JSPUtil.getParameter(request,	prefix + "rct_dt", ""));
		setTotalCnt(JSPUtil.getParameter(request,	prefix + "total_cnt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ReceiptListByDetailVO[]
	 */
	public ReceiptListByDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ReceiptListByDetailVO[]
	 */
	public ReceiptListByDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ReceiptListByDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd".trim(),	length));
				String[] otsCustNm =	(JSPUtil.getParameter(request, prefix +	"ots_cust_nm".trim(),	length));
				String[] sailArrDt =	(JSPUtil.getParameter(request, prefix +	"sail_arr_dt".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] rctCxlRsnCd =	(JSPUtil.getParameter(request, prefix +	"rct_cxl_rsn_cd".trim(),	length));
				String[] rctAplyChgCd =	(JSPUtil.getParameter(request, prefix +	"rct_aply_chg_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd".trim(),	length));
				String[] rctCustCntCd =	(JSPUtil.getParameter(request, prefix +	"rct_cust_cnt_cd".trim(),	length));
				String[] rctAplySrcCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_aply_src_curr_cd".trim(),	length));
				String[] wrtfCd =	(JSPUtil.getParameter(request, prefix +	"wrtf_cd".trim(),	length));
				String[] rctDpsDt =	(JSPUtil.getParameter(request, prefix +	"rct_dps_dt".trim(),	length));
				String[] rvsFlg =	(JSPUtil.getParameter(request, prefix +	"rvs_flg".trim(),	length));
				String[] rctCxlRmk =	(JSPUtil.getParameter(request, prefix +	"rct_cxl_rmk".trim(),	length));
				String[] invDt =	(JSPUtil.getParameter(request, prefix +	"inv_dt".trim(),	length));
				String[] bankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"bank_acct_seq".trim(),	length));
				String[] rctAmt =	(JSPUtil.getParameter(request, prefix +	"rct_amt".trim(),	length));
				String[] loclVvdCd =	(JSPUtil.getParameter(request, prefix +	"locl_vvd_cd".trim(),	length));
				String[] otsAplyAmt =	(JSPUtil.getParameter(request, prefix +	"ots_aply_amt".trim(),	length));
				String[] rctCustNm =	(JSPUtil.getParameter(request, prefix +	"rct_cust_nm".trim(),	length));
				String[] rctCxlDt =	(JSPUtil.getParameter(request, prefix +	"rct_cxl_dt".trim(),	length));
				String[] usrOfc =	(JSPUtil.getParameter(request, prefix +	"usr_ofc".trim(),	length));
				String[] rctAplyXchRt =	(JSPUtil.getParameter(request, prefix +	"rct_aply_xch_rt".trim(),	length));
				String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] otsOfcCd =	(JSPUtil.getParameter(request, prefix +	"ots_ofc_cd".trim(),	length));
				String[] unappFlg =	(JSPUtil.getParameter(request, prefix +	"unapp_flg".trim(),	length));
				String[] cCustCd =	(JSPUtil.getParameter(request, prefix +	"c_cust_cd".trim(),	length));
				String[] asaNo =	(JSPUtil.getParameter(request, prefix +	"asa_no".trim(),	length));
				String[] cxlUsrId =	(JSPUtil.getParameter(request, prefix +	"cxl_usr_id".trim(),	length));
				String[] bankChgAmt =	(JSPUtil.getParameter(request, prefix +	"bank_chg_amt".trim(),	length));
				String[] rctNo =	(JSPUtil.getParameter(request, prefix +	"rct_no".trim(),	length));
				String[] laneCd =	(JSPUtil.getParameter(request, prefix +	"lane_cd".trim(),	length));
				String[] rctOfcCd =	(JSPUtil.getParameter(request, prefix +	"rct_ofc_cd".trim(),	length));
				String[] cCustNm =	(JSPUtil.getParameter(request, prefix +	"c_cust_nm".trim(),	length));
				String[] rctAplyTgtCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_aply_tgt_curr_cd".trim(),	length));
				String[] cxlRsnFlg =	(JSPUtil.getParameter(request, prefix +	"cxl_rsn_flg".trim(),	length));
				String[] otsBalAmt =	(JSPUtil.getParameter(request, prefix +	"ots_bal_amt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] rctCurrCd =	(JSPUtil.getParameter(request, prefix +	"rct_curr_cd".trim(),	length));
				String[] rctAplyAmt =	(JSPUtil.getParameter(request, prefix +	"rct_aply_amt".trim(),	length));
				String[] usrNm =	(JSPUtil.getParameter(request, prefix +	"usr_nm".trim(),	length));
				String[] rctCustCd =	(JSPUtil.getParameter(request, prefix +	"rct_cust_cd".trim(),	length));
				String[] rctSeq =	(JSPUtil.getParameter(request, prefix +	"rct_seq".trim(),	length));
				String[] sCustCd =	(JSPUtil.getParameter(request, prefix +	"s_cust_cd".trim(),	length));
				String[] otsCustCd =	(JSPUtil.getParameter(request, prefix +	"ots_cust_cd".trim(),	length));
				String[] bankAcctNm =	(JSPUtil.getParameter(request, prefix +	"bank_acct_nm".trim(),	length));
				String[] sCustNm =	(JSPUtil.getParameter(request, prefix +	"s_cust_nm".trim(),	length));
				String[] chqNo =	(JSPUtil.getParameter(request, prefix +	"chq_no".trim(),	length));
				String[] vslNm =	(JSPUtil.getParameter(request, prefix +	"vsl_nm".trim(),	length));
				String[] cltTerm =	(JSPUtil.getParameter(request, prefix +	"clt_term".trim(),	length));
				String[] ioBndCd =	(JSPUtil.getParameter(request, prefix +	"io_bnd_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] rctCustSeq =	(JSPUtil.getParameter(request, prefix +	"rct_cust_seq".trim(),	length));
				String[] rctTpCd =	(JSPUtil.getParameter(request, prefix +	"rct_tp_cd".trim(),	length));
				String[] rctDt =	(JSPUtil.getParameter(request, prefix +	"rct_dt".trim(),	length));
				String[] totalCnt =	(JSPUtil.getParameter(request, prefix +	"total_cnt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ReceiptListByDetailVO();
						if ( svcScpCd[i] !=	null)
						model.setSvcScpCd( svcScpCd[i]);
						if ( otsCustNm[i] !=	null)
						model.setOtsCustNm( otsCustNm[i]);
						if ( sailArrDt[i] !=	null)
						model.setSailArrDt( sailArrDt[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( rctCxlRsnCd[i] !=	null)
						model.setRctCxlRsnCd( rctCxlRsnCd[i]);
						if ( rctAplyChgCd[i] !=	null)
						model.setRctAplyChgCd( rctAplyChgCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( polCd[i] !=	null)
						model.setPolCd( polCd[i]);
						if ( rctCustCntCd[i] !=	null)
						model.setRctCustCntCd( rctCustCntCd[i]);
						if ( rctAplySrcCurrCd[i] !=	null)
						model.setRctAplySrcCurrCd( rctAplySrcCurrCd[i]);
						if ( wrtfCd[i] !=	null)
						model.setWrtfCd( wrtfCd[i]);
						if ( rctDpsDt[i] !=	null)
						model.setRctDpsDt( rctDpsDt[i]);
						if ( rvsFlg[i] !=	null)
						model.setRvsFlg( rvsFlg[i]);
						if ( rctCxlRmk[i] !=	null)
						model.setRctCxlRmk( rctCxlRmk[i]);
						if ( invDt[i] !=	null)
						model.setInvDt( invDt[i]);
						if ( bankAcctSeq[i] !=	null)
						model.setBankAcctSeq( bankAcctSeq[i]);
						if ( rctAmt[i] !=	null)
						model.setRctAmt( rctAmt[i]);
						if ( loclVvdCd[i] !=	null)
						model.setLoclVvdCd( loclVvdCd[i]);
						if ( otsAplyAmt[i] !=	null)
						model.setOtsAplyAmt( otsAplyAmt[i]);
						if ( rctCustNm[i] !=	null)
						model.setRctCustNm( rctCustNm[i]);
						if ( rctCxlDt[i] !=	null)
						model.setRctCxlDt( rctCxlDt[i]);
						if ( usrOfc[i] !=	null)
						model.setUsrOfc( usrOfc[i]);
						if ( rctAplyXchRt[i] !=	null)
						model.setRctAplyXchRt( rctAplyXchRt[i]);
						if ( podCd[i] !=	null)
						model.setPodCd( podCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( otsOfcCd[i] !=	null)
						model.setOtsOfcCd( otsOfcCd[i]);
						if ( unappFlg[i] !=	null)
						model.setUnappFlg( unappFlg[i]);
						if ( cCustCd[i] !=	null)
						model.setCCustCd( cCustCd[i]);
						if ( asaNo[i] !=	null)
						model.setAsaNo( asaNo[i]);
						if ( cxlUsrId[i] !=	null)
						model.setCxlUsrId( cxlUsrId[i]);
						if ( bankChgAmt[i] !=	null)
						model.setBankChgAmt( bankChgAmt[i]);
						if ( rctNo[i] !=	null)
						model.setRctNo( rctNo[i]);
						if ( laneCd[i] !=	null)
						model.setLaneCd( laneCd[i]);
						if ( rctOfcCd[i] !=	null)
						model.setRctOfcCd( rctOfcCd[i]);
						if ( cCustNm[i] !=	null)
						model.setCCustNm( cCustNm[i]);
						if ( rctAplyTgtCurrCd[i] !=	null)
						model.setRctAplyTgtCurrCd( rctAplyTgtCurrCd[i]);
						if ( cxlRsnFlg[i] !=	null)
						model.setCxlRsnFlg( cxlRsnFlg[i]);
						if ( otsBalAmt[i] !=	null)
						model.setOtsBalAmt( otsBalAmt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( rctCurrCd[i] !=	null)
						model.setRctCurrCd( rctCurrCd[i]);
						if ( rctAplyAmt[i] !=	null)
						model.setRctAplyAmt( rctAplyAmt[i]);
						if ( usrNm[i] !=	null)
						model.setUsrNm( usrNm[i]);
						if ( rctCustCd[i] !=	null)
						model.setRctCustCd( rctCustCd[i]);
						if ( rctSeq[i] !=	null)
						model.setRctSeq( rctSeq[i]);
						if ( sCustCd[i] !=	null)
						model.setSCustCd( sCustCd[i]);
						if ( otsCustCd[i] !=	null)
						model.setOtsCustCd( otsCustCd[i]);
						if ( bankAcctNm[i] !=	null)
						model.setBankAcctNm( bankAcctNm[i]);
						if ( sCustNm[i] !=	null)
						model.setSCustNm( sCustNm[i]);
						if ( chqNo[i] !=	null)
						model.setChqNo( chqNo[i]);
						if ( vslNm[i] !=	null)
						model.setVslNm( vslNm[i]);
						if ( cltTerm[i] !=	null)
						model.setCltTerm( cltTerm[i]);
						if ( ioBndCd[i] !=	null)
						model.setIoBndCd( ioBndCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( rctCustSeq[i] !=	null)
						model.setRctCustSeq( rctCustSeq[i]);
						if ( rctTpCd[i] !=	null)
						model.setRctTpCd( rctTpCd[i]);
						if ( rctDt[i] !=	null)
						model.setRctDt( rctDt[i]);
						if ( totalCnt[i] !=	null)
						model.setTotalCnt( totalCnt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getReceiptListByDetailVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ReceiptListByDetailVO[]
	 */
	public ReceiptListByDetailVO[]	 getReceiptListByDetailVOs(){
		ReceiptListByDetailVO[] vos = (ReceiptListByDetailVO[])models.toArray(new	ReceiptListByDetailVO[models.size()]);
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
		this.otsCustNm =	this.otsCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sailArrDt =	this.sailArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlRsnCd =	this.rctCxlRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyChgCd =	this.rctAplyChgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustCntCd =	this.rctCustCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplySrcCurrCd =	this.rctAplySrcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wrtfCd =	this.wrtfCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDpsDt =	this.rctDpsDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsFlg =	this.rvsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlRmk =	this.rctCxlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invDt =	this.invDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctSeq =	this.bankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAmt =	this.rctAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclVvdCd =	this.loclVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsAplyAmt =	this.otsAplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustNm =	this.rctCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCxlDt =	this.rctCxlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrOfc =	this.usrOfc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyXchRt =	this.rctAplyXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsOfcCd =	this.otsOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unappFlg =	this.unappFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustCd =	this.cCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asaNo =	this.asaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlUsrId =	this.cxlUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankChgAmt =	this.bankChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctNo =	this.rctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneCd =	this.laneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctOfcCd =	this.rctOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCustNm =	this.cCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyTgtCurrCd =	this.rctAplyTgtCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlRsnFlg =	this.cxlRsnFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsBalAmt =	this.otsBalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCurrCd =	this.rctCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctAplyAmt =	this.rctAplyAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm =	this.usrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustCd =	this.rctCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctSeq =	this.rctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustCd =	this.sCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.otsCustCd =	this.otsCustCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm =	this.bankAcctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCustNm =	this.sCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chqNo =	this.chqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm =	this.vslNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltTerm =	this.cltTerm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd =	this.ioBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctCustSeq =	this.rctCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctTpCd =	this.rctTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rctDt =	this.rctDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalCnt =	this.totalCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}