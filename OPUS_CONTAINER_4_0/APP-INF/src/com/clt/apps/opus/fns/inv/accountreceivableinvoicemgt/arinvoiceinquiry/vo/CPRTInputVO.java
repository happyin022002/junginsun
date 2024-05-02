/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : CPRTInputVO.java
*@FileTitle : CPRTInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.24
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.24  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo;

import java.lang.reflect.Field;
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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CPRTInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CPRTInputVO> models = new ArrayList<CPRTInputVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String cntrNoYn = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String custGb = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rptTmpltNm = null;
	/* Column Info */
	private String chgCdYn = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String custSeq = null;
	/* Column Info */
	private String arOfcCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String creUsrId = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String dateGb = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public CPRTInputVO() {}

	public CPRTInputVO(String ibflag, String pagerows, String bkgOfcCd, String porCd, String custGb, String cntrNoYn, String rptTmpltNm, String delCd, String chgCdYn, String toDate, String custSeq, String arOfcCd, String podCd, String vvd, String rfaNo, String creUsrId, String polCd, String fromDate, String scNo, String obSlsOfcCd, String custCntCd, String dateGb, String frtTermCd, String custCd, String blNos) {
		this.porCd = porCd;
		this.cntrNoYn = cntrNoYn;
		this.pagerows = pagerows;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.blNos = blNos;
		this.scNo = scNo;
		this.obSlsOfcCd = obSlsOfcCd;
		this.custCntCd = custCntCd;
		this.bkgOfcCd = bkgOfcCd;
		this.custGb = custGb;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.rptTmpltNm = rptTmpltNm;
		this.chgCdYn = chgCdYn;
		this.toDate = toDate;
		this.custSeq = custSeq;
		this.arOfcCd = arOfcCd;
		this.podCd = podCd;
		this.vvd = vvd;
		this.creUsrId = creUsrId;
		this.fromDate = fromDate;
		this.custCd = custCd;
		this.dateGb = dateGb;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("cntr_no_yn", getCntrNoYn());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("cust_gb", getCustGb());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rpt_tmplt_nm", getRptTmpltNm());
		this.hashColumns.put("chg_cd_yn", getChgCdYn());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("cust_seq", getCustSeq());
		this.hashColumns.put("ar_ofc_cd", getArOfcCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("cre_usr_id", getCreUsrId());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("date_gb", getDateGb());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("cntr_no_yn", "cntrNoYn");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("cust_gb", "custGb");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rpt_tmplt_nm", "rptTmpltNm");
		this.hashFields.put("chg_cd_yn", "chgCdYn");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("cust_seq", "custSeq");
		this.hashFields.put("ar_ofc_cd", "arOfcCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("cre_usr_id", "creUsrId");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("date_gb", "dateGb");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return cntrNoYn
	 */
	public String getCntrNoYn() {
		return this.cntrNoYn;
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
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return blNos
	 */
	public String getBlNos() {
		return this.blNos;
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
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
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
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return custGb
	 */
	public String getCustGb() {
		return this.custGb;
	}
	
	/**
	 * Column Info
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return rptTmpltNm
	 */
	public String getRptTmpltNm() {
		return this.rptTmpltNm;
	}
	
	/**
	 * Column Info
	 * @return chgCdYn
	 */
	public String getChgCdYn() {
		return this.chgCdYn;
	}
	
	/**
	 * Column Info
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
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
	 * @return arOfcCd
	 */
	public String getArOfcCd() {
		return this.arOfcCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return fromDate
	 */
	public String getFromDate() {
		return this.fromDate;
	}
	
	/**
	 * Column Info
	 * @return custCd
	 */
	public String getCustCd() {
		return this.custCd;
	}
	
	/**
	 * Column Info
	 * @return dateGb
	 */
	public String getDateGb() {
		return this.dateGb;
	}
	

	/**
	 * Column Info
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param cntrNoYn
	 */
	public void setCntrNoYn(String cntrNoYn) {
		this.cntrNoYn = cntrNoYn;
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
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param blNos
	 */
	public void setBlNos(String blNos) {
		this.blNos = blNos;
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
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
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
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param custGb
	 */
	public void setCustGb(String custGb) {
		this.custGb = custGb;
	}
	
	/**
	 * Column Info
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param rptTmpltNm
	 */
	public void setRptTmpltNm(String rptTmpltNm) {
		this.rptTmpltNm = rptTmpltNm;
	}
	
	/**
	 * Column Info
	 * @param chgCdYn
	 */
	public void setChgCdYn(String chgCdYn) {
		this.chgCdYn = chgCdYn;
	}
	
	/**
	 * Column Info
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
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
	 * @param arOfcCd
	 */
	public void setArOfcCd(String arOfcCd) {
		this.arOfcCd = arOfcCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param fromDate
	 */
	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}
	
	/**
	 * Column Info
	 * @param custCd
	 */
	public void setCustCd(String custCd) {
		this.custCd = custCd;
	}
	
	/**
	 * Column Info
	 * @param dateGb
	 */
	public void setDateGb(String dateGb) {
		this.dateGb = dateGb;
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
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setCntrNoYn(JSPUtil.getParameter(request, prefix + "cntr_no_yn", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setBlNos(JSPUtil.getParameter(request, prefix + "bl_nos", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setCustCntCd(JSPUtil.getParameter(request, prefix + "cust_cnt_cd", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setCustGb(JSPUtil.getParameter(request, prefix + "cust_gb", ""));
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setRptTmpltNm(JSPUtil.getParameter(request, prefix + "rpt_tmplt_nm", ""));
		setChgCdYn(JSPUtil.getParameter(request, prefix + "chg_cd_yn", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setCustSeq(JSPUtil.getParameter(request, prefix + "cust_seq", ""));
		setArOfcCd(JSPUtil.getParameter(request, prefix + "ar_ofc_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setCreUsrId(JSPUtil.getParameter(request, prefix + "cre_usr_id", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setDateGb(JSPUtil.getParameter(request, prefix + "date_gb", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CPRTInputVO[]
	 */
	public CPRTInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CPRTInputVO[]
	 */
	public CPRTInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CPRTInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] cntrNoYn = (JSPUtil.getParameter(request, prefix	+ "cntr_no_yn", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] custGb = (JSPUtil.getParameter(request, prefix	+ "cust_gb", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rptTmpltNm = (JSPUtil.getParameter(request, prefix	+ "rpt_tmplt_nm", length));
			String[] chgCdYn = (JSPUtil.getParameter(request, prefix	+ "chg_cd_yn", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			String[] arOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_ofc_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] creUsrId = (JSPUtil.getParameter(request, prefix	+ "cre_usr_id", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] dateGb = (JSPUtil.getParameter(request, prefix	+ "date_gb", length));
			
			for (int i = 0; i < length; i++) {
				model = new CPRTInputVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (cntrNoYn[i] != null)
					model.setCntrNoYn(cntrNoYn[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (custGb[i] != null)
					model.setCustGb(custGb[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rptTmpltNm[i] != null)
					model.setRptTmpltNm(rptTmpltNm[i]);
				if (chgCdYn[i] != null)
					model.setChgCdYn(chgCdYn[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				if (arOfcCd[i] != null)
					model.setArOfcCd(arOfcCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (creUsrId[i] != null)
					model.setCreUsrId(creUsrId[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (dateGb[i] != null)
					model.setDateGb(dateGb[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCPRTInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CPRTInputVO[]
	 */
	public CPRTInputVO[] getCPRTInputVOs(){
		CPRTInputVO[] vos = (CPRTInputVO[])models.toArray(new CPRTInputVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoYn = this.cntrNoYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custGb = this.custGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rptTmpltNm = this.rptTmpltNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chgCdYn = this.chgCdYn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arOfcCd = this.arOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creUsrId = this.creUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dateGb = this.dateGb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
