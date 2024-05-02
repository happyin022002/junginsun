/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : KorMakeFlatFileMACAMDVO.java
*@FileTitle : KorMakeFlatFileMACAMDVO
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.03 손윤석 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.korea.vo;

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

public class KorMakeFlatFileMACAMDVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<KorMakeFlatFileMACAMDVO> models = new ArrayList<KorMakeFlatFileMACAMDVO>();
	
	/* Column Info */
	private String vslCd = null;
	/* Column Info */
	private String bkgPolUn = null;
	/* Column Info */
	private String vslFlag = null;
	/* Column Info */
	private String msnNo = null;
	/* Column Info */
	private String meaQty = null;
	/* Column Info */
	private String mtonTp = null;
	/* Column Info */
	private String kcdTp = null;
	/* Column Info */
	private String blNo = null;
	/* Column Info */
	private String mrnNo = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String callYear = null;
	/* Column Info */
	private String flatData = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String ntfyCustAddr = null;
	/* Column Info */
	private String cgoDesc2 = null;
	/* Column Info */
	private String cgoDesc1 = null;
	/* Column Info */
	private String callSign = null;
	/* Column Info */
	private String shprCustAddr = null;
	/* Column Info */
	private String discMd = null;
	/* Column Info */
	private String bizNo = null;
	/* Column Info */
	private String discCo = null;
	/* Column Info */
	private String shprCustNm = null;
	/* Column Info */
	private String kvInCnt = null;
	/* Column Info */
	private String cneeCustAddr = null;
	/* Column Info */
	private String pkgCd = null;
	/* Column Info */
	private String bondAreaCode = null;
	/* Column Info */
	private String vslName = null;
	/* Column Info */
	private String quayCd2 = null;
	/* Column Info */
	private String kvInCnt2 = null;
	/* Column Info */
	private String blTp = null;
	/* Column Info */
	private String imoClass1 = null;
	/* Column Info */
	private String cneeCustNm = null;
	/* Column Info */
	private String imoClass2 = null;
	/* Column Info */
	private String imoClass3 = null;
	/* Column Info */
	private String ktPa2 = null;
	/* Column Info */
	private String bkgPodUn = null;
	/* Column Info */
	private String ntfyCustNm = null;
	/* Column Info */
	private String cgoCd = null;
	/* Column Info */
	private String wgtQty = null;
	/* Column Info */
	private String bound = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new HashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new HashMap<String, String>();
	
	public KorMakeFlatFileMACAMDVO() {}

	public KorMakeFlatFileMACAMDVO(String ibflag, String pagerows, String bound, String kvInCnt2, String callYear, String callSign, String ktPa2, String mrnNo, String vslCd, String vslName, String vslFlag, String kvInCnt, String blNo, String msnNo, String blTp, String kcdTp, String discMd, String bkgPolUn, String bkgPodUn, String quayCd2, String bondAreaCode, String pkgCd, String cgoCd, String cgoDesc1, String cgoDesc2, String imoClass1, String imoClass2, String imoClass3, String wgtQty, String mtonTp, String meaQty, String shprCustNm, String shprCustAddr, String cneeCustNm, String cneeCustAddr, String ntfyCustNm, String ntfyCustAddr, String discCo, String bizNo, String flatData) {
		this.vslCd = vslCd;
		this.bkgPolUn = bkgPolUn;
		this.vslFlag = vslFlag;
		this.msnNo = msnNo;
		this.meaQty = meaQty;
		this.mtonTp = mtonTp;
		this.kcdTp = kcdTp;
		this.blNo = blNo;
		this.mrnNo = mrnNo;
		this.pagerows = pagerows;
		this.callYear = callYear;
		this.flatData = flatData;
		this.ibflag = ibflag;
		this.ntfyCustAddr = ntfyCustAddr;
		this.cgoDesc2 = cgoDesc2;
		this.cgoDesc1 = cgoDesc1;
		this.callSign = callSign;
		this.shprCustAddr = shprCustAddr;
		this.discMd = discMd;
		this.bizNo = bizNo;
		this.discCo = discCo;
		this.shprCustNm = shprCustNm;
		this.kvInCnt = kvInCnt;
		this.cneeCustAddr = cneeCustAddr;
		this.pkgCd = pkgCd;
		this.bondAreaCode = bondAreaCode;
		this.vslName = vslName;
		this.quayCd2 = quayCd2;
		this.kvInCnt2 = kvInCnt2;
		this.blTp = blTp;
		this.imoClass1 = imoClass1;
		this.cneeCustNm = cneeCustNm;
		this.imoClass2 = imoClass2;
		this.imoClass3 = imoClass3;
		this.ktPa2 = ktPa2;
		this.bkgPodUn = bkgPodUn;
		this.ntfyCustNm = ntfyCustNm;
		this.cgoCd = cgoCd;
		this.wgtQty = wgtQty;
		this.bound = bound;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("vsl_cd", getVslCd());
		this.hashColumns.put("bkg_pol_un", getBkgPolUn());
		this.hashColumns.put("vsl_flag", getVslFlag());
		this.hashColumns.put("msn_no", getMsnNo());
		this.hashColumns.put("mea_qty", getMeaQty());
		this.hashColumns.put("mton_tp", getMtonTp());
		this.hashColumns.put("kcd_tp", getKcdTp());
		this.hashColumns.put("bl_no", getBlNo());
		this.hashColumns.put("mrn_no", getMrnNo());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("call_year", getCallYear());
		this.hashColumns.put("flat_data", getFlatData());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("ntfy_cust_addr", getNtfyCustAddr());
		this.hashColumns.put("cgo_desc2", getCgoDesc2());
		this.hashColumns.put("cgo_desc1", getCgoDesc1());
		this.hashColumns.put("call_sign", getCallSign());
		this.hashColumns.put("shpr_cust_addr", getShprCustAddr());
		this.hashColumns.put("disc_md", getDiscMd());
		this.hashColumns.put("biz_no", getBizNo());
		this.hashColumns.put("disc_co", getDiscCo());
		this.hashColumns.put("shpr_cust_nm", getShprCustNm());
		this.hashColumns.put("kv_in_cnt", getKvInCnt());
		this.hashColumns.put("cnee_cust_addr", getCneeCustAddr());
		this.hashColumns.put("pkg_cd", getPkgCd());
		this.hashColumns.put("bond_area_code", getBondAreaCode());
		this.hashColumns.put("vsl_name", getVslName());
		this.hashColumns.put("quay_cd2", getQuayCd2());
		this.hashColumns.put("kv_in_cnt2", getKvInCnt2());
		this.hashColumns.put("bl_tp", getBlTp());
		this.hashColumns.put("imo_class1", getImoClass1());
		this.hashColumns.put("cnee_cust_nm", getCneeCustNm());
		this.hashColumns.put("imo_class2", getImoClass2());
		this.hashColumns.put("imo_class3", getImoClass3());
		this.hashColumns.put("kt_pa2", getKtPa2());
		this.hashColumns.put("bkg_pod_un", getBkgPodUn());
		this.hashColumns.put("ntfy_cust_nm", getNtfyCustNm());
		this.hashColumns.put("cgo_cd", getCgoCd());
		this.hashColumns.put("wgt_qty", getWgtQty());
		this.hashColumns.put("bound", getBound());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("vsl_cd", "vslCd");
		this.hashFields.put("bkg_pol_un", "bkgPolUn");
		this.hashFields.put("vsl_flag", "vslFlag");
		this.hashFields.put("msn_no", "msnNo");
		this.hashFields.put("mea_qty", "meaQty");
		this.hashFields.put("mton_tp", "mtonTp");
		this.hashFields.put("kcd_tp", "kcdTp");
		this.hashFields.put("bl_no", "blNo");
		this.hashFields.put("mrn_no", "mrnNo");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("call_year", "callYear");
		this.hashFields.put("flat_data", "flatData");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("ntfy_cust_addr", "ntfyCustAddr");
		this.hashFields.put("cgo_desc2", "cgoDesc2");
		this.hashFields.put("cgo_desc1", "cgoDesc1");
		this.hashFields.put("call_sign", "callSign");
		this.hashFields.put("shpr_cust_addr", "shprCustAddr");
		this.hashFields.put("disc_md", "discMd");
		this.hashFields.put("biz_no", "bizNo");
		this.hashFields.put("disc_co", "discCo");
		this.hashFields.put("shpr_cust_nm", "shprCustNm");
		this.hashFields.put("kv_in_cnt", "kvInCnt");
		this.hashFields.put("cnee_cust_addr", "cneeCustAddr");
		this.hashFields.put("pkg_cd", "pkgCd");
		this.hashFields.put("bond_area_code", "bondAreaCode");
		this.hashFields.put("vsl_name", "vslName");
		this.hashFields.put("quay_cd2", "quayCd2");
		this.hashFields.put("kv_in_cnt2", "kvInCnt2");
		this.hashFields.put("bl_tp", "blTp");
		this.hashFields.put("imo_class1", "imoClass1");
		this.hashFields.put("cnee_cust_nm", "cneeCustNm");
		this.hashFields.put("imo_class2", "imoClass2");
		this.hashFields.put("imo_class3", "imoClass3");
		this.hashFields.put("kt_pa2", "ktPa2");
		this.hashFields.put("bkg_pod_un", "bkgPodUn");
		this.hashFields.put("ntfy_cust_nm", "ntfyCustNm");
		this.hashFields.put("cgo_cd", "cgoCd");
		this.hashFields.put("wgt_qty", "wgtQty");
		this.hashFields.put("bound", "bound");
		return this.hashFields;
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
	 * @return bkgPolUn
	 */
	public String getBkgPolUn() {
		return this.bkgPolUn;
	}
	
	/**
	 * Column Info
	 * @return vslFlag
	 */
	public String getVslFlag() {
		return this.vslFlag;
	}
	
	/**
	 * Column Info
	 * @return msnNo
	 */
	public String getMsnNo() {
		return this.msnNo;
	}
	
	/**
	 * Column Info
	 * @return meaQty
	 */
	public String getMeaQty() {
		return this.meaQty;
	}
	
	/**
	 * Column Info
	 * @return mtonTp
	 */
	public String getMtonTp() {
		return this.mtonTp;
	}
	
	/**
	 * Column Info
	 * @return kcdTp
	 */
	public String getKcdTp() {
		return this.kcdTp;
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
	 * @return mrnNo
	 */
	public String getMrnNo() {
		return this.mrnNo;
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
	 * @return callYear
	 */
	public String getCallYear() {
		return this.callYear;
	}
	
	/**
	 * Column Info
	 * @return flatData
	 */
	public String getFlatData() {
		return this.flatData;
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
	 * @return ntfyCustAddr
	 */
	public String getNtfyCustAddr() {
		return this.ntfyCustAddr;
	}
	
	/**
	 * Column Info
	 * @return cgoDesc2
	 */
	public String getCgoDesc2() {
		return this.cgoDesc2;
	}
	
	/**
	 * Column Info
	 * @return cgoDesc1
	 */
	public String getCgoDesc1() {
		return this.cgoDesc1;
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
	 * @return shprCustAddr
	 */
	public String getShprCustAddr() {
		return this.shprCustAddr;
	}
	
	/**
	 * Column Info
	 * @return discMd
	 */
	public String getDiscMd() {
		return this.discMd;
	}
	
	/**
	 * Column Info
	 * @return bizNo
	 */
	public String getBizNo() {
		return this.bizNo;
	}
	
	/**
	 * Column Info
	 * @return discCo
	 */
	public String getDiscCo() {
		return this.discCo;
	}
	
	/**
	 * Column Info
	 * @return shprCustNm
	 */
	public String getShprCustNm() {
		return this.shprCustNm;
	}
	
	/**
	 * Column Info
	 * @return kvInCnt
	 */
	public String getKvInCnt() {
		return this.kvInCnt;
	}
	
	/**
	 * Column Info
	 * @return cneeCustAddr
	 */
	public String getCneeCustAddr() {
		return this.cneeCustAddr;
	}
	
	/**
	 * Column Info
	 * @return pkgCd
	 */
	public String getPkgCd() {
		return this.pkgCd;
	}
	
	/**
	 * Column Info
	 * @return bondAreaCode
	 */
	public String getBondAreaCode() {
		return this.bondAreaCode;
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
	 * @return quayCd2
	 */
	public String getQuayCd2() {
		return this.quayCd2;
	}
	
	/**
	 * Column Info
	 * @return kvInCnt2
	 */
	public String getKvInCnt2() {
		return this.kvInCnt2;
	}
	
	/**
	 * Column Info
	 * @return blTp
	 */
	public String getBlTp() {
		return this.blTp;
	}
	
	/**
	 * Column Info
	 * @return imoClass1
	 */
	public String getImoClass1() {
		return this.imoClass1;
	}
	
	/**
	 * Column Info
	 * @return cneeCustNm
	 */
	public String getCneeCustNm() {
		return this.cneeCustNm;
	}
	
	/**
	 * Column Info
	 * @return imoClass2
	 */
	public String getImoClass2() {
		return this.imoClass2;
	}
	
	/**
	 * Column Info
	 * @return imoClass3
	 */
	public String getImoClass3() {
		return this.imoClass3;
	}
	
	/**
	 * Column Info
	 * @return ktPa2
	 */
	public String getKtPa2() {
		return this.ktPa2;
	}
	
	/**
	 * Column Info
	 * @return bkgPodUn
	 */
	public String getBkgPodUn() {
		return this.bkgPodUn;
	}
	
	/**
	 * Column Info
	 * @return ntfyCustNm
	 */
	public String getNtfyCustNm() {
		return this.ntfyCustNm;
	}
	
	/**
	 * Column Info
	 * @return cgoCd
	 */
	public String getCgoCd() {
		return this.cgoCd;
	}
	
	/**
	 * Column Info
	 * @return wgtQty
	 */
	public String getWgtQty() {
		return this.wgtQty;
	}
	
	/**
	 * Column Info
	 * @return bound
	 */
	public String getBound() {
		return this.bound;
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
	 * @param bkgPolUn
	 */
	public void setBkgPolUn(String bkgPolUn) {
		this.bkgPolUn = bkgPolUn;
	}
	
	/**
	 * Column Info
	 * @param vslFlag
	 */
	public void setVslFlag(String vslFlag) {
		this.vslFlag = vslFlag;
	}
	
	/**
	 * Column Info
	 * @param msnNo
	 */
	public void setMsnNo(String msnNo) {
		this.msnNo = msnNo;
	}
	
	/**
	 * Column Info
	 * @param meaQty
	 */
	public void setMeaQty(String meaQty) {
		this.meaQty = meaQty;
	}
	
	/**
	 * Column Info
	 * @param mtonTp
	 */
	public void setMtonTp(String mtonTp) {
		this.mtonTp = mtonTp;
	}
	
	/**
	 * Column Info
	 * @param kcdTp
	 */
	public void setKcdTp(String kcdTp) {
		this.kcdTp = kcdTp;
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
	 * @param mrnNo
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
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
	 * @param callYear
	 */
	public void setCallYear(String callYear) {
		this.callYear = callYear;
	}
	
	/**
	 * Column Info
	 * @param flatData
	 */
	public void setFlatData(String flatData) {
		this.flatData = flatData;
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
	 * @param ntfyCustAddr
	 */
	public void setNtfyCustAddr(String ntfyCustAddr) {
		this.ntfyCustAddr = ntfyCustAddr;
	}
	
	/**
	 * Column Info
	 * @param cgoDesc2
	 */
	public void setCgoDesc2(String cgoDesc2) {
		this.cgoDesc2 = cgoDesc2;
	}
	
	/**
	 * Column Info
	 * @param cgoDesc1
	 */
	public void setCgoDesc1(String cgoDesc1) {
		this.cgoDesc1 = cgoDesc1;
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
	 * @param shprCustAddr
	 */
	public void setShprCustAddr(String shprCustAddr) {
		this.shprCustAddr = shprCustAddr;
	}
	
	/**
	 * Column Info
	 * @param discMd
	 */
	public void setDiscMd(String discMd) {
		this.discMd = discMd;
	}
	
	/**
	 * Column Info
	 * @param bizNo
	 */
	public void setBizNo(String bizNo) {
		this.bizNo = bizNo;
	}
	
	/**
	 * Column Info
	 * @param discCo
	 */
	public void setDiscCo(String discCo) {
		this.discCo = discCo;
	}
	
	/**
	 * Column Info
	 * @param shprCustNm
	 */
	public void setShprCustNm(String shprCustNm) {
		this.shprCustNm = shprCustNm;
	}
	
	/**
	 * Column Info
	 * @param kvInCnt
	 */
	public void setKvInCnt(String kvInCnt) {
		this.kvInCnt = kvInCnt;
	}
	
	/**
	 * Column Info
	 * @param cneeCustAddr
	 */
	public void setCneeCustAddr(String cneeCustAddr) {
		this.cneeCustAddr = cneeCustAddr;
	}
	
	/**
	 * Column Info
	 * @param pkgCd
	 */
	public void setPkgCd(String pkgCd) {
		this.pkgCd = pkgCd;
	}
	
	/**
	 * Column Info
	 * @param bondAreaCode
	 */
	public void setBondAreaCode(String bondAreaCode) {
		this.bondAreaCode = bondAreaCode;
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
	 * @param quayCd2
	 */
	public void setQuayCd2(String quayCd2) {
		this.quayCd2 = quayCd2;
	}
	
	/**
	 * Column Info
	 * @param kvInCnt2
	 */
	public void setKvInCnt2(String kvInCnt2) {
		this.kvInCnt2 = kvInCnt2;
	}
	
	/**
	 * Column Info
	 * @param blTp
	 */
	public void setBlTp(String blTp) {
		this.blTp = blTp;
	}
	
	/**
	 * Column Info
	 * @param imoClass1
	 */
	public void setImoClass1(String imoClass1) {
		this.imoClass1 = imoClass1;
	}
	
	/**
	 * Column Info
	 * @param cneeCustNm
	 */
	public void setCneeCustNm(String cneeCustNm) {
		this.cneeCustNm = cneeCustNm;
	}
	
	/**
	 * Column Info
	 * @param imoClass2
	 */
	public void setImoClass2(String imoClass2) {
		this.imoClass2 = imoClass2;
	}
	
	/**
	 * Column Info
	 * @param imoClass3
	 */
	public void setImoClass3(String imoClass3) {
		this.imoClass3 = imoClass3;
	}
	
	/**
	 * Column Info
	 * @param ktPa2
	 */
	public void setKtPa2(String ktPa2) {
		this.ktPa2 = ktPa2;
	}
	
	/**
	 * Column Info
	 * @param bkgPodUn
	 */
	public void setBkgPodUn(String bkgPodUn) {
		this.bkgPodUn = bkgPodUn;
	}
	
	/**
	 * Column Info
	 * @param ntfyCustNm
	 */
	public void setNtfyCustNm(String ntfyCustNm) {
		this.ntfyCustNm = ntfyCustNm;
	}
	
	/**
	 * Column Info
	 * @param cgoCd
	 */
	public void setCgoCd(String cgoCd) {
		this.cgoCd = cgoCd;
	}
	
	/**
	 * Column Info
	 * @param wgtQty
	 */
	public void setWgtQty(String wgtQty) {
		this.wgtQty = wgtQty;
	}
	
	/**
	 * Column Info
	 * @param bound
	 */
	public void setBound(String bound) {
		this.bound = bound;
	}
	
	/**
	 * Request 의 데이터를 추출하여 VO 의 멤버변수에 설정.
	 * @param request
	 */
	public void fromRequest(HttpServletRequest request) {
		setVslCd(JSPUtil.getParameter(request, "vsl_cd", ""));
		setBkgPolUn(JSPUtil.getParameter(request, "bkg_pol_un", ""));
		setVslFlag(JSPUtil.getParameter(request, "vsl_flag", ""));
		setMsnNo(JSPUtil.getParameter(request, "msn_no", ""));
		setMeaQty(JSPUtil.getParameter(request, "mea_qty", ""));
		setMtonTp(JSPUtil.getParameter(request, "mton_tp", ""));
		setKcdTp(JSPUtil.getParameter(request, "kcd_tp", ""));
		setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
		setMrnNo(JSPUtil.getParameter(request, "mrn_no", ""));
		setPagerows(JSPUtil.getParameter(request, "pagerows", ""));
		setCallYear(JSPUtil.getParameter(request, "call_year", ""));
		setFlatData(JSPUtil.getParameter(request, "flat_data", ""));
		setIbflag(JSPUtil.getParameter(request, "ibflag", ""));
		setNtfyCustAddr(JSPUtil.getParameter(request, "ntfy_cust_addr", ""));
		setCgoDesc2(JSPUtil.getParameter(request, "cgo_desc2", ""));
		setCgoDesc1(JSPUtil.getParameter(request, "cgo_desc1", ""));
		setCallSign(JSPUtil.getParameter(request, "call_sign", ""));
		setShprCustAddr(JSPUtil.getParameter(request, "shpr_cust_addr", ""));
		setDiscMd(JSPUtil.getParameter(request, "disc_md", ""));
		setBizNo(JSPUtil.getParameter(request, "biz_no", ""));
		setDiscCo(JSPUtil.getParameter(request, "disc_co", ""));
		setShprCustNm(JSPUtil.getParameter(request, "shpr_cust_nm", ""));
		setKvInCnt(JSPUtil.getParameter(request, "kv_in_cnt", ""));
		setCneeCustAddr(JSPUtil.getParameter(request, "cnee_cust_addr", ""));
		setPkgCd(JSPUtil.getParameter(request, "pkg_cd", ""));
		setBondAreaCode(JSPUtil.getParameter(request, "bond_area_code", ""));
		setVslName(JSPUtil.getParameter(request, "vsl_name", ""));
		setQuayCd2(JSPUtil.getParameter(request, "quay_cd2", ""));
		setKvInCnt2(JSPUtil.getParameter(request, "kv_in_cnt2", ""));
		setBlTp(JSPUtil.getParameter(request, "bl_tp", ""));
		setImoClass1(JSPUtil.getParameter(request, "imo_class1", ""));
		setCneeCustNm(JSPUtil.getParameter(request, "cnee_cust_nm", ""));
		setImoClass2(JSPUtil.getParameter(request, "imo_class2", ""));
		setImoClass3(JSPUtil.getParameter(request, "imo_class3", ""));
		setKtPa2(JSPUtil.getParameter(request, "kt_pa2", ""));
		setBkgPodUn(JSPUtil.getParameter(request, "bkg_pod_un", ""));
		setNtfyCustNm(JSPUtil.getParameter(request, "ntfy_cust_nm", ""));
		setCgoCd(JSPUtil.getParameter(request, "cgo_cd", ""));
		setWgtQty(JSPUtil.getParameter(request, "wgt_qty", ""));
		setBound(JSPUtil.getParameter(request, "bound", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return KorMakeFlatFileMACAMDVO[]
	 */
	public KorMakeFlatFileMACAMDVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return KorMakeFlatFileMACAMDVO[]
	 */
	public KorMakeFlatFileMACAMDVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		KorMakeFlatFileMACAMDVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] vslCd = (JSPUtil.getParameter(request, prefix	+ "vsl_cd", length));
			String[] bkgPolUn = (JSPUtil.getParameter(request, prefix	+ "bkg_pol_un", length));
			String[] vslFlag = (JSPUtil.getParameter(request, prefix	+ "vsl_flag", length));
			String[] msnNo = (JSPUtil.getParameter(request, prefix	+ "msn_no", length));
			String[] meaQty = (JSPUtil.getParameter(request, prefix	+ "mea_qty", length));
			String[] mtonTp = (JSPUtil.getParameter(request, prefix	+ "mton_tp", length));
			String[] kcdTp = (JSPUtil.getParameter(request, prefix	+ "kcd_tp", length));
			String[] blNo = (JSPUtil.getParameter(request, prefix	+ "bl_no", length));
			String[] mrnNo = (JSPUtil.getParameter(request, prefix	+ "mrn_no", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] callYear = (JSPUtil.getParameter(request, prefix	+ "call_year", length));
			String[] flatData = (JSPUtil.getParameter(request, prefix	+ "flat_data", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] ntfyCustAddr = (JSPUtil.getParameter(request, prefix	+ "ntfy_cust_addr", length));
			String[] cgoDesc2 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc2", length));
			String[] cgoDesc1 = (JSPUtil.getParameter(request, prefix	+ "cgo_desc1", length));
			String[] callSign = (JSPUtil.getParameter(request, prefix	+ "call_sign", length));
			String[] shprCustAddr = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_addr", length));
			String[] discMd = (JSPUtil.getParameter(request, prefix	+ "disc_md", length));
			String[] bizNo = (JSPUtil.getParameter(request, prefix	+ "biz_no", length));
			String[] discCo = (JSPUtil.getParameter(request, prefix	+ "disc_co", length));
			String[] shprCustNm = (JSPUtil.getParameter(request, prefix	+ "shpr_cust_nm", length));
			String[] kvInCnt = (JSPUtil.getParameter(request, prefix	+ "kv_in_cnt", length));
			String[] cneeCustAddr = (JSPUtil.getParameter(request, prefix	+ "cnee_cust_addr", length));
			String[] pkgCd = (JSPUtil.getParameter(request, prefix	+ "pkg_cd", length));
			String[] bondAreaCode = (JSPUtil.getParameter(request, prefix	+ "bond_area_code", length));
			String[] vslName = (JSPUtil.getParameter(request, prefix	+ "vsl_name", length));
			String[] quayCd2 = (JSPUtil.getParameter(request, prefix	+ "quay_cd2", length));
			String[] kvInCnt2 = (JSPUtil.getParameter(request, prefix	+ "kv_in_cnt2", length));
			String[] blTp = (JSPUtil.getParameter(request, prefix	+ "bl_tp", length));
			String[] imoClass1 = (JSPUtil.getParameter(request, prefix	+ "imo_class1", length));
			String[] cneeCustNm = (JSPUtil.getParameter(request, prefix	+ "cnee_cust_nm", length));
			String[] imoClass2 = (JSPUtil.getParameter(request, prefix	+ "imo_class2", length));
			String[] imoClass3 = (JSPUtil.getParameter(request, prefix	+ "imo_class3", length));
			String[] ktPa2 = (JSPUtil.getParameter(request, prefix	+ "kt_pa2", length));
			String[] bkgPodUn = (JSPUtil.getParameter(request, prefix	+ "bkg_pod_un", length));
			String[] ntfyCustNm = (JSPUtil.getParameter(request, prefix	+ "ntfy_cust_nm", length));
			String[] cgoCd = (JSPUtil.getParameter(request, prefix	+ "cgo_cd", length));
			String[] wgtQty = (JSPUtil.getParameter(request, prefix	+ "wgt_qty", length));
			String[] bound = (JSPUtil.getParameter(request, prefix	+ "bound", length));
			
			for (int i = 0; i < length; i++) {
				model = new KorMakeFlatFileMACAMDVO();
				if (vslCd[i] != null)
					model.setVslCd(vslCd[i]);
				if (bkgPolUn[i] != null)
					model.setBkgPolUn(bkgPolUn[i]);
				if (vslFlag[i] != null)
					model.setVslFlag(vslFlag[i]);
				if (msnNo[i] != null)
					model.setMsnNo(msnNo[i]);
				if (meaQty[i] != null)
					model.setMeaQty(meaQty[i]);
				if (mtonTp[i] != null)
					model.setMtonTp(mtonTp[i]);
				if (kcdTp[i] != null)
					model.setKcdTp(kcdTp[i]);
				if (blNo[i] != null)
					model.setBlNo(blNo[i]);
				if (mrnNo[i] != null)
					model.setMrnNo(mrnNo[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (callYear[i] != null)
					model.setCallYear(callYear[i]);
				if (flatData[i] != null)
					model.setFlatData(flatData[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (ntfyCustAddr[i] != null)
					model.setNtfyCustAddr(ntfyCustAddr[i]);
				if (cgoDesc2[i] != null)
					model.setCgoDesc2(cgoDesc2[i]);
				if (cgoDesc1[i] != null)
					model.setCgoDesc1(cgoDesc1[i]);
				if (callSign[i] != null)
					model.setCallSign(callSign[i]);
				if (shprCustAddr[i] != null)
					model.setShprCustAddr(shprCustAddr[i]);
				if (discMd[i] != null)
					model.setDiscMd(discMd[i]);
				if (bizNo[i] != null)
					model.setBizNo(bizNo[i]);
				if (discCo[i] != null)
					model.setDiscCo(discCo[i]);
				if (shprCustNm[i] != null)
					model.setShprCustNm(shprCustNm[i]);
				if (kvInCnt[i] != null)
					model.setKvInCnt(kvInCnt[i]);
				if (cneeCustAddr[i] != null)
					model.setCneeCustAddr(cneeCustAddr[i]);
				if (pkgCd[i] != null)
					model.setPkgCd(pkgCd[i]);
				if (bondAreaCode[i] != null)
					model.setBondAreaCode(bondAreaCode[i]);
				if (vslName[i] != null)
					model.setVslName(vslName[i]);
				if (quayCd2[i] != null)
					model.setQuayCd2(quayCd2[i]);
				if (kvInCnt2[i] != null)
					model.setKvInCnt2(kvInCnt2[i]);
				if (blTp[i] != null)
					model.setBlTp(blTp[i]);
				if (imoClass1[i] != null)
					model.setImoClass1(imoClass1[i]);
				if (cneeCustNm[i] != null)
					model.setCneeCustNm(cneeCustNm[i]);
				if (imoClass2[i] != null)
					model.setImoClass2(imoClass2[i]);
				if (imoClass3[i] != null)
					model.setImoClass3(imoClass3[i]);
				if (ktPa2[i] != null)
					model.setKtPa2(ktPa2[i]);
				if (bkgPodUn[i] != null)
					model.setBkgPodUn(bkgPodUn[i]);
				if (ntfyCustNm[i] != null)
					model.setNtfyCustNm(ntfyCustNm[i]);
				if (cgoCd[i] != null)
					model.setCgoCd(cgoCd[i]);
				if (wgtQty[i] != null)
					model.setWgtQty(wgtQty[i]);
				if (bound[i] != null)
					model.setBound(bound[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getKorMakeFlatFileMACAMDVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return KorMakeFlatFileMACAMDVO[]
	 */
	public KorMakeFlatFileMACAMDVO[] getKorMakeFlatFileMACAMDVOs(){
		KorMakeFlatFileMACAMDVO[] vos = (KorMakeFlatFileMACAMDVO[])models.toArray(new KorMakeFlatFileMACAMDVO[models.size()]);
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
		this.vslCd = this.vslCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPolUn = this.bkgPolUn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslFlag = this.vslFlag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.msnNo = this.msnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.meaQty = this.meaQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mtonTp = this.mtonTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kcdTp = this.kcdTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blNo = this.blNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.mrnNo = this.mrnNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callYear = this.callYear .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.flatData = this.flatData .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCustAddr = this.ntfyCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc2 = this.cgoDesc2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoDesc1 = this.cgoDesc1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.callSign = this.callSign .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustAddr = this.shprCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discMd = this.discMd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bizNo = this.bizNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.discCo = this.discCo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCustNm = this.shprCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvInCnt = this.kvInCnt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustAddr = this.cneeCustAddr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pkgCd = this.pkgCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bondAreaCode = this.bondAreaCode .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.vslName = this.vslName .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.quayCd2 = this.quayCd2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.kvInCnt2 = this.kvInCnt2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.blTp = this.blTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoClass1 = this.imoClass1 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cneeCustNm = this.cneeCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoClass2 = this.imoClass2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.imoClass3 = this.imoClass3 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ktPa2 = this.ktPa2 .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgPodUn = this.bkgPodUn .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCustNm = this.ntfyCustNm .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cgoCd = this.cgoCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.wgtQty = this.wgtQty .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bound = this.bound .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
