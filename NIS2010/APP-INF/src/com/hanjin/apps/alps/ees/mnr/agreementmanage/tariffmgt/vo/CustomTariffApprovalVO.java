/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CustomTariffApprovalVO.java
*@FileTitle : CustomTariffApprovalVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2010.02.18 김완규 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.vo;

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
 * @author 김완규
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CustomTariffApprovalVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CustomTariffApprovalVO> models = new ArrayList<CustomTariffApprovalVO>();
	
	/* Column Info */
	private String mnrTrfStsCd = null;
	/* Column Info */
	private String creDt = null;
	/* Column Info */
	private String aproOfcCd = null;
	/* Column Info */
	private String totalRatio = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String mnrTrfStsNm = null;
	/* Column Info */
	private String chassis = null;
	/* Column Info */
	private String vndrNm = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String eqKndNm = null;
	/* Column Info */
	private String mnrTrfStsDt = null;
	/* Column Info */
	private String genset = null;
	/* Column Info */
	private String updUsrId = null;
	/* Column Info */
	private String dry = null;
	/* Column Info */
	private String specialDry = null;
	/* Column Info */
	private String arHdQtrOfcCd = null;
	/* Column Info */
	private String agmtNo = null;
	/* Column Info */
	private String reeferUnit = null;
	/* Column Info */
	private String eqKndCd = null;
	/* Column Info */
	private String aproDt = null;
	/* Column Info */
	private String reeferBox = null;
	/* Column Info */
	private String mnrTrfRmk = null;
	/* Column Info */
	private String aproUsrId = null;
	/* Column Info */
	private String trfNo = null;
	/* Column Info */
	private String vndrSeq = null;
	/* Column Info */
	private String rqstOfcCd = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CustomTariffApprovalVO() {}

	public CustomTariffApprovalVO(String ibflag, String pagerows, String mnrTrfStsCd, String creDt, String totalRatio, String aproOfcCd, String vndrNm, String chassis, String mnrTrfStsNm, String eqKndNm, String mnrTrfStsDt, String genset, String updUsrId, String dry, String specialDry, String arHdQtrOfcCd, String agmtNo, String reeferUnit, String eqKndCd, String aproDt, String reeferBox, String aproUsrId, String trfNo, String vndrSeq, String rqstOfcCd, String mnrTrfRmk) {
		this.mnrTrfStsCd = mnrTrfStsCd;
		this.creDt = creDt;
		this.aproOfcCd = aproOfcCd;
		this.totalRatio = totalRatio;
		this.pagerows = pagerows;
		this.mnrTrfStsNm = mnrTrfStsNm;
		this.chassis = chassis;
		this.vndrNm = vndrNm;
		this.ibflag = ibflag;
		this.eqKndNm = eqKndNm;
		this.mnrTrfStsDt = mnrTrfStsDt;
		this.genset = genset;
		this.updUsrId = updUsrId;
		this.dry = dry;
		this.specialDry = specialDry;
		this.arHdQtrOfcCd = arHdQtrOfcCd;
		this.agmtNo = agmtNo;
		this.reeferUnit = reeferUnit;
		this.eqKndCd = eqKndCd;
		this.aproDt = aproDt;
		this.reeferBox = reeferBox;
		this.mnrTrfRmk = mnrTrfRmk;
		this.aproUsrId = aproUsrId;
		this.trfNo = trfNo;
		this.vndrSeq = vndrSeq;
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("mnr_trf_sts_cd", getMnrTrfStsCd());
		this.hashColumns.put("cre_dt", getCreDt());
		this.hashColumns.put("apro_ofc_cd", getAproOfcCd());
		this.hashColumns.put("total_ratio", getTotalRatio());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("mnr_trf_sts_nm", getMnrTrfStsNm());
		this.hashColumns.put("chassis", getChassis());
		this.hashColumns.put("vndr_nm", getVndrNm());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("eq_knd_nm", getEqKndNm());
		this.hashColumns.put("mnr_trf_sts_dt", getMnrTrfStsDt());
		this.hashColumns.put("genset", getGenset());
		this.hashColumns.put("upd_usr_id", getUpdUsrId());
		this.hashColumns.put("dry", getDry());
		this.hashColumns.put("special_dry", getSpecialDry());
		this.hashColumns.put("ar_hd_qtr_ofc_cd", getArHdQtrOfcCd());
		this.hashColumns.put("agmt_no", getAgmtNo());
		this.hashColumns.put("reefer_unit", getReeferUnit());
		this.hashColumns.put("eq_knd_cd", getEqKndCd());
		this.hashColumns.put("apro_dt", getAproDt());
		this.hashColumns.put("reefer_box", getReeferBox());
		this.hashColumns.put("mnr_trf_rmk", getMnrTrfRmk());
		this.hashColumns.put("apro_usr_id", getAproUsrId());
		this.hashColumns.put("trf_no", getTrfNo());
		this.hashColumns.put("vndr_seq", getVndrSeq());
		this.hashColumns.put("rqst_ofc_cd", getRqstOfcCd());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("mnr_trf_sts_cd", "mnrTrfStsCd");
		this.hashFields.put("cre_dt", "creDt");
		this.hashFields.put("apro_ofc_cd", "aproOfcCd");
		this.hashFields.put("total_ratio", "totalRatio");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("mnr_trf_sts_nm", "mnrTrfStsNm");
		this.hashFields.put("chassis", "chassis");
		this.hashFields.put("vndr_nm", "vndrNm");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("eq_knd_nm", "eqKndNm");
		this.hashFields.put("mnr_trf_sts_dt", "mnrTrfStsDt");
		this.hashFields.put("genset", "genset");
		this.hashFields.put("upd_usr_id", "updUsrId");
		this.hashFields.put("dry", "dry");
		this.hashFields.put("special_dry", "specialDry");
		this.hashFields.put("ar_hd_qtr_ofc_cd", "arHdQtrOfcCd");
		this.hashFields.put("agmt_no", "agmtNo");
		this.hashFields.put("reefer_unit", "reeferUnit");
		this.hashFields.put("eq_knd_cd", "eqKndCd");
		this.hashFields.put("apro_dt", "aproDt");
		this.hashFields.put("reefer_box", "reeferBox");
		this.hashFields.put("mnr_trf_rmk", "mnrTrfRmk");
		this.hashFields.put("apro_usr_id", "aproUsrId");
		this.hashFields.put("trf_no", "trfNo");
		this.hashFields.put("vndr_seq", "vndrSeq");
		this.hashFields.put("rqst_ofc_cd", "rqstOfcCd");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return mnrTrfStsCd
	 */
	public String getMnrTrfStsCd() {
		return this.mnrTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @return creDt
	 */
	public String getCreDt() {
		return this.creDt;
	}
	
	/**
	 * Column Info
	 * @return aproOfcCd
	 */
	public String getAproOfcCd() {
		return this.aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @return totalRatio
	 */
	public String getTotalRatio() {
		return this.totalRatio;
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
	 * @return mnrTrfStsNm
	 */
	public String getMnrTrfStsNm() {
		return this.mnrTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @return chassis
	 */
	public String getChassis() {
		return this.chassis;
	}
	
	/**
	 * Column Info
	 * @return vndrNm
	 */
	public String getVndrNm() {
		return this.vndrNm;
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
	 * @return eqKndNm
	 */
	public String getEqKndNm() {
		return this.eqKndNm;
	}
	
	/**
	 * Column Info
	 * @return mnrTrfStsDt
	 */
	public String getMnrTrfStsDt() {
		return this.mnrTrfStsDt;
	}
	
	/**
	 * Column Info
	 * @return genset
	 */
	public String getGenset() {
		return this.genset;
	}
	
	/**
	 * Column Info
	 * @return updUsrId
	 */
	public String getUpdUsrId() {
		return this.updUsrId;
	}
	
	/**
	 * Column Info
	 * @return dry
	 */
	public String getDry() {
		return this.dry;
	}
	
	/**
	 * Column Info
	 * @return specialDry
	 */
	public String getSpecialDry() {
		return this.specialDry;
	}
	
	/**
	 * Column Info
	 * @return arHdQtrOfcCd
	 */
	public String getArHdQtrOfcCd() {
		return this.arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @return agmtNo
	 */
	public String getAgmtNo() {
		return this.agmtNo;
	}
	
	/**
	 * Column Info
	 * @return reeferUnit
	 */
	public String getReeferUnit() {
		return this.reeferUnit;
	}
	
	/**
	 * Column Info
	 * @return eqKndCd
	 */
	public String getEqKndCd() {
		return this.eqKndCd;
	}
	
	/**
	 * Column Info
	 * @return aproDt
	 */
	public String getAproDt() {
		return this.aproDt;
	}
	
	/**
	 * Column Info
	 * @return reeferBox
	 */
	public String getReeferBox() {
		return this.reeferBox;
	}
	
	/**
	 * Column Info
	 * @return mnrTrfRmk
	 */
	public String getMnrTrfRmk() {
		return this.mnrTrfRmk;
	}
	
	/**
	 * Column Info
	 * @return aproUsrId
	 */
	public String getAproUsrId() {
		return this.aproUsrId;
	}
	
	/**
	 * Column Info
	 * @return trfNo
	 */
	public String getTrfNo() {
		return this.trfNo;
	}
	
	/**
	 * Column Info
	 * @return vndrSeq
	 */
	public String getVndrSeq() {
		return this.vndrSeq;
	}
	
	/**
	 * Column Info
	 * @return rqstOfcCd
	 */
	public String getRqstOfcCd() {
		return this.rqstOfcCd;
	}
	

	/**
	 * Column Info
	 * @param mnrTrfStsCd
	 */
	public void setMnrTrfStsCd(String mnrTrfStsCd) {
		this.mnrTrfStsCd = mnrTrfStsCd;
	}
	
	/**
	 * Column Info
	 * @param creDt
	 */
	public void setCreDt(String creDt) {
		this.creDt = creDt;
	}
	
	/**
	 * Column Info
	 * @param aproOfcCd
	 */
	public void setAproOfcCd(String aproOfcCd) {
		this.aproOfcCd = aproOfcCd;
	}
	
	/**
	 * Column Info
	 * @param totalRatio
	 */
	public void setTotalRatio(String totalRatio) {
		this.totalRatio = totalRatio;
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
	 * @param mnrTrfStsNm
	 */
	public void setMnrTrfStsNm(String mnrTrfStsNm) {
		this.mnrTrfStsNm = mnrTrfStsNm;
	}
	
	/**
	 * Column Info
	 * @param chassis
	 */
	public void setChassis(String chassis) {
		this.chassis = chassis;
	}
	
	/**
	 * Column Info
	 * @param vndrNm
	 */
	public void setVndrNm(String vndrNm) {
		this.vndrNm = vndrNm;
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
	 * @param eqKndNm
	 */
	public void setEqKndNm(String eqKndNm) {
		this.eqKndNm = eqKndNm;
	}
	
	/**
	 * Column Info
	 * @param mnrTrfStsDt
	 */
	public void setMnrTrfStsDt(String mnrTrfStsDt) {
		this.mnrTrfStsDt = mnrTrfStsDt;
	}
	
	/**
	 * Column Info
	 * @param genset
	 */
	public void setGenset(String genset) {
		this.genset = genset;
	}
	
	/**
	 * Column Info
	 * @param updUsrId
	 */
	public void setUpdUsrId(String updUsrId) {
		this.updUsrId = updUsrId;
	}
	
	/**
	 * Column Info
	 * @param dry
	 */
	public void setDry(String dry) {
		this.dry = dry;
	}
	
	/**
	 * Column Info
	 * @param specialDry
	 */
	public void setSpecialDry(String specialDry) {
		this.specialDry = specialDry;
	}
	
	/**
	 * Column Info
	 * @param arHdQtrOfcCd
	 */
	public void setArHdQtrOfcCd(String arHdQtrOfcCd) {
		this.arHdQtrOfcCd = arHdQtrOfcCd;
	}
	
	/**
	 * Column Info
	 * @param agmtNo
	 */
	public void setAgmtNo(String agmtNo) {
		this.agmtNo = agmtNo;
	}
	
	/**
	 * Column Info
	 * @param reeferUnit
	 */
	public void setReeferUnit(String reeferUnit) {
		this.reeferUnit = reeferUnit;
	}
	
	/**
	 * Column Info
	 * @param eqKndCd
	 */
	public void setEqKndCd(String eqKndCd) {
		this.eqKndCd = eqKndCd;
	}
	
	/**
	 * Column Info
	 * @param aproDt
	 */
	public void setAproDt(String aproDt) {
		this.aproDt = aproDt;
	}
	
	/**
	 * Column Info
	 * @param reeferBox
	 */
	public void setReeferBox(String reeferBox) {
		this.reeferBox = reeferBox;
	}
	
	/**
	 * Column Info
	 * @param mnrTrfRmk
	 */
	public void setMnrTrfRmk(String mnrTrfRmk) {
		this.mnrTrfRmk = mnrTrfRmk;
	}
	
	/**
	 * Column Info
	 * @param aproUsrId
	 */
	public void setAproUsrId(String aproUsrId) {
		this.aproUsrId = aproUsrId;
	}
	
	/**
	 * Column Info
	 * @param trfNo
	 */
	public void setTrfNo(String trfNo) {
		this.trfNo = trfNo;
	}
	
	/**
	 * Column Info
	 * @param vndrSeq
	 */
	public void setVndrSeq(String vndrSeq) {
		this.vndrSeq = vndrSeq;
	}
	
	/**
	 * Column Info
	 * @param rqstOfcCd
	 */
	public void setRqstOfcCd(String rqstOfcCd) {
		this.rqstOfcCd = rqstOfcCd;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setMnrTrfStsCd(JSPUtil.getParameter(request, "mnr_trf_sts_cd", ""));
		setCreDt(JSPUtil.getParameter(request, "cre_dt", ""));
		setAproOfcCd(JSPUtil.getParameter(request, "apro_ofc_cd", ""));
		setTotalRatio(JSPUtil.getParameter(request, "total_ratio", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setMnrTrfStsNm(JSPUtil.getParameter(request, "mnr_trf_sts_nm", ""));
		setChassis(JSPUtil.getParameter(request, "chassis", ""));
		setVndrNm(JSPUtil.getParameter(request, "vndr_nm", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setEqKndNm(JSPUtil.getParameter(request, "eq_knd_nm", ""));
		setMnrTrfStsDt(JSPUtil.getParameter(request, "mnr_trf_sts_dt", ""));
		setGenset(JSPUtil.getParameter(request, "genset", ""));
		setUpdUsrId(JSPUtil.getParameter(request, "upd_usr_id", ""));
		setDry(JSPUtil.getParameter(request, "dry", ""));
		setSpecialDry(JSPUtil.getParameter(request, "special_dry", ""));
		setArHdQtrOfcCd(JSPUtil.getParameter(request, "ar_hd_qtr_ofc_cd", ""));
		setAgmtNo(JSPUtil.getParameter(request, "agmt_no", ""));
		setReeferUnit(JSPUtil.getParameter(request, "reefer_unit", ""));
		setEqKndCd(JSPUtil.getParameter(request, "eq_knd_cd", ""));
		setAproDt(JSPUtil.getParameter(request, "apro_dt", ""));
		setReeferBox(JSPUtil.getParameter(request, "reefer_box", ""));
		setMnrTrfRmk(JSPUtil.getParameter(request, "mnr_trf_rmk", ""));
		setAproUsrId(JSPUtil.getParameter(request, "apro_usr_id", ""));
		setTrfNo(JSPUtil.getParameter(request, "trf_no", ""));
		setVndrSeq(JSPUtil.getParameter(request, "vndr_seq", ""));
		setRqstOfcCd(JSPUtil.getParameter(request, "rqst_ofc_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CustomTariffApprovalVO[]
	 */
	public CustomTariffApprovalVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CustomTariffApprovalVO[]
	 */
	public CustomTariffApprovalVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CustomTariffApprovalVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] mnrTrfStsCd = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_sts_cd", length));
			String[] creDt = (JSPUtil.getParameter(request, prefix	+ "cre_dt", length));
			String[] aproOfcCd = (JSPUtil.getParameter(request, prefix	+ "apro_ofc_cd", length));
			String[] totalRatio = (JSPUtil.getParameter(request, prefix	+ "total_ratio", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] mnrTrfStsNm = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_sts_nm", length));
			String[] chassis = (JSPUtil.getParameter(request, prefix	+ "chassis", length));
			String[] vndrNm = (JSPUtil.getParameter(request, prefix	+ "vndr_nm", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] eqKndNm = (JSPUtil.getParameter(request, prefix	+ "eq_knd_nm", length));
			String[] mnrTrfStsDt = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_sts_dt", length));
			String[] genset = (JSPUtil.getParameter(request, prefix	+ "genset", length));
			String[] updUsrId = (JSPUtil.getParameter(request, prefix	+ "upd_usr_id", length));
			String[] dry = (JSPUtil.getParameter(request, prefix	+ "dry", length));
			String[] specialDry = (JSPUtil.getParameter(request, prefix	+ "special_dry", length));
			String[] arHdQtrOfcCd = (JSPUtil.getParameter(request, prefix	+ "ar_hd_qtr_ofc_cd", length));
			String[] agmtNo = (JSPUtil.getParameter(request, prefix	+ "agmt_no", length));
			String[] reeferUnit = (JSPUtil.getParameter(request, prefix	+ "reefer_unit", length));
			String[] eqKndCd = (JSPUtil.getParameter(request, prefix	+ "eq_knd_cd", length));
			String[] aproDt = (JSPUtil.getParameter(request, prefix	+ "apro_dt", length));
			String[] reeferBox = (JSPUtil.getParameter(request, prefix	+ "reefer_box", length));
			String[] mnrTrfRmk = (JSPUtil.getParameter(request, prefix	+ "mnr_trf_rmk", length));
			String[] aproUsrId = (JSPUtil.getParameter(request, prefix	+ "apro_usr_id", length));
			String[] trfNo = (JSPUtil.getParameter(request, prefix	+ "trf_no", length));
			String[] vndrSeq = (JSPUtil.getParameter(request, prefix	+ "vndr_seq", length));
			String[] rqstOfcCd = (JSPUtil.getParameter(request, prefix	+ "rqst_ofc_cd", length));
			
			for (int i = 0; i < length; i++) {
				model = new CustomTariffApprovalVO();
				if (mnrTrfStsCd[i] != null)
					model.setMnrTrfStsCd(mnrTrfStsCd[i]);
				if (creDt[i] != null)
					model.setCreDt(creDt[i]);
				if (aproOfcCd[i] != null)
					model.setAproOfcCd(aproOfcCd[i]);
				if (totalRatio[i] != null)
					model.setTotalRatio(totalRatio[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (mnrTrfStsNm[i] != null)
					model.setMnrTrfStsNm(mnrTrfStsNm[i]);
				if (chassis[i] != null)
					model.setChassis(chassis[i]);
				if (vndrNm[i] != null)
					model.setVndrNm(vndrNm[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (eqKndNm[i] != null)
					model.setEqKndNm(eqKndNm[i]);
				if (mnrTrfStsDt[i] != null)
					model.setMnrTrfStsDt(mnrTrfStsDt[i]);
				if (genset[i] != null)
					model.setGenset(genset[i]);
				if (updUsrId[i] != null)
					model.setUpdUsrId(updUsrId[i]);
				if (dry[i] != null)
					model.setDry(dry[i]);
				if (specialDry[i] != null)
					model.setSpecialDry(specialDry[i]);
				if (arHdQtrOfcCd[i] != null)
					model.setArHdQtrOfcCd(arHdQtrOfcCd[i]);
				if (agmtNo[i] != null)
					model.setAgmtNo(agmtNo[i]);
				if (reeferUnit[i] != null)
					model.setReeferUnit(reeferUnit[i]);
				if (eqKndCd[i] != null)
					model.setEqKndCd(eqKndCd[i]);
				if (aproDt[i] != null)
					model.setAproDt(aproDt[i]);
				if (reeferBox[i] != null)
					model.setReeferBox(reeferBox[i]);
				if (mnrTrfRmk[i] != null)
					model.setMnrTrfRmk(mnrTrfRmk[i]);
				if (aproUsrId[i] != null)
					model.setAproUsrId(aproUsrId[i]);
				if (trfNo[i] != null)
					model.setTrfNo(trfNo[i]);
				if (vndrSeq[i] != null)
					model.setVndrSeq(vndrSeq[i]);
				if (rqstOfcCd[i] != null)
					model.setRqstOfcCd(rqstOfcCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCustomTariffApprovalVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CustomTariffApprovalVO[]
	 */
	public CustomTariffApprovalVO[] getCustomTariffApprovalVOs(){
		CustomTariffApprovalVO[] vos = (CustomTariffApprovalVO[])models.toArray(new CustomTariffApprovalVO[models.size()]);
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
		this.mnrTrfStsCd = this.mnrTrfStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.creDt = this.creDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproOfcCd = this.aproOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.totalRatio = this.totalRatio .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfStsNm = this.mnrTrfStsNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chassis = this.chassis .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrNm = this.vndrNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndNm = this.eqKndNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfStsDt = this.mnrTrfStsDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.genset = this.genset .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.updUsrId = this.updUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dry = this.dry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.specialDry = this.specialDry .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.arHdQtrOfcCd = this.arHdQtrOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.agmtNo = this.agmtNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reeferUnit = this.reeferUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eqKndCd = this.eqKndCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproDt = this.aproDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.reeferBox = this.reeferBox .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mnrTrfRmk = this.mnrTrfRmk .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.aproUsrId = this.aproUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.trfNo = this.trfNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vndrSeq = this.vndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rqstOfcCd = this.rqstOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
