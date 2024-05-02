/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmEdiPodBookingListVO.java
*@FileTitle : CgmEdiPodBookingListVO
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.18
*@LastModifier : 두기민
*@LastVersion : 1.0
* 2016.07.18 두기민
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.vo;

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
 * @author 두기민
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class CgmEdiPodBookingListVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<CgmEdiPodBookingListVO> models = new ArrayList<CgmEdiPodBookingListVO>();
	
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String cntrTotalWgt = null;
	/* Column Info */
	private String cntrTotalWgtUnit = null;
	/* Column Info */
	private String sealNo = null;
	/* Column Info */
	private String tCnt = null;
	/* Column Info */
	private String tCntrTpszCd = null;
	/* Column Info */
	private String brac = null;
	/* Column Info */
	private String twgt = null;
	/* Column Info */
	private String bkgnbr = null;
	/* Column Info */
	private String polAmsqual = null;
	/* Column Info */
	private String blnbr = null;
	/* Column Info */
	private String rdtyp = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String skdVoy = null;
	/* Column Info */
	private String skdDir = null;
	/* Column Info */
	private String vslName = null;
	/* Column Info */
	private String vslLloyd = null;
	/* Column Info */
	private String porName = null;
	/* Column Info */
	private String porAmsqual = null;
	/* Column Info */
	private String porAmsport = null;
	/* Column Info */
	private String porUnlc = null;
	/* Column Info */
	private String porYdcd = null;
	/* Column Info */
	private String polName = null;
	/* Column Info */
	private String polAmsport = null;
	/* Column Info */
	private String polUnlc = null;
	/* Column Info */
	private String polYdcd = null;
	/* Column Info */
	private String podName = null;
	/* Column Info */
	private String podAmsqual = null;
	/* Column Info */
	private String podAmsport = null;
	/* Column Info */
	private String podUnlc = null;
	/* Column Info */
	private String podYdcd = null;
	/* Column Info */
	private String delName = null;
	/* Column Info */
	private String delAmsqual = null;
	/* Column Info */
	private String delAmsport = null;
	/* Column Info */
	private String delUnlc = null;
	/* Column Info */
	private String delYdcd = null;
	/* Column Info */
	private String twunit = null;
	/* Column Info */
	private String fmInd = null;
	/* Column Info */
	private String rfInd = null;
	/* Column Info */
	private String dgInd = null;
	/* Column Info */
	private String akInd = null;
	/* Column Info */
	private String bkInd = null;
	/* Column Info */
	private String chzExcept = null;
	/* Column Info */
	private String chzExceptDays = null;
	/* Column Info */
	private String tpszCd = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String effDt = null;
	/* Column Info */
	private String cntrNo = null;
	/* Status */
	private String ibflag = null;
	/* Column Info */
	private String ieInd = null;
	/* Column Info */
	private String finalInd = null;
	/* Column Info */
	private String bkgStsCd = null;
	/* Page Number */
	private String pagerows = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public CgmEdiPodBookingListVO() {}
    
	/**
	 * 컬럼명과 변수 매핑 
	 * @param ibflag
	 * @param pagerows
	 * @param ieInd
	 * @param finalInd
	 * @param bkgStsCd
	 * @param bkgNo
	 * @param cntrTotalWgt
	 * @param cntrTotalWgtUnit
	 * @param sealNo
	 * @param tCnt
	 * @param tCntrTpszCd
	 * @param brac
	 * @param twgt
	 * @param bkgnbr
	 * @param polAmsqual
	 * @param blnbr
	 * @param rdtyp
	 * @param vslCd
	 * @param skdVoy
	 * @param skdDir
	 * @param vslName
	 * @param vslLloyd
	 * @param porName
	 * @param porAmsqual
	 * @param porAmsport
	 * @param porUnlc
	 * @param porYdcd
	 * @param polName
	 * @param polAmsport
	 * @param polUnlc
	 * @param polYdcd
	 * @param podName
	 * @param podAmsqual
	 * @param podAmsport
	 * @param podUnlc
	 * @param podYdcd
	 * @param delName
	 * @param delAmsqual
	 * @param delAmsport
	 * @param delUnlc
	 * @param delYdcd
	 * @param twunit
	 * @param fmInd
	 * @param rfInd
	 * @param dgInd
	 * @param akInd
	 * @param bkInd
	 * @param chzExcept
	 * @param chzExceptDays
	 * @param tpszCd
	 * @param locCd
	 * @param scNo
	 * @param effDt
	 * @param cntrNo
	 */
	public CgmEdiPodBookingListVO(String ibflag, String pagerows, String ieInd, String finalInd,  String bkgStsCd, String bkgNo, String cntrTotalWgt, String cntrTotalWgtUnit, String sealNo, String tCnt, String tCntrTpszCd, String brac, String twgt, String bkgnbr, String polAmsqual,
			                    String blnbr, String rdtyp, String vslCd, String skdVoy, String skdDir, String vslName, String vslLloyd, String porName, String porAmsqual, String porAmsport, String porUnlc,
			                    String porYdcd, String polName, String polAmsport, String polUnlc, String polYdcd, String podName, String podAmsqual, String podAmsport, String podUnlc, String podYdcd, String delName, 
			                    String delAmsqual, String delAmsport, String delUnlc, String delYdcd, String twunit, String fmInd, String rfInd, String dgInd, String akInd, String bkInd, 
			                    String chzExcept, String chzExceptDays, String tpszCd, String locCd, String scNo, String effDt, String cntrNo) {
		this.bkgNo = bkgNo;
		this.cntrTotalWgt = cntrTotalWgt;
		this.cntrTotalWgtUnit = cntrTotalWgtUnit;
		this.sealNo = sealNo;
		this.tCnt = tCnt;
		this.tCntrTpszCd = tCntrTpszCd;
		this.brac = brac;
		this.twgt = twgt;
		this.bkgnbr = bkgnbr;
		this.polAmsqual = polAmsqual;
		this.blnbr = blnbr;
		this.rdtyp = rdtyp;
		this.vslCd = vslCd;
		this.skdVoy = skdVoy;
		this.skdDir = skdDir;
		this.vslName = vslName;
		this.vslLloyd = vslLloyd;
		this.porName = porName;
		this.porAmsqual = porAmsqual;
		this.porAmsport = porAmsport;
		this.porUnlc = porUnlc;
		this.porYdcd = porYdcd;
		this.polName = polName;
		this.polAmsport = polAmsport;
		this.polUnlc = polUnlc;
		this.polYdcd = polYdcd;
		this.podName = podName;
		this.podAmsqual = podAmsqual;
		this.podAmsport = podAmsport;
		this.podUnlc = podUnlc;
		this.podYdcd = podYdcd;
		this.delName = delName;
		this.delAmsqual = delAmsqual;
		this.delAmsport = delAmsport;
		this.delUnlc = delUnlc;
		this.delYdcd = delYdcd;
		this.twunit = twunit;
		this.fmInd = fmInd;
		this.rfInd = rfInd;
		this.dgInd = dgInd;
		this.akInd = akInd;
		this.bkInd = bkInd;
		this.chzExcept = chzExcept;
		this.chzExceptDays = chzExceptDays;
		this.tpszCd = tpszCd;
		this.locCd = locCd;
		this.scNo = scNo;
		this.effDt = effDt;
		this.cntrNo = cntrNo;
		this.ibflag = ibflag;
		this.ieInd = ieInd;
		this.finalInd = finalInd;
		this.bkgStsCd = bkgStsCd;
		this.pagerows = pagerows;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("cntr_total_wgt", getCntrTotalWgt());
		this.hashColumns.put("cntr_total_wgt_unit", getCntrTotalWgtUnit());
		this.hashColumns.put("seal_no", getSealNo());
		this.hashColumns.put("t_cnt", getTCnt());
		this.hashColumns.put("t_cntr_tpsz_cd", getTCntrTpszCd());
		this.hashColumns.put("bkgnbr", getBkgnbr());
		this.hashColumns.put("pol_amsqual", getPolAmsqual());
		this.hashColumns.put("blnbr", getBlnbr());
		this.hashColumns.put("rdtyp", getRdtyp());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("skd_voy", getSkdVoy());
		this.hashColumns.put("skd_dir", getSdkDir());
		this.hashColumns.put("vsl_name", getVslName());
		this.hashColumns.put("vsl_lloyd", getVslLloyd());
		this.hashColumns.put("por_name", getPorName());
		this.hashColumns.put("por_amsqual", getPorAmsqual());
		this.hashColumns.put("por_amsport", getPorAmsport());
		this.hashColumns.put("por_unlc", getPorUnlc());
		this.hashColumns.put("por_ydcd", getPorYdcd());
		this.hashColumns.put("pol_name", getPolName());
		this.hashColumns.put("pol_amsport", getPolAmsport());
		this.hashColumns.put("pol_unlc", getPolUnlc());
		this.hashColumns.put("pol_ydcd", getPolYdcd());
		this.hashColumns.put("pod_name", getPodName());
		this.hashColumns.put("pod_amsqual", getPodAmsqual());
		this.hashColumns.put("pod_amsport", getPodAmsport());
		this.hashColumns.put("pod_unlc", getPodUnlc());
		this.hashColumns.put("pod_ydcd", getPodYdcd());
		this.hashColumns.put("del_name", getDelName());
		this.hashColumns.put("del_amsqual", getDelAmsqual());
		this.hashColumns.put("del_amsport", getDelAmsport());
		this.hashColumns.put("del_unlc", getDelUnlc());
		this.hashColumns.put("del_ydcd", getDelYdcd());
		this.hashColumns.put("twunit", getTwunit());
		this.hashColumns.put("fmInd", getfmInd());
		this.hashColumns.put("rfInd", getRfInd());
		this.hashColumns.put("dgInd", getDgInd());
		this.hashColumns.put("akInd", getAkInd());
		this.hashColumns.put("bkInd", getBkInd());
		this.hashColumns.put("chz_except", getChzExcept());
		this.hashColumns.put("chz_except_days", getChzExceptDays());
		this.hashColumns.put("tpsz_cd", getTpszCd());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("eff_dt", getEffDt());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ie_ind", getIeInd());
		this.hashColumns.put("final_ind", getFinalInd());
		this.hashColumns.put("bkg_sts_cd", getBkgStsCd());
		this.hashColumns.put("pagerows", getPagerows());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("cntr_total_wgt", "cntrTotalWgt");
		this.hashFields.put("cntr_total_wgt_unit", "cntrTotalWgtUnit");
		this.hashFields.put("seal_no", "sealNo");
		this.hashFields.put("t_cnt", "tCnt");
		this.hashFields.put("t_cntr_tpsz_cd", "tCntrTpszCd");
		this.hashFields.put("brac", "brac");
		this.hashFields.put("twgt", "twgt");
		this.hashFields.put("bkgnbr", "bkgnbr");
		this.hashFields.put("pol_amsqual", "polAmsqual");
		this.hashFields.put("blnbr", "blnbr");
		this.hashFields.put("rdtyp", "rdtyp");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("skd_voy", "skdVoy");
		this.hashFields.put("skd_dir", "skdDir");
		this.hashFields.put("vsl_name", "vslName");
		this.hashFields.put("vsl_lloyd", "vslLloyd");
		this.hashFields.put("por_name", "porName");
		this.hashFields.put("por_amsqual", "porAmsqual");
		this.hashFields.put("por_amsport", "porAmsport");
		this.hashFields.put("por_unlc", "porUnlc");
		this.hashFields.put("por_ydcd", "porYdcd");
		this.hashFields.put("pol_name", "polName");
		this.hashFields.put("pol_amsport", "polAmsport");
		this.hashFields.put("pol_unlc", "polUnlc");
		this.hashFields.put("pol_ydcd", "polYdcd");
		this.hashFields.put("pod_name", "podName");
		this.hashFields.put("pod_amsqual", "podAmsqual");
		this.hashFields.put("pod_amsport", "podAmsport");
		this.hashFields.put("pod_unlc", "podUnlc");
		this.hashFields.put("pod_ydcd", "podYdcd");
		this.hashFields.put("del_name", "delName");
		this.hashFields.put("del_amsqual", "delAmsqual");
		this.hashFields.put("del_amsport", "delAmsport");
		this.hashFields.put("del_unlc", "delUnlc");
		this.hashFields.put("del_ydcd", "delYdcd");
		this.hashFields.put("twunit", "twunit");
		this.hashFields.put("fm_ind", "fmInd");
		this.hashFields.put("rf_ind", "rfInd");
		this.hashFields.put("dg_ind", "dgInd");
		this.hashFields.put("ak_ind", "akInd");
		this.hashFields.put("bk_ind", "bkInd");
		this.hashFields.put("chz_except", "chzExcept");
		this.hashFields.put("chz_except_days", "chzExceptDays");
		this.hashFields.put("tpsz_cd", "tpszCd");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("eff_dt", "effDt");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ie_ind", "ieInd");
		this.hashFields.put("final_ind", "finalInd");
		this.hashFields.put("bkg_sts_cd", "bkgStsCd");
		this.hashFields.put("pagerows", "pagerows");
		return this.hashFields;
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
	 * @return cntrTotalWgt
	 */
	public String getCntrTotalWgt() {
		return this.cntrTotalWgt;
	}
	
	/**
	 * Column Info
	 * @return cntrTotalWgtUnit
	 */
	public String getCntrTotalWgtUnit() {
		return this.cntrTotalWgtUnit;
	}
	
	/**
	 * Column Info
	 * @return sealNo
	 */
	public String getSealNo() {
		return this.sealNo;
	}
	
	/**
	 * Column Info
	 * @return tCnt
	 */
	public String getTCnt() {
		return this.tCnt;
	}
	
	/**
	 * Column Info
	 * @return tCntrTpszCd
	 */
	public String getTCntrTpszCd() {
		return this.tCntrTpszCd;
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
	 * @return twgt
	 */
	public String getTwgt() {
		return this.twgt;
	}
	
	/**
	 * Column Info
	 * @return bkgnbr
	 */
	public String getBkgnbr() {
		return this.bkgnbr;
	}
	
	/**
	 * Column Info
	 * @return polAmsqual
	 */
	public String getPolAmsqual() {
		return this.polAmsqual;
	}
	
	/**
	 * Column Info
	 * @return blnbr
	 */
	public String getBlnbr() {
		return this.blnbr;
	}
	
	/**
	 * Column Info
	 * @return rdtyp
	 */
	public String getRdtyp() {
		return this.rdtyp;
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
	 * @return skdVoy
	 */
	public String getSkdVoy() {
		return this.skdVoy;
	}
	
	/**
	 * Column Info
	 * @return skdDir
	 */
	public String getSdkDir() {
		return this.skdDir;
	}
	
	/**
	 * Column Info
	 * @return vslName
	 */
	public String getVslName() {
		return this.vslName;
	}
	
	/**
	 * Column Info
	 * @return vslLloyd
	 */
	public String getVslLloyd() {
		return this.vslLloyd;
	}
	
	/**
	 * Column Info
	 * @return porName
	 */
	public String getPorName() {
		return this.porName;
	}
	
	/**
	 * Column Info
	 * @return porAmsqual
	 */
	public String getPorAmsqual() {
		return this.porAmsqual;
	}
	
	/**
	 * Column Info
	 * @return porAmsport
	 */
	public String getPorAmsport() {
		return this.porAmsport;
	}
	
	/**
	 * Column Info
	 * @return porUnlc
	 */
	public String getPorUnlc() {
		return this.porUnlc;
	}
	
	/**
	 * Column Info
	 * @return porYdcd
	 */
	public String getPorYdcd() {
		return this.porYdcd;
	}
	
	/**
	 * Column Info
	 * @return polName
	 */
	public String getPolName() {
		return this.polName;
	}
	
	/**
	 * Column Info
	 * @return polAmsport
	 */
	public String getPolAmsport() {
		return this.polAmsport;
	}
	
	/**
	 * Column Info
	 * @return polUnlc
	 */
	public String getPolUnlc() {
		return this.polUnlc;
	}
	
	/**
	 * Column Info
	 * @return polYdcd
	 */
	public String getPolYdcd() {
		return this.polYdcd;
	}
	
	/**
	 * Column Info
	 * @return podName
	 */
	public String getPodName() {
		return this.podName;
	}
	
	/**
	 * Column Info
	 * @return podAmsqual
	 */
	public String getPodAmsqual() {
		return this.podAmsqual;
	}
	
	/**
	 * Column Info
	 * @return podAmsport
	 */
	public String getPodAmsport() {
		return this.podAmsport;
	}
	
	/**
	 * Column Info
	 * @return podUnlc
	 */
	public String getPodUnlc() {
		return this.podUnlc;
	}
	
	/**
	 * Column Info
	 * @return podYdcd
	 */
	public String getPodYdcd() {
		return this.podYdcd;
	}
	
	/**
	 * Column Info
	 * @return delName
	 */
	public String getDelName() {
		return this.delName;
	}
	
	/**
	 * Column Info
	 * @return delAmsqual
	 */
	public String getDelAmsqual() {
		return this.delAmsqual;
	}
	
	/**
	 * Column Info
	 * @return delAmsport
	 */
	public String getDelAmsport() {
		return this.delAmsport;
	}
	
	/**
	 * Column Info
	 * @return delUnlc
	 */
	public String getDelUnlc() {
		return this.delUnlc;
	}
	
	/**
	 * Column Info
	 * @return delYdcd
	 */
	public String getDelYdcd() {
		return this.delYdcd;
	}	
	
	/**
	 * Column Info
	 * @return twunit
	 */
	public String getTwunit() {
		return this.twunit;
	}
	
	/**
	 * Column Info
	 * @return fmInd
	 */
	public String getfmInd() {
		return this.fmInd;
	}
	
	/**
	 * Column Info
	 * @return rfInd
	 */
	public String getRfInd() {
		return this.rfInd;
	}
	
	/**
	 * Column Info
	 * @return dgInd
	 */
	public String getDgInd() {
		return this.dgInd;
	}
	
	/**
	 * Column Info
	 * @return akInd
	 */
	public String getAkInd() {
		return this.akInd;
	}
	
	/**
	 * Column Info
	 * @return bkInd
	 */
	public String getBkInd() {
		return this.bkInd;
	}
	
	/**
	 * Column Info
	 * @return chzExcept
	 */
	public String getChzExcept() {
		return this.chzExcept;
	}
	
	/**
	 * Column Info
	 * @return chzExceptDays
	 */
	public String getChzExceptDays() {
		return this.chzExceptDays;
	}
	
	/**
	 * Column Info
	 * @return tpszCd
	 */
	public String getTpszCd() {
		return this.tpszCd;
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
	 * @return scNo
	 */
	public String getScNo() {
		return this.scNo;
	}
	
	/**
	 * Column Info
	 * @return effDt
	 */
	public String getEffDt() {
		return this.effDt;
	}
	
	/**
	 * Column Info
	 * @return cntrNo
	 */
	public String getCntrNo() {
		return this.cntrNo;
	}
	
	/**
	 * Status
	 * @return ibflag
	 */
	public String getIbflag() {
		return this.ibflag;
	}
	
	/**
	 * Column Info
	 * @return ieInd
	 */
	public String getIeInd() {
		return this.ieInd;
	}
	
	/**
	 * Column Info
	 * @return finalInd
	 */
	public String getFinalInd() {
		return this.finalInd;
	}
	
	/**
	 * Column Info
	 * @return bkgStsCd
	 */
	public String getBkgStsCd() {
		return this.bkgStsCd;
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
	 * @param bkgNo
	 */
	public void setBkgNo(String bkgNo) {
		this.bkgNo = bkgNo;
	}
	
	/**
	 * Column Info
	 * @param cntrTotalWgt
	 */
	public void setCntrTotalWgt(String cntrTotalWgt) {
		this.cntrTotalWgt = cntrTotalWgt;
	}
	
	/**
	 * Column Info
	 * @param cntrTotalWgtUnit
	 */
	public void setCntrTotalWgtUnit(String cntrTotalWgtUnit) {
		this.cntrTotalWgtUnit = cntrTotalWgtUnit;
	}
	
	/**
	 * Column Info
	 * @param sealNo
	 */
	public void setSealNo(String sealNo) {
		this.sealNo = sealNo;
	}
	
	/**
	 * Column Info
	 * @param tCnt
	 */
	public void setTCnt(String tCnt) {
		this.tCnt = tCnt;
	}
	
	/**
	 * Column Info
	 * @param tCntrTpszCd
	 */
	public void setTCntrTpszCd(String tCntrTpszCd) {
		this.tCntrTpszCd = tCntrTpszCd;
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
	 * @param twgt
	 */
	public void setTwgt(String twgt) {
		this.twgt = twgt;
	}
	
	/**
	 * Column Info
	 * @param bkgnbr
	 */
	public void setBkgnbr(String bkgnbr) {
		this.bkgnbr = bkgnbr;
	}
	
	/**
	 * Column Info
	 * @param polAmsqual
	 */
	public void setPolAmsqual(String polAmsqual) {
		this.polAmsqual = polAmsqual;
	}
	
	/**
	 * Column Info
	 * @param blnbr
	 */
	public void setBlnbr(String blnbr) {
		this.blnbr = blnbr;
	}
	
	/**
	 * Column Info
	 * @param rdtyp
	 */
	public void setRdtyp(String rdtyp) {
		this.rdtyp = rdtyp;
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
	 * @param skdVoy
	 */
	public void setSkdVoy(String skdVoy) {
		this.skdVoy = skdVoy;
	}
	
	/**
	 * Column Info
	 * @param skdDir
	 */
	public void setSdkDir(String skdDir) {
		this.skdDir = skdDir;
	}
	
	/**
	 * Column Info
	 * @param vslName
	 */
	public void setVslName(String vslName) {
		this.vslName = vslName;
	}
	
	/**
	 * Column Info
	 * @param vslLloyd
	 */
	public void setVslLloyd(String vslLloyd) {
		this.vslLloyd = vslLloyd;
	}
	
	/**
	 * Column Info
	 * @param porName
	 */
	public void setPorName(String porName) {
		this.porName = porName;
	}
	
	/**
	 * Column Info
	 * @param porAmsqual
	 */
	public void setPorAmsqual(String porAmsqual) {
		this.porAmsqual = porAmsqual;
	}
	
	/**
	 * Column Info
	 * @param porAmsport
	 */
	public void setPorAmsport(String porAmsport) {
		this.porAmsport = porAmsport;
	}
	
	/**
	 * Column Info
	 * @param porUnlc
	 */
	public void setPorUnlc(String porUnlc) {
		this.porUnlc = porUnlc;
	}
	
	/**
	 * Column Info
	 * @param porYdcd
	 */
	public void setPorYdcd(String porYdcd) {
		this.porYdcd = porYdcd;
	}
	
	/**
	 * Column Info
	 * @param polName
	 */
	public void setPolName(String polName) {
		this.polName = polName;
	}
	
	/**
	 * Column Info
	 * @param polAmsport
	 */
	public void setPolAmsport(String polAmsport) {
		this.polAmsport = polAmsport;
	}
	
	/**
	 * Column Info
	 * @param polUnlc
	 */
	public void setPolUnlc(String polUnlc) {
		this.polUnlc = polUnlc;
	}
	
	/**
	 * Column Info
	 * @param polYdcd
	 */
	public void setPolYdcd(String polYdcd) {
		this.polYdcd = polYdcd;
	}
	
	/**
	 * Column Info
	 * @param podName
	 */
	public void setPodName(String podName) {
		this.podName = podName;
	}
	
	/**
	 * Column Info
	 * @param podAmsqual
	 */
	public void setPodAmsqual(String podAmsqual) {
		this.podAmsqual = podAmsqual;
	}
	
	/**
	 * Column Info
	 * @param podAmsport
	 */
	public void setPodAmsport(String podAmsport) {
		this.podAmsport = podAmsport;
	}
	
	/**
	 * Column Info
	 * @param podUnlc
	 */
	public void setPodUnlc(String podUnlc) {
		this.podUnlc = podUnlc;
	}
	
	/**
	 * Column Info
	 * @param podYdcd
	 */
	public void setPodYdcd(String podYdcd) {
		this.podYdcd = podYdcd;
	}
	
	/**
	 * Column Info
	 * @param delName
	 */
	public void setDelName(String delName) {
		this.delName = delName;
	}
	
	/**
	 * Column Info
	 * @param delAmsqual
	 */
	public void setDelAmsqual(String delAmsqual) {
		this.delAmsqual = delAmsqual;
	}
	
	/**
	 * Column Info
	 * @param delAmsport
	 */
	public void setDelAmsport(String delAmsport) {
		this.delAmsport = delAmsport;
	}
	
	/**
	 * Column Info
	 * @param delUnlc
	 */
	public void setDelUnlc(String delUnlc) {
		this.delUnlc = delUnlc;
	}
	
	/**
	 * Column Info
	 * @param delYdcd
	 */
	public void setDelYdcd(String delYdcd) {
		this.delYdcd = delYdcd;
	}
	
	/**
	 * Column Info
	 * @param twunit
	 */
	public void setTwunit(String twunit) {
		this.twunit = twunit;
	}
	
	/**
	 * Column Info
	 * @param fmInd
	 */
	public void setfmInd(String fmInd) {
		this.fmInd = fmInd;
	}
	
	/**
	 * Column Info
	 * @param rfInd
	 */
	public void setRfInd(String rfInd) {
		this.rfInd = rfInd;
	}
	
	/**
	 * Column Info
	 * @param dgInd
	 */
	public void setDgInd(String dgInd) {
		this.dgInd = dgInd;
	}
	
	/**
	 * Column Info
	 * @param akInd
	 */
	public void setAkInd(String akInd) {
		this.akInd = akInd;
	}
	
	/**
	 * Column Info
	 * @param bkInd
	 */
	public void setBkInd(String bkInd) {
		this.bkInd = bkInd;
	}
	
	/**
	 * Column Info
	 * @param chzExcept
	 */
	public void setChzExcept(String chzExcept) {
		this.chzExcept = chzExcept;
	}
	
	/**
	 * Column Info
	 * @param chzExceptDays
	 */
	public void setChzExceptDays(String chzExceptDays) {
		this.chzExceptDays = chzExceptDays;
	}
	
	/**
	 * Column Info
	 * @param tpszCd
	 */
	public void setTpszCd(String tpszCd) {
		this.tpszCd = tpszCd;
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
	 * @param scNo
	 */
	public void setScNo(String scNo) {
		this.scNo = scNo;
	}
	
	/**
	 * Column Info
	 * @param effDt
	 */
	public void setEffDt(String effDt) {
		this.effDt = effDt;
	}
	
	/**
	 * Column Info
	 * @param cntrNo
	 */
	public void setCntrNo(String cntrNo) {
		this.cntrNo = cntrNo;
	}
	
	/**
	 * Status
	 * @param ibflag
	 */
	public void setIbflag(String ibflag) {
		this.ibflag = ibflag;
	}
	
	/**
	 * Column Info
	 * @param ieInd
	 */
	public void setIeInd(String ieInd) {
		this.ieInd = ieInd;
	}
	
	/**
	 * Column Info
	 * @param finalInd
	 */
	public void setFinalInd(String finalInd) {
		this.finalInd = finalInd;
	}
	
	/**
	 * Column Info
	 * @param bkgStsCd
	 */
	public void setBkgStsCd(String bkgStsCd) {
		this.bkgStsCd = bkgStsCd;
	}
	
	/**
	 * Page Number
	 * @param pagerows
	 */
	public void setPagerows(String pagerows) {
		this.pagerows = pagerows;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
		setCntrTotalWgt(JSPUtil.getParameter(request, "cntr_total_wgt", ""));
		setCntrTotalWgtUnit(JSPUtil.getParameter(request, "cntr_total_wgt_unit", ""));
		setSealNo(JSPUtil.getParameter(request, "seal_no", ""));
		setTCnt(JSPUtil.getParameter(request, "t_cnt", ""));
		setTCntrTpszCd(JSPUtil.getParameter(request, "t_cntr_tpsz_cd", ""));
		setBrac(JSPUtil.getParameter(request, "brac", ""));
		setTwgt(JSPUtil.getParameter(request, "twgt", ""));
		setBkgnbr(JSPUtil.getParameter(request, "bkgnbr", ""));
		setPolAmsqual(JSPUtil.getParameter(request, "pol_amsqual", ""));
		setBlnbr(JSPUtil.getParameter(request, "blnbr", ""));
		setRdtyp(JSPUtil.getParameter(request, "rdtyp", ""));
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setSkdVoy(JSPUtil.getParameter(request, "skd_voy", ""));
		setSdkDir(JSPUtil.getParameter(request, "skd_dir", ""));
		setVslName(JSPUtil.getParameter(request, "vsl_name", ""));
		setVslLloyd(JSPUtil.getParameter(request, "vsl_lloyd", ""));
		setPorName(JSPUtil.getParameter(request, "por_name", ""));
		setPorAmsqual(JSPUtil.getParameter(request, "por_amsqual", ""));
		setPorAmsport(JSPUtil.getParameter(request, "por_amsport", ""));
		setPorUnlc(JSPUtil.getParameter(request, "por_unlc", ""));
		setPorYdcd(JSPUtil.getParameter(request, "por_ydcd", ""));
		setPolName(JSPUtil.getParameter(request, "pol_name", ""));
		setPolAmsport(JSPUtil.getParameter(request, "pol_amsport", ""));
		setPolYdcd(JSPUtil.getParameter(request, "pol_unlc", ""));
		setPodName(JSPUtil.getParameter(request, "pol_ydcd", ""));
		setPodAmsqual(JSPUtil.getParameter(request, "pod_name", ""));
		setPodAmsport(JSPUtil.getParameter(request, "pod_amsqual", ""));
		setPodUnlc(JSPUtil.getParameter(request, "pod_amsport", ""));
		setPodYdcd(JSPUtil.getParameter(request, "pod_unlc", ""));
		setDelName(JSPUtil.getParameter(request, "pod_ydcd", ""));
		setDelAmsqual(JSPUtil.getParameter(request, "del_name", ""));
		setDelAmsport(JSPUtil.getParameter(request, "del_amsqual", ""));
		setDelUnlc(JSPUtil.getParameter(request, "del_amsport", ""));
		setDelYdcd(JSPUtil.getParameter(request, "del_unlc", ""));
		setTwunit(JSPUtil.getParameter(request, "twunit", ""));
		setfmInd(JSPUtil.getParameter(request, "fm_ind", ""));
		setPorUnlc(JSPUtil.getParameter(request, "por_unlc", ""));
		setRfInd(JSPUtil.getParameter(request, "rf_ind", ""));
		setDgInd(JSPUtil.getParameter(request, "dg_ind", ""));
		setAkInd(JSPUtil.getParameter(request, "ak_ind", ""));
		setBkInd(JSPUtil.getParameter(request, "bk_ind", ""));
		setChzExcept(JSPUtil.getParameter(request, "chz_except", ""));
		setChzExceptDays(JSPUtil.getParameter(request, "chz_except_days", ""));
		setTpszCd(JSPUtil.getParameter(request, "tpsz_cd", ""));
		setLocCd(JSPUtil.getParameter(request, "loc_cd", ""));
		setScNo(JSPUtil.getParameter(request, "sc_no", ""));
		setEffDt(JSPUtil.getParameter(request, "eff_dt", ""));
		setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setIeInd(JSPUtil.getParameter(request, "ie_ind", ""));
		setFinalInd(JSPUtil.getParameter(request, "final_ind", ""));
		setBkgStsCd(JSPUtil.getParameter(request, "bkg_sts_cd", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return CgmEdiPodBookingListVO[]
	 */
	public CgmEdiPodBookingListVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return CgmEdiPodBookingListVO[]
	 */
	public CgmEdiPodBookingListVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		CgmEdiPodBookingListVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no".trim(), length));
			String[] cntrTotalWgt = (JSPUtil.getParameter(request, prefix	+ "cntr_total_wgt".trim(), length));
			String[] cntrTotalWgtUnit = (JSPUtil.getParameter(request, prefix	+ "cntr_total_wgt_unit".trim(), length));
			String[] sealNo = (JSPUtil.getParameter(request, prefix	+ "seal_no".trim(), length));
			String[] tCnt = (JSPUtil.getParameter(request, prefix	+ "t_cnt".trim(), length));
			String[] tCntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "t_cntr_tpsz_cd".trim(), length));
			String[] brac = (JSPUtil.getParameter(request, prefix	+ "brac".trim(), length));
			String[] twgt = (JSPUtil.getParameter(request, prefix	+ "twgt".trim(), length));
			String[] bkgnbr = (JSPUtil.getParameter(request, prefix	+ "bkgnbr".trim(), length));
			String[] polAmsqual = (JSPUtil.getParameter(request, prefix	+ "pol_amsqual".trim(), length));
			String[] blnbr = (JSPUtil.getParameter(request, prefix	+ "blnbr".trim(), length));
			String[] rdtyp = (JSPUtil.getParameter(request, prefix	+ "rdtyp".trim(), length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd".trim(), length));
			String[] skdVoy = (JSPUtil.getParameter(request, prefix	+ "skd_voy".trim(), length));
			String[] skdDir = (JSPUtil.getParameter(request, prefix	+ "skd_dir".trim(), length));
			String[] vslName = (JSPUtil.getParameter(request, prefix	+ "vsl_name".trim(), length));
			String[] vslLloyd = (JSPUtil.getParameter(request, prefix	+ "vsl_lloyd".trim(), length));
			String[] porName = (JSPUtil.getParameter(request, prefix	+ "por_name".trim(), length));
			String[] porAmsqual = (JSPUtil.getParameter(request, prefix	+ "por_amsqual".trim(), length));
			String[] porAmsport = (JSPUtil.getParameter(request, prefix	+ "por_amsport".trim(), length));
			String[] porUnlc = (JSPUtil.getParameter(request, prefix	+ "por_unlc".trim(), length));
			String[] porYdcd = (JSPUtil.getParameter(request, prefix	+ "por_ydcd".trim(), length));
			String[] polName = (JSPUtil.getParameter(request, prefix	+ "pol_name".trim(), length));
			String[] polAmsport = (JSPUtil.getParameter(request, prefix	+ "pol_amsport".trim(), length));
			String[] polUnlc = (JSPUtil.getParameter(request, prefix	+ "pol_unlc".trim(), length));
			String[] polYdcd = (JSPUtil.getParameter(request, prefix	+ "pol_ydcd".trim(), length));
			String[] podName = (JSPUtil.getParameter(request, prefix	+ "pod_name".trim(), length));
			String[] podAmsqual = (JSPUtil.getParameter(request, prefix	+ "pod_amsqual".trim(), length));
			String[] podAmsport = (JSPUtil.getParameter(request, prefix	+ "pod_amsport".trim(), length));
			String[] podUnlc = (JSPUtil.getParameter(request, prefix	+ "pod_unlc".trim(), length));
			String[] podYdcd = (JSPUtil.getParameter(request, prefix	+ "pod_ydcd".trim(), length));
			String[] delName = (JSPUtil.getParameter(request, prefix	+ "del_name".trim(), length));
			String[] delAmsqual = (JSPUtil.getParameter(request, prefix	+ "del_amsqual".trim(), length));
			String[] delAmsport = (JSPUtil.getParameter(request, prefix	+ "del_amsport".trim(), length));
			String[] delUnlc = (JSPUtil.getParameter(request, prefix	+ "del_unlc".trim(), length));
			String[] delYdcd = (JSPUtil.getParameter(request, prefix	+ "por_unlc".trim(), length));
			String[] twunit = (JSPUtil.getParameter(request, prefix	+ "twunit".trim(), length));
			String[] fmInd = (JSPUtil.getParameter(request, prefix	+ "fm_ind".trim(), length));
			String[] rfInd = (JSPUtil.getParameter(request, prefix	+ "rf_ind".trim(), length));
			String[] dgInd = (JSPUtil.getParameter(request, prefix	+ "dg_ind".trim(), length));
			String[] akInd = (JSPUtil.getParameter(request, prefix	+ "ak_ind".trim(), length));
			String[] bkInd = (JSPUtil.getParameter(request, prefix	+ "bk_ind".trim(), length));
			String[] chzExcept = (JSPUtil.getParameter(request, prefix	+ "chz_except".trim(), length));
			String[] chzExceptDays = (JSPUtil.getParameter(request, prefix	+ "chz_except_days".trim(), length));
			String[] tpszCd = (JSPUtil.getParameter(request, prefix	+ "tpsz_cd".trim(), length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd".trim(), length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no".trim(), length));
			String[] effDt = (JSPUtil.getParameter(request, prefix	+ "eff_dt".trim(), length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no".trim(), length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag".trim(), length));
			String[] ieInd = (JSPUtil.getParameter(request, prefix	+ "ie_ind".trim(), length));
			String[] finalInd = (JSPUtil.getParameter(request, prefix	+ "final_ind".trim(), length));
			String[] bkgStsCd = (JSPUtil.getParameter(request, prefix	+ "bkg_sts_cd".trim(), length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows".trim(), length));
			
			for (int i = 0; i < length; i++) {
				model = new CgmEdiPodBookingListVO();
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (cntrTotalWgt[i] != null)
					model.setCntrTotalWgt(cntrTotalWgt[i]);
				if (cntrTotalWgtUnit[i] != null)
					model.setCntrTotalWgtUnit(cntrTotalWgtUnit[i]);
				if (sealNo[i] != null)
					model.setSealNo(sealNo[i]);
				if (tCnt[i] != null)
					model.setTCnt(tCnt[i]);
				if (tCntrTpszCd[i] != null)
					model.setTCntrTpszCd(tCntrTpszCd[i]);
				if (brac[i] != null)
					model.setBrac(brac[i]);
				if (twgt[i] != null)
					model.setTwgt(twgt[i]);
				if (bkgnbr[i] != null)
					model.setBkgnbr(bkgnbr[i]);
				if (polAmsqual[i] != null)
					model.setPolAmsqual(polAmsqual[i]);
				if (blnbr[i] != null)
					model.setBlnbr(blnbr[i]);
				if (rdtyp[i] != null)
					model.setRdtyp(rdtyp[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (skdVoy[i] != null)
					model.setSkdVoy(skdVoy[i]);
				if (skdDir[i] != null)
					model.setSdkDir(skdDir[i]);
				if (vslName[i] != null)
					model.setVslName(vslName[i]);
				if (vslLloyd[i] != null)
					model.setVslLloyd(vslLloyd[i]);
				if (porName[i] != null)
					model.setPorName(porName[i]);
				if (porAmsqual[i] != null)
					model.setPorAmsqual(porAmsqual[i]);
				if (porAmsport[i] != null)
					model.setPorAmsport(porAmsport[i]);
				if (porUnlc[i] != null)
					model.setPorUnlc(porUnlc[i]);				
				if (porYdcd[i] != null)
					model.setPorYdcd(porYdcd[i]);
				if (polName[i] != null)
					model.setPolAmsport(polName[i]);
				if (polAmsport[i] != null)
					model.setPolAmsport(polAmsport[i]);
				if (polUnlc[i] != null)
					model.setPolUnlc(polUnlc[i]);
				if (polYdcd[i] != null)
					model.setPolYdcd(polYdcd[i]);
				if (podName[i] != null)
					model.setPodName(podName[i]);
				if (podAmsqual[i] != null)
					model.setPodAmsqual(podAmsqual[i]);
				if (podAmsport[i] != null)
					model.setPodAmsport(podAmsport[i]);
				if (podUnlc[i] != null)
					model.setPodUnlc(podUnlc[i]);
				if (podYdcd[i] != null)
					model.setPodYdcd(podYdcd[i]);
				if (delName[i] != null)
					model.setDelName(delName[i]);
				if (delAmsqual[i] != null)
					model.setDelAmsqual(delAmsqual[i]);
				if (delAmsport[i] != null)
					model.setDelAmsport(delAmsport[i]);
				if (delUnlc[i] != null)
					model.setDelUnlc(delUnlc[i]);
				if (delYdcd[i] != null)
					model.setDelYdcd(delYdcd[i]);
				if (twunit[i] != null)
					model.setTwunit(twunit[i]);
				if (fmInd[i] != null)
					model.setfmInd(fmInd[i]);
				if (rfInd[i] != null)
					model.setRfInd(rfInd[i]);
				if (dgInd[i] != null)
					model.setDgInd(dgInd[i]);
				if (akInd[i] != null)
					model.setAkInd(akInd[i]);
				if (bkInd[i] != null)
					model.setBkInd(bkInd[i]);				
				if (chzExcept[i] != null)
					model.setChzExcept(chzExcept[i]);
				if (chzExceptDays[i] != null)
					model.setChzExceptDays(chzExceptDays[i]);
				if (tpszCd[i] != null)
					model.setTpszCd(tpszCd[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (effDt[i] != null)
					model.setEffDt(effDt[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ieInd[i] != null)
					model.setIeInd(ieInd[i]);
				if (finalInd[i] != null)
					model.setFinalInd(finalInd[i]);
				if (bkgStsCd[i] != null)
					model.setBkgStsCd(bkgStsCd[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getCgmEdiPodBookingListVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return CgmEdiPodBookingListVO[]
	 */
	public CgmEdiPodBookingListVO[] getCgmEdiPodBookingListVOs(){
		CgmEdiPodBookingListVO[] vos = (CgmEdiPodBookingListVO[])models.toArray(new CgmEdiPodBookingListVO[models.size()]);
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
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTotalWgt = this.cntrTotalWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTotalWgtUnit = this.cntrTotalWgtUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sealNo = this.sealNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCnt = this.tCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tCntrTpszCd = this.tCntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.brac = this.brac .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twgt = this.twgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgnbr = this.bkgnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAmsqual = this.polAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blnbr = this.blnbr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rdtyp = this.rdtyp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoy = this.skdVoy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDir = this.skdDir .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslName = this.vslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslLloyd = this.vslLloyd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porName = this.porName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAmsqual = this.porAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porAmsport = this.porAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porUnlc = this.porUnlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porYdcd = this.porYdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polName = this.polName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polAmsport = this.polAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polUnlc = this.polUnlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polYdcd = this.polYdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podName = this.podName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAmsqual = this.podAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podAmsport = this.podAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podUnlc = this.podUnlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podYdcd = this.podYdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delName = this.delName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAmsqual = this.delAmsqual .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delAmsport = this.delAmsport .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delUnlc = this.delUnlc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delYdcd = this.delYdcd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.twunit = this.twunit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fmInd = this.fmInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfInd = this.rfInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgInd = this.dgInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akInd = this.akInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkInd = this.bkInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chzExcept = this.chzExcept .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.chzExceptDays = this.chzExceptDays .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tpszCd = this.tpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.effDt = this.effDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ieInd = this.ieInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.finalInd = this.finalInd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgStsCd = this.bkgStsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
