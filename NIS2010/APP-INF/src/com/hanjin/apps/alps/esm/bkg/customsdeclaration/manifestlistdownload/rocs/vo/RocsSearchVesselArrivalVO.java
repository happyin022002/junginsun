/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsSearchVesselArrivalVO.java
*@FileTitle : RocsSearchVesselArrivalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.15
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.07.15 임재택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalVO;
import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 임재택
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class RocsSearchVesselArrivalVO extends VesselArrivalVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsSearchVesselArrivalVO> models = new ArrayList<RocsSearchVesselArrivalVO>();
	
	/* Column Info */
	private String vslCallRefStsCdNm = null;
	/* Column Info */
	private String cstmsDeclUsrId = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String vslCallRefStsCd = null;
	/* Column Info */
	private String blCreDt = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String vvdNumber = null;
	/* Column Info */
	private String vslCallRefNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podClptIndSeq = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsSearchVesselArrivalVO() {}

	public RocsSearchVesselArrivalVO(String ibflag, String pagerows, String slanCd, String vslCallRefNo, String vvdNumber, String vpsEtaDt, String vslEngNm, String vpsPortCd, String cstmsDeclUsrId, String vslCallRefStsCd, String blCreDt, String vslCallRefStsCdNm, String podClptIndSeq) {
		this.vslCallRefStsCdNm = vslCallRefStsCdNm;
		this.cstmsDeclUsrId = cstmsDeclUsrId;
		this.vpsPortCd = vpsPortCd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.vslEngNm = vslEngNm;
		this.vslCallRefStsCd = vslCallRefStsCd;
		this.blCreDt = blCreDt;
		this.vpsEtaDt = vpsEtaDt;
		this.vvdNumber = vvdNumber;
		this.vslCallRefNo = vslCallRefNo;
		this.pagerows = pagerows;
		this.podClptIndSeq = podClptIndSeq;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_call_ref_sts_cd_nm", getVslCallRefStsCdNm());
		this.hashColumns.put("cstms_decl_usr_id", getCstmsDeclUsrId());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("vsl_call_ref_sts_cd", getVslCallRefStsCd());
		this.hashColumns.put("bl_cre_dt", getBlCreDt());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("vvd_number", getVvdNumber());
		this.hashColumns.put("vsl_call_ref_no", getVslCallRefNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_call_ref_sts_cd_nm", "vslCallRefStsCdNm");
		this.hashFields.put("cstms_decl_usr_id", "cstmsDeclUsrId");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("vsl_call_ref_sts_cd", "vslCallRefStsCd");
		this.hashFields.put("bl_cre_dt", "blCreDt");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("vvd_number", "vvdNumber");
		this.hashFields.put("vsl_call_ref_no", "vslCallRefNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vslCallRefStsCdNm
	 */
	public String getVslCallRefStsCdNm() {
		return this.vslCallRefStsCdNm;
	}
	
	/**
	 * Column Info
	 * @return cstmsDeclUsrId
	 */
	public String getCstmsDeclUsrId() {
		return this.cstmsDeclUsrId;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return vslEngNm
	 */
	public String getVslEngNm() {
		return this.vslEngNm;
	}
	
	/**
	 * Column Info
	 * @return vslCallRefStsCd
	 */
	public String getVslCallRefStsCd() {
		return this.vslCallRefStsCd;
	}
	
	/**
	 * Column Info
	 * @return blCreDt
	 */
	public String getBlCreDt() {
		return this.blCreDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
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
	 * @return vslCallRefNo
	 */
	public String getVslCallRefNo() {
		return this.vslCallRefNo;
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
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
	}
	
	
	/**
	 * Column Info
	 * @param vslCallRefStsCdNm
	 */
	public void setVslCallRefStsCdNm(String vslCallRefStsCdNm) {
		this.vslCallRefStsCdNm = vslCallRefStsCdNm;
	}
	
	/**
	 * Column Info
	 * @param cstmsDeclUsrId
	 */
	public void setCstmsDeclUsrId(String cstmsDeclUsrId) {
		this.cstmsDeclUsrId = cstmsDeclUsrId;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param vslEngNm
	 */
	public void setVslEngNm(String vslEngNm) {
		this.vslEngNm = vslEngNm;
	}
	
	/**
	 * Column Info
	 * @param vslCallRefStsCd
	 */
	public void setVslCallRefStsCd(String vslCallRefStsCd) {
		this.vslCallRefStsCd = vslCallRefStsCd;
	}
	
	/**
	 * Column Info
	 * @param blCreDt
	 */
	public void setBlCreDt(String blCreDt) {
		this.blCreDt = blCreDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
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
	 * @param vslCallRefNo
	 */
	public void setVslCallRefNo(String vslCallRefNo) {
		this.vslCallRefNo = vslCallRefNo;
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
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCallRefStsCdNm(JSPUtil.getParameter(request, "vsl_call_ref_sts_cd_nm", ""));
		setCstmsDeclUsrId(JSPUtil.getParameter(request, "cstms_decl_usr_id", ""));
		setVpsPortCd(JSPUtil.getParameter(request, "vps_port_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setVslEngNm(JSPUtil.getParameter(request, "vsl_eng_nm", ""));
		setVslCallRefStsCd(JSPUtil.getParameter(request, "vsl_call_ref_sts_cd", ""));
		setBlCreDt(JSPUtil.getParameter(request, "bl_cre_dt", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setVvdNumber(JSPUtil.getParameter(request, "vvd_number", ""));
		setVslCallRefNo(JSPUtil.getParameter(request, "vsl_call_ref_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, "pod_clpt_ind_seq", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsSearchVesselArrivalVO[]
	 */
	public RocsSearchVesselArrivalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsSearchVesselArrivalVO[]
	 */
	public RocsSearchVesselArrivalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsSearchVesselArrivalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCallRefStsCdNm = (JSPUtil.getParameter(request, prefix	+ "vsl_call_ref_sts_cd_nm", length));
			String[] cstmsDeclUsrId = (JSPUtil.getParameter(request, prefix	+ "cstms_decl_usr_id", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] vslCallRefStsCd = (JSPUtil.getParameter(request, prefix	+ "vsl_call_ref_sts_cd", length));
			String[] blCreDt = (JSPUtil.getParameter(request, prefix	+ "bl_cre_dt", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] vvdNumber = (JSPUtil.getParameter(request, prefix	+ "vvd_number", length));
			String[] vslCallRefNo = (JSPUtil.getParameter(request, prefix	+ "vsl_call_ref_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq", length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsSearchVesselArrivalVO();
				if (vslCallRefStsCdNm[i] != null)
					model.setVslCallRefStsCdNm(vslCallRefStsCdNm[i]);
				if (cstmsDeclUsrId[i] != null)
					model.setCstmsDeclUsrId(cstmsDeclUsrId[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (vslCallRefStsCd[i] != null)
					model.setVslCallRefStsCd(vslCallRefStsCd[i]);
				if (blCreDt[i] != null)
					model.setBlCreDt(blCreDt[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (vvdNumber[i] != null)
					model.setVvdNumber(vvdNumber[i]);
				if (vslCallRefNo[i] != null)
					model.setVslCallRefNo(vslCallRefNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsSearchVesselArrivalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsSearchVesselArrivalVO[]
	 */
	public RocsSearchVesselArrivalVO[] getRocsSearchVesselArrivalVOs(){
		RocsSearchVesselArrivalVO[] vos = (RocsSearchVesselArrivalVO[])models.toArray(new RocsSearchVesselArrivalVO[models.size()]);
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
		this.vslCallRefStsCdNm = this.vslCallRefStsCdNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsDeclUsrId = this.cstmsDeclUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallRefStsCd = this.vslCallRefStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blCreDt = this.blCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdNumber = this.vvdNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCallRefNo = this.vslCallRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
