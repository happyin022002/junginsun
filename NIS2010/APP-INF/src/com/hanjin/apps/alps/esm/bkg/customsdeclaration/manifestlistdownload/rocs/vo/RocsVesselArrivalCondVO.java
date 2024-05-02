/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RocsVesselArrivalCondVO.java
*@FileTitle : RocsVesselArrivalCondVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.21
*@LastModifier : 임재택
*@LastVersion : 1.0
* 2009.06.21 임재택 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.rocs.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselCondVO;
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

public class RocsVesselArrivalCondVO  extends VesselCondVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<RocsVesselArrivalCondVO> models = new ArrayList<RocsVesselArrivalCondVO>();
	
	/* Column Info */
	private String frmCrnNumber = null;
	/* Column Info */
	private String vslCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String vpsEtaEndDt = null;
	/* Column Info */
	private String vpsEtaStartDt = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String podClptIndSeq = null;
	/* Column Info */
	private String mtFlag = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public RocsVesselArrivalCondVO() {}

	public RocsVesselArrivalCondVO(String ibflag, String pagerows, String vpsEtaEndDt, String vpsEtaStartDt, String vslCd, String skdDirCd, String skdVoyNo, String slanCd, String frmCrnNumber, String podClptIndSeq, String mtFlag) {
		this.frmCrnNumber = frmCrnNumber;
		this.vslCd = vslCd;
		this.ibflag = ibflag;
		this.slanCd = slanCd;
		this.skdVoyNo = skdVoyNo;
		this.vpsEtaEndDt = vpsEtaEndDt;
		this.vpsEtaStartDt = vpsEtaStartDt;
		this.skdDirCd = skdDirCd;
		this.pagerows = pagerows;
		this.podClptIndSeq = podClptIndSeq;
		this.mtFlag = mtFlag;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("frm_crn_number", getFrmCrnNumber());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("vps_eta_end_dt", getVpsEtaEndDt());
		this.hashColumns.put("vps_eta_start_dt", getVpsEtaStartDt());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pod_clpt_ind_seq", getPodClptIndSeq());
		this.hashColumns.put("mt_flag", getMtFlag());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("frm_crn_number", "frmCrnNumber");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("vps_eta_end_dt", "vpsEtaEndDt");
		this.hashFields.put("vps_eta_start_dt", "vpsEtaStartDt");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pod_clpt_ind_seq", "podClptIndSeq");
		this.hashFields.put("mt_flag", "mtFlag");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return frmCrnNumber
	 */
	public String getFrmCrnNumber() {
		return this.frmCrnNumber;
	}
	
	/**
	 * Column Info
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaEndDt
	 */
	public String getVpsEtaEndDt() {
		return this.vpsEtaEndDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaStartDt
	 */
	public String getVpsEtaStartDt() {
		return this.vpsEtaStartDt;
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
	 * @return podClptIndSeq
	 */
	public String getPodClptIndSeq() {
		return this.podClptIndSeq;
	}

	/**
	 * Column Info
	 * @return mtFlag
	 */
	public String getMtFlag() {
		return this.mtFlag;
	}
	


	/**
	 * Column Info
	 * @param frmCrnNumber
	 */
	public void setFrmCrnNumber(String frmCrnNumber) {
		this.frmCrnNumber = frmCrnNumber;
	}
	
	/**
	 * Column Info
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaEndDt
	 */
	public void setVpsEtaEndDt(String vpsEtaEndDt) {
		this.vpsEtaEndDt = vpsEtaEndDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaStartDt
	 */
	public void setVpsEtaStartDt(String vpsEtaStartDt) {
		this.vpsEtaStartDt = vpsEtaStartDt;
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
	 * @param podClptIndSeq
	 */
	public void setPodClptIndSeq(String podClptIndSeq) {
		this.podClptIndSeq = podClptIndSeq;
	}

	/**
	 * Column Info
	 * @param mtFlag
	 */
	public void setMtFlag(String mtFlag) {
		this.mtFlag = mtFlag;
	}
		
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setFrmCrnNumber(JSPUtil.getParameter(request, "frm_crn_number", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setSlanCd(JSPUtil.getParameter(request, "slan_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setVpsEtaEndDt(JSPUtil.getParameter(request, "vps_eta_end_dt", ""));
		setVpsEtaStartDt(JSPUtil.getParameter(request, "vps_eta_start_dt", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPodClptIndSeq(JSPUtil.getParameter(request, "pod_clpt_ind_seq", ""));
		setMtFlag(JSPUtil.getParameter(request, "mt_flag", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return RocsVesselArrivalCondVO[]
	 */
	public RocsVesselArrivalCondVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return RocsVesselArrivalCondVO[]
	 */
	public RocsVesselArrivalCondVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		RocsVesselArrivalCondVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] frmCrnNumber = (JSPUtil.getParameter(request, prefix	+ "frm_crn_number".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd".trim(), length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no".trim(), length));
			String[] vpsEtaEndDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_end_dt".trim(), length));
			String[] vpsEtaStartDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_start_dt".trim(), length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			String[] podClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pod_clpt_ind_seq".trim(), length));
			String[] mtFlag = (JSPUtil.getParameter(request, prefix	+ "mt_flag".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new RocsVesselArrivalCondVO();
				if (frmCrnNumber[i] != null)
					model.setFrmCrnNumber(frmCrnNumber[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (vpsEtaEndDt[i] != null)
					model.setVpsEtaEndDt(vpsEtaEndDt[i]);
				if (vpsEtaStartDt[i] != null)
					model.setVpsEtaStartDt(vpsEtaStartDt[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (podClptIndSeq[i] != null)
					model.setPodClptIndSeq(podClptIndSeq[i]);
				if (mtFlag[i] != null)
					model.setMtFlag(mtFlag[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getRocsVesselArrivalCondVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return RocsVesselArrivalCondVO[]
	 */
	public RocsVesselArrivalCondVO[] getRocsVesselArrivalCondVOs(){
		RocsVesselArrivalCondVO[] vos = (RocsVesselArrivalCondVO[])models.toArray(new RocsVesselArrivalCondVO[models.size()]);
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
		this.frmCrnNumber = this.frmCrnNumber .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaEndDt = this.vpsEtaEndDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaStartDt = this.vpsEtaStartDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podClptIndSeq = this.podClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtFlag = this.mtFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
