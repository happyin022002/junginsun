/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltRtRoutHdrListVO.java
*@FileTitle : RsltRtRoutHdrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.18
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.18  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRtRoutHdrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRtRoutHdrListVO> models = new ArrayList<RsltRtRoutHdrListVO>();
	
	/* Column Info */
	private String naCnt = null;
	/* Column Info */
	private String rn = null;
	/* Column Info */
	private String destRoutViaPortDefCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String noteDpSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ndCnt = null;
	/* Column Info */
	private String destRoutViaPortDefCdProp = null;
	/* Column Info */
	private String orgRoutViaPortDefCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String destRoutPntLocDefCdProp = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String noteCtntProp = null;
	/* Column Info */
	private String cmdtHdrSeq = null;
	/* Column Info */
	private String orgRoutPntLocDefCd = null;
	/* Column Info */
	private String routSeq = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String rowProperties = null;
	/* Column Info */
	private String upCnt = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String orgRoutPntLocDefCdProp = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String destRoutPntLocDefCd = null;
	/* Column Info */
	private String noteCtntTooltip = null;
	/* Column Info */
	private String orgRoutViaPortDefCdProp = null;
	/* Column Info */
	private String orgN1stCmncAmdtSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRtRoutHdrListVO() {}

	public RsltRtRoutHdrListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String cmdtHdrSeq, String routSeq, String orgRoutPntLocDefCd, String orgRoutPntLocDefCdProp, String orgRoutViaPortDefCd, String orgRoutViaPortDefCdProp, String destRoutViaPortDefCd, String destRoutViaPortDefCdProp, String destRoutPntLocDefCd, String destRoutPntLocDefCdProp, String noteCtnt, String noteCtntProp, String noteCtntTooltip, String ndCnt, String naCnt, String upCnt, String rowProperties, String noteDpSeq, String n1stCmncAmdtSeq, String orgN1stCmncAmdtSeq, String creUsrId, String creDt, String updUsrId, String updDt, String rn) {
		this.naCnt = naCnt;
		this.rn = rn;
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.noteCtnt = noteCtnt;
		this.noteDpSeq = noteDpSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.ndCnt = ndCnt;
		this.destRoutViaPortDefCdProp = destRoutViaPortDefCdProp;
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
		this.updUsrId = updUsrId;
		this.destRoutPntLocDefCdProp = destRoutPntLocDefCdProp;
		this.updDt = updDt;
		this.noteCtntProp = noteCtntProp;
		this.cmdtHdrSeq = cmdtHdrSeq;
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
		this.routSeq = routSeq;
		this.creUsrId = creUsrId;
		this.rowProperties = rowProperties;
		this.upCnt = upCnt;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.orgRoutPntLocDefCdProp = orgRoutPntLocDefCdProp;
		this.propNo = propNo;
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
		this.noteCtntTooltip = noteCtntTooltip;
		this.orgRoutViaPortDefCdProp = orgRoutViaPortDefCdProp;
		this.orgN1stCmncAmdtSeq = orgN1stCmncAmdtSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("na_cnt", getNaCnt());
		this.hashColumns.put("rn", getRn());
		this.hashColumns.put("dest_rout_via_port_def_cd", getDestRoutViaPortDefCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("note_dp_seq", getNoteDpSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("nd_cnt", getNdCnt());
		this.hashColumns.put("dest_rout_via_port_def_cd_prop", getDestRoutViaPortDefCdProp());
		this.hashColumns.put("org_rout_via_port_def_cd", getOrgRoutViaPortDefCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd_prop", getDestRoutPntLocDefCdProp());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("note_ctnt_prop", getNoteCtntProp());
		this.hashColumns.put("cmdt_hdr_seq", getCmdtHdrSeq());
		this.hashColumns.put("org_rout_pnt_loc_def_cd", getOrgRoutPntLocDefCd());
		this.hashColumns.put("rout_seq", getRoutSeq());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("row_properties", getRowProperties());
		this.hashColumns.put("up_cnt", getUpCnt());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("org_rout_pnt_loc_def_cd_prop", getOrgRoutPntLocDefCdProp());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("dest_rout_pnt_loc_def_cd", getDestRoutPntLocDefCd());
		this.hashColumns.put("note_ctnt_tooltip", getNoteCtntTooltip());
		this.hashColumns.put("org_rout_via_port_def_cd_prop", getOrgRoutViaPortDefCdProp());
		this.hashColumns.put("org_n1st_cmnc_amdt_seq", getOrgN1stCmncAmdtSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("na_cnt", "naCnt");
		this.hashFields.put("rn", "rn");
		this.hashFields.put("dest_rout_via_port_def_cd", "destRoutViaPortDefCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("note_dp_seq", "noteDpSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("nd_cnt", "ndCnt");
		this.hashFields.put("dest_rout_via_port_def_cd_prop", "destRoutViaPortDefCdProp");
		this.hashFields.put("org_rout_via_port_def_cd", "orgRoutViaPortDefCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dest_rout_pnt_loc_def_cd_prop", "destRoutPntLocDefCdProp");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("note_ctnt_prop", "noteCtntProp");
		this.hashFields.put("cmdt_hdr_seq", "cmdtHdrSeq");
		this.hashFields.put("org_rout_pnt_loc_def_cd", "orgRoutPntLocDefCd");
		this.hashFields.put("rout_seq", "routSeq");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("row_properties", "rowProperties");
		this.hashFields.put("up_cnt", "upCnt");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("org_rout_pnt_loc_def_cd_prop", "orgRoutPntLocDefCdProp");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("dest_rout_pnt_loc_def_cd", "destRoutPntLocDefCd");
		this.hashFields.put("note_ctnt_tooltip", "noteCtntTooltip");
		this.hashFields.put("org_rout_via_port_def_cd_prop", "orgRoutViaPortDefCdProp");
		this.hashFields.put("org_n1st_cmnc_amdt_seq", "orgN1stCmncAmdtSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return naCnt
	 */
	public String getNaCnt() {
		return this.naCnt;
	}
	
	/**
	 * Column Info
	 * @return rn
	 */
	public String getRn() {
		return this.rn;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCd
	 */
	public String getDestRoutViaPortDefCd() {
		return this.destRoutViaPortDefCd;
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
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return noteCtnt
	 */
	public String getNoteCtnt() {
		return this.noteCtnt;
	}
	
	/**
	 * Column Info
	 * @return noteDpSeq
	 */
	public String getNoteDpSeq() {
		return this.noteDpSeq;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return ndCnt
	 */
	public String getNdCnt() {
		return this.ndCnt;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortDefCdProp
	 */
	public String getDestRoutViaPortDefCdProp() {
		return this.destRoutViaPortDefCdProp;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCd
	 */
	public String getOrgRoutViaPortDefCd() {
		return this.orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocDefCdProp
	 */
	public String getDestRoutPntLocDefCdProp() {
		return this.destRoutPntLocDefCdProp;
	}
	
	/**
	 * Column Info
	 * @return updDt
	 */
	public String getUpdDt() {
		return this.updDt;
	}
	
	/**
	 * Column Info
	 * @return noteCtntProp
	 */
	public String getNoteCtntProp() {
		return this.noteCtntProp;
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
	 * @return orgRoutPntLocDefCd
	 */
	public String getOrgRoutPntLocDefCd() {
		return this.orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return routSeq
	 */
	public String getRoutSeq() {
		return this.routSeq;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return rowProperties
	 */
	public String getRowProperties() {
		return this.rowProperties;
	}
	
	/**
	 * Column Info
	 * @return upCnt
	 */
	public String getUpCnt() {
		return this.upCnt;
	}
	
	/**
	 * Column Info
	 * @return n1stCmncAmdtSeq
	 */
	public String getN1stCmncAmdtSeq() {
		return this.n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocDefCdProp
	 */
	public String getOrgRoutPntLocDefCdProp() {
		return this.orgRoutPntLocDefCdProp;
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
	 * @return destRoutPntLocDefCd
	 */
	public String getDestRoutPntLocDefCd() {
		return this.destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return noteCtntTooltip
	 */
	public String getNoteCtntTooltip() {
		return this.noteCtntTooltip;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortDefCdProp
	 */
	public String getOrgRoutViaPortDefCdProp() {
		return this.orgRoutViaPortDefCdProp;
	}
	
	/**
	 * Column Info
	 * @return orgN1stCmncAmdtSeq
	 */
	public String getOrgN1stCmncAmdtSeq() {
		return this.orgN1stCmncAmdtSeq;
	}
	

	/**
	 * Column Info
	 * @param naCnt
	 */
	public void setNaCnt(String naCnt) {
		this.naCnt = naCnt;
	}
	
	/**
	 * Column Info
	 * @param rn
	 */
	public void setRn(String rn) {
		this.rn = rn;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCd
	 */
	public void setDestRoutViaPortDefCd(String destRoutViaPortDefCd) {
		this.destRoutViaPortDefCd = destRoutViaPortDefCd;
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
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param noteCtnt
	 */
	public void setNoteCtnt(String noteCtnt) {
		this.noteCtnt = noteCtnt;
	}
	
	/**
	 * Column Info
	 * @param noteDpSeq
	 */
	public void setNoteDpSeq(String noteDpSeq) {
		this.noteDpSeq = noteDpSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param ndCnt
	 */
	public void setNdCnt(String ndCnt) {
		this.ndCnt = ndCnt;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortDefCdProp
	 */
	public void setDestRoutViaPortDefCdProp(String destRoutViaPortDefCdProp) {
		this.destRoutViaPortDefCdProp = destRoutViaPortDefCdProp;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCd
	 */
	public void setOrgRoutViaPortDefCd(String orgRoutViaPortDefCd) {
		this.orgRoutViaPortDefCd = orgRoutViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param destRoutPntLocDefCdProp
	 */
	public void setDestRoutPntLocDefCdProp(String destRoutPntLocDefCdProp) {
		this.destRoutPntLocDefCdProp = destRoutPntLocDefCdProp;
	}
	
	/**
	 * Column Info
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param noteCtntProp
	 */
	public void setNoteCtntProp(String noteCtntProp) {
		this.noteCtntProp = noteCtntProp;
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
	 * @param orgRoutPntLocDefCd
	 */
	public void setOrgRoutPntLocDefCd(String orgRoutPntLocDefCd) {
		this.orgRoutPntLocDefCd = orgRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param routSeq
	 */
	public void setRoutSeq(String routSeq) {
		this.routSeq = routSeq;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param rowProperties
	 */
	public void setRowProperties(String rowProperties) {
		this.rowProperties = rowProperties;
	}
	
	/**
	 * Column Info
	 * @param upCnt
	 */
	public void setUpCnt(String upCnt) {
		this.upCnt = upCnt;
	}
	
	/**
	 * Column Info
	 * @param n1stCmncAmdtSeq
	 */
	public void setN1stCmncAmdtSeq(String n1stCmncAmdtSeq) {
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocDefCdProp
	 */
	public void setOrgRoutPntLocDefCdProp(String orgRoutPntLocDefCdProp) {
		this.orgRoutPntLocDefCdProp = orgRoutPntLocDefCdProp;
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
	 * @param destRoutPntLocDefCd
	 */
	public void setDestRoutPntLocDefCd(String destRoutPntLocDefCd) {
		this.destRoutPntLocDefCd = destRoutPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param noteCtntTooltip
	 */
	public void setNoteCtntTooltip(String noteCtntTooltip) {
		this.noteCtntTooltip = noteCtntTooltip;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortDefCdProp
	 */
	public void setOrgRoutViaPortDefCdProp(String orgRoutViaPortDefCdProp) {
		this.orgRoutViaPortDefCdProp = orgRoutViaPortDefCdProp;
	}
	
	/**
	 * Column Info
	 * @param orgN1stCmncAmdtSeq
	 */
	public void setOrgN1stCmncAmdtSeq(String orgN1stCmncAmdtSeq) {
		this.orgN1stCmncAmdtSeq = orgN1stCmncAmdtSeq;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setNaCnt(JSPUtil.getParameter(request, prefix + "na_cnt", ""));
		setRn(JSPUtil.getParameter(request, prefix + "rn", ""));
		setDestRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setNoteDpSeq(JSPUtil.getParameter(request, prefix + "note_dp_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setNdCnt(JSPUtil.getParameter(request, prefix + "nd_cnt", ""));
		setDestRoutViaPortDefCdProp(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_def_cd_prop", ""));
		setOrgRoutViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setDestRoutPntLocDefCdProp(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd_prop", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setNoteCtntProp(JSPUtil.getParameter(request, prefix + "note_ctnt_prop", ""));
		setCmdtHdrSeq(JSPUtil.getParameter(request, prefix + "cmdt_hdr_seq", ""));
		setOrgRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd", ""));
		setRoutSeq(JSPUtil.getParameter(request, prefix + "rout_seq", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setRowProperties(JSPUtil.getParameter(request, prefix + "row_properties", ""));
		setUpCnt(JSPUtil.getParameter(request, prefix + "up_cnt", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "n1st_cmnc_amdt_seq", ""));
		setOrgRoutPntLocDefCdProp(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_def_cd_prop", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setDestRoutPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_def_cd", ""));
		setNoteCtntTooltip(JSPUtil.getParameter(request, prefix + "note_ctnt_tooltip", ""));
		setOrgRoutViaPortDefCdProp(JSPUtil.getParameter(request, prefix + "org_rout_via_port_def_cd_prop", ""));
		setOrgN1stCmncAmdtSeq(JSPUtil.getParameter(request, prefix + "org_n1st_cmnc_amdt_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRtRoutHdrListVO[]
	 */
	public RsltRtRoutHdrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRtRoutHdrListVO[]
	 */
	public RsltRtRoutHdrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRtRoutHdrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] naCnt = (JSPUtil.getParameter(request, prefix	+ "na_cnt", length));
			String[] rn = (JSPUtil.getParameter(request, prefix	+ "rn", length));
			String[] destRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] noteDpSeq = (JSPUtil.getParameter(request, prefix	+ "note_dp_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ndCnt = (JSPUtil.getParameter(request, prefix	+ "nd_cnt", length));
			String[] destRoutViaPortDefCdProp = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_def_cd_prop", length));
			String[] orgRoutViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] destRoutPntLocDefCdProp = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd_prop", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] noteCtntProp = (JSPUtil.getParameter(request, prefix	+ "note_ctnt_prop", length));
			String[] cmdtHdrSeq = (JSPUtil.getParameter(request, prefix	+ "cmdt_hdr_seq", length));
			String[] orgRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd", length));
			String[] routSeq = (JSPUtil.getParameter(request, prefix	+ "rout_seq", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] rowProperties = (JSPUtil.getParameter(request, prefix	+ "row_properties", length));
			String[] upCnt = (JSPUtil.getParameter(request, prefix	+ "up_cnt", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] orgRoutPntLocDefCdProp = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_def_cd_prop", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] destRoutPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_def_cd", length));
			String[] noteCtntTooltip = (JSPUtil.getParameter(request, prefix	+ "note_ctnt_tooltip", length));
			String[] orgRoutViaPortDefCdProp = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_def_cd_prop", length));
			String[] orgN1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "org_n1st_cmnc_amdt_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRtRoutHdrListVO();
				if (naCnt[i] != null)
					model.setNaCnt(naCnt[i]);
				if (rn[i] != null)
					model.setRn(rn[i]);
				if (destRoutViaPortDefCd[i] != null)
					model.setDestRoutViaPortDefCd(destRoutViaPortDefCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (noteDpSeq[i] != null)
					model.setNoteDpSeq(noteDpSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ndCnt[i] != null)
					model.setNdCnt(ndCnt[i]);
				if (destRoutViaPortDefCdProp[i] != null)
					model.setDestRoutViaPortDefCdProp(destRoutViaPortDefCdProp[i]);
				if (orgRoutViaPortDefCd[i] != null)
					model.setOrgRoutViaPortDefCd(orgRoutViaPortDefCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (destRoutPntLocDefCdProp[i] != null)
					model.setDestRoutPntLocDefCdProp(destRoutPntLocDefCdProp[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (noteCtntProp[i] != null)
					model.setNoteCtntProp(noteCtntProp[i]);
				if (cmdtHdrSeq[i] != null)
					model.setCmdtHdrSeq(cmdtHdrSeq[i]);
				if (orgRoutPntLocDefCd[i] != null)
					model.setOrgRoutPntLocDefCd(orgRoutPntLocDefCd[i]);
				if (routSeq[i] != null)
					model.setRoutSeq(routSeq[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (rowProperties[i] != null)
					model.setRowProperties(rowProperties[i]);
				if (upCnt[i] != null)
					model.setUpCnt(upCnt[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (orgRoutPntLocDefCdProp[i] != null)
					model.setOrgRoutPntLocDefCdProp(orgRoutPntLocDefCdProp[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (destRoutPntLocDefCd[i] != null)
					model.setDestRoutPntLocDefCd(destRoutPntLocDefCd[i]);
				if (noteCtntTooltip[i] != null)
					model.setNoteCtntTooltip(noteCtntTooltip[i]);
				if (orgRoutViaPortDefCdProp[i] != null)
					model.setOrgRoutViaPortDefCdProp(orgRoutViaPortDefCdProp[i]);
				if (orgN1stCmncAmdtSeq[i] != null)
					model.setOrgN1stCmncAmdtSeq(orgN1stCmncAmdtSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRtRoutHdrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRtRoutHdrListVO[]
	 */
	public RsltRtRoutHdrListVO[] getRsltRtRoutHdrListVOs(){
		RsltRtRoutHdrListVO[] vos = (RsltRtRoutHdrListVO[])models.toArray(new RsltRtRoutHdrListVO[models.size()]);
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
		this.naCnt = this.naCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rn = this.rn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCd = this.destRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteDpSeq = this.noteDpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ndCnt = this.ndCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortDefCdProp = this.destRoutViaPortDefCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCd = this.orgRoutViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCdProp = this.destRoutPntLocDefCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtntProp = this.noteCtntProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHdrSeq = this.cmdtHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCd = this.orgRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.routSeq = this.routSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowProperties = this.rowProperties .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.upCnt = this.upCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocDefCdProp = this.orgRoutPntLocDefCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutPntLocDefCd = this.destRoutPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtntTooltip = this.noteCtntTooltip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortDefCdProp = this.orgRoutViaPortDefCdProp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgN1stCmncAmdtSeq = this.orgN1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
