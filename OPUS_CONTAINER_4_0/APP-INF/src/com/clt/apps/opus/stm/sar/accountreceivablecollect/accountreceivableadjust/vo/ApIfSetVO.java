/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ApIfSetVO.java
 *@FileTitle : ApIfSetVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.10
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.07.10  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo;

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
public class ApIfSetVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ApIfSetVO>  models =	new	ArrayList<ApIfSetVO>();


	/*	Column Info	*/
	private  String	 dpPrcsKnt   =  null;
	/*	Column Info	*/
	private  String	 sysTpCd   =  null;
	/*	Column Info	*/
	private  String	 vndrNo   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 funcCurrCd   =  null;
	/*	Column Info	*/
	private  String	 adjNo   =  null;
	/*	Column Info	*/
	private  String	 apGlDt   =  null;
	/*	Column Info	*/
	private  String	 adjTpCd   =  null;
	/*	Column Info	*/
	private  String	 apCurrCd   =  null;
	/*	Column Info	*/
	private  String	 rvsFlg   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 apExDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public ApIfSetVO(){}

	public ApIfSetVO(String dpPrcsKnt,String sysTpCd,String vndrNo,String ibflag,String usrId,String funcCurrCd,String adjNo,String apGlDt,String adjTpCd,String apCurrCd,String rvsFlg,String pagerows,String apExDt)	{
		this.dpPrcsKnt  = dpPrcsKnt ;
		this.sysTpCd  = sysTpCd ;
		this.vndrNo  = vndrNo ;
		this.ibflag  = ibflag ;
		this.usrId  = usrId ;
		this.funcCurrCd  = funcCurrCd ;
		this.adjNo  = adjNo ;
		this.apGlDt  = apGlDt ;
		this.adjTpCd  = adjTpCd ;
		this.apCurrCd  = apCurrCd ;
		this.rvsFlg  = rvsFlg ;
		this.pagerows  = pagerows ;
		this.apExDt  = apExDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_prcs_knt", getDpPrcsKnt());		
		this.hashColumns.put("sys_tp_cd", getSysTpCd());		
		this.hashColumns.put("vndr_no", getVndrNo());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("func_curr_cd", getFuncCurrCd());		
		this.hashColumns.put("adj_no", getAdjNo());		
		this.hashColumns.put("ap_gl_dt", getApGlDt());		
		this.hashColumns.put("adj_tp_cd", getAdjTpCd());		
		this.hashColumns.put("ap_curr_cd", getApCurrCd());		
		this.hashColumns.put("rvs_flg", getRvsFlg());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("ap_ex_dt", getApExDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("dp_prcs_knt", "dpPrcsKnt");
		this.hashFields.put("sys_tp_cd", "sysTpCd");
		this.hashFields.put("vndr_no", "vndrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("func_curr_cd", "funcCurrCd");
		this.hashFields.put("adj_no", "adjNo");
		this.hashFields.put("ap_gl_dt", "apGlDt");
		this.hashFields.put("adj_tp_cd", "adjTpCd");
		this.hashFields.put("ap_curr_cd", "apCurrCd");
		this.hashFields.put("rvs_flg", "rvsFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ap_ex_dt", "apExDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  dpPrcsKnt
	*/
	public void	setDpPrcsKnt( String	dpPrcsKnt ) {
		this.dpPrcsKnt =	dpPrcsKnt;
	}
 
	/**
	 * Column Info
	 * @return	dpPrcsKnt
	 */
	 public	 String	getDpPrcsKnt() {
		 return	this.dpPrcsKnt;
	 } 
 	/**
	* Column Info
	* @param  sysTpCd
	*/
	public void	setSysTpCd( String	sysTpCd ) {
		this.sysTpCd =	sysTpCd;
	}
 
	/**
	 * Column Info
	 * @return	sysTpCd
	 */
	 public	 String	getSysTpCd() {
		 return	this.sysTpCd;
	 } 
 	/**
	* Column Info
	* @param  vndrNo
	*/
	public void	setVndrNo( String	vndrNo ) {
		this.vndrNo =	vndrNo;
	}
 
	/**
	 * Column Info
	 * @return	vndrNo
	 */
	 public	 String	getVndrNo() {
		 return	this.vndrNo;
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
	* @param  funcCurrCd
	*/
	public void	setFuncCurrCd( String	funcCurrCd ) {
		this.funcCurrCd =	funcCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	funcCurrCd
	 */
	 public	 String	getFuncCurrCd() {
		 return	this.funcCurrCd;
	 } 
 	/**
	* Column Info
	* @param  adjNo
	*/
	public void	setAdjNo( String	adjNo ) {
		this.adjNo =	adjNo;
	}
 
	/**
	 * Column Info
	 * @return	adjNo
	 */
	 public	 String	getAdjNo() {
		 return	this.adjNo;
	 } 
 	/**
	* Column Info
	* @param  apGlDt
	*/
	public void	setApGlDt( String	apGlDt ) {
		this.apGlDt =	apGlDt;
	}
 
	/**
	 * Column Info
	 * @return	apGlDt
	 */
	 public	 String	getApGlDt() {
		 return	this.apGlDt;
	 } 
 	/**
	* Column Info
	* @param  adjTpCd
	*/
	public void	setAdjTpCd( String	adjTpCd ) {
		this.adjTpCd =	adjTpCd;
	}
 
	/**
	 * Column Info
	 * @return	adjTpCd
	 */
	 public	 String	getAdjTpCd() {
		 return	this.adjTpCd;
	 } 
 	/**
	* Column Info
	* @param  apCurrCd
	*/
	public void	setApCurrCd( String	apCurrCd ) {
		this.apCurrCd =	apCurrCd;
	}
 
	/**
	 * Column Info
	 * @return	apCurrCd
	 */
	 public	 String	getApCurrCd() {
		 return	this.apCurrCd;
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
	* @param  apExDt
	*/
	public void	setApExDt( String	apExDt ) {
		this.apExDt =	apExDt;
	}
 
	/**
	 * Column Info
	 * @return	apExDt
	 */
	 public	 String	getApExDt() {
		 return	this.apExDt;
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
		setDpPrcsKnt(JSPUtil.getParameter(request,	prefix + "dp_prcs_knt", ""));
		setSysTpCd(JSPUtil.getParameter(request,	prefix + "sys_tp_cd", ""));
		setVndrNo(JSPUtil.getParameter(request,	prefix + "vndr_no", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setFuncCurrCd(JSPUtil.getParameter(request,	prefix + "func_curr_cd", ""));
		setAdjNo(JSPUtil.getParameter(request,	prefix + "adj_no", ""));
		setApGlDt(JSPUtil.getParameter(request,	prefix + "ap_gl_dt", ""));
		setAdjTpCd(JSPUtil.getParameter(request,	prefix + "adj_tp_cd", ""));
		setApCurrCd(JSPUtil.getParameter(request,	prefix + "ap_curr_cd", ""));
		setRvsFlg(JSPUtil.getParameter(request,	prefix + "rvs_flg", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setApExDt(JSPUtil.getParameter(request,	prefix + "ap_ex_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ApIfSetVO[]
	 */
	public ApIfSetVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ApIfSetVO[]
	 */
	public ApIfSetVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ApIfSetVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] dpPrcsKnt =	(JSPUtil.getParameter(request, prefix +	"dp_prcs_knt".trim(),	length));
				String[] sysTpCd =	(JSPUtil.getParameter(request, prefix +	"sys_tp_cd".trim(),	length));
				String[] vndrNo =	(JSPUtil.getParameter(request, prefix +	"vndr_no".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] funcCurrCd =	(JSPUtil.getParameter(request, prefix +	"func_curr_cd".trim(),	length));
				String[] adjNo =	(JSPUtil.getParameter(request, prefix +	"adj_no".trim(),	length));
				String[] apGlDt =	(JSPUtil.getParameter(request, prefix +	"ap_gl_dt".trim(),	length));
				String[] adjTpCd =	(JSPUtil.getParameter(request, prefix +	"adj_tp_cd".trim(),	length));
				String[] apCurrCd =	(JSPUtil.getParameter(request, prefix +	"ap_curr_cd".trim(),	length));
				String[] rvsFlg =	(JSPUtil.getParameter(request, prefix +	"rvs_flg".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] apExDt =	(JSPUtil.getParameter(request, prefix +	"ap_ex_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	ApIfSetVO();
						if ( dpPrcsKnt[i] !=	null)
						model.setDpPrcsKnt( dpPrcsKnt[i]);
						if ( sysTpCd[i] !=	null)
						model.setSysTpCd( sysTpCd[i]);
						if ( vndrNo[i] !=	null)
						model.setVndrNo( vndrNo[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( funcCurrCd[i] !=	null)
						model.setFuncCurrCd( funcCurrCd[i]);
						if ( adjNo[i] !=	null)
						model.setAdjNo( adjNo[i]);
						if ( apGlDt[i] !=	null)
						model.setApGlDt( apGlDt[i]);
						if ( adjTpCd[i] !=	null)
						model.setAdjTpCd( adjTpCd[i]);
						if ( apCurrCd[i] !=	null)
						model.setApCurrCd( apCurrCd[i]);
						if ( rvsFlg[i] !=	null)
						model.setRvsFlg( rvsFlg[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( apExDt[i] !=	null)
						model.setApExDt( apExDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getApIfSetVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ApIfSetVO[]
	 */
	public ApIfSetVO[]	 getApIfSetVOs(){
		ApIfSetVO[] vos = (ApIfSetVO[])models.toArray(new	ApIfSetVO[models.size()]);
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
		this.dpPrcsKnt =	this.dpPrcsKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sysTpCd =	this.sysTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNo =	this.vndrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.funcCurrCd =	this.funcCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjNo =	this.adjNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apGlDt =	this.apGlDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adjTpCd =	this.adjTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apCurrCd =	this.apCurrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rvsFlg =	this.rvsFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apExDt =	this.apExDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}