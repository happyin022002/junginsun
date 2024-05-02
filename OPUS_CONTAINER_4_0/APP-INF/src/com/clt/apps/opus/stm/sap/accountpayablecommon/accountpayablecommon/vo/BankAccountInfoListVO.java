/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BankAccountInfoListVO.java
 *@FileTitle : BankAccountInfoListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.08.22
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.08.22  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo;

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
public class BankAccountInfoListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BankAccountInfoListVO>  models =	new	ArrayList<BankAccountInfoListVO>();


	/*	Column Info	*/
	private  String	 bankAcctSeq   =  null;
	/*	Column Info	*/
	private  String	 bankAcctNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 currCd   =  null;
	/*	Column Info	*/
	private  String	 bankNm   =  null;
	/*	Column Info	*/
	private  String	 mltCurrFlg   =  null;
	/*	Column Info	*/
	private  String	 bankAcctNm   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 acctTpCd   =  null;
	/*	Column Info	*/
	private  String	 acctTpCdNm   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public BankAccountInfoListVO(){}

	public BankAccountInfoListVO(String bankAcctSeq,String bankAcctNo,String ibflag,String currCd,String bankNm,String mltCurrFlg,String bankAcctNm,String pagerows,String acctTpCd,String acctTpCdNm)	{
		this.bankAcctSeq  = bankAcctSeq ;
		this.bankAcctNo  = bankAcctNo ;
		this.ibflag  = ibflag ;
		this.currCd  = currCd ;
		this.bankNm  = bankNm ;
		this.mltCurrFlg  = mltCurrFlg ;
		this.bankAcctNm  = bankAcctNm ;
		this.pagerows  = pagerows ;
		this.acctTpCd  = acctTpCd ;
		this.acctTpCdNm  = acctTpCdNm ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bank_acct_seq", getBankAcctSeq());		
		this.hashColumns.put("bank_acct_no", getBankAcctNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("curr_cd", getCurrCd());		
		this.hashColumns.put("bank_nm", getBankNm());		
		this.hashColumns.put("mlt_curr_flg", getMltCurrFlg());		
		this.hashColumns.put("bank_acct_nm", getBankAcctNm());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("acct_tp_cd", getAcctTpCd());		
		this.hashColumns.put("acct_tp_cd_nm", getAcctTpCdNm());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("bank_acct_seq", "bankAcctSeq");
		this.hashFields.put("bank_acct_no", "bankAcctNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("bank_nm", "bankNm");
		this.hashFields.put("mlt_curr_flg", "mltCurrFlg");
		this.hashFields.put("bank_acct_nm", "bankAcctNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("acct_tp_cd", "acctTpCd");
		this.hashFields.put("acct_tp_cd_nm", "acctTpCdNm");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  bankAcctNo
	*/
	public void	setBankAcctNo( String	bankAcctNo ) {
		this.bankAcctNo =	bankAcctNo;
	}
 
	/**
	 * Column Info
	 * @return	bankAcctNo
	 */
	 public	 String	getBankAcctNo() {
		 return	this.bankAcctNo;
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
	* @param  bankNm
	*/
	public void	setBankNm( String	bankNm ) {
		this.bankNm =	bankNm;
	}
 
	/**
	 * Column Info
	 * @return	bankNm
	 */
	 public	 String	getBankNm() {
		 return	this.bankNm;
	 } 
 	/**
	* Column Info
	* @param  mltCurrFlg
	*/
	public void	setMltCurrFlg( String	mltCurrFlg ) {
		this.mltCurrFlg =	mltCurrFlg;
	}
 
	/**
	 * Column Info
	 * @return	mltCurrFlg
	 */
	 public	 String	getMltCurrFlg() {
		 return	this.mltCurrFlg;
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
	* @param  acctTpCd
	*/
	public void	setAcctTpCd( String	acctTpCd ) {
		this.acctTpCd =	acctTpCd;
	}
 
	/**
	 * Column Info
	 * @return	acctTpCd
	 */
	 public	 String	getAcctTpCd() {
		 return	this.acctTpCd;
	 } 
 	/**
	* Column Info
	* @param  acctTpCdNm
	*/
	public void	setAcctTpCdNm( String	acctTpCdNm ) {
		this.acctTpCdNm =	acctTpCdNm;
	}
 
	/**
	 * Column Info
	 * @return	acctTpCdNm
	 */
	 public	 String	getAcctTpCdNm() {
		 return	this.acctTpCdNm;
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
		setBankAcctSeq(JSPUtil.getParameter(request,	prefix + "bank_acct_seq", ""));
		setBankAcctNo(JSPUtil.getParameter(request,	prefix + "bank_acct_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setBankNm(JSPUtil.getParameter(request,	prefix + "bank_nm", ""));
		setMltCurrFlg(JSPUtil.getParameter(request,	prefix + "mlt_curr_flg", ""));
		setBankAcctNm(JSPUtil.getParameter(request,	prefix + "bank_acct_nm", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAcctTpCd(JSPUtil.getParameter(request,	prefix + "acct_tp_cd", ""));
		setAcctTpCdNm(JSPUtil.getParameter(request,	prefix + "acct_tp_cd_nm", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BankAccountInfoListVO[]
	 */
	public BankAccountInfoListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BankAccountInfoListVO[]
	 */
	public BankAccountInfoListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BankAccountInfoListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] bankAcctSeq =	(JSPUtil.getParameter(request, prefix +	"bank_acct_seq".trim(),	length));
				String[] bankAcctNo =	(JSPUtil.getParameter(request, prefix +	"bank_acct_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd".trim(),	length));
				String[] bankNm =	(JSPUtil.getParameter(request, prefix +	"bank_nm".trim(),	length));
				String[] mltCurrFlg =	(JSPUtil.getParameter(request, prefix +	"mlt_curr_flg".trim(),	length));
				String[] bankAcctNm =	(JSPUtil.getParameter(request, prefix +	"bank_acct_nm".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] acctTpCd =	(JSPUtil.getParameter(request, prefix +	"acct_tp_cd".trim(),	length));
				String[] acctTpCdNm =	(JSPUtil.getParameter(request, prefix +	"acct_tp_cd_nm".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BankAccountInfoListVO();
						if ( bankAcctSeq[i] !=	null)
						model.setBankAcctSeq( bankAcctSeq[i]);
						if ( bankAcctNo[i] !=	null)
						model.setBankAcctNo( bankAcctNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( currCd[i] !=	null)
						model.setCurrCd( currCd[i]);
						if ( bankNm[i] !=	null)
						model.setBankNm( bankNm[i]);
						if ( mltCurrFlg[i] !=	null)
						model.setMltCurrFlg( mltCurrFlg[i]);
						if ( bankAcctNm[i] !=	null)
						model.setBankAcctNm( bankAcctNm[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( acctTpCd[i] !=	null)
						model.setAcctTpCd( acctTpCd[i]);
						if ( acctTpCdNm[i] !=	null)
						model.setAcctTpCdNm( acctTpCdNm[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBankAccountInfoListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BankAccountInfoListVO[]
	 */
	public BankAccountInfoListVO[]	 getBankAccountInfoListVOs(){
		BankAccountInfoListVO[] vos = (BankAccountInfoListVO[])models.toArray(new	BankAccountInfoListVO[models.size()]);
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
		this.bankAcctSeq =	this.bankAcctSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNo =	this.bankAcctNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankNm =	this.bankNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mltCurrFlg =	this.mltCurrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bankAcctNm =	this.bankAcctNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTpCd =	this.acctTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctTpCdNm =	this.acctTpCdNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}