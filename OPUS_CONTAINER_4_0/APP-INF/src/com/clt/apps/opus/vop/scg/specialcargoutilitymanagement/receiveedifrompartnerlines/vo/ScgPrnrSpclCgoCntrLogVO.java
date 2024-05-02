/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScgPrnrSpclCgoCntrLogVO.java
 *@FileTitle : ScgPrnrSpclCgoCntrLogVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.27
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.11.27 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.vo;

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
public class ScgPrnrSpclCgoCntrLogVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ScgPrnrSpclCgoCntrLogVO>  models =	new	ArrayList<ScgPrnrSpclCgoCntrLogVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String trsmBndCd = null;
	/*	Column Info	*/
	private String trsmDt = null;
	/*	Column Info	*/
	private String spclCgoCateCd = null;
	/*	Column Info	*/
	private String prnrSpclCgoSeq = null;
	/*	Column Info	*/
	private String cntrSeq = null;
	/*	Column Info	*/
	private String cntrRefNo = null;
	/*	Column Info	*/
	private String cntrTpszCdCtnt = null;
	/*	Column Info	*/
	private String isoCntrTpszCd = null;
	/*	Column Info	*/
	private String rsdFlgCtnt = null;
	/*	Column Info	*/
	private String mapgTrsmBndCd = null;
	/*	Column Info	*/
	private String mapgTrsmDt = null;
	/*	Column Info	*/
	private String mapgTrsmSpclCgoCateCd = null;
	/*	Column Info	*/
	private String mapgPrnrSpclCgoSeq = null;
	/*	Column Info	*/
	private String mapgEdiTrsmStsCd = null;
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
	public ScgPrnrSpclCgoCntrLogVO(){}

	public ScgPrnrSpclCgoCntrLogVO(String ibflag,String pagerows,String trsmBndCd,String trsmDt,String spclCgoCateCd,String prnrSpclCgoSeq,String cntrSeq,String cntrRefNo,String cntrTpszCdCtnt,String isoCntrTpszCd,String rsdFlgCtnt,String mapgTrsmBndCd,String mapgTrsmDt,String mapgTrsmSpclCgoCateCd,String mapgPrnrSpclCgoSeq,String mapgEdiTrsmStsCd,String creUsrId,String creDt,String updUsrId,String updDt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.trsmBndCd = trsmBndCd;
		this.trsmDt = trsmDt;
		this.spclCgoCateCd = spclCgoCateCd;
		this.prnrSpclCgoSeq = prnrSpclCgoSeq;
		this.cntrSeq = cntrSeq;
		this.cntrRefNo = cntrRefNo;
		this.cntrTpszCdCtnt = cntrTpszCdCtnt;
		this.isoCntrTpszCd = isoCntrTpszCd;
		this.rsdFlgCtnt = rsdFlgCtnt;
		this.mapgTrsmBndCd = mapgTrsmBndCd;
		this.mapgTrsmDt = mapgTrsmDt;
		this.mapgTrsmSpclCgoCateCd = mapgTrsmSpclCgoCateCd;
		this.mapgPrnrSpclCgoSeq = mapgPrnrSpclCgoSeq;
		this.mapgEdiTrsmStsCd = mapgEdiTrsmStsCd;
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
		this.hashColumns.put("trsm_bnd_cd", getTrsmBndCd());
		this.hashColumns.put("trsm_dt", getTrsmDt());
		this.hashColumns.put("spcl_cgo_cate_cd", getSpclCgoCateCd());
		this.hashColumns.put("prnr_spcl_cgo_seq", getPrnrSpclCgoSeq());
		this.hashColumns.put("cntr_seq", getCntrSeq());
		this.hashColumns.put("cntr_ref_no", getCntrRefNo());
		this.hashColumns.put("cntr_tpsz_cd_ctnt", getCntrTpszCdCtnt());
		this.hashColumns.put("iso_cntr_tpsz_cd", getIsoCntrTpszCd());
		this.hashColumns.put("rsd_flg_ctnt", getRsdFlgCtnt());
		this.hashColumns.put("mapg_trsm_bnd_cd", getMapgTrsmBndCd());
		this.hashColumns.put("mapg_trsm_dt", getMapgTrsmDt());
		this.hashColumns.put("mapg_trsm_spcl_cgo_cate_cd", getMapgTrsmSpclCgoCateCd());
		this.hashColumns.put("mapg_prnr_spcl_cgo_seq", getMapgPrnrSpclCgoSeq());
		this.hashColumns.put("mapg_edi_trsm_sts_cd", getMapgEdiTrsmStsCd());
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
		this.hashFields.put("trsm_bnd_cd", "trsmBndCd");
		this.hashFields.put("trsm_dt", "trsmDt");
		this.hashFields.put("spcl_cgo_cate_cd", "spclCgoCateCd");
		this.hashFields.put("prnr_spcl_cgo_seq", "prnrSpclCgoSeq");
		this.hashFields.put("cntr_seq", "cntrSeq");
		this.hashFields.put("cntr_ref_no", "cntrRefNo");
		this.hashFields.put("cntr_tpsz_cd_ctnt", "cntrTpszCdCtnt");
		this.hashFields.put("iso_cntr_tpsz_cd", "isoCntrTpszCd");
		this.hashFields.put("rsd_flg_ctnt", "rsdFlgCtnt");
		this.hashFields.put("mapg_trsm_bnd_cd", "mapgTrsmBndCd");
		this.hashFields.put("mapg_trsm_dt", "mapgTrsmDt");
		this.hashFields.put("mapg_trsm_spcl_cgo_cate_cd", "mapgTrsmSpclCgoCateCd");
		this.hashFields.put("mapg_prnr_spcl_cgo_seq", "mapgPrnrSpclCgoSeq");
		this.hashFields.put("mapg_edi_trsm_sts_cd", "mapgEdiTrsmStsCd");
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
	 * @return trsmBndCd
	 */
	public	String getTrsmBndCd() {
		return	this.trsmBndCd;
	}

	/**
	 * Column Info
	 * @return trsmDt
	 */
	public	String getTrsmDt() {
		return	this.trsmDt;
	}

	/**
	 * Column Info
	 * @return spclCgoCateCd
	 */
	public	String getSpclCgoCateCd() {
		return	this.spclCgoCateCd;
	}

	/**
	 * Column Info
	 * @return prnrSpclCgoSeq
	 */
	public	String getPrnrSpclCgoSeq() {
		return	this.prnrSpclCgoSeq;
	}

	/**
	 * Column Info
	 * @return cntrSeq
	 */
	public	String getCntrSeq() {
		return	this.cntrSeq;
	}

	/**
	 * Column Info
	 * @return cntrRefNo
	 */
	public	String getCntrRefNo() {
		return	this.cntrRefNo;
	}

	/**
	 * Column Info
	 * @return cntrTpszCdCtnt
	 */
	public	String getCntrTpszCdCtnt() {
		return	this.cntrTpszCdCtnt;
	}

	/**
	 * Column Info
	 * @return isoCntrTpszCd
	 */
	public	String getIsoCntrTpszCd() {
		return	this.isoCntrTpszCd;
	}

	/**
	 * Column Info
	 * @return rsdFlgCtnt
	 */
	public	String getRsdFlgCtnt() {
		return	this.rsdFlgCtnt;
	}

	/**
	 * Column Info
	 * @return mapgTrsmBndCd
	 */
	public	String getMapgTrsmBndCd() {
		return	this.mapgTrsmBndCd;
	}

	/**
	 * Column Info
	 * @return mapgTrsmDt
	 */
	public	String getMapgTrsmDt() {
		return	this.mapgTrsmDt;
	}

	/**
	 * Column Info
	 * @return mapgTrsmSpclCgoCateCd
	 */
	public	String getMapgTrsmSpclCgoCateCd() {
		return	this.mapgTrsmSpclCgoCateCd;
	}

	/**
	 * Column Info
	 * @return mapgPrnrSpclCgoSeq
	 */
	public	String getMapgPrnrSpclCgoSeq() {
		return	this.mapgPrnrSpclCgoSeq;
	}

	/**
	 * Column Info
	 * @return mapgEdiTrsmStsCd
	 */
	public	String getMapgEdiTrsmStsCd() {
		return	this.mapgEdiTrsmStsCd;
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
	 * @param  trsmBndCd
 	 */
	public void	setTrsmBndCd(String trsmBndCd ) {
		this.trsmBndCd =	trsmBndCd;
	}
 	/**
	 * Column Info
	 * @param  trsmDt
 	 */
	public void	setTrsmDt(String trsmDt ) {
		this.trsmDt =	trsmDt;
	}
 	/**
	 * Column Info
	 * @param  spclCgoCateCd
 	 */
	public void	setSpclCgoCateCd(String spclCgoCateCd ) {
		this.spclCgoCateCd =	spclCgoCateCd;
	}
 	/**
	 * Column Info
	 * @param  prnrSpclCgoSeq
 	 */
	public void	setPrnrSpclCgoSeq(String prnrSpclCgoSeq ) {
		this.prnrSpclCgoSeq =	prnrSpclCgoSeq;
	}
 	/**
	 * Column Info
	 * @param  cntrSeq
 	 */
	public void	setCntrSeq(String cntrSeq ) {
		this.cntrSeq =	cntrSeq;
	}
 	/**
	 * Column Info
	 * @param  cntrRefNo
 	 */
	public void	setCntrRefNo(String cntrRefNo ) {
		this.cntrRefNo =	cntrRefNo;
	}
 	/**
	 * Column Info
	 * @param  cntrTpszCdCtnt
 	 */
	public void	setCntrTpszCdCtnt(String cntrTpszCdCtnt ) {
		this.cntrTpszCdCtnt =	cntrTpszCdCtnt;
	}
 	/**
	 * Column Info
	 * @param  isoCntrTpszCd
 	 */
	public void	setIsoCntrTpszCd(String isoCntrTpszCd ) {
		this.isoCntrTpszCd =	isoCntrTpszCd;
	}
 	/**
	 * Column Info
	 * @param  rsdFlgCtnt
 	 */
	public void	setRsdFlgCtnt(String rsdFlgCtnt ) {
		this.rsdFlgCtnt =	rsdFlgCtnt;
	}
 	/**
	 * Column Info
	 * @param  mapgTrsmBndCd
 	 */
	public void	setMapgTrsmBndCd(String mapgTrsmBndCd ) {
		this.mapgTrsmBndCd =	mapgTrsmBndCd;
	}
 	/**
	 * Column Info
	 * @param  mapgTrsmDt
 	 */
	public void	setMapgTrsmDt(String mapgTrsmDt ) {
		this.mapgTrsmDt =	mapgTrsmDt;
	}
 	/**
	 * Column Info
	 * @param  mapgTrsmSpclCgoCateCd
 	 */
	public void	setMapgTrsmSpclCgoCateCd(String mapgTrsmSpclCgoCateCd ) {
		this.mapgTrsmSpclCgoCateCd =	mapgTrsmSpclCgoCateCd;
	}
 	/**
	 * Column Info
	 * @param  mapgPrnrSpclCgoSeq
 	 */
	public void	setMapgPrnrSpclCgoSeq(String mapgPrnrSpclCgoSeq ) {
		this.mapgPrnrSpclCgoSeq =	mapgPrnrSpclCgoSeq;
	}
 	/**
	 * Column Info
	 * @param  mapgEdiTrsmStsCd
 	 */
	public void	setMapgEdiTrsmStsCd(String mapgEdiTrsmStsCd ) {
		this.mapgEdiTrsmStsCd =	mapgEdiTrsmStsCd;
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
		setTrsmBndCd(JSPUtil.getParameter(request,	prefix + "trsm_bnd_cd", ""));
		setTrsmDt(JSPUtil.getParameter(request,	prefix + "trsm_dt", ""));
		setSpclCgoCateCd(JSPUtil.getParameter(request,	prefix + "spcl_cgo_cate_cd", ""));
		setPrnrSpclCgoSeq(JSPUtil.getParameter(request,	prefix + "prnr_spcl_cgo_seq", ""));
		setCntrSeq(JSPUtil.getParameter(request,	prefix + "cntr_seq", ""));
		setCntrRefNo(JSPUtil.getParameter(request,	prefix + "cntr_ref_no", ""));
		setCntrTpszCdCtnt(JSPUtil.getParameter(request,	prefix + "cntr_tpsz_cd_ctnt", ""));
		setIsoCntrTpszCd(JSPUtil.getParameter(request,	prefix + "iso_cntr_tpsz_cd", ""));
		setRsdFlgCtnt(JSPUtil.getParameter(request,	prefix + "rsd_flg_ctnt", ""));
		setMapgTrsmBndCd(JSPUtil.getParameter(request,	prefix + "mapg_trsm_bnd_cd", ""));
		setMapgTrsmDt(JSPUtil.getParameter(request,	prefix + "mapg_trsm_dt", ""));
		setMapgTrsmSpclCgoCateCd(JSPUtil.getParameter(request,	prefix + "mapg_trsm_spcl_cgo_cate_cd", ""));
		setMapgPrnrSpclCgoSeq(JSPUtil.getParameter(request,	prefix + "mapg_prnr_spcl_cgo_seq", ""));
		setMapgEdiTrsmStsCd(JSPUtil.getParameter(request,	prefix + "mapg_edi_trsm_sts_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrSpclCgoCntrLogVO[]
	 */
	public ScgPrnrSpclCgoCntrLogVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ScgPrnrSpclCgoCntrLogVO[]
	 */
	public ScgPrnrSpclCgoCntrLogVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ScgPrnrSpclCgoCntrLogVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] trsmBndCd =	(JSPUtil.getParameter(request, prefix +	"trsm_bnd_cd",	length));
			String[] trsmDt =	(JSPUtil.getParameter(request, prefix +	"trsm_dt",	length));
			String[] spclCgoCateCd =	(JSPUtil.getParameter(request, prefix +	"spcl_cgo_cate_cd",	length));
			String[] prnrSpclCgoSeq =	(JSPUtil.getParameter(request, prefix +	"prnr_spcl_cgo_seq",	length));
			String[] cntrSeq =	(JSPUtil.getParameter(request, prefix +	"cntr_seq",	length));
			String[] cntrRefNo =	(JSPUtil.getParameter(request, prefix +	"cntr_ref_no",	length));
			String[] cntrTpszCdCtnt =	(JSPUtil.getParameter(request, prefix +	"cntr_tpsz_cd_ctnt",	length));
			String[] isoCntrTpszCd =	(JSPUtil.getParameter(request, prefix +	"iso_cntr_tpsz_cd",	length));
			String[] rsdFlgCtnt =	(JSPUtil.getParameter(request, prefix +	"rsd_flg_ctnt",	length));
			String[] mapgTrsmBndCd =	(JSPUtil.getParameter(request, prefix +	"mapg_trsm_bnd_cd",	length));
			String[] mapgTrsmDt =	(JSPUtil.getParameter(request, prefix +	"mapg_trsm_dt",	length));
			String[] mapgTrsmSpclCgoCateCd =	(JSPUtil.getParameter(request, prefix +	"mapg_trsm_spcl_cgo_cate_cd",	length));
			String[] mapgPrnrSpclCgoSeq =	(JSPUtil.getParameter(request, prefix +	"mapg_prnr_spcl_cgo_seq",	length));
			String[] mapgEdiTrsmStsCd =	(JSPUtil.getParameter(request, prefix +	"mapg_edi_trsm_sts_cd",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	ScgPrnrSpclCgoCntrLogVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( trsmBndCd[i] !=	null)
					model.setTrsmBndCd( trsmBndCd[i]);
				if ( trsmDt[i] !=	null)
					model.setTrsmDt( trsmDt[i]);
				if ( spclCgoCateCd[i] !=	null)
					model.setSpclCgoCateCd( spclCgoCateCd[i]);
				if ( prnrSpclCgoSeq[i] !=	null)
					model.setPrnrSpclCgoSeq( prnrSpclCgoSeq[i]);
				if ( cntrSeq[i] !=	null)
					model.setCntrSeq( cntrSeq[i]);
				if ( cntrRefNo[i] !=	null)
					model.setCntrRefNo( cntrRefNo[i]);
				if ( cntrTpszCdCtnt[i] !=	null)
					model.setCntrTpszCdCtnt( cntrTpszCdCtnt[i]);
				if ( isoCntrTpszCd[i] !=	null)
					model.setIsoCntrTpszCd( isoCntrTpszCd[i]);
				if ( rsdFlgCtnt[i] !=	null)
					model.setRsdFlgCtnt( rsdFlgCtnt[i]);
				if ( mapgTrsmBndCd[i] !=	null)
					model.setMapgTrsmBndCd( mapgTrsmBndCd[i]);
				if ( mapgTrsmDt[i] !=	null)
					model.setMapgTrsmDt( mapgTrsmDt[i]);
				if ( mapgTrsmSpclCgoCateCd[i] !=	null)
					model.setMapgTrsmSpclCgoCateCd( mapgTrsmSpclCgoCateCd[i]);
				if ( mapgPrnrSpclCgoSeq[i] !=	null)
					model.setMapgPrnrSpclCgoSeq( mapgPrnrSpclCgoSeq[i]);
				if ( mapgEdiTrsmStsCd[i] !=	null)
					model.setMapgEdiTrsmStsCd( mapgEdiTrsmStsCd[i]);
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
		return getScgPrnrSpclCgoCntrLogVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ScgPrnrSpclCgoCntrLogVO[]
	 */
	public ScgPrnrSpclCgoCntrLogVO[]	 getScgPrnrSpclCgoCntrLogVOs(){
		ScgPrnrSpclCgoCntrLogVO[] vos = (ScgPrnrSpclCgoCntrLogVO[])models.toArray(new	ScgPrnrSpclCgoCntrLogVO[models.size()]);
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
		this.trsmBndCd =	this.trsmBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trsmDt =	this.trsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoCateCd =	this.spclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prnrSpclCgoSeq =	this.prnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSeq =	this.cntrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrRefNo =	this.cntrRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCdCtnt =	this.cntrTpszCdCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.isoCntrTpszCd =	this.isoCntrTpszCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rsdFlgCtnt =	this.rsdFlgCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgTrsmBndCd =	this.mapgTrsmBndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgTrsmDt =	this.mapgTrsmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgTrsmSpclCgoCateCd =	this.mapgTrsmSpclCgoCateCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgPrnrSpclCgoSeq =	this.mapgPrnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mapgEdiTrsmStsCd =	this.mapgEdiTrsmStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}