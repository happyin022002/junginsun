/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : InvEdiMGBHdrVO.java
*@FileTitle : InvEdiMGBHdrVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.vo;

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

public class InvEdiMGBHdrVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<InvEdiMGBHdrVO> models = new ArrayList<InvEdiMGBHdrVO>();
	
	
	/* Column Info */
	private String invSeq = null;
	/* Column Info */
	private String arIfNo = null;
	/* Column Info */
	private String updDt = null;
	/* Column Info */
	private String ttlTrfRtAmt = null;
	/* Column Info */
	private String blSrcNo = null;
	/* Column Info */
	private String docNo = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String ptCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String funcCd = null;
	/* Column Info */
	private String invNo = null;
	/* Column Info */
	private String creUsrId = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String totAmnt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String docDate = null;
	/* Column Info */
	private String invCur = null;
	/* Column Info */
	private String paperInd = null;
	/* Column Info */
	private String ediSndFlg = null;
	/* Column Info */
	private String invIssueDate = null;
	/* Column Info */
	private String updUsrId = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public InvEdiMGBHdrVO() {}

	public InvEdiMGBHdrVO(String ibflag, String pagerows, String invSeq,  String arIfNo,  String docNo, String funcCd, String paperInd, String docDate, String cntrNo, String invNo, String invIssueDate, String totAmnt, String invCur, String ptCd, String blSrcNo, String ttlTrfRtAmt, String ediSndFlg, String creUsrId, String creDt, String updUsrId, String updDt) {
		this.invSeq = invSeq;
		this.arIfNo = arIfNo;
		this.updDt = updDt;
		this.ttlTrfRtAmt = ttlTrfRtAmt;
		this.blSrcNo = blSrcNo;
		this.docNo = docNo;
		this.creDt = creDt;
		this.ptCd = ptCd;
		this.pagerows = pagerows;
		this.funcCd = funcCd;
		this.invNo = invNo;
		this.creUsrId = creUsrId;
		this.ibflag = ibflag;
		this.totAmnt = totAmnt;
		this.cntrNo = cntrNo;
		this.docDate = docDate;
		this.invCur = invCur;
		this.paperInd = paperInd;
		this.ediSndFlg = ediSndFlg;
		this.invIssueDate = invIssueDate;
		this.updUsrId = updUsrId;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("inv_seq", getInvSeq());
		this.hashColumns.put("ar_if_no", getArIfNo());
		this.hashColumns.put("upd_dt", getUpdDt());
		this.hashColumns.put("ttl_trf_rt_amt", getTtlTrfRtAmt());
		this.hashColumns.put("bl_src_no", getBlSrcNo());
		this.hashColumns.put("doc_no", getDocNo());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("pt_cd", getPtCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("func_cd", getFuncCd());
		this.hashColumns.put("inv_no", getInvNo());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot_amnt", getTotAmnt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("doc_date", getDocDate());
		this.hashColumns.put("inv_cur", getInvCur());
		this.hashColumns.put("paper_ind", getPaperInd());
		this.hashColumns.put("edi_snd_flg", getEdiSndFlg());
		this.hashColumns.put("inv_issue_date", getInvIssueDate());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("inv_seq", "invSeq");
		this.hashFields.put("ar_if_no", "arIfNo");
		this.hashFields.put("upd_dt", "updDt");
		this.hashFields.put("ttl_trf_rt_amt", "ttlTrfRtAmt");
		this.hashFields.put("bl_src_no", "blSrcNo");
		this.hashFields.put("doc_no", "docNo");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("pt_cd", "ptCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("func_cd", "funcCd");
		this.hashFields.put("inv_no", "invNo");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot_amnt", "totAmnt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("doc_date", "docDate");
		this.hashFields.put("inv_cur", "invCur");
		this.hashFields.put("paper_ind", "paperInd");
		this.hashFields.put("edi_snd_flg", "ediSndFlg");
		this.hashFields.put("inv_issue_date", "invIssueDate");
		this.hashFields.put("upd_usr_id", "updUsrId");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return invSeq
	 */
	public String getInvSeq() {
		return this.invSeq;
	}
	
	/**
	 * Column Info
	 * @return arIfNo
	 */
	public String getArIfNo() {
		return this.arIfNo;
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
	 * @return ttlTrfRtAmt
	 */
	public String getTtlTrfRtAmt() {
		return this.ttlTrfRtAmt;
	}
	
	/**
	 * Column Info
	 * @return blSrcNo
	 */
	public String getBlSrcNo() {
		return this.blSrcNo;
	}
	
	/**
	 * Column Info
	 * @return docNo
	 */
	public String getDocNo() {
		return this.docNo;
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
	 * @return ptCd
	 */
	public String getPtCd() {
		return this.ptCd;
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
	 * @return funcCd
	 */
	public String getFuncCd() {
		return this.funcCd;
	}
	
	/**
	 * Column Info
	 * @return invNo
	 */
	public String getInvNo() {
		return this.invNo;
	}
	
	/**
	 * Column Info
	 * @return creUsrId
	 */
	public String getCreUsrId() {
		return this.creUsrId;
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
	 * @return totAmnt
	 */
	public String getTotAmnt() {
		return this.totAmnt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return docDate
	 */
	public String getDocDate() {
		return this.docDate;
	}
	
	/**
	 * Column Info
	 * @return invCur
	 */
	public String getInvCur() {
		return this.invCur;
	}
	
	/**
	 * Column Info
	 * @return paperInd
	 */
	public String getPaperInd() {
		return this.paperInd;
	}
	
	/**
	 * Column Info
	 * @return ediSndFlg
	 */
	public String getEdiSndFlg() {
		return this.ediSndFlg;
	}
	
	/**
	 * Column Info
	 * @return invIssueDate
	 */
	public String getInvIssueDate() {
		return this.invIssueDate;
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
	 * @param invSeq
	 */
	public void setInvSeq(String invSeq) {
		this.invSeq = invSeq;
	}
	
	/**
	 * Column Info
	 * @param arIfNo
	 */
	public void setArIfNo(String arIfNo) {
		this.arIfNo = arIfNo;
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
	 * @param ttlTrfRtAmt
	 */
	public void setTtlTrfRtAmt(String ttlTrfRtAmt) {
		this.ttlTrfRtAmt = ttlTrfRtAmt;
	}
	
	/**
	 * Column Info
	 * @param blSrcNo
	 */
	public void setBlSrcNo(String blSrcNo) {
		this.blSrcNo = blSrcNo;
	}
	
	/**
	 * Column Info
	 * @param docNo
	 */
	public void setDocNo(String docNo) {
		this.docNo = docNo;
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
	 * @param ptCd
	 */
	public void setPtCd(String ptCd) {
		this.ptCd = ptCd;
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
	 * @param funcCd
	 */
	public void setFuncCd(String funcCd) {
		this.funcCd = funcCd;
	}
	
	/**
	 * Column Info
	 * @param invNo
	 */
	public void setInvNo(String invNo) {
		this.invNo = invNo;
	}
	
	/**
	 * Column Info
	 * @param creUsrId
	 */
	public void setCreUsrId(String creUsrId) {
		this.creUsrId = creUsrId;
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
	 * @param totAmnt
	 */
	public void setTotAmnt(String totAmnt) {
		this.totAmnt = totAmnt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param docDate
	 */
	public void setDocDate(String docDate) {
		this.docDate = docDate;
	}
	
	/**
	 * Column Info
	 * @param invCur
	 */
	public void setInvCur(String invCur) {
		this.invCur = invCur;
	}
	
	/**
	 * Column Info
	 * @param paperInd
	 */
	public void setPaperInd(String paperInd) {
		this.paperInd = paperInd;
	}
	
	/**
	 * Column Info
	 * @param ediSndFlg
	 */
	public void setEdiSndFlg(String ediSndFlg) {
		this.ediSndFlg = ediSndFlg;
	}
	
	/**
	 * Column Info
	 * @param invIssueDate
	 */
	public void setInvIssueDate(String invIssueDate) {
		this.invIssueDate = invIssueDate;
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
		setInvSeq(JSPUtil.getParameter(request, prefix + "inv_seq", ""));
		setArIfNo(JSPUtil.getParameter(request, prefix + "ar_if_no", ""));
		setUpdDt(JSPUtil.getParameter(request, prefix + "upd_dt", ""));
		setTtlTrfRtAmt(JSPUtil.getParameter(request, prefix + "ttl_trf_rt_amt", ""));
		setBlSrcNo(JSPUtil.getParameter(request, prefix + "bl_src_no", ""));
		setDocNo(JSPUtil.getParameter(request, prefix + "doc_no", ""));
		setCreDt(JSPUtil.getParameter(request, prefix + "cre_dt", ""));
		setPtCd(JSPUtil.getParameter(request, prefix + "pt_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFuncCd(JSPUtil.getParameter(request, prefix + "func_cd", ""));
		setInvNo(JSPUtil.getParameter(request, prefix + "inv_no", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTotAmnt(JSPUtil.getParameter(request, prefix + "tot_amnt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setDocDate(JSPUtil.getParameter(request, prefix + "doc_date", ""));
		setInvCur(JSPUtil.getParameter(request, prefix + "inv_cur", ""));
		setPaperInd(JSPUtil.getParameter(request, prefix + "paper_ind", ""));
		setEdiSndFlg(JSPUtil.getParameter(request, prefix + "edi_snd_flg", ""));
		setInvIssueDate(JSPUtil.getParameter(request, prefix + "inv_issue_date", ""));
		setUpdUsrId(JSPUtil.getParameter(request, prefix + "upd_usr_id", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return InvEdiMGBHdrVO[]
	 */
	public InvEdiMGBHdrVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return InvEdiMGBHdrVO[]
	 */
	public InvEdiMGBHdrVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		InvEdiMGBHdrVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] invSeq = (JSPUtil.getParameter(request, prefix	+ "inv_seq", length));
			String[] arIfNo = (JSPUtil.getParameter(request, prefix	+ "ar_if_no", length));
			String[] updDt = (JSPUtil.getParameter(request, prefix	+ "upd_dt", length));
			String[] ttlTrfRtAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_trf_rt_amt", length));
			String[] blSrcNo = (JSPUtil.getParameter(request, prefix	+ "bl_src_no", length));
			String[] docNo = (JSPUtil.getParameter(request, prefix	+ "doc_no", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] ptCd = (JSPUtil.getParameter(request, prefix	+ "pt_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] funcCd = (JSPUtil.getParameter(request, prefix	+ "func_cd", length));
			String[] invNo = (JSPUtil.getParameter(request, prefix	+ "inv_no", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] totAmnt = (JSPUtil.getParameter(request, prefix	+ "tot_amnt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] docDate = (JSPUtil.getParameter(request, prefix	+ "doc_date", length));
			String[] invCur = (JSPUtil.getParameter(request, prefix	+ "inv_cur", length));
			String[] paperInd = (JSPUtil.getParameter(request, prefix	+ "paper_ind", length));
			String[] ediSndFlg = (JSPUtil.getParameter(request, prefix	+ "edi_snd_flg", length));
			String[] invIssueDate = (JSPUtil.getParameter(request, prefix	+ "inv_issue_date", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			
			for (int i = 0; i < length; i++) {
				model = new InvEdiMGBHdrVO();
				if (invSeq[i] != null)
					model.setInvSeq(invSeq[i]);
				if (arIfNo[i] != null)
					model.setArIfNo(arIfNo[i]);
				if (updDt[i] != null)
					model.setUpdDt(updDt[i]);
				if (ttlTrfRtAmt[i] != null)
					model.setTtlTrfRtAmt(ttlTrfRtAmt[i]);
				if (blSrcNo[i] != null)
					model.setBlSrcNo(blSrcNo[i]);
				if (docNo[i] != null)
					model.setDocNo(docNo[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (ptCd[i] != null)
					model.setPtCd(ptCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (funcCd[i] != null)
					model.setFuncCd(funcCd[i]);
				if (invNo[i] != null)
					model.setInvNo(invNo[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (totAmnt[i] != null)
					model.setTotAmnt(totAmnt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (docDate[i] != null)
					model.setDocDate(docDate[i]);
				if (invCur[i] != null)
					model.setInvCur(invCur[i]);
				if (paperInd[i] != null)
					model.setPaperInd(paperInd[i]);
				if (ediSndFlg[i] != null)
					model.setEdiSndFlg(ediSndFlg[i]);
				if (invIssueDate[i] != null)
					model.setInvIssueDate(invIssueDate[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getInvEdiMGBHdrVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return InvEdiMGBHdrVO[]
	 */
	public InvEdiMGBHdrVO[] getInvEdiMGBHdrVOs(){
		InvEdiMGBHdrVO[] vos = (InvEdiMGBHdrVO[])models.toArray(new InvEdiMGBHdrVO[models.size()]);
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
		this.invSeq = this.invSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arIfNo = this.arIfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updDt = this.updDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlTrfRtAmt = this.ttlTrfRtAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blSrcNo = this.blSrcNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docNo = this.docNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptCd = this.ptCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.funcCd = this.funcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invNo = this.invNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totAmnt = this.totAmnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docDate = this.docDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invCur = this.invCur .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.paperInd = this.paperInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediSndFlg = this.ediSndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.invIssueDate = this.invIssueDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
