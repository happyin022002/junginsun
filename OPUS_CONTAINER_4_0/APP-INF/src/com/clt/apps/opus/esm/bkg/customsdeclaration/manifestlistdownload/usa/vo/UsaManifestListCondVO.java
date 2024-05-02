/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaManifestListCondVO.java
*@FileTitle : UsaManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class UsaManifestListCondVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<UsaManifestListCondVO> models = new ArrayList<UsaManifestListCondVO>();
	
	/* Column Info */
	private String total = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bkgCgoTpCd = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String blNos = null;
	/* Column Info */
	private String usrId = null;
	/* Column Info */
	private String caFlg = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String customs = null;
	/* Column Info */
	private String cstmsPortCd = null;
	/* Column Info */
	private String blType = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String caIssDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String sheetId = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String pageNo = null;
	/* Column Info */
	private String caNo = null;
	/* Column Info */
	private String allPol = null;
	/* Column Info */
	private String customsCd = null;
	/* Column Info */
	private String cntCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public UsaManifestListCondVO() {}

	public UsaManifestListCondVO(String ibflag, String pagerows, String total, String vslCd, String bkgCgoTpCd, String blType, String delCd, String skdVoyNo, String blNo, String skdDirCd, String caIssDt, String podCd, String bkgNo, String sheetId, String polCd, String podNodCd, String blNos, String pageNo, String caNo, String caFlg, String delNodCd, String customs, String cstmsPortCd, String allPol, String usrId, String customsCd, String cntCd) {
		this.total = total;
		this.vslCd = vslCd;
		this.bkgCgoTpCd = bkgCgoTpCd;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.blNos = blNos;
		this.usrId = usrId;
		this.caFlg = caFlg;
		this.delNodCd = delNodCd;
		this.customs = customs;
		this.cstmsPortCd = cstmsPortCd;
		this.blType = blType;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.caIssDt = caIssDt;
		this.bkgNo = bkgNo;
		this.sheetId = sheetId;
		this.podNodCd = podNodCd;
		this.pageNo = pageNo;
		this.caNo = caNo;
		this.allPol = allPol;
		this.customsCd = customsCd;
		this.cntCd = cntCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("total", getTotal());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bkg_cgo_tp_cd", getBkgCgoTpCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("bl_nos", getBlNos());
		this.hashColumns.put("usr_id", getUsrId());
		this.hashColumns.put("ca_flg", getCaFlg());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("customs", getCustoms());
		this.hashColumns.put("cstms_port_cd", getCstmsPortCd());
		this.hashColumns.put("bl_type", getBlType());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ca_iss_dt", getCaIssDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sheet_id", getSheetId());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("page_no", getPageNo());
		this.hashColumns.put("ca_no", getCaNo());
		this.hashColumns.put("all_pol", getAllPol());
		this.hashColumns.put("customs_cd", getCustomsCd());
		this.hashColumns.put("cnt_cd", getCntCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("total", "total");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bkg_cgo_tp_cd", "bkgCgoTpCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("bl_nos", "blNos");
		this.hashFields.put("usr_id", "usrId");
		this.hashFields.put("ca_flg", "caFlg");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("customs", "customs");
		this.hashFields.put("cstms_port_cd", "cstmsPortCd");
		this.hashFields.put("bl_type", "blType");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ca_iss_dt", "caIssDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sheet_id", "sheetId");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("page_no", "pageNo");
		this.hashFields.put("ca_no", "caNo");
		this.hashFields.put("all_pol", "allPol");
		this.hashFields.put("customs_cd", "customsCd");
		this.hashFields.put("cnt_cd", "cntCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return total
	 */
	public String getTotal() {
		return this.total;
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
	 * @return bkgCgoTpCd
	 */
	public String getBkgCgoTpCd() {
		return this.bkgCgoTpCd;
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
	 * @return blNos
	 */
	public String getBlNos() {
		return this.blNos;
	}
	
	/**
	 * Column Info
	 * @return usrId
	 */
	public String getUsrId() {
		return this.usrId;
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
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return customs
	 */
	public String getCustoms() {
		return this.customs;
	}
	
	/**
	 * Column Info
	 * @return cstmsPortCd
	 */
	public String getCstmsPortCd() {
		return this.cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @return blType
	 */
	public String getBlType() {
		return this.blType;
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
	 * @return podCd
	 */
	public String getPodCd() {
		return this.podCd;
	}
	
	/**
	 * Column Info
	 * @return caIssDt
	 */
	public String getCaIssDt() {
		return this.caIssDt;
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
	 * @return sheetId
	 */
	public String getSheetId() {
		return this.sheetId;
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
	 * @return pageNo
	 */
	public String getPageNo() {
		return this.pageNo;
	}
	
	/**
	 * Column Info
	 * @return caNo
	 */
	public String getCaNo() {
		return this.caNo;
	}
	
	/**
	 * Column Info
	 * @return allPol
	 */
	public String getAllPol() {
		return this.allPol;
	}
	
	/**
	 * Column Info
	 * @return customsCd
	 */
	public String getCustomsCd() {
		return this.customsCd;
	}
	
	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}

	/**
	 * Column Info
	 * @param total
	 */
	public void setTotal(String total) {
		this.total = total;
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
	 * @param bkgCgoTpCd
	 */
	public void setBkgCgoTpCd(String bkgCgoTpCd) {
		this.bkgCgoTpCd = bkgCgoTpCd;
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
	 * @param blNos
	 */
	public void setBlNos(String blNos) {
		this.blNos = blNos;
	}
	
	/**
	 * Column Info
	 * @param usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
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
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param customs
	 */
	public void setCustoms(String customs) {
		this.customs = customs;
	}
	
	/**
	 * Column Info
	 * @param cstmsPortCd
	 */
	public void setCstmsPortCd(String cstmsPortCd) {
		this.cstmsPortCd = cstmsPortCd;
	}
	
	/**
	 * Column Info
	 * @param blType
	 */
	public void setBlType(String blType) {
		this.blType = blType;
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
	 * Column Info
	 * @param podCd
	 */
	public void setPodCd(String podCd) {
		this.podCd = podCd;
	}
	
	/**
	 * Column Info
	 * @param caIssDt
	 */
	public void setCaIssDt(String caIssDt) {
		this.caIssDt = caIssDt;
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
	 * @param sheetId
	 */
	public void setSheetId(String sheetId) {
		this.sheetId = sheetId;
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
	 * @param pageNo
	 */
	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}
	
	/**
	 * Column Info
	 * @param caNo
	 */
	public void setCaNo(String caNo) {
		this.caNo = caNo;
	}
	
	/**
	 * Column Info
	 * @param allPol
	 */
	public void setAllPol(String allPol) {
		this.allPol = allPol;
	}
	
	/**
	 * Column Info
	 * @param customsCd
	 */
	public void setCustomsCd(String customsCd) {
		this.customsCd = customsCd;
	}
	
	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setTotal(JSPUtil.getParameter(request, "total", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBkgCgoTpCd(JSPUtil.getParameter(request, "bkg_cgo_tp_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setBlNos(JSPUtil.getParameter(request, "bl_nos", ""));
		setUsrId(JSPUtil.getParameter(request, "usr_id", ""));
		setCaFlg(JSPUtil.getParameter(request, "ca_flg", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
		setCustoms(JSPUtil.getParameter(request, "customs", ""));
		setCstmsPortCd(JSPUtil.getParameter(request, "cstms_port_cd", ""));
		setBlType(JSPUtil.getParameter(request, "bl_type", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setCaIssDt(JSPUtil.getParameter(request, "ca_iss_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setSheetId(JSPUtil.getParameter(request, "sheet_id", ""));
		setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd", ""));
		setPageNo(JSPUtil.getParameter(request, "page_no", ""));
		setCaNo(JSPUtil.getParameter(request, "ca_no", ""));
		setAllPol(JSPUtil.getParameter(request, "all_pol", ""));
		setCustomsCd(JSPUtil.getParameter(request, "customs_cd", ""));
		setCntCd(JSPUtil.getParameter(request, "cnt_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return UsaManifestListCondVO[]
	 */
	public UsaManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return UsaManifestListCondVO[]
	 */
	public UsaManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		UsaManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] total = (JSPUtil.getParameter(request, prefix	+ "total", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bkgCgoTpCd = (JSPUtil.getParameter(request, prefix	+ "bkg_cgo_tp_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] blNos = (JSPUtil.getParameter(request, prefix	+ "bl_nos", length));
			String[] usrId = (JSPUtil.getParameter(request, prefix	+ "usr_id", length));
			String[] caFlg = (JSPUtil.getParameter(request, prefix	+ "ca_flg", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] customs = (JSPUtil.getParameter(request, prefix	+ "customs", length));
			String[] cstmsPortCd = (JSPUtil.getParameter(request, prefix	+ "cstms_port_cd", length));
			String[] blType = (JSPUtil.getParameter(request, prefix	+ "bl_type", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] caIssDt = (JSPUtil.getParameter(request, prefix	+ "ca_iss_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] sheetId = (JSPUtil.getParameter(request, prefix	+ "sheet_id", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] pageNo = (JSPUtil.getParameter(request, prefix	+ "page_no", length));
			String[] caNo = (JSPUtil.getParameter(request, prefix	+ "ca_no", length));
			String[] allPol = (JSPUtil.getParameter(request, prefix	+ "all_pol", length));
			String[] customsCd = (JSPUtil.getParameter(request, prefix	+ "customs_cd", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new UsaManifestListCondVO();
				if (total[i] != null)
					model.setTotal(total[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bkgCgoTpCd[i] != null)
					model.setBkgCgoTpCd(bkgCgoTpCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (blNos[i] != null)
					model.setBlNos(blNos[i]);
				if (usrId[i] != null)
					model.setUsrId(usrId[i]);
				if (caFlg[i] != null)
					model.setCaFlg(caFlg[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (customs[i] != null)
					model.setCustoms(customs[i]);
				if (cstmsPortCd[i] != null)
					model.setCstmsPortCd(cstmsPortCd[i]);
				if (blType[i] != null)
					model.setBlType(blType[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (caIssDt[i] != null)
					model.setCaIssDt(caIssDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (sheetId[i] != null)
					model.setSheetId(sheetId[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (pageNo[i] != null)
					model.setPageNo(pageNo[i]);
				if (caNo[i] != null)
					model.setCaNo(caNo[i]);
				if (allPol[i] != null)
					model.setAllPol(allPol[i]);
				if (customsCd[i] != null)
					model.setCustomsCd(customsCd[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getUsaManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return UsaManifestListCondVO[]
	 */
	public UsaManifestListCondVO[] getUsaManifestListCondVOs(){
		UsaManifestListCondVO[] vos = (UsaManifestListCondVO[])models.toArray(new UsaManifestListCondVO[models.size()]);
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
		this.total = this.total .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgCgoTpCd = this.bkgCgoTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNos = this.blNos .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrId = this.usrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caFlg = this.caFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customs = this.customs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsPortCd = this.cstmsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blType = this.blType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caIssDt = this.caIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sheetId = this.sheetId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pageNo = this.pageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.caNo = this.caNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allPol = this.allPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.customsCd = this.customsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}

