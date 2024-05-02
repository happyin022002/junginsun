/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : TotalLossPerformanceVO.java
 *@FileTitle : TotalLossPerformanceVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.13
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.11.13  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mnr.reportmanage.performancereport.vo;

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
public class TotalLossPerformanceVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<TotalLossPerformanceVO>  models =	new	ArrayList<TotalLossPerformanceVO>();


	/*	Column Info	*/
	private  String	 dvExp   =  null;
	/*	Column Info	*/
	private  String	 dsEqQty   =  null;
	/*	Column Info	*/
	private  String	 cltAmt   =  null;
	/*	Column Info	*/
	private  String	 irDvVal   =  null;
	/*	Column Info	*/
	private  String	 dsExp   =  null;
	/*	Column Info	*/
	private  String	 ttlLssNo   =  null;
	/*	Column Info	*/
	private  String	 dvEqQty   =  null;
	/*	Column Info	*/
	private  String	 mnrStsRefNo   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 aproOfcCd   =  null;
	/*	Column Info	*/
	private  String	 tpDvVal   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ttlLssCfmDt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 dsDvVal   =  null;
	/*	Column Info	*/
	private  String	 scBal   =  null;
	/*	Column Info	*/
	private  String	 tpEqQty   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 ttlLssCfmId   =  null;
	/*	Column Info	*/
	private  String	 rqstDt   =  null;
	/*	Column Info	*/
	private  String	 scExp   =  null;
	/*	Column Info	*/
	private  String	 ttlLssRsnNm   =  null;
	/*	Column Info	*/
	private  String	 scDvVal   =  null;
	/*	Column Info	*/
	private  String	 tpExp   =  null;
	/*	Column Info	*/
	private  String	 ttlLssDtlRsnNm   =  null;
	/*	Column Info	*/
	private  String	 irEqQty   =  null;
	/*	Column Info	*/
	private  String	 tpBal   =  null;
	/*	Column Info	*/
	private  String	 irBal   =  null;
	/*	Column Info	*/
	private  String	 ttlLssStsNm   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 dvBal   =  null;
	/*	Column Info	*/
	private  String	 irExp   =  null;
	/*	Column Info	*/
	private  String	 scEqQty   =  null;
	/*	Column Info	*/
	private  String	 ttlLssDt   =  null;
	/*	Column Info	*/
	private  String	 rqstOfcCd   =  null;
	/*	Column Info	*/
	private  String	 ttlLssDtlRsnCd   =  null;
	/*	Column Info	*/
	private  String	 ttlLssRmk   =  null;
	/*	Column Info	*/
	private  String	 dsBal   =  null;
	/*	Column Info	*/
	private  String	 fileSeq   =  null;
	/*	Column Info	*/
	private  String	 ttlLssRsnCd   =  null;
	/*	Column Info	*/
	private  String	 respbOfcCd   =  null;
	/*	Column Info	*/
	private  String	 ttlLssCmplNm   =  null;
	/*	Column Info	*/
	private  String	 ttlLssStsCd   =  null;
	/*	Column Info	*/
	private  String	 dvDvVal   =  null;
	/*	Column Info	*/
	private  String	 tmpseq   =  null;
	/*	Column Info	*/
	private  String	 rqstEqNo   =  null;
	/*	Column Info	*/
	private  String	 ttlLssDtlCmplNm   =  null;
	/*	Column Info	*/
	private  String	 ttlLssDtlCmplDt   =  null;
	/*	Column Info	*/
	private  String	 ttlLssN3ptyTpCd   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 lessorNm   =  null;
	/*	Column Info	*/
	private  String	 eqTpszCd   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblNm   =  null;
	/*	Column Info	*/
	private  String	 dvRecovery   =  null;
	/*	Column Info	*/
	private  String	 dvBalance   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblTp   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblVal   =  null;
	/*	Column Info	*/
	private  String	 ctrtNo   =  null;
	/*	Column Info	*/
	private  String	 dvCurrCd   =  null;
	/*	Column Info	*/
	private  String	 tpCurrCd   =  null;
	/*	Column Info	*/
	private  String	 dsCurrCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public TotalLossPerformanceVO(){}

	public TotalLossPerformanceVO(String dvExp,String dsEqQty,String cltAmt,String irDvVal,String dsExp,String ttlLssNo,String dvEqQty,String mnrStsRefNo,String creDt,String aproOfcCd,String tpDvVal,String pagerows,String ttlLssCfmDt,String ibflag,String dsDvVal,String scBal,String tpEqQty,String updUsrId,String updDt,String ttlLssCfmId,String rqstDt,String scExp,String ttlLssRsnNm,String scDvVal,String tpExp,String ttlLssDtlRsnNm,String irEqQty,String tpBal,String irBal,String ttlLssStsNm,String creUsrId,String dvBal,String irExp,String scEqQty,String ttlLssDt,String rqstOfcCd,String ttlLssDtlRsnCd,String ttlLssRmk,String dsBal,String fileSeq,String ttlLssRsnCd,String respbOfcCd,String ttlLssCmplNm,String ttlLssStsCd,String dvDvVal,String tmpseq,String rqstEqNo,String ttlLssDtlCmplNm,String ttlLssDtlCmplDt,String ttlLssN3ptyTpCd,String agmtSeq,String crntYdCd,String lessorNm,String eqTpszCd,String rstrUsgLblNm,String dvRecovery,String dvBalance,String rstrUsgLblTp,String rstrUsgLblVal, String ctrtNo, String dvCurrCd, String tpCurrCd, String dsCurrCd)	{
		this.dvExp  = dvExp ;
		this.dsEqQty  = dsEqQty ;
		this.cltAmt  = cltAmt ;
		this.irDvVal  = irDvVal ;
		this.dsExp  = dsExp ;
		this.ttlLssNo  = ttlLssNo ;
		this.dvEqQty  = dvEqQty ;
		this.mnrStsRefNo  = mnrStsRefNo ;
		this.creDt  = creDt ;
		this.aproOfcCd  = aproOfcCd ;
		this.tpDvVal  = tpDvVal ;
		this.pagerows  = pagerows ;
		this.ttlLssCfmDt  = ttlLssCfmDt ;
		this.ibflag  = ibflag ;
		this.dsDvVal  = dsDvVal ;
		this.scBal  = scBal ;
		this.tpEqQty  = tpEqQty ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.ttlLssCfmId  = ttlLssCfmId ;
		this.rqstDt  = rqstDt ;
		this.scExp  = scExp ;
		this.ttlLssRsnNm  = ttlLssRsnNm ;
		this.scDvVal  = scDvVal ;
		this.tpExp  = tpExp ;
		this.ttlLssDtlRsnNm  = ttlLssDtlRsnNm ;
		this.irEqQty  = irEqQty ;
		this.tpBal  = tpBal ;
		this.irBal  = irBal ;
		this.ttlLssStsNm  = ttlLssStsNm ;
		this.creUsrId  = creUsrId ;
		this.dvBal  = dvBal ;
		this.irExp  = irExp ;
		this.scEqQty  = scEqQty ;
		this.ttlLssDt  = ttlLssDt ;
		this.rqstOfcCd  = rqstOfcCd ;
		this.ttlLssDtlRsnCd  = ttlLssDtlRsnCd ;
		this.ttlLssRmk  = ttlLssRmk ;
		this.dsBal  = dsBal ;
		this.fileSeq  = fileSeq ;
		this.ttlLssRsnCd  = ttlLssRsnCd ;
		this.respbOfcCd  = respbOfcCd ;
		this.ttlLssCmplNm  = ttlLssCmplNm ;
		this.ttlLssStsCd  = ttlLssStsCd ;
		this.dvDvVal  = dvDvVal ;
		this.tmpseq  = tmpseq ;
		this.rqstEqNo  = rqstEqNo ;
		this.ttlLssDtlCmplNm  = ttlLssDtlCmplNm ;
		this.ttlLssDtlCmplDt  = ttlLssDtlCmplDt ;
		this.ttlLssN3ptyTpCd  = ttlLssN3ptyTpCd ;
		this.agmtSeq  = agmtSeq ;
		this.crntYdCd  = crntYdCd ;
		this.lessorNm  = lessorNm ;
		this.eqTpszCd  = eqTpszCd ;
		this.rstrUsgLblNm  = rstrUsgLblNm ;
		this.dvRecovery  = dvRecovery ;
		this.dvBalance  = dvBalance ;
		this.rstrUsgLblTp = rstrUsgLblTp;
		this.rstrUsgLblVal = rstrUsgLblVal;
		this.ctrtNo = ctrtNo;
		this.dvCurrCd = dvCurrCd;
		this.tpCurrCd = tpCurrCd;
		this.dsCurrCd = dsCurrCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dv_exp", getDvExp());		
		this.hashColumns.put("ds_eq_qty", getDsEqQty());		
		this.hashColumns.put("clt_amt", getCltAmt());		
		this.hashColumns.put("ir_dv_val", getIrDvVal());		
		this.hashColumns.put("ds_exp", getDsExp());		
		this.hashColumns.put("ttl_lss_no", getTtlLssNo());		
		this.hashColumns.put("dv_eq_qty", getDvEqQty());		
		this.hashColumns.put("mnr_sts_ref_no", getMnrStsRefNo());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());		
		this.hashColumns.put("tp_dv_val", getTpDvVal());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ttl_lss_cfm_dt", getTtlLssCfmDt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ds_dv_val", getDsDvVal());		
		this.hashColumns.put("sc_bal", getScBal());		
		this.hashColumns.put("tp_eq_qty", getTpEqQty());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("ttl_lss_cfm_id", getTtlLssCfmId());		
		this.hashColumns.put("rqst_dt", getRqstDt());		
		this.hashColumns.put("sc_exp", getScExp());		
		this.hashColumns.put("ttl_lss_rsn_nm", getTtlLssRsnNm());		
		this.hashColumns.put("sc_dv_val", getScDvVal());		
		this.hashColumns.put("tp_exp", getTpExp());		
		this.hashColumns.put("ttl_lss_dtl_rsn_nm", getTtlLssDtlRsnNm());		
		this.hashColumns.put("ir_eq_qty", getIrEqQty());		
		this.hashColumns.put("tp_bal", getTpBal());		
		this.hashColumns.put("ir_bal", getIrBal());		
		this.hashColumns.put("ttl_lss_sts_nm", getTtlLssStsNm());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("dv_bal", getDvBal());		
		this.hashColumns.put("ir_exp", getIrExp());		
		this.hashColumns.put("sc_eq_qty", getScEqQty());		
		this.hashColumns.put("ttl_lss_dt", getTtlLssDt());		
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());		
		this.hashColumns.put("ttl_lss_dtl_rsn_cd", getTtlLssDtlRsnCd());		
		this.hashColumns.put("ttl_lss_rmk", getTtlLssRmk());		
		this.hashColumns.put("ds_bal", getDsBal());		
		this.hashColumns.put("file_seq", getFileSeq());		
		this.hashColumns.put("ttl_lss_rsn_cd", getTtlLssRsnCd());		
		this.hashColumns.put("respb_ofc_cd", getRespbOfcCd());		
		this.hashColumns.put("ttl_lss_cmpl_nm", getTtlLssCmplNm());		
		this.hashColumns.put("ttl_lss_sts_cd", getTtlLssStsCd());		
		this.hashColumns.put("dv_dv_val", getDvDvVal());		
		this.hashColumns.put("tmpseq", getTmpseq());		
		this.hashColumns.put("rqst_eq_no", getRqstEqNo());		
		this.hashColumns.put("ttl_lss_dtl_cmpl_nm", getTtlLssDtlCmplNm());		
		this.hashColumns.put("ttl_lss_dtl_cmpl_dt", getTtlLssDtlCmplDt());		
		this.hashColumns.put("ttl_lss_n3pty_tp_cd", getTtlLssN3ptyTpCd());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("lessor_nm", getLessorNm());		
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());		
		this.hashColumns.put("rstr_usg_lbl_nm", getRstrUsgLblNm());		
		this.hashColumns.put("dv_recovery", getDvRecovery());		
		this.hashColumns.put("dv_balance", getDvBalance());	
		this.hashColumns.put("rstr_usg_lbl_tp", getRstrUsgLblTp());
		this.hashColumns.put("rstr_usg_lbl_val", getRstrUsgLblVal());
		this.hashColumns.put("ctrt_no", getCtrtNo());
		this.hashColumns.put("dv_curr_cd", getDvCurrCd());
		this.hashColumns.put("tp_curr_cd", getTpCurrCd());
		this.hashColumns.put("ds_curr_cd", getDsCurrCd());
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("dv_exp", "dvExp");
		this.hashFields.put("ds_eq_qty", "dsEqQty");
		this.hashFields.put("clt_amt", "cltAmt");
		this.hashFields.put("ir_dv_val", "irDvVal");
		this.hashFields.put("ds_exp", "dsExp");
		this.hashFields.put("ttl_lss_no", "ttlLssNo");
		this.hashFields.put("dv_eq_qty", "dvEqQty");
		this.hashFields.put("mnr_sts_ref_no", "mnrStsRefNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("tp_dv_val", "tpDvVal");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ttl_lss_cfm_dt", "ttlLssCfmDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ds_dv_val", "dsDvVal");
		this.hashFields.put("sc_bal", "scBal");
		this.hashFields.put("tp_eq_qty", "tpEqQty");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ttl_lss_cfm_id", "ttlLssCfmId");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("sc_exp", "scExp");
		this.hashFields.put("ttl_lss_rsn_nm", "ttlLssRsnNm");
		this.hashFields.put("sc_dv_val", "scDvVal");
		this.hashFields.put("tp_exp", "tpExp");
		this.hashFields.put("ttl_lss_dtl_rsn_nm", "ttlLssDtlRsnNm");
		this.hashFields.put("ir_eq_qty", "irEqQty");
		this.hashFields.put("tp_bal", "tpBal");
		this.hashFields.put("ir_bal", "irBal");
		this.hashFields.put("ttl_lss_sts_nm", "ttlLssStsNm");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dv_bal", "dvBal");
		this.hashFields.put("ir_exp", "irExp");
		this.hashFields.put("sc_eq_qty", "scEqQty");
		this.hashFields.put("ttl_lss_dt", "ttlLssDt");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		this.hashFields.put("ttl_lss_dtl_rsn_cd", "ttlLssDtlRsnCd");
		this.hashFields.put("ttl_lss_rmk", "ttlLssRmk");
		this.hashFields.put("ds_bal", "dsBal");
		this.hashFields.put("file_seq", "fileSeq");
		this.hashFields.put("ttl_lss_rsn_cd", "ttlLssRsnCd");
		this.hashFields.put("respb_ofc_cd", "respbOfcCd");
		this.hashFields.put("ttl_lss_cmpl_nm", "ttlLssCmplNm");
		this.hashFields.put("ttl_lss_sts_cd", "ttlLssStsCd");
		this.hashFields.put("dv_dv_val", "dvDvVal");
		this.hashFields.put("tmpseq", "tmpseq");
		this.hashFields.put("rqst_eq_no", "rqstEqNo");
		this.hashFields.put("ttl_lss_dtl_cmpl_nm", "ttlLssDtlCmplNm");
		this.hashFields.put("ttl_lss_dtl_cmpl_dt", "ttlLssDtlCmplDt");
		this.hashFields.put("ttl_lss_n3pty_tp_cd", "ttlLssN3ptyTpCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("lessor_nm", "lessorNm");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		this.hashFields.put("rstr_usg_lbl_nm", "rstrUsgLblNm");
		this.hashFields.put("dv_recovery", "dvRecovery");
		this.hashFields.put("dv_balance", "dvBalance");
		this.hashFields.put("rstr_usg_lbl_tp", "rstrUsgLblTp");
		this.hashFields.put("rstr_usg_lbl_val", "rstrUsgLblVal");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("dv_curr_cd", "dvCurrCd");
		this.hashFields.put("tp_curr_cd", "tpCurrCd");
		this.hashFields.put("ds_curr_cd", "dsCurrCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  dvExp
	*/
	public void	setDvExp( String	dvExp ) {
		this.dvExp =	dvExp;
	}
 
	/**
	 * Column Info
	 * @return	dvExp
	 */
	 public	 String	getDvExp() {
		 return	this.dvExp;
	 } 
 	/**
	* Column Info
	* @param  dsEqQty
	*/
	public void	setDsEqQty( String	dsEqQty ) {
		this.dsEqQty =	dsEqQty;
	}
 
	/**
	 * Column Info
	 * @return	dsEqQty
	 */
	 public	 String	getDsEqQty() {
		 return	this.dsEqQty;
	 } 
 	/**
	* Column Info
	* @param  cltAmt
	*/
	public void	setCltAmt( String	cltAmt ) {
		this.cltAmt =	cltAmt;
	}
 
	/**
	 * Column Info
	 * @return	cltAmt
	 */
	 public	 String	getCltAmt() {
		 return	this.cltAmt;
	 } 
 	/**
	* Column Info
	* @param  irDvVal
	*/
	public void	setIrDvVal( String	irDvVal ) {
		this.irDvVal =	irDvVal;
	}
 
	/**
	 * Column Info
	 * @return	irDvVal
	 */
	 public	 String	getIrDvVal() {
		 return	this.irDvVal;
	 } 
 	/**
	* Column Info
	* @param  dsExp
	*/
	public void	setDsExp( String	dsExp ) {
		this.dsExp =	dsExp;
	}
 
	/**
	 * Column Info
	 * @return	dsExp
	 */
	 public	 String	getDsExp() {
		 return	this.dsExp;
	 } 
 	/**
	* Column Info
	* @param  ttlLssNo
	*/
	public void	setTtlLssNo( String	ttlLssNo ) {
		this.ttlLssNo =	ttlLssNo;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssNo
	 */
	 public	 String	getTtlLssNo() {
		 return	this.ttlLssNo;
	 } 
 	/**
	* Column Info
	* @param  dvEqQty
	*/
	public void	setDvEqQty( String	dvEqQty ) {
		this.dvEqQty =	dvEqQty;
	}
 
	/**
	 * Column Info
	 * @return	dvEqQty
	 */
	 public	 String	getDvEqQty() {
		 return	this.dvEqQty;
	 } 
 	/**
	* Column Info
	* @param  mnrStsRefNo
	*/
	public void	setMnrStsRefNo( String	mnrStsRefNo ) {
		this.mnrStsRefNo =	mnrStsRefNo;
	}
 
	/**
	 * Column Info
	 * @return	mnrStsRefNo
	 */
	 public	 String	getMnrStsRefNo() {
		 return	this.mnrStsRefNo;
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
	* @param  aproOfcCd
	*/
	public void	setAproOfcCd( String	aproOfcCd ) {
		this.aproOfcCd =	aproOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	aproOfcCd
	 */
	 public	 String	getAproOfcCd() {
		 return	this.aproOfcCd;
	 } 
 	/**
	* Column Info
	* @param  tpDvVal
	*/
	public void	setTpDvVal( String	tpDvVal ) {
		this.tpDvVal =	tpDvVal;
	}
 
	/**
	 * Column Info
	 * @return	tpDvVal
	 */
	 public	 String	getTpDvVal() {
		 return	this.tpDvVal;
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
	* @param  ttlLssCfmDt
	*/
	public void	setTtlLssCfmDt( String	ttlLssCfmDt ) {
		this.ttlLssCfmDt =	ttlLssCfmDt;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssCfmDt
	 */
	 public	 String	getTtlLssCfmDt() {
		 return	this.ttlLssCfmDt;
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
	* @param  dsDvVal
	*/
	public void	setDsDvVal( String	dsDvVal ) {
		this.dsDvVal =	dsDvVal;
	}
 
	/**
	 * Column Info
	 * @return	dsDvVal
	 */
	 public	 String	getDsDvVal() {
		 return	this.dsDvVal;
	 } 
 	/**
	* Column Info
	* @param  scBal
	*/
	public void	setScBal( String	scBal ) {
		this.scBal =	scBal;
	}
 
	/**
	 * Column Info
	 * @return	scBal
	 */
	 public	 String	getScBal() {
		 return	this.scBal;
	 } 
 	/**
	* Column Info
	* @param  tpEqQty
	*/
	public void	setTpEqQty( String	tpEqQty ) {
		this.tpEqQty =	tpEqQty;
	}
 
	/**
	 * Column Info
	 * @return	tpEqQty
	 */
	 public	 String	getTpEqQty() {
		 return	this.tpEqQty;
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
	* @param  ttlLssCfmId
	*/
	public void	setTtlLssCfmId( String	ttlLssCfmId ) {
		this.ttlLssCfmId =	ttlLssCfmId;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssCfmId
	 */
	 public	 String	getTtlLssCfmId() {
		 return	this.ttlLssCfmId;
	 } 
 	/**
	* Column Info
	* @param  rqstDt
	*/
	public void	setRqstDt( String	rqstDt ) {
		this.rqstDt =	rqstDt;
	}
 
	/**
	 * Column Info
	 * @return	rqstDt
	 */
	 public	 String	getRqstDt() {
		 return	this.rqstDt;
	 } 
 	/**
	* Column Info
	* @param  scExp
	*/
	public void	setScExp( String	scExp ) {
		this.scExp =	scExp;
	}
 
	/**
	 * Column Info
	 * @return	scExp
	 */
	 public	 String	getScExp() {
		 return	this.scExp;
	 } 
 	/**
	* Column Info
	* @param  ttlLssRsnNm
	*/
	public void	setTtlLssRsnNm( String	ttlLssRsnNm ) {
		this.ttlLssRsnNm =	ttlLssRsnNm;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssRsnNm
	 */
	 public	 String	getTtlLssRsnNm() {
		 return	this.ttlLssRsnNm;
	 } 
 	/**
	* Column Info
	* @param  scDvVal
	*/
	public void	setScDvVal( String	scDvVal ) {
		this.scDvVal =	scDvVal;
	}
 
	/**
	 * Column Info
	 * @return	scDvVal
	 */
	 public	 String	getScDvVal() {
		 return	this.scDvVal;
	 } 
 	/**
	* Column Info
	* @param  tpExp
	*/
	public void	setTpExp( String	tpExp ) {
		this.tpExp =	tpExp;
	}
 
	/**
	 * Column Info
	 * @return	tpExp
	 */
	 public	 String	getTpExp() {
		 return	this.tpExp;
	 } 
 	/**
	* Column Info
	* @param  ttlLssDtlRsnNm
	*/
	public void	setTtlLssDtlRsnNm( String	ttlLssDtlRsnNm ) {
		this.ttlLssDtlRsnNm =	ttlLssDtlRsnNm;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssDtlRsnNm
	 */
	 public	 String	getTtlLssDtlRsnNm() {
		 return	this.ttlLssDtlRsnNm;
	 } 
 	/**
	* Column Info
	* @param  irEqQty
	*/
	public void	setIrEqQty( String	irEqQty ) {
		this.irEqQty =	irEqQty;
	}
 
	/**
	 * Column Info
	 * @return	irEqQty
	 */
	 public	 String	getIrEqQty() {
		 return	this.irEqQty;
	 } 
 	/**
	* Column Info
	* @param  tpBal
	*/
	public void	setTpBal( String	tpBal ) {
		this.tpBal =	tpBal;
	}
 
	/**
	 * Column Info
	 * @return	tpBal
	 */
	 public	 String	getTpBal() {
		 return	this.tpBal;
	 } 
 	/**
	* Column Info
	* @param  irBal
	*/
	public void	setIrBal( String	irBal ) {
		this.irBal =	irBal;
	}
 
	/**
	 * Column Info
	 * @return	irBal
	 */
	 public	 String	getIrBal() {
		 return	this.irBal;
	 } 
 	/**
	* Column Info
	* @param  ttlLssStsNm
	*/
	public void	setTtlLssStsNm( String	ttlLssStsNm ) {
		this.ttlLssStsNm =	ttlLssStsNm;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssStsNm
	 */
	 public	 String	getTtlLssStsNm() {
		 return	this.ttlLssStsNm;
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
	* @param  dvBal
	*/
	public void	setDvBal( String	dvBal ) {
		this.dvBal =	dvBal;
	}
 
	/**
	 * Column Info
	 * @return	dvBal
	 */
	 public	 String	getDvBal() {
		 return	this.dvBal;
	 } 
 	/**
	* Column Info
	* @param  irExp
	*/
	public void	setIrExp( String	irExp ) {
		this.irExp =	irExp;
	}
 
	/**
	 * Column Info
	 * @return	irExp
	 */
	 public	 String	getIrExp() {
		 return	this.irExp;
	 } 
 	/**
	* Column Info
	* @param  scEqQty
	*/
	public void	setScEqQty( String	scEqQty ) {
		this.scEqQty =	scEqQty;
	}
 
	/**
	 * Column Info
	 * @return	scEqQty
	 */
	 public	 String	getScEqQty() {
		 return	this.scEqQty;
	 } 
 	/**
	* Column Info
	* @param  ttlLssDt
	*/
	public void	setTtlLssDt( String	ttlLssDt ) {
		this.ttlLssDt =	ttlLssDt;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssDt
	 */
	 public	 String	getTtlLssDt() {
		 return	this.ttlLssDt;
	 } 
 	/**
	* Column Info
	* @param  rqstOfcCd
	*/
	public void	setRqstOfcCd( String	rqstOfcCd ) {
		this.rqstOfcCd =	rqstOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	rqstOfcCd
	 */
	 public	 String	getRqstOfcCd() {
		 return	this.rqstOfcCd;
	 } 
 	/**
	* Column Info
	* @param  ttlLssDtlRsnCd
	*/
	public void	setTtlLssDtlRsnCd( String	ttlLssDtlRsnCd ) {
		this.ttlLssDtlRsnCd =	ttlLssDtlRsnCd;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssDtlRsnCd
	 */
	 public	 String	getTtlLssDtlRsnCd() {
		 return	this.ttlLssDtlRsnCd;
	 } 
 	/**
	* Column Info
	* @param  ttlLssRmk
	*/
	public void	setTtlLssRmk( String	ttlLssRmk ) {
		this.ttlLssRmk =	ttlLssRmk;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssRmk
	 */
	 public	 String	getTtlLssRmk() {
		 return	this.ttlLssRmk;
	 } 
 	/**
	* Column Info
	* @param  dsBal
	*/
	public void	setDsBal( String	dsBal ) {
		this.dsBal =	dsBal;
	}
 
	/**
	 * Column Info
	 * @return	dsBal
	 */
	 public	 String	getDsBal() {
		 return	this.dsBal;
	 } 
 	/**
	* Column Info
	* @param  fileSeq
	*/
	public void	setFileSeq( String	fileSeq ) {
		this.fileSeq =	fileSeq;
	}
 
	/**
	 * Column Info
	 * @return	fileSeq
	 */
	 public	 String	getFileSeq() {
		 return	this.fileSeq;
	 } 
 	/**
	* Column Info
	* @param  ttlLssRsnCd
	*/
	public void	setTtlLssRsnCd( String	ttlLssRsnCd ) {
		this.ttlLssRsnCd =	ttlLssRsnCd;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssRsnCd
	 */
	 public	 String	getTtlLssRsnCd() {
		 return	this.ttlLssRsnCd;
	 } 
 	/**
	* Column Info
	* @param  respbOfcCd
	*/
	public void	setRespbOfcCd( String	respbOfcCd ) {
		this.respbOfcCd =	respbOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	respbOfcCd
	 */
	 public	 String	getRespbOfcCd() {
		 return	this.respbOfcCd;
	 } 
 	/**
	* Column Info
	* @param  ttlLssCmplNm
	*/
	public void	setTtlLssCmplNm( String	ttlLssCmplNm ) {
		this.ttlLssCmplNm =	ttlLssCmplNm;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssCmplNm
	 */
	 public	 String	getTtlLssCmplNm() {
		 return	this.ttlLssCmplNm;
	 } 
 	/**
	* Column Info
	* @param  ttlLssStsCd
	*/
	public void	setTtlLssStsCd( String	ttlLssStsCd ) {
		this.ttlLssStsCd =	ttlLssStsCd;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssStsCd
	 */
	 public	 String	getTtlLssStsCd() {
		 return	this.ttlLssStsCd;
	 } 
 	/**
	* Column Info
	* @param  dvDvVal
	*/
	public void	setDvDvVal( String	dvDvVal ) {
		this.dvDvVal =	dvDvVal;
	}
 
	/**
	 * Column Info
	 * @return	dvDvVal
	 */
	 public	 String	getDvDvVal() {
		 return	this.dvDvVal;
	 } 
 	/**
	* Column Info
	* @param  tmpseq
	*/
	public void	setTmpseq( String	tmpseq ) {
		this.tmpseq =	tmpseq;
	}
 
	/**
	 * Column Info
	 * @return	tmpseq
	 */
	 public	 String	getTmpseq() {
		 return	this.tmpseq;
	 } 
 	/**
	* Column Info
	* @param  rqstEqNo
	*/
	public void	setRqstEqNo( String	rqstEqNo ) {
		this.rqstEqNo =	rqstEqNo;
	}
 
	/**
	 * Column Info
	 * @return	rqstEqNo
	 */
	 public	 String	getRqstEqNo() {
		 return	this.rqstEqNo;
	 } 
 	/**
	* Column Info
	* @param  ttlLssDtlCmplNm
	*/
	public void	setTtlLssDtlCmplNm( String	ttlLssDtlCmplNm ) {
		this.ttlLssDtlCmplNm =	ttlLssDtlCmplNm;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssDtlCmplNm
	 */
	 public	 String	getTtlLssDtlCmplNm() {
		 return	this.ttlLssDtlCmplNm;
	 } 
 	/**
	* Column Info
	* @param  ttlLssDtlCmplDt
	*/
	public void	setTtlLssDtlCmplDt( String	ttlLssDtlCmplDt ) {
		this.ttlLssDtlCmplDt =	ttlLssDtlCmplDt;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssDtlCmplDt
	 */
	 public	 String	getTtlLssDtlCmplDt() {
		 return	this.ttlLssDtlCmplDt;
	 } 
 	/**
	* Column Info
	* @param  ttlLssN3ptyTpCd
	*/
	public void	setTtlLssN3ptyTpCd( String	ttlLssN3ptyTpCd ) {
		this.ttlLssN3ptyTpCd =	ttlLssN3ptyTpCd;
	}
 
	/**
	 * Column Info
	 * @return	ttlLssN3ptyTpCd
	 */
	 public	 String	getTtlLssN3ptyTpCd() {
		 return	this.ttlLssN3ptyTpCd;
	 } 
 	/**
	* Column Info
	* @param  agmtSeq
	*/
	public void	setAgmtSeq( String	agmtSeq ) {
		this.agmtSeq =	agmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	agmtSeq
	 */
	 public	 String	getAgmtSeq() {
		 return	this.agmtSeq;
	 } 
 	/**
	* Column Info
	* @param  crntYdCd
	*/
	public void	setCrntYdCd( String	crntYdCd ) {
		this.crntYdCd =	crntYdCd;
	}
 
	/**
	 * Column Info
	 * @return	crntYdCd
	 */
	 public	 String	getCrntYdCd() {
		 return	this.crntYdCd;
	 } 
 	/**
	* Column Info
	* @param  lessorNm
	*/
	public void	setLessorNm( String	lessorNm ) {
		this.lessorNm =	lessorNm;
	}
 
	/**
	 * Column Info
	 * @return	lessorNm
	 */
	 public	 String	getLessorNm() {
		 return	this.lessorNm;
	 } 
 	/**
	* Column Info
	* @param  eqTpszCd
	*/
	public void	setEqTpszCd( String	eqTpszCd ) {
		this.eqTpszCd =	eqTpszCd;
	}
 
	/**
	 * Column Info
	 * @return	eqTpszCd
	 */
	 public	 String	getEqTpszCd() {
		 return	this.eqTpszCd;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblNm
	*/
	public void	setRstrUsgLblNm( String	rstrUsgLblNm ) {
		this.rstrUsgLblNm =	rstrUsgLblNm;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblNm
	 */
	 public	 String	getRstrUsgLblNm() {
		 return	this.rstrUsgLblNm;
	 } 
 	/**
	* Column Info
	* @param  dvRecovery
	*/
	public void	setDvRecovery( String	dvRecovery ) {
		this.dvRecovery =	dvRecovery;
	}
 
	/**
	 * Column Info
	 * @return	dvRecovery
	 */
	 public	 String	getDvRecovery() {
		 return	this.dvRecovery;
	 } 
 	/**
	* Column Info
	* @param  dvBalance
	*/
	public void	setDvBalance( String	dvBalance ) {
		this.dvBalance =	dvBalance;
	}
 
	/**
	 * Column Info
	 * @return	dvBalance
	 */
	 public	 String	getDvBalance() {
		 return	this.dvBalance;
	 } 
	 
	public String getRstrUsgLblTp() {
		return rstrUsgLblTp;
	}

	public void setRstrUsgLblTp(String rstrUsgLblTp) {
		this.rstrUsgLblTp = rstrUsgLblTp;
	}

	public String getRstrUsgLblVal() {
		return rstrUsgLblVal;
	}

	public void setRstrUsgLblVal(String rstrUsgLblVal) {
		this.rstrUsgLblVal = rstrUsgLblVal;
	}
	
	public String getCtrtNo() {
		return ctrtNo;
	}

	public void setCtrtNo(String ctrtNo) {
		this.ctrtNo = ctrtNo;
	}

	public String getDvCurrCd() {
		return dvCurrCd;
	}

	public void setDvCurrCd(String dvCurrCd) {
		this.dvCurrCd = dvCurrCd;
	}

	public String getTpCurrCd() {
		return tpCurrCd;
	}

	public void setTpCurrCd(String tpCurrCd) {
		this.tpCurrCd = tpCurrCd;
	}

	public String getDsCurrCd() {
		return dsCurrCd;
	}

	public void setDsCurrCd(String dsCurrCd) {
		this.dsCurrCd = dsCurrCd;
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
		setDvExp(JSPUtil.getParameter(request,	prefix + "dv_exp", ""));
		setDsEqQty(JSPUtil.getParameter(request,	prefix + "ds_eq_qty", ""));
		setCltAmt(JSPUtil.getParameter(request,	prefix + "clt_amt", ""));
		setIrDvVal(JSPUtil.getParameter(request,	prefix + "ir_dv_val", ""));
		setDsExp(JSPUtil.getParameter(request,	prefix + "ds_exp", ""));
		setTtlLssNo(JSPUtil.getParameter(request,	prefix + "ttl_lss_no", ""));
		setDvEqQty(JSPUtil.getParameter(request,	prefix + "dv_eq_qty", ""));
		setMnrStsRefNo(JSPUtil.getParameter(request,	prefix + "mnr_sts_ref_no", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request,	prefix + "apro_ofc_cd", ""));
		setTpDvVal(JSPUtil.getParameter(request,	prefix + "tp_dv_val", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setTtlLssCfmDt(JSPUtil.getParameter(request,	prefix + "ttl_lss_cfm_dt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setDsDvVal(JSPUtil.getParameter(request,	prefix + "ds_dv_val", ""));
		setScBal(JSPUtil.getParameter(request,	prefix + "sc_bal", ""));
		setTpEqQty(JSPUtil.getParameter(request,	prefix + "tp_eq_qty", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setTtlLssCfmId(JSPUtil.getParameter(request,	prefix + "ttl_lss_cfm_id", ""));
		setRqstDt(JSPUtil.getParameter(request,	prefix + "rqst_dt", ""));
		setScExp(JSPUtil.getParameter(request,	prefix + "sc_exp", ""));
		setTtlLssRsnNm(JSPUtil.getParameter(request,	prefix + "ttl_lss_rsn_nm", ""));
		setScDvVal(JSPUtil.getParameter(request,	prefix + "sc_dv_val", ""));
		setTpExp(JSPUtil.getParameter(request,	prefix + "tp_exp", ""));
		setTtlLssDtlRsnNm(JSPUtil.getParameter(request,	prefix + "ttl_lss_dtl_rsn_nm", ""));
		setIrEqQty(JSPUtil.getParameter(request,	prefix + "ir_eq_qty", ""));
		setTpBal(JSPUtil.getParameter(request,	prefix + "tp_bal", ""));
		setIrBal(JSPUtil.getParameter(request,	prefix + "ir_bal", ""));
		setTtlLssStsNm(JSPUtil.getParameter(request,	prefix + "ttl_lss_sts_nm", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setDvBal(JSPUtil.getParameter(request,	prefix + "dv_bal", ""));
		setIrExp(JSPUtil.getParameter(request,	prefix + "ir_exp", ""));
		setScEqQty(JSPUtil.getParameter(request,	prefix + "sc_eq_qty", ""));
		setTtlLssDt(JSPUtil.getParameter(request,	prefix + "ttl_lss_dt", ""));
		setRqstOfcCd(JSPUtil.getParameter(request,	prefix + "rqst_ofc_cd", ""));
		setTtlLssDtlRsnCd(JSPUtil.getParameter(request,	prefix + "ttl_lss_dtl_rsn_cd", ""));
		setTtlLssRmk(JSPUtil.getParameter(request,	prefix + "ttl_lss_rmk", ""));
		setDsBal(JSPUtil.getParameter(request,	prefix + "ds_bal", ""));
		setFileSeq(JSPUtil.getParameter(request,	prefix + "file_seq", ""));
		setTtlLssRsnCd(JSPUtil.getParameter(request,	prefix + "ttl_lss_rsn_cd", ""));
		setRespbOfcCd(JSPUtil.getParameter(request,	prefix + "respb_ofc_cd", ""));
		setTtlLssCmplNm(JSPUtil.getParameter(request,	prefix + "ttl_lss_cmpl_nm", ""));
		setTtlLssStsCd(JSPUtil.getParameter(request,	prefix + "ttl_lss_sts_cd", ""));
		setDvDvVal(JSPUtil.getParameter(request,	prefix + "dv_dv_val", ""));
		setTmpseq(JSPUtil.getParameter(request,	prefix + "tmpseq", ""));
		setRqstEqNo(JSPUtil.getParameter(request,	prefix + "rqst_eq_no", ""));
		setTtlLssDtlCmplNm(JSPUtil.getParameter(request,	prefix + "ttl_lss_dtl_cmpl_nm", ""));
		setTtlLssDtlCmplDt(JSPUtil.getParameter(request,	prefix + "ttl_lss_dtl_cmpl_dt", ""));
		setTtlLssN3ptyTpCd(JSPUtil.getParameter(request,	prefix + "ttl_lss_n3pty_tp_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setLessorNm(JSPUtil.getParameter(request,	prefix + "lessor_nm", ""));
		setEqTpszCd(JSPUtil.getParameter(request,	prefix + "eq_tpsz_cd", ""));
		setRstrUsgLblNm(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_nm", ""));
		setDvRecovery(JSPUtil.getParameter(request,	prefix + "dv_recovery", ""));
		setDvBalance(JSPUtil.getParameter(request,	prefix + "dv_balance", ""));
		setRstrUsgLblTp(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_tp", ""));
		setRstrUsgLblVal(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_val", ""));
		setCtrtNo(JSPUtil.getParameter(request,	prefix + "ctrt_no", ""));
		setDvCurrCd(JSPUtil.getParameter(request,	prefix + "dv_curr_cd", ""));
		setTpCurrCd(JSPUtil.getParameter(request,	prefix + "tp_curr_cd", ""));
		setDsCurrCd(JSPUtil.getParameter(request,	prefix + "ds_curr_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TotalLossPerformanceVO[]
	 */
	public TotalLossPerformanceVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TotalLossPerformanceVO[]
	 */
	public TotalLossPerformanceVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		TotalLossPerformanceVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] dvExp =	(JSPUtil.getParameter(request, prefix +	"dv_exp".trim(),	length));
				String[] dsEqQty =	(JSPUtil.getParameter(request, prefix +	"ds_eq_qty".trim(),	length));
				String[] cltAmt =	(JSPUtil.getParameter(request, prefix +	"clt_amt".trim(),	length));
				String[] irDvVal =	(JSPUtil.getParameter(request, prefix +	"ir_dv_val".trim(),	length));
				String[] dsExp =	(JSPUtil.getParameter(request, prefix +	"ds_exp".trim(),	length));
				String[] ttlLssNo =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_no".trim(),	length));
				String[] dvEqQty =	(JSPUtil.getParameter(request, prefix +	"dv_eq_qty".trim(),	length));
				String[] mnrStsRefNo =	(JSPUtil.getParameter(request, prefix +	"mnr_sts_ref_no".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] aproOfcCd =	(JSPUtil.getParameter(request, prefix +	"apro_ofc_cd".trim(),	length));
				String[] tpDvVal =	(JSPUtil.getParameter(request, prefix +	"tp_dv_val".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ttlLssCfmDt =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_cfm_dt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] dsDvVal =	(JSPUtil.getParameter(request, prefix +	"ds_dv_val".trim(),	length));
				String[] scBal =	(JSPUtil.getParameter(request, prefix +	"sc_bal".trim(),	length));
				String[] tpEqQty =	(JSPUtil.getParameter(request, prefix +	"tp_eq_qty".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] ttlLssCfmId =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_cfm_id".trim(),	length));
				String[] rqstDt =	(JSPUtil.getParameter(request, prefix +	"rqst_dt".trim(),	length));
				String[] scExp =	(JSPUtil.getParameter(request, prefix +	"sc_exp".trim(),	length));
				String[] ttlLssRsnNm =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_rsn_nm".trim(),	length));
				String[] scDvVal =	(JSPUtil.getParameter(request, prefix +	"sc_dv_val".trim(),	length));
				String[] tpExp =	(JSPUtil.getParameter(request, prefix +	"tp_exp".trim(),	length));
				String[] ttlLssDtlRsnNm =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_dtl_rsn_nm".trim(),	length));
				String[] irEqQty =	(JSPUtil.getParameter(request, prefix +	"ir_eq_qty".trim(),	length));
				String[] tpBal =	(JSPUtil.getParameter(request, prefix +	"tp_bal".trim(),	length));
				String[] irBal =	(JSPUtil.getParameter(request, prefix +	"ir_bal".trim(),	length));
				String[] ttlLssStsNm =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_sts_nm".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] dvBal =	(JSPUtil.getParameter(request, prefix +	"dv_bal".trim(),	length));
				String[] irExp =	(JSPUtil.getParameter(request, prefix +	"ir_exp".trim(),	length));
				String[] scEqQty =	(JSPUtil.getParameter(request, prefix +	"sc_eq_qty".trim(),	length));
				String[] ttlLssDt =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_dt".trim(),	length));
				String[] rqstOfcCd =	(JSPUtil.getParameter(request, prefix +	"rqst_ofc_cd".trim(),	length));
				String[] ttlLssDtlRsnCd =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_dtl_rsn_cd".trim(),	length));
				String[] ttlLssRmk =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_rmk".trim(),	length));
				String[] dsBal =	(JSPUtil.getParameter(request, prefix +	"ds_bal".trim(),	length));
				String[] fileSeq =	(JSPUtil.getParameter(request, prefix +	"file_seq".trim(),	length));
				String[] ttlLssRsnCd =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_rsn_cd".trim(),	length));
				String[] respbOfcCd =	(JSPUtil.getParameter(request, prefix +	"respb_ofc_cd".trim(),	length));
				String[] ttlLssCmplNm =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_cmpl_nm".trim(),	length));
				String[] ttlLssStsCd =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_sts_cd".trim(),	length));
				String[] dvDvVal =	(JSPUtil.getParameter(request, prefix +	"dv_dv_val".trim(),	length));
				String[] tmpseq =	(JSPUtil.getParameter(request, prefix +	"tmpseq".trim(),	length));
				String[] rqstEqNo =	(JSPUtil.getParameter(request, prefix +	"rqst_eq_no".trim(),	length));
				String[] ttlLssDtlCmplNm =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_dtl_cmpl_nm".trim(),	length));
				String[] ttlLssDtlCmplDt =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_dtl_cmpl_dt".trim(),	length));
				String[] ttlLssN3ptyTpCd =	(JSPUtil.getParameter(request, prefix +	"ttl_lss_n3pty_tp_cd".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] lessorNm =	(JSPUtil.getParameter(request, prefix +	"lessor_nm".trim(),	length));
				String[] eqTpszCd =	(JSPUtil.getParameter(request, prefix +	"eq_tpsz_cd".trim(),	length));
				String[] rstrUsgLblNm =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_nm".trim(),	length));
				String[] dvRecovery =	(JSPUtil.getParameter(request, prefix +	"dv_recovery".trim(),	length));
				String[] dvBalance =	(JSPUtil.getParameter(request, prefix +	"dv_balance".trim(),	length));
				String[] rstrUsgLblTp =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_tp".trim(),	length));
				String[] rstrUsgLblVal =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_val".trim(),	length));
				String[] ctrtNo =	(JSPUtil.getParameter(request, prefix +	"ctrt_no".trim(),	length));
				String[] dvCurrCd =	(JSPUtil.getParameter(request, prefix +	"dv_curr_cd".trim(),	length));
				String[] tpCurrCd =	(JSPUtil.getParameter(request, prefix +	"tp_curr_cd".trim(),	length));
				String[] dsCurrCd =	(JSPUtil.getParameter(request, prefix +	"ds_curr_cd".trim(),	length));
				
				for	(int i = 0;	i <	length;	i++) {
					model =	new	TotalLossPerformanceVO();
						if ( dvExp[i] !=	null)
						model.setDvExp( dvExp[i]);
						if ( dsEqQty[i] !=	null)
						model.setDsEqQty( dsEqQty[i]);
						if ( cltAmt[i] !=	null)
						model.setCltAmt( cltAmt[i]);
						if ( irDvVal[i] !=	null)
						model.setIrDvVal( irDvVal[i]);
						if ( dsExp[i] !=	null)
						model.setDsExp( dsExp[i]);
						if ( ttlLssNo[i] !=	null)
						model.setTtlLssNo( ttlLssNo[i]);
						if ( dvEqQty[i] !=	null)
						model.setDvEqQty( dvEqQty[i]);
						if ( mnrStsRefNo[i] !=	null)
						model.setMnrStsRefNo( mnrStsRefNo[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( aproOfcCd[i] !=	null)
						model.setAproOfcCd( aproOfcCd[i]);
						if ( tpDvVal[i] !=	null)
						model.setTpDvVal( tpDvVal[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ttlLssCfmDt[i] !=	null)
						model.setTtlLssCfmDt( ttlLssCfmDt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( dsDvVal[i] !=	null)
						model.setDsDvVal( dsDvVal[i]);
						if ( scBal[i] !=	null)
						model.setScBal( scBal[i]);
						if ( tpEqQty[i] !=	null)
						model.setTpEqQty( tpEqQty[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( ttlLssCfmId[i] !=	null)
						model.setTtlLssCfmId( ttlLssCfmId[i]);
						if ( rqstDt[i] !=	null)
						model.setRqstDt( rqstDt[i]);
						if ( scExp[i] !=	null)
						model.setScExp( scExp[i]);
						if ( ttlLssRsnNm[i] !=	null)
						model.setTtlLssRsnNm( ttlLssRsnNm[i]);
						if ( scDvVal[i] !=	null)
						model.setScDvVal( scDvVal[i]);
						if ( tpExp[i] !=	null)
						model.setTpExp( tpExp[i]);
						if ( ttlLssDtlRsnNm[i] !=	null)
						model.setTtlLssDtlRsnNm( ttlLssDtlRsnNm[i]);
						if ( irEqQty[i] !=	null)
						model.setIrEqQty( irEqQty[i]);
						if ( tpBal[i] !=	null)
						model.setTpBal( tpBal[i]);
						if ( irBal[i] !=	null)
						model.setIrBal( irBal[i]);
						if ( ttlLssStsNm[i] !=	null)
						model.setTtlLssStsNm( ttlLssStsNm[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( dvBal[i] !=	null)
						model.setDvBal( dvBal[i]);
						if ( irExp[i] !=	null)
						model.setIrExp( irExp[i]);
						if ( scEqQty[i] !=	null)
						model.setScEqQty( scEqQty[i]);
						if ( ttlLssDt[i] !=	null)
						model.setTtlLssDt( ttlLssDt[i]);
						if ( rqstOfcCd[i] !=	null)
						model.setRqstOfcCd( rqstOfcCd[i]);
						if ( ttlLssDtlRsnCd[i] !=	null)
						model.setTtlLssDtlRsnCd( ttlLssDtlRsnCd[i]);
						if ( ttlLssRmk[i] !=	null)
						model.setTtlLssRmk( ttlLssRmk[i]);
						if ( dsBal[i] !=	null)
						model.setDsBal( dsBal[i]);
						if ( fileSeq[i] !=	null)
						model.setFileSeq( fileSeq[i]);
						if ( ttlLssRsnCd[i] !=	null)
						model.setTtlLssRsnCd( ttlLssRsnCd[i]);
						if ( respbOfcCd[i] !=	null)
						model.setRespbOfcCd( respbOfcCd[i]);
						if ( ttlLssCmplNm[i] !=	null)
						model.setTtlLssCmplNm( ttlLssCmplNm[i]);
						if ( ttlLssStsCd[i] !=	null)
						model.setTtlLssStsCd( ttlLssStsCd[i]);
						if ( dvDvVal[i] !=	null)
						model.setDvDvVal( dvDvVal[i]);
						if ( tmpseq[i] !=	null)
						model.setTmpseq( tmpseq[i]);
						if ( rqstEqNo[i] !=	null)
						model.setRqstEqNo( rqstEqNo[i]);
						if ( ttlLssDtlCmplNm[i] !=	null)
						model.setTtlLssDtlCmplNm( ttlLssDtlCmplNm[i]);
						if ( ttlLssDtlCmplDt[i] !=	null)
						model.setTtlLssDtlCmplDt( ttlLssDtlCmplDt[i]);
						if ( ttlLssN3ptyTpCd[i] !=	null)
						model.setTtlLssN3ptyTpCd( ttlLssN3ptyTpCd[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( lessorNm[i] !=	null)
						model.setLessorNm( lessorNm[i]);
						if ( eqTpszCd[i] !=	null)
						model.setEqTpszCd( eqTpszCd[i]);
						if ( rstrUsgLblNm[i] !=	null)
						model.setRstrUsgLblNm( rstrUsgLblNm[i]);
						if ( dvRecovery[i] !=	null)
						model.setDvRecovery( dvRecovery[i]);
						if ( dvBalance[i] !=	null)
						model.setDvBalance( dvBalance[i]);
						if ( rstrUsgLblTp[i] !=	null)
						model.setRstrUsgLblTp( rstrUsgLblTp[i]);
						if ( rstrUsgLblVal[i] !=	null)
						model.setRstrUsgLblVal( rstrUsgLblVal[i]);
						if ( ctrtNo[i] !=	null)
						model.setCtrtNo( ctrtNo[i]);
						if ( dvCurrCd[i] !=	null)
							model.setDvCurrCd( dvCurrCd[i]);
						if ( tpCurrCd[i] !=	null)
							model.setTpCurrCd( tpCurrCd[i]);
						if ( dsCurrCd[i] !=	null)
							model.setDsCurrCd( dsCurrCd[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getTotalLossPerformanceVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return TotalLossPerformanceVO[]
	 */
	public TotalLossPerformanceVO[]	 getTotalLossPerformanceVOs(){
		TotalLossPerformanceVO[] vos = (TotalLossPerformanceVO[])models.toArray(new	TotalLossPerformanceVO[models.size()]);
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
		this.dvExp =	this.dvExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsEqQty =	this.dsEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cltAmt =	this.cltAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irDvVal =	this.irDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsExp =	this.dsExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssNo =	this.ttlLssNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvEqQty =	this.dvEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrStsRefNo =	this.mnrStsRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd =	this.aproOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpDvVal =	this.tpDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCfmDt =	this.ttlLssCfmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsDvVal =	this.dsDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scBal =	this.scBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpEqQty =	this.tpEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCfmId =	this.ttlLssCfmId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt =	this.rqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scExp =	this.scExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRsnNm =	this.ttlLssRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scDvVal =	this.scDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpExp =	this.tpExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnNm =	this.ttlLssDtlRsnNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irEqQty =	this.irEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpBal =	this.tpBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irBal =	this.irBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssStsNm =	this.ttlLssStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvBal =	this.dvBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.irExp =	this.irExp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scEqQty =	this.scEqQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDt =	this.ttlLssDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd =	this.rqstOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlRsnCd =	this.ttlLssDtlRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRmk =	this.ttlLssRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsBal =	this.dsBal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fileSeq =	this.fileSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssRsnCd =	this.ttlLssRsnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.respbOfcCd =	this.respbOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssCmplNm =	this.ttlLssCmplNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssStsCd =	this.ttlLssStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvDvVal =	this.dvDvVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmpseq =	this.tmpseq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstEqNo =	this.rqstEqNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlCmplNm =	this.ttlLssDtlCmplNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssDtlCmplDt =	this.ttlLssDtlCmplDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlLssN3ptyTpCd =	this.ttlLssN3ptyTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessorNm =	this.lessorNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd =	this.eqTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblNm =	this.rstrUsgLblNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvRecovery =	this.dvRecovery.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvBalance =	this.dvBalance.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblTp =	this.rstrUsgLblTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblVal =	this.rstrUsgLblVal.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo =	this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvCurrCd =	this.dvCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpCurrCd =	this.tpCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dsCurrCd =	this.dsCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}