/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltPriRpInqVO.java
 *@FileTitle : RsltPriRpInqVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.09.29
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2014.09.29 jaewonLee 
 * 1.0 Creation 
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo;

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
public class RsltPriRpInqVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltPriRpInqVO>  models =	new	ArrayList<RsltPriRpInqVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String propSrepCd = null;
	/*	Column Info	*/
	private String amdtSeq = null;
	/*	Column Info	*/
	private String creDt = null;
	/*	Column Info	*/
	private String custTpNm = null;
	/*	Column Info	*/
	private String rfaNo = null;
	/*	Column Info	*/
	private String ctrtPtyNm = null;
	/*	Column Info	*/
	private String effDt = null;
	/*	Column Info	*/
	private String propOfcCd = null;
	/*	Column Info	*/
	private String propStsNm = null;
	/*	Column Info	*/
	private String propNo = null;
	/*	Column Info	*/
	private String expDt = null;
	/*	Column Info	*/
	private String trfCtrtFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltPriRpInqVO(){}

	public RsltPriRpInqVO(String ibflag,String pagerows,String propSrepCd,String amdtSeq,String creDt,String custTpNm,String rfaNo,String ctrtPtyNm,String effDt,String propOfcCd,String propStsNm,String propNo,String expDt,String trfCtrtFlg)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.propSrepCd = propSrepCd;
		this.amdtSeq = amdtSeq;
		this.creDt = creDt;
		this.custTpNm = custTpNm;
		this.rfaNo = rfaNo;
		this.ctrtPtyNm = ctrtPtyNm;
		this.effDt = effDt;
		this.propOfcCd = propOfcCd;
		this.propStsNm = propStsNm;
		this.propNo = propNo;
		this.expDt = expDt;
		this.trfCtrtFlg = trfCtrtFlg;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prop_srep_cd", getPropSrepCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("cust_tp_nm", getCustTpNm());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ctrt_pty_nm", getCtrtPtyNm());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("prop_ofc_cd", getPropOfcCd());
		this.hashColumns.put("prop_sts_nm", getPropStsNm());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("trf_ctrt_flg", getTrfCtrtFlg());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prop_srep_cd", "propSrepCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("cust_tp_nm", "custTpNm");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ctrt_pty_nm", "ctrtPtyNm");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("prop_ofc_cd", "propOfcCd");
		this.hashFields.put("prop_sts_nm", "propStsNm");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("trf_ctrt_flg", "trfCtrtFlg");
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
	 * @return propSrepCd
	 */
	public	String getPropSrepCd() {
		return	this.propSrepCd;
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
	 * @return creDt
	 */
	public	String getCreDt() {
		return	this.creDt;
	}

	/**
	 * Column Info
	 * @return custTpNm
	 */
	public	String getCustTpNm() {
		return	this.custTpNm;
	}

	/**
	 * Column Info
	 * @return rfaNo
	 */
	public	String getRfaNo() {
		return	this.rfaNo;
	}

	/**
	 * Column Info
	 * @return ctrtPtyNm
	 */
	public	String getCtrtPtyNm() {
		return	this.ctrtPtyNm;
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
	 * @return propOfcCd
	 */
	public	String getPropOfcCd() {
		return	this.propOfcCd;
	}

	/**
	 * Column Info
	 * @return propStsNm
	 */
	public	String getPropStsNm() {
		return	this.propStsNm;
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
	 * @return expDt
	 */
	public	String getExpDt() {
		return	this.expDt;
	}

	/**
	 * Column Info
	 * @return trfCtrtFlg
	 */
	public	String getTrfCtrtFlg() {
		return	this.trfCtrtFlg;
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
	 * @param  propSrepCd
 	 */
	public void	setPropSrepCd(String propSrepCd ) {
		this.propSrepCd =	propSrepCd;
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
	 * @param  creDt
 	 */
	public void	setCreDt(String creDt ) {
		this.creDt =	creDt;
	}
 	/**
	 * Column Info
	 * @param  custTpNm
 	 */
	public void	setCustTpNm(String custTpNm ) {
		this.custTpNm =	custTpNm;
	}
 	/**
	 * Column Info
	 * @param  rfaNo
 	 */
	public void	setRfaNo(String rfaNo ) {
		this.rfaNo =	rfaNo;
	}
 	/**
	 * Column Info
	 * @param  ctrtPtyNm
 	 */
	public void	setCtrtPtyNm(String ctrtPtyNm ) {
		this.ctrtPtyNm =	ctrtPtyNm;
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
	 * @param  propOfcCd
 	 */
	public void	setPropOfcCd(String propOfcCd ) {
		this.propOfcCd =	propOfcCd;
	}
 	/**
	 * Column Info
	 * @param  propStsNm
 	 */
	public void	setPropStsNm(String propStsNm ) {
		this.propStsNm =	propStsNm;
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
	 * @param  expDt
 	 */
	public void	setExpDt(String expDt ) {
		this.expDt =	expDt;
	}
 	/**
	 * Column Info
	 * @param  trfCtrtFlg
 	 */
	public void	setTrfCtrtFlg(String trfCtrtFlg ) {
		this.trfCtrtFlg =	trfCtrtFlg;
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
		setPropSrepCd(JSPUtil.getParameter(request,	prefix + "prop_srep_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request,	prefix + "amdt_seq", ""));
		setCreDt(JSPUtil.getParameter(request,	prefix + "cre_dt", ""));
		setCustTpNm(JSPUtil.getParameter(request,	prefix + "cust_tp_nm", ""));
		setRfaNo(JSPUtil.getParameter(request,	prefix + "rfa_no", ""));
		setCtrtPtyNm(JSPUtil.getParameter(request,	prefix + "ctrt_pty_nm", ""));
		setEffDt(JSPUtil.getParameter(request,	prefix + "eff_dt", ""));
		setPropOfcCd(JSPUtil.getParameter(request,	prefix + "prop_ofc_cd", ""));
		setPropStsNm(JSPUtil.getParameter(request,	prefix + "prop_sts_nm", ""));
		setPropNo(JSPUtil.getParameter(request,	prefix + "prop_no", ""));
		setExpDt(JSPUtil.getParameter(request,	prefix + "exp_dt", ""));
		setTrfCtrtFlg(JSPUtil.getParameter(request,	prefix + "trf_ctrt_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriRpInqVO[]
	 */
	public RsltPriRpInqVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltPriRpInqVO[]
	 */
	public RsltPriRpInqVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltPriRpInqVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] propSrepCd =	(JSPUtil.getParameter(request, prefix +	"prop_srep_cd",	length));
			String[] amdtSeq =	(JSPUtil.getParameter(request, prefix +	"amdt_seq",	length));
			String[] creDt =	(JSPUtil.getParameter(request, prefix +	"cre_dt",	length));
			String[] custTpNm =	(JSPUtil.getParameter(request, prefix +	"cust_tp_nm",	length));
			String[] rfaNo =	(JSPUtil.getParameter(request, prefix +	"rfa_no",	length));
			String[] ctrtPtyNm =	(JSPUtil.getParameter(request, prefix +	"ctrt_pty_nm",	length));
			String[] effDt =	(JSPUtil.getParameter(request, prefix +	"eff_dt",	length));
			String[] propOfcCd =	(JSPUtil.getParameter(request, prefix +	"prop_ofc_cd",	length));
			String[] propStsNm =	(JSPUtil.getParameter(request, prefix +	"prop_sts_nm",	length));
			String[] propNo =	(JSPUtil.getParameter(request, prefix +	"prop_no",	length));
			String[] expDt =	(JSPUtil.getParameter(request, prefix +	"exp_dt",	length));
			String[] trfCtrtFlg =	(JSPUtil.getParameter(request, prefix +	"trf_ctrt_flg",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltPriRpInqVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( propSrepCd[i] !=	null)
					model.setPropSrepCd( propSrepCd[i]);
				if ( amdtSeq[i] !=	null)
					model.setAmdtSeq( amdtSeq[i]);
				if ( creDt[i] !=	null)
					model.setCreDt( creDt[i]);
				if ( custTpNm[i] !=	null)
					model.setCustTpNm( custTpNm[i]);
				if ( rfaNo[i] !=	null)
					model.setRfaNo( rfaNo[i]);
				if ( ctrtPtyNm[i] !=	null)
					model.setCtrtPtyNm( ctrtPtyNm[i]);
				if ( effDt[i] !=	null)
					model.setEffDt( effDt[i]);
				if ( propOfcCd[i] !=	null)
					model.setPropOfcCd( propOfcCd[i]);
				if ( propStsNm[i] !=	null)
					model.setPropStsNm( propStsNm[i]);
				if ( propNo[i] !=	null)
					model.setPropNo( propNo[i]);
				if ( expDt[i] !=	null)
					model.setExpDt( expDt[i]);
				if ( trfCtrtFlg[i] !=	null)
					model.setTrfCtrtFlg( trfCtrtFlg[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltPriRpInqVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltPriRpInqVO[]
	 */
	public RsltPriRpInqVO[]	 getRsltPriRpInqVOs(){
		RsltPriRpInqVO[] vos = (RsltPriRpInqVO[])models.toArray(new	RsltPriRpInqVO[models.size()]);
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
		this.propSrepCd =	this.propSrepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq =	this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt =	this.creDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpNm =	this.custTpNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo =	this.rfaNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtPtyNm =	this.ctrtPtyNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt =	this.effDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propOfcCd =	this.propOfcCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsNm =	this.propStsNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo =	this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt =	this.expDt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfCtrtFlg =	this.trfCtrtFlg.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}