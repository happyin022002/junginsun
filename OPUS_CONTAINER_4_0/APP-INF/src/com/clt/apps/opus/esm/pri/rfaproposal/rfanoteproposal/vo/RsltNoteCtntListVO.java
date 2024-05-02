/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltNoteCtntListVO.java
*@FileTitle : RsltNoteCtntListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.02
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2009.12.02 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltNoteCtntListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltNoteCtntListVO> models = new ArrayList<RsltNoteCtntListVO>();
	
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String noteChgTpCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String chgCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcProgStsCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String noteTpCd = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String befExpDt = null;
	/* Column Info */
	private String acptOfcCd = null;
	/* Column Info */
	private String acptDt = null;
	/* Column Info */
	private String prevNoteConvMapgId = null;
	/* Column Info */
	private String befEffDt = null;
	/* Column Info */
	private String acptUsrNm = null;
	/* Column Info */
	private String srcInfoCd = null;
	/* Column Info */
	private String noteSeq = null;
	/* Column Info */
	private String noteConvFlg = null;
	/* Column Info */
	private String noteCtntSeq = null;
	/* Column Info */
	private String noteConvMapgId = null;
	/* Column Info */
	private String n1stCmncAmdtSeq = null;
	/* Column Info */
	private String propNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltNoteCtntListVO() {}

	public RsltNoteCtntListVO(String ibflag, String pagerows, String dpSeq, String noteChgTpCd, String prevNoteConvMapgId, String acptDt, String acptOfcCd, String amdtSeq, String acptUsrNm, String svcScpCd, String srcInfoCd, String noteSeq, String noteCtnt, String noteConvFlg, String noteCtntSeq, String chgCd, String noteConvMapgId, String prcProgStsCd, String effDt, String noteTpCd, String n1stCmncAmdtSeq, String propNo, String expDt, String befEffDt, String befExpDt) {
		this.dpSeq = dpSeq;
		this.noteChgTpCd = noteChgTpCd;
		this.amdtSeq = amdtSeq;
		this.svcScpCd = svcScpCd;
		this.noteCtnt = noteCtnt;
		this.chgCd = chgCd;
		this.pagerows = pagerows;
		this.prcProgStsCd = prcProgStsCd;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.noteTpCd = noteTpCd;
		this.expDt = expDt;
		this.befExpDt = befExpDt;
		this.acptOfcCd = acptOfcCd;
		this.acptDt = acptDt;
		this.prevNoteConvMapgId = prevNoteConvMapgId;
		this.befEffDt = befEffDt;
		this.acptUsrNm = acptUsrNm;
		this.srcInfoCd = srcInfoCd;
		this.noteSeq = noteSeq;
		this.noteConvFlg = noteConvFlg;
		this.noteCtntSeq = noteCtntSeq;
		this.noteConvMapgId = noteConvMapgId;
		this.n1stCmncAmdtSeq = n1stCmncAmdtSeq;
		this.propNo = propNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("note_chg_tp_cd", getNoteChgTpCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("chg_cd", getChgCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_prog_sts_cd", getPrcProgStsCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("note_tp_cd", getNoteTpCd());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("bef_exp_dt", getBefExpDt());
		this.hashColumns.put("acpt_ofc_cd", getAcptOfcCd());
		this.hashColumns.put("acpt_dt", getAcptDt());
		this.hashColumns.put("prev_note_conv_mapg_id", getPrevNoteConvMapgId());
		this.hashColumns.put("bef_eff_dt", getBefEffDt());
		this.hashColumns.put("acpt_usr_nm", getAcptUsrNm());
		this.hashColumns.put("src_info_cd", getSrcInfoCd());
		this.hashColumns.put("note_seq", getNoteSeq());
		this.hashColumns.put("note_conv_flg", getNoteConvFlg());
		this.hashColumns.put("note_ctnt_seq", getNoteCtntSeq());
		this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
		this.hashColumns.put("n1st_cmnc_amdt_seq", getN1stCmncAmdtSeq());
		this.hashColumns.put("prop_no", getPropNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("note_chg_tp_cd", "noteChgTpCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("chg_cd", "chgCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_prog_sts_cd", "prcProgStsCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("note_tp_cd", "noteTpCd");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("bef_exp_dt", "befExpDt");
		this.hashFields.put("acpt_ofc_cd", "acptOfcCd");
		this.hashFields.put("acpt_dt", "acptDt");
		this.hashFields.put("prev_note_conv_mapg_id", "prevNoteConvMapgId");
		this.hashFields.put("bef_eff_dt", "befEffDt");
		this.hashFields.put("acpt_usr_nm", "acptUsrNm");
		this.hashFields.put("src_info_cd", "srcInfoCd");
		this.hashFields.put("note_seq", "noteSeq");
		this.hashFields.put("note_conv_flg", "noteConvFlg");
		this.hashFields.put("note_ctnt_seq", "noteCtntSeq");
		this.hashFields.put("note_conv_mapg_id", "noteConvMapgId");
		this.hashFields.put("n1st_cmnc_amdt_seq", "n1stCmncAmdtSeq");
		this.hashFields.put("prop_no", "propNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
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
	 * @return noteCtnt
	 */
	public String getNoteCtnt() {
		return this.noteCtnt;
	}
	
	/**
	 * Column Info
	 * @return chgCd
	 */
	public String getChgCd() {
		return this.chgCd;
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
	 * @return prcProgStsCd
	 */
	public String getPrcProgStsCd() {
		return this.prcProgStsCd;
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
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return noteTpCd
	 */
	public String getNoteTpCd() {
		return this.noteTpCd;
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
	 * @return befExpDt
	 */
	public String getBefExpDt() {
		return this.befExpDt;
	}
	
	/**
	 * Column Info
	 * @return acptOfcCd
	 */
	public String getAcptOfcCd() {
		return this.acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @return acptDt
	 */
	public String getAcptDt() {
		return this.acptDt;
	}
	
	/**
	 * Column Info
	 * @return prevNoteConvMapgId
	 */
	public String getPrevNoteConvMapgId() {
		return this.prevNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @return befEffDt
	 */
	public String getBefEffDt() {
		return this.befEffDt;
	}
	
	/**
	 * Column Info
	 * @return acptUsrNm
	 */
	public String getAcptUsrNm() {
		return this.acptUsrNm;
	}
	
	/**
	 * Column Info
	 * @return srcInfoCd
	 */
	public String getSrcInfoCd() {
		return this.srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @return noteSeq
	 */
	public String getNoteSeq() {
		return this.noteSeq;
	}
	
	/**
	 * Column Info
	 * @return noteConvFlg
	 */
	public String getNoteConvFlg() {
		return this.noteConvFlg;
	}
	
	/**
	 * Column Info
	 * @return noteCtntSeq
	 */
	public String getNoteCtntSeq() {
		return this.noteCtntSeq;
	}
	
	/**
	 * Column Info
	 * @return noteConvMapgId
	 */
	public String getNoteConvMapgId() {
		return this.noteConvMapgId;
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
	 * @return propNo
	 */
	public String getPropNo() {
		return this.propNo;
	}
	

	/**
	 * Column Info
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
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
	 * @param noteCtnt
	 */
	public void setNoteCtnt(String noteCtnt) {
		this.noteCtnt = noteCtnt;
	}
	
	/**
	 * Column Info
	 * @param chgCd
	 */
	public void setChgCd(String chgCd) {
		this.chgCd = chgCd;
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
	 * @param prcProgStsCd
	 */
	public void setPrcProgStsCd(String prcProgStsCd) {
		this.prcProgStsCd = prcProgStsCd;
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
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param noteTpCd
	 */
	public void setNoteTpCd(String noteTpCd) {
		this.noteTpCd = noteTpCd;
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
	 * @param befExpDt
	 */
	public void setBefExpDt(String befExpDt) {
		this.befExpDt = befExpDt;
	}
	
	/**
	 * Column Info
	 * @param acptOfcCd
	 */
	public void setAcptOfcCd(String acptOfcCd) {
		this.acptOfcCd = acptOfcCd;
	}
	
	/**
	 * Column Info
	 * @param acptDt
	 */
	public void setAcptDt(String acptDt) {
		this.acptDt = acptDt;
	}
	
	/**
	 * Column Info
	 * @param prevNoteConvMapgId
	 */
	public void setPrevNoteConvMapgId(String prevNoteConvMapgId) {
		this.prevNoteConvMapgId = prevNoteConvMapgId;
	}
	
	/**
	 * Column Info
	 * @param befEffDt
	 */
	public void setBefEffDt(String befEffDt) {
		this.befEffDt = befEffDt;
	}
	
	/**
	 * Column Info
	 * @param acptUsrNm
	 */
	public void setAcptUsrNm(String acptUsrNm) {
		this.acptUsrNm = acptUsrNm;
	}
	
	/**
	 * Column Info
	 * @param srcInfoCd
	 */
	public void setSrcInfoCd(String srcInfoCd) {
		this.srcInfoCd = srcInfoCd;
	}
	
	/**
	 * Column Info
	 * @param noteSeq
	 */
	public void setNoteSeq(String noteSeq) {
		this.noteSeq = noteSeq;
	}
	
	/**
	 * Column Info
	 * @param noteConvFlg
	 */
	public void setNoteConvFlg(String noteConvFlg) {
		this.noteConvFlg = noteConvFlg;
	}
	
	/**
	 * Column Info
	 * @param noteCtntSeq
	 */
	public void setNoteCtntSeq(String noteCtntSeq) {
		this.noteCtntSeq = noteCtntSeq;
	}
	
	/**
	 * Column Info
	 * @param noteConvMapgId
	 */
	public void setNoteConvMapgId(String noteConvMapgId) {
		this.noteConvMapgId = noteConvMapgId;
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
	 * @param propNo
	 */
	public void setPropNo(String propNo) {
		this.propNo = propNo;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setDpSeq(JSPUtil.getParameter(request, "dp_seq", ""));
		setNoteChgTpCd(JSPUtil.getParameter(request, "note_chg_tp_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, "amdt_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setNoteCtnt(JSPUtil.getParameter(request, "note_ctnt", ""));
		setChgCd(JSPUtil.getParameter(request, "chg_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcProgStsCd(JSPUtil.getParameter(request, "prc_prog_sts_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setNoteTpCd(JSPUtil.getParameter(request, "note_tp_cd", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setBefExpDt(JSPUtil.getParameter(request, "bef_exp_dt", ""));
		setAcptOfcCd(JSPUtil.getParameter(request, "acpt_ofc_cd", ""));
		setAcptDt(JSPUtil.getParameter(request, "acpt_dt", ""));
		setPrevNoteConvMapgId(JSPUtil.getParameter(request, "prev_note_conv_mapg_id", ""));
		setBefEffDt(JSPUtil.getParameter(request, "bef_eff_dt", ""));
		setAcptUsrNm(JSPUtil.getParameter(request, "acpt_usr_nm", ""));
		setSrcInfoCd(JSPUtil.getParameter(request, "src_info_cd", ""));
		setNoteSeq(JSPUtil.getParameter(request, "note_seq", ""));
		setNoteConvFlg(JSPUtil.getParameter(request, "note_conv_flg", ""));
		setNoteCtntSeq(JSPUtil.getParameter(request, "note_ctnt_seq", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request, "note_conv_mapg_id", ""));
		setN1stCmncAmdtSeq(JSPUtil.getParameter(request, "n1st_cmnc_amdt_seq", ""));
		setPropNo(JSPUtil.getParameter(request, "prop_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltNoteCtntListVO[]
	 */
	public RsltNoteCtntListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltNoteCtntListVO[]
	 */
	public RsltNoteCtntListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltNoteCtntListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] noteChgTpCd = (JSPUtil.getParameter(request, prefix	+ "note_chg_tp_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] chgCd = (JSPUtil.getParameter(request, prefix	+ "chg_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcProgStsCd = (JSPUtil.getParameter(request, prefix	+ "prc_prog_sts_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] noteTpCd = (JSPUtil.getParameter(request, prefix	+ "note_tp_cd", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] befExpDt = (JSPUtil.getParameter(request, prefix	+ "bef_exp_dt", length));
			String[] acptOfcCd = (JSPUtil.getParameter(request, prefix	+ "acpt_ofc_cd", length));
			String[] acptDt = (JSPUtil.getParameter(request, prefix	+ "acpt_dt", length));
			String[] prevNoteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "prev_note_conv_mapg_id", length));
			String[] befEffDt = (JSPUtil.getParameter(request, prefix	+ "bef_eff_dt", length));
			String[] acptUsrNm = (JSPUtil.getParameter(request, prefix	+ "acpt_usr_nm", length));
			String[] srcInfoCd = (JSPUtil.getParameter(request, prefix	+ "src_info_cd", length));
			String[] noteSeq = (JSPUtil.getParameter(request, prefix	+ "note_seq", length));
			String[] noteConvFlg = (JSPUtil.getParameter(request, prefix	+ "note_conv_flg", length));
			String[] noteCtntSeq = (JSPUtil.getParameter(request, prefix	+ "note_ctnt_seq", length));
			String[] noteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "note_conv_mapg_id", length));
			String[] n1stCmncAmdtSeq = (JSPUtil.getParameter(request, prefix	+ "n1st_cmnc_amdt_seq", length));
			String[] propNo = (JSPUtil.getParameter(request, prefix	+ "prop_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltNoteCtntListVO();
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (noteChgTpCd[i] != null)
					model.setNoteChgTpCd(noteChgTpCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (chgCd[i] != null)
					model.setChgCd(chgCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcProgStsCd[i] != null)
					model.setPrcProgStsCd(prcProgStsCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (noteTpCd[i] != null)
					model.setNoteTpCd(noteTpCd[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (befExpDt[i] != null)
					model.setBefExpDt(befExpDt[i]);
				if (acptOfcCd[i] != null)
					model.setAcptOfcCd(acptOfcCd[i]);
				if (acptDt[i] != null)
					model.setAcptDt(acptDt[i]);
				if (prevNoteConvMapgId[i] != null)
					model.setPrevNoteConvMapgId(prevNoteConvMapgId[i]);
				if (befEffDt[i] != null)
					model.setBefEffDt(befEffDt[i]);
				if (acptUsrNm[i] != null)
					model.setAcptUsrNm(acptUsrNm[i]);
				if (srcInfoCd[i] != null)
					model.setSrcInfoCd(srcInfoCd[i]);
				if (noteSeq[i] != null)
					model.setNoteSeq(noteSeq[i]);
				if (noteConvFlg[i] != null)
					model.setNoteConvFlg(noteConvFlg[i]);
				if (noteCtntSeq[i] != null)
					model.setNoteCtntSeq(noteCtntSeq[i]);
				if (noteConvMapgId[i] != null)
					model.setNoteConvMapgId(noteConvMapgId[i]);
				if (n1stCmncAmdtSeq[i] != null)
					model.setN1stCmncAmdtSeq(n1stCmncAmdtSeq[i]);
				if (propNo[i] != null)
					model.setPropNo(propNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltNoteCtntListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltNoteCtntListVO[]
	 */
	public RsltNoteCtntListVO[] getRsltNoteCtntListVOs(){
		RsltNoteCtntListVO[] vos = (RsltNoteCtntListVO[])models.toArray(new RsltNoteCtntListVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteChgTpCd = this.noteChgTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCd = this.chgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcProgStsCd = this.prcProgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteTpCd = this.noteTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befExpDt = this.befExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptOfcCd = this.acptOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptDt = this.acptDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prevNoteConvMapgId = this.prevNoteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.befEffDt = this.befEffDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.acptUsrNm = this.acptUsrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srcInfoCd = this.srcInfoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteSeq = this.noteSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvFlg = this.noteConvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtntSeq = this.noteCtntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvMapgId = this.noteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.n1stCmncAmdtSeq = this.n1stCmncAmdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.propNo = this.propNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
