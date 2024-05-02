/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : GrpBlDtInVO.java
*@FileTitle : GrpBlDtInVO
*Open Issues :
*Change history :
*@LastModifyDate : 2011.04.25
*@LastModifier : 
*@LastVersion : 1.0
* 2011.04.25  
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo;

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

public class GrpBlDtInVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<GrpBlDtInVO> models = new ArrayList<GrpBlDtInVO>();
	
	/* Column Info */
	private String obInfoIssRdyFlg = null;
	/* Column Info */
	private String trunkVvd = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String blRdyFlg = null;
	/* Column Info */
	private String oblIssFlg = null;
	/* Column Info */
	private String chkdIss = null;
	/* Column Info */
	private String actArrDt = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String oblRlseFlg = null;
	/* Column Info */
	private String obSrepCd = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String actDepDt = null;
	/* Column Info */
	private String shipperCd = null;
	/* Column Info */
	private String polClptIndSeq = null;
	/* Column Info */
	private String fwdrCd = null;
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String rfaNo = null;
	
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String bkgToDt = null;
	/* Column Info */
	private String bkgFromDt = null;
	/* Column Info */
	private String typeDate = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public GrpBlDtInVO() {}

	public GrpBlDtInVO(String ibflag, String pagerows, String vvd, String polCd, String bkgOfcCd, String oblIssFlg, String oblRlseFlg, String shipperCd, String obSrepCd, String actArrDt, String actDepDt, String chkdIss, String polClptIndSeq, String blRdyFlg, String fwdrCd, String cneeCd, String rfaNo, String scNo, String typeDate, String bkgFromDt, String bkgToDt, String bkgNo, String trunkVvd, String obInfoIssRdyFlg) {
		this.obInfoIssRdyFlg = obInfoIssRdyFlg;
		this.bkgOfcCd = bkgOfcCd;
		this.blRdyFlg = blRdyFlg;
		this.oblIssFlg = oblIssFlg;
		this.chkdIss = chkdIss;
		this.actArrDt = actArrDt;
		this.pagerows = pagerows;
		this.vvd = vvd;
		this.oblRlseFlg = oblRlseFlg;
		this.obSrepCd = obSrepCd;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.actDepDt = actDepDt;
		this.shipperCd = shipperCd;
		this.polClptIndSeq = polClptIndSeq;
		this.cneeCd = cneeCd;
		this.fwdrCd = fwdrCd;
		this.scNo = scNo;
		this.rfaNo = rfaNo;
		this.bkgNo = bkgNo;
		this.bkgToDt = bkgToDt;
		this.bkgFromDt = bkgFromDt;
		this.typeDate = typeDate;
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("ob_info_iss_rdy_flg", getObInfoIssRdyFlg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("bl_rdy_flg", getBlRdyFlg());
		this.hashColumns.put("obl_iss_flg", getOblIssFlg());
		this.hashColumns.put("chkd_iss", getChkdIss());
		this.hashColumns.put("act_arr_dt", getActArrDt());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("obl_rlse_flg", getOblRlseFlg());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("act_dep_dt", getActDepDt());
		this.hashColumns.put("shipper_cd", getShipperCd());
		this.hashColumns.put("pol_clpt_ind_seq", getPolClptIndSeq());
		this.hashColumns.put("fwdr_cd", getFwdrCd());
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("bkg_to_dt", getBkgToDt());
		this.hashColumns.put("bkg_from_dt", getBkgFromDt());
		this.hashColumns.put("type_date", getTypeDate());
		this.hashColumns.put("trunk_vvd", getTrunkVvd());
		
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("ob_info_iss_rdy_flg", "obInfoIssRdyFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("bl_rdy_flg", "blRdyFlg");
		this.hashFields.put("obl_iss_flg", "oblIssFlg");
		this.hashFields.put("chkd_iss", "chkdIss");
		this.hashFields.put("act_arr_dt", "actArrDt");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("obl_rlse_flg", "oblRlseFlg");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("act_dep_dt", "actDepDt");
		this.hashFields.put("shipper_cd", "shipperCd");
		this.hashFields.put("pol_clpt_ind_seq", "polClptIndSeq");
		this.hashFields.put("fwdr_cd", "fwdrCd");
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("bkg_to_dt", "bkgToDt");
		this.hashFields.put("bkg_from_dt", "bkgFromDt");
		this.hashFields.put("type_date", "typeDate");
		this.hashFields.put("trunk_vvd", "trunkVvd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return obInfoIssRdyFlg
	 */
	public String getObInfoIssRdyFlg() {
		return this.obInfoIssRdyFlg;
	}
	
	/**
	 * Column Info
	 * @return trunkVvd
	 */
	public String getTrunkVvd() {
		return this.trunkVvd;
	}
	
	/**
	 * Column Info
	 * @return bkgOfcCd
	 */
	public String getBkgOfcCd() {
		return this.bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @return blRdyFlg
	 */
	public String getBlRdyFlg() {
		return this.blRdyFlg;
	}
	
	/**
	 * Column Info
	 * @return oblIssFlg
	 */
	public String getOblIssFlg() {
		return this.oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @return chkdIss
	 */
	public String getChkdIss() {
		return this.chkdIss;
	}
	
	/**
	 * Column Info
	 * @return actArrDt
	 */
	public String getActArrDt() {
		return this.actArrDt;
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
	 * @return vvd
	 */
	public String getVvd() {
		return this.vvd;
	}
	
	/**
	 * Column Info
	 * @return oblRlseFlg
	 */
	public String getOblRlseFlg() {
		return this.oblRlseFlg;
	}
	
	/**
	 * Column Info
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
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
	 * @return actDepDt
	 */
	public String getActDepDt() {
		return this.actDepDt;
	}
	
	/**
	 * Column Info
	 * @return shipperCd
	 */
	public String getShipperCd() {
		return this.shipperCd;
	}
	
	/**
	 * Column Info
	 * @return polClptIndSeq
	 */
	public String getPolClptIndSeq() {
		return this.polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return fwdrCd
	 */
	public String getFwdrCd() {
		return this.fwdrCd;
	}

	/**
	 * Column Info
	 * @return cneeCd
	 */
	public String getCneeCd() {
		return this.cneeCd;
	}

	/**
	 * Column Info
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return bkgToDt
	 */
	public String getBkgToDt() {
		return this.bkgToDt;
	}
	/**
	 * Column Info
	 * @return bkgFromDt
	 */
	public String getBkgFromDt() {
		return this.bkgFromDt;
	}
	/**
	 * Column Info
	 * @return typeDate
	 */
	public String getTypeDate() {
		return this.typeDate;
	}
	
	/**
	 * Column Info
	 * @param obInfoIssRdyFlg
	 */
	public void setObInfoIssRdyFlg(String obInfoIssRdyFlg) {
		this.obInfoIssRdyFlg = obInfoIssRdyFlg;
	}
	
	/**
	 * Column Info
	 * @param trunkVvd
	 */
	public void setTrunkVvd(String trunkVvd) {
		this.trunkVvd = trunkVvd;
	}
	
	/**
	 * Column Info
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void SetRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
	}
	/**
	 * Column Info
	 * @param bkgOfcCd
	 */
	public void setBkgOfcCd(String bkgOfcCd) {
		this.bkgOfcCd = bkgOfcCd;
	}
	
	/**
	 * Column Info
	 * @param blRdyFlg
	 */
	public void setBlRdyFlg(String blRdyFlg) {
		this.blRdyFlg = blRdyFlg;
	}
	
	/**
	 * Column Info
	 * @param oblIssFlg
	 */
	public void setOblIssFlg(String oblIssFlg) {
		this.oblIssFlg = oblIssFlg;
	}
	
	/**
	 * Column Info
	 * @param chkdIss
	 */
	public void setChkdIss(String chkdIss) {
		this.chkdIss = chkdIss;
	}
	
	/**
	 * Column Info
	 * @param actArrDt
	 */
	public void setActArrDt(String actArrDt) {
		this.actArrDt = actArrDt;
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
	 * @param vvd
	 */
	public void setVvd(String vvd) {
		this.vvd = vvd;
	}
	
	/**
	 * Column Info
	 * @param oblRlseFlg
	 */
	public void setOblRlseFlg(String oblRlseFlg) {
		this.oblRlseFlg = oblRlseFlg;
	}
	
	/**
	 * Column Info
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
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
	 * @param actDepDt
	 */
	public void setActDepDt(String actDepDt) {
		this.actDepDt = actDepDt;
	}
	
	/**
	 * Column Info
	 * @param shipperCd
	 */
	public void setShipperCd(String shipperCd) {
		this.shipperCd = shipperCd;
	}
	
	/**
	 * Column Info
	 * @param polClptIndSeq
	 */
	public void setPolClptIndSeq(String polClptIndSeq) {
		this.polClptIndSeq = polClptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param fwdrCd
	 */
	public void setFwdrCd(String fwdrCd) {
		this.fwdrCd = fwdrCd;
	}
	
	/**
	 * Column Info
	 * @param cneeCd
	 */
	public void setCneeCd(String cneeCd) {
		this.cneeCd = cneeCd;
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
	 * @param bkgToDt
	 */
	public void setBkgToDt(String bkgToDt) {
		this.bkgToDt = bkgToDt;
	}
	/**
	 * Column Info
	 * @param bkgFromDt
	 */
	public void setBkgFromDt(String bkgFromDt) {
		this.bkgFromDt = bkgFromDt;
	}
	/**
	 * Column Info
	 * @param typeDate
	 */
	public void setTypeDate(String typeDate) {
		this.typeDate = typeDate;
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
		setObInfoIssRdyFlg(JSPUtil.getParameter(request, prefix + "ob_info_iss_rdy_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, prefix + "bkg_ofc_cd", ""));
		setBlRdyFlg(JSPUtil.getParameter(request, prefix + "bl_rdy_flg", ""));
		setOblIssFlg(JSPUtil.getParameter(request, prefix + "obl_iss_flg", ""));
		setChkdIss(JSPUtil.getParameter(request, prefix + "chkd_iss", ""));
		setActArrDt(JSPUtil.getParameter(request, prefix + "act_arr_dt", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setOblRlseFlg(JSPUtil.getParameter(request, prefix + "obl_rlse_flg", ""));
		setObSrepCd(JSPUtil.getParameter(request, prefix + "ob_srep_cd", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setActDepDt(JSPUtil.getParameter(request, prefix + "act_dep_dt", ""));
		setShipperCd(JSPUtil.getParameter(request, prefix + "shipper_cd", ""));
		setPolClptIndSeq(JSPUtil.getParameter(request, prefix + "pol_clpt_ind_seq", ""));
		setFwdrCd(JSPUtil.getParameter(request, prefix + "fwdr_cd", ""));
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		SetRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setBkgToDt(JSPUtil.getParameter(request, prefix + "bkg_to_dt", ""));
		setBkgFromDt(JSPUtil.getParameter(request, prefix + "bkg_from_dt", ""));
		setTypeDate(JSPUtil.getParameter(request, prefix + "type_date", ""));
		setTrunkVvd(JSPUtil.getParameter(request, prefix + "trunk_vvd", ""));
		
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return GrpBlDtInVO[]
	 */
	public GrpBlDtInVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefixtjs
	 * @return GrpBlDtInVO[]
	 */
	public GrpBlDtInVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		GrpBlDtInVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] obInfoIssRdyFlg = (JSPUtil.getParameter(request, prefix	+ "ob_info_iss_rdy_flg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] blRdyFlg = (JSPUtil.getParameter(request, prefix	+ "bl_rdy_flg", length));
			String[] oblIssFlg = (JSPUtil.getParameter(request, prefix	+ "obl_iss_flg", length));
			String[] chkdIss = (JSPUtil.getParameter(request, prefix	+ "chkd_iss", length));
			String[] actArrDt = (JSPUtil.getParameter(request, prefix	+ "act_arr_dt", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] oblRlseFlg = (JSPUtil.getParameter(request, prefix	+ "obl_rlse_flg", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] actDepDt = (JSPUtil.getParameter(request, prefix	+ "act_dep_dt", length));
			String[] shipperCd = (JSPUtil.getParameter(request, prefix	+ "shipper_cd", length));
			String[] polClptIndSeq = (JSPUtil.getParameter(request, prefix	+ "pol_clpt_ind_seq", length));
			String[] fwdrCd = (JSPUtil.getParameter(request, prefix	+ "fwdr_cd", length));
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] bkgToDt = (JSPUtil.getParameter(request, prefix	+ "bkg_to_dt", length));
			String[] bkgFromDt = (JSPUtil.getParameter(request, prefix	+ "bkg_from_dt", length));
			String[] typeDate = (JSPUtil.getParameter(request, prefix	+ "type_date", length));
			String[] trunkVvd = (JSPUtil.getParameter(request, prefix	+ "trunk_vvd", length));
			
			for (int i = 0; i < length; i++) {
				model = new GrpBlDtInVO();
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (blRdyFlg[i] != null)
					model.setBlRdyFlg(blRdyFlg[i]);
				if (oblIssFlg[i] != null)
					model.setOblIssFlg(oblIssFlg[i]);
				if (chkdIss[i] != null)
					model.setChkdIss(chkdIss[i]);
				if (actArrDt[i] != null)
					model.setActArrDt(actArrDt[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (oblRlseFlg[i] != null)
					model.setOblRlseFlg(oblRlseFlg[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (actDepDt[i] != null)
					model.setActDepDt(actDepDt[i]);
				if (shipperCd[i] != null)
					model.setShipperCd(shipperCd[i]);
				if (polClptIndSeq[i] != null)
					model.setPolClptIndSeq(polClptIndSeq[i]);
				if (fwdrCd[i] != null)
					model.setFwdrCd(fwdrCd[i]);
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (rfaNo[i] != null)
					model.SetRfaNo(rfaNo[i]);
				
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (bkgToDt[i] != null)
					model.setBkgToDt(bkgToDt[i]);
				if (bkgFromDt[i] != null)
					model.setBkgFromDt(bkgFromDt[i]);
				if (typeDate[i] != null)
					model.setTypeDate(typeDate[i]);
				if (trunkVvd[i] != null)
					model.setTrunkVvd(trunkVvd[i]);
				if (obInfoIssRdyFlg[i] != null)
					model.setObInfoIssRdyFlg(obInfoIssRdyFlg[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getGrpBlDtInVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return GrpBlDtInVO[]
	 */
	public GrpBlDtInVO[] getGrpBlDtInVOs(){
		GrpBlDtInVO[] vos = (GrpBlDtInVO[])models.toArray(new GrpBlDtInVO[models.size()]);
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
		this.obInfoIssRdyFlg = this.obInfoIssRdyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blRdyFlg = this.blRdyFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblIssFlg = this.oblIssFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkdIss = this.chkdIss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actArrDt = this.actArrDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oblRlseFlg = this.oblRlseFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.actDepDt = this.actDepDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shipperCd = this.shipperCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polClptIndSeq = this.polClptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fwdrCd = this.fwdrCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgToDt = this.bkgToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgFromDt = this.bkgFromDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.typeDate = this.typeDate .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trunkVvd = this.trunkVvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		
	}
}
