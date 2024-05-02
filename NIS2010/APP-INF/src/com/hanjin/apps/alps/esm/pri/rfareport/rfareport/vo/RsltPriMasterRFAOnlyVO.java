/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RsltPriMasterRFAOnlyVO.java
*@FileTitle : RsltPriMasterRFAOnlyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.01
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.01  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriMasterRFAOnlyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriMasterRFAOnlyVO> models = new ArrayList<RsltPriMasterRFAOnlyVO>();
	
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String destPntLocDefCd = null;
	/* Column Info */
	private String noteConvSeq = null;
	/* Column Info */
	private String propFrtD4RtAmt = null;
	/* Column Info */
	private String bkgDirCallFlg = null;
	/* Column Info */
	private String mstRfaNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String propFrtD2RtAmt = null;
	/* Column Info */
	private String orgViaPortDefCd = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgTsPortDefCd = null;
	/* Column Info */
	private String propStsCd = null;
	/* Column Info */
	private String bkgSlanCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String prcCmdtDefCd = null;
	/* Column Info */
	private String destViaPortDefCd = null;
	/* Column Info */
	private String propFrtD5RtAmt = null;
	/* Column Info */
	private String rhqCd = null;
	/* Column Info */
	private String mstRoutId = null;
	/* Column Info */
	private String noteConvChgCd = null;
	/* Column Info */
	private String orgPntLocDefCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String propNo = null;
	/* Column Info */
	private String bkgVvdCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltPriMasterRFAOnlyVO() {}

	public RsltPriMasterRFAOnlyVO(String ibflag, String pagerows, String svcScpCd, String rhqCd, String ofcCd, String effDt, String expDt, String propNo, String mstRfaNo, String amdtSeq, String mstRoutId, String orgPntLocDefCd, String rcvTermCd, String orgViaPortDefCd, String destViaPortDefCd, String destPntLocDefCd, String deTermCd, String propFrtD2RtAmt, String propFrtD4RtAmt, String propFrtD5RtAmt, String noteConvChgCd, String bkgDirCallFlg, String bkgTsPortDefCd, String bkgSlanCd, String bkgVvdCd, String noteConvSeq, String prcCmdtDefCd, String propStsCd) {
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.destPntLocDefCd = destPntLocDefCd;
		this.noteConvSeq = noteConvSeq;
		this.propFrtD4RtAmt = propFrtD4RtAmt;
		this.bkgDirCallFlg = bkgDirCallFlg;
		this.mstRfaNo = mstRfaNo;
		this.pagerows = pagerows;
		this.propFrtD2RtAmt = propFrtD2RtAmt;
		this.orgViaPortDefCd = orgViaPortDefCd;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.bkgTsPortDefCd = bkgTsPortDefCd;
		this.propStsCd = propStsCd;
		this.bkgSlanCd = bkgSlanCd;
		this.rcvTermCd = rcvTermCd;
		this.expDt = expDt;
		this.prcCmdtDefCd = prcCmdtDefCd;
		this.destViaPortDefCd = destViaPortDefCd;
		this.propFrtD5RtAmt = propFrtD5RtAmt;
		this.rhqCd = rhqCd;
		this.mstRoutId = mstRoutId;
		this.noteConvChgCd = noteConvChgCd;
		this.orgPntLocDefCd = orgPntLocDefCd;
		this.ofcCd = ofcCd;
		this.deTermCd = deTermCd;
		this.propNo = propNo;
		this.bkgVvdCd = bkgVvdCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("dest_pnt_loc_def_cd", getDestPntLocDefCd());
		this.hashColumns.put("note_conv_seq", getNoteConvSeq());
		this.hashColumns.put("prop_frt_d4_rt_amt", getPropFrtD4RtAmt());
		this.hashColumns.put("bkg_dir_call_flg", getBkgDirCallFlg());
		this.hashColumns.put("mst_rfa_no", getMstRfaNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prop_frt_d2_rt_amt", getPropFrtD2RtAmt());
		this.hashColumns.put("org_via_port_def_cd", getOrgViaPortDefCd());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_ts_port_def_cd", getBkgTsPortDefCd());
		this.hashColumns.put("prop_sts_cd", getPropStsCd());
		this.hashColumns.put("bkg_slan_cd", getBkgSlanCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("prc_cmdt_def_cd", getPrcCmdtDefCd());
		this.hashColumns.put("dest_via_port_def_cd", getDestViaPortDefCd());
		this.hashColumns.put("prop_frt_d5_rt_amt", getPropFrtD5RtAmt());
		this.hashColumns.put("rhq_cd", getRhqCd());
		this.hashColumns.put("mst_rout_id", getMstRoutId());
		this.hashColumns.put("note_conv_chg_cd", getNoteConvChgCd());
		this.hashColumns.put("org_pnt_loc_def_cd", getOrgPntLocDefCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("bkg_vvd_cd", getBkgVvdCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("dest_pnt_loc_def_cd", "destPntLocDefCd");
		this.hashFields.put("note_conv_seq", "noteConvSeq");
		this.hashFields.put("prop_frt_d4_rt_amt", "propFrtD4RtAmt");
		this.hashFields.put("bkg_dir_call_flg", "bkgDirCallFlg");
		this.hashFields.put("mst_rfa_no", "mstRfaNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prop_frt_d2_rt_amt", "propFrtD2RtAmt");
		this.hashFields.put("org_via_port_def_cd", "orgViaPortDefCd");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_ts_port_def_cd", "bkgTsPortDefCd");
		this.hashFields.put("prop_sts_cd", "propStsCd");
		this.hashFields.put("bkg_slan_cd", "bkgSlanCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("prc_cmdt_def_cd", "prcCmdtDefCd");
		this.hashFields.put("dest_via_port_def_cd", "destViaPortDefCd");
		this.hashFields.put("prop_frt_d5_rt_amt", "propFrtD5RtAmt");
		this.hashFields.put("rhq_cd", "rhqCd");
		this.hashFields.put("mst_rout_id", "mstRoutId");
		this.hashFields.put("note_conv_chg_cd", "noteConvChgCd");
		this.hashFields.put("org_pnt_loc_def_cd", "orgPntLocDefCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("bkg_vvd_cd", "bkgVvdCd");
		return this.hashFields;
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
	 * @return destPntLocDefCd
	 */
	public String getDestPntLocDefCd() {
		return this.destPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @return noteConvSeq
	 */
	public String getNoteConvSeq() {
		return this.noteConvSeq;
	}
	
	/**
	 * Column Info
	 * @return propFrtD4RtAmt
	 */
	public String getPropFrtD4RtAmt() {
		return this.propFrtD4RtAmt;
	}
	
	/**
	 * Column Info
	 * @return bkgDirCallFlg
	 */
	public String getBkgDirCallFlg() {
		return this.bkgDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @return mstRfaNo
	 */
	public String getMstRfaNo() {
		return this.mstRfaNo;
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
	 * @return propFrtD2RtAmt
	 */
	public String getPropFrtD2RtAmt() {
		return this.propFrtD2RtAmt;
	}
	
	/**
	 * Column Info
	 * @return orgViaPortDefCd
	 */
	public String getOrgViaPortDefCd() {
		return this.orgViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
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
	 * @return bkgTsPortDefCd
	 */
	public String getBkgTsPortDefCd() {
		return this.bkgTsPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return propStsCd
	 */
	public String getPropStsCd() {
		return this.propStsCd;
	}
	
	/**
	 * Column Info
	 * @return bkgSlanCd
	 */
	public String getBkgSlanCd() {
		return this.bkgSlanCd;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return prcCmdtDefCd
	 */
	public String getPrcCmdtDefCd() {
		return this.prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @return destViaPortDefCd
	 */
	public String getDestViaPortDefCd() {
		return this.destViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @return propFrtD5RtAmt
	 */
	public String getPropFrtD5RtAmt() {
		return this.propFrtD5RtAmt;
	}
	
	/**
	 * Column Info
	 * @return rhqCd
	 */
	public String getRhqCd() {
		return this.rhqCd;
	}
	
	/**
	 * Column Info
	 * @return mstRoutId
	 */
	public String getMstRoutId() {
		return this.mstRoutId;
	}
	
	/**
	 * Column Info
	 * @return noteConvChgCd
	 */
	public String getNoteConvChgCd() {
		return this.noteConvChgCd;
	}
	
	/**
	 * Column Info
	 * @return orgPntLocDefCd
	 */
	public String getOrgPntLocDefCd() {
		return this.orgPntLocDefCd;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return bkgVvdCd
	 */
	public String getBkgVvdCd() {
		return this.bkgVvdCd;
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
	 * @param destPntLocDefCd
	 */
	public void setDestPntLocDefCd(String destPntLocDefCd) {
		this.destPntLocDefCd = destPntLocDefCd;
	}
	
	/**
	 * Column Info
	 * @param noteConvSeq
	 */
	public void setNoteConvSeq(String noteConvSeq) {
		this.noteConvSeq = noteConvSeq;
	}
	
	/**
	 * Column Info
	 * @param propFrtD4RtAmt
	 */
	public void setPropFrtD4RtAmt(String propFrtD4RtAmt) {
		this.propFrtD4RtAmt = propFrtD4RtAmt;
	}
	
	/**
	 * Column Info
	 * @param bkgDirCallFlg
	 */
	public void setBkgDirCallFlg(String bkgDirCallFlg) {
		this.bkgDirCallFlg = bkgDirCallFlg;
	}
	
	/**
	 * Column Info
	 * @param mstRfaNo
	 */
	public void setMstRfaNo(String mstRfaNo) {
		this.mstRfaNo = mstRfaNo;
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
	 * @param propFrtD2RtAmt
	 */
	public void setPropFrtD2RtAmt(String propFrtD2RtAmt) {
		this.propFrtD2RtAmt = propFrtD2RtAmt;
	}
	
	/**
	 * Column Info
	 * @param orgViaPortDefCd
	 */
	public void setOrgViaPortDefCd(String orgViaPortDefCd) {
		this.orgViaPortDefCd = orgViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
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
	 * @param bkgTsPortDefCd
	 */
	public void setBkgTsPortDefCd(String bkgTsPortDefCd) {
		this.bkgTsPortDefCd = bkgTsPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param propStsCd
	 */
	public void setPropStsCd(String propStsCd) {
		this.propStsCd = propStsCd;
	}
	
	/**
	 * Column Info
	 * @param bkgSlanCd
	 */
	public void setBkgSlanCd(String bkgSlanCd) {
		this.bkgSlanCd = bkgSlanCd;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param prcCmdtDefCd
	 */
	public void setPrcCmdtDefCd(String prcCmdtDefCd) {
		this.prcCmdtDefCd = prcCmdtDefCd;
	}
	
	/**
	 * Column Info
	 * @param destViaPortDefCd
	 */
	public void setDestViaPortDefCd(String destViaPortDefCd) {
		this.destViaPortDefCd = destViaPortDefCd;
	}
	
	/**
	 * Column Info
	 * @param propFrtD5RtAmt
	 */
	public void setPropFrtD5RtAmt(String propFrtD5RtAmt) {
		this.propFrtD5RtAmt = propFrtD5RtAmt;
	}
	
	/**
	 * Column Info
	 * @param rhqCd
	 */
	public void setRhqCd(String rhqCd) {
		this.rhqCd = rhqCd;
	}
	
	/**
	 * Column Info
	 * @param mstRoutId
	 */
	public void setMstRoutId(String mstRoutId) {
		this.mstRoutId = mstRoutId;
	}
	
	/**
	 * Column Info
	 * @param noteConvChgCd
	 */
	public void setNoteConvChgCd(String noteConvChgCd) {
		this.noteConvChgCd = noteConvChgCd;
	}
	
	/**
	 * Column Info
	 * @param orgPntLocDefCd
	 */
	public void setOrgPntLocDefCd(String orgPntLocDefCd) {
		this.orgPntLocDefCd = orgPntLocDefCd;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param bkgVvdCd
	 */
	public void setBkgVvdCd(String bkgVvdCd) {
		this.bkgVvdCd = bkgVvdCd;
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
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setDestPntLocDefCd(JSPUtil.getParameter(request, prefix + "dest_pnt_loc_def_cd", ""));
		setNoteConvSeq(JSPUtil.getParameter(request, prefix + "note_conv_seq", ""));
		setPropFrtD4RtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_d4_rt_amt", ""));
		setBkgDirCallFlg(JSPUtil.getParameter(request, prefix + "bkg_dir_call_flg", ""));
		setMstRfaNo(JSPUtil.getParameter(request, prefix + "mst_rfa_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPropFrtD2RtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_d2_rt_amt", ""));
		setOrgViaPortDefCd(JSPUtil.getParameter(request, prefix + "org_via_port_def_cd", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgTsPortDefCd(JSPUtil.getParameter(request, prefix + "bkg_ts_port_def_cd", ""));
		setPropStsCd(JSPUtil.getParameter(request, prefix + "prop_sts_cd", ""));
		setBkgSlanCd(JSPUtil.getParameter(request, prefix + "bkg_slan_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setPrcCmdtDefCd(JSPUtil.getParameter(request, prefix + "prc_cmdt_def_cd", ""));
		setDestViaPortDefCd(JSPUtil.getParameter(request, prefix + "dest_via_port_def_cd", ""));
		setPropFrtD5RtAmt(JSPUtil.getParameter(request, prefix + "prop_frt_d5_rt_amt", ""));
		setRhqCd(JSPUtil.getParameter(request, prefix + "rhq_cd", ""));
		setMstRoutId(JSPUtil.getParameter(request, prefix + "mst_rout_id", ""));
		setNoteConvChgCd(JSPUtil.getParameter(request, prefix + "note_conv_chg_cd", ""));
		setOrgPntLocDefCd(JSPUtil.getParameter(request, prefix + "org_pnt_loc_def_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setBkgVvdCd(JSPUtil.getParameter(request, prefix + "bkg_vvd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriMasterRFAOnlyVO[]
	 */
	public RsltPriMasterRFAOnlyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriMasterRFAOnlyVO[]
	 */
	public RsltPriMasterRFAOnlyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriMasterRFAOnlyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] destPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_pnt_loc_def_cd", length));
			String[] noteConvSeq = (JSPUtil.getParameter(request, prefix	+ "note_conv_seq", length));
			String[] propFrtD4RtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_d4_rt_amt", length));
			String[] bkgDirCallFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_dir_call_flg", length));
			String[] mstRfaNo = (JSPUtil.getParameter(request, prefix	+ "mst_rfa_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] propFrtD2RtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_d2_rt_amt", length));
			String[] orgViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "org_via_port_def_cd", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgTsPortDefCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ts_port_def_cd", length));
			String[] propStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_sts_cd", length));
			String[] bkgSlanCd = (JSPUtil.getParameter(request, prefix	+ "bkg_slan_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] prcCmdtDefCd = (JSPUtil.getParameter(request, prefix	+ "prc_cmdt_def_cd", length));
			String[] destViaPortDefCd = (JSPUtil.getParameter(request, prefix	+ "dest_via_port_def_cd", length));
			String[] propFrtD5RtAmt = (JSPUtil.getParameter(request, prefix	+ "prop_frt_d5_rt_amt", length));
			String[] rhqCd = (JSPUtil.getParameter(request, prefix	+ "rhq_cd", length));
			String[] mstRoutId = (JSPUtil.getParameter(request, prefix	+ "mst_rout_id", length));
			String[] noteConvChgCd = (JSPUtil.getParameter(request, prefix	+ "note_conv_chg_cd", length));
			String[] orgPntLocDefCd = (JSPUtil.getParameter(request, prefix	+ "org_pnt_loc_def_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] bkgVvdCd = (JSPUtil.getParameter(request, prefix	+ "bkg_vvd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriMasterRFAOnlyVO();
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (destPntLocDefCd[i] != null)
					model.setDestPntLocDefCd(destPntLocDefCd[i]);
				if (noteConvSeq[i] != null)
					model.setNoteConvSeq(noteConvSeq[i]);
				if (propFrtD4RtAmt[i] != null)
					model.setPropFrtD4RtAmt(propFrtD4RtAmt[i]);
				if (bkgDirCallFlg[i] != null)
					model.setBkgDirCallFlg(bkgDirCallFlg[i]);
				if (mstRfaNo[i] != null)
					model.setMstRfaNo(mstRfaNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (propFrtD2RtAmt[i] != null)
					model.setPropFrtD2RtAmt(propFrtD2RtAmt[i]);
				if (orgViaPortDefCd[i] != null)
					model.setOrgViaPortDefCd(orgViaPortDefCd[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgTsPortDefCd[i] != null)
					model.setBkgTsPortDefCd(bkgTsPortDefCd[i]);
				if (propStsCd[i] != null)
					model.setPropStsCd(propStsCd[i]);
				if (bkgSlanCd[i] != null)
					model.setBkgSlanCd(bkgSlanCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (prcCmdtDefCd[i] != null)
					model.setPrcCmdtDefCd(prcCmdtDefCd[i]);
				if (destViaPortDefCd[i] != null)
					model.setDestViaPortDefCd(destViaPortDefCd[i]);
				if (propFrtD5RtAmt[i] != null)
					model.setPropFrtD5RtAmt(propFrtD5RtAmt[i]);
				if (rhqCd[i] != null)
					model.setRhqCd(rhqCd[i]);
				if (mstRoutId[i] != null)
					model.setMstRoutId(mstRoutId[i]);
				if (noteConvChgCd[i] != null)
					model.setNoteConvChgCd(noteConvChgCd[i]);
				if (orgPntLocDefCd[i] != null)
					model.setOrgPntLocDefCd(orgPntLocDefCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (bkgVvdCd[i] != null)
					model.setBkgVvdCd(bkgVvdCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriMasterRFAOnlyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriMasterRFAOnlyVO[]
	 */
	public RsltPriMasterRFAOnlyVO[] getRsltPriMasterRFAOnlyVOs(){
		RsltPriMasterRFAOnlyVO[] vos = (RsltPriMasterRFAOnlyVO[])models.toArray(new RsltPriMasterRFAOnlyVO[models.size()]);
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
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destPntLocDefCd = this.destPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvSeq = this.noteConvSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtD4RtAmt = this.propFrtD4RtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDirCallFlg = this.bkgDirCallFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstRfaNo = this.mstRfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtD2RtAmt = this.propFrtD2RtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgViaPortDefCd = this.orgViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTsPortDefCd = this.bkgTsPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propStsCd = this.propStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgSlanCd = this.bkgSlanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCmdtDefCd = this.prcCmdtDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destViaPortDefCd = this.destViaPortDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propFrtD5RtAmt = this.propFrtD5RtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rhqCd = this.rhqCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mstRoutId = this.mstRoutId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvChgCd = this.noteConvChgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgPntLocDefCd = this.orgPntLocDefCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgVvdCd = this.bkgVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
