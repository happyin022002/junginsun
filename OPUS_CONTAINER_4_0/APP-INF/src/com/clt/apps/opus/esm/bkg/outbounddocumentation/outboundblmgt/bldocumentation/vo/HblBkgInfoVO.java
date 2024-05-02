/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : HblBkgInfoVO.java
*@FileTitle : HblBkgInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.14
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2010.01.14 김영출 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo;

import java.lang.reflect.Field;
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
 * @author 김영출
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class HblBkgInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HblBkgInfoVO> models = new ArrayList<HblBkgInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String orgBlNo = null;
	/* Column Info */
	private String bdrFlg = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String usaCstmsFileCd = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String bkgMkDesc = null;
	/* Column Info */
	private String htsFlg = null;
	/* Column Info */
	private String cndFlg = null;
	/* Column Info */
	private String bkgCstmsDesc = null;
	/* Column Info */
	private String cndCstmsFileCd = null;
	/* Column Info */
	private String bkgPckQty = null;
	/* Column Info */
	private String bkgPckUnit = null;
	/* Column Info */
	private String bkgWgtQty = null;
	/* Column Info */
	private String bkgWgtUnit = null;
	/* Column Info */
	private String bkgMeasQty = null;
	/* Column Info */
	private String bkgMeasUnit = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public HblBkgInfoVO() {}

	public HblBkgInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String blTpCd, String orgBlNo, String porCd, String polCd, String podCd, String delCd, String usaCstmsFileCd, String cndCstmsFileCd, String cndFlg, String htsFlg, String bkgStsCd, String bdrFlg, String caFlg, String bkgMkDesc, String bkgCstmsDesc, String bkgPckQty, String bkgPckUnit, String bkgWgtQty, String bkgWgtUnit, String bkgMeasQty, String bkgMeasUnit) {
		this.porCd = porCd;
		this.orgBlNo = orgBlNo;
		this.bdrFlg = bdrFlg;
		this.bkgStsCd = bkgStsCd;
		this.delCd = delCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.blTpCd = blTpCd;
		this.usaCstmsFileCd = usaCstmsFileCd;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.caFlg = caFlg;
		this.bkgMkDesc = bkgMkDesc;
		this.htsFlg = htsFlg;
		this.cndFlg = cndFlg;
		this.bkgCstmsDesc = bkgCstmsDesc;
		this.cndCstmsFileCd = cndCstmsFileCd;
		this.bkgPckQty = bkgPckQty;
		this.bkgPckUnit = bkgPckUnit;
		this.bkgWgtQty = bkgWgtQty;
		this.bkgWgtUnit = bkgWgtUnit;
		this.bkgMeasQty = bkgMeasQty;
		this.bkgMeasUnit = bkgMeasUnit;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("org_bl_no", getOrgBlNo());
		this.hashColumns.put("bdr_flg", getBdrFlg());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("usa_cstms_file_cd", getUsaCstmsFileCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("bkg_mk_desc", getBkgMkDesc());
		this.hashColumns.put("hts_flg", getHtsFlg());
		this.hashColumns.put("cnd_flg", getCndFlg());
		this.hashColumns.put("bkg_cstms_desc", getBkgCstmsDesc());
		this.hashColumns.put("cnd_cstms_file_cd", getCndCstmsFileCd());
		this.hashColumns.put("bkg_pck_qty", getBkgPckQty());
		this.hashColumns.put("bkg_pck_unit", getBkgPckUnit());
		this.hashColumns.put("bkg_wgt_qty", getBkgWgtQty());
		this.hashColumns.put("bkg_wgt_unit", getBkgWgtUnit());
		this.hashColumns.put("bkg_meas_qty", getBkgMeasQty());
		this.hashColumns.put("bkg_meas_unit", getBkgMeasUnit());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("org_bl_no", "orgBlNo");
		this.hashFields.put("bdr_flg", "bdrFlg");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("usa_cstms_file_cd", "usaCstmsFileCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("bkg_mk_desc", "bkgMkDesc");
		this.hashFields.put("hts_flg", "htsFlg");
		this.hashFields.put("cnd_flg", "cndFlg");
		this.hashFields.put("bkg_cstms_desc", "bkgCstmsDesc");
		this.hashFields.put("cnd_cstms_file_cd", "cndCstmsFileCd");
		this.hashFields.put("bkg_pck_qty", "bkgPckQty");
		this.hashFields.put("bkg_pck_unit", "bkgPckUnit");
		this.hashFields.put("bkg_wgt_qty", "bkgWgtQty");
		this.hashFields.put("bkg_wgt_unit", "bkgWgtUnit");
		this.hashFields.put("bkg_meas_qty", "bkgMeasQty");
		this.hashFields.put("bkg_meas_unit", "bkgMeasUnit");
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
	 * @return orgBlNo
	 */
	public String getOrgBlNo() {
		return this.orgBlNo;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return usaCstmsFileCd
	 */
	public String getUsaCstmsFileCd() {
		return this.usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
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
	 * @return caFlg
	 */
	public String getCaFlg() {
		return this.caFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgMkDesc
	 */
	public String getBkgMkDesc() {
		return this.bkgMkDesc;
	}
	
	/**
	 * Column Info
	 * @return htsFlg
	 */
	public String getHtsFlg() {
		return this.htsFlg;
	}
	
	/**
	 * Column Info
	 * @return cndFlg
	 */
	public String getCndFlg() {
		return this.cndFlg;
	}
	
	/**
	 * Column Info
	 * @return bkgCstmsDesc
	 */
	public String getBkgCstmsDesc() {
		return this.bkgCstmsDesc;
	}
	
	/**
	 * Column Info
	 * @return cndCstmsFileCd
	 */
	public String getCndCstmsFileCd() {
		return this.cndCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @return bkgPckQty
	 */
	public String getBkgPckQty() {
		return this.bkgPckQty;
	}
	
	/**
	 * Column Info
	 * @return bkgPckUnit
	 */
	public String getBkgPckUnit() {
		return this.bkgPckUnit;
	}
	
	/**
	 * Column Info
	 * @return bkgWgtQty
	 */
	public String getBkgWgtQty() {
		return this.bkgWgtQty;
	}
	
	/**
	 * Column Info
	 * @return bkgWgtUnit
	 */
	public String getBkgWgtUnit() {
		return this.bkgWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return bkgMeasQty
	 */
	public String getBkgMeasQty() {
		return this.bkgMeasQty;
	}
	
	/**
	 * Column Info
	 * @return bkgMeasUnit
	 */
	public String getBkgMeasUnit() {
		return this.bkgMeasUnit;
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
	 * @param orgBlNo
	 */
	public void setOrgBlNo(String orgBlNo) {
		this.orgBlNo = orgBlNo;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param usaCstmsFileCd
	 */
	public void setUsaCstmsFileCd(String usaCstmsFileCd) {
		this.usaCstmsFileCd = usaCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
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
	 * @param caFlg
	 */
	public void setCaFlg(String caFlg) {
		this.caFlg = caFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgMkDesc
	 */
	public void setBkgMkDesc(String bkgMkDesc) {
		this.bkgMkDesc = bkgMkDesc;
	}
	
	/**
	 * Column Info
	 * @param htsFlg
	 */
	public void setHtsFlg(String htsFlg) {
		this.htsFlg = htsFlg;
	}
	
	/**
	 * Column Info
	 * @param cndFlg
	 */
	public void setCndFlg(String cndFlg) {
		this.cndFlg = cndFlg;
	}
	
	/**
	 * Column Info
	 * @param bkgCstmsDesc
	 */
	public void setBkgCstmsDesc(String bkgCstmsDesc) {
		this.bkgCstmsDesc = bkgCstmsDesc;
	}
	
	/**
	 * Column Info
	 * @param cndCstmsFileCd
	 */
	public void setCndCstmsFileCd(String cndCstmsFileCd) {
		this.cndCstmsFileCd = cndCstmsFileCd;
	}
	
	/**
	 * Column Info
	 * @param bkgPckQty
	 */
	public void setBkgPckQty(String bkgPckQty) {
		this.bkgPckQty = bkgPckQty;
	}
	
	/**
	 * Column Info
	 * @param bkgPckUnit
	 */
	public void setBkgPckUnit(String bkgPckUnit) {
		this.bkgPckUnit = bkgPckUnit;
	}
	
	/**
	 * Column Info
	 * @param bkgWgtQty
	 */
	public void setBkgWgtQty(String bkgWgtQty) {
		this.bkgWgtQty = bkgWgtQty;
	}
	
	/**
	 * Column Info
	 * @param bkgWgtUnit
	 */
	public void setBkgWgtUnit(String bkgWgtUnit) {
		this.bkgWgtUnit = bkgWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param bkgMeasQty
	 */
	public void setBkgMeasQty(String bkgMeasQty) {
		this.bkgMeasQty = bkgMeasQty;
	}
	
	/**
	 * Column Info
	 * @param bkgMeasUnit
	 */
	public void setBkgMeasUnit(String bkgMeasUnit) {
		this.bkgMeasUnit = bkgMeasUnit;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setOrgBlNo(JSPUtil.getParameter(request, "org_bl_no", ""));
		setBdrFlg(JSPUtil.getParameter(request, "bdr_flg", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setUsaCstmsFileCd(JSPUtil.getParameter(request, "usa_cstms_file_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setCaFlg(JSPUtil.getParameter(request, "ca_flg", ""));
		setBkgMkDesc(JSPUtil.getParameter(request, "bkg_mk_desc", ""));
		setHtsFlg(JSPUtil.getParameter(request, "hts_flg", ""));
		setCndFlg(JSPUtil.getParameter(request, "cnd_flg", ""));
		setBkgCstmsDesc(JSPUtil.getParameter(request, "bkg_cstms_desc", ""));
		setCndCstmsFileCd(JSPUtil.getParameter(request, "cnd_cstms_file_cd", ""));
		setBkgPckQty(JSPUtil.getParameter(request, "bkg_pck_qty", ""));
		setBkgPckUnit(JSPUtil.getParameter(request, "bkg_pck_unit", ""));
		setBkgWgtQty(JSPUtil.getParameter(request, "bkg_wgt_qty", ""));
		setBkgWgtUnit(JSPUtil.getParameter(request, "bkg_wgt_unit", ""));
		setBkgMeasQty(JSPUtil.getParameter(request, "bkg_meas_qty", ""));
		setBkgMeasUnit(JSPUtil.getParameter(request, "bkg_meas_unit", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HblBkgInfoVO[]
	 */
	public HblBkgInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HblBkgInfoVO[]
	 */
	public HblBkgInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HblBkgInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] orgBlNo = (JSPUtil.getParameter(request, prefix	+ "org_bl_no", length));
			String[] bdrFlg = (JSPUtil.getParameter(request, prefix	+ "bdr_flg", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] usaCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "usa_cstms_file_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] bkgMkDesc = (JSPUtil.getParameter(request, prefix	+ "bkg_mk_desc", length));
			String[] htsFlg = (JSPUtil.getParameter(request, prefix	+ "hts_flg", length));
			String[] cndFlg = (JSPUtil.getParameter(request, prefix	+ "cnd_flg", length));
			String[] bkgCstmsDesc = (JSPUtil.getParameter(request, prefix	+ "bkg_cstms_desc", length));
			String[] cndCstmsFileCd = (JSPUtil.getParameter(request, prefix	+ "cnd_cstms_file_cd", length));
			String[] bkgPckQty = (JSPUtil.getParameter(request, prefix	+ "bkg_pck_qty", length));
			String[] bkgPckUnit = (JSPUtil.getParameter(request, prefix	+ "bkg_pck_unit", length));
			String[] bkgWgtQty = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_qty", length));
			String[] bkgWgtUnit = (JSPUtil.getParameter(request, prefix	+ "bkg_wgt_unit", length));
			String[] bkgMeasQty = (JSPUtil.getParameter(request, prefix	+ "bkg_meas_qty", length));
			String[] bkgMeasUnit = (JSPUtil.getParameter(request, prefix	+ "bkg_meas_unit", length));
			
			for (int i = 0; i < length; i++) {
				model = new HblBkgInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (orgBlNo[i] != null)
					model.setOrgBlNo(orgBlNo[i]);
				if (bdrFlg[i] != null)
					model.setBdrFlg(bdrFlg[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (usaCstmsFileCd[i] != null)
					model.setUsaCstmsFileCd(usaCstmsFileCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (bkgMkDesc[i] != null)
					model.setBkgMkDesc(bkgMkDesc[i]);
				if (htsFlg[i] != null)
					model.setHtsFlg(htsFlg[i]);
				if (cndFlg[i] != null)
					model.setCndFlg(cndFlg[i]);
				if (bkgCstmsDesc[i] != null)
					model.setBkgCstmsDesc(bkgCstmsDesc[i]);
				if (cndCstmsFileCd[i] != null)
					model.setCndCstmsFileCd(cndCstmsFileCd[i]);
				if (bkgPckQty[i] != null)
					model.setBkgPckQty(bkgPckQty[i]);
				if (bkgPckUnit[i] != null)
					model.setBkgPckUnit(bkgPckUnit[i]);
				if (bkgWgtQty[i] != null)
					model.setBkgWgtQty(bkgWgtQty[i]);
				if (bkgWgtUnit[i] != null)
					model.setBkgWgtUnit(bkgWgtUnit[i]);
				if (bkgMeasQty[i] != null)
					model.setBkgMeasQty(bkgMeasQty[i]);
				if (bkgMeasUnit[i] != null)
					model.setBkgMeasUnit(bkgMeasUnit[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getHblBkgInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HblBkgInfoVO[]
	 */
	public HblBkgInfoVO[] getHblBkgInfoVOs(){
		HblBkgInfoVO[] vos = (HblBkgInfoVO[])models.toArray(new HblBkgInfoVO[models.size()]);
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
		this.orgBlNo = this.orgBlNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrFlg = this.bdrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usaCstmsFileCd = this.usaCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMkDesc = this.bkgMkDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.htsFlg = this.htsFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndFlg = this.cndFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCstmsDesc = this.bkgCstmsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cndCstmsFileCd = this.cndCstmsFileCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPckQty = this.bkgPckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPckUnit = this.bkgPckUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgtQty = this.bkgWgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgWgtUnit = this.bkgWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMeasQty = this.bkgMeasQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgMeasUnit = this.bkgMeasUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
