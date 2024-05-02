/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DoNotificationSendCntrListVO.java
*@FileTitle : DoNotificationSendCntrListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

public class DoNotificationSendCntrListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<DoNotificationSendCntrListVO> models = new ArrayList<DoNotificationSendCntrListVO>();
	
	/* Column Info */
	private String toNodCd = null;
	/* Column Info */
	private String podNm = null;
	/* Column Info */
	private String ibVvdCd = null;
	/* Column Info */
	private String delNm = null;
	/* Column Info */
	private String dorNodYard = null;
	/* Column Info */
	private String toNodYard = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String railRamp = null;
	/* Column Info */
	private String locOfcTime = null;
	/* Column Info */
	private String ctrlOfcCd = null;
	/* Column Info */
	private String fmNodYard = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String fmNodCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String railEtaDt = null;
	/* Column Info */
	private String bkgNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String dorNodCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public DoNotificationSendCntrListVO() {}

	public DoNotificationSendCntrListVO(String ibflag, String pagerows, String blNo, String cntrNo, String podNm, String delNm, String vvd, String etaDt, String railRamp, String railEtaDt, String locOfcTime, String cntrTpszCd, String ctrlOfcCd, String fmNodCd, String fmNodYard, String toNodCd, String toNodYard, String dorNodCd, String dorNodYard, String bkgNo, String ibVvdCd) {
		this.toNodCd = toNodCd;
		this.podNm = podNm;
		this.ibVvdCd = ibVvdCd;
		this.delNm = delNm;
		this.dorNodYard = dorNodYard;
		this.toNodYard = toNodYard;
		this.etaDt = etaDt;
		this.railRamp = railRamp;
		this.locOfcTime = locOfcTime;
		this.ctrlOfcCd = ctrlOfcCd;
		this.fmNodYard = fmNodYard;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.fmNodCd = fmNodCd;
		this.vvd = vvd;
		this.railEtaDt = railEtaDt;
		this.bkgNo = bkgNo;
		this.ibflag = ibflag;
		this.cntrNo = cntrNo;
		this.cntrTpszCd = cntrTpszCd;
		this.dorNodCd = dorNodCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("to_nod_cd", getToNodCd());
		this.hashColumns.put("pod_nm", getPodNm());
		this.hashColumns.put("ib_vvd_cd", getIbVvdCd());
		this.hashColumns.put("del_nm", getDelNm());
		this.hashColumns.put("dor_nod_yard", getDorNodYard());
		this.hashColumns.put("to_nod_yard", getToNodYard());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("rail_ramp", getRailRamp());
		this.hashColumns.put("loc_ofc_time", getLocOfcTime());
		this.hashColumns.put("ctrl_ofc_cd", getCtrlOfcCd());
		this.hashColumns.put("fm_nod_yard", getFmNodYard());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("fm_nod_cd", getFmNodCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("rail_eta_dt", getRailEtaDt());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("dor_nod_cd", getDorNodCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("to_nod_cd", "toNodCd");
		this.hashFields.put("pod_nm", "podNm");
		this.hashFields.put("ib_vvd_cd", "ibVvdCd");
		this.hashFields.put("del_nm", "delNm");
		this.hashFields.put("dor_nod_yard", "dorNodYard");
		this.hashFields.put("to_nod_yard", "toNodYard");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("rail_ramp", "railRamp");
		this.hashFields.put("loc_ofc_time", "locOfcTime");
		this.hashFields.put("ctrl_ofc_cd", "ctrlOfcCd");
		this.hashFields.put("fm_nod_yard", "fmNodYard");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("fm_nod_cd", "fmNodCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("rail_eta_dt", "railEtaDt");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("dor_nod_cd", "dorNodCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return toNodCd
	 */
	public String getToNodCd() {
		return this.toNodCd;
	}
	
	/**
	 * Column Info
	 * @return podNm
	 */
	public String getPodNm() {
		return this.podNm;
	}
	
	/**
	 * Column Info
	 * @return ibVvdCd
	 */
	public String getIbVvdCd() {
		return this.ibVvdCd;
	}
	
	/**
	 * Column Info
	 * @return delNm
	 */
	public String getDelNm() {
		return this.delNm;
	}
	
	/**
	 * Column Info
	 * @return dorNodYard
	 */
	public String getDorNodYard() {
		return this.dorNodYard;
	}
	
	/**
	 * Column Info
	 * @return toNodYard
	 */
	public String getToNodYard() {
		return this.toNodYard;
	}
	
	/**
	 * Column Info
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return railRamp
	 */
	public String getRailRamp() {
		return this.railRamp;
	}
	
	/**
	 * Column Info
	 * @return locOfcTime
	 */
	public String getLocOfcTime() {
		return this.locOfcTime;
	}
	
	/**
	 * Column Info
	 * @return ctrlOfcCd
	 */
	public String getCtrlOfcCd() {
		return this.ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @return fmNodYard
	 */
	public String getFmNodYard() {
		return this.fmNodYard;
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
	 * @return fmNodCd
	 */
	public String getFmNodCd() {
		return this.fmNodCd;
	}
	
	/**
	 * Column Info
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return railEtaDt
	 */
	public String getRailEtaDt() {
		return this.railEtaDt;
	}
	
	/**
	 * Column Info
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return dorNodCd
	 */
	public String getDorNodCd() {
		return this.dorNodCd;
	}
	

	/**
	 * Column Info
	 * @param toNodCd
	 */
	public void setToNodCd(String toNodCd) {
		this.toNodCd = toNodCd;
	}
	
	/**
	 * Column Info
	 * @param podNm
	 */
	public void setPodNm(String podNm) {
		this.podNm = podNm;
	}
	
	/**
	 * Column Info
	 * @param ibVvdCd
	 */
	public void setIbVvdCd(String ibVvdCd) {
		this.ibVvdCd = ibVvdCd;
	}
	
	/**
	 * Column Info
	 * @param delNm
	 */
	public void setDelNm(String delNm) {
		this.delNm = delNm;
	}
	
	/**
	 * Column Info
	 * @param dorNodYard
	 */
	public void setDorNodYard(String dorNodYard) {
		this.dorNodYard = dorNodYard;
	}
	
	/**
	 * Column Info
	 * @param toNodYard
	 */
	public void setToNodYard(String toNodYard) {
		this.toNodYard = toNodYard;
	}
	
	/**
	 * Column Info
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param railRamp
	 */
	public void setRailRamp(String railRamp) {
		this.railRamp = railRamp;
	}
	
	/**
	 * Column Info
	 * @param locOfcTime
	 */
	public void setLocOfcTime(String locOfcTime) {
		this.locOfcTime = locOfcTime;
	}
	
	/**
	 * Column Info
	 * @param ctrlOfcCd
	 */
	public void setCtrlOfcCd(String ctrlOfcCd) {
		this.ctrlOfcCd = ctrlOfcCd;
	}
	
	/**
	 * Column Info
	 * @param fmNodYard
	 */
	public void setFmNodYard(String fmNodYard) {
		this.fmNodYard = fmNodYard;
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
	 * @param fmNodCd
	 */
	public void setFmNodCd(String fmNodCd) {
		this.fmNodCd = fmNodCd;
	}
	
	/**
	 * Column Info
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param railEtaDt
	 */
	public void setRailEtaDt(String railEtaDt) {
		this.railEtaDt = railEtaDt;
	}
	
	/**
	 * Column Info
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param dorNodCd
	 */
	public void setDorNodCd(String dorNodCd) {
		this.dorNodCd = dorNodCd;
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
		setToNodCd(JSPUtil.getParameter(request, prefix + "to_nod_cd", ""));
		setPodNm(JSPUtil.getParameter(request, prefix + "pod_nm", ""));
		setIbVvdCd(JSPUtil.getParameter(request, prefix + "ib_vvd_cd", ""));
		setDelNm(JSPUtil.getParameter(request, prefix + "del_nm", ""));
		setDorNodYard(JSPUtil.getParameter(request, prefix + "dor_nod_yard", ""));
		setToNodYard(JSPUtil.getParameter(request, prefix + "to_nod_yard", ""));
		setEtaDt(JSPUtil.getParameter(request, prefix + "eta_dt", ""));
		setRailRamp(JSPUtil.getParameter(request, prefix + "rail_ramp", ""));
		setLocOfcTime(JSPUtil.getParameter(request, prefix + "loc_ofc_time", ""));
		setCtrlOfcCd(JSPUtil.getParameter(request, prefix + "ctrl_ofc_cd", ""));
		setFmNodYard(JSPUtil.getParameter(request, prefix + "fm_nod_yard", ""));
		setBlNo(JSPUtil.getParameter(request, prefix + "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setFmNodCd(JSPUtil.getParameter(request, prefix + "fm_nod_cd", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setRailEtaDt(JSPUtil.getParameter(request, prefix + "rail_eta_dt", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setDorNodCd(JSPUtil.getParameter(request, prefix + "dor_nod_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoNotificationSendCntrListVO[]
	 */
	public DoNotificationSendCntrListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoNotificationSendCntrListVO[]
	 */
	public DoNotificationSendCntrListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoNotificationSendCntrListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] toNodCd = (JSPUtil.getParameter(request, prefix	+ "to_nod_cd", length));
			String[] podNm = (JSPUtil.getParameter(request, prefix	+ "pod_nm", length));
			String[] ibVvdCd = (JSPUtil.getParameter(request, prefix	+ "ib_vvd_cd", length));
			String[] delNm = (JSPUtil.getParameter(request, prefix	+ "del_nm", length));
			String[] dorNodYard = (JSPUtil.getParameter(request, prefix	+ "dor_nod_yard", length));
			String[] toNodYard = (JSPUtil.getParameter(request, prefix	+ "to_nod_yard", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] railRamp = (JSPUtil.getParameter(request, prefix	+ "rail_ramp", length));
			String[] locOfcTime = (JSPUtil.getParameter(request, prefix	+ "loc_ofc_time", length));
			String[] ctrlOfcCd = (JSPUtil.getParameter(request, prefix	+ "ctrl_ofc_cd", length));
			String[] fmNodYard = (JSPUtil.getParameter(request, prefix	+ "fm_nod_yard", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] fmNodCd = (JSPUtil.getParameter(request, prefix	+ "fm_nod_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] railEtaDt = (JSPUtil.getParameter(request, prefix	+ "rail_eta_dt", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] dorNodCd = (JSPUtil.getParameter(request, prefix	+ "dor_nod_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new DoNotificationSendCntrListVO();
				if (toNodCd[i] != null)
					model.setToNodCd(toNodCd[i]);
				if (podNm[i] != null)
					model.setPodNm(podNm[i]);
				if (ibVvdCd[i] != null)
					model.setIbVvdCd(ibVvdCd[i]);
				if (delNm[i] != null)
					model.setDelNm(delNm[i]);
				if (dorNodYard[i] != null)
					model.setDorNodYard(dorNodYard[i]);
				if (toNodYard[i] != null)
					model.setToNodYard(toNodYard[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (railRamp[i] != null)
					model.setRailRamp(railRamp[i]);
				if (locOfcTime[i] != null)
					model.setLocOfcTime(locOfcTime[i]);
				if (ctrlOfcCd[i] != null)
					model.setCtrlOfcCd(ctrlOfcCd[i]);
				if (fmNodYard[i] != null)
					model.setFmNodYard(fmNodYard[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (fmNodCd[i] != null)
					model.setFmNodCd(fmNodCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (railEtaDt[i] != null)
					model.setRailEtaDt(railEtaDt[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (dorNodCd[i] != null)
					model.setDorNodCd(dorNodCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoNotificationSendCntrListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoNotificationSendCntrListVO[]
	 */
	public DoNotificationSendCntrListVO[] getDoNotificationSendCntrListVOs(){
		DoNotificationSendCntrListVO[] vos = (DoNotificationSendCntrListVO[])models.toArray(new DoNotificationSendCntrListVO[models.size()]);
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
		this.toNodCd = this.toNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNm = this.podNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibVvdCd = this.ibVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNm = this.delNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodYard = this.dorNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.toNodYard = this.toNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railRamp = this.railRamp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locOfcTime = this.locOfcTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ctrlOfcCd = this.ctrlOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodYard = this.fmNodYard .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmNodCd = this.fmNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.railEtaDt = this.railEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dorNodCd = this.dorNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
