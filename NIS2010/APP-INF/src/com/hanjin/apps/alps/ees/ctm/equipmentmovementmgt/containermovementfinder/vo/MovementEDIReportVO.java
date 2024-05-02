/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : MovementEDIReportVO.java
*@FileTitle : MovementEDIReportVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.18
*@LastModifier : 나상보
*@LastVersion : 1.0
* 2010.08.18 나상보
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.08.18 나상보 [CHM-201005413-01] MVNT timely update ratio 기능보완
*                   : [EES_CTM_0418] 1. LCC 선택시 Yard 단위로 Download 가능 하도록 처리
*						             2. 검색 조건 추가 (mvmt status 멀티 선택 가능)
* 2010.09.09 김상수 [CHM-201006478-01] Full/Mty Option기능 추가 (Movement 적시 update 비율 및 row data를 조회하는 화면)
*                   1.Movement 적시 update 비율 및 row data를 조회하는 화면에 Full/Mty Option기능 추가
*                     ->Service Management > CNTR Movement > Monitoring > MVMT Timely Update Ratio
*                   2. Default 값은 All 로 하고, 필요시 Full 혹은 Mty별 조회 기능 추가
=========================================================*/

package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo;

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
 * @author 김상수
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class MovementEDIReportVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;

	private Collection<MovementEDIReportVO> models = new ArrayList<MovementEDIReportVO>();

	/* Column Info */
	private String per48 = null;
	/* Column Info */
	private String oper48 = null;
	/* Column Info */
	private String intType = null;
	/* Column Info */
	private String mtot = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String stsCd = null;
	/* Column Info */
	private String eoff12 = null;
	/* Column Info */
	private String ovr48 = null;
	/* Column Info */
	private String locCd = null;
	/* Column Info */
	private String pDate1 = null;
	/* Column Info */
	private String pDate2 = null;
	/* Column Info */
	private String soper48 = null;
	/* Column Info */
	private String cntCd = null;
	/* Column Info */
	private String soff24 = null;
	/* Column Info */
	private String dataBy = null;
	/* Column Info */
	private String moff24 = null;
	/* Column Info */
	private String eper24 = null;
	/* Column Info */
	private String sper24 = null;
	/* Column Info */
	private String eoff24 = null;
	/* Column Info */
	private String pYard2 = null;
	/* Column Info */
	private String moff12 = null;
	/* Column Info */
	private String pYard1 = null;
	/* Column Info */
	private String mper24 = null;
	/* Column Info */
	private String gap = null;
	/* Column Info */
	private String eper48 = null;
	/* Column Info */
	private String stot = null;
	/* Column Info */
	private String moper48 = null;
	/* Column Info */
	private String fcntrFlg = null;
	/* Column Info */
	private String eoper48 = null;
	/* Column Info */
	private String off24 = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String tot = null;
	/* Column Info */
	private String mper12 = null;
	/* Column Info */
	private String sper48 = null;
	/* Column Info */
	private String moff48 = null;
	/* Column Info */
	private String soff48 = null;
	/* Column Info */
	private String domFlg = null;
	/* Column Info */
	private String per12 = null;
	/* Column Info */
	private String rccCd = null;
	/* Column Info */
	private String off12 = null;
	/* Column Info */
	private String orgYdCd = null;
	/* Column Info */
	private String sovr48 = null;
	/* Column Info */
	private String movr48 = null;
	/* Column Info */
	private String lccCd = null;
	/* Column Info */
	private String eoff48 = null;
	/* Column Info */
	private String eovr48 = null;
	/* Column Info */
	private String sper12 = null;
	/* Column Info */
	private String eper12 = null;
	/* Column Info */
	private String per24 = null;
	/* Column Info */
	private String mper48 = null;
	/* Column Info */
	private String soff12 = null;
	/* Column Info */
	private String etot = null;
	/* Column Info */
	private String off48 = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();

	public MovementEDIReportVO() {}

	public MovementEDIReportVO(String ibflag, String pagerows, String cntCd, String dataBy, String domFlg, String eoff12, String eoff24, String eoff48, String eoper48, String eovr48, String eper12, String eper24, String eper48, String fcntrFlg, String etot, String gap, String intType, String lccCd, String locCd, String moff12, String moff24, String moff48, String moper48, String movr48, String mper12, String mper24, String mper48, String mtot, String off12, String off24, String off48, String oper48, String orgYdCd, String ovr48, String pDate1, String pDate2, String pYard1, String pYard2, String per12, String per24, String per48, String rccCd, String soff12, String soff24, String soff48, String soper48, String sovr48, String sper12, String sper24, String sper48, String stot, String stsCd, String tot) {
		this.per48 = per48;
		this.oper48 = oper48;
		this.intType = intType;
		this.mtot = mtot;
		this.pagerows = pagerows;
		this.stsCd = stsCd;
		this.eoff12 = eoff12;
		this.ovr48 = ovr48;
		this.locCd = locCd;
		this.pDate1 = pDate1;
		this.pDate2 = pDate2;
		this.soper48 = soper48;
		this.cntCd = cntCd;
		this.soff24 = soff24;
		this.dataBy = dataBy;
		this.moff24 = moff24;
		this.eper24 = eper24;
		this.sper24 = sper24;
		this.eoff24 = eoff24;
		this.pYard2 = pYard2;
		this.moff12 = moff12;
		this.pYard1 = pYard1;
		this.mper24 = mper24;
		this.gap = gap;
		this.eper48 = eper48;
		this.stot = stot;
		this.moper48 = moper48;
		this.fcntrFlg = fcntrFlg;
		this.eoper48 = eoper48;
		this.off24 = off24;
		this.ibflag = ibflag;
		this.tot = tot;
		this.mper12 = mper12;
		this.sper48 = sper48;
		this.moff48 = moff48;
		this.soff48 = soff48;
		this.domFlg = domFlg;
		this.per12 = per12;
		this.rccCd = rccCd;
		this.off12 = off12;
		this.orgYdCd = orgYdCd;
		this.sovr48 = sovr48;
		this.movr48 = movr48;
		this.lccCd = lccCd;
		this.eoff48 = eoff48;
		this.eovr48 = eovr48;
		this.sper12 = sper12;
		this.eper12 = eper12;
		this.per24 = per24;
		this.mper48 = mper48;
		this.soff12 = soff12;
		this.etot = etot;
		this.off48 = off48;
	}

	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("per_48", getPer48());
		this.hashColumns.put("oper_48", getOper48());
		this.hashColumns.put("int_type", getIntType());
		this.hashColumns.put("mtot", getMtot());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("sts_cd", getStsCd());
		this.hashColumns.put("eoff_12", getEoff12());
		this.hashColumns.put("ovr_48", getOvr48());
		this.hashColumns.put("loc_cd", getLocCd());
		this.hashColumns.put("p_date1", getPDate1());
		this.hashColumns.put("p_date2", getPDate2());
		this.hashColumns.put("soper_48", getSoper48());
		this.hashColumns.put("cnt_cd", getCntCd());
		this.hashColumns.put("soff_24", getSoff24());
		this.hashColumns.put("data_by", getDataBy());
		this.hashColumns.put("moff_24", getMoff24());
		this.hashColumns.put("eper_24", getEper24());
		this.hashColumns.put("sper_24", getSper24());
		this.hashColumns.put("eoff_24", getEoff24());
		this.hashColumns.put("p_yard2", getPYard2());
		this.hashColumns.put("moff_12", getMoff12());
		this.hashColumns.put("p_yard1", getPYard1());
		this.hashColumns.put("mper_24", getMper24());
		this.hashColumns.put("gap", getGap());
		this.hashColumns.put("eper_48", getEper48());
		this.hashColumns.put("stot", getStot());
		this.hashColumns.put("moper_48", getMoper48());
		this.hashColumns.put("fcntr_flg", getFcntrFlg());
		this.hashColumns.put("eoper_48", getEoper48());
		this.hashColumns.put("off_24", getOff24());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("tot", getTot());
		this.hashColumns.put("mper_12", getMper12());
		this.hashColumns.put("sper_48", getSper48());
		this.hashColumns.put("moff_48", getMoff48());
		this.hashColumns.put("soff_48", getSoff48());
		this.hashColumns.put("dom_flg", getDomFlg());
		this.hashColumns.put("per_12", getPer12());
		this.hashColumns.put("rcc_cd", getRccCd());
		this.hashColumns.put("off_12", getOff12());
		this.hashColumns.put("org_yd_cd", getOrgYdCd());
		this.hashColumns.put("sovr_48", getSovr48());
		this.hashColumns.put("movr_48", getMovr48());
		this.hashColumns.put("lcc_cd", getLccCd());
		this.hashColumns.put("eoff_48", getEoff48());
		this.hashColumns.put("eovr_48", getEovr48());
		this.hashColumns.put("sper_12", getSper12());
		this.hashColumns.put("eper_12", getEper12());
		this.hashColumns.put("per_24", getPer24());
		this.hashColumns.put("mper_48", getMper48());
		this.hashColumns.put("soff_12", getSoff12());
		this.hashColumns.put("etot", getEtot());
		this.hashColumns.put("off_48", getOff48());
		return this.hashColumns;
	}

	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("per_48", "per48");
		this.hashFields.put("oper_48", "oper48");
		this.hashFields.put("int_type", "intType");
		this.hashFields.put("mtot", "mtot");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("sts_cd", "stsCd");
		this.hashFields.put("eoff_12", "eoff12");
		this.hashFields.put("ovr_48", "ovr48");
		this.hashFields.put("loc_cd", "locCd");
		this.hashFields.put("p_date1", "pDate1");
		this.hashFields.put("p_date2", "pDate2");
		this.hashFields.put("soper_48", "soper48");
		this.hashFields.put("cnt_cd", "cntCd");
		this.hashFields.put("soff_24", "soff24");
		this.hashFields.put("data_by", "dataBy");
		this.hashFields.put("moff_24", "moff24");
		this.hashFields.put("eper_24", "eper24");
		this.hashFields.put("sper_24", "sper24");
		this.hashFields.put("eoff_24", "eoff24");
		this.hashFields.put("p_yard2", "pYard2");
		this.hashFields.put("moff_12", "moff12");
		this.hashFields.put("p_yard1", "pYard1");
		this.hashFields.put("mper_24", "mper24");
		this.hashFields.put("gap", "gap");
		this.hashFields.put("eper_48", "eper48");
		this.hashFields.put("stot", "stot");
		this.hashFields.put("moper_48", "moper48");
		this.hashFields.put("fcntr_flg", "fcntrFlg");
		this.hashFields.put("eoper_48", "eoper48");
		this.hashFields.put("off_24", "off24");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("tot", "tot");
		this.hashFields.put("mper_12", "mper12");
		this.hashFields.put("sper_48", "sper48");
		this.hashFields.put("moff_48", "moff48");
		this.hashFields.put("soff_48", "soff48");
		this.hashFields.put("dom_flg", "domFlg");
		this.hashFields.put("per_12", "per12");
		this.hashFields.put("rcc_cd", "rccCd");
		this.hashFields.put("off_12", "off12");
		this.hashFields.put("org_yd_cd", "orgYdCd");
		this.hashFields.put("sovr_48", "sovr48");
		this.hashFields.put("movr_48", "movr48");
		this.hashFields.put("lcc_cd", "lccCd");
		this.hashFields.put("eoff_48", "eoff48");
		this.hashFields.put("eovr_48", "eovr48");
		this.hashFields.put("sper_12", "sper12");
		this.hashFields.put("eper_12", "eper12");
		this.hashFields.put("per_24", "per24");
		this.hashFields.put("mper_48", "mper48");
		this.hashFields.put("soff_12", "soff12");
		this.hashFields.put("etot", "etot");
		this.hashFields.put("off_48", "off48");
		return this.hashFields;
	}

	/**
	 * Column Info
	 * @return per48
	 */
	public String getPer48() {
		return this.per48;
	}

	/**
	 * Column Info
	 * @return oper48
	 */
	public String getOper48() {
		return this.oper48;
	}

	/**
	 * Column Info
	 * @return intType
	 */
	public String getIntType() {
		return this.intType;
	}

	/**
	 * Column Info
	 * @return mtot
	 */
	public String getMtot() {
		return this.mtot;
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
	 * @return stsCd
	 */
	public String getStsCd() {
		return this.stsCd;
	}

	/**
	 * Column Info
	 * @return eoff12
	 */
	public String getEoff12() {
		return this.eoff12;
	}

	/**
	 * Column Info
	 * @return ovr48
	 */
	public String getOvr48() {
		return this.ovr48;
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
	 * @return pDate1
	 */
	public String getPDate1() {
		return this.pDate1;
	}

	/**
	 * Column Info
	 * @return pDate2
	 */
	public String getPDate2() {
		return this.pDate2;
	}

	/**
	 * Column Info
	 * @return soper48
	 */
	public String getSoper48() {
		return this.soper48;
	}

	/**
	 * Column Info
	 * @return cntCd
	 */
	public String getCntCd() {
		return this.cntCd;
	}

	/**
	 * Column Info
	 * @return soff24
	 */
	public String getSoff24() {
		return this.soff24;
	}

	/**
	 * Column Info
	 * @return dataBy
	 */
	public String getDataBy() {
		return this.dataBy;
	}

	/**
	 * Column Info
	 * @return moff24
	 */
	public String getMoff24() {
		return this.moff24;
	}

	/**
	 * Column Info
	 * @return eper24
	 */
	public String getEper24() {
		return this.eper24;
	}

	/**
	 * Column Info
	 * @return sper24
	 */
	public String getSper24() {
		return this.sper24;
	}

	/**
	 * Column Info
	 * @return eoff24
	 */
	public String getEoff24() {
		return this.eoff24;
	}

	/**
	 * Column Info
	 * @return pYard2
	 */
	public String getPYard2() {
		return this.pYard2;
	}

	/**
	 * Column Info
	 * @return moff12
	 */
	public String getMoff12() {
		return this.moff12;
	}

	/**
	 * Column Info
	 * @return pYard1
	 */
	public String getPYard1() {
		return this.pYard1;
	}

	/**
	 * Column Info
	 * @return mper24
	 */
	public String getMper24() {
		return this.mper24;
	}

	/**
	 * Column Info
	 * @return gap
	 */
	public String getGap() {
		return this.gap;
	}

	/**
	 * Column Info
	 * @return eper48
	 */
	public String getEper48() {
		return this.eper48;
	}

	/**
	 * Column Info
	 * @return stot
	 */
	public String getStot() {
		return this.stot;
	}

	/**
	 * Column Info
	 * @return moper48
	 */
	public String getMoper48() {
		return this.moper48;
	}

	/**
	 * Column Info
	 * @return fcntrFlg
	 */
	public String getFcntrFlg() {
		return this.fcntrFlg;
	}

	/**
	 * Column Info
	 * @return eoper48
	 */
	public String getEoper48() {
		return this.eoper48;
	}

	/**
	 * Column Info
	 * @return off24
	 */
	public String getOff24() {
		return this.off24;
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
	 * @return tot
	 */
	public String getTot() {
		return this.tot;
	}

	/**
	 * Column Info
	 * @return mper12
	 */
	public String getMper12() {
		return this.mper12;
	}

	/**
	 * Column Info
	 * @return sper48
	 */
	public String getSper48() {
		return this.sper48;
	}

	/**
	 * Column Info
	 * @return moff48
	 */
	public String getMoff48() {
		return this.moff48;
	}

	/**
	 * Column Info
	 * @return soff48
	 */
	public String getSoff48() {
		return this.soff48;
	}

	/**
	 * Column Info
	 * @return domFlg
	 */
	public String getDomFlg() {
		return this.domFlg;
	}

	/**
	 * Column Info
	 * @return per12
	 */
	public String getPer12() {
		return this.per12;
	}

	/**
	 * Column Info
	 * @return rccCd
	 */
	public String getRccCd() {
		return this.rccCd;
	}

	/**
	 * Column Info
	 * @return off12
	 */
	public String getOff12() {
		return this.off12;
	}

	/**
	 * Column Info
	 * @return orgYdCd
	 */
	public String getOrgYdCd() {
		return this.orgYdCd;
	}

	/**
	 * Column Info
	 * @return sovr48
	 */
	public String getSovr48() {
		return this.sovr48;
	}

	/**
	 * Column Info
	 * @return movr48
	 */
	public String getMovr48() {
		return this.movr48;
	}

	/**
	 * Column Info
	 * @return lccCd
	 */
	public String getLccCd() {
		return this.lccCd;
	}

	/**
	 * Column Info
	 * @return eoff48
	 */
	public String getEoff48() {
		return this.eoff48;
	}

	/**
	 * Column Info
	 * @return eovr48
	 */
	public String getEovr48() {
		return this.eovr48;
	}

	/**
	 * Column Info
	 * @return sper12
	 */
	public String getSper12() {
		return this.sper12;
	}

	/**
	 * Column Info
	 * @return eper12
	 */
	public String getEper12() {
		return this.eper12;
	}

	/**
	 * Column Info
	 * @return per24
	 */
	public String getPer24() {
		return this.per24;
	}

	/**
	 * Column Info
	 * @return mper48
	 */
	public String getMper48() {
		return this.mper48;
	}

	/**
	 * Column Info
	 * @return soff12
	 */
	public String getSoff12() {
		return this.soff12;
	}

	/**
	 * Column Info
	 * @return etot
	 */
	public String getEtot() {
		return this.etot;
	}

	/**
	 * Column Info
	 * @return off48
	 */
	public String getOff48() {
		return this.off48;
	}


	/**
	 * Column Info
	 * @param per48
	 */
	public void setPer48(String per48) {
		this.per48 = per48;
	}

	/**
	 * Column Info
	 * @param oper48
	 */
	public void setOper48(String oper48) {
		this.oper48 = oper48;
	}

	/**
	 * Column Info
	 * @param intType
	 */
	public void setIntType(String intType) {
		this.intType = intType;
	}

	/**
	 * Column Info
	 * @param mtot
	 */
	public void setMtot(String mtot) {
		this.mtot = mtot;
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
	 * @param stsCd
	 */
	public void setStsCd(String stsCd) {
		this.stsCd = stsCd;
	}

	/**
	 * Column Info
	 * @param eoff12
	 */
	public void setEoff12(String eoff12) {
		this.eoff12 = eoff12;
	}

	/**
	 * Column Info
	 * @param ovr48
	 */
	public void setOvr48(String ovr48) {
		this.ovr48 = ovr48;
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
	 * @param pDate1
	 */
	public void setPDate1(String pDate1) {
		this.pDate1 = pDate1;
	}

	/**
	 * Column Info
	 * @param pDate2
	 */
	public void setPDate2(String pDate2) {
		this.pDate2 = pDate2;
	}

	/**
	 * Column Info
	 * @param soper48
	 */
	public void setSoper48(String soper48) {
		this.soper48 = soper48;
	}

	/**
	 * Column Info
	 * @param cntCd
	 */
	public void setCntCd(String cntCd) {
		this.cntCd = cntCd;
	}

	/**
	 * Column Info
	 * @param soff24
	 */
	public void setSoff24(String soff24) {
		this.soff24 = soff24;
	}

	/**
	 * Column Info
	 * @param dataBy
	 */
	public void setDataBy(String dataBy) {
		this.dataBy = dataBy;
	}

	/**
	 * Column Info
	 * @param moff24
	 */
	public void setMoff24(String moff24) {
		this.moff24 = moff24;
	}

	/**
	 * Column Info
	 * @param eper24
	 */
	public void setEper24(String eper24) {
		this.eper24 = eper24;
	}

	/**
	 * Column Info
	 * @param sper24
	 */
	public void setSper24(String sper24) {
		this.sper24 = sper24;
	}

	/**
	 * Column Info
	 * @param eoff24
	 */
	public void setEoff24(String eoff24) {
		this.eoff24 = eoff24;
	}

	/**
	 * Column Info
	 * @param pYard2
	 */
	public void setPYard2(String pYard2) {
		this.pYard2 = pYard2;
	}

	/**
	 * Column Info
	 * @param moff12
	 */
	public void setMoff12(String moff12) {
		this.moff12 = moff12;
	}

	/**
	 * Column Info
	 * @param pYard1
	 */
	public void setPYard1(String pYard1) {
		this.pYard1 = pYard1;
	}

	/**
	 * Column Info
	 * @param mper24
	 */
	public void setMper24(String mper24) {
		this.mper24 = mper24;
	}

	/**
	 * Column Info
	 * @param gap
	 */
	public void setGap(String gap) {
		this.gap = gap;
	}

	/**
	 * Column Info
	 * @param eper48
	 */
	public void setEper48(String eper48) {
		this.eper48 = eper48;
	}

	/**
	 * Column Info
	 * @param stot
	 */
	public void setStot(String stot) {
		this.stot = stot;
	}

	/**
	 * Column Info
	 * @param moper48
	 */
	public void setMoper48(String moper48) {
		this.moper48 = moper48;
	}

	/**
	 * Column Info
	 * @param fcntrFlg
	 */
	public void setFcntrFlg(String fcntrFlg) {
		this.fcntrFlg = fcntrFlg;
	}

	/**
	 * Column Info
	 * @param eoper48
	 */
	public void setEoper48(String eoper48) {
		this.eoper48 = eoper48;
	}

	/**
	 * Column Info
	 * @param off24
	 */
	public void setOff24(String off24) {
		this.off24 = off24;
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
	 * @param tot
	 */
	public void setTot(String tot) {
		this.tot = tot;
	}

	/**
	 * Column Info
	 * @param mper12
	 */
	public void setMper12(String mper12) {
		this.mper12 = mper12;
	}

	/**
	 * Column Info
	 * @param sper48
	 */
	public void setSper48(String sper48) {
		this.sper48 = sper48;
	}

	/**
	 * Column Info
	 * @param moff48
	 */
	public void setMoff48(String moff48) {
		this.moff48 = moff48;
	}

	/**
	 * Column Info
	 * @param soff48
	 */
	public void setSoff48(String soff48) {
		this.soff48 = soff48;
	}

	/**
	 * Column Info
	 * @param domFlg
	 */
	public void setDomFlg(String domFlg) {
		this.domFlg = domFlg;
	}

	/**
	 * Column Info
	 * @param per12
	 */
	public void setPer12(String per12) {
		this.per12 = per12;
	}

	/**
	 * Column Info
	 * @param rccCd
	 */
	public void setRccCd(String rccCd) {
		this.rccCd = rccCd;
	}

	/**
	 * Column Info
	 * @param off12
	 */
	public void setOff12(String off12) {
		this.off12 = off12;
	}

	/**
	 * Column Info
	 * @param orgYdCd
	 */
	public void setOrgYdCd(String orgYdCd) {
		this.orgYdCd = orgYdCd;
	}

	/**
	 * Column Info
	 * @param sovr48
	 */
	public void setSovr48(String sovr48) {
		this.sovr48 = sovr48;
	}

	/**
	 * Column Info
	 * @param movr48
	 */
	public void setMovr48(String movr48) {
		this.movr48 = movr48;
	}

	/**
	 * Column Info
	 * @param lccCd
	 */
	public void setLccCd(String lccCd) {
		this.lccCd = lccCd;
	}

	/**
	 * Column Info
	 * @param eoff48
	 */
	public void setEoff48(String eoff48) {
		this.eoff48 = eoff48;
	}

	/**
	 * Column Info
	 * @param eovr48
	 */
	public void setEovr48(String eovr48) {
		this.eovr48 = eovr48;
	}

	/**
	 * Column Info
	 * @param sper12
	 */
	public void setSper12(String sper12) {
		this.sper12 = sper12;
	}

	/**
	 * Column Info
	 * @param eper12
	 */
	public void setEper12(String eper12) {
		this.eper12 = eper12;
	}

	/**
	 * Column Info
	 * @param per24
	 */
	public void setPer24(String per24) {
		this.per24 = per24;
	}

	/**
	 * Column Info
	 * @param mper48
	 */
	public void setMper48(String mper48) {
		this.mper48 = mper48;
	}

	/**
	 * Column Info
	 * @param soff12
	 */
	public void setSoff12(String soff12) {
		this.soff12 = soff12;
	}

	/**
	 * Column Info
	 * @param etot
	 */
	public void setEtot(String etot) {
		this.etot = etot;
	}

	/**
	 * Column Info
	 * @param off48
	 */
	public void setOff48(String off48) {
		this.off48 = off48;
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
		setPer48(JSPUtil.getParameter(request, prefix + "per_48", ""));
		setOper48(JSPUtil.getParameter(request, prefix + "oper_48", ""));
		setIntType(JSPUtil.getParameter(request, prefix + "int_type", ""));
		setMtot(JSPUtil.getParameter(request, prefix + "mtot", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setStsCd(JSPUtil.getParameter(request, prefix + "sts_cd", ""));
		setEoff12(JSPUtil.getParameter(request, prefix + "eoff_12", ""));
		setOvr48(JSPUtil.getParameter(request, prefix + "ovr_48", ""));
		setLocCd(JSPUtil.getParameter(request, prefix + "loc_cd", ""));
		setPDate1(JSPUtil.getParameter(request, prefix + "p_date1", ""));
		setPDate2(JSPUtil.getParameter(request, prefix + "p_date2", ""));
		setSoper48(JSPUtil.getParameter(request, prefix + "soper_48", ""));
		setCntCd(JSPUtil.getParameter(request, prefix + "cnt_cd", ""));
		setSoff24(JSPUtil.getParameter(request, prefix + "soff_24", ""));
		setDataBy(JSPUtil.getParameter(request, prefix + "data_by", ""));
		setMoff24(JSPUtil.getParameter(request, prefix + "moff_24", ""));
		setEper24(JSPUtil.getParameter(request, prefix + "eper_24", ""));
		setSper24(JSPUtil.getParameter(request, prefix + "sper_24", ""));
		setEoff24(JSPUtil.getParameter(request, prefix + "eoff_24", ""));
		setPYard2(JSPUtil.getParameter(request, prefix + "p_yard2", ""));
		setMoff12(JSPUtil.getParameter(request, prefix + "moff_12", ""));
		setPYard1(JSPUtil.getParameter(request, prefix + "p_yard1", ""));
		setMper24(JSPUtil.getParameter(request, prefix + "mper_24", ""));
		setGap(JSPUtil.getParameter(request, prefix + "gap", ""));
		setEper48(JSPUtil.getParameter(request, prefix + "eper_48", ""));
		setStot(JSPUtil.getParameter(request, prefix + "stot", ""));
		setMoper48(JSPUtil.getParameter(request, prefix + "moper_48", ""));
		setFcntrFlg(JSPUtil.getParameter(request, prefix + "fcntr_flg", ""));
		setEoper48(JSPUtil.getParameter(request, prefix + "eoper_48", ""));
		setOff24(JSPUtil.getParameter(request, prefix + "off_24", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setTot(JSPUtil.getParameter(request, prefix + "tot", ""));
		setMper12(JSPUtil.getParameter(request, prefix + "mper_12", ""));
		setSper48(JSPUtil.getParameter(request, prefix + "sper_48", ""));
		setMoff48(JSPUtil.getParameter(request, prefix + "moff_48", ""));
		setSoff48(JSPUtil.getParameter(request, prefix + "soff_48", ""));
		setDomFlg(JSPUtil.getParameter(request, prefix + "dom_flg", ""));
		setPer12(JSPUtil.getParameter(request, prefix + "per_12", ""));
		setRccCd(JSPUtil.getParameter(request, prefix + "rcc_cd", ""));
		setOff12(JSPUtil.getParameter(request, prefix + "off_12", ""));
		setOrgYdCd(JSPUtil.getParameter(request, prefix + "org_yd_cd", ""));
		setSovr48(JSPUtil.getParameter(request, prefix + "sovr_48", ""));
		setMovr48(JSPUtil.getParameter(request, prefix + "movr_48", ""));
		setLccCd(JSPUtil.getParameter(request, prefix + "lcc_cd", ""));
		setEoff48(JSPUtil.getParameter(request, prefix + "eoff_48", ""));
		setEovr48(JSPUtil.getParameter(request, prefix + "eovr_48", ""));
		setSper12(JSPUtil.getParameter(request, prefix + "sper_12", ""));
		setEper12(JSPUtil.getParameter(request, prefix + "eper_12", ""));
		setPer24(JSPUtil.getParameter(request, prefix + "per_24", ""));
		setMper48(JSPUtil.getParameter(request, prefix + "mper_48", ""));
		setSoff12(JSPUtil.getParameter(request, prefix + "soff_12", ""));
		setEtot(JSPUtil.getParameter(request, prefix + "etot", ""));
		setOff48(JSPUtil.getParameter(request, prefix + "off_48", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return MovementEDIReportVO[]
	 */
	public MovementEDIReportVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다.
	 * @param request
	 * @param prefix
	 * @return MovementEDIReportVO[]
	 */
	public MovementEDIReportVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		MovementEDIReportVO model = null;

		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;

		try {
			String[] per48 = (JSPUtil.getParameter(request, prefix	+ "per_48", length));
			String[] oper48 = (JSPUtil.getParameter(request, prefix	+ "oper_48", length));
			String[] intType = (JSPUtil.getParameter(request, prefix	+ "int_type", length));
			String[] mtot = (JSPUtil.getParameter(request, prefix	+ "mtot", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] stsCd = (JSPUtil.getParameter(request, prefix	+ "sts_cd", length));
			String[] eoff12 = (JSPUtil.getParameter(request, prefix	+ "eoff_12", length));
			String[] ovr48 = (JSPUtil.getParameter(request, prefix	+ "ovr_48", length));
			String[] locCd = (JSPUtil.getParameter(request, prefix	+ "loc_cd", length));
			String[] pDate1 = (JSPUtil.getParameter(request, prefix	+ "p_date1", length));
			String[] pDate2 = (JSPUtil.getParameter(request, prefix	+ "p_date2", length));
			String[] soper48 = (JSPUtil.getParameter(request, prefix	+ "soper_48", length));
			String[] cntCd = (JSPUtil.getParameter(request, prefix	+ "cnt_cd", length));
			String[] soff24 = (JSPUtil.getParameter(request, prefix	+ "soff_24", length));
			String[] dataBy = (JSPUtil.getParameter(request, prefix	+ "data_by", length));
			String[] moff24 = (JSPUtil.getParameter(request, prefix	+ "moff_24", length));
			String[] eper24 = (JSPUtil.getParameter(request, prefix	+ "eper_24", length));
			String[] sper24 = (JSPUtil.getParameter(request, prefix	+ "sper_24", length));
			String[] eoff24 = (JSPUtil.getParameter(request, prefix	+ "eoff_24", length));
			String[] pYard2 = (JSPUtil.getParameter(request, prefix	+ "p_yard2", length));
			String[] moff12 = (JSPUtil.getParameter(request, prefix	+ "moff_12", length));
			String[] pYard1 = (JSPUtil.getParameter(request, prefix	+ "p_yard1", length));
			String[] mper24 = (JSPUtil.getParameter(request, prefix	+ "mper_24", length));
			String[] gap = (JSPUtil.getParameter(request, prefix	+ "gap", length));
			String[] eper48 = (JSPUtil.getParameter(request, prefix	+ "eper_48", length));
			String[] stot = (JSPUtil.getParameter(request, prefix	+ "stot", length));
			String[] moper48 = (JSPUtil.getParameter(request, prefix	+ "moper_48", length));
			String[] fcntrFlg = (JSPUtil.getParameter(request, prefix	+ "fcntr_flg", length));
			String[] eoper48 = (JSPUtil.getParameter(request, prefix	+ "eoper_48", length));
			String[] off24 = (JSPUtil.getParameter(request, prefix	+ "off_24", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] tot = (JSPUtil.getParameter(request, prefix	+ "tot", length));
			String[] mper12 = (JSPUtil.getParameter(request, prefix	+ "mper_12", length));
			String[] sper48 = (JSPUtil.getParameter(request, prefix	+ "sper_48", length));
			String[] moff48 = (JSPUtil.getParameter(request, prefix	+ "moff_48", length));
			String[] soff48 = (JSPUtil.getParameter(request, prefix	+ "soff_48", length));
			String[] domFlg = (JSPUtil.getParameter(request, prefix	+ "dom_flg", length));
			String[] per12 = (JSPUtil.getParameter(request, prefix	+ "per_12", length));
			String[] rccCd = (JSPUtil.getParameter(request, prefix	+ "rcc_cd", length));
			String[] off12 = (JSPUtil.getParameter(request, prefix	+ "off_12", length));
			String[] orgYdCd = (JSPUtil.getParameter(request, prefix	+ "org_yd_cd", length));
			String[] sovr48 = (JSPUtil.getParameter(request, prefix	+ "sovr_48", length));
			String[] movr48 = (JSPUtil.getParameter(request, prefix	+ "movr_48", length));
			String[] lccCd = (JSPUtil.getParameter(request, prefix	+ "lcc_cd", length));
			String[] eoff48 = (JSPUtil.getParameter(request, prefix	+ "eoff_48", length));
			String[] eovr48 = (JSPUtil.getParameter(request, prefix	+ "eovr_48", length));
			String[] sper12 = (JSPUtil.getParameter(request, prefix	+ "sper_12", length));
			String[] eper12 = (JSPUtil.getParameter(request, prefix	+ "eper_12", length));
			String[] per24 = (JSPUtil.getParameter(request, prefix	+ "per_24", length));
			String[] mper48 = (JSPUtil.getParameter(request, prefix	+ "mper_48", length));
			String[] soff12 = (JSPUtil.getParameter(request, prefix	+ "soff_12", length));
			String[] etot = (JSPUtil.getParameter(request, prefix	+ "etot", length));
			String[] off48 = (JSPUtil.getParameter(request, prefix	+ "off_48", length));

			for (int i = 0; i < length; i++) {
				model = new MovementEDIReportVO();
				if (per48[i] != null)
					model.setPer48(per48[i]);
				if (oper48[i] != null)
					model.setOper48(oper48[i]);
				if (intType[i] != null)
					model.setIntType(intType[i]);
				if (mtot[i] != null)
					model.setMtot(mtot[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (stsCd[i] != null)
					model.setStsCd(stsCd[i]);
				if (eoff12[i] != null)
					model.setEoff12(eoff12[i]);
				if (ovr48[i] != null)
					model.setOvr48(ovr48[i]);
				if (locCd[i] != null)
					model.setLocCd(locCd[i]);
				if (pDate1[i] != null)
					model.setPDate1(pDate1[i]);
				if (pDate2[i] != null)
					model.setPDate2(pDate2[i]);
				if (soper48[i] != null)
					model.setSoper48(soper48[i]);
				if (cntCd[i] != null)
					model.setCntCd(cntCd[i]);
				if (soff24[i] != null)
					model.setSoff24(soff24[i]);
				if (dataBy[i] != null)
					model.setDataBy(dataBy[i]);
				if (moff24[i] != null)
					model.setMoff24(moff24[i]);
				if (eper24[i] != null)
					model.setEper24(eper24[i]);
				if (sper24[i] != null)
					model.setSper24(sper24[i]);
				if (eoff24[i] != null)
					model.setEoff24(eoff24[i]);
				if (pYard2[i] != null)
					model.setPYard2(pYard2[i]);
				if (moff12[i] != null)
					model.setMoff12(moff12[i]);
				if (pYard1[i] != null)
					model.setPYard1(pYard1[i]);
				if (mper24[i] != null)
					model.setMper24(mper24[i]);
				if (gap[i] != null)
					model.setGap(gap[i]);
				if (eper48[i] != null)
					model.setEper48(eper48[i]);
				if (stot[i] != null)
					model.setStot(stot[i]);
				if (moper48[i] != null)
					model.setMoper48(moper48[i]);
				if (fcntrFlg[i] != null)
					model.setFcntrFlg(fcntrFlg[i]);
				if (eoper48[i] != null)
					model.setEoper48(eoper48[i]);
				if (off24[i] != null)
					model.setOff24(off24[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (tot[i] != null)
					model.setTot(tot[i]);
				if (mper12[i] != null)
					model.setMper12(mper12[i]);
				if (sper48[i] != null)
					model.setSper48(sper48[i]);
				if (moff48[i] != null)
					model.setMoff48(moff48[i]);
				if (soff48[i] != null)
					model.setSoff48(soff48[i]);
				if (domFlg[i] != null)
					model.setDomFlg(domFlg[i]);
				if (per12[i] != null)
					model.setPer12(per12[i]);
				if (rccCd[i] != null)
					model.setRccCd(rccCd[i]);
				if (off12[i] != null)
					model.setOff12(off12[i]);
				if (orgYdCd[i] != null)
					model.setOrgYdCd(orgYdCd[i]);
				if (sovr48[i] != null)
					model.setSovr48(sovr48[i]);
				if (movr48[i] != null)
					model.setMovr48(movr48[i]);
				if (lccCd[i] != null)
					model.setLccCd(lccCd[i]);
				if (eoff48[i] != null)
					model.setEoff48(eoff48[i]);
				if (eovr48[i] != null)
					model.setEovr48(eovr48[i]);
				if (sper12[i] != null)
					model.setSper12(sper12[i]);
				if (eper12[i] != null)
					model.setEper12(eper12[i]);
				if (per24[i] != null)
					model.setPer24(per24[i]);
				if (mper48[i] != null)
					model.setMper48(mper48[i]);
				if (soff12[i] != null)
					model.setSoff12(soff12[i]);
				if (etot[i] != null)
					model.setEtot(etot[i]);
				if (off48[i] != null)
					model.setOff48(off48[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getMovementEDIReportVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return MovementEDIReportVO[]
	 */
	public MovementEDIReportVO[] getMovementEDIReportVOs(){
		MovementEDIReportVO[] vos = (MovementEDIReportVO[])models.toArray(new MovementEDIReportVO[models.size()]);
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
		this.per48 = this.per48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oper48 = this.oper48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.intType = this.intType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtot = this.mtot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stsCd = this.stsCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eoff12 = this.eoff12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovr48 = this.ovr48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.locCd = this.locCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate1 = this.pDate1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pDate2 = this.pDate2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soper48 = this.soper48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntCd = this.cntCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soff24 = this.soff24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dataBy = this.dataBy .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moff24 = this.moff24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eper24 = this.eper24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sper24 = this.sper24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eoff24 = this.eoff24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard2 = this.pYard2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moff12 = this.moff12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pYard1 = this.pYard1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mper24 = this.mper24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.gap = this.gap .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eper48 = this.eper48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stot = this.stot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moper48 = this.moper48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fcntrFlg = this.fcntrFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eoper48 = this.eoper48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.off24 = this.off24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tot = this.tot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mper12 = this.mper12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sper48 = this.sper48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.moff48 = this.moff48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soff48 = this.soff48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.domFlg = this.domFlg .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.per12 = this.per12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rccCd = this.rccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.off12 = this.off12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.orgYdCd = this.orgYdCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sovr48 = this.sovr48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.movr48 = this.movr48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.lccCd = this.lccCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eoff48 = this.eoff48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eovr48 = this.eovr48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.sper12 = this.sper12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.eper12 = this.eper12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.per24 = this.per24 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mper48 = this.mper48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.soff12 = this.soff12 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.etot = this.etot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.off48 = this.off48 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
