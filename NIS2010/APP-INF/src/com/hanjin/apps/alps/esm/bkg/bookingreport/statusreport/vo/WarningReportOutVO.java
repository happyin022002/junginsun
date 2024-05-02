/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : WarningReportOutVO.java
*@FileTitle : WarningReportOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 
*@LastVersion : 1.0
* 2016.04.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport.vo;

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

public class WarningReportOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<WarningReportOutVO> models = new ArrayList<WarningReportOutVO>();
	
	/* Column Info */
	private String cstmsDescKwNm = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String interXterRmkKwNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String rowsPerPage = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cneeSeq = null;
	/* Column Info */
	private String currPage = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String ctrtOfcCd = null;
	/* Column Info */
	private String opCntrQty = null;
	/* Column Info */
	private String obSlsOfcCd = null;
	/* Column Info */
	private String shprSeq = null;
	/* Column Info */
	private String fwrdSeq = null;
	/* Column Info */
	private String cmdtDescKwNm = null;
	/* Column Info */
	private String custDescKwNm = null;
	/* Column Info */
	private String cntrMfGdsDescKwNm = null;
 
	/* Column Info */
	private String shipper   = null;
	private String consignee = null;
	private String ffdr      = null;
	private String shprName  = null;
	private String cneeName  = null;
	private String ffdrName  = null;

	
	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public WarningReportOutVO() {}

	public WarningReportOutVO(String ibflag, String pagerows, String bkgNo, String blNo, String obSlsOfcCd, String ctrtOfcCd, String opCntrQty, String interXterRmkKwNm, String shprSeq, String fwrdSeq, String cneeSeq, String porCd, String polCd, String podCd, String delCd, String cmdtCd, String cstmsDescKwNm, String cmdtDescKwNm, String rowsPerPage, String currPage, String  shipper, String consignee ,String ffdr ,String shprName  ,String cneeName  ,String ffdrName, String custDescKwNm, String cntrMfGdsDescKwNm) {
		this.cstmsDescKwNm = cstmsDescKwNm;
		this.porCd = porCd;
		this.interXterRmkKwNm = interXterRmkKwNm;
		this.delCd = delCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.rowsPerPage = rowsPerPage;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.cneeSeq = cneeSeq;
		this.currPage = currPage;
		this.cmdtCd = cmdtCd;
		this.ctrtOfcCd = ctrtOfcCd;
		this.opCntrQty = opCntrQty;
		this.obSlsOfcCd = obSlsOfcCd;
		this.shprSeq = shprSeq;
		this.fwrdSeq = fwrdSeq;
		this.cmdtDescKwNm = cmdtDescKwNm;
		
		this.shipper   = shipper  ;
		this.consignee = consignee;
		this.ffdr      = ffdr     ;
		this.shprName  = shprName ;
		this.cneeName  = cneeName ;
		this.ffdrName  = ffdrName ;
		this.custDescKwNm  = custDescKwNm ;
		this.cntrMfGdsDescKwNm  = cntrMfGdsDescKwNm ;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cstms_desc_kw_nm", getCstmsDescKwNm());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("inter_xter_rmk_kw_nm", getInterXterRmkKwNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("rows_per_page", getRowsPerPage());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cnee_seq", getCneeSeq());
		this.hashColumns.put("curr_page", getCurrPage());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("ctrt_ofc_cd", getCtrtOfcCd());
		this.hashColumns.put("op_cntr_qty", getOpCntrQty());
		this.hashColumns.put("ob_sls_ofc_cd", getObSlsOfcCd());
		this.hashColumns.put("shpr_seq", getShprSeq());
		this.hashColumns.put("fwrd_seq", getFwrdSeq());
		this.hashColumns.put("cmdt_desc_kw_nm", getCmdtDescKwNm());
		
		this.hashColumns.put("shipper", getShipper  ());
		this.hashColumns.put("consignee", getConsignee());
		this.hashColumns.put("ffdr", getFfdr     ());
		this.hashColumns.put("shpr_name", getShprName());
		this.hashColumns.put("cnee_name", getCneeName());
		this.hashColumns.put("ffdr_name", getFfdrName());
		this.hashColumns.put("cust_desc_kw_nm", getCustDescKwNm());
		this.hashColumns.put("cntr_mf_gds_desc_kw_nm", getCntrMfGdsDescKwNm());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cstms_desc_kw_nm", "cstmsDescKwNm");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("inter_xter_rmk_kw_nm", "interXterRmkKwNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("rows_per_page", "rowsPerPage");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cnee_seq", "cneeSeq");
		this.hashFields.put("curr_page", "currPage");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("ctrt_ofc_cd", "ctrtOfcCd");
		this.hashFields.put("op_cntr_qty", "opCntrQty");
		this.hashFields.put("ob_sls_ofc_cd", "obSlsOfcCd");
		this.hashFields.put("shpr_seq", "shprSeq");
		this.hashFields.put("fwrd_seq", "fwrdSeq");
		this.hashFields.put("cmdt_desc_kw_nm", "cmdtDescKwNm");
		
		this.hashFields.put("shipper"  , "shipper"  );
		this.hashFields.put("consignee", "consignee");
		this.hashFields.put("ffdr"     , "ffdr"     );
		this.hashFields.put("shpr_name", "shprName");
		this.hashFields.put("cnee_name", "cneeName");
		this.hashFields.put("ffdr_name", "ffdrName");
		this.hashFields.put("cust_desc_kw_nm", "custDescKwNm");
		this.hashFields.put("cntr_mf_gds_desc_kw_nm", "cntrMfGdsDescKwNm");
		
		
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return cstmsDescKwNm
	 */
	public String getCstmsDescKwNm() {
		return this.cstmsDescKwNm;
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
	 * @return interXterRmkKwNm
	 */
	public String getInterXterRmkKwNm() {
		return this.interXterRmkKwNm;
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
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
	}
	
	/**
	 * Column Info
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
	 * @return rowsPerPage
	 */
	public String getRowsPerPage() {
		return this.rowsPerPage;
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
	 * @return cneeSeq
	 */
	public String getCneeSeq() {
		return this.cneeSeq;
	}
	
	/**
	 * Column Info
	 * @return currPage
	 */
	public String getCurrPage() {
		return this.currPage;
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
	 * @return ctrtOfcCd
	 */
	public String getCtrtOfcCd() {
		return this.ctrtOfcCd;
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
	 * @return obSlsOfcCd
	 */
	public String getObSlsOfcCd() {
		return this.obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @return shprSeq
	 */
	public String getShprSeq() {
		return this.shprSeq;
	}
	
	/**
	 * Column Info
	 * @return fwrdSeq
	 */
	public String getFwrdSeq() {
		return this.fwrdSeq;
	}
	
	/**
	 * Column Info
	 * @return cmdtDescKwNm
	 */
	public String getCmdtDescKwNm() {
		return this.cmdtDescKwNm;
	}
	

	/**
	 * Column Info
	 * @param cstmsDescKwNm
	 */
	public void setCstmsDescKwNm(String cstmsDescKwNm) {
		this.cstmsDescKwNm = cstmsDescKwNm;
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
	 * @param interXterRmkKwNm
	 */
	public void setInterXterRmkKwNm(String interXterRmkKwNm) {
		this.interXterRmkKwNm = interXterRmkKwNm;
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
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
	}
	
	/**
	 * Column Info
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
	 * @param rowsPerPage
	 */
	public void setRowsPerPage(String rowsPerPage) {
		this.rowsPerPage = rowsPerPage;
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
	 * @param cneeSeq
	 */
	public void setCneeSeq(String cneeSeq) {
		this.cneeSeq = cneeSeq;
	}
	
	/**
	 * Column Info
	 * @param currPage
	 */
	public void setCurrPage(String currPage) {
		this.currPage = currPage;
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
	 * @param ctrtOfcCd
	 */
	public void setCtrtOfcCd(String ctrtOfcCd) {
		this.ctrtOfcCd = ctrtOfcCd;
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
	 * @param obSlsOfcCd
	 */
	public void setObSlsOfcCd(String obSlsOfcCd) {
		this.obSlsOfcCd = obSlsOfcCd;
	}
	
	/**
	 * Column Info
	 * @param shprSeq
	 */
	public void setShprSeq(String shprSeq) {
		this.shprSeq = shprSeq;
	}
	
	/**
	 * Column Info
	 * @param fwrdSeq
	 */
	public void setFwrdSeq(String fwrdSeq) {
		this.fwrdSeq = fwrdSeq;
	}
	
	/**
	 * Column Info
	 * @param cmdtDescKwNm
	 */
	public void setCmdtDescKwNm(String cmdtDescKwNm) {
		this.cmdtDescKwNm = cmdtDescKwNm;
	}
	
public String getShipper() {
		return shipper;
	}

	public void setShipper(String shipper) {
		this.shipper = shipper;
	}

	public String getConsignee() {
		return consignee;
	}

	public void setConsignee(String consignee) {
		this.consignee = consignee;
	}

	public String getFfdr() {
		return ffdr;
	}

	public void setFfdr(String ffdr) {
		this.ffdr = ffdr;
	}

	public String getShprName() {
		return shprName;
	}

	public void setShprName(String shprName) {
		this.shprName = shprName;
	}

	public String getCneeName() {
		return cneeName;
	}

	public void setCneeName(String cneeName) {
		this.cneeName = cneeName;
	}

	public String getFfdrName() {
		return ffdrName;
	}

	public void setFfdrName(String ffdrName) {
		this.ffdrName = ffdrName;
	}

public String getCustDescKwNm() {
		return custDescKwNm;
	}

	public void setCustDescKwNm(String custDescKwNm) {
		this.custDescKwNm = custDescKwNm;
	}

public String getCntrMfGdsDescKwNm() {
		return cntrMfGdsDescKwNm;
	}

	public void setCntrMfGdsDescKwNm(String cntrMfGdsDescKwNm) {
		this.cntrMfGdsDescKwNm = cntrMfGdsDescKwNm;
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
		setCstmsDescKwNm(JSPUtil.getParameter(request, prefix + "cstms_desc_kw_nm", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setInterXterRmkKwNm(JSPUtil.getParameter(request, prefix + "inter_xter_rmk_kw_nm", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setRowsPerPage(JSPUtil.getParameter(request, prefix + "rows_per_page", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCneeSeq(JSPUtil.getParameter(request, prefix + "cnee_seq", ""));
		setCurrPage(JSPUtil.getParameter(request, prefix + "curr_page", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCtrtOfcCd(JSPUtil.getParameter(request, prefix + "ctrt_ofc_cd", ""));
		setOpCntrQty(JSPUtil.getParameter(request, prefix + "op_cntr_qty", ""));
		setObSlsOfcCd(JSPUtil.getParameter(request, prefix + "ob_sls_ofc_cd", ""));
		setShprSeq(JSPUtil.getParameter(request, prefix + "shpr_seq", ""));
		setFwrdSeq(JSPUtil.getParameter(request, prefix + "fwrd_seq", ""));
		setCmdtDescKwNm(JSPUtil.getParameter(request, prefix + "cmdt_desc_kw_nm", ""));
		
		setShipper  (JSPUtil.getParameter(request, prefix + "shipper"  , ""));
		setConsignee(JSPUtil.getParameter(request, prefix + "consignee", ""));
		setFfdr     (JSPUtil.getParameter(request, prefix + "ffdr"     , ""));
		setShprName (JSPUtil.getParameter(request, prefix + "shpr_name", ""));
		setCneeName (JSPUtil.getParameter(request, prefix + "cnee_name", ""));
		setFfdrName (JSPUtil.getParameter(request, prefix + "ffdr_name", ""));
		setCustDescKwNm (JSPUtil.getParameter(request, prefix + "cust_desc_kw_nm", ""));
		setCntrMfGdsDescKwNm (JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc_kw_nm", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return WarningReportOutVO[]
	 */
	public WarningReportOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return WarningReportOutVO[]
	 */
	public WarningReportOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		WarningReportOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cstmsDescKwNm = (JSPUtil.getParameter(request, prefix	+ "cstms_desc_kw_nm", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] interXterRmkKwNm = (JSPUtil.getParameter(request, prefix	+ "inter_xter_rmk_kw_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] rowsPerPage = (JSPUtil.getParameter(request, prefix	+ "rows_per_page", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cneeSeq = (JSPUtil.getParameter(request, prefix	+ "cnee_seq", length));
			String[] currPage = (JSPUtil.getParameter(request, prefix	+ "curr_page", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] ctrtOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrt_ofc_cd", length));
			String[] opCntrQty = (JSPUtil.getParameter(request, prefix	+ "op_cntr_qty", length));
			String[] obSlsOfcCd = (JSPUtil.getParameter(request, prefix	+ "ob_sls_ofc_cd", length));
			String[] shprSeq = (JSPUtil.getParameter(request, prefix	+ "shpr_seq", length));
			String[] fwrdSeq = (JSPUtil.getParameter(request, prefix	+ "fwrd_seq", length));
			String[] cmdtDescKwNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc_kw_nm", length));

			String[] shipper   = (JSPUtil.getParameter(request, prefix	+ "shipper"  , length));
			String[] consignee = (JSPUtil.getParameter(request, prefix	+ "consignee", length));
			String[] ffdr      = (JSPUtil.getParameter(request, prefix	+ "ffdr"     , length));
			String[] shprName  = (JSPUtil.getParameter(request, prefix	+ "shpr_name", length));
			String[] cneeName  = (JSPUtil.getParameter(request, prefix	+ "cnee_name", length));
			String[] ffdrName  = (JSPUtil.getParameter(request, prefix	+ "ffdr_name", length));
			String[] custDescKwNm  = (JSPUtil.getParameter(request, prefix	+ "cust_desc_kw_nm", length));
			String[] cntrMfGdsDescKwNm  = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc_kw_nm", length));
			
			for (int i = 0; i < length; i++) {
				model = new WarningReportOutVO();
				if (cstmsDescKwNm[i] != null)
					model.setCstmsDescKwNm(cstmsDescKwNm[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (interXterRmkKwNm[i] != null)
					model.setInterXterRmkKwNm(interXterRmkKwNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (rowsPerPage[i] != null)
					model.setRowsPerPage(rowsPerPage[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cneeSeq[i] != null)
					model.setCneeSeq(cneeSeq[i]);
				if (currPage[i] != null)
					model.setCurrPage(currPage[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (ctrtOfcCd[i] != null)
					model.setCtrtOfcCd(ctrtOfcCd[i]);
				if (opCntrQty[i] != null)
					model.setOpCntrQty(opCntrQty[i]);
				if (obSlsOfcCd[i] != null)
					model.setObSlsOfcCd(obSlsOfcCd[i]);
				if (shprSeq[i] != null)
					model.setShprSeq(shprSeq[i]);
				if (fwrdSeq[i] != null)
					model.setFwrdSeq(fwrdSeq[i]);
				if (cmdtDescKwNm[i] != null)
					model.setCmdtDescKwNm(cmdtDescKwNm[i]);
				if (cntrMfGdsDescKwNm[i] != null)
					model.setCntrMfGdsDescKwNm(cntrMfGdsDescKwNm[i]);
				
				if (shipper  [i] != null) model.setShipper  (shipper  [i]);
				if (consignee[i] != null) model.setConsignee(consignee[i]);
				if (ffdr     [i] != null) model.setFfdr     (ffdr     [i]);
				if (shprName [i] != null) model.setShprName (shprName [i]);
				if (cneeName [i] != null) model.setCneeName (cneeName [i]);
				if (ffdrName [i] != null) model.setFfdrName (ffdrName [i]);
				if (custDescKwNm [i] != null) model.setCustDescKwNm (custDescKwNm [i]);
				if (cntrMfGdsDescKwNm [i] != null) model.setCntrMfGdsDescKwNm (cntrMfGdsDescKwNm [i]);
				     
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getWarningReportOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return WarningReportOutVO[]
	 */
	public WarningReportOutVO[] getWarningReportOutVOs(){
		WarningReportOutVO[] vos = (WarningReportOutVO[])models.toArray(new WarningReportOutVO[models.size()]);
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
		this.cstmsDescKwNm = this.cstmsDescKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.interXterRmkKwNm = this.interXterRmkKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rowsPerPage = this.rowsPerPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeSeq = this.cneeSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currPage = this.currPage .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrtOfcCd = this.ctrtOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.opCntrQty = this.opCntrQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSlsOfcCd = this.obSlsOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprSeq = this.shprSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwrdSeq = this.fwrdSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDescKwNm = this.cmdtDescKwNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.shipper   = this.shipper   .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.consignee = this.consignee .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffdr      = this.ffdr      .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprName  = this.shprName  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeName  = this.cneeName  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ffdrName  = this.ffdrName  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custDescKwNm  = this.custDescKwNm  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDescKwNm  = this.cntrMfGdsDescKwNm  .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
