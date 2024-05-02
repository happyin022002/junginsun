/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltPriSgArbVO.java
 *@FileTitle : RsltPriSgArbVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.11.19
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2015.11.19 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scguideline.scarbitrarychargeguideline.vo;

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
public class RsltPriSgArbVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltPriSgArbVO>  models =	new	ArrayList<RsltPriSgArbVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String dirCallFlg = null;
	/*	Column Info	*/
	private String viaPortTpCd = null;
	/*	Column Info	*/
	private String currCd = null;
	/*	Column Info	*/
	private String prcCgoTpCd = null;
	/*	Column Info	*/
	private String locDes = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String orgDestTpCd = null;
	/*	Column Info	*/
	private String routPntLocDefCd = null;
	/*	Column Info	*/
	private String ratUtCd = null;
	/*	Column Info	*/
	private String glineSeq = null;
	/*	Column Info	*/
	private String bsePortDefCd = null;
	/*	Column Info	*/
	private String viaPortDefCd = null;
	/*	Column Info	*/
	private String arbSeq = null;
	/*	Column Info	*/
	private String bsePortTpCd = null;
	/*	Column Info	*/
	private String frtRtAmt = null;
	/*	Column Info	*/
	private String prcTrspModCd = null;
	/*	Column Info	*/
	private String rcvDeTermCd = null;
	/*	Column Info	*/
	private String routPntLocTpCd = null;
	/*	Column Info	*/
	private String minCgoWgt = null;
	/*	Column Info	*/
	private String maxCgoWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltPriSgArbVO(){}

	public RsltPriSgArbVO(String ibflag,String pagerows,String dirCallFlg,String viaPortTpCd,String currCd,String prcCgoTpCd,String locDes,String svcScpCd,String orgDestTpCd,String routPntLocDefCd,String ratUtCd,String glineSeq,String bsePortDefCd,String viaPortDefCd,String arbSeq,String bsePortTpCd,String frtRtAmt,String prcTrspModCd,String rcvDeTermCd,String routPntLocTpCd,String minCgoWgt,String maxCgoWgt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.dirCallFlg = dirCallFlg;
		this.viaPortTpCd = viaPortTpCd;
		this.currCd = currCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.locDes = locDes;
		this.svcScpCd = svcScpCd;
		this.orgDestTpCd = orgDestTpCd;
		this.routPntLocDefCd = routPntLocDefCd;
		this.ratUtCd = ratUtCd;
		this.glineSeq = glineSeq;
		this.bsePortDefCd = bsePortDefCd;
		this.viaPortDefCd = viaPortDefCd;
		this.arbSeq = arbSeq;
		this.bsePortTpCd = bsePortTpCd;
		this.frtRtAmt = frtRtAmt;
		this.prcTrspModCd = prcTrspModCd;
		this.rcvDeTermCd = rcvDeTermCd;
		this.routPntLocTpCd = routPntLocTpCd;
		this.minCgoWgt = minCgoWgt;
		this.maxCgoWgt = maxCgoWgt;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("dir_call_flg", getDirCallFlg());
		this.hashColumns.put("via_port_tp_cd", getViaPortTpCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("loc_des", getLocDes());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("rout_pnt_loc_def_cd", getRoutPntLocDefCd());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("bse_port_def_cd", getBsePortDefCd());
		this.hashColumns.put("via_port_def_cd", getViaPortDefCd());
		this.hashColumns.put("arb_seq", getArbSeq());
		this.hashColumns.put("bse_port_tp_cd", getBsePortTpCd());
		this.hashColumns.put("frt_rt_amt", getFrtRtAmt());
		this.hashColumns.put("prc_trsp_mod_cd", getPrcTrspModCd());
		this.hashColumns.put("rcv_de_term_cd", getRcvDeTermCd());
		this.hashColumns.put("rout_pnt_loc_tp_cd", getRoutPntLocTpCd());
		this.hashColumns.put("min_cgo_wgt", getMinCgoWgt());
		this.hashColumns.put("max_cgo_wgt", getMaxCgoWgt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("dir_call_flg", "dirCallFlg");
		this.hashFields.put("via_port_tp_cd", "viaPortTpCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("loc_des", "locDes");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("rout_pnt_loc_def_cd", "routPntLocDefCd");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("bse_port_def_cd", "bsePortDefCd");
		this.hashFields.put("via_port_def_cd", "viaPortDefCd");
		this.hashFields.put("arb_seq", "arbSeq");
		this.hashFields.put("bse_port_tp_cd", "bsePortTpCd");
		this.hashFields.put("frt_rt_amt", "frtRtAmt");
		this.hashFields.put("prc_trsp_mod_cd", "prcTrspModCd");
		this.hashFields.put("rcv_de_term_cd", "rcvDeTermCd");
		this.hashFields.put("rout_pnt_loc_tp_cd", "routPntLocTpCd");
		this.hashFields.put("min_cgo_wgt", "minCgoWgt");
		this.hashFields.put("max_cgo_wgt", "maxCgoWgt");
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
	 * @return dirCallFlg
	 */
	public	String getDirCallFlg() {
		return	this.dirCallFlg;
	}

	/**
	 * Column Info
	 * @return viaPortTpCd
	 */
	public	String getViaPortTpCd() {
		return	this.viaPortTpCd;
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
	 * @return prcCgoTpCd
	 */
	public	String getPrcCgoTpCd() {
		return	this.prcCgoTpCd;
	}

	/**
	 * Column Info
	 * @return locDes
	 */
	public	String getLocDes() {
		return	this.locDes;
	}

	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public	String getSvcScpCd() {
		return	this.svcScpCd;
	}

	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public	String getOrgDestTpCd() {
		return	this.orgDestTpCd;
	}

	/**
	 * Column Info
	 * @return routPntLocDefCd
	 */
	public	String getRoutPntLocDefCd() {
		return	this.routPntLocDefCd;
	}

	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public	String getRatUtCd() {
		return	this.ratUtCd;
	}

	/**
	 * Column Info
	 * @return glineSeq
	 */
	public	String getGlineSeq() {
		return	this.glineSeq;
	}

	/**
	 * Column Info
	 * @return bsePortDefCd
	 */
	public	String getBsePortDefCd() {
		return	this.bsePortDefCd;
	}

	/**
	 * Column Info
	 * @return viaPortDefCd
	 */
	public	String getViaPortDefCd() {
		return	this.viaPortDefCd;
	}

	/**
	 * Column Info
	 * @return arbSeq
	 */
	public	String getArbSeq() {
		return	this.arbSeq;
	}

	/**
	 * Column Info
	 * @return bsePortTpCd
	 */
	public	String getBsePortTpCd() {
		return	this.bsePortTpCd;
	}

	/**
	 * Column Info
	 * @return frtRtAmt
	 */
	public	String getFrtRtAmt() {
		return	this.frtRtAmt;
	}

	/**
	 * Column Info
	 * @return prcTrspModCd
	 */
	public	String getPrcTrspModCd() {
		return	this.prcTrspModCd;
	}

	/**
	 * Column Info
	 * @return rcvDeTermCd
	 */
	public	String getRcvDeTermCd() {
		return	this.rcvDeTermCd;
	}

	/**
	 * Column Info
	 * @return routPntLocTpCd
	 */
	public	String getRoutPntLocTpCd() {
		return	this.routPntLocTpCd;
	}

	/**
	 * Column Info
	 * @return minCgoWgt
	 */
	public	String getMinCgoWgt() {
		return	this.minCgoWgt;
	}

	/**
	 * Column Info
	 * @return maxCgoWgt
	 */
	public	String getMaxCgoWgt() {
		return	this.maxCgoWgt;
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
	 * @param  dirCallFlg
 	 */
	public void	setDirCallFlg(String dirCallFlg ) {
		this.dirCallFlg =	dirCallFlg;
	}
 	/**
	 * Column Info
	 * @param  viaPortTpCd
 	 */
	public void	setViaPortTpCd(String viaPortTpCd ) {
		this.viaPortTpCd =	viaPortTpCd;
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
	 * @param  prcCgoTpCd
 	 */
	public void	setPrcCgoTpCd(String prcCgoTpCd ) {
		this.prcCgoTpCd =	prcCgoTpCd;
	}
 	/**
	 * Column Info
	 * @param  locDes
 	 */
	public void	setLocDes(String locDes ) {
		this.locDes =	locDes;
	}
 	/**
	 * Column Info
	 * @param  svcScpCd
 	 */
	public void	setSvcScpCd(String svcScpCd ) {
		this.svcScpCd =	svcScpCd;
	}
 	/**
	 * Column Info
	 * @param  orgDestTpCd
 	 */
	public void	setOrgDestTpCd(String orgDestTpCd ) {
		this.orgDestTpCd =	orgDestTpCd;
	}
 	/**
	 * Column Info
	 * @param  routPntLocDefCd
 	 */
	public void	setRoutPntLocDefCd(String routPntLocDefCd ) {
		this.routPntLocDefCd =	routPntLocDefCd;
	}
 	/**
	 * Column Info
	 * @param  ratUtCd
 	 */
	public void	setRatUtCd(String ratUtCd ) {
		this.ratUtCd =	ratUtCd;
	}
 	/**
	 * Column Info
	 * @param  glineSeq
 	 */
	public void	setGlineSeq(String glineSeq ) {
		this.glineSeq =	glineSeq;
	}
 	/**
	 * Column Info
	 * @param  bsePortDefCd
 	 */
	public void	setBsePortDefCd(String bsePortDefCd ) {
		this.bsePortDefCd =	bsePortDefCd;
	}
 	/**
	 * Column Info
	 * @param  viaPortDefCd
 	 */
	public void	setViaPortDefCd(String viaPortDefCd ) {
		this.viaPortDefCd =	viaPortDefCd;
	}
 	/**
	 * Column Info
	 * @param  arbSeq
 	 */
	public void	setArbSeq(String arbSeq ) {
		this.arbSeq =	arbSeq;
	}
 	/**
	 * Column Info
	 * @param  bsePortTpCd
 	 */
	public void	setBsePortTpCd(String bsePortTpCd ) {
		this.bsePortTpCd =	bsePortTpCd;
	}
 	/**
	 * Column Info
	 * @param  frtRtAmt
 	 */
	public void	setFrtRtAmt(String frtRtAmt ) {
		this.frtRtAmt =	frtRtAmt;
	}
 	/**
	 * Column Info
	 * @param  prcTrspModCd
 	 */
	public void	setPrcTrspModCd(String prcTrspModCd ) {
		this.prcTrspModCd =	prcTrspModCd;
	}
 	/**
	 * Column Info
	 * @param  rcvDeTermCd
 	 */
	public void	setRcvDeTermCd(String rcvDeTermCd ) {
		this.rcvDeTermCd =	rcvDeTermCd;
	}
 	/**
	 * Column Info
	 * @param  routPntLocTpCd
 	 */
	public void	setRoutPntLocTpCd(String routPntLocTpCd ) {
		this.routPntLocTpCd =	routPntLocTpCd;
	}
 	/**
	 * Column Info
	 * @param  minCgoWgt
 	 */
	public void	setMinCgoWgt(String minCgoWgt ) {
		this.minCgoWgt =	minCgoWgt;
	}
 	/**
	 * Column Info
	 * @param  maxCgoWgt
 	 */
	public void	setMaxCgoWgt(String maxCgoWgt ) {
		this.maxCgoWgt =	maxCgoWgt;
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
		setDirCallFlg(JSPUtil.getParameter(request,	prefix + "dir_call_flg", ""));
		setViaPortTpCd(JSPUtil.getParameter(request,	prefix + "via_port_tp_cd", ""));
		setCurrCd(JSPUtil.getParameter(request,	prefix + "curr_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request,	prefix + "prc_cgo_tp_cd", ""));
		setLocDes(JSPUtil.getParameter(request,	prefix + "loc_des", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request,	prefix + "org_dest_tp_cd", ""));
		setRoutPntLocDefCd(JSPUtil.getParameter(request,	prefix + "rout_pnt_loc_def_cd", ""));
		setRatUtCd(JSPUtil.getParameter(request,	prefix + "rat_ut_cd", ""));
		setGlineSeq(JSPUtil.getParameter(request,	prefix + "gline_seq", ""));
		setBsePortDefCd(JSPUtil.getParameter(request,	prefix + "bse_port_def_cd", ""));
		setViaPortDefCd(JSPUtil.getParameter(request,	prefix + "via_port_def_cd", ""));
		setArbSeq(JSPUtil.getParameter(request,	prefix + "arb_seq", ""));
		setBsePortTpCd(JSPUtil.getParameter(request,	prefix + "bse_port_tp_cd", ""));
		setFrtRtAmt(JSPUtil.getParameter(request,	prefix + "frt_rt_amt", ""));
		setPrcTrspModCd(JSPUtil.getParameter(request,	prefix + "prc_trsp_mod_cd", ""));
		setRcvDeTermCd(JSPUtil.getParameter(request,	prefix + "rcv_de_term_cd", ""));
		setRoutPntLocTpCd(JSPUtil.getParameter(request,	prefix + "rout_pnt_loc_tp_cd", ""));
		setMinCgoWgt(JSPUtil.getParameter(request,	prefix + "min_cgo_wgt", ""));
		setMaxCgoWgt(JSPUtil.getParameter(request,	prefix + "max_cgo_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSgArbVO[]
	 */
	public RsltPriSgArbVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltPriSgArbVO[]
	 */
	public RsltPriSgArbVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltPriSgArbVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] dirCallFlg =	(JSPUtil.getParameter(request, prefix +	"dir_call_flg",	length));
			String[] viaPortTpCd =	(JSPUtil.getParameter(request, prefix +	"via_port_tp_cd",	length));
			String[] currCd =	(JSPUtil.getParameter(request, prefix +	"curr_cd",	length));
			String[] prcCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"prc_cgo_tp_cd",	length));
			String[] locDes =	(JSPUtil.getParameter(request, prefix +	"loc_des",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] orgDestTpCd =	(JSPUtil.getParameter(request, prefix +	"org_dest_tp_cd",	length));
			String[] routPntLocDefCd =	(JSPUtil.getParameter(request, prefix +	"rout_pnt_loc_def_cd",	length));
			String[] ratUtCd =	(JSPUtil.getParameter(request, prefix +	"rat_ut_cd",	length));
			String[] glineSeq =	(JSPUtil.getParameter(request, prefix +	"gline_seq",	length));
			String[] bsePortDefCd =	(JSPUtil.getParameter(request, prefix +	"bse_port_def_cd",	length));
			String[] viaPortDefCd =	(JSPUtil.getParameter(request, prefix +	"via_port_def_cd",	length));
			String[] arbSeq =	(JSPUtil.getParameter(request, prefix +	"arb_seq",	length));
			String[] bsePortTpCd =	(JSPUtil.getParameter(request, prefix +	"bse_port_tp_cd",	length));
			String[] frtRtAmt =	(JSPUtil.getParameter(request, prefix +	"frt_rt_amt",	length));
			String[] prcTrspModCd =	(JSPUtil.getParameter(request, prefix +	"prc_trsp_mod_cd",	length));
			String[] rcvDeTermCd =	(JSPUtil.getParameter(request, prefix +	"rcv_de_term_cd",	length));
			String[] routPntLocTpCd =	(JSPUtil.getParameter(request, prefix +	"rout_pnt_loc_tp_cd",	length));
			String[] minCgoWgt =	(JSPUtil.getParameter(request, prefix +	"min_cgo_wgt",	length));
			String[] maxCgoWgt =	(JSPUtil.getParameter(request, prefix +	"max_cgo_wgt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltPriSgArbVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( dirCallFlg[i] !=	null)
					model.setDirCallFlg( dirCallFlg[i]);
				if ( viaPortTpCd[i] !=	null)
					model.setViaPortTpCd( viaPortTpCd[i]);
				if ( currCd[i] !=	null)
					model.setCurrCd( currCd[i]);
				if ( prcCgoTpCd[i] !=	null)
					model.setPrcCgoTpCd( prcCgoTpCd[i]);
				if ( locDes[i] !=	null)
					model.setLocDes( locDes[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( orgDestTpCd[i] !=	null)
					model.setOrgDestTpCd( orgDestTpCd[i]);
				if ( routPntLocDefCd[i] !=	null)
					model.setRoutPntLocDefCd( routPntLocDefCd[i]);
				if ( ratUtCd[i] !=	null)
					model.setRatUtCd( ratUtCd[i]);
				if ( glineSeq[i] !=	null)
					model.setGlineSeq( glineSeq[i]);
				if ( bsePortDefCd[i] !=	null)
					model.setBsePortDefCd( bsePortDefCd[i]);
				if ( viaPortDefCd[i] !=	null)
					model.setViaPortDefCd( viaPortDefCd[i]);
				if ( arbSeq[i] !=	null)
					model.setArbSeq( arbSeq[i]);
				if ( bsePortTpCd[i] !=	null)
					model.setBsePortTpCd( bsePortTpCd[i]);
				if ( frtRtAmt[i] !=	null)
					model.setFrtRtAmt( frtRtAmt[i]);
				if ( prcTrspModCd[i] !=	null)
					model.setPrcTrspModCd( prcTrspModCd[i]);
				if ( rcvDeTermCd[i] !=	null)
					model.setRcvDeTermCd( rcvDeTermCd[i]);
				if ( routPntLocTpCd[i] !=	null)
					model.setRoutPntLocTpCd( routPntLocTpCd[i]);
				if ( minCgoWgt[i] !=	null)
					model.setMinCgoWgt( minCgoWgt[i]);
				if ( maxCgoWgt[i] !=	null)
					model.setMaxCgoWgt( maxCgoWgt[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltPriSgArbVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltPriSgArbVO[]
	 */
	public RsltPriSgArbVO[]	 getRsltPriSgArbVOs(){
		RsltPriSgArbVO[] vos = (RsltPriSgArbVO[])models.toArray(new	RsltPriSgArbVO[models.size()]);
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
		this.dirCallFlg =	this.dirCallFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaPortTpCd =	this.viaPortTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd =	this.currCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd =	this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locDes =	this.locDes.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd =	this.orgDestTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocDefCd =	this.routPntLocDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd =	this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq =	this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortDefCd =	this.bsePortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.viaPortDefCd =	this.viaPortDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arbSeq =	this.arbSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsePortTpCd =	this.bsePortTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtRtAmt =	this.frtRtAmt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcTrspModCd =	this.prcTrspModCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvDeTermCd =	this.rcvDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routPntLocTpCd =	this.routPntLocTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minCgoWgt =	this.minCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxCgoWgt =	this.maxCgoWgt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}