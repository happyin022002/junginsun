/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FullCntrRlseOrderHisVO.java
*@FileTitle : FullCntrRlseOrderHisVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.08.11 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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
 * @author 손윤석
 * @since J2EE 1.6
 * @see AbstractValueObject
 */
  
public class FullCntrRlseOrderHisVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FullCntrRlseOrderHisVO> models = new ArrayList<FullCntrRlseOrderHisVO>();
	
	/* Column Info */
	private String rmk = null;
	/* Column Info */
	private String custNm = null;
	/* Column Info */
	private String doIssDt = null;
	/* Column Info */
	private String cxlFlg = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String trspMod = null;
	/* Column Info */
	private String rlseDt = null;
	/* Column Info */
	private String rlseExpDt = null;
	/* Column Info */
	private String rlseNtcEml = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String doNo = null;
	/* Column Info */
	private String cntrTpSzCd = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String deTermCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String usrNm = null;
	/* Column Info */
	private String ydCd = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String mzd = null;
	/* Column Info */
	private String pkupDt = null;
	/* Column Info */
	private String coBdgId = null;
	/* Column Info */
	private String cgoCrrId = null;
	/* Column Info */
	private String rlseCreDt = null;
	/* Column Info */
	private String pinNo = null;
	/* Column Info */
	private String vehRgstId = null;
	/* Column Info */
	private String roadHlgId = null;
	/* Column Info */
	private String uqVslIdNo = null;
	/* Column Info */
	private String cstmsVoyNo = null;
	/* Column Info */
	private String frtFwrdCd = null;
	/* Column Info */
	private String ptyToInvCd = null;
	/* Column Info */
	private String mtRetCyCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public FullCntrRlseOrderHisVO() {}

	public FullCntrRlseOrderHisVO(String ibflag, String pagerows, String blNo, String bkgNo, String cntrNo, String cntrTpSzCd, String custNm, String ydCd, String vvd, String polCd, String podCd, String trspMod, String pkupDt, String cxlFlg, String deTermCd, String rmk, String ofcCd, String usrNm, String rlseDt, String mzd, String doNo, String doIssDt, String coBdgId, String cgoCrrId, String rlseCreDt, String rlseExpDt, String pinNo, String vehRgstId, String roadHlgId, String uqVslIdNo, String rlseNtcEml, String cstmsVoyNo, String frtFwrdCd, String ptyToInvCd, String mtRetCyCd) {
		this.rmk = rmk;
		this.custNm = custNm;
		this.doIssDt = doIssDt;
		this.cxlFlg = cxlFlg;
		this.blNo = blNo;
		this.trspMod = trspMod;
		this.rlseDt = rlseDt;
		this.pagerows = pagerows;
		this.doNo = doNo;
		this.cntrTpSzCd = cntrTpSzCd;
		this.vvd = vvd;
		this.podCd = podCd;
		this.ofcCd = ofcCd;
		this.deTermCd = deTermCd;
		this.ibflag = ibflag;
		this.bkgNo = bkgNo;
		this.polCd = polCd;
		this.usrNm = usrNm;
		this.ydCd = ydCd;
		this.cntrNo = cntrNo;
		this.mzd = mzd;
		this.pkupDt = pkupDt;
		this.coBdgId = coBdgId;
		this.cgoCrrId = cgoCrrId;
		this.rlseCreDt = rlseCreDt;
		this.rlseExpDt = rlseExpDt;
		this.pinNo = pinNo;
		this.vehRgstId = vehRgstId;
		this.roadHlgId = roadHlgId;
		this.uqVslIdNo = uqVslIdNo;
		this.rlseNtcEml = rlseNtcEml;
		this.cstmsVoyNo = cstmsVoyNo;
		this.frtFwrdCd = frtFwrdCd;
		this.ptyToInvCd = ptyToInvCd;
		this.mtRetCyCd = mtRetCyCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("rmk", getRmk());
		this.hashColumns.put("cust_nm", getCustNm());
		this.hashColumns.put("do_iss_dt", getDoIssDt());
		this.hashColumns.put("cxl_flg", getCxlFlg());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("trsp_mod", getTrspMod());
		this.hashColumns.put("rlse_dt", getRlseDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("do_no", getDoNo());
		this.hashColumns.put("cntr_tp_sz_cd", getCntrTpSzCd());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("usr_nm", getUsrNm());
		this.hashColumns.put("yd_cd", getYdCd());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("mzd", getMzd());
		this.hashColumns.put("pkup_dt", getPkupDt());
		this.hashColumns.put("co_bdg_id", getCoBdgId());
		this.hashColumns.put("cgo_crr_id", getCgoCrrId());
		this.hashColumns.put("rlse_cre_dt", getRlseCreDt());
		this.hashColumns.put("rlse_exp_dt", getRlseExpDt());
		this.hashColumns.put("pin_no", getPinNo());
		this.hashColumns.put("veh_rgst_id", getVehRgstId());
		this.hashColumns.put("road_hlg_id", getRoadHlgId());
		this.hashColumns.put("uq_vsl_id_no", getUqVslIdNo());
		this.hashColumns.put("rlse_ntc_eml", getRlseNtcEml());
		this.hashColumns.put("cstms_voy_no", getCstmsVoyNo());
		this.hashColumns.put("frt_fwrd_cd", getFrtFwrdCd());
		this.hashColumns.put("pty_to_inv_cd", getPtyToInvCd());
		this.hashColumns.put("mt_ret_cy_cd", getMtRetCyCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("rmk", "rmk");
		this.hashFields.put("cust_nm", "custNm");
		this.hashFields.put("do_iss_dt", "doIssDt");
		this.hashFields.put("cxl_flg", "cxlFlg");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("trsp_mod", "trspMod");
		this.hashFields.put("rlse_dt", "rlseDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("do_no", "doNo");
		this.hashFields.put("cntr_tp_sz_cd", "cntrTpSzCd");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("usr_nm", "usrNm");
		this.hashFields.put("yd_cd", "ydCd");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("mzd", "mzd");
		this.hashFields.put("pkup_dt", "pkupDt");
		this.hashFields.put("co_bdg_id", "coBdgId");
		this.hashFields.put("cgo_crr_id", "cgoCrrId");
		this.hashFields.put("rlse_cre_dt", "rlseCreDt");
		this.hashFields.put("rlse_exp_dt", "rlseExpDt");
		this.hashFields.put("pin_no", "pinNo");
		this.hashFields.put("veh_rgst_id", "vehRgstId");
		this.hashFields.put("road_hlg_id", "roadHlgId");
		this.hashFields.put("uq_vsl_id_no", "uqVslIdNo");
		this.hashFields.put("rlse_ntc_eml", "rlseNtcEml");
		this.hashFields.put("cstms_voy_no", "cstmsVoyNo");
		this.hashFields.put("frt_fwrd_cd", "frtFwrdCd");
		this.hashFields.put("pty_to_inv_cd", "ptyToInvCd");
		this.hashFields.put("mt_ret_cy_cd", "mtRetCyCd");
		return this.hashFields;
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
	 * @return custNm
	 */
	public String getCustNm() {
		return this.custNm;
	}
	
	/**
	 * Column Info
	 * @return doIssDt
	 */
	public String getDoIssDt() {
		return this.doIssDt;
	}
	
	/**
	 * Column Info
	 * @return cxlFlg
	 */
	public String getCxlFlg() {
		return this.cxlFlg;
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
	 * @return trspMod
	 */
	public String getTrspMod() {
		return this.trspMod;
	}
	
	/**
	 * Column Info
	 * @return rlseDt
	 */
	public String getRlseDt() {
		return this.rlseDt;
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
	 * @return doNo
	 */
	public String getDoNo() {
		return this.doNo;
	}
	
	/**
	 * Column Info
	 * @return cntrTpSzCd
	 */
	public String getCntrTpSzCd() {
		return this.cntrTpSzCd;
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
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return usrNm
	 */
	public String getUsrNm() {
		return this.usrNm;
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
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Column Info
	 * @return mzd
	 */
	public String getMzd() {
		return this.mzd;
	}
	
	/**
	 * Column Info
	 * @return pkupDt
	 */
	public String getPkupDt() {
		return this.pkupDt;
	}
	
	/**
	 * Column Info
	 * @return coBdgId
	 */
	public String getCoBdgId() {
		return coBdgId;
	}

	/**
	 * Column Info
	 * @return cgoCrrId
	 */
	public String getCgoCrrId() {
		return cgoCrrId;
	}

	/**
	 * Column Info
	 * @return rlseCreDt
	 */
	public String getRlseCreDt() {
		return rlseCreDt;
	}
	
	/**
	 * Column Info
	 * @return rlseExpDt
	 */
	public String getRlseExpDt() {
		return rlseExpDt;
	}

	/**
	 * Column Info
	 * @return pinNo
	 */
	public String getPinNo() {
		return pinNo;
	}

	/**
	 * Column Info
	 * @return vehRgstId
	 */
	public String getVehRgstId() {
		return vehRgstId;
	}

	/**
	 * Column Info
	 * @return roadHlgId
	 */
	public String getRoadHlgId() {
		return roadHlgId;
	}

	/**
	 * Column Info
	 * @return uqVslIdNo
	 */
	public String getUqVslIdNo() {
		return uqVslIdNo;
	}
	
	/**
	 * Column Info
	 * @return rlseNtcEml
	 */
	public String getRlseNtcEml() {
		return rlseNtcEml;
	}
	
	/**
	 * Column Info
	 * @return cstmsVoyNo
	 */
	public String getCstmsVoyNo() {
		return this.cstmsVoyNo;
	}
	
	/**
	 * Column Info
	 * @return frtFwrdCd
	 */
	public String getFrtFwrdCd() {
		return this.frtFwrdCd;
	}
	
	/**
	 * Column Info
	 * @return ptyToInvCd
	 */
	public String getPtyToInvCd() {
		return this.ptyToInvCd;
	}
	
	/**
	 * Column Info
	 * @return mtRetCyCd
	 */
	public String getMtRetCyCd() {
		return this.mtRetCyCd;
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
	 * @param custNm
	 */
	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}
	
	/**
	 * Column Info
	 * @param doIssDt
	 */
	public void setDoIssDt(String doIssDt) {
		this.doIssDt = doIssDt;
	}
	
	/**
	 * Column Info
	 * @param cxlFlg
	 */
	public void setCxlFlg(String cxlFlg) {
		this.cxlFlg = cxlFlg;
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
	 * @param trspMod
	 */
	public void setTrspMod(String trspMod) {
		this.trspMod = trspMod;
	}
	
	/**
	 * Column Info
	 * @param rlseDt
	 */
	public void setRlseDt(String rlseDt) {
		this.rlseDt = rlseDt;
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
	 * @param doNo
	 */
	public void setDoNo(String doNo) {
		this.doNo = doNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTpSzCd
	 */
	public void setCntrTpSzCd(String cntrTpSzCd) {
		this.cntrTpSzCd = cntrTpSzCd;
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
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param usrNm
	 */
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
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
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Column Info
	 * @param mzd
	 */
	public void setMzd(String mzd) {
		this.mzd = mzd;
	}
	
	/**
	 * Column Info
	 * @param pkupDt
	 */
	public void setPkupDt(String pkupDt) {
		this.pkupDt = pkupDt;
	}
	
	/**
	 * Column Info
	 * @param coBdgId
	 */
	public void setCoBdgId(String coBdgId) {
		this.coBdgId = coBdgId;
	}

	/**
	 * Column Info
	 * @param cgoCrrId
	 */
	public void setCgoCrrId(String cgoCrrId) {
		this.cgoCrrId = cgoCrrId;
	}

	/**
	 * Column Info
	 * @param rlseCreDt
	 */
	public void setRlseCreDt(String rlseCreDt) {
		this.rlseCreDt = rlseCreDt;
	}
	
	/**
	 * Column Info
	 * @param rlseExpDt
	 */
	public void setRlseExpDt(String rlseExpDt) {
		this.rlseExpDt = rlseExpDt;
	}

	/**
	 * Column Info
	 * @param pinNo
	 */
	public void setPinNo(String pinNo) {
		this.pinNo = pinNo;
	}

	/**
	 * Column Info
	 * @param vehRgstId
	 */
	public void setVehRgstId(String vehRgstId) {
		this.vehRgstId = vehRgstId;
	}

	/**
	 * Column Info
	 * @param roadHlgId
	 */
	public void setRoadHlgId(String roadHlgId) {
		this.roadHlgId = roadHlgId;
	}

	/**
	 * Column Info
	 * @param uqVslIdNo
	 */
	public void setUqVslIdNo(String uqVslIdNo) {
		this.uqVslIdNo = uqVslIdNo;
	}
	
	/**
	 * Column Info
	 * @param rlseNtcEml
	 */
	public void setRlseNtcEml(String rlseNtcEml) {
		this.rlseNtcEml = rlseNtcEml;
	}
	
	/**
	 * Column Info
	 * @param cstmsVoyNo
	 */
	public void setCstmsVoyNo(String cstmsVoyNo) {
		this.cstmsVoyNo = cstmsVoyNo;
	}
	
	/**
	 * Column Info
	 * @param frtFwrdCd
	 */
	public void setFrtFwrdCd(String frtFwrdCd) {
		this.frtFwrdCd = frtFwrdCd;
	}
	
	/**
	 * Column Info
	 * @param ptyToInvCd
	 */
	public void setPtyToInvCd(String ptyToInvCd) {
		this.ptyToInvCd = ptyToInvCd;
	}
	
	/**
	 * Column Info
	 * @param mtRetCyCd
	 */
	public void setMtRetCyCd(String mtRetCyCd) {
		this.mtRetCyCd = mtRetCyCd;
	}
	
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setRmk(JSPUtil.getParameter(request, "rmk", ""));
		setCustNm(JSPUtil.getParameter(request, "cust_nm", ""));
		setDoIssDt(JSPUtil.getParameter(request, "do_iss_dt", ""));
		setCxlFlg(JSPUtil.getParameter(request, "cxl_flg", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setTrspMod(JSPUtil.getParameter(request, "trsp_mod", ""));
		setRlseDt(JSPUtil.getParameter(request, "rlse_dt", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setDoNo(JSPUtil.getParameter(request, "do_no", ""));
		setCntrTpSzCd(JSPUtil.getParameter(request, "cntr_tp_sz_cd", ""));
		setVvd(JSPUtil.getParameter(request, "vvd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, "ofc_cd", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setUsrNm(JSPUtil.getParameter(request, "usr_nm", ""));
		setYdCd(JSPUtil.getParameter(request, "yd_cd", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setMzd(JSPUtil.getParameter(request, "mzd", ""));
		setPkupDt(JSPUtil.getParameter(request, "pkup_dt", ""));
		setCoBdgId(JSPUtil.getParameter(request, "co_bdg_id", ""));
		setCgoCrrId(JSPUtil.getParameter(request, "cgo_crr_id", ""));
		setRlseCreDt(JSPUtil.getParameter(request, "rlse_cre_dt", ""));
		setRlseExpDt(JSPUtil.getParameter(request, "rlse_exp_dt", ""));
		setPinNo(JSPUtil.getParameter(request, "pin_no", ""));
		setVehRgstId(JSPUtil.getParameter(request, "veh_rgst_id", ""));
		setRoadHlgId(JSPUtil.getParameter(request, "road_hlg_id", ""));
		setUqVslIdNo(JSPUtil.getParameter(request, "uq_vsl_id_no", ""));
		setRlseNtcEml(JSPUtil.getParameter(request, "rlse_ntc_eml", ""));
		setCstmsVoyNo(JSPUtil.getParameter(request, "cstms_voy_no", ""));
		setFrtFwrdCd(JSPUtil.getParameter(request, "frt_fwrd_cd", ""));
		setPtyToInvCd(JSPUtil.getParameter(request, "pty_to_inv_cd", ""));
		setMtRetCyCd(JSPUtil.getParameter(request, "mt_ret_cy_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FullCntrRlseOrderHisVO[]
	 */
	public FullCntrRlseOrderHisVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FullCntrRlseOrderHisVO[]
	 */
	public FullCntrRlseOrderHisVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FullCntrRlseOrderHisVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] rmk = (JSPUtil.getParameter(request, prefix	+ "rmk", length));
			String[] custNm = (JSPUtil.getParameter(request, prefix	+ "cust_nm", length));
			String[] doIssDt = (JSPUtil.getParameter(request, prefix	+ "do_iss_dt", length));
			String[] cxlFlg = (JSPUtil.getParameter(request, prefix	+ "cxl_flg", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] trspMod = (JSPUtil.getParameter(request, prefix	+ "trsp_mod", length));
			String[] rlseDt = (JSPUtil.getParameter(request, prefix	+ "rlse_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] doNo = (JSPUtil.getParameter(request, prefix	+ "do_no", length));
			String[] cntrTpSzCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tp_sz_cd", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] usrNm = (JSPUtil.getParameter(request, prefix	+ "usr_nm", length));
			String[] ydCd = (JSPUtil.getParameter(request, prefix	+ "yd_cd", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] mzd = (JSPUtil.getParameter(request, prefix	+ "mzd", length));
			String[] pkupDt = (JSPUtil.getParameter(request, prefix	+ "pkup_dt", length));
			String[] coBdgId = (JSPUtil.getParameter(request, prefix	+ "co_bdg_id", length));
			String[] cgoCrrId = (JSPUtil.getParameter(request, prefix	+ "cgo_crr_id", length));
			String[] rlseCreDt = (JSPUtil.getParameter(request, prefix	+ "rlse_cre_dt", length));
			String[] rlseExpDt = (JSPUtil.getParameter(request, prefix	+ "rlse_exp_dt", length));
			String[] pinNo = (JSPUtil.getParameter(request, prefix	+ "pin_no", length));
			String[] vehRgstId = (JSPUtil.getParameter(request, prefix	+ "veh_rgst_id", length));
			String[] roadHlgId = (JSPUtil.getParameter(request, prefix	+ "road_hlg_id", length));
			String[] uqVslIdNo = (JSPUtil.getParameter(request, prefix	+ "uq_vsl_id_no", length));
			String[] rlseNtcEml = (JSPUtil.getParameter(request, prefix	+ "rlse_ntc_eml", length));
			String[] cstmsVoyNo = (JSPUtil.getParameter(request, prefix	+ "cstms_voy_no", length));
			String[] frtFwrdCd = (JSPUtil.getParameter(request, prefix	+ "frt_fwrd_cd", length));
			String[] ptyToInvCd = (JSPUtil.getParameter(request, prefix	+ "pty_to_inv_cd", length));
			String[] mtRetCyCd = (JSPUtil.getParameter(request, prefix	+ "mt_ret_cy_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new FullCntrRlseOrderHisVO();
				if (rmk[i] != null)
					model.setRmk(rmk[i]);
				if (custNm[i] != null)
					model.setCustNm(custNm[i]);
				if (doIssDt[i] != null)
					model.setDoIssDt(doIssDt[i]);
				if (cxlFlg[i] != null)
					model.setCxlFlg(cxlFlg[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (trspMod[i] != null)
					model.setTrspMod(trspMod[i]);
				if (rlseDt[i] != null)
					model.setRlseDt(rlseDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (doNo[i] != null)
					model.setDoNo(doNo[i]);
				if (cntrTpSzCd[i] != null)
					model.setCntrTpSzCd(cntrTpSzCd[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (usrNm[i] != null)
					model.setUsrNm(usrNm[i]);
				if (ydCd[i] != null)
					model.setYdCd(ydCd[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (mzd[i] != null)
					model.setMzd(mzd[i]);
				if (pkupDt[i] != null)
					model.setPkupDt(pkupDt[i]);
				if (coBdgId[i] != null)
					model.setCoBdgId(coBdgId[i]);
				if (cgoCrrId[i] != null)
					model.setCgoCrrId(cgoCrrId[i]);
				if (rlseCreDt[i] != null)
					model.setRlseCreDt(rlseCreDt[i]);
				if (rlseExpDt[i] != null)
					model.setRlseExpDt(rlseExpDt[i]);
				if (pinNo[i] != null)
					model.setPinNo(pinNo[i]);
				if (vehRgstId[i] != null)
					model.setVehRgstId(vehRgstId[i]);
				if (roadHlgId[i] != null)
					model.setRoadHlgId(roadHlgId[i]);
				if (uqVslIdNo[i] != null)
					model.setUqVslIdNo(uqVslIdNo[i]);
				if (rlseNtcEml[i] != null)
					model.setRlseNtcEml(rlseNtcEml[i]);
				if (cstmsVoyNo[i] != null)
					model.setCstmsVoyNo(cstmsVoyNo[i]);
				if (frtFwrdCd[i] != null)
					model.setFrtFwrdCd(frtFwrdCd[i]);
				if (ptyToInvCd[i] != null)
					model.setPtyToInvCd(ptyToInvCd[i]);
				if (mtRetCyCd[i] != null)
					model.setMtRetCyCd(mtRetCyCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFullCntrRlseOrderHisVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FullCntrRlseOrderHisVO[]
	 */
	public FullCntrRlseOrderHisVO[] getFullCntrRlseOrderHisVOs(){
		FullCntrRlseOrderHisVO[] vos = (FullCntrRlseOrderHisVO[])models.toArray(new FullCntrRlseOrderHisVO[models.size()]);
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
		this.rmk = this.rmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.custNm = this.custNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doIssDt = this.doIssDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cxlFlg = this.cxlFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trspMod = this.trspMod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseDt = this.rlseDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.doNo = this.doNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpSzCd = this.cntrTpSzCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usrNm = this.usrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydCd = this.ydCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mzd = this.mzd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkupDt = this.pkupDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.coBdgId = this.coBdgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCrrId = this.cgoCrrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseCreDt = this.rlseCreDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseExpDt = this.rlseExpDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pinNo = this.pinNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vehRgstId = this.vehRgstId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.roadHlgId = this.roadHlgId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.uqVslIdNo = this.uqVslIdNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlseNtcEml = this.rlseNtcEml .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cstmsVoyNo = this.cstmsVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.frtFwrdCd = this.frtFwrdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ptyToInvCd = this.ptyToInvCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtRetCyCd = this.mtRetCyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
