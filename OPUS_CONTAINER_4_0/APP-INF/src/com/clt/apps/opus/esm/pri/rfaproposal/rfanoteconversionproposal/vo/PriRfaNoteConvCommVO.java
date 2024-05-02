/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : PriRfaNoteConvCommVO.java
 *@FileTitle : PriRfaNoteConvCommVO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2016.05.20
 *@LastModifier : jaewonLee
 *@LastVersion : 1.0
 * 2016.05.20 jaewonLee 
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo;

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
public class PriRfaNoteConvCommVO	extends	 AbstractValueObject {

	private	 static final long serialVersionUID = 1L;

	private	 Collection<PriRfaNoteConvCommVO>  models =	new	ArrayList<PriRfaNoteConvCommVO>();
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Page Number */
	private String pagerows = null;
	/*	Column Info	*/
	private String amdtSeq = null;
	/*	Column Info	*/
	private String propNo = null;
	/*	Column Info	*/
	private String svcScpCd = null;
	/*	Column Info	*/
	private String cmdtHdrSeq = null;
	/*	Column Info	*/
	private String noteChgTpCd = null;
	/*	Column Info	*/
	private String noteConvMapgId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private	 HashMap<String , String>	hashColumns	= new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private	 HashMap<String , String>	hashFields = new LinkedHashMap<String, String>();


	/**	Constructor	*/
	public PriRfaNoteConvCommVO(){}

	public PriRfaNoteConvCommVO(String ibflag,String pagerows,String amdtSeq,String propNo,String svcScpCd,String cmdtHdrSeq,String noteChgTpCd,String noteConvMapgId)	{
		this.ibflag = ibflag;
		this.pagerows = pagerows;
		this.amdtSeq = amdtSeq;
		this.propNo = propNo;
		this.svcScpCd = svcScpCd;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.noteChgTpCd = noteChgTpCd;
		this.noteConvMapgId = noteConvMapgId;
	}


	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value">	로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("note_chg_tp_cd", getNoteChgTpCd());
		this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에	대응되는 멤버변수명을	저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public  HashMap<String, String>  getFieldNames(){
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("note_chg_tp_cd", "noteChgTpCd");
		this.hashFields.put("note_conv_mapg_id", "noteConvMapgId");
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
	 * @return amdtSeq
	 */
	public	String getAmdtSeq() {
		return	this.amdtSeq;
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
	 * @return svcScpCd
	 */
	public	String getSvcScpCd() {
		return	this.svcScpCd;
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
	 * @return noteChgTpCd
	 */
	public	String getNoteChgTpCd() {
		return	this.noteChgTpCd;
	}

	/**
	 * Column Info
	 * @return noteConvMapgId
	 */
	public	String getNoteConvMapgId() {
		return	this.noteConvMapgId;
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
	 * @param  amdtSeq
 	 */
	public void	setAmdtSeq(String amdtSeq ) {
		this.amdtSeq =	amdtSeq;
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
	 * @param  svcScpCd
 	 */
	public void	setSvcScpCd(String svcScpCd ) {
		this.svcScpCd =	svcScpCd;
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
	 * @param  noteChgTpCd
 	 */
	public void	setNoteChgTpCd(String noteChgTpCd ) {
		this.noteChgTpCd =	noteChgTpCd;
	}
 	/**
	 * Column Info
	 * @param  noteConvMapgId
 	 */
	public void	setNoteConvMapgId(String noteConvMapgId ) {
		this.noteConvMapgId =	noteConvMapgId;
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
		setAmdtSeq(JSPUtil.getParameter(request,	prefix + "amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request,	prefix + "prop_no", ""));
		setSvcScpCd(JSPUtil.getParameter(request,	prefix + "svc_scp_cd", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request,	prefix + "cmdt_hdr_seq", ""));
		setNoteChgTpCd(JSPUtil.getParameter(request,	prefix + "note_chg_tp_cd", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request,	prefix + "note_conv_mapg_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return PriRfaNoteConvCommVO[]
	 */
	public PriRfaNoteConvCommVO[]	fromRequestGrid(HttpServletRequest request)	{
		return fromRequestGrid(request,	"");
	}

	/**
	 * Request 넘어온 여러 건	DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return PriRfaNoteConvCommVO[]
	 */
	public PriRfaNoteConvCommVO[]	fromRequestGrid(HttpServletRequest request,	String prefix) {
		PriRfaNoteConvCommVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
		if (tmp	== null)
			return null;

		int	length = request.getParameterValues(prefix + "ibflag").length;

		try	{
			String[] ibflag =	(JSPUtil.getParameter(request, prefix +	"ibflag",	length));
			String[] pagerows =	(JSPUtil.getParameter(request, prefix +	"pagerows",	length));
			String[] amdtSeq =	(JSPUtil.getParameter(request, prefix +	"amdt_seq",	length));
			String[] propNo =	(JSPUtil.getParameter(request, prefix +	"prop_no",	length));
			String[] svcScpCd =	(JSPUtil.getParameter(request, prefix +	"svc_scp_cd",	length));
			String[] cmdtHdrSeq =	(JSPUtil.getParameter(request, prefix +	"cmdt_hdr_seq",	length));
			String[] noteChgTpCd =	(JSPUtil.getParameter(request, prefix +	"note_chg_tp_cd",	length));
			String[] noteConvMapgId =	(JSPUtil.getParameter(request, prefix +	"note_conv_mapg_id",	length));
			for	(int i = 0;	i <	length;	i++) {
				model =	new	PriRfaNoteConvCommVO();
				if ( ibflag[i] !=	null)
					model.setIbflag( ibflag[i]);
				if ( pagerows[i] !=	null)
					model.setPagerows( pagerows[i]);
				if ( amdtSeq[i] !=	null)
					model.setAmdtSeq( amdtSeq[i]);
				if ( propNo[i] !=	null)
					model.setPropNo( propNo[i]);
				if ( svcScpCd[i] !=	null)
					model.setSvcScpCd( svcScpCd[i]);
				if ( cmdtHdrSeq[i] !=	null)
					model.setCmdtHdrSeq( cmdtHdrSeq[i]);
				if ( noteChgTpCd[i] !=	null)
					model.setNoteChgTpCd( noteChgTpCd[i]);
				if ( noteConvMapgId[i] !=	null)
					model.setNoteConvMapgId( noteConvMapgId[i]);
				models.add(model);
			}

		} catch	(Exception e) {
			return null;
		}
		return getPriRfaNoteConvCommVOs();
	}

	/**
	 *  VO 배열을 반환
	 * @return PriRfaNoteConvCommVO[]
	 */
	public PriRfaNoteConvCommVO[]	 getPriRfaNoteConvCommVOs(){
		PriRfaNoteConvCommVO[] vos = (PriRfaNoteConvCommVO[])models.toArray(new	PriRfaNoteConvCommVO[models.size()]);
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
		this.amdtSeq =	this.amdtSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo =	this.propNo.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd =	this.svcScpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq =	this.cmdtHdrSeq.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteChgTpCd =	this.noteChgTpCd.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvMapgId =	this.noteConvMapgId.replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}