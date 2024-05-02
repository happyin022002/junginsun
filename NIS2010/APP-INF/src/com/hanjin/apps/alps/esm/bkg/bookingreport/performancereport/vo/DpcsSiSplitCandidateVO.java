/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : DpcsSiSplitCandidateVO.java
*@FileTitle : DpcsSiSplitCandidateVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.31
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2011.05.31 김기종 
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
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DpcsSiSplitCandidateVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DpcsSiSplitCandidateVO> models = new ArrayList<DpcsSiSplitCandidateVO>();
	
	/* Column Info */
	private String splitStsCd = null;
	/* Column Info */
	private String xterRmkAll = null;
	/* Column Info */
	private String netWgtUtCd = null;
	/* Column Info */
	private String searchType = null;
	/* Column Info */
	private String bkgValidFlg = null;
	/* Column Info */
	private String bkgUpldStsCd = null;
	/* Column Info */
	private String xterBkgRqstStsCd = null;
	/* Column Info */
	private String docTpCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String rqstDt = null;
	/* Column Info */
	private String xterSndrId = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String netWgt = null;
	/* Column Info */
	private String cntrCnt = null;
	/* Column Info */
	private String rqstDepDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrDesc = null;
	/* Column Info */
	private String ediHldFlg = null;
	/* Column Info */
	private String xterRmk = null;
	/* Column Info */
	private String xterRqstSeq = null;
	/* Column Info */
	private String xterRqstNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DpcsSiSplitCandidateVO() {}

	public DpcsSiSplitCandidateVO(String ibflag, String pagerows, String bkgNo, String docTpCd, String xterRqstNo, String splitStsCd, String xterBkgRqstStsCd, String bkgUpldStsCd, String xterRqstSeq, String rqstDt, String polCd, String rqstDepDt, String vvdCd, String ediHldFlg, String cntrCnt, String cntrDesc, String xterRmk, String xterRmkAll, String pckQty, String pckTpCd, String netWgt, String netWgtUtCd, String measQty, String measUtCd, String xterSndrId, String vpsEtdDt, String bkgValidFlg, String searchType) {
		this.splitStsCd = splitStsCd;
		this.xterRmkAll = xterRmkAll;
		this.netWgtUtCd = netWgtUtCd;
		this.searchType = searchType;
		this.bkgValidFlg = bkgValidFlg;
		this.bkgUpldStsCd = bkgUpldStsCd;
		this.xterBkgRqstStsCd = xterBkgRqstStsCd;
		this.docTpCd = docTpCd;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.vvdCd = vvdCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.rqstDt = rqstDt;
		this.xterSndrId = xterSndrId;
		this.vpsEtdDt = vpsEtdDt;
		this.netWgt = netWgt;
		this.cntrCnt = cntrCnt;
		this.rqstDepDt = rqstDepDt;
		this.bkgNo = bkgNo;
		this.cntrDesc = cntrDesc;
		this.ediHldFlg = ediHldFlg;
		this.xterRmk = xterRmk;
		this.xterRqstSeq = xterRqstSeq;
		this.xterRqstNo = xterRqstNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("split_sts_cd", getSplitStsCd());
		this.hashColumns.put("xter_rmk_all", getXterRmkAll());
		this.hashColumns.put("net_wgt_ut_cd", getNetWgtUtCd());
		this.hashColumns.put("search_type", getSearchType());
		this.hashColumns.put("bkg_valid_flg", getBkgValidFlg());
		this.hashColumns.put("bkg_upld_sts_cd", getBkgUpldStsCd());
		this.hashColumns.put("xter_bkg_rqst_sts_cd", getXterBkgRqstStsCd());
		this.hashColumns.put("doc_tp_cd", getDocTpCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("rqst_dt", getRqstDt());
		this.hashColumns.put("xter_sndr_id", getXterSndrId());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("net_wgt", getNetWgt());
		this.hashColumns.put("cntr_cnt", getCntrCnt());
		this.hashColumns.put("rqst_dep_dt", getRqstDepDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_desc", getCntrDesc());
		this.hashColumns.put("edi_hld_flg", getEdiHldFlg());
		this.hashColumns.put("xter_rmk", getXterRmk());
		this.hashColumns.put("xter_rqst_seq", getXterRqstSeq());
		this.hashColumns.put("xter_rqst_no", getXterRqstNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("split_sts_cd", "splitStsCd");
		this.hashFields.put("xter_rmk_all", "xterRmkAll");
		this.hashFields.put("net_wgt_ut_cd", "netWgtUtCd");
		this.hashFields.put("search_type", "searchType");
		this.hashFields.put("bkg_valid_flg", "bkgValidFlg");
		this.hashFields.put("bkg_upld_sts_cd", "bkgUpldStsCd");
		this.hashFields.put("xter_bkg_rqst_sts_cd", "xterBkgRqstStsCd");
		this.hashFields.put("doc_tp_cd", "docTpCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("rqst_dt", "rqstDt");
		this.hashFields.put("xter_sndr_id", "xterSndrId");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("net_wgt", "netWgt");
		this.hashFields.put("cntr_cnt", "cntrCnt");
		this.hashFields.put("rqst_dep_dt", "rqstDepDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_desc", "cntrDesc");
		this.hashFields.put("edi_hld_flg", "ediHldFlg");
		this.hashFields.put("xter_rmk", "xterRmk");
		this.hashFields.put("xter_rqst_seq", "xterRqstSeq");
		this.hashFields.put("xter_rqst_no", "xterRqstNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return splitStsCd
	 */
	public String getSplitStsCd() {
		return this.splitStsCd;
	}
	
	/**
	 * Column Info
	 * @return xterRmkAll
	 */
	public String getXterRmkAll() {
		return this.xterRmkAll;
	}
	
	/**
	 * Column Info
	 * @return netWgtUtCd
	 */
	public String getNetWgtUtCd() {
		return this.netWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return searchType
	 */
	public String getSearchType() {
		return this.searchType;
	}
	
	/**
	 * Column Info
	 * @return bkgValidFlg
	 */
	public String getBkgValidFlg() {
		return this.bkgValidFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgUpldStsCd
	 */
	public String getBkgUpldStsCd() {
		return this.bkgUpldStsCd;
	}
	
	/**
	 * Column Info
	 * @return xterBkgRqstStsCd
	 */
	public String getXterBkgRqstStsCd() {
		return this.xterBkgRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @return docTpCd
	 */
	public String getDocTpCd() {
		return this.docTpCd;
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
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return rqstDt
	 */
	public String getRqstDt() {
		return this.rqstDt;
	}
	
	/**
	 * Column Info
	 * @return xterSndrId
	 */
	public String getXterSndrId() {
		return this.xterSndrId;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return netWgt
	 */
	public String getNetWgt() {
		return this.netWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrCnt
	 */
	public String getCntrCnt() {
		return this.cntrCnt;
	}
	
	/**
	 * Column Info
	 * @return rqstDepDt
	 */
	public String getRqstDepDt() {
		return this.rqstDepDt;
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
	 * @return cntrDesc
	 */
	public String getCntrDesc() {
		return this.cntrDesc;
	}
	
	/**
	 * Column Info
	 * @return ediHldFlg
	 */
	public String getEdiHldFlg() {
		return this.ediHldFlg;
	}
	
	/**
	 * Column Info
	 * @return xterRmk
	 */
	public String getXterRmk() {
		return this.xterRmk;
	}
	
	/**
	 * Column Info
	 * @return xterRqstSeq
	 */
	public String getXterRqstSeq() {
		return this.xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @return xterRqstNo
	 */
	public String getXterRqstNo() {
		return this.xterRqstNo;
	}
	

	/**
	 * Column Info
	 * @param splitStsCd
	 */
	public void setSplitStsCd(String splitStsCd) {
		this.splitStsCd = splitStsCd;
	}
	
	/**
	 * Column Info
	 * @param xterRmkAll
	 */
	public void setXterRmkAll(String xterRmkAll) {
		this.xterRmkAll = xterRmkAll;
	}
	
	/**
	 * Column Info
	 * @param netWgtUtCd
	 */
	public void setNetWgtUtCd(String netWgtUtCd) {
		this.netWgtUtCd = netWgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param searchType
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	
	/**
	 * Column Info
	 * @param bkgValidFlg
	 */
	public void setBkgValidFlg(String bkgValidFlg) {
		this.bkgValidFlg = bkgValidFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgUpldStsCd
	 */
	public void setBkgUpldStsCd(String bkgUpldStsCd) {
		this.bkgUpldStsCd = bkgUpldStsCd;
	}
	
	/**
	 * Column Info
	 * @param xterBkgRqstStsCd
	 */
	public void setXterBkgRqstStsCd(String xterBkgRqstStsCd) {
		this.xterBkgRqstStsCd = xterBkgRqstStsCd;
	}
	
	/**
	 * Column Info
	 * @param docTpCd
	 */
	public void setDocTpCd(String docTpCd) {
		this.docTpCd = docTpCd;
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
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param rqstDt
	 */
	public void setRqstDt(String rqstDt) {
		this.rqstDt = rqstDt;
	}
	
	/**
	 * Column Info
	 * @param xterSndrId
	 */
	public void setXterSndrId(String xterSndrId) {
		this.xterSndrId = xterSndrId;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param netWgt
	 */
	public void setNetWgt(String netWgt) {
		this.netWgt = netWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrCnt
	 */
	public void setCntrCnt(String cntrCnt) {
		this.cntrCnt = cntrCnt;
	}
	
	/**
	 * Column Info
	 * @param rqstDepDt
	 */
	public void setRqstDepDt(String rqstDepDt) {
		this.rqstDepDt = rqstDepDt;
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
	 * @param cntrDesc
	 */
	public void setCntrDesc(String cntrDesc) {
		this.cntrDesc = cntrDesc;
	}
	
	/**
	 * Column Info
	 * @param ediHldFlg
	 */
	public void setEdiHldFlg(String ediHldFlg) {
		this.ediHldFlg = ediHldFlg;
	}
	
	/**
	 * Column Info
	 * @param xterRmk
	 */
	public void setXterRmk(String xterRmk) {
		this.xterRmk = xterRmk;
	}
	
	/**
	 * Column Info
	 * @param xterRqstSeq
	 */
	public void setXterRqstSeq(String xterRqstSeq) {
		this.xterRqstSeq = xterRqstSeq;
	}
	
	/**
	 * Column Info
	 * @param xterRqstNo
	 */
	public void setXterRqstNo(String xterRqstNo) {
		this.xterRqstNo = xterRqstNo;
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
		setSplitStsCd(JSPUtil.getParameter(request, prefix + "split_sts_cd", ""));
		setXterRmkAll(JSPUtil.getParameter(request, prefix + "xter_rmk_all", ""));
		setNetWgtUtCd(JSPUtil.getParameter(request, prefix + "net_wgt_ut_cd", ""));
		setSearchType(JSPUtil.getParameter(request, prefix + "search_type", ""));
		setBkgValidFlg(JSPUtil.getParameter(request, prefix + "bkg_valid_flg", ""));
		setBkgUpldStsCd(JSPUtil.getParameter(request, prefix + "bkg_upld_sts_cd", ""));
		setXterBkgRqstStsCd(JSPUtil.getParameter(request, prefix + "xter_bkg_rqst_sts_cd", ""));
		setDocTpCd(JSPUtil.getParameter(request, prefix + "doc_tp_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, prefix + "meas_ut_cd", ""));
		setRqstDt(JSPUtil.getParameter(request, prefix + "rqst_dt", ""));
		setXterSndrId(JSPUtil.getParameter(request, prefix + "xter_sndr_id", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setNetWgt(JSPUtil.getParameter(request, prefix + "net_wgt", ""));
		setCntrCnt(JSPUtil.getParameter(request, prefix + "cntr_cnt", ""));
		setRqstDepDt(JSPUtil.getParameter(request, prefix + "rqst_dep_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrDesc(JSPUtil.getParameter(request, prefix + "cntr_desc", ""));
		setEdiHldFlg(JSPUtil.getParameter(request, prefix + "edi_hld_flg", ""));
		setXterRmk(JSPUtil.getParameter(request, prefix + "xter_rmk", ""));
		setXterRqstSeq(JSPUtil.getParameter(request, prefix + "xter_rqst_seq", ""));
		setXterRqstNo(JSPUtil.getParameter(request, prefix + "xter_rqst_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DpcsSiSplitCandidateVO[]
	 */
	public DpcsSiSplitCandidateVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DpcsSiSplitCandidateVO[]
	 */
	public DpcsSiSplitCandidateVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DpcsSiSplitCandidateVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] splitStsCd = (JSPUtil.getParameter(request, prefix	+ "split_sts_cd", length));
			String[] xterRmkAll = (JSPUtil.getParameter(request, prefix	+ "xter_rmk_all", length));
			String[] netWgtUtCd = (JSPUtil.getParameter(request, prefix	+ "net_wgt_ut_cd", length));
			String[] searchType = (JSPUtil.getParameter(request, prefix	+ "search_type", length));
			String[] bkgValidFlg = (JSPUtil.getParameter(request, prefix	+ "bkg_valid_flg", length));
			String[] bkgUpldStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_upld_sts_cd", length));
			String[] xterBkgRqstStsCd = (JSPUtil.getParameter(request, prefix	+ "xter_bkg_rqst_sts_cd", length));
			String[] docTpCd = (JSPUtil.getParameter(request, prefix	+ "doc_tp_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] rqstDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dt", length));
			String[] xterSndrId = (JSPUtil.getParameter(request, prefix	+ "xter_sndr_id", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] netWgt = (JSPUtil.getParameter(request, prefix	+ "net_wgt", length));
			String[] cntrCnt = (JSPUtil.getParameter(request, prefix	+ "cntr_cnt", length));
			String[] rqstDepDt = (JSPUtil.getParameter(request, prefix	+ "rqst_dep_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_desc", length));
			String[] ediHldFlg = (JSPUtil.getParameter(request, prefix	+ "edi_hld_flg", length));
			String[] xterRmk = (JSPUtil.getParameter(request, prefix	+ "xter_rmk", length));
			String[] xterRqstSeq = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_seq", length));
			String[] xterRqstNo = (JSPUtil.getParameter(request, prefix	+ "xter_rqst_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DpcsSiSplitCandidateVO();
				if (splitStsCd[i] != null)
					model.setSplitStsCd(splitStsCd[i]);
				if (xterRmkAll[i] != null)
					model.setXterRmkAll(xterRmkAll[i]);
				if (netWgtUtCd[i] != null)
					model.setNetWgtUtCd(netWgtUtCd[i]);
				if (searchType[i] != null)
					model.setSearchType(searchType[i]);
				if (bkgValidFlg[i] != null)
					model.setBkgValidFlg(bkgValidFlg[i]);
				if (bkgUpldStsCd[i] != null)
					model.setBkgUpldStsCd(bkgUpldStsCd[i]);
				if (xterBkgRqstStsCd[i] != null)
					model.setXterBkgRqstStsCd(xterBkgRqstStsCd[i]);
				if (docTpCd[i] != null)
					model.setDocTpCd(docTpCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (rqstDt[i] != null)
					model.setRqstDt(rqstDt[i]);
				if (xterSndrId[i] != null)
					model.setXterSndrId(xterSndrId[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (netWgt[i] != null)
					model.setNetWgt(netWgt[i]);
				if (cntrCnt[i] != null)
					model.setCntrCnt(cntrCnt[i]);
				if (rqstDepDt[i] != null)
					model.setRqstDepDt(rqstDepDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrDesc[i] != null)
					model.setCntrDesc(cntrDesc[i]);
				if (ediHldFlg[i] != null)
					model.setEdiHldFlg(ediHldFlg[i]);
				if (xterRmk[i] != null)
					model.setXterRmk(xterRmk[i]);
				if (xterRqstSeq[i] != null)
					model.setXterRqstSeq(xterRqstSeq[i]);
				if (xterRqstNo[i] != null)
					model.setXterRqstNo(xterRqstNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDpcsSiSplitCandidateVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DpcsSiSplitCandidateVO[]
	 */
	public DpcsSiSplitCandidateVO[] getDpcsSiSplitCandidateVOs(){
		DpcsSiSplitCandidateVO[] vos = (DpcsSiSplitCandidateVO[])models.toArray(new DpcsSiSplitCandidateVO[models.size()]);
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
		this.splitStsCd = this.splitStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmkAll = this.xterRmkAll .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgtUtCd = this.netWgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.searchType = this.searchType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgValidFlg = this.bkgValidFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgUpldStsCd = this.bkgUpldStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterBkgRqstStsCd = this.xterBkgRqstStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docTpCd = this.docTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDt = this.rqstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterSndrId = this.xterSndrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.netWgt = this.netWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrCnt = this.cntrCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstDepDt = this.rqstDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrDesc = this.cntrDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ediHldFlg = this.ediHldFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRmk = this.xterRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstSeq = this.xterRqstSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.xterRqstNo = this.xterRqstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
