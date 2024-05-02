/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : FullStorageDailyCalcVO.java
*@FileTitle : FullStorageDailyCalcVO
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.28
*@LastModifier : 최덕우
*@LastVersion : 1.0
* 2015.08.28 최덕우 
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.mas.weeklypfmc.weeklycm.vo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.hanjin.framework.component.common.AbstractValueObject;
import com.hanjin.framework.component.util.JSPUtil;

/**
 * Table Value Ojbect<br>
 * 관련 Event 에서 생성, 서버실행요청시 Data 전달역할을 수행하는 Value Object
 *
 * @author 최덕우
 * @since J2EE 1.6
 * @see AbstractValueObject
 */

public class FullStorageDailyCalcVO extends AbstractValueObject {

	private static final long serialVersionUID = 1L;
	
	private Collection<FullStorageDailyCalcVO> models = new ArrayList<FullStorageDailyCalcVO>();
	
	/* Column Info */
	private String cneeCd = null;
	/* Column Info */
	private String calUpdDt = null;
	/* Column Info */
	private String stoCalcSts = null;
	/* Column Info */
	private String scCustSeq = null;
	/* Column Info */
	private String loclTs = null;
	/* Page Number */
	private String pagerows = null;
	/* Column Info */
	private String tesCalc = null;
	/* Column Info */
	private String polCd = null;
	/* Column Info */
	private String costCd = null;
	/* Column Info */
	private String ydChr = null;
	/* Column Info */
	private String scNo = null;
	/* Column Info */
	private String cntrTpszCd = null;
	/* Column Info */
	private String freeXcldDys = null;
	/* Column Info */
	private String dgClss = null;
	/* Column Info */
	private String shprCd = null;
	/* Column Info */
	private String stoToNod = null;
	/* Column Info */
	private String delCd = null;
	/* Column Info */
	private String nodBnd = null;
	/* Column Info */
	private String stoFmDt = null;
	/* Column Info */
	private String podCd = null;
	/* Column Info */
	private String ftTtlDys = null;
	/* Column Info */
	private String bkgNo = null;
	/* Column Info */
	private String stoFmNod = null;
	/* Column Info */
	private String ftAddDys = null;
	/* Column Info */
	private String ovrDys = null;
	/* Column Info */
	private String porCd = null;
	/* Column Info */
	private String bkgBnd = null;
	/* Column Info */
	private String stoToDt = null;
	/* Column Info */
	private String currCd = null;
	/* Column Info */
	private String fCalRslt = null;
	/* Column Info */
	private String fStoSts = null;
	/* Column Info */
	private String condType = null;
	/* Column Info */
	private String rfaNo = null;
	/* VO Data Value( C:Creation, U:Update, D:Delete ) */
	private String ibflag = null;
	/* Column Info */
	private String stayDys = null;
	/* Column Info */
	private String fStoType = null;
	/* Column Info */
	private String rcvTermCd = null;
	/* Column Info */
	private String dfltVndrSeq = null;
	/* Column Info */
	private String stoFmMvmt = null;
	/* Column Info */
	private String stoTtlAmt = null;
	/* Column Info */
	private String calSrc = null;
	/* Column Info */
	private String ntfyCd = null;
	/* Column Info */
	private String rfaCustSeq = null;
	/* Column Info */
	private String deTermCd = null;
	/* Column Info */
	private String ofcCd = null;
	/* Column Info */
	private String usdAmt = null;
	/* Column Info */
	private String freeDys = null;
	/* Column Info */
	private String cntrNo = null;
	/* Column Info */
	private String stoToMvmt = null;
	/* Column Info */
	private String revMon = null;
	/* Column Info */
	private String nodTp = null;

	/*	테이블 컬럼의 값을 저장하는 Hashtable */
	private HashMap<String, String> hashColumns = new LinkedHashMap<String, String>();

	/*	테이블 컬럼에 대응되는 멤버변수를 저장하는 Hashtable */
	private HashMap<String, String> hashFields = new LinkedHashMap<String, String>();
	
	public FullStorageDailyCalcVO() {}

