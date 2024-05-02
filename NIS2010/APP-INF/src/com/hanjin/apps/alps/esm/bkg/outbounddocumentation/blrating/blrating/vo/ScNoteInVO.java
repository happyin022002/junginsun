/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ScNoteInVO.java
*@FileTitle : ScNoteInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.29
*@LastModifier : 김태경
*@LastVersion : 1.0
* 2009.11.29 김태경 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김태경
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class ScNoteInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<ScNoteInVO> models = new ArrayList<ScNoteInVO>();
	
	/* Column Info */
	private String noteChgTpCd = null;
	/* Column Info */
	private String noteRtSeq = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String endApplicationdate = null;
	/* Column Info */
	private String startApplicationdate = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String routSeq = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String applicationDate = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String genSpclRtTpCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public ScNoteInVO() {}

	public ScNoteInVO(String ibflag, String pagerows, String bkgNo, String scNo, String svcScpCd, String noteRtSeq, String propNo, String amdtSeq, String genSpclRtTpCd, String cmdtHdrSeq, String routSeq, String applicationDate, String startApplicationdate, String endApplicationdate, String noteChgTpCd) {
		this.noteChgTpCd = noteChgTpCd;
		this.noteRtSeq = noteRtSeq;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.endApplicationdate = endApplicationdate;
		this.startApplicationdate = startApplicationdate;
		this.pagerows = pagerows;
		this.routSeq = routSeq;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.propNo = propNo;
		this.applicationDate = applicationDate;
		this.scNo = scNo;
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("note_chg_tp_cd", getNoteChgTpCd());
		this.hashColumns.put("note_rt_seq", getNoteRtSeq());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("end_applicationdate", getEndApplicationdate());
		this.hashColumns.put("start_applicationdate", getStartApplicationdate());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("application_date", getApplicationDate());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("gen_spcl_rt_tp_cd", getGenSpclRtTpCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("note_chg_tp_cd", "noteChgTpCd");
		this.hashFields.put("note_rt_seq", "noteRtSeq");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("end_applicationdate", "endApplicationdate");
		this.hashFields.put("start_applicationdate", "startApplicationdate");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("application_date", "applicationDate");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("gen_spcl_rt_tp_cd", "genSpclRtTpCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return noteChgTpCd
	 */
	public String getNoteChgTpCd() {
		return this.noteChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return noteRtSeq
	 */
	public String getNoteRtSeq() {
		return this.noteRtSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtHdrSeq
	 */
	public String getCmdtHdrSeq() {
		return this.cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return amdtSeq
	 */
	public String getAmdtSeq() {
		return this.amdtSeq;
	}
	
	/**
	 * Column Info
	 * @return svcScpCd
	 */
	public String getSvcScpCd() {
		return this.svcScpCd;
	}
	
	/**
	 * Column Info
	 * @return endApplicationdate
	 */
	public String getEndApplicationdate() {
		return this.endApplicationdate;
	}
	
	/**
	 * Column Info
	 * @return startApplicationdate
	 */
	public String getStartApplicationdate() {
		return this.startApplicationdate;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return applicationDate
	 */
	public String getApplicationDate() {
		return this.applicationDate;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return genSpclRtTpCd
	 */
	public String getGenSpclRtTpCd() {
		return this.genSpclRtTpCd;
	}
	

	/**
	 * Column Info
	 * @param noteChgTpCd
	 */
	public void setNoteChgTpCd(String noteChgTpCd) {
		this.noteChgTpCd = noteChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param noteRtSeq
	 */
	public void setNoteRtSeq(String noteRtSeq) {
		this.noteRtSeq = noteRtSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtHdrSeq
	 */
	public void setCmdtHdrSeq(String cmdtHdrSeq) {
		this.cmdtHdrSeq = cmdtHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param amdtSeq
	 */
	public void setAmdtSeq(String amdtSeq) {
		this.amdtSeq = amdtSeq;
	}
	
	/**
	 * Column Info
	 * @param svcScpCd
	 */
	public void setSvcScpCd(String svcScpCd) {
		this.svcScpCd = svcScpCd;
	}
	
	/**
	 * Column Info
	 * @param endApplicationdate
	 */
	public void setEndApplicationdate(String endApplicationdate) {
		this.endApplicationdate = endApplicationdate;
	}
	
	/**
	 * Column Info
	 * @param startApplicationdate
	 */
	public void setStartApplicationdate(String startApplicationdate) {
		this.startApplicationdate = startApplicationdate;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * VO Data Value( C:Creation, U:Update, D:Delete )
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param applicationDate
	 */
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param genSpclRtTpCd
	 */
	public void setGenSpclRtTpCd(String genSpclRtTpCd) {
		this.genSpclRtTpCd = genSpclRtTpCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setNoteChgTpCd(JSPUtil.getParameter(request, "note_chg_tp_cd", ""));
		setNoteRtSeq(JSPUtil.getParameter(request, "note_rt_seq", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, "cmdt_hdr_seq", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setEndApplicationdate(JSPUtil.getParameter(request, "end_applicationdate", ""));
		setStartApplicationdate(JSPUtil.getParameter(request, "start_applicationdate", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRoutSeq(JSPUtil.getParameter(request, "rout_seq", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setApplicationDate(JSPUtil.getParameter(request, "application_date", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setGenSpclRtTpCd(JSPUtil.getParameter(request, "gen_spcl_rt_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return ScNoteInVO[]
	 */
	public ScNoteInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return ScNoteInVO[]
	 */
	public ScNoteInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		ScNoteInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] noteChgTpCd = (JSPUtil.getParameter(request, prefix	+ "note_chg_tp_cd", length));
			String[] noteRtSeq = (JSPUtil.getParameter(request, prefix	+ "note_rt_seq", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] endApplicationdate = (JSPUtil.getParameter(request, prefix	+ "end_applicationdate", length));
			String[] startApplicationdate = (JSPUtil.getParameter(request, prefix	+ "start_applicationdate", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] applicationDate = (JSPUtil.getParameter(request, prefix	+ "application_date", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] genSpclRtTpCd = (JSPUtil.getParameter(request, prefix	+ "gen_spcl_rt_tp_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new ScNoteInVO();
				if (noteChgTpCd[i] != null)
					model.setNoteChgTpCd(noteChgTpCd[i]);
				if (noteRtSeq[i] != null)
					model.setNoteRtSeq(noteRtSeq[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (endApplicationdate[i] != null)
					model.setEndApplicationdate(endApplicationdate[i]);
				if (startApplicationdate[i] != null)
					model.setStartApplicationdate(startApplicationdate[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (applicationDate[i] != null)
					model.setApplicationDate(applicationDate[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (genSpclRtTpCd[i] != null)
					model.setGenSpclRtTpCd(genSpclRtTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getScNoteInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return ScNoteInVO[]
	 */
	public ScNoteInVO[] getScNoteInVOs(){
		ScNoteInVO[] vos = (ScNoteInVO[])models.toArray(new ScNoteInVO[models.size()]);
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
	public void unDataFormat(){
		this.noteChgTpCd = this.noteChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteRtSeq = this.noteRtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.endApplicationdate = this.endApplicationdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.startApplicationdate = this.startApplicationdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.applicationDate = this.applicationDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genSpclRtTpCd = this.genSpclRtTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
