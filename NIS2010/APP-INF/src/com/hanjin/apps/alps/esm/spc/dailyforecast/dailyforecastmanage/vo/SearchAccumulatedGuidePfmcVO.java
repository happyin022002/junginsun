/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SearchAccumulatedGuidePfmcVO.java
*@FileTitle : SearchAccumulatedGuidePfmcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.05
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2013.03.05 최윤성 
* 1.0 Creation
* 2013.03.05 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2013.08.14 [Trouble shooting] Accum 팝업 내 Period 변경 가능하도록 수정
* 2014.02.04 [CHM-201428383-01] RFA 로직 추가
=========================================================*/

package com.hanjin.apps.alps.esm.spc.dailyforecast.dailyforecastmanage.vo;

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
 * @author 최윤성
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SearchAccumulatedGuidePfmcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SearchAccumulatedGuidePfmcVO> models = new ArrayList<SearchAccumulatedGuidePfmcVO>();
	
	/* Column Info */
	private String guide = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmYrwk = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String perf = null;
	/* Column Info */
	private String toYrwk = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String subTrdCd = null;
	/* Column Info */
	private String sdate = null;
	/* Column Info */
	private String edate = null;
	/* Column Info */
	private String rfaNo = null;
	/* Column Info */
	private String rlaneCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SearchAccumulatedGuidePfmcVO() {}

	public SearchAccumulatedGuidePfmcVO(String ibflag, String pagerows, String fmYrwk, String toYrwk, String slsRgnOfcCd, String custCntCd, String custSeq, String custNm, String scNo, String custCtrlCd, String subTrdCd, String guide, String bkgQty, String perf, String sdate, String edate, String rlaneCd, String rfaNo) {
		this.guide = guide;
		this.custNm = custNm;
		this.custSeq = custSeq;
		this.custCtrlCd = custCtrlCd;
		this.pagerows = pagerows;
		this.fmYrwk = fmYrwk;
		this.ibflag = ibflag;
		this.perf = perf;
		this.toYrwk = toYrwk;
		this.scNo = scNo;
		this.bkgQty = bkgQty;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.custCntCd = custCntCd;
		this.subTrdCd = subTrdCd;
		this.sdate = sdate;
		this.edate = edate;
		this.rlaneCd = rlaneCd;
		this.rfaNo = rfaNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("guide", getGuide());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_yrwk", getFmYrwk());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("perf", getPerf());
		this.hashColumns.put("to_yrwk", getToYrwk());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		this.hashColumns.put("sdate", getSdate());
		this.hashColumns.put("edate", getEdate());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("rfa_no", getRfaNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("guide", "guide");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_yrwk", "fmYrwk");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("perf", "perf");
		this.hashFields.put("to_yrwk", "toYrwk");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		this.hashFields.put("sdate", "sdate");
		this.hashFields.put("edate", "edate");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("rfa_no", "rfaNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return guide
	 */
	public String getGuide() {
		return this.guide;
	}
	
	/**
	 * Column Info
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return custSeq
	 */
	public String getCustSeq() {
		return this.custSeq;
	}
	
	/**
	 * Column Info
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
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
	 * @return fmYrwk
	 */
	public String getFmYrwk() {
		return this.fmYrwk;
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
	 * @return perf
	 */
	public String getPerf() {
		return this.perf;
	}
	
	/**
	 * Column Info
	 * @return toYrwk
	 */
	public String getToYrwk() {
		return this.toYrwk;
	}
	
	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return bkgQty
	 */
	public String getBkgQty() {
		return this.bkgQty;
	}
	
	/**
	 * Column Info
	 * @return slsRgnOfcCd
	 */
	public String getSlsRgnOfcCd() {
		return this.slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custCntCd
	 */
	public String getCustCntCd() {
		return this.custCntCd;
	}
	
	/**
	 * Column Info
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return sdate
	 */
	public String getSdate() {
		return this.sdate;
	}
	
	/**
	 * Column Info
	 * @return edate
	 */
	public String getEdate() {
		return this.edate;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
	}
	

	/**
	 * Column Info
	 * @param guide
	 */
	public void setGuide(String guide) {
		this.guide = guide;
	}
	
	/**
	 * Column Info
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param custSeq
	 */
	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}
	
	/**
	 * Column Info
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
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
	 * @param fmYrwk
	 */
	public void setFmYrwk(String fmYrwk) {
		this.fmYrwk = fmYrwk;
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
	 * @param perf
	 */
	public void setPerf(String perf) {
		this.perf = perf;
	}
	
	/**
	 * Column Info
	 * @param toYrwk
	 */
	public void setToYrwk(String toYrwk) {
		this.toYrwk = toYrwk;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param bkgQty
	 */
	public void setBkgQty(String bkgQty) {
		this.bkgQty = bkgQty;
	}
	
	/**
	 * Column Info
	 * @param slsRgnOfcCd
	 */
	public void setSlsRgnOfcCd(String slsRgnOfcCd) {
		this.slsRgnOfcCd = slsRgnOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custCntCd
	 */
	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}
	
	/**
	 * Column Info
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param sdate
	 */
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	
	/**
	 * Column Info
	 * @param edate
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
		setGuide(JSPUtil.getParameter(request, prefix + "guide", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmYrwk(JSPUtil.getParameter(request, prefix + "fm_yrwk", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPerf(JSPUtil.getParameter(request, prefix + "perf", ""));
		setToYrwk(JSPUtil.getParameter(request, prefix + "to_yrwk", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		setSdate(JSPUtil.getParameter(request, prefix + "sdate", ""));
		setEdate(JSPUtil.getParameter(request, prefix + "edate", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchAccumulatedGuidePfmcVO[]
	 */
	public SearchAccumulatedGuidePfmcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchAccumulatedGuidePfmcVO[]
	 */
	public SearchAccumulatedGuidePfmcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SearchAccumulatedGuidePfmcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] guide = (JSPUtil.getParameter(request, prefix	+ "guide", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmYrwk = (JSPUtil.getParameter(request, prefix	+ "fm_yrwk", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] perf = (JSPUtil.getParameter(request, prefix	+ "perf", length));
			String[] toYrwk = (JSPUtil.getParameter(request, prefix	+ "to_yrwk", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			String[] sdate = (JSPUtil.getParameter(request, prefix	+ "sdate", length));
			String[] edate = (JSPUtil.getParameter(request, prefix	+ "edate", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SearchAccumulatedGuidePfmcVO();
				if (guide[i] != null)
					model.setGuide(guide[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmYrwk[i] != null)
					model.setFmYrwk(fmYrwk[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (perf[i] != null)
					model.setPerf(perf[i]);
				if (toYrwk[i] != null)
					model.setToYrwk(toYrwk[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				if (sdate[i] != null)
					model.setSdate(sdate[i]);
				if (edate[i] != null)
					model.setEdate(edate[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchAccumulatedGuidePfmcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchAccumulatedGuidePfmcVO[]
	 */
	public SearchAccumulatedGuidePfmcVO[] getSearchAccumulatedGuidePfmcVOs(){
		SearchAccumulatedGuidePfmcVO[] vos = (SearchAccumulatedGuidePfmcVO[])models.toArray(new SearchAccumulatedGuidePfmcVO[models.size()]);
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
		this.guide = this.guide .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmYrwk = this.fmYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.perf = this.perf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toYrwk = this.toYrwk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sdate = this.sdate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.edate = this.edate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
