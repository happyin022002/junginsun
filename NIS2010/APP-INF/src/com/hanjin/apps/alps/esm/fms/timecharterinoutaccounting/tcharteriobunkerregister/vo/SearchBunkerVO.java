/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : SearchBunkerVO.java
 *@FileTitle : SearchBunkerVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2017.05.17
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2017.05.17  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharteriobunkerregister.vo;

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
public class SearchBunkerVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<SearchBunkerVO>  models =	new	ArrayList<SearchBunkerVO>();


	/*	Column Info	*/
	private  String	 atchFileFletLnkId   =  null;
	/*	Column Info	*/
	private  String	 acctItmNm   =  null;
	/*	Column Info	*/
	private  String	 vslCd   =  null;
	/*	Column Info	*/
	private  String	 atchFileLnkCnt   =  null;
	/*	Column Info	*/
	private  String	 bunkerVvd   =  null;
	/*	Column Info	*/
	private  String	 fletMeasUtCd   =  null;
	/*	Column Info	*/
	private  String	 bnkPrcAmt   =  null;
	/*	Column Info	*/
	private  String	 totalAmt   =  null;
	/*	Column Info	*/
	private  String	 bnkYrmon   =  null;
	/*	Column Info	*/
	private  String	 bnkSeq   =  null;
	/*	Column Info	*/
	private  String	 bnkTpCd   =  null;
	/*	Column Info	*/
	private  String	 bnkDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 fletCtrtNo   =  null;
	/*	Column Info	*/
	private  String	 acctItmSeq   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 bnkAmt   =  null;
	/*	Column Info	*/
	private  String	 acctCd   =  null;
	/*	Column Info	*/
	private  String	 bnkQty   =  null;
	/*	Column Info	*/
	private  String	 portCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 csrNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public SearchBunkerVO(){}

	public SearchBunkerVO(String atchFileFletLnkId,String acctItmNm,String vslCd,String atchFileLnkCnt,String bunkerVvd,String fletMeasUtCd,String bnkPrcAmt,String totalAmt,String bnkYrmon,String bnkSeq,String bnkTpCd,String bnkDt,String pagerows,String fletCtrtNo,String acctItmSeq,String ibflag,String bnkAmt,String acctCd,String bnkQty,String portCd,String updUsrId,String csrNo)	{
		this.atchFileFletLnkId  = atchFileFletLnkId ;
		this.acctItmNm  = acctItmNm ;
		this.vslCd  = vslCd ;
		this.atchFileLnkCnt  = atchFileLnkCnt ;
		this.bunkerVvd  = bunkerVvd ;
		this.fletMeasUtCd  = fletMeasUtCd ;
		this.bnkPrcAmt  = bnkPrcAmt ;
		this.totalAmt  = totalAmt ;
		this.bnkYrmon  = bnkYrmon ;
		this.bnkSeq  = bnkSeq ;
		this.bnkTpCd  = bnkTpCd ;
		this.bnkDt  = bnkDt ;
		this.pagerows  = pagerows ;
		this.fletCtrtNo  = fletCtrtNo ;
		this.acctItmSeq  = acctItmSeq ;
		this.ibflag  = ibflag ;
		this.bnkAmt  = bnkAmt ;
		this.acctCd  = acctCd ;
		this.bnkQty  = bnkQty ;
		this.portCd  = portCd ;
		this.updUsrId  = updUsrId ;
		this.csrNo  = csrNo ;
	}


	/**
	 * �뀒�씠釉� 而щ읆�뿉 ���옣�븷 媛믪쓣 Hashtable<"column_name", "value">	濡� 諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("atch_file_flet_lnk_id", getAtchFileFletLnkId());		
		this.hashColumns.put("acct_itm_nm", getAcctItmNm());		
		this.hashColumns.put("vsl_cd", getVslCd());		
		this.hashColumns.put("atch_file_lnk_cnt", getAtchFileLnkCnt());		
		this.hashColumns.put("bunker_vvd", getBunkerVvd());		
		this.hashColumns.put("flet_meas_ut_cd", getFletMeasUtCd());		
		this.hashColumns.put("bnk_prc_amt", getBnkPrcAmt());		
		this.hashColumns.put("total_amt", getTotalAmt());		
		this.hashColumns.put("bnk_yrmon", getBnkYrmon());		
		this.hashColumns.put("bnk_seq", getBnkSeq());		
		this.hashColumns.put("bnk_tp_cd", getBnkTpCd());		
		this.hashColumns.put("bnk_dt", getBnkDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("flet_ctrt_no", getFletCtrtNo());		
		this.hashColumns.put("acct_itm_seq", getAcctItmSeq());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("bnk_amt", getBnkAmt());		
		this.hashColumns.put("acct_cd", getAcctCd());		
		this.hashColumns.put("bnk_qty", getBnkQty());		
		this.hashColumns.put("port_cd", getPortCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("csr_no", getCsrNo());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	���쓳�릺�뒗 硫ㅻ쾭蹂��닔紐낆쓣	���옣�븯�뿬 Hashtable<"column_name", "variable"> 濡� 諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("atch_file_flet_lnk_id", "atchFileFletLnkId");
		this.hashFields.put("acct_itm_nm", "acctItmNm");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("atch_file_lnk_cnt", "atchFileLnkCnt");
		this.hashFields.put("bunker_vvd", "bunkerVvd");
		this.hashFields.put("flet_meas_ut_cd", "fletMeasUtCd");
		this.hashFields.put("bnk_prc_amt", "bnkPrcAmt");
		this.hashFields.put("total_amt", "totalAmt");
		this.hashFields.put("bnk_yrmon", "bnkYrmon");
		this.hashFields.put("bnk_seq", "bnkSeq");
		this.hashFields.put("bnk_tp_cd", "bnkTpCd");
		this.hashFields.put("bnk_dt", "bnkDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("flet_ctrt_no", "fletCtrtNo");
		this.hashFields.put("acct_itm_seq", "acctItmSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bnk_amt", "bnkAmt");
		this.hashFields.put("acct_cd", "acctCd");
		this.hashFields.put("bnk_qty", "bnkQty");
		this.hashFields.put("port_cd", "portCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("csr_no", "csrNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  atchFileFletLnkId
	*/
	public void	setAtchFileFletLnkId( String	atchFileFletLnkId ) {
		this.atchFileFletLnkId =	atchFileFletLnkId;
	}
 
	/**
	 * Column Info
	 * @return	atchFileFletLnkId
	 */
	 public	 String	getAtchFileFletLnkId() {
		 return	this.atchFileFletLnkId;
	 } 
 	/**
	* Column Info
	* @param  acctItmNm
	*/
	public void	setAcctItmNm( String	acctItmNm ) {
		this.acctItmNm =	acctItmNm;
	}
 
	/**
	 * Column Info
	 * @return	acctItmNm
	 */
	 public	 String	getAcctItmNm() {
		 return	this.acctItmNm;
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
	* @param  atchFileLnkCnt
	*/
	public void	setAtchFileLnkCnt( String	atchFileLnkCnt ) {
		this.atchFileLnkCnt =	atchFileLnkCnt;
	}
 
	/**
	 * Column Info
	 * @return	atchFileLnkCnt
	 */
	 public	 String	getAtchFileLnkCnt() {
		 return	this.atchFileLnkCnt;
	 } 
 	/**
	* Column Info
	* @param  bunkerVvd
	*/
	public void	setBunkerVvd( String	bunkerVvd ) {
		this.bunkerVvd =	bunkerVvd;
	}
 
	/**
	 * Column Info
	 * @return	bunkerVvd
	 */
	 public	 String	getBunkerVvd() {
		 return	this.bunkerVvd;
	 } 
 	/**
	* Column Info
	* @param  fletMeasUtCd
	*/
	public void	setFletMeasUtCd( String	fletMeasUtCd ) {
		this.fletMeasUtCd =	fletMeasUtCd;
	}
 
	/**
	 * Column Info
	 * @return	fletMeasUtCd
	 */
	 public	 String	getFletMeasUtCd() {
		 return	this.fletMeasUtCd;
	 } 
 	/**
	* Column Info
	* @param  bnkPrcAmt
	*/
	public void	setBnkPrcAmt( String	bnkPrcAmt ) {
		this.bnkPrcAmt =	bnkPrcAmt;
	}
 
	/**
	 * Column Info
	 * @return	bnkPrcAmt
	 */
	 public	 String	getBnkPrcAmt() {
		 return	this.bnkPrcAmt;
	 } 
 	/**
	* Column Info
	* @param  totalAmt
	*/
	public void	setTotalAmt( String	totalAmt ) {
		this.totalAmt =	totalAmt;
	}
 
	/**
	 * Column Info
	 * @return	totalAmt
	 */
	 public	 String	getTotalAmt() {
		 return	this.totalAmt;
	 } 
 	/**
	* Column Info
	* @param  bnkYrmon
	*/
	public void	setBnkYrmon( String	bnkYrmon ) {
		this.bnkYrmon =	bnkYrmon;
	}
 
	/**
	 * Column Info
	 * @return	bnkYrmon
	 */
	 public	 String	getBnkYrmon() {
		 return	this.bnkYrmon;
	 } 
 	/**
	* Column Info
	* @param  bnkSeq
	*/
	public void	setBnkSeq( String	bnkSeq ) {
		this.bnkSeq =	bnkSeq;
	}
 
	/**
	 * Column Info
	 * @return	bnkSeq
	 */
	 public	 String	getBnkSeq() {
		 return	this.bnkSeq;
	 } 
 	/**
	* Column Info
	* @param  bnkTpCd
	*/
	public void	setBnkTpCd( String	bnkTpCd ) {
		this.bnkTpCd =	bnkTpCd;
	}
 
	/**
	 * Column Info
	 * @return	bnkTpCd
	 */
	 public	 String	getBnkTpCd() {
		 return	this.bnkTpCd;
	 } 
 	/**
	* Column Info
	* @param  bnkDt
	*/
	public void	setBnkDt( String	bnkDt ) {
		this.bnkDt =	bnkDt;
	}
 
	/**
	 * Column Info
	 * @return	bnkDt
	 */
	 public	 String	getBnkDt() {
		 return	this.bnkDt;
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
	* @param  acctItmSeq
	*/
	public void	setAcctItmSeq( String	acctItmSeq ) {
		this.acctItmSeq =	acctItmSeq;
	}
 
	/**
	 * Column Info
	 * @return	acctItmSeq
	 */
	 public	 String	getAcctItmSeq() {
		 return	this.acctItmSeq;
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
	* @param  bnkAmt
	*/
	public void	setBnkAmt( String	bnkAmt ) {
		this.bnkAmt =	bnkAmt;
	}
 
	/**
	 * Column Info
	 * @return	bnkAmt
	 */
	 public	 String	getBnkAmt() {
		 return	this.bnkAmt;
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
	* @param  bnkQty
	*/
	public void	setBnkQty( String	bnkQty ) {
		this.bnkQty =	bnkQty;
	}
 
	/**
	 * Column Info
	 * @return	bnkQty
	 */
	 public	 String	getBnkQty() {
		 return	this.bnkQty;
	 } 
 	/**
	* Column Info
	* @param  portCd
	*/
	public void	setPortCd( String	portCd ) {
		this.portCd =	portCd;
	}
 
	/**
	 * Column Info
	 * @return	portCd
	 */
	 public	 String	getPortCd() {
		 return	this.portCd;
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
		setAtchFileFletLnkId(JSPUtil.getParameter(request,	prefix + "atch_file_flet_lnk_id", ""));
		setAcctItmNm(JSPUtil.getParameter(request,	prefix + "acct_itm_nm", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setAtchFileLnkCnt(JSPUtil.getParameter(request,	prefix + "atch_file_lnk_cnt", ""));
		setBunkerVvd(JSPUtil.getParameter(request,	prefix + "bunker_vvd", ""));
		setFletMeasUtCd(JSPUtil.getParameter(request,	prefix + "flet_meas_ut_cd", ""));
		setBnkPrcAmt(JSPUtil.getParameter(request,	prefix + "bnk_prc_amt", ""));
		setTotalAmt(JSPUtil.getParameter(request,	prefix + "total_amt", ""));
		setBnkYrmon(JSPUtil.getParameter(request,	prefix + "bnk_yrmon", ""));
		setBnkSeq(JSPUtil.getParameter(request,	prefix + "bnk_seq", ""));
		setBnkTpCd(JSPUtil.getParameter(request,	prefix + "bnk_tp_cd", ""));
		setBnkDt(JSPUtil.getParameter(request,	prefix + "bnk_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setFletCtrtNo(JSPUtil.getParameter(request,	prefix + "flet_ctrt_no", ""));
		setAcctItmSeq(JSPUtil.getParameter(request,	prefix + "acct_itm_seq", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setBnkAmt(JSPUtil.getParameter(request,	prefix + "bnk_amt", ""));
		setAcctCd(JSPUtil.getParameter(request,	prefix + "acct_cd", ""));
		setBnkQty(JSPUtil.getParameter(request,	prefix + "bnk_qty", ""));
		setPortCd(JSPUtil.getParameter(request,	prefix + "port_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setCsrNo(JSPUtil.getParameter(request,	prefix + "csr_no", ""));
	}
	
	/**
	 * Request �쓽 �뜲�씠�꽣瑜� VO 諛곗뿴濡� 蹂��솚�븯�뿬 諛섑솚.
	 * @param request
	 * @return SearchBunkerVO[]
	 */
	public SearchBunkerVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �꽆�뼱�삩 �뿬�윭 嫄�	DATA瑜� VO Class �뿉 �떞�뒗�떎.
	 * @param request
	 * @param prefix
	 * @return SearchBunkerVO[]
	 */
	public SearchBunkerVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		SearchBunkerVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] atchFileFletLnkId =	(JSPUtil.getParameter(request, prefix +	"atch_file_flet_lnk_id".trim(),	length));
				String[] acctItmNm =	(JSPUtil.getParameter(request, prefix +	"acct_itm_nm".trim(),	length));
				String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd".trim(),	length));
				String[] atchFileLnkCnt =	(JSPUtil.getParameter(request, prefix +	"atch_file_lnk_cnt".trim(),	length));
				String[] bunkerVvd =	(JSPUtil.getParameter(request, prefix +	"bunker_vvd".trim(),	length));
				String[] fletMeasUtCd =	(JSPUtil.getParameter(request, prefix +	"flet_meas_ut_cd".trim(),	length));
				String[] bnkPrcAmt =	(JSPUtil.getParameter(request, prefix +	"bnk_prc_amt".trim(),	length));
				String[] totalAmt =	(JSPUtil.getParameter(request, prefix +	"total_amt".trim(),	length));
				String[] bnkYrmon =	(JSPUtil.getParameter(request, prefix +	"bnk_yrmon".trim(),	length));
				String[] bnkSeq =	(JSPUtil.getParameter(request, prefix +	"bnk_seq".trim(),	length));
				String[] bnkTpCd =	(JSPUtil.getParameter(request, prefix +	"bnk_tp_cd".trim(),	length));
				String[] bnkDt =	(JSPUtil.getParameter(request, prefix +	"bnk_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] fletCtrtNo =	(JSPUtil.getParameter(request, prefix +	"flet_ctrt_no".trim(),	length));
				String[] acctItmSeq =	(JSPUtil.getParameter(request, prefix +	"acct_itm_seq".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] bnkAmt =	(JSPUtil.getParameter(request, prefix +	"bnk_amt".trim(),	length));
				String[] acctCd =	(JSPUtil.getParameter(request, prefix +	"acct_cd".trim(),	length));
				String[] bnkQty =	(JSPUtil.getParameter(request, prefix +	"bnk_qty".trim(),	length));
				String[] portCd =	(JSPUtil.getParameter(request, prefix +	"port_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] csrNo =	(JSPUtil.getParameter(request, prefix +	"csr_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	SearchBunkerVO();
						if ( atchFileFletLnkId[i] !=	null)
						model.setAtchFileFletLnkId( atchFileFletLnkId[i]);
						if ( acctItmNm[i] !=	null)
						model.setAcctItmNm( acctItmNm[i]);
						if ( vslCd[i] !=	null)
						model.setVslCd( vslCd[i]);
						if ( atchFileLnkCnt[i] !=	null)
						model.setAtchFileLnkCnt( atchFileLnkCnt[i]);
						if ( bunkerVvd[i] !=	null)
						model.setBunkerVvd( bunkerVvd[i]);
						if ( fletMeasUtCd[i] !=	null)
						model.setFletMeasUtCd( fletMeasUtCd[i]);
						if ( bnkPrcAmt[i] !=	null)
						model.setBnkPrcAmt( bnkPrcAmt[i]);
						if ( totalAmt[i] !=	null)
						model.setTotalAmt( totalAmt[i]);
						if ( bnkYrmon[i] !=	null)
						model.setBnkYrmon( bnkYrmon[i]);
						if ( bnkSeq[i] !=	null)
						model.setBnkSeq( bnkSeq[i]);
						if ( bnkTpCd[i] !=	null)
						model.setBnkTpCd( bnkTpCd[i]);
						if ( bnkDt[i] !=	null)
						model.setBnkDt( bnkDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( fletCtrtNo[i] !=	null)
						model.setFletCtrtNo( fletCtrtNo[i]);
						if ( acctItmSeq[i] !=	null)
						model.setAcctItmSeq( acctItmSeq[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( bnkAmt[i] !=	null)
						model.setBnkAmt( bnkAmt[i]);
						if ( acctCd[i] !=	null)
						model.setAcctCd( acctCd[i]);
						if ( bnkQty[i] !=	null)
						model.setBnkQty( bnkQty[i]);
						if ( portCd[i] !=	null)
						model.setPortCd( portCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( csrNo[i] !=	null)
						model.setCsrNo( csrNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getSearchBunkerVOs();
	}

	/**
	 *  VO 諛곗뿴�쓣 諛섑솚
	 * @return SearchBunkerVO[]
	 */
	public SearchBunkerVO[]	 getSearchBunkerVOs(){
		SearchBunkerVO[] vos = (SearchBunkerVO[])models.toArray(new	SearchBunkerVO[models.size()]);
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
		this.atchFileFletLnkId =	this.atchFileFletLnkId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmNm =	this.acctItmNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.atchFileLnkCnt =	this.atchFileLnkCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bunkerVvd =	this.bunkerVvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletMeasUtCd =	this.fletMeasUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkPrcAmt =	this.bnkPrcAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalAmt =	this.totalAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkYrmon =	this.bnkYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkSeq =	this.bnkSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkTpCd =	this.bnkTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkDt =	this.bnkDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fletCtrtNo =	this.fletCtrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctItmSeq =	this.acctItmSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkAmt =	this.bnkAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCd =	this.acctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnkQty =	this.bnkQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portCd =	this.portCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.csrNo =	this.csrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}