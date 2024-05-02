/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : RsltTriPropInquiryListVO.java
*@FileTitle : RsltTriPropInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.10
*@LastModifier : 김경미
*@LastVersion : 1.0
* 2016.05.10 김경미 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.pri.triproposal.triproposal.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김경미
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RsltTriPropInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RsltTriPropInquiryListVO> models = new ArrayList<RsltTriPropInquiryListVO>();
	
	/* Column Info */
	private String destRoutPntLocNm = null;
	/* Column Info */
	private String triRmk = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String amdtSeq = null;
	/* Column Info */
	private String triPropNo = null;
	/* Column Info */
	private String ratUtCd = null;
	/* Column Info */
	private String noteCtnt = null;
	/* Column Info */
	private String fnlFrtRtAmt = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String orgRoutPntLocNm = null;
	/* Column Info */
	private String destRoutViaPortNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String effDt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String taaNo = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String orgRoutViaPortNm = null;
	/* Column Info */
	private String expDt = null;
	/* Column Info */
	private String trfPfxCd = null;
	/* Column Info */
	private String triNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public RsltTriPropInquiryListVO() {}

	public RsltTriPropInquiryListVO(String ibflag, String pagerows, String triPropNo, String trfPfxCd, String trfNo, String triNo, String amdtSeq, String cmdtCd, String cmdtNm, String orgRoutPntLocNm, String orgRoutViaPortNm, String destRoutViaPortNm, String destRoutPntLocNm, String ratUtCd, String currCd, String fnlFrtRtAmt, String noteCtnt, String triRmk, String effDt, String expDt, String taaNo) {
		this.destRoutPntLocNm = destRoutPntLocNm;
		this.triRmk = triRmk;
		this.currCd = currCd;
		this.amdtSeq = amdtSeq;
		this.triPropNo = triPropNo;
		this.ratUtCd = ratUtCd;
		this.noteCtnt = noteCtnt;
		this.fnlFrtRtAmt = fnlFrtRtAmt;
		this.cmdtNm = cmdtNm;
		this.orgRoutPntLocNm = orgRoutPntLocNm;
		this.destRoutViaPortNm = destRoutViaPortNm;
		this.pagerows = pagerows;
		this.effDt = effDt;
		this.ibflag = ibflag;
		this.taaNo = taaNo;
		this.cmdtCd = cmdtCd;
		this.trfNo = trfNo;
		this.orgRoutViaPortNm = orgRoutViaPortNm;
		this.expDt = expDt;
		this.trfPfxCd = trfPfxCd;
		this.triNo = triNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("dest_rout_pnt_loc_nm", getDestRoutPntLocNm());
		this.hashColumns.put("tri_rmk", getTriRmk());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("amdt_seq", getAmdtSeq());
		this.hashColumns.put("tri_prop_no", getTriPropNo());
		this.hashColumns.put("rat_ut_cd", getRatUtCd());
		this.hashColumns.put("note_ctnt", getNoteCtnt());
		this.hashColumns.put("fnl_frt_rt_amt", getFnlFrtRtAmt());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("org_rout_pnt_loc_nm", getOrgRoutPntLocNm());
		this.hashColumns.put("dest_rout_via_port_nm", getDestRoutViaPortNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("taa_no", getTaaNo());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("org_rout_via_port_nm", getOrgRoutViaPortNm());
		this.hashColumns.put("exp_dt", getExpDt());
		this.hashColumns.put("trf_pfx_cd", getTrfPfxCd());
		this.hashColumns.put("tri_no", getTriNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("dest_rout_pnt_loc_nm", "destRoutPntLocNm");
		this.hashFields.put("tri_rmk", "triRmk");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("amdt_seq", "amdtSeq");
		this.hashFields.put("tri_prop_no", "triPropNo");
		this.hashFields.put("rat_ut_cd", "ratUtCd");
		this.hashFields.put("note_ctnt", "noteCtnt");
		this.hashFields.put("fnl_frt_rt_amt", "fnlFrtRtAmt");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("org_rout_pnt_loc_nm", "orgRoutPntLocNm");
		this.hashFields.put("dest_rout_via_port_nm", "destRoutViaPortNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("taa_no", "taaNo");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("org_rout_via_port_nm", "orgRoutViaPortNm");
		this.hashFields.put("exp_dt", "expDt");
		this.hashFields.put("trf_pfx_cd", "trfPfxCd");
		this.hashFields.put("tri_no", "triNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return destRoutPntLocNm
	 */
	public String getDestRoutPntLocNm() {
		return this.destRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @return triRmk
	 */
	public String getTriRmk() {
		return this.triRmk;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
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
	 * @return triPropNo
	 */
	public String getTriPropNo() {
		return this.triPropNo;
	}
	
	/**
	 * Column Info
	 * @return ratUtCd
	 */
	public String getRatUtCd() {
		return this.ratUtCd;
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
	 * @return fnlFrtRtAmt
	 */
	public String getFnlFrtRtAmt() {
		return this.fnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return orgRoutPntLocNm
	 */
	public String getOrgRoutPntLocNm() {
		return this.orgRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @return destRoutViaPortNm
	 */
	public String getDestRoutViaPortNm() {
		return this.destRoutViaPortNm;
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
	 * @return taaNo
	 */
	public String getTaaNo() {
		return this.taaNo;
	}
	
	/**
	 * Column Info
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return orgRoutViaPortNm
	 */
	public String getOrgRoutViaPortNm() {
		return this.orgRoutViaPortNm;
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
	 * @return trfPfxCd
	 */
	public String getTrfPfxCd() {
		return this.trfPfxCd;
	}
	
	/**
	 * Column Info
	 * @return triNo
	 */
	public String getTriNo() {
		return this.triNo;
	}
	

	/**
	 * Column Info
	 * @param destRoutPntLocNm
	 */
	public void setDestRoutPntLocNm(String destRoutPntLocNm) {
		this.destRoutPntLocNm = destRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @param triRmk
	 */
	public void setTriRmk(String triRmk) {
		this.triRmk = triRmk;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
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
	 * @param triPropNo
	 */
	public void setTriPropNo(String triPropNo) {
		this.triPropNo = triPropNo;
	}
	
	/**
	 * Column Info
	 * @param ratUtCd
	 */
	public void setRatUtCd(String ratUtCd) {
		this.ratUtCd = ratUtCd;
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
	 * @param fnlFrtRtAmt
	 */
	public void setFnlFrtRtAmt(String fnlFrtRtAmt) {
		this.fnlFrtRtAmt = fnlFrtRtAmt;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param orgRoutPntLocNm
	 */
	public void setOrgRoutPntLocNm(String orgRoutPntLocNm) {
		this.orgRoutPntLocNm = orgRoutPntLocNm;
	}
	
	/**
	 * Column Info
	 * @param destRoutViaPortNm
	 */
	public void setDestRoutViaPortNm(String destRoutViaPortNm) {
		this.destRoutViaPortNm = destRoutViaPortNm;
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
	 * @param taaNo
	 */
	public void setTaaNo(String taaNo) {
		this.taaNo = taaNo;
	}
	
	/**
	 * Column Info
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param orgRoutViaPortNm
	 */
	public void setOrgRoutViaPortNm(String orgRoutViaPortNm) {
		this.orgRoutViaPortNm = orgRoutViaPortNm;
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
	 * @param trfPfxCd
	 */
	public void setTrfPfxCd(String trfPfxCd) {
		this.trfPfxCd = trfPfxCd;
	}
	
	/**
	 * Column Info
	 * @param triNo
	 */
	public void setTriNo(String triNo) {
		this.triNo = triNo;
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
		setDestRoutPntLocNm(JSPUtil.getParameter(request, prefix + "dest_rout_pnt_loc_nm", ""));
		setTriRmk(JSPUtil.getParameter(request, prefix + "tri_rmk", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setAmdtSeq(JSPUtil.getParameter(request, prefix + "amdt_seq", ""));
		setTriPropNo(JSPUtil.getParameter(request, prefix + "tri_prop_no", ""));
		setRatUtCd(JSPUtil.getParameter(request, prefix + "rat_ut_cd", ""));
		setNoteCtnt(JSPUtil.getParameter(request, prefix + "note_ctnt", ""));
		setFnlFrtRtAmt(JSPUtil.getParameter(request, prefix + "fnl_frt_rt_amt", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setOrgRoutPntLocNm(JSPUtil.getParameter(request, prefix + "org_rout_pnt_loc_nm", ""));
		setDestRoutViaPortNm(JSPUtil.getParameter(request, prefix + "dest_rout_via_port_nm", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEffDt(JSPUtil.getParameter(request, prefix + "eff_dt", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTaaNo(JSPUtil.getParameter(request, prefix + "taa_no", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setTrfNo(JSPUtil.getParameter(request, prefix + "trf_no", ""));
		setOrgRoutViaPortNm(JSPUtil.getParameter(request, prefix + "org_rout_via_port_nm", ""));
		setExpDt(JSPUtil.getParameter(request, prefix + "exp_dt", ""));
		setTrfPfxCd(JSPUtil.getParameter(request, prefix + "trf_pfx_cd", ""));
		setTriNo(JSPUtil.getParameter(request, prefix + "tri_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RsltTriPropInquiryListVO[]
	 */
	public RsltTriPropInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RsltTriPropInquiryListVO[]
	 */
	public RsltTriPropInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RsltTriPropInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] destRoutPntLocNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_pnt_loc_nm", length));
			String[] triRmk = (JSPUtil.getParameter(request, prefix	+ "tri_rmk", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] amdtSeq = (JSPUtil.getParameter(request, prefix	+ "amdt_seq", length));
			String[] triPropNo = (JSPUtil.getParameter(request, prefix	+ "tri_prop_no", length));
			String[] ratUtCd = (JSPUtil.getParameter(request, prefix	+ "rat_ut_cd", length));
			String[] noteCtnt = (JSPUtil.getParameter(request, prefix	+ "note_ctnt", length));
			String[] fnlFrtRtAmt = (JSPUtil.getParameter(request, prefix	+ "fnl_frt_rt_amt", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] orgRoutPntLocNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_pnt_loc_nm", length));
			String[] destRoutViaPortNm = (JSPUtil.getParameter(request, prefix	+ "dest_rout_via_port_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] taaNo = (JSPUtil.getParameter(request, prefix	+ "taa_no", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] orgRoutViaPortNm = (JSPUtil.getParameter(request, prefix	+ "org_rout_via_port_nm", length));
			String[] expDt = (JSPUtil.getParameter(request, prefix	+ "exp_dt", length));
			String[] trfPfxCd = (JSPUtil.getParameter(request, prefix	+ "trf_pfx_cd", length));
			String[] triNo = (JSPUtil.getParameter(request, prefix	+ "tri_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new RsltTriPropInquiryListVO();
				if (destRoutPntLocNm[i] != null)
					model.setDestRoutPntLocNm(destRoutPntLocNm[i]);
				if (triRmk[i] != null)
					model.setTriRmk(triRmk[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (amdtSeq[i] != null)
					model.setAmdtSeq(amdtSeq[i]);
				if (triPropNo[i] != null)
					model.setTriPropNo(triPropNo[i]);
				if (ratUtCd[i] != null)
					model.setRatUtCd(ratUtCd[i]);
				if (noteCtnt[i] != null)
					model.setNoteCtnt(noteCtnt[i]);
				if (fnlFrtRtAmt[i] != null)
					model.setFnlFrtRtAmt(fnlFrtRtAmt[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (orgRoutPntLocNm[i] != null)
					model.setOrgRoutPntLocNm(orgRoutPntLocNm[i]);
				if (destRoutViaPortNm[i] != null)
					model.setDestRoutViaPortNm(destRoutViaPortNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (taaNo[i] != null)
					model.setTaaNo(taaNo[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (orgRoutViaPortNm[i] != null)
					model.setOrgRoutViaPortNm(orgRoutViaPortNm[i]);
				if (expDt[i] != null)
					model.setExpDt(expDt[i]);
				if (trfPfxCd[i] != null)
					model.setTrfPfxCd(trfPfxCd[i]);
				if (triNo[i] != null)
					model.setTriNo(triNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRsltTriPropInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RsltTriPropInquiryListVO[]
	 */
	public RsltTriPropInquiryListVO[] getRsltTriPropInquiryListVOs(){
		RsltTriPropInquiryListVO[] vos = (RsltTriPropInquiryListVO[])models.toArray(new RsltTriPropInquiryListVO[models.size()]);
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
		this.destRoutPntLocNm = this.destRoutPntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triRmk = this.triRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.amdtSeq = this.amdtSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triPropNo = this.triPropNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratUtCd = this.ratUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noteCtnt = this.noteCtnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fnlFrtRtAmt = this.fnlFrtRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutPntLocNm = this.orgRoutPntLocNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destRoutViaPortNm = this.destRoutViaPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.taaNo = this.taaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgRoutViaPortNm = this.orgRoutViaPortNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.expDt = this.expDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfPfxCd = this.trfPfxCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.triNo = this.triNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
