/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : DgEdiFltFileVO.java
 *@FileTitle : DgEdiFltFileVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.05
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2014.12.05 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.scg.scgcommon.scgutileai.vo;

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
public class DgEdiFltFileVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<DgEdiFltFileVO>  models =	new	ArrayList<DgEdiFltFileVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String trsmBndCd = null;
	/*	Column Info	*/
	private String prnrSpclCgoSeq = null;
	/*	Column Info	*/
	private String bkgRefNo = null;
	/*	Column Info	*/
	private String fltFileDatCtnt = null;
	/*	Column Info	*/
	private String exptMsg = null;
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
	public DgEdiFltFileVO(){}

	public DgEdiFltFileVO(String ibflag,String pagerows,String trsmBndCd,String prnrSpclCgoSeq,String bkgRefNo,String fltFileDatCtnt,String exptMsg,String creUsrId,String creDt,String updUsrId,String updDt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.trsmBndCd = trsmBndCd;
		this.prnrSpclCgoSeq = prnrSpclCgoSeq;
		this.bkgRefNo = bkgRefNo;
		this.fltFileDatCtnt = fltFileDatCtnt;
		this.exptMsg = exptMsg;
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
		this.hashColumns.put("prnr_spcl_cgo_seq", getPrnrSpclCgoSeq());
		this.hashColumns.put("bkg_ref_no", getBkgRefNo());
		this.hashColumns.put("flt_file_dat_ctnt", getFltFileDatCtnt());
		this.hashColumns.put("expt_msg", getExptMsg());
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
		this.hashFields.put("prnr_spcl_cgo_seq", "prnrSpclCgoSeq");
		this.hashFields.put("bkg_ref_no", "bkgRefNo");
		this.hashFields.put("flt_file_dat_ctnt", "fltFileDatCtnt");
		this.hashFields.put("expt_msg", "exptMsg");
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
	 * @return prnrSpclCgoSeq
	 */
	public	String getPrnrSpclCgoSeq() {
		return	this.prnrSpclCgoSeq;
	}

	/**
	 * Column Info
	 * @return bkgRefNo
	 */
	public	String getBkgRefNo() {
		return	this.bkgRefNo;
	}

	/**
	 * Column Info
	 * @return fltFileDatCtnt
	 */
	public	String getFltFileDatCtnt() {
		return	this.fltFileDatCtnt;
	}

	/**
	 * Column Info
	 * @return exptMsg
	 */
	public	String getExptMsg() {
		return	this.exptMsg;
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
	 * @param  prnrSpclCgoSeq
 	 */
	public void	setPrnrSpclCgoSeq(String prnrSpclCgoSeq ) {
		this.prnrSpclCgoSeq =	prnrSpclCgoSeq;
	}
 	/**
	 * Column Info
	 * @param  bkgRefNo
 	 */
	public void	setBkgRefNo(String bkgRefNo ) {
		this.bkgRefNo =	bkgRefNo;
	}
 	/**
	 * Column Info
	 * @param  fltFileDatCtnt
 	 */
	public void	setFltFileDatCtnt(String fltFileDatCtnt ) {
		this.fltFileDatCtnt =	fltFileDatCtnt;
	}
 	/**
	 * Column Info
	 * @param  exptMsg
 	 */
	public void	setExptMsg(String exptMsg ) {
		this.exptMsg =	exptMsg;
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
		setPrnrSpclCgoSeq(JSPUtil.getParameter(request,	prefix + "prnr_spcl_cgo_seq", ""));
		setBkgRefNo(JSPUtil.getParameter(request,	prefix + "bkg_ref_no", ""));
		setFltFileDatCtnt(JSPUtil.getParameter(request,	prefix + "flt_file_dat_ctnt", ""));
		setExptMsg(JSPUtil.getParameter(request,	prefix + "expt_msg", ""));
		setCreUsrId(JSPUtil.getParameter(request,	prefix + "cre_usr_id", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setUpdUsrId(JSPUtil.getParameter(request,	prefix + "upd_usr_id", ""));
		setUpdDt(JSPUtil.getParameter(request,	prefix + "upd_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgEdiFltFileVO[]
	 */
	public DgEdiFltFileVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return DgEdiFltFileVO[]
	 */
	public DgEdiFltFileVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		DgEdiFltFileVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] trsmBndCd =	(JSPUtil.getParameter(request, prefix +	"trsm_bnd_cd",	length));
			String[] prnrSpclCgoSeq =	(JSPUtil.getParameter(request, prefix +	"prnr_spcl_cgo_seq",	length));
			String[] bkgRefNo =	(JSPUtil.getParameter(request, prefix +	"bkg_ref_no",	length));
			String[] fltFileDatCtnt =	(JSPUtil.getParameter(request, prefix +	"flt_file_dat_ctnt",	length));
			String[] exptMsg =	(JSPUtil.getParameter(request, prefix +	"expt_msg",	length));
			String[] creUsrId =	(JSPUtil.getParameter(request, prefix +	"cre_usr_id",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] updUsrId =	(JSPUtil.getParameter(request, prefix +	"upd_usr_id",	length));
			String[] updDt =	(JSPUtil.getParameter(request, prefix +	"upd_dt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	DgEdiFltFileVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( trsmBndCd[i] !=	null)
					model.setTrsmBndCd( trsmBndCd[i]);
				if ( prnrSpclCgoSeq[i] !=	null)
					model.setPrnrSpclCgoSeq( prnrSpclCgoSeq[i]);
				if ( bkgRefNo[i] !=	null)
					model.setBkgRefNo( bkgRefNo[i]);
				if ( fltFileDatCtnt[i] !=	null)
					model.setFltFileDatCtnt( fltFileDatCtnt[i]);
				if ( exptMsg[i] !=	null)
					model.setExptMsg( exptMsg[i]);
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
		return getDgEdiFltFileVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return DgEdiFltFileVO[]
	 */
	public DgEdiFltFileVO[]	 getDgEdiFltFileVOs(){
		DgEdiFltFileVO[] vos = (DgEdiFltFileVO[])models.toArray(new	DgEdiFltFileVO[models.size()]);
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
		this.prnrSpclCgoSeq =	this.prnrSpclCgoSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRefNo =	this.bkgRefNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fltFileDatCtnt =	this.fltFileDatCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.exptMsg =	this.exptMsg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId =	this.creUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId =	this.updUsrId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt =	this.updDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}