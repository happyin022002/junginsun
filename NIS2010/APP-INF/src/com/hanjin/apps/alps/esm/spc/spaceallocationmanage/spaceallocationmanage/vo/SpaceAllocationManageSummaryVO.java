/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : SpaceAllocationManageSummaryVO.java
*@FileTitle : SpaceAllocationManageSummaryVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.03.12
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2013.03.12 진마리아 
* 1.0 Creation
* 2013.03.12 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진 
=========================================================*/

package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo;

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
 * @author 진마리아
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpaceAllocationManageSummaryVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpaceAllocationManageSummaryVO> models = new ArrayList<SpaceAllocationManageSummaryVO>();
	
	/* Column Info */
	private String accumMdl = null;
	/* Column Info */
	private String bkgRto = null;
	/* Column Info */
	private String trdCd = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String custCtrlCd = null;
	/* Column Info */
	private String destLocCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String alocRto = null;
	/* Column Info */
	private String accumBkg = null;
	/* Column Info */
	private String accumDiff = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String alocDiff = null;
	/* Column Info */
	private String alocQty = null;
	/* Column Info */
	private String bkgQty = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String mdlRto = null;
	/* Column Info */
	private String fcastRtoDiff = null;
	/* Column Info */
	private String fcastRto = null;
	/* Column Info */
	private String alocRtoDiff = null;
	/* Column Info */
	private String mdlQty = null;
	/* Column Info */
	private String fcastQty = null;
	/* Column Info */
	private String bkgRtoDiff = null;
	/* Column Info */
	private String accumRto = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String bkgDiff = null;
	/* Column Info */
	private String fcastDiff = null;
	/* Column Info */
	private String bsa = null;
	/* Column Info */
	private String slsRgnOfcCd = null;
	/* Column Info */
	private String subTrdCd = null;
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpaceAllocationManageSummaryVO() {}

	public SpaceAllocationManageSummaryVO(String ibflag, String pagerows, String slsRgnOfcCd, String trdCd, String subTrdCd, String rlaneCd, String dirCd, 
			String vvd, String custCtrlCd, String mdlQty, String mdlRto, String fcastQty, String fcastDiff, String fcastRto, String fcastRtoDiff, 
			String alocQty, String alocDiff, String alocRto, String alocRtoDiff, String bkgQty, String bkgDiff, String bkgRto, String bkgRtoDiff, 
			String accumMdl, String accumBkg, String accumDiff, String accumRto, String bsa, String destLocCd, String vslCd, String skdVoyNo, String skdDirCd) {
		this.accumMdl = accumMdl;
		this.bkgRto = bkgRto;
		this.trdCd = trdCd;
		this.rlaneCd = rlaneCd;
		this.custCtrlCd = custCtrlCd;
		this.destLocCd = destLocCd;
		this.pagerows = pagerows;
		this.alocRto = alocRto;
		this.accumBkg = accumBkg;
		this.accumDiff = accumDiff;
		this.ibflag = ibflag;
		this.alocDiff = alocDiff;
		this.alocQty = alocQty;
		this.bkgQty = bkgQty;
		this.dirCd = dirCd;
		this.mdlRto = mdlRto;
		this.fcastRtoDiff = fcastRtoDiff;
		this.fcastRto = fcastRto;
		this.alocRtoDiff = alocRtoDiff;
		this.mdlQty = mdlQty;
		this.fcastQty = fcastQty;
		this.bkgRtoDiff = bkgRtoDiff;
		this.accumRto = accumRto;
		this.vvd = vvd;
		this.bkgDiff = bkgDiff;
		this.fcastDiff = fcastDiff;
		this.bsa = bsa;
		this.slsRgnOfcCd = slsRgnOfcCd;
		this.subTrdCd = subTrdCd;
		
		this.vslCd = vslCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("accum_mdl", getAccumMdl());
		this.hashColumns.put("bkg_rto", getBkgRto());
		this.hashColumns.put("trd_cd", getTrdCd());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("cust_ctrl_cd", getCustCtrlCd());
		this.hashColumns.put("dest_loc_cd", getDestLocCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("aloc_rto", getAlocRto());
		this.hashColumns.put("accum_bkg", getAccumBkg());
		this.hashColumns.put("accum_diff", getAccumDiff());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("aloc_diff", getAlocDiff());
		this.hashColumns.put("aloc_qty", getAlocQty());
		this.hashColumns.put("bkg_qty", getBkgQty());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("mdl_rto", getMdlRto());
		this.hashColumns.put("fcast_rto_diff", getFcastRtoDiff());
		this.hashColumns.put("fcast_rto", getFcastRto());
		this.hashColumns.put("aloc_rto_diff", getAlocRtoDiff());
		this.hashColumns.put("mdl_qty", getMdlQty());
		this.hashColumns.put("fcast_qty", getFcastQty());
		this.hashColumns.put("bkg_rto_diff", getBkgRtoDiff());
		this.hashColumns.put("accum_rto", getAccumRto());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("bkg_diff", getBkgDiff());
		this.hashColumns.put("fcast_diff", getFcastDiff());
		this.hashColumns.put("bsa", getBsa());
		this.hashColumns.put("sls_rgn_ofc_cd", getSlsRgnOfcCd());
		this.hashColumns.put("sub_trd_cd", getSubTrdCd());
		
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("accum_mdl", "accumMdl");
		this.hashFields.put("bkg_rto", "bkgRto");
		this.hashFields.put("trd_cd", "trdCd");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("cust_ctrl_cd", "custCtrlCd");
		this.hashFields.put("dest_loc_cd", "destLocCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("aloc_rto", "alocRto");
		this.hashFields.put("accum_bkg", "accumBkg");
		this.hashFields.put("accum_diff", "accumDiff");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("aloc_diff", "alocDiff");
		this.hashFields.put("aloc_qty", "alocQty");
		this.hashFields.put("bkg_qty", "bkgQty");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("mdl_rto", "mdlRto");
		this.hashFields.put("fcast_rto_diff", "fcastRtoDiff");
		this.hashFields.put("fcast_rto", "fcastRto");
		this.hashFields.put("aloc_rto_diff", "alocRtoDiff");
		this.hashFields.put("mdl_qty", "mdlQty");
		this.hashFields.put("fcast_qty", "fcastQty");
		this.hashFields.put("bkg_rto_diff", "bkgRtoDiff");
		this.hashFields.put("accum_rto", "accumRto");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("bkg_diff", "bkgDiff");
		this.hashFields.put("fcast_diff", "fcastDiff");
		this.hashFields.put("bsa", "bsa");
		this.hashFields.put("sls_rgn_ofc_cd", "slsRgnOfcCd");
		this.hashFields.put("sub_trd_cd", "subTrdCd");
		
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return accumMdl
	 */
	public String getAccumMdl() {
		return this.accumMdl;
	}
	
	/**
	 * Column Info
	 * @return bkgRto
	 */
	public String getBkgRto() {
		return this.bkgRto;
	}
	
	/**
	 * Column Info
	 * @return trdCd
	 */
	public String getTrdCd() {
		return this.trdCd;
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
	 * @return custCtrlCd
	 */
	public String getCustCtrlCd() {
		return this.custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @return destLocCd
	 */
	public String getDestLocCd() {
		return this.destLocCd;
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
	 * @return alocRto
	 */
	public String getAlocRto() {
		return this.alocRto;
	}
	
	/**
	 * Column Info
	 * @return accumBkg
	 */
	public String getAccumBkg() {
		return this.accumBkg;
	}
	
	/**
	 * Column Info
	 * @return accumDiff
	 */
	public String getAccumDiff() {
		return this.accumDiff;
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
	 * @return alocDiff
	 */
	public String getAlocDiff() {
		return this.alocDiff;
	}
	
	/**
	 * Column Info
	 * @return alocQty
	 */
	public String getAlocQty() {
		return this.alocQty;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return mdlRto
	 */
	public String getMdlRto() {
		return this.mdlRto;
	}
	
	/**
	 * Column Info
	 * @return fcastRtoDiff
	 */
	public String getFcastRtoDiff() {
		return this.fcastRtoDiff;
	}
	
	/**
	 * Column Info
	 * @return fcastRto
	 */
	public String getFcastRto() {
		return this.fcastRto;
	}
	
	/**
	 * Column Info
	 * @return alocRtoDiff
	 */
	public String getAlocRtoDiff() {
		return this.alocRtoDiff;
	}
	
	/**
	 * Column Info
	 * @return mdlQty
	 */
	public String getMdlQty() {
		return this.mdlQty;
	}
	
	/**
	 * Column Info
	 * @return fcastQty
	 */
	public String getFcastQty() {
		return this.fcastQty;
	}
	
	/**
	 * Column Info
	 * @return bkgRtoDiff
	 */
	public String getBkgRtoDiff() {
		return this.bkgRtoDiff;
	}
	
	/**
	 * Column Info
	 * @return accumRto
	 */
	public String getAccumRto() {
		return this.accumRto;
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
	 * @return bkgDiff
	 */
	public String getBkgDiff() {
		return this.bkgDiff;
	}
	
	/**
	 * Column Info
	 * @return fcastDiff
	 */
	public String getFcastDiff() {
		return this.fcastDiff;
	}
	
	/**
	 * Column Info
	 * @return bsa
	 */
	public String getBsa() {
		return this.bsa;
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
	 * @return subTrdCd
	 */
	public String getSubTrdCd() {
		return this.subTrdCd;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
	}
	

	/**
	 * Column Info
	 * @param accumMdl
	 */
	public void setAccumMdl(String accumMdl) {
		this.accumMdl = accumMdl;
	}
	
	/**
	 * Column Info
	 * @param bkgRto
	 */
	public void setBkgRto(String bkgRto) {
		this.bkgRto = bkgRto;
	}
	
	/**
	 * Column Info
	 * @param trdCd
	 */
	public void setTrdCd(String trdCd) {
		this.trdCd = trdCd;
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
	 * @param custCtrlCd
	 */
	public void setCustCtrlCd(String custCtrlCd) {
		this.custCtrlCd = custCtrlCd;
	}
	
	/**
	 * Column Info
	 * @param destLocCd
	 */
	public void setDestLocCd(String destLocCd) {
		this.destLocCd = destLocCd;
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
	 * @param alocRto
	 */
	public void setAlocRto(String alocRto) {
		this.alocRto = alocRto;
	}
	
	/**
	 * Column Info
	 * @param accumBkg
	 */
	public void setAccumBkg(String accumBkg) {
		this.accumBkg = accumBkg;
	}
	
	/**
	 * Column Info
	 * @param accumDiff
	 */
	public void setAccumDiff(String accumDiff) {
		this.accumDiff = accumDiff;
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
	 * @param alocDiff
	 */
	public void setAlocDiff(String alocDiff) {
		this.alocDiff = alocDiff;
	}
	
	/**
	 * Column Info
	 * @param alocQty
	 */
	public void setAlocQty(String alocQty) {
		this.alocQty = alocQty;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param mdlRto
	 */
	public void setMdlRto(String mdlRto) {
		this.mdlRto = mdlRto;
	}
	
	/**
	 * Column Info
	 * @param fcastRtoDiff
	 */
	public void setFcastRtoDiff(String fcastRtoDiff) {
		this.fcastRtoDiff = fcastRtoDiff;
	}
	
	/**
	 * Column Info
	 * @param fcastRto
	 */
	public void setFcastRto(String fcastRto) {
		this.fcastRto = fcastRto;
	}
	
	/**
	 * Column Info
	 * @param alocRtoDiff
	 */
	public void setAlocRtoDiff(String alocRtoDiff) {
		this.alocRtoDiff = alocRtoDiff;
	}
	
	/**
	 * Column Info
	 * @param mdlQty
	 */
	public void setMdlQty(String mdlQty) {
		this.mdlQty = mdlQty;
	}
	
	/**
	 * Column Info
	 * @param fcastQty
	 */
	public void setFcastQty(String fcastQty) {
		this.fcastQty = fcastQty;
	}
	
	/**
	 * Column Info
	 * @param bkgRtoDiff
	 */
	public void setBkgRtoDiff(String bkgRtoDiff) {
		this.bkgRtoDiff = bkgRtoDiff;
	}
	
	/**
	 * Column Info
	 * @param accumRto
	 */
	public void setAccumRto(String accumRto) {
		this.accumRto = accumRto;
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
	 * @param bkgDiff
	 */
	public void setBkgDiff(String bkgDiff) {
		this.bkgDiff = bkgDiff;
	}
	
	/**
	 * Column Info
	 * @param fcastDiff
	 */
	public void setFcastDiff(String fcastDiff) {
		this.fcastDiff = fcastDiff;
	}
	
	/**
	 * Column Info
	 * @param bsa
	 */
	public void setBsa(String bsa) {
		this.bsa = bsa;
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
	 * @param subTrdCd
	 */
	public void setSubTrdCd(String subTrdCd) {
		this.subTrdCd = subTrdCd;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
		setAccumMdl(JSPUtil.getParameter(request, prefix + "accum_mdl", ""));
		setBkgRto(JSPUtil.getParameter(request, prefix + "bkg_rto", ""));
		setTrdCd(JSPUtil.getParameter(request, prefix + "trd_cd", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setCustCtrlCd(JSPUtil.getParameter(request, prefix + "cust_ctrl_cd", ""));
		setDestLocCd(JSPUtil.getParameter(request, prefix + "dest_loc_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setAlocRto(JSPUtil.getParameter(request, prefix + "aloc_rto", ""));
		setAccumBkg(JSPUtil.getParameter(request, prefix + "accum_bkg", ""));
		setAccumDiff(JSPUtil.getParameter(request, prefix + "accum_diff", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setAlocDiff(JSPUtil.getParameter(request, prefix + "aloc_diff", ""));
		setAlocQty(JSPUtil.getParameter(request, prefix + "aloc_qty", ""));
		setBkgQty(JSPUtil.getParameter(request, prefix + "bkg_qty", ""));
		setDirCd(JSPUtil.getParameter(request, prefix + "dir_cd", ""));
		setMdlRto(JSPUtil.getParameter(request, prefix + "mdl_rto", ""));
		setFcastRtoDiff(JSPUtil.getParameter(request, prefix + "fcast_rto_diff", ""));
		setFcastRto(JSPUtil.getParameter(request, prefix + "fcast_rto", ""));
		setAlocRtoDiff(JSPUtil.getParameter(request, prefix + "aloc_rto_diff", ""));
		setMdlQty(JSPUtil.getParameter(request, prefix + "mdl_qty", ""));
		setFcastQty(JSPUtil.getParameter(request, prefix + "fcast_qty", ""));
		setBkgRtoDiff(JSPUtil.getParameter(request, prefix + "bkg_rto_diff", ""));
		setAccumRto(JSPUtil.getParameter(request, prefix + "accum_rto", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setBkgDiff(JSPUtil.getParameter(request, prefix + "bkg_diff", ""));
		setFcastDiff(JSPUtil.getParameter(request, prefix + "fcast_diff", ""));
		setBsa(JSPUtil.getParameter(request, prefix + "bsa", ""));
		setSlsRgnOfcCd(JSPUtil.getParameter(request, prefix + "sls_rgn_ofc_cd", ""));
		setSubTrdCd(JSPUtil.getParameter(request, prefix + "sub_trd_cd", ""));
		
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpaceAllocationManageSummaryVO[]
	 */
	public SpaceAllocationManageSummaryVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpaceAllocationManageSummaryVO[]
	 */
	public SpaceAllocationManageSummaryVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpaceAllocationManageSummaryVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] accumMdl = (JSPUtil.getParameter(request, prefix	+ "accum_mdl", length));
			String[] bkgRto = (JSPUtil.getParameter(request, prefix	+ "bkg_rto", length));
			String[] trdCd = (JSPUtil.getParameter(request, prefix	+ "trd_cd", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] custCtrlCd = (JSPUtil.getParameter(request, prefix	+ "cust_ctrl_cd", length));
			String[] destLocCd = (JSPUtil.getParameter(request, prefix	+ "dest_loc_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] alocRto = (JSPUtil.getParameter(request, prefix	+ "aloc_rto", length));
			String[] accumBkg = (JSPUtil.getParameter(request, prefix	+ "accum_bkg", length));
			String[] accumDiff = (JSPUtil.getParameter(request, prefix	+ "accum_diff", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] alocDiff = (JSPUtil.getParameter(request, prefix	+ "aloc_diff", length));
			String[] alocQty = (JSPUtil.getParameter(request, prefix	+ "aloc_qty", length));
			String[] bkgQty = (JSPUtil.getParameter(request, prefix	+ "bkg_qty", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] mdlRto = (JSPUtil.getParameter(request, prefix	+ "mdl_rto", length));
			String[] fcastRtoDiff = (JSPUtil.getParameter(request, prefix	+ "fcast_rto_diff", length));
			String[] fcastRto = (JSPUtil.getParameter(request, prefix	+ "fcast_rto", length));
			String[] alocRtoDiff = (JSPUtil.getParameter(request, prefix	+ "aloc_rto_diff", length));
			String[] mdlQty = (JSPUtil.getParameter(request, prefix	+ "mdl_qty", length));
			String[] fcastQty = (JSPUtil.getParameter(request, prefix	+ "fcast_qty", length));
			String[] bkgRtoDiff = (JSPUtil.getParameter(request, prefix	+ "bkg_rto_diff", length));
			String[] accumRto = (JSPUtil.getParameter(request, prefix	+ "accum_rto", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] bkgDiff = (JSPUtil.getParameter(request, prefix	+ "bkg_diff", length));
			String[] fcastDiff = (JSPUtil.getParameter(request, prefix	+ "fcast_diff", length));
			String[] bsa = (JSPUtil.getParameter(request, prefix	+ "bsa", length));
			String[] slsRgnOfcCd = (JSPUtil.getParameter(request, prefix	+ "sls_rgn_ofc_cd", length));
			String[] subTrdCd = (JSPUtil.getParameter(request, prefix	+ "sub_trd_cd", length));
			
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpaceAllocationManageSummaryVO();
				if (accumMdl[i] != null)
					model.setAccumMdl(accumMdl[i]);
				if (bkgRto[i] != null)
					model.setBkgRto(bkgRto[i]);
				if (trdCd[i] != null)
					model.setTrdCd(trdCd[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (custCtrlCd[i] != null)
					model.setCustCtrlCd(custCtrlCd[i]);
				if (destLocCd[i] != null)
					model.setDestLocCd(destLocCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (alocRto[i] != null)
					model.setAlocRto(alocRto[i]);
				if (accumBkg[i] != null)
					model.setAccumBkg(accumBkg[i]);
				if (accumDiff[i] != null)
					model.setAccumDiff(accumDiff[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (alocDiff[i] != null)
					model.setAlocDiff(alocDiff[i]);
				if (alocQty[i] != null)
					model.setAlocQty(alocQty[i]);
				if (bkgQty[i] != null)
					model.setBkgQty(bkgQty[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (mdlRto[i] != null)
					model.setMdlRto(mdlRto[i]);
				if (fcastRtoDiff[i] != null)
					model.setFcastRtoDiff(fcastRtoDiff[i]);
				if (fcastRto[i] != null)
					model.setFcastRto(fcastRto[i]);
				if (alocRtoDiff[i] != null)
					model.setAlocRtoDiff(alocRtoDiff[i]);
				if (mdlQty[i] != null)
					model.setMdlQty(mdlQty[i]);
				if (fcastQty[i] != null)
					model.setFcastQty(fcastQty[i]);
				if (bkgRtoDiff[i] != null)
					model.setBkgRtoDiff(bkgRtoDiff[i]);
				if (accumRto[i] != null)
					model.setAccumRto(accumRto[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (bkgDiff[i] != null)
					model.setBkgDiff(bkgDiff[i]);
				if (fcastDiff[i] != null)
					model.setFcastDiff(fcastDiff[i]);
				if (bsa[i] != null)
					model.setBsa(bsa[i]);
				if (slsRgnOfcCd[i] != null)
					model.setSlsRgnOfcCd(slsRgnOfcCd[i]);
				if (subTrdCd[i] != null)
					model.setSubTrdCd(subTrdCd[i]);
				
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpaceAllocationManageSummaryVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpaceAllocationManageSummaryVO[]
	 */
	public SpaceAllocationManageSummaryVO[] getSpaceAllocationManageSummaryVOs(){
		SpaceAllocationManageSummaryVO[] vos = (SpaceAllocationManageSummaryVO[])models.toArray(new SpaceAllocationManageSummaryVO[models.size()]);
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
		this.accumMdl = this.accumMdl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRto = this.bkgRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trdCd = this.trdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custCtrlCd = this.custCtrlCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destLocCd = this.destLocCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocRto = this.alocRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accumBkg = this.accumBkg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accumDiff = this.accumDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocDiff = this.alocDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocQty = this.alocQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgQty = this.bkgQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlRto = this.mdlRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRtoDiff = this.fcastRtoDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastRto = this.fcastRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.alocRtoDiff = this.alocRtoDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mdlQty = this.mdlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastQty = this.fcastQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgRtoDiff = this.bkgRtoDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.accumRto = this.accumRto .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgDiff = this.bkgDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcastDiff = this.fcastDiff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bsa = this.bsa .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slsRgnOfcCd = this.slsRgnOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.subTrdCd = this.subTrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
