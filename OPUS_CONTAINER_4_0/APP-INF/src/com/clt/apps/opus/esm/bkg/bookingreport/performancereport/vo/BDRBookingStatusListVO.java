/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BDRBookingStatusListVO.java
*@FileTitle : BDRBookingStatusListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.06.04 김경섭 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.performancereport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김경섭
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class BDRBookingStatusListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<BDRBookingStatusListVO> models = new ArrayList<BDRBookingStatusListVO>();
	
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String fromDt = null;
	/* Column Info */
	private String preRlyPortCd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String ebdrDt = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String toDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String statusCd = null;
	/* Column Info */
	private String periodType = null;
	/* Column Info */
	private String bdrDt = null;
	/* Column Info */
	private String pstRlyPortCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public BDRBookingStatusListVO() {}

	public BDRBookingStatusListVO(String ibflag, String pagerows, String bkgOfcCd, String bkgNo, String bkgStsCd, String vslCd, String skdVoyNo, String skdDirCd, String porCd, String polCd, String podCd, String delCd, String preRlyPortCd, String pstRlyPortCd, String blNo, String etdDt, String bdrDt, String ebdrDt, String slanCd, String periodType, String fromDt, String toDt, String ofcCd, String statusCd) {
		this.bkgOfcCd = bkgOfcCd;
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.fromDt = fromDt;
		this.preRlyPortCd = preRlyPortCd;
		this.bkgStsCd = bkgStsCd;
		this.delCd = delCd;
		this.ebdrDt = ebdrDt;
		this.skdVoyNo = skdVoyNo;
		this.etdDt = etdDt;
		this.blNo = blNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.toDt = toDt;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.slanCd = slanCd;
		this.statusCd = statusCd;
		this.periodType = periodType;
		this.bdrDt = bdrDt;
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("from_dt", getFromDt());
		this.hashColumns.put("pre_rly_port_cd", getPreRlyPortCd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("ebdr_dt", getEbdrDt());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("to_dt", getToDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("status_cd", getStatusCd());
		this.hashColumns.put("period_type", getPeriodType());
		this.hashColumns.put("bdr_dt", getBdrDt());
		this.hashColumns.put("pst_rly_port_cd", getPstRlyPortCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("from_dt", "fromDt");
		this.hashFields.put("pre_rly_port_cd", "preRlyPortCd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("ebdr_dt", "ebdrDt");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("to_dt", "toDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("status_cd", "statusCd");
		this.hashFields.put("period_type", "periodType");
		this.hashFields.put("bdr_dt", "bdrDt");
		this.hashFields.put("pst_rly_port_cd", "pstRlyPortCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
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
	 * @return fromDt
	 */
	public String getFromDt() {
		return this.fromDt;
	}
	
	/**
	 * Column Info
	 * @return preRlyPortCd
	 */
	public String getPreRlyPortCd() {
		return this.preRlyPortCd;
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
	 * @return ebdrDt
	 */
	public String getEbdrDt() {
		return this.ebdrDt;
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
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
	}
	
	/**
	 * Column Info
	 * @return toDt
	 */
	public String getToDt() {
		return this.toDt;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return statusCd
	 */
	public String getStatusCd() {
		return this.statusCd;
	}
	
	/**
	 * Column Info
	 * @return periodType
	 */
	public String getPeriodType() {
		return this.periodType;
	}
	
	/**
	 * Column Info
	 * @return bdrDt
	 */
	public String getBdrDt() {
		return this.bdrDt;
	}
	
	/**
	 * Column Info
	 * @return pstRlyPortCd
	 */
	public String getPstRlyPortCd() {
		return this.pstRlyPortCd;
	}
	

	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
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
	 * @param fromDt
	 */
	public void setFromDt(String fromDt) {
		this.fromDt = fromDt;
	}
	
	/**
	 * Column Info
	 * @param preRlyPortCd
	 */
	public void setPreRlyPortCd(String preRlyPortCd) {
		this.preRlyPortCd = preRlyPortCd;
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
	 * @param ebdrDt
	 */
	public void setEbdrDt(String ebdrDt) {
		this.ebdrDt = ebdrDt;
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
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Column Info
	 * @param toDt
	 */
	public void setToDt(String toDt) {
		this.toDt = toDt;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param statusCd
	 */
	public void setStatusCd(String statusCd) {
		this.statusCd = statusCd;
	}
	
	/**
	 * Column Info
	 * @param periodType
	 */
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	
	/**
	 * Column Info
	 * @param bdrDt
	 */
	public void setBdrDt(String bdrDt) {
		this.bdrDt = bdrDt;
	}
	
	/**
	 * Column Info
	 * @param pstRlyPortCd
	 */
	public void setPstRlyPortCd(String pstRlyPortCd) {
		this.pstRlyPortCd = pstRlyPortCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setFromDt(JSPUtil.getParameter(request, "from_dt", ""));
		setPreRlyPortCd(JSPUtil.getParameter(request, "pre_rly_port_cd", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setEbdrDt(JSPUtil.getParameter(request, "ebdr_dt", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setToDt(JSPUtil.getParameter(request, "to_dt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setStatusCd(JSPUtil.getParameter(request, "status_cd", ""));
		setPeriodType(JSPUtil.getParameter(request, "period_type", ""));
		setBdrDt(JSPUtil.getParameter(request, "bdr_dt", ""));
		setPstRlyPortCd(JSPUtil.getParameter(request, "pst_rly_port_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SearchBDRBookingStatusListVO[]
	 */
	public BDRBookingStatusListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SearchBDRBookingStatusListVO[]
	 */
	public BDRBookingStatusListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		BDRBookingStatusListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd".trim(), length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] fromDt = (JSPUtil.getParameter(request, prefix	+ "from_dt".trim(), length));
			String[] preRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pre_rly_port_cd".trim(), length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd".trim(), length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd".trim(), length));
			String[] ebdrDt = (JSPUtil.getParameter(request, prefix	+ "ebdr_dt".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt".trim(), length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] toDt = (JSPUtil.getParameter(request, prefix	+ "to_dt".trim(), length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd".trim(), length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] statusCd = (JSPUtil.getParameter(request, prefix	+ "status_cd".trim(), length));
			String[] periodType = (JSPUtil.getParameter(request, prefix	+ "period_type".trim(), length));
			String[] bdrDt = (JSPUtil.getParameter(request, prefix	+ "bdr_dt".trim(), length));
			String[] pstRlyPortCd = (JSPUtil.getParameter(request, prefix	+ "pst_rly_port_cd".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new BDRBookingStatusListVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (fromDt[i] != null)
					model.setFromDt(fromDt[i]);
				if (preRlyPortCd[i] != null)
					model.setPreRlyPortCd(preRlyPortCd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (ebdrDt[i] != null)
					model.setEbdrDt(ebdrDt[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (toDt[i] != null)
					model.setToDt(toDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (statusCd[i] != null)
					model.setStatusCd(statusCd[i]);
				if (periodType[i] != null)
					model.setPeriodType(periodType[i]);
				if (bdrDt[i] != null)
					model.setBdrDt(bdrDt[i]);
				if (pstRlyPortCd[i] != null)
					model.setPstRlyPortCd(pstRlyPortCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSearchBDRBookingStatusListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SearchBDRBookingStatusListVO[]
	 */
	public BDRBookingStatusListVO[] getSearchBDRBookingStatusListVOs(){
		BDRBookingStatusListVO[] vos = (BDRBookingStatusListVO[])models.toArray(new BDRBookingStatusListVO[models.size()]);
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
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fromDt = this.fromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preRlyPortCd = this.preRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ebdrDt = this.ebdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toDt = this.toDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.statusCd = this.statusCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.periodType = this.periodType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bdrDt = this.bdrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pstRlyPortCd = this.pstRlyPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
