/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : VietnamManifestListCondVO.java
*@FileTitle : VietnamManifestListCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2014.04.22
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2014.04.22 김상수 
* 1.0 Creation
=========================================================*/
  
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vietnam.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김상수
 * @since J2EE 1.6
 * @see com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO
 */

public class VietnamManifestListCondVO extends com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<VietnamManifestListCondVO> models = new ArrayList<VietnamManifestListCondVO>();
	
	/* Column Info */
	private String sMode = null;
	/* Column Info */
	private String eta = null;
	/* Column Info */
	private String vslCallsign = null;
	/* Column Info */
	private String toVslCd = null;
	/* Column Info */
	private String sTrunkPorCd = null;
	/* Column Info */
	private String etd = null;
	/* Column Info */
	private String sTrunkPolCd = null;
	/* Column Info */
	private String sStatus = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String sTrunkDelCd = null;
	/* Column Info */
	private String sVvd = null;
	/* Column Info */
	private String toSkdVoyNo = null;
	/* Column Info */
	private String polGubun = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String frmPortCd = null;
	/* Column Info */
	private String sPodCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tsTpCd = null;
	/* Column Info */
	private String sTrunkPodCd = null;
	/* Column Info */
	private String sPolCd = null;
	/* Column Info */
	private String toSkdDirCd = null;
	/* Column Info */
	private String misFlg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public VietnamManifestListCondVO() {}

	public VietnamManifestListCondVO(String ibflag, String pagerows, String sMode, String sPodCd, String sTrunkPodCd, String sTrunkPorCd, String sTrunkPolCd, String sPolCd, String sStatus, String sTrunkDelCd, String sVvd, String tsTpCd, String frmPortCd, String vslNm, String vslCallsign, String etd, String eta, String polGubun, String toVslCd, String toSkdVoyNo, String toSkdDirCd, String misFlg) {
		this.sMode = sMode;
		this.eta = eta;
		this.vslCallsign = vslCallsign;
		this.toVslCd = toVslCd;
		this.sTrunkPorCd = sTrunkPorCd;
		this.etd = etd;
		this.sTrunkPolCd = sTrunkPolCd;
		this.sStatus = sStatus;
		this.vslNm = vslNm;
		this.sTrunkDelCd = sTrunkDelCd;
		this.sVvd = sVvd;
		this.toSkdVoyNo = toSkdVoyNo;
		this.polGubun = polGubun;
		this.pagerows = pagerows;
		this.frmPortCd = frmPortCd;
		this.sPodCd = sPodCd;
		this.ibflag = ibflag;
		this.tsTpCd = tsTpCd;
		this.sTrunkPodCd = sTrunkPodCd;
		this.sPolCd = sPolCd;
		this.toSkdDirCd = toSkdDirCd;
		this.misFlg = misFlg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("s_mode", getSMode());
		this.hashColumns.put("eta", getEta());
		this.hashColumns.put("vsl_callsign", getVslCallsign());
		this.hashColumns.put("to_vsl_cd", getToVslCd());
		this.hashColumns.put("s_trunk_por_cd", getSTrunkPorCd());
		this.hashColumns.put("etd", getEtd());
		this.hashColumns.put("s_trunk_pol_cd", getSTrunkPolCd());
		this.hashColumns.put("s_status", getSStatus());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("s_trunk_del_cd", getSTrunkDelCd());
		this.hashColumns.put("s_vvd", getSVvd());
		this.hashColumns.put("to_skd_voy_no", getToSkdVoyNo());
		this.hashColumns.put("pol_gubun", getPolGubun());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("frm_port_cd", getFrmPortCd());
		this.hashColumns.put("s_pod_cd", getSPodCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ts_tp_cd", getTsTpCd());
		this.hashColumns.put("s_trunk_pod_cd", getSTrunkPodCd());
		this.hashColumns.put("s_pol_cd", getSPolCd());
		this.hashColumns.put("to_skd_dir_cd", getToSkdDirCd());
		this.hashColumns.put("mis_flg", getMisFlg());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("s_mode", "sMode");
		this.hashFields.put("eta", "eta");
		this.hashFields.put("vsl_callsign", "vslCallsign");
		this.hashFields.put("to_vsl_cd", "toVslCd");
		this.hashFields.put("s_trunk_por_cd", "sTrunkPorCd");
		this.hashFields.put("etd", "etd");
		this.hashFields.put("s_trunk_pol_cd", "sTrunkPolCd");
		this.hashFields.put("s_status", "sStatus");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("s_trunk_del_cd", "sTrunkDelCd");
		this.hashFields.put("s_vvd", "sVvd");
		this.hashFields.put("to_skd_voy_no", "toSkdVoyNo");
		this.hashFields.put("pol_gubun", "polGubun");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("frm_port_cd", "frmPortCd");
		this.hashFields.put("s_pod_cd", "sPodCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ts_tp_cd", "tsTpCd");
		this.hashFields.put("s_trunk_pod_cd", "sTrunkPodCd");
		this.hashFields.put("s_pol_cd", "sPolCd");
		this.hashFields.put("to_skd_dir_cd", "toSkdDirCd");
		this.hashFields.put("mis_flg", "misFlg");
		return this.hashFields;
	}
	
	
	
	/**
	 * Column Info
	 * @return misFlg
	 */
	public String getMisFlg() {
		return misFlg;
	}

	/**
	 * Column Info
	 * @param misFlg
	 */
	public void setMisFlg(String misFlg) {
		this.misFlg = misFlg;
	}
	
	/**
	 * Column Info
	 * @return sMode
	 */
	public String getSMode() {
		return this.sMode;
	}
	
	/**
	 * Column Info
	 * @return eta
	 */
	public String getEta() {
		return this.eta;
	}
	
	/**
	 * Column Info
	 * @return vslCallsign
	 */
	public String getVslCallsign() {
		return this.vslCallsign;
	}
	
	/**
	 * Column Info
	 * @return toVslCd
	 */
	public String getToVslCd() {
		return this.toVslCd;
	}
	
	/**
	 * Column Info
	 * @return sTrunkPorCd
	 */
	public String getSTrunkPorCd() {
		return this.sTrunkPorCd;
	}
	
	/**
	 * Column Info
	 * @return etd
	 */
	public String getEtd() {
		return this.etd;
	}
	
	/**
	 * Column Info
	 * @return sTrunkPolCd
	 */
	public String getSTrunkPolCd() {
		return this.sTrunkPolCd;
	}
	
	/**
	 * Column Info
	 * @return sStatus
	 */
	public String getSStatus() {
		return this.sStatus;
	}
	
	/**
	 * Column Info
	 * @return vslNm
	 */
	public String getVslNm() {
		return this.vslNm;
	}
	
	/**
	 * Column Info
	 * @return sTrunkDelCd
	 */
	public String getSTrunkDelCd() {
		return this.sTrunkDelCd;
	}
	
	/**
	 * Column Info
	 * @return sVvd
	 */
	public String getSVvd() {
		return this.sVvd;
	}
	
	/**
	 * Column Info
	 * @return toSkdVoyNo
	 */
	public String getToSkdVoyNo() {
		return this.toSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return polGubun
	 */
	public String getPolGubun() {
		return this.polGubun;
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
	 * @return frmPortCd
	 */
	public String getFrmPortCd() {
		return this.frmPortCd;
	}
	
	/**
	 * Column Info
	 * @return sPodCd
	 */
	public String getSPodCd() {
		return this.sPodCd;
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
	 * @return tsTpCd
	 */
	public String getTsTpCd() {
		return this.tsTpCd;
	}
	
	/**
	 * Column Info
	 * @return sTrunkPodCd
	 */
	public String getSTrunkPodCd() {
		return this.sTrunkPodCd;
	}
	
	/**
	 * Column Info
	 * @return sPolCd
	 */
	public String getSPolCd() {
		return this.sPolCd;
	}
	
	/**
	 * Column Info
	 * @return toSkdDirCd
	 */
	public String getToSkdDirCd() {
		return this.toSkdDirCd;
	}
	

	/**
	 * Column Info
	 * @param sMode
	 */
	public void setSMode(String sMode) {
		this.sMode = sMode;
	}
	
	/**
	 * Column Info
	 * @param eta
	 */
	public void setEta(String eta) {
		this.eta = eta;
	}
	
	/**
	 * Column Info
	 * @param vslCallsign
	 */
	public void setVslCallsign(String vslCallsign) {
		this.vslCallsign = vslCallsign;
	}
	
	/**
	 * Column Info
	 * @param toVslCd
	 */
	public void setToVslCd(String toVslCd) {
		this.toVslCd = toVslCd;
	}
	
	/**
	 * Column Info
	 * @param sTrunkPorCd
	 */
	public void setSTrunkPorCd(String sTrunkPorCd) {
		this.sTrunkPorCd = sTrunkPorCd;
	}
	
	/**
	 * Column Info
	 * @param etd
	 */
	public void setEtd(String etd) {
		this.etd = etd;
	}
	
	/**
	 * Column Info
	 * @param sTrunkPolCd
	 */
	public void setSTrunkPolCd(String sTrunkPolCd) {
		this.sTrunkPolCd = sTrunkPolCd;
	}
	
	/**
	 * Column Info
	 * @param sStatus
	 */
	public void setSStatus(String sStatus) {
		this.sStatus = sStatus;
	}
	
	/**
	 * Column Info
	 * @param vslNm
	 */
	public void setVslNm(String vslNm) {
		this.vslNm = vslNm;
	}
	
	/**
	 * Column Info
	 * @param sTrunkDelCd
	 */
	public void setSTrunkDelCd(String sTrunkDelCd) {
		this.sTrunkDelCd = sTrunkDelCd;
	}
	
	/**
	 * Column Info
	 * @param sVvd
	 */
	public void setSVvd(String sVvd) {
		this.sVvd = sVvd;
	}
	
	/**
	 * Column Info
	 * @param toSkdVoyNo
	 */
	public void setToSkdVoyNo(String toSkdVoyNo) {
		this.toSkdVoyNo = toSkdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param polGubun
	 */
	public void setPolGubun(String polGubun) {
		this.polGubun = polGubun;
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
	 * @param frmPortCd
	 */
	public void setFrmPortCd(String frmPortCd) {
		this.frmPortCd = frmPortCd;
	}
	
	/**
	 * Column Info
	 * @param sPodCd
	 */
	public void setSPodCd(String sPodCd) {
		this.sPodCd = sPodCd;
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
	 * @param tsTpCd
	 */
	public void setTsTpCd(String tsTpCd) {
		this.tsTpCd = tsTpCd;
	}
	
	/**
	 * Column Info
	 * @param sTrunkPodCd
	 */
	public void setSTrunkPodCd(String sTrunkPodCd) {
		this.sTrunkPodCd = sTrunkPodCd;
	}
	
	/**
	 * Column Info
	 * @param sPolCd
	 */
	public void setSPolCd(String sPolCd) {
		this.sPolCd = sPolCd;
	}
	
	/**
	 * Column Info
	 * @param toSkdDirCd
	 */
	public void setToSkdDirCd(String toSkdDirCd) {
		this.toSkdDirCd = toSkdDirCd;
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
		setSMode(JSPUtil.getParameter(request, prefix + "s_mode", ""));
		setEta(JSPUtil.getParameter(request, prefix + "eta", ""));
		setVslCallsign(JSPUtil.getParameter(request, prefix + "vsl_callsign", ""));
		setToVslCd(JSPUtil.getParameter(request, prefix + "to_vsl_cd", ""));
		setSTrunkPorCd(JSPUtil.getParameter(request, prefix + "s_trunk_por_cd", ""));
		setEtd(JSPUtil.getParameter(request, prefix + "etd", ""));
		setSTrunkPolCd(JSPUtil.getParameter(request, prefix + "s_trunk_pol_cd", ""));
		setSStatus(JSPUtil.getParameter(request, prefix + "s_status", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setSTrunkDelCd(JSPUtil.getParameter(request, prefix + "s_trunk_del_cd", ""));
		setSVvd(JSPUtil.getParameter(request, prefix + "s_vvd", ""));
		setToSkdVoyNo(JSPUtil.getParameter(request, prefix + "to_skd_voy_no", ""));
		setPolGubun(JSPUtil.getParameter(request, prefix + "pol_gubun", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFrmPortCd(JSPUtil.getParameter(request, prefix + "frm_port_cd", ""));
		setSPodCd(JSPUtil.getParameter(request, prefix + "s_pod_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTsTpCd(JSPUtil.getParameter(request, prefix + "ts_tp_cd", ""));
		setSTrunkPodCd(JSPUtil.getParameter(request, prefix + "s_trunk_pod_cd", ""));
		setSPolCd(JSPUtil.getParameter(request, prefix + "s_pol_cd", ""));
		setToSkdDirCd(JSPUtil.getParameter(request, prefix + "to_skd_dir_cd", ""));
		setMisFlg(JSPUtil.getParameter(request, prefix + "mis_flg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return VietnamManifestListCondVO[]
	 */
	public VietnamManifestListCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return VietnamManifestListCondVO[]
	 */
	public VietnamManifestListCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		VietnamManifestListCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] sMode = (JSPUtil.getParameter(request, prefix	+ "s_mode", length));
			String[] eta = (JSPUtil.getParameter(request, prefix	+ "eta", length));
			String[] vslCallsign = (JSPUtil.getParameter(request, prefix	+ "vsl_callsign", length));
			String[] toVslCd = (JSPUtil.getParameter(request, prefix	+ "to_vsl_cd", length));
			String[] sTrunkPorCd = (JSPUtil.getParameter(request, prefix	+ "s_trunk_por_cd", length));
			String[] etd = (JSPUtil.getParameter(request, prefix	+ "etd", length));
			String[] sTrunkPolCd = (JSPUtil.getParameter(request, prefix	+ "s_trunk_pol_cd", length));
			String[] sStatus = (JSPUtil.getParameter(request, prefix	+ "s_status", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] sTrunkDelCd = (JSPUtil.getParameter(request, prefix	+ "s_trunk_del_cd", length));
			String[] sVvd = (JSPUtil.getParameter(request, prefix	+ "s_vvd", length));
			String[] toSkdVoyNo = (JSPUtil.getParameter(request, prefix	+ "to_skd_voy_no", length));
			String[] polGubun = (JSPUtil.getParameter(request, prefix	+ "pol_gubun", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] frmPortCd = (JSPUtil.getParameter(request, prefix	+ "frm_port_cd", length));
			String[] sPodCd = (JSPUtil.getParameter(request, prefix	+ "s_pod_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tsTpCd = (JSPUtil.getParameter(request, prefix	+ "ts_tp_cd", length));
			String[] sTrunkPodCd = (JSPUtil.getParameter(request, prefix	+ "s_trunk_pod_cd", length));
			String[] sPolCd = (JSPUtil.getParameter(request, prefix	+ "s_pol_cd", length));
			String[] toSkdDirCd = (JSPUtil.getParameter(request, prefix	+ "to_skd_dir_cd", length));
			String[] misFlg = (JSPUtil.getParameter(request, prefix	+ "mis_flg", length));
			
			for (int i = 0; i < length; i++) {
				model = new VietnamManifestListCondVO();
				if (sMode[i] != null)
					model.setSMode(sMode[i]);
				if (eta[i] != null)
					model.setEta(eta[i]);
				if (vslCallsign[i] != null)
					model.setVslCallsign(vslCallsign[i]);
				if (toVslCd[i] != null)
					model.setToVslCd(toVslCd[i]);
				if (sTrunkPorCd[i] != null)
					model.setSTrunkPorCd(sTrunkPorCd[i]);
				if (etd[i] != null)
					model.setEtd(etd[i]);
				if (sTrunkPolCd[i] != null)
					model.setSTrunkPolCd(sTrunkPolCd[i]);
				if (sStatus[i] != null)
					model.setSStatus(sStatus[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (sTrunkDelCd[i] != null)
					model.setSTrunkDelCd(sTrunkDelCd[i]);
				if (sVvd[i] != null)
					model.setSVvd(sVvd[i]);
				if (toSkdVoyNo[i] != null)
					model.setToSkdVoyNo(toSkdVoyNo[i]);
				if (polGubun[i] != null)
					model.setPolGubun(polGubun[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (frmPortCd[i] != null)
					model.setFrmPortCd(frmPortCd[i]);
				if (sPodCd[i] != null)
					model.setSPodCd(sPodCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tsTpCd[i] != null)
					model.setTsTpCd(tsTpCd[i]);
				if (sTrunkPodCd[i] != null)
					model.setSTrunkPodCd(sTrunkPodCd[i]);
				if (sPolCd[i] != null)
					model.setSPolCd(sPolCd[i]);
				if (toSkdDirCd[i] != null)
					model.setToSkdDirCd(toSkdDirCd[i]);
				if (misFlg[i] != null)
					model.setMisFlg(misFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getVietnamManifestListCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return VietnamManifestListCondVO[]
	 */
	public VietnamManifestListCondVO[] getVietnamManifestListCondVOs(){
		VietnamManifestListCondVO[] vos = (VietnamManifestListCondVO[])models.toArray(new VietnamManifestListCondVO[models.size()]);
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
		this.sMode = this.sMode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eta = this.eta .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallsign = this.vslCallsign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toVslCd = this.toVslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrunkPorCd = this.sTrunkPorCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etd = this.etd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrunkPolCd = this.sTrunkPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sStatus = this.sStatus .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrunkDelCd = this.sTrunkDelCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sVvd = this.sVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSkdVoyNo = this.toSkdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polGubun = this.polGubun .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frmPortCd = this.frmPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPodCd = this.sPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tsTpCd = this.tsTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sTrunkPodCd = this.sTrunkPodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sPolCd = this.sPolCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toSkdDirCd = this.toSkdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.misFlg = this.misFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
