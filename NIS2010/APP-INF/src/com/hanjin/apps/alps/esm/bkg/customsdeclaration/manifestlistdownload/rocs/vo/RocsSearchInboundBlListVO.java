/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsSearchInboundBlListVO.java
*@FileTitle : RocsSearchInboundBlListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.10
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.10 임재택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

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
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsSearchInboundBlListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearchInboundBlListVO> models = new ArrayList<RocsSearchInboundBlListVO>();
	
	/* Column Info */
	private String frmCrnNumber = null;
	/* Column Info */
	private String demFreeDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String vvdNm = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cntrNoCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrMfDesc = null;
	/* Column Info */
	private String cntrWgtUtCd = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String ntfyAddr = null;
	/* Column Info */
	private String bkgTtlQty = null;
	/* Column Info */
	private String ibFileSeq = null;
	/* Column Info */
	private String pckDesc = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String maxBrbIfSeq = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String cntrTpszDesc = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgTtlQtyUtCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String vvdNumber = null;
	/* Column Info */
	private String podClptIndSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsSearchInboundBlListVO() {}

	public RocsSearchInboundBlListVO(String ibflag, String pagerows, String vvdNm, String vvdNumber, String frmCrnNumber, String cntrTpszDesc, String cntrNo, String cntrTpszCd, String cntrNoCd, String pckDesc, String cntrWgtUtCd, String blNo, String polCd, String podCd, String ntfyAddr, String bkgTtlQty, String bkgTtlQtyUtCd, String bkgNo, String cntrMfDesc, String ibFileSeq, String maxBrbIfSeq, String demFreeDt, String rcvTermCd, String deTermCd, String pckQty, String podClptIndSeq) {
		this.frmCrnNumber = frmCrnNumber;
		this.demFreeDt = demFreeDt;
		this.blNo = blNo;
		this.vvdNm = vvdNm;
		this.pagerows = pagerows;
		this.cntrNoCd = cntrNoCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cntrMfDesc = cntrMfDesc;
		this.cntrWgtUtCd = cntrWgtUtCd;
		this.cntrTpszCd = cntrTpszCd;
		this.pckQty = pckQty;
		this.rcvTermCd = rcvTermCd;
		this.ntfyAddr = ntfyAddr;
		this.bkgTtlQty = bkgTtlQty;
		this.ibFileSeq = ibFileSeq;
		this.pckDesc = pckDesc;
		this.podCd = podCd;
		this.maxBrbIfSeq = maxBrbIfSeq;
		this.deTermCd = deTermCd;
		this.cntrTpszDesc = cntrTpszDesc;
		this.bkgNo = bkgNo;
		this.bkgTtlQtyUtCd = bkgTtlQtyUtCd;
		this.cntrNo = cntrNo;
		this.vvdNumber = vvdNumber;
		this.podClptIndSeq = podClptIndSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_crn_number", getFrmCrnNumber());
		this.hashColumns.put("dem_free_dt", getDemFreeDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("vvd_nm", getVvdNm());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cntr_no_cd", getCntrNoCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_mf_desc", getCntrMfDesc());
		this.hashColumns.put("cntr_wgt_ut_cd", getCntrWgtUtCd());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("ntfy_addr", getNtfyAddr());
		this.hashColumns.put("bkg_ttl_qty", getBkgTtlQty());
		this.hashColumns.put("ib_file_seq", getIbFileSeq());
		this.hashColumns.put("pck_desc", getPckDesc());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("max_brb_if_seq", getMaxBrbIfSeq());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("cntr_tpsz_desc", getCntrTpszDesc());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_ttl_qty_ut_cd", getBkgTtlQtyUtCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("vvd_number", getVvdNumber());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_crn_number", "frmCrnNumber");
		this.hashFields.put("dem_free_dt", "demFreeDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("vvd_nm", "vvdNm");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cntr_no_cd", "cntrNoCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_mf_desc", "cntrMfDesc");
		this.hashFields.put("cntr_wgt_ut_cd", "cntrWgtUtCd");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("ntfy_addr", "ntfyAddr");
		this.hashFields.put("bkg_ttl_qty", "bkgTtlQty");
		this.hashFields.put("ib_file_seq", "ibFileSeq");
		this.hashFields.put("pck_desc", "pckDesc");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("max_brb_if_seq", "maxBrbIfSeq");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("cntr_tpsz_desc", "cntrTpszDesc");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_ttl_qty_ut_cd", "bkgTtlQtyUtCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("vvd_number", "vvdNumber");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frmCrnNumber
	 */
	public String getFrmCrnNumber() {
		return this.frmCrnNumber;
	}
	
	/**
	 * Column Info
	 * @return demFreeDt
	 */
	public String getDemFreeDt() {
		return this.demFreeDt;
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
	 * @return vvdNm
	 */
	public String getVvdNm() {
		return this.vvdNm;
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
	 * @return cntrNoCd
	 */
	public String getCntrNoCd() {
		return this.cntrNoCd;
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
	 * @return cntrMfDesc
	 */
	public String getCntrMfDesc() {
		return this.cntrMfDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrWgtUtCd
	 */
	public String getCntrWgtUtCd() {
		return this.cntrWgtUtCd;
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
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return ntfyAddr
	 */
	public String getNtfyAddr() {
		return this.ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @return bkgTtlQty
	 */
	public String getBkgTtlQty() {
		return this.bkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @return ibFileSeq
	 */
	public String getIbFileSeq() {
		return this.ibFileSeq;
	}
	
	/**
	 * Column Info
	 * @return pckDesc
	 */
	public String getPckDesc() {
		return this.pckDesc;
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
	 * @return maxBrbIfSeq
	 */
	public String getMaxBrbIfSeq() {
		return this.maxBrbIfSeq;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszDesc
	 */
	public String getCntrTpszDesc() {
		return this.cntrTpszDesc;
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
	 * @return bkgTtlQtyUtCd
	 */
	public String getBkgTtlQtyUtCd() {
		return this.bkgTtlQtyUtCd;
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
	 * @return vvdNumber
	 */
	public String getVvdNumber() {
		return this.vvdNumber;
	}
	
	/**
	 * Column Info
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
	}
	

	/**
	 * Column Info
	 * @param frmCrnNumber
	 */
	public void setFrmCrnNumber(String frmCrnNumber) {
		this.frmCrnNumber = frmCrnNumber;
	}
	
	/**
	 * Column Info
	 * @param demFreeDt
	 */
	public void setDemFreeDt(String demFreeDt) {
		this.demFreeDt = demFreeDt;
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
	 * @param vvdNm
	 */
	public void setVvdNm(String vvdNm) {
		this.vvdNm = vvdNm;
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
	 * @param cntrNoCd
	 */
	public void setCntrNoCd(String cntrNoCd) {
		this.cntrNoCd = cntrNoCd;
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
	 * @param cntrMfDesc
	 */
	public void setCntrMfDesc(String cntrMfDesc) {
		this.cntrMfDesc = cntrMfDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrWgtUtCd
	 */
	public void setCntrWgtUtCd(String cntrWgtUtCd) {
		this.cntrWgtUtCd = cntrWgtUtCd;
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
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param ntfyAddr
	 */
	public void setNtfyAddr(String ntfyAddr) {
		this.ntfyAddr = ntfyAddr;
	}
	
	/**
	 * Column Info
	 * @param bkgTtlQty
	 */
	public void setBkgTtlQty(String bkgTtlQty) {
		this.bkgTtlQty = bkgTtlQty;
	}
	
	/**
	 * Column Info
	 * @param ibFileSeq
	 */
	public void setIbFileSeq(String ibFileSeq) {
		this.ibFileSeq = ibFileSeq;
	}
	
	/**
	 * Column Info
	 * @param pckDesc
	 */
	public void setPckDesc(String pckDesc) {
		this.pckDesc = pckDesc;
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
	 * @param maxBrbIfSeq
	 */
	public void setMaxBrbIfSeq(String maxBrbIfSeq) {
		this.maxBrbIfSeq = maxBrbIfSeq;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszDesc
	 */
	public void setCntrTpszDesc(String cntrTpszDesc) {
		this.cntrTpszDesc = cntrTpszDesc;
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
	 * @param bkgTtlQtyUtCd
	 */
	public void setBkgTtlQtyUtCd(String bkgTtlQtyUtCd) {
		this.bkgTtlQtyUtCd = bkgTtlQtyUtCd;
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
	 * @param vvdNumber
	 */
	public void setVvdNumber(String vvdNumber) {
		this.vvdNumber = vvdNumber;
	}

	/**
	 * Column Info
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFrmCrnNumber(JSPUtil.getParameter(request, "frm_crn_number", ""));
		setDemFreeDt(JSPUtil.getParameter(request, "dem_free_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setVvdNm(JSPUtil.getParameter(request, "vvd_nm", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCntrNoCd(JSPUtil.getParameter(request, "cntr_no_cd", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setCntrMfDesc(JSPUtil.getParameter(request, "cntr_mf_desc", ""));
		setCntrWgtUtCd(JSPUtil.getParameter(request, "cntr_wgt_ut_cd", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, "cntr_tpsz_cd", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setRcvTermCd(JSPUtil.getParameter(request, "rcv_term_cd", ""));
		setNtfyAddr(JSPUtil.getParameter(request, "ntfy_addr", ""));
		setBkgTtlQty(JSPUtil.getParameter(request, "bkg_ttl_qty", ""));
		setIbFileSeq(JSPUtil.getParameter(request, "ib_file_seq", ""));
		setPckDesc(JSPUtil.getParameter(request, "pck_desc", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setMaxBrbIfSeq(JSPUtil.getParameter(request, "max_brb_if_seq", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setCntrTpszDesc(JSPUtil.getParameter(request, "cntr_tpsz_desc", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setBkgTtlQtyUtCd(JSPUtil.getParameter(request, "bkg_ttl_qty_ut_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setVvdNumber(JSPUtil.getParameter(request, "vvd_number", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, "pod_clpt_ind_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchInboundBlListVO[]
	 */
	public RocsSearchInboundBlListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchInboundBlListVO[]
	 */
	public RocsSearchInboundBlListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearchInboundBlListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmCrnNumber = (JSPUtil.getParameter(request, prefix	+ "frm_crn_number", length));
			String[] demFreeDt = (JSPUtil.getParameter(request, prefix	+ "dem_free_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] vvdNm = (JSPUtil.getParameter(request, prefix	+ "vvd_nm", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cntrNoCd = (JSPUtil.getParameter(request, prefix	+ "cntr_no_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrMfDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_desc", length));
			String[] cntrWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt_ut_cd", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] ntfyAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_addr", length));
			String[] bkgTtlQty = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_qty", length));
			String[] ibFileSeq = (JSPUtil.getParameter(request, prefix	+ "ib_file_seq", length));
			String[] pckDesc = (JSPUtil.getParameter(request, prefix	+ "pck_desc", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] maxBrbIfSeq = (JSPUtil.getParameter(request, prefix	+ "max_brb_if_seq", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] cntrTpszDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_desc", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgTtlQtyUtCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ttl_qty_ut_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearchInboundBlListVO();
				if (frmCrnNumber[i] != null)
					model.setFrmCrnNumber(frmCrnNumber[i]);
				if (demFreeDt[i] != null)
					model.setDemFreeDt(demFreeDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (vvdNm[i] != null)
					model.setVvdNm(vvdNm[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cntrNoCd[i] != null)
					model.setCntrNoCd(cntrNoCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrMfDesc[i] != null)
					model.setCntrMfDesc(cntrMfDesc[i]);
				if (cntrWgtUtCd[i] != null)
					model.setCntrWgtUtCd(cntrWgtUtCd[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (ntfyAddr[i] != null)
					model.setNtfyAddr(ntfyAddr[i]);
				if (bkgTtlQty[i] != null)
					model.setBkgTtlQty(bkgTtlQty[i]);
				if (ibFileSeq[i] != null)
					model.setIbFileSeq(ibFileSeq[i]);
				if (pckDesc[i] != null)
					model.setPckDesc(pckDesc[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (maxBrbIfSeq[i] != null)
					model.setMaxBrbIfSeq(maxBrbIfSeq[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (cntrTpszDesc[i] != null)
					model.setCntrTpszDesc(cntrTpszDesc[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgTtlQtyUtCd[i] != null)
					model.setBkgTtlQtyUtCd(bkgTtlQtyUtCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (vvdNumber[i] != null)
					model.setVvdNumber(vvdNumber[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearchInboundBlListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchInboundBlListVO[]
	 */
	public RocsSearchInboundBlListVO[] getRocsSearchInboundBlListVOs(){
		RocsSearchInboundBlListVO[] vos = (RocsSearchInboundBlListVO[])models.toArray(new RocsSearchInboundBlListVO[models.size()]);
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
		this.frmCrnNumber = this.frmCrnNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.demFreeDt = this.demFreeDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNm = this.vvdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNoCd = this.cntrNoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfDesc = this.cntrMfDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgtUtCd = this.cntrWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyAddr = this.ntfyAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlQty = this.bkgTtlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibFileSeq = this.ibFileSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckDesc = this.pckDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxBrbIfSeq = this.maxBrbIfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszDesc = this.cntrTpszDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgTtlQtyUtCd = this.bkgTtlQtyUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNumber = this.vvdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
