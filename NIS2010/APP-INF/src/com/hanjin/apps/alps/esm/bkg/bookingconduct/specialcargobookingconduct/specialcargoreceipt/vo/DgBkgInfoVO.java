/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : DgBkgInfoVO.java
*@FileTitle : DgBkgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.19
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2013.08.19 류대영 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo;

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
 * @author 류대영
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class DgBkgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DgBkgInfoVO> models = new ArrayList<DgBkgInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String destTrnsModCd = null;
	/* Column Info */
	private String imgFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String pckPreChkCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cmdtCd = null;
	/* Column Info */
	private String crrPreChkCd = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String vslPrePstCd = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String segrPreChkCd = null;
	/* Column Info */
	private String vesselNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String corrNo = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String cmdtNm = null;
	/* Column Info */
	private String corrN1stDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String flexHgtFlg = null;
	/* Column Info */
	private String oprPreChkCd = null;
	/* Column Info */
	private String grsWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DgBkgInfoVO() {}

	public DgBkgInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String bkgStsCd, String vslCd, String vesselNm, String rcvTermCd, String deTermCd, String polCd, String polNodCd, String podCd, String podNodCd, String porCd, String delCd, String cmdtCd, String cmdtNm, String flexHgtFlg, String slanCd, String destTrnsModCd, String corrN1stDt, String corrNo, String bdrFlg, String grsWgt, String wgtUtCd, String vslPrePstCd, String imgFlg, String crrPreChkCd, String oprPreChkCd, String segrPreChkCd, String pckPreChkCd) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.destTrnsModCd = destTrnsModCd;
		this.imgFlg = imgFlg;
		this.bkgStsCd = bkgStsCd;
		this.bdrFlg = bdrFlg;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.pckPreChkCd = pckPreChkCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.cmdtCd = cmdtCd;
		this.crrPreChkCd = crrPreChkCd;
		this.wgtUtCd = wgtUtCd;
		this.vslPrePstCd = vslPrePstCd;
		this.rcvTermCd = rcvTermCd;
		this.segrPreChkCd = segrPreChkCd;
		this.vesselNm = vesselNm;
		this.delCd = delCd;
		this.corrNo = corrNo;
		this.polNodCd = polNodCd;
		this.cmdtNm = cmdtNm;
		this.corrN1stDt = corrN1stDt;
		this.podCd = podCd;
		this.deTermCd = deTermCd;
		this.podNodCd = podNodCd;
		this.bkgNo = bkgNo;
		this.slanCd = slanCd;
		this.flexHgtFlg = flexHgtFlg;
		this.oprPreChkCd = oprPreChkCd;
		this.grsWgt = grsWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("dest_trns_mod_cd", getDestTrnsModCd());
		this.hashColumns.put("img_flg", getImgFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pck_pre_chk_cd", getPckPreChkCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cmdt_cd", getCmdtCd());
		this.hashColumns.put("crr_pre_chk_cd", getCrrPreChkCd());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("vsl_pre_pst_cd", getVslPrePstCd());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("segr_pre_chk_cd", getSegrPreChkCd());
		this.hashColumns.put("vessel_nm", getVesselNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("corr_no", getCorrNo());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("cmdt_nm", getCmdtNm());
		this.hashColumns.put("corr_n1st_dt", getCorrN1stDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("flex_hgt_flg", getFlexHgtFlg());
		this.hashColumns.put("opr_pre_chk_cd", getOprPreChkCd());
		this.hashColumns.put("grs_wgt", getGrsWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("dest_trns_mod_cd", "destTrnsModCd");
		this.hashFields.put("img_flg", "imgFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pck_pre_chk_cd", "pckPreChkCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cmdt_cd", "cmdtCd");
		this.hashFields.put("crr_pre_chk_cd", "crrPreChkCd");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("vsl_pre_pst_cd", "vslPrePstCd");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("segr_pre_chk_cd", "segrPreChkCd");
		this.hashFields.put("vessel_nm", "vesselNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("corr_no", "corrNo");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("cmdt_nm", "cmdtNm");
		this.hashFields.put("corr_n1st_dt", "corrN1stDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("flex_hgt_flg", "flexHgtFlg");
		this.hashFields.put("opr_pre_chk_cd", "oprPreChkCd");
		this.hashFields.put("grs_wgt", "grsWgt");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return destTrnsModCd
	 */
	public String getDestTrnsModCd() {
		return this.destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @return imgFlg
	 */
	public String getImgFlg() {
		return this.imgFlg;
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
	 * @return bdrFlg
	 */
	public String getBdrFlg() {
		return this.bdrFlg;
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
	 * @return pckPreChkCd
	 */
	public String getPckPreChkCd() {
		return this.pckPreChkCd;
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
	 * @return cmdtCd
	 */
	public String getCmdtCd() {
		return this.cmdtCd;
	}
	
	/**
	 * Column Info
	 * @return crrPreChkCd
	 */
	public String getCrrPreChkCd() {
		return this.crrPreChkCd;
	}
	
	/**
	 * Column Info
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return vslPrePstCd
	 */
	public String getVslPrePstCd() {
		return this.vslPrePstCd;
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
	 * @return segrPreChkCd
	 */
	public String getSegrPreChkCd() {
		return this.segrPreChkCd;
	}
	
	/**
	 * Column Info
	 * @return vesselNm
	 */
	public String getVesselNm() {
		return this.vesselNm;
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
	 * @return corrNo
	 */
	public String getCorrNo() {
		return this.corrNo;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return cmdtNm
	 */
	public String getCmdtNm() {
		return this.cmdtNm;
	}
	
	/**
	 * Column Info
	 * @return corrN1stDt
	 */
	public String getCorrN1stDt() {
		return this.corrN1stDt;
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
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
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
	 * @return flexHgtFlg
	 */
	public String getFlexHgtFlg() {
		return this.flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @return oprPreChkCd
	 */
	public String getOprPreChkCd() {
		return this.oprPreChkCd;
	}
	
	/**
	 * Column Info
	 * @return grsWgt
	 */
	public String getGrsWgt() {
		return this.grsWgt;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param destTrnsModCd
	 */
	public void setDestTrnsModCd(String destTrnsModCd) {
		this.destTrnsModCd = destTrnsModCd;
	}
	
	/**
	 * Column Info
	 * @param imgFlg
	 */
	public void setImgFlg(String imgFlg) {
		this.imgFlg = imgFlg;
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
	 * @param bdrFlg
	 */
	public void setBdrFlg(String bdrFlg) {
		this.bdrFlg = bdrFlg;
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
	 * @param pckPreChkCd
	 */
	public void setPckPreChkCd(String pckPreChkCd) {
		this.pckPreChkCd = pckPreChkCd;
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
	 * @param cmdtCd
	 */
	public void setCmdtCd(String cmdtCd) {
		this.cmdtCd = cmdtCd;
	}
	
	/**
	 * Column Info
	 * @param crrPreChkCd
	 */
	public void setCrrPreChkCd(String crrPreChkCd) {
		this.crrPreChkCd = crrPreChkCd;
	}
	
	/**
	 * Column Info
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param vslPrePstCd
	 */
	public void setVslPrePstCd(String vslPrePstCd) {
		this.vslPrePstCd = vslPrePstCd;
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
	 * @param segrPreChkCd
	 */
	public void setSegrPreChkCd(String segrPreChkCd) {
		this.segrPreChkCd = segrPreChkCd;
	}
	
	/**
	 * Column Info
	 * @param vesselNm
	 */
	public void setVesselNm(String vesselNm) {
		this.vesselNm = vesselNm;
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
	 * @param corrNo
	 */
	public void setCorrNo(String corrNo) {
		this.corrNo = corrNo;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param cmdtNm
	 */
	public void setCmdtNm(String cmdtNm) {
		this.cmdtNm = cmdtNm;
	}
	
	/**
	 * Column Info
	 * @param corrN1stDt
	 */
	public void setCorrN1stDt(String corrN1stDt) {
		this.corrN1stDt = corrN1stDt;
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
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
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
	 * @param flexHgtFlg
	 */
	public void setFlexHgtFlg(String flexHgtFlg) {
		this.flexHgtFlg = flexHgtFlg;
	}
	
	/**
	 * Column Info
	 * @param oprPreChkCd
	 */
	public void setOprPreChkCd(String oprPreChkCd) {
		this.oprPreChkCd = oprPreChkCd;
	}
	
	/**
	 * Column Info
	 * @param grsWgt
	 */
	public void setGrsWgt(String grsWgt) {
		this.grsWgt = grsWgt;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setDestTrnsModCd(JSPUtil.getParameter(request, prefix + "dest_trns_mod_cd", ""));
		setImgFlg(JSPUtil.getParameter(request, prefix + "img_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, prefix + "bkg_sts_cd", ""));
		setBdrFlg(JSPUtil.getParameter(request, prefix + "bdr_flg", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPckPreChkCd(JSPUtil.getParameter(request, prefix + "pck_pre_chk_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCmdtCd(JSPUtil.getParameter(request, prefix + "cmdt_cd", ""));
		setCrrPreChkCd(JSPUtil.getParameter(request, prefix + "crr_pre_chk_cd", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setVslPrePstCd(JSPUtil.getParameter(request, prefix + "vsl_pre_pst_cd", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setSegrPreChkCd(JSPUtil.getParameter(request, prefix + "segr_pre_chk_cd", ""));
		setVesselNm(JSPUtil.getParameter(request, prefix + "vessel_nm", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setCorrNo(JSPUtil.getParameter(request, prefix + "corr_no", ""));
		setPolNodCd(JSPUtil.getParameter(request, prefix + "pol_nod_cd", ""));
		setCmdtNm(JSPUtil.getParameter(request, prefix + "cmdt_nm", ""));
		setCorrN1stDt(JSPUtil.getParameter(request, prefix + "corr_n1st_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setPodNodCd(JSPUtil.getParameter(request, prefix + "pod_nod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setFlexHgtFlg(JSPUtil.getParameter(request, prefix + "flex_hgt_flg", ""));
		setOprPreChkCd(JSPUtil.getParameter(request, prefix + "opr_pre_chk_cd", ""));
		setGrsWgt(JSPUtil.getParameter(request, prefix + "grs_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DgBkgInfoVO[]
	 */
	public DgBkgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DgBkgInfoVO[]
	 */
	public DgBkgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DgBkgInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] destTrnsModCd = (JSPUtil.getParameter(request, prefix	+ "dest_trns_mod_cd", length));
			String[] imgFlg = (JSPUtil.getParameter(request, prefix	+ "img_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] pckPreChkCd = (JSPUtil.getParameter(request, prefix	+ "pck_pre_chk_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cmdtCd = (JSPUtil.getParameter(request, prefix	+ "cmdt_cd", length));
			String[] crrPreChkCd = (JSPUtil.getParameter(request, prefix	+ "crr_pre_chk_cd", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] vslPrePstCd = (JSPUtil.getParameter(request, prefix	+ "vsl_pre_pst_cd", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] segrPreChkCd = (JSPUtil.getParameter(request, prefix	+ "segr_pre_chk_cd", length));
			String[] vesselNm = (JSPUtil.getParameter(request, prefix	+ "vessel_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] corrNo = (JSPUtil.getParameter(request, prefix	+ "corr_no", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] cmdtNm = (JSPUtil.getParameter(request, prefix	+ "cmdt_nm", length));
			String[] corrN1stDt = (JSPUtil.getParameter(request, prefix	+ "corr_n1st_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] flexHgtFlg = (JSPUtil.getParameter(request, prefix	+ "flex_hgt_flg", length));
			String[] oprPreChkCd = (JSPUtil.getParameter(request, prefix	+ "opr_pre_chk_cd", length));
			String[] grsWgt = (JSPUtil.getParameter(request, prefix	+ "grs_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new DgBkgInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (destTrnsModCd[i] != null)
					model.setDestTrnsModCd(destTrnsModCd[i]);
				if (imgFlg[i] != null)
					model.setImgFlg(imgFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (pckPreChkCd[i] != null)
					model.setPckPreChkCd(pckPreChkCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cmdtCd[i] != null)
					model.setCmdtCd(cmdtCd[i]);
				if (crrPreChkCd[i] != null)
					model.setCrrPreChkCd(crrPreChkCd[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (vslPrePstCd[i] != null)
					model.setVslPrePstCd(vslPrePstCd[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (segrPreChkCd[i] != null)
					model.setSegrPreChkCd(segrPreChkCd[i]);
				if (vesselNm[i] != null)
					model.setVesselNm(vesselNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (corrNo[i] != null)
					model.setCorrNo(corrNo[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (cmdtNm[i] != null)
					model.setCmdtNm(cmdtNm[i]);
				if (corrN1stDt[i] != null)
					model.setCorrN1stDt(corrN1stDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (flexHgtFlg[i] != null)
					model.setFlexHgtFlg(flexHgtFlg[i]);
				if (oprPreChkCd[i] != null)
					model.setOprPreChkCd(oprPreChkCd[i]);
				if (grsWgt[i] != null)
					model.setGrsWgt(grsWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDgBkgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DgBkgInfoVO[]
	 */
	public DgBkgInfoVO[] getDgBkgInfoVOs(){
		DgBkgInfoVO[] vos = (DgBkgInfoVO[])models.toArray(new DgBkgInfoVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.destTrnsModCd = this.destTrnsModCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imgFlg = this.imgFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckPreChkCd = this.pckPreChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtCd = this.cmdtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.crrPreChkCd = this.crrPreChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslPrePstCd = this.vslPrePstCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.segrPreChkCd = this.segrPreChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselNm = this.vesselNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrNo = this.corrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cmdtNm = this.cmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.corrN1stDt = this.corrN1stDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flexHgtFlg = this.flexHgtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprPreChkCd = this.oprPreChkCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grsWgt = this.grsWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
