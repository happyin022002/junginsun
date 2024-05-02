/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DocQueueSummaryStatusVO.java
*@FileTitle : DocQueueSummaryStatusVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.06.03
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2011.06.03 김상수 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DocQueueSummaryStatusVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DocQueueSummaryStatusVO> models = new ArrayList<DocQueueSummaryStatusVO>();
	
	/* Column Info */
	private String inputPer = null;
	/* Column Info */
	private String region = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String ratePer = null;
	/* Column Info */
	private String dcPend = null;
	/* Column Info */
	private String openIndPer = null;
	/* Column Info */
	private String done = null;
	/* Column Info */
	private String dcPendPer = null;
	/* Column Info */
	private String blProof = null;
	/* Column Info */
	private String qa = null;
	/* Column Info */
	private String kind = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String foPend = null;
	/* Column Info */
	private String qaPer = null;
	/* Column Info */
	private String foPendPer = null;
	/* Column Info */
	private String input = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String rate = null;
	/* Column Info */
	private String blProofPer = null;
	/* Column Info */
	private String openInd = null;
	/* Column Info */
	private String donePer = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DocQueueSummaryStatusVO() {}

	public DocQueueSummaryStatusVO(String ibflag, String pagerows, String region, String bkgOfcCd, String kind, String total, String done, String donePer, String dcPend, String dcPendPer, String foPend, String foPendPer, String openInd, String openIndPer, String input, String inputPer, String rate, String ratePer, String qa, String qaPer, String blProof, String blProofPer) {
		this.inputPer = inputPer;
		this.region = region;
		this.bkgOfcCd = bkgOfcCd;
		this.total = total;
		this.ratePer = ratePer;
		this.dcPend = dcPend;
		this.openIndPer = openIndPer;
		this.done = done;
		this.dcPendPer = dcPendPer;
		this.blProof = blProof;
		this.qa = qa;
		this.kind = kind;
		this.pagerows = pagerows;
		this.foPend = foPend;
		this.qaPer = qaPer;
		this.foPendPer = foPendPer;
		this.input = input;
		this.ibflag = ibflag;
		this.rate = rate;
		this.blProofPer = blProofPer;
		this.openInd = openInd;
		this.donePer = donePer;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("input_per", getInputPer());
		this.hashColumns.put("region", getRegion());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("rate_per", getRatePer());
		this.hashColumns.put("dc_pend", getDcPend());
		this.hashColumns.put("open_ind_per", getOpenIndPer());
		this.hashColumns.put("done", getDone());
		this.hashColumns.put("dc_pend_per", getDcPendPer());
		this.hashColumns.put("bl_proof", getBlProof());
		this.hashColumns.put("qa", getQa());
		this.hashColumns.put("kind", getKind());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fo_pend", getFoPend());
		this.hashColumns.put("qa_per", getQaPer());
		this.hashColumns.put("fo_pend_per", getFoPendPer());
		this.hashColumns.put("input", getInput());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("rate", getRate());
		this.hashColumns.put("bl_proof_per", getBlProofPer());
		this.hashColumns.put("open_ind", getOpenInd());
		this.hashColumns.put("done_per", getDonePer());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("input_per", "inputPer");
		this.hashFields.put("region", "region");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("total", "total");
		this.hashFields.put("rate_per", "ratePer");
		this.hashFields.put("dc_pend", "dcPend");
		this.hashFields.put("open_ind_per", "openIndPer");
		this.hashFields.put("done", "done");
		this.hashFields.put("dc_pend_per", "dcPendPer");
		this.hashFields.put("bl_proof", "blProof");
		this.hashFields.put("qa", "qa");
		this.hashFields.put("kind", "kind");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fo_pend", "foPend");
		this.hashFields.put("qa_per", "qaPer");
		this.hashFields.put("fo_pend_per", "foPendPer");
		this.hashFields.put("input", "input");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("rate", "rate");
		this.hashFields.put("bl_proof_per", "blProofPer");
		this.hashFields.put("open_ind", "openInd");
		this.hashFields.put("done_per", "donePer");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return inputPer
	 */
	public String getInputPer() {
		return this.inputPer;
	}
	
	/**
	 * Column Info
	 * @return region
	 */
	public String getRegion() {
		return this.region;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
	}
	
	/**
	 * Column Info
	 * @return ratePer
	 */
	public String getRatePer() {
		return this.ratePer;
	}
	
	/**
	 * Column Info
	 * @return dcPend
	 */
	public String getDcPend() {
		return this.dcPend;
	}
	
	/**
	 * Column Info
	 * @return openIndPer
	 */
	public String getOpenIndPer() {
		return this.openIndPer;
	}
	
	/**
	 * Column Info
	 * @return done
	 */
	public String getDone() {
		return this.done;
	}
	
	/**
	 * Column Info
	 * @return dcPendPer
	 */
	public String getDcPendPer() {
		return this.dcPendPer;
	}
	
	/**
	 * Column Info
	 * @return blProof
	 */
	public String getBlProof() {
		return this.blProof;
	}
	
	/**
	 * Column Info
	 * @return qa
	 */
	public String getQa() {
		return this.qa;
	}
	
	/**
	 * Column Info
	 * @return kind
	 */
	public String getKind() {
		return this.kind;
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
	 * @return foPend
	 */
	public String getFoPend() {
		return this.foPend;
	}
	
	/**
	 * Column Info
	 * @return qaPer
	 */
	public String getQaPer() {
		return this.qaPer;
	}
	
	/**
	 * Column Info
	 * @return foPendPer
	 */
	public String getFoPendPer() {
		return this.foPendPer;
	}
	
	/**
	 * Column Info
	 * @return input
	 */
	public String getInput() {
		return this.input;
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
	 * @return rate
	 */
	public String getRate() {
		return this.rate;
	}
	
	/**
	 * Column Info
	 * @return blProofPer
	 */
	public String getBlProofPer() {
		return this.blProofPer;
	}
	
	/**
	 * Column Info
	 * @return openInd
	 */
	public String getOpenInd() {
		return this.openInd;
	}
	
	/**
	 * Column Info
	 * @return donePer
	 */
	public String getDonePer() {
		return this.donePer;
	}
	

	/**
	 * Column Info
	 * @param inputPer
	 */
	public void setInputPer(String inputPer) {
		this.inputPer = inputPer;
	}
	
	/**
	 * Column Info
	 * @param region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	/**
	 * Column Info
	 * @param ratePer
	 */
	public void setRatePer(String ratePer) {
		this.ratePer = ratePer;
	}
	
	/**
	 * Column Info
	 * @param dcPend
	 */
	public void setDcPend(String dcPend) {
		this.dcPend = dcPend;
	}
	
	/**
	 * Column Info
	 * @param openIndPer
	 */
	public void setOpenIndPer(String openIndPer) {
		this.openIndPer = openIndPer;
	}
	
	/**
	 * Column Info
	 * @param done
	 */
	public void setDone(String done) {
		this.done = done;
	}
	
	/**
	 * Column Info
	 * @param dcPendPer
	 */
	public void setDcPendPer(String dcPendPer) {
		this.dcPendPer = dcPendPer;
	}
	
	/**
	 * Column Info
	 * @param blProof
	 */
	public void setBlProof(String blProof) {
		this.blProof = blProof;
	}
	
	/**
	 * Column Info
	 * @param qa
	 */
	public void setQa(String qa) {
		this.qa = qa;
	}
	
	/**
	 * Column Info
	 * @param kind
	 */
	public void setKind(String kind) {
		this.kind = kind;
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
	 * @param foPend
	 */
	public void setFoPend(String foPend) {
		this.foPend = foPend;
	}
	
	/**
	 * Column Info
	 * @param qaPer
	 */
	public void setQaPer(String qaPer) {
		this.qaPer = qaPer;
	}
	
	/**
	 * Column Info
	 * @param foPendPer
	 */
	public void setFoPendPer(String foPendPer) {
		this.foPendPer = foPendPer;
	}
	
	/**
	 * Column Info
	 * @param input
	 */
	public void setInput(String input) {
		this.input = input;
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
	 * @param rate
	 */
	public void setRate(String rate) {
		this.rate = rate;
	}
	
	/**
	 * Column Info
	 * @param blProofPer
	 */
	public void setBlProofPer(String blProofPer) {
		this.blProofPer = blProofPer;
	}
	
	/**
	 * Column Info
	 * @param openInd
	 */
	public void setOpenInd(String openInd) {
		this.openInd = openInd;
	}
	
	/**
	 * Column Info
	 * @param donePer
	 */
	public void setDonePer(String donePer) {
		this.donePer = donePer;
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
		setInputPer(JSPUtil.getParameter(request, prefix + "input_per", ""));
		setRegion(JSPUtil.getParameter(request, prefix + "region", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setTotal(JSPUtil.getParameter(request, prefix + "total", ""));
		setRatePer(JSPUtil.getParameter(request, prefix + "rate_per", ""));
		setDcPend(JSPUtil.getParameter(request, prefix + "dc_pend", ""));
		setOpenIndPer(JSPUtil.getParameter(request, prefix + "open_ind_per", ""));
		setDone(JSPUtil.getParameter(request, prefix + "done", ""));
		setDcPendPer(JSPUtil.getParameter(request, prefix + "dc_pend_per", ""));
		setBlProof(JSPUtil.getParameter(request, prefix + "bl_proof", ""));
		setQa(JSPUtil.getParameter(request, prefix + "qa", ""));
		setKind(JSPUtil.getParameter(request, prefix + "kind", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFoPend(JSPUtil.getParameter(request, prefix + "fo_pend", ""));
		setQaPer(JSPUtil.getParameter(request, prefix + "qa_per", ""));
		setFoPendPer(JSPUtil.getParameter(request, prefix + "fo_pend_per", ""));
		setInput(JSPUtil.getParameter(request, prefix + "input", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setRate(JSPUtil.getParameter(request, prefix + "rate", ""));
		setBlProofPer(JSPUtil.getParameter(request, prefix + "bl_proof_per", ""));
		setOpenInd(JSPUtil.getParameter(request, prefix + "open_ind", ""));
		setDonePer(JSPUtil.getParameter(request, prefix + "done_per", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DocQueueSummaryStatusVO[]
	 */
	public DocQueueSummaryStatusVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DocQueueSummaryStatusVO[]
	 */
	public DocQueueSummaryStatusVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DocQueueSummaryStatusVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] inputPer = (JSPUtil.getParameter(request, prefix	+ "input_per", length));
			String[] region = (JSPUtil.getParameter(request, prefix	+ "region", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] ratePer = (JSPUtil.getParameter(request, prefix	+ "rate_per", length));
			String[] dcPend = (JSPUtil.getParameter(request, prefix	+ "dc_pend", length));
			String[] openIndPer = (JSPUtil.getParameter(request, prefix	+ "open_ind_per", length));
			String[] done = (JSPUtil.getParameter(request, prefix	+ "done", length));
			String[] dcPendPer = (JSPUtil.getParameter(request, prefix	+ "dc_pend_per", length));
			String[] blProof = (JSPUtil.getParameter(request, prefix	+ "bl_proof", length));
			String[] qa = (JSPUtil.getParameter(request, prefix	+ "qa", length));
			String[] kind = (JSPUtil.getParameter(request, prefix	+ "kind", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] foPend = (JSPUtil.getParameter(request, prefix	+ "fo_pend", length));
			String[] qaPer = (JSPUtil.getParameter(request, prefix	+ "qa_per", length));
			String[] foPendPer = (JSPUtil.getParameter(request, prefix	+ "fo_pend_per", length));
			String[] input = (JSPUtil.getParameter(request, prefix	+ "input", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] rate = (JSPUtil.getParameter(request, prefix	+ "rate", length));
			String[] blProofPer = (JSPUtil.getParameter(request, prefix	+ "bl_proof_per", length));
			String[] openInd = (JSPUtil.getParameter(request, prefix	+ "open_ind", length));
			String[] donePer = (JSPUtil.getParameter(request, prefix	+ "done_per", length));
			
			for (int i = 0; i < length; i++) {
				model = new DocQueueSummaryStatusVO();
				if (inputPer[i] != null)
					model.setInputPer(inputPer[i]);
				if (region[i] != null)
					model.setRegion(region[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (total[i] != null)
					model.setTotal(total[i]);
				if (ratePer[i] != null)
					model.setRatePer(ratePer[i]);
				if (dcPend[i] != null)
					model.setDcPend(dcPend[i]);
				if (openIndPer[i] != null)
					model.setOpenIndPer(openIndPer[i]);
				if (done[i] != null)
					model.setDone(done[i]);
				if (dcPendPer[i] != null)
					model.setDcPendPer(dcPendPer[i]);
				if (blProof[i] != null)
					model.setBlProof(blProof[i]);
				if (qa[i] != null)
					model.setQa(qa[i]);
				if (kind[i] != null)
					model.setKind(kind[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (foPend[i] != null)
					model.setFoPend(foPend[i]);
				if (qaPer[i] != null)
					model.setQaPer(qaPer[i]);
				if (foPendPer[i] != null)
					model.setFoPendPer(foPendPer[i]);
				if (input[i] != null)
					model.setInput(input[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (rate[i] != null)
					model.setRate(rate[i]);
				if (blProofPer[i] != null)
					model.setBlProofPer(blProofPer[i]);
				if (openInd[i] != null)
					model.setOpenInd(openInd[i]);
				if (donePer[i] != null)
					model.setDonePer(donePer[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDocQueueSummaryStatusVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DocQueueSummaryStatusVO[]
	 */
	public DocQueueSummaryStatusVO[] getDocQueueSummaryStatusVOs(){
		DocQueueSummaryStatusVO[] vos = (DocQueueSummaryStatusVO[])models.toArray(new DocQueueSummaryStatusVO[models.size()]);
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
		this.inputPer = this.inputPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.region = this.region .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ratePer = this.ratePer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcPend = this.dcPend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.openIndPer = this.openIndPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.done = this.done .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcPendPer = this.dcPendPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blProof = this.blProof .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qa = this.qa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kind = this.kind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foPend = this.foPend .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.qaPer = this.qaPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.foPendPer = this.foPendPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.input = this.input .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rate = this.rate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blProofPer = this.blProofPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.openInd = this.openInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.donePer = this.donePer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
