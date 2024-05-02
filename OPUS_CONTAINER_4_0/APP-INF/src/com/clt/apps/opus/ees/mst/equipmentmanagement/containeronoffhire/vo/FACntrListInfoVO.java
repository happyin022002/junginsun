/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : FACntrListInfoVO.java
 *@FileTitle : FACntrListInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.07.09
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.07.09  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo;

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
public class FACntrListInfoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<FACntrListInfoVO>  models =	new	ArrayList<FACntrListInfoVO>();


	/*	Column Info	*/
	private  String	 onhYdCd   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 cntrStsCd   =  null;
	/*	Column Info	*/
	private  String	 usedDys   =  null;
	/*	Column Info	*/
	private  String	 lotPlnYr   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 lotSeq   =  null;
	/*	Column Info	*/
	private  String	 lotLocCd   =  null;
	/*	Column Info	*/
	private  String	 onhDt   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 minOnhDys   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 termCngSeq   =  null;
	/*	Column Info	*/
	private  String	 rowSeq   =  null;
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
	private  String	 mftDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public FACntrListInfoVO(){}

	public FACntrListInfoVO(String onhYdCd,String agmtSeq,String cnmvDt,String cntrStsCd,String usedDys,String lotPlnYr,String crntYdCd,String lotSeq,String lotLocCd,String onhDt,String pagerows,String minOnhDys,String cnmvStsCd,String ibflag,String termCngSeq,String rowSeq,String cntrNo,String agmtCtyCd,String cntrTpszCd,String refNo,String lstmCd,String onhFreeDys,String mftDt)	{
		this.onhYdCd  = onhYdCd ;
		this.agmtSeq  = agmtSeq ;
		this.cnmvDt  = cnmvDt ;
		this.cntrStsCd  = cntrStsCd ;
		this.usedDys  = usedDys ;
		this.lotPlnYr  = lotPlnYr ;
		this.crntYdCd  = crntYdCd ;
		this.lotSeq  = lotSeq ;
		this.lotLocCd  = lotLocCd ;
		this.onhDt  = onhDt ;
		this.pagerows  = pagerows ;
		this.minOnhDys  = minOnhDys ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.ibflag  = ibflag ;
		this.termCngSeq  = termCngSeq ;
		this.rowSeq  = rowSeq ;
		this.cntrNo  = cntrNo ;
		this.agmtCtyCd  = agmtCtyCd ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.refNo  = refNo ;
		this.lstmCd  = lstmCd ;
		this.onhFreeDys  = onhFreeDys ;
		this.mftDt  = mftDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("onh_yd_cd", getOnhYdCd());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("cntr_sts_cd", getCntrStsCd());		
		this.hashColumns.put("used_dys", getUsedDys());		
		this.hashColumns.put("lot_pln_yr", getLotPlnYr());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("lot_seq", getLotSeq());		
		this.hashColumns.put("lot_loc_cd", getLotLocCd());		
		this.hashColumns.put("onh_dt", getOnhDt());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("min_onh_dys", getMinOnhDys());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("term_cng_seq", getTermCngSeq());		
		this.hashColumns.put("row_seq", getRowSeq());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("ref_no", getRefNo());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("onh_free_dys", getOnhFreeDys());		
		this.hashColumns.put("mft_dt", getMftDt());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("onh_yd_cd", "onhYdCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("cntr_sts_cd", "cntrStsCd");
		this.hashFields.put("used_dys", "usedDys");
		this.hashFields.put("lot_pln_yr", "lotPlnYr");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("lot_seq", "lotSeq");
		this.hashFields.put("lot_loc_cd", "lotLocCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("min_onh_dys", "minOnhDys");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("term_cng_seq", "termCngSeq");
		this.hashFields.put("row_seq", "rowSeq");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("ref_no", "refNo");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("onh_free_dys", "onhFreeDys");
		this.hashFields.put("mft_dt", "mftDt");
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
	* @param  lotPlnYr
	*/
	public void	setLotPlnYr( String	lotPlnYr ) {
		this.lotPlnYr =	lotPlnYr;
	}
 
	/**
	 * Column Info
	 * @return	lotPlnYr
	 */
	 public	 String	getLotPlnYr() {
		 return	this.lotPlnYr;
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
	* @param  lotSeq
	*/
	public void	setLotSeq( String	lotSeq ) {
		this.lotSeq =	lotSeq;
	}
 
	/**
	 * Column Info
	 * @return	lotSeq
	 */
	 public	 String	getLotSeq() {
		 return	this.lotSeq;
	 } 
 	/**
	* Column Info
	* @param  lotLocCd
	*/
	public void	setLotLocCd( String	lotLocCd ) {
		this.lotLocCd =	lotLocCd;
	}
 
	/**
	 * Column Info
	 * @return	lotLocCd
	 */
	 public	 String	getLotLocCd() {
		 return	this.lotLocCd;
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
	* @param  termCngSeq
	*/
	public void	setTermCngSeq( String	termCngSeq ) {
		this.termCngSeq =	termCngSeq;
	}
 
	/**
	 * Column Info
	 * @return	termCngSeq
	 */
	 public	 String	getTermCngSeq() {
		 return	this.termCngSeq;
	 } 
 	/**
	* Column Info
	* @param  rowSeq
	*/
	public void	setRowSeq( String	rowSeq ) {
		this.rowSeq =	rowSeq;
	}
 
	/**
	 * Column Info
	 * @return	rowSeq
	 */
	 public	 String	getRowSeq() {
		 return	this.rowSeq;
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
	* @param  mftDt
	*/
	public void	setMftDt( String	mftDt ) {
		this.mftDt =	mftDt;
	}
 
	/**
	 * Column Info
	 * @return	mftDt
	 */
	 public	 String	getMftDt() {
		 return	this.mftDt;
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
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setCntrStsCd(JSPUtil.getParameter(request,	prefix + "cntr_sts_cd", ""));
		setUsedDys(JSPUtil.getParameter(request,	prefix + "used_dys", ""));
		setLotPlnYr(JSPUtil.getParameter(request,	prefix + "lot_pln_yr", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setLotSeq(JSPUtil.getParameter(request,	prefix + "lot_seq", ""));
		setLotLocCd(JSPUtil.getParameter(request,	prefix + "lot_loc_cd", ""));
		setOnhDt(JSPUtil.getParameter(request,	prefix + "onh_dt", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setMinOnhDys(JSPUtil.getParameter(request,	prefix + "min_onh_dys", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setTermCngSeq(JSPUtil.getParameter(request,	prefix + "term_cng_seq", ""));
		setRowSeq(JSPUtil.getParameter(request,	prefix + "row_seq", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setRefNo(JSPUtil.getParameter(request,	prefix + "ref_no", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setOnhFreeDys(JSPUtil.getParameter(request,	prefix + "onh_free_dys", ""));
		setMftDt(JSPUtil.getParameter(request,	prefix + "mft_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FACntrListInfoVO[]
	 */
	public FACntrListInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return FACntrListInfoVO[]
	 */
	public FACntrListInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		FACntrListInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] onhYdCd =	(JSPUtil.getParameter(request, prefix +	"onh_yd_cd".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] cntrStsCd =	(JSPUtil.getParameter(request, prefix +	"cntr_sts_cd".trim(),	length));
				String[] usedDys =	(JSPUtil.getParameter(request, prefix +	"used_dys".trim(),	length));
				String[] lotPlnYr =	(JSPUtil.getParameter(request, prefix +	"lot_pln_yr".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] lotSeq =	(JSPUtil.getParameter(request, prefix +	"lot_seq".trim(),	length));
				String[] lotLocCd =	(JSPUtil.getParameter(request, prefix +	"lot_loc_cd".trim(),	length));
				String[] onhDt =	(JSPUtil.getParameter(request, prefix +	"onh_dt".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] minOnhDys =	(JSPUtil.getParameter(request, prefix +	"min_onh_dys".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] termCngSeq =	(JSPUtil.getParameter(request, prefix +	"term_cng_seq".trim(),	length));
				String[] rowSeq =	(JSPUtil.getParameter(request, prefix +	"row_seq".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] refNo =	(JSPUtil.getParameter(request, prefix +	"ref_no".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] onhFreeDys =	(JSPUtil.getParameter(request, prefix +	"onh_free_dys".trim(),	length));
				String[] mftDt =	(JSPUtil.getParameter(request, prefix +	"mft_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	FACntrListInfoVO();
						if ( onhYdCd[i] !=	null)
						model.setOnhYdCd( onhYdCd[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( cntrStsCd[i] !=	null)
						model.setCntrStsCd( cntrStsCd[i]);
						if ( usedDys[i] !=	null)
						model.setUsedDys( usedDys[i]);
						if ( lotPlnYr[i] !=	null)
						model.setLotPlnYr( lotPlnYr[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( lotSeq[i] !=	null)
						model.setLotSeq( lotSeq[i]);
						if ( lotLocCd[i] !=	null)
						model.setLotLocCd( lotLocCd[i]);
						if ( onhDt[i] !=	null)
						model.setOnhDt( onhDt[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( minOnhDys[i] !=	null)
						model.setMinOnhDys( minOnhDys[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( termCngSeq[i] !=	null)
						model.setTermCngSeq( termCngSeq[i]);
						if ( rowSeq[i] !=	null)
						model.setRowSeq( rowSeq[i]);
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
						if ( mftDt[i] !=	null)
						model.setMftDt( mftDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getFACntrListInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return FACntrListInfoVO[]
	 */
	public FACntrListInfoVO[]	 getFACntrListInfoVOs(){
		FACntrListInfoVO[] vos = (FACntrListInfoVO[])models.toArray(new	FACntrListInfoVO[models.size()]);
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
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrStsCd =	this.cntrStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usedDys =	this.usedDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotPlnYr =	this.lotPlnYr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotSeq =	this.lotSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lotLocCd =	this.lotLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt =	this.onhDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minOnhDys =	this.minOnhDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCngSeq =	this.termCngSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowSeq =	this.rowSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNo =	this.refNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhFreeDys =	this.onhFreeDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mftDt =	this.mftDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}