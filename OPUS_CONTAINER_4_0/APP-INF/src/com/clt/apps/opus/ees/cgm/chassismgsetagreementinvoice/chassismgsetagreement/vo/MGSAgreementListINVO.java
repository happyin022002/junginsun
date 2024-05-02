/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : MGSAgreementListINVO.java
 *@FileTitle : MGSAgreementListINVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.23
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.12.23  
 * 1.0 Creation
=========================================================*/

package	 com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo;

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
public class MGSAgreementListINVO	extends	 AbstractValueObject
{

	private	 static final long serialVersionUID = 1L;

	private	 Collection<MGSAgreementListINVO>  models =	new	ArrayList<MGSAgreementListINVO>();


	/*	Column Info	*/
	private  String	 lstVerFlg   =  null;
	/*	Column Info	*/
	private  String	 vndrLglEngNm   =  null;
	/*	Column Info	*/
	private  String	 agmtDt   =  null;
	/*	Column Info	*/
	private  String	 creDt   =  null;
	/*	Column Info	*/
	private  String	 effFlag   =  null;
	/*	Column Info	*/
	private  String	 pagerows   =  null;
	/*	Column Info	*/
	private  String	 agmtIssOfcCd   =  null;
	/*	Column Info	*/
	private  String	 ibflag   =  null;
	/*	Column Info	*/
	private  String	 effDt   =  null;
	/*	Column Info	*/
	private  String	 agmtDtTo   =  null;
	/*	Column Info	*/
	private  String	 expDt   =  null;
	/*	Column Info	*/
	private  String	 effectiveDate   =  null;
	/*	Column Info	*/
	private  String	 updUsrId   =  null;
	/*	Column Info	*/
	private  String	 updDt   =  null;
	/*	Column Info	*/
	private  String	 agmtRefNo   =  null;
	/*	Column Info	*/
	private  String	 agmtSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtNo   =  null;
	/*	Column Info	*/
	private  String	 agmtLstmCd   =  null;
	/*	Column Info	*/
	private  String	 eqKndCd   =  null;
	/*	Column Info	*/
	private  String	 creUsrId   =  null;
	/*	Column Info	*/
	private  String	 agmtDtFr   =  null;
	/*	Column Info	*/
	private  String	 vndrSeq   =  null;
	/*	Column Info	*/
	private  String	 agmtOfcCtyCd   =  null;
	/*	Column Info	*/
	private  String	 seq   =  null;
	/*	Column Info	*/
	private  String	 agmtVerNo   =  null;
	/*	Column Info	*/
	private  String	 oldAgmtNo   =  null;

	/* hashColumnInpo */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/* hashFildInpo	*/
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();
 
 
	/**	Constructor	*/
	public MGSAgreementListINVO(){}

