/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AlpsTroDtlVO.java
 *@FileTitle : AlpsTroDtlVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.07.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.07.27  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * - PDTO(Data Transfer	Object including Parameters)<br>
 * - 관련	Event에서	작성,	서버실행요청시	PDTO의 역할을 수행하는 Value Object<br>
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class AlpsTroDtlVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AlpsTroDtlVO>  models =	new	ArrayList<AlpsTroDtlVO>();


	/*	Column Info	*/
	private  String	 troQty   =  null;
	/*	Column Info	*/
	private  String	 pkupYdCd   =  null;
	/*	Column Info	*/
	private  String	 rtnLocCd   =  null;
	/*	Column Info	*/
	private  String	 troSubSeq   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 dorArrDt   =  null;
	/*	Column Info	*/
	private  String	 troSeq   =  null;
	/*	Column Info	*/
	private  String	 cxlFlg   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 rtnYdCd   =  null;
	/*	Column Info	*/
	private  String	 pkupLocCd   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 rtnDt   =  null;
	/*	Column Info	*/
	private  String	 bkgTrspMzdCd   =  null;
	/*	Column Info	*/
	private  String	 dorAddrTpCd   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public AlpsTroDtlVO(){}

	public AlpsTroDtlVO(String troQty,String pkupYdCd,String rtnLocCd,String troSubSeq,String ibflag,String dorArrDt,String troSeq,String cxlFlg,String cntrTpszCd,String rtnYdCd,String pkupLocCd,String pagerows,String rtnDt,String bkgTrspMzdCd,String dorAddrTpCd)	{
		this.troQty  = troQty ;
		this.pkupYdCd  = pkupYdCd ;
		this.rtnLocCd  = rtnLocCd ;
		this.troSubSeq  = troSubSeq ;
		this.ibflag  = ibflag ;
		this.dorArrDt  = dorArrDt ;
		this.troSeq  = troSeq ;
		this.cxlFlg  = cxlFlg ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.rtnYdCd  = rtnYdCd ;
		this.pkupLocCd  = pkupLocCd ;
		this.pagerows  = pagerows ;
		this.rtnDt  = rtnDt ;
		this.bkgTrspMzdCd  = bkgTrspMzdCd ;
		this.dorAddrTpCd  = dorAddrTpCd ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tro_qty", getTroQty());		
		this.hashColumns.put("pkup_yd_cd", getPkupYdCd());		
		this.hashColumns.put("rtn_loc_cd", getRtnLocCd());		
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("dor_arr_dt", getDorArrDt());		
		this.hashColumns.put("tro_seq", getTroSeq());		
		this.hashColumns.put("cxl_flg", getCxlFlg());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("rtn_yd_cd", getRtnYdCd());		
		this.hashColumns.put("pkup_loc_cd", getPkupLocCd());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("rtn_dt", getRtnDt());		
		this.hashColumns.put("bkg_trsp_mzd_cd", getBkgTrspMzdCd());		
		this.hashColumns.put("dor_addr_tp_cd", getDorAddrTpCd());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("tro_qty", "troQty");
		this.hashFields.put("pkup_yd_cd", "pkupYdCd");
		this.hashFields.put("rtn_loc_cd", "rtnLocCd");
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("dor_arr_dt", "dorArrDt");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("rtn_yd_cd", "rtnYdCd");
		this.hashFields.put("pkup_loc_cd", "pkupLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rtn_dt", "rtnDt");
		this.hashFields.put("bkg_trsp_mzd_cd", "bkgTrspMzdCd");
		this.hashFields.put("dor_addr_tp_cd", "dorAddrTpCd");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  troQty
	*/
	public void	setTroQty( String	troQty ) {
		this.troQty =	troQty;
	}
 
	/**
	 * Column Info
	 * @return	troQty
	 */
	 public	String	getTroQty() {
		 return	this.troQty;
	 } 
 	/**
	* Column Info
	* @param  pkupYdCd
	*/
	public void	setPkupYdCd( String	pkupYdCd ) {
		this.pkupYdCd =	pkupYdCd;
	}
 
	/**
	 * Column Info
	 * @return	pkupYdCd
	 */
	 public	String	getPkupYdCd() {
		 return	this.pkupYdCd;
	 } 
 	/**
	* Column Info
	* @param  rtnLocCd
	*/
	public void	setRtnLocCd( String	rtnLocCd ) {
		this.rtnLocCd =	rtnLocCd;
	}
 
	/**
	 * Column Info
	 * @return	rtnLocCd
	 */
	 public	String	getRtnLocCd() {
		 return	this.rtnLocCd;
	 } 
 	/**
	* Column Info
	* @param  troSubSeq
	*/
	public void	setTroSubSeq( String	troSubSeq ) {
		this.troSubSeq =	troSubSeq;
	}
 
	/**
	 * Column Info
	 * @return	troSubSeq
	 */
	 public	String	getTroSubSeq() {
		 return	this.troSubSeq;
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
	* @param  dorArrDt
	*/
	public void	setDorArrDt( String	dorArrDt ) {
		this.dorArrDt =	dorArrDt;
	}
 
	/**
	 * Column Info
	 * @return	dorArrDt
	 */
	 public	String	getDorArrDt() {
		 return	this.dorArrDt;
	 } 
 	/**
	* Column Info
	* @param  troSeq
	*/
	public void	setTroSeq( String	troSeq ) {
		this.troSeq =	troSeq;
	}
 
	/**
	 * Column Info
	 * @return	troSeq
	 */
	 public	String	getTroSeq() {
		 return	this.troSeq;
	 } 
 	/**
	* Column Info
	* @param  cxlFlg
	*/
	public void	setCxlFlg( String	cxlFlg ) {
		this.cxlFlg =	cxlFlg;
	}
 
	/**
	 * Column Info
	 * @return	cxlFlg
	 */
	 public	String	getCxlFlg() {
		 return	this.cxlFlg;
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
	 public	String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
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
	 public	String	getRtnYdCd() {
		 return	this.rtnYdCd;
	 } 
 	/**
	* Column Info
	* @param  pkupLocCd
	*/
	public void	setPkupLocCd( String	pkupLocCd ) {
		this.pkupLocCd =	pkupLocCd;
	}
 
	/**
	 * Column Info
	 * @return	pkupLocCd
	 */
	 public	String	getPkupLocCd() {
		 return	this.pkupLocCd;
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
	* @param  rtnDt
	*/
	public void	setRtnDt( String	rtnDt ) {
		this.rtnDt =	rtnDt;
	}
 
	/**
	 * Column Info
	 * @return	rtnDt
	 */
	 public	String	getRtnDt() {
		 return	this.rtnDt;
	 } 
 	/**
	* Column Info
	* @param  bkgTrspMzdCd
	*/
	public void	setBkgTrspMzdCd( String	bkgTrspMzdCd ) {
		this.bkgTrspMzdCd =	bkgTrspMzdCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgTrspMzdCd
	 */
	 public	String	getBkgTrspMzdCd() {
		 return	this.bkgTrspMzdCd;
	 } 
 	/**
	* Column Info
	* @param  dorAddrTpCd
	*/
	public void	setDorAddrTpCd( String	dorAddrTpCd ) {
		this.dorAddrTpCd =	dorAddrTpCd;
	}
 
	/**
	 * Column Info
	 * @return	dorAddrTpCd
	 */
	 public	String	getDorAddrTpCd() {
		 return	this.dorAddrTpCd;
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
		setTroQty(JSPUtil.getParameter(request,	prefix + "tro_qty", ""));
		setPkupYdCd(JSPUtil.getParameter(request,	prefix + "pkup_yd_cd", ""));
		setRtnLocCd(JSPUtil.getParameter(request,	prefix + "rtn_loc_cd", ""));
		setTroSubSeq(JSPUtil.getParameter(request,	prefix + "tro_sub_seq", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setDorArrDt(JSPUtil.getParameter(request,	prefix + "dor_arr_dt", ""));
		setTroSeq(JSPUtil.getParameter(request,	prefix + "tro_seq", ""));
		setCxlFlg(JSPUtil.getParameter(request,	prefix + "cxl_flg", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setRtnYdCd(JSPUtil.getParameter(request,	prefix + "rtn_yd_cd", ""));
		setPkupLocCd(JSPUtil.getParameter(request,	prefix + "pkup_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setRtnDt(JSPUtil.getParameter(request,	prefix + "rtn_dt", ""));
		setBkgTrspMzdCd(JSPUtil.getParameter(request,	prefix + "bkg_trsp_mzd_cd", ""));
		setDorAddrTpCd(JSPUtil.getParameter(request,	prefix + "dor_addr_tp_cd", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AlpsTroDtlVO[]
	 */
	public AlpsTroDtlVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AlpsTroDtlVO[]
	 */
	public AlpsTroDtlVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AlpsTroDtlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] troQty =	(JSPUtil.getParameter(request, prefix +	"tro_qty".trim(),	length));
				String[] pkupYdCd =	(JSPUtil.getParameter(request, prefix +	"pkup_yd_cd".trim(),	length));
				String[] rtnLocCd =	(JSPUtil.getParameter(request, prefix +	"rtn_loc_cd".trim(),	length));
				String[] troSubSeq =	(JSPUtil.getParameter(request, prefix +	"tro_sub_seq".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] dorArrDt =	(JSPUtil.getParameter(request, prefix +	"dor_arr_dt".trim(),	length));
				String[] troSeq =	(JSPUtil.getParameter(request, prefix +	"tro_seq".trim(),	length));
				String[] cxlFlg =	(JSPUtil.getParameter(request, prefix +	"cxl_flg".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] rtnYdCd =	(JSPUtil.getParameter(request, prefix +	"rtn_yd_cd".trim(),	length));
				String[] pkupLocCd =	(JSPUtil.getParameter(request, prefix +	"pkup_loc_cd".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] rtnDt =	(JSPUtil.getParameter(request, prefix +	"rtn_dt".trim(),	length));
				String[] bkgTrspMzdCd =	(JSPUtil.getParameter(request, prefix +	"bkg_trsp_mzd_cd".trim(),	length));
				String[] dorAddrTpCd =	(JSPUtil.getParameter(request, prefix +	"dor_addr_tp_cd".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AlpsTroDtlVO();
						if ( troQty[i] !=	null)
						model.setTroQty( troQty[i]);
						if ( pkupYdCd[i] !=	null)
						model.setPkupYdCd( pkupYdCd[i]);
						if ( rtnLocCd[i] !=	null)
						model.setRtnLocCd( rtnLocCd[i]);
						if ( troSubSeq[i] !=	null)
						model.setTroSubSeq( troSubSeq[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( dorArrDt[i] !=	null)
						model.setDorArrDt( dorArrDt[i]);
						if ( troSeq[i] !=	null)
						model.setTroSeq( troSeq[i]);
						if ( cxlFlg[i] !=	null)
						model.setCxlFlg( cxlFlg[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( rtnYdCd[i] !=	null)
						model.setRtnYdCd( rtnYdCd[i]);
						if ( pkupLocCd[i] !=	null)
						model.setPkupLocCd( pkupLocCd[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( rtnDt[i] !=	null)
						model.setRtnDt( rtnDt[i]);
						if ( bkgTrspMzdCd[i] !=	null)
						model.setBkgTrspMzdCd( bkgTrspMzdCd[i]);
						if ( dorAddrTpCd[i] !=	null)
						model.setDorAddrTpCd( dorAddrTpCd[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAlpsTroDtlVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return AlpsTroDtlVO[]
	 */
	public AlpsTroDtlVO[]	 getAlpsTroDtlVOs(){
		AlpsTroDtlVO[] vos = (AlpsTroDtlVO[])models.toArray(new	AlpsTroDtlVO[models.size()]);
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
		this.troQty =	this.troQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupYdCd =	this.pkupYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnLocCd =	this.rtnLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSubSeq =	this.troSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorArrDt =	this.dorArrDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq =	this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg =	this.cxlFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnYdCd =	this.rtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupLocCd =	this.pkupLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtnDt =	this.rtnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspMzdCd =	this.bkgTrspMzdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorAddrTpCd =	this.dorAddrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}