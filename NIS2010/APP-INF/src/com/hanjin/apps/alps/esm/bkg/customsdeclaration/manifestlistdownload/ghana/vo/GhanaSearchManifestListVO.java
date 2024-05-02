/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GhanaSearchManifestListVO.java
*@FileTitle : GhanaSearchManifestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.20
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.20  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ghana.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
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

public class GhanaSearchManifestListVO extends ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<GhanaSearchManifestListVO> models = new ArrayList<GhanaSearchManifestListVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String ghtemCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String bvPodCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String hotDeFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String bvPolCd = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String mfSndDt = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String termCd = null;
	/* Column Info */
	private String totalBl = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String rcFlg = null;
	/* Column Info */
	private String vvdNumber = null;
	/* Column Info */
	private String mfsndCode = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GhanaSearchManifestListVO() {}

	public GhanaSearchManifestListVO(String ibflag, String pagerows, String vvdNumber, String bkgNo, String blNo, String mfsndCode, String termCd, String ghtemCd, String porCd, String bvPolCd, String bvPodCd, String delCd, String actWgt, String wgtUtCd, String pckQty, String vvdCd, String frtTermCd, String hotDeFlg, String rcFlg, String mfSndDt, String totalBl, String polCd, String podCd, String blTpCd) {
		this.porCd = porCd;
		this.frtTermCd = frtTermCd;
		this.ghtemCd = ghtemCd;
		this.delCd = delCd;
		this.bvPodCd = bvPodCd;
		this.blNo = blNo;
		this.blTpCd = blTpCd;
		this.hotDeFlg = hotDeFlg;
		this.pagerows = pagerows;
		this.bvPolCd = bvPolCd;
		this.actWgt = actWgt;
		this.podCd = podCd;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.vvdCd = vvdCd;
		this.mfSndDt = mfSndDt;
		this.wgtUtCd = wgtUtCd;
		this.termCd = termCd;
		this.totalBl = totalBl;
		this.pckQty = pckQty;
		this.rcFlg = rcFlg;
		this.vvdNumber = vvdNumber;
		this.mfsndCode = mfsndCode;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("ghtem_cd", getGhtemCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bv_pod_cd", getBvPodCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("hot_de_flg", getHotDeFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("bv_pol_cd", getBvPolCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("mf_snd_dt", getMfSndDt());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("term_cd", getTermCd());
		this.hashColumns.put("total_bl", getTotalBl());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("rc_flg", getRcFlg());
		this.hashColumns.put("vvd_number", getVvdNumber());
		this.hashColumns.put("mfsnd_code", getMfsndCode());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("ghtem_cd", "ghtemCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bv_pod_cd", "bvPodCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("hot_de_flg", "hotDeFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("bv_pol_cd", "bvPolCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("mf_snd_dt", "mfSndDt");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("term_cd", "termCd");
		this.hashFields.put("total_bl", "totalBl");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("rc_flg", "rcFlg");
		this.hashFields.put("vvd_number", "vvdNumber");
		this.hashFields.put("mfsnd_code", "mfsndCode");
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
	 * @return frtTermCd
	 */
	public String getFrtTermCd() {
		return this.frtTermCd;
	}
	
	/**
	 * Column Info
	 * @return ghtemCd
	 */
	public String getGhtemCd() {
		return this.ghtemCd;
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
	 * @return bvPodCd
	 */
	public String getBvPodCd() {
		return this.bvPodCd;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return hotDeFlg
	 */
	public String getHotDeFlg() {
		return this.hotDeFlg;
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
	 * @return bvPolCd
	 */
	public String getBvPolCd() {
		return this.bvPolCd;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return mfSndDt
	 */
	public String getMfSndDt() {
		return this.mfSndDt;
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
	 * @return termCd
	 */
	public String getTermCd() {
		return this.termCd;
	}
	
	/**
	 * Column Info
	 * @return totalBl
	 */
	public String getTotalBl() {
		return this.totalBl;
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
	 * @return rcFlg
	 */
	public String getRcFlg() {
		return this.rcFlg;
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
	 * @return mfsndCode
	 */
	public String getMfsndCode() {
		return this.mfsndCode;
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
	 * @param frtTermCd
	 */
	public void setFrtTermCd(String frtTermCd) {
		this.frtTermCd = frtTermCd;
	}
	
	/**
	 * Column Info
	 * @param ghtemCd
	 */
	public void setGhtemCd(String ghtemCd) {
		this.ghtemCd = ghtemCd;
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
	 * @param bvPodCd
	 */
	public void setBvPodCd(String bvPodCd) {
		this.bvPodCd = bvPodCd;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param hotDeFlg
	 */
	public void setHotDeFlg(String hotDeFlg) {
		this.hotDeFlg = hotDeFlg;
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
	 * @param bvPolCd
	 */
	public void setBvPolCd(String bvPolCd) {
		this.bvPolCd = bvPolCd;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param mfSndDt
	 */
	public void setMfSndDt(String mfSndDt) {
		this.mfSndDt = mfSndDt;
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
	 * @param termCd
	 */
	public void setTermCd(String termCd) {
		this.termCd = termCd;
	}
	
	/**
	 * Column Info
	 * @param totalBl
	 */
	public void setTotalBl(String totalBl) {
		this.totalBl = totalBl;
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
	 * @param rcFlg
	 */
	public void setRcFlg(String rcFlg) {
		this.rcFlg = rcFlg;
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
	 * @param mfsndCode
	 */
	public void setMfsndCode(String mfsndCode) {
		this.mfsndCode = mfsndCode;
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
		setFrtTermCd(JSPUtil.getParameter(request, prefix + "frt_term_cd", ""));
		setGhtemCd(JSPUtil.getParameter(request, prefix + "ghtem_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setBvPodCd(JSPUtil.getParameter(request, prefix + "bv_pod_cd", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setBlTpCd(JSPUtil.getParameter(request, prefix + "bl_tp_cd", ""));
		setHotDeFlg(JSPUtil.getParameter(request, prefix + "hot_de_flg", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setBvPolCd(JSPUtil.getParameter(request, prefix + "bv_pol_cd", ""));
		setActWgt(JSPUtil.getParameter(request, prefix + "act_wgt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setVvdCd(JSPUtil.getParameter(request, prefix + "vvd_cd", ""));
		setMfSndDt(JSPUtil.getParameter(request, prefix + "mf_snd_dt", ""));
		setWgtUtCd(JSPUtil.getParameter(request, prefix + "wgt_ut_cd", ""));
		setTermCd(JSPUtil.getParameter(request, prefix + "term_cd", ""));
		setTotalBl(JSPUtil.getParameter(request, prefix + "total_bl", ""));
		setPckQty(JSPUtil.getParameter(request, prefix + "pck_qty", ""));
		setRcFlg(JSPUtil.getParameter(request, prefix + "rc_flg", ""));
		setVvdNumber(JSPUtil.getParameter(request, prefix + "vvd_number", ""));
		setMfsndCode(JSPUtil.getParameter(request, prefix + "mfsnd_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GhanaSearchManifestListVO[]
	 */
	public GhanaSearchManifestListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return GhanaSearchManifestListVO[]
	 */
	public GhanaSearchManifestListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GhanaSearchManifestListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] ghtemCd = (JSPUtil.getParameter(request, prefix	+ "ghtem_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] bvPodCd = (JSPUtil.getParameter(request, prefix	+ "bv_pod_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] hotDeFlg = (JSPUtil.getParameter(request, prefix	+ "hot_de_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] bvPolCd = (JSPUtil.getParameter(request, prefix	+ "bv_pol_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] termCd = (JSPUtil.getParameter(request, prefix	+ "term_cd", length));
			String[] totalBl = (JSPUtil.getParameter(request, prefix	+ "total_bl", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number", length));
			String[] mfsndCode = (JSPUtil.getParameter(request, prefix	+ "mfsnd_code", length));
			
			for (int i = 0; i < length; i++) {
				model = new GhanaSearchManifestListVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (ghtemCd[i] != null)
					model.setGhtemCd(ghtemCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (bvPodCd[i] != null)
					model.setBvPodCd(bvPodCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (hotDeFlg[i] != null)
					model.setHotDeFlg(hotDeFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (bvPolCd[i] != null)
					model.setBvPolCd(bvPolCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (mfSndDt[i] != null)
					model.setMfSndDt(mfSndDt[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (termCd[i] != null)
					model.setTermCd(termCd[i]);
				if (totalBl[i] != null)
					model.setTotalBl(totalBl[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (rcFlg[i] != null)
					model.setRcFlg(rcFlg[i]);
				if (vvdNumber[i] != null)
					model.setVvdNumber(vvdNumber[i]);
				if (mfsndCode[i] != null)
					model.setMfsndCode(mfsndCode[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGhanaSearchManifestListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GhanaSearchManifestListVO[]
	 */
	public GhanaSearchManifestListVO[] getGhanaSearchManifestListVOs(){
		GhanaSearchManifestListVO[] vos = (GhanaSearchManifestListVO[])models.toArray(new GhanaSearchManifestListVO[models.size()]);
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
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ghtemCd = this.ghtemCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bvPodCd = this.bvPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hotDeFlg = this.hotDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bvPolCd = this.bvPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfSndDt = this.mfSndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.termCd = this.termCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalBl = this.totalBl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcFlg = this.rcFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNumber = this.vvdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mfsndCode = this.mfsndCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
