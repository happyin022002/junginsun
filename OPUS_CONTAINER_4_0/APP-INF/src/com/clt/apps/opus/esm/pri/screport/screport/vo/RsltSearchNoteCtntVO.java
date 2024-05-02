/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : RsltSearchNoteCtntVO.java
 *@FileTitle : RsltSearchNoteCtntVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.06.07
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2016.06.07 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.screport.screport.vo;

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
public class RsltSearchNoteCtntVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<RsltSearchNoteCtntVO>  models =	new	ArrayList<RsltSearchNoteCtntVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String isSc = null;
	/*	Column Info	*/
	private String noteGubun = null;
	/*	Column Info	*/
	private String propNo = null;
	/*	Column Info	*/
	private String amdtSeq = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String genSpclRtTpCd = null;
	/*	Column Info	*/
	private String cmdtHdrSeq = null;
	/*	Column Info	*/
	private String routSeq = null;
	/*	Column Info	*/
	private String noteCtnt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public RsltSearchNoteCtntVO(){}

	public RsltSearchNoteCtntVO(String ibflag,String pagerows,String isSc,String noteGubun,String propNo,String amdtSeq,String svcScpCd,String genSpclRtTpCd,String cmdtHdrSeq,String routSeq,String noteCtnt)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.isSc = isSc;
		this.noteGubun = noteGubun;
		this.propNo = propNo;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.genSpclRtTpCd = genSpclRtTpCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.routSeq = routSeq;
		this.noteCtnt = noteCtnt;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("is_sc", getIsSc());
		this.hashColumns.put("note_gubun", getNoteGubun());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("is_sc", "isSc");
		this.hashFields.put("note_gubun", "noteGubun");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("note_ctnt", "noteCtnt");
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
	 * @return isSc
	 */
	public	String getIsSc() {
		return	this.isSc;
	}

	/**
	 * Column Info
	 * @return noteGubun
	 */
	public	String getNoteGubun() {
		return	this.noteGubun;
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
	 * @return genSpclRtTpCd
	 */
	public	String getGenSpclRtTpCd() {
		return	this.genSpclRtTpCd;
	}

	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public	String getCmdtHdrSeq() {
		return	this.cmdtHdrSeq;
	}

	/**
	 * Column Info
	 * @return routSeq
	 */
	public	String getRoutSeq() {
		return	this.routSeq;
	}

	/**
	 * Column Info
	 * @return noteCtnt
	 */
	public	String getNoteCtnt() {
		return	this.noteCtnt;
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
	 * @param  isSc
 	 */
	public void	setIsSc(String isSc ) {
		this.isSc =	isSc;
	}
 	/**
	 * Column Info
	 * @param  noteGubun
 	 */
	public void	setNoteGubun(String noteGubun ) {
		this.noteGubun =	noteGubun;
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
	 * @param  genSpclRtTpCd
 	 */
	public void	setGenSpclRtTpCd(String genSpclRtTpCd ) {
		this.genSpclRtTpCd =	genSpclRtTpCd;
	}
 	/**
	 * Column Info
	 * @param  cmdtHdrSeq
 	 */
	public void	setCmdtHdrSeq(String cmdtHdrSeq ) {
		this.cmdtHdrSeq =	cmdtHdrSeq;
	}
 	/**
	 * Column Info
	 * @param  routSeq
 	 */
	public void	setRoutSeq(String routSeq ) {
		this.routSeq =	routSeq;
	}
 	/**
	 * Column Info
	 * @param  noteCtnt
 	 */
	public void	setNoteCtnt(String noteCtnt ) {
		this.noteCtnt =	noteCtnt;
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
		setIsSc(JSPUtil.getParameter(request,	prefix + "is_sc", ""));
		setNoteGubun(JSPUtil.getParameter(request,	prefix + "note_gubun", ""));
		setPropNo(JSPUtil.getParameter(request,	prefix + "prop_no", ""));
		setAmdtSeq(JSPUtil.getParameter(request,	prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request,	prefix + "gen_spcl_rt_tp_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request,	prefix + "cmdt_hdr_seq", ""));
		setRoutSeq(JSPUtil.getParameter(request,	prefix + "rout_seq", ""));
		setNoteCtnt(JSPUtil.getParameter(request,	prefix + "note_ctnt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltSearchNoteCtntVO[]
	 */
	public RsltSearchNoteCtntVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return RsltSearchNoteCtntVO[]
	 */
	public RsltSearchNoteCtntVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		RsltSearchNoteCtntVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] isSc =	(JSPUtil.getParameter(request, prefix +	"is_sc",	length));
			String[] noteGubun =	(JSPUtil.getParameter(request, prefix +	"note_gubun",	length));
			String[] propNo =	(JSPUtil.getParameter(request, prefix +	"prop_no",	length));
			String[] amdtSeq =	(JSPUtil.getParameter(request, prefix +	"amdt_seq",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] genSpclRtTpCd =	(JSPUtil.getParameter(request, prefix +	"gen_spcl_rt_tp_cd",	length));
			String[] cmdtHdrSeq =	(JSPUtil.getParameter(request, prefix +	"cmdt_hdr_seq",	length));
			String[] routSeq =	(JSPUtil.getParameter(request, prefix +	"rout_seq",	length));
			String[] noteCtnt =	(JSPUtil.getParameter(request, prefix +	"note_ctnt",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	RsltSearchNoteCtntVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( isSc[i] !=	null)
					model.setIsSc( isSc[i]);
				if ( noteGubun[i] !=	null)
					model.setNoteGubun( noteGubun[i]);
				if ( propNo[i] !=	null)
					model.setPropNo( propNo[i]);
				if ( amdtSeq[i] !=	null)
					model.setAmdtSeq( amdtSeq[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( genSpclRtTpCd[i] !=	null)
					model.setGenSpclRtTpCd( genSpclRtTpCd[i]);
				if ( cmdtHdrSeq[i] !=	null)
					model.setCmdtHdrSeq( cmdtHdrSeq[i]);
				if ( routSeq[i] !=	null)
					model.setRoutSeq( routSeq[i]);
				if ( noteCtnt[i] !=	null)
					model.setNoteCtnt( noteCtnt[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getRsltSearchNoteCtntVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return RsltSearchNoteCtntVO[]
	 */
	public RsltSearchNoteCtntVO[]	 getRsltSearchNoteCtntVOs(){
		RsltSearchNoteCtntVO[] vos = (RsltSearchNoteCtntVO[])models.toArray(new	RsltSearchNoteCtntVO[models.size()]);
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
		this.isSc =	this.isSc.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteGubun =	this.noteGubun.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo =	this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq =	this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd =	this.genSpclRtTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq =	this.cmdtHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq =	this.routSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt =	this.noteCtnt.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}