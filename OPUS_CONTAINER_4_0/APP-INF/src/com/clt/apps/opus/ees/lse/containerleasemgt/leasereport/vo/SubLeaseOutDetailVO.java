/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SubLeaseOutDetailVO.java
 *@FileTitle : SubLeaseOutDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.06.14
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.06.14  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo;

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
 * - 愿�젴	Event�먯꽌	�묒꽦,	�쒕쾭�ㅽ뻾�붿껌��PDTO����븷���섑뻾�섎뒗 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class SubLeaseOutDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SubLeaseOutDetailVO>  models =	new	ArrayList<SubLeaseOutDetailVO>();


	/*	Column Info	*/
	private  String	 cntrFullFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrStsEvntDt   =  null;
	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 lsiAgmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 lsiAgmtSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 ttlUseDys   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 lsiAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 refNo   =  null;
	/*	Column Info	*/
	private  String	 lsiRefNo   =  null;
	/*	Column Info	*/
	private  String	 rccCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 lccCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 sccCd   =  null;
	/*	Column Info	*/
	private  String	 ydCd   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntryCd   =  null;
	/*	Column Info	*/
	private  String	 vndrAbbrNm   =  null;
	/*	Column Info	*/
	private  String	 rntlChgFreeDys   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 pdmAmt   =  null;
	/*	Column Info	*/
	private  String	 lonAmt   =  null;
	/*	Column Info	*/
	private  String	 lofAmt   =  null;
	/*	Column Info	*/
	private  String	 docAmt   =  null;
	/*	Column Info	*/
	private  String	 ttlAmt   =  null;
	/*	Column Info	*/
	private  String	 cntrRtnEvntDt   =  null;
	/*	Column Info	*/
	private  String	 rtnYdCd   =  null;
	/*	Column Info	*/
	private  String	 cntrOnhAuthNo   =  null;
	/*	Column Info	*/
	private  String	 approvalNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SubLeaseOutDetailVO(){}

	public SubLeaseOutDetailVO(String cntrFullFlg,String cntrStsEvntDt,String agmtCtyCd,String lsiAgmtCtyCd,String agmtSeq,String lsiAgmtSeq,String cntrStsCd,String ttlUseDys,String agmtNo,String lsiAgmtNo,String refNo,String lsiRefNo,String rccCd,String pagerows,String lccCd,String ibflag,String locCd,String sccCd,String ydCd,String vndrSeq,String cntrNo,String cntrTpszCd,String cntryCd,String vndrAbbrNm,String rntlChgFreeDys,String lstmCd,String pdmAmt,String lonAmt,String lofAmt,String docAmt,String ttlAmt,String cntrRtnEvntDt,String rtnYdCd,String cntrOnhAuthNo,String approvalNo)	{
		this.cntrFullFlg  = cntrFullFlg ;
		this.cntrStsEvntDt  = cntrStsEvntDt ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.lsiAgmtCtyCd  = lsiAgmtCtyCd ;
		this.agmtSeq  = agmtSeq ;
		this.lsiAgmtSeq  = lsiAgmtSeq ;
		this.cntrStsCd  = cntrStsCd ;
		this.ttlUseDys  = ttlUseDys ;
		this.agmtNo  = agmtNo ;
		this.lsiAgmtNo  = lsiAgmtNo ;
		this.refNo  = refNo ;
		this.lsiRefNo  = lsiRefNo ;
		this.rccCd  = rccCd ;
		this.pagerows  = pagerows ;
		this.lccCd  = lccCd ;
		this.ibflag  = ibflag ;
		this.locCd  = locCd ;
		this.sccCd  = sccCd ;
		this.ydCd  = ydCd ;
		this.vndrSeq  = vndrSeq ;
		this.cntrNo  = cntrNo ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.cntryCd  = cntryCd ;
		this.vndrAbbrNm  = vndrAbbrNm ;
		this.rntlChgFreeDys  = rntlChgFreeDys ;
		this.lstmCd  = lstmCd ;
		this.pdmAmt  = pdmAmt ;
		this.lonAmt  = lonAmt ;
		this.lofAmt  = lofAmt ;
		this.docAmt  = docAmt ;
		this.ttlAmt  = ttlAmt ;
		this.cntrRtnEvntDt  = cntrRtnEvntDt ;
		this.rtnYdCd  = rtnYdCd ;
		this.cntrOnhAuthNo  = cntrOnhAuthNo ;
		this.approvalNo  = approvalNo ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cntr_full_flg", getCntrFullFlg());		
		this.hashColumns.put("cntr_sts_evnt_dt", getCntrStsEvntDt());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("lsi_agmt_cty_cd", getLsiAgmtCtyCd());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("lsi_agmt_seq", getLsiAgmtSeq());		
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());		
		this.hashColumns.put("ttl_use_dys", getTtlUseDys());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("lsi_agmt_no", getLsiAgmtNo());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("lsi_ref_no", getLsiRefNo());		
		this.hashColumns.put("rcc_cd", getRccCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("lcc_cd", getLccCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("scc_cd", getSccCd());		
		this.hashColumns.put("yd_cd", getYdCd());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("cntry_cd", getCntryCd());		
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());		
		this.hashColumns.put("rntl_chg_free_dys", getRntlChgFreeDys());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("pdm_amt", getPdmAmt());		
		this.hashColumns.put("lon_amt", getLonAmt());		
		this.hashColumns.put("lof_amt", getLofAmt());		
		this.hashColumns.put("doc_amt", getDocAmt());		
		this.hashColumns.put("ttl_amt", getTtlAmt());		
		this.hashColumns.put("cntr_rtn_evnt_dt", getCntrRtnEvntDt());		
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());		
		this.hashColumns.put("cntr_onh_auth_no", getCntrOnhAuthNo());
		this.hashColumns.put("approval_no", getApprovalNo());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("cntr_full_flg", "cntrFullFlg");
		this.hashFields.put("cntr_sts_evnt_dt", "cntrStsEvntDt");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("lsi_agmt_cty_cd", "lsiAgmtCtyCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("lsi_agmt_seq", "lsiAgmtSeq");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("ttl_use_dys", "ttlUseDys");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("lsi_agmt_no", "lsiAgmtNo");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("lsi_ref_no", "lsiRefNo");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("scc_cd", "sccCd");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntry_cd", "cntryCd");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		this.hashFields.put("rntl_chg_free_dys", "rntlChgFreeDys");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("pdm_amt", "pdmAmt");
		this.hashFields.put("lon_amt", "lonAmt");
		this.hashFields.put("lof_amt", "lofAmt");
		this.hashFields.put("doc_amt", "docAmt");
		this.hashFields.put("ttl_amt", "ttlAmt");
		this.hashFields.put("cntr_rtn_evnt_dt", "cntrRtnEvntDt");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("cntr_onh_auth_no", "cntrOnhAuthNo");
		this.hashFields.put("approval_no", "approvalNo");
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
	* @param  cntrStsEvntDt
	*/
	public void	setCntrStsEvntDt( String	cntrStsEvntDt ) {
		this.cntrStsEvntDt =	cntrStsEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsEvntDt
	 */
	 public	 String	getCntrStsEvntDt() {
		 return	this.cntrStsEvntDt;
	 } 
 	/**
	* Column Info
	* @param  agmtCtyCd
	*/
	public void	setAgmtCtyCd( String	agmtCtyCd ) {
		this.agmtCtyCd =	agmtCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtCtyCd
	 */
	 public	 String	getAgmtCtyCd() {
		 return	this.agmtCtyCd;
	 } 
 	/**
	* Column Info
	* @param  lsiAgmtCtyCd
	*/
	public void	setLsiAgmtCtyCd( String	lsiAgmtCtyCd ) {
		this.lsiAgmtCtyCd =	lsiAgmtCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	lsiAgmtCtyCd
	 */
	 public	 String	getLsiAgmtCtyCd() {
		 return	this.lsiAgmtCtyCd;
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
	* @param  lsiAgmtSeq
	*/
	public void	setLsiAgmtSeq( String	lsiAgmtSeq ) {
		this.lsiAgmtSeq =	lsiAgmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	lsiAgmtSeq
	 */
	 public	 String	getLsiAgmtSeq() {
		 return	this.lsiAgmtSeq;
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
	* @param  ttlUseDys
	*/
	public void	setTtlUseDys( String	ttlUseDys ) {
		this.ttlUseDys =	ttlUseDys;
	}
 
	/**
	 * Column Info
	 * @return	ttlUseDys
	 */
	 public	 String	getTtlUseDys() {
		 return	this.ttlUseDys;
	 } 
 	/**
	* Column Info
	* @param  agmtNo
	*/
	public void	setAgmtNo( String	agmtNo ) {
		this.agmtNo =	agmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtNo
	 */
	 public	 String	getAgmtNo() {
		 return	this.agmtNo;
	 } 
 	/**
	* Column Info
	* @param  lsiAgmtNo
	*/
	public void	setLsiAgmtNo( String	lsiAgmtNo ) {
		this.lsiAgmtNo =	lsiAgmtNo;
	}
 
	/**
	 * Column Info
	 * @return	lsiAgmtNo
	 */
	 public	 String	getLsiAgmtNo() {
		 return	this.lsiAgmtNo;
	 } 
 	/**
	* Column Info
	* @param  refNo
	*/
	public void	setRefNo( String	refNo ) {
		this.refNo =	refNo;
	}
 
	/**
	 * Column Info
	 * @return	refNo
	 */
	 public	 String	getRefNo() {
		 return	this.refNo;
	 } 
 	/**
	* Column Info
	* @param  lsiRefNo
	*/
	public void	setLsiRefNo( String	lsiRefNo ) {
		this.lsiRefNo =	lsiRefNo;
	}
 
	/**
	 * Column Info
	 * @return	lsiRefNo
	 */
	 public	 String	getLsiRefNo() {
		 return	this.lsiRefNo;
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
	* @param  cntryCd
	*/
	public void	setCntryCd( String	cntryCd ) {
		this.cntryCd =	cntryCd;
	}
 
	/**
	 * Column Info
	 * @return	cntryCd
	 */
	 public	 String	getCntryCd() {
		 return	this.cntryCd;
	 } 
 	/**
	* Column Info
	* @param  vndrAbbrNm
	*/
	public void	setVndrAbbrNm( String	vndrAbbrNm ) {
		this.vndrAbbrNm =	vndrAbbrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrAbbrNm
	 */
	 public	 String	getVndrAbbrNm() {
		 return	this.vndrAbbrNm;
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
	* @param  lstmCd
	*/
	public void	setLstmCd( String	lstmCd ) {
		this.lstmCd =	lstmCd;
	}
 
	/**
	 * Column Info
	 * @return	lstmCd
	 */
	 public	 String	getLstmCd() {
		 return	this.lstmCd;
	 } 
 	/**
	* Column Info
	* @param  pdmAmt
	*/
	public void	setPdmAmt( String	pdmAmt ) {
		this.pdmAmt =	pdmAmt;
	}
 
	/**
	 * Column Info
	 * @return	pdmAmt
	 */
	 public	 String	getPdmAmt() {
		 return	this.pdmAmt;
	 } 
 	/**
	* Column Info
	* @param  lonAmt
	*/
	public void	setLonAmt( String	lonAmt ) {
		this.lonAmt =	lonAmt;
	}
 
	/**
	 * Column Info
	 * @return	lonAmt
	 */
	 public	 String	getLonAmt() {
		 return	this.lonAmt;
	 } 
 	/**
	* Column Info
	* @param  lofAmt
	*/
	public void	setLofAmt( String	lofAmt ) {
		this.lofAmt =	lofAmt;
	}
 
	/**
	 * Column Info
	 * @return	lofAmt
	 */
	 public	 String	getLofAmt() {
		 return	this.lofAmt;
	 } 
 	/**
	* Column Info
	* @param  docAmt
	*/
	public void	setDocAmt( String	docAmt ) {
		this.docAmt =	docAmt;
	}
 
	/**
	 * Column Info
	 * @return	docAmt
	 */
	 public	 String	getDocAmt() {
		 return	this.docAmt;
	 } 
 	/**
	* Column Info
	* @param  ttlAmt
	*/
	public void	setTtlAmt( String	ttlAmt ) {
		this.ttlAmt =	ttlAmt;
	}
 
	/**
	 * Column Info
	 * @return	ttlAmt
	 */
	 public	 String	getTtlAmt() {
		 return	this.ttlAmt;
	 } 
 	/**
	* Column Info
	* @param  cntrRtnEvntDt
	*/
	public void	setCntrRtnEvntDt( String	cntrRtnEvntDt ) {
		this.cntrRtnEvntDt =	cntrRtnEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	cntrRtnEvntDt
	 */
	 public	 String	getCntrRtnEvntDt() {
		 return	this.cntrRtnEvntDt;
	 } 
 	/**
	* Column Info
	* @param  rtnYdCd
	*/
	public void	setRtnYdCd( String	rtnYdCd ) {
		this.rtnYdCd =	rtnYdCd;
	}
 
	/**
	 * Column Info
	 * @return	rtnYdCd
	 */
	 public	 String	getRtnYdCd() {
		 return	this.rtnYdCd;
	 } 
 	/**
	* Column Info
	* @param  cntrOnhAuthNo
	*/
	public void	setCntrOnhAuthNo( String	cntrOnhAuthNo ) {
		this.cntrOnhAuthNo =	cntrOnhAuthNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrOnhAuthNo
	 */
	 public	 String	getCntrOnhAuthNo() {
		 return	this.cntrOnhAuthNo;
	 } 
	 /**
	* Column Info
	* @param  approvalNo
	*/
	public void	setApprovalNo( String	approvalNo ) {
		this.approvalNo =	approvalNo;
	}
 
	/**
	 * Column Info
	 * @return	approvalNo
	 */
	 public	 String	getApprovalNo() {
		 return	this.approvalNo;
	 } 

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request ���곗씠�곕� 異붿텧�섏뿬 VO ��硫ㅻ쾭蹂�닔���ㅼ젙.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setCntrFullFlg(JSPUtil.getParameter(request,	prefix + "cntr_full_flg", ""));
		setCntrStsEvntDt(JSPUtil.getParameter(request,	prefix + "cntr_sts_evnt_dt", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setLsiAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "lsi_agmt_cty_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setLsiAgmtSeq(JSPUtil.getParameter(request,	prefix + "lsi_agmt_seq", ""));
		setCntrStsCd(JSPUtil.getParameter(request,	prefix + "cntr_sts_cd", ""));
		setTtlUseDys(JSPUtil.getParameter(request,	prefix + "ttl_use_dys", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setLsiAgmtNo(JSPUtil.getParameter(request,	prefix + "lsi_agmt_no", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setLsiRefNo(JSPUtil.getParameter(request,	prefix + "lsi_ref_no", ""));
		setRccCd(JSPUtil.getParameter(request,	prefix + "rcc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setLccCd(JSPUtil.getParameter(request,	prefix + "lcc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setSccCd(JSPUtil.getParameter(request,	prefix + "scc_cd", ""));
		setYdCd(JSPUtil.getParameter(request,	prefix + "yd_cd", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setCntryCd(JSPUtil.getParameter(request,	prefix + "cntry_cd", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request,	prefix + "vndr_abbr_nm", ""));
		setRntlChgFreeDys(JSPUtil.getParameter(request,	prefix + "rntl_chg_free_dys", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setPdmAmt(JSPUtil.getParameter(request,	prefix + "pdm_amt", ""));
		setLonAmt(JSPUtil.getParameter(request,	prefix + "lon_amt", ""));
		setLofAmt(JSPUtil.getParameter(request,	prefix + "lof_amt", ""));
		setDocAmt(JSPUtil.getParameter(request,	prefix + "doc_amt", ""));
		setTtlAmt(JSPUtil.getParameter(request,	prefix + "ttl_amt", ""));
		setCntrRtnEvntDt(JSPUtil.getParameter(request,	prefix + "cntr_rtn_evnt_dt", ""));
		setRtnYdCd(JSPUtil.getParameter(request,	prefix + "rtn_yd_cd", ""));
		setCntrOnhAuthNo(JSPUtil.getParameter(request,	prefix + "cntr_onh_auth_no", ""));
		setApprovalNo(JSPUtil.getParameter(request,	prefix + "approval_no", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return SubLeaseOutDetailVO[]
	 */
	public SubLeaseOutDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return SubLeaseOutDetailVO[]
	 */
	public SubLeaseOutDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SubLeaseOutDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] cntrFullFlg =	(JSPUtil.getParameter(request, prefix +	"cntr_full_flg".trim(),	length));
				String[] cntrStsEvntDt =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_evnt_dt".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] lsiAgmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"lsi_agmt_cty_cd".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] lsiAgmtSeq =	(JSPUtil.getParameter(request, prefix +	"lsi_agmt_seq".trim(),	length));
				String[] cntrStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_cd".trim(),	length));
				String[] ttlUseDys =	(JSPUtil.getParameter(request, prefix +	"ttl_use_dys".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] lsiAgmtNo =	(JSPUtil.getParameter(request, prefix +	"lsi_agmt_no".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] lsiRefNo =	(JSPUtil.getParameter(request, prefix +	"lsi_ref_no".trim(),	length));
				String[] rccCd =	(JSPUtil.getParameter(request, prefix +	"rcc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] lccCd =	(JSPUtil.getParameter(request, prefix +	"lcc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] sccCd =	(JSPUtil.getParameter(request, prefix +	"scc_cd".trim(),	length));
				String[] ydCd =	(JSPUtil.getParameter(request, prefix +	"yd_cd".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] cntryCd =	(JSPUtil.getParameter(request, prefix +	"cntry_cd".trim(),	length));
				String[] vndrAbbrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_abbr_nm".trim(),	length));
				String[] rntlChgFreeDys =	(JSPUtil.getParameter(request, prefix +	"rntl_chg_free_dys".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] pdmAmt =	(JSPUtil.getParameter(request, prefix +	"pdm_amt".trim(),	length));
				String[] lonAmt =	(JSPUtil.getParameter(request, prefix +	"lon_amt".trim(),	length));
				String[] lofAmt =	(JSPUtil.getParameter(request, prefix +	"lof_amt".trim(),	length));
				String[] docAmt =	(JSPUtil.getParameter(request, prefix +	"doc_amt".trim(),	length));
				String[] ttlAmt =	(JSPUtil.getParameter(request, prefix +	"ttl_amt".trim(),	length));
				String[] cntrRtnEvntDt =	(JSPUtil.getParameter(request, prefix +	"cntr_rtn_evnt_dt".trim(),	length));
				String[] rtnYdCd =	(JSPUtil.getParameter(request, prefix +	"rtn_yd_cd".trim(),	length));
				String[] cntrOnhAuthNo =	(JSPUtil.getParameter(request, prefix +	"cntr_onh_auth_no".trim(),	length));
				String[] approvalNo =	(JSPUtil.getParameter(request, prefix +	"approval_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SubLeaseOutDetailVO();
						if ( cntrFullFlg[i] !=	null)
						model.setCntrFullFlg( cntrFullFlg[i]);
						if ( cntrStsEvntDt[i] !=	null)
						model.setCntrStsEvntDt( cntrStsEvntDt[i]);
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( lsiAgmtCtyCd[i] !=	null)
						model.setLsiAgmtCtyCd( lsiAgmtCtyCd[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( lsiAgmtSeq[i] !=	null)
						model.setLsiAgmtSeq( lsiAgmtSeq[i]);
						if ( cntrStsCd[i] !=	null)
						model.setCntrStsCd( cntrStsCd[i]);
						if ( ttlUseDys[i] !=	null)
						model.setTtlUseDys( ttlUseDys[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( lsiAgmtNo[i] !=	null)
						model.setLsiAgmtNo( lsiAgmtNo[i]);
						if ( refNo[i] !=	null)
						model.setRefNo( refNo[i]);
						if ( lsiRefNo[i] !=	null)
						model.setLsiRefNo( lsiRefNo[i]);
						if ( rccCd[i] !=	null)
						model.setRccCd( rccCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( lccCd[i] !=	null)
						model.setLccCd( lccCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( sccCd[i] !=	null)
						model.setSccCd( sccCd[i]);
						if ( ydCd[i] !=	null)
						model.setYdCd( ydCd[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( cntryCd[i] !=	null)
						model.setCntryCd( cntryCd[i]);
						if ( vndrAbbrNm[i] !=	null)
						model.setVndrAbbrNm( vndrAbbrNm[i]);
						if ( rntlChgFreeDys[i] !=	null)
						model.setRntlChgFreeDys( rntlChgFreeDys[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( pdmAmt[i] !=	null)
						model.setPdmAmt( pdmAmt[i]);
						if ( lonAmt[i] !=	null)
						model.setLonAmt( lonAmt[i]);
						if ( lofAmt[i] !=	null)
						model.setLofAmt( lofAmt[i]);
						if ( docAmt[i] !=	null)
						model.setDocAmt( docAmt[i]);
						if ( ttlAmt[i] !=	null)
						model.setTtlAmt( ttlAmt[i]);
						if ( cntrRtnEvntDt[i] !=	null)
						model.setCntrRtnEvntDt( cntrRtnEvntDt[i]);
						if ( rtnYdCd[i] !=	null)
						model.setRtnYdCd( rtnYdCd[i]);
						if ( cntrOnhAuthNo[i] !=	null)
						model.setCntrOnhAuthNo( cntrOnhAuthNo[i]);
						if ( approvalNo[i] !=	null)
						model.setApprovalNo( approvalNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSubLeaseOutDetailVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return SubLeaseOutDetailVO[]
	 */
	public SubLeaseOutDetailVO[]	 getSubLeaseOutDetailVOs(){
		SubLeaseOutDetailVO[] vos = (SubLeaseOutDetailVO[])models.toArray(new	SubLeaseOutDetailVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class���댁슜��String�쇰줈 蹂�솚
	 */
	public String  toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* �щ㎎�낅맂 臾몄옄�댁뿉���뱀닔臾몄옄 �쒓굅("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.cntrFullFlg =	this.cntrFullFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsEvntDt =	this.cntrStsEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiAgmtCtyCd =	this.lsiAgmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiAgmtSeq =	this.lsiAgmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd =	this.cntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlUseDys =	this.ttlUseDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiAgmtNo =	this.lsiAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lsiRefNo =	this.lsiRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd =	this.rccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd =	this.lccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sccCd =	this.sccCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd =	this.ydCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntryCd =	this.cntryCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm =	this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rntlChgFreeDys =	this.rntlChgFreeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pdmAmt =	this.pdmAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lonAmt =	this.lonAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lofAmt =	this.lofAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docAmt =	this.docAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlAmt =	this.ttlAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnEvntDt =	this.cntrRtnEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd =	this.rtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrOnhAuthNo =	this.cntrOnhAuthNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.approvalNo =	this.approvalNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}