/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BlCntrCargoManifestOutVO.java
*@FileTitle : BlCntrCargoManifestOutVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.22
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.22  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

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

public class BlCntrCargoManifestOutVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BlCntrCargoManifestOutVO> models = new ArrayList<BlCntrCargoManifestOutVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String prePostVvd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String prePostPolCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String cstmsDesc = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String cntrWgt = null;
	/* Column Info */
	private String sNm = null;
	/* Column Info */
	private String sCd = null;
	/* Column Info */
	private String cCd = null;
	/* Column Info */
	private String prePostPolYdCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String prePostPodYdCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String blTp = null;
	/* Column Info */
	private String nAd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String prePostPodCd = null;
	/* Column Info */
	private String cNm = null;
	/* Column Info */
	private String nNm = null;
	/* Column Info */
	private String cAd = null;
	/* Column Info */
	private String prePost = null;
	/* Column Info */
	private String sAd = null;
	/* Column Info */
	private String mkDesc =null;
	/* Column Info */
	private String cmdtDesc =null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BlCntrCargoManifestOutVO() {}

	public BlCntrCargoManifestOutVO(String ibflag, String pagerows, String blNo, String bkgNo, String blTp, String cntrNo, String cntrTpszCd, String sealNo, String pckQty, String pckTpCd, String cntrWgt, String measQty, String cstmsDesc, String porCd, String polCd, String podCd, String delCd, String sNm, String sAd, String cNm, String cAd, String nNm, String nAd, String prePostVvd, String prePostPolCd, String prePostPolYdCd, String prePostPodCd, String prePostPodYdCd, String prePost, String sCd, String cCd, String mkDesc, String cmdtDesc) {
		this.porCd = porCd;
		this.prePostVvd = prePostVvd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.prePostPolCd = prePostPolCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.cstmsDesc = cstmsDesc;
		this.measQty = measQty;
		this.cntrTpszCd = cntrTpszCd;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.sealNo = sealNo;
		this.cntrWgt = cntrWgt;
		this.sNm = sNm;
		this.sCd = sCd;
		this.cCd = cCd;
		this.prePostPolYdCd = prePostPolYdCd;
		this.delCd = delCd;
		this.podCd = podCd;
		this.prePostPodYdCd = prePostPodYdCd;
		this.bkgNo = bkgNo;
		this.blTp = blTp;
		this.nAd = nAd;
		this.cntrNo = cntrNo;
		this.prePostPodCd = prePostPodCd;
		this.cNm = cNm;
		this.nNm = nNm;
		this.cAd = cAd;
		this.prePost = prePost;
		this.sAd = sAd;
		this.cmdtDesc = cmdtDesc;
		this.mkDesc = mkDesc;
		
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("pre_post_vvd", getPrePostVvd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_post_pol_cd", getPrePostPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cstms_desc", getCstmsDesc());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("cntr_wgt", getCntrWgt());
		this.hashColumns.put("s_nm", getSNm());
		this.hashColumns.put("s_cd", getSCd());
		this.hashColumns.put("c_cd", getCCd());
		this.hashColumns.put("pre_post_pol_yd_cd", getPrePostPolYdCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pre_post_pod_yd_cd", getPrePostPodYdCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bl_tp", getBlTp());
		this.hashColumns.put("n_ad", getNAd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("pre_post_pod_cd", getPrePostPodCd());
		this.hashColumns.put("c_nm", getCNm());
		this.hashColumns.put("n_nm", getNNm());
		this.hashColumns.put("c_ad", getCAd());
		this.hashColumns.put("pre_post", getPrePost());
		this.hashColumns.put("s_ad", getSAd());
		this.hashColumns.put("mk_desc", getMkDesc());
		this.hashColumns.put("cmdt_desc", getCmdtDesc());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("pre_post_vvd", "prePostVvd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_post_pol_cd", "prePostPolCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cstms_desc", "cstmsDesc");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("cntr_wgt", "cntrWgt");
		this.hashFields.put("s_nm", "sNm");
		this.hashFields.put("s_cd", "sCd");
		this.hashFields.put("c_cd", "cCd");
		this.hashFields.put("pre_post_pol_yd_cd", "prePostPolYdCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pre_post_pod_yd_cd", "prePostPodYdCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bl_tp", "blTp");
		this.hashFields.put("n_ad", "nAd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("pre_post_pod_cd", "prePostPodCd");
		this.hashFields.put("c_nm", "cNm");
		this.hashFields.put("n_nm", "nNm");
		this.hashFields.put("c_ad", "cAd");
		this.hashFields.put("pre_post", "prePost");
		this.hashFields.put("s_ad", "sAd");
		this.hashFields.put("mk_desc", "mkDesc");
		this.hashFields.put("cmdt_desc", "cmdtDesc");
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
	 * @return prePostVvd
	 */
	public String getPrePostVvd() {
		return this.prePostVvd;
	}
	
	/**
	 * Column Info
	 * @return blNo
	 */
	public String getBlNo() {
		return this.blNo;
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
	 * @return prePostPolCd
	 */
	public String getPrePostPolCd() {
		return this.prePostPolCd;
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
	 * @return cstmsDesc
	 */
	public String getCstmsDesc() {
		return this.cstmsDesc;
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
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}
	
	/**
	 * Column Info
	 * @return cntrWgt
	 */
	public String getCntrWgt() {
		return this.cntrWgt;
	}
	
	/**
	 * Column Info
	 * @return sNm
	 */
	public String getSNm() {
		return this.sNm;
	}
	
	/**
	 * Column Info
	 * @return prePostPolYdCd
	 */
	public String getPrePostPolYdCd() {
		return this.prePostPolYdCd;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return prePostPodYdCd
	 */
	public String getPrePostPodYdCd() {
		return this.prePostPodYdCd;
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
	 * @return blTp
	 */
	public String getBlTp() {
		return this.blTp;
	}
	
	/**
	 * Column Info
	 * @return nAd
	 */
	public String getNAd() {
		return this.nAd;
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
	 * @return prePostPodCd
	 */
	public String getPrePostPodCd() {
		return this.prePostPodCd;
	}
	
	/**
	 * Column Info
	 * @return cNm
	 */
	public String getCNm() {
		return this.cNm;
	}
	
	/**
	 * Column Info
	 * @return nNm
	 */
	public String getNNm() {
		return this.nNm;
	}
	
	/**
	 * Column Info
	 * @return sCd
	 */
	public String getSCd() {
		return this.sCd;
	}
	
	/**
	 * Column Info
	 * @return cCd
	 */
	public String getCCd() {
		return this.cCd;
	}
	
	/**
	 * Column Info
	 * @return cAd
	 */
	public String getCAd() {
		return this.cAd;
	}
	
	/**
	 * Column Info
	 * @return prePost
	 */
	public String getPrePost() {
		return this.prePost;
	}
	
	/**
	 * Column Info
	 * @return sAd
	 */
	public String getSAd() {
		return this.sAd;
	}
	
	/**
	 * Column Info
	 * @param mk_desc
	 */

	public String getMkDesc() {
		return mkDesc;
	}
	
	/**
	 * Column Info
	 * @param cmdt_desc
	 */
	
	public String getCmdtDesc() {
		return cmdtDesc;
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
	 * @param prePostVvd
	 */
	public void setPrePostVvd(String prePostVvd) {
		this.prePostVvd = prePostVvd;
	}
	
	/**
	 * Column Info
	 * @param blNo
	 */
	public void setBlNo(String blNo) {
		this.blNo = blNo;
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
	 * @param prePostPolCd
	 */
	public void setPrePostPolCd(String prePostPolCd) {
		this.prePostPolCd = prePostPolCd;
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
	 * @param cstmsDesc
	 */
	public void setCstmsDesc(String cstmsDesc) {
		this.cstmsDesc = cstmsDesc;
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
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	
	/**
	 * Column Info
	 * @param cntrWgt
	 */
	public void setCntrWgt(String cntrWgt) {
		this.cntrWgt = cntrWgt;
	}
	
	/**
	 * Column Info
	 * @param sNm
	 */
	public void setSNm(String sNm) {
		this.sNm = sNm;
	}
	
	/**
	 * Column Info
	 * @param prePostPolYdCd
	 */
	public void setPrePostPolYdCd(String prePostPolYdCd) {
		this.prePostPolYdCd = prePostPolYdCd;
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
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param prePostPodYdCd
	 */
	public void setPrePostPodYdCd(String prePostPodYdCd) {
		this.prePostPodYdCd = prePostPodYdCd;
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
	 * @param blTp
	 */
	public void setBlTp(String blTp) {
		this.blTp = blTp;
	}
	
	/**
	 * Column Info
	 * @param nAd
	 */
	public void setNAd(String nAd) {
		this.nAd = nAd;
	}
	
	/**
	 * Column Info
	 * @param sCd
	 */
	public void setSCd(String sCd) {
		this.sCd = sCd;
	}
	
	/**
	 * Column Info
	 * @param cCd
	 */
	public void setCCd(String cCd) {
		this.cCd = cCd;
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
	 * @param prePostPodCd
	 */
	public void setPrePostPodCd(String prePostPodCd) {
		this.prePostPodCd = prePostPodCd;
	}
	
	/**
	 * Column Info
	 * @param cNm
	 */
	public void setCNm(String cNm) {
		this.cNm = cNm;
	}
	
	/**
	 * Column Info
	 * @param nNm
	 */
	public void setNNm(String nNm) {
		this.nNm = nNm;
	}
	
	/**
	 * Column Info
	 * @param cAd
	 */
	public void setCAd(String cAd) {
		this.cAd = cAd;
	}
	
	/**
	 * Column Info
	 * @param prePost
	 */
	public void setPrePost(String prePost) {
		this.prePost = prePost;
	}
	
	/**
	 * Column Info
	 * @param sAd
	 */
	public void setSAd(String sAd) {
		this.sAd = sAd;
	}
	
/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		fromRequest(request,"");
	}

	/**
	 * Column Info
	 * @param mk_desc
	 */


	public void setMkDesc(String mkDesc) {
		this.mkDesc = mkDesc;
	}
	

	/**
	 * Column Info
	 * @param cmdt_desc
	 */
	public void setCmdtDesc(String cmdtDesc) {
		this.cmdtDesc = cmdtDesc;
	}

	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request, String prefix) {
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setPrePostVvd(JSPUtil.getParameter(request, prefix + "pre_post_vvd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPrePostPolCd(JSPUtil.getParameter(request, prefix + "pre_post_pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCstmsDesc(JSPUtil.getParameter(request, prefix + "cstms_desc", ""));
		setMeasQty(JSPUtil.getParameter(request, prefix + "meas_qty", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, prefix + "pck_tp_cd", ""));
		setSealNo(JSPUtil.getParameter(request, prefix + "seal_no", ""));
		setCntrWgt(JSPUtil.getParameter(request, prefix + "cntr_wgt", ""));
		setSNm(JSPUtil.getParameter(request, prefix + "s_nm", ""));
		setPrePostPolYdCd(JSPUtil.getParameter(request, prefix + "pre_post_pol_yd_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPrePostPodYdCd(JSPUtil.getParameter(request, prefix + "pre_post_pod_yd_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBlTp(JSPUtil.getParameter(request, prefix + "bl_tp", ""));
		setNAd(JSPUtil.getParameter(request, prefix + "n_ad", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setPrePostPodCd(JSPUtil.getParameter(request, prefix + "pre_post_pod_cd", ""));
		setCNm(JSPUtil.getParameter(request, prefix + "c_nm", ""));
		setNNm(JSPUtil.getParameter(request, prefix + "n_nm", ""));
		setCAd(JSPUtil.getParameter(request, prefix + "c_ad", ""));
		setSCd(JSPUtil.getParameter(request, prefix + "s_cd", ""));
		setCCd(JSPUtil.getParameter(request, prefix + "c_cd", ""));
		setPrePost(JSPUtil.getParameter(request, prefix + "pre_post", ""));
		setSAd(JSPUtil.getParameter(request, prefix + "s_ad", ""));
		setMkDesc(JSPUtil.getParameter(request, prefix + "mk_desc", ""));
		setCmdtDesc(JSPUtil.getParameter(request, prefix + "cmdt_desc", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return BlCntrCargoManifestOutVO[]
	 */
	public BlCntrCargoManifestOutVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return BlCntrCargoManifestOutVO[]
	 */
	public BlCntrCargoManifestOutVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BlCntrCargoManifestOutVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] prePostVvd = (JSPUtil.getParameter(request, prefix	+ "pre_post_vvd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] prePostPolCd = (JSPUtil.getParameter(request, prefix	+ "pre_post_pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] cstmsDesc = (JSPUtil.getParameter(request, prefix	+ "cstms_desc", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no", length));
			String[] cntrWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_wgt", length));
			String[] sNm = (JSPUtil.getParameter(request, prefix	+ "s_nm", length));
			String[] prePostPolYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_post_pol_yd_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] prePostPodYdCd = (JSPUtil.getParameter(request, prefix	+ "pre_post_pod_yd_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] blTp = (JSPUtil.getParameter(request, prefix	+ "bl_tp", length));
			String[] nAd = (JSPUtil.getParameter(request, prefix	+ "n_ad", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] prePostPodCd = (JSPUtil.getParameter(request, prefix	+ "pre_post_pod_cd", length));
			String[] cNm = (JSPUtil.getParameter(request, prefix	+ "c_nm", length));
			String[] nNm = (JSPUtil.getParameter(request, prefix	+ "n_nm", length));
			String[] cAd = (JSPUtil.getParameter(request, prefix	+ "c_ad", length));
			String[] sCd = (JSPUtil.getParameter(request, prefix	+ "s_cd", length));
			String[] cCd = (JSPUtil.getParameter(request, prefix	+ "c_cd", length));
			String[] prePost = (JSPUtil.getParameter(request, prefix	+ "pre_post", length));
			String[] sAd = (JSPUtil.getParameter(request, prefix	+ "s_ad", length));
			String[] mkDesc = (JSPUtil.getParameter(request, prefix	+ "mk_desc", length));
			String[] cmdtDesc = (JSPUtil.getParameter(request, prefix	+ "cmdt_desc", length));
			
			for (int i = 0; i < length; i++) {
				model = new BlCntrCargoManifestOutVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (prePostVvd[i] != null)
					model.setPrePostVvd(prePostVvd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (prePostPolCd[i] != null)
					model.setPrePostPolCd(prePostPolCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (cstmsDesc[i] != null)
					model.setCstmsDesc(cstmsDesc[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (cntrWgt[i] != null)
					model.setCntrWgt(cntrWgt[i]);
				if (sNm[i] != null)
					model.setSNm(sNm[i]);
				if (prePostPolYdCd[i] != null)
					model.setPrePostPolYdCd(prePostPolYdCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (prePostPodYdCd[i] != null)
					model.setPrePostPodYdCd(prePostPodYdCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (blTp[i] != null)
					model.setBlTp(blTp[i]);
				if (nAd[i] != null)
					model.setNAd(nAd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (prePostPodCd[i] != null)
					model.setPrePostPodCd(prePostPodCd[i]);
				if (cNm[i] != null)
					model.setCNm(cNm[i]);
				if (nNm[i] != null)
					model.setNNm(nNm[i]);
				if (cAd[i] != null)
					model.setCAd(cAd[i]);
				if (prePost[i] != null)
					model.setPrePost(prePost[i]);
				if (sAd[i] != null)
					model.setSAd(sAd[i]);
				if (sCd[i] != null)
					model.setSCd(sCd[i]);
				if (cCd[i] != null)
					model.setCCd(cCd[i]);
				if (mkDesc[i] != null)
					model.setMkDesc(mkDesc[i]);
				if (cmdtDesc[i] != null)
					model.setCmdtDesc(cmdtDesc[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getBlCntrCargoManifestOutVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return BlCntrCargoManifestOutVO[]
	 */
	public BlCntrCargoManifestOutVO[] getBlCntrCargoManifestOutVOs(){
		BlCntrCargoManifestOutVO[] vos = (BlCntrCargoManifestOutVO[])models.toArray(new BlCntrCargoManifestOutVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePostVvd = this.prePostVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePostPolCd = this.prePostPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDesc = this.cstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrWgt = this.cntrWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sNm = this.sNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePostPolYdCd = this.prePostPolYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePostPodYdCd = this.prePostPodYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTp = this.blTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nAd = this.nAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePostPodCd = this.prePostPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cNm = this.cNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nNm = this.nNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cAd = this.cAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sCd = this.sCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cCd = this.cCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.prePost = this.prePost .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sAd = this.sAd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mkDesc = this.mkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtDesc = this.cmdtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
