/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PriCntrSrhCondVO.java
 *@FileTitle : PriCntrSrhCondVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.12.11
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2014.12.11 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.prisimulation.prisimulation.vo;

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
public class PriCntrSrhCondVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PriCntrSrhCondVO>  models =	new	ArrayList<PriCntrSrhCondVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String ssvcScpCd = null;
	/*	Column Info	*/
	private String seffDt = null;
	/*	Column Info	*/
	private String scontractNo = null;
	/*	Column Info	*/
	private String sroutPntLocDefCdOri = null;
	/*	Column Info	*/
	private String sroutViaPortDefCdOri = null;
	/*	Column Info	*/
	private String sroutViaPortDefCdDest = null;
	/*	Column Info	*/
	private String sroutPntLocDefCdDest = null;
	/*	Column Info	*/
	private String sctrtCust = null;
	/*	Column Info	*/
	private String sctrtCustSeq = null;
	/*	Column Info	*/
	private String scust = null;
	/*	Column Info	*/
	private String scustSeq = null;
	/*	Column Info	*/
	private String sprcCgoTpCd = null;
	/*	Column Info	*/
	private String spropScpSrepCd = null;
	/*	Column Info	*/
	private String spropScpOfcCd = null;
	/*	Column Info	*/
	private String sprcCtrtCustTpCd = null;
	/*	Column Info	*/
	private String sContractType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public PriCntrSrhCondVO(){}

	public PriCntrSrhCondVO(String ibflag,String pagerows,String ssvcScpCd,String seffDt,String scontractNo,String sroutPntLocDefCdOri,String sroutViaPortDefCdOri,String sroutViaPortDefCdDest,String sroutPntLocDefCdDest,String sctrtCust,String sctrtCustSeq,String scust,String scustSeq,String sprcCgoTpCd,String spropScpSrepCd,String spropScpOfcCd,String sprcCtrtCustTpCd,String sContractType)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.ssvcScpCd = ssvcScpCd;
		this.seffDt = seffDt;
		this.scontractNo = scontractNo;
		this.sroutPntLocDefCdOri = sroutPntLocDefCdOri;
		this.sroutViaPortDefCdOri = sroutViaPortDefCdOri;
		this.sroutViaPortDefCdDest = sroutViaPortDefCdDest;
		this.sroutPntLocDefCdDest = sroutPntLocDefCdDest;
		this.sctrtCust = sctrtCust;
		this.sctrtCustSeq = sctrtCustSeq;
		this.scust = scust;
		this.scustSeq = scustSeq;
		this.sprcCgoTpCd = sprcCgoTpCd;
		this.spropScpSrepCd = spropScpSrepCd;
		this.spropScpOfcCd = spropScpOfcCd;
		this.sprcCtrtCustTpCd = sprcCtrtCustTpCd;
		this.sContractType = sContractType;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ssvc_scp_cd", getSsvcScpCd());
		this.hashColumns.put("seff_dt", getSeffDt());
		this.hashColumns.put("scontract_no", getScontractNo());
		this.hashColumns.put("srout_pnt_loc_def_cd_ori", getSroutPntLocDefCdOri());
		this.hashColumns.put("srout_via_port_def_cd_ori", getSroutViaPortDefCdOri());
		this.hashColumns.put("srout_via_port_def_cd_dest", getSroutViaPortDefCdDest());
		this.hashColumns.put("srout_pnt_loc_def_cd_dest", getSroutPntLocDefCdDest());
		this.hashColumns.put("sctrt_cust", getSctrtCust());
		this.hashColumns.put("sctrt_cust_seq", getSctrtCustSeq());
		this.hashColumns.put("scust", getScust());
		this.hashColumns.put("scust_seq", getScustSeq());
		this.hashColumns.put("sprc_cgo_tp_cd", getSprcCgoTpCd());
		this.hashColumns.put("sprop_scp_srep_cd", getSpropScpSrepCd());
		this.hashColumns.put("sprop_scp_ofc_cd", getSpropScpOfcCd());
		this.hashColumns.put("sprc_ctrt_cust_tp_cd", getSprcCtrtCustTpCd());
		this.hashColumns.put("s_contract_type", getSContractType());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ssvc_scp_cd", "ssvcScpCd");
		this.hashFields.put("seff_dt", "seffDt");
		this.hashFields.put("scontract_no", "scontractNo");
		this.hashFields.put("srout_pnt_loc_def_cd_ori", "sroutPntLocDefCdOri");
		this.hashFields.put("srout_via_port_def_cd_ori", "sroutViaPortDefCdOri");
		this.hashFields.put("srout_via_port_def_cd_dest", "sroutViaPortDefCdDest");
		this.hashFields.put("srout_pnt_loc_def_cd_dest", "sroutPntLocDefCdDest");
		this.hashFields.put("sctrt_cust", "sctrtCust");
		this.hashFields.put("sctrt_cust_seq", "sctrtCustSeq");
		this.hashFields.put("scust", "scust");
		this.hashFields.put("scust_seq", "scustSeq");
		this.hashFields.put("sprc_cgo_tp_cd", "sprcCgoTpCd");
		this.hashFields.put("sprop_scp_srep_cd", "spropScpSrepCd");
		this.hashFields.put("sprop_scp_ofc_cd", "spropScpOfcCd");
		this.hashFields.put("sprc_ctrt_cust_tp_cd", "sprcCtrtCustTpCd");
		this.hashFields.put("s_contract_type", "sContractType");
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
	 * @return ssvcScpCd
	 */
	public	String getSsvcScpCd() {
		return	this.ssvcScpCd;
	}

	/**
	 * Column Info
	 * @return seffDt
	 */
	public	String getSeffDt() {
		return	this.seffDt;
	}

	/**
	 * Column Info
	 * @return scontractNo
	 */
	public	String getScontractNo() {
		return	this.scontractNo;
	}

	/**
	 * Column Info
	 * @return sroutPntLocDefCdOri
	 */
	public	String getSroutPntLocDefCdOri() {
		return	this.sroutPntLocDefCdOri;
	}

	/**
	 * Column Info
	 * @return sroutViaPortDefCdOri
	 */
	public	String getSroutViaPortDefCdOri() {
		return	this.sroutViaPortDefCdOri;
	}

	/**
	 * Column Info
	 * @return sroutViaPortDefCdDest
	 */
	public	String getSroutViaPortDefCdDest() {
		return	this.sroutViaPortDefCdDest;
	}

	/**
	 * Column Info
	 * @return sroutPntLocDefCdDest
	 */
	public	String getSroutPntLocDefCdDest() {
		return	this.sroutPntLocDefCdDest;
	}

	/**
	 * Column Info
	 * @return sctrtCust
	 */
	public	String getSctrtCust() {
		return	this.sctrtCust;
	}

	/**
	 * Column Info
	 * @return sctrtCustSeq
	 */
	public	String getSctrtCustSeq() {
		return	this.sctrtCustSeq;
	}

	/**
	 * Column Info
	 * @return scust
	 */
	public	String getScust() {
		return	this.scust;
	}

	/**
	 * Column Info
	 * @return scustSeq
	 */
	public	String getScustSeq() {
		return	this.scustSeq;
	}

	/**
	 * Column Info
	 * @return sprcCgoTpCd
	 */
	public	String getSprcCgoTpCd() {
		return	this.sprcCgoTpCd;
	}

	/**
	 * Column Info
	 * @return spropScpSrepCd
	 */
	public	String getSpropScpSrepCd() {
		return	this.spropScpSrepCd;
	}

	/**
	 * Column Info
	 * @return spropScpOfcCd
	 */
	public	String getSpropScpOfcCd() {
		return	this.spropScpOfcCd;
	}

	/**
	 * Column Info
	 * @return sprcCtrtCustTpCd
	 */
	public	String getSprcCtrtCustTpCd() {
		return	this.sprcCtrtCustTpCd;
	}

	/**
	 * Column Info
	 * @return sContractType
	 */
	public	String getSContractType() {
		return	this.sContractType;
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
	 * @param  ssvcScpCd
 	 */
	public void	setSsvcScpCd(String ssvcScpCd ) {
		this.ssvcScpCd =	ssvcScpCd;
	}
 	/**
	 * Column Info
	 * @param  seffDt
 	 */
	public void	setSeffDt(String seffDt ) {
		this.seffDt =	seffDt;
	}
 	/**
	 * Column Info
	 * @param  scontractNo
 	 */
	public void	setScontractNo(String scontractNo ) {
		this.scontractNo =	scontractNo;
	}
 	/**
	 * Column Info
	 * @param  sroutPntLocDefCdOri
 	 */
	public void	setSroutPntLocDefCdOri(String sroutPntLocDefCdOri ) {
		this.sroutPntLocDefCdOri =	sroutPntLocDefCdOri;
	}
 	/**
	 * Column Info
	 * @param  sroutViaPortDefCdOri
 	 */
	public void	setSroutViaPortDefCdOri(String sroutViaPortDefCdOri ) {
		this.sroutViaPortDefCdOri =	sroutViaPortDefCdOri;
	}
 	/**
	 * Column Info
	 * @param  sroutViaPortDefCdDest
 	 */
	public void	setSroutViaPortDefCdDest(String sroutViaPortDefCdDest ) {
		this.sroutViaPortDefCdDest =	sroutViaPortDefCdDest;
	}
 	/**
	 * Column Info
	 * @param  sroutPntLocDefCdDest
 	 */
	public void	setSroutPntLocDefCdDest(String sroutPntLocDefCdDest ) {
		this.sroutPntLocDefCdDest =	sroutPntLocDefCdDest;
	}
 	/**
	 * Column Info
	 * @param  sctrtCust
 	 */
	public void	setSctrtCust(String sctrtCust ) {
		this.sctrtCust =	sctrtCust;
	}
 	/**
	 * Column Info
	 * @param  sctrtCustSeq
 	 */
	public void	setSctrtCustSeq(String sctrtCustSeq ) {
		this.sctrtCustSeq =	sctrtCustSeq;
	}
 	/**
	 * Column Info
	 * @param  scust
 	 */
	public void	setScust(String scust ) {
		this.scust =	scust;
	}
 	/**
	 * Column Info
	 * @param  scustSeq
 	 */
	public void	setScustSeq(String scustSeq ) {
		this.scustSeq =	scustSeq;
	}
 	/**
	 * Column Info
	 * @param  sprcCgoTpCd
 	 */
	public void	setSprcCgoTpCd(String sprcCgoTpCd ) {
		this.sprcCgoTpCd =	sprcCgoTpCd;
	}
 	/**
	 * Column Info
	 * @param  spropScpSrepCd
 	 */
	public void	setSpropScpSrepCd(String spropScpSrepCd ) {
		this.spropScpSrepCd =	spropScpSrepCd;
	}
 	/**
	 * Column Info
	 * @param  spropScpOfcCd
 	 */
	public void	setSpropScpOfcCd(String spropScpOfcCd ) {
		this.spropScpOfcCd =	spropScpOfcCd;
	}
 	/**
	 * Column Info
	 * @param  sprcCtrtCustTpCd
 	 */
	public void	setSprcCtrtCustTpCd(String sprcCtrtCustTpCd ) {
		this.sprcCtrtCustTpCd =	sprcCtrtCustTpCd;
	}
 	/**
	 * Column Info
	 * @param  sContractType
 	 */
	public void	setSContractType(String sContractType ) {
		this.sContractType =	sContractType;
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
		setSsvcScpCd(JSPUtil.getParameter(request,	prefix + "ssvc_scp_cd", ""));
		setSeffDt(JSPUtil.getParameter(request,	prefix + "seff_dt", ""));
		setScontractNo(JSPUtil.getParameter(request,	prefix + "scontract_no", ""));
		setSroutPntLocDefCdOri(JSPUtil.getParameter(request,	prefix + "srout_pnt_loc_def_cd_ori", ""));
		setSroutViaPortDefCdOri(JSPUtil.getParameter(request,	prefix + "srout_via_port_def_cd_ori", ""));
		setSroutViaPortDefCdDest(JSPUtil.getParameter(request,	prefix + "srout_via_port_def_cd_dest", ""));
		setSroutPntLocDefCdDest(JSPUtil.getParameter(request,	prefix + "srout_pnt_loc_def_cd_dest", ""));
		setSctrtCust(JSPUtil.getParameter(request,	prefix + "sctrt_cust", ""));
		setSctrtCustSeq(JSPUtil.getParameter(request,	prefix + "sctrt_cust_seq", ""));
		setScust(JSPUtil.getParameter(request,	prefix + "scust", ""));
		setScustSeq(JSPUtil.getParameter(request,	prefix + "scust_seq", ""));
		setSprcCgoTpCd(JSPUtil.getParameter(request,	prefix + "sprc_cgo_tp_cd", ""));
		setSpropScpSrepCd(JSPUtil.getParameter(request,	prefix + "sprop_scp_srep_cd", ""));
		setSpropScpOfcCd(JSPUtil.getParameter(request,	prefix + "sprop_scp_ofc_cd", ""));
		setSprcCtrtCustTpCd(JSPUtil.getParameter(request,	prefix + "sprc_ctrt_cust_tp_cd", ""));
		setSContractType(JSPUtil.getParameter(request,	prefix + "s_contract_type", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriCntrSrhCondVO[]
	 */
	public PriCntrSrhCondVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PriCntrSrhCondVO[]
	 */
	public PriCntrSrhCondVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PriCntrSrhCondVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] ssvcScpCd =	(JSPUtil.getParameter(request, prefix +	"ssvc_scp_cd",	length));
			String[] seffDt =	(JSPUtil.getParameter(request, prefix +	"seff_dt",	length));
			String[] scontractNo =	(JSPUtil.getParameter(request, prefix +	"scontract_no",	length));
			String[] sroutPntLocDefCdOri =	(JSPUtil.getParameter(request, prefix +	"srout_pnt_loc_def_cd_ori",	length));
			String[] sroutViaPortDefCdOri =	(JSPUtil.getParameter(request, prefix +	"srout_via_port_def_cd_ori",	length));
			String[] sroutViaPortDefCdDest =	(JSPUtil.getParameter(request, prefix +	"srout_via_port_def_cd_dest",	length));
			String[] sroutPntLocDefCdDest =	(JSPUtil.getParameter(request, prefix +	"srout_pnt_loc_def_cd_dest",	length));
			String[] sctrtCust =	(JSPUtil.getParameter(request, prefix +	"sctrt_cust",	length));
			String[] sctrtCustSeq =	(JSPUtil.getParameter(request, prefix +	"sctrt_cust_seq",	length));
			String[] scust =	(JSPUtil.getParameter(request, prefix +	"scust",	length));
			String[] scustSeq =	(JSPUtil.getParameter(request, prefix +	"scust_seq",	length));
			String[] sprcCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"sprc_cgo_tp_cd",	length));
			String[] spropScpSrepCd =	(JSPUtil.getParameter(request, prefix +	"sprop_scp_srep_cd",	length));
			String[] spropScpOfcCd =	(JSPUtil.getParameter(request, prefix +	"sprop_scp_ofc_cd",	length));
			String[] sprcCtrtCustTpCd =	(JSPUtil.getParameter(request, prefix +	"sprc_ctrt_cust_tp_cd",	length));
			String[] sContractType =	(JSPUtil.getParameter(request, prefix +	"s_contract_type",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	PriCntrSrhCondVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( ssvcScpCd[i] !=	null)
					model.setSsvcScpCd( ssvcScpCd[i]);
				if ( seffDt[i] !=	null)
					model.setSeffDt( seffDt[i]);
				if ( scontractNo[i] !=	null)
					model.setScontractNo( scontractNo[i]);
				if ( sroutPntLocDefCdOri[i] !=	null)
					model.setSroutPntLocDefCdOri( sroutPntLocDefCdOri[i]);
				if ( sroutViaPortDefCdOri[i] !=	null)
					model.setSroutViaPortDefCdOri( sroutViaPortDefCdOri[i]);
				if ( sroutViaPortDefCdDest[i] !=	null)
					model.setSroutViaPortDefCdDest( sroutViaPortDefCdDest[i]);
				if ( sroutPntLocDefCdDest[i] !=	null)
					model.setSroutPntLocDefCdDest( sroutPntLocDefCdDest[i]);
				if ( sctrtCust[i] !=	null)
					model.setSctrtCust( sctrtCust[i]);
				if ( sctrtCustSeq[i] !=	null)
					model.setSctrtCustSeq( sctrtCustSeq[i]);
				if ( scust[i] !=	null)
					model.setScust( scust[i]);
				if ( scustSeq[i] !=	null)
					model.setScustSeq( scustSeq[i]);
				if ( sprcCgoTpCd[i] !=	null)
					model.setSprcCgoTpCd( sprcCgoTpCd[i]);
				if ( spropScpSrepCd[i] !=	null)
					model.setSpropScpSrepCd( spropScpSrepCd[i]);
				if ( spropScpOfcCd[i] !=	null)
					model.setSpropScpOfcCd( spropScpOfcCd[i]);
				if ( sprcCtrtCustTpCd[i] !=	null)
					model.setSprcCtrtCustTpCd( sprcCtrtCustTpCd[i]);
				if ( sContractType[i] !=	null)
					model.setSContractType( sContractType[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getPriCntrSrhCondVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PriCntrSrhCondVO[]
	 */
	public PriCntrSrhCondVO[]	 getPriCntrSrhCondVOs(){
		PriCntrSrhCondVO[] vos = (PriCntrSrhCondVO[])models.toArray(new	PriCntrSrhCondVO[models.size()]);
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
		this.ssvcScpCd =	this.ssvcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seffDt =	this.seffDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scontractNo =	this.scontractNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sroutPntLocDefCdOri =	this.sroutPntLocDefCdOri.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sroutViaPortDefCdOri =	this.sroutViaPortDefCdOri.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sroutViaPortDefCdDest =	this.sroutViaPortDefCdDest.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sroutPntLocDefCdDest =	this.sroutPntLocDefCdDest.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sctrtCust =	this.sctrtCust.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sctrtCustSeq =	this.sctrtCustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scust =	this.scust.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustSeq =	this.scustSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprcCgoTpCd =	this.sprcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropScpSrepCd =	this.spropScpSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spropScpOfcCd =	this.spropScpOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sprcCtrtCustTpCd =	this.sprcCtrtCustTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sContractType =	this.sContractType.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}