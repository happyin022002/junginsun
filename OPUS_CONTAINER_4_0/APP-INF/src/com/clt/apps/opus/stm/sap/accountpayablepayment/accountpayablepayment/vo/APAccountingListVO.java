/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : APAccountingListVO.java
 *@FileTitle : APAccountingListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.05.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.05.22  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
public class APAccountingListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<APAccountingListVO>  models =	new	ArrayList<APAccountingListVO>();


	/*	Column Info	*/
	private  String	 inpDrAmt   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt10   =  null;
	/*	Column Info	*/
	private  String	 coaAcctCd   =  null;
	/*	Column Info	*/
	private  String	 coaInterCoCd   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt9   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt8   =  null;
	/*	Column Info	*/
	private  String	 coaRgnCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt1   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt2   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt3   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt4   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt5   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt6   =  null;
	/*	Column Info	*/
	private  String	 attrCtnt7   =  null;
	/*	Column Info	*/
	private  String	 convXchRt   =  null;
	/*	Column Info	*/
	private  String	 acctDrAmt   =  null;
	/*	Column Info	*/
	private  String	 acctCrAmt   =  null;
	/*	Column Info	*/
	private  String	 coaCtrCd   =  null;
	/*	Column Info	*/
	private  String	 acctgDt   =  null;
	/*	Column Info	*/
	private  String	 coaVvdCd   =  null;
	/*	Column Info	*/
	private  String	 inpCrAmt   =  null;
	/*	Column Info	*/
	private  String	 coaCoCd   =  null;
	/*	Column Info	*/
	private  String	 acctgErrCd   =  null;
	/*	Column Info	*/
	private  String	 acctgDesc   =  null;
	/*	Column Info	*/
	private  String	 acctgEvntCateCd   =  null;
	/*	Column Info	*/
	private  String	 acctgEvntLineNo   =  null;
	/*	Column Info	*/
	private  String	 acctgEvntTpCd   =  null;
	/*	Column Info	*/
	private  String	 cInpDrAmt   =  null;
	/*	Column Info	*/
	private  String	 cInpCrAmt   =  null;
	/*	Column Info	*/
	private  String	 cAcctDrAmt   =  null;
	/*	Column Info	*/
	private  String	 cAcctCrAmt   =  null;
	/*	Column Info	*/
	private  String	 acctgEvntSeq   =  null;
	/*	Column Info	*/
	private  String	 acctgHdrSeq   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public APAccountingListVO(){}

	public APAccountingListVO(String inpDrAmt,String currCd,String attrCtnt10,String coaAcctCd,String coaInterCoCd,String attrCtnt9,String attrCtnt8,String coaRgnCd,String pagerows,String attrCtnt1,String ibflag,String attrCtnt2,String attrCtnt3,String attrCtnt4,String attrCtnt5,String attrCtnt6,String attrCtnt7,String convXchRt,String acctDrAmt,String acctCrAmt,String coaCtrCd,String acctgDt,String coaVvdCd,String inpCrAmt,String coaCoCd,String acctgErrCd,String acctgDesc,String acctgEvntCateCd,String acctgEvntLineNo,String acctgEvntTpCd,String cInpDrAmt,String cInpCrAmt,String cAcctDrAmt,String cAcctCrAmt,String acctgEvntSeq,String acctgHdrSeq,String usrId)	{
		this.inpDrAmt  = inpDrAmt ;
		this.currCd  = currCd ;
		this.attrCtnt10  = attrCtnt10 ;
		this.coaAcctCd  = coaAcctCd ;
		this.coaInterCoCd  = coaInterCoCd ;
		this.attrCtnt9  = attrCtnt9 ;
		this.attrCtnt8  = attrCtnt8 ;
		this.coaRgnCd  = coaRgnCd ;
		this.pagerows  = pagerows ;
		this.attrCtnt1  = attrCtnt1 ;
		this.ibflag  = ibflag ;
		this.attrCtnt2  = attrCtnt2 ;
		this.attrCtnt3  = attrCtnt3 ;
		this.attrCtnt4  = attrCtnt4 ;
		this.attrCtnt5  = attrCtnt5 ;
		this.attrCtnt6  = attrCtnt6 ;
		this.attrCtnt7  = attrCtnt7 ;
		this.convXchRt  = convXchRt ;
		this.acctDrAmt  = acctDrAmt ;
		this.acctCrAmt  = acctCrAmt ;
		this.coaCtrCd  = coaCtrCd ;
		this.acctgDt  = acctgDt ;
		this.coaVvdCd  = coaVvdCd ;
		this.inpCrAmt  = inpCrAmt ;
		this.coaCoCd  = coaCoCd ;
		this.acctgErrCd  = acctgErrCd ;
		this.acctgDesc  = acctgDesc ;
		this.acctgEvntCateCd  = acctgEvntCateCd ;
		this.acctgEvntLineNo  = acctgEvntLineNo ;
		this.acctgEvntTpCd  = acctgEvntTpCd ;
		this.cInpDrAmt  = cInpDrAmt ;
		this.cInpCrAmt  = cInpCrAmt ;
		this.cAcctDrAmt  = cAcctDrAmt ;
		this.cAcctCrAmt  = cAcctCrAmt ;
		this.acctgEvntSeq  = acctgEvntSeq ;
		this.acctgHdrSeq  = acctgHdrSeq ;
		this.usrId  = usrId ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inp_dr_amt", getInpDrAmt());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("attr_ctnt10", getAttrCtnt10());		
		this.hashColumns.put("coa_acct_cd", getCoaAcctCd());		
		this.hashColumns.put("coa_inter_co_cd", getCoaInterCoCd());		
		this.hashColumns.put("attr_ctnt9", getAttrCtnt9());		
		this.hashColumns.put("attr_ctnt8", getAttrCtnt8());		
		this.hashColumns.put("coa_rgn_cd", getCoaRgnCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("attr_ctnt1", getAttrCtnt1());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("attr_ctnt2", getAttrCtnt2());		
		this.hashColumns.put("attr_ctnt3", getAttrCtnt3());		
		this.hashColumns.put("attr_ctnt4", getAttrCtnt4());		
		this.hashColumns.put("attr_ctnt5", getAttrCtnt5());		
		this.hashColumns.put("attr_ctnt6", getAttrCtnt6());		
		this.hashColumns.put("attr_ctnt7", getAttrCtnt7());		
		this.hashColumns.put("conv_xch_rt", getConvXchRt());		
		this.hashColumns.put("acct_dr_amt", getAcctDrAmt());		
		this.hashColumns.put("acct_cr_amt", getAcctCrAmt());		
		this.hashColumns.put("coa_ctr_cd", getCoaCtrCd());		
		this.hashColumns.put("acctg_dt", getAcctgDt());		
		this.hashColumns.put("coa_vvd_cd", getCoaVvdCd());		
		this.hashColumns.put("inp_cr_amt", getInpCrAmt());		
		this.hashColumns.put("coa_co_cd", getCoaCoCd());		
		this.hashColumns.put("acctg_err_cd", getAcctgErrCd());		
		this.hashColumns.put("acctg_desc", getAcctgDesc());		
		this.hashColumns.put("acctg_evnt_cate_cd", getAcctgEvntCateCd());		
		this.hashColumns.put("acctg_evnt_line_no", getAcctgEvntLineNo());		
		this.hashColumns.put("acctg_evnt_tp_cd", getAcctgEvntTpCd());		
		this.hashColumns.put("c_inp_dr_amt", getCInpDrAmt());		
		this.hashColumns.put("c_inp_cr_amt", getCInpCrAmt());		
		this.hashColumns.put("c_acct_dr_amt", getCAcctDrAmt());		
		this.hashColumns.put("c_acct_cr_amt", getCAcctCrAmt());		
		this.hashColumns.put("acctg_evnt_seq", getAcctgEvntSeq());		
		this.hashColumns.put("acctg_hdr_seq", getAcctgHdrSeq());		
		this.hashColumns.put("usr_id", getUsrId());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("inp_dr_amt", "inpDrAmt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("attr_ctnt10", "attrCtnt10");
		this.hashFields.put("coa_acct_cd", "coaAcctCd");
		this.hashFields.put("coa_inter_co_cd", "coaInterCoCd");
		this.hashFields.put("attr_ctnt9", "attrCtnt9");
		this.hashFields.put("attr_ctnt8", "attrCtnt8");
		this.hashFields.put("coa_rgn_cd", "coaRgnCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("attr_ctnt1", "attrCtnt1");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("attr_ctnt2", "attrCtnt2");
		this.hashFields.put("attr_ctnt3", "attrCtnt3");
		this.hashFields.put("attr_ctnt4", "attrCtnt4");
		this.hashFields.put("attr_ctnt5", "attrCtnt5");
		this.hashFields.put("attr_ctnt6", "attrCtnt6");
		this.hashFields.put("attr_ctnt7", "attrCtnt7");
		this.hashFields.put("conv_xch_rt", "convXchRt");
		this.hashFields.put("acct_dr_amt", "acctDrAmt");
		this.hashFields.put("acct_cr_amt", "acctCrAmt");
		this.hashFields.put("coa_ctr_cd", "coaCtrCd");
		this.hashFields.put("acctg_dt", "acctgDt");
		this.hashFields.put("coa_vvd_cd", "coaVvdCd");
		this.hashFields.put("inp_cr_amt", "inpCrAmt");
		this.hashFields.put("coa_co_cd", "coaCoCd");
		this.hashFields.put("acctg_err_cd", "acctgErrCd");
		this.hashFields.put("acctg_desc", "acctgDesc");
		this.hashFields.put("acctg_evnt_cate_cd", "acctgEvntCateCd");
		this.hashFields.put("acctg_evnt_line_no", "acctgEvntLineNo");
		this.hashFields.put("acctg_evnt_tp_cd", "acctgEvntTpCd");
		this.hashFields.put("c_inp_dr_amt", "cInpDrAmt");
		this.hashFields.put("c_inp_cr_amt", "cInpCrAmt");
		this.hashFields.put("c_acct_dr_amt", "cAcctDrAmt");
		this.hashFields.put("c_acct_cr_amt", "cAcctCrAmt");
		this.hashFields.put("acctg_evnt_seq", "acctgEvntSeq");
		this.hashFields.put("acctg_hdr_seq", "acctgHdrSeq");
		this.hashFields.put("usr_id", "usrId");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  inpDrAmt
	*/
	public void	setInpDrAmt( String	inpDrAmt ) {
		this.inpDrAmt =	inpDrAmt;
	}
 
	/**
	 * Column Info
	 * @return	inpDrAmt
	 */
	 public	String	getInpDrAmt() {
		 return	this.inpDrAmt;
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
	 public	String	getCurrCd() {
		 return	this.currCd;
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
	 public	String	getAttrCtnt10() {
		 return	this.attrCtnt10;
	 } 
 	/**
	* Column Info
	* @param  coaAcctCd
	*/
	public void	setCoaAcctCd( String	coaAcctCd ) {
		this.coaAcctCd =	coaAcctCd;
	}
 
	/**
	 * Column Info
	 * @return	coaAcctCd
	 */
	 public	String	getCoaAcctCd() {
		 return	this.coaAcctCd;
	 } 
 	/**
	* Column Info
	* @param  coaInterCoCd
	*/
	public void	setCoaInterCoCd( String	coaInterCoCd ) {
		this.coaInterCoCd =	coaInterCoCd;
	}
 
	/**
	 * Column Info
	 * @return	coaInterCoCd
	 */
	 public	String	getCoaInterCoCd() {
		 return	this.coaInterCoCd;
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
	 public	String	getAttrCtnt9() {
		 return	this.attrCtnt9;
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
	 public	String	getAttrCtnt8() {
		 return	this.attrCtnt8;
	 } 
 	/**
	* Column Info
	* @param  coaRgnCd
	*/
	public void	setCoaRgnCd( String	coaRgnCd ) {
		this.coaRgnCd =	coaRgnCd;
	}
 
	/**
	 * Column Info
	 * @return	coaRgnCd
	 */
	 public	String	getCoaRgnCd() {
		 return	this.coaRgnCd;
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
	 public	String	getPagerows() {
		 return	this.pagerows;
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
	 public	String	getAttrCtnt1() {
		 return	this.attrCtnt1;
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
	 public	String	getIbflag() {
		 return	this.ibflag;
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
	 public	String	getAttrCtnt2() {
		 return	this.attrCtnt2;
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
	 public	String	getAttrCtnt3() {
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
	 public	String	getAttrCtnt4() {
		 return	this.attrCtnt4;
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
	 public	String	getAttrCtnt5() {
		 return	this.attrCtnt5;
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
	 public	String	getAttrCtnt6() {
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
	 public	String	getAttrCtnt7() {
		 return	this.attrCtnt7;
	 } 
 	/**
	* Column Info
	* @param  convXchRt
	*/
	public void	setConvXchRt( String	convXchRt ) {
		this.convXchRt =	convXchRt;
	}
 
	/**
	 * Column Info
	 * @return	convXchRt
	 */
	 public	String	getConvXchRt() {
		 return	this.convXchRt;
	 } 
 	/**
	* Column Info
	* @param  acctDrAmt
	*/
	public void	setAcctDrAmt( String	acctDrAmt ) {
		this.acctDrAmt =	acctDrAmt;
	}
 
	/**
	 * Column Info
	 * @return	acctDrAmt
	 */
	 public	String	getAcctDrAmt() {
		 return	this.acctDrAmt;
	 } 
 	/**
	* Column Info
	* @param  acctCrAmt
	*/
	public void	setAcctCrAmt( String	acctCrAmt ) {
		this.acctCrAmt =	acctCrAmt;
	}
 
	/**
	 * Column Info
	 * @return	acctCrAmt
	 */
	 public	String	getAcctCrAmt() {
		 return	this.acctCrAmt;
	 } 
 	/**
	* Column Info
	* @param  coaCtrCd
	*/
	public void	setCoaCtrCd( String	coaCtrCd ) {
		this.coaCtrCd =	coaCtrCd;
	}
 
	/**
	 * Column Info
	 * @return	coaCtrCd
	 */
	 public	String	getCoaCtrCd() {
		 return	this.coaCtrCd;
	 } 
 	/**
	* Column Info
	* @param  acctgDt
	*/
	public void	setAcctgDt( String	acctgDt ) {
		this.acctgDt =	acctgDt;
	}
 
	/**
	 * Column Info
	 * @return	acctgDt
	 */
	 public	String	getAcctgDt() {
		 return	this.acctgDt;
	 } 
 	/**
	* Column Info
	* @param  coaVvdCd
	*/
	public void	setCoaVvdCd( String	coaVvdCd ) {
		this.coaVvdCd =	coaVvdCd;
	}
 
	/**
	 * Column Info
	 * @return	coaVvdCd
	 */
	 public	String	getCoaVvdCd() {
		 return	this.coaVvdCd;
	 } 
 	/**
	* Column Info
	* @param  inpCrAmt
	*/
	public void	setInpCrAmt( String	inpCrAmt ) {
		this.inpCrAmt =	inpCrAmt;
	}
 
	/**
	 * Column Info
	 * @return	inpCrAmt
	 */
	 public	String	getInpCrAmt() {
		 return	this.inpCrAmt;
	 } 
 	/**
	* Column Info
	* @param  coaCoCd
	*/
	public void	setCoaCoCd( String	coaCoCd ) {
		this.coaCoCd =	coaCoCd;
	}
 
	/**
	 * Column Info
	 * @return	coaCoCd
	 */
	 public	String	getCoaCoCd() {
		 return	this.coaCoCd;
	 } 
 	/**
	* Column Info
	* @param  acctgErrCd
	*/
	public void	setAcctgErrCd( String	acctgErrCd ) {
		this.acctgErrCd =	acctgErrCd;
	}
 
	/**
	 * Column Info
	 * @return	acctgErrCd
	 */
	 public	String	getAcctgErrCd() {
		 return	this.acctgErrCd;
	 } 
 	/**
	* Column Info
	* @param  acctgDesc
	*/
	public void	setAcctgDesc( String	acctgDesc ) {
		this.acctgDesc =	acctgDesc;
	}
 
	/**
	 * Column Info
	 * @return	acctgDesc
	 */
	 public	String	getAcctgDesc() {
		 return	this.acctgDesc;
	 } 
 	/**
	* Column Info
	* @param  acctgEvntCateCd
	*/
	public void	setAcctgEvntCateCd( String	acctgEvntCateCd ) {
		this.acctgEvntCateCd =	acctgEvntCateCd;
	}
 
	/**
	 * Column Info
	 * @return	acctgEvntCateCd
	 */
	 public	String	getAcctgEvntCateCd() {
		 return	this.acctgEvntCateCd;
	 } 
 	/**
	* Column Info
	* @param  acctgEvntLineNo
	*/
	public void	setAcctgEvntLineNo( String	acctgEvntLineNo ) {
		this.acctgEvntLineNo =	acctgEvntLineNo;
	}
 
	/**
	 * Column Info
	 * @return	acctgEvntLineNo
	 */
	 public	String	getAcctgEvntLineNo() {
		 return	this.acctgEvntLineNo;
	 } 
 	/**
	* Column Info
	* @param  acctgEvntTpCd
	*/
	public void	setAcctgEvntTpCd( String	acctgEvntTpCd ) {
		this.acctgEvntTpCd =	acctgEvntTpCd;
	}
 
	/**
	 * Column Info
	 * @return	acctgEvntTpCd
	 */
	 public	String	getAcctgEvntTpCd() {
		 return	this.acctgEvntTpCd;
	 } 
 	/**
	* Column Info
	* @param  cInpDrAmt
	*/
	public void	setCInpDrAmt( String	cInpDrAmt ) {
		this.cInpDrAmt =	cInpDrAmt;
	}
 
	/**
	 * Column Info
	 * @return	cInpDrAmt
	 */
	 public	String	getCInpDrAmt() {
		 return	this.cInpDrAmt;
	 } 
 	/**
	* Column Info
	* @param  cInpCrAmt
	*/
	public void	setCInpCrAmt( String	cInpCrAmt ) {
		this.cInpCrAmt =	cInpCrAmt;
	}
 
	/**
	 * Column Info
	 * @return	cInpCrAmt
	 */
	 public	String	getCInpCrAmt() {
		 return	this.cInpCrAmt;
	 } 
 	/**
	* Column Info
	* @param  cAcctDrAmt
	*/
	public void	setCAcctDrAmt( String	cAcctDrAmt ) {
		this.cAcctDrAmt =	cAcctDrAmt;
	}
 
	/**
	 * Column Info
	 * @return	cAcctDrAmt
	 */
	 public	String	getCAcctDrAmt() {
		 return	this.cAcctDrAmt;
	 } 
 	/**
	* Column Info
	* @param  cAcctCrAmt
	*/
	public void	setCAcctCrAmt( String	cAcctCrAmt ) {
		this.cAcctCrAmt =	cAcctCrAmt;
	}
 
	/**
	 * Column Info
	 * @return	cAcctCrAmt
	 */
	 public	String	getCAcctCrAmt() {
		 return	this.cAcctCrAmt;
	 } 
 	/**
	* Column Info
	* @param  acctgEvntSeq
	*/
	public void	setAcctgEvntSeq( String	acctgEvntSeq ) {
		this.acctgEvntSeq =	acctgEvntSeq;
	}
 
	/**
	 * Column Info
	 * @return	acctgEvntSeq
	 */
	 public	String	getAcctgEvntSeq() {
		 return	this.acctgEvntSeq;
	 } 
 	/**
	* Column Info
	* @param  acctgHdrSeq
	*/
	public void	setAcctgHdrSeq( String	acctgHdrSeq ) {
		this.acctgHdrSeq =	acctgHdrSeq;
	}
 
	/**
	 * Column Info
	 * @return	acctgHdrSeq
	 */
	 public	String	getAcctgHdrSeq() {
		 return	this.acctgHdrSeq;
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
	 public	String	getUsrId() {
		 return	this.usrId;
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
		setInpDrAmt(JSPUtil.getParameter(request,	prefix + "inp_dr_amt", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setAttrCtnt10(JSPUtil.getParameter(request,	prefix + "attr_ctnt10", ""));
		setCoaAcctCd(JSPUtil.getParameter(request,	prefix + "coa_acct_cd", ""));
		setCoaInterCoCd(JSPUtil.getParameter(request,	prefix + "coa_inter_co_cd", ""));
		setAttrCtnt9(JSPUtil.getParameter(request,	prefix + "attr_ctnt9", ""));
		setAttrCtnt8(JSPUtil.getParameter(request,	prefix + "attr_ctnt8", ""));
		setCoaRgnCd(JSPUtil.getParameter(request,	prefix + "coa_rgn_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAttrCtnt1(JSPUtil.getParameter(request,	prefix + "attr_ctnt1", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAttrCtnt2(JSPUtil.getParameter(request,	prefix + "attr_ctnt2", ""));
		setAttrCtnt3(JSPUtil.getParameter(request,	prefix + "attr_ctnt3", ""));
		setAttrCtnt4(JSPUtil.getParameter(request,	prefix + "attr_ctnt4", ""));
		setAttrCtnt5(JSPUtil.getParameter(request,	prefix + "attr_ctnt5", ""));
		setAttrCtnt6(JSPUtil.getParameter(request,	prefix + "attr_ctnt6", ""));
		setAttrCtnt7(JSPUtil.getParameter(request,	prefix + "attr_ctnt7", ""));
		setConvXchRt(JSPUtil.getParameter(request,	prefix + "conv_xch_rt", ""));
		setAcctDrAmt(JSPUtil.getParameter(request,	prefix + "acct_dr_amt", ""));
		setAcctCrAmt(JSPUtil.getParameter(request,	prefix + "acct_cr_amt", ""));
		setCoaCtrCd(JSPUtil.getParameter(request,	prefix + "coa_ctr_cd", ""));
		setAcctgDt(JSPUtil.getParameter(request,	prefix + "acctg_dt", ""));
		setCoaVvdCd(JSPUtil.getParameter(request,	prefix + "coa_vvd_cd", ""));
		setInpCrAmt(JSPUtil.getParameter(request,	prefix + "inp_cr_amt", ""));
		setCoaCoCd(JSPUtil.getParameter(request,	prefix + "coa_co_cd", ""));
		setAcctgErrCd(JSPUtil.getParameter(request,	prefix + "acctg_err_cd", ""));
		setAcctgDesc(JSPUtil.getParameter(request,	prefix + "acctg_desc", ""));
		setAcctgEvntCateCd(JSPUtil.getParameter(request,	prefix + "acctg_evnt_cate_cd", ""));
		setAcctgEvntLineNo(JSPUtil.getParameter(request,	prefix + "acctg_evnt_line_no", ""));
		setAcctgEvntTpCd(JSPUtil.getParameter(request,	prefix + "acctg_evnt_tp_cd", ""));
		setCInpDrAmt(JSPUtil.getParameter(request,	prefix + "c_inp_dr_amt", ""));
		setCInpCrAmt(JSPUtil.getParameter(request,	prefix + "c_inp_cr_amt", ""));
		setCAcctDrAmt(JSPUtil.getParameter(request,	prefix + "c_acct_dr_amt", ""));
		setCAcctCrAmt(JSPUtil.getParameter(request,	prefix + "c_acct_cr_amt", ""));
		setAcctgEvntSeq(JSPUtil.getParameter(request,	prefix + "acctg_evnt_seq", ""));
		setAcctgHdrSeq(JSPUtil.getParameter(request,	prefix + "acctg_hdr_seq", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return APAccountingListVO[]
	 */
	public APAccountingListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return APAccountingListVO[]
	 */
	public APAccountingListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		APAccountingListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] inpDrAmt =	(JSPUtil.getParameter(request, prefix +	"inp_dr_amt".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] attrCtnt10 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt10".trim(),	length));
				String[] coaAcctCd =	(JSPUtil.getParameter(request, prefix +	"coa_acct_cd".trim(),	length));
				String[] coaInterCoCd =	(JSPUtil.getParameter(request, prefix +	"coa_inter_co_cd".trim(),	length));
				String[] attrCtnt9 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt9".trim(),	length));
				String[] attrCtnt8 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt8".trim(),	length));
				String[] coaRgnCd =	(JSPUtil.getParameter(request, prefix +	"coa_rgn_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] attrCtnt1 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt1".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] attrCtnt2 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt2".trim(),	length));
				String[] attrCtnt3 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt3".trim(),	length));
				String[] attrCtnt4 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt4".trim(),	length));
				String[] attrCtnt5 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt5".trim(),	length));
				String[] attrCtnt6 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt6".trim(),	length));
				String[] attrCtnt7 =	(JSPUtil.getParameter(request, prefix +	"attr_ctnt7".trim(),	length));
				String[] convXchRt =	(JSPUtil.getParameter(request, prefix +	"conv_xch_rt".trim(),	length));
				String[] acctDrAmt =	(JSPUtil.getParameter(request, prefix +	"acct_dr_amt".trim(),	length));
				String[] acctCrAmt =	(JSPUtil.getParameter(request, prefix +	"acct_cr_amt".trim(),	length));
				String[] coaCtrCd =	(JSPUtil.getParameter(request, prefix +	"coa_ctr_cd".trim(),	length));
				String[] acctgDt =	(JSPUtil.getParameter(request, prefix +	"acctg_dt".trim(),	length));
				String[] coaVvdCd =	(JSPUtil.getParameter(request, prefix +	"coa_vvd_cd".trim(),	length));
				String[] inpCrAmt =	(JSPUtil.getParameter(request, prefix +	"inp_cr_amt".trim(),	length));
				String[] coaCoCd =	(JSPUtil.getParameter(request, prefix +	"coa_co_cd".trim(),	length));
				String[] acctgErrCd =	(JSPUtil.getParameter(request, prefix +	"acctg_err_cd".trim(),	length));
				String[] acctgDesc =	(JSPUtil.getParameter(request, prefix +	"acctg_desc".trim(),	length));
				String[] acctgEvntCateCd =	(JSPUtil.getParameter(request, prefix +	"acctg_evnt_cate_cd".trim(),	length));
				String[] acctgEvntLineNo =	(JSPUtil.getParameter(request, prefix +	"acctg_evnt_line_no".trim(),	length));
				String[] acctgEvntTpCd =	(JSPUtil.getParameter(request, prefix +	"acctg_evnt_tp_cd".trim(),	length));
				String[] cInpDrAmt =	(JSPUtil.getParameter(request, prefix +	"c_inp_dr_amt".trim(),	length));
				String[] cInpCrAmt =	(JSPUtil.getParameter(request, prefix +	"c_inp_cr_amt".trim(),	length));
				String[] cAcctDrAmt =	(JSPUtil.getParameter(request, prefix +	"c_acct_dr_amt".trim(),	length));
				String[] cAcctCrAmt =	(JSPUtil.getParameter(request, prefix +	"c_acct_cr_amt".trim(),	length));
				String[] acctgEvntSeq =	(JSPUtil.getParameter(request, prefix +	"acctg_evnt_seq".trim(),	length));
				String[] acctgHdrSeq =	(JSPUtil.getParameter(request, prefix +	"acctg_hdr_seq".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	APAccountingListVO();
						if ( inpDrAmt[i] !=	null)
						model.setInpDrAmt( inpDrAmt[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( attrCtnt10[i] !=	null)
						model.setAttrCtnt10( attrCtnt10[i]);
						if ( coaAcctCd[i] !=	null)
						model.setCoaAcctCd( coaAcctCd[i]);
						if ( coaInterCoCd[i] !=	null)
						model.setCoaInterCoCd( coaInterCoCd[i]);
						if ( attrCtnt9[i] !=	null)
						model.setAttrCtnt9( attrCtnt9[i]);
						if ( attrCtnt8[i] !=	null)
						model.setAttrCtnt8( attrCtnt8[i]);
						if ( coaRgnCd[i] !=	null)
						model.setCoaRgnCd( coaRgnCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( attrCtnt1[i] !=	null)
						model.setAttrCtnt1( attrCtnt1[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( attrCtnt2[i] !=	null)
						model.setAttrCtnt2( attrCtnt2[i]);
						if ( attrCtnt3[i] !=	null)
						model.setAttrCtnt3( attrCtnt3[i]);
						if ( attrCtnt4[i] !=	null)
						model.setAttrCtnt4( attrCtnt4[i]);
						if ( attrCtnt5[i] !=	null)
						model.setAttrCtnt5( attrCtnt5[i]);
						if ( attrCtnt6[i] !=	null)
						model.setAttrCtnt6( attrCtnt6[i]);
						if ( attrCtnt7[i] !=	null)
						model.setAttrCtnt7( attrCtnt7[i]);
						if ( convXchRt[i] !=	null)
						model.setConvXchRt( convXchRt[i]);
						if ( acctDrAmt[i] !=	null)
						model.setAcctDrAmt( acctDrAmt[i]);
						if ( acctCrAmt[i] !=	null)
						model.setAcctCrAmt( acctCrAmt[i]);
						if ( coaCtrCd[i] !=	null)
						model.setCoaCtrCd( coaCtrCd[i]);
						if ( acctgDt[i] !=	null)
						model.setAcctgDt( acctgDt[i]);
						if ( coaVvdCd[i] !=	null)
						model.setCoaVvdCd( coaVvdCd[i]);
						if ( inpCrAmt[i] !=	null)
						model.setInpCrAmt( inpCrAmt[i]);
						if ( coaCoCd[i] !=	null)
						model.setCoaCoCd( coaCoCd[i]);
						if ( acctgErrCd[i] !=	null)
						model.setAcctgErrCd( acctgErrCd[i]);
						if ( acctgDesc[i] !=	null)
						model.setAcctgDesc( acctgDesc[i]);
						if ( acctgEvntCateCd[i] !=	null)
						model.setAcctgEvntCateCd( acctgEvntCateCd[i]);
						if ( acctgEvntLineNo[i] !=	null)
						model.setAcctgEvntLineNo( acctgEvntLineNo[i]);
						if ( acctgEvntTpCd[i] !=	null)
						model.setAcctgEvntTpCd( acctgEvntTpCd[i]);
						if ( cInpDrAmt[i] !=	null)
						model.setCInpDrAmt( cInpDrAmt[i]);
						if ( cInpCrAmt[i] !=	null)
						model.setCInpCrAmt( cInpCrAmt[i]);
						if ( cAcctDrAmt[i] !=	null)
						model.setCAcctDrAmt( cAcctDrAmt[i]);
						if ( cAcctCrAmt[i] !=	null)
						model.setCAcctCrAmt( cAcctCrAmt[i]);
						if ( acctgEvntSeq[i] !=	null)
						model.setAcctgEvntSeq( acctgEvntSeq[i]);
						if ( acctgHdrSeq[i] !=	null)
						model.setAcctgHdrSeq( acctgHdrSeq[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAPAccountingListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return APAccountingListVO[]
	 */
	public APAccountingListVO[]	 getAPAccountingListVOs(){
		APAccountingListVO[] vos = (APAccountingListVO[])models.toArray(new	APAccountingListVO[models.size()]);
		return vos;
		}

	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		   return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE );
	}
	

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void	unDataFormat(){
		this.inpDrAmt =	this.inpDrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt10 =	this.attrCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaAcctCd =	this.coaAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaInterCoCd =	this.coaInterCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt9 =	this.attrCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt8 =	this.attrCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaRgnCd =	this.coaRgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt1 =	this.attrCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt2 =	this.attrCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt3 =	this.attrCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt4 =	this.attrCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt5 =	this.attrCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt6 =	this.attrCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.attrCtnt7 =	this.attrCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.convXchRt =	this.convXchRt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctDrAmt =	this.acctDrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCrAmt =	this.acctCrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCtrCd =	this.coaCtrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgDt =	this.acctgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaVvdCd =	this.coaVvdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.inpCrAmt =	this.inpCrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaCoCd =	this.coaCoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgErrCd =	this.acctgErrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgDesc =	this.acctgDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgEvntCateCd =	this.acctgEvntCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgEvntLineNo =	this.acctgEvntLineNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgEvntTpCd =	this.acctgEvntTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cInpDrAmt =	this.cInpDrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cInpCrAmt =	this.cInpCrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cAcctDrAmt =	this.cAcctDrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cAcctCrAmt =	this.cAcctCrAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgEvntSeq =	this.acctgEvntSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgHdrSeq =	this.acctgHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}