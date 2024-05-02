/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : RsltPropMnScpListVO.java
*@FileTitle : RsltPropMnScpListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.03.13
*@LastModifier : 송호진
*@LastVersion : 1.0
* 2015.03.13 송호진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scproposal.scproposalmain.vo;

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
 * @author 송호진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPropMnScpListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPropMnScpListVO> models = new ArrayList<RsltPropMnScpListVO>();
	
	/* Column Info */
	private String preExpDt = null;
	/* Column Info */
	private String newScgFlg = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String newInsFlg = null;
	/* Column Info */
	private String ctrtEffDt = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String propScpMqcQty = null;
	/* Column Info */
	private String preExtScp = null;
	/* Column Info */
	private String durDupFlg = null;
	/* Column Info */
	private String propNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String ctrtExpDt = null;
	/* Column Info */
	private String propScpAproOfcCd = null;
	/* Column Info */
	private String griApplFlg = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String cntrLodUtCd = null;
	/* Column Info */
	private String acptCnt = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String noteHdrSeq = null;
	/* Column Info */
	private String propScpSts = null;
	/* Column Info */
	private String propScpSrepCd = null;
	/* Column Info */
	private String propScpOfcCd = null;
	/* Column Info */
	private String chssExptFlg = null;
	/* Column Info */
	private String amdtCnt = null;
	/* Column Info */
	private String propScpStsCd = null;
	/* Column Info */
	private String amdScpFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltPropMnScpListVO() {}

	public RsltPropMnScpListVO(String ibflag, String pagerows, String propNo, String amdtSeq, String svcScpCd, String propScpAproOfcCd, String propScpOfcCd, String propScpMqcQty, String cntrLodUtCd, String propScpSrepCd, String ctrtEffDt, String ctrtExpDt, String effDt, String expDt, String preExpDt, String durDupFlg, String propScpStsCd, String propScpSts, String noteHdrSeq, String amdScpFlg, String preExtScp, String chssExptFlg, String griApplFlg, String newScgFlg, String newInsFlg, String amdtCnt, String acptCnt) {
		this.preExpDt = preExpDt;
		this.newScgFlg = newScgFlg;
		this.ibflag = ibflag;
		this.expDt = expDt;
		this.newInsFlg = newInsFlg;
		this.ctrtEffDt = ctrtEffDt;
		this.svcScpCd = svcScpCd;
		this.propScpMqcQty = propScpMqcQty;
		this.preExtScp = preExtScp;
		this.durDupFlg = durDupFlg;
		this.propNo = propNo;
		this.pagerows = pagerows;
		this.ctrtExpDt = ctrtExpDt;
		this.propScpAproOfcCd = propScpAproOfcCd;
		this.griApplFlg = griApplFlg;
		this.effDt = effDt;
		this.cntrLodUtCd = cntrLodUtCd;
		this.acptCnt = acptCnt;
		this.amdtSeq = amdtSeq;
		this.noteHdrSeq = noteHdrSeq;
		this.propScpSts = propScpSts;
		this.propScpSrepCd = propScpSrepCd;
		this.propScpOfcCd = propScpOfcCd;
		this.chssExptFlg = chssExptFlg;
		this.amdtCnt = amdtCnt;
		this.propScpStsCd = propScpStsCd;
		this.amdScpFlg = amdScpFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pre_exp_dt", getPreExpDt());
		this.hashColumns.put("new_scg_flg", getNewScgFlg());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("new_ins_flg", getNewInsFlg());
		this.hashColumns.put("ctrt_eff_dt", getCtrtEffDt());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("prop_scp_mqc_qty", getPropScpMqcQty());
		this.hashColumns.put("pre_ext_scp", getPreExtScp());
		this.hashColumns.put("dur_dup_flg", getDurDupFlg());
		this.hashColumns.put("prop_no", getPropNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ctrt_exp_dt", getCtrtExpDt());
		this.hashColumns.put("prop_scp_apro_ofc_cd", getPropScpAproOfcCd());
		this.hashColumns.put("gri_appl_flg", getGriApplFlg());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cntr_lod_ut_cd", getCntrLodUtCd());
		this.hashColumns.put("acpt_cnt", getAcptCnt());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("note_hdr_seq", getNoteHdrSeq());
		this.hashColumns.put("prop_scp_sts", getPropScpSts());
		this.hashColumns.put("prop_scp_srep_cd", getPropScpSrepCd());
		this.hashColumns.put("prop_scp_ofc_cd", getPropScpOfcCd());
		this.hashColumns.put("chss_expt_flg", getChssExptFlg());
		this.hashColumns.put("amdt_cnt", getAmdtCnt());
		this.hashColumns.put("prop_scp_sts_cd", getPropScpStsCd());
		this.hashColumns.put("amd_scp_flg", getAmdScpFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pre_exp_dt", "preExpDt");
		this.hashFields.put("new_scg_flg", "newScgFlg");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("new_ins_flg", "newInsFlg");
		this.hashFields.put("ctrt_eff_dt", "ctrtEffDt");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("prop_scp_mqc_qty", "propScpMqcQty");
		this.hashFields.put("pre_ext_scp", "preExtScp");
		this.hashFields.put("dur_dup_flg", "durDupFlg");
		this.hashFields.put("prop_no", "propNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ctrt_exp_dt", "ctrtExpDt");
		this.hashFields.put("prop_scp_apro_ofc_cd", "propScpAproOfcCd");
		this.hashFields.put("gri_appl_flg", "griApplFlg");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cntr_lod_ut_cd", "cntrLodUtCd");
		this.hashFields.put("acpt_cnt", "acptCnt");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("note_hdr_seq", "noteHdrSeq");
		this.hashFields.put("prop_scp_sts", "propScpSts");
		this.hashFields.put("prop_scp_srep_cd", "propScpSrepCd");
		this.hashFields.put("prop_scp_ofc_cd", "propScpOfcCd");
		this.hashFields.put("chss_expt_flg", "chssExptFlg");
		this.hashFields.put("amdt_cnt", "amdtCnt");
		this.hashFields.put("prop_scp_sts_cd", "propScpStsCd");
		this.hashFields.put("amd_scp_flg", "amdScpFlg");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return preExpDt
	 */
	public String getPreExpDt() {
		return this.preExpDt;
	}
	
	/**
	 * Column Info
	 * @return newScgFlg
	 */
	public String getNewScgFlg() {
		return this.newScgFlg;
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
	 * @return expDt
	 */
	public String getExpDt() {
		return this.expDt;
	}
	
	/**
	 * Column Info
	 * @return newInsFlg
	 */
	public String getNewInsFlg() {
		return this.newInsFlg;
	}
	
	/**
	 * Column Info
	 * @return ctrtEffDt
	 */
	public String getCtrtEffDt() {
		return this.ctrtEffDt;
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
	 * @return propScpMqcQty
	 */
	public String getPropScpMqcQty() {
		return this.propScpMqcQty;
	}
	
	/**
	 * Column Info
	 * @return preExtScp
	 */
	public String getPreExtScp() {
		return this.preExtScp;
	}
	
	/**
	 * Column Info
	 * @return durDupFlg
	 */
	public String getDurDupFlg() {
		return this.durDupFlg;
	}
	
	/**
	 * Column Info
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
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
	 * @return ctrtExpDt
	 */
	public String getCtrtExpDt() {
		return this.ctrtExpDt;
	}
	
	/**
	 * Column Info
	 * @return propScpAproOfcCd
	 */
	public String getPropScpAproOfcCd() {
		return this.propScpAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return griApplFlg
	 */
	public String getGriApplFlg() {
		return this.griApplFlg;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return cntrLodUtCd
	 */
	public String getCntrLodUtCd() {
		return this.cntrLodUtCd;
	}
	
	/**
	 * Column Info
	 * @return acptCnt
	 */
	public String getAcptCnt() {
		return this.acptCnt;
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
	 * @return noteHdrSeq
	 */
	public String getNoteHdrSeq() {
		return this.noteHdrSeq;
	}
	
	/**
	 * Column Info
	 * @return propScpSts
	 */
	public String getPropScpSts() {
		return this.propScpSts;
	}
	
	/**
	 * Column Info
	 * @return propScpSrepCd
	 */
	public String getPropScpSrepCd() {
		return this.propScpSrepCd;
	}
	
	/**
	 * Column Info
	 * @return propScpOfcCd
	 */
	public String getPropScpOfcCd() {
		return this.propScpOfcCd;
	}
	
	/**
	 * Column Info
	 * @return chssExptFlg
	 */
	public String getChssExptFlg() {
		return this.chssExptFlg;
	}
	
	/**
	 * Column Info
	 * @return amdtCnt
	 */
	public String getAmdtCnt() {
		return this.amdtCnt;
	}
	
	/**
	 * Column Info
	 * @return propScpStsCd
	 */
	public String getPropScpStsCd() {
		return this.propScpStsCd;
	}
	
	/**
	 * Column Info
	 * @return amdScpFlg
	 */
	public String getAmdScpFlg() {
		return this.amdScpFlg;
	}
	

	/**
	 * Column Info
	 * @param preExpDt
	 */
	public void setPreExpDt(String preExpDt) {
		this.preExpDt = preExpDt;
	}
	
	/**
	 * Column Info
	 * @param newScgFlg
	 */
	public void setNewScgFlg(String newScgFlg) {
		this.newScgFlg = newScgFlg;
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
	 * @param expDt
	 */
	public void setExpDt(String expDt) {
		this.expDt = expDt;
	}
	
	/**
	 * Column Info
	 * @param newInsFlg
	 */
	public void setNewInsFlg(String newInsFlg) {
		this.newInsFlg = newInsFlg;
	}
	
	/**
	 * Column Info
	 * @param ctrtEffDt
	 */
	public void setCtrtEffDt(String ctrtEffDt) {
		this.ctrtEffDt = ctrtEffDt;
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
	 * @param propScpMqcQty
	 */
	public void setPropScpMqcQty(String propScpMqcQty) {
		this.propScpMqcQty = propScpMqcQty;
	}
	
	/**
	 * Column Info
	 * @param preExtScp
	 */
	public void setPreExtScp(String preExtScp) {
		this.preExtScp = preExtScp;
	}
	
	/**
	 * Column Info
	 * @param durDupFlg
	 */
	public void setDurDupFlg(String durDupFlg) {
		this.durDupFlg = durDupFlg;
	}
	
	/**
	 * Column Info
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
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
	 * @param ctrtExpDt
	 */
	public void setCtrtExpDt(String ctrtExpDt) {
		this.ctrtExpDt = ctrtExpDt;
	}
	
	/**
	 * Column Info
	 * @param propScpAproOfcCd
	 */
	public void setPropScpAproOfcCd(String propScpAproOfcCd) {
		this.propScpAproOfcCd = propScpAproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param griApplFlg
	 */
	public void setGriApplFlg(String griApplFlg) {
		this.griApplFlg = griApplFlg;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param cntrLodUtCd
	 */
	public void setCntrLodUtCd(String cntrLodUtCd) {
		this.cntrLodUtCd = cntrLodUtCd;
	}
	
	/**
	 * Column Info
	 * @param acptCnt
	 */
	public void setAcptCnt(String acptCnt) {
		this.acptCnt = acptCnt;
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
	 * @param noteHdrSeq
	 */
	public void setNoteHdrSeq(String noteHdrSeq) {
		this.noteHdrSeq = noteHdrSeq;
	}
	
	/**
	 * Column Info
	 * @param propScpSts
	 */
	public void setPropScpSts(String propScpSts) {
		this.propScpSts = propScpSts;
	}
	
	/**
	 * Column Info
	 * @param propScpSrepCd
	 */
	public void setPropScpSrepCd(String propScpSrepCd) {
		this.propScpSrepCd = propScpSrepCd;
	}
	
	/**
	 * Column Info
	 * @param propScpOfcCd
	 */
	public void setPropScpOfcCd(String propScpOfcCd) {
		this.propScpOfcCd = propScpOfcCd;
	}
	
	/**
	 * Column Info
	 * @param chssExptFlg
	 */
	public void setChssExptFlg(String chssExptFlg) {
		this.chssExptFlg = chssExptFlg;
	}
	
	/**
	 * Column Info
	 * @param amdtCnt
	 */
	public void setAmdtCnt(String amdtCnt) {
		this.amdtCnt = amdtCnt;
	}
	
	/**
	 * Column Info
	 * @param propScpStsCd
	 */
	public void setPropScpStsCd(String propScpStsCd) {
		this.propScpStsCd = propScpStsCd;
	}
	
	/**
	 * Column Info
	 * @param amdScpFlg
	 */
	public void setAmdScpFlg(String amdScpFlg) {
		this.amdScpFlg = amdScpFlg;
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
		setPreExpDt(JSPUtil.getParameter(request, prefix + "pre_exp_dt", ""));
		setNewScgFlg(JSPUtil.getParameter(request, prefix + "new_scg_flg", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setNewInsFlg(JSPUtil.getParameter(request, prefix + "new_ins_flg", ""));
		setCtrtEffDt(JSPUtil.getParameter(request, prefix + "ctrt_eff_dt", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setPropScpMqcQty(JSPUtil.getParameter(request, prefix + "prop_scp_mqc_qty", ""));
		setPreExtScp(JSPUtil.getParameter(request, prefix + "pre_ext_scp", ""));
		setDurDupFlg(JSPUtil.getParameter(request, prefix + "dur_dup_flg", ""));
		setPropNo(JSPUtil.getParameter(request, prefix + "prop_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setCtrtExpDt(JSPUtil.getParameter(request, prefix + "ctrt_exp_dt", ""));
		setPropScpAproOfcCd(JSPUtil.getParameter(request, prefix + "prop_scp_apro_ofc_cd", ""));
		setGriApplFlg(JSPUtil.getParameter(request, prefix + "gri_appl_flg", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setCntrLodUtCd(JSPUtil.getParameter(request, prefix + "cntr_lod_ut_cd", ""));
		setAcptCnt(JSPUtil.getParameter(request, prefix + "acpt_cnt", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setNoteHdrSeq(JSPUtil.getParameter(request, prefix + "note_hdr_seq", ""));
		setPropScpSts(JSPUtil.getParameter(request, prefix + "prop_scp_sts", ""));
		setPropScpSrepCd(JSPUtil.getParameter(request, prefix + "prop_scp_srep_cd", ""));
		setPropScpOfcCd(JSPUtil.getParameter(request, prefix + "prop_scp_ofc_cd", ""));
		setChssExptFlg(JSPUtil.getParameter(request, prefix + "chss_expt_flg", ""));
		setAmdtCnt(JSPUtil.getParameter(request, prefix + "amdt_cnt", ""));
		setPropScpStsCd(JSPUtil.getParameter(request, prefix + "prop_scp_sts_cd", ""));
		setAmdScpFlg(JSPUtil.getParameter(request, prefix + "amd_scp_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPropMnScpListVO[]
	 */
	public RsltPropMnScpListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPropMnScpListVO[]
	 */
	public RsltPropMnScpListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPropMnScpListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] preExpDt = (JSPUtil.getParameter(request, prefix	+ "pre_exp_dt", length));
			String[] newScgFlg = (JSPUtil.getParameter(request, prefix	+ "new_scg_flg", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] newInsFlg = (JSPUtil.getParameter(request, prefix	+ "new_ins_flg", length));
			String[] ctrtEffDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_eff_dt", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] propScpMqcQty = (JSPUtil.getParameter(request, prefix	+ "prop_scp_mqc_qty", length));
			String[] preExtScp = (JSPUtil.getParameter(request, prefix	+ "pre_ext_scp", length));
			String[] durDupFlg = (JSPUtil.getParameter(request, prefix	+ "dur_dup_flg", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ctrtExpDt = (JSPUtil.getParameter(request, prefix	+ "ctrt_exp_dt", length));
			String[] propScpAproOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_apro_ofc_cd", length));
			String[] griApplFlg = (JSPUtil.getParameter(request, prefix	+ "gri_appl_flg", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] cntrLodUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_lod_ut_cd", length));
			String[] acptCnt = (JSPUtil.getParameter(request, prefix	+ "acpt_cnt", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] noteHdrSeq = (JSPUtil.getParameter(request, prefix	+ "note_hdr_seq", length));
			String[] propScpSts = (JSPUtil.getParameter(request, prefix	+ "prop_scp_sts", length));
			String[] propScpSrepCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_srep_cd", length));
			String[] propScpOfcCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_ofc_cd", length));
			String[] chssExptFlg = (JSPUtil.getParameter(request, prefix	+ "chss_expt_flg", length));
			String[] amdtCnt = (JSPUtil.getParameter(request, prefix	+ "amdt_cnt", length));
			String[] propScpStsCd = (JSPUtil.getParameter(request, prefix	+ "prop_scp_sts_cd", length));
			String[] amdScpFlg = (JSPUtil.getParameter(request, prefix	+ "amd_scp_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPropMnScpListVO();
				if (preExpDt[i] != null)
					model.setPreExpDt(preExpDt[i]);
				if (newScgFlg[i] != null)
					model.setNewScgFlg(newScgFlg[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (newInsFlg[i] != null)
					model.setNewInsFlg(newInsFlg[i]);
				if (ctrtEffDt[i] != null)
					model.setCtrtEffDt(ctrtEffDt[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (propScpMqcQty[i] != null)
					model.setPropScpMqcQty(propScpMqcQty[i]);
				if (preExtScp[i] != null)
					model.setPreExtScp(preExtScp[i]);
				if (durDupFlg[i] != null)
					model.setDurDupFlg(durDupFlg[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ctrtExpDt[i] != null)
					model.setCtrtExpDt(ctrtExpDt[i]);
				if (propScpAproOfcCd[i] != null)
					model.setPropScpAproOfcCd(propScpAproOfcCd[i]);
				if (griApplFlg[i] != null)
					model.setGriApplFlg(griApplFlg[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (cntrLodUtCd[i] != null)
					model.setCntrLodUtCd(cntrLodUtCd[i]);
				if (acptCnt[i] != null)
					model.setAcptCnt(acptCnt[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (noteHdrSeq[i] != null)
					model.setNoteHdrSeq(noteHdrSeq[i]);
				if (propScpSts[i] != null)
					model.setPropScpSts(propScpSts[i]);
				if (propScpSrepCd[i] != null)
					model.setPropScpSrepCd(propScpSrepCd[i]);
				if (propScpOfcCd[i] != null)
					model.setPropScpOfcCd(propScpOfcCd[i]);
				if (chssExptFlg[i] != null)
					model.setChssExptFlg(chssExptFlg[i]);
				if (amdtCnt[i] != null)
					model.setAmdtCnt(amdtCnt[i]);
				if (propScpStsCd[i] != null)
					model.setPropScpStsCd(propScpStsCd[i]);
				if (amdScpFlg[i] != null)
					model.setAmdScpFlg(amdScpFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPropMnScpListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPropMnScpListVO[]
	 */
	public RsltPropMnScpListVO[] getRsltPropMnScpListVOs(){
		RsltPropMnScpListVO[] vos = (RsltPropMnScpListVO[])models.toArray(new RsltPropMnScpListVO[models.size()]);
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
		this.preExpDt = this.preExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newScgFlg = this.newScgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.newInsFlg = this.newInsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtEffDt = this.ctrtEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpMqcQty = this.propScpMqcQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preExtScp = this.preExtScp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.durDupFlg = this.durDupFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtExpDt = this.ctrtExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpAproOfcCd = this.propScpAproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.griApplFlg = this.griApplFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrLodUtCd = this.cntrLodUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptCnt = this.acptCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteHdrSeq = this.noteHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpSts = this.propScpSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpSrepCd = this.propScpSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpOfcCd = this.propScpOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chssExptFlg = this.chssExptFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtCnt = this.amdtCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propScpStsCd = this.propScpStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdScpFlg = this.amdScpFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
