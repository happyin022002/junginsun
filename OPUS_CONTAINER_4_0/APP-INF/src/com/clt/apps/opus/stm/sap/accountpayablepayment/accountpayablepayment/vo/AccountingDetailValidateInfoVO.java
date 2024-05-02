/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountingDetailValidateInfoVO.java
 *@FileTitle : AccountingDetailValidateInfoVO
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
public class AccountingDetailValidateInfoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AccountingDetailValidateInfoVO>  models =	new	ArrayList<AccountingDetailValidateInfoVO>();


	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 acctgErrCd   =  null;
	/*	Column Info	*/
	private  String	 acctgDt   =  null;
	/*	Column Info	*/
	private  String	 acctgSrcSeq   =  null;
	/*	Column Info	*/
	private  String	 acctgEvntSeq   =  null;
	/*	Column Info	*/
	private  String	 acctgHdrSeq   =  null;
	/*	Column Info	*/
	private  String	 acctgEvntTpCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public AccountingDetailValidateInfoVO(){}

	public AccountingDetailValidateInfoVO(String ibflag,String acctgErrCd,String acctgDt,String acctgSrcSeq,String acctgEvntSeq,String acctgHdrSeq,String acctgEvntTpCd,String pagerows,String usrId)	{
		this.ibflag  = ibflag ;
		this.acctgErrCd  = acctgErrCd ;
		this.acctgDt  = acctgDt ;
		this.acctgSrcSeq  = acctgSrcSeq ;
		this.acctgEvntSeq  = acctgEvntSeq ;
		this.acctgHdrSeq  = acctgHdrSeq ;
		this.acctgEvntTpCd  = acctgEvntTpCd ;
		this.pagerows  = pagerows ;
		this.usrId  = usrId ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("acctg_err_cd", getAcctgErrCd());		
		this.hashColumns.put("acctg_dt", getAcctgDt());		
		this.hashColumns.put("acctg_src_seq", getAcctgSrcSeq());		
		this.hashColumns.put("acctg_evnt_seq", getAcctgEvntSeq());		
		this.hashColumns.put("acctg_hdr_seq", getAcctgHdrSeq());		
		this.hashColumns.put("acctg_evnt_tp_cd", getAcctgEvntTpCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("usr_id", getUsrId());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("acctg_err_cd", "acctgErrCd");
		this.hashFields.put("acctg_dt", "acctgDt");
		this.hashFields.put("acctg_src_seq", "acctgSrcSeq");
		this.hashFields.put("acctg_evnt_seq", "acctgEvntSeq");
		this.hashFields.put("acctg_hdr_seq", "acctgHdrSeq");
		this.hashFields.put("acctg_evnt_tp_cd", "acctgEvntTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("usr_id", "usrId");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  acctgSrcSeq
	*/
	public void	setAcctgSrcSeq( String	acctgSrcSeq ) {
		this.acctgSrcSeq =	acctgSrcSeq;
	}
 
	/**
	 * Column Info
	 * @return	acctgSrcSeq
	 */
	 public	String	getAcctgSrcSeq() {
		 return	this.acctgSrcSeq;
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
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAcctgErrCd(JSPUtil.getParameter(request,	prefix + "acctg_err_cd", ""));
		setAcctgDt(JSPUtil.getParameter(request,	prefix + "acctg_dt", ""));
		setAcctgSrcSeq(JSPUtil.getParameter(request,	prefix + "acctg_src_seq", ""));
		setAcctgEvntSeq(JSPUtil.getParameter(request,	prefix + "acctg_evnt_seq", ""));
		setAcctgHdrSeq(JSPUtil.getParameter(request,	prefix + "acctg_hdr_seq", ""));
		setAcctgEvntTpCd(JSPUtil.getParameter(request,	prefix + "acctg_evnt_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AccountingDetailValidateInfoVO[]
	 */
	public AccountingDetailValidateInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AccountingDetailValidateInfoVO[]
	 */
	public AccountingDetailValidateInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AccountingDetailValidateInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] acctgErrCd =	(JSPUtil.getParameter(request, prefix +	"acctg_err_cd".trim(),	length));
				String[] acctgDt =	(JSPUtil.getParameter(request, prefix +	"acctg_dt".trim(),	length));
				String[] acctgSrcSeq =	(JSPUtil.getParameter(request, prefix +	"acctg_src_seq".trim(),	length));
				String[] acctgEvntSeq =	(JSPUtil.getParameter(request, prefix +	"acctg_evnt_seq".trim(),	length));
				String[] acctgHdrSeq =	(JSPUtil.getParameter(request, prefix +	"acctg_hdr_seq".trim(),	length));
				String[] acctgEvntTpCd =	(JSPUtil.getParameter(request, prefix +	"acctg_evnt_tp_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AccountingDetailValidateInfoVO();
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( acctgErrCd[i] !=	null)
						model.setAcctgErrCd( acctgErrCd[i]);
						if ( acctgDt[i] !=	null)
						model.setAcctgDt( acctgDt[i]);
						if ( acctgSrcSeq[i] !=	null)
						model.setAcctgSrcSeq( acctgSrcSeq[i]);
						if ( acctgEvntSeq[i] !=	null)
						model.setAcctgEvntSeq( acctgEvntSeq[i]);
						if ( acctgHdrSeq[i] !=	null)
						model.setAcctgHdrSeq( acctgHdrSeq[i]);
						if ( acctgEvntTpCd[i] !=	null)
						model.setAcctgEvntTpCd( acctgEvntTpCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAccountingDetailValidateInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AccountingDetailValidateInfoVO[]
	 */
	public AccountingDetailValidateInfoVO[]	 getAccountingDetailValidateInfoVOs(){
		AccountingDetailValidateInfoVO[] vos = (AccountingDetailValidateInfoVO[])models.toArray(new	AccountingDetailValidateInfoVO[models.size()]);
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
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgErrCd =	this.acctgErrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgDt =	this.acctgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgSrcSeq =	this.acctgSrcSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgEvntSeq =	this.acctgEvntSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgHdrSeq =	this.acctgHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctgEvntTpCd =	this.acctgEvntTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}