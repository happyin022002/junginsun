/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : TesTmlSoHdrVO.java
 *@FileTitle : TesTmlSoHdrVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.08.03
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.08.03  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.syscommon.common.table;

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
 * - 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class TesTmlSoHdrVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<TesTmlSoHdrVO>  models =	new	ArrayList<TesTmlSoHdrVO>();


	/*	Column Info	*/
	private  String	 payDt   =  null;
	/*	Column Info	*/
	private  String	 ediFlg   =  null;
	/*	Column Info	*/
	private  String	 hpcCreFlg   =  null;
	/*	Column Info	*/
	private  String	 tmlInvTpCd   =  null;
	/*	Column Info	*/
	private  String	 apPayDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 effDt   =  null;
	/*	Column Info	*/
	private  String	 tmlCostGrpCd   =  null;
	/*	Column Info	*/
	private  String	 leaCreFlg   =  null;
	/*	Column Info	*/
	private  String	 apRvsCngFlg   =  null;
	/*	Column Info	*/
	private  String	 rcvDt   =  null;
	/*	Column Info	*/
	private  String	 payDueDt   =  null;
	/*	Column Info	*/
	private  String	 tmlInvRjctStsCd   =  null;
	/*	Column Info	*/
	private  String	 hpcDeltFlg   =  null;
	/*	Column Info	*/
	private  String	 fmPrdDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 csrNo   =  null;
	/*	Column Info	*/
	private  String	 apCxlDt   =  null;
	/*	Column Info	*/
	private  String	 invRjctRmk   =  null;
	/*	Column Info	*/
	private  String	 rtroTmlInvFlg   =  null;
	/*	Column Info	*/
	private  String	 whldTaxAmt   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 tmlSoSeq   =  null;
	/*	Column Info	*/
	private  String	 invRjctDt   =  null;
	/*	Column Info	*/
	private  String	 loclUpdDt   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 deltFlg   =  null;
	/*	Column Info	*/
	private  String	 errInvNo   =  null;
	/*	Column Info	*/
	private  String	 payFlg   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 tmlCalcIndCd   =  null;
	/*	Column Info	*/
	private  String	 issDt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 ttlCalcAmt   =  null;
	/*	Column Info	*/
	private  String	 apIfDt   =  null;
	/*	Column Info	*/
	private  String	 invOfcCd   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 costOfcCd   =  null;
	/*	Column Info	*/
	private  String	 hpcCxlFlg   =  null;
	/*	Column Info	*/
	private  String	 invCfmDt   =  null;
	/*	Column Info	*/
	private  String	 loclCreDt   =  null;
	/*	Column Info	*/
	private  String	 toPrdDt   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 vatAmt   =  null;
	/*	Column Info	*/
	private  String	 hldRmk   =  null;
	/*	Column Info	*/
	private  String	 ydCd   =  null;
	/*	Column Info	*/
	private  String	 tmlInvStsCd   =  null;
	/*	Column Info	*/
	private  String	 leaCxlFlg   =  null;
	/*	Column Info	*/
	private  String	 stoDysIndCd   =  null;
	/*	Column Info	*/
	private  String	 hldFlg   =  null;
	/*	Column Info	*/
	private  String	 ttlInvAmt   =  null;
	/*	Column Info	*/
	private  String	 tmlSoOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 idaCgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaSgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaIgstAmt   =  null;
	/*	Column Info	*/
	private  String	 idaUgstAmt   =  null;
	/*	Column Info	*/
	private  String	 dbtNoteNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public TesTmlSoHdrVO(){}

	public TesTmlSoHdrVO(String payDt,String ediFlg,String hpcCreFlg,String tmlInvTpCd,String apPayDt,String pagerows,String effDt,String tmlCostGrpCd,String leaCreFlg,String apRvsCngFlg,String rcvDt,String payDueDt,String tmlInvRjctStsCd,String hpcDeltFlg,String fmPrdDt,String updUsrId,String csrNo,String apCxlDt,String invRjctRmk,String rtroTmlInvFlg,String whldTaxAmt,String creUsrId,String vndrSeq,String tmlSoSeq,String invRjctDt,String loclUpdDt,String currCd,String deltFlg,String errInvNo,String payFlg,String creDt,String tmlCalcIndCd,String issDt,String ibflag,String ttlCalcAmt,String apIfDt,String invOfcCd,String updDt,String costOfcCd,String hpcCxlFlg,String invCfmDt,String loclCreDt,String toPrdDt,String invNo,String vatAmt,String hldRmk,String ydCd,String tmlInvStsCd,String leaCxlFlg,String stoDysIndCd,String hldFlg,String ttlInvAmt,String tmlSoOfcCtyCd,String idaCgstAmt,String idaSgstAmt,String idaIgstAmt,String idaUgstAmt,String dbtNoteNo)	{
		this.payDt  = payDt ;
		this.ediFlg  = ediFlg ;
		this.hpcCreFlg  = hpcCreFlg ;
		this.tmlInvTpCd  = tmlInvTpCd ;
		this.apPayDt  = apPayDt ;
		this.pagerows  = pagerows ;
		this.effDt  = effDt ;
		this.tmlCostGrpCd  = tmlCostGrpCd ;
		this.leaCreFlg  = leaCreFlg ;
		this.apRvsCngFlg  = apRvsCngFlg ;
		this.rcvDt  = rcvDt ;
		this.payDueDt  = payDueDt ;
		this.tmlInvRjctStsCd  = tmlInvRjctStsCd ;
		this.hpcDeltFlg  = hpcDeltFlg ;
		this.fmPrdDt  = fmPrdDt ;
		this.updUsrId  = updUsrId ;
		this.csrNo  = csrNo ;
		this.apCxlDt  = apCxlDt ;
		this.invRjctRmk  = invRjctRmk ;
		this.rtroTmlInvFlg  = rtroTmlInvFlg ;
		this.whldTaxAmt  = whldTaxAmt ;
		this.creUsrId  = creUsrId ;
		this.vndrSeq  = vndrSeq ;
		this.tmlSoSeq  = tmlSoSeq ;
		this.invRjctDt  = invRjctDt ;
		this.loclUpdDt  = loclUpdDt ;
		this.currCd  = currCd ;
		this.deltFlg  = deltFlg ;
		this.errInvNo  = errInvNo ;
		this.payFlg  = payFlg ;
		this.creDt  = creDt ;
		this.tmlCalcIndCd  = tmlCalcIndCd ;
		this.issDt  = issDt ;
		this.ibflag  = ibflag ;
		this.ttlCalcAmt  = ttlCalcAmt ;
		this.apIfDt  = apIfDt ;
		this.invOfcCd  = invOfcCd ;
		this.updDt  = updDt ;
		this.costOfcCd  = costOfcCd ;
		this.hpcCxlFlg  = hpcCxlFlg ;
		this.invCfmDt  = invCfmDt ;
		this.loclCreDt  = loclCreDt ;
		this.toPrdDt  = toPrdDt ;
		this.invNo  = invNo ;
		this.vatAmt  = vatAmt ;
		this.hldRmk  = hldRmk ;
		this.ydCd  = ydCd ;
		this.tmlInvStsCd  = tmlInvStsCd ;
		this.leaCxlFlg  = leaCxlFlg ;
		this.stoDysIndCd  = stoDysIndCd ;
		this.hldFlg  = hldFlg ;
		this.ttlInvAmt  = ttlInvAmt ;
		this.tmlSoOfcCtyCd  = tmlSoOfcCtyCd ;
		this.idaCgstAmt  = idaCgstAmt ;
		this.idaSgstAmt  = idaSgstAmt ;
		this.idaIgstAmt  = idaIgstAmt ;
		this.idaUgstAmt  = idaUgstAmt ;
		this.dbtNoteNo  = dbtNoteNo ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pay_dt", getPayDt());		
		this.hashColumns.put("edi_flg", getEdiFlg());		
		this.hashColumns.put("hpc_cre_flg", getHpcCreFlg());		
		this.hashColumns.put("tml_inv_tp_cd", getTmlInvTpCd());		
		this.hashColumns.put("ap_pay_dt", getApPayDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("eff_dt", getEffDt());		
		this.hashColumns.put("tml_cost_grp_cd", getTmlCostGrpCd());		
		this.hashColumns.put("lea_cre_flg", getLeaCreFlg());		
		this.hashColumns.put("ap_rvs_cng_flg", getApRvsCngFlg());		
		this.hashColumns.put("rcv_dt", getRcvDt());		
		this.hashColumns.put("pay_due_dt", getPayDueDt());		
		this.hashColumns.put("tml_inv_rjct_sts_cd", getTmlInvRjctStsCd());		
		this.hashColumns.put("hpc_delt_flg", getHpcDeltFlg());		
		this.hashColumns.put("fm_prd_dt", getFmPrdDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("csr_no", getCsrNo());		
		this.hashColumns.put("ap_cxl_dt", getApCxlDt());		
		this.hashColumns.put("inv_rjct_rmk", getInvRjctRmk());		
		this.hashColumns.put("rtro_tml_inv_flg", getRtroTmlInvFlg());		
		this.hashColumns.put("whld_tax_amt", getWhldTaxAmt());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("tml_so_seq", getTmlSoSeq());		
		this.hashColumns.put("inv_rjct_dt", getInvRjctDt());		
		this.hashColumns.put("locl_upd_dt", getLoclUpdDt());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("delt_flg", getDeltFlg());		
		this.hashColumns.put("err_inv_no", getErrInvNo());		
		this.hashColumns.put("pay_flg", getPayFlg());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("tml_calc_ind_cd", getTmlCalcIndCd());		
		this.hashColumns.put("iss_dt", getIssDt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ttl_calc_amt", getTtlCalcAmt());		
		this.hashColumns.put("ap_if_dt", getApIfDt());		
		this.hashColumns.put("inv_ofc_cd", getInvOfcCd());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("cost_ofc_cd", getCostOfcCd());		
		this.hashColumns.put("hpc_cxl_flg", getHpcCxlFlg());		
		this.hashColumns.put("inv_cfm_dt", getInvCfmDt());		
		this.hashColumns.put("locl_cre_dt", getLoclCreDt());		
		this.hashColumns.put("to_prd_dt", getToPrdDt());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("vat_amt", getVatAmt());		
		this.hashColumns.put("hld_rmk", getHldRmk());		
		this.hashColumns.put("yd_cd", getYdCd());		
		this.hashColumns.put("tml_inv_sts_cd", getTmlInvStsCd());		
		this.hashColumns.put("lea_cxl_flg", getLeaCxlFlg());		
		this.hashColumns.put("sto_dys_ind_cd", getStoDysIndCd());		
		this.hashColumns.put("hld_flg", getHldFlg());		
		this.hashColumns.put("ttl_inv_amt", getTtlInvAmt());		
		this.hashColumns.put("tml_so_ofc_cty_cd", getTmlSoOfcCtyCd());		
		this.hashColumns.put("ida_cgst_amt", getIdaCgstAmt());		
		this.hashColumns.put("ida_sgst_amt", getIdaSgstAmt());		
		this.hashColumns.put("ida_igst_amt", getIdaIgstAmt());		
		this.hashColumns.put("ida_ugst_amt", getIdaUgstAmt());		
		this.hashColumns.put("dbt_note_no", getDbtNoteNo());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("pay_dt", "payDt");
		this.hashFields.put("edi_flg", "ediFlg");
		this.hashFields.put("hpc_cre_flg", "hpcCreFlg");
		this.hashFields.put("tml_inv_tp_cd", "tmlInvTpCd");
		this.hashFields.put("ap_pay_dt", "apPayDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("tml_cost_grp_cd", "tmlCostGrpCd");
		this.hashFields.put("lea_cre_flg", "leaCreFlg");
		this.hashFields.put("ap_rvs_cng_flg", "apRvsCngFlg");
		this.hashFields.put("rcv_dt", "rcvDt");
		this.hashFields.put("pay_due_dt", "payDueDt");
		this.hashFields.put("tml_inv_rjct_sts_cd", "tmlInvRjctStsCd");
		this.hashFields.put("hpc_delt_flg", "hpcDeltFlg");
		this.hashFields.put("fm_prd_dt", "fmPrdDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("csr_no", "csrNo");
		this.hashFields.put("ap_cxl_dt", "apCxlDt");
		this.hashFields.put("inv_rjct_rmk", "invRjctRmk");
		this.hashFields.put("rtro_tml_inv_flg", "rtroTmlInvFlg");
		this.hashFields.put("whld_tax_amt", "whldTaxAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("tml_so_seq", "tmlSoSeq");
		this.hashFields.put("inv_rjct_dt", "invRjctDt");
		this.hashFields.put("locl_upd_dt", "loclUpdDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("err_inv_no", "errInvNo");
		this.hashFields.put("pay_flg", "payFlg");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("tml_calc_ind_cd", "tmlCalcIndCd");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ttl_calc_amt", "ttlCalcAmt");
		this.hashFields.put("ap_if_dt", "apIfDt");
		this.hashFields.put("inv_ofc_cd", "invOfcCd");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("cost_ofc_cd", "costOfcCd");
		this.hashFields.put("hpc_cxl_flg", "hpcCxlFlg");
		this.hashFields.put("inv_cfm_dt", "invCfmDt");
		this.hashFields.put("locl_cre_dt", "loclCreDt");
		this.hashFields.put("to_prd_dt", "toPrdDt");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("vat_amt", "vatAmt");
		this.hashFields.put("hld_rmk", "hldRmk");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("tml_inv_sts_cd", "tmlInvStsCd");
		this.hashFields.put("lea_cxl_flg", "leaCxlFlg");
		this.hashFields.put("sto_dys_ind_cd", "stoDysIndCd");
		this.hashFields.put("hld_flg", "hldFlg");
		this.hashFields.put("ttl_inv_amt", "ttlInvAmt");
		this.hashFields.put("tml_so_ofc_cty_cd", "tmlSoOfcCtyCd");
		this.hashFields.put("ida_cgst_amt", "idaCgstAmt");
		this.hashFields.put("ida_sgst_amt", "idaSgstAmt");
		this.hashFields.put("ida_igst_amt", "idaIgstAmt");
		this.hashFields.put("ida_ugst_amt", "idaUgstAmt");
		this.hashFields.put("dbt_note_no", "dbtNoteNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  payDt
	*/
	public void	setPayDt( String	payDt ) {
		this.payDt =	payDt;
	}
 
	/**
	 * Column Info
	 * @return	payDt
	 */
	 public	 String	getPayDt() {
		 return	this.payDt;
	 } 
 	/**
	* Column Info
	* @param  ediFlg
	*/
	public void	setEdiFlg( String	ediFlg ) {
		this.ediFlg =	ediFlg;
	}
 
	/**
	 * Column Info
	 * @return	ediFlg
	 */
	 public	 String	getEdiFlg() {
		 return	this.ediFlg;
	 } 
 	/**
	* Column Info
	* @param  hpcCreFlg
	*/
	public void	setHpcCreFlg( String	hpcCreFlg ) {
		this.hpcCreFlg =	hpcCreFlg;
	}
 
	/**
	 * Column Info
	 * @return	hpcCreFlg
	 */
	 public	 String	getHpcCreFlg() {
		 return	this.hpcCreFlg;
	 } 
 	/**
	* Column Info
	* @param  tmlInvTpCd
	*/
	public void	setTmlInvTpCd( String	tmlInvTpCd ) {
		this.tmlInvTpCd =	tmlInvTpCd;
	}
 
	/**
	 * Column Info
	 * @return	tmlInvTpCd
	 */
	 public	 String	getTmlInvTpCd() {
		 return	this.tmlInvTpCd;
	 } 
 	/**
	* Column Info
	* @param  apPayDt
	*/
	public void	setApPayDt( String	apPayDt ) {
		this.apPayDt =	apPayDt;
	}
 
	/**
	 * Column Info
	 * @return	apPayDt
	 */
	 public	 String	getApPayDt() {
		 return	this.apPayDt;
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
	* @param  tmlCostGrpCd
	*/
	public void	setTmlCostGrpCd( String	tmlCostGrpCd ) {
		this.tmlCostGrpCd =	tmlCostGrpCd;
	}
 
	/**
	 * Column Info
	 * @return	tmlCostGrpCd
	 */
	 public	 String	getTmlCostGrpCd() {
		 return	this.tmlCostGrpCd;
	 } 
 	/**
	* Column Info
	* @param  leaCreFlg
	*/
	public void	setLeaCreFlg( String	leaCreFlg ) {
		this.leaCreFlg =	leaCreFlg;
	}
 
	/**
	 * Column Info
	 * @return	leaCreFlg
	 */
	 public	 String	getLeaCreFlg() {
		 return	this.leaCreFlg;
	 } 
 	/**
	* Column Info
	* @param  apRvsCngFlg
	*/
	public void	setApRvsCngFlg( String	apRvsCngFlg ) {
		this.apRvsCngFlg =	apRvsCngFlg;
	}
 
	/**
	 * Column Info
	 * @return	apRvsCngFlg
	 */
	 public	 String	getApRvsCngFlg() {
		 return	this.apRvsCngFlg;
	 } 
 	/**
	* Column Info
	* @param  rcvDt
	*/
	public void	setRcvDt( String	rcvDt ) {
		this.rcvDt =	rcvDt;
	}
 
	/**
	 * Column Info
	 * @return	rcvDt
	 */
	 public	 String	getRcvDt() {
		 return	this.rcvDt;
	 } 
 	/**
	* Column Info
	* @param  payDueDt
	*/
	public void	setPayDueDt( String	payDueDt ) {
		this.payDueDt =	payDueDt;
	}
 
	/**
	 * Column Info
	 * @return	payDueDt
	 */
	 public	 String	getPayDueDt() {
		 return	this.payDueDt;
	 } 
 	/**
	* Column Info
	* @param  tmlInvRjctStsCd
	*/
	public void	setTmlInvRjctStsCd( String	tmlInvRjctStsCd ) {
		this.tmlInvRjctStsCd =	tmlInvRjctStsCd;
	}
 
	/**
	 * Column Info
	 * @return	tmlInvRjctStsCd
	 */
	 public	 String	getTmlInvRjctStsCd() {
		 return	this.tmlInvRjctStsCd;
	 } 
 	/**
	* Column Info
	* @param  hpcDeltFlg
	*/
	public void	setHpcDeltFlg( String	hpcDeltFlg ) {
		this.hpcDeltFlg =	hpcDeltFlg;
	}
 
	/**
	 * Column Info
	 * @return	hpcDeltFlg
	 */
	 public	 String	getHpcDeltFlg() {
		 return	this.hpcDeltFlg;
	 } 
 	/**
	* Column Info
	* @param  fmPrdDt
	*/
	public void	setFmPrdDt( String	fmPrdDt ) {
		this.fmPrdDt =	fmPrdDt;
	}
 
	/**
	 * Column Info
	 * @return	fmPrdDt
	 */
	 public	 String	getFmPrdDt() {
		 return	this.fmPrdDt;
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
	* @param  csrNo
	*/
	public void	setCsrNo( String	csrNo ) {
		this.csrNo =	csrNo;
	}
 
	/**
	 * Column Info
	 * @return	csrNo
	 */
	 public	 String	getCsrNo() {
		 return	this.csrNo;
	 } 
 	/**
	* Column Info
	* @param  apCxlDt
	*/
	public void	setApCxlDt( String	apCxlDt ) {
		this.apCxlDt =	apCxlDt;
	}
 
	/**
	 * Column Info
	 * @return	apCxlDt
	 */
	 public	 String	getApCxlDt() {
		 return	this.apCxlDt;
	 } 
 	/**
	* Column Info
	* @param  invRjctRmk
	*/
	public void	setInvRjctRmk( String	invRjctRmk ) {
		this.invRjctRmk =	invRjctRmk;
	}
 
	/**
	 * Column Info
	 * @return	invRjctRmk
	 */
	 public	 String	getInvRjctRmk() {
		 return	this.invRjctRmk;
	 } 
 	/**
	* Column Info
	* @param  rtroTmlInvFlg
	*/
	public void	setRtroTmlInvFlg( String	rtroTmlInvFlg ) {
		this.rtroTmlInvFlg =	rtroTmlInvFlg;
	}
 
	/**
	 * Column Info
	 * @return	rtroTmlInvFlg
	 */
	 public	 String	getRtroTmlInvFlg() {
		 return	this.rtroTmlInvFlg;
	 } 
 	/**
	* Column Info
	* @param  whldTaxAmt
	*/
	public void	setWhldTaxAmt( String	whldTaxAmt ) {
		this.whldTaxAmt =	whldTaxAmt;
	}
 
	/**
	 * Column Info
	 * @return	whldTaxAmt
	 */
	 public	 String	getWhldTaxAmt() {
		 return	this.whldTaxAmt;
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
	* @param  invRjctDt
	*/
	public void	setInvRjctDt( String	invRjctDt ) {
		this.invRjctDt =	invRjctDt;
	}
 
	/**
	 * Column Info
	 * @return	invRjctDt
	 */
	 public	 String	getInvRjctDt() {
		 return	this.invRjctDt;
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
	* @param  deltFlg
	*/
	public void	setDeltFlg( String	deltFlg ) {
		this.deltFlg =	deltFlg;
	}
 
	/**
	 * Column Info
	 * @return	deltFlg
	 */
	 public	 String	getDeltFlg() {
		 return	this.deltFlg;
	 } 
 	/**
	* Column Info
	* @param  errInvNo
	*/
	public void	setErrInvNo( String	errInvNo ) {
		this.errInvNo =	errInvNo;
	}
 
	/**
	 * Column Info
	 * @return	errInvNo
	 */
	 public	 String	getErrInvNo() {
		 return	this.errInvNo;
	 } 
 	/**
	* Column Info
	* @param  payFlg
	*/
	public void	setPayFlg( String	payFlg ) {
		this.payFlg =	payFlg;
	}
 
	/**
	 * Column Info
	 * @return	payFlg
	 */
	 public	 String	getPayFlg() {
		 return	this.payFlg;
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
	* @param  tmlCalcIndCd
	*/
	public void	setTmlCalcIndCd( String	tmlCalcIndCd ) {
		this.tmlCalcIndCd =	tmlCalcIndCd;
	}
 
	/**
	 * Column Info
	 * @return	tmlCalcIndCd
	 */
	 public	 String	getTmlCalcIndCd() {
		 return	this.tmlCalcIndCd;
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
	* @param  ttlCalcAmt
	*/
	public void	setTtlCalcAmt( String	ttlCalcAmt ) {
		this.ttlCalcAmt =	ttlCalcAmt;
	}
 
	/**
	 * Column Info
	 * @return	ttlCalcAmt
	 */
	 public	 String	getTtlCalcAmt() {
		 return	this.ttlCalcAmt;
	 } 
 	/**
	* Column Info
	* @param  apIfDt
	*/
	public void	setApIfDt( String	apIfDt ) {
		this.apIfDt =	apIfDt;
	}
 
	/**
	 * Column Info
	 * @return	apIfDt
	 */
	 public	 String	getApIfDt() {
		 return	this.apIfDt;
	 } 
 	/**
	* Column Info
	* @param  invOfcCd
	*/
	public void	setInvOfcCd( String	invOfcCd ) {
		this.invOfcCd =	invOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	invOfcCd
	 */
	 public	 String	getInvOfcCd() {
		 return	this.invOfcCd;
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
	* @param  costOfcCd
	*/
	public void	setCostOfcCd( String	costOfcCd ) {
		this.costOfcCd =	costOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	costOfcCd
	 */
	 public	 String	getCostOfcCd() {
		 return	this.costOfcCd;
	 } 
 	/**
	* Column Info
	* @param  hpcCxlFlg
	*/
	public void	setHpcCxlFlg( String	hpcCxlFlg ) {
		this.hpcCxlFlg =	hpcCxlFlg;
	}
 
	/**
	 * Column Info
	 * @return	hpcCxlFlg
	 */
	 public	 String	getHpcCxlFlg() {
		 return	this.hpcCxlFlg;
	 } 
 	/**
	* Column Info
	* @param  invCfmDt
	*/
	public void	setInvCfmDt( String	invCfmDt ) {
		this.invCfmDt =	invCfmDt;
	}
 
	/**
	 * Column Info
	 * @return	invCfmDt
	 */
	 public	 String	getInvCfmDt() {
		 return	this.invCfmDt;
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
	* @param  toPrdDt
	*/
	public void	setToPrdDt( String	toPrdDt ) {
		this.toPrdDt =	toPrdDt;
	}
 
	/**
	 * Column Info
	 * @return	toPrdDt
	 */
	 public	 String	getToPrdDt() {
		 return	this.toPrdDt;
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
	* @param  vatAmt
	*/
	public void	setVatAmt( String	vatAmt ) {
		this.vatAmt =	vatAmt;
	}
 
	/**
	 * Column Info
	 * @return	vatAmt
	 */
	 public	 String	getVatAmt() {
		 return	this.vatAmt;
	 } 
 	/**
	* Column Info
	* @param  hldRmk
	*/
	public void	setHldRmk( String	hldRmk ) {
		this.hldRmk =	hldRmk;
	}
 
	/**
	 * Column Info
	 * @return	hldRmk
	 */
	 public	 String	getHldRmk() {
		 return	this.hldRmk;
	 } 
 	/**
	* Column Info
	* @param  ydCd
	*/
	public void	setYdCd( String	ydCd ) {
		this.ydCd =	ydCd;
	}
 
	/**
	 * Column Info
	 * @return	ydCd
	 */
	 public	 String	getYdCd() {
		 return	this.ydCd;
	 } 
 	/**
	* Column Info
	* @param  tmlInvStsCd
	*/
	public void	setTmlInvStsCd( String	tmlInvStsCd ) {
		this.tmlInvStsCd =	tmlInvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	tmlInvStsCd
	 */
	 public	 String	getTmlInvStsCd() {
		 return	this.tmlInvStsCd;
	 } 
 	/**
	* Column Info
	* @param  leaCxlFlg
	*/
	public void	setLeaCxlFlg( String	leaCxlFlg ) {
		this.leaCxlFlg =	leaCxlFlg;
	}
 
	/**
	 * Column Info
	 * @return	leaCxlFlg
	 */
	 public	 String	getLeaCxlFlg() {
		 return	this.leaCxlFlg;
	 } 
 	/**
	* Column Info
	* @param  stoDysIndCd
	*/
	public void	setStoDysIndCd( String	stoDysIndCd ) {
		this.stoDysIndCd =	stoDysIndCd;
	}
 
	/**
	 * Column Info
	 * @return	stoDysIndCd
	 */
	 public	 String	getStoDysIndCd() {
		 return	this.stoDysIndCd;
	 } 
 	/**
	* Column Info
	* @param  hldFlg
	*/
	public void	setHldFlg( String	hldFlg ) {
		this.hldFlg =	hldFlg;
	}
 
	/**
	 * Column Info
	 * @return	hldFlg
	 */
	 public	 String	getHldFlg() {
		 return	this.hldFlg;
	 } 
 	/**
	* Column Info
	* @param  ttlInvAmt
	*/
	public void	setTtlInvAmt( String	ttlInvAmt ) {
		this.ttlInvAmt =	ttlInvAmt;
	}
 
	/**
	 * Column Info
	 * @return	ttlInvAmt
	 */
	 public	 String	getTtlInvAmt() {
		 return	this.ttlInvAmt;
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
	* @param  dbtNoteNo
	*/
	public void	setDbtNoteNo( String	dbtNoteNo ) {
		this.dbtNoteNo =	dbtNoteNo;
	}
 
	/**
	 * Column Info
	 * @return	dbtNoteNo
	 */
	 public	 String	getDbtNoteNo() {
		 return	this.dbtNoteNo;
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
		setPayDt(JSPUtil.getParameter(request,	prefix + "pay_dt", ""));
		setEdiFlg(JSPUtil.getParameter(request,	prefix + "edi_flg", ""));
		setHpcCreFlg(JSPUtil.getParameter(request,	prefix + "hpc_cre_flg", ""));
		setTmlInvTpCd(JSPUtil.getParameter(request,	prefix + "tml_inv_tp_cd", ""));
		setApPayDt(JSPUtil.getParameter(request,	prefix + "ap_pay_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setTmlCostGrpCd(JSPUtil.getParameter(request,	prefix + "tml_cost_grp_cd", ""));
		setLeaCreFlg(JSPUtil.getParameter(request,	prefix + "lea_cre_flg", ""));
		setApRvsCngFlg(JSPUtil.getParameter(request,	prefix + "ap_rvs_cng_flg", ""));
		setRcvDt(JSPUtil.getParameter(request,	prefix + "rcv_dt", ""));
		setPayDueDt(JSPUtil.getParameter(request,	prefix + "pay_due_dt", ""));
		setTmlInvRjctStsCd(JSPUtil.getParameter(request,	prefix + "tml_inv_rjct_sts_cd", ""));
		setHpcDeltFlg(JSPUtil.getParameter(request,	prefix + "hpc_delt_flg", ""));
		setFmPrdDt(JSPUtil.getParameter(request,	prefix + "fm_prd_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setCsrNo(JSPUtil.getParameter(request,	prefix + "csr_no", ""));
		setApCxlDt(JSPUtil.getParameter(request,	prefix + "ap_cxl_dt", ""));
		setInvRjctRmk(JSPUtil.getParameter(request,	prefix + "inv_rjct_rmk", ""));
		setRtroTmlInvFlg(JSPUtil.getParameter(request,	prefix + "rtro_tml_inv_flg", ""));
		setWhldTaxAmt(JSPUtil.getParameter(request,	prefix + "whld_tax_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setTmlSoSeq(JSPUtil.getParameter(request,	prefix + "tml_so_seq", ""));
		setInvRjctDt(JSPUtil.getParameter(request,	prefix + "inv_rjct_dt", ""));
		setLoclUpdDt(JSPUtil.getParameter(request,	prefix + "locl_upd_dt", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request,	prefix + "delt_flg", ""));
		setErrInvNo(JSPUtil.getParameter(request,	prefix + "err_inv_no", ""));
		setPayFlg(JSPUtil.getParameter(request,	prefix + "pay_flg", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setTmlCalcIndCd(JSPUtil.getParameter(request,	prefix + "tml_calc_ind_cd", ""));
		setIssDt(JSPUtil.getParameter(request,	prefix + "iss_dt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setTtlCalcAmt(JSPUtil.getParameter(request,	prefix + "ttl_calc_amt", ""));
		setApIfDt(JSPUtil.getParameter(request,	prefix + "ap_if_dt", ""));
		setInvOfcCd(JSPUtil.getParameter(request,	prefix + "inv_ofc_cd", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCostOfcCd(JSPUtil.getParameter(request,	prefix + "cost_ofc_cd", ""));
		setHpcCxlFlg(JSPUtil.getParameter(request,	prefix + "hpc_cxl_flg", ""));
		setInvCfmDt(JSPUtil.getParameter(request,	prefix + "inv_cfm_dt", ""));
		setLoclCreDt(JSPUtil.getParameter(request,	prefix + "locl_cre_dt", ""));
		setToPrdDt(JSPUtil.getParameter(request,	prefix + "to_prd_dt", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setVatAmt(JSPUtil.getParameter(request,	prefix + "vat_amt", ""));
		setHldRmk(JSPUtil.getParameter(request,	prefix + "hld_rmk", ""));
		setYdCd(JSPUtil.getParameter(request,	prefix + "yd_cd", ""));
		setTmlInvStsCd(JSPUtil.getParameter(request,	prefix + "tml_inv_sts_cd", ""));
		setLeaCxlFlg(JSPUtil.getParameter(request,	prefix + "lea_cxl_flg", ""));
		setStoDysIndCd(JSPUtil.getParameter(request,	prefix + "sto_dys_ind_cd", ""));
		setHldFlg(JSPUtil.getParameter(request,	prefix + "hld_flg", ""));
		setTtlInvAmt(JSPUtil.getParameter(request,	prefix + "ttl_inv_amt", ""));
		setTmlSoOfcCtyCd(JSPUtil.getParameter(request,	prefix + "tml_so_ofc_cty_cd", ""));
		setIdaCgstAmt(JSPUtil.getParameter(request,	prefix + "ida_cgst_amt", ""));
		setIdaSgstAmt(JSPUtil.getParameter(request,	prefix + "ida_sgst_amt", ""));
		setIdaIgstAmt(JSPUtil.getParameter(request,	prefix + "ida_igst_amt", ""));
		setIdaUgstAmt(JSPUtil.getParameter(request,	prefix + "ida_ugst_amt", ""));
		setDbtNoteNo(JSPUtil.getParameter(request,	prefix + "dbt_note_no", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return TesTmlSoHdrVO[]
	 */
	public TesTmlSoHdrVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return TesTmlSoHdrVO[]
	 */
	public TesTmlSoHdrVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		TesTmlSoHdrVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] payDt =	(JSPUtil.getParameter(request, prefix +	"pay_dt".trim(),	length));
				String[] ediFlg =	(JSPUtil.getParameter(request, prefix +	"edi_flg".trim(),	length));
				String[] hpcCreFlg =	(JSPUtil.getParameter(request, prefix +	"hpc_cre_flg".trim(),	length));
				String[] tmlInvTpCd =	(JSPUtil.getParameter(request, prefix +	"tml_inv_tp_cd".trim(),	length));
				String[] apPayDt =	(JSPUtil.getParameter(request, prefix +	"ap_pay_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt".trim(),	length));
				String[] tmlCostGrpCd =	(JSPUtil.getParameter(request, prefix +	"tml_cost_grp_cd".trim(),	length));
				String[] leaCreFlg =	(JSPUtil.getParameter(request, prefix +	"lea_cre_flg".trim(),	length));
				String[] apRvsCngFlg =	(JSPUtil.getParameter(request, prefix +	"ap_rvs_cng_flg".trim(),	length));
				String[] rcvDt =	(JSPUtil.getParameter(request, prefix +	"rcv_dt".trim(),	length));
				String[] payDueDt =	(JSPUtil.getParameter(request, prefix +	"pay_due_dt".trim(),	length));
				String[] tmlInvRjctStsCd =	(JSPUtil.getParameter(request, prefix +	"tml_inv_rjct_sts_cd".trim(),	length));
				String[] hpcDeltFlg =	(JSPUtil.getParameter(request, prefix +	"hpc_delt_flg".trim(),	length));
				String[] fmPrdDt =	(JSPUtil.getParameter(request, prefix +	"fm_prd_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] csrNo =	(JSPUtil.getParameter(request, prefix +	"csr_no".trim(),	length));
				String[] apCxlDt =	(JSPUtil.getParameter(request, prefix +	"ap_cxl_dt".trim(),	length));
				String[] invRjctRmk =	(JSPUtil.getParameter(request, prefix +	"inv_rjct_rmk".trim(),	length));
				String[] rtroTmlInvFlg =	(JSPUtil.getParameter(request, prefix +	"rtro_tml_inv_flg".trim(),	length));
				String[] whldTaxAmt =	(JSPUtil.getParameter(request, prefix +	"whld_tax_amt".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] tmlSoSeq =	(JSPUtil.getParameter(request, prefix +	"tml_so_seq".trim(),	length));
				String[] invRjctDt =	(JSPUtil.getParameter(request, prefix +	"inv_rjct_dt".trim(),	length));
				String[] loclUpdDt =	(JSPUtil.getParameter(request, prefix +	"locl_upd_dt".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] deltFlg =	(JSPUtil.getParameter(request, prefix +	"delt_flg".trim(),	length));
				String[] errInvNo =	(JSPUtil.getParameter(request, prefix +	"err_inv_no".trim(),	length));
				String[] payFlg =	(JSPUtil.getParameter(request, prefix +	"pay_flg".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] tmlCalcIndCd =	(JSPUtil.getParameter(request, prefix +	"tml_calc_ind_cd".trim(),	length));
				String[] issDt =	(JSPUtil.getParameter(request, prefix +	"iss_dt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] ttlCalcAmt =	(JSPUtil.getParameter(request, prefix +	"ttl_calc_amt".trim(),	length));
				String[] apIfDt =	(JSPUtil.getParameter(request, prefix +	"ap_if_dt".trim(),	length));
				String[] invOfcCd =	(JSPUtil.getParameter(request, prefix +	"inv_ofc_cd".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] costOfcCd =	(JSPUtil.getParameter(request, prefix +	"cost_ofc_cd".trim(),	length));
				String[] hpcCxlFlg =	(JSPUtil.getParameter(request, prefix +	"hpc_cxl_flg".trim(),	length));
				String[] invCfmDt =	(JSPUtil.getParameter(request, prefix +	"inv_cfm_dt".trim(),	length));
				String[] loclCreDt =	(JSPUtil.getParameter(request, prefix +	"locl_cre_dt".trim(),	length));
				String[] toPrdDt =	(JSPUtil.getParameter(request, prefix +	"to_prd_dt".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] vatAmt =	(JSPUtil.getParameter(request, prefix +	"vat_amt".trim(),	length));
				String[] hldRmk =	(JSPUtil.getParameter(request, prefix +	"hld_rmk".trim(),	length));
				String[] ydCd =	(JSPUtil.getParameter(request, prefix +	"yd_cd".trim(),	length));
				String[] tmlInvStsCd =	(JSPUtil.getParameter(request, prefix +	"tml_inv_sts_cd".trim(),	length));
				String[] leaCxlFlg =	(JSPUtil.getParameter(request, prefix +	"lea_cxl_flg".trim(),	length));
				String[] stoDysIndCd =	(JSPUtil.getParameter(request, prefix +	"sto_dys_ind_cd".trim(),	length));
				String[] hldFlg =	(JSPUtil.getParameter(request, prefix +	"hld_flg".trim(),	length));
				String[] ttlInvAmt =	(JSPUtil.getParameter(request, prefix +	"ttl_inv_amt".trim(),	length));
				String[] tmlSoOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"tml_so_ofc_cty_cd".trim(),	length));
				String[] idaCgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_cgst_amt".trim(),	length));
				String[] idaSgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_sgst_amt".trim(),	length));
				String[] idaIgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_igst_amt".trim(),	length));
				String[] idaUgstAmt =	(JSPUtil.getParameter(request, prefix +	"ida_ugst_amt".trim(),	length));
				String[] dbtNoteNo =	(JSPUtil.getParameter(request, prefix +	"dbt_note_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	TesTmlSoHdrVO();
						if ( payDt[i] !=	null)
						model.setPayDt( payDt[i]);
						if ( ediFlg[i] !=	null)
						model.setEdiFlg( ediFlg[i]);
						if ( hpcCreFlg[i] !=	null)
						model.setHpcCreFlg( hpcCreFlg[i]);
						if ( tmlInvTpCd[i] !=	null)
						model.setTmlInvTpCd( tmlInvTpCd[i]);
						if ( apPayDt[i] !=	null)
						model.setApPayDt( apPayDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( effDt[i] !=	null)
						model.setEffDt( effDt[i]);
						if ( tmlCostGrpCd[i] !=	null)
						model.setTmlCostGrpCd( tmlCostGrpCd[i]);
						if ( leaCreFlg[i] !=	null)
						model.setLeaCreFlg( leaCreFlg[i]);
						if ( apRvsCngFlg[i] !=	null)
						model.setApRvsCngFlg( apRvsCngFlg[i]);
						if ( rcvDt[i] !=	null)
						model.setRcvDt( rcvDt[i]);
						if ( payDueDt[i] !=	null)
						model.setPayDueDt( payDueDt[i]);
						if ( tmlInvRjctStsCd[i] !=	null)
						model.setTmlInvRjctStsCd( tmlInvRjctStsCd[i]);
						if ( hpcDeltFlg[i] !=	null)
						model.setHpcDeltFlg( hpcDeltFlg[i]);
						if ( fmPrdDt[i] !=	null)
						model.setFmPrdDt( fmPrdDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( csrNo[i] !=	null)
						model.setCsrNo( csrNo[i]);
						if ( apCxlDt[i] !=	null)
						model.setApCxlDt( apCxlDt[i]);
						if ( invRjctRmk[i] !=	null)
						model.setInvRjctRmk( invRjctRmk[i]);
						if ( rtroTmlInvFlg[i] !=	null)
						model.setRtroTmlInvFlg( rtroTmlInvFlg[i]);
						if ( whldTaxAmt[i] !=	null)
						model.setWhldTaxAmt( whldTaxAmt[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( tmlSoSeq[i] !=	null)
						model.setTmlSoSeq( tmlSoSeq[i]);
						if ( invRjctDt[i] !=	null)
						model.setInvRjctDt( invRjctDt[i]);
						if ( loclUpdDt[i] !=	null)
						model.setLoclUpdDt( loclUpdDt[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( deltFlg[i] !=	null)
						model.setDeltFlg( deltFlg[i]);
						if ( errInvNo[i] !=	null)
						model.setErrInvNo( errInvNo[i]);
						if ( payFlg[i] !=	null)
						model.setPayFlg( payFlg[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( tmlCalcIndCd[i] !=	null)
						model.setTmlCalcIndCd( tmlCalcIndCd[i]);
						if ( issDt[i] !=	null)
						model.setIssDt( issDt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( ttlCalcAmt[i] !=	null)
						model.setTtlCalcAmt( ttlCalcAmt[i]);
						if ( apIfDt[i] !=	null)
						model.setApIfDt( apIfDt[i]);
						if ( invOfcCd[i] !=	null)
						model.setInvOfcCd( invOfcCd[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( costOfcCd[i] !=	null)
						model.setCostOfcCd( costOfcCd[i]);
						if ( hpcCxlFlg[i] !=	null)
						model.setHpcCxlFlg( hpcCxlFlg[i]);
						if ( invCfmDt[i] !=	null)
						model.setInvCfmDt( invCfmDt[i]);
						if ( loclCreDt[i] !=	null)
						model.setLoclCreDt( loclCreDt[i]);
						if ( toPrdDt[i] !=	null)
						model.setToPrdDt( toPrdDt[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( vatAmt[i] !=	null)
						model.setVatAmt( vatAmt[i]);
						if ( hldRmk[i] !=	null)
						model.setHldRmk( hldRmk[i]);
						if ( ydCd[i] !=	null)
						model.setYdCd( ydCd[i]);
						if ( tmlInvStsCd[i] !=	null)
						model.setTmlInvStsCd( tmlInvStsCd[i]);
						if ( leaCxlFlg[i] !=	null)
						model.setLeaCxlFlg( leaCxlFlg[i]);
						if ( stoDysIndCd[i] !=	null)
						model.setStoDysIndCd( stoDysIndCd[i]);
						if ( hldFlg[i] !=	null)
						model.setHldFlg( hldFlg[i]);
						if ( ttlInvAmt[i] !=	null)
						model.setTtlInvAmt( ttlInvAmt[i]);
						if ( tmlSoOfcCtyCd[i] !=	null)
						model.setTmlSoOfcCtyCd( tmlSoOfcCtyCd[i]);
						if ( idaCgstAmt[i] !=	null)
						model.setIdaCgstAmt( idaCgstAmt[i]);
						if ( idaSgstAmt[i] !=	null)
						model.setIdaSgstAmt( idaSgstAmt[i]);
						if ( idaIgstAmt[i] !=	null)
						model.setIdaIgstAmt( idaIgstAmt[i]);
						if ( idaUgstAmt[i] !=	null)
						model.setIdaUgstAmt( idaUgstAmt[i]);
						if ( dbtNoteNo[i] !=	null)
						model.setDbtNoteNo( dbtNoteNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getTesTmlSoHdrVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return TesTmlSoHdrVO[]
	 */
	public TesTmlSoHdrVO[]	 getTesTmlSoHdrVOs(){
		TesTmlSoHdrVO[] vos = (TesTmlSoHdrVO[])models.toArray(new	TesTmlSoHdrVO[models.size()]);
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
		this.payDt =	this.payDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediFlg =	this.ediFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hpcCreFlg =	this.hpcCreFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvTpCd =	this.tmlInvTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apPayDt =	this.apPayDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCostGrpCd =	this.tmlCostGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leaCreFlg =	this.leaCreFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apRvsCngFlg =	this.apRvsCngFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDt =	this.rcvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payDueDt =	this.payDueDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvRjctStsCd =	this.tmlInvRjctStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hpcDeltFlg =	this.hpcDeltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmPrdDt =	this.fmPrdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo =	this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCxlDt =	this.apCxlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRjctRmk =	this.invRjctRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtroTmlInvFlg =	this.rtroTmlInvFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.whldTaxAmt =	this.whldTaxAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoSeq =	this.tmlSoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invRjctDt =	this.invRjctDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclUpdDt =	this.loclUpdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg =	this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errInvNo =	this.errInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payFlg =	this.payFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlCalcIndCd =	this.tmlCalcIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt =	this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCalcAmt =	this.ttlCalcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apIfDt =	this.apIfDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invOfcCd =	this.invOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costOfcCd =	this.costOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hpcCxlFlg =	this.hpcCxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCfmDt =	this.invCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclCreDt =	this.loclCreDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toPrdDt =	this.toPrdDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vatAmt =	this.vatAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldRmk =	this.hldRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd =	this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlInvStsCd =	this.tmlInvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.leaCxlFlg =	this.leaCxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoDysIndCd =	this.stoDysIndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hldFlg =	this.hldFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlInvAmt =	this.ttlInvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmlSoOfcCtyCd =	this.tmlSoOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaCgstAmt =	this.idaCgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaSgstAmt =	this.idaSgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaIgstAmt =	this.idaIgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.idaUgstAmt =	this.idaUgstAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dbtNoteNo =	this.dbtNoteNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}