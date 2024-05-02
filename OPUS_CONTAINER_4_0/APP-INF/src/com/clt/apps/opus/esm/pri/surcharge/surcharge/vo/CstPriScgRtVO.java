/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CstPriScgRtVO.java
 *@FileTitle : CstPriScgRtVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.04.14
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2016.04.14 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.surcharge.surcharge.vo;

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
public class CstPriScgRtVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<CstPriScgRtVO>  models =	new	ArrayList<CstPriScgRtVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String updDt = null;
	/*	Column Info	*/
	private String prcDeTermCd = null;
	/*	Column Info	*/
	private String prcCgoTpCd = null;
	/*	Column Info	*/
	private String scgImdgClssCd = null;
	/*	Column Info	*/
	private String cntrSzCd = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String wdrFlg = null;
	/*	Column Info	*/
	private String ratUtCd = null;
	/*	Column Info	*/
	private String porDefCd = null;
	/*	Column Info	*/
	private String chgCd = null;
	/*	Column Info	*/
	private String polDefCd = null;
	/*	Column Info	*/
	private String prcRcvTermCd = null;
	/*	Column Info	*/
	private String delDefCd = null;
	/*	Column Info	*/
	private String effDt = null;
	/*	Column Info	*/
	private String podDefCd = null;
	/*	Column Info	*/
	private String vslSlanCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public CstPriScgRtVO(){}

	public CstPriScgRtVO(String ibflag,String pagerows,String updDt,String prcDeTermCd,String prcCgoTpCd,String scgImdgClssCd,String cntrSzCd,String svcScpCd,String wdrFlg,String ratUtCd,String porDefCd,String chgCd,String polDefCd,String prcRcvTermCd,String delDefCd,String effDt,String podDefCd,String vslSlanCd)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.updDt = updDt;
		this.prcDeTermCd = prcDeTermCd;
		this.prcCgoTpCd = prcCgoTpCd;
		this.scgImdgClssCd = scgImdgClssCd;
		this.cntrSzCd = cntrSzCd;
		this.svcScpCd = svcScpCd;
		this.wdrFlg = wdrFlg;
		this.ratUtCd = ratUtCd;
		this.porDefCd = porDefCd;
		this.chgCd = chgCd;
		this.polDefCd = polDefCd;
		this.prcRcvTermCd = prcRcvTermCd;
		this.delDefCd = delDefCd;
		this.effDt = effDt;
		this.podDefCd = podDefCd;
		this.vslSlanCd = vslSlanCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("prc_de_term_cd", getPrcDeTermCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		this.hashColumns.put("scg_imdg_clss_cd", getScgImdgClssCd());
		this.hashColumns.put("cntr_sz_cd", getCntrSzCd());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("wdr_flg", getWdrFlg());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("por_def_cd", getPorDefCd());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pol_def_cd", getPolDefCd());
		this.hashColumns.put("prc_rcv_term_cd", getPrcRcvTermCd());
		this.hashColumns.put("del_def_cd", getDelDefCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("pod_def_cd", getPodDefCd());
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
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("prc_de_term_cd", "prcDeTermCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
		this.hashFields.put("scg_imdg_clss_cd", "scgImdgClssCd");
		this.hashFields.put("cntr_sz_cd", "cntrSzCd");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("wdr_flg", "wdrFlg");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("por_def_cd", "porDefCd");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pol_def_cd", "polDefCd");
		this.hashFields.put("prc_rcv_term_cd", "prcRcvTermCd");
		this.hashFields.put("del_def_cd", "delDefCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("pod_def_cd", "podDefCd");
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
	 * @return updDt
	 */
	public	String getUpdDt() {
		return	this.updDt;
	}

	/**
	 * Column Info
	 * @return prcDeTermCd
	 */
	public	String getPrcDeTermCd() {
		return	this.prcDeTermCd;
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
	 * @return scgImdgClssCd
	 */
	public	String getScgImdgClssCd() {
		return	this.scgImdgClssCd;
	}

	/**
	 * Column Info
	 * @return cntrSzCd
	 */
	public	String getCntrSzCd() {
		return	this.cntrSzCd;
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
	 * @return wdrFlg
	 */
	public	String getWdrFlg() {
		return	this.wdrFlg;
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
	 * @return porDefCd
	 */
	public	String getPorDefCd() {
		return	this.porDefCd;
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
	 * @return polDefCd
	 */
	public	String getPolDefCd() {
		return	this.polDefCd;
	}

	/**
	 * Column Info
	 * @return prcRcvTermCd
	 */
	public	String getPrcRcvTermCd() {
		return	this.prcRcvTermCd;
	}

	/**
	 * Column Info
	 * @return delDefCd
	 */
	public	String getDelDefCd() {
		return	this.delDefCd;
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
	 * @return podDefCd
	 */
	public	String getPodDefCd() {
		return	this.podDefCd;
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
	 * @param  updDt
 	 */
	public void	setUpdDt(String updDt ) {
		this.updDt =	updDt;
	}
 	/**
	 * Column Info
	 * @param  prcDeTermCd
 	 */
	public void	setPrcDeTermCd(String prcDeTermCd ) {
		this.prcDeTermCd =	prcDeTermCd;
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
	 * @param  scgImdgClssCd
 	 */
	public void	setScgImdgClssCd(String scgImdgClssCd ) {
		this.scgImdgClssCd =	scgImdgClssCd;
	}
 	/**
	 * Column Info
	 * @param  cntrSzCd
 	 */
	public void	setCntrSzCd(String cntrSzCd ) {
		this.cntrSzCd =	cntrSzCd;
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
	 * @param  wdrFlg
 	 */
	public void	setWdrFlg(String wdrFlg ) {
		this.wdrFlg =	wdrFlg;
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
	 * @param  porDefCd
 	 */
	public void	setPorDefCd(String porDefCd ) {
		this.porDefCd =	porDefCd;
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
	 * @param  polDefCd
 	 */
	public void	setPolDefCd(String polDefCd ) {
		this.polDefCd =	polDefCd;
	}
 	/**
	 * Column Info
	 * @param  prcRcvTermCd
 	 */
	public void	setPrcRcvTermCd(String prcRcvTermCd ) {
		this.prcRcvTermCd =	prcRcvTermCd;
	}
 	/**
	 * Column Info
	 * @param  delDefCd
 	 */
	public void	setDelDefCd(String delDefCd ) {
		this.delDefCd =	delDefCd;
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
	 * @param  podDefCd
 	 */
	public void	setPodDefCd(String podDefCd ) {
		this.podDefCd =	podDefCd;
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
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
		setPrcDeTermCd(JSPUtil.getParameter(request,	prefix + "prc_de_term_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request,	prefix + "prc_cgo_tp_cd", ""));
		setScgImdgClssCd(JSPUtil.getParameter(request,	prefix + "scg_imdg_clss_cd", ""));
		setCntrSzCd(JSPUtil.getParameter(request,	prefix + "cntr_sz_cd", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setWdrFlg(JSPUtil.getParameter(request,	prefix + "wdr_flg", ""));
		setRatUtCd(JSPUtil.getParameter(request,	prefix + "rat_ut_cd", ""));
		setPorDefCd(JSPUtil.getParameter(request,	prefix + "por_def_cd", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPolDefCd(JSPUtil.getParameter(request,	prefix + "pol_def_cd", ""));
		setPrcRcvTermCd(JSPUtil.getParameter(request,	prefix + "prc_rcv_term_cd", ""));
		setDelDefCd(JSPUtil.getParameter(request,	prefix + "del_def_cd", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setPodDefCd(JSPUtil.getParameter(request,	prefix + "pod_def_cd", ""));
		setVslSlanCd(JSPUtil.getParameter(request,	prefix + "vsl_slan_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CstPriScgRtVO[]
	 */
	public CstPriScgRtVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return CstPriScgRtVO[]
	 */
	public CstPriScgRtVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		CstPriScgRtVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			String[] prcDeTermCd =	(JSPUtil.getParameter(request, prefix +	"prc_de_term_cd",	length));
			String[] prcCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"prc_cgo_tp_cd",	length));
			String[] scgImdgClssCd =	(JSPUtil.getParameter(request, prefix +	"scg_imdg_clss_cd",	length));
			String[] cntrSzCd =	(JSPUtil.getParameter(request, prefix +	"cntr_sz_cd",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] wdrFlg =	(JSPUtil.getParameter(request, prefix +	"wdr_flg",	length));
			String[] ratUtCd =	(JSPUtil.getParameter(request, prefix +	"rat_ut_cd",	length));
			String[] porDefCd =	(JSPUtil.getParameter(request, prefix +	"por_def_cd",	length));
			String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd",	length));
			String[] polDefCd =	(JSPUtil.getParameter(request, prefix +	"pol_def_cd",	length));
			String[] prcRcvTermCd =	(JSPUtil.getParameter(request, prefix +	"prc_rcv_term_cd",	length));
			String[] delDefCd =	(JSPUtil.getParameter(request, prefix +	"del_def_cd",	length));
			String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt",	length));
			String[] podDefCd =	(JSPUtil.getParameter(request, prefix +	"pod_def_cd",	length));
			String[] vslSlanCd =	(JSPUtil.getParameter(request, prefix +	"vsl_slan_cd",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	CstPriScgRtVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( updDt[i] !=	null)
					model.setUpdDt( updDt[i]);
				if ( prcDeTermCd[i] !=	null)
					model.setPrcDeTermCd( prcDeTermCd[i]);
				if ( prcCgoTpCd[i] !=	null)
					model.setPrcCgoTpCd( prcCgoTpCd[i]);
				if ( scgImdgClssCd[i] !=	null)
					model.setScgImdgClssCd( scgImdgClssCd[i]);
				if ( cntrSzCd[i] !=	null)
					model.setCntrSzCd( cntrSzCd[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( wdrFlg[i] !=	null)
					model.setWdrFlg( wdrFlg[i]);
				if ( ratUtCd[i] !=	null)
					model.setRatUtCd( ratUtCd[i]);
				if ( porDefCd[i] !=	null)
					model.setPorDefCd( porDefCd[i]);
				if ( chgCd[i] !=	null)
					model.setChgCd( chgCd[i]);
				if ( polDefCd[i] !=	null)
					model.setPolDefCd( polDefCd[i]);
				if ( prcRcvTermCd[i] !=	null)
					model.setPrcRcvTermCd( prcRcvTermCd[i]);
				if ( delDefCd[i] !=	null)
					model.setDelDefCd( delDefCd[i]);
				if ( effDt[i] !=	null)
					model.setEffDt( effDt[i]);
				if ( podDefCd[i] !=	null)
					model.setPodDefCd( podDefCd[i]);
				if ( vslSlanCd[i] !=	null)
					model.setVslSlanCd( vslSlanCd[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getCstPriScgRtVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return CstPriScgRtVO[]
	 */
	public CstPriScgRtVO[]	 getCstPriScgRtVOs(){
		CstPriScgRtVO[] vos = (CstPriScgRtVO[])models.toArray(new	CstPriScgRtVO[models.size()]);
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
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcDeTermCd =	this.prcDeTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd =	this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scgImdgClssCd =	this.scgImdgClssCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSzCd =	this.cntrSzCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wdrFlg =	this.wdrFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd =	this.ratUtCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porDefCd =	this.porDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polDefCd =	this.polDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcRcvTermCd =	this.prcRcvTermCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delDefCd =	this.delDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podDefCd =	this.podDefCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd =	this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}