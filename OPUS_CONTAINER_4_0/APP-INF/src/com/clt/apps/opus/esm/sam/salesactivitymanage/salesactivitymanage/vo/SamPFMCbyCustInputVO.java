/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : SamPFMCbyCustInputVO.java
*@FileTitle : SamPFMCbyCustInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.26
*@LastModifier : 이관샨
*@LastVersion : 1.0
* 2011.05.26 이관샨 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.sam.salesactivitymanage.salesactivitymanage.vo;

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
 * @author 이관샨
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SamPFMCbyCustInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SamPFMCbyCustInputVO> models = new ArrayList<SamPFMCbyCustInputVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String salesOffice = null;
	/* Column Info */
	private String totalBkg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String toDate = null;
	/* Column Info */
	private String totalQty = null;
	/* Column Info */
	private String srepCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String salesRep = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String fromDate = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String bkgCreDt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SamPFMCbyCustInputVO() {}

	public SamPFMCbyCustInputVO(String ibflag, String pagerows, String bkgNo, String bkgCreDt, String custCd, String cmdtCd, String vvd, String porCd, String polCd, String podCd, String delCd, String bkgStsCd, String srepCd, String cntrTpszCd, String opCntrQty, String totalBkg, String totalQty, String fromDate, String toDate, String salesRep, String salesOffice) {
		this.porCd = porCd;
		this.salesOffice = salesOffice;
		this.totalBkg = totalBkg;
		this.bkgStsCd = bkgStsCd;
		this.delCd = delCd;
		this.toDate = toDate;
		this.totalQty = totalQty;
		this.srepCd = srepCd;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.podCd = podCd;
		this.salesRep = salesRep;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.fromDate = fromDate;
		this.cmdtCd = cmdtCd;
		this.custCd = custCd;
		this.cntrTpszCd = cntrTpszCd;
		this.opCntrQty = opCntrQty;
		this.bkgCreDt = bkgCreDt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("sales_office", getSalesOffice());
		this.hashColumns.put("total_bkg", getTotalBkg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("to_date", getToDate());
		this.hashColumns.put("total_qty", getTotalQty());
		this.hashColumns.put("srep_cd", getSrepCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sales_rep", getSalesRep());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("from_date", getFromDate());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("bkg_cre_dt", getBkgCreDt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("sales_office", "salesOffice");
		this.hashFields.put("total_bkg", "totalBkg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("to_date", "toDate");
		this.hashFields.put("total_qty", "totalQty");
		this.hashFields.put("srep_cd", "srepCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sales_rep", "salesRep");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("from_date", "fromDate");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("bkg_cre_dt", "bkgCreDt");
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
	 * @return salesOffice
	 */
	public String getSalesOffice() {
		return this.salesOffice;
	}
	
	/**
	 * Column Info
	 * @return totalBkg
	 */
	public String getTotalBkg() {
		return this.totalBkg;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
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
	 * @return toDate
	 */
	public String getToDate() {
		return this.toDate;
	}
	
	/**
	 * Column Info
	 * @return totalQty
	 */
	public String getTotalQty() {
		return this.totalQty;
	}
	
	/**
	 * Column Info
	 * @return srepCd
	 */
	public String getSrepCd() {
		return this.srepCd;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
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
	 * @return salesRep
	 */
	public String getSalesRep() {
		return this.salesRep;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return opCntrQty
	 */
	public String getOpCntrQty() {
		return this.opCntrQty;
	}
	
	/**
	 * Column Info
	 * @return bkgCreDt
	 */
	public String getBkgCreDt() {
		return this.bkgCreDt;
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
	 * @param salesOffice
	 */
	public void setSalesOffice(String salesOffice) {
		this.salesOffice = salesOffice;
	}
	
	/**
	 * Column Info
	 * @param totalBkg
	 */
	public void setTotalBkg(String totalBkg) {
		this.totalBkg = totalBkg;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
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
	 * @param toDate
	 */
	public void setToDate(String toDate) {
		this.toDate = toDate;
	}
	
	/**
	 * Column Info
	 * @param totalQty
	 */
	public void setTotalQty(String totalQty) {
		this.totalQty = totalQty;
	}
	
	/**
	 * Column Info
	 * @param srepCd
	 */
	public void setSrepCd(String srepCd) {
		this.srepCd = srepCd;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
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
	 * @param salesRep
	 */
	public void setSalesRep(String salesRep) {
		this.salesRep = salesRep;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param opCntrQty
	 */
	public void setOpCntrQty(String opCntrQty) {
		this.opCntrQty = opCntrQty;
	}
	
	/**
	 * Column Info
	 * @param bkgCreDt
	 */
	public void setBkgCreDt(String bkgCreDt) {
		this.bkgCreDt = bkgCreDt;
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
		setSalesOffice(JSPUtil.getParameter(request, prefix + "sales_office", ""));
		setTotalBkg(JSPUtil.getParameter(request, prefix + "total_bkg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setToDate(JSPUtil.getParameter(request, prefix + "to_date", ""));
		setTotalQty(JSPUtil.getParameter(request, prefix + "total_qty", ""));
		setSrepCd(JSPUtil.getParameter(request, prefix + "srep_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setSalesRep(JSPUtil.getParameter(request, prefix + "sales_rep", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setFromDate(JSPUtil.getParameter(request, prefix + "from_date", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCustCd(JSPUtil.getParameter(request, prefix + "cust_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setBkgCreDt(JSPUtil.getParameter(request, prefix + "bkg_cre_dt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SamPFMCbyCustInputVO[]
	 */
	public SamPFMCbyCustInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SamPFMCbyCustInputVO[]
	 */
	public SamPFMCbyCustInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SamPFMCbyCustInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] salesOffice = (JSPUtil.getParameter(request, prefix	+ "sales_office", length));
			String[] totalBkg = (JSPUtil.getParameter(request, prefix	+ "total_bkg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] toDate = (JSPUtil.getParameter(request, prefix	+ "to_date", length));
			String[] totalQty = (JSPUtil.getParameter(request, prefix	+ "total_qty", length));
			String[] srepCd = (JSPUtil.getParameter(request, prefix	+ "srep_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] salesRep = (JSPUtil.getParameter(request, prefix	+ "sales_rep", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] fromDate = (JSPUtil.getParameter(request, prefix	+ "from_date", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] bkgCreDt = (JSPUtil.getParameter(request, prefix	+ "bkg_cre_dt", length));
			
			for (int i = 0; i < length; i++) {
				model = new SamPFMCbyCustInputVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (salesOffice[i] != null)
					model.setSalesOffice(salesOffice[i]);
				if (totalBkg[i] != null)
					model.setTotalBkg(totalBkg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (toDate[i] != null)
					model.setToDate(toDate[i]);
				if (totalQty[i] != null)
					model.setTotalQty(totalQty[i]);
				if (srepCd[i] != null)
					model.setSrepCd(srepCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (salesRep[i] != null)
					model.setSalesRep(salesRep[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (fromDate[i] != null)
					model.setFromDate(fromDate[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (bkgCreDt[i] != null)
					model.setBkgCreDt(bkgCreDt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSamPFMCbyCustInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SamPFMCbyCustInputVO[]
	 */
	public SamPFMCbyCustInputVO[] getSamPFMCbyCustInputVOs(){
		SamPFMCbyCustInputVO[] vos = (SamPFMCbyCustInputVO[])models.toArray(new SamPFMCbyCustInputVO[models.size()]);
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
		this.salesOffice = this.salesOffice .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBkg = this.totalBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDate = this.toDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalQty = this.totalQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srepCd = this.srepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesRep = this.salesRep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDate = this.fromDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCreDt = this.bkgCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
