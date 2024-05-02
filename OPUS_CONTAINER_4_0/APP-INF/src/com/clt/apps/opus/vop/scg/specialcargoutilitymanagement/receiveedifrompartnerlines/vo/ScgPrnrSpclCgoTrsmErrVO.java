/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : ScgPrnrSpclCgoTrsmErrVO.java
 *@FileTitle : ScgPrnrSpclCgoTrsmErrVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.11.21
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.11.21 dongsoo 
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
public class ScgPrnrSpclCgoTrsmErrVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<ScgPrnrSpclCgoTrsmErrVO>  models =	new	ArrayList<ScgPrnrSpclCgoTrsmErrVO>();
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
	private String errDtlSeq = null;
	/*	Column Info	*/
	private String errKndCd = null;
	/*	Column Info	*/
	private String errDtlCd = null;
	/*	Column Info	*/
	private String apErrCd = null;
	/*	Column Info	*/
	private String errDtlRmk = null;
	/*	Column Info	*/
	private String errLvl = null;
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
	public ScgPrnrSpclCgoTrsmErrVO(){}

	public ScgPrnrSpclCgoTrsmErrVO(String ibflag,String pagerows,String trsmBndCd,String trsmDt,String spclCgoCateCd,String prnrSpclCgoSeq,String errDtlSeq,String errKndCd,String errDtlCd,String apErrCd,String errDtlRmk,String errLvl,String creUsrId,String creDt,String updUsrId,String updDt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.trsmBndCd = trsmBndCd;
		this.trsmDt = trsmDt;
		this.spclCgoCateCd = spclCgoCateCd;
		this.prnrSpclCgoSeq = prnrSpclCgoSeq;
		this.errDtlSeq = errDtlSeq;
		this.errKndCd = errKndCd;
		this.errDtlCd = errDtlCd;
		this.apErrCd = apErrCd;
		this.errDtlRmk = errDtlRmk;
		this.errLvl = errLvl;
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
		this.hashColumns.put("err_dtl_seq", getErrDtlSeq());
		this.hashColumns.put("err_knd_cd", getErrKndCd());
		this.hashColumns.put("err_dtl_cd", getErrDtlCd());
		this.hashColumns.put("ap_err_cd", getApErrCd());
		this.hashColumns.put("err_dtl_rmk", getErrDtlRmk());
		this.hashColumns.put("err_lvl", getErrLvl());
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
		this.hashFields.put("err_dtl_seq", "errDtlSeq");
		this.hashFields.put("err_knd_cd", "errKndCd");
		this.hashFields.put("err_dtl_cd", "errDtlCd");
		this.hashFields.put("ap_err_cd", "apErrCd");
		this.hashFields.put("err_dtl_rmk", "errDtlRmk");
		this.hashFields.put("err_lvl", "errLvl");
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
	 * @return errDtlSeq
	 */
	public	String getErrDtlSeq() {
		return	this.errDtlSeq;
	}

	/**
	 * Column Info
	 * @return errKndCd
	 */
	public	String getErrKndCd() {
		return	this.errKndCd;
	}

	/**
	 * Column Info
	 * @return errDtlCd
	 */
	public	String getErrDtlCd() {
		return	this.errDtlCd;
	}

	/**
	 * Column Info
	 * @return apErrCd
	 */
	public	String getApErrCd() {
		return	this.apErrCd;
	}

	/**
	 * Column Info
	 * @return errDtlRmk
	 */
	public	String getErrDtlRmk() {
		return	this.errDtlRmk;
	}

	/**
	 * Column Info
	 * @return errLvl
	 */
	public	String getErrLvl() {
		return	this.errLvl;
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
	 * @param  errDtlSeq
 	 */
	public void	setErrDtlSeq(String errDtlSeq ) {
		this.errDtlSeq =	errDtlSeq;
	}
 	/**
	 * Column Info
	 * @param  errKndCd
 	 */
	public void	setErrKndCd(String errKndCd ) {
		this.errKndCd =	errKndCd;
	}
 	/**
	 * Column Info
	 * @param  errDtlCd
 	 */
	public void	setErrDtlCd(String errDtlCd ) {
		this.errDtlCd =	errDtlCd;
	}
 	/**
	 * Column Info
	 * @param  apErrCd
 	 */
	public void	setApErrCd(String apErrCd ) {
		this.apErrCd =	apErrCd;
	}
 	/**
	 * Column Info
	 * @param  errDtlRmk
 	 */
	public void	setErrDtlRmk(String errDtlRmk ) {
		this.errDtlRmk =	errDtlRmk;
	}
 	/**
	 * Column Info
	 * @param  errLvl
 	 */
	public void	setErrLvl(String errLvl ) {
		this.errLvl =	errLvl;
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
		setErrDtlSeq(JSPUtil.getParameter(request,	prefix + "err_dtl_seq", ""));
		setErrKndCd(JSPUtil.getParameter(request,	prefix + "err_knd_cd", ""));
		setErrDtlCd(JSPUtil.getParameter(request,	prefix + "err_dtl_cd", ""));
		setApErrCd(JSPUtil.getParameter(request,	prefix + "ap_err_cd", ""));
		setErrDtlRmk(JSPUtil.getParameter(request,	prefix + "err_dtl_rmk", ""));
		setErrLvl(JSPUtil.getParameter(request,	prefix + "err_lvl", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScgPrnrSpclCgoTrsmErrVO[]
	 */
	public ScgPrnrSpclCgoTrsmErrVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return ScgPrnrSpclCgoTrsmErrVO[]
	 */
	public ScgPrnrSpclCgoTrsmErrVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		ScgPrnrSpclCgoTrsmErrVO model = null;

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
			String[] errDtlSeq =	(JSPUtil.getParameter(request, prefix +	"err_dtl_seq",	length));
			String[] errKndCd =	(JSPUtil.getParameter(request, prefix +	"err_knd_cd",	length));
			String[] errDtlCd =	(JSPUtil.getParameter(request, prefix +	"err_dtl_cd",	length));
			String[] apErrCd =	(JSPUtil.getParameter(request, prefix +	"ap_err_cd",	length));
			String[] errDtlRmk =	(JSPUtil.getParameter(request, prefix +	"err_dtl_rmk",	length));
			String[] errLvl =	(JSPUtil.getParameter(request, prefix +	"err_lvl",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	ScgPrnrSpclCgoTrsmErrVO();
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
				if ( errDtlSeq[i] !=	null)
					model.setErrDtlSeq( errDtlSeq[i]);
				if ( errKndCd[i] !=	null)
					model.setErrKndCd( errKndCd[i]);
				if ( errDtlCd[i] !=	null)
					model.setErrDtlCd( errDtlCd[i]);
				if ( apErrCd[i] !=	null)
					model.setApErrCd( apErrCd[i]);
				if ( errDtlRmk[i] !=	null)
					model.setErrDtlRmk( errDtlRmk[i]);
				if ( errLvl[i] !=	null)
					model.setErrLvl( errLvl[i]);
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
		return getScgPrnrSpclCgoTrsmErrVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return ScgPrnrSpclCgoTrsmErrVO[]
	 */
	public ScgPrnrSpclCgoTrsmErrVO[]	 getScgPrnrSpclCgoTrsmErrVOs(){
		ScgPrnrSpclCgoTrsmErrVO[] vos = (ScgPrnrSpclCgoTrsmErrVO[])models.toArray(new	ScgPrnrSpclCgoTrsmErrVO[models.size()]);
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
		this.errDtlSeq =	this.errDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errKndCd =	this.errKndCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDtlCd =	this.errDtlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.apErrCd =	this.apErrCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errDtlRmk =	this.errDtlRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.errLvl =	this.errLvl.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}