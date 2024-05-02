/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : VvdPortLaneOtherVO.java
 *@FileTitle : VvdPortLaneOtherVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.03.17
 *@LastModifier : dongsoo
 *@LastVersion : 1.0
 * 2015.03.17 dongsoo 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo;

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
public class VvdPortLaneOtherVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<VvdPortLaneOtherVO>  models =	new	ArrayList<VvdPortLaneOtherVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String vslCd = null;
	/*	Column Info	*/
	private String subTrdDirCd = null;
	/*	Column Info	*/
	private String vskdTpCd = null;
	/*	Column Info	*/
	private String fmDt = null;
	/*	Column Info	*/
	private String actInpYrmon = null;
	/*	Column Info	*/
	private String skdVoyNo = null;
	/*	Column Info	*/
	private String vslSlanCd = null;
	/*	Column Info	*/
	private String vpsEtaDt = null;
	/*	Column Info	*/
	private String vskdCngTpCd = null;
	/*	Column Info	*/
	private String skdDirCd = null;
	/*	Column Info	*/
	private String toDt = null;
	/*	Column Info	*/
	private String vpsPortCd = null;
	/*	Column Info	*/
	private String diffRmk = null;
	/*	Column Info	*/
	private String ctrlCd = null;
	/*	Column Info	*/
	private String ibCssmVoyNo = null;
	/*	Column Info	*/
	private String obCssmVoyNo = null;
	
	private String bkgAtchFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public VvdPortLaneOtherVO(){}

	public VvdPortLaneOtherVO(String ibflag,String pagerows,String vslCd,String subTrdDirCd,String vskdTpCd,String fmDt,String actInpYrmon,String skdVoyNo,String vslSlanCd,String vpsEtaDt,String vskdCngTpCd,String skdDirCd,String toDt,String vpsPortCd,String diffRmk,String ctrlCd,String ibCssmVoyNo,String obCssmVoyNo, String bkgAtchFlg)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.vslCd = vslCd;
		this.subTrdDirCd = subTrdDirCd;
		this.vskdTpCd = vskdTpCd;
		this.fmDt = fmDt;
		this.actInpYrmon = actInpYrmon;
		this.skdVoyNo = skdVoyNo;
		this.vslSlanCd = vslSlanCd;
		this.vpsEtaDt = vpsEtaDt;
		this.vskdCngTpCd = vskdCngTpCd;
		this.skdDirCd = skdDirCd;
		this.toDt = toDt;
		this.vpsPortCd = vpsPortCd;
		this.diffRmk = diffRmk;
		this.ctrlCd = ctrlCd;
		this.ibCssmVoyNo = ibCssmVoyNo;
		this.obCssmVoyNo = obCssmVoyNo;
		this.bkgAtchFlg = bkgAtchFlg;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("sub_trd_dir_cd", getSubTrdDirCd());
		this.hashColumns.put("vskd_tp_cd", getVskdTpCd());
		this.hashColumns.put("fm_dt", getFmDt());
		this.hashColumns.put("act_inp_yrmon", getActInpYrmon());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vsl_slan_cd", getVslSlanCd());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("vskd_cng_tp_cd", getVskdCngTpCd());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("diff_rmk", getDiffRmk());
		this.hashColumns.put("ctrl_cd", getCtrlCd());
		this.hashColumns.put("ib_cssm_voy_no", getIbCssmVoyNo());
		this.hashColumns.put("ob_cssm_voy_no", getObCssmVoyNo());
		this.hashColumns.put("bkg_atch_flg", getBkgAtchFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("sub_trd_dir_cd", "subTrdDirCd");
		this.hashFields.put("vskd_tp_cd", "vskdTpCd");
		this.hashFields.put("fm_dt", "fmDt");
		this.hashFields.put("act_inp_yrmon", "actInpYrmon");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vsl_slan_cd", "vslSlanCd");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("vskd_cng_tp_cd", "vskdCngTpCd");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("diff_rmk", "diffRmk");
		this.hashFields.put("ctrl_cd", "ctrlCd");
		this.hashFields.put("ib_cssm_voy_no", "ibCssmVoyNo");
		this.hashFields.put("ob_cssm_voy_no", "obCssmVoyNo");
		this.hashFields.put("bkg_atch_flg", "bkgAtchFlg");
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
	 * @return vslCd
	 */
	public	String getVslCd() {
		return	this.vslCd;
	}

	/**
	 * Column Info
	 * @return subTrdDirCd
	 */
	public	String getSubTrdDirCd() {
		return	this.subTrdDirCd;
	}

	/**
	 * Column Info
	 * @return vskdTpCd
	 */
	public	String getVskdTpCd() {
		return	this.vskdTpCd;
	}

	/**
	 * Column Info
	 * @return fmDt
	 */
	public	String getFmDt() {
		return	this.fmDt;
	}

	/**
	 * Column Info
	 * @return actInpYrmon
	 */
	public	String getActInpYrmon() {
		return	this.actInpYrmon;
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
	 * @return vslSlanCd
	 */
	public	String getVslSlanCd() {
		return	this.vslSlanCd;
	}

	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public	String getVpsEtaDt() {
		return	this.vpsEtaDt;
	}

	/**
	 * Column Info
	 * @return vskdCngTpCd
	 */
	public	String getVskdCngTpCd() {
		return	this.vskdCngTpCd;
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
	 * @return toDt
	 */
	public	String getToDt() {
		return	this.toDt;
	}

	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public	String getVpsPortCd() {
		return	this.vpsPortCd;
	}

	/**
	 * Column Info
	 * @return diffRmk
	 */
	public	String getDiffRmk() {
		return	this.diffRmk;
	}

	/**
	 * Column Info
	 * @return ctrlCd
	 */
	public	String getCtrlCd() {
		return	this.ctrlCd;
	}

	/**
	 * Column Info
	 * @return ibCssmVoyNo
	 */
	public	String getIbCssmVoyNo() {
		return	this.ibCssmVoyNo;
	}

	/**
	 * Column Info
	 * @return obCssmVoyNo
	 */
	public	String getObCssmVoyNo() {
		return	this.obCssmVoyNo;
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
	 * @param  vslCd
 	 */
	public void	setVslCd(String vslCd ) {
		this.vslCd =	vslCd;
	}
 	/**
	 * Column Info
	 * @param  subTrdDirCd
 	 */
	public void	setSubTrdDirCd(String subTrdDirCd ) {
		this.subTrdDirCd =	subTrdDirCd;
	}
 	/**
	 * Column Info
	 * @param  vskdTpCd
 	 */
	public void	setVskdTpCd(String vskdTpCd ) {
		this.vskdTpCd =	vskdTpCd;
	}
 	/**
	 * Column Info
	 * @param  fmDt
 	 */
	public void	setFmDt(String fmDt ) {
		this.fmDt =	fmDt;
	}
 	/**
	 * Column Info
	 * @param  actInpYrmon
 	 */
	public void	setActInpYrmon(String actInpYrmon ) {
		this.actInpYrmon =	actInpYrmon;
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
	 * @param  vslSlanCd
 	 */
	public void	setVslSlanCd(String vslSlanCd ) {
		this.vslSlanCd =	vslSlanCd;
	}
 	/**
	 * Column Info
	 * @param  vpsEtaDt
 	 */
	public void	setVpsEtaDt(String vpsEtaDt ) {
		this.vpsEtaDt =	vpsEtaDt;
	}
 	/**
	 * Column Info
	 * @param  vskdCngTpCd
 	 */
	public void	setVskdCngTpCd(String vskdCngTpCd ) {
		this.vskdCngTpCd =	vskdCngTpCd;
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
	 * @param  toDt
 	 */
	public void	setToDt(String toDt ) {
		this.toDt =	toDt;
	}
 	/**
	 * Column Info
	 * @param  vpsPortCd
 	 */
	public void	setVpsPortCd(String vpsPortCd ) {
		this.vpsPortCd =	vpsPortCd;
	}
 	/**
	 * Column Info
	 * @param  diffRmk
 	 */
	public void	setDiffRmk(String diffRmk ) {
		this.diffRmk =	diffRmk;
	}
 	/**
	 * Column Info
	 * @param  ctrlCd
 	 */
	public void	setCtrlCd(String ctrlCd ) {
		this.ctrlCd =	ctrlCd;
	}
 	/**
	 * Column Info
	 * @param  ibCssmVoyNo
 	 */
	public void	setIbCssmVoyNo(String ibCssmVoyNo ) {
		this.ibCssmVoyNo =	ibCssmVoyNo;
	}
 	/**
	 * Column Info
	 * @param  obCssmVoyNo
 	 */
	public void	setObCssmVoyNo(String obCssmVoyNo ) {
		this.obCssmVoyNo =	obCssmVoyNo;
	}

	public String getBkgAtchFlg() {
		return bkgAtchFlg;
	}

	public void setBkgAtchFlg(String bkgAtchFlg) {
		this.bkgAtchFlg = bkgAtchFlg;
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
		setVslCd(JSPUtil.getParameter(request,	prefix + "vsl_cd", ""));
		setSubTrdDirCd(JSPUtil.getParameter(request,	prefix + "sub_trd_dir_cd", ""));
		setVskdTpCd(JSPUtil.getParameter(request,	prefix + "vskd_tp_cd", ""));
		setFmDt(JSPUtil.getParameter(request,	prefix + "fm_dt", ""));
		setActInpYrmon(JSPUtil.getParameter(request,	prefix + "act_inp_yrmon", ""));
		setSkdVoyNo(JSPUtil.getParameter(request,	prefix + "skd_voy_no", ""));
		setVslSlanCd(JSPUtil.getParameter(request,	prefix + "vsl_slan_cd", ""));
		setVpsEtaDt(JSPUtil.getParameter(request,	prefix + "vps_eta_dt", ""));
		setVskdCngTpCd(JSPUtil.getParameter(request,	prefix + "vskd_cng_tp_cd", ""));
		setSkdDirCd(JSPUtil.getParameter(request,	prefix + "skd_dir_cd", ""));
		setToDt(JSPUtil.getParameter(request,	prefix + "to_dt", ""));
		setVpsPortCd(JSPUtil.getParameter(request,	prefix + "vps_port_cd", ""));
		setDiffRmk(JSPUtil.getParameter(request,	prefix + "diff_rmk", ""));
		setCtrlCd(JSPUtil.getParameter(request,	prefix + "ctrl_cd", ""));
		setIbCssmVoyNo(JSPUtil.getParameter(request,	prefix + "ib_cssm_voy_no", ""));
		setObCssmVoyNo(JSPUtil.getParameter(request,	prefix + "ob_cssm_voy_no", ""));
		setBkgAtchFlg(JSPUtil.getParameter(request,	prefix + "bkg_atch_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VvdPortLaneOtherVO[]
	 */
	public VvdPortLaneOtherVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return VvdPortLaneOtherVO[]
	 */
	public VvdPortLaneOtherVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		VvdPortLaneOtherVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] vslCd =	(JSPUtil.getParameter(request, prefix +	"vsl_cd",	length));
			String[] subTrdDirCd =	(JSPUtil.getParameter(request, prefix +	"sub_trd_dir_cd",	length));
			String[] vskdTpCd =	(JSPUtil.getParameter(request, prefix +	"vskd_tp_cd",	length));
			String[] fmDt =	(JSPUtil.getParameter(request, prefix +	"fm_dt",	length));
			String[] actInpYrmon =	(JSPUtil.getParameter(request, prefix +	"act_inp_yrmon",	length));
			String[] skdVoyNo =	(JSPUtil.getParameter(request, prefix +	"skd_voy_no",	length));
			String[] vslSlanCd =	(JSPUtil.getParameter(request, prefix +	"vsl_slan_cd",	length));
			String[] vpsEtaDt =	(JSPUtil.getParameter(request, prefix +	"vps_eta_dt",	length));
			String[] vskdCngTpCd =	(JSPUtil.getParameter(request, prefix +	"vskd_cng_tp_cd",	length));
			String[] skdDirCd =	(JSPUtil.getParameter(request, prefix +	"skd_dir_cd",	length));
			String[] toDt =	(JSPUtil.getParameter(request, prefix +	"to_dt",	length));
			String[] vpsPortCd =	(JSPUtil.getParameter(request, prefix +	"vps_port_cd",	length));
			String[] diffRmk =	(JSPUtil.getParameter(request, prefix +	"diff_rmk",	length));
			String[] ctrlCd =	(JSPUtil.getParameter(request, prefix +	"ctrl_cd",	length));
			String[] ibCssmVoyNo =	(JSPUtil.getParameter(request, prefix +	"ib_cssm_voy_no",	length));
			String[] obCssmVoyNo =	(JSPUtil.getParameter(request, prefix +	"ob_cssm_voy_no",	length));
			String[] bkgAtchFlg =	(JSPUtil.getParameter(request, prefix +	"bkg_atch_flg",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	VvdPortLaneOtherVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( vslCd[i] !=	null)
					model.setVslCd( vslCd[i]);
				if ( subTrdDirCd[i] !=	null)
					model.setSubTrdDirCd( subTrdDirCd[i]);
				if ( vskdTpCd[i] !=	null)
					model.setVskdTpCd( vskdTpCd[i]);
				if ( fmDt[i] !=	null)
					model.setFmDt( fmDt[i]);
				if ( actInpYrmon[i] !=	null)
					model.setActInpYrmon( actInpYrmon[i]);
				if ( skdVoyNo[i] !=	null)
					model.setSkdVoyNo( skdVoyNo[i]);
				if ( vslSlanCd[i] !=	null)
					model.setVslSlanCd( vslSlanCd[i]);
				if ( vpsEtaDt[i] !=	null)
					model.setVpsEtaDt( vpsEtaDt[i]);
				if ( vskdCngTpCd[i] !=	null)
					model.setVskdCngTpCd( vskdCngTpCd[i]);
				if ( skdDirCd[i] !=	null)
					model.setSkdDirCd( skdDirCd[i]);
				if ( toDt[i] !=	null)
					model.setToDt( toDt[i]);
				if ( vpsPortCd[i] !=	null)
					model.setVpsPortCd( vpsPortCd[i]);
				if ( diffRmk[i] !=	null)
					model.setDiffRmk( diffRmk[i]);
				if ( ctrlCd[i] !=	null)
					model.setCtrlCd( ctrlCd[i]);
				if ( ibCssmVoyNo[i] !=	null)
					model.setIbCssmVoyNo( ibCssmVoyNo[i]);
				if ( obCssmVoyNo[i] !=	null)
					model.setObCssmVoyNo( obCssmVoyNo[i]);
				if( bkgAtchFlg[i] != null)
					model.setBkgAtchFlg( bkgAtchFlg[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getVvdPortLaneOtherVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return VvdPortLaneOtherVO[]
	 */
	public VvdPortLaneOtherVO[]	 getVvdPortLaneOtherVOs(){
		VvdPortLaneOtherVO[] vos = (VvdPortLaneOtherVO[])models.toArray(new	VvdPortLaneOtherVO[models.size()]);
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
		this.vslCd =	this.vslCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdDirCd =	this.subTrdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdTpCd =	this.vskdTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmDt =	this.fmDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actInpYrmon =	this.actInpYrmon.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo =	this.skdVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslSlanCd =	this.vslSlanCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt =	this.vpsEtaDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vskdCngTpCd =	this.vskdCngTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd =	this.skdDirCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt =	this.toDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd =	this.vpsPortCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.diffRmk =	this.diffRmk.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlCd =	this.ctrlCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibCssmVoyNo =	this.ibCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obCssmVoyNo =	this.obCssmVoyNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgAtchFlg =	this.bkgAtchFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}