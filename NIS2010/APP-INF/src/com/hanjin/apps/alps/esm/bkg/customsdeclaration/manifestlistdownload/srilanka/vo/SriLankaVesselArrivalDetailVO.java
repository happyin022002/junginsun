/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SriLankaVesselArrivalDetailVO.java
*@FileTitle : SriLankaVesselArrivalDetailVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.27
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.27  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.srilanka.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.VesselArrivalDetailVO;
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

public class SriLankaVesselArrivalDetailVO extends VesselArrivalDetailVO {

	private static final long serialVersionUID = 1L;
	
	private Collection<SriLankaVesselArrivalDetailVO> models = new ArrayList<SriLankaVesselArrivalDetailVO>();
	
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String srStsCd = null;
	/* Column Info */
	private String arrivalPort = null;
	/* Column Info */
	private String depaturePort = null;
	/* Column Info */
	private String vslRgstNo = null;
	/* Column Info */
	private String srCmtDesc = null;
	/* Column Info */
	private String cstmsVvdCd = null;
	/* Column Info */
	private String srStsDesc = null;
	/* Column Info */
	private String vslNm = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String vpsEtaDtTime = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String declBlQty = null;
	/* Column Info */
	private String msgRefNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String vslRgstCntCd = null;
	/* Column Info */
	private String vslNm2 = null;
	/* Column Info */
	private String vslEngNm = null;
	/* Column Info */
	private String rjctDt = null;
	/* Column Info */
	private String vpsEtdDtTime = null;
	/* Column Info */
	private String capNm = null;
	/* Column Info */
	private String rgstDt = null;
	/* Column Info */
	private String vslAuthNo = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public SriLankaVesselArrivalDetailVO() {}

