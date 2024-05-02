/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PriMotChgRtVO.java
 *@FileTitle : PriMotChgRtVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.05.18
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2015.05.18 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

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
 * @author jaewonLee
 * @since J2EE 1.6
 * @see	..
 */
public class PriMotChgRtVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PriMotChgRtVO>  models =	new	ArrayList<PriMotChgRtVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String chgCd = null;
	/*	Column Info	*/
	private String polCd = null;
	/*	Column Info	*/
	private String chgRtSeq = null;
	/*	Column Info	*/
	private String custCntCdSeq = null;
	/*	Column Info	*/
	private String custCntCd = null;
	/*	Column Info	*/
	private String custSeq = null;
	/*	Column Info	*/
	private String custNm = null;
	/*	Column Info	*/
	private String socFlg = null;
	/*	Column Info	*/
	private String prcCgoTpCd = null;
	/*	Column Info	*/
	private String motFileCntrTpCd = null;
	/*	Column Info	*/
	private String motFileLaneCd = null;
	/*	Column Info	*/
	private String payTermCd = null;
	/*	Column Info	*/
	private String agnCd = null;
	/*	Column Info	*/
	private String effDt = null;
	/*	Column Info	*/
	private String expDt = null;
	/*	Column Info	*/
	private String currCd = null;
	/*	Column Info	*/
	private String cntr20ftRtAmt = null;
	/*	Column Info	*/
	private String cntr40ftRtAmt = null;
	/*	Column Info	*/
	private String cntr45ftRtAmt = null;
	/*	Column Info	*/
	private String creUsrId = null;
	/*	Column Info	*/
	private String creDt = null;
	/*	Column Info	*/
	private String updUsrId = null;
	/*	Column Info	*/
	private String updDt = null;
	/*	Column Info	*/
	private String vslSlanCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public PriMotChgRtVO(){}

	public PriMotChgRtVO(String ibflag,String pagerows,String chgCd,String polCd,String chgRtSeq,String custCntCdSeq,String custCntCd,String custSeq,String custNm,String socFlg,String prcCgoTpCd,String motFileCntrTpCd,String motFileLaneCd,String payTermCd,String agnCd,String effDt,String expDt,String currCd,String cntr20ftRtAmt,String cntr40ftRtAmt,String cntr45ftRtAmt,String creUsrId,String creDt,String updUsrId,String updDt,String vslSlanCd)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.chgCd = chgCd;
		this.polCd = polCd;
		this.chgRtSeq = chgRtSeq;
		this.custCntCdSeq = custCntCdSeq;
		this.custCntCd = custCntCd;
		this.custSeq = custSeq;
		this.custNm = custNm;
		this.socFlg = socFlg;
		this.prcCgoTpCd = prcCgoTpCd;
		this.motFileCntrTpCd = motFileCntrTpCd;
		this.motFileLaneCd = motFileLaneCd;
		this.payTermCd = payTermCd;
		this.agnCd = agnCd;
		this.effDt = effDt;
		this.expDt = expDt;
		this.currCd = currCd;
		this.cntr20ftRtAmt = cntr20ftRtAmt;
		this.cntr40ftRtAmt = cntr40ftRtAmt;
		this.cntr45ftRtAmt = cntr45ftRtAmt;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
		this.vslSlanCd = vslSlanCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("chg_rt_seq", getChgRtSeq());
		this.hashColumns.put("cust_cnt_cd_seq", getCustCntCdSeq());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("mot_file_cntr_tp_cd", getMotFileCntrTpCd());
		this.hashColumns.put("mot_file_lane_cd", getMotFileLaneCd());
		this.hashColumns.put("pay_term_cd", getPayTermCd());
		this.hashColumns.put("agn_cd", getAgnCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("cntr_20ft_rt_amt", getCntr20ftRtAmt());
		this.hashColumns.put("cntr_40ft_rt_amt", getCntr40ftRtAmt());
		this.hashColumns.put("cntr_45ft_rt_amt", getCntr45ftRtAmt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("chg_rt_seq", "chgRtSeq");
		this.hashFields.put("cust_cnt_cd_seq", "custCntCdSeq");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("mot_file_cntr_tp_cd", "motFileCntrTpCd");
		this.hashFields.put("mot_file_lane_cd", "motFileLaneCd");
		this.hashFields.put("pay_term_cd", "payTermCd");
		this.hashFields.put("agn_cd", "agnCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("cntr_20ft_rt_amt", "cntr20ftRtAmt");
		this.hashFields.put("cntr_40ft_rt_amt", "cntr40ftRtAmt");
		this.hashFields.put("cntr_45ft_rt_amt", "cntr45ftRtAmt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		return this.hashFields;
	}

	//	Getters	and	Setters

	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public	String getIbflag() {
		return	this.ibflag;
	}

	/**
	 * Page Number
	 * @return pagerows
	 */
	public	String getPagerows() {
		return	this.pagerows;
	}

	/**
	 * Column Info
	 * @return chgCd
	 */
	public	String getChgCd() {
		return	this.chgCd;
	}

	/**
	 * Column Info
	 * @return polCd
	 */
	public	String getPolCd() {
		return	this.polCd;
	}

	/**
	 * Column Info
	 * @return chgRtSeq
	 */
	public	String getChgRtSeq() {
		return	this.chgRtSeq;
	}

	/**
	 * Column Info
	 * @return custCntCdSeq
	 */
	public	String getCustCntCdSeq() {
		return	this.custCntCdSeq;
	}

	/**
	 * Column Info
	 * @return custCntCd
	 */
	public	String getCustCntCd() {
		return	this.custCntCd;
	}

	/**
	 * Column Info
	 * @return custSeq
	 */
	public	String getCustSeq() {
		return	this.custSeq;
	}

	/**
	 * Column Info
	 * @return custNm
	 */
	public	String getCustNm() {
		return	this.custNm;
	}

	/**
	 * Column Info
	 * @return socFlg
	 */
	public	String getSocFlg() {
		return	this.socFlg;
	}

	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public	String getPrcCgoTpCd() {
		return	this.prcCgoTpCd;
	}

	/**
	 * Column Info
	 * @return motFileCntrTpCd
	 */
	public	String getMotFileCntrTpCd() {
		return	this.motFileCntrTpCd;
	}

	/**
	 * Column Info
	 * @return motFileLaneCd
	 */
	public	String getMotFileLaneCd() {
		return	this.motFileLaneCd;
	}

	/**
	 * Column Info
	 * @return payTermCd
	 */
	public	String getPayTermCd() {
		return	this.payTermCd;
	}

	/**
	 * Column Info
	 * @return agnCd
	 */
	public	String getAgnCd() {
		return	this.agnCd;
	}

	/**
	 * Column Info
	 * @return effDt
	 */
	public	String getEffDt() {
		return	this.effDt;
	}

	/**
	 * Column Info
	 * @return expDt
	 */
	public	String getExpDt() {
		return	this.expDt;
	}

	/**
	 * Column Info
	 * @return currCd
	 */
	public	String getCurrCd() {
		return	this.currCd;
	}

	/**
	 * Column Info
	 * @return cntr20ftRtAmt
	 */
	public	String getCntr20ftRtAmt() {
		return	this.cntr20ftRtAmt;
	}

	/**
	 * Column Info
	 * @return cntr40ftRtAmt
	 */
	public	String getCntr40ftRtAmt() {
		return	this.cntr40ftRtAmt;
	}

	/**
	 * Column Info
	 * @return cntr45ftRtAmt
	 */
	public	String getCntr45ftRtAmt() {
		return	this.cntr45ftRtAmt;
	}

	/**
	 * Column Info
	 * @return creUsrId
	 */
	public	String getCreUsrId() {
		return	this.creUsrId;
	}

	/**
	 * Column Info
	 * @return creDt
	 */
	public	String getCreDt() {
		return	this.creDt;
	}

	/**
	 * Column Info
	 * @return updUsrId
	 */
	public	String getUpdUsrId() {
		return	this.updUsrId;
	}

	/**
	 * Column Info
	 * @return updDt
	 */
	public	String getUpdDt() {
		return	this.updDt;
	}

	/**
	 * Column Info
	 * @return vslSlanCd
	 */
	public	String getVslSlanCd() {
		return	this.vslSlanCd;
	}

 	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param  ibflag
 	 */
	public void	setIbflag(String ibflag ) {
		this.ibflag =	ibflag;
	}
 	/**
	 * Page Number
	 * @param  pagerows
 	 */
	public void	setPagerows(String pagerows ) {
		this.pagerows =	pagerows;
	}
 	/**
	 * Column Info
	 * @param  chgCd
 	 */
	public void	setChgCd(String chgCd ) {
		this.chgCd =	chgCd;
	}
 	/**
	 * Column Info
	 * @param  polCd
 	 */
	public void	setPolCd(String polCd ) {
		this.polCd =	polCd;
	}
 	/**
	 * Column Info
	 * @param  chgRtSeq
 	 */
	public void	setChgRtSeq(String chgRtSeq ) {
		this.chgRtSeq =	chgRtSeq;
	}
 	/**
	 * Column Info
	 * @param  custCntCdSeq
 	 */
	public void	setCustCntCdSeq(String custCntCdSeq ) {
		this.custCntCdSeq =	custCntCdSeq;
	}
 	/**
	 * Column Info
	 * @param  custCntCd
 	 */
	public void	setCustCntCd(String custCntCd ) {
		this.custCntCd =	custCntCd;
	}
 	/**
	 * Column Info
	 * @param  custSeq
 	 */
	public void	setCustSeq(String custSeq ) {
		this.custSeq =	custSeq;
	}
 	/**
	 * Column Info
	 * @param  custNm
 	 */
	public void	setCustNm(String custNm ) {
		this.custNm =	custNm;
	}
 	/**
	 * Column Info
	 * @param  socFlg
 	 */
	public void	setSocFlg(String socFlg ) {
		this.socFlg =	socFlg;
	}
 	/**
	 * Column Info
	 * @param  prcCgoTpCd
 	 */
	public void	setPrcCgoTpCd(String prcCgoTpCd ) {
		this.prcCgoTpCd =	prcCgoTpCd;
	}
 	/**
	 * Column Info
	 * @param  motFileCntrTpCd
 	 */
	public void	setMotFileCntrTpCd(String motFileCntrTpCd ) {
		this.motFileCntrTpCd =	motFileCntrTpCd;
	}
 	/**
	 * Column Info
	 * @param  motFileLaneCd
 	 */
	public void	setMotFileLaneCd(String motFileLaneCd ) {
		this.motFileLaneCd =	motFileLaneCd;
	}
 	/**
	 * Column Info
	 * @param  payTermCd
 	 */
	public void	setPayTermCd(String payTermCd ) {
		this.payTermCd =	payTermCd;
	}
 	/**
	 * Column Info
	 * @param  agnCd
 	 */
	public void	setAgnCd(String agnCd ) {
		this.agnCd =	agnCd;
	}
 	/**
	 * Column Info
	 * @param  effDt
 	 */
	public void	setEffDt(String effDt ) {
		this.effDt =	effDt;
	}
 	/**
	 * Column Info
	 * @param  expDt
 	 */
	public void	setExpDt(String expDt ) {
		this.expDt =	expDt;
	}
 	/**
	 * Column Info
	 * @param  currCd
 	 */
	public void	setCurrCd(String currCd ) {
		this.currCd =	currCd;
	}
 	/**
	 * Column Info
	 * @param  cntr20ftRtAmt
 	 */
	public void	setCntr20ftRtAmt(String cntr20ftRtAmt ) {
		this.cntr20ftRtAmt =	cntr20ftRtAmt;
	}
 	/**
	 * Column Info
	 * @param  cntr40ftRtAmt
 	 */
	public void	setCntr40ftRtAmt(String cntr40ftRtAmt ) {
		this.cntr40ftRtAmt =	cntr40ftRtAmt;
	}
 	/**
	 * Column Info
	 * @param  cntr45ftRtAmt
 	 */
	public void	setCntr45ftRtAmt(String cntr45ftRtAmt ) {
		this.cntr45ftRtAmt =	cntr45ftRtAmt;
	}
 	/**
	 * Column Info
	 * @param  creUsrId
 	 */
	public void	setCreUsrId(String creUsrId ) {
		this.creUsrId =	creUsrId;
	}
 	/**
	 * Column Info
	 * @param  creDt
 	 */
	public void	setCreDt(String creDt ) {
		this.creDt =	creDt;
	}
 	/**
	 * Column Info
	 * @param  updUsrId
 	 */
	public void	setUpdUsrId(String updUsrId ) {
		this.updUsrId =	updUsrId;
	}
 	/**
	 * Column Info
	 * @param  updDt
 	 */
	public void	setUpdDt(String updDt ) {
		this.updDt =	updDt;
	}
 	/**
	 * Column Info
	 * @param  vslSlanCd
 	 */
	public void	setVslSlanCd(String vslSlanCd ) {
		this.vslSlanCd =	vslSlanCd;
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
		setIbflag(JSPUtil.getParameter(request,	prefix + "ibflag", ""));
		setPagerows(JSPUtil.getParameter(request,	prefix + "pagerows", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setChgRtSeq(JSPUtil.getParameter(request,	prefix + "chg_rt_seq", ""));
		setCustCntCdSeq(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd_seq", ""));
		setCustCntCd(JSPUtil.getParameter(request,	prefix + "cust_cnt_cd", ""));
		setCustSeq(JSPUtil.getParameter(request,	prefix + "cust_seq", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setSocFlg(JSPUtil.getParameter(request,	prefix + "soc_flg", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request,	prefix + "prc_cgo_tp_cd", ""));
		setMotFileCntrTpCd(JSPUtil.getParameter(request,	prefix + "mot_file_cntr_tp_cd", ""));
		setMotFileLaneCd(JSPUtil.getParameter(request,	prefix + "mot_file_lane_cd", ""));
		setPayTermCd(JSPUtil.getParameter(request,	prefix + "pay_term_cd", ""));
		setAgnCd(JSPUtil.getParameter(request,	prefix + "agn_cd", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setCntr20ftRtAmt(JSPUtil.getParameter(request,	prefix + "cntr_20ft_rt_amt", ""));
		setCntr40ftRtAmt(JSPUtil.getParameter(request,	prefix + "cntr_40ft_rt_amt", ""));
		setCntr45ftRtAmt(JSPUtil.getParameter(request,	prefix + "cntr_45ft_rt_amt", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setVslSlanCd(JSPUtil.getParameter(request,	prefix + "vsl_slan_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriMotChgRtVO[]
	 */
	public PriMotChgRtVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PriMotChgRtVO[]
	 */
	public PriMotChgRtVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PriMotChgRtVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd",	length));
			String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd",	length));
			String[] chgRtSeq =	(JSPUtil.getParameter(request, prefix +	"chg_rt_seq",	length));
			String[] custCntCdSeq =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd_seq",	length));
			String[] custCntCd =	(JSPUtil.getParameter(request, prefix +	"cust_cnt_cd",	length));
			String[] custSeq =	(JSPUtil.getParameter(request, prefix +	"cust_seq",	length));
			String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm",	length));
			String[] socFlg =	(JSPUtil.getParameter(request, prefix +	"soc_flg",	length));
			String[] prcCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"prc_cgo_tp_cd",	length));
			String[] motFileCntrTpCd =	(JSPUtil.getParameter(request, prefix +	"mot_file_cntr_tp_cd",	length));
			String[] motFileLaneCd =	(JSPUtil.getParameter(request, prefix +	"mot_file_lane_cd",	length));
			String[] payTermCd =	(JSPUtil.getParameter(request, prefix +	"pay_term_cd",	length));
			String[] agnCd =	(JSPUtil.getParameter(request, prefix +	"agn_cd",	length));
			String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt",	length));
			String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt",	length));
			String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd",	length));
			String[] cntr20ftRtAmt =	(JSPUtil.getParameter(request, prefix +	"cntr_20ft_rt_amt",	length));
			String[] cntr40ftRtAmt =	(JSPUtil.getParameter(request, prefix +	"cntr_40ft_rt_amt",	length));
			String[] cntr45ftRtAmt =	(JSPUtil.getParameter(request, prefix +	"cntr_45ft_rt_amt",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			String[] vslSlanCd =	(JSPUtil.getParameter(request, prefix +	"vsl_slan_cd",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	PriMotChgRtVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( chgCd[i] !=	null)
					model.setChgCd( chgCd[i]);
				if ( polCd[i] !=	null)
					model.setPolCd( polCd[i]);
				if ( chgRtSeq[i] !=	null)
					model.setChgRtSeq( chgRtSeq[i]);
				if ( custCntCdSeq[i] !=	null)
					model.setCustCntCdSeq( custCntCdSeq[i]);
				if ( custCntCd[i] !=	null)
					model.setCustCntCd( custCntCd[i]);
				if ( custSeq[i] !=	null)
					model.setCustSeq( custSeq[i]);
				if ( custNm[i] !=	null)
					model.setCustNm( custNm[i]);
				if ( socFlg[i] !=	null)
					model.setSocFlg( socFlg[i]);
				if ( prcCgoTpCd[i] !=	null)
					model.setPrcCgoTpCd( prcCgoTpCd[i]);
				if ( motFileCntrTpCd[i] !=	null)
					model.setMotFileCntrTpCd( motFileCntrTpCd[i]);
				if ( motFileLaneCd[i] !=	null)
					model.setMotFileLaneCd( motFileLaneCd[i]);
				if ( payTermCd[i] !=	null)
					model.setPayTermCd( payTermCd[i]);
				if ( agnCd[i] !=	null)
					model.setAgnCd( agnCd[i]);
				if ( effDt[i] !=	null)
					model.setEffDt( effDt[i]);
				if ( expDt[i] !=	null)
					model.setExpDt( expDt[i]);
				if ( currCd[i] !=	null)
					model.setCurrCd( currCd[i]);
				if ( cntr20ftRtAmt[i] !=	null)
					model.setCntr20ftRtAmt( cntr20ftRtAmt[i]);
				if ( cntr40ftRtAmt[i] !=	null)
					model.setCntr40ftRtAmt( cntr40ftRtAmt[i]);
				if ( cntr45ftRtAmt[i] !=	null)
					model.setCntr45ftRtAmt( cntr45ftRtAmt[i]);
				if ( creUsrId[i] !=	null)
					model.setCreUsrId( creUsrId[i]);
				if ( creDt[i] !=	null)
					model.setCreDt( creDt[i]);
				if ( updUsrId[i] !=	null)
					model.setUpdUsrId( updUsrId[i]);
				if ( updDt[i] !=	null)
					model.setUpdDt( updDt[i]);
				if ( vslSlanCd[i] !=	null)
					model.setVslSlanCd( vslSlanCd[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getPriMotChgRtVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PriMotChgRtVO[]
	 */
	public PriMotChgRtVO[]	 getPriMotChgRtVOs(){
		PriMotChgRtVO[] vos = (PriMotChgRtVO[])models.toArray(new	PriMotChgRtVO[models.size()]);
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
		this.ibflag =	this.ibflag.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows =	this.pagerows.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgRtSeq =	this.chgRtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCdSeq =	this.custCntCdSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd =	this.custCntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq =	this.custSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg =	this.socFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd =	this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motFileCntrTpCd =	this.motFileCntrTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.motFileLaneCd =	this.motFileLaneCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.payTermCd =	this.payTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agnCd =	this.agnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr20ftRtAmt =	this.cntr20ftRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr40ftRtAmt =	this.cntr40ftRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntr45ftRtAmt =	this.cntr45ftRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd =	this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}