/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SpecialCargoSummaryReportVO.java
*@FileTitle : SpecialCargoSummaryReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.16
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.10.16 김기종 
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingreport.specialreport.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 김기종
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class SpecialCargoSummaryReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<SpecialCargoSummaryReportVO> models = new ArrayList<SpecialCargoSummaryReportVO>();
	
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String chkLType = null;
	/* Column Info */
	private String spclCgoSeq = null;
	/* Column Info */
	private String docUsrId = null;
	/* Column Info */
	private String ts = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Column Info */
	private String stow = null;
	/* Column Info */
	private String chkTType = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String obSrepCd = null;
	/* Column Info */
	private String bkgStaffType = null;
	/* Column Info */
	private String authResultT = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String spclCgoAproCd = null;
	/* Column Info */
	private String wgt = null;
	/* Column Info */
	private String vvdCd = null;
	/* Column Info */
	private String delNodCd = null;
	/* Column Info */
	private String overSize = null;
	/* Column Info */
	private String spclCgoType = null;
	/* Column Info */
	private String mrnPolutFlg = null;
	/* Column Info */
	private String bkgOfcCd = null;
	/* Column Info */
	private String tpSz = null;
	/* Column Info */
	private String porNodCd = null;
	/* Column Info */
	private String vent = null;
	/* Column Info */
	private String cntrVentTpCd = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String spclCntrSeq = null;
	/* Column Info */
	private String polNodCd = null;
	/* Column Info */
	private String unNo = null;
	/* Column Info */
	private String dgClass = null;
	/* Column Info */
	private String um = null;
	/* Column Info */
	private String zoneCode = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String podNodCd = null;
	/* Column Info */
	private String dgApprRef = null;
	/* Column Info */
	private String cdoTemp = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String clptIndSeq = null;
	/* Column Info */
	private String ng = null;
	/* Column Info */
	private String bkgStaff = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public SpecialCargoSummaryReportVO() {}

	public SpecialCargoSummaryReportVO(String ibflag, String pagerows, String bkgNo, String podCd, String delCd, String bkgStsCd, String vvdCd, String vslCd, String skdVoyNo, String skdDirCd, String ng, String clptIndSeq, String ts, String docUsrId, String porCd, String polCd, String porNodCd, String polNodCd, String podNodCd, String delNodCd, String bkgOfcCd, String obSrepCd, String cntrNo, String spclCgoType, String spclCntrSeq, String spclCgoSeq, String authResultT, String tpSz, String wgt, String dgClass, String overSize, String unNo, String dgApprRef, String mrnPolutFlg, String cdoTemp, String vent, String stow, String zoneCode, String um, String bkgStaffType, String bkgStaff, String spclCgoAproCd, String chkLType, String chkTType,String cntrVentTpCd) {
		this.porCd = porCd;
		this.vslCd = vslCd;
		this.chkLType = chkLType;
		this.spclCgoSeq = spclCgoSeq;
		this.docUsrId = docUsrId;
		this.ts = ts;
		this.bkgStsCd = bkgStsCd;
		this.stow = stow;
		this.chkTType = chkTType;
		this.pagerows = pagerows;
		this.obSrepCd = obSrepCd;
		this.bkgStaffType = bkgStaffType;
		this.authResultT = authResultT;
		this.ibflag = ibflag;
		this.polCd = polCd;
		this.spclCgoAproCd = spclCgoAproCd;
		this.wgt = wgt;
		this.vvdCd = vvdCd;
		this.delNodCd = delNodCd;
		this.overSize = overSize;
		this.spclCgoType = spclCgoType;
		this.mrnPolutFlg = mrnPolutFlg;
		this.bkgOfcCd = bkgOfcCd;
		this.tpSz = tpSz;
		this.porNodCd = porNodCd;
		this.vent = vent;
		this.cntrVentTpCd = cntrVentTpCd;
		this.delCd = delCd;
		this.skdVoyNo = skdVoyNo;
		this.spclCntrSeq = spclCntrSeq;
		this.polNodCd = polNodCd;
		this.unNo = unNo;
		this.dgClass = dgClass;
		this.um = um;
		this.zoneCode = zoneCode;
		this.skdDirCd = skdDirCd;
		this.podCd = podCd;
		this.bkgNo = bkgNo;
		this.podNodCd = podNodCd;
		this.dgApprRef = dgApprRef;
		this.cdoTemp = cdoTemp;
		this.cntrNo = cntrNo;
		this.clptIndSeq = clptIndSeq;
		this.ng = ng;
		this.bkgStaff = bkgStaff;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("chk_l_type", getChkLType());
		this.hashColumns.put("spcl_cgo_seq", getSpclCgoSeq());
		this.hashColumns.put("doc_usr_id", getDocUsrId());
		this.hashColumns.put("ts", getTs());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("stow", getStow());
		this.hashColumns.put("chk_t_type", getChkTType());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("ob_srep_cd", getObSrepCd());
		this.hashColumns.put("bkg_staff_type", getBkgStaffType());
		this.hashColumns.put("auth_result_t", getAuthResultT());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("spcl_cgo_apro_cd", getSpclCgoAproCd());
		this.hashColumns.put("wgt", getWgt());
		this.hashColumns.put("vvd_cd", getVvdCd());
		this.hashColumns.put("del_nod_cd", getDelNodCd());
		this.hashColumns.put("over_size", getOverSize());
		this.hashColumns.put("spcl_cgo_type", getSpclCgoType());
		this.hashColumns.put("mrn_polut_flg", getMrnPolutFlg());
		this.hashColumns.put("bkg_ofc_cd", getBkgOfcCd());
		this.hashColumns.put("tp_sz", getTpSz());
		this.hashColumns.put("por_nod_cd", getPorNodCd());
		this.hashColumns.put("vent", getVent());
		this.hashColumns.put("cntr_vent_tp_cd", getCntrVentTpCd());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("spcl_cntr_seq", getSpclCntrSeq());
		this.hashColumns.put("pol_nod_cd", getPolNodCd());
		this.hashColumns.put("un_no", getUnNo());
		this.hashColumns.put("dg_class", getDgClass());
		this.hashColumns.put("um", getUm());
		this.hashColumns.put("zone_code", getZoneCode());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("pod_nod_cd", getPodNodCd());
		this.hashColumns.put("dg_appr_ref", getDgApprRef());
		this.hashColumns.put("cdo_temp", getCdoTemp());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("clpt_ind_seq", getClptIndSeq());
		this.hashColumns.put("ng", getNg());
		this.hashColumns.put("bkg_staff", getBkgStaff());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("chk_l_type", "chkLType");
		this.hashFields.put("spcl_cgo_seq", "spclCgoSeq");
		this.hashFields.put("doc_usr_id", "docUsrId");
		this.hashFields.put("ts", "ts");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("stow", "stow");
		this.hashFields.put("chk_t_type", "chkTType");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("ob_srep_cd", "obSrepCd");
		this.hashFields.put("bkg_staff_type", "bkgStaffType");
		this.hashFields.put("auth_result_t", "authResultT");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("spcl_cgo_apro_cd", "spclCgoAproCd");
		this.hashFields.put("wgt", "wgt");
		this.hashFields.put("vvd_cd", "vvdCd");
		this.hashFields.put("del_nod_cd", "delNodCd");
		this.hashFields.put("over_size", "overSize");
		this.hashFields.put("spcl_cgo_type", "spclCgoType");
		this.hashFields.put("mrn_polut_flg", "mrnPolutFlg");
		this.hashFields.put("bkg_ofc_cd", "bkgOfcCd");
		this.hashFields.put("tp_sz", "tpSz");
		this.hashFields.put("por_nod_cd", "porNodCd");
		this.hashFields.put("vent", "vent");
		this.hashFields.put("cntr_vent_tp_cd", "cntrVentTpCd");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("spcl_cntr_seq", "spclCntrSeq");
		this.hashFields.put("pol_nod_cd", "polNodCd");
		this.hashFields.put("un_no", "unNo");
		this.hashFields.put("dg_class", "dgClass");
		this.hashFields.put("um", "um");
		this.hashFields.put("zone_code", "zoneCode");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("pod_nod_cd", "podNodCd");
		this.hashFields.put("dg_appr_ref", "dgApprRef");
		this.hashFields.put("cdo_temp", "cdoTemp");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("clpt_ind_seq", "clptIndSeq");
		this.hashFields.put("ng", "ng");
		this.hashFields.put("bkg_staff", "bkgStaff");
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
	 * @return vslCd
	 */
	public String getVslCd() {
		return this.vslCd;
	}
	
	/**
	 * Column Info
	 * @return chkLType
	 */
	public String getChkLType() {
		return this.chkLType;
	}
	
	/**
	 * Column Info
	 * @return spclCgoSeq
	 */
	public String getSpclCgoSeq() {
		return this.spclCgoSeq;
	}
	
	/**
	 * Column Info
	 * @return docUsrId
	 */
	public String getDocUsrId() {
		return this.docUsrId;
	}
	
	/**
	 * Column Info
	 * @return ts
	 */
	public String getTs() {
		return this.ts;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @return stow
	 */
	public String getStow() {
		return this.stow;
	}
	
	/**
	 * Column Info
	 * @return chkTType
	 */
	public String getChkTType() {
		return this.chkTType;
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
	 * @return obSrepCd
	 */
	public String getObSrepCd() {
		return this.obSrepCd;
	}
	
	/**
	 * Column Info
	 * @return bkgStaffType
	 */
	public String getBkgStaffType() {
		return this.bkgStaffType;
	}
	
	/**
	 * Column Info
	 * @return authResultT
	 */
	public String getAuthResultT() {
		return this.authResultT;
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
	 * @return spclCgoAproCd
	 */
	public String getSpclCgoAproCd() {
		return this.spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @return wgt
	 */
	public String getWgt() {
		return this.wgt;
	}
	
	/**
	 * Column Info
	 * @return vvdCd
	 */
	public String getVvdCd() {
		return this.vvdCd;
	}
	
	/**
	 * Column Info
	 * @return delNodCd
	 */
	public String getDelNodCd() {
		return this.delNodCd;
	}
	
	/**
	 * Column Info
	 * @return overSize
	 */
	public String getOverSize() {
		return this.overSize;
	}
	
	/**
	 * Column Info
	 * @return spclCgoType
	 */
	public String getSpclCgoType() {
		return this.spclCgoType;
	}
	
	/**
	 * Column Info
	 * @return mrnPolutFlg
	 */
	public String getMrnPolutFlg() {
		return this.mrnPolutFlg;
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
	 * @return tpSz
	 */
	public String getTpSz() {
		return this.tpSz;
	}
	
	/**
	 * Column Info
	 * @return porNodCd
	 */
	public String getPorNodCd() {
		return this.porNodCd;
	}
	
	/**
	 * Column Info
	 * @return vent
	 */
	public String getVent() {
		return this.vent;
	}
	
	/**
	 * Column Info
	 * @return cntrVentTpCd
	 */
	public String getCntrVentTpCd() {
		return this.cntrVentTpCd;
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
	 * @return skdVoyNo
	 */
	public String getSkdVoyNo() {
		return this.skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @return spclCntrSeq
	 */
	public String getSpclCntrSeq() {
		return this.spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @return polNodCd
	 */
	public String getPolNodCd() {
		return this.polNodCd;
	}
	
	/**
	 * Column Info
	 * @return unNo
	 */
	public String getUnNo() {
		return this.unNo;
	}
	
	/**
	 * Column Info
	 * @return dgClass
	 */
	public String getDgClass() {
		return this.dgClass;
	}
	
	/**
	 * Column Info
	 * @return um
	 */
	public String getUm() {
		return this.um;
	}
	
	/**
	 * Column Info
	 * @return zoneCode
	 */
	public String getZoneCode() {
		return this.zoneCode;
	}
	
	/**
	 * Column Info
	 * @return skdDirCd
	 */
	public String getSkdDirCd() {
		return this.skdDirCd;
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
	 * @return bkgNo
	 */
	public String getBkgNo() {
		return this.bkgNo;
	}
	
	/**
	 * Column Info
	 * @return podNodCd
	 */
	public String getPodNodCd() {
		return this.podNodCd;
	}
	
	/**
	 * Column Info
	 * @return dgApprRef
	 */
	public String getDgApprRef() {
		return this.dgApprRef;
	}
	
	/**
	 * Column Info
	 * @return cdoTemp
	 */
	public String getCdoTemp() {
		return this.cdoTemp;
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
	 * @return clptIndSeq
	 */
	public String getClptIndSeq() {
		return this.clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @return ng
	 */
	public String getNg() {
		return this.ng;
	}
	
	/**
	 * Column Info
	 * @return bkgStaff
	 */
	public String getBkgStaff() {
		return this.bkgStaff;
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
	 * @param vslCd
	 */
	public void setVslCd(String vslCd) {
		this.vslCd = vslCd;
	}
	
	/**
	 * Column Info
	 * @param chkLType
	 */
	public void setChkLType(String chkLType) {
		this.chkLType = chkLType;
	}
	
	/**
	 * Column Info
	 * @param spclCgoSeq
	 */
	public void setSpclCgoSeq(String spclCgoSeq) {
		this.spclCgoSeq = spclCgoSeq;
	}
	
	/**
	 * Column Info
	 * @param docUsrId
	 */
	public void setDocUsrId(String docUsrId) {
		this.docUsrId = docUsrId;
	}
	
	/**
	 * Column Info
	 * @param ts
	 */
	public void setTs(String ts) {
		this.ts = ts;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Column Info
	 * @param stow
	 */
	public void setStow(String stow) {
		this.stow = stow;
	}
	
	/**
	 * Column Info
	 * @param chkTType
	 */
	public void setChkTType(String chkTType) {
		this.chkTType = chkTType;
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
	 * @param obSrepCd
	 */
	public void setObSrepCd(String obSrepCd) {
		this.obSrepCd = obSrepCd;
	}
	
	/**
	 * Column Info
	 * @param bkgStaffType
	 */
	public void setBkgStaffType(String bkgStaffType) {
		this.bkgStaffType = bkgStaffType;
	}
	
	/**
	 * Column Info
	 * @param authResultT
	 */
	public void setAuthResultT(String authResultT) {
		this.authResultT = authResultT;
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
	 * @param spclCgoAproCd
	 */
	public void setSpclCgoAproCd(String spclCgoAproCd) {
		this.spclCgoAproCd = spclCgoAproCd;
	}
	
	/**
	 * Column Info
	 * @param wgt
	 */
	public void setWgt(String wgt) {
		this.wgt = wgt;
	}
	
	/**
	 * Column Info
	 * @param vvdCd
	 */
	public void setVvdCd(String vvdCd) {
		this.vvdCd = vvdCd;
	}
	
	/**
	 * Column Info
	 * @param delNodCd
	 */
	public void setDelNodCd(String delNodCd) {
		this.delNodCd = delNodCd;
	}
	
	/**
	 * Column Info
	 * @param overSize
	 */
	public void setOverSize(String overSize) {
		this.overSize = overSize;
	}
	
	/**
	 * Column Info
	 * @param spclCgoType
	 */
	public void setSpclCgoType(String spclCgoType) {
		this.spclCgoType = spclCgoType;
	}
	
	/**
	 * Column Info
	 * @param mrnPolutFlg
	 */
	public void setMrnPolutFlg(String mrnPolutFlg) {
		this.mrnPolutFlg = mrnPolutFlg;
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
	 * @param tpSz
	 */
	public void setTpSz(String tpSz) {
		this.tpSz = tpSz;
	}
	
	/**
	 * Column Info
	 * @param porNodCd
	 */
	public void setPorNodCd(String porNodCd) {
		this.porNodCd = porNodCd;
	}
	
	/**
	 * Column Info
	 * @param vent
	 */
	public void setVent(String vent) {
		this.vent = vent;
	}
	
	/**
	 * Column Info
	 * @param cntrVentTpCd
	 */
	public void setCntrVentTpCd(String cntrVentTpCd) {
		this.cntrVentTpCd = cntrVentTpCd;
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
	 * @param skdVoyNo
	 */
	public void setSkdVoyNo(String skdVoyNo) {
		this.skdVoyNo = skdVoyNo;
	}
	
	/**
	 * Column Info
	 * @param spclCntrSeq
	 */
	public void setSpclCntrSeq(String spclCntrSeq) {
		this.spclCntrSeq = spclCntrSeq;
	}
	
	/**
	 * Column Info
	 * @param polNodCd
	 */
	public void setPolNodCd(String polNodCd) {
		this.polNodCd = polNodCd;
	}
	
	/**
	 * Column Info
	 * @param unNo
	 */
	public void setUnNo(String unNo) {
		this.unNo = unNo;
	}
	
	/**
	 * Column Info
	 * @param dgClass
	 */
	public void setDgClass(String dgClass) {
		this.dgClass = dgClass;
	}
	
	/**
	 * Column Info
	 * @param um
	 */
	public void setUm(String um) {
		this.um = um;
	}
	
	/**
	 * Column Info
	 * @param zoneCode
	 */
	public void setZoneCode(String zoneCode) {
		this.zoneCode = zoneCode;
	}
	
	/**
	 * Column Info
	 * @param skdDirCd
	 */
	public void setSkdDirCd(String skdDirCd) {
		this.skdDirCd = skdDirCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param podNodCd
	 */
	public void setPodNodCd(String podNodCd) {
		this.podNodCd = podNodCd;
	}
	
	/**
	 * Column Info
	 * @param dgApprRef
	 */
	public void setDgApprRef(String dgApprRef) {
		this.dgApprRef = dgApprRef;
	}
	
	/**
	 * Column Info
	 * @param cdoTemp
	 */
	public void setCdoTemp(String cdoTemp) {
		this.cdoTemp = cdoTemp;
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
	 * @param clptIndSeq
	 */
	public void setClptIndSeq(String clptIndSeq) {
		this.clptIndSeq = clptIndSeq;
	}
	
	/**
	 * Column Info
	 * @param ng
	 */
	public void setNg(String ng) {
		this.ng = ng;
	}
	
	/**
	 * Column Info
	 * @param bkgStaff
	 */
	public void setBkgStaff(String bkgStaff) {
		this.bkgStaff = bkgStaff;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setPorCd(JSPUtil.getParameter(request, "por_cd", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setChkLType(JSPUtil.getParameter(request, "chk_l_type", ""));
		setSpclCgoSeq(JSPUtil.getParameter(request, "spcl_cgo_seq", ""));
		setDocUsrId(JSPUtil.getParameter(request, "doc_usr_id", ""));
		setTs(JSPUtil.getParameter(request, "ts", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setStow(JSPUtil.getParameter(request, "stow", ""));
		setChkTType(JSPUtil.getParameter(request, "chk_t_type", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setObSrepCd(JSPUtil.getParameter(request, "ob_srep_cd", ""));
		setBkgStaffType(JSPUtil.getParameter(request, "bkg_staff_type", ""));
		setAuthResultT(JSPUtil.getParameter(request, "auth_result_t", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setPolCd(JSPUtil.getParameter(request, "pol_cd", ""));
		setSpclCgoAproCd(JSPUtil.getParameter(request, "spcl_cgo_apro_cd", ""));
		setWgt(JSPUtil.getParameter(request, "wgt", ""));
		setVvdCd(JSPUtil.getParameter(request, "vvd_cd", ""));
		setDelNodCd(JSPUtil.getParameter(request, "del_nod_cd", ""));
		setOverSize(JSPUtil.getParameter(request, "over_size", ""));
		setSpclCgoType(JSPUtil.getParameter(request, "spcl_cgo_type", ""));
		setMrnPolutFlg(JSPUtil.getParameter(request, "mrn_polut_flg", ""));
		setBkgOfcCd(JSPUtil.getParameter(request, "bkg_ofc_cd", ""));
		setTpSz(JSPUtil.getParameter(request, "tp_sz", ""));
		setPorNodCd(JSPUtil.getParameter(request, "por_nod_cd", ""));
		setVent(JSPUtil.getParameter(request, "vent", ""));
		setDelCd(JSPUtil.getParameter(request, "del_cd", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, "skd_voy_no", ""));
		setSpclCntrSeq(JSPUtil.getParameter(request, "spcl_cntr_seq", ""));
		setPolNodCd(JSPUtil.getParameter(request, "pol_nod_cd", ""));
		setUnNo(JSPUtil.getParameter(request, "un_no", ""));
		setDgClass(JSPUtil.getParameter(request, "dg_class", ""));
		setUm(JSPUtil.getParameter(request, "um", ""));
		setZoneCode(JSPUtil.getParameter(request, "zone_code", ""));
		setSkdDirCd(JSPUtil.getParameter(request, "skd_dir_cd", ""));
		setPodCd(JSPUtil.getParameter(request, "pod_cd", ""));
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setPodNodCd(JSPUtil.getParameter(request, "pod_nod_cd", ""));
		setDgApprRef(JSPUtil.getParameter(request, "dg_appr_ref", ""));
		setCdoTemp(JSPUtil.getParameter(request, "cdo_temp", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setClptIndSeq(JSPUtil.getParameter(request, "clpt_ind_seq", ""));
		setNg(JSPUtil.getParameter(request, "ng", ""));
		setBkgStaff(JSPUtil.getParameter(request, "bkg_staff", ""));
		setCntrVentTpCd(JSPUtil.getParameter(request, "cntr_vent_tp_cd", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return SpecialCargoSummaryReportVO[]
	 */
	public SpecialCargoSummaryReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return SpecialCargoSummaryReportVO[]
	 */
	public SpecialCargoSummaryReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		SpecialCargoSummaryReportVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] chkLType = (JSPUtil.getParameter(request, prefix	+ "chk_l_type", length));
			String[] spclCgoSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_seq", length));
			String[] docUsrId = (JSPUtil.getParameter(request, prefix	+ "doc_usr_id", length));
			String[] ts = (JSPUtil.getParameter(request, prefix	+ "ts", length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd", length));
			String[] stow = (JSPUtil.getParameter(request, prefix	+ "stow", length));
			String[] chkTType = (JSPUtil.getParameter(request, prefix	+ "chk_t_type", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] obSrepCd = (JSPUtil.getParameter(request, prefix	+ "ob_srep_cd", length));
			String[] bkgStaffType = (JSPUtil.getParameter(request, prefix	+ "bkg_staff_type", length));
			String[] authResultT = (JSPUtil.getParameter(request, prefix	+ "auth_result_t", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] spclCgoAproCd = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_apro_cd", length));
			String[] wgt = (JSPUtil.getParameter(request, prefix	+ "wgt", length));
			String[] vvdCd = (JSPUtil.getParameter(request, prefix	+ "vvd_cd", length));
			String[] delNodCd = (JSPUtil.getParameter(request, prefix	+ "del_nod_cd", length));
			String[] overSize = (JSPUtil.getParameter(request, prefix	+ "over_size", length));
			String[] spclCgoType = (JSPUtil.getParameter(request, prefix	+ "spcl_cgo_type", length));
			String[] mrnPolutFlg = (JSPUtil.getParameter(request, prefix	+ "mrn_polut_flg", length));
			String[] bkgOfcCd = (JSPUtil.getParameter(request, prefix	+ "bkg_ofc_cd", length));
			String[] tpSz = (JSPUtil.getParameter(request, prefix	+ "tp_sz", length));
			String[] porNodCd = (JSPUtil.getParameter(request, prefix	+ "por_nod_cd", length));
			String[] vent = (JSPUtil.getParameter(request, prefix	+ "vent", length));
			String[] cntrVentTpCd = (JSPUtil.getParameter(request, prefix	+ "cntr_vent_tp_cd", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] spclCntrSeq = (JSPUtil.getParameter(request, prefix	+ "spcl_cntr_seq", length));
			String[] polNodCd = (JSPUtil.getParameter(request, prefix	+ "pol_nod_cd", length));
			String[] unNo = (JSPUtil.getParameter(request, prefix	+ "un_no", length));
			String[] dgClass = (JSPUtil.getParameter(request, prefix	+ "dg_class", length));
			String[] um = (JSPUtil.getParameter(request, prefix	+ "um", length));
			String[] zoneCode = (JSPUtil.getParameter(request, prefix	+ "zone_code", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] podNodCd = (JSPUtil.getParameter(request, prefix	+ "pod_nod_cd", length));
			String[] dgApprRef = (JSPUtil.getParameter(request, prefix	+ "dg_appr_ref", length));
			String[] cdoTemp = (JSPUtil.getParameter(request, prefix	+ "cdo_temp", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] clptIndSeq = (JSPUtil.getParameter(request, prefix	+ "clpt_ind_seq", length));
			String[] ng = (JSPUtil.getParameter(request, prefix	+ "ng", length));
			String[] bkgStaff = (JSPUtil.getParameter(request, prefix	+ "bkg_staff", length));
			
			for (int i = 0; i < length; i++) {
				model = new SpecialCargoSummaryReportVO();
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (chkLType[i] != null)
					model.setChkLType(chkLType[i]);
				if (spclCgoSeq[i] != null)
					model.setSpclCgoSeq(spclCgoSeq[i]);
				if (docUsrId[i] != null)
					model.setDocUsrId(docUsrId[i]);
				if (ts[i] != null)
					model.setTs(ts[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (stow[i] != null)
					model.setStow(stow[i]);
				if (chkTType[i] != null)
					model.setChkTType(chkTType[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (obSrepCd[i] != null)
					model.setObSrepCd(obSrepCd[i]);
				if (bkgStaffType[i] != null)
					model.setBkgStaffType(bkgStaffType[i]);
				if (authResultT[i] != null)
					model.setAuthResultT(authResultT[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (spclCgoAproCd[i] != null)
					model.setSpclCgoAproCd(spclCgoAproCd[i]);
				if (wgt[i] != null)
					model.setWgt(wgt[i]);
				if (vvdCd[i] != null)
					model.setVvdCd(vvdCd[i]);
				if (delNodCd[i] != null)
					model.setDelNodCd(delNodCd[i]);
				if (overSize[i] != null)
					model.setOverSize(overSize[i]);
				if (spclCgoType[i] != null)
					model.setSpclCgoType(spclCgoType[i]);
				if (mrnPolutFlg[i] != null)
					model.setMrnPolutFlg(mrnPolutFlg[i]);
				if (bkgOfcCd[i] != null)
					model.setBkgOfcCd(bkgOfcCd[i]);
				if (tpSz[i] != null)
					model.setTpSz(tpSz[i]);
				if (porNodCd[i] != null)
					model.setPorNodCd(porNodCd[i]);
				if (vent[i] != null)
					model.setVent(vent[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (spclCntrSeq[i] != null)
					model.setSpclCntrSeq(spclCntrSeq[i]);
				if (polNodCd[i] != null)
					model.setPolNodCd(polNodCd[i]);
				if (unNo[i] != null)
					model.setUnNo(unNo[i]);
				if (dgClass[i] != null)
					model.setDgClass(dgClass[i]);
				if (um[i] != null)
					model.setUm(um[i]);
				if (zoneCode[i] != null)
					model.setZoneCode(zoneCode[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (podNodCd[i] != null)
					model.setPodNodCd(podNodCd[i]);
				if (dgApprRef[i] != null)
					model.setDgApprRef(dgApprRef[i]);
				if (cdoTemp[i] != null)
					model.setCdoTemp(cdoTemp[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (clptIndSeq[i] != null)
					model.setClptIndSeq(clptIndSeq[i]);
				if (ng[i] != null)
					model.setNg(ng[i]);
				if (bkgStaff[i] != null)
					model.setBkgStaff(bkgStaff[i]);
				if (cntrVentTpCd[i] != null)
					model.setCntrVentTpCd(cntrVentTpCd[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getSpecialCargoSummaryReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return SpecialCargoSummaryReportVO[]
	 */
	public SpecialCargoSummaryReportVO[] getSpecialCargoSummaryReportVOs(){
		SpecialCargoSummaryReportVO[] vos = (SpecialCargoSummaryReportVO[])models.toArray(new SpecialCargoSummaryReportVO[models.size()]);
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
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkLType = this.chkLType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoSeq = this.spclCgoSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.docUsrId = this.docUsrId .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ts = this.ts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stow = this.stow .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chkTType = this.chkTType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.obSrepCd = this.obSrepCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaffType = this.bkgStaffType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.authResultT = this.authResultT .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoAproCd = this.spclCgoAproCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgt = this.wgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvdCd = this.vvdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delNodCd = this.delNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSize = this.overSize .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCgoType = this.spclCgoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnPolutFlg = this.mrnPolutFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgOfcCd = this.bkgOfcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpSz = this.tpSz .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porNodCd = this.porNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vent = this.vent .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrVentTpCd = this.cntrVentTpCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.spclCntrSeq = this.spclCntrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polNodCd = this.polNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.unNo = this.unNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgClass = this.dgClass .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.um = this.um .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.zoneCode = this.zoneCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podNodCd = this.podNodCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgApprRef = this.dgApprRef .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cdoTemp = this.cdoTemp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.clptIndSeq = this.clptIndSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ng = this.ng .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStaff = this.bkgStaff .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
