/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BkgListForBkgReceiptInputVO.java
*@FileTitle : BkgListForBkgReceiptInputVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.09
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.09 전용진 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookinglistsearch.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.common.AbstractValueObject;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 전용진
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BkgListForBkgReceiptInputVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BkgListForBkgReceiptInputVO> models = new ArrayList<BkgListForBkgReceiptInputVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgKind = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String salesOfc = null;
	/* Column Info */
	private String delCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String emlProcStsCd = null;
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
	private String faxProcStsCd = null;
	/* Column Info */
	private String custCd = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String bkgFromDt = null;
	/* Column Info */
	private String custTpCd = null;
	/* Column Info */
	private String bkgStatus = null;
	/* Column Info */
	private String bkgStaff = null;
	/* Column Info */
	private String custCntCd = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String custSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BkgListForBkgReceiptInputVO() {}

	public BkgListForBkgReceiptInputVO(String ibflag, String pagerows, String bkgNo, String bkgFromDt, String bkgToDt, String bkgOfcCd, String bkgStaff, String bkgStatus, String bkgKind, String vvd, String porCd, String polCd, String podCd, String delCd, String salesRep, String salesOfc, String custTpCd, String custCd, String custNm, String faxProcStsCd, String emlProcStsCd, String custCntCd, String polYdCd, String podYdCd, String custSeq) {
		this.bkgOfcCd = bkgOfcCd;
		this.porCd = porCd;
		this.bkgKind = bkgKind;
		this.custNm = custNm;
		this.salesOfc = salesOfc;
		this.delCd = delCd;
		this.pagerows = pagerows;
		this.emlProcStsCd = emlProcStsCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.salesRep = salesRep;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.faxProcStsCd = faxProcStsCd;
		this.custCd = custCd;
		this.bkgToDt = bkgToDt;
		this.bkgFromDt = bkgFromDt;
		this.custTpCd = custTpCd;
		this.bkgStatus = bkgStatus;
		this.bkgStaff = bkgStaff;
		this.custCntCd = custCntCd;
		this.polYdCd = polYdCd;
		this.podYdCd = podYdCd;
		this.custSeq = custSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_kind", getBkgKind());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("sales_ofc", getSalesOfc());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("eml_proc_sts_cd", getEmlProcStsCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("sales_rep", getSalesRep());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("fax_proc_sts_cd", getFaxProcStsCd());
		this.hashColumns.put("cust_cd", getCustCd());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("bkg_from_dt", getBkgFromDt());
		this.hashColumns.put("cust_tp_cd", getCustTpCd());
		this.hashColumns.put("bkg_status", getBkgStatus());
		this.hashColumns.put("bkg_staff", getBkgStaff());
		this.hashColumns.put("cust_cnt_cd", getCustCntCd());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("cust_seq", getCustSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_kind", "bkgKind");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("sales_ofc", "salesOfc");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("eml_proc_sts_cd", "emlProcStsCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("sales_rep", "salesRep");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("fax_proc_sts_cd", "faxProcStsCd");
		this.hashFields.put("cust_cd", "custCd");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("bkg_from_dt", "bkgFromDt");
		this.hashFields.put("cust_tp_cd", "custTpCd");
		this.hashFields.put("bkg_status", "bkgStatus");
		this.hashFields.put("bkg_staff", "bkgStaff");
		this.hashFields.put("cust_cnt_cd", "custCntCd");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("cust_seq", "custSeq");
		return this.hashFields;
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
	 * @return porCd
	 */
	public String getPorCd() {
		return this.porCd;
	}
	
	/**
	 * Column Info
	 * @return bkgKind
	 */
	public String getBkgKind() {
		return this.bkgKind;
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
	 * @return salesOfc
	 */
	public String getSalesOfc() {
		return this.salesOfc;
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
	 * @return emlProcStsCd
	 */
	public String getEmlProcStsCd() {
		return this.emlProcStsCd;
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
	 * @return faxProcStsCd
	 */
	public String getFaxProcStsCd() {
		return this.faxProcStsCd;
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
	 * @return bkgToDt
	 */
	public String getBkgToDt() {
		return this.bkgToDt;
	}
	
	/**
	 * Column Info
	 * @return bkgFromDt
	 */
	public String getBkgFromDt() {
		return this.bkgFromDt;
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
	 * @return bkgStatus
	 */
	public String getBkgStatus() {
		return this.bkgStatus;
	}
	
	/**
	 * Column Info
	 * @return bkgStaff
	 */
	public String getBkgStaff() {
		return this.bkgStaff;
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
	 * @param porCd
	 */
	public void setPorCd(String porCd) {
		this.porCd = porCd;
	}
	
	/**
	 * Column Info
	 * @param bkgKind
	 */
	public void setBkgKind(String bkgKind) {
		this.bkgKind = bkgKind;
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
	 * @param salesOfc
	 */
	public void setSalesOfc(String salesOfc) {
		this.salesOfc = salesOfc;
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
	 * @param emlProcStsCd
	 */
	public void setEmlProcStsCd(String emlProcStsCd) {
		this.emlProcStsCd = emlProcStsCd;
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
	 * @param faxProcStsCd
	 */
	public void setFaxProcStsCd(String faxProcStsCd) {
		this.faxProcStsCd = faxProcStsCd;
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
	 * @param bkgToDt
	 */
	public void setBkgToDt(String bkgToDt) {
		this.bkgToDt = bkgToDt;
	}
	
	/**
	 * Column Info
	 * @param bkgFromDt
	 */
	public void setBkgFromDt(String bkgFromDt) {
		this.bkgFromDt = bkgFromDt;
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
	 * @param bkgStatus
	 */
	public void setBkgStatus(String bkgStatus) {
		this.bkgStatus = bkgStatus;
	}
	
	/**
	 * Column Info
	 * @param bkgStaff
	 */
	public void setBkgStaff(String bkgStaff) {
		this.bkgStaff = bkgStaff;
	}
	
	public String getCustCntCd() {
		return custCntCd;
	}

	public void setCustCntCd(String custCntCd) {
		this.custCntCd = custCntCd;
	}

	public String getPolYdCd() {
		return polYdCd;
	}

	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}

	public String getPodYdCd() {
		return podYdCd;
	}

	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}

	public String getCustSeq() {
		return custSeq;
	}

	public void setCustSeq(String custSeq) {
		this.custSeq = custSeq;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setBkgKind(JSPUtil.getParameter(request, "bkg_kind", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setSalesOfc(JSPUtil.getParameter(request, "sales_ofc", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setEmlProcStsCd(JSPUtil.getParameter(request, "eml_proc_sts_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setSalesRep(JSPUtil.getParameter(request, "sales_rep", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setFaxProcStsCd(JSPUtil.getParameter(request, "fax_proc_sts_cd", ""));
		setCustCd(JSPUtil.getParameter(request, "cust_cd", ""));
		setBkgToDt(JSPUtil.getParameter(request, "bkg_to_dt", ""));
		setBkgFromDt(JSPUtil.getParameter(request, "bkg_from_dt", ""));
		setCustTpCd(JSPUtil.getParameter(request, "cust_tp_cd", ""));
		setBkgStatus(JSPUtil.getParameter(request, "bkg_status", ""));
		setBkgStaff(JSPUtil.getParameter(request, "bkg_staff", ""));
		setCustCntCd(JSPUtil.getParameter(request, "cust_cnt_cd", ""));
		setPolYdCd(JSPUtil.getParameter(request, "pol_yd_cd", ""));
		setPodYdCd(JSPUtil.getParameter(request, "pod_yd_cd", ""));
		setCustSeq(JSPUtil.getParameter(request, "cust_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BkgListForBkgReceiptInputVO[]
	 */
	public BkgListForBkgReceiptInputVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BkgListForBkgReceiptInputVO[]
	 */
	public BkgListForBkgReceiptInputVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BkgListForBkgReceiptInputVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgKind = (JSPUtil.getParameter(request, prefix	+ "bkg_kind", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] salesOfc = (JSPUtil.getParameter(request, prefix	+ "sales_ofc", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] emlProcStsCd = (JSPUtil.getParameter(request, prefix	+ "eml_proc_sts_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] salesRep = (JSPUtil.getParameter(request, prefix	+ "sales_rep", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] faxProcStsCd = (JSPUtil.getParameter(request, prefix	+ "fax_proc_sts_cd", length));
			String[] custCd = (JSPUtil.getParameter(request, prefix	+ "cust_cd", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] bkgFromDt = (JSPUtil.getParameter(request, prefix	+ "bkg_from_dt", length));
			String[] custTpCd = (JSPUtil.getParameter(request, prefix	+ "cust_tp_cd", length));
			String[] bkgStatus = (JSPUtil.getParameter(request, prefix	+ "bkg_status", length));
			String[] bkgStaff = (JSPUtil.getParameter(request, prefix	+ "bkg_staff", length));
			String[] custCntCd = (JSPUtil.getParameter(request, prefix	+ "cust_cnt_cd", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] custSeq = (JSPUtil.getParameter(request, prefix	+ "cust_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new BkgListForBkgReceiptInputVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgKind[i] != null)
					model.setBkgKind(bkgKind[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (salesOfc[i] != null)
					model.setSalesOfc(salesOfc[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (emlProcStsCd[i] != null)
					model.setEmlProcStsCd(emlProcStsCd[i]);
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
				if (faxProcStsCd[i] != null)
					model.setFaxProcStsCd(faxProcStsCd[i]);
				if (custCd[i] != null)
					model.setCustCd(custCd[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (bkgFromDt[i] != null)
					model.setBkgFromDt(bkgFromDt[i]);
				if (custTpCd[i] != null)
					model.setCustTpCd(custTpCd[i]);
				if (bkgStatus[i] != null)
					model.setBkgStatus(bkgStatus[i]);
				if (bkgStaff[i] != null)
					model.setBkgStaff(bkgStaff[i]);
				if (custCntCd[i] != null)
					model.setCustCntCd(custCntCd[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (custSeq[i] != null)
					model.setCustSeq(custSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBkgListForBkgReceiptInputVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BkgListForBkgReceiptInputVO[]
	 */
	public BkgListForBkgReceiptInputVO[] getBkgListForBkgReceiptInputVOs(){
		BkgListForBkgReceiptInputVO[] vos = (BkgListForBkgReceiptInputVO[])models.toArray(new BkgListForBkgReceiptInputVO[models.size()]);
		return vos;
	}
	
	/**
	 * VO Class의 내용을 String으로 변환
	 */
	public String toString() {
		StringBuffer ret = new StringBuffer();
		Field[] field = this.getClass().getDeclaredFields();
		String space = "";
		try{
			for(int i = 0; i < field.length; i++){
				String[] arr = null;
				arr = getField(field, i);
				if(arr != null){
					for(int j = 0; j < arr.length; j++) {
						ret.append(field[i].getName().concat(space).substring(0, 30).concat("= ") + arr[j] + "\n");
					}
				} else {
					ret.append(field[i].getName() + " =  null \n");
				}
			}
		} catch (Exception ex) {
			return null;
		}
		return ret.toString();
	}
	
	/**
	 * 필드에 있는 값을 스트링 배열로 반환.
	 * @param field
	 * @param i
	 * @return String[]
	 */
	private String[] getField(Field[] field, int i) {
		String[] arr = null;
		try{
			arr = (String[]) field[i].get(this);
		}catch(Exception ex){
			arr = null;
		}
		return arr;
	}

	/**
	* 포맷팅된 문자열에서 특수문자 제거("-","/",",",":")
	*/
	public void unDataFormat(){
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgKind = this.bkgKind .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesOfc = this.salesOfc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.emlProcStsCd = this.emlProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.salesRep = this.salesRep .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.faxProcStsCd = this.faxProcStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCd = this.custCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFromDt = this.bkgFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custTpCd = this.custTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStatus = this.bkgStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaff = this.bkgStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCntCd = this.custCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custSeq = this.custSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
