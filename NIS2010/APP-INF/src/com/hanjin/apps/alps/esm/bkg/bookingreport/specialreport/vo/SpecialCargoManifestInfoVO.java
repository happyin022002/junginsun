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

package com.hanjin.apps.alps.esm.bkg.bookingreport.specialreport.vo;

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
	private String vvdPol = null;
	/* Column Info */
	private String vvdPod = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String rdoInOut = null;
	/* Column Info */
	private String rdoLocalTs = null;
	/* Column Info */
	private String dg = null;
	/* Column Info */
	private String awk = null;
	/* Column Info */
	private String bb = null;
	/* Column Info */
	private String rf = null;
	/* Column Info */
	private String stwg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpecialCargoManifestInfoVO() {}

	public SpecialCargoManifestInfoVO(String ibflag, String pagerows, String polCd, String podCd, String vslCd, String skdVoyNo, String skdDirCd, String polYdCd, String podYdCd, String vesselName, String nationality, String officialNo, String callSign, String voyageNo, String vvdPol, String vvdPod, String porCd, String delCd, String rdoInOut, String rdoLocalTs, String dg, String awk, String bb, String rf, String stwg, String kindOfShip, String polName, String podName) {
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
		this.vvdPol = vvdPol;
		this.vvdPod = vvdPod;
		this.porCd = porCd;
		this.delCd = delCd;
		this.rdoInOut = rdoInOut;
		this.rdoLocalTs = rdoLocalTs;
		this.dg = dg;
		this.awk = awk;
		this.bb = bb;
		this.rf = rf;
		this.stwg = stwg;
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
		this.hashColumns.put("vvd_pol", getVvdPol());
		this.hashColumns.put("vvd_pod", getVvdPod());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("rdo_in_out", getRdoInOut());
		this.hashColumns.put("rdo_local_ts", getRdoLocalTs());
		this.hashColumns.put("dg", getDg());
		this.hashColumns.put("awk", getAwk());
		this.hashColumns.put("bb", getBb());
		this.hashColumns.put("rf", getRf());
		this.hashColumns.put("stwg", getStwg());
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
		this.hashFields.put("vvd_pol", "vvdPol");
		this.hashFields.put("vvd_pod", "vvdPod");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("rdo_in_out", "rdoInOut");
		this.hashFields.put("rdo_local_ts", "rdoLocalTs");
		this.hashFields.put("dg", "dg");
		this.hashFields.put("awk", "awk");
		this.hashFields.put("bb", "bb");
		this.hashFields.put("rf", "rf");
		this.hashFields.put("stwg", "stwg");
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
	 * @return vvdPol
	 */
	public String getVvdPol() {
		return this.vvdPol;
	}
	
	/**
	 * Column Info
	 * @return vvdPod
	 */
	public String getVvdPod() {
		return this.vvdPod;
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
	 * @return delCd
	 */
	public String getDelCd() {
		return this.delCd;
	}
	
	/**
	 * Column Info
	 * @return rdoInOut
	 */
	public String getRdoInOut() {
		return this.rdoInOut;
	}
	
	/**
	 * Column Info
	 * @return rdoLocalTs
	 */
	public String getRdoLocalTs() {
		return this.rdoLocalTs;
	}
	
	/**
	 * Column Info
	 * @return dg
	 */
	public String getDg() {
		return this.dg;
	}
	
	/**
	 * Column Info
	 * @return awk
	 */
	public String getAwk() {
		return this.awk;
	}
	
	/**
	 * Column Info
	 * @return bb
	 */
	public String getBb() {
		return this.bb;
	}
	
	/**
	 * Column Info
	 * @return rf
	 */
	public String getRf() {
		return this.rf;
	}
	
	/**
	 * Column Info
	 * @return stwg
	 */
	public String getStwg() {
		return this.stwg;
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
	 * @param vvdPol
	 */
	public void setVvdPol(String vvdPol) {
		this.vvdPol = vvdPol;
	}
	
	/**
	 * Column Info
	 * @param vvdPod
	 */
	public void setVvdPod(String vvdPod) {
		this.vvdPod = vvdPod;
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
	 * @param delCd
	 */
	public void setDelCd(String delCd) {
		this.delCd = delCd;
	}
	
	/**
	 * Column Info
	 * @param rdoInOut
	 */
	public void setRdoInOut(String rdoInOut) {
		this.rdoInOut = rdoInOut;
	}
	
	/**
	 * Column Info
	 * @param rdoLocalTs
	 */
	public void setRdoLocalTs(String rdoLocalTs) {
		this.rdoLocalTs = rdoLocalTs;
	}
	
	/**
	 * Column Info
	 * @param dg
	 */
	public void setDg(String dg) {
		this.dg = dg;
	}
	
	/**
	 * Column Info
	 * @param awk
	 */
	public void setAwk(String awk) {
		this.awk = awk;
	}
	
	/**
	 * Column Info
	 * @param bb
	 */
	public void setBb(String bb) {
		this.bb = bb;
	}
	
	/**
	 * Column Info
	 * @param rf
	 */
	public void setRf(String rf) {
		this.rf = rf;
	}
	
	/**
	 * Column Info
	 * @param stwg
	 */
	public void setStwg(String stwg) {
		this.stwg = stwg;
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
		setVvdPol(JSPUtil.getParameter(request, prefix + "vvd_pol", ""));
		setVvdPod(JSPUtil.getParameter(request, prefix + "vvd_pod", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setRdoInOut(JSPUtil.getParameter(request, prefix + "rdo_in_out", ""));
		setRdoLocalTs(JSPUtil.getParameter(request, prefix + "rdo_local_ts", ""));
		setDg(JSPUtil.getParameter(request, prefix + "dg", ""));
		setAwk(JSPUtil.getParameter(request, prefix + "awk", ""));
		setBb(JSPUtil.getParameter(request, prefix + "bb", ""));
		setRf(JSPUtil.getParameter(request, prefix + "rf", ""));
		setStwg(JSPUtil.getParameter(request, prefix + "stwg", ""));
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
			String[] vvdPol = (JSPUtil.getParameter(request, prefix	+ "vvd_pol", length));
			String[] vvdPod = (JSPUtil.getParameter(request, prefix	+ "vvd_pod", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] rdoInOut = (JSPUtil.getParameter(request, prefix	+ "rdo_in_out", length));
			String[] rdoLocalTs = (JSPUtil.getParameter(request, prefix	+ "rdo_local_ts", length));
			String[] dg = (JSPUtil.getParameter(request, prefix	+ "dg", length));
			String[] awk = (JSPUtil.getParameter(request, prefix	+ "awk", length));
			String[] bb = (JSPUtil.getParameter(request, prefix	+ "bb", length));
			String[] rf = (JSPUtil.getParameter(request, prefix	+ "rf", length));
			String[] stwg = (JSPUtil.getParameter(request, prefix	+ "stwg", length));
			
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
				if (vvdPol[i] != null)
					model.setVvdPol(vvdPol[i]);
				if (vvdPod[i] != null)
					model.setVvdPod(vvdPod[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (rdoInOut[i] != null)
					model.setRdoInOut(rdoInOut[i]);
				if (rdoLocalTs[i] != null)
					model.setRdoLocalTs(rdoLocalTs[i]);
				if (dg[i] != null)
					model.setDg(dg[i]);
				if (awk[i] != null)
					model.setAwk(awk[i]);
				if (bb[i] != null)
					model.setBb(bb[i]);
				if (rf[i] != null)
					model.setRf(rf[i]);
				if (stwg[i] != null)
					model.setStwg(stwg[i]);
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
		this.vvdPol = this.vvdPol .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdPod = this.vvdPod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdoInOut = this.rdoInOut .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdoLocalTs = this.rdoLocalTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dg = this.dg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.awk = this.awk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bb = this.bb .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf = this.rf .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stwg = this.stwg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
