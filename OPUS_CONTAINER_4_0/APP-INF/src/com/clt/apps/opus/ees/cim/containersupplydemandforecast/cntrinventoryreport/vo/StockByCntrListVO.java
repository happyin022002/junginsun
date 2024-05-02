/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : StockByCntrListVO.java
 *@FileTitle : StockByCntrListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.12.30
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2015.12.30  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cim.containersupplydemandforecast.cntrinventoryreport.vo;

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
public class StockByCntrListVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<StockByCntrListVO>  models =	new	ArrayList<StockByCntrListVO>();


	/*	Column Info	*/
	private  String	 stkEvntDt   =  null;
	/*	Column Info	*/
	private  String	 cnmvDt   =  null;
	/*	Column Info	*/
	private  String	 stkGateIoCd   =  null;
	/*	Column Info	*/
	private  String	 crntYdCd   =  null;
	/*	Column Info	*/
	private  String	 stkYdCd   =  null;
	/*	Column Info	*/
	private  String	 dmgFlg   =  null;
	/*	Column Info	*/
	private  String	 blNo   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 vvd   =  null;
	/*	Column Info	*/
	private  String	 stkJbDt   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 cnmvStsCd   =  null;
	/*	Column Info	*/
	private  String	 bkgNo   =  null;
	/*	Column Info	*/
	private  String	 cntrNo   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 trspSoTpCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 stkOfcCd   =  null;
	/*	Column Info	*/
	private  String	 dmgFlgDt   =  null;
	/*	Column Info	*/
	private  String	 dmgUnflgDt   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public StockByCntrListVO(){}

	public StockByCntrListVO(String stkEvntDt,String cnmvDt,String stkGateIoCd,String crntYdCd,String stkYdCd,String dmgFlg,String blNo,String pagerows,String vvd,String stkJbDt,String locCd,String ibflag,String cnmvStsCd,String bkgNo,String cntrNo,String cntrTpszCd,String lstmCd,String trspSoTpCd,String updUsrId,String stkOfcCd,String dmgFlgDt,String dmgUnflgDt)	{
		this.stkEvntDt  = stkEvntDt ;
		this.cnmvDt  = cnmvDt ;
		this.stkGateIoCd  = stkGateIoCd ;
		this.crntYdCd  = crntYdCd ;
		this.stkYdCd  = stkYdCd ;
		this.dmgFlg  = dmgFlg ;
		this.blNo  = blNo ;
		this.pagerows  = pagerows ;
		this.vvd  = vvd ;
		this.stkJbDt  = stkJbDt ;
		this.locCd  = locCd ;
		this.ibflag  = ibflag ;
		this.cnmvStsCd  = cnmvStsCd ;
		this.bkgNo  = bkgNo ;
		this.cntrNo  = cntrNo ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.lstmCd  = lstmCd ;
		this.trspSoTpCd  = trspSoTpCd ;
		this.updUsrId  = updUsrId ;
		this.stkOfcCd  = stkOfcCd ;
		this.dmgFlgDt  = dmgFlgDt ;
		this.dmgUnflgDt  = dmgUnflgDt ;
	}


	/**
	 * �뚯씠釉�而щ읆����옣��媛믪쓣 Hashtable<"column_name", "value">	濡�諛섑솚
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("stk_evnt_dt", getStkEvntDt());		
		this.hashColumns.put("cnmv_dt", getCnmvDt());		
		this.hashColumns.put("stk_gate_io_cd", getStkGateIoCd());		
		this.hashColumns.put("crnt_yd_cd", getCrntYdCd());		
		this.hashColumns.put("stk_yd_cd", getStkYdCd());		
		this.hashColumns.put("dmg_flg", getDmgFlg());		
		this.hashColumns.put("bl_no", getBlNo());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("vvd", getVvd());		
		this.hashColumns.put("stk_jb_dt", getStkJbDt());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("cnmv_sts_cd", getCnmvStsCd());		
		this.hashColumns.put("bkg_no", getBkgNo());		
		this.hashColumns.put("cntr_no", getCntrNo());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("trsp_so_tp_cd", getTrspSoTpCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("stk_ofc_cd", getStkOfcCd());		
		this.hashColumns.put("dmg_flg_dt", getDmgFlgDt());		
		this.hashColumns.put("dmg_unflg_dt", getDmgUnflgDt());		
		return this.hashColumns;
}

	/**
	 * 而щ읆紐낆뿉	��쓳�섎뒗 硫ㅻ쾭蹂�닔紐낆쓣	��옣�섏뿬 Hashtable<"column_name", "variable"> 濡�諛섑솚
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("stk_evnt_dt", "stkEvntDt");
		this.hashFields.put("cnmv_dt", "cnmvDt");
		this.hashFields.put("stk_gate_io_cd", "stkGateIoCd");
		this.hashFields.put("crnt_yd_cd", "crntYdCd");
		this.hashFields.put("stk_yd_cd", "stkYdCd");
		this.hashFields.put("dmg_flg", "dmgFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("stk_jb_dt", "stkJbDt");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cnmv_sts_cd", "cnmvStsCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("trsp_so_tp_cd", "trspSoTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("stk_ofc_cd", "stkOfcCd");
		this.hashFields.put("dmg_flg_dt", "dmgFlgDt");
		this.hashFields.put("dmg_unflg_dt", "dmgUnflgDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  stkEvntDt
	*/
	public void	setStkEvntDt( String	stkEvntDt ) {
		this.stkEvntDt =	stkEvntDt;
	}
 
	/**
	 * Column Info
	 * @return	stkEvntDt
	 */
	 public	 String	getStkEvntDt() {
		 return	this.stkEvntDt;
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
	* @param  stkGateIoCd
	*/
	public void	setStkGateIoCd( String	stkGateIoCd ) {
		this.stkGateIoCd =	stkGateIoCd;
	}
 
	/**
	 * Column Info
	 * @return	stkGateIoCd
	 */
	 public	 String	getStkGateIoCd() {
		 return	this.stkGateIoCd;
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
	* @param  stkYdCd
	*/
	public void	setStkYdCd( String	stkYdCd ) {
		this.stkYdCd =	stkYdCd;
	}
 
	/**
	 * Column Info
	 * @return	stkYdCd
	 */
	 public	 String	getStkYdCd() {
		 return	this.stkYdCd;
	 } 
 	/**
	* Column Info
	* @param  dmgFlg
	*/
	public void	setDmgFlg( String	dmgFlg ) {
		this.dmgFlg =	dmgFlg;
	}
 
	/**
	 * Column Info
	 * @return	dmgFlg
	 */
	 public	 String	getDmgFlg() {
		 return	this.dmgFlg;
	 } 
 	/**
	* Column Info
	* @param  blNo
	*/
	public void	setBlNo( String	blNo ) {
		this.blNo =	blNo;
	}
 
	/**
	 * Column Info
	 * @return	blNo
	 */
	 public	 String	getBlNo() {
		 return	this.blNo;
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
	* @param  vvd
	*/
	public void	setVvd( String	vvd ) {
		this.vvd =	vvd;
	}
 
	/**
	 * Column Info
	 * @return	vvd
	 */
	 public	 String	getVvd() {
		 return	this.vvd;
	 } 
 	/**
	* Column Info
	* @param  stkJbDt
	*/
	public void	setStkJbDt( String	stkJbDt ) {
		this.stkJbDt =	stkJbDt;
	}
 
	/**
	 * Column Info
	 * @return	stkJbDt
	 */
	 public	 String	getStkJbDt() {
		 return	this.stkJbDt;
	 } 
 	/**
	* Column Info
	* @param  locCd
	*/
	public void	setLocCd( String	locCd ) {
		this.locCd =	locCd;
	}
 
	/**
	 * Column Info
	 * @return	locCd
	 */
	 public	 String	getLocCd() {
		 return	this.locCd;
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
	* @param  bkgNo
	*/
	public void	setBkgNo( String	bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 
	/**
	 * Column Info
	 * @return	bkgNo
	 */
	 public	 String	getBkgNo() {
		 return	this.bkgNo;
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
	* @param  trspSoTpCd
	*/
	public void	setTrspSoTpCd( String	trspSoTpCd ) {
		this.trspSoTpCd =	trspSoTpCd;
	}
 
	/**
	 * Column Info
	 * @return	trspSoTpCd
	 */
	 public	 String	getTrspSoTpCd() {
		 return	this.trspSoTpCd;
	 } 
 	/**
	* Column Info
	* @param  updUsrId
	*/
	public void	setUpdUsrId( String	updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 
	/**
	 * Column Info
	 * @return	updUsrId
	 */
	 public	 String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  stkOfcCd
	*/
	public void	setStkOfcCd( String	stkOfcCd ) {
		this.stkOfcCd =	stkOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	stkOfcCd
	 */
	 public	 String	getStkOfcCd() {
		 return	this.stkOfcCd;
	 } 
 	/**
	* Column Info
	* @param  dmgFlgDt
	*/
	public void	setDmgFlgDt( String	dmgFlgDt ) {
		this.dmgFlgDt =	dmgFlgDt;
	}
 
	/**
	 * Column Info
	 * @return	dmgFlgDt
	 */
	 public	 String	getDmgFlgDt() {
		 return	this.dmgFlgDt;
	 } 
 	/**
	* Column Info
	* @param  dmgUnflgDt
	*/
	public void	setDmgUnflgDt( String	dmgUnflgDt ) {
		this.dmgUnflgDt =	dmgUnflgDt;
	}
 
	/**
	 * Column Info
	 * @return	dmgUnflgDt
	 */
	 public	 String	getDmgUnflgDt() {
		 return	this.dmgUnflgDt;
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
		setStkEvntDt(JSPUtil.getParameter(request,	prefix + "stk_evnt_dt", ""));
		setCnmvDt(JSPUtil.getParameter(request,	prefix + "cnmv_dt", ""));
		setStkGateIoCd(JSPUtil.getParameter(request,	prefix + "stk_gate_io_cd", ""));
		setCrntYdCd(JSPUtil.getParameter(request,	prefix + "crnt_yd_cd", ""));
		setStkYdCd(JSPUtil.getParameter(request,	prefix + "stk_yd_cd", ""));
		setDmgFlg(JSPUtil.getParameter(request,	prefix + "dmg_flg", ""));
		setBlNo(JSPUtil.getParameter(request,	prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request,	prefix + "vvd", ""));
		setStkJbDt(JSPUtil.getParameter(request,	prefix + "stk_jb_dt", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setCnmvStsCd(JSPUtil.getParameter(request,	prefix + "cnmv_sts_cd", ""));
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setTrspSoTpCd(JSPUtil.getParameter(request,	prefix + "trsp_so_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setStkOfcCd(JSPUtil.getParameter(request,	prefix + "stk_ofc_cd", ""));
		setDmgFlgDt(JSPUtil.getParameter(request,	prefix + "dmg_flg_dt", ""));
		setDmgUnflgDt(JSPUtil.getParameter(request,	prefix + "dmg_unflg_dt", ""));
	}
	
	/**
	 * Request ���곗씠�곕� VO 諛곗뿴濡�蹂�솚�섏뿬 諛섑솚.
	 * @param request
	 * @return StockByCntrListVO[]
	 */
	public StockByCntrListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request �섏뼱���щ윭 嫄�DATA瑜�VO Class ���대뒗��
	 * @param request
	 * @param prefix
	 * @return StockByCntrListVO[]
	 */
	public StockByCntrListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		StockByCntrListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] stkEvntDt =	(JSPUtil.getParameter(request, prefix +	"stk_evnt_dt".trim(),	length));
				String[] cnmvDt =	(JSPUtil.getParameter(request, prefix +	"cnmv_dt".trim(),	length));
				String[] stkGateIoCd =	(JSPUtil.getParameter(request, prefix +	"stk_gate_io_cd".trim(),	length));
				String[] crntYdCd =	(JSPUtil.getParameter(request, prefix +	"crnt_yd_cd".trim(),	length));
				String[] stkYdCd =	(JSPUtil.getParameter(request, prefix +	"stk_yd_cd".trim(),	length));
				String[] dmgFlg =	(JSPUtil.getParameter(request, prefix +	"dmg_flg".trim(),	length));
				String[] blNo =	(JSPUtil.getParameter(request, prefix +	"bl_no".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] vvd =	(JSPUtil.getParameter(request, prefix +	"vvd".trim(),	length));
				String[] stkJbDt =	(JSPUtil.getParameter(request, prefix +	"stk_jb_dt".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] cnmvStsCd =	(JSPUtil.getParameter(request, prefix +	"cnmv_sts_cd".trim(),	length));
				String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no".trim(),	length));
				String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] trspSoTpCd =	(JSPUtil.getParameter(request, prefix +	"trsp_so_tp_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] stkOfcCd =	(JSPUtil.getParameter(request, prefix +	"stk_ofc_cd".trim(),	length));
				String[] dmgFlgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_flg_dt".trim(),	length));
				String[] dmgUnflgDt =	(JSPUtil.getParameter(request, prefix +	"dmg_unflg_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	StockByCntrListVO();
						if ( stkEvntDt[i] !=	null)
						model.setStkEvntDt( stkEvntDt[i]);
						if ( cnmvDt[i] !=	null)
						model.setCnmvDt( cnmvDt[i]);
						if ( stkGateIoCd[i] !=	null)
						model.setStkGateIoCd( stkGateIoCd[i]);
						if ( crntYdCd[i] !=	null)
						model.setCrntYdCd( crntYdCd[i]);
						if ( stkYdCd[i] !=	null)
						model.setStkYdCd( stkYdCd[i]);
						if ( dmgFlg[i] !=	null)
						model.setDmgFlg( dmgFlg[i]);
						if ( blNo[i] !=	null)
						model.setBlNo( blNo[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( vvd[i] !=	null)
						model.setVvd( vvd[i]);
						if ( stkJbDt[i] !=	null)
						model.setStkJbDt( stkJbDt[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( cnmvStsCd[i] !=	null)
						model.setCnmvStsCd( cnmvStsCd[i]);
						if ( bkgNo[i] !=	null)
						model.setBkgNo( bkgNo[i]);
						if ( cntrNo[i] !=	null)
						model.setCntrNo( cntrNo[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( trspSoTpCd[i] !=	null)
						model.setTrspSoTpCd( trspSoTpCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( stkOfcCd[i] !=	null)
						model.setStkOfcCd( stkOfcCd[i]);
						if ( dmgFlgDt[i] !=	null)
						model.setDmgFlgDt( dmgFlgDt[i]);
						if ( dmgUnflgDt[i] !=	null)
						model.setDmgUnflgDt( dmgUnflgDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getStockByCntrListVOs();
	}

	/**
	 *  VO 諛곗뿴��諛섑솚
	 * @return StockByCntrListVO[]
	 */
	public StockByCntrListVO[]	 getStockByCntrListVOs(){
		StockByCntrListVO[] vos = (StockByCntrListVO[])models.toArray(new	StockByCntrListVO[models.size()]);
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
		this.stkEvntDt =	this.stkEvntDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvDt =	this.cnmvDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkGateIoCd =	this.stkGateIoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntYdCd =	this.crntYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkYdCd =	this.stkYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlg =	this.dmgFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo =	this.blNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd =	this.vvd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkJbDt =	this.stkJbDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnmvStsCd =	this.cnmvStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspSoTpCd =	this.trspSoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stkOfcCd =	this.stkOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgFlgDt =	this.dmgFlgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dmgUnflgDt =	this.dmgUnflgDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}