	public SriLankaVesselArrivalDetailVO(String ibflag, String pagerows, String vpsEtdDt, String srStsCd, String arrivalPort, String vslRgstNo, String srCmtDesc, String cstmsVvdCd, String srStsDesc, String vslNm, String vpsEtaDt, String vpsEtaDtTime, String msgRefNo, String declBlQty, String vslEngNm, String vslNm2, String vslRgstCntCd, String rjctDt, String vpsEtdDtTime, String rgstDt, String capNm, String vslAuthNo, String depaturePort) {
		this.vpsEtdDt = vpsEtdDt;
		this.srStsCd = srStsCd;
		this.arrivalPort = arrivalPort;
		this.depaturePort = depaturePort;
		this.vslRgstNo = vslRgstNo;
		this.srCmtDesc = srCmtDesc;
		this.cstmsVvdCd = cstmsVvdCd;
		this.srStsDesc = srStsDesc;
		this.vslNm = vslNm;
		this.vpsEtaDt = vpsEtaDt;
		this.vpsEtaDtTime = vpsEtaDtTime;
		this.pagerows = pagerows;
		this.declBlQty = declBlQty;
		this.msgRefNo = msgRefNo;
		this.ibflag = ibflag;
		this.vslRgstCntCd = vslRgstCntCd;
		this.vslNm2 = vslNm2;
		this.vslEngNm = vslEngNm;
		this.rjctDt = rjctDt;
		this.vpsEtdDtTime = vpsEtdDtTime;
		this.capNm = capNm;
		this.rgstDt = rgstDt;
		this.vslAuthNo = vslAuthNo;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("sr_sts_cd", getSrStsCd());
		this.hashColumns.put("arrival_port", getArrivalPort());
		this.hashColumns.put("depature_port", getDepaturePort());
		this.hashColumns.put("vsl_rgst_no", getVslRgstNo());
		this.hashColumns.put("sr_cmt_desc", getSrCmtDesc());
		this.hashColumns.put("cstms_vvd_cd", getCstmsVvdCd());
		this.hashColumns.put("sr_sts_desc", getSrStsDesc());
		this.hashColumns.put("vsl_nm", getVslNm());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("vps_eta_dt_time", getVpsEtaDtTime());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("decl_bl_qty", getDeclBlQty());
		this.hashColumns.put("msg_ref_no", getMsgRefNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("vsl_rgst_cnt_cd", getVslRgstCntCd());
		this.hashColumns.put("vsl_nm2", getVslNm2());
		this.hashColumns.put("vsl_eng_nm", getVslEngNm());
		this.hashColumns.put("rjct_dt", getRjctDt());
		this.hashColumns.put("vps_etd_dt_time", getVpsEtdDtTime());
		this.hashColumns.put("cap_nm", getCapNm());
		this.hashColumns.put("rgst_dt", getRgstDt());
		this.hashColumns.put("vsl_auth_no", getVslAuthNo());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("sr_sts_cd", "srStsCd");
		this.hashFields.put("arrival_port", "arrivalPort");
		this.hashFields.put("depature_port", "depaturePort");
		this.hashFields.put("vsl_rgst_no", "vslRgstNo");
		this.hashFields.put("sr_cmt_desc", "srCmtDesc");
		this.hashFields.put("cstms_vvd_cd", "cstmsVvdCd");
		this.hashFields.put("sr_sts_desc", "srStsDesc");
		this.hashFields.put("vsl_nm", "vslNm");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("vps_eta_dt_time", "vpsEtaDtTime");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("decl_bl_qty", "declBlQty");
		this.hashFields.put("msg_ref_no", "msgRefNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("vsl_rgst_cnt_cd", "vslRgstCntCd");
		this.hashFields.put("vsl_nm2", "vslNm2");
		this.hashFields.put("vsl_eng_nm", "vslEngNm");
		this.hashFields.put("rjct_dt", "rjctDt");
		this.hashFields.put("vps_etd_dt_time", "vpsEtdDtTime");
		this.hashFields.put("cap_nm", "capNm");
		this.hashFields.put("rgst_dt", "rgstDt");
		this.hashFields.put("vsl_auth_no", "vslAuthNo");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDt
	 */
	public String getVpsEtdDt() {
		return this.vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @return srStsCd
	 */
	public String getSrStsCd() {
		return this.srStsCd;
	}
	
	/**
	 * Column Info
	 * @return arrivalPort
	 */
	public String getArrivalPort() {
		return this.arrivalPort;
	}
	
	/**
	 * Column Info
	 * @return depaturePort
	 */
	public String getDepaturePort() {
		return this.depaturePort;
	}
	
	/**
	 * Column Info
	 * @return vslRgstNo
	 */
	public String getVslRgstNo() {
		return this.vslRgstNo;
	}
	
	/**
	 * Column Info
	 * @return srCmtDesc
	 */
	public String getSrCmtDesc() {
		return this.srCmtDesc;
	}
	
	/**
	 * Column Info
	 * @return cstmsVvdCd
	 */
	public String getCstmsVvdCd() {
		return this.cstmsVvdCd;
	}
	
	/**
	 * Column Info
	 * @return srStsDesc
	 */
	public String getSrStsDesc() {
		return this.srStsDesc;
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
	 * @return vpsEtaDt
	 */
	public String getVpsEtaDt() {
		return this.vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtaDtTime
	 */
	public String getVpsEtaDtTime() {
		return this.vpsEtaDtTime;
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
	 * @return declBlQty
	 */
	public String getDeclBlQty() {
		return this.declBlQty;
	}
	
	/**
	 * Column Info
	 * @return msgRefNo
	 */
	public String getMsgRefNo() {
		return this.msgRefNo;
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
	 * @return vslRgstCntCd
	 */
	public String getVslRgstCntCd() {
		return this.vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @return vslNm2
	 */
	public String getVslNm2() {
		return this.vslNm2;
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
	 * @return rjctDt
	 */
	public String getRjctDt() {
		return this.rjctDt;
	}
	
	/**
	 * Column Info
	 * @return vpsEtdDtTime
	 */
	public String getVpsEtdDtTime() {
		return this.vpsEtdDtTime;
	}
	
	/**
	 * Column Info
	 * @return capNm
	 */
	public String getCapNm() {
		return this.capNm;
	}
	
	/**
	 * Column Info
	 * @return rgstDt
	 */
	public String getRgstDt() {
		return this.rgstDt;
	}
	
	/**
	 * Column Info
	 * @return vslAuthNo
	 */
	public String getVslAuthNo() {
		return this.vslAuthNo;
	}
	

	/**
	 * Column Info
	 * @param vpsEtdDt
	 */
	public void setVpsEtdDt(String vpsEtdDt) {
		this.vpsEtdDt = vpsEtdDt;
	}
	
	/**
	 * Column Info
	 * @param srStsCd
	 */
	public void setSrStsCd(String srStsCd) {
		this.srStsCd = srStsCd;
	}
	
	/**
	 * Column Info
	 * @param arrivalPort
	 */
	public void setArrivalPort(String arrivalPort) {
		this.arrivalPort = arrivalPort;
	}
	
	/**
	 * Column Info
	 * @param depaturePort
	 */
	public void setDepaturePort(String depaturePort) {
		this.depaturePort = depaturePort;
	}
	
	/**
	 * Column Info
	 * @param vslRgstNo
	 */
	public void setVslRgstNo(String vslRgstNo) {
		this.vslRgstNo = vslRgstNo;
	}
	
	/**
	 * Column Info
	 * @param srCmtDesc
	 */
	public void setSrCmtDesc(String srCmtDesc) {
		this.srCmtDesc = srCmtDesc;
	}
	
	/**
	 * Column Info
	 * @param cstmsVvdCd
	 */
	public void setCstmsVvdCd(String cstmsVvdCd) {
		this.cstmsVvdCd = cstmsVvdCd;
	}
	
	/**
	 * Column Info
	 * @param srStsDesc
	 */
	public void setSrStsDesc(String srStsDesc) {
		this.srStsDesc = srStsDesc;
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
	 * @param vpsEtaDt
	 */
	public void setVpsEtaDt(String vpsEtaDt) {
		this.vpsEtaDt = vpsEtaDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtaDtTime
	 */
	public void setVpsEtaDtTime(String vpsEtaDtTime) {
		this.vpsEtaDtTime = vpsEtaDtTime;
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
	 * @param declBlQty
	 */
	public void setDeclBlQty(String declBlQty) {
		this.declBlQty = declBlQty;
	}
	
	/**
	 * Column Info
	 * @param msgRefNo
	 */
	public void setMsgRefNo(String msgRefNo) {
		this.msgRefNo = msgRefNo;
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
	 * @param vslRgstCntCd
	 */
	public void setVslRgstCntCd(String vslRgstCntCd) {
		this.vslRgstCntCd = vslRgstCntCd;
	}
	
	/**
	 * Column Info
	 * @param vslNm2
	 */
	public void setVslNm2(String vslNm2) {
		this.vslNm2 = vslNm2;
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
	 * @param rjctDt
	 */
	public void setRjctDt(String rjctDt) {
		this.rjctDt = rjctDt;
	}
	
	/**
	 * Column Info
	 * @param vpsEtdDtTime
	 */
	public void setVpsEtdDtTime(String vpsEtdDtTime) {
		this.vpsEtdDtTime = vpsEtdDtTime;
	}
	
	/**
	 * Column Info
	 * @param capNm
	 */
	public void setCapNm(String capNm) {
		this.capNm = capNm;
	}
	
	/**
	 * Column Info
	 * @param rgstDt
	 */
	public void setRgstDt(String rgstDt) {
		this.rgstDt = rgstDt;
	}
	
	/**
	 * Column Info
	 * @param vslAuthNo
	 */
	public void setVslAuthNo(String vslAuthNo) {
		this.vslAuthNo = vslAuthNo;
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
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setSrStsCd(JSPUtil.getParameter(request, prefix + "sr_sts_cd", ""));
		setArrivalPort(JSPUtil.getParameter(request, prefix + "arrival_port", ""));
		setDepaturePort(JSPUtil.getParameter(request, prefix + "depature_port", ""));
		setVslRgstNo(JSPUtil.getParameter(request, prefix + "vsl_rgst_no", ""));
		setSrCmtDesc(JSPUtil.getParameter(request, prefix + "sr_cmt_desc", ""));
		setCstmsVvdCd(JSPUtil.getParameter(request, prefix + "cstms_vvd_cd", ""));
		setSrStsDesc(JSPUtil.getParameter(request, prefix + "sr_sts_desc", ""));
		setVslNm(JSPUtil.getParameter(request, prefix + "vsl_nm", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, prefix + "vps_eta_dt", ""));
		setVpsEtaDtTime(JSPUtil.getParameter(request, prefix + "vps_eta_dt_time", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setDeclBlQty(JSPUtil.getParameter(request, prefix + "decl_bl_qty", ""));
		setMsgRefNo(JSPUtil.getParameter(request, prefix + "msg_ref_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setVslRgstCntCd(JSPUtil.getParameter(request, prefix + "vsl_rgst_cnt_cd", ""));
		setVslNm2(JSPUtil.getParameter(request, prefix + "vsl_nm2", ""));
		setVslEngNm(JSPUtil.getParameter(request, prefix + "vsl_eng_nm", ""));
		setRjctDt(JSPUtil.getParameter(request, prefix + "rjct_dt", ""));
		setVpsEtdDtTime(JSPUtil.getParameter(request, prefix + "vps_etd_dt_time", ""));
		setCapNm(JSPUtil.getParameter(request, prefix + "cap_nm", ""));
		setRgstDt(JSPUtil.getParameter(request, prefix + "rgst_dt", ""));
		setVslAuthNo(JSPUtil.getParameter(request, prefix + "vsl_auth_no", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SriLankaVesselArrivalDetailVO[]
	 */
	public SriLankaVesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SriLankaVesselArrivalDetailVO[]
	 */
	public SriLankaVesselArrivalDetailVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SriLankaVesselArrivalDetailVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] srStsCd = (JSPUtil.getParameter(request, prefix	+ "sr_sts_cd", length));
			String[] arrivalPort = (JSPUtil.getParameter(request, prefix	+ "arrival_port", length));
			String[] depaturePort = (JSPUtil.getParameter(request, prefix	+ "depature_port", length));
			String[] vslRgstNo = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_no", length));
			String[] srCmtDesc = (JSPUtil.getParameter(request, prefix	+ "sr_cmt_desc", length));
			String[] cstmsVvdCd = (JSPUtil.getParameter(request, prefix	+ "cstms_vvd_cd", length));
			String[] srStsDesc = (JSPUtil.getParameter(request, prefix	+ "sr_sts_desc", length));
			String[] vslNm = (JSPUtil.getParameter(request, prefix	+ "vsl_nm", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] vpsEtaDtTime = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt_time", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] declBlQty = (JSPUtil.getParameter(request, prefix	+ "decl_bl_qty", length));
			String[] msgRefNo = (JSPUtil.getParameter(request, prefix	+ "msg_ref_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] vslRgstCntCd = (JSPUtil.getParameter(request, prefix	+ "vsl_rgst_cnt_cd", length));
			String[] vslNm2 = (JSPUtil.getParameter(request, prefix	+ "vsl_nm2", length));
			String[] vslEngNm = (JSPUtil.getParameter(request, prefix	+ "vsl_eng_nm", length));
			String[] rjctDt = (JSPUtil.getParameter(request, prefix	+ "rjct_dt", length));
			String[] vpsEtdDtTime = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt_time", length));
			String[] capNm = (JSPUtil.getParameter(request, prefix	+ "cap_nm", length));
			String[] rgstDt = (JSPUtil.getParameter(request, prefix	+ "rgst_dt", length));
			String[] vslAuthNo = (JSPUtil.getParameter(request, prefix	+ "vsl_auth_no", length));
			
			for (int i = 0; i < length; i++) {
				model = new SriLankaVesselArrivalDetailVO();
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (srStsCd[i] != null)
					model.setSrStsCd(srStsCd[i]);
				if (arrivalPort[i] != null)
					model.setArrivalPort(arrivalPort[i]);
				if (depaturePort[i] != null)
					model.setDepaturePort(depaturePort[i]);
				if (vslRgstNo[i] != null)
					model.setVslRgstNo(vslRgstNo[i]);
				if (srCmtDesc[i] != null)
					model.setSrCmtDesc(srCmtDesc[i]);
				if (cstmsVvdCd[i] != null)
					model.setCstmsVvdCd(cstmsVvdCd[i]);
				if (srStsDesc[i] != null)
					model.setSrStsDesc(srStsDesc[i]);
				if (vslNm[i] != null)
					model.setVslNm(vslNm[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (vpsEtaDtTime[i] != null)
					model.setVpsEtaDtTime(vpsEtaDtTime[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (declBlQty[i] != null)
					model.setDeclBlQty(declBlQty[i]);
				if (msgRefNo[i] != null)
					model.setMsgRefNo(msgRefNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (vslRgstCntCd[i] != null)
					model.setVslRgstCntCd(vslRgstCntCd[i]);
				if (vslNm2[i] != null)
					model.setVslNm2(vslNm2[i]);
				if (vslEngNm[i] != null)
					model.setVslEngNm(vslEngNm[i]);
				if (rjctDt[i] != null)
					model.setRjctDt(rjctDt[i]);
				if (vpsEtdDtTime[i] != null)
					model.setVpsEtdDtTime(vpsEtdDtTime[i]);
				if (capNm[i] != null)
					model.setCapNm(capNm[i]);
				if (rgstDt[i] != null)
					model.setRgstDt(rgstDt[i]);
				if (vslAuthNo[i] != null)
					model.setVslAuthNo(vslAuthNo[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSriLankaVesselArrivalDetailVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SriLankaVesselArrivalDetailVO[]
	 */
	public SriLankaVesselArrivalDetailVO[] getSriLankaVesselArrivalDetailVOs(){
		SriLankaVesselArrivalDetailVO[] vos = (SriLankaVesselArrivalDetailVO[])models.toArray(new SriLankaVesselArrivalDetailVO[models.size()]);
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
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsCd = this.srStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalPort = this.arrivalPort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.depaturePort = this.depaturePort .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstNo = this.vslRgstNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srCmtDesc = this.srCmtDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsVvdCd = this.cstmsVvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.srStsDesc = this.srStsDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm = this.vslNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDtTime = this.vpsEtaDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.declBlQty = this.declBlQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msgRefNo = this.msgRefNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslRgstCntCd = this.vslRgstCntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslNm2 = this.vslNm2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslEngNm = this.vslEngNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rjctDt = this.rjctDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDtTime = this.vpsEtdDtTime .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.capNm = this.capNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rgstDt = this.rgstDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslAuthNo = this.vslAuthNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
