/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AvailableOffHireRegisterVO.java
 *@FileTitle : AvailableOffHireRegisterVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.20
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2016.05.20  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.lse.containerleasemgt.availableoffhire.vo;

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
 * - 
 * 
 * @author 
 * @since J2EE 1.6
 * @see	..
 */
public class AvailableOffHireRegisterVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<AvailableOffHireRegisterVO>  models =	new	ArrayList<AvailableOffHireRegisterVO>();


	/*	Column Info	*/
	private  String	 agmtCtyCd   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 cntrTpszCd   =  null;
	/*	Column Info	*/
	private  String	 eqLocTpCd   =  null;
	/*	Column Info	*/
	private  String	 locCd   =  null;
	/*	Column Info	*/
	private  String	 genRmk   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 ctrtNo   =  null;
	/*	Column Info	*/
	private  String	 lstmCd   =  null;
	/*	Column Info	*/
	private  String	 oldAgmtNo   =  null;
	/*	Column Info	*/
	private  String	 lessor   =  null;
	/*	Column Info	*/
	private  String	 slbFlg   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 useFlg   =  null;
	/*	Column Info	*/
	private  String	 ibFlag   =  null;
	/* Column Info */
	private String 	vndrSeq = null;
	/* Column Info */
	private String 	remain = null;
	/* Column Info */
	private String fullLocTpCd = null;
	/*	Column Info	*/
	private  String	 eqLocTpNm   =  null;
	/*	Column Info	*/
	private  String	 remQty   =  null; 
	/*	Column Info	*/
	private  String	 locNm   =  null; 
	/*	Column Info	*/
	private  String	 offhFmDt   =  null; 
	/*	Column Info	*/
	private  String	 offhToDt   =  null; 
    
	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public AvailableOffHireRegisterVO(){}

	public AvailableOffHireRegisterVO(String agmtCtyCd,String agmtSeq,String cntrTpszCd,String eqLocTpCd,String locCd,String genRmk,String creUsrId,String creDt,String updUsrId,String updDt,String ctrtNo,String lstmCd,String oldAgmtNo,String lessor,String slbFlg,String agmtNo,String useFlg,String ibFlag,String vndrSeq,String remain,String fullLocTpCd,String eqLocTpNm,String remQty,String locNm,String offhFmDt,String offhToDt)	{
		this.agmtCtyCd  = agmtCtyCd ;
		this.agmtSeq  = agmtSeq ;
		this.cntrTpszCd  = cntrTpszCd ;
		this.eqLocTpCd  = eqLocTpCd ;
		this.locCd  = locCd ;
		this.genRmk  = genRmk ;
		this.creUsrId  = creUsrId ;
		this.creDt  = creDt ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.ctrtNo  = ctrtNo ;
		this.lstmCd  = lstmCd ;
		this.oldAgmtNo  = oldAgmtNo ;
		this.lessor  = lessor ;
		this.slbFlg  = slbFlg ;
		this.agmtNo  = agmtNo ;
		this.useFlg  = useFlg ;
		this.ibFlag  = ibFlag ;
		this.vndrSeq  = vndrSeq ;
		this.remain  = remain ;
		this.fullLocTpCd  = fullLocTpCd ;
		this.eqLocTpNm  = eqLocTpNm ;
		this.remQty  = remQty ;
		this.locNm  = locNm ;
		this.offhFmDt  = offhFmDt ;
		this.offhToDt  = offhToDt ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("agmt_cty_cd", getAgmtCtyCd());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());		
		this.hashColumns.put("eq_loc_tp_cd", getEqLocTpCd());		
		this.hashColumns.put("loc_cd", getLocCd());		
		this.hashColumns.put("gen_rmk", getGenRmk());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("ctrt_no", getCtrtNo());		
		this.hashColumns.put("lstm_cd", getLstmCd());		
		this.hashColumns.put("old_agmt_no", getOldAgmtNo());		
		this.hashColumns.put("lessor_cd", getLessor());		
		this.hashColumns.put("slb_flg", getSlbFlg());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("use_flg", getUseFlg());		
		this.hashColumns.put("ib_flag", getIbFlag());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("remain", getRemain());
		this.hashColumns.put("full_loc_tp_cd", getFullLocTpCd());
		this.hashColumns.put("eq_loc_tp_nm", getEqLocTpNm());
		this.hashColumns.put("rem_qty", getRemQty());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("offh_fm_dt", getOffhFmDt());
		this.hashColumns.put("offh_to_dt", getOffhToDt());
		return this.hashColumns;
}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("agmt_cty_cd", "agmtCtyCd");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("eq_loc_tp_cd", "eqLocTpCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("gen_rmk", "genRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ctrt_no", "ctrtNo");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		this.hashFields.put("lessor_cd", "lessor");
		this.hashFields.put("slb_flg", "slbFlg");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("use_flg", "useFlg");
		this.hashFields.put("ib_flag", "ibFlag");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("remain", "remain");
		this.hashFields.put("full_loc_tp_cd", "fullLocTpCd");
		this.hashFields.put("eq_loc_tp_nm", "eqLocTpNm");
		this.hashFields.put("rem_qty", "remQty");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("offh_fm_dt", "offhFmDt");
		this.hashFields.put("offh_to_dt", "offhToDt");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
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
	* @param  eqLocTpCd
	*/
	public void	setEqLocTpCd( String	eqLocTpCd ) {
		this.eqLocTpCd =	eqLocTpCd;
	}
 
	/**
	 * Column Info
	 * @return	eqLocTpCd
	 */
	 public	 String	getEqLocTpCd() {
		 return	this.eqLocTpCd;
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
	* @param  genRmk
	*/
	public void	setGenRmk( String	genRmk ) {
		this.genRmk =	genRmk;
	}
 
	/**
	 * Column Info
	 * @return	genRmk
	 */
	 public	 String	getGenRmk() {
		 return	this.genRmk;
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
	 public	 String	getCreUsrId() {
		 return	this.creUsrId;
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
	 public	 String	getCreDt() {
		 return	this.creDt;
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
	* @param  updDt
	*/
	public void	setUpdDt( String	updDt ) {
		this.updDt =	updDt;
	}
 
	/**
	 * Column Info
	 * @return	updDt
	 */
	 public	 String	getUpdDt() {
		 return	this.updDt;
	 } 
 	/**
	* Column Info
	* @param  ctrtNo
	*/
	public void	setCtrtNo( String	ctrtNo ) {
		this.ctrtNo =	ctrtNo;
	}
 
	/**
	 * Column Info
	 * @return	ctrtNo
	 */
	 public	 String	getCtrtNo() {
		 return	this.ctrtNo;
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
	* @param  oldAgmtNo
	*/
	public void	setOldAgmtNo( String	oldAgmtNo ) {
		this.oldAgmtNo =	oldAgmtNo;
	}
 
	/**
	 * Column Info
	 * @return	oldAgmtNo
	 */
	 public	 String	getOldAgmtNo() {
		 return	this.oldAgmtNo;
	 } 
 	/**
	* Column Info
	* @param  lessor
	*/
	public void	setLessor( String	lessor ) {
		this.lessor =	lessor;
	}
 
	/**
	 * Column Info
	 * @return	lessor
	 */
	 public	 String	getLessor() {
		 return	this.lessor;
	 } 
 	/**
	* Column Info
	* @param  slbFlg
	*/
	public void	setSlbFlg( String	slbFlg ) {
		this.slbFlg =	slbFlg;
	}
 
	/**
	 * Column Info
	 * @return	slbFlg
	 */
	 public	 String	getSlbFlg() {
		 return	this.slbFlg;
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
	* @param  useFlg
	*/
	public void	setUseFlg( String	useFlg ) {
		this.useFlg =	useFlg;
	}
 
	/**
	 * Column Info
	 * @return	useFlg
	 */
	 public	 String	getUseFlg() {
		 return	this.useFlg;
	 } 
 	/**
	* Column Info
	* @param  ibFlag
	*/
	public void	setIbFlag( String	ibFlag ) {
		this.ibFlag =	ibFlag;
	}
 
	/**
	 * Column Info
	 * @return	ibFlag
	 */
	 public	 String	getIbFlag() {
		 return	this.ibFlag;
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
	* @param  remain
	*/
	public void	setRemain( String	remain ) {
		this.remain =	remain;
	}
 
	/**
	 * Column Info
	 * @return	remain
	 */
	 public	 String	getRemain() {
		 return	this.remain;
	 } 
	 
	 /**
	* Column Info
	* @param  fullLocTpCd
	*/
	public void	setFullLocTpCd( String	fullLocTpCd ) {
		this.fullLocTpCd =	fullLocTpCd;
	}
 
	/**
	 * Column Info
	 * @return	fullLocTpCd
	 */
	 public	 String	getFullLocTpCd() {
		 return	this.fullLocTpCd;
	 } 
	 
	 /**
	* Column Info
	* @param  eqLocTpNm
	*/
	public void	setEqLocTpNm( String	eqLocTpNm ) {
		this.eqLocTpNm =	eqLocTpNm;
	}
 
	/**
	 * Column Info
	 * @return	eqLocTpNm
	 */
	 public	 String	getEqLocTpNm() {
		 return	this.eqLocTpNm;
	 } 
	 
	 /**
	* Column Info
	* @param  remQty
	*/
	public void	setRemQty( String	remQty ) {
		this.remQty =	remQty;
	}
 
	/**
	 * Column Info
	 * @return	remQty
	 */
	 public	 String	getRemQty() {
		 return	this.remQty;
	 } 
	 
	/**
	* Column Info
	* @param  locNm
	*/
	public void	setLocNm( String	locNm ) {
		this.locNm =	locNm;
	}
 
	/**
	 * Column Info
	 * @return	locNm
	 */
	 public	 String	getLocNm() {
		 return	this.locNm;
	 }
	 
	 /**
	  * Column Info
	  * @param  offhFmDt
	  */
	 public void	setOffhFmDt( String	offhFmDt ) {
	 	this.offhFmDt =	offhFmDt;
	 }
	
	/**
	 * Column Info
	 * @return	offhFmDt
	 */
	 public	 String	getOffhFmDt() {
		 return	this.offhFmDt;
	 }
	 
	 /**
	  * Column Info
	  * @param  offhToDt
	  */
	 public void	setOffhToDt( String	offhToDt ) {
	 	this.offhToDt =	offhToDt;
	 }
	
	/**
	 * Column Info
	 * @return	offhToDt
	 */
	 public	 String	getOffhToDt() {
		 return	this.offhToDt;
	 }

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request)	{
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void	fromRequest(HttpServletRequest request,	String prefix) {
		setAgmtCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_cty_cd", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setCntrTpszCd(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd", ""));
		setEqLocTpCd(JSPUtil.getParameter(request,	prefix + "eq_loc_tp_cd", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setGenRmk(JSPUtil.getParameter(request,	prefix + "gen_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setCtrtNo(JSPUtil.getParameter(request,	prefix + "ctrt_no", ""));
		setLstmCd(JSPUtil.getParameter(request,	prefix + "lstm_cd", ""));
		setOldAgmtNo(JSPUtil.getParameter(request,	prefix + "old_agmt_no", ""));
		setLessor(JSPUtil.getParameter(request,	prefix + "lessor_cd", ""));
		setSlbFlg(JSPUtil.getParameter(request,	prefix + "slb_flg", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setUseFlg(JSPUtil.getParameter(request,	prefix + "use_flg", ""));
		setIbFlag(JSPUtil.getParameter(request,	prefix + "ib_flag", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setRemain(JSPUtil.getParameter(request,	prefix + "remain", ""));
		setFullLocTpCd(JSPUtil.getParameter(request,	prefix + "full_loc_tp_cd", ""));
		setEqLocTpNm(JSPUtil.getParameter(request,	prefix + "eq_loc_tp_nm", ""));
		setRemQty(JSPUtil.getParameter(request,	prefix + "rem_qty", ""));
		setLocNm(JSPUtil.getParameter(request,	prefix + "loc_nm", ""));
		setOffhFmDt(JSPUtil.getParameter(request,	prefix + "offh_fm_dt", ""));
		setOffhToDt(JSPUtil.getParameter(request,	prefix + "offh_to_dt", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return AvailableOffHireRegisterVO[]
	 */
	public AvailableOffHireRegisterVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return AvailableOffHireRegisterVO[]
	 */
	public AvailableOffHireRegisterVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		AvailableOffHireRegisterVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] agmtCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_cty_cd".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] cntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd".trim(),	length));
				String[] eqLocTpCd =	(JSPUtil.getParameter(request, prefix +	"eq_loc_tp_cd".trim(),	length));
				String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd".trim(),	length));
				String[] genRmk =	(JSPUtil.getParameter(request, prefix +	"gen_rmk".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] ctrtNo =	(JSPUtil.getParameter(request, prefix +	"ctrt_no".trim(),	length));
				String[] lstmCd =	(JSPUtil.getParameter(request, prefix +	"lstm_cd".trim(),	length));
				String[] oldAgmtNo =	(JSPUtil.getParameter(request, prefix +	"old_agmt_no".trim(),	length));
				String[] lessor =	(JSPUtil.getParameter(request, prefix +	"lessor_cd".trim(),	length));
				String[] slbFlg =	(JSPUtil.getParameter(request, prefix +	"slb_flg".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] useFlg =	(JSPUtil.getParameter(request, prefix +	"use_flg".trim(),	length));
				String[] ibFlag =	(JSPUtil.getParameter(request, prefix +	"ib_flag".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] remain =	(JSPUtil.getParameter(request, prefix +	"remain".trim(),	length));
				String[] fullLocTpCd =	(JSPUtil.getParameter(request, prefix +	"full_loc_tp_cd".trim(),	length));
				String[] eqLocTpNm =	(JSPUtil.getParameter(request, prefix +	"eq_loc_tp_nm".trim(),	length));
				String[] remQty =	(JSPUtil.getParameter(request, prefix +	"rem_qty".trim(),	length));
				String[] locNm =	(JSPUtil.getParameter(request, prefix +	"loc_nm".trim(),	length));
				String[] offhFmDt =	(JSPUtil.getParameter(request, prefix +	"offh_fm_dt".trim(),	length));
				String[] offhToDt =	(JSPUtil.getParameter(request, prefix +	"offh_to_dt".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	AvailableOffHireRegisterVO();
						if ( agmtCtyCd[i] !=	null)
						model.setAgmtCtyCd( agmtCtyCd[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( cntrTpszCd[i] !=	null)
						model.setCntrTpszCd( cntrTpszCd[i]);
						if ( eqLocTpCd[i] !=	null)
						model.setEqLocTpCd( eqLocTpCd[i]);
						if ( locCd[i] !=	null)
						model.setLocCd( locCd[i]);
						if ( genRmk[i] !=	null)
						model.setGenRmk( genRmk[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( ctrtNo[i] !=	null)
						model.setCtrtNo( ctrtNo[i]);
						if ( lstmCd[i] !=	null)
						model.setLstmCd( lstmCd[i]);
						if ( oldAgmtNo[i] !=	null)
						model.setOldAgmtNo( oldAgmtNo[i]);
						if ( lessor[i] !=	null)
						model.setLessor( lessor[i]);
						if ( slbFlg[i] !=	null)
						model.setSlbFlg( slbFlg[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( useFlg[i] !=	null)
						model.setUseFlg( useFlg[i]);
						if ( ibFlag[i] !=	null)
						model.setIbFlag( ibFlag[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( remain[i] !=	null)
						model.setRemain( remain[i]);
						if ( fullLocTpCd[i] !=	null)
						model.setFullLocTpCd( fullLocTpCd[i]);
						if ( eqLocTpNm[i] !=	null)
						model.setEqLocTpNm( eqLocTpNm[i]);
						if ( remQty[i] !=	null)
						model.setRemQty( remQty[i]);
						if ( locNm[i] !=	null)
						model.setLocNm( locNm[i]);
						if ( offhFmDt[i] !=	null)
						model.setOffhFmDt( offhFmDt[i]);
						if ( offhToDt[i] !=	null)
						model.setOffhToDt( offhToDt[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getAvailableOffHireRegisterVOs();
	}

	
	/**
	 *  VO 배열을 반환
	 * @return AvailableOffHireRegisterVO[]
	 */
	public AvailableOffHireRegisterVO[]	 getAvailableOffHireRegisterVOs(){
		AvailableOffHireRegisterVO[] vos = (AvailableOffHireRegisterVO[])models.toArray(new	AvailableOffHireRegisterVO[models.size()]);
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
		this.agmtCtyCd =	this.agmtCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd =	this.cntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocTpCd =	this.eqLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genRmk =	this.genRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtNo =	this.ctrtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd =	this.lstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo =	this.oldAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lessor =	this.lessor.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slbFlg =	this.slbFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.useFlg =	this.useFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFlag =	this.ibFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remain =	this.remain.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fullLocTpCd =	this.fullLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqLocTpNm =	this.eqLocTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.remQty =	this.remQty.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm =	this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhFmDt =	this.offhFmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.offhToDt =	this.offhToDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}