	public MGSAgreementListINVO(String lstVerFlg,String vndrLglEngNm,String agmtDt,String creDt,String effFlag,String pagerows,String agmtIssOfcCd,String ibflag,String effDt,String agmtDtTo,String expDt,String effectiveDate,String updUsrId,String updDt,String agmtRefNo,String agmtSeq,String agmtNo,String agmtLstmCd,String eqKndCd,String creUsrId,String agmtDtFr,String vndrSeq,String agmtOfcCtyCd,String seq,String agmtVerNo,String oldAgmtNo)	{
		this.lstVerFlg  = lstVerFlg ;
		this.vndrLglEngNm  = vndrLglEngNm ;
		this.agmtDt  = agmtDt ;
		this.creDt  = creDt ;
		this.effFlag  = effFlag ;
		this.pagerows  = pagerows ;
		this.agmtIssOfcCd  = agmtIssOfcCd ;
		this.ibflag  = ibflag ;
		this.effDt  = effDt ;
		this.agmtDtTo  = agmtDtTo ;
		this.expDt  = expDt ;
		this.effectiveDate  = effectiveDate ;
		this.updUsrId  = updUsrId ;
		this.updDt  = updDt ;
		this.agmtRefNo  = agmtRefNo ;
		this.agmtSeq  = agmtSeq ;
		this.agmtNo  = agmtNo ;
		this.agmtLstmCd  = agmtLstmCd ;
		this.eqKndCd  = eqKndCd ;
		this.creUsrId  = creUsrId ;
		this.agmtDtFr  = agmtDtFr ;
		this.vndrSeq  = vndrSeq ;
		this.agmtOfcCtyCd  = agmtOfcCtyCd ;
		this.seq  = seq ;
		this.agmtVerNo  = agmtVerNo ;
		this.oldAgmtNo  = oldAgmtNo ;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lst_ver_flg", getLstVerFlg());		
		this.hashColumns.put("vndr_lgl_eng_nm", getVndrLglEngNm());		
		this.hashColumns.put("agmt_dt", getAgmtDt());		
		this.hashColumns.put("cre_dt", getCreDt());		
		this.hashColumns.put("eff_flag", getEffFlag());		
		this.hashColumns.put("pagerows", getPagerows());		
		this.hashColumns.put("agmt_iss_ofc_cd", getAgmtIssOfcCd());		
		this.hashColumns.put("ibflag", getIbflag());		
		this.hashColumns.put("eff_dt", getEffDt());		
		this.hashColumns.put("agmt_dt_to", getAgmtDtTo());		
		this.hashColumns.put("exp_dt", getExpDt());		
		this.hashColumns.put("effective_date", getEffectiveDate());		
		this.hashColumns.put("upd_usr_id", getUpdUsrId());		
		this.hashColumns.put("upd_dt", getUpdDt());		
		this.hashColumns.put("agmt_ref_no", getAgmtRefNo());		
		this.hashColumns.put("agmt_seq", getAgmtSeq());		
		this.hashColumns.put("agmt_no", getAgmtNo());		
		this.hashColumns.put("agmt_lstm_cd", getAgmtLstmCd());		
		this.hashColumns.put("eq_knd_cd", getEqKndCd());		
		this.hashColumns.put("cre_usr_id", getCreUsrId());		
		this.hashColumns.put("agmt_dt_fr", getAgmtDtFr());		
		this.hashColumns.put("vndr_seq", getVndrSeq());		
		this.hashColumns.put("agmt_ofc_cty_cd", getAgmtOfcCtyCd());		
		this.hashColumns.put("seq", getSeq());		
		this.hashColumns.put("agmt_ver_no", getAgmtVerNo());		
		this.hashColumns.put("old_agmt_no", getOldAgmtNo());		
		return this.hashColumns;
}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("lst_ver_flg", "lstVerFlg");
		this.hashFields.put("vndr_lgl_eng_nm", "vndrLglEngNm");
		this.hashFields.put("agmt_dt", "agmtDt");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("eff_flag", "effFlag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("agmt_iss_ofc_cd", "agmtIssOfcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("agmt_dt_to", "agmtDtTo");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("effective_date", "effectiveDate");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("agmt_ref_no", "agmtRefNo");
		this.hashFields.put("agmt_seq", "agmtSeq");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("agmt_lstm_cd", "agmtLstmCd");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("agmt_dt_fr", "agmtDtFr");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("agmt_ofc_cty_cd", "agmtOfcCtyCd");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("agmt_ver_no", "agmtVerNo");
		this.hashFields.put("old_agmt_no", "oldAgmtNo");
		return this.hashFields;
}
	
	
	
 //	Getters	and	Setters
 	/**
	* Column Info
	* @param  lstVerFlg
	*/
	public void	setLstVerFlg( String	lstVerFlg ) {
		this.lstVerFlg =	lstVerFlg;
	}
 
	/**
	 * Column Info
	 * @return	lstVerFlg
	 */
	 public	 String	getLstVerFlg() {
		 return	this.lstVerFlg;
	 } 
 	/**
	* Column Info
	* @param  vndrLglEngNm
	*/
	public void	setVndrLglEngNm( String	vndrLglEngNm ) {
		this.vndrLglEngNm =	vndrLglEngNm;
	}
 
	/**
	 * Column Info
	 * @return	vndrLglEngNm
	 */
	 public	 String	getVndrLglEngNm() {
		 return	this.vndrLglEngNm;
	 } 
 	/**
	* Column Info
	* @param  agmtDt
	*/
	public void	setAgmtDt( String	agmtDt ) {
		this.agmtDt =	agmtDt;
	}
 
