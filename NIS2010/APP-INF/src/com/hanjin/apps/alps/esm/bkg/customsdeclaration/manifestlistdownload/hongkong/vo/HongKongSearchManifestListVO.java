/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : HongKongSearchManifestListVO.java
*@FileTitle : HongKongSearchManifestListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.19
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.08.19 임재택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.hongkong.vo;

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

public class HongKongSearchManifestListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<HongKongSearchManifestListVO> models = new ArrayList<HongKongSearchManifestListVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String frtTermCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String bvPodCd = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String hotDeFlg = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String cnhkgCd = null;
	/* Column Info */
	private String bvPolCd = null;
	/* Column Info */
	private String actWgt = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
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
	
	public HongKongSearchManifestListVO() {}

	public HongKongSearchManifestListVO(String ibflag, String pagerows, String vvdNumber, String bkgNo, String blNo, String mfsndCode, String termCd, String cnhkgCd, String porCd, String bvPolCd, String bvPodCd, String delCd, String actWgt, String wgtUtCd, String pckQty, String vslCd, String skdVoyNo, String skdDirCd, String frtTermCd, String hotDeFlg, String rcFlg, String mfSndDt, String totalBl) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.frtTermCd = frtTermCd;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.bvPodCd = bvPodCd;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.hotDeFlg = hotDeFlg;
		this.pagerows = pagerows;
		this.cnhkgCd = cnhkgCd;
		this.bvPolCd = bvPolCd;
		this.actWgt = actWgt;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
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
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("frt_term_cd", getFrtTermCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("bv_pod_cd", getBvPodCd());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("hot_de_flg", getHotDeFlg());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("cnhkg_cd", getCnhkgCd());
		this.hashColumns.put("bv_pol_cd", getBvPolCd());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
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
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("frt_term_cd", "frtTermCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("bv_pod_cd", "bvPodCd");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("hot_de_flg", "hotDeFlg");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("cnhkg_cd", "cnhkgCd");
		this.hashFields.put("bv_pol_cd", "bvPolCd");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return cnhkgCd
	 */
	public String getCnhkgCd() {
		return this.cnhkgCd;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param cnhkgCd
	 */
	public void setCnhkgCd(String cnhkgCd) {
		this.cnhkgCd = cnhkgCd;
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
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setFrtTermCd(JSPUtil.getParameter(request, "frt_term_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setBvPodCd(JSPUtil.getParameter(request, "bv_pod_cd", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setHotDeFlg(JSPUtil.getParameter(request, "hot_de_flg", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCnhkgCd(JSPUtil.getParameter(request, "cnhkg_cd", ""));
		setBvPolCd(JSPUtil.getParameter(request, "bv_pol_cd", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setMfSndDt(JSPUtil.getParameter(request, "mf_snd_dt", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setTermCd(JSPUtil.getParameter(request, "term_cd", ""));
		setTotalBl(JSPUtil.getParameter(request, "total_bl", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setRcFlg(JSPUtil.getParameter(request, "rc_flg", ""));
		setVvdNumber(JSPUtil.getParameter(request, "vvd_number", ""));
		setMfsndCode(JSPUtil.getParameter(request, "mfsnd_code", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return HongKongSearchManifestListVO[]
	 */
	public HongKongSearchManifestListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return HongKongSearchManifestListVO[]
	 */
	public HongKongSearchManifestListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		HongKongSearchManifestListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] frtTermCd = (JSPUtil.getParameter(request, prefix	+ "frt_term_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] bvPodCd = (JSPUtil.getParameter(request, prefix	+ "bv_pod_cd", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] hotDeFlg = (JSPUtil.getParameter(request, prefix	+ "hot_de_flg", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] cnhkgCd = (JSPUtil.getParameter(request, prefix	+ "cnhkg_cd", length));
			String[] bvPolCd = (JSPUtil.getParameter(request, prefix	+ "bv_pol_cd", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] mfSndDt = (JSPUtil.getParameter(request, prefix	+ "mf_snd_dt", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] termCd = (JSPUtil.getParameter(request, prefix	+ "term_cd", length));
			String[] totalBl = (JSPUtil.getParameter(request, prefix	+ "total_bl", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] rcFlg = (JSPUtil.getParameter(request, prefix	+ "rc_flg", length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number", length));
			String[] mfsndCode = (JSPUtil.getParameter(request, prefix	+ "mfsnd_code", length));
			
			for (int i = 0; i < length; i++) {
				model = new HongKongSearchManifestListVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (frtTermCd[i] != null)
					model.setFrtTermCd(frtTermCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (bvPodCd[i] != null)
					model.setBvPodCd(bvPodCd[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (hotDeFlg[i] != null)
					model.setHotDeFlg(hotDeFlg[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (cnhkgCd[i] != null)
					model.setCnhkgCd(cnhkgCd[i]);
				if (bvPolCd[i] != null)
					model.setBvPolCd(bvPolCd[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
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
		return getHongKongSearchManifestListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return HongKongSearchManifestListVO[]
	 */
	public HongKongSearchManifestListVO[] getHongKongSearchManifestListVOs(){
		HongKongSearchManifestListVO[] vos = (HongKongSearchManifestListVO[])models.toArray(new HongKongSearchManifestListVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtTermCd = this.frtTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bvPodCd = this.bvPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hotDeFlg = this.hotDeFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cnhkgCd = this.cnhkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bvPolCd = this.bvPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
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
