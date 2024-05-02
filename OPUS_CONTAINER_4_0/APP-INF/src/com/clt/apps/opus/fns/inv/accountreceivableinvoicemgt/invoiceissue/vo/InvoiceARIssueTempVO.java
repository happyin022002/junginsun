/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InvoiceARIssueTempVO.java
 *@FileTitle : InvoiceARIssueTempVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.05.27  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo;

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
public class InvoiceARIssueTempVO	extends	 AbstractValueObject 
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InvoiceARIssueTempVO>  models =	new	ArrayList<InvoiceARIssueTempVO>();


	/*	Column Info	*/
	private  String	 invIssSndTpCd   =  null;
	/*	Column Info	*/
	private  String	 rissDt   =  null;
	/*	Column Info	*/
	private  String	 usdXchRt   =  null;
	/*	Column Info	*/
	private  String	 issOfcCd   =  null;
	/*	Column Info	*/
	private  String	 issOptTpFlg   =  null;
	/*	Column Info	*/
	private  String	 issOptCpyKnt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 issOptSndFlg   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt1   =  null;
	/*	Column Info	*/
	private  String	 issDt   =  null;
	/*	Column Info	*/
	private  String	 invIssCmbFlg   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt2   =  null;
	/*	Column Info	*/
	private  String	 loclPoNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt3   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt4   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt5   =  null;
	/*	Column Info	*/
	private  String	 invIssRmk   =  null;
	/*	Column Info	*/
	private  String	 invXchRtDt   =  null;
	/*	Column Info	*/
	private  String	 invLineNo   =  null;
	/*	Column Info	*/
	private  String	 issGrpTpCd   =  null;
	/*	Column Info	*/
	private  String	 fmInvNo   =  null;
	/*	Column Info	*/
	private  String	 issOptOfcCd   =  null;
	/*	Column Info	*/
	private  String	 prvFlg   =  null;
	/*	Column Info	*/
	private  String	 issOptRptFileNm   =  null;
	/*	Column Info	*/
	private  String	 issOptLgoFlg   =  null;
	/*	Column Info	*/
	private  String	 actInvNo   =  null;
	/*	Column Info	*/
	private  String	 mltInvNoCtnt   =  null;
	/*	Column Info	*/
	private  String	 n2ndInvIssSndTpCd   =  null;
	/*	Column Info	*/
	private  String	 invNo   =  null;
	/*	Column Info	*/
	private  String	 invSglFlg   =  null;
	/*	Column Info	*/
	private  String	 invIssTmpSeq   =  null;
	/*	Column Info	*/
	private  String	 toInvNo   =  null;
	/*	Column Info	*/
	private  String	 issOptRissFlg   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt6   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt7   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt8   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt9   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt10   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt11   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt12   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt13   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt14   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt15   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt16   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt17   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt18   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt19   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt20   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt21   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt22   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt23   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt24   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt25   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InvoiceARIssueTempVO(){}

	public InvoiceARIssueTempVO(String invIssSndTpCd,String rissDt,String usdXchRt,String issOfcCd,String issOptTpFlg,String issOptCpyKnt,String pagerows,String issOptSndFlg,String attrCtnt1,String issDt,String invIssCmbFlg,String attrCtnt2,String loclPoNo,String ibflag,String attrCtnt3,String attrCtnt4,String usrId,String attrCtnt5,String invIssRmk,String invXchRtDt,String invLineNo,String issGrpTpCd,String fmInvNo,String issOptOfcCd,String prvFlg,String issOptRptFileNm,String issOptLgoFlg,String actInvNo,String mltInvNoCtnt,String n2ndInvIssSndTpCd,String invNo,String invSglFlg,String invIssTmpSeq,String toInvNo,String issOptRissFlg,String attrCtnt6,String attrCtnt7,String attrCtnt8,String attrCtnt9,String attrCtnt10,String attrCtnt11,String attrCtnt12,String attrCtnt13,String attrCtnt14,String attrCtnt15,String attrCtnt16,String attrCtnt17,String attrCtnt18,String attrCtnt19,String attrCtnt20,String attrCtnt21,String attrCtnt22,String attrCtnt23,String attrCtnt24,String attrCtnt25)	{
		this.invIssSndTpCd  = invIssSndTpCd ;
		this.rissDt  = rissDt ;
		this.usdXchRt  = usdXchRt ;
		this.issOfcCd  = issOfcCd ;
		this.issOptTpFlg  = issOptTpFlg ;
		this.issOptCpyKnt  = issOptCpyKnt ;
		this.pagerows  = pagerows ;
		this.issOptSndFlg  = issOptSndFlg ;
		this.attrCtnt1  = attrCtnt1 ;
		this.issDt  = issDt ;
		this.invIssCmbFlg  = invIssCmbFlg ;
		this.attrCtnt2  = attrCtnt2 ;
		this.loclPoNo  = loclPoNo ;
		this.ibflag  = ibflag ;
		this.attrCtnt3  = attrCtnt3 ;
		this.attrCtnt4  = attrCtnt4 ;
		this.usrId  = usrId ;
		this.attrCtnt5  = attrCtnt5 ;
		this.invIssRmk  = invIssRmk ;
		this.invXchRtDt  = invXchRtDt ;
		this.invLineNo  = invLineNo ;
		this.issGrpTpCd  = issGrpTpCd ;
		this.fmInvNo  = fmInvNo ;
		this.issOptOfcCd  = issOptOfcCd ;
		this.prvFlg  = prvFlg ;
		this.issOptRptFileNm  = issOptRptFileNm ;
		this.issOptLgoFlg  = issOptLgoFlg ;
		this.actInvNo  = actInvNo ;
		this.mltInvNoCtnt  = mltInvNoCtnt ;
		this.n2ndInvIssSndTpCd  = n2ndInvIssSndTpCd ;
		this.invNo  = invNo ;
		this.invSglFlg  = invSglFlg ;
		this.invIssTmpSeq  = invIssTmpSeq ;
		this.toInvNo  = toInvNo ;
		this.issOptRissFlg  = issOptRissFlg ;
		this.attrCtnt6  = attrCtnt6 ;
		this.attrCtnt7  = attrCtnt7 ;
		this.attrCtnt8  = attrCtnt8 ;
		this.attrCtnt9  = attrCtnt9 ;
		this.attrCtnt10  = attrCtnt10 ;
		this.attrCtnt11  = attrCtnt11 ;
		this.attrCtnt12  = attrCtnt12 ;
		this.attrCtnt13  = attrCtnt13 ;
		this.attrCtnt14  = attrCtnt14 ;
		this.attrCtnt15  = attrCtnt15 ;
		this.attrCtnt16  = attrCtnt16 ;
		this.attrCtnt17  = attrCtnt17 ;
		this.attrCtnt18  = attrCtnt18 ;
		this.attrCtnt19  = attrCtnt19 ;
		this.attrCtnt20  = attrCtnt20 ;
		this.attrCtnt21  = attrCtnt21 ;
		this.attrCtnt22  = attrCtnt22 ;
		this.attrCtnt23  = attrCtnt23 ;
		this.attrCtnt24  = attrCtnt24 ;
		this.attrCtnt25  = attrCtnt25 ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_iss_snd_tp_cd", getInvIssSndTpCd());		
		this.hashColumns.put("riss_dt", getRissDt());		
		this.hashColumns.put("usd_xch_rt", getUsdXchRt());		
		this.hashColumns.put("iss_ofc_cd", getIssOfcCd());		
		this.hashColumns.put("iss_opt_tp_flg", getIssOptTpFlg());		
		this.hashColumns.put("iss_opt_cpy_knt", getIssOptCpyKnt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("iss_opt_snd_flg", getIssOptSndFlg());		
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());		
		this.hashColumns.put("iss_dt", getIssDt());		
		this.hashColumns.put("inv_iss_cmb_flg", getInvIssCmbFlg());		
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());		
		this.hashColumns.put("locl_po_no", getLoclPoNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());		
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());		
		this.hashColumns.put("inv_iss_rmk", getInvIssRmk());		
		this.hashColumns.put("inv_xch_rt_dt", getInvXchRtDt());		
		this.hashColumns.put("inv_line_no", getInvLineNo());		
		this.hashColumns.put("iss_grp_tp_cd", getIssGrpTpCd());		
		this.hashColumns.put("fm_inv_no", getFmInvNo());		
		this.hashColumns.put("iss_opt_ofc_cd", getIssOptOfcCd());		
		this.hashColumns.put("prv_flg", getPrvFlg());		
		this.hashColumns.put("iss_opt_rpt_file_nm", getIssOptRptFileNm());		
		this.hashColumns.put("iss_opt_lgo_flg", getIssOptLgoFlg());		
		this.hashColumns.put("act_inv_no", getActInvNo());		
		this.hashColumns.put("mlt_inv_no_ctnt", getMltInvNoCtnt());		
		this.hashColumns.put("n2nd_inv_iss_snd_tp_cd", getN2ndInvIssSndTpCd());		
		this.hashColumns.put("inv_no", getInvNo());		
		this.hashColumns.put("inv_sgl_flg", getInvSglFlg());		
		this.hashColumns.put("inv_iss_tmp_seq", getInvIssTmpSeq());		
		this.hashColumns.put("to_inv_no", getToInvNo());		
		this.hashColumns.put("iss_opt_riss_flg", getIssOptRissFlg());		
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());		
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());		
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());		
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());		
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());		
		this.hashColumns.put("attr_ctnt11", getAttrCtnt11());		
		this.hashColumns.put("attr_ctnt12", getAttrCtnt12());		
		this.hashColumns.put("attr_ctnt13", getAttrCtnt13());		
		this.hashColumns.put("attr_ctnt14", getAttrCtnt14());		
		this.hashColumns.put("attr_ctnt15", getAttrCtnt15());		
		this.hashColumns.put("attr_ctnt16", getAttrCtnt16());		
		this.hashColumns.put("attr_ctnt17", getAttrCtnt17());		
		this.hashColumns.put("attr_ctnt18", getAttrCtnt18());		
		this.hashColumns.put("attr_ctnt19", getAttrCtnt19());		
		this.hashColumns.put("attr_ctnt20", getAttrCtnt20());		
		this.hashColumns.put("attr_ctnt21", getAttrCtnt21());		
		this.hashColumns.put("attr_ctnt22", getAttrCtnt22());		
		this.hashColumns.put("attr_ctnt23", getAttrCtnt23());		
		this.hashColumns.put("attr_ctnt24", getAttrCtnt24());		
		this.hashColumns.put("attr_ctnt25", getAttrCtnt25());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inv_iss_snd_tp_cd", "invIssSndTpCd");
		this.hashFields.put("riss_dt", "rissDt");
		this.hashFields.put("usd_xch_rt", "usdXchRt");
		this.hashFields.put("iss_ofc_cd", "issOfcCd");
		this.hashFields.put("iss_opt_tp_flg", "issOptTpFlg");
		this.hashFields.put("iss_opt_cpy_knt", "issOptCpyKnt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("iss_opt_snd_flg", "issOptSndFlg");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("iss_dt", "issDt");
		this.hashFields.put("inv_iss_cmb_flg", "invIssCmbFlg");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("locl_po_no", "loclPoNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("inv_iss_rmk", "invIssRmk");
		this.hashFields.put("inv_xch_rt_dt", "invXchRtDt");
		this.hashFields.put("inv_line_no", "invLineNo");
		this.hashFields.put("iss_grp_tp_cd", "issGrpTpCd");
		this.hashFields.put("fm_inv_no", "fmInvNo");
		this.hashFields.put("iss_opt_ofc_cd", "issOptOfcCd");
		this.hashFields.put("prv_flg", "prvFlg");
		this.hashFields.put("iss_opt_rpt_file_nm", "issOptRptFileNm");
		this.hashFields.put("iss_opt_lgo_flg", "issOptLgoFlg");
		this.hashFields.put("act_inv_no", "actInvNo");
		this.hashFields.put("mlt_inv_no_ctnt", "mltInvNoCtnt");
		this.hashFields.put("n2nd_inv_iss_snd_tp_cd", "n2ndInvIssSndTpCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("inv_sgl_flg", "invSglFlg");
		this.hashFields.put("inv_iss_tmp_seq", "invIssTmpSeq");
		this.hashFields.put("to_inv_no", "toInvNo");
		this.hashFields.put("iss_opt_riss_flg", "issOptRissFlg");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("attr_ctnt11", "attrCtnt11");
		this.hashFields.put("attr_ctnt12", "attrCtnt12");
		this.hashFields.put("attr_ctnt13", "attrCtnt13");
		this.hashFields.put("attr_ctnt14", "attrCtnt14");
		this.hashFields.put("attr_ctnt15", "attrCtnt15");
		this.hashFields.put("attr_ctnt16", "attrCtnt16");
		this.hashFields.put("attr_ctnt17", "attrCtnt17");
		this.hashFields.put("attr_ctnt18", "attrCtnt18");
		this.hashFields.put("attr_ctnt19", "attrCtnt19");
		this.hashFields.put("attr_ctnt20", "attrCtnt20");
		this.hashFields.put("attr_ctnt21", "attrCtnt21");
		this.hashFields.put("attr_ctnt22", "attrCtnt22");
		this.hashFields.put("attr_ctnt23", "attrCtnt23");
		this.hashFields.put("attr_ctnt24", "attrCtnt24");
		this.hashFields.put("attr_ctnt25", "attrCtnt25");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  invIssSndTpCd
	*/
	public void	setInvIssSndTpCd( String	invIssSndTpCd ) {
		this.invIssSndTpCd =	invIssSndTpCd;
	}
 
	/**
	 * Column Info
	 * @return	invIssSndTpCd
	 */
	 public	 String	getInvIssSndTpCd() {
		 return	this.invIssSndTpCd;
	 } 
 	/**
	* Column Info
	* @param  rissDt
	*/
	public void	setRissDt( String	rissDt ) {
		this.rissDt =	rissDt;
	}
 
	/**
	 * Column Info
	 * @return	rissDt
	 */
	 public	 String	getRissDt() {
		 return	this.rissDt;
	 } 
 	/**
	* Column Info
	* @param  usdXchRt
	*/
	public void	setUsdXchRt( String	usdXchRt ) {
		this.usdXchRt =	usdXchRt;
	}
 
	/**
	 * Column Info
	 * @return	usdXchRt
	 */
	 public	 String	getUsdXchRt() {
		 return	this.usdXchRt;
	 } 
 	/**
	* Column Info
	* @param  issOfcCd
	*/
	public void	setIssOfcCd( String	issOfcCd ) {
		this.issOfcCd =	issOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	issOfcCd
	 */
	 public	 String	getIssOfcCd() {
		 return	this.issOfcCd;
	 } 
 	/**
	* Column Info
	* @param  issOptTpFlg
	*/
	public void	setIssOptTpFlg( String	issOptTpFlg ) {
		this.issOptTpFlg =	issOptTpFlg;
	}
 
	/**
	 * Column Info
	 * @return	issOptTpFlg
	 */
	 public	 String	getIssOptTpFlg() {
		 return	this.issOptTpFlg;
	 } 
 	/**
	* Column Info
	* @param  issOptCpyKnt
	*/
	public void	setIssOptCpyKnt( String	issOptCpyKnt ) {
		this.issOptCpyKnt =	issOptCpyKnt;
	}
 
	/**
	 * Column Info
	 * @return	issOptCpyKnt
	 */
	 public	 String	getIssOptCpyKnt() {
		 return	this.issOptCpyKnt;
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
	* @param  issOptSndFlg
	*/
	public void	setIssOptSndFlg( String	issOptSndFlg ) {
		this.issOptSndFlg =	issOptSndFlg;
	}
 
	/**
	 * Column Info
	 * @return	issOptSndFlg
	 */
	 public	 String	getIssOptSndFlg() {
		 return	this.issOptSndFlg;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt1
	*/
	public void	setAttrCtnt1( String	attrCtnt1 ) {
		this.attrCtnt1 =	attrCtnt1;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt1
	 */
	 public	 String	getAttrCtnt1() {
		 return	this.attrCtnt1;
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
	* @param  invIssCmbFlg
	*/
	public void	setInvIssCmbFlg( String	invIssCmbFlg ) {
		this.invIssCmbFlg =	invIssCmbFlg;
	}
 
	/**
	 * Column Info
	 * @return	invIssCmbFlg
	 */
	 public	 String	getInvIssCmbFlg() {
		 return	this.invIssCmbFlg;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt2
	*/
	public void	setAttrCtnt2( String	attrCtnt2 ) {
		this.attrCtnt2 =	attrCtnt2;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt2
	 */
	 public	 String	getAttrCtnt2() {
		 return	this.attrCtnt2;
	 } 
 	/**
	* Column Info
	* @param  loclPoNo
	*/
	public void	setLoclPoNo( String	loclPoNo ) {
		this.loclPoNo =	loclPoNo;
	}
 
	/**
	 * Column Info
	 * @return	loclPoNo
	 */
	 public	 String	getLoclPoNo() {
		 return	this.loclPoNo;
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
	* @param  attrCtnt3
	*/
	public void	setAttrCtnt3( String	attrCtnt3 ) {
		this.attrCtnt3 =	attrCtnt3;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt3
	 */
	 public	 String	getAttrCtnt3() {
		 return	this.attrCtnt3;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt4
	*/
	public void	setAttrCtnt4( String	attrCtnt4 ) {
		this.attrCtnt4 =	attrCtnt4;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt4
	 */
	 public	 String	getAttrCtnt4() {
		 return	this.attrCtnt4;
	 } 
 	/**
	* Column Info
	* @param  usrId
	*/
	public void	setUsrId( String	usrId ) {
		this.usrId =	usrId;
	}
 
	/**
	 * Column Info
	 * @return	usrId
	 */
	 public	 String	getUsrId() {
		 return	this.usrId;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt5
	*/
	public void	setAttrCtnt5( String	attrCtnt5 ) {
		this.attrCtnt5 =	attrCtnt5;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt5
	 */
	 public	 String	getAttrCtnt5() {
		 return	this.attrCtnt5;
	 } 
 	/**
	* Column Info
	* @param  invIssRmk
	*/
	public void	setInvIssRmk( String	invIssRmk ) {
		this.invIssRmk =	invIssRmk;
	}
 
	/**
	 * Column Info
	 * @return	invIssRmk
	 */
	 public	 String	getInvIssRmk() {
		 return	this.invIssRmk;
	 } 
 	/**
	* Column Info
	* @param  invXchRtDt
	*/
	public void	setInvXchRtDt( String	invXchRtDt ) {
		this.invXchRtDt =	invXchRtDt;
	}
 
	/**
	 * Column Info
	 * @return	invXchRtDt
	 */
	 public	 String	getInvXchRtDt() {
		 return	this.invXchRtDt;
	 } 
 	/**
	* Column Info
	* @param  invLineNo
	*/
	public void	setInvLineNo( String	invLineNo ) {
		this.invLineNo =	invLineNo;
	}
 
	/**
	 * Column Info
	 * @return	invLineNo
	 */
	 public	 String	getInvLineNo() {
		 return	this.invLineNo;
	 } 
 	/**
	* Column Info
	* @param  issGrpTpCd
	*/
	public void	setIssGrpTpCd( String	issGrpTpCd ) {
		this.issGrpTpCd =	issGrpTpCd;
	}
 
	/**
	 * Column Info
	 * @return	issGrpTpCd
	 */
	 public	 String	getIssGrpTpCd() {
		 return	this.issGrpTpCd;
	 } 
 	/**
	* Column Info
	* @param  fmInvNo
	*/
	public void	setFmInvNo( String	fmInvNo ) {
		this.fmInvNo =	fmInvNo;
	}
 
	/**
	 * Column Info
	 * @return	fmInvNo
	 */
	 public	 String	getFmInvNo() {
		 return	this.fmInvNo;
	 } 
 	/**
	* Column Info
	* @param  issOptOfcCd
	*/
	public void	setIssOptOfcCd( String	issOptOfcCd ) {
		this.issOptOfcCd =	issOptOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	issOptOfcCd
	 */
	 public	 String	getIssOptOfcCd() {
		 return	this.issOptOfcCd;
	 } 
 	/**
	* Column Info
	* @param  prvFlg
	*/
	public void	setPrvFlg( String	prvFlg ) {
		this.prvFlg =	prvFlg;
	}
 
	/**
	 * Column Info
	 * @return	prvFlg
	 */
	 public	 String	getPrvFlg() {
		 return	this.prvFlg;
	 } 
 	/**
	* Column Info
	* @param  issOptRptFileNm
	*/
	public void	setIssOptRptFileNm( String	issOptRptFileNm ) {
		this.issOptRptFileNm =	issOptRptFileNm;
	}
 
	/**
	 * Column Info
	 * @return	issOptRptFileNm
	 */
	 public	 String	getIssOptRptFileNm() {
		 return	this.issOptRptFileNm;
	 } 
 	/**
	* Column Info
	* @param  issOptLgoFlg
	*/
	public void	setIssOptLgoFlg( String	issOptLgoFlg ) {
		this.issOptLgoFlg =	issOptLgoFlg;
	}
 
	/**
	 * Column Info
	 * @return	issOptLgoFlg
	 */
	 public	 String	getIssOptLgoFlg() {
		 return	this.issOptLgoFlg;
	 } 
 	/**
	* Column Info
	* @param  actInvNo
	*/
	public void	setActInvNo( String	actInvNo ) {
		this.actInvNo =	actInvNo;
	}
 
	/**
	 * Column Info
	 * @return	actInvNo
	 */
	 public	 String	getActInvNo() {
		 return	this.actInvNo;
	 } 
 	/**
	* Column Info
	* @param  mltInvNoCtnt
	*/
	public void	setMltInvNoCtnt( String	mltInvNoCtnt ) {
		this.mltInvNoCtnt =	mltInvNoCtnt;
	}
 
	/**
	 * Column Info
	 * @return	mltInvNoCtnt
	 */
	 public	 String	getMltInvNoCtnt() {
		 return	this.mltInvNoCtnt;
	 } 
 	/**
	* Column Info
	* @param  n2ndInvIssSndTpCd
	*/
	public void	setN2ndInvIssSndTpCd( String	n2ndInvIssSndTpCd ) {
		this.n2ndInvIssSndTpCd =	n2ndInvIssSndTpCd;
	}
 
	/**
	 * Column Info
	 * @return	n2ndInvIssSndTpCd
	 */
	 public	 String	getN2ndInvIssSndTpCd() {
		 return	this.n2ndInvIssSndTpCd;
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
	* @param  invSglFlg
	*/
	public void	setInvSglFlg( String	invSglFlg ) {
		this.invSglFlg =	invSglFlg;
	}
 
	/**
	 * Column Info
	 * @return	invSglFlg
	 */
	 public	 String	getInvSglFlg() {
		 return	this.invSglFlg;
	 } 
 	/**
	* Column Info
	* @param  invIssTmpSeq
	*/
	public void	setInvIssTmpSeq( String	invIssTmpSeq ) {
		this.invIssTmpSeq =	invIssTmpSeq;
	}
 
	/**
	 * Column Info
	 * @return	invIssTmpSeq
	 */
	 public	 String	getInvIssTmpSeq() {
		 return	this.invIssTmpSeq;
	 } 
 	/**
	* Column Info
	* @param  toInvNo
	*/
	public void	setToInvNo( String	toInvNo ) {
		this.toInvNo =	toInvNo;
	}
 
	/**
	 * Column Info
	 * @return	toInvNo
	 */
	 public	 String	getToInvNo() {
		 return	this.toInvNo;
	 } 
 	/**
	* Column Info
	* @param  issOptRissFlg
	*/
	public void	setIssOptRissFlg( String	issOptRissFlg ) {
		this.issOptRissFlg =	issOptRissFlg;
	}
 
	/**
	 * Column Info
	 * @return	issOptRissFlg
	 */
	 public	 String	getIssOptRissFlg() {
		 return	this.issOptRissFlg;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt6
	*/
	public void	setAttrCtnt6( String	attrCtnt6 ) {
		this.attrCtnt6 =	attrCtnt6;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt6
	 */
	 public	 String	getAttrCtnt6() {
		 return	this.attrCtnt6;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt7
	*/
	public void	setAttrCtnt7( String	attrCtnt7 ) {
		this.attrCtnt7 =	attrCtnt7;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt7
	 */
	 public	 String	getAttrCtnt7() {
		 return	this.attrCtnt7;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt8
	*/
	public void	setAttrCtnt8( String	attrCtnt8 ) {
		this.attrCtnt8 =	attrCtnt8;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt8
	 */
	 public	 String	getAttrCtnt8() {
		 return	this.attrCtnt8;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt9
	*/
	public void	setAttrCtnt9( String	attrCtnt9 ) {
		this.attrCtnt9 =	attrCtnt9;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt9
	 */
	 public	 String	getAttrCtnt9() {
		 return	this.attrCtnt9;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt10
	*/
	public void	setAttrCtnt10( String	attrCtnt10 ) {
		this.attrCtnt10 =	attrCtnt10;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt10
	 */
	 public	 String	getAttrCtnt10() {
		 return	this.attrCtnt10;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt11
	*/
	public void	setAttrCtnt11( String	attrCtnt11 ) {
		this.attrCtnt11 =	attrCtnt11;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt11
	 */
	 public	 String	getAttrCtnt11() {
		 return	this.attrCtnt11;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt12
	*/
	public void	setAttrCtnt12( String	attrCtnt12 ) {
		this.attrCtnt12 =	attrCtnt12;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt12
	 */
	 public	 String	getAttrCtnt12() {
		 return	this.attrCtnt12;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt13
	*/
	public void	setAttrCtnt13( String	attrCtnt13 ) {
		this.attrCtnt13 =	attrCtnt13;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt13
	 */
	 public	 String	getAttrCtnt13() {
		 return	this.attrCtnt13;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt14
	*/
	public void	setAttrCtnt14( String	attrCtnt14 ) {
		this.attrCtnt14 =	attrCtnt14;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt14
	 */
	 public	 String	getAttrCtnt14() {
		 return	this.attrCtnt14;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt15
	*/
	public void	setAttrCtnt15( String	attrCtnt15 ) {
		this.attrCtnt15 =	attrCtnt15;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt15
	 */
	 public	 String	getAttrCtnt15() {
		 return	this.attrCtnt15;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt16
	*/
	public void	setAttrCtnt16( String	attrCtnt16 ) {
		this.attrCtnt16 =	attrCtnt16;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt16
	 */
	 public	 String	getAttrCtnt16() {
		 return	this.attrCtnt16;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt17
	*/
	public void	setAttrCtnt17( String	attrCtnt17 ) {
		this.attrCtnt17 =	attrCtnt17;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt17
	 */
	 public	 String	getAttrCtnt17() {
		 return	this.attrCtnt17;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt18
	*/
	public void	setAttrCtnt18( String	attrCtnt18 ) {
		this.attrCtnt18 =	attrCtnt18;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt18
	 */
	 public	 String	getAttrCtnt18() {
		 return	this.attrCtnt18;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt19
	*/
	public void	setAttrCtnt19( String	attrCtnt19 ) {
		this.attrCtnt19 =	attrCtnt19;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt19
	 */
	 public	 String	getAttrCtnt19() {
		 return	this.attrCtnt19;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt20
	*/
	public void	setAttrCtnt20( String	attrCtnt20 ) {
		this.attrCtnt20 =	attrCtnt20;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt20
	 */
	 public	 String	getAttrCtnt20() {
		 return	this.attrCtnt20;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt21
	*/
	public void	setAttrCtnt21( String	attrCtnt21 ) {
		this.attrCtnt21 =	attrCtnt21;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt21
	 */
	 public	 String	getAttrCtnt21() {
		 return	this.attrCtnt21;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt22
	*/
	public void	setAttrCtnt22( String	attrCtnt22 ) {
		this.attrCtnt22 =	attrCtnt22;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt22
	 */
	 public	 String	getAttrCtnt22() {
		 return	this.attrCtnt22;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt23
	*/
	public void	setAttrCtnt23( String	attrCtnt23 ) {
		this.attrCtnt23 =	attrCtnt23;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt23
	 */
	 public	 String	getAttrCtnt23() {
		 return	this.attrCtnt23;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt24
	*/
	public void	setAttrCtnt24( String	attrCtnt24 ) {
		this.attrCtnt24 =	attrCtnt24;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt24
	 */
	 public	 String	getAttrCtnt24() {
		 return	this.attrCtnt24;
	 } 
 	/**
	* Column Info
	* @param  attrCtnt25
	*/
	public void	setAttrCtnt25( String	attrCtnt25 ) {
		this.attrCtnt25 =	attrCtnt25;
	}
 
	/**
	 * Column Info
	 * @return	attrCtnt25
	 */
	 public	 String	getAttrCtnt25() {
		 return	this.attrCtnt25;
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
		setInvIssSndTpCd(JSPUtil.getParameter(request,	prefix + "inv_iss_snd_tp_cd", ""));
		setRissDt(JSPUtil.getParameter(request,	prefix + "riss_dt", ""));
		setUsdXchRt(JSPUtil.getParameter(request,	prefix + "usd_xch_rt", ""));
		setIssOfcCd(JSPUtil.getParameter(request,	prefix + "iss_ofc_cd", ""));
		setIssOptTpFlg(JSPUtil.getParameter(request,	prefix + "iss_opt_tp_flg", ""));
		setIssOptCpyKnt(JSPUtil.getParameter(request,	prefix + "iss_opt_cpy_knt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIssOptSndFlg(JSPUtil.getParameter(request,	prefix + "iss_opt_snd_flg", ""));
		setAttrCtnt1(JSPUtil.getParameter(request,	prefix + "attr_ctnt1", ""));
		setIssDt(JSPUtil.getParameter(request,	prefix + "iss_dt", ""));
		setInvIssCmbFlg(JSPUtil.getParameter(request,	prefix + "inv_iss_cmb_flg", ""));
		setAttrCtnt2(JSPUtil.getParameter(request,	prefix + "attr_ctnt2", ""));
		setLoclPoNo(JSPUtil.getParameter(request,	prefix + "locl_po_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAttrCtnt3(JSPUtil.getParameter(request,	prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request,	prefix + "attr_ctnt4", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setAttrCtnt5(JSPUtil.getParameter(request,	prefix + "attr_ctnt5", ""));
		setInvIssRmk(JSPUtil.getParameter(request,	prefix + "inv_iss_rmk", ""));
		setInvXchRtDt(JSPUtil.getParameter(request,	prefix + "inv_xch_rt_dt", ""));
		setInvLineNo(JSPUtil.getParameter(request,	prefix + "inv_line_no", ""));
		setIssGrpTpCd(JSPUtil.getParameter(request,	prefix + "iss_grp_tp_cd", ""));
		setFmInvNo(JSPUtil.getParameter(request,	prefix + "fm_inv_no", ""));
		setIssOptOfcCd(JSPUtil.getParameter(request,	prefix + "iss_opt_ofc_cd", ""));
		setPrvFlg(JSPUtil.getParameter(request,	prefix + "prv_flg", ""));
		setIssOptRptFileNm(JSPUtil.getParameter(request,	prefix + "iss_opt_rpt_file_nm", ""));
		setIssOptLgoFlg(JSPUtil.getParameter(request,	prefix + "iss_opt_lgo_flg", ""));
		setActInvNo(JSPUtil.getParameter(request,	prefix + "act_inv_no", ""));
		setMltInvNoCtnt(JSPUtil.getParameter(request,	prefix + "mlt_inv_no_ctnt", ""));
		setN2ndInvIssSndTpCd(JSPUtil.getParameter(request,	prefix + "n2nd_inv_iss_snd_tp_cd", ""));
		setInvNo(JSPUtil.getParameter(request,	prefix + "inv_no", ""));
		setInvSglFlg(JSPUtil.getParameter(request,	prefix + "inv_sgl_flg", ""));
		setInvIssTmpSeq(JSPUtil.getParameter(request,	prefix + "inv_iss_tmp_seq", ""));
		setToInvNo(JSPUtil.getParameter(request,	prefix + "to_inv_no", ""));
		setIssOptRissFlg(JSPUtil.getParameter(request,	prefix + "iss_opt_riss_flg", ""));
		setAttrCtnt6(JSPUtil.getParameter(request,	prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request,	prefix + "attr_ctnt7", ""));
		setAttrCtnt8(JSPUtil.getParameter(request,	prefix + "attr_ctnt8", ""));
		setAttrCtnt9(JSPUtil.getParameter(request,	prefix + "attr_ctnt9", ""));
		setAttrCtnt10(JSPUtil.getParameter(request,	prefix + "attr_ctnt10", ""));
		setAttrCtnt11(JSPUtil.getParameter(request,	prefix + "attr_ctnt11", ""));
		setAttrCtnt12(JSPUtil.getParameter(request,	prefix + "attr_ctnt12", ""));
		setAttrCtnt13(JSPUtil.getParameter(request,	prefix + "attr_ctnt13", ""));
		setAttrCtnt14(JSPUtil.getParameter(request,	prefix + "attr_ctnt14", ""));
		setAttrCtnt15(JSPUtil.getParameter(request,	prefix + "attr_ctnt15", ""));
		setAttrCtnt16(JSPUtil.getParameter(request,	prefix + "attr_ctnt16", ""));
		setAttrCtnt17(JSPUtil.getParameter(request,	prefix + "attr_ctnt17", ""));
		setAttrCtnt18(JSPUtil.getParameter(request,	prefix + "attr_ctnt18", ""));
		setAttrCtnt19(JSPUtil.getParameter(request,	prefix + "attr_ctnt19", ""));
		setAttrCtnt20(JSPUtil.getParameter(request,	prefix + "attr_ctnt20", ""));
		setAttrCtnt21(JSPUtil.getParameter(request,	prefix + "attr_ctnt21", ""));
		setAttrCtnt22(JSPUtil.getParameter(request,	prefix + "attr_ctnt22", ""));
		setAttrCtnt23(JSPUtil.getParameter(request,	prefix + "attr_ctnt23", ""));
		setAttrCtnt24(JSPUtil.getParameter(request,	prefix + "attr_ctnt24", ""));
		setAttrCtnt25(JSPUtil.getParameter(request,	prefix + "attr_ctnt25", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvoiceARIssueTempVO[]
	 */
	public InvoiceARIssueTempVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InvoiceARIssueTempVO[]
	 */
	public InvoiceARIssueTempVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InvoiceARIssueTempVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] invIssSndTpCd =	(JSPUtil.getParameter(request, prefix +	"inv_iss_snd_tp_cd".trim(),	length));
				String[] rissDt =	(JSPUtil.getParameter(request, prefix +	"riss_dt".trim(),	length));
				String[] usdXchRt =	(JSPUtil.getParameter(request, prefix +	"usd_xch_rt".trim(),	length));
				String[] issOfcCd =	(JSPUtil.getParameter(request, prefix +	"iss_ofc_cd".trim(),	length));
				String[] issOptTpFlg =	(JSPUtil.getParameter(request, prefix +	"iss_opt_tp_flg".trim(),	length));
				String[] issOptCpyKnt =	(JSPUtil.getParameter(request, prefix +	"iss_opt_cpy_knt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] issOptSndFlg =	(JSPUtil.getParameter(request, prefix +	"iss_opt_snd_flg".trim(),	length));
				String[] attrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt1".trim(),	length));
				String[] issDt =	(JSPUtil.getParameter(request, prefix +	"iss_dt".trim(),	length));
				String[] invIssCmbFlg =	(JSPUtil.getParameter(request, prefix +	"inv_iss_cmb_flg".trim(),	length));
				String[] attrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt2".trim(),	length));
				String[] loclPoNo =	(JSPUtil.getParameter(request, prefix +	"locl_po_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] attrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt3".trim(),	length));
				String[] attrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt4".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] attrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt5".trim(),	length));
				String[] invIssRmk =	(JSPUtil.getParameter(request, prefix +	"inv_iss_rmk".trim(),	length));
				String[] invXchRtDt =	(JSPUtil.getParameter(request, prefix +	"inv_xch_rt_dt".trim(),	length));
				String[] invLineNo =	(JSPUtil.getParameter(request, prefix +	"inv_line_no".trim(),	length));
				String[] issGrpTpCd =	(JSPUtil.getParameter(request, prefix +	"iss_grp_tp_cd".trim(),	length));
				String[] fmInvNo =	(JSPUtil.getParameter(request, prefix +	"fm_inv_no".trim(),	length));
				String[] issOptOfcCd =	(JSPUtil.getParameter(request, prefix +	"iss_opt_ofc_cd".trim(),	length));
				String[] prvFlg =	(JSPUtil.getParameter(request, prefix +	"prv_flg".trim(),	length));
				String[] issOptRptFileNm =	(JSPUtil.getParameter(request, prefix +	"iss_opt_rpt_file_nm".trim(),	length));
				String[] issOptLgoFlg =	(JSPUtil.getParameter(request, prefix +	"iss_opt_lgo_flg".trim(),	length));
				String[] actInvNo =	(JSPUtil.getParameter(request, prefix +	"act_inv_no".trim(),	length));
				String[] mltInvNoCtnt =	(JSPUtil.getParameter(request, prefix +	"mlt_inv_no_ctnt".trim(),	length));
				String[] n2ndInvIssSndTpCd =	(JSPUtil.getParameter(request, prefix +	"n2nd_inv_iss_snd_tp_cd".trim(),	length));
				String[] invNo =	(JSPUtil.getParameter(request, prefix +	"inv_no".trim(),	length));
				String[] invSglFlg =	(JSPUtil.getParameter(request, prefix +	"inv_sgl_flg".trim(),	length));
				String[] invIssTmpSeq =	(JSPUtil.getParameter(request, prefix +	"inv_iss_tmp_seq".trim(),	length));
				String[] toInvNo =	(JSPUtil.getParameter(request, prefix +	"to_inv_no".trim(),	length));
				String[] issOptRissFlg =	(JSPUtil.getParameter(request, prefix +	"iss_opt_riss_flg".trim(),	length));
				String[] attrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt6".trim(),	length));
				String[] attrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt7".trim(),	length));
				String[] attrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt8".trim(),	length));
				String[] attrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt9".trim(),	length));
				String[] attrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt10".trim(),	length));
				String[] attrCtnt11 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt11".trim(),	length));
				String[] attrCtnt12 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt12".trim(),	length));
				String[] attrCtnt13 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt13".trim(),	length));
				String[] attrCtnt14 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt14".trim(),	length));
				String[] attrCtnt15 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt15".trim(),	length));
				String[] attrCtnt16 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt16".trim(),	length));
				String[] attrCtnt17 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt17".trim(),	length));
				String[] attrCtnt18 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt18".trim(),	length));
				String[] attrCtnt19 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt19".trim(),	length));
				String[] attrCtnt20 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt20".trim(),	length));
				String[] attrCtnt21 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt21".trim(),	length));
				String[] attrCtnt22 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt22".trim(),	length));
				String[] attrCtnt23 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt23".trim(),	length));
				String[] attrCtnt24 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt24".trim(),	length));
				String[] attrCtnt25 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt25".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InvoiceARIssueTempVO();
						if ( invIssSndTpCd[i] !=	null)
						model.setInvIssSndTpCd( invIssSndTpCd[i]);
						if ( rissDt[i] !=	null)
						model.setRissDt( rissDt[i]);
						if ( usdXchRt[i] !=	null)
						model.setUsdXchRt( usdXchRt[i]);
						if ( issOfcCd[i] !=	null)
						model.setIssOfcCd( issOfcCd[i]);
						if ( issOptTpFlg[i] !=	null)
						model.setIssOptTpFlg( issOptTpFlg[i]);
						if ( issOptCpyKnt[i] !=	null)
						model.setIssOptCpyKnt( issOptCpyKnt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( issOptSndFlg[i] !=	null)
						model.setIssOptSndFlg( issOptSndFlg[i]);
						if ( attrCtnt1[i] !=	null)
						model.setAttrCtnt1( attrCtnt1[i]);
						if ( issDt[i] !=	null)
						model.setIssDt( issDt[i]);
						if ( invIssCmbFlg[i] !=	null)
						model.setInvIssCmbFlg( invIssCmbFlg[i]);
						if ( attrCtnt2[i] !=	null)
						model.setAttrCtnt2( attrCtnt2[i]);
						if ( loclPoNo[i] !=	null)
						model.setLoclPoNo( loclPoNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( attrCtnt3[i] !=	null)
						model.setAttrCtnt3( attrCtnt3[i]);
						if ( attrCtnt4[i] !=	null)
						model.setAttrCtnt4( attrCtnt4[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( attrCtnt5[i] !=	null)
						model.setAttrCtnt5( attrCtnt5[i]);
						if ( invIssRmk[i] !=	null)
						model.setInvIssRmk( invIssRmk[i]);
						if ( invXchRtDt[i] !=	null)
						model.setInvXchRtDt( invXchRtDt[i]);
						if ( invLineNo[i] !=	null)
						model.setInvLineNo( invLineNo[i]);
						if ( issGrpTpCd[i] !=	null)
						model.setIssGrpTpCd( issGrpTpCd[i]);
						if ( fmInvNo[i] !=	null)
						model.setFmInvNo( fmInvNo[i]);
						if ( issOptOfcCd[i] !=	null)
						model.setIssOptOfcCd( issOptOfcCd[i]);
						if ( prvFlg[i] !=	null)
						model.setPrvFlg( prvFlg[i]);
						if ( issOptRptFileNm[i] !=	null)
						model.setIssOptRptFileNm( issOptRptFileNm[i]);
						if ( issOptLgoFlg[i] !=	null)
						model.setIssOptLgoFlg( issOptLgoFlg[i]);
						if ( actInvNo[i] !=	null)
						model.setActInvNo( actInvNo[i]);
						if ( mltInvNoCtnt[i] !=	null)
						model.setMltInvNoCtnt( mltInvNoCtnt[i]);
						if ( n2ndInvIssSndTpCd[i] !=	null)
						model.setN2ndInvIssSndTpCd( n2ndInvIssSndTpCd[i]);
						if ( invNo[i] !=	null)
						model.setInvNo( invNo[i]);
						if ( invSglFlg[i] !=	null)
						model.setInvSglFlg( invSglFlg[i]);
						if ( invIssTmpSeq[i] !=	null)
						model.setInvIssTmpSeq( invIssTmpSeq[i]);
						if ( toInvNo[i] !=	null)
						model.setToInvNo( toInvNo[i]);
						if ( issOptRissFlg[i] !=	null)
						model.setIssOptRissFlg( issOptRissFlg[i]);
						if ( attrCtnt6[i] !=	null)
						model.setAttrCtnt6( attrCtnt6[i]);
						if ( attrCtnt7[i] !=	null)
						model.setAttrCtnt7( attrCtnt7[i]);
						if ( attrCtnt8[i] !=	null)
						model.setAttrCtnt8( attrCtnt8[i]);
						if ( attrCtnt9[i] !=	null)
						model.setAttrCtnt9( attrCtnt9[i]);
						if ( attrCtnt10[i] !=	null)
						model.setAttrCtnt10( attrCtnt10[i]);
						if ( attrCtnt11[i] !=	null)
						model.setAttrCtnt11( attrCtnt11[i]);
						if ( attrCtnt12[i] !=	null)
						model.setAttrCtnt12( attrCtnt12[i]);
						if ( attrCtnt13[i] !=	null)
						model.setAttrCtnt13( attrCtnt13[i]);
						if ( attrCtnt14[i] !=	null)
						model.setAttrCtnt14( attrCtnt14[i]);
						if ( attrCtnt15[i] !=	null)
						model.setAttrCtnt15( attrCtnt15[i]);
						if ( attrCtnt16[i] !=	null)
						model.setAttrCtnt16( attrCtnt16[i]);
						if ( attrCtnt17[i] !=	null)
						model.setAttrCtnt17( attrCtnt17[i]);
						if ( attrCtnt18[i] !=	null)
						model.setAttrCtnt18( attrCtnt18[i]);
						if ( attrCtnt19[i] !=	null)
						model.setAttrCtnt19( attrCtnt19[i]);
						if ( attrCtnt20[i] !=	null)
						model.setAttrCtnt20( attrCtnt20[i]);
						if ( attrCtnt21[i] !=	null)
						model.setAttrCtnt21( attrCtnt21[i]);
						if ( attrCtnt22[i] !=	null)
						model.setAttrCtnt22( attrCtnt22[i]);
						if ( attrCtnt23[i] !=	null)
						model.setAttrCtnt23( attrCtnt23[i]);
						if ( attrCtnt24[i] !=	null)
						model.setAttrCtnt24( attrCtnt24[i]);
						if ( attrCtnt25[i] !=	null)
						model.setAttrCtnt25( attrCtnt25[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInvoiceARIssueTempVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InvoiceARIssueTempVO[]
	 */
	public InvoiceARIssueTempVO[]	 getInvoiceARIssueTempVOs(){
		InvoiceARIssueTempVO[] vos = (InvoiceARIssueTempVO[])models.toArray(new	InvoiceARIssueTempVO[models.size()]);
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
		this.invIssSndTpCd =	this.invIssSndTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rissDt =	this.rissDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdXchRt =	this.usdXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOfcCd =	this.issOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOptTpFlg =	this.issOptTpFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOptCpyKnt =	this.issOptCpyKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOptSndFlg =	this.issOptSndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 =	this.attrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issDt =	this.issDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssCmbFlg =	this.invIssCmbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 =	this.attrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclPoNo =	this.loclPoNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 =	this.attrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 =	this.attrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 =	this.attrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssRmk =	this.invIssRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invXchRtDt =	this.invXchRtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invLineNo =	this.invLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issGrpTpCd =	this.issGrpTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmInvNo =	this.fmInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOptOfcCd =	this.issOptOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prvFlg =	this.prvFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOptRptFileNm =	this.issOptRptFileNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOptLgoFlg =	this.issOptLgoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInvNo =	this.actInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltInvNoCtnt =	this.mltInvNoCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n2ndInvIssSndTpCd =	this.n2ndInvIssSndTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo =	this.invNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invSglFlg =	this.invSglFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssTmpSeq =	this.invIssTmpSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toInvNo =	this.toInvNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.issOptRissFlg =	this.issOptRissFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 =	this.attrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 =	this.attrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 =	this.attrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 =	this.attrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 =	this.attrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt11 =	this.attrCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt12 =	this.attrCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt13 =	this.attrCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt14 =	this.attrCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt15 =	this.attrCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt16 =	this.attrCtnt16.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt17 =	this.attrCtnt17.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt18 =	this.attrCtnt18.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt19 =	this.attrCtnt19.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt20 =	this.attrCtnt20.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt21 =	this.attrCtnt21.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt22 =	this.attrCtnt22.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt23 =	this.attrCtnt23.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt24 =	this.attrCtnt24.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt25 =	this.attrCtnt25.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}