/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : BkgEdiGrpCustVO.java
 *@FileTitle : BkgEdiGrpCustVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.06.03
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.06.03  
 * 1.0 Creation
=========================================================*/

package	 com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.vo;

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
public class BkgEdiGrpCustVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<BkgEdiGrpCustVO>  models =	new	ArrayList<BkgEdiGrpCustVO>();


	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 coCd   =  null;
	/*	Column Info	*/
	private  String	 deltFlg   =  null;
	/*	Column Info	*/
	private  String	 esvcGrpCd   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 bkgCfmAutoFlg   =  null;
	/*	Column Info	*/
	private  String	 blDrftAutoFlg   =  null;
	/*	Column Info	*/
	private  String	 blDrftAutoDys   =  null;
	/*	Column Info	*/
	private  String	 custSeq   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 blDrftFlg   =  null;
	/*	Column Info	*/
	private  String	 eaiSts   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 bkgCfmFlg   =  null;
	/*	Column Info	*/
	private  String	 scNo   =  null;
	/*	Column Info	*/
	private  String	 cntCd   =  null;
	/*	Column Info	*/
	private  String	 anFlg   =  null;
	/*	Column Info	*/
	private  String	 bkgCtrtTpCd   =  null;
	/*	Column Info	*/
	private  String	 cgoTrakFlg   =  null;
	/*	Column Info	*/
	private  String	 esvcBlTpCd   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 bkgCustTpDesc   =  null;
	/*	Column Info	*/
	private  String	 blDrftAutoOnceSndFlg   =  null;
	/*	Column Info	*/
	private  String	 ultiNewAsiaCustFlg   =  null;
	/*	Column Info	*/
	private  String	 ultiTrnsCustFlg   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new HashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new HashMap<String, String>();
 
 
	/**	Constructor	*/
	public BkgEdiGrpCustVO(){}

	public BkgEdiGrpCustVO(String updDt,String coCd,String deltFlg,String esvcGrpCd,String creDt,String bkgCfmAutoFlg,String blDrftAutoFlg,String blDrftAutoDys,String custSeq,String pagerows,String blDrftFlg,String eaiSts,String creUsrId,String ibflag,String bkgCfmFlg,String scNo,String cntCd,String anFlg,String bkgCtrtTpCd,String cgoTrakFlg,String esvcBlTpCd,String updUsrId,String bkgCustTpDesc,String blDrftAutoOnceSndFlg,String ultiNewAsiaCustFlg,String ultiTrnsCustFlg)	{
		this.updDt  = updDt ;
		this.coCd  = coCd ;
		this.deltFlg  = deltFlg ;
		this.esvcGrpCd  = esvcGrpCd ;
		this.creDt  = creDt ;
		this.bkgCfmAutoFlg  = bkgCfmAutoFlg ;
		this.blDrftAutoFlg  = blDrftAutoFlg ;
		this.blDrftAutoDys  = blDrftAutoDys ;
		this.custSeq  = custSeq ;
		this.pagerows  = pagerows ;
		this.blDrftFlg  = blDrftFlg ;
		this.eaiSts  = eaiSts ;
		this.creUsrId  = creUsrId ;
		this.ibflag  = ibflag ;
		this.bkgCfmFlg  = bkgCfmFlg ;
		this.scNo  = scNo ;
		this.cntCd  = cntCd ;
		this.anFlg  = anFlg ;
		this.bkgCtrtTpCd  = bkgCtrtTpCd ;
		this.cgoTrakFlg  = cgoTrakFlg ;
		this.esvcBlTpCd  = esvcBlTpCd ;
		this.updUsrId  = updUsrId ;
		this.bkgCustTpDesc  = bkgCustTpDesc ;
		this.blDrftAutoOnceSndFlg  = blDrftAutoOnceSndFlg ;
		this.ultiNewAsiaCustFlg  = ultiNewAsiaCustFlg ;
		this.ultiTrnsCustFlg  = ultiTrnsCustFlg ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("co_cd", getCoCd());		
		this.hashColumns.put("delt_flg", getDeltFlg());		
		this.hashColumns.put("esvc_grp_cd", getEsvcGrpCd());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("bkg_cfm_auto_flg", getBkgCfmAutoFlg());		
		this.hashColumns.put("bl_drft_auto_flg", getBlDrftAutoFlg());		
		this.hashColumns.put("bl_drft_auto_dys", getBlDrftAutoDys());		
		this.hashColumns.put("cust_seq", getCustSeq());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("bl_drft_flg", getBlDrftFlg());		
		this.hashColumns.put("eai_sts", getEaiSts());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("bkg_cfm_flg", getBkgCfmFlg());		
		this.hashColumns.put("sc_no", getScNo());		
		this.hashColumns.put("cnt_cd", getCntCd());		
		this.hashColumns.put("an_flg", getAnFlg());		
		this.hashColumns.put("bkg_ctrt_tp_cd", getBkgCtrtTpCd());		
		this.hashColumns.put("cgo_trak_flg", getCgoTrakFlg());		
		this.hashColumns.put("esvc_bl_tp_cd", getEsvcBlTpCd());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("bkg_cust_tp_desc", getBkgCustTpDesc());		
		this.hashColumns.put("bl_drft_auto_once_snd_flg", getBlDrftAutoOnceSndFlg());		
		this.hashColumns.put("ulti_new_asia_cust_flg", getUltiNewAsiaCustFlg());		
		this.hashColumns.put("ulti_trns_cust_flg", getUltiTrnsCustFlg());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("co_cd", "coCd");
		this.hashFields.put("delt_flg", "deltFlg");
		this.hashFields.put("esvc_grp_cd", "esvcGrpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("bkg_cfm_auto_flg", "bkgCfmAutoFlg");
		this.hashFields.put("bl_drft_auto_flg", "blDrftAutoFlg");
		this.hashFields.put("bl_drft_auto_dys", "blDrftAutoDys");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_drft_flg", "blDrftFlg");
		this.hashFields.put("eai_sts", "eaiSts");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_cfm_flg", "bkgCfmFlg");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("an_flg", "anFlg");
		this.hashFields.put("bkg_ctrt_tp_cd", "bkgCtrtTpCd");
		this.hashFields.put("cgo_trak_flg", "cgoTrakFlg");
		this.hashFields.put("esvc_bl_tp_cd", "esvcBlTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("bkg_cust_tp_desc", "bkgCustTpDesc");
		this.hashFields.put("bl_drft_auto_once_snd_flg", "blDrftAutoOnceSndFlg");
		this.hashFields.put("ulti_new_asia_cust_flg", "ultiNewAsiaCustFlg");
		this.hashFields.put("ulti_trns_cust_flg", "ultiTrnsCustFlg");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  coCd
	*/
	public void	setCoCd( String	coCd ) {
		this.coCd =	coCd;
	}
 
	/**
	 * Column Info
	 * @return	coCd
	 */
	 public	String	getCoCd() {
		 return	this.coCd;
	 } 
 	/**
	* Column Info
	* @param  deltFlg
	*/
	public void	setDeltFlg( String	deltFlg ) {
		this.deltFlg =	deltFlg;
	}
 
	/**
	 * Column Info
	 * @return	deltFlg
	 */
	 public	String	getDeltFlg() {
		 return	this.deltFlg;
	 } 
 	/**
	* Column Info
	* @param  esvcGrpCd
	*/
	public void	setEsvcGrpCd( String	esvcGrpCd ) {
		this.esvcGrpCd =	esvcGrpCd;
	}
 
	/**
	 * Column Info
	 * @return	esvcGrpCd
	 */
	 public	String	getEsvcGrpCd() {
		 return	this.esvcGrpCd;
	 } 
 	/**
	* Column Info
	* @param  creDt
	*/
	public void	setCreDt( String	creDt ) {
		this.creDt =	creDt;
	}
 
	/**
	 * Column Info
	 * @return	creDt
	 */
	 public	String	getCreDt() {
		 return	this.creDt;
	 } 
 	/**
	* Column Info
	* @param  bkgCfmAutoFlg
	*/
	public void	setBkgCfmAutoFlg( String	bkgCfmAutoFlg ) {
		this.bkgCfmAutoFlg =	bkgCfmAutoFlg;
	}
 
	/**
	 * Column Info
	 * @return	bkgCfmAutoFlg
	 */
	 public	String	getBkgCfmAutoFlg() {
		 return	this.bkgCfmAutoFlg;
	 } 
 	/**
	* Column Info
	* @param  blDrftAutoFlg
	*/
	public void	setBlDrftAutoFlg( String	blDrftAutoFlg ) {
		this.blDrftAutoFlg =	blDrftAutoFlg;
	}
 
	/**
	 * Column Info
	 * @return	blDrftAutoFlg
	 */
	 public	String	getBlDrftAutoFlg() {
		 return	this.blDrftAutoFlg;
	 } 
 	/**
	* Column Info
	* @param  blDrftAutoDys
	*/
	public void	setBlDrftAutoDys( String	blDrftAutoDys ) {
		this.blDrftAutoDys =	blDrftAutoDys;
	}
 
	/**
	 * Column Info
	 * @return	blDrftAutoDys
	 */
	 public	String	getBlDrftAutoDys() {
		 return	this.blDrftAutoDys;
	 } 
 	/**
	* Column Info
	* @param  custSeq
	*/
	public void	setCustSeq( String	custSeq ) {
		this.custSeq =	custSeq;
	}
 
	/**
	 * Column Info
	 * @return	custSeq
	 */
	 public	String	getCustSeq() {
		 return	this.custSeq;
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
	* @param  blDrftFlg
	*/
	public void	setBlDrftFlg( String	blDrftFlg ) {
		this.blDrftFlg =	blDrftFlg;
	}
 
	/**
	 * Column Info
	 * @return	blDrftFlg
	 */
	 public	String	getBlDrftFlg() {
		 return	this.blDrftFlg;
	 } 
 	/**
	* Column Info
	* @param  eaiSts
	*/
	public void	setEaiSts( String	eaiSts ) {
		this.eaiSts =	eaiSts;
	}
 
	/**
	 * Column Info
	 * @return	eaiSts
	 */
	 public	String	getEaiSts() {
		 return	this.eaiSts;
	 } 
 	/**
	* Column Info
	* @param  creUsrId
	*/
	public void	setCreUsrId( String	creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 
	/**
	 * Column Info
	 * @return	creUsrId
	 */
	 public	String	getCreUsrId() {
		 return	this.creUsrId;
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
	* @param  bkgCfmFlg
	*/
	public void	setBkgCfmFlg( String	bkgCfmFlg ) {
		this.bkgCfmFlg =	bkgCfmFlg;
	}
 
	/**
	 * Column Info
	 * @return	bkgCfmFlg
	 */
	 public	String	getBkgCfmFlg() {
		 return	this.bkgCfmFlg;
	 } 
 	/**
	* Column Info
	* @param  scNo
	*/
	public void	setScNo( String	scNo ) {
		this.scNo =	scNo;
	}
 
	/**
	 * Column Info
	 * @return	scNo
	 */
	 public	String	getScNo() {
		 return	this.scNo;
	 } 
 	/**
	* Column Info
	* @param  cntCd
	*/
	public void	setCntCd( String	cntCd ) {
		this.cntCd =	cntCd;
	}
 
	/**
	 * Column Info
	 * @return	cntCd
	 */
	 public	String	getCntCd() {
		 return	this.cntCd;
	 } 
 	/**
	* Column Info
	* @param  anFlg
	*/
	public void	setAnFlg( String	anFlg ) {
		this.anFlg =	anFlg;
	}
 
	/**
	 * Column Info
	 * @return	anFlg
	 */
	 public	String	getAnFlg() {
		 return	this.anFlg;
	 } 
 	/**
	* Column Info
	* @param  bkgCtrtTpCd
	*/
	public void	setBkgCtrtTpCd( String	bkgCtrtTpCd ) {
		this.bkgCtrtTpCd =	bkgCtrtTpCd;
	}
 
	/**
	 * Column Info
	 * @return	bkgCtrtTpCd
	 */
	 public	String	getBkgCtrtTpCd() {
		 return	this.bkgCtrtTpCd;
	 } 
 	/**
	* Column Info
	* @param  cgoTrakFlg
	*/
	public void	setCgoTrakFlg( String	cgoTrakFlg ) {
		this.cgoTrakFlg =	cgoTrakFlg;
	}
 
	/**
	 * Column Info
	 * @return	cgoTrakFlg
	 */
	 public	String	getCgoTrakFlg() {
		 return	this.cgoTrakFlg;
	 } 
 	/**
	* Column Info
	* @param  esvcBlTpCd
	*/
	public void	setEsvcBlTpCd( String	esvcBlTpCd ) {
		this.esvcBlTpCd =	esvcBlTpCd;
	}
 
	/**
	 * Column Info
	 * @return	esvcBlTpCd
	 */
	 public	String	getEsvcBlTpCd() {
		 return	this.esvcBlTpCd;
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
	 public	String	getUpdUsrId() {
		 return	this.updUsrId;
	 } 
 	/**
	* Column Info
	* @param  bkgCustTpDesc
	*/
	public void	setBkgCustTpDesc( String	bkgCustTpDesc ) {
		this.bkgCustTpDesc =	bkgCustTpDesc;
	}
 
	/**
	 * Column Info
	 * @return	bkgCustTpDesc
	 */
	 public	String	getBkgCustTpDesc() {
		 return	this.bkgCustTpDesc;
	 } 
 	/**
	* Column Info
	* @param  blDrftAutoOnceSndFlg
	*/
	public void	setBlDrftAutoOnceSndFlg( String	blDrftAutoOnceSndFlg ) {
		this.blDrftAutoOnceSndFlg =	blDrftAutoOnceSndFlg;
	}
 
	/**
	 * Column Info
	 * @return	blDrftAutoOnceSndFlg
	 */
	 public	String	getBlDrftAutoOnceSndFlg() {
		 return	this.blDrftAutoOnceSndFlg;
	 } 
 	/**
	* Column Info
	* @param  ultiNewAsiaCustFlg
	*/
	public void	setUltiNewAsiaCustFlg( String	ultiNewAsiaCustFlg ) {
		this.ultiNewAsiaCustFlg =	ultiNewAsiaCustFlg;
	}
 
	/**
	 * Column Info
	 * @return	ultiNewAsiaCustFlg
	 */
	 public	String	getUltiNewAsiaCustFlg() {
		 return	this.ultiNewAsiaCustFlg;
	 } 
 	/**
	* Column Info
	* @param  ultiTrnsCustFlg
	*/
	public void	setUltiTrnsCustFlg( String	ultiTrnsCustFlg ) {
		this.ultiTrnsCustFlg =	ultiTrnsCustFlg;
	}
 
	/**
	 * Column Info
	 * @return	ultiTrnsCustFlg
	 */
	 public	String	getUltiTrnsCustFlg() {
		 return	this.ultiTrnsCustFlg;
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
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCoCd(JSPUtil.getParameter(request,	prefix + "co_cd", ""));
		setDeltFlg(JSPUtil.getParameter(request,	prefix + "delt_flg", ""));
		setEsvcGrpCd(JSPUtil.getParameter(request,	prefix + "esvc_grp_cd", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setBkgCfmAutoFlg(JSPUtil.getParameter(request,	prefix + "bkg_cfm_auto_flg", ""));
		setBlDrftAutoFlg(JSPUtil.getParameter(request,	prefix + "bl_drft_auto_flg", ""));
		setBlDrftAutoDys(JSPUtil.getParameter(request,	prefix + "bl_drft_auto_dys", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setBlDrftFlg(JSPUtil.getParameter(request,	prefix + "bl_drft_flg", ""));
		setEaiSts(JSPUtil.getParameter(request,	prefix + "eai_sts", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setBkgCfmFlg(JSPUtil.getParameter(request,	prefix + "bkg_cfm_flg", ""));
		setScNo(JSPUtil.getParameter(request,	prefix + "sc_no", ""));
		setCntCd(JSPUtil.getParameter(request,	prefix + "cnt_cd", ""));
		setAnFlg(JSPUtil.getParameter(request,	prefix + "an_flg", ""));
		setBkgCtrtTpCd(JSPUtil.getParameter(request,	prefix + "bkg_ctrt_tp_cd", ""));
		setCgoTrakFlg(JSPUtil.getParameter(request,	prefix + "cgo_trak_flg", ""));
		setEsvcBlTpCd(JSPUtil.getParameter(request,	prefix + "esvc_bl_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setBkgCustTpDesc(JSPUtil.getParameter(request,	prefix + "bkg_cust_tp_desc", ""));
		setBlDrftAutoOnceSndFlg(JSPUtil.getParameter(request,	prefix + "bl_drft_auto_once_snd_flg", ""));
		setUltiNewAsiaCustFlg(JSPUtil.getParameter(request,	prefix + "ulti_new_asia_cust_flg", ""));
		setUltiTrnsCustFlg(JSPUtil.getParameter(request,	prefix + "ulti_trns_cust_flg", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgEdiGrpCustVO[]
	 */
	public BkgEdiGrpCustVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return BkgEdiGrpCustVO[]
	 */
	public BkgEdiGrpCustVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		BkgEdiGrpCustVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] coCd =	(JSPUtil.getParameter(request, prefix +	"co_cd".trim(),	length));
				String[] deltFlg =	(JSPUtil.getParameter(request, prefix +	"delt_flg".trim(),	length));
				String[] esvcGrpCd =	(JSPUtil.getParameter(request, prefix +	"esvc_grp_cd".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] bkgCfmAutoFlg =	(JSPUtil.getParameter(request, prefix +	"bkg_cfm_auto_flg".trim(),	length));
				String[] blDrftAutoFlg =	(JSPUtil.getParameter(request, prefix +	"bl_drft_auto_flg".trim(),	length));
				String[] blDrftAutoDys =	(JSPUtil.getParameter(request, prefix +	"bl_drft_auto_dys".trim(),	length));
				String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] blDrftFlg =	(JSPUtil.getParameter(request, prefix +	"bl_drft_flg".trim(),	length));
				String[] eaiSts =	(JSPUtil.getParameter(request, prefix +	"eai_sts".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] bkgCfmFlg =	(JSPUtil.getParameter(request, prefix +	"bkg_cfm_flg".trim(),	length));
				String[] scNo =	(JSPUtil.getParameter(request, prefix +	"sc_no".trim(),	length));
				String[] cntCd =	(JSPUtil.getParameter(request, prefix +	"cnt_cd".trim(),	length));
				String[] anFlg =	(JSPUtil.getParameter(request, prefix +	"an_flg".trim(),	length));
				String[] bkgCtrtTpCd =	(JSPUtil.getParameter(request, prefix +	"bkg_ctrt_tp_cd".trim(),	length));
				String[] cgoTrakFlg =	(JSPUtil.getParameter(request, prefix +	"cgo_trak_flg".trim(),	length));
				String[] esvcBlTpCd =	(JSPUtil.getParameter(request, prefix +	"esvc_bl_tp_cd".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] bkgCustTpDesc =	(JSPUtil.getParameter(request, prefix +	"bkg_cust_tp_desc".trim(),	length));
				String[] blDrftAutoOnceSndFlg =	(JSPUtil.getParameter(request, prefix +	"bl_drft_auto_once_snd_flg".trim(),	length));
				String[] ultiNewAsiaCustFlg =	(JSPUtil.getParameter(request, prefix +	"ulti_new_asia_cust_flg".trim(),	length));
				String[] ultiTrnsCustFlg =	(JSPUtil.getParameter(request, prefix +	"ulti_trns_cust_flg".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	BkgEdiGrpCustVO();
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( coCd[i] !=	null)
						model.setCoCd( coCd[i]);
						if ( deltFlg[i] !=	null)
						model.setDeltFlg( deltFlg[i]);
						if ( esvcGrpCd[i] !=	null)
						model.setEsvcGrpCd( esvcGrpCd[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( bkgCfmAutoFlg[i] !=	null)
						model.setBkgCfmAutoFlg( bkgCfmAutoFlg[i]);
						if ( blDrftAutoFlg[i] !=	null)
						model.setBlDrftAutoFlg( blDrftAutoFlg[i]);
						if ( blDrftAutoDys[i] !=	null)
						model.setBlDrftAutoDys( blDrftAutoDys[i]);
						if ( custSeq[i] !=	null)
						model.setCustSeq( custSeq[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( blDrftFlg[i] !=	null)
						model.setBlDrftFlg( blDrftFlg[i]);
						if ( eaiSts[i] !=	null)
						model.setEaiSts( eaiSts[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( bkgCfmFlg[i] !=	null)
						model.setBkgCfmFlg( bkgCfmFlg[i]);
						if ( scNo[i] !=	null)
						model.setScNo( scNo[i]);
						if ( cntCd[i] !=	null)
						model.setCntCd( cntCd[i]);
						if ( anFlg[i] !=	null)
						model.setAnFlg( anFlg[i]);
						if ( bkgCtrtTpCd[i] !=	null)
						model.setBkgCtrtTpCd( bkgCtrtTpCd[i]);
						if ( cgoTrakFlg[i] !=	null)
						model.setCgoTrakFlg( cgoTrakFlg[i]);
						if ( esvcBlTpCd[i] !=	null)
						model.setEsvcBlTpCd( esvcBlTpCd[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( bkgCustTpDesc[i] !=	null)
						model.setBkgCustTpDesc( bkgCustTpDesc[i]);
						if ( blDrftAutoOnceSndFlg[i] !=	null)
						model.setBlDrftAutoOnceSndFlg( blDrftAutoOnceSndFlg[i]);
						if ( ultiNewAsiaCustFlg[i] !=	null)
						model.setUltiNewAsiaCustFlg( ultiNewAsiaCustFlg[i]);
						if ( ultiTrnsCustFlg[i] !=	null)
						model.setUltiTrnsCustFlg( ultiTrnsCustFlg[i]);
					models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getBkgEdiGrpCustVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return BkgEdiGrpCustVO[]
	 */
	public BkgEdiGrpCustVO[]	 getBkgEdiGrpCustVOs(){
		BkgEdiGrpCustVO[] vos = (BkgEdiGrpCustVO[])models.toArray(new	BkgEdiGrpCustVO[models.size()]);
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
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coCd =	this.coCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deltFlg =	this.deltFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcGrpCd =	this.esvcGrpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCfmAutoFlg =	this.bkgCfmAutoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftAutoFlg =	this.blDrftAutoFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftAutoDys =	this.blDrftAutoDys.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftFlg =	this.blDrftFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eaiSts =	this.eaiSts.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCfmFlg =	this.bkgCfmFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo =	this.scNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd =	this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.anFlg =	this.anFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCtrtTpCd =	this.bkgCtrtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTrakFlg =	this.cgoTrakFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.esvcBlTpCd =	this.esvcBlTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCustTpDesc =	this.bkgCustTpDesc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blDrftAutoOnceSndFlg =	this.blDrftAutoOnceSndFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ultiNewAsiaCustFlg =	this.ultiNewAsiaCustFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ultiTrnsCustFlg =	this.ultiTrnsCustFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}