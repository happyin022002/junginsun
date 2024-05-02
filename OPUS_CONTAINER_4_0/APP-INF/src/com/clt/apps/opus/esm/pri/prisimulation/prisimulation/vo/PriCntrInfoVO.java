/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PriCntrInfoVO.java
 *@FileTitle : PriCntrInfoVO
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
public class PriCntrInfoVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PriCntrInfoVO>  models =	new	ArrayList<PriCntrInfoVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String cntrTp = null;
	/*	Column Info	*/
	private String cntrNo = null;
	/*	Column Info	*/
	private String custNm = null;
	/*	Column Info	*/
	private String actCustNm = null;
	/*	Column Info	*/
	private String srepCd = null;
	/*	Column Info	*/
	private String cmdtNm = null;
	/*	Column Info	*/
	private String orgCd = null;
	/*	Column Info	*/
	private String orgViaCd = null;
	/*	Column Info	*/
	private String destViaCd = null;
	/*	Column Info	*/
	private String destCd = null;
	/*	Column Info	*/
	private String prcCgoTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public PriCntrInfoVO(){}

	public PriCntrInfoVO(String ibflag,String pagerows,String cntrTp,String cntrNo,String custNm,String actCustNm,String srepCd,String cmdtNm,String orgCd,String orgViaCd,String destViaCd,String destCd,String prcCgoTpCd)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.cntrTp = cntrTp;
		this.cntrNo = cntrNo;
		this.custNm = custNm;
		this.actCustNm = actCustNm;
		this.srepCd = srepCd;
		this.cmdtNm = cmdtNm;
		this.orgCd = orgCd;
		this.orgViaCd = orgViaCd;
		this.destViaCd = destViaCd;
		this.destCd = destCd;
		this.prcCgoTpCd = prcCgoTpCd;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_tp", getCntrTp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("act_cust_nm", getActCustNm());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("org_cd", getOrgCd());
		this.hashColumns.put("org_via_cd", getOrgViaCd());
		this.hashColumns.put("dest_via_cd", getDestViaCd());
		this.hashColumns.put("dest_cd", getDestCd());
		this.hashColumns.put("prc_cgo_tp_cd", getPrcCgoTpCd());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_tp", "cntrTp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("act_cust_nm", "actCustNm");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("org_cd", "orgCd");
		this.hashFields.put("org_via_cd", "orgViaCd");
		this.hashFields.put("dest_via_cd", "destViaCd");
		this.hashFields.put("dest_cd", "destCd");
		this.hashFields.put("prc_cgo_tp_cd", "prcCgoTpCd");
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
	 * @return cntrTp
	 */
	public	String getCntrTp() {
		return	this.cntrTp;
	}

	/**
	 * Column Info
	 * @return cntrNo
	 */
	public	String getCntrNo() {
		return	this.cntrNo;
	}

	/**
	 * Column Info
	 * @return custNm
	 */
	public	String getCustNm() {
		return	this.custNm;
	}

	/**
	 * Column Info
	 * @return actCustNm
	 */
	public	String getActCustNm() {
		return	this.actCustNm;
	}

	/**
	 * Column Info
	 * @return srepCd
	 */
	public	String getSrepCd() {
		return	this.srepCd;
	}

	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public	String getCmdtNm() {
		return	this.cmdtNm;
	}

	/**
	 * Column Info
	 * @return orgCd
	 */
	public	String getOrgCd() {
		return	this.orgCd;
	}

	/**
	 * Column Info
	 * @return orgViaCd
	 */
	public	String getOrgViaCd() {
		return	this.orgViaCd;
	}

	/**
	 * Column Info
	 * @return destViaCd
	 */
	public	String getDestViaCd() {
		return	this.destViaCd;
	}

	/**
	 * Column Info
	 * @return destCd
	 */
	public	String getDestCd() {
		return	this.destCd;
	}

	/**
	 * Column Info
	 * @return prcCgoTpCd
	 */
	public	String getPrcCgoTpCd() {
		return	this.prcCgoTpCd;
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
	 * @param  cntrTp
 	 */
	public void	setCntrTp(String cntrTp ) {
		this.cntrTp =	cntrTp;
	}
 	/**
	 * Column Info
	 * @param  cntrNo
 	 */
	public void	setCntrNo(String cntrNo ) {
		this.cntrNo =	cntrNo;
	}
 	/**
	 * Column Info
	 * @param  custNm
 	 */
	public void	setCustNm(String custNm ) {
		this.custNm =	custNm;
	}
 	/**
	 * Column Info
	 * @param  actCustNm
 	 */
	public void	setActCustNm(String actCustNm ) {
		this.actCustNm =	actCustNm;
	}
 	/**
	 * Column Info
	 * @param  srepCd
 	 */
	public void	setSrepCd(String srepCd ) {
		this.srepCd =	srepCd;
	}
 	/**
	 * Column Info
	 * @param  cmdtNm
 	 */
	public void	setCmdtNm(String cmdtNm ) {
		this.cmdtNm =	cmdtNm;
	}
 	/**
	 * Column Info
	 * @param  orgCd
 	 */
	public void	setOrgCd(String orgCd ) {
		this.orgCd =	orgCd;
	}
 	/**
	 * Column Info
	 * @param  orgViaCd
 	 */
	public void	setOrgViaCd(String orgViaCd ) {
		this.orgViaCd =	orgViaCd;
	}
 	/**
	 * Column Info
	 * @param  destViaCd
 	 */
	public void	setDestViaCd(String destViaCd ) {
		this.destViaCd =	destViaCd;
	}
 	/**
	 * Column Info
	 * @param  destCd
 	 */
	public void	setDestCd(String destCd ) {
		this.destCd =	destCd;
	}
 	/**
	 * Column Info
	 * @param  prcCgoTpCd
 	 */
	public void	setPrcCgoTpCd(String prcCgoTpCd ) {
		this.prcCgoTpCd =	prcCgoTpCd;
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
		setCntrTp(JSPUtil.getParameter(request,	prefix + "cntr_tp", ""));
		setCntrNo(JSPUtil.getParameter(request,	prefix + "cntr_no", ""));
		setCustNm(JSPUtil.getParameter(request,	prefix + "cust_nm", ""));
		setActCustNm(JSPUtil.getParameter(request,	prefix + "act_cust_nm", ""));
		setSrepCd(JSPUtil.getParameter(request,	prefix + "srep_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request,	prefix + "cmdt_nm", ""));
		setOrgCd(JSPUtil.getParameter(request,	prefix + "org_cd", ""));
		setOrgViaCd(JSPUtil.getParameter(request,	prefix + "org_via_cd", ""));
		setDestViaCd(JSPUtil.getParameter(request,	prefix + "dest_via_cd", ""));
		setDestCd(JSPUtil.getParameter(request,	prefix + "dest_cd", ""));
		setPrcCgoTpCd(JSPUtil.getParameter(request,	prefix + "prc_cgo_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriCntrInfoVO[]
	 */
	public PriCntrInfoVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PriCntrInfoVO[]
	 */
	public PriCntrInfoVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PriCntrInfoVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] cntrTp =	(JSPUtil.getParameter(request, prefix +	"cntr_tp",	length));
			String[] cntrNo =	(JSPUtil.getParameter(request, prefix +	"cntr_no",	length));
			String[] custNm =	(JSPUtil.getParameter(request, prefix +	"cust_nm",	length));
			String[] actCustNm =	(JSPUtil.getParameter(request, prefix +	"act_cust_nm",	length));
			String[] srepCd =	(JSPUtil.getParameter(request, prefix +	"srep_cd",	length));
			String[] cmdtNm =	(JSPUtil.getParameter(request, prefix +	"cmdt_nm",	length));
			String[] orgCd =	(JSPUtil.getParameter(request, prefix +	"org_cd",	length));
			String[] orgViaCd =	(JSPUtil.getParameter(request, prefix +	"org_via_cd",	length));
			String[] destViaCd =	(JSPUtil.getParameter(request, prefix +	"dest_via_cd",	length));
			String[] destCd =	(JSPUtil.getParameter(request, prefix +	"dest_cd",	length));
			String[] prcCgoTpCd =	(JSPUtil.getParameter(request, prefix +	"prc_cgo_tp_cd",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	PriCntrInfoVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( cntrTp[i] !=	null)
					model.setCntrTp( cntrTp[i]);
				if ( cntrNo[i] !=	null)
					model.setCntrNo( cntrNo[i]);
				if ( custNm[i] !=	null)
					model.setCustNm( custNm[i]);
				if ( actCustNm[i] !=	null)
					model.setActCustNm( actCustNm[i]);
				if ( srepCd[i] !=	null)
					model.setSrepCd( srepCd[i]);
				if ( cmdtNm[i] !=	null)
					model.setCmdtNm( cmdtNm[i]);
				if ( orgCd[i] !=	null)
					model.setOrgCd( orgCd[i]);
				if ( orgViaCd[i] !=	null)
					model.setOrgViaCd( orgViaCd[i]);
				if ( destViaCd[i] !=	null)
					model.setDestViaCd( destViaCd[i]);
				if ( destCd[i] !=	null)
					model.setDestCd( destCd[i]);
				if ( prcCgoTpCd[i] !=	null)
					model.setPrcCgoTpCd( prcCgoTpCd[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getPriCntrInfoVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PriCntrInfoVO[]
	 */
	public PriCntrInfoVO[]	 getPriCntrInfoVOs(){
		PriCntrInfoVO[] vos = (PriCntrInfoVO[])models.toArray(new	PriCntrInfoVO[models.size()]);
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
		this.cntrTp =	this.cntrTp.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo =	this.cntrNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm =	this.custNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actCustNm =	this.actCustNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd =	this.srepCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm =	this.cmdtNm.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgCd =	this.orgCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgViaCd =	this.orgViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destViaCd =	this.destViaCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destCd =	this.destCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCgoTpCd =	this.prcCgoTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}