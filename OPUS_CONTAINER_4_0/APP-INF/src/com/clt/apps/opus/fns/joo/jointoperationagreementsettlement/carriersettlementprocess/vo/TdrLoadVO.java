/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TdrLoadVO.java
*@FileTitle : TdrLoadVO
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.09
*@LastModifier : 
*@LastVersion : 1.0
* 2010.12.09  
* 1.0 Creation
* --------------------------------------------------------
* History
* 2010.12.07 김상수 [CHM-201007318-01] JOO - TDR Inquiry 기능 보완 요청 - i-stowage 연계
*                    1. 조회조건에 Carrier Code를 Multi Select 할 수 있는 멀티콤보 추가
*                    2. Sheet에 컬럼 추가
*                      (※ Data 조회 Logic 보완)
*                      - 기존처럼  해당 VVD 와 Port를 선정할때  Upload Status가  N (증빙 가)일 경우
*                         해당 정보(20’, 40’, 20HC, 40HC, 45, AK, RF, EMPTY)를 I-Stowage에서 조회
*                      - Source 컬럼 추가
*                         OPF : OPF 모듈에서  Data 조회
*                         IST : I-Stowage에서 Data 조회
=========================================================*/

package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo;

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

public class TdrLoadVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<TdrLoadVO> models = new ArrayList<TdrLoadVO>();
	
	/* Column Info */
	private String hcBsa40 = null;
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String hcLd45 = null;
	/* Column Info */
	private String rf20Qty = null;
	/* Column Info */
	private String hcBsa45 = null;
	/* Column Info */
	private String akVoid = null;
	/* Column Info */
	private String hcBsa20 = null;
	/* Column Info */
	private String rf40Qty = null;
	/* Column Info */
	private String mt20 = null;
	/* Column Info */
	private String rlaneCd = null;
	/* Column Info */
	private String mt40 = null;
	/* Column Info */
	private String hcLd20 = null;
	/* Column Info */
	private String full20 = null;
	/* Column Info */
	private String mtTeu = null;
	/* Column Info */
	private String allWgt = null;
	/* Column Info */
	private String full40 = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String preFr = null;
	/* Column Info */
	private String vpsPortCd = null;
	/* Column Info */
	private String overSlot = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String hcLd40 = null;
	/* Column Info */
	private String mtWt = null;
	/* Column Info */
	private String joRgnCd = null;
	/* Column Info */
	private String vpsEtdDt = null;
	/* Column Info */
	private String superCd1 = null;
	/* Column Info */
	private String skdVoyNo = null;
	/* Column Info */
	private String overWgt = null;
	/* Column Info */
	private String grandTtlSlot = null;
	/* Column Info */
	private String allTeu = null;
	/* Column Info */
	private String skdDirCd = null;
	/* Column Info */
	private String akUnit = null;
	/* Column Info */
	private String vvd = null;
	/* Column Info */
	private String slanCd = null;
	/* Column Info */
	private String source = null;
	/* Column Info */
	private String preTo = null;
	/* Column Info */
	private String oprCd = null;
	/* Column Info */
	private String grandTtlWgt = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public TdrLoadVO() {}

	public TdrLoadVO(String ibflag, String pagerows, String vvd, String oprCd, String vslCd, String skdVoyNo, String skdDirCd, String vpsPortCd, String slanCd, String vpsEtdDt, String allTeu, String allWgt, String grandTtlSlot, String grandTtlWgt, String overSlot, String overWgt, String hcLd20, String hcLd40, String hcLd45, String rf20Qty, String rf40Qty, String preFr, String preTo, String rlaneCd, String joRgnCd, String superCd1, String mtTeu, String hcBsa20, String hcBsa40, String hcBsa45, String full20, String mt20, String full40, String mt40, String mtWt, String akUnit, String akVoid, String source) {
		this.hcBsa40 = hcBsa40;
		this.vslCd = vslCd;
		this.hcLd45 = hcLd45;
		this.rf20Qty = rf20Qty;
		this.hcBsa45 = hcBsa45;
		this.akVoid = akVoid;
		this.hcBsa20 = hcBsa20;
		this.rf40Qty = rf40Qty;
		this.mt20 = mt20;
		this.rlaneCd = rlaneCd;
		this.mt40 = mt40;
		this.hcLd20 = hcLd20;
		this.full20 = full20;
		this.mtTeu = mtTeu;
		this.allWgt = allWgt;
		this.full40 = full40;
		this.pagerows = pagerows;
		this.preFr = preFr;
		this.vpsPortCd = vpsPortCd;
		this.overSlot = overSlot;
		this.ibflag = ibflag;
		this.hcLd40 = hcLd40;
		this.mtWt = mtWt;
		this.joRgnCd = joRgnCd;
		this.vpsEtdDt = vpsEtdDt;
		this.superCd1 = superCd1;
		this.skdVoyNo = skdVoyNo;
		this.overWgt = overWgt;
		this.grandTtlSlot = grandTtlSlot;
		this.allTeu = allTeu;
		this.skdDirCd = skdDirCd;
		this.akUnit = akUnit;
		this.vvd = vvd;
		this.slanCd = slanCd;
		this.source = source;
		this.preTo = preTo;
		this.oprCd = oprCd;
		this.grandTtlWgt = grandTtlWgt;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("hc_bsa_40", getHcBsa40());
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("hc_ld_45", getHcLd45());
		this.hashColumns.put("rf_20_qty", getRf20Qty());
		this.hashColumns.put("hc_bsa_45", getHcBsa45());
		this.hashColumns.put("ak_void", getAkVoid());
		this.hashColumns.put("hc_bsa_20", getHcBsa20());
		this.hashColumns.put("rf_40_qty", getRf40Qty());
		this.hashColumns.put("mt_20", getMt20());
		this.hashColumns.put("rlane_cd", getRlaneCd());
		this.hashColumns.put("mt_40", getMt40());
		this.hashColumns.put("hc_ld_20", getHcLd20());
		this.hashColumns.put("full_20", getFull20());
		this.hashColumns.put("mt_teu", getMtTeu());
		this.hashColumns.put("all_wgt", getAllWgt());
		this.hashColumns.put("full_40", getFull40());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("pre_fr", getPreFr());
		this.hashColumns.put("vps_port_cd", getVpsPortCd());
		this.hashColumns.put("over_slot", getOverSlot());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("hc_ld_40", getHcLd40());
		this.hashColumns.put("mt_wt", getMtWt());
		this.hashColumns.put("jo_rgn_cd", getJoRgnCd());
		this.hashColumns.put("vps_etd_dt", getVpsEtdDt());
		this.hashColumns.put("super_cd1", getSuperCd1());
		this.hashColumns.put("skd_voy_no", getSkdVoyNo());
		this.hashColumns.put("over_wgt", getOverWgt());
		this.hashColumns.put("grand_ttl_slot", getGrandTtlSlot());
		this.hashColumns.put("all_teu", getAllTeu());
		this.hashColumns.put("skd_dir_cd", getSkdDirCd());
		this.hashColumns.put("ak_unit", getAkUnit());
		this.hashColumns.put("vvd", getVvd());
		this.hashColumns.put("slan_cd", getSlanCd());
		this.hashColumns.put("source", getSource());
		this.hashColumns.put("pre_to", getPreTo());
		this.hashColumns.put("opr_cd", getOprCd());
		this.hashColumns.put("grand_ttl_wgt", getGrandTtlWgt());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("hc_bsa_40", "hcBsa40");
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("hc_ld_45", "hcLd45");
		this.hashFields.put("rf_20_qty", "rf20Qty");
		this.hashFields.put("hc_bsa_45", "hcBsa45");
		this.hashFields.put("ak_void", "akVoid");
		this.hashFields.put("hc_bsa_20", "hcBsa20");
		this.hashFields.put("rf_40_qty", "rf40Qty");
		this.hashFields.put("mt_20", "mt20");
		this.hashFields.put("rlane_cd", "rlaneCd");
		this.hashFields.put("mt_40", "mt40");
		this.hashFields.put("hc_ld_20", "hcLd20");
		this.hashFields.put("full_20", "full20");
		this.hashFields.put("mt_teu", "mtTeu");
		this.hashFields.put("all_wgt", "allWgt");
		this.hashFields.put("full_40", "full40");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("pre_fr", "preFr");
		this.hashFields.put("vps_port_cd", "vpsPortCd");
		this.hashFields.put("over_slot", "overSlot");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("hc_ld_40", "hcLd40");
		this.hashFields.put("mt_wt", "mtWt");
		this.hashFields.put("jo_rgn_cd", "joRgnCd");
		this.hashFields.put("vps_etd_dt", "vpsEtdDt");
		this.hashFields.put("super_cd1", "superCd1");
		this.hashFields.put("skd_voy_no", "skdVoyNo");
		this.hashFields.put("over_wgt", "overWgt");
		this.hashFields.put("grand_ttl_slot", "grandTtlSlot");
		this.hashFields.put("all_teu", "allTeu");
		this.hashFields.put("skd_dir_cd", "skdDirCd");
		this.hashFields.put("ak_unit", "akUnit");
		this.hashFields.put("vvd", "vvd");
		this.hashFields.put("slan_cd", "slanCd");
		this.hashFields.put("source", "source");
		this.hashFields.put("pre_to", "preTo");
		this.hashFields.put("opr_cd", "oprCd");
		this.hashFields.put("grand_ttl_wgt", "grandTtlWgt");
		return this.hashFields;
	}
	
	/**
	 * Column Info
	 * @return hcBsa40
	 */
	public String getHcBsa40() {
		return this.hcBsa40;
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
	 * @return hcLd45
	 */
	public String getHcLd45() {
		return this.hcLd45;
	}
	
	/**
	 * Column Info
	 * @return rf20Qty
	 */
	public String getRf20Qty() {
		return this.rf20Qty;
	}
	
	/**
	 * Column Info
	 * @return hcBsa45
	 */
	public String getHcBsa45() {
		return this.hcBsa45;
	}
	
	/**
	 * Column Info
	 * @return akVoid
	 */
	public String getAkVoid() {
		return this.akVoid;
	}
	
	/**
	 * Column Info
	 * @return hcBsa20
	 */
	public String getHcBsa20() {
		return this.hcBsa20;
	}
	
	/**
	 * Column Info
	 * @return rf40Qty
	 */
	public String getRf40Qty() {
		return this.rf40Qty;
	}
	
	/**
	 * Column Info
	 * @return mt20
	 */
	public String getMt20() {
		return this.mt20;
	}
	
	/**
	 * Column Info
	 * @return rlaneCd
	 */
	public String getRlaneCd() {
		return this.rlaneCd;
	}
	
	/**
	 * Column Info
	 * @return mt40
	 */
	public String getMt40() {
		return this.mt40;
	}
	
	/**
	 * Column Info
	 * @return hcLd20
	 */
	public String getHcLd20() {
		return this.hcLd20;
	}
	
	/**
	 * Column Info
	 * @return full20
	 */
	public String getFull20() {
		return this.full20;
	}
	
	/**
	 * Column Info
	 * @return mtTeu
	 */
	public String getMtTeu() {
		return this.mtTeu;
	}
	
	/**
	 * Column Info
	 * @return allWgt
	 */
	public String getAllWgt() {
		return this.allWgt;
	}
	
	/**
	 * Column Info
	 * @return full40
	 */
	public String getFull40() {
		return this.full40;
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
	 * @return preFr
	 */
	public String getPreFr() {
		return this.preFr;
	}
	
	/**
	 * Column Info
	 * @return vpsPortCd
	 */
	public String getVpsPortCd() {
		return this.vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @return overSlot
	 */
	public String getOverSlot() {
		return this.overSlot;
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
	 * @return hcLd40
	 */
	public String getHcLd40() {
		return this.hcLd40;
	}
	
	/**
	 * Column Info
	 * @return mtWt
	 */
	public String getMtWt() {
		return this.mtWt;
	}
	
	/**
	 * Column Info
	 * @return joRgnCd
	 */
	public String getJoRgnCd() {
		return this.joRgnCd;
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
	 * @return superCd1
	 */
	public String getSuperCd1() {
		return this.superCd1;
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
	 * @return overWgt
	 */
	public String getOverWgt() {
		return this.overWgt;
	}
	
	/**
	 * Column Info
	 * @return grandTtlSlot
	 */
	public String getGrandTtlSlot() {
		return this.grandTtlSlot;
	}
	
	/**
	 * Column Info
	 * @return allTeu
	 */
	public String getAllTeu() {
		return this.allTeu;
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
	 * @return akUnit
	 */
	public String getAkUnit() {
		return this.akUnit;
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
	 * @return slanCd
	 */
	public String getSlanCd() {
		return this.slanCd;
	}
	
	/**
	 * Column Info
	 * @return source
	 */
	public String getSource() {
		return this.source;
	}
	
	/**
	 * Column Info
	 * @return preTo
	 */
	public String getPreTo() {
		return this.preTo;
	}
	
	/**
	 * Column Info
	 * @return oprCd
	 */
	public String getOprCd() {
		return this.oprCd;
	}
	
	/**
	 * Column Info
	 * @return grandTtlWgt
	 */
	public String getGrandTtlWgt() {
		return this.grandTtlWgt;
	}
	

	/**
	 * Column Info
	 * @param hcBsa40
	 */
	public void setHcBsa40(String hcBsa40) {
		this.hcBsa40 = hcBsa40;
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
	 * @param hcLd45
	 */
	public void setHcLd45(String hcLd45) {
		this.hcLd45 = hcLd45;
	}
	
	/**
	 * Column Info
	 * @param rf20Qty
	 */
	public void setRf20Qty(String rf20Qty) {
		this.rf20Qty = rf20Qty;
	}
	
	/**
	 * Column Info
	 * @param hcBsa45
	 */
	public void setHcBsa45(String hcBsa45) {
		this.hcBsa45 = hcBsa45;
	}
	
	/**
	 * Column Info
	 * @param akVoid
	 */
	public void setAkVoid(String akVoid) {
		this.akVoid = akVoid;
	}
	
	/**
	 * Column Info
	 * @param hcBsa20
	 */
	public void setHcBsa20(String hcBsa20) {
		this.hcBsa20 = hcBsa20;
	}
	
	/**
	 * Column Info
	 * @param rf40Qty
	 */
	public void setRf40Qty(String rf40Qty) {
		this.rf40Qty = rf40Qty;
	}
	
	/**
	 * Column Info
	 * @param mt20
	 */
	public void setMt20(String mt20) {
		this.mt20 = mt20;
	}
	
	/**
	 * Column Info
	 * @param rlaneCd
	 */
	public void setRlaneCd(String rlaneCd) {
		this.rlaneCd = rlaneCd;
	}
	
	/**
	 * Column Info
	 * @param mt40
	 */
	public void setMt40(String mt40) {
		this.mt40 = mt40;
	}
	
	/**
	 * Column Info
	 * @param hcLd20
	 */
	public void setHcLd20(String hcLd20) {
		this.hcLd20 = hcLd20;
	}
	
	/**
	 * Column Info
	 * @param full20
	 */
	public void setFull20(String full20) {
		this.full20 = full20;
	}
	
	/**
	 * Column Info
	 * @param mtTeu
	 */
	public void setMtTeu(String mtTeu) {
		this.mtTeu = mtTeu;
	}
	
	/**
	 * Column Info
	 * @param allWgt
	 */
	public void setAllWgt(String allWgt) {
		this.allWgt = allWgt;
	}
	
	/**
	 * Column Info
	 * @param full40
	 */
	public void setFull40(String full40) {
		this.full40 = full40;
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
	 * @param preFr
	 */
	public void setPreFr(String preFr) {
		this.preFr = preFr;
	}
	
	/**
	 * Column Info
	 * @param vpsPortCd
	 */
	public void setVpsPortCd(String vpsPortCd) {
		this.vpsPortCd = vpsPortCd;
	}
	
	/**
	 * Column Info
	 * @param overSlot
	 */
	public void setOverSlot(String overSlot) {
		this.overSlot = overSlot;
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
	 * @param hcLd40
	 */
	public void setHcLd40(String hcLd40) {
		this.hcLd40 = hcLd40;
	}
	
	/**
	 * Column Info
	 * @param mtWt
	 */
	public void setMtWt(String mtWt) {
		this.mtWt = mtWt;
	}
	
	/**
	 * Column Info
	 * @param joRgnCd
	 */
	public void setJoRgnCd(String joRgnCd) {
		this.joRgnCd = joRgnCd;
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
	 * @param superCd1
	 */
	public void setSuperCd1(String superCd1) {
		this.superCd1 = superCd1;
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
	 * @param overWgt
	 */
	public void setOverWgt(String overWgt) {
		this.overWgt = overWgt;
	}
	
	/**
	 * Column Info
	 * @param grandTtlSlot
	 */
	public void setGrandTtlSlot(String grandTtlSlot) {
		this.grandTtlSlot = grandTtlSlot;
	}
	
	/**
	 * Column Info
	 * @param allTeu
	 */
	public void setAllTeu(String allTeu) {
		this.allTeu = allTeu;
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
	 * @param akUnit
	 */
	public void setAkUnit(String akUnit) {
		this.akUnit = akUnit;
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
	 * @param slanCd
	 */
	public void setSlanCd(String slanCd) {
		this.slanCd = slanCd;
	}
	
	/**
	 * Column Info
	 * @param source
	 */
	public void setSource(String source) {
		this.source = source;
	}
	
	/**
	 * Column Info
	 * @param preTo
	 */
	public void setPreTo(String preTo) {
		this.preTo = preTo;
	}
	
	/**
	 * Column Info
	 * @param oprCd
	 */
	public void setOprCd(String oprCd) {
		this.oprCd = oprCd;
	}
	
	/**
	 * Column Info
	 * @param grandTtlWgt
	 */
	public void setGrandTtlWgt(String grandTtlWgt) {
		this.grandTtlWgt = grandTtlWgt;
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
		setHcBsa40(JSPUtil.getParameter(request, prefix + "hc_bsa_40", ""));
		setVslCd(JSPUtil.getParameter(request, prefix + "vsl_cd", ""));
		setHcLd45(JSPUtil.getParameter(request, prefix + "hc_ld_45", ""));
		setRf20Qty(JSPUtil.getParameter(request, prefix + "rf_20_qty", ""));
		setHcBsa45(JSPUtil.getParameter(request, prefix + "hc_bsa_45", ""));
		setAkVoid(JSPUtil.getParameter(request, prefix + "ak_void", ""));
		setHcBsa20(JSPUtil.getParameter(request, prefix + "hc_bsa_20", ""));
		setRf40Qty(JSPUtil.getParameter(request, prefix + "rf_40_qty", ""));
		setMt20(JSPUtil.getParameter(request, prefix + "mt_20", ""));
		setRlaneCd(JSPUtil.getParameter(request, prefix + "rlane_cd", ""));
		setMt40(JSPUtil.getParameter(request, prefix + "mt_40", ""));
		setHcLd20(JSPUtil.getParameter(request, prefix + "hc_ld_20", ""));
		setFull20(JSPUtil.getParameter(request, prefix + "full_20", ""));
		setMtTeu(JSPUtil.getParameter(request, prefix + "mt_teu", ""));
		setAllWgt(JSPUtil.getParameter(request, prefix + "all_wgt", ""));
		setFull40(JSPUtil.getParameter(request, prefix + "full_40", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setPreFr(JSPUtil.getParameter(request, prefix + "pre_fr", ""));
		setVpsPortCd(JSPUtil.getParameter(request, prefix + "vps_port_cd", ""));
		setOverSlot(JSPUtil.getParameter(request, prefix + "over_slot", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setHcLd40(JSPUtil.getParameter(request, prefix + "hc_ld_40", ""));
		setMtWt(JSPUtil.getParameter(request, prefix + "mt_wt", ""));
		setJoRgnCd(JSPUtil.getParameter(request, prefix + "jo_rgn_cd", ""));
		setVpsEtdDt(JSPUtil.getParameter(request, prefix + "vps_etd_dt", ""));
		setSuperCd1(JSPUtil.getParameter(request, prefix + "super_cd1", ""));
		setSkdVoyNo(JSPUtil.getParameter(request, prefix + "skd_voy_no", ""));
		setOverWgt(JSPUtil.getParameter(request, prefix + "over_wgt", ""));
		setGrandTtlSlot(JSPUtil.getParameter(request, prefix + "grand_ttl_slot", ""));
		setAllTeu(JSPUtil.getParameter(request, prefix + "all_teu", ""));
		setSkdDirCd(JSPUtil.getParameter(request, prefix + "skd_dir_cd", ""));
		setAkUnit(JSPUtil.getParameter(request, prefix + "ak_unit", ""));
		setVvd(JSPUtil.getParameter(request, prefix + "vvd", ""));
		setSlanCd(JSPUtil.getParameter(request, prefix + "slan_cd", ""));
		setSource(JSPUtil.getParameter(request, prefix + "source", ""));
		setPreTo(JSPUtil.getParameter(request, prefix + "pre_to", ""));
		setOprCd(JSPUtil.getParameter(request, prefix + "opr_cd", ""));
		setGrandTtlWgt(JSPUtil.getParameter(request, prefix + "grand_ttl_wgt", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return TdrLoadVO[]
	 */
	public TdrLoadVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return TdrLoadVO[]
	 */
	public TdrLoadVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		TdrLoadVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] hcBsa40 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_40", length));
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] hcLd45 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_45", length));
			String[] rf20Qty = (JSPUtil.getParameter(request, prefix	+ "rf_20_qty", length));
			String[] hcBsa45 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_45", length));
			String[] akVoid = (JSPUtil.getParameter(request, prefix	+ "ak_void", length));
			String[] hcBsa20 = (JSPUtil.getParameter(request, prefix	+ "hc_bsa_20", length));
			String[] rf40Qty = (JSPUtil.getParameter(request, prefix	+ "rf_40_qty", length));
			String[] mt20 = (JSPUtil.getParameter(request, prefix	+ "mt_20", length));
			String[] rlaneCd = (JSPUtil.getParameter(request, prefix	+ "rlane_cd", length));
			String[] mt40 = (JSPUtil.getParameter(request, prefix	+ "mt_40", length));
			String[] hcLd20 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_20", length));
			String[] full20 = (JSPUtil.getParameter(request, prefix	+ "full_20", length));
			String[] mtTeu = (JSPUtil.getParameter(request, prefix	+ "mt_teu", length));
			String[] allWgt = (JSPUtil.getParameter(request, prefix	+ "all_wgt", length));
			String[] full40 = (JSPUtil.getParameter(request, prefix	+ "full_40", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] preFr = (JSPUtil.getParameter(request, prefix	+ "pre_fr", length));
			String[] vpsPortCd = (JSPUtil.getParameter(request, prefix	+ "vps_port_cd", length));
			String[] overSlot = (JSPUtil.getParameter(request, prefix	+ "over_slot", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] hcLd40 = (JSPUtil.getParameter(request, prefix	+ "hc_ld_40", length));
			String[] mtWt = (JSPUtil.getParameter(request, prefix	+ "mt_wt", length));
			String[] joRgnCd = (JSPUtil.getParameter(request, prefix	+ "jo_rgn_cd", length));
			String[] vpsEtdDt = (JSPUtil.getParameter(request, prefix	+ "vps_etd_dt", length));
			String[] superCd1 = (JSPUtil.getParameter(request, prefix	+ "super_cd1", length));
			String[] skdVoyNo = (JSPUtil.getParameter(request, prefix	+ "skd_voy_no", length));
			String[] overWgt = (JSPUtil.getParameter(request, prefix	+ "over_wgt", length));
			String[] grandTtlSlot = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_slot", length));
			String[] allTeu = (JSPUtil.getParameter(request, prefix	+ "all_teu", length));
			String[] skdDirCd = (JSPUtil.getParameter(request, prefix	+ "skd_dir_cd", length));
			String[] akUnit = (JSPUtil.getParameter(request, prefix	+ "ak_unit", length));
			String[] vvd = (JSPUtil.getParameter(request, prefix	+ "vvd", length));
			String[] slanCd = (JSPUtil.getParameter(request, prefix	+ "slan_cd", length));
			String[] source = (JSPUtil.getParameter(request, prefix	+ "source", length));
			String[] preTo = (JSPUtil.getParameter(request, prefix	+ "pre_to", length));
			String[] oprCd = (JSPUtil.getParameter(request, prefix	+ "opr_cd", length));
			String[] grandTtlWgt = (JSPUtil.getParameter(request, prefix	+ "grand_ttl_wgt", length));
			
			for (int i = 0; i < length; i++) {
				model = new TdrLoadVO();
				if (hcBsa40[i] != null)
					model.setHcBsa40(hcBsa40[i]);
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (hcLd45[i] != null)
					model.setHcLd45(hcLd45[i]);
				if (rf20Qty[i] != null)
					model.setRf20Qty(rf20Qty[i]);
				if (hcBsa45[i] != null)
					model.setHcBsa45(hcBsa45[i]);
				if (akVoid[i] != null)
					model.setAkVoid(akVoid[i]);
				if (hcBsa20[i] != null)
					model.setHcBsa20(hcBsa20[i]);
				if (rf40Qty[i] != null)
					model.setRf40Qty(rf40Qty[i]);
				if (mt20[i] != null)
					model.setMt20(mt20[i]);
				if (rlaneCd[i] != null)
					model.setRlaneCd(rlaneCd[i]);
				if (mt40[i] != null)
					model.setMt40(mt40[i]);
				if (hcLd20[i] != null)
					model.setHcLd20(hcLd20[i]);
				if (full20[i] != null)
					model.setFull20(full20[i]);
				if (mtTeu[i] != null)
					model.setMtTeu(mtTeu[i]);
				if (allWgt[i] != null)
					model.setAllWgt(allWgt[i]);
				if (full40[i] != null)
					model.setFull40(full40[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (preFr[i] != null)
					model.setPreFr(preFr[i]);
				if (vpsPortCd[i] != null)
					model.setVpsPortCd(vpsPortCd[i]);
				if (overSlot[i] != null)
					model.setOverSlot(overSlot[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (hcLd40[i] != null)
					model.setHcLd40(hcLd40[i]);
				if (mtWt[i] != null)
					model.setMtWt(mtWt[i]);
				if (joRgnCd[i] != null)
					model.setJoRgnCd(joRgnCd[i]);
				if (vpsEtdDt[i] != null)
					model.setVpsEtdDt(vpsEtdDt[i]);
				if (superCd1[i] != null)
					model.setSuperCd1(superCd1[i]);
				if (skdVoyNo[i] != null)
					model.setSkdVoyNo(skdVoyNo[i]);
				if (overWgt[i] != null)
					model.setOverWgt(overWgt[i]);
				if (grandTtlSlot[i] != null)
					model.setGrandTtlSlot(grandTtlSlot[i]);
				if (allTeu[i] != null)
					model.setAllTeu(allTeu[i]);
				if (skdDirCd[i] != null)
					model.setSkdDirCd(skdDirCd[i]);
				if (akUnit[i] != null)
					model.setAkUnit(akUnit[i]);
				if (vvd[i] != null)
					model.setVvd(vvd[i]);
				if (slanCd[i] != null)
					model.setSlanCd(slanCd[i]);
				if (source[i] != null)
					model.setSource(source[i]);
				if (preTo[i] != null)
					model.setPreTo(preTo[i]);
				if (oprCd[i] != null)
					model.setOprCd(oprCd[i]);
				if (grandTtlWgt[i] != null)
					model.setGrandTtlWgt(grandTtlWgt[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getTdrLoadVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return TdrLoadVO[]
	 */
	public TdrLoadVO[] getTdrLoadVOs(){
		TdrLoadVO[] vos = (TdrLoadVO[])models.toArray(new TdrLoadVO[models.size()]);
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
		this.hcBsa40 = this.hcBsa40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd45 = this.hcLd45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf20Qty = this.rf20Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa45 = this.hcBsa45 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akVoid = this.akVoid .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcBsa20 = this.hcBsa20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rf40Qty = this.rf40Qty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt20 = this.mt20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rlaneCd = this.rlaneCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mt40 = this.mt40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd20 = this.hcLd20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full20 = this.full20 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtTeu = this.mtTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allWgt = this.allWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.full40 = this.full40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preFr = this.preFr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsPortCd = this.vpsPortCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overSlot = this.overSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.hcLd40 = this.hcLd40 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtWt = this.mtWt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.joRgnCd = this.joRgnCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vpsEtdDt = this.vpsEtdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.superCd1 = this.superCd1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdVoyNo = this.skdVoyNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.overWgt = this.overWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlSlot = this.grandTtlSlot .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.allTeu = this.allTeu .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.skdDirCd = this.skdDirCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.akUnit = this.akUnit .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vvd = this.vvd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.slanCd = this.slanCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.source = this.source .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.preTo = this.preTo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.oprCd = this.oprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.grandTtlWgt = this.grandTtlWgt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
