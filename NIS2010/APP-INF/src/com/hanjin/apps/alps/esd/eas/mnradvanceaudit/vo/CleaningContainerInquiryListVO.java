/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CleaningContainerInquiryListVO.java
*@FileTitle : CleaningContainerInquiryListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.05.21
*@LastModifier : 박정민
*@LastVersion : 1.0
* 2015.05.21 박정민 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.eas.mnradvanceaudit.vo;

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
 * @author 박정민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CleaningContainerInquiryListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CleaningContainerInquiryListVO> models = new ArrayList<CleaningContainerInquiryListVO>();
	
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String eqNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String usingDays = null;
	/* Column Info */
	private String costAmt = null;
	/* Column Info */
	private String noOfCases = null;
	/* Column Info */
	private String dvValue = null;
	/* Column Info */
	private String ttlNoOfCases = null;
	/* Column Info */
	private String ttlCostAmt = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String onhDt = null;
	/* Column Info */
	private String lstmCd = null;
	/* Column Info */
	private String ownrCoCd = null;
	/* Column Info */
	private String vndrNm = null;
	/* Column Info */
	private String seq = null;
	/* Column Info */
	private String eqTpszCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CleaningContainerInquiryListVO() {}

	public CleaningContainerInquiryListVO(String ibflag, String pagerows, String seq, String eqNo, String eqTpszCd, String lstmCd, String ownrCoCd, String currCd, String onhDt, String usingDays, String dvValue, String ttlNoOfCases, String locCd, String ttlCostAmt, String ydCd, String vndrSeq, String vndrNm, String noOfCases, String costAmt) {
		this.pagerows = pagerows;
		this.eqNo = eqNo;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.currCd = currCd;
		this.usingDays = usingDays;
		this.costAmt = costAmt;
		this.noOfCases = noOfCases;
		this.dvValue = dvValue;
		this.ttlNoOfCases = ttlNoOfCases;
		this.ttlCostAmt = ttlCostAmt;
		this.vndrSeq = vndrSeq;
		this.ydCd = ydCd;
		this.onhDt = onhDt;
		this.lstmCd = lstmCd;
		this.ownrCoCd = ownrCoCd;
		this.vndrNm = vndrNm;
		this.seq = seq;
		this.eqTpszCd = eqTpszCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eq_no", getEqNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("using_days", getUsingDays());
		this.hashColumns.put("cost_amt", getCostAmt());
		this.hashColumns.put("no_of_cases", getNoOfCases());
		this.hashColumns.put("dv_value", getDvValue());
		this.hashColumns.put("ttl_no_of_cases", getTtlNoOfCases());
		this.hashColumns.put("ttl_cost_amt", getTtlCostAmt());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("onh_dt", getOnhDt());
		this.hashColumns.put("lstm_cd", getLstmCd());
		this.hashColumns.put("ownr_co_cd", getOwnrCoCd());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("seq", getSeq());
		this.hashColumns.put("eq_tpsz_cd", getEqTpszCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eq_no", "eqNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("using_days", "usingDays");
		this.hashFields.put("cost_amt", "costAmt");
		this.hashFields.put("no_of_cases", "noOfCases");
		this.hashFields.put("dv_value", "dvValue");
		this.hashFields.put("ttl_no_of_cases", "ttlNoOfCases");
		this.hashFields.put("ttl_cost_amt", "ttlCostAmt");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("onh_dt", "onhDt");
		this.hashFields.put("lstm_cd", "lstmCd");
		this.hashFields.put("ownr_co_cd", "ownrCoCd");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("seq", "seq");
		this.hashFields.put("eq_tpsz_cd", "eqTpszCd");
		return this.hashFields;
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
	 * @return eqNo
	 */
	public String getEqNo() {
		return this.eqNo;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
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
	 * @return usingDays
	 */
	public String getUsingDays() {
		return this.usingDays;
	}
	
	/**
	 * Column Info
	 * @return costAmt
	 */
	public String getCostAmt() {
		return this.costAmt;
	}
	
	/**
	 * Column Info
	 * @return noOfCases
	 */
	public String getNoOfCases() {
		return this.noOfCases;
	}
	
	/**
	 * Column Info
	 * @return dvValue
	 */
	public String getDvValue() {
		return this.dvValue;
	}
	
	/**
	 * Column Info
	 * @return ttlNoOfCases
	 */
	public String getTtlNoOfCases() {
		return this.ttlNoOfCases;
	}
	
	/**
	 * Column Info
	 * @return ttlCostAmt
	 */
	public String getTtlCostAmt() {
		return this.ttlCostAmt;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return onhDt
	 */
	public String getOnhDt() {
		return this.onhDt;
	}
	
	/**
	 * Column Info
	 * @return lstmCd
	 */
	public String getLstmCd() {
		return this.lstmCd;
	}
	
	/**
	 * Column Info
	 * @return ownrCoCd
	 */
	public String getOwnrCoCd() {
		return this.ownrCoCd;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
	}
	
	/**
	 * Column Info
	 * @return seq
	 */
	public String getSeq() {
		return this.seq;
	}
	
	/**
	 * Column Info
	 * @return eqTpszCd
	 */
	public String getEqTpszCd() {
		return this.eqTpszCd;
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
	 * @param eqNo
	 */
	public void setEqNo(String eqNo) {
		this.eqNo = eqNo;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
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
	 * @param usingDays
	 */
	public void setUsingDays(String usingDays) {
		this.usingDays = usingDays;
	}
	
	/**
	 * Column Info
	 * @param costAmt
	 */
	public void setCostAmt(String costAmt) {
		this.costAmt = costAmt;
	}
	
	/**
	 * Column Info
	 * @param noOfCases
	 */
	public void setNoOfCases(String noOfCases) {
		this.noOfCases = noOfCases;
	}
	
	/**
	 * Column Info
	 * @param dvValue
	 */
	public void setDvValue(String dvValue) {
		this.dvValue = dvValue;
	}
	
	/**
	 * Column Info
	 * @param ttlNoOfCases
	 */
	public void setTtlNoOfCases(String ttlNoOfCases) {
		this.ttlNoOfCases = ttlNoOfCases;
	}
	
	/**
	 * Column Info
	 * @param ttlCostAmt
	 */
	public void setTtlCostAmt(String ttlCostAmt) {
		this.ttlCostAmt = ttlCostAmt;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param onhDt
	 */
	public void setOnhDt(String onhDt) {
		this.onhDt = onhDt;
	}
	
	/**
	 * Column Info
	 * @param lstmCd
	 */
	public void setLstmCd(String lstmCd) {
		this.lstmCd = lstmCd;
	}
	
	/**
	 * Column Info
	 * @param ownrCoCd
	 */
	public void setOwnrCoCd(String ownrCoCd) {
		this.ownrCoCd = ownrCoCd;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
	}
	
	/**
	 * Column Info
	 * @param seq
	 */
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	/**
	 * Column Info
	 * @param eqTpszCd
	 */
	public void setEqTpszCd(String eqTpszCd) {
		this.eqTpszCd = eqTpszCd;
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
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setEqNo(JSPUtil.getParameter(request, prefix + "eq_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setUsingDays(JSPUtil.getParameter(request, prefix + "using_days", ""));
		setCostAmt(JSPUtil.getParameter(request, prefix + "cost_amt", ""));
		setNoOfCases(JSPUtil.getParameter(request, prefix + "no_of_cases", ""));
		setDvValue(JSPUtil.getParameter(request, prefix + "dv_value", ""));
		setTtlNoOfCases(JSPUtil.getParameter(request, prefix + "ttl_no_of_cases", ""));
		setTtlCostAmt(JSPUtil.getParameter(request, prefix + "ttl_cost_amt", ""));
		setVndrSeq(JSPUtil.getParameter(request, prefix + "vndr_seq", ""));
		setYdCd(JSPUtil.getParameter(request, prefix + "yd_cd", ""));
		setOnhDt(JSPUtil.getParameter(request, prefix + "onh_dt", ""));
		setLstmCd(JSPUtil.getParameter(request, prefix + "lstm_cd", ""));
		setOwnrCoCd(JSPUtil.getParameter(request, prefix + "ownr_co_cd", ""));
		setVndrNm(JSPUtil.getParameter(request, prefix + "vndr_nm", ""));
		setSeq(JSPUtil.getParameter(request, prefix + "seq", ""));
		setEqTpszCd(JSPUtil.getParameter(request, prefix + "eq_tpsz_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CleaningContainerInquiryListVO[]
	 */
	public CleaningContainerInquiryListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CleaningContainerInquiryListVO[]
	 */
	public CleaningContainerInquiryListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CleaningContainerInquiryListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] eqNo = (JSPUtil.getParameter(request, prefix	+ "eq_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] usingDays = (JSPUtil.getParameter(request, prefix	+ "using_days", length));
			String[] costAmt = (JSPUtil.getParameter(request, prefix	+ "cost_amt", length));
			String[] noOfCases = (JSPUtil.getParameter(request, prefix	+ "no_of_cases", length));
			String[] dvValue = (JSPUtil.getParameter(request, prefix	+ "dv_value", length));
			String[] ttlNoOfCases = (JSPUtil.getParameter(request, prefix	+ "ttl_no_of_cases", length));
			String[] ttlCostAmt = (JSPUtil.getParameter(request, prefix	+ "ttl_cost_amt", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] onhDt = (JSPUtil.getParameter(request, prefix	+ "onh_dt", length));
			String[] lstmCd = (JSPUtil.getParameter(request, prefix	+ "lstm_cd", length));
			String[] ownrCoCd = (JSPUtil.getParameter(request, prefix	+ "ownr_co_cd", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] seq = (JSPUtil.getParameter(request, prefix	+ "seq", length));
			String[] eqTpszCd = (JSPUtil.getParameter(request, prefix	+ "eq_tpsz_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CleaningContainerInquiryListVO();
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (eqNo[i] != null)
					model.setEqNo(eqNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (usingDays[i] != null)
					model.setUsingDays(usingDays[i]);
				if (costAmt[i] != null)
					model.setCostAmt(costAmt[i]);
				if (noOfCases[i] != null)
					model.setNoOfCases(noOfCases[i]);
				if (dvValue[i] != null)
					model.setDvValue(dvValue[i]);
				if (ttlNoOfCases[i] != null)
					model.setTtlNoOfCases(ttlNoOfCases[i]);
				if (ttlCostAmt[i] != null)
					model.setTtlCostAmt(ttlCostAmt[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (onhDt[i] != null)
					model.setOnhDt(onhDt[i]);
				if (lstmCd[i] != null)
					model.setLstmCd(lstmCd[i]);
				if (ownrCoCd[i] != null)
					model.setOwnrCoCd(ownrCoCd[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (seq[i] != null)
					model.setSeq(seq[i]);
				if (eqTpszCd[i] != null)
					model.setEqTpszCd(eqTpszCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCleaningContainerInquiryListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CleaningContainerInquiryListVO[]
	 */
	public CleaningContainerInquiryListVO[] getCleaningContainerInquiryListVOs(){
		CleaningContainerInquiryListVO[] vos = (CleaningContainerInquiryListVO[])models.toArray(new CleaningContainerInquiryListVO[models.size()]);
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
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqNo = this.eqNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usingDays = this.usingDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costAmt = this.costAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.noOfCases = this.noOfCases .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dvValue = this.dvValue .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlNoOfCases = this.ttlNoOfCases .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ttlCostAmt = this.ttlCostAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.onhDt = this.onhDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lstmCd = this.lstmCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ownrCoCd = this.ownrCoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.seq = this.seq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqTpszCd = this.eqTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
