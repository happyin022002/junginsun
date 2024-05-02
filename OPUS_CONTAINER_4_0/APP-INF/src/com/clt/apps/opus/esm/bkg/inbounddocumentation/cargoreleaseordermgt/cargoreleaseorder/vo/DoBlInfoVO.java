/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DoBlInfoVO.java
*@FileTitle : DoBlInfoVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.22
*@LastModifier : 
*@LastVersion : 1.0
* 2009.12.22  
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo;

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

public class DoBlInfoVO extends AbstractValueObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8646723684722153105L;

	private Collection<DoBlInfoVO> models = new ArrayList<DoBlInfoVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String splitFlg = null;
	/* Column Info */
	private String dschLoc = null;
	/* Column Info */
	private String vpsEtaDt = null;
	/* Column Info */
	private String blNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String polCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String wgtUtCd = null;
	/* Column Info */
	private String measQty = null;
	/* Column Info */
	private String pckQty = null;
	/* Column Info */
	private String pckTpCd = null;
	/* Column Info */
	private String measUtCd = null;
	/* Column Info */
	private String oblIssRmk = null;
	/* Column Info */
	private String ccustAddr = null;
	/* Column Info */
	private String cntrPrtFlg = null;
	/* Column Info */
	private String ncustAddr = null;
	/* Column Info */
	private String scustAddr = null;
	/* Column Info */
	private String repCmdtNm = null;
	/* Column Info */
	private String callSgnNo = null;
	/* Column Info */
	private String scustNm = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String blTpCd = null;
	/* Column Info */
	private String ncustNm = null;
	/* Column Info */
	private String actWgt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String socFlg = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String arrivalVessel = null;
	/* Column Info */
	private String deTermDesc = null;
	/* Column Info */
	private String ccustNm = null;
	
	private String lcloblissueflg = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public DoBlInfoVO() {}

	public DoBlInfoVO(String ibflag, String pagerows, String bkgNo, String blNo, String porCd, String polCd, String podCd, String delCd, String deTermCd, String deTermDesc, String arrivalVessel, String vpsEtaDt, String pckQty, String pckTpCd, String actWgt, String wgtUtCd, String measQty, String measUtCd, String socFlg, String splitFlg, String repCmdtNm, String dschLoc, String cntrPrtFlg, String ccustNm, String ccustAddr, String ncustNm, String ncustAddr, String scustNm, String scustAddr, String callSgnNo, String blTpCd, String oblIssRmk, String lcloblissueflg) {
		this.porCd = porCd;
		this.splitFlg = splitFlg;
		this.dschLoc = dschLoc;
		this.vpsEtaDt = vpsEtaDt;
		this.blNo = blNo;
		this.pagerows = pagerows;
		this.polCd = polCd;
		this.ibflag = ibflag;
		this.wgtUtCd = wgtUtCd;
		this.measQty = measQty;
		this.pckQty = pckQty;
		this.pckTpCd = pckTpCd;
		this.measUtCd = measUtCd;
		this.oblIssRmk = oblIssRmk;
		this.ccustAddr = ccustAddr;
		this.cntrPrtFlg = cntrPrtFlg;
		this.ncustAddr = ncustAddr;
		this.scustAddr = scustAddr;
		this.repCmdtNm = repCmdtNm;
		this.callSgnNo = callSgnNo;
		this.scustNm = scustNm;
		this.delCd = delCd;
		this.blTpCd = blTpCd;
		this.ncustNm = ncustNm;
		this.actWgt = actWgt;
		this.podCd = podCd;
		this.socFlg = socFlg;
		this.deTermCd = deTermCd;
		this.bkgNo = bkgNo;
		this.arrivalVessel = arrivalVessel;
		this.deTermDesc = deTermDesc;
		this.ccustNm = ccustNm;
		this.lcloblissueflg = lcloblissueflg;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("split_flg", getSplitFlg());
		this.hashColumns.put("dsch_loc", getDschLoc());
		this.hashColumns.put("vps_eta_dt", getVpsEtaDt());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("wgt_ut_cd", getWgtUtCd());
		this.hashColumns.put("meas_qty", getMeasQty());
		this.hashColumns.put("pck_qty", getPckQty());
		this.hashColumns.put("pck_tp_cd", getPckTpCd());
		this.hashColumns.put("meas_ut_cd", getMeasUtCd());
		this.hashColumns.put("obl_iss_rmk", getOblIssRmk());
		this.hashColumns.put("ccust_addr", getCcustAddr());
		this.hashColumns.put("cntr_prt_flg", getCntrPrtFlg());
		this.hashColumns.put("ncust_addr", getNcustAddr());
		this.hashColumns.put("scust_addr", getScustAddr());
		this.hashColumns.put("rep_cmdt_nm", getRepCmdtNm());
		this.hashColumns.put("call_sgn_no", getCallSgnNo());
		this.hashColumns.put("scust_nm", getScustNm());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("bl_tp_cd", getBlTpCd());
		this.hashColumns.put("ncust_nm", getNcustNm());
		this.hashColumns.put("act_wgt", getActWgt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("soc_flg", getSocFlg());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("arrival_vessel", getArrivalVessel());
		this.hashColumns.put("de_term_desc", getDeTermDesc());
		this.hashColumns.put("ccust_nm", getCcustNm());
		this.hashColumns.put("lcloblissueflg", getLcloblissueflg()); 
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("split_flg", "splitFlg");
		this.hashFields.put("dsch_loc", "dschLoc");
		this.hashFields.put("vps_eta_dt", "vpsEtaDt");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("wgt_ut_cd", "wgtUtCd");
		this.hashFields.put("meas_qty", "measQty");
		this.hashFields.put("pck_qty", "pckQty");
		this.hashFields.put("pck_tp_cd", "pckTpCd");
		this.hashFields.put("meas_ut_cd", "measUtCd");
		this.hashFields.put("obl_iss_rmk", "oblIssRmk");
		this.hashFields.put("ccust_addr", "ccustAddr");
		this.hashFields.put("cntr_prt_flg", "cntrPrtFlg");
		this.hashFields.put("ncust_addr", "ncustAddr");
		this.hashFields.put("scust_addr", "scustAddr");
		this.hashFields.put("rep_cmdt_nm", "repCmdtNm");
		this.hashFields.put("call_sgn_no", "callSgnNo");
		this.hashFields.put("scust_nm", "scustNm");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("bl_tp_cd", "blTpCd");
		this.hashFields.put("ncust_nm", "ncustNm");
		this.hashFields.put("act_wgt", "actWgt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("soc_flg", "socFlg");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("arrival_vessel", "arrivalVessel");
		this.hashFields.put("de_term_desc", "deTermDesc");
		this.hashFields.put("ccust_nm", "ccustNm");
		this.hashFields.put("lcloblissueflg", "lcloblissueflg");
		
		return this.hashFields;
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
	 * @return splitFlg
	 */
	public String getSplitFlg() {
		return this.splitFlg;
	}
	
	/**
	 * Column Info
	 * @return dschLoc
	 */
	public String getDschLoc() {
		return this.dschLoc;
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
	 * @return polCd
	 */
	public String getPolCd() {
		return this.polCd;
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
	 * @return wgtUtCd
	 */
	public String getWgtUtCd() {
		return this.wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @return measQty
	 */
	public String getMeasQty() {
		return this.measQty;
	}
	
	/**
	 * Column Info
	 * @return pckQty
	 */
	public String getPckQty() {
		return this.pckQty;
	}
	
	/**
	 * Column Info
	 * @return pckTpCd
	 */
	public String getPckTpCd() {
		return this.pckTpCd;
	}
	
	/**
	 * Column Info
	 * @return measUtCd
	 */
	public String getMeasUtCd() {
		return this.measUtCd;
	}
	
	/**
	 * Column Info
	 * @return oblIssRmk
	 */
	public String getOblIssRmk() {
		return this.oblIssRmk;
	}
	
	/**
	 * Column Info
	 * @return ccustAddr
	 */
	public String getCcustAddr() {
		return this.ccustAddr;
	}
	
	/**
	 * Column Info
	 * @return cntrPrtFlg
	 */
	public String getCntrPrtFlg() {
		return this.cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @return ncustAddr
	 */
	public String getNcustAddr() {
		return this.ncustAddr;
	}
	
	/**
	 * Column Info
	 * @return scustAddr
	 */
	public String getScustAddr() {
		return this.scustAddr;
	}
	
	/**
	 * Column Info
	 * @return repCmdtNm
	 */
	public String getRepCmdtNm() {
		return this.repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @return callSgnNo
	 */
	public String getCallSgnNo() {
		return this.callSgnNo;
	}
	
	/**
	 * Column Info
	 * @return scustNm
	 */
	public String getScustNm() {
		return this.scustNm;
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
	 * @return blTpCd
	 */
	public String getBlTpCd() {
		return this.blTpCd;
	}
	
	/**
	 * Column Info
	 * @return ncustNm
	 */
	public String getNcustNm() {
		return this.ncustNm;
	}
	
	/**
	 * Column Info
	 * @return actWgt
	 */
	public String getActWgt() {
		return this.actWgt;
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
	 * @return socFlg
	 */
	public String getSocFlg() {
		return this.socFlg;
	}
	
	/**
	 * Column Info
	 * @return deTermCd
	 */
	public String getDeTermCd() {
		return this.deTermCd;
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
	 * @return arrivalVessel
	 */
	public String getArrivalVessel() {
		return this.arrivalVessel;
	}
	
	/**
	 * Column Info
	 * @return deTermDesc
	 */
	public String getDeTermDesc() {
		return this.deTermDesc;
	}
	
	/**
	 * Column Info
	 * @return ccustNm
	 */
	public String getCcustNm() {
		return this.ccustNm;
	}
	
	/**
	 * Column Info
	 * @return lcloblissueflg
	 */
	public String getLcloblissueflg() {
		return this.lcloblissueflg;
	}
	

	/**
	 * Column Info
	 * @param lcloblissueflg
	 */
	public void setLcloblissueflg(String lcloblissueflg) {
		this.lcloblissueflg = lcloblissueflg;
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
	 * @param splitFlg
	 */
	public void setSplitFlg(String splitFlg) {
		this.splitFlg = splitFlg;
	}
	
	/**
	 * Column Info
	 * @param dschLoc
	 */
	public void setDschLoc(String dschLoc) {
		this.dschLoc = dschLoc;
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
	 * @param polCd
	 */
	public void setPolCd(String polCd) {
		this.polCd = polCd;
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
	 * @param wgtUtCd
	 */
	public void setWgtUtCd(String wgtUtCd) {
		this.wgtUtCd = wgtUtCd;
	}
	
	/**
	 * Column Info
	 * @param measQty
	 */
	public void setMeasQty(String measQty) {
		this.measQty = measQty;
	}
	
	/**
	 * Column Info
	 * @param pckQty
	 */
	public void setPckQty(String pckQty) {
		this.pckQty = pckQty;
	}
	
	/**
	 * Column Info
	 * @param pckTpCd
	 */
	public void setPckTpCd(String pckTpCd) {
		this.pckTpCd = pckTpCd;
	}
	
	/**
	 * Column Info
	 * @param measUtCd
	 */
	public void setMeasUtCd(String measUtCd) {
		this.measUtCd = measUtCd;
	}
	
	/**
	 * Column Info
	 * @param oblIssRmk
	 */
	public void setOblIssRmk(String oblIssRmk) {
		this.oblIssRmk = oblIssRmk;
	}
	
	/**
	 * Column Info
	 * @param ccustAddr
	 */
	public void setCcustAddr(String ccustAddr) {
		this.ccustAddr = ccustAddr;
	}
	
	/**
	 * Column Info
	 * @param cntrPrtFlg
	 */
	public void setCntrPrtFlg(String cntrPrtFlg) {
		this.cntrPrtFlg = cntrPrtFlg;
	}
	
	/**
	 * Column Info
	 * @param ncustAddr
	 */
	public void setNcustAddr(String ncustAddr) {
		this.ncustAddr = ncustAddr;
	}
	
	/**
	 * Column Info
	 * @param scustAddr
	 */
	public void setScustAddr(String scustAddr) {
		this.scustAddr = scustAddr;
	}
	
	/**
	 * Column Info
	 * @param repCmdtNm
	 */
	public void setRepCmdtNm(String repCmdtNm) {
		this.repCmdtNm = repCmdtNm;
	}
	
	/**
	 * Column Info
	 * @param callSgnNo
	 */
	public void setCallSgnNo(String callSgnNo) {
		this.callSgnNo = callSgnNo;
	}
	
	/**
	 * Column Info
	 * @param scustNm
	 */
	public void setScustNm(String scustNm) {
		this.scustNm = scustNm;
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
	 * @param blTpCd
	 */
	public void setBlTpCd(String blTpCd) {
		this.blTpCd = blTpCd;
	}
	
	/**
	 * Column Info
	 * @param ncustNm
	 */
	public void setNcustNm(String ncustNm) {
		this.ncustNm = ncustNm;
	}
	
	/**
	 * Column Info
	 * @param actWgt
	 */
	public void setActWgt(String actWgt) {
		this.actWgt = actWgt;
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
	 * @param socFlg
	 */
	public void setSocFlg(String socFlg) {
		this.socFlg = socFlg;
	}
	
	/**
	 * Column Info
	 * @param deTermCd
	 */
	public void setDeTermCd(String deTermCd) {
		this.deTermCd = deTermCd;
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
	 * @param arrivalVessel
	 */
	public void setArrivalVessel(String arrivalVessel) {
		this.arrivalVessel = arrivalVessel;
	}
	
	/**
	 * Column Info
	 * @param deTermDesc
	 */
	public void setDeTermDesc(String deTermDesc) {
		this.deTermDesc = deTermDesc;
	}
	
	/**
	 * Column Info
	 * @param ccustNm
	 */
	public void setCcustNm(String ccustNm) {
		this.ccustNm = ccustNm;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setSplitFlg(JSPUtil.getParameter(request, "split_flg", ""));
		setDschLoc(JSPUtil.getParameter(request, "dsch_loc", ""));
		setVpsEtaDt(JSPUtil.getParameter(request, "vps_eta_dt", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setWgtUtCd(JSPUtil.getParameter(request, "wgt_ut_cd", ""));
		setMeasQty(JSPUtil.getParameter(request, "meas_qty", ""));
		setPckQty(JSPUtil.getParameter(request, "pck_qty", ""));
		setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
		setMeasUtCd(JSPUtil.getParameter(request, "meas_ut_cd", ""));
		setOblIssRmk(JSPUtil.getParameter(request, "obl_iss_rmk", ""));
		setCcustAddr(JSPUtil.getParameter(request, "ccust_addr", ""));
		setCntrPrtFlg(JSPUtil.getParameter(request, "cntr_prt_flg", ""));
		setNcustAddr(JSPUtil.getParameter(request, "ncust_addr", ""));
		setScustAddr(JSPUtil.getParameter(request, "scust_addr", ""));
		setRepCmdtNm(JSPUtil.getParameter(request, "rep_cmdt_nm", ""));
		setCallSgnNo(JSPUtil.getParameter(request, "call_sgn_no", ""));
		setScustNm(JSPUtil.getParameter(request, "scust_nm", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
		setNcustNm(JSPUtil.getParameter(request, "ncust_nm", ""));
		setActWgt(JSPUtil.getParameter(request, "act_wgt", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setSocFlg(JSPUtil.getParameter(request, "soc_flg", ""));
		setDeTermCd(JSPUtil.getParameter(request, "de_term_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setArrivalVessel(JSPUtil.getParameter(request, "arrival_vessel", ""));
		setDeTermDesc(JSPUtil.getParameter(request, "de_term_desc", ""));
		setCcustNm(JSPUtil.getParameter(request, "ccust_nm", ""));
		setLcloblissueflg(JSPUtil.getParameter(request, "lcloblissueflg", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return DoBlInfoVO[]
	 */
	public DoBlInfoVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return DoBlInfoVO[]
	 */
	public DoBlInfoVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		DoBlInfoVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] splitFlg = (JSPUtil.getParameter(request, prefix	+ "split_flg", length));
			String[] dschLoc = (JSPUtil.getParameter(request, prefix	+ "dsch_loc", length));
			String[] vpsEtaDt = (JSPUtil.getParameter(request, prefix	+ "vps_eta_dt", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] wgtUtCd = (JSPUtil.getParameter(request, prefix	+ "wgt_ut_cd", length));
			String[] measQty = (JSPUtil.getParameter(request, prefix	+ "meas_qty", length));
			String[] pckQty = (JSPUtil.getParameter(request, prefix	+ "pck_qty", length));
			String[] pckTpCd = (JSPUtil.getParameter(request, prefix	+ "pck_tp_cd", length));
			String[] measUtCd = (JSPUtil.getParameter(request, prefix	+ "meas_ut_cd", length));
			String[] oblIssRmk = (JSPUtil.getParameter(request, prefix	+ "obl_iss_rmk", length));
			String[] ccustAddr = (JSPUtil.getParameter(request, prefix	+ "ccust_addr", length));
			String[] cntrPrtFlg = (JSPUtil.getParameter(request, prefix	+ "cntr_prt_flg", length));
			String[] ncustAddr = (JSPUtil.getParameter(request, prefix	+ "ncust_addr", length));
			String[] scustAddr = (JSPUtil.getParameter(request, prefix	+ "scust_addr", length));
			String[] repCmdtNm = (JSPUtil.getParameter(request, prefix	+ "rep_cmdt_nm", length));
			String[] callSgnNo = (JSPUtil.getParameter(request, prefix	+ "call_sgn_no", length));
			String[] scustNm = (JSPUtil.getParameter(request, prefix	+ "scust_nm", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] blTpCd = (JSPUtil.getParameter(request, prefix	+ "bl_tp_cd", length));
			String[] ncustNm = (JSPUtil.getParameter(request, prefix	+ "ncust_nm", length));
			String[] actWgt = (JSPUtil.getParameter(request, prefix	+ "act_wgt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] socFlg = (JSPUtil.getParameter(request, prefix	+ "soc_flg", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] arrivalVessel = (JSPUtil.getParameter(request, prefix	+ "arrival_vessel", length));
			String[] deTermDesc = (JSPUtil.getParameter(request, prefix	+ "de_term_desc", length));
			String[] ccustNm = (JSPUtil.getParameter(request, prefix	+ "ccust_nm", length));
			String[] lcloblissueflg = (JSPUtil.getParameter(request, prefix	+ "lcloblissueflg", length));
			
			
			for (int i = 0; i < length; i++) {
				model = new DoBlInfoVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (splitFlg[i] != null)
					model.setSplitFlg(splitFlg[i]);
				if (dschLoc[i] != null)
					model.setDschLoc(dschLoc[i]);
				if (vpsEtaDt[i] != null)
					model.setVpsEtaDt(vpsEtaDt[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (wgtUtCd[i] != null)
					model.setWgtUtCd(wgtUtCd[i]);
				if (measQty[i] != null)
					model.setMeasQty(measQty[i]);
				if (pckQty[i] != null)
					model.setPckQty(pckQty[i]);
				if (pckTpCd[i] != null)
					model.setPckTpCd(pckTpCd[i]);
				if (measUtCd[i] != null)
					model.setMeasUtCd(measUtCd[i]);
				if (oblIssRmk[i] != null)
					model.setOblIssRmk(oblIssRmk[i]);
				if (ccustAddr[i] != null)
					model.setCcustAddr(ccustAddr[i]);
				if (cntrPrtFlg[i] != null)
					model.setCntrPrtFlg(cntrPrtFlg[i]);
				if (ncustAddr[i] != null)
					model.setNcustAddr(ncustAddr[i]);
				if (scustAddr[i] != null)
					model.setScustAddr(scustAddr[i]);
				if (repCmdtNm[i] != null)
					model.setRepCmdtNm(repCmdtNm[i]);
				if (callSgnNo[i] != null)
					model.setCallSgnNo(callSgnNo[i]);
				if (scustNm[i] != null)
					model.setScustNm(scustNm[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (blTpCd[i] != null)
					model.setBlTpCd(blTpCd[i]);
				if (ncustNm[i] != null)
					model.setNcustNm(ncustNm[i]);
				if (actWgt[i] != null)
					model.setActWgt(actWgt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (socFlg[i] != null)
					model.setSocFlg(socFlg[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (arrivalVessel[i] != null)
					model.setArrivalVessel(arrivalVessel[i]);
				if (deTermDesc[i] != null)
					model.setDeTermDesc(deTermDesc[i]);
				if (ccustNm[i] != null)
					model.setCcustNm(ccustNm[i]);
				if (lcloblissueflg[i] != null)
					model.setLcloblissueflg(lcloblissueflg[i]);
				
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getDoBlInfoVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return DoBlInfoVO[]
	 */
	public DoBlInfoVO[] getDoBlInfoVOs(){
		DoBlInfoVO[] vos = (DoBlInfoVO[])models.toArray(new DoBlInfoVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.splitFlg = this.splitFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dschLoc = this.dschLoc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtaDt = this.vpsEtaDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtUtCd = this.wgtUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measQty = this.measQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckQty = this.pckQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pckTpCd = this.pckTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.measUtCd = this.measUtCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssRmk = this.oblIssRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccustAddr = this.ccustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrPrtFlg = this.cntrPrtFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncustAddr = this.ncustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustAddr = this.scustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.repCmdtNm = this.repCmdtNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSgnNo = this.callSgnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scustNm = this.scustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTpCd = this.blTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ncustNm = this.ncustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actWgt = this.actWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.socFlg = this.socFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arrivalVessel = this.arrivalVessel .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermDesc = this.deTermDesc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ccustNm = this.ccustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lcloblissueflg = this.lcloblissueflg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");		
	}
}