	public FullStorageDailyCalcVO(String ibflag, String pagerows, String cneeCd, String stoCalcSts, String scCustSeq, String loclTs, String tesCalc, String polCd, String costCd, String ydChr, String scNo, String cntrTpszCd, String freeXcldDys, String dgClss, String stoToNod, String shprCd, String delCd, String nodBnd, String stoFmDt, String podCd, String ftTtlDys, String bkgNo, String stoFmNod, String ovrDys, String ftAddDys, String porCd, String bkgBnd, String stoToDt, String currCd, String fCalRslt, String fStoSts, String condType, String rfaNo, String stayDys, String fStoType, String rcvTermCd, String dfltVndrSeq, String stoFmMvmt, String stoTtlAmt, String calSrc, String ntfyCd, String rfaCustSeq, String deTermCd, String ofcCd, String usdAmt, String freeDys, String cntrNo, String stoToMvmt, String revMon, String nodTp, String calUpdDt) {
		this.cneeCd = cneeCd;
		this.calUpdDt = calUpdDt;
		this.stoCalcSts = stoCalcSts;
		this.scCustSeq = scCustSeq;
		this.loclTs = loclTs;
		this.pagerows = pagerows;
		this.tesCalc = tesCalc;
		this.polCd = polCd;
		this.costCd = costCd;
		this.ydChr = ydChr;
		this.scNo = scNo;
		this.cntrTpszCd = cntrTpszCd;
		this.freeXcldDys = freeXcldDys;
		this.dgClss = dgClss;
		this.shprCd = shprCd;
		this.stoToNod = stoToNod;
		this.delCd = delCd;
		this.nodBnd = nodBnd;
		this.stoFmDt = stoFmDt;
		this.podCd = podCd;
		this.ftTtlDys = ftTtlDys;
		this.bkgNo = bkgNo;
		this.stoFmNod = stoFmNod;
		this.ftAddDys = ftAddDys;
		this.ovrDys = ovrDys;
		this.porCd = porCd;
		this.bkgBnd = bkgBnd;
		this.stoToDt = stoToDt;
		this.currCd = currCd;
		this.fCalRslt = fCalRslt;
		this.fStoSts = fStoSts;
		this.condType = condType;
		this.rfaNo = rfaNo;
		this.ibflag = ibflag;
		this.stayDys = stayDys;
		this.fStoType = fStoType;
		this.rcvTermCd = rcvTermCd;
		this.dfltVndrSeq = dfltVndrSeq;
		this.stoFmMvmt = stoFmMvmt;
		this.stoTtlAmt = stoTtlAmt;
		this.calSrc = calSrc;
		this.ntfyCd = ntfyCd;
		this.rfaCustSeq = rfaCustSeq;
		this.deTermCd = deTermCd;
		this.ofcCd = ofcCd;
		this.usdAmt = usdAmt;
		this.freeDys = freeDys;
		this.cntrNo = cntrNo;
		this.stoToMvmt = stoToMvmt;
		this.revMon = revMon;
		this.nodTp = nodTp;
	}
	
	/**
	 * 테이블 컬럼에 저장할 값을 Hashtable<"column_name", "value"> 로 반환
	 * @return HashMap
	 */
	public HashMap<String, String> getColumnValues(){
		this.hashColumns.put("cnee_cd", getCneeCd());
		this.hashColumns.put("cal_upd_dt", getCalUpdDt());
		this.hashColumns.put("sto_calc_sts", getStoCalcSts());
		this.hashColumns.put("sc_cust_seq", getScCustSeq());
		this.hashColumns.put("locl_ts", getLoclTs());
		this.hashColumns.put("pagerows", getPagerows());
		this.hashColumns.put("tes_calc", getTesCalc());
		this.hashColumns.put("pol_cd", getPolCd());
		this.hashColumns.put("cost_cd", getCostCd());
		this.hashColumns.put("yd_chr", getYdChr());
		this.hashColumns.put("sc_no", getScNo());
		this.hashColumns.put("cntr_tpsz_cd", getCntrTpszCd());
		this.hashColumns.put("free_xcld_dys", getFreeXcldDys());
		this.hashColumns.put("dg_clss", getDgClss());
		this.hashColumns.put("shpr_cd", getShprCd());
		this.hashColumns.put("sto_to_nod", getStoToNod());
		this.hashColumns.put("del_cd", getDelCd());
		this.hashColumns.put("nod_bnd", getNodBnd());
		this.hashColumns.put("sto_fm_dt", getStoFmDt());
		this.hashColumns.put("pod_cd", getPodCd());
		this.hashColumns.put("ft_ttl_dys", getFtTtlDys());
		this.hashColumns.put("bkg_no", getBkgNo());
		this.hashColumns.put("sto_fm_nod", getStoFmNod());
		this.hashColumns.put("ft_add_dys", getFtAddDys());
		this.hashColumns.put("ovr_dys", getOvrDys());
		this.hashColumns.put("por_cd", getPorCd());
		this.hashColumns.put("bkg_bnd", getBkgBnd());
		this.hashColumns.put("sto_to_dt", getStoToDt());
		this.hashColumns.put("curr_cd", getCurrCd());
		this.hashColumns.put("f_cal_rslt", getFCalRslt());
		this.hashColumns.put("f_sto_sts", getFStoSts());
		this.hashColumns.put("cond_type", getCondType());
		this.hashColumns.put("rfa_no", getRfaNo());
		this.hashColumns.put("ibflag", getIbflag());
		this.hashColumns.put("stay_dys", getStayDys());
		this.hashColumns.put("f_sto_type", getFStoType());
		this.hashColumns.put("rcv_term_cd", getRcvTermCd());
		this.hashColumns.put("dflt_vndr_seq", getDfltVndrSeq());
		this.hashColumns.put("sto_fm_mvmt", getStoFmMvmt());
		this.hashColumns.put("sto_ttl_amt", getStoTtlAmt());
		this.hashColumns.put("cal_src", getCalSrc());
		this.hashColumns.put("ntfy_cd", getNtfyCd());
		this.hashColumns.put("rfa_cust_seq", getRfaCustSeq());
		this.hashColumns.put("de_term_cd", getDeTermCd());
		this.hashColumns.put("ofc_cd", getOfcCd());
		this.hashColumns.put("usd_amt", getUsdAmt());
		this.hashColumns.put("free_dys", getFreeDys());
		this.hashColumns.put("cntr_no", getCntrNo());
		this.hashColumns.put("sto_to_mvmt", getStoToMvmt());
		this.hashColumns.put("rev_mon", getRevMon());
		this.hashColumns.put("nod_tp", getNodTp());
		return this.hashColumns;
	}
	
