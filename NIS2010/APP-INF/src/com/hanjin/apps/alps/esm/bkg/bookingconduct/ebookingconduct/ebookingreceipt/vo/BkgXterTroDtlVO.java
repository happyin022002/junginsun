/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BkgXterTroDtlVO.java
 *@FileTitle : BkgXterTroDtlVO
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
public class BkgXterTroDtlVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BkgXterTroDtlVO>  models =	new	ArrayList<BkgXterTroDtlVO>();


	/*	Column Info	*/
	private  String	 troSubSeq   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 troSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 cntrQty   =  null;
	/*	Column Info	*/
	private  String	 dorRqstDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 bkgTrspModCd   =  null;
	/*	Column Info	*/
	private  String	 dorAddrTpCd   =  null;
	/*	Column Info	*/
	private  String	 cntrRtnYdCd   =  null;
	/*	Column Info	*/
	private  String	 cntrRtnDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public BkgXterTroDtlVO(){}

	public BkgXterTroDtlVO(String troSubSeq,String ibflag,String troSeq,String cntrTpszCd,String cntrQty,String dorRqstDt,String pagerows,String bkgTrspModCd,String dorAddrTpCd,String cntrRtnYdCd,String cntrRtnDt)	{
		this.troSubSeq  = troSubSeq ;
		this.ibflag  = ibflag ;
		this.troSeq  = troSeq ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.cntrQty  = cntrQty ;
		this.dorRqstDt  = dorRqstDt ;
		this.pagerows  = pagerows ;
		this.bkgTrspModCd  = bkgTrspModCd ;
		this.dorAddrTpCd  = dorAddrTpCd ;
		this.cntrRtnYdCd  = cntrRtnYdCd ;
		this.cntrRtnDt  = cntrRtnDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("tro_sub_seq", getTroSubSeq());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("tro_seq", getTroSeq());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("cntr_qty", getCntrQty());		
		this.hashColumns.put("dor_rqst_dt", getDorRqstDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("bkg_trsp_mod_cd", getBkgTrspModCd());		
		this.hashColumns.put("dor_addr_tp_cd", getDorAddrTpCd());		
		this.hashColumns.put("cntr_rtn_yd_cd", getCntrRtnYdCd());		
		this.hashColumns.put("cntr_rtn_dt", getCntrRtnDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("tro_sub_seq", "troSubSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tro_seq", "troSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("cntr_qty", "cntrQty");
		this.hashFields.put("dor_rqst_dt", "dorRqstDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_trsp_mod_cd", "bkgTrspModCd");
		this.hashFields.put("dor_addr_tp_cd", "dorAddrTpCd");
		this.hashFields.put("cntr_rtn_yd_cd", "cntrRtnYdCd");
		this.hashFields.put("cntr_rtn_dt", "cntrRtnDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  cntrQty
	*/
	public void	setCntrQty( String	cntrQty ) {
		this.cntrQty =	cntrQty;
	}
 
	/**
	 * Column Info
	 * @return	cntrQty
	 */
	 public	String	getCntrQty() {
		 return	this.cntrQty;
	 } 
 	/**
	* Column Info
	* @param  dorRqstDt
	*/
	public void	setDorRqstDt( String	dorRqstDt ) {
		this.dorRqstDt =	dorRqstDt;
	}
 
	/**
	 * Column Info
	 * @return	dorRqstDt
	 */
	 public	String	getDorRqstDt() {
		 return	this.dorRqstDt;
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
	* @param  bkgTrspModCd
	*/
	public void	setBkgTrspModCd( String	bkgTrspModCd ) {
		this.bkgTrspModCd =	bkgTrspModCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgTrspModCd
	 */
	 public	String	getBkgTrspModCd() {
		 return	this.bkgTrspModCd;
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
	* Column Info
	* @param  cntrRtnYdCd
	*/
	public void	setCntrRtnYdCd( String	cntrRtnYdCd ) {
		this.cntrRtnYdCd =	cntrRtnYdCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrRtnYdCd
	 */
	 public	String	getCntrRtnYdCd() {
		 return	this.cntrRtnYdCd;
	 } 
 	/**
	* Column Info
	* @param  cntrRtnDt
	*/
	public void	setCntrRtnDt( String	cntrRtnDt ) {
		this.cntrRtnDt =	cntrRtnDt;
	}
 
	/**
	 * Column Info
	 * @return	cntrRtnDt
	 */
	 public	String	getCntrRtnDt() {
		 return	this.cntrRtnDt;
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
		setTroSubSeq(JSPUtil.getParameter(request,	prefix + "tro_sub_seq", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setTroSeq(JSPUtil.getParameter(request,	prefix + "tro_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setCntrQty(JSPUtil.getParameter(request,	prefix + "cntr_qty", ""));
		setDorRqstDt(JSPUtil.getParameter(request,	prefix + "dor_rqst_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setBkgTrspModCd(JSPUtil.getParameter(request,	prefix + "bkg_trsp_mod_cd", ""));
		setDorAddrTpCd(JSPUtil.getParameter(request,	prefix + "dor_addr_tp_cd", ""));
		setCntrRtnYdCd(JSPUtil.getParameter(request,	prefix + "cntr_rtn_yd_cd", ""));
		setCntrRtnDt(JSPUtil.getParameter(request,	prefix + "cntr_rtn_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgXterTroDtlVO[]
	 */
	public BkgXterTroDtlVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgXterTroDtlVO[]
	 */
	public BkgXterTroDtlVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BkgXterTroDtlVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] troSubSeq =	(JSPUtil.getParameter(request, prefix +	"tro_sub_seq".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] troSeq =	(JSPUtil.getParameter(request, prefix +	"tro_seq".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] cntrQty =	(JSPUtil.getParameter(request, prefix +	"cntr_qty".trim(),	length));
				String[] dorRqstDt =	(JSPUtil.getParameter(request, prefix +	"dor_rqst_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] bkgTrspModCd =	(JSPUtil.getParameter(request, prefix +	"bkg_trsp_mod_cd".trim(),	length));
				String[] dorAddrTpCd =	(JSPUtil.getParameter(request, prefix +	"dor_addr_tp_cd".trim(),	length));
				String[] cntrRtnYdCd =	(JSPUtil.getParameter(request, prefix +	"cntr_rtn_yd_cd".trim(),	length));
				String[] cntrRtnDt =	(JSPUtil.getParameter(request, prefix +	"cntr_rtn_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BkgXterTroDtlVO();
						if ( troSubSeq[i] !=	null)
						model.setTroSubSeq( troSubSeq[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( troSeq[i] !=	null)
						model.setTroSeq( troSeq[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( cntrQty[i] !=	null)
						model.setCntrQty( cntrQty[i]);
						if ( dorRqstDt[i] !=	null)
						model.setDorRqstDt( dorRqstDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( bkgTrspModCd[i] !=	null)
						model.setBkgTrspModCd( bkgTrspModCd[i]);
						if ( dorAddrTpCd[i] !=	null)
						model.setDorAddrTpCd( dorAddrTpCd[i]);
						if ( cntrRtnYdCd[i] !=	null)
						model.setCntrRtnYdCd( cntrRtnYdCd[i]);
						if ( cntrRtnDt[i] !=	null)
						model.setCntrRtnDt( cntrRtnDt[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBkgXterTroDtlVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BkgXterTroDtlVO[]
	 */
	public BkgXterTroDtlVO[]	 getBkgXterTroDtlVOs(){
		BkgXterTroDtlVO[] vos = (BkgXterTroDtlVO[])models.toArray(new	BkgXterTroDtlVO[models.size()]);
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
		this.troSubSeq =	this.troSubSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.troSeq =	this.troSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrQty =	this.cntrQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorRqstDt =	this.dorRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTrspModCd =	this.bkgTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorAddrTpCd =	this.dorAddrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnYdCd =	this.cntrRtnYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRtnDt =	this.cntrRtnDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}