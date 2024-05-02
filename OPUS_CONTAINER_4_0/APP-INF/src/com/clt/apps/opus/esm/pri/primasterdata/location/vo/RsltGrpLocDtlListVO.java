/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltGrpLocDtlListVO.java
 *@FileTitle : RsltGrpLocDtlListVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.04.16
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2015.04.16 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.primasterdata.location.vo;

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
public class RsltGrpLocDtlListVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltGrpLocDtlListVO>  models =	new	ArrayList<RsltGrpLocDtlListVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String rgnCd = null;
	/*	Column Info	*/
	private String orgDestCd = null;
	/*	Column Info	*/
	private String amdtSeq = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String grpLocSeq = null;
	/*	Column Info	*/
	private String comboGrpLocCd = null;
	/*	Column Info	*/
	private String srcInfoCd = null;
	/*	Column Info	*/
	private String glineSeq = null;
	/*	Column Info	*/
	private String locNm = null;
	/*	Column Info	*/
	private String chgCd = null;
	/*	Column Info	*/
	private String prcProgStsCd = null;
	/*	Column Info	*/
	private String locCd = null;
	/*	Column Info	*/
	private String propNo = null;
	/*	Column Info	*/
	private String creOfcCd = null;
	/*	Column Info	*/
	private String qttnNo = null;
	/*	Column Info	*/
	private String qttnVerNo = null;
	/*	Column Info	*/
	private String grpLocDtlSeq = null;
	/*	Column Info	*/
	private String scontiCd = null;
	/*	Column Info	*/
	private String steCd = null;
	/*	Column Info	*/
	private String cntCd = null;
	/*	Column Info	*/
	private String unLocCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltGrpLocDtlListVO(){}

	public RsltGrpLocDtlListVO(String ibflag,String pagerows,String rgnCd,String orgDestCd,String amdtSeq,String svcScpCd,String grpLocSeq,String comboGrpLocCd,String srcInfoCd,String glineSeq,String locNm,String chgCd,String prcProgStsCd,String locCd,String propNo,String creOfcCd,String qttnNo,String qttnVerNo,String grpLocDtlSeq,String scontiCd,String steCd,String cntCd,String unLocCd)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.rgnCd = rgnCd;
		this.orgDestCd = orgDestCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.grpLocSeq = grpLocSeq;
		this.comboGrpLocCd = comboGrpLocCd;
		this.srcInfoCd = srcInfoCd;
		this.glineSeq = glineSeq;
		this.locNm = locNm;
		this.chgCd = chgCd;
		this.prcProgStsCd = prcProgStsCd;
		this.locCd = locCd;
		this.propNo = propNo;
		this.creOfcCd = creOfcCd;
		this.qttnNo = qttnNo;
		this.qttnVerNo = qttnVerNo;
		this.grpLocDtlSeq = grpLocDtlSeq;
		this.scontiCd = scontiCd;
		this.steCd = steCd;
		this.cntCd = cntCd;
		this.unLocCd = unLocCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rgn_cd", getRgnCd());
		this.hashColumns.put("org_dest_cd", getOrgDestCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("grp_loc_seq", getGrpLocSeq());
		this.hashColumns.put("combo_grp_loc_cd", getComboGrpLocCd());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("gline_seq", getGlineSeq());
		this.hashColumns.put("loc_nm", getLocNm());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("cre_ofc_cd", getCreOfcCd());
		this.hashColumns.put("qttn_no", getQttnNo());
		this.hashColumns.put("qttn_ver_no", getQttnVerNo());
		this.hashColumns.put("grp_loc_dtl_seq", getGrpLocDtlSeq());
		this.hashColumns.put("sconti_cd", getScontiCd());
		this.hashColumns.put("ste_cd", getSteCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("un_loc_cd", getUnLocCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rgn_cd", "rgnCd");
		this.hashFields.put("org_dest_cd", "orgDestCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("grp_loc_seq", "grpLocSeq");
		this.hashFields.put("combo_grp_loc_cd", "comboGrpLocCd");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("gline_seq", "glineSeq");
		this.hashFields.put("loc_nm", "locNm");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("cre_ofc_cd", "creOfcCd");
		this.hashFields.put("qttn_no", "qttnNo");
		this.hashFields.put("qttn_ver_no", "qttnVerNo");
		this.hashFields.put("grp_loc_dtl_seq", "grpLocDtlSeq");
		this.hashFields.put("sconti_cd", "scontiCd");
		this.hashFields.put("ste_cd", "steCd");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("un_loc_cd", "unLocCd");
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
	 * @return rgnCd
	 */
	public	String getRgnCd() {
		return	this.rgnCd;
	}

	/**
	 * Column Info
	 * @return orgDestCd
	 */
	public	String getOrgDestCd() {
		return	this.orgDestCd;
	}

	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public	String getAmdtSeq() {
		return	this.amdtSeq;
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
	 * @return grpLocSeq
	 */
	public	String getGrpLocSeq() {
		return	this.grpLocSeq;
	}

	/**
	 * Column Info
	 * @return comboGrpLocCd
	 */
	public	String getComboGrpLocCd() {
		return	this.comboGrpLocCd;
	}

	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public	String getSrcInfoCd() {
		return	this.srcInfoCd;
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
	 * @return locNm
	 */
	public	String getLocNm() {
		return	this.locNm;
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
	 * @return prcProgStsCd
	 */
	public	String getPrcProgStsCd() {
		return	this.prcProgStsCd;
	}

	/**
	 * Column Info
	 * @return locCd
	 */
	public	String getLocCd() {
		return	this.locCd;
	}

	/**
	 * Column Info
	 * @return propNo
	 */
	public	String getPropNo() {
		return	this.propNo;
	}

	/**
	 * Column Info
	 * @return creOfcCd
	 */
	public	String getCreOfcCd() {
		return	this.creOfcCd;
	}

	/**
	 * Column Info
	 * @return qttnNo
	 */
	public	String getQttnNo() {
		return	this.qttnNo;
	}

	/**
	 * Column Info
	 * @return qttnVerNo
	 */
	public	String getQttnVerNo() {
		return	this.qttnVerNo;
	}

	/**
	 * Column Info
	 * @return grpLocDtlSeq
	 */
	public	String getGrpLocDtlSeq() {
		return	this.grpLocDtlSeq;
	}

	/**
	 * Column Info
	 * @return scontiCd
	 */
	public	String getScontiCd() {
		return	this.scontiCd;
	}

	/**
	 * Column Info
	 * @return steCd
	 */
	public	String getSteCd() {
		return	this.steCd;
	}

	/**
	 * Column Info
	 * @return cntCd
	 */
	public	String getCntCd() {
		return	this.cntCd;
	}

	/**
	 * Column Info
	 * @return unLocCd
	 */
	public	String getUnLocCd() {
		return	this.unLocCd;
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
	 * @param  rgnCd
 	 */
	public void	setRgnCd(String rgnCd ) {
		this.rgnCd =	rgnCd;
	}
 	/**
	 * Column Info
	 * @param  orgDestCd
 	 */
	public void	setOrgDestCd(String orgDestCd ) {
		this.orgDestCd =	orgDestCd;
	}
 	/**
	 * Column Info
	 * @param  amdtSeq
 	 */
	public void	setAmdtSeq(String amdtSeq ) {
		this.amdtSeq =	amdtSeq;
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
	 * @param  grpLocSeq
 	 */
	public void	setGrpLocSeq(String grpLocSeq ) {
		this.grpLocSeq =	grpLocSeq;
	}
 	/**
	 * Column Info
	 * @param  comboGrpLocCd
 	 */
	public void	setComboGrpLocCd(String comboGrpLocCd ) {
		this.comboGrpLocCd =	comboGrpLocCd;
	}
 	/**
	 * Column Info
	 * @param  srcInfoCd
 	 */
	public void	setSrcInfoCd(String srcInfoCd ) {
		this.srcInfoCd =	srcInfoCd;
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
	 * @param  locNm
 	 */
	public void	setLocNm(String locNm ) {
		this.locNm =	locNm;
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
	 * @param  prcProgStsCd
 	 */
	public void	setPrcProgStsCd(String prcProgStsCd ) {
		this.prcProgStsCd =	prcProgStsCd;
	}
 	/**
	 * Column Info
	 * @param  locCd
 	 */
	public void	setLocCd(String locCd ) {
		this.locCd =	locCd;
	}
 	/**
	 * Column Info
	 * @param  propNo
 	 */
	public void	setPropNo(String propNo ) {
		this.propNo =	propNo;
	}
 	/**
	 * Column Info
	 * @param  creOfcCd
 	 */
	public void	setCreOfcCd(String creOfcCd ) {
		this.creOfcCd =	creOfcCd;
	}
 	/**
	 * Column Info
	 * @param  qttnNo
 	 */
	public void	setQttnNo(String qttnNo ) {
		this.qttnNo =	qttnNo;
	}
 	/**
	 * Column Info
	 * @param  qttnVerNo
 	 */
	public void	setQttnVerNo(String qttnVerNo ) {
		this.qttnVerNo =	qttnVerNo;
	}
 	/**
	 * Column Info
	 * @param  grpLocDtlSeq
 	 */
	public void	setGrpLocDtlSeq(String grpLocDtlSeq ) {
		this.grpLocDtlSeq =	grpLocDtlSeq;
	}
 	/**
	 * Column Info
	 * @param  scontiCd
 	 */
	public void	setScontiCd(String scontiCd ) {
		this.scontiCd =	scontiCd;
	}
 	/**
	 * Column Info
	 * @param  steCd
 	 */
	public void	setSteCd(String steCd ) {
		this.steCd =	steCd;
	}
 	/**
	 * Column Info
	 * @param  cntCd
 	 */
	public void	setCntCd(String cntCd ) {
		this.cntCd =	cntCd;
	}
 	/**
	 * Column Info
	 * @param  unLocCd
 	 */
	public void	setUnLocCd(String unLocCd ) {
		this.unLocCd =	unLocCd;
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
		setRgnCd(JSPUtil.getParameter(request,	prefix + "rgn_cd", ""));
		setOrgDestCd(JSPUtil.getParameter(request,	prefix + "org_dest_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request,	prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setGrpLocSeq(JSPUtil.getParameter(request,	prefix + "grp_loc_seq", ""));
		setComboGrpLocCd(JSPUtil.getParameter(request,	prefix + "combo_grp_loc_cd", ""));
		setSrcInfoCd(JSPUtil.getParameter(request,	prefix + "src_info_cd", ""));
		setGlineSeq(JSPUtil.getParameter(request,	prefix + "gline_seq", ""));
		setLocNm(JSPUtil.getParameter(request,	prefix + "loc_nm", ""));
		setChgCd(JSPUtil.getParameter(request,	prefix + "chg_cd", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request,	prefix + "prc_prog_sts_cd", ""));
		setLocCd(JSPUtil.getParameter(request,	prefix + "loc_cd", ""));
		setPropNo(JSPUtil.getParameter(request,	prefix + "prop_no", ""));
		setCreOfcCd(JSPUtil.getParameter(request,	prefix + "cre_ofc_cd", ""));
		setQttnNo(JSPUtil.getParameter(request,	prefix + "qttn_no", ""));
		setQttnVerNo(JSPUtil.getParameter(request,	prefix + "qttn_ver_no", ""));
		setGrpLocDtlSeq(JSPUtil.getParameter(request,	prefix + "grp_loc_dtl_seq", ""));
		setScontiCd(JSPUtil.getParameter(request,	prefix + "sconti_cd", ""));
		setSteCd(JSPUtil.getParameter(request,	prefix + "ste_cd", ""));
		setCntCd(JSPUtil.getParameter(request,	prefix + "cnt_cd", ""));
		setUnLocCd(JSPUtil.getParameter(request,	prefix + "un_loc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltGrpLocDtlListVO[]
	 */
	public RsltGrpLocDtlListVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltGrpLocDtlListVO[]
	 */
	public RsltGrpLocDtlListVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltGrpLocDtlListVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] rgnCd =	(JSPUtil.getParameter(request, prefix +	"rgn_cd",	length));
			String[] orgDestCd =	(JSPUtil.getParameter(request, prefix +	"org_dest_cd",	length));
			String[] amdtSeq =	(JSPUtil.getParameter(request, prefix +	"amdt_seq",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] grpLocSeq =	(JSPUtil.getParameter(request, prefix +	"grp_loc_seq",	length));
			String[] comboGrpLocCd =	(JSPUtil.getParameter(request, prefix +	"combo_grp_loc_cd",	length));
			String[] srcInfoCd =	(JSPUtil.getParameter(request, prefix +	"src_info_cd",	length));
			String[] glineSeq =	(JSPUtil.getParameter(request, prefix +	"gline_seq",	length));
			String[] locNm =	(JSPUtil.getParameter(request, prefix +	"loc_nm",	length));
			String[] chgCd =	(JSPUtil.getParameter(request, prefix +	"chg_cd",	length));
			String[] prcProgStsCd =	(JSPUtil.getParameter(request, prefix +	"prc_prog_sts_cd",	length));
			String[] locCd =	(JSPUtil.getParameter(request, prefix +	"loc_cd",	length));
			String[] propNo =	(JSPUtil.getParameter(request, prefix +	"prop_no",	length));
			String[] creOfcCd =	(JSPUtil.getParameter(request, prefix +	"cre_ofc_cd",	length));
			String[] qttnNo =	(JSPUtil.getParameter(request, prefix +	"qttn_no",	length));
			String[] qttnVerNo =	(JSPUtil.getParameter(request, prefix +	"qttn_ver_no",	length));
			String[] grpLocDtlSeq =	(JSPUtil.getParameter(request, prefix +	"grp_loc_dtl_seq",	length));
			String[] scontiCd =	(JSPUtil.getParameter(request, prefix +	"sconti_cd",	length));
			String[] steCd =	(JSPUtil.getParameter(request, prefix +	"ste_cd",	length));
			String[] cntCd =	(JSPUtil.getParameter(request, prefix +	"cnt_cd",	length));
			String[] unLocCd =	(JSPUtil.getParameter(request, prefix +	"un_loc_cd",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltGrpLocDtlListVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( rgnCd[i] !=	null)
					model.setRgnCd( rgnCd[i]);
				if ( orgDestCd[i] !=	null)
					model.setOrgDestCd( orgDestCd[i]);
				if ( amdtSeq[i] !=	null)
					model.setAmdtSeq( amdtSeq[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( grpLocSeq[i] !=	null)
					model.setGrpLocSeq( grpLocSeq[i]);
				if ( comboGrpLocCd[i] !=	null)
					model.setComboGrpLocCd( comboGrpLocCd[i]);
				if ( srcInfoCd[i] !=	null)
					model.setSrcInfoCd( srcInfoCd[i]);
				if ( glineSeq[i] !=	null)
					model.setGlineSeq( glineSeq[i]);
				if ( locNm[i] !=	null)
					model.setLocNm( locNm[i]);
				if ( chgCd[i] !=	null)
					model.setChgCd( chgCd[i]);
				if ( prcProgStsCd[i] !=	null)
					model.setPrcProgStsCd( prcProgStsCd[i]);
				if ( locCd[i] !=	null)
					model.setLocCd( locCd[i]);
				if ( propNo[i] !=	null)
					model.setPropNo( propNo[i]);
				if ( creOfcCd[i] !=	null)
					model.setCreOfcCd( creOfcCd[i]);
				if ( qttnNo[i] !=	null)
					model.setQttnNo( qttnNo[i]);
				if ( qttnVerNo[i] !=	null)
					model.setQttnVerNo( qttnVerNo[i]);
				if ( grpLocDtlSeq[i] !=	null)
					model.setGrpLocDtlSeq( grpLocDtlSeq[i]);
				if ( scontiCd[i] !=	null)
					model.setScontiCd( scontiCd[i]);
				if ( steCd[i] !=	null)
					model.setSteCd( steCd[i]);
				if ( cntCd[i] !=	null)
					model.setCntCd( cntCd[i]);
				if ( unLocCd[i] !=	null)
					model.setUnLocCd( unLocCd[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltGrpLocDtlListVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltGrpLocDtlListVO[]
	 */
	public RsltGrpLocDtlListVO[]	 getRsltGrpLocDtlListVOs(){
		RsltGrpLocDtlListVO[] vos = (RsltGrpLocDtlListVO[])models.toArray(new	RsltGrpLocDtlListVO[models.size()]);
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
		this.rgnCd =	this.rgnCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestCd =	this.orgDestCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq =	this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLocSeq =	this.grpLocSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.comboGrpLocCd =	this.comboGrpLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd =	this.srcInfoCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.glineSeq =	this.glineSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locNm =	this.locNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd =	this.chgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd =	this.prcProgStsCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd =	this.locCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo =	this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creOfcCd =	this.creOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnNo =	this.qttnNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qttnVerNo =	this.qttnVerNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpLocDtlSeq =	this.grpLocDtlSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontiCd =	this.scontiCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.steCd =	this.steCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd =	this.cntCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unLocCd =	this.unLocCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}