/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : TermChangeCreationVO.java
 *@FileTitle : TermChangeCreationVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.08.19
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.08.19  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containerleasemgt.termchange.vo;

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
public class TermChangeCreationVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<TermChangeCreationVO>  models =	new	ArrayList<TermChangeCreationVO>();


	/*	Column Info	*/
	private  String	 cntrFullFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 diFlag   =  null;
	/*	Column Info	*/
	private  String	 aftAgmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 onhDt   =  null;
	/*	Column Info	*/
	private  String	 cntrMinOnhDys   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 aftLstmCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 cntrPkupChgAmt   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntrPkupPsvAmt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 cntrPkupNgvAmt   =  null;
	/*	Column Info	*/
	private  String	 rntlChgFreeDys   =  null;
	/*	Column Info	*/
	private  String	 aftVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 aftAgmtSeq   =  null;
	/*	Column Info	*/
	private  String	 curAgmtSeq   =  null;
	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 curAgmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 diiFee   =  null;
	/*	Column Info	*/
	private  String	 lstStsYdCd   =  null;
	/*	Column Info	*/
	private  String	 rowSeq   =  null;
	/*	Column Info	*/
	private  String	 termCngSeq   =  null;
	/*	Column Info	*/
	private  String	 seqSet   =  null;
	/*	Column Info	*/
	private  String	 actDt   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 dirItchgVndrSeq   =  null;
	/*	Column Info	*/
	private  String	 delChk   =  null;
	/*	Column Info	*/
	private  String	 cntrStsSeq   =  null;
	/*	Column Info	*/
	private  String	 ydCd   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 sccCd   =  null;
	/*	Column Info	*/
	private  String	 eccCd   =  null;
	/*	Column Info	*/
	private  String	 lccCd   =  null;
	/*	Column Info	*/
	private  String	 rccCd   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 errCd   =  null;
	/*	Column Info	*/
	private  String	 dpCntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 dpCnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 dpOnhDt   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm3   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgTpLblNm8   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public TermChangeCreationVO(){}

	public TermChangeCreationVO(String cntrFullFlg,String cntrStsCd,String diFlag,String aftAgmtCtyCd,String onhDt,String cntrMinOnhDys,String pagerows,String aftLstmCd,String ibflag,String cnmvStsCd,String cnmvDt,String cntrPkupChgAmt,String cntrTpszCd,String cntrPkupPsvAmt,String updUsrId,String cntrPkupNgvAmt,String rntlChgFreeDys,String aftVndrSeq,String aftAgmtSeq,String curAgmtSeq,String ofcCd,String curAgmtCtyCd,String creUsrId,String diiFee,String lstStsYdCd,String rowSeq,String termCngSeq,String seqSet,String actDt,String cntrNo,String dirItchgVndrSeq,String delChk,String cntrStsSeq,String ydCd,String locCd,String sccCd,String eccCd,String lccCd,String rccCd,String crntYdCd,String errCd,String dpCntrStsCd,String dpCnmvStsCd,String dpOnhDt,String rstrUsgTpLblNm3,String rstrUsgTpLblNm8)	{
		this.cntrFullFlg  = cntrFullFlg ;
		this.cntrStsCd  = cntrStsCd ;
		this.diFlag  = diFlag ;
		this.aftAgmtCtyCd  = aftAgmtCtyCd ;
		this.onhDt  = onhDt ;
		this.cntrMinOnhDys  = cntrMinOnhDys ;
		this.pagerows  = pagerows ;
		this.aftLstmCd  = aftLstmCd ;
		this.ibflag  = ibflag ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.cnmvDt  = cnmvDt ;
		this.cntrPkupChgAmt  = cntrPkupChgAmt ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.cntrPkupPsvAmt  = cntrPkupPsvAmt ;
		this.updUsrId  = updUsrId ;
		this.cntrPkupNgvAmt  = cntrPkupNgvAmt ;
		this.rntlChgFreeDys  = rntlChgFreeDys ;
		this.aftVndrSeq  = aftVndrSeq ;
		this.aftAgmtSeq  = aftAgmtSeq ;
		this.curAgmtSeq  = curAgmtSeq ;
		this.ofcCd  = ofcCd ;
		this.curAgmtCtyCd  = curAgmtCtyCd ;
		this.creUsrId  = creUsrId ;
		this.diiFee  = diiFee ;
		this.lstStsYdCd  = lstStsYdCd ;
		this.rowSeq  = rowSeq ;
		this.termCngSeq  = termCngSeq ;
		this.seqSet  = seqSet ;
		this.actDt  = actDt ;
		this.cntrNo  = cntrNo ;
		this.dirItchgVndrSeq  = dirItchgVndrSeq ;
		this.delChk  = delChk ;
		this.cntrStsSeq  = cntrStsSeq ;
		this.ydCd  = ydCd ;
		this.locCd  = locCd ;
		this.sccCd  = sccCd ;
		this.eccCd  = eccCd ;
		this.lccCd  = lccCd ;
		this.rccCd  = rccCd ;
		this.crntYdCd  = crntYdCd ;
		this.errCd  = errCd ;
		this.dpCntrStsCd  = dpCntrStsCd ;
		this.dpCnmvStsCd  = dpCnmvStsCd ;
		this.dpOnhDt  = dpOnhDt ;
		this.rstrUsgTpLblNm3  = rstrUsgTpLblNm3 ;
		this.rstrUsgTpLblNm8  = rstrUsgTpLblNm8 ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_full_flg", getCntrFullFlg());		
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());		
		this.hashColumns.put("di_flag", getDiFlag());		
		this.hashColumns.put("aft_agmt_cty_cd", getAftAgmtCtyCd());		
		this.hashColumns.put("onh_dt", getOnhDt());		
		this.hashColumns.put("cntr_min_onh_dys", getCntrMinOnhDys());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("aft_lstm_cd", getAftLstmCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("cntr_pkup_chg_amt", getCntrPkupChgAmt());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("cntr_pkup_psv_amt", getCntrPkupPsvAmt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("cntr_pkup_ngv_amt", getCntrPkupNgvAmt());		
		this.hashColumns.put("rntl_chg_free_dys", getRntlChgFreeDys());		
		this.hashColumns.put("aft_vndr_seq", getAftVndrSeq());		
		this.hashColumns.put("aft_agmt_seq", getAftAgmtSeq());		
		this.hashColumns.put("cur_agmt_seq", getCurAgmtSeq());		
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("cur_agmt_cty_cd", getCurAgmtCtyCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("dii_fee", getDiiFee());		
		this.hashColumns.put("lst_sts_yd_cd", getLstStsYdCd());		
		this.hashColumns.put("row_seq", getRowSeq());		
		this.hashColumns.put("term_cng_seq", getTermCngSeq());		
		this.hashColumns.put("seq_set", getSeqSet());		
		this.hashColumns.put("act_dt", getActDt());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("dir_itchg_vndr_seq", getDirItchgVndrSeq());		
		this.hashColumns.put("del_chk", getDelChk());		
		this.hashColumns.put("cntr_sts_seq", getCntrStsSeq());		
		this.hashColumns.put("yd_cd", getYdCd());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("scc_cd", getSccCd());		
		this.hashColumns.put("ecc_cd", getEccCd());		
		this.hashColumns.put("lcc_cd", getLccCd());		
		this.hashColumns.put("rcc_cd", getRccCd());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("err_cd", getErrCd());		
		this.hashColumns.put("dp_cntr_sts_cd", getDpCntrStsCd());		
		this.hashColumns.put("dp_cnmv_sts_cd", getDpCnmvStsCd());		
		this.hashColumns.put("dp_onh_dt", getDpOnhDt());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm3", getRstrUsgTpLblNm3());		
		this.hashColumns.put("rstr_usg_tp_lbl_nm8", getRstrUsgTpLblNm8());	
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cntr_full_flg", "cntrFullFlg");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("di_flag", "diFlag");
		this.hashFields.put("aft_agmt_cty_cd", "aftAgmtCtyCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("cntr_min_onh_dys", "cntrMinOnhDys");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("aft_lstm_cd", "aftLstmCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("cntr_pkup_chg_amt", "cntrPkupChgAmt");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_pkup_psv_amt", "cntrPkupPsvAmt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("cntr_pkup_ngv_amt", "cntrPkupNgvAmt");
		this.hashFields.put("rntl_chg_free_dys", "rntlChgFreeDys");
		this.hashFields.put("aft_vndr_seq", "aftVndrSeq");
		this.hashFields.put("aft_agmt_seq", "aftAgmtSeq");
		this.hashFields.put("cur_agmt_seq", "curAgmtSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cur_agmt_cty_cd", "curAgmtCtyCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("dii_fee", "diiFee");
		this.hashFields.put("lst_sts_yd_cd", "lstStsYdCd");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("term_cng_seq", "termCngSeq");
		this.hashFields.put("seq_set", "seqSet");
		this.hashFields.put("act_dt", "actDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("dir_itchg_vndr_seq", "dirItchgVndrSeq");
		this.hashFields.put("del_chk", "delChk");
		this.hashFields.put("cntr_sts_seq", "cntrStsSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("ecc_cd", "eccCd");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("err_cd", "errCd");
		this.hashFields.put("dp_cntr_sts_cd", "dpCntrStsCd");
		this.hashFields.put("dp_cnmv_sts_cd", "dpCnmvStsCd");
		this.hashFields.put("dp_onh_dt", "dpOnhDt");
		this.hashFields.put("rstr_usg_tp_lbl_nm3", "rstrUsgTpLblNm3");
		this.hashFields.put("rstr_usg_tp_lbl_nm8", "rstrUsgTpLblNm8");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  cntrFullFlg
	*/
	public void	setCntrFullFlg( String	cntrFullFlg ) {
		this.cntrFullFlg =	cntrFullFlg;
	}
 
	/**
	 * Column Info
	 * @return	cntrFullFlg
	 */
	 public	 String	getCntrFullFlg() {
		 return	this.cntrFullFlg;
	 } 
 	/**
	* Column Info
	* @param  cntrStsCd
	*/
	public void	setCntrStsCd( String	cntrStsCd ) {
		this.cntrStsCd =	cntrStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsCd
	 */
	 public	 String	getCntrStsCd() {
		 return	this.cntrStsCd;
	 } 
 	/**
	* Column Info
	* @param  diFlag
	*/
	public void	setDiFlag( String	diFlag ) {
		this.diFlag =	diFlag;
	}
 
	/**
	 * Column Info
	 * @return	diFlag
	 */
	 public	 String	getDiFlag() {
		 return	this.diFlag;
	 } 
 	/**
	* Column Info
	* @param  aftAgmtCtyCd
	*/
	public void	setAftAgmtCtyCd( String	aftAgmtCtyCd ) {
		this.aftAgmtCtyCd =	aftAgmtCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	aftAgmtCtyCd
	 */
	 public	 String	getAftAgmtCtyCd() {
		 return	this.aftAgmtCtyCd;
	 } 
 	/**
	* Column Info
	* @param  onhDt
	*/
	public void	setOnhDt( String	onhDt ) {
		this.onhDt =	onhDt;
	}
 
	/**
	 * Column Info
	 * @return	onhDt
	 */
	 public	 String	getOnhDt() {
		 return	this.onhDt;
	 } 
 	/**
	* Column Info
	* @param  cntrMinOnhDys
	*/
	public void	setCntrMinOnhDys( String	cntrMinOnhDys ) {
		this.cntrMinOnhDys =	cntrMinOnhDys;
	}
 
	/**
	 * Column Info
	 * @return	cntrMinOnhDys
	 */
	 public	 String	getCntrMinOnhDys() {
		 return	this.cntrMinOnhDys;
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
	* @param  aftLstmCd
	*/
	public void	setAftLstmCd( String	aftLstmCd ) {
		this.aftLstmCd =	aftLstmCd;
	}
 
	/**
	 * Column Info
	 * @return	aftLstmCd
	 */
	 public	 String	getAftLstmCd() {
		 return	this.aftLstmCd;
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
	* @param  cnmvStsCd
	*/
	public void	setCnmvStsCd( String	cnmvStsCd ) {
		this.cnmvStsCd =	cnmvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd
	 */
	 public	 String	getCnmvStsCd() {
		 return	this.cnmvStsCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvDt
	*/
	public void	setCnmvDt( String	cnmvDt ) {
		this.cnmvDt =	cnmvDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvDt
	 */
	 public	 String	getCnmvDt() {
		 return	this.cnmvDt;
	 } 
 	/**
	* Column Info
	* @param  cntrPkupChgAmt
	*/
	public void	setCntrPkupChgAmt( String	cntrPkupChgAmt ) {
		this.cntrPkupChgAmt =	cntrPkupChgAmt;
	}
 
	/**
	 * Column Info
	 * @return	cntrPkupChgAmt
	 */
	 public	 String	getCntrPkupChgAmt() {
		 return	this.cntrPkupChgAmt;
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
	* @param  cntrPkupPsvAmt
	*/
	public void	setCntrPkupPsvAmt( String	cntrPkupPsvAmt ) {
		this.cntrPkupPsvAmt =	cntrPkupPsvAmt;
	}
 
	/**
	 * Column Info
	 * @return	cntrPkupPsvAmt
	 */
	 public	 String	getCntrPkupPsvAmt() {
		 return	this.cntrPkupPsvAmt;
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
	* @param  cntrPkupNgvAmt
	*/
	public void	setCntrPkupNgvAmt( String	cntrPkupNgvAmt ) {
		this.cntrPkupNgvAmt =	cntrPkupNgvAmt;
	}
 
	/**
	 * Column Info
	 * @return	cntrPkupNgvAmt
	 */
	 public	 String	getCntrPkupNgvAmt() {
		 return	this.cntrPkupNgvAmt;
	 } 
 	/**
	* Column Info
	* @param  rntlChgFreeDys
	*/
	public void	setRntlChgFreeDys( String	rntlChgFreeDys ) {
		this.rntlChgFreeDys =	rntlChgFreeDys;
	}
 
	/**
	 * Column Info
	 * @return	rntlChgFreeDys
	 */
	 public	 String	getRntlChgFreeDys() {
		 return	this.rntlChgFreeDys;
	 } 
 	/**
	* Column Info
	* @param  aftVndrSeq
	*/
	public void	setAftVndrSeq( String	aftVndrSeq ) {
		this.aftVndrSeq =	aftVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	aftVndrSeq
	 */
	 public	 String	getAftVndrSeq() {
		 return	this.aftVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  aftAgmtSeq
	*/
	public void	setAftAgmtSeq( String	aftAgmtSeq ) {
		this.aftAgmtSeq =	aftAgmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	aftAgmtSeq
	 */
	 public	 String	getAftAgmtSeq() {
		 return	this.aftAgmtSeq;
	 } 
 	/**
	* Column Info
	* @param  curAgmtSeq
	*/
	public void	setCurAgmtSeq( String	curAgmtSeq ) {
		this.curAgmtSeq =	curAgmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	curAgmtSeq
	 */
	 public	 String	getCurAgmtSeq() {
		 return	this.curAgmtSeq;
	 } 
 	/**
	* Column Info
	* @param  ofcCd
	*/
	public void	setOfcCd( String	ofcCd ) {
		this.ofcCd =	ofcCd;
	}
 
	/**
	 * Column Info
	 * @return	ofcCd
	 */
	 public	 String	getOfcCd() {
		 return	this.ofcCd;
	 } 
 	/**
	* Column Info
	* @param  curAgmtCtyCd
	*/
	public void	setCurAgmtCtyCd( String	curAgmtCtyCd ) {
		this.curAgmtCtyCd =	curAgmtCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	curAgmtCtyCd
	 */
	 public	 String	getCurAgmtCtyCd() {
		 return	this.curAgmtCtyCd;
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
	* @param  diiFee
	*/
	public void	setDiiFee( String	diiFee ) {
		this.diiFee =	diiFee;
	}
 
	/**
	 * Column Info
	 * @return	diiFee
	 */
	 public	 String	getDiiFee() {
		 return	this.diiFee;
	 } 
 	/**
	* Column Info
	* @param  lstStsYdCd
	*/
	public void	setLstStsYdCd( String	lstStsYdCd ) {
		this.lstStsYdCd =	lstStsYdCd;
	}
 
	/**
	 * Column Info
	 * @return	lstStsYdCd
	 */
	 public	 String	getLstStsYdCd() {
		 return	this.lstStsYdCd;
	 } 
 	/**
	* Column Info
	* @param  rowSeq
	*/
	public void	setRowSeq( String	rowSeq ) {
		this.rowSeq =	rowSeq;
	}
 
	/**
	 * Column Info
	 * @return	rowSeq
	 */
	 public	 String	getRowSeq() {
		 return	this.rowSeq;
	 } 
 	/**
	* Column Info
	* @param  termCngSeq
	*/
	public void	setTermCngSeq( String	termCngSeq ) {
		this.termCngSeq =	termCngSeq;
	}
 
	/**
	 * Column Info
	 * @return	termCngSeq
	 */
	 public	 String	getTermCngSeq() {
		 return	this.termCngSeq;
	 } 
 	/**
	* Column Info
	* @param  seqSet
	*/
	public void	setSeqSet( String	seqSet ) {
		this.seqSet =	seqSet;
	}
 
	/**
	 * Column Info
	 * @return	seqSet
	 */
	 public	 String	getSeqSet() {
		 return	this.seqSet;
	 } 
 	/**
	* Column Info
	* @param  actDt
	*/
	public void	setActDt( String	actDt ) {
		this.actDt =	actDt;
	}
 
	/**
	 * Column Info
	 * @return	actDt
	 */
	 public	 String	getActDt() {
		 return	this.actDt;
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
	* @param  dirItchgVndrSeq
	*/
	public void	setDirItchgVndrSeq( String	dirItchgVndrSeq ) {
		this.dirItchgVndrSeq =	dirItchgVndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	dirItchgVndrSeq
	 */
	 public	 String	getDirItchgVndrSeq() {
		 return	this.dirItchgVndrSeq;
	 } 
 	/**
	* Column Info
	* @param  delChk
	*/
	public void	setDelChk( String	delChk ) {
		this.delChk =	delChk;
	}
 
	/**
	 * Column Info
	 * @return	delChk
	 */
	 public	 String	getDelChk() {
		 return	this.delChk;
	 } 
 	/**
	* Column Info
	* @param  cntrStsSeq
	*/
	public void	setCntrStsSeq( String	cntrStsSeq ) {
		this.cntrStsSeq =	cntrStsSeq;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsSeq
	 */
	 public	 String	getCntrStsSeq() {
		 return	this.cntrStsSeq;
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
	* @param  locCd
	*/
	public void	setLocCd( String	locCd ) {
		this.locCd =	locCd;
	}
 
	/**
	 * Column Info
	 * @return	locCd
	 */
	 public	 String	getLocCd() {
		 return	this.locCd;
	 } 
 	/**
	* Column Info
	* @param  sccCd
	*/
	public void	setSccCd( String	sccCd ) {
		this.sccCd =	sccCd;
	}
 
	/**
	 * Column Info
	 * @return	sccCd
	 */
	 public	 String	getSccCd() {
		 return	this.sccCd;
	 } 
 	/**
	* Column Info
	* @param  eccCd
	*/
	public void	setEccCd( String	eccCd ) {
		this.eccCd =	eccCd;
	}
 
	/**
	 * Column Info
	 * @return	eccCd
	 */
	 public	 String	getEccCd() {
		 return	this.eccCd;
	 } 
 	/**
	* Column Info
	* @param  lccCd
	*/
	public void	setLccCd( String	lccCd ) {
		this.lccCd =	lccCd;
	}
 
	/**
	 * Column Info
	 * @return	lccCd
	 */
	 public	 String	getLccCd() {
		 return	this.lccCd;
	 } 
 	/**
	* Column Info
	* @param  rccCd
	*/
	public void	setRccCd( String	rccCd ) {
		this.rccCd =	rccCd;
	}
 
	/**
	 * Column Info
	 * @return	rccCd
	 */
	 public	 String	getRccCd() {
		 return	this.rccCd;
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
	* @param  errCd
	*/
	public void	setErrCd( String	errCd ) {
		this.errCd =	errCd;
	}
 
	/**
	 * Column Info
	 * @return	errCd
	 */
	 public	 String	getErrCd() {
		 return	this.errCd;
	 } 
 	/**
	* Column Info
	* @param  dpCntrStsCd
	*/
	public void	setDpCntrStsCd( String	dpCntrStsCd ) {
		this.dpCntrStsCd =	dpCntrStsCd;
	}
 
	/**
	 * Column Info
	 * @return	dpCntrStsCd
	 */
	 public	 String	getDpCntrStsCd() {
		 return	this.dpCntrStsCd;
	 } 
 	/**
	* Column Info
	* @param  dpCnmvStsCd
	*/
	public void	setDpCnmvStsCd( String	dpCnmvStsCd ) {
		this.dpCnmvStsCd =	dpCnmvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	dpCnmvStsCd
	 */
	 public	 String	getDpCnmvStsCd() {
		 return	this.dpCnmvStsCd;
	 } 
 	/**
	* Column Info
	* @param  dpOnhDt
	*/
	public void	setDpOnhDt( String	dpOnhDt ) {
		this.dpOnhDt =	dpOnhDt;
	}
 
	/**
	 * Column Info
	 * @return	dpOnhDt
	 */
	 public	 String	getDpOnhDt() {
		 return	this.dpOnhDt;
	 } 
	 
	 /**
	* Column Info
	* @param  rstrUsgTpLblNm3
	*/
	public void	setRstrUsgTpLblNm3( String	rstrUsgTpLblNm3 ) {
		this.rstrUsgTpLblNm3 =	rstrUsgTpLblNm3;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm3
	 */
	 public	 String	getRstrUsgTpLblNm3() {
		 return	this.rstrUsgTpLblNm3;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgTpLblNm8
	*/
	public void	setRstrUsgTpLblNm8( String	rstrUsgTpLblNm8 ) {
		this.rstrUsgTpLblNm8 =	rstrUsgTpLblNm8;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgTpLblNm8
	 */
	 public	 String	getRstrUsgTpLblNm8() {
		 return	this.rstrUsgTpLblNm8;
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
		setCntrFullFlg(JSPUtil.getParameter(request,	prefix + "cntr_full_flg", ""));
		setCntrStsCd(JSPUtil.getParameter(request,	prefix + "cntr_sts_cd", ""));
		setDiFlag(JSPUtil.getParameter(request,	prefix + "di_flag", ""));
		setAftAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "aft_agmt_cty_cd", ""));
		setOnhDt(JSPUtil.getParameter(request,	prefix + "onh_dt", ""));
		setCntrMinOnhDys(JSPUtil.getParameter(request,	prefix + "cntr_min_onh_dys", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAftLstmCd(JSPUtil.getParameter(request,	prefix + "aft_lstm_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setCntrPkupChgAmt(JSPUtil.getParameter(request,	prefix + "cntr_pkup_chg_amt", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setCntrPkupPsvAmt(JSPUtil.getParameter(request,	prefix + "cntr_pkup_psv_amt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setCntrPkupNgvAmt(JSPUtil.getParameter(request,	prefix + "cntr_pkup_ngv_amt", ""));
		setRntlChgFreeDys(JSPUtil.getParameter(request,	prefix + "rntl_chg_free_dys", ""));
		setAftVndrSeq(JSPUtil.getParameter(request,	prefix + "aft_vndr_seq", ""));
		setAftAgmtSeq(JSPUtil.getParameter(request,	prefix + "aft_agmt_seq", ""));
		setCurAgmtSeq(JSPUtil.getParameter(request,	prefix + "cur_agmt_seq", ""));
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setCurAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "cur_agmt_cty_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setDiiFee(JSPUtil.getParameter(request,	prefix + "dii_fee", ""));
		setLstStsYdCd(JSPUtil.getParameter(request,	prefix + "lst_sts_yd_cd", ""));
		setRowSeq(JSPUtil.getParameter(request,	prefix + "row_seq", ""));
		setTermCngSeq(JSPUtil.getParameter(request,	prefix + "term_cng_seq", ""));
		setSeqSet(JSPUtil.getParameter(request,	prefix + "seq_set", ""));
		setActDt(JSPUtil.getParameter(request,	prefix + "act_dt", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setDirItchgVndrSeq(JSPUtil.getParameter(request,	prefix + "dir_itchg_vndr_seq", ""));
		setDelChk(JSPUtil.getParameter(request,	prefix + "del_chk", ""));
		setCntrStsSeq(JSPUtil.getParameter(request,	prefix + "cntr_sts_seq", ""));
		setYdCd(JSPUtil.getParameter(request,	prefix + "yd_cd", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setSccCd(JSPUtil.getParameter(request,	prefix + "scc_cd", ""));
		setEccCd(JSPUtil.getParameter(request,	prefix + "ecc_cd", ""));
		setLccCd(JSPUtil.getParameter(request,	prefix + "lcc_cd", ""));
		setRccCd(JSPUtil.getParameter(request,	prefix + "rcc_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setErrCd(JSPUtil.getParameter(request,	prefix + "err_cd", ""));
		setDpCntrStsCd(JSPUtil.getParameter(request,	prefix + "dp_cntr_sts_cd", ""));
		setDpCnmvStsCd(JSPUtil.getParameter(request,	prefix + "dp_cnmv_sts_cd", ""));
		setDpOnhDt(JSPUtil.getParameter(request,	prefix + "dp_onh_dt", ""));
		setRstrUsgTpLblNm3(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm3", ""));
		setRstrUsgTpLblNm8(JSPUtil.getParameter(request,	prefix + "rstr_usg_tp_lbl_nm8", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TermChangeCreationVO[]
	 */
	public TermChangeCreationVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return TermChangeCreationVO[]
	 */
	public TermChangeCreationVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		TermChangeCreationVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] cntrFullFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_full_flg".trim(),	length));
				String[] cntrStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_cd".trim(),	length));
				String[] diFlag =	(JSPUtil.getParameter(request, prefix +	"di_flag".trim(),	length));
				String[] aftAgmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"aft_agmt_cty_cd".trim(),	length));
				String[] onhDt =	(JSPUtil.getParameter(request, prefix +	"onh_dt".trim(),	length));
				String[] cntrMinOnhDys =	(JSPUtil.getParameter(request, prefix +	"cntr_min_onh_dys".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] aftLstmCd =	(JSPUtil.getParameter(request, prefix +	"aft_lstm_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] cntrPkupChgAmt =	(JSPUtil.getParameter(request, prefix +	"cntr_pkup_chg_amt".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] cntrPkupPsvAmt =	(JSPUtil.getParameter(request, prefix +	"cntr_pkup_psv_amt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] cntrPkupNgvAmt =	(JSPUtil.getParameter(request, prefix +	"cntr_pkup_ngv_amt".trim(),	length));
				String[] rntlChgFreeDys =	(JSPUtil.getParameter(request, prefix +	"rntl_chg_free_dys".trim(),	length));
				String[] aftVndrSeq =	(JSPUtil.getParameter(request, prefix +	"aft_vndr_seq".trim(),	length));
				String[] aftAgmtSeq =	(JSPUtil.getParameter(request, prefix +	"aft_agmt_seq".trim(),	length));
				String[] curAgmtSeq =	(JSPUtil.getParameter(request, prefix +	"cur_agmt_seq".trim(),	length));
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] curAgmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"cur_agmt_cty_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] diiFee =	(JSPUtil.getParameter(request, prefix +	"dii_fee".trim(),	length));
				String[] lstStsYdCd =	(JSPUtil.getParameter(request, prefix +	"lst_sts_yd_cd".trim(),	length));
				String[] rowSeq =	(JSPUtil.getParameter(request, prefix +	"row_seq".trim(),	length));
				String[] termCngSeq =	(JSPUtil.getParameter(request, prefix +	"term_cng_seq".trim(),	length));
				String[] seqSet =	(JSPUtil.getParameter(request, prefix +	"seq_set".trim(),	length));
				String[] actDt =	(JSPUtil.getParameter(request, prefix +	"act_dt".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] dirItchgVndrSeq =	(JSPUtil.getParameter(request, prefix +	"dir_itchg_vndr_seq".trim(),	length));
				String[] delChk =	(JSPUtil.getParameter(request, prefix +	"del_chk".trim(),	length));
				String[] cntrStsSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_seq".trim(),	length));
				String[] ydCd =	(JSPUtil.getParameter(request, prefix +	"yd_cd".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] sccCd =	(JSPUtil.getParameter(request, prefix +	"scc_cd".trim(),	length));
				String[] eccCd =	(JSPUtil.getParameter(request, prefix +	"ecc_cd".trim(),	length));
				String[] lccCd =	(JSPUtil.getParameter(request, prefix +	"lcc_cd".trim(),	length));
				String[] rccCd =	(JSPUtil.getParameter(request, prefix +	"rcc_cd".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] errCd =	(JSPUtil.getParameter(request, prefix +	"err_cd".trim(),	length));
				String[] dpCntrStsCd =	(JSPUtil.getParameter(request, prefix +	"dp_cntr_sts_cd".trim(),	length));
				String[] dpCnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"dp_cnmv_sts_cd".trim(),	length));
				String[] dpOnhDt =	(JSPUtil.getParameter(request, prefix +	"dp_onh_dt".trim(),	length));
				String[] rstrUsgTpLblNm3 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm3".trim(),	length));
				String[] rstrUsgTpLblNm8 =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_tp_lbl_nm8".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	TermChangeCreationVO();
						if ( cntrFullFlg[i] !=	null)
						model.setCntrFullFlg( cntrFullFlg[i]);
						if ( cntrStsCd[i] !=	null)
						model.setCntrStsCd( cntrStsCd[i]);
						if ( diFlag[i] !=	null)
						model.setDiFlag( diFlag[i]);
						if ( aftAgmtCtyCd[i] !=	null)
						model.setAftAgmtCtyCd( aftAgmtCtyCd[i]);
						if ( onhDt[i] !=	null)
						model.setOnhDt( onhDt[i]);
						if ( cntrMinOnhDys[i] !=	null)
						model.setCntrMinOnhDys( cntrMinOnhDys[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( aftLstmCd[i] !=	null)
						model.setAftLstmCd( aftLstmCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( cntrPkupChgAmt[i] !=	null)
						model.setCntrPkupChgAmt( cntrPkupChgAmt[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( cntrPkupPsvAmt[i] !=	null)
						model.setCntrPkupPsvAmt( cntrPkupPsvAmt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( cntrPkupNgvAmt[i] !=	null)
						model.setCntrPkupNgvAmt( cntrPkupNgvAmt[i]);
						if ( rntlChgFreeDys[i] !=	null)
						model.setRntlChgFreeDys( rntlChgFreeDys[i]);
						if ( aftVndrSeq[i] !=	null)
						model.setAftVndrSeq( aftVndrSeq[i]);
						if ( aftAgmtSeq[i] !=	null)
						model.setAftAgmtSeq( aftAgmtSeq[i]);
						if ( curAgmtSeq[i] !=	null)
						model.setCurAgmtSeq( curAgmtSeq[i]);
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( curAgmtCtyCd[i] !=	null)
						model.setCurAgmtCtyCd( curAgmtCtyCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( diiFee[i] !=	null)
						model.setDiiFee( diiFee[i]);
						if ( lstStsYdCd[i] !=	null)
						model.setLstStsYdCd( lstStsYdCd[i]);
						if ( rowSeq[i] !=	null)
						model.setRowSeq( rowSeq[i]);
						if ( termCngSeq[i] !=	null)
						model.setTermCngSeq( termCngSeq[i]);
						if ( seqSet[i] !=	null)
						model.setSeqSet( seqSet[i]);
						if ( actDt[i] !=	null)
						model.setActDt( actDt[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( dirItchgVndrSeq[i] !=	null)
						model.setDirItchgVndrSeq( dirItchgVndrSeq[i]);
						if ( delChk[i] !=	null)
						model.setDelChk( delChk[i]);
						if ( cntrStsSeq[i] !=	null)
						model.setCntrStsSeq( cntrStsSeq[i]);
						if ( ydCd[i] !=	null)
						model.setYdCd( ydCd[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( sccCd[i] !=	null)
						model.setSccCd( sccCd[i]);
						if ( eccCd[i] !=	null)
						model.setEccCd( eccCd[i]);
						if ( lccCd[i] !=	null)
						model.setLccCd( lccCd[i]);
						if ( rccCd[i] !=	null)
						model.setRccCd( rccCd[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( errCd[i] !=	null)
						model.setErrCd( errCd[i]);
						if ( dpCntrStsCd[i] !=	null)
						model.setDpCntrStsCd( dpCntrStsCd[i]);
						if ( dpCnmvStsCd[i] !=	null)
						model.setDpCnmvStsCd( dpCnmvStsCd[i]);
						if ( dpOnhDt[i] !=	null)
						model.setDpOnhDt( dpOnhDt[i]);
						if ( rstrUsgTpLblNm3[i] !=	null)
						model.setRstrUsgTpLblNm3( rstrUsgTpLblNm3[i]);
						if ( rstrUsgTpLblNm8[i] !=	null)
						model.setRstrUsgTpLblNm8( rstrUsgTpLblNm8[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getTermChangeCreationVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return TermChangeCreationVO[]
	 */
	public TermChangeCreationVO[]	 getTermChangeCreationVOs(){
		TermChangeCreationVO[] vos = (TermChangeCreationVO[])models.toArray(new	TermChangeCreationVO[models.size()]);
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
		this.cntrFullFlg =	this.cntrFullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd =	this.cntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diFlag =	this.diFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftAgmtCtyCd =	this.aftAgmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt =	this.onhDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMinOnhDys =	this.cntrMinOnhDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftLstmCd =	this.aftLstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupChgAmt =	this.cntrPkupChgAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupPsvAmt =	this.cntrPkupPsvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPkupNgvAmt =	this.cntrPkupNgvAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChgFreeDys =	this.rntlChgFreeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftVndrSeq =	this.aftVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aftAgmtSeq =	this.aftAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curAgmtSeq =	this.curAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curAgmtCtyCd =	this.curAgmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diiFee =	this.diiFee.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstStsYdCd =	this.lstStsYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq =	this.rowSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCngSeq =	this.termCngSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seqSet =	this.seqSet.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDt =	this.actDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirItchgVndrSeq =	this.dirItchgVndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delChk =	this.delChk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsSeq =	this.cntrStsSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd =	this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd =	this.sccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eccCd =	this.eccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd =	this.lccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd =	this.rccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errCd =	this.errCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpCntrStsCd =	this.dpCntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpCnmvStsCd =	this.dpCnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dpOnhDt =	this.dpOnhDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm3 =	this.rstrUsgTpLblNm3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgTpLblNm8 =	this.rstrUsgTpLblNm8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}