/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : LedgerCodeCombinationListVO.java
 *@FileTitle : LedgerCodeCombinationListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.06.19
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.06.19  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sco.statementcommon.statementcommon.vo;

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
public class LedgerCodeCombinationListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<LedgerCodeCombinationListVO>  models =	new	ArrayList<LedgerCodeCombinationListVO>();


	/*	Column Info	*/
	private  String	 coaStDt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 coaEndDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 coaSeq   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt14   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt13   =  null;
	/*	Column Info	*/
	private  String	 cdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt12   =  null;
	/*	Column Info	*/
	private  String	 legrAcctTpCd   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt11   =  null;
	/*	Column Info	*/
	private  String	 enblFlg   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt15   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt8   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt9   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt10   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt2   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt3   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt1   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt6   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt7   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt4   =  null;
	/*	Column Info	*/
	private  String	 sgmCtnt5   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public LedgerCodeCombinationListVO(){}

	public LedgerCodeCombinationListVO(String coaStDt,String creDt,String coaEndDt,String pagerows,String ibflag,String updUsrId,String updDt,String coaSeq,String sgmCtnt14,String sgmCtnt13,String cdCmbSeq,String sgmCtnt12,String legrAcctTpCd,String sgmCtnt11,String enblFlg,String sgmCtnt15,String sgmCtnt8,String creUsrId,String sgmCtnt9,String sgmCtnt10,String sgmCtnt2,String sgmCtnt3,String sgmCtnt1,String sgmCtnt6,String sgmCtnt7,String sgmCtnt4,String sgmCtnt5,String usrId)	{
		this.coaStDt  = coaStDt ;
		this.creDt  = creDt ;
		this.coaEndDt  = coaEndDt ;
		this.pagerows  = pagerows ;
		this.ibflag  = ibflag ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.coaSeq  = coaSeq ;
		this.sgmCtnt14  = sgmCtnt14 ;
		this.sgmCtnt13  = sgmCtnt13 ;
		this.cdCmbSeq  = cdCmbSeq ;
		this.sgmCtnt12  = sgmCtnt12 ;
		this.legrAcctTpCd  = legrAcctTpCd ;
		this.sgmCtnt11  = sgmCtnt11 ;
		this.enblFlg  = enblFlg ;
		this.sgmCtnt15  = sgmCtnt15 ;
		this.sgmCtnt8  = sgmCtnt8 ;
		this.creUsrId  = creUsrId ;
		this.sgmCtnt9  = sgmCtnt9 ;
		this.sgmCtnt10  = sgmCtnt10 ;
		this.sgmCtnt2  = sgmCtnt2 ;
		this.sgmCtnt3  = sgmCtnt3 ;
		this.sgmCtnt1  = sgmCtnt1 ;
		this.sgmCtnt6  = sgmCtnt6 ;
		this.sgmCtnt7  = sgmCtnt7 ;
		this.sgmCtnt4  = sgmCtnt4 ;
		this.sgmCtnt5  = sgmCtnt5 ;
		this.usrId  = usrId ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("coa_st_dt", getCoaStDt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("coa_end_dt", getCoaEndDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("coa_seq", getCoaSeq());		
		this.hashColumns.put("sgm_ctnt14", getSgmCtnt14());		
		this.hashColumns.put("sgm_ctnt13", getSgmCtnt13());		
		this.hashColumns.put("cd_cmb_seq", getCdCmbSeq());		
		this.hashColumns.put("sgm_ctnt12", getSgmCtnt12());		
		this.hashColumns.put("legr_acct_tp_cd", getLegrAcctTpCd());		
		this.hashColumns.put("sgm_ctnt11", getSgmCtnt11());		
		this.hashColumns.put("enbl_flg", getEnblFlg());		
		this.hashColumns.put("sgm_ctnt15", getSgmCtnt15());		
		this.hashColumns.put("sgm_ctnt8", getSgmCtnt8());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("sgm_ctnt9", getSgmCtnt9());		
		this.hashColumns.put("sgm_ctnt10", getSgmCtnt10());		
		this.hashColumns.put("sgm_ctnt2", getSgmCtnt2());		
		this.hashColumns.put("sgm_ctnt3", getSgmCtnt3());		
		this.hashColumns.put("sgm_ctnt1", getSgmCtnt1());		
		this.hashColumns.put("sgm_ctnt6", getSgmCtnt6());		
		this.hashColumns.put("sgm_ctnt7", getSgmCtnt7());		
		this.hashColumns.put("sgm_ctnt4", getSgmCtnt4());		
		this.hashColumns.put("sgm_ctnt5", getSgmCtnt5());		
		this.hashColumns.put("usr_id", getUsrId());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("coa_st_dt", "coaStDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("coa_end_dt", "coaEndDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("coa_seq", "coaSeq");
		this.hashFields.put("sgm_ctnt14", "sgmCtnt14");
		this.hashFields.put("sgm_ctnt13", "sgmCtnt13");
		this.hashFields.put("cd_cmb_seq", "cdCmbSeq");
		this.hashFields.put("sgm_ctnt12", "sgmCtnt12");
		this.hashFields.put("legr_acct_tp_cd", "legrAcctTpCd");
		this.hashFields.put("sgm_ctnt11", "sgmCtnt11");
		this.hashFields.put("enbl_flg", "enblFlg");
		this.hashFields.put("sgm_ctnt15", "sgmCtnt15");
		this.hashFields.put("sgm_ctnt8", "sgmCtnt8");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("sgm_ctnt9", "sgmCtnt9");
		this.hashFields.put("sgm_ctnt10", "sgmCtnt10");
		this.hashFields.put("sgm_ctnt2", "sgmCtnt2");
		this.hashFields.put("sgm_ctnt3", "sgmCtnt3");
		this.hashFields.put("sgm_ctnt1", "sgmCtnt1");
		this.hashFields.put("sgm_ctnt6", "sgmCtnt6");
		this.hashFields.put("sgm_ctnt7", "sgmCtnt7");
		this.hashFields.put("sgm_ctnt4", "sgmCtnt4");
		this.hashFields.put("sgm_ctnt5", "sgmCtnt5");
		this.hashFields.put("usr_id", "usrId");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  coaStDt
	*/
	public void	setCoaStDt( String	coaStDt ) {
		this.coaStDt =	coaStDt;
	}
 
	/**
	 * Column Info
	 * @return	coaStDt
	 */
	 public	 String	getCoaStDt() {
		 return	this.coaStDt;
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
	* @param  coaEndDt
	*/
	public void	setCoaEndDt( String	coaEndDt ) {
		this.coaEndDt =	coaEndDt;
	}
 
	/**
	 * Column Info
	 * @return	coaEndDt
	 */
	 public	 String	getCoaEndDt() {
		 return	this.coaEndDt;
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
	* @param  coaSeq
	*/
	public void	setCoaSeq( String	coaSeq ) {
		this.coaSeq =	coaSeq;
	}
 
	/**
	 * Column Info
	 * @return	coaSeq
	 */
	 public	 String	getCoaSeq() {
		 return	this.coaSeq;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt14
	*/
	public void	setSgmCtnt14( String	sgmCtnt14 ) {
		this.sgmCtnt14 =	sgmCtnt14;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt14
	 */
	 public	 String	getSgmCtnt14() {
		 return	this.sgmCtnt14;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt13
	*/
	public void	setSgmCtnt13( String	sgmCtnt13 ) {
		this.sgmCtnt13 =	sgmCtnt13;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt13
	 */
	 public	 String	getSgmCtnt13() {
		 return	this.sgmCtnt13;
	 } 
 	/**
	* Column Info
	* @param  cdCmbSeq
	*/
	public void	setCdCmbSeq( String	cdCmbSeq ) {
		this.cdCmbSeq =	cdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	cdCmbSeq
	 */
	 public	 String	getCdCmbSeq() {
		 return	this.cdCmbSeq;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt12
	*/
	public void	setSgmCtnt12( String	sgmCtnt12 ) {
		this.sgmCtnt12 =	sgmCtnt12;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt12
	 */
	 public	 String	getSgmCtnt12() {
		 return	this.sgmCtnt12;
	 } 
 	/**
	* Column Info
	* @param  legrAcctTpCd
	*/
	public void	setLegrAcctTpCd( String	legrAcctTpCd ) {
		this.legrAcctTpCd =	legrAcctTpCd;
	}
 
	/**
	 * Column Info
	 * @return	legrAcctTpCd
	 */
	 public	 String	getLegrAcctTpCd() {
		 return	this.legrAcctTpCd;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt11
	*/
	public void	setSgmCtnt11( String	sgmCtnt11 ) {
		this.sgmCtnt11 =	sgmCtnt11;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt11
	 */
	 public	 String	getSgmCtnt11() {
		 return	this.sgmCtnt11;
	 } 
 	/**
	* Column Info
	* @param  enblFlg
	*/
	public void	setEnblFlg( String	enblFlg ) {
		this.enblFlg =	enblFlg;
	}
 
	/**
	 * Column Info
	 * @return	enblFlg
	 */
	 public	 String	getEnblFlg() {
		 return	this.enblFlg;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt15
	*/
	public void	setSgmCtnt15( String	sgmCtnt15 ) {
		this.sgmCtnt15 =	sgmCtnt15;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt15
	 */
	 public	 String	getSgmCtnt15() {
		 return	this.sgmCtnt15;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt8
	*/
	public void	setSgmCtnt8( String	sgmCtnt8 ) {
		this.sgmCtnt8 =	sgmCtnt8;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt8
	 */
	 public	 String	getSgmCtnt8() {
		 return	this.sgmCtnt8;
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
	* @param  sgmCtnt9
	*/
	public void	setSgmCtnt9( String	sgmCtnt9 ) {
		this.sgmCtnt9 =	sgmCtnt9;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt9
	 */
	 public	 String	getSgmCtnt9() {
		 return	this.sgmCtnt9;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt10
	*/
	public void	setSgmCtnt10( String	sgmCtnt10 ) {
		this.sgmCtnt10 =	sgmCtnt10;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt10
	 */
	 public	 String	getSgmCtnt10() {
		 return	this.sgmCtnt10;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt2
	*/
	public void	setSgmCtnt2( String	sgmCtnt2 ) {
		this.sgmCtnt2 =	sgmCtnt2;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt2
	 */
	 public	 String	getSgmCtnt2() {
		 return	this.sgmCtnt2;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt3
	*/
	public void	setSgmCtnt3( String	sgmCtnt3 ) {
		this.sgmCtnt3 =	sgmCtnt3;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt3
	 */
	 public	 String	getSgmCtnt3() {
		 return	this.sgmCtnt3;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt1
	*/
	public void	setSgmCtnt1( String	sgmCtnt1 ) {
		this.sgmCtnt1 =	sgmCtnt1;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt1
	 */
	 public	 String	getSgmCtnt1() {
		 return	this.sgmCtnt1;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt6
	*/
	public void	setSgmCtnt6( String	sgmCtnt6 ) {
		this.sgmCtnt6 =	sgmCtnt6;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt6
	 */
	 public	 String	getSgmCtnt6() {
		 return	this.sgmCtnt6;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt7
	*/
	public void	setSgmCtnt7( String	sgmCtnt7 ) {
		this.sgmCtnt7 =	sgmCtnt7;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt7
	 */
	 public	 String	getSgmCtnt7() {
		 return	this.sgmCtnt7;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt4
	*/
	public void	setSgmCtnt4( String	sgmCtnt4 ) {
		this.sgmCtnt4 =	sgmCtnt4;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt4
	 */
	 public	 String	getSgmCtnt4() {
		 return	this.sgmCtnt4;
	 } 
 	/**
	* Column Info
	* @param  sgmCtnt5
	*/
	public void	setSgmCtnt5( String	sgmCtnt5 ) {
		this.sgmCtnt5 =	sgmCtnt5;
	}
 
	/**
	 * Column Info
	 * @return	sgmCtnt5
	 */
	 public	 String	getSgmCtnt5() {
		 return	this.sgmCtnt5;
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
		setCoaStDt(JSPUtil.getParameter(request,	prefix + "coa_st_dt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setCoaEndDt(JSPUtil.getParameter(request,	prefix + "coa_end_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCoaSeq(JSPUtil.getParameter(request,	prefix + "coa_seq", ""));
		setSgmCtnt14(JSPUtil.getParameter(request,	prefix + "sgm_ctnt14", ""));
		setSgmCtnt13(JSPUtil.getParameter(request,	prefix + "sgm_ctnt13", ""));
		setCdCmbSeq(JSPUtil.getParameter(request,	prefix + "cd_cmb_seq", ""));
		setSgmCtnt12(JSPUtil.getParameter(request,	prefix + "sgm_ctnt12", ""));
		setLegrAcctTpCd(JSPUtil.getParameter(request,	prefix + "legr_acct_tp_cd", ""));
		setSgmCtnt11(JSPUtil.getParameter(request,	prefix + "sgm_ctnt11", ""));
		setEnblFlg(JSPUtil.getParameter(request,	prefix + "enbl_flg", ""));
		setSgmCtnt15(JSPUtil.getParameter(request,	prefix + "sgm_ctnt15", ""));
		setSgmCtnt8(JSPUtil.getParameter(request,	prefix + "sgm_ctnt8", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setSgmCtnt9(JSPUtil.getParameter(request,	prefix + "sgm_ctnt9", ""));
		setSgmCtnt10(JSPUtil.getParameter(request,	prefix + "sgm_ctnt10", ""));
		setSgmCtnt2(JSPUtil.getParameter(request,	prefix + "sgm_ctnt2", ""));
		setSgmCtnt3(JSPUtil.getParameter(request,	prefix + "sgm_ctnt3", ""));
		setSgmCtnt1(JSPUtil.getParameter(request,	prefix + "sgm_ctnt1", ""));
		setSgmCtnt6(JSPUtil.getParameter(request,	prefix + "sgm_ctnt6", ""));
		setSgmCtnt7(JSPUtil.getParameter(request,	prefix + "sgm_ctnt7", ""));
		setSgmCtnt4(JSPUtil.getParameter(request,	prefix + "sgm_ctnt4", ""));
		setSgmCtnt5(JSPUtil.getParameter(request,	prefix + "sgm_ctnt5", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return LedgerCodeCombinationListVO[]
	 */
	public LedgerCodeCombinationListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return LedgerCodeCombinationListVO[]
	 */
	public LedgerCodeCombinationListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		LedgerCodeCombinationListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] coaStDt =	(JSPUtil.getParameter(request, prefix +	"coa_st_dt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] coaEndDt =	(JSPUtil.getParameter(request, prefix +	"coa_end_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] coaSeq =	(JSPUtil.getParameter(request, prefix +	"coa_seq".trim(),	length));
				String[] sgmCtnt14 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt14".trim(),	length));
				String[] sgmCtnt13 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt13".trim(),	length));
				String[] cdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"cd_cmb_seq".trim(),	length));
				String[] sgmCtnt12 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt12".trim(),	length));
				String[] legrAcctTpCd =	(JSPUtil.getParameter(request, prefix +	"legr_acct_tp_cd".trim(),	length));
				String[] sgmCtnt11 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt11".trim(),	length));
				String[] enblFlg =	(JSPUtil.getParameter(request, prefix +	"enbl_flg".trim(),	length));
				String[] sgmCtnt15 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt15".trim(),	length));
				String[] sgmCtnt8 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt8".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] sgmCtnt9 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt9".trim(),	length));
				String[] sgmCtnt10 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt10".trim(),	length));
				String[] sgmCtnt2 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt2".trim(),	length));
				String[] sgmCtnt3 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt3".trim(),	length));
				String[] sgmCtnt1 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt1".trim(),	length));
				String[] sgmCtnt6 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt6".trim(),	length));
				String[] sgmCtnt7 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt7".trim(),	length));
				String[] sgmCtnt4 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt4".trim(),	length));
				String[] sgmCtnt5 =	(JSPUtil.getParameter(request, prefix +	"sgm_ctnt5".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	LedgerCodeCombinationListVO();
						if ( coaStDt[i] !=	null)
						model.setCoaStDt( coaStDt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( coaEndDt[i] !=	null)
						model.setCoaEndDt( coaEndDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( coaSeq[i] !=	null)
						model.setCoaSeq( coaSeq[i]);
						if ( sgmCtnt14[i] !=	null)
						model.setSgmCtnt14( sgmCtnt14[i]);
						if ( sgmCtnt13[i] !=	null)
						model.setSgmCtnt13( sgmCtnt13[i]);
						if ( cdCmbSeq[i] !=	null)
						model.setCdCmbSeq( cdCmbSeq[i]);
						if ( sgmCtnt12[i] !=	null)
						model.setSgmCtnt12( sgmCtnt12[i]);
						if ( legrAcctTpCd[i] !=	null)
						model.setLegrAcctTpCd( legrAcctTpCd[i]);
						if ( sgmCtnt11[i] !=	null)
						model.setSgmCtnt11( sgmCtnt11[i]);
						if ( enblFlg[i] !=	null)
						model.setEnblFlg( enblFlg[i]);
						if ( sgmCtnt15[i] !=	null)
						model.setSgmCtnt15( sgmCtnt15[i]);
						if ( sgmCtnt8[i] !=	null)
						model.setSgmCtnt8( sgmCtnt8[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( sgmCtnt9[i] !=	null)
						model.setSgmCtnt9( sgmCtnt9[i]);
						if ( sgmCtnt10[i] !=	null)
						model.setSgmCtnt10( sgmCtnt10[i]);
						if ( sgmCtnt2[i] !=	null)
						model.setSgmCtnt2( sgmCtnt2[i]);
						if ( sgmCtnt3[i] !=	null)
						model.setSgmCtnt3( sgmCtnt3[i]);
						if ( sgmCtnt1[i] !=	null)
						model.setSgmCtnt1( sgmCtnt1[i]);
						if ( sgmCtnt6[i] !=	null)
						model.setSgmCtnt6( sgmCtnt6[i]);
						if ( sgmCtnt7[i] !=	null)
						model.setSgmCtnt7( sgmCtnt7[i]);
						if ( sgmCtnt4[i] !=	null)
						model.setSgmCtnt4( sgmCtnt4[i]);
						if ( sgmCtnt5[i] !=	null)
						model.setSgmCtnt5( sgmCtnt5[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getLedgerCodeCombinationListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return LedgerCodeCombinationListVO[]
	 */
	public LedgerCodeCombinationListVO[]	 getLedgerCodeCombinationListVOs(){
		LedgerCodeCombinationListVO[] vos = (LedgerCodeCombinationListVO[])models.toArray(new	LedgerCodeCombinationListVO[models.size()]);
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
		this.coaStDt =	this.coaStDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaEndDt =	this.coaEndDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coaSeq =	this.coaSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt14 =	this.sgmCtnt14.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt13 =	this.sgmCtnt13.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdCmbSeq =	this.cdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt12 =	this.sgmCtnt12.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.legrAcctTpCd =	this.legrAcctTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt11 =	this.sgmCtnt11.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.enblFlg =	this.enblFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt15 =	this.sgmCtnt15.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt8 =	this.sgmCtnt8.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt9 =	this.sgmCtnt9.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt10 =	this.sgmCtnt10.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt2 =	this.sgmCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt3 =	this.sgmCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt1 =	this.sgmCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt6 =	this.sgmCtnt6.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt7 =	this.sgmCtnt7.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt4 =	this.sgmCtnt4.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sgmCtnt5 =	this.sgmCtnt5.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}