/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : RsltPriSgStndNoteCtntVO.java
*@FileTitle : RsltPriSgStndNoteCtntVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.21
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2010.04.21 최성민 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.scguideline.scbasicstandardnoteguideline.vo;

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
 * @author 최성민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltPriSgStndNoteCtntVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltPriSgStndNoteCtntVO> models = new ArrayList<RsltPriSgStndNoteCtntVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String dpSeq = null;
	/* Column Info */
	private String svcScpCd = null;
	/* Column Info */
	private String noteTitNm = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String noteSeq = null;
	/* Column Info */
	private String noteNm = null;
	/* Column Info */
	private String noteConvFlg = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String cfmFlg = null;
	/* Column Info */
	private String noteCtntSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String noteConvMapgId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String noteHdrSeq = null;
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
	
	public RsltPriSgStndNoteCtntVO() {}

	public RsltPriSgStndNoteCtntVO(String ibflag, String pagerows, String cfmFlg, String cfmUsrId, String creDt, String creUsrId, String dpSeq, String effDt, String expDt, String noteConvFlg, String noteConvMapgId, String noteCtnt, String noteCtntSeq, String noteHdrSeq, String noteNm, String noteRefYr, String noteSeq, String noteTitNm, String prcCustTpCd, String svcScpCd, String updDt, String updUsrId) {
		this.updDt = updDt;
		this.dpSeq = dpSeq;
		this.svcScpCd = svcScpCd;
		this.noteTitNm = noteTitNm;
		this.creDt = creDt;
		this.noteSeq = noteSeq;
		this.noteNm = noteNm;
		this.noteConvFlg = noteConvFlg;
		this.noteCtnt = noteCtnt;
		this.cfmFlg = cfmFlg;
		this.noteCtntSeq = noteCtntSeq;
		this.pagerows = pagerows;
		this.noteConvMapgId = noteConvMapgId;
		this.ibflag = ibflag;
		this.creUsrId = creUsrId;
		this.effDt = effDt;
		this.noteHdrSeq = noteHdrSeq;
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
		this.hashColumns.put("dp_seq", getDpSeq());
		this.hashColumns.put("svc_scp_cd", getSvcScpCd());
		this.hashColumns.put("note_tit_nm", getNoteTitNm());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("note_seq", getNoteSeq());
		this.hashColumns.put("note_nm", getNoteNm());
		this.hashColumns.put("note_conv_flg", getNoteConvFlg());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("cfm_flg", getCfmFlg());
		this.hashColumns.put("note_ctnt_seq", getNoteCtntSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("note_conv_mapg_id", getNoteConvMapgId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("note_hdr_seq", getNoteHdrSeq());
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
		this.hashFields.put("dp_seq", "dpSeq");
		this.hashFields.put("svc_scp_cd", "svcScpCd");
		this.hashFields.put("note_tit_nm", "noteTitNm");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("note_seq", "noteSeq");
		this.hashFields.put("note_nm", "noteNm");
		this.hashFields.put("note_conv_flg", "noteConvFlg");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("cfm_flg", "cfmFlg");
		this.hashFields.put("note_ctnt_seq", "noteCtntSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("note_conv_mapg_id", "noteConvMapgId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("note_hdr_seq", "noteHdrSeq");
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
	 * @return dpSeq
	 */
	public String getDpSeq() {
		return this.dpSeq;
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
	 * @return noteTitNm
	 */
	public String getNoteTitNm() {
		return this.noteTitNm;
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
	 * @return noteConvFlg
	 */
	public String getNoteConvFlg() {
		return this.noteConvFlg;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return noteConvMapgId
	 */
	public String getNoteConvMapgId() {
		return this.noteConvMapgId;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return noteHdrSeq
	 */
	public String getNoteHdrSeq() {
		return this.noteHdrSeq;
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
	 * @param dpSeq
	 */
	public void setDpSeq(String dpSeq) {
		this.dpSeq = dpSeq;
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
	 * @param noteTitNm
	 */
	public void setNoteTitNm(String noteTitNm) {
		this.noteTitNm = noteTitNm;
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
	 * @param noteConvFlg
	 */
	public void setNoteConvFlg(String noteConvFlg) {
		this.noteConvFlg = noteConvFlg;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param noteConvMapgId
	 */
	public void setNoteConvMapgId(String noteConvMapgId) {
		this.noteConvMapgId = noteConvMapgId;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param noteHdrSeq
	 */
	public void setNoteHdrSeq(String noteHdrSeq) {
		this.noteHdrSeq = noteHdrSeq;
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
		fromRequest(request,"");
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setDpSeq(JSPUtil.getParameter(request, prefix + "dp_seq", ""));
		setSvcScpCd(JSPUtil.getParameter(request, prefix + "svc_scp_cd", ""));
		setNoteTitNm(JSPUtil.getParameter(request, prefix + "note_tit_nm", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setNoteSeq(JSPUtil.getParameter(request, prefix + "note_seq", ""));
		setNoteNm(JSPUtil.getParameter(request, prefix + "note_nm", ""));
		setNoteConvFlg(JSPUtil.getParameter(request, prefix + "note_conv_flg", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setCfmFlg(JSPUtil.getParameter(request, prefix + "cfm_flg", ""));
		setNoteCtntSeq(JSPUtil.getParameter(request, prefix + "note_ctnt_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setNoteConvMapgId(JSPUtil.getParameter(request, prefix + "note_conv_mapg_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setNoteHdrSeq(JSPUtil.getParameter(request, prefix + "note_hdr_seq", ""));
		setCfmUsrId(JSPUtil.getParameter(request, prefix + "cfm_usr_id", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setNoteRefYr(JSPUtil.getParameter(request, prefix + "note_ref_yr", ""));
		setPrcCustTpCd(JSPUtil.getParameter(request, prefix + "prc_cust_tp_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltPriSgStndNoteCtntVO[]
	 */
	public RsltPriSgStndNoteCtntVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltPriSgStndNoteCtntVO[]
	 */
	public RsltPriSgStndNoteCtntVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltPriSgStndNoteCtntVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] dpSeq = (JSPUtil.getParameter(request, prefix	+ "dp_seq", length));
			String[] svcScpCd = (JSPUtil.getParameter(request, prefix	+ "svc_scp_cd", length));
			String[] noteTitNm = (JSPUtil.getParameter(request, prefix	+ "note_tit_nm", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] noteSeq = (JSPUtil.getParameter(request, prefix	+ "note_seq", length));
			String[] noteNm = (JSPUtil.getParameter(request, prefix	+ "note_nm", length));
			String[] noteConvFlg = (JSPUtil.getParameter(request, prefix	+ "note_conv_flg", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] cfmFlg = (JSPUtil.getParameter(request, prefix	+ "cfm_flg", length));
			String[] noteCtntSeq = (JSPUtil.getParameter(request, prefix	+ "note_ctnt_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] noteConvMapgId = (JSPUtil.getParameter(request, prefix	+ "note_conv_mapg_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] noteHdrSeq = (JSPUtil.getParameter(request, prefix	+ "note_hdr_seq", length));
			String[] cfmUsrId = (JSPUtil.getParameter(request, prefix	+ "cfm_usr_id", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] noteRefYr = (JSPUtil.getParameter(request, prefix	+ "note_ref_yr", length));
			String[] prcCustTpCd = (JSPUtil.getParameter(request, prefix	+ "prc_cust_tp_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltPriSgStndNoteCtntVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (dpSeq[i] != null)
					model.setDpSeq(dpSeq[i]);
				if (svcScpCd[i] != null)
					model.setSvcScpCd(svcScpCd[i]);
				if (noteTitNm[i] != null)
					model.setNoteTitNm(noteTitNm[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (noteSeq[i] != null)
					model.setNoteSeq(noteSeq[i]);
				if (noteNm[i] != null)
					model.setNoteNm(noteNm[i]);
				if (noteConvFlg[i] != null)
					model.setNoteConvFlg(noteConvFlg[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (cfmFlg[i] != null)
					model.setCfmFlg(cfmFlg[i]);
				if (noteCtntSeq[i] != null)
					model.setNoteCtntSeq(noteCtntSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (noteConvMapgId[i] != null)
					model.setNoteConvMapgId(noteConvMapgId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (noteHdrSeq[i] != null)
					model.setNoteHdrSeq(noteHdrSeq[i]);
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
		return getRsltPriSgStndNoteCtntVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltPriSgStndNoteCtntVO[]
	 */
	public RsltPriSgStndNoteCtntVO[] getRsltPriSgStndNoteCtntVOs(){
		RsltPriSgStndNoteCtntVO[] vos = (RsltPriSgStndNoteCtntVO[])models.toArray(new RsltPriSgStndNoteCtntVO[models.size()]);
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
		this.dpSeq = this.dpSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcScpCd = this.svcScpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteTitNm = this.noteTitNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteSeq = this.noteSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteNm = this.noteNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvFlg = this.noteConvFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmFlg = this.cfmFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtntSeq = this.noteCtntSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteConvMapgId = this.noteConvMapgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteHdrSeq = this.noteHdrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cfmUsrId = this.cfmUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteRefYr = this.noteRefYr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prcCustTpCd = this.prcCustTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
