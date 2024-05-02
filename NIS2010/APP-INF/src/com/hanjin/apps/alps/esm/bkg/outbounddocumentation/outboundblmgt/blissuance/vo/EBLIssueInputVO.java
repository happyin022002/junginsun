/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EBLIssueInputVO.java
*@FileTitle : EBLIssueInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.08
*@LastModifier : 최도순
*@LastVersion : 1.0
* 2011.02.08 최도순 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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
 * @author 최도순
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EBLIssueInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EBLIssueInputVO> models = new ArrayList<EBLIssueInputVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String srRqstTpCd = null;
	/* Column Info */
	private String srRqstStDt = null;
	/* Column Info */
	private String delCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String srRqstEndDt = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String srRqstNo = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String srRqstDt = null;
	/* Column Info */
	private String dtType = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EBLIssueInputVO() {}

	public EBLIssueInputVO(String ibflag, String pagerows, String srRqstTpCd, String srStsCd, String srRqstNo, String bkgNo, String srRqstDt, String srRqstStDt, String srRqstEndDt, String custTpCd, String custCd, String custNm, String vvd, String slanCd, String porCd, String polCd, String podCd, String delCd, String dtType) {
		this.porCd = porCd;
		this.srStsCd = srStsCd;
		this.custNm = custNm;
		this.srRqstTpCd = srRqstTpCd;
		this.srRqstStDt = srRqstStDt;
		this.delCd = delCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.vvd = vvd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.slanCd = slanCd;
		this.srRqstEndDt = srRqstEndDt;
		this.custCd = custCd;
		this.srRqstNo = srRqstNo;
		this.custTpCd = custTpCd;
		this.srRqstDt = srRqstDt;
		this.dtType = dtType;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("sr_rqst_tp_cd", getSrRqstTpCd());
		this.hashColumns.put("sr_rqst_st_dt", getSrRqstStDt());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("sr_rqst_end_dt", getSrRqstEndDt());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("sr_rqst_no", getSrRqstNo());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("sr_rqst_dt", getSrRqstDt());
		this.hashColumns.put("dt_type", getDtType());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("sr_rqst_tp_cd", "srRqstTpCd");
		this.hashFields.put("sr_rqst_st_dt", "srRqstStDt");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("sr_rqst_end_dt", "srRqstEndDt");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("sr_rqst_no", "srRqstNo");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("sr_rqst_dt", "srRqstDt");
		this.hashFields.put("dt_type", "dtType");
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
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
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
	 * @return srRqstTpCd
	 */
	public String getSrRqstTpCd() {
		return this.srRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @return srRqstStDt
	 */
	public String getSrRqstStDt() {
		return this.srRqstStDt;
	}
	
	/**
	 * Column Info
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return srRqstEndDt
	 */
	public String getSrRqstEndDt() {
		return this.srRqstEndDt;
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
	 * @return srRqstNo
	 */
	public String getSrRqstNo() {
		return this.srRqstNo;
	}
	
	/**
	 * Column Info
	 * @return custTpCd
	 */
	public String getCustTpCd() {
		return this.custTpCd;
	}
	
	/**
	 * Column Info
	 * @return srRqstDt
	 */
	public String getSrRqstDt() {
		return this.srRqstDt;
	}

	/**
	 * Column Info
	 * @return dtType
	 */
	public String getDtType() {
		return this.dtType;
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
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
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
	 * @param srRqstTpCd
	 */
	public void setSrRqstTpCd(String srRqstTpCd) {
		this.srRqstTpCd = srRqstTpCd;
	}
	
	/**
	 * Column Info
	 * @param srRqstStDt
	 */
	public void setSrRqstStDt(String srRqstStDt) {
		this.srRqstStDt = srRqstStDt;
	}
	
	/**
	 * Column Info
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param srRqstEndDt
	 */
	public void setSrRqstEndDt(String srRqstEndDt) {
		this.srRqstEndDt = srRqstEndDt;
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
	 * @param srRqstNo
	 */
	public void setSrRqstNo(String srRqstNo) {
		this.srRqstNo = srRqstNo;
	}
	
	/**
	 * Column Info
	 * @param custTpCd
	 */
	public void setCustTpCd(String custTpCd) {
		this.custTpCd = custTpCd;
	}
	
	/**
	 * Column Info
	 * @param srRqstDt
	 */
	public void setSrRqstDt(String srRqstDt) {
		this.srRqstDt = srRqstDt;
	}
	
	/**
	 * Column Info
	 * @param dtType
	 */
	public void setDtType(String dtType) {
		this.dtType = dtType;
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
		setSrStsCd(JSPUtil.getParameter(request, prefix + "sr_sts_cd", ""));
		setCustNm(JSPUtil.getParameter(request, prefix + "cust_nm", ""));
		setSrRqstTpCd(JSPUtil.getParameter(request, prefix + "sr_rqst_tp_cd", ""));
		setSrRqstStDt(JSPUtil.getParameter(request, prefix + "sr_rqst_st_dt", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setSrRqstEndDt(JSPUtil.getParameter(request, prefix + "sr_rqst_end_dt", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setSrRqstNo(JSPUtil.getParameter(request, prefix + "sr_rqst_no", ""));
		setCustTpCd(JSPUtil.getParameter(request, prefix + "cust_tp_cd", ""));
		setSrRqstDt(JSPUtil.getParameter(request, prefix + "sr_rqst_dt", ""));
		setDtType(JSPUtil.getParameter(request, prefix + "dt_type", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EBLIssueInputVO[]
	 */
	public EBLIssueInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EBLIssueInputVO[]
	 */
	public EBLIssueInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EBLIssueInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] srRqstTpCd = (JSPUtil.getParameter(request, prefix	+ "sr_rqst_tp_cd", length));
			String[] srRqstStDt = (JSPUtil.getParameter(request, prefix	+ "sr_rqst_st_dt", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] srRqstEndDt = (JSPUtil.getParameter(request, prefix	+ "sr_rqst_end_dt", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] srRqstNo = (JSPUtil.getParameter(request, prefix	+ "sr_rqst_no", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] srRqstDt = (JSPUtil.getParameter(request, prefix	+ "sr_rqst_dt", length));
			String[] dtType = (JSPUtil.getParameter(request, prefix	+ "dt_type", length));
			
			for (int i = 0; i < length; i++) {
				model = new EBLIssueInputVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (srRqstTpCd[i] != null)
					model.setSrRqstTpCd(srRqstTpCd[i]);
				if (srRqstStDt[i] != null)
					model.setSrRqstStDt(srRqstStDt[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (srRqstEndDt[i] != null)
					model.setSrRqstEndDt(srRqstEndDt[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (srRqstNo[i] != null)
					model.setSrRqstNo(srRqstNo[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (srRqstDt[i] != null)
					model.setSrRqstDt(srRqstDt[i]);
				if (dtType[i] != null)
					model.setDtType(dtType[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEBLIssueInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EBLIssueInputVO[]
	 */
	public EBLIssueInputVO[] getEBLIssueInputVOs(){
		EBLIssueInputVO[] vos = (EBLIssueInputVO[])models.toArray(new EBLIssueInputVO[models.size()]);
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
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRqstTpCd = this.srRqstTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRqstStDt = this.srRqstStDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRqstEndDt = this.srRqstEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRqstNo = this.srRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srRqstDt = this.srRqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dtType = this.dtType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
