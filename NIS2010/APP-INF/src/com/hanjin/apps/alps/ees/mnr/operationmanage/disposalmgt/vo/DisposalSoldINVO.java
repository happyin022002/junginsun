/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DisposalSoldINVO.java
*@FileTitle : DisposalSoldINVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.06
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.06  
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.10.14 허철용 [CHM-201113679-01] ALPS MNR-Disposal-SOLD Creation 에서
*                  office로 sold creation 할 수 있게 office 입력 및 조회할 수 있게 보완 개발
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DisposalSoldINVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DisposalSoldINVO> models = new ArrayList<DisposalSoldINVO>();
	
	/* Column Info */
	private String kindCd = null;
	/* Column Info */
	private String selectedDispNo = null;
	/* Column Info */
	private String dispNo = null;
	/* Column Info */
	private String status = null;
	/* Column Info */
	private String kindNo = null;
	/* Column Info */
	private String mnrPrnrCntCd = null;
	/* Column Info */
	private String selectedMnrPrnrSeq = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrPrnrSeq = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqNo = null;
	/* Column Info */
	private String selectedMnrPrnrCntCd = null;
	/* Column Info */
	private String aproDtTo = null;
	/* Column Info */
	private String aproDtFr = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DisposalSoldINVO() {}

	public DisposalSoldINVO(String ibflag, String pagerows, String kindCd, String selectedDispNo, String dispNo, String status, String kindNo, String mnrPrnrCntCd, String selectedMnrPrnrSeq, String eqKndCd, String mnrPrnrSeq, String eqNo, String selectedMnrPrnrCntCd, String aproDtTo, String aproDtFr, String ofcCd) {
		this.kindCd = kindCd;
		this.selectedDispNo = selectedDispNo;
		this.dispNo = dispNo;
		this.status = status;
		this.kindNo = kindNo;
		this.mnrPrnrCntCd = mnrPrnrCntCd;
		this.selectedMnrPrnrSeq = selectedMnrPrnrSeq;
		this.eqKndCd = eqKndCd;
		this.pagerows = pagerows;
		this.mnrPrnrSeq = mnrPrnrSeq;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.eqNo = eqNo;
		this.selectedMnrPrnrCntCd = selectedMnrPrnrCntCd;
		this.aproDtTo = aproDtTo;
		this.aproDtFr = aproDtFr;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("kind_cd", getKindCd());
		this.hashColumns.put("selected_disp_no", getSelectedDispNo());
		this.hashColumns.put("disp_no", getDispNo());
		this.hashColumns.put("status", getStatus());
		this.hashColumns.put("kind_no", getKindNo());
		this.hashColumns.put("mnr_prnr_cnt_cd", getMnrPrnrCntCd());
		this.hashColumns.put("selected_mnr_prnr_seq", getSelectedMnrPrnrSeq());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_prnr_seq", getMnrPrnrSeq());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("selected_mnr_prnr_cnt_cd", getSelectedMnrPrnrCntCd());
		this.hashColumns.put("apro_dt_to", getAproDtTo());
		this.hashColumns.put("apro_dt_fr", getAproDtFr());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("kind_cd", "kindCd");
		this.hashFields.put("selected_disp_no", "selectedDispNo");
		this.hashFields.put("disp_no", "dispNo");
		this.hashFields.put("status", "status");
		this.hashFields.put("kind_no", "kindNo");
		this.hashFields.put("mnr_prnr_cnt_cd", "mnrPrnrCntCd");
		this.hashFields.put("selected_mnr_prnr_seq", "selectedMnrPrnrSeq");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_prnr_seq", "mnrPrnrSeq");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("selected_mnr_prnr_cnt_cd", "selectedMnrPrnrCntCd");
		this.hashFields.put("apro_dt_to", "aproDtTo");
		this.hashFields.put("apro_dt_fr", "aproDtFr");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return kindCd
	 */
	public String getKindCd() {
		return this.kindCd;
	}
	
	/**
	 * Column Info
	 * @return selectedDispNo
	 */
	public String getSelectedDispNo() {
		return this.selectedDispNo;
	}
	
	/**
	 * Column Info
	 * @return dispNo
	 */
	public String getDispNo() {
		return this.dispNo;
	}
	
	/**
	 * Column Info
	 * @return status
	 */
	public String getStatus() {
		return this.status;
	}
	
	/**
	 * Column Info
	 * @return kindNo
	 */
	public String getKindNo() {
		return this.kindNo;
	}
	
	/**
	 * Column Info
	 * @return mnrPrnrCntCd
	 */
	public String getMnrPrnrCntCd() {
		return this.mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @return selectedMnrPrnrSeq
	 */
	public String getSelectedMnrPrnrSeq() {
		return this.selectedMnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
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
	 * @return mnrPrnrSeq
	 */
	public String getMnrPrnrSeq() {
		return this.mnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
	}
	
	/**
	 * Column Info
	 * @return selectedMnrPrnrCntCd
	 */
	public String getSelectedMnrPrnrCntCd() {
		return this.selectedMnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @return aproDtTo
	 */
	public String getAproDtTo() {
		return this.aproDtTo;
	}
	
	/**
	 * Column Info
	 * @return aproDtFr
	 */
	public String getAproDtFr() {
		return this.aproDtFr;
	}
	

	/**
	 * Column Info
	 * @param kindCd
	 */
	public void setKindCd(String kindCd) {
		this.kindCd = kindCd;
	}
	
	/**
	 * Column Info
	 * @param selectedDispNo
	 */
	public void setSelectedDispNo(String selectedDispNo) {
		this.selectedDispNo = selectedDispNo;
	}
	
	/**
	 * Column Info
	 * @param dispNo
	 */
	public void setDispNo(String dispNo) {
		this.dispNo = dispNo;
	}
	
	/**
	 * Column Info
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * Column Info
	 * @param kindNo
	 */
	public void setKindNo(String kindNo) {
		this.kindNo = kindNo;
	}
	
	/**
	 * Column Info
	 * @param mnrPrnrCntCd
	 */
	public void setMnrPrnrCntCd(String mnrPrnrCntCd) {
		this.mnrPrnrCntCd = mnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @param selectedMnrPrnrSeq
	 */
	public void setSelectedMnrPrnrSeq(String selectedMnrPrnrSeq) {
		this.selectedMnrPrnrSeq = selectedMnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
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
	 * @param mnrPrnrSeq
	 */
	public void setMnrPrnrSeq(String mnrPrnrSeq) {
		this.mnrPrnrSeq = mnrPrnrSeq;
	}
	
	/**
	 * Column Info
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
	}
	
	/**
	 * Column Info
	 * @param selectedMnrPrnrCntCd
	 */
	public void setSelectedMnrPrnrCntCd(String selectedMnrPrnrCntCd) {
		this.selectedMnrPrnrCntCd = selectedMnrPrnrCntCd;
	}
	
	/**
	 * Column Info
	 * @param aproDtTo
	 */
	public void setAproDtTo(String aproDtTo) {
		this.aproDtTo = aproDtTo;
	}
	
	/**
	 * Column Info
	 * @param aproDtFr
	 */
	public void setAproDtFr(String aproDtFr) {
		this.aproDtFr = aproDtFr;
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
		setKindCd(JSPUtil.getParameter(request, prefix + "kind_cd", ""));
		setSelectedDispNo(JSPUtil.getParameter(request, prefix + "selected_disp_no", ""));
		setDispNo(JSPUtil.getParameter(request, prefix + "disp_no", ""));
		setStatus(JSPUtil.getParameter(request, prefix + "status", ""));
		setKindNo(JSPUtil.getParameter(request, prefix + "kind_no", ""));
		setMnrPrnrCntCd(JSPUtil.getParameter(request, prefix + "mnr_prnr_cnt_cd", ""));
		setSelectedMnrPrnrSeq(JSPUtil.getParameter(request, prefix + "selected_mnr_prnr_seq", ""));
		setEqKndCd(JSPUtil.getParameter(request, prefix + "eq_knd_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setMnrPrnrSeq(JSPUtil.getParameter(request, prefix + "mnr_prnr_seq", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setSelectedMnrPrnrCntCd(JSPUtil.getParameter(request, prefix + "selected_mnr_prnr_cnt_cd", ""));
		setAproDtTo(JSPUtil.getParameter(request, prefix + "apro_dt_to", ""));
		setAproDtFr(JSPUtil.getParameter(request, prefix + "apro_dt_fr", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DisposalSoldINVO[]
	 */
	public DisposalSoldINVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DisposalSoldINVO[]
	 */
	public DisposalSoldINVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DisposalSoldINVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] kindCd = (JSPUtil.getParameter(request, prefix	+ "kind_cd", length));
			String[] selectedDispNo = (JSPUtil.getParameter(request, prefix	+ "selected_disp_no", length));
			String[] dispNo = (JSPUtil.getParameter(request, prefix	+ "disp_no", length));
			String[] status = (JSPUtil.getParameter(request, prefix	+ "status", length));
			String[] kindNo = (JSPUtil.getParameter(request, prefix	+ "kind_no", length));
			String[] mnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_cnt_cd", length));
			String[] selectedMnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "selected_mnr_prnr_seq", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrPrnrSeq = (JSPUtil.getParameter(request, prefix	+ "mnr_prnr_seq", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] selectedMnrPrnrCntCd = (JSPUtil.getParameter(request, prefix	+ "selected_mnr_prnr_cnt_cd", length));
			String[] aproDtTo = (JSPUtil.getParameter(request, prefix	+ "apro_dt_to", length));
			String[] aproDtFr = (JSPUtil.getParameter(request, prefix	+ "apro_dt_fr", length));
			
			for (int i = 0; i < length; i++) {
				model = new DisposalSoldINVO();
				if (kindCd[i] != null)
					model.setKindCd(kindCd[i]);
				if (selectedDispNo[i] != null)
					model.setSelectedDispNo(selectedDispNo[i]);
				if (dispNo[i] != null)
					model.setDispNo(dispNo[i]);
				if (status[i] != null)
					model.setStatus(status[i]);
				if (kindNo[i] != null)
					model.setKindNo(kindNo[i]);
				if (mnrPrnrCntCd[i] != null)
					model.setMnrPrnrCntCd(mnrPrnrCntCd[i]);
				if (selectedMnrPrnrSeq[i] != null)
					model.setSelectedMnrPrnrSeq(selectedMnrPrnrSeq[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrPrnrSeq[i] != null)
					model.setMnrPrnrSeq(mnrPrnrSeq[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (selectedMnrPrnrCntCd[i] != null)
					model.setSelectedMnrPrnrCntCd(selectedMnrPrnrCntCd[i]);
				if (aproDtTo[i] != null)
					model.setAproDtTo(aproDtTo[i]);
				if (aproDtFr[i] != null)
					model.setAproDtFr(aproDtFr[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDisposalSoldINVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DisposalSoldINVO[]
	 */
	public DisposalSoldINVO[] getDisposalSoldINVOs(){
		DisposalSoldINVO[] vos = (DisposalSoldINVO[])models.toArray(new DisposalSoldINVO[models.size()]);
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
		this.kindCd = this.kindCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectedDispNo = this.selectedDispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dispNo = this.dispNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.status = this.status .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindNo = this.kindNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrCntCd = this.mnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectedMnrPrnrSeq = this.selectedMnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrPrnrSeq = this.mnrPrnrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.selectedMnrPrnrCntCd = this.selectedMnrPrnrCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDtTo = this.aproDtTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDtFr = this.aproDtFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
