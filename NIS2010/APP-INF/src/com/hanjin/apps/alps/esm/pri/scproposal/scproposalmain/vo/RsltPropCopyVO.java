/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPropCopyVO.java
*@FileTitle : RsltPropCopyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.14
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2010.07.14 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPropCopyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPropCopyVO> models = new ArrayList<RsltPropCopyVO>();
	
	/* Column Info */
	private String scpChk = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String srepCd = null;
	/* Column Info */
	private String prcPropCreTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String noteTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String grateChk = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String ardeChk = null;
	/* Column Info */
	private String loadChk = null;
	/* Column Info */
	private String ihcChk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String addChgTpCd = null;
	/* Column Info */
	private String gohChk = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String orgnChk = null;
	/* Column Info */
	private String newPropNo = null;
	/* Column Info */
	private String destChk = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String custTp = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String locaChk = null;
	/* Column Info */
	private String cmdtChk = null;
	/* Column Info */
	private String spntChk = null;
	/* Column Info */
	private String arorChk = null;
	/* Column Info */
	private String srateChk = null;
	/* Column Info */
	private String blplChk = null;
	/* Column Info */
	private String afilChk = null;
	/* Column Info */
	private String cntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPropCopyVO() {}

	public RsltPropCopyVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String scpChk, String orgnChk, String destChk, String locaChk, String cmdtChk, String arorChk, String ardeChk, String spntChk, String loadChk, String ihcChk, String gohChk, String grateChk, String srateChk, String scNo, String newPropNo, String blplChk, String afilChk, String creUsrId, String updUsrId, String ofcCd, String srepCd, String orgDestTpCd, String addChgTpCd, String noteTpCd, String prcPropCreTpCd, String custTp,String cntCd) {
		this.scpChk = scpChk;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.srepCd = srepCd;
		this.prcPropCreTpCd = prcPropCreTpCd;
		this.pagerows = pagerows;
		this.noteTpCd = noteTpCd;
		this.ibflag = ibflag;
		this.grateChk = grateChk;
		this.scNo = scNo;
		this.ardeChk = ardeChk;
		this.loadChk = loadChk;
		this.ihcChk = ihcChk;
		this.updUsrId = updUsrId;
		this.addChgTpCd = addChgTpCd;
		this.gohChk = gohChk;
		this.orgDestTpCd = orgDestTpCd;
		this.orgnChk = orgnChk;
		this.newPropNo = newPropNo;
		this.destChk = destChk;
		this.ofcCd = ofcCd;
		this.custTp = custTp;
		this.creUsrId = creUsrId;
		this.propNo = propNo;
		this.locaChk = locaChk;
		this.cmdtChk = cmdtChk;
		this.spntChk = spntChk;
		this.arorChk = arorChk;
		this.srateChk = srateChk;
		this.blplChk = blplChk;
		this.afilChk = afilChk;
		this.cntCd = cntCd;

	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scp_chk", getScpChk());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("prc_prop_cre_tp_cd", getPrcPropCreTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("note_tp_cd", getNoteTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("grate_chk", getGrateChk());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("arde_chk", getArdeChk());
		this.hashColumns.put("load_chk", getLoadChk());
		this.hashColumns.put("ihc_chk", getIhcChk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("add_chg_tp_cd", getAddChgTpCd());
		this.hashColumns.put("goh_chk", getGohChk());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("orgn_chk", getOrgnChk());
		this.hashColumns.put("new_prop_no", getNewPropNo());
		this.hashColumns.put("dest_chk", getDestChk());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cust_tp", getCustTp());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("loca_chk", getLocaChk());
		this.hashColumns.put("cmdt_chk", getCmdtChk());
		this.hashColumns.put("spnt_chk", getSpntChk());
		this.hashColumns.put("aror_chk", getArorChk());
		this.hashColumns.put("srate_chk", getSrateChk());
		this.hashColumns.put("blpl_chk", getBlplChk());
		this.hashColumns.put("afil_chk", getAfilChk());
		this.hashColumns.put("cnt_cd", getCntCd());

		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("scp_chk", "scpChk");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("prc_prop_cre_tp_cd", "prcPropCreTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("note_tp_cd", "noteTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("grate_chk", "grateChk");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("arde_chk", "ardeChk");
		this.hashFields.put("load_chk", "loadChk");
		this.hashFields.put("ihc_chk", "ihcChk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("add_chg_tp_cd", "addChgTpCd");
		this.hashFields.put("goh_chk", "gohChk");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("orgn_chk", "orgnChk");
		this.hashFields.put("new_prop_no", "newPropNo");
		this.hashFields.put("dest_chk", "destChk");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cust_tp", "custTp");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("loca_chk", "locaChk");
		this.hashFields.put("cmdt_chk", "cmdtChk");
		this.hashFields.put("spnt_chk", "spntChk");
		this.hashFields.put("aror_chk", "arorChk");
		this.hashFields.put("srate_chk", "srateChk");
		this.hashFields.put("blpl_chk", "blplChk");
		this.hashFields.put("afil_chk", "afilChk");
		this.hashFields.put("cnt_cd", "cntCd");

		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return scpChk
	 */
	public String getScpChk() {
		return this.scpChk;
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
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
	}
	
	/**
	 * Column Info
	 * @return prcPropCreTpCd
	 */
	public String getPrcPropCreTpCd() {
		return this.prcPropCreTpCd;
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
	 * @return noteTpCd
	 */
	public String getNoteTpCd() {
		return this.noteTpCd;
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
	 * @return grateChk
	 */
	public String getGrateChk() {
		return this.grateChk;
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
	 * @return ardeChk
	 */
	public String getArdeChk() {
		return this.ardeChk;
	}
	
	/**
	 * Column Info
	 * @return loadChk
	 */
	public String getLoadChk() {
		return this.loadChk;
	}
	
	/**
	 * Column Info
	 * @return ihcChk
	 */
	public String getIhcChk() {
		return this.ihcChk;
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
	 * @return addChgTpCd
	 */
	public String getAddChgTpCd() {
		return this.addChgTpCd;
	}
	
	/**
	 * Column Info
	 * @return gohChk
	 */
	public String getGohChk() {
		return this.gohChk;
	}
	
	/**
	 * Column Info
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @return orgnChk
	 */
	public String getOrgnChk() {
		return this.orgnChk;
	}
	
	/**
	 * Column Info
	 * @return newPropNo
	 */
	public String getNewPropNo() {
		return this.newPropNo;
	}
	
	/**
	 * Column Info
	 * @return destChk
	 */
	public String getDestChk() {
		return this.destChk;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return custTp
	 */
	public String getCustTp() {
		return this.custTp;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	
	/**
	 * Column Info
	 * @return locaChk
	 */
	public String getLocaChk() {
		return this.locaChk;
	}
	
	/**
	 * Column Info
	 * @return cmdtChk
	 */
	public String getCmdtChk() {
		return this.cmdtChk;
	}
	
	/**
	 * Column Info
	 * @return spntChk
	 */
	public String getSpntChk() {
		return this.spntChk;
	}
	
	/**
	 * Column Info
	 * @return arorChk
	 */
	public String getArorChk() {
		return this.arorChk;
	}
	
	/**
	 * Column Info
	 * @return srateChk
	 */
	public String getSrateChk() {
		return this.srateChk;
	}
	
	/**
	 * Column Info
	 * @return blplChk
	 */
	public String getBlplChk() {
		return this.blplChk;
	}
	
	/**
	 * Column Info
	 * @return afilChk
	 */
	public String getAfilChk() {
		return this.afilChk;
	}
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}

	/**
	 * Column Info
	 * @param scpChk
	 */
	public void setScpChk(String scpChk) {
		this.scpChk = scpChk;
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
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
	}
	
	/**
	 * Column Info
	 * @param prcPropCreTpCd
	 */
	public void setPrcPropCreTpCd(String prcPropCreTpCd) {
		this.prcPropCreTpCd = prcPropCreTpCd;
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
	 * @param noteTpCd
	 */
	public void setNoteTpCd(String noteTpCd) {
		this.noteTpCd = noteTpCd;
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
	 * @param grateChk
	 */
	public void setGrateChk(String grateChk) {
		this.grateChk = grateChk;
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
	 * @param ardeChk
	 */
	public void setArdeChk(String ardeChk) {
		this.ardeChk = ardeChk;
	}
	
	/**
	 * Column Info
	 * @param loadChk
	 */
	public void setLoadChk(String loadChk) {
		this.loadChk = loadChk;
	}
	
	/**
	 * Column Info
	 * @param ihcChk
	 */
	public void setIhcChk(String ihcChk) {
		this.ihcChk = ihcChk;
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
	 * @param addChgTpCd
	 */
	public void setAddChgTpCd(String addChgTpCd) {
		this.addChgTpCd = addChgTpCd;
	}
	
	/**
	 * Column Info
	 * @param gohChk
	 */
	public void setGohChk(String gohChk) {
		this.gohChk = gohChk;
	}
	
	/**
	 * Column Info
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
	}
	
	/**
	 * Column Info
	 * @param orgnChk
	 */
	public void setOrgnChk(String orgnChk) {
		this.orgnChk = orgnChk;
	}
	
	/**
	 * Column Info
	 * @param newPropNo
	 */
	public void setNewPropNo(String newPropNo) {
		this.newPropNo = newPropNo;
	}
	
	/**
	 * Column Info
	 * @param destChk
	 */
	public void setDestChk(String destChk) {
		this.destChk = destChk;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param custTp
	 */
	public void setCustTp(String custTp) {
		this.custTp = custTp;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Column Info
	 * @param locaChk
	 */
	public void setLocaChk(String locaChk) {
		this.locaChk = locaChk;
	}
	
	/**
	 * Column Info
	 * @param cmdtChk
	 */
	public void setCmdtChk(String cmdtChk) {
		this.cmdtChk = cmdtChk;
	}
	
	/**
	 * Column Info
	 * @param spntChk
	 */
	public void setSpntChk(String spntChk) {
		this.spntChk = spntChk;
	}
	
	/**
	 * Column Info
	 * @param arorChk
	 */
	public void setArorChk(String arorChk) {
		this.arorChk = arorChk;
	}
	
	/**
	 * Column Info
	 * @param srateChk
	 */
	public void setSrateChk(String srateChk) {
		this.srateChk = srateChk;
	}
	
	/**
	 * Column Info
	 * @param blplChk
	 */
	public void setBlplChk(String blplChk) {
		this.blplChk = blplChk;
	}
	
	/**
	 * Column Info
	 * @param afilChk
	 */
	public void setAfilChk(String afilChk) {
		this.afilChk = afilChk;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
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
		setScpChk(JSPUtil.getParameter(request, prefix + "scp_chk", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPrcPropCreTpCd(JSPUtil.getParameter(request, prefix + "prc_prop_cre_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNoteTpCd(JSPUtil.getParameter(request, prefix + "note_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setGrateChk(JSPUtil.getParameter(request, prefix + "grate_chk", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setArdeChk(JSPUtil.getParameter(request, prefix + "arde_chk", ""));
		setLoadChk(JSPUtil.getParameter(request, prefix + "load_chk", ""));
		setIhcChk(JSPUtil.getParameter(request, prefix + "ihc_chk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
		setAddChgTpCd(JSPUtil.getParameter(request, prefix + "add_chg_tp_cd", ""));
		setGohChk(JSPUtil.getParameter(request, prefix + "goh_chk", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, prefix + "org_dest_tp_cd", ""));
		setOrgnChk(JSPUtil.getParameter(request, prefix + "orgn_chk", ""));
		setNewPropNo(JSPUtil.getParameter(request, prefix + "new_prop_no", ""));
		setDestChk(JSPUtil.getParameter(request, prefix + "dest_chk", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setCustTp(JSPUtil.getParameter(request, prefix + "cust_tp", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setLocaChk(JSPUtil.getParameter(request, prefix + "loca_chk", ""));
		setCmdtChk(JSPUtil.getParameter(request, prefix + "cmdt_chk", ""));
		setSpntChk(JSPUtil.getParameter(request, prefix + "spnt_chk", ""));
		setArorChk(JSPUtil.getParameter(request, prefix + "aror_chk", ""));
		setSrateChk(JSPUtil.getParameter(request, prefix + "srate_chk", ""));
		setBlplChk(JSPUtil.getParameter(request, prefix + "blpl_chk", ""));
		setAfilChk(JSPUtil.getParameter(request, prefix + "afil_chk", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPropCopyVO[]
	 */
	public RsltPropCopyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPropCopyVO[]
	 */
	public RsltPropCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPropCopyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scpChk = (JSPUtil.getParameter(request, prefix	+ "scp_chk", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] prcPropCreTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_prop_cre_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] noteTpCd = (JSPUtil.getParameter(request, prefix	+ "note_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] grateChk = (JSPUtil.getParameter(request, prefix	+ "grate_chk", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] ardeChk = (JSPUtil.getParameter(request, prefix	+ "arde_chk", length));
			String[] loadChk = (JSPUtil.getParameter(request, prefix	+ "load_chk", length));
			String[] ihcChk = (JSPUtil.getParameter(request, prefix	+ "ihc_chk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] addChgTpCd = (JSPUtil.getParameter(request, prefix	+ "add_chg_tp_cd", length));
			String[] gohChk = (JSPUtil.getParameter(request, prefix	+ "goh_chk", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] orgnChk = (JSPUtil.getParameter(request, prefix	+ "orgn_chk", length));
			String[] newPropNo = (JSPUtil.getParameter(request, prefix	+ "new_prop_no", length));
			String[] destChk = (JSPUtil.getParameter(request, prefix	+ "dest_chk", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] custTp = (JSPUtil.getParameter(request, prefix	+ "cust_tp", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] locaChk = (JSPUtil.getParameter(request, prefix	+ "loca_chk", length));
			String[] cmdtChk = (JSPUtil.getParameter(request, prefix	+ "cmdt_chk", length));
			String[] spntChk = (JSPUtil.getParameter(request, prefix	+ "spnt_chk", length));
			String[] arorChk = (JSPUtil.getParameter(request, prefix	+ "aror_chk", length));
			String[] srateChk = (JSPUtil.getParameter(request, prefix	+ "srate_chk", length));
			String[] blplChk = (JSPUtil.getParameter(request, prefix	+ "blpl_chk", length));
			String[] afilChk = (JSPUtil.getParameter(request, prefix	+ "afil_chk", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPropCopyVO();
				if (scpChk[i] != null)
					model.setScpChk(scpChk[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (prcPropCreTpCd[i] != null)
					model.setPrcPropCreTpCd(prcPropCreTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (noteTpCd[i] != null)
					model.setNoteTpCd(noteTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (grateChk[i] != null)
					model.setGrateChk(grateChk[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (ardeChk[i] != null)
					model.setArdeChk(ardeChk[i]);
				if (loadChk[i] != null)
					model.setLoadChk(loadChk[i]);
				if (ihcChk[i] != null)
					model.setIhcChk(ihcChk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (addChgTpCd[i] != null)
					model.setAddChgTpCd(addChgTpCd[i]);
				if (gohChk[i] != null)
					model.setGohChk(gohChk[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (orgnChk[i] != null)
					model.setOrgnChk(orgnChk[i]);
				if (newPropNo[i] != null)
					model.setNewPropNo(newPropNo[i]);
				if (destChk[i] != null)
					model.setDestChk(destChk[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (custTp[i] != null)
					model.setCustTp(custTp[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (locaChk[i] != null)
					model.setLocaChk(locaChk[i]);
				if (cmdtChk[i] != null)
					model.setCmdtChk(cmdtChk[i]);
				if (spntChk[i] != null)
					model.setSpntChk(spntChk[i]);
				if (arorChk[i] != null)
					model.setArorChk(arorChk[i]);
				if (srateChk[i] != null)
					model.setSrateChk(srateChk[i]);
				if (blplChk[i] != null)
					model.setBlplChk(blplChk[i]);
				if (afilChk[i] != null)
					model.setAfilChk(afilChk[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPropCopyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPropCopyVO[]
	 */
	public RsltPropCopyVO[] getRsltPropCopyVOs(){
		RsltPropCopyVO[] vos = (RsltPropCopyVO[])models.toArray(new RsltPropCopyVO[models.size()]);
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
		this.scpChk = this.scpChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcPropCreTpCd = this.prcPropCreTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteTpCd = this.noteTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grateChk = this.grateChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ardeChk = this.ardeChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loadChk = this.loadChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ihcChk = this.ihcChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgTpCd = this.addChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gohChk = this.gohChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgnChk = this.orgnChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPropNo = this.newPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destChk = this.destChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTp = this.custTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locaChk = this.locaChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtChk = this.cmdtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spntChk = this.spntChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arorChk = this.arorChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srateChk = this.srateChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blplChk = this.blplChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afilChk = this.afilChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");

	}
}
