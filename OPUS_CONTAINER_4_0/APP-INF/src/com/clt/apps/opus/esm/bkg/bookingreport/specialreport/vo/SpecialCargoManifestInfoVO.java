/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialCargoManifestInfoVO.java
*@FileTitle : SpecialCargoManifestInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.26
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.26  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo;

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
 * @author 
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpecialCargoManifestInfoVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpecialCargoManifestInfoVO> models = new ArrayList<SpecialCargoManifestInfoVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String vesselName = null;
	/* Column Info */
	private String officialNo = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String podName = null;
	/* Column Info */
	private String nationality = null;
	/* Column Info */
	private String kindOfShip = null;
	/* Column Info */
	private String polYdCd = null;
	/* Column Info */
	private String callSign = null;
	/* Column Info */
	private String polName = null;
	/* Column Info */
	private String podYdCd = null;
	/* Column Info */
	private String voyageNo = null;
	/* Column Info */
	private String vslRgstCntNm = null;
	/* Column Info */
	private String lloydNo = null;
	/* Column Info */
	private String delName = null;
	/* Column Info */
	private String ioBndCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpecialCargoManifestInfoVO() {}

	public SpecialCargoManifestInfoVO(String ibflag, String pagerows, String polCd, String podCd, String vslCd, String skdVoyNo, String skdDirCd, String polYdCd, String podYdCd, String vesselName, String nationality, String officialNo, String callSign, String voyageNo, String kindOfShip, String polName, String podName, String vslRgstCntNm, String lloydNo, String delName, String ioBndCd) {
		this.vslCd = vslCd;
		this.vesselName = vesselName;
		this.officialNo = officialNo;
		this.skdVoyNo = skdVoyNo;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podCd = podCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.podName = podName;
		this.nationality = nationality;
		this.kindOfShip = kindOfShip;
		this.polYdCd = polYdCd;
		this.callSign = callSign;
		this.polName = polName;
		this.podYdCd = podYdCd;
		this.voyageNo = voyageNo;
		this.vslRgstCntNm = vslRgstCntNm;
		this.lloydNo = lloydNo;
		this.delName = delName;
		this.ioBndCd = ioBndCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("vessel_name", getVesselName());
		this.hashColumns.put("official_no", getOfficialNo());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("pod_name", getPodName());
		this.hashColumns.put("nationality", getNationality());
		this.hashColumns.put("kind_of_ship", getKindOfShip());
		this.hashColumns.put("pol_yd_cd", getPolYdCd());
		this.hashColumns.put("call_sign", getCallSign());
		this.hashColumns.put("pol_name", getPolName());
		this.hashColumns.put("pod_yd_cd", getPodYdCd());
		this.hashColumns.put("voyage_no", getVoyageNo());
		this.hashColumns.put("vsl_rgst_cnt_nm", getVslRgstCntNm());
		this.hashColumns.put("lloyd_no", getLloydNo());
		this.hashColumns.put("del_name", getDelName());
		this.hashColumns.put("io_bnd_cd", getIoBndCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("vessel_name", "vesselName");
		this.hashFields.put("official_no", "officialNo");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("pod_name", "podName");
		this.hashFields.put("nationality", "nationality");
		this.hashFields.put("kind_of_ship", "kindOfShip");
		this.hashFields.put("pol_yd_cd", "polYdCd");
		this.hashFields.put("call_sign", "callSign");
		this.hashFields.put("pol_name", "polName");
		this.hashFields.put("pod_yd_cd", "podYdCd");
		this.hashFields.put("voyage_no", "voyageNo");
		this.hashFields.put("vsl_rgst_cnt_nm", "vslRgstCntNm");
		this.hashFields.put("lloyd_no", "lloydNo");
		this.hashFields.put("del_name", "delName");
		this.hashFields.put("io_bnd_cd", "ioBndCd");
		return this.hashFields;
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
	 * @return vesselName
	 */
	public String getVesselName() {
		return this.vesselName;
	}
	
	/**
	 * Column Info
	 * @return officialNo
	 */
	public String getOfficialNo() {
		return this.officialNo;
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
	 * Page Number
	 * @return pagerows
	 */
	public String getPagerows() {
		return this.pagerows;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
	}
	
	/**
	 * Column Info
	 * @return podName
	 */
	public String getPodName() {
		return this.podName;
	}
	
	/**
	 * Column Info
	 * @return nationality
	 */
	public String getNationality() {
		return this.nationality;
	}
	
	/**
	 * Column Info
	 * @return kindOfShip
	 */
	public String getKindOfShip() {
		return this.kindOfShip;
	}
	
	/**
	 * Column Info
	 * @return polYdCd
	 */
	public String getPolYdCd() {
		return this.polYdCd;
	}
	
	/**
	 * Column Info
	 * @return callSign
	 */
	public String getCallSign() {
		return this.callSign;
	}
	
	/**
	 * Column Info
	 * @return polName
	 */
	public String getPolName() {
		return this.polName;
	}
	
	/**
	 * Column Info
	 * @return podYdCd
	 */
	public String getPodYdCd() {
		return this.podYdCd;
	}
	
	/**
	 * Column Info
	 * @return voyageNo
	 */
	public String getVoyageNo() {
		return this.voyageNo;
	}
	

	/**
	 * Column Info
	 * @return the vslRgstCntNm
	 */
	public String getVslRgstCntNm() {
		return this.vslRgstCntNm;
	}

	/**
	 * Column Info
	 * @return the lloydNo
	 */
	public String getLloydNo() {
		return this.lloydNo;
	}
	
	/**
	 * Column Info
	 * @return the delName
	 */
	public String getDelName() {
		return this.delName;
	}
	
	/**
	 * Column Info
	 * @return the ioBndCd
	 */
	public String getIoBndCd() {
		return this.ioBndCd;
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
	 * @param vesselName
	 */
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	
	/**
	 * Column Info
	 * @param officialNo
	 */
	public void setOfficialNo(String officialNo) {
		this.officialNo = officialNo;
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
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
	}
	
	/**
	 * Column Info
	 * @param podName
	 */
	public void setPodName(String podName) {
		this.podName = podName;
	}
	
	/**
	 * Column Info
	 * @param nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	
	/**
	 * Column Info
	 * @param kindOfShip
	 */
	public void setKindOfShip(String kindOfShip) {
		this.kindOfShip = kindOfShip;
	}
	
	/**
	 * Column Info
	 * @param polYdCd
	 */
	public void setPolYdCd(String polYdCd) {
		this.polYdCd = polYdCd;
	}
	
	/**
	 * Column Info
	 * @param callSign
	 */
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	
	/**
	 * Column Info
	 * @param polName
	 */
	public void setPolName(String polName) {
		this.polName = polName;
	}
	
	/**
	 * Column Info
	 * @param podYdCd
	 */
	public void setPodYdCd(String podYdCd) {
		this.podYdCd = podYdCd;
	}
	
	/**
	 * Column Info
	 * @param voyageNo
	 */
	public void setVoyageNo(String voyageNo) {
		this.voyageNo = voyageNo;
	}
	
	
	/**
	 * Column Info
	 * @param vslRgstCntNm
	 */
	public void setVslRgstCntNm(String vslRgstCntNm) {
		this.vslRgstCntNm = vslRgstCntNm;
	}

	/**
	 * Column Info
	 * @param lloydNo
	 */
	public void setLloydNo(String lloydNo) {
		this.lloydNo = lloydNo;
	}
	
	
	/**
	 * Column Info
	 * @param delName
	 */
	public void setDelName(String delName) {
		this.delName = delName;
	}
	
	/**
	 * Column Info
	 * @param ioBndCd
	 */
	public void setIoBndCd(String ioBndCd) {
		this.ioBndCd = ioBndCd;
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
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setVesselName(JSPUtil.getParameter(request, prefix + "vessel_name", ""));
		setOfficialNo(JSPUtil.getParameter(request, prefix + "official_no", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setPodName(JSPUtil.getParameter(request, prefix + "pod_name", ""));
		setNationality(JSPUtil.getParameter(request, prefix + "nationality", ""));
		setKindOfShip(JSPUtil.getParameter(request, prefix + "kind_of_ship", ""));
		setPolYdCd(JSPUtil.getParameter(request, prefix + "pol_yd_cd", ""));
		setCallSign(JSPUtil.getParameter(request, prefix + "call_sign", ""));
		setPolName(JSPUtil.getParameter(request, prefix + "pol_name", ""));
		setPodYdCd(JSPUtil.getParameter(request, prefix + "pod_yd_cd", ""));
		setVoyageNo(JSPUtil.getParameter(request, prefix + "voyage_no", ""));
		setVslRgstCntNm(JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_nm", ""));
		setLloydNo(JSPUtil.getParameter(request, prefix + "lloyd_no", ""));
		setDelName(JSPUtil.getParameter(request, prefix + "del_name", ""));
		setIoBndCd(JSPUtil.getParameter(request, prefix + "io_bnd_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpecialCargoManifestInfoVO[]
	 */
	public SpecialCargoManifestInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpecialCargoManifestInfoVO[]
	 */
	public SpecialCargoManifestInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpecialCargoManifestInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] vesselName = (JSPUtil.getParameter(request, prefix	+ "vessel_name", length));
			String[] officialNo = (JSPUtil.getParameter(request, prefix	+ "official_no", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] podName = (JSPUtil.getParameter(request, prefix	+ "pod_name", length));
			String[] nationality = (JSPUtil.getParameter(request, prefix	+ "nationality", length));
			String[] kindOfShip = (JSPUtil.getParameter(request, prefix	+ "kind_of_ship", length));
			String[] polYdCd = (JSPUtil.getParameter(request, prefix	+ "pol_yd_cd", length));
			String[] callSign = (JSPUtil.getParameter(request, prefix	+ "call_sign", length));
			String[] polName = (JSPUtil.getParameter(request, prefix	+ "pol_name", length));
			String[] podYdCd = (JSPUtil.getParameter(request, prefix	+ "pod_yd_cd", length));
			String[] voyageNo = (JSPUtil.getParameter(request, prefix	+ "voyage_no", length));
			String[] vslRgstCntNm = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_nm", length));
			String[] lloydNo = (JSPUtil.getParameter(request, prefix	+ "lloyd_no", length));
			String[] delName = (JSPUtil.getParameter(request, prefix	+ "del_name", length));
			String[] ioBndCd = (JSPUtil.getParameter(request, prefix	+ "io_bnd_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpecialCargoManifestInfoVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (vesselName[i] != null)
					model.setVesselName(vesselName[i]);
				if (officialNo[i] != null)
					model.setOfficialNo(officialNo[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (podName[i] != null)
					model.setPodName(podName[i]);
				if (nationality[i] != null)
					model.setNationality(nationality[i]);
				if (kindOfShip[i] != null)
					model.setKindOfShip(kindOfShip[i]);
				if (polYdCd[i] != null)
					model.setPolYdCd(polYdCd[i]);
				if (callSign[i] != null)
					model.setCallSign(callSign[i]);
				if (polName[i] != null)
					model.setPolName(polName[i]);
				if (podYdCd[i] != null)
					model.setPodYdCd(podYdCd[i]);
				if (voyageNo[i] != null)
					model.setVoyageNo(voyageNo[i]);
				if (vslRgstCntNm[i] != null)
					model.setVslRgstCntNm(voyageNo[i]);
				if (lloydNo[i] != null)
					model.setLloydNo(lloydNo[i]);
				if (delName[i] != null)
					model.setDelName(delName[i]);
				if (ioBndCd[i] != null)
					model.setIoBndCd(ioBndCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpecialCargoManifestInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpecialCargoManifestInfoVO[]
	 */
	public SpecialCargoManifestInfoVO[] getSpecialCargoManifestInfoVOs(){
		SpecialCargoManifestInfoVO[] vos = (SpecialCargoManifestInfoVO[])models.toArray(new SpecialCargoManifestInfoVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vesselName = this.vesselName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.officialNo = this.officialNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podName = this.podName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nationality = this.nationality .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kindOfShip = this.kindOfShip .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdCd = this.polYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSign = this.callSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polName = this.polName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdCd = this.podYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyageNo = this.voyageNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntNm = this.vslRgstCntNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lloydNo = this.lloydNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delName = this.delName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ioBndCd = this.ioBndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