	/**
	 * 컬럼명에 대응되는 멤버변수명을 저장하여 Hashtable<"column_name", "variable"> 로 반환   
	 * @return
	 */
	public HashMap<String, String> getFieldNames(){
		this.hashFields.put("cnee_cd", "cneeCd");
		this.hashFields.put("cal_upd_dt", "calUpdDt");
		this.hashFields.put("sto_calc_sts", "stoCalcSts");
		this.hashFields.put("sc_cust_seq", "scCustSeq");
		this.hashFields.put("locl_ts", "loclTs");
		this.hashFields.put("pagerows", "pagerows");
		this.hashFields.put("tes_calc", "tesCalc");
		this.hashFields.put("pol_cd", "polCd");
		this.hashFields.put("cost_cd", "costCd");
		this.hashFields.put("yd_chr", "ydChr");
		this.hashFields.put("sc_no", "scNo");
		this.hashFields.put("cntr_tpsz_cd", "cntrTpszCd");
		this.hashFields.put("free_xcld_dys", "freeXcldDys");
		this.hashFields.put("dg_clss", "dgClss");
		this.hashFields.put("shpr_cd", "shprCd");
		this.hashFields.put("sto_to_nod", "stoToNod");
		this.hashFields.put("del_cd", "delCd");
		this.hashFields.put("nod_bnd", "nodBnd");
		this.hashFields.put("sto_fm_dt", "stoFmDt");
		this.hashFields.put("pod_cd", "podCd");
		this.hashFields.put("ft_ttl_dys", "ftTtlDys");
		this.hashFields.put("bkg_no", "bkgNo");
		this.hashFields.put("sto_fm_nod", "stoFmNod");
		this.hashFields.put("ft_add_dys", "ftAddDys");
		this.hashFields.put("ovr_dys", "ovrDys");
		this.hashFields.put("por_cd", "porCd");
		this.hashFields.put("bkg_bnd", "bkgBnd");
		this.hashFields.put("sto_to_dt", "stoToDt");
		this.hashFields.put("curr_cd", "currCd");
		this.hashFields.put("f_cal_rslt", "fCalRslt");
		this.hashFields.put("f_sto_sts", "fStoSts");
		this.hashFields.put("cond_type", "condType");
		this.hashFields.put("rfa_no", "rfaNo");
		this.hashFields.put("ibflag", "ibflag");
		this.hashFields.put("stay_dys", "stayDys");
		this.hashFields.put("f_sto_type", "fStoType");
		this.hashFields.put("rcv_term_cd", "rcvTermCd");
		this.hashFields.put("dflt_vndr_seq", "dfltVndrSeq");
		this.hashFields.put("sto_fm_mvmt", "stoFmMvmt");
		this.hashFields.put("sto_ttl_amt", "stoTtlAmt");
		this.hashFields.put("cal_src", "calSrc");
		this.hashFields.put("ntfy_cd", "ntfyCd");
		this.hashFields.put("rfa_cust_seq", "rfaCustSeq");
		this.hashFields.put("de_term_cd", "deTermCd");
		this.hashFields.put("ofc_cd", "ofcCd");
		this.hashFields.put("usd_amt", "usdAmt");
		this.hashFields.put("free_dys", "freeDys");
		this.hashFields.put("cntr_no", "cntrNo");
		this.hashFields.put("sto_to_mvmt", "stoToMvmt");
		this.hashFields.put("rev_mon", "revMon");
		this.hashFields.put("nod_tp", "nodTp");
		return this.hashFields;
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
	 * @return calUpdDt
	 */
	public String getCalUpdDt() {
		return this.calUpdDt;
	}
	
	/**
	 * Column Info
	 * @return stoCalcSts
	 */
	public String getStoCalcSts() {
		return this.stoCalcSts;
	}
	
	/**
	 * Column Info
	 * @return scCustSeq
	 */
	public String getScCustSeq() {
		return this.scCustSeq;
	}
	
	/**
	 * Column Info
	 * @return loclTs
	 */
	public String getLoclTs() {
		return this.loclTs;
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
	 * @return tesCalc
	 */
	public String getTesCalc() {
		return this.tesCalc;
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
	 * @return costCd
	 */
	public String getCostCd() {
		return this.costCd;
	}
	
	/**
	 * Column Info
	 * @return ydChr
	 */
	public String getYdChr() {
		return this.ydChr;
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
	 * @return cntrTpszCd
	 */
	public String getCntrTpszCd() {
		return this.cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @return freeXcldDys
	 */
	public String getFreeXcldDys() {
		return this.freeXcldDys;
	}
	
	/**
	 * Column Info
	 * @return dgClss
	 */
	public String getDgClss() {
		return this.dgClss;
	}
	
	/**
	 * Column Info
	 * @return shprCd
	 */
	public String getShprCd() {
		return this.shprCd;
	}
	
	/**
	 * Column Info
	 * @return stoToNod
	 */
	public String getStoToNod() {
		return this.stoToNod;
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
	 * @return nodBnd
	 */
	public String getNodBnd() {
		return this.nodBnd;
	}
	
	/**
	 * Column Info
	 * @return stoFmDt
	 */
	public String getStoFmDt() {
		return this.stoFmDt;
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
	 * @return ftTtlDys
	 */
	public String getFtTtlDys() {
		return this.ftTtlDys;
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
	 * @return stoFmNod
	 */
	public String getStoFmNod() {
		return this.stoFmNod;
	}
	
	/**
	 * Column Info
	 * @return ftAddDys
	 */
	public String getFtAddDys() {
		return this.ftAddDys;
	}
	
	/**
	 * Column Info
	 * @return ovrDys
	 */
	public String getOvrDys() {
		return this.ovrDys;
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
	 * @return bkgBnd
	 */
	public String getBkgBnd() {
		return this.bkgBnd;
	}
	
	/**
	 * Column Info
	 * @return stoToDt
	 */
	public String getStoToDt() {
		return this.stoToDt;
	}
	
	/**
	 * Column Info
	 * @return currCd
	 */
	public String getCurrCd() {
		return this.currCd;
	}
	
	/**
	 * Column Info
	 * @return fCalRslt
	 */
	public String getFCalRslt() {
		return this.fCalRslt;
	}
	
	/**
	 * Column Info
	 * @return fStoSts
	 */
	public String getFStoSts() {
		return this.fStoSts;
	}
	
	/**
	 * Column Info
	 * @return condType
	 */
	public String getCondType() {
		return this.condType;
	}
	
	/**
	 * Column Info
	 * @return rfaNo
	 */
	public String getRfaNo() {
		return this.rfaNo;
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
	 * @return stayDys
	 */
	public String getStayDys() {
		return this.stayDys;
	}
	
	/**
	 * Column Info
	 * @return fStoType
	 */
	public String getFStoType() {
		return this.fStoType;
	}
	
	/**
	 * Column Info
	 * @return rcvTermCd
	 */
	public String getRcvTermCd() {
		return this.rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @return dfltVndrSeq
	 */
	public String getDfltVndrSeq() {
		return this.dfltVndrSeq;
	}
	
	/**
	 * Column Info
	 * @return stoFmMvmt
	 */
	public String getStoFmMvmt() {
		return this.stoFmMvmt;
	}
	
	/**
	 * Column Info
	 * @return stoTtlAmt
	 */
	public String getStoTtlAmt() {
		return this.stoTtlAmt;
	}
	
	/**
	 * Column Info
	 * @return calSrc
	 */
	public String getCalSrc() {
		return this.calSrc;
	}
	
	/**
	 * Column Info
	 * @return ntfyCd
	 */
	public String getNtfyCd() {
		return this.ntfyCd;
	}
	
	/**
	 * Column Info
	 * @return rfaCustSeq
	 */
	public String getRfaCustSeq() {
		return this.rfaCustSeq;
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
	 * @return ofcCd
	 */
	public String getOfcCd() {
		return this.ofcCd;
	}
	
	/**
	 * Column Info
	 * @return usdAmt
	 */
	public String getUsdAmt() {
		return this.usdAmt;
	}
	
	/**
	 * Column Info
	 * @return freeDys
	 */
	public String getFreeDys() {
		return this.freeDys;
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
	 * @return stoToMvmt
	 */
	public String getStoToMvmt() {
		return this.stoToMvmt;
	}
	
	/**
	 * Column Info
	 * @return revMon
	 */
	public String getRevMon() {
		return this.revMon;
	}
	
	/**
	 * Column Info
	 * @return nodTp
	 */
	public String getNodTp() {
		return this.nodTp;
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
	 * @param calUpdDt
	 */
	public void setCalUpdDt(String calUpdDt) {
		this.calUpdDt = calUpdDt;
	}
	
	/**
	 * Column Info
	 * @param stoCalcSts
	 */
	public void setStoCalcSts(String stoCalcSts) {
		this.stoCalcSts = stoCalcSts;
	}
	
	/**
	 * Column Info
	 * @param scCustSeq
	 */
	public void setScCustSeq(String scCustSeq) {
		this.scCustSeq = scCustSeq;
	}
	
	/**
	 * Column Info
	 * @param loclTs
	 */
	public void setLoclTs(String loclTs) {
		this.loclTs = loclTs;
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
	 * @param tesCalc
	 */
	public void setTesCalc(String tesCalc) {
		this.tesCalc = tesCalc;
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
	 * @param costCd
	 */
	public void setCostCd(String costCd) {
		this.costCd = costCd;
	}
	
	/**
	 * Column Info
	 * @param ydChr
	 */
	public void setYdChr(String ydChr) {
		this.ydChr = ydChr;
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
	 * @param cntrTpszCd
	 */
	public void setCntrTpszCd(String cntrTpszCd) {
		this.cntrTpszCd = cntrTpszCd;
	}
	
	/**
	 * Column Info
	 * @param freeXcldDys
	 */
	public void setFreeXcldDys(String freeXcldDys) {
		this.freeXcldDys = freeXcldDys;
	}
	
	/**
	 * Column Info
	 * @param dgClss
	 */
	public void setDgClss(String dgClss) {
		this.dgClss = dgClss;
	}
	
	/**
	 * Column Info
	 * @param shprCd
	 */
	public void setShprCd(String shprCd) {
		this.shprCd = shprCd;
	}
	
	/**
	 * Column Info
	 * @param stoToNod
	 */
	public void setStoToNod(String stoToNod) {
		this.stoToNod = stoToNod;
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
	 * @param nodBnd
	 */
	public void setNodBnd(String nodBnd) {
		this.nodBnd = nodBnd;
	}
	
	/**
	 * Column Info
	 * @param stoFmDt
	 */
	public void setStoFmDt(String stoFmDt) {
		this.stoFmDt = stoFmDt;
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
	 * @param ftTtlDys
	 */
	public void setFtTtlDys(String ftTtlDys) {
		this.ftTtlDys = ftTtlDys;
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
	 * @param stoFmNod
	 */
	public void setStoFmNod(String stoFmNod) {
		this.stoFmNod = stoFmNod;
	}
	
	/**
	 * Column Info
	 * @param ftAddDys
	 */
	public void setFtAddDys(String ftAddDys) {
		this.ftAddDys = ftAddDys;
	}
	
	/**
	 * Column Info
	 * @param ovrDys
	 */
	public void setOvrDys(String ovrDys) {
		this.ovrDys = ovrDys;
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
	 * @param bkgBnd
	 */
	public void setBkgBnd(String bkgBnd) {
		this.bkgBnd = bkgBnd;
	}
	
	/**
	 * Column Info
	 * @param stoToDt
	 */
	public void setStoToDt(String stoToDt) {
		this.stoToDt = stoToDt;
	}
	
	/**
	 * Column Info
	 * @param currCd
	 */
	public void setCurrCd(String currCd) {
		this.currCd = currCd;
	}
	
	/**
	 * Column Info
	 * @param fCalRslt
	 */
	public void setFCalRslt(String fCalRslt) {
		this.fCalRslt = fCalRslt;
	}
	
	/**
	 * Column Info
	 * @param fStoSts
	 */
	public void setFStoSts(String fStoSts) {
		this.fStoSts = fStoSts;
	}
	
	/**
	 * Column Info
	 * @param condType
	 */
	public void setCondType(String condType) {
		this.condType = condType;
	}
	
	/**
	 * Column Info
	 * @param rfaNo
	 */
	public void setRfaNo(String rfaNo) {
		this.rfaNo = rfaNo;
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
	 * @param stayDys
	 */
	public void setStayDys(String stayDys) {
		this.stayDys = stayDys;
	}
	
	/**
	 * Column Info
	 * @param fStoType
	 */
	public void setFStoType(String fStoType) {
		this.fStoType = fStoType;
	}
	
	/**
	 * Column Info
	 * @param rcvTermCd
	 */
	public void setRcvTermCd(String rcvTermCd) {
		this.rcvTermCd = rcvTermCd;
	}
	
	/**
	 * Column Info
	 * @param dfltVndrSeq
	 */
	public void setDfltVndrSeq(String dfltVndrSeq) {
		this.dfltVndrSeq = dfltVndrSeq;
	}
	
	/**
	 * Column Info
	 * @param stoFmMvmt
	 */
	public void setStoFmMvmt(String stoFmMvmt) {
		this.stoFmMvmt = stoFmMvmt;
	}
	
	/**
	 * Column Info
	 * @param stoTtlAmt
	 */
	public void setStoTtlAmt(String stoTtlAmt) {
		this.stoTtlAmt = stoTtlAmt;
	}
	
	/**
	 * Column Info
	 * @param calSrc
	 */
	public void setCalSrc(String calSrc) {
		this.calSrc = calSrc;
	}
	
	/**
	 * Column Info
	 * @param ntfyCd
	 */
	public void setNtfyCd(String ntfyCd) {
		this.ntfyCd = ntfyCd;
	}
	
	/**
	 * Column Info
	 * @param rfaCustSeq
	 */
	public void setRfaCustSeq(String rfaCustSeq) {
		this.rfaCustSeq = rfaCustSeq;
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
	 * @param ofcCd
	 */
	public void setOfcCd(String ofcCd) {
		this.ofcCd = ofcCd;
	}
	
	/**
	 * Column Info
	 * @param usdAmt
	 */
	public void setUsdAmt(String usdAmt) {
		this.usdAmt = usdAmt;
	}
	
	/**
	 * Column Info
	 * @param freeDys
	 */
	public void setFreeDys(String freeDys) {
		this.freeDys = freeDys;
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
	 * @param stoToMvmt
	 */
	public void setStoToMvmt(String stoToMvmt) {
		this.stoToMvmt = stoToMvmt;
	}
	
	/**
	 * Column Info
	 * @param revMon
	 */
	public void setRevMon(String revMon) {
		this.revMon = revMon;
	}
	
	/**
	 * Column Info
	 * @param nodTp
	 */
	public void setNodTp(String nodTp) {
		this.nodTp = nodTp;
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
		setCneeCd(JSPUtil.getParameter(request, prefix + "cnee_cd", ""));
		setCalUpdDt(JSPUtil.getParameter(request, prefix + "cal_upd_dt", ""));
		setStoCalcSts(JSPUtil.getParameter(request, prefix + "sto_calc_sts", ""));
		setScCustSeq(JSPUtil.getParameter(request, prefix + "sc_cust_seq", ""));
		setLoclTs(JSPUtil.getParameter(request, prefix + "locl_ts", ""));
		setPagerows(JSPUtil.getParameter(request, prefix + "pagerows", ""));
		setTesCalc(JSPUtil.getParameter(request, prefix + "tes_calc", ""));
		setPolCd(JSPUtil.getParameter(request, prefix + "pol_cd", ""));
		setCostCd(JSPUtil.getParameter(request, prefix + "cost_cd", ""));
		setYdChr(JSPUtil.getParameter(request, prefix + "yd_chr", ""));
		setScNo(JSPUtil.getParameter(request, prefix + "sc_no", ""));
		setCntrTpszCd(JSPUtil.getParameter(request, prefix + "cntr_tpsz_cd", ""));
		setFreeXcldDys(JSPUtil.getParameter(request, prefix + "free_xcld_dys", ""));
		setDgClss(JSPUtil.getParameter(request, prefix + "dg_clss", ""));
		setShprCd(JSPUtil.getParameter(request, prefix + "shpr_cd", ""));
		setStoToNod(JSPUtil.getParameter(request, prefix + "sto_to_nod", ""));
		setDelCd(JSPUtil.getParameter(request, prefix + "del_cd", ""));
		setNodBnd(JSPUtil.getParameter(request, prefix + "nod_bnd", ""));
		setStoFmDt(JSPUtil.getParameter(request, prefix + "sto_fm_dt", ""));
		setPodCd(JSPUtil.getParameter(request, prefix + "pod_cd", ""));
		setFtTtlDys(JSPUtil.getParameter(request, prefix + "ft_ttl_dys", ""));
		setBkgNo(JSPUtil.getParameter(request, prefix + "bkg_no", ""));
		setStoFmNod(JSPUtil.getParameter(request, prefix + "sto_fm_nod", ""));
		setFtAddDys(JSPUtil.getParameter(request, prefix + "ft_add_dys", ""));
		setOvrDys(JSPUtil.getParameter(request, prefix + "ovr_dys", ""));
		setPorCd(JSPUtil.getParameter(request, prefix + "por_cd", ""));
		setBkgBnd(JSPUtil.getParameter(request, prefix + "bkg_bnd", ""));
		setStoToDt(JSPUtil.getParameter(request, prefix + "sto_to_dt", ""));
		setCurrCd(JSPUtil.getParameter(request, prefix + "curr_cd", ""));
		setFCalRslt(JSPUtil.getParameter(request, prefix + "f_cal_rslt", ""));
		setFStoSts(JSPUtil.getParameter(request, prefix + "f_sto_sts", ""));
		setCondType(JSPUtil.getParameter(request, prefix + "cond_type", ""));
		setRfaNo(JSPUtil.getParameter(request, prefix + "rfa_no", ""));
		setIbflag(JSPUtil.getParameter(request, prefix + "ibflag", ""));
		setStayDys(JSPUtil.getParameter(request, prefix + "stay_dys", ""));
		setFStoType(JSPUtil.getParameter(request, prefix + "f_sto_type", ""));
		setRcvTermCd(JSPUtil.getParameter(request, prefix + "rcv_term_cd", ""));
		setDfltVndrSeq(JSPUtil.getParameter(request, prefix + "dflt_vndr_seq", ""));
		setStoFmMvmt(JSPUtil.getParameter(request, prefix + "sto_fm_mvmt", ""));
		setStoTtlAmt(JSPUtil.getParameter(request, prefix + "sto_ttl_amt", ""));
		setCalSrc(JSPUtil.getParameter(request, prefix + "cal_src", ""));
		setNtfyCd(JSPUtil.getParameter(request, prefix + "ntfy_cd", ""));
		setRfaCustSeq(JSPUtil.getParameter(request, prefix + "rfa_cust_seq", ""));
		setDeTermCd(JSPUtil.getParameter(request, prefix + "de_term_cd", ""));
		setOfcCd(JSPUtil.getParameter(request, prefix + "ofc_cd", ""));
		setUsdAmt(JSPUtil.getParameter(request, prefix + "usd_amt", ""));
		setFreeDys(JSPUtil.getParameter(request, prefix + "free_dys", ""));
		setCntrNo(JSPUtil.getParameter(request, prefix + "cntr_no", ""));
		setStoToMvmt(JSPUtil.getParameter(request, prefix + "sto_to_mvmt", ""));
		setRevMon(JSPUtil.getParameter(request, prefix + "rev_mon", ""));
		setNodTp(JSPUtil.getParameter(request, prefix + "nod_tp", ""));
	}

	/**
	 * Request 의 데이터를 VO 배열로 변환하여 반환.
	 * @param request
	 * @return FullStorageDailyCalcVO[]
	 */
	public FullStorageDailyCalcVO[] fromRequestGrid(HttpServletRequest request) {
		return fromRequestGrid(request, "");
	}

	/**
	 * Request 넘어온 여러 건 DATA를 VO Class 에 담는다. 
	 * @param request
	 * @param prefix
	 * @return FullStorageDailyCalcVO[]
	 */
	public FullStorageDailyCalcVO[] fromRequestGrid(HttpServletRequest request, String prefix) {
		FullStorageDailyCalcVO model = null;
		
		String[] tmp = request.getParameterValues(prefix + "ibflag");
  		if(tmp == null)
   			return null;

  		int length = request.getParameterValues(prefix + "ibflag").length;
  
		try {
			String[] cneeCd = (JSPUtil.getParameter(request, prefix	+ "cnee_cd", length));
			String[] calUpdDt = (JSPUtil.getParameter(request, prefix	+ "cal_upd_dt", length));
			String[] stoCalcSts = (JSPUtil.getParameter(request, prefix	+ "sto_calc_sts", length));
			String[] scCustSeq = (JSPUtil.getParameter(request, prefix	+ "sc_cust_seq", length));
			String[] loclTs = (JSPUtil.getParameter(request, prefix	+ "locl_ts", length));
			String[] pagerows = (JSPUtil.getParameter(request, prefix	+ "pagerows", length));
			String[] tesCalc = (JSPUtil.getParameter(request, prefix	+ "tes_calc", length));
			String[] polCd = (JSPUtil.getParameter(request, prefix	+ "pol_cd", length));
			String[] costCd = (JSPUtil.getParameter(request, prefix	+ "cost_cd", length));
			String[] ydChr = (JSPUtil.getParameter(request, prefix	+ "yd_chr", length));
			String[] scNo = (JSPUtil.getParameter(request, prefix	+ "sc_no", length));
			String[] cntrTpszCd = (JSPUtil.getParameter(request, prefix	+ "cntr_tpsz_cd", length));
			String[] freeXcldDys = (JSPUtil.getParameter(request, prefix	+ "free_xcld_dys", length));
			String[] dgClss = (JSPUtil.getParameter(request, prefix	+ "dg_clss", length));
			String[] shprCd = (JSPUtil.getParameter(request, prefix	+ "shpr_cd", length));
			String[] stoToNod = (JSPUtil.getParameter(request, prefix	+ "sto_to_nod", length));
			String[] delCd = (JSPUtil.getParameter(request, prefix	+ "del_cd", length));
			String[] nodBnd = (JSPUtil.getParameter(request, prefix	+ "nod_bnd", length));
			String[] stoFmDt = (JSPUtil.getParameter(request, prefix	+ "sto_fm_dt", length));
			String[] podCd = (JSPUtil.getParameter(request, prefix	+ "pod_cd", length));
			String[] ftTtlDys = (JSPUtil.getParameter(request, prefix	+ "ft_ttl_dys", length));
			String[] bkgNo = (JSPUtil.getParameter(request, prefix	+ "bkg_no", length));
			String[] stoFmNod = (JSPUtil.getParameter(request, prefix	+ "sto_fm_nod", length));
			String[] ftAddDys = (JSPUtil.getParameter(request, prefix	+ "ft_add_dys", length));
			String[] ovrDys = (JSPUtil.getParameter(request, prefix	+ "ovr_dys", length));
			String[] porCd = (JSPUtil.getParameter(request, prefix	+ "por_cd", length));
			String[] bkgBnd = (JSPUtil.getParameter(request, prefix	+ "bkg_bnd", length));
			String[] stoToDt = (JSPUtil.getParameter(request, prefix	+ "sto_to_dt", length));
			String[] currCd = (JSPUtil.getParameter(request, prefix	+ "curr_cd", length));
			String[] fCalRslt = (JSPUtil.getParameter(request, prefix	+ "f_cal_rslt", length));
			String[] fStoSts = (JSPUtil.getParameter(request, prefix	+ "f_sto_sts", length));
			String[] condType = (JSPUtil.getParameter(request, prefix	+ "cond_type", length));
			String[] rfaNo = (JSPUtil.getParameter(request, prefix	+ "rfa_no", length));
			String[] ibflag = (JSPUtil.getParameter(request, prefix	+ "ibflag", length));
			String[] stayDys = (JSPUtil.getParameter(request, prefix	+ "stay_dys", length));
			String[] fStoType = (JSPUtil.getParameter(request, prefix	+ "f_sto_type", length));
			String[] rcvTermCd = (JSPUtil.getParameter(request, prefix	+ "rcv_term_cd", length));
			String[] dfltVndrSeq = (JSPUtil.getParameter(request, prefix	+ "dflt_vndr_seq", length));
			String[] stoFmMvmt = (JSPUtil.getParameter(request, prefix	+ "sto_fm_mvmt", length));
			String[] stoTtlAmt = (JSPUtil.getParameter(request, prefix	+ "sto_ttl_amt", length));
			String[] calSrc = (JSPUtil.getParameter(request, prefix	+ "cal_src", length));
			String[] ntfyCd = (JSPUtil.getParameter(request, prefix	+ "ntfy_cd", length));
			String[] rfaCustSeq = (JSPUtil.getParameter(request, prefix	+ "rfa_cust_seq", length));
			String[] deTermCd = (JSPUtil.getParameter(request, prefix	+ "de_term_cd", length));
			String[] ofcCd = (JSPUtil.getParameter(request, prefix	+ "ofc_cd", length));
			String[] usdAmt = (JSPUtil.getParameter(request, prefix	+ "usd_amt", length));
			String[] freeDys = (JSPUtil.getParameter(request, prefix	+ "free_dys", length));
			String[] cntrNo = (JSPUtil.getParameter(request, prefix	+ "cntr_no", length));
			String[] stoToMvmt = (JSPUtil.getParameter(request, prefix	+ "sto_to_mvmt", length));
			String[] revMon = (JSPUtil.getParameter(request, prefix	+ "rev_mon", length));
			String[] nodTp = (JSPUtil.getParameter(request, prefix	+ "nod_tp", length));
			
			for (int i = 0; i < length; i++) {
				model = new FullStorageDailyCalcVO();
				if (cneeCd[i] != null)
					model.setCneeCd(cneeCd[i]);
				if (calUpdDt[i] != null)
					model.setCalUpdDt(calUpdDt[i]);
				if (stoCalcSts[i] != null)
					model.setStoCalcSts(stoCalcSts[i]);
				if (scCustSeq[i] != null)
					model.setScCustSeq(scCustSeq[i]);
				if (loclTs[i] != null)
					model.setLoclTs(loclTs[i]);
				if (pagerows[i] != null)
					model.setPagerows(pagerows[i]);
				if (tesCalc[i] != null)
					model.setTesCalc(tesCalc[i]);
				if (polCd[i] != null)
					model.setPolCd(polCd[i]);
				if (costCd[i] != null)
					model.setCostCd(costCd[i]);
				if (ydChr[i] != null)
					model.setYdChr(ydChr[i]);
				if (scNo[i] != null)
					model.setScNo(scNo[i]);
				if (cntrTpszCd[i] != null)
					model.setCntrTpszCd(cntrTpszCd[i]);
				if (freeXcldDys[i] != null)
					model.setFreeXcldDys(freeXcldDys[i]);
				if (dgClss[i] != null)
					model.setDgClss(dgClss[i]);
				if (shprCd[i] != null)
					model.setShprCd(shprCd[i]);
				if (stoToNod[i] != null)
					model.setStoToNod(stoToNod[i]);
				if (delCd[i] != null)
					model.setDelCd(delCd[i]);
				if (nodBnd[i] != null)
					model.setNodBnd(nodBnd[i]);
				if (stoFmDt[i] != null)
					model.setStoFmDt(stoFmDt[i]);
				if (podCd[i] != null)
					model.setPodCd(podCd[i]);
				if (ftTtlDys[i] != null)
					model.setFtTtlDys(ftTtlDys[i]);
				if (bkgNo[i] != null)
					model.setBkgNo(bkgNo[i]);
				if (stoFmNod[i] != null)
					model.setStoFmNod(stoFmNod[i]);
				if (ftAddDys[i] != null)
					model.setFtAddDys(ftAddDys[i]);
				if (ovrDys[i] != null)
					model.setOvrDys(ovrDys[i]);
				if (porCd[i] != null)
					model.setPorCd(porCd[i]);
				if (bkgBnd[i] != null)
					model.setBkgBnd(bkgBnd[i]);
				if (stoToDt[i] != null)
					model.setStoToDt(stoToDt[i]);
				if (currCd[i] != null)
					model.setCurrCd(currCd[i]);
				if (fCalRslt[i] != null)
					model.setFCalRslt(fCalRslt[i]);
				if (fStoSts[i] != null)
					model.setFStoSts(fStoSts[i]);
				if (condType[i] != null)
					model.setCondType(condType[i]);
				if (rfaNo[i] != null)
					model.setRfaNo(rfaNo[i]);
				if (ibflag[i] != null)
					model.setIbflag(ibflag[i]);
				if (stayDys[i] != null)
					model.setStayDys(stayDys[i]);
				if (fStoType[i] != null)
					model.setFStoType(fStoType[i]);
				if (rcvTermCd[i] != null)
					model.setRcvTermCd(rcvTermCd[i]);
				if (dfltVndrSeq[i] != null)
					model.setDfltVndrSeq(dfltVndrSeq[i]);
				if (stoFmMvmt[i] != null)
					model.setStoFmMvmt(stoFmMvmt[i]);
				if (stoTtlAmt[i] != null)
					model.setStoTtlAmt(stoTtlAmt[i]);
				if (calSrc[i] != null)
					model.setCalSrc(calSrc[i]);
				if (ntfyCd[i] != null)
					model.setNtfyCd(ntfyCd[i]);
				if (rfaCustSeq[i] != null)
					model.setRfaCustSeq(rfaCustSeq[i]);
				if (deTermCd[i] != null)
					model.setDeTermCd(deTermCd[i]);
				if (ofcCd[i] != null)
					model.setOfcCd(ofcCd[i]);
				if (usdAmt[i] != null)
					model.setUsdAmt(usdAmt[i]);
				if (freeDys[i] != null)
					model.setFreeDys(freeDys[i]);
				if (cntrNo[i] != null)
					model.setCntrNo(cntrNo[i]);
				if (stoToMvmt[i] != null)
					model.setStoToMvmt(stoToMvmt[i]);
				if (revMon[i] != null)
					model.setRevMon(revMon[i]);
				if (nodTp[i] != null)
					model.setNodTp(nodTp[i]);
				models.add(model);
			}

		} catch (Exception e) {
			return null;
		}
		return getFullStorageDailyCalcVOs();
	}

	/**
	 * VO 배열을 반환
	 * @return FullStorageDailyCalcVO[]
	 */
	public FullStorageDailyCalcVO[] getFullStorageDailyCalcVOs(){
		FullStorageDailyCalcVO[] vos = (FullStorageDailyCalcVO[])models.toArray(new FullStorageDailyCalcVO[models.size()]);
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
		this.cneeCd = this.cneeCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calUpdDt = this.calUpdDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoCalcSts = this.stoCalcSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scCustSeq = this.scCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.loclTs = this.loclTs .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.pagerows = this.pagerows .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.tesCalc = this.tesCalc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.polCd = this.polCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.costCd = this.costCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ydChr = this.ydChr .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.scNo = this.scNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrTpszCd = this.cntrTpszCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeXcldDys = this.freeXcldDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dgClss = this.dgClss .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.shprCd = this.shprCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoToNod = this.stoToNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.delCd = this.delCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodBnd = this.nodBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoFmDt = this.stoFmDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.podCd = this.podCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftTtlDys = this.ftTtlDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgNo = this.bkgNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoFmNod = this.stoFmNod .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ftAddDys = this.ftAddDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ovrDys = this.ovrDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.porCd = this.porCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.bkgBnd = this.bkgBnd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoToDt = this.stoToDt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.currCd = this.currCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fCalRslt = this.fCalRslt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStoSts = this.fStoSts .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.condType = this.condType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaNo = this.rfaNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ibflag = this.ibflag .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stayDys = this.stayDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.fStoType = this.fStoType .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rcvTermCd = this.rcvTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.dfltVndrSeq = this.dfltVndrSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoFmMvmt = this.stoFmMvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoTtlAmt = this.stoTtlAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.calSrc = this.calSrc .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ntfyCd = this.ntfyCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.rfaCustSeq = this.rfaCustSeq .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.deTermCd = this.deTermCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.ofcCd = this.ofcCd .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.usdAmt = this.usdAmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.freeDys = this.freeDys .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.cntrNo = this.cntrNo .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.stoToMvmt = this.stoToMvmt .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.revMon = this.revMon .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
		this.nodTp = this.nodTp .replaceAll(",", "").replaceAll("-", "").replaceAll("/", "").replaceAll(":", "");
	}
}
