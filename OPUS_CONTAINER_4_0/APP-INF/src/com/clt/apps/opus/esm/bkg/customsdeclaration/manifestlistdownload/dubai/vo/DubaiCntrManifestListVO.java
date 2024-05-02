/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : DubaiCntrManifestListVO.java
*@FileTitle : DubaiCntrManifestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.26
*@LastModifier : 김민정
*@LastVersion : 1.0
* 2010.03.26 김민정 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo;

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
 * @author 김민정
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DubaiCntrManifestListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DubaiCntrManifestListVO> models = new ArrayList<DubaiCntrManifestListVO>();
	
	/* Column Info */
	private String duPckTpCd = null;
	/* Column Info */
	private String flshPntCdoTemp = null;
	/* Column Info */
	private String dcgoTempUtCd = null;
	/* Column Info */
	private String cntrMfWgt = null;
	/* Column Info */
	private String minTemp = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String cntrMfSeq = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String dcgoFlg = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pltQty = null;
	/* Column Info */
	private String cmdtHsCd = null;
	/* Column Info */
	private String imdgUnNo = null;
	/* Column Info */
	private String cntrMfMkDesc = null;
	/* Column Info */
	private String rfrtReqFlg = null;
	/* Column Info */
	private String maxTemp = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrTareWgt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cgoTempUtCd = null;
	/* Column Info */
	private String cntrMfGdsDesc = null;
	/* Column Info */
	private String cntrSealNo = null;
	/* Column Info */
	private String dgStoReqFlg = null;
	/* Column Info */
	private String imdgClssCd = null;
	/* Column Info */
	private String duCntrSerNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DubaiCntrManifestListVO() {}

	public DubaiCntrManifestListVO(String ibflag, String pagerows, String blNo, String bkgNo, String podCd, String cntrNo, String cntrTareWgt, String cntrSealNo, String cntrMfSeq, String duCntrSerNo, String cntrMfMkDesc, String cntrMfGdsDesc, String cmdtHsCd, String pckQty, String duPckTpCd, String pltQty, String cntrMfWgt, String measQty, String dcgoFlg, String imdgClssCd, String imdgUnNo, String flshPntCdoTemp, String dcgoTempUtCd, String dgStoReqFlg, String rfrtReqFlg, String minTemp, String maxTemp, String cgoTempUtCd) {
		this.duPckTpCd = duPckTpCd;
		this.flshPntCdoTemp = flshPntCdoTemp;
		this.dcgoTempUtCd = dcgoTempUtCd;
		this.cntrMfWgt = cntrMfWgt;
		this.minTemp = minTemp;
		this.blNo = blNo;
		this.cntrMfSeq = cntrMfSeq;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.measQty = measQty;
		this.dcgoFlg = dcgoFlg;
		this.pckQty = pckQty;
		this.pltQty = pltQty;
		this.cmdtHsCd = cmdtHsCd;
		this.imdgUnNo = imdgUnNo;
		this.cntrMfMkDesc = cntrMfMkDesc;
		this.rfrtReqFlg = rfrtReqFlg;
		this.maxTemp = maxTemp;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.cntrTareWgt = cntrTareWgt;
		this.cntrNo = cntrNo;
		this.cgoTempUtCd = cgoTempUtCd;
		this.cntrMfGdsDesc = cntrMfGdsDesc;
		this.cntrSealNo = cntrSealNo;
		this.dgStoReqFlg = dgStoReqFlg;
		this.imdgClssCd = imdgClssCd;
		this.duCntrSerNo = duCntrSerNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("du_pck_tp_cd", getDuPckTpCd());
		this.hashColumns.put("flsh_pnt_cdo_temp", getFlshPntCdoTemp());
		this.hashColumns.put("dcgo_temp_ut_cd", getDcgoTempUtCd());
		this.hashColumns.put("cntr_mf_wgt", getCntrMfWgt());
		this.hashColumns.put("min_temp", getMinTemp());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("cntr_mf_seq", getCntrMfSeq());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("dcgo_flg", getDcgoFlg());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("plt_qty", getPltQty());
		this.hashColumns.put("cmdt_hs_cd", getCmdtHsCd());
		this.hashColumns.put("imdg_un_no", getImdgUnNo());
		this.hashColumns.put("cntr_mf_mk_desc", getCntrMfMkDesc());
		this.hashColumns.put("rfrt_req_flg", getRfrtReqFlg());
		this.hashColumns.put("max_temp", getMaxTemp());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_tare_wgt", getCntrTareWgt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cgo_temp_ut_cd", getCgoTempUtCd());
		this.hashColumns.put("cntr_mf_gds_desc", getCntrMfGdsDesc());
		this.hashColumns.put("cntr_seal_no", getCntrSealNo());
		this.hashColumns.put("dg_sto_req_flg", getDgStoReqFlg());
		this.hashColumns.put("imdg_clss_cd", getImdgClssCd());
		this.hashColumns.put("du_cntr_ser_no", getDuCntrSerNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("du_pck_tp_cd", "duPckTpCd");
		this.hashFields.put("flsh_pnt_cdo_temp", "flshPntCdoTemp");
		this.hashFields.put("dcgo_temp_ut_cd", "dcgoTempUtCd");
		this.hashFields.put("cntr_mf_wgt", "cntrMfWgt");
		this.hashFields.put("min_temp", "minTemp");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("cntr_mf_seq", "cntrMfSeq");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("dcgo_flg", "dcgoFlg");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("plt_qty", "pltQty");
		this.hashFields.put("cmdt_hs_cd", "cmdtHsCd");
		this.hashFields.put("imdg_un_no", "imdgUnNo");
		this.hashFields.put("cntr_mf_mk_desc", "cntrMfMkDesc");
		this.hashFields.put("rfrt_req_flg", "rfrtReqFlg");
		this.hashFields.put("max_temp", "maxTemp");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_tare_wgt", "cntrTareWgt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cgo_temp_ut_cd", "cgoTempUtCd");
		this.hashFields.put("cntr_mf_gds_desc", "cntrMfGdsDesc");
		this.hashFields.put("cntr_seal_no", "cntrSealNo");
		this.hashFields.put("dg_sto_req_flg", "dgStoReqFlg");
		this.hashFields.put("imdg_clss_cd", "imdgClssCd");
		this.hashFields.put("du_cntr_ser_no", "duCntrSerNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return duPckTpCd
	 */
	public String getDuPckTpCd() {
		return this.duPckTpCd;
	}
	
	/**
	 * Column Info
	 * @return flshPntCdoTemp
	 */
	public String getFlshPntCdoTemp() {
		return this.flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @return dcgoTempUtCd
	 */
	public String getDcgoTempUtCd() {
		return this.dcgoTempUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrMfWgt
	 */
	public String getCntrMfWgt() {
		return this.cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @return minTemp
	 */
	public String getMinTemp() {
		return this.minTemp;
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
	 * @return cntrMfSeq
	 */
	public String getCntrMfSeq() {
		return this.cntrMfSeq;
	}
	
	/**
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return dcgoFlg
	 */
	public String getDcgoFlg() {
		return this.dcgoFlg;
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
	 * @return pltQty
	 */
	public String getPltQty() {
		return this.pltQty;
	}
	
	/**
	 * Column Info
	 * @return cmdtHsCd
	 */
	public String getCmdtHsCd() {
		return this.cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @return imdgUnNo
	 */
	public String getImdgUnNo() {
		return this.imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @return cntrMfMkDesc
	 */
	public String getCntrMfMkDesc() {
		return this.cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @return rfrtReqFlg
	 */
	public String getRfrtReqFlg() {
		return this.rfrtReqFlg;
	}
	
	/**
	 * Column Info
	 * @return maxTemp
	 */
	public String getMaxTemp() {
		return this.maxTemp;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTareWgt
	 */
	public String getCntrTareWgt() {
		return this.cntrTareWgt;
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
	 * @return cgoTempUtCd
	 */
	public String getCgoTempUtCd() {
		return this.cgoTempUtCd;
	}
	
	/**
	 * Column Info
	 * @return cntrMfGdsDesc
	 */
	public String getCntrMfGdsDesc() {
		return this.cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @return cntrSealNo
	 */
	public String getCntrSealNo() {
		return this.cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @return dgStoReqFlg
	 */
	public String getDgStoReqFlg() {
		return this.dgStoReqFlg;
	}
	
	/**
	 * Column Info
	 * @return imdgClssCd
	 */
	public String getImdgClssCd() {
		return this.imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @return duCntrSerNo
	 */
	public String getDuCntrSerNo() {
		return this.duCntrSerNo;
	}
	

	/**
	 * Column Info
	 * @param duPckTpCd
	 */
	public void setDuPckTpCd(String duPckTpCd) {
		this.duPckTpCd = duPckTpCd;
	}
	
	/**
	 * Column Info
	 * @param flshPntCdoTemp
	 */
	public void setFlshPntCdoTemp(String flshPntCdoTemp) {
		this.flshPntCdoTemp = flshPntCdoTemp;
	}
	
	/**
	 * Column Info
	 * @param dcgoTempUtCd
	 */
	public void setDcgoTempUtCd(String dcgoTempUtCd) {
		this.dcgoTempUtCd = dcgoTempUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrMfWgt
	 */
	public void setCntrMfWgt(String cntrMfWgt) {
		this.cntrMfWgt = cntrMfWgt;
	}
	
	/**
	 * Column Info
	 * @param minTemp
	 */
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
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
	 * @param cntrMfSeq
	 */
	public void setCntrMfSeq(String cntrMfSeq) {
		this.cntrMfSeq = cntrMfSeq;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param dcgoFlg
	 */
	public void setDcgoFlg(String dcgoFlg) {
		this.dcgoFlg = dcgoFlg;
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
	 * @param pltQty
	 */
	public void setPltQty(String pltQty) {
		this.pltQty = pltQty;
	}
	
	/**
	 * Column Info
	 * @param cmdtHsCd
	 */
	public void setCmdtHsCd(String cmdtHsCd) {
		this.cmdtHsCd = cmdtHsCd;
	}
	
	/**
	 * Column Info
	 * @param imdgUnNo
	 */
	public void setImdgUnNo(String imdgUnNo) {
		this.imdgUnNo = imdgUnNo;
	}
	
	/**
	 * Column Info
	 * @param cntrMfMkDesc
	 */
	public void setCntrMfMkDesc(String cntrMfMkDesc) {
		this.cntrMfMkDesc = cntrMfMkDesc;
	}
	
	/**
	 * Column Info
	 * @param rfrtReqFlg
	 */
	public void setRfrtReqFlg(String rfrtReqFlg) {
		this.rfrtReqFlg = rfrtReqFlg;
	}
	
	/**
	 * Column Info
	 * @param maxTemp
	 */
	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTareWgt
	 */
	public void setCntrTareWgt(String cntrTareWgt) {
		this.cntrTareWgt = cntrTareWgt;
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
	 * @param cgoTempUtCd
	 */
	public void setCgoTempUtCd(String cgoTempUtCd) {
		this.cgoTempUtCd = cgoTempUtCd;
	}
	
	/**
	 * Column Info
	 * @param cntrMfGdsDesc
	 */
	public void setCntrMfGdsDesc(String cntrMfGdsDesc) {
		this.cntrMfGdsDesc = cntrMfGdsDesc;
	}
	
	/**
	 * Column Info
	 * @param cntrSealNo
	 */
	public void setCntrSealNo(String cntrSealNo) {
		this.cntrSealNo = cntrSealNo;
	}
	
	/**
	 * Column Info
	 * @param dgStoReqFlg
	 */
	public void setDgStoReqFlg(String dgStoReqFlg) {
		this.dgStoReqFlg = dgStoReqFlg;
	}
	
	/**
	 * Column Info
	 * @param imdgClssCd
	 */
	public void setImdgClssCd(String imdgClssCd) {
		this.imdgClssCd = imdgClssCd;
	}
	
	/**
	 * Column Info
	 * @param duCntrSerNo
	 */
	public void setDuCntrSerNo(String duCntrSerNo) {
		this.duCntrSerNo = duCntrSerNo;
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
		setDuPckTpCd(JSPUtil.getParameter(request, prefix + "du_pck_tp_cd", ""));
		setFlshPntCdoTemp(JSPUtil.getParameter(request, prefix + "flsh_pnt_cdo_temp", ""));
		setDcgoTempUtCd(JSPUtil.getParameter(request, prefix + "dcgo_temp_ut_cd", ""));
		setCntrMfWgt(JSPUtil.getParameter(request, prefix + "cntr_mf_wgt", ""));
		setMinTemp(JSPUtil.getParameter(request, prefix + "min_temp", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setCntrMfSeq(JSPUtil.getParameter(request, prefix + "cntr_mf_seq", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setDcgoFlg(JSPUtil.getParameter(request, prefix + "dcgo_flg", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPltQty(JSPUtil.getParameter(request, prefix + "plt_qty", ""));
		setCmdtHsCd(JSPUtil.getParameter(request, prefix + "cmdt_hs_cd", ""));
		setImdgUnNo(JSPUtil.getParameter(request, prefix + "imdg_un_no", ""));
		setCntrMfMkDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_mk_desc", ""));
		setRfrtReqFlg(JSPUtil.getParameter(request, prefix + "rfrt_req_flg", ""));
		setMaxTemp(JSPUtil.getParameter(request, prefix + "max_temp", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setCntrTareWgt(JSPUtil.getParameter(request, prefix + "cntr_tare_wgt", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCgoTempUtCd(JSPUtil.getParameter(request, prefix + "cgo_temp_ut_cd", ""));
		setCntrMfGdsDesc(JSPUtil.getParameter(request, prefix + "cntr_mf_gds_desc", ""));
		setCntrSealNo(JSPUtil.getParameter(request, prefix + "cntr_seal_no", ""));
		setDgStoReqFlg(JSPUtil.getParameter(request, prefix + "dg_sto_req_flg", ""));
		setImdgClssCd(JSPUtil.getParameter(request, prefix + "imdg_clss_cd", ""));
		setDuCntrSerNo(JSPUtil.getParameter(request, prefix + "du_cntr_ser_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DubaiCntrManifestListVO[]
	 */
	public DubaiCntrManifestListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DubaiCntrManifestListVO[]
	 */
	public DubaiCntrManifestListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DubaiCntrManifestListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] duPckTpCd = (JSPUtil.getParameter(request, prefix	+ "du_pck_tp_cd", length));
			String[] flshPntCdoTemp = (JSPUtil.getParameter(request, prefix	+ "flsh_pnt_cdo_temp", length));
			String[] dcgoTempUtCd = (JSPUtil.getParameter(request, prefix	+ "dcgo_temp_ut_cd", length));
			String[] cntrMfWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_wgt", length));
			String[] minTemp = (JSPUtil.getParameter(request, prefix	+ "min_temp", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] cntrMfSeq = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_seq", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] dcgoFlg = (JSPUtil.getParameter(request, prefix	+ "dcgo_flg", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pltQty = (JSPUtil.getParameter(request, prefix	+ "plt_qty", length));
			String[] cmdtHsCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_hs_cd", length));
			String[] imdgUnNo = (JSPUtil.getParameter(request, prefix	+ "imdg_un_no", length));
			String[] cntrMfMkDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_mk_desc", length));
			String[] rfrtReqFlg = (JSPUtil.getParameter(request, prefix	+ "rfrt_req_flg", length));
			String[] maxTemp = (JSPUtil.getParameter(request, prefix	+ "max_temp", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] cntrTareWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_tare_wgt", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cgoTempUtCd = (JSPUtil.getParameter(request, prefix	+ "cgo_temp_ut_cd", length));
			String[] cntrMfGdsDesc = (JSPUtil.getParameter(request, prefix	+ "cntr_mf_gds_desc", length));
			String[] cntrSealNo = (JSPUtil.getParameter(request, prefix	+ "cntr_seal_no", length));
			String[] dgStoReqFlg = (JSPUtil.getParameter(request, prefix	+ "dg_sto_req_flg", length));
			String[] imdgClssCd = (JSPUtil.getParameter(request, prefix	+ "imdg_clss_cd", length));
			String[] duCntrSerNo = (JSPUtil.getParameter(request, prefix	+ "du_cntr_ser_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new DubaiCntrManifestListVO();
				if (duPckTpCd[i] != null)
					model.setDuPckTpCd(duPckTpCd[i]);
				if (flshPntCdoTemp[i] != null)
					model.setFlshPntCdoTemp(flshPntCdoTemp[i]);
				if (dcgoTempUtCd[i] != null)
					model.setDcgoTempUtCd(dcgoTempUtCd[i]);
				if (cntrMfWgt[i] != null)
					model.setCntrMfWgt(cntrMfWgt[i]);
				if (minTemp[i] != null)
					model.setMinTemp(minTemp[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (cntrMfSeq[i] != null)
					model.setCntrMfSeq(cntrMfSeq[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (dcgoFlg[i] != null)
					model.setDcgoFlg(dcgoFlg[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pltQty[i] != null)
					model.setPltQty(pltQty[i]);
				if (cmdtHsCd[i] != null)
					model.setCmdtHsCd(cmdtHsCd[i]);
				if (imdgUnNo[i] != null)
					model.setImdgUnNo(imdgUnNo[i]);
				if (cntrMfMkDesc[i] != null)
					model.setCntrMfMkDesc(cntrMfMkDesc[i]);
				if (rfrtReqFlg[i] != null)
					model.setRfrtReqFlg(rfrtReqFlg[i]);
				if (maxTemp[i] != null)
					model.setMaxTemp(maxTemp[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrTareWgt[i] != null)
					model.setCntrTareWgt(cntrTareWgt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cgoTempUtCd[i] != null)
					model.setCgoTempUtCd(cgoTempUtCd[i]);
				if (cntrMfGdsDesc[i] != null)
					model.setCntrMfGdsDesc(cntrMfGdsDesc[i]);
				if (cntrSealNo[i] != null)
					model.setCntrSealNo(cntrSealNo[i]);
				if (dgStoReqFlg[i] != null)
					model.setDgStoReqFlg(dgStoReqFlg[i]);
				if (imdgClssCd[i] != null)
					model.setImdgClssCd(imdgClssCd[i]);
				if (duCntrSerNo[i] != null)
					model.setDuCntrSerNo(duCntrSerNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDubaiCntrManifestListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DubaiCntrManifestListVO[]
	 */
	public DubaiCntrManifestListVO[] getDubaiCntrManifestListVOs(){
		DubaiCntrManifestListVO[] vos = (DubaiCntrManifestListVO[])models.toArray(new DubaiCntrManifestListVO[models.size()]);
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
		this.duPckTpCd = this.duPckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flshPntCdoTemp = this.flshPntCdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoTempUtCd = this.dcgoTempUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfWgt = this.cntrMfWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.minTemp = this.minTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfSeq = this.cntrMfSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dcgoFlg = this.dcgoFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pltQty = this.pltQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtHsCd = this.cmdtHsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgUnNo = this.imdgUnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfMkDesc = this.cntrMfMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfrtReqFlg = this.rfrtReqFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.maxTemp = this.maxTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTareWgt = this.cntrTareWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoTempUtCd = this.cgoTempUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrMfGdsDesc = this.cntrMfGdsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrSealNo = this.cntrSealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgStoReqFlg = this.dgStoReqFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imdgClssCd = this.imdgClssCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.duCntrSerNo = this.duCntrSerNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
