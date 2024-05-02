/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EdiMsgNis2010VskUbizHjsVendorVskVO.java
*@FileTitle : EdiMsgNis2010VskUbizHjsVendorVskVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.10
*@LastModifier : 정명훈
*@LastVersion : 1.0
* 2009.07.10 정명훈 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.vop.vsk.scheduleplanningoperation.vesselschedulemgt.vo;

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
 * @author 정명훈
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class EdiMsgNis2010VskUbizHjsVendorVskVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<EdiMsgNis2010VskUbizHjsVendorVskVO> models = new ArrayList<EdiMsgNis2010VskUbizHjsVendorVskVO>();
	
	/* Column Info */
	private String laneCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String etaDt = null;
	/* Column Info */
	private String cctDt = null;
	/* Column Info */
	private String contactFax = null;
	/* Column Info */
	private String contactTel = null;
	/* Page Number */
	private String pagerows = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String tmnlVsl = null;
	/* Column Info */
	private String callSign = null;
	/* Column Info */
	private String dirCd = null;
	/* Column Info */
	private String etbDt = null;
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String voyNo = null;
	/* Column Info */
	private String contactPer = null;
	/* Column Info */
	private String laneNm = null;
	/* Column Info */
	private String contactEmail = null;
	/* Column Info */
	private String locDesx = null;
	/* Column Info */
	private String iMrnNo = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String etdDt = null;
	/* Column Info */
	private String oMrnNo = null;
	/* Column Info */
	private String tmnlVoy = null;
	/* Column Info */
	private String brac = null;
	/* Column Info */
	private String contactId = null;
	/* Column Info */
	private String freeTm = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String portInd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public EdiMsgNis2010VskUbizHjsVendorVskVO() {}

	public EdiMsgNis2010VskUbizHjsVendorVskVO(String ibflag, String pagerows, String brac, String vslCd, String vslNm, String voyNo, String dirCd, String callSign, String laneCd, String laneNm, String tmnlVsl, String tmnlVoy, String oMrnNo, String iMrnNo, String rmk, String portInd, String locCd, String locDesx, String ydCd, String etaDt, String etdDt, String etbDt, String cctDt, String freeTm, String contactId, String contactPer, String contactTel, String contactFax, String contactEmail) {
		this.laneCd = laneCd;
		this.vslCd = vslCd;
		this.etaDt = etaDt;
		this.cctDt = cctDt;
		this.contactFax = contactFax;
		this.contactTel = contactTel;
		this.pagerows = pagerows;
		this.ibflag = ibflag;
		this.locCd = locCd;
		this.tmnlVsl = tmnlVsl;
		this.callSign = callSign;
		this.dirCd = dirCd;
		this.etbDt = etbDt;
		this.rmk = rmk;
		this.voyNo = voyNo;
		this.contactPer = contactPer;
		this.laneNm = laneNm;
		this.contactEmail = contactEmail;
		this.locDesx = locDesx;
		this.iMrnNo = iMrnNo;
		this.vslNm = vslNm;
		this.etdDt = etdDt;
		this.oMrnNo = oMrnNo;
		this.tmnlVoy = tmnlVoy;
		this.brac = brac;
		this.contactId = contactId;
		this.freeTm = freeTm;
		this.ydCd = ydCd;
		this.portInd = portInd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("lane_cd", getLaneCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("eta_dt", getEtaDt());
		this.hashColumns.put("cct_dt", getCctDt());
		this.hashColumns.put("contact_fax", getContactFax());
		this.hashColumns.put("contact_tel", getContactTel());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("tmnl_vsl", getTmnlVsl());
		this.hashColumns.put("call_sign", getCallSign());
		this.hashColumns.put("dir_cd", getDirCd());
		this.hashColumns.put("etb_dt", getEtbDt());
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("voy_no", getVoyNo());
		this.hashColumns.put("contact_per", getContactPer());
		this.hashColumns.put("lane_nm", getLaneNm());
		this.hashColumns.put("contact_email", getContactEmail());
		this.hashColumns.put("loc_desx", getLocDesx());
		this.hashColumns.put("i_mrn_no", getIMrnNo());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("etd_dt", getEtdDt());
		this.hashColumns.put("o_mrn_no", getOMrnNo());
		this.hashColumns.put("tmnl_voy", getTmnlVoy());
		this.hashColumns.put("brac", getBrac());
		this.hashColumns.put("contact_id", getContactId());
		this.hashColumns.put("free_tm", getFreeTm());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("port_ind", getPortInd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("lane_cd", "laneCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("eta_dt", "etaDt");
		this.hashFields.put("cct_dt", "cctDt");
		this.hashFields.put("contact_fax", "contactFax");
		this.hashFields.put("contact_tel", "contactTel");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("tmnl_vsl", "tmnlVsl");
		this.hashFields.put("call_sign", "callSign");
		this.hashFields.put("dir_cd", "dirCd");
		this.hashFields.put("etb_dt", "etbDt");
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("voy_no", "voyNo");
		this.hashFields.put("contact_per", "contactPer");
		this.hashFields.put("lane_nm", "laneNm");
		this.hashFields.put("contact_email", "contactEmail");
		this.hashFields.put("loc_desx", "locDesx");
		this.hashFields.put("i_mrn_no", "iMrnNo");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("etd_dt", "etdDt");
		this.hashFields.put("o_mrn_no", "oMrnNo");
		this.hashFields.put("tmnl_voy", "tmnlVoy");
		this.hashFields.put("brac", "brac");
		this.hashFields.put("contact_id", "contactId");
		this.hashFields.put("free_tm", "freeTm");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("port_ind", "portInd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return laneCd
	 */
	public String getLaneCd() {
		return this.laneCd;
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
	 * @return etaDt
	 */
	public String getEtaDt() {
		return this.etaDt;
	}
	
	/**
	 * Column Info
	 * @return cctDt
	 */
	public String getCctDt() {
		return this.cctDt;
	}
	
	/**
	 * Column Info
	 * @return contactFax
	 */
	public String getContactFax() {
		return this.contactFax;
	}
	
	/**
	 * Column Info
	 * @return contactTel
	 */
	public String getContactTel() {
		return this.contactTel;
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
	 * @return locCd
	 */
	public String getLocCd() {
		return this.locCd;
	}
	
	/**
	 * Column Info
	 * @return tmnlVsl
	 */
	public String getTmnlVsl() {
		return this.tmnlVsl;
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
	 * @return dirCd
	 */
	public String getDirCd() {
		return this.dirCd;
	}
	
	/**
	 * Column Info
	 * @return etbDt
	 */
	public String getEtbDt() {
		return this.etbDt;
	}
	
	/**
	 * Column Info
	 * @return rmk
	 */
	public String getRmk() {
		return this.rmk;
	}
	
	/**
	 * Column Info
	 * @return voyNo
	 */
	public String getVoyNo() {
		return this.voyNo;
	}
	
	/**
	 * Column Info
	 * @return contactPer
	 */
	public String getContactPer() {
		return this.contactPer;
	}
	
	/**
	 * Column Info
	 * @return laneNm
	 */
	public String getLaneNm() {
		return this.laneNm;
	}
	
	/**
	 * Column Info
	 * @return contactEmail
	 */
	public String getContactEmail() {
		return this.contactEmail;
	}
	
	/**
	 * Column Info
	 * @return locDesx
	 */
	public String getLocDesx() {
		return this.locDesx;
	}
	
	/**
	 * Column Info
	 * @return iMrnNo
	 */
	public String getIMrnNo() {
		return this.iMrnNo;
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
	 * @return etdDt
	 */
	public String getEtdDt() {
		return this.etdDt;
	}
	
	/**
	 * Column Info
	 * @return oMrnNo
	 */
	public String getOMrnNo() {
		return this.oMrnNo;
	}
	
	/**
	 * Column Info
	 * @return tmnlVoy
	 */
	public String getTmnlVoy() {
		return this.tmnlVoy;
	}
	
	/**
	 * Column Info
	 * @return brac
	 */
	public String getBrac() {
		return this.brac;
	}
	
	/**
	 * Column Info
	 * @return contactId
	 */
	public String getContactId() {
		return this.contactId;
	}
	
	/**
	 * Column Info
	 * @return freeTm
	 */
	public String getFreeTm() {
		return this.freeTm;
	}
	
	/**
	 * Column Info
	 * @return ydCd
	 */
	public String getYdCd() {
		return this.ydCd;
	}
	
	/**
	 * Column Info
	 * @return portInd
	 */
	public String getPortInd() {
		return this.portInd;
	}
	

	/**
	 * Column Info
	 * @param laneCd
	 */
	public void setLaneCd(String laneCd) {
		this.laneCd = laneCd;
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
	 * @param etaDt
	 */
	public void setEtaDt(String etaDt) {
		this.etaDt = etaDt;
	}
	
	/**
	 * Column Info
	 * @param cctDt
	 */
	public void setCctDt(String cctDt) {
		this.cctDt = cctDt;
	}
	
	/**
	 * Column Info
	 * @param contactFax
	 */
	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}
	
	/**
	 * Column Info
	 * @param contactTel
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
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
	 * @param locCd
	 */
	public void setLocCd(String locCd) {
		this.locCd = locCd;
	}
	
	/**
	 * Column Info
	 * @param tmnlVsl
	 */
	public void setTmnlVsl(String tmnlVsl) {
		this.tmnlVsl = tmnlVsl;
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
	 * @param dirCd
	 */
	public void setDirCd(String dirCd) {
		this.dirCd = dirCd;
	}
	
	/**
	 * Column Info
	 * @param etbDt
	 */
	public void setEtbDt(String etbDt) {
		this.etbDt = etbDt;
	}
	
	/**
	 * Column Info
	 * @param rmk
	 */
	public void setRmk(String rmk) {
		this.rmk = rmk;
	}
	
	/**
	 * Column Info
	 * @param voyNo
	 */
	public void setVoyNo(String voyNo) {
		this.voyNo = voyNo;
	}
	
	/**
	 * Column Info
	 * @param contactPer
	 */
	public void setContactPer(String contactPer) {
		this.contactPer = contactPer;
	}
	
	/**
	 * Column Info
	 * @param laneNm
	 */
	public void setLaneNm(String laneNm) {
		this.laneNm = laneNm;
	}
	
	/**
	 * Column Info
	 * @param contactEmail
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	
	/**
	 * Column Info
	 * @param locDesx
	 */
	public void setLocDesx(String locDesx) {
		this.locDesx = locDesx;
	}
	
	/**
	 * Column Info
	 * @param iMrnNo
	 */
	public void setIMrnNo(String iMrnNo) {
		this.iMrnNo = iMrnNo;
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
	 * @param etdDt
	 */
	public void setEtdDt(String etdDt) {
		this.etdDt = etdDt;
	}
	
	/**
	 * Column Info
	 * @param oMrnNo
	 */
	public void setOMrnNo(String oMrnNo) {
		this.oMrnNo = oMrnNo;
	}
	
	/**
	 * Column Info
	 * @param tmnlVoy
	 */
	public void setTmnlVoy(String tmnlVoy) {
		this.tmnlVoy = tmnlVoy;
	}
	
	/**
	 * Column Info
	 * @param brac
	 */
	public void setBrac(String brac) {
		this.brac = brac;
	}
	
	/**
	 * Column Info
	 * @param contactId
	 */
	public void setContactId(String contactId) {
		this.contactId = contactId;
	}
	
	/**
	 * Column Info
	 * @param freeTm
	 */
	public void setFreeTm(String freeTm) {
		this.freeTm = freeTm;
	}
	
	/**
	 * Column Info
	 * @param ydCd
	 */
	public void setYdCd(String ydCd) {
		this.ydCd = ydCd;
	}
	
	/**
	 * Column Info
	 * @param portInd
	 */
	public void setPortInd(String portInd) {
		this.portInd = portInd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setLaneCd(JSPUtil.getParameter(request, "lane_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setEtaDt(JSPUtil.getParameter(request, "eta_dt", ""));
		setCctDt(JSPUtil.getParameter(request, "cct_dt", ""));
		setContactFax(JSPUtil.getParameter(request, "contact_fax", ""));
		setContactTel(JSPUtil.getParameter(request, "contact_tel", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setTmnlVsl(JSPUtil.getParameter(request, "tmnl_vsl", ""));
		setCallSign(JSPUtil.getParameter(request, "call_sign", ""));
		setDirCd(JSPUtil.getParameter(request, "dir_cd", ""));
		setEtbDt(JSPUtil.getParameter(request, "etb_dt", ""));
		setRmk(JSPUtil.getParameter(request, "rmk", ""));
		setVoyNo(JSPUtil.getParameter(request, "voy_no", ""));
		setContactPer(JSPUtil.getParameter(request, "contact_per", ""));
		setLaneNm(JSPUtil.getParameter(request, "lane_nm", ""));
		setContactEmail(JSPUtil.getParameter(request, "contact_email", ""));
		setLocDesx(JSPUtil.getParameter(request, "loc_desx", ""));
		setIMrnNo(JSPUtil.getParameter(request, "i_mrn_no", ""));
		setVslNm(JSPUtil.getParameter(request, "vsl_nm", ""));
		setEtdDt(JSPUtil.getParameter(request, "etd_dt", ""));
		setOMrnNo(JSPUtil.getParameter(request, "o_mrn_no", ""));
		setTmnlVoy(JSPUtil.getParameter(request, "tmnl_voy", ""));
		setBrac(JSPUtil.getParameter(request, "brac", ""));
		setContactId(JSPUtil.getParameter(request, "contact_id", ""));
		setFreeTm(JSPUtil.getParameter(request, "free_tm", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setPortInd(JSPUtil.getParameter(request, "port_ind", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return EdiMsgNis2010VskUbizHjsVendorVskVO[]
	 */
	public EdiMsgNis2010VskUbizHjsVendorVskVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return EdiMsgNis2010VskUbizHjsVendorVskVO[]
	 */
	public EdiMsgNis2010VskUbizHjsVendorVskVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		EdiMsgNis2010VskUbizHjsVendorVskVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] laneCd = (JSPUtil.getParameter(request, prefix	+ "lane_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] etaDt = (JSPUtil.getParameter(request, prefix	+ "eta_dt", length));
			String[] cctDt = (JSPUtil.getParameter(request, prefix	+ "cct_dt", length));
			String[] contactFax = (JSPUtil.getParameter(request, prefix	+ "contact_fax", length));
			String[] contactTel = (JSPUtil.getParameter(request, prefix	+ "contact_tel", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] tmnlVsl = (JSPUtil.getParameter(request, prefix	+ "tmnl_vsl", length));
			String[] callSign = (JSPUtil.getParameter(request, prefix	+ "call_sign", length));
			String[] dirCd = (JSPUtil.getParameter(request, prefix	+ "dir_cd", length));
			String[] etbDt = (JSPUtil.getParameter(request, prefix	+ "etb_dt", length));
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] voyNo = (JSPUtil.getParameter(request, prefix	+ "voy_no", length));
			String[] contactPer = (JSPUtil.getParameter(request, prefix	+ "contact_per", length));
			String[] laneNm = (JSPUtil.getParameter(request, prefix	+ "lane_nm", length));
			String[] contactEmail = (JSPUtil.getParameter(request, prefix	+ "contact_email", length));
			String[] locDesx = (JSPUtil.getParameter(request, prefix	+ "loc_desx", length));
			String[] iMrnNo = (JSPUtil.getParameter(request, prefix	+ "i_mrn_no", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] etdDt = (JSPUtil.getParameter(request, prefix	+ "etd_dt", length));
			String[] oMrnNo = (JSPUtil.getParameter(request, prefix	+ "o_mrn_no", length));
			String[] tmnlVoy = (JSPUtil.getParameter(request, prefix	+ "tmnl_voy", length));
			String[] brac = (JSPUtil.getParameter(request, prefix	+ "brac", length));
			String[] contactId = (JSPUtil.getParameter(request, prefix	+ "contact_id", length));
			String[] freeTm = (JSPUtil.getParameter(request, prefix	+ "free_tm", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] portInd = (JSPUtil.getParameter(request, prefix	+ "port_ind", length));
			
			for (int i = 0; i < length; i++) {
				model = new EdiMsgNis2010VskUbizHjsVendorVskVO();
				if (laneCd[i] != null)
					model.setLaneCd(laneCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (etaDt[i] != null)
					model.setEtaDt(etaDt[i]);
				if (cctDt[i] != null)
					model.setCctDt(cctDt[i]);
				if (contactFax[i] != null)
					model.setContactFax(contactFax[i]);
				if (contactTel[i] != null)
					model.setContactTel(contactTel[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (tmnlVsl[i] != null)
					model.setTmnlVsl(tmnlVsl[i]);
				if (callSign[i] != null)
					model.setCallSign(callSign[i]);
				if (dirCd[i] != null)
					model.setDirCd(dirCd[i]);
				if (etbDt[i] != null)
					model.setEtbDt(etbDt[i]);
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (voyNo[i] != null)
					model.setVoyNo(voyNo[i]);
				if (contactPer[i] != null)
					model.setContactPer(contactPer[i]);
				if (laneNm[i] != null)
					model.setLaneNm(laneNm[i]);
				if (contactEmail[i] != null)
					model.setContactEmail(contactEmail[i]);
				if (locDesx[i] != null)
					model.setLocDesx(locDesx[i]);
				if (iMrnNo[i] != null)
					model.setIMrnNo(iMrnNo[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (etdDt[i] != null)
					model.setEtdDt(etdDt[i]);
				if (oMrnNo[i] != null)
					model.setOMrnNo(oMrnNo[i]);
				if (tmnlVoy[i] != null)
					model.setTmnlVoy(tmnlVoy[i]);
				if (brac[i] != null)
					model.setBrac(brac[i]);
				if (contactId[i] != null)
					model.setContactId(contactId[i]);
				if (freeTm[i] != null)
					model.setFreeTm(freeTm[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (portInd[i] != null)
					model.setPortInd(portInd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getEdiMsgNis2010VskUbizHjsVendorVskVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return EdiMsgNis2010VskUbizHjsVendorVskVO[]
	 */
	public EdiMsgNis2010VskUbizHjsVendorVskVO[] getEdiMsgNis2010VskUbizHjsVendorVskVOs(){
		EdiMsgNis2010VskUbizHjsVendorVskVO[] vos = (EdiMsgNis2010VskUbizHjsVendorVskVO[])models.toArray(new EdiMsgNis2010VskUbizHjsVendorVskVO[models.size()]);
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
		this.laneCd = this.laneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etaDt = this.etaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cctDt = this.cctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactFax = this.contactFax .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactTel = this.contactTel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlVsl = this.tmnlVsl .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSign = this.callSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dirCd = this.dirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etbDt = this.etbDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.voyNo = this.voyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactPer = this.contactPer .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.laneNm = this.laneNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactEmail = this.contactEmail .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locDesx = this.locDesx .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.iMrnNo = this.iMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etdDt = this.etdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oMrnNo = this.oMrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tmnlVoy = this.tmnlVoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brac = this.brac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.contactId = this.contactId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeTm = this.freeTm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.portInd = this.portInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
