/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : InventoryDetailVO.java
 *@FileTitle : InventoryDetailVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.09
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.07.09  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containerleasemgt.leasereport.vo;

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
public class InventoryDetailVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<InventoryDetailVO>  models =	new	ArrayList<InventoryDetailVO>();


	/*	Column Info	*/
	private  String	 onhYdCd   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 usedDys   =  null;
	/*	Column Info	*/
	private  String	 onhDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 minOnhDys   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 refNo   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 onhFreeDys   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 cntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 lstCnt   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 vndrAbbrNm   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public InventoryDetailVO(){}

	public InventoryDetailVO(String onhYdCd,String agmtSeq,String usedDys,String onhDt,String pagerows,String minOnhDys,String ibflag,String cntrNo,String agmtCtyCd,String cntrTpszCd,String refNo,String lstmCd,String onhFreeDys,String cnmvDt,String cntrStsCd,String cnmvStsCd,String crntYdCd,String lstCnt,String vndrSeq,String vndrAbbrNm)	{
		this.onhYdCd  = onhYdCd ;
		this.agmtSeq  = agmtSeq ;
		this.usedDys  = usedDys ;
		this.onhDt  = onhDt ;
		this.pagerows  = pagerows ;
		this.minOnhDys  = minOnhDys ;
		this.ibflag  = ibflag ;
		this.cntrNo  = cntrNo ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.refNo  = refNo ;
		this.lstmCd  = lstmCd ;
		this.onhFreeDys  = onhFreeDys ;
		this.cnmvDt  = cnmvDt ;
		this.cntrStsCd  = cntrStsCd ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.crntYdCd  = crntYdCd ;
		this.lstCnt  = lstCnt ;
		this.vndrSeq  = vndrSeq ;
		this.vndrAbbrNm  = vndrAbbrNm ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("used_dys", getUsedDys());		
		this.hashColumns.put("onh_dt", getOnhDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("min_onh_dys", getMinOnhDys());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("onh_free_dys", getOnhFreeDys());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("lst_cnt", getLstCnt());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("vndr_abbr_nm", getVndrAbbrNm());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("used_dys", "usedDys");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("min_onh_dys", "minOnhDys");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("onh_free_dys", "onhFreeDys");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("lst_cnt", "lstCnt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("vndr_abbr_nm", "vndrAbbrNm");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  onhYdCd
	*/
	public void	setOnhYdCd( String	onhYdCd ) {
		this.onhYdCd =	onhYdCd;
	}
 
	/**
	 * Column Info
	 * @return	onhYdCd
	 */
	 public	 String	getOnhYdCd() {
		 return	this.onhYdCd;
	 } 
 	/**
	* Column Info
	* @param  agmtSeq
	*/
	public void	setAgmtSeq( String	agmtSeq ) {
		this.agmtSeq =	agmtSeq;
	}
 
	/**
	 * Column Info
	 * @return	agmtSeq
	 */
	 public	 String	getAgmtSeq() {
		 return	this.agmtSeq;
	 } 
 	/**
	* Column Info
	* @param  usedDys
	*/
	public void	setUsedDys( String	usedDys ) {
		this.usedDys =	usedDys;
	}
 
	/**
	 * Column Info
	 * @return	usedDys
	 */
	 public	 String	getUsedDys() {
		 return	this.usedDys;
	 } 
 	/**
	* Column Info
	* @param  onhDt
	*/
	public void	setOnhDt( String	onhDt ) {
		this.onhDt =	onhDt;
	}
 
	/**
	 * Column Info
	 * @return	onhDt
	 */
	 public	 String	getOnhDt() {
		 return	this.onhDt;
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
	* @param  minOnhDys
	*/
	public void	setMinOnhDys( String	minOnhDys ) {
		this.minOnhDys =	minOnhDys;
	}
 
	/**
	 * Column Info
	 * @return	minOnhDys
	 */
	 public	 String	getMinOnhDys() {
		 return	this.minOnhDys;
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
	* @param  cntrNo
	*/
	public void	setCntrNo( String	cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 
	/**
	 * Column Info
	 * @return	cntrNo
	 */
	 public	 String	getCntrNo() {
		 return	this.cntrNo;
	 } 
 	/**
	* Column Info
	* @param  agmtCtyCd
	*/
	public void	setAgmtCtyCd( String	agmtCtyCd ) {
		this.agmtCtyCd =	agmtCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtCtyCd
	 */
	 public	 String	getAgmtCtyCd() {
		 return	this.agmtCtyCd;
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
	 public	 String	getCntrTpszCd() {
		 return	this.cntrTpszCd;
	 } 
 	/**
	* Column Info
	* @param  refNo
	*/
	public void	setRefNo( String	refNo ) {
		this.refNo =	refNo;
	}
 
	/**
	 * Column Info
	 * @return	refNo
	 */
	 public	 String	getRefNo() {
		 return	this.refNo;
	 } 
 	/**
	* Column Info
	* @param  lstmCd
	*/
	public void	setLstmCd( String	lstmCd ) {
		this.lstmCd =	lstmCd;
	}
 
	/**
	 * Column Info
	 * @return	lstmCd
	 */
	 public	 String	getLstmCd() {
		 return	this.lstmCd;
	 } 
 	/**
	* Column Info
	* @param  onhFreeDys
	*/
	public void	setOnhFreeDys( String	onhFreeDys ) {
		this.onhFreeDys =	onhFreeDys;
	}
 
	/**
	 * Column Info
	 * @return	onhFreeDys
	 */
	 public	 String	getOnhFreeDys() {
		 return	this.onhFreeDys;
	 } 
 	/**
	* Column Info
	* @param  cnmvDt
	*/
	public void	setCnmvDt( String	cnmvDt ) {
		this.cnmvDt =	cnmvDt;
	}
 
	/**
	 * Column Info
	 * @return	cnmvDt
	 */
	 public	 String	getCnmvDt() {
		 return	this.cnmvDt;
	 } 
 	/**
	* Column Info
	* @param  cntrStsCd
	*/
	public void	setCntrStsCd( String	cntrStsCd ) {
		this.cntrStsCd =	cntrStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cntrStsCd
	 */
	 public	 String	getCntrStsCd() {
		 return	this.cntrStsCd;
	 } 
 	/**
	* Column Info
	* @param  cnmvStsCd
	*/
	public void	setCnmvStsCd( String	cnmvStsCd ) {
		this.cnmvStsCd =	cnmvStsCd;
	}
 
	/**
	 * Column Info
	 * @return	cnmvStsCd
	 */
	 public	 String	getCnmvStsCd() {
		 return	this.cnmvStsCd;
	 } 
 	/**
	* Column Info
	* @param  crntYdCd
	*/
	public void	setCrntYdCd( String	crntYdCd ) {
		this.crntYdCd =	crntYdCd;
	}
 
	/**
	 * Column Info
	 * @return	crntYdCd
	 */
	 public	 String	getCrntYdCd() {
		 return	this.crntYdCd;
	 } 
 	/**
	* Column Info
	* @param  lstCnt
	*/
	public void	setLstCnt( String	lstCnt ) {
		this.lstCnt =	lstCnt;
	}
 
	/**
	 * Column Info
	 * @return	lstCnt
	 */
	 public	 String	getLstCnt() {
		 return	this.lstCnt;
	 } 
 	/**
	* Column Info
	* @param  vndrSeq
	*/
	public void	setVndrSeq( String	vndrSeq ) {
		this.vndrSeq =	vndrSeq;
	}
 
	/**
	 * Column Info
	 * @return	vndrSeq
	 */
	 public	 String	getVndrSeq() {
		 return	this.vndrSeq;
	 } 
 	/**
	* Column Info
	* @param  vndrAbbrNm
	*/
	public void	setVndrAbbrNm( String	vndrAbbrNm ) {
		this.vndrAbbrNm =	vndrAbbrNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrAbbrNm
	 */
	 public	 String	getVndrAbbrNm() {
		 return	this.vndrAbbrNm;
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
		setOnhYdCd(JSPUtil.getParameter(request,	prefix + "onh_yd_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setUsedDys(JSPUtil.getParameter(request,	prefix + "used_dys", ""));
		setOnhDt(JSPUtil.getParameter(request,	prefix + "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setMinOnhDys(JSPUtil.getParameter(request,	prefix + "min_onh_dys", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setOnhFreeDys(JSPUtil.getParameter(request,	prefix + "onh_free_dys", ""));
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setCntrStsCd(JSPUtil.getParameter(request,	prefix + "cntr_sts_cd", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setLstCnt(JSPUtil.getParameter(request,	prefix + "lst_cnt", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setVndrAbbrNm(JSPUtil.getParameter(request,	prefix + "vndr_abbr_nm", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InventoryDetailVO[]
	 */
	public InventoryDetailVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return InventoryDetailVO[]
	 */
	public InventoryDetailVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		InventoryDetailVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] onhYdCd =	(JSPUtil.getParameter(request, prefix +	"onh_yd_cd".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] usedDys =	(JSPUtil.getParameter(request, prefix +	"used_dys".trim(),	length));
				String[] onhDt =	(JSPUtil.getParameter(request, prefix +	"onh_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] minOnhDys =	(JSPUtil.getParameter(request, prefix +	"min_onh_dys".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] onhFreeDys =	(JSPUtil.getParameter(request, prefix +	"onh_free_dys".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] cntrStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_cd".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] lstCnt =	(JSPUtil.getParameter(request, prefix +	"lst_cnt".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] vndrAbbrNm =	(JSPUtil.getParameter(request, prefix +	"vndr_abbr_nm".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	InventoryDetailVO();
						if ( onhYdCd[i] !=	null)
						model.setOnhYdCd( onhYdCd[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( usedDys[i] !=	null)
						model.setUsedDys( usedDys[i]);
						if ( onhDt[i] !=	null)
						model.setOnhDt( onhDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( minOnhDys[i] !=	null)
						model.setMinOnhDys( minOnhDys[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( refNo[i] !=	null)
						model.setRefNo( refNo[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( onhFreeDys[i] !=	null)
						model.setOnhFreeDys( onhFreeDys[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( cntrStsCd[i] !=	null)
						model.setCntrStsCd( cntrStsCd[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( lstCnt[i] !=	null)
						model.setLstCnt( lstCnt[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( vndrAbbrNm[i] !=	null)
						model.setVndrAbbrNm( vndrAbbrNm[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getInventoryDetailVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return InventoryDetailVO[]
	 */
	public InventoryDetailVO[]	 getInventoryDetailVOs(){
		InventoryDetailVO[] vos = (InventoryDetailVO[])models.toArray(new	InventoryDetailVO[models.size()]);
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
		this.onhYdCd =	this.onhYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedDys =	this.usedDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt =	this.onhDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOnhDys =	this.minOnhDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhFreeDys =	this.onhFreeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd =	this.cntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstCnt =	this.lstCnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrAbbrNm =	this.vndrAbbrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}