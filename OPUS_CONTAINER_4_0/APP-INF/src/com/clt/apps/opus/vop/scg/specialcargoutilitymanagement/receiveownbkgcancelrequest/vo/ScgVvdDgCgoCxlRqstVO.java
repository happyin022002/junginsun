/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScgVvdDgCgoCxlRqstVO.java
 *@FileTitle : ScgVvdDgCgoCxlRqstVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.19
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.19 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveownbkgcancelrequest.vo;

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
 * @author dongsoo
 * @since J2EE 1.6
 * @see	..
 */
public class ScgVvdDgCgoCxlRqstVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ScgVvdDgCgoCxlRqstVO>  models =	new	ArrayList<ScgVvdDgCgoCxlRqstVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String bkgNo = null;
	/*	Column Info	*/
	private String dcgoCxlRqstSeq = null;
	/*	Column Info	*/
	private String vslCd = null;
	/*	Column Info	*/
	private String skdVoyNo = null;
	/*	Column Info	*/
	private String skdDirCd = null;
	/*	Column Info	*/
	private String polCd = null;
	/*	Column Info	*/
	private String polClptIndSeq = null;
	/*	Column Info	*/
	private String polYdCd = null;
	/*	Column Info	*/
	private String podCd = null;
	/*	Column Info	*/
	private String podClptIndSeq = null;
	/*	Column Info	*/
	private String podYdCd = null;
	/*	Column Info	*/
	private String cxlCgoKndCd = null;
	/*	Column Info	*/
	private String cxlCgoRqstDt = null;
	/*	Column Info	*/
	private String cxlCgoRsn = null;
	/*	Column Info	*/
	private String dgCntrKnt = null;
	/*	Column Info	*/
	private String dcgoKnt = null;
	/*	Column Info	*/
	private String rqstVrfyRsltCd = null;
	/*	Column Info	*/
	private String rqstVrfyRsltRmk = null;
	/*	Column Info	*/
	private String creUsrId = null;
	/*	Column Info	*/
	private String creDt = null;
	/*	Column Info	*/
	private String updUsrId = null;
	/*	Column Info	*/
	private String updDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public ScgVvdDgCgoCxlRqstVO(){}

	public ScgVvdDgCgoCxlRqstVO(String ibflag,String pagerows,String bkgNo,String dcgoCxlRqstSeq,String vslCd,String skdVoyNo,String skdDirCd,String polCd,String polClptIndSeq,String polYdCd,String podCd,String podClptIndSeq,String podYdCd,String cxlCgoKndCd,String cxlCgoRqstDt,String cxlCgoRsn,String dgCntrKnt,String dcgoKnt,String rqstVrfyRsltCd,String rqstVrfyRsltRmk,String creUsrId,String creDt,String updUsrId,String updDt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.bkgNo = bkgNo;
		this.dcgoCxlRqstSeq = dcgoCxlRqstSeq;
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.polCd = polCd;
		this.polClptIndSeq = polClptIndSeq;
		this.polYdCd = polYdCd;
		this.podCd = podCd;
		this.podClptIndSeq = podClptIndSeq;
		this.podYdCd = podYdCd;
		this.cxlCgoKndCd = cxlCgoKndCd;
		this.cxlCgoRqstDt = cxlCgoRqstDt;
		this.cxlCgoRsn = cxlCgoRsn;
		this.dgCntrKnt = dgCntrKnt;
		this.dcgoKnt = dcgoKnt;
		this.rqstVrfyRsltCd = rqstVrfyRsltCd;
		this.rqstVrfyRsltRmk = rqstVrfyRsltRmk;
		this.creUsrId = creUsrId;
		this.creDt = creDt;
		this.updUsrId = updUsrId;
		this.updDt = updDt;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("dcgo_cxl_rqst_seq", getDcgoCxlRqstSeq());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("cxl_cgo_knd_cd", getCxlCgoKndCd());
		this.hashColumns.put("cxl_cgo_rqst_dt", getCxlCgoRqstDt());
		this.hashColumns.put("cxl_cgo_rsn", getCxlCgoRsn());
		this.hashColumns.put("dg_cntr_knt", getDgCntrKnt());
		this.hashColumns.put("dcgo_knt", getDcgoKnt());
		this.hashColumns.put("rqst_vrfy_rslt_cd", getRqstVrfyRsltCd());
		this.hashColumns.put("rqst_vrfy_rslt_rmk", getRqstVrfyRsltRmk());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("upd_dt", getUpdDt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("dcgo_cxl_rqst_seq", "dcgoCxlRqstSeq");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("cxl_cgo_knd_cd", "cxlCgoKndCd");
		this.hashFields.put("cxl_cgo_rqst_dt", "cxlCgoRqstDt");
		this.hashFields.put("cxl_cgo_rsn", "cxlCgoRsn");
		this.hashFields.put("dg_cntr_knt", "dgCntrKnt");
		this.hashFields.put("dcgo_knt", "dcgoKnt");
		this.hashFields.put("rqst_vrfy_rslt_cd", "rqstVrfyRsltCd");
		this.hashFields.put("rqst_vrfy_rslt_rmk", "rqstVrfyRsltRmk");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("upd_dt", "updDt");
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
	 * @return bkgNo
	 */
	public	String getBkgNo() {
		return	this.bkgNo;
	}

	/**
	 * Column Info
	 * @return dcgoCxlRqstSeq
	 */
	public	String getDcgoCxlRqstSeq() {
		return	this.dcgoCxlRqstSeq;
	}

	/**
	 * Column Info
	 * @return vslCd
	 */
	public	String getVslCd() {
		return	this.vslCd;
	}

	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public	String getSkdVoyNo() {
		return	this.skdVoyNo;
	}

	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public	String getSkdDirCd() {
		return	this.skdDirCd;
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
	 * @return polClptIndSeq
	 */
	public	String getPolClptIndSeq() {
		return	this.polClptIndSeq;
	}

	/**
	 * Column Info
	 * @return polYdCd
	 */
	public	String getPolYdCd() {
		return	this.polYdCd;
	}

	/**
	 * Column Info
	 * @return podCd
	 */
	public	String getPodCd() {
		return	this.podCd;
	}

	/**
	 * Column Info
	 * @return podClptIndSeq
	 */
	public	String getPodClptIndSeq() {
		return	this.podClptIndSeq;
	}

	/**
	 * Column Info
	 * @return podYdCd
	 */
	public	String getPodYdCd() {
		return	this.podYdCd;
	}

	/**
	 * Column Info
	 * @return cxlCgoKndCd
	 */
	public	String getCxlCgoKndCd() {
		return	this.cxlCgoKndCd;
	}

	/**
	 * Column Info
	 * @return cxlCgoRqstDt
	 */
	public	String getCxlCgoRqstDt() {
		return	this.cxlCgoRqstDt;
	}

	/**
	 * Column Info
	 * @return cxlCgoRsn
	 */
	public	String getCxlCgoRsn() {
		return	this.cxlCgoRsn;
	}

	/**
	 * Column Info
	 * @return dgCntrKnt
	 */
	public	String getDgCntrKnt() {
		return	this.dgCntrKnt;
	}

	/**
	 * Column Info
	 * @return dcgoKnt
	 */
	public	String getDcgoKnt() {
		return	this.dcgoKnt;
	}

	/**
	 * Column Info
	 * @return rqstVrfyRsltCd
	 */
	public	String getRqstVrfyRsltCd() {
		return	this.rqstVrfyRsltCd;
	}

	/**
	 * Column Info
	 * @return rqstVrfyRsltRmk
	 */
	public	String getRqstVrfyRsltRmk() {
		return	this.rqstVrfyRsltRmk;
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
	 * @param  bkgNo
 	 */
	public void	setBkgNo(String bkgNo ) {
		this.bkgNo =	bkgNo;
	}
 	/**
	 * Column Info
	 * @param  dcgoCxlRqstSeq
 	 */
	public void	setDcgoCxlRqstSeq(String dcgoCxlRqstSeq ) {
		this.dcgoCxlRqstSeq =	dcgoCxlRqstSeq;
	}
 	/**
	 * Column Info
	 * @param  vslCd
 	 */
	public void	setVslCd(String vslCd ) {
		this.vslCd =	vslCd;
	}
 	/**
	 * Column Info
	 * @param  skdVoyNo
 	 */
	public void	setSkdVoyNo(String skdVoyNo ) {
		this.skdVoyNo =	skdVoyNo;
	}
 	/**
	 * Column Info
	 * @param  skdDirCd
 	 */
	public void	setSkdDirCd(String skdDirCd ) {
		this.skdDirCd =	skdDirCd;
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
	 * @param  polClptIndSeq
 	 */
	public void	setPolClptIndSeq(String polClptIndSeq ) {
		this.polClptIndSeq =	polClptIndSeq;
	}
 	/**
	 * Column Info
	 * @param  polYdCd
 	 */
	public void	setPolYdCd(String polYdCd ) {
		this.polYdCd =	polYdCd;
	}
 	/**
	 * Column Info
	 * @param  podCd
 	 */
	public void	setPodCd(String podCd ) {
		this.podCd =	podCd;
	}
 	/**
	 * Column Info
	 * @param  podClptIndSeq
 	 */
	public void	setPodClptIndSeq(String podClptIndSeq ) {
		this.podClptIndSeq =	podClptIndSeq;
	}
 	/**
	 * Column Info
	 * @param  podYdCd
 	 */
	public void	setPodYdCd(String podYdCd ) {
		this.podYdCd =	podYdCd;
	}
 	/**
	 * Column Info
	 * @param  cxlCgoKndCd
 	 */
	public void	setCxlCgoKndCd(String cxlCgoKndCd ) {
		this.cxlCgoKndCd =	cxlCgoKndCd;
	}
 	/**
	 * Column Info
	 * @param  cxlCgoRqstDt
 	 */
	public void	setCxlCgoRqstDt(String cxlCgoRqstDt ) {
		this.cxlCgoRqstDt =	cxlCgoRqstDt;
	}
 	/**
	 * Column Info
	 * @param  cxlCgoRsn
 	 */
	public void	setCxlCgoRsn(String cxlCgoRsn ) {
		this.cxlCgoRsn =	cxlCgoRsn;
	}
 	/**
	 * Column Info
	 * @param  dgCntrKnt
 	 */
	public void	setDgCntrKnt(String dgCntrKnt ) {
		this.dgCntrKnt =	dgCntrKnt;
	}
 	/**
	 * Column Info
	 * @param  dcgoKnt
 	 */
	public void	setDcgoKnt(String dcgoKnt ) {
		this.dcgoKnt =	dcgoKnt;
	}
 	/**
	 * Column Info
	 * @param  rqstVrfyRsltCd
 	 */
	public void	setRqstVrfyRsltCd(String rqstVrfyRsltCd ) {
		this.rqstVrfyRsltCd =	rqstVrfyRsltCd;
	}
 	/**
	 * Column Info
	 * @param  rqstVrfyRsltRmk
 	 */
	public void	setRqstVrfyRsltRmk(String rqstVrfyRsltRmk ) {
		this.rqstVrfyRsltRmk =	rqstVrfyRsltRmk;
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
		setBkgNo(JSPUtil.getParameter(request,	prefix + "bkg_no", ""));
		setDcgoCxlRqstSeq(JSPUtil.getParameter(request,	prefix + "dcgo_cxl_rqst_seq", ""));
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setPolCd(JSPUtil.getParameter(request,	prefix + "pol_cd", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request,	prefix + "pol_clpt_ind_seq", ""));
		setPolYdCd(JSPUtil.getParameter(request,	prefix + "pol_yd_cd", ""));
		setPodCd(JSPUtil.getParameter(request,	prefix + "pod_cd", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request,	prefix + "pod_clpt_ind_seq", ""));
		setPodYdCd(JSPUtil.getParameter(request,	prefix + "pod_yd_cd", ""));
		setCxlCgoKndCd(JSPUtil.getParameter(request,	prefix + "cxl_cgo_knd_cd", ""));
		setCxlCgoRqstDt(JSPUtil.getParameter(request,	prefix + "cxl_cgo_rqst_dt", ""));
		setCxlCgoRsn(JSPUtil.getParameter(request,	prefix + "cxl_cgo_rsn", ""));
		setDgCntrKnt(JSPUtil.getParameter(request,	prefix + "dg_cntr_knt", ""));
		setDcgoKnt(JSPUtil.getParameter(request,	prefix + "dcgo_knt", ""));
		setRqstVrfyRsltCd(JSPUtil.getParameter(request,	prefix + "rqst_vrfy_rslt_cd", ""));
		setRqstVrfyRsltRmk(JSPUtil.getParameter(request,	prefix + "rqst_vrfy_rslt_rmk", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgVvdDgCgoCxlRqstVO[]
	 */
	public ScgVvdDgCgoCxlRqstVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ScgVvdDgCgoCxlRqstVO[]
	 */
	public ScgVvdDgCgoCxlRqstVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ScgVvdDgCgoCxlRqstVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] bkgNo =	(JSPUtil.getParameter(request, prefix +	"bkg_no",	length));
			String[] dcgoCxlRqstSeq =	(JSPUtil.getParameter(request, prefix +	"dcgo_cxl_rqst_seq",	length));
			String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd",	length));
			String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no",	length));
			String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd",	length));
			String[] polCd =	(JSPUtil.getParameter(request, prefix +	"pol_cd",	length));
			String[] polClptIndSeq =	(JSPUtil.getParameter(request, prefix +	"pol_clpt_ind_seq",	length));
			String[] polYdCd =	(JSPUtil.getParameter(request, prefix +	"pol_yd_cd",	length));
			String[] podCd =	(JSPUtil.getParameter(request, prefix +	"pod_cd",	length));
			String[] podClptIndSeq =	(JSPUtil.getParameter(request, prefix +	"pod_clpt_ind_seq",	length));
			String[] podYdCd =	(JSPUtil.getParameter(request, prefix +	"pod_yd_cd",	length));
			String[] cxlCgoKndCd =	(JSPUtil.getParameter(request, prefix +	"cxl_cgo_knd_cd",	length));
			String[] cxlCgoRqstDt =	(JSPUtil.getParameter(request, prefix +	"cxl_cgo_rqst_dt",	length));
			String[] cxlCgoRsn =	(JSPUtil.getParameter(request, prefix +	"cxl_cgo_rsn",	length));
			String[] dgCntrKnt =	(JSPUtil.getParameter(request, prefix +	"dg_cntr_knt",	length));
			String[] dcgoKnt =	(JSPUtil.getParameter(request, prefix +	"dcgo_knt",	length));
			String[] rqstVrfyRsltCd =	(JSPUtil.getParameter(request, prefix +	"rqst_vrfy_rslt_cd",	length));
			String[] rqstVrfyRsltRmk =	(JSPUtil.getParameter(request, prefix +	"rqst_vrfy_rslt_rmk",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	ScgVvdDgCgoCxlRqstVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( bkgNo[i] !=	null)
					model.setBkgNo( bkgNo[i]);
				if ( dcgoCxlRqstSeq[i] !=	null)
					model.setDcgoCxlRqstSeq( dcgoCxlRqstSeq[i]);
				if ( vslCd[i] !=	null)
					model.setVslCd( vslCd[i]);
				if ( skdVoyNo[i] !=	null)
					model.setSkdVoyNo( skdVoyNo[i]);
				if ( skdDirCd[i] !=	null)
					model.setSkdDirCd( skdDirCd[i]);
				if ( polCd[i] !=	null)
					model.setPolCd( polCd[i]);
				if ( polClptIndSeq[i] !=	null)
					model.setPolClptIndSeq( polClptIndSeq[i]);
				if ( polYdCd[i] !=	null)
					model.setPolYdCd( polYdCd[i]);
				if ( podCd[i] !=	null)
					model.setPodCd( podCd[i]);
				if ( podClptIndSeq[i] !=	null)
					model.setPodClptIndSeq( podClptIndSeq[i]);
				if ( podYdCd[i] !=	null)
					model.setPodYdCd( podYdCd[i]);
				if ( cxlCgoKndCd[i] !=	null)
					model.setCxlCgoKndCd( cxlCgoKndCd[i]);
				if ( cxlCgoRqstDt[i] !=	null)
					model.setCxlCgoRqstDt( cxlCgoRqstDt[i]);
				if ( cxlCgoRsn[i] !=	null)
					model.setCxlCgoRsn( cxlCgoRsn[i]);
				if ( dgCntrKnt[i] !=	null)
					model.setDgCntrKnt( dgCntrKnt[i]);
				if ( dcgoKnt[i] !=	null)
					model.setDcgoKnt( dcgoKnt[i]);
				if ( rqstVrfyRsltCd[i] !=	null)
					model.setRqstVrfyRsltCd( rqstVrfyRsltCd[i]);
				if ( rqstVrfyRsltRmk[i] !=	null)
					model.setRqstVrfyRsltRmk( rqstVrfyRsltRmk[i]);
				if ( creUsrId[i] !=	null)
					model.setCreUsrId( creUsrId[i]);
				if ( creDt[i] !=	null)
					model.setCreDt( creDt[i]);
				if ( updUsrId[i] !=	null)
					model.setUpdUsrId( updUsrId[i]);
				if ( updDt[i] !=	null)
					model.setUpdDt( updDt[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getScgVvdDgCgoCxlRqstVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ScgVvdDgCgoCxlRqstVO[]
	 */
	public ScgVvdDgCgoCxlRqstVO[]	 getScgVvdDgCgoCxlRqstVOs(){
		ScgVvdDgCgoCxlRqstVO[] vos = (ScgVvdDgCgoCxlRqstVO[])models.toArray(new	ScgVvdDgCgoCxlRqstVO[models.size()]);
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
		this.bkgNo =	this.bkgNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoCxlRqstSeq =	this.dcgoCxlRqstSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd =	this.polCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq =	this.polClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd =	this.polYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd =	this.podCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq =	this.podClptIndSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd =	this.podYdCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlCgoKndCd =	this.cxlCgoKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlCgoRqstDt =	this.cxlCgoRqstDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlCgoRsn =	this.cxlCgoRsn.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgCntrKnt =	this.dgCntrKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoKnt =	this.dcgoKnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstVrfyRsltCd =	this.rqstVrfyRsltCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstVrfyRsltRmk =	this.rqstVrfyRsltRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}