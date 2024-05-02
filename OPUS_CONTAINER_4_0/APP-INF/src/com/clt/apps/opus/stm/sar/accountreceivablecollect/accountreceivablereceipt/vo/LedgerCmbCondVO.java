/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : LedgerCmbCondVO.java
 *@FileTitle : LedgerCmbCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.09.30
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.09.30  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo;

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
public class LedgerCmbCondVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<LedgerCmbCondVO>  models =	new	ArrayList<LedgerCmbCondVO>();


	/*	Column Info	*/
	private  String	 glDt   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 arAcctCd   =  null;
	/*	Column Info	*/
	private  String	 asetCdCmbSeq   =  null;
	/*	Column Info	*/
	private  String	 acctCtnt2   =  null;
	/*	Column Info	*/
	private  String	 acctCtnt3   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 acctCtnt1   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public LedgerCmbCondVO(){}

	public LedgerCmbCondVO(String glDt,String ibflag,String arAcctCd,String asetCdCmbSeq,String acctCtnt2,String acctCtnt3,String pagerows,String acctCtnt1)	{
		this.glDt  = glDt ;
		this.ibflag  = ibflag ;
		this.arAcctCd  = arAcctCd ;
		this.asetCdCmbSeq  = asetCdCmbSeq ;
		this.acctCtnt2  = acctCtnt2 ;
		this.acctCtnt3  = acctCtnt3 ;
		this.pagerows  = pagerows ;
		this.acctCtnt1  = acctCtnt1 ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("gl_dt", getGlDt());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("ar_acct_cd", getArAcctCd());		
		this.hashColumns.put("aset_cd_cmb_seq", getAsetCdCmbSeq());		
		this.hashColumns.put("acct_ctnt2", getAcctCtnt2());		
		this.hashColumns.put("acct_ctnt3", getAcctCtnt3());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("acct_ctnt1", getAcctCtnt1());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("gl_dt", "glDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ar_acct_cd", "arAcctCd");
		this.hashFields.put("aset_cd_cmb_seq", "asetCdCmbSeq");
		this.hashFields.put("acct_ctnt2", "acctCtnt2");
		this.hashFields.put("acct_ctnt3", "acctCtnt3");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("acct_ctnt1", "acctCtnt1");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  glDt
	*/
	public void	setGlDt( String	glDt ) {
		this.glDt =	glDt;
	}
 
	/**
	 * Column Info
	 * @return	glDt
	 */
	 public	 String	getGlDt() {
		 return	this.glDt;
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
	* @param  arAcctCd
	*/
	public void	setArAcctCd( String	arAcctCd ) {
		this.arAcctCd =	arAcctCd;
	}
 
	/**
	 * Column Info
	 * @return	arAcctCd
	 */
	 public	 String	getArAcctCd() {
		 return	this.arAcctCd;
	 } 
 	/**
	* Column Info
	* @param  asetCdCmbSeq
	*/
	public void	setAsetCdCmbSeq( String	asetCdCmbSeq ) {
		this.asetCdCmbSeq =	asetCdCmbSeq;
	}
 
	/**
	 * Column Info
	 * @return	asetCdCmbSeq
	 */
	 public	 String	getAsetCdCmbSeq() {
		 return	this.asetCdCmbSeq;
	 } 
 	/**
	* Column Info
	* @param  acctCtnt2
	*/
	public void	setAcctCtnt2( String	acctCtnt2 ) {
		this.acctCtnt2 =	acctCtnt2;
	}
 
	/**
	 * Column Info
	 * @return	acctCtnt2
	 */
	 public	 String	getAcctCtnt2() {
		 return	this.acctCtnt2;
	 } 
 	/**
	* Column Info
	* @param  acctCtnt3
	*/
	public void	setAcctCtnt3( String	acctCtnt3 ) {
		this.acctCtnt3 =	acctCtnt3;
	}
 
	/**
	 * Column Info
	 * @return	acctCtnt3
	 */
	 public	 String	getAcctCtnt3() {
		 return	this.acctCtnt3;
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
	* @param  acctCtnt1
	*/
	public void	setAcctCtnt1( String	acctCtnt1 ) {
		this.acctCtnt1 =	acctCtnt1;
	}
 
	/**
	 * Column Info
	 * @return	acctCtnt1
	 */
	 public	 String	getAcctCtnt1() {
		 return	this.acctCtnt1;
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
		setGlDt(JSPUtil.getParameter(request,	prefix + "gl_dt", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setArAcctCd(JSPUtil.getParameter(request,	prefix + "ar_acct_cd", ""));
		setAsetCdCmbSeq(JSPUtil.getParameter(request,	prefix + "aset_cd_cmb_seq", ""));
		setAcctCtnt2(JSPUtil.getParameter(request,	prefix + "acct_ctnt2", ""));
		setAcctCtnt3(JSPUtil.getParameter(request,	prefix + "acct_ctnt3", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAcctCtnt1(JSPUtil.getParameter(request,	prefix + "acct_ctnt1", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return LedgerCmbCondVO[]
	 */
	public LedgerCmbCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return LedgerCmbCondVO[]
	 */
	public LedgerCmbCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		LedgerCmbCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] glDt =	(JSPUtil.getParameter(request, prefix +	"gl_dt".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] arAcctCd =	(JSPUtil.getParameter(request, prefix +	"ar_acct_cd".trim(),	length));
				String[] asetCdCmbSeq =	(JSPUtil.getParameter(request, prefix +	"aset_cd_cmb_seq".trim(),	length));
				String[] acctCtnt2 =	(JSPUtil.getParameter(request, prefix +	"acct_ctnt2".trim(),	length));
				String[] acctCtnt3 =	(JSPUtil.getParameter(request, prefix +	"acct_ctnt3".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] acctCtnt1 =	(JSPUtil.getParameter(request, prefix +	"acct_ctnt1".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	LedgerCmbCondVO();
						if ( glDt[i] !=	null)
						model.setGlDt( glDt[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( arAcctCd[i] !=	null)
						model.setArAcctCd( arAcctCd[i]);
						if ( asetCdCmbSeq[i] !=	null)
						model.setAsetCdCmbSeq( asetCdCmbSeq[i]);
						if ( acctCtnt2[i] !=	null)
						model.setAcctCtnt2( acctCtnt2[i]);
						if ( acctCtnt3[i] !=	null)
						model.setAcctCtnt3( acctCtnt3[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( acctCtnt1[i] !=	null)
						model.setAcctCtnt1( acctCtnt1[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getLedgerCmbCondVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return LedgerCmbCondVO[]
	 */
	public LedgerCmbCondVO[]	 getLedgerCmbCondVOs(){
		LedgerCmbCondVO[] vos = (LedgerCmbCondVO[])models.toArray(new	LedgerCmbCondVO[models.size()]);
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
		this.glDt =	this.glDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arAcctCd =	this.arAcctCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.asetCdCmbSeq =	this.asetCdCmbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt2 =	this.acctCtnt2.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt3 =	this.acctCtnt3.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acctCtnt1 =	this.acctCtnt1.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}