/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JapDorEdiTransVO.java
*@FileTitle : JapDorEdiTransVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.24
*@LastModifier : 
*@LastVersion : 1.0
* 2009.11.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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

public class JapDorEdiTransVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<JapDorEdiTransVO> models = new ArrayList<JapDorEdiTransVO>();
	
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String evntOfcCd = null;
	/* Column Info */
	private String jpDoGrpNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String rlseSeq = null;
	/* Column Info */
	private String crntCtnt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String jpDoSndStsCd = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String doIfSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String doCngEvntCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String evntUsrId = null;
	/* Column Info */
	private String preCtnt = null;
	/* Column Info */
	private String svcCd = null;
	/* Column Info */
	private String grpNo = null;
	/* Column Info */
	private String evntCd = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String evntDt = null;
	/* Column Info */
	private String flatFile = null;
	/* Column Info */
	private String refNumber = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public JapDorEdiTransVO() {}

	public JapDorEdiTransVO(String ibflag, String pagerows, String bkgNo, String rlseSeq, String doIfSeq, String evntDt, String jpDoSndStsCd, String jpDoGrpNo, String evntUsrId, String evntOfcCd, String creUsrId, String creDt, String updUsrId, String updDt, String svcCd, String doCngEvntCd, String crntCtnt, String preCtnt, String grpNo, String blNo, String evntCd, String ofcCd, String usrId, String doNo,String flatFile, String refNumber) {
		this.updDt = updDt;
		this.evntOfcCd = evntOfcCd;
		this.jpDoGrpNo = jpDoGrpNo;
		this.creDt = creDt;
		this.rlseSeq = rlseSeq;
		this.crntCtnt = crntCtnt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.jpDoSndStsCd = jpDoSndStsCd;
		this.doNo = doNo;
		this.doIfSeq = doIfSeq;
		this.ofcCd = ofcCd;
		this.doCngEvntCd = doCngEvntCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.creUsrId = creUsrId;
		this.usrId = usrId;
		this.evntUsrId = evntUsrId;
		this.preCtnt = preCtnt;
		this.svcCd = svcCd;
		this.grpNo = grpNo;
		this.evntCd = evntCd;
		this.updUsrId = updUsrId;
		this.evntDt = evntDt;
		this.flatFile = flatFile;				
		this.refNumber = refNumber;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("evnt_ofc_cd", getEvntOfcCd());
		this.hashColumns.put("jp_do_grp_no", getJpDoGrpNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("rlse_seq", getRlseSeq());
		this.hashColumns.put("crnt_ctnt", getCrntCtnt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("jp_do_snd_sts_cd", getJpDoSndStsCd());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("do_if_seq", getDoIfSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("do_cng_evnt_cd", getDoCngEvntCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("evnt_usr_id", getEvntUsrId());
		this.hashColumns.put("pre_ctnt", getPreCtnt());
		this.hashColumns.put("svc_cd", getSvcCd());
		this.hashColumns.put("grp_no", getGrpNo());
		this.hashColumns.put("evnt_cd", getEvntCd());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("evnt_dt", getEvntDt());
		this.hashColumns.put("flat_file", getFlatFile());
		this.hashColumns.put("ref_number", getRefNumber());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("evnt_ofc_cd", "evntOfcCd");
		this.hashFields.put("jp_do_grp_no", "jpDoGrpNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("rlse_seq", "rlseSeq");
		this.hashFields.put("crnt_ctnt", "crntCtnt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("jp_do_snd_sts_cd", "jpDoSndStsCd");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("do_if_seq", "doIfSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("do_cng_evnt_cd", "doCngEvntCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("evnt_usr_id", "evntUsrId");
		this.hashFields.put("pre_ctnt", "preCtnt");
		this.hashFields.put("svc_cd", "svcCd");
		this.hashFields.put("grp_no", "grpNo");
		this.hashFields.put("evnt_cd", "evntCd");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("evnt_dt", "evntDt");
		this.hashFields.put("flat_file", "flatFile");
		this.hashFields.put("ref_number", "refNumber");
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
	 * @return evntOfcCd
	 */
	public String getEvntOfcCd() {
		return this.evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @return jpDoGrpNo
	 */
	public String getJpDoGrpNo() {
		return this.jpDoGrpNo;
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
	 * @return rlseSeq
	 */
	public String getRlseSeq() {
		return this.rlseSeq;
	}
	
	/**
	 * Column Info
	 * @return crntCtnt
	 */
	public String getCrntCtnt() {
		return this.crntCtnt;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return jpDoSndStsCd
	 */
	public String getJpDoSndStsCd() {
		return this.jpDoSndStsCd;
	}
	
	/**
	 * Column Info
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return doIfSeq
	 */
	public String getDoIfSeq() {
		return this.doIfSeq;
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
	 * @return doCngEvntCd
	 */
	public String getDoCngEvntCd() {
		return this.doCngEvntCd;
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
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
	}
	
	/**
	 * Column Info
	 * @return evntUsrId
	 */
	public String getEvntUsrId() {
		return this.evntUsrId;
	}
	
	/**
	 * Column Info
	 * @return preCtnt
	 */
	public String getPreCtnt() {
		return this.preCtnt;
	}
	
	/**
	 * Column Info
	 * @return svcCd
	 */
	public String getSvcCd() {
		return this.svcCd;
	}
	
	/**
	 * Column Info
	 * @return grpNo
	 */
	public String getGrpNo() {
		return this.grpNo;
	}
	
	/**
	 * Column Info
	 * @return evntCd
	 */
	public String getEvntCd() {
		return this.evntCd;
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
	 * @return evntDt
	 */
	public String getEvntDt() {
		return this.evntDt;
	}
	
	/**
	 * Column Info
	 * @return evntDt
	 */
	public String getFlatFile() {
		return this.flatFile;
	}
	
	/**
	 * Column Info
	 * @return refNumber
	 */
	public String getRefNumber() {
		return this.refNumber;
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
	 * @param evntOfcCd
	 */
	public void setEvntOfcCd(String evntOfcCd) {
		this.evntOfcCd = evntOfcCd;
	}
	
	/**
	 * Column Info
	 * @param jpDoGrpNo
	 */
	public void setJpDoGrpNo(String jpDoGrpNo) {
		this.jpDoGrpNo = jpDoGrpNo;
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
	 * @param rlseSeq
	 */
	public void setRlseSeq(String rlseSeq) {
		this.rlseSeq = rlseSeq;
	}
	
	/**
	 * Column Info
	 * @param crntCtnt
	 */
	public void setCrntCtnt(String crntCtnt) {
		this.crntCtnt = crntCtnt;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param jpDoSndStsCd
	 */
	public void setJpDoSndStsCd(String jpDoSndStsCd) {
		this.jpDoSndStsCd = jpDoSndStsCd;
	}
	
	/**
	 * Column Info
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param doIfSeq
	 */
	public void setDoIfSeq(String doIfSeq) {
		this.doIfSeq = doIfSeq;
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
	 * @param doCngEvntCd
	 */
	public void setDoCngEvntCd(String doCngEvntCd) {
		this.doCngEvntCd = doCngEvntCd;
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
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
	/**
	 * Column Info
	 * @param evntUsrId
	 */
	public void setEvntUsrId(String evntUsrId) {
		this.evntUsrId = evntUsrId;
	}
	
	/**
	 * Column Info
	 * @param preCtnt
	 */
	public void setPreCtnt(String preCtnt) {
		this.preCtnt = preCtnt;
	}
	
	/**
	 * Column Info
	 * @param svcCd
	 */
	public void setSvcCd(String svcCd) {
		this.svcCd = svcCd;
	}
	
	/**
	 * Column Info
	 * @param grpNo
	 */
	public void setGrpNo(String grpNo) {
		this.grpNo = grpNo;
	}
	
	/**
	 * Column Info
	 * @param evntCd
	 */
	public void setEvntCd(String evntCd) {
		this.evntCd = evntCd;
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
	 * @param evntDt
	 */
	public void setEvntDt(String evntDt) {
		this.evntDt = evntDt;
	}
	
	/**
	 * Column Info
	 * @param evntDt
	 */
	public void setFlatFile(String flatFile) {
		this.flatFile = flatFile;
	}	

	/**
	 * Column Info
	 * @param refNumber
	 */
	public void setRefNumber(String refNumber) {
		this.refNumber = refNumber;
	}		
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setUpdDt(JSPUtil.getParameter(request, "upd_dt", ""));
		setEvntOfcCd(JSPUtil.getParameter(request, "evnt_ofc_cd", ""));
		setJpDoGrpNo(JSPUtil.getParameter(request, "jp_do_grp_no", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setRlseSeq(JSPUtil.getParameter(request, "rlse_seq", ""));
		setCrntCtnt(JSPUtil.getParameter(request, "crnt_ctnt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setJpDoSndStsCd(JSPUtil.getParameter(request, "jp_do_snd_sts_cd", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setDoIfSeq(JSPUtil.getParameter(request, "do_if_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setDoCngEvntCd(JSPUtil.getParameter(request, "do_cng_evnt_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, "cre_usr_id", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setEvntUsrId(JSPUtil.getParameter(request, "evnt_usr_id", ""));
		setPreCtnt(JSPUtil.getParameter(request, "pre_ctnt", ""));
		setSvcCd(JSPUtil.getParameter(request, "svc_cd", ""));
		setGrpNo(JSPUtil.getParameter(request, "grp_no", ""));
		setEvntCd(JSPUtil.getParameter(request, "evnt_cd", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setEvntDt(JSPUtil.getParameter(request, "evnt_dt", ""));
		setFlatFile(JSPUtil.getParameter(request, "flat_file", ""));
		setRefNumber(JSPUtil.getParameter(request, "ref_number", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return JapDorEdiTransVO[]
	 */
	public JapDorEdiTransVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return JapDorEdiTransVO[]
	 */
	public JapDorEdiTransVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		JapDorEdiTransVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] evntOfcCd = (JSPUtil.getParameter(request, prefix	+ "evnt_ofc_cd", length));
			String[] jpDoGrpNo = (JSPUtil.getParameter(request, prefix	+ "jp_do_grp_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] rlseSeq = (JSPUtil.getParameter(request, prefix	+ "rlse_seq", length));
			String[] crntCtnt = (JSPUtil.getParameter(request, prefix	+ "crnt_ctnt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] jpDoSndStsCd = (JSPUtil.getParameter(request, prefix	+ "jp_do_snd_sts_cd", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] doIfSeq = (JSPUtil.getParameter(request, prefix	+ "do_if_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] doCngEvntCd = (JSPUtil.getParameter(request, prefix	+ "do_cng_evnt_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] evntUsrId = (JSPUtil.getParameter(request, prefix	+ "evnt_usr_id", length));
			String[] preCtnt = (JSPUtil.getParameter(request, prefix	+ "pre_ctnt", length));
			String[] svcCd = (JSPUtil.getParameter(request, prefix	+ "svc_cd", length));
			String[] grpNo = (JSPUtil.getParameter(request, prefix	+ "grp_no", length));
			String[] evntCd = (JSPUtil.getParameter(request, prefix	+ "evnt_cd", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] evntDt = (JSPUtil.getParameter(request, prefix	+ "evnt_dt", length));
			String[] flatFile = (JSPUtil.getParameter(request, prefix	+ "flat_file", length));
			String[] refNumber = (JSPUtil.getParameter(request, prefix	+ "ref_number", length));
			
			for (int i = 0; i < length; i++) {
				model = new JapDorEdiTransVO();
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (evntOfcCd[i] != null)
					model.setEvntOfcCd(evntOfcCd[i]);
				if (jpDoGrpNo[i] != null)
					model.setJpDoGrpNo(jpDoGrpNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (rlseSeq[i] != null)
					model.setRlseSeq(rlseSeq[i]);
				if (crntCtnt[i] != null)
					model.setCrntCtnt(crntCtnt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (jpDoSndStsCd[i] != null)
					model.setJpDoSndStsCd(jpDoSndStsCd[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (doIfSeq[i] != null)
					model.setDoIfSeq(doIfSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (doCngEvntCd[i] != null)
					model.setDoCngEvntCd(doCngEvntCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (evntUsrId[i] != null)
					model.setEvntUsrId(evntUsrId[i]);
				if (preCtnt[i] != null)
					model.setPreCtnt(preCtnt[i]);
				if (svcCd[i] != null)
					model.setSvcCd(svcCd[i]);
				if (grpNo[i] != null)
					model.setGrpNo(grpNo[i]);
				if (evntCd[i] != null)
					model.setEvntCd(evntCd[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (evntDt[i] != null)
					model.setEvntDt(evntDt[i]);
				if (flatFile[i] != null)
					model.setFlatFile(flatFile[i]);
				if (refNumber[i] != null)
					model.setRefNumber(refNumber[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getJapDorEdiTransVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return JapDorEdiTransVO[]
	 */
	public JapDorEdiTransVO[] getJapDorEdiTransVOs(){
		JapDorEdiTransVO[] vos = (JapDorEdiTransVO[])models.toArray(new JapDorEdiTransVO[models.size()]);
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
		this.evntOfcCd = this.evntOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpDoGrpNo = this.jpDoGrpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseSeq = this.rlseSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crntCtnt = this.crntCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.jpDoSndStsCd = this.jpDoSndStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIfSeq = this.doIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doCngEvntCd = this.doCngEvntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntUsrId = this.evntUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preCtnt = this.preCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.svcCd = this.svcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grpNo = this.grpNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntCd = this.evntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.evntDt = this.evntDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatFile = this.flatFile .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.refNumber = this.refNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
