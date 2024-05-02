/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltRfaPropCopyVO.java
*@FileTitle : RsltRfaPropCopyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.30
*@LastModifier : 문동규
*@LastVersion : 1.0
* 2009.09.30 문동규 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo;

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
 * @author 문동규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltRfaPropCopyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltRfaPropCopyVO> models = new ArrayList<RsltRfaPropCopyVO>();
	
	/* Column Info */
	private String scpChk = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String rtCmdtCnt = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String noteTpCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String adLocCnt = null;
	/* Column Info */
	private String ardeChk = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String addChgTpCd = null;
	/* Column Info */
	private String orgDestTpCd = null;
	/* Column Info */
	private String newPropNo = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String locaChk = null;
	/* Column Info */
	private String aoLocCnt = null;
	/* Column Info */
	private String cmdtChk = null;
	/* Column Info */
	private String spntChk = null;
	/* Column Info */
	private String rateChk = null;
	/* Column Info */
	private String arorChk = null;
	/* Column Info */
	private String rtLocCnt = null;
	/* Column Info */
	private String afilChk = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltRfaPropCopyVO() {}

	public RsltRfaPropCopyVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String scpChk, String locaChk, String cmdtChk, String spntChk, String arorChk, String ardeChk, String rateChk, String rtCmdtCnt, String rtLocCnt, String aoLocCnt, String adLocCnt, String rfaNo, String newPropNo, String afilChk, String creUsrId, String updUsrId, String ofcCd, String srepCd, String orgDestTpCd, String addChgTpCd, String noteTpCd) {
		this.scpChk = scpChk;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.rtCmdtCnt = rtCmdtCnt;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.noteTpCd = noteTpCd;
		this.ibflag = ibflag;
		this.adLocCnt = adLocCnt;
		this.ardeChk = ardeChk;
		this.updUsrId = updUsrId;
		this.addChgTpCd = addChgTpCd;
		this.orgDestTpCd = orgDestTpCd;
		this.newPropNo = newPropNo;
		this.ofcCd = ofcCd;
		this.creUsrId = creUsrId;
		this.propNo = propNo;
		this.locaChk = locaChk;
		this.aoLocCnt = aoLocCnt;
		this.cmdtChk = cmdtChk;
		this.spntChk = spntChk;
		this.rateChk = rateChk;
		this.arorChk = arorChk;
		this.rtLocCnt = rtLocCnt;
		this.afilChk = afilChk;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("scp_chk", getScpChk());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("rt_cmdt_cnt", getRtCmdtCnt());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("note_tp_cd", getNoteTpCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ad_loc_cnt", getAdLocCnt());
		this.hashColumns.put("arde_chk", getArdeChk());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("add_chg_tp_cd", getAddChgTpCd());
		this.hashColumns.put("org_dest_tp_cd", getOrgDestTpCd());
		this.hashColumns.put("new_prop_no", getNewPropNo());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("loca_chk", getLocaChk());
		this.hashColumns.put("ao_loc_cnt", getAoLocCnt());
		this.hashColumns.put("cmdt_chk", getCmdtChk());
		this.hashColumns.put("spnt_chk", getSpntChk());
		this.hashColumns.put("rate_chk", getRateChk());
		this.hashColumns.put("aror_chk", getArorChk());
		this.hashColumns.put("rt_loc_cnt", getRtLocCnt());
		this.hashColumns.put("afil_chk", getAfilChk());
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
		this.hashFields.put("rt_cmdt_cnt", "rtCmdtCnt");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("note_tp_cd", "noteTpCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ad_loc_cnt", "adLocCnt");
		this.hashFields.put("arde_chk", "ardeChk");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("add_chg_tp_cd", "addChgTpCd");
		this.hashFields.put("org_dest_tp_cd", "orgDestTpCd");
		this.hashFields.put("new_prop_no", "newPropNo");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("loca_chk", "locaChk");
		this.hashFields.put("ao_loc_cnt", "aoLocCnt");
		this.hashFields.put("cmdt_chk", "cmdtChk");
		this.hashFields.put("spnt_chk", "spntChk");
		this.hashFields.put("rate_chk", "rateChk");
		this.hashFields.put("aror_chk", "arorChk");
		this.hashFields.put("rt_loc_cnt", "rtLocCnt");
		this.hashFields.put("afil_chk", "afilChk");
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
	 * @return rtCmdtCnt
	 */
	public String getRtCmdtCnt() {
		return this.rtCmdtCnt;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return adLocCnt
	 */
	public String getAdLocCnt() {
		return this.adLocCnt;
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
	 * @return orgDestTpCd
	 */
	public String getOrgDestTpCd() {
		return this.orgDestTpCd;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return aoLocCnt
	 */
	public String getAoLocCnt() {
		return this.aoLocCnt;
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
	 * @return rateChk
	 */
	public String getRateChk() {
		return this.rateChk;
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
	 * @return rtLocCnt
	 */
	public String getRtLocCnt() {
		return this.rtLocCnt;
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
	 * @param rtCmdtCnt
	 */
	public void setRtCmdtCnt(String rtCmdtCnt) {
		this.rtCmdtCnt = rtCmdtCnt;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param adLocCnt
	 */
	public void setAdLocCnt(String adLocCnt) {
		this.adLocCnt = adLocCnt;
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
	 * @param orgDestTpCd
	 */
	public void setOrgDestTpCd(String orgDestTpCd) {
		this.orgDestTpCd = orgDestTpCd;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param aoLocCnt
	 */
	public void setAoLocCnt(String aoLocCnt) {
		this.aoLocCnt = aoLocCnt;
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
	 * @param rateChk
	 */
	public void setRateChk(String rateChk) {
		this.rateChk = rateChk;
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
	 * @param rtLocCnt
	 */
	public void setRtLocCnt(String rtLocCnt) {
		this.rtLocCnt = rtLocCnt;
	}
	
	/**
	 * Column Info
	 * @param afilChk
	 */
	public void setAfilChk(String afilChk) {
		this.afilChk = afilChk;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setScpChk(JSPUtil.getParameter(request, "scp_chk", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setRtCmdtCnt(JSPUtil.getParameter(request, "rt_cmdt_cnt", ""));
		setSrepCd(JSPUtil.getParameter(request, "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, "rfa_no", ""));
		setNoteTpCd(JSPUtil.getParameter(request, "note_tp_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setAdLocCnt(JSPUtil.getParameter(request, "ad_loc_cnt", ""));
		setArdeChk(JSPUtil.getParameter(request, "arde_chk", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setAddChgTpCd(JSPUtil.getParameter(request, "add_chg_tp_cd", ""));
		setOrgDestTpCd(JSPUtil.getParameter(request, "org_dest_tp_cd", ""));
		setNewPropNo(JSPUtil.getParameter(request, "new_prop_no", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
		setLocaChk(JSPUtil.getParameter(request, "loca_chk", ""));
		setAoLocCnt(JSPUtil.getParameter(request, "ao_loc_cnt", ""));
		setCmdtChk(JSPUtil.getParameter(request, "cmdt_chk", ""));
		setSpntChk(JSPUtil.getParameter(request, "spnt_chk", ""));
		setRateChk(JSPUtil.getParameter(request, "rate_chk", ""));
		setArorChk(JSPUtil.getParameter(request, "aror_chk", ""));
		setRtLocCnt(JSPUtil.getParameter(request, "rt_loc_cnt", ""));
		setAfilChk(JSPUtil.getParameter(request, "afil_chk", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltRfaPropCopyVO[]
	 */
	public RsltRfaPropCopyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltRfaPropCopyVO[]
	 */
	public RsltRfaPropCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltRfaPropCopyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] scpChk = (JSPUtil.getParameter(request, prefix	+ "scp_chk", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] rtCmdtCnt = (JSPUtil.getParameter(request, prefix	+ "rt_cmdt_cnt", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] noteTpCd = (JSPUtil.getParameter(request, prefix	+ "note_tp_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] adLocCnt = (JSPUtil.getParameter(request, prefix	+ "ad_loc_cnt", length));
			String[] ardeChk = (JSPUtil.getParameter(request, prefix	+ "arde_chk", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] addChgTpCd = (JSPUtil.getParameter(request, prefix	+ "add_chg_tp_cd", length));
			String[] orgDestTpCd = (JSPUtil.getParameter(request, prefix	+ "org_dest_tp_cd", length));
			String[] newPropNo = (JSPUtil.getParameter(request, prefix	+ "new_prop_no", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] locaChk = (JSPUtil.getParameter(request, prefix	+ "loca_chk", length));
			String[] aoLocCnt = (JSPUtil.getParameter(request, prefix	+ "ao_loc_cnt", length));
			String[] cmdtChk = (JSPUtil.getParameter(request, prefix	+ "cmdt_chk", length));
			String[] spntChk = (JSPUtil.getParameter(request, prefix	+ "spnt_chk", length));
			String[] rateChk = (JSPUtil.getParameter(request, prefix	+ "rate_chk", length));
			String[] arorChk = (JSPUtil.getParameter(request, prefix	+ "aror_chk", length));
			String[] rtLocCnt = (JSPUtil.getParameter(request, prefix	+ "rt_loc_cnt", length));
			String[] afilChk = (JSPUtil.getParameter(request, prefix	+ "afil_chk", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltRfaPropCopyVO();
				if (scpChk[i] != null)
					model.setScpChk(scpChk[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (rtCmdtCnt[i] != null)
					model.setRtCmdtCnt(rtCmdtCnt[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (noteTpCd[i] != null)
					model.setNoteTpCd(noteTpCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (adLocCnt[i] != null)
					model.setAdLocCnt(adLocCnt[i]);
				if (ardeChk[i] != null)
					model.setArdeChk(ardeChk[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (addChgTpCd[i] != null)
					model.setAddChgTpCd(addChgTpCd[i]);
				if (orgDestTpCd[i] != null)
					model.setOrgDestTpCd(orgDestTpCd[i]);
				if (newPropNo[i] != null)
					model.setNewPropNo(newPropNo[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (locaChk[i] != null)
					model.setLocaChk(locaChk[i]);
				if (aoLocCnt[i] != null)
					model.setAoLocCnt(aoLocCnt[i]);
				if (cmdtChk[i] != null)
					model.setCmdtChk(cmdtChk[i]);
				if (spntChk[i] != null)
					model.setSpntChk(spntChk[i]);
				if (rateChk[i] != null)
					model.setRateChk(rateChk[i]);
				if (arorChk[i] != null)
					model.setArorChk(arorChk[i]);
				if (rtLocCnt[i] != null)
					model.setRtLocCnt(rtLocCnt[i]);
				if (afilChk[i] != null)
					model.setAfilChk(afilChk[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltRfaPropCopyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltRfaPropCopyVO[]
	 */
	public RsltRfaPropCopyVO[] getRsltRfaPropCopyVOs(){
		RsltRfaPropCopyVO[] vos = (RsltRfaPropCopyVO[])models.toArray(new RsltRfaPropCopyVO[models.size()]);
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
		this.rtCmdtCnt = this.rtCmdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteTpCd = this.noteTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.adLocCnt = this.adLocCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ardeChk = this.ardeChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.addChgTpCd = this.addChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgDestTpCd = this.orgDestTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newPropNo = this.newPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locaChk = this.locaChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aoLocCnt = this.aoLocCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtChk = this.cmdtChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spntChk = this.spntChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rateChk = this.rateChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arorChk = this.arorChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rtLocCnt = this.rtLocCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.afilChk = this.afilChk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
