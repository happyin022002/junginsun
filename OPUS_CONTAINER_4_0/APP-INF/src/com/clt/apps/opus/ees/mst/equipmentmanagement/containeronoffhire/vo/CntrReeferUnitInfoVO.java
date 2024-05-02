/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CntrReeferUnitInfoVO.java
 *@FileTitle : CntrReeferUnitInfoVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.05.27
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.05.27  
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
public class CntrReeferUnitInfoVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CntrReeferUnitInfoVO>  models =	new	ArrayList<CntrReeferUnitInfoVO>();


	/*	Column Info	*/
	private  String	 rfMkrNm   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 ceflg   =  null;
	/*	Column Info	*/
	private  String	 minTemp   =  null;
	/*	Column Info	*/
	private  String	 onhDt   =  null;
	/*	Column Info	*/
	private  String	 rfMdlNm   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 maxTemp   =  null;
	/*	Column Info	*/
	private  String	 rfMkrSeq   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 aeflg   =  null;
	/*	Column Info	*/
	private  String	 eeflg   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 beflg   =  null;
	/*	Column Info	*/
	private  String	 deflg   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 rfRfrNo   =  null;
	/*	Column Info	*/
	private  String	 usrId   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblNm   =  null;
	/*	Column Info	*/
	private  String	 rfTpCd   =  null;
	/*	Column Info	*/
	private  String	 rfHumidCtrlValCd   =  null;
	/*	Column Info	*/
	private  String	 rfCmprCtnt   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblTp   =  null;
	/*	Column Info	*/
	private  String	 rstrUsgLblDesc   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public CntrReeferUnitInfoVO(){}

	public CntrReeferUnitInfoVO(String rfMkrNm,String agmtNo,String ceflg,String minTemp,String onhDt,String rfMdlNm,String pagerows,String maxTemp,String rfMkrSeq,String ibflag,String aeflg,String eeflg,String cntrNo,String vndrSeq,String cntrTpszCd,String beflg,String deflg,String lstmCd,String rfRfrNo,String usrId,String rstrUsgLblNm,String rfTpCd,String rfHumidCtrlValCd,String rfCmprCtnt,String rstrUsgLblTp,String rstrUsgLblDesc)	{
		this.rfMkrNm  = rfMkrNm ;
		this.agmtNo  = agmtNo ;
		this.ceflg  = ceflg ;
		this.minTemp  = minTemp ;
		this.onhDt  = onhDt ;
		this.rfMdlNm  = rfMdlNm ;
		this.pagerows  = pagerows ;
		this.maxTemp  = maxTemp ;
		this.rfMkrSeq  = rfMkrSeq ;
		this.ibflag  = ibflag ;
		this.aeflg  = aeflg ;
		this.eeflg  = eeflg ;
		this.cntrNo  = cntrNo ;
		this.vndrSeq  = vndrSeq ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.beflg  = beflg ;
		this.deflg  = deflg ;
		this.lstmCd  = lstmCd ;
		this.rfRfrNo  = rfRfrNo ;
		this.usrId  = usrId ;
		this.rstrUsgLblNm  = rstrUsgLblNm ;
		this.rfTpCd  = rfTpCd ;
		this.rfHumidCtrlValCd  = rfHumidCtrlValCd ;
		this.rfCmprCtnt  = rfCmprCtnt ;
		this.rstrUsgLblTp  = rstrUsgLblTp ;
		this.rstrUsgLblDesc  = rstrUsgLblDesc ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rf_mkr_nm", getRfMkrNm());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("ceflg", getCeflg());		
		this.hashColumns.put("min_temp", getMinTemp());		
		this.hashColumns.put("onh_dt", getOnhDt());		
		this.hashColumns.put("rf_mdl_nm", getRfMdlNm());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("max_temp", getMaxTemp());		
		this.hashColumns.put("rf_mkr_seq", getRfMkrSeq());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("aeflg", getAeflg());		
		this.hashColumns.put("eeflg", getEeflg());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("beflg", getBeflg());		
		this.hashColumns.put("deflg", getDeflg());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("rf_rfr_no", getRfRfrNo());		
		this.hashColumns.put("usr_id", getUsrId());		
		this.hashColumns.put("rstr_usg_lbl_nm", getRstrUsgLblNm());		
		this.hashColumns.put("rf_tp_cd", getRfTpCd());		
		this.hashColumns.put("rf_humid_ctrl_val_cd", getRfHumidCtrlValCd());		
		this.hashColumns.put("rf_cmpr_ctnt", getRfCmprCtnt());		
		this.hashColumns.put("rstr_usg_lbl_tp", getRstrUsgLblTp());		
		this.hashColumns.put("rstr_usg_lbl_desc", getRstrUsgLblDesc());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("rf_mkr_nm", "rfMkrNm");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("ceflg", "ceflg");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("rf_mdl_nm", "rfMdlNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("rf_mkr_seq", "rfMkrSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aeflg", "aeflg");
		this.hashFields.put("eeflg", "eeflg");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("beflg", "beflg");
		this.hashFields.put("deflg", "deflg");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("rf_rfr_no", "rfRfrNo");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("rstr_usg_lbl_nm", "rstrUsgLblNm");
		this.hashFields.put("rf_tp_cd", "rfTpCd");
		this.hashFields.put("rf_humid_ctrl_val_cd", "rfHumidCtrlValCd");
		this.hashFields.put("rf_cmpr_ctnt", "rfCmprCtnt");
		this.hashFields.put("rstr_usg_lbl_tp", "rstrUsgLblTp");
		this.hashFields.put("rstr_usg_lbl_desc", "rstrUsgLblDesc");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  rfMkrNm
	*/
	public void	setRfMkrNm( String	rfMkrNm ) {
		this.rfMkrNm =	rfMkrNm;
	}
 
	/**
	 * Column Info
	 * @return	rfMkrNm
	 */
	 public	 String	getRfMkrNm() {
		 return	this.rfMkrNm;
	 } 
 	/**
	* Column Info
	* @param  agmtNo
	*/
	public void	setAgmtNo( String	agmtNo ) {
		this.agmtNo =	agmtNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtNo
	 */
	 public	 String	getAgmtNo() {
		 return	this.agmtNo;
	 } 
 	/**
	* Column Info
	* @param  ceflg
	*/
	public void	setCeflg( String	ceflg ) {
		this.ceflg =	ceflg;
	}
 
	/**
	 * Column Info
	 * @return	ceflg
	 */
	 public	 String	getCeflg() {
		 return	this.ceflg;
	 } 
 	/**
	* Column Info
	* @param  minTemp
	*/
	public void	setMinTemp( String	minTemp ) {
		this.minTemp =	minTemp;
	}
 
	/**
	 * Column Info
	 * @return	minTemp
	 */
	 public	 String	getMinTemp() {
		 return	this.minTemp;
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
	* @param  rfMdlNm
	*/
	public void	setRfMdlNm( String	rfMdlNm ) {
		this.rfMdlNm =	rfMdlNm;
	}
 
	/**
	 * Column Info
	 * @return	rfMdlNm
	 */
	 public	 String	getRfMdlNm() {
		 return	this.rfMdlNm;
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
	* @param  maxTemp
	*/
	public void	setMaxTemp( String	maxTemp ) {
		this.maxTemp =	maxTemp;
	}
 
	/**
	 * Column Info
	 * @return	maxTemp
	 */
	 public	 String	getMaxTemp() {
		 return	this.maxTemp;
	 } 
 	/**
	* Column Info
	* @param  rfMkrSeq
	*/
	public void	setRfMkrSeq( String	rfMkrSeq ) {
		this.rfMkrSeq =	rfMkrSeq;
	}
 
	/**
	 * Column Info
	 * @return	rfMkrSeq
	 */
	 public	 String	getRfMkrSeq() {
		 return	this.rfMkrSeq;
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
	* @param  aeflg
	*/
	public void	setAeflg( String	aeflg ) {
		this.aeflg =	aeflg;
	}
 
	/**
	 * Column Info
	 * @return	aeflg
	 */
	 public	 String	getAeflg() {
		 return	this.aeflg;
	 } 
 	/**
	* Column Info
	* @param  eeflg
	*/
	public void	setEeflg( String	eeflg ) {
		this.eeflg =	eeflg;
	}
 
	/**
	 * Column Info
	 * @return	eeflg
	 */
	 public	 String	getEeflg() {
		 return	this.eeflg;
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
	* @param  beflg
	*/
	public void	setBeflg( String	beflg ) {
		this.beflg =	beflg;
	}
 
	/**
	 * Column Info
	 * @return	beflg
	 */
	 public	 String	getBeflg() {
		 return	this.beflg;
	 } 
 	/**
	* Column Info
	* @param  deflg
	*/
	public void	setDeflg( String	deflg ) {
		this.deflg =	deflg;
	}
 
	/**
	 * Column Info
	 * @return	deflg
	 */
	 public	 String	getDeflg() {
		 return	this.deflg;
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
	* @param  rfRfrNo
	*/
	public void	setRfRfrNo( String	rfRfrNo ) {
		this.rfRfrNo =	rfRfrNo;
	}
 
	/**
	 * Column Info
	 * @return	rfRfrNo
	 */
	 public	 String	getRfRfrNo() {
		 return	this.rfRfrNo;
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
	* @param  rstrUsgLblNm
	*/
	public void	setRstrUsgLblNm( String	rstrUsgLblNm ) {
		this.rstrUsgLblNm =	rstrUsgLblNm;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblNm
	 */
	 public	 String	getRstrUsgLblNm() {
		 return	this.rstrUsgLblNm;
	 } 
 	/**
	* Column Info
	* @param  rfTpCd
	*/
	public void	setRfTpCd( String	rfTpCd ) {
		this.rfTpCd =	rfTpCd;
	}
 
	/**
	 * Column Info
	 * @return	rfTpCd
	 */
	 public	 String	getRfTpCd() {
		 return	this.rfTpCd;
	 } 
 	/**
	* Column Info
	* @param  rfHumidCtrlValCd
	*/
	public void	setRfHumidCtrlValCd( String	rfHumidCtrlValCd ) {
		this.rfHumidCtrlValCd =	rfHumidCtrlValCd;
	}
 
	/**
	 * Column Info
	 * @return	rfHumidCtrlValCd
	 */
	 public	 String	getRfHumidCtrlValCd() {
		 return	this.rfHumidCtrlValCd;
	 } 
 	/**
	* Column Info
	* @param  rfCmprCtnt
	*/
	public void	setRfCmprCtnt( String	rfCmprCtnt ) {
		this.rfCmprCtnt =	rfCmprCtnt;
	}
 
	/**
	 * Column Info
	 * @return	rfCmprCtnt
	 */
	 public	 String	getRfCmprCtnt() {
		 return	this.rfCmprCtnt;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblTp
	*/
	public void	setRstrUsgLblTp( String	rstrUsgLblTp ) {
		this.rstrUsgLblTp =	rstrUsgLblTp;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblTp
	 */
	 public	 String	getRstrUsgLblTp() {
		 return	this.rstrUsgLblTp;
	 } 
 	/**
	* Column Info
	* @param  rstrUsgLblDesc
	*/
	public void	setRstrUsgLblDesc( String	rstrUsgLblDesc ) {
		this.rstrUsgLblDesc =	rstrUsgLblDesc;
	}
 
	/**
	 * Column Info
	 * @return	rstrUsgLblDesc
	 */
	 public	 String	getRstrUsgLblDesc() {
		 return	this.rstrUsgLblDesc;
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
		setRfMkrNm(JSPUtil.getParameter(request,	prefix + "rf_mkr_nm", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setCeflg(JSPUtil.getParameter(request,	prefix + "ceflg", ""));
		setMinTemp(JSPUtil.getParameter(request,	prefix + "min_temp", ""));
		setOnhDt(JSPUtil.getParameter(request,	prefix + "onh_dt", ""));
		setRfMdlNm(JSPUtil.getParameter(request,	prefix + "rf_mdl_nm", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setMaxTemp(JSPUtil.getParameter(request,	prefix + "max_temp", ""));
		setRfMkrSeq(JSPUtil.getParameter(request,	prefix + "rf_mkr_seq", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setAeflg(JSPUtil.getParameter(request,	prefix + "aeflg", ""));
		setEeflg(JSPUtil.getParameter(request,	prefix + "eeflg", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setBeflg(JSPUtil.getParameter(request,	prefix + "beflg", ""));
		setDeflg(JSPUtil.getParameter(request,	prefix + "deflg", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setRfRfrNo(JSPUtil.getParameter(request,	prefix + "rf_rfr_no", ""));
		setUsrId(JSPUtil.getParameter(request,	prefix + "usr_id", ""));
		setRstrUsgLblNm(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_nm", ""));
		setRfTpCd(JSPUtil.getParameter(request,	prefix + "rf_tp_cd", ""));
		setRfHumidCtrlValCd(JSPUtil.getParameter(request,	prefix + "rf_humid_ctrl_val_cd", ""));
		setRfCmprCtnt(JSPUtil.getParameter(request,	prefix + "rf_cmpr_ctnt", ""));
		setRstrUsgLblTp(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_tp", ""));
		setRstrUsgLblDesc(JSPUtil.getParameter(request,	prefix + "rstr_usg_lbl_desc", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CntrReeferUnitInfoVO[]
	 */
	public CntrReeferUnitInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CntrReeferUnitInfoVO[]
	 */
	public CntrReeferUnitInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CntrReeferUnitInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] rfMkrNm =	(JSPUtil.getParameter(request, prefix +	"rf_mkr_nm".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] ceflg =	(JSPUtil.getParameter(request, prefix +	"ceflg".trim(),	length));
				String[] minTemp =	(JSPUtil.getParameter(request, prefix +	"min_temp".trim(),	length));
				String[] onhDt =	(JSPUtil.getParameter(request, prefix +	"onh_dt".trim(),	length));
				String[] rfMdlNm =	(JSPUtil.getParameter(request, prefix +	"rf_mdl_nm".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] maxTemp =	(JSPUtil.getParameter(request, prefix +	"max_temp".trim(),	length));
				String[] rfMkrSeq =	(JSPUtil.getParameter(request, prefix +	"rf_mkr_seq".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] aeflg =	(JSPUtil.getParameter(request, prefix +	"aeflg".trim(),	length));
				String[] eeflg =	(JSPUtil.getParameter(request, prefix +	"eeflg".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] beflg =	(JSPUtil.getParameter(request, prefix +	"beflg".trim(),	length));
				String[] deflg =	(JSPUtil.getParameter(request, prefix +	"deflg".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] rfRfrNo =	(JSPUtil.getParameter(request, prefix +	"rf_rfr_no".trim(),	length));
				String[] usrId =	(JSPUtil.getParameter(request, prefix +	"usr_id".trim(),	length));
				String[] rstrUsgLblNm =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_nm".trim(),	length));
				String[] rfTpCd =	(JSPUtil.getParameter(request, prefix +	"rf_tp_cd".trim(),	length));
				String[] rfHumidCtrlValCd =	(JSPUtil.getParameter(request, prefix +	"rf_humid_ctrl_val_cd".trim(),	length));
				String[] rfCmprCtnt =	(JSPUtil.getParameter(request, prefix +	"rf_cmpr_ctnt".trim(),	length));
				String[] rstrUsgLblTp =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_tp".trim(),	length));
				String[] rstrUsgLblDesc =	(JSPUtil.getParameter(request, prefix +	"rstr_usg_lbl_desc".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	CntrReeferUnitInfoVO();
						if ( rfMkrNm[i] !=	null)
						model.setRfMkrNm( rfMkrNm[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( ceflg[i] !=	null)
						model.setCeflg( ceflg[i]);
						if ( minTemp[i] !=	null)
						model.setMinTemp( minTemp[i]);
						if ( onhDt[i] !=	null)
						model.setOnhDt( onhDt[i]);
						if ( rfMdlNm[i] !=	null)
						model.setRfMdlNm( rfMdlNm[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( maxTemp[i] !=	null)
						model.setMaxTemp( maxTemp[i]);
						if ( rfMkrSeq[i] !=	null)
						model.setRfMkrSeq( rfMkrSeq[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( aeflg[i] !=	null)
						model.setAeflg( aeflg[i]);
						if ( eeflg[i] !=	null)
						model.setEeflg( eeflg[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( beflg[i] !=	null)
						model.setBeflg( beflg[i]);
						if ( deflg[i] !=	null)
						model.setDeflg( deflg[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( rfRfrNo[i] !=	null)
						model.setRfRfrNo( rfRfrNo[i]);
						if ( usrId[i] !=	null)
						model.setUsrId( usrId[i]);
						if ( rstrUsgLblNm[i] !=	null)
						model.setRstrUsgLblNm( rstrUsgLblNm[i]);
						if ( rfTpCd[i] !=	null)
						model.setRfTpCd( rfTpCd[i]);
						if ( rfHumidCtrlValCd[i] !=	null)
						model.setRfHumidCtrlValCd( rfHumidCtrlValCd[i]);
						if ( rfCmprCtnt[i] !=	null)
						model.setRfCmprCtnt( rfCmprCtnt[i]);
						if ( rstrUsgLblTp[i] !=	null)
						model.setRstrUsgLblTp( rstrUsgLblTp[i]);
						if ( rstrUsgLblDesc[i] !=	null)
						model.setRstrUsgLblDesc( rstrUsgLblDesc[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getCntrReeferUnitInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CntrReeferUnitInfoVO[]
	 */
	public CntrReeferUnitInfoVO[]	 getCntrReeferUnitInfoVOs(){
		CntrReeferUnitInfoVO[] vos = (CntrReeferUnitInfoVO[])models.toArray(new	CntrReeferUnitInfoVO[models.size()]);
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
		this.rfMkrNm =	this.rfMkrNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ceflg =	this.ceflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp =	this.minTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt =	this.onhDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMdlNm =	this.rfMdlNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp =	this.maxTemp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfMkrSeq =	this.rfMkrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aeflg =	this.aeflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eeflg =	this.eeflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.beflg =	this.beflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deflg =	this.deflg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfRfrNo =	this.rfRfrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId =	this.usrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblNm =	this.rstrUsgLblNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfTpCd =	this.rfTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfHumidCtrlValCd =	this.rfHumidCtrlValCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfCmprCtnt =	this.rfCmprCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblTp =	this.rstrUsgLblTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rstrUsgLblDesc =	this.rstrUsgLblDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}