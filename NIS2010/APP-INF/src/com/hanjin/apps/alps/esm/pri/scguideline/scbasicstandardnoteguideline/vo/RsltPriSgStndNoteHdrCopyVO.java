/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RsltPriSgStndNoteHdrCopyVO.java
*@FileTitle : RsltPriSgStndNoteHdrCopyVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.01
*@LastModifier : 이승준
*@LastVersion : 1.0
* 2009.12.01 이승준 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.pri.scguideline.scbasicstandardnoteguideline.vo;

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
 * @author 이승준
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSgStndNoteHdrCopyVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSgStndNoteHdrCopyVO> models = new ArrayList<RsltPriSgStndNoteHdrCopyVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String noteHdrSeqCopy = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String noteSeq = null;
	/* Column Info */
	private String noteNm = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String noteCtntSeq = null;
	/* Column Info */
	private String effDtHidden = null;
	/* Column Info */
	private String noteConvMapgId = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prcCustTpCdCopy = null;
	/* Column Info */
	private String expDtHidden = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String noteHdrSeq = null;
	/* Column Info */
	private String svcScpCdCopy = null;
	/* Column Info */
	private String cfmUsrId = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String noteRefYr = null;
	/* Column Info */
	private String prcCustTpCd = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RsltPriSgStndNoteHdrCopyVO() {}

	public RsltPriSgStndNoteHdrCopyVO(String ibflag, String pagerows, String updDt, String noteHdrSeqCopy, String svcScpCd, String creDt, String noteNm, String cfmFlg, String prcCustTpCdCopy, String effDt, String creUsrId, String noteHdrSeq, String svcScpCdCopy, String cfmUsrId, String expDt, String noteRefYr, String prcCustTpCd, String updUsrId, String noteConvMapgId, String noteSeq, String noteCtntSeq, String effDtHidden, String expDtHidden) {
		this.updDt = updDt;
		this.noteHdrSeqCopy = noteHdrSeqCopy;
		this.svcScpCd = svcScpCd;
		this.creDt = creDt;
		this.noteSeq = noteSeq;
		this.noteNm = noteNm;
		this.cfmFlg = cfmFlg;
		this.noteCtntSeq = noteCtntSeq;
		this.effDtHidden = effDtHidden;
		this.noteConvMapgId = noteConvMapgId;
		this.pagerows = pagerows;
		this.prcCustTpCdCopy = prcCustTpCdCopy;
		this.expDtHidden = expDtHidden;
		this.ibflag = ibflag;
		this.effDt = effDt;
		this.creUsrId = creUsrId;
		this.noteHdrSeq = noteHdrSeq;
		this.svcScpCdCopy = svcScpCdCopy;
		this.cfmUsrId = cfmUsrId;
		this.expDt = expDt;
		this.noteRefYr = noteRefYr;
		this.prcCustTpCd = prcCustTpCd;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("note_hdr_seq_copy", getNoteHdrSeqCopy());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("note_seq", getNoteSeq());
		this.hashColumns.put("note_nm", getNoteNm());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("note_ctnt_seq", getNoteCtntSeq());
		this.hashColumns.put("eff_dt_hidden", getEffDtHidden());
		this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("prc_cust_tp_cd_copy", getPrcCustTpCdCopy());
		this.hashColumns.put("exp_dt_hidden", getExpDtHidden());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("note_hdr_seq", getNoteHdrSeq());
		this.hashColumns.put("svc_scp_cd_copy", getSvcScpCdCopy());
		this.hashColumns.put("cfm_usr_id", getCfmUsrId());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("note_ref_yr", getNoteRefYr());
		this.hashColumns.put("prc_cust_tp_cd", getPrcCustTpCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("note_hdr_seq_copy", "noteHdrSeqCopy");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("note_seq", "noteSeq");
		this.hashFields.put("note_nm", "noteNm");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("note_ctnt_seq", "noteCtntSeq");
		this.hashFields.put("eff_dt_hidden", "effDtHidden");
		this.hashFields.put("note_conv_mapg_id", "noteConvMapgId");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("prc_cust_tp_cd_copy", "prcCustTpCdCopy");
		this.hashFields.put("exp_dt_hidden", "expDtHidden");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("note_hdr_seq", "noteHdrSeq");
		this.hashFields.put("svc_scp_cd_copy", "svcScpCdCopy");
		this.hashFields.put("cfm_usr_id", "cfmUsrId");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("note_ref_yr", "noteRefYr");
		this.hashFields.put("prc_cust_tp_cd", "prcCustTpCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
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
	 * @return noteHdrSeqCopy
	 */
	public String getNoteHdrSeqCopy() {
		return this.noteHdrSeqCopy;
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
	 * @return noteSeq
	 */
	public String getNoteSeq() {
		return this.noteSeq;
	}
	
	/**
	 * Column Info
	 * @return noteNm
	 */
	public String getNoteNm() {
		return this.noteNm;
	}
	
	/**
	 * Column Info
	 * @return cfmFlg
	 */
	public String getCfmFlg() {
		return this.cfmFlg;
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
	 * @return effDtHidden
	 */
	public String getEffDtHidden() {
		return this.effDtHidden;
	}
	
	/**
	 * Column Info
	 * @return noteConvMapgId
	 */
	public String getNoteConvMapgId() {
		return this.noteConvMapgId;
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
	 * @return prcCustTpCdCopy
	 */
	public String getPrcCustTpCdCopy() {
		return this.prcCustTpCdCopy;
	}
	
	/**
	 * Column Info
	 * @return expDtHidden
	 */
	public String getExpDtHidden() {
		return this.expDtHidden;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return svcScpCdCopy
	 */
	public String getSvcScpCdCopy() {
		return this.svcScpCdCopy;
	}
	
	/**
	 * Column Info
	 * @return cfmUsrId
	 */
	public String getCfmUsrId() {
		return this.cfmUsrId;
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
	 * @return noteRefYr
	 */
	public String getNoteRefYr() {
		return this.noteRefYr;
	}
	
	/**
	 * Column Info
	 * @return prcCustTpCd
	 */
	public String getPrcCustTpCd() {
		return this.prcCustTpCd;
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
	 * @param updDt
	 */
	public void setUpdDt(String updDt) {
		this.updDt = updDt;
	}
	
	/**
	 * Column Info
	 * @param noteHdrSeqCopy
	 */
	public void setNoteHdrSeqCopy(String noteHdrSeqCopy) {
		this.noteHdrSeqCopy = noteHdrSeqCopy;
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
	 * @param noteSeq
	 */
	public void setNoteSeq(String noteSeq) {
		this.noteSeq = noteSeq;
	}
	
	/**
	 * Column Info
	 * @param noteNm
	 */
	public void setNoteNm(String noteNm) {
		this.noteNm = noteNm;
	}
	
	/**
	 * Column Info
	 * @param cfmFlg
	 */
	public void setCfmFlg(String cfmFlg) {
		this.cfmFlg = cfmFlg;
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
	 * @param effDtHidden
	 */
	public void setEffDtHidden(String effDtHidden) {
		this.effDtHidden = effDtHidden;
	}
	
	/**
	 * Column Info
	 * @param noteConvMapgId
	 */
	public void setNoteConvMapgId(String noteConvMapgId) {
		this.noteConvMapgId = noteConvMapgId;
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
	 * @param prcCustTpCdCopy
	 */
	public void setPrcCustTpCdCopy(String prcCustTpCdCopy) {
		this.prcCustTpCdCopy = prcCustTpCdCopy;
	}
	
	/**
	 * Column Info
	 * @param expDtHidden
	 */
	public void setExpDtHidden(String expDtHidden) {
		this.expDtHidden = expDtHidden;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param svcScpCdCopy
	 */
	public void setSvcScpCdCopy(String svcScpCdCopy) {
		this.svcScpCdCopy = svcScpCdCopy;
	}
	
	/**
	 * Column Info
	 * @param cfmUsrId
	 */
	public void setCfmUsrId(String cfmUsrId) {
		this.cfmUsrId = cfmUsrId;
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
	 * @param noteRefYr
	 */
	public void setNoteRefYr(String noteRefYr) {
		this.noteRefYr = noteRefYr;
	}
	
	/**
	 * Column Info
	 * @param prcCustTpCd
	 */
	public void setPrcCustTpCd(String prcCustTpCd) {
		this.prcCustTpCd = prcCustTpCd;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setNoteHdrSeqCopy(JSPUtil.getParameter(request, "note_hdr_seq_copy", ""));
		setSvcScpCd(JSPUtil.getParameter(request, "svc_scp_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setNoteSeq(JSPUtil.getParameter(request, "note_seq", ""));
		setNoteNm(JSPUtil.getParameter(request, "note_nm", ""));
		setCfmFlg(JSPUtil.getParameter(request, "cfm_flg", ""));
		setNoteCtntSeq(JSPUtil.getParameter(request, "note_ctnt_seq", ""));
		setEffDtHidden(JSPUtil.getParameter(request, "eff_dt_hidden", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request, "note_conv_mapg_id", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPrcCustTpCdCopy(JSPUtil.getParameter(request, "prc_cust_tp_cd_copy", ""));
		setExpDtHidden(JSPUtil.getParameter(request, "exp_dt_hidden", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setNoteHdrSeq(JSPUtil.getParameter(request, "note_hdr_seq", ""));
		setSvcScpCdCopy(JSPUtil.getParameter(request, "svc_scp_cd_copy", ""));
		setCfmUsrId(JSPUtil.getParameter(request, "cfm_usr_id", ""));
		setExpDt(JSPUtil.getParameter(request, "exp_dt", ""));
		setNoteRefYr(JSPUtil.getParameter(request, "note_ref_yr", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, "prc_cust_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSgStndNoteHdrCopyVO[]
	 */
	public RsltPriSgStndNoteHdrCopyVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSgStndNoteHdrCopyVO[]
	 */
	public RsltPriSgStndNoteHdrCopyVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSgStndNoteHdrCopyVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] noteHdrSeqCopy = (JSPUtil.getParameter(request, prefix	+ "note_hdr_seq_copy", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] noteSeq = (JSPUtil.getParameter(request, prefix	+ "note_seq", length));
			String[] noteNm = (JSPUtil.getParameter(request, prefix	+ "note_nm", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] noteCtntSeq = (JSPUtil.getParameter(request, prefix	+ "note_ctnt_seq", length));
			String[] effDtHidden = (JSPUtil.getParameter(request, prefix	+ "eff_dt_hidden", length));
			String[] noteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "note_conv_mapg_id", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prcCustTpCdCopy = (JSPUtil.getParameter(request, prefix	+ "prc_cust_tp_cd_copy", length));
			String[] expDtHidden = (JSPUtil.getParameter(request, prefix	+ "exp_dt_hidden", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] noteHdrSeq = (JSPUtil.getParameter(request, prefix	+ "note_hdr_seq", length));
			String[] svcScpCdCopy = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd_copy", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] noteRefYr = (JSPUtil.getParameter(request, prefix	+ "note_ref_yr", length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cust_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSgStndNoteHdrCopyVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (noteHdrSeqCopy[i] != null)
					model.setNoteHdrSeqCopy(noteHdrSeqCopy[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (noteSeq[i] != null)
					model.setNoteSeq(noteSeq[i]);
				if (noteNm[i] != null)
					model.setNoteNm(noteNm[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (noteCtntSeq[i] != null)
					model.setNoteCtntSeq(noteCtntSeq[i]);
				if (effDtHidden[i] != null)
					model.setEffDtHidden(effDtHidden[i]);
				if (noteConvMapgId[i] != null)
					model.setNoteConvMapgId(noteConvMapgId[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prcCustTpCdCopy[i] != null)
					model.setPrcCustTpCdCopy(prcCustTpCdCopy[i]);
				if (expDtHidden[i] != null)
					model.setExpDtHidden(expDtHidden[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (noteHdrSeq[i] != null)
					model.setNoteHdrSeq(noteHdrSeq[i]);
				if (svcScpCdCopy[i] != null)
					model.setSvcScpCdCopy(svcScpCdCopy[i]);
				if (cfmUsrId[i] != null)
					model.setCfmUsrId(cfmUsrId[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (noteRefYr[i] != null)
					model.setNoteRefYr(noteRefYr[i]);
				if (prcCustTpCd[i] != null)
					model.setPrcCustTpCd(prcCustTpCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltPriSgStndNoteHdrCopyVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSgStndNoteHdrCopyVO[]
	 */
	public RsltPriSgStndNoteHdrCopyVO[] getRsltPriSgStndNoteHdrCopyVOs(){
		RsltPriSgStndNoteHdrCopyVO[] vos = (RsltPriSgStndNoteHdrCopyVO[])models.toArray(new RsltPriSgStndNoteHdrCopyVO[models.size()]);
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
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteHdrSeqCopy = this.noteHdrSeqCopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteSeq = this.noteSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteNm = this.noteNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtntSeq = this.noteCtntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDtHidden = this.effDtHidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvMapgId = this.noteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCdCopy = this.prcCustTpCdCopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDtHidden = this.expDtHidden .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteHdrSeq = this.noteHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCdCopy = this.svcScpCdCopy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteRefYr = this.noteRefYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