	/**
	 * Column Info
	 * @return	agmtDt
	 */
	 public	 String	getAgmtDt() {
		 return	this.agmtDt;
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
	* @param  effFlag
	*/
	public void	setEffFlag( String	effFlag ) {
		this.effFlag =	effFlag;
	}
 
	/**
	 * Column Info
	 * @return	effFlag
	 */
	 public	 String	getEffFlag() {
		 return	this.effFlag;
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
	* @param  agmtIssOfcCd
	*/
	public void	setAgmtIssOfcCd( String	agmtIssOfcCd ) {
		this.agmtIssOfcCd =	agmtIssOfcCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtIssOfcCd
	 */
	 public	 String	getAgmtIssOfcCd() {
		 return	this.agmtIssOfcCd;
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
	* @param  effDt
	*/
	public void	setEffDt( String	effDt ) {
		this.effDt =	effDt;
	}
 
	/**
	 * Column Info
	 * @return	effDt
	 */
	 public	 String	getEffDt() {
		 return	this.effDt;
	 } 
 	/**
	* Column Info
	* @param  agmtDtTo
	*/
	public void	setAgmtDtTo( String	agmtDtTo ) {
		this.agmtDtTo =	agmtDtTo;
	}
 
	/**
	 * Column Info
	 * @return	agmtDtTo
	 */
	 public	 String	getAgmtDtTo() {
		 return	this.agmtDtTo;
	 } 
 	/**
	* Column Info
	* @param  expDt
	*/
	public void	setExpDt( String	expDt ) {
		this.expDt =	expDt;
	}
 
	/**
	 * Column Info
	 * @return	expDt
	 */
	 public	 String	getExpDt() {
		 return	this.expDt;
	 } 
 	/**
	* Column Info
	* @param  effectiveDate
	*/
	public void	setEffectiveDate( String	effectiveDate ) {
		this.effectiveDate =	effectiveDate;
	}
 
	/**
	 * Column Info
	 * @return	effectiveDate
	 */
	 public	 String	getEffectiveDate() {
		 return	this.effectiveDate;
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
	* @param  agmtRefNo
	*/
	public void	setAgmtRefNo( String	agmtRefNo ) {
		this.agmtRefNo =	agmtRefNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtRefNo
	 */
	 public	 String	getAgmtRefNo() {
		 return	this.agmtRefNo;
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
	* @param  agmtLstmCd
	*/
	public void	setAgmtLstmCd( String	agmtLstmCd ) {
		this.agmtLstmCd =	agmtLstmCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtLstmCd
	 */
	 public	 String	getAgmtLstmCd() {
		 return	this.agmtLstmCd;
	 } 
 	/**
	* Column Info
	* @param  eqKndCd
	*/
	public void	setEqKndCd( String	eqKndCd ) {
		this.eqKndCd =	eqKndCd;
	}
 
	/**
	 * Column Info
	 * @return	eqKndCd
	 */
	 public	 String	getEqKndCd() {
		 return	this.eqKndCd;
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
	* @param  agmtDtFr
	*/
	public void	setAgmtDtFr( String	agmtDtFr ) {
		this.agmtDtFr =	agmtDtFr;
	}
 
	/**
	 * Column Info
	 * @return	agmtDtFr
	 */
	 public	 String	getAgmtDtFr() {
		 return	this.agmtDtFr;
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
	* @param  agmtOfcCtyCd
	*/
	public void	setAgmtOfcCtyCd( String	agmtOfcCtyCd ) {
		this.agmtOfcCtyCd =	agmtOfcCtyCd;
	}
 
	/**
	 * Column Info
	 * @return	agmtOfcCtyCd
	 */
	 public	 String	getAgmtOfcCtyCd() {
		 return	this.agmtOfcCtyCd;
	 } 
 	/**
	* Column Info
	* @param  seq
	*/
	public void	setSeq( String	seq ) {
		this.seq =	seq;
	}
 
	/**
	 * Column Info
	 * @return	seq
	 */
	 public	 String	getSeq() {
		 return	this.seq;
	 } 
 	/**
	* Column Info
	* @param  agmtVerNo
	*/
	public void	setAgmtVerNo( String	agmtVerNo ) {
		this.agmtVerNo =	agmtVerNo;
	}
 
	/**
	 * Column Info
	 * @return	agmtVerNo
	 */
	 public	 String	getAgmtVerNo() {
		 return	this.agmtVerNo;
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
		setLstVerFlg(JSPUtil.getParameter(request,	prefix + "lst_ver_flg", ""));
		setVndrLglEngNm(JSPUtil.getParameter(request,	prefix + "vndr_lgl_eng_nm", ""));
		setAgmtDt(JSPUtil.getParameter(request,	prefix + "agmt_dt", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setEffFlag(JSPUtil.getParameter(request,	prefix + "eff_flag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setAgmtIssOfcCd(JSPUtil.getParameter(request,	prefix + "agmt_iss_ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setAgmtDtTo(JSPUtil.getParameter(request,	prefix + "agmt_dt_to", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setEffectiveDate(JSPUtil.getParameter(request,	prefix + "effective_date", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setAgmtRefNo(JSPUtil.getParameter(request,	prefix + "agmt_ref_no", ""));
		setAgmtSeq(JSPUtil.getParameter(request,	prefix + "agmt_seq", ""));
		setAgmtNo(JSPUtil.getParameter(request,	prefix + "agmt_no", ""));
		setAgmtLstmCd(JSPUtil.getParameter(request,	prefix + "agmt_lstm_cd", ""));
		setEqKndCd(JSPUtil.getParameter(request,	prefix + "eq_knd_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setAgmtDtFr(JSPUtil.getParameter(request,	prefix + "agmt_dt_fr", ""));
		setVndrSeq(JSPUtil.getParameter(request,	prefix + "vndr_seq", ""));
		setAgmtOfcCtyCd(JSPUtil.getParameter(request,	prefix + "agmt_ofc_cty_cd", ""));
		setSeq(JSPUtil.getParameter(request,	prefix + "seq", ""));
		setAgmtVerNo(JSPUtil.getParameter(request,	prefix + "agmt_ver_no", ""));
		setOldAgmtNo(JSPUtil.getParameter(request,	prefix + "old_agmt_no", ""));
	}
	
	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MGSAgreementListINVO[]
	 */
	public MGSAgreementListINVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return MGSAgreementListINVO[]
	 */
	public MGSAgreementListINVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		MGSAgreementListINVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
				String[] lstVerFlg =	(JSPUtil.getParameter(request, prefix +	"lst_ver_flg".trim(),	length));
				String[] vndrLglEngNm =	(JSPUtil.getParameter(request, prefix +	"vndr_lgl_eng_nm".trim(),	length));
				String[] agmtDt =	(JSPUtil.getParameter(request, prefix +	"agmt_dt".trim(),	length));
				String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt".trim(),	length));
				String[] effFlag =	(JSPUtil.getParameter(request, prefix +	"eff_flag".trim(),	length));
				String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows".trim(),	length));
				String[] agmtIssOfcCd =	(JSPUtil.getParameter(request, prefix +	"agmt_iss_ofc_cd".trim(),	length));
				String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag".trim(),	length));
				String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt".trim(),	length));
				String[] agmtDtTo =	(JSPUtil.getParameter(request, prefix +	"agmt_dt_to".trim(),	length));
				String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt".trim(),	length));
				String[] effectiveDate =	(JSPUtil.getParameter(request, prefix +	"effective_date".trim(),	length));
				String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id".trim(),	length));
				String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt".trim(),	length));
				String[] agmtRefNo =	(JSPUtil.getParameter(request, prefix +	"agmt_ref_no".trim(),	length));
				String[] agmtSeq =	(JSPUtil.getParameter(request, prefix +	"agmt_seq".trim(),	length));
				String[] agmtNo =	(JSPUtil.getParameter(request, prefix +	"agmt_no".trim(),	length));
				String[] agmtLstmCd =	(JSPUtil.getParameter(request, prefix +	"agmt_lstm_cd".trim(),	length));
				String[] eqKndCd =	(JSPUtil.getParameter(request, prefix +	"eq_knd_cd".trim(),	length));
				String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id".trim(),	length));
				String[] agmtDtFr =	(JSPUtil.getParameter(request, prefix +	"agmt_dt_fr".trim(),	length));
				String[] vndrSeq =	(JSPUtil.getParameter(request, prefix +	"vndr_seq".trim(),	length));
				String[] agmtOfcCtyCd =	(JSPUtil.getParameter(request, prefix +	"agmt_ofc_cty_cd".trim(),	length));
				String[] seq =	(JSPUtil.getParameter(request, prefix +	"seq".trim(),	length));
				String[] agmtVerNo =	(JSPUtil.getParameter(request, prefix +	"agmt_ver_no".trim(),	length));
				String[] oldAgmtNo =	(JSPUtil.getParameter(request, prefix +	"old_agmt_no".trim(),	length));
				for	(int i = 0;	i <	length;	i++) {
					model =	new	MGSAgreementListINVO();
						if ( lstVerFlg[i] !=	null)
						model.setLstVerFlg( lstVerFlg[i]);
						if ( vndrLglEngNm[i] !=	null)
						model.setVndrLglEngNm( vndrLglEngNm[i]);
						if ( agmtDt[i] !=	null)
						model.setAgmtDt( agmtDt[i]);
						if ( creDt[i] !=	null)
						model.setCreDt( creDt[i]);
						if ( effFlag[i] !=	null)
						model.setEffFlag( effFlag[i]);
						if ( pagerows[i] !=	null)
						model.setPagerows( pagerows[i]);
						if ( agmtIssOfcCd[i] !=	null)
						model.setAgmtIssOfcCd( agmtIssOfcCd[i]);
						if ( ibflag[i] !=	null)
						model.setIbflag( ibflag[i]);
						if ( effDt[i] !=	null)
						model.setEffDt( effDt[i]);
						if ( agmtDtTo[i] !=	null)
						model.setAgmtDtTo( agmtDtTo[i]);
						if ( expDt[i] !=	null)
						model.setExpDt( expDt[i]);
						if ( effectiveDate[i] !=	null)
						model.setEffectiveDate( effectiveDate[i]);
						if ( updUsrId[i] !=	null)
						model.setUpdUsrId( updUsrId[i]);
						if ( updDt[i] !=	null)
						model.setUpdDt( updDt[i]);
						if ( agmtRefNo[i] !=	null)
						model.setAgmtRefNo( agmtRefNo[i]);
						if ( agmtSeq[i] !=	null)
						model.setAgmtSeq( agmtSeq[i]);
						if ( agmtNo[i] !=	null)
						model.setAgmtNo( agmtNo[i]);
						if ( agmtLstmCd[i] !=	null)
						model.setAgmtLstmCd( agmtLstmCd[i]);
						if ( eqKndCd[i] !=	null)
						model.setEqKndCd( eqKndCd[i]);
						if ( creUsrId[i] !=	null)
						model.setCreUsrId( creUsrId[i]);
						if ( agmtDtFr[i] !=	null)
						model.setAgmtDtFr( agmtDtFr[i]);
						if ( vndrSeq[i] !=	null)
						model.setVndrSeq( vndrSeq[i]);
						if ( agmtOfcCtyCd[i] !=	null)
						model.setAgmtOfcCtyCd( agmtOfcCtyCd[i]);
						if ( seq[i] !=	null)
						model.setSeq( seq[i]);
						if ( agmtVerNo[i] !=	null)
						model.setAgmtVerNo( agmtVerNo[i]);
						if ( oldAgmtNo[i] !=	null)
						model.setOldAgmtNo( oldAgmtNo[i]);
					 models.add(model);
				}

		} catch	(Exception e) {
			return null;
		}
		return getMGSAgreementListINVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return MGSAgreementListINVO[]
	 */
	public MGSAgreementListINVO[]	 getMGSAgreementListINVOs(){
		MGSAgreementListINVO[] vos = (MGSAgreementListINVO[])models.toArray(new	MGSAgreementListINVO[models.size()]);
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
		this.lstVerFlg =	this.lstVerFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrLglEngNm =	this.vndrLglEngNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDt =	this.agmtDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effFlag =	this.effFlag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtIssOfcCd =	this.agmtIssOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDtTo =	this.agmtDtTo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effectiveDate =	this.effectiveDate.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtRefNo =	this.agmtRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtSeq =	this.agmtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo =	this.agmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtLstmCd =	this.agmtLstmCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd =	this.eqKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtDtFr =	this.agmtDtFr.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq =	this.vndrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtOfcCtyCd =	this.agmtOfcCtyCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq =	this.seq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtVerNo =	this.agmtVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oldAgmtNo =	this.oldAgmtNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}	
}