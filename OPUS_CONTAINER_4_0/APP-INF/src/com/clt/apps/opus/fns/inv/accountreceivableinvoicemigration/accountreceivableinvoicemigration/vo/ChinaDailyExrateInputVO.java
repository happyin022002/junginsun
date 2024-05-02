/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ChinaDailyExrateInputVO.java
 *@FileTitle : ChinaDailyExrateInputVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.25
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.05.25  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo;

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
public class ChinaDailyExrateInputVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ChinaDailyExrateInputVO>  models =	new	ArrayList<ChinaDailyExrateInputVO>();


	/*	Column Info	*/
	private  String	 ofcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 lclCurr   =  null;
	/*	Column Info	*/
	private  String	 saDt   =  null;
	/*	Column Info	*/
	private  String	 curr   =  null;
	/*	Column Info	*/
	private  String	 bnd   =  null;
	/*	Column Info	*/
	private  String	 exrateType   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 rvsFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ChinaDailyExrateInputVO(){}

	public ChinaDailyExrateInputVO(String ofcCd,String ibflag,String lclCurr,String saDt,String curr,String bnd,String exrateType,String pagerows,String rvsFlg)	{
		this.ofcCd  = ofcCd ;
		this.ibflag  = ibflag ;
		this.lclCurr  = lclCurr ;
		this.saDt  = saDt ;
		this.curr  = curr ;
		this.bnd  = bnd ;
		this.exrateType  = exrateType ;
		this.pagerows  = pagerows ;
		this.rvsFlg  = rvsFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ofc_cd", getOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("lcl_curr", getLclCurr());		
		this.hashColumns.put("sa_dt", getSaDt());		
		this.hashColumns.put("curr", getCurr());		
		this.hashColumns.put("bnd", getBnd());		
		this.hashColumns.put("exrate_type", getExrateType());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("rvs_flg", getRvsFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("lcl_curr", "lclCurr");
		this.hashFields.put("sa_dt", "saDt");
		this.hashFields.put("curr", "curr");
		this.hashFields.put("bnd", "bnd");
		this.hashFields.put("exrate_type", "exrateType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rvs_flg", "rvsFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  lclCurr
	*/
	public void	setLclCurr( String	lclCurr ) {
		this.lclCurr =	lclCurr;
	}
 
	/**
	 * Column Info
	 * @return	lclCurr
	 */
	 public	 String	getLclCurr() {
		 return	this.lclCurr;
	 } 
 	/**
	* Column Info
	* @param  saDt
	*/
	public void	setSaDt( String	saDt ) {
		this.saDt =	saDt;
	}
 
	/**
	 * Column Info
	 * @return	saDt
	 */
	 public	 String	getSaDt() {
		 return	this.saDt;
	 } 
 	/**
	* Column Info
	* @param  curr
	*/
	public void	setCurr( String	curr ) {
		this.curr =	curr;
	}
 
	/**
	 * Column Info
	 * @return	curr
	 */
	 public	 String	getCurr() {
		 return	this.curr;
	 } 
 	/**
	* Column Info
	* @param  bnd
	*/
	public void	setBnd( String	bnd ) {
		this.bnd =	bnd;
	}
 
	/**
	 * Column Info
	 * @return	bnd
	 */
	 public	 String	getBnd() {
		 return	this.bnd;
	 } 
 	/**
	* Column Info
	* @param  exrateType
	*/
	public void	setExrateType( String	exrateType ) {
		this.exrateType =	exrateType;
	}
 
	/**
	 * Column Info
	 * @return	exrateType
	 */
	 public	 String	getExrateType() {
		 return	this.exrateType;
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
	* @param  rvsFlg
	*/
	public void	setRvsFlg( String	rvsFlg ) {
		this.rvsFlg =	rvsFlg;
	}
 
	/**
	 * Column Info
	 * @return	rvsFlg
	 */
	 public	 String	getRvsFlg() {
		 return	this.rvsFlg;
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
		setOfcCd(JSPUtil.getParameter(request,	prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setLclCurr(JSPUtil.getParameter(request,	prefix + "lcl_curr", ""));
		setSaDt(JSPUtil.getParameter(request,	prefix + "sa_dt", ""));
		setCurr(JSPUtil.getParameter(request,	prefix + "curr", ""));
		setBnd(JSPUtil.getParameter(request,	prefix + "bnd", ""));
		setExrateType(JSPUtil.getParameter(request,	prefix + "exrate_type", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRvsFlg(JSPUtil.getParameter(request,	prefix + "rvs_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ChinaDailyExrateInputVO[]
	 */
	public ChinaDailyExrateInputVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ChinaDailyExrateInputVO[]
	 */
	public ChinaDailyExrateInputVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ChinaDailyExrateInputVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] ofcCd =	(JSPUtil.getParameter(request, prefix +	"ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] lclCurr =	(JSPUtil.getParameter(request, prefix +	"lcl_curr".trim(),	length));
				String[] saDt =	(JSPUtil.getParameter(request, prefix +	"sa_dt".trim(),	length));
				String[] curr =	(JSPUtil.getParameter(request, prefix +	"curr".trim(),	length));
				String[] bnd =	(JSPUtil.getParameter(request, prefix +	"bnd".trim(),	length));
				String[] exrateType =	(JSPUtil.getParameter(request, prefix +	"exrate_type".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] rvsFlg =	(JSPUtil.getParameter(request, prefix +	"rvs_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ChinaDailyExrateInputVO();
						if ( ofcCd[i] !=	null)
						model.setOfcCd( ofcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( lclCurr[i] !=	null)
						model.setLclCurr( lclCurr[i]);
						if ( saDt[i] !=	null)
						model.setSaDt( saDt[i]);
						if ( curr[i] !=	null)
						model.setCurr( curr[i]);
						if ( bnd[i] !=	null)
						model.setBnd( bnd[i]);
						if ( exrateType[i] !=	null)
						model.setExrateType( exrateType[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( rvsFlg[i] !=	null)
						model.setRvsFlg( rvsFlg[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getChinaDailyExrateInputVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ChinaDailyExrateInputVO[]
	 */
	public ChinaDailyExrateInputVO[]	 getChinaDailyExrateInputVOs(){
		ChinaDailyExrateInputVO[] vos = (ChinaDailyExrateInputVO[])models.toArray(new	ChinaDailyExrateInputVO[models.size()]);
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
		this.ofcCd =	this.ofcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lclCurr =	this.lclCurr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.saDt =	this.saDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.curr =	this.curr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bnd =	this.bnd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exrateType =	this.exrateType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsFlg =	this.rvsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}